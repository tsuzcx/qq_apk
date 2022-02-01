package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.model.b.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.thumbplayer.view.MultiMediaEffectVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewBgUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "firstTimePlay", "", "getFirstTimePlay", "()Z", "setFirstTimePlay", "(Z)V", "isOnActivityPause", "setOnActivityPause", "mediaInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaSEInfo;", "progressCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "timeMs", "total", "", "getProgressCallback", "()Lkotlin/jvm/functions/Function2;", "setProgressCallback", "(Lkotlin/jvm/functions/Function2;)V", "rawProgressCallback", "Lkotlin/Function1;", "getRawProgressCallback", "()Lkotlin/jvm/functions/Function1;", "setRawProgressCallback", "(Lkotlin/jvm/functions/Function1;)V", "thumbPath", "getThumbPath", "setThumbPath", "(Ljava/lang/String;)V", "thumbUrl", "getThumbUrl", "setThumbUrl", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getTrackData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setTrackData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MultiMediaEffectVideoLayout;", "getVideoLayout", "()Lcom/tencent/mm/plugin/thumbplayer/view/MultiMediaEffectVideoLayout;", "setVideoLayout", "(Lcom/tencent/mm/plugin/thumbplayer/view/MultiMediaEffectVideoLayout;)V", "applyTransition", "index", "", "pagInfo", "Lcom/tencent/mm/plugin/mv/model/DefaultPagInfo;", "checkSyncMvPositionWithMusic", "collectBgVideoInfo", "delete", "initBgCover", "listener", "Lcom/tencent/mm/plugin/mv/ui/uic/OnBackgroundBitmapReadyListener;", "initBgVideo", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "move", "fromPosition", "toPosition", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "onStart", "onStop", "refreshOffsets", "fillingDuration", "seekToTime", "selectMedia", "updateMediaInfo", "startTime", "endTime", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends UIComponent
{
  public dtf LZM;
  public MultiMediaEffectVideoLayout Mci;
  public m<? super Long, ? super Long, kotlin.ah> Mgs;
  public kotlin.g.a.b<? super Long, kotlin.ah> Mgt;
  private boolean Mgu;
  private boolean Mgv;
  final String TAG;
  public String thumbPath;
  public String thumbUrl;
  public final LinkedList<com.tencent.mm.plugin.thumbplayer.d.d> vaX;
  
  public n(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287805);
    this.TAG = "MicroMsg.Mv.MusicMvPreviewBgUIC";
    this.vaX = new LinkedList();
    this.Mgu = true;
    AppMethodBeat.o(287805);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.mv.model.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(287931);
    Object localObject1 = this.vaX.get(paramInt);
    s.s(localObject1, "mediaInfoList[index]");
    com.tencent.mm.plugin.thumbplayer.d.d locald = (com.tencent.mm.plugin.thumbplayer.d.d)localObject1;
    if (parama == null)
    {
      localObject1 = null;
      locald.TEX = ((String)localObject1);
      if (parama != null) {
        break label90;
      }
      localObject1 = null;
      label47:
      locald.TEW = ((String)localObject1);
      localObject1 = this.Mci;
      if (localObject1 != null) {
        if (parama != null) {
          break label98;
        }
      }
    }
    label90:
    label98:
    for (parama = localObject2;; parama = parama.LWN)
    {
      ((MultiMediaEffectVideoLayout)localObject1).a(locald, parama);
      AppMethodBeat.o(287931);
      return;
      localObject1 = parama.LWN;
      break;
      localObject1 = parama.id;
      break label47;
    }
  }
  
  public final void a(u paramu)
  {
    AppMethodBeat.i(287847);
    ImageView localImageView = (ImageView)getActivity().findViewById(b.e.LRQ);
    n.a locala = new n.a(this, localImageView, paramu);
    paramu = this.thumbPath;
    if (paramu == null) {}
    for (paramu = null;; paramu = kotlin.ah.aiuX)
    {
      if (paramu == null)
      {
        localObject1 = (n)this;
        paramu = ((n)localObject1).thumbUrl;
        if (paramu != null)
        {
          Object localObject2 = com.tencent.mm.plugin.mv.ui.a.Maz;
          localObject2 = com.tencent.mm.plugin.mv.ui.a.aPB(paramu);
          Log.i(((n)localObject1).TAG, "initBgCover url:" + paramu + " fullPath:" + (String)localObject2);
          localObject1 = new c.a();
          ((c.a)localObject1).fullPath = ((String)localObject2);
          ((c.a)localObject1).oKp = true;
          ((c.a)localObject1).oKn = true;
          r.bKe().a(paramu, localImageView, ((c.a)localObject1).bKx(), (h)locala);
        }
      }
      AppMethodBeat.o(287847);
      return;
      Log.i(this.TAG, s.X("initBgCover thumbPath:", this.thumbPath));
      Object localObject1 = new c.a();
      ((c.a)localObject1).oKn = true;
      ((c.a)localObject1).oKs = 1;
      localObject1 = ((c.a)localObject1).bKx();
      s.s(localObject1, "Builder().setCacheInMemo…ns.LoadFrom.FILE).build()");
      r.bKe().a(paramu, localImageView, (c)localObject1, (h)locala);
    }
  }
  
  public final void a(final com.tencent.mm.plugin.thumbplayer.view.d paramd)
  {
    AppMethodBeat.i(287889);
    s.u(paramd, "listener");
    final FrameLayout localFrameLayout = (FrameLayout)getActivity().findViewById(b.e.LRP);
    kotlinx.coroutines.j.a((aq)bu.ajwo, (f)bg.kCh(), null, (m)new b(this, localFrameLayout, paramd, null), 2);
    AppMethodBeat.o(287889);
  }
  
  public final void aej(int paramInt)
  {
    AppMethodBeat.i(287948);
    if (paramInt == -1)
    {
      AppMethodBeat.o(287948);
      return;
    }
    this.vaX.remove(paramInt);
    sJ(((com.tencent.mm.plugin.thumbplayer.d.d)this.vaX.getLast()).TBN);
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.Mci;
    if (localMultiMediaEffectVideoLayout != null)
    {
      Object localObject1 = (Iterable)this.vaX;
      Collection localCollection = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label135:
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (((com.tencent.mm.plugin.thumbplayer.d.d)localObject2).TBN > 0L) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label135;
          }
          localCollection.add(localObject2);
          break;
        }
      }
      localMultiMediaEffectVideoLayout.setMediaList((List)localCollection);
    }
    localMultiMediaEffectVideoLayout = this.Mci;
    if (localMultiMediaEffectVideoLayout != null) {
      localMultiMediaEffectVideoLayout.start();
    }
    AppMethodBeat.o(287948);
  }
  
  public final void b(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(287943);
    Log.i(this.TAG, "updateMediaInfo: index=" + paramInt + ", startTime=" + paramLong1 + ", endTime=" + paramLong2 + ", fillingDuration=" + paramLong3);
    Object localObject1 = this.vaX.get(paramInt);
    s.s(localObject1, "mediaInfoList[index]");
    localObject1 = (com.tencent.mm.plugin.thumbplayer.d.d)localObject1;
    ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBN = (paramLong2 - paramLong1);
    ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBO = paramLong1;
    sJ(paramLong3);
    localObject1 = this.Mci;
    if (localObject1 != null)
    {
      Object localObject2 = (Iterable)this.vaX;
      Collection localCollection = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label202:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (((com.tencent.mm.plugin.thumbplayer.d.d)localObject3).TBN > 0L) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label202;
          }
          localCollection.add(localObject3);
          break;
        }
      }
      ((MultiMediaEffectVideoLayout)localObject1).setMediaList((List)localCollection);
    }
    localObject1 = this.Mci;
    if (localObject1 != null) {
      ((MultiMediaEffectVideoLayout)localObject1).start();
    }
    AppMethodBeat.o(287943);
  }
  
  public final LinkedList<com.tencent.mm.plugin.thumbplayer.d.d> grd()
  {
    for (;;)
    {
      Object localObject4;
      int k;
      int i;
      try
      {
        AppMethodBeat.i(287882);
        Object localObject1;
        if (this.vaX.isEmpty())
        {
          long l2 = Util.currentTicks();
          LinkedList localLinkedList1 = new LinkedList();
          localObject4 = this.LZM;
          if (localObject4 != null)
          {
            localObject1 = ((dtf)localObject4).aaYK;
            boq localboq;
            Object localObject5;
            Object localObject6;
            if (localObject1 == null)
            {
              localObject1 = null;
              break label1805;
              localObject1 = ((dtf)localObject4).aaYK;
              if (localObject1 == null)
              {
                localObject1 = null;
                LinkedList localLinkedList2 = ((dtf)localObject4).ZJp;
                if (localObject1 == null) {
                  continue;
                }
                Iterator localIterator = ((Iterable)localObject1).iterator();
                k = 0;
                if (!localIterator.hasNext()) {
                  continue;
                }
                localObject1 = localIterator.next();
                if (k < 0) {
                  p.kkW();
                }
                localboq = (boq)localObject1;
                if (localboq.refObjectId == 0L) {
                  break label1800;
                }
                localObject5 = (n)this;
                s.s(localLinkedList2, "refObjectList");
                localObject1 = ((Iterable)localLinkedList2).iterator();
                if (!((Iterator)localObject1).hasNext()) {
                  break label1795;
                }
                localObject6 = (FinderObject)((Iterator)localObject1).next();
                if (((FinderObject)localObject6).id != localboq.refObjectId) {
                  continue;
                }
                localObject1 = ((FinderObject)localObject6).objectDesc;
                if (localObject1 != null) {
                  continue;
                }
                localObject1 = null;
                i = 0;
                j = i;
                if (localObject1 == null)
                {
                  Log.i(((n)localObject5).TAG, "not find ref object media " + k + ' ' + localboq.refObjectId + ' ' + localboq.ZWZ);
                  localObject1 = kotlin.ah.aiuX;
                  j = i;
                }
                localObject1 = kotlin.ah.aiuX;
                if (j != 0) {
                  break label1834;
                }
                Log.i(this.TAG, s.X("not find ref obj Id:", Long.valueOf(localboq.refObjectId)));
                if (localboq == null) {
                  break label1789;
                }
                localObject4 = localboq.ZWZ;
                if (localObject4 == null) {
                  break label1789;
                }
                if (((CharSequence)localObject4).length() <= 0) {
                  break label1823;
                }
                i = 1;
                break label1813;
                if ((localObject4 == null) || (localLinkedList2 == null)) {
                  break label1789;
                }
                localObject6 = ((Iterable)localLinkedList2).iterator();
                localObject1 = null;
                label379:
                if (!((Iterator)localObject6).hasNext()) {
                  continue;
                }
                localObject7 = (FinderObject)((Iterator)localObject6).next();
                if (!s.p(localObject4, ((FinderObject)localObject7).objectNonceId)) {
                  break label1786;
                }
                localObject5 = ((FinderObject)localObject7).objectDesc;
                if (localObject5 == null) {
                  break label1786;
                }
                localObject5 = ((FinderObjectDesc)localObject5).media;
                if (localObject5 == null) {
                  break label1786;
                }
                localFinderMedia = (FinderMedia)p.oL((List)localObject5);
                if (localFinderMedia == null) {
                  break label1786;
                }
                str = "video_" + ((FinderObject)localObject7).objectNonceId + '_' + k;
                localObject5 = localFinderMedia.url;
                localObject1 = localObject5;
                if (localObject5 == null) {
                  localObject1 = "";
                }
                localObject1 = new com.tencent.mm.plugin.thumbplayer.d.d(str, (String)localObject1, "", kotlin.h.a.eH(localFinderMedia.width), kotlin.h.a.eH(localFinderMedia.height));
                ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).vYw = localFinderMedia.videoDuration;
                localObject5 = kotlin.ah.aiuX;
                ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBP = localObject7;
                ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).hJv = true;
                localObject5 = kotlin.ah.aiuX;
                localObject5 = kotlin.ah.aiuX;
                break label1820;
              }
            }
            else
            {
              localObject1 = ((FinderObject)localObject1).objectDesc;
              if (localObject1 == null)
              {
                localObject1 = null;
                break label1805;
              }
              localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
              if (localObject1 == null)
              {
                localObject1 = null;
                break label1805;
              }
              localObject1 = Integer.valueOf(((bol)localObject1).ZWM);
              break label1805;
              if (((Integer)localObject1).intValue() != 1) {
                continue;
              }
              localObject1 = ((dtf)localObject4).aaYK;
              if (localObject1 == null)
              {
                localObject1 = null;
                continue;
              }
              localObject1 = ((FinderObject)localObject1).objectDesc;
              if (localObject1 == null)
              {
                localObject1 = null;
                continue;
              }
              localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
              if (localObject1 == null)
              {
                localObject1 = null;
                continue;
              }
              localObject1 = ((bol)localObject1).ZWL;
              continue;
            }
            localObject1 = ((FinderObject)localObject1).objectDesc;
            if (localObject1 == null)
            {
              localObject1 = null;
              continue;
            }
            localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
            if (localObject1 == null)
            {
              localObject1 = null;
              continue;
            }
            localObject1 = ((bol)localObject1).ZWI;
            continue;
            localObject1 = ((FinderObjectDesc)localObject1).media;
            if (localObject1 == null)
            {
              localObject1 = null;
              i = 0;
              continue;
            }
            FinderMedia localFinderMedia = (FinderMedia)p.oL((List)localObject1);
            if (localFinderMedia == null)
            {
              localObject1 = null;
              i = 0;
              continue;
            }
            Object localObject7 = "video_" + ((FinderObject)localObject6).id + '_' + k;
            localObject1 = com.tencent.mm.plugin.mv.ui.a.Maz;
            String str = com.tencent.mm.plugin.mv.ui.a.aPC((String)localObject7);
            localObject4 = localFinderMedia.url;
            localObject1 = localObject4;
            if (localObject4 == null) {
              localObject1 = "";
            }
            localObject7 = new com.tencent.mm.plugin.thumbplayer.d.d((String)localObject7, str, (String)localObject1, kotlin.h.a.eH(localFinderMedia.width), kotlin.h.a.eH(localFinderMedia.height));
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).TBJ = 2;
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).hVy = "xV2";
            localObject4 = localFinderMedia.url_token;
            localObject1 = localObject4;
            if (localObject4 == null) {
              localObject1 = "";
            }
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).msf = ((String)localObject1);
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).decodeKey = localFinderMedia.decodeKey;
            localObject4 = localFinderMedia.thumbUrl;
            localObject1 = localObject4;
            if (localObject4 == null) {
              localObject1 = "";
            }
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).thumbUrl = ((String)localObject1);
            localObject4 = localFinderMedia.thumb_url_token;
            localObject1 = localObject4;
            if (localObject4 == null) {
              localObject1 = "";
            }
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).msh = ((String)localObject1);
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).TBN = localboq.ZWY;
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).TBM = localboq.TBM;
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).TBO = localboq.TBO;
            localObject1 = ((FinderObject)localObject6).objectDesc;
            if (localObject1 == null)
            {
              l1 = 0L;
              ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).vYw = (l1 * 1000L);
              ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).nDl = 2;
              ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).hJv = false;
              ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).TBP = localObject6;
              ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).TEV = localboq.ZXd;
              ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).TEW = localboq.ZXe;
              localObject1 = com.tencent.mm.plugin.mv.model.a.LWK;
              localObject1 = (com.tencent.mm.plugin.mv.model.a)((Map)com.tencent.mm.plugin.mv.model.a.gpt()).get(localboq.ZXe);
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).TEX = ((com.tencent.mm.plugin.mv.model.a)localObject1).LWN;
              }
              localLinkedList1.add(localObject7);
              Log.i(((n)localObject5).TAG, "add mediaTrack network id:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).mediaId + " path:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).path + " width:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).width + " height:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).height + " timeOffsetInClipMs:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).TBO + " timeOffsetInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).TBM + " timeLengthInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject7).TBN);
              localObject1 = kotlin.ah.aiuX;
              localObject1 = kotlin.ah.aiuX;
              i = 1;
              continue;
            }
            localObject1 = ((FinderObjectDesc)localObject1).media;
            if (localObject1 == null)
            {
              l1 = 0L;
              continue;
            }
            localObject1 = (FinderMedia)p.oK((List)localObject1);
            if (localObject1 == null)
            {
              l1 = 0L;
              continue;
            }
            long l1 = ((FinderMedia)localObject1).videoDuration;
            continue;
            localObject4 = kotlin.ah.aiuX;
            if (localObject1 != null) {
              break label1783;
            }
            localObject1 = com.tencent.mm.plugin.mv.model.b.LWQ;
            localObject4 = b.a.gpv();
            localObject1 = new com.tencent.mm.plugin.thumbplayer.d.d("video_" + ((com.tencent.mm.plugin.mv.model.b)localObject4).name + '_' + k, ((com.tencent.mm.plugin.mv.model.b)localObject4).getFilePath(), "", ((com.tencent.mm.plugin.mv.model.b)localObject4).width, ((com.tencent.mm.plugin.mv.model.b)localObject4).height);
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).vYw = ((com.tencent.mm.plugin.mv.model.b)localObject4).durationMs;
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).loop = true;
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBL = true;
            localObject4 = kotlin.ah.aiuX;
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).hJv = true;
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TEZ = localboq.ZXg;
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TEY.addAll((Collection)localboq.ZXf);
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBN = localboq.ZWY;
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBM = localboq.TBM;
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBO = localboq.TBO;
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).hJv = true;
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).nDl = 2;
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).hYK = SightVideoJNI.getMp4RotateVFS(((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).path);
            if (((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).hLc()) {
              ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).vYw = 5000L;
            }
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TEW = localboq.ZXe;
            localObject4 = com.tencent.mm.plugin.mv.model.a.LWK;
            localObject4 = (com.tencent.mm.plugin.mv.model.a)((Map)com.tencent.mm.plugin.mv.model.a.gpt()).get(localboq.ZXe);
            if (localObject4 != null) {
              ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TEX = ((com.tencent.mm.plugin.mv.model.a)localObject4).LWN;
            }
            localLinkedList1.add(localObject1);
            Log.i(this.TAG, "add mediaTrack local id:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).mediaId + " path:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).path + " width:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).width + " height:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).height + " timeOffsetInClipMs:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBO + " timeOffsetInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBM + " timeLengthInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBN);
            localObject1 = kotlin.ah.aiuX;
            localObject1 = kotlin.ah.aiuX;
            break label1834;
            localObject1 = kotlin.ah.aiuX;
          }
          Log.i(this.TAG, s.X("collectBgVideoInfo cost:", Long.valueOf(Util.ticksToNow(l2))));
          this.vaX.addAll((Collection)localLinkedList1);
        }
        else
        {
          localObject1 = this.vaX;
          AppMethodBeat.o(287882);
          return localObject1;
        }
      }
      finally {}
      label1783:
      continue;
      label1786:
      break label1820;
      label1789:
      Object localObject3 = null;
      continue;
      label1795:
      int j = 0;
      continue;
      label1800:
      j = 0;
      continue;
      label1805:
      if (localObject3 == null)
      {
        continue;
        for (;;)
        {
          label1813:
          if (i == 0) {
            break label1828;
          }
          break;
          label1820:
          break label379;
          label1823:
          i = 0;
        }
        label1828:
        localObject4 = null;
        continue;
        label1834:
        k += 1;
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(287822);
    if (getIntent().getBooleanExtra("key_seek_to_start", false)) {
      com.tencent.mm.plugin.music.logic.j.gnw().gnj().wH(0);
    }
    AppMethodBeat.o(287822);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(287835);
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.Mci;
    if (localMultiMediaEffectVideoLayout != null) {
      localMultiMediaEffectVideoLayout.TGY.release();
    }
    AppMethodBeat.o(287835);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(287830);
    super.onNewIntent(paramIntent);
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_seek_to_start", false))) {
      com.tencent.mm.plugin.music.logic.j.gnw().gnj().wH(0);
    }
    AppMethodBeat.o(287830);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(287916);
    this.Mgv = true;
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.Mci;
    if (localMultiMediaEffectVideoLayout != null) {
      localMultiMediaEffectVideoLayout.pause();
    }
    AppMethodBeat.o(287916);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(287910);
    if (this.Mgv)
    {
      MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.Mci;
      if (localMultiMediaEffectVideoLayout != null) {
        localMultiMediaEffectVideoLayout.start();
      }
      this.Mgv = false;
    }
    AppMethodBeat.o(287910);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(287923);
    super.onStart();
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.Mci;
    if (localMultiMediaEffectVideoLayout != null) {
      localMultiMediaEffectVideoLayout.start();
    }
    AppMethodBeat.o(287923);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(287927);
    super.onStop();
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.Mci;
    if (localMultiMediaEffectVideoLayout != null) {
      localMultiMediaEffectVideoLayout.TGY.stop();
    }
    AppMethodBeat.o(287927);
  }
  
  public final void sJ(long paramLong)
  {
    AppMethodBeat.i(287953);
    Object localObject3 = (Iterable)kotlin.k.k.qt(0, this.vaX.size() - 1);
    Object localObject1 = this.vaX;
    Object localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add((com.tencent.mm.plugin.thumbplayer.d.d)((LinkedList)localObject1).get(((kotlin.a.ah)localObject3).Zo()));
    }
    localObject1 = ((Iterable)localObject2).iterator();
    for (long l = 0L; ((Iterator)localObject1).hasNext(); l = ((com.tencent.mm.plugin.thumbplayer.d.d)localObject2).TBN + l)
    {
      localObject2 = (com.tencent.mm.plugin.thumbplayer.d.d)((Iterator)localObject1).next();
      ((com.tencent.mm.plugin.thumbplayer.d.d)localObject2).TBM = l;
    }
    localObject1 = (com.tencent.mm.plugin.thumbplayer.d.d)this.vaX.getLast();
    ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBM = l;
    ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBN = paramLong;
    AppMethodBeat.o(287953);
  }
  
  public final void sM(long paramLong)
  {
    AppMethodBeat.i(287902);
    Log.i(this.TAG, s.X("seekToTime: ", Long.valueOf(paramLong)));
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.Mci;
    if (localMultiMediaEffectVideoLayout != null) {
      localMultiMediaEffectVideoLayout.seekTo(paramLong);
    }
    AppMethodBeat.o(287902);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    b(n paramn, FrameLayout paramFrameLayout, com.tencent.mm.plugin.thumbplayer.view.d paramd, kotlin.d.d<? super b> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(287985);
      paramObject = (kotlin.d.d)new b(this.Mgw, localFrameLayout, paramd, paramd);
      AppMethodBeat.o(287985);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(287980);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(287980);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (f)bg.kCi();
        localObject1 = (m)new n.b.d(this.Mgw, null);
        localObject3 = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = l.a(paramObject, (m)localObject1, (kotlin.d.d)localObject3);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(287980);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      Object localObject3 = (LinkedList)paramObject;
      Log.i(this.Mgw.TAG, s.X("init mediaInfoList:", Integer.valueOf(((LinkedList)localObject3).size())));
      if (((LinkedList)localObject3).isEmpty())
      {
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(287980);
        return paramObject;
      }
      localFrameLayout.setAlpha(0.0F);
      paramObject = new MultiMediaEffectVideoLayout((Context)this.Mgw.getActivity());
      Object localObject4 = paramd;
      Object localObject1 = localFrameLayout;
      localObject2 = this.Mgw;
      paramObject.setId(b.e.music_video_layout);
      paramObject.setMediaChangeListener((com.tencent.mm.plugin.thumbplayer.view.d)localObject4);
      paramObject.setMvMusicProxy((com.tencent.mm.plugin.thumbplayer.view.b)new a());
      localObject4 = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout)localObject1).removeAllViews();
      ((FrameLayout)localObject1).addView((View)paramObject, (ViewGroup.LayoutParams)localObject4);
      paramObject.setMute(true);
      paramObject.setLoop(true);
      localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      label357:
      while (((Iterator)localObject4).hasNext())
      {
        Object localObject5 = ((Iterator)localObject4).next();
        if (((com.tencent.mm.plugin.thumbplayer.d.d)localObject5).TBN > 0L) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label357;
          }
          ((Collection)localObject3).add(localObject5);
          break;
        }
      }
      paramObject.setMediaList((List)localObject3);
      Log.i(paramObject.TAG, "startIgnoreMusicPosition");
      paramObject.TGY.start();
      paramObject.TGZ = -1L;
      n.a((n)localObject2);
      paramObject.setOnProgressCallback((m)new n.b.b((n)localObject2));
      paramObject.setFirstFrameRenderCallback((kotlin.g.a.a)new n.b.c((FrameLayout)localObject1));
      paramObject.setKeepScreenOn(true);
      ((n)localObject2).Mci = paramObject;
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(287980);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewBgUIC$initBgVideo$1$1$1", "Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;", "getCurrentPosition", "", "getTotalDuration", "seekMusic", "", "position", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.mm.plugin.thumbplayer.view.b
    {
      public final void aea(int paramInt)
      {
        AppMethodBeat.i(287996);
        com.tencent.mm.plugin.music.logic.j.gnw().gnj().wH(paramInt);
        AppMethodBeat.o(287996);
      }
      
      public final long getCurrentPosition()
      {
        AppMethodBeat.i(287988);
        long l = com.tencent.mm.plugin.music.logic.j.gnw().gnj().gmA();
        AppMethodBeat.o(287988);
        return l;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.n
 * JD-Core Version:    0.7.0.1
 */