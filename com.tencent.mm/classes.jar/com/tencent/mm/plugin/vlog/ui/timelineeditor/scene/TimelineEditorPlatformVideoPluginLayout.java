package com.tencent.mm.plugin.vlog.ui.timelineeditor.scene;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.LyricsInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.k;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.ui.plugin.ai;
import com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup;
import com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup.a;
import com.tencent.mm.plugin.vlog.ui.plugin.timeedit.TimeEditorItemContainer;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.b.b;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.c.c;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.c.d;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.c.e;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.i;
import com.tencent.mm.plugin.xlabeffect.XEffectConfig;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.timelineedit.TimelineEditor;
import com.tencent.mm.timelineedit.TimelineEditor.c;
import com.tencent.mm.timelineedit.TimelineEditor.d;
import com.tencent.mm.vfs.u;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.af;
import com.tencent.mm.xeffect.effect.v;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.g.b.aa.f;
import kotlin.g.b.q;
import kotlin.l;
import kotlinx.coroutines.ak;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorPlatformVideoPluginLayout;", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorBaseVideoPluginLayout;", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCorePlugin$CompositionUpdateCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "syncTimeRangeList", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "addEditorTimeRange", "", "path", "timeRange", "getCurrentTrackTimeRange", "initPlugin", "initPluginLogic", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "logTag", "onBackPress", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "update", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "plugin-vlog_release"})
public class TimelineEditorPlatformVideoPluginLayout
  extends TimelineEditorBaseVideoPluginLayout
  implements b.b
{
  private final HashMap<String, ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d>> NFe;
  
  public TimelineEditorPlatformVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(237368);
    this.NFe = new HashMap();
    AppMethodBeat.o(237368);
  }
  
  private final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d getCurrentTrackTimeRange()
  {
    AppMethodBeat.i(237364);
    com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d locald = null;
    Object localObject = getCurrentTrack();
    if (localObject != null)
    {
      locald = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d(0L, false, 3);
      locald.ar(((com.tencent.mm.videocomposition.b)localObject).startTimeMs, ((com.tencent.mm.videocomposition.b)localObject).endTimeMs);
      localObject = ((com.tencent.mm.videocomposition.b)localObject).path;
      if (this.NFe.get(localObject) == null) {
        ((Map)this.NFe).put(localObject, new ArrayList());
      }
      localObject = (ArrayList)this.NFe.get(localObject);
      if (localObject == null) {
        break label105;
      }
      ((ArrayList)localObject).add(locald);
    }
    label105:
    for (;;)
    {
      AppMethodBeat.o(237364);
      return locald;
    }
  }
  
  public void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(237356);
    super.a(paramb);
    Object localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h.class);
    if (localObject2 != null)
    {
      paramb = com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.b.p(getConfigProvider());
      Object localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.e)((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h)localObject2).bfT("21875");
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.e)localObject1).awV(paramb);
      }
      paramb = com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.b.q(getConfigProvider());
      localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.e)((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h)localObject2).bfT("21875");
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.e)localObject1).setSessionId(paramb);
      }
      paramb = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.e)((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h)localObject2).bfT("21875");
      if (paramb != null) {
        paramb.setEditId(getEditId());
      }
      paramb = getConfigProvider();
      label216:
      boolean bool;
      if (paramb != null)
      {
        paramb = paramb.mab.getString("post_id", "");
        "getPostId by parse:".concat(String.valueOf(paramb));
        com.tencent.d.f.h.ioq();
        kotlin.g.b.p.j(paramb, "ret");
        localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.a)((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h)localObject2).bfT("19904");
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.a)localObject1).setEditId(getEditId());
        }
        localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.a)((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h)localObject2).bfT("19904");
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.a)localObject1).bfS(paramb);
        }
        localObject1 = getConfigProvider();
        if (localObject1 == null) {
          break label361;
        }
        localObject1 = ((RecordConfigProvider)localObject1).mab;
        if (localObject1 == null) {
          break label361;
        }
        localObject1 = (XEffectConfig)((Bundle)localObject1).getParcelable("key_beauty_config");
        com.tencent.mm.plugin.vlog.ui.timelineeditor.report.a locala = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.a)((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h)localObject2).bfT("19904");
        if (locala != null) {
          locala.a((XEffectConfig)localObject1);
        }
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_MULTI_MEDIA_POST_ID_STRING", paramb);
        paramb = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_MULTI_MEDIA_EDIT_ID_STRING", getEditId());
        paramb = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.c)((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h)localObject2).bfT("20741");
        if (paramb != null) {
          paramb.setEditId(getEditId());
        }
        localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.c)((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h)localObject2).bfT("20741");
        if (localObject1 == null) {
          break label411;
        }
        localObject2 = getConfigProvider();
        if (localObject2 == null) {
          break label406;
        }
        paramb = ((RecordConfigProvider)localObject2).mab;
        if (paramb == null) {
          break label366;
        }
        paramb = paramb.getString("KEY_ORIGIN_MUSIC_PATH");
        label332:
        if (Util.isNullOrNil(paramb)) {
          break label371;
        }
        bool = true;
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.c)localObject1).AMb = bool;
        AppMethodBeat.o(237356);
        return;
        com.tencent.d.f.h.ioq();
        paramb = "";
        break;
        label361:
        localObject1 = null;
        break label216;
        label366:
        paramb = null;
        break label332;
        label371:
        paramb = ((RecordConfigProvider)localObject2).mab;
        if (paramb != null) {}
        for (paramb = (AudioCacheInfo)paramb.getParcelable("KEY_SELECT_AUDIO_INFO");; paramb = null)
        {
          if (paramb == null) {
            break label406;
          }
          bool = true;
          break;
        }
        label406:
        bool = false;
      }
      label411:
      AppMethodBeat.o(237356);
      return;
    }
    AppMethodBeat.o(237356);
  }
  
  public void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(237362);
    kotlin.g.b.p.k(paramc, "status");
    Object localObject1;
    Object localObject3;
    int i;
    int j;
    Object localObject4;
    long l;
    switch (c.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      for (;;)
      {
        localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h.class);
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h)localObject1).a(paramc, paramBundle);
        paramc = kotlin.x.aazN;
        AppMethodBeat.o(237362);
        return;
        if (paramBundle != null)
        {
          localObject1 = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO");
          if (localObject1 != null)
          {
            localObject2 = getCurrentTrackTimeRange();
            localObject3 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
            if (localObject3 != null)
            {
              com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.a((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject3, (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((EmojiInfo)localObject1), (com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject2);
              localObject1 = kotlin.x.aazN;
              continue;
              if (paramBundle != null)
              {
                localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                if (localObject1 != null)
                {
                  localObject2 = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
                  i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
                  j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
                  localObject3 = paramBundle.getString("PARAM_EDIT_TEXT_FONT");
                  if (localObject3 == null) {
                    kotlin.g.b.p.iCn();
                  }
                  localObject2 = new r((CharSequence)localObject2, i, j, (String)localObject3);
                  localObject3 = getCurrentTrackTimeRange();
                  com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.a((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1, (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2, (com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject3);
                  TimelineEditorBaseVideoPluginLayout.a(this);
                  localObject1 = kotlin.x.aazN;
                  continue;
                  guD();
                  TimelineEditorBaseVideoPluginLayout.a(this);
                  localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                  if (localObject1 != null)
                  {
                    ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).gwl();
                    localObject1 = kotlin.x.aazN;
                    continue;
                    cSG();
                    localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.c)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.c.class);
                    if (localObject1 != null)
                    {
                      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).gvm().setEnableLengthEdit(true);
                      localObject1 = kotlin.x.aazN;
                    }
                    localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
                    if (localObject1 != null)
                    {
                      localObject1 = ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).NAn;
                      if (localObject1 != null)
                      {
                        localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.c)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.c.class);
                        if (localObject2 != null)
                        {
                          ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject2).NAi = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1);
                          localObject2 = kotlin.x.aazN;
                        }
                        localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
                        if (localObject2 != null)
                        {
                          ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject2).aG(((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibr.Ido.getTime(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibr.Idp.getTime());
                          localObject1 = kotlin.x.aazN;
                        }
                      }
                    }
                    localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
                    if (localObject1 != null)
                    {
                      localObject2 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).NmT;
                      if (localObject2 != null)
                      {
                        localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.c)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.c.class);
                        if (localObject1 != null)
                        {
                          kotlin.g.b.p.k(localObject2, "composition");
                          localObject3 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).NAi;
                          if (localObject3 != null)
                          {
                            ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).Nuj = false;
                            if (!((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).jvb)
                            {
                              ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).jvb = true;
                              ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).ATq.setCloseTouchOutside(true);
                              ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).gvm().setCallback((TimeCropViewGroup.a)((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).NDX);
                              ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).gvm().setRealTimeCallback((TimeCropViewGroup.a)((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).NDX);
                              ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).ATq.setOnVisibleChangeCallback((kotlin.g.a.b)new c.c((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1));
                              ((ImageView)((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).NAe.getValue()).setOnClickListener((View.OnClickListener)new c.d((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1));
                              ((ImageView)((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).NAf.getValue()).setOnClickListener((View.OnClickListener)new c.e((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1));
                            }
                            ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).Nvc = (((com.tencent.mm.videocomposition.j)localObject2).igH().getStartUs() / 1000L);
                            ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).Nvd = (((com.tencent.mm.videocomposition.j)localObject2).igH().getEndUs() / 1000L);
                            if (((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject3).Ibr.Idp.getTime() > ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).Nvd)
                            {
                              localObject4 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject3).Ibr.Idp;
                              ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c)localObject4).PF(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c)localObject4).offset + (((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).Nvd - ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject3).Ibr.Idp.getTime()));
                            }
                            ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).Nve = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject3).Ibr.Ido.getTime();
                            ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).Nvf = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject3).Ibr.Idp.getTime();
                            ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).NAg = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).Nve;
                            ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).NAh = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).Nvf;
                            localObject4 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d(0L, false, 3);
                            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject4).ar(((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).NAg, ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).NAh);
                            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject3).Ibq = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject4);
                            Log.i("MicroMsg.VLogTimeEditPlugin", "time range:" + ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject3).Ibr);
                            localObject3 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).gvm();
                            localObject2 = com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a.d((com.tencent.mm.videocomposition.j)localObject2);
                            localObject4 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).NAi;
                            if (localObject4 == null) {
                              kotlin.g.b.p.iCn();
                            }
                            l = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject4).Ibr.getStart();
                            localObject4 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).NAi;
                            if (localObject4 == null) {
                              kotlin.g.b.p.iCn();
                            }
                            ((TimeCropViewGroup)localObject3).a((ac)localObject2, l, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject4).Ibr.getEnd());
                            ((com.tencent.mm.plugin.vlog.ui.timelineeditor.c)localObject1).ATq.setShow(true);
                          }
                          localObject1 = kotlin.x.aazN;
                        }
                      }
                    }
                    TimelineEditorBaseVideoPluginLayout.a(this);
                  }
                }
              }
            }
          }
        }
      }
    case 5: 
      guD();
      localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).NAn;
        label1037:
        localObject2 = localObject1;
        if (!(localObject1 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.p)) {
          localObject2 = null;
        }
        localObject3 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.p)localObject2;
        if (localObject3 != null)
        {
          localObject1 = com.tencent.mm.plugin.vlog.model.local.a.Nol;
          localObject1 = com.tencent.mm.plugin.vlog.model.local.a.gtM();
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          localObject1 = ((EffectManager)localObject1).WH(((com.tencent.mm.plugin.recordvideo.ui.editor.item.p)localObject3).IcQ);
          if (localObject1 != null)
          {
            ((af)localObject1).aZ(((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject3).Ibr.getStart(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject3).Ibr.getEnd());
            localObject2 = kotlin.x.aazN;
          }
          if ((localObject1 instanceof v)) {
            break label3387;
          }
        }
      }
      break;
    }
    label2432:
    label2452:
    label3387:
    for (Object localObject2 = null;; localObject2 = localObject1)
    {
      localObject2 = (v)localObject2;
      if (localObject2 != null)
      {
        ((v)localObject2).a(new com.tencent.mm.xeffect.effect.f((int)((com.tencent.mm.plugin.recordvideo.ui.editor.item.p)localObject3).aGt, (int)((com.tencent.mm.plugin.recordvideo.ui.editor.item.p)localObject3).aGu, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.p)localObject3).scale, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.p)localObject3).oYk));
        localObject2 = kotlin.x.aazN;
      }
      if (!(localObject1 instanceof com.tencent.mm.xeffect.effect.x)) {
        localObject1 = null;
      }
      for (;;)
      {
        localObject1 = (com.tencent.mm.xeffect.effect.x)localObject1;
        if (localObject1 != null)
        {
          ((com.tencent.mm.xeffect.effect.x)localObject1).a(new com.tencent.mm.xeffect.effect.h(((com.tencent.mm.plugin.recordvideo.ui.editor.item.p)localObject3).text, null, 30));
          localObject1 = kotlin.x.aazN;
        }
        localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).gwm();
          localObject1 = kotlin.x.aazN;
        }
        localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).NmT;
          if (localObject1 != null)
          {
            localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
            if (localObject2 != null)
            {
              ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject2).aG(((com.tencent.mm.videocomposition.j)localObject1).YId, ((com.tencent.mm.videocomposition.j)localObject1).igG());
              localObject1 = kotlin.x.aazN;
            }
          }
        }
        TimelineEditorBaseVideoPluginLayout.a(this);
        break;
        localObject1 = null;
        break label1037;
        if (paramBundle == null) {
          break;
        }
        if (paramBundle.getByteArray("PARAM_1_BYTEARRAY") != null)
        {
          localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.caption.b)bp(com.tencent.mm.plugin.vlog.ui.plugin.caption.b.class);
          if (localObject1 != null)
          {
            ((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).gvU();
            localObject1 = kotlin.x.aazN;
          }
          dmf();
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR", 0);
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT", 0);
          localObject1 = paramBundle.getString("PARAM_EDIT_TEXT_FONT");
          localObject2 = (com.tencent.mm.plugin.recordvideo.plugin.d)bp(com.tencent.mm.plugin.recordvideo.plugin.d.class);
          if (localObject2 != null)
          {
            localObject3 = paramBundle.getByteArray("PARAM_1_BYTEARRAY");
            if (localObject3 == null) {
              kotlin.g.b.p.iCn();
            }
            kotlin.g.b.p.j(localObject3, "it.getByteArray(IRecordStatus.PARAM_1_BYTEARRAY)!!");
            ((com.tencent.mm.plugin.recordvideo.plugin.d)localObject2).a((byte[])localObject3, i, j, (String)localObject1);
            localObject1 = kotlin.x.aazN;
          }
        }
        localObject1 = kotlin.x.aazN;
        break;
        if (paramBundle == null) {
          break;
        }
        if (paramBundle.getByteArray("PARAM_1_BYTEARRAY") != null)
        {
          dmf();
          cSG();
          localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.caption.b)bp(com.tencent.mm.plugin.vlog.ui.plugin.caption.b.class);
          if (localObject1 != null)
          {
            localObject2 = paramBundle.getByteArray("PARAM_1_BYTEARRAY");
            if (localObject2 == null) {
              kotlin.g.b.p.iCn();
            }
            kotlin.g.b.p.j(localObject2, "it.getByteArray(IRecordStatus.PARAM_1_BYTEARRAY)!!");
            ((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).cu((byte[])localObject2);
            localObject1 = kotlin.x.aazN;
          }
        }
        localObject1 = kotlin.x.aazN;
        break;
        TimelineEditorBaseVideoPluginLayout.a(this);
        localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).gwi();
        localObject1 = kotlin.x.aazN;
        break;
        if (paramBundle == null) {
          break;
        }
        if (paramBundle.getByteArray("PARAM_1_BYTEARRAY") != null)
        {
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR", 0);
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT", 0);
          localObject1 = paramBundle.getString("PARAM_EDIT_TEXT_FONT");
          localObject2 = (com.tencent.mm.plugin.vlog.ui.plugin.caption.b)bp(com.tencent.mm.plugin.vlog.ui.plugin.caption.b.class);
          if (localObject2 != null)
          {
            localObject3 = paramBundle.getByteArray("PARAM_1_BYTEARRAY");
            if (localObject3 == null) {
              kotlin.g.b.p.iCn();
            }
            kotlin.g.b.p.j(localObject3, "it.getByteArray(IRecordStatus.PARAM_1_BYTEARRAY)!!");
            ((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject2).a((byte[])localObject3, i, j, (String)localObject1);
            localObject1 = kotlin.x.aazN;
          }
        }
        if (paramBundle.getLong("PARAM_1_LONG", -1L) >= 0L) {
          m(Long.valueOf(paramBundle.getLong("PARAM_1_LONG")));
        }
        localObject1 = kotlin.x.aazN;
        break;
        if (paramBundle == null) {
          break;
        }
        if (paramBundle.getInt("PARAM_1_INT") == 0) {}
        for (localObject1 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbL;; localObject1 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbM)
        {
          localObject2 = paramBundle.getByteArray("PARAM_1_BYTEARRAY");
          if (localObject2 == null) {
            kotlin.g.b.p.iCn();
          }
          kotlin.g.b.p.j(localObject2, "it.getByteArray(IRecordStatus.PARAM_1_BYTEARRAY)!!");
          localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.c((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localObject1, (byte[])localObject2);
          localObject2 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
          if (localObject2 == null) {
            break;
          }
          com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.a((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject2, (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1, getCurrentTrackTimeRange());
          localObject1 = kotlin.x.aazN;
          break;
        }
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("PARAM_1_INT");
        localObject2 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
        if (localObject2 == null) {
          break;
        }
        if (i == 1) {}
        for (localObject1 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbM;; localObject1 = com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbL)
        {
          ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject2).c((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localObject1);
          localObject1 = kotlin.x.aazN;
          break;
        }
        localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).NAn;
        if (localObject1 == null) {
          break;
        }
        dmf();
        localObject2 = (com.tencent.mm.plugin.vlog.ui.plugin.read.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.read.a.class);
        if (localObject2 == null) {
          break;
        }
        ((com.tencent.mm.plugin.vlog.ui.plugin.read.a)localObject2).a((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1);
        localObject1 = kotlin.x.aazN;
        break;
        if (paramBundle == null) {
          break;
        }
        paramBundle.getLong("PARAM_1_LONG");
        localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).NAn;
          label2004:
          localObject2 = localObject1;
          if (!(localObject1 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.p)) {
            localObject2 = null;
          }
          localObject1 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.p)localObject2;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.vlog.model.local.a.Nol;
            localObject2 = com.tencent.mm.plugin.vlog.model.local.a.gtM();
            if (localObject2 == null) {
              kotlin.g.b.p.iCn();
            }
            localObject2 = ((EffectManager)localObject2).WH(((com.tencent.mm.plugin.recordvideo.ui.editor.item.p)localObject1).IcQ);
            if (localObject2 != null)
            {
              ((af)localObject2).aZ(((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibr.getStart(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibr.getEnd());
              localObject1 = kotlin.x.aazN;
            }
          }
          localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
          if (localObject1 != null)
          {
            ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).NAo.gwp();
            localObject1 = kotlin.x.aazN;
          }
          localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
          if (localObject1 != null)
          {
            ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).gwm();
            localObject1 = kotlin.x.aazN;
          }
          localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
          if (localObject2 != null)
          {
            localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
            if (localObject1 == null) {
              break label2259;
            }
          }
        }
        label2259:
        for (localObject1 = ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).NAo.getAllTTSData();; localObject1 = null)
        {
          localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject2).iJ((List)localObject1);
          if (localObject1 != null)
          {
            localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
            if (localObject2 != null)
            {
              com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject2, (com.tencent.mm.videocomposition.j)localObject1, false, false, 0L, 14);
              localObject1 = kotlin.x.aazN;
            }
          }
          TimelineEditorBaseVideoPluginLayout.a(this);
          localObject1 = kotlin.x.aazN;
          break;
          localObject1 = null;
          break label2004;
        }
        if (paramBundle == null) {
          break;
        }
        final boolean bool = paramBundle.getBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN");
        localObject1 = (LyricsInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_LYRICS_LIST");
        localObject2 = new ArrayList();
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)((LyricsInfo)localObject1).HMu).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject4 = (byte[])((Iterator)localObject1).next();
              localObject3 = new ctg();
              localObject5 = (com.tencent.mm.cd.a)localObject3;
              try
              {
                ((com.tencent.mm.cd.a)localObject5).parseFrom((byte[])localObject4);
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
          localObject1 = kotlin.x.aazN;
        }
        if (bool)
        {
          localObject1 = (com.tencent.mm.plugin.vlog.ui.a)bp(com.tencent.mm.plugin.vlog.ui.a.class);
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.vlog.ui.a)localObject1).AQf;
            localObject2 = (List)localObject2;
            if (localObject1 == null) {
              break label2546;
            }
            l = ((AudioCacheInfo)localObject1).duration;
            localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.m((List)localObject2, l);
            localObject2 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
            if (localObject2 != null)
            {
              ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject2).a(com.tencent.mm.plugin.recordvideo.ui.editor.view.b.Ier);
              localObject2 = kotlin.x.aazN;
            }
            localObject2 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
            if (localObject2 != null)
            {
              com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.a((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject2, (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1, null, null, 0L, 12);
              localObject1 = kotlin.x.aazN;
            }
          }
        }
        for (;;)
        {
          localObject1 = kotlin.x.aazN;
          break;
          localObject1 = null;
          break label2432;
          label2546:
          l = 0L;
          break label2452;
          localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
          if (localObject1 != null)
          {
            ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).a(com.tencent.mm.plugin.recordvideo.ui.editor.view.b.Ier);
            localObject1 = kotlin.x.aazN;
          }
        }
        if (paramBundle != null)
        {
          i = paramBundle.getInt("PARAM_DELETE_VIEW_TYPE_INT");
          if (i != com.tencent.mm.plugin.recordvideo.ui.editor.view.b.Ier.ordinal()) {
            break label2641;
          }
          localObject1 = (com.tencent.mm.plugin.vlog.ui.a)bp(com.tencent.mm.plugin.vlog.ui.a.class);
          if (localObject1 != null)
          {
            ((com.tencent.mm.plugin.vlog.ui.a)localObject1).guw();
            localObject1 = kotlin.x.aazN;
          }
        }
        for (;;)
        {
          TimelineEditorBaseVideoPluginLayout.a(this);
          break;
          label2641:
          if (i == com.tencent.mm.plugin.recordvideo.ui.editor.view.b.Iet.ordinal())
          {
            localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.caption.b)bp(com.tencent.mm.plugin.vlog.ui.plugin.caption.b.class);
            if (localObject1 != null)
            {
              ((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).ako(0);
              localObject1 = kotlin.x.aazN;
            }
          }
          else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.view.b.Ieu.ordinal())
          {
            localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.caption.b)bp(com.tencent.mm.plugin.vlog.ui.plugin.caption.b.class);
            if (localObject1 != null)
            {
              ((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).ako(1);
              localObject1 = kotlin.x.aazN;
            }
          }
          else
          {
            localObject1 = kotlin.x.aazN;
          }
        }
        localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).gwm();
          localObject1 = kotlin.x.aazN;
        }
        TimelineEditorBaseVideoPluginLayout.a(this);
        break;
        localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).NAo.gwp();
          localObject1 = kotlin.x.aazN;
        }
        localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).gwm();
          localObject1 = kotlin.x.aazN;
        }
        localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (localObject2 != null)
        {
          localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
          if (localObject1 == null) {
            break label2921;
          }
        }
        label2921:
        for (localObject1 = ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).NAo.getAllTTSData();; localObject1 = null)
        {
          localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject2).iJ((List)localObject1);
          if (localObject1 != null)
          {
            localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
            if (localObject2 != null)
            {
              com.tencent.mm.plugin.vlog.ui.timelineeditor.f.a((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject2, (com.tencent.mm.videocomposition.j)localObject1, false, false, 0L, 14);
              localObject1 = kotlin.x.aazN;
            }
          }
          TimelineEditorBaseVideoPluginLayout.a(this);
          break;
        }
        dmf();
        localObject1 = (i)bp(i.class);
        if (localObject1 != null)
        {
          i.a((i)localObject1);
          localObject1 = kotlin.x.aazN;
        }
        localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
        if (localObject1 == null) {
          break;
        }
        localObject2 = new Rect(0, 0, ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).NAo.getWidth(), ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).NAo.getHeight());
        localObject3 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.g)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.g.class);
        if (localObject3 != null)
        {
          ((com.tencent.mm.plugin.vlog.ui.timelineeditor.g)localObject3).a((Rect)localObject2, com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.fwJ(), (List)((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).NAo.getEditorDataList());
          localObject2 = kotlin.x.aazN;
        }
        localObject2 = new Rect(0, 0, ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).NAo.getWidth(), ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).NAo.getHeight());
        localObject3 = new Rect();
        localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.e)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.e.class);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject1).vav;
          if (localObject1 != null)
          {
            ((RectF)localObject1).round((Rect)localObject3);
            localObject1 = kotlin.x.aazN;
          }
        }
        localObject1 = kotlin.x.aazN;
        final Rect localRect = new Rect();
        localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.e)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.e.class);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.e)localObject1).NEc;
          if (localObject1 != null)
          {
            ((RectF)localObject1).round(localRect);
            localObject1 = kotlin.x.aazN;
          }
        }
        localObject1 = kotlin.x.aazN;
        localObject1 = (ai)bp(ai.class);
        if (localObject1 != null)
        {
          bool = ((ai)localObject1).Nxd;
          localObject1 = (com.tencent.mm.plugin.vlog.ui.a)bp(com.tencent.mm.plugin.vlog.ui.a.class);
          if (localObject1 == null) {
            break label3283;
          }
        }
        label3283:
        for (localObject1 = ((com.tencent.mm.plugin.vlog.ui.a)localObject1).AQf;; localObject1 = null)
        {
          if (localObject1 == null) {
            break label3289;
          }
          localObject5 = k.HMx;
          k.fwB().a((AudioCacheInfo)localObject1, (kotlin.g.a.m)new b((AudioCacheInfo)localObject1, (Rect)localObject2, (Rect)localObject3, localRect, bool, this));
          localObject1 = kotlin.x.aazN;
          break;
          bool = false;
          break label3206;
        }
        label3289:
        localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).NmT;
        if (localObject1 == null) {
          break;
        }
        Object localObject5 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.g)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.g.class);
        if (localObject5 == null) {
          break;
        }
        ((com.tencent.mm.plugin.vlog.ui.timelineeditor.g)localObject5).a((com.tencent.mm.videocomposition.j)localObject1, (Rect)localObject2, (Rect)localObject3, localRect, bool, (kotlin.g.a.b)new c((Rect)localObject2, (Rect)localObject3, localRect, bool, this));
        localObject1 = kotlin.x.aazN;
        break;
        AppMethodBeat.o(237362);
        return;
      }
    }
  }
  
  protected final void b(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(237354);
    kotlin.g.b.p.k(parama, "navigator");
    kotlin.g.b.p.k(paramRecordConfigProvider, "configProvider");
    setOnClickListener((View.OnClickListener)new a(this));
    super.b(parama, paramRecordConfigProvider);
    Object localObject = (com.tencent.mm.plugin.vlog.ui.timelineeditor.g)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.g.class);
    if (localObject != null)
    {
      kotlin.g.b.p.k(parama, "navigator");
      kotlin.g.b.p.k(paramRecordConfigProvider, "configProvider");
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.g)localObject).ALV = paramRecordConfigProvider;
    }
    parama = (com.tencent.mm.plugin.vlog.ui.timelineeditor.e)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.e.class);
    if (parama != null)
    {
      localObject = new Rect();
      parama.vav.round((Rect)localObject);
      com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a locala = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
      if (locala != null) {
        locala.c(paramRecordConfigProvider);
      }
      paramRecordConfigProvider = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
      if (paramRecordConfigProvider != null) {
        paramRecordConfigProvider.y((Rect)localObject);
      }
      parama = parama.vav;
      paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.background.e.HGz;
      parama.round(com.tencent.mm.plugin.recordvideo.background.e.fuW());
      AppMethodBeat.o(237354);
      return;
    }
    AppMethodBeat.o(237354);
  }
  
  public final void c(com.tencent.mm.videocomposition.j paramj)
  {
    AppMethodBeat.i(237367);
    Object localObject2;
    if (paramj != null)
    {
      localObject1 = (List)paramj.MQY;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.videocomposition.b)((Iterator)localObject1).next();
          Object localObject3 = (ArrayList)this.NFe.get(((com.tencent.mm.videocomposition.b)localObject2).path);
          if (localObject3 != null)
          {
            localObject3 = ((Iterable)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d locald = (com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)((Iterator)localObject3).next();
              long l1 = ((com.tencent.mm.videocomposition.b)localObject2).startTimeMs;
              long l2 = ((com.tencent.mm.videocomposition.b)localObject2).endTimeMs;
              locald.Ido.PF(l1);
              locald.Idp.PF(l2);
            }
          }
        }
      }
    }
    Object localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.caption.b)bp(com.tencent.mm.plugin.vlog.ui.plugin.caption.b.class);
    if (localObject1 != null)
    {
      ((ArrayList)((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).NxE.get(0)).clear();
      if (paramj != null)
      {
        paramj = (List)paramj.MQY;
        if (paramj != null)
        {
          paramj = ((Iterable)paramj).iterator();
          while (paramj.hasNext())
          {
            localObject2 = (com.tencent.mm.videocomposition.b)paramj.next();
            localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a(((com.tencent.mm.videocomposition.b)localObject2).path, ((com.tencent.mm.videocomposition.b)localObject2).MQV, ((com.tencent.mm.videocomposition.b)localObject2).MQW, ((com.tencent.mm.videocomposition.b)localObject2).pvh);
            ((ArrayList)((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).NxE.get(0)).add(localObject2);
            Log.i("MicroMsg.EditorCaptionPlugin", "update script:".concat(String.valueOf(localObject2)));
          }
        }
      }
      if (((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).NxI)
      {
        ((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).akp(0);
        ((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).akn(0);
      }
      AppMethodBeat.o(237367);
      return;
    }
    AppMethodBeat.o(237367);
  }
  
  protected final void gwJ()
  {
    AppMethodBeat.i(237353);
    super.gwJ();
    Object localObject1 = (TimeEditorItemContainer)findViewById(a.f.video_editor_item_container);
    kotlin.g.b.p.j(localObject1, "editorContainerView");
    new com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a((TimeEditorItemContainer)localObject1, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    Object localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject2).a((com.tencent.mm.plugin.vlog.ui.plugin.d.b)localObject1);
    }
    localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
    if (localObject1 != null)
    {
      localObject2 = (b.b)this;
      kotlin.g.b.p.k(localObject2, "callback");
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).NDP.add(localObject2);
    }
    localObject1 = findViewById(a.f.editor_time_edit_panel);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.editor_time_edit_panel)");
    localObject1 = new com.tencent.mm.plugin.vlog.ui.timelineeditor.c((EditorPanelHolder)localObject1, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    localObject2 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.f)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.f.class);
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.vlog.ui.timelineeditor.f)localObject2).a((com.tencent.mm.plugin.vlog.ui.plugin.d.b)localObject1);
    }
    localObject1 = findViewById(a.f.timeline_finish);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.timeline_finish)");
    new com.tencent.mm.plugin.vlog.ui.timelineeditor.g((View)localObject1, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    localObject1 = new com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h((com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h)localObject1).a((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.g)new com.tencent.mm.plugin.vlog.ui.timelineeditor.report.a((BasePluginLayout)this));
    ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h)localObject1).a((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.g)new com.tencent.mm.plugin.vlog.ui.timelineeditor.report.c((BasePluginLayout)this));
    ((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h)localObject1).a((com.tencent.mm.plugin.vlog.ui.timelineeditor.report.g)new com.tencent.mm.plugin.vlog.ui.timelineeditor.report.e((BasePluginLayout)this));
    AppMethodBeat.o(237353);
  }
  
  protected String gwK()
  {
    return "MicroMsg.TimelineEditorPlatformVideoPluginLayout";
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(237357);
    if (super.onBackPress())
    {
      localh = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h.class);
      if (localh != null) {
        localh.gwD();
      }
      AppMethodBeat.o(237357);
      return true;
    }
    com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h localh = (com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h.class);
    if (localh != null) {
      localh.gwD();
    }
    AppMethodBeat.o(237357);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(TimelineEditorPlatformVideoPluginLayout paramTimelineEditorPlatformVideoPluginLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(226114);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorPlatformVideoPluginLayout$initPluginLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (TimelineEditorPlatformVideoPluginLayout.a(this.NFf)) {
        com.tencent.mm.plugin.recordvideo.plugin.parent.d.b.a(this.NFf, d.c.HTk);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorPlatformVideoPluginLayout$initPluginLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(226114);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "filePath", "", "invoke", "com/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorPlatformVideoPluginLayout$statusChange$17$1"})
  static final class b
    extends q
    implements kotlin.g.a.m<Boolean, String, kotlin.x>
  {
    b(AudioCacheInfo paramAudioCacheInfo, Rect paramRect1, Rect paramRect2, Rect paramRect3, boolean paramBoolean, TimelineEditorPlatformVideoPluginLayout paramTimelineEditorPlatformVideoPluginLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorPlatformVideoPluginLayout$statusChange$17$2$1", "com/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorPlatformVideoPluginLayout$$special$$inlined$let$lambda$1"})
  static final class c
    extends q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    c(Rect paramRect1, Rect paramRect2, Rect paramRect3, boolean paramBoolean, TimelineEditorPlatformVideoPluginLayout paramTimelineEditorPlatformVideoPluginLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.scene.TimelineEditorPlatformVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */