package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

final class SightSettingsUI$a
  extends BaseAdapter
{
  SightSettingsUI$a(SightSettingsUI paramSightSettingsUI) {}
  
  public final int getCount()
  {
    return SightSettingsUI.d(this.mqM).size();
  }
  
  public final Object getItem(int paramInt)
  {
    return SightSettingsUI.d(this.mqM).get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = new TextView(this.mqM);
    paramViewGroup = (SightSettingsUI.b)getItem(paramInt);
    paramView.setText(paramViewGroup.mqP + "->:" + paramViewGroup.ul(((Integer)SightSettingsUI.b(paramViewGroup.mqM).get(paramViewGroup.mqS, Integer.valueOf(0))).intValue()));
    paramView.setGravity(17);
    paramView.setTextSize(1, 20.0F);
    paramView.setHeight(a.fromDPToPix(ae.getContext(), 50));
    if (paramInt % 2 == 1) {
      paramView.setBackgroundColor(Color.parseColor("#e2efda"));
    }
    paramView.setOnClickListener(new SightSettingsUI.a.1(this, paramViewGroup));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightSettingsUI.a
 * JD-Core Version:    0.7.0.1
 */