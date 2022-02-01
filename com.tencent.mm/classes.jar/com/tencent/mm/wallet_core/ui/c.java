package com.tencent.mm.wallet_core.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ct;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class c
{
  ViewGroup JGL;
  private boolean JGM;
  public o jat;
  private ImageView jau;
  private View jav;
  private View.OnClickListener jax;
  private MMActivity nTt;
  public boolean ocd;
  private Bitmap ofY;
  private View ogb;
  private ImageView ogc;
  private MMVerticalTextView ogd;
  private ArrayList<Bitmap> ogf;
  private String vrZ;
  private String vuP;
  public Bitmap vuj;
  public Bitmap vuk;
  
  public c(MMActivity paramMMActivity)
  {
    this(paramMMActivity, false);
  }
  
  public c(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(72952);
    this.vuj = null;
    this.vuk = null;
    this.ofY = null;
    this.vuP = "";
    this.vrZ = "";
    this.ocd = true;
    this.ogf = new ArrayList();
    this.jat = null;
    this.JGM = false;
    this.jax = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72948);
        if (((paramAnonymousView.getId() == 2131303350) || (paramAnonymousView.getId() == 2131303346)) && (c.this.jat != null) && (c.this.jat.isShowing())) {
          c.this.jat.dismiss();
        }
        AppMethodBeat.o(72948);
      }
    };
    this.nTt = paramMMActivity;
    this.JGM = paramBoolean;
    AppMethodBeat.o(72952);
  }
  
  private void fAO()
  {
    AppMethodBeat.i(72958);
    if (this.ocd)
    {
      this.ogc.setOnClickListener(this.jax);
      Bitmap localBitmap = this.ofY;
      if (this.vuk != null)
      {
        this.ofY = e.S(this.vuk);
        ac.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp != null");
      }
      for (;;)
      {
        this.ogc.setImageBitmap(this.ofY);
        this.ogf.add(0, localBitmap);
        recycleBmpList();
        this.jav.setVisibility(8);
        this.ogb.setVisibility(0);
        this.ogd.setText(e.aSN(this.vrZ));
        this.jat.update();
        AppMethodBeat.o(72958);
        return;
        this.ofY = null;
        ac.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp == null");
      }
    }
    this.jau.setOnClickListener(this.jax);
    this.jau.setImageBitmap(this.vuj);
    if (this.vuj != null) {
      ac.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp != null");
    }
    for (;;)
    {
      this.jav.setVisibility(0);
      this.ogb.setVisibility(8);
      break;
      ac.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp == null");
    }
  }
  
  private void recycleBmpList()
  {
    AppMethodBeat.i(72959);
    if (this.ogf.size() >= 2)
    {
      int i = this.ogf.size() - 1;
      while (i > 1)
      {
        e.T((Bitmap)this.ogf.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(72959);
  }
  
  public final void M(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(72955);
    this.ocd = paramBoolean;
    if ((this.jat != null) && (!this.jat.isShowing()))
    {
      this.jat.showAtLocation(paramView.getRootView(), 17, 0, 0);
      this.jat.setFocusable(true);
      this.jat.setTouchable(true);
      this.jat.setBackgroundDrawable(new ColorDrawable(16777215));
      this.jat.setOutsideTouchable(true);
      if (this.ocd) {
        fAN();
      }
      fAO();
    }
    AppMethodBeat.o(72955);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(72960);
    if ((this.jat != null) && (this.jat.isShowing())) {
      this.jat.dismiss();
    }
    AppMethodBeat.o(72960);
  }
  
  public final void fAL()
  {
    AppMethodBeat.i(72954);
    if (this.jat != null)
    {
      AppMethodBeat.o(72954);
      return;
    }
    View localView;
    if (this.JGM)
    {
      localView = View.inflate(this.nTt, 2131495991, null);
      MMVerticalTextView localMMVerticalTextView = (MMVerticalTextView)localView.findViewById(2131302163);
      this.JGL = ((ViewGroup)localView.findViewById(2131303349));
      localMMVerticalTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72949);
          ac.d("MicroMsg.OfflinePopupWindow", "on click know");
          c.this.JGL.setVisibility(8);
          paramAnonymousView = new ct();
          paramAnonymousView.dct.dcu = 1;
          a.GpY.l(paramAnonymousView);
          AppMethodBeat.o(72949);
        }
      });
      localView.findViewById(2131303348).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72950);
          ac.d("MicroMsg.OfflinePopupWindow", "root on click");
          if ((c.this.jat != null) && (c.this.jat.isShowing())) {
            c.this.jat.dismiss();
          }
          AppMethodBeat.o(72950);
        }
      });
    }
    for (;;)
    {
      this.jav = localView.findViewById(2131303351);
      this.jau = ((ImageView)localView.findViewById(2131303350));
      this.ogb = localView.findViewById(2131303347);
      this.ogc = ((ImageView)localView.findViewById(2131303346));
      this.ogd = ((MMVerticalTextView)localView.findViewById(2131306295));
      this.jat = new o(localView, -1, -1, true);
      this.jat.setClippingEnabled(false);
      this.jat.update();
      this.jat.setBackgroundDrawable(new ColorDrawable(16777215));
      this.jat.setOnDismissListener(new PopupWindow.OnDismissListener()
      {
        public final void onDismiss() {}
      });
      AppMethodBeat.o(72954);
      return;
      localView = View.inflate(this.nTt, 2131495994, null);
      localView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72951);
          if ((c.this.jat != null) && (c.this.jat.isShowing())) {
            c.this.jat.dismiss();
          }
          AppMethodBeat.o(72951);
        }
      });
    }
  }
  
  public final void fAM()
  {
    AppMethodBeat.i(72956);
    if ((this.jat != null) && (this.jat.isShowing())) {
      fAO();
    }
    AppMethodBeat.o(72956);
  }
  
  public final void fAN()
  {
    AppMethodBeat.i(72957);
    if (this.JGL != null) {
      this.JGL.setVisibility(0);
    }
    AppMethodBeat.o(72957);
  }
  
  public final void mh(String paramString1, String paramString2)
  {
    this.vuP = paramString1;
    this.vrZ = paramString2;
  }
  
  public final void release()
  {
    AppMethodBeat.i(72953);
    if ((this.jat != null) && (this.jat.isShowing())) {
      this.jat.dismiss();
    }
    e.T(this.ofY);
    e.bc(this.ogf);
    this.ogf.clear();
    this.nTt = null;
    AppMethodBeat.o(72953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.c
 * JD-Core Version:    0.7.0.1
 */