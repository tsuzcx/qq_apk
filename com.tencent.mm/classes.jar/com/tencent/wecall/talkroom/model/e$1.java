package com.tencent.wecall.talkroom.model;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.am;
import com.tencent.pb.common.c.d;
import com.tencent.pb.common.c.g;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.List;

final class e$1
  implements g.a
{
  e$1(e parame) {}
  
  public final void H(String paramString, byte[] paramArrayOfByte)
  {
    int i = 0;
    AppMethodBeat.i(127835);
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "onRcvMultiTalkMsg groupId: ", paramString, " datas size: ", Integer.valueOf(i) });
      if (e.a(this.BAl) != null) {
        e.a(this.BAl);
      }
      AppMethodBeat.o(127835);
      return;
      i = paramArrayOfByte.length;
    }
  }
  
  public final void Tp(int paramInt)
  {
    AppMethodBeat.i(127820);
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onOpeningChannel", Integer.valueOf(paramInt) });
    AppMethodBeat.o(127820);
  }
  
  public final void Tq(int paramInt)
  {
    AppMethodBeat.i(127836);
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onSwitchMultiTalkVideoSuss bitRate: ", Integer.valueOf(paramInt) });
    if (e.a(this.BAl) != null) {
      e.a(this.BAl).bTm();
    }
    AppMethodBeat.o(127836);
  }
  
  public final void a(int paramInt, MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(127832);
    com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "onMisscMultiTalk", paramMultiTalkGroup, " time: ", Integer.valueOf(paramInt) });
    if (e.a(this.BAl) != null)
    {
      e.a(this.BAl).d(paramMultiTalkGroup);
      if (com.tencent.pb.common.a.a.BcA) {
        Toast.makeText(d.tFk, "onMisscMultiTalk ".concat(String.valueOf(paramMultiTalkGroup)), 0).show();
      }
    }
    AppMethodBeat.o(127832);
  }
  
  public final void akV()
  {
    AppMethodBeat.i(127821);
    com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "onInitSeccess" });
    if (com.tencent.pb.common.a.a.BcA) {
      Toast.makeText(d.tFk, "onInitSeccess ", 0).show();
    }
    if (e.a(this.BAl) != null) {
      e.a(this.BAl).bTl();
    }
    AppMethodBeat.o(127821);
  }
  
  public final void b(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(127831);
    com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "onInviteMultiTalk", paramMultiTalkGroup });
    if (e.a(this.BAl) != null)
    {
      e.a(this.BAl).b(paramMultiTalkGroup);
      if (com.tencent.pb.common.a.a.BcA) {
        Toast.makeText(d.tFk, "onInviteMultiTalk ".concat(String.valueOf(paramMultiTalkGroup)), 0).show();
      }
    }
    AppMethodBeat.o(127831);
  }
  
  public final void bTn()
  {
    AppMethodBeat.i(127837);
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onSubscribeLargeVideoSuss" });
    if (e.a(this.BAl) != null) {
      e.a(this.BAl).bTn();
    }
    AppMethodBeat.o(127837);
  }
  
  public final void cp(List<a.am> paramList)
  {
    AppMethodBeat.i(127838);
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onVideoGroupMemberChange videoUserNames: ", paramList });
    if (e.a(this.BAl) != null) {
      e.a(this.BAl).cp(paramList);
    }
    AppMethodBeat.o(127838);
  }
  
  public final void cx(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(127825);
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onExitRoom", paramString, a.dXg().nuW, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(127825);
  }
  
  public final void dXA()
  {
    AppMethodBeat.i(127827);
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onSelfHoldOnBegin" });
    AppMethodBeat.o(127827);
  }
  
  public final void dXB()
  {
    AppMethodBeat.i(127828);
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onSelfHoldOnEnd" });
    AppMethodBeat.o(127828);
  }
  
  public final void dXC()
  {
    AppMethodBeat.i(127834);
    com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "onSendMsgSucc" });
    if (e.a(this.BAl) != null) {
      e.a(this.BAl);
    }
    AppMethodBeat.o(127834);
  }
  
  public final void fM(List<MultiTalkGroup> paramList)
  {
    AppMethodBeat.i(127833);
    com.tencent.pb.common.c.c.i("TalkRoomSdkApi", new Object[] { "onActiveMultiTalkList ", paramList });
    if (e.a(this.BAl) != null) {
      e.a(this.BAl);
    }
    AppMethodBeat.o(127833);
  }
  
  public final void fh(String paramString, int paramInt)
  {
    AppMethodBeat.i(127829);
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onModifyGroupInfo", paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(127829);
  }
  
  public final void g(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(127822);
    Object localObject = a.dXg().nuW;
    String str = null;
    if (paramMultiTalkGroup != null) {
      str = paramMultiTalkGroup.Bhl;
    }
    com.tencent.pb.common.c.c.i("TalkRoomSdkApi", new Object[] { "onMemberChange mGroupId: ", localObject, " groupId: ", str, paramMultiTalkGroup });
    if (com.tencent.pb.common.a.a.BcA) {
      Toast.makeText(d.tFk, "onMemberChange ".concat(String.valueOf(paramMultiTalkGroup)), 0).show();
    }
    int k;
    int j;
    int i;
    if (g.iN(str, (String)localObject))
    {
      c.dXv();
      if ((c.axu((String)localObject)) && (a.dXg().state != 3))
      {
        c.dXv();
        k = c.axv((String)localObject);
        if (k != 104) {
          break label275;
        }
        j = -1602;
        i = 325;
      }
    }
    for (;;)
    {
      com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "onMemberChange isMySelfExit finish ", "stopstatus", Integer.valueOf(j), Integer.valueOf(i), str, " reason: ", Integer.valueOf(k) });
      h.Tt(j);
      a.dXg().BAG.Tx(i);
      localObject = a.dXg();
      i = a.dXg().nTj;
      long l = a.dXg().tFh;
      a.dXg();
      ((f)localObject).a(str, i, l, false, false, false);
      if (e.a(this.BAl) != null) {
        e.a(this.BAl).g(paramMultiTalkGroup);
      }
      AppMethodBeat.o(127822);
      return;
      label275:
      if (k == 2)
      {
        j = -1603;
        i = 326;
      }
      else
      {
        j = -1604;
        i = 328;
      }
    }
  }
  
  public final void jx(boolean paramBoolean)
  {
    AppMethodBeat.i(127830);
    com.tencent.pb.common.c.c.i("TalkRoomSdkApi", new Object[] { "onMuteStateChange", Boolean.valueOf(paramBoolean) });
    if (e.a(this.BAl) != null) {
      e.a(this.BAl).jx(paramBoolean);
    }
    AppMethodBeat.o(127830);
  }
  
  public final void l(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(127823);
    com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "onErr errCode: ", Integer.valueOf(paramInt), " data: ", paramObject });
    if (e.a(this.BAl) != null) {
      e.a(this.BAl).l(paramInt, paramObject);
    }
    AppMethodBeat.o(127823);
  }
  
  public final void onStateChanged(int paramInt)
  {
    AppMethodBeat.i(127826);
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onStateChanged", Integer.valueOf(paramInt) });
    AppMethodBeat.o(127826);
  }
  
  public final void p(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(127819);
    com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "onCreateRoom", paramMultiTalkGroup });
    if (com.tencent.pb.common.a.a.BcA) {
      Toast.makeText(d.tFk, "onCreateRoom ".concat(String.valueOf(paramMultiTalkGroup)), 0).show();
    }
    if (e.a(this.BAl) != null) {
      e.a(this.BAl).e(paramMultiTalkGroup);
    }
    AppMethodBeat.o(127819);
  }
  
  public final void q(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(127824);
    com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "onEnterRoom", paramMultiTalkGroup });
    if (e.a(this.BAl) != null)
    {
      e.a(this.BAl).f(paramMultiTalkGroup);
      if (com.tencent.pb.common.a.a.BcA) {
        Toast.makeText(d.tFk, "onEnterRoom ".concat(String.valueOf(paramMultiTalkGroup)), 0).show();
      }
    }
    AppMethodBeat.o(127824);
  }
  
  public final void zE(int paramInt)
  {
    AppMethodBeat.i(127839);
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ", Integer.valueOf(paramInt) });
    if (e.a(this.BAl) != null) {
      e.a(this.BAl).zE(paramInt);
    }
    AppMethodBeat.o(127839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.e.1
 * JD-Core Version:    0.7.0.1
 */