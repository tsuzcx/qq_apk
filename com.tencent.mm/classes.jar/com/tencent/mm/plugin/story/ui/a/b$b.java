package com.tencent.mm.plugin.story.ui.a;

import a.f.b.j;
import a.l;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$b
  implements View.OnClickListener
{
  b$b(b paramb, String paramString, b.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110093);
    j.p(paramView, "it");
    if (paramView.isSelected())
    {
      paramView = new Intent();
      paramView.putExtra("Contact_User", this.sIe);
      paramView.putExtra("Contact_ChatRoomId", this.sId.grA);
      paramView.putExtra("CONTACT_INFO_UI_SOURCE", 15);
      View localView = this.sIf.aku;
      j.p(localView, "holder.itemView");
      d.b(localView.getContext(), "profile", ".ui.ContactInfoUI", paramView);
    }
    AppMethodBeat.o(110093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.b.b
 * JD-Core Version:    0.7.0.1
 */