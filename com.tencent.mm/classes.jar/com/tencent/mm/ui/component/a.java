package com.tencent.mm.ui.component;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.Factory;
import android.arch.lifecycle.ViewModelProvider.NewInstanceFactory;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.g;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/component/UICProvider;", "", "()V", "of", "Landroid/arch/lifecycle/ViewModelProvider;", "context", "Landroid/content/Context;", "fragment", "Landroid/support/v4/app/Fragment;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "P", "Lcom/tencent/mm/kernel/plugin/Plugin;", "ownerClazz", "Ljava/lang/Class;", "libmmui_release"})
public final class a
{
  public static final a PRN;
  
  static
  {
    AppMethodBeat.i(204834);
    PRN = new a();
    AppMethodBeat.o(204834);
  }
  
  public static ViewModelProvider b(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(204832);
    p.h(paramAppCompatActivity, "activity");
    paramAppCompatActivity = ViewModelProviders.of((FragmentActivity)paramAppCompatActivity, (ViewModelProvider.Factory)new b(paramAppCompatActivity));
    p.g(paramAppCompatActivity, "ViewModelProviders.of(ac…\n            }\n        })");
    AppMethodBeat.o(204832);
    return paramAppCompatActivity;
  }
  
  public static <P extends f> ViewModelProvider bi(Class<P> paramClass)
  {
    AppMethodBeat.i(204833);
    p.h(paramClass, "ownerClazz");
    paramClass = g.ah(paramClass);
    if (paramClass == null) {
      p.hyc();
    }
    paramClass = (f)paramClass;
    if (!(paramClass instanceof ViewModelStoreOwner))
    {
      paramClass = (Throwable)new RuntimeException(paramClass + " cannot create ViewModelProvider failed.");
      AppMethodBeat.o(204833);
      throw paramClass;
    }
    paramClass = new ViewModelProvider((ViewModelStoreOwner)paramClass, (ViewModelProvider.Factory)new c(paramClass));
    AppMethodBeat.o(204833);
    return paramClass;
  }
  
  public static ViewModelProvider ko(Context paramContext)
  {
    AppMethodBeat.i(204831);
    p.h(paramContext, "context");
    if (!(paramContext instanceof AppCompatActivity))
    {
      paramContext = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(204831);
      throw paramContext;
    }
    paramContext = b((AppCompatActivity)paramContext);
    AppMethodBeat.o(204831);
    return paramContext;
  }
  
  public static ViewModelProvider of(Fragment paramFragment)
  {
    AppMethodBeat.i(204830);
    p.h(paramFragment, "fragment");
    paramFragment = ViewModelProviders.of(paramFragment, (ViewModelProvider.Factory)new a(paramFragment));
    p.g(paramFragment, "ViewModelProviders.of(fr…\n            }\n        })");
    AppMethodBeat.o(204830);
    return paramFragment;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/ui/component/UICProvider$of$1", "Landroid/arch/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "libmmui_release"})
  public static final class a
    extends ViewModelProvider.NewInstanceFactory
  {
    a(Fragment paramFragment) {}
    
    public final <T extends ViewModel> T create(Class<T> paramClass)
    {
      AppMethodBeat.i(204827);
      p.h(paramClass, "modelClass");
      if (SimpleUIComponent.class.isAssignableFrom(paramClass)) {
        try
        {
          ViewModel localViewModel = (ViewModel)paramClass.getConstructor(new Class[] { Fragment.class }).newInstance(new Object[] { this.uRC });
          AppMethodBeat.o(204827);
          return localViewModel;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localNoSuchMethodException);
          AppMethodBeat.o(204827);
          throw paramClass;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localIllegalAccessException);
          AppMethodBeat.o(204827);
          throw paramClass;
        }
        catch (InstantiationException localInstantiationException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInstantiationException);
          AppMethodBeat.o(204827);
          throw paramClass;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInvocationTargetException);
          AppMethodBeat.o(204827);
          throw paramClass;
        }
      }
      paramClass = super.create(paramClass);
      AppMethodBeat.o(204827);
      return paramClass;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/ui/component/UICProvider$of$2", "Landroid/arch/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "libmmui_release"})
  public static final class b
    extends ViewModelProvider.NewInstanceFactory
  {
    b(AppCompatActivity paramAppCompatActivity) {}
    
    public final <T extends ViewModel> T create(Class<T> paramClass)
    {
      AppMethodBeat.i(204828);
      p.h(paramClass, "modelClass");
      if (SimpleUIComponent.class.isAssignableFrom(paramClass)) {
        try
        {
          ViewModel localViewModel = (ViewModel)paramClass.getConstructor(new Class[] { AppCompatActivity.class }).newInstance(new Object[] { this.uQi });
          AppMethodBeat.o(204828);
          return localViewModel;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localNoSuchMethodException);
          AppMethodBeat.o(204828);
          throw paramClass;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localIllegalAccessException);
          AppMethodBeat.o(204828);
          throw paramClass;
        }
        catch (InstantiationException localInstantiationException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInstantiationException);
          AppMethodBeat.o(204828);
          throw paramClass;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInvocationTargetException);
          AppMethodBeat.o(204828);
          throw paramClass;
        }
      }
      paramClass = super.create(paramClass);
      AppMethodBeat.o(204828);
      return paramClass;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/ui/component/UICProvider$of$3", "Landroid/arch/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "libmmui_release"})
  public static final class c
    extends ViewModelProvider.NewInstanceFactory
  {
    c(f paramf) {}
    
    public final <T extends ViewModel> T create(Class<T> paramClass)
    {
      AppMethodBeat.i(204829);
      p.h(paramClass, "modelClass");
      if (UIComponentPlugin.class.isAssignableFrom(paramClass)) {
        try
        {
          Object localObject1 = paramClass.getConstructor(new Class[0]).newInstance(new Object[0]);
          localObject2 = (ViewModel)localObject1;
          if (localObject2 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentPlugin<P>");
            AppMethodBeat.o(204829);
            throw ((Throwable)localObject1);
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localNoSuchMethodException);
          AppMethodBeat.o(204829);
          throw paramClass;
          Object localObject2 = (UIComponentPlugin)localObject2;
          f localf = this.PRO;
          p.h(localf, "<set-?>");
          ((UIComponentPlugin)localObject2).PSd = localf;
          ViewModel localViewModel = (ViewModel)localNoSuchMethodException;
          AppMethodBeat.o(204829);
          return localViewModel;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localIllegalAccessException);
          AppMethodBeat.o(204829);
          throw paramClass;
        }
        catch (InstantiationException localInstantiationException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInstantiationException);
          AppMethodBeat.o(204829);
          throw paramClass;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInvocationTargetException);
          AppMethodBeat.o(204829);
          throw paramClass;
        }
      }
      paramClass = super.create(paramClass);
      AppMethodBeat.o(204829);
      return paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.component.a
 * JD-Core Version:    0.7.0.1
 */