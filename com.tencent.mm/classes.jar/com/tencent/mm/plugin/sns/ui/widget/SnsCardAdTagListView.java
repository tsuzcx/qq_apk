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
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.List;

public class SnsCardAdTagListView
  extends LinearLayout
{
  private Activity activity;
  private List<View> oYz = new ArrayList();
  private int space;
  
  public SnsCardAdTagListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SnsCardAdTagListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void cL(List<String> paramList)
  {
    int i;
    if (paramList != null)
    {
      i = 0;
      if (i < paramList.size()) {
        if (i != 0) {
          break label132;
        }
      }
    }
    label132:
    for (int j = 0;; j = 1)
    {
      String str = (String)paramList.get(i);
      if (!bk.bl(str))
      {
        View localView = this.activity.getLayoutInflater().inflate(i.g.ad_card_tag_item, null);
        TextView localTextView = (TextView)localView.findViewById(i.f.card_ad_tag_text);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (j != 0) {
          localLayoutParams.leftMargin = this.space;
        }
        localTextView.setText(str);
        addView(localView, localLayoutParams);
        this.oYz.add(localView);
      }
      i += 1;
      break;
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = 0;
    paramInt1 = 0;
    int i = paramInt1;
    if (paramInt1 < this.oYz.size())
    {
      if (paramInt1 <= 0) {
        break label209;
      }
      paramInt2 += this.space;
    }
    label48:
    label209:
    for (;;)
    {
      if (paramInt2 >= getMeasuredWidth()) {
        i = paramInt1 - 1;
      }
      for (;;)
      {
        if ((i >= 0) && (i < this.oYz.size()))
        {
          View localView = (View)this.oYz.get(i);
          TextView localTextView = (TextView)localView.findViewById(i.f.card_ad_tag_text);
          localTextView.setEllipsize(TextUtils.TruncateAt.END);
          getViewTreeObserver().addOnPreDrawListener(new SnsCardAdTagListView.1(this, localTextView, localView));
          paramInt1 = i + 1;
          for (;;)
          {
            if (paramInt1 < this.oYz.size())
            {
              removeView((View)this.oYz.get(paramInt1));
              this.oYz.remove(paramInt1);
              paramInt1 += 1;
              continue;
              paramInt2 = ((View)this.oYz.get(paramInt1)).getMeasuredWidth() + paramInt2;
              i = paramInt1;
              if (paramInt2 >= getMeasuredWidth()) {
                break label48;
              }
              paramInt1 += 1;
              break;
            }
          }
        }
      }
      return;
    }
  }
  
  public void removeAllViews()
  {
    super.removeAllViews();
    this.oYz.clear();
  }
  
  public void setActivityContext(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setTagSpace(int paramInt)
  {
    this.space = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView
 * JD-Core Version:    0.7.0.1
 */