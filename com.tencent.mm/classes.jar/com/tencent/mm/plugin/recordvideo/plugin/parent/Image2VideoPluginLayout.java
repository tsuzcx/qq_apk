package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fp;
import com.tencent.mm.g.b.a.ga;
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
import com.tencent.mm.protocal.protobuf.bvs;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/Image2VideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "photoToViewPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin;", "createReportString", "", "city", "poiName", "getPlayerView", "Landroid/view/View;", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "", "prepareImageSizeReport", "prepareStoryBehaviorReport", "prepareStoryFailBehaviorReport", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public final class Image2VideoPluginLayout
  extends BaseEditVideoPluginLayout
  implements d
{
  public static final Image2VideoPluginLayout.a xGt;
  private o xGs;
  
  static
  {
    AppMethodBeat.i(75793);
    xGt = new Image2VideoPluginLayout.a((byte)0);
    AppMethodBeat.o(75793);
  }
  
  public Image2VideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75792);
    AppMethodBeat.o(75792);
  }
  
  private final void dGG()
  {
    AppMethodBeat.i(75790);
    Object localObject1 = ((Iterable)getItemContainerPlugin().getEditorDataList()).iterator();
    int j = 0;
    int i = 0;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)((Iterator)localObject1).next();
      Object localObject3 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).xNC;
      switch (e.gnp[localObject3.ordinal()])
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
        localObject2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).dHT();
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LocationItemData");
          AppMethodBeat.o(75790);
          throw ((Throwable)localObject1);
        }
        localObject2 = (bvs)localObject2;
        localObject3 = c.xHa;
        localObject3 = c.dGL();
        String str1 = ((bvs)localObject2).xOD;
        d.g.b.p.g(str1, "poiData.cityName");
        String str2 = ((bvs)localObject2).jDf;
        d.g.b.p.g(str2, "poiData.poiName");
        StringBuilder localStringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty((CharSequence)str1)) {
          localStringBuilder.append(n.h(str1, ",", " ", true));
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
          localStringBuilder.append(n.h(str2, ",", " ", true));
          str1 = localStringBuilder.toString();
          d.g.b.p.g(str1, "reportPositionString.toString()");
          ((fp)localObject3).oA(str1);
          localObject3 = c.xHa;
          c.dGL().oB(String.valueOf(((bvs)localObject2).dyz));
          localObject3 = c.xHa;
          c.dGL().oC(String.valueOf(((bvs)localObject2).dAp));
          break;
        }
      case 4: 
        localObject2 = c.xHa;
        c.dGL().Tq();
        break;
      case 5: 
        label348:
        localObject2 = c.xHa;
        c.dGL().Tr();
      }
    }
    localObject1 = c.xHa;
    c.dGL().ko(i);
    localObject1 = c.xHa;
    c.dGL().kp(j);
    localObject1 = c.xHa;
    localObject1 = c.dGL();
    if (getMoreMenuPlugin().xAo)
    {
      l = 1L;
      ((fp)localObject1).ku(l);
      localObject1 = c.xHa;
      localObject1 = c.dGL();
      localObject2 = getAddMusicPlugin().xxj;
      if (localObject2 == null) {
        break label507;
      }
      i = ((AudioCacheInfo)localObject2).dnh;
      localObject2 = AudioCacheInfo.xzp;
      if (i != AudioCacheInfo.dFY()) {
        break label507;
      }
    }
    label507:
    for (long l = 1L;; l = 0L)
    {
      ((fp)localObject1).kt(l);
      AppMethodBeat.o(75790);
      return;
      l = 0L;
      break;
    }
  }
  
  private final void dGH()
  {
    AppMethodBeat.i(75791);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = getCaptureInfo();
    if (localObject != null)
    {
      localObject = ((b)localObject).htW;
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
      localObject = c.xHa;
      c.dGL().oE(localStringBuilder.substring(0, i).toString());
    }
    AppMethodBeat.o(75791);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(75787);
    super.a(paramb);
    ad.i("MicroMsg.Image2VideoPluginLayout", "loadCurrentPage info ".concat(String.valueOf(paramb)));
    if (paramb != null)
    {
      Object localObject = this.xGs;
      if (localObject != null)
      {
        d.g.b.p.h(paramb, "info");
        ad.i("MicroMsg.EditPhotoToVideoPlugin", "start preview ".concat(String.valueOf(paramb)));
        ((o)localObject).xAw = paramb;
        ((o)localObject).xAV.setVisibility(0);
        ((o)localObject).xAV.setAlpha(0.0F);
        ((o)localObject).xAV.setCallback((StoryFakeVideoPlayView.a)((o)localObject).xAU);
        ((o)localObject).xAV.as(paramb.htW);
        ((o)localObject).ddx = paramb.ddx;
        ((o)localObject).htQ = paramb.htQ;
      }
      localObject = getReMuxPlugin();
      RecordConfigProvider localRecordConfigProvider = getConfigProvider();
      if (localRecordConfigProvider == null) {
        d.g.b.p.gfZ();
      }
      ((ab)localObject).a(paramb, localRecordConfigProvider);
    }
    AppMethodBeat.o(75787);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(75788);
    d.g.b.p.h(paramc, "status");
    if (paramc != d.c.xER) {
      ad.i("MicroMsg.Image2VideoPluginLayout", "statusChange " + paramc + " ,param : " + paramBundle);
    }
    switch (e.cpQ[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
      AppMethodBeat.o(75788);
      return;
    case 1: 
      getItemContainerPlugin().onPause();
      getAddMusicPlugin().onPause();
      if (!getMoreMenuPlugin().xAo) {
        break;
      }
    }
    for (int i = 1;; i = 0)
    {
      paramc = CaptureDataManager.xxY;
      d.g.b.p.g(paramc, "CaptureDataManager.INSTANCE");
      paramc.getExtData().putInt("key_extra_feature_flag", i);
      if (getMoreMenuPlugin().bxN == 2)
      {
        paramc = CaptureDataManager.xxY;
        d.g.b.p.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_group_list", getMoreMenuPlugin().dGs());
        boolean bool = getAddMusicPlugin().xDi.getMuteOrigin();
        AudioCacheInfo localAudioCacheInfo = getAddMusicPlugin().xxj;
        ArrayList localArrayList1 = h.a(getItemContainerPlugin());
        ArrayList localArrayList2 = getItemContainerPlugin().getEditorDataList();
        float[] arrayOfFloat = getItemContainerPlugin().dGl();
        paramc = this.xGs;
        if (paramc != null)
        {
          paramc = paramc.xAw;
          if (paramc != null)
          {
            paramBundle = paramc.htW;
            paramc = paramBundle;
            if (paramBundle != null) {
              break label273;
            }
          }
        }
        paramc = new ArrayList();
        label273:
        getItemContainerPlugin();
        paramc = new com.tencent.mm.plugin.recordvideo.b.f(bool, localAudioCacheInfo, localArrayList1, localArrayList2, arrayOfFloat, paramc, h.dGm());
        ad.i("MicroMsg.Image2VideoPluginLayout", "edit config: ".concat(String.valueOf(paramc)));
        getReMuxPlugin().a(paramc);
        paramc = c.xHa;
        c.u("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().dGo()));
        paramc = c.xHa;
        c.u("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().dGp()));
        paramc = c.xHa;
        if (getAddMusicPlugin().xxj != null) {
          break label538;
        }
        i = 0;
        label380:
        c.u("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
        paramc = c.xHa;
        if (!getAddMusicPlugin().xDi.getMuteOrigin()) {
          break label543;
        }
      }
      label538:
      label543:
      for (i = 0;; i = 1)
      {
        c.u("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i));
        paramc = c.xHa;
        c.u("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
        dGG();
        dGH();
        paramc = c.xHa;
        c.NN(13);
        paramc = c.xHa;
        c.dGL().kl(System.currentTimeMillis());
        paramc = c.xHa;
        paramc = getConfigProvider();
        i = j;
        if (paramc != null) {
          i = paramc.scene;
        }
        c.NO(i);
        AppMethodBeat.o(75788);
        return;
        if (getMoreMenuPlugin().bxN != 3) {
          break;
        }
        paramc = CaptureDataManager.xxY;
        d.g.b.p.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_black_list", getMoreMenuPlugin().dGs());
        break;
        i = 1;
        break label380;
      }
      AppMethodBeat.o(75788);
      return;
    }
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(75789);
    Object localObject1;
    int j;
    int i;
    if (!super.aoB())
    {
      ad.i("MicroMsg.Image2VideoPluginLayout", "onBackPress");
      localObject1 = c.xHa;
      c.u("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject1 = ((Iterable)getItemContainerPlugin().xAi.getAllItemViews()).iterator();
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
          localObject2 = c.xHa;
          c.dGM().TS();
        }
        else if ((!(localObject2 instanceof m)) && ((localObject2 instanceof s)))
        {
          localObject2 = c.xHa;
          c.dGM().TU();
        }
      }
      localObject1 = c.xHa;
      localObject1 = c.dGM();
      if (!getMoreMenuPlugin().xAo) {
        break label248;
      }
    }
    label248:
    for (long l = 1L;; l = 0L)
    {
      ((ga)localObject1).lw(l);
      localObject1 = c.xHa;
      c.dGM().ls(i);
      localObject1 = c.xHa;
      c.dGM().lt(j);
      localObject1 = getNavigator();
      if (localObject1 != null) {
        a.a.a((com.tencent.mm.plugin.recordvideo.activity.a)localObject1);
      }
      AppMethodBeat.o(75789);
      return true;
    }
  }
  
  public final View getPlayerView()
  {
    AppMethodBeat.i(75786);
    Object localObject = new StoryFakeVideoPlayView(getContext());
    ((StoryFakeVideoPlayView)localObject).setAlpha(0.0F);
    ad.i("MicroMsg.Image2VideoPluginLayout", "playerView :".concat(String.valueOf(localObject)));
    o localo = new o((StoryFakeVideoPlayView)localObject, (d)this);
    this.xGs = localo;
    getPluginList().add(localo);
    localObject = (View)localObject;
    AppMethodBeat.o(75786);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.Image2VideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */