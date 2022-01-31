package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends Preference
{
  View.OnClickListener mOnClickListener;
  private View mView;
  List<MallOrderDetailObject.HelpCenter> poQ;
  String prU;
  View.OnClickListener prV;
  
  public j(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(43924);
    this.mView = null;
    this.mOnClickListener = null;
    this.prV = null;
    this.poQ = new LinkedList();
    setLayoutResource(2130970104);
    AppMethodBeat.o(43924);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(43925);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(43925);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(43926);
    super.onBindView(paramView);
    paramView = (LinearLayout)paramView.findViewById(2131826012);
    paramView.removeAllViews();
    if (this.poQ == null)
    {
      AppMethodBeat.o(43926);
      return;
    }
    int i;
    if ((!bo.isNullOrNil(this.prU)) && (this.prV != null))
    {
      i = this.poQ.size();
      if (i != 0) {
        break label455;
      }
      i = -1;
    }
    label455:
    for (;;)
    {
      int j = 0;
      int k = 0;
      Object localObject;
      for (;;)
      {
        if (j < this.poQ.size())
        {
          localObject = (MallOrderDetailObject.HelpCenter)this.poQ.get(j);
          TextView localTextView = new TextView(this.mContext);
          localTextView.setTextColor(this.mContext.getResources().getColor(2131689763));
          localTextView.setTextSize(0, a.ao(this.mContext, 2131427809));
          localTextView.setIncludeFontPadding(false);
          localTextView.setText(((MallOrderDetailObject.HelpCenter)localObject).name);
          localTextView.setTag(localObject);
          localTextView.setGravity(17);
          localTextView.setOnClickListener(this.mOnClickListener);
          if (k == i) {
            localTextView.setTextColor(this.mContext.getResources().getColor(2131690139));
          }
          paramView.addView(localTextView, new LinearLayout.LayoutParams(0, -2, 1.0F));
          if (k < i)
          {
            localObject = new View(this.mContext);
            ((View)localObject).setBackgroundColor(this.mContext.getResources().getColor(2131690471));
            paramView.addView((View)localObject, new LinearLayout.LayoutParams(a.ao(this.mContext, 2131427577), -1));
          }
          k += 1;
          j += 1;
          continue;
          i = this.poQ.size() - 1;
          break;
        }
      }
      if ((!bo.isNullOrNil(this.prU)) && (this.prV != null))
      {
        localObject = new TextView(this.mContext);
        ((TextView)localObject).setTextColor(this.mContext.getResources().getColor(2131689763));
        ((TextView)localObject).setTextSize(0, a.ao(this.mContext, 2131427809));
        ((TextView)localObject).setIncludeFontPadding(false);
        ((TextView)localObject).setText(this.prU);
        ((TextView)localObject).setGravity(17);
        ((TextView)localObject).setOnClickListener(this.prV);
        if (k == i) {
          ((TextView)localObject).setTextColor(this.mContext.getResources().getColor(2131690139));
        }
        paramView.addView((View)localObject, new LinearLayout.LayoutParams(0, -2, 1.0F));
      }
      AppMethodBeat.o(43926);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.j
 * JD-Core Version:    0.7.0.1
 */