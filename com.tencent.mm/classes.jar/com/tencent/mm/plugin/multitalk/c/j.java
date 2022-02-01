package com.tencent.mm.plugin.multitalk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.protocal.protobuf.afp;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.protocal.protobuf.fyy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TimerTask;

public final class j
{
  public long LiS;
  public long LiT;
  public String LiU;
  public String LiV;
  ArrayList<i> LiW;
  public String LiX;
  public String LiY;
  public long LiZ;
  public String Lja;
  final TimerTask Ljb;
  ArrayList<i> wUq;
  ArrayList<i> wUs;
  final ArrayList<a> wUu;
  d<?> wUv;
  
  public j()
  {
    AppMethodBeat.i(285121);
    this.wUs = new ArrayList(10);
    this.wUu = new ArrayList(2);
    this.Ljb = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(285011);
        o.Ljn.au(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(285057);
            if (o.Ljn.Ljt == 1)
            {
              ArrayList localArrayList = new ArrayList(5);
              ??? = j.this.wUq.iterator();
              Object localObject3;
              while (((Iterator)???).hasNext())
              {
                localObject3 = (i)((Iterator)???).next();
                o localo = o.Ljn;
                boolean bool = o.a((i)localObject3);
                Log.v("MicroMsg.Multitalk.ILinkMemberMgr", "hy: member %s is talking %b", new Object[] { localObject3, Boolean.valueOf(bool) });
                if (bool) {
                  localArrayList.add(localObject3);
                }
              }
              Collections.sort(localArrayList, new Comparator() {});
              if (!j.a(j.this, localArrayList)) {
                synchronized (j.this.wUu)
                {
                  localObject3 = j.this.wUu.iterator();
                  if (((Iterator)localObject3).hasNext()) {
                    ((j.a)((Iterator)localObject3).next()).V(localArrayList);
                  }
                }
              }
              j.this.wUs = localObject1;
              AppMethodBeat.o(285057);
              return;
            }
            Log.w("MicroMsg.Multitalk.ILinkMemberMgr", "hy: not in room, ignore speaker change");
            AppMethodBeat.o(285057);
          }
        });
        AppMethodBeat.o(285011);
      }
    };
    this.wUq = new ArrayList(10);
    AppMethodBeat.o(285121);
  }
  
  final void a(afq paramafq, LinkedList<fyy> paramLinkedList, String paramString1, String paramString2, b<String> paramb)
  {
    AppMethodBeat.i(285159);
    ArrayList localArrayList = new ArrayList();
    if ((paramafq == null) || (paramafq.YFR == null) || (paramafq.YFR.size() == 0)) {
      this.wUq.clear();
    }
    for (;;)
    {
      this.wUq = localArrayList;
      this.LiW = this.wUq;
      paramb.a(0, 0, null, null);
      AppMethodBeat.o(285159);
      return;
      paramafq = paramafq.YFR.iterator();
      while (paramafq.hasNext())
      {
        afp localafp = (afp)paramafq.next();
        i locali = new i();
        locali.wTC = localafp.ZnB;
        locali.openId = localafp.openid;
        locali.mStatus = localafp.status;
        locali.luk = "";
        Iterator localIterator = paramLinkedList.iterator();
        while (localIterator.hasNext())
        {
          fyy localfyy = (fyy)localIterator.next();
          Log.i("MicroMsg.Multitalk.ILinkMemberMgr", "username %s, openid:%s", new Object[] { localfyy.username, localfyy.abWi });
          if (localafp.openid.equals(localfyy.abWi)) {
            locali.luk = localfyy.username;
          }
          if (localfyy.username.equals(paramString1)) {
            locali.LiP = paramString2;
          }
        }
        localArrayList.add(locali);
        Log.i("MicroMsg.Multitalk.ILinkMemberMgr", "steve: add member, memberid:%d openid:%s, username:%s, status %d, inviteName:%s", new Object[] { Integer.valueOf(locali.wTC), locali.openId, locali.luk, Integer.valueOf(locali.mStatus), locali.LiP });
      }
    }
  }
  
  public final i aMF(String paramString)
  {
    AppMethodBeat.i(285179);
    if ((this.wUq != null) && (paramString != null))
    {
      Iterator localIterator = this.wUq.iterator();
      while (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        if ((locali != null) && (locali.luk.equals(paramString)))
        {
          AppMethodBeat.o(285179);
          return locali;
        }
      }
    }
    AppMethodBeat.o(285179);
    return null;
  }
  
  final void aNi()
  {
    AppMethodBeat.i(285134);
    this.wUs.clear();
    this.wUq.clear();
    this.wUu.clear();
    this.LiS = 0L;
    this.LiT = 0L;
    this.LiU = null;
    this.LiW = null;
    this.LiX = null;
    this.LiY = null;
    gei();
    AppMethodBeat.o(285134);
  }
  
  final String abn(int paramInt)
  {
    AppMethodBeat.i(285174);
    if (this.wUq != null)
    {
      Object localObject = this.wUq.iterator();
      while (((Iterator)localObject).hasNext())
      {
        i locali = (i)((Iterator)localObject).next();
        if ((locali != null) && (paramInt == locali.wTC))
        {
          localObject = locali.luk;
          AppMethodBeat.o(285174);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(285174);
    return null;
  }
  
  public final int abo(int paramInt)
  {
    AppMethodBeat.i(285184);
    if (this.wUq.size() == 0)
    {
      AppMethodBeat.o(285184);
      return -1;
    }
    Iterator localIterator = this.wUq.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.wTC == paramInt)
      {
        paramInt = locali.wVL;
        AppMethodBeat.o(285184);
        return paramInt;
      }
    }
    AppMethodBeat.o(285184);
    return -1;
  }
  
  final void bF(LinkedList<afg> paramLinkedList)
  {
    AppMethodBeat.i(285150);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Log.i("MicroMsg.Multitalk.ILinkMemberMgr", "yuemwang videoIdList: ".concat(String.valueOf(paramLinkedList)));
      paramLinkedList = paramLinkedList.iterator();
      if (paramLinkedList.hasNext())
      {
        afg localafg = (afg)paramLinkedList.next();
        int i;
        if ((localafg.ZnC & 0x4) != 0) {
          i = 101;
        }
        for (;;)
        {
          jP(localafg.ZnB, i);
          break;
          if ((localafg.ZnC & 0x8) != 0) {
            i = 102;
          } else {
            i = 103;
          }
        }
      }
    }
    AppMethodBeat.o(285150);
  }
  
  public final ArrayList<i> geh()
  {
    try
    {
      AppMethodBeat.i(285167);
      ArrayList localArrayList = (ArrayList)this.wUq.clone();
      AppMethodBeat.o(285167);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void gei()
  {
    AppMethodBeat.i(285190);
    synchronized (this.wUu)
    {
      this.wUu.clear();
      if (this.wUv != null) {
        this.wUv.cancel(false);
      }
      AppMethodBeat.o(285190);
      return;
    }
  }
  
  final void jP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(285139);
    if (this.wUq != null)
    {
      Iterator localIterator = this.wUq.iterator();
      while (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        if ((locali != null) && (locali.wTC == paramInt1)) {
          locali.wVL = paramInt2;
        }
      }
    }
    AppMethodBeat.o(285139);
  }
  
  static abstract interface a
  {
    public abstract void V(ArrayList<i> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.j
 * JD-Core Version:    0.7.0.1
 */