package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;

public final class h
{
  public ArrayList<bv> rKI;
  public boolean rKJ;
  ArrayList<b> rKK;
  
  private h()
  {
    AppMethodBeat.i(36079);
    this.rKI = new ArrayList();
    this.rKJ = false;
    this.rKK = new ArrayList();
    AppMethodBeat.o(36079);
  }
  
  private bv EJ(long paramLong)
  {
    AppMethodBeat.i(36081);
    Iterator localIterator = this.rKI.iterator();
    while (localIterator.hasNext())
    {
      bv localbv = (bv)localIterator.next();
      if (localbv.field_msgId == paramLong)
      {
        AppMethodBeat.o(36081);
        return localbv;
      }
    }
    AppMethodBeat.o(36081);
    return null;
  }
  
  private void cao()
  {
    AppMethodBeat.i(36087);
    Iterator localIterator = this.rKK.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).clear();
    }
    AppMethodBeat.o(36087);
  }
  
  private void fKa()
  {
    AppMethodBeat.i(36086);
    Iterator localIterator = this.rKK.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).fJY();
    }
    AppMethodBeat.o(36086);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(36088);
    this.rKK.remove(paramb);
    this.rKK.add(paramb);
    AppMethodBeat.o(36088);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(36083);
    ae.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
    this.rKI.clear();
    cao();
    AppMethodBeat.o(36083);
  }
  
  public final void cm(bv parambv)
  {
    AppMethodBeat.i(36080);
    if (parambv == null)
    {
      AppMethodBeat.o(36080);
      return;
    }
    ae.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[] { Long.valueOf(parambv.field_msgId) });
    this.rKI.remove(parambv);
    this.rKI.remove(EJ(parambv.field_msgId));
    this.rKI.add(parambv);
    fKa();
    AppMethodBeat.o(36080);
  }
  
  public final void cn(bv parambv)
  {
    AppMethodBeat.i(36082);
    if (parambv == null)
    {
      AppMethodBeat.o(36082);
      return;
    }
    ae.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[] { Long.valueOf(parambv.field_msgId) });
    this.rKI.remove(parambv);
    this.rKI.remove(EJ(parambv.field_msgId));
    fKa();
    AppMethodBeat.o(36082);
  }
  
  public final boolean co(bv parambv)
  {
    AppMethodBeat.i(36085);
    if (parambv == null)
    {
      AppMethodBeat.o(36085);
      return false;
    }
    Iterator localIterator = this.rKI.iterator();
    while (localIterator.hasNext()) {
      if (((bv)localIterator.next()).field_msgId == parambv.field_msgId)
      {
        AppMethodBeat.o(36085);
        return true;
      }
    }
    AppMethodBeat.o(36085);
    return false;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36084);
    this.rKK.clear();
    clear();
    this.rKJ = false;
    AppMethodBeat.o(36084);
  }
  
  public static final class a
  {
    private static final h Kmv;
    
    static
    {
      AppMethodBeat.i(36078);
      Kmv = new h((byte)0);
      AppMethodBeat.o(36078);
    }
  }
  
  public static abstract interface b
  {
    public abstract void clear();
    
    public abstract void fJY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.h
 * JD-Core Version:    0.7.0.1
 */