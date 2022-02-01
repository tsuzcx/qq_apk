package com.tencent.mm.plugin.multitalk.ui.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.h;
import com.tencent.mm.api.r;
import com.tencent.mm.api.z;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.a.c;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.e;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkScreenEditContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "bgView", "Landroid/view/View;", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "editPencilPlugin", "Lcom/tencent/mm/plugin/multitalk/ui/editor/MultitalkScreenEditPhotoPencilPlugin;", "mHeight", "", "getMHeight", "()I", "setMHeight", "(I)V", "mWidth", "getMWidth", "setMWidth", "multiTalkEditPhotoWrapper", "Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin;", "getMultiTalkEditPhotoWrapper", "()Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "clearScreen", "", "drawBitmap", "initLogic", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "loadDoodle", "onBackPress", "", "onViewStatusChange", "zoom", "", "transX", "transY", "refreshDoodleLayout", "isLand", "refreshEditLayout", "callback", "Lkotlin/Function0;", "setDrawingEnable", "enable", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-multitalk_release"})
public final class b
  extends BasePluginLayout
  implements com.tencent.mm.plugin.recordvideo.plugin.parent.d
{
  public static final a Fwh;
  private com.tencent.mm.plugin.recordvideo.activity.a ALU;
  private RecordConfigProvider ALV;
  private e FvZ;
  public final d Fwe;
  public final a Fwf;
  public com.tencent.mm.plugin.multitalk.ui.widget.projector.a Fwg;
  public Bitmap bitmap;
  private View cCj;
  public int mHeight;
  public int mWidth;
  
  static
  {
    AppMethodBeat.i(199476);
    Fwh = new a((byte)0);
    AppMethodBeat.o(199476);
  }
  
  public b(Context paramContext, com.tencent.mm.plugin.multitalk.ui.widget.projector.a parama, e parame)
  {
    super(paramContext, null);
    AppMethodBeat.i(199475);
    this.Fwg = parama;
    this.FvZ = parame;
    this.cCj = View.inflate(paramContext, b.f.screen_edit_plugin_layout, (ViewGroup)this);
    this.Fwe = new d((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramContext = findViewById(b.e.screen_preview_plugin);
    p.j(paramContext, "findViewById(R.id.screen_preview_plugin)");
    this.Fwf = new a((FrameLayout)paramContext, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this, this.FvZ);
    getPluginList().add(this.Fwe);
    getPluginList().add(this.Fwf);
    AppMethodBeat.o(199475);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(199452);
    super.a(paramb);
    if (paramb != null)
    {
      if (paramb.byG != null) {
        this.Fwf.b(paramb);
      }
      AppMethodBeat.o(199452);
      return;
    }
    AppMethodBeat.o(199452);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(199448);
    p.k(parama, "navigator");
    p.k(paramRecordConfigProvider, "configProvider");
    Log.i("MicroMsg.MultiTalkScreenEditContainerPlugin", "configProvider ".concat(String.valueOf(paramRecordConfigProvider)));
    this.ALU = parama;
    this.ALV = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.e.d.IeU;
    com.tencent.mm.plugin.recordvideo.e.d.f(paramRecordConfigProvider);
    parama = ((Iterable)getPluginList()).iterator();
    if (parama.hasNext())
    {
      com.tencent.mm.plugin.recordvideo.plugin.u localu = (com.tencent.mm.plugin.recordvideo.plugin.u)parama.next();
      Object localObject = paramRecordConfigProvider.HKT;
      boolean bool;
      if (localObject != null)
      {
        localObject = ((UICustomParam)localObject).jwa;
        if (localObject != null)
        {
          localObject = (Boolean)((Map)localObject).get(localu.name());
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
        localu.setVisibility(i);
        break;
        bool = false;
        break label136;
        i = 0;
        break label143;
      }
    }
    AppMethodBeat.o(199448);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    com.tencent.mm.ca.b localb = null;
    AppMethodBeat.i(199455);
    p.k(paramc, "status");
    Log.i("MicroMsg.MultiTalkScreenEditContainerPlugin", "status :" + paramc + " , param :" + paramBundle);
    switch (c.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(199455);
      return;
      onBackPress();
      AppMethodBeat.o(199455);
      return;
      AppMethodBeat.o(199455);
      return;
      AppMethodBeat.o(199455);
      return;
      AppMethodBeat.o(199455);
      return;
      if (paramBundle != null)
      {
        paramBundle = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO");
        if (paramBundle != null)
        {
          paramc = this.Fwf;
          p.j(paramBundle, "this");
          paramBundle = (r)paramBundle;
          p.k(paramBundle, "emojiInfo");
          localb = paramc.FvS;
          if (localb != null) {
            localb.getSelectedFeatureListener().a(h.fao);
          }
          paramc = paramc.FvS;
          if (paramc != null)
          {
            paramc.c(paramBundle);
            AppMethodBeat.o(199455);
            return;
          }
          AppMethodBeat.o(199455);
          return;
        }
      }
      AppMethodBeat.o(199455);
      return;
      this.Fwf.reset();
      AppMethodBeat.o(199455);
      return;
      paramc = this.Fwf;
      paramc.FvW = h.faq;
      paramc.wzx = 0;
      paramBundle = paramc.FvS;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(h.faq);
      }
      paramc = paramc.FvS;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(h.faq, 0, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.aVY("KEY_CLICK_MOSAIC_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.acq(8);
      AppMethodBeat.o(199455);
      return;
      paramc = this.Fwf;
      paramc.FvW = h.faq;
      paramc.wzx = 1;
      paramBundle = paramc.FvS;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(h.faq);
      }
      paramc = paramc.FvS;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(h.faq, 1, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.aVY("KEY_CLICK_BRUSH_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.acq(9);
      AppMethodBeat.o(199455);
      return;
      int i;
      if (paramBundle != null)
      {
        paramc = this.Fwf;
        i = paramBundle.getInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT");
        paramc.FvW = h.fan;
        paramc.wzx = i;
        paramBundle = paramc.FvS;
        if (paramBundle != null) {
          paramBundle.getSelectedFeatureListener().a(h.fan);
        }
        paramc = paramc.FvS;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(h.fan, i, null);
          AppMethodBeat.o(199455);
          return;
        }
        AppMethodBeat.o(199455);
        return;
      }
      AppMethodBeat.o(199455);
      return;
      paramc = this.Fwf;
      paramBundle = paramc.FvS;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.cache.c.arE().arF(), -1, null);
      }
      paramBundle = paramc.FvS;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(paramc.FvW);
      }
      paramBundle = paramc.FvS;
      if (paramBundle != null)
      {
        paramBundle.getSelectedFeatureListener().a(paramc.FvW, paramc.wzx, null);
        AppMethodBeat.o(199455);
        return;
      }
      AppMethodBeat.o(199455);
      return;
      paramc = this.Fwf.FvS;
      if (paramc != null)
      {
        paramc.getSelectedFeatureListener().a(h.fap);
        AppMethodBeat.o(199455);
        return;
      }
      AppMethodBeat.o(199455);
      return;
      com.tencent.mm.plugin.multitalk.ui.widget.projector.a.b.a(this.Fwg, a.c.FAY);
      AppMethodBeat.o(199455);
      return;
      paramc = this.Fwf.FvS;
      if (paramc != null)
      {
        paramc.getSelectedFeatureListener().a(h.fao);
        AppMethodBeat.o(199455);
        return;
      }
      AppMethodBeat.o(199455);
      return;
      if (paramBundle != null)
      {
        CharSequence localCharSequence = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
        i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
        int j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
        paramBundle = this.Fwf;
        paramc = localb;
        if (localCharSequence != null) {
          paramc = localCharSequence.toString();
        }
        localb = paramBundle.FvS;
        if (localb != null) {
          localb.getSelectedFeatureListener().a(h.fao);
        }
        localb = paramBundle.FvS;
        if (localb != null) {
          localb.aQ(paramc, i, j);
        }
        paramc = paramBundle.FvU;
        if (paramc != null)
        {
          paramc.invoke();
          AppMethodBeat.o(199455);
          return;
        }
        AppMethodBeat.o(199455);
        return;
      }
      AppMethodBeat.o(199455);
      return;
      paramc = this.Fwf;
      if (paramc != null)
      {
        paramc = paramc.FvU;
        if (paramc != null)
        {
          paramc.invoke();
          AppMethodBeat.o(199455);
          return;
        }
        AppMethodBeat.o(199455);
        return;
      }
      AppMethodBeat.o(199455);
      return;
      if (paramBundle != null)
      {
        paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
        paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
        paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
        AppMethodBeat.o(199455);
        return;
      }
      AppMethodBeat.o(199455);
      return;
      paramc = this.Fwf;
      if (!paramc.isFinishing)
      {
        paramBundle = paramc.context;
        if (paramBundle == null)
        {
          paramc = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(199455);
          throw paramc;
        }
        if (!((Activity)paramBundle).isFinishing()) {}
      }
      else
      {
        AppMethodBeat.o(199455);
        return;
      }
      paramc.isFinishing = true;
      paramBundle = paramc.Fhh;
    } while (paramBundle == null);
    paramBundle.a((com.tencent.mm.api.u)new a.b(paramc));
    AppMethodBeat.o(199455);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.plugin.u paramu)
  {
    AppMethodBeat.i(199478);
    p.k(paramu, "plugin");
    p.k(paramu, "plugin");
    AppMethodBeat.o(199478);
  }
  
  public final Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  public final e getConfig()
  {
    return this.FvZ;
  }
  
  protected final RecordConfigProvider getConfigProvider()
  {
    return this.ALV;
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
    return this.Fwf;
  }
  
  public final com.tencent.mm.plugin.multitalk.ui.widget.projector.a getStatusManager()
  {
    return this.Fwg;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(199458);
    super.onBackPress();
    AppMethodBeat.o(199458);
    return true;
  }
  
  public final void setBitmap(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
  }
  
  public final void setConfig(e parame)
  {
    this.FvZ = parame;
  }
  
  protected final void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    this.ALV = paramRecordConfigProvider;
  }
  
  public final void setDrawingEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(199443);
    Object localObject = this.Fwf.FvR;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.view.b.b)((com.tencent.mm.view.l)localObject).getBaseBoardView();
      if (localObject != null)
      {
        ((com.tencent.mm.view.b.b)localObject).setTouchEnable(paramBoolean);
        AppMethodBeat.o(199443);
        return;
      }
    }
    AppMethodBeat.o(199443);
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
    AppMethodBeat.i(199468);
    p.k(parama, "<set-?>");
    this.Fwg = parama;
    AppMethodBeat.o(199468);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkScreenEditContainerPlugin$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.a.b
 * JD-Core Version:    0.7.0.1
 */