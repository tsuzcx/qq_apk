package com.tencent.mm.plugin.order.ui;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

public final class MallOrderRecordListUI$a
  extends BaseAdapter
{
  protected MallOrderRecordListUI$a(MallOrderRecordListUI paramMallOrderRecordListUI) {}
  
  private i vL(int paramInt)
  {
    return (i)this.mQU.mQQ.get(paramInt);
  }
  
  public final int getCount()
  {
    return this.mQU.mQQ.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    i locali;
    int i;
    Object localObject1;
    if (paramView == null)
    {
      localView = View.inflate(this.mQU, a.g.mall_order_list_item, null);
      paramViewGroup = new MallOrderRecordListUI.b(this.mQU, (byte)0);
      paramViewGroup.mQW = ((TextView)localView.findViewById(a.f.order_list_item_title_tv));
      paramViewGroup.mQY = ((TextView)localView.findViewById(a.f.order_list_item_time_tv));
      paramViewGroup.mQX = ((TextView)localView.findViewById(a.f.order_list_item_status_tv));
      paramViewGroup.mQZ = ((TextView)localView.findViewById(a.f.order_list_item_product_price_tv));
      paramViewGroup.mRb = localView.findViewById(a.f.order_list_item_month_view);
      paramViewGroup.mRc = ((TextView)localView.findViewById(a.f.order_list_item_month_view_date));
      paramViewGroup.mRd = ((TextView)localView.findViewById(a.f.order_list_item_month_view_amount));
      paramViewGroup.mRa = ((TextView)localView.findViewById(a.f.order_list_item_product_real_pay_tv));
      localView.setTag(paramViewGroup);
      locali = vL(paramInt);
      i = 0;
      if (paramInt != 0) {
        break label600;
      }
      i = 1;
      paramView = vL(0);
      localObject1 = new GregorianCalendar();
      ((GregorianCalendar)localObject1).setTimeInMillis(paramView.mPL * 1000L);
      paramView = MallOrderRecordListUI.dB(((GregorianCalendar)localObject1).get(1), ((GregorianCalendar)localObject1).get(2) + 1);
    }
    for (;;)
    {
      for (;;)
      {
        if (i != 0)
        {
          localObject1 = new SimpleDateFormat(this.mQU.getString(a.i.fmt_year_month, new Object[] { "" })).format(new Date(vL(paramInt).mPL * 1000L));
          paramViewGroup.mRc.setText((CharSequence)localObject1);
          if ((!bk.bl(paramView)) && (!bk.bl((String)this.mQU.mQT.get(paramView)))) {
            paramViewGroup.mRd.setText((CharSequence)this.mQU.mQT.get(paramView));
          }
          paramViewGroup.mRb.setVisibility(0);
          label342:
          paramViewGroup.mQW.setText(locali.mPK);
          paramViewGroup.mQX.setText(locali.mPM);
          i = this.mQU.mController.uMN.getResources().getColor(a.c.mall_order_detail_item_subtitle_color);
          paramInt = i;
          if (bk.bl(locali.mPY)) {}
        }
        try
        {
          paramInt = Color.parseColor(locali.mPY);
          paramViewGroup.mQX.setTextColor(paramInt);
          paramViewGroup.mQY.setText(this.mQU.vK(locali.mPL));
          i = this.mQU.mController.uMN.getResources().getColor(a.c.mall_order_detail_item_title_color);
          paramInt = i;
          if (bk.bl(locali.mPZ)) {}
        }
        catch (Exception paramView)
        {
          try
          {
            paramInt = Color.parseColor(locali.mPZ);
            if (locali.mPJ != locali.mQa)
            {
              paramView = e.d(locali.mPJ / 100.0D, locali.mPO);
              localObject1 = new SpannableString(paramView);
              ((SpannableString)localObject1).setSpan(new StrikethroughSpan(), 0, paramView.length(), 33);
              paramViewGroup.mQZ.setText((CharSequence)localObject1);
              paramViewGroup.mRa.setTextColor(paramInt);
              paramViewGroup.mRa.setText(e.d(locali.mQa / 100.0D, locali.mPO));
              return localView;
              paramViewGroup = (MallOrderRecordListUI.b)paramView.getTag();
              localView = paramView;
              break;
              label600:
              paramView = vL(paramInt);
              Object localObject2 = vL(paramInt - 1);
              if ((paramView.mPL <= 0) || (((i)localObject2).mPL <= 0)) {
                break label829;
              }
              localObject1 = new GregorianCalendar();
              ((GregorianCalendar)localObject1).setTimeInMillis(((i)localObject2).mPL * 1000L);
              localObject2 = new GregorianCalendar();
              ((GregorianCalendar)localObject2).setTimeInMillis(paramView.mPL * 1000L);
              if ((((GregorianCalendar)localObject1).get(1) == ((GregorianCalendar)localObject2).get(1)) && (((GregorianCalendar)localObject1).get(2) == ((GregorianCalendar)localObject2).get(2))) {
                break label829;
              }
              i = 1;
              paramView = MallOrderRecordListUI.dB(((GregorianCalendar)localObject2).get(1), ((GregorianCalendar)localObject2).get(2) + 1);
              continue;
              paramViewGroup.mRb.setVisibility(8);
              break label342;
              paramView = paramView;
              y.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bk.pm(locali.mPY));
              paramInt = i;
            }
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              y.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bk.pm(locali.mPZ));
              paramInt = i;
              continue;
              paramViewGroup.mQZ.setText("");
            }
            label829:
            paramView = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.a
 * JD-Core Version:    0.7.0.1
 */