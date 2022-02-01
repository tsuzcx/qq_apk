package com.tencent.mm.plugin.voip.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.model.n;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.pulldown.c;
import java.util.HashSet;

@k
@com.tencent.mm.ui.base.a(3)
@c(0)
public class VideoActivity
  extends MMActivity
  implements ServiceConnection, d.a, VoipBaseFragment.d, b
{
  com.tencent.mm.plugin.voip.b.a UIY;
  d UIZ;
  
  public VideoActivity()
  {
    AppMethodBeat.i(115323);
    AppMethodBeat.o(115323);
  }
  
  public final void VR(int paramInt)
  {
    AppMethodBeat.i(292705);
    if (this.UIZ != null) {
      this.UIZ.VR(paramInt);
    }
    AppMethodBeat.o(292705);
  }
  
  public final void VV(int paramInt)
  {
    AppMethodBeat.i(292711);
    if (this.UIZ != null) {
      this.UIZ.VV(paramInt);
    }
    AppMethodBeat.o(292711);
  }
  
  public final void VW(int paramInt)
  {
    AppMethodBeat.i(292616);
    if (this.UIZ != null) {
      this.UIZ.VW(paramInt);
    }
    AppMethodBeat.o(292616);
  }
  
  public final void VX(int paramInt)
  {
    AppMethodBeat.i(292716);
    if (this.UIZ != null) {
      this.UIZ.VY(paramInt);
    }
    AppMethodBeat.o(292716);
  }
  
  public final void VY(int paramInt)
  {
    AppMethodBeat.i(292725);
    if (this.UIZ != null) {
      this.UIZ.VY(paramInt);
    }
    AppMethodBeat.o(292725);
  }
  
  public final void aDJ(String paramString)
  {
    AppMethodBeat.i(115342);
    if (this.UIZ != null) {
      this.UIZ.aDJ(paramString);
    }
    AppMethodBeat.o(115342);
  }
  
  public final void aq(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115359);
    if (this.UIZ != null) {
      this.UIZ.aq(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(115359);
  }
  
  public final void bX(int paramInt, String paramString)
  {
    AppMethodBeat.i(115341);
    if (this.UIZ != null) {
      this.UIZ.bX(paramInt, paramString);
    }
    AppMethodBeat.o(115341);
  }
  
  public final void bf(Bundle paramBundle)
  {
    AppMethodBeat.i(292434);
    super.onCreate(paramBundle);
    setTitleVisibility(8);
    AppMethodBeat.o(292434);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(115343);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "dealContentView", "(Landroid/view/View;)V", this, localb.aYj());
    iar().dealContentView(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "dealContentView", "(Landroid/view/View;)V");
    AppMethodBeat.o(115343);
  }
  
  public void finish()
  {
    AppMethodBeat.i(115334);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "finish", "()V", this);
    iar().finish();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "finish", "()V");
    AppMethodBeat.o(115334);
  }
  
  public final void fwi()
  {
    AppMethodBeat.i(292592);
    if (this.UIZ != null) {
      this.UIZ.fwi();
    }
    AppMethodBeat.o(292592);
  }
  
  public final void fwq()
  {
    AppMethodBeat.i(292700);
    if (this.UIZ != null) {
      this.UIZ.fwq();
    }
    AppMethodBeat.o(292700);
  }
  
  public final Context fwr()
  {
    AppMethodBeat.i(115354);
    if (this.UIZ != null)
    {
      Context localContext = this.UIZ.fwr();
      AppMethodBeat.o(115354);
      return localContext;
    }
    AppMethodBeat.o(115354);
    return null;
  }
  
  public final void fws()
  {
    AppMethodBeat.i(292621);
    if (this.UIZ != null) {
      this.UIZ.fws();
    }
    AppMethodBeat.o(292621);
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(292600);
    if (this.UIZ != null) {
      this.UIZ.fwv();
    }
    AppMethodBeat.o(292600);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(115358);
    if (this.UIZ != null) {
      this.UIZ.fww();
    }
    AppMethodBeat.o(115358);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(292608);
    if (this.UIZ != null) {
      this.UIZ.fwx();
    }
    AppMethodBeat.o(292608);
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(292441);
    int i = iar().getForceOrientation();
    AppMethodBeat.o(292441);
    return i;
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(292563);
    int i = iar().getLayoutId();
    AppMethodBeat.o(292563);
    return i;
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(292735);
    Resources localResources = super.getResources();
    if (this.UIY != null) {
      this.UIY.fixResources(localResources);
    }
    AppMethodBeat.o(292735);
    return localResources;
  }
  
  public final void iU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115328);
    if (this.UIZ != null) {
      this.UIZ.iU(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115328);
  }
  
  public final com.tencent.mm.plugin.voip.b.a iar()
  {
    AppMethodBeat.i(292419);
    if (this.UIY == null)
    {
      if (!getIntent().hasExtra("cached_engine_id")) {
        break label75;
      }
      this.UIY = ((com.tencent.mm.plugin.flutter.voip.a.a)h.ax(com.tencent.mm.plugin.flutter.voip.a.a.class)).aS(this);
      if (!(this.UIY instanceof d)) {
        break label90;
      }
    }
    label75:
    label90:
    for (Object localObject = (d)this.UIY;; localObject = null)
    {
      this.UIZ = ((d)localObject);
      localObject = this.UIY;
      AppMethodBeat.o(292419);
      return localObject;
      this.UIY = new e(this);
      break;
    }
  }
  
  public final void ias()
  {
    AppMethodBeat.i(292475);
    super.finish();
    AppMethodBeat.o(292475);
  }
  
  public final void iat()
  {
    AppMethodBeat.i(292490);
    super.setScreenEnable(true);
    AppMethodBeat.o(292490);
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(292627);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    iar().onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(292627);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(292518);
    if (!iar().onBackPressed()) {
      super.onBackPressed();
    }
    AppMethodBeat.o(292518);
  }
  
  public void onBusinessPermissionDenied(String paramString) {}
  
  public void onBusinessPermissionGranted(String paramString)
  {
    AppMethodBeat.i(292742);
    m.hWU().UyW.hWV();
    SubCoreVoip.hVp().UBF.fwc();
    AppMethodBeat.o(292742);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(115325);
    super.onConfigurationChanged(paramConfiguration);
    iar().onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(115325);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(115324);
    iar().onCreate(paramBundle);
    AppMethodBeat.o(115324);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115331);
    iar().onDestroy();
    super.onDestroy();
    AppMethodBeat.o(115331);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(115329);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.sc(paramInt);
    localb.cH(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", this, localb.aYj());
    if ((iar().onKeyDown(paramInt, paramKeyEvent)) || (super.onKeyDown(paramInt, paramKeyEvent))) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(115329);
      return bool;
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(115336);
    super.onNewIntent(paramIntent);
    iar().onNewIntent(paramIntent);
    AppMethodBeat.o(115336);
  }
  
  public void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(292731);
    iar().onOrientationChange(paramInt);
    AppMethodBeat.o(292731);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(115337);
    super.onPause();
    iar().onPause();
    AppMethodBeat.o(115337);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(292514);
    super.onPostResume();
    iar().onPostResume();
    AppMethodBeat.o(292514);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(115362);
    iar().onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(115362);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(115338);
    super.onResume();
    iar().onResume();
    AppMethodBeat.o(115338);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(292687);
    if (this.UIZ != null) {
      this.UIZ.onServiceConnected(paramComponentName, paramIBinder);
    }
    AppMethodBeat.o(292687);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(292693);
    if (this.UIZ != null) {
      this.UIZ.onServiceDisconnected(paramComponentName);
    }
    AppMethodBeat.o(292693);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(115333);
    super.onStart();
    iar().onStart();
    AppMethodBeat.o(115333);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(115332);
    iar().onStop();
    super.onStop();
    AppMethodBeat.o(115332);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(292531);
    super.onTrimMemory(paramInt);
    iar().onTrimMemory(paramInt);
    AppMethodBeat.o(292531);
  }
  
  protected void onUserLeaveHint()
  {
    AppMethodBeat.i(292524);
    if (!iar().onUserLeaveHint()) {
      super.onUserLeaveHint();
    }
    AppMethodBeat.o(292524);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setConnectSec(long paramLong)
  {
    AppMethodBeat.i(115356);
    if (this.UIZ != null) {
      this.UIZ.setConnectSec(paramLong);
    }
    AppMethodBeat.o(115356);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(115346);
    if (this.UIZ != null) {
      this.UIZ.setMute(paramBoolean);
    }
    AppMethodBeat.o(115346);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(292538);
    if (Build.VERSION.SDK_INT == 26) {
      try
      {
        super.setRequestedOrientation(paramInt);
        AppMethodBeat.o(292538);
        return;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.Voip.VideoActivity", "setRequestedOrientation() couldn't be called successfully");
        AppMethodBeat.o(292538);
        return;
      }
    }
    super.setRequestedOrientation(paramInt);
    AppMethodBeat.o(292538);
  }
  
  public void setScreenEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(115335);
    super.setScreenEnable(paramBoolean);
    if (this.UIZ != null) {
      this.UIZ.setScreenEnable(paramBoolean);
    }
    AppMethodBeat.o(115335);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(115345);
    if (this.UIZ != null) {
      this.UIZ.setVoicePlayDevice(paramInt);
    }
    AppMethodBeat.o(115345);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(292421);
    super.superImportUIComponents(paramHashSet);
    iar().c(paramHashSet);
    AppMethodBeat.o(292421);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115355);
    if (this.UIZ != null) {
      this.UIZ.uninit();
    }
    AppMethodBeat.o(115355);
  }
  
  public final void vJ(boolean paramBoolean)
  {
    AppMethodBeat.i(115357);
    if (this.UIZ != null) {
      this.UIZ.vJ(paramBoolean);
    }
    AppMethodBeat.o(115357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity
 * JD-Core Version:    0.7.0.1
 */