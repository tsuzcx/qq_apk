package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class BankRemitSelectPayeeUI$b
  extends BaseAdapter
{
  private BankRemitSelectPayeeUI$b(BankRemitSelectPayeeUI paramBankRemitSelectPayeeUI) {}
  
  private boolean cgV()
  {
    AppMethodBeat.i(44687);
    if (BankRemitSelectPayeeUI.d(this.qiD) >= 0)
    {
      AppMethodBeat.o(44687);
      return true;
    }
    AppMethodBeat.o(44687);
    return false;
  }
  
  private boolean cgW()
  {
    AppMethodBeat.i(44688);
    if (BankRemitSelectPayeeUI.e(this.qiD) >= 0)
    {
      AppMethodBeat.o(44688);
      return true;
    }
    AppMethodBeat.o(44688);
    return false;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(44682);
    int j = BankRemitSelectPayeeUI.c(this.qiD).size();
    int i = j;
    if (cgV()) {
      i = j + 1;
    }
    j = i;
    if (cgW()) {
      j = i + 1;
    }
    AppMethodBeat.o(44682);
    return j;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(44683);
    if ((paramInt == BankRemitSelectPayeeUI.d(this.qiD)) || (paramInt == BankRemitSelectPayeeUI.e(this.qiD)))
    {
      AppMethodBeat.o(44683);
      return null;
    }
    Object localObject;
    if (paramInt < BankRemitSelectPayeeUI.e(this.qiD))
    {
      localObject = BankRemitSelectPayeeUI.c(this.qiD).get(paramInt - 1);
      AppMethodBeat.o(44683);
      return localObject;
    }
    if ((cgW()) && (paramInt > BankRemitSelectPayeeUI.e(this.qiD)))
    {
      if (cgV())
      {
        localObject = BankRemitSelectPayeeUI.c(this.qiD).get(paramInt - 2);
        AppMethodBeat.o(44683);
        return localObject;
      }
      localObject = BankRemitSelectPayeeUI.c(this.qiD).get(paramInt - 1);
      AppMethodBeat.o(44683);
      return localObject;
    }
    if (cgV())
    {
      localObject = BankRemitSelectPayeeUI.c(this.qiD).get(paramInt - 1);
      AppMethodBeat.o(44683);
      return localObject;
    }
    ab.i("MicroMsg.BankRemitSelectPayeeUI", "maybe wrong pos: [%s,%s,%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(BankRemitSelectPayeeUI.d(this.qiD)), Integer.valueOf(BankRemitSelectPayeeUI.e(this.qiD)) });
    AppMethodBeat.o(44683);
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(44685);
    if ((paramInt == BankRemitSelectPayeeUI.d(this.qiD)) || (paramInt == BankRemitSelectPayeeUI.e(this.qiD)))
    {
      AppMethodBeat.o(44685);
      return 0;
    }
    AppMethodBeat.o(44685);
    return 1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(44686);
    int i = getItemViewType(paramInt);
    View localView = paramView;
    if (paramView == null)
    {
      if (i == 0) {
        localView = LayoutInflater.from(this.qiD.getContext()).inflate(2130968831, paramViewGroup, false);
      }
    }
    else {
      switch (i)
      {
      default: 
        ab.w("MicroMsg.BankRemitSelectPayeeUI", "unknown type: %d", new Object[] { Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(44686);
      return localView;
      localView = LayoutInflater.from(this.qiD.getContext()).inflate(2130968832, paramViewGroup, false);
      paramView = new BankRemitSelectPayeeUI.a(this.qiD, (byte)0);
      paramView.qiI = ((CdnImageView)localView.findViewById(2131821728));
      paramView.qgs = ((TextView)localView.findViewById(2131821729));
      paramView.qiJ = ((TextView)localView.findViewById(2131821730));
      localView.setTag(paramView);
      break;
      paramView = (TextView)localView.findViewById(2131821726);
      if (BankRemitSelectPayeeUI.d(this.qiD) == paramInt) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label223;
        }
        paramView.setText(2131297516);
        break;
      }
      label223:
      if (BankRemitSelectPayeeUI.e(this.qiD) == paramInt) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label257;
        }
        paramView.setText(2131297514);
        break;
      }
      label257:
      paramView.setText("");
      ab.w("MicroMsg.BankRemitSelectPayeeUI", "wrong header pos: %s", new Object[] { Integer.valueOf(paramInt) });
      continue;
      paramView = (BankRemitSelectPayeeUI.a)localView.getTag();
      paramViewGroup = (TransferRecordParcel)getItem(paramInt);
      if (paramViewGroup != null)
      {
        paramView.qiI.eq(paramViewGroup.qfY, 2131690605);
        if (!bo.isNullOrNil(paramViewGroup.qgx))
        {
          SpannableString localSpannableString = j.b(paramView.qiD.getContext(), paramView.qiD.getContext().getString(2131297513, new Object[] { paramViewGroup.qgw, paramViewGroup.qgx }));
          paramView.qgs.setText(localSpannableString);
        }
        for (;;)
        {
          paramView.qiJ.setText(paramView.qiD.getString(2131297513, new Object[] { paramViewGroup.nLq, paramViewGroup.qgv }));
          break;
          paramView.qgs.setText(paramViewGroup.qgw);
        }
      }
      paramView.qiI.setImageResource(2131690605);
      paramView.qgs.setText("");
      paramView.qiJ.setText("");
      ab.w("MicroMsg.BankRemitSelectPayeeUI", "empty record");
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(44684);
    if ((paramInt == BankRemitSelectPayeeUI.d(this.qiD)) || (paramInt == BankRemitSelectPayeeUI.e(this.qiD)))
    {
      AppMethodBeat.o(44684);
      return false;
    }
    AppMethodBeat.o(44684);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.b
 * JD-Core Version:    0.7.0.1
 */