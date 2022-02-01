package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.widget.NestedScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiGridScrollView;", "Landroidx/core/widget/NestedScrollView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastY", "getLastY", "()I", "setLastY", "(I)V", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusEmojiGridScrollView
  extends NestedScrollView
{
  public static final a TkO;
  private int EHM;
  
  static
  {
    AppMethodBeat.i(290820);
    TkO = new a((byte)0);
    AppMethodBeat.o(290820);
  }
  
  public TextStatusEmojiGridScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(290807);
    AppMethodBeat.o(290807);
  }
  
  public TextStatusEmojiGridScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(290812);
    AppMethodBeat.o(290812);
  }
  
  public final int getLastY()
  {
    return this.EHM;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(290836);
    Object localObject1;
    Object localObject2;
    label22:
    int i;
    if (paramMotionEvent == null)
    {
      localObject1 = null;
      if (paramMotionEvent != null) {
        break label101;
      }
      localObject2 = Double.valueOf(0.0D);
      i = (int)((Float)localObject2).floatValue();
      Log.v("WxIme.ImeEmojiGridScrollView", "action " + localObject1 + ' ' + getX());
      if (localObject1 != null) {
        break label113;
      }
      label71:
      if (localObject1 != null) {
        break label129;
      }
    }
    label101:
    label113:
    while ((((Integer)localObject1).intValue() != 2) || (Math.abs(this.EHM - i) <= 20)) {
      for (;;)
      {
        boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
        AppMethodBeat.o(290836);
        return bool;
        localObject1 = Integer.valueOf(paramMotionEvent.getActionMasked());
        break;
        localObject2 = Float.valueOf(paramMotionEvent.getRawY());
        break label22;
        if (((Integer)localObject1).intValue() != 0) {
          break label71;
        }
        this.EHM = i;
      }
    }
    label129:
    Log.i("WxIme.ImeEmojiGridScrollView", "ImeEmojiGridScrollView onInterceptTouchEvent");
    AppMethodBeat.o(290836);
    return true;
  }
  
  public final void setLastY(int paramInt)
  {
    this.EHM = paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiGridScrollView$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.TextStatusEmojiGridScrollView
 * JD-Core Version:    0.7.0.1
 */