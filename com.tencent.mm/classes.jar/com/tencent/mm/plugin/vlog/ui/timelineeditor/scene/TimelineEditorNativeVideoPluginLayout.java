package com.tencent.mm.plugin.vlog.ui.timelineeditor.scene;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
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
import com.tencent.mm.xeffect.effect.p;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorNativeVideoPluginLayout;", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorBaseVideoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "initPlugin", "", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TimelineEditorNativeVideoPluginLayout
  extends TimelineEditorBaseVideoPluginLayout
{
  public TimelineEditorNativeVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(282157);
    AppMethodBeat.o(282157);
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(282180);
    s.u(paramc, "status");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
    }
    Object localObject3;
    label204:
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(282180);
          return;
        } while (paramBundle == null);
        localObject1 = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO");
      } while (localObject1 == null);
      paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
      if (paramBundle != null)
      {
        paramc = getCurrentTrack();
        if (paramc == null) {}
        for (paramc = (a.c)localObject2;; paramc = Long.valueOf(paramc.id))
        {
          s.u(localObject1, "emojiInfo");
          localObject2 = paramBundle.Uqp;
          localObject3 = c.UqK;
          localObject1 = ((EmojiInfo)localObject1).getMd5();
          s.s(localObject1, "emojiInfo.md5");
          localObject1 = ((TimelineEditor)localObject2).bzx(c.a.bfx((String)localObject1));
          if (localObject1 == null) {
            break label204;
          }
          if (paramc == null) {
            break;
          }
          paramBundle.Uqp.a((af)localObject1, paramc.longValue());
          AppMethodBeat.o(282180);
          return;
        }
        paramBundle.Uqp.a((af)localObject1);
      }
      AppMethodBeat.o(282180);
      return;
      hSs();
      TimelineEditorBaseVideoPluginLayout.a((TimelineEditorBaseVideoPluginLayout)this);
    } while (paramBundle == null);
    paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
    int i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
    int j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
    localObject2 = paramBundle.getString("PARAM_EDIT_TEXT_FONT");
    paramBundle = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
    if (paramBundle != null)
    {
      localObject3 = String.valueOf(paramc);
      paramc = getCurrentTrack();
      if (paramc == null) {}
      for (paramc = (a.c)localObject1;; paramc = Long.valueOf(paramc.id))
      {
        s.u(localObject3, "text");
        localObject1 = paramBundle.Uqp;
        b.a locala = com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder.b.UqI;
        localObject1 = ((TimelineEditor)localObject1).bzx(b.a.q((String)localObject3, i, j, (String)localObject2));
        if (localObject1 == null) {
          break label376;
        }
        if (paramc == null) {
          break;
        }
        paramBundle.Uqp.a((af)localObject1, paramc.longValue());
        AppMethodBeat.o(282180);
        return;
      }
      paramBundle.Uqp.a((af)localObject1);
    }
    label376:
    AppMethodBeat.o(282180);
  }
  
  protected final void hUG()
  {
    AppMethodBeat.i(282162);
    super.hUG();
    AppMethodBeat.o(282162);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(282193);
    Object localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && (paramMotionEvent != null))
    {
      localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).Uqp;
      s.t(paramMotionEvent, "touchEvent");
      int n = paramMotionEvent.getPointerCount();
      if (n > 0)
      {
        int j = 0;
        float f1 = -1.0F;
        float f2 = -1.0F;
        int k = paramMotionEvent.getPointerId(0);
        int i = -1;
        int i1 = paramMotionEvent.getActionMasked();
        int m = a.azs(i1);
        float f3 = paramMotionEvent.getX(0);
        float f4 = paramMotionEvent.getY(0);
        if (n >= 2)
        {
          j = a.azs(i1);
          f1 = paramMotionEvent.getX(1);
          f2 = paramMotionEvent.getY(1);
          i = paramMotionEvent.getPointerId(1);
        }
        localObject2 = ((TimelineEditor)localObject1).nTouchMotionEvent(((TimelineEditor)localObject1).nNg, m, f3, f4, k, j, f1, f2, i);
        if (localObject2 == null) {
          break label294;
        }
        localObject3 = w.dl((byte[])localObject2);
        s.r(localObject3, "touchResult");
        if (((w)localObject3).adro <= 0L) {
          break label309;
        }
        localObject1 = (af)((TimelineEditor)localObject1).adps.get(Long.valueOf(((w)localObject3).adro));
        if ((localObject1 == null) || (!(localObject1 instanceof p))) {
          break label309;
        }
      }
    }
    label294:
    label309:
    for (localObject1 = (p)localObject1;; localObject1 = null)
    {
      if (((w)localObject3).jgl())
      {
        localObject2 = new g();
        localObject3 = ((w)localObject3).jgm().toByteArray();
        s.r(localObject3, "touchResult.touchTrack.toByteArray()");
        ((g)localObject2).dj((byte[])localObject3);
      }
      for (;;)
      {
        new r(localObject1, localObject2);
        boolean bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(282193);
        return bool;
        localObject2 = null;
        localObject1 = null;
        continue;
        localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.scene.TimelineEditorNativeVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */