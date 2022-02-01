package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mLayoutDirection", "getLayoutDirection", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "left", "top", "right", "bottom", "setLayoutDirection", "layoutDirection", "Companion", "plugin-vlog_release"})
public final class EditFrameListContainer
  extends FrameLayout
{
  public static final a NCC;
  private int mLayoutDirection;
  
  static
  {
    AppMethodBeat.i(227053);
    NCC = new a((byte)0);
    AppMethodBeat.o(227053);
  }
  
  public EditFrameListContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(227050);
    AppMethodBeat.o(227050);
  }
  
  public EditFrameListContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(227052);
    AppMethodBeat.o(227052);
  }
  
  public final int getLayoutDirection()
  {
    return this.mLayoutDirection;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(227049);
    super.onDraw(paramCanvas);
    Log.d("EditFrameListContainer", "onDraw, ".concat(String.valueOf(this)));
    AppMethodBeat.o(227049);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(227047);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d("EditFrameListContainer", "onLayout, " + this + ", LayoutDirection:" + this.mLayoutDirection);
    AppMethodBeat.o(227047);
  }
  
  public final void setLayoutDirection(int paramInt)
  {
    this.mLayoutDirection = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListContainer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.EditFrameListContainer
 * JD-Core Version:    0.7.0.1
 */