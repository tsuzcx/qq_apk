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
import com.tencent.mm.plugin.recordvideo.activity.a.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.AutoRegisterPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.a.e;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.g;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.plugin.vlog.ui.plugin.af;
import com.tencent.mm.plugin.vlog.ui.plugin.d.b;
import com.tencent.mm.plugin.vlog.ui.plugin.d.d;
import com.tencent.mm.plugin.vlog.ui.plugin.d.d.a;
import com.tencent.mm.plugin.vlog.ui.plugin.d.e;
import com.tencent.mm.plugin.vlog.ui.plugin.t;
import com.tencent.mm.plugin.vlog.ui.plugin.t.a;
import com.tencent.mm.plugin.vlog.ui.plugin.timeedit.TimeEditorItemContainer;
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
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.IStickerDecoderFactory;
import com.tencent.mm.xeffect.effect.StickerDecoderFactoryWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorBaseVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/AutoRegisterPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bottomLayout", "Landroid/view/ViewGroup;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "editId", "", "getEditId", "()Ljava/lang/String;", "setEditId", "(Ljava/lang/String;)V", "headLayout", "isMediaMute", "", "()Z", "setMediaMute", "(Z)V", "maxCropVideoDurationMs", "", "getMaxCropVideoDurationMs", "()J", "setMaxCropVideoDurationMs", "(J)V", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "pluginLayout", "getPluginLayout", "()Landroid/view/ViewGroup;", "adjustBottomLayoutForAccessibility", "", "editSingleTrack", "getCurrentTrack", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "getCurrentTrackPlayRange", "Lcom/tencent/mm/timelineedit/model/TimeRange;", "hideOperation", "initLogic", "initPlugin", "initPluginLogic", "initPluginStyle", "isPlaying", "loadCurrentPage", "model", "logTag", "onBackPress", "onDetach", "pauseVideo", "release", "reset", "resumeVideo", "seekTo", "(Ljava/lang/Long;)V", "setSingleTrackPlayRange", "seekStart", "showOperation", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public class TimelineEditorBaseVideoPluginLayout
  extends AutoRegisterPluginLayout
{
  public static final TimelineEditorBaseVideoPluginLayout.a Ura;
  private com.tencent.mm.plugin.recordvideo.activity.a Fiu;
  private com.tencent.mm.media.widget.camerarecordview.b.b NKf;
  private long Uff;
  private boolean Ufu;
  private final ViewGroup Urb;
  private final ViewGroup Urc;
  private final ViewGroup Urd;
  private String editId;
  private RecordConfigProvider oaV;
  
  static
  {
    AppMethodBeat.i(282332);
    Ura = new TimelineEditorBaseVideoPluginLayout.a((byte)0);
    AppMethodBeat.o(282332);
  }
  
  public TimelineEditorBaseVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(282249);
    this.editId = "";
    this.Uff = 60000L;
    Log.i(hUH(), "create TimelineEditorVideoPluginLayout instance[" + hashCode() + ']');
    if (((ViewGroup)((Activity)paramContext).findViewById(a.f.record_ui_root)).getChildCount() == 0) {
      ((ViewGroup)((Activity)paramContext).getWindow().getDecorView().findViewById(16908290)).setAlpha(0.0F);
    }
    LayoutInflater.from(paramContext).inflate(a.g.timeline_editor_plugin_layout, (ViewGroup)this, true);
    paramContext = findViewById(a.f.plugin_layout);
    ((InsectRelativeLayout)paramContext).setDiscardKeyboard(true);
    paramAttributeSet = kotlin.ah.aiuX;
    s.s(paramContext, "findViewById<InsectRelat…Keyboard = true\n        }");
    this.Urb = ((ViewGroup)paramContext);
    paramContext = findViewById(a.f.timeline_editor_bottom_layout);
    s.s(paramContext, "findViewById(R.id.timeline_editor_bottom_layout)");
    this.Urc = ((ViewGroup)paramContext);
    paramContext = findViewById(a.f.timeline_editor_head_layout);
    s.s(paramContext, "findViewById(R.id.timeline_editor_head_layout)");
    this.Urd = ((ViewGroup)paramContext);
    paramContext = this.Urc.findViewById(a.f.timeline_finish);
    if (paramContext != null)
    {
      paramAttributeSet = com.tencent.mm.plugin.vlog.util.a.UsM;
      com.tencent.mm.plugin.vlog.util.a.iM(paramContext);
    }
    AppMethodBeat.o(282249);
  }
  
  private static final void b(TimelineEditorBaseVideoPluginLayout paramTimelineEditorBaseVideoPluginLayout)
  {
    AppMethodBeat.i(282306);
    s.u(paramTimelineEditorBaseVideoPluginLayout, "this$0");
    paramTimelineEditorBaseVideoPluginLayout.getPluginLayout().setVisibility(4);
    AppMethodBeat.o(282306);
  }
  
  private final com.tencent.mm.timelineedit.a.f getCurrentTrackPlayRange()
  {
    AppMethodBeat.i(282294);
    Object localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.p)bZ(com.tencent.mm.plugin.vlog.ui.plugin.p.class);
    int i;
    Object localObject3;
    Object localObject2;
    if (localObject1 != null)
    {
      i = ((com.tencent.mm.plugin.vlog.ui.plugin.p)localObject1).TZU;
      if (i >= 0)
      {
        localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (localObject1 != null)
        {
          localObject3 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).Uaw;
          if (localObject3 != null)
          {
            localObject2 = (com.tencent.mm.videocomposition.b)((List)((com.tencent.mm.videocomposition.j)localObject3).TDz).get(i);
            localObject1 = new com.tencent.mm.timelineedit.a.f(((com.tencent.mm.videocomposition.b)localObject2).startTimeMs, ((com.tencent.mm.videocomposition.b)localObject2).endTimeMs);
            if (!((com.tencent.mm.videocomposition.b)localObject2).TDy.isValid()) {
              break label257;
            }
            localObject1 = new com.tencent.mm.timelineedit.a.f(((com.tencent.mm.timelineedit.a.f)localObject1).startTimeMs - ((com.tencent.mm.videocomposition.b)localObject2).TDy.duration / 2L, ((com.tencent.mm.timelineedit.a.f)localObject1).endTimeMs);
          }
        }
      }
    }
    label257:
    for (;;)
    {
      localObject2 = localObject1;
      if (i + 1 < ((List)((com.tencent.mm.videocomposition.j)localObject3).TDz).size())
      {
        localObject3 = (com.tencent.mm.videocomposition.b)((List)((com.tencent.mm.videocomposition.j)localObject3).TDz).get(i + 1);
        localObject2 = localObject1;
        if (((com.tencent.mm.videocomposition.b)localObject3).TDy.isValid())
        {
          long l1 = ((com.tencent.mm.timelineedit.a.f)localObject1).startTimeMs;
          long l2 = ((com.tencent.mm.timelineedit.a.f)localObject1).endTimeMs;
          localObject2 = new com.tencent.mm.timelineedit.a.f(l1, ((com.tencent.mm.videocomposition.b)localObject3).TDy.duration / 2L + l2);
        }
      }
      AppMethodBeat.o(282294);
      return localObject2;
      AppMethodBeat.o(282294);
      return null;
    }
  }
  
  private final void setSingleTrackPlayRange(boolean paramBoolean)
  {
    AppMethodBeat.i(282275);
    com.tencent.mm.timelineedit.a.f localf = getCurrentTrackPlayRange();
    if (localf != null)
    {
      com.tencent.mm.plugin.vlog.ui.timelineeditor.f localf1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
      if (localf1 != null) {
        localf1.bs(localf.startTimeMs, localf.endTimeMs);
      }
      if (paramBoolean)
      {
        localf1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
        if (localf1 != null) {
          localf1.seek(localf.startTimeMs);
        }
      }
    }
    AppMethodBeat.o(282275);
  }
  
  public void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(282613);
    Log.i(hUH(), "loadCurrentPage time:" + System.currentTimeMillis() + " model:" + paramb);
    super.a(paramb);
    Object localObject1 = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    this.editId = (com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond());
    this.NKf = paramb;
    Object localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.e)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.e.class);
    Object localObject3;
    float f1;
    if (localObject2 != null)
    {
      localObject1 = this.Fiu;
      s.checkNotNull(localObject1);
      localObject3 = getConfigProvider();
      s.checkNotNull(localObject3);
      s.u(localObject1, "navigator");
      s.u(localObject3, "configProvider");
      localObject1 = ((RecordConfigProvider)localObject3).oSS;
      if (localObject1 == null) {
        break label1052;
      }
      localObject1 = ((Bundle)localObject1).getParcelableArrayList("media_list");
      if (localObject1 == null) {
        break label1052;
      }
      localObject3 = (GalleryItem.MediaItem)kotlin.a.p.oK((List)localObject1);
      if (((GalleryItem.MediaItem)localObject3).getType() == 2)
      {
        localObject3 = com.tencent.mm.plugin.gallery.b.g.HRf;
        localObject1 = com.tencent.mm.plugin.gallery.b.g.aBH(((GalleryItem.MediaItem)kotlin.a.p.oK((List)localObject1)).Gcc);
        f1 = ((com.tencent.mm.plugin.sight.base.b)localObject1).width / ((com.tencent.mm.plugin.sight.base.b)localObject1).height;
        localObject1 = aw.bf(((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject2).context);
        int i = ((Point)localObject1).x;
        int j = ((Point)localObject1).y;
        new Size(i, j);
        int k = ((Point)localObject1).x;
        k = ((Point)localObject1).y;
        localObject1 = com.tencent.mm.plugin.vlog.util.a.UsM;
        localObject1 = com.tencent.mm.plugin.vlog.util.a.UsM;
        com.tencent.mm.plugin.vlog.util.a.hUK();
        f1 = i / f1;
        float f2 = (j - f1) / 2.0F;
        localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject2).Uqy.getParent();
        if (!(localObject1 instanceof CropOperationContainer)) {
          break label1057;
        }
        localObject1 = (CropOperationContainer)localObject1;
        label336:
        if (localObject1 != null) {
          ((CropOperationContainer)localObject1).setEditorItemFirstTouch(false);
        }
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject2).ymw = new RectF(0.0F, f2, i, f2 + f1);
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject2).Uqy.a(((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject2).Uqz, ((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject2).ymw);
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject2).Uqz = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject2).ymw;
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject2).Uqy.a(((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject2).Uqz, ((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject2).ymw);
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject2).Uqy.setVisibility(4);
        localObject1 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
        com.tencent.mm.plugin.recordvideo.background.e.gGM().top = ((int)((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject2).ymw.top);
        localObject1 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
        com.tencent.mm.plugin.recordvideo.background.e.gGM().bottom = ((int)((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject2).ymw.bottom);
        localObject3 = new Rect();
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject2).ymw.round((Rect)localObject3);
        localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (localObject1 != null)
        {
          s.u(localObject3, "valid");
          Object localObject4 = aw.bf(MMApplicationContext.getContext());
          Object localObject5 = new Rect(0, 0, ((Point)localObject4).x, ((Point)localObject4).y);
          s.u(localObject5, "canvasRect");
          s.u(localObject3, "validRect");
          localObject4 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).Uqp;
          com.tencent.mm.timelineedit.a.c localc = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).Uqo;
          s.t(localObject5, "canvasRect");
          s.t(localObject3, "validRect");
          s.t(localc, "config");
          TimelineEditor.Companion.access$checkInitJNI(TimelineEditor.adpu);
          localObject5 = com.tencent.mm.timelineedit.a.a.H((Rect)localObject5).toByteArray();
          s.r(localObject5, "canvasRect.toProto().toByteArray()");
          localObject3 = com.tencent.mm.timelineedit.a.a.H((Rect)localObject3).toByteArray();
          s.r(localObject3, "validRect.toProto().toByteArray()");
          ((TimelineEditor)localObject4).nNg = ((TimelineEditor)localObject4).nCreate((byte[])localObject5, (byte[])localObject3, localc.jeD());
          localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).Uqp.getEffectManager();
          if (localObject1 != null)
          {
            localObject3 = (IStickerDecoderFactory)new com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder.d();
            s.t(localObject3, "factory");
            ((EffectManager)localObject1).nSetDecoderFactory(((EffectManager)localObject1).nNg, (IStickerDecoderFactory)new StickerDecoderFactoryWrapper((IStickerDecoderFactory)localObject3));
          }
        }
        localObject1 = com.tencent.mm.plugin.vlog.util.a.UsM;
        localObject1 = com.tencent.mm.plugin.vlog.util.a.j(((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject2).ymw);
        localObject2 = (com.tencent.mm.plugin.vlog.ui.plugin.ah)bZ(com.tencent.mm.plugin.vlog.ui.plugin.ah.class);
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.vlog.ui.plugin.ah)localObject2).setVisibleRect((RectF)localObject1);
        }
        localObject2 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
        ((RectF)localObject1).round(com.tencent.mm.plugin.recordvideo.background.e.getVisibleRect());
      }
    }
    else
    {
      localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
      if (localObject1 != null) {
        break label1063;
      }
    }
    label1052:
    label1057:
    label1063:
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).Uqp.getEffectManager())
    {
      com.tencent.mm.plugin.vlog.model.local.a.UbD.b((EffectManager)localObject1);
      localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).Gb(this.Ufu);
      }
      localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).u(getConfigProvider());
        localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).Uaw;
        if (localObject1 != null)
        {
          localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
          if (localObject2 != null)
          {
            s.u(localObject1, "composition");
            ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject2).Uaw = ((com.tencent.mm.videocomposition.j)localObject1);
            ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject2).GmD.a((com.tencent.mm.videocomposition.j)localObject1);
          }
          localObject2 = (af)bZ(af.class);
          if (localObject2 != null) {
            d.d.a.a((d.d)localObject2, com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a.d((com.tencent.mm.videocomposition.j)localObject1));
          }
          if (((com.tencent.mm.videocomposition.j)localObject1).getDurationMs() > getMaxCropVideoDurationMs()) {
            a.b.a((com.tencent.mm.plugin.recordvideo.plugin.parent.a)this, a.c.NOH);
          }
        }
      }
      localObject1 = (com.tencent.mm.plugin.vlog.ui.a)bZ(com.tencent.mm.plugin.vlog.ui.a.class);
      if (localObject1 != null)
      {
        s.checkNotNull(paramb);
        com.tencent.mm.plugin.vlog.ui.a.a((com.tencent.mm.plugin.vlog.ui.a)localObject1, paramb, this.oaV, false, this.Ufu, false, 20);
      }
      paramb = this.oaV;
      if (paramb != null)
      {
        localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.caption.b)bZ(com.tencent.mm.plugin.vlog.ui.plugin.caption.b.class);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).a(paramb);
        }
      }
      AppMethodBeat.o(282613);
      return;
      localObject1 = BitmapUtil.getImageOptions(((GalleryItem.MediaItem)localObject3).Gcc);
      f1 = ((BitmapFactory.Options)localObject1).outWidth / ((BitmapFactory.Options)localObject1).outHeight;
      break;
      f1 = 1.0F;
      break;
      localObject1 = null;
      break label336;
    }
  }
  
  public void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(282505);
    s.u(parama, "navigator");
    s.u(paramRecordConfigProvider, "configProvider");
    this.oaV = paramRecordConfigProvider;
    this.Fiu = parama;
    Object localObject = this.oaV;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((RecordConfigProvider)localObject).oSS)
    {
      if (localObject != null) {
        ((Bundle)localObject).setClassLoader(GalleryItem.MediaItem.class.getClassLoader());
      }
      localObject = com.tencent.mm.plugin.recordvideo.util.f.Obq;
      com.tencent.mm.plugin.recordvideo.util.f.l(paramRecordConfigProvider);
      Log.i("MicroMsg.TimelineEditorFirstEnterOperate", "checkResUpdate");
      com.tencent.mm.plugin.recordvideo.res.e.NRR.bIJ();
      com.tencent.mm.plugin.recordvideo.res.f.NRS.bIJ();
      com.tencent.mm.plugin.recordvideo.res.g.NRT.bIJ();
      com.tencent.mm.plugin.recordvideo.res.e.NRR.gJw();
      com.tencent.mm.plugin.recordvideo.res.f.NRS.gJw();
      com.tencent.mm.plugin.recordvideo.res.g.NRT.gJw();
      hUG();
      localObject = (com.tencent.mm.plugin.vlog.ui.a)bZ(com.tencent.mm.plugin.vlog.ui.a.class);
      if (localObject != null)
      {
        int i = a.h.popvideo_post_selected_origin;
        if (i > 0) {
          ((com.tencent.mm.plugin.vlog.ui.a)localObject).NMT.setImageDrawable(((com.tencent.mm.plugin.vlog.ui.a)localObject).parent.getContext().getResources().getDrawable(i));
        }
      }
      localObject = (com.tencent.mm.plugin.recordvideo.plugin.e)bZ(com.tencent.mm.plugin.recordvideo.plugin.e.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.recordvideo.plugin.e)localObject).c(Integer.valueOf(a.e.btn_solid_orange), null);
      }
      b(parama, paramRecordConfigProvider);
      super.a(parama, paramRecordConfigProvider);
      AppMethodBeat.o(282505);
      return;
    }
  }
  
  public void a(final a.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(282709);
    s.u(paramc, "status");
    label647:
    final int i;
    label699:
    label959:
    label965:
    label977:
    int j;
    Object localObject;
    label1355:
    label1660:
    final long l1;
    label1679:
    label1846:
    label1857:
    label1868:
    label2012:
    long l2;
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
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
      do
      {
        AppMethodBeat.o(282709);
        return;
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.i)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.i.class);
        if (paramc != null)
        {
          paramc.hideLoading();
          paramc = kotlin.ah.aiuX;
        }
        paramc = getContext();
        if (paramc == null)
        {
          paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(282709);
          throw paramc;
        }
        ((ViewGroup)((Activity)paramc).getWindow().getDecorView().findViewById(16908290)).setAlpha(1.0F);
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
        if (paramc == null) {}
        for (paramc = null;; paramc = paramc.GmD)
        {
          if (paramc != null) {
            paramc.setAlpha(1.0F);
          }
          paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
          if (paramc != null)
          {
            paramc = paramc.Uaw;
            if (paramc != null)
            {
              paramBundle = (com.tencent.mm.plugin.vlog.ui.plugin.ah)bZ(com.tencent.mm.plugin.vlog.ui.plugin.ah.class);
              if (paramBundle != null)
              {
                paramBundle.b(paramc);
                paramc = kotlin.ah.aiuX;
              }
              paramc = (com.tencent.mm.plugin.vlog.ui.plugin.ah)bZ(com.tencent.mm.plugin.vlog.ui.plugin.ah.class);
              if (paramc != null)
              {
                paramc.setVisibility(0);
                paramc = kotlin.ah.aiuX;
              }
            }
          }
          AppMethodBeat.o(282709);
          return;
        }
        onBackPress();
        AppMethodBeat.o(282709);
        return;
        dwY();
        AppMethodBeat.o(282709);
        return;
        hSs();
        AppMethodBeat.o(282709);
        return;
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
        if (paramc != null)
        {
          paramc.seek(0L);
          paramc = kotlin.ah.aiuX;
        }
        a(this);
        AppMethodBeat.o(282709);
        return;
        if (paramBundle != null)
        {
          bool1 = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
          paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
          if (paramc != null) {
            paramc.Gb(bool1);
          }
          paramc = kotlin.ah.aiuX;
          paramc = kotlin.ah.aiuX;
        }
        AppMethodBeat.o(282709);
        return;
        dwY();
        paramc = (t)bZ(t.class);
        if (paramc != null)
        {
          paramc.hTr();
          paramc = kotlin.ah.aiuX;
        }
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (paramc != null)
        {
          paramc = paramc.hUy();
          if (paramc != null)
          {
            paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
            if (paramBundle != null)
            {
              paramBundle = paramBundle.Uqp;
              paramBundle.nSave(paramBundle.nNg);
              paramBundle = kotlin.ah.aiuX;
            }
            paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.a)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.a.class);
            if (paramBundle != null)
            {
              com.tencent.mm.plugin.vlog.ui.timelineeditor.a.a(paramBundle, paramc);
              paramBundle = kotlin.ah.aiuX;
            }
            paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
            if (paramBundle != null)
            {
              com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a(paramBundle, paramc, false, false, 0L, 14);
              paramc = kotlin.ah.aiuX;
            }
          }
        }
        AppMethodBeat.o(282709);
        return;
        if (paramBundle != null) {
          break label699;
        }
        bool1 = false;
        if (bool1) {
          break;
        }
      } while (bool1);
      paramc = (t)bZ(t.class);
      if ((paramc != null) && (paramc.Ujc == true)) {}
      for (i = 1; i != 0; i = 0)
      {
        a(this);
        AppMethodBeat.o(282709);
        return;
        bool1 = paramBundle.getBoolean("PARAM_1_BOOLEAN", false);
        break label647;
      }
    case 12: 
    case 13: 
      dSW();
      AppMethodBeat.o(282709);
      return;
    case 14: 
      boolean bool2;
      if (paramBundle != null)
      {
        bool2 = paramBundle.getBoolean("EDIT_VLOG_TRACK_CROP_CONFIRM");
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (paramc != null)
        {
          if (bool2) {
            break label959;
          }
          bool1 = true;
          paramBundle = paramc.Uqp;
          paramBundle = (com.tencent.mm.videocomposition.j)TimelineEditor.a((kotlin.g.a.a)new TimelineEditor.o(paramBundle, bool1), (kotlin.g.a.b)new TimelineEditor.p(paramBundle));
          if (bool1) {
            paramc.setComposition(paramBundle);
          }
          paramc = paramc.Uaw;
          if (paramc != null)
          {
            if (paramc.getDurationMs() <= getMaxCropVideoDurationMs() + 200L) {
              break label977;
            }
            if (!bool2) {
              break label965;
            }
            paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
            if (paramc != null)
            {
              paramc = paramc.wQ(getMaxCropVideoDurationMs());
              if (paramc != null)
              {
                paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
                if (paramBundle != null)
                {
                  com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a(paramBundle, paramc, false, false, 0L, 12);
                  paramBundle = kotlin.ah.aiuX;
                }
                paramBundle = (af)bZ(af.class);
                if (paramBundle != null)
                {
                  d.d.a.a((d.d)paramBundle, com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a.d(paramc));
                  paramc = kotlin.ah.aiuX;
                }
              }
            }
            a(this);
          }
        }
      }
      for (;;)
      {
        paramc = kotlin.ah.aiuX;
        paramc = kotlin.ah.aiuX;
        hSs();
        paramc = kotlin.ah.aiuX;
        paramc = kotlin.ah.aiuX;
        AppMethodBeat.o(282709);
        return;
        bool1 = false;
        break;
        onBackPress();
        AppMethodBeat.o(282709);
        return;
        paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
        if (paramBundle != null)
        {
          com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a(paramBundle, paramc, false, false, 0L, 12);
          paramBundle = kotlin.ah.aiuX;
        }
        if (bool2)
        {
          paramBundle = (af)bZ(af.class);
          if (paramBundle != null)
          {
            d.d.a.a((d.d)paramBundle, com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a.d(paramc));
            paramc = kotlin.ah.aiuX;
          }
        }
        a(this);
      }
    case 15: 
      if (paramBundle != null)
      {
        dSW();
        paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
        i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
        j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
        paramBundle = paramBundle.getString("PARAM_EDIT_TEXT_FONT");
        localObject = (com.tencent.mm.plugin.recordvideo.plugin.e)bZ(com.tencent.mm.plugin.recordvideo.plugin.e.class);
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.recordvideo.plugin.e)localObject).a(paramc, i, j, paramBundle);
          paramc = kotlin.ah.aiuX;
        }
        paramc = kotlin.ah.aiuX;
      }
      AppMethodBeat.o(282709);
      return;
    case 16: 
      dwY();
      dSW();
      AppMethodBeat.o(282709);
      return;
    case 17: 
      hSs();
      a(this);
      AppMethodBeat.o(282709);
      return;
    case 18: 
      paramc = (com.tencent.mm.plugin.recordvideo.plugin.e)bZ(com.tencent.mm.plugin.recordvideo.plugin.e.class);
      if (paramc != null)
      {
        paramc.gIo();
        paramc = kotlin.ah.aiuX;
      }
      AppMethodBeat.o(282709);
      return;
    case 19: 
      paramc = (com.tencent.mm.plugin.recordvideo.plugin.c)bZ(com.tencent.mm.plugin.recordvideo.plugin.c.class);
      if (paramc != null)
      {
        paramc.gIn();
        paramc = kotlin.ah.aiuX;
      }
      AppMethodBeat.o(282709);
      return;
    case 20: 
      if (paramBundle != null)
      {
        j = paramBundle.getInt("EDIT_VLOG_SELECT_TRACK", -1);
        paramc = (com.tencent.mm.plugin.vlog.ui.plugin.p)bZ(com.tencent.mm.plugin.vlog.ui.plugin.p.class);
        if ((paramc == null) || (paramc.TZU != j)) {
          break label1355;
        }
      }
      for (i = 1;; i = 0)
      {
        if ((i == 0) && (j >= 0))
        {
          this.Urd.setVisibility(4);
          this.Urc.setVisibility(4);
          paramc = (com.tencent.mm.plugin.vlog.ui.plugin.p)bZ(com.tencent.mm.plugin.vlog.ui.plugin.p.class);
          if (paramc != null) {
            paramc.TZU = j;
          }
          paramc = (com.tencent.mm.plugin.vlog.ui.plugin.p)bZ(com.tencent.mm.plugin.vlog.ui.plugin.p.class);
          if (paramc != null)
          {
            paramc.setVisibility(0);
            paramc = kotlin.ah.aiuX;
          }
          setSingleTrackPlayRange(true);
        }
        paramc = kotlin.ah.aiuX;
        paramc = kotlin.ah.aiuX;
        AppMethodBeat.o(282709);
        return;
      }
    case 21: 
      if (this.Urd.getVisibility() != 0)
      {
        paramc = (com.tencent.mm.plugin.vlog.ui.plugin.p)bZ(com.tencent.mm.plugin.vlog.ui.plugin.p.class);
        if (paramc != null) {
          paramc.TZU = -1;
        }
        paramc = (com.tencent.mm.plugin.vlog.ui.plugin.p)bZ(com.tencent.mm.plugin.vlog.ui.plugin.p.class);
        if (paramc != null)
        {
          paramc.setVisibility(4);
          paramc = kotlin.ah.aiuX;
        }
        this.Urd.setVisibility(0);
        this.Urc.setVisibility(0);
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (paramc != null)
        {
          paramc = paramc.Uaw;
          if (paramc != null)
          {
            paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
            if (paramBundle != null)
            {
              paramBundle.bs(paramc.getPlayStart(), paramc.hQW());
              paramc = kotlin.ah.aiuX;
            }
            paramc = (af)bZ(af.class);
            if (paramc != null)
            {
              paramc.w(-1, 0L, 0L);
              paramc = kotlin.ah.aiuX;
            }
          }
        }
      }
      paramc = (t)bZ(t.class);
      if ((paramc != null) && (paramc.Ujc == true)) {}
      for (i = 1; i != 0; i = 0)
      {
        a(this);
        AppMethodBeat.o(282709);
        return;
      }
    case 22: 
      paramc = getCurrentTrack();
      if (paramc != null)
      {
        paramBundle = (com.tencent.mm.plugin.vlog.ui.plugin.ac)bZ(com.tencent.mm.plugin.vlog.ui.plugin.ac.class);
        if (paramBundle != null)
        {
          paramBundle.dC(paramc.sAn);
          paramc = kotlin.ah.aiuX;
        }
        paramc = (com.tencent.mm.plugin.vlog.ui.plugin.ac)bZ(com.tencent.mm.plugin.vlog.ui.plugin.ac.class);
        if (paramc != null)
        {
          paramc = paramc.Gvm;
          if (paramc != null)
          {
            paramc.setShow(true);
            paramc = kotlin.ah.aiuX;
          }
        }
      }
      AppMethodBeat.o(282709);
      return;
    case 23: 
    case 24: 
      float f;
      t localt;
      if (paramBundle != null)
      {
        f = paramBundle.getFloat("EDIT_TRACK_DURATION_SCALE", 1.0F);
        paramBundle = getCurrentTrack();
        if (paramBundle != null) {
          break label1846;
        }
        paramBundle = null;
        localObject = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (localObject != null) {
          break label1857;
        }
        paramBundle = null;
        localObject = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
        if (localObject != null)
        {
          localt = (t)bZ(t.class);
          if (localt != null) {
            break label1868;
          }
        }
      }
      for (bool1 = false;; bool1 = localt.hLy)
      {
        com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject, paramBundle, bool1, false, 0L, 8);
        paramBundle = kotlin.ah.aiuX;
        setSingleTrackPlayRange(true);
        paramBundle = kotlin.ah.aiuX;
        paramBundle = kotlin.ah.aiuX;
        if (paramc != a.c.NPI) {
          break;
        }
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (paramc != null)
        {
          paramc = paramc.Uaw;
          if (paramc != null)
          {
            paramBundle = (af)bZ(af.class);
            if (paramBundle != null)
            {
              d.d.a.a((d.d)paramBundle, com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a.d(paramc));
              paramc = kotlin.ah.aiuX;
            }
            paramc = (af)bZ(af.class);
            if (paramc != null)
            {
              paramc = paramc.UjU;
              if (paramc != null)
              {
                paramc.UpN = true;
                paramc = kotlin.ah.aiuX;
              }
            }
          }
        }
        AppMethodBeat.o(282709);
        return;
        paramBundle = Long.valueOf(paramBundle.id);
        break label1660;
        paramBundle = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject).a(paramBundle, f);
        break label1679;
      }
    case 25: 
      paramBundle = getCurrentTrack();
      if (paramBundle != null)
      {
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (paramc != null) {
          break label2012;
        }
      }
      for (paramc = null;; paramc = (com.tencent.mm.videocomposition.j)TimelineEditor.a((kotlin.g.a.a)new TimelineEditor.i(paramc, l1), (kotlin.g.a.b)new TimelineEditor.j(paramc)))
      {
        localObject = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
        if (localObject != null)
        {
          com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject, paramc, false, false, 0L, 14);
          paramc = kotlin.ah.aiuX;
        }
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
        if (paramc != null)
        {
          paramc.bs(((float)paramBundle.TDw / paramBundle.sAn), ((float)paramBundle.TDx / paramBundle.sAn));
          paramc = kotlin.ah.aiuX;
        }
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.h)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.h.class);
        if (paramc != null)
        {
          com.tencent.mm.plugin.vlog.ui.timelineeditor.h.a(paramc, paramBundle);
          paramc = kotlin.ah.aiuX;
        }
        AppMethodBeat.o(282709);
        return;
        l1 = paramBundle.id;
        paramc = paramc.Uqp;
      }
    case 26: 
      if ((getCurrentTrack() != null) && (paramBundle != null))
      {
        l1 = paramBundle.getLong("EDIT_VLOG_TRACK_CROP_START");
        l2 = paramBundle.getLong("EDIT_VLOG_TRAKC_CROP_END");
        paramc = getCurrentTrack();
        if (paramc == null) {}
        for (paramc = null; paramBundle.getBoolean("EDIT_VLOG_TRACK_CROP_CHANGE", false); paramc = Long.valueOf(paramc.id))
        {
          kotlinx.coroutines.j.a((aq)bu.ajwo, (kotlin.d.f)bg.kCi(), null, (m)new c(this, paramc, l1, l2, null), 2);
          AppMethodBeat.o(282709);
          return;
        }
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
        if (paramc != null)
        {
          paramc.bs(l1, l2);
          paramc = kotlin.ah.aiuX;
        }
        a(this);
        paramc = kotlin.ah.aiuX;
      }
      AppMethodBeat.o(282709);
      return;
    case 27: 
      if (paramBundle != null)
      {
        l1 = paramBundle.getLong("PARAM_1_LONG");
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
        if (paramc != null)
        {
          paramc.seek(l1);
          paramc = kotlin.ah.aiuX;
        }
      }
      AppMethodBeat.o(282709);
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
          a(this);
          paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
          if (paramc != null)
          {
            paramc.bs(l1, l2);
            paramc = kotlin.ah.aiuX;
          }
          paramc = kotlin.ah.aiuX;
        }
      }
      else
      {
        AppMethodBeat.o(282709);
        return;
      }
      dSW();
      paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
      if (paramc != null)
      {
        paramc.seek(l3);
        paramc = kotlin.ah.aiuX;
      }
      paramc = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
      if (paramc == null) {}
      for (paramc = null;; paramc = paramc.Und.getAllTTSData())
      {
        paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (paramBundle == null) {
          break;
        }
        paramc = paramBundle.lR(paramc);
        if (paramc == null) {
          break;
        }
        paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
        if (paramBundle == null) {
          break;
        }
        com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a(paramBundle, paramc, false, false, 0L, 14);
        paramc = kotlin.ah.aiuX;
        break;
      }
    case 29: 
      if (paramBundle != null)
      {
        i = paramBundle.getInt("EDIT_SELECT_TRANSITION_INDEX");
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (paramc != null)
        {
          paramBundle = paramc.Uaw;
          if (paramBundle != null)
          {
            localObject = (com.tencent.mm.videocomposition.b)((List)paramBundle.TDz).get(i);
            paramc = (com.tencent.mm.videocomposition.b)((List)paramBundle.TDz).get(i + 1);
            l2 = ((com.tencent.mm.videocomposition.b)localObject).endTimeMs - paramc.TDy.duration / 2L;
            l1 = Math.max(0L, l2 - 1000L);
            l2 = Math.min(paramBundle.getDurationMs(), l2 + 1000L);
            paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
            if (paramBundle != null)
            {
              paramBundle.bs(l1, l2);
              paramBundle = kotlin.ah.aiuX;
            }
            paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
            if (paramBundle != null)
            {
              paramBundle.seek(l1);
              paramBundle = kotlin.ah.aiuX;
            }
            paramBundle = (com.tencent.mm.plugin.vlog.ui.plugin.transition.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.transition.a.class);
            if (paramBundle != null) {
              paramBundle.UnR = l1;
            }
            paramBundle = (com.tencent.mm.plugin.vlog.ui.plugin.transition.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.transition.a.class);
            if (paramBundle != null)
            {
              paramBundle.dw(i, paramc.TDy.path);
              paramc = kotlin.ah.aiuX;
            }
          }
        }
      }
      AppMethodBeat.o(282709);
      return;
    case 30: 
      paramc = (com.tencent.mm.plugin.vlog.ui.plugin.p)bZ(com.tencent.mm.plugin.vlog.ui.plugin.p.class);
      if (paramc == null)
      {
        i = -1;
        if (i < 0) {
          break label2800;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label2806;
        }
        if (getCurrentTrack() != null)
        {
          paramc = getCurrentTrackPlayRange();
          if (paramc != null)
          {
            paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
            if (paramBundle != null)
            {
              paramBundle.bs(paramc.startTimeMs, paramc.endTimeMs);
              paramBundle = kotlin.ah.aiuX;
            }
            paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
            if (paramBundle != null)
            {
              paramBundle.seek(paramc.startTimeMs);
              paramc = kotlin.ah.aiuX;
            }
          }
        }
        AppMethodBeat.o(282709);
        return;
        i = paramc.TZU;
        break;
      }
      paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
      if (paramc != null)
      {
        paramc = paramc.Uaw;
        if (paramc != null)
        {
          paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
          if (paramBundle != null)
          {
            paramBundle.bs(paramc.agDK, paramc.jLU());
            paramc = kotlin.ah.aiuX;
          }
          paramc = (com.tencent.mm.plugin.vlog.ui.plugin.transition.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.transition.a.class);
          if (paramc != null)
          {
            l1 = paramc.UnR;
            paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
            if (paramc != null)
            {
              paramc.seek(l1);
              paramc = kotlin.ah.aiuX;
            }
          }
          a(this);
          paramc = kotlin.ah.aiuX;
          paramc = kotlin.ah.aiuX;
        }
      }
      AppMethodBeat.o(282709);
      return;
    case 31: 
      if (paramBundle != null)
      {
        paramc = paramBundle.getString("PARAM_1_STRING");
        l1 = paramBundle.getLong("PARAM_1_INT");
        j = paramBundle.getInt("EDIT_SELECT_TRANSITION_INDEX");
        paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (paramBundle != null)
        {
          paramc = paramBundle.u(paramc, l1, j);
          if (paramc != null)
          {
            paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
            if (paramBundle != null)
            {
              com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a(paramBundle, paramc, false, false, 0L, 14);
              paramc = kotlin.ah.aiuX;
            }
            paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
            if (paramc != null)
            {
              paramBundle = paramc.Uaw;
              if (paramBundle != null) {
                break label3161;
              }
              i = 0;
              if (i <= j + 1) {
                break label3190;
              }
              paramc = paramc.Uaw;
              s.checkNotNull(paramc);
              paramc = (com.tencent.mm.videocomposition.b)((List)paramc.TDz).get(j);
              l1 = paramc.TDy.duration;
              l1 = paramc.endTimeMs - l1 / 2L;
            }
          }
        }
      }
      for (paramc = new com.tencent.mm.timelineedit.a.f(l1 - 1000L, l1 + 1000L);; paramc = null)
      {
        if (paramc != null)
        {
          paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
          if (paramBundle != null)
          {
            paramBundle.bs(paramc.startTimeMs, paramc.endTimeMs);
            paramc = kotlin.ah.aiuX;
          }
        }
        AppMethodBeat.o(282709);
        return;
        paramBundle = (List)paramBundle.TDz;
        if (paramBundle == null)
        {
          i = 0;
          break;
        }
        i = paramBundle.size();
        break;
      }
    case 32: 
      if (paramBundle != null)
      {
        paramc = paramBundle.getString("PARAM_1_STRING");
        l1 = paramBundle.getLong("PARAM_1_INT");
        paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (paramBundle != null)
        {
          paramc = paramBundle.bN(paramc, l1);
          if (paramc != null)
          {
            paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
            if (paramBundle != null)
            {
              com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a(paramBundle, paramc, false, false, 0L, 14);
              paramc = kotlin.ah.aiuX;
            }
          }
        }
      }
      AppMethodBeat.o(282709);
      return;
    case 33: 
      paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
      if (paramc != null)
      {
        paramc = paramc.Uaw;
        if (paramc != null)
        {
          paramBundle = (List)paramc.TDz;
          if (paramBundle != null)
          {
            paramc = (af)bZ(af.class);
            if (paramc != null)
            {
              localObject = (Iterable)kotlin.a.p.ag(paramBundle, paramBundle.size() - 1);
              paramBundle = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
              localObject = ((Iterable)localObject).iterator();
              if (((Iterator)localObject).hasNext())
              {
                if (((com.tencent.mm.videocomposition.b)((Iterator)localObject).next()).TDy.duration > 0L) {}
                for (bool1 = true;; bool1 = false)
                {
                  paramBundle.add(Boolean.valueOf(bool1));
                  break;
                }
              }
              paramc.lP((List)paramBundle);
              paramc = kotlin.ah.aiuX;
            }
          }
        }
      }
      AppMethodBeat.o(282709);
      return;
    case 34: 
      paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.d)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.d.class);
      if (paramc != null)
      {
        ((com.google.android.material.bottomsheet.a)paramc.UiV.getValue()).show();
        paramc = kotlin.ah.aiuX;
      }
      AppMethodBeat.o(282709);
      return;
    case 35: 
    case 36: 
      label2800:
      label2806:
      if (paramBundle != null)
      {
        i = paramBundle.getInt("EDIT_COMPOSITION_TRACK_INDEX");
        bool1 = paramBundle.getBoolean("EDIT_COMPOSITION_LEFT");
        l1 = paramBundle.getLong("EDIT_VLOG_TRACK_CROP_START");
        l2 = paramBundle.getLong("EDIT_VLOG_TRAKC_CROP_END");
        paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (paramc != null) {
          kotlinx.coroutines.j.a((aq)bu.ajwo, (kotlin.d.f)bg.kCi(), null, (m)new d(paramc, i, l1, l2, bool1, this, null), 2);
        }
      }
      label3161:
      label3190:
      AppMethodBeat.o(282709);
      return;
    }
    if (paramBundle == null) {}
    for (final boolean bool1 = false;; bool1 = paramBundle.getBoolean("PARAM_1_BOOLEAN", false))
    {
      paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
      if (paramc != null)
      {
        paramc = paramc.Uaw;
        if (paramc != null)
        {
          paramBundle = com.tencent.mm.plugin.vlog.model.local.a.UbD;
          com.tencent.mm.plugin.vlog.model.local.a.a(paramc, bool1);
          paramc = kotlin.ah.aiuX;
          paramc = kotlin.ah.aiuX;
        }
      }
      paramc = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
      if (paramc == null) {
        break;
      }
      paramc.GmD.cxp();
      paramc = kotlin.ah.aiuX;
      break;
    }
  }
  
  protected void b(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    boolean bool1 = false;
    AppMethodBeat.i(282569);
    s.u(parama, "navigator");
    s.u(paramRecordConfigProvider, "configProvider");
    parama = paramRecordConfigProvider.oSS;
    if (parama != null)
    {
      boolean bool2 = parama.getBoolean("KEY_DISABLE_VIDEO_ENHANCEMENT", false);
      parama = (com.tencent.mm.plugin.vlog.ui.plugin.ah)bZ(com.tencent.mm.plugin.vlog.ui.plugin.ah.class);
      if (parama != null)
      {
        if (!bool2) {
          bool1 = true;
        }
        parama.setEnable(bool1);
      }
    }
    AppMethodBeat.o(282569);
  }
  
  protected final void dSW()
  {
    AppMethodBeat.i(282785);
    Object localObject = (t)bZ(t.class);
    if (localObject != null) {
      ((t)localObject).hTs();
    }
    localObject = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject).pause();
    }
    localObject = (com.tencent.mm.plugin.vlog.ui.a)bZ(com.tencent.mm.plugin.vlog.ui.a.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.vlog.ui.a)localObject).bLg();
    }
    AppMethodBeat.o(282785);
  }
  
  protected final void dwY()
  {
    AppMethodBeat.i(282773);
    this.Urb.animate().cancel();
    this.Urb.animate().alpha(0.0F).setDuration(100L).withEndAction(new TimelineEditorBaseVideoPluginLayout..ExternalSyntheticLambda0(this)).start();
    AppMethodBeat.o(282773);
  }
  
  protected final com.tencent.mm.media.widget.camerarecordview.b.b getCaptureInfo()
  {
    return this.NKf;
  }
  
  protected final RecordConfigProvider getConfigProvider()
  {
    return this.oaV;
  }
  
  protected final com.tencent.mm.videocomposition.b getCurrentTrack()
  {
    AppMethodBeat.i(282817);
    Object localObject = (com.tencent.mm.plugin.vlog.ui.plugin.p)bZ(com.tencent.mm.plugin.vlog.ui.plugin.p.class);
    if (localObject != null)
    {
      int i = ((com.tencent.mm.plugin.vlog.ui.plugin.p)localObject).TZU;
      if (i >= 0)
      {
        localObject = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject).Uaw;
          if (localObject != null)
          {
            localObject = (com.tencent.mm.videocomposition.b)((List)((com.tencent.mm.videocomposition.j)localObject).TDz).get(i);
            AppMethodBeat.o(282817);
            return localObject;
          }
        }
      }
    }
    AppMethodBeat.o(282817);
    return null;
  }
  
  protected final String getEditId()
  {
    return this.editId;
  }
  
  protected final long getMaxCropVideoDurationMs()
  {
    return this.Uff;
  }
  
  protected final ViewGroup getPluginLayout()
  {
    return this.Urb;
  }
  
  protected final void hSs()
  {
    AppMethodBeat.i(282743);
    this.Urb.setVisibility(0);
    this.Urb.animate().cancel();
    this.Urb.animate().alpha(1.0F).setDuration(100L).start();
    AppMethodBeat.o(282743);
  }
  
  protected final boolean hUF()
  {
    return this.Ufu;
  }
  
  protected void hUG()
  {
    AppMethodBeat.i(282551);
    Object localObject1 = findViewById(a.f.video_composition_player);
    s.s(localObject1, "findViewById(R.id.video_composition_player)");
    localObject1 = new com.tencent.mm.plugin.vlog.ui.timelineeditor.f((VideoCompositionPlayView)localObject1, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
    Object localObject2 = new com.tencent.mm.timelineedit.a.c();
    Object localObject3 = this.oaV;
    long l;
    if (localObject3 != null)
    {
      l = ((RecordConfigProvider)localObject3).oSS.getLong("video_max_duration", 60000L);
      Log.i("MicroMsg.TimelineEditorModelParser", s.X("getMaxDurationMs by parse:", Long.valueOf(l)));
    }
    for (;;)
    {
      this.Uff = l;
      ((com.tencent.mm.timelineedit.a.c)localObject2).azt(com.tencent.mm.cd.a.ms(MMApplicationContext.getContext()) / 2);
      ((com.tencent.mm.timelineedit.a.c)localObject2).azu(com.tencent.mm.cd.a.mt(MMApplicationContext.getContext()) / 2);
      new com.tencent.mm.plugin.vlog.ui.timelineeditor.b((com.tencent.mm.plugin.recordvideo.plugin.parent.a)this, (com.tencent.mm.timelineedit.a.c)localObject2);
      localObject2 = getContext();
      s.s(localObject2, "context");
      com.tencent.mm.plugin.vlog.ui.timelineeditor.i.a(new com.tencent.mm.plugin.vlog.ui.timelineeditor.i((Context)localObject2, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this));
      localObject2 = (ViewGroup)this;
      localObject3 = findViewById(a.f.editor_add_emoji);
      s.s(localObject3, "findViewById(R.id.editor_add_emoji)");
      new com.tencent.mm.plugin.recordvideo.plugin.c((ViewGroup)localObject2, (ImageView)localObject3, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
      localObject2 = findViewById(a.f.change_text_root);
      s.s(localObject2, "findViewById(R.id.change_text_root)");
      localObject2 = new com.tencent.mm.plugin.recordvideo.plugin.i((EditorInputView)localObject2, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
      ((com.tencent.mm.plugin.recordvideo.plugin.i)localObject2).NJH.setEnableClickOutsideConfirm(true);
      new com.tencent.mm.plugin.recordvideo.plugin.e((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this, ((com.tencent.mm.plugin.recordvideo.plugin.i)localObject2).NJH);
      new com.tencent.mm.plugin.vlog.ui.plugin.l((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
      localObject2 = new com.tencent.mm.plugin.vlog.ui.a((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
      ((com.tencent.mm.plugin.vlog.ui.a)localObject2).NMW = true;
      ((com.tencent.mm.plugin.vlog.ui.a)localObject2).setBackground(a.e.video_edit_panel_bg);
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject1).Uib = ((d.e)localObject2);
      localObject2 = findViewById(a.f.timeline_editor_back);
      s.s(localObject2, "findViewById(R.id.timeline_editor_back)");
      new com.tencent.mm.plugin.recordvideo.plugin.g((ImageView)localObject2, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
      new com.tencent.mm.plugin.vlog.ui.timelineeditor.e((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
      localObject2 = new com.tencent.mm.plugin.vlog.ui.timelineeditor.a((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject1).a((d.b)localObject2);
      new t((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this).a((t.a)localObject2);
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject1).a((d.b)new af((View)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this));
      new com.tencent.mm.plugin.vlog.ui.plugin.p((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
      localObject2 = findViewById(a.f.editor_track_play_rate_panel);
      s.s(localObject2, "findViewById(R.id.editor_track_play_rate_panel)");
      new com.tencent.mm.plugin.vlog.ui.plugin.ac((EditorPanelHolder)localObject2, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
      localObject2 = findViewById(a.f.editor_track_edit_panel);
      s.s(localObject2, "findViewById(R.id.editor_track_edit_panel)");
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject1).a((d.b)new com.tencent.mm.plugin.vlog.ui.timelineeditor.h((EditorPanelHolder)localObject2, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this));
      new com.tencent.mm.plugin.vlog.ui.plugin.transition.a((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this, false);
      localObject2 = findViewById(a.f.editor_add_caption_group);
      s.s(localObject2, "findViewById(R.id.editor_add_caption_group)");
      localObject2 = (ViewGroup)localObject2;
      localObject3 = findViewById(a.f.editor_caption_preview_panel);
      s.s(localObject3, "findViewById(R.id.editor_caption_preview_panel)");
      localObject3 = (EditorPanelHolder)localObject3;
      View localView = findViewById(a.f.editor_caption_edit_panel);
      s.s(localView, "findViewById(R.id.editor_caption_edit_panel)");
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject1).a((d.b)new com.tencent.mm.plugin.vlog.ui.plugin.caption.b((ViewGroup)localObject2, (EditorPanelHolder)localObject3, (EditorPanelHolder)localView, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this));
      localObject2 = findViewById(a.f.editor_tts_panel);
      s.s(localObject2, "findViewById(R.id.editor_tts_panel)");
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject1).a((d.b)new com.tencent.mm.plugin.vlog.ui.plugin.read.a((ViewGroup)localObject2, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this));
      new com.tencent.mm.plugin.vlog.ui.plugin.ah((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
      AppMethodBeat.o(282551);
      return;
      Log.i("MicroMsg.TimelineEditorModelParser", "getMaxDurationMs by default:60000");
      l = 60000L;
    }
  }
  
  protected String hUH()
  {
    return "MicroMsg.TimelineEditorVideoPluginLayout";
  }
  
  public boolean onBackPress()
  {
    AppMethodBeat.i(282830);
    if (!super.onBackPress())
    {
      com.tencent.mm.plugin.recordvideo.activity.a locala = this.Fiu;
      if (locala != null) {
        a.a.a(locala);
      }
    }
    AppMethodBeat.o(282830);
    return true;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(282759);
    super.onDetach();
    Object localObject = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject).GmD;
      if (localObject != null) {
        ((VideoCompositionPlayView)localObject).stop();
      }
    }
    localObject = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject).GmD)
    {
      if (localObject != null) {
        ((VideoCompositionPlayView)localObject).setAlpha(0.0F);
      }
      AppMethodBeat.o(282759);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(282840);
    super.release();
    com.tencent.mm.plugin.vlog.model.local.a.UbD.unInit();
    AppMethodBeat.o(282840);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(282728);
    super.reset();
    this.Urd.setVisibility(0);
    this.Urc.setVisibility(0);
    AppMethodBeat.o(282728);
  }
  
  protected final void s(Long paramLong)
  {
    AppMethodBeat.i(282801);
    Object localObject = (t)bZ(t.class);
    if (localObject != null) {
      ((t)localObject).hTr();
    }
    localObject = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject).GmD.resume();
    }
    localObject = (com.tencent.mm.plugin.vlog.ui.a)bZ(com.tencent.mm.plugin.vlog.ui.a.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.vlog.ui.a)localObject).bLh();
    }
    if (paramLong != null)
    {
      localObject = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject).seek(paramLong.longValue());
      }
    }
    AppMethodBeat.o(282801);
  }
  
  protected final void setCaptureInfo(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    this.NKf = paramb;
  }
  
  protected final void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    this.oaV = paramRecordConfigProvider;
  }
  
  protected final void setEditId(String paramString)
  {
    AppMethodBeat.i(282422);
    s.u(paramString, "<set-?>");
    this.editId = paramString;
    AppMethodBeat.o(282422);
  }
  
  protected final void setMaxCropVideoDurationMs(long paramLong)
  {
    this.Uff = paramLong;
  }
  
  protected final void setMediaMute(boolean paramBoolean)
  {
    this.Ufu = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    long Yx;
    int label;
    
    c(TimelineEditorBaseVideoPluginLayout paramTimelineEditorBaseVideoPluginLayout, Long paramLong, long paramLong1, long paramLong2, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(282199);
      paramd = new c(this.Ure, paramc, l1, this.Urg, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(282199);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(282191);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      final long l1;
      Object localObject1;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(282191);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
        l1 = System.currentTimeMillis();
        localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)this.Ure.bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (localObject1 != null)
        {
          localObject2 = paramc;
          long l2 = l1;
          long l3 = this.Urg;
          kotlin.d.d locald = (kotlin.d.d)this;
          this.L$0 = paramObject;
          this.Yx = l1;
          this.label = 1;
          localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).a((Long)localObject2, l2, l3, locald);
          if (localObject1 != locala) {
            break label356;
          }
          AppMethodBeat.o(282191);
          return locala;
        }
        break;
      case 1: 
        l1 = this.Yx;
        localObject2 = (aq)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      label356:
      for (;;)
      {
        localObject2 = (com.tencent.mm.videocomposition.j)localObject1;
        if (localObject2 != null)
        {
          localObject1 = this.Ure;
          Log.i("MicroMsg.TimelineProfile", s.X("jni updateTrackDuration coast:", kotlin.d.b.a.b.BF(System.currentTimeMillis() - l1)));
          kotlinx.coroutines.j.a(paramObject, null, (m)new a((TimelineEditorBaseVideoPluginLayout)localObject1, (com.tencent.mm.videocomposition.j)localObject2, null), 3);
          Log.i("MicroMsg.TimelineProfile", s.X("updateComposition:", kotlin.d.b.a.b.BF(System.currentTimeMillis() - l1)));
          localObject2 = com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a.d((com.tencent.mm.videocomposition.j)localObject2);
          Log.i("MicroMsg.TimelineProfile", s.X("videoComposition2VLogComposition coast:", kotlin.d.b.a.b.BF(System.currentTimeMillis() - l1)));
          paramObject = (kotlin.d.f)bg.kCh();
          localObject1 = (m)new b((TimelineEditorBaseVideoPluginLayout)localObject1, (com.tencent.mm.plugin.vlog.model.ac)localObject2, l1, null);
          this.L$0 = null;
          this.label = 2;
          if (kotlinx.coroutines.l.a(paramObject, (m)localObject1, this) == locala)
          {
            AppMethodBeat.o(282191);
            return locala;
            ResultKt.throwOnFailure(paramObject);
          }
        }
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(282191);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
    {
      int label;
      
      a(TimelineEditorBaseVideoPluginLayout paramTimelineEditorBaseVideoPluginLayout, com.tencent.mm.videocomposition.j paramj, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(282175);
        paramObject = (kotlin.d.d)new a(this.Ure, this.TXm, paramd);
        AppMethodBeat.o(282175);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(282168);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(282168);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)this.Ure.bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
        if (paramObject == null)
        {
          AppMethodBeat.o(282168);
          return null;
        }
        com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a(paramObject, this.TXm, false, false, 0L, 14);
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(282168);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends k
      implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
    {
      int label;
      
      b(TimelineEditorBaseVideoPluginLayout paramTimelineEditorBaseVideoPluginLayout, com.tencent.mm.plugin.vlog.model.ac paramac, long paramLong, kotlin.d.d<? super b> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(282188);
        paramObject = (kotlin.d.d)new b(this.Ure, this.Urh, l1, paramd);
        AppMethodBeat.o(282188);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(282181);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(282181);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = (af)this.Ure.bZ(af.class);
        if (paramObject != null) {
          d.d.a.a((d.d)paramObject, this.Urh);
        }
        Log.i("MicroMsg.TimelineProfile", s.X("VLogThumbViewPlugin:", kotlin.d.b.a.b.BF(System.currentTimeMillis() - l1)));
        TimelineEditorBaseVideoPluginLayout.c(this.Ure);
        paramObject = (af)this.Ure.bZ(af.class);
        if (paramObject != null)
        {
          paramObject = paramObject.UjU;
          if (paramObject != null) {
            paramObject.UpN = true;
          }
        }
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(282181);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    d(com.tencent.mm.plugin.vlog.ui.timelineeditor.b paramb, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean, TimelineEditorBaseVideoPluginLayout paramTimelineEditorBaseVideoPluginLayout, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(282198);
      paramObject = (kotlin.d.d)new d(this.Urj, i, l1, bool1, this.Urn, this.Ure, paramd);
      AppMethodBeat.o(282198);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(282190);
      Object localObject1 = kotlin.d.a.a.aiwj;
      int i;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(282190);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.Urj;
        i = i;
        l1 = l1;
        long l2 = bool1;
        localObject2 = (kotlin.d.d)this;
        this.label = 1;
        if (kotlinx.coroutines.l.a((kotlin.d.f)bg.kCi(), (m)new b.c(i, paramObject, l1, l2, null), (kotlin.d.d)localObject2) == localObject1)
        {
          AppMethodBeat.o(282190);
          return localObject1;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = this.Urj.hUy();
      if (paramObject != null)
      {
        boolean bool = this.Urn;
        i = i;
        localObject1 = this.Ure;
        if (!bool) {
          break label247;
        }
      }
      label247:
      for (long l1 = ((com.tencent.mm.videocomposition.b)((List)paramObject.TDz).get(i)).startTimeMs;; l1 = ((com.tencent.mm.videocomposition.b)((List)paramObject.TDz).get(i)).endTimeMs)
      {
        localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)((TimelineEditorBaseVideoPluginLayout)localObject1).bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject2).a(paramObject, false, true, l1);
        }
        paramObject = (com.tencent.mm.plugin.vlog.ui.timelineeditor.a)((TimelineEditorBaseVideoPluginLayout)localObject1).bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.a.class);
        if (paramObject != null) {
          paramObject.hSD().wP(l1);
        }
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(282190);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.scene.TimelineEditorBaseVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */