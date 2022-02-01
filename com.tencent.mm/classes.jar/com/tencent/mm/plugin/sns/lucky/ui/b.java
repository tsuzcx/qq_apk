package com.tencent.mm.plugin.sns.lucky.ui;

import android.content.Context;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.j.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.cje;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.wallet_core.ui.g;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public final class b
  extends BaseAdapter
{
  List<a.a> Eud;
  private int Eug;
  private final String TAG;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(68362);
    this.TAG = "SnsLuckyMoneyReceivedRecordListAdapter";
    this.Eud = new ArrayList();
    this.Eug = 1;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(68362);
  }
  
  private a.a afI(int paramInt)
  {
    AppMethodBeat.i(68364);
    a.a locala = (a.a)this.Eud.get(paramInt);
    AppMethodBeat.o(68364);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(68363);
    int i = this.Eud.size();
    AppMethodBeat.o(68363);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(68365);
    View localView;
    if (paramView == null)
    {
      localView = this.mInflater.inflate(a.g.sns_lucky_money_record_item, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.tXu = ((ImageView)localView.findViewById(a.f.lucky_money_record_avatar));
      paramViewGroup.vsF = ((TextView)localView.findViewById(a.f.lucky_money_record_nickname));
      paramViewGroup.Eui = ((TextView)localView.findViewById(a.f.lucky_money_record_time));
      paramViewGroup.Euj = ((TextView)localView.findViewById(a.f.lucky_money_record_amount));
      paramViewGroup.Eun = ((TextView)localView.findViewById(a.f.lucky_money_record_game_tips));
      localView.setTag(paramViewGroup);
    }
    for (;;)
    {
      a.a locala = afI(paramInt);
      h.aHH();
      as localas = ((n)h.ae(n.class)).bbL().RG(locala.pRV);
      label169:
      long l1;
      Object localObject;
      if (locala.pRV != null)
      {
        a.b.d(paramViewGroup.tXu, locala.pRV);
        TextView localTextView = paramViewGroup.Eui;
        paramView = this.mContext;
        l1 = locala.EsP * 1000L;
        localObject = new GregorianCalendar();
        if (l1 >= 3600000L) {
          break label389;
        }
        paramView = "";
        label213:
        localTextView.setText(paramView);
        paramViewGroup.Eui.setVisibility(0);
        if (localas == null) {
          break label511;
        }
        ag.a(this.mContext, paramViewGroup.vsF, localas.ays());
        label248:
        paramView = new cje();
      }
      try
      {
        if ((locala.EsQ != null) && (locala.EsQ.Ufv > 0))
        {
          paramView.parseFrom(z.a(locala.EsQ));
          if (paramView.gbJ > 0L)
          {
            paramView = this.mContext.getString(a.i.lucky_money_receive_amount, new Object[] { g.formatMoney2f(paramView.gbJ / 100.0D) });
            paramViewGroup.Euj.setText(paramView);
            paramViewGroup.Eun.setVisibility(8);
          }
          for (;;)
          {
            AppMethodBeat.o(68365);
            return localView;
            paramViewGroup = (a)paramView.getTag();
            localView = paramView;
            break;
            Log.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[] { locala.pRV });
            break label169;
            label389:
            long l2 = l1 - new GregorianCalendar(((GregorianCalendar)localObject).get(1), ((GregorianCalendar)localObject).get(2), ((GregorianCalendar)localObject).get(5)).getTimeInMillis();
            if ((l2 > 0L) && (l2 <= 86400000L))
            {
              paramView = new SimpleDateFormat("HH:mm").format(new Date(l1));
              break label213;
            }
            localObject = new Time();
            ((Time)localObject).set(l1);
            paramView = e.a(paramView.getString(a.i.fmt_datetime, new Object[] { " " }), (Time)localObject).toString();
            break label213;
            label511:
            Log.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[] { locala.pRV });
            break label248;
            paramViewGroup.Euj.setVisibility(8);
            paramViewGroup.Eun.setVisibility(0);
          }
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          Log.e("SnsLuckyMoneyReceivedRecordListAdapter", paramView.getMessage() + "hbBuffer is error");
          paramViewGroup.Euj.setVisibility(8);
          paramViewGroup.Eun.setVisibility(8);
          paramViewGroup.tXu.setVisibility(8);
          paramViewGroup.vsF.setVisibility(8);
          paramViewGroup.Eui.setVisibility(8);
          continue;
          paramViewGroup.Euj.setVisibility(8);
          paramViewGroup.Eun.setVisibility(0);
        }
      }
    }
  }
  
  final class a
  {
    TextView Eui;
    TextView Euj;
    TextView Eun;
    ImageView tXu;
    TextView vsF;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.b
 * JD-Core Version:    0.7.0.1
 */