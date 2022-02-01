package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import java.util.ArrayList;
import java.util.Iterator;

public final class h
{
  public ArrayList<bo> qSv;
  public boolean qSw;
  ArrayList<b> qSx;
  
  private h()
  {
    AppMethodBeat.i(36079);
    this.qSv = new ArrayList();
    this.qSw = false;
    this.qSx = new ArrayList();
    AppMethodBeat.o(36079);
  }
  
  private bo Bp(long paramLong)
  {
    AppMethodBeat.i(36081);
    Iterator localIterator = this.qSv.iterator();
    while (localIterator.hasNext())
    {
      bo localbo = (bo)localIterator.next();
      if (localbo.field_msgId == paramLong)
      {
        AppMethodBeat.o(36081);
        return localbo;
      }
    }
    AppMethodBeat.o(36081);
    return null;
  }
  
  private void bUu()
  {
    AppMethodBeat.i(36087);
    Iterator localIterator = this.qSx.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).clear();
    }
    AppMethodBeat.o(36087);
  }
  
  private void fpo()
  {
    AppMethodBeat.i(36086);
    Iterator localIterator = this.qSx.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).fpm();
    }
    AppMethodBeat.o(36086);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(36088);
    this.qSx.remove(paramb);
    this.qSx.add(paramb);
    AppMethodBeat.o(36088);
  }
  
  public final void cg(bo parambo)
  {
    AppMethodBeat.i(36080);
    if (parambo == null)
    {
      AppMethodBeat.o(36080);
      return;
    }
    ac.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[] { Long.valueOf(parambo.field_msgId) });
    this.qSv.remove(parambo);
    this.qSv.remove(Bp(parambo.field_msgId));
    this.qSv.add(parambo);
    fpo();
    AppMethodBeat.o(36080);
  }
  
  public final void ch(bo parambo)
  {
    AppMethodBeat.i(36082);
    if (parambo == null)
    {
      AppMethodBeat.o(36082);
      return;
    }
    ac.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[] { Long.valueOf(parambo.field_msgId) });
    this.qSv.remove(parambo);
    this.qSv.remove(Bp(parambo.field_msgId));
    fpo();
    AppMethodBeat.o(36082);
  }
  
  public final boolean ci(bo parambo)
  {
    AppMethodBeat.i(36085);
    if (parambo == null)
    {
      AppMethodBeat.o(36085);
      return false;
    }
    Iterator localIterator = this.qSv.iterator();
    while (localIterator.hasNext()) {
      if (((bo)localIterator.next()).field_msgId == parambo.field_msgId)
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
    ac.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
    this.qSv.clear();
    bUu();
    AppMethodBeat.o(36083);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36084);
    this.qSx.clear();
    clear();
    this.qSw = false;
    AppMethodBeat.o(36084);
  }
  
  public static final class a
  {
    private static final h IbS;
    
    static
    {
      AppMethodBeat.i(36078);
      IbS = new h((byte)0);
      AppMethodBeat.o(36078);
    }
  }
  
  public static abstract interface b
  {
    public abstract void clear();
    
    public abstract void fpm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.h
 * JD-Core Version:    0.7.0.1
 */