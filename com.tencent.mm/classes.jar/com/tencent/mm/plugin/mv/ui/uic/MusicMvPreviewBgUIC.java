package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.thumbplayer.view.MMMvVideoLayout;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.g;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewBgUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "firstTimePlay", "", "getFirstTimePlay", "()Z", "setFirstTimePlay", "(Z)V", "isOnActivityPause", "setOnActivityPause", "mediaInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "playerRecycler", "Lcom/tencent/mm/plugin/thumbplayer/view/MMCdnTPPlayerRecycler;", "getPlayerRecycler", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMCdnTPPlayerRecycler;", "setPlayerRecycler", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMCdnTPPlayerRecycler;)V", "thumbPath", "getThumbPath", "setThumbPath", "(Ljava/lang/String;)V", "thumbUrl", "getThumbUrl", "setThumbUrl", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getTrackData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setTrackData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout;", "getVideoLayout", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout;", "setVideoLayout", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout;)V", "checkSyncMvPositionWithMusic", "", "collectBgVideoInfo", "initBgCover", "listener", "Lcom/tencent/mm/plugin/mv/ui/uic/OnBackgroundBitmapReadyListener;", "initBgVideo", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "onVideoProgressUpdate", "timeMs", "", "videoDuration", "selectMedia", "index", "", "plugin-mv_release"})
public final class MusicMvPreviewBgUIC
  extends UIComponent
{
  public csp AqY;
  public MMMvVideoLayout AtX;
  private com.tencent.mm.plugin.thumbplayer.view.a Avu;
  private boolean Avv;
  private boolean Avw;
  public final String TAG;
  private final LinkedList<com.tencent.mm.plugin.thumbplayer.d.a> oNM;
  public String thumbPath;
  public String thumbUrl;
  
  public MusicMvPreviewBgUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(257325);
    this.TAG = "MicroMsg.Mv.MusicMvPreviewBgUIC";
    this.oNM = new LinkedList();
    this.Avu = new com.tencent.mm.plugin.thumbplayer.view.a((Context)getContext());
    this.Avv = true;
    AppMethodBeat.o(257325);
  }
  
  public final LinkedList<com.tencent.mm.plugin.thumbplayer.d.a> ewh()
  {
    for (;;)
    {
      int k;
      long l1;
      try
      {
        AppMethodBeat.i(257322);
        Object localObject1;
        if (this.oNM.isEmpty())
        {
          long l2 = Util.currentTicks();
          LinkedList localLinkedList = new LinkedList();
          csp localcsp = this.AqY;
          if (localcsp != null)
          {
            localObject1 = localcsp.MxE;
            if (localObject1 != null)
            {
              localObject1 = ((FinderObject)localObject1).objectDesc;
              if (localObject1 != null)
              {
                localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
                if (localObject1 != null)
                {
                  localObject1 = ((axw)localObject1).LId;
                  if (localObject1 != null)
                  {
                    Iterator localIterator = ((Iterable)localObject1).iterator();
                    j = 0;
                    if (localIterator.hasNext())
                    {
                      localObject1 = localIterator.next();
                      k = j + 1;
                      if (j < 0) {
                        kotlin.a.j.hxH();
                      }
                      axz localaxz = (axz)localObject1;
                      if (localaxz.refObjectId == 0L) {
                        break label1488;
                      }
                      Object localObject5 = (MusicMvPreviewBgUIC)this;
                      localObject1 = localcsp.LDi;
                      p.g(localObject1, "data.refObjectList");
                      localObject1 = ((Iterable)localObject1).iterator();
                      if (!((Iterator)localObject1).hasNext()) {
                        break label1483;
                      }
                      Object localObject6 = (FinderObject)((Iterator)localObject1).next();
                      if (((FinderObject)localObject6).id != localaxz.refObjectId) {
                        continue;
                      }
                      localObject1 = ((FinderObject)localObject6).objectDesc;
                      if (localObject1 != null)
                      {
                        localObject1 = ((FinderObjectDesc)localObject1).media;
                        if (localObject1 != null)
                        {
                          FinderMedia localFinderMedia = (FinderMedia)kotlin.a.j.kt((List)localObject1);
                          if (localFinderMedia != null)
                          {
                            Object localObject7 = "video_" + ((FinderObject)localObject6).id;
                            localObject1 = com.tencent.mm.plugin.mv.ui.a.ArA;
                            String str = com.tencent.mm.plugin.mv.ui.a.aIp((String)localObject7);
                            localObject4 = localFinderMedia.url;
                            localObject1 = localObject4;
                            if (localObject4 == null) {
                              localObject1 = "";
                            }
                            localObject7 = new com.tencent.mm.plugin.thumbplayer.d.a((String)localObject7, str, (String)localObject1, kotlin.h.a.cR(localFinderMedia.width), kotlin.h.a.cR(localFinderMedia.height));
                            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).Ghr = Integer.valueOf(2);
                            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).dVY = "xV2";
                            localObject4 = localFinderMedia.url_token;
                            localObject1 = localObject4;
                            if (localObject4 == null) {
                              localObject1 = "";
                            }
                            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).aTt((String)localObject1);
                            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).decodeKey = localFinderMedia.decodeKey;
                            localObject4 = localFinderMedia.thumbUrl;
                            localObject1 = localObject4;
                            if (localObject4 == null) {
                              localObject1 = "";
                            }
                            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).GR((String)localObject1);
                            localObject4 = localFinderMedia.thumb_url_token;
                            localObject1 = localObject4;
                            if (localObject4 == null) {
                              localObject1 = "";
                            }
                            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).aTu((String)localObject1);
                            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).Ghv = localaxz.LIl;
                            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).Ghu = localaxz.Ghu;
                            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).Ghw = localaxz.Ghw;
                            localObject1 = ((FinderObject)localObject6).objectDesc;
                            if (localObject1 == null) {
                              break label1500;
                            }
                            localObject1 = ((FinderObjectDesc)localObject1).media;
                            if (localObject1 == null) {
                              break label1500;
                            }
                            localObject1 = (FinderMedia)kotlin.a.j.ks((List)localObject1);
                            if (localObject1 == null) {
                              break label1500;
                            }
                            l1 = ((FinderMedia)localObject1).videoDuration;
                            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).pLQ = (l1 * 1000L);
                            localObject1 = MMThumbPlayerTextureView.GiC;
                            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).scaleType = MMThumbPlayerTextureView.fxj();
                            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).dLQ = false;
                            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).Ghx = localObject6;
                            localLinkedList.add(localObject7);
                            Log.i(((MusicMvPreviewBgUIC)localObject5).TAG, "add mediaTrack network id:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).mediaId + " path:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).path + " width:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).width + " height:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).height + " timeOffsetInClipMs:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).Ghw + " timeOffsetInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).Ghu + " timeLengthInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject7).Ghv);
                            localObject1 = x.SXb;
                            i = 1;
                            localObject1 = x.SXb;
                            if (i != 0) {
                              break label1529;
                            }
                            Log.i(this.TAG, "not find ref obj Id:" + localaxz.refObjectId);
                            if (localaxz == null) {
                              break label1523;
                            }
                            localObject4 = localaxz.LIm;
                            if (localObject4 == null) {
                              break label1523;
                            }
                            p.g(localObject4, "it");
                            if (((CharSequence)localObject4).length() <= 0) {
                              break label1506;
                            }
                            i = 1;
                            break label1493;
                            label786:
                            if (localObject4 == null) {
                              break label1523;
                            }
                            localObject1 = this.AqY;
                            if (localObject1 == null) {
                              break label1517;
                            }
                            localObject1 = ((csp)localObject1).LDi;
                            if (localObject1 == null) {
                              break label1517;
                            }
                            localObject6 = ((Iterable)localObject1).iterator();
                            localObject1 = null;
                            if (!((Iterator)localObject6).hasNext()) {
                              continue;
                            }
                            localObject7 = (FinderObject)((Iterator)localObject6).next();
                            if (!p.j(localObject4, ((FinderObject)localObject7).objectNonceId)) {
                              continue;
                            }
                            localObject5 = ((FinderObject)localObject7).objectDesc;
                            if (localObject5 == null) {
                              continue;
                            }
                            localObject5 = ((FinderObjectDesc)localObject5).media;
                            if (localObject5 == null) {
                              continue;
                            }
                            localFinderMedia = (FinderMedia)kotlin.a.j.kt((List)localObject5);
                            if (localFinderMedia == null) {
                              continue;
                            }
                            str = "video_" + ((FinderObject)localObject7).objectNonceId;
                            localObject5 = localFinderMedia.url;
                            localObject1 = localObject5;
                            if (localObject5 == null) {
                              localObject1 = "";
                            }
                            localObject1 = new com.tencent.mm.plugin.thumbplayer.d.a(str, (String)localObject1, "", kotlin.h.a.cR(localFinderMedia.width), kotlin.h.a.cR(localFinderMedia.height));
                            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).pLQ = (localFinderMedia.videoDuration * 1000L);
                            localObject5 = x.SXb;
                            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).Ghx = localObject7;
                            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).dLQ = true;
                            localObject5 = x.SXb;
                            continue;
                          }
                        }
                      }
                      Log.i(((MusicMvPreviewBgUIC)localObject5).TAG, "not find ref object media " + j + ' ' + localaxz.refObjectId + ' ' + localaxz.LIm);
                      localObject1 = x.SXb;
                      i = 0;
                      continue;
                      localObject4 = x.SXb;
                      localObject4 = localObject1;
                      if (localObject1 == null)
                      {
                        localObject1 = com.tencent.mm.plugin.mv.a.a.Apj;
                        localObject1 = com.tencent.mm.plugin.mv.a.a.evw();
                        localObject4 = com.tencent.mm.plugin.mv.a.a.Apj;
                        localObject1 = (com.tencent.mm.plugin.mv.a.a)((List)localObject1).get(j % com.tencent.mm.plugin.mv.a.a.evw().size());
                        localObject4 = new com.tencent.mm.plugin.thumbplayer.d.a("video_" + ((com.tencent.mm.plugin.mv.a.a)localObject1).name, ((com.tencent.mm.plugin.mv.a.a)localObject1).getFilePath(), "", ((com.tencent.mm.plugin.mv.a.a)localObject1).width, ((com.tencent.mm.plugin.mv.a.a)localObject1).height);
                        ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).pLQ = ((com.tencent.mm.plugin.mv.a.a)localObject1).durationMs;
                        ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).loop = true;
                        ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).Ght = true;
                        localObject1 = x.SXb;
                        ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).dLQ = true;
                      }
                      if (localObject4 == null) {
                        break label1529;
                      }
                      ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).Ghv = localaxz.LIl;
                      ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).Ghu = localaxz.Ghu;
                      ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).Ghw = localaxz.Ghw;
                      ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).dLQ = true;
                      localObject1 = MMThumbPlayerTextureView.GiC;
                      ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).scaleType = MMThumbPlayerTextureView.fxj();
                      ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).dYT = SightVideoJNI.getMp4RotateVFS(((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).path);
                      localLinkedList.add(localObject4);
                      Log.i(this.TAG, "add mediaTrack local id:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).mediaId + " path:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).path + " width:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).width + " height:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).height + " timeOffsetInClipMs:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).Ghw + " timeOffsetInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).Ghu + " timeLengthInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject4).Ghv);
                      localObject1 = x.SXb;
                      j = k;
                      continue;
                    }
                    localObject1 = x.SXb;
                  }
                }
              }
            }
          }
          Log.i(this.TAG, "collectBgVideoInfo cost:" + Util.ticksToNow(l2));
          this.oNM.addAll((Collection)localLinkedList);
        }
        else
        {
          localObject1 = this.oNM;
          AppMethodBeat.o(257322);
          return localObject1;
        }
      }
      finally {}
      label1483:
      int i = 0;
      continue;
      label1488:
      i = 0;
      continue;
      for (;;)
      {
        label1493:
        if (i == 0) {
          break label1511;
        }
        break label786;
        label1500:
        l1 = 0L;
        break;
        label1506:
        i = 0;
      }
      label1511:
      Object localObject4 = null;
      continue;
      label1517:
      Object localObject3 = null;
      continue;
      label1523:
      localObject3 = null;
      continue;
      label1529:
      int j = k;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(257319);
    if (getIntent().getBooleanExtra("key_seek_to_start", false))
    {
      paramBundle = k.euj();
      p.g(paramBundle, "MusicPlayerManager.Instance()");
      paramBundle.etW().tG(0);
    }
    AppMethodBeat.o(257319);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(257321);
    Object localObject1 = this.AtX;
    if (localObject1 != null) {
      ((MMMvVideoLayout)localObject1).recycle();
    }
    localObject1 = this.Avu;
    Iterator localIterator = ((Iterable)((com.tencent.mm.plugin.thumbplayer.view.a)localObject1).Gia).iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.thumbplayer.e.b)localIterator.next();
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).stopAsync();
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).recycle();
    }
    localIterator = ((Map)((com.tencent.mm.plugin.thumbplayer.view.a)localObject1).Gib).entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (Map.Entry)localIterator.next();
      ((com.tencent.mm.plugin.thumbplayer.e.b)((Map.Entry)localObject2).getKey()).stopAsync();
      ((com.tencent.mm.plugin.thumbplayer.e.b)((Map.Entry)localObject2).getKey()).recycle();
    }
    ((com.tencent.mm.plugin.thumbplayer.view.a)localObject1).Gia.clear();
    ((com.tencent.mm.plugin.thumbplayer.view.a)localObject1).Gib.clear();
    AppMethodBeat.o(257321);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(257320);
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      if (paramIntent.getBooleanExtra("key_seek_to_start", false))
      {
        paramIntent = k.euj();
        p.g(paramIntent, "MusicPlayerManager.Instance()");
        paramIntent.etW().tG(0);
      }
      AppMethodBeat.o(257320);
      return;
    }
    AppMethodBeat.o(257320);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(257324);
    this.Avw = true;
    MMMvVideoLayout localMMMvVideoLayout = this.AtX;
    if (localMMMvVideoLayout != null)
    {
      localMMMvVideoLayout.pause();
      AppMethodBeat.o(257324);
      return;
    }
    AppMethodBeat.o(257324);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(257323);
    if (this.Avw)
    {
      MMMvVideoLayout localMMMvVideoLayout = this.AtX;
      if (localMMMvVideoLayout != null) {
        localMMMvVideoLayout.resume();
      }
      this.Avw = false;
    }
    AppMethodBeat.o(257323);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewBgUIC$initBgCover$imageLoaderListener$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"})
  public static final class a
    implements h
  {
    public a(ImageView paramImageView, a parama) {}
    
    public final Bitmap a(String paramString, View paramView, com.tencent.mm.av.a.d.b paramb)
    {
      AppMethodBeat.i(257313);
      p.h(paramString, "url");
      p.h(paramView, "view");
      p.h(paramb, "imageData");
      AppMethodBeat.o(257313);
      return null;
    }
    
    public final void b(String paramString, View paramView)
    {
      AppMethodBeat.i(257312);
      p.h(paramString, "url");
      p.h(paramView, "view");
      AppMethodBeat.o(257312);
    }
    
    public final void b(String paramString, View paramView, com.tencent.mm.av.a.d.b paramb)
    {
      boolean bool = false;
      AppMethodBeat.i(257314);
      p.h(paramString, "url");
      p.h(paramView, "view");
      p.h(paramb, "imageData");
      paramView = this.Avx.TAG;
      if (paramb.bitmap != null) {
        bool = true;
      }
      Log.i(paramView, "onImageLoadFinish %s %b", new Object[] { paramString, Boolean.valueOf(bool) });
      if (paramb.bitmap != null)
      {
        paramString = paramb.bitmap;
        p.g(paramString, "imageData.bitmap");
        if (!paramString.isRecycled()) {
          com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, paramb.bitmap));
        }
      }
      AppMethodBeat.o(257314);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(MusicMvPreviewBgUIC.a parama, Bitmap paramBitmap)
      {
        super();
      }
    }
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewBgUIC$initBgVideo$1", f="MusicMvPreviewBgUIC.kt", hxM={210}, m="invokeSuspend")
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  public static final class b
    extends kotlin.d.b.a.j
    implements m<ai, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ai p$;
    
    public b(MusicMvPreviewBgUIC paramMusicMvPreviewBgUIC, com.tencent.mm.plugin.thumbplayer.view.d paramd, kotlin.d.d paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(258929);
      p.h(paramd, "completion");
      paramd = new b(this.Avx, this.Uro, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(258929);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(258930);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(258930);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(258928);
      Object localObject2 = kotlin.d.a.a.SXO;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(258928);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        localObject1 = (kotlin.d.f)ba.hMW();
        localObject3 = (m)new MusicMvPreviewBgUIC.b.c(this, null);
        this.L$0 = paramObject;
        this.label = 1;
        localObject1 = g.a((kotlin.d.f)localObject1, (m)localObject3, this);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(258928);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      Object localObject1 = (LinkedList)paramObject;
      Log.i(this.Avx.TAG, "init mediaInfoList:" + ((LinkedList)localObject1).size());
      if (((LinkedList)localObject1).isEmpty())
      {
        paramObject = x.SXb;
        AppMethodBeat.o(258928);
        return paramObject;
      }
      localObject2 = (FrameLayout)this.Avx.getActivity().findViewById(2131297175);
      paramObject = new MMMvVideoLayout((Context)this.Avx.getActivity());
      paramObject.setId(2131305117);
      paramObject.setMediaChangeListener(this.Uro);
      paramObject.setMvMusicProxy((com.tencent.mm.plugin.thumbplayer.view.c)new MusicMvPreviewBgUIC.b.a());
      Object localObject3 = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout)localObject2).removeAllViews();
      ((FrameLayout)localObject2).addView((View)paramObject, (ViewGroup.LayoutParams)localObject3);
      paramObject.fxd();
      MMMvVideoLayout.a(paramObject, (List)localObject1);
      localObject1 = com.tencent.mm.util.c.QYz;
      paramObject.setEnableEffect(com.tencent.mm.util.c.hdl());
      paramObject.start();
      MusicMvPreviewBgUIC.a(this.Avx);
      paramObject.setOnProgressUpdate((m)new MusicMvPreviewBgUIC.b.b(this.Avx));
      paramObject.setKeepScreenOn(true);
      this.Avx.AtX = paramObject;
      paramObject = x.SXb;
      AppMethodBeat.o(258928);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewBgUIC
 * JD-Core Version:    0.7.0.1
 */