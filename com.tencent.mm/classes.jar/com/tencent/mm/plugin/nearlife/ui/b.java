package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.protocal.c.atn;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;

public final class b
  extends a
{
  com.tencent.mm.plugin.nearlife.b.a mEX;
  private com.tencent.mm.plugin.nearlife.b.a mEY = new com.tencent.mm.plugin.nearlife.b.a("", new atn());
  String mEZ;
  private HashMap<String, Integer> mFa = new HashMap();
  
  public b(Context paramContext, View.OnClickListener paramOnClickListener, String paramString, boolean paramBoolean)
  {
    super(paramContext, paramOnClickListener, paramString, paramBoolean);
    this.mEY.mDU = "NotCheckIn";
    this.mEY.bGw = paramContext.getString(R.l.near_life_no_display);
    this.mFa.put(this.mEY.mDU, Integer.valueOf(2));
    if (!paramBoolean)
    {
      a(this.mEY, 0);
      notifyDataSetChanged();
    }
  }
  
  private Spannable GJ(String paramString)
  {
    return f.a(paramString, this.mEh);
  }
  
  public final com.tencent.mm.plugin.nearlife.b.a eh(String paramString1, String paramString2)
  {
    if (this.mEX == null)
    {
      this.mEX = new com.tencent.mm.plugin.nearlife.b.a("", new atn());
      this.mEX.mDU = "City";
      this.mFa.put(this.mEX.mDU, Integer.valueOf(1));
      a(this.mEX, 1);
    }
    this.mEX.bGw = paramString1;
    this.mEX.lJQ = paramString2;
    notifyDataSetChanged();
    return this.mEX;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.tencent.mm.plugin.nearlife.b.a locala;
    if (paramView == null)
    {
      paramViewGroup = new b.a(this);
      paramView = View.inflate(this.mContext, R.i.near_life_item, null);
      paramViewGroup.eXr = ((TextView)paramView.findViewById(R.h.life_item_title));
      paramViewGroup.lxl = ((TextView)paramView.findViewById(R.h.life_item_price));
      paramViewGroup.gaI = ((TextView)paramView.findViewById(R.h.life_item_desc));
      paramViewGroup.mFc = ((LinearLayout)paramView.findViewById(R.h.root_content));
      paramViewGroup.mFd = ((ImageView)paramView.findViewById(R.h.select_iv));
      paramViewGroup.mFc.setOnClickListener(this.kdc);
      paramView.setTag(paramViewGroup);
      locala = vh(paramInt);
      if (!this.mFa.containsKey(locala.mDU)) {
        break label457;
      }
    }
    label457:
    for (int i = ((Integer)this.mFa.get(locala.mDU)).intValue();; i = 0)
    {
      paramViewGroup.mFd.setVisibility(8);
      paramViewGroup.type = i;
      paramViewGroup.mFb = locala;
      if ((!bk.bl(this.mEZ)) && (this.mEZ.equals(locala.mDU))) {
        paramViewGroup.mFd.setVisibility(0);
      }
      switch (i)
      {
      default: 
        label236:
        paramViewGroup.position = paramInt;
        paramViewGroup.mDU = locala.mDU;
        if (this.mEl)
        {
          paramViewGroup.eXr.setText(GJ(locala.bGw));
          paramViewGroup.gaI.setText(GJ(bS(locala.mDZ)));
        }
        break;
      }
      for (;;)
      {
        paramViewGroup.lxl.setVisibility(8);
        return paramView;
        paramViewGroup = (b.a)paramView.getTag();
        break;
        paramViewGroup.eXr.setTextColor(this.mContext.getResources().getColor(R.e.black));
        paramViewGroup.gaI.setVisibility(8);
        break label236;
        paramViewGroup.gaI.setVisibility(8);
        paramViewGroup.eXr.setTextColor(this.mContext.getResources().getColor(R.e.sns_link_color));
        if (!bk.bl(this.mEZ)) {
          break label236;
        }
        paramViewGroup.mFd.setVisibility(0);
        break label236;
        paramViewGroup.eXr.setTextColor(this.mContext.getResources().getColor(R.e.black));
        paramViewGroup.gaI.setVisibility(0);
        break label236;
        paramViewGroup.eXr.setText(locala.bGw);
        paramViewGroup.gaI.setText(bS(locala.mDZ));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.b
 * JD-Core Version:    0.7.0.1
 */