package com.tencent.mm.ui.component;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/component/SimpleUIComponent;", "Lcom/tencent/mm/ui/component/IUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "arguments", "Landroid/os/Bundle;", "context", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "context$delegate", "Lkotlin/Lazy;", "isUserVisibleFocused", "", "()Z", "setUserVisibleFocused", "(Z)V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "getArguments", "getLayoutId", "", "isBelongFragment", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "onCreateAfter", "onCreateBefore", "onDestroy", "onFinished", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onNewIntent", "intent", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "options", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "onWindowFocusChanged", "hasFocus", "setArguments", "plugin-uic_release"})
public abstract class UIComponent
  extends e
  implements d
{
  private boolean XoB;
  private Bundle XoC;
  public View oFW;
  private final f xwp = g.ar((a)new UIComponent.a(this));
  
  public UIComponent(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public UIComponent(Fragment paramFragment)
  {
    super(paramFragment);
  }
  
  public Bundle getArguments()
  {
    return this.XoC;
  }
  
  public final Activity getContext()
  {
    return (Activity)this.xwp.getValue();
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public final View getRootView()
  {
    View localView = this.oFW;
    if (localView == null) {
      p.bGy("rootView");
    }
    return localView;
  }
  
  public final boolean isBelongFragment()
  {
    return getFragment() != null;
  }
  
  public final boolean isUserVisibleFocused()
  {
    return this.XoB;
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
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onCreateAfter(Bundle paramBundle) {}
  
  public void onCreateBefore(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public void onFinished() {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    p.k(paramKeyEvent, "event");
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    p.k(paramKeyEvent, "event");
    return false;
  }
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onPause() {}
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
  }
  
  public void onRestoreInstanceState(Bundle paramBundle) {}
  
  public void onResume() {}
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart() {}
  
  public void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public void onStop() {}
  
  public void onUserVisibleFocused()
  {
    this.XoB = true;
  }
  
  public void onUserVisibleUnFocused()
  {
    this.XoB = false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {}
  
  public void setArguments(Bundle paramBundle)
  {
    this.XoC = paramBundle;
  }
  
  public final void setRootView(View paramView)
  {
    p.k(paramView, "<set-?>");
    this.oFW = paramView;
  }
  
  public final void setUserVisibleFocused(boolean paramBoolean)
  {
    this.XoB = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.UIComponent
 * JD-Core Version:    0.7.0.1
 */