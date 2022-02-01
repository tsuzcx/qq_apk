package com.tencent.mm.plugin.scanner;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.protocal.protobuf.bbr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
import com.tencent.mm.vending.g.d.b;
import java.io.IOException;
import java.util.HashMap;

public class ScanCodeSheetItemLogic
  implements LifecycleObserver
{
  private Context mContext;
  public bbr vLD;
  private a vLE;
  private b vLF;
  public b vLG;
  private HashMap<String, bbr> vLH;
  private MutableLiveData<bbr> vLI;
  private int vLJ;
  
  public ScanCodeSheetItemLogic(Context paramContext)
  {
    AppMethodBeat.i(151569);
    this.vLH = new HashMap();
    this.vLI = new MutableLiveData();
    this.mContext = paramContext;
    AppMethodBeat.o(151569);
  }
  
  public ScanCodeSheetItemLogic(Context paramContext, a parama)
  {
    AppMethodBeat.i(151570);
    this.vLH = new HashMap();
    this.vLI = new MutableLiveData();
    this.mContext = paramContext;
    this.vLE = parama;
    AppMethodBeat.o(151570);
  }
  
  public ScanCodeSheetItemLogic(Context paramContext, b paramb)
  {
    AppMethodBeat.i(151571);
    this.vLH = new HashMap();
    this.vLI = new MutableLiveData();
    this.mContext = paramContext;
    this.vLF = paramb;
    AppMethodBeat.o(151571);
  }
  
  @SuppressLint({"ResourceType"})
  private View a(View.OnClickListener paramOnClickListener, int paramInt, String paramString)
  {
    AppMethodBeat.i(151577);
    Object localObject = new ViewTitleWithAnimation(this.mContext);
    ((ViewTitleWithAnimation)localObject).startLoading();
    ((ViewTitleWithAnimation)localObject).setOnClickListener(paramOnClickListener);
    if (e.bD(paramInt, paramString))
    {
      ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131689516);
      ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762816));
    }
    for (;;)
    {
      AppMethodBeat.o(151577);
      return localObject;
      if (e.bE(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762817));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131233888);
      }
      else if (e.bF(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762820));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131099687);
      }
      else if (e.bG(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762818));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131690016);
      }
      else if (e.bH(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762822));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131099687);
      }
      else if (e.bJ(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762819));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(am.i(this.mContext, 2131690677, this.mContext.getResources().getColor(2131099700)));
      }
      else
      {
        if (!e.bI(paramInt, paramString)) {
          break;
        }
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762821));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(am.i(this.mContext, 2131690336, this.mContext.getResources().getColor(2131099829)));
      }
    }
    paramString = this.mContext.getString(2131762857);
    localObject = new com.tencent.mm.ui.widget.bottomsheet.a(this.mContext);
    ((com.tencent.mm.ui.widget.bottomsheet.a)localObject).setOnClickListener(paramOnClickListener);
    ((com.tencent.mm.ui.widget.bottomsheet.a)localObject).setTitle(paramString);
    AppMethodBeat.o(151577);
    return localObject;
  }
  
  @SuppressLint({"ResourceType"})
  private View d(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(151576);
    ViewTitleWithAnimation localViewTitleWithAnimation = new ViewTitleWithAnimation(this.mContext);
    localViewTitleWithAnimation.hideLoading();
    if ((this.vLD.Ret != 0) || (bt.isNullOrNil(this.vLD.mAQ)))
    {
      localViewTitleWithAnimation.ffh();
      localViewTitleWithAnimation.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(151576);
      return localViewTitleWithAnimation;
    }
    localViewTitleWithAnimation.setTitle(this.vLD.mAQ);
    localViewTitleWithAnimation.setOnClickListener(paramOnClickListener);
    paramOnClickListener = new c.a();
    paramOnClickListener.hjT = true;
    localViewTitleWithAnimation.getIconImageView().setBackground(null);
    localViewTitleWithAnimation.getIconImageView().setImageDrawable(null);
    if (this.vLD.Dzl == 4)
    {
      localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762816));
      paramOnClickListener.hkf = 2131689516;
      paramOnClickListener.gkG = true;
      com.tencent.mm.aw.a.a.ayO().a(this.vLD.Dzm, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.azc());
    }
    for (;;)
    {
      AppMethodBeat.o(151576);
      return localViewTitleWithAnimation;
      if (this.vLD.Dzl == 3)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762817));
        paramOnClickListener.hkf = 2131233888;
        paramOnClickListener.gkG = true;
        com.tencent.mm.aw.a.a.ayO().a(this.vLD.Dzm, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.azc());
      }
      else if (this.vLD.Dzl == 1)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762820));
        paramOnClickListener.hkf = 2131099687;
        com.tencent.mm.aw.a.a.ayO().a(this.vLD.Dzm, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.azc());
      }
      else if (this.vLD.Dzl == 2)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762818));
        localViewTitleWithAnimation.getIconImageView().setImageResource(2131690016);
      }
      else if (this.vLD.Dzl == 7)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762822));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(null);
        if (!bt.isNullOrNil(this.vLD.Dzn)) {
          localViewTitleWithAnimation.setCompanyText(bt.u("@%s", new Object[] { this.vLD.Dzn }));
        }
        paramOnClickListener.hkf = 2131099687;
        com.tencent.mm.aw.a.a.ayO().a(this.vLD.Dzm, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.azc());
      }
      else if (this.vLD.Dzl == 6)
      {
        localViewTitleWithAnimation.setTitle(bt.u(this.mContext.getString(2131762856), new Object[] { this.vLD.mAQ }));
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762819));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(am.i(this.mContext, 2131690677, this.mContext.getResources().getColor(2131099699)));
      }
      else if (this.vLD.Dzl == 5)
      {
        localViewTitleWithAnimation.setTitle(bt.u(this.mContext.getString(2131762875), new Object[] { this.vLD.mAQ }));
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762821));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(am.i(this.mContext, 2131690336, this.mContext.getResources().getColor(2131099829)));
      }
      else
      {
        localViewTitleWithAnimation.ffh();
      }
    }
  }
  
  @SuppressLint({"ResourceType"})
  public final View a(View.OnClickListener paramOnClickListener, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(151575);
    this.vLJ = paramInt2;
    paramOnClickListener = new ScanCodeSheetItemLogic.3(this, paramInt2, paramOnClickListener);
    if (this.vLD == null)
    {
      paramOnClickListener = a(paramOnClickListener, paramInt1, paramString);
      AppMethodBeat.o(151575);
      return paramOnClickListener;
    }
    paramOnClickListener = d(paramOnClickListener);
    AppMethodBeat.o(151575);
    return paramOnClickListener;
  }
  
  public final void bM(int paramInt, final String paramString)
  {
    AppMethodBeat.i(151573);
    this.vLD = null;
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151573);
      return;
    }
    if (this.vLG == null) {
      this.vLG = new b();
    }
    if (e.bK(paramInt, paramString)) {
      this.vLG.bC(paramInt, paramString).a(new d.b() {});
    }
    AppMethodBeat.o(151573);
  }
  
  public final String dkU()
  {
    AppMethodBeat.i(151572);
    String str = this.mContext.getString(2131762857);
    AppMethodBeat.o(151572);
    return str;
  }
  
  public final void q(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151574);
    bbr localbbr = new bbr();
    if ((paramInt == 0) && (!bt.cw(paramArrayOfByte))) {}
    for (;;)
    {
      try
      {
        localbbr.parseFrom(paramArrayOfByte);
        if ((bt.isNullOrNil(localbbr.Dzm)) && (bt.isNullOrNil(localbbr.mAQ))) {
          localbbr.Ret = -1;
        }
        this.vLD = localbbr;
        if (this.vLE != null) {
          this.vLE.beE();
        }
        AppMethodBeat.o(151574);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        ad.e("MicroMsg.ScanCodeSheetItemLogic", "parse exception: s%", new Object[] { paramArrayOfByte.getMessage() });
      }
      localbbr.Ret = -1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void beE();
  }
  
  public static abstract interface b
  {
    public abstract void YE(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic
 * JD-Core Version:    0.7.0.1
 */