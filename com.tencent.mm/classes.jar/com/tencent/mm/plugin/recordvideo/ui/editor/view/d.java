package com.tencent.mm.plugin.recordvideo.ui.editor.view;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "", "enableNotify", "", "getContentBoundary", "", "getDrawRect", "Landroid/graphics/RectF;", "getEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getSafeArea", "Landroid/graphics/Rect;", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "setDefaultLocation", "", "displayRect", "heightPercent", "", "setSafeArea", "safeRect", "damp", "", "setValidArea", "validRect", "showAtObjectId", "objID", "", "showAtTime", "currentMs", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface d
{
  public abstract void a(Rect paramRect, float paramFloat);
  
  public abstract boolean aTn(String paramString);
  
  public abstract void b(Rect paramRect, int paramInt);
  
  public abstract boolean gJS();
  
  public abstract float[] getContentBoundary();
  
  public abstract RectF getDrawRect();
  
  public abstract a getEditorData();
  
  public abstract b getType();
  
  public abstract void setValidArea(Rect paramRect);
  
  public abstract boolean tA(long paramLong);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean a(d paramd, long paramLong)
    {
      AppMethodBeat.i(279990);
      s.u(paramd, "this");
      a locala = paramd.getEditorData();
      if ((locala != null) && (locala.tA(paramLong)) && (paramd.gJS()))
      {
        ((View)paramd).setVisibility(0);
        AppMethodBeat.o(279990);
        return true;
      }
      ((View)paramd).setVisibility(4);
      AppMethodBeat.o(279990);
      return false;
    }
    
    public static boolean a(d paramd, String paramString)
    {
      AppMethodBeat.i(279997);
      s.u(paramd, "this");
      s.u(paramString, "objID");
      a locala = paramd.getEditorData();
      if ((locala != null) && (locala.aTn(paramString)))
      {
        ((View)paramd).setVisibility(0);
        AppMethodBeat.o(279997);
        return true;
      }
      ((View)paramd).setVisibility(4);
      AppMethodBeat.o(279997);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.view.d
 * JD-Core Version:    0.7.0.1
 */