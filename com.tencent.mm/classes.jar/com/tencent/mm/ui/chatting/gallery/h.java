package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.Iterator;

public final class h
{
  public ArrayList<bl> qjT;
  public boolean qjU;
  ArrayList<b> qjV;
  
  private h()
  {
    AppMethodBeat.i(36079);
    this.qjT = new ArrayList();
    this.qjU = false;
    this.qjV = new ArrayList();
    AppMethodBeat.o(36079);
  }
  
  private void bNj()
  {
    AppMethodBeat.i(36087);
    Iterator localIterator = this.qjV.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).clear();
    }
    AppMethodBeat.o(36087);
  }
  
  private void eZz()
  {
    AppMethodBeat.i(36086);
    Iterator localIterator = this.qjV.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).eZx();
    }
    AppMethodBeat.o(36086);
  }
  
  private bl wM(long paramLong)
  {
    AppMethodBeat.i(36081);
    Iterator localIterator = this.qjT.iterator();
    while (localIterator.hasNext())
    {
      bl localbl = (bl)localIterator.next();
      if (localbl.field_msgId == paramLong)
      {
        AppMethodBeat.o(36081);
        return localbl;
      }
    }
    AppMethodBeat.o(36081);
    return null;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(36088);
    this.qjV.remove(paramb);
    this.qjV.add(paramb);
    AppMethodBeat.o(36088);
  }
  
  public final void cd(bl parambl)
  {
    AppMethodBeat.i(36080);
    if (parambl == null)
    {
      AppMethodBeat.o(36080);
      return;
    }
    ad.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[] { Long.valueOf(parambl.field_msgId) });
    this.qjT.remove(parambl);
    this.qjT.remove(wM(parambl.field_msgId));
    this.qjT.add(parambl);
    eZz();
    AppMethodBeat.o(36080);
  }
  
  public final void ce(bl parambl)
  {
    AppMethodBeat.i(36082);
    if (parambl == null)
    {
      AppMethodBeat.o(36082);
      return;
    }
    ad.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[] { Long.valueOf(parambl.field_msgId) });
    this.qjT.remove(parambl);
    this.qjT.remove(wM(parambl.field_msgId));
    eZz();
    AppMethodBeat.o(36082);
  }
  
  public final boolean cf(bl parambl)
  {
    AppMethodBeat.i(36085);
    if (parambl == null)
    {
      AppMethodBeat.o(36085);
      return false;
    }
    Iterator localIterator = this.qjT.iterator();
    while (localIterator.hasNext()) {
      if (((bl)localIterator.next()).field_msgId == parambl.field_msgId)
      {
        AppMethodBeat.o(36085);
        return true;
      }
    }
    AppMethodBeat.o(36085);
    return false;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(36083);
    ad.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
    this.qjT.clear();
    bNj();
    AppMethodBeat.o(36083);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36084);
    this.qjV.clear();
    clear();
    this.qjU = false;
    AppMethodBeat.o(36084);
  }
  
  public static final class a
  {
    private static final h GBY;
    
    static
    {
      AppMethodBeat.i(36078);
      GBY = new h((byte)0);
      AppMethodBeat.o(36078);
    }
  }
  
  public static abstract interface b
  {
    public abstract void clear();
    
    public abstract void eZx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.h
 * JD-Core Version:    0.7.0.1
 */