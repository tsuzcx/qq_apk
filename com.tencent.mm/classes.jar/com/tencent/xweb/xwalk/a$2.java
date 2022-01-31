package com.tencent.xweb.xwalk;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.xweb.g.a;
import com.tencent.xweb.k;
import org.xwalk.core.Log;
import org.xwalk.core.R.id;

final class a$2
  implements RadioGroup.OnCheckedChangeListener
{
  a$2(a parama) {}
  
  public final void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    paramRadioGroup = g.a.xgw;
    if (paramInt == R.id.v8_auto) {
      paramRadioGroup = g.a.xgw;
    }
    for (;;)
    {
      k.cSk().a(paramRadioGroup);
      Log.d("WebDebugPage", "v8 type change to=" + paramRadioGroup);
      return;
      if (paramInt == R.id.v8_sys) {
        paramRadioGroup = g.a.xgx;
      } else if (paramInt == R.id.v8_x5) {
        paramRadioGroup = g.a.xgB;
      } else if (paramInt == R.id.v8_nativescript) {
        paramRadioGroup = g.a.xgD;
      } else if (paramInt == R.id.v8_mmv8) {
        paramRadioGroup = g.a.xgE;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.2
 * JD-Core Version:    0.7.0.1
 */