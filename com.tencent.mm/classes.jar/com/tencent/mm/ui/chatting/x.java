package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.at;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class x
  implements at
{
  public z GpR;
  public a cOd;
  
  public x(a parama)
  {
    AppMethodBeat.i(34778);
    this.cOd = parama;
    this.GpR = new z();
    AppMethodBeat.o(34778);
  }
  
  private void bf(bl parambl)
  {
    AppMethodBeat.i(34782);
    if (parambl == null)
    {
      AppMethodBeat.o(34782);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(parambl);
    hA(localArrayList);
    AppMethodBeat.o(34782);
  }
  
  private void hA(List<bl> paramList)
  {
    AppMethodBeat.i(34783);
    if ((this.GpR != null) && (this.cOd != null))
    {
      this.GpR.a(this.cOd.GzJ.getContext(), paramList);
      this.GpR.G(this.cOd.eZb(), this.cOd.getTalkerUserName());
    }
    AppMethodBeat.o(34783);
  }
  
  public final void V(List<bl> paramList)
  {
    AppMethodBeat.i(34780);
    if (this.cOd == null)
    {
      ad.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui is null.");
      AppMethodBeat.o(34780);
      return;
    }
    if (com.tencent.mm.model.w.pF(this.cOd.getTalkerUserName()))
    {
      AppMethodBeat.o(34780);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bl localbl = (bl)paramList.next();
      if ((localbl.field_talker.equals(this.cOd.getTalkerUserName())) && ((localbl.isText()) || (localbl.eMh()))) {
        localArrayList.add(localbl);
      }
    }
    hA(localArrayList);
    AppMethodBeat.o(34780);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle) {}
  
  public final void a(bl parambl)
  {
    AppMethodBeat.i(34779);
    if (this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class) == null)
    {
      ad.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui maybe has exit!");
      AppMethodBeat.o(34779);
      return;
    }
    ((com.tencent.mm.ui.chatting.c.b.w)this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).eXQ();
    if ((!parambl.field_talker.equals(this.cOd.getTalkerUserName())) || ((!parambl.isText()) && (!parambl.eMh())))
    {
      AppMethodBeat.o(34779);
      return;
    }
    bf(parambl);
    AppMethodBeat.o(34779);
  }
  
  public final void adu(String paramString)
  {
    AppMethodBeat.i(34781);
    if (ae.isNullOrNil(paramString))
    {
      AppMethodBeat.o(34781);
      return;
    }
    bl localbl = new bl();
    localbl.setContent(paramString);
    localbl.jV(1);
    bf(localbl);
    AppMethodBeat.o(34781);
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(34784);
    Looper localLooper = Looper.getMainLooper();
    AppMethodBeat.o(34784);
    return localLooper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.x
 * JD-Core Version:    0.7.0.1
 */