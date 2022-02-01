package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mLayoutDirection", "getLayoutDirection", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "left", "top", "right", "bottom", "setLayoutDirection", "layoutDirection", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EditFrameListContainer
  extends FrameLayout
{
  public static final a Upj;
  private int mLayoutDirection;
  
  static
  {
    AppMethodBeat.i(281607);
    Upj = new a((byte)0);
    AppMethodBeat.o(281607);
  }
  
  public EditFrameListContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(281598);
    AppMethodBeat.o(281598);
  }
  
  public EditFrameListContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(281602);
    AppMethodBeat.o(281602);
  }
  
  public final int getLayoutDirection()
  {
    return this.mLayoutDirection;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(281628);
    super.onDraw(paramCanvas);
    Log.d("EditFrameListContainer", s.X("onDraw, ", this));
    AppMethodBeat.o(281628);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(281624);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d("EditFrameListContainer", "onLayout, " + this + ", LayoutDirection:" + this.mLayoutDirection);
    AppMethodBeat.o(281624);
  }
  
  public final void setLayoutDirection(int paramInt)
  {
    this.mLayoutDirection = paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListContainer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.EditFrameListContainer
 * JD-Core Version:    0.7.0.1
 */