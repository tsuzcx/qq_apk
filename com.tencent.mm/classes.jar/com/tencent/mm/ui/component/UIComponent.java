package com.tencent.mm.ui.component;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/component/SimpleUIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "isUserVisibleFocused", "", "()Z", "setUserVisibleFocused", "(Z)V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "getLayoutId", "", "isFragment", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onFinishing", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "libmmui_release"})
public abstract class UIComponent
  extends SimpleUIComponent
{
  private boolean KEZ;
  public View kFh;
  
  public UIComponent(Fragment paramFragment)
  {
    super(paramFragment);
  }
  
  public UIComponent(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public void ad(Bundle paramBundle) {}
  
  public void ae(Bundle paramBundle) {}
  
  public void cDm()
  {
    this.KEZ = true;
  }
  
  public void cNe()
  {
    this.KEZ = false;
  }
  
  public void cRf() {}
  
  public final boolean fLQ()
  {
    return this.fragment != null;
  }
  
  public final void gV(View paramView)
  {
    p.h(paramView, "<set-?>");
    this.kFh = paramView;
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public final View getRootView()
  {
    View localView = this.kFh;
    if (localView == null) {
      p.bdF("rootView");
    }
    return localView;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
  }
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.component.UIComponent
 * JD-Core Version:    0.7.0.1
 */