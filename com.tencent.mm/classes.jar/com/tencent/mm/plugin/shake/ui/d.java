package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.r;
import java.util.GregorianCalendar;

final class d
  extends r<f>
{
  private Context mContext;
  private LayoutInflater mInflater;
  int zeU;
  
  public d(Context paramContext)
  {
    super(paramContext, new f());
    AppMethodBeat.i(28416);
    this.zeU = 20;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(28416);
  }
  
  public final void PY(int paramInt)
  {
    AppMethodBeat.i(28417);
    dhl();
    this.zeU = paramInt;
    ZD();
    AppMethodBeat.o(28417);
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(28419);
    setCursor(m.dSm().PT(this.zeU));
    super.notifyDataSetChanged();
    AppMethodBeat.o(28419);
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(28418);
    ZD();
    AppMethodBeat.o(28418);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(28420);
    Object localObject1;
    Object localObject2;
    label141:
    label162:
    long l1;
    if (paramView == null)
    {
      paramViewGroup = this.mInflater.inflate(2131495417, paramViewGroup, false);
      localObject1 = new a();
      ((a)localObject1).zeV = ((MMImageView)paramViewGroup.findViewById(2131304694));
      ((a)localObject1).lHk = ((TextView)paramViewGroup.findViewById(2131304696));
      ((a)localObject1).lHT = ((TextView)paramViewGroup.findViewById(2131304693));
      ((a)localObject1).vvV = ((TextView)paramViewGroup.findViewById(2131304695));
      paramViewGroup.setTag(localObject1);
      localObject2 = (f)getItem(paramInt);
      e.a(((a)localObject1).zeV, ((f)localObject2).field_thumburl, 2131689584, false);
      if (!bu.isNullOrNil(((f)localObject2).field_title)) {
        break label234;
      }
      ((a)localObject1).lHk.setVisibility(8);
      if (!bu.isNullOrNil(((f)localObject2).field_desc)) {
        break label274;
      }
      ((a)localObject1).lHT.setVisibility(8);
      localObject1 = ((a)localObject1).vvV;
      paramView = this.mContext;
      l1 = ((f)localObject2).field_createtime * 1000L;
      localObject2 = new GregorianCalendar();
      if (l1 >= 3600000L) {
        break label314;
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
      label234:
      ((a)localObject1).lHk.setText(k.b(this.mContext, ((f)localObject2).field_title, ((a)localObject1).lHk.getTextSize()));
      ((a)localObject1).lHk.setVisibility(0);
      break label141;
      label274:
      ((a)localObject1).lHT.setText(k.b(this.mContext, ((f)localObject2).field_desc, ((a)localObject1).lHT.getTextSize()));
      ((a)localObject1).lHT.setVisibility(0);
      break label162;
      label314:
      long l2 = ((GregorianCalendar)localObject2).getTimeInMillis();
      int i;
      if ((l2 - l1) / 3600000L == 0L)
      {
        i = (int)((l2 - l1) / 60000L);
        paramInt = i;
        if (i <= 0) {
          paramInt = 1;
        }
        paramView = paramView.getResources().getQuantityString(2131623946, paramInt, new Object[] { Integer.valueOf(paramInt) });
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
          paramView = paramView.getResources().getQuantityString(2131623945, paramInt, new Object[] { Integer.valueOf(paramInt) });
        }
        else
        {
          l3 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis() + 86400000L;
          if ((l3 > 0L) && (l3 <= 86400000L))
          {
            paramView = paramView.getString(2131759551);
          }
          else
          {
            i = (int)((l2 - l1) / 86400000L);
            paramInt = i;
            if (i <= 0) {
              paramInt = 1;
            }
            paramView = paramView.getResources().getQuantityString(2131623947, paramInt, new Object[] { Integer.valueOf(paramInt) });
          }
        }
      }
    }
  }
  
  final class a
  {
    TextView lHT;
    TextView lHk;
    TextView vvV;
    MMImageView zeV;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.d
 * JD-Core Version:    0.7.0.1
 */