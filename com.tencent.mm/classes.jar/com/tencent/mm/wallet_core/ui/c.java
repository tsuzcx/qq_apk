package com.tencent.mm.wallet_core.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.de;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.r;
import java.util.ArrayList;

public final class c
{
  private String GBR;
  private String GEL;
  public Bitmap GEe;
  public Bitmap GEf;
  ViewGroup YWS;
  private boolean YWT;
  private View nmA;
  private View.OnClickListener nmC;
  public r nmy;
  private ImageView nmz;
  MMActivity tmY;
  public boolean tvI;
  private Bitmap tzE;
  private View tzH;
  private ImageView tzI;
  private MMVerticalTextView tzJ;
  private ArrayList<Bitmap> tzL;
  
  public c(MMActivity paramMMActivity)
  {
    this(paramMMActivity, false);
  }
  
  public c(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(72952);
    this.GEe = null;
    this.GEf = null;
    this.tzE = null;
    this.GEL = "";
    this.GBR = "";
    this.tvI = true;
    this.tzL = new ArrayList();
    this.nmy = null;
    this.YWT = false;
    this.nmC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72948);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (((paramAnonymousView.getId() == a.f.popupwd_qrcode_iv) || (paramAnonymousView.getId() == a.f.popupwd_barcode_iv)) && (c.this.nmy != null) && (c.this.nmy.isShowing())) {
          c.this.nmy.dismiss();
        }
        a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72948);
      }
    };
    this.tmY = paramMMActivity;
    this.YWT = paramBoolean;
    AppMethodBeat.o(72952);
  }
  
  private void ijt()
  {
    AppMethodBeat.i(72958);
    if (this.tvI)
    {
      this.tzI.setOnClickListener(this.nmC);
      Bitmap localBitmap = this.tzE;
      if (this.GEf != null)
      {
        this.tzE = g.W(this.GEf);
        Log.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp != null");
      }
      for (;;)
      {
        this.tzI.setImageBitmap(this.tzE);
        this.tzL.add(0, localBitmap);
        recycleBmpList();
        this.nmA.setVisibility(8);
        this.tzH.setVisibility(0);
        this.tzJ.setText(g.bCu(this.GBR));
        this.nmy.update();
        AppMethodBeat.o(72958);
        return;
        this.tzE = null;
        Log.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp == null");
      }
    }
    this.nmz.setOnClickListener(this.nmC);
    this.nmz.setImageBitmap(this.GEe);
    if (this.GEe != null) {
      Log.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp != null");
    }
    for (;;)
    {
      this.nmA.setVisibility(0);
      this.tzH.setVisibility(8);
      break;
      Log.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp == null");
    }
  }
  
  private void recycleBmpList()
  {
    AppMethodBeat.i(72959);
    if (this.tzL.size() >= 2)
    {
      int i = this.tzL.size() - 1;
      while (i > 1)
      {
        g.X((Bitmap)this.tzL.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(72959);
  }
  
  public final void ae(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(72955);
    this.tvI = paramBoolean;
    if ((this.nmy != null) && (!this.nmy.isShowing()))
    {
      this.nmy.showAtLocation(paramView.getRootView(), 17, 0, 0);
      this.nmy.setFocusable(true);
      this.nmy.setTouchable(true);
      this.nmy.setBackgroundDrawable(new ColorDrawable(16777215));
      this.nmy.setOutsideTouchable(true);
      if (this.tvI) {
        ijs();
      }
      ijt();
      this.tmY.getWindow().addFlags(1024);
    }
    AppMethodBeat.o(72955);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(72960);
    if ((this.nmy != null) && (this.nmy.isShowing())) {
      this.nmy.dismiss();
    }
    AppMethodBeat.o(72960);
  }
  
  public final void ijq()
  {
    AppMethodBeat.i(72954);
    if (this.nmy != null)
    {
      AppMethodBeat.o(72954);
      return;
    }
    View localView;
    if (this.YWT)
    {
      localView = View.inflate(this.tmY, a.g.wallet_offline_new_popupwindow_layout, null);
      MMVerticalTextView localMMVerticalTextView = (MMVerticalTextView)localView.findViewById(a.f.mask_i_know_btn);
      localMMVerticalTextView.setMediumBold(true);
      this.YWS = ((ViewGroup)localView.findViewById(a.f.popupwd_mask_layout));
      localMMVerticalTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72949);
          b localb = new b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.d("MicroMsg.OfflinePopupWindow", "on click know");
          c.this.YWS.setVisibility(8);
          paramAnonymousView = new de();
          paramAnonymousView.fyT.fyU = 1;
          EventCenter.instance.publish(paramAnonymousView);
          a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72949);
        }
      });
      localView.findViewById(a.f.popupwd_content_layout).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72950);
          b localb = new b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.d("MicroMsg.OfflinePopupWindow", "root on click");
          if ((c.this.nmy != null) && (c.this.nmy.isShowing())) {
            c.this.nmy.dismiss();
          }
          a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72950);
        }
      });
    }
    for (;;)
    {
      this.nmA = localView.findViewById(a.f.popupwd_qrcode_layout);
      this.nmz = ((ImageView)localView.findViewById(a.f.popupwd_qrcode_iv));
      this.tzH = localView.findViewById(a.f.popupwd_barcode_layout);
      this.tzI = ((ImageView)localView.findViewById(a.f.popupwd_barcode_iv));
      this.tzJ = ((MMVerticalTextView)localView.findViewById(a.f.vertical_barcode_text));
      this.nmy = new r(localView, -1, -1, true);
      this.nmy.setClippingEnabled(false);
      this.nmy.update();
      this.nmy.setBackgroundDrawable(new ColorDrawable(16777215));
      this.nmy.setOnDismissListener(new PopupWindow.OnDismissListener()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(254998);
          c.this.tmY.getWindow().clearFlags(1024);
          AppMethodBeat.o(254998);
        }
      });
      AppMethodBeat.o(72954);
      return;
      localView = View.inflate(this.tmY, a.g.wallet_offline_popup_window, null);
      localView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72951);
          b localb = new b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if ((c.this.nmy != null) && (c.this.nmy.isShowing())) {
            c.this.nmy.dismiss();
          }
          a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72951);
        }
      });
    }
  }
  
  public final void ijr()
  {
    AppMethodBeat.i(72956);
    if ((this.nmy != null) && (this.nmy.isShowing())) {
      ijt();
    }
    AppMethodBeat.o(72956);
  }
  
  public final void ijs()
  {
    AppMethodBeat.i(72957);
    if (this.YWS != null) {
      this.YWS.setVisibility(0);
    }
    AppMethodBeat.o(72957);
  }
  
  public final void ox(String paramString1, String paramString2)
  {
    this.GEL = paramString1;
    this.GBR = paramString2;
  }
  
  public final void release()
  {
    AppMethodBeat.i(72953);
    if ((this.nmy != null) && (this.nmy.isShowing())) {
      this.nmy.dismiss();
    }
    g.X(this.tzE);
    g.bJ(this.tzL);
    this.tzL.clear();
    this.tmY = null;
    AppMethodBeat.o(72953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.c
 * JD-Core Version:    0.7.0.1
 */