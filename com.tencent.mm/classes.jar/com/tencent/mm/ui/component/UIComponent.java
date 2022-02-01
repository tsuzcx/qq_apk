package com.tencent.mm.ui.component;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/component/SimpleUIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "isUserVisibleFocused", "", "()Z", "setUserVisibleFocused", "(Z)V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "getLayoutId", "", "isFragment", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onFinishing", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "libmmui_release"})
public abstract class UIComponent
  extends SimpleUIComponent
{
  private boolean Isa;
  public View khe;
  
  public UIComponent(Fragment paramFragment)
  {
    super(paramFragment);
  }
  
  public UIComponent(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public void Z(Bundle paramBundle) {}
  
  public void aa(Bundle paramBundle) {}
  
  public void cFW()
  {
    this.Isa = false;
  }
  
  public void cGh() {}
  
  public void cvj()
  {
    this.Isa = true;
  }
  
  public final boolean fqL()
  {
    return this.fragment != null;
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public final View getRootView()
  {
    View localView = this.khe;
    if (localView == null) {
      k.aVY("rootView");
    }
    return localView;
  }
  
  public final void gz(View paramView)
  {
    k.h(paramView, "<set-?>");
    this.khe = paramView;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.component.UIComponent
 * JD-Core Version:    0.7.0.1
 */