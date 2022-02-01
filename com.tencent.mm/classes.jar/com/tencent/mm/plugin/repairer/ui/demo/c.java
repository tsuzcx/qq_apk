package com.tencent.mm.plugin.repairer.ui.demo;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.sdk.statecenter.BaseState;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/Biz3UIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "dataUIC", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoDataUIC;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends UIComponent
{
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(278109);
    AppMethodBeat.o(278109);
  }
  
  private static final void a(c paramc, o paramo)
  {
    AppMethodBeat.i(278128);
    s.u(paramc, "this$0");
    s.u(paramo, "state");
    Object localObject = ((BaseState)paramo).getAction();
    if ((localObject != null) && ((localObject instanceof w)))
    {
      TextView localTextView = (TextView)paramc.findViewById(b.c.status_tv);
      if (localTextView != null)
      {
        if (!paramo.vDm) {
          break label127;
        }
        localObject = (CharSequence)"正在搜索";
        localTextView.setText((CharSequence)localObject);
      }
    }
    localObject = ((BaseState)paramo).getAction();
    if ((localObject != null) && ((localObject instanceof q)))
    {
      localObject = (TextView)paramc.findViewById(b.c.status_tv);
      if (localObject != null) {
        if (!paramo.vDm) {
          break label136;
        }
      }
    }
    label136:
    for (paramc = (CharSequence)"正在搜索";; paramc = (CharSequence)"没有搜索")
    {
      ((TextView)localObject).setText(paramc);
      AppMethodBeat.o(278128);
      return;
      label127:
      localObject = (CharSequence)"没有搜索";
      break;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278159);
    super.onCreate(paramBundle);
    paramBundle = k.aeZF;
    paramBundle = k.d(getActivity()).q(i.class);
    s.s(paramBundle, "UICProvider.of(activity)…(DemoDataUIC::class.java)");
    ((i)paramBundle).getStateCenter().observe((androidx.lifecycle.q)getActivity(), new c..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(278159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.c
 * JD-Core Version:    0.7.0.1
 */