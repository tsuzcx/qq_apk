package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.g.b.a.fb;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.activity.a.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.i;
import com.tencent.mm.plugin.recordvideo.plugin.o;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView;
import com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.g;
import com.tencent.mm.protocal.protobuf.brf;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/Image2VideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "photoToViewPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin;", "createReportString", "", "city", "poiName", "getPlayerView", "Landroid/view/View;", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "", "prepareImageSizeReport", "prepareStoryBehaviorReport", "prepareStoryFailBehaviorReport", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public final class Image2VideoPluginLayout
  extends BaseEditVideoPluginLayout
  implements d
{
  public static final Image2VideoPluginLayout.a wxz;
  private o wxy;
  
  static
  {
    AppMethodBeat.i(75793);
    wxz = new Image2VideoPluginLayout.a((byte)0);
    AppMethodBeat.o(75793);
  }
  
  public Image2VideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75792);
    AppMethodBeat.o(75792);
  }
  
  private final void dwm()
  {
    AppMethodBeat.i(75790);
    Object localObject1 = ((Iterable)getItemContainerPlugin().dvN()).iterator();
    int j = 0;
    int i = 0;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.media.editor.a.a)((Iterator)localObject1).next();
      Object localObject3 = ((com.tencent.mm.media.editor.a.a)localObject2).gPj;
      switch (e.fTL[localObject3.ordinal()])
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
        localObject2 = (brf)((com.tencent.mm.media.editor.a.a)localObject2).aqw();
        localObject3 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        localObject3 = com.tencent.mm.plugin.recordvideo.d.c.dwr();
        String str1 = ((brf)localObject2).gPx;
        k.g(str1, "poiData.cityName");
        String str2 = ((brf)localObject2).gPy;
        k.g(str2, "poiData.poiName");
        StringBuilder localStringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty((CharSequence)str1)) {
          localStringBuilder.append(n.h(str1, ",", " ", true));
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
          localStringBuilder.append(n.h(str2, ",", " ", true));
          str1 = localStringBuilder.toString();
          k.g(str1, "reportPositionString.toString()");
          ((eq)localObject3).mn(str1);
          localObject3 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          com.tencent.mm.plugin.recordvideo.d.c.dwr().mo(String.valueOf(((brf)localObject2).dmL));
          localObject3 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          com.tencent.mm.plugin.recordvideo.d.c.dwr().mp(String.valueOf(((brf)localObject2).doB));
          break;
        }
      case 4: 
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.dwr().Rj();
        break;
      case 5: 
        label320:
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.dwr().Rk();
      }
    }
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
    com.tencent.mm.plugin.recordvideo.d.c.dwr().iC(i);
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
    com.tencent.mm.plugin.recordvideo.d.c.dwr().iD(j);
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dwr();
    if (getMoreMenuPlugin().wsv)
    {
      l = 1L;
      ((eq)localObject1).iI(l);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dwr();
      localObject2 = getAddMusicPlugin().wpt;
      if (localObject2 == null) {
        break label479;
      }
      i = ((AudioCacheInfo)localObject2).dbL;
      localObject2 = AudioCacheInfo.wry;
      if (i != AudioCacheInfo.dvC()) {
        break label479;
      }
    }
    label479:
    for (long l = 1L;; l = 0L)
    {
      ((eq)localObject1).iH(l);
      AppMethodBeat.o(75790);
      return;
      l = 0L;
      break;
    }
  }
  
  private final void dwn()
  {
    AppMethodBeat.i(75791);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = getCaptureInfo();
    if (localObject != null)
    {
      localObject = ((b)localObject).hbO;
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
      localObject = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.dwr().mr(localStringBuilder.substring(0, i).toString());
    }
    AppMethodBeat.o(75791);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(75787);
    super.a(paramb);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Image2VideoPluginLayout", "loadCurrentPage info ".concat(String.valueOf(paramb)));
    if (paramb != null)
    {
      Object localObject = this.wxy;
      if (localObject != null)
      {
        k.h(paramb, "info");
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.EditPhotoToVideoPlugin", "start preview ".concat(String.valueOf(paramb)));
        ((o)localObject).sgm = paramb;
        ((o)localObject).wsV.setVisibility(0);
        ((o)localObject).wsV.setAlpha(0.0F);
        ((o)localObject).wsV.setCallback((StoryFakeVideoPlayView.a)((o)localObject).wsU);
        ((o)localObject).wsV.au(paramb.hbO);
        ((o)localObject).cSh = paramb.cSh;
        ((o)localObject).hbI = paramb.hbI;
      }
      localObject = getReMuxPlugin();
      RecordConfigProvider localRecordConfigProvider = getConfigProvider();
      if (localRecordConfigProvider == null) {
        k.fOy();
      }
      ((com.tencent.mm.plugin.recordvideo.plugin.ac)localObject).a(paramb, localRecordConfigProvider);
    }
    AppMethodBeat.o(75787);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(75788);
    k.h(paramc, "status");
    if (paramc != d.c.wwI) {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Image2VideoPluginLayout", "statusChange " + paramc + " ,param : " + paramBundle);
    }
    switch (e.cfA[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
      AppMethodBeat.o(75788);
      return;
    }
    getItemContainerPlugin().onPause();
    getAddMusicPlugin().onPause();
    if (getMoreMenuPlugin().wsv) {}
    for (int i = 1;; i = 0)
    {
      paramc = CaptureDataManager.wqi;
      k.g(paramc, "CaptureDataManager.INSTANCE");
      paramc.getExtData().putInt("key_extra_feature_flag", i);
      if (getMoreMenuPlugin().bns == 2)
      {
        paramc = CaptureDataManager.wqi;
        k.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_group_list", getMoreMenuPlugin().dvU());
        boolean bool = getAddMusicPlugin().wvm.getMuteOrigin();
        AudioCacheInfo localAudioCacheInfo = getAddMusicPlugin().wpt;
        ArrayList localArrayList1 = com.tencent.mm.plugin.recordvideo.plugin.h.a(getItemContainerPlugin());
        ArrayList localArrayList2 = getItemContainerPlugin().dvN();
        float[] arrayOfFloat = getItemContainerPlugin().dvO();
        paramc = this.wxy;
        if (paramc != null)
        {
          paramc = paramc.sgm;
          if (paramc != null)
          {
            paramBundle = paramc.hbO;
            paramc = paramBundle;
            if (paramBundle != null) {
              break label269;
            }
          }
        }
        paramc = new ArrayList();
        label269:
        paramc = new com.tencent.mm.plugin.recordvideo.b.f(bool, localAudioCacheInfo, localArrayList1, localArrayList2, arrayOfFloat, paramc, 256);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Image2VideoPluginLayout", "edit config: ".concat(String.valueOf(paramc)));
        getReMuxPlugin().a(paramc);
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().dvQ()));
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().dvR()));
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        if (getAddMusicPlugin().wpt != null) {
          break label529;
        }
        i = 0;
        label371:
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        if (!getAddMusicPlugin().wvm.getMuteOrigin()) {
          break label534;
        }
      }
      label529:
      label534:
      for (i = 0;; i = 1)
      {
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i));
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
        dwm();
        dwn();
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.Mo(13);
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.dwr().iz(System.currentTimeMillis());
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        paramc = getConfigProvider();
        i = j;
        if (paramc != null) {
          i = paramc.scene;
        }
        com.tencent.mm.plugin.recordvideo.d.c.Mp(i);
        AppMethodBeat.o(75788);
        return;
        if (getMoreMenuPlugin().bns != 3) {
          break;
        }
        paramc = CaptureDataManager.wqi;
        k.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_black_list", getMoreMenuPlugin().dvU());
        break;
        i = 1;
        break label371;
      }
    }
  }
  
  public final boolean alO()
  {
    AppMethodBeat.i(75789);
    Object localObject1;
    int j;
    int i;
    if (!super.alO())
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Image2VideoPluginLayout", "onBackPress");
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject1 = ((Iterable)getItemContainerPlugin().wsp.getAllItemViews()).iterator();
      j = 0;
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (com.tencent.mm.media.editor.a.h)((Iterator)localObject1).next();
        if ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.c))
        {
          i += 1;
        }
        else if ((localObject2 instanceof g))
        {
          j += 1;
        }
        else if ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.f))
        {
          localObject2 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          com.tencent.mm.plugin.recordvideo.d.c.dws().RL();
        }
        else if ((!(localObject2 instanceof e)) && ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.h)))
        {
          localObject2 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          com.tencent.mm.plugin.recordvideo.d.c.dws().RN();
        }
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dws();
      if (!getMoreMenuPlugin().wsv) {
        break label248;
      }
    }
    label248:
    for (long l = 1L;; l = 0L)
    {
      ((fb)localObject1).jK(l);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.dws().jG(i);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.dws().jH(j);
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Image2VideoPluginLayout", "playerView :".concat(String.valueOf(localObject)));
    o localo = new o((StoryFakeVideoPlayView)localObject, (d)this);
    this.wxy = localo;
    getPluginList().add(localo);
    localObject = (View)localObject;
    AppMethodBeat.o(75786);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.Image2VideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */