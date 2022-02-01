package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Iterator;

public final class l
{
  public ArrayList<ca> wQK;
  public boolean wQL;
  ArrayList<b> wQM;
  
  private l()
  {
    AppMethodBeat.i(36079);
    this.wQK = new ArrayList();
    this.wQL = false;
    this.wQM = new ArrayList();
    AppMethodBeat.o(36079);
  }
  
  private ca Wa(long paramLong)
  {
    AppMethodBeat.i(36081);
    Iterator localIterator = this.wQK.iterator();
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
  
  private void cMA()
  {
    AppMethodBeat.i(36087);
    Iterator localIterator = this.wQM.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).clear();
    }
    AppMethodBeat.o(36087);
  }
  
  private void hRN()
  {
    AppMethodBeat.i(36086);
    Iterator localIterator = this.wQM.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).hRL();
    }
    AppMethodBeat.o(36086);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(36088);
    this.wQM.remove(paramb);
    this.wQM.add(paramb);
    AppMethodBeat.o(36088);
  }
  
  public final void cY(ca paramca)
  {
    AppMethodBeat.i(36080);
    if (paramca == null)
    {
      AppMethodBeat.o(36080);
      return;
    }
    Log.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[] { Long.valueOf(paramca.field_msgId) });
    this.wQK.remove(paramca);
    this.wQK.remove(Wa(paramca.field_msgId));
    this.wQK.add(paramca);
    hRN();
    AppMethodBeat.o(36080);
  }
  
  public final void cZ(ca paramca)
  {
    AppMethodBeat.i(36082);
    if (paramca == null)
    {
      AppMethodBeat.o(36082);
      return;
    }
    Log.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[] { Long.valueOf(paramca.field_msgId) });
    this.wQK.remove(paramca);
    this.wQK.remove(Wa(paramca.field_msgId));
    hRN();
    AppMethodBeat.o(36082);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(36083);
    Log.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
    this.wQK.clear();
    cMA();
    AppMethodBeat.o(36083);
  }
  
  public final boolean da(ca paramca)
  {
    AppMethodBeat.i(36085);
    if (paramca == null)
    {
      AppMethodBeat.o(36085);
      return false;
    }
    Iterator localIterator = this.wQK.iterator();
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
  
  public final void detach()
  {
    AppMethodBeat.i(36084);
    this.wQM.clear();
    clear();
    this.wQL = false;
    AppMethodBeat.o(36084);
  }
  
  public static final class a
  {
    private static final l WSR;
    
    static
    {
      AppMethodBeat.i(36078);
      WSR = new l((byte)0);
      AppMethodBeat.o(36078);
    }
  }
  
  public static abstract interface b
  {
    public abstract void clear();
    
    public abstract void hRL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.l
 * JD-Core Version:    0.7.0.1
 */