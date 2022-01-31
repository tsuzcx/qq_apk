package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Iterator;

public final class h
{
  public ArrayList<bi> mCl;
  public boolean mCm;
  ArrayList<h.b> mCn;
  
  private h()
  {
    AppMethodBeat.i(32166);
    this.mCl = new ArrayList();
    this.mCm = false;
    this.mCn = new ArrayList();
    AppMethodBeat.o(32166);
  }
  
  private void bfY()
  {
    AppMethodBeat.i(32174);
    Iterator localIterator = this.mCn.iterator();
    while (localIterator.hasNext()) {
      ((h.b)localIterator.next()).clear();
    }
    AppMethodBeat.o(32174);
  }
  
  private void dKf()
  {
    AppMethodBeat.i(32173);
    Iterator localIterator = this.mCn.iterator();
    while (localIterator.hasNext()) {
      ((h.b)localIterator.next()).dKd();
    }
    AppMethodBeat.o(32173);
  }
  
  private bi oL(long paramLong)
  {
    AppMethodBeat.i(32168);
    Iterator localIterator = this.mCl.iterator();
    while (localIterator.hasNext())
    {
      bi localbi = (bi)localIterator.next();
      if (localbi.field_msgId == paramLong)
      {
        AppMethodBeat.o(32168);
        return localbi;
      }
    }
    AppMethodBeat.o(32168);
    return null;
  }
  
  public final void a(h.b paramb)
  {
    AppMethodBeat.i(32175);
    this.mCn.remove(paramb);
    this.mCn.add(paramb);
    AppMethodBeat.o(32175);
  }
  
  public final void bD(bi parambi)
  {
    AppMethodBeat.i(32167);
    if (parambi == null)
    {
      AppMethodBeat.o(32167);
      return;
    }
    ab.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[] { Long.valueOf(parambi.field_msgId) });
    this.mCl.remove(parambi);
    this.mCl.remove(oL(parambi.field_msgId));
    this.mCl.add(parambi);
    dKf();
    AppMethodBeat.o(32167);
  }
  
  public final void bE(bi parambi)
  {
    AppMethodBeat.i(32169);
    if (parambi == null)
    {
      AppMethodBeat.o(32169);
      return;
    }
    ab.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[] { Long.valueOf(parambi.field_msgId) });
    this.mCl.remove(parambi);
    this.mCl.remove(oL(parambi.field_msgId));
    dKf();
    AppMethodBeat.o(32169);
  }
  
  public final boolean bF(bi parambi)
  {
    AppMethodBeat.i(32172);
    if (parambi == null)
    {
      AppMethodBeat.o(32172);
      return false;
    }
    Iterator localIterator = this.mCl.iterator();
    while (localIterator.hasNext()) {
      if (((bi)localIterator.next()).field_msgId == parambi.field_msgId)
      {
        AppMethodBeat.o(32172);
        return true;
      }
    }
    AppMethodBeat.o(32172);
    return false;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(32170);
    ab.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
    this.mCl.clear();
    bfY();
    AppMethodBeat.o(32170);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(32171);
    this.mCn.clear();
    clear();
    this.mCm = false;
    AppMethodBeat.o(32171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.h
 * JD-Core Version:    0.7.0.1
 */