package com.tencent.mm.plugin.sns.lucky.ui;

import android.content.Context;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.q.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.aoz;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public final class b
  extends BaseAdapter
{
  private LayoutInflater Lu;
  private final String TAG = "SnsLuckyMoneyReceivedRecordListAdapter";
  List<a.a> lLG = new ArrayList();
  private int lLJ = 1;
  private Context mContext;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
    this.Lu = LayoutInflater.from(paramContext);
  }
  
  private a.a xD(int paramInt)
  {
    return (a.a)this.lLG.get(paramInt);
  }
  
  public final int getCount()
  {
    return this.lLG.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.Lu.inflate(a.g.sns_lucky_money_record_item, paramViewGroup, false);
      paramViewGroup = new b.a(this);
      paramViewGroup.iIS = ((ImageView)localView.findViewById(a.f.lucky_money_record_avatar));
      paramViewGroup.lbC = ((TextView)localView.findViewById(a.f.lucky_money_record_nickname));
      paramViewGroup.lLL = ((TextView)localView.findViewById(a.f.lucky_money_record_time));
      paramViewGroup.lLM = ((TextView)localView.findViewById(a.f.lucky_money_record_amount));
      paramViewGroup.lLQ = ((TextView)localView.findViewById(a.f.lucky_money_record_game_tips));
      localView.setTag(paramViewGroup);
    }
    for (;;)
    {
      a.a locala = xD(paramInt);
      com.tencent.mm.kernel.g.DQ();
      ad localad = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(locala.hcm);
      label164:
      long l1;
      Object localObject;
      if (locala.hcm != null)
      {
        a.b.n(paramViewGroup.iIS, locala.hcm);
        TextView localTextView = paramViewGroup.lLL;
        paramView = this.mContext;
        l1 = locala.lKK * 1000L;
        localObject = new GregorianCalendar();
        if (l1 >= 3600000L) {
          break label378;
        }
        paramView = "";
        label208:
        localTextView.setText(paramView);
        paramViewGroup.lLL.setVisibility(0);
        if (localad == null) {
          break label500;
        }
        o.a(this.mContext, paramViewGroup.lbC, localad.Bq());
        label243:
        paramView = new aoz();
      }
      try
      {
        if ((locala.lKL != null) && (locala.lKL.tFK > 0))
        {
          paramView.aH(aa.a(locala.lKL));
          if (paramView.ceq > 0L)
          {
            paramView = this.mContext.getString(a.i.lucky_money_receive_amount, new Object[] { e.A(paramView.ceq / 100.0D) });
            paramViewGroup.lLM.setText(paramView);
            paramViewGroup.lLQ.setVisibility(8);
            return localView;
            paramViewGroup = (b.a)paramView.getTag();
            localView = paramView;
            continue;
            y.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[] { locala.hcm });
            break label164;
            label378:
            long l2 = l1 - new GregorianCalendar(((GregorianCalendar)localObject).get(1), ((GregorianCalendar)localObject).get(2), ((GregorianCalendar)localObject).get(5)).getTimeInMillis();
            if ((l2 > 0L) && (l2 <= 86400000L))
            {
              paramView = new SimpleDateFormat("HH:mm").format(new Date(l1));
              break label208;
            }
            localObject = new Time();
            ((Time)localObject).set(l1);
            paramView = com.tencent.mm.pluginsdk.f.g.a(paramView.getString(a.i.fmt_datetime, new Object[] { " " }), (Time)localObject).toString();
            break label208;
            label500:
            y.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[] { locala.hcm });
            break label243;
          }
          paramViewGroup.lLM.setVisibility(8);
          paramViewGroup.lLQ.setVisibility(0);
          return localView;
        }
      }
      catch (Exception paramView)
      {
        y.e("SnsLuckyMoneyReceivedRecordListAdapter", paramView.getMessage() + "hbBuffer is error");
        paramViewGroup.lLM.setVisibility(8);
        paramViewGroup.lLQ.setVisibility(8);
        paramViewGroup.iIS.setVisibility(8);
        paramViewGroup.lbC.setVisibility(8);
        paramViewGroup.lLL.setVisibility(8);
        return localView;
      }
    }
    paramViewGroup.lLM.setVisibility(8);
    paramViewGroup.lLQ.setVisibility(0);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.b
 * JD-Core Version:    0.7.0.1
 */