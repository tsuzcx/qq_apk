package com.tencent.mm.plugin.soter.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.util.SparseArray;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.a.f;
import com.tencent.mm.plugin.soter.c.c.a;
import com.tencent.mm.plugin.soter.model.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.soter.a.a.1;
import com.tencent.soter.a.b.d;
import com.tencent.soter.a.g.e.a;
import com.tencent.soter.core.c.i;
import java.lang.ref.WeakReference;

public class SoterAuthenticationUI
  extends AppCompatActivity
{
  private static e RZE = null;
  public static a Sav = null;
  private c.a RZV;
  private com.tencent.mm.plugin.soter.c.c Sas;
  private boolean Sat;
  private i Sau;
  private com.tencent.soter.a.b.b<d> Saw;
  private String appId;
  private ResultReceiver dK;
  private int fromScene;
  private int scene;
  private ProgressDialog wQT;
  
  public SoterAuthenticationUI()
  {
    AppMethodBeat.i(145977);
    this.Sas = null;
    this.wQT = null;
    this.fromScene = -1;
    this.scene = -1;
    this.Sat = false;
    this.Sau = null;
    this.appId = null;
    this.RZV = new c.a()
    {
      public final void a(i paramAnonymousi)
      {
        AppMethodBeat.i(145972);
        SoterAuthenticationUI.a(SoterAuthenticationUI.this, paramAnonymousi);
        AppMethodBeat.o(145972);
      }
    };
    this.Saw = new SoterAuthenticationUI.2(this);
    AppMethodBeat.o(145977);
  }
  
  private void a(h paramh)
  {
    AppMethodBeat.i(145982);
    this.dK.send(1, b(paramh));
    c(paramh);
    finish();
    AppMethodBeat.o(145982);
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
  
  private static Bundle b(h paramh)
  {
    AppMethodBeat.i(145983);
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", paramh.errCode);
    localBundle.putString("err_msg", paramh.errMsg);
    localBundle.putByte("use_mode", paramh.Saa);
    localBundle.putString("result_json", paramh.hZD);
    localBundle.putString("result_json_signature", paramh.Sab);
    Log.d("MicroMsg.SoterAuthenticationUI", "hy: dump mp soter result: %s", new Object[] { localBundle.toString() });
    AppMethodBeat.o(145983);
    return localBundle;
  }
  
  private void c(h paramh)
  {
    AppMethodBeat.i(145984);
    if (paramh == null)
    {
      AppMethodBeat.o(145984);
      return;
    }
    if (this.fromScene == 1)
    {
      int i = adK(paramh.errCode);
      com.tencent.mm.plugin.soter.model.f.aM(this.appId, paramh.errCode, i);
    }
    AppMethodBeat.o(145984);
  }
  
  public void finish()
  {
    AppMethodBeat.i(145981);
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(145981);
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(262521);
    Resources localResources = MMApplicationContext.getResources();
    AppMethodBeat.o(262521);
    return localResources;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(145978);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    this.dK = ((ResultReceiver)getIntent().getParcelableExtra("Soter_Result_Receiver"));
    if (Sav != null) {
      a.a(Sav);
    }
    Sav = new a(this, (byte)0);
    paramBundle = new com.tencent.mm.plugin.soter.model.g();
    Object localObject1 = new h();
    Object localObject2 = getIntent().getStringExtra("auth_mode");
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode : null");
      ((h)localObject1).errCode = 90003;
      ((h)localObject1).errMsg = "authen mode is null";
    }
    for (;;)
    {
      if (((h)localObject1).errCode != 0)
      {
        a((h)localObject1);
        AppMethodBeat.o(145978);
        return;
      }
      try
      {
        paramBundle.RZZ = Byte.parseByte(Util.nullAs(((String)localObject2).substring(2), "00"), 16);
        paramBundle.Hgd = getIntent().getStringExtra("challenge");
        paramBundle.content = getIntent().getStringExtra("auth_content");
        if (!com.tencent.soter.core.a.jXV())
        {
          Log.e("MicroMsg.SoterAuthenticationUI", "hy: not support soter");
          ((h)localObject1).errCode = 90001;
          ((h)localObject1).errMsg = "not support soter";
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Log.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode format: %s", new Object[] { localObject2 });
        ((h)localObject1).errCode = 90003;
        ((h)localObject1).errMsg = "authen mode is illegal: number format error. found: ".concat(String.valueOf(localObject2));
        continue;
        if (paramBundle.RZZ <= 0)
        {
          Log.e("MicroMsg.SoterAuthenticationUI", "hy: param error: request mode illegal");
          ((h)localObject1).errCode = 90003;
          ((h)localObject1).errMsg = "resp model error";
          continue;
        }
        if (Util.isNullOrNil(paramBundle.Hgd))
        {
          Log.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge null");
          ((h)localObject1).errCode = 90004;
          ((h)localObject1).errMsg = "challenge is null";
          continue;
        }
        if (paramBundle.Hgd.length() >= 512)
        {
          Log.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge too long");
          ((h)localObject1).errCode = 90004;
          ((h)localObject1).errMsg = "challenge is too long. 512 chars at most";
          continue;
        }
        if (Util.isNullOrNil(paramBundle.content))
        {
          paramBundle.content = getString(a.f.soter_authen_put_finger_msg);
          continue;
        }
        if (paramBundle.content.length() <= 42) {
          continue;
        }
        Log.e("MicroMsg.SoterAuthenticationUI", "hy: param error: content too long. use default");
        paramBundle.content = getString(a.f.soter_authen_put_finger_msg);
        continue;
        this.fromScene = getIntent().getIntExtra("key_soter_fp_luggage_fromscene", 1);
        this.scene = getIntent().getIntExtra("key_soter_fp_luggage_scene", 2048);
        localObject2 = com.tencent.mm.plugin.soter.c.a.RZB;
        this.Sas = com.tencent.mm.plugin.soter.c.a.a(this, paramBundle, (h)localObject1, Sav);
        if (this.Sas == null)
        {
          Log.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
          ((h)localObject1).errCode = 90003;
          ((h)localObject1).errMsg = "no corresponding mode";
          a((h)localObject1);
          AppMethodBeat.o(145978);
          return;
        }
        this.Sas.RZU = null;
        this.Sas.RZT = null;
        this.Sas.mScene = this.scene;
        this.Sas.RZV = this.RZV;
        boolean bool = com.tencent.soter.a.c.b.jYt().isInit();
        Log.i("MicroMsg.SoterAuthenticationUI", "hy: isInit:".concat(String.valueOf(bool)));
        if (!bool)
        {
          Log.i("MicroMsg.SoterAuthenticationUI", "hy: init scene:" + this.Sas.mScene);
          paramBundle = new e.a().V(new int[] { this.Sas.mScene }).ahyC;
          localObject1 = getApplicationContext();
          localObject2 = this.Saw;
          com.tencent.soter.a.g.g.jYG().au(new a.1((Context)localObject1, paramBundle, (com.tencent.soter.a.b.b)localObject2));
          this.Sat = true;
        }
        this.appId = getIntent().getStringExtra("key_app_id");
        this.Sas.bB();
        AppMethodBeat.o(145978);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label214:
        break label214;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(145986);
    super.onDestroy();
    if ((this.wQT != null) && (this.wQT.isShowing()))
    {
      Log.i("MicroMsg.SoterAuthenticationUI", "onDestroy mProgressDialog dismiss!");
      this.wQT.dismiss();
    }
    if ((RZE != null) && (RZE.isShowing()))
    {
      Log.i("MicroMsg.SoterAuthenticationUI", "onDestroy mAuthenDialog dismiss!");
      RZE.dismiss();
    }
    a.a(Sav);
    if (this.Sat)
    {
      com.tencent.soter.a.g.f.jYD().jYE();
      com.tencent.soter.a.c.b localb = com.tencent.soter.a.c.b.jYt();
      try
      {
        localb.isInit = false;
        localb.hCb = false;
        localb.ahxQ = new SparseArray(10);
        localb.ahxR = null;
        return;
      }
      finally
      {
        AppMethodBeat.o(145986);
      }
    }
    AppMethodBeat.o(145986);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(145980);
    super.onPause();
    if (this.Sas != null) {
      this.Sas.onPause();
    }
    AppMethodBeat.o(145980);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(145985);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (this.Sas != null) {
      this.Sas.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(145985);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(145979);
    super.onResume();
    if (this.Sas != null) {
      this.Sas.onResume();
    }
    overridePendingTransition(0, 0);
    AppMethodBeat.o(145979);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
    extends Handler
  {
    private WeakReference<SoterAuthenticationUI> Say;
    
    private a(SoterAuthenticationUI paramSoterAuthenticationUI)
    {
      AppMethodBeat.i(145974);
      this.Say = null;
      this.Say = new WeakReference(paramSoterAuthenticationUI);
      AppMethodBeat.o(145974);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(145975);
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      default: 
        Log.e("MicroMsg.SoterAuthenticationUI", "hy: unidentified msg: %d", new Object[] { Integer.valueOf(paramMessage.what) });
        AppMethodBeat.o(145975);
        return;
      case 0: 
        Log.i("MicroMsg.SoterAuthenticationUI", "hy: inform ok");
        paramMessage = (h)paramMessage.obj;
        if ((this.Say != null) && (this.Say.get() != null))
        {
          SoterAuthenticationUI.a((SoterAuthenticationUI)this.Say.get(), paramMessage);
          AppMethodBeat.o(145975);
          return;
        }
        Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
        AppMethodBeat.o(145975);
        return;
      case 1: 
        Log.i("MicroMsg.SoterAuthenticationUI", "hy: inform cancel");
        paramMessage = (h)paramMessage.obj;
        if ((this.Say != null) && (this.Say.get() != null))
        {
          SoterAuthenticationUI.b((SoterAuthenticationUI)this.Say.get(), paramMessage);
          AppMethodBeat.o(145975);
          return;
        }
        Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
        AppMethodBeat.o(145975);
        return;
      case 2: 
        Log.i("MicroMsg.SoterAuthenticationUI", "hy: inform fail");
        paramMessage = (h)paramMessage.obj;
        if ((this.Say != null) && (this.Say.get() != null))
        {
          SoterAuthenticationUI.c((SoterAuthenticationUI)this.Say.get(), paramMessage);
          AppMethodBeat.o(145975);
          return;
        }
        Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
        AppMethodBeat.o(145975);
        return;
      case 3: 
        Log.i("MicroMsg.SoterAuthenticationUI", "hy: request permission");
        if ((this.Say != null) && (this.Say.get() != null))
        {
          Object localObject = paramMessage.getData().getStringArray("permissions");
          int i = paramMessage.getData().getInt("request_code");
          if ((localObject == null) || (localObject.length <= 1))
          {
            Log.e("MicroMsg.SoterAuthenticationUI", "hy: permission null");
            AppMethodBeat.o(145975);
            return;
          }
          paramMessage = (SoterAuthenticationUI)this.Say.get();
          localObject = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramMessage, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/soter/ui/SoterAuthenticationUI$SoterMpAuthenHandler", "handleMessage", "(Landroid/os/Message;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
          paramMessage.requestPermissions((String[])((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(1)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramMessage, "com/tencent/mm/plugin/soter/ui/SoterAuthenticationUI$SoterMpAuthenHandler", "handleMessage", "(Landroid/os/Message;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
          AppMethodBeat.o(145975);
          return;
        }
        Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
        AppMethodBeat.o(145975);
        return;
      case 4: 
        Log.i("MicroMsg.SoterAuthenticationUI", "hy: show progress");
        if ((this.Say != null) && (this.Say.get() != null))
        {
          SoterAuthenticationUI.a((SoterAuthenticationUI)this.Say.get());
          AppMethodBeat.o(145975);
          return;
        }
        Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
        AppMethodBeat.o(145975);
        return;
      case 5: 
        Log.i("MicroMsg.SoterAuthenticationUI", "hy: dismiss progress");
        if ((this.Say != null) && (this.Say.get() != null))
        {
          SoterAuthenticationUI.b((SoterAuthenticationUI)this.Say.get());
          AppMethodBeat.o(145975);
          return;
        }
        Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
        AppMethodBeat.o(145975);
        return;
      }
      Log.i("MicroMsg.SoterAuthenticationUI", "hy: show dialog");
      if ((this.Say != null) && (this.Say.get() != null))
      {
        SoterAuthenticationUI.c((e)paramMessage.obj);
        AppMethodBeat.o(145975);
        return;
      }
      Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
      AppMethodBeat.o(145975);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterAuthenticationUI
 * JD-Core Version:    0.7.0.1
 */