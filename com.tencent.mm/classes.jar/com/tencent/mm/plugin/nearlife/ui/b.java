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
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;

public final class b
  extends a
{
  private boolean AZM;
  private boolean GuH;
  com.tencent.mm.plugin.nearlife.b.b GuO;
  private com.tencent.mm.plugin.nearlife.b.b GuP;
  String GuQ;
  private HashMap<String, Integer> GuR;
  private String lmL;
  
  public b(Context paramContext, View.OnClickListener paramOnClickListener, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, boolean paramBoolean3)
  {
    super(paramContext, paramOnClickListener, paramString1, paramBoolean2);
    AppMethodBeat.i(215151);
    this.GuR = new HashMap();
    this.GuH = true;
    this.AZM = false;
    this.GuP = new com.tencent.mm.plugin.nearlife.b.b("", new cqf());
    this.GuP.GtI = "NotCheckIn";
    this.GuP.fwr = paramContext.getString(R.l.eMm);
    this.GuH = paramBoolean1;
    this.lmL = paramString2;
    this.GuR.put(this.GuP.GtI, Integer.valueOf(2));
    if ((!paramBoolean2) && (paramBoolean1))
    {
      a(this.GuP, 0);
      notifyDataSetChanged();
    }
    this.AZM = paramBoolean3;
    AppMethodBeat.o(215151);
  }
  
  private Spannable aNu(String paramString)
  {
    AppMethodBeat.i(26576);
    paramString = f.b(paramString, this.GtV);
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
      paramView = View.inflate(this.mContext, R.i.ejp, null);
      paramViewGroup.titleTv = ((TextView)paramView.findViewById(R.h.dLh));
      paramViewGroup.DXc = ((TextView)paramView.findViewById(R.h.dLg));
      paramViewGroup.kEs = ((TextView)paramView.findViewById(R.h.dLf));
      paramViewGroup.GuT = ((LinearLayout)paramView.findViewById(R.h.root_content));
      paramViewGroup.GuU = ((WeImageView)paramView.findViewById(R.h.dTC));
      if (this.lmL != null) {
        paramViewGroup.GuU.setIconColor(Color.parseColor(this.lmL));
      }
      paramViewGroup.GuT.setOnClickListener(this.dig);
      paramView.setTag(paramViewGroup);
      localb = aah(paramInt);
      if (!this.GuR.containsKey(localb.GtI)) {
        break label554;
      }
    }
    label264:
    label554:
    for (int i = ((Integer)this.GuR.get(localb.GtI)).intValue();; i = 0)
    {
      paramViewGroup.GuU.setVisibility(8);
      paramViewGroup.type = i;
      paramViewGroup.GuS = localb;
      if ((!Util.isNullOrNil(this.GuQ)) && (this.GuQ.equals(localb.GtI))) {
        paramViewGroup.GuU.setVisibility(0);
      }
      switch (i)
      {
      default: 
        paramViewGroup.position = paramInt;
        paramViewGroup.GtI = localb.GtI;
        if (this.Cem)
        {
          paramViewGroup.titleTv.setText(aNu(localb.fwr));
          paramViewGroup.kEs.setText(aNu(gj(localb.GtN)));
        }
        break;
      }
      for (;;)
      {
        paramViewGroup.DXc.setVisibility(8);
        if (this.AZM)
        {
          paramViewGroup.GuT.setBackground(this.mContext.getDrawable(R.g.mm_listitem_dark_mode));
          paramViewGroup.titleTv.setTextColor(Color.parseColor("#CCFFFFFF"));
          paramViewGroup.kEs.setTextColor(Color.parseColor("#80FFFFFF"));
          paramViewGroup.DXc.setTextColor(Color.parseColor("#CCFFFFFF"));
        }
        AppMethodBeat.o(26575);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(R.e.normal_text_color));
        paramViewGroup.kEs.setVisibility(8);
        break label264;
        paramViewGroup.kEs.setVisibility(8);
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(R.e.sns_link_color));
        if (!Util.isNullOrNil(this.GuQ)) {
          break label264;
        }
        paramViewGroup.GuU.setVisibility(0);
        break label264;
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(R.e.normal_text_color));
        paramViewGroup.kEs.setVisibility(0);
        break label264;
        paramViewGroup.titleTv.setText(localb.fwr);
        paramViewGroup.kEs.setText(gj(localb.GtN));
      }
    }
  }
  
  public final com.tencent.mm.plugin.nearlife.b.b jp(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(26574);
    com.tencent.mm.plugin.nearlife.b.b localb;
    if (this.GuO == null)
    {
      this.GuO = new com.tencent.mm.plugin.nearlife.b.b("", new cqf());
      this.GuO.GtI = "City";
      this.GuR.put(this.GuO.GtI, Integer.valueOf(1));
      localb = this.GuO;
      if (!this.GuH) {
        break label117;
      }
    }
    for (;;)
    {
      a(localb, i);
      this.GuO.fwr = paramString1;
      this.GuO.fIY = paramString2;
      notifyDataSetChanged();
      paramString1 = this.GuO;
      AppMethodBeat.o(26574);
      return paramString1;
      label117:
      i = 0;
    }
  }
  
  final class a
  {
    TextView DXc;
    String GtI;
    com.tencent.mm.plugin.nearlife.b.b GuS;
    LinearLayout GuT;
    WeImageView GuU;
    TextView kEs;
    int position;
    TextView titleTv;
    int type;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.b
 * JD-Core Version:    0.7.0.1
 */