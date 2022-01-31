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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  
  private i Bk(int paramInt)
  {
    AppMethodBeat.i(43857);
    i locali = (i)this.prh.prd.get(paramInt);
    AppMethodBeat.o(43857);
    return locali;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(43856);
    int i = this.prh.prd.size();
    AppMethodBeat.o(43856);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(43858);
    View localView;
    i locali;
    int i;
    Object localObject1;
    if (paramView == null)
    {
      localView = View.inflate(this.prh, 2130970103, null);
      paramViewGroup = new MallOrderRecordListUI.b(this.prh, (byte)0);
      paramViewGroup.prj = ((TextView)localView.findViewById(2131826007));
      paramViewGroup.prl = ((TextView)localView.findViewById(2131826009));
      paramViewGroup.prk = ((TextView)localView.findViewById(2131826008));
      paramViewGroup.prm = ((TextView)localView.findViewById(2131826011));
      paramViewGroup.pro = localView.findViewById(2131826004);
      paramViewGroup.prp = ((TextView)localView.findViewById(2131826005));
      paramViewGroup.prq = ((TextView)localView.findViewById(2131826006));
      paramViewGroup.prn = ((TextView)localView.findViewById(2131826010));
      localView.setTag(paramViewGroup);
      locali = Bk(paramInt);
      i = 0;
      if (paramInt != 0) {
        break label592;
      }
      i = 1;
      paramView = Bk(0);
      localObject1 = new GregorianCalendar();
      ((GregorianCalendar)localObject1).setTimeInMillis(paramView.CreateTime * 1000L);
      paramView = MallOrderRecordListUI.fb(((GregorianCalendar)localObject1).get(1), ((GregorianCalendar)localObject1).get(2) + 1);
    }
    for (;;)
    {
      for (;;)
      {
        if (i != 0)
        {
          localObject1 = new SimpleDateFormat(this.prh.getString(2131300112, new Object[] { "" })).format(new Date(Bk(paramInt).CreateTime * 1000L));
          paramViewGroup.prp.setText((CharSequence)localObject1);
          if ((!bo.isNullOrNil(paramView)) && (!bo.isNullOrNil((String)this.prh.prg.get(paramView)))) {
            paramViewGroup.prq.setText((CharSequence)this.prh.prg.get(paramView));
          }
          paramViewGroup.pro.setVisibility(0);
          label337:
          paramViewGroup.prj.setText(locali.pqa);
          paramViewGroup.prk.setText(locali.pqb);
          i = this.prh.getContext().getResources().getColor(2131690269);
          paramInt = i;
          if (bo.isNullOrNil(locali.pqn)) {}
        }
        try
        {
          paramInt = Color.parseColor(locali.pqn);
          paramViewGroup.prk.setTextColor(paramInt);
          paramViewGroup.prl.setText(this.prh.Bj(locali.CreateTime));
          i = this.prh.getContext().getResources().getColor(2131690271);
          paramInt = i;
          if (bo.isNullOrNil(locali.pqo)) {}
        }
        catch (Exception paramView)
        {
          try
          {
            paramInt = Color.parseColor(locali.pqo);
            if (locali.ppZ != locali.pqp)
            {
              paramView = e.e(locali.ppZ / 100.0D, locali.pqd);
              localObject1 = new SpannableString(paramView);
              ((SpannableString)localObject1).setSpan(new StrikethroughSpan(), 0, paramView.length(), 33);
              paramViewGroup.prm.setText((CharSequence)localObject1);
              paramViewGroup.prn.setTextColor(paramInt);
              paramViewGroup.prn.setText(e.e(locali.pqp / 100.0D, locali.pqd));
              AppMethodBeat.o(43858);
              return localView;
              paramViewGroup = (MallOrderRecordListUI.b)paramView.getTag();
              localView = paramView;
              break;
              label592:
              paramView = Bk(paramInt);
              Object localObject2 = Bk(paramInt - 1);
              if ((paramView.CreateTime <= 0) || (((i)localObject2).CreateTime <= 0)) {
                break label821;
              }
              localObject1 = new GregorianCalendar();
              ((GregorianCalendar)localObject1).setTimeInMillis(((i)localObject2).CreateTime * 1000L);
              localObject2 = new GregorianCalendar();
              ((GregorianCalendar)localObject2).setTimeInMillis(paramView.CreateTime * 1000L);
              if ((((GregorianCalendar)localObject1).get(1) == ((GregorianCalendar)localObject2).get(1)) && (((GregorianCalendar)localObject1).get(2) == ((GregorianCalendar)localObject2).get(2))) {
                break label821;
              }
              i = 1;
              paramView = MallOrderRecordListUI.fb(((GregorianCalendar)localObject2).get(1), ((GregorianCalendar)localObject2).get(2) + 1);
              continue;
              paramViewGroup.pro.setVisibility(8);
              break label337;
              paramView = paramView;
              ab.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bo.nullAsNil(locali.pqn));
              paramInt = i;
            }
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              ab.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bo.nullAsNil(locali.pqo));
              paramInt = i;
              continue;
              paramViewGroup.prm.setText("");
            }
            label821:
            paramView = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.a
 * JD-Core Version:    0.7.0.1
 */