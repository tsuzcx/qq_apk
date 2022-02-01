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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class c
{
  ViewGroup Ifj;
  private boolean Ifk;
  public o iAs;
  private ImageView iAt;
  private View iAu;
  private View.OnClickListener iAw;
  private Bitmap nCX;
  private View nDa;
  private ImageView nDb;
  private MMVerticalTextView nDc;
  private ArrayList<Bitmap> nDe;
  private MMActivity nqt;
  public boolean nzc;
  private String ujd;
  private String ulT;
  public Bitmap uln;
  public Bitmap ulo;
  
  public c(MMActivity paramMMActivity)
  {
    this(paramMMActivity, false);
  }
  
  public c(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(72952);
    this.uln = null;
    this.ulo = null;
    this.nCX = null;
    this.ulT = "";
    this.ujd = "";
    this.nzc = true;
    this.nDe = new ArrayList();
    this.iAs = null;
    this.Ifk = false;
    this.iAw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72948);
        if (((paramAnonymousView.getId() == 2131303350) || (paramAnonymousView.getId() == 2131303346)) && (c.this.iAs != null) && (c.this.iAs.isShowing())) {
          c.this.iAs.dismiss();
        }
        AppMethodBeat.o(72948);
      }
    };
    this.nqt = paramMMActivity;
    this.Ifk = paramBoolean;
    AppMethodBeat.o(72952);
  }
  
  private void fky()
  {
    AppMethodBeat.i(72958);
    if (this.nzc)
    {
      this.nDb.setOnClickListener(this.iAw);
      Bitmap localBitmap = this.nCX;
      if (this.ulo != null)
      {
        this.nCX = e.S(this.ulo);
        ad.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp != null");
      }
      for (;;)
      {
        this.nDb.setImageBitmap(this.nCX);
        this.nDe.add(0, localBitmap);
        recycleBmpList();
        this.iAu.setVisibility(8);
        this.nDa.setVisibility(0);
        this.nDc.setText(e.aNk(this.ujd));
        this.iAs.update();
        AppMethodBeat.o(72958);
        return;
        this.nCX = null;
        ad.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp == null");
      }
    }
    this.iAt.setOnClickListener(this.iAw);
    this.iAt.setImageBitmap(this.uln);
    if (this.uln != null) {
      ad.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp != null");
    }
    for (;;)
    {
      this.iAu.setVisibility(0);
      this.nDa.setVisibility(8);
      break;
      ad.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp == null");
    }
  }
  
  private void recycleBmpList()
  {
    AppMethodBeat.i(72959);
    if (this.nDe.size() >= 2)
    {
      int i = this.nDe.size() - 1;
      while (i > 1)
      {
        e.T((Bitmap)this.nDe.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(72959);
  }
  
  public final void M(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(72955);
    this.nzc = paramBoolean;
    if ((this.iAs != null) && (!this.iAs.isShowing()))
    {
      this.iAs.showAtLocation(paramView.getRootView(), 17, 0, 0);
      this.iAs.setFocusable(true);
      this.iAs.setTouchable(true);
      this.iAs.setBackgroundDrawable(new ColorDrawable(16777215));
      this.iAs.setOutsideTouchable(true);
      if (this.nzc) {
        fkx();
      }
      fky();
    }
    AppMethodBeat.o(72955);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(72960);
    if ((this.iAs != null) && (this.iAs.isShowing())) {
      this.iAs.dismiss();
    }
    AppMethodBeat.o(72960);
  }
  
  public final void fkv()
  {
    AppMethodBeat.i(72954);
    if (this.iAs != null)
    {
      AppMethodBeat.o(72954);
      return;
    }
    View localView;
    if (this.Ifk)
    {
      localView = View.inflate(this.nqt, 2131495991, null);
      MMVerticalTextView localMMVerticalTextView = (MMVerticalTextView)localView.findViewById(2131302163);
      this.Ifj = ((ViewGroup)localView.findViewById(2131303349));
      localMMVerticalTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72949);
          ad.d("MicroMsg.OfflinePopupWindow", "on click know");
          c.this.Ifj.setVisibility(8);
          paramAnonymousView = new ct();
          paramAnonymousView.deZ.dfa = 1;
          a.ESL.l(paramAnonymousView);
          AppMethodBeat.o(72949);
        }
      });
      localView.findViewById(2131303348).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72950);
          ad.d("MicroMsg.OfflinePopupWindow", "root on click");
          if ((c.this.iAs != null) && (c.this.iAs.isShowing())) {
            c.this.iAs.dismiss();
          }
          AppMethodBeat.o(72950);
        }
      });
    }
    for (;;)
    {
      this.iAu = localView.findViewById(2131303351);
      this.iAt = ((ImageView)localView.findViewById(2131303350));
      this.nDa = localView.findViewById(2131303347);
      this.nDb = ((ImageView)localView.findViewById(2131303346));
      this.nDc = ((MMVerticalTextView)localView.findViewById(2131306295));
      this.iAs = new o(localView, -1, -1, true);
      this.iAs.setClippingEnabled(false);
      this.iAs.update();
      this.iAs.setBackgroundDrawable(new ColorDrawable(16777215));
      this.iAs.setOnDismissListener(new PopupWindow.OnDismissListener()
      {
        public final void onDismiss() {}
      });
      AppMethodBeat.o(72954);
      return;
      localView = View.inflate(this.nqt, 2131495994, null);
      localView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72951);
          if ((c.this.iAs != null) && (c.this.iAs.isShowing())) {
            c.this.iAs.dismiss();
          }
          AppMethodBeat.o(72951);
        }
      });
    }
  }
  
  public final void fkw()
  {
    AppMethodBeat.i(72956);
    if ((this.iAs != null) && (this.iAs.isShowing())) {
      fky();
    }
    AppMethodBeat.o(72956);
  }
  
  public final void fkx()
  {
    AppMethodBeat.i(72957);
    if (this.Ifj != null) {
      this.Ifj.setVisibility(0);
    }
    AppMethodBeat.o(72957);
  }
  
  public final void lK(String paramString1, String paramString2)
  {
    this.ulT = paramString1;
    this.ujd = paramString2;
  }
  
  public final void release()
  {
    AppMethodBeat.i(72953);
    if ((this.iAs != null) && (this.iAs.isShowing())) {
      this.iAs.dismiss();
    }
    e.T(this.nCX);
    e.aQ(this.nDe);
    this.nDe.clear();
    this.nqt = null;
    AppMethodBeat.o(72953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.c
 * JD-Core Version:    0.7.0.1
 */