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
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditViewParser;", "", "()V", "captionItemView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView;", "recordCaptionItemView", "getTimeEditView", "Landroid/view/View;", "context", "Landroid/content/Context;", "data", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "itemStateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "displayArea", "Landroid/graphics/Rect;", "scale", "Landroid/graphics/PointF;", "refreshView", "", "itemView", "Companion", "plugin-vlog_release"})
public final class c
{
  public static final c.a BSB;
  private com.tencent.mm.plugin.recordvideo.ui.editor.a BSA;
  private com.tencent.mm.plugin.recordvideo.ui.editor.a xPv;
  
  static
  {
    AppMethodBeat.i(196708);
    BSB = new c.a((byte)0);
    AppMethodBeat.o(196708);
  }
  
  public static void a(View paramView, com.tencent.mm.plugin.recordvideo.ui.editor.item.a parama)
  {
    AppMethodBeat.i(196707);
    p.h(paramView, "itemView");
    p.h(parama, "data");
    d locald = parama.xNC;
    switch (d.gnp[locald.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196707);
      return;
      ((r)paramView).setText((q)parama);
      ((r)paramView).setEnableNotify(true);
      ((r)paramView).setVisibility(0);
    }
  }
  
  public final View a(Context paramContext, com.tencent.mm.plugin.recordvideo.ui.editor.item.a parama, EditorItemContainer.b paramb, Rect paramRect, PointF paramPointF)
  {
    Object localObject1 = null;
    AppMethodBeat.i(196706);
    p.h(paramContext, "context");
    p.h(parama, "data");
    p.h(paramb, "itemStateResolve");
    p.h(paramRect, "displayArea");
    p.h(paramPointF, "scale");
    int i = paramRect.bottom + paramRect.top;
    Object localObject2 = com.tencent.mm.plugin.recordvideo.background.e.xuo;
    float f = com.tencent.mm.plugin.recordvideo.background.e.dEO().top;
    localObject2 = com.tencent.mm.plugin.recordvideo.background.e.xuo;
    f = (f * 0.3F + com.tencent.mm.plugin.recordvideo.background.e.dEO().bottom * 0.7F) / i;
    localObject2 = parama.xNC;
    switch (d.cpQ[localObject2.ordinal()])
    {
    default: 
      paramContext = localObject1;
    }
    for (;;)
    {
      if (paramContext != null)
      {
        parama = com.tencent.mm.plugin.recordvideo.background.e.xuo;
        parama = com.tencent.mm.plugin.recordvideo.background.e.dEN();
        paramb = com.tencent.mm.plugin.recordvideo.background.e.xuo;
        paramContext.b(parama, com.tencent.mm.plugin.recordvideo.background.e.dEP());
      }
      if (paramContext != null)
      {
        parama = com.tencent.mm.plugin.recordvideo.background.e.xuo;
        paramContext.setValidArea(com.tencent.mm.plugin.recordvideo.background.e.dEO());
      }
      if (paramContext != null) {
        paramContext.a(paramRect, f);
      }
      ad.i("MicroMsg.TimeEditViewParser", "setDefaultLocation heightPercent:".concat(String.valueOf(f)));
      paramContext = (View)paramContext;
      AppMethodBeat.o(196706);
      return paramContext;
      paramContext = (com.tencent.mm.plugin.recordvideo.ui.editor.view.c)new f(paramContext);
      ((f)paramContext).setStateResolve(paramb);
      ((f)paramContext).aa(paramPointF.x, paramPointF.y);
      ((f)paramContext).setEmojiItem((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)parama);
      continue;
      paramContext = (com.tencent.mm.plugin.recordvideo.ui.editor.view.c)new r(paramContext);
      ((r)paramContext).aa(paramPointF.x, paramPointF.y);
      ((r)paramContext).setStateResolve(paramb);
      ((r)paramContext).setText((q)parama);
      continue;
      if (this.xPv != null)
      {
        paramPointF = this.xPv;
        if (paramPointF == null) {
          break label448;
        }
      }
      int j;
      label448:
      for (paramPointF = paramPointF.getParent();; paramPointF = null)
      {
        if (paramPointF != null) {
          break label454;
        }
        paramPointF = (com.tencent.mm.plugin.recordvideo.ui.editor.view.c)new com.tencent.mm.plugin.recordvideo.ui.editor.a(paramContext);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF).setStateResolve(paramb);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF).setCaptionItem((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)parama);
        this.xPv = ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF);
        j = i / 2;
        parama = com.tencent.mm.plugin.recordvideo.background.e.xuo;
        f = 0.5F - (j - (com.tencent.mm.plugin.recordvideo.background.e.dEO().bottom - com.tencent.mm.cc.a.ax(paramContext, 2131165298))) / i;
        paramContext = paramPointF;
        break;
      }
      label454:
      paramContext = this.xPv;
      if (paramContext != null) {
        paramContext.a((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)parama);
      }
      paramContext = this.xPv;
      if (paramContext != null) {
        paramContext.setVisibility(0);
      }
      AppMethodBeat.o(196706);
      return null;
      if (this.BSA != null)
      {
        paramPointF = this.BSA;
        if (paramPointF == null) {
          break label607;
        }
      }
      label607:
      for (paramPointF = paramPointF.getParent();; paramPointF = null)
      {
        if (paramPointF != null) {
          break label613;
        }
        paramPointF = (com.tencent.mm.plugin.recordvideo.ui.editor.view.c)new com.tencent.mm.plugin.recordvideo.ui.editor.a(paramContext);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF).setStateResolve(paramb);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF).setCaptionItem((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)parama);
        this.BSA = ((com.tencent.mm.plugin.recordvideo.ui.editor.a)paramPointF);
        j = i / 2;
        parama = com.tencent.mm.plugin.recordvideo.background.e.xuo;
        f = 0.5F - (j - (com.tencent.mm.plugin.recordvideo.background.e.dEO().bottom - com.tencent.mm.cc.a.ax(paramContext, 2131165275))) / i;
        paramContext = paramPointF;
        break;
      }
      label613:
      paramContext = this.BSA;
      if (paramContext != null) {
        paramContext.a((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)parama);
      }
      paramContext = this.BSA;
      if (paramContext != null) {
        paramContext.setVisibility(0);
      }
      AppMethodBeat.o(196706);
      return null;
      paramContext = (com.tencent.mm.plugin.recordvideo.ui.editor.view.c)new n(paramContext);
      ((n)paramContext).setStateResolve(paramb);
      parama = (o)parama;
      ((n)paramContext).setEditItem(parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timeedit.c
 * JD-Core Version:    0.7.0.1
 */