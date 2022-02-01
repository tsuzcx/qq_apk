package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.protocal.protobuf.acy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.pb.common.b.a.a.a.ar;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  q Fmu;
  MultiTalkGroup Fmv;
  Map<String, Long> Fmw;
  
  public c(q paramq)
  {
    AppMethodBeat.i(197801);
    this.Fmu = null;
    this.Fmv = null;
    this.Fmw = new ConcurrentHashMap();
    this.Fmu = paramq;
    AppMethodBeat.o(197801);
  }
  
  static MultiTalkGroup a(j paramj)
  {
    AppMethodBeat.i(197805);
    MultiTalkGroup localMultiTalkGroup = new MultiTalkGroup();
    localMultiTalkGroup.ZiE = paramj.FmM;
    localMultiTalkGroup.FmP = paramj.FmO;
    if (paramj.FmR == null) {}
    for (Object localObject = "";; localObject = paramj.FmR)
    {
      localMultiTalkGroup.ZiF = ((String)localObject);
      localMultiTalkGroup.FmO = paramj.FmO;
      paramj = paramj.FmQ;
      if ((paramj == null) || (paramj.size() <= 0)) {
        break;
      }
      paramj = paramj.iterator();
      while (paramj.hasNext())
      {
        localObject = (i)paramj.next();
        MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
        localMultiTalkGroupMember.ZiH = ((i)localObject).iSn;
        localMultiTalkGroupMember.ZiI = ((i)localObject).FmI;
        localMultiTalkGroupMember.bnA = ((i)localObject).FmJ;
        localMultiTalkGroupMember.status = 20;
        if (((i)localObject).mStatus == 1) {
          localMultiTalkGroupMember.status = 10;
        }
        if ((((i)localObject).mStatus == 2) || (((i)localObject).mStatus == 3)) {
          localMultiTalkGroupMember.status = 1;
        }
        localMultiTalkGroupMember.ZhL = ((int)((i)localObject).FmK);
        localMultiTalkGroup.ZiG.add(localMultiTalkGroupMember);
      }
    }
    AppMethodBeat.o(197805);
    return localMultiTalkGroup;
  }
  
  public final void a(j paramj, LinkedList<acy> paramLinkedList)
  {
    AppMethodBeat.i(197816);
    if (this.Fmu != null)
    {
      final ArrayList localArrayList = new ArrayList();
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          acy localacy = (acy)paramLinkedList.next();
          String str = paramj.Xl(localacy.SoO);
          if (str == null)
          {
            Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onVideoGroupMemberChange: mid:%d NOT exist!!!", new Object[] { Integer.valueOf(localacy.SoO) });
          }
          else
          {
            a.ar localar = new a.ar();
            localar.tQm = localacy.SoO;
            localar.RCR = localacy.SoO;
            localar.videoStatus = 1;
            if ((localacy.SoP & 0x2) != 0) {
              localar.videoStatus = 3;
            }
            localar.fEC = str;
            localar.ZgR = 100;
            if ((localacy.SoP & 0x4) != 0) {
              localar.ZgR = 101;
            }
            for (;;)
            {
              localArrayList.add(localar);
              paramj.ik(localacy.SoO, localar.ZgR);
              break;
              if ((localacy.SoP & 0x8) != 0) {
                localar.ZgR = 102;
              } else {
                localar.ZgR = 103;
              }
            }
          }
        }
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203137);
          if (c.this.Fmu != null)
          {
            Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onVideoGroupMemberChange:%s", new Object[] { localArrayList });
            c.this.Fmu.gb(localArrayList);
          }
          AppMethodBeat.o(203137);
        }
      });
    }
    AppMethodBeat.o(197816);
  }
  
  public final void b(final j paramj)
  {
    AppMethodBeat.i(197806);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206435);
        if (c.this.Fmu != null)
        {
          MultiTalkGroup localMultiTalkGroup = c.a(paramj);
          c.this.Fmu.d(localMultiTalkGroup);
        }
        AppMethodBeat.o(206435);
      }
    });
    AppMethodBeat.o(197806);
  }
  
  public final void bF(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(197807);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196282);
        int i;
        if (c.this.Fmu != null)
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
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onErr errorcode:%d, errType:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
          c.this.Fmu.r(i, paramString);
          AppMethodBeat.o(196282);
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
    AppMethodBeat.o(197807);
  }
  
  public final void c(final j paramj)
  {
    AppMethodBeat.i(197808);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202387);
        if (c.this.Fmu != null)
        {
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onEnterMultiTalk");
          MultiTalkGroup localMultiTalkGroup = c.a(paramj);
          c.this.Fmu.e(localMultiTalkGroup);
        }
        AppMethodBeat.o(202387);
      }
    });
    AppMethodBeat.o(197808);
  }
  
  public final void d(final j paramj)
  {
    AppMethodBeat.i(197809);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202764);
        if (c.this.Fmu != null)
        {
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onInviteOrAcceptTimeout");
          MultiTalkGroup localMultiTalkGroup = c.a(paramj);
          c.this.Fmu.c(localMultiTalkGroup);
        }
        AppMethodBeat.o(202764);
      }
    });
    AppMethodBeat.o(197809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.c
 * JD-Core Version:    0.7.0.1
 */