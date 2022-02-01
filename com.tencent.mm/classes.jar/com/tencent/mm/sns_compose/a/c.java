package com.tencent.mm.sns_compose.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.plugin.thumbplayer.downloader.h;
import com.tencent.mm.protocal.protobuf.dmz;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/api/IWithTaComposeOp;", "", "entranceEnable", "", "getAvatarBitmap", "Landroid/graphics/Bitmap;", "userName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDisplayName", "getDisplayRemark", "getDisplayTime", "context", "Landroid/content/Context;", "createTime", "", "getImageFromUrl", "url", "getImagePath", "snsId", "mediaId", "requestThumb", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPage", "Lcom/tencent/mm/sns_compose/api/PageLoadResult;", "Lcom/tencent/mm/sns_compose/api/PageDataWrapper;", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "feedId", "", "pageSize", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSelfName", "getSnsMediaBitmap", "media", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "thumb", "(Lcom/tencent/mm/protocal/protobuf/MediaObj;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSnsVideoPath", "localId", "getSnsVideoTask", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoDownloadTask;", "getUsername", "getWithFriends", "imagePreview", "", "isSelf", "data", "Lcom/tencent/mm/sns_compose/api/GalleryData;", "isTogetherVideoEnabled", "ownerSetting", "showAlertListDialog", "scope", "Lkotlinx/coroutines/CoroutineScope;", "seq", "action", "tipsId", "cb", "Lkotlin/Function1;", "showDetailUI", "snsWithTaOpRequest", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startProfile", "username", "scene", "source", "unPackSnsId", "sns-compose.api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c
{
  public abstract h a(int paramInt1, dmz paramdmz, int paramInt2);
  
  public abstract Object a(long paramLong, int paramInt, kotlin.d.d<? super e<d<f>>> paramd);
  
  public abstract Object a(String paramString1, String paramString2, boolean paramBoolean, kotlin.d.d<? super String> paramd);
  
  public abstract String a(int paramInt, dmz paramdmz);
  
  public abstract void a(Context paramContext, int paramInt, boolean paramBoolean, a parama);
  
  public abstract void a(Context paramContext, aq paramaq, String paramString, int paramInt1, int paramInt2, b<? super Boolean, ah> paramb);
  
  public abstract String aSV();
  
  public abstract String aX(Context paramContext, int paramInt);
  
  public abstract long aXe(String paramString);
  
  public abstract Object b(dmz paramdmz, boolean paramBoolean, kotlin.d.d<? super Bitmap> paramd);
  
  public abstract void b(Context paramContext, String paramString, int paramInt1, int paramInt2);
  
  public abstract void bQ(Context paramContext, String paramString);
  
  public abstract String getDisplayName(String paramString);
  
  public abstract String getUsername();
  
  public abstract boolean hge();
  
  public abstract String hgg();
  
  public abstract String hhX();
  
  public abstract int hhY();
  
  public abstract boolean isSelf();
  
  public abstract Object p(String paramString, kotlin.d.d<? super Bitmap> paramd);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sns_compose.a.c
 * JD-Core Version:    0.7.0.1
 */