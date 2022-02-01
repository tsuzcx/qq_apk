package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.textstatus.g.z;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class TextStatusEditActivity$p
  implements View.OnClickListener
{
  TextStatusEditActivity$p(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216506);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    paramView = this.GeQ.fwr();
    if (paramView != null)
    {
      localObject = paramView.getText();
      if (localObject != null)
      {
        paramView = this.GeQ.fwr();
        if (paramView == null) {
          break label146;
        }
      }
    }
    label146:
    for (paramView = Integer.valueOf(paramView.getSelectionStart());; paramView = null)
    {
      ((Editable)localObject).insert(paramView.intValue(), (CharSequence)this.GeQ.getContext().getString(2131766606));
      this.GeQ.fwr().requestFocus();
      paramView = this.GeQ.getContext().getSystemService("input_method");
      if (paramView != null) {
        break;
      }
      paramView = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(216506);
      throw paramView;
    }
    ((InputMethodManager)paramView).showSoftInput((View)this.GeQ.fwr(), 0);
    paramView = SecDataUIC.CWq;
    paramView = this.GeQ.getContext();
    p.g(paramView, "context");
    paramView = (z)SecDataUIC.a.a((Context)paramView, 8, z.class);
    if (paramView != null) {
      paramView.Ust = (1L + paramView.Ust);
    }
    a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.p
 * JD-Core Version:    0.7.0.1
 */