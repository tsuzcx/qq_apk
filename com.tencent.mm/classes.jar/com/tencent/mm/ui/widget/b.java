package com.tencent.mm.ui.widget;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.glocom.b.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/IPullDownView;", "Lcom/tencent/mm/ui/component/glocom/IGloUIComponent;", "()V", "isOpen", "", "()Z", "setOpen", "(Z)V", "checkIsPullDownValid", "", "listener", "Lcom/tencent/mm/ui/widget/IPullDownView$CheckValidListener;", "getCurCycle", "", "isPauseMusic", "onJumpDetail", "onPostClose", "onPostOpen", "onPreClose", "onPreOpen", "onTransAnim", "percent", "", "CheckValidListener", "libmmui_release"})
public abstract class b
  implements com.tencent.mm.ui.component.glocom.b
{
  public boolean gZ;
  
  public final void a(MMFragmentActivity paramMMFragmentActivity)
  {
    p.k(paramMMFragmentActivity, "activity");
    b.a.a(this, paramMMFragmentActivity);
  }
  
  public final void b(MMFragmentActivity paramMMFragmentActivity)
  {
    p.k(paramMMFragmentActivity, "activity");
    b.a.b(this, paramMMFragmentActivity);
  }
  
  public abstract void dDB();
  
  public abstract void dDC();
  
  public boolean dDD()
  {
    return false;
  }
  
  public void dDE()
  {
    this.gZ = true;
  }
  
  public long ejq()
  {
    return 1L;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public void onBeforeFinish(Intent paramIntent) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    p.k(paramConfiguration, "newConfig");
    p.k(paramConfiguration, "newConfig");
    p.k(paramConfiguration, "newConfig");
  }
  
  public void onCreateAfter(Bundle paramBundle) {}
  
  public void onCreateBefore(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    p.k(paramKeyEvent, "event");
    p.k(paramKeyEvent, "event");
    p.k(paramKeyEvent, "event");
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    p.k(paramKeyEvent, "event");
    p.k(paramKeyEvent, "event");
    p.k(paramKeyEvent, "event");
    return false;
  }
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onPause() {}
  
  public void onPostClose()
  {
    this.gZ = false;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
  }
  
  public void onRestoreInstanceState(Bundle paramBundle) {}
  
  public void onResume() {}
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart() {}
  
  public void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */