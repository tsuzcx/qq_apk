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
  private static e ZVo = null;
  private final String TAG;
  private com.tencent.pb.talkroom.sdk.a ZVn;
  private ConnectReceiver ZVp;
  private g.a ZVq;
  
  private e()
  {
    AppMethodBeat.i(62610);
    this.TAG = "TalkRoomSdkApi";
    this.ZVn = null;
    this.ZVp = new ConnectReceiver();
    this.ZVq = new g.a()
    {
      public final void K(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
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
      
      public final void Xr(int paramAnonymousInt)
      {
        AppMethodBeat.i(208893);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSwitchVideoScreenSharingRsp switch_ret: ", Integer.valueOf(paramAnonymousInt) });
        if (e.a(e.this) != null) {
          e.a(e.this).Xr(paramAnonymousInt);
        }
        AppMethodBeat.o(208893);
      }
      
      public final void Xw(int paramAnonymousInt)
      {
        AppMethodBeat.i(62683);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ", Integer.valueOf(paramAnonymousInt) });
        if (e.a(e.this) != null) {
          e.a(e.this).Xw(paramAnonymousInt);
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
          if (com.tencent.pb.common.a.a.ZdL) {
            Toast.makeText(com.tencent.pb.common.c.c.NYh, "onMisscMultiTalk ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
          }
        }
        AppMethodBeat.o(62676);
      }
      
      public final void aCu(int paramAnonymousInt)
      {
        AppMethodBeat.i(62664);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onOpeningChannel", Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(62664);
      }
      
      public final void aCv(int paramAnonymousInt)
      {
        AppMethodBeat.i(62680);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSwitchMultiTalkVideoSuss bitRate: ", Integer.valueOf(paramAnonymousInt) });
        if (e.a(e.this) != null) {
          e.a(e.this).eXv();
        }
        AppMethodBeat.o(62680);
      }
      
      public final void ay(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(208894);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onDoScreenSharingSecurityCheck ret: ", Integer.valueOf(paramAnonymousInt1), " checkRet: ", Integer.valueOf(paramAnonymousInt2) });
        if (e.a(e.this) != null) {
          e.a(e.this).ay(paramAnonymousString, paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(208894);
      }
      
      public final void b(MultiTalkGroup paramAnonymousMultiTalkGroup)
      {
        AppMethodBeat.i(62675);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onInviteMultiTalk", paramAnonymousMultiTalkGroup });
        if (e.a(e.this) != null)
        {
          e.a(e.this).b(paramAnonymousMultiTalkGroup);
          if (com.tencent.pb.common.a.a.ZdL) {
            Toast.makeText(com.tencent.pb.common.c.c.NYh, "onInviteMultiTalk ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
          }
        }
        AppMethodBeat.o(62675);
      }
      
      public final void bpP()
      {
        AppMethodBeat.i(62665);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onInitSeccess" });
        if (com.tencent.pb.common.a.a.ZdL) {
          Toast.makeText(com.tencent.pb.common.c.c.NYh, "onInitSeccess ", 0).show();
        }
        if (e.a(e.this) != null) {
          e.a(e.this).eXu();
        }
        AppMethodBeat.o(62665);
      }
      
      public final void dT(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(62669);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onExitRoom", paramAnonymousString, a.iut().CSB, Boolean.valueOf(paramAnonymousBoolean) });
        AppMethodBeat.o(62669);
      }
      
      public final void eXw()
      {
        AppMethodBeat.i(62681);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSubscribeLargeVideoSuss" });
        if (e.a(e.this) != null) {
          e.a(e.this).eXw();
        }
        AppMethodBeat.o(62681);
      }
      
      public final void eXx()
      {
        AppMethodBeat.i(183717);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSubscribeGeneralVideoSuss" });
        if (e.a(e.this) != null) {
          e.a(e.this).eXx();
        }
        AppMethodBeat.o(183717);
      }
      
      public final void eXy()
      {
        AppMethodBeat.i(208898);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSubscribeScreenSharingVideoSuss" });
        if (e.a(e.this) != null) {
          e.a(e.this).eXy();
        }
        AppMethodBeat.o(208898);
      }
      
      public final void f(MultiTalkGroup paramAnonymousMultiTalkGroup)
      {
        AppMethodBeat.i(62666);
        Object localObject = a.iut().CSB;
        String str = null;
        if (paramAnonymousMultiTalkGroup != null) {
          str = paramAnonymousMultiTalkGroup.FmO;
        }
        com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "onMemberChange mGroupId: ", localObject, " groupId: ", str, paramAnonymousMultiTalkGroup });
        if (com.tencent.pb.common.a.a.ZdL) {
          Toast.makeText(com.tencent.pb.common.c.c.NYh, "onMemberChange ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
        }
        int k;
        int j;
        int i;
        if (com.tencent.pb.common.c.f.oB(str, (String)localObject))
        {
          c.iuI();
          if ((c.bEk((String)localObject)) && (a.iut().state != 3))
          {
            c.iuI();
            k = c.bEl((String)localObject);
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
          h.aCy(j);
          a.iut().ZVU.aCC(i);
          localObject = a.iut();
          i = a.iut().DVO;
          long l = a.iut().NXM;
          a.iut();
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
      
      public final void gb(List<a.ar> paramAnonymousList)
      {
        AppMethodBeat.i(62682);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onVideoGroupMemberChange videoUserNames: ", paramAnonymousList });
        if (e.a(e.this) != null) {
          e.a(e.this).gb(paramAnonymousList);
        }
        AppMethodBeat.o(62682);
      }
      
      public final void it(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(62673);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onModifyGroupInfo", paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(62673);
      }
      
      public final void iuM()
      {
        AppMethodBeat.i(62671);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSelfHoldOnBegin" });
        AppMethodBeat.o(62671);
      }
      
      public final void iuN()
      {
        AppMethodBeat.i(62672);
        com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "onSelfHoldOnEnd" });
        AppMethodBeat.o(62672);
      }
      
      public final void lc(List<MultiTalkGroup> paramAnonymousList)
      {
        AppMethodBeat.i(62677);
        com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "onActiveMultiTalkList ", paramAnonymousList });
        if (e.a(e.this) != null) {
          e.a(e.this);
        }
        AppMethodBeat.o(62677);
      }
      
      public final void o(MultiTalkGroup paramAnonymousMultiTalkGroup)
      {
        AppMethodBeat.i(62663);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onCreateRoom", paramAnonymousMultiTalkGroup });
        if (com.tencent.pb.common.a.a.ZdL) {
          Toast.makeText(com.tencent.pb.common.c.c.NYh, "onCreateRoom ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
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
          if (com.tencent.pb.common.a.a.ZdL) {
            Toast.makeText(com.tencent.pb.common.c.c.NYh, "onEnterRoom ".concat(String.valueOf(paramAnonymousMultiTalkGroup)), 0).show();
          }
        }
        AppMethodBeat.o(62668);
      }
      
      public final void r(int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(62667);
        com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "onErr errCode: ", Integer.valueOf(paramAnonymousInt), " data: ", paramAnonymousObject });
        if (e.a(e.this) != null) {
          e.a(e.this).r(paramAnonymousInt, paramAnonymousObject);
        }
        AppMethodBeat.o(62667);
      }
      
      public final void uy(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(62674);
        com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "onMuteStateChange", Boolean.valueOf(paramAnonymousBoolean) });
        if (e.a(e.this) != null) {
          e.a(e.this).uy(paramAnonymousBoolean);
        }
        AppMethodBeat.o(62674);
      }
    };
    AppMethodBeat.o(62610);
  }
  
  public static e iuL()
  {
    AppMethodBeat.i(62609);
    if (ZVo == null) {}
    try
    {
      if (ZVo == null) {
        ZVo = new e();
      }
      e locale = ZVo;
      AppMethodBeat.o(62609);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(62609);
    }
  }
  
  public static void mu(Context paramContext)
  {
    AppMethodBeat.i(62611);
    com.tencent.pb.common.c.c.NYh = paramContext;
    com.tencent.f.i.mo(paramContext);
    AppMethodBeat.o(62611);
  }
  
  public final boolean In(boolean paramBoolean)
  {
    AppMethodBeat.i(62624);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "holadMultiTalk isHold", Boolean.valueOf(paramBoolean) });
    f localf;
    if (paramBoolean)
    {
      localf = a.iut();
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "startHoldOn" });
      localf.ZWq = true;
      localf.ux(false);
      com.tencent.pb.common.c.g.runOnMainThread(new g.14(localf.ZWc));
    }
    for (;;)
    {
      AppMethodBeat.o(62624);
      return true;
      localf = a.iut();
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "endHoldOn" });
      localf.ZWq = false;
      localf.iuQ();
      if ((localf.gyH()) && (localf.EmI))
      {
        localf.ux(true);
        com.tencent.pb.common.c.g.runOnMainThread(new g.15(localf.ZWc));
      }
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.f Q(int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(62630);
    com.tencent.pb.talkroom.sdk.f localf = a.iut().Q(paramArrayOfInt);
    if (paramArrayOfInt == null) {}
    for (;;)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "receiveVideo imgBuffer size: ", Integer.valueOf(i), " MultiTalkVideoDecodeInfo: ", localf });
      AppMethodBeat.o(62630);
      return localf;
      i = paramArrayOfInt.length;
    }
  }
  
  public final boolean Q(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(62619);
    if (!com.tencent.pb.common.c.f.oB(paramString, a.iut().CSB))
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "addMultiTalkMember groupid is not same; multiTalkGroupid: ", paramString, a.iut().CSB });
      AppMethodBeat.o(62619);
      return false;
    }
    f localf = a.iut();
    int j = localf.DVO;
    long l = localf.NXM;
    int i;
    boolean bool;
    if (paramList == null)
    {
      i = 0;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "addrTalkRoomMember", paramString, Integer.valueOf(j), Long.valueOf(l), " users length: ", Integer.valueOf(i) });
      localf.ZWi = false;
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
        paramList = f.ld(paramList);
        if (paramList.length <= 0)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "addTalkRoomMember users is null" });
          bool = false;
        }
        else
        {
          paramString = new com.tencent.wecall.talkroom.a.b(paramString, localf.DVO, localf.NXM, paramList);
          bool = com.tencent.pb.common.b.e.ikG().b(paramString);
          localf.ZVU.ag(new String[] { "add", "req", String.valueOf(bool), String.valueOf(localf.state) });
        }
      }
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.f a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(208933);
    paramArrayOfInt = a.iut().a(paramArrayOfByte, paramArrayOfInt, paramInt);
    if (paramArrayOfByte == null) {}
    for (paramInt = i;; paramInt = paramArrayOfByte.length)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "receiveScreen imgBuffer size: ", Integer.valueOf(paramInt), " MultiTalkVideoDecodeInfo: ", paramArrayOfInt });
      AppMethodBeat.o(208933);
      return paramArrayOfInt;
    }
  }
  
  public final boolean a(com.tencent.pb.talkroom.sdk.a parama, com.tencent.pb.talkroom.sdk.e parame)
  {
    AppMethodBeat.i(62612);
    if (com.tencent.pb.common.c.c.NYh == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "init fail context: ", com.tencent.pb.common.c.c.NYh });
      AppMethodBeat.o(62612);
      return false;
    }
    try
    {
      this.ZVn = parama;
      f.a(parame);
      parama = a.iut();
      g.a locala = this.ZVq;
      parama.ZWc.a(locala);
      com.tencent.pb.common.b.f.ikJ().Zex = parame;
      a.ius();
      a.iuu();
      parama = new IntentFilter();
      parama.setPriority(2147483647);
      parama.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      com.tencent.pb.common.c.c.NYh.registerReceiver(this.ZVp, parama);
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
    AppMethodBeat.i(208919);
    paramString3 = a.iut().a(paramString1, paramInt1, paramLong, paramInt2, 100, paramString2, paramString3);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "enterMultiTalk multiTalkGroupid:", paramString1, " roomId: ", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " routId: ", Integer.valueOf(paramInt2), " wxGroupId: ", paramString2, " ret: ", paramString3 });
    if (paramString3 == f.b.ZWV)
    {
      AppMethodBeat.o(208919);
      return true;
    }
    AppMethodBeat.o(208919);
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, List<String> paramList, String paramString3)
  {
    AppMethodBeat.i(208916);
    f localf = a.iut();
    localf.ZVL = paramString3;
    paramString3 = f.ld(paramList);
    int i;
    if (paramString3.length > 0)
    {
      if (TextUtils.isEmpty(null)) {
        break label309;
      }
      throw new NullPointerException();
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom cliendId: ", paramString1, " voiceSingle2MultiInfo: ", null, " memeberUuids size: ", Integer.valueOf(paramString3.length), "routeId", Integer.valueOf(i), " context: ", null, " type: ", Integer.valueOf(0), " playId: ", Long.valueOf(0L), " sdkKey: ", null });
      if (com.tencent.pb.a.a.a.ilb()) {
        break label338;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.ilb()), " isBindMobile: ", Boolean.valueOf(com.tencent.pb.a.a.a.ilc()) });
      h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "noAuth" });
    }
    for (;;)
    {
      paramString1 = null;
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "createTalkRoom clientId is: ", paramString1, "wXgroupId: ", paramString2, " creatorUsrName: ", com.tencent.pb.a.a.a.ila(), " usrnameList: ", paramList });
      if (paramString1 == null) {
        break label1006;
      }
      AppMethodBeat.o(208916);
      return true;
      label309:
      i = new Random().nextInt() << 16 | com.tencent.pb.a.a.a.ila().hashCode() & 0xFFFF;
      break;
      label338:
      if (!com.tencent.pb.common.b.h.isNetworkConnected())
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom isNetworkConnected is false" });
        h.aCA(-4003);
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "noNetwork" });
      }
      else if (localf.gyH())
      {
        if (localf.gyH()) {
          h.aCA(-4002);
        }
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "isBusy" });
      }
      else if (TextUtils.isEmpty(paramString1))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom cliendId is null" });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "cliendIdnull" });
      }
      else if (!i.bEt(paramString1))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom groupId is not cliend id: ", paramString1 });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "isnotcliendId" });
      }
      else
      {
        if (c.iuI().bEf(paramString1) == null) {
          c.iuI().f(paramString1, paramString2, paramString3);
        }
        localf.ZVU.reset();
        localf.IJ(false);
        localf.iuP();
        if (localf.giH()) {
          break label700;
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "createTalkRoom initEngine fail" });
        h.a("", paramString1, 0, 0L, new String[] { "create", "req", "false", "initEnginefail" });
        localf.IJ(false);
      }
    }
    label700:
    localf.ZVU.ive();
    localf.CSB = paramString1;
    localf.ZWg = paramString1;
    localf.Zel = i;
    localf.ZVD = paramString1;
    localf.setState(1);
    localf.NKr = true;
    Object localObject = new f.a(localf);
    ((f.a)localObject).groupId = localf.CSB;
    ((f.a)localObject).ZWP = paramString3;
    ((f.a)localObject).ZWQ = null;
    ((f.a)localObject).ZeV = i;
    ((f.a)localObject).type = 0;
    ((f.a)localObject).ZWR = 0L;
    ((f.a)localObject).ZWS = null;
    ((f.a)localObject).ZWT = false;
    ((f.a)localObject).ZWU = paramString2;
    paramString3 = Message.obtain();
    paramString3.what = 2;
    paramString3.obj = localObject;
    localf.mHandler.removeMessages(2);
    localObject = c.iuI().bEf(localf.CSB);
    if (localObject == null) {
      com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "isOnlyMySelfInGroup talkroom is null" });
    }
    for (;;)
    {
      localf.mHandler.sendMessage(paramString3);
      localf.ZWi = true;
      break;
      localObject = ((TalkRoom)localObject).iuz();
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
    label1006:
    AppMethodBeat.o(208916);
    return false;
  }
  
  public final boolean aAg(int paramInt)
  {
    AppMethodBeat.i(62627);
    if (!a.iut().gyH())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "switchMultiTalkVideo isWorking is false" });
      AppMethodBeat.o(62627);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "switchMultiTalkVideo action: ", Integer.valueOf(paramInt) });
    Object localObject = a.iut();
    if (TextUtils.isEmpty(((f)localObject).CSB))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "switchMultiTalkVideo mGroupId is null" });
      AppMethodBeat.o(62627);
      return false;
    }
    ((f)localObject).ZVM = paramInt;
    localObject = new m(((f)localObject).CSB, ((f)localObject).DVO, ((f)localObject).NXM, paramInt, ((f)localObject).ZVC, 0, null, null);
    boolean bool = com.tencent.pb.common.b.e.ikG().b((com.tencent.pb.common.b.d)localObject);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "switchMultiTalkVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62627);
    return bool;
  }
  
  public final boolean aPY(String paramString)
  {
    AppMethodBeat.i(62620);
    if (!com.tencent.pb.common.c.f.oB(paramString, a.iut().CSB))
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "exitMultiTalk groupid is not same; multiTalkGroupid: ", paramString, a.iut().CSB });
      f.e locale;
      f localf;
      if (a.iut().bEo(paramString))
      {
        locale = a.iut().bEn(paramString);
        localf = a.iut();
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
      for (l = 0L;; l = locale.DPJ)
      {
        localf.c(paramString, i, l, 1);
        AppMethodBeat.o(62620);
        return false;
        i = locale.roomId;
        break;
      }
    }
    int i = a.iut().DVO;
    long l = a.iut().NXM;
    boolean bool = a.iut().ba(paramString, 1, 100);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "exitMultiTalk groupId: ", paramString, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(l) });
    AppMethodBeat.o(62620);
    return bool;
  }
  
  public final boolean aQs(String paramString)
  {
    AppMethodBeat.i(62628);
    if (!a.iut().gyH())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "subscribeLargeVideo isWorking is false" });
      AppMethodBeat.o(62628);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "subscribeLargeVideo ownerUserName: ", paramString });
    f localf = a.iut();
    if (TextUtils.isEmpty(localf.CSB))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "subscribeLargeVideo mGroupId null " });
      AppMethodBeat.o(62628);
      return false;
    }
    paramString = new k(localf.CSB, localf.DVO, localf.NXM, paramString);
    boolean bool = com.tencent.pb.common.b.e.ikG().b(paramString);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "subscribeLargeVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62628);
    return bool;
  }
  
  public final com.tencent.pb.talkroom.sdk.g b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    int j = 0;
    AppMethodBeat.i(62631);
    com.tencent.pb.talkroom.sdk.g localg = a.iut().b(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
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
  
  public final List<String> bCJ(String paramString)
  {
    AppMethodBeat.i(62621);
    if (!com.tencent.pb.common.c.f.oB(paramString, a.iut().CSB))
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "getTalkingMember groupid is not same; multiTalkGroupid: ", paramString, a.iut().CSB });
      AppMethodBeat.o(62621);
      return null;
    }
    Object localObject1 = c.iuI().bEf(paramString);
    if (localObject1 == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getTalkingMember talkroom is null: groupId: ", paramString });
      AppMethodBeat.o(62621);
      return null;
    }
    localObject1 = ((TalkRoom)localObject1).iuA();
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
        localObject2 = a.iut();
        i = locald.getMemberId();
        if (((f)localObject2).ZVV == null) {
          break label231;
        }
        localObject2 = ((f)localObject2).ZVV;
        if ((!com.tencent.pb.common.a.a.ZdM) || (((b)localObject2).ZVf == null)) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label234;
        }
        paramString.add(locald.iuK());
        break;
        if (((b)localObject2).ZVf.GetVoiceActivity(i) > 0)
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
  
  public final Map<String, Integer> bCK(String paramString)
  {
    AppMethodBeat.i(208923);
    if (!com.tencent.pb.common.c.f.oB(paramString, a.iut().CSB))
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "getTalkingEnergyMember groupid is not same; multiTalkGroupid: ", paramString, a.iut().CSB });
      AppMethodBeat.o(208923);
      return null;
    }
    Object localObject = c.iuI().bEf(paramString);
    if (localObject == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getTalkingMember talkroom is null: groupId: ", paramString });
      AppMethodBeat.o(208923);
      return null;
    }
    paramString = ((TalkRoom)localObject).iuA();
    localObject = new HashMap();
    Iterator localIterator = paramString.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald != null)
      {
        f localf = a.iut();
        int i = locald.getMemberId();
        paramString = Integer.valueOf(0);
        if (localf.ZVV != null)
        {
          paramString = localf.ZVV;
          if ((com.tencent.pb.common.a.a.ZdM) && (paramString.ZVf != null)) {
            break label219;
          }
        }
        label219:
        for (paramString = Integer.valueOf(0);; paramString = Integer.valueOf(paramString.ZVf.GetVoiceActivity(i)))
        {
          i = paramString.intValue();
          if (i <= 0) {
            break;
          }
          ((Map)localObject).put(locald.iuK(), Integer.valueOf(i));
          break;
        }
      }
    }
    AppMethodBeat.o(208923);
    return localObject;
  }
  
  public final boolean bCL(String paramString)
  {
    AppMethodBeat.i(208925);
    if (!a.iut().gyH())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "DoScreenSharingSecurityCheck isWorking is false" });
      AppMethodBeat.o(208925);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "DoScreenSharingSecurityCheck fileMd5: ", paramString, " fileId: ", null });
    f localf = a.iut();
    if (TextUtils.isEmpty(localf.CSB))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "DoScreenSharingSecurityCheck mGroupId is null" });
      AppMethodBeat.o(208925);
      return false;
    }
    paramString = new m(localf.CSB, localf.DVO, localf.NXM, 103, localf.ZVC, 0, paramString, null);
    boolean bool = com.tencent.pb.common.b.e.ikG().b(paramString);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "DoScreenSharingSecurityCheck ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(208925);
    return bool;
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(208931);
    int j = a.iut().c(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "sendVideo buffer size: ", Integer.valueOf(i), " len: ", Integer.valueOf(paramInt1), " w: ", Integer.valueOf(paramInt2), " h: ", Integer.valueOf(paramInt3), " format: ", Integer.valueOf(paramInt4), " mode: ", Integer.valueOf(paramInt5) });
      AppMethodBeat.o(208931);
      return j;
    }
  }
  
  public final int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(208932);
    int j;
    if (paramArrayOfByte == null)
    {
      i = 0;
      com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "sendScreen buffer size: ", Integer.valueOf(i), " len: ", Integer.valueOf(paramInt1), " w: ", Integer.valueOf(paramInt2), " h: ", Integer.valueOf(paramInt3), " format: ", Integer.valueOf(paramInt4) });
      j = a.iut().d(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
      if (paramArrayOfByte != null) {
        break label231;
      }
    }
    label231:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      com.tencent.pb.common.c.b.i("TalkRoomSdkApi", new Object[] { "sendScreen buffer size: ", Integer.valueOf(i), " len: ", Integer.valueOf(paramInt1), " w: ", Integer.valueOf(paramInt2), " h: ", Integer.valueOf(paramInt3), " format: ", Integer.valueOf(paramInt4), " ret: ", Integer.valueOf(j) });
      AppMethodBeat.o(208932);
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
      com.tencent.pb.common.b.f.ikJ().v(paramInt2, paramArrayOfByte);
    }
    for (;;)
    {
      AppMethodBeat.o(62622);
      return true;
      i = paramArrayOfByte.length;
      break;
      label109:
      paramArrayOfByte = com.tencent.pb.common.b.f.ikJ();
      com.tencent.pb.common.b.f.a locala = paramArrayOfByte.aAe(paramInt2);
      if (locala != null)
      {
        com.tencent.pb.common.c.b.w("NETCMD", new Object[] { "CLTRCV FAIL", Integer.valueOf(paramInt2), locala.ZeA, Integer.valueOf(1), Integer.valueOf(paramInt1) });
        paramArrayOfByte.a(locala, -1, null);
      }
    }
  }
  
  public final boolean dq(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62623);
    com.tencent.pb.common.b.f.ikJ();
    int i = com.tencent.pb.common.b.f.dp(paramArrayOfByte);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "handleMultiTalkNotify ret: ", Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(62623);
      return true;
    }
    AppMethodBeat.o(62623);
    return false;
  }
  
  public final void ds(int paramInt, String paramString)
  {
    AppMethodBeat.i(62626);
    com.tencent.pb.a.a.a.aAf(paramInt);
    com.tencent.pb.a.a.a.bCI(paramString);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "setWxUinAndUsrName uin: ", Integer.valueOf(paramInt), " usrname: ", paramString });
    AppMethodBeat.o(62626);
  }
  
  public final boolean gd(List<a.aq> paramList)
  {
    AppMethodBeat.i(183716);
    if (!a.iut().gyH())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "subscribeGeneralVideo isWorking is false" });
      AppMethodBeat.o(183716);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "subscribeGeneralVideo memberListInfo: ", paramList });
    f localf = a.iut();
    if (TextUtils.isEmpty(localf.CSB))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "subscribeGeneralVideo mGroupId null " });
      AppMethodBeat.o(183716);
      return false;
    }
    paramList = new j(localf.CSB, localf.DVO, localf.NXM, paramList);
    boolean bool = com.tencent.pb.common.b.e.ikG().b(paramList);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "subscribeGeneralVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(183716);
    return bool;
  }
  
  public final boolean ild()
  {
    AppMethodBeat.i(62615);
    try
    {
      com.tencent.pb.common.c.b.ikY();
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
  
  public final String ile()
  {
    AppMethodBeat.i(62625);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("client_");
    ((StringBuilder)localObject).append(com.tencent.pb.a.a.a.ila());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = ((StringBuilder)localObject).toString();
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "genMultiTalkClientId clientId: ", localObject });
    AppMethodBeat.o(62625);
    return localObject;
  }
  
  public final boolean kW(List<a.ap> paramList)
  {
    AppMethodBeat.i(208929);
    if (!a.iut().gyH())
    {
      com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "subscribeScreenSharingVideoForUserList isWorking is false" });
      AppMethodBeat.o(208929);
      return false;
    }
    com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "subscribeScreenSharingVideoForUserList memberListInfo: ", paramList });
    f localf = a.iut();
    if (TextUtils.isEmpty(localf.CSB))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "subscribeScreenSharingVideo mGroupId null " });
      AppMethodBeat.o(208929);
      return false;
    }
    paramList = new l(localf.CSB, localf.DVO, localf.NXM, paramList);
    boolean bool = com.tencent.pb.common.b.e.ikG().b(paramList);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "subscribeScreenSharingVideo ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(208929);
    return bool;
  }
  
  public final boolean o(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(208917);
    f localf = a.iut();
    localf.ZVL = paramString3;
    paramString2 = localf.a(paramString1, localf.DVO, localf.NXM, paramInt, 1, paramString2, paramString3);
    com.tencent.pb.common.c.b.w("TalkRoomSdkApi", new Object[] { "enterMultiTalk multiTalkGroupid:", paramString1, " isAccept: ", Boolean.TRUE, " routId: ", Integer.valueOf(paramInt), " ret: ", paramString2 });
    if (paramString2 == f.b.ZWV)
    {
      AppMethodBeat.o(208917);
      return true;
    }
    AppMethodBeat.o(208917);
    return false;
  }
  
  public final int screenTrans(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(208934);
    paramInt1 = a.iut().screenTrans(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramArrayOfByte2, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.o(208934);
    return paramInt1;
  }
  
  public final int setAppCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = -1;
    AppMethodBeat.i(62632);
    Object localObject = a.iut();
    if (((f)localObject).ZVV == null) {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "setAppCmd type: ", Integer.valueOf(paramInt1), " engine is null" });
    }
    for (;;)
    {
      com.tencent.pb.common.c.b.d("TalkRoomSdkApi", new Object[] { "setAppCmd type: ", Integer.valueOf(paramInt1), " paramLen: ", Integer.valueOf(paramInt2), " ret: ", Integer.valueOf(i) });
      AppMethodBeat.o(62632);
      return i;
      localObject = ((f)localObject).ZVV;
      if ((paramArrayOfByte == null) || (((b)localObject).ZVf == null)) {
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:setAppCmd null, params:", paramArrayOfByte, ", engine:", ((b)localObject).ZVf });
      } else {
        i = ((b)localObject).ZVf.setAppCmd(paramInt1, paramArrayOfByte, paramInt2);
      }
    }
  }
  
  public final void uM(boolean paramBoolean)
  {
    AppMethodBeat.i(62614);
    a.iut();
    com.tencent.pb.talkroom.sdk.e locale = f.ivc();
    if (locale != null) {}
    for (boolean bool = locale.uE(paramBoolean);; bool = false)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "switchSpeakerPhone", Boolean.valueOf(paramBoolean), " ret: ", Boolean.valueOf(bool), " realret: ", Boolean.valueOf(f.ivb()), " wxCallBack: ", locale });
      AppMethodBeat.o(62614);
      return;
    }
  }
  
  public final void uN(boolean paramBoolean)
  {
    AppMethodBeat.i(62613);
    f localf = a.iut();
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "setMute isMute: ", Boolean.valueOf(paramBoolean) });
    localf.mIsMute = paramBoolean;
    com.tencent.pb.common.c.g.runOnMainThread(new g.17(localf.ZWc, paramBoolean));
    AppMethodBeat.o(62613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.e
 * JD-Core Version:    0.7.0.1
 */