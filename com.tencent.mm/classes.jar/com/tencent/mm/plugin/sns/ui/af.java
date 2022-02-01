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
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class af
  implements View.OnTouchListener
{
  private static q Esx;
  private static TextView Esy;
  
  public static void ffX()
  {
    AppMethodBeat.i(97958);
    if (Esx != null)
    {
      Esx.setIsPressed(false);
      Esy.invalidate();
      Esy = null;
      Esx = null;
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
      if ((localTextView != null) && (localObject != null) && (g.a(localTextView, (Spanned)localObject)))
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
          paramView = (q[])((Spannable)localObject).getSpans(j, j, q.class);
          j = paramView.length - 1;
          Log.d("MicroMsg.MMOnTouchListener", " action span Len: " + paramView.length);
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
          new MMHandler().postDelayed(new af.1(this), 300L);
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
            ffX();
            Esx = paramView[j];
            Esy = localTextView;
            paramView[j].setIsPressed(true);
            localTextView.invalidate();
            i = 1;
            continue;
            label617:
            ffX();
          }
          else
          {
            i = 0;
          }
        }
      }
      label625:
      ffX();
      AppMethodBeat.o(97957);
      return false;
      AppMethodBeat.o(97957);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.af
 * JD-Core Version:    0.7.0.1
 */