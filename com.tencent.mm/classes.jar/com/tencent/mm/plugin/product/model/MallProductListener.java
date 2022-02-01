package com.tencent.mm.plugin.product.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.sk;
import com.tencent.mm.sdk.event.IListener;

public class MallProductListener
  extends IListener<sk>
{
  public MallProductListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160829);
    this.__eventId = sk.class.getName().hashCode();
    AppMethodBeat.o(160829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.model.MallProductListener
 * JD-Core Version:    0.7.0.1
 */