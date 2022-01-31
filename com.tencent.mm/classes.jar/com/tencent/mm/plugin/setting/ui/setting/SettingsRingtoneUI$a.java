package com.tencent.mm.plugin.setting.ui.setting;

import android.content.res.Resources;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.setting.a.d;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.y;

final class SettingsRingtoneUI$a
  extends BaseAdapter
{
  Cursor bLw;
  int count = 0;
  int padding = 0;
  
  public SettingsRingtoneUI$a(SettingsRingtoneUI paramSettingsRingtoneUI, Cursor paramCursor)
  {
    this.bLw = paramCursor;
    this.count = (paramCursor.getCount() + 1);
    y.d("RingtonePickerActivity", "count = " + this.count);
    this.padding = paramSettingsRingtoneUI.getResources().getDimensionPixelSize(a.d.NormalPadding);
  }
  
  private String ke(int paramInt)
  {
    if ((this.bLw.isClosed()) || (!this.bLw.moveToPosition(paramInt - 1))) {
      return "";
    }
    return this.bLw.getString(this.bLw.getColumnIndex("title"));
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (CheckedTextView)this.nVG.nVC.inflate(a.g.select_dialog_singlechoice, null);
    if (paramInt == 0)
    {
      paramView.setBackgroundResource(a.e.comm_list_item_selector);
      paramView.setText(a.i.settings_notification_ringtone_sys);
    }
    for (;;)
    {
      paramView.setPadding(this.padding, 0, this.padding, 0);
      paramView.setCheckMarkDrawable(a.e.round_selector);
      return paramView;
      paramView.setBackgroundResource(a.e.comm_list_item_selector);
      paramView.setText(ke(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsRingtoneUI.a
 * JD-Core Version:    0.7.0.1
 */