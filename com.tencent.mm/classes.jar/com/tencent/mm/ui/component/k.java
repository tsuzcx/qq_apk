package com.tencent.mm.ui.component;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.af;
import androidx.lifecycle.ah;
import androidx.lifecycle.ah.b;
import androidx.lifecycle.ah.d;
import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.h;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/UICProvider;", "", "()V", "apiInstanceMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getApiInstanceMap", "()Ljava/util/HashMap;", "apiUicMap", "getApiUicMap", "errorHandler", "Lcom/tencent/mm/ui/component/UICProvider$ErrorHandler;", "getErrorHandler", "()Lcom/tencent/mm/ui/component/UICProvider$ErrorHandler;", "setErrorHandler", "(Lcom/tencent/mm/ui/component/UICProvider$ErrorHandler;)V", "ownerStoreField", "Ljava/lang/reflect/Field;", "kotlin.jvm.PlatformType", "newInstance", "T", "Lcom/tencent/mm/ui/component/ApiInstance;", "t", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/ui/component/ApiInstance;", "of", "Lcom/tencent/mm/ui/component/UICProvider$ViewModelProviderProxy;", "context", "Landroid/content/Context;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "owner", "Lcom/tencent/mm/ui/component/IModel;", "P", "Lcom/tencent/mm/kernel/plugin/IAlias;", "ownerClazz", "ErrorHandler", "ViewModelProviderProxy", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k aeZF;
  private static final HashMap<Object, Object> aeZG;
  private static final HashMap<Object, Object> aeZH;
  private static k.a aeZI;
  private static final Field aeZJ;
  
  static
  {
    AppMethodBeat.i(250451);
    aeZF = new k();
    aeZG = new HashMap();
    aeZH = new HashMap();
    Field localField = aj.class.getDeclaredField("bIx");
    localField.setAccessible(true);
    aeZJ = localField;
    AppMethodBeat.o(250451);
  }
  
  public static void a(k.a parama)
  {
    aeZI = parama;
  }
  
  public static <P extends a> b cn(Class<P> paramClass)
  {
    AppMethodBeat.i(250435);
    s.u(paramClass, "ownerClazz");
    paramClass = h.az(paramClass);
    if (!(paramClass instanceof ak))
    {
      paramClass = new RuntimeException(paramClass + " cannot create ViewModelProvider failed.");
      AppMethodBeat.o(250435);
      throw paramClass;
    }
    paramClass = new b((ak)paramClass, (ah.b)new e(paramClass));
    AppMethodBeat.o(250435);
    return paramClass;
  }
  
  public static b d(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(250429);
    s.u(paramAppCompatActivity, "activity");
    paramAppCompatActivity = new b((ak)paramAppCompatActivity, (ah.b)new d(paramAppCompatActivity));
    AppMethodBeat.o(250429);
    return paramAppCompatActivity;
  }
  
  public static HashMap<Object, Object> jxL()
  {
    return aeZG;
  }
  
  public static HashMap<Object, Object> jxM()
  {
    return aeZH;
  }
  
  public static b nq(Context paramContext)
  {
    AppMethodBeat.i(250424);
    s.u(paramContext, "context");
    if (!(paramContext instanceof AppCompatActivity))
    {
      paramContext = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(250424);
      throw paramContext;
    }
    paramContext = d((AppCompatActivity)paramContext);
    AppMethodBeat.o(250424);
    return paramContext;
  }
  
  public static b y(Fragment paramFragment)
  {
    AppMethodBeat.i(250416);
    s.u(paramFragment, "fragment");
    paramFragment = new b((ak)paramFragment, (ah.b)new c(paramFragment));
    AppMethodBeat.o(250416);
    return paramFragment;
  }
  
  public final <T extends b> T co(Class<T> paramClass)
  {
    AppMethodBeat.i(250458);
    s.u(paramClass, "t");
    paramClass = aeZH.get(paramClass.getName());
    if ((paramClass instanceof Class)) {}
    for (paramClass = (Class)paramClass; paramClass == null; paramClass = null)
    {
      paramClass = (k)this;
      paramClass = new RuntimeException(paramClass + " never import any instance.");
      AppMethodBeat.o(250458);
      throw paramClass;
    }
    paramClass.isInterface();
    paramClass = paramClass.newInstance();
    s.s(paramClass, "clazz.newInstance()");
    paramClass = (b)paramClass;
    AppMethodBeat.o(250458);
    return paramClass;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/UICProvider$ViewModelProviderProxy;", "Landroidx/lifecycle/ViewModelProvider;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/lifecycle/ViewModelProvider$Factory;)V", "getOwner", "()Landroidx/lifecycle/ViewModelStoreOwner;", "srcMap", "", "api", "T", "Lcom/tencent/mm/ui/component/ApiUIC;", "apiClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/ui/component/ApiUIC;", "apiOrNull", "checkValid", "", "exportApi", "U", "Lcom/tencent/mm/ui/component/UIComponent;", "impl", "getOrNull", "Lcom/tencent/mm/ui/component/UICViewModel;", "uicClass", "(Ljava/lang/Class;)Lcom/tencent/mm/ui/component/UICViewModel;", "state", "S", "Lcom/tencent/mm/ui/component/UicState;", "Lcom/tencent/mm/ui/component/ApiUicWithState;", "(Ljava/lang/Class;)Lcom/tencent/mm/ui/component/UicState;", "stateOrNull", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends ah
  {
    private final ak aeZK;
    private final Object aeZL;
    
    public b(ak paramak, ah.b paramb)
    {
      super(paramb);
      AppMethodBeat.i(250299);
      this.aeZK = paramak;
      paramak = k.jxN().get(this.aeZK.getViewModelStore());
      s.checkNotNull(paramak);
      this.aeZL = paramak;
      AppMethodBeat.o(250299);
    }
    
    public final <T extends m> T cp(Class<T> paramClass)
    {
      AppMethodBeat.i(250305);
      s.u(paramClass, "uicClass");
      paramClass = (m)((Map)this.aeZL).get(s.X("androidx.lifecycle.ViewModelProvider.DefaultKey:", paramClass.getCanonicalName()));
      AppMethodBeat.o(250305);
      return paramClass;
    }
    
    public final <T extends c> T cq(Class<T> paramClass)
    {
      AppMethodBeat.i(250312);
      s.u(paramClass, "apiClass");
      Object localObject = k.aeZF;
      localObject = k.jxL().get(paramClass.getName());
      if (localObject == null)
      {
        paramClass = new RuntimeException(paramClass + " never import any instance.");
        AppMethodBeat.o(250312);
        throw paramClass;
      }
      paramClass = (c)q((Class)localObject);
      AppMethodBeat.o(250312);
      return paramClass;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/component/UICProvider$of$1", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends ah.d
  {
    c(Fragment paramFragment) {}
    
    public final <T extends af> T create(Class<T> paramClass)
    {
      Object localObject3 = null;
      AppMethodBeat.i(250294);
      s.u(paramClass, "modelClass");
      Object localObject1;
      if (i.class.isAssignableFrom(paramClass))
      {
        localObject1 = paramClass;
        if (localObject1 != null) {
          break label52;
        }
        localObject1 = localObject3;
      }
      label52:
      Object localObject2;
      for (;;)
      {
        if (localObject1 != null) {
          break label151;
        }
        paramClass = super.create(paramClass);
        AppMethodBeat.o(250294);
        return paramClass;
        localObject1 = null;
        break;
        localObject1 = this.FcW;
        try
        {
          localObject3 = Result.Companion;
          localObject1 = Result.constructor-impl((af)paramClass.getConstructor(new Class[] { Fragment.class }).newInstance(new Object[] { localObject1 }));
          localObject3 = Result.exceptionOrNull-impl(localObject1);
          if (localObject3 != null)
          {
            paramClass = new RuntimeException(s.X("Cannot create an instance of ", paramClass), (Throwable)localObject3);
            AppMethodBeat.o(250294);
            throw paramClass;
          }
        }
        finally
        {
          for (;;)
          {
            localObject3 = Result.Companion;
            localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable));
          }
          ResultKt.throwOnFailure(localObject2);
        }
      }
      label151:
      AppMethodBeat.o(250294);
      return localObject2;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/component/UICProvider$of$2", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends ah.d
  {
    d(AppCompatActivity paramAppCompatActivity) {}
    
    public final <T extends af> T create(Class<T> paramClass)
    {
      Object localObject3 = null;
      AppMethodBeat.i(250297);
      s.u(paramClass, "modelClass");
      Object localObject1;
      if (i.class.isAssignableFrom(paramClass))
      {
        localObject1 = paramClass;
        if (localObject1 != null) {
          break label52;
        }
        localObject1 = localObject3;
      }
      label52:
      Object localObject2;
      for (;;)
      {
        if (localObject1 != null) {
          break label151;
        }
        paramClass = super.create(paramClass);
        AppMethodBeat.o(250297);
        return paramClass;
        localObject1 = null;
        break;
        localObject1 = this.Awh;
        try
        {
          localObject3 = Result.Companion;
          localObject1 = Result.constructor-impl((af)paramClass.getConstructor(new Class[] { AppCompatActivity.class }).newInstance(new Object[] { localObject1 }));
          localObject3 = Result.exceptionOrNull-impl(localObject1);
          if (localObject3 != null)
          {
            paramClass = new RuntimeException(s.X("Cannot create an instance of ", paramClass), (Throwable)localObject3);
            AppMethodBeat.o(250297);
            throw paramClass;
          }
        }
        finally
        {
          for (;;)
          {
            localObject3 = Result.Companion;
            localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable));
          }
          ResultKt.throwOnFailure(localObject2);
        }
      }
      label151:
      AppMethodBeat.o(250297);
      return localObject2;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/component/UICProvider$of$3", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends ah.d
  {
    e(P paramP) {}
    
    public final <T extends af> T create(Class<T> paramClass)
    {
      Object localObject3 = null;
      AppMethodBeat.i(250293);
      s.u(paramClass, "modelClass");
      Object localObject1;
      if (n.class.isAssignableFrom(paramClass))
      {
        localObject1 = paramClass;
        if (localObject1 != null) {
          break label52;
        }
        localObject1 = localObject3;
      }
      label52:
      Object localObject2;
      for (;;)
      {
        if (localObject1 != null) {
          break label197;
        }
        paramClass = super.create(paramClass);
        AppMethodBeat.o(250293);
        return paramClass;
        localObject1 = null;
        break;
        localObject1 = this.aeZM;
        try
        {
          localObject3 = Result.Companion;
          localObject3 = paramClass.getConstructor(new Class[0]).newInstance(new Object[0]);
          localObject4 = (af)localObject3;
          if (localObject4 == null)
          {
            localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentPlugin<P of com.tencent.mm.ui.component.UICProvider.of.<no name provided>.create$lambda-4$lambda-2$lambda-1>");
            AppMethodBeat.o(250293);
            throw ((Throwable)localObject1);
          }
        }
        finally
        {
          Object localObject4;
          localObject3 = Result.Companion;
          for (localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable));; localObject2 = Result.constructor-impl((af)localObject3))
          {
            localObject3 = Result.exceptionOrNull-impl(localObject2);
            if (localObject3 == null) {
              break;
            }
            paramClass = new RuntimeException(s.X("Cannot create an instance of ", paramClass), (Throwable)localObject3);
            AppMethodBeat.o(250293);
            throw paramClass;
            localObject4 = (n)localObject4;
            s.s(localObject2, "owner");
            s.u(localObject2, "<set-?>");
            ((n)localObject4).aeZU = ((a)localObject2);
          }
          ResultKt.throwOnFailure(localObject2);
          localObject2 = (af)localObject2;
        }
      }
      label197:
      AppMethodBeat.o(250293);
      return localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.component.k
 * JD-Core Version:    0.7.0.1
 */