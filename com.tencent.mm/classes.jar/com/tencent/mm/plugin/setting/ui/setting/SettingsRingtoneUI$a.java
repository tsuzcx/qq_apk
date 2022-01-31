package com.tencent.mm.plugin.setting.ui.setting;

import android.content.res.Resources;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SettingsRingtoneUI$a
  extends BaseAdapter
{
  int count;
  Cursor csQ;
  int padding;
  
  public SettingsRingtoneUI$a(SettingsRingtoneUI paramSettingsRingtoneUI, Cursor paramCursor)
  {
    AppMethodBeat.i(127426);
    this.count = 0;
    this.padding = 0;
    this.csQ = paramCursor;
    this.count = (paramCursor.getCount() + 1);
    ab.d("RingtonePickerActivity", "count = " + this.count);
    this.padding = paramSettingsRingtoneUI.getResources().getDimensionPixelSize(2131427808);
    AppMethodBeat.o(127426);
  }
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(127428);
    if ((this.csQ.isClosed()) || (!this.csQ.moveToPosition(paramInt - 1)))
    {
      AppMethodBeat.o(127428);
      return "";
    }
    String str = this.csQ.getString(this.csQ.getColumnIndex("title"));
    AppMethodBeat.o(127428);
    return str;
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
    AppMethodBeat.i(127427);
    paramView = (CheckedTextView)this.qJP.qJL.inflate(2130970650, null);
    if (paramInt == 0)
    {
      paramView.setBackgroundResource(2130838445);
      paramView.setText(2131303352);
    }
    for (;;)
    {
      paramView.setPadding(this.padding, 0, this.padding, 0);
      paramView.setCheckMarkDrawable(2130840179);
      AppMethodBeat.o(127427);
      return paramView;
      paramView.setBackgroundResource(2130838445);
      paramView.setText(getItem(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsRingtoneUI.a
 * JD-Core Version:    0.7.0.1
 */