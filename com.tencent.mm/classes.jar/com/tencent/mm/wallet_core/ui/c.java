package com.tencent.mm.wallet_core.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class c
{
  ViewGroup AYw;
  private boolean AYx;
  public o gMK;
  private ImageView gML;
  private View gMM;
  private View.OnClickListener gMO;
  private MMActivity jpX;
  public boolean ktM;
  private Bitmap kxE;
  private View kxH;
  private ImageView kxI;
  private MMVerticalTextView kxJ;
  private ArrayList<Bitmap> kxL;
  private String pkz;
  public Bitmap pmD;
  public Bitmap pmE;
  private String pmZ;
  
  public c(MMActivity paramMMActivity)
  {
    this(paramMMActivity, false);
  }
  
  public c(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(49231);
    this.pmD = null;
    this.pmE = null;
    this.kxE = null;
    this.pmZ = "";
    this.pkz = "";
    this.ktM = true;
    this.kxL = new ArrayList();
    this.gMK = null;
    this.AYx = false;
    this.gMO = new c.1(this);
    this.jpX = paramMMActivity;
    this.AYx = paramBoolean;
    AppMethodBeat.o(49231);
  }
  
  private void ber()
  {
    AppMethodBeat.i(49238);
    if (this.kxL.size() >= 2)
    {
      int i = this.kxL.size() - 1;
      while (i > 1)
      {
        e.I((Bitmap)this.kxL.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(49238);
  }
  
  private void dSR()
  {
    AppMethodBeat.i(49237);
    if (this.ktM)
    {
      this.kxI.setOnClickListener(this.gMO);
      Bitmap localBitmap = this.kxE;
      if (this.pmE != null)
      {
        this.kxE = e.H(this.pmE);
        ab.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp != null");
      }
      for (;;)
      {
        this.kxI.setImageBitmap(this.kxE);
        this.kxL.add(0, localBitmap);
        ber();
        this.gMM.setVisibility(8);
        this.kxH.setVisibility(0);
        this.kxJ.setText(e.awh(this.pkz));
        this.gMK.update();
        AppMethodBeat.o(49237);
        return;
        this.kxE = null;
        ab.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp == null");
      }
    }
    this.gML.setOnClickListener(this.gMO);
    this.gML.setImageBitmap(this.pmD);
    if (this.pmD != null) {
      ab.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp != null");
    }
    for (;;)
    {
      this.gMM.setVisibility(0);
      this.kxH.setVisibility(8);
      break;
      ab.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp == null");
    }
  }
  
  public final void H(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(49234);
    this.ktM = paramBoolean;
    if ((this.gMK != null) && (!this.gMK.isShowing()))
    {
      this.gMK.showAtLocation(paramView.getRootView(), 17, 0, 0);
      this.gMK.setFocusable(true);
      this.gMK.setTouchable(true);
      this.gMK.setBackgroundDrawable(new ColorDrawable(16777215));
      this.gMK.setOutsideTouchable(true);
      if (this.ktM) {
        dSQ();
      }
      dSR();
    }
    AppMethodBeat.o(49234);
  }
  
  public final void dSO()
  {
    AppMethodBeat.i(49233);
    if (this.gMK != null)
    {
      AppMethodBeat.o(49233);
      return;
    }
    View localView;
    if (this.AYx)
    {
      localView = View.inflate(this.jpX, 2130971214, null);
      MMVerticalTextView localMMVerticalTextView = (MMVerticalTextView)localView.findViewById(2131829248);
      this.AYw = ((ViewGroup)localView.findViewById(2131829247));
      localMMVerticalTextView.setOnClickListener(new c.2(this));
      localView.findViewById(2131829245).setOnClickListener(new c.3(this));
    }
    for (;;)
    {
      this.gMM = localView.findViewById(2131822317);
      this.gML = ((ImageView)localView.findViewById(2131822318));
      this.kxH = localView.findViewById(2131822321);
      this.kxI = ((ImageView)localView.findViewById(2131822324));
      this.kxJ = ((MMVerticalTextView)localView.findViewById(2131822323));
      this.gMK = new o(localView, -1, -1, true);
      this.gMK.setClippingEnabled(false);
      this.gMK.update();
      this.gMK.setBackgroundDrawable(new ColorDrawable(16777215));
      this.gMK.setOnDismissListener(new c.5(this));
      AppMethodBeat.o(49233);
      return;
      localView = View.inflate(this.jpX, 2130971217, null);
      localView.setOnClickListener(new c.4(this));
    }
  }
  
  public final void dSP()
  {
    AppMethodBeat.i(49235);
    if ((this.gMK != null) && (this.gMK.isShowing())) {
      dSR();
    }
    AppMethodBeat.o(49235);
  }
  
  public final void dSQ()
  {
    AppMethodBeat.i(49236);
    if (this.AYw != null) {
      this.AYw.setVisibility(0);
    }
    AppMethodBeat.o(49236);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(49239);
    if ((this.gMK != null) && (this.gMK.isShowing())) {
      this.gMK.dismiss();
    }
    AppMethodBeat.o(49239);
  }
  
  public final void iJ(String paramString1, String paramString2)
  {
    this.pmZ = paramString1;
    this.pkz = paramString2;
  }
  
  public final void release()
  {
    AppMethodBeat.i(49232);
    if ((this.gMK != null) && (this.gMK.isShowing())) {
      this.gMK.dismiss();
    }
    e.I(this.kxE);
    e.at(this.kxL);
    this.kxL.clear();
    this.jpX = null;
    AppMethodBeat.o(49232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.c
 * JD-Core Version:    0.7.0.1
 */