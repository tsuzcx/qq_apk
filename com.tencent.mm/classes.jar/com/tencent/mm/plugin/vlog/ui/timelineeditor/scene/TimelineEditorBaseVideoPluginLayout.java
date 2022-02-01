package com.tencent.mm.plugin.vlog.ui.timelineeditor.scene;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.AutoRegisterPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.a.e;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.g;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.ui.plugin.ad;
import com.tencent.mm.plugin.vlog.ui.plugin.ag;
import com.tencent.mm.plugin.vlog.ui.plugin.ai;
import com.tencent.mm.plugin.vlog.ui.plugin.d.d;
import com.tencent.mm.plugin.vlog.ui.plugin.d.d.a;
import com.tencent.mm.plugin.vlog.ui.plugin.d.e;
import com.tencent.mm.plugin.vlog.ui.plugin.timeedit.TimeEditorItemContainer;
import com.tencent.mm.plugin.vlog.ui.plugin.u;
import com.tencent.mm.plugin.vlog.ui.plugin.u.a;
import com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackCropView;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.b.c;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.view.TimelineEditorDragRectView;
import com.tencent.mm.plugin.vlog.ui.widget.CropOperationContainer;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.timelineedit.TimelineEditor;
import com.tencent.mm.timelineedit.TimelineEditor.Companion;
import com.tencent.mm.timelineedit.TimelineEditor.i;
import com.tencent.mm.timelineedit.TimelineEditor.j;
import com.tencent.mm.timelineedit.TimelineEditor.o;
import com.tencent.mm.timelineedit.TimelineEditor.p;
import com.tencent.mm.timelineedit.a.a.q;
import com.tencent.mm.timelineedit.a.c;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.IStickerDecoderFactory;
import com.tencent.mm.xeffect.effect.StickerDecoderFactoryWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.g.b.aa.e;
import kotlin.g.b.aa.f;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorBaseVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/AutoRegisterPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bottomLayout", "Landroid/view/ViewGroup;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "editId", "", "getEditId", "()Ljava/lang/String;", "setEditId", "(Ljava/lang/String;)V", "headLayout", "isMediaMute", "", "()Z", "setMediaMute", "(Z)V", "maxCropVideoDurationMs", "", "getMaxCropVideoDurationMs", "()J", "setMaxCropVideoDurationMs", "(J)V", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "pluginLayout", "getPluginLayout", "()Landroid/view/ViewGroup;", "editSingleTrack", "getCurrentTrack", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "getCurrentTrackPlayRange", "Lcom/tencent/mm/timelineedit/model/TimeRange;", "hideOperation", "", "initLogic", "initPlugin", "initPluginLogic", "initPluginStyle", "isPlaying", "loadCurrentPage", "model", "logTag", "onBackPress", "pauseVideo", "release", "reset", "resumeVideo", "seekTo", "(Ljava/lang/Long;)V", "setSingleTrackPlayRange", "seekStart", "showOperation", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-vlog_release"})
public class TimelineEditorBaseVideoPluginLayout
  extends AutoRegisterPluginLayout
{
  public static final a NEP;
  private com.tencent.mm.plugin.recordvideo.activity.a ALU;
  private RecordConfigProvider ALV;
  private com.tencent.mm.media.widget.camerarecordview.b.b HNh;
  private final ViewGroup NEM;
  private final ViewGroup NEN;
  private final ViewGroup NEO;
  private boolean NrL;
  private long Nrw;
  private String editId;
  
  static
  {
    AppMethodBeat.i(233646);
    NEP = new a((byte)0);
    AppMethodBeat.o(233646);
  }
  
  public TimelineEditorBaseVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(233645);
    this.editId = "";
    this.Nrw = 60000L;
    Log.i(gwK(), "create TimelineEditorVideoPluginLayout instance[" + hashCode() + ']');
    paramAttributeSet = ((Activity)paramContext).findViewById(a.f.record_ui_root);
    kotlin.g.b.p.j(paramAttributeSet, "(context as Activity).fi…oup>(R.id.record_ui_root)");
    if (((ViewGroup)paramAttributeSet).getChildCount() == 0)
    {
      paramAttributeSet = ((Activity)paramContext).getWindow();
      kotlin.g.b.p.j(paramAttributeSet, "context.window");
      paramAttributeSet = paramAttributeSet.getDecorView().findViewById(16908290);
      kotlin.g.b.p.j(paramAttributeSet, "context.window.decorView…up>(android.R.id.content)");
      ((ViewGroup)paramAttributeSet).setAlpha(0.0F);
    }
    LayoutInflater.from(paramContext).inflate(a.g.timeline_editor_plugin_layout, (ViewGroup)this, true);
    ((Activity)paramContext).getWindow().setSoftInputMode(48);
    paramContext = findViewById(a.f.plugin_layout);
    ((InsectRelativeLayout)paramContext).setDiscardKeyboard(true);
    kotlin.g.b.p.j(paramContext, "findViewById<InsectRelat…Keyboard = true\n        }");
    this.NEM = ((ViewGroup)paramContext);
    paramContext = findViewById(a.f.timeline_editor_bottom_layout);
    kotlin.g.b.p.j(paramContext, "findViewById(R.id.timeline_editor_bottom_layout)");
    this.NEN = ((ViewGroup)paramContext);
    paramContext = findViewById(a.f.timeline_editor_head_layout);
    kotlin.g.b.p.j(paramContext, "findViewById(R.id.timeline_editor_head_layout)");
    this.NEO = ((ViewGroup)paramContext);
    AppMethodBeat.o(233645);
  }
  
  private final com.tencent.mm.timelineedit.a.f getCurrentTrackPlayRange()
  {
    AppMethodBeat.i(233637);
    Object localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.p)bp(com.tencent.mm.plugin.vlog.ui.plugin.p.class);
    int i;
    Object localObject3;
    Object localObject2;
    if (localObject1 != null)
    {
      i = ((com.tencent.mm.plugin.vlog.ui.plugin.p)localObject1).Nmo;
      if (i >= 0)
      {
        localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (localObject1 != null)
        {
          localObject3 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).NmT;
          if (localObject3 != null)
          {
            localObject2 = (com.tencent.mm.videocomposition.b)((List)((com.tencent.mm.videocomposition.j)localObject3).MQY).get(i);
            localObject1 = new com.tencent.mm.timelineedit.a.f(((com.tencent.mm.videocomposition.b)localObject2).startTimeMs, ((com.tencent.mm.videocomposition.b)localObject2).endTimeMs);
            if (!((com.tencent.mm.videocomposition.b)localObject2).MQX.isValid()) {
              break label257;
            }
            localObject1 = new com.tencent.mm.timelineedit.a.f(((com.tencent.mm.timelineedit.a.f)localObject1).startTimeMs - ((com.tencent.mm.videocomposition.b)localObject2).MQX.duration / 2L, ((com.tencent.mm.timelineedit.a.f)localObject1).endTimeMs);
          }
        }
      }
    }
    label257:
    for (;;)
    {
      localObject2 = localObject1;
      if (i + 1 < ((List)((com.tencent.mm.videocomposition.j)localObject3).MQY).size())
      {
        localObject3 = (com.tencent.mm.videocomposition.b)((List)((com.tencent.mm.videocomposition.j)localObject3).MQY).get(i + 1);
        localObject2 = localObject1;
        if (((com.tencent.mm.videocomposition.b)localObject3).MQX.isValid())
        {
          long l1 = ((com.tencent.mm.timelineedit.a.f)localObject1).startTimeMs;
          long l2 = ((com.tencent.mm.timelineedit.a.f)localObject1).endTimeMs;
          localObject2 = new com.tencent.mm.timelineedit.a.f(l1, ((com.tencent.mm.videocomposition.b)localObject3).MQX.duration / 2L + l2);
        }
      }
      AppMethodBeat.o(233637);
      return localObject2;
      AppMethodBeat.o(233637);
      return null;
    }
  }
  
  private final void setSingleTrackPlayRange(boolean paramBoolean)
  {
    AppMethodBeat.i(233633);
    com.tencent.mm.timelineedit.a.f localf = getCurrentTrackPlayRange();
    if (localf != null)
    {
      com.tencent.mm.plugin.vlog.ui.timelineeditor.f localf1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
      if (localf1 != null) {
        localf1.aG(localf.startTimeMs, localf.endTimeMs);
      }
      if (paramBoolean)
      {
        localf1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
        if (localf1 != null)
        {
          localf1.seek(localf.startTimeMs);
          AppMethodBeat.o(233633);
          return;
        }
      }
      AppMethodBeat.o(233633);
      return;
    }
    AppMethodBeat.o(233633);
  }
  
  public void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(233603);
    Log.i(gwK(), "loadCurrentPage time:" + System.currentTimeMillis() + " model:" + paramb);
    super.a(paramb);
    Object localObject1 = new StringBuilder();
    kotlin.g.b.p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
    this.editId = (com.tencent.mm.kernel.b.aGq() + '_' + Util.nowMilliSecond());
    this.HNh = paramb;
    com.tencent.mm.plugin.vlog.ui.timelineeditor.e locale = (com.tencent.mm.plugin.vlog.ui.timelineeditor.e)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.e.class);
    Object localObject3;
    float f1;
    if (locale != null)
    {
      localObject1 = this.ALU;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      localObject3 = this.ALV;
      if (localObject3 == null) {
        kotlin.g.b.p.iCn();
      }
      kotlin.g.b.p.k(localObject1, "navigator");
      kotlin.g.b.p.k(localObject3, "configProvider");
      localObject1 = ((RecordConfigProvider)localObject3).mab;
      if (localObject1 == null) {
        break label1088;
      }
      localObject1 = ((Bundle)localObject1).getParcelableArrayList("media_list");
      if (localObject1 == null) {
        break label1088;
      }
      kotlin.g.b.p.j(localObject1, "list");
      localObject3 = (GalleryItem.MediaItem)kotlin.a.j.lo((List)localObject1);
      kotlin.g.b.p.j(localObject3, "firstMediaItem");
      if (((GalleryItem.MediaItem)localObject3).getType() != 2) {
        break label1061;
      }
      localObject3 = com.tencent.mm.plugin.gallery.a.d.CeY;
      localObject1 = com.tencent.mm.plugin.gallery.a.d.aFG(((GalleryItem.MediaItem)kotlin.a.j.lo((List)localObject1)).AAz);
      f1 = ((com.tencent.mm.plugin.sight.base.b)localObject1).width / ((com.tencent.mm.plugin.sight.base.b)localObject1).height;
    }
    for (;;)
    {
      localObject1 = ar.au(locale.context);
      int i = ((Point)localObject1).x;
      int j = ((Point)localObject1).y;
      new Size(i, j);
      int k = ((Point)localObject1).x;
      k = ((Point)localObject1).y;
      localObject1 = com.tencent.mm.plugin.vlog.util.a.NGN;
      localObject1 = com.tencent.mm.plugin.vlog.util.a.NGN;
      com.tencent.mm.plugin.vlog.util.a.gwN();
      f1 = i / f1;
      float f2 = (j - f1) / 2.0F;
      localObject3 = locale.NEb.getParent();
      localObject1 = localObject3;
      if (!(localObject3 instanceof CropOperationContainer)) {
        localObject1 = null;
      }
      localObject1 = (CropOperationContainer)localObject1;
      if (localObject1 != null) {
        ((CropOperationContainer)localObject1).setEditorItemFirstTouch(false);
      }
      locale.vav = new RectF(0.0F, f2, i, f2 + f1);
      locale.NEb.a(locale.NEc, locale.vav);
      locale.NEc = locale.vav;
      locale.NEb.a(locale.NEc, locale.vav);
      locale.NEb.setVisibility(4);
      localObject1 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
      com.tencent.mm.plugin.recordvideo.background.e.fuW().top = ((int)locale.vav.top);
      localObject1 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
      com.tencent.mm.plugin.recordvideo.background.e.fuW().bottom = ((int)locale.vav.bottom);
      localObject3 = new Rect();
      locale.vav.round((Rect)localObject3);
      localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
      if (localObject1 != null)
      {
        kotlin.g.b.p.k(localObject3, "valid");
        Object localObject4 = ar.au(MMApplicationContext.getContext());
        Object localObject5 = new Rect(0, 0, ((Point)localObject4).x, ((Point)localObject4).y);
        kotlin.g.b.p.k(localObject5, "canvasRect");
        kotlin.g.b.p.k(localObject3, "validRect");
        localObject4 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).NDO;
        c localc = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).NDQ;
        kotlin.g.b.p.k(localObject5, "canvasRect");
        kotlin.g.b.p.k(localObject3, "validRect");
        kotlin.g.b.p.k(localc, "config");
        TimelineEditor.Companion.access$checkInitJNI(TimelineEditor.VLq);
        localObject5 = com.tencent.mm.timelineedit.a.a.z((Rect)localObject5).toByteArray();
        kotlin.g.b.p.j(localObject5, "canvasRect.toProto().toByteArray()");
        localObject3 = com.tencent.mm.timelineedit.a.a.z((Rect)localObject3).toByteArray();
        kotlin.g.b.p.j(localObject3, "validRect.toProto().toByteArray()");
        ((TimelineEditor)localObject4).NmO = ((TimelineEditor)localObject4).nCreate((byte[])localObject5, (byte[])localObject3, localc.hCx());
        localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).NDO.getEffectManager();
        if (localObject1 != null)
        {
          localObject3 = (IStickerDecoderFactory)new com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder.d();
          kotlin.g.b.p.k(localObject3, "factory");
          ((EffectManager)localObject1).nSetDecoderFactory(((EffectManager)localObject1).NmO, (IStickerDecoderFactory)new StickerDecoderFactoryWrapper((IStickerDecoderFactory)localObject3));
        }
      }
      localObject1 = com.tencent.mm.plugin.vlog.util.a.NGN;
      localObject1 = com.tencent.mm.plugin.vlog.util.a.j(locale.vav);
      localObject3 = (ai)bp(ai.class);
      if (localObject3 != null) {
        ((ai)localObject3).h((RectF)localObject1);
      }
      localObject3 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
      ((RectF)localObject1).round(com.tencent.mm.plugin.recordvideo.background.e.getVisibleRect());
      localObject3 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject3).NDO.getEffectManager();
      }
      com.tencent.mm.plugin.vlog.model.local.a.Nol.b((EffectManager)localObject1);
      localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).AC(this.NrL);
      }
      localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).o(this.ALV);
        localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).NmT;
        if (localObject1 != null)
        {
          localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
          if (localObject2 != null)
          {
            kotlin.g.b.p.k(localObject1, "composition");
            ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject2).NmT = ((com.tencent.mm.videocomposition.j)localObject1);
            ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject2).AJS.a((com.tencent.mm.videocomposition.j)localObject1);
          }
          localObject2 = (ag)bp(ag.class);
          if (localObject2 != null) {
            d.d.a.a((d.d)localObject2, com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a.d((com.tencent.mm.videocomposition.j)localObject1));
          }
          if (((com.tencent.mm.videocomposition.j)localObject1).getDurationMs() > this.Nrw) {
            com.tencent.mm.plugin.recordvideo.plugin.parent.d.b.a(this, d.c.HSb);
          }
        }
      }
      localObject1 = (com.tencent.mm.plugin.vlog.ui.a)bp(com.tencent.mm.plugin.vlog.ui.a.class);
      if (localObject1 != null)
      {
        if (paramb == null) {
          kotlin.g.b.p.iCn();
        }
        com.tencent.mm.plugin.vlog.ui.a.a((com.tencent.mm.plugin.vlog.ui.a)localObject1, paramb, this.ALV, false, this.NrL, false, 20);
      }
      paramb = (com.tencent.mm.plugin.vlog.ui.plugin.caption.b)bp(com.tencent.mm.plugin.vlog.ui.plugin.caption.b.class);
      if (paramb == null) {
        break;
      }
      paramb.n(this.ALV);
      AppMethodBeat.o(233603);
      return;
      label1061:
      localObject1 = BitmapUtil.getImageOptions(((GalleryItem.MediaItem)localObject3).AAz);
      f1 = ((BitmapFactory.Options)localObject1).outWidth / ((BitmapFactory.Options)localObject1).outHeight;
      continue;
      label1088:
      f1 = 1.0F;
    }
    AppMethodBeat.o(233603);
  }
  
  public void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(233591);
    kotlin.g.b.p.k(parama, "navigator");
    kotlin.g.b.p.k(paramRecordConfigProvider, "configProvider");
    this.ALV = paramRecordConfigProvider;
    this.ALU = parama;
    Object localObject1 = this.ALV;
    if (localObject1 != null)
    {
      localObject1 = ((RecordConfigProvider)localObject1).mab;
      if (localObject1 != null) {
        ((Bundle)localObject1).setClassLoader(GalleryItem.MediaItem.class.getClassLoader());
      }
    }
    localObject1 = com.tencent.mm.plugin.recordvideo.e.d.IeU;
    com.tencent.mm.plugin.recordvideo.e.d.g(paramRecordConfigProvider);
    Log.i("MicroMsg.TimelineEditorFirstEnterOperate", "checkResUpdate");
    com.tencent.mm.plugin.recordvideo.res.e.HVb.bkQ();
    com.tencent.mm.plugin.recordvideo.res.f.HVc.bkQ();
    com.tencent.mm.plugin.recordvideo.res.g.HVd.bkQ();
    com.tencent.mm.plugin.recordvideo.res.e.HVb.fxH();
    com.tencent.mm.plugin.recordvideo.res.f.HVc.fxH();
    com.tencent.mm.plugin.recordvideo.res.g.HVd.fxH();
    gwJ();
    Object localObject2 = (com.tencent.mm.plugin.vlog.ui.a)bp(com.tencent.mm.plugin.vlog.ui.a.class);
    if (localObject2 != null)
    {
      int i = a.h.popvideo_post_selected_origin;
      if (i > 0)
      {
        localObject1 = ((com.tencent.mm.plugin.vlog.ui.a)localObject2).HQp;
        localObject2 = ((com.tencent.mm.plugin.vlog.ui.a)localObject2).parent.getContext();
        kotlin.g.b.p.j(localObject2, "parent.context");
        ((ImageView)localObject1).setImageDrawable(((Context)localObject2).getResources().getDrawable(i));
      }
    }
    localObject1 = (com.tencent.mm.plugin.recordvideo.plugin.d)bp(com.tencent.mm.plugin.recordvideo.plugin.d.class);
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.recordvideo.plugin.d)localObject1).a(Integer.valueOf(a.e.btn_solid_orange), null);
    }
    b(parama, paramRecordConfigProvider);
    AppMethodBeat.o(233591);
  }
  
  public void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(233613);
    kotlin.g.b.p.k(paramc, "status");
    float f;
    label821:
    long l2;
    final long l1;
    Object localObject1;
    label1169:
    label1234:
    label1243:
    label1258:
    label1270:
    final int i;
    int j;
    Object localObject2;
    Object localObject3;
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
      do
      {
        AppMethodBeat.o(233613);
        return;
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.i)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.i.class);
        if (paramc != null)
        {
          paramc.hideLoading();
          paramc = x.aazN;
        }
        paramc = getContext();
        if (paramc == null)
        {
          paramc = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(233613);
          throw paramc;
        }
        paramc = ((Activity)paramc).getWindow();
        kotlin.g.b.p.j(paramc, "(context as Activity).window");
        paramc = paramc.getDecorView().findViewById(16908290);
        kotlin.g.b.p.j(paramc, "(context as Activity).wi…up>(android.R.id.content)");
        ((ViewGroup)paramc).setAlpha(1.0F);
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (paramc != null)
        {
          paramc = paramc.NmT;
          if (paramc != null)
          {
            paramBundle = (ai)bp(ai.class);
            if (paramBundle != null)
            {
              paramBundle.b(paramc);
              paramc = x.aazN;
            }
            paramc = (ai)bp(ai.class);
            if (paramc != null)
            {
              paramc.setVisibility(0);
              paramc = x.aazN;
              AppMethodBeat.o(233613);
              return;
            }
            AppMethodBeat.o(233613);
            return;
          }
        }
        AppMethodBeat.o(233613);
        return;
        onBackPress();
        AppMethodBeat.o(233613);
        return;
        cSG();
        AppMethodBeat.o(233613);
        return;
        guD();
        AppMethodBeat.o(233613);
        return;
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
        if (paramc != null)
        {
          paramc.seek(0L);
          paramc = x.aazN;
        }
        m(null);
        AppMethodBeat.o(233613);
        return;
        if (paramBundle != null)
        {
          bool1 = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
          paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
          if (paramc != null) {
            paramc.AC(bool1);
          }
          paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
          if (paramc != null)
          {
            paramc = paramc.NmT;
            if (paramc != null)
            {
              paramc = (List)paramc.MQY;
              if (paramc != null)
              {
                paramc = ((Iterable)paramc).iterator();
                while (paramc.hasNext())
                {
                  paramBundle = (com.tencent.mm.videocomposition.b)paramc.next();
                  if (paramBundle.type != 3)
                  {
                    if (bool1) {}
                    for (f = 0.0F;; f = 1.0F)
                    {
                      paramBundle.setVolume(f);
                      break;
                    }
                  }
                }
              }
            }
            paramc = x.aazN;
            AppMethodBeat.o(233613);
            return;
          }
          AppMethodBeat.o(233613);
          return;
        }
        AppMethodBeat.o(233613);
        return;
        cSG();
        paramc = (u)bp(u.class);
        if (paramc != null)
        {
          paramc.gvC();
          paramc = x.aazN;
        }
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (paramc != null)
        {
          paramc = paramc.gwA();
          if (paramc != null)
          {
            paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
            if (paramBundle != null)
            {
              paramBundle = paramBundle.NDO;
              paramBundle.nSave(paramBundle.NmO);
              paramBundle = x.aazN;
            }
            paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.a)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.a.class);
            if (paramBundle != null)
            {
              com.tencent.mm.plugin.vlog.ui.timelineeditor.a.a(paramBundle, paramc);
              paramBundle = x.aazN;
            }
            paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
            if (paramBundle != null)
            {
              com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a(paramBundle, paramc, false, false, 0L, 14);
              paramc = x.aazN;
              AppMethodBeat.o(233613);
              return;
            }
            AppMethodBeat.o(233613);
            return;
          }
        }
        AppMethodBeat.o(233613);
        return;
        if (paramBundle != null) {}
        for (bool1 = paramBundle.getBoolean("PARAM_1_BOOLEAN", false);; bool1 = false)
        {
          if (!bool1)
          {
            if (bool1) {
              break;
            }
            paramc = (u)bp(u.class);
            if (paramc == null) {
              break label821;
            }
            if (paramc.NvP != true) {
              break;
            }
          }
          m(null);
          AppMethodBeat.o(233613);
          return;
        }
        AppMethodBeat.o(233613);
        return;
        dmf();
        AppMethodBeat.o(233613);
        return;
        if (paramBundle != null)
        {
          boolean bool2 = paramBundle.getBoolean("EDIT_VLOG_TRACK_CROP_CONFIRM");
          paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
          if (paramc != null)
          {
            if (!bool2)
            {
              bool1 = true;
              paramBundle = paramc.NDO;
              paramBundle = (com.tencent.mm.videocomposition.j)TimelineEditor.a((kotlin.g.a.a)new TimelineEditor.o(paramBundle, bool1), (kotlin.g.a.b)new TimelineEditor.p(paramBundle));
              if (bool1) {
                paramc.setComposition(paramBundle);
              }
              paramc = paramc.NmT;
              if (paramc == null) {
                break label1243;
              }
              if (paramc.getDurationMs() <= this.Nrw + 200L) {
                break label1270;
              }
              if (!bool2) {
                break label1258;
              }
              paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
              if (paramc == null) {
                break label1234;
              }
              l2 = this.Nrw;
              l1 = 0L;
              paramBundle = paramc.NmT;
              if (paramBundle != null)
              {
                paramBundle = (List)paramBundle.MQY;
                if (paramBundle != null) {
                  paramBundle = ((Iterable)paramBundle).iterator();
                }
              }
            }
            else
            {
              for (;;)
              {
                if (!paramBundle.hasNext()) {
                  break label1169;
                }
                localObject1 = (com.tencent.mm.videocomposition.b)paramBundle.next();
                if (l1 >= l2)
                {
                  paramc.setComposition(paramc.NDO.c(com.tencent.mm.timelineedit.a.a.c((com.tencent.mm.videocomposition.b)localObject1)));
                  continue;
                  bool1 = false;
                  break;
                }
                if (((com.tencent.mm.videocomposition.b)localObject1).endTimeMs - ((com.tencent.mm.videocomposition.b)localObject1).startTimeMs + l1 > l2)
                {
                  ((com.tencent.mm.videocomposition.b)localObject1).Sl(l1);
                  ((com.tencent.mm.videocomposition.b)localObject1).Sm(l2);
                  ((com.tencent.mm.videocomposition.b)localObject1).Sn(((com.tencent.mm.videocomposition.b)localObject1).MQV);
                  ((com.tencent.mm.videocomposition.b)localObject1).So(((float)(((com.tencent.mm.videocomposition.b)localObject1).endTimeMs - ((com.tencent.mm.videocomposition.b)localObject1).startTimeMs) * ((com.tencent.mm.videocomposition.b)localObject1).pvh + (float)((com.tencent.mm.videocomposition.b)localObject1).MQV));
                  paramc.setComposition(paramc.NDO.b(com.tencent.mm.timelineedit.a.a.c((com.tencent.mm.videocomposition.b)localObject1)));
                }
                l1 += ((com.tencent.mm.videocomposition.b)localObject1).endTimeMs - ((com.tencent.mm.videocomposition.b)localObject1).startTimeMs;
              }
            }
            paramc = paramc.NmT;
            if (paramc != null)
            {
              paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
              if (paramBundle != null)
              {
                com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a(paramBundle, paramc, false, false, 0L, 12);
                paramBundle = x.aazN;
              }
              paramBundle = (ag)bp(ag.class);
              if (paramBundle != null)
              {
                d.d.a.a(paramBundle, com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a.d(paramc));
                paramc = x.aazN;
              }
            }
            m(null);
          }
          for (;;)
          {
            paramc = x.aazN;
            guD();
            paramc = x.aazN;
            AppMethodBeat.o(233613);
            return;
            onBackPress();
            AppMethodBeat.o(233613);
            return;
            paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
            if (paramBundle != null)
            {
              com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a(paramBundle, paramc, false, false, 0L, 12);
              paramBundle = x.aazN;
            }
            if (bool2)
            {
              paramBundle = (ag)bp(ag.class);
              if (paramBundle != null)
              {
                d.d.a.a(paramBundle, com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a.d(paramc));
                paramc = x.aazN;
              }
            }
            m(null);
          }
        }
        AppMethodBeat.o(233613);
        return;
        if (paramBundle != null)
        {
          dmf();
          paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          paramBundle = paramBundle.getString("PARAM_EDIT_TEXT_FONT");
          localObject1 = (com.tencent.mm.plugin.recordvideo.plugin.d)bp(com.tencent.mm.plugin.recordvideo.plugin.d.class);
          if (localObject1 != null)
          {
            ((com.tencent.mm.plugin.recordvideo.plugin.d)localObject1).a(paramc, i, j, paramBundle);
            paramc = x.aazN;
          }
          paramc = x.aazN;
        }
        AppMethodBeat.o(233613);
        return;
        cSG();
        dmf();
        AppMethodBeat.o(233613);
        return;
        guD();
        m(null);
        AppMethodBeat.o(233613);
        return;
        paramc = (com.tencent.mm.plugin.recordvideo.plugin.d)bp(com.tencent.mm.plugin.recordvideo.plugin.d.class);
        if (paramc != null)
        {
          paramc.fwG();
          paramc = x.aazN;
          AppMethodBeat.o(233613);
          return;
        }
        AppMethodBeat.o(233613);
        return;
        paramc = (com.tencent.mm.plugin.recordvideo.plugin.b)bp(com.tencent.mm.plugin.recordvideo.plugin.b.class);
        if (paramc != null)
        {
          paramc.fwE();
          paramc = x.aazN;
          AppMethodBeat.o(233613);
          return;
        }
        AppMethodBeat.o(233613);
        return;
        if (paramBundle != null)
        {
          i = paramBundle.getInt("EDIT_VLOG_SELECT_TRACK", -1);
          paramc = (com.tencent.mm.plugin.vlog.ui.plugin.p)bp(com.tencent.mm.plugin.vlog.ui.plugin.p.class);
          if (((paramc == null) || (paramc.Nmo != i)) && (i >= 0))
          {
            this.NEO.setVisibility(4);
            this.NEN.setVisibility(4);
            paramc = (com.tencent.mm.plugin.vlog.ui.plugin.p)bp(com.tencent.mm.plugin.vlog.ui.plugin.p.class);
            if (paramc != null) {
              paramc.Nmo = i;
            }
            paramc = (com.tencent.mm.plugin.vlog.ui.plugin.p)bp(com.tencent.mm.plugin.vlog.ui.plugin.p.class);
            if (paramc != null)
            {
              paramc.setVisibility(0);
              paramc = x.aazN;
            }
            setSingleTrackPlayRange(true);
          }
          paramc = x.aazN;
          AppMethodBeat.o(233613);
          return;
        }
        AppMethodBeat.o(233613);
        return;
        if (this.NEO.getVisibility() != 0)
        {
          paramc = (com.tencent.mm.plugin.vlog.ui.plugin.p)bp(com.tencent.mm.plugin.vlog.ui.plugin.p.class);
          if (paramc != null) {
            paramc.Nmo = -1;
          }
          paramc = (com.tencent.mm.plugin.vlog.ui.plugin.p)bp(com.tencent.mm.plugin.vlog.ui.plugin.p.class);
          if (paramc != null)
          {
            paramc.setVisibility(4);
            paramc = x.aazN;
          }
          this.NEO.setVisibility(0);
          this.NEN.setVisibility(0);
          paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
          if (paramc != null)
          {
            paramc = paramc.NmT;
            if (paramc != null)
            {
              paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
              if (paramBundle != null)
              {
                paramBundle.aG(paramc.getPlayStart(), paramc.gtw());
                paramc = x.aazN;
              }
              paramc = (ag)bp(ag.class);
              if (paramc != null)
              {
                paramc.x(-1, 0L, 0L);
                paramc = x.aazN;
              }
            }
          }
        }
        paramc = (u)bp(u.class);
        if (paramc == null) {
          break;
        }
      } while (paramc.NvP != true);
      m(null);
      AppMethodBeat.o(233613);
      return;
      AppMethodBeat.o(233613);
      return;
    case 22: 
      paramc = getCurrentTrack();
      if (paramc != null)
      {
        paramBundle = (ad)bp(ad.class);
        if (paramBundle != null)
        {
          paramBundle.cq(paramc.pvh);
          paramc = x.aazN;
        }
        paramc = (ad)bp(ad.class);
        if (paramc != null)
        {
          paramc = paramc.ATq;
          if (paramc != null)
          {
            paramc.setShow(true);
            paramc = x.aazN;
            AppMethodBeat.o(233613);
            return;
          }
        }
        AppMethodBeat.o(233613);
        return;
      }
      AppMethodBeat.o(233613);
      return;
    case 23: 
    case 24: 
      if (paramBundle != null)
      {
        f = paramBundle.getFloat("EDIT_TRACK_DURATION_SCALE", 1.0F);
        paramBundle = getCurrentTrack();
        if (paramBundle != null) {}
        for (paramBundle = Long.valueOf(paramBundle.id);; paramBundle = null)
        {
          localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
          if (localObject1 == null) {
            break label2294;
          }
          if (paramBundle == null) {
            break;
          }
          ((Number)paramBundle).longValue();
          localObject2 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).NmT;
          if (localObject2 == null) {
            break;
          }
          localObject2 = (List)((com.tencent.mm.videocomposition.j)localObject2).MQY;
          if (localObject2 == null) {
            break;
          }
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (com.tencent.mm.videocomposition.b)((Iterator)localObject2).next();
            l1 = ((com.tencent.mm.videocomposition.b)localObject3).id;
            if ((paramBundle != null) && (l1 == paramBundle.longValue()))
            {
              ((com.tencent.mm.videocomposition.b)localObject3).setPlayRate(f);
              ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).setComposition(((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).NDO.b(com.tencent.mm.timelineedit.a.a.c((com.tencent.mm.videocomposition.b)localObject3)));
            }
          }
        }
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).gwB();
        paramBundle = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).NmT;
        localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
        if (localObject1 != null)
        {
          localObject2 = (u)bp(u.class);
          if (localObject2 == null) {
            break label2299;
          }
        }
      }
      for (bool1 = ((u)localObject2).fGh;; bool1 = false)
      {
        com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject1, paramBundle, bool1, false, 0L, 8);
        paramBundle = x.aazN;
        setSingleTrackPlayRange(true);
        paramBundle = x.aazN;
        if (paramc != d.c.HTc) {
          break;
        }
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (paramc == null) {
          break label2312;
        }
        paramc = paramc.NmT;
        if (paramc == null) {
          break label2312;
        }
        paramBundle = (ag)bp(ag.class);
        if (paramBundle != null)
        {
          d.d.a.a(paramBundle, com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a.d(paramc));
          paramc = x.aazN;
        }
        paramc = (ag)bp(ag.class);
        if (paramc == null) {
          break label2305;
        }
        paramc = paramc.NwM;
        if (paramc == null) {
          break label2305;
        }
        paramc.NDj = true;
        paramc = x.aazN;
        AppMethodBeat.o(233613);
        return;
        paramBundle = null;
        break label2130;
      }
      AppMethodBeat.o(233613);
      return;
      AppMethodBeat.o(233613);
      return;
    case 25: 
      paramBundle = getCurrentTrack();
      if (paramBundle != null)
      {
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (paramc != null)
        {
          l1 = paramBundle.id;
          paramc = paramc.NDO;
        }
        for (paramc = (com.tencent.mm.videocomposition.j)TimelineEditor.a((kotlin.g.a.a)new TimelineEditor.i(paramc, l1), (kotlin.g.a.b)new TimelineEditor.j(paramc));; paramc = null)
        {
          localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
          if (localObject1 != null)
          {
            com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject1, paramc, false, false, 0L, 14);
            paramc = x.aazN;
          }
          paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
          if (paramc != null)
          {
            paramc.aG(((float)paramBundle.MQV / paramBundle.pvh), ((float)paramBundle.MQW / paramBundle.pvh));
            paramc = x.aazN;
          }
          paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.h)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.h.class);
          if (paramc == null) {
            break;
          }
          com.tencent.mm.plugin.vlog.ui.timelineeditor.h.a(paramc, paramBundle);
          paramc = x.aazN;
          AppMethodBeat.o(233613);
          return;
        }
        AppMethodBeat.o(233613);
        return;
      }
      AppMethodBeat.o(233613);
      return;
    case 26: 
      if ((getCurrentTrack() != null) && (paramBundle != null))
      {
        l1 = paramBundle.getLong("EDIT_VLOG_TRACK_CROP_START");
        l2 = paramBundle.getLong("EDIT_VLOG_TRAKC_CROP_END");
        paramc = getCurrentTrack();
        if (paramc != null) {}
        for (paramc = Long.valueOf(paramc.id); paramBundle.getBoolean("EDIT_VLOG_TRACK_CROP_CHANGE", false); paramc = null)
        {
          kotlinx.coroutines.g.b((ak)br.abxo, (kotlin.d.f)bc.iRs(), (m)new c(paramc, l1, l2, null, this, paramBundle), 2);
          AppMethodBeat.o(233613);
          return;
        }
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
        if (paramc != null)
        {
          paramc.aG(l1, l2);
          paramc = x.aazN;
        }
        m(null);
        paramc = x.aazN;
        AppMethodBeat.o(233613);
        return;
      }
      AppMethodBeat.o(233613);
      return;
    case 27: 
      if (paramBundle != null)
      {
        l1 = paramBundle.getLong("PARAM_1_LONG");
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
        if (paramc != null)
        {
          paramc.seek(l1);
          paramc = x.aazN;
          AppMethodBeat.o(233613);
          return;
        }
        AppMethodBeat.o(233613);
        return;
      }
      AppMethodBeat.o(233613);
      return;
    case 28: 
      long l3;
      if (paramBundle != null)
      {
        l1 = paramBundle.getLong("EDIT_CROP_VLOG_LENGTH_START_TIME_LONG");
        l2 = paramBundle.getLong("EDIT_CROP_VLOG_LENGTH_END_TIME_LONG");
        l3 = paramBundle.getLong("EDIT_CROP_VLOG_SEEKTIME_LONG");
        if (paramBundle.getBoolean("EDIT_CROP_VLOG_ON_UP_BOOLEAN"))
        {
          m(null);
          paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
          if (paramc != null)
          {
            paramc.aG(l1, l2);
            paramc = x.aazN;
          }
          paramc = x.aazN;
        }
      }
      else
      {
        AppMethodBeat.o(233613);
        return;
      }
      dmf();
      paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
      if (paramc != null)
      {
        paramc.seek(l3);
        paramc = x.aazN;
      }
      paramc = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
      if (paramc != null) {}
      for (paramc = paramc.NAo.getAllTTSData();; paramc = null)
      {
        paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (paramBundle == null) {
          break;
        }
        paramc = paramBundle.iJ(paramc);
        if (paramc == null) {
          break;
        }
        paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
        if (paramBundle == null) {
          break;
        }
        com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a(paramBundle, paramc, false, false, 0L, 14);
        paramc = x.aazN;
        break;
      }
    case 29: 
      if (paramBundle != null)
      {
        j = paramBundle.getInt("EDIT_SELECT_TRANSITION_INDEX");
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (paramc != null)
        {
          paramBundle = paramc.NmT;
          if (paramBundle != null)
          {
            localObject1 = (com.tencent.mm.videocomposition.b)((List)paramBundle.MQY).get(j);
            paramc = (com.tencent.mm.videocomposition.b)((List)paramBundle.MQY).get(j + 1);
            l2 = ((com.tencent.mm.videocomposition.b)localObject1).endTimeMs - paramc.MQX.duration / 2L;
            l1 = Math.max(0L, l2 - 1000L);
            l2 = Math.min(paramBundle.getDurationMs(), l2 + 1000L);
            paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
            if (paramBundle != null)
            {
              paramBundle.aG(l1, l2);
              paramBundle = x.aazN;
            }
            paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
            if (paramBundle != null)
            {
              paramBundle.seek(l1);
              paramBundle = x.aazN;
            }
            paramBundle = (com.tencent.mm.plugin.vlog.ui.plugin.transition.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.transition.a.class);
            if (paramBundle != null) {
              paramBundle.NBf = l1;
            }
            paramBundle = (com.tencent.mm.plugin.vlog.ui.plugin.transition.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.transition.a.class);
            if (paramBundle != null)
            {
              paramc = paramc.MQX.path;
              paramBundle.gws();
              localObject1 = paramBundle.gwr();
              localObject2 = com.tencent.mm.plugin.vlog.model.local.a.Nol;
              localObject2 = (Iterable)com.tencent.mm.plugin.vlog.model.local.a.gtJ();
              i = 0;
              localObject2 = ((Iterable)localObject2).iterator();
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = ((Iterator)localObject2).next();
                if (i < 0) {
                  kotlin.a.j.iBO();
                }
                if (kotlin.g.b.p.h(((com.tencent.mm.plugin.vlog.model.local.a.a)localObject3).assetPath, paramc)) {
                  ((com.tencent.mm.plugin.vlog.ui.plugin.transition.b)localObject1).kL(j, i + 1);
                }
              }
              for (;;)
              {
                paramBundle.ATq.setShow(true);
                paramc = x.aazN;
                AppMethodBeat.o(233613);
                return;
                i += 1;
                break;
                ((com.tencent.mm.plugin.vlog.ui.plugin.transition.b)localObject1).kL(j, -1);
              }
            }
            AppMethodBeat.o(233613);
            return;
          }
        }
        AppMethodBeat.o(233613);
        return;
      }
      AppMethodBeat.o(233613);
      return;
    case 30: 
      paramc = (com.tencent.mm.plugin.vlog.ui.plugin.p)bp(com.tencent.mm.plugin.vlog.ui.plugin.p.class);
      if (paramc != null)
      {
        i = paramc.Nmo;
        if (i < 0) {
          break label3410;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          if (getCurrentTrack() != null)
          {
            paramc = getCurrentTrackPlayRange();
            if (paramc != null)
            {
              paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
              if (paramBundle != null)
              {
                paramBundle.aG(paramc.startTimeMs, paramc.endTimeMs);
                paramBundle = x.aazN;
              }
              paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
              if (paramBundle != null)
              {
                paramBundle.seek(paramc.startTimeMs);
                paramc = x.aazN;
                AppMethodBeat.o(233613);
                return;
                i = -1;
                break;
                i = 0;
                continue;
              }
              AppMethodBeat.o(233613);
              return;
            }
          }
          AppMethodBeat.o(233613);
          return;
        }
      }
      paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
      if (paramc != null)
      {
        paramc = paramc.NmT;
        if (paramc != null)
        {
          paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
          if (paramBundle != null)
          {
            paramBundle.aG(paramc.YId, paramc.igG());
            paramc = x.aazN;
          }
          paramc = (com.tencent.mm.plugin.vlog.ui.plugin.transition.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.transition.a.class);
          if (paramc != null)
          {
            l1 = paramc.NBf;
            paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
            if (paramc != null)
            {
              paramc.seek(l1);
              paramc = x.aazN;
            }
          }
          m(null);
          paramc = x.aazN;
          AppMethodBeat.o(233613);
          return;
        }
      }
      AppMethodBeat.o(233613);
      return;
    case 31: 
      if (paramBundle != null)
      {
        paramc = paramBundle.getString("PARAM_1_STRING");
        l1 = paramBundle.getLong("PARAM_1_INT");
        j = paramBundle.getInt("EDIT_SELECT_TRANSITION_INDEX");
        paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (paramBundle != null)
        {
          paramc = paramBundle.r(paramc, l1, j);
          if (paramc != null)
          {
            paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
            if (paramBundle != null)
            {
              com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a(paramBundle, paramc, false, false, 0L, 14);
              paramc = x.aazN;
            }
            paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
            if (paramc != null)
            {
              paramBundle = paramc.NmT;
              if (paramBundle != null)
              {
                paramBundle = (List)paramBundle.MQY;
                if (paramBundle != null)
                {
                  i = paramBundle.size();
                  if (i <= j + 1) {
                    break label3815;
                  }
                  paramc = paramc.NmT;
                  if (paramc == null) {
                    kotlin.g.b.p.iCn();
                  }
                  paramc = (com.tencent.mm.videocomposition.b)((List)paramc.MQY).get(j);
                  l1 = paramc.MQX.duration;
                  l1 = paramc.endTimeMs - l1 / 2L;
                  paramc = new com.tencent.mm.timelineedit.a.f(l1 - 1000L, l1 + 1000L);
                }
              }
              for (;;)
              {
                if (paramc != null)
                {
                  paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
                  if (paramBundle != null)
                  {
                    paramBundle.aG(paramc.startTimeMs, paramc.endTimeMs);
                    paramc = x.aazN;
                    AppMethodBeat.o(233613);
                    return;
                    i = 0;
                    break;
                    paramc = null;
                    continue;
                  }
                  AppMethodBeat.o(233613);
                  return;
                }
              }
            }
            AppMethodBeat.o(233613);
            return;
          }
        }
      }
      AppMethodBeat.o(233613);
      return;
    case 32: 
      if (paramBundle != null)
      {
        paramc = paramBundle.getString("PARAM_1_STRING");
        l1 = paramBundle.getLong("PARAM_1_INT");
        paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (paramBundle != null)
        {
          localObject1 = paramBundle.NmT;
          if (localObject1 != null)
          {
            localObject1 = (List)((com.tencent.mm.videocomposition.j)localObject1).MQY;
            if (localObject1 != null)
            {
              localObject1 = ((Iterable)localObject1).iterator();
              i = 0;
              while (((Iterator)localObject1).hasNext())
              {
                ((Iterator)localObject1).next();
                if (i < 0) {
                  kotlin.a.j.iBO();
                }
                paramBundle.r(paramc, l1, i);
                i += 1;
              }
            }
          }
          paramc = paramBundle.NmT;
          if (paramc != null)
          {
            paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
            if (paramBundle != null)
            {
              com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a(paramBundle, paramc, false, false, 0L, 14);
              paramc = x.aazN;
              AppMethodBeat.o(233613);
              return;
            }
            AppMethodBeat.o(233613);
            return;
          }
        }
      }
      AppMethodBeat.o(233613);
      return;
    case 33: 
      paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
      if (paramc != null)
      {
        paramc = paramc.NmT;
        if (paramc != null)
        {
          paramBundle = (List)paramc.MQY;
          if (paramBundle != null)
          {
            paramc = (ag)bp(ag.class);
            if (paramc != null)
            {
              localObject1 = (Iterable)kotlin.a.j.O(paramBundle, paramBundle.size() - 1);
              paramBundle = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
              localObject1 = ((Iterable)localObject1).iterator();
              if (((Iterator)localObject1).hasNext())
              {
                if (((com.tencent.mm.videocomposition.b)((Iterator)localObject1).next()).MQX.duration > 0L) {}
                for (bool1 = true;; bool1 = false)
                {
                  paramBundle.add(Boolean.valueOf(bool1));
                  break;
                }
              }
              paramc.iH((List)paramBundle);
              paramc = x.aazN;
              AppMethodBeat.o(233613);
              return;
            }
            AppMethodBeat.o(233613);
            return;
          }
        }
      }
      AppMethodBeat.o(233613);
      return;
    case 34: 
      paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.d)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.d.class);
      if (paramc != null)
      {
        ((com.google.android.material.bottomsheet.a)paramc.NvG.getValue()).show();
        paramc = x.aazN;
        AppMethodBeat.o(233613);
        return;
      }
      AppMethodBeat.o(233613);
      return;
    case 35: 
    case 36: 
      label2130:
      label2294:
      label2299:
      if (paramBundle != null)
      {
        i = paramBundle.getInt("EDIT_COMPOSITION_TRACK_INDEX");
        bool1 = paramBundle.getBoolean("EDIT_COMPOSITION_LEFT");
        l1 = paramBundle.getLong("EDIT_VLOG_TRACK_CROP_START");
        l2 = paramBundle.getLong("EDIT_VLOG_TRAKC_CROP_END");
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (paramc != null)
        {
          kotlinx.coroutines.g.b((ak)br.abxo, (kotlin.d.f)bc.iRs(), (m)new d(paramc, null, i, l1, l2, bool1, this), 2);
          AppMethodBeat.o(233613);
          return;
        }
        AppMethodBeat.o(233613);
        return;
      }
      label2305:
      label2312:
      label3410:
      label3815:
      AppMethodBeat.o(233613);
      return;
    }
    if (paramBundle != null) {}
    for (final boolean bool1 = paramBundle.getBoolean("PARAM_1_BOOLEAN", false);; bool1 = false)
    {
      paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
      if (paramc != null)
      {
        paramc = paramc.NmT;
        if (paramc != null)
        {
          paramBundle = com.tencent.mm.plugin.vlog.model.local.a.Nol;
          com.tencent.mm.plugin.vlog.model.local.a.a(paramc, bool1);
          paramc = x.aazN;
        }
      }
      paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
      if (paramc == null) {
        break;
      }
      paramc.AJS.bXe();
      paramc = x.aazN;
      AppMethodBeat.o(233613);
      return;
    }
  }
  
  protected void b(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    boolean bool1 = false;
    AppMethodBeat.i(233596);
    kotlin.g.b.p.k(parama, "navigator");
    kotlin.g.b.p.k(paramRecordConfigProvider, "configProvider");
    parama = paramRecordConfigProvider.mab;
    if (parama != null)
    {
      boolean bool2 = parama.getBoolean("KEY_DISABLE_VIDEO_ENHANCEMENT", false);
      parama = (ai)bp(ai.class);
      if (parama != null)
      {
        if (!bool2) {
          bool1 = true;
        }
        parama.setEnable(bool1);
        AppMethodBeat.o(233596);
        return;
      }
      AppMethodBeat.o(233596);
      return;
    }
    AppMethodBeat.o(233596);
  }
  
  protected final void cSG()
  {
    AppMethodBeat.i(233620);
    this.NEM.animate().cancel();
    this.NEM.animate().alpha(0.0F).setDuration(100L).withEndAction((Runnable)new b(this)).start();
    AppMethodBeat.o(233620);
  }
  
  protected final void dmf()
  {
    AppMethodBeat.i(233621);
    Object localObject = (u)bp(u.class);
    if (localObject != null) {
      ((u)localObject).gvD();
    }
    localObject = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject).pause();
    }
    localObject = (com.tencent.mm.plugin.vlog.ui.a)bp(com.tencent.mm.plugin.vlog.ui.a.class);
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.vlog.ui.a)localObject).bnt();
      AppMethodBeat.o(233621);
      return;
    }
    AppMethodBeat.o(233621);
  }
  
  protected final com.tencent.mm.media.widget.camerarecordview.b.b getCaptureInfo()
  {
    return this.HNh;
  }
  
  protected final RecordConfigProvider getConfigProvider()
  {
    return this.ALV;
  }
  
  protected final com.tencent.mm.videocomposition.b getCurrentTrack()
  {
    AppMethodBeat.i(233631);
    Object localObject = (com.tencent.mm.plugin.vlog.ui.plugin.p)bp(com.tencent.mm.plugin.vlog.ui.plugin.p.class);
    if (localObject != null)
    {
      int i = ((com.tencent.mm.plugin.vlog.ui.plugin.p)localObject).Nmo;
      if (i >= 0)
      {
        localObject = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject).NmT;
          if (localObject != null)
          {
            localObject = (com.tencent.mm.videocomposition.b)((List)((com.tencent.mm.videocomposition.j)localObject).MQY).get(i);
            AppMethodBeat.o(233631);
            return localObject;
          }
        }
      }
    }
    AppMethodBeat.o(233631);
    return null;
  }
  
  protected final String getEditId()
  {
    return this.editId;
  }
  
  protected final long getMaxCropVideoDurationMs()
  {
    return this.Nrw;
  }
  
  protected final ViewGroup getPluginLayout()
  {
    return this.NEM;
  }
  
  protected final void guD()
  {
    AppMethodBeat.i(233618);
    this.NEM.setVisibility(0);
    this.NEM.animate().cancel();
    this.NEM.animate().alpha(1.0F).setDuration(100L).start();
    AppMethodBeat.o(233618);
  }
  
  protected final boolean gwI()
  {
    return this.NrL;
  }
  
  protected void gwJ()
  {
    AppMethodBeat.i(233595);
    Object localObject1 = findViewById(a.f.video_composition_player);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.video_composition_player)");
    localObject1 = new com.tencent.mm.plugin.vlog.ui.timelineeditor.f((VideoCompositionPlayView)localObject1, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    Object localObject2 = new c();
    Object localObject3 = this.ALV;
    long l;
    if (localObject3 != null)
    {
      l = ((RecordConfigProvider)localObject3).mab.getLong("video_max_duration", 60000L);
      "getMaxDurationMs by parse:".concat(String.valueOf(l));
      com.tencent.d.f.h.ioq();
    }
    for (;;)
    {
      this.Nrw = l;
      ((c)localObject2).atd(com.tencent.mm.ci.a.kr(MMApplicationContext.getContext()) / 2);
      ((c)localObject2).ate(com.tencent.mm.ci.a.ks(MMApplicationContext.getContext()) / 2);
      new com.tencent.mm.plugin.vlog.ui.timelineeditor.b((com.tencent.mm.plugin.recordvideo.plugin.parent.d)this, (c)localObject2);
      localObject2 = getContext();
      kotlin.g.b.p.j(localObject2, "context");
      com.tencent.mm.plugin.vlog.ui.timelineeditor.i.a(new com.tencent.mm.plugin.vlog.ui.timelineeditor.i((Context)localObject2, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this));
      localObject2 = (ViewGroup)this;
      localObject3 = findViewById(a.f.editor_add_emoji);
      kotlin.g.b.p.j(localObject3, "findViewById(R.id.editor_add_emoji)");
      new com.tencent.mm.plugin.recordvideo.plugin.b((ViewGroup)localObject2, (ImageView)localObject3, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
      localObject2 = findViewById(a.f.change_text_root);
      kotlin.g.b.p.j(localObject2, "findViewById(R.id.change_text_root)");
      localObject2 = new com.tencent.mm.plugin.recordvideo.plugin.h((EditorInputView)localObject2, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
      ((com.tencent.mm.plugin.recordvideo.plugin.h)localObject2).HMM.setEnableClickOutsideConfirm(true);
      new com.tencent.mm.plugin.recordvideo.plugin.d((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this, ((com.tencent.mm.plugin.recordvideo.plugin.h)localObject2).HMM);
      new com.tencent.mm.plugin.vlog.ui.plugin.l((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
      localObject2 = new com.tencent.mm.plugin.vlog.ui.a((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
      ((com.tencent.mm.plugin.vlog.ui.a)localObject2).HQs = true;
      ((com.tencent.mm.plugin.vlog.ui.a)localObject2).setBackground(a.e.video_edit_panel_bg);
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject1).NuH = ((d.e)localObject2);
      localObject2 = findViewById(a.f.timeline_editor_back);
      kotlin.g.b.p.j(localObject2, "findViewById(R.id.timeline_editor_back)");
      new com.tencent.mm.plugin.recordvideo.plugin.f((ImageView)localObject2, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
      new com.tencent.mm.plugin.vlog.ui.timelineeditor.e((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
      localObject2 = new com.tencent.mm.plugin.vlog.ui.timelineeditor.a((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject1).a((com.tencent.mm.plugin.vlog.ui.plugin.d.b)localObject2);
      new u((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this).a((u.a)localObject2);
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject1).a((com.tencent.mm.plugin.vlog.ui.plugin.d.b)new ag((View)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this));
      new com.tencent.mm.plugin.vlog.ui.plugin.p((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
      localObject2 = findViewById(a.f.editor_track_play_rate_panel);
      kotlin.g.b.p.j(localObject2, "findViewById(R.id.editor_track_play_rate_panel)");
      new ad((EditorPanelHolder)localObject2, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
      localObject2 = findViewById(a.f.editor_track_edit_panel);
      kotlin.g.b.p.j(localObject2, "findViewById(R.id.editor_track_edit_panel)");
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject1).a((com.tencent.mm.plugin.vlog.ui.plugin.d.b)new com.tencent.mm.plugin.vlog.ui.timelineeditor.h((EditorPanelHolder)localObject2, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this));
      new com.tencent.mm.plugin.vlog.ui.plugin.transition.a((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this, false);
      localObject2 = findViewById(a.f.editor_add_caption_group);
      kotlin.g.b.p.j(localObject2, "findViewById(R.id.editor_add_caption_group)");
      localObject2 = (ViewGroup)localObject2;
      localObject3 = findViewById(a.f.editor_caption_preview_panel);
      kotlin.g.b.p.j(localObject3, "findViewById(R.id.editor_caption_preview_panel)");
      localObject3 = (EditorPanelHolder)localObject3;
      View localView = findViewById(a.f.editor_caption_edit_panel);
      kotlin.g.b.p.j(localView, "findViewById(R.id.editor_caption_edit_panel)");
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject1).a((com.tencent.mm.plugin.vlog.ui.plugin.d.b)new com.tencent.mm.plugin.vlog.ui.plugin.caption.b((ViewGroup)localObject2, (EditorPanelHolder)localObject3, (EditorPanelHolder)localView, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this));
      localObject2 = findViewById(a.f.editor_tts_panel);
      kotlin.g.b.p.j(localObject2, "findViewById(R.id.editor_tts_panel)");
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject1).a((com.tencent.mm.plugin.vlog.ui.plugin.d.b)new com.tencent.mm.plugin.vlog.ui.plugin.read.a((ViewGroup)localObject2, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this));
      new ai((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
      AppMethodBeat.o(233595);
      return;
      com.tencent.d.f.h.ioq();
      l = 60000L;
    }
  }
  
  protected String gwK()
  {
    return "MicroMsg.TimelineEditorVideoPluginLayout";
  }
  
  protected final void m(Long paramLong)
  {
    AppMethodBeat.i(233625);
    Object localObject = (u)bp(u.class);
    if (localObject != null) {
      ((u)localObject).gvC();
    }
    localObject = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject).AJS.resume();
    }
    localObject = (com.tencent.mm.plugin.vlog.ui.a)bp(com.tencent.mm.plugin.vlog.ui.a.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.vlog.ui.a)localObject).bnu();
    }
    if (paramLong != null)
    {
      localObject = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject).seek(paramLong.longValue());
        AppMethodBeat.o(233625);
        return;
      }
    }
    AppMethodBeat.o(233625);
  }
  
  public boolean onBackPress()
  {
    AppMethodBeat.i(233638);
    if (!super.onBackPress())
    {
      com.tencent.mm.plugin.recordvideo.activity.a locala = this.ALU;
      if (locala != null) {
        com.tencent.mm.plugin.recordvideo.activity.a.a.a(locala);
      }
    }
    AppMethodBeat.o(233638);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(233640);
    super.release();
    com.tencent.mm.plugin.vlog.model.local.a.Nol.unInit();
    AppMethodBeat.o(233640);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(233616);
    super.reset();
    this.NEO.setVisibility(0);
    this.NEN.setVisibility(0);
    AppMethodBeat.o(233616);
  }
  
  protected final void setCaptureInfo(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    this.HNh = paramb;
  }
  
  protected final void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    this.ALV = paramRecordConfigProvider;
  }
  
  protected final void setEditId(String paramString)
  {
    AppMethodBeat.i(233583);
    kotlin.g.b.p.k(paramString, "<set-?>");
    this.editId = paramString;
    AppMethodBeat.o(233583);
  }
  
  protected final void setMaxCropVideoDurationMs(long paramLong)
  {
    this.Nrw = paramLong;
  }
  
  protected final void setMediaMute(boolean paramBoolean)
  {
    this.NrL = paramBoolean;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorBaseVideoPluginLayout$Companion;", "", "()V", "Profile_Tag", "", "plugin-vlog_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(TimelineEditorBaseVideoPluginLayout paramTimelineEditorBaseVideoPluginLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(224489);
      this.NEQ.getPluginLayout().setVisibility(4);
      AppMethodBeat.o(224489);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorBaseVideoPluginLayout$statusChange$12$1$1", "com/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorBaseVideoPluginLayout$$special$$inlined$let$lambda$1"})
  static final class c
    extends kotlin.d.b.a.j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    Object pGq;
    Object pGr;
    
    c(Long paramLong, long paramLong1, long paramLong2, kotlin.d.d paramd, TimelineEditorBaseVideoPluginLayout paramTimelineEditorBaseVideoPluginLayout, Bundle paramBundle)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(232442);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new c(this.NER, l1, this.NES, paramd, this.NEQ, this.ypn);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(232442);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(232443);
      paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(232443);
      return paramObject1;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(232440);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      final aa.e locale;
      Object localObject1;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(232440);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        locale = new aa.e();
        locale.aaBB = System.currentTimeMillis();
        localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)this.NEQ.bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (localObject1 != null)
        {
          localObject2 = this.NER;
          long l1 = l1;
          long l2 = this.NES;
          this.L$0 = paramObject;
          this.oDA = locale;
          this.label = 1;
          localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).a((Long)localObject2, l1, l2, this);
          if (localObject1 != locala) {
            break label424;
          }
          AppMethodBeat.o(232440);
          return locala;
        }
        break;
      case 1: 
        locale = (aa.e)this.oDA;
        localObject2 = (ak)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      label424:
      for (;;)
      {
        localObject1 = (com.tencent.mm.videocomposition.j)localObject1;
        if (localObject1 != null)
        {
          Log.i("MicroMsg.TimelineProfile", "jni updateTrackDuration coast:" + (System.currentTimeMillis() - locale.aaBB));
          kotlinx.coroutines.g.a(paramObject, null, (m)new kotlin.d.b.a.j((com.tencent.mm.videocomposition.j)localObject1, null)
          {
            int label;
            private ak p$;
            
            public final kotlin.d.d<x> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
            {
              AppMethodBeat.i(231483);
              kotlin.g.b.p.k(paramAnonymousd, "completion");
              paramAnonymousd = new 1(this.Nku, paramAnonymousd, jdField_this, paramObject, locale);
              paramAnonymousd.p$ = ((ak)paramAnonymousObject);
              AppMethodBeat.o(231483);
              return paramAnonymousd;
            }
            
            public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
            {
              AppMethodBeat.i(231484);
              paramAnonymousObject1 = ((1)create(paramAnonymousObject1, (kotlin.d.d)paramAnonymousObject2)).invokeSuspend(x.aazN);
              AppMethodBeat.o(231484);
              return paramAnonymousObject1;
            }
            
            public final Object invokeSuspend(Object paramAnonymousObject)
            {
              AppMethodBeat.i(231480);
              kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
              switch (this.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(231480);
                throw paramAnonymousObject;
              }
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)jdField_this.NEQ.bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
              if (paramAnonymousObject != null)
              {
                com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a(paramAnonymousObject, this.Nku, false, false, 0L, 14);
                paramAnonymousObject = x.aazN;
                AppMethodBeat.o(231480);
                return paramAnonymousObject;
              }
              AppMethodBeat.o(231480);
              return null;
            }
          }, 3);
          Log.i("MicroMsg.TimelineProfile", "updateComposition:" + (System.currentTimeMillis() - locale.aaBB));
          localObject2 = new aa.f();
          ((aa.f)localObject2).aaBC = com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a.d((com.tencent.mm.videocomposition.j)localObject1);
          Log.i("MicroMsg.TimelineProfile", "videoComposition2VLogComposition coast:" + (System.currentTimeMillis() - locale.aaBB));
          kotlin.d.f localf = (kotlin.d.f)bc.iRr();
          m localm = (m)new kotlin.d.b.a.j((aa.f)localObject2, null)
          {
            int label;
            private ak p$;
            
            public final kotlin.d.d<x> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
            {
              AppMethodBeat.i(228954);
              kotlin.g.b.p.k(paramAnonymousd, "completion");
              paramAnonymousd = new 2(this.NEV, paramAnonymousd, jdField_this, paramObject, locale);
              paramAnonymousd.p$ = ((ak)paramAnonymousObject);
              AppMethodBeat.o(228954);
              return paramAnonymousd;
            }
            
            public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
            {
              AppMethodBeat.i(228956);
              paramAnonymousObject1 = ((2)create(paramAnonymousObject1, (kotlin.d.d)paramAnonymousObject2)).invokeSuspend(x.aazN);
              AppMethodBeat.o(228956);
              return paramAnonymousObject1;
            }
            
            public final Object invokeSuspend(Object paramAnonymousObject)
            {
              AppMethodBeat.i(228951);
              kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
              switch (this.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(228951);
                throw paramAnonymousObject;
              }
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = (ag)jdField_this.NEQ.bp(ag.class);
              if (paramAnonymousObject != null) {
                d.d.a.a(paramAnonymousObject, (ac)this.NEV.aaBC);
              }
              Log.i("MicroMsg.TimelineProfile", "VLogThumbViewPlugin:" + (System.currentTimeMillis() - locale.aaBB));
              TimelineEditorBaseVideoPluginLayout.b(jdField_this.NEQ);
              paramAnonymousObject = (ag)jdField_this.NEQ.bp(ag.class);
              if (paramAnonymousObject != null)
              {
                paramAnonymousObject = paramAnonymousObject.NwM;
                if (paramAnonymousObject != null)
                {
                  paramAnonymousObject.NDj = true;
                  paramAnonymousObject = x.aazN;
                  AppMethodBeat.o(228951);
                  return paramAnonymousObject;
                }
              }
              AppMethodBeat.o(228951);
              return null;
            }
          };
          this.L$0 = paramObject;
          this.oDA = locale;
          this.pGq = localObject1;
          this.pGr = localObject2;
          this.label = 2;
          if (kotlinx.coroutines.i.a(localf, localm, this) == locala)
          {
            AppMethodBeat.o(232440);
            return locala;
            ResultKt.throwOnFailure(paramObject);
          }
        }
        paramObject = x.aazN;
        AppMethodBeat.o(232440);
        return paramObject;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorBaseVideoPluginLayout$statusChange$21$1$1", "com/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorBaseVideoPluginLayout$$special$$inlined$let$lambda$2"})
  static final class d
    extends kotlin.d.b.a.j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    d(com.tencent.mm.plugin.vlog.ui.timelineeditor.b paramb, kotlin.d.d paramd, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean, TimelineEditorBaseVideoPluginLayout paramTimelineEditorBaseVideoPluginLayout)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(242016);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new d(this.NEX, paramd, i, l1, bool1, this.NFb, this.NEQ);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(242016);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(242019);
      paramObject1 = ((d)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(242019);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(242015);
      Object localObject = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(242015);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        com.tencent.mm.plugin.vlog.ui.timelineeditor.b localb = this.NEX;
        int i = i;
        l1 = l1;
        long l2 = bool1;
        this.L$0 = paramObject;
        this.label = 1;
        if (kotlinx.coroutines.i.a((kotlin.d.f)bc.iRs(), (m)new b.c(localb, i, l1, l2, null), this) == localObject)
        {
          AppMethodBeat.o(242015);
          return localObject;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = this.NEX.gwA();
      if (paramObject != null) {
        if (!this.NFb) {
          break label244;
        }
      }
      label244:
      for (long l1 = ((com.tencent.mm.videocomposition.b)((List)paramObject.MQY).get(i)).startTimeMs;; l1 = ((com.tencent.mm.videocomposition.b)((List)paramObject.MQY).get(i)).endTimeMs)
      {
        localObject = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)this.NEQ.bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
        if (localObject != null) {
          ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject).a(paramObject, false, true, l1);
        }
        paramObject = (com.tencent.mm.plugin.vlog.ui.timelineeditor.a)this.NEQ.bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.a.class);
        if (paramObject != null) {
          paramObject.guO().SB(l1);
        }
        paramObject = x.aazN;
        AppMethodBeat.o(242015);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.scene.TimelineEditorBaseVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */