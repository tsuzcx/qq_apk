package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.g.a.ua.a;
import com.tencent.mm.sdk.b.c;
import java.lang.ref.WeakReference;

final class b$a
  extends c<ua>
{
  int mwo;
  int qTp;
  int qTq;
  WeakReference<b> qTr;
  
  public b$a(b paramb)
  {
    super(0);
    AppMethodBeat.i(70229);
    this.qTp = 0;
    this.qTq = 0;
    this.mwo = 0;
    this.qTr = new WeakReference(paramb);
    this.__eventId = ua.class.getName().hashCode();
    AppMethodBeat.o(70229);
  }
  
  private void a(ua paramua)
  {
    this.qTp = paramua.cKz.cKC;
    this.qTq = paramua.cKz.cKA;
    this.mwo = paramua.cKz.cKB;
  }
  
  private boolean cmG()
  {
    AppMethodBeat.i(70230);
    if (this.qTr.get() == null)
    {
      AppMethodBeat.o(70230);
      return false;
    }
    int i = b.E((b)this.qTr.get()) + this.qTp;
    if ((i < this.qTq) || (i > this.mwo))
    {
      AppMethodBeat.o(70230);
      return false;
    }
    AppMethodBeat.o(70230);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.a
 * JD-Core Version:    0.7.0.1
 */