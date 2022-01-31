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
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.p;
import java.util.GregorianCalendar;

final class d
  extends p<f>
{
  private Context mContext;
  private LayoutInflater mInflater;
  int qPU;
  
  public d(Context paramContext)
  {
    super(paramContext, new f());
    AppMethodBeat.i(24745);
    this.qPU = 20;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(24745);
  }
  
  public final void Dp(int paramInt)
  {
    AppMethodBeat.i(24746);
    bKb();
    this.qPU = paramInt;
    Ku();
    AppMethodBeat.o(24746);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(24748);
    setCursor(m.clo().Dk(this.qPU));
    super.notifyDataSetChanged();
    AppMethodBeat.o(24748);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(24747);
    Ku();
    AppMethodBeat.o(24747);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(24749);
    Object localObject1;
    Object localObject2;
    label141:
    label162:
    long l1;
    if (paramView == null)
    {
      paramViewGroup = this.mInflater.inflate(2130970714, paramViewGroup, false);
      localObject1 = new d.a(this);
      ((d.a)localObject1).qPV = ((MMImageView)paramViewGroup.findViewById(2131827706));
      ((d.a)localObject1).iJG = ((TextView)paramViewGroup.findViewById(2131827707));
      ((d.a)localObject1).kPB = ((TextView)paramViewGroup.findViewById(2131827708));
      ((d.a)localObject1).ojf = ((TextView)paramViewGroup.findViewById(2131827709));
      paramViewGroup.setTag(localObject1);
      localObject2 = (f)getItem(paramInt);
      e.a(((d.a)localObject1).qPV, ((f)localObject2).field_thumburl, 2131230829, false);
      if (!bo.isNullOrNil(((f)localObject2).field_title)) {
        break label234;
      }
      ((d.a)localObject1).iJG.setVisibility(8);
      if (!bo.isNullOrNil(((f)localObject2).field_desc)) {
        break label274;
      }
      ((d.a)localObject1).kPB.setVisibility(8);
      localObject1 = ((d.a)localObject1).ojf;
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
      AppMethodBeat.o(24749);
      return paramViewGroup;
      localObject1 = (d.a)paramView.getTag();
      paramViewGroup = paramView;
      break;
      label234:
      ((d.a)localObject1).iJG.setText(j.b(this.mContext, ((f)localObject2).field_title, ((d.a)localObject1).iJG.getTextSize()));
      ((d.a)localObject1).iJG.setVisibility(0);
      break label141;
      label274:
      ((d.a)localObject1).kPB.setText(j.b(this.mContext, ((f)localObject2).field_desc, ((d.a)localObject1).kPB.getTextSize()));
      ((d.a)localObject1).kPB.setVisibility(0);
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
        paramView = paramView.getResources().getQuantityString(2131361802, paramInt, new Object[] { Integer.valueOf(paramInt) });
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
          paramView = paramView.getResources().getQuantityString(2131361801, paramInt, new Object[] { Integer.valueOf(paramInt) });
        }
        else
        {
          l3 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis() + 86400000L;
          if ((l3 > 0L) && (l3 <= 86400000L))
          {
            paramView = paramView.getString(2131300084);
          }
          else
          {
            i = (int)((l2 - l1) / 86400000L);
            paramInt = i;
            if (i <= 0) {
              paramInt = 1;
            }
            paramView = paramView.getResources().getQuantityString(2131361803, paramInt, new Object[] { Integer.valueOf(paramInt) });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.d
 * JD-Core Version:    0.7.0.1
 */