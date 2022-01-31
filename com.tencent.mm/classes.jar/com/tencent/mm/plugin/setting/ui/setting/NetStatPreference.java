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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.Preference;

public class NetStatPreference
  extends Preference
{
  boolean qFW;
  
  public NetStatPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NetStatPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(126966);
    this.qFW = false;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.NetStatPreference, paramInt, 0);
    if (paramAttributeSet.getInt(0, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.qFW = bool;
      paramAttributeSet.recycle();
      setSummary(paramContext.getString(2131303340, new Object[] { Integer.valueOf(15) }));
      AppMethodBeat.o(126966);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(126968);
    super.onBindView(paramView);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131826210);
    localLinearLayout.removeAllViews();
    int k = (int)(System.currentTimeMillis() / 86400000L);
    int i = 15;
    while (i > 0)
    {
      localNetStatGroup = new NetStatGroup(this.mContext);
      int m = k - i + 1;
      bool = this.qFW;
      localObject = DateFormat.format(localNetStatGroup.getContext().getString(2131300031, new Object[] { "" }), m * 86400000L).toString();
      localNetStatGroup.qFV.setText((CharSequence)localObject);
      ab.d("MicroMsg.NetStatGroup", "NetStat dataTime = ".concat(String.valueOf(localObject)));
      localNetStatGroup.qFU.removeAllViews();
      int j = 0;
      if (j < 5)
      {
        localObject = new NetStatUnit(localNetStatGroup.getContext());
        k localk = q.akL().mb(m + j);
        int n;
        int i1;
        int i2;
        if (localk != null)
        {
          if (!bool) {
            break label319;
          }
          ab.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d wifi : %d %d %d %d", new Object[] { Integer.valueOf(localk.fTt), Integer.valueOf(localk.fTP), Integer.valueOf(localk.fTD), Integer.valueOf(localk.fTR), Integer.valueOf(localk.fTF) });
          n = localk.fTP;
          i1 = localk.fTD;
          i2 = localk.fTR;
          ((NetStatUnit)localObject).fr(n + i1, localk.fTF + i2);
        }
        for (;;)
        {
          ((NetStatUnit)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
          localNetStatGroup.qFU.addView((View)localObject);
          j += 1;
          break;
          label319:
          ab.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d mobile : %d %d %d %d", new Object[] { Integer.valueOf(localk.fTt), Integer.valueOf(localk.fTO), Integer.valueOf(localk.fTC), Integer.valueOf(localk.fTQ), Integer.valueOf(localk.fTE) });
          n = localk.fTO;
          i1 = localk.fTC;
          i2 = localk.fTQ;
          ((NetStatUnit)localObject).fr(n + i1, localk.fTE + i2);
        }
      }
      localLinearLayout.addView(localNetStatGroup, -2, -1);
      i -= 5;
    }
    localLinearLayout = (LinearLayout)paramView.findViewById(2131826225);
    localLinearLayout.removeAllViews();
    NetStatGroup localNetStatGroup = new NetStatGroup(this.mContext);
    boolean bool = this.qFW;
    localNetStatGroup.removeAllViews();
    View.inflate(localNetStatGroup.getContext(), 2130970351, localNetStatGroup);
    localNetStatGroup.qFU = ((LinearLayout)localNetStatGroup.findViewById(2131826210));
    Object localObject = new NetStatRuler(localNetStatGroup.getContext());
    if (bool) {}
    for (paramView = "wifi";; paramView = "mobile")
    {
      ((NetStatRuler)localObject).setTag(paramView);
      ((NetStatRuler)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
      localNetStatGroup.qFU.addView((View)localObject);
      localLinearLayout.addView(localNetStatGroup);
      OW(8);
      AppMethodBeat.o(126968);
      return;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(126967);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2130970210, localViewGroup);
    AppMethodBeat.o(126967);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.NetStatPreference
 * JD-Core Version:    0.7.0.1
 */