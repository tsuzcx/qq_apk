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
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.q.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.platformtools.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.wallet_core.ui.i;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public final class b
  extends BaseAdapter
{
  List<a.a> KmK;
  private int KmN;
  private final String TAG;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(68362);
    this.TAG = "SnsLuckyMoneyReceivedRecordListAdapter";
    this.KmK = new ArrayList();
    this.KmN = 1;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(68362);
  }
  
  private a.a akx(int paramInt)
  {
    AppMethodBeat.i(68364);
    a.a locala = (a.a)this.KmK.get(paramInt);
    AppMethodBeat.o(68364);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(68363);
    int i = this.KmK.size();
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
      paramViewGroup.xaN = ((ImageView)localView.findViewById(a.f.lucky_money_record_avatar));
      paramViewGroup.yEQ = ((TextView)localView.findViewById(a.f.lucky_money_record_nickname));
      paramViewGroup.KmP = ((TextView)localView.findViewById(a.f.lucky_money_record_time));
      paramViewGroup.KmQ = ((TextView)localView.findViewById(a.f.lucky_money_record_amount));
      paramViewGroup.KmU = ((TextView)localView.findViewById(a.f.lucky_money_record_game_tips));
      localView.setTag(paramViewGroup);
    }
    for (;;)
    {
      a.a locala = akx(paramInt);
      h.baF();
      au localau = ((n)h.ax(n.class)).bzA().JE(locala.sWX);
      label169:
      long l1;
      Object localObject;
      if (locala.sWX != null)
      {
        a.b.h(paramViewGroup.xaN, locala.sWX);
        TextView localTextView = paramViewGroup.KmP;
        paramView = this.mContext;
        l1 = locala.Klv * 1000L;
        localObject = new GregorianCalendar();
        if (l1 >= 3600000L) {
          break label389;
        }
        paramView = "";
        label213:
        localTextView.setText(paramView);
        paramViewGroup.KmP.setVisibility(0);
        if (localau == null) {
          break label511;
        }
        ah.a(this.mContext, paramViewGroup.yEQ, localau.aSV());
        label248:
        paramView = new czh();
      }
      try
      {
        if ((locala.Klw != null) && (locala.Klw.abwJ > 0))
        {
          paramView.parseFrom(w.a(locala.Klw));
          if (paramView.ihV > 0L)
          {
            paramView = this.mContext.getString(a.i.lucky_money_receive_amount, new Object[] { i.formatMoney2f(paramView.ihV / 100.0D) });
            paramViewGroup.KmQ.setText(paramView);
            paramViewGroup.KmU.setVisibility(8);
          }
          for (;;)
          {
            AppMethodBeat.o(68365);
            return localView;
            paramViewGroup = (a)paramView.getTag();
            localView = paramView;
            break;
            Log.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[] { locala.sWX });
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
            Log.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[] { locala.sWX });
            break label248;
            paramViewGroup.KmQ.setVisibility(8);
            paramViewGroup.KmU.setVisibility(0);
          }
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          Log.e("SnsLuckyMoneyReceivedRecordListAdapter", paramView.getMessage() + "hbBuffer is error");
          paramViewGroup.KmQ.setVisibility(8);
          paramViewGroup.KmU.setVisibility(8);
          paramViewGroup.xaN.setVisibility(8);
          paramViewGroup.yEQ.setVisibility(8);
          paramViewGroup.KmP.setVisibility(8);
          continue;
          paramViewGroup.KmQ.setVisibility(8);
          paramViewGroup.KmU.setVisibility(0);
        }
      }
    }
  }
  
  final class a
  {
    TextView KmP;
    TextView KmQ;
    TextView KmU;
    ImageView xaN;
    TextView yEQ;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.b
 * JD-Core Version:    0.7.0.1
 */