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
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;

public final class b
  extends a
{
  private String gHT;
  com.tencent.mm.plugin.nearlife.b.b ucC;
  private com.tencent.mm.plugin.nearlife.b.b ucD;
  String ucE;
  private HashMap<String, Integer> ucF;
  private boolean ucv;
  
  public b(Context paramContext, View.OnClickListener paramOnClickListener, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    super(paramContext, paramOnClickListener, paramString1, paramBoolean2);
    AppMethodBeat.i(26573);
    this.ucF = new HashMap();
    this.ucv = true;
    this.ucD = new com.tencent.mm.plugin.nearlife.b.b("", new blc());
    this.ucD.ubw = "NotCheckIn";
    this.ucD.Title = paramContext.getString(2131761490);
    this.ucv = paramBoolean1;
    this.gHT = paramString2;
    this.ucF.put(this.ucD.ubw, Integer.valueOf(2));
    if ((!paramBoolean2) && (paramBoolean1))
    {
      a(this.ucD, 0);
      notifyDataSetChanged();
    }
    AppMethodBeat.o(26573);
  }
  
  private Spannable aff(String paramString)
  {
    AppMethodBeat.i(26576);
    paramString = f.a(paramString, this.ubJ);
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
      paramViewGroup.sIs = ((TextView)paramView.findViewById(2131301406));
      paramViewGroup.lEA = ((TextView)paramView.findViewById(2131301405));
      paramViewGroup.ucH = ((LinearLayout)paramView.findViewById(2131304242));
      paramViewGroup.ucI = ((WeImageView)paramView.findViewById(2131304519));
      if (this.gHT != null) {
        paramViewGroup.ucI.setIconColor(Color.parseColor(this.gHT));
      }
      paramViewGroup.ucH.setOnClickListener(this.cEO);
      paramView.setTag(paramViewGroup);
      localb = Ii(paramInt);
      if (!this.ucF.containsKey(localb.ubw)) {
        break label480;
      }
    }
    label256:
    label480:
    for (int i = ((Integer)this.ucF.get(localb.ubw)).intValue();; i = 0)
    {
      paramViewGroup.ucI.setVisibility(8);
      paramViewGroup.type = i;
      paramViewGroup.ucG = localb;
      if ((!bt.isNullOrNil(this.ucE)) && (this.ucE.equals(localb.ubw))) {
        paramViewGroup.ucI.setVisibility(0);
      }
      switch (i)
      {
      default: 
        paramViewGroup.position = paramInt;
        paramViewGroup.ubw = localb.ubw;
        if (this.rLt)
        {
          paramViewGroup.titleTv.setText(aff(localb.Title));
          paramViewGroup.lEA.setText(aff(ej(localb.ubB)));
        }
        break;
      }
      for (;;)
      {
        paramViewGroup.sIs.setVisibility(8);
        AppMethodBeat.o(26575);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100711));
        paramViewGroup.lEA.setVisibility(8);
        break label256;
        paramViewGroup.lEA.setVisibility(8);
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100914));
        if (!bt.isNullOrNil(this.ucE)) {
          break label256;
        }
        paramViewGroup.ucI.setVisibility(0);
        break label256;
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100711));
        paramViewGroup.lEA.setVisibility(0);
        break label256;
        paramViewGroup.titleTv.setText(localb.Title);
        paramViewGroup.lEA.setText(ej(localb.ubB));
      }
    }
  }
  
  public final com.tencent.mm.plugin.nearlife.b.b hI(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(26574);
    com.tencent.mm.plugin.nearlife.b.b localb;
    if (this.ucC == null)
    {
      this.ucC = new com.tencent.mm.plugin.nearlife.b.b("", new blc());
      this.ucC.ubw = "City";
      this.ucF.put(this.ucC.ubw, Integer.valueOf(1));
      localb = this.ucC;
      if (!this.ucv) {
        break label116;
      }
    }
    for (;;)
    {
      a(localb, i);
      this.ucC.Title = paramString1;
      this.ucC.dnB = paramString2;
      notifyDataSetChanged();
      paramString1 = this.ucC;
      AppMethodBeat.o(26574);
      return paramString1;
      label116:
      i = 0;
    }
  }
  
  final class a
  {
    TextView lEA;
    int position;
    TextView sIs;
    TextView titleTv;
    int type;
    String ubw;
    com.tencent.mm.plugin.nearlife.b.b ucG;
    LinearLayout ucH;
    WeImageView ucI;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.b
 * JD-Core Version:    0.7.0.1
 */