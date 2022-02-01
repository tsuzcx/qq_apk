package com.tencent.mm.plugin.recordvideo.ui.editor.view;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "", "enableNotify", "", "getContentBoundary", "", "getDrawRect", "Landroid/graphics/RectF;", "getEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getSafeArea", "Landroid/graphics/Rect;", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "setDefaultLocation", "", "displayRect", "heightPercent", "", "setSafeArea", "safeRect", "damp", "", "setValidArea", "validRect", "showAtObjectId", "objID", "", "showAtTime", "currentMs", "", "plugin-recordvideo_release"})
public abstract interface c
{
  public abstract void a(Rect paramRect, float paramFloat);
  
  public abstract boolean avO(String paramString);
  
  public abstract void b(Rect paramRect, int paramInt);
  
  public abstract boolean dHt();
  
  public abstract float[] getContentBoundary();
  
  public abstract RectF getDrawRect();
  
  public abstract a getEditorData();
  
  public abstract b getType();
  
  public abstract void setValidArea(Rect paramRect);
  
  public abstract boolean yJ(long paramLong);
  
  @l(gfx={1, 1, 16})
  public static final class a
  {
    public static boolean a(c paramc, long paramLong)
    {
      AppMethodBeat.i(200866);
      a locala = paramc.getEditorData();
      if (((locala instanceof a)) && (locala.yJ(paramLong)) && (paramc.dHt()))
      {
        ((View)paramc).setVisibility(0);
        AppMethodBeat.o(200866);
        return true;
      }
      ((View)paramc).setVisibility(4);
      AppMethodBeat.o(200866);
      return false;
    }
    
    public static boolean a(c paramc, String paramString)
    {
      AppMethodBeat.i(200867);
      p.h(paramString, "objID");
      a locala = paramc.getEditorData();
      if (((locala instanceof a)) && (locala.avO(paramString)))
      {
        ((View)paramc).setVisibility(0);
        AppMethodBeat.o(200867);
        return true;
      }
      ((View)paramc).setVisibility(4);
      AppMethodBeat.o(200867);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.view.c
 * JD-Core Version:    0.7.0.1
 */