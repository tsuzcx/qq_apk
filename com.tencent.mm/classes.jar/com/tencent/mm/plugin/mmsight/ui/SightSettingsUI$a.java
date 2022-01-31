package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;

final class SightSettingsUI$a
  extends BaseAdapter
{
  SightSettingsUI$a(SightSettingsUI paramSightSettingsUI) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(55282);
    int i = SightSettingsUI.d(this.oQB).size();
    AppMethodBeat.o(55282);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(55283);
    Object localObject = SightSettingsUI.d(this.oQB).get(paramInt);
    AppMethodBeat.o(55283);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(55284);
    paramView = new TextView(this.oQB);
    paramViewGroup = (SightSettingsUI.b)getItem(paramInt);
    paramView.setText(paramViewGroup.oQE + "->:" + paramViewGroup.zC(((Integer)SightSettingsUI.b(paramViewGroup.oQB).get(paramViewGroup.oQH, Integer.valueOf(0))).intValue()));
    paramView.setGravity(17);
    paramView.setTextSize(1, 20.0F);
    paramView.setHeight(a.fromDPToPix(ah.getContext(), 50));
    if (paramInt % 2 == 1) {
      paramView.setBackgroundColor(Color.parseColor("#e2efda"));
    }
    paramView.setOnClickListener(new SightSettingsUI.a.1(this, paramViewGroup));
    AppMethodBeat.o(55284);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightSettingsUI.a
 * JD-Core Version:    0.7.0.1
 */