package com.tencent.mm.plugin.offline.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class WalletOfflineCoinPurseUI$a
  extends BaseAdapter
{
  ArrayList<String> iVH;
  ArrayList<Boolean> pnW;
  
  public WalletOfflineCoinPurseUI$a(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI)
  {
    AppMethodBeat.i(43556);
    this.iVH = new ArrayList();
    this.pnW = new ArrayList();
    AppMethodBeat.o(43556);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(43557);
    int i = this.iVH.size();
    AppMethodBeat.o(43557);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(43558);
    Object localObject = this.iVH.get(paramInt);
    AppMethodBeat.o(43558);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(43560);
    paramView = (CheckedTextView)View.inflate(this.pny, 2130971195, null);
    paramView.setText((String)this.iVH.get(paramInt));
    if (WalletOfflineCoinPurseUI.bZs() == paramInt)
    {
      paramView.setChecked(true);
      if (!isEnabled(paramInt)) {
        break label90;
      }
      paramView.setTextColor(this.pny.getResources().getColor(2131690322));
      paramView.setEnabled(true);
    }
    for (;;)
    {
      AppMethodBeat.o(43560);
      return paramView;
      paramView.setChecked(false);
      break;
      label90:
      paramView.setTextColor(this.pny.getResources().getColor(2131690168));
      paramView.setEnabled(false);
    }
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(43559);
    boolean bool = ((Boolean)this.pnW.get(paramInt)).booleanValue();
    AppMethodBeat.o(43559);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.a
 * JD-Core Version:    0.7.0.1
 */