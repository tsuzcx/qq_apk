package com.tencent.mm.plugin.repairer.ui.demo;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
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
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/Biz2UIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "dataUIC", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoDataUIC;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends UIComponent
{
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(278101);
    AppMethodBeat.o(278101);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(278117);
    s.u(paramb, "this$0");
    paramb.gNf().getStateCenter().dispatch((IStateAction)new q());
    AppMethodBeat.o(278117);
  }
  
  private static final void a(b paramb, o paramo)
  {
    AppMethodBeat.i(278124);
    s.u(paramb, "this$0");
    s.u(paramo, "state");
    paramo = ((BaseState)paramo).getAction();
    if ((paramo != null) && ((paramo instanceof r)))
    {
      paramo = paramb.findViewById(b.c.OtW);
      if (paramo != null) {
        paramo.setOnClickListener(new b..ExternalSyntheticLambda0(paramb));
      }
    }
    AppMethodBeat.o(278124);
  }
  
  private i gNf()
  {
    AppMethodBeat.i(278108);
    Object localObject = k.aeZF;
    localObject = k.d(getActivity()).q(i.class);
    s.s(localObject, "UICProvider.of(activity)…(DemoDataUIC::class.java)");
    localObject = (i)localObject;
    AppMethodBeat.o(278108);
    return localObject;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278147);
    super.onCreate(paramBundle);
    gNf().getStateCenter().process((androidx.lifecycle.q)getActivity(), (kotlin.g.a.b)a.OwI);
    gNf().getStateCenter().observe((androidx.lifecycle.q)getActivity(), new b..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(278147);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "state", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<o, ah>
  {
    public static final a OwI;
    
    static
    {
      AppMethodBeat.i(278395);
      OwI = new a();
      AppMethodBeat.o(278395);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.b
 * JD-Core Version:    0.7.0.1
 */