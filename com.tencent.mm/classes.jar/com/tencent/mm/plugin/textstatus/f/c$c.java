package com.tencent.mm.plugin.textstatus.f;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$TextStatusMovementMethod;", "Landroid/text/method/LinkMovementMethod;", "extraSpaceCallback", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "onTouchEvent", "", "widget", "Landroid/widget/TextView;", "buffer", "Landroid/text/Spannable;", "event", "Landroid/view/MotionEvent;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$c
  extends LinkMovementMethod
{
  private final a<ah> Tmo;
  
  public c$c(a<ah> parama)
  {
    this.Tmo = parama;
  }
  
  public final boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(289719);
    Integer localInteger;
    if (paramMotionEvent == null)
    {
      localInteger = null;
      if (paramTextView != null)
      {
        if (localInteger != null) {
          break label55;
        }
        label21:
        if (localInteger != null) {
          break label168;
        }
      }
    }
    label55:
    label64:
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    float f6;
    Layout localLayout;
    do
    {
      boolean bool = super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
      AppMethodBeat.o(289719);
      return bool;
      localInteger = Integer.valueOf(paramMotionEvent.getAction());
      break;
      if (localInteger.intValue() != 1) {
        break label21;
      }
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      f3 = paramTextView.getTotalPaddingLeft();
      f4 = paramTextView.getTotalPaddingTop();
      f5 = paramTextView.getScrollX();
      f6 = paramTextView.getScrollY();
      localLayout = paramTextView.getLayout();
      s.s(localLayout, "widget.layout");
    } while (localLayout.getOffsetForHorizontal(localLayout.getLineForVertical((int)(f2 - f4 + f6)), f1 - f3 + f5) < paramTextView.getText().length());
    if (localInteger == null) {}
    for (;;)
    {
      AppMethodBeat.o(289719);
      return false;
      label168:
      if (localInteger.intValue() != 0) {
        break;
      }
      break label64;
      if (localInteger.intValue() == 1)
      {
        paramTextView = this.Tmo;
        if (paramTextView != null) {
          paramTextView.invoke();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.c.c
 * JD-Core Version:    0.7.0.1
 */