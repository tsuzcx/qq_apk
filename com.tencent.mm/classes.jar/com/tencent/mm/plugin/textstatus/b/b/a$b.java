package com.tencent.mm.plugin.textstatus.b.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.as;
import com.tencent.mm.view.recyclerview.h;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$b
  implements View.OnClickListener
{
  a$b(as paramas, h paramh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216102);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/textstatus/convert/like/LikeHistoryItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = new Intent();
    paramView.putExtra("Contact_User", this.Byz.getUsername());
    paramView.putExtra("CONTACT_INFO_UI_SOURCE", 2);
    com.tencent.mm.br.c.b(this.qhp.getContext(), "profile", ".ui.ContactInfoUI", paramView, 213);
    ((com.tencent.mm.plugin.textstatus.a.c)g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).report22210(this.Byz.getUsername(), 4L);
    a.a(this, "com/tencent/mm/plugin/textstatus/convert/like/LikeHistoryItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.b.a.b
 * JD-Core Version:    0.7.0.1
 */