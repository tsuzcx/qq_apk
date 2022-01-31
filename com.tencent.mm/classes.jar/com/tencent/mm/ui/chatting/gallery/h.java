package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Iterator;

public final class h
{
  public ArrayList<bi> khB = new ArrayList();
  public boolean khC = false;
  ArrayList<h.b> khD = new ArrayList();
  
  private void cGb()
  {
    Iterator localIterator = this.khD.iterator();
    while (localIterator.hasNext()) {
      ((h.b)localIterator.next()).cFZ();
    }
  }
  
  private bi hZ(long paramLong)
  {
    Iterator localIterator = this.khB.iterator();
    while (localIterator.hasNext())
    {
      bi localbi = (bi)localIterator.next();
      if (localbi.field_msgId == paramLong) {
        return localbi;
      }
    }
    return null;
  }
  
  public final void a(h.b paramb)
  {
    if (paramb == null) {
      return;
    }
    this.khD.remove(paramb);
    this.khD.add(paramb);
  }
  
  public final void bv(bi parambi)
  {
    if (parambi == null) {
      return;
    }
    y.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[] { Long.valueOf(parambi.field_msgId) });
    this.khB.remove(parambi);
    this.khB.remove(hZ(parambi.field_msgId));
    this.khB.add(parambi);
    cGb();
  }
  
  public final void bw(bi parambi)
  {
    if (parambi == null) {
      return;
    }
    y.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[] { Long.valueOf(parambi.field_msgId) });
    this.khB.remove(parambi);
    this.khB.remove(hZ(parambi.field_msgId));
    cGb();
  }
  
  public final boolean bx(bi parambi)
  {
    if (parambi == null) {
      return false;
    }
    Iterator localIterator = this.khB.iterator();
    while (localIterator.hasNext()) {
      if (((bi)localIterator.next()).field_msgId == parambi.field_msgId) {
        return true;
      }
    }
    return false;
  }
  
  public final void clear()
  {
    y.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
    this.khB.clear();
    Iterator localIterator = this.khD.iterator();
    while (localIterator.hasNext()) {
      ((h.b)localIterator.next()).clear();
    }
  }
  
  public final void detach()
  {
    this.khD.clear();
    clear();
    this.khC = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.h
 * JD-Core Version:    0.7.0.1
 */