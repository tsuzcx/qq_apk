package com.tencent.mm.plugin.story.ui.a;

import a.f.b.j;
import a.l;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.story.model.b.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class f$a$c
  implements View.OnClickListener
{
  f$a$c(f.a parama, a parama1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(138851);
    paramView = new Intent();
    paramView.putExtra("Contact_User", this.sIE.czp);
    paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
    View localView = this.sID.aku;
    j.p(localView, "itemView");
    d.b(localView.getContext(), "profile", ".ui.ContactInfoUI", paramView);
    AppMethodBeat.o(138851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.f.a.c
 * JD-Core Version:    0.7.0.1
 */