package com.tencent.mm.plugin.sns.ui;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kiss.widget.textview.PLSysTextView;
import com.tencent.mm.kiss.widget.textview.SysTextView;
import com.tencent.mm.pluginsdk.ui.span.f;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.aq;

public final class ae
  implements View.OnTouchListener
{
  private static p AjP;
  private static TextView AjQ;
  
  public static void edF()
  {
    AppMethodBeat.i(97958);
    if (AjP != null)
    {
      AjP.setIsPressed(false);
      AjQ.invalidate();
      AjQ = null;
      AjP = null;
    }
    AppMethodBeat.o(97958);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(97957);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    ((b)localObject).bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/sns/ui/MMOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((b)localObject).ahF());
    TextView localTextView = (TextView)paramView;
    localTextView.getTag();
    CharSequence localCharSequence = localTextView.getText();
    localObject = localTextView.getLayout();
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
        break label705;
      }
      paramView = ((SysTextView)localTextView).getTvLayout();
    }
    label413:
    label676:
    label705:
    for (;;)
    {
      localTextView.invalidate();
      boolean bool;
      if ((localTextView != null) && (localObject != null) && (f.a(localTextView, (Spanned)localObject))) {
        bool = false;
      }
      for (;;)
      {
        a.a(bool, this, "com/tencent/mm/plugin/sns/ui/MMOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(97957);
        return bool;
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
              bool = false;
              continue;
            }
            if (i >= ((PLSysTextView)localTextView).getVerticalDrawOffset())
            {
              k = paramView.getHeight();
              if (i <= ((PLSysTextView)localTextView).getVerticalDrawOffset() + k) {}
            }
            else
            {
              bool = false;
            }
          }
          else if ((localTextView instanceof TextView))
          {
            if ((j < localTextView.getTotalPaddingLeft()) || (j > paramView.getWidth() + localTextView.getTotalPaddingLeft()))
            {
              bool = false;
              continue;
            }
            if ((i < localTextView.getTotalPaddingTop()) || (i > paramView.getHeight() + localTextView.getTotalPaddingTop()))
            {
              bool = false;
              continue;
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
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMOnTouchListener", " action span Len: " + paramView.length);
            if ((localTextView.getLayout() == null) && ((localTextView instanceof SysTextView))) {
              ((SysTextView)localTextView).getTvLayout();
            }
            if (paramView.length == 0) {
              break label668;
            }
            if (i != 1) {
              break label621;
            }
            paramView[j].onClick(localTextView);
            new aq().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97956);
                ae.edF();
                AppMethodBeat.o(97956);
              }
            }, 300L);
            i = 1;
          }
          for (;;)
          {
            if (i == 0) {
              break label676;
            }
            bool = true;
            break;
            if ((localTextView instanceof TextView))
            {
              j -= localTextView.getTotalPaddingLeft();
              i -= localTextView.getTotalPaddingTop();
              break label413;
            }
            j -= localTextView.getPaddingLeft();
            i -= localTextView.getPaddingTop();
            break label413;
            label621:
            if ((i == 0) || (i == 2) || (i == 3))
            {
              edF();
              AjP = paramView[j];
              AjQ = localTextView;
              paramView[j].setIsPressed(true);
              localTextView.invalidate();
              i = 1;
              continue;
              edF();
            }
            else
            {
              i = 0;
            }
          }
        }
        else
        {
          edF();
          bool = false;
        }
      }
      a.a(false, this, "com/tencent/mm/plugin/sns/ui/MMOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(97957);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ae
 * JD-Core Version:    0.7.0.1
 */