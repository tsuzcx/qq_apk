package com.tencent.mm.plugin.sns.ui;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.PLSysTextView;
import com.tencent.mm.kiss.widget.textview.SysTextView;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class aa
  implements View.OnTouchListener
{
  private static o rIn;
  private static TextView rIo;
  
  public static void ctL()
  {
    AppMethodBeat.i(38306);
    if (rIn != null)
    {
      rIn.setIsPressed(false);
      rIo.invalidate();
      rIo = null;
      rIn = null;
    }
    AppMethodBeat.o(38306);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38305);
    TextView localTextView = (TextView)paramView;
    localTextView.getTag();
    CharSequence localCharSequence = localTextView.getText();
    Object localObject = localTextView.getLayout();
    paramView = (View)localObject;
    if (localObject == null)
    {
      paramView = (View)localObject;
      if ((localTextView instanceof SysTextView)) {
        paramView = ((SysTextView)localTextView).getTvLayout();
      }
    }
    int i;
    if (((localCharSequence instanceof Spannable)) && (paramView != null))
    {
      localObject = (Spannable)localCharSequence;
      i = paramMotionEvent.getAction();
      paramView = localTextView.getLayout();
      if ((paramView != null) || (!(localTextView instanceof SysTextView))) {
        break label642;
      }
      paramView = ((SysTextView)localTextView).getTvLayout();
    }
    label642:
    for (;;)
    {
      localTextView.invalidate();
      if ((localTextView != null) && (localObject != null) && (e.a(localTextView, (Spanned)localObject)))
      {
        AppMethodBeat.o(38305);
        return false;
      }
      if ((i == 1) || (i == 0) || (i == 2))
      {
        int j = (int)paramMotionEvent.getX();
        i = (int)paramMotionEvent.getY();
        int k;
        if ((localTextView instanceof PLSysTextView))
        {
          if (j >= ((PLSysTextView)localTextView).getHorizontalDrawOffset())
          {
            k = paramView.getWidth();
            if (j <= ((PLSysTextView)localTextView).getHorizontalDrawOffset() + k) {}
          }
          else
          {
            AppMethodBeat.o(38305);
            return false;
          }
          if (i >= ((PLSysTextView)localTextView).getVerticalDrawOffset())
          {
            k = paramView.getHeight();
            if (i <= ((PLSysTextView)localTextView).getVerticalDrawOffset() + k) {}
          }
          else
          {
            AppMethodBeat.o(38305);
            return false;
          }
        }
        else if ((localTextView instanceof TextView))
        {
          if ((j < localTextView.getTotalPaddingLeft()) || (j > paramView.getWidth() + localTextView.getTotalPaddingLeft()))
          {
            AppMethodBeat.o(38305);
            return false;
          }
          if ((i < localTextView.getTotalPaddingTop()) || (i > paramView.getHeight() + localTextView.getTotalPaddingTop()))
          {
            AppMethodBeat.o(38305);
            return false;
          }
        }
        if ((localTextView instanceof PLSysTextView))
        {
          j -= ((PLSysTextView)localTextView).getHorizontalDrawOffset();
          i -= ((PLSysTextView)localTextView).getVerticalDrawOffset();
          k = localTextView.getScrollX();
          j = paramView.getOffsetForHorizontal(paramView.getLineForVertical(i + localTextView.getScrollY()), j + k);
          i = paramMotionEvent.getAction();
          paramView = (o[])((Spannable)localObject).getSpans(j, j, o.class);
          j = paramView.length - 1;
          ab.d("MicroMsg.MMOnTouchListener", " action span Len: " + paramView.length);
          if ((localTextView.getLayout() == null) && ((localTextView instanceof SysTextView))) {
            ((SysTextView)localTextView).getTvLayout();
          }
          if (paramView.length == 0) {
            break label617;
          }
          if (i != 1) {
            break label570;
          }
          paramView[j].onClick(localTextView);
          new ak().postDelayed(new aa.1(this), 300L);
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            break label625;
          }
          AppMethodBeat.o(38305);
          return true;
          if ((localTextView instanceof TextView))
          {
            j -= localTextView.getTotalPaddingLeft();
            i -= localTextView.getTotalPaddingTop();
            break;
          }
          j -= localTextView.getPaddingLeft();
          i -= localTextView.getPaddingTop();
          break;
          label570:
          if ((i == 0) || (i == 2) || (i == 3))
          {
            ctL();
            rIn = paramView[j];
            rIo = localTextView;
            paramView[j].setIsPressed(true);
            localTextView.invalidate();
            i = 1;
            continue;
            label617:
            ctL();
          }
          else
          {
            i = 0;
          }
        }
      }
      label625:
      ctL();
      AppMethodBeat.o(38305);
      return false;
      AppMethodBeat.o(38305);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aa
 * JD-Core Version:    0.7.0.1
 */