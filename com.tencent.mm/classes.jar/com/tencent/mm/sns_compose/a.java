package com.tencent.mm.sns_compose;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.downloader.h;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sns_compose.a.f;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lcom.tencent.mm.sns_compose.a.e<Lcom.tencent.mm.sns_compose.a.d<Lcom.tencent.mm.sns_compose.a.f;>;>;>;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/PlatformOp;", "Lcom/tencent/mm/sns_compose/api/IWithTaComposeOp;", "()V", "TAG", "", "implProxy", "entranceEnable", "", "getAvatarBitmap", "Landroid/graphics/Bitmap;", "userName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDisplayName", "getDisplayRemark", "getDisplayTime", "context", "Landroid/content/Context;", "createTime", "", "getFinderImage", "thumbUrl", "getImageFromUrl", "url", "getImagePath", "snsId", "mediaId", "requestThumb", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPage", "Lcom/tencent/mm/sns_compose/api/PageLoadResult;", "Lcom/tencent/mm/sns_compose/api/PageDataWrapper;", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "feedId", "", "pageSize", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSelfName", "getSnsMediaBitmap", "media", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "thumb", "(Lcom/tencent/mm/protocal/protobuf/MediaObj;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSnsVideoPath", "localId", "getSnsVideoTask", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoDownloadTask;", "getUsername", "getWithFriends", "imagePreview", "", "isSelf", "data", "Lcom/tencent/mm/sns_compose/api/GalleryData;", "impl", "isTogetherVideoEnabled", "ownerSetting", "setImpl", "showAlertListDialog", "scope", "Lkotlinx/coroutines/CoroutineScope;", "seq", "action", "tipsId", "cb", "Lkotlin/Function1;", "showDetailUI", "snsWithTaOpRequest", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startProfile", "username", "scene", "source", "unPackSnsId", "sns-compose_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.sns_compose.a.c
{
  public static final int Ue;
  public static final a acyR;
  private static com.tencent.mm.sns_compose.a.c acyS;
  
  static
  {
    AppMethodBeat.i(235485);
    acyR = new a();
    Ue = 8;
    AppMethodBeat.o(235485);
  }
  
  public static void a(com.tencent.mm.sns_compose.a.c paramc)
  {
    AppMethodBeat.i(235482);
    s.u(paramc, "impl");
    acyS = paramc;
    AppMethodBeat.o(235482);
  }
  
  public final h a(int paramInt1, dmz paramdmz, int paramInt2)
  {
    AppMethodBeat.i(235583);
    s.u(paramdmz, "media");
    com.tencent.mm.sns_compose.a.c localc = acyS;
    if (localc == null) {}
    for (paramdmz = null;; paramdmz = localc.a(paramInt1, paramdmz, paramInt2))
    {
      s.checkNotNull(paramdmz);
      AppMethodBeat.o(235583);
      return paramdmz;
    }
  }
  
  public final Object a(long paramLong, int paramInt, kotlin.d.d<? super com.tencent.mm.sns_compose.a.e<com.tencent.mm.sns_compose.a.d<f>>> paramd)
  {
    AppMethodBeat.i(235557);
    if ((paramd instanceof a))
    {
      localObject = (a)paramd;
      if ((((a)localObject).label & 0x80000000) != 0) {
        ((a)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super com.tencent.mm.sns_compose.a.e<com.tencent.mm.sns_compose.a.d<f>>>)localObject;; paramd = new a(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(235557);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject);
    Log.i("PlatformOp", "getPage() called with: feedId = " + paramLong + ", pageSize = " + paramInt);
    Object localObject = acyS;
    if (localObject == null) {}
    for (paramd = null; paramd == null; paramd = (com.tencent.mm.sns_compose.a.e)paramd)
    {
      paramd = (com.tencent.mm.sns_compose.a.e)new com.tencent.mm.sns_compose.a.e.a((byte)0);
      AppMethodBeat.o(235557);
      return paramd;
      paramd.label = 1;
      localObject = ((com.tencent.mm.sns_compose.a.c)localObject).a(paramLong, paramInt, paramd);
      paramd = (kotlin.d.d<? super com.tencent.mm.sns_compose.a.e<com.tencent.mm.sns_compose.a.d<f>>>)localObject;
      if (localObject == locala)
      {
        AppMethodBeat.o(235557);
        return locala;
        ResultKt.throwOnFailure(localObject);
        paramd = (kotlin.d.d<? super com.tencent.mm.sns_compose.a.e<com.tencent.mm.sns_compose.a.d<f>>>)localObject;
      }
    }
    AppMethodBeat.o(235557);
    return paramd;
  }
  
  public final Object a(String paramString1, String paramString2, boolean paramBoolean, kotlin.d.d<? super String> paramd)
  {
    AppMethodBeat.i(235573);
    com.tencent.mm.sns_compose.a.c localc = acyS;
    if (localc == null)
    {
      AppMethodBeat.o(235573);
      return null;
    }
    paramString1 = localc.a(paramString1, paramString2, paramBoolean, paramd);
    AppMethodBeat.o(235573);
    return paramString1;
  }
  
  public final String a(int paramInt, dmz paramdmz)
  {
    AppMethodBeat.i(235577);
    s.u(paramdmz, "media");
    com.tencent.mm.sns_compose.a.c localc = acyS;
    if (localc == null)
    {
      AppMethodBeat.o(235577);
      return null;
    }
    paramdmz = localc.a(paramInt, paramdmz);
    AppMethodBeat.o(235577);
    return paramdmz;
  }
  
  public final void a(Context paramContext, int paramInt, boolean paramBoolean, com.tencent.mm.sns_compose.a.a parama)
  {
    AppMethodBeat.i(235531);
    s.u(paramContext, "context");
    s.u(parama, "data");
    Log.i("PlatformOp", "imagePreview() called with: context = " + paramContext + ", localId = " + paramInt);
    com.tencent.mm.sns_compose.a.c localc = acyS;
    if (localc != null) {
      localc.a(paramContext, paramInt, paramBoolean, parama);
    }
    com.tencent.mm.plugin.comm.b.e.xfd.a(com.tencent.mm.plugin.comm.b.b.xeN.name(), "withFriendGalleryCount", Integer.valueOf(paramInt), com.tencent.mm.plugin.comm.b.c.xeW);
    AppMethodBeat.o(235531);
  }
  
  public final void a(Context paramContext, aq paramaq, String paramString, int paramInt1, int paramInt2, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(235587);
    s.u(paramContext, "context");
    s.u(paramaq, "scope");
    s.u(paramString, "seq");
    s.u(paramb, "cb");
    com.tencent.mm.sns_compose.a.c localc = acyS;
    if (localc != null) {
      localc.a(paramContext, paramaq, paramString, paramInt1, paramInt2, paramb);
    }
    AppMethodBeat.o(235587);
  }
  
  public final String aSV()
  {
    AppMethodBeat.i(235500);
    Object localObject = acyS;
    if (localObject == null)
    {
      AppMethodBeat.o(235500);
      return "";
    }
    localObject = ((com.tencent.mm.sns_compose.a.c)localObject).aSV();
    if (localObject == null)
    {
      AppMethodBeat.o(235500);
      return "";
    }
    AppMethodBeat.o(235500);
    return localObject;
  }
  
  public final String aX(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(235544);
    s.u(paramContext, "context");
    Log.i("PlatformOp", "getDisplayTime() called with: context = " + paramContext + ", createTime = " + paramInt);
    com.tencent.mm.sns_compose.a.c localc = acyS;
    if (localc == null)
    {
      AppMethodBeat.o(235544);
      return "";
    }
    paramContext = localc.aX(paramContext, paramInt);
    if (paramContext == null)
    {
      AppMethodBeat.o(235544);
      return "";
    }
    AppMethodBeat.o(235544);
    return paramContext;
  }
  
  public final long aXe(String paramString)
  {
    AppMethodBeat.i(235522);
    s.u(paramString, "snsId");
    com.tencent.mm.sns_compose.a.c localc = acyS;
    if (localc == null)
    {
      AppMethodBeat.o(235522);
      return 0L;
    }
    long l = localc.aXe(paramString);
    AppMethodBeat.o(235522);
    return l;
  }
  
  public final Object b(dmz paramdmz, boolean paramBoolean, kotlin.d.d<? super Bitmap> paramd)
  {
    AppMethodBeat.i(235568);
    Log.i("PlatformOp", "getSnsMediaBitmap() called with: mediaId = " + paramdmz.Id + ", thumb = " + paramBoolean);
    com.tencent.mm.sns_compose.a.c localc = acyS;
    if (localc == null)
    {
      AppMethodBeat.o(235568);
      return null;
    }
    paramdmz = localc.b(paramdmz, paramBoolean, paramd);
    AppMethodBeat.o(235568);
    return paramdmz;
  }
  
  public final void b(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235548);
    s.u(paramContext, "context");
    s.u(paramString, "username");
    com.tencent.mm.sns_compose.a.c localc = acyS;
    if (localc != null) {
      localc.b(paramContext, paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(235548);
  }
  
  public final void bQ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(235534);
    s.u(paramContext, "context");
    s.u(paramString, "snsId");
    Log.i("PlatformOp", "showDetailUI() called with: context = " + paramContext + ", snsId = " + paramString);
    com.tencent.mm.sns_compose.a.c localc = acyS;
    if (localc != null) {
      localc.bQ(paramContext, paramString);
    }
    com.tencent.mm.plugin.comm.b.e.xfd.a(com.tencent.mm.plugin.comm.b.b.xeN.name(), "withFriendDetailCount", paramString, com.tencent.mm.plugin.comm.b.c.xeW);
    AppMethodBeat.o(235534);
  }
  
  public final String getDisplayName(String paramString)
  {
    AppMethodBeat.i(235540);
    s.u(paramString, "userName");
    Log.i("PlatformOp", s.X("getDisplayName() called with: userName = ", paramString));
    com.tencent.mm.sns_compose.a.c localc = acyS;
    if (localc == null)
    {
      AppMethodBeat.o(235540);
      return "";
    }
    paramString = localc.getDisplayName(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(235540);
      return "";
    }
    AppMethodBeat.o(235540);
    return paramString;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(235510);
    Object localObject = acyS;
    if (localObject == null)
    {
      AppMethodBeat.o(235510);
      return "";
    }
    localObject = ((com.tencent.mm.sns_compose.a.c)localObject).getUsername();
    if (localObject == null)
    {
      AppMethodBeat.o(235510);
      return "";
    }
    AppMethodBeat.o(235510);
    return localObject;
  }
  
  public final boolean hge()
  {
    AppMethodBeat.i(235591);
    com.tencent.mm.sns_compose.a.c localc = acyS;
    if (localc == null)
    {
      AppMethodBeat.o(235591);
      return false;
    }
    boolean bool = localc.hge();
    AppMethodBeat.o(235591);
    return bool;
  }
  
  public final String hgg()
  {
    AppMethodBeat.i(235505);
    Object localObject = acyS;
    if (localObject == null)
    {
      AppMethodBeat.o(235505);
      return "";
    }
    localObject = ((com.tencent.mm.sns_compose.a.c)localObject).hgg();
    if (localObject == null)
    {
      AppMethodBeat.o(235505);
      return "";
    }
    AppMethodBeat.o(235505);
    return localObject;
  }
  
  public final String hhX()
  {
    AppMethodBeat.i(235493);
    Object localObject = acyS;
    if (localObject == null)
    {
      AppMethodBeat.o(235493);
      return "";
    }
    localObject = ((com.tencent.mm.sns_compose.a.c)localObject).hhX();
    if (localObject == null)
    {
      AppMethodBeat.o(235493);
      return "";
    }
    AppMethodBeat.o(235493);
    return localObject;
  }
  
  public final int hhY()
  {
    AppMethodBeat.i(235516);
    com.tencent.mm.sns_compose.a.c localc = acyS;
    if (localc == null)
    {
      AppMethodBeat.o(235516);
      return 0;
    }
    int i = localc.hhY();
    AppMethodBeat.o(235516);
    return i;
  }
  
  public final boolean isSelf()
  {
    AppMethodBeat.i(235512);
    com.tencent.mm.sns_compose.a.c localc = acyS;
    if (localc == null)
    {
      AppMethodBeat.o(235512);
      return false;
    }
    boolean bool = localc.isSelf();
    AppMethodBeat.o(235512);
    return bool;
  }
  
  public final Object p(String paramString, kotlin.d.d<? super Bitmap> paramd)
  {
    AppMethodBeat.i(235571);
    Log.i("PlatformOp", s.X("getAvatarBitmap() called with: userName = ", paramString));
    com.tencent.mm.sns_compose.a.c localc = acyS;
    if (localc == null)
    {
      AppMethodBeat.o(235571);
      return null;
    }
    paramString = localc.p(paramString, paramd);
    AppMethodBeat.o(235571);
    return paramString;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    int label;
    
    a(a parama, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(235466);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.acyT.a(0L, 0, (kotlin.d.d)this);
      AppMethodBeat.o(235466);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sns_compose.a
 * JD-Core Version:    0.7.0.1
 */