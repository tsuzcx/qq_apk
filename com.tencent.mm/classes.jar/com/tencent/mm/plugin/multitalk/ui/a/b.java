package com.tencent.mm.plugin.multitalk.ui.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.h;
import com.tencent.mm.api.r;
import com.tencent.mm.api.u;
import com.tencent.mm.api.z;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.a.c;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.e;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkScreenEditContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "bgView", "Landroid/view/View;", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "editPencilPlugin", "Lcom/tencent/mm/plugin/multitalk/ui/editor/MultitalkScreenEditPhotoPencilPlugin;", "mHeight", "", "getMHeight", "()I", "setMHeight", "(I)V", "mWidth", "getMWidth", "setMWidth", "multiTalkEditPhotoWrapper", "Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin;", "getMultiTalkEditPhotoWrapper", "()Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "clearScreen", "", "drawBitmap", "initLogic", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "loadDoodle", "onBackPress", "", "onViewStatusChange", "zoom", "", "transX", "transY", "refreshDoodleLayout", "isLand", "refreshEditLayout", "callback", "Lkotlin/Function0;", "setDrawingEnable", "enable", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-multitalk_release"})
public final class b
  extends BasePluginLayout
  implements com.tencent.mm.plugin.recordvideo.plugin.parent.d
{
  public static final b.a zQE;
  public Bitmap bitmap;
  private View cBH;
  public int mHeight;
  public int mWidth;
  private com.tencent.mm.plugin.recordvideo.activity.a wdl;
  private RecordConfigProvider wdm;
  public final d zQB;
  public final a zQC;
  public com.tencent.mm.plugin.multitalk.ui.widget.projector.a zQD;
  private e zQw;
  
  static
  {
    AppMethodBeat.i(239750);
    zQE = new b.a((byte)0);
    AppMethodBeat.o(239750);
  }
  
  public b(Context paramContext, com.tencent.mm.plugin.multitalk.ui.widget.projector.a parama, e parame)
  {
    super(paramContext, null);
    AppMethodBeat.i(239749);
    this.zQD = parama;
    this.zQw = parame;
    this.cBH = View.inflate(paramContext, 2131496163, (ViewGroup)this);
    this.zQB = new d((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramContext = findViewById(2131307304);
    p.g(paramContext, "findViewById(R.id.screen_preview_plugin)");
    this.zQC = new a((FrameLayout)paramContext, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this, this.zQw);
    getPluginList().add(this.zQB);
    getPluginList().add(this.zQC);
    AppMethodBeat.o(239749);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(239745);
    super.a(paramb);
    if (paramb != null)
    {
      if (paramb.rect != null) {
        this.zQC.b(paramb);
      }
      AppMethodBeat.o(239745);
      return;
    }
    AppMethodBeat.o(239745);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(239744);
    p.h(parama, "navigator");
    p.h(paramRecordConfigProvider, "configProvider");
    Log.i("MicroMsg.MultiTalkScreenEditContainerPlugin", "configProvider ".concat(String.valueOf(paramRecordConfigProvider)));
    this.wdl = parama;
    this.wdm = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.e.c.Cic;
    com.tencent.mm.plugin.recordvideo.e.c.d(paramRecordConfigProvider);
    parama = ((Iterable)getPluginList()).iterator();
    if (parama.hasNext())
    {
      com.tencent.mm.plugin.recordvideo.plugin.t localt = (com.tencent.mm.plugin.recordvideo.plugin.t)parama.next();
      Object localObject = paramRecordConfigProvider.BOn;
      boolean bool;
      if (localObject != null)
      {
        localObject = ((UICustomParam)localObject).gLL;
        if (localObject != null)
        {
          localObject = (Boolean)((Map)localObject).get(localt.name());
          if (localObject != null)
          {
            bool = ((Boolean)localObject).booleanValue();
            label136:
            if (bool) {
              break label166;
            }
            i = 1;
            label143:
            if (i == 0) {
              break label171;
            }
          }
        }
      }
      label166:
      label171:
      for (int i = 0;; i = 8)
      {
        localt.setVisibility(i);
        break;
        bool = false;
        break label136;
        i = 0;
        break label143;
      }
    }
    AppMethodBeat.o(239744);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(239746);
    p.h(paramc, "status");
    Log.i("MicroMsg.MultiTalkScreenEditContainerPlugin", "status :" + paramc + " , param :" + paramBundle);
    switch (c.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(239746);
      return;
      onBackPress();
      AppMethodBeat.o(239746);
      return;
      AppMethodBeat.o(239746);
      return;
      AppMethodBeat.o(239746);
      return;
      AppMethodBeat.o(239746);
      return;
      Object localObject;
      if (paramBundle != null)
      {
        paramBundle = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO");
        if (paramBundle != null)
        {
          paramc = this.zQC;
          p.g(paramBundle, "this");
          paramBundle = (r)paramBundle;
          p.h(paramBundle, "emojiInfo");
          localObject = paramc.zQp;
          if (localObject != null) {
            ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener().a(h.diI);
          }
          paramc = paramc.zQp;
          if (paramc != null)
          {
            paramc.c(paramBundle);
            AppMethodBeat.o(239746);
            return;
          }
          AppMethodBeat.o(239746);
          return;
        }
      }
      AppMethodBeat.o(239746);
      return;
      this.zQC.reset();
      AppMethodBeat.o(239746);
      return;
      paramc = this.zQC;
      paramc.zQt = h.diK;
      paramc.sTB = 0;
      paramBundle = paramc.zQp;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(h.diK);
      }
      paramc = paramc.zQp;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(h.diK, 0, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_CLICK_MOSAIC_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.VH(8);
      AppMethodBeat.o(239746);
      return;
      paramc = this.zQC;
      paramc.zQt = h.diK;
      paramc.sTB = 1;
      paramBundle = paramc.zQp;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(h.diK);
      }
      paramc = paramc.zQp;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(h.diK, 1, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_CLICK_BRUSH_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.VH(9);
      AppMethodBeat.o(239746);
      return;
      int i;
      if (paramBundle != null)
      {
        paramc = this.zQC;
        i = paramBundle.getInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT");
        paramc.zQt = h.diH;
        paramc.sTB = i;
        paramBundle = paramc.zQp;
        if (paramBundle != null) {
          paramBundle.getSelectedFeatureListener().a(h.diH);
        }
        paramc = paramc.zQp;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(h.diH, i, null);
          AppMethodBeat.o(239746);
          return;
        }
        AppMethodBeat.o(239746);
        return;
      }
      AppMethodBeat.o(239746);
      return;
      paramc = this.zQC;
      paramBundle = paramc.zQp;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.cache.c.alF().alG(), -1, null);
      }
      paramBundle = paramc.zQp;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(paramc.zQt);
      }
      paramBundle = paramc.zQp;
      if (paramBundle != null)
      {
        paramBundle.getSelectedFeatureListener().a(paramc.zQt, paramc.sTB, null);
        AppMethodBeat.o(239746);
        return;
      }
      AppMethodBeat.o(239746);
      return;
      paramc = this.zQC.zQp;
      if (paramc != null)
      {
        paramc.getSelectedFeatureListener().a(h.diJ);
        AppMethodBeat.o(239746);
        return;
      }
      AppMethodBeat.o(239746);
      return;
      com.tencent.mm.plugin.multitalk.ui.widget.projector.a.b.a(this.zQD, a.c.zVo);
      AppMethodBeat.o(239746);
      return;
      paramc = this.zQC.zQp;
      if (paramc != null)
      {
        paramc.getSelectedFeatureListener().a(h.diI);
        AppMethodBeat.o(239746);
        return;
      }
      AppMethodBeat.o(239746);
      return;
      if (paramBundle != null)
      {
        localObject = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
        i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
        int j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
        paramc = this.zQC;
        paramBundle = (Editable)localObject;
        if (paramBundle == null) {
          p.hyc();
        }
        p.h(paramBundle, "text");
        paramBundle.clearSpans();
        localObject = paramc.zQp;
        if (localObject != null) {
          ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener().a(h.diI);
        }
        localObject = paramc.zQp;
        if (localObject != null) {
          ((com.tencent.mm.bt.b)localObject).a(paramBundle, i, j);
        }
        paramc = paramc.zQr;
        if (paramc != null)
        {
          paramc.invoke();
          AppMethodBeat.o(239746);
          return;
        }
        AppMethodBeat.o(239746);
        return;
      }
      AppMethodBeat.o(239746);
      return;
      paramc = this.zQC;
      if (paramc != null)
      {
        paramc = paramc.zQr;
        if (paramc != null)
        {
          paramc.invoke();
          AppMethodBeat.o(239746);
          return;
        }
        AppMethodBeat.o(239746);
        return;
      }
      AppMethodBeat.o(239746);
      return;
      if (paramBundle != null)
      {
        paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
        paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
        paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
        AppMethodBeat.o(239746);
        return;
      }
      AppMethodBeat.o(239746);
      return;
      paramc = this.zQC;
      if (!paramc.isFinishing)
      {
        paramBundle = paramc.context;
        if (paramBundle == null)
        {
          paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(239746);
          throw paramc;
        }
        if (!((Activity)paramBundle).isFinishing()) {}
      }
      else
      {
        AppMethodBeat.o(239746);
        return;
      }
      paramc.isFinishing = true;
      paramBundle = paramc.zCl;
    } while (paramBundle == null);
    paramBundle.a((u)new a.b(paramc));
    AppMethodBeat.o(239746);
  }
  
  public final Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  public final e getConfig()
  {
    return this.zQw;
  }
  
  protected final RecordConfigProvider getConfigProvider()
  {
    return this.wdm;
  }
  
  public final int getMHeight()
  {
    return this.mHeight;
  }
  
  public final int getMWidth()
  {
    return this.mWidth;
  }
  
  public final a getMultiTalkEditPhotoWrapper()
  {
    return this.zQC;
  }
  
  public final com.tencent.mm.plugin.multitalk.ui.widget.projector.a getStatusManager()
  {
    return this.zQD;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(239747);
    super.onBackPress();
    AppMethodBeat.o(239747);
    return true;
  }
  
  public final void setBitmap(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
  }
  
  public final void setConfig(e parame)
  {
    this.zQw = parame;
  }
  
  protected final void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    this.wdm = paramRecordConfigProvider;
  }
  
  public final void setDrawingEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(239743);
    Object localObject = this.zQC.zQo;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.view.b.b)((com.tencent.mm.view.l)localObject).getBaseBoardView();
      if (localObject != null)
      {
        ((com.tencent.mm.view.b.b)localObject).setTouchEnable(paramBoolean);
        AppMethodBeat.o(239743);
        return;
      }
    }
    AppMethodBeat.o(239743);
  }
  
  public final void setMHeight(int paramInt)
  {
    this.mHeight = paramInt;
  }
  
  public final void setMWidth(int paramInt)
  {
    this.mWidth = paramInt;
  }
  
  public final void setStatusManager(com.tencent.mm.plugin.multitalk.ui.widget.projector.a parama)
  {
    AppMethodBeat.i(239748);
    p.h(parama, "<set-?>");
    this.zQD = parama;
    AppMethodBeat.o(239748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.a.b
 * JD-Core Version:    0.7.0.1
 */