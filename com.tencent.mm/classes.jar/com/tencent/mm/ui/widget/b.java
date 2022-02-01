package com.tencent.mm.ui.widget;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.glocom.b.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/IPullDownView;", "Lcom/tencent/mm/ui/component/glocom/IGloUIComponent;", "()V", "isOpen", "", "()Z", "setOpen", "(Z)V", "beforeJumpDetail", "", "beforeJumpSource", "checkIsPullDownValid", "listener", "Lcom/tencent/mm/ui/widget/IPullDownView$CheckValidListener;", "getCurCycle", "", "isInterceptMusicHandle", "isPauseMusic", "onPostClose", "onPostOpen", "onPreClose", "onPreOpen", "onTransAnim", "percent", "", "CheckValidListener", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  implements com.tencent.mm.ui.component.glocom.b
{
  public boolean hU;
  
  public final void c(MMFragmentActivity paramMMFragmentActivity)
  {
    b.a.a(this, paramMMFragmentActivity);
  }
  
  public final void d(MMFragmentActivity paramMMFragmentActivity)
  {
    b.a.b(this, paramMMFragmentActivity);
  }
  
  public abstract void etL();
  
  public abstract void etM();
  
  public boolean etN()
  {
    return false;
  }
  
  public void etO()
  {
    this.hU = true;
  }
  
  public long flv()
  {
    return 1L;
  }
  
  public void gpi() {}
  
  public boolean gpj()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    b.a.c((com.tencent.mm.ui.component.glocom.b)this);
  }
  
  public boolean onBackPressed()
  {
    return b.a.d((com.tencent.mm.ui.component.glocom.b)this);
  }
  
  public void onBeforeFinish(Intent paramIntent)
  {
    b.a.e((com.tencent.mm.ui.component.glocom.b)this);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    b.a.a((com.tencent.mm.ui.component.glocom.b)this, paramConfiguration);
  }
  
  public void onCreateAfter(Bundle paramBundle)
  {
    b.a.f((com.tencent.mm.ui.component.glocom.b)this);
  }
  
  public void onCreateBefore(Bundle paramBundle)
  {
    b.a.g((com.tencent.mm.ui.component.glocom.b)this);
  }
  
  public void onDestroy()
  {
    b.a.h((com.tencent.mm.ui.component.glocom.b)this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return b.a.a((com.tencent.mm.ui.component.glocom.b)this, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return b.a.b((com.tencent.mm.ui.component.glocom.b)this, paramKeyEvent);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    b.a.i((com.tencent.mm.ui.component.glocom.b)this);
  }
  
  public void onPause()
  {
    b.a.j((com.tencent.mm.ui.component.glocom.b)this);
  }
  
  public void onPostClose()
  {
    this.hU = false;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    b.a.a((com.tencent.mm.ui.component.glocom.b)this, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    b.a.k((com.tencent.mm.ui.component.glocom.b)this);
  }
  
  public void onResume()
  {
    b.a.l((com.tencent.mm.ui.component.glocom.b)this);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    b.a.m((com.tencent.mm.ui.component.glocom.b)this);
  }
  
  public void onStart()
  {
    b.a.n((com.tencent.mm.ui.component.glocom.b)this);
  }
  
  public void onStop()
  {
    b.a.o((com.tencent.mm.ui.component.glocom.b)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */