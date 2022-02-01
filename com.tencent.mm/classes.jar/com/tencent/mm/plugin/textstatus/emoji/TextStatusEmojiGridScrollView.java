package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.widget.NestedScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiGridScrollView;", "Landroidx/core/widget/NestedScrollView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastY", "getLastY", "()I", "setLastY", "(I)V", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "Companion", "plugin-textstatus_release"})
public final class TextStatusEmojiGridScrollView
  extends NestedScrollView
{
  public static final a MBi;
  private int zDE;
  
  static
  {
    AppMethodBeat.i(232583);
    MBi = new a((byte)0);
    AppMethodBeat.o(232583);
  }
  
  public TextStatusEmojiGridScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(232577);
    AppMethodBeat.o(232577);
  }
  
  public TextStatusEmojiGridScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(232581);
    AppMethodBeat.o(232581);
  }
  
  public final int getLastY()
  {
    return this.zDE;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(232574);
    Integer localInteger;
    Object localObject;
    label31:
    int i;
    if (paramMotionEvent != null)
    {
      localInteger = Integer.valueOf(paramMotionEvent.getActionMasked());
      if (paramMotionEvent == null) {
        break label104;
      }
      localObject = Float.valueOf(paramMotionEvent.getRawY());
      i = (int)((Float)localObject).floatValue();
      Log.v("WxIme.ImeEmojiGridScrollView", "action " + localInteger + ' ' + getX());
      if (localInteger != null) {
        break label113;
      }
      label80:
      if (localInteger != null) {
        break label129;
      }
    }
    label104:
    label113:
    while ((localInteger.intValue() != 2) || (Math.abs(this.zDE - i) <= 20)) {
      for (;;)
      {
        boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
        AppMethodBeat.o(232574);
        return bool;
        localInteger = null;
        break;
        localObject = Double.valueOf(0.0D);
        break label31;
        if (localInteger.intValue() != 0) {
          break label80;
        }
        this.zDE = i;
      }
    }
    label129:
    Log.i("WxIme.ImeEmojiGridScrollView", "ImeEmojiGridScrollView onInterceptTouchEvent");
    AppMethodBeat.o(232574);
    return true;
  }
  
  public final void setLastY(int paramInt)
  {
    this.zDE = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiGridScrollView$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.TextStatusEmojiGridScrollView
 * JD-Core Version:    0.7.0.1
 */