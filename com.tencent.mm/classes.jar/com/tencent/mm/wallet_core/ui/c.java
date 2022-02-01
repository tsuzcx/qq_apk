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
import com.tencent.mm.g.a.da;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;

public final class c
{
  private String AII;
  public Bitmap AKT;
  public Bitmap AKU;
  private String ALA;
  ViewGroup Rvu;
  private boolean Rvv;
  public p kuK;
  private ImageView kuL;
  private View kuM;
  private View.OnClickListener kuO;
  MMActivity pQZ;
  public boolean pZM;
  private Bitmap qdH;
  private View qdK;
  private ImageView qdL;
  private MMVerticalTextView qdM;
  private ArrayList<Bitmap> qdO;
  
  public c(MMActivity paramMMActivity)
  {
    this(paramMMActivity, false);
  }
  
  public c(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(72952);
    this.AKT = null;
    this.AKU = null;
    this.qdH = null;
    this.ALA = "";
    this.AII = "";
    this.pZM = true;
    this.qdO = new ArrayList();
    this.kuK = null;
    this.Rvv = false;
    this.kuO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72948);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (((paramAnonymousView.getId() == 2131306037) || (paramAnonymousView.getId() == 2131306033)) && (c.this.kuK != null) && (c.this.kuK.isShowing())) {
          c.this.kuK.dismiss();
        }
        a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72948);
      }
    };
    this.pQZ = paramMMActivity;
    this.Rvv = paramBoolean;
    AppMethodBeat.o(72952);
  }
  
  private void hhS()
  {
    AppMethodBeat.i(72958);
    if (this.pZM)
    {
      this.qdL.setOnClickListener(this.kuO);
      Bitmap localBitmap = this.qdH;
      if (this.AKU != null)
      {
        this.qdH = f.Y(this.AKU);
        Log.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp != null");
      }
      for (;;)
      {
        this.qdL.setImageBitmap(this.qdH);
        this.qdO.add(0, localBitmap);
        recycleBmpList();
        this.kuM.setVisibility(8);
        this.qdK.setVisibility(0);
        this.qdM.setText(f.bpx(this.AII));
        this.kuK.update();
        AppMethodBeat.o(72958);
        return;
        this.qdH = null;
        Log.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp == null");
      }
    }
    this.kuL.setOnClickListener(this.kuO);
    this.kuL.setImageBitmap(this.AKT);
    if (this.AKT != null) {
      Log.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp != null");
    }
    for (;;)
    {
      this.kuM.setVisibility(0);
      this.qdK.setVisibility(8);
      break;
      Log.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp == null");
    }
  }
  
  private void recycleBmpList()
  {
    AppMethodBeat.i(72959);
    if (this.qdO.size() >= 2)
    {
      int i = this.qdO.size() - 1;
      while (i > 1)
      {
        f.Z((Bitmap)this.qdO.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(72959);
  }
  
  public final void aa(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(72955);
    this.pZM = paramBoolean;
    if ((this.kuK != null) && (!this.kuK.isShowing()))
    {
      this.kuK.showAtLocation(paramView.getRootView(), 17, 0, 0);
      this.kuK.setFocusable(true);
      this.kuK.setTouchable(true);
      this.kuK.setBackgroundDrawable(new ColorDrawable(16777215));
      this.kuK.setOutsideTouchable(true);
      if (this.pZM) {
        hhR();
      }
      hhS();
      this.pQZ.getWindow().addFlags(1024);
    }
    AppMethodBeat.o(72955);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(72960);
    if ((this.kuK != null) && (this.kuK.isShowing())) {
      this.kuK.dismiss();
    }
    AppMethodBeat.o(72960);
  }
  
  public final void hhP()
  {
    AppMethodBeat.i(72954);
    if (this.kuK != null)
    {
      AppMethodBeat.o(72954);
      return;
    }
    View localView;
    if (this.Rvv)
    {
      localView = View.inflate(this.pQZ, 2131496971, null);
      MMVerticalTextView localMMVerticalTextView = (MMVerticalTextView)localView.findViewById(2131304505);
      localMMVerticalTextView.setMediumBold(true);
      this.Rvu = ((ViewGroup)localView.findViewById(2131306036));
      localMMVerticalTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72949);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.d("MicroMsg.OfflinePopupWindow", "on click know");
          c.this.Rvu.setVisibility(8);
          paramAnonymousView = new da();
          paramAnonymousView.dGj.dGk = 1;
          EventCenter.instance.publish(paramAnonymousView);
          a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72949);
        }
      });
      localView.findViewById(2131306035).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72950);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.d("MicroMsg.OfflinePopupWindow", "root on click");
          if ((c.this.kuK != null) && (c.this.kuK.isShowing())) {
            c.this.kuK.dismiss();
          }
          a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72950);
        }
      });
    }
    for (;;)
    {
      this.kuM = localView.findViewById(2131306038);
      this.kuL = ((ImageView)localView.findViewById(2131306037));
      this.qdK = localView.findViewById(2131306034);
      this.qdL = ((ImageView)localView.findViewById(2131306033));
      this.qdM = ((MMVerticalTextView)localView.findViewById(2131309708));
      this.kuK = new p(localView, -1, -1, true);
      this.kuK.setClippingEnabled(false);
      this.kuK.update();
      this.kuK.setBackgroundDrawable(new ColorDrawable(16777215));
      this.kuK.setOnDismissListener(new PopupWindow.OnDismissListener()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(214336);
          c.this.pQZ.getWindow().clearFlags(1024);
          AppMethodBeat.o(214336);
        }
      });
      AppMethodBeat.o(72954);
      return;
      localView = View.inflate(this.pQZ, 2131496974, null);
      localView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72951);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if ((c.this.kuK != null) && (c.this.kuK.isShowing())) {
            c.this.kuK.dismiss();
          }
          a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72951);
        }
      });
    }
  }
  
  public final void hhQ()
  {
    AppMethodBeat.i(72956);
    if ((this.kuK != null) && (this.kuK.isShowing())) {
      hhS();
    }
    AppMethodBeat.o(72956);
  }
  
  public final void hhR()
  {
    AppMethodBeat.i(72957);
    if (this.Rvu != null) {
      this.Rvu.setVisibility(0);
    }
    AppMethodBeat.o(72957);
  }
  
  public final void nC(String paramString1, String paramString2)
  {
    this.ALA = paramString1;
    this.AII = paramString2;
  }
  
  public final void release()
  {
    AppMethodBeat.i(72953);
    if ((this.kuK != null) && (this.kuK.isShowing())) {
      this.kuK.dismiss();
    }
    f.Z(this.qdH);
    f.bu(this.qdO);
    this.qdO.clear();
    this.pQZ = null;
    AppMethodBeat.o(72953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.c
 * JD-Core Version:    0.7.0.1
 */