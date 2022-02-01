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
import com.tencent.mm.autogen.mmdata.rpt.oo;
import com.tencent.mm.autogen.mmdata.rpt.oz;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.comm.b.e;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.recordvideo.activity.a.a;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.ae;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditorVideoPlayView;
import com.tencent.mm.plugin.recordvideo.plugin.j;
import com.tencent.mm.plugin.recordvideo.plugin.k;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.f;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.q;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.t;
import com.tencent.mm.plugin.recordvideo.util.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.protobuf.djw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "createReportString", "", "city", "poiName", "getPlayerView", "Landroid/view/View;", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "", "onDetach", "prepareImageSizeReport", "prepareStoryBehaviorReport", "prepareStoryFailBehaviorReport", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public class EditorVideoPluginLayoutNew
  extends BaseEditVideoPluginLayout
  implements a
{
  public static final EditorVideoPluginLayoutNew.a NNF;
  
  static
  {
    AppMethodBeat.i(75779);
    NNF = new EditorVideoPluginLayoutNew.a((byte)0);
    AppMethodBeat.o(75779);
  }
  
  public EditorVideoPluginLayoutNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75778);
    AppMethodBeat.o(75778);
  }
  
  private static final void a(EditorVideoPluginLayoutNew paramEditorVideoPluginLayoutNew)
  {
    Object localObject2 = null;
    AppMethodBeat.i(281141);
    kotlin.g.b.s.u(paramEditorVideoPluginLayoutNew, "this$0");
    Object localObject1 = paramEditorVideoPluginLayoutNew.getCaptureInfo();
    if (localObject1 == null)
    {
      localObject1 = null;
      y.deleteFile((String)localObject1);
      paramEditorVideoPluginLayoutNew = paramEditorVideoPluginLayoutNew.getCaptureInfo();
      if (paramEditorVideoPluginLayoutNew != null) {
        break label59;
      }
    }
    label59:
    for (paramEditorVideoPluginLayoutNew = localObject2;; paramEditorVideoPluginLayoutNew = paramEditorVideoPluginLayoutNew.nJU)
    {
      y.deleteFile(paramEditorVideoPluginLayoutNew);
      AppMethodBeat.o(281141);
      return;
      localObject1 = ((b)localObject1).nJX;
      break;
    }
  }
  
  private final void gIY()
  {
    AppMethodBeat.i(75776);
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
            break label320;
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
        label320:
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
      AppMethodBeat.o(75776);
      return;
    }
  }
  
  private final void gIZ()
  {
    AppMethodBeat.i(75777);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = getCaptureInfo();
    if (localObject != null)
    {
      localObject = ((b)localObject).nKc;
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
    AppMethodBeat.o(75777);
  }
  
  public void a(b paramb)
  {
    long l2 = 1L;
    AppMethodBeat.i(75773);
    Log.i("MicroMsg.EditorVideoPluginLayoutNew", kotlin.g.b.s.X("loadCurrentPage info ", paramb));
    super.a(paramb);
    Object localObject1;
    long l1;
    if (paramb != null)
    {
      localObject1 = d.Obm;
      d.ahc(0);
      if (paramb.buf())
      {
        localObject1 = d.Obm;
        d.ahc(d.gLe() + 1);
      }
      if (paramb.bue())
      {
        localObject1 = d.Obm;
        d.ahc(d.gLe() + 1);
      }
      l1 = Util.currentTicks();
      localObject1 = getBgPlugin();
      Object localObject2 = getCaptureInfo();
      kotlin.g.b.s.checkNotNull(localObject2);
      ((com.tencent.mm.plugin.recordvideo.plugin.s)localObject1).a((b)localObject2, getConfigProvider());
      localObject1 = getPreviewPlugin();
      localObject2 = getCaptureInfo();
      kotlin.g.b.s.checkNotNull(localObject2);
      ((u)localObject1).b((b)localObject2, getConfigProvider());
      Log.d("MicroMsg.EditorVideoPluginLayoutNew", kotlin.g.b.s.X("previewPlugin ", Long.valueOf(Util.ticksToNow(l1))));
      localObject1 = getReMuxPlugin();
      localObject2 = getConfigProvider();
      kotlin.g.b.s.checkNotNull(localObject2);
      ((ae)localObject1).c(paramb, (RecordConfigProvider)localObject2);
      Log.d("MicroMsg.EditorVideoPluginLayoutNew", kotlin.g.b.s.X("reMuxPlugin ", Long.valueOf(Util.ticksToNow(l1))));
      localObject1 = getCropVideoPlugin();
      localObject2 = getCaptureInfo();
      kotlin.g.b.s.checkNotNull(localObject2);
      Object localObject3 = getConfigProvider();
      kotlin.g.b.s.checkNotNull(localObject3);
      ((com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a)localObject1).c((b)localObject2, (RecordConfigProvider)localObject3);
      Log.d("MicroMsg.EditorVideoPluginLayoutNew", kotlin.g.b.s.X("cropVideoPlugin ", Long.valueOf(Util.ticksToNow(l1))));
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
        break label651;
      }
      i = 1;
      if (i != 0) {
        break label656;
      }
      l1 = 1L;
      label464:
      ((oo)localObject1).jjH = l1;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.gJf().jjI = paramb.nKc.size();
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.gJg();
      localObject2 = (Collection)paramb.nKc;
      if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
        break label663;
      }
      i = 1;
      label525:
      if (i != 0) {
        break label668;
      }
      l1 = l2;
      label532:
      ((oz)localObject1).jjH = l1;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.gJg().jjI = paramb.nKc.size();
      if (!paramb.nJW) {
        break label675;
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.f.g.NRB;
      com.tencent.mm.plugin.recordvideo.f.g.aTj(paramb.nJU);
      localObject1 = com.tencent.mm.plugin.recordvideo.f.g.NRB;
      com.tencent.mm.plugin.recordvideo.f.g.aTk(paramb.nJX);
      label588:
      paramb = com.tencent.mm.plugin.recordvideo.f.g.NRB;
      com.tencent.mm.plugin.recordvideo.f.g.setConfigProvider(getConfigProvider());
      paramb = getCaptureInfo();
      kotlin.g.b.s.checkNotNull(paramb);
      if (!paramb.nJW)
      {
        paramb = getConfigProvider();
        if (paramb != null) {
          break label690;
        }
      }
    }
    label651:
    label656:
    label663:
    label668:
    label675:
    label690:
    for (int i = 0;; i = paramb.scene)
    {
      if (i > 0)
      {
        paramb = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0));
      }
      AppMethodBeat.o(75773);
      return;
      i = 0;
      break;
      l1 = 2L;
      break label464;
      i = 0;
      break label525;
      l1 = 2L;
      break label532;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.g.NRB;
      com.tencent.mm.plugin.recordvideo.f.g.aTl(paramb.nJU);
      break label588;
    }
  }
  
  public void a(a.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(75774);
    kotlin.g.b.s.u(paramc, "status");
    if (paramc != a.c.NOK) {
      Log.i("MicroMsg.EditorVideoPluginLayoutNew", "statusChange " + paramc + " ,param : " + paramBundle);
    }
    if (b.$EnumSwitchMapping$0[paramc.ordinal()] == 1)
    {
      paramc = getBgPlugin().gID();
      getPreviewPlugin().release();
      getItemContainerPlugin().onPause();
      getAddMusicPlugin().onPause();
      int i = 0;
      if (getMoreMenuPlugin().NJY) {
        i = 1;
      }
      CaptureDataManager.NHH.rnY.putInt("key_extra_feature_flag", i);
      if (getMoreMenuPlugin().dbk == 2)
      {
        CaptureDataManager.NHH.rnY.putString("key_group_list", getMoreMenuPlugin().gIy());
        boolean bool = getAddMusicPlugin().Gso.getMuteOrigin();
        paramBundle = getAddMusicPlugin().Gss;
        ArrayList localArrayList1 = j.a(getItemContainerPlugin());
        ArrayList localArrayList2 = getItemContainerPlugin().getEditorDataList();
        float[] arrayOfFloat = getItemContainerPlugin().gIq();
        i = getPreviewPlugin().startTime;
        int j = getPreviewPlugin().endTime;
        ArrayList localArrayList3 = new ArrayList();
        getItemContainerPlugin();
        paramc = new com.tencent.mm.plugin.recordvideo.c.g(bool, paramBundle, localArrayList1, localArrayList2, arrayOfFloat, i, j, localArrayList3, paramc, j.gIr());
        Log.i("MicroMsg.EditorVideoPluginLayoutNew", kotlin.g.b.s.X("edit config: ", paramc));
        paramBundle = com.tencent.mm.plugin.recordvideo.f.g.NRB;
        j = getItemContainerPlugin().gIu();
        int k = getItemContainerPlugin().gIv();
        if (getAddMusicPlugin().Gss != null) {
          break label544;
        }
        i = 0;
        label302:
        com.tencent.mm.plugin.recordvideo.f.g.M(new int[] { j, k, i });
        getReMuxPlugin().a(paramc);
        paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().gIu()));
        paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().gIv()));
        paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        if (getAddMusicPlugin().Gss != null) {
          break label549;
        }
        i = 0;
        label386:
        com.tencent.mm.plugin.recordvideo.f.c.I("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
        paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        if (!getAddMusicPlugin().Gso.getMuteOrigin()) {
          break label554;
        }
        i = 0;
        label415:
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
          break label559;
        }
      }
      label544:
      label549:
      label554:
      label559:
      for (i = 0;; i = paramc.scene)
      {
        com.tencent.mm.plugin.recordvideo.f.c.agI(i);
        paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
        paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.gIh();
        if (paramc != null) {
          paramc.gId();
        }
        AppMethodBeat.o(75774);
        return;
        if (getMoreMenuPlugin().dbk != 3) {
          break;
        }
        CaptureDataManager.NHH.rnY.putString("key_black_list", getMoreMenuPlugin().gIy());
        break;
        i = 1;
        break label302;
        i = 1;
        break label386;
        i = 1;
        break label415;
      }
    }
    if (paramc != a.c.NOK) {
      Log.e("MicroMsg.EditorVideoPluginLayoutNew", kotlin.g.b.s.X("unknown status ", paramc));
    }
    super.a(paramc, paramBundle);
    AppMethodBeat.o(75774);
  }
  
  public View getPlayerView()
  {
    AppMethodBeat.i(75772);
    Object localObject = new EditorVideoPlayView(getContext());
    Log.i("MicroMsg.EditorVideoPluginLayoutNew", kotlin.g.b.s.X("playerView :", localObject));
    setPreviewPlugin(new u((VideoPlayerTextureView)localObject, (a)this, (TextView)findViewById(b.e.video_debug_info)));
    getPluginList().add(getPreviewPlugin());
    localObject = (View)localObject;
    AppMethodBeat.o(75772);
    return localObject;
  }
  
  public final boolean onBackPress()
  {
    long l = 1L;
    int k = 0;
    AppMethodBeat.i(75775);
    Object localObject1;
    int j;
    int i;
    if (!super.onBackPress())
    {
      Log.i("MicroMsg.EditorVideoPluginLayoutNew", "onBackPress");
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject1 = ((Iterable)getItemContainerPlugin().NJQ.getAllItemViews()).iterator();
      j = 0;
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.h)((Iterator)localObject1).next();
        if ((localObject2 instanceof f))
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
        else if ((!(localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.n)) && ((localObject2 instanceof t)))
        {
          localObject2 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.gJg().jjK = 1L;
        }
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.gJg();
      if (!getMoreMenuPlugin().NJY) {
        break label303;
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
        if (((b)localObject1).nJW == true) {
          i = 1;
        }
      }
      if (i != 0) {
        com.tencent.threadpool.h.ahAA.bm(new EditorVideoPluginLayoutNew..ExternalSyntheticLambda0(this));
      }
      getPreviewPlugin().reset();
      localObject1 = getNavigator();
      if (localObject1 != null) {
        a.a.a((com.tencent.mm.plugin.recordvideo.activity.a)localObject1);
      }
      AppMethodBeat.o(75775);
      return true;
      label303:
      l = 0L;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(281167);
    super.onDetach();
    com.tencent.mm.plugin.recordvideo.f.c localc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.bu("MEDIA_EDIT_PAGE_STAYTIME_LONG", getBrowserTimeMs());
    e.xfd.a("SnsPublishProcess", "mediaEditPageStaytime_", Long.valueOf(getBrowserTimeMs()), com.tencent.mm.plugin.comm.b.c.xeT);
    AppMethodBeat.o(281167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew
 * JD-Core Version:    0.7.0.1
 */