package com.tencent.mm.plugin.mvvmbase.b;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ScrollView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmbase.b.a;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmbase/ui/KeyboardInputChangeUIC;", "Lcom/tencent/mm/plugin/mvvmbase/BaseMvvmUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "isKeyboardShow", "", "scrollView", "Landroid/widget/ScrollView;", "kotlin.jvm.PlatformType", "getScrollView", "()Landroid/widget/ScrollView;", "scrollView$delegate", "Lkotlin/Lazy;", "fitKeyboard", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFocusChange", "focus", "plugin-mvvmbase_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.mvvmbase.a
{
  private final j ETc;
  private boolean HDO;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(261027);
    this.ETc = k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(261027);
  }
  
  private static final void a(a parama, int paramInt)
  {
    AppMethodBeat.i(261041);
    s.u(parama, "this$0");
    parama = parama.ewP();
    if (parama != null) {
      parama.smoothScrollBy(0, paramInt);
    }
    AppMethodBeat.o(261041);
  }
  
  private static final void a(a parama, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(261036);
    s.u(parama, "this$0");
    parama.HDO = paramBoolean;
    if (paramBoolean) {
      parama.gsv();
    }
    AppMethodBeat.o(261036);
  }
  
  private final ScrollView ewP()
  {
    AppMethodBeat.i(261028);
    ScrollView localScrollView = (ScrollView)this.ETc.getValue();
    AppMethodBeat.o(261028);
    return localScrollView;
  }
  
  private final void gsv()
  {
    AppMethodBeat.i(261031);
    int i = com.tencent.mm.cd.a.fromDPToPix((Context)getActivity(), 64);
    Object localObject = getActivity().getWindow().getCurrentFocus();
    if (localObject != null)
    {
      int[] arrayOfInt = new int[2];
      ((View)localObject).getLocationInWindow(arrayOfInt);
      i = arrayOfInt[1] - i;
      if (i > 0)
      {
        localObject = ewP();
        if (localObject != null) {
          ((ScrollView)localObject).post(new a..ExternalSyntheticLambda1(this, i));
        }
      }
    }
    AppMethodBeat.o(261031);
  }
  
  public final void Aa(boolean paramBoolean)
  {
    AppMethodBeat.i(261058);
    if ((paramBoolean) && (this.HDO)) {
      gsv();
    }
    AppMethodBeat.o(261058);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(261052);
    super.onCreate(paramBundle);
    paramBundle = (InputPanelLinearLayout)findViewById(b.a.keyboard_change_input_panel);
    if (paramBundle != null) {
      paramBundle.setExternalListener(new a..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(261052);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ScrollView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ScrollView>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.mvvmbase.b.a
 * JD-Core Version:    0.7.0.1
 */