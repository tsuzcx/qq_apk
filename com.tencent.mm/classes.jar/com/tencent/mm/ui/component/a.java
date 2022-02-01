package com.tencent.mm.ui.component;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.Factory;
import android.arch.lifecycle.ViewModelProvider.NewInstanceFactory;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/component/UICProvider;", "", "()V", "of", "Landroid/arch/lifecycle/ViewModelProvider;", "fragment", "Landroid/support/v4/app/Fragment;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "P", "Lcom/tencent/mm/kernel/plugin/Plugin;", "ownerClazz", "Ljava/lang/Class;", "libmmui_release"})
public final class a
{
  public static final a KEX;
  
  static
  {
    AppMethodBeat.i(193859);
    KEX = new a();
    AppMethodBeat.o(193859);
  }
  
  public static <P extends f> ViewModelProvider bi(Class<P> paramClass)
  {
    AppMethodBeat.i(193858);
    p.h(paramClass, "ownerClazz");
    paramClass = g.ad(paramClass);
    if (paramClass == null) {
      p.gkB();
    }
    paramClass = (f)paramClass;
    if (!(paramClass instanceof ViewModelStoreOwner))
    {
      paramClass = (Throwable)new RuntimeException(paramClass + " cannot create ViewModelProvider failed.");
      AppMethodBeat.o(193858);
      throw paramClass;
    }
    paramClass = new ViewModelProvider((ViewModelStoreOwner)paramClass, (ViewModelProvider.Factory)new c(paramClass));
    AppMethodBeat.o(193858);
    return paramClass;
  }
  
  public static ViewModelProvider of(Fragment paramFragment)
  {
    AppMethodBeat.i(193856);
    p.h(paramFragment, "fragment");
    paramFragment = ViewModelProviders.of(paramFragment, (ViewModelProvider.Factory)new a(paramFragment));
    p.g(paramFragment, "ViewModelProviders.of(fr…\n            }\n        })");
    AppMethodBeat.o(193856);
    return paramFragment;
  }
  
  public static ViewModelProvider s(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(193857);
    p.h(paramMMActivity, "activity");
    paramMMActivity = ViewModelProviders.of((FragmentActivity)paramMMActivity, (ViewModelProvider.Factory)new b(paramMMActivity));
    p.g(paramMMActivity, "ViewModelProviders.of(ac…\n            }\n        })");
    AppMethodBeat.o(193857);
    return paramMMActivity;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/ui/component/UICProvider$of$1", "Landroid/arch/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "libmmui_release"})
  public static final class a
    extends ViewModelProvider.NewInstanceFactory
  {
    a(Fragment paramFragment) {}
    
    public final <T extends ViewModel> T create(Class<T> paramClass)
    {
      AppMethodBeat.i(193853);
      p.h(paramClass, "modelClass");
      if (SimpleUIComponent.class.isAssignableFrom(paramClass)) {
        try
        {
          ViewModel localViewModel = (ViewModel)paramClass.getConstructor(new Class[] { Fragment.class }).newInstance(new Object[] { this.tmW });
          AppMethodBeat.o(193853);
          return localViewModel;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localNoSuchMethodException);
          AppMethodBeat.o(193853);
          throw paramClass;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localIllegalAccessException);
          AppMethodBeat.o(193853);
          throw paramClass;
        }
        catch (InstantiationException localInstantiationException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInstantiationException);
          AppMethodBeat.o(193853);
          throw paramClass;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInvocationTargetException);
          AppMethodBeat.o(193853);
          throw paramClass;
        }
      }
      paramClass = super.create(paramClass);
      AppMethodBeat.o(193853);
      return paramClass;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/ui/component/UICProvider$of$2", "Landroid/arch/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "libmmui_release"})
  public static final class b
    extends ViewModelProvider.NewInstanceFactory
  {
    b(MMActivity paramMMActivity) {}
    
    public final <T extends ViewModel> T create(Class<T> paramClass)
    {
      AppMethodBeat.i(193854);
      p.h(paramClass, "modelClass");
      if (SimpleUIComponent.class.isAssignableFrom(paramClass)) {
        try
        {
          ViewModel localViewModel = (ViewModel)paramClass.getConstructor(new Class[] { MMActivity.class }).newInstance(new Object[] { this.lTT });
          AppMethodBeat.o(193854);
          return localViewModel;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localNoSuchMethodException);
          AppMethodBeat.o(193854);
          throw paramClass;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localIllegalAccessException);
          AppMethodBeat.o(193854);
          throw paramClass;
        }
        catch (InstantiationException localInstantiationException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInstantiationException);
          AppMethodBeat.o(193854);
          throw paramClass;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInvocationTargetException);
          AppMethodBeat.o(193854);
          throw paramClass;
        }
      }
      paramClass = super.create(paramClass);
      AppMethodBeat.o(193854);
      return paramClass;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/ui/component/UICProvider$of$3", "Landroid/arch/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "libmmui_release"})
  public static final class c
    extends ViewModelProvider.NewInstanceFactory
  {
    c(f paramf) {}
    
    public final <T extends ViewModel> T create(Class<T> paramClass)
    {
      AppMethodBeat.i(193855);
      p.h(paramClass, "modelClass");
      if (UIComponentPlugin.class.isAssignableFrom(paramClass)) {
        try
        {
          Object localObject1 = paramClass.getConstructor(new Class[0]).newInstance(new Object[0]);
          localObject2 = (ViewModel)localObject1;
          if (localObject2 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentPlugin<P>");
            AppMethodBeat.o(193855);
            throw ((Throwable)localObject1);
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localNoSuchMethodException);
          AppMethodBeat.o(193855);
          throw paramClass;
          Object localObject2 = (UIComponentPlugin)localObject2;
          f localf = this.KEY;
          p.h(localf, "<set-?>");
          ((UIComponentPlugin)localObject2).KFh = localf;
          ViewModel localViewModel = (ViewModel)localNoSuchMethodException;
          AppMethodBeat.o(193855);
          return localViewModel;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localIllegalAccessException);
          AppMethodBeat.o(193855);
          throw paramClass;
        }
        catch (InstantiationException localInstantiationException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInstantiationException);
          AppMethodBeat.o(193855);
          throw paramClass;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInvocationTargetException);
          AppMethodBeat.o(193855);
          throw paramClass;
        }
      }
      paramClass = super.create(paramClass);
      AppMethodBeat.o(193855);
      return paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.a
 * JD-Core Version:    0.7.0.1
 */