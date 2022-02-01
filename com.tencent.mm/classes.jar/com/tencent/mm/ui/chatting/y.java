package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class y
  implements aw
{
  public aa JYo;
  public a cXJ;
  
  public y(a parama)
  {
    AppMethodBeat.i(34778);
    this.cXJ = parama;
    this.JYo = new aa();
    AppMethodBeat.o(34778);
  }
  
  private void bj(bv parambv)
  {
    AppMethodBeat.i(34782);
    if (parambv == null)
    {
      AppMethodBeat.o(34782);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(parambv);
    ij(localArrayList);
    AppMethodBeat.o(34782);
  }
  
  private void ij(List<bv> paramList)
  {
    AppMethodBeat.i(34783);
    if ((this.JYo != null) && (this.cXJ != null))
    {
      this.JYo.a(this.cXJ.Kkd.getContext(), paramList);
      this.JYo.O(this.cXJ.fJC(), this.cXJ.getTalkerUserName());
    }
    AppMethodBeat.o(34783);
  }
  
  public final void M(List<bv> paramList)
  {
    AppMethodBeat.i(34780);
    if (this.cXJ == null)
    {
      ae.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui is null.");
      AppMethodBeat.o(34780);
      return;
    }
    if (x.wb(this.cXJ.getTalkerUserName()))
    {
      AppMethodBeat.o(34780);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bv localbv = (bv)paramList.next();
      if ((localbv.field_talker.equals(this.cXJ.getTalkerUserName())) && ((localbv.isText()) || (localbv.fvQ()))) {
        localArrayList.add(localbv);
      }
    }
    ij(localArrayList);
    AppMethodBeat.o(34780);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle) {}
  
  public final void a(bv parambv)
  {
    AppMethodBeat.i(34779);
    if (this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.y.class) == null)
    {
      ae.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui maybe has exit!");
      AppMethodBeat.o(34779);
      return;
    }
    ((com.tencent.mm.ui.chatting.d.b.y)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.y.class)).fHr();
    if ((!parambv.field_talker.equals(this.cXJ.getTalkerUserName())) || ((!parambv.isText()) && (!parambv.fvQ())))
    {
      AppMethodBeat.o(34779);
      return;
    }
    bj(parambv);
    AppMethodBeat.o(34779);
  }
  
  public final void aoa(String paramString)
  {
    AppMethodBeat.i(34781);
    if (af.isNullOrNil(paramString))
    {
      AppMethodBeat.o(34781);
      return;
    }
    bv localbv = new bv();
    localbv.setContent(paramString);
    localbv.kt(1);
    bj(localbv);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.y
 * JD-Core Version:    0.7.0.1
 */