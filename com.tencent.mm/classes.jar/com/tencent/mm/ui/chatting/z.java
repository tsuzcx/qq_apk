package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.chatting.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class z
  implements ao
{
  public a byx;
  public ac vmf;
  
  public z(a parama)
  {
    this.byx = parama;
    this.vmf = new ac();
  }
  
  private void dT(List<bi> paramList)
  {
    if ((this.vmf != null) && (this.byx != null)) {
      this.vmf.a(this.byx.vtz.getContext(), paramList);
    }
  }
  
  public final void C(List<bi> paramList)
  {
    if (this.byx == null) {
      y.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui is null.");
    }
    while (s.fn(this.byx.getTalkerUserName())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bi localbi = (bi)paramList.next();
      if ((localbi.field_talker.equals(this.byx.getTalkerUserName())) && (localbi.isText())) {
        localArrayList.add(localbi);
      }
    }
    dT(localArrayList);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle) {}
  
  public final void a(bi parambi)
  {
    if (this.byx.ac(q.class) == null) {
      y.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui maybe has exit!");
    }
    do
    {
      return;
      ((q)this.byx.ac(q.class)).cEE();
    } while ((!parambi.field_talker.equals(this.byx.getTalkerUserName())) || (!parambi.isText()));
    aE(parambi);
  }
  
  public final void aE(bi parambi)
  {
    if (parambi == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(parambi);
    dT(localArrayList);
  }
  
  public final Looper getLooper()
  {
    return Looper.getMainLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.z
 * JD-Core Version:    0.7.0.1
 */