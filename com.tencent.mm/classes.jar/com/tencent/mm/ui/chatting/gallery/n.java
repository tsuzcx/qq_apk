package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import java.util.ArrayList;
import java.util.Iterator;

public final class n
{
  public ArrayList<cc> Ann;
  public boolean Ano;
  ArrayList<b> Anp;
  
  private n()
  {
    AppMethodBeat.i(36079);
    this.Ann = new ArrayList();
    this.Ano = false;
    this.Anp = new ArrayList();
    AppMethodBeat.o(36079);
  }
  
  private cc Ak(long paramLong)
  {
    AppMethodBeat.i(36081);
    Iterator localIterator = this.Ann.iterator();
    while (localIterator.hasNext())
    {
      cc localcc = (cc)localIterator.next();
      if (localcc.field_msgId == paramLong)
      {
        AppMethodBeat.o(36081);
        return localcc;
      }
    }
    AppMethodBeat.o(36081);
    return null;
  }
  
  private void dqe()
  {
    AppMethodBeat.i(36087);
    Iterator localIterator = this.Anp.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).clear();
    }
    AppMethodBeat.o(36087);
  }
  
  private void jvl()
  {
    AppMethodBeat.i(36086);
    Iterator localIterator = this.Anp.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).jvj();
    }
    AppMethodBeat.o(36086);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(36088);
    this.Anp.remove(paramb);
    this.Anp.add(paramb);
    AppMethodBeat.o(36088);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(36083);
    Log.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
    this.Ann.clear();
    dqe();
    AppMethodBeat.o(36083);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36084);
    this.Anp.clear();
    clear();
    this.Ano = false;
    AppMethodBeat.o(36084);
  }
  
  public final void dv(cc paramcc)
  {
    AppMethodBeat.i(36080);
    if (paramcc == null)
    {
      AppMethodBeat.o(36080);
      return;
    }
    Log.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[] { Long.valueOf(paramcc.field_msgId) });
    this.Ann.remove(paramcc);
    this.Ann.remove(Ak(paramcc.field_msgId));
    this.Ann.add(paramcc);
    jvl();
    AppMethodBeat.o(36080);
  }
  
  public final void dw(cc paramcc)
  {
    AppMethodBeat.i(36082);
    if (paramcc == null)
    {
      AppMethodBeat.o(36082);
      return;
    }
    Log.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[] { Long.valueOf(paramcc.field_msgId) });
    this.Ann.remove(paramcc);
    this.Ann.remove(Ak(paramcc.field_msgId));
    jvl();
    AppMethodBeat.o(36082);
  }
  
  public final boolean dx(cc paramcc)
  {
    AppMethodBeat.i(36085);
    if (paramcc == null)
    {
      AppMethodBeat.o(36085);
      return false;
    }
    Iterator localIterator = this.Ann.iterator();
    while (localIterator.hasNext()) {
      if (((cc)localIterator.next()).field_msgId == paramcc.field_msgId)
      {
        AppMethodBeat.o(36085);
        return true;
      }
    }
    AppMethodBeat.o(36085);
    return false;
  }
  
  public static final class a
  {
    private static final n aeCu;
    
    static
    {
      AppMethodBeat.i(36078);
      aeCu = new n((byte)0);
      AppMethodBeat.o(36078);
    }
  }
  
  public static abstract interface b
  {
    public abstract void clear();
    
    public abstract void jvj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.n
 * JD-Core Version:    0.7.0.1
 */