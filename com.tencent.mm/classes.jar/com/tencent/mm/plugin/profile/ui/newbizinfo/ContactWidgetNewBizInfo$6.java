package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;

final class ContactWidgetNewBizInfo$6
  implements Runnable
{
  ContactWidgetNewBizInfo$6(ContactWidgetNewBizInfo paramContactWidgetNewBizInfo) {}
  
  public final void run()
  {
    AppMethodBeat.i(231943);
    ContactWidgetNewBizInfo.a(this.Bjh, 4);
    if (ContactWidgetNewBizInfo.b(this.Bjh).getIntent().getIntExtra("Kdel_from", -1) == 1)
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      c.b(ContactWidgetNewBizInfo.b(this.Bjh), "shake", ".ui.ShakeReportUI", localIntent);
    }
    AppMethodBeat.o(231943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.6
 * JD-Core Version:    0.7.0.1
 */