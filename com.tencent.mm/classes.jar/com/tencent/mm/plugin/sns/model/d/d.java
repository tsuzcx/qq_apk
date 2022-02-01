package com.tencent.mm.plugin.sns.model.d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.b.a;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.data.u;
import com.tencent.mm.plugin.sns.data.u.a;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ar.a;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ai;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.SnsGalleryUI;
import com.tencent.mm.plugin.sns.ui.aq.c;
import com.tencent.mm.plugin.sns.ui.bp;
import com.tencent.mm.plugin.sns.ui.video.c.b;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.protocal.protobuf.ffx;
import com.tencent.mm.protocal.protobuf.ffy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Ljava.lang.Boolean;>;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/model/withta/WithTaComposeOp;", "Lcom/tencent/mm/sns_compose/api/IWithTaComposeOp;", "()V", "TAG", "", "mUserName", "getMUserName", "()Ljava/lang/String;", "setMUserName", "(Ljava/lang/String;)V", "withFriendsNameList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getWithFriendsNameList", "()Ljava/util/ArrayList;", "withFriendsStr", "getWithFriendsStr", "setWithFriendsStr", "clear", "", "entranceEnable", "", "getAvatarBitmap", "Landroid/graphics/Bitmap;", "userName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDisplayName", "getDisplayRemark", "getDisplayTime", "context", "Landroid/content/Context;", "createTime", "", "getImageFromUrl", "url", "getImagePath", "snsId", "mediaId", "requestThumb", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPage", "Lcom/tencent/mm/sns_compose/api/PageLoadResult;", "Lcom/tencent/mm/sns_compose/api/PageDataWrapper;", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "feedId", "", "pageSize", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSelfName", "getSnsMediaBitmap", "media", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "thumb", "(Lcom/tencent/mm/protocal/protobuf/MediaObj;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSnsVideoPath", "localId", "getSnsVideoTask", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoDownloadTask;", "getUsername", "getWithFriends", "imagePreview", "isSelf", "data", "Lcom/tencent/mm/sns_compose/api/GalleryData;", "isTogetherVideoEnabled", "ownerSetting", "showAlertListDialog", "scope", "Lkotlinx/coroutines/CoroutineScope;", "seq", "action", "tipsId", "cb", "Lkotlin/Function1;", "showDetailUI", "snsWithTaOpRequest", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startProfile", "username", "scene", "source", "unPackSnsId", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements com.tencent.mm.sns_compose.a.c
{
  public static final d QAS;
  private static final ArrayList<String> QAT;
  private static String QAU;
  private static String luk;
  
  static
  {
    AppMethodBeat.i(309634);
    QAS = new d();
    QAT = new ArrayList();
    QAU = "";
    luk = "";
    AppMethodBeat.o(309634);
  }
  
  public static void aZc(String paramString)
  {
    AppMethodBeat.i(309619);
    kotlin.g.b.s.u(paramString, "<set-?>");
    QAU = paramString;
    AppMethodBeat.o(309619);
  }
  
  public static void aZd(String paramString)
  {
    AppMethodBeat.i(309627);
    kotlin.g.b.s.u(paramString, "<set-?>");
    luk = paramString;
    AppMethodBeat.o(309627);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(309630);
    QAT.clear();
    QAU = "";
    AppMethodBeat.o(309630);
  }
  
  public static ArrayList<String> hhW()
  {
    return QAT;
  }
  
  public final com.tencent.mm.plugin.thumbplayer.downloader.h a(int paramInt1, dmz paramdmz, int paramInt2)
  {
    AppMethodBeat.i(309703);
    kotlin.g.b.s.u(paramdmz, "media");
    paramdmz = (com.tencent.mm.plugin.thumbplayer.downloader.h)new com.tencent.mm.plugin.sns.ui.video.c(paramdmz, paramInt2, kotlin.g.b.s.X("sns_table_", Integer.valueOf(paramInt1)), new com.tencent.mm.plugin.thumbplayer.f.b(System.currentTimeMillis()), (c.b)new a());
    AppMethodBeat.o(309703);
    return paramdmz;
  }
  
  public final Object a(long paramLong, int paramInt, kotlin.d.d<? super com.tencent.mm.sns_compose.a.e<com.tencent.mm.sns_compose.a.d<com.tencent.mm.sns_compose.a.f>>> paramd)
  {
    AppMethodBeat.i(309732);
    paramd = c.QAQ.a(paramLong, paramInt, luk, paramd);
    AppMethodBeat.o(309732);
    return paramd;
  }
  
  public final Object a(String paramString1, String paramString2, boolean paramBoolean, kotlin.d.d<? super String> paramd)
  {
    AppMethodBeat.i(309755);
    a.a locala = a.QAN;
    paramString1 = l.a((kotlin.d.f)bg.kCi(), (m)new a.a.b(paramString1, paramString2, paramBoolean, null), paramd);
    AppMethodBeat.o(309755);
    return paramString1;
  }
  
  public final String a(int paramInt, dmz paramdmz)
  {
    AppMethodBeat.i(309696);
    kotlin.g.b.s.u(paramdmz, "media");
    paramdmz = az.a(kotlin.g.b.s.X("sns_table_", Integer.valueOf(paramInt)), paramdmz);
    AppMethodBeat.o(309696);
    return paramdmz;
  }
  
  public final void a(Context paramContext, int paramInt, boolean paramBoolean, com.tencent.mm.sns_compose.a.a parama)
  {
    AppMethodBeat.i(309668);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(parama, "data");
    Intent localIntent = new Intent(paramContext, SnsGalleryUI.class);
    localIntent.putExtra("sns_gallery_userName", luk);
    localIntent.putExtra("sns_gallery_is_self", paramBoolean);
    localIntent.putExtra("sns_gallery_localId", paramInt);
    localIntent.putExtra("key_from_scene", 4);
    localIntent.putExtra("sns_gallery_position", parama.position);
    al.hgr().o(luk, parama.aczd);
    parama = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, parama.aYi(), "com/tencent/mm/plugin/sns/model/withta/WithTaComposeOp", "imagePreview", "(Landroid/content/Context;IZLcom/tencent/mm/sns_compose/api/GalleryData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)parama.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/sns/model/withta/WithTaComposeOp", "imagePreview", "(Landroid/content/Context;IZLcom/tencent/mm/sns_compose/api/GalleryData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(309668);
  }
  
  public final void a(Context paramContext, aq paramaq, String paramString, int paramInt1, int paramInt2, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(309726);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramaq, "scope");
    kotlin.g.b.s.u(paramString, "seq");
    kotlin.g.b.s.u(paramb, "cb");
    e.a locala = e.QAW;
    e.a.a(paramContext, paramaq, paramString, paramInt1, paramInt2, paramb);
    AppMethodBeat.o(309726);
  }
  
  public final String aSV()
  {
    AppMethodBeat.i(309644);
    String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).IE(luk);
    kotlin.g.b.s.s(str, "service(IContactCommDisp…tDisplayRemark(mUserName)");
    AppMethodBeat.o(309644);
    return str;
  }
  
  public final String aX(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(309685);
    kotlin.g.b.s.u(paramContext, "context");
    paramContext = bp.u(paramContext, paramInt * 1000L);
    if (paramContext == null)
    {
      AppMethodBeat.o(309685);
      return "";
    }
    AppMethodBeat.o(309685);
    return paramContext;
  }
  
  public final long aXe(String paramString)
  {
    AppMethodBeat.i(309663);
    kotlin.g.b.s.u(paramString, "snsId");
    long l = ai.aXe(paramString);
    AppMethodBeat.o(309663);
    return l;
  }
  
  public final Object b(dmz paramdmz, boolean paramBoolean, kotlin.d.d<? super Bitmap> paramd)
  {
    AppMethodBeat.i(309738);
    a.a locala = a.QAN;
    paramdmz = l.a((kotlin.d.f)bg.kCi(), (m)new a.a.a(paramdmz, paramBoolean, null), paramd);
    AppMethodBeat.o(309738);
    return paramdmz;
  }
  
  public final void b(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(309690);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "username");
    u.a locala = u.Qoz;
    u.a.b(paramContext, paramString, paramInt1, paramInt2);
    AppMethodBeat.o(309690);
  }
  
  public final void bQ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(309674);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "snsId");
    SnsInfo localSnsInfo = al.hgB().aZK(paramString);
    if (localSnsInfo == null)
    {
      Log.e("WithTaComposeOp", "showDetailUI snsInfo is null :snsId:%s", new Object[] { paramString });
      AppMethodBeat.o(309674);
      return;
    }
    Log.i("WithTaComposeOp", "showDetailUI snsId:%s localId:%d", new Object[] { paramString, Integer.valueOf(localSnsInfo.localid) });
    paramString = new Intent(paramContext, SnsCommentDetailUI.class);
    paramString.putExtra("INTENT_TALKER", luk);
    paramString.putExtra("INTENT_NEED_RPT_FEED", true);
    paramString.putExtra("INTENT_SNS_LOCAL_ID", ai.bF("sns_table_", localSnsInfo.localid));
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/sns/model/withta/WithTaComposeOp", "showDetailUI", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/sns/model/withta/WithTaComposeOp", "showDetailUI", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(309674);
  }
  
  public final Object f(String paramString, int paramInt, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(309718);
    if ((paramd instanceof d.b))
    {
      localObject = (d.b)paramd;
      if ((((d.b)localObject).label & 0x80000000) != 0) {
        ((d.b)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super Boolean>)localObject;; paramd = new d.b(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(309718);
        throw paramString;
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = new c.a();
    ((c.a)localObject).funcId = 5213;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnswithtaop";
    ffx localffx = new ffx();
    localffx.Tqa = t.aXD(paramString);
    localffx.action = paramInt;
    paramString = ah.aiuX;
    ((c.a)localObject).otE = ((com.tencent.mm.bx.a)localffx);
    ((c.a)localObject).otF = ((com.tencent.mm.bx.a)new ffy());
    paramString = ((c.a)localObject).bEF();
    localObject = com.tencent.mm.am.a.b.ovw;
    kotlin.g.b.s.s(paramString, "commReqResp");
    paramString = b.a.e(paramString);
    paramd.label = 1;
    paramd = kotlinx.coroutines.b.s.b(paramString, paramd);
    paramString = paramd;
    if (paramd == locala)
    {
      AppMethodBeat.o(309718);
      return locala;
      ResultKt.throwOnFailure(localObject);
      paramString = (String)localObject;
    }
    if (((com.tencent.mm.am.a.a)paramString).ovD == com.tencent.mm.am.b.b.ovB)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label312;
      }
      label277:
      paramString = (com.tencent.mm.am.a.a)paramString;
      if (paramString != null) {
        break label317;
      }
      paramInt = 0;
      label288:
      if (paramInt == 0) {
        break label337;
      }
    }
    label312:
    label317:
    label337:
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(309718);
      return Boolean.valueOf(bool);
      paramInt = 0;
      break;
      paramString = null;
      break label277;
      if ((ffy)paramString.ott == null)
      {
        paramInt = 0;
        break label288;
      }
      paramInt = 1;
      break label288;
    }
  }
  
  public final String getDisplayName(String paramString)
  {
    AppMethodBeat.i(309681);
    kotlin.g.b.s.u(paramString, "userName");
    paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).IE(paramString);
    kotlin.g.b.s.s(paramString, "service(IContactCommDisp…etDisplayRemark(userName)");
    AppMethodBeat.o(309681);
    return paramString;
  }
  
  public final String getUsername()
  {
    return luk;
  }
  
  public final boolean hge()
  {
    AppMethodBeat.i(309764);
    boolean bool = aj.hge();
    AppMethodBeat.o(309764);
    return bool;
  }
  
  public final String hgg()
  {
    AppMethodBeat.i(309650);
    String str = al.hgg();
    kotlin.g.b.s.s(str, "getSelfName()");
    AppMethodBeat.o(309650);
    return str;
  }
  
  public final String hhX()
  {
    return QAU;
  }
  
  public final int hhY()
  {
    AppMethodBeat.i(309658);
    if (q.Qki != null)
    {
      ffs localffs = q.Qki.aWV(luk);
      if (localffs != null)
      {
        int i = localffs.abFF;
        int j = localffs.abFG;
        if ((j == 4320) && ((i & 0x1000) > 0))
        {
          AppMethodBeat.o(309658);
          return 1;
        }
        if ((j == 72) && ((i & 0x1000) > 0))
        {
          AppMethodBeat.o(309658);
          return 2;
        }
        if ((j == 720) && ((i & 0x1000) > 0))
        {
          AppMethodBeat.o(309658);
          return 3;
        }
        AppMethodBeat.o(309658);
        return 0;
      }
    }
    AppMethodBeat.o(309658);
    return 0;
  }
  
  public final boolean isSelf()
  {
    AppMethodBeat.i(309653);
    boolean bool = al.hgg().equals(luk);
    AppMethodBeat.o(309653);
    return bool;
  }
  
  public final Object p(String paramString, kotlin.d.d<? super Bitmap> paramd)
  {
    AppMethodBeat.i(309748);
    paramString = com.tencent.mm.modelavatar.d.a(paramString, false, -1, null);
    AppMethodBeat.o(309748);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/model/withta/WithTaComposeOp$getSnsVideoTask$1", "Lcom/tencent/mm/plugin/sns/ui/video/SnsVideoDownloadTask$Provider;", "providePlayVideoDurationByResume", "", "provideUiReport", "Lcom/tencent/mm/plugin/sns/ui/OnlineVideoViewHelper$VideoRptStruct;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements c.b
  {
    public final aq.c hhZ()
    {
      AppMethodBeat.i(309632);
      aq.c localc = new aq.c();
      AppMethodBeat.o(309632);
      return localc;
    }
    
    public final long hia()
    {
      return 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.d.d
 * JD-Core Version:    0.7.0.1
 */