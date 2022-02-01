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
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.l.a.a;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.i.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cbd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
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
  List<a.a> yQe;
  private int yQh;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(68362);
    this.TAG = "SnsLuckyMoneyReceivedRecordListAdapter";
    this.yQe = new ArrayList();
    this.yQh = 1;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(68362);
  }
  
  private a.a Yq(int paramInt)
  {
    AppMethodBeat.i(68364);
    a.a locala = (a.a)this.yQe.get(paramInt);
    AppMethodBeat.o(68364);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(68363);
    int i = this.yQe.size();
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
      localView = this.mInflater.inflate(2131496453, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.qyu = ((ImageView)localView.findViewById(2131304259));
      paramViewGroup.rMV = ((TextView)localView.findViewById(2131304263));
      paramViewGroup.yQj = ((TextView)localView.findViewById(2131304264));
      paramViewGroup.yQk = ((TextView)localView.findViewById(2131304257));
      paramViewGroup.yQo = ((TextView)localView.findViewById(2131304261));
      localView.setTag(paramViewGroup);
    }
    for (;;)
    {
      a.a locala = Yq(paramInt);
      g.aAi();
      as localas = ((l)g.af(l.class)).aSN().Kn(locala.mRa);
      label163:
      long l1;
      Object localObject;
      if (locala.mRa != null)
      {
        a.b.d(paramViewGroup.qyu, locala.mRa);
        TextView localTextView = paramViewGroup.yQj;
        paramView = this.mContext;
        l1 = locala.yOR * 1000L;
        localObject = new GregorianCalendar();
        if (l1 >= 3600000L) {
          break label381;
        }
        paramView = "";
        label207:
        localTextView.setText(paramView);
        paramViewGroup.yQj.setVisibility(0);
        if (localas == null) {
          break label503;
        }
        af.a(this.mContext, paramViewGroup.rMV, localas.arJ());
        label242:
        paramView = new cbd();
      }
      try
      {
        if ((locala.yOS != null) && (locala.yOS.getILen() > 0))
        {
          paramView.parseFrom(z.a(locala.yOS));
          if (paramView.eht > 0L)
          {
            paramView = this.mContext.getString(2131762714, new Object[] { f.formatMoney2f(paramView.eht / 100.0D) });
            paramViewGroup.yQk.setText(paramView);
            paramViewGroup.yQo.setVisibility(8);
          }
          for (;;)
          {
            AppMethodBeat.o(68365);
            return localView;
            paramViewGroup = (a)paramView.getTag();
            localView = paramView;
            break;
            Log.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[] { locala.mRa });
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
            paramView = e.a(paramView.getString(2131760815, new Object[] { " " }), (Time)localObject).toString();
            break label207;
            label503:
            Log.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[] { locala.mRa });
            break label242;
            paramViewGroup.yQk.setVisibility(8);
            paramViewGroup.yQo.setVisibility(0);
          }
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          Log.e("SnsLuckyMoneyReceivedRecordListAdapter", paramView.getMessage() + "hbBuffer is error");
          paramViewGroup.yQk.setVisibility(8);
          paramViewGroup.yQo.setVisibility(8);
          paramViewGroup.qyu.setVisibility(8);
          paramViewGroup.rMV.setVisibility(8);
          paramViewGroup.yQj.setVisibility(8);
          continue;
          paramViewGroup.yQk.setVisibility(8);
          paramViewGroup.yQo.setVisibility(0);
        }
      }
    }
  }
  
  final class a
  {
    ImageView qyu;
    TextView rMV;
    TextView yQj;
    TextView yQk;
    TextView yQo;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.b
 * JD-Core Version:    0.7.0.1
 */