package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.RadioButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.y;

final class d$54
  implements AdapterView.OnItemSelectedListener
{
  d$54(d paramd) {}
  
  public final void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(154214);
    Object localObject = new b();
    ((b)localObject).bm(paramAdapterView);
    ((b)localObject).bm(paramView);
    ((b)localObject).pH(paramInt);
    ((b)localObject).zo(paramLong);
    a.b("com/tencent/xweb/xwalk/WebDebugPage$8", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).axR());
    paramAdapterView = this.SGe.SzQ.getResources().getStringArray(2130903106);
    this.SGe.SFY = paramAdapterView[paramInt];
    paramAdapterView = this.SGe;
    paramAdapterView.SFX = true;
    if (paramAdapterView.SFY.equals("all"))
    {
      paramView = paramAdapterView.SzQ.getResources().getStringArray(2130903105);
      localObject = y.hsF().bsk(paramView[0]);
      paramInt = 1;
      if (paramInt < paramView.length) {
        if (y.hsF().bsk(paramView[paramInt]) != localObject)
        {
          ((RadioButton)paramAdapterView.SFW.findViewById(2131296280)).setChecked(false);
          ((RadioButton)paramAdapterView.SFW.findViewById(2131296283)).setChecked(false);
          ((RadioButton)paramAdapterView.SFW.findViewById(2131296282)).setChecked(false);
          ((RadioButton)paramAdapterView.SFW.findViewById(2131296281)).setChecked(false);
        }
      }
    }
    for (;;)
    {
      paramAdapterView.SFX = false;
      a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$8", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(154214);
      return;
      paramInt += 1;
      break;
      paramAdapterView.m((WebView.c)localObject);
      continue;
      paramAdapterView.m(y.hsF().bsk(paramAdapterView.SFY));
    }
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.54
 * JD-Core Version:    0.7.0.1
 */