package com.tencent.mm.ui.component;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import androidx.annotation.a;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/component/SimpleUIComponent;", "Lcom/tencent/mm/ui/component/SimpleUIComponentJava;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "()V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "setActivity", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "getColor", "", "id", "getDimension", "", "getFindIdDelegateView", "Landroid/view/View;", "getString", "", "onCleared", "", "toString", "Companion", "plugin-uic_release"})
public class e
  extends f
{
  public static final a Xov;
  private Fragment fragment;
  public AppCompatActivity xGq;
  
  static
  {
    AppMethodBeat.i(231494);
    Xov = new a((byte)0);
    AppMethodBeat.o(231494);
  }
  
  private e() {}
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(231490);
    this.xGq = paramAppCompatActivity;
    AppMethodBeat.o(231490);
  }
  
  public e(Fragment paramFragment)
  {
    this((AppCompatActivity)localFragmentActivity);
    AppMethodBeat.i(231491);
    this.fragment = paramFragment;
    AppMethodBeat.o(231491);
  }
  
  public final AppCompatActivity getActivity()
  {
    AppMethodBeat.i(231472);
    AppCompatActivity localAppCompatActivity = this.xGq;
    if (localAppCompatActivity == null) {
      p.bGy("activity");
    }
    AppMethodBeat.o(231472);
    return localAppCompatActivity;
  }
  
  public final int getColor(@a int paramInt)
  {
    AppMethodBeat.i(231485);
    paramInt = getResources().getColor(paramInt);
    AppMethodBeat.o(231485);
    return paramInt;
  }
  
  public final float getDimension(int paramInt)
  {
    AppMethodBeat.i(231486);
    float f = getResources().getDimension(paramInt);
    AppMethodBeat.o(231486);
    return f;
  }
  
  protected View getFindIdDelegateView()
  {
    AppMethodBeat.i(231481);
    if (this.fragment != null)
    {
      localObject = this.fragment;
      if (localObject != null)
      {
        localObject = ((Fragment)localObject).getView();
        AppMethodBeat.o(231481);
        return localObject;
      }
      AppMethodBeat.o(231481);
      return null;
    }
    Object localObject = this.xGq;
    if (localObject == null) {
      p.bGy("activity");
    }
    localObject = ((AppCompatActivity)localObject).getWindow();
    p.j(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    AppMethodBeat.o(231481);
    return localObject;
  }
  
  public final Fragment getFragment()
  {
    return this.fragment;
  }
  
  public final Intent getIntent()
  {
    AppMethodBeat.i(231476);
    Object localObject = this.xGq;
    if (localObject == null) {
      p.bGy("activity");
    }
    localObject = ((AppCompatActivity)localObject).getIntent();
    p.j(localObject, "activity.intent");
    AppMethodBeat.o(231476);
    return localObject;
  }
  
  public final h getLifecycle()
  {
    AppMethodBeat.i(231475);
    Object localObject = this.fragment;
    if (localObject != null)
    {
      h localh = ((Fragment)localObject).getLifecycle();
      localObject = localh;
      if (localh != null) {}
    }
    else
    {
      localObject = this.xGq;
      if (localObject == null) {
        p.bGy("activity");
      }
      localObject = ((AppCompatActivity)localObject).getLifecycle();
      p.j(localObject, "activity.lifecycle");
    }
    AppMethodBeat.o(231475);
    return localObject;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(231478);
    Object localObject = this.xGq;
    if (localObject == null) {
      p.bGy("activity");
    }
    localObject = ((AppCompatActivity)localObject).getResources();
    p.j(localObject, "activity.resources");
    AppMethodBeat.o(231478);
    return localObject;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(231482);
    String str = getResources().getString(paramInt);
    p.j(str, "resources.getString(id)");
    AppMethodBeat.o(231482);
    return str;
  }
  
  public void onCleared()
  {
    AppMethodBeat.i(231488);
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
      localObject2 = this.xGq;
      if (localObject2 == null) {
        p.bGy("activity");
      }
      Log.i("SimpleUIComponent", localObject2.getClass().getName());
      AppMethodBeat.o(231488);
      return;
    }
  }
  
  public final void setActivity(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(231473);
    p.k(paramAppCompatActivity, "<set-?>");
    this.xGq = paramAppCompatActivity;
    AppMethodBeat.o(231473);
  }
  
  public final void setFragment(Fragment paramFragment)
  {
    this.fragment = paramFragment;
  }
  
  public String toString()
  {
    AppMethodBeat.i(231487);
    String str = getClass().getName() + '@' + hashCode();
    AppMethodBeat.o(231487);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/component/SimpleUIComponent$Companion;", "", "()V", "TAG", "", "plugin-uic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.e
 * JD-Core Version:    0.7.0.1
 */