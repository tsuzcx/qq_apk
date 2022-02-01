package com.tencent.mm.wallet_core.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class c
{
  ViewGroup LWE;
  private boolean LWF;
  private View.OnClickListener jwB;
  public o jwx;
  private ImageView jwy;
  private View jwz;
  private MMActivity oDq;
  public boolean oLY;
  private Bitmap oPT;
  private View oPW;
  private ImageView oPX;
  private MMVerticalTextView oPY;
  private ArrayList<Bitmap> oQa;
  private String wNc;
  private String wPT;
  public Bitmap wPn;
  public Bitmap wPo;
  
  public c(MMActivity paramMMActivity)
  {
    this(paramMMActivity, false);
  }
  
  public c(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(72952);
    this.wPn = null;
    this.wPo = null;
    this.oPT = null;
    this.wPT = "";
    this.wNc = "";
    this.oLY = true;
    this.oQa = new ArrayList();
    this.jwx = null;
    this.LWF = false;
    this.jwB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72948);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (((paramAnonymousView.getId() == 2131303350) || (paramAnonymousView.getId() == 2131303346)) && (c.this.jwx != null) && (c.this.jwx.isShowing())) {
          c.this.jwx.dismiss();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72948);
      }
    };
    this.oDq = paramMMActivity;
    this.LWF = paramBoolean;
    AppMethodBeat.o(72952);
  }
  
  private void fWu()
  {
    AppMethodBeat.i(72958);
    if (this.oLY)
    {
      this.oPX.setOnClickListener(this.jwB);
      Bitmap localBitmap = this.oPT;
      if (this.wPo != null)
      {
        this.oPT = f.T(this.wPo);
        ae.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp != null");
      }
      for (;;)
      {
        this.oPX.setImageBitmap(this.oPT);
        this.oQa.add(0, localBitmap);
        recycleBmpList();
        this.jwz.setVisibility(8);
        this.oPW.setVisibility(0);
        this.oPY.setText(f.bap(this.wNc));
        this.jwx.update();
        AppMethodBeat.o(72958);
        return;
        this.oPT = null;
        ae.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp == null");
      }
    }
    this.jwy.setOnClickListener(this.jwB);
    this.jwy.setImageBitmap(this.wPn);
    if (this.wPn != null) {
      ae.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp != null");
    }
    for (;;)
    {
      this.jwz.setVisibility(0);
      this.oPW.setVisibility(8);
      break;
      ae.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp == null");
    }
  }
  
  private void recycleBmpList()
  {
    AppMethodBeat.i(72959);
    if (this.oQa.size() >= 2)
    {
      int i = this.oQa.size() - 1;
      while (i > 1)
      {
        f.U((Bitmap)this.oQa.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(72959);
  }
  
  public final void S(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(72955);
    this.oLY = paramBoolean;
    if ((this.jwx != null) && (!this.jwx.isShowing()))
    {
      this.jwx.showAtLocation(paramView.getRootView(), 17, 0, 0);
      this.jwx.setFocusable(true);
      this.jwx.setTouchable(true);
      this.jwx.setBackgroundDrawable(new ColorDrawable(16777215));
      this.jwx.setOutsideTouchable(true);
      if (this.oLY) {
        fWt();
      }
      fWu();
    }
    AppMethodBeat.o(72955);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(72960);
    if ((this.jwx != null) && (this.jwx.isShowing())) {
      this.jwx.dismiss();
    }
    AppMethodBeat.o(72960);
  }
  
  public final void fWr()
  {
    AppMethodBeat.i(72954);
    if (this.jwx != null)
    {
      AppMethodBeat.o(72954);
      return;
    }
    View localView;
    if (this.LWF)
    {
      localView = View.inflate(this.oDq, 2131495991, null);
      MMVerticalTextView localMMVerticalTextView = (MMVerticalTextView)localView.findViewById(2131302163);
      this.LWE = ((ViewGroup)localView.findViewById(2131303349));
      localMMVerticalTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72949);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.d("MicroMsg.OfflinePopupWindow", "on click know");
          c.this.LWE.setVisibility(8);
          paramAnonymousView = new cx();
          paramAnonymousView.doU.doV = 1;
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.d("MicroMsg.OfflinePopupWindow", "root on click");
          if ((c.this.jwx != null) && (c.this.jwx.isShowing())) {
            c.this.jwx.dismiss();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72950);
        }
      });
    }
    for (;;)
    {
      this.jwz = localView.findViewById(2131303351);
      this.jwy = ((ImageView)localView.findViewById(2131303350));
      this.oPW = localView.findViewById(2131303347);
      this.oPX = ((ImageView)localView.findViewById(2131303346));
      this.oPY = ((MMVerticalTextView)localView.findViewById(2131306295));
      this.jwx = new o(localView, -1, -1, true);
      this.jwx.setClippingEnabled(false);
      this.jwx.update();
      this.jwx.setBackgroundDrawable(new ColorDrawable(16777215));
      this.jwx.setOnDismissListener(new PopupWindow.OnDismissListener()
      {
        public final void onDismiss() {}
      });
      AppMethodBeat.o(72954);
      return;
      localView = View.inflate(this.oDq, 2131495994, null);
      localView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72951);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if ((c.this.jwx != null) && (c.this.jwx.isShowing())) {
            c.this.jwx.dismiss();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72951);
        }
      });
    }
  }
  
  public final void fWs()
  {
    AppMethodBeat.i(72956);
    if ((this.jwx != null) && (this.jwx.isShowing())) {
      fWu();
    }
    AppMethodBeat.o(72956);
  }
  
  public final void fWt()
  {
    AppMethodBeat.i(72957);
    if (this.LWE != null) {
      this.LWE.setVisibility(0);
    }
    AppMethodBeat.o(72957);
  }
  
  public final void mL(String paramString1, String paramString2)
  {
    this.wPT = paramString1;
    this.wNc = paramString2;
  }
  
  public final void release()
  {
    AppMethodBeat.i(72953);
    if ((this.jwx != null) && (this.jwx.isShowing())) {
      this.jwx.dismiss();
    }
    f.U(this.oPT);
    f.ba(this.oQa);
    this.oQa.clear();
    this.oDq = null;
    AppMethodBeat.o(72953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.c
 * JD-Core Version:    0.7.0.1
 */