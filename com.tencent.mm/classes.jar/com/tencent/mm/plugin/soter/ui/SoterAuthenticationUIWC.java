package com.tencent.mm.plugin.soter.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ao.a.c;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.plugin.soter.model.g;
import com.tencent.mm.plugin.soter.model.h;
import com.tencent.mm.plugin.soter.model.i;
import com.tencent.mm.plugin.soter.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.a.b.b;
import com.tencent.soter.a.b.d;
import java.lang.ref.WeakReference;

@com.tencent.mm.ui.base.a(7)
public class SoterAuthenticationUIWC
  extends MMActivity
{
  private static com.tencent.mm.ui.widget.a.e RZE = null;
  public static a Saz = null;
  private com.tencent.mm.plugin.soter.c.c Sas;
  private b<d> Saw;
  private String appId;
  private int fromScene;
  private ProgressDialog wQT;
  
  public SoterAuthenticationUIWC()
  {
    AppMethodBeat.i(130891);
    this.Sas = null;
    this.wQT = null;
    this.fromScene = -1;
    this.appId = null;
    this.Saw = new b() {};
    AppMethodBeat.o(130891);
  }
  
  private void a(h paramh)
  {
    AppMethodBeat.i(130895);
    setResult(1, d(paramh));
    c(paramh);
    finish();
    AppMethodBeat.o(130895);
  }
  
  private static int adK(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 0: 
      return 0;
    case 90001: 
    case 90002: 
    case 90003: 
    case 90004: 
    case 90006: 
    case 90007: 
    case 90011: 
      return 2;
    }
    return 3;
  }
  
  private void c(h paramh)
  {
    AppMethodBeat.i(130897);
    if (paramh == null)
    {
      AppMethodBeat.o(130897);
      return;
    }
    if (this.fromScene == 0)
    {
      int i = adK(paramh.errCode);
      i locali = i.Sac;
      i.v("requireSoterBiometricAuthentication", this.appId, i, paramh.errCode);
    }
    AppMethodBeat.o(130897);
  }
  
  private static Intent d(h paramh)
  {
    AppMethodBeat.i(130896);
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", paramh.errCode);
    localBundle.putString("err_msg", paramh.errMsg);
    localBundle.putByte("use_mode", paramh.Saa);
    localBundle.putString("result_json", paramh.hZD);
    localBundle.putString("result_json_signature", paramh.Sab);
    Log.d("MicroMsg.SoterAuthenticationUIWC", "hy: dump mp soter result: %s", new Object[] { localBundle.toString() });
    paramh = new Intent();
    paramh.putExtras(localBundle);
    AppMethodBeat.o(130896);
    return paramh;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(130892);
    super.onCreate(paramBundle);
    if (26 != Build.VERSION.SDK_INT) {
      setRequestedOrientation(1);
    }
    if (Saz != null) {
      a.a(Saz);
    }
    Saz = new a(this, (byte)0);
    paramBundle = new g();
    h localh = new h();
    Object localObject = getIntent().getStringExtra("auth_mode");
    if (Util.isNullOrNil((String)localObject))
    {
      Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: error authen mode : null");
      localh.errCode = 90003;
      localh.errMsg = "authen mode is null";
    }
    for (;;)
    {
      if (localh.errCode != 0)
      {
        a(localh);
        AppMethodBeat.o(130892);
        return;
      }
      try
      {
        paramBundle.RZZ = Byte.parseByte(Util.nullAs(((String)localObject).substring(2), "00"), 16);
        paramBundle.Hgd = getIntent().getStringExtra("challenge");
        paramBundle.content = getIntent().getStringExtra("auth_content");
        if (!j.htF())
        {
          Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: not support soter");
          localh.errCode = 90001;
          localh.errMsg = "not support soter";
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: error authen mode format: %s", new Object[] { localObject });
        localh.errCode = 90003;
        localh.errMsg = "authen mode is illegal: number format error. found: ".concat(String.valueOf(localObject));
        continue;
        if (paramBundle.RZZ <= 0)
        {
          Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: request mode illegal");
          localh.errCode = 90003;
          localh.errMsg = "resp model error";
          continue;
        }
        if (Util.isNullOrNil(paramBundle.Hgd))
        {
          Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: challenge null");
          localh.errCode = 90004;
          localh.errMsg = "challenge is null";
          continue;
        }
        if (paramBundle.Hgd.length() >= 512)
        {
          Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: challenge too long");
          localh.errCode = 90004;
          localh.errMsg = "challenge is too long. 512 chars at most";
          continue;
        }
        if (Util.isNullOrNil(paramBundle.content))
        {
          paramBundle.content = getString(a.c.soter_authen_put_finger_msg);
          continue;
        }
        if (paramBundle.content.length() <= 42) {
          continue;
        }
        Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: content too long. use default");
        paramBundle.content = getString(a.c.soter_authen_put_finger_msg);
        continue;
        this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
        localObject = com.tencent.mm.plugin.soter.c.a.RZB;
        this.Sas = com.tencent.mm.plugin.soter.c.a.a(this, paramBundle, localh, Saz);
        if (this.Sas == null)
        {
          Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: no corresponding authen mode");
          localh.errCode = 90003;
          localh.errMsg = "no corresponding mode";
          a(localh);
          AppMethodBeat.o(130892);
          return;
        }
        this.Sas.RZU = new f();
        this.Sas.RZT = new com.tencent.mm.plugin.soter.b.e();
        this.Sas.mScene = 2;
        this.appId = getIntent().getStringExtra("key_app_id");
        this.Sas.bB();
        AppMethodBeat.o(130892);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label198:
        break label198;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(130899);
    super.onDestroy();
    if ((this.wQT != null) && (this.wQT.isShowing()))
    {
      Log.i("MicroMsg.SoterAuthenticationUIWC", "onDestroy mProgressDialog dismiss!");
      this.wQT.dismiss();
    }
    if ((RZE != null) && (RZE.isShowing()))
    {
      Log.i("MicroMsg.SoterAuthenticationUIWC", "onDestroy mAuthenDialog dismiss!");
      RZE.dismiss();
    }
    a.a(Saz);
    AppMethodBeat.o(130899);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(130894);
    super.onPause();
    if (this.Sas != null) {
      this.Sas.onPause();
    }
    AppMethodBeat.o(130894);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(130898);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (this.Sas != null) {
      this.Sas.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(130898);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(130893);
    super.onResume();
    if (this.Sas != null) {
      this.Sas.onResume();
    }
    AppMethodBeat.o(130893);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
    extends Handler
  {
    private WeakReference<SoterAuthenticationUIWC> Say;
    
    private a(SoterAuthenticationUIWC paramSoterAuthenticationUIWC)
    {
      AppMethodBeat.i(130888);
      this.Say = null;
      this.Say = new WeakReference(paramSoterAuthenticationUIWC);
      AppMethodBeat.o(130888);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(130889);
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      default: 
        Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: unidentified msg: %d", new Object[] { Integer.valueOf(paramMessage.what) });
        AppMethodBeat.o(130889);
        return;
      case 0: 
        Log.i("MicroMsg.SoterAuthenticationUIWC", "hy: inform ok");
        paramMessage = (h)paramMessage.obj;
        if ((this.Say != null) && (this.Say.get() != null))
        {
          SoterAuthenticationUIWC.a((SoterAuthenticationUIWC)this.Say.get(), paramMessage);
          AppMethodBeat.o(130889);
          return;
        }
        Log.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
        AppMethodBeat.o(130889);
        return;
      case 1: 
        Log.i("MicroMsg.SoterAuthenticationUIWC", "hy: inform cancel");
        paramMessage = (h)paramMessage.obj;
        if ((this.Say != null) && (this.Say.get() != null))
        {
          SoterAuthenticationUIWC.b((SoterAuthenticationUIWC)this.Say.get(), paramMessage);
          AppMethodBeat.o(130889);
          return;
        }
        Log.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
        AppMethodBeat.o(130889);
        return;
      case 2: 
        Log.i("MicroMsg.SoterAuthenticationUIWC", "hy: inform fail");
        paramMessage = (h)paramMessage.obj;
        if ((this.Say != null) && (this.Say.get() != null))
        {
          SoterAuthenticationUIWC.c((SoterAuthenticationUIWC)this.Say.get(), paramMessage);
          AppMethodBeat.o(130889);
          return;
        }
        Log.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
        AppMethodBeat.o(130889);
        return;
      case 3: 
        Log.i("MicroMsg.SoterAuthenticationUIWC", "hy: request permission");
        if ((this.Say != null) && (this.Say.get() != null))
        {
          Object localObject = paramMessage.getData().getStringArray("permissions");
          int i = paramMessage.getData().getInt("request_code");
          if ((localObject == null) || (localObject.length <= 1))
          {
            Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: permission null");
            AppMethodBeat.o(130889);
            return;
          }
          paramMessage = (SoterAuthenticationUIWC)this.Say.get();
          localObject = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramMessage, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/soter/ui/SoterAuthenticationUIWC$SoterMpAuthenHandler", "handleMessage", "(Landroid/os/Message;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
          paramMessage.requestPermissions((String[])((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(1)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramMessage, "com/tencent/mm/plugin/soter/ui/SoterAuthenticationUIWC$SoterMpAuthenHandler", "handleMessage", "(Landroid/os/Message;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
          AppMethodBeat.o(130889);
          return;
        }
        Log.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
        AppMethodBeat.o(130889);
        return;
      case 4: 
        Log.i("MicroMsg.SoterAuthenticationUIWC", "hy: show progress");
        if ((this.Say != null) && (this.Say.get() != null))
        {
          SoterAuthenticationUIWC.a((SoterAuthenticationUIWC)this.Say.get());
          AppMethodBeat.o(130889);
          return;
        }
        Log.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
        AppMethodBeat.o(130889);
        return;
      case 5: 
        Log.i("MicroMsg.SoterAuthenticationUIWC", "hy: dismiss progress");
        if ((this.Say != null) && (this.Say.get() != null))
        {
          SoterAuthenticationUIWC.b((SoterAuthenticationUIWC)this.Say.get());
          AppMethodBeat.o(130889);
          return;
        }
        Log.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
        AppMethodBeat.o(130889);
        return;
      }
      Log.i("MicroMsg.SoterAuthenticationUIWC", "hy: show dialog");
      if ((this.Say != null) && (this.Say.get() != null))
      {
        SoterAuthenticationUIWC.c((com.tencent.mm.ui.widget.a.e)paramMessage.obj);
        AppMethodBeat.o(130889);
        return;
      }
      Log.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
      AppMethodBeat.o(130889);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterAuthenticationUIWC
 * JD-Core Version:    0.7.0.1
 */