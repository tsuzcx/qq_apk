package com.tencent.mm.ui.component;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/SimpleUIComponent;", "Lcom/tencent/mm/ui/component/SimpleUIComponentJava;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "()V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "setActivity", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "getColor", "", "id", "theme", "Landroid/content/res/Resources$Theme;", "getDimension", "", "getFindViewIdRootView", "Landroid/view/View;", "getString", "", "onCleared", "", "toString", "Companion", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class i
  extends j
{
  public static final a Companion = new a((byte)0);
  public static final String TAG = "SimpleUIComponent";
  public AppCompatActivity activity;
  private Fragment fragment;
  
  public i() {}
  
  public i(AppCompatActivity paramAppCompatActivity)
  {
    setActivity(paramAppCompatActivity);
  }
  
  public i(Fragment paramFragment)
  {
    this((AppCompatActivity)localFragmentActivity);
    this.fragment = paramFragment;
  }
  
  public final AppCompatActivity getActivity()
  {
    AppCompatActivity localAppCompatActivity = this.activity;
    if (localAppCompatActivity != null) {
      return localAppCompatActivity;
    }
    s.bIx("activity");
    return null;
  }
  
  public final int getColor(int paramInt)
  {
    return getResources().getColor(paramInt);
  }
  
  public final int getColor(int paramInt, Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return getResources().getColor(paramInt, paramTheme);
    }
    return getColor(paramInt);
  }
  
  public final float getDimension(int paramInt)
  {
    return getResources().getDimension(paramInt);
  }
  
  protected View getFindViewIdRootView()
  {
    if (this.fragment != null)
    {
      Fragment localFragment = this.fragment;
      if (localFragment == null) {
        return null;
      }
      return localFragment.getView();
    }
    return getActivity().getWindow().getDecorView();
  }
  
  public final Fragment getFragment()
  {
    return this.fragment;
  }
  
  public final Intent getIntent()
  {
    Intent localIntent = getActivity().getIntent();
    s.s(localIntent, "activity.intent");
    return localIntent;
  }
  
  public final androidx.lifecycle.j getLifecycle()
  {
    Object localObject1 = this.fragment;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((Fragment)localObject1).getLifecycle())
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = getActivity().getLifecycle();
        s.s(localObject2, "activity.lifecycle");
      }
      return localObject2;
    }
  }
  
  public final Resources getResources()
  {
    Resources localResources = getActivity().getResources();
    s.s(localResources, "activity.resources");
    return localResources;
  }
  
  public final String getString(int paramInt)
  {
    String str = getResources().getString(paramInt);
    s.s(str, "resources.getString(id)");
    return str;
  }
  
  public void onCleared()
  {
    Object localObject1 = null;
    super.onCleared();
    StringBuilder localStringBuilder = new StringBuilder("[onCleared] fragment=");
    Object localObject2 = this.fragment;
    if (localObject2 == null) {}
    for (;;)
    {
      Log.i("SimpleUIComponent", localObject1 + " activity=" + getActivity().getClass().getName());
      return;
      localObject2 = localObject2.getClass();
      if (localObject2 != null) {
        localObject1 = ((Class)localObject2).getName();
      }
    }
  }
  
  public final void setActivity(AppCompatActivity paramAppCompatActivity)
  {
    s.u(paramAppCompatActivity, "<set-?>");
    this.activity = paramAppCompatActivity;
  }
  
  public final void setFragment(Fragment paramFragment)
  {
    this.fragment = paramFragment;
  }
  
  public String toString()
  {
    return getClass().getName() + '@' + hashCode();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/SimpleUIComponent$Companion;", "", "()V", "TAG", "", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.i
 * JD-Core Version:    0.7.0.1
 */