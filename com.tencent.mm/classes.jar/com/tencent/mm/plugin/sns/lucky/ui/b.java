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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.l.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.i.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  List<a.a> vjL;
  private int vjO;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(68362);
    this.TAG = "SnsLuckyMoneyReceivedRecordListAdapter";
    this.vjL = new ArrayList();
    this.vjO = 1;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(68362);
  }
  
  private a.a PM(int paramInt)
  {
    AppMethodBeat.i(68364);
    a.a locala = (a.a)this.vjL.get(paramInt);
    AppMethodBeat.o(68364);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(68363);
    int i = this.vjL.size();
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
      paramViewGroup.pcD = ((ImageView)localView.findViewById(2131301935));
      paramViewGroup.upn = ((TextView)localView.findViewById(2131301938));
      paramViewGroup.vjQ = ((TextView)localView.findViewById(2131301939));
      paramViewGroup.vjR = ((TextView)localView.findViewById(2131301933));
      paramViewGroup.vjV = ((TextView)localView.findViewById(2131301937));
      localView.setTag(paramViewGroup);
    }
    for (;;)
    {
      a.a locala = PM(paramInt);
      g.ajD();
      am localam = ((l)g.ab(l.class)).azp().Bf(locala.lEN);
      label163:
      long l1;
      Object localObject;
      if (locala.lEN != null)
      {
        a.b.d(paramViewGroup.pcD, locala.lEN);
        TextView localTextView = paramViewGroup.vjQ;
        paramView = this.mContext;
        l1 = locala.viC * 1000L;
        localObject = new GregorianCalendar();
        if (l1 >= 3600000L) {
          break label381;
        }
        paramView = "";
        label207:
        localTextView.setText(paramView);
        paramViewGroup.vjQ.setVisibility(0);
        if (localam == null) {
          break label503;
        }
        com.tencent.mm.plugin.luckymoney.model.z.a(this.mContext, paramViewGroup.upn, localam.adv());
        label242:
        paramView = new bnt();
      }
      try
      {
        if ((locala.viD != null) && (locala.viD.getILen() > 0))
        {
          paramView.parseFrom(com.tencent.mm.platformtools.z.a(locala.viD));
          if (paramView.dOa > 0L)
          {
            paramView = this.mContext.getString(2131760940, new Object[] { e.C(paramView.dOa / 100.0D) });
            paramViewGroup.vjR.setText(paramView);
            paramViewGroup.vjV.setVisibility(8);
          }
          for (;;)
          {
            AppMethodBeat.o(68365);
            return localView;
            paramViewGroup = (a)paramView.getTag();
            localView = paramView;
            break;
            ad.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[] { locala.lEN });
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
            paramView = h.a(paramView.getString(2131759500, new Object[] { " " }), (Time)localObject).toString();
            break label207;
            label503:
            ad.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[] { locala.lEN });
            break label242;
            paramViewGroup.vjR.setVisibility(8);
            paramViewGroup.vjV.setVisibility(0);
          }
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          ad.e("SnsLuckyMoneyReceivedRecordListAdapter", paramView.getMessage() + "hbBuffer is error");
          paramViewGroup.vjR.setVisibility(8);
          paramViewGroup.vjV.setVisibility(8);
          paramViewGroup.pcD.setVisibility(8);
          paramViewGroup.upn.setVisibility(8);
          paramViewGroup.vjQ.setVisibility(8);
          continue;
          paramViewGroup.vjR.setVisibility(8);
          paramViewGroup.vjV.setVisibility(0);
        }
      }
    }
  }
  
  final class a
  {
    ImageView pcD;
    TextView upn;
    TextView vjQ;
    TextView vjR;
    TextView vjV;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.b
 * JD-Core Version:    0.7.0.1
 */