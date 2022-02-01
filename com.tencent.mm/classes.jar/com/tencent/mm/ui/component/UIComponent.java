package com.tencent.mm.ui.component;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/component/SimpleUIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "isUserVisibleFocused", "", "()Z", "setUserVisibleFocused", "(Z)V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "getLayoutId", "", "isFragment", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onFinishing", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "libmmui_release"})
public abstract class UIComponent
  extends SimpleUIComponent
{
  private boolean LCZ;
  public View jGG;
  
  public UIComponent(Fragment paramFragment)
  {
    super(paramFragment);
  }
  
  public UIComponent(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public void ba(Bundle paramBundle) {}
  
  public void be(Bundle paramBundle) {}
  
  public void fTo()
  {
    this.LCZ = true;
  }
  
  public void fXn()
  {
    this.LCZ = false;
  }
  
  public void fXy() {}
  
  public final void gT(View paramView)
  {
    k.h(paramView, "<set-?>");
    this.jGG = paramView;
  }
  
  public final boolean gak()
  {
    return this.fragment != null;
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public final View getRootView()
  {
    View localView = this.jGG;
    if (localView == null) {
      k.aPZ("rootView");
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
    k.h(paramArrayOfString, "permissions");
    k.h(paramArrayOfInt, "grantResults");
  }
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.component.UIComponent
 * JD-Core Version:    0.7.0.1
 */