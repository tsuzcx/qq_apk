package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.v;
import java.util.GregorianCalendar;

final class d
  extends v<f>
{
  int Jpo;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public d(Context paramContext)
  {
    super(paramContext, new f());
    AppMethodBeat.i(28416);
    this.Jpo = 20;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(28416);
  }
  
  public final void aeA(int paramInt)
  {
    AppMethodBeat.i(28417);
    eKd();
    this.Jpo = paramInt;
    atr();
    AppMethodBeat.o(28417);
  }
  
  public final void atr()
  {
    AppMethodBeat.i(28419);
    v(m.fHp().aev(this.Jpo));
    super.notifyDataSetChanged();
    AppMethodBeat.o(28419);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(28418);
    atr();
    AppMethodBeat.o(28418);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(28420);
    Object localObject1;
    Object localObject2;
    label147:
    label168:
    long l1;
    if (paramView == null)
    {
      paramViewGroup = this.mInflater.inflate(R.i.ekV, paramViewGroup, false);
      localObject1 = new a();
      ((a)localObject1).Jpp = ((MMImageView)paramViewGroup.findViewById(R.h.dUi));
      ((a)localObject1).pPT = ((TextView)paramViewGroup.findViewById(R.h.dUk));
      ((a)localObject1).mMA = ((TextView)paramViewGroup.findViewById(R.h.dUh));
      ((a)localObject1).Eui = ((TextView)paramViewGroup.findViewById(R.h.dUj));
      paramViewGroup.setTag(localObject1);
      localObject2 = (f)getItem(paramInt);
      e.a(((a)localObject1).Jpp, ((f)localObject2).field_thumburl, R.k.app_attach_file_icon_webpage, false);
      if (!Util.isNullOrNil(((f)localObject2).field_title)) {
        break label240;
      }
      ((a)localObject1).pPT.setVisibility(8);
      if (!Util.isNullOrNil(((f)localObject2).field_desc)) {
        break label280;
      }
      ((a)localObject1).mMA.setVisibility(8);
      localObject1 = ((a)localObject1).Eui;
      paramView = this.mContext;
      l1 = ((f)localObject2).field_createtime * 1000L;
      localObject2 = new GregorianCalendar();
      if (l1 >= 3600000L) {
        break label320;
      }
      paramView = "";
    }
    for (;;)
    {
      ((TextView)localObject1).setText(paramView);
      AppMethodBeat.o(28420);
      return paramViewGroup;
      localObject1 = (a)paramView.getTag();
      paramViewGroup = paramView;
      break;
      label240:
      ((a)localObject1).pPT.setText(l.b(this.mContext, ((f)localObject2).field_title, ((a)localObject1).pPT.getTextSize()));
      ((a)localObject1).pPT.setVisibility(0);
      break label147;
      label280:
      ((a)localObject1).mMA.setText(l.b(this.mContext, ((f)localObject2).field_desc, ((a)localObject1).mMA.getTextSize()));
      ((a)localObject1).mMA.setVisibility(0);
      break label168;
      label320:
      long l2 = ((GregorianCalendar)localObject2).getTimeInMillis();
      int i;
      if ((l2 - l1) / 3600000L == 0L)
      {
        i = (int)((l2 - l1) / 60000L);
        paramInt = i;
        if (i <= 0) {
          paramInt = 1;
        }
        paramView = paramView.getResources().getQuantityString(R.j.fmt_in60min, paramInt, new Object[] { Integer.valueOf(paramInt) });
      }
      else
      {
        localObject2 = new GregorianCalendar(((GregorianCalendar)localObject2).get(1), ((GregorianCalendar)localObject2).get(2), ((GregorianCalendar)localObject2).get(5));
        long l3 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis();
        if ((l3 > 0L) && (l3 <= 86400000L))
        {
          i = (int)((l2 - l1) / 3600000L);
          paramInt = i;
          if (i <= 0) {
            paramInt = 1;
          }
          paramView = paramView.getResources().getQuantityString(R.j.fmt_in24h, paramInt, new Object[] { Integer.valueOf(paramInt) });
        }
        else
        {
          l3 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis() + 86400000L;
          if ((l3 > 0L) && (l3 <= 86400000L))
          {
            paramView = paramView.getString(R.l.fmt_pre_yesterday);
          }
          else
          {
            i = (int)((l2 - l1) / 86400000L);
            paramInt = i;
            if (i <= 0) {
              paramInt = 1;
            }
            paramView = paramView.getResources().getQuantityString(R.j.fmt_indayh, paramInt, new Object[] { Integer.valueOf(paramInt) });
          }
        }
      }
    }
  }
  
  final class a
  {
    TextView Eui;
    MMImageView Jpp;
    TextView mMA;
    TextView pPT;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.d
 * JD-Core Version:    0.7.0.1
 */