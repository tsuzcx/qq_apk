package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.Iterator;

public final class h
{
  public ArrayList<bu> rCx;
  public boolean rCy;
  ArrayList<b> rCz;
  
  private h()
  {
    AppMethodBeat.i(36079);
    this.rCx = new ArrayList();
    this.rCy = false;
    this.rCz = new ArrayList();
    AppMethodBeat.o(36079);
  }
  
  private bu Eh(long paramLong)
  {
    AppMethodBeat.i(36081);
    Iterator localIterator = this.rCx.iterator();
    while (localIterator.hasNext())
    {
      bu localbu = (bu)localIterator.next();
      if (localbu.field_msgId == paramLong)
      {
        AppMethodBeat.o(36081);
        return localbu;
      }
    }
    AppMethodBeat.o(36081);
    return null;
  }
  
  private void bYZ()
  {
    AppMethodBeat.i(36087);
    Iterator localIterator = this.rCz.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).clear();
    }
    AppMethodBeat.o(36087);
  }
  
  private void fFT()
  {
    AppMethodBeat.i(36086);
    Iterator localIterator = this.rCz.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).fFR();
    }
    AppMethodBeat.o(36086);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(36088);
    this.rCz.remove(paramb);
    this.rCz.add(paramb);
    AppMethodBeat.o(36088);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(36083);
    ad.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
    this.rCx.clear();
    bYZ();
    AppMethodBeat.o(36083);
  }
  
  public final void cm(bu parambu)
  {
    AppMethodBeat.i(36080);
    if (parambu == null)
    {
      AppMethodBeat.o(36080);
      return;
    }
    ad.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[] { Long.valueOf(parambu.field_msgId) });
    this.rCx.remove(parambu);
    this.rCx.remove(Eh(parambu.field_msgId));
    this.rCx.add(parambu);
    fFT();
    AppMethodBeat.o(36080);
  }
  
  public final void cn(bu parambu)
  {
    AppMethodBeat.i(36082);
    if (parambu == null)
    {
      AppMethodBeat.o(36082);
      return;
    }
    ad.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[] { Long.valueOf(parambu.field_msgId) });
    this.rCx.remove(parambu);
    this.rCx.remove(Eh(parambu.field_msgId));
    fFT();
    AppMethodBeat.o(36082);
  }
  
  public final boolean co(bu parambu)
  {
    AppMethodBeat.i(36085);
    if (parambu == null)
    {
      AppMethodBeat.o(36085);
      return false;
    }
    Iterator localIterator = this.rCx.iterator();
    while (localIterator.hasNext()) {
      if (((bu)localIterator.next()).field_msgId == parambu.field_msgId)
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
    this.rCz.clear();
    clear();
    this.rCy = false;
    AppMethodBeat.o(36084);
  }
  
  public static final class a
  {
    private static final h JRk;
    
    static
    {
      AppMethodBeat.i(36078);
      JRk = new h((byte)0);
      AppMethodBeat.o(36078);
    }
  }
  
  public static abstract interface b
  {
    public abstract void clear();
    
    public abstract void fFR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.h
 * JD-Core Version:    0.7.0.1
 */