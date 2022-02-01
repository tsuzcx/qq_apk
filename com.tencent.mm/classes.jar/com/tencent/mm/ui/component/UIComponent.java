package com.tencent.mm.ui.component;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/component/SimpleUIComponent;", "Lcom/tencent/mm/ui/component/IUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "()V", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "setArguments", "(Landroid/os/Bundle;)V", "context", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "isUserVisibleFocused", "", "()Z", "setUserVisibleFocused", "(Z)V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "getLayoutId", "", "isBelongFragment", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "onCreateAfter", "onCreateBefore", "onDestroy", "onFinished", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onNewIntent", "intent", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "options", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "onViewCreated", "contentView", "onWindowFocusChanged", "hasFocus", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class UIComponent
  extends i
  implements g
{
  private Bundle arguments;
  private boolean isUserVisibleFocused;
  public View rootView;
  
  public UIComponent() {}
  
  public UIComponent(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public UIComponent(Fragment paramFragment)
  {
    super(paramFragment);
  }
  
  public final Bundle getArguments()
  {
    return this.arguments;
  }
  
  public final Activity getContext()
  {
    return (Activity)getActivity();
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public final View getRootView()
  {
    View localView = this.rootView;
    if (localView != null) {
      return localView;
    }
    s.bIx("rootView");
    return null;
  }
  
  public final boolean isBelongFragment()
  {
    return getFragment() != null;
  }
  
  public final boolean isUserVisibleFocused()
  {
    return this.isUserVisibleFocused;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public void onBeforeFinish(Intent paramIntent) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    s.u(paramConfiguration, "newConfig");
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onCreateAfter(Bundle paramBundle) {}
  
  public void onCreateBefore(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public void onFinished() {}
  
  public boolean onInterceptFinish()
  {
    s.u(this, "this");
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    s.u(paramKeyEvent, "event");
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    s.u(paramKeyEvent, "event");
    return false;
  }
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onPause() {}
  
  public void onPostDestroyed()
  {
    s.u(this, "this");
  }
  
  public void onPreDestroyed()
  {
    s.u(this, "this");
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
  }
  
  public void onRestoreInstanceState(Bundle paramBundle) {}
  
  public void onResume() {}
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart() {}
  
  public void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public void onStop() {}
  
  public void onUserVisibleFocused()
  {
    this.isUserVisibleFocused = true;
  }
  
  public void onUserVisibleUnFocused()
  {
    this.isUserVisibleFocused = false;
  }
  
  public void onViewCreated(View paramView)
  {
    s.u(paramView, "contentView");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {}
  
  public final void setArguments(Bundle paramBundle)
  {
    this.arguments = paramBundle;
  }
  
  public final void setRootView(View paramView)
  {
    s.u(paramView, "<set-?>");
    this.rootView = paramView;
  }
  
  public final void setUserVisibleFocused(boolean paramBoolean)
  {
    this.isUserVisibleFocused = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.component.UIComponent
 * JD-Core Version:    0.7.0.1
 */