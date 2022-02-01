package com.tencent.mm.plugin.vlog.ui.timelineeditor.scene;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder.b.a;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder.c;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder.c.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.timelineedit.TimelineEditor;
import com.tencent.mm.timelineedit.a.a;
import com.tencent.mm.timelineedit.a.a.aa;
import com.tencent.mm.timelineedit.a.a.w;
import com.tencent.mm.timelineedit.a.g;
import com.tencent.mm.xeffect.effect.af;
import java.util.HashMap;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorNativeVideoPluginLayout;", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorBaseVideoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "initPlugin", "", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "plugin-vlog_release"})
public final class TimelineEditorNativeVideoPluginLayout
  extends TimelineEditorBaseVideoPluginLayout
{
  public TimelineEditorNativeVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(233979);
    AppMethodBeat.o(233979);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(233975);
    kotlin.g.b.p.k(paramc, "status");
    Object localObject3;
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
      AppMethodBeat.o(233975);
      return;
    case 1: 
      if (paramBundle != null)
      {
        localObject1 = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO");
        if (localObject1 != null)
        {
          paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
          if (paramBundle != null)
          {
            kotlin.g.b.p.j(localObject1, "it");
            localObject3 = getCurrentTrack();
            paramc = (d.c)localObject2;
            if (localObject3 != null) {
              paramc = Long.valueOf(((com.tencent.mm.videocomposition.b)localObject3).id);
            }
            kotlin.g.b.p.k(localObject1, "emojiInfo");
            localObject2 = paramBundle.NDO;
            localObject3 = c.NEA;
            localObject1 = ((EmojiInfo)localObject1).getMd5();
            kotlin.g.b.p.j(localObject1, "emojiInfo.md5");
            localObject1 = ((TimelineEditor)localObject2).byc(c.a.bfR((String)localObject1));
            if (localObject1 != null)
            {
              if (paramc != null)
              {
                paramBundle.NDO.a((af)localObject1, paramc.longValue());
                AppMethodBeat.o(233975);
                return;
              }
              paramBundle.NDO.a((af)localObject1);
              AppMethodBeat.o(233975);
              return;
            }
            AppMethodBeat.o(233975);
            return;
          }
          AppMethodBeat.o(233975);
          return;
        }
      }
      AppMethodBeat.o(233975);
      return;
    }
    guD();
    TimelineEditorBaseVideoPluginLayout.a(this);
    if (paramBundle != null)
    {
      paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
      int i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
      int j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
      localObject2 = paramBundle.getString("PARAM_EDIT_TEXT_FONT");
      paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
      if (paramBundle != null)
      {
        localObject3 = String.valueOf(paramc);
        Object localObject4 = getCurrentTrack();
        paramc = (d.c)localObject1;
        if (localObject4 != null) {
          paramc = Long.valueOf(((com.tencent.mm.videocomposition.b)localObject4).id);
        }
        kotlin.g.b.p.k(localObject3, "text");
        localObject1 = paramBundle.NDO;
        localObject4 = com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder.b.NEy;
        localObject1 = ((TimelineEditor)localObject1).byc(b.a.p((String)localObject3, i, j, (String)localObject2));
        if (localObject1 != null)
        {
          if (paramc != null)
          {
            paramBundle.NDO.a((af)localObject1, paramc.longValue());
            AppMethodBeat.o(233975);
            return;
          }
          paramBundle.NDO.a((af)localObject1);
          AppMethodBeat.o(233975);
          return;
        }
        AppMethodBeat.o(233975);
        return;
      }
      AppMethodBeat.o(233975);
      return;
    }
    AppMethodBeat.o(233975);
  }
  
  protected final void gwJ()
  {
    AppMethodBeat.i(233971);
    super.gwJ();
    AppMethodBeat.o(233971);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(233977);
    Object localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && (paramMotionEvent != null))
    {
      localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).NDO;
      kotlin.g.b.p.k(paramMotionEvent, "touchEvent");
      int n = paramMotionEvent.getPointerCount();
      if (n > 0)
      {
        int j = 0;
        float f1 = -1.0F;
        float f2 = -1.0F;
        int k = paramMotionEvent.getPointerId(0);
        int i = -1;
        int i1 = paramMotionEvent.getActionMasked();
        int m = a.atc(i1);
        float f3 = paramMotionEvent.getX(0);
        float f4 = paramMotionEvent.getY(0);
        if (n >= 2)
        {
          j = a.atc(i1);
          f1 = paramMotionEvent.getX(1);
          f2 = paramMotionEvent.getY(1);
          i = paramMotionEvent.getPointerId(1);
        }
        localObject2 = ((TimelineEditor)localObject1).nTouchMotionEvent(((TimelineEditor)localObject1).NmO, m, f3, f4, k, j, f1, f2, i);
        if (localObject2 == null) {
          break label294;
        }
        localObject3 = w.di((byte[])localObject2);
        kotlin.g.b.p.j(localObject3, "touchResult");
        if (((w)localObject3).hEa() <= 0L) {
          break label309;
        }
        localObject1 = (af)((TimelineEditor)localObject1).VLo.get(Long.valueOf(((w)localObject3).hEa()));
        if ((localObject1 == null) || (!(localObject1 instanceof com.tencent.mm.xeffect.effect.p))) {
          break label309;
        }
      }
    }
    label294:
    label309:
    for (localObject1 = (com.tencent.mm.xeffect.effect.p)localObject1;; localObject1 = null)
    {
      if (((w)localObject3).hEb())
      {
        localObject2 = new g();
        localObject3 = ((w)localObject3).hEc().toByteArray();
        kotlin.g.b.p.j(localObject3, "touchResult.touchTrack.toByteArray()");
        ((g)localObject2).dg((byte[])localObject3);
      }
      for (;;)
      {
        new o(localObject1, localObject2);
        boolean bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(233977);
        return bool;
        localObject2 = null;
        localObject1 = null;
        continue;
        localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.scene.TimelineEditorNativeVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */