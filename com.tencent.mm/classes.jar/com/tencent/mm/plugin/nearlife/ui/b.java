package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;

public final class b
  extends a
{
  private String hAD;
  private boolean wqM;
  com.tencent.mm.plugin.nearlife.b.b wqT;
  private com.tencent.mm.plugin.nearlife.b.b wqU;
  String wqV;
  private HashMap<String, Integer> wqW;
  
  public b(Context paramContext, View.OnClickListener paramOnClickListener, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    super(paramContext, paramOnClickListener, paramString1, paramBoolean2);
    AppMethodBeat.i(26573);
    this.wqW = new HashMap();
    this.wqM = true;
    this.wqU = new com.tencent.mm.plugin.nearlife.b.b("", new btl());
    this.wqU.wpM = "NotCheckIn";
    this.wqU.Title = paramContext.getString(2131761490);
    this.wqM = paramBoolean1;
    this.hAD = paramString2;
    this.wqW.put(this.wqU.wpM, Integer.valueOf(2));
    if ((!paramBoolean2) && (paramBoolean1))
    {
      a(this.wqU, 0);
      notifyDataSetChanged();
    }
    AppMethodBeat.o(26573);
  }
  
  private Spannable aoM(String paramString)
  {
    AppMethodBeat.i(26576);
    paramString = f.b(paramString, this.wpZ);
    AppMethodBeat.o(26576);
    return paramString;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(26575);
    com.tencent.mm.plugin.nearlife.b.b localb;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = View.inflate(this.mContext, 2131494997, null);
      paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131301407));
      paramViewGroup.uSM = ((TextView)paramView.findViewById(2131301406));
      paramViewGroup.gUs = ((TextView)paramView.findViewById(2131301405));
      paramViewGroup.wqY = ((LinearLayout)paramView.findViewById(2131304242));
      paramViewGroup.wqZ = ((WeImageView)paramView.findViewById(2131304519));
      if (this.hAD != null) {
        paramViewGroup.wqZ.setIconColor(Color.parseColor(this.hAD));
      }
      paramViewGroup.wqY.setOnClickListener(this.cMV);
      paramView.setTag(paramViewGroup);
      localb = LJ(paramInt);
      if (!this.wqW.containsKey(localb.wpM)) {
        break label480;
      }
    }
    label256:
    label480:
    for (int i = ((Integer)this.wqW.get(localb.wpM)).intValue();; i = 0)
    {
      paramViewGroup.wqZ.setVisibility(8);
      paramViewGroup.type = i;
      paramViewGroup.wqX = localb;
      if ((!bt.isNullOrNil(this.wqV)) && (this.wqV.equals(localb.wpM))) {
        paramViewGroup.wqZ.setVisibility(0);
      }
      switch (i)
      {
      default: 
        paramViewGroup.position = paramInt;
        paramViewGroup.wpM = localb.wpM;
        if (this.tPM)
        {
          paramViewGroup.titleTv.setText(aoM(localb.Title));
          paramViewGroup.gUs.setText(aoM(eA(localb.wpR)));
        }
        break;
      }
      for (;;)
      {
        paramViewGroup.uSM.setVisibility(8);
        AppMethodBeat.o(26575);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100711));
        paramViewGroup.gUs.setVisibility(8);
        break label256;
        paramViewGroup.gUs.setVisibility(8);
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100914));
        if (!bt.isNullOrNil(this.wqV)) {
          break label256;
        }
        paramViewGroup.wqZ.setVisibility(0);
        break label256;
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100711));
        paramViewGroup.gUs.setVisibility(0);
        break label256;
        paramViewGroup.titleTv.setText(localb.Title);
        paramViewGroup.gUs.setText(eA(localb.wpR));
      }
    }
  }
  
  public final com.tencent.mm.plugin.nearlife.b.b im(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(26574);
    com.tencent.mm.plugin.nearlife.b.b localb;
    if (this.wqT == null)
    {
      this.wqT = new com.tencent.mm.plugin.nearlife.b.b("", new btl());
      this.wqT.wpM = "City";
      this.wqW.put(this.wqT.wpM, Integer.valueOf(1));
      localb = this.wqT;
      if (!this.wqM) {
        break label116;
      }
    }
    for (;;)
    {
      a(localb, i);
      this.wqT.Title = paramString1;
      this.wqT.dwW = paramString2;
      notifyDataSetChanged();
      paramString1 = this.wqT;
      AppMethodBeat.o(26574);
      return paramString1;
      label116:
      i = 0;
    }
  }
  
  final class a
  {
    TextView gUs;
    int position;
    TextView titleTv;
    int type;
    TextView uSM;
    String wpM;
    com.tencent.mm.plugin.nearlife.b.b wqX;
    LinearLayout wqY;
    WeImageView wqZ;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.b
 * JD-Core Version:    0.7.0.1
 */