package com.tencent.mm.plugin.soter.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.b.e;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.plugin.soter.d.l;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.a.b.b;
import java.lang.ref.WeakReference;

@com.tencent.mm.ui.base.a(7)
public class SoterAuthenticationUIWC
  extends MMActivity
{
  private static com.tencent.mm.ui.widget.a.d znk = null;
  public static a zof = null;
  private String appId;
  private int fromScene;
  private ProgressDialog opZ;
  private com.tencent.mm.plugin.soter.c.c znZ;
  private b<com.tencent.soter.a.b.d> zod;
  
  public SoterAuthenticationUIWC()
  {
    AppMethodBeat.i(130891);
    this.znZ = null;
    this.opZ = null;
    this.fromScene = -1;
    this.appId = null;
    this.zod = new b() {};
    AppMethodBeat.o(130891);
  }
  
  private static int JY(int paramInt)
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
  
  private void a(k paramk)
  {
    AppMethodBeat.i(130895);
    setResult(1, d(paramk));
    c(paramk);
    finish();
    AppMethodBeat.o(130895);
  }
  
  private void c(k paramk)
  {
    AppMethodBeat.i(130897);
    if (paramk == null)
    {
      AppMethodBeat.o(130897);
      return;
    }
    if (this.fromScene == 0)
    {
      int i = JY(paramk.errCode);
      l locall = l.znJ;
      l.s("requireSoterBiometricAuthentication", this.appId, i, paramk.errCode);
    }
    AppMethodBeat.o(130897);
  }
  
  private static Intent d(k paramk)
  {
    AppMethodBeat.i(130896);
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", paramk.errCode);
    localBundle.putString("err_msg", paramk.errMsg);
    localBundle.putByte("use_mode", paramk.znH);
    localBundle.putString("result_json", paramk.duS);
    localBundle.putString("result_json_signature", paramk.znI);
    ac.d("MicroMsg.SoterAuthenticationUIWC", "hy: dump mp soter result: %s", new Object[] { localBundle.toString() });
    paramk = new Intent();
    paramk.putExtras(localBundle);
    AppMethodBeat.o(130896);
    return paramk;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  @TargetApi(23)
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(130892);
    super.onCreate(paramBundle);
    if (26 != Build.VERSION.SDK_INT) {
      setRequestedOrientation(1);
    }
    if (zof != null) {
      a.a(zof);
    }
    zof = new a(this, (byte)0);
    paramBundle = new j();
    k localk = new k();
    Object localObject = getIntent().getStringExtra("auth_mode");
    if (bs.isNullOrNil((String)localObject))
    {
      ac.e("MicroMsg.SoterAuthenticationUIWC", "hy: error authen mode : null");
      localk.errCode = 90003;
      localk.errMsg = "authen mode is null";
    }
    for (;;)
    {
      if (localk.errCode != 0)
      {
        a(localk);
        AppMethodBeat.o(130892);
        return;
      }
      try
      {
        paramBundle.znG = Byte.parseByte(bs.bG(((String)localObject).substring(2), "00"), 16);
        paramBundle.skD = getIntent().getStringExtra("challenge");
        paramBundle.content = getIntent().getStringExtra("auth_content");
        if (!m.dTw())
        {
          ac.e("MicroMsg.SoterAuthenticationUIWC", "hy: not support soter");
          localk.errCode = 90001;
          localk.errMsg = "not support soter";
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        ac.e("MicroMsg.SoterAuthenticationUIWC", "hy: error authen mode format: %s", new Object[] { localObject });
        localk.errCode = 90003;
        localk.errMsg = "authen mode is illegal: number format error. found: ".concat(String.valueOf(localObject));
        continue;
        if (paramBundle.znG <= 0)
        {
          ac.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: request mode illegal");
          localk.errCode = 90003;
          localk.errMsg = "resp model error";
          continue;
        }
        if (bs.isNullOrNil(paramBundle.skD))
        {
          ac.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: challenge null");
          localk.errCode = 90004;
          localk.errMsg = "challenge is null";
          continue;
        }
        if (paramBundle.skD.length() >= 512)
        {
          ac.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: challenge too long");
          localk.errCode = 90004;
          localk.errMsg = "challenge is too long. 512 chars at most";
          continue;
        }
        if (bs.isNullOrNil(paramBundle.content))
        {
          paramBundle.content = getString(2131764073);
          continue;
        }
        if (paramBundle.content.length() <= 42) {
          continue;
        }
        ac.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: content too long. use default");
        paramBundle.content = getString(2131764073);
        continue;
        this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
        localObject = com.tencent.mm.plugin.soter.c.a.znh;
        this.znZ = com.tencent.mm.plugin.soter.c.a.a(this, paramBundle, localk, zof);
        if (this.znZ == null)
        {
          ac.e("MicroMsg.SoterAuthenticationUIWC", "hy: no corresponding authen mode");
          localk.errCode = 90003;
          localk.errMsg = "no corresponding mode";
          a(localk);
          AppMethodBeat.o(130892);
          return;
        }
        this.znZ.znA = new f();
        this.znZ.znz = new e();
        this.znZ.mScene = 2;
        this.appId = getIntent().getStringExtra("key_app_id");
        this.znZ.gb();
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
    if ((this.opZ != null) && (this.opZ.isShowing()))
    {
      ac.i("MicroMsg.SoterAuthenticationUIWC", "onDestroy mProgressDialog dismiss!");
      this.opZ.dismiss();
    }
    if ((znk != null) && (znk.isShowing()))
    {
      ac.i("MicroMsg.SoterAuthenticationUIWC", "onDestroy mAuthenDialog dismiss!");
      znk.dismiss();
    }
    a.a(zof);
    AppMethodBeat.o(130899);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(130894);
    super.onPause();
    if (this.znZ != null) {
      this.znZ.onPause();
    }
    AppMethodBeat.o(130894);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(130898);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (this.znZ != null) {
      this.znZ.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(130898);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(130893);
    super.onResume();
    if (this.znZ != null) {
      this.znZ.onResume();
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
    private WeakReference<SoterAuthenticationUIWC> qAq;
    
    private a(SoterAuthenticationUIWC paramSoterAuthenticationUIWC)
    {
      AppMethodBeat.i(130888);
      this.qAq = null;
      this.qAq = new WeakReference(paramSoterAuthenticationUIWC);
      AppMethodBeat.o(130888);
    }
    
    @TargetApi(23)
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(130889);
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      default: 
        ac.e("MicroMsg.SoterAuthenticationUIWC", "hy: unidentified msg: %d", new Object[] { Integer.valueOf(paramMessage.what) });
        AppMethodBeat.o(130889);
        return;
      case 0: 
        ac.i("MicroMsg.SoterAuthenticationUIWC", "hy: inform ok");
        paramMessage = (k)paramMessage.obj;
        if ((this.qAq != null) && (this.qAq.get() != null))
        {
          SoterAuthenticationUIWC.a((SoterAuthenticationUIWC)this.qAq.get(), paramMessage);
          AppMethodBeat.o(130889);
          return;
        }
        ac.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
        AppMethodBeat.o(130889);
        return;
      case 1: 
        ac.i("MicroMsg.SoterAuthenticationUIWC", "hy: inform cancel");
        paramMessage = (k)paramMessage.obj;
        if ((this.qAq != null) && (this.qAq.get() != null))
        {
          SoterAuthenticationUIWC.b((SoterAuthenticationUIWC)this.qAq.get(), paramMessage);
          AppMethodBeat.o(130889);
          return;
        }
        ac.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
        AppMethodBeat.o(130889);
        return;
      case 2: 
        ac.i("MicroMsg.SoterAuthenticationUIWC", "hy: inform fail");
        paramMessage = (k)paramMessage.obj;
        if ((this.qAq != null) && (this.qAq.get() != null))
        {
          SoterAuthenticationUIWC.c((SoterAuthenticationUIWC)this.qAq.get(), paramMessage);
          AppMethodBeat.o(130889);
          return;
        }
        ac.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
        AppMethodBeat.o(130889);
        return;
      case 3: 
        ac.i("MicroMsg.SoterAuthenticationUIWC", "hy: request permission");
        if ((this.qAq != null) && (this.qAq.get() != null))
        {
          Object localObject = paramMessage.getData().getStringArray("permissions");
          int i = paramMessage.getData().getInt("request_code");
          if ((localObject == null) || (localObject.length <= 1))
          {
            ac.e("MicroMsg.SoterAuthenticationUIWC", "hy: permission null");
            AppMethodBeat.o(130889);
            return;
          }
          paramMessage = (SoterAuthenticationUIWC)this.qAq.get();
          localObject = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a()).ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramMessage, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/soter/ui/SoterAuthenticationUIWC$SoterMpAuthenHandler", "handleMessage", "(Landroid/os/Message;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
          paramMessage.requestPermissions((String[])((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(1)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramMessage, "com/tencent/mm/plugin/soter/ui/SoterAuthenticationUIWC$SoterMpAuthenHandler", "handleMessage", "(Landroid/os/Message;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
          AppMethodBeat.o(130889);
          return;
        }
        ac.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
        AppMethodBeat.o(130889);
        return;
      case 4: 
        ac.i("MicroMsg.SoterAuthenticationUIWC", "hy: show progress");
        if ((this.qAq != null) && (this.qAq.get() != null))
        {
          SoterAuthenticationUIWC.a((SoterAuthenticationUIWC)this.qAq.get());
          AppMethodBeat.o(130889);
          return;
        }
        ac.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
        AppMethodBeat.o(130889);
        return;
      case 5: 
        ac.i("MicroMsg.SoterAuthenticationUIWC", "hy: dismiss progress");
        if ((this.qAq != null) && (this.qAq.get() != null))
        {
          SoterAuthenticationUIWC.b((SoterAuthenticationUIWC)this.qAq.get());
          AppMethodBeat.o(130889);
          return;
        }
        ac.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
        AppMethodBeat.o(130889);
        return;
      }
      ac.i("MicroMsg.SoterAuthenticationUIWC", "hy: show dialog");
      if ((this.qAq != null) && (this.qAq.get() != null))
      {
        SoterAuthenticationUIWC.c((com.tencent.mm.ui.widget.a.d)paramMessage.obj);
        AppMethodBeat.o(130889);
        return;
      }
      ac.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
      AppMethodBeat.o(130889);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterAuthenticationUIWC
 * JD-Core Version:    0.7.0.1
 */