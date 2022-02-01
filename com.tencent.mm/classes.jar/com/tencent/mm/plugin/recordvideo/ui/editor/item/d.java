package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Rect;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditView;", "", "getContentBoundary", "", "getSafeArea", "Landroid/graphics/Rect;", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditItemType;", "setDefaultLocation", "", "displayRect", "heightPercent", "", "setSafeArea", "safeRect", "damp", "", "setValidArea", "validRect", "plugin-recordvideo_release"})
public abstract interface d
{
  public abstract void a(Rect paramRect, float paramFloat);
  
  public abstract float[] getContentBoundary();
  
  public abstract b getType();
  
  public abstract void setValidArea(Rect paramRect);
  
  @l(fvt={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.d
 * JD-Core Version:    0.7.0.1
 */