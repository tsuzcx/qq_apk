package com.tencent.mm.wallet_core.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class c
{
  public o fvf = null;
  private ImageView fvg;
  private View fvh;
  private View.OnClickListener fvj = new c.1(this);
  private MMActivity hxN;
  public boolean isF = true;
  private Bitmap iwA = null;
  private View iwD;
  private ImageView iwE;
  private MMVerticalTextView iwF;
  private ArrayList<Bitmap> iwH = new ArrayList();
  private String mKk = "";
  private String mMK = "";
  public Bitmap mMn = null;
  public Bitmap mMo = null;
  ViewGroup wCd;
  private boolean wCe = false;
  
  public c(MMActivity paramMMActivity)
  {
    this(paramMMActivity, false);
  }
  
  public c(MMActivity paramMMActivity, boolean paramBoolean)
  {
    this.hxN = paramMMActivity;
    this.wCe = paramBoolean;
  }
  
  private void cNf()
  {
    if (this.isF)
    {
      this.iwE.setOnClickListener(this.fvj);
      Bitmap localBitmap = this.iwA;
      if (this.mMo != null)
      {
        this.iwA = e.v(this.mMo);
        y.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp != null");
      }
      for (;;)
      {
        this.iwE.setImageBitmap(this.iwA);
        this.iwH.add(0, localBitmap);
        if (this.iwH.size() < 2) {
          break;
        }
        int i = this.iwH.size() - 1;
        while (i > 1)
        {
          e.w((Bitmap)this.iwH.remove(i));
          i -= 1;
        }
        this.iwA = null;
        y.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp == null");
      }
      this.fvh.setVisibility(8);
      this.iwD.setVisibility(0);
      this.iwF.setText(e.afo(this.mKk));
      this.fvf.update();
      return;
    }
    this.fvg.setOnClickListener(this.fvj);
    this.fvg.setImageBitmap(this.mMn);
    if (this.mMn != null) {
      y.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp != null");
    }
    for (;;)
    {
      this.fvh.setVisibility(0);
      this.iwD.setVisibility(8);
      break;
      y.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp == null");
    }
  }
  
  public final void cNd()
  {
    if ((this.fvf != null) && (this.fvf.isShowing())) {
      cNf();
    }
  }
  
  public final void cNe()
  {
    if (this.wCd != null) {
      this.wCd.setVisibility(0);
    }
  }
  
  public final void dismiss()
  {
    if ((this.fvf != null) && (this.fvf.isShowing())) {
      this.fvf.dismiss();
    }
  }
  
  public final void gG(String paramString1, String paramString2)
  {
    this.mMK = paramString1;
    this.mKk = paramString2;
  }
  
  public final void init()
  {
    View localView;
    if (this.fvf == null)
    {
      if (!this.wCe) {
        break label207;
      }
      localView = View.inflate(this.hxN, a.g.wallet_offline_new_popupwindow_layout, null);
      MMVerticalTextView localMMVerticalTextView = (MMVerticalTextView)localView.findViewById(a.f.mask_i_know_btn);
      this.wCd = ((ViewGroup)localView.findViewById(a.f.popupwd_mask_layout));
      localMMVerticalTextView.setOnClickListener(new c.2(this));
      localView.findViewById(a.f.popupwd_content_layout).setOnClickListener(new c.3(this));
    }
    for (;;)
    {
      this.fvh = localView.findViewById(a.f.popupwd_qrcode_layout);
      this.fvg = ((ImageView)localView.findViewById(a.f.popupwd_qrcode_iv));
      this.iwD = localView.findViewById(a.f.popupwd_barcode_layout);
      this.iwE = ((ImageView)localView.findViewById(a.f.popupwd_barcode_iv));
      this.iwF = ((MMVerticalTextView)localView.findViewById(a.f.vertical_barcode_text));
      this.fvf = new o(localView, -1, -1, true);
      this.fvf.setClippingEnabled(false);
      this.fvf.update();
      this.fvf.setBackgroundDrawable(new ColorDrawable(16777215));
      this.fvf.setOnDismissListener(new c.5(this));
      return;
      label207:
      localView = View.inflate(this.hxN, a.g.wallet_offline_popup_window, null);
      localView.setOnClickListener(new c.4(this));
    }
  }
  
  public final void release()
  {
    if ((this.fvf != null) && (this.fvf.isShowing())) {
      this.fvf.dismiss();
    }
    e.w(this.iwA);
    e.ak(this.iwH);
    this.iwH.clear();
    this.hxN = null;
  }
  
  public final void y(View paramView, boolean paramBoolean)
  {
    this.isF = paramBoolean;
    if ((this.fvf != null) && (!this.fvf.isShowing()))
    {
      this.fvf.showAtLocation(paramView.getRootView(), 17, 0, 0);
      this.fvf.setFocusable(true);
      this.fvf.setTouchable(true);
      this.fvf.setBackgroundDrawable(new ColorDrawable(16777215));
      this.fvf.setOutsideTouchable(true);
      if (this.isF) {
        cNe();
      }
      cNf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.c
 * JD-Core Version:    0.7.0.1
 */