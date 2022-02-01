package com.tencent.mm.ui.component;

import android.arch.lifecycle.Lifecycle;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.a;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/component/SimpleUIComponent;", "Lcom/tencent/mm/ui/component/SimpleUIComponentJava;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "()V", "getActivity", "()Landroid/support/v7/app/AppCompatActivity;", "setActivity", "getFragment", "()Landroid/support/v4/app/Fragment;", "setFragment", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "lifecycle", "Landroid/arch/lifecycle/Lifecycle;", "getLifecycle", "()Landroid/arch/lifecycle/Lifecycle;", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "getColor", "", "id", "getDimension", "", "getFindIdDelegateView", "Landroid/view/View;", "getString", "", "onCleared", "", "toString", "Companion", "libmmui_release"})
public class SimpleUIComponent
  extends SimpleUIComponentJava
{
  public static final a PRM;
  private Fragment fragment;
  public AppCompatActivity tUQ;
  
  static
  {
    AppMethodBeat.i(204826);
    PRM = new a((byte)0);
    AppMethodBeat.o(204826);
  }
  
  private SimpleUIComponent() {}
  
  public SimpleUIComponent(Fragment paramFragment)
  {
    this((AppCompatActivity)localFragmentActivity);
    AppMethodBeat.i(204825);
    this.fragment = paramFragment;
    AppMethodBeat.o(204825);
  }
  
  public SimpleUIComponent(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(204824);
    this.tUQ = paramAppCompatActivity;
    AppMethodBeat.o(204824);
  }
  
  public final AppCompatActivity getActivity()
  {
    AppMethodBeat.i(204813);
    AppCompatActivity localAppCompatActivity = this.tUQ;
    if (localAppCompatActivity == null) {
      p.btv("activity");
    }
    AppMethodBeat.o(204813);
    return localAppCompatActivity;
  }
  
  public final int getColor(@a int paramInt)
  {
    AppMethodBeat.i(204820);
    paramInt = getResources().getColor(paramInt);
    AppMethodBeat.o(204820);
    return paramInt;
  }
  
  public final float getDimension(int paramInt)
  {
    AppMethodBeat.i(204821);
    float f = getResources().getDimension(paramInt);
    AppMethodBeat.o(204821);
    return f;
  }
  
  protected View getFindIdDelegateView()
  {
    AppMethodBeat.i(204818);
    if (this.fragment != null)
    {
      localObject = this.fragment;
      if (localObject != null)
      {
        localObject = ((Fragment)localObject).getView();
        AppMethodBeat.o(204818);
        return localObject;
      }
      AppMethodBeat.o(204818);
      return null;
    }
    Object localObject = this.tUQ;
    if (localObject == null) {
      p.btv("activity");
    }
    localObject = ((AppCompatActivity)localObject).getWindow();
    p.g(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    AppMethodBeat.o(204818);
    return localObject;
  }
  
  public final Fragment getFragment()
  {
    return this.fragment;
  }
  
  public final Intent getIntent()
  {
    AppMethodBeat.i(204816);
    Object localObject = this.tUQ;
    if (localObject == null) {
      p.btv("activity");
    }
    localObject = ((AppCompatActivity)localObject).getIntent();
    p.g(localObject, "activity.intent");
    AppMethodBeat.o(204816);
    return localObject;
  }
  
  public final Lifecycle getLifecycle()
  {
    AppMethodBeat.i(204815);
    Object localObject = this.fragment;
    if (localObject != null)
    {
      Lifecycle localLifecycle = ((Fragment)localObject).getLifecycle();
      localObject = localLifecycle;
      if (localLifecycle != null) {}
    }
    else
    {
      localObject = this.tUQ;
      if (localObject == null) {
        p.btv("activity");
      }
      localObject = ((AppCompatActivity)localObject).getLifecycle();
      p.g(localObject, "activity.lifecycle");
    }
    AppMethodBeat.o(204815);
    return localObject;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(204817);
    Object localObject = this.tUQ;
    if (localObject == null) {
      p.btv("activity");
    }
    localObject = ((AppCompatActivity)localObject).getResources();
    p.g(localObject, "activity.resources");
    AppMethodBeat.o(204817);
    return localObject;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(204819);
    String str = getResources().getString(paramInt);
    p.g(str, "resources.getString(id)");
    AppMethodBeat.o(204819);
    return str;
  }
  
  public void onCleared()
  {
    AppMethodBeat.i(204823);
    super.onCleared();
    Object localObject2 = new StringBuilder("[onCleared] fragment=");
    Object localObject1 = this.fragment;
    if (localObject1 != null)
    {
      localObject1 = localObject1.getClass();
      if (localObject1 == null) {}
    }
    for (localObject1 = ((Class)localObject1).getName();; localObject1 = null)
    {
      localObject1 = ((StringBuilder)localObject2).append((String)localObject1).append(" activity=");
      localObject2 = this.tUQ;
      if (localObject2 == null) {
        p.btv("activity");
      }
      Log.i("SimpleUIComponent", localObject2.getClass().getName());
      AppMethodBeat.o(204823);
      return;
    }
  }
  
  public final void setActivity(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(204814);
    p.h(paramAppCompatActivity, "<set-?>");
    this.tUQ = paramAppCompatActivity;
    AppMethodBeat.o(204814);
  }
  
  public final void setFragment(Fragment paramFragment)
  {
    this.fragment = paramFragment;
  }
  
  public String toString()
  {
    AppMethodBeat.i(204822);
    String str = getClass().getName() + '@' + hashCode();
    AppMethodBeat.o(204822);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/component/SimpleUIComponent$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.component.SimpleUIComponent
 * JD-Core Version:    0.7.0.1
 */