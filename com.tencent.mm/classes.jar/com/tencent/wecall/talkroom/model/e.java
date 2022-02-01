package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.b.a.a.a.aq;
import com.tencent.pb.common.b.a.a.a.ar;
import com.tencent.pb.common.b.a.a.a.as;
import com.tencent.pb.common.system.ConnectReceiver;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.a.k;
import com.tencent.wecall.talkroom.a.l;
import com.tencent.wecall.talkroom.a.m;
import com.tencent.wecall.talkroom.a.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class e
  implements com.tencent.pb.talkroom.sdk.d
{
  private static e Sus = null;
  private com.tencent.pb.talkroom.sdk.a Sur;
  private ConnectReceiver Sut;
  private g.a Suu;
  private final String TAG;
  
  private e()
  {
    AppMethodBeat.i(62610);
    this.TAG = "TalkRoomSdkApi";
    this.Sur = null;
    this.Sut = new ConnectReceiver();
    this.Suu = new g.a()
    {
      public final void F(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
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
      
      public final void Rd(int paramAnonymousInt)
      {
        AppMethodBeat.i(199679);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSwitchVideoScreenSharingRsp switch_ret: ", Integer.valueOf(paramAnonymousInt) });
        if (e.a(e.this) != null) {
          e.a(e.this).Rd(paramAnonymousInt);
        }
        AppMethodBeat.o(199679);
      }
      
      public final void Ri(int paramAnonymousInt)
      {
        AppMethodBeat.i(62683);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ", Integer.valueOf(paramAnonymousInt) });
        if (e.a(e.this) != null) {
          e.a(e.this).Ri(paramAnonymousInt);
        }
        AppMethodBeat.o(62683);
      }
      
      public final void a(int paramAnonymousInt, MultiTalkGroup paramAnonymousMultiTalkGroup)
      {
        AppMethodBeat.i(62676);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onMisscMultiTalk", paramAnonymousMultiTalkGroup, " time: ", Integer.valueOf(paramAnonymousInt) });
        if (e.a(e.this) != null)
        {
          e.a(e.this).c(paramAnonymousMultiTalkGroup);
          if (com.tencent.pb.common.a.a.RCj) {
            Toast.makeText(com.tencent.pb.common.c.c.Hhs, "onMisscMultiTalk ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
          }
        }
        AppMethodBeat.o(62676);
      }
      
      public final void asG(int paramAnonymousInt)
      {
        AppMethodBeat.i(62664);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onOpeningChannel", Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(62664);
      }
      
      public final void asH(int paramAnonymousInt)
      {
        AppMethodBeat.i(62680);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSwitchMultiTalkVideoSuss bitRate: ", Integer.valueOf(paramAnonymousInt) });
        if (e.a(e.this) != null) {
          e.a(e.this).enF();
        }
        AppMethodBeat.o(62680);
      }
      
      public final void b(MultiTalkGroup paramAnonymousMultiTalkGroup)
      {
        AppMethodBeat.i(62675);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onInviteMultiTalk", paramAnonymousMultiTalkGroup });
        if (e.a(e.this) != null)
        {
          e.a(e.this).b(paramAnonymousMultiTalkGroup);
          if (com.tencent.pb.common.a.a.RCj) {
            Toast.makeText(com.tencent.pb.common.c.c.Hhs, "onInviteMultiTalk ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
          }
        }
        AppMethodBeat.o(62675);
      }
      
      public final void bgz()
      {
        AppMethodBeat.i(62665);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onInitSeccess" });
        if (com.tencent.pb.common.a.a.RCj) {
          Toast.makeText(com.tencent.pb.common.c.c.Hhs, "onInitSeccess ", 0).show();
        }
        if (e.a(e.this) != null) {
          e.a(e.this).enE();
        }
        AppMethodBeat.o(62665);
      }
      
      public final void dH(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(62669);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onExitRoom", paramAnonymousString, a.hqJ().xOr, Boolean.valueOf(paramAnonymousBoolean) });
        AppMethodBeat.o(62669);
      }
      
      public final void enG()
      {
        AppMethodBeat.i(62681);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSubscribeLargeVideoSuss" });
        if (e.a(e.this) != null) {
          e.a(e.this).enG();
        }
        AppMethodBeat.o(62681);
      }
      
      public final void enH()
      {
        AppMethodBeat.i(183717);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSubscribeGeneralVideoSuss" });
        if (e.a(e.this) != null) {
          e.a(e.this).enH();
        }
        AppMethodBeat.o(183717);
      }
      
      public final void enI()
      {
        AppMethodBeat.i(199680);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSubscribeScreenSharingVideoSuss" });
        if (e.a(e.this) != null) {
          e.a(e.this).enI();
        }
        AppMethodBeat.o(199680);
      }
      
      public final void f(MultiTalkGroup paramAnonymousMultiTalkGroup)
      {
        AppMethodBeat.i(62666);
        Object localObject = a.hqJ().xOr;
        String str = null;
        if (paramAnonymousMultiTalkGroup != null) {
          str = paramAnonymousMultiTalkGroup.zHD;
        }
        com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "onMemberChange mGroupId: ", localObject, " groupId: ", str, paramAnonymousMultiTalkGroup });
        if (com.tencent.pb.common.a.a.RCj) {
          Toast.makeText(com.tencent.pb.common.c.c.Hhs, "onMemberChange ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
        }
        int k;
        int j;
        int i;
        if (com.tencent.pb.common.c.f.nG(str, (String)localObject))
        {
          c.hqY();
          if ((c.brl((String)localObject)) && (a.hqJ().state != 3))
          {
            c.hqY();
            k = c.brm((String)localObject);
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
          h.asK(j);
          a.hqJ().SuY.asO(i);
          localObject = a.hqJ();
          i = a.hqJ().yvK;
          long l = a.hqJ().HgX;
          a.hqJ();
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
      
      public final void fz(List<a.as> paramAnonymousList)
      {
        AppMethodBeat.i(62682);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onVideoGroupMemberChange videoUserNames: ", paramAnonymousList });
        if (e.a(e.this) != null) {
          e.a(e.this).fz(paramAnonymousList);
        }
        AppMethodBeat.o(62682);
      }
      
      public final void hK(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(62673);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onModifyGroupInfo", paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(62673);
      }
      
      public final void hrc()
      {
        AppMethodBeat.i(62671);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSelfHoldOnBegin" });
        AppMethodBeat.o(62671);
      }
      
      public final void hrd()
      {
        AppMethodBeat.i(62672);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSelfHoldOnEnd" });
        AppMethodBeat.o(62672);
      }
      
      public final void hre()
      {
        AppMethodBeat.i(62678);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onSendMsgSucc" });
        if (e.a(e.this) != null) {
          e.a(e.this);
        }
        AppMethodBeat.o(62678);
      }
      
      public final void ki(List<MultiTalkGroup> paramAnonymousList)
      {
        AppMethodBeat.i(62677);
        com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "onActiveMultiTalkList ", paramAnonymousList });
        if (e.a(e.this) != null) {
          e.a(e.this);
        }
        AppMethodBeat.o(62677);
      }
      
      public final void n(int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(62667);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onErr errCode: ", Integer.valueOf(paramAnonymousInt), " data: ", paramAnonymousObject });
        if (e.a(e.this) != null) {
          e.a(e.this).n(paramAnonymousInt, paramAnonymousObject);
        }
        AppMethodBeat.o(62667);
      }
      
      public final void onStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(62670);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onStateChanged", Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(62670);
      }
      
      public final void p(MultiTalkGroup paramAnonymousMultiTalkGroup)
      {
        AppMethodBeat.i(62663);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onCreateRoom", paramAnonymousMultiTalkGroup });
        if (com.tencent.pb.common.a.a.RCj) {
          Toast.makeText(com.tencent.pb.common.c.c.Hhs, "onCreateRoom ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
        }
        if (e.a(e.this) != null) {
          e.a(e.this).d(paramAnonymousMultiTalkGroup);
        }
        AppMethodBeat.o(62663);
      }
      
      public final void q(MultiTalkGroup paramAnonymousMultiTalkGroup)
      {
        AppMethodBeat.i(62668);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onEnterRoom", paramAnonymousMultiTalkGroup });
        if (e.a(e.this) != null)
        {
          e.a(e.this).e(paramAnonymousMultiTalkGroup);
          if (com.tencent.pb.common.a.a.RCj) {
            Toast.makeText(com.tencent.pb.common.c.c.Hhs, "onEnterRoom ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
          }
        }
        AppMethodBeat.o(62668);
      }
      
      public final void rv(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(62674);
        com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "onMuteStateChange", Boolean.valueOf(paramAnonymousBoolean) });
        if (e.a(e.this) != null) {
          e.a(e.this).rv(paramAnonymousBoolean);
        }
        AppMethodBeat.o(62674);
      }
    };
    AppMethodBeat.o(62610);
  }
  
  public static e hrb()
  {
    AppMethodBeat.i(62609);
    if (Sus == null) {}
    try
    {
      if (Sus == null) {
        Sus = new e();
      }
      e locale = Sus;
      AppMethodBeat.o(62609);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(62609);
    }
  }
  
  public static void lw(Context paramContext)
  {
    AppMethodBeat.i(62611);
    com.tencent.pb.common.c.c.Hhs = paramContext;
    i.lq(paramContext);
    AppMethodBeat.o(62611);
  }
  
  public final boolean DM(boolean paramBoolean)
  {
    AppMethodBeat.i(62624);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "holadMultiTalk isHold", Boolean.valueOf(paramBoolean) });
    f localf;
    if (paramBoolean)
    {
      localf = a.hqJ();
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "startHoldOn" });
      localf.Svu = true;
      localf.rt(false);
      com.tencent.pb.common.c.g.runOnMainThread(new g.14(localf.Svg));
    }
    for (;;)
    {
      AppMethodBeat.o(62624);
      return true;
      localf = a.hqJ();
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "endHoldOn" });
      localf.Svu = false;
      localf.hrh();
      if ((localf.fGt()) && (localf.yIP))
      {
        localf.rt(true);
        com.tencent.pb.common.c.g.runOnMainThread(new g.15(localf.Svg));
      }
    }
  }
  
  public final boolean Q(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(62619);
    if (!com.tencent.pb.common.c.f.nG(paramString, a.hqJ().xOr))
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "addMultiTalkMember groupid is not same; multiTalkGroupid: ", paramString, a.hqJ().xOr });
      AppMethodBeat.o(62619);
      return false;
    }
    f localf = a.hqJ();
    int j = localf.yvK;
    long l = localf.HgX;
    int i;
    boolean bool;
    if (paramList == null)
    {
      i = 0;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "addrTalkRoomMember", paramString, Integer.valueOf(j), Long.valueOf(l), " users length: ", Integer.valueOf(i) });
      localf.Svm = false;
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
        paramList = f.kj(paramList);
        if (paramList.length <= 0)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "addTalkRoomMember users is null" });
          bool = false;
        }
        else
        {
          paramString = new com.tencent.wecall.talkroom.a.b(paramString, localf.yvK, localf.HgX, paramList);
          bool = com.tencent.pb.common.b.e.hiW().a(paramString);
          localf.SuY.ag(new String[] { "add", "req", String.valueOf(bool), String.valueOf(localf.state) });
        }
      }
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.f R(int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(62630);
    com.tencent.pb.talkroom.sdk.f localf = a.hqJ().R(paramArrayOfInt);
    if (paramArrayOfInt == null) {}
    for (;;)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "receiveVideo imgBuffer size: ", Integer.valueOf(i), " MultiTalkVideoDecodeInfo: ", localf });
      AppMethodBeat.o(62630);
      return localf;
      i = paramArrayOfInt.length;
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.f a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(199677);
    paramArrayOfInt = a.hqJ().a(paramArrayOfByte, paramArrayOfInt, paramInt);
    if (paramArrayOfByte == null) {}
    for (paramInt = i;; paramInt = paramArrayOfByte.length)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "receiveScreen imgBuffer size: ", Integer.valueOf(paramInt), " MultiTalkVideoDecodeInfo: ", paramArrayOfInt });
      AppMethodBeat.o(199677);
      return paramArrayOfInt;
    }
  }
  
  public final boolean a(com.tencent.pb.talkroom.sdk.a parama, com.tencent.pb.talkroom.sdk.e parame)
  {
    AppMethodBeat.i(62612);
    if (com.tencent.pb.common.c.c.Hhs == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "init fail context: ", com.tencent.pb.common.c.c.Hhs });
      AppMethodBeat.o(62612);
      return false;
    }
    try
    {
      this.Sur = parama;
      f.a(parame);
      parama = a.hqJ();
      g.a locala = this.Suu;
      parama.Svg.a(locala);
      com.tencent.pb.common.b.f.hiZ().RCV = parame;
      a.hqI();
      a.hqK();
      parama = new IntentFilter();
      parama.setPriority(2147483647);
      parama.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      com.tencent.pb.common.c.c.Hhs.registerReceiver(this.Sut, parama);
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
  
  public final boolean a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, int paramInt3)
  {
    AppMethodBeat.i(183715);
    f.b localb = a.hqJ().a(paramString1, paramInt1, paramLong, paramInt2, 100, paramString2, paramInt3);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "enterMultiTalk multiTalkGroupid:", paramString1, " roomId: ", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " routId: ", Integer.valueOf(paramInt2), " wxGroupId: ", paramString2, " ret: ", localb });
    if (localb == f.b.SvZ)
    {
      AppMethodBeat.o(183715);
      return true;
    }
    AppMethodBeat.o(183715);
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(183713);
    f localf = a.hqJ();
    localf.SuP = paramInt;
    Object localObject1 = f.kj(paramList);
    if (localObject1.length > 0)
    {
      if (TextUtils.isEmpty(null)) {
        break label309;
      }
      throw new NullPointerException();
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom cliendId: ", paramString1, " voiceSingle2MultiInfo: ", null, " memeberUuids size: ", Integer.valueOf(localObject1.length), "routeId", Integer.valueOf(paramInt), " context: ", null, " type: ", Integer.valueOf(0), " playId: ", Long.valueOf(0L), " sdkKey: ", null });
      if (com.tencent.pb.a.a.a.hjr()) {
        break label338;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.hjr()), " isBindMobile: ", Boolean.valueOf(com.tencent.pb.a.a.a.hjs()) });
      h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "noAuth" });
    }
    for (;;)
    {
      paramString1 = null;
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "createTalkRoom clientId is: ", paramString1, "wXgroupId: ", paramString2, " creatorUsrName: ", com.tencent.pb.a.a.a.hjq(), " usrnameList: ", paramList });
      if (paramString1 == null) {
        break label1006;
      }
      AppMethodBeat.o(183713);
      return true;
      label309:
      paramInt = new Random().nextInt() << 16 | com.tencent.pb.a.a.a.hjq().hashCode() & 0xFFFF;
      break;
      label338:
      if (!com.tencent.pb.common.b.h.isNetworkConnected())
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom isNetworkConnected is false" });
        h.asM(-4003);
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "noNetwork" });
      }
      else if (localf.fGt())
      {
        if (localf.fGt()) {
          h.asM(-4002);
        }
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "isBusy" });
      }
      else if (TextUtils.isEmpty(paramString1))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom cliendId is null" });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "cliendIdnull" });
      }
      else if (!j.bru(paramString1))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom groupId is not cliend id: ", paramString1 });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "isnotcliendId" });
      }
      else
      {
        if (c.hqY().brg(paramString1) == null) {
          c.hqY().e(paramString1, paramString2, (String[])localObject1);
        }
        localf.SuY.reset();
        localf.Eh(false);
        localf.hrg();
        if (localf.fuf()) {
          break label700;
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom initEngine fail" });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "initEnginefail" });
        localf.Eh(false);
      }
    }
    label700:
    localf.SuY.hrv();
    localf.xOr = paramString1;
    localf.Svk = paramString1;
    localf.RCJ = paramInt;
    localf.SuH = paramString1;
    localf.setState(1);
    localf.GUf = true;
    Object localObject2 = new f.a(localf);
    ((f.a)localObject2).groupId = localf.xOr;
    ((f.a)localObject2).SvT = ((String[])localObject1);
    ((f.a)localObject2).SvU = null;
    ((f.a)localObject2).RDt = paramInt;
    ((f.a)localObject2).type = 0;
    ((f.a)localObject2).SvV = 0L;
    ((f.a)localObject2).SvW = null;
    ((f.a)localObject2).SvX = false;
    ((f.a)localObject2).SvY = paramString2;
    localObject1 = Message.obtain();
    ((Message)localObject1).what = 2;
    ((Message)localObject1).obj = localObject2;
    localf.mHandler.removeMessages(2);
    localObject2 = c.hqY().brg(localf.xOr);
    if (localObject2 == null) {
      com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup talkroom is null" });
    }
    for (;;)
    {
      localf.mHandler.sendMessage((Message)localObject1);
      localf.Svm = true;
      break;
      localObject2 = ((TalkRoom)localObject2).hqP();
      if ((localObject2 == null) || (((List)localObject2).size() != 1))
      {
        com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup TalkRoomMember list is not match" });
      }
      else
      {
        localObject2 = (d)((List)localObject2).get(0);
        if (localObject2 == null) {
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup talkRoomMember is null" });
        } else {
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup ret: ", Boolean.valueOf(((d)localObject2).isSelf()) });
        }
      }
    }
    label1006:
    AppMethodBeat.o(183713);
    return false;
  }
  
  public final boolean aFM(String paramString)
  {
    AppMethodBeat.i(62620);
    if (!com.tencent.pb.common.c.f.nG(paramString, a.hqJ().xOr))
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "exitMultiTalk groupid is not same; multiTalkGroupid: ", paramString, a.hqJ().xOr });
      f.e locale;
      f localf;
      if (a.hqJ().brp(paramString))
      {
        locale = a.hqJ().bro(paramString);
        localf = a.hqJ();
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
      for (l = 0L;; l = locale.ypH)
      {
        localf.c(paramString, i, l, 1);
        AppMethodBeat.o(62620);
        return false;
        i = locale.roomId;
        break;
      }
    }
    int i = a.hqJ().yvK;
    long l = a.hqJ().HgX;
    boolean bool = a.hqJ().aY(paramString, 1, 100);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "exitMultiTalk groupId: ", paramString, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(l) });
    AppMethodBeat.o(62620);
    return bool;
  }
  
  public final boolean aGe(String paramString)
  {
    AppMethodBeat.i(62628);
    if (!a.hqJ().fGt())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "subscribeLargeVideo isWorking is false" });
      AppMethodBeat.o(62628);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "subscribeLargeVideo ownerUserName: ", paramString });
    f localf = a.hqJ();
    if (TextUtils.isEmpty(localf.xOr))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "subscribeLargeVideo mGroupId null " });
      AppMethodBeat.o(62628);
      return false;
    }
    paramString = new l(localf.xOr, localf.yvK, localf.HgX, paramString);
    boolean bool = com.tencent.pb.common.b.e.hiW().a(paramString);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "subscribeLargeVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62628);
    return bool;
  }
  
  public final boolean aqv(int paramInt)
  {
    AppMethodBeat.i(62627);
    if (!a.hqJ().fGt())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "switchMultiTalkVideo isWorking is false" });
      AppMethodBeat.o(62627);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "switchMultiTalkVideo action: ", Integer.valueOf(paramInt) });
    Object localObject = a.hqJ();
    if (TextUtils.isEmpty(((f)localObject).xOr))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "switchMultiTalkVideo mGroupId is null" });
      AppMethodBeat.o(62627);
      return false;
    }
    ((f)localObject).SuQ = paramInt;
    localObject = new n(((f)localObject).xOr, ((f)localObject).yvK, ((f)localObject).HgX, paramInt);
    boolean bool = com.tencent.pb.common.b.e.hiW().a((com.tencent.pb.common.b.d)localObject);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "switchMultiTalkVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62627);
    return bool;
  }
  
  public final com.tencent.pb.talkroom.sdk.g b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    int j = 0;
    AppMethodBeat.i(62631);
    com.tencent.pb.talkroom.sdk.g localg = a.hqJ().b(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
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
  
  public final List<String> bpM(String paramString)
  {
    AppMethodBeat.i(62621);
    if (!com.tencent.pb.common.c.f.nG(paramString, a.hqJ().xOr))
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "getTalkingMember groupid is not same; multiTalkGroupid: ", paramString, a.hqJ().xOr });
      AppMethodBeat.o(62621);
      return null;
    }
    Object localObject1 = c.hqY().brg(paramString);
    if (localObject1 == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getTalkingMember talkroom is null: groupId: ", paramString });
      AppMethodBeat.o(62621);
      return null;
    }
    localObject1 = ((TalkRoom)localObject1).hqQ();
    paramString = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    label231:
    label234:
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
        localObject2 = a.hqJ();
        i = locald.getMemberId();
        if (((f)localObject2).SuZ == null) {
          break label231;
        }
        localObject2 = ((f)localObject2).SuZ;
        if ((!com.tencent.pb.common.a.a.RCk) || (((b)localObject2).Suj == null)) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label234;
        }
        paramString.add(locald.hra());
        break;
        if (((b)localObject2).Suj.GetVoiceActivity(i) > 0)
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
  
  public final Map<String, Integer> bpN(String paramString)
  {
    AppMethodBeat.i(199673);
    if (!com.tencent.pb.common.c.f.nG(paramString, a.hqJ().xOr))
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "getTalkingEnergyMember groupid is not same; multiTalkGroupid: ", paramString, a.hqJ().xOr });
      AppMethodBeat.o(199673);
      return null;
    }
    Object localObject = c.hqY().brg(paramString);
    if (localObject == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getTalkingMember talkroom is null: groupId: ", paramString });
      AppMethodBeat.o(199673);
      return null;
    }
    paramString = ((TalkRoom)localObject).hqQ();
    localObject = new HashMap();
    Iterator localIterator = paramString.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald != null)
      {
        f localf = a.hqJ();
        int i = locald.getMemberId();
        paramString = Integer.valueOf(0);
        if (localf.SuZ != null)
        {
          paramString = localf.SuZ;
          if ((com.tencent.pb.common.a.a.RCk) && (paramString.Suj != null)) {
            break label219;
          }
        }
        label219:
        for (paramString = Integer.valueOf(0);; paramString = Integer.valueOf(paramString.Suj.GetVoiceActivity(i)))
        {
          i = paramString.intValue();
          if (i <= 0) {
            break;
          }
          ((Map)localObject).put(locald.hra(), Integer.valueOf(i));
          break;
        }
      }
    }
    AppMethodBeat.o(199673);
    return localObject;
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(199675);
    int j = a.hqJ().c(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "sendVideo buffer size: ", Integer.valueOf(i), " len: ", Integer.valueOf(paramInt1), " w: ", Integer.valueOf(paramInt2), " h: ", Integer.valueOf(paramInt3), " format: ", Integer.valueOf(paramInt4), " mode: ", Integer.valueOf(paramInt5) });
      AppMethodBeat.o(199675);
      return j;
    }
  }
  
  public final boolean c(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(183714);
    f localf = a.hqJ();
    localf.SuP = paramInt2;
    paramString2 = localf.a(paramString1, localf.yvK, localf.HgX, paramInt1, 1, paramString2, paramInt2);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "enterMultiTalk multiTalkGroupid:", paramString1, " isAccept: ", Boolean.TRUE, " routId: ", Integer.valueOf(paramInt1), " ret: ", paramString2 });
    if (paramString2 == f.b.SvZ)
    {
      AppMethodBeat.o(183714);
      return true;
    }
    AppMethodBeat.o(183714);
    return false;
  }
  
  public final boolean cR(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62623);
    com.tencent.pb.common.b.f.hiZ();
    int i = com.tencent.pb.common.b.f.cQ(paramArrayOfByte);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "handleMultiTalkNotify ret: ", Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(62623);
      return true;
    }
    AppMethodBeat.o(62623);
    return false;
  }
  
  public final int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(199676);
    int j;
    if (paramArrayOfByte == null)
    {
      i = 0;
      com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "sendScreen buffer size: ", Integer.valueOf(i), " len: ", Integer.valueOf(paramInt1), " w: ", Integer.valueOf(paramInt2), " h: ", Integer.valueOf(paramInt3), " format: ", Integer.valueOf(paramInt4) });
      j = a.hqJ().d(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
      if (paramArrayOfByte != null) {
        break label231;
      }
    }
    label231:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "sendScreen buffer size: ", Integer.valueOf(i), " len: ", Integer.valueOf(paramInt1), " w: ", Integer.valueOf(paramInt2), " h: ", Integer.valueOf(paramInt3), " format: ", Integer.valueOf(paramInt4), " ret: ", Integer.valueOf(j) });
      AppMethodBeat.o(199676);
      return j;
      i = paramArrayOfByte.length;
      break;
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
      com.tencent.pb.common.b.f.hiZ().u(paramInt2, paramArrayOfByte);
    }
    for (;;)
    {
      AppMethodBeat.o(62622);
      return true;
      i = paramArrayOfByte.length;
      break;
      label109:
      paramArrayOfByte = com.tencent.pb.common.b.f.hiZ();
      com.tencent.pb.common.b.f.a locala = paramArrayOfByte.aqt(paramInt2);
      if (locala != null)
      {
        com.tencent.pb.common.c.b.w("NETCMD", new Object[] { "CLTRCV FAIL", Integer.valueOf(paramInt2), locala.RCY, Integer.valueOf(1), Integer.valueOf(paramInt1) });
        paramArrayOfByte.a(locala, -1, null);
      }
    }
  }
  
  public final void dr(int paramInt, String paramString)
  {
    AppMethodBeat.i(62626);
    com.tencent.pb.a.a.a.aqu(paramInt);
    com.tencent.pb.a.a.a.bpL(paramString);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "setWxUinAndUsrName uin: ", Integer.valueOf(paramInt), " usrname: ", paramString });
    AppMethodBeat.o(62626);
  }
  
  public final boolean fB(List<a.ar> paramList)
  {
    AppMethodBeat.i(183716);
    if (!a.hqJ().fGt())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "subscribeGeneralVideo isWorking is false" });
      AppMethodBeat.o(183716);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "subscribeGeneralVideo memberListInfo: ", paramList });
    f localf = a.hqJ();
    if (TextUtils.isEmpty(localf.xOr))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "subscribeGeneralVideo mGroupId null " });
      AppMethodBeat.o(183716);
      return false;
    }
    paramList = new k(localf.xOr, localf.yvK, localf.HgX, paramList);
    boolean bool = com.tencent.pb.common.b.e.hiW().a(paramList);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "subscribeGeneralVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(183716);
    return bool;
  }
  
  public final boolean hjt()
  {
    AppMethodBeat.i(62615);
    try
    {
      com.tencent.pb.common.c.b.hjo();
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "setOpenLog: isOpenSdkLog", Boolean.TRUE, " level: ", Integer.valueOf(0) });
      AppMethodBeat.o(62615);
      return true;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "setOpenLog: ", localThrowable });
      AppMethodBeat.o(62615);
    }
    return false;
  }
  
  public final String hju()
  {
    AppMethodBeat.i(62625);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("client_");
    ((StringBuilder)localObject).append(com.tencent.pb.a.a.a.hjq());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = ((StringBuilder)localObject).toString();
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "genMultiTalkClientId clientId: ", localObject });
    AppMethodBeat.o(62625);
    return localObject;
  }
  
  public final boolean kc(List<a.aq> paramList)
  {
    AppMethodBeat.i(199674);
    if (!a.hqJ().fGt())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "subscribeScreenSharingVideoForUserList isWorking is false" });
      AppMethodBeat.o(199674);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "subscribeScreenSharingVideoForUserList memberListInfo: ", paramList });
    f localf = a.hqJ();
    if (TextUtils.isEmpty(localf.xOr))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "subscribeScreenSharingVideo mGroupId null " });
      AppMethodBeat.o(199674);
      return false;
    }
    paramList = new m(localf.xOr, localf.yvK, localf.HgX, paramList);
    boolean bool = com.tencent.pb.common.b.e.hiW().a(paramList);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "subscribeScreenSharingVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(199674);
    return bool;
  }
  
  public final void rJ(boolean paramBoolean)
  {
    AppMethodBeat.i(62614);
    a.hqJ();
    com.tencent.pb.talkroom.sdk.e locale = f.hrt();
    if (locale != null) {}
    for (boolean bool = locale.rB(paramBoolean);; bool = false)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "switchSpeakerPhone", Boolean.valueOf(paramBoolean), " ret: ", Boolean.valueOf(bool), " realret: ", Boolean.valueOf(f.hrs()), " wxCallBack: ", locale });
      AppMethodBeat.o(62614);
      return;
    }
  }
  
  public final void rK(boolean paramBoolean)
  {
    AppMethodBeat.i(62613);
    f localf = a.hqJ();
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "setMute isMute: ", Boolean.valueOf(paramBoolean) });
    localf.mIsMute = paramBoolean;
    com.tencent.pb.common.c.g.runOnMainThread(new g.17(localf.Svg, paramBoolean));
    AppMethodBeat.o(62613);
  }
  
  public final int screenTrans(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(199678);
    paramInt1 = a.hqJ().screenTrans(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramArrayOfByte2, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.o(199678);
    return paramInt1;
  }
  
  public final int setAppCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = -1;
    AppMethodBeat.i(62632);
    Object localObject = a.hqJ();
    if (((f)localObject).SuZ == null) {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "setAppCmd type: ", Integer.valueOf(paramInt1), " engine is null" });
    }
    for (;;)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "setAppCmd type: ", Integer.valueOf(paramInt1), " paramLen: ", Integer.valueOf(paramInt2), " ret: ", Integer.valueOf(i) });
      AppMethodBeat.o(62632);
      return i;
      localObject = ((f)localObject).SuZ;
      if ((paramArrayOfByte == null) || (((b)localObject).Suj == null)) {
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:setAppCmd null, params:", paramArrayOfByte, ", engine:", ((b)localObject).Suj });
      } else {
        i = ((b)localObject).Suj.setAppCmd(paramInt1, paramArrayOfByte, paramInt2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.e
 * JD-Core Version:    0.7.0.1
 */