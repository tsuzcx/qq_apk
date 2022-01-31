package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class k
{
  long createTime;
  String czp;
  String fileId;
  public int mPosition;
  public TextView mzS;
  public View ngZ;
  int rxA;
  public c zKg;
  public ProgressBar zNA;
  public ProgressBar zNB;
  public LinearLayout zNC;
  public TextView zND;
  public ImageView zNE;
  public MultiTouchImageView zNF;
  public WxImageView zNG;
  public MultiTouchImageView zNH;
  public boolean zNI;
  int zNJ;
  int zNK;
  public c.b zNi;
  public HashMap<String, Boolean> zNj;
  public RelativeLayout zNk;
  public e zNl;
  public ImageView zNm;
  public ImageView zNn;
  public MMPinProgressBtn zNo;
  public View zNp;
  public RelativeLayout zNq;
  public ImageView zNr;
  public ImageView zNs;
  public e zNt;
  public MMPinProgressBtn zNu;
  public TextView zNv;
  public LinearLayout zNw;
  public TextView zNx;
  public TextView zNy;
  public ImageView zNz;
  
  @TargetApi(11)
  public k(c paramc, View paramView)
  {
    AppMethodBeat.i(32392);
    this.zNj = new HashMap();
    this.rxA = 0;
    this.zNJ = 0;
    this.zNK = 0;
    this.czp = "";
    this.ngZ = paramView;
    this.zKg = paramc;
    this.zNF = ((MultiTouchImageView)paramView.findViewById(2131820629));
    this.zNG = ((WxImageView)paramView.findViewById(2131825112));
    this.zNH = ((MultiTouchImageView)paramView.findViewById(2131825113));
    this.zNB = ((ProgressBar)paramView.findViewById(2131825116));
    if (this.zNG != null) {
      this.zNG.setForceTileFlag(com.tencent.mm.graphics.a.c.eAE);
    }
    if ((com.tencent.mm.compatible.util.d.fv(11)) && (paramView.getLayerType() != 2)) {
      paramView.setLayerType(2, null);
    }
    AppMethodBeat.o(32392);
  }
  
  public static void aq(View paramView, int paramInt)
  {
    AppMethodBeat.i(32393);
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(32393);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, long paramLong)
  {
    this.rxA = paramInt1;
    this.zNJ = paramInt2;
    this.zNK = paramInt3;
    this.czp = paramString1;
    this.fileId = paramString2;
    this.createTime = paramLong;
  }
  
  public final void a(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(32398);
    ab.i("MicroMsg.ImageGalleryViewHolder", "%d switch video model isVideoPlay[%b] alpha[%f]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
    if (paramBoolean)
    {
      View localView = (View)dKP().zNt;
      localView.setAlpha(paramFloat);
      aq(localView, 0);
      if (paramFloat >= 1.0D)
      {
        aq(dKP().zNr, 8);
        aq(dKP().zNs, 8);
      }
      AppMethodBeat.o(32398);
      return;
    }
    aq((View)dKP().zNt, 8);
    aq(dKP().zNr, 0);
    aq(dKP().zNs, 0);
    AppMethodBeat.o(32398);
  }
  
  public final k dKM()
  {
    AppMethodBeat.i(32394);
    if (this.zNw == null)
    {
      this.zNw = ((LinearLayout)((ViewStub)this.ngZ.findViewById(2131825114)).inflate());
      this.zNA = ((ProgressBar)this.zNw.findViewById(2131822683));
      this.zNx = ((TextView)this.zNw.findViewById(2131824027));
      this.zNy = ((TextView)this.zNw.findViewById(2131825118));
      this.zNz = ((ImageView)this.zNw.findViewById(2131825117));
    }
    AppMethodBeat.o(32394);
    return this;
  }
  
  public final k dKN()
  {
    AppMethodBeat.i(32395);
    if (this.zNC == null)
    {
      this.zNC = ((LinearLayout)((ViewStub)this.ngZ.findViewById(2131825115)).inflate());
      this.zNE = ((ImageView)this.zNC.findViewById(2131825119));
      this.zND = ((TextView)this.zNC.findViewById(2131823463));
    }
    AppMethodBeat.o(32395);
    return this;
  }
  
  public final k dKO()
  {
    AppMethodBeat.i(32396);
    if (this.zNk == null)
    {
      this.zNk = ((RelativeLayout)((ViewStub)this.ngZ.findViewById(2131825111)).inflate());
      this.zNl = q.ga(this.ngZ.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      this.zNk.addView((View)this.zNl, localLayoutParams);
      ((View)this.zNl).setVisibility(8);
      this.zNp = this.zNk.findViewById(2131823916);
      this.zNp.setVisibility(8);
      this.mzS = ((TextView)this.zNk.findViewById(2131827797));
      this.zNo = ((MMPinProgressBtn)this.zNk.findViewById(2131827771));
      this.zNo.setVisibility(8);
      this.zNm = ((ImageView)this.zNk.findViewById(2131827770));
      this.zNn = ((ImageView)this.zNk.findViewById(2131827772));
      this.zNl.setVideoCallback(new k.1(this));
      this.mzS.setOnClickListener(new k.2(this));
    }
    AppMethodBeat.o(32396);
    return this;
  }
  
  public final k dKP()
  {
    AppMethodBeat.i(32397);
    if (this.zNq == null)
    {
      if (this.zNG != null) {
        this.zNG.setVisibility(8);
      }
      if (this.zNF != null) {
        this.zNF.setVisibility(8);
      }
      this.zNq = ((RelativeLayout)((ViewStub)this.ngZ.findViewById(2131822190)).inflate());
      this.zNr = ((ImageView)this.zNq.findViewById(2131825121));
      this.zNs = ((ImageView)this.zNq.findViewById(2131825122));
      this.zNs.setOnClickListener(new k.3(this));
      com.tencent.mm.modelcontrol.d.afW();
      if (!com.tencent.mm.modelcontrol.d.agf()) {
        break label275;
      }
      this.zNt = new VideoPlayerTextureView(this.ngZ.getContext());
      h.qsU.idkeyStat(354L, 150L, 1L, false);
    }
    for (;;)
    {
      this.zNv = ((TextView)this.ngZ.findViewById(2131825110));
      this.zNt.setPlayProgressCallback(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.zNq.addView((View)this.zNt, 2, localLayoutParams);
      this.zNu = ((MMPinProgressBtn)this.zNq.findViewById(2131825123));
      this.zNu.setVisibility(8);
      ((View)this.zNt).setVisibility(8);
      this.zNt.setVideoCallback(new k.4(this));
      AppMethodBeat.o(32397);
      return this;
      label275:
      this.zNt = new VideoTextureView(this.ngZ.getContext());
      h.qsU.idkeyStat(354L, 151L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k
 * JD-Core Version:    0.7.0.1
 */