package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class SelectScanModeGrid$a
  extends BaseAdapter
{
  private Context context;
  private List<SelectScanModeGrid.b> itemList;
  int nNu = -1;
  
  public SelectScanModeGrid$a(Context paramContext, List<SelectScanModeGrid.b> paramList)
  {
    this.context = paramContext;
    this.itemList = paramList;
    y.d("MicroMsg.scanner.SelectScanModeGroupAdapter", "<init> list size = " + this.itemList.size());
  }
  
  public final int getCount()
  {
    return this.itemList.size();
  }
  
  public final Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.itemList.size()))
    {
      y.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getItem fail, invalid position = " + paramInt);
      return null;
    }
    return this.itemList.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SelectScanModeGrid.a.a locala;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, R.i.select_scan_mode_grid_item, null);
      locala = new SelectScanModeGrid.a.a();
      locala.nNv = ((TextView)paramView.findViewById(R.h.select_scan_mode_img));
      locala.mTE = ((TextView)paramView.findViewById(R.h.select_scan_mode_tv));
      locala.nNw = ((ImageView)paramView.findViewById(R.h.select_scan_mode_red_dot));
      paramView.setTag(locala);
    }
    for (;;)
    {
      if (paramInt == paramViewGroup.getChildCount())
      {
        paramViewGroup = (SelectScanModeGrid.b)getItem(paramInt);
        if (paramViewGroup != null) {
          break;
        }
        y.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getView fail, item is null");
      }
      return paramView;
      locala = (SelectScanModeGrid.a.a)paramView.getTag();
    }
    locala.mTE.setText(paramViewGroup.title);
    if (paramInt == this.nNu) {
      locala.nNv.setBackgroundResource(paramViewGroup.nNy);
    }
    for (;;)
    {
      paramViewGroup.nNA = locala.nNv;
      if (!paramViewGroup.nNB) {
        break;
      }
      locala.nNw.setVisibility(0);
      return paramView;
      locala.nNv.setBackgroundResource(paramViewGroup.nNx);
    }
    locala.nNw.setVisibility(4);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a
 * JD-Core Version:    0.7.0.1
 */