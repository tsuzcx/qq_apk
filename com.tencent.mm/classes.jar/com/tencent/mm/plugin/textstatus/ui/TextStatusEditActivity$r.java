package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.textstatus.g.z;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class TextStatusEditActivity$r
  implements View.OnClickListener
{
  TextStatusEditActivity$r(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216508);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    paramView = TextStatusDoWhatActivity.GdF;
    paramView = (Activity)this.GeQ;
    int i = TextStatusEditActivity.c(this.GeQ);
    p.h(paramView, "context");
    localObject = new Intent((Context)paramView, TextStatusDoWhatActivity.class);
    ((Intent)localObject).putExtra("KEY_DEFAULT_BACKGROUND_ID", i);
    paramView.startActivityForResult((Intent)localObject, 3);
    if (paramView != null) {
      paramView.overridePendingTransition(2130772132, 2130771986);
    }
    paramView = SecDataUIC.CWq;
    paramView = this.GeQ.getContext();
    p.g(paramView, "context");
    paramView = (z)SecDataUIC.a.a((Context)paramView, 8, z.class);
    if (paramView != null) {
      paramView.Uss = (1L + paramView.Uss);
    }
    a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.r
 * JD-Core Version:    0.7.0.1
 */