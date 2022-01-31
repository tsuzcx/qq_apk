package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.model.app.f;
import java.util.List;

final class MoreShareAppUI$a
  extends ArrayAdapter<f>
{
  private List<f> iVa;
  private Context mContext;
  
  public MoreShareAppUI$a(Context paramContext, List<f> paramList)
  {
    super(paramContext, R.i.more_share_app_list_item, paramList);
    this.mContext = paramContext;
    this.iVa = paramList;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, R.i.more_share_app_list_item, null);
      paramViewGroup = new MoreShareAppUI.a.a(paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      f localf = (f)getItem(paramInt);
      paramViewGroup.eXO.setText(localf.field_appName);
      paramView.setVisibility(0);
      return paramView;
      paramViewGroup = (MoreShareAppUI.a.a)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MoreShareAppUI.a
 * JD-Core Version:    0.7.0.1
 */