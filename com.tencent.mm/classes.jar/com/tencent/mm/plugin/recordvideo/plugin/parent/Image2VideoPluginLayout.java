package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.jf;
import com.tencent.mm.g.b.a.jq;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.activity.a.a;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.ab;
import com.tencent.mm.plugin.recordvideo.plugin.h;
import com.tencent.mm.plugin.recordvideo.plugin.i;
import com.tencent.mm.plugin.recordvideo.plugin.o;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView;
import com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.g;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.m;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.s;
import com.tencent.mm.protocal.protobuf.cka;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/Image2VideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "photoToViewPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin;", "createReportString", "", "city", "poiName", "getPlayerView", "Landroid/view/View;", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "", "prepareImageSizeReport", "prepareStoryBehaviorReport", "prepareStoryFailBehaviorReport", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public final class Image2VideoPluginLayout
  extends BaseEditVideoPluginLayout
  implements d
{
  public static final Image2VideoPluginLayout.a BWZ;
  private o BWY;
  
  static
  {
    AppMethodBeat.i(75793);
    BWZ = new Image2VideoPluginLayout.a((byte)0);
    AppMethodBeat.o(75793);
  }
  
  public Image2VideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75792);
    AppMethodBeat.o(75792);
  }
  
  private final void eKS()
  {
    AppMethodBeat.i(75790);
    Object localObject1 = ((Iterable)getItemContainerPlugin().getEditorDataList()).iterator();
    int j = 0;
    int i = 0;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)((Iterator)localObject1).next();
      Object localObject3 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).Cex;
      switch (e.haE[localObject3.ordinal()])
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
        localObject2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).eMk();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LocationItemData");
          AppMethodBeat.o(75790);
          throw ((Throwable)localObject1);
        }
        localObject2 = (cka)localObject2;
        localObject3 = c.BXI;
        localObject3 = c.eKX();
        String str1 = ((cka)localObject2).Cfy;
        kotlin.g.b.p.g(str1, "poiData.cityName");
        String str2 = ((cka)localObject2).kHV;
        kotlin.g.b.p.g(str2, "poiData.poiName");
        StringBuilder localStringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty((CharSequence)str1)) {
          localStringBuilder.append(n.j(str1, ",", " ", true));
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
          localStringBuilder.append(n.j(str2, ",", " ", true));
          str1 = localStringBuilder.toString();
          kotlin.g.b.p.g(str1, "reportPositionString.toString()");
          ((jf)localObject3).wE(str1);
          localObject3 = c.BXI;
          c.eKX().wF(String.valueOf(((cka)localObject2).latitude));
          localObject3 = c.BXI;
          c.eKX().wG(String.valueOf(((cka)localObject2).dTj));
          break;
        }
      case 4: 
        localObject2 = c.BXI;
        c.eKX().ahl();
        break;
      case 5: 
        label348:
        localObject2 = c.BXI;
        c.eKX().ahm();
      }
    }
    localObject1 = c.BXI;
    c.eKX().rB(i);
    localObject1 = c.BXI;
    c.eKX().rC(j);
    localObject1 = c.BXI;
    localObject1 = c.eKX();
    if (getMoreMenuPlugin().BQn)
    {
      l = 1L;
      ((jf)localObject1).rH(l);
      localObject1 = c.BXI;
      localObject1 = c.eKX();
      localObject2 = getAddMusicPlugin().wgG;
      if (localObject2 == null) {
        break label507;
      }
      i = ((AudioCacheInfo)localObject2).source;
      localObject2 = AudioCacheInfo.BPo;
      if (i != AudioCacheInfo.eKc()) {
        break label507;
      }
    }
    label507:
    for (long l = 1L;; l = 0L)
    {
      ((jf)localObject1).rG(l);
      AppMethodBeat.o(75790);
      return;
      l = 0L;
      break;
    }
  }
  
  private final void eKT()
  {
    AppMethodBeat.i(75791);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = getCaptureInfo();
    if (localObject != null)
    {
      localObject = ((b)localObject).iqm;
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
      localObject = c.BXI;
      c.eKX().wI(localStringBuilder.substring(0, i).toString());
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
      Object localObject = this.BWY;
      if (localObject != null)
      {
        kotlin.g.b.p.h(paramb, "info");
        Log.i("MicroMsg.EditPhotoToVideoPlugin", "start preview ".concat(String.valueOf(paramb)));
        ((o)localObject).BQt = paramb;
        ((o)localObject).BQN.setVisibility(0);
        ((o)localObject).BQN.setAlpha(0.0F);
        ((o)localObject).BQN.setCallback((StoryFakeVideoPlayView.a)((o)localObject).BQM);
        ((o)localObject).BQN.aK(paramb.iqm);
        ((o)localObject).dvv = paramb.dvv;
        ((o)localObject).iqg = paramb.iqg;
      }
      localObject = getReMuxPlugin();
      RecordConfigProvider localRecordConfigProvider = getConfigProvider();
      if (localRecordConfigProvider == null) {
        kotlin.g.b.p.hyc();
      }
      ((ab)localObject).a(paramb, localRecordConfigProvider);
    }
    AppMethodBeat.o(75787);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(75788);
    kotlin.g.b.p.h(paramc, "status");
    if (paramc != d.c.BVq) {
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
      if (!getMoreMenuPlugin().BQn) {
        break;
      }
    }
    for (int i = 1;; i = 0)
    {
      paramc = CaptureDataManager.BOb;
      kotlin.g.b.p.g(paramc, "CaptureDataManager.INSTANCE");
      paramc.getExtData().putInt("key_extra_feature_flag", i);
      if (getMoreMenuPlugin().bxP == 2)
      {
        paramc = CaptureDataManager.BOb;
        kotlin.g.b.p.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_group_list", getMoreMenuPlugin().eKy());
        boolean bool = getAddMusicPlugin().wgL.getMuteOrigin();
        AudioCacheInfo localAudioCacheInfo = getAddMusicPlugin().wgG;
        ArrayList localArrayList1 = h.a(getItemContainerPlugin());
        ArrayList localArrayList2 = getItemContainerPlugin().getEditorDataList();
        float[] arrayOfFloat = getItemContainerPlugin().eKr();
        paramc = this.BWY;
        if (paramc != null)
        {
          paramc = paramc.BQt;
          if (paramc != null)
          {
            paramBundle = paramc.iqm;
            paramc = paramBundle;
            if (paramBundle != null) {
              break label273;
            }
          }
        }
        paramc = new ArrayList();
        label273:
        getItemContainerPlugin();
        paramc = new com.tencent.mm.plugin.recordvideo.b.f(bool, localAudioCacheInfo, localArrayList1, localArrayList2, arrayOfFloat, paramc, h.eKs());
        Log.i("MicroMsg.Image2VideoPluginLayout", "edit config: ".concat(String.valueOf(paramc)));
        getReMuxPlugin().a(paramc);
        paramc = c.BXI;
        c.x("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().eKu()));
        paramc = c.BXI;
        c.x("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().eKv()));
        paramc = c.BXI;
        if (getAddMusicPlugin().wgG != null) {
          break label538;
        }
        i = 0;
        label380:
        c.x("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
        paramc = c.BXI;
        if (!getAddMusicPlugin().wgL.getMuteOrigin()) {
          break label543;
        }
      }
      label538:
      label543:
      for (i = 0;; i = 1)
      {
        c.x("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i));
        paramc = c.BXI;
        c.x("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
        eKS();
        eKT();
        paramc = c.BXI;
        c.VI(13);
        paramc = c.BXI;
        c.eKX().ry(System.currentTimeMillis());
        paramc = c.BXI;
        paramc = getConfigProvider();
        i = j;
        if (paramc != null) {
          i = paramc.scene;
        }
        c.VJ(i);
        AppMethodBeat.o(75788);
        return;
        if (getMoreMenuPlugin().bxP != 3) {
          break;
        }
        paramc = CaptureDataManager.BOb;
        kotlin.g.b.p.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_black_list", getMoreMenuPlugin().eKy());
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
    o localo = new o((StoryFakeVideoPlayView)localObject, (d)this);
    this.BWY = localo;
    getPluginList().add(localo);
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
      localObject1 = c.BXI;
      c.x("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject1 = ((Iterable)getItemContainerPlugin().BQh.getAllItemViews()).iterator();
      j = 0;
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (g)((Iterator)localObject1).next();
        if ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.f))
        {
          i += 1;
        }
        else if ((localObject2 instanceof r))
        {
          j += 1;
        }
        else if ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.p))
        {
          localObject2 = c.BXI;
          c.eKY().ahN();
        }
        else if ((!(localObject2 instanceof m)) && ((localObject2 instanceof s)))
        {
          localObject2 = c.BXI;
          c.eKY().ahP();
        }
      }
      localObject1 = c.BXI;
      localObject1 = c.eKY();
      if (!getMoreMenuPlugin().BQn) {
        break label248;
      }
    }
    label248:
    for (long l = 1L;; l = 0L)
    {
      ((jq)localObject1).sJ(l);
      localObject1 = c.BXI;
      c.eKY().sF(i);
      localObject1 = c.BXI;
      c.eKY().sG(j);
      localObject1 = getNavigator();
      if (localObject1 != null) {
        a.a.a((com.tencent.mm.plugin.recordvideo.activity.a)localObject1);
      }
      AppMethodBeat.o(75789);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.Image2VideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */