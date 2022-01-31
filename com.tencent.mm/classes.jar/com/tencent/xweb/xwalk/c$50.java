package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.RadioButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.q;

final class c$50
  implements AdapterView.OnItemSelectedListener
{
  c$50(c paramc) {}
  
  public final void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    AppMethodBeat.i(85173);
    paramAdapterView = this.BIO.BDH.getResources().getStringArray(2131755070);
    this.BIO.BIM = paramAdapterView[paramInt];
    paramAdapterView = this.BIO;
    paramAdapterView.BIL = true;
    WebView.d locald;
    if (paramAdapterView.BIM.equals("all"))
    {
      paramView = paramAdapterView.BDH.getResources().getStringArray(2131755069);
      locald = q.dYn().axW(paramView[0]);
      paramInt = i;
      if (paramInt < paramView.length) {
        if (q.dYn().axW(paramView[paramInt]) != locald)
        {
          ((RadioButton)paramAdapterView.BIK.findViewById(2131823321)).setChecked(false);
          ((RadioButton)paramAdapterView.BIK.findViewById(2131823322)).setChecked(false);
          ((RadioButton)paramAdapterView.BIK.findViewById(2131823324)).setChecked(false);
          ((RadioButton)paramAdapterView.BIK.findViewById(2131823323)).setChecked(false);
        }
      }
    }
    for (;;)
    {
      paramAdapterView.BIL = false;
      AppMethodBeat.o(85173);
      return;
      paramInt += 1;
      break;
      paramAdapterView.k(locald);
      continue;
      paramAdapterView.k(q.dYn().axW(paramAdapterView.BIM));
    }
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.50
 * JD-Core Version:    0.7.0.1
 */