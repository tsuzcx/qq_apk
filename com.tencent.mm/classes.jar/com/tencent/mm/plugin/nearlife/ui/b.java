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
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;

public final class b
  extends a
{
  private String hiu;
  com.tencent.mm.plugin.nearlife.b.b vlB;
  private com.tencent.mm.plugin.nearlife.b.b vlC;
  String vlD;
  private HashMap<String, Integer> vlE;
  private boolean vlu;
  
  public b(Context paramContext, View.OnClickListener paramOnClickListener, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    super(paramContext, paramOnClickListener, paramString1, paramBoolean2);
    AppMethodBeat.i(26573);
    this.vlE = new HashMap();
    this.vlu = true;
    this.vlC = new com.tencent.mm.plugin.nearlife.b.b("", new boy());
    this.vlC.vku = "NotCheckIn";
    this.vlC.Title = paramContext.getString(2131761490);
    this.vlu = paramBoolean1;
    this.hiu = paramString2;
    this.vlE.put(this.vlC.vku, Integer.valueOf(2));
    if ((!paramBoolean2) && (paramBoolean1))
    {
      a(this.vlC, 0);
      notifyDataSetChanged();
    }
    AppMethodBeat.o(26573);
  }
  
  private Spannable ajZ(String paramString)
  {
    AppMethodBeat.i(26576);
    paramString = f.b(paramString, this.vkH);
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
      paramViewGroup.tPZ = ((TextView)paramView.findViewById(2131301406));
      paramViewGroup.gAI = ((TextView)paramView.findViewById(2131301405));
      paramViewGroup.vlG = ((LinearLayout)paramView.findViewById(2131304242));
      paramViewGroup.vlH = ((WeImageView)paramView.findViewById(2131304519));
      if (this.hiu != null) {
        paramViewGroup.vlH.setIconColor(Color.parseColor(this.hiu));
      }
      paramViewGroup.vlG.setOnClickListener(this.cBW);
      paramView.setTag(paramViewGroup);
      localb = Kh(paramInt);
      if (!this.vlE.containsKey(localb.vku)) {
        break label480;
      }
    }
    label256:
    label480:
    for (int i = ((Integer)this.vlE.get(localb.vku)).intValue();; i = 0)
    {
      paramViewGroup.vlH.setVisibility(8);
      paramViewGroup.type = i;
      paramViewGroup.vlF = localb;
      if ((!bs.isNullOrNil(this.vlD)) && (this.vlD.equals(localb.vku))) {
        paramViewGroup.vlH.setVisibility(0);
      }
      switch (i)
      {
      default: 
        paramViewGroup.position = paramInt;
        paramViewGroup.vku = localb.vku;
        if (this.sTi)
        {
          paramViewGroup.titleTv.setText(ajZ(localb.Title));
          paramViewGroup.gAI.setText(ajZ(en(localb.vkz)));
        }
        break;
      }
      for (;;)
      {
        paramViewGroup.tPZ.setVisibility(8);
        AppMethodBeat.o(26575);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100711));
        paramViewGroup.gAI.setVisibility(8);
        break label256;
        paramViewGroup.gAI.setVisibility(8);
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100914));
        if (!bs.isNullOrNil(this.vlD)) {
          break label256;
        }
        paramViewGroup.vlH.setVisibility(0);
        break label256;
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100711));
        paramViewGroup.gAI.setVisibility(0);
        break label256;
        paramViewGroup.titleTv.setText(localb.Title);
        paramViewGroup.gAI.setText(en(localb.vkz));
      }
    }
  }
  
  public final com.tencent.mm.plugin.nearlife.b.b ib(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(26574);
    com.tencent.mm.plugin.nearlife.b.b localb;
    if (this.vlB == null)
    {
      this.vlB = new com.tencent.mm.plugin.nearlife.b.b("", new boy());
      this.vlB.vku = "City";
      this.vlE.put(this.vlB.vku, Integer.valueOf(1));
      localb = this.vlB;
      if (!this.vlu) {
        break label116;
      }
    }
    for (;;)
    {
      a(localb, i);
      this.vlB.Title = paramString1;
      this.vlB.dlj = paramString2;
      notifyDataSetChanged();
      paramString1 = this.vlB;
      AppMethodBeat.o(26574);
      return paramString1;
      label116:
      i = 0;
    }
  }
  
  final class a
  {
    TextView gAI;
    int position;
    TextView tPZ;
    TextView titleTv;
    int type;
    String vku;
    com.tencent.mm.plugin.nearlife.b.b vlF;
    LinearLayout vlG;
    WeImageView vlH;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.b
 * JD-Core Version:    0.7.0.1
 */