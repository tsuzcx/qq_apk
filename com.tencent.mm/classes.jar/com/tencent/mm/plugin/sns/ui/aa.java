package com.tencent.mm.plugin.sns.ui;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mm.kiss.widget.textview.PLSysTextView;
import com.tencent.mm.kiss.widget.textview.SysTextView;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class aa
  implements View.OnTouchListener
{
  private static o oQB;
  private static TextView oQC;
  
  public static void bHF()
  {
    if (oQB != null)
    {
      oQB.mmZ = false;
      oQC.invalidate();
      oQC = null;
      oQB = null;
    }
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
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
        break label597;
      }
      paramView = ((SysTextView)localTextView).getTvLayout();
    }
    label535:
    label582:
    label590:
    label597:
    for (;;)
    {
      localTextView.invalidate();
      if ((localTextView != null) && (localObject != null) && (e.a(localTextView, (Spanned)localObject))) {
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
            return false;
          }
          if (i >= ((PLSysTextView)localTextView).getVerticalDrawOffset())
          {
            k = paramView.getHeight();
            if (i <= ((PLSysTextView)localTextView).getVerticalDrawOffset() + k) {}
          }
          else
          {
            return false;
          }
        }
        else if ((localTextView instanceof TextView))
        {
          if ((j < localTextView.getTotalPaddingLeft()) || (j > paramView.getWidth() + localTextView.getTotalPaddingLeft())) {
            return false;
          }
          if ((i < localTextView.getTotalPaddingTop()) || (i > paramView.getHeight() + localTextView.getTotalPaddingTop())) {
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
          y.d("MicroMsg.MMOnTouchListener", " action span Len: " + paramView.length);
          if ((localTextView.getLayout() == null) && ((localTextView instanceof SysTextView))) {
            ((SysTextView)localTextView).getTvLayout();
          }
          if (paramView.length == 0) {
            break label582;
          }
          if (i != 1) {
            break label535;
          }
          paramView[j].onClick(localTextView);
          new ah().postDelayed(new aa.1(this), 300L);
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            break label590;
          }
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
          if ((i == 0) || (i == 2) || (i == 3))
          {
            bHF();
            oQB = paramView[j];
            oQC = localTextView;
            paramView[j].mmZ = true;
            localTextView.invalidate();
            i = 1;
            continue;
            bHF();
          }
          else
          {
            i = 0;
          }
        }
      }
      bHF();
      return false;
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aa
 * JD-Core Version:    0.7.0.1
 */