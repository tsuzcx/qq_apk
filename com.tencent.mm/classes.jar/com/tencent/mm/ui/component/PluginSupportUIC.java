package com.tencent.mm.ui.component;

import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.a.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/PluginSupportUIC;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "viewModelStore", "Lcom/tencent/mm/ui/component/UicViewModelStore;", "attachUicApiRegister", "Lcom/tencent/mm/ui/component/annotation/UicApiRegister;", "getViewModelStore", "Landroidx/lifecycle/ViewModelStore;", "installed", "", "onAccountRelease", "Companion", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class PluginSupportUIC
  extends f
  implements ak, c
{
  public static final a aeZD = new a((byte)0);
  private final q aeZE = new q(true);
  
  public a attachUicApiRegister()
  {
    Object localObject = s.X("com.tencent.mm.ui.component.UicApiExporterFor", getClass().getSimpleName());
    Log.i("PluginSupportUIC", s.X("[attachUicApiRegister] name=", localObject));
    localObject = Class.forName((String)localObject).newInstance();
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.component.annotation.UicApiRegister");
    }
    return (a)localObject;
  }
  
  public aj getViewModelStore()
  {
    return (aj)this.aeZE;
  }
  
  public void installed()
  {
    super.installed();
    try
    {
      Object localObject1 = Result.Companion;
      attachUicApiRegister().aoW();
      localObject1 = Result.constructor-impl(ah.aiuX);
      localObject1 = Result.exceptionOrNull-impl(localObject1);
      if (localObject1 != null) {
        Log.printErrStackTrace("PluginSupportUIC", (Throwable)localObject1, "", new Object[0]);
      }
      return;
    }
    finally
    {
      for (;;)
      {
        Result.Companion localCompanion = Result.Companion;
        Object localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable));
      }
    }
  }
  
  public void onAccountRelease()
  {
    this.aeZE.clear();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/PluginSupportUIC$Companion;", "", "()V", "GENERATE_FILE_NAME_PREFIX", "", "GENERATE_PACKAGE", "TAG", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.component.PluginSupportUIC
 * JD-Core Version:    0.7.0.1
 */