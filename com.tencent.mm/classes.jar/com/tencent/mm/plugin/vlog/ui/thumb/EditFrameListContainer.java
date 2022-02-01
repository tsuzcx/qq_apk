package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mLayoutDirection", "getLayoutDirection", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "left", "top", "right", "bottom", "setLayoutDirection", "layoutDirection", "Companion", "plugin-vlog_release"})
public final class EditFrameListContainer
  extends FrameLayout
{
  public static final a GOU;
  private int mLayoutDirection;
  
  static
  {
    AppMethodBeat.i(192052);
    GOU = new a((byte)0);
    AppMethodBeat.o(192052);
  }
  
  public EditFrameListContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192050);
    AppMethodBeat.o(192050);
  }
  
  public EditFrameListContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192051);
    AppMethodBeat.o(192051);
  }
  
  public final int getLayoutDirection()
  {
    return this.mLayoutDirection;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(192049);
    super.onDraw(paramCanvas);
    Log.d("EditFrameListContainer", "onDraw, ".concat(String.valueOf(this)));
    AppMethodBeat.o(192049);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(192048);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d("EditFrameListContainer", "onLayout, " + this + ", LayoutDirection:" + this.mLayoutDirection);
    AppMethodBeat.o(192048);
  }
  
  public final void setLayoutDirection(int paramInt)
  {
    this.mLayoutDirection = paramInt;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListContainer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.EditFrameListContainer
 * JD-Core Version:    0.7.0.1
 */