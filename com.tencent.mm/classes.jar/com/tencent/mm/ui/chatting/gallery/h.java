package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Iterator;

public final class h
{
  public ArrayList<ca> tkt;
  public boolean tku;
  ArrayList<b> tkv;
  
  private h()
  {
    AppMethodBeat.i(36079);
    this.tkt = new ArrayList();
    this.tku = false;
    this.tkv = new ArrayList();
    AppMethodBeat.o(36079);
  }
  
  private ca NO(long paramLong)
  {
    AppMethodBeat.i(36081);
    Iterator localIterator = this.tkt.iterator();
    while (localIterator.hasNext())
    {
      ca localca = (ca)localIterator.next();
      if (localca.field_msgId == paramLong)
      {
        AppMethodBeat.o(36081);
        return localca;
      }
    }
    AppMethodBeat.o(36081);
    return null;
  }
  
  private void cyf()
  {
    AppMethodBeat.i(36087);
    Iterator localIterator = this.tkv.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).clear();
    }
    AppMethodBeat.o(36087);
  }
  
  private void gSo()
  {
    AppMethodBeat.i(36086);
    Iterator localIterator = this.tkv.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).gSm();
    }
    AppMethodBeat.o(36086);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(36088);
    this.tkv.remove(paramb);
    this.tkv.add(paramb);
    AppMethodBeat.o(36088);
  }
  
  public final void cC(ca paramca)
  {
    AppMethodBeat.i(36080);
    if (paramca == null)
    {
      AppMethodBeat.o(36080);
      return;
    }
    Log.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[] { Long.valueOf(paramca.field_msgId) });
    this.tkt.remove(paramca);
    this.tkt.remove(NO(paramca.field_msgId));
    this.tkt.add(paramca);
    gSo();
    AppMethodBeat.o(36080);
  }
  
  public final void cD(ca paramca)
  {
    AppMethodBeat.i(36082);
    if (paramca == null)
    {
      AppMethodBeat.o(36082);
      return;
    }
    Log.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[] { Long.valueOf(paramca.field_msgId) });
    this.tkt.remove(paramca);
    this.tkt.remove(NO(paramca.field_msgId));
    gSo();
    AppMethodBeat.o(36082);
  }
  
  public final boolean cE(ca paramca)
  {
    AppMethodBeat.i(36085);
    if (paramca == null)
    {
      AppMethodBeat.o(36085);
      return false;
    }
    Iterator localIterator = this.tkt.iterator();
    while (localIterator.hasNext()) {
      if (((ca)localIterator.next()).field_msgId == paramca.field_msgId)
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
    Log.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
    this.tkt.clear();
    cyf();
    AppMethodBeat.o(36083);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36084);
    this.tkv.clear();
    clear();
    this.tku = false;
    AppMethodBeat.o(36084);
  }
  
  public static final class a
  {
    private static final h Pys;
    
    static
    {
      AppMethodBeat.i(36078);
      Pys = new h((byte)0);
      AppMethodBeat.o(36078);
    }
  }
  
  public static abstract interface b
  {
    public abstract void clear();
    
    public abstract void gSm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.h
 * JD-Core Version:    0.7.0.1
 */