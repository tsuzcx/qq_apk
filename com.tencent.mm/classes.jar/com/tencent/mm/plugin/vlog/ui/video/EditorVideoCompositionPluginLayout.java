package com.tencent.mm.plugin.vlog.ui.video;

import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.oo;
import com.tencent.mm.autogen.mmdata.rpt.oz;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.activity.a.a;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.q;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.protocal.protobuf.djw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/video/EditorVideoCompositionPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mediaModel", "Lcom/tencent/mm/plugin/vlog/ui/video/MediaModel;", "previewNewPlugin", "Lcom/tencent/mm/plugin/vlog/ui/video/EditVideoPreviewPlugin;", "reMuxNewPlugin", "Lcom/tencent/mm/plugin/vlog/ui/video/RemuxNewPlugin;", "createReportString", "", "city", "poiName", "getPlayerView", "Landroid/view/View;", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "", "prepareImageSizeReport", "prepareStoryBehaviorReport", "prepareStoryFailBehaviorReport", "setupMediaData", "Lkotlinx/coroutines/Job;", "setupNormalVideoPlugins", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public class EditorVideoCompositionPluginLayout
  extends BaseEditVideoPluginLayout
  implements com.tencent.mm.plugin.recordvideo.plugin.parent.a
{
  public static final EditorVideoCompositionPluginLayout.a UrH;
  private d UrE;
  private c UrI;
  private final e UrJ;
  
  static
  {
    AppMethodBeat.i(282042);
    UrH = new EditorVideoCompositionPluginLayout.a((byte)0);
    AppMethodBeat.o(282042);
  }
  
  public EditorVideoCompositionPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(281977);
    this.UrE = new d();
    com.tencent.mm.plugin.vlog.model.local.a.a(com.tencent.mm.plugin.vlog.model.local.a.UbD);
    this.UrJ = new e(paramContext, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
    getPluginList().add(this.UrJ);
    AppMethodBeat.o(281977);
  }
  
  private static final void a(EditorVideoCompositionPluginLayout paramEditorVideoCompositionPluginLayout)
  {
    Object localObject2 = null;
    AppMethodBeat.i(282011);
    kotlin.g.b.s.u(paramEditorVideoCompositionPluginLayout, "this$0");
    Object localObject1 = paramEditorVideoCompositionPluginLayout.getCaptureInfo();
    if (localObject1 == null)
    {
      localObject1 = null;
      y.deleteFile((String)localObject1);
      paramEditorVideoCompositionPluginLayout = paramEditorVideoCompositionPluginLayout.getCaptureInfo();
      if (paramEditorVideoCompositionPluginLayout != null) {
        break label59;
      }
    }
    label59:
    for (paramEditorVideoCompositionPluginLayout = localObject2;; paramEditorVideoCompositionPluginLayout = paramEditorVideoCompositionPluginLayout.nJU)
    {
      y.deleteFile(paramEditorVideoCompositionPluginLayout);
      AppMethodBeat.o(282011);
      return;
      localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJX;
      break;
    }
  }
  
  private final void gIY()
  {
    AppMethodBeat.i(281991);
    Object localObject1 = ((Iterable)getItemContainerPlugin().getEditorDataList()).iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)((Iterator)localObject1).next();
      Object localObject3 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).NXP;
      switch (b.avl[localObject3.ordinal()])
      {
      default: 
        break;
      case 1: 
        i += 1;
        break;
      case 2: 
        j += 1;
        break;
      case 3: 
        localObject2 = (djw)((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).gKs();
        localObject3 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        localObject3 = com.tencent.mm.plugin.recordvideo.f.c.gJf();
        String str1 = ((djw)localObject2).NYS;
        kotlin.g.b.s.s(str1, "poiData.cityName");
        String str2 = ((djw)localObject2).poiName;
        kotlin.g.b.s.s(str2, "poiData.poiName");
        StringBuilder localStringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty((CharSequence)str1)) {
          localStringBuilder.append(kotlin.n.n.m(str1, ",", " ", true));
        }
        if (!TextUtils.isEmpty((CharSequence)str2)) {
          if (((CharSequence)localStringBuilder).length() <= 0) {
            break label328;
          }
        }
        for (int k = 1;; k = 0)
        {
          if (k != 0) {
            localStringBuilder.append("|");
          }
          localStringBuilder.append(kotlin.n.n.m(str2, ",", " ", true));
          str1 = localStringBuilder.toString();
          kotlin.g.b.s.s(str1, "reportPositionString.toString()");
          ((oo)localObject3).wo(str1);
          localObject3 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.gJf().wp(String.valueOf(((djw)localObject2).latitude));
          localObject3 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.gJf().wq(String.valueOf(((djw)localObject2).longitude));
          break;
        }
      case 4: 
        localObject2 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.gJf().jjJ = 1L;
        break;
      case 5: 
        label328:
        localObject2 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.gJf().jjK = 1L;
      }
    }
    localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.gJf().jjx = i;
    localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.gJf().jjy = j;
    localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    localObject1 = com.tencent.mm.plugin.recordvideo.f.c.gJf();
    if (getMoreMenuPlugin().NJY) {}
    for (long l = 1L;; l = 0L)
    {
      ((oo)localObject1).jjG = l;
      AppMethodBeat.o(281991);
      return;
    }
  }
  
  private final void gIZ()
  {
    AppMethodBeat.i(282003);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = getCaptureInfo();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).nKc;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          BitmapFactory.decodeFile(str, localOptions);
          i = localOptions.outWidth;
          int j = localOptions.outHeight;
          localStringBuilder.append(j + ':' + i + "||");
        }
      }
    }
    int i = localStringBuilder.lastIndexOf("||");
    if (i >= 0)
    {
      localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.gJf().wr(localStringBuilder.substring(0, i).toString());
    }
    AppMethodBeat.o(282003);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(282072);
    Log.i("MicroMsg.EditorVideoCompositionPluginLayout", kotlin.g.b.s.X("loadCurrentPage info ", paramb));
    super.a(paramb);
    Object localObject3 = this.UrI;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("previewNewPlugin");
      localObject1 = null;
    }
    localObject3 = this.UrE;
    kotlin.g.b.s.u(localObject3, "mediaModel");
    ((c)localObject1).UrE = ((d)localObject3);
    kotlinx.coroutines.j.a((aq)bu.ajwo, (kotlin.d.f)bg.kCh(), null, (m)new c(this, null), 2);
    long l;
    if (paramb != null)
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.util.d.Obm;
      com.tencent.mm.plugin.recordvideo.util.d.ahc(0);
      if (paramb.buf())
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.util.d.Obm;
        com.tencent.mm.plugin.recordvideo.util.d.ahc(com.tencent.mm.plugin.recordvideo.util.d.gLe() + 1);
      }
      if (paramb.bue())
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.util.d.Obm;
        com.tencent.mm.plugin.recordvideo.util.d.ahc(com.tencent.mm.plugin.recordvideo.util.d.gLe() + 1);
      }
      l = Util.currentTicks();
      localObject1 = getBgPlugin();
      localObject3 = getCaptureInfo();
      kotlin.g.b.s.checkNotNull(localObject3);
      ((com.tencent.mm.plugin.recordvideo.plugin.s)localObject1).a((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3, getConfigProvider());
      localObject3 = this.UrJ;
      localObject1 = getConfigProvider();
      kotlin.g.b.s.checkNotNull(localObject1);
      kotlin.g.b.s.u(paramb, "info");
      kotlin.g.b.s.u(localObject1, "configProvider");
      ((e)localObject3).NLs = paramb;
      ((e)localObject3).oaV = ((RecordConfigProvider)localObject1);
      localObject1 = ((e)localObject3).oaV;
      if (localObject1 != null) {
        break label776;
      }
      localObject1 = localObject2;
      ((e)localObject3).KVn = ((VideoTransPara)localObject1);
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_IS_CAPUTRE_BOOLEAN", Boolean.valueOf(paramb.nJW));
      if (paramb.nJW)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("KEY_CAPUTRE_VIDEO_PATH_STRING", paramb.bug());
        localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("KEY_CAPUTRE_THUMB_PATH_STRING", paramb.buh());
      }
      Log.d("MicroMsg.EditorVideoCompositionPluginLayout", kotlin.g.b.s.X("reMuxNewPlugin ", Long.valueOf(Util.ticksToNow(l))));
      localObject1 = getCropVideoPlugin();
      localObject2 = getCaptureInfo();
      kotlin.g.b.s.checkNotNull(localObject2);
      localObject3 = getConfigProvider();
      kotlin.g.b.s.checkNotNull(localObject3);
      ((com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a)localObject1).c((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2, (RecordConfigProvider)localObject3);
      Log.d("MicroMsg.EditorVideoCompositionPluginLayout", kotlin.g.b.s.X("cropVideoPlugin ", Long.valueOf(Util.ticksToNow(l))));
      if (paramb.nKf != null)
      {
        localObject1 = paramb.nKf;
        kotlin.g.b.s.checkNotNull(localObject1);
        localObject2 = AudioCacheInfo.NIB;
        localObject1 = ((Bundle)localObject1).getParcelableArrayList(AudioCacheInfo.gHN());
        localObject2 = paramb.nKf;
        kotlin.g.b.s.checkNotNull(localObject2);
        localObject3 = AudioCacheInfo.NIB;
        i = ((Bundle)localObject2).getInt(AudioCacheInfo.gHM(), 0);
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
          getAddMusicPlugin().d(i, (ArrayList)localObject1);
        }
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_MEDIA_TYPE_INT", Integer.valueOf(2));
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Integer.valueOf(paramb.endTime));
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_EDIT_PUBLISHID_INT", Long.valueOf(System.currentTimeMillis()));
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.gJf().jjv = System.currentTimeMillis();
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.gJf();
      localObject2 = (Collection)paramb.nKc;
      if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
        break label786;
      }
      i = 1;
      label584:
      if (i != 0) {
        break label791;
      }
      l = 1L;
      label590:
      ((oo)localObject1).jjH = l;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.gJf().jjI = paramb.nKc.size();
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.gJg();
      localObject2 = (Collection)paramb.nKc;
      if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
        break label798;
      }
      i = 1;
      label651:
      if (i != 0) {
        break label803;
      }
      l = 1L;
      label657:
      ((oz)localObject1).jjH = l;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.gJg().jjI = paramb.nKc.size();
      if (!paramb.nJW) {
        break label810;
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.f.g.NRB;
      com.tencent.mm.plugin.recordvideo.f.g.aTj(paramb.nJU);
      localObject1 = com.tencent.mm.plugin.recordvideo.f.g.NRB;
      com.tencent.mm.plugin.recordvideo.f.g.aTk(paramb.nJX);
      label713:
      paramb = com.tencent.mm.plugin.recordvideo.f.g.NRB;
      com.tencent.mm.plugin.recordvideo.f.g.setConfigProvider(getConfigProvider());
      paramb = getCaptureInfo();
      kotlin.g.b.s.checkNotNull(paramb);
      if (!paramb.nJW)
      {
        paramb = getConfigProvider();
        if (paramb != null) {
          break label825;
        }
      }
    }
    label776:
    label786:
    label791:
    label798:
    label803:
    label810:
    label825:
    for (int i = 0;; i = paramb.scene)
    {
      if (i > 0)
      {
        paramb = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0));
      }
      AppMethodBeat.o(282072);
      return;
      localObject1 = ((RecordConfigProvider)localObject1).oXZ;
      break;
      i = 0;
      break label584;
      l = 2L;
      break label590;
      i = 0;
      break label651;
      l = 2L;
      break label657;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.g.NRB;
      com.tencent.mm.plugin.recordvideo.f.g.aTl(paramb.nJU);
      break label713;
    }
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(282102);
    kotlin.g.b.s.u(paramc, "status");
    boolean bool;
    label178:
    int j;
    label195:
    int k;
    label207:
    int m;
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
    case 1: 
      do
      {
        AppMethodBeat.o(282102);
        return;
      } while (paramBundle == null);
      bool = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
      paramBundle = this.UrI;
      paramc = paramBundle;
      if (paramBundle == null)
      {
        kotlin.g.b.s.bIx("previewNewPlugin");
        paramc = null;
      }
      paramc = paramc.UrD;
      if (paramc != null) {
        paramc.NX(bool);
      }
      AppMethodBeat.o(282102);
      return;
    case 2: 
      getVideoControlContainerPlugin().setVisibility(4);
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", false);
        paramc = this.UrI;
        if (paramc != null) {
          break label693;
        }
        kotlin.g.b.s.bIx("previewNewPlugin");
        paramc = null;
        paramc.NKN = true;
        paramBundle = paramc.gIE();
        if (paramBundle != null) {
          break label696;
        }
        j = 0;
        paramBundle = paramc.gIE();
        if (paramBundle != null) {
          break label705;
        }
        k = 0;
        m = com.tencent.mm.cd.a.fromDPToPix(paramc.context, 20) + com.tencent.mm.cd.a.fromDPToPix(paramc.context, 95) + com.tencent.mm.cd.a.fromDPToPix(paramc.context, 12);
        if (!bf.bg(paramc.context)) {
          break label2156;
        }
        m += bf.bk(paramc.context);
      }
      break;
    }
    label343:
    label354:
    label2156:
    for (;;)
    {
      int i = 0;
      if (bool)
      {
        i = com.tencent.mm.cd.a.fromDPToPix(paramc.context, 56) + 0;
        if (aw.bx(paramc.context))
        {
          Log.d("MicroMsg.EditVideoPreviewPlugin", "hasCutOut is true，videoViewTopMargin: " + i + ", cutout height is " + aw.bw(paramc.context));
          i += aw.bw(paramc.context);
        }
      }
      else
      {
        paramBundle = paramc.gIE();
        if (paramBundle != null) {
          break label726;
        }
        paramBundle = null;
        if (paramBundle != null) {
          break label737;
        }
        n = m + 0;
        label364:
        if (n >= com.tencent.mm.plugin.mmsight.d.iQ(paramc.context).y) {
          break label2143;
        }
      }
      for (int n = (int)((j - com.tencent.mm.cd.a.fromDPToPix(paramc.context, 32) * 2) / (j / k));; n = k - m - i)
      {
        int i1 = (int)(j / k * n);
        float f1 = i1 / j;
        float f2 = n / k;
        float f3 = -(Math.abs(m - i) / 2.0F);
        Log.i("MicroMsg.EditVideoPreviewPlugin", "scaleX: " + f1 + ", scaleY: " + f2 + ", translationY: " + f3);
        Log.i("MicroMsg.EditVideoPreviewPlugin", "isShowWeseeBtn: " + bool + ", videoViewWidth: " + j + ", videoViewHeight: " + k + ", videoViewBottomMargin:" + m + ", videoViewTopMargin:" + i + ", videoViewScaleHeight: " + n + ", videoViewScaleWidth: " + i1);
        paramBundle = paramc.gIE();
        if (paramBundle != null)
        {
          paramBundle = paramBundle.animate();
          if (paramBundle != null)
          {
            paramBundle = paramBundle.scaleX(f1);
            if (paramBundle != null)
            {
              paramBundle = paramBundle.scaleY(f2);
              if (paramBundle != null)
              {
                paramBundle = paramBundle.translationY(f3);
                if (paramBundle != null)
                {
                  paramBundle = paramBundle.setDuration(300L);
                  if (paramBundle != null) {
                    paramBundle.setListener((Animator.AnimatorListener)new c.b(paramc));
                  }
                }
              }
            }
          }
        }
        getItemContainerPlugin().gIs();
        paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ENTER_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(282102);
        return;
        break label178;
        j = paramBundle.getWidth();
        break label195;
        k = paramBundle.getHeight();
        break label207;
        Log.d("MicroMsg.EditVideoPreviewPlugin", "hasCutOut is false");
        break label343;
        paramBundle = Integer.valueOf(paramBundle.getBottom());
        break label354;
        n = paramBundle.intValue();
        break label364;
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_START_TIME_INT");
        j = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_END_TIME_INT");
        paramBundle = this.UrI;
        paramc = paramBundle;
        if (paramBundle == null)
        {
          kotlin.g.b.s.bIx("previewNewPlugin");
          paramc = null;
        }
        Log.i("MicroMsg.EditVideoPreviewPlugin", "setPlayRange >> start: " + i + ", end: " + j);
        paramc.startTime = i;
        paramc.endTime = j;
        paramc = paramc.UrD;
        if (paramc != null) {
          paramc.bs(i, j);
        }
        paramBundle = this.UrI;
        paramc = paramBundle;
        if (paramBundle == null)
        {
          kotlin.g.b.s.bIx("previewNewPlugin");
          paramc = null;
        }
        if (paramc.UrD != null)
        {
          paramBundle = paramc.UrD;
          kotlin.g.b.s.checkNotNull(paramBundle);
          if (!paramBundle.isPlaying())
          {
            paramBundle = paramc.UrD;
            kotlin.g.b.s.checkNotNull(paramBundle);
            paramBundle.resume();
          }
          paramc = paramc.UrD;
          kotlin.g.b.s.checkNotNull(paramc);
          paramc.seekTo(i);
        }
        AppMethodBeat.o(282102);
        return;
        paramBundle = this.UrI;
        paramc = paramBundle;
        if (paramBundle == null)
        {
          kotlin.g.b.s.bIx("previewNewPlugin");
          paramc = null;
        }
        paramc.hSS();
        AppMethodBeat.o(282102);
        return;
        paramBundle = this.UrI;
        paramc = paramBundle;
        if (paramBundle == null)
        {
          kotlin.g.b.s.bIx("previewNewPlugin");
          paramc = null;
        }
        paramc.onResume();
        AppMethodBeat.o(282102);
        return;
        AppMethodBeat.o(282102);
        return;
        paramc = getCaptureInfo();
        if (paramc == null) {
          break;
        }
        paramBundle = getConfigProvider();
        if (paramBundle == null) {
          i = 10000;
        }
        while (paramc.endTime - paramc.startTime > i + 250)
        {
          paramc = com.tencent.mm.plugin.recordvideo.f.g.NRB;
          com.tencent.mm.plugin.recordvideo.f.g.aQ(2, 3L);
          paramc = getContext();
          if (paramc == null)
          {
            paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(282102);
            throw paramc;
            i = paramBundle.NHZ;
          }
          else
          {
            ((Activity)paramc).setResult(3000);
            paramc = getContext();
            if (paramc == null)
            {
              paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(282102);
              throw paramc;
            }
            ((Activity)paramc).finish();
            AppMethodBeat.o(282102);
            return;
          }
        }
        getVideoControlContainerPlugin().setVisibility(0);
        paramBundle = this.UrI;
        paramc = paramBundle;
        if (paramBundle == null)
        {
          kotlin.g.b.s.bIx("previewNewPlugin");
          paramc = null;
        }
        paramc.AX(false);
        getItemContainerPlugin().gIt();
        paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(282102);
        return;
        getVideoControlContainerPlugin().setVisibility(0);
        getAddMusicPlugin().gIV();
        paramBundle = this.UrI;
        paramc = paramBundle;
        if (paramBundle == null)
        {
          kotlin.g.b.s.bIx("previewNewPlugin");
          paramc = null;
        }
        paramc.AX(true);
        getItemContainerPlugin().gIt();
        Object localObject1 = new StringBuilder("crop finish >> startTime: ");
        paramBundle = this.UrI;
        paramc = paramBundle;
        if (paramBundle == null)
        {
          kotlin.g.b.s.bIx("previewNewPlugin");
          paramc = null;
        }
        localObject1 = ((StringBuilder)localObject1).append(paramc.startTime).append(" >> endTime: ");
        paramBundle = this.UrI;
        paramc = paramBundle;
        if (paramBundle == null)
        {
          kotlin.g.b.s.bIx("previewNewPlugin");
          paramc = null;
        }
        Log.i("MicroMsg.EditorVideoCompositionPluginLayout", paramc.endTime);
        localObject1 = this.UrE;
        paramBundle = this.UrI;
        paramc = paramBundle;
        if (paramBundle == null)
        {
          kotlin.g.b.s.bIx("previewNewPlugin");
          paramc = null;
        }
        long l = paramc.startTime;
        paramBundle = this.UrI;
        paramc = paramBundle;
        if (paramBundle == null)
        {
          kotlin.g.b.s.bIx("previewNewPlugin");
          paramc = null;
        }
        ((d)localObject1).bB(l, paramc.endTime);
        paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(282102);
        return;
        paramc = this.UrE;
        if ((paramc.maxWidth == 0) || (paramc.maxHeight == 0)) {
          Log.e(paramc.TAG, "isNormalSizeValid maxWidth: " + paramc.maxWidth + ", maxHeight: " + paramc.maxHeight);
        }
        for (i = 0; i == 0; i = 1)
        {
          Log.e("MicroMsg.EditorVideoCompositionPluginLayout", "size is not valid,return this click");
          AppMethodBeat.o(282102);
          return;
        }
        localObject1 = getBgPlugin().gID();
        paramBundle = this.UrI;
        paramc = paramBundle;
        if (paramBundle == null)
        {
          kotlin.g.b.s.bIx("previewNewPlugin");
          paramc = null;
        }
        paramc.hSS();
        getItemContainerPlugin().onPause();
        getAddMusicPlugin().onPause();
        i = 0;
        if (getMoreMenuPlugin().NJY) {
          i = 1;
        }
        CaptureDataManager.NHH.rnY.putInt("key_extra_feature_flag", i);
        if (getMoreMenuPlugin().dbk == 2)
        {
          CaptureDataManager.NHH.rnY.putString("key_group_list", getMoreMenuPlugin().gIy());
          bool = getAddMusicPlugin().Gso.getMuteOrigin();
          Object localObject2 = getAddMusicPlugin().Gss;
          ArrayList localArrayList1 = com.tencent.mm.plugin.recordvideo.plugin.j.a(getItemContainerPlugin());
          ArrayList localArrayList2 = getItemContainerPlugin().getEditorDataList();
          float[] arrayOfFloat = getItemContainerPlugin().gIq();
          paramBundle = this.UrI;
          paramc = paramBundle;
          if (paramBundle == null)
          {
            kotlin.g.b.s.bIx("previewNewPlugin");
            paramc = null;
          }
          i = paramc.startTime;
          paramBundle = this.UrI;
          paramc = paramBundle;
          if (paramBundle == null)
          {
            kotlin.g.b.s.bIx("previewNewPlugin");
            paramc = null;
          }
          j = paramc.endTime;
          paramc = new ArrayList();
          getItemContainerPlugin();
          paramc = new com.tencent.mm.plugin.recordvideo.c.g(bool, (AudioCacheInfo)localObject2, localArrayList1, localArrayList2, arrayOfFloat, i, j, paramc, (String)localObject1, com.tencent.mm.plugin.recordvideo.plugin.j.gIr());
          Log.i("MicroMsg.EditorVideoCompositionPluginLayout", kotlin.g.b.s.X("edit config: ", paramc));
          paramBundle = com.tencent.mm.plugin.recordvideo.f.g.NRB;
          j = getItemContainerPlugin().gIu();
          k = getItemContainerPlugin().gIv();
          if (getAddMusicPlugin().Gss != null) {
            break label2116;
          }
          i = 0;
          com.tencent.mm.plugin.recordvideo.f.g.M(new int[] { j, k, i });
          paramBundle = this.UrJ;
          localObject1 = this.UrE;
          kotlin.g.b.s.u(paramc, "editConfig");
          kotlin.g.b.s.u(localObject1, "mediaModel");
          localObject2 = paramBundle.NLw;
          if (localObject2 != null) {
            ((cb)localObject2).a(null);
          }
          paramBundle.NLw = kotlinx.coroutines.j.a(paramBundle.scope, null, null, (m)new e.i(paramBundle, paramc, (d)localObject1, null), 3);
          paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().gIu()));
          paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().gIv()));
          paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          if (getAddMusicPlugin().Gss != null) {
            break label2122;
          }
          i = 0;
          com.tencent.mm.plugin.recordvideo.f.c.I("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
          paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          if (!getAddMusicPlugin().Gso.getMuteOrigin()) {
            break label2128;
          }
          i = 0;
          com.tencent.mm.plugin.recordvideo.f.c.I("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i));
          paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.I("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
          gIY();
          gIZ();
          paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.agH(13);
          paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.gJf().jjw = System.currentTimeMillis();
          paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          paramc = getConfigProvider();
          if (paramc != null) {
            break label2134;
          }
        }
        for (i = 0;; i = paramc.scene)
        {
          com.tencent.mm.plugin.recordvideo.f.c.agI(i);
          paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
          paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.gIh();
          if (paramc != null) {
            paramc.gId();
          }
          AppMethodBeat.o(282102);
          return;
          if (getMoreMenuPlugin().dbk != 3) {
            break;
          }
          CaptureDataManager.NHH.rnY.putString("key_black_list", getMoreMenuPlugin().gIy());
          break;
          i = 1;
          break label1801;
          i = 1;
          break label1953;
          i = 1;
          break label1984;
        }
      }
    }
  }
  
  public View getPlayerView()
  {
    AppMethodBeat.i(282056);
    Object localObject1 = getContext();
    kotlin.g.b.s.s(localObject1, "context");
    VideoCompositionPlayView localVideoCompositionPlayView = new VideoCompositionPlayView((Context)localObject1);
    Log.i("MicroMsg.EditorVideoCompositionPluginLayout", kotlin.g.b.s.X("videoPlayView :", localVideoCompositionPlayView));
    setPreviewPlugin(new u(null, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this, null));
    localObject1 = (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this;
    Object localObject2 = (TextView)findViewById(b.e.video_debug_info);
    Object localObject3 = getContext();
    kotlin.g.b.s.s(localObject3, "context");
    this.UrI = new c(localVideoCompositionPlayView, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)localObject1, (TextView)localObject2, (Context)localObject3);
    localObject3 = getPluginList();
    localObject2 = this.UrI;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("previewNewPlugin");
      localObject1 = null;
    }
    ((ArrayList)localObject3).add(localObject1);
    localObject1 = (View)localVideoCompositionPlayView;
    AppMethodBeat.o(282056);
    return localObject1;
  }
  
  public final boolean onBackPress()
  {
    long l = 1L;
    int k = 0;
    AppMethodBeat.i(282113);
    Object localObject1;
    int j;
    int i;
    Object localObject2;
    if (!super.onBackPress())
    {
      Log.i("MicroMsg.EditorVideoCompositionPluginLayout", "onBackPress");
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject1 = ((Iterable)getItemContainerPlugin().NJQ.getAllItemViews()).iterator();
      j = 0;
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.h)((Iterator)localObject1).next();
        if ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.f))
        {
          i += 1;
        }
        else if ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.s))
        {
          j += 1;
        }
        else if ((localObject2 instanceof q))
        {
          localObject2 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.gJg().jkY = 1L;
        }
        else if ((!(localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.n)) && ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.t)))
        {
          localObject2 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.gJg().jjK = 1L;
        }
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.gJg();
      if (!getMoreMenuPlugin().NJY) {
        break label355;
      }
    }
    for (;;)
    {
      ((oz)localObject1).jjG = l;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.gJg().jjx = i;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.gJg().jjy = j;
      localObject1 = getCaptureInfo();
      i = k;
      if (localObject1 != null)
      {
        i = k;
        if (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJW == true) {
          i = 1;
        }
      }
      if (i != 0) {
        com.tencent.threadpool.h.ahAA.bm(new EditorVideoCompositionPluginLayout..ExternalSyntheticLambda0(this));
      }
      localObject2 = this.UrI;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("previewNewPlugin");
        localObject1 = null;
      }
      localObject2 = ((c)localObject1).peV;
      if (localObject2 != null) {
        ((com.tencent.mm.compatible.util.b)localObject2).aPS();
      }
      localObject1 = ((c)localObject1).UrD;
      if (localObject1 != null) {
        ((VideoCompositionPlayView)localObject1).stop();
      }
      localObject1 = getNavigator();
      if (localObject1 != null) {
        a.a.a((com.tencent.mm.plugin.recordvideo.activity.a)localObject1);
      }
      AppMethodBeat.o(282113);
      return true;
      label355:
      l = 0L;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    long Yx;
    int label;
    
    c(EditorVideoCompositionPluginLayout paramEditorVideoCompositionPluginLayout, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(281961);
      paramObject = (kotlin.d.d)new c(this.UrK, paramd);
      AppMethodBeat.o(281961);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(281955);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      long l;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(281955);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        l = System.currentTimeMillis();
        Log.i("MicroMsg.EditorVideoCompositionPluginLayout", kotlin.g.b.s.X("setupMediaData start:", kotlin.d.b.a.b.BF(l)));
        paramObject = EditorVideoCompositionPluginLayout.b(this.UrK);
        kotlin.g.b.s.checkNotNull(paramObject);
        Object localObject1 = p.listOf(paramObject.bug());
        Object localObject2 = p.listOf(Integer.valueOf(2));
        final Integer[] arrayOfInteger = new Integer[1];
        int i = 0;
        if (i <= 0)
        {
          paramObject = EditorVideoCompositionPluginLayout.b(this.UrK);
          if ((paramObject != null) && (paramObject.nJW == true))
          {
            i = 1;
            if (i == 0) {
              break label163;
            }
          }
          for (i = 1;; i = 0)
          {
            arrayOfInteger[0] = Integer.valueOf(i);
            i = 1;
            break;
            i = 0;
            break label139;
          }
        }
        paramObject = (kotlin.d.f)bg.kCi();
        localObject1 = (m)new kotlin.d.b.a.k(this.UrK, (List)localObject1)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(282006);
            paramAnonymousObject = (kotlin.d.d)new 1(this.UrK, this.Ugz, this.UgA, arrayOfInteger, paramAnonymousd);
            AppMethodBeat.o(282006);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(281995);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(281995);
              throw paramAnonymousObject;
            case 0: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = EditorVideoCompositionPluginLayout.c(this.UrK);
              Object localObject = this.Ugz;
              List localList1 = this.UgA;
              List localList2 = kotlin.a.k.ae(arrayOfInteger);
              kotlin.d.d locald = (kotlin.d.d)this;
              this.label = 1;
              localObject = l.a((kotlin.d.f)bg.kCi(), (m)new d.c(paramAnonymousObject, (List)localObject, localList1, localList2, null), locald);
              paramAnonymousObject = localObject;
              if (localObject == locala)
              {
                AppMethodBeat.o(281995);
                return locala;
              }
              break;
            case 1: 
              ResultKt.throwOnFailure(paramAnonymousObject);
            }
            AppMethodBeat.o(281995);
            return paramAnonymousObject;
          }
        };
        localObject2 = (kotlin.d.d)this;
        this.Yx = l;
        this.label = 1;
        if (l.a(paramObject, (m)localObject1, (kotlin.d.d)localObject2) == locala)
        {
          AppMethodBeat.o(281955);
          return locala;
        }
        break;
      case 1: 
        label139:
        label163:
        l = this.Yx;
        ResultKt.throwOnFailure(paramObject);
      }
      for (;;)
      {
        EditorVideoCompositionPluginLayout.d(this.UrK);
        Log.i("MicroMsg.EditorVideoCompositionPluginLayout", kotlin.g.b.s.X("setupMediaData end cost:", kotlin.d.b.a.b.BF(System.currentTimeMillis() - l)));
        paramObject = ah.aiuX;
        AppMethodBeat.o(281955);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    d(EditorVideoCompositionPluginLayout paramEditorVideoCompositionPluginLayout, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(281960);
      paramObject = (kotlin.d.d)new d(this.UrK, paramd);
      AppMethodBeat.o(281960);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(281954);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(281954);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = EditorVideoCompositionPluginLayout.c(this.UrK);
        paramObject.TZS.clear();
        paramObject.TZS.addAll((Collection)paramObject.TZF);
        paramObject.TYA = new ac((List)paramObject.TZS);
        paramObject.TYA.wz(paramObject.Tzj);
        Object localObject1 = paramObject.TYA;
        Object localObject2 = com.tencent.mm.plugin.vlog.model.local.a.UbD;
        ((ac)localObject1).a(com.tencent.mm.plugin.vlog.model.local.a.hRu());
        paramObject.TYA.mu(paramObject.maxWidth, paramObject.maxHeight);
        paramObject = (kotlin.d.f)bg.kCh();
        localObject1 = (m)new kotlin.d.b.a.k(this.UrK, null)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(281895);
            paramAnonymousObject = (kotlin.d.d)new 1(this.UrK, paramAnonymousd);
            AppMethodBeat.o(281895);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(281891);
            Object localObject = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(281891);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            localObject = EditorVideoCompositionPluginLayout.e(this.UrK);
            paramAnonymousObject = localObject;
            if (localObject == null)
            {
              kotlin.g.b.s.bIx("previewNewPlugin");
              paramAnonymousObject = null;
            }
            localObject = EditorVideoCompositionPluginLayout.b(this.UrK);
            kotlin.g.b.s.checkNotNull(localObject);
            paramAnonymousObject.d((com.tencent.mm.media.widget.camerarecordview.b.b)localObject, EditorVideoCompositionPluginLayout.f(this.UrK));
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(281891);
            return paramAnonymousObject;
          }
        };
        localObject2 = (kotlin.d.d)this;
        this.label = 1;
        if (l.a(paramObject, (m)localObject1, (kotlin.d.d)localObject2) == locala)
        {
          AppMethodBeat.o(281954);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(281954);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.video.EditorVideoCompositionPluginLayout
 * JD-Core Version:    0.7.0.1
 */