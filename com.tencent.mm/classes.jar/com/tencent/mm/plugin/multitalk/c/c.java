package com.tencent.mm.plugin.multitalk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.common.b.a.a.a.ab;
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
  p Lix;
  MultiTalkGroup Liy;
  Map<String, Long> Liz;
  
  public c(p paramp)
  {
    AppMethodBeat.i(285132);
    this.Lix = null;
    this.Liy = null;
    this.Liz = new ConcurrentHashMap();
    this.Lix = paramp;
    AppMethodBeat.o(285132);
  }
  
  static MultiTalkGroup a(j paramj)
  {
    AppMethodBeat.i(285143);
    MultiTalkGroup localMultiTalkGroup = new MultiTalkGroup();
    localMultiTalkGroup.ahhf = paramj.LiS;
    localMultiTalkGroup.LiV = paramj.LiU;
    if (paramj.LiX == null) {}
    for (Object localObject = "";; localObject = paramj.LiX)
    {
      localMultiTalkGroup.ahhg = ((String)localObject);
      localMultiTalkGroup.LiU = paramj.LiU;
      paramj = paramj.LiW;
      if ((paramj == null) || (paramj.size() <= 0)) {
        break;
      }
      paramj = paramj.iterator();
      while (paramj.hasNext())
      {
        localObject = (i)paramj.next();
        MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
        localMultiTalkGroupMember.ahhi = ((i)localObject).luk;
        localMultiTalkGroupMember.ahhj = ((i)localObject).LiP;
        localMultiTalkGroupMember.reason = ((i)localObject).EV;
        localMultiTalkGroupMember.status = 20;
        if (((i)localObject).mStatus == 1) {
          localMultiTalkGroupMember.status = 10;
        }
        if ((((i)localObject).mStatus == 2) || (((i)localObject).mStatus == 3)) {
          localMultiTalkGroupMember.status = 1;
        }
        localMultiTalkGroupMember.ahgm = ((int)((i)localObject).LiQ);
        localMultiTalkGroup.ahhh.add(localMultiTalkGroupMember);
      }
    }
    AppMethodBeat.o(285143);
    return localMultiTalkGroup;
  }
  
  public final void a(j paramj, LinkedList<afg> paramLinkedList)
  {
    AppMethodBeat.i(285177);
    if (this.Lix != null)
    {
      final ArrayList localArrayList = new ArrayList();
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          afg localafg = (afg)paramLinkedList.next();
          String str = paramj.abn(localafg.ZnB);
          if (str == null)
          {
            Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onVideoGroupMemberChange: mid:%d NOT exist!!!", new Object[] { Integer.valueOf(localafg.ZnB) });
          }
          else
          {
            a.ar localar = new a.ar();
            localar.wTC = localafg.ZnB;
            localar.Yzt = localafg.ZnB;
            localar.videoStatus = 1;
            if ((localafg.ZnC & 0x2) != 0) {
              localar.videoStatus = 3;
            }
            localar.hJs = str;
            localar.ahfs = 100;
            if ((localafg.ZnC & 0x4) != 0) {
              localar.ahfs = 101;
            }
            for (;;)
            {
              localArrayList.add(localar);
              paramj.jP(localafg.ZnB, localar.ahfs);
              break;
              if ((localafg.ZnC & 0x8) != 0) {
                localar.ahfs = 102;
              } else {
                localar.ahfs = 103;
              }
            }
          }
        }
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(285199);
          if (c.this.Lix != null)
          {
            Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onVideoGroupMemberChange:%s", new Object[] { localArrayList });
            c.this.Lix.iY(localArrayList);
          }
          AppMethodBeat.o(285199);
        }
      });
    }
    AppMethodBeat.o(285177);
  }
  
  public final void b(final j paramj)
  {
    AppMethodBeat.i(285149);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(285205);
        if (c.this.Lix != null)
        {
          MultiTalkGroup localMultiTalkGroup = c.a(paramj);
          c.this.Lix.d(localMultiTalkGroup);
        }
        AppMethodBeat.o(285205);
      }
    });
    AppMethodBeat.o(285149);
  }
  
  public final void c(final int paramInt, final String paramString, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(285154);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(285191);
        int j;
        String str;
        Object localObject;
        int i;
        if (c.this.Lix != null)
        {
          j = paramInt;
          str = paramString;
          localObject = str;
          i = j;
          switch (paramInt)
          {
          default: 
            i = j;
            localObject = str;
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onErr errorcode:%d, errType:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
          c.this.Lix.L(i, localObject);
          AppMethodBeat.o(285191);
          return;
          i = -100;
          localObject = str;
          continue;
          i = -200;
          localObject = str;
          continue;
          i = -300;
          localObject = str;
          continue;
          i = -301;
          localObject = str;
          continue;
          i = -400;
          localObject = str;
          continue;
          i = -500;
          localObject = str;
          continue;
          i = -600;
          localObject = str;
          continue;
          i = -1000;
          localObject = str;
          continue;
          i = -1100;
          localObject = str;
          continue;
          j = -1300;
          localObject = str;
          i = j;
          if (paramArrayOfByte != null)
          {
            localObject = str;
            i = j;
            if (paramArrayOfByte.length == 4)
            {
              localObject = new a.ab();
              ((a.ab)localObject).aheW = Util.byteArrayToInt(paramArrayOfByte);
              i = j;
            }
          }
        }
      }
    });
    AppMethodBeat.o(285154);
  }
  
  public final void c(final j paramj)
  {
    AppMethodBeat.i(285158);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(285140);
        if (c.this.Lix != null)
        {
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onEnterMultiTalk");
          MultiTalkGroup localMultiTalkGroup = c.a(paramj);
          c.this.Lix.e(localMultiTalkGroup);
        }
        AppMethodBeat.o(285140);
      }
    });
    AppMethodBeat.o(285158);
  }
  
  public final void d(final j paramj)
  {
    AppMethodBeat.i(285165);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(285202);
        if (c.this.Lix != null)
        {
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onInviteOrAcceptTimeout");
          MultiTalkGroup localMultiTalkGroup = c.a(paramj);
          c.this.Lix.c(localMultiTalkGroup);
        }
        AppMethodBeat.o(285202);
      }
    });
    AppMethodBeat.o(285165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.c
 * JD-Core Version:    0.7.0.1
 */