package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aba;
import com.tencent.mm.protocal.protobuf.abb;
import com.tencent.mm.protocal.protobuf.dxw;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public final class k
{
  ArrayList<j> pdr;
  ArrayList<j> pds;
  final ArrayList<a> pdt;
  Timer pdu;
  public String wmA;
  ArrayList<j> wmB;
  public String wmC;
  public String wmD;
  public long wmE;
  public String wmF;
  public long wmx;
  public long wmy;
  public String wmz;
  
  public k()
  {
    AppMethodBeat.i(190467);
    this.pds = new ArrayList(10);
    this.pdt = new ArrayList(2);
    this.pdr = new ArrayList(10);
    AppMethodBeat.o(190467);
  }
  
  final String KX(int paramInt)
  {
    AppMethodBeat.i(190471);
    if (this.pdr != null)
    {
      Object localObject = this.pdr.iterator();
      while (((Iterator)localObject).hasNext())
      {
        j localj = (j)((Iterator)localObject).next();
        if ((localj != null) && (paramInt == localj.pcE))
        {
          localObject = localj.fIQ;
          AppMethodBeat.o(190471);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(190471);
    return null;
  }
  
  final void Zm()
  {
    AppMethodBeat.i(190468);
    this.pds.clear();
    this.pdr.clear();
    this.pdt.clear();
    this.wmx = 0L;
    this.wmy = 0L;
    this.wmz = null;
    this.wmB = null;
    this.wmC = null;
    this.wmD = null;
    drJ();
    AppMethodBeat.o(190468);
  }
  
  final void a(abb paramabb, LinkedList<dxw> paramLinkedList, String paramString1, String paramString2, b<String> paramb)
  {
    AppMethodBeat.i(190469);
    ArrayList localArrayList = new ArrayList();
    if ((paramabb == null) || (paramabb.FNS == null) || (paramabb.FNS.size() == 0)) {
      this.pdr.clear();
    }
    for (;;)
    {
      this.pdr = localArrayList;
      this.wmB = this.pdr;
      paramb.a(0, 0, null, null);
      AppMethodBeat.o(190469);
      return;
      paramabb = paramabb.FNS.iterator();
      while (paramabb.hasNext())
      {
        aba localaba = (aba)paramabb.next();
        j localj = new j();
        localj.pcE = localaba.Gsd;
        localj.openId = localaba.FQc;
        localj.mStatus = localaba.status;
        localj.fIQ = "";
        Iterator localIterator = paramLinkedList.iterator();
        while (localIterator.hasNext())
        {
          dxw localdxw = (dxw)localIterator.next();
          ae.i("MicroMsg.Multitalk.ILinkMemberMgr", "username %s, openid:%s", new Object[] { localdxw.username, localdxw.IcF });
          if (localaba.FQc.equals(localdxw.IcF)) {
            localj.fIQ = localdxw.username;
          }
          if (localdxw.username.equals(paramString1)) {
            localj.wmt = paramString2;
          }
        }
        localArrayList.add(localj);
        ae.i("MicroMsg.Multitalk.ILinkMemberMgr", "steve: add member, memberid:%d openid:%s, username:%s, status %d, inviteName:%s", new Object[] { Integer.valueOf(localj.pcE), localj.openId, localj.fIQ, Integer.valueOf(localj.mStatus), localj.wmt });
      }
    }
  }
  
  final j asd(String paramString)
  {
    AppMethodBeat.i(190472);
    if ((this.pdr != null) && (paramString != null))
    {
      Iterator localIterator = this.pdr.iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        if ((localj != null) && (localj.fIQ.equals(paramString)))
        {
          AppMethodBeat.o(190472);
          return localj;
        }
      }
    }
    AppMethodBeat.o(190472);
    return null;
  }
  
  public final ArrayList<j> drI()
  {
    try
    {
      AppMethodBeat.i(190470);
      ArrayList localArrayList = (ArrayList)this.pdr.clone();
      AppMethodBeat.o(190470);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void drJ()
  {
    AppMethodBeat.i(190473);
    synchronized (this.pdt)
    {
      this.pdt.clear();
      if (this.pdu != null) {
        this.pdu.cancel();
      }
      AppMethodBeat.o(190473);
      return;
    }
  }
  
  static abstract interface a
  {
    public abstract void J(ArrayList<j> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.k
 * JD-Core Version:    0.7.0.1
 */