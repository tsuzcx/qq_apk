package com.tencent.mm.plugin.vlog.ui.plugin.timeedit;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.f;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.g;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.m;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.o;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.p;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.vlog.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditViewParser;", "", "()V", "captionItemView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView;", "recordCaptionItemView", "getTimeEditView", "Landroid/view/View;", "context", "Landroid/content/Context;", "data", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "itemStateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "displayArea", "Landroid/graphics/Rect;", "scale", "Landroid/graphics/PointF;", "refreshView", "", "itemView", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a Unx;
  private com.tencent.mm.plugin.recordvideo.ui.editor.a NZA;
  private com.tencent.mm.plugin.recordvideo.ui.editor.a Uny;
  
  static
  {
    AppMethodBeat.i(283072);
    Unx = new c.a((byte)0);
    AppMethodBeat.o(283072);
  }
  
  public static void a(View paramView, com.tencent.mm.plugin.recordvideo.ui.editor.item.a parama)
  {
    AppMethodBeat.i(283061);
    kotlin.g.b.s.u(paramView, "itemView");
    kotlin.g.b.s.u(parama, "data");
    com.tencent.mm.plugin.recordvideo.ui.editor.item.d locald = parama.NXP;
    if (b.$EnumSwitchMapping$0[locald.ordinal()] == 2)
    {
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)paramView).setText((r)parama);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)paramView).setEnableNotify(true);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)paramView).setVisibility(0);
    }
    AppMethodBeat.o(283061);
  }
  
  public final View a(Context paramContext, com.tencent.mm.plugin.recordvideo.ui.editor.item.a parama, EditorItemContainer.b paramb, Rect paramRect, PointF paramPointF)
  {
    Object localObject = null;
    AppMethodBeat.i(283088);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(parama, "data");
    kotlin.g.b.s.u(paramb, "itemStateResolve");
    kotlin.g.b.s.u(paramRect, "displayArea");
    kotlin.g.b.s.u(paramPointF, "scale");
    int i = paramRect.bottom;
    i = paramRect.top + i;
    com.tencent.mm.plugin.recordvideo.ui.editor.item.d locald = parama.NXP;
    float f;
    switch (b.$EnumSwitchMapping$0[locald.ordinal()])
    {
    default: 
      f = 0.5F;
      paramContext = localObject;
    }
    for (;;)
    {
      if (paramContext != null)
      {
        parama = com.tencent.mm.plugin.recordvideo.background.e.NDU;
        parama = com.tencent.mm.plugin.recordvideo.background.e.gGL();
        paramb = com.tencent.mm.plugin.recordvideo.background.e.NDU;
        paramContext.b(parama, com.tencent.mm.plugin.recordvideo.background.e.gGN());
      }
      if (paramContext != null)
      {
        parama = com.tencent.mm.plugin.recordvideo.background.e.NDU;
        paramContext.setValidArea(com.tencent.mm.plugin.recordvideo.background.e.gGM());
      }
      if (paramContext != null) {
        paramContext.a(paramRect, f);
      }
      Log.i("MicroMsg.TimeEditViewParser", kotlin.g.b.s.X("setDefaultLocation heightPercent:", Float.valueOf(f)));
      paramContext = (View)paramContext;
      AppMethodBeat.o(283088);
      return paramContext;
      paramContext = (com.tencent.mm.plugin.recordvideo.ui.editor.view.d)new f(paramContext);
      ((f)paramContext).setStateResolve(paramb);
      ((f)paramContext).aM(paramPointF.x, paramPointF.y);
      ((f)paramContext).setEmojiItem((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)parama);
      f = 0.5F;
      continue;
      paramContext = (com.tencent.mm.plugin.recordvideo.ui.editor.view.d)new com.tencent.mm.plugin.recordvideo.ui.editor.item.s(paramContext);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)paramContext).aM(paramPointF.x, paramPointF.y);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)paramContext).setStateResolve(paramb);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)paramContext).setText((r)parama);
      f = 0.5F;
      continue;
      if (this.NZA != null)
      {
        paramPointF = this.NZA;
        if (paramPointF != null) {
          break label425;
        }
      }
      int j;
      label425:
      for (paramPointF = null;; paramPointF = paramPointF.getParent())
      {
        if (paramPointF != null) {
          break label435;
        }
        paramPointF = (com.tencent.mm.plugin.recordvideo.ui.editor.view.d)new com.tencent.mm.plugin.recordvideo.ui.editor.a(paramContext);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF).setStateResolve(paramb);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF).setCaptionItem((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)parama);
        this.NZA = ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF);
        j = i / 2;
        parama = com.tencent.mm.plugin.recordvideo.background.e.NDU;
        f = 0.5F - (j - (com.tencent.mm.plugin.recordvideo.background.e.getVisibleRect().bottom - com.tencent.mm.cd.a.br(paramContext, a.d.Edge_6A))) / i;
        paramContext = paramPointF;
        break;
      }
      label435:
      paramContext = this.NZA;
      if (paramContext != null) {
        paramContext.a((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)parama);
      }
      paramContext = this.NZA;
      if (paramContext != null) {
        paramContext.setVisibility(0);
      }
      AppMethodBeat.o(283088);
      return null;
      if (this.Uny != null)
      {
        paramPointF = this.Uny;
        if (paramPointF != null) {
          break label585;
        }
      }
      label585:
      for (paramPointF = null;; paramPointF = paramPointF.getParent())
      {
        if (paramPointF != null) {
          break label595;
        }
        paramPointF = (com.tencent.mm.plugin.recordvideo.ui.editor.view.d)new com.tencent.mm.plugin.recordvideo.ui.editor.a(paramContext);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF).setStateResolve(paramb);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF).setCaptionItem((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)parama);
        this.Uny = ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF);
        j = i / 2;
        parama = com.tencent.mm.plugin.recordvideo.background.e.NDU;
        f = 0.5F - (j - (com.tencent.mm.plugin.recordvideo.background.e.gGM().bottom - com.tencent.mm.cd.a.br(paramContext, a.d.Edge_10A))) / i;
        paramContext = paramPointF;
        break;
      }
      label595:
      paramContext = this.Uny;
      if (paramContext != null) {
        paramContext.a((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)parama);
      }
      paramContext = this.Uny;
      if (paramContext != null) {
        paramContext.setVisibility(0);
      }
      AppMethodBeat.o(283088);
      return null;
      paramContext = (com.tencent.mm.plugin.recordvideo.ui.editor.view.d)new o(paramContext);
      ((o)paramContext).setStateResolve(paramb);
      parama = (p)parama;
      ((o)paramContext).setEditItem(parama);
      f = 0.5F;
      continue;
      paramContext = new g(paramContext);
      paramContext.setStateResolve(paramb);
      paramContext.a((m)parama);
      paramContext = (com.tencent.mm.plugin.recordvideo.ui.editor.view.d)paramContext;
      f = 0.5F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timeedit.c
 * JD-Core Version:    0.7.0.1
 */