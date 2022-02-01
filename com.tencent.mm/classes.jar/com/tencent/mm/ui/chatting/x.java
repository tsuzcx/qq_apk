package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.au;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.d.b.y;
import com.tencent.mm.ui.chatting.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class x
  implements au
{
  public z JDx;
  public a cWM;
  
  public x(a parama)
  {
    AppMethodBeat.i(34778);
    this.cWM = parama;
    this.JDx = new z();
    AppMethodBeat.o(34778);
  }
  
  private void bk(bu parambu)
  {
    AppMethodBeat.i(34782);
    if (parambu == null)
    {
      AppMethodBeat.o(34782);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(parambu);
    hZ(localArrayList);
    AppMethodBeat.o(34782);
  }
  
  private void hZ(List<bu> paramList)
  {
    AppMethodBeat.i(34783);
    if ((this.JDx != null) && (this.cWM != null))
    {
      this.JDx.a(this.cWM.JOR.getContext(), paramList);
      this.JDx.M(this.cWM.fFv(), this.cWM.getTalkerUserName());
    }
    AppMethodBeat.o(34783);
  }
  
  public final void M(List<bu> paramList)
  {
    AppMethodBeat.i(34780);
    if (this.cWM == null)
    {
      ad.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui is null.");
      AppMethodBeat.o(34780);
      return;
    }
    if (w.vF(this.cWM.getTalkerUserName()))
    {
      AppMethodBeat.o(34780);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bu localbu = (bu)paramList.next();
      if ((localbu.field_talker.equals(this.cWM.getTalkerUserName())) && ((localbu.isText()) || (localbu.frQ()))) {
        localArrayList.add(localbu);
      }
    }
    hZ(localArrayList);
    AppMethodBeat.o(34780);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle) {}
  
  public final void a(bu parambu)
  {
    AppMethodBeat.i(34779);
    if (this.cWM.bh(y.class) == null)
    {
      ad.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui maybe has exit!");
      AppMethodBeat.o(34779);
      return;
    }
    ((y)this.cWM.bh(y.class)).fDo();
    if ((!parambu.field_talker.equals(this.cWM.getTalkerUserName())) || ((!parambu.isText()) && (!parambu.frQ())))
    {
      AppMethodBeat.o(34779);
      return;
    }
    bk(parambu);
    AppMethodBeat.o(34779);
  }
  
  public final void amZ(String paramString)
  {
    AppMethodBeat.i(34781);
    if (af.isNullOrNil(paramString))
    {
      AppMethodBeat.o(34781);
      return;
    }
    bu localbu = new bu();
    localbu.setContent(paramString);
    localbu.kr(1);
    bk(localbu);
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