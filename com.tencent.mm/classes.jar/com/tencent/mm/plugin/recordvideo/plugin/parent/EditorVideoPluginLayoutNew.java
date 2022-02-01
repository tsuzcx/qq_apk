package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.lo;
import com.tencent.mm.f.b.a.lz;
import com.tencent.mm.plugin.recordvideo.activity.a.a;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.e.e;
import com.tencent.mm.plugin.recordvideo.e.e.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.ac;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditorVideoPlayView;
import com.tencent.mm.plugin.recordvideo.plugin.j;
import com.tencent.mm.plugin.recordvideo.plugin.r;
import com.tencent.mm.plugin.recordvideo.plugin.t.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.f;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.q;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.s;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "createReportString", "", "city", "poiName", "getPlayerView", "Landroid/view/View;", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "", "prepareImageSizeReport", "prepareStoryBehaviorReport", "prepareStoryFailBehaviorReport", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public class EditorVideoPluginLayoutNew
  extends BaseEditVideoPluginLayout
  implements d
{
  public static final a HQY;
  
  static
  {
    AppMethodBeat.i(75779);
    HQY = new a((byte)0);
    AppMethodBeat.o(75779);
  }
  
  public EditorVideoPluginLayoutNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75778);
    AppMethodBeat.o(75778);
  }
  
  private final void fxm()
  {
    AppMethodBeat.i(75776);
    Object localObject1 = ((Iterable)getItemContainerPlugin().getEditorDataList()).iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)((Iterator)localObject1).next();
      Object localObject3 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).Ibt;
      switch (c.jLJ[localObject3.ordinal()])
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
        localObject2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).fyG();
        if (localObject2 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LocationItemData");
          AppMethodBeat.o(75776);
          throw ((Throwable)localObject1);
        }
        localObject2 = (csu)localObject2;
        localObject3 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        localObject3 = com.tencent.mm.plugin.recordvideo.d.c.fxq();
        String str1 = ((csu)localObject2).Icv;
        p.j(str1, "poiData.cityName");
        String str2 = ((csu)localObject2).poiName;
        p.j(str2, "poiData.poiName");
        StringBuilder localStringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty((CharSequence)str1)) {
          localStringBuilder.append(kotlin.n.n.l(str1, ",", " ", true));
        }
        if (!TextUtils.isEmpty((CharSequence)str2)) {
          if (((CharSequence)localStringBuilder).length() <= 0) {
            break label348;
          }
        }
        for (int k = 1;; k = 0)
        {
          if (k != 0) {
            localStringBuilder.append("|");
          }
          localStringBuilder.append(kotlin.n.n.l(str2, ",", " ", true));
          str1 = localStringBuilder.toString();
          p.j(str1, "reportPositionString.toString()");
          ((lo)localObject3).Cf(str1);
          localObject3 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          com.tencent.mm.plugin.recordvideo.d.c.fxq().Cg(String.valueOf(((csu)localObject2).latitude));
          localObject3 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          com.tencent.mm.plugin.recordvideo.d.c.fxq().Ch(String.valueOf(((csu)localObject2).longitude));
          break;
        }
      case 4: 
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.fxq().amH();
        break;
      case 5: 
        label348:
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.fxq().amI();
      }
    }
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
    com.tencent.mm.plugin.recordvideo.d.c.fxq().vD(i);
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
    com.tencent.mm.plugin.recordvideo.d.c.fxq().vE(j);
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.fxq();
    if (getMoreMenuPlugin().HNb) {}
    for (long l = 1L;; l = 0L)
    {
      ((lo)localObject1).vJ(l);
      AppMethodBeat.o(75776);
      return;
    }
  }
  
  private final void fxn()
  {
    AppMethodBeat.i(75777);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = getCaptureInfo();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).lfr;
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
      localObject = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.fxq().Cj(localStringBuilder.substring(0, i).toString());
    }
    AppMethodBeat.o(75777);
  }
  
  public void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    long l2 = 1L;
    Object localObject2 = null;
    AppMethodBeat.i(75773);
    Log.i("MicroMsg.EditorVideoPluginLayoutNew", "loadCurrentPage info ".concat(String.valueOf(paramb)));
    super.a(paramb);
    label386:
    label426:
    label955:
    label962:
    label1220:
    if (paramb != null)
    {
      Object localObject1 = com.tencent.mm.plugin.recordvideo.e.c.IeQ;
      com.tencent.mm.plugin.recordvideo.e.c.acK(0);
      if (paramb.aZg())
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.e.c.IeQ;
        com.tencent.mm.plugin.recordvideo.e.c.acK(com.tencent.mm.plugin.recordvideo.e.c.fzs() + 1);
      }
      if (paramb.aZf())
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.e.c.IeQ;
        com.tencent.mm.plugin.recordvideo.e.c.acK(com.tencent.mm.plugin.recordvideo.e.c.fzs() + 1);
      }
      long l1 = Util.currentTicks();
      localObject1 = getBgPlugin();
      Object localObject3 = getCaptureInfo();
      if (localObject3 == null) {
        p.iCn();
      }
      ((r)localObject1).a((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3, getConfigProvider());
      localObject3 = getPreviewPlugin();
      com.tencent.mm.media.widget.camerarecordview.b.b localb = getCaptureInfo();
      if (localb == null) {
        p.iCn();
      }
      RecordConfigProvider localRecordConfigProvider = getConfigProvider();
      p.k(localb, "info");
      Log.i("MicroMsg.EditVideoPlayPlugin", "start preview ".concat(String.valueOf(localb)));
      ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject3).HNh = localb;
      if (localRecordConfigProvider != null)
      {
        i = localRecordConfigProvider.HLb;
        ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject3).HNQ = i;
        localObject1 = ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject3).Fdy;
        if (localObject1 == null) {
          break label1096;
        }
        localObject1 = ((VideoPlayerTextureView)localObject1).getContext();
        label215:
        ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject3).mlj = new com.tencent.mm.compatible.util.b((Context)localObject1);
        localObject1 = ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject3).mlj;
        if (localObject1 != null) {
          ((com.tencent.mm.compatible.util.b)localObject1).avy();
        }
        localObject1 = ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject3).Fdy;
        if (localObject1 != null) {
          ((VideoPlayerTextureView)localObject1).setVisibility(0);
        }
        localObject1 = ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject3).Fdy;
        if (localObject1 != null) {
          ((VideoPlayerTextureView)localObject1).setAlpha(0.0F);
        }
        localObject1 = ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject3).Fdy;
        if (localObject1 != null) {
          ((VideoPlayerTextureView)localObject1).setVideoPath(localb.aZh());
        }
        localObject1 = localObject2;
        if (localRecordConfigProvider != null) {
          localObject1 = localRecordConfigProvider.HKW;
        }
        if (p.h(localObject1, Boolean.TRUE))
        {
          localObject1 = e.Ife;
          localObject1 = e.aWt(localb.aZh());
          if (localObject1 != null)
          {
            if ((((e.a)localObject1).fSM != 0) && (((e.a)localObject1).fSM != 180)) {
              break label1107;
            }
            if (((e.a)localObject1).width <= ((e.a)localObject1).height) {
              break label1102;
            }
            i = 1;
            if ((localRecordConfigProvider != null) && (localRecordConfigProvider.HKU != i.e.RcE)) {
              break label1171;
            }
            if (i == 0) {
              break label1130;
            }
            localObject1 = ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject3).Fdy;
            if (localObject1 != null) {
              ((VideoPlayerTextureView)localObject1).setScaleType(i.e.RcE);
            }
            ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject3).Awa = true;
          }
        }
        localObject1 = ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject3).Fdy;
        if (localObject1 != null) {
          ((VideoPlayerTextureView)localObject1).setVideoCallback((k.a)((com.tencent.mm.plugin.recordvideo.plugin.t)localObject3).HNU);
        }
        ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject3).fod = localb.fod;
        ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject3).endTime = localb.endTime;
        localObject1 = ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject3).HNV;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        localObject1 = ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject3).HNV;
        if ((localObject1 != null) && (WeChatEnvironment.hasDebugger())) {
          com.tencent.mm.plugin.mmsight.model.i.am((Runnable)new t.c((TextView)localObject1, (com.tencent.mm.plugin.recordvideo.plugin.t)localObject3));
        }
        Log.d("MicroMsg.EditorVideoPluginLayoutNew", "previewPlugin " + Util.ticksToNow(l1));
        localObject1 = getReMuxPlugin();
        localObject2 = getConfigProvider();
        if (localObject2 == null) {
          p.iCn();
        }
        ((ac)localObject1).b(paramb, (RecordConfigProvider)localObject2);
        Log.d("MicroMsg.EditorVideoPluginLayoutNew", "reMuxPlugin " + Util.ticksToNow(l1));
        localObject1 = getCropVideoPlugin();
        localObject2 = getCaptureInfo();
        if (localObject2 == null) {
          p.iCn();
        }
        localObject3 = getConfigProvider();
        if (localObject3 == null) {
          p.iCn();
        }
        ((com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a)localObject1).b((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2, (RecordConfigProvider)localObject3);
        Log.d("MicroMsg.EditorVideoPluginLayoutNew", "cropVideoPlugin " + Util.ticksToNow(l1));
        if (paramb.lfu != null)
        {
          localObject1 = paramb.lfu;
          if (localObject1 == null) {
            p.iCn();
          }
          localObject2 = AudioCacheInfo.HMa;
          localObject1 = ((Bundle)localObject1).getParcelableArrayList(AudioCacheInfo.fwe());
          localObject2 = paramb.lfu;
          if (localObject2 == null) {
            p.iCn();
          }
          localObject3 = AudioCacheInfo.HMa;
          i = ((Bundle)localObject2).getInt(AudioCacheInfo.fwd(), 0);
          if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
            getAddMusicPlugin().d(i, (ArrayList)localObject1);
          }
        }
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_MEDIA_TYPE_INT", Integer.valueOf(2));
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Integer.valueOf(paramb.endTime));
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_EDIT_PUBLISHID_INT", Long.valueOf(System.currentTimeMillis()));
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.fxq().vz(System.currentTimeMillis());
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.fxq();
        localObject2 = (Collection)paramb.lfr;
        if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
          break label1196;
        }
        i = 1;
        label886:
        if (i != 0) {
          break label1201;
        }
        l1 = 1L;
        label892:
        ((lo)localObject1).vK(l1);
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.fxq().vL(paramb.lfr.size());
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.fxr();
        localObject2 = (Collection)paramb.lfr;
        if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
          break label1208;
        }
        i = 1;
        if (i != 0) {
          break label1213;
        }
        l1 = l2;
        ((lz)localObject1).wL(l1);
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.fxr().wM(paramb.lfr.size());
        if (!paramb.lfl) {
          break label1220;
        }
        localObject1 = com.tencent.mm.plugin.recordvideo.d.g.HUM;
        com.tencent.mm.plugin.recordvideo.d.g.aWb(paramb.lfj);
        localObject1 = com.tencent.mm.plugin.recordvideo.d.g.HUM;
        com.tencent.mm.plugin.recordvideo.d.g.aWc(paramb.lfm);
        label1020:
        paramb = com.tencent.mm.plugin.recordvideo.d.g.HUM;
        com.tencent.mm.plugin.recordvideo.d.g.setConfigProvider(getConfigProvider());
        paramb = getCaptureInfo();
        if (paramb == null) {
          p.iCn();
        }
        if (!paramb.lfl)
        {
          paramb = getConfigProvider();
          if (paramb == null) {
            break label1235;
          }
        }
      }
      label1096:
      label1102:
      label1235:
      for (int i = paramb.scene;; i = 0)
      {
        if (i > 0)
        {
          paramb = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          com.tencent.mm.plugin.recordvideo.d.c.w("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0));
        }
        AppMethodBeat.o(75773);
        return;
        i = 10000;
        break;
        localObject1 = null;
        break label215;
        i = 0;
        break label386;
        label1107:
        if (((e.a)localObject1).height > ((e.a)localObject1).width)
        {
          i = 1;
          break label386;
        }
        i = 0;
        break label386;
        label1130:
        localObject1 = ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject3).Fdy;
        if (localObject1 != null) {
          ((VideoPlayerTextureView)localObject1).setForceScaleFullScreen(true);
        }
        localObject1 = ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject3).Fdy;
        if (localObject1 == null) {
          break label426;
        }
        ((VideoPlayerTextureView)localObject1).setScaleType(i.e.RcH);
        break label426;
        localObject1 = ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject3).Fdy;
        if (localObject1 == null) {
          break label426;
        }
        ((VideoPlayerTextureView)localObject1).setScaleType(localRecordConfigProvider.HKU);
        break label426;
        i = 0;
        break label886;
        l1 = 2L;
        break label892;
        i = 0;
        break label955;
        l1 = 2L;
        break label962;
        localObject1 = com.tencent.mm.plugin.recordvideo.d.g.HUM;
        com.tencent.mm.plugin.recordvideo.d.g.aWd(paramb.lfj);
        break label1020;
      }
    }
    label1171:
    label1196:
    label1201:
    label1208:
    label1213:
    AppMethodBeat.o(75773);
  }
  
  public void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(75774);
    p.k(paramc, "status");
    if (paramc != d.c.HSe) {
      Log.i("MicroMsg.EditorVideoPluginLayoutNew", "statusChange " + paramc + " ,param : " + paramBundle);
    }
    switch (c.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      if (paramc != d.c.HSe) {
        Log.e("MicroMsg.EditorVideoPluginLayoutNew", "unknown status ".concat(String.valueOf(paramc)));
      }
      super.a(paramc, paramBundle);
      AppMethodBeat.o(75774);
      return;
    }
    paramc = getBgPlugin().fwV();
    getPreviewPlugin().release();
    getItemContainerPlugin().onPause();
    getAddMusicPlugin().onPause();
    int i = 0;
    if (getMoreMenuPlugin().HNb) {
      i = 1;
    }
    paramBundle = CaptureDataManager.HKJ;
    p.j(paramBundle, "CaptureDataManager.INSTANCE");
    paramBundle.getExtData().putInt("key_extra_feature_flag", i);
    if (getMoreMenuPlugin().bhr == 2)
    {
      paramBundle = CaptureDataManager.HKJ;
      p.j(paramBundle, "CaptureDataManager.INSTANCE");
      paramBundle.getExtData().putString("key_group_list", getMoreMenuPlugin().fwQ());
      boolean bool = getAddMusicPlugin().AQb.getMuteOrigin();
      paramBundle = getAddMusicPlugin().AQf;
      ArrayList localArrayList1 = com.tencent.mm.plugin.recordvideo.plugin.i.a(getItemContainerPlugin());
      ArrayList localArrayList2 = getItemContainerPlugin().getEditorDataList();
      float[] arrayOfFloat = getItemContainerPlugin().fwI();
      i = getPreviewPlugin().fod;
      int j = getPreviewPlugin().endTime;
      ArrayList localArrayList3 = new ArrayList();
      getItemContainerPlugin();
      paramc = new com.tencent.mm.plugin.recordvideo.b.g(bool, paramBundle, localArrayList1, localArrayList2, arrayOfFloat, i, j, localArrayList3, paramc, com.tencent.mm.plugin.recordvideo.plugin.i.fwJ());
      Log.i("MicroMsg.EditorVideoPluginLayoutNew", "edit config: ".concat(String.valueOf(paramc)));
      paramBundle = com.tencent.mm.plugin.recordvideo.d.g.HUM;
      j = getItemContainerPlugin().fwM();
      int k = getItemContainerPlugin().fwN();
      if (getAddMusicPlugin().AQf != null) {
        break label629;
      }
      i = 0;
      label374:
      com.tencent.mm.plugin.recordvideo.d.g.I(new int[] { j, k, i });
      getReMuxPlugin().a(paramc);
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().fwM()));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().fwN()));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      if (getAddMusicPlugin().AQf != null) {
        break label634;
      }
      i = 0;
      label458:
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      if (!getAddMusicPlugin().AQb.getMuteOrigin()) {
        break label639;
      }
      i = 0;
      label487:
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      fxm();
      fxn();
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.acr(13);
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.fxq().vA(System.currentTimeMillis());
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      paramc = getConfigProvider();
      if (paramc == null) {
        break label644;
      }
    }
    label644:
    for (i = paramc.scene;; i = 0)
    {
      com.tencent.mm.plugin.recordvideo.d.c.acs(i);
      paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.HMp;
      paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.fwy();
      if (paramc == null) {
        break label649;
      }
      paramc.fwu();
      AppMethodBeat.o(75774);
      return;
      if (getMoreMenuPlugin().bhr != 3) {
        break;
      }
      paramBundle = CaptureDataManager.HKJ;
      p.j(paramBundle, "CaptureDataManager.INSTANCE");
      paramBundle.getExtData().putString("key_black_list", getMoreMenuPlugin().fwQ());
      break;
      label629:
      i = 1;
      break label374;
      label634:
      i = 1;
      break label458;
      label639:
      i = 1;
      break label487;
    }
    label649:
    AppMethodBeat.o(75774);
  }
  
  public View getPlayerView()
  {
    AppMethodBeat.i(75772);
    Object localObject = new EditorVideoPlayView(getContext());
    Log.i("MicroMsg.EditorVideoPluginLayoutNew", "playerView :".concat(String.valueOf(localObject)));
    setPreviewPlugin(new com.tencent.mm.plugin.recordvideo.plugin.t((VideoPlayerTextureView)localObject, (d)this, (TextView)findViewById(b.e.video_debug_info)));
    getPluginList().add(getPreviewPlugin());
    localObject = (View)localObject;
    AppMethodBeat.o(75772);
    return localObject;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75775);
    Object localObject1;
    int j;
    int i;
    if (!super.onBackPress())
    {
      Log.i("MicroMsg.EditorVideoPluginLayoutNew", "onBackPress");
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject1 = ((Iterable)getItemContainerPlugin().HMV.getAllItemViews()).iterator();
      j = 0;
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.h)((Iterator)localObject1).next();
        if ((localObject2 instanceof f))
        {
          i += 1;
        }
        else if ((localObject2 instanceof s))
        {
          j += 1;
        }
        else if ((localObject2 instanceof q))
        {
          localObject2 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          com.tencent.mm.plugin.recordvideo.d.c.fxr().ank();
        }
        else if ((!(localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.n)) && ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.t)))
        {
          localObject2 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          com.tencent.mm.plugin.recordvideo.d.c.fxr().anm();
        }
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.fxr();
      if (!getMoreMenuPlugin().HNb) {
        break label295;
      }
    }
    label295:
    for (long l = 1L;; l = 0L)
    {
      ((lz)localObject1).wK(l);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.fxr().wH(i);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.fxr().wI(j);
      localObject1 = getCaptureInfo();
      if ((localObject1 != null) && (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).lfl == true)) {
        com.tencent.e.h.ZvG.be((Runnable)new b(this));
      }
      getPreviewPlugin().reset();
      localObject1 = getNavigator();
      if (localObject1 != null) {
        a.a.a((com.tencent.mm.plugin.recordvideo.activity.a)localObject1);
      }
      AppMethodBeat.o(75775);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(EditorVideoPluginLayoutNew paramEditorVideoPluginLayoutNew) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(169939);
      Object localObject1 = this.HQZ.getCaptureInfo();
      if (localObject1 != null) {}
      for (localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).lfm;; localObject1 = null)
      {
        u.deleteFile((String)localObject1);
        com.tencent.mm.media.widget.camerarecordview.b.b localb = this.HQZ.getCaptureInfo();
        localObject1 = localObject2;
        if (localb != null) {
          localObject1 = localb.lfj;
        }
        u.deleteFile((String)localObject1);
        AppMethodBeat.o(169939);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew
 * JD-Core Version:    0.7.0.1
 */