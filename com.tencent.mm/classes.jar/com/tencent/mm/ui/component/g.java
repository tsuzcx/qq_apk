package com.tencent.mm.ui.component;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.aa;
import androidx.lifecycle.ab;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.lifecycle.y.b;
import androidx.lifecycle.y.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/component/UICProvider;", "", "()V", "apiUicMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getApiUicMap", "()Ljava/util/HashMap;", "of", "Lcom/tencent/mm/ui/component/UICProvider$ViewModelProviderProxy;", "context", "Landroid/content/Context;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "owner", "Lcom/tencent/mm/ui/component/IModel;", "P", "Lcom/tencent/mm/kernel/plugin/IAlias;", "ownerClazz", "Ljava/lang/Class;", "ViewModelProviderProxy", "plugin-uic_release"})
public final class g
{
  private static final HashMap<Object, Object> Xow;
  public static final g Xox;
  
  static
  {
    AppMethodBeat.i(231648);
    Xox = new g();
    Xow = new HashMap();
    AppMethodBeat.o(231648);
  }
  
  public static a b(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(231642);
    p.k(paramAppCompatActivity, "activity");
    paramAppCompatActivity = new a((ab)paramAppCompatActivity, (y.b)new c(paramAppCompatActivity));
    AppMethodBeat.o(231642);
    return paramAppCompatActivity;
  }
  
  public static <P extends com.tencent.mm.kernel.b.a> a bD(Class<P> paramClass)
  {
    AppMethodBeat.i(231644);
    p.k(paramClass, "ownerClazz");
    paramClass = h.ag(paramClass);
    if (!(paramClass instanceof ab))
    {
      paramClass = (Throwable)new RuntimeException(paramClass + " cannot create ViewModelProvider failed.");
      AppMethodBeat.o(231644);
      throw paramClass;
    }
    paramClass = new a((ab)paramClass, (y.b)new d(paramClass));
    AppMethodBeat.o(231644);
    return paramClass;
  }
  
  public static a h(Fragment paramFragment)
  {
    AppMethodBeat.i(231637);
    p.k(paramFragment, "fragment");
    paramFragment = new a((ab)paramFragment, (y.b)new b(paramFragment));
    AppMethodBeat.o(231637);
    return paramFragment;
  }
  
  public static HashMap<Object, Object> hUc()
  {
    return Xow;
  }
  
  public static a lm(Context paramContext)
  {
    AppMethodBeat.i(231640);
    p.k(paramContext, "context");
    if (!(paramContext instanceof AppCompatActivity))
    {
      paramContext = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(231640);
      throw paramContext;
    }
    paramContext = b((AppCompatActivity)paramContext);
    AppMethodBeat.o(231640);
    return paramContext;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/component/UICProvider$ViewModelProviderProxy;", "Landroidx/lifecycle/ViewModelProvider;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/lifecycle/ViewModelProvider$Factory;)V", "field", "Ljava/lang/reflect/Field;", "getField", "()Ljava/lang/reflect/Field;", "getOwner", "()Landroidx/lifecycle/ViewModelStoreOwner;", "srcMap", "", "getSrcMap", "()Ljava/lang/Object;", "api", "T", "Lcom/tencent/mm/ui/component/ApiUIC;", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/ui/component/ApiUIC;", "getOrNull", "Landroidx/lifecycle/ViewModel;", "modelClass", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "importApi", "", "U", "Lcom/tencent/mm/ui/component/UIComponent;", "impl", "plugin-uic_release"})
  public static final class a
    extends y
  {
    public final Object Xoy;
    private final ab Xoz;
    private final Field bKF;
    
    public a(ab paramab, y.b paramb)
    {
      super(paramb);
      AppMethodBeat.i(231594);
      this.Xoz = paramab;
      paramab = aa.class.getDeclaredField("aaP");
      p.j(paramab, "it");
      paramab.setAccessible(true);
      p.j(paramab, "ViewModelStore::class.ja… it.isAccessible = true }");
      this.bKF = paramab;
      paramab = this.bKF.get(this.Xoz.getViewModelStore());
      if (paramab == null) {
        p.iCn();
      }
      this.Xoy = paramab;
      AppMethodBeat.o(231594);
    }
    
    public final <T extends a> T bE(Class<T> paramClass)
    {
      AppMethodBeat.i(231592);
      p.k(paramClass, "api");
      Object localObject = g.Xox;
      localObject = g.hUc().get(paramClass.getName());
      if (localObject == null)
      {
        paramClass = (Throwable)new RuntimeException(paramClass + " never import any instance.");
        AppMethodBeat.o(231592);
        throw paramClass;
      }
      p.j(localObject, "apiUicMap[api.name]\n    …er import any instance.\")");
      if (localObject == null)
      {
        paramClass = new t("null cannot be cast to non-null type java.lang.Class<androidx.lifecycle.ViewModel>");
        AppMethodBeat.o(231592);
        throw paramClass;
      }
      paramClass = i((Class)localObject);
      if (paramClass == null)
      {
        paramClass = new t("null cannot be cast to non-null type T");
        AppMethodBeat.o(231592);
        throw paramClass;
      }
      paramClass = (a)paramClass;
      AppMethodBeat.o(231592);
      return paramClass;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/component/UICProvider$of$1", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-uic_release"})
  public static final class b
    extends y.c
  {
    b(Fragment paramFragment) {}
    
    public final <T extends x> T create(Class<T> paramClass)
    {
      AppMethodBeat.i(231527);
      p.k(paramClass, "modelClass");
      if (e.class.isAssignableFrom(paramClass)) {
        try
        {
          x localx = (x)paramClass.getConstructor(new Class[] { Fragment.class }).newInstance(new Object[] { this.zQN });
          AppMethodBeat.o(231527);
          return localx;
        }
        catch (Throwable localThrowable)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localThrowable);
          AppMethodBeat.o(231527);
          throw paramClass;
        }
      }
      paramClass = super.create(paramClass);
      AppMethodBeat.o(231527);
      return paramClass;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/component/UICProvider$of$2", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-uic_release"})
  public static final class c
    extends y.c
  {
    c(AppCompatActivity paramAppCompatActivity) {}
    
    public final <T extends x> T create(Class<T> paramClass)
    {
      AppMethodBeat.i(231446);
      p.k(paramClass, "modelClass");
      if (e.class.isAssignableFrom(paramClass)) {
        try
        {
          x localx = (x)paramClass.getConstructor(new Class[] { AppCompatActivity.class }).newInstance(new Object[] { this.wYZ });
          AppMethodBeat.o(231446);
          return localx;
        }
        catch (Throwable localThrowable)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localThrowable);
          AppMethodBeat.o(231446);
          throw paramClass;
        }
      }
      paramClass = super.create(paramClass);
      AppMethodBeat.o(231446);
      return paramClass;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/component/UICProvider$of$3", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-uic_release"})
  public static final class d
    extends y.c
  {
    d(com.tencent.mm.kernel.b.a parama) {}
    
    public final <T extends x> T create(Class<T> paramClass)
    {
      AppMethodBeat.i(231566);
      p.k(paramClass, "modelClass");
      if (i.class.isAssignableFrom(paramClass))
      {
        try
        {
          Object localObject1 = paramClass.getConstructor(new Class[0]).newInstance(new Object[0]);
          localObject2 = (x)localObject1;
          if (localObject2 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentPlugin<P>");
            AppMethodBeat.o(231566);
            throw ((Throwable)localObject1);
          }
        }
        catch (Throwable localThrowable)
        {
          paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localThrowable);
          AppMethodBeat.o(231566);
          throw paramClass;
        }
        Object localObject2 = (i)localObject2;
        com.tencent.mm.kernel.b.a locala = this.XoA;
        p.k(locala, "<set-?>");
        ((i)localObject2).XoP = locala;
        x localx = (x)localThrowable;
        AppMethodBeat.o(231566);
        return localx;
      }
      paramClass = super.create(paramClass);
      AppMethodBeat.o(231566);
      return paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.component.g
 * JD-Core Version:    0.7.0.1
 */