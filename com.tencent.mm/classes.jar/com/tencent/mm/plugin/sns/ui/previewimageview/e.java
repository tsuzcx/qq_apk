package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.v;
import com.tencent.mm.plugin.sns.ui.v.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class e
  implements v
{
  private Context context;
  TextView oPv;
  private ImageView pbf;
  private boolean ppJ;
  c ppK;
  DynamicGridView ppL;
  v.a ppM;
  float ppN;
  View ppO;
  ImageView ppP;
  private View ppQ;
  private View ppR;
  private int ppS;
  Rect ppT;
  
  public e(View paramView1, View paramView2, View paramView3, Context paramContext, List<String> paramList, DynamicGridView paramDynamicGridView, v.a parama, c.a parama1, boolean paramBoolean)
  {
    this.ppJ = paramBoolean;
    this.context = paramContext;
    this.ppM = parama;
    this.ppO = paramView2;
    this.ppQ = paramView3;
    this.ppL = paramDynamicGridView;
    this.ppP = ((ImageView)paramView2.findViewById(i.f.del_img));
    this.oPv = ((TextView)paramView2.findViewById(i.f.del_tv));
    this.ppR = paramView1;
    paramDynamicGridView.setWobbleInEditMode(false);
    af.bDu();
    this.ppS = ((s.getScreenWidth() - paramContext.getResources().getDimensionPixelSize(i.d.sns_upload_previewimg_view_margin) * 4 - paramContext.getResources().getDimensionPixelSize(i.d.LargerPadding) * 2) / 3);
    paramDynamicGridView.setColumnWidth(this.ppS + paramContext.getResources().getDimensionPixelSize(i.d.sns_upload_previewimg_view_margin) * 2);
    paramDynamicGridView.setNumColumns(3);
    paramDynamicGridView.setOverScrollMode(2);
    paramDynamicGridView.setStretchMode(0);
    paramDynamicGridView.setClipChildren(false);
    paramDynamicGridView.setClipToPadding(false);
    paramDynamicGridView.setSelector(new ColorDrawable(0));
    this.ppK = new c(paramContext, paramList, paramBoolean, parama1);
    bKo();
    paramDynamicGridView.setAdapter(this.ppK);
    paramDynamicGridView.setOnDragListener(new e.1(this, paramDynamicGridView));
    paramDynamicGridView.setOnItemLongClickListener(new e.2(this));
    paramDynamicGridView.setOnItemClickListener(new e.3(this));
    paramDynamicGridView.setOnDropListener(new e.4(this, paramDynamicGridView, paramView1));
    paramDynamicGridView.getViewTreeObserver().addOnPreDrawListener(new e.5(this, paramDynamicGridView, paramList));
    af.bDu();
    if (s.getScreenWidth() == 0) {
      new ah().postDelayed(new e.6(this, paramList), 50L);
    }
  }
  
  private void bKo()
  {
    if ((ae.cqS().getBoolean("key_show_tips", true)) && (this.ppK.bKn() > 1))
    {
      this.ppQ.setVisibility(0);
      this.pbf = ((ImageView)this.ppQ.findViewById(i.f.sns_img_close_iv));
      this.pbf.setOnClickListener(new e.7(this));
      return;
    }
    this.ppQ.setVisibility(8);
  }
  
  public final void clean()
  {
    if ((this.ppL != null) && (this.ppL.getAdapter() == null)) {
      ((c)this.ppL.getAdapter()).oSy = true;
    }
  }
  
  public final View getView()
  {
    return this.ppL;
  }
  
  public final void setImageClick(v.a parama)
  {
    this.ppM = parama;
  }
  
  public final void setIsShowAddImage(boolean paramBoolean)
  {
    this.ppJ = paramBoolean;
  }
  
  public final void setList$22875ea3(List<String> paramList)
  {
    if (this.ppK != null)
    {
      this.ppK.cJ(paramList);
      bKo();
    }
  }
  
  public final void zb(int paramInt)
  {
    int i = 3;
    af.bDu();
    this.ppS = ((s.getScreenWidth() - this.context.getResources().getDimensionPixelSize(i.d.sns_upload_previewimg_view_margin) * 4 - this.context.getResources().getDimensionPixelSize(i.d.LargerPadding) * 2) / 3);
    this.ppL.setColumnWidth(this.ppS + this.context.getResources().getDimensionPixelSize(i.d.sns_upload_previewimg_view_margin) * 2);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.ppL.getLayoutParams();
    af.bDu();
    y.i("DynamicGrid", "setGridViewMargins margin: screenWith:%d", new Object[] { Integer.valueOf(s.getScreenWidth()) });
    paramInt = (paramInt + 3) / 3;
    if (paramInt > 3) {
      paramInt = i;
    }
    for (;;)
    {
      i = localMarginLayoutParams.leftMargin;
      int j = this.ppR.getHeight();
      int k = this.ppS;
      int m = this.context.getResources().getDimensionPixelSize(i.d.sns_upload_previewimg_view_margin);
      int n = localMarginLayoutParams.rightMargin;
      float f = com.tencent.mm.sdk.platformtools.c.cqp().density;
      localMarginLayoutParams.setMargins(i, j - k - m * 2, n, (int)((4 - paramInt) * (f * 32.0F)));
      this.ppL.setLayoutParams(localMarginLayoutParams);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e
 * JD-Core Version:    0.7.0.1
 */