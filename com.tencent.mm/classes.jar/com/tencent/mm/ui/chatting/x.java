package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class x
  implements aq
{
  public a caz;
  public z zBD;
  
  public x(a parama)
  {
    AppMethodBeat.i(30904);
    this.caz = parama;
    this.zBD = new z();
    AppMethodBeat.o(30904);
  }
  
  private void aM(bi parambi)
  {
    AppMethodBeat.i(30908);
    if (parambi == null)
    {
      AppMethodBeat.o(30908);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(parambi);
    fd(localArrayList);
    AppMethodBeat.o(30908);
  }
  
  private void fd(List<bi> paramList)
  {
    AppMethodBeat.i(30909);
    if ((this.zBD != null) && (this.caz != null)) {
      this.zBD.a(this.caz.zJz.getContext(), paramList);
    }
    AppMethodBeat.o(30909);
  }
  
  public final void J(List<bi> paramList)
  {
    AppMethodBeat.i(30906);
    if (this.caz == null)
    {
      ab.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui is null.");
      AppMethodBeat.o(30906);
      return;
    }
    if (t.lA(this.caz.getTalkerUserName()))
    {
      AppMethodBeat.o(30906);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bi localbi = (bi)paramList.next();
      if ((localbi.field_talker.equals(this.caz.getTalkerUserName())) && (localbi.isText())) {
        localArrayList.add(localbi);
      }
    }
    fd(localArrayList);
    AppMethodBeat.o(30906);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle) {}
  
  public final void a(bi parambi)
  {
    AppMethodBeat.i(30905);
    if (this.caz.ay(r.class) == null)
    {
      ab.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui maybe has exit!");
      AppMethodBeat.o(30905);
      return;
    }
    ((r)this.caz.ay(r.class)).dIv();
    if ((!parambi.field_talker.equals(this.caz.getTalkerUserName())) || (!parambi.isText()))
    {
      AppMethodBeat.o(30905);
      return;
    }
    aM(parambi);
    AppMethodBeat.o(30905);
  }
  
  public final void atM(String paramString)
  {
    AppMethodBeat.i(30907);
    if (ah.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30907);
      return;
    }
    bi localbi = new bi();
    localbi.setContent(paramString);
    localbi.hL(1);
    aM(localbi);
    AppMethodBeat.o(30907);
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(30910);
    Looper localLooper = Looper.getMainLooper();
    AppMethodBeat.o(30910);
    return localLooper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.x
 * JD-Core Version:    0.7.0.1
 */