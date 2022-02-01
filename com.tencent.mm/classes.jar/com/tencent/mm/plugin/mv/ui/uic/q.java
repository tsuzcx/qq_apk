package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.a.c.h;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.model.b.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.thumbplayer.e.e;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView;
import com.tencent.mm.plugin.thumbplayer.view.MultiMediaEffectVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;
import kotlinx.coroutines.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewBgUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "firstTimePlay", "", "getFirstTimePlay", "()Z", "setFirstTimePlay", "(Z)V", "isOnActivityPause", "setOnActivityPause", "mediaInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaSEInfo;", "progressCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "timeMs", "total", "", "getProgressCallback", "()Lkotlin/jvm/functions/Function2;", "setProgressCallback", "(Lkotlin/jvm/functions/Function2;)V", "rawProgressCallback", "Lkotlin/Function1;", "getRawProgressCallback", "()Lkotlin/jvm/functions/Function1;", "setRawProgressCallback", "(Lkotlin/jvm/functions/Function1;)V", "thumbPath", "getThumbPath", "setThumbPath", "(Ljava/lang/String;)V", "thumbUrl", "getThumbUrl", "setThumbUrl", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getTrackData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setTrackData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MultiMediaEffectVideoLayout;", "getVideoLayout", "()Lcom/tencent/mm/plugin/thumbplayer/view/MultiMediaEffectVideoLayout;", "setVideoLayout", "(Lcom/tencent/mm/plugin/thumbplayer/view/MultiMediaEffectVideoLayout;)V", "applyTransition", "index", "", "pagInfo", "Lcom/tencent/mm/plugin/mv/model/DefaultPagInfo;", "checkSyncMvPositionWithMusic", "collectBgVideoInfo", "initBgCover", "listener", "Lcom/tencent/mm/plugin/mv/ui/uic/OnBackgroundBitmapReadyListener;", "initBgVideo", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "move", "moveList", "", "Lkotlin/Pair;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "onStart", "onStop", "refreshOffsets", "fillingDuration", "seekToTime", "selectMedia", "updateMediaInfo", "startTime", "endTime", "plugin-mv_release"})
public final class q
  extends UIComponent
{
  public dbo Geg;
  public MultiMediaEffectVideoLayout GgY;
  public m<? super Long, ? super Long, kotlin.x> GlW;
  public kotlin.g.a.b<? super Long, kotlin.x> GlX;
  private boolean GlY;
  private boolean GlZ;
  final String TAG;
  public final LinkedList<e> rPI;
  public String thumbPath;
  public String thumbUrl;
  
  public q(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(234542);
    this.TAG = "MicroMsg.Mv.MusicMvPreviewBgUIC";
    this.rPI = new LinkedList();
    this.GlY = true;
    AppMethodBeat.o(234542);
  }
  
  public final void OL(long paramLong)
  {
    AppMethodBeat.i(234541);
    Object localObject3 = (Iterable)kotlin.k.i.ou(0, this.rPI.size() - 1);
    Object localObject1 = this.rPI;
    Object localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add((e)((LinkedList)localObject1).get(((ab)localObject3).zD()));
    }
    localObject1 = ((Iterable)localObject2).iterator();
    for (long l = 0L; ((Iterator)localObject1).hasNext(); l = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject2).MSF + l)
    {
      localObject2 = (e)((Iterator)localObject1).next();
      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject2).MSE = l;
    }
    localObject1 = (e)this.rPI.getLast();
    ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSE = l;
    ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSF = paramLong;
    AppMethodBeat.o(234541);
  }
  
  public final void OP(long paramLong)
  {
    AppMethodBeat.i(234526);
    Log.i(this.TAG, "seekToTime: ".concat(String.valueOf(paramLong)));
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.GgY;
    if (localMultiMediaEffectVideoLayout != null)
    {
      localMultiMediaEffectVideoLayout.seekTo(paramLong);
      AppMethodBeat.o(234526);
      return;
    }
    AppMethodBeat.o(234526);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.mv.model.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(234534);
    Object localObject1 = this.rPI.get(paramInt);
    p.j(localObject1, "mediaInfoList[index]");
    e locale = (e)localObject1;
    if (parama != null)
    {
      localObject1 = parama.GaM;
      locale.MSK = ((String)localObject1);
      if (parama == null) {
        break label104;
      }
    }
    label104:
    for (localObject1 = parama.id;; localObject1 = null)
    {
      locale.MSJ = ((String)localObject1);
      MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.GgY;
      if (localMultiMediaEffectVideoLayout == null) {
        break label109;
      }
      localObject1 = localObject2;
      if (parama != null) {
        localObject1 = parama.GaM;
      }
      localMultiMediaEffectVideoLayout.a(locale, (String)localObject1);
      AppMethodBeat.o(234534);
      return;
      localObject1 = null;
      break;
    }
    label109:
    AppMethodBeat.o(234534);
  }
  
  public final void a(final x paramx)
  {
    AppMethodBeat.i(234521);
    final ImageView localImageView = (ImageView)getActivity().findViewById(b.e.FWD);
    paramx = new a(this, localImageView, paramx);
    String str = this.thumbPath;
    if (str != null)
    {
      Log.i(this.TAG, "initBgCover thumbPath:" + this.thumbPath);
      localObject1 = new c.a().gs(true).bmH().bmL();
      p.j(localObject1, "ImageLoaderOptions.Build…ns.LoadFrom.FILE).build()");
      com.tencent.mm.ay.q.bml().a(str, localImageView, (com.tencent.mm.ay.a.a.c)localObject1, (h)paramx);
      AppMethodBeat.o(234521);
      return;
    }
    Object localObject1 = (q)this;
    str = ((q)localObject1).thumbUrl;
    if (str != null)
    {
      Object localObject2 = com.tencent.mm.plugin.mv.ui.a.Gfi;
      localObject2 = com.tencent.mm.plugin.mv.ui.a.aSH(str);
      Log.i(((q)localObject1).TAG, "initBgCover url:" + str + " fullPath:" + (String)localObject2);
      localObject1 = new c.a();
      ((c.a)localObject1).Wq((String)localObject2);
      ((c.a)localObject1).bmF();
      ((c.a)localObject1).gs(true);
      com.tencent.mm.ay.q.bml().a(str, localImageView, ((c.a)localObject1).bmL(), (h)paramx);
      AppMethodBeat.o(234521);
      return;
    }
    AppMethodBeat.o(234521);
  }
  
  public final void a(final com.tencent.mm.plugin.thumbplayer.view.d paramd)
  {
    AppMethodBeat.i(234524);
    p.k(paramd, "listener");
    final FrameLayout localFrameLayout = (FrameLayout)getActivity().findViewById(b.e.FWC);
    g.b((ak)br.abxo, (f)bc.iRr(), (m)new b(this, localFrameLayout, paramd, null), 2);
    AppMethodBeat.o(234524);
  }
  
  public final void b(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(234537);
    Log.i(this.TAG, "updateMediaInfo: index=" + paramInt + ", startTime=" + paramLong1 + ", endTime=" + paramLong2 + ", fillingDuration=" + paramLong3);
    Object localObject1 = this.rPI.get(paramInt);
    p.j(localObject1, "mediaInfoList[index]");
    localObject1 = (e)localObject1;
    ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSF = (paramLong2 - paramLong1);
    ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSG = paramLong1;
    OL(paramLong3);
    localObject1 = this.GgY;
    if (localObject1 != null)
    {
      Object localObject2 = (Iterable)this.rPI;
      Collection localCollection = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label203:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (((e)localObject3).MSF > 0L) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label203;
          }
          localCollection.add(localObject3);
          break;
        }
      }
      ((MultiMediaEffectVideoLayout)localObject1).setMediaList((List)localCollection);
    }
    localObject1 = this.GgY;
    if (localObject1 != null)
    {
      ((MultiMediaEffectVideoLayout)localObject1).start();
      AppMethodBeat.o(234537);
      return;
    }
    AppMethodBeat.o(234537);
  }
  
  public final LinkedList<e> fhs()
  {
    for (;;)
    {
      int k;
      long l1;
      try
      {
        AppMethodBeat.i(234523);
        Object localObject1;
        if (this.rPI.isEmpty())
        {
          long l2 = Util.currentTicks();
          LinkedList localLinkedList1 = new LinkedList();
          localObject4 = this.Geg;
          if (localObject4 != null)
          {
            localObject1 = ((dbo)localObject4).TIV;
            if (localObject1 == null) {
              break label1746;
            }
            localObject1 = ((FinderObject)localObject1).objectDesc;
            if (localObject1 == null) {
              break label1746;
            }
            localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
            if (localObject1 == null) {
              break label1746;
            }
            localObject1 = Integer.valueOf(((bdp)localObject1).SOF);
            break label1731;
            localObject1 = ((dbo)localObject4).TIV;
            if (localObject1 == null) {
              break label1758;
            }
            localObject1 = ((FinderObject)localObject1).objectDesc;
            if (localObject1 == null) {
              break label1758;
            }
            localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
            if (localObject1 == null) {
              break label1758;
            }
            localObject1 = ((bdp)localObject1).SOB;
            LinkedList localLinkedList2 = ((dbo)localObject4).SGC;
            if (localObject1 != null)
            {
              Iterator localIterator = ((Iterable)localObject1).iterator();
              j = 0;
              if (localIterator.hasNext())
              {
                localObject1 = localIterator.next();
                k = j + 1;
                if (j < 0) {
                  kotlin.a.j.iBO();
                }
                bdt localbdt = (bdt)localObject1;
                if (localbdt.refObjectId == 0L) {
                  break label1726;
                }
                Object localObject5 = (q)this;
                p.j(localLinkedList2, "refObjectList");
                localObject1 = ((Iterable)localLinkedList2).iterator();
                if (!((Iterator)localObject1).hasNext()) {
                  break label1721;
                }
                Object localObject6 = (FinderObject)((Iterator)localObject1).next();
                if (((FinderObject)localObject6).id != localbdt.refObjectId) {
                  continue;
                }
                localObject1 = ((FinderObject)localObject6).objectDesc;
                if (localObject1 != null)
                {
                  localObject1 = ((FinderObjectDesc)localObject1).media;
                  if (localObject1 != null)
                  {
                    FinderMedia localFinderMedia = (FinderMedia)kotlin.a.j.lp((List)localObject1);
                    if (localFinderMedia != null)
                    {
                      Object localObject7 = "video_" + ((FinderObject)localObject6).id + '_' + j;
                      localObject1 = com.tencent.mm.plugin.mv.ui.a.Gfi;
                      String str = com.tencent.mm.plugin.mv.ui.a.aSI((String)localObject7);
                      localObject4 = localFinderMedia.url;
                      localObject1 = localObject4;
                      if (localObject4 == null) {
                        localObject1 = "";
                      }
                      localObject7 = new e((String)localObject7, str, (String)localObject1, kotlin.h.a.dm(localFinderMedia.width), kotlin.h.a.dm(localFinderMedia.height));
                      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject7).MSA = Integer.valueOf(2);
                      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject7).fPD = "xV2";
                      localObject4 = localFinderMedia.url_token;
                      localObject1 = localObject4;
                      if (localObject4 == null) {
                        localObject1 = "";
                      }
                      ((e)localObject7).beR((String)localObject1);
                      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject7).decodeKey = localFinderMedia.decodeKey;
                      localObject4 = localFinderMedia.thumbUrl;
                      localObject1 = localObject4;
                      if (localObject4 == null) {
                        localObject1 = "";
                      }
                      ((e)localObject7).Oc((String)localObject1);
                      localObject4 = localFinderMedia.thumb_url_token;
                      localObject1 = localObject4;
                      if (localObject4 == null) {
                        localObject1 = "";
                      }
                      ((e)localObject7).beS((String)localObject1);
                      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject7).MSF = localbdt.SOR;
                      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject7).MSE = localbdt.MSE;
                      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject7).MSG = localbdt.MSG;
                      localObject1 = ((FinderObject)localObject6).objectDesc;
                      if (localObject1 == null) {
                        break label1764;
                      }
                      localObject1 = ((FinderObjectDesc)localObject1).media;
                      if (localObject1 == null) {
                        break label1764;
                      }
                      localObject1 = (FinderMedia)kotlin.a.j.lo((List)localObject1);
                      if (localObject1 == null) {
                        break label1764;
                      }
                      l1 = ((FinderMedia)localObject1).videoDuration;
                      label600:
                      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject7).sTg = (l1 * 1000L);
                      localObject1 = MMThumbPlayerTextureView.MUw;
                      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject7).kYn = MMThumbPlayerTextureView.gpa();
                      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject7).fEF = false;
                      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject7).MSH = localObject6;
                      ((e)localObject7).MSI = localbdt.SOW;
                      ((e)localObject7).MSJ = localbdt.SOX;
                      localObject1 = com.tencent.mm.plugin.mv.model.a.GaP;
                      localObject1 = (com.tencent.mm.plugin.mv.model.a)((Map)com.tencent.mm.plugin.mv.model.a.ffQ()).get(localbdt.SOX);
                      if (localObject1 != null) {
                        ((e)localObject7).MSK = ((com.tencent.mm.plugin.mv.model.a)localObject1).GaM;
                      }
                      localLinkedList1.add(localObject7);
                      Log.i(((q)localObject5).TAG, "add mediaTrack network id:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject7).mediaId + " path:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject7).path + " width:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject7).width + " height:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject7).height + " timeOffsetInClipMs:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject7).MSG + " timeOffsetInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject7).MSE + " timeLengthInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject7).MSF);
                      localObject1 = kotlin.x.aazN;
                      i = 1;
                      localObject1 = kotlin.x.aazN;
                      if (i != 0) {
                        break label1793;
                      }
                      Log.i(this.TAG, "not find ref obj Id:" + localbdt.refObjectId);
                      if (localbdt == null) {
                        break label1787;
                      }
                      localObject4 = localbdt.SOS;
                      if (localObject4 == null) {
                        break label1787;
                      }
                      p.j(localObject4, "it");
                      if (((CharSequence)localObject4).length() <= 0) {
                        break label1770;
                      }
                      i = 1;
                      break label1739;
                      label906:
                      if (localObject4 == null) {
                        break label1787;
                      }
                      if (localLinkedList2 == null) {
                        break label1781;
                      }
                      localObject6 = ((Iterable)localLinkedList2).iterator();
                      localObject1 = null;
                      if (!((Iterator)localObject6).hasNext()) {
                        continue;
                      }
                      localObject7 = (FinderObject)((Iterator)localObject6).next();
                      if (!p.h(localObject4, ((FinderObject)localObject7).objectNonceId)) {
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
                      localFinderMedia = (FinderMedia)kotlin.a.j.lp((List)localObject5);
                      if (localFinderMedia == null) {
                        continue;
                      }
                      str = "video_" + ((FinderObject)localObject7).objectNonceId + '_' + j;
                      localObject5 = localFinderMedia.url;
                      localObject1 = localObject5;
                      if (localObject5 == null) {
                        localObject1 = "";
                      }
                      localObject1 = new e(str, (String)localObject1, "", kotlin.h.a.dm(localFinderMedia.width), kotlin.h.a.dm(localFinderMedia.height));
                      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).sTg = localFinderMedia.videoDuration;
                      localObject5 = kotlin.x.aazN;
                      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSH = localObject7;
                      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).fEF = true;
                      localObject5 = kotlin.x.aazN;
                      continue;
                      label1130:
                      if (((Integer)localObject1).intValue() != 1) {
                        continue;
                      }
                      localObject1 = ((dbo)localObject4).TIV;
                      if (localObject1 == null) {
                        break label1752;
                      }
                      localObject1 = ((FinderObject)localObject1).objectDesc;
                      if (localObject1 == null) {
                        break label1752;
                      }
                      localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
                      if (localObject1 == null) {
                        break label1752;
                      }
                      localObject1 = ((bdp)localObject1).SOE;
                      continue;
                    }
                  }
                }
                Log.i(((q)localObject5).TAG, "not find ref object media " + j + ' ' + localbdt.refObjectId + ' ' + localbdt.SOS);
                localObject1 = kotlin.x.aazN;
                i = 0;
                continue;
                localObject4 = kotlin.x.aazN;
                if (localObject1 != null) {
                  break label1718;
                }
                localObject1 = com.tencent.mm.plugin.mv.model.b.GaR;
                localObject4 = b.a.ffS();
                localObject1 = new e("video_" + ((com.tencent.mm.plugin.mv.model.b)localObject4).name + '_' + j, ((com.tencent.mm.plugin.mv.model.b)localObject4).getFilePath(), "", ((com.tencent.mm.plugin.mv.model.b)localObject4).width, ((com.tencent.mm.plugin.mv.model.b)localObject4).height);
                ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).sTg = ((com.tencent.mm.plugin.mv.model.b)localObject4).durationMs;
                ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).loop = true;
                ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSD = true;
                localObject4 = kotlin.x.aazN;
                ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).fEF = true;
                if (localObject1 == null) {
                  break label1793;
                }
                ((e)localObject1).MSM = localbdt.SOZ;
                ((e)localObject1).MSL.addAll((Collection)localbdt.SOY);
                ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSF = localbdt.SOR;
                ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSE = localbdt.MSE;
                ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSG = localbdt.MSG;
                ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).fEF = true;
                localObject4 = MMThumbPlayerTextureView.MUw;
                ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).kYn = MMThumbPlayerTextureView.gpa();
                ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).fSM = SightVideoJNI.getMp4RotateVFS(((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).path);
                if (((e)localObject1).gop()) {
                  ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).sTg = 5000L;
                }
                ((e)localObject1).MSJ = localbdt.SOX;
                localObject4 = com.tencent.mm.plugin.mv.model.a.GaP;
                localObject4 = (com.tencent.mm.plugin.mv.model.a)((Map)com.tencent.mm.plugin.mv.model.a.ffQ()).get(localbdt.SOX);
                if (localObject4 != null) {
                  ((e)localObject1).MSK = ((com.tencent.mm.plugin.mv.model.a)localObject4).GaM;
                }
                localLinkedList1.add(localObject1);
                Log.i(this.TAG, "add mediaTrack local id:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).mediaId + " path:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).path + " width:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).width + " height:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).height + " timeOffsetInClipMs:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSG + " timeOffsetInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSE + " timeLengthInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSF);
                localObject1 = kotlin.x.aazN;
                j = k;
                continue;
              }
              localObject1 = kotlin.x.aazN;
            }
          }
          Log.i(this.TAG, "collectBgVideoInfo cost:" + Util.ticksToNow(l2));
          this.rPI.addAll((Collection)localLinkedList1);
        }
        else
        {
          localObject1 = this.rPI;
          AppMethodBeat.o(234523);
          return localObject1;
        }
      }
      finally {}
      label1718:
      continue;
      label1721:
      int i = 0;
      continue;
      label1726:
      i = 0;
      continue;
      label1731:
      if (localObject2 == null) {}
      for (;;)
      {
        label1739:
        if (i == 0) {
          break label1775;
        }
        break label906;
        label1746:
        localObject3 = null;
        break label1731;
        break label1130;
        label1752:
        localObject3 = null;
        break;
        label1758:
        localObject3 = null;
        break;
        label1764:
        l1 = 0L;
        break label600;
        label1770:
        i = 0;
      }
      label1775:
      Object localObject4 = null;
      continue;
      label1781:
      Object localObject3 = null;
      continue;
      label1787:
      localObject3 = null;
      continue;
      label1793:
      int j = k;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(234517);
    if (getIntent().getBooleanExtra("key_seek_to_start", false))
    {
      paramBundle = k.fet();
      p.j(paramBundle, "MusicPlayerManager.Instance()");
      paramBundle.feg().wG(0);
    }
    AppMethodBeat.o(234517);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(234519);
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.GgY;
    if (localMultiMediaEffectVideoLayout != null)
    {
      localMultiMediaEffectVideoLayout.MUy.release();
      AppMethodBeat.o(234519);
      return;
    }
    AppMethodBeat.o(234519);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(234518);
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      if (paramIntent.getBooleanExtra("key_seek_to_start", false))
      {
        paramIntent = k.fet();
        p.j(paramIntent, "MusicPlayerManager.Instance()");
        paramIntent.feg().wG(0);
      }
      AppMethodBeat.o(234518);
      return;
    }
    AppMethodBeat.o(234518);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(234529);
    this.GlZ = true;
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.GgY;
    if (localMultiMediaEffectVideoLayout != null)
    {
      localMultiMediaEffectVideoLayout.pause();
      AppMethodBeat.o(234529);
      return;
    }
    AppMethodBeat.o(234529);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(234527);
    if (this.GlZ)
    {
      MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.GgY;
      if (localMultiMediaEffectVideoLayout != null) {
        localMultiMediaEffectVideoLayout.start();
      }
      this.GlZ = false;
    }
    AppMethodBeat.o(234527);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(234530);
    super.onStart();
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.GgY;
    if (localMultiMediaEffectVideoLayout != null)
    {
      localMultiMediaEffectVideoLayout.start();
      AppMethodBeat.o(234530);
      return;
    }
    AppMethodBeat.o(234530);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(234532);
    super.onStop();
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.GgY;
    if (localMultiMediaEffectVideoLayout != null)
    {
      localMultiMediaEffectVideoLayout.MUy.stop();
      AppMethodBeat.o(234532);
      return;
    }
    AppMethodBeat.o(234532);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewBgUIC$initBgCover$imageLoaderListener$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"})
  public static final class a
    implements h
  {
    a(ImageView paramImageView, x paramx) {}
    
    public final Bitmap a(String paramString, View paramView, com.tencent.mm.ay.a.d.b paramb)
    {
      AppMethodBeat.i(227534);
      p.k(paramString, "url");
      p.k(paramView, "view");
      p.k(paramb, "imageData");
      AppMethodBeat.o(227534);
      return null;
    }
    
    public final void b(String paramString, View paramView)
    {
      AppMethodBeat.i(227531);
      p.k(paramString, "url");
      p.k(paramView, "view");
      AppMethodBeat.o(227531);
    }
    
    public final void b(String paramString, View paramView, com.tencent.mm.ay.a.d.b paramb)
    {
      boolean bool = false;
      AppMethodBeat.i(227540);
      p.k(paramString, "url");
      p.k(paramView, "view");
      p.k(paramb, "imageData");
      paramView = this.Gma.TAG;
      if (paramb.bitmap != null) {
        bool = true;
      }
      Log.i(paramView, "onImageLoadFinish %s %b", new Object[] { paramString, Boolean.valueOf(bool) });
      if (paramb.bitmap != null)
      {
        paramString = paramb.bitmap;
        p.j(paramString, "imageData.bitmap");
        if (!paramString.isRecycled()) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramb.bitmap));
        }
      }
      AppMethodBeat.o(227540);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(q.a parama, Bitmap paramBitmap)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends kotlin.d.b.a.j
    implements m<ak, kotlin.d.d<? super kotlin.x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    b(q paramq, FrameLayout paramFrameLayout, com.tencent.mm.plugin.thumbplayer.view.d paramd, kotlin.d.d paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(228274);
      p.k(paramd, "completion");
      paramd = new b(this.Gma, localFrameLayout, paramd, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(228274);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(228277);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
      AppMethodBeat.o(228277);
      return paramObject1;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(228269);
      Object localObject2 = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(228269);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        localObject1 = (f)bc.iRs();
        localObject3 = (m)new d(this, null);
        this.L$0 = paramObject;
        this.label = 1;
        localObject1 = kotlinx.coroutines.i.a((f)localObject1, (m)localObject3, this);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(228269);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (LinkedList)paramObject;
      Log.i(this.Gma.TAG, "init mediaInfoList:" + paramObject.size());
      if (paramObject.isEmpty())
      {
        paramObject = kotlin.x.aazN;
        AppMethodBeat.o(228269);
        return paramObject;
      }
      Object localObject1 = localFrameLayout;
      p.j(localObject1, "videoContainer");
      ((FrameLayout)localObject1).setAlpha(0.0F);
      localObject1 = new MultiMediaEffectVideoLayout((Context)this.Gma.getActivity());
      ((MultiMediaEffectVideoLayout)localObject1).setId(b.e.music_video_layout);
      ((MultiMediaEffectVideoLayout)localObject1).setMediaChangeListener(paramd);
      ((MultiMediaEffectVideoLayout)localObject1).setMvMusicProxy((com.tencent.mm.plugin.thumbplayer.view.b)new a());
      localObject2 = new FrameLayout.LayoutParams(-1, -1);
      localFrameLayout.removeAllViews();
      localFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      ((MultiMediaEffectVideoLayout)localObject1).setMute(true);
      ((MultiMediaEffectVideoLayout)localObject1).setLoop(true);
      Object localObject3 = (Iterable)paramObject;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      label361:
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = ((Iterator)localObject3).next();
        if (((e)localObject4).MSF > 0L) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label361;
          }
          ((Collection)localObject2).add(localObject4);
          break;
        }
      }
      ((MultiMediaEffectVideoLayout)localObject1).setMediaList((List)localObject2);
      Log.i(((MultiMediaEffectVideoLayout)localObject1).TAG, "startIgnoreMusicPosition");
      ((MultiMediaEffectVideoLayout)localObject1).MUy.start();
      ((MultiMediaEffectVideoLayout)localObject1).MUz = -1L;
      q.a(this.Gma);
      ((MultiMediaEffectVideoLayout)localObject1).setOnProgressCallback((m)new b(this, paramObject));
      ((MultiMediaEffectVideoLayout)localObject1).setFirstFrameRenderCallback((kotlin.g.a.a)new c(this, paramObject));
      ((MultiMediaEffectVideoLayout)localObject1).setKeepScreenOn(true);
      this.Gma.GgY = ((MultiMediaEffectVideoLayout)localObject1);
      paramObject = kotlin.x.aazN;
      AppMethodBeat.o(228269);
      return paramObject;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewBgUIC$initBgVideo$1$1$1", "Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;", "getCurrentPosition", "", "getTotalDuration", "seekMusic", "", "position", "", "plugin-mv_release"})
    public static final class a
      implements com.tencent.mm.plugin.thumbplayer.view.b
    {
      public final void ZN(int paramInt)
      {
        AppMethodBeat.i(225196);
        k localk = k.fet();
        p.j(localk, "MusicPlayerManager.Instance()");
        localk.feg().wG(paramInt);
        AppMethodBeat.o(225196);
      }
      
      public final long getCurrentPosition()
      {
        AppMethodBeat.i(225194);
        Object localObject = k.fet();
        p.j(localObject, "MusicPlayerManager.Instance()");
        localObject = ((k)localObject).feg();
        p.j(localObject, "MusicPlayerManager.Instance().musicPlayer");
        long l = ((com.tencent.mm.plugin.music.f.a.d)localObject).fdx();
        AppMethodBeat.o(225194);
        return l;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "timeMs", "", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "invoke", "com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewBgUIC$initBgVideo$1$1$3"})
    static final class b
      extends kotlin.g.b.q
      implements m<Long, com.tencent.mm.plugin.thumbplayer.e.d, kotlin.x>
    {
      b(q.b paramb, LinkedList paramLinkedList)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewBgUIC$initBgVideo$1$1$4"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      c(q.b paramb, LinkedList paramLinkedList)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaSEInfo;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class d
      extends kotlin.d.b.a.j
      implements m<ak, kotlin.d.d<? super LinkedList<e>>, Object>
    {
      int label;
      private ak p$;
      
      d(q.b paramb, kotlin.d.d paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(229386);
        p.k(paramd, "completion");
        paramd = new d(this.Gme, paramd);
        paramd.p$ = ((ak)paramObject);
        AppMethodBeat.o(229386);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(229388);
        paramObject1 = ((d)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
        AppMethodBeat.o(229388);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(229380);
        kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(229380);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.Gme.Gma.fhs();
        AppMethodBeat.o(229380);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.q
 * JD-Core Version:    0.7.0.1
 */