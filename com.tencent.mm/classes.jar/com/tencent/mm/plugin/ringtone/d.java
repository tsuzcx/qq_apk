package com.tencent.mm.plugin.ringtone;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.notification.PluginNotification;
import com.tencent.mm.plugin.recordvideo.model.audio.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/RingtoneManager;", "", "()V", "KEY_SHOW_CALL_ME_ICON", "", "KV_EXCLUSIVE_NAME", "KV_NAME", "KV_PARAMS_NAME", "RINGTONE_NAME", "TAG", "accountKeyPrefix", "accountScope", "Lkotlinx/coroutines/CoroutineScope;", "checkedUsername", "exclusiveMMKv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "keyParamsMMKv", "mExclusiveList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "mmkv", "ringtoneCheckJob", "Lkotlinx/coroutines/Job;", "cacheRingtone", "", "toUser", "ringtone", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkIfChannelModifiedByUser", "", "checkIfRingtoneSetup", "deleteAllVoipChannel", "deleteNonMyVoipChannel", "getAccountKey", "key", "getCommonRingtone", "getDefaultStartRing", "getExclusiveCache", "username", "getGlobalRingtoneCache", "getIsShowEnableCallerListenMyRingBackSwitch", "getLastSetTime", "", "getVoipExclusiveList", "", "Lcom/tencent/mm/plugin/ringtone/params/ExclusiveInfo;", "getVoipRingtoneChannelInUse", "getVoipRingtoneInfo", "getVoipRingtoneInfoInUse", "onAccountInitialized", "onAccountRelease", "postCheckRingtone", "resetVoipRingtoneInfo", "newRingtone", "saveIsShowEnableCallerListenMyRingBackSwitch", "isShow", "saveVoipExclusiveInfo", "ringtoneInfo", "seq", "saveVoipRingtoneInfo", "setCheckedUsername", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private static MultiProcessMMKV OBA;
  private static aq OBB;
  private static cb OBC;
  private static String OBD;
  private static HashSet<String> OBE;
  public static final d OBx;
  private static String OBy;
  private static MultiProcessMMKV OBz;
  private static MultiProcessMMKV eMf;
  
  static
  {
    AppMethodBeat.i(273284);
    OBx = new d();
    OBy = "";
    eMf = MultiProcessMMKV.getMMKV(UO("mmkv_ringtone_manager"));
    OBz = MultiProcessMMKV.getMMKV(UO("mmkv_exclusive_manager"));
    OBA = MultiProcessMMKV.getMMKV(UO("mmkv_ringtone_params"));
    OBB = ar.b(ar.d((f)bg.kCi()), (f)cx.g(null));
    OBD = "";
    OBE = new HashSet();
    AppMethodBeat.o(273284);
  }
  
  public static final void BM(boolean paramBoolean)
  {
    AppMethodBeat.i(273188);
    OBA.putBoolean("show_enable_caller_listen_my_ringback", paramBoolean);
    AppMethodBeat.o(273188);
  }
  
  private static String UO(String paramString)
  {
    AppMethodBeat.i(273130);
    paramString = OBy + '#' + paramString;
    AppMethodBeat.o(273130);
    return paramString;
  }
  
  public static final void a(String paramString, com.tencent.mm.plugin.ringtone.g.d paramd, long paramLong)
  {
    AppMethodBeat.i(273175);
    s.u(paramString, "username");
    if (paramd != null)
    {
      if (!s.p(paramString, z.bAM()))
      {
        com.tencent.mm.plugin.ringtone.g.a locala = new com.tencent.mm.plugin.ringtone.g.a((byte)0);
        locala.OCX = paramd;
        locala.OCY = paramLong;
        locala.name = paramString;
        MultiProcessMMKV localMultiProcessMMKV = OBz;
        i locali = new i();
        paramd = locala.OCX;
        if (paramd == null) {
          paramd = "{}";
        }
        for (;;)
        {
          locali.m("info", paramd);
          locali.m("name", locala.name);
          locali.t("order", locala.OCY);
          paramd = locali.toString();
          s.s(paramd, "JSONObject().apply {\n   …der)\n        }.toString()");
          localMultiProcessMMKV.putString(paramString, paramd);
          AppMethodBeat.o(273175);
          return;
          String str = paramd.toJson();
          paramd = str;
          if (str == null) {
            paramd = "{}";
          }
        }
      }
      OBz.putString(z.bAM(), paramd.toJson());
      AppMethodBeat.o(273175);
      return;
    }
    if (!s.p(paramString, z.bAM())) {
      OBE.remove(paramString);
    }
    OBz.remove(paramString);
    AppMethodBeat.o(273175);
  }
  
  public static final com.tencent.mm.plugin.ringtone.g.d aUs(String paramString)
  {
    AppMethodBeat.i(273204);
    s.u(paramString, "username");
    paramString = OBz.getString(paramString, "");
    if ((paramString == null) || (n.bp((CharSequence)paramString)))
    {
      AppMethodBeat.o(273204);
      return null;
    }
    new com.tencent.mm.plugin.ringtone.g.a((byte)0);
    paramString = com.tencent.mm.plugin.ringtone.g.a.aUw(paramString).OCX;
    AppMethodBeat.o(273204);
    return paramString;
  }
  
  public static final com.tencent.mm.plugin.ringtone.g.d aUt(String paramString)
  {
    AppMethodBeat.i(273233);
    s.u(paramString, "toUser");
    paramString = UO(s.X(com.tencent.mm.bq.b.XNi, paramString));
    paramString = eMf.getString(paramString, null);
    if (paramString == null)
    {
      AppMethodBeat.o(273233);
      return null;
    }
    com.tencent.mm.plugin.ringtone.g.d.a locala = com.tencent.mm.plugin.ringtone.g.d.ODu;
    paramString = com.tencent.mm.plugin.ringtone.g.d.a.aUz(paramString);
    AppMethodBeat.o(273233);
    return paramString;
  }
  
  public static final com.tencent.mm.plugin.ringtone.g.d aUu(String paramString)
  {
    Object localObject = null;
    int j = 1;
    AppMethodBeat.i(273244);
    s.u(paramString, "toUser");
    OBD = paramString;
    paramString = aUt(paramString);
    int i;
    label47:
    String str1;
    if (paramString == null)
    {
      paramString = null;
      if ((paramString == null) || (paramString.gOE() != true)) {
        break label153;
      }
      i = 1;
      str1 = paramString;
      if (i == 0) {
        str1 = null;
      }
      paramString = aUt("");
      if (paramString != null) {
        break label158;
      }
      paramString = null;
      label67:
      if ((paramString == null) || (paramString.gOE() != true)) {
        break label168;
      }
      i = j;
      label81:
      if (i != 0) {
        break label189;
      }
      paramString = (String)localObject;
    }
    label153:
    label158:
    label168:
    label189:
    for (;;)
    {
      localObject = com.tencent.mm.plugin.ringtone.g.d.ODu;
      localObject = com.tencent.mm.plugin.ringtone.g.d.a.gOF();
      String str2 = com.tencent.mm.bq.b.iGr();
      s.s(str2, "getVoipChannelId()");
      ((com.tencent.mm.plugin.ringtone.g.d)localObject).aUx(str2);
      ((com.tencent.mm.plugin.ringtone.g.d)localObject).a(com.tencent.mm.plugin.ringtone.g.c.ODq);
      if (str1 == null)
      {
        if (paramString == null)
        {
          AppMethodBeat.o(273244);
          return localObject;
          paramString.a(com.tencent.mm.plugin.ringtone.g.c.ODs);
          break;
          i = 0;
          break label47;
          paramString.a(com.tencent.mm.plugin.ringtone.g.c.ODr);
          break label67;
          i = 0;
          break label81;
        }
        AppMethodBeat.o(273244);
        return paramString;
      }
      AppMethodBeat.o(273244);
      return str1;
    }
  }
  
  public static final String aUv(String paramString)
  {
    AppMethodBeat.i(273250);
    s.u(paramString, "toUser");
    String str = aUu(paramString).channelId;
    Log.i("MicroMsg.RingtoneManager", "getVoipRingtoneChannelInUse toUser:" + paramString + " channelId:" + str);
    AppMethodBeat.o(273250);
    return str;
  }
  
  public static final void aZq()
  {
    AppMethodBeat.i(273154);
    com.tencent.mm.kernel.h.baC();
    Object localObject2;
    if (com.tencent.mm.kernel.b.aZM())
    {
      OBD = "";
      com.tencent.mm.kernel.h.baC();
      Object localObject1 = MD5Util.getMD5String(com.tencent.mm.kernel.b.aZs());
      s.s(localObject1, "getMD5String(MMKernel.account().uinString)");
      OBy = n.jP((String)localObject1, 16);
      eMf = MultiProcessMMKV.getMMKV(UO("mmkv_ringtone_manager"));
      OBA = MultiProcessMMKV.getMMKV(UO("mmkv_ringtone_params"));
      OBz = MultiProcessMMKV.getMMKV(UO("mmkv_exclusive_manager"));
      if (Build.VERSION.SDK_INT >= 26)
      {
        Log.i("MicroMsg.RingtoneManager", "deleteNonMyVoipChannel");
        try
        {
          com.tencent.mm.kernel.h.baC();
          if (com.tencent.mm.kernel.b.aZM())
          {
            localObject1 = com.tencent.mm.bq.b.XNi;
            s.s(localObject1, "VOIP_RINGTONE_CHANNEL_ID");
            localObject1 = UO((String)localObject1);
            localObject2 = MMApplicationContext.getContext().getSystemService("notification");
            if (localObject2 != null) {
              break label181;
            }
            localObject1 = new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
            AppMethodBeat.o(273154);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.RingtoneManager", s.X("deleteNonMyVoipChannel error: ", localException.getLocalizedMessage()));
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(273154);
      return;
      label181:
      localObject2 = (NotificationManager)localObject2;
      Iterator localIterator = ((NotificationManager)localObject2).getNotificationChannels().iterator();
      while (localIterator.hasNext())
      {
        NotificationChannel localNotificationChannel = (NotificationChannel)localIterator.next();
        Object localObject3 = localNotificationChannel.getId();
        s.s(localObject3, "channel.id");
        localObject3 = (CharSequence)localObject3;
        String str = com.tencent.mm.bq.b.XNi;
        s.s(str, "VOIP_RINGTONE_CHANNEL_ID");
        if (n.i((CharSequence)localObject3, (CharSequence)str))
        {
          localObject3 = localNotificationChannel.getId();
          s.s(localObject3, "channel.id");
          if (!n.U((String)localObject3, localException, false))
          {
            Log.i("MicroMsg.RingtoneManager", "deleteNonMyVoipChannel id:%s", new Object[] { localNotificationChannel.getId() });
            ((NotificationManager)localObject2).deleteNotificationChannel(localNotificationChannel.getId());
          }
        }
      }
    }
  }
  
  public static final void b(String paramString, com.tencent.mm.plugin.ringtone.g.d paramd)
  {
    AppMethodBeat.i(273261);
    s.u(paramString, "toUser");
    Log.i("MicroMsg.RingtoneManager", s.X("resetVoipRingtoneInfo toUser:", paramString));
    Object localObject2 = aUt(paramString);
    String str2 = aUv(paramString);
    Object localObject1;
    label107:
    AudioAttributes localAudioAttributes;
    if (paramd == null)
    {
      if (localObject2 == null)
      {
        localObject1 = null;
        y.deleteFile((String)localObject1);
      }
    }
    else
    {
      s.u(paramString, "toUser");
      localObject1 = UO(s.X(com.tencent.mm.bq.b.XNi, paramString));
      if (paramd == null) {
        break label190;
      }
      paramd.aUx(s.X((String)localObject1, Long.valueOf(System.currentTimeMillis())));
      paramd.createTime = System.currentTimeMillis();
      eMf.putString((String)localObject1, paramd.toJson());
      if (Build.VERSION.SDK_INT >= 26)
      {
        if (!c.gOk()) {
          break label201;
        }
        localAudioAttributes = new AudioAttributes.Builder().setUsage(6).setContentType(2).build();
        label142:
        if (localObject2 != null) {
          break label224;
        }
        localObject1 = "";
        label149:
        if (paramd != null) {
          break label241;
        }
        localObject2 = "";
        label156:
        if (paramd != null) {
          break label261;
        }
        paramd = "";
      }
    }
    for (;;)
    {
      PluginNotification.resetVoipRingtoneChannel(paramString, (String)localObject1, (String)localObject2, str2, paramd, localAudioAttributes);
      AppMethodBeat.o(273261);
      return;
      localObject1 = ((com.tencent.mm.plugin.ringtone.g.d)localObject2).gOC();
      break;
      label190:
      eMf.remove((String)localObject1);
      break label107;
      label201:
      localAudioAttributes = new AudioAttributes.Builder().setUsage(5).setContentType(2).build();
      break label142;
      label224:
      localObject2 = ((com.tencent.mm.plugin.ringtone.g.d)localObject2).channelId;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label149;
      }
      localObject1 = "";
      break label149;
      label241:
      String str1 = paramd.channelId;
      localObject2 = str1;
      if (str1 != null) {
        break label156;
      }
      localObject2 = "";
      break label156;
      label261:
      str1 = paramd.gOC();
      paramd = str1;
      if (str1 == null) {
        paramd = "";
      }
    }
  }
  
  public static boolean b(com.tencent.mm.plugin.ringtone.g.d paramd)
  {
    AppMethodBeat.i(273278);
    s.u(paramd, "ringtone");
    Object localObject;
    if (Build.VERSION.SDK_INT >= 26) {
      try
      {
        localObject = MMApplicationContext.getContext().getSystemService("notification");
        if (localObject == null)
        {
          paramd = new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
          AppMethodBeat.o(273278);
          throw paramd;
        }
      }
      catch (Exception paramd)
      {
        Log.e("MicroMsg.RingtoneManager", s.X("checkIfChannelModifiedByUser error:", paramd.getLocalizedMessage()));
      }
    }
    label201:
    label203:
    label206:
    for (;;)
    {
      AppMethodBeat.o(273278);
      return false;
      Uri localUri = ((NotificationManager)localObject).getNotificationChannel(paramd.channelId).getSound();
      localObject = localUri.getPath();
      if (localObject == null)
      {
        localObject = null;
        label105:
        if (s.p(localObject, n.bJJ(paramd.gOC()))) {
          break label201;
        }
        localObject = localUri.getPath();
        if ((localObject == null) || (n.rs((String)localObject, String.valueOf(b.e.phonering)) != true)) {
          break label203;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label206;
        }
        Log.i("MicroMsg.RingtoneManager", "find user modify channel! sound path:" + localUri.getPath() + ", ringtone path:" + paramd.gOC());
        AppMethodBeat.o(273278);
        return true;
        localObject = n.bJJ((String)localObject);
        break label105;
        break;
      }
    }
  }
  
  public static final boolean gOp()
  {
    AppMethodBeat.i(273196);
    boolean bool = OBA.getBoolean("show_enable_caller_listen_my_ringback", false);
    AppMethodBeat.o(273196);
    return bool;
  }
  
  public static final com.tencent.mm.plugin.ringtone.g.d gOq()
  {
    AppMethodBeat.i(273209);
    Object localObject = OBz.getString(z.bAM(), "");
    if ((localObject == null) || (n.bp((CharSequence)localObject)))
    {
      localObject = com.tencent.mm.plugin.ringtone.g.d.ODu;
      localObject = com.tencent.mm.plugin.ringtone.g.d.a.gOF();
      AppMethodBeat.o(273209);
      return localObject;
    }
    com.tencent.mm.plugin.ringtone.g.d.a locala = com.tencent.mm.plugin.ringtone.g.d.ODu;
    localObject = com.tencent.mm.plugin.ringtone.g.d.a.aUz((String)localObject);
    AppMethodBeat.o(273209);
    return localObject;
  }
  
  public static final boolean gOr()
  {
    AppMethodBeat.i(273214);
    String[] arrayOfString = OBz.allKeys();
    int i;
    String str;
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      i = 0;
      if (i < j)
      {
        str = arrayOfString[i];
        if (!s.p(str, z.bAM())) {}
      }
    }
    for (;;)
    {
      if (str == null) {
        break label65;
      }
      AppMethodBeat.o(273214);
      return true;
      i += 1;
      break;
      str = null;
    }
    label65:
    AppMethodBeat.o(273214);
    return false;
  }
  
  public static final List<com.tencent.mm.plugin.ringtone.g.a> gOs()
  {
    AppMethodBeat.i(273223);
    Object localObject1 = OBz.allKeys();
    if (localObject1 == null) {}
    Object localObject2;
    for (localObject1 = null;; localObject1 = (List)localObject2)
    {
      localObject2 = new ArrayList();
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      String str;
      while (((Iterator)localObject1).hasNext())
      {
        str = (String)((Iterator)localObject1).next();
        str = OBz.getString(str, null);
        if (str != null)
        {
          new com.tencent.mm.plugin.ringtone.g.a((byte)0);
          ((ArrayList)localObject2).add(com.tencent.mm.plugin.ringtone.g.a.aUw(str));
        }
      }
      localObject2 = (Collection)new ArrayList();
      int k = localObject1.length;
      int i = 0;
      if (i < k)
      {
        str = localObject1[i];
        if (!s.p(str, z.bAM())) {}
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            ((Collection)localObject2).add(str);
          }
          i += 1;
          break;
        }
      }
    }
    Collections.sort((List)localObject2, Collections.reverseOrder());
    localObject1 = (List)localObject2;
    AppMethodBeat.o(273223);
    return localObject1;
  }
  
  public static final long gOt()
  {
    AppMethodBeat.i(273268);
    com.tencent.mm.plugin.ringtone.g.d locald = aUt("");
    if (locald == null)
    {
      AppMethodBeat.o(273268);
      return 0L;
    }
    long l = locald.createTime;
    AppMethodBeat.o(273268);
    return l;
  }
  
  public static void gOu()
  {
    AppMethodBeat.i(273275);
    if (((CharSequence)OBD).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.RingtoneManager", s.X("postCheckRingtone: ", OBD));
        String str = OBD;
        OBD = "";
        cb localcb = OBC;
        if (localcb != null) {
          localcb.a(null);
        }
        OBC = j.a(OBB, null, null, (m)new c(str, null), 3);
      }
      AppMethodBeat.o(273275);
      return;
    }
  }
  
  public static final void onAccountRelease()
  {
    AppMethodBeat.i(273159);
    cb localcb = OBC;
    if (localcb != null) {
      localcb.a(null);
    }
    OBC = null;
    AppMethodBeat.o(273159);
  }
  
  public final Object a(String paramString, com.tencent.mm.plugin.ringtone.g.d paramd, kotlin.d.d<? super ah> paramd1)
  {
    AppMethodBeat.i(273294);
    Object localObject1;
    if ((paramd1 instanceof b))
    {
      localObject1 = (b)paramd1;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd1 = (kotlin.d.d<? super ah>)localObject1;; paramd1 = new b(this, paramd1))
    {
      localObject1 = paramd1.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd1.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273294);
        throw paramString;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Log.i("MicroMsg.RingtoneManager", s.X("cacheRingtone toUser:", paramString));
    for (;;)
    {
      try
      {
        localb = paramd.ODv;
        if (localb != null)
        {
          localObject1 = aUt(paramString);
          int i;
          if ((localObject1 != null) && (((com.tencent.mm.plugin.ringtone.g.d)localObject1).gOE() == true))
          {
            i = 1;
            Object localObject2;
            if (i != 0)
            {
              localObject2 = localb.mediaId;
              if (localObject1 == null)
              {
                localObject1 = null;
                if (s.p(localObject2, localObject1)) {
                  continue;
                }
              }
            }
            else
            {
              localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.k.NJr;
              localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.k.gIk();
              paramd1.L$0 = paramString;
              paramd1.Uf = paramd;
              paramd1.label = 1;
              localObject2 = new kotlin.d.h(kotlin.d.a.b.au(paramd1));
              ((com.tencent.mm.plugin.recordvideo.model.audio.k)localObject1).a(localb, (m)new k.c((kotlin.d.d)localObject2));
              localObject1 = ((kotlin.d.h)localObject2).kli();
              if (localObject1 == kotlin.d.a.a.aiwj) {
                s.u(paramd1, "frame");
              }
              paramd1 = (kotlin.d.d<? super ah>)localObject1;
              if (localObject1 != locala) {
                continue;
              }
              AppMethodBeat.o(273294);
              return locala;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          localObject1 = ((com.tencent.mm.plugin.ringtone.g.d)localObject1).getMediaId();
          continue;
          paramd = (com.tencent.mm.plugin.ringtone.g.d)paramd1.Uf;
          paramString = (String)paramd1.L$0;
          ResultKt.throwOnFailure(localObject1);
          paramd1 = (kotlin.d.d<? super ah>)localObject1;
          localObject1 = (String)paramd1;
          if (localObject1 != null)
          {
            paramd1 = c.lD(paramString, "Ringtone");
            y.O((String)localObject1, paramd1, false);
            s.u(paramd1, "path");
            localObject1 = paramd.ODv;
            if (localObject1 != null) {
              ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).path = paramd1;
            }
            paramd1 = paramd.ODv;
            if (paramd1 != null) {
              paramd1.hJv = true;
            }
            b(paramString, paramd);
          }
        }
      }
      catch (Exception paramString)
      {
        com.tencent.mm.plugin.thumbplayer.a.b localb;
        Log.e("MicroMsg.RingtoneManager", s.X("cacheRingtone fail:", paramString.getLocalizedMessage()));
        continue;
      }
      paramString = ah.aiuX;
      AppMethodBeat.o(273294);
      return paramString;
      Log.w("MicroMsg.RingtoneManager", "cacheRingtone, mediaId is same:" + localb.mediaId + ", skip cache!");
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    b(d paramd, kotlin.d.d<? super b> paramd1)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(272781);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.OBF.a(null, null, (kotlin.d.d)this);
      AppMethodBeat.o(272781);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(String paramString, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(272785);
      paramd = new c(this.OBG, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(272785);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(272783);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      kotlin.d.d locald;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272783);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject1 = (aq)this.L$0;
        paramObject = this.OBG;
        locald = (kotlin.d.d)this;
        this.L$0 = localObject1;
        this.label = 1;
        paramObject = c.a(paramObject, false, locald);
        if (paramObject == locala)
        {
          AppMethodBeat.o(272783);
          return locala;
        }
        break;
      case 1: 
        localObject1 = (aq)this.L$0;
        ResultKt.throwOnFailure(paramObject);
      }
      for (;;)
      {
        paramObject = (com.tencent.mm.plugin.ringtone.g.d)paramObject;
        if (ar.a((aq)localObject1))
        {
          localObject1 = d.OBx;
          Object localObject2 = this.OBG;
          locald = (kotlin.d.d)this;
          this.L$0 = null;
          this.label = 2;
          Log.i("MicroMsg.RingtoneManager", s.X("checkIfRingtoneSetup toUser:", localObject2));
          int i;
          Object localObject3;
          if (((CharSequence)localObject2).length() == 0)
          {
            i = 1;
            if (i == 0)
            {
              localObject3 = paramObject.ODB;
              switch (d.a.$EnumSwitchMapping$0[localObject3.ordinal()])
              {
              }
            }
          }
          for (;;)
          {
            label236:
            paramObject = ah.aiuX;
            do
            {
              do
              {
                if (paramObject != locala) {
                  break label419;
                }
                AppMethodBeat.o(272783);
                return locala;
                i = 0;
                break;
                Log.i("MicroMsg.RingtoneManager", "checkIfRingtoneSetup reset exclusive");
                localObject3 = d.aUt((String)localObject2);
                if ((localObject3 != null) && (((com.tencent.mm.plugin.ringtone.g.d)localObject3).gOE()) && (s.p(((com.tencent.mm.plugin.ringtone.g.d)localObject3).getMediaId(), paramObject.getMediaId()))) {
                  break label236;
                }
                localObject1 = ((d)localObject1).a((String)localObject2, paramObject, locald);
                paramObject = localObject1;
              } while (localObject1 == kotlin.d.a.a.aiwj);
              break label236;
              Log.i("MicroMsg.RingtoneManager", "checkIfRingtoneSetup reset global");
              d.b((String)localObject2, null);
              localObject2 = d.aUt("");
              if ((localObject2 != null) && (((com.tencent.mm.plugin.ringtone.g.d)localObject2).gOE()) && (s.p(((com.tencent.mm.plugin.ringtone.g.d)localObject2).getMediaId(), paramObject.getMediaId()))) {
                break label236;
              }
              localObject1 = ((d)localObject1).a("", paramObject, locald);
              paramObject = localObject1;
            } while (localObject1 == kotlin.d.a.a.aiwj);
            continue;
            Log.i("MicroMsg.RingtoneManager", "checkIfRingtoneSetup reset default");
            d.b((String)localObject2, null);
            d.b("", null);
          }
          ResultKt.throwOnFailure(paramObject);
        }
        label419:
        paramObject = ah.aiuX;
        AppMethodBeat.o(272783);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.d
 * JD-Core Version:    0.7.0.1
 */