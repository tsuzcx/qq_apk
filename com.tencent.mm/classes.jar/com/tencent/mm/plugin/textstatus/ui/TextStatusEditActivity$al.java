package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.textstatus.proto.am;
import com.tencent.mm.ui.ai.f;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class TextStatusEditActivity$al
  implements View.OnClickListener
{
  TextStatusEditActivity$al(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(233764);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    paramView = this.MMz.MMa;
    if (paramView != null) {
      paramView.dismiss();
    }
    paramView = this.MMz.gmI();
    if (paramView != null)
    {
      localObject = paramView.getText();
      if (localObject != null)
      {
        paramView = this.MMz.gmI();
        if (paramView == null) {
          break label163;
        }
      }
    }
    label163:
    for (paramView = Integer.valueOf(paramView.getSelectionStart());; paramView = null)
    {
      ((Editable)localObject).insert(paramView.intValue(), (CharSequence)this.MMz.getContext().getString(ai.f.tag_search_word));
      this.MMz.gmI().requestFocus();
      paramView = this.MMz.getContext().getSystemService("input_method");
      if (paramView != null) {
        break;
      }
      paramView = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(233764);
      throw paramView;
    }
    ((InputMethodManager)paramView).showSoftInput((View)this.MMz.gmI(), 0);
    paramView = com.tencent.mm.plugin.secdata.ui.a.JbV;
    paramView = this.MMz.getContext();
    p.j(paramView, "context");
    paramView = (am)a.a.a((Context)paramView, 8, am.class);
    if (paramView != null) {
      paramView.MGo = (1L + paramView.MGo);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(233764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.al
 * JD-Core Version:    0.7.0.1
 */