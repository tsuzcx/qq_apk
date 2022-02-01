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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.e;
import java.io.IOException;
import java.util.HashMap;

public class ScanCodeSheetItemLogic
  implements LifecycleObserver
{
  private Context mContext;
  public bfj wVE;
  private a wVF;
  private b wVG;
  public c wVH;
  private HashMap<String, bfj> wVI;
  private MutableLiveData<bfj> wVJ;
  private int wVK;
  
  public ScanCodeSheetItemLogic(Context paramContext)
  {
    AppMethodBeat.i(151569);
    this.wVI = new HashMap();
    this.wVJ = new MutableLiveData();
    this.mContext = paramContext;
    AppMethodBeat.o(151569);
  }
  
  public ScanCodeSheetItemLogic(Context paramContext, a parama)
  {
    AppMethodBeat.i(151570);
    this.wVI = new HashMap();
    this.wVJ = new MutableLiveData();
    this.mContext = paramContext;
    this.wVF = parama;
    AppMethodBeat.o(151570);
  }
  
  public ScanCodeSheetItemLogic(Context paramContext, b paramb)
  {
    AppMethodBeat.i(151571);
    this.wVI = new HashMap();
    this.wVJ = new MutableLiveData();
    this.mContext = paramContext;
    this.wVG = paramb;
    AppMethodBeat.o(151571);
  }
  
  @SuppressLint({"ResourceType"})
  private View a(View.OnClickListener paramOnClickListener, int paramInt, String paramString)
  {
    AppMethodBeat.i(151577);
    Object localObject = new ViewTitleWithAnimation(this.mContext);
    ((ViewTitleWithAnimation)localObject).startLoading();
    ((ViewTitleWithAnimation)localObject).setOnClickListener(paramOnClickListener);
    if (f.bG(paramInt, paramString))
    {
      ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131689516);
      ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762816));
    }
    for (;;)
    {
      AppMethodBeat.o(151577);
      return localObject;
      if (f.bH(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762817));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131233888);
      }
      else if (f.bI(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762820));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131099687);
      }
      else if (f.bJ(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762818));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131690016);
      }
      else if (f.bK(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762822));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131099687);
      }
      else if (f.bM(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762819));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(am.k(this.mContext, 2131690677, this.mContext.getResources().getColor(2131099700)));
      }
      else
      {
        if (!f.bL(paramInt, paramString)) {
          break;
        }
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762821));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(am.k(this.mContext, 2131690336, this.mContext.getResources().getColor(2131099829)));
      }
    }
    paramString = this.mContext.getString(2131762857);
    if (!d.d.Wn(paramInt)) {
      paramString = this.mContext.getString(2131766795);
    }
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
    if ((this.wVE.Ret != 0) || (bs.isNullOrNil(this.wVE.ncR)))
    {
      localViewTitleWithAnimation.fvd();
      localViewTitleWithAnimation.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(151576);
      return localViewTitleWithAnimation;
    }
    localViewTitleWithAnimation.setTitle(this.wVE.ncR);
    localViewTitleWithAnimation.setOnClickListener(paramOnClickListener);
    paramOnClickListener = new c.a();
    paramOnClickListener.hKw = true;
    localViewTitleWithAnimation.getIconImageView().setBackground(null);
    localViewTitleWithAnimation.getIconImageView().setImageDrawable(null);
    if (this.wVE.EUH == 4)
    {
      localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762816));
      paramOnClickListener.hKI = 2131689516;
      paramOnClickListener.gLt = true;
      com.tencent.mm.av.a.a.aFG().a(this.wVE.EUI, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.aFT());
    }
    for (;;)
    {
      AppMethodBeat.o(151576);
      return localViewTitleWithAnimation;
      if (this.wVE.EUH == 3)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762817));
        paramOnClickListener.hKI = 2131233888;
        paramOnClickListener.gLt = true;
        com.tencent.mm.av.a.a.aFG().a(this.wVE.EUI, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.aFT());
      }
      else if (this.wVE.EUH == 1)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762820));
        paramOnClickListener.hKI = 2131099687;
        com.tencent.mm.av.a.a.aFG().a(this.wVE.EUI, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.aFT());
      }
      else if (this.wVE.EUH == 2)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762818));
        localViewTitleWithAnimation.getIconImageView().setImageResource(2131690016);
      }
      else if (this.wVE.EUH == 7)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762822));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(null);
        if (!bs.isNullOrNil(this.wVE.EUJ)) {
          localViewTitleWithAnimation.setCompanyText(bs.u("@%s", new Object[] { this.wVE.EUJ }));
        }
        paramOnClickListener.hKI = 2131099687;
        com.tencent.mm.av.a.a.aFG().a(this.wVE.EUI, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.aFT());
      }
      else if (this.wVE.EUH == 6)
      {
        localViewTitleWithAnimation.setTitle(bs.u(this.mContext.getString(2131762856), new Object[] { this.wVE.ncR }));
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762819));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(am.k(this.mContext, 2131690677, this.mContext.getResources().getColor(2131099699)));
      }
      else if (this.wVE.EUH == 5)
      {
        localViewTitleWithAnimation.setTitle(bs.u(this.mContext.getString(2131762875), new Object[] { this.wVE.ncR }));
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762821));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(am.k(this.mContext, 2131690336, this.mContext.getResources().getColor(2131099829)));
      }
      else
      {
        localViewTitleWithAnimation.fvd();
      }
    }
  }
  
  public final String ML(int paramInt)
  {
    AppMethodBeat.i(192640);
    String str = this.mContext.getString(2131762857);
    if (!d.d.Wn(paramInt)) {
      str = this.mContext.getString(2131766795);
    }
    AppMethodBeat.o(192640);
    return str;
  }
  
  @SuppressLint({"ResourceType"})
  public final View a(View.OnClickListener paramOnClickListener, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(151575);
    this.wVK = paramInt2;
    paramOnClickListener = new ScanCodeSheetItemLogic.3(this, paramInt2, paramOnClickListener);
    if (this.wVE == null)
    {
      paramOnClickListener = a(paramOnClickListener, paramInt1, paramString);
      AppMethodBeat.o(151575);
      return paramOnClickListener;
    }
    paramOnClickListener = d(paramOnClickListener);
    AppMethodBeat.o(151575);
    return paramOnClickListener;
  }
  
  public final void bP(int paramInt, final String paramString)
  {
    AppMethodBeat.i(151573);
    this.wVE = null;
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151573);
      return;
    }
    if (this.wVH == null) {
      this.wVH = new c();
    }
    if (f.bN(paramInt, paramString)) {
      this.wVH.bF(paramInt, paramString).a(new d.b() {});
    }
    AppMethodBeat.o(151573);
  }
  
  public final void q(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151574);
    bfj localbfj = new bfj();
    if ((paramInt == 0) && (!bs.cv(paramArrayOfByte))) {}
    for (;;)
    {
      try
      {
        localbfj.parseFrom(paramArrayOfByte);
        if ((bs.isNullOrNil(localbfj.EUI)) && (bs.isNullOrNil(localbfj.ncR))) {
          localbfj.Ret = -1;
        }
        this.wVE = localbfj;
        if (this.wVF != null) {
          this.wVF.bly();
        }
        AppMethodBeat.o(151574);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        ac.e("MicroMsg.ScanCodeSheetItemLogic", "parse exception: s%", new Object[] { paramArrayOfByte.getMessage() });
      }
      localbfj.Ret = -1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void bly();
  }
  
  public static abstract interface b
  {
    public abstract void ada(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic
 * JD-Core Version:    0.7.0.1
 */