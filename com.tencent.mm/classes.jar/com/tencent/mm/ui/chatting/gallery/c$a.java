package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.e;
import com.tencent.mm.at.g;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class c$a
{
  int eke;
  ak handler;
  private int min;
  protected boolean prepared;
  private String talker;
  private List<bi> zKa;
  int zKb;
  protected int zKc;
  protected int zKd;
  protected int zKe;
  protected long zKf;
  private c zKg;
  public HashMap<Long, e> zKh;
  public HashMap<Long, e> zKi;
  
  public c$a(long paramLong, String paramString, c paramc, Boolean paramBoolean)
  {
    AppMethodBeat.i(31966);
    this.prepared = false;
    this.zKh = new HashMap();
    this.zKi = new HashMap();
    this.handler = new ak();
    this.talker = paramString;
    this.zKa = new LinkedList();
    this.zKg = paramc;
    aw.aaz();
    paramString = com.tencent.mm.model.c.YC().kB(paramLong);
    if (paramString.field_msgId == 0L)
    {
      Assert.assertTrue("MicroMsg.AutoList <init>, currentMsg does not exist, currentMsgId = " + paramLong + ", stack = " + bo.dtY(), false);
      AppMethodBeat.o(31966);
      return;
    }
    this.zKa.add(paramString);
    aw.RO().ac(new c.a.1(this, paramLong, paramBoolean, paramc));
    paramc.zJK.zMo = new c.a.2(this, paramc);
    AppMethodBeat.o(31966);
  }
  
  private void D(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(31970);
    ab.i("MicroMsg.AutoList", "start loadMsgInfo, currentMsgId = " + paramLong + ", forward = " + paramBoolean);
    if (c.muT) {
      aw.aaz();
    }
    for (List localList = com.tencent.mm.model.c.YD().b(this.talker, c.jUy, paramLong, paramBoolean); (localList == null) || (localList.size() == 0); localList = com.tencent.mm.model.c.YC().g(this.talker, paramLong, paramBoolean))
    {
      ab.w("MicroMsg.AutoList", "loadMsgInfo fail, addedMsgList is null, forward = ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(31970);
      return;
      aw.aaz();
    }
    ab.i("MicroMsg.AutoList", "loadMsgInfo done, new added list, size = " + localList.size() + ", forward = " + paramBoolean);
    paramLong = System.currentTimeMillis();
    fi(localList);
    ab.i("MicroMsg.AutoList", "loadImgInfo spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong) });
    if (paramBoolean)
    {
      this.zKa.addAll(localList);
      AppMethodBeat.o(31970);
      return;
    }
    this.zKa.addAll(0, localList);
    this.min -= localList.size();
    if (this.min < 0)
    {
      ab.e("MicroMsg.AutoList", "loadMsgInfo fail, min should not be minus, min = " + this.min);
      AppMethodBeat.o(31970);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("min from ");
    int i = this.min;
    ab.i("MicroMsg.AutoList", localList.size() + i + " to " + this.min);
    AppMethodBeat.o(31970);
  }
  
  private void fi(List<bi> paramList)
  {
    AppMethodBeat.i(31967);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if (c.c((bi)paramList.get(i)))
      {
        localArrayList1.add(Long.valueOf(((bi)paramList.get(i)).field_msgSvrId));
        if (((bi)paramList.get(i)).field_isSend == 1) {
          localArrayList2.add(Long.valueOf(((bi)paramList.get(i)).field_msgId));
        }
      }
      i += 1;
    }
    this.zKh.putAll(com.tencent.mm.at.o.ahC().a((Long[])localArrayList1.toArray(new Long[0])));
    this.zKi.putAll(com.tencent.mm.at.o.ahC().b((Long[])localArrayList2.toArray(new Long[0])));
    AppMethodBeat.o(31967);
  }
  
  public final int Qa(int paramInt)
  {
    return paramInt - 100000 + this.zKb;
  }
  
  public final bi Qb(int paramInt)
  {
    AppMethodBeat.i(31969);
    paramInt = Qa(paramInt);
    int i = this.min + this.zKa.size() - 1;
    if ((paramInt < this.min) || (paramInt > i))
    {
      ab.e("MicroMsg.AutoList", "get, invalid pos " + paramInt + ", min = " + this.min + ", max = " + i);
      AppMethodBeat.o(31969);
      return null;
    }
    ab.d("MicroMsg.AutoList", "get, pos = ".concat(String.valueOf(paramInt)));
    if (paramInt == this.min)
    {
      localbi = (bi)this.zKa.get(0);
      if (this.prepared) {
        D(localbi.field_msgId, false);
      }
      AppMethodBeat.o(31969);
      return localbi;
    }
    if ((paramInt == i) && (i < this.eke - 1))
    {
      localbi = (bi)this.zKa.get(this.zKa.size() - 1);
      if (this.prepared) {
        D(localbi.field_msgId, true);
      }
      AppMethodBeat.o(31969);
      return localbi;
    }
    bi localbi = (bi)this.zKa.get(paramInt - this.min);
    AppMethodBeat.o(31969);
    return localbi;
  }
  
  public final void a(long paramLong, e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(31968);
    if (paramBoolean)
    {
      this.zKh.put(Long.valueOf(paramLong), parame);
      AppMethodBeat.o(31968);
      return;
    }
    this.zKi.put(Long.valueOf(paramLong), parame);
    AppMethodBeat.o(31968);
  }
  
  public final void dJV()
  {
    this.prepared = false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(31971);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AutoList, Size = " + this.zKa.size());
    ((StringBuilder)localObject).append("; Content = {");
    Iterator localIterator = this.zKa.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuilder)localObject).append(((bi)localIterator.next()).field_msgId);
      ((StringBuilder)localObject).append(",");
    }
    ((StringBuilder)localObject).append("}");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(31971);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.c.a
 * JD-Core Version:    0.7.0.1
 */