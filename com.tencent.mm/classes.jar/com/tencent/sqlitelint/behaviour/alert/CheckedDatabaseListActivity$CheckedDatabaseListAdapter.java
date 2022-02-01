package com.tencent.sqlitelint.behaviour.alert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

class CheckedDatabaseListActivity$CheckedDatabaseListAdapter
  extends BaseAdapter
{
  private List<String> mDefectiveDbList;
  private final LayoutInflater mInflater;
  
  CheckedDatabaseListActivity$CheckedDatabaseListAdapter(Context paramContext)
  {
    AppMethodBeat.i(52891);
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(52891);
  }
  
  public int getCount()
  {
    AppMethodBeat.i(52893);
    if (this.mDefectiveDbList == null)
    {
      AppMethodBeat.o(52893);
      return 0;
    }
    int i = this.mDefectiveDbList.size();
    AppMethodBeat.o(52893);
    return i;
  }
  
  public String getItem(int paramInt)
  {
    AppMethodBeat.i(52894);
    String str = (String)this.mDefectiveDbList.get(paramInt);
    AppMethodBeat.o(52894);
    return str;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(52895);
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2131496813, paramViewGroup, false);
      paramViewGroup = new CheckedDatabaseListActivity.ViewHolder();
      paramViewGroup.dbPathTv = ((TextView)paramView.findViewById(2131299423));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      String str = getItem(paramInt);
      paramViewGroup.dbPathTv.setText(str);
      AppMethodBeat.o(52895);
      return paramView;
      paramViewGroup = (CheckedDatabaseListActivity.ViewHolder)paramView.getTag();
    }
  }
  
  public void setData(List<String> paramList)
  {
    AppMethodBeat.i(52892);
    this.mDefectiveDbList = paramList;
    notifyDataSetChanged();
    AppMethodBeat.o(52892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.alert.CheckedDatabaseListActivity.CheckedDatabaseListAdapter
 * JD-Core Version:    0.7.0.1
 */