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
  boolean yEh;
  
  public NetStatPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NetStatPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(73895);
    this.yEh = false;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.NetStatPreference, paramInt, 0);
    if (paramAttributeSet.getInt(0, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.yEh = bool;
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
      bool = this.yEh;
      localObject = DateFormat.format(localNetStatGroup.getContext().getString(2131759498, new Object[] { "" }), m * 86400000L).toString();
      localNetStatGroup.yEg.setText((CharSequence)localObject);
      ad.d("MicroMsg.NetStatGroup", "NetStat dataTime = ".concat(String.valueOf(localObject)));
      localNetStatGroup.yEf.removeAllViews();
      int j = 0;
      if (j < 5)
      {
        localObject = new NetStatUnit(localNetStatGroup.getContext());
        k localk = q.aLQ().qb(m + j);
        long l1;
        long l2;
        long l3;
        if (localk != null)
        {
          if (!bool) {
            break label319;
          }
          ad.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d wifi : %d %d %d %d", new Object[] { Integer.valueOf(localk.ipY), Long.valueOf(localk.iqu), Long.valueOf(localk.iqi), Long.valueOf(localk.iqw), Long.valueOf(localk.iqk) });
          l1 = localk.iqu;
          l2 = localk.iqi;
          l3 = localk.iqw;
          ((NetStatUnit)localObject).ah(l1 + l2, localk.iqk + l3);
        }
        for (;;)
        {
          ((NetStatUnit)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
          localNetStatGroup.yEf.addView((View)localObject);
          j += 1;
          break;
          label319:
          ad.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d mobile : %d %d %d %d", new Object[] { Integer.valueOf(localk.ipY), Long.valueOf(localk.iqt), Long.valueOf(localk.iqh), Long.valueOf(localk.iqv), Long.valueOf(localk.iqj) });
          l1 = localk.iqt;
          l2 = localk.iqh;
          l3 = localk.iqv;
          ((NetStatUnit)localObject).ah(l1 + l2, localk.iqj + l3);
        }
      }
      localLinearLayout.addView(localNetStatGroup, -2, -1);
      i -= 5;
    }
    localLinearLayout = (LinearLayout)paramView.findViewById(2131304272);
    localLinearLayout.removeAllViews();
    NetStatGroup localNetStatGroup = new NetStatGroup(this.mContext);
    boolean bool = this.yEh;
    localNetStatGroup.removeAllViews();
    View.inflate(localNetStatGroup.getContext(), 2131495008, localNetStatGroup);
    localNetStatGroup.yEf = ((LinearLayout)localNetStatGroup.findViewById(2131300621));
    Object localObject = new NetStatRuler(localNetStatGroup.getContext());
    if (bool) {}
    for (paramView = "wifi";; paramView = "mobile")
    {
      ((NetStatRuler)localObject).setTag(paramView);
      ((NetStatRuler)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
      localNetStatGroup.yEf.addView((View)localObject);
      localLinearLayout.addView(localNetStatGroup);
      acw(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.NetStatPreference
 * JD-Core Version:    0.7.0.1
 */