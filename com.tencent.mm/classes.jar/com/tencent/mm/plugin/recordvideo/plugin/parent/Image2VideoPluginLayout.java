package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.lo;
import com.tencent.mm.f.b.a.lz;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.activity.a.a;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.ac;
import com.tencent.mm.plugin.recordvideo.plugin.i;
import com.tencent.mm.plugin.recordvideo.plugin.j;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView;
import com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.f;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.h;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.q;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.s;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/Image2VideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "photoToViewPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin;", "createReportString", "", "city", "poiName", "getPlayerView", "Landroid/view/View;", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "", "prepareImageSizeReport", "prepareStoryBehaviorReport", "prepareStoryFailBehaviorReport", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public final class Image2VideoPluginLayout
  extends BaseEditVideoPluginLayout
  implements d
{
  public static final a HTN;
  private com.tencent.mm.plugin.recordvideo.plugin.p HTM;
  
  static
  {
    AppMethodBeat.i(75793);
    HTN = new a((byte)0);
    AppMethodBeat.o(75793);
  }
  
  public Image2VideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75792);
    AppMethodBeat.o(75792);
  }
  
  private final void fxm()
  {
    AppMethodBeat.i(75790);
    Object localObject1 = ((Iterable)getItemContainerPlugin().getEditorDataList()).iterator();
    int j = 0;
    int i = 0;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)((Iterator)localObject1).next();
      Object localObject3 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).Ibt;
      switch (e.jLJ[localObject3.ordinal()])
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
          AppMethodBeat.o(75790);
          throw ((Throwable)localObject1);
        }
        localObject2 = (csu)localObject2;
        localObject3 = c.HUw;
        localObject3 = c.fxq();
        String str1 = ((csu)localObject2).Icv;
        kotlin.g.b.p.j(str1, "poiData.cityName");
        String str2 = ((csu)localObject2).poiName;
        kotlin.g.b.p.j(str2, "poiData.poiName");
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
          kotlin.g.b.p.j(str1, "reportPositionString.toString()");
          ((lo)localObject3).Cf(str1);
          localObject3 = c.HUw;
          c.fxq().Cg(String.valueOf(((csu)localObject2).latitude));
          localObject3 = c.HUw;
          c.fxq().Ch(String.valueOf(((csu)localObject2).longitude));
          break;
        }
      case 4: 
        localObject2 = c.HUw;
        c.fxq().amH();
        break;
      case 5: 
        label348:
        localObject2 = c.HUw;
        c.fxq().amI();
      }
    }
    localObject1 = c.HUw;
    c.fxq().vD(i);
    localObject1 = c.HUw;
    c.fxq().vE(j);
    localObject1 = c.HUw;
    localObject1 = c.fxq();
    if (getMoreMenuPlugin().HNb)
    {
      l = 1L;
      ((lo)localObject1).vJ(l);
      localObject1 = c.HUw;
      localObject1 = c.fxq();
      localObject2 = getAddMusicPlugin().AQf;
      if (localObject2 == null) {
        break label507;
      }
      i = ((AudioCacheInfo)localObject2).source;
      localObject2 = AudioCacheInfo.HMa;
      if (i != AudioCacheInfo.fwp()) {
        break label507;
      }
    }
    label507:
    for (long l = 1L;; l = 0L)
    {
      ((lo)localObject1).vI(l);
      AppMethodBeat.o(75790);
      return;
      l = 0L;
      break;
    }
  }
  
  private final void fxn()
  {
    AppMethodBeat.i(75791);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = getCaptureInfo();
    if (localObject != null)
    {
      localObject = ((b)localObject).lfr;
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
      localObject = c.HUw;
      c.fxq().Cj(localStringBuilder.substring(0, i).toString());
    }
    AppMethodBeat.o(75791);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(75787);
    super.a(paramb);
    Log.i("MicroMsg.Image2VideoPluginLayout", "loadCurrentPage info ".concat(String.valueOf(paramb)));
    if (paramb != null)
    {
      Object localObject = this.HTM;
      if (localObject != null)
      {
        kotlin.g.b.p.k(paramb, "info");
        Log.i("MicroMsg.EditPhotoToVideoPlugin", "start preview ".concat(String.valueOf(paramb)));
        ((com.tencent.mm.plugin.recordvideo.plugin.p)localObject).HNh = paramb;
        ((com.tencent.mm.plugin.recordvideo.plugin.p)localObject).HND.setVisibility(0);
        ((com.tencent.mm.plugin.recordvideo.plugin.p)localObject).HND.setAlpha(0.0F);
        ((com.tencent.mm.plugin.recordvideo.plugin.p)localObject).HND.setCallback((StoryFakeVideoPlayView.a)((com.tencent.mm.plugin.recordvideo.plugin.p)localObject).HNC);
        ((com.tencent.mm.plugin.recordvideo.plugin.p)localObject).HND.aR(paramb.lfr);
        ((com.tencent.mm.plugin.recordvideo.plugin.p)localObject).fod = paramb.fod;
        ((com.tencent.mm.plugin.recordvideo.plugin.p)localObject).endTime = paramb.endTime;
      }
      localObject = getReMuxPlugin();
      RecordConfigProvider localRecordConfigProvider = getConfigProvider();
      if (localRecordConfigProvider == null) {
        kotlin.g.b.p.iCn();
      }
      ((ac)localObject).b(paramb, localRecordConfigProvider);
    }
    AppMethodBeat.o(75787);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(75788);
    kotlin.g.b.p.k(paramc, "status");
    if (paramc != d.c.HSe) {
      Log.i("MicroMsg.Image2VideoPluginLayout", "statusChange " + paramc + " ,param : " + paramBundle);
    }
    switch (e.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
      AppMethodBeat.o(75788);
      return;
    case 1: 
      getItemContainerPlugin().onPause();
      getAddMusicPlugin().onPause();
      if (!getMoreMenuPlugin().HNb) {
        break;
      }
    }
    for (int i = 1;; i = 0)
    {
      paramc = CaptureDataManager.HKJ;
      kotlin.g.b.p.j(paramc, "CaptureDataManager.INSTANCE");
      paramc.getExtData().putInt("key_extra_feature_flag", i);
      if (getMoreMenuPlugin().bhr == 2)
      {
        paramc = CaptureDataManager.HKJ;
        kotlin.g.b.p.j(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_group_list", getMoreMenuPlugin().fwQ());
        boolean bool = getAddMusicPlugin().AQb.getMuteOrigin();
        AudioCacheInfo localAudioCacheInfo = getAddMusicPlugin().AQf;
        ArrayList localArrayList1 = i.a(getItemContainerPlugin());
        ArrayList localArrayList2 = getItemContainerPlugin().getEditorDataList();
        float[] arrayOfFloat = getItemContainerPlugin().fwI();
        paramc = this.HTM;
        if (paramc != null)
        {
          paramc = paramc.HNh;
          if (paramc != null)
          {
            paramBundle = paramc.lfr;
            paramc = paramBundle;
            if (paramBundle != null) {
              break label273;
            }
          }
        }
        paramc = new ArrayList();
        label273:
        getItemContainerPlugin();
        paramc = new g(bool, localAudioCacheInfo, localArrayList1, localArrayList2, arrayOfFloat, paramc, i.fwJ());
        Log.i("MicroMsg.Image2VideoPluginLayout", "edit config: ".concat(String.valueOf(paramc)));
        getReMuxPlugin().a(paramc);
        paramc = c.HUw;
        c.w("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().fwM()));
        paramc = c.HUw;
        c.w("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().fwN()));
        paramc = c.HUw;
        if (getAddMusicPlugin().AQf != null) {
          break label538;
        }
        i = 0;
        label380:
        c.w("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
        paramc = c.HUw;
        if (!getAddMusicPlugin().AQb.getMuteOrigin()) {
          break label543;
        }
      }
      label538:
      label543:
      for (i = 0;; i = 1)
      {
        c.w("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i));
        paramc = c.HUw;
        c.w("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
        fxm();
        fxn();
        paramc = c.HUw;
        c.acr(13);
        paramc = c.HUw;
        c.fxq().vA(System.currentTimeMillis());
        paramc = c.HUw;
        paramc = getConfigProvider();
        i = j;
        if (paramc != null) {
          i = paramc.scene;
        }
        c.acs(i);
        AppMethodBeat.o(75788);
        return;
        if (getMoreMenuPlugin().bhr != 3) {
          break;
        }
        paramc = CaptureDataManager.HKJ;
        kotlin.g.b.p.j(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_black_list", getMoreMenuPlugin().fwQ());
        break;
        i = 1;
        break label380;
      }
      AppMethodBeat.o(75788);
      return;
    }
  }
  
  public final View getPlayerView()
  {
    AppMethodBeat.i(75786);
    Object localObject = new StoryFakeVideoPlayView(getContext());
    ((StoryFakeVideoPlayView)localObject).setAlpha(0.0F);
    Log.i("MicroMsg.Image2VideoPluginLayout", "playerView :".concat(String.valueOf(localObject)));
    com.tencent.mm.plugin.recordvideo.plugin.p localp = new com.tencent.mm.plugin.recordvideo.plugin.p((StoryFakeVideoPlayView)localObject, (d)this);
    this.HTM = localp;
    getPluginList().add(localp);
    localObject = (View)localObject;
    AppMethodBeat.o(75786);
    return localObject;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75789);
    Object localObject1;
    int j;
    int i;
    if (!super.onBackPress())
    {
      Log.i("MicroMsg.Image2VideoPluginLayout", "onBackPress");
      localObject1 = c.HUw;
      c.w("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject1 = ((Iterable)getItemContainerPlugin().HMV.getAllItemViews()).iterator();
      j = 0;
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (h)((Iterator)localObject1).next();
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
          localObject2 = c.HUw;
          c.fxr().ank();
        }
        else if ((!(localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.n)) && ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.t)))
        {
          localObject2 = c.HUw;
          c.fxr().anm();
        }
      }
      localObject1 = c.HUw;
      localObject1 = c.fxr();
      if (!getMoreMenuPlugin().HNb) {
        break label248;
      }
    }
    label248:
    for (long l = 1L;; l = 0L)
    {
      ((lz)localObject1).wK(l);
      localObject1 = c.HUw;
      c.fxr().wH(i);
      localObject1 = c.HUw;
      c.fxr().wI(j);
      localObject1 = getNavigator();
      if (localObject1 != null) {
        a.a.a((com.tencent.mm.plugin.recordvideo.activity.a)localObject1);
      }
      AppMethodBeat.o(75789);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/Image2VideoPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.Image2VideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */