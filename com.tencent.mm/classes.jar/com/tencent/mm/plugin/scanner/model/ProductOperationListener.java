package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.sk;
import com.tencent.mm.sdk.event.IListener;

public class ProductOperationListener
  extends IListener<sk>
{
  public ProductOperationListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161001);
    this.__eventId = sk.class.getName().hashCode();
    AppMethodBeat.o(161001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ProductOperationListener
 * JD-Core Version:    0.7.0.1
 */