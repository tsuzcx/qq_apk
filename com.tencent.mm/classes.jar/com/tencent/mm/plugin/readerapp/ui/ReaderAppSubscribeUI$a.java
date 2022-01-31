package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.plugin.readerapp.a.d;
import com.tencent.mm.plugin.readerapp.a.e;
import com.tencent.mm.plugin.readerapp.a.g;

final class ReaderAppSubscribeUI$a
  extends BaseAdapter
{
  private final Context context;
  final int[] noJ = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192 };
  int noK;
  private String[] noL = null;
  int noM = 0;
  
  public ReaderAppSubscribeUI$a(Context paramContext, int paramInt)
  {
    this.context = paramContext;
    this.noK = paramInt;
    this.noL = paramContext.getString(a.g.readerapp_subscribe_category).split(";");
    this.noM = wt(paramInt);
  }
  
  private int wt(int paramInt)
  {
    int j = 0;
    int i = 0;
    if (j < this.noJ.length)
    {
      if ((this.noJ[j] & paramInt) == 0) {
        break label37;
      }
      i += 1;
    }
    label37:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  public final int getCount()
  {
    return this.noL.length;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new ReaderAppSubscribeUI.a.a();
      paramView = View.inflate(this.context, a.e.readerapp_subscribe_item, null);
      paramViewGroup.eXO = ((TextView)paramView.findViewById(a.d.readerapp_subscribe_item_title_tv));
      paramViewGroup.eXQ = ((CheckBox)paramView.findViewById(a.d.readerapp_subscribe_item_select_cb));
      paramView.setTag(paramViewGroup);
      paramViewGroup.eXO.setText(this.noL[paramInt]);
      paramViewGroup = paramViewGroup.eXQ;
      if ((this.noK & this.noJ[paramInt]) == 0) {
        break label111;
      }
    }
    label111:
    for (boolean bool = true;; bool = false)
    {
      paramViewGroup.setChecked(bool);
      return paramView;
      paramViewGroup = (ReaderAppSubscribeUI.a.a)paramView.getTag();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI.a
 * JD-Core Version:    0.7.0.1
 */