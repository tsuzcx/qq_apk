package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.y;

public abstract class i
  extends a
{
  public static float rNm = Resources.getSystem().getDisplayMetrics().density;
  public static int rNn = Resources.getSystem().getDisplayMetrics().widthPixels;
  public static int rNo = (int)(40.0F * rNm + 0.5F);
  public ImageView bNu;
  public LinearLayout fmL;
  public View.OnClickListener laS = new i.4(this);
  public WXRTEditText rMY;
  public WXRTEditText rMZ;
  public LinearLayout rNa;
  public TextView rNb;
  public TextView rNc;
  public ImageView rNd;
  public View rNe;
  public LinearLayout rNf;
  public LinearLayout rNg;
  public LinearLayout rNh;
  public LinearLayout rNi;
  public LinearLayout rNj;
  public LinearLayout rNk;
  public LinearLayout rNl;
  
  public i(View paramView, k paramk)
  {
    super(paramView, paramk);
    this.bNu = ((ImageView)paramView.findViewById(R.h.edit_imageView));
    this.rNe = paramView.findViewById(R.h.video_click_area);
    this.rNa = ((LinearLayout)paramView.findViewById(R.h.note_card_ll));
    this.fmL = ((LinearLayout)paramView.findViewById(R.h.note_voice_ll));
    this.rNb = ((TextView)paramView.findViewById(R.h.note_card_title));
    this.rNc = ((TextView)paramView.findViewById(R.h.note_card_detail));
    this.rNd = ((ImageView)paramView.findViewById(R.h.note_card_icon));
    this.rNb.setTextSize(16.0F);
    this.rNc.setTextSize(12.0F);
    this.rNf = ((LinearLayout)paramView.findViewById(R.h.note_split_ll));
    this.rNf.setVisibility(8);
    this.rNh = ((LinearLayout)paramView.findViewById(R.h.note_reminder_ll));
    this.rNh.setVisibility(8);
    this.rNi = ((LinearLayout)paramView.findViewById(R.h.note_bottom_logo_ll));
    this.rNi.setVisibility(8);
    this.rNj = ((LinearLayout)paramView.findViewById(R.h.other_cover_view));
    this.rNj.setBackgroundColor(1347529272);
    this.rNj.setVisibility(8);
    this.rNj.setOnClickListener(new i.1(this));
    this.rNk = ((LinearLayout)paramView.findViewById(R.h.other_up_cover_view));
    this.rNk.setBackgroundColor(1347529272);
    this.rNk.setVisibility(4);
    this.rNl = ((LinearLayout)paramView.findViewById(R.h.other_down_cover_view));
    this.rNl.setBackgroundColor(1347529272);
    this.rNl.setVisibility(4);
    this.rNg = ((LinearLayout)paramView.findViewById(R.h.edit_view_ll));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.rNg.getLayoutParams();
    localLayoutParams.width = (rNn - rNo);
    localLayoutParams.height = -2;
    this.rNg.setLayoutParams(localLayoutParams);
    this.rMZ = ((WXRTEditText)paramView.findViewById(R.h.btnNext));
    this.rMY = ((WXRTEditText)paramView.findViewById(R.h.btnPrev));
    ((LinearLayout)paramView.findViewById(R.h.btnNextLL)).setOnClickListener(new i.2(this));
    ((LinearLayout)paramView.findViewById(R.h.btnPrevLL)).setOnClickListener(new i.3(this));
    this.rMZ.setEditTextType(2);
    this.rMY.setEditTextType(1);
    this.rMY.rIp = this;
    this.rMZ.rIp = this;
    if ((paramk.rJg != 2) || (!this.rLi.rJh))
    {
      this.rMZ.setKeyListener(null);
      this.rMZ.setEnabled(false);
      this.rMZ.setFocusable(false);
      this.rMY.setKeyListener(null);
      this.rMY.setEnabled(false);
      this.rMY.setFocusable(false);
    }
    this.rLi.o(this.rMY);
    this.rLi.o(this.rMZ);
  }
  
  public void a(c paramc, int paramInt1, int paramInt2)
  {
    y.i("Micromsg.NoteOtherItemHolder", "ImageItemHolder position is " + ic());
    this.rMY.setPosInDataList(paramInt1);
    this.rMZ.setPosInDataList(paramInt1);
    if (e.isEnabled()) {
      e.ciJ().a(this.rNj, this.rNk, this.rNl, paramInt1);
    }
    paramc.rGq = this.rMY;
    paramc.rGr = this.rMZ;
    paramc.rGs = null;
    if (paramc.rGn) {
      if (paramc.rGt) {
        this.rMY.requestFocus();
      }
    }
    for (;;)
    {
      if (this.rNa.getVisibility() == 0)
      {
        if (!paramc.rGu) {
          break;
        }
        this.rNa.setBackgroundResource(R.g.wenote_basecard_pressed_bg);
      }
      return;
      this.rMZ.requestFocus();
      continue;
      if (this.rMY.hasFocus()) {
        this.rMY.clearFocus();
      }
      if (this.rMZ.hasFocus()) {
        this.rMZ.clearFocus();
      }
    }
    this.rNa.setBackgroundResource(R.g.wenote_basecard_bg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.i
 * JD-Core Version:    0.7.0.1
 */