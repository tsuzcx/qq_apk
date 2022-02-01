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
  private static e MIx = null;
  private com.tencent.pb.talkroom.sdk.a MIw;
  private ConnectReceiver MIy;
  private g.a MIz;
  private final String TAG;
  
  private e()
  {
    AppMethodBeat.i(62610);
    this.TAG = "TalkRoomSdkApi";
    this.MIw = null;
    this.MIy = new ConnectReceiver();
    this.MIz = new g.a()
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
      
      public final void Ld(int paramAnonymousInt)
      {
        AppMethodBeat.i(208334);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSwitchVideoScreenSharingRsp switch_ret: ", Integer.valueOf(paramAnonymousInt) });
        if (e.a(e.this) != null) {
          e.a(e.this).Ld(paramAnonymousInt);
        }
        AppMethodBeat.o(208334);
      }
      
      public final void Li(int paramAnonymousInt)
      {
        AppMethodBeat.i(62683);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ", Integer.valueOf(paramAnonymousInt) });
        if (e.a(e.this) != null) {
          e.a(e.this).Li(paramAnonymousInt);
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
          if (com.tencent.pb.common.a.a.MbU) {
            Toast.makeText(com.tencent.pb.common.c.c.CDp, "onMisscMultiTalk ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
          }
        }
        AppMethodBeat.o(62676);
      }
      
      public final void aMy()
      {
        AppMethodBeat.i(62665);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onInitSeccess" });
        if (com.tencent.pb.common.a.a.MbU) {
          Toast.makeText(com.tencent.pb.common.c.c.CDp, "onInitSeccess ", 0).show();
        }
        if (e.a(e.this) != null) {
          e.a(e.this).dtj();
        }
        AppMethodBeat.o(62665);
      }
      
      public final void aiX(int paramAnonymousInt)
      {
        AppMethodBeat.i(62664);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onOpeningChannel", Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(62664);
      }
      
      public final void aiY(int paramAnonymousInt)
      {
        AppMethodBeat.i(62680);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSwitchMultiTalkVideoSuss bitRate: ", Integer.valueOf(paramAnonymousInt) });
        if (e.a(e.this) != null) {
          e.a(e.this).dtk();
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
          if (com.tencent.pb.common.a.a.MbU) {
            Toast.makeText(com.tencent.pb.common.c.c.CDp, "onInviteMultiTalk ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
          }
        }
        AppMethodBeat.o(62675);
      }
      
      public final void dm(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(62669);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onExitRoom", paramAnonymousString, a.gdH().uwq, Boolean.valueOf(paramAnonymousBoolean) });
        AppMethodBeat.o(62669);
      }
      
      public final void dtl()
      {
        AppMethodBeat.i(62681);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSubscribeLargeVideoSuss" });
        if (e.a(e.this) != null) {
          e.a(e.this).dtl();
        }
        AppMethodBeat.o(62681);
      }
      
      public final void dtm()
      {
        AppMethodBeat.i(183717);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSubscribeGeneralVideoSuss" });
        if (e.a(e.this) != null) {
          e.a(e.this).dtm();
        }
        AppMethodBeat.o(183717);
      }
      
      public final void eE(List<a.ap> paramAnonymousList)
      {
        AppMethodBeat.i(62682);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onVideoGroupMemberChange videoUserNames: ", paramAnonymousList });
        if (e.a(e.this) != null) {
          e.a(e.this).eE(paramAnonymousList);
        }
        AppMethodBeat.o(62682);
      }
      
      public final void f(MultiTalkGroup paramAnonymousMultiTalkGroup)
      {
        AppMethodBeat.i(62666);
        Object localObject = a.gdH().uwq;
        String str = null;
        if (paramAnonymousMultiTalkGroup != null) {
          str = paramAnonymousMultiTalkGroup.wmz;
        }
        com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "onMemberChange mGroupId: ", localObject, " groupId: ", str, paramAnonymousMultiTalkGroup });
        if (com.tencent.pb.common.a.a.MbU) {
          Toast.makeText(com.tencent.pb.common.c.c.CDp, "onMemberChange ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
        }
        int k;
        int j;
        int i;
        if (com.tencent.pb.common.c.f.mP(str, (String)localObject))
        {
          c.gdW();
          if ((c.bbH((String)localObject)) && (a.gdH().state != 3))
          {
            c.gdW();
            k = c.bbI((String)localObject);
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
          h.ajb(j);
          a.gdH().MJd.ajf(i);
          localObject = a.gdH();
          i = a.gdH().vdk;
          long l = a.gdH().CCU;
          a.gdH();
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
      
      public final void geb()
      {
        AppMethodBeat.i(62671);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSelfHoldOnBegin" });
        AppMethodBeat.o(62671);
      }
      
      public final void gec()
      {
        AppMethodBeat.i(62672);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSelfHoldOnEnd" });
        AppMethodBeat.o(62672);
      }
      
      public final void ged()
      {
        AppMethodBeat.i(62678);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onSendMsgSucc" });
        if (e.a(e.this) != null) {
          e.a(e.this);
        }
        AppMethodBeat.o(62678);
      }
      
      public final void ho(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(62673);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onModifyGroupInfo", paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(62673);
      }
      
      public final void jb(List<MultiTalkGroup> paramAnonymousList)
      {
        AppMethodBeat.i(62677);
        com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "onActiveMultiTalkList ", paramAnonymousList });
        if (e.a(e.this) != null) {
          e.a(e.this);
        }
        AppMethodBeat.o(62677);
      }
      
      public final void m(int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(62667);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onErr errCode: ", Integer.valueOf(paramAnonymousInt), " data: ", paramAnonymousObject });
        if (e.a(e.this) != null) {
          e.a(e.this).m(paramAnonymousInt, paramAnonymousObject);
        }
        AppMethodBeat.o(62667);
      }
      
      public final void oN(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(62674);
        com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "onMuteStateChange", Boolean.valueOf(paramAnonymousBoolean) });
        if (e.a(e.this) != null) {
          e.a(e.this).oN(paramAnonymousBoolean);
        }
        AppMethodBeat.o(62674);
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
        if (com.tencent.pb.common.a.a.MbU) {
          Toast.makeText(com.tencent.pb.common.c.c.CDp, "onCreateRoom ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
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
          if (com.tencent.pb.common.a.a.MbU) {
            Toast.makeText(com.tencent.pb.common.c.c.CDp, "onEnterRoom ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
          }
        }
        AppMethodBeat.o(62668);
      }
    };
    AppMethodBeat.o(62610);
  }
  
  public static e gea()
  {
    AppMethodBeat.i(62609);
    if (MIx == null) {}
    try
    {
      if (MIx == null) {
        MIx = new e();
      }
      e locale = MIx;
      AppMethodBeat.o(62609);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(62609);
    }
  }
  
  public static void lx(Context paramContext)
  {
    AppMethodBeat.i(62611);
    com.tencent.pb.common.c.c.CDp = paramContext;
    i.lw(paramContext);
    AppMethodBeat.o(62611);
  }
  
  public final boolean J(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(62619);
    if (!com.tencent.pb.common.c.f.mP(paramString, a.gdH().uwq))
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "addMultiTalkMember groupid is not same; multiTalkGroupid: ", paramString, a.gdH().uwq });
      AppMethodBeat.o(62619);
      return false;
    }
    f localf = a.gdH();
    int j = localf.vdk;
    long l = localf.CCU;
    int i;
    boolean bool;
    if (paramList == null)
    {
      i = 0;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "addrTalkRoomMember", paramString, Integer.valueOf(j), Long.valueOf(l), " users length: ", Integer.valueOf(i) });
      localf.MJr = false;
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
        paramList = f.jc(paramList);
        if (paramList.length <= 0)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "addTalkRoomMember users is null" });
          bool = false;
        }
        else
        {
          paramString = new com.tencent.wecall.talkroom.a.b(paramString, localf.vdk, localf.CCU, paramList);
          bool = com.tencent.pb.common.b.e.fXr().a(paramString);
          localf.MJd.af(new String[] { "add", "req", String.valueOf(bool), String.valueOf(localf.state) });
        }
      }
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.f K(int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(62630);
    com.tencent.pb.talkroom.sdk.f localf = a.gdH().K(paramArrayOfInt);
    if (paramArrayOfInt == null) {}
    for (;;)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "receiveVideo imgBuffer size: ", Integer.valueOf(i), " MultiTalkVideoDecodeInfo: ", localf });
      AppMethodBeat.o(62630);
      return localf;
      i = paramArrayOfInt.length;
    }
  }
  
  public final boolean Lj(int paramInt)
  {
    AppMethodBeat.i(62627);
    if (!a.gdH().ezD())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "switchMultiTalkVideo isWorking is false" });
      AppMethodBeat.o(62627);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "switchMultiTalkVideo action: ", Integer.valueOf(paramInt) });
    Object localObject = a.gdH();
    if (TextUtils.isEmpty(((f)localObject).uwq))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "switchMultiTalkVideo mGroupId is null" });
      AppMethodBeat.o(62627);
      return false;
    }
    ((f)localObject).MIV = paramInt;
    localObject = new m(((f)localObject).uwq, ((f)localObject).vdk, ((f)localObject).CCU, paramInt);
    boolean bool = com.tencent.pb.common.b.e.fXr().a((com.tencent.pb.common.b.d)localObject);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "switchMultiTalkVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62627);
    return bool;
  }
  
  public final com.tencent.pb.talkroom.sdk.f a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(208332);
    paramArrayOfInt = a.gdH().a(paramArrayOfByte, paramArrayOfInt, paramInt);
    if (paramArrayOfByte == null) {}
    for (paramInt = i;; paramInt = paramArrayOfByte.length)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "receiveScreen imgBuffer size: ", Integer.valueOf(paramInt), " MultiTalkVideoDecodeInfo: ", paramArrayOfInt });
      AppMethodBeat.o(208332);
      return paramArrayOfInt;
    }
  }
  
  public final boolean a(com.tencent.pb.talkroom.sdk.a parama, com.tencent.pb.talkroom.sdk.e parame)
  {
    AppMethodBeat.i(62612);
    if (com.tencent.pb.common.c.c.CDp == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "init fail context: ", com.tencent.pb.common.c.c.CDp });
      AppMethodBeat.o(62612);
      return false;
    }
    try
    {
      this.MIw = parama;
      f.a(parame);
      parama = a.gdH();
      g.a locala = this.MIz;
      parama.MJl.a(locala);
      com.tencent.pb.common.b.f.fXu().McG = parame;
      a.gdG();
      a.gdI();
      parama = new IntentFilter();
      parama.setPriority(2147483647);
      parama.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      com.tencent.pb.common.c.c.CDp.registerReceiver(this.MIy, parama);
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
    f.b localb = a.gdH().a(paramString1, paramInt1, paramLong, paramInt2, 100, paramString2, paramInt3);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "enterMultiTalk multiTalkGroupid:", paramString1, " roomId: ", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " routId: ", Integer.valueOf(paramInt2), " wxGroupId: ", paramString2, " ret: ", localb });
    if (localb == f.b.MKe)
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
    f localf = a.gdH();
    localf.MIU = paramInt;
    Object localObject1 = f.jc(paramList);
    if (localObject1.length > 0)
    {
      if (TextUtils.isEmpty(null)) {
        break label309;
      }
      throw new NullPointerException();
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom cliendId: ", paramString1, " voiceSingle2MultiInfo: ", null, " memeberUuids size: ", Integer.valueOf(localObject1.length), "routeId", Integer.valueOf(paramInt), " context: ", null, " type: ", Integer.valueOf(0), " playId: ", Long.valueOf(0L), " sdkKey: ", null });
      if (com.tencent.pb.a.a.a.fXL()) {
        break label338;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.fXL()), " isBindMobile: ", Boolean.valueOf(com.tencent.pb.a.a.a.fXM()) });
      h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "noAuth" });
    }
    for (;;)
    {
      paramString1 = null;
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "createTalkRoom clientId is: ", paramString1, "wXgroupId: ", paramString2, " creatorUsrName: ", com.tencent.pb.a.a.a.fXK(), " usrnameList: ", paramList });
      if (paramString1 == null) {
        break label1006;
      }
      AppMethodBeat.o(183713);
      return true;
      label309:
      paramInt = new Random().nextInt() << 16 | com.tencent.pb.a.a.a.fXK().hashCode() & 0xFFFF;
      break;
      label338:
      if (!com.tencent.pb.common.b.h.isNetworkConnected())
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom isNetworkConnected is false" });
        h.ajd(-4003);
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "noNetwork" });
      }
      else if (localf.ezD())
      {
        if (localf.ezD()) {
          h.ajd(-4002);
        }
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "isBusy" });
      }
      else if (TextUtils.isEmpty(paramString1))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom cliendId is null" });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "cliendIdnull" });
      }
      else if (!j.bbQ(paramString1))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom groupId is not cliend id: ", paramString1 });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "isnotcliendId" });
      }
      else
      {
        if (c.gdW().bbC(paramString1) == null) {
          c.gdW().e(paramString1, paramString2, (String[])localObject1);
        }
        localf.MJd.reset();
        localf.zQ(false);
        localf.gef();
        if (localf.erC()) {
          break label700;
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom initEngine fail" });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "initEnginefail" });
        localf.zQ(false);
      }
    }
    label700:
    localf.MJd.gev();
    localf.uwq = paramString1;
    localf.MJp = paramString1;
    localf.Mcu = paramInt;
    localf.MIM = paramString1;
    localf.setState(1);
    localf.Cqi = true;
    Object localObject2 = new f.a(localf);
    ((f.a)localObject2).groupId = localf.uwq;
    ((f.a)localObject2).MJY = ((String[])localObject1);
    ((f.a)localObject2).MJZ = null;
    ((f.a)localObject2).Mde = paramInt;
    ((f.a)localObject2).type = 0;
    ((f.a)localObject2).MKa = 0L;
    ((f.a)localObject2).MKb = null;
    ((f.a)localObject2).MKc = false;
    ((f.a)localObject2).MKd = paramString2;
    localObject1 = Message.obtain();
    ((Message)localObject1).what = 2;
    ((Message)localObject1).obj = localObject2;
    localf.mHandler.removeMessages(2);
    localObject2 = c.gdW().bbC(localf.uwq);
    if (localObject2 == null) {
      com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup talkroom is null" });
    }
    for (;;)
    {
      localf.mHandler.sendMessage((Message)localObject1);
      localf.MJr = true;
      break;
      localObject2 = ((TalkRoom)localObject2).gdN();
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
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup ret: ", Boolean.valueOf(((d)localObject2).gdZ()) });
        }
      }
    }
    label1006:
    AppMethodBeat.o(183713);
    return false;
  }
  
  public final boolean asF(String paramString)
  {
    AppMethodBeat.i(62628);
    if (!a.gdH().ezD())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "subscribeLargeVideo isWorking is false" });
      AppMethodBeat.o(62628);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "subscribeLargeVideo ownerUserName: ", paramString });
    f localf = a.gdH();
    if (TextUtils.isEmpty(localf.uwq))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "subscribeLargeVideo mGroupId null " });
      AppMethodBeat.o(62628);
      return false;
    }
    paramString = new l(localf.uwq, localf.vdk, localf.CCU, paramString);
    boolean bool = com.tencent.pb.common.b.e.fXr().a(paramString);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "subscribeLargeVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62628);
    return bool;
  }
  
  public final boolean ast(String paramString)
  {
    AppMethodBeat.i(62620);
    if (!com.tencent.pb.common.c.f.mP(paramString, a.gdH().uwq))
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "exitMultiTalk groupid is not same; multiTalkGroupid: ", paramString, a.gdH().uwq });
      f.e locale;
      f localf;
      if (a.gdH().bbL(paramString))
      {
        locale = a.gdH().bbK(paramString);
        localf = a.gdH();
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
      for (l = 0L;; l = locale.uXg)
      {
        localf.b(paramString, i, l, 1);
        AppMethodBeat.o(62620);
        return false;
        i = locale.roomId;
        break;
      }
    }
    int i = a.gdH().vdk;
    long l = a.gdH().CCU;
    boolean bool = a.gdH().bd(paramString, 1, 100);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "exitMultiTalk groupId: ", paramString, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(l) });
    AppMethodBeat.o(62620);
    return bool;
  }
  
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(208330);
    int j = a.gdH().b(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "sendVideo buffer size: ", Integer.valueOf(i), " len: ", Integer.valueOf(paramInt1), " w: ", Integer.valueOf(paramInt2), " h: ", Integer.valueOf(paramInt3), " format: ", Integer.valueOf(paramInt4), " mode: ", Integer.valueOf(paramInt5) });
      AppMethodBeat.o(208330);
      return j;
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.g b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    int j = 0;
    AppMethodBeat.i(62631);
    com.tencent.pb.talkroom.sdk.g localg = a.gdH().b(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
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
  
  public final List<String> baE(String paramString)
  {
    AppMethodBeat.i(62621);
    if (!com.tencent.pb.common.c.f.mP(paramString, a.gdH().uwq))
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "getTalkingMember groupid is not same; multiTalkGroupid: ", paramString, a.gdH().uwq });
      AppMethodBeat.o(62621);
      return null;
    }
    Object localObject1 = c.gdW().bbC(paramString);
    if (localObject1 == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getTalkingMember talkroom is null: groupId: ", paramString });
      AppMethodBeat.o(62621);
      return null;
    }
    localObject1 = ((TalkRoom)localObject1).gdO();
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
        localObject2 = a.gdH();
        i = locald.getMemberId();
        if (((f)localObject2).MJe == null) {
          break label232;
        }
        localObject2 = ((f)localObject2).MJe;
        if ((!com.tencent.pb.common.a.a.MbV) || (((b)localObject2).MIo == null)) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label235;
        }
        paramString.add(locald.gdY());
        break;
        if (((b)localObject2).MIo.GetVoiceActivity(i) == 1)
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
  
  public final boolean c(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(183714);
    f localf = a.gdH();
    localf.MIU = paramInt2;
    paramString2 = localf.a(paramString1, localf.vdk, localf.CCU, paramInt1, 1, paramString2, paramInt2);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "enterMultiTalk multiTalkGroupid:", paramString1, " isAccept: ", Boolean.TRUE, " routId: ", Integer.valueOf(paramInt1), " ret: ", paramString2 });
    if (paramString2 == f.b.MKe)
    {
      AppMethodBeat.o(183714);
      return true;
    }
    AppMethodBeat.o(183714);
    return false;
  }
  
  public final boolean cO(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62623);
    com.tencent.pb.common.b.f.fXu();
    int i = com.tencent.pb.common.b.f.cN(paramArrayOfByte);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "handleMultiTalkNotify ret: ", Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(62623);
      return true;
    }
    AppMethodBeat.o(62623);
    return false;
  }
  
  public final void cW(int paramInt, String paramString)
  {
    AppMethodBeat.i(62626);
    com.tencent.pb.a.a.a.ahh(paramInt);
    com.tencent.pb.a.a.a.baD(paramString);
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
      com.tencent.pb.common.b.f.fXu().u(paramInt2, paramArrayOfByte);
    }
    for (;;)
    {
      AppMethodBeat.o(62622);
      return true;
      i = paramArrayOfByte.length;
      break;
      label109:
      paramArrayOfByte = com.tencent.pb.common.b.f.fXu();
      com.tencent.pb.common.b.f.a locala = paramArrayOfByte.ahg(paramInt2);
      if (locala != null)
      {
        com.tencent.pb.common.c.b.w("NETCMD", new Object[] { "CLTRCV FAIL", Integer.valueOf(paramInt2), locala.McJ, Integer.valueOf(1), Integer.valueOf(paramInt1) });
        paramArrayOfByte.a(locala, -1, null);
      }
    }
  }
  
  public final int e(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(208331);
    int j;
    if (paramArrayOfByte == null)
    {
      i = 0;
      com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "sendScreen buffer size: ", Integer.valueOf(i), " len: ", Integer.valueOf(paramInt1), " w: ", Integer.valueOf(paramInt2), " h: ", Integer.valueOf(paramInt3), " format: ", Integer.valueOf(paramInt4) });
      j = a.gdH().e(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
      if (paramArrayOfByte != null) {
        break label231;
      }
    }
    label231:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "sendScreen buffer size: ", Integer.valueOf(i), " len: ", Integer.valueOf(paramInt1), " w: ", Integer.valueOf(paramInt2), " h: ", Integer.valueOf(paramInt3), " format: ", Integer.valueOf(paramInt4), " ret: ", Integer.valueOf(j) });
      AppMethodBeat.o(208331);
      return j;
      i = paramArrayOfByte.length;
      break;
    }
  }
  
  public final boolean eG(List<a.ao> paramList)
  {
    AppMethodBeat.i(183716);
    if (!a.gdH().ezD())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "subscribeGeneralVideo isWorking is false" });
      AppMethodBeat.o(183716);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "subscribeGeneralVideo memberListInfo: ", paramList });
    f localf = a.gdH();
    if (TextUtils.isEmpty(localf.uwq))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "subscribeGeneralVideo mGroupId null " });
      AppMethodBeat.o(183716);
      return false;
    }
    paramList = new k(localf.uwq, localf.vdk, localf.CCU, paramList);
    boolean bool = com.tencent.pb.common.b.e.fXr().a(paramList);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "subscribeGeneralVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(183716);
    return bool;
  }
  
  public final boolean fXN()
  {
    AppMethodBeat.i(62615);
    try
    {
      com.tencent.pb.common.c.b.fXI();
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
  
  public final String fXO()
  {
    AppMethodBeat.i(62625);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("client_");
    ((StringBuilder)localObject).append(com.tencent.pb.a.a.a.fXK());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = ((StringBuilder)localObject).toString();
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "genMultiTalkClientId clientId: ", localObject });
    AppMethodBeat.o(62625);
    return localObject;
  }
  
  public final void pb(boolean paramBoolean)
  {
    AppMethodBeat.i(62614);
    a.gdH();
    com.tencent.pb.talkroom.sdk.e locale = f.ges();
    if (locale != null) {}
    for (boolean bool = locale.oT(paramBoolean);; bool = false)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "switchSpeakerPhone", Boolean.valueOf(paramBoolean), " ret: ", Boolean.valueOf(bool), " realret: ", Boolean.valueOf(f.ger()), " wxCallBack: ", locale });
      AppMethodBeat.o(62614);
      return;
    }
  }
  
  public final int screenTrans(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(208333);
    paramInt1 = a.gdH().screenTrans(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramArrayOfByte2, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.o(208333);
    return paramInt1;
  }
  
  public final int setAppCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = -1;
    AppMethodBeat.i(62632);
    Object localObject = a.gdH();
    if (((f)localObject).MJe == null) {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "setAppCmd type: ", Integer.valueOf(paramInt1), " engine is null" });
    }
    for (;;)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "setAppCmd type: ", Integer.valueOf(paramInt1), " paramLen: ", Integer.valueOf(paramInt2), " ret: ", Integer.valueOf(i) });
      AppMethodBeat.o(62632);
      return i;
      localObject = ((f)localObject).MJe;
      if ((paramArrayOfByte == null) || (((b)localObject).MIo == null)) {
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:setAppCmd null, params:", paramArrayOfByte, ", engine:", ((b)localObject).MIo });
      } else {
        i = ((b)localObject).MIo.setAppCmd(paramInt1, paramArrayOfByte, paramInt2);
      }
    }
  }
  
  public final void zB(boolean paramBoolean)
  {
    AppMethodBeat.i(62613);
    f localf = a.gdH();
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "setMute isMute: ", Boolean.valueOf(paramBoolean) });
    localf.mIsMute = paramBoolean;
    com.tencent.pb.common.c.g.runOnMainThread(new g.16(localf.MJl, paramBoolean));
    AppMethodBeat.o(62613);
  }
  
  public final boolean zC(boolean paramBoolean)
  {
    AppMethodBeat.i(62624);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "holadMultiTalk isHold", Boolean.valueOf(paramBoolean) });
    f localf;
    if (paramBoolean)
    {
      localf = a.gdH();
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "startHoldOn" });
      localf.MJz = true;
      localf.oL(false);
      com.tencent.pb.common.c.g.runOnMainThread(new g.13(localf.MJl));
    }
    for (;;)
    {
      AppMethodBeat.o(62624);
      return true;
      localf = a.gdH();
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "endHoldOn" });
      localf.MJz = false;
      localf.geg();
      if ((localf.ezD()) && (localf.voZ))
      {
        localf.oL(true);
        com.tencent.pb.common.c.g.runOnMainThread(new g.14(localf.MJl));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.e
 * JD-Core Version:    0.7.0.1
 */