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
import com.tencent.mm.modelstat.j;
import com.tencent.mm.modelstat.l;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;

public class NetStatPreference
  extends Preference
{
  boolean JeM;
  
  public NetStatPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NetStatPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(73895);
    this.JeM = false;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.j.NetStatPreference, paramInt, 0);
    if (paramAttributeSet.getInt(b.j.NetStatPreference_srcType, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.JeM = bool;
      paramAttributeSet.recycle();
      aF(paramContext.getString(b.i.settings_netstat_statistic_period, new Object[] { Integer.valueOf(15) }));
      AppMethodBeat.o(73895);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(73897);
    super.onBindView(paramView);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(b.f.group);
    localLinearLayout.removeAllViews();
    int k = (int)(System.currentTimeMillis() / 86400000L);
    int i = 15;
    while (i > 0)
    {
      localNetStatGroup = new NetStatGroup(this.mContext);
      int m = k - i + 1;
      bool = this.JeM;
      localObject = DateFormat.format(localNetStatGroup.getContext().getString(b.i.fmt_date, new Object[] { "" }), m * 86400000L).toString();
      localNetStatGroup.JeL.setText((CharSequence)localObject);
      Log.d("MicroMsg.NetStatGroup", "NetStat dataTime = ".concat(String.valueOf(localObject)));
      localNetStatGroup.JeK.removeAllViews();
      int j = 0;
      if (j < 5)
      {
        localObject = new NetStatUnit(localNetStatGroup.getContext());
        j localj = p.bpD().wT(m + j);
        long l1;
        long l2;
        long l3;
        if (localj != null)
        {
          if (!bool) {
            break label321;
          }
          Log.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d wifi : %d %d %d %d", new Object[] { Integer.valueOf(localj.mdv), Long.valueOf(localj.mdR), Long.valueOf(localj.mdF), Long.valueOf(localj.mdT), Long.valueOf(localj.mdH) });
          l1 = localj.mdR;
          l2 = localj.mdF;
          l3 = localj.mdT;
          ((NetStatUnit)localObject).au(l1 + l2, localj.mdH + l3);
        }
        for (;;)
        {
          ((NetStatUnit)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
          localNetStatGroup.JeK.addView((View)localObject);
          j += 1;
          break;
          label321:
          Log.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d mobile : %d %d %d %d", new Object[] { Integer.valueOf(localj.mdv), Long.valueOf(localj.mdQ), Long.valueOf(localj.mdE), Long.valueOf(localj.mdS), Long.valueOf(localj.mdG) });
          l1 = localj.mdQ;
          l2 = localj.mdE;
          l3 = localj.mdS;
          ((NetStatUnit)localObject).au(l1 + l2, localj.mdG + l3);
        }
      }
      localLinearLayout.addView(localNetStatGroup, -2, -1);
      i -= 5;
    }
    localLinearLayout = (LinearLayout)paramView.findViewById(b.f.ruler);
    localLinearLayout.removeAllViews();
    NetStatGroup localNetStatGroup = new NetStatGroup(this.mContext);
    boolean bool = this.JeM;
    localNetStatGroup.removeAllViews();
    View.inflate(localNetStatGroup.getContext(), b.g.netstat_ruler, localNetStatGroup);
    localNetStatGroup.JeK = ((LinearLayout)localNetStatGroup.findViewById(b.f.group));
    Object localObject = new NetStatRuler(localNetStatGroup.getContext());
    if (bool) {}
    for (paramView = "wifi";; paramView = "mobile")
    {
      ((NetStatRuler)localObject).setTag(paramView);
      ((NetStatRuler)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
      localNetStatGroup.JeK.addView((View)localObject);
      localLinearLayout.addView(localNetStatGroup);
      auO(8);
      AppMethodBeat.o(73897);
      return;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(73896);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(b.f.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, b.g.mm_preference_content_netstat, localViewGroup);
    AppMethodBeat.o(73896);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.NetStatPreference
 * JD-Core Version:    0.7.0.1
 */