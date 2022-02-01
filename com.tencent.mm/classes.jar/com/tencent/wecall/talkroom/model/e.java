package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.b.a.a.a.ap;
import com.tencent.pb.common.b.a.a.a.aq;
import com.tencent.pb.common.b.a.a.a.ar;
import com.tencent.pb.common.system.ConnectReceiver;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.a.j;
import com.tencent.wecall.talkroom.a.k;
import com.tencent.wecall.talkroom.a.l;
import com.tencent.wecall.talkroom.a.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class e
  implements com.tencent.pb.talkroom.sdk.d
{
  private static e ahZN = null;
  private final String TAG;
  private com.tencent.pb.talkroom.sdk.a ahZM;
  private ConnectReceiver ahZO;
  private g.a ahZP;
  
  private e()
  {
    AppMethodBeat.i(62610);
    this.TAG = "TalkRoomSdkApi";
    this.ahZM = null;
    this.ahZO = new ConnectReceiver();
    this.ahZP = new g.a()
    {
      public final void L(int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(62667);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onErr errCode: ", Integer.valueOf(paramAnonymousInt), " data: ", paramAnonymousObject });
        if (e.a(e.this) != null) {
          e.a(e.this).L(paramAnonymousInt, paramAnonymousObject);
        }
        AppMethodBeat.o(62667);
      }
      
      public final void N(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        int i = 0;
        AppMethodBeat.i(62679);
        if (paramAnonymousArrayOfByte == null) {}
        for (;;)
        {
          com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onRcvMultiTalkMsg groupId: ", paramAnonymousString, " datas size: ", Integer.valueOf(i) });
          if (e.a(e.this) != null) {
            e.a(e.this);
          }
          AppMethodBeat.o(62679);
          return;
          i = paramAnonymousArrayOfByte.length;
        }
      }
      
      public final void a(int paramAnonymousInt, MultiTalkGroup paramAnonymousMultiTalkGroup)
      {
        AppMethodBeat.i(62676);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onMisscMultiTalk", paramAnonymousMultiTalkGroup, " time: ", Integer.valueOf(paramAnonymousInt) });
        if (e.a(e.this) != null)
        {
          e.a(e.this).c(paramAnonymousMultiTalkGroup);
          if (com.tencent.pb.common.a.a.ahcp) {
            Toast.makeText(com.tencent.pb.common.c.c.UMe, "onMisscMultiTalk ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
          }
        }
        AppMethodBeat.o(62676);
      }
      
      public final void aF(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(212304);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onDoScreenSharingSecurityCheck ret: ", Integer.valueOf(paramAnonymousInt1), " checkRet: ", Integer.valueOf(paramAnonymousInt2) });
        if (e.a(e.this) != null) {
          e.a(e.this).aF(paramAnonymousString, paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(212304);
      }
      
      public final void aJh(int paramAnonymousInt)
      {
        AppMethodBeat.i(62664);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onOpeningChannel", Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(62664);
      }
      
      public final void aJi(int paramAnonymousInt)
      {
        AppMethodBeat.i(62680);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSwitchMultiTalkVideoSuss bitRate: ", Integer.valueOf(paramAnonymousInt) });
        if (e.a(e.this) != null) {
          e.a(e.this).ggl();
        }
        AppMethodBeat.o(62680);
      }
      
      public final void abC(int paramAnonymousInt)
      {
        AppMethodBeat.i(212303);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSwitchVideoScreenSharingRsp switch_ret: ", Integer.valueOf(paramAnonymousInt) });
        if (e.a(e.this) != null) {
          e.a(e.this).abC(paramAnonymousInt);
        }
        AppMethodBeat.o(212303);
      }
      
      public final void abH(int paramAnonymousInt)
      {
        AppMethodBeat.i(62683);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ", Integer.valueOf(paramAnonymousInt) });
        if (e.a(e.this) != null) {
          e.a(e.this).abH(paramAnonymousInt);
        }
        AppMethodBeat.o(62683);
      }
      
      public final void b(MultiTalkGroup paramAnonymousMultiTalkGroup)
      {
        AppMethodBeat.i(62675);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onInviteMultiTalk", paramAnonymousMultiTalkGroup });
        if (e.a(e.this) != null)
        {
          e.a(e.this).b(paramAnonymousMultiTalkGroup);
          if (com.tencent.pb.common.a.a.ahcp) {
            Toast.makeText(com.tencent.pb.common.c.c.UMe, "onInviteMultiTalk ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
          }
        }
        AppMethodBeat.o(62675);
      }
      
      public final void bNv()
      {
        AppMethodBeat.i(62665);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onInitSeccess" });
        if (com.tencent.pb.common.a.a.ahcp) {
          Toast.makeText(com.tencent.pb.common.c.c.UMe, "onInitSeccess ", 0).show();
        }
        if (e.a(e.this) != null) {
          e.a(e.this).ggk();
        }
        AppMethodBeat.o(62665);
      }
      
      public final void c(MultiTalkGroup paramAnonymousMultiTalkGroup, long paramAnonymousLong)
      {
        AppMethodBeat.i(212281);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onCreateRoom", paramAnonymousMultiTalkGroup });
        if (com.tencent.pb.common.a.a.ahcp) {
          Toast.makeText(com.tencent.pb.common.c.c.UMe, "onCreateRoom ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
        }
        if (e.a(e.this) != null) {
          e.a(e.this).a(paramAnonymousMultiTalkGroup, paramAnonymousLong);
        }
        AppMethodBeat.o(212281);
      }
      
      public final void d(MultiTalkGroup paramAnonymousMultiTalkGroup, long paramAnonymousLong)
      {
        AppMethodBeat.i(212285);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onEnterRoom", paramAnonymousMultiTalkGroup });
        if (e.a(e.this) != null)
        {
          e.a(e.this).b(paramAnonymousMultiTalkGroup, paramAnonymousLong);
          if (com.tencent.pb.common.a.a.ahcp) {
            Toast.makeText(com.tencent.pb.common.c.c.UMe, "onEnterRoom ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
          }
        }
        AppMethodBeat.o(212285);
      }
      
      public final void eI(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(62669);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onExitRoom", paramAnonymousString, a.kdP().IMR, Boolean.valueOf(paramAnonymousBoolean) });
        AppMethodBeat.o(62669);
      }
      
      public final void f(MultiTalkGroup paramAnonymousMultiTalkGroup)
      {
        AppMethodBeat.i(62666);
        Object localObject = a.kdP().IMR;
        String str = null;
        if (paramAnonymousMultiTalkGroup != null) {
          str = paramAnonymousMultiTalkGroup.LiU;
        }
        com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "onMemberChange mGroupId: ", localObject, " groupId: ", str, paramAnonymousMultiTalkGroup });
        if (com.tencent.pb.common.a.a.ahcp) {
          Toast.makeText(com.tencent.pb.common.c.c.UMe, "onMemberChange ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
        }
        int k;
        int j;
        int i;
        if (com.tencent.pb.common.c.f.qz(str, (String)localObject))
        {
          c.ked();
          if ((c.bGJ((String)localObject)) && (a.kdP().state != 3))
          {
            c.ked();
            k = c.bGK((String)localObject);
            if (k != 104) {
              break label275;
            }
            j = -1602;
            i = 325;
          }
        }
        for (;;)
        {
          com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onMemberChange isMySelfExit finish ", "stopstatus", Integer.valueOf(j), Integer.valueOf(i), str, " reason: ", Integer.valueOf(k) });
          h.aJl(j);
          a.kdP().aiat.aJp(i);
          localObject = a.kdP();
          i = a.kdP().JMX;
          long l = a.kdP().UGt;
          a.kdP();
          ((f)localObject).a(str, i, l, false, false, false);
          if (e.a(e.this) != null) {
            e.a(e.this).f(paramAnonymousMultiTalkGroup);
          }
          AppMethodBeat.o(62666);
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
      
      public final void ggm()
      {
        AppMethodBeat.i(62681);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSubscribeLargeVideoSuss" });
        if (e.a(e.this) != null) {
          e.a(e.this).ggm();
        }
        AppMethodBeat.o(62681);
      }
      
      public final void ggn()
      {
        AppMethodBeat.i(183717);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSubscribeGeneralVideoSuss" });
        if (e.a(e.this) != null) {
          e.a(e.this).ggn();
        }
        AppMethodBeat.o(183717);
      }
      
      public final void ggo()
      {
        AppMethodBeat.i(212307);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSubscribeScreenSharingVideoSuss" });
        if (e.a(e.this) != null) {
          e.a(e.this).ggo();
        }
        AppMethodBeat.o(212307);
      }
      
      public final void iY(List<a.ar> paramAnonymousList)
      {
        AppMethodBeat.i(62682);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onVideoGroupMemberChange videoUserNames: ", paramAnonymousList });
        if (e.a(e.this) != null) {
          e.a(e.this).iY(paramAnonymousList);
        }
        AppMethodBeat.o(62682);
      }
      
      public final void jF(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(62673);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onModifyGroupInfo", paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(62673);
      }
      
      public final void keh()
      {
        AppMethodBeat.i(62671);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSelfHoldOnBegin" });
        AppMethodBeat.o(62671);
      }
      
      public final void kei()
      {
        AppMethodBeat.i(62672);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSelfHoldOnEnd" });
        AppMethodBeat.o(62672);
      }
      
      public final void onStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(62670);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onStateChanged", Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(62670);
      }
      
      public final void oz(List<MultiTalkGroup> paramAnonymousList)
      {
        AppMethodBeat.i(62677);
        com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "onActiveMultiTalkList ", paramAnonymousList });
        if (e.a(e.this) != null) {
          e.a(e.this);
        }
        AppMethodBeat.o(62677);
      }
      
      public final void yN(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(62674);
        com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "onMuteStateChange", Boolean.valueOf(paramAnonymousBoolean) });
        if (e.a(e.this) != null) {
          e.a(e.this).yN(paramAnonymousBoolean);
        }
        AppMethodBeat.o(62674);
      }
    };
    AppMethodBeat.o(62610);
  }
  
  public static e keg()
  {
    AppMethodBeat.i(62609);
    if (ahZN == null) {}
    try
    {
      if (ahZN == null) {
        ahZN = new e();
      }
      e locale = ahZN;
      AppMethodBeat.o(62609);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(62609);
    }
  }
  
  public static void oK(Context paramContext)
  {
    AppMethodBeat.i(62611);
    com.tencent.pb.common.c.c.UMe = paramContext;
    com.tencent.f.i.oE(paramContext);
    AppMethodBeat.o(62611);
  }
  
  public final boolean Op(boolean paramBoolean)
  {
    AppMethodBeat.i(62624);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "holadMultiTalk isHold", Boolean.valueOf(paramBoolean) });
    f localf;
    if (paramBoolean)
    {
      localf = a.kdP();
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "startHoldOn" });
      localf.aiaP = true;
      localf.yL(false);
      com.tencent.pb.common.c.g.runOnMainThread(new g.14(localf.aiaB));
    }
    for (;;)
    {
      AppMethodBeat.o(62624);
      return true;
      localf = a.kdP();
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "endHoldOn" });
      localf.aiaP = false;
      localf.kel();
      if ((localf.hWB()) && (localf.Kfr))
      {
        localf.yL(true);
        com.tencent.pb.common.c.g.runOnMainThread(new g.15(localf.aiaB));
      }
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.f S(int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(62630);
    com.tencent.pb.talkroom.sdk.f localf = a.kdP().S(paramArrayOfInt);
    if (paramArrayOfInt == null) {}
    for (;;)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "receiveVideo imgBuffer size: ", Integer.valueOf(i), " MultiTalkVideoDecodeInfo: ", localf });
      AppMethodBeat.o(62630);
      return localf;
      i = paramArrayOfInt.length;
    }
  }
  
  public final boolean X(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(62619);
    if (!com.tencent.pb.common.c.f.qz(paramString, a.kdP().IMR))
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "addMultiTalkMember groupid is not same; multiTalkGroupid: ", paramString, a.kdP().IMR });
      AppMethodBeat.o(62619);
      return false;
    }
    f localf = a.kdP();
    int j = localf.JMX;
    long l = localf.UGt;
    int i;
    boolean bool;
    if (paramList == null)
    {
      i = 0;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "addrTalkRoomMember", paramString, Integer.valueOf(j), Long.valueOf(l), " users length: ", Integer.valueOf(i) });
      localf.aiaH = false;
      if ((!TextUtils.isEmpty(paramString)) && (paramList != null)) {
        break label184;
      }
      bool = false;
    }
    for (;;)
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "addMultiTalkMember ret: ", Boolean.valueOf(bool) });
      AppMethodBeat.o(62619);
      return bool;
      i = paramList.size();
      break;
      label184:
      if (!com.tencent.pb.common.b.h.isNetworkConnected())
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "addTalkRoomMember isNetworkConnected is false" });
        bool = false;
      }
      else
      {
        paramList = f.oA(paramList);
        if ((paramList == null) || (paramList.length <= 0))
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "addTalkRoomMember users is null" });
          bool = false;
        }
        else
        {
          paramString = new com.tencent.wecall.talkroom.a.b(paramString, localf.JMX, localf.UGt, paramList);
          bool = com.tencent.pb.common.b.e.jQX().b(paramString);
          localf.aiat.ai(new String[] { "add", "req", String.valueOf(bool), String.valueOf(localf.state) });
        }
      }
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.f a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(212311);
    paramArrayOfInt = a.kdP().a(paramArrayOfByte, paramArrayOfInt, paramInt);
    if (paramArrayOfByte == null) {}
    for (paramInt = i;; paramInt = paramArrayOfByte.length)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "receiveScreen imgBuffer size: ", Integer.valueOf(paramInt), " MultiTalkVideoDecodeInfo: ", paramArrayOfInt });
      AppMethodBeat.o(212311);
      return paramArrayOfInt;
    }
  }
  
  public final boolean a(com.tencent.pb.talkroom.sdk.a parama, com.tencent.pb.talkroom.sdk.e parame)
  {
    AppMethodBeat.i(62612);
    if (com.tencent.pb.common.c.c.UMe == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "init fail context: ", com.tencent.pb.common.c.c.UMe });
      AppMethodBeat.o(62612);
      return false;
    }
    try
    {
      this.ahZM = parama;
      f.a(parame);
      parama = a.kdP();
      g.a locala = this.ahZP;
      parama.aiaB.a(locala);
      com.tencent.pb.common.b.f.jRa().ahda = parame;
      a.kdO();
      a.kdQ();
      parama = new IntentFilter();
      parama.setPriority(2147483647);
      parama.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      com.tencent.pb.common.c.c.UMe.registerReceiver(this.ahZO, parama);
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "init" });
      AppMethodBeat.o(62612);
      return true;
    }
    catch (Exception parama)
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "init ", parama });
      AppMethodBeat.o(62612);
    }
    return false;
  }
  
  public final boolean a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(212290);
    paramString3 = a.kdP().a(paramString1, paramInt1, paramLong, paramInt2, 100, paramString2, paramString3);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "enterMultiTalk multiTalkGroupid:", paramString1, " roomId: ", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " routId: ", Integer.valueOf(paramInt2), " wxGroupId: ", paramString2, " ret: ", paramString3 });
    if (paramString3 == f.b.aibu)
    {
      AppMethodBeat.o(212290);
      return true;
    }
    AppMethodBeat.o(212290);
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, List<String> paramList, String paramString3)
  {
    AppMethodBeat.i(212287);
    f localf = a.kdP();
    localf.aiak = paramString3;
    paramString3 = f.oA(paramList);
    int i;
    label53:
    int j;
    if (paramString3.length > 0)
    {
      if (TextUtils.isEmpty(null)) {
        break label316;
      }
      throw new NullPointerException();
      if (paramString3 != null) {
        break label345;
      }
      i = 0;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom cliendId: ", paramString1, " voiceSingle2MultiInfo: ", null, " memeberUuids size: ", Integer.valueOf(i), "routeId", Integer.valueOf(j), " context: ", null, " type: ", Integer.valueOf(0), " playId: ", Long.valueOf(0L), " sdkKey: ", null });
      if (com.tencent.pb.a.a.a.jRs()) {
        break label353;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.jRs()), " isBindMobile: ", Boolean.valueOf(com.tencent.pb.a.a.a.jRt()) });
      h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "noAuth" });
    }
    for (;;)
    {
      paramString1 = null;
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "createTalkRoom clientId is: ", paramString1, "wXgroupId: ", paramString2, " creatorUsrName: ", com.tencent.pb.a.a.a.jRr(), " usrnameList: ", paramList });
      if (paramString1 == null) {
        break label1083;
      }
      AppMethodBeat.o(212287);
      return true;
      label316:
      j = new Random().nextInt() << 16 | com.tencent.pb.a.a.a.jRr().hashCode() & 0xFFFF;
      break;
      label345:
      i = paramString3.length;
      break label53;
      label353:
      if (!com.tencent.pb.common.b.h.isNetworkConnected())
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom isNetworkConnected is false" });
        h.aJn(-4003);
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "noNetwork" });
      }
      else if (localf.hWB())
      {
        if (localf.hWB()) {
          h.aJn(-4002);
        }
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "isBusy" });
      }
      else if (TextUtils.isEmpty(paramString1))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom cliendId is null" });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "cliendIdnull" });
      }
      else if (!i.bGS(paramString1))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom groupId is not cliend id: ", paramString1 });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "isnotcliendId" });
      }
      else
      {
        if (c.ked().bGE(paramString1) == null) {
          c.ked().f(paramString1, paramString2, paramString3);
        }
        localf.aiat.reset();
        localf.OL(false);
        if (!localf.kek())
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom initService fail" });
          h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "initServicefail" });
          localf.OL(false);
        }
        else
        {
          if (localf.hCI()) {
            break label777;
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom initEngine fail" });
          h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "initEnginefail" });
          localf.OL(false);
        }
      }
    }
    label777:
    localf.aiat.keA();
    localf.IMR = paramString1;
    localf.aiaF = paramString1;
    localf.ahcO = j;
    localf.aiac = paramString1;
    localf.setState(1);
    localf.Uxb = true;
    Object localObject = new f.a(localf);
    ((f.a)localObject).groupId = localf.IMR;
    ((f.a)localObject).aibo = paramString3;
    ((f.a)localObject).aibp = null;
    ((f.a)localObject).ahdy = j;
    ((f.a)localObject).type = 0;
    ((f.a)localObject).aibq = 0L;
    ((f.a)localObject).aibr = null;
    ((f.a)localObject).aibs = false;
    ((f.a)localObject).aibt = paramString2;
    paramString3 = Message.obtain();
    paramString3.what = 2;
    paramString3.obj = localObject;
    localf.mHandler.removeMessages(2);
    localObject = c.ked().bGE(localf.IMR);
    if (localObject == null) {
      com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup talkroom is null" });
    }
    for (;;)
    {
      localf.mHandler.sendMessage(paramString3);
      localf.aiaH = true;
      break;
      localObject = ((TalkRoom)localObject).kdV();
      if ((localObject == null) || (((List)localObject).size() != 1))
      {
        com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup TalkRoomMember list is not match" });
      }
      else
      {
        localObject = (d)((List)localObject).get(0);
        if (localObject == null) {
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup talkRoomMember is null" });
        } else {
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup ret: ", Boolean.valueOf(((d)localObject).isSelf()) });
        }
      }
    }
    label1083:
    AppMethodBeat.o(212287);
    return false;
  }
  
  public final boolean aMT(String paramString)
  {
    AppMethodBeat.i(62620);
    if (!com.tencent.pb.common.c.f.qz(paramString, a.kdP().IMR))
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "exitMultiTalk groupid is not same; multiTalkGroupid: ", paramString, a.kdP().IMR });
      f.e locale;
      f localf;
      if (a.kdP().bGN(paramString))
      {
        locale = a.kdP().bGM(paramString);
        localf = a.kdP();
        if (locale != null) {
          break label103;
        }
        i = 0;
        if (locale != null) {
          break label112;
        }
      }
      label103:
      label112:
      for (l = 0L;; l = locale.Hnt)
      {
        localf.c(paramString, i, l, 1);
        AppMethodBeat.o(62620);
        return false;
        i = locale.roomId;
        break;
      }
    }
    int i = a.kdP().JMX;
    long l = a.kdP().UGt;
    boolean bool = a.kdP().bk(paramString, 1, 100);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "exitMultiTalk groupId: ", paramString, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(l) });
    AppMethodBeat.o(62620);
    return bool;
  }
  
  public final boolean aNl(String paramString)
  {
    AppMethodBeat.i(62628);
    if (!a.kdP().hWB())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "subscribeLargeVideo isWorking is false" });
      AppMethodBeat.o(62628);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "subscribeLargeVideo ownerUserName: ", paramString });
    f localf = a.kdP();
    if (TextUtils.isEmpty(localf.IMR))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "subscribeLargeVideo mGroupId null " });
      AppMethodBeat.o(62628);
      return false;
    }
    paramString = new k(localf.IMR, localf.JMX, localf.UGt, paramString);
    boolean bool = com.tencent.pb.common.b.e.jQX().b(paramString);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "subscribeLargeVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62628);
    return bool;
  }
  
  public final boolean abI(int paramInt)
  {
    AppMethodBeat.i(62627);
    if (!a.kdP().hWB())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "switchMultiTalkVideo isWorking is false" });
      AppMethodBeat.o(62627);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "switchMultiTalkVideo action: ", Integer.valueOf(paramInt) });
    Object localObject = a.kdP();
    if (TextUtils.isEmpty(((f)localObject).IMR))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "switchMultiTalkVideo mGroupId is null" });
      AppMethodBeat.o(62627);
      return false;
    }
    ((f)localObject).aial = paramInt;
    localObject = new m(((f)localObject).IMR, ((f)localObject).JMX, ((f)localObject).UGt, paramInt, ((f)localObject).aiab, 0, null, null);
    boolean bool = com.tencent.pb.common.b.e.jQX().b((com.tencent.pb.common.b.d)localObject);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "switchMultiTalkVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62627);
    return bool;
  }
  
  public final com.tencent.pb.talkroom.sdk.g b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    int j = 0;
    AppMethodBeat.i(62631);
    com.tencent.pb.talkroom.sdk.g localg = a.kdP().b(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    int i;
    if (paramArrayOfByte == null)
    {
      i = 0;
      if (paramArrayOfInt != null) {
        break label144;
      }
    }
    for (;;)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "videoTrans recordData size: ", Integer.valueOf(i), " len: ", Integer.valueOf(paramInt1), " localImg size: ", Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), " multiTalkVideoRGBinfo: ", localg });
      AppMethodBeat.o(62631);
      return localg;
      i = paramArrayOfByte.length;
      break;
      label144:
      j = paramArrayOfInt.length;
    }
  }
  
  public final List<String> bFm(String paramString)
  {
    AppMethodBeat.i(62621);
    if (!com.tencent.pb.common.c.f.qz(paramString, a.kdP().IMR))
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "getTalkingMember groupid is not same; multiTalkGroupid: ", paramString, a.kdP().IMR });
      AppMethodBeat.o(62621);
      return null;
    }
    Object localObject1 = c.ked().bGE(paramString);
    if (localObject1 == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getTalkingMember talkroom is null: groupId: ", paramString });
      AppMethodBeat.o(62621);
      return null;
    }
    localObject1 = ((TalkRoom)localObject1).kdW();
    if (localObject1 == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getTalkingMember mems is null: groupId: ", paramString });
      AppMethodBeat.o(62621);
      return null;
    }
    paramString = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    label263:
    label266:
    for (;;)
    {
      d locald;
      Object localObject2;
      int i;
      if (((Iterator)localObject1).hasNext())
      {
        locald = (d)((Iterator)localObject1).next();
        if (locald == null) {
          continue;
        }
        localObject2 = a.kdP();
        i = locald.getMemberId();
        if (((f)localObject2).aiau == null) {
          break label263;
        }
        localObject2 = ((f)localObject2).aiau;
        if ((!com.tencent.pb.common.a.a.ahcq) || (((b)localObject2).ahZE == null)) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label266;
        }
        paramString.add(locald.kef());
        break;
        if (((b)localObject2).ahZE.GetVoiceActivity(i) > 0)
        {
          i = 1;
        }
        else
        {
          i = 0;
          continue;
          AppMethodBeat.o(62621);
          return paramString;
          i = 0;
        }
      }
    }
  }
  
  public final Map<String, Integer> bFn(String paramString)
  {
    AppMethodBeat.i(212301);
    if (!com.tencent.pb.common.c.f.qz(paramString, a.kdP().IMR))
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "getTalkingEnergyMember groupid is not same; multiTalkGroupid: ", paramString, a.kdP().IMR });
      AppMethodBeat.o(212301);
      return null;
    }
    Object localObject1 = c.ked().bGE(paramString);
    if (localObject1 == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getTalkingMember talkroom is null: groupId: ", paramString });
      AppMethodBeat.o(212301);
      return null;
    }
    Object localObject2 = ((TalkRoom)localObject1).kdW();
    if (localObject2 == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getTalkingMember mems is null: groupId: ", paramString });
      AppMethodBeat.o(212301);
      return null;
    }
    localObject1 = new HashMap();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      d locald = (d)((Iterator)localObject2).next();
      if (locald != null)
      {
        f localf = a.kdP();
        int i = locald.getMemberId();
        paramString = Integer.valueOf(0);
        if (localf.aiau != null)
        {
          paramString = localf.aiau;
          if ((com.tencent.pb.common.a.a.ahcq) && (paramString.ahZE != null)) {
            break label254;
          }
        }
        label254:
        for (paramString = Integer.valueOf(0);; paramString = Integer.valueOf(paramString.ahZE.GetVoiceActivity(i)))
        {
          i = paramString.intValue();
          if (i <= 0) {
            break;
          }
          ((Map)localObject1).put(locald.kef(), Integer.valueOf(i));
          break;
        }
      }
    }
    AppMethodBeat.o(212301);
    return localObject1;
  }
  
  public final boolean bFo(String paramString)
  {
    AppMethodBeat.i(212306);
    if (!a.kdP().hWB())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "DoScreenSharingSecurityCheck isWorking is false" });
      AppMethodBeat.o(212306);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "DoScreenSharingSecurityCheck fileMd5: ", paramString, " fileId: ", null });
    f localf = a.kdP();
    if (TextUtils.isEmpty(localf.IMR))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "DoScreenSharingSecurityCheck mGroupId is null" });
      AppMethodBeat.o(212306);
      return false;
    }
    paramString = new m(localf.IMR, localf.JMX, localf.UGt, 103, localf.aiab, 0, paramString, null);
    boolean bool = com.tencent.pb.common.b.e.jQX().b(paramString);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "DoScreenSharingSecurityCheck ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(212306);
    return bool;
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(212310);
    int j;
    if (paramArrayOfByte == null)
    {
      i = 0;
      com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "sendScreen buffer size: ", Integer.valueOf(i), " len: ", Integer.valueOf(paramInt1), " w: ", Integer.valueOf(paramInt2), " h: ", Integer.valueOf(paramInt3), " format: ", Integer.valueOf(paramInt4) });
      j = a.kdP().c(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
      if (paramArrayOfByte != null) {
        break label231;
      }
    }
    label231:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "sendScreen buffer size: ", Integer.valueOf(i), " len: ", Integer.valueOf(paramInt1), " w: ", Integer.valueOf(paramInt2), " h: ", Integer.valueOf(paramInt3), " format: ", Integer.valueOf(paramInt4), " ret: ", Integer.valueOf(j) });
      AppMethodBeat.o(212310);
      return j;
      i = paramArrayOfByte.length;
      break;
    }
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(212309);
    int j = a.kdP().c(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "sendVideo buffer size: ", Integer.valueOf(i), " len: ", Integer.valueOf(paramInt1), " w: ", Integer.valueOf(paramInt2), " h: ", Integer.valueOf(paramInt3), " format: ", Integer.valueOf(paramInt4), " mode: ", Integer.valueOf(paramInt5) });
      AppMethodBeat.o(212309);
      return j;
    }
  }
  
  public final boolean d(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62622);
    int i;
    if (paramArrayOfByte == null)
    {
      i = 0;
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "handleMultiTalkResp retCode: ", Integer.valueOf(paramInt1), " seq: ", Integer.valueOf(paramInt2), " cmdId: ", Integer.valueOf(paramInt3), " data length: ", Integer.valueOf(i) });
      if (paramInt1 != 0) {
        break label109;
      }
      com.tencent.pb.common.b.f.jRa().w(paramInt2, paramArrayOfByte);
    }
    for (;;)
    {
      AppMethodBeat.o(62622);
      return true;
      i = paramArrayOfByte.length;
      break;
      label109:
      paramArrayOfByte = com.tencent.pb.common.b.f.jRa();
      com.tencent.pb.common.b.f.a locala = paramArrayOfByte.aGR(paramInt2);
      if (locala != null)
      {
        com.tencent.pb.common.c.b.w("NETCMD", new Object[] { "CLTRCV FAIL", Integer.valueOf(paramInt2), locala.ahdd, Integer.valueOf(1), Integer.valueOf(paramInt1) });
        paramArrayOfByte.a(locala, -1, null);
      }
    }
  }
  
  public final boolean ds(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62623);
    com.tencent.pb.common.b.f.jRa();
    int i = com.tencent.pb.common.b.f.dr(paramArrayOfByte);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "handleMultiTalkNotify ret: ", Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(62623);
      return true;
    }
    AppMethodBeat.o(62623);
    return false;
  }
  
  public final void em(int paramInt, String paramString)
  {
    AppMethodBeat.i(62626);
    com.tencent.pb.a.a.a.aGS(paramInt);
    com.tencent.pb.a.a.a.bFl(paramString);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "setWxUinAndUsrName uin: ", Integer.valueOf(paramInt), " usrname: ", paramString });
    AppMethodBeat.o(62626);
  }
  
  public final boolean jRu()
  {
    AppMethodBeat.i(62615);
    try
    {
      com.tencent.pb.common.c.b.jRp();
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "setOpenLog: isOpenSdkLog", Boolean.TRUE, " level: ", Integer.valueOf(0) });
      AppMethodBeat.o(62615);
      return true;
    }
    finally
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "setOpenLog: ", localObject });
      AppMethodBeat.o(62615);
    }
    return false;
  }
  
  public final String jRv()
  {
    AppMethodBeat.i(62625);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("client_");
    ((StringBuilder)localObject).append(com.tencent.pb.a.a.a.jRr());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = ((StringBuilder)localObject).toString();
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "genMultiTalkClientId clientId: ", localObject });
    AppMethodBeat.o(62625);
    return localObject;
  }
  
  public final boolean ja(List<a.aq> paramList)
  {
    AppMethodBeat.i(183716);
    if (!a.kdP().hWB())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "subscribeGeneralVideo isWorking is false" });
      AppMethodBeat.o(183716);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "subscribeGeneralVideo memberListInfo: ", paramList });
    f localf = a.kdP();
    if (TextUtils.isEmpty(localf.IMR))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "subscribeGeneralVideo mGroupId null " });
      AppMethodBeat.o(183716);
      return false;
    }
    paramList = new j(localf.IMR, localf.JMX, localf.UGt, paramList);
    boolean bool = com.tencent.pb.common.b.e.jQX().b(paramList);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "subscribeGeneralVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(183716);
    return bool;
  }
  
  public final boolean n(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(212288);
    f localf = a.kdP();
    localf.aiak = paramString3;
    paramString2 = localf.a(paramString1, localf.JMX, localf.UGt, paramInt, 1, paramString2, paramString3);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "enterMultiTalk multiTalkGroupid:", paramString1, " isAccept: ", Boolean.TRUE, " routId: ", Integer.valueOf(paramInt), " ret: ", paramString2 });
    if (paramString2 == f.b.aibu)
    {
      AppMethodBeat.o(212288);
      return true;
    }
    AppMethodBeat.o(212288);
    return false;
  }
  
  public final boolean ot(List<a.ap> paramList)
  {
    AppMethodBeat.i(212308);
    if (!a.kdP().hWB())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "subscribeScreenSharingVideoForUserList isWorking is false" });
      AppMethodBeat.o(212308);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "subscribeScreenSharingVideoForUserList memberListInfo: ", paramList });
    f localf = a.kdP();
    if (TextUtils.isEmpty(localf.IMR))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "subscribeScreenSharingVideo mGroupId null " });
      AppMethodBeat.o(212308);
      return false;
    }
    paramList = new l(localf.IMR, localf.JMX, localf.UGt, paramList);
    boolean bool = com.tencent.pb.common.b.e.jQX().b(paramList);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "subscribeScreenSharingVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(212308);
    return bool;
  }
  
  public final int screenTrans(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(212313);
    paramInt1 = a.kdP().screenTrans(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramArrayOfByte2, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.o(212313);
    return paramInt1;
  }
  
  public final int setAppCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = -1;
    AppMethodBeat.i(62632);
    Object localObject = a.kdP();
    if (((f)localObject).aiau == null) {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "setAppCmd type: ", Integer.valueOf(paramInt1), " engine is null" });
    }
    for (;;)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "setAppCmd type: ", Integer.valueOf(paramInt1), " paramLen: ", Integer.valueOf(paramInt2), " ret: ", Integer.valueOf(i) });
      AppMethodBeat.o(62632);
      return i;
      localObject = ((f)localObject).aiau;
      if ((paramArrayOfByte == null) || (((b)localObject).ahZE == null)) {
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:setAppCmd null, params:", paramArrayOfByte, ", engine:", ((b)localObject).ahZE });
      } else {
        i = ((b)localObject).ahZE.setAppCmd(paramInt1, paramArrayOfByte, paramInt2);
      }
    }
  }
  
  public final void zb(boolean paramBoolean)
  {
    AppMethodBeat.i(62614);
    a.kdP();
    com.tencent.pb.talkroom.sdk.e locale = f.kex();
    if (locale != null) {}
    for (boolean bool = locale.yT(paramBoolean);; bool = false)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "switchSpeakerPhone", Boolean.valueOf(paramBoolean), " ret: ", Boolean.valueOf(bool), " realret: ", Boolean.valueOf(f.kew()), " wxCallBack: ", locale });
      AppMethodBeat.o(62614);
      return;
    }
  }
  
  public final void zc(boolean paramBoolean)
  {
    AppMethodBeat.i(62613);
    f localf = a.kdP();
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "setMute isMute: ", Boolean.valueOf(paramBoolean) });
    localf.mIsMute = paramBoolean;
    com.tencent.pb.common.c.g.runOnMainThread(new g.17(localf.aiaB, paramBoolean));
    AppMethodBeat.o(62613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.e
 * JD-Core Version:    0.7.0.1
 */