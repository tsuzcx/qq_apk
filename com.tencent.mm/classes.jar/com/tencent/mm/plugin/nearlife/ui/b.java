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
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;

public final class b
  extends a
{
  private boolean FyH;
  private boolean MqG;
  com.tencent.mm.plugin.nearlife.b.b MqN;
  private com.tencent.mm.plugin.nearlife.b.b MqO;
  String MqP;
  private HashMap<String, Integer> MqQ;
  private String nRQ;
  
  public b(Context paramContext, View.OnClickListener paramOnClickListener, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, boolean paramBoolean3)
  {
    super(paramContext, paramOnClickListener, paramString1, paramBoolean2);
    AppMethodBeat.i(267279);
    this.MqQ = new HashMap();
    this.MqG = true;
    this.FyH = false;
    this.MqO = new com.tencent.mm.plugin.nearlife.b.b("", new dgz());
    this.MqO.MpI = "NotCheckIn";
    this.MqO.hAP = paramContext.getString(R.l.gOk);
    this.MqG = paramBoolean1;
    this.nRQ = paramString2;
    this.MqQ.put(this.MqO.MpI, Integer.valueOf(2));
    if ((!paramBoolean2) && (paramBoolean1))
    {
      a(this.MqO, 0);
      notifyDataSetChanged();
    }
    this.FyH = paramBoolean3;
    AppMethodBeat.o(267279);
  }
  
  private Spannable aKp(String paramString)
  {
    AppMethodBeat.i(26576);
    paramString = f.b(paramString, this.MpV);
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
      paramView = View.inflate(this.mContext, R.i.gmq, null);
      paramViewGroup.titleTv = ((TextView)paramView.findViewById(R.h.fMM));
      paramViewGroup.JOl = ((TextView)paramView.findViewById(R.h.fML));
      paramViewGroup.descTv = ((TextView)paramView.findViewById(R.h.fMK));
      paramViewGroup.MqS = ((LinearLayout)paramView.findViewById(R.h.root_content));
      paramViewGroup.MqT = ((WeImageView)paramView.findViewById(R.h.fVK));
      if (this.nRQ != null) {
        paramViewGroup.MqT.setIconColor(Color.parseColor(this.nRQ));
      }
      paramViewGroup.MqS.setOnClickListener(this.fhU);
      paramView.setTag(paramViewGroup);
      localb = aeA(paramInt);
      if (!this.MqQ.containsKey(localb.MpI)) {
        break label554;
      }
    }
    label264:
    label554:
    for (int i = ((Integer)this.MqQ.get(localb.MpI)).intValue();; i = 0)
    {
      paramViewGroup.MqT.setVisibility(8);
      paramViewGroup.type = i;
      paramViewGroup.MqR = localb;
      if ((!Util.isNullOrNil(this.MqP)) && (this.MqP.equals(localb.MpI))) {
        paramViewGroup.MqT.setVisibility(0);
      }
      switch (i)
      {
      default: 
        paramViewGroup.position = paramInt;
        paramViewGroup.MpI = localb.MpI;
        if (this.HQr)
        {
          paramViewGroup.titleTv.setText(aKp(localb.hAP));
          paramViewGroup.descTv.setText(aKp(ji(localb.MpN)));
        }
        break;
      }
      for (;;)
      {
        paramViewGroup.JOl.setVisibility(8);
        if (this.FyH)
        {
          paramViewGroup.MqS.setBackground(this.mContext.getDrawable(R.g.mm_listitem_dark_mode));
          paramViewGroup.titleTv.setTextColor(Color.parseColor("#CCFFFFFF"));
          paramViewGroup.descTv.setTextColor(Color.parseColor("#80FFFFFF"));
          paramViewGroup.JOl.setTextColor(Color.parseColor("#CCFFFFFF"));
        }
        AppMethodBeat.o(26575);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(R.e.normal_text_color));
        paramViewGroup.descTv.setVisibility(8);
        break label264;
        paramViewGroup.descTv.setVisibility(8);
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(R.e.sns_link_color));
        if (!Util.isNullOrNil(this.MqP)) {
          break label264;
        }
        paramViewGroup.MqT.setVisibility(0);
        break label264;
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(R.e.normal_text_color));
        paramViewGroup.descTv.setVisibility(0);
        break label264;
        paramViewGroup.titleTv.setText(localb.hAP);
        paramViewGroup.descTv.setText(ji(localb.MpN));
      }
    }
  }
  
  public final com.tencent.mm.plugin.nearlife.b.b kG(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(26574);
    com.tencent.mm.plugin.nearlife.b.b localb;
    if (this.MqN == null)
    {
      this.MqN = new com.tencent.mm.plugin.nearlife.b.b("", new dgz());
      this.MqN.MpI = "City";
      this.MqQ.put(this.MqN.MpI, Integer.valueOf(1));
      localb = this.MqN;
      if (!this.MqG) {
        break label117;
      }
    }
    for (;;)
    {
      a(localb, i);
      this.MqN.hAP = paramString1;
      this.MqN.hOG = paramString2;
      notifyDataSetChanged();
      paramString1 = this.MqN;
      AppMethodBeat.o(26574);
      return paramString1;
      label117:
      i = 0;
    }
  }
  
  final class a
  {
    TextView JOl;
    String MpI;
    com.tencent.mm.plugin.nearlife.b.b MqR;
    LinearLayout MqS;
    WeImageView MqT;
    TextView descTv;
    int position;
    TextView titleTv;
    int type;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.b
 * JD-Core Version:    0.7.0.1
 */