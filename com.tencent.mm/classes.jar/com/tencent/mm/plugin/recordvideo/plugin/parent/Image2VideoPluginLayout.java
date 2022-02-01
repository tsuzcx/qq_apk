package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fr;
import com.tencent.mm.g.b.a.gc;
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
import com.tencent.mm.protocal.protobuf.bwm;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/Image2VideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "photoToViewPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin;", "createReportString", "", "city", "poiName", "getPlayerView", "Landroid/view/View;", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "", "prepareImageSizeReport", "prepareStoryBehaviorReport", "prepareStoryFailBehaviorReport", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public final class Image2VideoPluginLayout
  extends BaseEditVideoPluginLayout
  implements d
{
  public static final Image2VideoPluginLayout.a xWo;
  private o xWn;
  
  static
  {
    AppMethodBeat.i(75793);
    xWo = new Image2VideoPluginLayout.a((byte)0);
    AppMethodBeat.o(75793);
  }
  
  public Image2VideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75792);
    AppMethodBeat.o(75792);
  }
  
  private final void dJX()
  {
    AppMethodBeat.i(75790);
    Object localObject1 = ((Iterable)getItemContainerPlugin().getEditorDataList()).iterator();
    int j = 0;
    int i = 0;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)((Iterator)localObject1).next();
      Object localObject3 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).ydv;
      switch (e.gpL[localObject3.ordinal()])
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
        localObject2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).dLk();
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LocationItemData");
          AppMethodBeat.o(75790);
          throw ((Throwable)localObject1);
        }
        localObject2 = (bwm)localObject2;
        localObject3 = c.xWV;
        localObject3 = c.dKc();
        String str1 = ((bwm)localObject2).yew;
        d.g.b.p.g(str1, "poiData.cityName");
        String str2 = ((bwm)localObject2).jGd;
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
          ((fr)localObject3).oV(str1);
          localObject3 = c.xWV;
          c.dKc().oW(String.valueOf(((bwm)localObject2).dzE));
          localObject3 = c.xWV;
          c.dKc().oX(String.valueOf(((bwm)localObject2).dBu));
          break;
        }
      case 4: 
        localObject2 = c.xWV;
        c.dKc().Tw();
        break;
      case 5: 
        label348:
        localObject2 = c.xWV;
        c.dKc().Tx();
      }
    }
    localObject1 = c.xWV;
    c.dKc().kz(i);
    localObject1 = c.xWV;
    c.dKc().kA(j);
    localObject1 = c.xWV;
    localObject1 = c.dKc();
    if (getMoreMenuPlugin().xQk)
    {
      l = 1L;
      ((fr)localObject1).kF(l);
      localObject1 = c.xWV;
      localObject1 = c.dKc();
      localObject2 = getAddMusicPlugin().xNg;
      if (localObject2 == null) {
        break label507;
      }
      i = ((AudioCacheInfo)localObject2).doj;
      localObject2 = AudioCacheInfo.xPl;
      if (i != AudioCacheInfo.dJp()) {
        break label507;
      }
    }
    label507:
    for (long l = 1L;; l = 0L)
    {
      ((fr)localObject1).kE(l);
      AppMethodBeat.o(75790);
      return;
      l = 0L;
      break;
    }
  }
  
  private final void dJY()
  {
    AppMethodBeat.i(75791);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = getCaptureInfo();
    if (localObject != null)
    {
      localObject = ((b)localObject).hwK;
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
      localObject = c.xWV;
      c.dKc().oZ(localStringBuilder.substring(0, i).toString());
    }
    AppMethodBeat.o(75791);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(75787);
    super.a(paramb);
    ae.i("MicroMsg.Image2VideoPluginLayout", "loadCurrentPage info ".concat(String.valueOf(paramb)));
    if (paramb != null)
    {
      Object localObject = this.xWn;
      if (localObject != null)
      {
        d.g.b.p.h(paramb, "info");
        ae.i("MicroMsg.EditPhotoToVideoPlugin", "start preview ".concat(String.valueOf(paramb)));
        ((o)localObject).xQs = paramb;
        ((o)localObject).xQQ.setVisibility(0);
        ((o)localObject).xQQ.setAlpha(0.0F);
        ((o)localObject).xQQ.setCallback((StoryFakeVideoPlayView.a)((o)localObject).xQP);
        ((o)localObject).xQQ.at(paramb.hwK);
        ((o)localObject).dez = paramb.dez;
        ((o)localObject).hwE = paramb.hwE;
      }
      localObject = getReMuxPlugin();
      RecordConfigProvider localRecordConfigProvider = getConfigProvider();
      if (localRecordConfigProvider == null) {
        d.g.b.p.gkB();
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
    if (paramc != d.c.xUM) {
      ae.i("MicroMsg.Image2VideoPluginLayout", "statusChange " + paramc + " ,param : " + paramBundle);
    }
    switch (e.cqt[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
      AppMethodBeat.o(75788);
      return;
    case 1: 
      getItemContainerPlugin().onPause();
      getAddMusicPlugin().onPause();
      if (!getMoreMenuPlugin().xQk) {
        break;
      }
    }
    for (int i = 1;; i = 0)
    {
      paramc = CaptureDataManager.xNV;
      d.g.b.p.g(paramc, "CaptureDataManager.INSTANCE");
      paramc.getExtData().putInt("key_extra_feature_flag", i);
      if (getMoreMenuPlugin().bxN == 2)
      {
        paramc = CaptureDataManager.xNV;
        d.g.b.p.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_group_list", getMoreMenuPlugin().dJJ());
        boolean bool = getAddMusicPlugin().xTd.getMuteOrigin();
        AudioCacheInfo localAudioCacheInfo = getAddMusicPlugin().xNg;
        ArrayList localArrayList1 = h.a(getItemContainerPlugin());
        ArrayList localArrayList2 = getItemContainerPlugin().getEditorDataList();
        float[] arrayOfFloat = getItemContainerPlugin().dJC();
        paramc = this.xWn;
        if (paramc != null)
        {
          paramc = paramc.xQs;
          if (paramc != null)
          {
            paramBundle = paramc.hwK;
            paramc = paramBundle;
            if (paramBundle != null) {
              break label273;
            }
          }
        }
        paramc = new ArrayList();
        label273:
        getItemContainerPlugin();
        paramc = new com.tencent.mm.plugin.recordvideo.b.f(bool, localAudioCacheInfo, localArrayList1, localArrayList2, arrayOfFloat, paramc, h.dJD());
        ae.i("MicroMsg.Image2VideoPluginLayout", "edit config: ".concat(String.valueOf(paramc)));
        getReMuxPlugin().a(paramc);
        paramc = c.xWV;
        c.u("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().dJF()));
        paramc = c.xWV;
        c.u("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().dJG()));
        paramc = c.xWV;
        if (getAddMusicPlugin().xNg != null) {
          break label538;
        }
        i = 0;
        label380:
        c.u("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
        paramc = c.xWV;
        if (!getAddMusicPlugin().xTd.getMuteOrigin()) {
          break label543;
        }
      }
      label538:
      label543:
      for (i = 0;; i = 1)
      {
        c.u("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i));
        paramc = c.xWV;
        c.u("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
        dJX();
        dJY();
        paramc = c.xWV;
        c.Ot(13);
        paramc = c.xWV;
        c.dKc().kw(System.currentTimeMillis());
        paramc = c.xWV;
        paramc = getConfigProvider();
        i = j;
        if (paramc != null) {
          i = paramc.scene;
        }
        c.Ou(i);
        AppMethodBeat.o(75788);
        return;
        if (getMoreMenuPlugin().bxN != 3) {
          break;
        }
        paramc = CaptureDataManager.xNV;
        d.g.b.p.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_black_list", getMoreMenuPlugin().dJJ());
        break;
        i = 1;
        break label380;
      }
      AppMethodBeat.o(75788);
      return;
    }
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(75789);
    Object localObject1;
    int j;
    int i;
    if (!super.aoQ())
    {
      ae.i("MicroMsg.Image2VideoPluginLayout", "onBackPress");
      localObject1 = c.xWV;
      c.u("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject1 = ((Iterable)getItemContainerPlugin().xQe.getAllItemViews()).iterator();
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
          localObject2 = c.xWV;
          c.dKd().TY();
        }
        else if ((!(localObject2 instanceof m)) && ((localObject2 instanceof s)))
        {
          localObject2 = c.xWV;
          c.dKd().Ua();
        }
      }
      localObject1 = c.xWV;
      localObject1 = c.dKd();
      if (!getMoreMenuPlugin().xQk) {
        break label248;
      }
    }
    label248:
    for (long l = 1L;; l = 0L)
    {
      ((gc)localObject1).lH(l);
      localObject1 = c.xWV;
      c.dKd().lD(i);
      localObject1 = c.xWV;
      c.dKd().lE(j);
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
    ae.i("MicroMsg.Image2VideoPluginLayout", "playerView :".concat(String.valueOf(localObject)));
    o localo = new o((StoryFakeVideoPlayView)localObject, (d)this);
    this.xWn = localo;
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