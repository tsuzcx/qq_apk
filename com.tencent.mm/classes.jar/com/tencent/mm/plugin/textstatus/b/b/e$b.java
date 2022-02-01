package com.tencent.mm.plugin.textstatus.b.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.textstatus.a.d;
import com.tencent.mm.storage.as;
import com.tencent.mm.view.recyclerview.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class e$b
  implements View.OnClickListener
{
  e$b(e parame, as paramas, i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(238531);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/textstatus/convert/like/ReferenceItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = new Intent();
    paramView.putExtra("Contact_User", this.HtW.getUsername());
    paramView.putExtra("CONTACT_INFO_UI_SOURCE", 54);
    c.b(this.tDl.getContext(), "profile", ".ui.ContactInfoUI", paramView, 213);
    ((d)h.ag(d.class)).report22210(this.HtW.getUsername(), this.MAD.MAv);
    a.a(this, "com/tencent/mm/plugin/textstatus/convert/like/ReferenceItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(238531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.b.e.b
 * JD-Core Version:    0.7.0.1
 */