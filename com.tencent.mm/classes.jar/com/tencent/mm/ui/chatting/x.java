package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.at;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class x
  implements at
{
  public z HPJ;
  public a cLy;
  
  public x(a parama)
  {
    AppMethodBeat.i(34778);
    this.cLy = parama;
    this.HPJ = new z();
    AppMethodBeat.o(34778);
  }
  
  private void bh(bo parambo)
  {
    AppMethodBeat.i(34782);
    if (parambo == null)
    {
      AppMethodBeat.o(34782);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(parambo);
    hN(localArrayList);
    AppMethodBeat.o(34782);
  }
  
  private void hN(List<bo> paramList)
  {
    AppMethodBeat.i(34783);
    if ((this.HPJ != null) && (this.cLy != null))
    {
      this.HPJ.a(this.cLy.HZF.getContext(), paramList);
      this.HPJ.H(this.cLy.foQ(), this.cLy.getTalkerUserName());
    }
    AppMethodBeat.o(34783);
  }
  
  public final void M(List<bo> paramList)
  {
    AppMethodBeat.i(34780);
    if (this.cLy == null)
    {
      ac.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui is null.");
      AppMethodBeat.o(34780);
      return;
    }
    if (com.tencent.mm.model.w.sQ(this.cLy.getTalkerUserName()))
    {
      AppMethodBeat.o(34780);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bo localbo = (bo)paramList.next();
      if ((localbo.field_talker.equals(this.cLy.getTalkerUserName())) && ((localbo.isText()) || (localbo.fbM()))) {
        localArrayList.add(localbo);
      }
    }
    hN(localArrayList);
    AppMethodBeat.o(34780);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle) {}
  
  public final void a(bo parambo)
  {
    AppMethodBeat.i(34779);
    if (this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class) == null)
    {
      ac.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui maybe has exit!");
      AppMethodBeat.o(34779);
      return;
    }
    ((com.tencent.mm.ui.chatting.c.b.w)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class)).fnC();
    if ((!parambo.field_talker.equals(this.cLy.getTalkerUserName())) || ((!parambo.isText()) && (!parambo.fbM())))
    {
      AppMethodBeat.o(34779);
      return;
    }
    bh(parambo);
    AppMethodBeat.o(34779);
  }
  
  public final void aim(String paramString)
  {
    AppMethodBeat.i(34781);
    if (ae.isNullOrNil(paramString))
    {
      AppMethodBeat.o(34781);
      return;
    }
    bo localbo = new bo();
    localbo.setContent(paramString);
    localbo.jT(1);
    bh(localbo);
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
 * Qualified Name:     com.tencent.mm.ui.chatting.x
 * JD-Core Version:    0.7.0.1
 */