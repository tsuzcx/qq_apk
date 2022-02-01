package com.tencent.mm.plugin.repairer.ui.demo;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.sdk.statecenter.BaseState;
import com.tencent.mm.sdk.statecenter.IStateAction;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/Biz1UIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "dataUIC", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoDataUIC;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
{
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(278096);
    AppMethodBeat.o(278096);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(278113);
    s.u(parama, "this$0");
    parama.gNf().getStateCenter().dispatch((IStateAction)new w());
    AppMethodBeat.o(278113);
  }
  
  private static final void a(a parama, o paramo)
  {
    AppMethodBeat.i(278122);
    s.u(parama, "this$0");
    s.u(paramo, "state");
    paramo = ((BaseState)paramo).getAction();
    if ((paramo != null) && ((paramo instanceof r)))
    {
      paramo = parama.findViewById(b.c.Ovf);
      if (paramo != null) {
        paramo.setOnClickListener(new a..ExternalSyntheticLambda0(parama));
      }
    }
    AppMethodBeat.o(278122);
  }
  
  private i gNf()
  {
    AppMethodBeat.i(278106);
    Object localObject = k.aeZF;
    localObject = k.d(getActivity()).q(i.class);
    s.s(localObject, "UICProvider.of(activity)…(DemoDataUIC::class.java)");
    localObject = (i)localObject;
    AppMethodBeat.o(278106);
    return localObject;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278145);
    super.onCreate(paramBundle);
    gNf().getStateCenter().process((q)getActivity(), (b)a.OwH);
    gNf().getStateCenter().observe((q)getActivity(), new a..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(278145);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "state", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<o, ah>
  {
    public static final a OwH;
    
    static
    {
      AppMethodBeat.i(278242);
      OwH = new a();
      AppMethodBeat.o(278242);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.a
 * JD-Core Version:    0.7.0.1
 */