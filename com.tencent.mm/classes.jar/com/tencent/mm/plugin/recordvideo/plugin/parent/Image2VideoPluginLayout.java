package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.oo;
import com.tencent.mm.autogen.mmdata.rpt.oz;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.activity.a.a;
import com.tencent.mm.plugin.recordvideo.c.g;
import com.tencent.mm.plugin.recordvideo.f.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.ae;
import com.tencent.mm.plugin.recordvideo.plugin.j;
import com.tencent.mm.plugin.recordvideo.plugin.k;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView;
import com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.f;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.h;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.t;
import com.tencent.mm.protocal.protobuf.djw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/Image2VideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "photoToViewPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin;", "createReportString", "", "city", "poiName", "getPlayerView", "Landroid/view/View;", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "", "prepareImageSizeReport", "prepareStoryBehaviorReport", "prepareStoryFailBehaviorReport", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class Image2VideoPluginLayout
  extends BaseEditVideoPluginLayout
  implements a
{
  public static final Image2VideoPluginLayout.a NQx;
  private com.tencent.mm.plugin.recordvideo.plugin.q NQy;
  
  static
  {
    AppMethodBeat.i(75793);
    NQx = new Image2VideoPluginLayout.a((byte)0);
    AppMethodBeat.o(75793);
  }
  
  public Image2VideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75792);
    AppMethodBeat.o(75792);
  }
  
  private final void gIY()
  {
    AppMethodBeat.i(75790);
    Object localObject1 = ((Iterable)getItemContainerPlugin().getEditorDataList()).iterator();
    int j = 0;
    int i = 0;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)((Iterator)localObject1).next();
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
        localObject3 = c.NRf;
        localObject3 = c.gJf();
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
          localObject3 = c.NRf;
          c.gJf().wp(String.valueOf(((djw)localObject2).latitude));
          localObject3 = c.NRf;
          c.gJf().wq(String.valueOf(((djw)localObject2).longitude));
          break;
        }
      case 4: 
        localObject2 = c.NRf;
        c.gJf().jjJ = 1L;
        break;
      case 5: 
        label320:
        localObject2 = c.NRf;
        c.gJf().jjK = 1L;
      }
    }
    localObject1 = c.NRf;
    c.gJf().jjx = i;
    localObject1 = c.NRf;
    c.gJf().jjy = j;
    localObject1 = c.NRf;
    localObject1 = c.gJf();
    if (getMoreMenuPlugin().NJY)
    {
      l = 1L;
      ((oo)localObject1).jjG = l;
      localObject1 = c.NRf;
      localObject1 = c.gJf();
      localObject2 = getAddMusicPlugin().Gss;
      if (localObject2 == null) {
        break label481;
      }
      i = ((AudioCacheInfo)localObject2).source;
      localObject2 = AudioCacheInfo.NIB;
      if (i != AudioCacheInfo.gHY()) {
        break label481;
      }
      i = 1;
      label455:
      if (i == 0) {
        break label486;
      }
    }
    label481:
    label486:
    for (long l = 1L;; l = 0L)
    {
      ((oo)localObject1).itK = l;
      AppMethodBeat.o(75790);
      return;
      l = 0L;
      break;
      i = 0;
      break label455;
    }
  }
  
  private final void gIZ()
  {
    AppMethodBeat.i(75791);
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
      localObject = c.NRf;
      c.gJf().wr(localStringBuilder.substring(0, i).toString());
    }
    AppMethodBeat.o(75791);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(75787);
    super.a(paramb);
    Log.i("MicroMsg.Image2VideoPluginLayout", kotlin.g.b.s.X("loadCurrentPage info ", paramb));
    if (paramb != null)
    {
      Object localObject = this.NQy;
      if (localObject != null)
      {
        kotlin.g.b.s.u(paramb, "info");
        Log.i("MicroMsg.EditPhotoToVideoPlugin", kotlin.g.b.s.X("start preview ", paramb));
        ((com.tencent.mm.plugin.recordvideo.plugin.q)localObject).NKf = paramb;
        ((com.tencent.mm.plugin.recordvideo.plugin.q)localObject).NKz.setVisibility(0);
        ((com.tencent.mm.plugin.recordvideo.plugin.q)localObject).NKz.setAlpha(0.0F);
        ((com.tencent.mm.plugin.recordvideo.plugin.q)localObject).NKz.setCallback((StoryFakeVideoPlayView.a)((com.tencent.mm.plugin.recordvideo.plugin.q)localObject).NKA);
        ((com.tencent.mm.plugin.recordvideo.plugin.q)localObject).NKz.bm(paramb.nKc);
        ((com.tencent.mm.plugin.recordvideo.plugin.q)localObject).startTime = paramb.startTime;
        ((com.tencent.mm.plugin.recordvideo.plugin.q)localObject).endTime = paramb.endTime;
      }
      localObject = getReMuxPlugin();
      RecordConfigProvider localRecordConfigProvider = getConfigProvider();
      kotlin.g.b.s.checkNotNull(localRecordConfigProvider);
      ((ae)localObject).c(paramb, localRecordConfigProvider);
    }
    AppMethodBeat.o(75787);
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    Object localObject = null;
    int j = 0;
    AppMethodBeat.i(75788);
    kotlin.g.b.s.u(paramc, "status");
    if (paramc != a.c.NOK) {
      Log.i("MicroMsg.Image2VideoPluginLayout", "statusChange " + paramc + " ,param : " + paramBundle);
    }
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
      AppMethodBeat.o(75788);
      return;
    case 1: 
      getItemContainerPlugin().onPause();
      getAddMusicPlugin().onPause();
      if (!getMoreMenuPlugin().NJY) {
        break;
      }
    }
    for (int i = 1;; i = 0)
    {
      CaptureDataManager.NHH.rnY.putInt("key_extra_feature_flag", i);
      if (getMoreMenuPlugin().dbk == 2)
      {
        CaptureDataManager.NHH.rnY.putString("key_group_list", getMoreMenuPlugin().gIy());
        boolean bool = getAddMusicPlugin().Gso.getMuteOrigin();
        AudioCacheInfo localAudioCacheInfo = getAddMusicPlugin().Gss;
        ArrayList localArrayList1 = j.a(getItemContainerPlugin());
        ArrayList localArrayList2 = getItemContainerPlugin().getEditorDataList();
        float[] arrayOfFloat = getItemContainerPlugin().gIq();
        paramc = this.NQy;
        if (paramc != null) {
          break label491;
        }
        paramc = localObject;
        label230:
        paramBundle = paramc;
        if (paramc == null) {
          paramBundle = new ArrayList();
        }
        getItemContainerPlugin();
        paramc = new g(bool, localAudioCacheInfo, localArrayList1, localArrayList2, arrayOfFloat, paramBundle, j.gIr());
        Log.i("MicroMsg.Image2VideoPluginLayout", kotlin.g.b.s.X("edit config: ", paramc));
        getReMuxPlugin().a(paramc);
        paramc = c.NRf;
        c.I("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().gIu()));
        paramc = c.NRf;
        c.I("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().gIv()));
        paramc = c.NRf;
        if (getAddMusicPlugin().Gss != null) {
          break label511;
        }
        i = 0;
        label348:
        c.I("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
        paramc = c.NRf;
        if (!getAddMusicPlugin().Gso.getMuteOrigin()) {
          break label516;
        }
        i = 0;
        label377:
        c.I("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i));
        paramc = c.NRf;
        c.I("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
        gIY();
        gIZ();
        paramc = c.NRf;
        c.agH(13);
        paramc = c.NRf;
        c.gJf().jjw = System.currentTimeMillis();
        paramc = c.NRf;
        paramc = getConfigProvider();
        if (paramc != null) {
          break label521;
        }
      }
      label516:
      label521:
      for (i = j;; i = paramc.scene)
      {
        c.agI(i);
        AppMethodBeat.o(75788);
        return;
        if (getMoreMenuPlugin().dbk != 3) {
          break;
        }
        CaptureDataManager.NHH.rnY.putString("key_black_list", getMoreMenuPlugin().gIy());
        break;
        label491:
        paramBundle = paramc.NKf;
        paramc = localObject;
        if (paramBundle == null) {
          break label230;
        }
        paramc = paramBundle.nKc;
        break label230;
        label511:
        i = 1;
        break label348;
        i = 1;
        break label377;
      }
      AppMethodBeat.o(75788);
      return;
    }
  }
  
  public final View getPlayerView()
  {
    AppMethodBeat.i(75786);
    Object localObject = getContext();
    kotlin.g.b.s.s(localObject, "context");
    localObject = new StoryFakeVideoPlayView((Context)localObject);
    ((StoryFakeVideoPlayView)localObject).setAlpha(0.0F);
    Log.i("MicroMsg.Image2VideoPluginLayout", kotlin.g.b.s.X("playerView :", localObject));
    com.tencent.mm.plugin.recordvideo.plugin.q localq = new com.tencent.mm.plugin.recordvideo.plugin.q((StoryFakeVideoPlayView)localObject, (a)this);
    this.NQy = localq;
    getPluginList().add(localq);
    localObject = (View)localObject;
    AppMethodBeat.o(75786);
    return localObject;
  }
  
  public final boolean onBackPress()
  {
    long l = 1L;
    AppMethodBeat.i(75789);
    Object localObject1;
    int j;
    int i;
    if (!super.onBackPress())
    {
      Log.i("MicroMsg.Image2VideoPluginLayout", "onBackPress");
      localObject1 = c.NRf;
      c.I("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject1 = ((Iterable)getItemContainerPlugin().NJQ.getAllItemViews()).iterator();
      j = 0;
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (h)((Iterator)localObject1).next();
        if ((localObject2 instanceof f))
        {
          i += 1;
        }
        else if ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.s))
        {
          j += 1;
        }
        else if ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.q))
        {
          localObject2 = c.NRf;
          c.gJg().jkY = 1L;
        }
        else if ((!(localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.n)) && ((localObject2 instanceof t)))
        {
          localObject2 = c.NRf;
          c.gJg().jjK = 1L;
        }
      }
      localObject1 = c.NRf;
      localObject1 = c.gJg();
      if (!getMoreMenuPlugin().NJY) {
        break label245;
      }
    }
    for (;;)
    {
      ((oz)localObject1).jjG = l;
      localObject1 = c.NRf;
      c.gJg().jjx = i;
      localObject1 = c.NRf;
      c.gJg().jjy = j;
      localObject1 = getNavigator();
      if (localObject1 != null) {
        a.a.a((com.tencent.mm.plugin.recordvideo.activity.a)localObject1);
      }
      AppMethodBeat.o(75789);
      return true;
      label245:
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.Image2VideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */