package com.tencent.mm.plugin.sns.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public class SnsCardAdTagListView
  extends LinearLayout
{
  private Activity activity;
  private List<View> rQS;
  private int smQ;
  
  public SnsCardAdTagListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(40465);
    this.rQS = new ArrayList();
    AppMethodBeat.o(40465);
  }
  
  public SnsCardAdTagListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(40466);
    this.rQS = new ArrayList();
    AppMethodBeat.o(40466);
  }
  
  public final void dx(List<String> paramList)
  {
    AppMethodBeat.i(40467);
    int i;
    if (paramList != null)
    {
      i = 0;
      if (i < paramList.size()) {
        if (i != 0) {
          break label140;
        }
      }
    }
    label140:
    for (int j = 0;; j = 1)
    {
      String str = (String)paramList.get(i);
      if (!bo.isNullOrNil(str))
      {
        View localView = this.activity.getLayoutInflater().inflate(2130968629, null);
        TextView localTextView = (TextView)localView.findViewById(2131821035);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (j != 0) {
          localLayoutParams.leftMargin = this.smQ;
        }
        localTextView.setText(str);
        addView(localView, localLayoutParams);
        this.rQS.add(localView);
      }
      i += 1;
      break;
      AppMethodBeat.o(40467);
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40469);
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = 0;
    paramInt1 = 0;
    int i = paramInt1;
    if (paramInt1 < this.rQS.size())
    {
      if (paramInt1 <= 0) {
        break label218;
      }
      paramInt2 += this.smQ;
    }
    label53:
    label218:
    for (;;)
    {
      if (paramInt2 >= getMeasuredWidth()) {
        i = paramInt1 - 1;
      }
      for (;;)
      {
        if ((i >= 0) && (i < this.rQS.size()))
        {
          View localView = (View)this.rQS.get(i);
          TextView localTextView = (TextView)localView.findViewById(2131821035);
          localTextView.setEllipsize(TextUtils.TruncateAt.END);
          getViewTreeObserver().addOnPreDrawListener(new SnsCardAdTagListView.1(this, localTextView, localView));
          paramInt1 = i + 1;
          for (;;)
          {
            if (paramInt1 < this.rQS.size())
            {
              removeView((View)this.rQS.get(paramInt1));
              this.rQS.remove(paramInt1);
              paramInt1 += 1;
              continue;
              paramInt2 = ((View)this.rQS.get(paramInt1)).getMeasuredWidth() + paramInt2;
              i = paramInt1;
              if (paramInt2 >= getMeasuredWidth()) {
                break label53;
              }
              paramInt1 += 1;
              break;
            }
          }
        }
      }
      AppMethodBeat.o(40469);
      return;
    }
  }
  
  public void removeAllViews()
  {
    AppMethodBeat.i(40468);
    super.removeAllViews();
    this.rQS.clear();
    AppMethodBeat.o(40468);
  }
  
  public void setActivityContext(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setTagSpace(int paramInt)
  {
    this.smQ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView
 * JD-Core Version:    0.7.0.1
 */