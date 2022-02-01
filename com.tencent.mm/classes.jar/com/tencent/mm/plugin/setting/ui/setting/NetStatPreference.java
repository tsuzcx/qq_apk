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
import com.tencent.mm.plugin.setting.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.Preference;

public class NetStatPreference
  extends Preference
{
  boolean weq;
  
  public NetStatPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NetStatPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(73895);
    this.weq = false;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.NetStatPreference, paramInt, 0);
    if (paramAttributeSet.getInt(0, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.weq = bool;
      paramAttributeSet.recycle();
      setSummary(paramContext.getString(2131763320, new Object[] { Integer.valueOf(15) }));
      AppMethodBeat.o(73895);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(73897);
    super.onBindView(paramView);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131300621);
    localLinearLayout.removeAllViews();
    int k = (int)(System.currentTimeMillis() / 86400000L);
    int i = 15;
    while (i > 0)
    {
      localNetStatGroup = new NetStatGroup(this.mContext);
      int m = k - i + 1;
      bool = this.weq;
      localObject = DateFormat.format(localNetStatGroup.getContext().getString(2131759498, new Object[] { "" }), m * 86400000L).toString();
      localNetStatGroup.wep.setText((CharSequence)localObject);
      ad.d("MicroMsg.NetStatGroup", "NetStat dataTime = ".concat(String.valueOf(localObject)));
      localNetStatGroup.weo.removeAllViews();
      int j = 0;
      if (j < 5)
      {
        localObject = new NetStatUnit(localNetStatGroup.getContext());
        k localk = q.aBQ().oK(m + j);
        long l1;
        long l2;
        long l3;
        if (localk != null)
        {
          if (!bool) {
            break label319;
          }
          ad.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d wifi : %d %d %d %d", new Object[] { Integer.valueOf(localk.hwc), Long.valueOf(localk.hwy), Long.valueOf(localk.hwm), Long.valueOf(localk.hwA), Long.valueOf(localk.hwo) });
          l1 = localk.hwy;
          l2 = localk.hwm;
          l3 = localk.hwA;
          ((NetStatUnit)localObject).ah(l1 + l2, localk.hwo + l3);
        }
        for (;;)
        {
          ((NetStatUnit)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
          localNetStatGroup.weo.addView((View)localObject);
          j += 1;
          break;
          label319:
          ad.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d mobile : %d %d %d %d", new Object[] { Integer.valueOf(localk.hwc), Long.valueOf(localk.hwx), Long.valueOf(localk.hwl), Long.valueOf(localk.hwz), Long.valueOf(localk.hwn) });
          l1 = localk.hwx;
          l2 = localk.hwl;
          l3 = localk.hwz;
          ((NetStatUnit)localObject).ah(l1 + l2, localk.hwn + l3);
        }
      }
      localLinearLayout.addView(localNetStatGroup, -2, -1);
      i -= 5;
    }
    localLinearLayout = (LinearLayout)paramView.findViewById(2131304272);
    localLinearLayout.removeAllViews();
    NetStatGroup localNetStatGroup = new NetStatGroup(this.mContext);
    boolean bool = this.weq;
    localNetStatGroup.removeAllViews();
    View.inflate(localNetStatGroup.getContext(), 2131495008, localNetStatGroup);
    localNetStatGroup.weo = ((LinearLayout)localNetStatGroup.findViewById(2131300621));
    Object localObject = new NetStatRuler(localNetStatGroup.getContext());
    if (bool) {}
    for (paramView = "wifi";; paramView = "mobile")
    {
      ((NetStatRuler)localObject).setTag(paramView);
      ((NetStatRuler)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
      localNetStatGroup.weo.addView((View)localObject);
      localLinearLayout.addView(localNetStatGroup);
      Yb(8);
      AppMethodBeat.o(73897);
      return;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(73896);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494837, localViewGroup);
    AppMethodBeat.o(73896);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.NetStatPreference
 * JD-Core Version:    0.7.0.1
 */