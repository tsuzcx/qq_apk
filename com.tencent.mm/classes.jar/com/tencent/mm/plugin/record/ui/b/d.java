package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.b.u;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.plugin.record.ui.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.bo;

public final class d
  implements h.b
{
  Context context;
  int jUm;
  int jUn;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void a(View paramView, int paramInt, b paramb, i parami, u paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(153644);
    paramView.setOnLongClickListener(new d.2(this, parami, paramBoolean, paramu, paramInt, paramb));
    AppMethodBeat.o(153644);
  }
  
  public final void a(View paramView, int paramInt, b paramb, Object paramObject)
  {
    AppMethodBeat.i(153643);
    TextView localTextView1 = (TextView)paramView.findViewById(2131827108);
    localTextView1.setText(paramb.cuL.desc);
    j.k(localTextView1, 1);
    TextView localTextView2 = (TextView)paramView.findViewById(2131827113);
    Object localObject = paramView.findViewById(2131827114);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131827115);
    localTextView2.setVisibility(8);
    ((View)localObject).setVisibility(8);
    localLinearLayout.setVisibility(8);
    i locali = (i)paramObject;
    if (locali != null)
    {
      paramObject = locali.Co(paramInt);
      if ((paramObject == null) || (paramObject.status != 2)) {
        break label247;
      }
      localTextView2.setText(paramObject.pYY);
      localTextView2.setVisibility(0);
      TextView localTextView3 = (TextView)paramView.findViewById(2131827117);
      if (!bo.isNullOrNil(paramObject.fwM)) {
        break label237;
      }
      localObject = paramView.getResources().getString(2131304283);
      label169:
      localTextView3.setText((CharSequence)localObject);
      localLinearLayout.setVisibility(0);
    }
    for (;;)
    {
      a(localTextView1, paramInt, paramb, locali, paramObject, true);
      if (locali != null) {
        a(localTextView2, paramInt, paramb, locali, paramObject, false);
      }
      paramView.setOnTouchListener(new d.1(this));
      AppMethodBeat.o(153643);
      return;
      paramObject = null;
      break;
      label237:
      localObject = paramObject.fwM;
      break label169;
      label247:
      if ((paramObject != null) && (paramObject.status == 1)) {
        ((View)localObject).setVisibility(0);
      }
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(24372);
    paramContext = View.inflate(paramContext, 2130970543, null);
    AppMethodBeat.o(24372);
    return paramContext;
  }
  
  public final void destroy()
  {
    this.context = null;
  }
  
  public final void pause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.d
 * JD-Core Version:    0.7.0.1
 */