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
import d.g.b.k;
import d.l;
import d.v;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/component/UICProvider;", "", "()V", "of", "Landroid/arch/lifecycle/ViewModelProvider;", "fragment", "Landroid/support/v4/app/Fragment;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "P", "Lcom/tencent/mm/kernel/plugin/Plugin;", "ownerClazz", "Ljava/lang/Class;", "libmmui_release"})
public final class a
{
  public static final a IrY;
  
  static
  {
    AppMethodBeat.i(197285);
    IrY = new a();
    AppMethodBeat.o(197285);
  }
  
  public static <P extends f> ViewModelProvider bg(Class<P> paramClass)
  {
    AppMethodBeat.i(197284);
    k.h(paramClass, "ownerClazz");
    paramClass = g.ad(paramClass);
    if (paramClass == null) {
      k.fOy();
    }
    paramClass = (f)paramClass;
    if (!(paramClass instanceof ViewModelStoreOwner))
    {
      paramClass = (Throwable)new RuntimeException(paramClass + " cannot create ViewModelProvider failed.");
      AppMethodBeat.o(197284);
      throw paramClass;
    }
    paramClass = new ViewModelProvider((ViewModelStoreOwner)paramClass, (ViewModelProvider.Factory)new c(paramClass));
    AppMethodBeat.o(197284);
    return paramClass;
  }
  
  public static ViewModelProvider of(Fragment paramFragment)
  {
    AppMethodBeat.i(197282);
    k.h(paramFragment, "fragment");
    paramFragment = ViewModelProviders.of(paramFragment, (ViewModelProvider.Factory)new a(paramFragment));
    k.g(paramFragment, "ViewModelProviders.of(fr…\n            }\n        })");
    AppMethodBeat.o(197282);
    return paramFragment;
  }
  
  public static ViewModelProvider q(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(197283);
    k.h(paramMMActivity, "activity");
    paramMMActivity = ViewModelProviders.of((FragmentActivity)paramMMActivity, (ViewModelProvider.Factory)new b(paramMMActivity));
    k.g(paramMMActivity, "ViewModelProviders.of(ac…\n            }\n        })");
    AppMethodBeat.o(197283);
    return paramMMActivity;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/ui/component/UICProvider$of$1", "Landroid/arch/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "libmmui_release"})
  public static final class a
    extends ViewModelProvider.NewInstanceFactory
  {
    a(Fragment paramFragment) {}
    
    public final <T extends ViewModel> T create(Class<T> paramClass)
    {
      AppMethodBeat.i(197279);
      k.h(paramClass, "modelClass");
      if (SimpleUIComponent.class.isAssignableFrom(paramClass)) {
        try
        {
          ViewModel localViewModel = (ViewModel)paramClass.getConstructor(new Class[] { Fragment.class }).newInstance(new Object[] { this.sef });
          AppMethodBeat.o(197279);
          return localViewModel;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localNoSuchMethodException);
          AppMethodBeat.o(197279);
          throw paramClass;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localIllegalAccessException);
          AppMethodBeat.o(197279);
          throw paramClass;
        }
        catch (InstantiationException localInstantiationException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInstantiationException);
          AppMethodBeat.o(197279);
          throw paramClass;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInvocationTargetException);
          AppMethodBeat.o(197279);
          throw paramClass;
        }
      }
      paramClass = super.create(paramClass);
      AppMethodBeat.o(197279);
      return paramClass;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/ui/component/UICProvider$of$2", "Landroid/arch/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "libmmui_release"})
  public static final class b
    extends ViewModelProvider.NewInstanceFactory
  {
    b(MMActivity paramMMActivity) {}
    
    public final <T extends ViewModel> T create(Class<T> paramClass)
    {
      AppMethodBeat.i(197280);
      k.h(paramClass, "modelClass");
      if (SimpleUIComponent.class.isAssignableFrom(paramClass)) {
        try
        {
          ViewModel localViewModel = (ViewModel)paramClass.getConstructor(new Class[] { MMActivity.class }).newInstance(new Object[] { this.rte });
          AppMethodBeat.o(197280);
          return localViewModel;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localNoSuchMethodException);
          AppMethodBeat.o(197280);
          throw paramClass;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localIllegalAccessException);
          AppMethodBeat.o(197280);
          throw paramClass;
        }
        catch (InstantiationException localInstantiationException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInstantiationException);
          AppMethodBeat.o(197280);
          throw paramClass;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInvocationTargetException);
          AppMethodBeat.o(197280);
          throw paramClass;
        }
      }
      paramClass = super.create(paramClass);
      AppMethodBeat.o(197280);
      return paramClass;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/ui/component/UICProvider$of$3", "Landroid/arch/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "libmmui_release"})
  public static final class c
    extends ViewModelProvider.NewInstanceFactory
  {
    c(f paramf) {}
    
    public final <T extends ViewModel> T create(Class<T> paramClass)
    {
      AppMethodBeat.i(197281);
      k.h(paramClass, "modelClass");
      if (UIComponentPlugin.class.isAssignableFrom(paramClass)) {
        try
        {
          Object localObject1 = paramClass.getConstructor(new Class[0]).newInstance(new Object[0]);
          localObject2 = (ViewModel)localObject1;
          if (localObject2 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentPlugin<P>");
            AppMethodBeat.o(197281);
            throw ((Throwable)localObject1);
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localNoSuchMethodException);
          AppMethodBeat.o(197281);
          throw paramClass;
          Object localObject2 = (UIComponentPlugin)localObject2;
          f localf = this.IrZ;
          k.h(localf, "<set-?>");
          ((UIComponentPlugin)localObject2).Isi = localf;
          ViewModel localViewModel = (ViewModel)localNoSuchMethodException;
          AppMethodBeat.o(197281);
          return localViewModel;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localIllegalAccessException);
          AppMethodBeat.o(197281);
          throw paramClass;
        }
        catch (InstantiationException localInstantiationException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInstantiationException);
          AppMethodBeat.o(197281);
          throw paramClass;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInvocationTargetException);
          AppMethodBeat.o(197281);
          throw paramClass;
        }
      }
      paramClass = super.create(paramClass);
      AppMethodBeat.o(197281);
      return paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.component.a
 * JD-Core Version:    0.7.0.1
 */