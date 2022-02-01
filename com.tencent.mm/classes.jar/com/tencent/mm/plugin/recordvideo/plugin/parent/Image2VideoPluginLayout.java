package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.g.b.a.dn;
import com.tencent.mm.plugin.recordvideo.activity.a.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.ab;
import com.tencent.mm.plugin.recordvideo.plugin.i;
import com.tencent.mm.plugin.recordvideo.plugin.o;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView;
import com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.g;
import com.tencent.mm.protocal.protobuf.bmp;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/Image2VideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "photoToViewPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin;", "createReportString", "", "city", "poiName", "getPlayerView", "Landroid/view/View;", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "", "prepareImageSizeReport", "prepareStoryBehaviorReport", "prepareStoryFailBehaviorReport", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public final class Image2VideoPluginLayout
  extends BaseEditVideoPluginLayout
  implements d
{
  public static final a voM;
  private o voL;
  
  static
  {
    AppMethodBeat.i(75793);
    voM = new a((byte)0);
    AppMethodBeat.o(75793);
  }
  
  public Image2VideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75792);
    AppMethodBeat.o(75792);
  }
  
  private final void diu()
  {
    AppMethodBeat.i(75790);
    Object localObject1 = ((Iterable)getItemContainerPlugin().did()).iterator();
    int j = 0;
    int i = 0;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.media.editor.a.a)((Iterator)localObject1).next();
      Object localObject3 = ((com.tencent.mm.media.editor.a.a)localObject2).goB;
      switch (e.fPQ[localObject3.ordinal()])
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
        localObject2 = (bmp)((com.tencent.mm.media.editor.a.a)localObject2).ajx();
        localObject3 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        localObject3 = com.tencent.mm.plugin.recordvideo.d.b.diy();
        String str1 = ((bmp)localObject2).goP;
        k.g(str1, "poiData.cityName");
        String str2 = ((bmp)localObject2).goQ;
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
          ((dc)localObject3).jx(str1);
          localObject3 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.diy().jy(String.valueOf(((bmp)localObject2).dpb));
          localObject3 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.diy().jz(String.valueOf(((bmp)localObject2).dqQ));
          break;
        }
      case 4: 
        localObject2 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.diy().QH();
        break;
      case 5: 
        label320:
        localObject2 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.diy().QI();
      }
    }
    localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.diy().fp(i);
    localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.diy().fq(j);
    localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    localObject1 = com.tencent.mm.plugin.recordvideo.d.b.diy();
    if (getMoreMenuPlugin().vjK)
    {
      l = 1L;
      ((dc)localObject1).fv(l);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.diy();
      localObject2 = getAddMusicPlugin().vgH;
      if (localObject2 == null) {
        break label479;
      }
      i = ((AudioCacheInfo)localObject2).dep;
      localObject2 = AudioCacheInfo.viM;
      if (i != AudioCacheInfo.dhR()) {
        break label479;
      }
    }
    label479:
    for (long l = 1L;; l = 0L)
    {
      ((dc)localObject1).fu(l);
      AppMethodBeat.o(75790);
      return;
      l = 0L;
      break;
    }
  }
  
  private final void div()
  {
    AppMethodBeat.i(75791);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = getCaptureInfo();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).gBs;
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
      localObject = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.diy().jB(localStringBuilder.substring(0, i).toString());
    }
    AppMethodBeat.o(75791);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(75787);
    super.a(paramb);
    ad.i("MicroMsg.Image2VideoPluginLayout", "loadCurrentPage info ".concat(String.valueOf(paramb)));
    if (paramb != null)
    {
      Object localObject = this.voL;
      if (localObject != null)
      {
        k.h(paramb, "info");
        ad.i("MicroMsg.EditPhotoToVideoPlugin", "start preview ".concat(String.valueOf(paramb)));
        ((o)localObject).vjS = paramb;
        ((o)localObject).vkt.setVisibility(0);
        ((o)localObject).vkt.setAlpha(0.0F);
        ((o)localObject).vkt.setCallback((StoryFakeVideoPlayView.a)((o)localObject).vks);
        ((o)localObject).vkt.ai(paramb.gBs);
        ((o)localObject).cUL = paramb.cUL;
        ((o)localObject).gBm = paramb.gBm;
      }
      localObject = getReMuxPlugin();
      RecordConfigProvider localRecordConfigProvider = getConfigProvider();
      if (localRecordConfigProvider == null) {
        k.fvU();
      }
      ((ab)localObject).a(paramb, localRecordConfigProvider);
    }
    AppMethodBeat.o(75787);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(75788);
    k.h(paramc, "status");
    if (paramc != d.c.vob) {
      ad.i("MicroMsg.Image2VideoPluginLayout", "statusChange " + paramc + " ,param : " + paramBundle);
    }
    switch (e.ciE[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
      AppMethodBeat.o(75788);
      return;
    }
    getItemContainerPlugin().onPause();
    getAddMusicPlugin().onPause();
    if (getMoreMenuPlugin().vjK) {}
    for (int i = 1;; i = 0)
    {
      paramc = CaptureDataManager.vhw;
      k.g(paramc, "CaptureDataManager.INSTANCE");
      paramc.getExtData().putInt("key_extra_feature_flag", i);
      if (getMoreMenuPlugin().boX == 2)
      {
        paramc = CaptureDataManager.vhw;
        k.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_group_list", getMoreMenuPlugin().dik());
        boolean bool = getAddMusicPlugin().vmE.getMuteOrigin();
        AudioCacheInfo localAudioCacheInfo = getAddMusicPlugin().vgH;
        ArrayList localArrayList1 = com.tencent.mm.plugin.recordvideo.plugin.h.a(getItemContainerPlugin());
        ArrayList localArrayList2 = getItemContainerPlugin().did();
        float[] arrayOfFloat = getItemContainerPlugin().die();
        paramc = this.voL;
        if (paramc != null)
        {
          paramc = paramc.vjS;
          if (paramc != null)
          {
            paramBundle = paramc.gBs;
            paramc = paramBundle;
            if (paramBundle != null) {
              break label269;
            }
          }
        }
        paramc = new ArrayList();
        label269:
        paramc = new com.tencent.mm.plugin.recordvideo.b.f(bool, localAudioCacheInfo, localArrayList1, localArrayList2, arrayOfFloat, paramc, 256);
        ad.i("MicroMsg.Image2VideoPluginLayout", "edit config: ".concat(String.valueOf(paramc)));
        getReMuxPlugin().a(paramc);
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().dig()));
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().dih()));
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        if (getAddMusicPlugin().vgH != null) {
          break label529;
        }
        i = 0;
        label371:
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        if (!getAddMusicPlugin().vmE.getMuteOrigin()) {
          break label534;
        }
      }
      label529:
      label534:
      for (i = 0;; i = 1)
      {
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i));
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
        diu();
        div();
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.Kp(13);
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.diy().fm(System.currentTimeMillis());
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        paramc = getConfigProvider();
        i = j;
        if (paramc != null) {
          i = paramc.scene;
        }
        com.tencent.mm.plugin.recordvideo.d.b.Kq(i);
        AppMethodBeat.o(75788);
        return;
        if (getMoreMenuPlugin().boX != 3) {
          break;
        }
        paramc = CaptureDataManager.vhw;
        k.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_black_list", getMoreMenuPlugin().dik());
        break;
        i = 1;
        break label371;
      }
    }
  }
  
  public final boolean dia()
  {
    AppMethodBeat.i(75789);
    Object localObject1;
    int j;
    int i;
    if (!super.dia())
    {
      ad.i("MicroMsg.Image2VideoPluginLayout", "onBackPress");
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject1 = ((Iterable)getItemContainerPlugin().vjE.getAllItemViews()).iterator();
      j = 0;
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (com.tencent.mm.media.editor.a.h)((Iterator)localObject1).next();
        if ((localObject2 instanceof c))
        {
          i += 1;
        }
        else if ((localObject2 instanceof g))
        {
          j += 1;
        }
        else if ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.f))
        {
          localObject2 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.diz().Rj();
        }
        else if ((!(localObject2 instanceof e)) && ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.h)))
        {
          localObject2 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.diz().Rl();
        }
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.diz();
      if (!getMoreMenuPlugin().vjK) {
        break label248;
      }
    }
    label248:
    for (long l = 1L;; l = 0L)
    {
      ((dn)localObject1).gx(l);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.diz().gt(i);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.diz().gu(j);
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
    this.voL = localo;
    getPluginList().add(localo);
    localObject = (View)localObject;
    AppMethodBeat.o(75786);
    return localObject;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/Image2VideoPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.Image2VideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */