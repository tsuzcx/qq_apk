package com.tencent.mm.plugin.mvvmbase.a;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmbase/coroutine/LifecycleScopeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "uicScope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "getUicScope", "()Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "uicScope$delegate", "Lkotlin/Lazy;", "plugin-mvvmbase_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
{
  private final j Mmy;
  private final String TAG;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(261022);
    this.TAG = "MicroMsg.Mvvm.LifecycleScopeUIC";
    this.Mmy = k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(261022);
  }
  
  public final LifecycleScope gsu()
  {
    AppMethodBeat.i(261029);
    LifecycleScope localLifecycleScope = (LifecycleScope)this.Mmy.getValue();
    AppMethodBeat.o(261029);
    return localLifecycleScope;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<LifecycleScope>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mvvmbase.a.a
 * JD-Core Version:    0.7.0.1
 */