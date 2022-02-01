package com.tencent.mm.plugin.music.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/ui/view/MusicMaxSizeFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxHeight", "maxWidth", "initAttribute", "", "onMeasure", "widthSpec", "heightSpec", "setMaxHeight", "setMaxWidth", "Companion", "plugin-music_release"})
public final class MusicMaxSizeFrameLayout
  extends FrameLayout
{
  public static final a Aoq;
  private int maxHeight;
  private int maxWidth;
  
  static
  {
    AppMethodBeat.i(220057);
    Aoq = new a((byte)0);
    AppMethodBeat.o(220057);
  }
  
  public MusicMaxSizeFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(220055);
    b(paramAttributeSet, 0);
    AppMethodBeat.o(220055);
  }
  
  public MusicMaxSizeFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220056);
    b(paramAttributeSet, paramInt);
    AppMethodBeat.o(220056);
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(220054);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.a.MaxSizeFrameLayout, paramInt, 0);
      this.maxHeight = ((int)paramAttributeSet.getDimension(0, 0.0F));
      this.maxWidth = ((int)paramAttributeSet.getDimension(0, 0.0F));
      paramAttributeSet.recycle();
      Log.i("Music.MusicMaxSizeFrameLayout", "[initAttribute],maxHeight:" + this.maxHeight + ", maxWidth:" + this.maxWidth);
    }
    AppMethodBeat.o(220054);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220053);
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = 0;
    if ((this.maxHeight >= 0) || (this.maxWidth >= 0)) {
      paramInt1 = 1;
    }
    if (paramInt1 != 0)
    {
      paramInt1 = getMeasuredHeight();
      paramInt2 = getMeasuredWidth();
      if (getMeasuredHeight() > this.maxHeight) {
        paramInt1 = this.maxHeight;
      }
      if (getMeasuredWidth() > this.maxWidth) {
        paramInt2 = this.maxWidth;
      }
      setMeasuredDimension(paramInt2, paramInt1);
    }
    AppMethodBeat.o(220053);
  }
  
  public final void setMaxHeight(int paramInt)
  {
    this.maxHeight = paramInt;
  }
  
  public final void setMaxWidth(int paramInt)
  {
    this.maxWidth = paramInt;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/ui/view/MusicMaxSizeFrameLayout$Companion;", "", "()V", "TAG", "", "plugin-music_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.MusicMaxSizeFrameLayout
 * JD-Core Version:    0.7.0.1
 */