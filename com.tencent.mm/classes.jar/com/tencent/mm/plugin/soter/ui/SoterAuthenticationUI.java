package com.tencent.mm.plugin.soter.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.c.c.a;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.soter.a.a.1;
import com.tencent.soter.a.g.e.a;
import com.tencent.soter.a.g.f;
import com.tencent.soter.a.g.g;
import java.lang.ref.WeakReference;

public class SoterAuthenticationUI
  extends AppCompatActivity
{
  private static com.tencent.mm.ui.widget.a.d FhA = null;
  public static a Fir = null;
  private c.a FhR;
  private com.tencent.mm.plugin.soter.c.c Fio;
  private boolean Fip;
  private com.tencent.soter.core.c.i Fiq;
  private com.tencent.soter.a.b.b<com.tencent.soter.a.b.d> Fis;
  private ResultReceiver MU;
  private String appId;
  private int fromScene;
  private ProgressDialog qoU;
  private int scene;
  
  public SoterAuthenticationUI()
  {
    AppMethodBeat.i(145977);
    this.Fio = null;
    this.qoU = null;
    this.fromScene = -1;
    this.scene = -1;
    this.Fip = false;
    this.Fiq = null;
    this.appId = null;
    this.FhR = new c.a()
    {
      public final void a(com.tencent.soter.core.c.i paramAnonymousi)
      {
        AppMethodBeat.i(145972);
        SoterAuthenticationUI.a(SoterAuthenticationUI.this, paramAnonymousi);
        AppMethodBeat.o(145972);
      }
    };
    this.Fis = new com.tencent.soter.a.b.b() {};
    AppMethodBeat.o(145977);
  }
  
  private static int Tc(int paramInt)
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
    AppMethodBeat.i(145982);
    this.MU.send(1, b(paramk));
    c(paramk);
    finish();
    AppMethodBeat.o(145982);
  }
  
  private static Bundle b(k paramk)
  {
    AppMethodBeat.i(145983);
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", paramk.errCode);
    localBundle.putString("err_msg", paramk.errMsg);
    localBundle.putByte("use_mode", paramk.FhW);
    localBundle.putString("result_json", paramk.dZL);
    localBundle.putString("result_json_signature", paramk.FhX);
    Log.d("MicroMsg.SoterAuthenticationUI", "hy: dump mp soter result: %s", new Object[] { localBundle.toString() });
    AppMethodBeat.o(145983);
    return localBundle;
  }
  
  private void c(k paramk)
  {
    AppMethodBeat.i(145984);
    if (paramk == null)
    {
      AppMethodBeat.o(145984);
      return;
    }
    if (this.fromScene == 1)
    {
      int i = Tc(paramk.errCode);
      com.tencent.mm.plugin.soter.d.i.aB(this.appId, paramk.errCode, i);
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
    AppMethodBeat.i(201780);
    Resources localResources = MMApplicationContext.getResources();
    AppMethodBeat.o(201780);
    return localResources;
  }
  
  @TargetApi(23)
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(145978);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    this.MU = ((ResultReceiver)getIntent().getParcelableExtra("Soter_Result_Receiver"));
    if (Fir != null) {
      a.a(Fir);
    }
    Fir = new a(this, (byte)0);
    paramBundle = new j();
    Object localObject1 = new k();
    Object localObject2 = getIntent().getStringExtra("auth_mode");
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode : null");
      ((k)localObject1).errCode = 90003;
      ((k)localObject1).errMsg = "authen mode is null";
    }
    for (;;)
    {
      if (((k)localObject1).errCode != 0)
      {
        a((k)localObject1);
        AppMethodBeat.o(145978);
        return;
      }
      try
      {
        paramBundle.FhV = Byte.parseByte(Util.nullAs(((String)localObject2).substring(2), "00"), 16);
        paramBundle.wFE = getIntent().getStringExtra("challenge");
        paramBundle.content = getIntent().getStringExtra("auth_content");
        if (!com.tencent.soter.core.a.hlj())
        {
          Log.e("MicroMsg.SoterAuthenticationUI", "hy: not support soter");
          ((k)localObject1).errCode = 90001;
          ((k)localObject1).errMsg = "not support soter";
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Log.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode format: %s", new Object[] { localObject2 });
        ((k)localObject1).errCode = 90003;
        ((k)localObject1).errMsg = "authen mode is illegal: number format error. found: ".concat(String.valueOf(localObject2));
        continue;
        if (paramBundle.FhV <= 0)
        {
          Log.e("MicroMsg.SoterAuthenticationUI", "hy: param error: request mode illegal");
          ((k)localObject1).errCode = 90003;
          ((k)localObject1).errMsg = "resp model error";
          continue;
        }
        if (Util.isNullOrNil(paramBundle.wFE))
        {
          Log.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge null");
          ((k)localObject1).errCode = 90004;
          ((k)localObject1).errMsg = "challenge is null";
          continue;
        }
        if (paramBundle.wFE.length() >= 512)
        {
          Log.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge too long");
          ((k)localObject1).errCode = 90004;
          ((k)localObject1).errMsg = "challenge is too long. 512 chars at most";
          continue;
        }
        if (Util.isNullOrNil(paramBundle.content))
        {
          paramBundle.content = getString(2131766315);
          continue;
        }
        if (paramBundle.content.length() <= 42) {
          continue;
        }
        Log.e("MicroMsg.SoterAuthenticationUI", "hy: param error: content too long. use default");
        paramBundle.content = getString(2131766315);
        continue;
        this.fromScene = getIntent().getIntExtra("key_soter_fp_luggage_fromscene", 1);
        this.scene = getIntent().getIntExtra("key_soter_fp_luggage_scene", 2048);
        localObject2 = com.tencent.mm.plugin.soter.c.a.Fhx;
        this.Fio = com.tencent.mm.plugin.soter.c.a.a(this, paramBundle, (k)localObject1, Fir);
        if (this.Fio == null)
        {
          Log.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
          ((k)localObject1).errCode = 90003;
          ((k)localObject1).errMsg = "no corresponding mode";
          a((k)localObject1);
          AppMethodBeat.o(145978);
          return;
        }
        this.Fio.FhQ = null;
        this.Fio.FhP = null;
        this.Fio.mScene = this.scene;
        this.Fio.FhR = this.FhR;
        boolean bool = com.tencent.soter.a.c.b.hlG().isInit();
        Log.i("MicroMsg.SoterAuthenticationUI", "hy: isInit:".concat(String.valueOf(bool)));
        if (!bool)
        {
          Log.i("MicroMsg.SoterAuthenticationUI", "hy: init scene:" + this.Fio.mScene);
          paramBundle = new e.a().U(new int[] { this.Fio.mScene }).RRf;
          localObject1 = getApplicationContext();
          localObject2 = this.Fis;
          g.hlR().aj(new a.1((Context)localObject1, paramBundle, (com.tencent.soter.a.b.b)localObject2));
          this.Fip = true;
        }
        this.appId = getIntent().getStringExtra("key_app_id");
        this.Fio.gA();
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
    if ((this.qoU != null) && (this.qoU.isShowing()))
    {
      Log.i("MicroMsg.SoterAuthenticationUI", "onDestroy mProgressDialog dismiss!");
      this.qoU.dismiss();
    }
    if ((FhA != null) && (FhA.isShowing()))
    {
      Log.i("MicroMsg.SoterAuthenticationUI", "onDestroy mAuthenDialog dismiss!");
      FhA.dismiss();
    }
    a.a(Fir);
    if (this.Fip)
    {
      f.hlO().hlP();
      com.tencent.soter.a.c.b localb = com.tencent.soter.a.c.b.hlG();
      try
      {
        localb.isInit = false;
        localb.dEI = false;
        localb.RQy = new SparseArray(10);
        localb.RQz = null;
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
    if (this.Fio != null) {
      this.Fio.onPause();
    }
    AppMethodBeat.o(145980);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(145985);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (this.Fio != null) {
      this.Fio.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(145985);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(145979);
    super.onResume();
    if (this.Fio != null) {
      this.Fio.onResume();
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
    private WeakReference<SoterAuthenticationUI> Fiu;
    
    private a(SoterAuthenticationUI paramSoterAuthenticationUI)
    {
      AppMethodBeat.i(145974);
      this.Fiu = null;
      this.Fiu = new WeakReference(paramSoterAuthenticationUI);
      AppMethodBeat.o(145974);
    }
    
    @TargetApi(23)
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
        paramMessage = (k)paramMessage.obj;
        if ((this.Fiu != null) && (this.Fiu.get() != null))
        {
          SoterAuthenticationUI.a((SoterAuthenticationUI)this.Fiu.get(), paramMessage);
          AppMethodBeat.o(145975);
          return;
        }
        Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
        AppMethodBeat.o(145975);
        return;
      case 1: 
        Log.i("MicroMsg.SoterAuthenticationUI", "hy: inform cancel");
        paramMessage = (k)paramMessage.obj;
        if ((this.Fiu != null) && (this.Fiu.get() != null))
        {
          SoterAuthenticationUI.b((SoterAuthenticationUI)this.Fiu.get(), paramMessage);
          AppMethodBeat.o(145975);
          return;
        }
        Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
        AppMethodBeat.o(145975);
        return;
      case 2: 
        Log.i("MicroMsg.SoterAuthenticationUI", "hy: inform fail");
        paramMessage = (k)paramMessage.obj;
        if ((this.Fiu != null) && (this.Fiu.get() != null))
        {
          SoterAuthenticationUI.c((SoterAuthenticationUI)this.Fiu.get(), paramMessage);
          AppMethodBeat.o(145975);
          return;
        }
        Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
        AppMethodBeat.o(145975);
        return;
      case 3: 
        Log.i("MicroMsg.SoterAuthenticationUI", "hy: request permission");
        if ((this.Fiu != null) && (this.Fiu.get() != null))
        {
          Object localObject = paramMessage.getData().getStringArray("permissions");
          int i = paramMessage.getData().getInt("request_code");
          if ((localObject == null) || (localObject.length <= 1))
          {
            Log.e("MicroMsg.SoterAuthenticationUI", "hy: permission null");
            AppMethodBeat.o(145975);
            return;
          }
          paramMessage = (SoterAuthenticationUI)this.Fiu.get();
          localObject = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramMessage, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/soter/ui/SoterAuthenticationUI$SoterMpAuthenHandler", "handleMessage", "(Landroid/os/Message;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
          paramMessage.requestPermissions((String[])((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(1)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramMessage, "com/tencent/mm/plugin/soter/ui/SoterAuthenticationUI$SoterMpAuthenHandler", "handleMessage", "(Landroid/os/Message;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
          AppMethodBeat.o(145975);
          return;
        }
        Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
        AppMethodBeat.o(145975);
        return;
      case 4: 
        Log.i("MicroMsg.SoterAuthenticationUI", "hy: show progress");
        if ((this.Fiu != null) && (this.Fiu.get() != null))
        {
          SoterAuthenticationUI.a((SoterAuthenticationUI)this.Fiu.get());
          AppMethodBeat.o(145975);
          return;
        }
        Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
        AppMethodBeat.o(145975);
        return;
      case 5: 
        Log.i("MicroMsg.SoterAuthenticationUI", "hy: dismiss progress");
        if ((this.Fiu != null) && (this.Fiu.get() != null))
        {
          SoterAuthenticationUI.b((SoterAuthenticationUI)this.Fiu.get());
          AppMethodBeat.o(145975);
          return;
        }
        Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
        AppMethodBeat.o(145975);
        return;
      }
      Log.i("MicroMsg.SoterAuthenticationUI", "hy: show dialog");
      if ((this.Fiu != null) && (this.Fiu.get() != null))
      {
        SoterAuthenticationUI.c((com.tencent.mm.ui.widget.a.d)paramMessage.obj);
        AppMethodBeat.o(145975);
        return;
      }
      Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
      AppMethodBeat.o(145975);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterAuthenticationUI
 * JD-Core Version:    0.7.0.1
 */