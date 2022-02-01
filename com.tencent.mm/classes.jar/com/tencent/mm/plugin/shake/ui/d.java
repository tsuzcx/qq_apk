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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.s;
import java.util.GregorianCalendar;

final class d
  extends s<f>
{
  int DjM;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public d(Context paramContext)
  {
    super(paramContext, new f());
    AppMethodBeat.i(28416);
    this.DjM = 20;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(28416);
  }
  
  public final void XB(int paramInt)
  {
    AppMethodBeat.i(28417);
    ebf();
    this.DjM = paramInt;
    anp();
    AppMethodBeat.o(28417);
  }
  
  public final void anp()
  {
    AppMethodBeat.i(28419);
    setCursor(m.eUn().Xw(this.DjM));
    super.notifyDataSetChanged();
    AppMethodBeat.o(28419);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(28418);
    anp();
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
      paramViewGroup = this.mInflater.inflate(2131496285, paramViewGroup, false);
      localObject1 = new a();
      ((a)localObject1).DjN = ((MMImageView)paramViewGroup.findViewById(2131307751));
      ((a)localObject1).mPa = ((TextView)paramViewGroup.findViewById(2131307753));
      ((a)localObject1).jVn = ((TextView)paramViewGroup.findViewById(2131307750));
      ((a)localObject1).yQj = ((TextView)paramViewGroup.findViewById(2131307752));
      paramViewGroup.setTag(localObject1);
      localObject2 = (f)getItem(paramInt);
      e.a(((a)localObject1).DjN, ((f)localObject2).field_thumburl, 2131689587, false);
      if (!Util.isNullOrNil(((f)localObject2).field_title)) {
        break label234;
      }
      ((a)localObject1).mPa.setVisibility(8);
      if (!Util.isNullOrNil(((f)localObject2).field_desc)) {
        break label274;
      }
      ((a)localObject1).jVn.setVisibility(8);
      localObject1 = ((a)localObject1).yQj;
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
      ((a)localObject1).mPa.setText(l.b(this.mContext, ((f)localObject2).field_title, ((a)localObject1).mPa.getTextSize()));
      ((a)localObject1).mPa.setVisibility(0);
      break label141;
      label274:
      ((a)localObject1).jVn.setText(l.b(this.mContext, ((f)localObject2).field_desc, ((a)localObject1).jVn.getTextSize()));
      ((a)localObject1).jVn.setVisibility(0);
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
            paramView = paramView.getString(2131760868);
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
    MMImageView DjN;
    TextView jVn;
    TextView mPa;
    TextView yQj;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.d
 * JD-Core Version:    0.7.0.1
 */