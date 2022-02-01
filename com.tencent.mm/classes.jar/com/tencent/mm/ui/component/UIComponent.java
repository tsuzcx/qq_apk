package com.tencent.mm.ui.component;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/component/SimpleUIComponent;", "Lcom/tencent/mm/ui/component/IUIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "arguments", "Landroid/os/Bundle;", "context", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "context$delegate", "Lkotlin/Lazy;", "isUserVisibleFocused", "", "()Z", "setUserVisibleFocused", "(Z)V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "getArguments", "getLayoutId", "", "isBelongFragment", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "onCreateAfter", "onCreateBefore", "onDestroy", "onFinished", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onNewIntent", "intent", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "options", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "onWindowFocusChanged", "hasFocus", "setArguments", "libmmui_release"})
public abstract class UIComponent
  extends SimpleUIComponent
{
  private boolean PRP;
  private Bundle PRQ;
  public View lJI;
  private final f tMy = g.ah((a)new a(this));
  
  public UIComponent(Fragment paramFragment)
  {
    super(paramFragment);
  }
  
  public UIComponent(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public Bundle getArguments()
  {
    return this.PRQ;
  }
  
  public final Activity getContext()
  {
    return (Activity)this.tMy.getValue();
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public final View getRootView()
  {
    View localView = this.lJI;
    if (localView == null) {
      p.btv("rootView");
    }
    return localView;
  }
  
  public final boolean isBelongFragment()
  {
    return getFragment() != null;
  }
  
  public final boolean isUserVisibleFocused()
  {
    return this.PRP;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public void onBeforeFinish(Intent paramIntent) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    p.h(paramConfiguration, "newConfig");
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onCreateAfter(Bundle paramBundle) {}
  
  public void onCreateBefore(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public void onFinished() {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    p.h(paramKeyEvent, "event");
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    p.h(paramKeyEvent, "event");
    return false;
  }
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onPause() {}
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
  }
  
  public void onRestoreInstanceState(Bundle paramBundle) {}
  
  public void onResume() {}
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart() {}
  
  public void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public void onStop() {}
  
  public void onUserVisibleFocused()
  {
    this.PRP = true;
  }
  
  public void onUserVisibleUnFocused()
  {
    this.PRP = false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {}
  
  public void setArguments(Bundle paramBundle)
  {
    this.PRQ = paramBundle;
  }
  
  public final void setRootView(View paramView)
  {
    p.h(paramView, "<set-?>");
    this.lJI = paramView;
  }
  
  public final void setUserVisibleFocused(boolean paramBoolean)
  {
    this.PRP = paramBoolean;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/app/AppCompatActivity;", "invoke"})
  static final class a
    extends q
    implements a<AppCompatActivity>
  {
    a(UIComponent paramUIComponent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.component.UIComponent
 * JD-Core Version:    0.7.0.1
 */