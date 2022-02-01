package com.tencent.mm.ui.component;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/component/SimpleUIComponent;", "Landroid/arch/lifecycle/ViewModel;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "()V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "setActivity", "getFragment", "()Landroid/support/v4/app/Fragment;", "setFragment", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "getString", "", "id", "", "onCleared", "", "toString", "Companion", "libmmui_release"})
public class SimpleUIComponent
  extends ViewModel
{
  public static final a LCW;
  public MMActivity activity;
  public Fragment fragment;
  
  static
  {
    AppMethodBeat.i(203949);
    LCW = new a((byte)0);
    AppMethodBeat.o(203949);
  }
  
  private SimpleUIComponent() {}
  
  public SimpleUIComponent(Fragment paramFragment)
  {
    this((MMActivity)localFragmentActivity);
    AppMethodBeat.i(203948);
    this.fragment = paramFragment;
    AppMethodBeat.o(203948);
  }
  
  public SimpleUIComponent(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(203947);
    this.activity = paramMMActivity;
    AppMethodBeat.o(203947);
  }
  
  public final void ae()
  {
    AppMethodBeat.i(203946);
    super.ae();
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
        k.aPZ("activity");
      }
      ad.i("SimpleUIComponent", localObject2.getClass().getSimpleName());
      AppMethodBeat.o(203946);
      return;
    }
  }
  
  public final MMActivity getActivity()
  {
    AppMethodBeat.i(203942);
    MMActivity localMMActivity = this.activity;
    if (localMMActivity == null) {
      k.aPZ("activity");
    }
    AppMethodBeat.o(203942);
    return localMMActivity;
  }
  
  public final Intent getIntent()
  {
    AppMethodBeat.i(203943);
    Object localObject = this.activity;
    if (localObject == null) {
      k.aPZ("activity");
    }
    localObject = ((MMActivity)localObject).getIntent();
    k.g(localObject, "activity.intent");
    AppMethodBeat.o(203943);
    return localObject;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(203944);
    Object localObject = this.activity;
    if (localObject == null) {
      k.aPZ("activity");
    }
    localObject = ((MMActivity)localObject).getResources().getString(paramInt);
    k.g(localObject, "activity.resources.getString(id)");
    AppMethodBeat.o(203944);
    return localObject;
  }
  
  public String toString()
  {
    AppMethodBeat.i(203945);
    String str = getClass().getSimpleName() + '@' + hashCode();
    AppMethodBeat.o(203945);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/component/SimpleUIComponent$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.component.SimpleUIComponent
 * JD-Core Version:    0.7.0.1
 */