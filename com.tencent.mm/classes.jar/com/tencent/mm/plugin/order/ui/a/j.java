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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends Preference
{
  View.OnClickListener mOnClickListener;
  private View mView;
  List<MallOrderDetailObject.HelpCenter> unQ;
  String uqU;
  View.OnClickListener uqV;
  
  public j(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66831);
    this.mView = null;
    this.mOnClickListener = null;
    this.uqV = null;
    this.unQ = new LinkedList();
    setLayoutResource(2131494718);
    AppMethodBeat.o(66831);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66832);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(66832);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(66833);
    super.onBindView(paramView);
    paramView = (LinearLayout)paramView.findViewById(2131302068);
    paramView.removeAllViews();
    if (this.unQ == null)
    {
      AppMethodBeat.o(66833);
      return;
    }
    int i;
    if ((!bt.isNullOrNil(this.uqU)) && (this.uqV != null))
    {
      i = this.unQ.size();
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
        if (j < this.unQ.size())
        {
          localObject = (MallOrderDetailObject.HelpCenter)this.unQ.get(j);
          TextView localTextView = new TextView(this.mContext);
          localTextView.setTextColor(this.mContext.getResources().getColor(2131100711));
          localTextView.setTextSize(0, a.ao(this.mContext, 2131165517));
          localTextView.setIncludeFontPadding(false);
          localTextView.setText(((MallOrderDetailObject.HelpCenter)localObject).name);
          localTextView.setTag(localObject);
          localTextView.setGravity(17);
          localTextView.setOnClickListener(this.mOnClickListener);
          if (k == i) {
            localTextView.setTextColor(this.mContext.getResources().getColor(2131100464));
          }
          paramView.addView(localTextView, new LinearLayout.LayoutParams(0, -2, 1.0F));
          if (k < i)
          {
            localObject = new View(this.mContext);
            ((View)localObject).setBackgroundColor(this.mContext.getResources().getColor(2131100886));
            paramView.addView((View)localObject, new LinearLayout.LayoutParams(a.ao(this.mContext, 2131165270), -1));
          }
          k += 1;
          j += 1;
          continue;
          i = this.unQ.size() - 1;
          break;
        }
      }
      if ((!bt.isNullOrNil(this.uqU)) && (this.uqV != null))
      {
        localObject = new TextView(this.mContext);
        ((TextView)localObject).setTextColor(this.mContext.getResources().getColor(2131100711));
        ((TextView)localObject).setTextSize(0, a.ao(this.mContext, 2131165517));
        ((TextView)localObject).setIncludeFontPadding(false);
        ((TextView)localObject).setText(this.uqU);
        ((TextView)localObject).setGravity(17);
        ((TextView)localObject).setOnClickListener(this.uqV);
        if (k == i) {
          ((TextView)localObject).setTextColor(this.mContext.getResources().getColor(2131100464));
        }
        paramView.addView((View)localObject, new LinearLayout.LayoutParams(0, -2, 1.0F));
      }
      AppMethodBeat.o(66833);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.j
 * JD-Core Version:    0.7.0.1
 */