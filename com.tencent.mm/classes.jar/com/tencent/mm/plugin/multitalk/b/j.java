package com.tencent.mm.plugin.multitalk.b;

import com.tencent.e.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.acy;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.fcn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TimerTask;

public final class j
{
  public long FmM;
  public long FmN;
  public String FmO;
  public String FmP;
  ArrayList<i> FmQ;
  public String FmR;
  public String FmS;
  public long FmT;
  public String FmU;
  final TimerTask FmV;
  ArrayList<i> tRa;
  ArrayList<i> tRc;
  final ArrayList<a> tRe;
  d<?> tRf;
  
  public j()
  {
    AppMethodBeat.i(198699);
    this.tRc = new ArrayList(10);
    this.tRe = new ArrayList(2);
    this.FmV = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(202163);
        o.Fne.am(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(199066);
            if (o.Fne.Fnk == 1)
            {
              ArrayList localArrayList = new ArrayList(5);
              ??? = j.this.tRa.iterator();
              Object localObject3;
              while (((Iterator)???).hasNext())
              {
                localObject3 = (i)((Iterator)???).next();
                o localo = o.Fne;
                boolean bool = o.a((i)localObject3);
                Log.v("MicroMsg.Multitalk.ILinkMemberMgr", "hy: member %s is talking %b", new Object[] { localObject3, Boolean.valueOf(bool) });
                if (bool) {
                  localArrayList.add(localObject3);
                }
              }
              Collections.sort(localArrayList, new Comparator() {});
              if (!j.a(j.this, localArrayList)) {
                synchronized (j.this.tRe)
                {
                  localObject3 = j.this.tRe.iterator();
                  if (((Iterator)localObject3).hasNext()) {
                    ((j.a)((Iterator)localObject3).next()).R(localArrayList);
                  }
                }
              }
              j.this.tRc = localObject1;
              AppMethodBeat.o(199066);
              return;
            }
            Log.w("MicroMsg.Multitalk.ILinkMemberMgr", "hy: not in room, ignore speaker change");
            AppMethodBeat.o(199066);
          }
        });
        AppMethodBeat.o(202163);
      }
    };
    this.tRa = new ArrayList(10);
    AppMethodBeat.o(198699);
  }
  
  final String Xl(int paramInt)
  {
    AppMethodBeat.i(198716);
    if (this.tRa != null)
    {
      Object localObject = this.tRa.iterator();
      while (((Iterator)localObject).hasNext())
      {
        i locali = (i)((Iterator)localObject).next();
        if ((locali != null) && (paramInt == locali.tQm))
        {
          localObject = locali.iSn;
          AppMethodBeat.o(198716);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(198716);
    return null;
  }
  
  public final int Xm(int paramInt)
  {
    AppMethodBeat.i(198721);
    if (this.tRa.size() == 0)
    {
      AppMethodBeat.o(198721);
      return -1;
    }
    Iterator localIterator = this.tRa.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.tQm == paramInt)
      {
        paramInt = locali.tSu;
        AppMethodBeat.o(198721);
        return paramInt;
      }
    }
    AppMethodBeat.o(198721);
    return -1;
  }
  
  final void a(adi paramadi, LinkedList<fcn> paramLinkedList, String paramString1, String paramString2, b<String> paramb)
  {
    AppMethodBeat.i(198712);
    ArrayList localArrayList = new ArrayList();
    if ((paramadi == null) || (paramadi.RIQ == null) || (paramadi.RIQ.size() == 0)) {
      this.tRa.clear();
    }
    for (;;)
    {
      this.tRa = localArrayList;
      this.FmQ = this.tRa;
      paramb.a(0, 0, null, null);
      AppMethodBeat.o(198712);
      return;
      paramadi = paramadi.RIQ.iterator();
      while (paramadi.hasNext())
      {
        adh localadh = (adh)paramadi.next();
        i locali = new i();
        locali.tQm = localadh.SoO;
        locali.openId = localadh.openid;
        locali.mStatus = localadh.status;
        locali.iSn = "";
        Iterator localIterator = paramLinkedList.iterator();
        while (localIterator.hasNext())
        {
          fcn localfcn = (fcn)localIterator.next();
          Log.i("MicroMsg.Multitalk.ILinkMemberMgr", "username %s, openid:%s", new Object[] { localfcn.username, localfcn.UBZ });
          if (localadh.openid.equals(localfcn.UBZ)) {
            locali.iSn = localfcn.username;
          }
          if (localfcn.username.equals(paramString1)) {
            locali.FmI = paramString2;
          }
        }
        localArrayList.add(locali);
        Log.i("MicroMsg.Multitalk.ILinkMemberMgr", "steve: add member, memberid:%d openid:%s, username:%s, status %d, inviteName:%s", new Object[] { Integer.valueOf(locali.tQm), locali.openId, locali.iSn, Integer.valueOf(locali.mStatus), locali.FmI });
      }
    }
  }
  
  final i aPH(String paramString)
  {
    AppMethodBeat.i(198719);
    if ((this.tRa != null) && (paramString != null))
    {
      Iterator localIterator = this.tRa.iterator();
      while (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        if ((locali != null) && (locali.iSn.equals(paramString)))
        {
          AppMethodBeat.o(198719);
          return locali;
        }
      }
    }
    AppMethodBeat.o(198719);
    return null;
  }
  
  final void ata()
  {
    AppMethodBeat.i(198701);
    this.tRc.clear();
    this.tRa.clear();
    this.tRe.clear();
    this.FmM = 0L;
    this.FmN = 0L;
    this.FmO = null;
    this.FmQ = null;
    this.FmR = null;
    this.FmS = null;
    eVr();
    AppMethodBeat.o(198701);
  }
  
  final void bx(LinkedList<acy> paramLinkedList)
  {
    AppMethodBeat.i(198708);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Log.i("MicroMsg.Multitalk.ILinkMemberMgr", "yuemwang videoIdList: ".concat(String.valueOf(paramLinkedList)));
      paramLinkedList = paramLinkedList.iterator();
      if (paramLinkedList.hasNext())
      {
        acy localacy = (acy)paramLinkedList.next();
        int i;
        if ((localacy.SoP & 0x4) != 0) {
          i = 101;
        }
        for (;;)
        {
          ik(localacy.SoO, i);
          break;
          if ((localacy.SoP & 0x8) != 0) {
            i = 102;
          } else {
            i = 103;
          }
        }
      }
    }
    AppMethodBeat.o(198708);
  }
  
  public final ArrayList<i> eVq()
  {
    try
    {
      AppMethodBeat.i(198713);
      ArrayList localArrayList = (ArrayList)this.tRa.clone();
      AppMethodBeat.o(198713);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void eVr()
  {
    AppMethodBeat.i(198725);
    synchronized (this.tRe)
    {
      this.tRe.clear();
      if (this.tRf != null) {
        this.tRf.cancel(false);
      }
      AppMethodBeat.o(198725);
      return;
    }
  }
  
  final void ik(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198706);
    if (this.tRa != null)
    {
      Iterator localIterator = this.tRa.iterator();
      while (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        if ((locali != null) && (locali.tQm == paramInt1)) {
          locali.tSu = paramInt2;
        }
      }
    }
    AppMethodBeat.o(198706);
  }
  
  static abstract interface a
  {
    public abstract void R(ArrayList<i> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.j
 * JD-Core Version:    0.7.0.1
 */