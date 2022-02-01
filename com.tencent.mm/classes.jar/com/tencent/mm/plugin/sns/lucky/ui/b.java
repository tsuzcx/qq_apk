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
import com.tencent.mm.plugin.l.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public final class b
  extends BaseAdapter
{
  private final String TAG;
  private Context mContext;
  private LayoutInflater mInflater;
  List<a.a> sYN;
  private int sYQ;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(68362);
    this.TAG = "SnsLuckyMoneyReceivedRecordListAdapter";
    this.sYN = new ArrayList();
    this.sYQ = 1;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(68362);
  }
  
  private a.a Md(int paramInt)
  {
    AppMethodBeat.i(68364);
    a.a locala = (a.a)this.sYN.get(paramInt);
    AppMethodBeat.o(68364);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(68363);
    int i = this.sYN.size();
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
      localView = this.mInflater.inflate(2131495561, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.nVN = ((ImageView)localView.findViewById(2131301935));
      paramViewGroup.siX = ((TextView)localView.findViewById(2131301938));
      paramViewGroup.sYS = ((TextView)localView.findViewById(2131301939));
      paramViewGroup.sYT = ((TextView)localView.findViewById(2131301933));
      paramViewGroup.sYX = ((TextView)localView.findViewById(2131301937));
      localView.setTag(paramViewGroup);
    }
    for (;;)
    {
      a.a locala = Md(paramInt);
      com.tencent.mm.kernel.g.afC();
      af localaf = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(locala.kGt);
      label163:
      long l1;
      Object localObject;
      if (locala.kGt != null)
      {
        a.b.d(paramViewGroup.nVN, locala.kGt);
        TextView localTextView = paramViewGroup.sYS;
        paramView = this.mContext;
        l1 = locala.sXF * 1000L;
        localObject = new GregorianCalendar();
        if (l1 >= 3600000L) {
          break label381;
        }
        paramView = "";
        label207:
        localTextView.setText(paramView);
        paramViewGroup.sYS.setVisibility(0);
        if (localaf == null) {
          break label503;
        }
        com.tencent.mm.plugin.luckymoney.model.z.a(this.mContext, paramViewGroup.siX, localaf.ZX());
        label242:
        paramView = new bft();
      }
      try
      {
        if ((locala.sXG != null) && (locala.sXG.getILen() > 0))
        {
          paramView.parseFrom(com.tencent.mm.platformtools.z.a(locala.sXG));
          if (paramView.dEb > 0L)
          {
            paramView = this.mContext.getString(2131760940, new Object[] { e.D(paramView.dEb / 100.0D) });
            paramViewGroup.sYT.setText(paramView);
            paramViewGroup.sYX.setVisibility(8);
          }
          for (;;)
          {
            AppMethodBeat.o(68365);
            return localView;
            paramViewGroup = (a)paramView.getTag();
            localView = paramView;
            break;
            ad.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[] { locala.kGt });
            break label163;
            label381:
            long l2 = l1 - new GregorianCalendar(((GregorianCalendar)localObject).get(1), ((GregorianCalendar)localObject).get(2), ((GregorianCalendar)localObject).get(5)).getTimeInMillis();
            if ((l2 > 0L) && (l2 <= 86400000L))
            {
              paramView = new SimpleDateFormat("HH:mm").format(new Date(l1));
              break label207;
            }
            localObject = new Time();
            ((Time)localObject).set(l1);
            paramView = com.tencent.mm.pluginsdk.g.g.a(paramView.getString(2131759500, new Object[] { " " }), (Time)localObject).toString();
            break label207;
            label503:
            ad.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[] { locala.kGt });
            break label242;
            paramViewGroup.sYT.setVisibility(8);
            paramViewGroup.sYX.setVisibility(0);
          }
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          ad.e("SnsLuckyMoneyReceivedRecordListAdapter", paramView.getMessage() + "hbBuffer is error");
          paramViewGroup.sYT.setVisibility(8);
          paramViewGroup.sYX.setVisibility(8);
          paramViewGroup.nVN.setVisibility(8);
          paramViewGroup.siX.setVisibility(8);
          paramViewGroup.sYS.setVisibility(8);
          continue;
          paramViewGroup.sYT.setVisibility(8);
          paramViewGroup.sYX.setVisibility(0);
        }
      }
    }
  }
  
  final class a
  {
    ImageView nVN;
    TextView sYS;
    TextView sYT;
    TextView sYX;
    TextView siX;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.b
 * JD-Core Version:    0.7.0.1
 */