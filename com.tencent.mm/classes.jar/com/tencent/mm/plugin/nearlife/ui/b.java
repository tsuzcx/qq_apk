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
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;

public final class b
  extends a
{
  private boolean ABF;
  com.tencent.mm.plugin.nearlife.b.b ABM;
  private com.tencent.mm.plugin.nearlife.b.b ABN;
  String ABO;
  private HashMap<String, Integer> ABP;
  private String ixw;
  
  public b(Context paramContext, View.OnClickListener paramOnClickListener, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    super(paramContext, paramOnClickListener, paramString1, paramBoolean2);
    AppMethodBeat.i(26573);
    this.ABP = new HashMap();
    this.ABF = true;
    this.ABN = new com.tencent.mm.plugin.nearlife.b.b("", new chj());
    this.ABN.AAG = "NotCheckIn";
    this.ABN.Title = paramContext.getString(2131763432);
    this.ABF = paramBoolean1;
    this.ixw = paramString2;
    this.ABP.put(this.ABN.AAG, Integer.valueOf(2));
    if ((!paramBoolean2) && (paramBoolean1))
    {
      a(this.ABN, 0);
      notifyDataSetChanged();
    }
    AppMethodBeat.o(26573);
  }
  
  private Spannable aDk(String paramString)
  {
    AppMethodBeat.i(26576);
    paramString = f.b(paramString, this.AAT);
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
      paramView = View.inflate(this.mContext, 2131495810, null);
      paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131303166));
      paramViewGroup.ywY = ((TextView)paramView.findViewById(2131303165));
      paramViewGroup.hPW = ((TextView)paramView.findViewById(2131303164));
      paramViewGroup.ABR = ((LinearLayout)paramView.findViewById(2131307161));
      paramViewGroup.ABS = ((WeImageView)paramView.findViewById(2131307534));
      if (this.ixw != null) {
        paramViewGroup.ABS.setIconColor(Color.parseColor(this.ixw));
      }
      paramViewGroup.ABR.setOnClickListener(this.dec);
      paramView.setTag(paramViewGroup);
      localb = Tv(paramInt);
      if (!this.ABP.containsKey(localb.AAG)) {
        break label480;
      }
    }
    label256:
    label480:
    for (int i = ((Integer)this.ABP.get(localb.AAG)).intValue();; i = 0)
    {
      paramViewGroup.ABS.setVisibility(8);
      paramViewGroup.type = i;
      paramViewGroup.ABQ = localb;
      if ((!Util.isNullOrNil(this.ABO)) && (this.ABO.equals(localb.AAG))) {
        paramViewGroup.ABS.setVisibility(0);
      }
      switch (i)
      {
      default: 
        paramViewGroup.position = paramInt;
        paramViewGroup.AAG = localb.AAG;
        if (this.xrR)
        {
          paramViewGroup.titleTv.setText(aDk(localb.Title));
          paramViewGroup.hPW.setText(aDk(fF(localb.AAL)));
        }
        break;
      }
      for (;;)
      {
        paramViewGroup.ywY.setVisibility(8);
        AppMethodBeat.o(26575);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100904));
        paramViewGroup.hPW.setVisibility(8);
        break label256;
        paramViewGroup.hPW.setVisibility(8);
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131101131));
        if (!Util.isNullOrNil(this.ABO)) {
          break label256;
        }
        paramViewGroup.ABS.setVisibility(0);
        break label256;
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100904));
        paramViewGroup.hPW.setVisibility(0);
        break label256;
        paramViewGroup.titleTv.setText(localb.Title);
        paramViewGroup.hPW.setText(fF(localb.AAL));
      }
    }
  }
  
  public final com.tencent.mm.plugin.nearlife.b.b jd(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(26574);
    com.tencent.mm.plugin.nearlife.b.b localb;
    if (this.ABM == null)
    {
      this.ABM = new com.tencent.mm.plugin.nearlife.b.b("", new chj());
      this.ABM.AAG = "City";
      this.ABP.put(this.ABM.AAG, Integer.valueOf(1));
      localb = this.ABM;
      if (!this.ABF) {
        break label116;
      }
    }
    for (;;)
    {
      a(localb, i);
      this.ABM.Title = paramString1;
      this.ABM.dPI = paramString2;
      notifyDataSetChanged();
      paramString1 = this.ABM;
      AppMethodBeat.o(26574);
      return paramString1;
      label116:
      i = 0;
    }
  }
  
  final class a
  {
    String AAG;
    com.tencent.mm.plugin.nearlife.b.b ABQ;
    LinearLayout ABR;
    WeImageView ABS;
    TextView hPW;
    int position;
    TextView titleTv;
    int type;
    TextView ywY;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.b
 * JD-Core Version:    0.7.0.1
 */