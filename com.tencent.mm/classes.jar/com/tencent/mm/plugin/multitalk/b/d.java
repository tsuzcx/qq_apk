package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.protocal.protobuf.aas;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.pb.common.b.a.a.a.ap;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  o wmg = null;
  MultiTalkGroup wmh = null;
  
  public d(o paramo)
  {
    this.wmg = paramo;
  }
  
  static MultiTalkGroup a(k paramk)
  {
    AppMethodBeat.i(190434);
    MultiTalkGroup localMultiTalkGroup = new MultiTalkGroup();
    localMultiTalkGroup.MgG = paramk.wmx;
    localMultiTalkGroup.wmA = paramk.wmz;
    localMultiTalkGroup.MgH = paramk.wmC;
    localMultiTalkGroup.wmz = paramk.wmz;
    paramk = paramk.wmB;
    if ((paramk != null) && (paramk.size() > 0))
    {
      paramk = paramk.iterator();
      while (paramk.hasNext())
      {
        j localj = (j)paramk.next();
        MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
        localMultiTalkGroupMember.MgJ = localj.fIQ;
        localMultiTalkGroupMember.MgK = localj.wmt;
        localMultiTalkGroupMember.reason = localj.wmu;
        localMultiTalkGroupMember.status = 20;
        if (localj.mStatus == 1) {
          localMultiTalkGroupMember.status = 10;
        }
        if ((localj.mStatus == 2) || (localj.mStatus == 3)) {
          localMultiTalkGroupMember.status = 1;
        }
        localMultiTalkGroupMember.MfN = ((int)localj.wmv);
        localMultiTalkGroup.MgI.add(localMultiTalkGroupMember);
      }
    }
    AppMethodBeat.o(190434);
    return localMultiTalkGroup;
  }
  
  public final void a(k paramk, LinkedList<aas> paramLinkedList)
  {
    AppMethodBeat.i(190439);
    if (this.wmg != null)
    {
      final ArrayList localArrayList = new ArrayList();
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          aas localaas = (aas)paramLinkedList.next();
          String str = paramk.KX(localaas.Gsd);
          if (str == null)
          {
            ae.i("MicroMsg.Multitalk.ILink2MtCallBack", "onVideoGroupMemberChange: mid:%d NOT exist!!!", new Object[] { Integer.valueOf(localaas.Gsd) });
          }
          else
          {
            a.ap localap = new a.ap();
            localap.pcE = localaas.Gsd;
            localap.FHN = localaas.Gsd;
            localap.MeT = 1;
            if ((localaas.Gse & 0x2) != 0) {
              localap.MeT = 3;
            }
            localap.duC = str;
            localap.MeU = 100;
            if ((localaas.Gse & 0x4) != 0) {
              if ((localaas.Gse & 0x8) != 0) {
                localap.MeU = 102;
              }
            }
            for (;;)
            {
              localArrayList.add(localap);
              break;
              localap.MeU = 101;
              continue;
              localap.MeU = 103;
            }
          }
        }
      }
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(190433);
          if (d.this.wmg != null)
          {
            ae.i("MicroMsg.Multitalk.ILink2MtCallBack", "onVideoGroupMemberChange:%s", new Object[] { localArrayList });
            d.this.wmg.eE(localArrayList);
          }
          AppMethodBeat.o(190433);
        }
      });
    }
    AppMethodBeat.o(190439);
  }
  
  public final void b(final k paramk)
  {
    AppMethodBeat.i(190435);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190426);
        if (d.this.wmg != null)
        {
          MultiTalkGroup localMultiTalkGroup = d.a(paramk);
          d.this.wmg.d(localMultiTalkGroup);
        }
        AppMethodBeat.o(190426);
      }
    });
    AppMethodBeat.o(190435);
  }
  
  public final void bv(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(190436);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190430);
        int i;
        if (d.this.wmg != null)
        {
          int j = paramInt;
          i = j;
          switch (paramInt)
          {
          default: 
            i = j;
          }
        }
        for (;;)
        {
          d.this.wmg.m(i, paramString);
          AppMethodBeat.o(190430);
          return;
          i = -100;
          continue;
          i = -200;
          continue;
          i = -300;
          continue;
          i = -301;
          continue;
          i = -400;
          continue;
          i = -500;
          continue;
          i = -600;
          continue;
          i = -1000;
          continue;
          i = -1100;
          continue;
          i = -1300;
        }
      }
    });
    AppMethodBeat.o(190436);
  }
  
  public final void c(final k paramk)
  {
    AppMethodBeat.i(190437);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190431);
        if (d.this.wmg != null)
        {
          ae.i("MicroMsg.Multitalk.ILink2MtCallBack", "onEnterMultiTalk");
          MultiTalkGroup localMultiTalkGroup = d.a(paramk);
          d.this.wmg.e(localMultiTalkGroup);
        }
        AppMethodBeat.o(190431);
      }
    });
    AppMethodBeat.o(190437);
  }
  
  public final void d(final k paramk)
  {
    AppMethodBeat.i(190438);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190432);
        if (d.this.wmg != null)
        {
          ae.i("MicroMsg.Multitalk.ILink2MtCallBack", "onInviteOrAcceptTimeout");
          MultiTalkGroup localMultiTalkGroup = d.a(paramk);
          d.this.wmg.c(localMultiTalkGroup);
        }
        AppMethodBeat.o(190432);
      }
    });
    AppMethodBeat.o(190438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.d
 * JD-Core Version:    0.7.0.1
 */