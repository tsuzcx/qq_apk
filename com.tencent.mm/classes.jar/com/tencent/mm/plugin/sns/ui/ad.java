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
import com.tencent.mm.pluginsdk.ui.span.f;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.ap;

public final class ad
  implements View.OnTouchListener
{
  private static p xoB;
  private static TextView xoC;
  
  public static void dzp()
  {
    AppMethodBeat.i(97958);
    if (xoB != null)
    {
      xoB.setIsPressed(false);
      xoC.invalidate();
      xoC = null;
      xoB = null;
    }
    AppMethodBeat.o(97958);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(97957);
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
      if ((localTextView != null) && (localObject != null) && (f.a(localTextView, (Spanned)localObject)))
      {
        AppMethodBeat.o(97957);
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
            AppMethodBeat.o(97957);
            return false;
          }
          if (i >= ((PLSysTextView)localTextView).getVerticalDrawOffset())
          {
            k = paramView.getHeight();
            if (i <= ((PLSysTextView)localTextView).getVerticalDrawOffset() + k) {}
          }
          else
          {
            AppMethodBeat.o(97957);
            return false;
          }
        }
        else if ((localTextView instanceof TextView))
        {
          if ((j < localTextView.getTotalPaddingLeft()) || (j > paramView.getWidth() + localTextView.getTotalPaddingLeft()))
          {
            AppMethodBeat.o(97957);
            return false;
          }
          if ((i < localTextView.getTotalPaddingTop()) || (i > paramView.getHeight() + localTextView.getTotalPaddingTop()))
          {
            AppMethodBeat.o(97957);
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
          paramView = (p[])((Spannable)localObject).getSpans(j, j, p.class);
          j = paramView.length - 1;
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.MMOnTouchListener", " action span Len: " + paramView.length);
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
          new ap().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97956);
              ad.dzp();
              AppMethodBeat.o(97956);
            }
          }, 300L);
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            break label625;
          }
          AppMethodBeat.o(97957);
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
            dzp();
            xoB = paramView[j];
            xoC = localTextView;
            paramView[j].setIsPressed(true);
            localTextView.invalidate();
            i = 1;
            continue;
            label617:
            dzp();
          }
          else
          {
            i = 0;
          }
        }
      }
      label625:
      dzp();
      AppMethodBeat.o(97957);
      return false;
      AppMethodBeat.o(97957);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ad
 * JD-Core Version:    0.7.0.1
 */