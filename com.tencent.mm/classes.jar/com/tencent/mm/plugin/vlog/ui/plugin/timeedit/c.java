package com.tencent.mm.plugin.vlog.ui.plugin.timeedit;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.f;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.g;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.m;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.o;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.s;
import com.tencent.mm.plugin.vlog.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditViewParser;", "", "()V", "captionItemView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView;", "recordCaptionItemView", "getTimeEditView", "Landroid/view/View;", "context", "Landroid/content/Context;", "data", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "itemStateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "displayArea", "Landroid/graphics/Rect;", "scale", "Landroid/graphics/PointF;", "refreshView", "", "itemView", "Companion", "plugin-vlog_release"})
public final class c
{
  public static final a NAK;
  private com.tencent.mm.plugin.recordvideo.ui.editor.a Ide;
  private com.tencent.mm.plugin.recordvideo.ui.editor.a NAJ;
  
  static
  {
    AppMethodBeat.i(226722);
    NAK = new a((byte)0);
    AppMethodBeat.o(226722);
  }
  
  public static void a(View paramView, com.tencent.mm.plugin.recordvideo.ui.editor.item.a parama)
  {
    AppMethodBeat.i(226720);
    kotlin.g.b.p.k(paramView, "itemView");
    kotlin.g.b.p.k(parama, "data");
    d locald = parama.Ibt;
    switch (d.jLJ[locald.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(226720);
      return;
      ((s)paramView).setText((r)parama);
      ((s)paramView).setEnableNotify(true);
      ((s)paramView).setVisibility(0);
    }
  }
  
  public final View a(Context paramContext, com.tencent.mm.plugin.recordvideo.ui.editor.item.a parama, EditorItemContainer.b paramb, Rect paramRect, PointF paramPointF)
  {
    Object localObject = null;
    AppMethodBeat.i(226717);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(parama, "data");
    kotlin.g.b.p.k(paramb, "itemStateResolve");
    kotlin.g.b.p.k(paramRect, "displayArea");
    kotlin.g.b.p.k(paramPointF, "scale");
    int i = paramRect.bottom;
    i = paramRect.top + i;
    d locald = parama.Ibt;
    float f;
    switch (d.$EnumSwitchMapping$0[locald.ordinal()])
    {
    default: 
      f = 0.5F;
      paramContext = localObject;
    }
    for (;;)
    {
      if (paramContext != null)
      {
        parama = com.tencent.mm.plugin.recordvideo.background.e.HGz;
        parama = com.tencent.mm.plugin.recordvideo.background.e.fuV();
        paramb = com.tencent.mm.plugin.recordvideo.background.e.HGz;
        paramContext.b(parama, com.tencent.mm.plugin.recordvideo.background.e.fuX());
      }
      if (paramContext != null)
      {
        parama = com.tencent.mm.plugin.recordvideo.background.e.HGz;
        paramContext.setValidArea(com.tencent.mm.plugin.recordvideo.background.e.fuW());
      }
      if (paramContext != null) {
        paramContext.a(paramRect, f);
      }
      Log.i("MicroMsg.TimeEditViewParser", "setDefaultLocation heightPercent:".concat(String.valueOf(f)));
      paramContext = (View)paramContext;
      AppMethodBeat.o(226717);
      return paramContext;
      paramContext = (com.tencent.mm.plugin.recordvideo.ui.editor.view.c)new f(paramContext);
      ((f)paramContext).setStateResolve(paramb);
      ((f)paramContext).ah(paramPointF.x, paramPointF.y);
      ((f)paramContext).setEmojiItem((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)parama);
      f = 0.5F;
      continue;
      paramContext = (com.tencent.mm.plugin.recordvideo.ui.editor.view.c)new s(paramContext);
      ((s)paramContext).ah(paramPointF.x, paramPointF.y);
      ((s)paramContext).setStateResolve(paramb);
      ((s)paramContext).setText((r)parama);
      f = 0.5F;
      continue;
      if (this.Ide != null)
      {
        paramPointF = this.Ide;
        if (paramPointF == null) {
          break label429;
        }
      }
      int j;
      label429:
      for (paramPointF = paramPointF.getParent();; paramPointF = null)
      {
        if (paramPointF != null) {
          break label435;
        }
        paramPointF = (com.tencent.mm.plugin.recordvideo.ui.editor.view.c)new com.tencent.mm.plugin.recordvideo.ui.editor.a(paramContext);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF).setStateResolve(paramb);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF).setCaptionItem((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)parama);
        this.Ide = ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF);
        j = i / 2;
        parama = com.tencent.mm.plugin.recordvideo.background.e.HGz;
        f = 0.5F - (j - (com.tencent.mm.plugin.recordvideo.background.e.getVisibleRect().bottom - com.tencent.mm.ci.a.aY(paramContext, a.d.Edge_6A))) / i;
        paramContext = paramPointF;
        break;
      }
      label435:
      paramContext = this.Ide;
      if (paramContext != null) {
        paramContext.a((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)parama);
      }
      paramContext = this.Ide;
      if (paramContext != null) {
        paramContext.setVisibility(0);
      }
      AppMethodBeat.o(226717);
      return null;
      if (this.NAJ != null)
      {
        paramPointF = this.NAJ;
        if (paramPointF == null) {
          break label589;
        }
      }
      label589:
      for (paramPointF = paramPointF.getParent();; paramPointF = null)
      {
        if (paramPointF != null) {
          break label595;
        }
        paramPointF = (com.tencent.mm.plugin.recordvideo.ui.editor.view.c)new com.tencent.mm.plugin.recordvideo.ui.editor.a(paramContext);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF).setStateResolve(paramb);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF).setCaptionItem((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)parama);
        this.NAJ = ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF);
        j = i / 2;
        parama = com.tencent.mm.plugin.recordvideo.background.e.HGz;
        f = 0.5F - (j - (com.tencent.mm.plugin.recordvideo.background.e.fuW().bottom - com.tencent.mm.ci.a.aY(paramContext, a.d.Edge_10A))) / i;
        paramContext = paramPointF;
        break;
      }
      label595:
      paramContext = this.NAJ;
      if (paramContext != null) {
        paramContext.a((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)parama);
      }
      paramContext = this.NAJ;
      if (paramContext != null) {
        paramContext.setVisibility(0);
      }
      AppMethodBeat.o(226717);
      return null;
      paramContext = (com.tencent.mm.plugin.recordvideo.ui.editor.view.c)new o(paramContext);
      ((o)paramContext).setStateResolve(paramb);
      parama = (com.tencent.mm.plugin.recordvideo.ui.editor.item.p)parama;
      ((o)paramContext).setEditItem(parama);
      f = 0.5F;
      continue;
      paramContext = new g(paramContext);
      paramContext.setStateResolve(paramb);
      paramContext.a((m)parama);
      paramContext = (com.tencent.mm.plugin.recordvideo.ui.editor.view.c)paramContext;
      f = 0.5F;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditViewParser$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timeedit.c
 * JD-Core Version:    0.7.0.1
 */