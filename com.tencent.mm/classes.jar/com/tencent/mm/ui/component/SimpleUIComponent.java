package com.tencent.mm.ui.component;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/component/SimpleUIComponent;", "Landroid/arch/lifecycle/ViewModel;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "()V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "setActivity", "getFragment", "()Landroid/support/v4/app/Fragment;", "setFragment", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "getString", "", "id", "", "onCleared", "", "toString", "Companion", "libmmui_release"})
public class SimpleUIComponent
  extends ViewModel
{
  public static final SimpleUIComponent.a IrX;
  public MMActivity activity;
  public Fragment fragment;
  
  static
  {
    AppMethodBeat.i(197278);
    IrX = new SimpleUIComponent.a((byte)0);
    AppMethodBeat.o(197278);
  }
  
  private SimpleUIComponent() {}
  
  public SimpleUIComponent(Fragment paramFragment)
  {
    this((MMActivity)localFragmentActivity);
    AppMethodBeat.i(197277);
    this.fragment = paramFragment;
    AppMethodBeat.o(197277);
  }
  
  public SimpleUIComponent(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(197276);
    this.activity = paramMMActivity;
    AppMethodBeat.o(197276);
  }
  
  public final void ae()
  {
    AppMethodBeat.i(197275);
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
        k.aVY("activity");
      }
      ac.i("SimpleUIComponent", localObject2.getClass().getSimpleName());
      AppMethodBeat.o(197275);
      return;
    }
  }
  
  public final MMActivity getActivity()
  {
    AppMethodBeat.i(197271);
    MMActivity localMMActivity = this.activity;
    if (localMMActivity == null) {
      k.aVY("activity");
    }
    AppMethodBeat.o(197271);
    return localMMActivity;
  }
  
  public final Intent getIntent()
  {
    AppMethodBeat.i(197272);
    Object localObject = this.activity;
    if (localObject == null) {
      k.aVY("activity");
    }
    localObject = ((MMActivity)localObject).getIntent();
    k.g(localObject, "activity.intent");
    AppMethodBeat.o(197272);
    return localObject;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(197273);
    Object localObject = this.activity;
    if (localObject == null) {
      k.aVY("activity");
    }
    localObject = ((MMActivity)localObject).getResources().getString(paramInt);
    k.g(localObject, "activity.resources.getString(id)");
    AppMethodBeat.o(197273);
    return localObject;
  }
  
  public String toString()
  {
    AppMethodBeat.i(197274);
    String str = getClass().getSimpleName() + '@' + hashCode();
    AppMethodBeat.o(197274);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.component.SimpleUIComponent
 * JD-Core Version:    0.7.0.1
 */