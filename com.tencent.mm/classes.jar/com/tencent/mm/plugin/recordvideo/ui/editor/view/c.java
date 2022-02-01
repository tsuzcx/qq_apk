package com.tencent.mm.plugin.recordvideo.ui.editor.view;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "", "enableNotify", "", "getContentBoundary", "", "getDrawRect", "Landroid/graphics/RectF;", "getEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getSafeArea", "Landroid/graphics/Rect;", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "setDefaultLocation", "", "displayRect", "heightPercent", "", "setSafeArea", "safeRect", "damp", "", "setValidArea", "validRect", "showAtObjectId", "objID", "", "showAtTime", "currentMs", "", "plugin-recordvideo_release"})
public abstract interface c
{
  public abstract boolean Ig(long paramLong);
  
  public abstract void a(Rect paramRect, float paramFloat);
  
  public abstract boolean aLB(String paramString);
  
  public abstract void b(Rect paramRect, int paramInt);
  
  public abstract boolean eLK();
  
  public abstract float[] getContentBoundary();
  
  public abstract RectF getDrawRect();
  
  public abstract a getEditorData();
  
  public abstract b getType();
  
  public abstract void setValidArea(Rect paramRect);
  
  @l(hxD={1, 1, 16})
  public static final class a
  {
    public static boolean a(c paramc, long paramLong)
    {
      AppMethodBeat.i(237965);
      a locala = paramc.getEditorData();
      if (((locala instanceof a)) && (locala.Ig(paramLong)) && (paramc.eLK()))
      {
        ((View)paramc).setVisibility(0);
        AppMethodBeat.o(237965);
        return true;
      }
      ((View)paramc).setVisibility(4);
      AppMethodBeat.o(237965);
      return false;
    }
    
    public static boolean a(c paramc, String paramString)
    {
      AppMethodBeat.i(237966);
      p.h(paramString, "objID");
      a locala = paramc.getEditorData();
      if (((locala instanceof a)) && (locala.aLB(paramString)))
      {
        ((View)paramc).setVisibility(0);
        AppMethodBeat.o(237966);
        return true;
      }
      ((View)paramc).setVisibility(4);
      AppMethodBeat.o(237966);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.view.c
 * JD-Core Version:    0.7.0.1
 */