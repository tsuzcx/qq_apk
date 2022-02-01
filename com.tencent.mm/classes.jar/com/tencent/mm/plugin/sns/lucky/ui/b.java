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
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.wallet_core.ui.f;
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
  List<a.a> vvQ;
  private int vvT;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(68362);
    this.TAG = "SnsLuckyMoneyReceivedRecordListAdapter";
    this.vvQ = new ArrayList();
    this.vvT = 1;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(68362);
  }
  
  private a.a Qt(int paramInt)
  {
    AppMethodBeat.i(68364);
    a.a locala = (a.a)this.vvQ.get(paramInt);
    AppMethodBeat.o(68364);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(68363);
    int i = this.vvQ.size();
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
      paramViewGroup.pjj = ((ImageView)localView.findViewById(2131301935));
      paramViewGroup.uAJ = ((TextView)localView.findViewById(2131301938));
      paramViewGroup.vvV = ((TextView)localView.findViewById(2131301939));
      paramViewGroup.vvW = ((TextView)localView.findViewById(2131301933));
      paramViewGroup.vwa = ((TextView)localView.findViewById(2131301937));
      localView.setTag(paramViewGroup);
    }
    for (;;)
    {
      a.a locala = Qt(paramInt);
      g.ajS();
      an localan = ((l)g.ab(l.class)).azF().BH(locala.lJm);
      label163:
      long l1;
      Object localObject;
      if (locala.lJm != null)
      {
        a.b.d(paramViewGroup.pjj, locala.lJm);
        TextView localTextView = paramViewGroup.vvV;
        paramView = this.mContext;
        l1 = locala.vuH * 1000L;
        localObject = new GregorianCalendar();
        if (l1 >= 3600000L) {
          break label381;
        }
        paramView = "";
        label207:
        localTextView.setText(paramView);
        paramViewGroup.vvV.setVisibility(0);
        if (localan == null) {
          break label503;
        }
        com.tencent.mm.plugin.luckymoney.model.z.a(this.mContext, paramViewGroup.uAJ, localan.adG());
        label242:
        paramView = new bol();
      }
      try
      {
        if ((locala.vuI != null) && (locala.vuI.getILen() > 0))
        {
          paramView.parseFrom(com.tencent.mm.platformtools.z.a(locala.vuI));
          if (paramView.dPq > 0L)
          {
            paramView = this.mContext.getString(2131760940, new Object[] { f.C(paramView.dPq / 100.0D) });
            paramViewGroup.vvW.setText(paramView);
            paramViewGroup.vwa.setVisibility(8);
          }
          for (;;)
          {
            AppMethodBeat.o(68365);
            return localView;
            paramViewGroup = (a)paramView.getTag();
            localView = paramView;
            break;
            ae.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[] { locala.lJm });
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
            ae.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[] { locala.lJm });
            break label242;
            paramViewGroup.vvW.setVisibility(8);
            paramViewGroup.vwa.setVisibility(0);
          }
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          ae.e("SnsLuckyMoneyReceivedRecordListAdapter", paramView.getMessage() + "hbBuffer is error");
          paramViewGroup.vvW.setVisibility(8);
          paramViewGroup.vwa.setVisibility(8);
          paramViewGroup.pjj.setVisibility(8);
          paramViewGroup.uAJ.setVisibility(8);
          paramViewGroup.vvV.setVisibility(8);
          continue;
          paramViewGroup.vvW.setVisibility(8);
          paramViewGroup.vwa.setVisibility(0);
        }
      }
    }
  }
  
  final class a
  {
    ImageView pjj;
    TextView uAJ;
    TextView vvV;
    TextView vvW;
    TextView vwa;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.b
 * JD-Core Version:    0.7.0.1
 */