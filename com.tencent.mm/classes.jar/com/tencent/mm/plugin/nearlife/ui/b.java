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
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;

public final class b
  extends a
{
  private String color;
  private boolean peW;
  com.tencent.mm.plugin.nearlife.b.a pfd;
  private com.tencent.mm.plugin.nearlife.b.a pfe;
  String pff;
  private HashMap<String, Integer> pfg;
  
  public b(Context paramContext, View.OnClickListener paramOnClickListener, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    super(paramContext, paramOnClickListener, paramString1, paramBoolean2);
    AppMethodBeat.i(22949);
    this.pfg = new HashMap();
    this.peW = true;
    this.pfe = new com.tencent.mm.plugin.nearlife.b.a("", new azs());
    this.pfe.pdW = "NotCheckIn";
    this.pfe.Title = paramContext.getString(2131301744);
    this.peW = paramBoolean1;
    this.color = paramString2;
    this.pfg.put(this.pfe.pdW, Integer.valueOf(2));
    if ((!paramBoolean2) && (paramBoolean1))
    {
      a(this.pfe, 0);
      notifyDataSetChanged();
    }
    AppMethodBeat.o(22949);
  }
  
  private Spannable Sm(String paramString)
  {
    AppMethodBeat.i(22952);
    paramString = f.a(paramString, this.pej);
    AppMethodBeat.o(22952);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.nearlife.b.a fB(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(22950);
    com.tencent.mm.plugin.nearlife.b.a locala;
    if (this.pfd == null)
    {
      this.pfd = new com.tencent.mm.plugin.nearlife.b.a("", new azs());
      this.pfd.pdW = "City";
      this.pfg.put(this.pfd.pdW, Integer.valueOf(1));
      locala = this.pfd;
      if (!this.peW) {
        break label116;
      }
    }
    for (;;)
    {
      a(locala, i);
      this.pfd.Title = paramString1;
      this.pfd.ohe = paramString2;
      notifyDataSetChanged();
      paramString1 = this.pfd;
      AppMethodBeat.o(22950);
      return paramString1;
      label116:
      i = 0;
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22951);
    com.tencent.mm.plugin.nearlife.b.a locala;
    if (paramView == null)
    {
      paramViewGroup = new b.a(this);
      paramView = View.inflate(this.mContext, 2130970340, null);
      paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131826469));
      paramViewGroup.nUy = ((TextView)paramView.findViewById(2131826481));
      paramViewGroup.hsI = ((TextView)paramView.findViewById(2131826482));
      paramViewGroup.pfi = ((LinearLayout)paramView.findViewById(2131826191));
      paramViewGroup.pfj = ((WeImageView)paramView.findViewById(2131826483));
      if (this.color != null) {
        paramViewGroup.pfj.setIconColor(Color.parseColor(this.color));
      }
      paramViewGroup.pfi.setOnClickListener(this.bTw);
      paramView.setTag(paramViewGroup);
      locala = AF(paramInt);
      if (!this.pfg.containsKey(locala.pdW)) {
        break label481;
      }
    }
    label256:
    label481:
    for (int i = ((Integer)this.pfg.get(locala.pdW)).intValue();; i = 0)
    {
      paramViewGroup.pfj.setVisibility(8);
      paramViewGroup.type = i;
      paramViewGroup.pfh = locala;
      if ((!bo.isNullOrNil(this.pff)) && (this.pff.equals(locala.pdW))) {
        paramViewGroup.pfj.setVisibility(0);
      }
      switch (i)
      {
      default: 
        paramViewGroup.position = paramInt;
        paramViewGroup.pdW = locala.pdW;
        if (this.peo)
        {
          paramViewGroup.titleTv.setText(Sm(locala.Title));
          paramViewGroup.hsI.setText(Sm(cq(locala.peb)));
        }
        break;
      }
      for (;;)
      {
        paramViewGroup.nUy.setVisibility(8);
        AppMethodBeat.o(22951);
        return paramView;
        paramViewGroup = (b.a)paramView.getTag();
        break;
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131689763));
        paramViewGroup.hsI.setVisibility(8);
        break label256;
        paramViewGroup.hsI.setVisibility(8);
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131690489));
        if (!bo.isNullOrNil(this.pff)) {
          break label256;
        }
        paramViewGroup.pfj.setVisibility(0);
        break label256;
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131689763));
        paramViewGroup.hsI.setVisibility(0);
        break label256;
        paramViewGroup.titleTv.setText(locala.Title);
        paramViewGroup.hsI.setText(cq(locala.peb));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.b
 * JD-Core Version:    0.7.0.1
 */