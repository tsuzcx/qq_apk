package com.tencent.mm.plugin.vlog.ui.timelineeditor.scene;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.LyricsInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.p;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.ui.plugin.d.b;
import com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup;
import com.tencent.mm.plugin.vlog.ui.plugin.timeedit.TimeEditorItemContainer;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.b.b;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.g;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.i;
import com.tencent.mm.plugin.xlabeffect.XEffectConfig;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.timelineedit.TimelineEditor;
import com.tencent.mm.timelineedit.TimelineEditor.c;
import com.tencent.mm.timelineedit.TimelineEditor.d;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.j;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.af;
import com.tencent.mm.xeffect.effect.h;
import com.tencent.mm.xeffect.effect.v;
import com.tencent.mm.xeffect.effect.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorPlatformVideoPluginLayout;", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorBaseVideoPluginLayout;", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCorePlugin$CompositionUpdateCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "syncTimeRangeList", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "addEditorTimeRange", "", "path", "timeRange", "getCurrentTrackTimeRange", "initPlugin", "initPluginLogic", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "logTag", "onBackPress", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "update", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public class TimelineEditorPlatformVideoPluginLayout
  extends TimelineEditorBaseVideoPluginLayout
  implements b.b
{
  private final HashMap<String, ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d>> Urq;
  
  public TimelineEditorPlatformVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(282220);
    this.Urq = new HashMap();
    AppMethodBeat.o(282220);
  }
  
  private static final void a(TimelineEditorPlatformVideoPluginLayout paramTimelineEditorPlatformVideoPluginLayout, View paramView)
  {
    AppMethodBeat.i(282235);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTimelineEditorPlatformVideoPluginLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorPlatformVideoPluginLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramTimelineEditorPlatformVideoPluginLayout, "this$0");
    if (paramTimelineEditorPlatformVideoPluginLayout.isAttached()) {
      a.b.a((com.tencent.mm.plugin.recordvideo.plugin.parent.a)paramTimelineEditorPlatformVideoPluginLayout, a.c.NPQ);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorPlatformVideoPluginLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282235);
  }
  
  private final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d getCurrentTrackTimeRange()
  {
    AppMethodBeat.i(282225);
    com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d locald = null;
    Object localObject = getCurrentTrack();
    if (localObject != null)
    {
      locald = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d(0L, false, 3);
      locald.bb(((com.tencent.mm.videocomposition.b)localObject).startTimeMs, ((com.tencent.mm.videocomposition.b)localObject).endTimeMs);
      localObject = ((com.tencent.mm.videocomposition.b)localObject).path;
      if (this.Urq.get(localObject) == null) {
        ((Map)this.Urq).put(localObject, new ArrayList());
      }
      localObject = (ArrayList)this.Urq.get(localObject);
      if (localObject != null) {
        ((ArrayList)localObject).add(locald);
      }
    }
    AppMethodBeat.o(282225);
    return locald;
  }
  
  public void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    Object localObject3 = null;
    AppMethodBeat.i(282298);
    super.a(paramb);
    Object localObject1 = (g)bZ(g.class);
    if (localObject1 != null) {
      ((g)localObject1).NKf = paramb;
    }
    com.tencent.mm.plugin.vlog.ui.timelineeditor.report.f localf = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.report.f.class);
    Object localObject2;
    label235:
    Object localObject4;
    label350:
    boolean bool;
    if (localf != null)
    {
      localObject1 = com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.b.v(getConfigProvider());
      localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.d)localf.bfz("21875");
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.d)localObject2).aqZ((String)localObject1);
      }
      localObject1 = com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.b.w(getConfigProvider());
      localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.d)localf.bfz("21875");
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.d)localObject2).setSessionId((String)localObject1);
      }
      localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.d)localf.bfz("21875");
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.d)localObject1).setEditId(getEditId());
      }
      localObject1 = getConfigProvider();
      if (localObject1 == null) {
        break label458;
      }
      localObject2 = ((RecordConfigProvider)localObject1).oSS.getString("post_id", "");
      Log.i("MicroMsg.TimelineEditorModelParser", s.X("getPostId by parse:", localObject2));
      s.s(localObject2, "ret");
      localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.a)localf.bfz("19904");
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.a)localObject1).setEditId(getEditId());
      }
      localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.a)localf.bfz("19904");
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.a)localObject1).bfy((String)localObject2);
      }
      localObject1 = getConfigProvider();
      if (localObject1 != null) {
        break label475;
      }
      localObject1 = null;
      localObject4 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.a)localf.bfz("19904");
      if (localObject4 != null) {
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.a)localObject4).a((XEffectConfig)localObject1);
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_MULTI_MEDIA_POST_ID_STRING", localObject2);
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_MULTI_MEDIA_EDIT_ID_STRING", getEditId());
      localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.b)localf.bfz("20741");
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.b)localObject1).setEditId(getEditId());
      }
      localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.b)localf.bfz("20741");
      if (localObject2 != null)
      {
        localObject4 = getConfigProvider();
        if (localObject4 == null) {
          break label549;
        }
        localObject1 = ((RecordConfigProvider)localObject4).oSS;
        if (localObject1 != null) {
          break label503;
        }
        localObject1 = null;
        if (Util.isNullOrNil((String)localObject1)) {
          break label514;
        }
        bool = true;
        label359:
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.b)localObject2).GoQ = bool;
      }
      if (paramb != null) {
        break label554;
      }
      paramb = localObject3;
    }
    for (;;)
    {
      localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.c)localf.bfz("21874");
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.c)localObject1).Fjx = "";
        if (paramb != null)
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("shooting_templateid", paramb.id);
          paramb = kotlin.ah.aiuX;
          paramb = ((JSONObject)localObject2).toString();
          s.s(paramb, "JSONObject().also {\n    …\n            }.toString()");
          ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.c)localObject1).Fjx = n.bV(paramb, ",", ";");
        }
      }
      AppMethodBeat.o(282298);
      return;
      label458:
      Log.i("MicroMsg.TimelineEditorModelParser", "getPostId by default:");
      localObject2 = "";
      break;
      label475:
      localObject1 = ((RecordConfigProvider)localObject1).oSS;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label235;
      }
      localObject1 = (XEffectConfig)((Bundle)localObject1).getParcelable("key_beauty_config");
      break label235;
      label503:
      localObject1 = ((Bundle)localObject1).getString("KEY_ORIGIN_MUSIC_PATH");
      break label350;
      label514:
      localObject1 = ((RecordConfigProvider)localObject4).oSS;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = (AudioCacheInfo)((Bundle)localObject1).getParcelable("KEY_SELECT_AUDIO_INFO"))
      {
        if (localObject1 == null) {
          break label549;
        }
        bool = true;
        break;
      }
      label549:
      bool = false;
      break label359;
      label554:
      localObject1 = paramb.nKf;
      paramb = localObject3;
      if (localObject1 == null) {
        continue;
      }
      localObject1 = ((Bundle)localObject1).getByteArray("KEY_POST_VIDEO_TEMPLATE");
      paramb = localObject3;
      if (localObject1 == null) {
        continue;
      }
      paramb = (com.tencent.mm.bx.a)new byy();
      try
      {
        paramb.parseFrom((byte[])localObject1);
        paramb = (byy)paramb;
      }
      catch (Exception paramb)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramb });
          paramb = null;
        }
      }
    }
  }
  
  public void a(a.c paramc, Bundle paramBundle)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(282355);
    s.u(paramc, "status");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
      localObject1 = kotlin.ah.aiuX;
    }
    for (;;)
    {
      localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.report.f.class);
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.f)localObject1).a(paramc, paramBundle);
        paramc = kotlin.ah.aiuX;
      }
      AppMethodBeat.o(282355);
      return;
      if (paramBundle != null)
      {
        localObject1 = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO");
        if (localObject1 != null)
        {
          localObject2 = getCurrentTrackTimeRange();
          Object localObject3 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
          if (localObject3 != null)
          {
            com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.a((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject3, (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((EmojiInfo)localObject1), (com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject2);
            localObject1 = kotlin.ah.aiuX;
            continue;
            if (paramBundle != null)
            {
              localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
              if (localObject1 != null)
              {
                localObject2 = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
                int i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
                int j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
                localObject3 = paramBundle.getString("PARAM_EDIT_TEXT_FONT");
                s.checkNotNull(localObject3);
                localObject2 = new r((CharSequence)localObject2, i, j, (String)localObject3);
                localObject3 = getCurrentTrackTimeRange();
                com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.a((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1, (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2, (com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject3);
                TimelineEditorBaseVideoPluginLayout.a((TimelineEditorBaseVideoPluginLayout)this);
                localObject1 = kotlin.ah.aiuX;
                localObject1 = kotlin.ah.aiuX;
                continue;
                hSs();
                TimelineEditorBaseVideoPluginLayout.a((TimelineEditorBaseVideoPluginLayout)this);
                localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                if (localObject1 != null)
                {
                  ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).hUc();
                  localObject1 = kotlin.ah.aiuX;
                  continue;
                  dwY();
                  localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.c)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.c.class);
                  if (localObject1 != null)
                  {
                    ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).hTc().setEnableLengthEdit(true);
                    localObject1 = kotlin.ah.aiuX;
                  }
                  localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                  if (localObject1 != null)
                  {
                    localObject1 = ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).Une;
                    if (localObject1 != null)
                    {
                      localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.c)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.c.class);
                      if (localObject2 != null)
                      {
                        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject2).UmZ = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1);
                        localObject2 = kotlin.ah.aiuX;
                      }
                      localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
                      if (localObject2 != null)
                      {
                        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject2).bs(((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR.NZL.getTime(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR.NZM.getTime());
                        localObject1 = kotlin.ah.aiuX;
                      }
                    }
                  }
                  localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
                  if (localObject1 != null)
                  {
                    localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).Uaw;
                    if (localObject1 != null)
                    {
                      localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.c)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.c.class);
                      if (localObject2 != null)
                      {
                        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject2).setComposition((j)localObject1);
                        localObject1 = kotlin.ah.aiuX;
                      }
                    }
                  }
                  TimelineEditorBaseVideoPluginLayout.a((TimelineEditorBaseVideoPluginLayout)this);
                  localObject1 = kotlin.ah.aiuX;
                  continue;
                  hSs();
                  localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                  label722:
                  if (localObject1 == null)
                  {
                    localObject1 = null;
                    label623:
                    if (!(localObject1 instanceof p)) {
                      break label929;
                    }
                    localObject1 = (p)localObject1;
                    label638:
                    if (localObject1 != null)
                    {
                      localObject2 = com.tencent.mm.plugin.vlog.model.local.a.UbD;
                      localObject2 = com.tencent.mm.plugin.vlog.model.local.a.hRu();
                      s.checkNotNull(localObject2);
                      localObject3 = ((EffectManager)localObject2).AS(((p)localObject1).NZm);
                      if (localObject3 != null)
                      {
                        ((af)localObject3).bL(((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR.NZL.getTime(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR.NZM.getTime());
                        localObject2 = kotlin.ah.aiuX;
                      }
                      if (!(localObject3 instanceof v)) {
                        break label935;
                      }
                      localObject2 = (v)localObject3;
                      if (localObject2 != null)
                      {
                        ((v)localObject2).a(new com.tencent.mm.xeffect.effect.f((int)((p)localObject1).centerX, (int)((p)localObject1).centerY, ((p)localObject1).scale, ((p)localObject1).aBi));
                        localObject2 = kotlin.ah.aiuX;
                      }
                      if (!(localObject3 instanceof x)) {
                        break label941;
                      }
                    }
                  }
                  label929:
                  label935:
                  label941:
                  for (localObject2 = (x)localObject3;; localObject2 = null)
                  {
                    if (localObject2 != null)
                    {
                      ((x)localObject2).a(new h(((p)localObject1).text, null, 30));
                      localObject1 = kotlin.ah.aiuX;
                    }
                    localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                    if (localObject1 != null)
                    {
                      ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).hUd();
                      localObject1 = kotlin.ah.aiuX;
                    }
                    localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
                    if (localObject1 != null)
                    {
                      localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).Uaw;
                      if (localObject1 != null)
                      {
                        localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
                        if (localObject2 != null)
                        {
                          ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject2).bs(((j)localObject1).agDK, ((j)localObject1).jLU());
                          localObject1 = kotlin.ah.aiuX;
                        }
                      }
                    }
                    TimelineEditorBaseVideoPluginLayout.a((TimelineEditorBaseVideoPluginLayout)this);
                    localObject1 = kotlin.ah.aiuX;
                    break;
                    localObject1 = ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).Une;
                    break label623;
                    localObject1 = null;
                    break label638;
                    localObject2 = null;
                    break label722;
                  }
                  if (paramBundle != null)
                  {
                    if (paramBundle.getByteArray("PARAM_1_BYTEARRAY") != null)
                    {
                      localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.caption.b)bZ(com.tencent.mm.plugin.vlog.ui.plugin.caption.b.class);
                      if (localObject1 != null)
                      {
                        ((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).hTJ();
                        localObject1 = kotlin.ah.aiuX;
                      }
                      dSW();
                      i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR", 0);
                      j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT", 0);
                      localObject1 = paramBundle.getString("PARAM_EDIT_TEXT_FONT");
                      localObject2 = (com.tencent.mm.plugin.recordvideo.plugin.e)bZ(com.tencent.mm.plugin.recordvideo.plugin.e.class);
                      if (localObject2 != null)
                      {
                        localObject3 = paramBundle.getByteArray("PARAM_1_BYTEARRAY");
                        s.checkNotNull(localObject3);
                        s.s(localObject3, "it.getByteArray(IRecordStatus.PARAM_1_BYTEARRAY)!!");
                        ((com.tencent.mm.plugin.recordvideo.plugin.e)localObject2).a((byte[])localObject3, i, j, (String)localObject1);
                        localObject1 = kotlin.ah.aiuX;
                      }
                    }
                    localObject1 = kotlin.ah.aiuX;
                    localObject1 = kotlin.ah.aiuX;
                    continue;
                    if (paramBundle != null)
                    {
                      if (paramBundle.getByteArray("PARAM_1_BYTEARRAY") != null)
                      {
                        dSW();
                        dwY();
                        localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.caption.b)bZ(com.tencent.mm.plugin.vlog.ui.plugin.caption.b.class);
                        if (localObject1 != null)
                        {
                          localObject2 = paramBundle.getByteArray("PARAM_1_BYTEARRAY");
                          s.checkNotNull(localObject2);
                          s.s(localObject2, "it.getByteArray(IRecordStatus.PARAM_1_BYTEARRAY)!!");
                          ((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).cy((byte[])localObject2);
                          localObject1 = kotlin.ah.aiuX;
                        }
                      }
                      localObject1 = kotlin.ah.aiuX;
                      localObject1 = kotlin.ah.aiuX;
                      continue;
                      TimelineEditorBaseVideoPluginLayout.a((TimelineEditorBaseVideoPluginLayout)this);
                      localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                      if (localObject1 != null)
                      {
                        ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).Und.hTZ();
                        localObject1 = kotlin.ah.aiuX;
                        continue;
                        if (paramBundle != null)
                        {
                          if (paramBundle.getByteArray("PARAM_1_BYTEARRAY") != null)
                          {
                            i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR", 0);
                            j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT", 0);
                            localObject1 = paramBundle.getString("PARAM_EDIT_TEXT_FONT");
                            localObject2 = (com.tencent.mm.plugin.vlog.ui.plugin.caption.b)bZ(com.tencent.mm.plugin.vlog.ui.plugin.caption.b.class);
                            if (localObject2 != null)
                            {
                              localObject3 = paramBundle.getByteArray("PARAM_1_BYTEARRAY");
                              s.checkNotNull(localObject3);
                              s.s(localObject3, "it.getByteArray(IRecordStatus.PARAM_1_BYTEARRAY)!!");
                              ((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject2).a((byte[])localObject3, i, j, (String)localObject1);
                              localObject1 = kotlin.ah.aiuX;
                            }
                          }
                          if (paramBundle.getLong("PARAM_1_LONG", -1L) >= 0L) {
                            s(Long.valueOf(paramBundle.getLong("PARAM_1_LONG")));
                          }
                          localObject1 = kotlin.ah.aiuX;
                          localObject1 = kotlin.ah.aiuX;
                          continue;
                          if (paramBundle != null)
                          {
                            if (paramBundle.getInt("PARAM_1_INT") == 0) {}
                            for (localObject1 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYi;; localObject1 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYj)
                            {
                              localObject2 = paramBundle.getByteArray("PARAM_1_BYTEARRAY");
                              s.checkNotNull(localObject2);
                              s.s(localObject2, "it.getByteArray(IRecordStatus.PARAM_1_BYTEARRAY)!!");
                              localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.c((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localObject1, (byte[])localObject2);
                              localObject2 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                              if (localObject2 == null) {
                                break;
                              }
                              com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.a((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject2, (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1, getCurrentTrackTimeRange());
                              localObject1 = kotlin.ah.aiuX;
                              break;
                            }
                            if (paramBundle != null)
                            {
                              i = paramBundle.getInt("PARAM_1_INT");
                              localObject2 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                              if (localObject2 != null)
                              {
                                if (i == 1) {}
                                for (localObject1 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYj;; localObject1 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYi)
                                {
                                  ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject2).c((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localObject1);
                                  localObject1 = kotlin.ah.aiuX;
                                  break;
                                }
                                localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                                if (localObject1 != null)
                                {
                                  localObject1 = ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).Une;
                                  if (localObject1 != null)
                                  {
                                    dSW();
                                    localObject2 = (com.tencent.mm.plugin.vlog.ui.plugin.read.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.read.a.class);
                                    if (localObject2 != null)
                                    {
                                      ((com.tencent.mm.plugin.vlog.ui.plugin.read.a)localObject2).a((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1);
                                      localObject1 = kotlin.ah.aiuX;
                                      continue;
                                      if (paramBundle != null)
                                      {
                                        paramBundle.getLong("PARAM_1_LONG");
                                        localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                                        if (localObject1 == null)
                                        {
                                          localObject1 = null;
                                          label1615:
                                          if (!(localObject1 instanceof p)) {
                                            break label1872;
                                          }
                                          localObject1 = (p)localObject1;
                                          label1630:
                                          if (localObject1 != null)
                                          {
                                            localObject3 = com.tencent.mm.plugin.vlog.model.local.a.UbD;
                                            localObject3 = com.tencent.mm.plugin.vlog.model.local.a.hRu();
                                            s.checkNotNull(localObject3);
                                            localObject3 = ((EffectManager)localObject3).AS(((p)localObject1).NZm);
                                            if (localObject3 != null)
                                            {
                                              ((af)localObject3).bL(((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR.NZL.getTime(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR.NZM.getTime());
                                              localObject1 = kotlin.ah.aiuX;
                                            }
                                          }
                                          localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                                          if (localObject1 != null)
                                          {
                                            ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).Und.hUh();
                                            localObject1 = kotlin.ah.aiuX;
                                          }
                                          localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                                          if (localObject1 != null)
                                          {
                                            ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).hUd();
                                            localObject1 = kotlin.ah.aiuX;
                                          }
                                          localObject3 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
                                          if (localObject3 != null)
                                          {
                                            localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                                            if (localObject1 != null) {
                                              break label1878;
                                            }
                                          }
                                        }
                                        label1872:
                                        label1878:
                                        for (localObject1 = localObject2;; localObject1 = ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).Und.getAllTTSData())
                                        {
                                          localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject3).lR((List)localObject1);
                                          if (localObject1 != null)
                                          {
                                            localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
                                            if (localObject2 != null)
                                            {
                                              com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject2, (j)localObject1, false, false, 0L, 14);
                                              localObject1 = kotlin.ah.aiuX;
                                            }
                                          }
                                          TimelineEditorBaseVideoPluginLayout.a((TimelineEditorBaseVideoPluginLayout)this);
                                          localObject1 = kotlin.ah.aiuX;
                                          localObject1 = kotlin.ah.aiuX;
                                          break;
                                          localObject1 = ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).Une;
                                          break label1615;
                                          localObject1 = null;
                                          break label1630;
                                        }
                                        final boolean bool;
                                        Object localObject4;
                                        label2060:
                                        long l;
                                        if (paramBundle != null)
                                        {
                                          bool = paramBundle.getBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN");
                                          localObject1 = (LyricsInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_LYRICS_LIST");
                                          localObject2 = new ArrayList();
                                          if (localObject1 != null)
                                          {
                                            localObject1 = ((Iterable)((LyricsInfo)localObject1).NJq).iterator();
                                            for (;;)
                                            {
                                              if (((Iterator)localObject1).hasNext())
                                              {
                                                byte[] arrayOfByte = (byte[])((Iterator)localObject1).next();
                                                localObject3 = new dki();
                                                localObject4 = (com.tencent.mm.bx.a)localObject3;
                                                try
                                                {
                                                  ((com.tencent.mm.bx.a)localObject4).parseFrom(arrayOfByte);
                                                  ((ArrayList)localObject2).add(localObject3);
                                                }
                                                catch (Exception localException)
                                                {
                                                  for (;;)
                                                  {
                                                    Log.printDebugStack("safeParser", "", new Object[] { localException });
                                                  }
                                                }
                                              }
                                            }
                                            localObject1 = kotlin.ah.aiuX;
                                            localObject1 = kotlin.ah.aiuX;
                                          }
                                          if (!bool) {
                                            break label2189;
                                          }
                                          localObject1 = (com.tencent.mm.plugin.vlog.ui.a)bZ(com.tencent.mm.plugin.vlog.ui.a.class);
                                          if (localObject1 != null) {
                                            break label2168;
                                          }
                                          localObject1 = null;
                                          localObject2 = (List)localObject2;
                                          if (localObject1 != null) {
                                            break label2178;
                                          }
                                          l = 0L;
                                          label2075:
                                          localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.m((List)localObject2, l);
                                          localObject2 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                                          if (localObject2 != null)
                                          {
                                            ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject2).a(com.tencent.mm.plugin.recordvideo.ui.editor.view.b.OaH);
                                            localObject2 = kotlin.ah.aiuX;
                                          }
                                          localObject2 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                                          if (localObject2 != null)
                                          {
                                            com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.a((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject2, (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1, null, null, 0L, 12);
                                            localObject1 = kotlin.ah.aiuX;
                                          }
                                        }
                                        for (;;)
                                        {
                                          localObject1 = kotlin.ah.aiuX;
                                          localObject1 = kotlin.ah.aiuX;
                                          break;
                                          label2168:
                                          localObject1 = ((com.tencent.mm.plugin.vlog.ui.a)localObject1).Gss;
                                          break label2060;
                                          label2178:
                                          l = ((AudioCacheInfo)localObject1).duration;
                                          break label2075;
                                          label2189:
                                          localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                                          if (localObject1 != null)
                                          {
                                            ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).a(com.tencent.mm.plugin.recordvideo.ui.editor.view.b.OaH);
                                            localObject1 = kotlin.ah.aiuX;
                                          }
                                        }
                                        if (paramBundle != null)
                                        {
                                          i = paramBundle.getInt("PARAM_DELETE_VIEW_TYPE_INT");
                                          if (i != com.tencent.mm.plugin.recordvideo.ui.editor.view.b.OaH.ordinal()) {
                                            break label2286;
                                          }
                                          localObject1 = (com.tencent.mm.plugin.vlog.ui.a)bZ(com.tencent.mm.plugin.vlog.ui.a.class);
                                          if (localObject1 != null)
                                          {
                                            ((com.tencent.mm.plugin.vlog.ui.a)localObject1).hSl();
                                            localObject1 = kotlin.ah.aiuX;
                                          }
                                        }
                                        for (;;)
                                        {
                                          TimelineEditorBaseVideoPluginLayout.a((TimelineEditorBaseVideoPluginLayout)this);
                                          localObject1 = kotlin.ah.aiuX;
                                          break;
                                          label2286:
                                          if (i == com.tencent.mm.plugin.recordvideo.ui.editor.view.b.OaJ.ordinal())
                                          {
                                            localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.caption.b)bZ(com.tencent.mm.plugin.vlog.ui.plugin.caption.b.class);
                                            if (localObject1 != null)
                                            {
                                              ((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).apH(0);
                                              localObject1 = kotlin.ah.aiuX;
                                            }
                                          }
                                          else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.view.b.OaK.ordinal())
                                          {
                                            localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.caption.b)bZ(com.tencent.mm.plugin.vlog.ui.plugin.caption.b.class);
                                            if (localObject1 != null)
                                            {
                                              ((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).apH(1);
                                              localObject1 = kotlin.ah.aiuX;
                                            }
                                          }
                                          else
                                          {
                                            localObject1 = kotlin.ah.aiuX;
                                          }
                                        }
                                        localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                                        if (localObject1 != null)
                                        {
                                          ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).hUd();
                                          localObject1 = kotlin.ah.aiuX;
                                        }
                                        TimelineEditorBaseVideoPluginLayout.a((TimelineEditorBaseVideoPluginLayout)this);
                                        localObject1 = kotlin.ah.aiuX;
                                        continue;
                                        localObject2 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                                        if (localObject2 != null)
                                        {
                                          ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject2).Und.hUh();
                                          localObject2 = kotlin.ah.aiuX;
                                        }
                                        localObject2 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                                        if (localObject2 != null)
                                        {
                                          ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject2).hUd();
                                          localObject2 = kotlin.ah.aiuX;
                                        }
                                        localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
                                        if (localObject2 != null)
                                        {
                                          localObject3 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                                          if (localObject3 != null) {
                                            break label2572;
                                          }
                                        }
                                        for (;;)
                                        {
                                          localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject2).lR((List)localObject1);
                                          if (localObject1 != null)
                                          {
                                            localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
                                            if (localObject2 != null)
                                            {
                                              com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject2, (j)localObject1, false, false, 0L, 14);
                                              localObject1 = kotlin.ah.aiuX;
                                            }
                                          }
                                          TimelineEditorBaseVideoPluginLayout.a((TimelineEditorBaseVideoPluginLayout)this);
                                          localObject1 = kotlin.ah.aiuX;
                                          break;
                                          label2572:
                                          localObject1 = ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject3).Und.getAllTTSData();
                                        }
                                        dSW();
                                        localObject1 = (i)bZ(i.class);
                                        if (localObject1 != null)
                                        {
                                          i.a((i)localObject1);
                                          localObject1 = kotlin.ah.aiuX;
                                        }
                                        localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                                        if (localObject1 != null)
                                        {
                                          localObject2 = new Rect(0, 0, ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).Und.getWidth(), ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).Und.getHeight());
                                          localObject3 = (g)bZ(g.class);
                                          if (localObject3 != null)
                                          {
                                            ((g)localObject3).a((Rect)localObject2, com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.gIr(), (List)((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).Und.getEditorDataList());
                                            localObject2 = kotlin.ah.aiuX;
                                          }
                                          localObject2 = new Rect(0, 0, ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).Und.getWidth(), ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).Und.getHeight());
                                          localObject3 = new Rect();
                                          localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.e)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.e.class);
                                          if (localObject1 != null)
                                          {
                                            localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject1).ymw;
                                            if (localObject1 != null)
                                            {
                                              ((RectF)localObject1).round((Rect)localObject3);
                                              localObject1 = kotlin.ah.aiuX;
                                            }
                                          }
                                          localObject1 = kotlin.ah.aiuX;
                                          final Rect localRect = new Rect();
                                          localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.e)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.e.class);
                                          if (localObject1 != null)
                                          {
                                            localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject1).Uqz;
                                            if (localObject1 != null)
                                            {
                                              ((RectF)localObject1).round(localRect);
                                              localObject1 = kotlin.ah.aiuX;
                                            }
                                          }
                                          localObject1 = kotlin.ah.aiuX;
                                          localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.ah)bZ(com.tencent.mm.plugin.vlog.ui.plugin.ah.class);
                                          if (localObject1 == null)
                                          {
                                            bool = false;
                                            label2859:
                                            localObject1 = (com.tencent.mm.plugin.vlog.ui.a)bZ(com.tencent.mm.plugin.vlog.ui.a.class);
                                            if (localObject1 != null) {
                                              break label2936;
                                            }
                                          }
                                          label2936:
                                          for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.vlog.ui.a)localObject1).Gss)
                                          {
                                            if (localObject1 == null) {
                                              break label2946;
                                            }
                                            localObject4 = com.tencent.mm.plugin.recordvideo.model.audio.k.NJr;
                                            com.tencent.mm.plugin.recordvideo.model.audio.k.gIk().a((AudioCacheInfo)localObject1, (kotlin.g.a.m)new b(this, (AudioCacheInfo)localObject1, (Rect)localObject2, (Rect)localObject3, localRect, bool));
                                            localObject1 = kotlin.ah.aiuX;
                                            break;
                                            bool = ((com.tencent.mm.plugin.vlog.ui.plugin.ah)localObject1).Ukk;
                                            break label2859;
                                          }
                                          label2946:
                                          localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
                                          if (localObject1 != null)
                                          {
                                            localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).Uaw;
                                            if (localObject1 != null)
                                            {
                                              localObject4 = (g)bZ(g.class);
                                              if (localObject4 != null)
                                              {
                                                ((g)localObject4).a((j)localObject1, getEditId(), (Rect)localObject2, (Rect)localObject3, localRect, bool, (kotlin.g.a.b)new c(this));
                                                localObject1 = kotlin.ah.aiuX;
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected final void b(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(282273);
    s.u(parama, "navigator");
    s.u(paramRecordConfigProvider, "configProvider");
    setOnClickListener(new TimelineEditorPlatformVideoPluginLayout..ExternalSyntheticLambda0(this));
    super.b(parama, paramRecordConfigProvider);
    Object localObject = (g)bZ(g.class);
    if (localObject != null)
    {
      s.u(parama, "navigator");
      s.u(paramRecordConfigProvider, "configProvider");
      ((g)localObject).Fiu = parama;
      ((g)localObject).oaV = paramRecordConfigProvider;
    }
    parama = (com.tencent.mm.plugin.vlog.ui.timelineeditor.e)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.e.class);
    if (parama != null)
    {
      localObject = new Rect();
      parama.ymw.round((Rect)localObject);
      com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a locala = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
      if (locala != null) {
        locala.e(paramRecordConfigProvider);
      }
      paramRecordConfigProvider = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
      if (paramRecordConfigProvider != null) {
        paramRecordConfigProvider.G((Rect)localObject);
      }
      parama = parama.ymw;
      paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.background.e.NDU;
      parama.round(com.tencent.mm.plugin.recordvideo.background.e.gGM());
    }
    AppMethodBeat.o(282273);
  }
  
  public final void c(j paramj)
  {
    AppMethodBeat.i(282367);
    Object localObject2;
    if (paramj != null)
    {
      localObject1 = (List)paramj.TDz;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.videocomposition.b)((Iterator)localObject1).next();
          Object localObject3 = (ArrayList)this.Urq.get(((com.tencent.mm.videocomposition.b)localObject2).path);
          if (localObject3 != null)
          {
            localObject3 = ((Iterable)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d locald = (com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)((Iterator)localObject3).next();
              long l1 = ((com.tencent.mm.videocomposition.b)localObject2).startTimeMs;
              long l2 = ((com.tencent.mm.videocomposition.b)localObject2).endTimeMs;
              locald.NZL.tF(l1);
              locald.NZM.tF(l2);
            }
          }
        }
      }
    }
    Object localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.caption.b)bZ(com.tencent.mm.plugin.vlog.ui.plugin.caption.b.class);
    if (localObject1 != null)
    {
      ((ArrayList)((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).UkI.get(0)).clear();
      if (paramj != null)
      {
        paramj = (List)paramj.TDz;
        if (paramj != null)
        {
          paramj = ((Iterable)paramj).iterator();
          while (paramj.hasNext())
          {
            localObject2 = (com.tencent.mm.videocomposition.b)paramj.next();
            localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a(((com.tencent.mm.videocomposition.b)localObject2).path, ((com.tencent.mm.videocomposition.b)localObject2).TDw, ((com.tencent.mm.videocomposition.b)localObject2).TDx, ((com.tencent.mm.videocomposition.b)localObject2).sAn);
            ((ArrayList)((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).UkI.get(0)).add(localObject2);
            Log.i("MicroMsg.EditorCaptionPlugin", s.X("update script:", localObject2));
          }
        }
      }
      if (((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).UkM)
      {
        ((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).apJ(0);
        ((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).apG(0);
      }
    }
    AppMethodBeat.o(282367);
  }
  
  protected final void hUG()
  {
    AppMethodBeat.i(282259);
    super.hUG();
    Object localObject1 = (TimeEditorItemContainer)findViewById(a.f.video_editor_item_container);
    s.s(localObject1, "editorContainerView");
    new com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a((TimeEditorItemContainer)localObject1, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
    Object localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject2).a((d.b)localObject1);
    }
    localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
    if (localObject1 != null)
    {
      localObject2 = (b.b)this;
      s.u(localObject2, "callback");
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).Uqq.add(localObject2);
    }
    localObject1 = findViewById(a.f.editor_time_edit_panel);
    s.s(localObject1, "findViewById(R.id.editor_time_edit_panel)");
    localObject1 = new com.tencent.mm.plugin.vlog.ui.timelineeditor.c((EditorPanelHolder)localObject1, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
    localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject2).a((d.b)localObject1);
    }
    localObject1 = findViewById(a.f.timeline_finish);
    s.s(localObject1, "findViewById(R.id.timeline_finish)");
    new g((View)localObject1, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
    localObject1 = (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this;
    localObject2 = getContext();
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(282259);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((Activity)localObject2).getIntent();
    s.s(localObject2, "context as Activity).intent");
    localObject1 = new com.tencent.mm.plugin.vlog.ui.timelineeditor.report.f((com.tencent.mm.plugin.recordvideo.plugin.parent.a)localObject1, (Intent)localObject2);
    ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.f)localObject1).a((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.e)new com.tencent.mm.plugin.vlog.ui.timelineeditor.report.a((BasePluginLayout)this));
    ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.f)localObject1).a((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.e)new com.tencent.mm.plugin.vlog.ui.timelineeditor.report.b((BasePluginLayout)this));
    ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.f)localObject1).a((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.e)new com.tencent.mm.plugin.vlog.ui.timelineeditor.report.d((BasePluginLayout)this));
    ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.f)localObject1).a((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.e)new com.tencent.mm.plugin.vlog.ui.timelineeditor.report.c((BasePluginLayout)this));
    AppMethodBeat.o(282259);
  }
  
  protected String hUH()
  {
    return "MicroMsg.TimelineEditorPlatformVideoPluginLayout";
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(282304);
    if (super.onBackPress())
    {
      localf = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.report.f.class);
      if (localf != null) {
        localf.hUB();
      }
      AppMethodBeat.o(282304);
      return true;
    }
    com.tencent.mm.plugin.vlog.ui.timelineeditor.report.f localf = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.f)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.report.f.class);
    if (localf != null) {
      localf.hUB();
    }
    AppMethodBeat.o(282304);
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "filePath", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.m<Boolean, String, kotlin.ah>
  {
    b(TimelineEditorPlatformVideoPluginLayout paramTimelineEditorPlatformVideoPluginLayout, AudioCacheInfo paramAudioCacheInfo, Rect paramRect1, Rect paramRect2, Rect paramRect3, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    c(TimelineEditorPlatformVideoPluginLayout paramTimelineEditorPlatformVideoPluginLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.scene.TimelineEditorPlatformVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */