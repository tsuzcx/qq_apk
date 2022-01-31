package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.sdk.platformtools.bo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

final class BankRemitHistoryUI$a
  extends BaseAdapter
{
  private SimpleDateFormat pYf;
  
  private BankRemitHistoryUI$a(BankRemitHistoryUI paramBankRemitHistoryUI)
  {
    AppMethodBeat.i(44614);
    this.pYf = new SimpleDateFormat(this.qhI.getContext().getString(2131297494));
    AppMethodBeat.o(44614);
  }
  
  private String ha(long paramLong)
  {
    AppMethodBeat.i(44618);
    String str = this.pYf.format(new Date(1000L * paramLong));
    AppMethodBeat.o(44618);
    return str;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(44615);
    int i = BankRemitHistoryUI.i(this.qhI).size();
    AppMethodBeat.o(44615);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(44616);
    Object localObject = BankRemitHistoryUI.i(this.qhI).get(paramInt);
    AppMethodBeat.o(44616);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(44617);
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.qhI.getContext()).inflate(2130968823, paramViewGroup, false);
      localView.setTag(new BankRemitHistoryUI.b(this.qhI, localView));
    }
    paramView = (BankRemitHistoryUI.b)localView.getTag();
    paramViewGroup = (avb)getItem(paramInt);
    String str = ha(paramViewGroup.xkr);
    if (paramInt == 0) {
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        paramView.qhL.setText(str);
        paramView.qhL.setVisibility(0);
        label104:
        paramView.qhO.setUrl(paramViewGroup.qfY);
        paramView.hsI.setText(paramViewGroup.title);
        paramView.qhM.setText(paramViewGroup.xks);
        paramView.gpp.setText(paramViewGroup.xkq);
        if (bo.isNullOrNil(paramViewGroup.xkt)) {
          break label251;
        }
        if (!bo.isNullOrNil(paramViewGroup.xku)) {
          paramView.qhN.setTextColor(Color.parseColor(paramViewGroup.xku));
        }
        paramView.qhN.setText(paramViewGroup.xkt);
        paramView.qhN.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(44617);
        return localView;
        if (str.equals(ha(((avb)getItem(paramInt - 1)).xkr))) {
          break label263;
        }
        paramInt = 1;
        break;
        paramView.qhL.setVisibility(8);
        break label104;
        label251:
        paramView.qhN.setVisibility(8);
      }
      label263:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.a
 * JD-Core Version:    0.7.0.1
 */