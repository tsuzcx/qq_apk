package com.tencent.mm.plugin.soter.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.soter.a.a.1;
import com.tencent.soter.a.g.e.a;
import com.tencent.soter.a.g.f;
import com.tencent.soter.a.g.g;
import java.lang.ref.WeakReference;

public class SoterAuthenticationUI
  extends AppCompatActivity
{
  private static com.tencent.mm.ui.widget.a.d AWH = null;
  public static a AXz = null;
  private c.a AWY;
  private com.tencent.soter.a.b.b<com.tencent.soter.a.b.d> AXA;
  private com.tencent.mm.plugin.soter.c.c AXw;
  private boolean AXx;
  private com.tencent.soter.core.c.i AXy;
  private ResultReceiver MK;
  private String appId;
  private int fromScene;
  private ProgressDialog oZW;
  private int scene;
  
  public SoterAuthenticationUI()
  {
    AppMethodBeat.i(145977);
    this.AXw = null;
    this.oZW = null;
    this.fromScene = -1;
    this.scene = -1;
    this.AXx = false;
    this.AXy = null;
    this.appId = null;
    this.AWY = new c.a()
    {
      public final void a(com.tencent.soter.core.c.i paramAnonymousi)
      {
        AppMethodBeat.i(145972);
        SoterAuthenticationUI.a(SoterAuthenticationUI.this, paramAnonymousi);
        AppMethodBeat.o(145972);
      }
    };
    this.AXA = new SoterAuthenticationUI.2(this);
    AppMethodBeat.o(145977);
  }
  
  private static int Mf(int paramInt)
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
    this.MK.send(1, b(paramk));
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
    localBundle.putByte("use_mode", paramk.AXe);
    localBundle.putString("result_json", paramk.dHZ);
    localBundle.putString("result_json_signature", paramk.AXf);
    ae.d("MicroMsg.SoterAuthenticationUI", "hy: dump mp soter result: %s", new Object[] { localBundle.toString() });
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
      int i = Mf(paramk.errCode);
      com.tencent.mm.plugin.soter.d.i.ay(this.appId, paramk.errCode, i);
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
  
  @TargetApi(23)
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(145978);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    this.MK = ((ResultReceiver)getIntent().getParcelableExtra("Soter_Result_Receiver"));
    if (AXz != null) {
      a.a(AXz);
    }
    AXz = new a(this, (byte)0);
    paramBundle = new j();
    Object localObject1 = new k();
    Object localObject2 = getIntent().getStringExtra("auth_mode");
    if (bu.isNullOrNil((String)localObject2))
    {
      ae.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode : null");
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
        paramBundle.AXd = Byte.parseByte(bu.bI(((String)localObject2).substring(2), "00"), 16);
        paramBundle.trY = getIntent().getStringExtra("challenge");
        paramBundle.content = getIntent().getStringExtra("auth_content");
        if (!com.tencent.soter.core.a.fYY())
        {
          ae.e("MicroMsg.SoterAuthenticationUI", "hy: not support soter");
          ((k)localObject1).errCode = 90001;
          ((k)localObject1).errMsg = "not support soter";
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        ae.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode format: %s", new Object[] { localObject2 });
        ((k)localObject1).errCode = 90003;
        ((k)localObject1).errMsg = "authen mode is illegal: number format error. found: ".concat(String.valueOf(localObject2));
        continue;
        if (paramBundle.AXd <= 0)
        {
          ae.e("MicroMsg.SoterAuthenticationUI", "hy: param error: request mode illegal");
          ((k)localObject1).errCode = 90003;
          ((k)localObject1).errMsg = "resp model error";
          continue;
        }
        if (bu.isNullOrNil(paramBundle.trY))
        {
          ae.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge null");
          ((k)localObject1).errCode = 90004;
          ((k)localObject1).errMsg = "challenge is null";
          continue;
        }
        if (paramBundle.trY.length() >= 512)
        {
          ae.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge too long");
          ((k)localObject1).errCode = 90004;
          ((k)localObject1).errMsg = "challenge is too long. 512 chars at most";
          continue;
        }
        if (bu.isNullOrNil(paramBundle.content))
        {
          paramBundle.content = getString(2131764073);
          continue;
        }
        if (paramBundle.content.length() <= 42) {
          continue;
        }
        ae.e("MicroMsg.SoterAuthenticationUI", "hy: param error: content too long. use default");
        paramBundle.content = getString(2131764073);
        continue;
        this.fromScene = getIntent().getIntExtra("key_soter_fp_luggage_fromscene", 1);
        this.scene = getIntent().getIntExtra("key_soter_fp_luggage_scene", 2048);
        localObject2 = com.tencent.mm.plugin.soter.c.a.AWE;
        this.AXw = com.tencent.mm.plugin.soter.c.a.a(this, paramBundle, (k)localObject1, AXz);
        if (this.AXw == null)
        {
          ae.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
          ((k)localObject1).errCode = 90003;
          ((k)localObject1).errMsg = "no corresponding mode";
          a((k)localObject1);
          AppMethodBeat.o(145978);
          return;
        }
        this.AXw.AWX = null;
        this.AXw.AWW = null;
        this.AXw.mScene = this.scene;
        this.AXw.AWY = this.AWY;
        boolean bool = com.tencent.soter.a.c.b.fZv().isInit();
        ae.i("MicroMsg.SoterAuthenticationUI", "hy: isInit:".concat(String.valueOf(bool)));
        if (!bool)
        {
          ae.i("MicroMsg.SoterAuthenticationUI", "hy: init scene:" + this.AXw.mScene);
          paramBundle = new e.a().N(new int[] { this.AXw.mScene }).MoH;
          localObject1 = getApplicationContext();
          localObject2 = this.AXA;
          g.fZG().ad(new a.1((Context)localObject1, paramBundle, (com.tencent.soter.a.b.b)localObject2));
          this.AXx = true;
        }
        this.appId = getIntent().getStringExtra("key_app_id");
        this.AXw.gt();
        AppMethodBeat.o(145978);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label213:
        break label213;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(145986);
    super.onDestroy();
    if ((this.oZW != null) && (this.oZW.isShowing()))
    {
      ae.i("MicroMsg.SoterAuthenticationUI", "onDestroy mProgressDialog dismiss!");
      this.oZW.dismiss();
    }
    if ((AWH != null) && (AWH.isShowing()))
    {
      ae.i("MicroMsg.SoterAuthenticationUI", "onDestroy mAuthenDialog dismiss!");
      AWH.dismiss();
    }
    a.a(AXz);
    if (this.AXx)
    {
      f.fZD().fZE();
      com.tencent.soter.a.c.b localb = com.tencent.soter.a.c.b.fZv();
      try
      {
        localb.cBE = false;
        localb.dnt = false;
        localb.Moa = new SparseArray(10);
        localb.Mob = null;
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
    if (this.AXw != null) {
      this.AXw.onPause();
    }
    AppMethodBeat.o(145980);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(145985);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (this.AXw != null) {
      this.AXw.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(145985);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(145979);
    super.onResume();
    if (this.AXw != null) {
      this.AXw.onResume();
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
    private WeakReference<SoterAuthenticationUI> rsj;
    
    private a(SoterAuthenticationUI paramSoterAuthenticationUI)
    {
      AppMethodBeat.i(145974);
      this.rsj = null;
      this.rsj = new WeakReference(paramSoterAuthenticationUI);
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
        ae.e("MicroMsg.SoterAuthenticationUI", "hy: unidentified msg: %d", new Object[] { Integer.valueOf(paramMessage.what) });
        AppMethodBeat.o(145975);
        return;
      case 0: 
        ae.i("MicroMsg.SoterAuthenticationUI", "hy: inform ok");
        paramMessage = (k)paramMessage.obj;
        if ((this.rsj != null) && (this.rsj.get() != null))
        {
          SoterAuthenticationUI.a((SoterAuthenticationUI)this.rsj.get(), paramMessage);
          AppMethodBeat.o(145975);
          return;
        }
        ae.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
        AppMethodBeat.o(145975);
        return;
      case 1: 
        ae.i("MicroMsg.SoterAuthenticationUI", "hy: inform cancel");
        paramMessage = (k)paramMessage.obj;
        if ((this.rsj != null) && (this.rsj.get() != null))
        {
          SoterAuthenticationUI.b((SoterAuthenticationUI)this.rsj.get(), paramMessage);
          AppMethodBeat.o(145975);
          return;
        }
        ae.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
        AppMethodBeat.o(145975);
        return;
      case 2: 
        ae.i("MicroMsg.SoterAuthenticationUI", "hy: inform fail");
        paramMessage = (k)paramMessage.obj;
        if ((this.rsj != null) && (this.rsj.get() != null))
        {
          SoterAuthenticationUI.c((SoterAuthenticationUI)this.rsj.get(), paramMessage);
          AppMethodBeat.o(145975);
          return;
        }
        ae.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
        AppMethodBeat.o(145975);
        return;
      case 3: 
        ae.i("MicroMsg.SoterAuthenticationUI", "hy: request permission");
        if ((this.rsj != null) && (this.rsj.get() != null))
        {
          Object localObject = paramMessage.getData().getStringArray("permissions");
          int i = paramMessage.getData().getInt("request_code");
          if ((localObject == null) || (localObject.length <= 1))
          {
            ae.e("MicroMsg.SoterAuthenticationUI", "hy: permission null");
            AppMethodBeat.o(145975);
            return;
          }
          paramMessage = (SoterAuthenticationUI)this.rsj.get();
          localObject = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a()).bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramMessage, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/soter/ui/SoterAuthenticationUI$SoterMpAuthenHandler", "handleMessage", "(Landroid/os/Message;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
          paramMessage.requestPermissions((String[])((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(1)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramMessage, "com/tencent/mm/plugin/soter/ui/SoterAuthenticationUI$SoterMpAuthenHandler", "handleMessage", "(Landroid/os/Message;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
          AppMethodBeat.o(145975);
          return;
        }
        ae.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
        AppMethodBeat.o(145975);
        return;
      case 4: 
        ae.i("MicroMsg.SoterAuthenticationUI", "hy: show progress");
        if ((this.rsj != null) && (this.rsj.get() != null))
        {
          SoterAuthenticationUI.a((SoterAuthenticationUI)this.rsj.get());
          AppMethodBeat.o(145975);
          return;
        }
        ae.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
        AppMethodBeat.o(145975);
        return;
      case 5: 
        ae.i("MicroMsg.SoterAuthenticationUI", "hy: dismiss progress");
        if ((this.rsj != null) && (this.rsj.get() != null))
        {
          SoterAuthenticationUI.b((SoterAuthenticationUI)this.rsj.get());
          AppMethodBeat.o(145975);
          return;
        }
        ae.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
        AppMethodBeat.o(145975);
        return;
      }
      ae.i("MicroMsg.SoterAuthenticationUI", "hy: show dialog");
      if ((this.rsj != null) && (this.rsj.get() != null))
      {
        SoterAuthenticationUI.c((com.tencent.mm.ui.widget.a.d)paramMessage.obj);
        AppMethodBeat.o(145975);
        return;
      }
      ae.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
      AppMethodBeat.o(145975);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterAuthenticationUI
 * JD-Core Version:    0.7.0.1
 */