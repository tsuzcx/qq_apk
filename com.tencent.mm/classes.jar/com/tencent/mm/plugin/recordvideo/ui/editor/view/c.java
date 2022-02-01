package com.tencent.mm.plugin.recordvideo.ui.editor.view;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "", "enableNotify", "", "getContentBoundary", "", "getDrawRect", "Landroid/graphics/RectF;", "getEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getSafeArea", "Landroid/graphics/Rect;", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "setDefaultLocation", "", "displayRect", "heightPercent", "", "setSafeArea", "safeRect", "damp", "", "setValidArea", "validRect", "showAtObjectId", "objID", "", "showAtTime", "currentMs", "", "plugin-recordvideo_release"})
public abstract interface c
{
  public abstract boolean PA(long paramLong);
  
  public abstract void a(Rect paramRect, float paramFloat);
  
  public abstract boolean aWf(String paramString);
  
  public abstract void b(Rect paramRect, int paramInt);
  
  public abstract boolean fyf();
  
  public abstract float[] getContentBoundary();
  
  public abstract RectF getDrawRect();
  
  public abstract a getEditorData();
  
  public abstract b getType();
  
  public abstract void setValidArea(Rect paramRect);
  
  @l(iBK={1, 1, 16})
  public static final class a
  {
    public static boolean a(c paramc, long paramLong)
    {
      AppMethodBeat.i(217350);
      a locala = paramc.getEditorData();
      if (((locala instanceof a)) && (locala.PA(paramLong)) && (paramc.fyf()))
      {
        ((View)paramc).setVisibility(0);
        AppMethodBeat.o(217350);
        return true;
      }
      ((View)paramc).setVisibility(4);
      AppMethodBeat.o(217350);
      return false;
    }
    
    public static boolean a(c paramc, String paramString)
    {
      AppMethodBeat.i(217353);
      p.k(paramString, "objID");
      a locala = paramc.getEditorData();
      if (((locala instanceof a)) && (locala.aWf(paramString)))
      {
        ((View)paramc).setVisibility(0);
        AppMethodBeat.o(217353);
        return true;
      }
      ((View)paramc).setVisibility(4);
      AppMethodBeat.o(217353);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.view.c
 * JD-Core Version:    0.7.0.1
 */