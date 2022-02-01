package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;

public final class FileSelectorFolderView$b
  extends BaseAdapter
{
  private Context mContext;
  
  public FileSelectorFolderView$b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final int getCount()
  {
    return 2;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(31951);
    AppMethodBeat.o(31951);
    return Integer.valueOf(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31952);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(R.i.ehh, null);
      paramViewGroup = new FileSelectorFolderView.c(paramView);
      paramView.setTag(paramViewGroup);
      switch (paramInt)
      {
      default: 
        paramViewGroup.titleTv.setText(R.l.app_empty_string);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(31952);
      return paramView;
      paramViewGroup = (FileSelectorFolderView.c)paramView.getTag();
      break;
      paramViewGroup.titleTv.setText(R.l.eEB);
      continue;
      paramViewGroup.titleTv.setText(R.l.eEC);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView.b
 * JD-Core Version:    0.7.0.1
 */