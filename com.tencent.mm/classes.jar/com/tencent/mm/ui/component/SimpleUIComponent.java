package com.tencent.mm.ui.component;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/component/SimpleUIComponent;", "Landroid/arch/lifecycle/ViewModel;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "()V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "setActivity", "getFragment", "()Landroid/support/v4/app/Fragment;", "setFragment", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "getString", "", "id", "", "onCleared", "", "toString", "Companion", "libmmui_release"})
public class SimpleUIComponent
  extends ViewModel
{
  public static final a KiC;
  public MMActivity activity;
  public Fragment fragment;
  
  static
  {
    AppMethodBeat.i(186595);
    KiC = new a((byte)0);
    AppMethodBeat.o(186595);
  }
  
  private SimpleUIComponent() {}
  
  public SimpleUIComponent(Fragment paramFragment)
  {
    this((MMActivity)localFragmentActivity);
    AppMethodBeat.i(186594);
    this.fragment = paramFragment;
    AppMethodBeat.o(186594);
  }
  
  public SimpleUIComponent(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(186593);
    this.activity = paramMMActivity;
    AppMethodBeat.o(186593);
  }
  
  public final void af()
  {
    AppMethodBeat.i(186592);
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
        p.bcb("activity");
      }
      ad.i("SimpleUIComponent", localObject2.getClass().getSimpleName());
      AppMethodBeat.o(186592);
      return;
    }
  }
  
  public final MMActivity getActivity()
  {
    AppMethodBeat.i(186588);
    MMActivity localMMActivity = this.activity;
    if (localMMActivity == null) {
      p.bcb("activity");
    }
    AppMethodBeat.o(186588);
    return localMMActivity;
  }
  
  public final Intent getIntent()
  {
    AppMethodBeat.i(186589);
    Object localObject = this.activity;
    if (localObject == null) {
      p.bcb("activity");
    }
    localObject = ((MMActivity)localObject).getIntent();
    p.g(localObject, "activity.intent");
    AppMethodBeat.o(186589);
    return localObject;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(186590);
    Object localObject = this.activity;
    if (localObject == null) {
      p.bcb("activity");
    }
    localObject = ((MMActivity)localObject).getResources().getString(paramInt);
    p.g(localObject, "activity.resources.getString(id)");
    AppMethodBeat.o(186590);
    return localObject;
  }
  
  public String toString()
  {
    AppMethodBeat.i(186591);
    String str = getClass().getSimpleName() + '@' + hashCode();
    AppMethodBeat.o(186591);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/component/SimpleUIComponent$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.SimpleUIComponent
 * JD-Core Version:    0.7.0.1
 */