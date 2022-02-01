package com.tencent.mm.plugin.multitalk.ui.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.i;
import com.tencent.mm.api.t;
import com.tencent.mm.api.w;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.e;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.util.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.view.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkScreenEditContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "bgView", "Landroid/view/View;", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "editPencilPlugin", "Lcom/tencent/mm/plugin/multitalk/ui/editor/MultitalkScreenEditPhotoPencilPlugin;", "mHeight", "", "getMHeight", "()I", "setMHeight", "(I)V", "mWidth", "getMWidth", "setMWidth", "multiTalkEditPhotoWrapper", "Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin;", "getMultiTalkEditPhotoWrapper", "()Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "clearScreen", "", "drawBitmap", "initLogic", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "loadDoodle", "onBackPress", "", "onViewStatusChange", "zoom", "", "transX", "transY", "refreshDoodleLayout", "isLand", "refreshEditLayout", "callback", "Lkotlin/Function0;", "setDrawingEnable", "enable", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends BasePluginLayout
  implements com.tencent.mm.plugin.recordvideo.plugin.parent.a
{
  public static final b.a Lsp;
  private View AhP;
  private com.tencent.mm.plugin.recordvideo.activity.a Fiu;
  private e Lsc;
  public com.tencent.mm.plugin.multitalk.ui.widget.projector.a Lsq;
  public final c Lsr;
  public final a Lss;
  public Bitmap bitmap;
  public int mHeight;
  public int mWidth;
  private RecordConfigProvider oaV;
  
  static
  {
    AppMethodBeat.i(285314);
    Lsp = new b.a((byte)0);
    AppMethodBeat.o(285314);
  }
  
  public b(Context paramContext, com.tencent.mm.plugin.multitalk.ui.widget.projector.a parama, e parame)
  {
    super(paramContext, null);
    AppMethodBeat.i(285308);
    this.Lsq = parama;
    this.Lsc = parame;
    this.AhP = View.inflate(paramContext, b.f.screen_edit_plugin_layout, (ViewGroup)this);
    this.Lsr = new c((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
    paramContext = findViewById(b.e.screen_preview_plugin);
    s.s(paramContext, "findViewById(R.id.screen_preview_plugin)");
    this.Lss = new a((FrameLayout)paramContext, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this, this.Lsc);
    getPluginList().add(this.Lsr);
    getPluginList().add(this.Lss);
    AppMethodBeat.o(285308);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(285374);
    super.a(paramb);
    if ((paramb != null) && (paramb.rect != null)) {
      getMultiTalkEditPhotoWrapper().b(paramb);
    }
    AppMethodBeat.o(285374);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(285367);
    s.u(parama, "navigator");
    s.u(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    Log.i("MicroMsg.MultiTalkScreenEditContainerPlugin", s.X("configProvider ", paramRecordConfigProvider));
    this.Fiu = parama;
    this.oaV = paramRecordConfigProvider;
    parama = f.Obq;
    f.k(paramRecordConfigProvider);
    parama = ((Iterable)getPluginList()).iterator();
    if (parama.hasNext())
    {
      v localv = (v)parama.next();
      Object localObject = paramRecordConfigProvider.NHR;
      boolean bool;
      if (localObject == null)
      {
        bool = false;
        label99:
        if (bool) {
          break label181;
        }
        i = 1;
        label106:
        if (i == 0) {
          break label186;
        }
      }
      label181:
      label186:
      for (int i = 0;; i = 8)
      {
        localv.setVisibility(i);
        break;
        localObject = ((UICustomParam)localObject).lZs;
        if (localObject == null)
        {
          bool = false;
          break label99;
        }
        localObject = (Boolean)((Map)localObject).get(localv.name());
        if (localObject == null)
        {
          bool = false;
          break label99;
        }
        bool = ((Boolean)localObject).booleanValue();
        break label99;
        i = 0;
        break label106;
      }
    }
    AppMethodBeat.o(285367);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.plugin.parent.a.c paramc, Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(285394);
    s.u(paramc, "status");
    Log.i("MicroMsg.MultiTalkScreenEditContainerPlugin", "status :" + paramc + " , param :" + paramBundle);
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(285394);
      return;
      onBackPress();
      AppMethodBeat.o(285394);
      return;
      AppMethodBeat.o(285394);
      return;
      AppMethodBeat.o(285394);
      return;
      AppMethodBeat.o(285394);
      return;
      if (paramBundle != null)
      {
        paramBundle = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO");
        if (paramBundle != null)
        {
          paramc = getMultiTalkEditPhotoWrapper();
          paramBundle = (t)paramBundle;
          s.u(paramBundle, "emojiInfo");
          localObject = paramc.Lsg;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
            if (localObject != null) {
              ((aa)localObject).a(i.hdP);
            }
          }
          paramc = paramc.Lsg;
          if (paramc != null) {
            paramc.d(paramBundle);
          }
          AppMethodBeat.o(285394);
          return;
          this.Lss.reset();
          AppMethodBeat.o(285394);
          return;
          paramc = this.Lss;
          paramc.Lsk = i.hdR;
          paramc.zVI = 0;
          paramBundle = paramc.Lsg;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.getSelectedFeatureListener();
            if (paramBundle != null) {
              paramBundle.a(i.hdR);
            }
          }
          paramc = paramc.Lsg;
          if (paramc != null)
          {
            paramc = paramc.getSelectedFeatureListener();
            if (paramc != null) {
              paramc.a(i.hdR, 0, null);
            }
          }
          paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.aTg("KEY_CLICK_MOSAIC_COUNT_INT");
          paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.agG(8);
          AppMethodBeat.o(285394);
          return;
          paramc = this.Lss;
          paramc.Lsk = i.hdR;
          paramc.zVI = 1;
          paramBundle = paramc.Lsg;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.getSelectedFeatureListener();
            if (paramBundle != null) {
              paramBundle.a(i.hdR);
            }
          }
          paramc = paramc.Lsg;
          if (paramc != null)
          {
            paramc = paramc.getSelectedFeatureListener();
            if (paramc != null) {
              paramc.a(i.hdR, 1, null);
            }
          }
          paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.aTg("KEY_CLICK_BRUSH_COUNT_INT");
          paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.agG(9);
          AppMethodBeat.o(285394);
          return;
          if (paramBundle != null)
          {
            paramc = getMultiTalkEditPhotoWrapper();
            int i = paramBundle.getInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT");
            paramc.Lsk = i.hdO;
            paramc.zVI = i;
            paramBundle = paramc.Lsg;
            if (paramBundle != null)
            {
              paramBundle = paramBundle.getSelectedFeatureListener();
              if (paramBundle != null) {
                paramBundle.a(i.hdO);
              }
            }
            paramc = paramc.Lsg;
            if (paramc != null)
            {
              paramc = paramc.getSelectedFeatureListener();
              if (paramc != null) {
                paramc.a(i.hdO, i, null);
              }
            }
            AppMethodBeat.o(285394);
            return;
            paramc = this.Lss;
            paramBundle = paramc.Lsg;
            if (paramBundle != null)
            {
              paramBundle = paramBundle.getSelectedFeatureListener();
              if (paramBundle != null) {
                paramBundle.a(com.tencent.mm.cache.c.aLA().aLB(), -1, null);
              }
            }
            paramBundle = paramc.Lsg;
            if (paramBundle != null)
            {
              paramBundle = paramBundle.getSelectedFeatureListener();
              if (paramBundle != null) {
                paramBundle.a(paramc.Lsk);
              }
            }
            paramBundle = paramc.Lsg;
            if (paramBundle != null)
            {
              paramBundle = paramBundle.getSelectedFeatureListener();
              if (paramBundle != null) {
                paramBundle.a(paramc.Lsk, paramc.zVI, null);
              }
            }
            AppMethodBeat.o(285394);
            return;
            paramc = this.Lss.Lsg;
            if (paramc != null)
            {
              paramc = paramc.getSelectedFeatureListener();
              if (paramc != null) {
                paramc.a(i.hdQ);
              }
            }
            AppMethodBeat.o(285394);
            return;
            com.tencent.mm.plugin.multitalk.ui.widget.projector.a.b.a(this.Lsq, com.tencent.mm.plugin.multitalk.ui.widget.projector.a.c.Lxa);
            AppMethodBeat.o(285394);
            return;
            paramc = this.Lss.Lsg;
            if (paramc != null)
            {
              paramc = paramc.getSelectedFeatureListener();
              if (paramc != null) {
                paramc.a(i.hdP);
              }
            }
            AppMethodBeat.o(285394);
            return;
            if (paramBundle != null)
            {
              paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
              i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
              int j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
              paramBundle = getMultiTalkEditPhotoWrapper();
              if (paramc == null) {}
              for (paramc = (com.tencent.mm.plugin.recordvideo.plugin.parent.a.c)localObject;; paramc = paramc.toString())
              {
                localObject = paramBundle.Lsg;
                if (localObject != null)
                {
                  localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
                  if (localObject != null) {
                    ((aa)localObject).a(i.hdP);
                  }
                }
                localObject = paramBundle.Lsg;
                if (localObject != null) {
                  ((com.tencent.mm.bt.b)localObject).aY(paramc, i, j);
                }
                paramc = paramBundle.Lsi;
                if (paramc != null) {
                  paramc.invoke();
                }
                AppMethodBeat.o(285394);
                return;
              }
              paramc = this.Lss;
              if (paramc != null)
              {
                paramc = paramc.Lsi;
                if (paramc != null) {
                  paramc.invoke();
                }
                AppMethodBeat.o(285394);
                return;
                if (paramBundle != null)
                {
                  paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
                  paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
                  paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
                  AppMethodBeat.o(285394);
                  return;
                  paramc = this.Lss;
                  if (!paramc.isFinishing)
                  {
                    paramBundle = paramc.context;
                    if (paramBundle == null)
                    {
                      paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                      AppMethodBeat.o(285394);
                      throw paramc;
                    }
                    if (!((Activity)paramBundle).isFinishing()) {}
                  }
                  else
                  {
                    AppMethodBeat.o(285394);
                    return;
                  }
                  paramc.isFinishing = true;
                  paramBundle = paramc.LcI;
                  if (paramBundle != null) {
                    paramBundle.a((w)new a.b(paramc));
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void a(v paramv)
  {
    AppMethodBeat.i(285426);
    com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this, paramv);
    AppMethodBeat.o(285426);
  }
  
  public final Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  public final e getConfig()
  {
    return this.Lsc;
  }
  
  protected final RecordConfigProvider getConfigProvider()
  {
    return this.oaV;
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
    return this.Lss;
  }
  
  public final com.tencent.mm.plugin.multitalk.ui.widget.projector.a getStatusManager()
  {
    return this.Lsq;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(285399);
    super.onBackPress();
    AppMethodBeat.o(285399);
    return true;
  }
  
  public final void setBitmap(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
  }
  
  public final void setConfig(e parame)
  {
    this.Lsc = parame;
  }
  
  protected final void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    this.oaV = paramRecordConfigProvider;
  }
  
  public final void setDrawingEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(285360);
    Object localObject = this.Lss.Lsf;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.view.b.b)((l)localObject).getBaseBoardView();
      if (localObject != null) {
        ((com.tencent.mm.view.b.b)localObject).setTouchEnable(paramBoolean);
      }
    }
    AppMethodBeat.o(285360);
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
    AppMethodBeat.i(285330);
    s.u(parama, "<set-?>");
    this.Lsq = parama;
    AppMethodBeat.o(285330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.a.b
 * JD-Core Version:    0.7.0.1
 */