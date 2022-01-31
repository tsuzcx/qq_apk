package com.tencent.mm.plugin.remittance.bankcard.model;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends BaseAdapter
  implements Filterable
{
  private Context mContext;
  private List<TransferRecordParcel> nvp;
  private List<TransferRecordParcel> nvq = new ArrayList();
  private List<Pair<Integer, Integer>> nvr = new ArrayList();
  private Filter nvs;
  
  public c(Context paramContext, List<TransferRecordParcel> paramList)
  {
    this.mContext = paramContext;
    this.nvp = paramList;
  }
  
  public final int getCount()
  {
    return this.nvq.size();
  }
  
  public final Filter getFilter()
  {
    if (this.nvs == null) {
      this.nvs = new c.a(this, (byte)0);
    }
    return this.nvs;
  }
  
  public final Object getItem(int paramInt)
  {
    return this.nvq.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mContext).inflate(a.g.bank_remit_payee_name_item, paramViewGroup, false);
      paramView = new c.b(this, (byte)0);
      paramView.nvv = ((CdnImageView)localView.findViewById(a.f.brpn_bank_logo_iv));
      paramView.nvw = ((TextView)localView.findViewById(a.f.brpn_payee_name_tv));
      paramView.nvx = ((TextView)localView.findViewById(a.f.brpn_bank_name_tv));
      localView.setTag(paramView);
    }
    paramView = (c.b)localView.getTag();
    paramViewGroup = (TransferRecordParcel)getItem(paramInt);
    Pair localPair = (Pair)this.nvr.get(paramInt);
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.normal_text_color));
    SpannableString localSpannableString = new SpannableString(paramViewGroup.nvA);
    localSpannableString.setSpan(localForegroundColorSpan, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue(), 18);
    paramView.nvv.setUrl(paramViewGroup.nve);
    paramView.nvw.setText(localSpannableString);
    paramView.nvx.setText(this.mContext.getString(a.i.bank_remit_select_payee_name_with_remark, new Object[] { paramViewGroup.lnT, paramViewGroup.nvz }));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.c
 * JD-Core Version:    0.7.0.1
 */