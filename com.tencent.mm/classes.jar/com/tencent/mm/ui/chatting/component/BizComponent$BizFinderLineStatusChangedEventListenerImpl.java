package com.tencent.mm.ui.chatting.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.at;
import com.tencent.mm.sdk.event.IListener;
import java.lang.ref.WeakReference;

class BizComponent$BizFinderLineStatusChangedEventListenerImpl
  extends IListener<at>
{
  private WeakReference<BizComponent> Ixt;
  
  public BizComponent$BizFinderLineStatusChangedEventListenerImpl(BizComponent paramBizComponent)
  {
    super(f.hfK);
    AppMethodBeat.i(256337);
    this.Ixt = new WeakReference(paramBizComponent);
    this.__eventId = at.class.getName().hashCode();
    AppMethodBeat.o(256337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.BizComponent.BizFinderLineStatusChangedEventListenerImpl
 * JD-Core Version:    0.7.0.1
 */