package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public final class k
{
  ArrayList<j> qsr;
  ArrayList<j> qss;
  final ArrayList<a> qst;
  Timer qsu;
  public long zHB;
  public long zHC;
  public String zHD;
  public String zHE;
  ArrayList<j> zHF;
  public String zHG;
  public String zHH;
  public long zHI;
  public String zHJ;
  
  public k()
  {
    AppMethodBeat.i(239040);
    this.qss = new ArrayList(10);
    this.qst = new ArrayList(2);
    this.qsr = new ArrayList(10);
    AppMethodBeat.o(239040);
  }
  
  final String QX(int paramInt)
  {
    AppMethodBeat.i(239046);
    if (this.qsr != null)
    {
      Object localObject = this.qsr.iterator();
      while (((Iterator)localObject).hasNext())
      {
        j localj = (j)((Iterator)localObject).next();
        if ((localj != null) && (paramInt == localj.qrD))
        {
          localObject = localj.goe;
          AppMethodBeat.o(239046);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(239046);
    return null;
  }
  
  public final int QY(int paramInt)
  {
    AppMethodBeat.i(239048);
    if (this.qsr.size() == 0)
    {
      AppMethodBeat.o(239048);
      return -1;
    }
    Iterator localIterator = this.qsr.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (localj.qrD == paramInt)
      {
        paramInt = localj.qtI;
        AppMethodBeat.o(239048);
        return paramInt;
      }
    }
    AppMethodBeat.o(239048);
    return -1;
  }
  
  final void a(ada paramada, LinkedList<esc> paramLinkedList, String paramString1, String paramString2, b<String> paramb)
  {
    AppMethodBeat.i(239044);
    ArrayList localArrayList = new ArrayList();
    if ((paramada == null) || (paramada.KHx == null) || (paramada.KHx.size() == 0)) {
      this.qsr.clear();
    }
    for (;;)
    {
      this.qsr = localArrayList;
      this.zHF = this.qsr;
      paramb.a(0, 0, null, null);
      AppMethodBeat.o(239044);
      return;
      paramada = paramada.KHx.iterator();
      while (paramada.hasNext())
      {
        acz localacz = (acz)paramada.next();
        j localj = new j();
        localj.qrD = localacz.Lnt;
        localj.openId = localacz.openid;
        localj.mStatus = localacz.status;
        localj.goe = "";
        Iterator localIterator = paramLinkedList.iterator();
        while (localIterator.hasNext())
        {
          esc localesc = (esc)localIterator.next();
          Log.i("MicroMsg.Multitalk.ILinkMemberMgr", "username %s, openid:%s", new Object[] { localesc.username, localesc.Npd });
          if (localacz.openid.equals(localesc.Npd)) {
            localj.goe = localesc.username;
          }
          if (localesc.username.equals(paramString1)) {
            localj.zHx = paramString2;
          }
        }
        localArrayList.add(localj);
        Log.i("MicroMsg.Multitalk.ILinkMemberMgr", "steve: add member, memberid:%d openid:%s, username:%s, status %d, inviteName:%s", new Object[] { Integer.valueOf(localj.qrD), localj.openId, localj.goe, Integer.valueOf(localj.mStatus), localj.zHx });
      }
    }
  }
  
  final j aFx(String paramString)
  {
    AppMethodBeat.i(239047);
    if ((this.qsr != null) && (paramString != null))
    {
      Iterator localIterator = this.qsr.iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        if ((localj != null) && (localj.goe.equals(paramString)))
        {
          AppMethodBeat.o(239047);
          return localj;
        }
      }
    }
    AppMethodBeat.o(239047);
    return null;
  }
  
  final void amZ()
  {
    AppMethodBeat.i(239041);
    this.qss.clear();
    this.qsr.clear();
    this.qst.clear();
    this.zHB = 0L;
    this.zHC = 0L;
    this.zHD = null;
    this.zHF = null;
    this.zHG = null;
    this.zHH = null;
    elG();
    AppMethodBeat.o(239041);
  }
  
  final void be(LinkedList<acq> paramLinkedList)
  {
    AppMethodBeat.i(239043);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Log.i("MicroMsg.Multitalk.ILinkMemberMgr", "yuemwang videoIdList: ".concat(String.valueOf(paramLinkedList)));
      paramLinkedList = paramLinkedList.iterator();
      if (paramLinkedList.hasNext())
      {
        acq localacq = (acq)paramLinkedList.next();
        int i;
        if ((localacq.Lnu & 0x4) != 0) {
          if ((localacq.Lnu & 0x8) != 0) {
            i = 102;
          }
        }
        for (;;)
        {
          hf(localacq.Lnt, i);
          break;
          i = 101;
          continue;
          i = 103;
        }
      }
    }
    AppMethodBeat.o(239043);
  }
  
  public final ArrayList<j> elF()
  {
    try
    {
      AppMethodBeat.i(239045);
      ArrayList localArrayList = (ArrayList)this.qsr.clone();
      AppMethodBeat.o(239045);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void elG()
  {
    AppMethodBeat.i(239049);
    synchronized (this.qst)
    {
      this.qst.clear();
      if (this.qsu != null) {
        this.qsu.cancel();
      }
      AppMethodBeat.o(239049);
      return;
    }
  }
  
  final void hf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239042);
    if (this.qsr != null)
    {
      Iterator localIterator = this.qsr.iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        if ((localj != null) && (localj.qrD == paramInt1)) {
          localj.qtI = paramInt2;
        }
      }
    }
    AppMethodBeat.o(239042);
  }
  
  static abstract interface a
  {
    public abstract void Q(ArrayList<j> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.k
 * JD-Core Version:    0.7.0.1
 */