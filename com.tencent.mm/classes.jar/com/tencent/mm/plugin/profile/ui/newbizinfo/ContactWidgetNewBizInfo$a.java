package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.w;
import com.tencent.mm.sdk.event.IListener;
import java.lang.ref.WeakReference;

final class ContactWidgetNewBizInfo$a
  extends IListener<w>
{
  private WeakReference<ContactWidgetNewBizInfo> Bjm;
  
  public ContactWidgetNewBizInfo$a(ContactWidgetNewBizInfo paramContactWidgetNewBizInfo)
  {
    AppMethodBeat.i(231948);
    this.Bjm = new WeakReference(paramContactWidgetNewBizInfo);
    this.__eventId = w.class.getName().hashCode();
    AppMethodBeat.o(231948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.a
 * JD-Core Version:    0.7.0.1
 */