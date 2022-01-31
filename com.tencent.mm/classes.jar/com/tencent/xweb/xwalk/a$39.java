package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.RadioButton;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.k;
import org.xwalk.core.R.array;
import org.xwalk.core.R.id;

final class a$39
  implements AdapterView.OnItemSelectedListener
{
  a$39(a parama) {}
  
  public final void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    paramAdapterView = this.xlg.xgK.getResources().getStringArray(R.array.webviewuimodules);
    this.xlg.xlf = paramAdapterView[paramInt];
    paramAdapterView = this.xlg;
    paramAdapterView.xle = true;
    WebView.d locald;
    if (paramAdapterView.xlf.equals("all"))
    {
      paramView = paramAdapterView.xgK.getResources().getStringArray(R.array.webviewmodules);
      locald = k.cSk().agU(paramView[0]);
      paramInt = i;
      if (paramInt < paramView.length) {
        if (k.cSk().agU(paramView[paramInt]) != locald)
        {
          ((RadioButton)paramAdapterView.xld.findViewById(R.id.WV_AUTO)).setChecked(false);
          ((RadioButton)paramAdapterView.xld.findViewById(R.id.WV_XWALK)).setChecked(false);
          ((RadioButton)paramAdapterView.xld.findViewById(R.id.WV_X5)).setChecked(false);
          ((RadioButton)paramAdapterView.xld.findViewById(R.id.WV_SYS)).setChecked(false);
        }
      }
    }
    for (;;)
    {
      paramAdapterView.xle = false;
      return;
      paramInt += 1;
      break;
      paramAdapterView.h(locald);
      continue;
      paramAdapterView.h(k.cSk().agU(paramAdapterView.xlf));
    }
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.39
 * JD-Core Version:    0.7.0.1
 */