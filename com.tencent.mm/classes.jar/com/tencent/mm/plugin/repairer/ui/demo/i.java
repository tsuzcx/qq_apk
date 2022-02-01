package com.tencent.mm.plugin.repairer.ui.demo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.statecenter.IStateAction;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/DemoDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initState", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoState;", "getInitState", "()Lcom/tencent/mm/plugin/repairer/ui/demo/DemoState;", "initState$delegate", "Lkotlin/Lazy;", "stateCenter", "Lcom/tencent/mm/sdk/statecenter/UIStateCenter;", "getStateCenter", "()Lcom/tencent/mm/sdk/statecenter/UIStateCenter;", "stateCenter$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends UIComponent
{
  private final j Mdr;
  final j OwL;
  
  public i(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(278076);
    this.OwL = k.cm((a)a.OwM);
    this.Mdr = k.cm((a)new b(this, paramAppCompatActivity));
    AppMethodBeat.o(278076);
  }
  
  public final UIStateCenter<o> getStateCenter()
  {
    AppMethodBeat.i(278092);
    UIStateCenter localUIStateCenter = (UIStateCenter)this.Mdr.getValue();
    AppMethodBeat.o(278092);
    return localUIStateCenter;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278086);
    super.onCreate(paramBundle);
    getStateCenter().dispatch((IStateAction)new r());
    AppMethodBeat.o(278086);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<o>
  {
    public static final a OwM;
    
    static
    {
      AppMethodBeat.i(278121);
      OwM = new a();
      AppMethodBeat.o(278121);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/statecenter/UIStateCenter;", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<UIStateCenter<o>>
  {
    b(i parami, AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.i
 * JD-Core Version:    0.7.0.1
 */