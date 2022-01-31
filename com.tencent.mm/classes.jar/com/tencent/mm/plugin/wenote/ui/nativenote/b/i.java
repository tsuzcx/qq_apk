package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class i
  extends a
{
  public static float vDQ = Resources.getSystem().getDisplayMetrics().density;
  public static int vDR = Resources.getSystem().getDisplayMetrics().widthPixels;
  public static int vDS = (int)(40.0F * vDQ + 0.5F);
  public ImageView cuM;
  public LinearLayout gEf;
  public View.OnClickListener nyO = new i.4(this);
  public WXRTEditText vDC;
  public WXRTEditText vDD;
  public LinearLayout vDE;
  public TextView vDF;
  public TextView vDG;
  public ImageView vDH;
  public View vDI;
  public LinearLayout vDJ;
  public LinearLayout vDK;
  public LinearLayout vDL;
  public LinearLayout vDM;
  public LinearLayout vDN;
  public LinearLayout vDO;
  public LinearLayout vDP;
  
  public i(View paramView, k paramk)
  {
    super(paramView, paramk);
    this.cuM = ((ImageView)paramView.findViewById(2131826578));
    this.vDI = paramView.findViewById(2131826579);
    this.vDE = ((LinearLayout)paramView.findViewById(2131826580));
    this.gEf = ((LinearLayout)paramView.findViewById(2131826584));
    this.vDF = ((TextView)paramView.findViewById(2131826582));
    this.vDG = ((TextView)paramView.findViewById(2131826583));
    this.vDH = ((ImageView)paramView.findViewById(2131826581));
    this.vDF.setTextSize(16.0F);
    this.vDG.setTextSize(12.0F);
    this.vDJ = ((LinearLayout)paramView.findViewById(2131826593));
    this.vDJ.setVisibility(8);
    this.vDL = ((LinearLayout)paramView.findViewById(2131826598));
    this.vDL.setVisibility(8);
    this.vDM = ((LinearLayout)paramView.findViewById(2131826595));
    this.vDM.setVisibility(8);
    this.vDN = ((LinearLayout)paramView.findViewById(2131826601));
    this.vDN.setBackgroundColor(1347529272);
    this.vDN.setVisibility(8);
    this.vDN.setOnClickListener(new i.1(this));
    this.vDO = ((LinearLayout)paramView.findViewById(2131826570));
    this.vDO.setBackgroundColor(1347529272);
    this.vDO.setVisibility(4);
    this.vDP = ((LinearLayout)paramView.findViewById(2131826602));
    this.vDP.setBackgroundColor(1347529272);
    this.vDP.setVisibility(4);
    this.vDK = ((LinearLayout)paramView.findViewById(2131826569));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.vDK.getLayoutParams();
    localLayoutParams.width = (vDR - vDS);
    localLayoutParams.height = -2;
    this.vDK.setLayoutParams(localLayoutParams);
    this.vDD = ((WXRTEditText)paramView.findViewById(2131826606));
    this.vDC = ((WXRTEditText)paramView.findViewById(2131826604));
    ((LinearLayout)paramView.findViewById(2131826605)).setOnClickListener(new i.2(this));
    ((LinearLayout)paramView.findViewById(2131826603)).setOnClickListener(new i.3(this));
    this.vDD.setEditTextType(2);
    this.vDC.setEditTextType(1);
    this.vDC.vyV = this;
    this.vDD.vyV = this;
    if ((paramk.vzL != 2) || (!this.vBM.vzM))
    {
      this.vDD.setKeyListener(null);
      this.vDD.setEnabled(false);
      this.vDD.setFocusable(false);
      this.vDC.setKeyListener(null);
      this.vDC.setEnabled(false);
      this.vDC.setFocusable(false);
    }
    this.vBM.q(this.vDC);
    this.vBM.q(this.vDD);
  }
  
  public void a(c paramc, int paramInt1, int paramInt2)
  {
    ab.i("Micromsg.NoteOtherItemHolder", "ImageItemHolder position is " + jM());
    this.vDC.setPosInDataList(paramInt1);
    this.vDD.setPosInDataList(paramInt1);
    if (e.isEnabled()) {
      e.djc().a(this.vDN, this.vDO, this.vDP, paramInt1);
    }
    paramc.vwZ = this.vDC;
    paramc.vxa = this.vDD;
    paramc.vxb = null;
    if (paramc.vwW) {
      if (paramc.vxc) {
        this.vDC.requestFocus();
      }
    }
    for (;;)
    {
      if (this.vDE.getVisibility() == 0)
      {
        if (!paramc.vxd) {
          break;
        }
        this.vDE.setBackgroundResource(2130840937);
      }
      return;
      this.vDD.requestFocus();
      continue;
      if (this.vDC.hasFocus()) {
        this.vDC.clearFocus();
      }
      if (this.vDD.hasFocus()) {
        this.vDD.clearFocus();
      }
    }
    this.vDE.setBackgroundResource(2130840936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.i
 * JD-Core Version:    0.7.0.1
 */