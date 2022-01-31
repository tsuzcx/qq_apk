package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.as.e;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class c$a
{
  int dsw;
  ah handler = new ah();
  private int min;
  protected boolean prepared = false;
  private String talker;
  private List<bi> vtZ;
  int vua;
  protected int vub;
  protected int vuc;
  protected int vud;
  protected long vue;
  private c vuf;
  public HashMap<Long, e> vug = new HashMap();
  public HashMap<Long, e> vuh = new HashMap();
  
  public c$a(long paramLong, String paramString, c paramc, Boolean paramBoolean)
  {
    this.talker = paramString;
    this.vtZ = new LinkedList();
    this.vuf = paramc;
    au.Hx();
    paramString = com.tencent.mm.model.c.Fy().fd(paramLong);
    if (paramString.field_msgId == 0L)
    {
      Assert.assertTrue("MicroMsg.AutoList <init>, currentMsg does not exist, currentMsgId = " + paramLong + ", stack = " + bk.csb(), false);
      return;
    }
    this.vtZ.add(paramString);
    au.DS().O(new c.a.1(this, paramLong, paramBoolean, paramc));
    paramc.vtJ.vwh = new c.a.2(this, paramc);
  }
  
  private void dY(List<bi> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if (c.be((bi)paramList.get(i)))
      {
        localArrayList1.add(Long.valueOf(((bi)paramList.get(i)).field_msgSvrId));
        if (((bi)paramList.get(i)).field_isSend == 1) {
          localArrayList2.add(Long.valueOf(((bi)paramList.get(i)).field_msgId));
        }
      }
      i += 1;
    }
    this.vug.putAll(com.tencent.mm.as.o.OJ().a((Long[])localArrayList1.toArray(new Long[0])));
    this.vuh.putAll(com.tencent.mm.as.o.OJ().b((Long[])localArrayList2.toArray(new Long[0])));
  }
  
  private void w(long paramLong, boolean paramBoolean)
  {
    y.i("MicroMsg.AutoList", "start loadMsgInfo, currentMsgId = " + paramLong + ", forward = " + paramBoolean);
    if (c.kax) {
      au.Hx();
    }
    for (List localList = com.tencent.mm.model.c.Fz().b(this.talker, c.idK, paramLong, paramBoolean); (localList == null) || (localList.size() == 0); localList = com.tencent.mm.model.c.Fy().g(this.talker, paramLong, paramBoolean))
    {
      y.w("MicroMsg.AutoList", "loadMsgInfo fail, addedMsgList is null, forward = " + paramBoolean);
      return;
      au.Hx();
    }
    y.i("MicroMsg.AutoList", "loadMsgInfo done, new added list, size = " + localList.size() + ", forward = " + paramBoolean);
    paramLong = System.currentTimeMillis();
    dY(localList);
    y.i("MicroMsg.AutoList", "loadImgInfo spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong) });
    if (paramBoolean)
    {
      this.vtZ.addAll(localList);
      return;
    }
    this.vtZ.addAll(0, localList);
    this.min -= localList.size();
    if (this.min < 0)
    {
      y.e("MicroMsg.AutoList", "loadMsgInfo fail, min should not be minus, min = " + this.min);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("min from ");
    int i = this.min;
    y.i("MicroMsg.AutoList", localList.size() + i + " to " + this.min);
  }
  
  public final int Ht(int paramInt)
  {
    return paramInt - 100000 + this.vua;
  }
  
  public final bi Hu(int paramInt)
  {
    paramInt = Ht(paramInt);
    int i = this.min + this.vtZ.size() - 1;
    Object localObject;
    if ((paramInt < this.min) || (paramInt > i))
    {
      y.e("MicroMsg.AutoList", "get, invalid pos " + paramInt + ", min = " + this.min + ", max = " + i);
      localObject = null;
    }
    bi localbi;
    do
    {
      do
      {
        return localObject;
        y.d("MicroMsg.AutoList", "get, pos = " + paramInt);
        if (paramInt != this.min) {
          break;
        }
        localbi = (bi)this.vtZ.get(0);
        localObject = localbi;
      } while (!this.prepared);
      w(localbi.field_msgId, false);
      return localbi;
      if ((paramInt != i) || (i >= this.dsw - 1)) {
        break;
      }
      localbi = (bi)this.vtZ.get(this.vtZ.size() - 1);
      localObject = localbi;
    } while (!this.prepared);
    w(localbi.field_msgId, true);
    return localbi;
    return (bi)this.vtZ.get(paramInt - this.min);
  }
  
  public final void cFS()
  {
    this.prepared = false;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AutoList, Size = " + this.vtZ.size());
    localStringBuilder.append("; Content = {");
    Iterator localIterator = this.vtZ.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((bi)localIterator.next()).field_msgId);
      localStringBuilder.append(",");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.c.a
 * JD-Core Version:    0.7.0.1
 */