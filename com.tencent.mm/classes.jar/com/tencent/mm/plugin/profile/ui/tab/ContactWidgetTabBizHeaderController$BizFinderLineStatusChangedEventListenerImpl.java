package com.tencent.mm.plugin.profile.ui.tab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.at;
import com.tencent.mm.sdk.event.IListener;
import java.lang.ref.WeakReference;

class ContactWidgetTabBizHeaderController$BizFinderLineStatusChangedEventListenerImpl
  extends IListener<at>
{
  private WeakReference<ContactWidgetTabBizHeaderController> Ixt;
  
  public ContactWidgetTabBizHeaderController$BizFinderLineStatusChangedEventListenerImpl(ContactWidgetTabBizHeaderController paramContactWidgetTabBizHeaderController)
  {
    super(f.hfK);
    AppMethodBeat.i(305939);
    this.Ixt = new WeakReference(paramContactWidgetTabBizHeaderController);
    this.__eventId = at.class.getName().hashCode();
    AppMethodBeat.o(305939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizHeaderController.BizFinderLineStatusChangedEventListenerImpl
 * JD-Core Version:    0.7.0.1
 */