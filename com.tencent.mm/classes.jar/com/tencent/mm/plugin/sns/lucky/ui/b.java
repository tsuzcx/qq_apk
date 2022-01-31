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
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.l.a.a;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.sdk.platformtools.ab;
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
  private final String TAG;
  private Context mContext;
  private LayoutInflater mInflater;
  List<a.a> oja;
  private int ojd;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(45190);
    this.TAG = "SnsLuckyMoneyReceivedRecordListAdapter";
    this.oja = new ArrayList();
    this.ojd = 1;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(45190);
  }
  
  private a.a DD(int paramInt)
  {
    AppMethodBeat.i(45192);
    a.a locala = (a.a)this.oja.get(paramInt);
    AppMethodBeat.o(45192);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(45191);
    int i = this.oja.size();
    AppMethodBeat.o(45191);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(45193);
    View localView;
    if (paramView == null)
    {
      localView = this.mInflater.inflate(2130970837, paramViewGroup, false);
      paramViewGroup = new b.a(this);
      paramViewGroup.kPy = ((ImageView)localView.findViewById(2131825822));
      paramViewGroup.nzx = ((TextView)localView.findViewById(2131825823));
      paramViewGroup.ojf = ((TextView)localView.findViewById(2131825827));
      paramViewGroup.ojg = ((TextView)localView.findViewById(2131825824));
      paramViewGroup.ojk = ((TextView)localView.findViewById(2131825829));
      localView.setTag(paramViewGroup);
    }
    for (;;)
    {
      a.a locala = DD(paramInt);
      com.tencent.mm.kernel.g.RM();
      ad localad = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(locala.ikj);
      label163:
      long l1;
      Object localObject;
      if (locala.ikj != null)
      {
        a.b.s(paramViewGroup.kPy, locala.ikj);
        TextView localTextView = paramViewGroup.ojf;
        paramView = this.mContext;
        l1 = locala.oic * 1000L;
        localObject = new GregorianCalendar();
        if (l1 >= 3600000L) {
          break label381;
        }
        paramView = "";
        label207:
        localTextView.setText(paramView);
        paramViewGroup.ojf.setVisibility(0);
        if (localad == null) {
          break label503;
        }
        x.a(this.mContext, paramViewGroup.nzx, localad.Of());
        label242:
        paramView = new aur();
      }
      try
      {
        if ((locala.oid != null) && (locala.oid.getILen() > 0))
        {
          paramView.parseFrom(aa.a(locala.oid));
          if (paramView.cNd > 0L)
          {
            paramView = this.mContext.getString(2131301295, new Object[] { e.E(paramView.cNd / 100.0D) });
            paramViewGroup.ojg.setText(paramView);
            paramViewGroup.ojk.setVisibility(8);
          }
          for (;;)
          {
            AppMethodBeat.o(45193);
            return localView;
            paramViewGroup = (b.a)paramView.getTag();
            localView = paramView;
            break;
            ab.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[] { locala.ikj });
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
            paramView = com.tencent.mm.pluginsdk.f.g.a(paramView.getString(2131300033, new Object[] { " " }), (Time)localObject).toString();
            break label207;
            label503:
            ab.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[] { locala.ikj });
            break label242;
            paramViewGroup.ojg.setVisibility(8);
            paramViewGroup.ojk.setVisibility(0);
          }
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          ab.e("SnsLuckyMoneyReceivedRecordListAdapter", paramView.getMessage() + "hbBuffer is error");
          paramViewGroup.ojg.setVisibility(8);
          paramViewGroup.ojk.setVisibility(8);
          paramViewGroup.kPy.setVisibility(8);
          paramViewGroup.nzx.setVisibility(8);
          paramViewGroup.ojf.setVisibility(8);
          continue;
          paramViewGroup.ojg.setVisibility(8);
          paramViewGroup.ojk.setVisibility(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.b
 * JD-Core Version:    0.7.0.1
 */