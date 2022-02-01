package com.tencent.mm.wallet_core.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.do;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.v;
import java.util.ArrayList;

public final class c
{
  public Bitmap MAx;
  public Bitmap MAy;
  private String MBn;
  private String MxZ;
  ViewGroup agUM;
  private boolean agUN;
  public v qjH;
  ImageView qjI;
  private View qjJ;
  private View.OnClickListener qjL;
  public boolean wAg;
  private Bitmap wDZ;
  private View wEc;
  private ImageView wEd;
  private MMVerticalTextView wEe;
  private ArrayList<Bitmap> wEg;
  MMActivity wry;
  
  public c(MMActivity paramMMActivity)
  {
    this(paramMMActivity, false);
  }
  
  public c(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(72952);
    this.MAx = null;
    this.MAy = null;
    this.wDZ = null;
    this.MBn = "";
    this.MxZ = "";
    this.wAg = true;
    this.wEg = new ArrayList();
    this.qjH = null;
    this.agUN = false;
    this.qjL = new c.1(this);
    this.wry = paramMMActivity;
    this.agUN = paramBoolean;
    AppMethodBeat.o(72952);
  }
  
  private void jPo()
  {
    AppMethodBeat.i(72958);
    if (this.wAg)
    {
      Bitmap localBitmap = this.wDZ;
      if (this.MAy != null)
      {
        this.wDZ = i.ag(this.MAy);
        Log.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp != null");
      }
      for (;;)
      {
        this.wEd.setImageBitmap(this.wDZ);
        this.wEg.add(0, localBitmap);
        recycleBmpList();
        this.qjJ.setVisibility(8);
        this.wEc.setVisibility(0);
        this.wEe.setText(i.bES(this.MxZ));
        this.wEe.setContentDescription(this.MxZ);
        this.qjH.update();
        AppMethodBeat.o(72958);
        return;
        this.wDZ = null;
        Log.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp == null");
      }
    }
    this.qjI.setImageBitmap(this.MAx);
    if (this.MAx != null) {
      Log.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp != null");
    }
    for (;;)
    {
      this.qjJ.setVisibility(0);
      this.wEc.setVisibility(8);
      this.qjI.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(242180);
          c.this.qjI.announceForAccessibility(MMApplicationContext.getString(a.i.wallet_wx_offline_qrcode_content_description_2));
          AppMethodBeat.o(242180);
        }
      }, 500L);
      break;
      Log.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp == null");
    }
  }
  
  private void recycleBmpList()
  {
    AppMethodBeat.i(72959);
    if (this.wEg.size() >= 2)
    {
      int i = this.wEg.size() - 1;
      while (i > 1)
      {
        i.ah((Bitmap)this.wEg.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(72959);
  }
  
  public final void ak(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(72955);
    this.wAg = paramBoolean;
    if ((this.qjH != null) && (!this.qjH.isShowing()))
    {
      this.qjH.showAtLocation(paramView.getRootView(), 17, 0, 0);
      this.qjH.setFocusable(true);
      this.qjH.setTouchable(true);
      this.qjH.setBackgroundDrawable(new ColorDrawable(16777215));
      this.qjH.setOutsideTouchable(true);
      if (!this.wAg) {
        break label116;
      }
      jPn();
    }
    for (;;)
    {
      jPo();
      this.wry.getWindow().addFlags(1024);
      AppMethodBeat.o(72955);
      return;
      label116:
      if (this.agUM != null) {
        this.agUM.setVisibility(8);
      }
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(72960);
    if ((this.qjH != null) && (this.qjH.isShowing())) {
      this.qjH.dismiss();
    }
    AppMethodBeat.o(72960);
  }
  
  public final void jPl()
  {
    AppMethodBeat.i(72954);
    if (this.qjH != null)
    {
      AppMethodBeat.o(72954);
      return;
    }
    View localView1;
    if (this.agUN)
    {
      localView1 = View.inflate(this.wry, a.g.wallet_offline_new_popupwindow_layout, null);
      final MMVerticalTextView localMMVerticalTextView1 = (MMVerticalTextView)localView1.findViewById(a.f.vertical_alert_text);
      MMVerticalTextView localMMVerticalTextView2 = (MMVerticalTextView)localView1.findViewById(a.f.mask_i_know_btn);
      localMMVerticalTextView2.setMediumBold(true);
      localMMVerticalTextView2.setAccessibilityViewType(1);
      this.agUM = ((ViewGroup)localView1.findViewById(a.f.popupwd_mask_layout));
      final View localView2 = localView1.findViewById(a.f.popupwd_content_layout);
      localView2.setImportantForAccessibility(4);
      localView2.setOnClickListener(new c.2(this));
      localMMVerticalTextView2.setOnClickListener(new k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(242179);
          Log.d("MicroMsg.OfflinePopupWindow", "on click know");
          c.this.agUM.setVisibility(8);
          paramAnonymousView = new do();
          paramAnonymousView.hDC.hDD = 1;
          paramAnonymousView.publish();
          localView2.setImportantForAccessibility(0);
          localMMVerticalTextView1.sendAccessibilityEvent(8);
          AppMethodBeat.o(242179);
        }
      });
      ((ViewGroup)localView1.findViewById(a.f.mask_vertical_alert_layout)).setContentDescription(MMApplicationContext.getString(a.i.offline_barcode_mask_alert_text1) + MMApplicationContext.getString(a.i.offline_barcode_mask_alert_text2));
    }
    for (;;)
    {
      this.qjJ = localView1.findViewById(a.f.popupwd_qrcode_layout);
      this.qjI = ((ImageView)localView1.findViewById(a.f.popupwd_qrcode_iv));
      this.wEc = localView1.findViewById(a.f.popupwd_barcode_layout);
      this.wEd = ((ImageView)localView1.findViewById(a.f.popupwd_barcode_iv));
      this.wEe = ((MMVerticalTextView)localView1.findViewById(a.f.vertical_barcode_text));
      this.qjH = new v(localView1, -1, -1, true);
      this.qjH.setClippingEnabled(false);
      this.qjH.update();
      this.qjH.setBackgroundDrawable(new ColorDrawable(16777215));
      this.qjH.setOnDismissListener(new c.5(this));
      AppMethodBeat.o(72954);
      return;
      localView1 = View.inflate(this.wry, a.g.wallet_offline_popup_window, null);
      localView1.setOnClickListener(new c.4(this));
    }
  }
  
  public final void jPm()
  {
    AppMethodBeat.i(72956);
    if ((this.qjH != null) && (this.qjH.isShowing())) {
      jPo();
    }
    AppMethodBeat.o(72956);
  }
  
  public final void jPn()
  {
    AppMethodBeat.i(72957);
    if (this.agUM != null)
    {
      this.agUM.setVisibility(0);
      this.agUM.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(242181);
          ViewGroup localViewGroup = (ViewGroup)c.this.agUM.findViewById(a.f.mask_vertical_alert_layout);
          if (localViewGroup != null) {
            localViewGroup.sendAccessibilityEvent(128);
          }
          AppMethodBeat.o(242181);
        }
      });
    }
    AppMethodBeat.o(72957);
  }
  
  public final void qv(String paramString1, String paramString2)
  {
    this.MBn = paramString1;
    this.MxZ = paramString2;
  }
  
  public final void release()
  {
    AppMethodBeat.i(72953);
    if ((this.qjH != null) && (this.qjH.isShowing())) {
      this.qjH.dismiss();
    }
    i.ah(this.wDZ);
    i.cj(this.wEg);
    this.wEg.clear();
    this.wry = null;
    AppMethodBeat.o(72953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.c
 * JD-Core Version:    0.7.0.1
 */