package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.modelstat.m;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.plugin.setting.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;

public class NetStatPreference
  extends Preference
{
  boolean CZf;
  
  public NetStatPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NetStatPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(73895);
    this.CZf = false;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.a.NetStatPreference, paramInt, 0);
    if (paramAttributeSet.getInt(0, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.CZf = bool;
      paramAttributeSet.recycle();
      setSummary(paramContext.getString(2131765499, new Object[] { Integer.valueOf(15) }));
      AppMethodBeat.o(73895);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(73897);
    super.onBindView(paramView);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131302176);
    localLinearLayout.removeAllViews();
    int k = (int)(System.currentTimeMillis() / 86400000L);
    int i = 15;
    while (i > 0)
    {
      localNetStatGroup = new NetStatGroup(this.mContext);
      int m = k - i + 1;
      bool = this.CZf;
      localObject = DateFormat.format(localNetStatGroup.getContext().getString(2131760813, new Object[] { "" }), m * 86400000L).toString();
      localNetStatGroup.CZe.setText((CharSequence)localObject);
      Log.d("MicroMsg.NetStatGroup", "NetStat dataTime = ".concat(String.valueOf(localObject)));
      localNetStatGroup.CZd.removeAllViews();
      int j = 0;
      if (j < 5)
      {
        localObject = new NetStatUnit(localNetStatGroup.getContext());
        k localk = q.bgo().tU(m + j);
        long l1;
        long l2;
        long l3;
        if (localk != null)
        {
          if (!bool) {
            break label319;
          }
          Log.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d wifi : %d %d %d %d", new Object[] { Integer.valueOf(localk.jog), Long.valueOf(localk.joC), Long.valueOf(localk.joq), Long.valueOf(localk.joE), Long.valueOf(localk.jos) });
          l1 = localk.joC;
          l2 = localk.joq;
          l3 = localk.joE;
          ((NetStatUnit)localObject).al(l1 + l2, localk.jos + l3);
        }
        for (;;)
        {
          ((NetStatUnit)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
          localNetStatGroup.CZd.addView((View)localObject);
          j += 1;
          break;
          label319:
          Log.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d mobile : %d %d %d %d", new Object[] { Integer.valueOf(localk.jog), Long.valueOf(localk.joB), Long.valueOf(localk.jop), Long.valueOf(localk.joD), Long.valueOf(localk.jor) });
          l1 = localk.joB;
          l2 = localk.jop;
          l3 = localk.joD;
          ((NetStatUnit)localObject).al(l1 + l2, localk.jor + l3);
        }
      }
      localLinearLayout.addView(localNetStatGroup, -2, -1);
      i -= 5;
    }
    localLinearLayout = (LinearLayout)paramView.findViewById(2131307195);
    localLinearLayout.removeAllViews();
    NetStatGroup localNetStatGroup = new NetStatGroup(this.mContext);
    boolean bool = this.CZf;
    localNetStatGroup.removeAllViews();
    View.inflate(localNetStatGroup.getContext(), 2131495838, localNetStatGroup);
    localNetStatGroup.CZd = ((LinearLayout)localNetStatGroup.findViewById(2131302176));
    Object localObject = new NetStatRuler(localNetStatGroup.getContext());
    if (bool) {}
    for (paramView = "wifi";; paramView = "mobile")
    {
      ((NetStatRuler)localObject).setTag(paramView);
      ((NetStatRuler)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
      localNetStatGroup.CZd.addView((View)localObject);
      localLinearLayout.addView(localNetStatGroup);
      alO(8);
      AppMethodBeat.o(73897);
      return;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(73896);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131495572, localViewGroup);
    AppMethodBeat.o(73896);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.NetStatPreference
 * JD-Core Version:    0.7.0.1
 */