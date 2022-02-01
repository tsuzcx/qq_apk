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
import com.tencent.mm.protocal.protobuf.bjl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  List<a.a> uhb;
  private int uhe;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(68362);
    this.TAG = "SnsLuckyMoneyReceivedRecordListAdapter";
    this.uhb = new ArrayList();
    this.uhe = 1;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(68362);
  }
  
  private a.a Of(int paramInt)
  {
    AppMethodBeat.i(68364);
    a.a locala = (a.a)this.uhb.get(paramInt);
    AppMethodBeat.o(68364);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(68363);
    int i = this.uhb.size();
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
      paramViewGroup.ozi = ((ImageView)localView.findViewById(2131301935));
      paramViewGroup.tqQ = ((TextView)localView.findViewById(2131301938));
      paramViewGroup.uhg = ((TextView)localView.findViewById(2131301939));
      paramViewGroup.uhh = ((TextView)localView.findViewById(2131301933));
      paramViewGroup.uhl = ((TextView)localView.findViewById(2131301937));
      localView.setTag(paramViewGroup);
    }
    for (;;)
    {
      a.a locala = Of(paramInt);
      com.tencent.mm.kernel.g.agS();
      ai localai = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(locala.lhM);
      label163:
      long l1;
      Object localObject;
      if (locala.lhM != null)
      {
        a.b.d(paramViewGroup.ozi, locala.lhM);
        TextView localTextView = paramViewGroup.uhg;
        paramView = this.mContext;
        l1 = locala.ufS * 1000L;
        localObject = new GregorianCalendar();
        if (l1 >= 3600000L) {
          break label381;
        }
        paramView = "";
        label207:
        localTextView.setText(paramView);
        paramViewGroup.uhg.setVisibility(0);
        if (localai == null) {
          break label503;
        }
        com.tencent.mm.plugin.luckymoney.model.z.a(this.mContext, paramViewGroup.tqQ, localai.aaS());
        label242:
        paramView = new bjl();
      }
      try
      {
        if ((locala.ufT != null) && (locala.ufT.getILen() > 0))
        {
          paramView.parseFrom(com.tencent.mm.platformtools.z.a(locala.ufT));
          if (paramView.dBN > 0L)
          {
            paramView = this.mContext.getString(2131760940, new Object[] { e.C(paramView.dBN / 100.0D) });
            paramViewGroup.uhh.setText(paramView);
            paramViewGroup.uhl.setVisibility(8);
          }
          for (;;)
          {
            AppMethodBeat.o(68365);
            return localView;
            paramViewGroup = (a)paramView.getTag();
            localView = paramView;
            break;
            ac.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[] { locala.lhM });
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
            ac.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[] { locala.lhM });
            break label242;
            paramViewGroup.uhh.setVisibility(8);
            paramViewGroup.uhl.setVisibility(0);
          }
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          ac.e("SnsLuckyMoneyReceivedRecordListAdapter", paramView.getMessage() + "hbBuffer is error");
          paramViewGroup.uhh.setVisibility(8);
          paramViewGroup.uhl.setVisibility(8);
          paramViewGroup.ozi.setVisibility(8);
          paramViewGroup.tqQ.setVisibility(8);
          paramViewGroup.uhg.setVisibility(8);
          continue;
          paramViewGroup.uhh.setVisibility(8);
          paramViewGroup.uhl.setVisibility(0);
        }
      }
    }
  }
  
  final class a
  {
    ImageView ozi;
    TextView tqQ;
    TextView uhg;
    TextView uhh;
    TextView uhl;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.b
 * JD-Core Version:    0.7.0.1
 */