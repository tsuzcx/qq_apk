package com.tencent.wecall.talkroom.model;

import android.widget.Toast;
import com.tencent.pb.common.b.a.a.am;
import com.tencent.pb.common.c.d;
import com.tencent.pb.common.c.g;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.List;

final class e$1
  implements g.a
{
  e$1(e parame) {}
  
  public final void Kw(int paramInt)
  {
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onOpeningChannel", Integer.valueOf(paramInt) });
  }
  
  public final void Kx(int paramInt)
  {
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onSwitchMultiTalkVideoSuss bitRate: ", Integer.valueOf(paramInt) });
    if (e.a(this.xdD) != null) {
      e.a(this.xdD).bln();
    }
  }
  
  public final void RM()
  {
    com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "onInitSeccess" });
    if (com.tencent.pb.common.a.a.wEZ) {
      Toast.makeText(d.pZI, "onInitSeccess ", 0).show();
    }
    if (e.a(this.xdD) != null) {
      e.a(this.xdD).blm();
    }
  }
  
  public final void a(int paramInt, MultiTalkGroup paramMultiTalkGroup)
  {
    com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "onMisscMultiTalk", paramMultiTalkGroup, " time: ", Integer.valueOf(paramInt) });
    if (e.a(this.xdD) != null)
    {
      e.a(this.xdD).d(paramMultiTalkGroup);
      if (com.tencent.pb.common.a.a.wEZ) {
        Toast.makeText(d.pZI, "onMisscMultiTalk " + paramMultiTalkGroup, 0).show();
      }
    }
  }
  
  public final void b(MultiTalkGroup paramMultiTalkGroup)
  {
    com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "onInviteMultiTalk", paramMultiTalkGroup });
    if (e.a(this.xdD) != null)
    {
      e.a(this.xdD).b(paramMultiTalkGroup);
      if (com.tencent.pb.common.a.a.wEZ) {
        Toast.makeText(d.pZI, "onInviteMultiTalk " + paramMultiTalkGroup, 0).show();
      }
    }
  }
  
  public final void bR(List<a.am> paramList)
  {
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onVideoGroupMemberChange videoUserNames: ", paramList });
    if (e.a(this.xdD) != null) {
      e.a(this.xdD).bR(paramList);
    }
  }
  
  public final void bT(String paramString, boolean paramBoolean)
  {
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onExitRoom", paramString, a.cRq().kWU, Boolean.valueOf(paramBoolean) });
  }
  
  public final void blo()
  {
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onSubscribeLargeVideoSuss" });
    if (e.a(this.xdD) != null) {
      e.a(this.xdD).blo();
    }
  }
  
  public final void cRI()
  {
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onSelfHoldOnBegin" });
  }
  
  public final void cRJ()
  {
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onSelfHoldOnEnd" });
  }
  
  public final void cRK()
  {
    com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "onSendMsgSucc" });
  }
  
  public final void dY(String paramString, int paramInt)
  {
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onModifyGroupInfo", paramString, Integer.valueOf(paramInt) });
  }
  
  public final void eD(List<MultiTalkGroup> paramList)
  {
    com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "onActiveMultiTalkList ", paramList });
  }
  
  public final void g(MultiTalkGroup paramMultiTalkGroup)
  {
    Object localObject = a.cRq().kWU;
    String str = null;
    if (paramMultiTalkGroup != null) {
      str = paramMultiTalkGroup.wJL;
    }
    com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "onMemberChange mGroupId: ", localObject, " groupId: ", str, paramMultiTalkGroup });
    if (com.tencent.pb.common.a.a.wEZ) {
      Toast.makeText(d.pZI, "onMemberChange " + paramMultiTalkGroup, 0).show();
    }
    int k;
    int j;
    int i;
    if (g.gK(str, (String)localObject))
    {
      c.cRC();
      if ((c.agz((String)localObject)) && (a.cRq().state != 3))
      {
        c.cRC();
        k = c.agA((String)localObject);
        if (k != 104) {
          break label276;
        }
        j = -1602;
        i = 325;
      }
    }
    for (;;)
    {
      com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "onMemberChange isMySelfExit finish ", "stopstatus", Integer.valueOf(j), Integer.valueOf(i), str, " reason: ", Integer.valueOf(k) });
      h.KA(j);
      a.cRq().xdZ.KE(i);
      localObject = a.cRq();
      i = a.cRq().lvU;
      long l = a.cRq().xdR;
      boolean bool = a.cRq().pSc;
      ((f)localObject).a(str, i, l, false, false, false);
      if (e.a(this.xdD) != null) {
        e.a(this.xdD).g(paramMultiTalkGroup);
      }
      return;
      label276:
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
  
  public final void hE(boolean paramBoolean)
  {
    com.tencent.pb.common.c.c.w("TalkRoomSdkApi", new Object[] { "onMuteStateChange", Boolean.valueOf(paramBoolean) });
    if (e.a(this.xdD) != null) {
      e.a(this.xdD).hE(paramBoolean);
    }
  }
  
  public final void i(int paramInt, Object paramObject)
  {
    com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "onErr errCode: ", Integer.valueOf(paramInt), " data: ", paramObject });
    if (e.a(this.xdD) != null) {
      e.a(this.xdD).i(paramInt, paramObject);
    }
  }
  
  public final void onStateChanged(int paramInt)
  {
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onStateChanged", Integer.valueOf(paramInt) });
  }
  
  public final void p(MultiTalkGroup paramMultiTalkGroup)
  {
    com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "onCreateRoom", paramMultiTalkGroup });
    if (com.tencent.pb.common.a.a.wEZ) {
      Toast.makeText(d.pZI, "onCreateRoom " + paramMultiTalkGroup, 0).show();
    }
    if (e.a(this.xdD) != null) {
      e.a(this.xdD).e(paramMultiTalkGroup);
    }
  }
  
  public final void q(MultiTalkGroup paramMultiTalkGroup)
  {
    com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "onEnterRoom", paramMultiTalkGroup });
    if (e.a(this.xdD) != null)
    {
      e.a(this.xdD).f(paramMultiTalkGroup);
      if (com.tencent.pb.common.a.a.wEZ) {
        Toast.makeText(d.pZI, "onEnterRoom " + paramMultiTalkGroup, 0).show();
      }
    }
  }
  
  public final void uo(int paramInt)
  {
    com.tencent.pb.common.c.c.d("TalkRoomSdkApi", new Object[] { "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ", Integer.valueOf(paramInt) });
    if (e.a(this.xdD) != null) {
      e.a(this.xdD).uo(paramInt);
    }
  }
  
  public final void z(String paramString, byte[] paramArrayOfByte)
  {
    int i = 0;
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      com.tencent.pb.common.c.c.x("TalkRoomSdkApi", new Object[] { "onRcvMultiTalkMsg groupId: ", paramString, " datas size: ", Integer.valueOf(i) });
      return;
      i = paramArrayOfByte.length;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.e.1
 * JD-Core Version:    0.7.0.1
 */