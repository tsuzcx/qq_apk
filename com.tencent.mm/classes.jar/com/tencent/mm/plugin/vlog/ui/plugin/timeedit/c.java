package com.tencent.mm.plugin.vlog.ui.plugin.timeedit;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.f;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.n;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.o;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.q;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditViewParser;", "", "()V", "captionItemView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView;", "recordCaptionItemView", "getTimeEditView", "Landroid/view/View;", "context", "Landroid/content/Context;", "data", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "itemStateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "displayArea", "Landroid/graphics/Rect;", "scale", "Landroid/graphics/PointF;", "refreshView", "", "itemView", "Companion", "plugin-vlog_release"})
public final class c
{
  public static final c.a GNd;
  private com.tencent.mm.plugin.recordvideo.ui.editor.a Cgo;
  private com.tencent.mm.plugin.recordvideo.ui.editor.a GNc;
  
  static
  {
    AppMethodBeat.i(191905);
    GNd = new c.a((byte)0);
    AppMethodBeat.o(191905);
  }
  
  public static void a(View paramView, com.tencent.mm.plugin.recordvideo.ui.editor.item.a parama)
  {
    AppMethodBeat.i(191904);
    p.h(paramView, "itemView");
    p.h(parama, "data");
    d locald = parama.Cex;
    switch (d.haE[locald.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(191904);
      return;
      ((r)paramView).setText((q)parama);
      ((r)paramView).setEnableNotify(true);
      ((r)paramView).setVisibility(0);
    }
  }
  
  public final View a(Context paramContext, com.tencent.mm.plugin.recordvideo.ui.editor.item.a parama, EditorItemContainer.b paramb, Rect paramRect, PointF paramPointF)
  {
    Object localObject = null;
    AppMethodBeat.i(191903);
    p.h(paramContext, "context");
    p.h(parama, "data");
    p.h(paramb, "itemStateResolve");
    p.h(paramRect, "displayArea");
    p.h(paramPointF, "scale");
    int i = paramRect.bottom;
    i = paramRect.top + i;
    d locald = parama.Cex;
    switch (d.$EnumSwitchMapping$0[locald.ordinal()])
    {
    default: 
      paramContext = localObject;
    }
    for (;;)
    {
      float f = 0.5F;
      for (;;)
      {
        if (paramContext != null)
        {
          parama = com.tencent.mm.plugin.recordvideo.background.e.BKp;
          parama = com.tencent.mm.plugin.recordvideo.background.e.eIR();
          paramb = com.tencent.mm.plugin.recordvideo.background.e.BKp;
          paramContext.b(parama, com.tencent.mm.plugin.recordvideo.background.e.eIT());
        }
        if (paramContext != null)
        {
          parama = com.tencent.mm.plugin.recordvideo.background.e.BKp;
          paramContext.setValidArea(com.tencent.mm.plugin.recordvideo.background.e.eIS());
        }
        if (paramContext != null) {
          paramContext.a(paramRect, f);
        }
        Log.i("MicroMsg.TimeEditViewParser", "setDefaultLocation heightPercent:".concat(String.valueOf(f)));
        paramContext = (View)paramContext;
        AppMethodBeat.o(191903);
        return paramContext;
        paramContext = (com.tencent.mm.plugin.recordvideo.ui.editor.view.c)new f(paramContext);
        ((f)paramContext).setStateResolve(paramb);
        ((f)paramContext).af(paramPointF.x, paramPointF.y);
        ((f)paramContext).setEmojiItem((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)parama);
        f = 0.5F;
        continue;
        paramContext = (com.tencent.mm.plugin.recordvideo.ui.editor.view.c)new r(paramContext);
        ((r)paramContext).af(paramPointF.x, paramPointF.y);
        ((r)paramContext).setStateResolve(paramb);
        ((r)paramContext).setText((q)parama);
        f = 0.5F;
      }
      if (this.Cgo != null)
      {
        paramPointF = this.Cgo;
        if (paramPointF == null) {
          break label424;
        }
      }
      int j;
      label424:
      for (paramPointF = paramPointF.getParent();; paramPointF = null)
      {
        if (paramPointF != null) {
          break label430;
        }
        paramPointF = (com.tencent.mm.plugin.recordvideo.ui.editor.view.c)new com.tencent.mm.plugin.recordvideo.ui.editor.a(paramContext);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF).setStateResolve(paramb);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF).setCaptionItem((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)parama);
        this.Cgo = ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF);
        j = i / 2;
        parama = com.tencent.mm.plugin.recordvideo.background.e.BKp;
        f = 0.5F - (j - (com.tencent.mm.plugin.recordvideo.background.e.getVisibleRect().bottom - com.tencent.mm.cb.a.aG(paramContext, 2131165308))) / i;
        paramContext = paramPointF;
        break;
      }
      label430:
      paramContext = this.Cgo;
      if (paramContext != null) {
        paramContext.a((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)parama);
      }
      paramContext = this.Cgo;
      if (paramContext != null) {
        paramContext.setVisibility(0);
      }
      AppMethodBeat.o(191903);
      return null;
      if (this.GNc != null)
      {
        paramPointF = this.GNc;
        if (paramPointF == null) {
          break label583;
        }
      }
      label583:
      for (paramPointF = paramPointF.getParent();; paramPointF = null)
      {
        if (paramPointF != null) {
          break label589;
        }
        paramPointF = (com.tencent.mm.plugin.recordvideo.ui.editor.view.c)new com.tencent.mm.plugin.recordvideo.ui.editor.a(paramContext);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF).setStateResolve(paramb);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF).setCaptionItem((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)parama);
        this.GNc = ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF);
        j = i / 2;
        parama = com.tencent.mm.plugin.recordvideo.background.e.BKp;
        f = 0.5F - (j - (com.tencent.mm.plugin.recordvideo.background.e.eIS().bottom - com.tencent.mm.cb.a.aG(paramContext, 2131165278))) / i;
        paramContext = paramPointF;
        break;
      }
      label589:
      paramContext = this.GNc;
      if (paramContext != null) {
        paramContext.a((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)parama);
      }
      paramContext = this.GNc;
      if (paramContext != null) {
        paramContext.setVisibility(0);
      }
      AppMethodBeat.o(191903);
      return null;
      paramContext = (com.tencent.mm.plugin.recordvideo.ui.editor.view.c)new n(paramContext);
      ((n)paramContext).setStateResolve(paramb);
      parama = (o)parama;
      ((n)paramContext).setEditItem(parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timeedit.c
 * JD-Core Version:    0.7.0.1
 */