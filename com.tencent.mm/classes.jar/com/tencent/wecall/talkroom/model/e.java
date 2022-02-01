package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.b.a.a.a.ao;
import com.tencent.pb.common.b.a.a.a.ap;
import com.tencent.pb.common.system.ConnectReceiver;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.a.k;
import com.tencent.wecall.talkroom.a.l;
import com.tencent.wecall.talkroom.a.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class e
  implements com.tencent.pb.talkroom.sdk.d
{
  private static e IJj = null;
  private com.tencent.pb.talkroom.sdk.a IJi;
  private ConnectReceiver IJk;
  private g.a IJl;
  private final String TAG;
  
  private e()
  {
    AppMethodBeat.i(62610);
    this.TAG = "TalkRoomSdkApi";
    this.IJi = null;
    this.IJk = new ConnectReceiver();
    this.IJl = new g.a()
    {
      public final void E(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
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
      
      public final void Hh(int paramAnonymousInt)
      {
        AppMethodBeat.i(62683);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ", Integer.valueOf(paramAnonymousInt) });
        if (e.a(e.this) != null) {
          e.a(e.this).Hh(paramAnonymousInt);
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
          if (com.tencent.pb.common.a.a.Ijw) {
            Toast.makeText(com.tencent.pb.common.c.c.ztG, "onMisscMultiTalk ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
          }
        }
        AppMethodBeat.o(62676);
      }
      
      public final void aCb()
      {
        AppMethodBeat.i(62665);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onInitSeccess" });
        if (com.tencent.pb.common.a.a.Ijw) {
          Toast.makeText(com.tencent.pb.common.c.c.ztG, "onInitSeccess ", 0).show();
        }
        if (e.a(e.this) != null) {
          e.a(e.this).cSp();
        }
        AppMethodBeat.o(62665);
      }
      
      public final void acS(int paramAnonymousInt)
      {
        AppMethodBeat.i(62664);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onOpeningChannel", Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(62664);
      }
      
      public final void acT(int paramAnonymousInt)
      {
        AppMethodBeat.i(62680);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSwitchMultiTalkVideoSuss bitRate: ", Integer.valueOf(paramAnonymousInt) });
        if (e.a(e.this) != null) {
          e.a(e.this).cSq();
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
          if (com.tencent.pb.common.a.a.Ijw) {
            Toast.makeText(com.tencent.pb.common.c.c.ztG, "onInviteMultiTalk ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
          }
        }
        AppMethodBeat.o(62675);
      }
      
      public final void cSr()
      {
        AppMethodBeat.i(62681);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSubscribeLargeVideoSuss" });
        if (e.a(e.this) != null) {
          e.a(e.this).cSr();
        }
        AppMethodBeat.o(62681);
      }
      
      public final void cSs()
      {
        AppMethodBeat.i(183717);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSubscribeGeneralVideoSuss" });
        if (e.a(e.this) != null) {
          e.a(e.this).cSs();
        }
        AppMethodBeat.o(183717);
      }
      
      public final void cZ(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(62669);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onExitRoom", paramAnonymousString, a.fpu().seB, Boolean.valueOf(paramAnonymousBoolean) });
        AppMethodBeat.o(62669);
      }
      
      public final void ei(List<a.ap> paramAnonymousList)
      {
        AppMethodBeat.i(62682);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onVideoGroupMemberChange videoUserNames: ", paramAnonymousList });
        if (e.a(e.this) != null) {
          e.a(e.this).ei(paramAnonymousList);
        }
        AppMethodBeat.o(62682);
      }
      
      public final void f(MultiTalkGroup paramAnonymousMultiTalkGroup)
      {
        AppMethodBeat.i(62666);
        Object localObject = a.fpu().seB;
        String str = null;
        if (paramAnonymousMultiTalkGroup != null) {
          str = paramAnonymousMultiTalkGroup.Iog;
        }
        com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "onMemberChange mGroupId: ", localObject, " groupId: ", str, paramAnonymousMultiTalkGroup });
        if (com.tencent.pb.common.a.a.Ijw) {
          Toast.makeText(com.tencent.pb.common.c.c.ztG, "onMemberChange ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
        }
        int k;
        int j;
        int i;
        if (com.tencent.pb.common.c.f.lO(str, (String)localObject))
        {
          c.fpJ();
          if ((c.aOu((String)localObject)) && (a.fpu().state != 3))
          {
            c.fpJ();
            k = c.aOv((String)localObject);
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
          h.acW(j);
          a.fpu().IJO.ada(i);
          localObject = a.fpu();
          i = a.fpu().sHe;
          long l = a.fpu().ztl;
          a.fpu();
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
      
      public final void fpO()
      {
        AppMethodBeat.i(62671);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSelfHoldOnBegin" });
        AppMethodBeat.o(62671);
      }
      
      public final void fpP()
      {
        AppMethodBeat.i(62672);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSelfHoldOnEnd" });
        AppMethodBeat.o(62672);
      }
      
      public final void fpQ()
      {
        AppMethodBeat.i(62678);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onSendMsgSucc" });
        if (e.a(e.this) != null) {
          e.a(e.this);
        }
        AppMethodBeat.o(62678);
      }
      
      public final void gC(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(62673);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onModifyGroupInfo", paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(62673);
      }
      
      public final void ir(List<MultiTalkGroup> paramAnonymousList)
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
      
      public final void ns(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(62674);
        com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "onMuteStateChange", Boolean.valueOf(paramAnonymousBoolean) });
        if (e.a(e.this) != null) {
          e.a(e.this).ns(paramAnonymousBoolean);
        }
        AppMethodBeat.o(62674);
      }
      
      public final void o(MultiTalkGroup paramAnonymousMultiTalkGroup)
      {
        AppMethodBeat.i(62663);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onCreateRoom", paramAnonymousMultiTalkGroup });
        if (com.tencent.pb.common.a.a.Ijw) {
          Toast.makeText(com.tencent.pb.common.c.c.ztG, "onCreateRoom ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
        }
        if (e.a(e.this) != null) {
          e.a(e.this).d(paramAnonymousMultiTalkGroup);
        }
        AppMethodBeat.o(62663);
      }
      
      public final void onStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(62670);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onStateChanged", Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(62670);
      }
      
      public final void p(MultiTalkGroup paramAnonymousMultiTalkGroup)
      {
        AppMethodBeat.i(62668);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onEnterRoom", paramAnonymousMultiTalkGroup });
        if (e.a(e.this) != null)
        {
          e.a(e.this).e(paramAnonymousMultiTalkGroup);
          if (com.tencent.pb.common.a.a.Ijw) {
            Toast.makeText(com.tencent.pb.common.c.c.ztG, "onEnterRoom ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
          }
        }
        AppMethodBeat.o(62668);
      }
    };
    AppMethodBeat.o(62610);
  }
  
  public static e fpN()
  {
    AppMethodBeat.i(62609);
    if (IJj == null) {}
    try
    {
      if (IJj == null) {
        IJj = new e();
      }
      e locale = IJj;
      AppMethodBeat.o(62609);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(62609);
    }
  }
  
  public static void kQ(Context paramContext)
  {
    AppMethodBeat.i(62611);
    com.tencent.pb.common.c.c.ztG = paramContext;
    i.kO(paramContext);
    AppMethodBeat.o(62611);
  }
  
  public final boolean Hi(int paramInt)
  {
    AppMethodBeat.i(62627);
    if (!a.fpu().dSZ())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "switchMultiTalkVideo isWorking is false" });
      AppMethodBeat.o(62627);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "switchMultiTalkVideo action: ", Integer.valueOf(paramInt) });
    Object localObject = a.fpu();
    if (TextUtils.isEmpty(((f)localObject).seB))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "switchMultiTalkVideo mGroupId is null" });
      AppMethodBeat.o(62627);
      return false;
    }
    ((f)localObject).IJH = paramInt;
    localObject = new m(((f)localObject).seB, ((f)localObject).sHe, ((f)localObject).ztl, paramInt);
    boolean bool = com.tencent.pb.common.b.e.fll().a((com.tencent.pb.common.b.d)localObject);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "switchMultiTalkVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62627);
    return bool;
  }
  
  public final com.tencent.pb.talkroom.sdk.f J(int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(62630);
    com.tencent.pb.talkroom.sdk.f localf = a.fpu().J(paramArrayOfInt);
    if (paramArrayOfInt == null) {}
    for (;;)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "receiveVideo imgBuffer size: ", Integer.valueOf(i), " MultiTalkVideoDecodeInfo: ", localf });
      AppMethodBeat.o(62630);
      return localf;
      i = paramArrayOfInt.length;
    }
  }
  
  public final boolean K(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(62619);
    if (!com.tencent.pb.common.c.f.lO(paramString, a.fpu().seB))
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "addMultiTalkMember groupid is not same; multiTalkGroupid: ", paramString, a.fpu().seB });
      AppMethodBeat.o(62619);
      return false;
    }
    f localf = a.fpu();
    int j = localf.sHe;
    long l = localf.ztl;
    int i;
    boolean bool;
    if (paramList == null)
    {
      i = 0;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "addrTalkRoomMember", paramString, Integer.valueOf(j), Long.valueOf(l), " users length: ", Integer.valueOf(i) });
      localf.IKc = false;
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
        paramList = f.is(paramList);
        if (paramList.length <= 0)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "addTalkRoomMember users is null" });
          bool = false;
        }
        else
        {
          paramString = new com.tencent.wecall.talkroom.a.b(paramString, localf.sHe, localf.ztl, paramList);
          bool = com.tencent.pb.common.b.e.fll().a(paramString);
          localf.IJO.ad(new String[] { "add", "req", String.valueOf(bool), String.valueOf(localf.state) });
        }
      }
    }
  }
  
  public final int a(byte[] paramArrayOfByte, short paramShort, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62629);
    int j = a.fpu().a(paramArrayOfByte, paramShort, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "sendVideo buffer size: ", Integer.valueOf(i), " len: ", Short.valueOf(paramShort), " w: ", Integer.valueOf(paramInt1), " h: ", Integer.valueOf(paramInt2), " format: ", Integer.valueOf(paramInt3), " mode: ", Integer.valueOf(paramInt4) });
      AppMethodBeat.o(62629);
      return j;
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.g a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    int j = 0;
    AppMethodBeat.i(62631);
    com.tencent.pb.talkroom.sdk.g localg = a.fpu().a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    int i;
    if (paramArrayOfByte == null)
    {
      i = 0;
      if (paramArrayOfInt != null) {
        break label143;
      }
    }
    for (;;)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "videoTrans recordData size: ", Integer.valueOf(i), " len: ", Integer.valueOf(paramInt1), " localImg size: ", Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), " multiTalkVideoRGBinfo: ", localg });
      AppMethodBeat.o(62631);
      return localg;
      i = paramArrayOfByte.length;
      break;
      label143:
      j = paramArrayOfInt.length;
    }
  }
  
  public final boolean a(com.tencent.pb.talkroom.sdk.a parama, com.tencent.pb.talkroom.sdk.e parame)
  {
    AppMethodBeat.i(62612);
    if (com.tencent.pb.common.c.c.ztG == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "init fail context: ", com.tencent.pb.common.c.c.ztG });
      AppMethodBeat.o(62612);
      return false;
    }
    try
    {
      this.IJi = parama;
      f.a(parame);
      parama = a.fpu();
      g.a locala = this.IJl;
      parama.IJW.a(locala);
      com.tencent.pb.common.b.f.flo().Iki = parame;
      a.fpt();
      a.fpv();
      parama = new IntentFilter();
      parama.setPriority(2147483647);
      parama.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      com.tencent.pb.common.c.c.ztG.registerReceiver(this.IJk, parama);
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
  
  public final boolean a(String paramString1, String paramString2, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(183713);
    f localf = a.fpu();
    localf.IJG = paramInt;
    Object localObject1 = f.is(paramList);
    if (localObject1.length > 0)
    {
      if (TextUtils.isEmpty(null)) {
        break label309;
      }
      throw new NullPointerException();
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom cliendId: ", paramString1, " voiceSingle2MultiInfo: ", null, " memeberUuids size: ", Integer.valueOf(localObject1.length), "routeId", Integer.valueOf(paramInt), " context: ", null, " type: ", Integer.valueOf(0), " playId: ", Long.valueOf(0L), " sdkKey: ", null });
      if (com.tencent.pb.a.a.a.flF()) {
        break label338;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.flF()), " isBindMobile: ", Boolean.valueOf(com.tencent.pb.a.a.a.flG()) });
      h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "noAuth" });
    }
    for (;;)
    {
      paramString1 = null;
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "createTalkRoom clientId is: ", paramString1, "wXgroupId: ", paramString2, " creatorUsrName: ", com.tencent.pb.a.a.a.flE(), " usrnameList: ", paramList });
      if (paramString1 == null) {
        break label1006;
      }
      AppMethodBeat.o(183713);
      return true;
      label309:
      paramInt = new Random().nextInt() << 16 | com.tencent.pb.a.a.a.flE().hashCode() & 0xFFFF;
      break;
      label338:
      if (!com.tencent.pb.common.b.h.isNetworkConnected())
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom isNetworkConnected is false" });
        h.acY(-4003);
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "noNetwork" });
      }
      else if (localf.dSZ())
      {
        if (localf.dSZ()) {
          h.acY(-4002);
        }
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "isBusy" });
      }
      else if (TextUtils.isEmpty(paramString1))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom cliendId is null" });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "cliendIdnull" });
      }
      else if (!j.aOD(paramString1))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom groupId is not cliend id: ", paramString1 });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "isnotcliendId" });
      }
      else
      {
        if (c.fpJ().aOp(paramString1) == null) {
          c.fpJ().d(paramString1, paramString2, (String[])localObject1);
        }
        localf.IJO.reset();
        localf.xz(false);
        localf.fpS();
        if (localf.dNe()) {
          break label700;
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom initEngine fail" });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "initEnginefail" });
        localf.xz(false);
      }
    }
    label700:
    localf.IJO.fqh();
    localf.seB = paramString1;
    localf.IKa = paramString1;
    localf.IjW = paramInt;
    localf.IJy = paramString1;
    localf.setState(1);
    localf.zgY = true;
    Object localObject2 = new f.a(localf);
    ((f.a)localObject2).groupId = localf.seB;
    ((f.a)localObject2).IKJ = ((String[])localObject1);
    ((f.a)localObject2).IKK = null;
    ((f.a)localObject2).IkG = paramInt;
    ((f.a)localObject2).type = 0;
    ((f.a)localObject2).IKL = 0L;
    ((f.a)localObject2).IKM = null;
    ((f.a)localObject2).IKN = false;
    ((f.a)localObject2).IKO = paramString2;
    localObject1 = Message.obtain();
    ((Message)localObject1).what = 2;
    ((Message)localObject1).obj = localObject2;
    localf.mHandler.removeMessages(2);
    localObject2 = c.fpJ().aOp(localf.seB);
    if (localObject2 == null) {
      com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup talkroom is null" });
    }
    for (;;)
    {
      localf.mHandler.sendMessage((Message)localObject1);
      localf.IKc = true;
      break;
      localObject2 = ((TalkRoom)localObject2).fpA();
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
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup ret: ", Boolean.valueOf(((d)localObject2).fpM()) });
        }
      }
    }
    label1006:
    AppMethodBeat.o(183713);
    return false;
  }
  
  public final List<String> aNy(String paramString)
  {
    AppMethodBeat.i(62621);
    if (!com.tencent.pb.common.c.f.lO(paramString, a.fpu().seB))
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "getTalkingMember groupid is not same; multiTalkGroupid: ", paramString, a.fpu().seB });
      AppMethodBeat.o(62621);
      return null;
    }
    Object localObject1 = c.fpJ().aOp(paramString);
    if (localObject1 == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getTalkingMember talkroom is null: groupId: ", paramString });
      AppMethodBeat.o(62621);
      return null;
    }
    localObject1 = ((TalkRoom)localObject1).fpB();
    paramString = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    label232:
    label235:
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
        localObject2 = a.fpu();
        i = locald.getMemberId();
        if (((f)localObject2).IJP == null) {
          break label232;
        }
        localObject2 = ((f)localObject2).IJP;
        if ((!com.tencent.pb.common.a.a.Ijx) || (((b)localObject2).IJa == null)) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label235;
        }
        paramString.add(locald.fpL());
        break;
        if (((b)localObject2).IJa.GetVoiceActivity(i) == 1)
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
  
  public final boolean ahD(String paramString)
  {
    AppMethodBeat.i(62628);
    if (!a.fpu().dSZ())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "subscribeLargeVideo isWorking is false" });
      AppMethodBeat.o(62628);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "subscribeLargeVideo ownerUserName: ", paramString });
    f localf = a.fpu();
    if (TextUtils.isEmpty(localf.seB))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "subscribeLargeVideo mGroupId null " });
      AppMethodBeat.o(62628);
      return false;
    }
    paramString = new l(localf.seB, localf.sHe, localf.ztl, paramString);
    boolean bool = com.tencent.pb.common.b.e.fll().a(paramString);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "subscribeLargeVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62628);
    return bool;
  }
  
  public final boolean ahu(String paramString)
  {
    AppMethodBeat.i(62620);
    if (!com.tencent.pb.common.c.f.lO(paramString, a.fpu().seB))
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "exitMultiTalk groupid is not same; multiTalkGroupid: ", paramString, a.fpu().seB });
      f.e locale;
      f localf;
      if (a.fpu().aOy(paramString))
      {
        locale = a.fpu().aOx(paramString);
        localf = a.fpu();
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
      for (l = 0L;; l = locale.sAY)
      {
        localf.a(paramString, i, l, 1);
        AppMethodBeat.o(62620);
        return false;
        i = locale.roomId;
        break;
      }
    }
    int i = a.fpu().sHe;
    long l = a.fpu().ztl;
    boolean bool = a.fpu().aV(paramString, 1, 100);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "exitMultiTalk groupId: ", paramString, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(l) });
    AppMethodBeat.o(62620);
    return bool;
  }
  
  public final boolean b(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, int paramInt3)
  {
    AppMethodBeat.i(183715);
    f.b localb = a.fpu().a(paramString1, paramInt1, paramLong, paramInt2, 100, paramString2, paramInt3);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "enterMultiTalk multiTalkGroupid:", paramString1, " roomId: ", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " routId: ", Integer.valueOf(paramInt2), " wxGroupId: ", paramString2, " ret: ", localb });
    if (localb == f.b.IKP)
    {
      AppMethodBeat.o(183715);
      return true;
    }
    AppMethodBeat.o(183715);
    return false;
  }
  
  public final boolean b(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(183714);
    f localf = a.fpu();
    localf.IJG = paramInt2;
    paramString2 = localf.a(paramString1, localf.sHe, localf.ztl, paramInt1, 1, paramString2, paramInt2);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "enterMultiTalk multiTalkGroupid:", paramString1, " isAccept: ", Boolean.TRUE, " routId: ", Integer.valueOf(paramInt1), " ret: ", paramString2 });
    if (paramString2 == f.b.IKP)
    {
      AppMethodBeat.o(183714);
      return true;
    }
    AppMethodBeat.o(183714);
    return false;
  }
  
  public final boolean cF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62623);
    com.tencent.pb.common.b.f.flo();
    int i = com.tencent.pb.common.b.f.cE(paramArrayOfByte);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "handleMultiTalkNotify ret: ", Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(62623);
      return true;
    }
    AppMethodBeat.o(62623);
    return false;
  }
  
  public final void cL(int paramInt, String paramString)
  {
    AppMethodBeat.i(62626);
    com.tencent.pb.a.a.a.abF(paramInt);
    com.tencent.pb.a.a.a.aNx(paramString);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "setWxUinAndUsrName uin: ", Integer.valueOf(paramInt), " usrname: ", paramString });
    AppMethodBeat.o(62626);
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
      com.tencent.pb.common.b.f.flo().u(paramInt2, paramArrayOfByte);
    }
    for (;;)
    {
      AppMethodBeat.o(62622);
      return true;
      i = paramArrayOfByte.length;
      break;
      label109:
      paramArrayOfByte = com.tencent.pb.common.b.f.flo();
      com.tencent.pb.common.b.f.a locala = paramArrayOfByte.abE(paramInt2);
      if (locala != null)
      {
        com.tencent.pb.common.c.b.w("NETCMD", new Object[] { "CLTRCV FAIL", Integer.valueOf(paramInt2), locala.Ikl, Integer.valueOf(1), Integer.valueOf(paramInt1) });
        paramArrayOfByte.a(locala, -1, null);
      }
    }
  }
  
  public final boolean flH()
  {
    AppMethodBeat.i(62615);
    try
    {
      com.tencent.pb.common.c.b.flC();
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
  
  public final String flI()
  {
    AppMethodBeat.i(62625);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("client_");
    ((StringBuilder)localObject).append(com.tencent.pb.a.a.a.flE());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = ((StringBuilder)localObject).toString();
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "genMultiTalkClientId clientId: ", localObject });
    AppMethodBeat.o(62625);
    return localObject;
  }
  
  public final boolean io(List<a.ao> paramList)
  {
    AppMethodBeat.i(183716);
    if (!a.fpu().dSZ())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "subscribeGeneralVideo isWorking is false" });
      AppMethodBeat.o(183716);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "subscribeGeneralVideo memberListInfo: ", paramList });
    f localf = a.fpu();
    if (TextUtils.isEmpty(localf.seB))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "subscribeGeneralVideo mGroupId null " });
      AppMethodBeat.o(183716);
      return false;
    }
    paramList = new k(localf.seB, localf.sHe, localf.ztl, paramList);
    boolean bool = com.tencent.pb.common.b.e.fll().a(paramList);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "subscribeGeneralVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(183716);
    return bool;
  }
  
  public final void nD(boolean paramBoolean)
  {
    AppMethodBeat.i(62614);
    a.fpu();
    com.tencent.pb.talkroom.sdk.e locale = f.fqf();
    if (locale != null) {}
    for (boolean bool = locale.nw(paramBoolean);; bool = false)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "switchSpeakerPhone", Boolean.valueOf(paramBoolean), " ret: ", Boolean.valueOf(bool), " realret: ", Boolean.valueOf(f.fqe()), " wxCallBack: ", locale });
      AppMethodBeat.o(62614);
      return;
    }
  }
  
  public final int setAppCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = -1;
    AppMethodBeat.i(62632);
    Object localObject = a.fpu();
    if (((f)localObject).IJP == null) {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "setAppCmd type: ", Integer.valueOf(paramInt1), " engine is null" });
    }
    for (;;)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "setAppCmd type: ", Integer.valueOf(paramInt1), " paramLen: ", Integer.valueOf(paramInt2), " ret: ", Integer.valueOf(i) });
      AppMethodBeat.o(62632);
      return i;
      localObject = ((f)localObject).IJP;
      if ((paramArrayOfByte == null) || (((b)localObject).IJa == null)) {
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:setAppCmd null, params:", paramArrayOfByte, ", engine:", ((b)localObject).IJa });
      } else {
        i = ((b)localObject).IJa.setAppCmd(paramInt1, paramArrayOfByte, paramInt2);
      }
    }
  }
  
  public final void xq(boolean paramBoolean)
  {
    AppMethodBeat.i(62613);
    f localf = a.fpu();
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "setMute isMute: ", Boolean.valueOf(paramBoolean) });
    localf.mIsMute = paramBoolean;
    com.tencent.pb.common.c.g.runOnMainThread(new g.15(localf.IJW, paramBoolean));
    AppMethodBeat.o(62613);
  }
  
  public final boolean xr(boolean paramBoolean)
  {
    AppMethodBeat.i(62624);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "holadMultiTalk isHold", Boolean.valueOf(paramBoolean) });
    f localf;
    if (paramBoolean)
    {
      localf = a.fpu();
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "startHoldOn" });
      localf.IKk = true;
      localf.xA(false);
      com.tencent.pb.common.c.g.runOnMainThread(new g.12(localf.IJW));
    }
    for (;;)
    {
      AppMethodBeat.o(62624);
      return true;
      localf = a.fpu();
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "endHoldOn" });
      localf.IKk = false;
      localf.fpT();
      if ((localf.dSZ()) && (localf.sRS))
      {
        localf.xA(true);
        com.tencent.pb.common.c.g.runOnMainThread(new g.13(localf.IJW));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.e
 * JD-Core Version:    0.7.0.1
 */