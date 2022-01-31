package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(28161);
    AppMethodBeat.o(28161);
    return Integer.valueOf(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(28162);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2130969605, null);
      paramViewGroup = new FileSelectorFolderView.c(paramView);
      paramView.setTag(paramViewGroup);
      switch (paramInt)
      {
      default: 
        paramViewGroup.titleTv.setText(2131296919);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(28162);
      return paramView;
      paramViewGroup = (FileSelectorFolderView.c)paramView.getTag();
      break;
      paramViewGroup.titleTv.setText(2131299878);
      continue;
      paramViewGroup.titleTv.setText(2131299879);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView.b
 * JD-Core Version:    0.7.0.1
 */