package com.tencent.mm.wallet_core.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class c
{
  ViewGroup LzP;
  private boolean LzQ;
  public o jtC;
  private ImageView jtD;
  private View jtE;
  private View.OnClickListener jtG;
  public boolean oFw;
  private Bitmap oJr;
  private View oJu;
  private ImageView oJv;
  private MMVerticalTextView oJw;
  private ArrayList<Bitmap> oJy;
  private MMActivity owO;
  private String wAi;
  private String wxr;
  public Bitmap wzC;
  public Bitmap wzD;
  
  public c(MMActivity paramMMActivity)
  {
    this(paramMMActivity, false);
  }
  
  public c(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(72952);
    this.wzC = null;
    this.wzD = null;
    this.oJr = null;
    this.wAi = "";
    this.wxr = "";
    this.oFw = true;
    this.oJy = new ArrayList();
    this.jtC = null;
    this.LzQ = false;
    this.jtG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72948);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (((paramAnonymousView.getId() == 2131303350) || (paramAnonymousView.getId() == 2131303346)) && (c.this.jtC != null) && (c.this.jtC.isShowing())) {
          c.this.jtC.dismiss();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72948);
      }
    };
    this.owO = paramMMActivity;
    this.LzQ = paramBoolean;
    AppMethodBeat.o(72952);
  }
  
  private void fRY()
  {
    AppMethodBeat.i(72958);
    if (this.oFw)
    {
      this.oJv.setOnClickListener(this.jtG);
      Bitmap localBitmap = this.oJr;
      if (this.wzD != null)
      {
        this.oJr = e.S(this.wzD);
        ad.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp != null");
      }
      for (;;)
      {
        this.oJv.setImageBitmap(this.oJr);
        this.oJy.add(0, localBitmap);
        recycleBmpList();
        this.jtE.setVisibility(8);
        this.oJu.setVisibility(0);
        this.oJw.setText(e.aYM(this.wxr));
        this.jtC.update();
        AppMethodBeat.o(72958);
        return;
        this.oJr = null;
        ad.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp == null");
      }
    }
    this.jtD.setOnClickListener(this.jtG);
    this.jtD.setImageBitmap(this.wzC);
    if (this.wzC != null) {
      ad.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp != null");
    }
    for (;;)
    {
      this.jtE.setVisibility(0);
      this.oJu.setVisibility(8);
      break;
      ad.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp == null");
    }
  }
  
  private void recycleBmpList()
  {
    AppMethodBeat.i(72959);
    if (this.oJy.size() >= 2)
    {
      int i = this.oJy.size() - 1;
      while (i > 1)
      {
        e.T((Bitmap)this.oJy.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(72959);
  }
  
  public final void N(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(72955);
    this.oFw = paramBoolean;
    if ((this.jtC != null) && (!this.jtC.isShowing()))
    {
      this.jtC.showAtLocation(paramView.getRootView(), 17, 0, 0);
      this.jtC.setFocusable(true);
      this.jtC.setTouchable(true);
      this.jtC.setBackgroundDrawable(new ColorDrawable(16777215));
      this.jtC.setOutsideTouchable(true);
      if (this.oFw) {
        fRX();
      }
      fRY();
    }
    AppMethodBeat.o(72955);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(72960);
    if ((this.jtC != null) && (this.jtC.isShowing())) {
      this.jtC.dismiss();
    }
    AppMethodBeat.o(72960);
  }
  
  public final void fRV()
  {
    AppMethodBeat.i(72954);
    if (this.jtC != null)
    {
      AppMethodBeat.o(72954);
      return;
    }
    View localView;
    if (this.LzQ)
    {
      localView = View.inflate(this.owO, 2131495991, null);
      MMVerticalTextView localMMVerticalTextView = (MMVerticalTextView)localView.findViewById(2131302163);
      this.LzP = ((ViewGroup)localView.findViewById(2131303349));
      localMMVerticalTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72949);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.d("MicroMsg.OfflinePopupWindow", "on click know");
          c.this.LzP.setVisibility(8);
          paramAnonymousView = new cw();
          paramAnonymousView.dnP.dnQ = 1;
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72949);
        }
      });
      localView.findViewById(2131303348).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72950);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.d("MicroMsg.OfflinePopupWindow", "root on click");
          if ((c.this.jtC != null) && (c.this.jtC.isShowing())) {
            c.this.jtC.dismiss();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72950);
        }
      });
    }
    for (;;)
    {
      this.jtE = localView.findViewById(2131303351);
      this.jtD = ((ImageView)localView.findViewById(2131303350));
      this.oJu = localView.findViewById(2131303347);
      this.oJv = ((ImageView)localView.findViewById(2131303346));
      this.oJw = ((MMVerticalTextView)localView.findViewById(2131306295));
      this.jtC = new o(localView, -1, -1, true);
      this.jtC.setClippingEnabled(false);
      this.jtC.update();
      this.jtC.setBackgroundDrawable(new ColorDrawable(16777215));
      this.jtC.setOnDismissListener(new PopupWindow.OnDismissListener()
      {
        public final void onDismiss() {}
      });
      AppMethodBeat.o(72954);
      return;
      localView = View.inflate(this.owO, 2131495994, null);
      localView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72951);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if ((c.this.jtC != null) && (c.this.jtC.isShowing())) {
            c.this.jtC.dismiss();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72951);
        }
      });
    }
  }
  
  public final void fRW()
  {
    AppMethodBeat.i(72956);
    if ((this.jtC != null) && (this.jtC.isShowing())) {
      fRY();
    }
    AppMethodBeat.o(72956);
  }
  
  public final void fRX()
  {
    AppMethodBeat.i(72957);
    if (this.LzP != null) {
      this.LzP.setVisibility(0);
    }
    AppMethodBeat.o(72957);
  }
  
  public final void mF(String paramString1, String paramString2)
  {
    this.wAi = paramString1;
    this.wxr = paramString2;
  }
  
  public final void release()
  {
    AppMethodBeat.i(72953);
    if ((this.jtC != null) && (this.jtC.isShowing())) {
      this.jtC.dismiss();
    }
    e.T(this.oJr);
    e.aZ(this.oJy);
    this.oJy.clear();
    this.owO = null;
    AppMethodBeat.o(72953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.c
 * JD-Core Version:    0.7.0.1
 */