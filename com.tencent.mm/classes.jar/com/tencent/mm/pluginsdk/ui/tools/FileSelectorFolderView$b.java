package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
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
    return Integer.valueOf(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(R.i.fm_folder_item, null);
      paramViewGroup = new FileSelectorFolderView.c(paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        paramViewGroup.eXr.setText(R.l.app_empty_string);
        return paramView;
        paramViewGroup = (FileSelectorFolderView.c)paramView.getTag();
      }
    }
    paramViewGroup.eXr.setText(R.l.file_explorer_mm_download_title);
    return paramView;
    paramViewGroup.eXr.setText(R.l.file_explorer_mobile_dir_title);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView.b
 * JD-Core Version:    0.7.0.1
 */