package com.tencent.mm.plugin.mvvmbase;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.statecenter.BaseState;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.vas.VASActivity;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmbase/BaseMvvmActivity;", "Lcom/tencent/mm/ui/vas/VASActivity;", "()V", "getStateCenter", "Lcom/tencent/mm/sdk/statecenter/UIStateCenter;", "State", "Lcom/tencent/mm/sdk/statecenter/BaseState;", "getUICScope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "superImportUIComponents", "", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lkotlin/collections/HashSet;", "plugin-mvvmbase_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseMvvmActivity
  extends VASActivity
{
  public void _$_clearFindViewByIdCache() {}
  
  public final <State extends BaseState> UIStateCenter<State> getStateCenter()
  {
    Object localObject = ((Iterable)getUiComponents()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      UIComponent localUIComponent = (UIComponent)((Iterator)localObject).next();
      if ((localUIComponent instanceof com.tencent.mm.plugin.mvvmbase.c.a))
      {
        localObject = ((com.tencent.mm.plugin.mvvmbase.c.a)localUIComponent).MmB;
        if ((localObject instanceof UIStateCenter)) {
          return localObject;
        }
        return null;
      }
    }
    return null;
  }
  
  public final LifecycleScope getUICScope()
  {
    k localk = k.aeZF;
    return ((com.tencent.mm.plugin.mvvmbase.a.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mvvmbase.a.a.class)).gsu();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.mvvmbase.a.a.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mvvmbase.BaseMvvmActivity
 * JD-Core Version:    0.7.0.1
 */