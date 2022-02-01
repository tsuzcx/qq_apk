package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.pb.common.b.a.a.a.as;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  q zHj;
  MultiTalkGroup zHk;
  Map<String, Long> zHl;
  
  public d(q paramq)
  {
    AppMethodBeat.i(239006);
    this.zHj = null;
    this.zHk = null;
    this.zHl = new ConcurrentHashMap();
    this.zHj = paramq;
    AppMethodBeat.o(239006);
  }
  
  static MultiTalkGroup a(k paramk)
  {
    AppMethodBeat.i(239007);
    MultiTalkGroup localMultiTalkGroup = new MultiTalkGroup();
    localMultiTalkGroup.RGY = paramk.zHB;
    localMultiTalkGroup.zHE = paramk.zHD;
    if (paramk.zHG == null) {}
    for (Object localObject = "";; localObject = paramk.zHG)
    {
      localMultiTalkGroup.RGZ = ((String)localObject);
      localMultiTalkGroup.zHD = paramk.zHD;
      paramk = paramk.zHF;
      if ((paramk == null) || (paramk.size() <= 0)) {
        break;
      }
      paramk = paramk.iterator();
      while (paramk.hasNext())
      {
        localObject = (j)paramk.next();
        MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
        localMultiTalkGroupMember.RHb = ((j)localObject).goe;
        localMultiTalkGroupMember.RHc = ((j)localObject).zHx;
        localMultiTalkGroupMember.bDZ = ((j)localObject).zHy;
        localMultiTalkGroupMember.status = 20;
        if (((j)localObject).mStatus == 1) {
          localMultiTalkGroupMember.status = 10;
        }
        if ((((j)localObject).mStatus == 2) || (((j)localObject).mStatus == 3)) {
          localMultiTalkGroupMember.status = 1;
        }
        localMultiTalkGroupMember.RGf = ((int)((j)localObject).zHz);
        localMultiTalkGroup.RHa.add(localMultiTalkGroupMember);
      }
    }
    AppMethodBeat.o(239007);
    return localMultiTalkGroup;
  }
  
  public final void a(k paramk, LinkedList<acq> paramLinkedList)
  {
    AppMethodBeat.i(239012);
    if (this.zHj != null)
    {
      final ArrayList localArrayList = new ArrayList();
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          acq localacq = (acq)paramLinkedList.next();
          String str = paramk.QX(localacq.Lnt);
          if (str == null)
          {
            Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onVideoGroupMemberChange: mid:%d NOT exist!!!", new Object[] { Integer.valueOf(localacq.Lnt) });
          }
          else
          {
            a.as localas = new a.as();
            localas.qrD = localacq.Lnt;
            localas.KBb = localacq.Lnt;
            localas.videoStatus = 1;
            if ((localacq.Lnu & 0x2) != 0) {
              localas.videoStatus = 3;
            }
            localas.dLN = str;
            localas.RFm = 100;
            if ((localacq.Lnu & 0x4) != 0) {
              if ((localacq.Lnu & 0x8) != 0) {
                localas.RFm = 102;
              }
            }
            for (;;)
            {
              localArrayList.add(localas);
              paramk.hf(localacq.Lnt, localas.RFm);
              break;
              localas.RFm = 101;
              continue;
              localas.RFm = 103;
            }
          }
        }
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(238997);
          if (d.this.zHj != null)
          {
            Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onVideoGroupMemberChange:%s", new Object[] { localArrayList });
            d.this.zHj.fz(localArrayList);
          }
          AppMethodBeat.o(238997);
        }
      });
    }
    AppMethodBeat.o(239012);
  }
  
  public final void b(final k paramk)
  {
    AppMethodBeat.i(239008);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238996);
        if (d.this.zHj != null)
        {
          MultiTalkGroup localMultiTalkGroup = d.a(paramk);
          d.this.zHj.d(localMultiTalkGroup);
        }
        AppMethodBeat.o(238996);
      }
    });
    AppMethodBeat.o(239008);
  }
  
  public final void bH(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(239009);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239001);
        int i;
        if (d.this.zHj != null)
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
          d.this.zHj.n(i, paramString);
          AppMethodBeat.o(239001);
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
    AppMethodBeat.o(239009);
  }
  
  public final void c(final k paramk)
  {
    AppMethodBeat.i(239010);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239004);
        if (d.this.zHj != null)
        {
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onEnterMultiTalk");
          MultiTalkGroup localMultiTalkGroup = d.a(paramk);
          d.this.zHj.e(localMultiTalkGroup);
        }
        AppMethodBeat.o(239004);
      }
    });
    AppMethodBeat.o(239010);
  }
  
  public final void d(final k paramk)
  {
    AppMethodBeat.i(239011);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239005);
        if (d.this.zHj != null)
        {
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onInviteOrAcceptTimeout");
          MultiTalkGroup localMultiTalkGroup = d.a(paramk);
          d.this.zHj.c(localMultiTalkGroup);
        }
        AppMethodBeat.o(239005);
      }
    });
    AppMethodBeat.o(239011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.d
 * JD-Core Version:    0.7.0.1
 */