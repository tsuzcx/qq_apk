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
import com.tencent.mm.protocal.protobuf.buf;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;

public final class b
  extends a
{
  private String hDr;
  com.tencent.mm.plugin.nearlife.b.b wGC;
  private com.tencent.mm.plugin.nearlife.b.b wGD;
  String wGE;
  private HashMap<String, Integer> wGF;
  private boolean wGv;
  
  public b(Context paramContext, View.OnClickListener paramOnClickListener, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    super(paramContext, paramOnClickListener, paramString1, paramBoolean2);
    AppMethodBeat.i(26573);
    this.wGF = new HashMap();
    this.wGv = true;
    this.wGD = new com.tencent.mm.plugin.nearlife.b.b("", new buf());
    this.wGD.wFv = "NotCheckIn";
    this.wGD.Title = paramContext.getString(2131761490);
    this.wGv = paramBoolean1;
    this.hDr = paramString2;
    this.wGF.put(this.wGD.wFv, Integer.valueOf(2));
    if ((!paramBoolean2) && (paramBoolean1))
    {
      a(this.wGD, 0);
      notifyDataSetChanged();
    }
    AppMethodBeat.o(26573);
  }
  
  private Spannable apR(String paramString)
  {
    AppMethodBeat.i(26576);
    paramString = f.b(paramString, this.wFI);
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
      paramViewGroup.vez = ((TextView)paramView.findViewById(2131301406));
      paramViewGroup.gXb = ((TextView)paramView.findViewById(2131301405));
      paramViewGroup.wGH = ((LinearLayout)paramView.findViewById(2131304242));
      paramViewGroup.wGI = ((WeImageView)paramView.findViewById(2131304519));
      if (this.hDr != null) {
        paramViewGroup.wGI.setIconColor(Color.parseColor(this.hDr));
      }
      paramViewGroup.wGH.setOnClickListener(this.cNE);
      paramView.setTag(paramViewGroup);
      localb = Mo(paramInt);
      if (!this.wGF.containsKey(localb.wFv)) {
        break label480;
      }
    }
    label256:
    label480:
    for (int i = ((Integer)this.wGF.get(localb.wFv)).intValue();; i = 0)
    {
      paramViewGroup.wGI.setVisibility(8);
      paramViewGroup.type = i;
      paramViewGroup.wGG = localb;
      if ((!bu.isNullOrNil(this.wGE)) && (this.wGE.equals(localb.wFv))) {
        paramViewGroup.wGI.setVisibility(0);
      }
      switch (i)
      {
      default: 
        paramViewGroup.position = paramInt;
        paramViewGroup.wFv = localb.wFv;
        if (this.uaD)
        {
          paramViewGroup.titleTv.setText(apR(localb.Title));
          paramViewGroup.gXb.setText(apR(eH(localb.wFA)));
        }
        break;
      }
      for (;;)
      {
        paramViewGroup.vez.setVisibility(8);
        AppMethodBeat.o(26575);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100711));
        paramViewGroup.gXb.setVisibility(8);
        break label256;
        paramViewGroup.gXb.setVisibility(8);
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100914));
        if (!bu.isNullOrNil(this.wGE)) {
          break label256;
        }
        paramViewGroup.wGI.setVisibility(0);
        break label256;
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100711));
        paramViewGroup.gXb.setVisibility(0);
        break label256;
        paramViewGroup.titleTv.setText(localb.Title);
        paramViewGroup.gXb.setText(eH(localb.wFA));
      }
    }
  }
  
  public final com.tencent.mm.plugin.nearlife.b.b is(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(26574);
    com.tencent.mm.plugin.nearlife.b.b localb;
    if (this.wGC == null)
    {
      this.wGC = new com.tencent.mm.plugin.nearlife.b.b("", new buf());
      this.wGC.wFv = "City";
      this.wGF.put(this.wGC.wFv, Integer.valueOf(1));
      localb = this.wGC;
      if (!this.wGv) {
        break label116;
      }
    }
    for (;;)
    {
      a(localb, i);
      this.wGC.Title = paramString1;
      this.wGC.dyb = paramString2;
      notifyDataSetChanged();
      paramString1 = this.wGC;
      AppMethodBeat.o(26574);
      return paramString1;
      label116:
      i = 0;
    }
  }
  
  final class a
  {
    TextView gXb;
    int position;
    TextView titleTv;
    int type;
    TextView vez;
    String wFv;
    com.tencent.mm.plugin.nearlife.b.b wGG;
    LinearLayout wGH;
    WeImageView wGI;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.b
 * JD-Core Version:    0.7.0.1
 */