package com.tencent.mm.ui.component;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/component/SimpleUIComponent;", "Landroid/arch/lifecycle/ViewModel;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "()V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "setActivity", "getFragment", "()Landroid/support/v4/app/Fragment;", "setFragment", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "getString", "", "id", "", "onCleared", "", "toString", "Companion", "libmmui_release"})
public class SimpleUIComponent
  extends ViewModel
{
  public static final a KEW;
  public MMActivity activity;
  public Fragment fragment;
  
  static
  {
    AppMethodBeat.i(193852);
    KEW = new a((byte)0);
    AppMethodBeat.o(193852);
  }
  
  private SimpleUIComponent() {}
  
  public SimpleUIComponent(Fragment paramFragment)
  {
    this((MMActivity)localFragmentActivity);
    AppMethodBeat.i(193851);
    this.fragment = paramFragment;
    AppMethodBeat.o(193851);
  }
  
  public SimpleUIComponent(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(193850);
    this.activity = paramMMActivity;
    AppMethodBeat.o(193850);
  }
  
  public final void af()
  {
    AppMethodBeat.i(193849);
    super.af();
    Object localObject2 = new StringBuilder("[onCleared] fragment=");
    Object localObject1 = this.fragment;
    if (localObject1 != null)
    {
      localObject1 = localObject1.getClass();
      if (localObject1 == null) {}
    }
    for (localObject1 = ((Class)localObject1).getSimpleName();; localObject1 = null)
    {
      localObject1 = ((StringBuilder)localObject2).append((String)localObject1).append(" activity=");
      localObject2 = this.activity;
      if (localObject2 == null) {
        p.bdF("activity");
      }
      ae.i("SimpleUIComponent", localObject2.getClass().getSimpleName());
      AppMethodBeat.o(193849);
      return;
    }
  }
  
  public final MMActivity getActivity()
  {
    AppMethodBeat.i(193846);
    MMActivity localMMActivity = this.activity;
    if (localMMActivity == null) {
      p.bdF("activity");
    }
    AppMethodBeat.o(193846);
    return localMMActivity;
  }
  
  public final Intent getIntent()
  {
    AppMethodBeat.i(193847);
    Object localObject = this.activity;
    if (localObject == null) {
      p.bdF("activity");
    }
    localObject = ((MMActivity)localObject).getIntent();
    p.g(localObject, "activity.intent");
    AppMethodBeat.o(193847);
    return localObject;
  }
  
  public String toString()
  {
    AppMethodBeat.i(193848);
    String str = getClass().getSimpleName() + '@' + hashCode();
    AppMethodBeat.o(193848);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/component/SimpleUIComponent$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.SimpleUIComponent
 * JD-Core Version:    0.7.0.1
 */