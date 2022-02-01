package com.tencent.mm.plugin.scanner;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.e;
import java.io.IOException;
import java.util.HashMap;

public class ScanCodeSheetItemLogic
  implements LifecycleObserver
{
  public Context mContext;
  public bjr yjh;
  public final bjr yji;
  private a yjj;
  private b yjk;
  public c yjl;
  private HashMap<String, bjr> yjm;
  private MutableLiveData<bjr> yjn;
  private int yjo;
  private boolean yjp;
  
  public ScanCodeSheetItemLogic(Context paramContext)
  {
    AppMethodBeat.i(151569);
    this.yji = new bjr();
    this.yjm = new HashMap();
    this.yjn = new MutableLiveData();
    this.yjp = false;
    this.mContext = paramContext;
    AppMethodBeat.o(151569);
  }
  
  public ScanCodeSheetItemLogic(Context paramContext, a parama)
  {
    AppMethodBeat.i(151570);
    this.yji = new bjr();
    this.yjm = new HashMap();
    this.yjn = new MutableLiveData();
    this.yjp = false;
    this.mContext = paramContext;
    this.yjj = parama;
    AppMethodBeat.o(151570);
  }
  
  public ScanCodeSheetItemLogic(Context paramContext, b paramb)
  {
    AppMethodBeat.i(151571);
    this.yji = new bjr();
    this.yjm = new HashMap();
    this.yjn = new MutableLiveData();
    this.yjp = false;
    this.mContext = paramContext;
    this.yjk = paramb;
    AppMethodBeat.o(151571);
  }
  
  @SuppressLint({"ResourceType"})
  private View a(View.OnClickListener paramOnClickListener, int paramInt, String paramString)
  {
    AppMethodBeat.i(151577);
    Object localObject = new ViewTitleWithAnimation(this.mContext);
    ((ViewTitleWithAnimation)localObject).startLoading();
    ((ViewTitleWithAnimation)localObject).setOnClickListener(paramOnClickListener);
    if (f.bM(paramInt, paramString))
    {
      ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131689516);
      ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762816));
    }
    for (;;)
    {
      AppMethodBeat.o(151577);
      return localObject;
      if (f.bN(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762817));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131233888);
      }
      else if (f.bO(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762820));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131099687);
      }
      else if (f.bP(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762818));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131690016);
      }
      else if (f.bQ(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762822));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131099687);
      }
      else if (f.bS(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762819));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(ao.k(this.mContext, 2131690677, this.mContext.getResources().getColor(2131099700)));
      }
      else
      {
        if (!f.bR(paramInt, paramString)) {
          break;
        }
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762821));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(ao.k(this.mContext, 2131690336, this.mContext.getResources().getColor(2131099829)));
      }
    }
    paramString = this.mContext.getString(2131762857);
    if (!e.d.Ye(paramInt)) {
      paramString = this.mContext.getString(2131766795);
    }
    localObject = new com.tencent.mm.ui.widget.bottomsheet.a(this.mContext);
    ((com.tencent.mm.ui.widget.bottomsheet.a)localObject).setOnClickListener(paramOnClickListener);
    ((com.tencent.mm.ui.widget.bottomsheet.a)localObject).setTitle(paramString);
    AppMethodBeat.o(151577);
    return localObject;
  }
  
  @SuppressLint({"ResourceType"})
  private View c(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(151576);
    ViewTitleWithAnimation localViewTitleWithAnimation = new ViewTitleWithAnimation(this.mContext);
    localViewTitleWithAnimation.hideLoading();
    if ((this.yjh.Ret != 0) || (bt.isNullOrNil(this.yjh.nDo)))
    {
      localViewTitleWithAnimation.fLO();
      localViewTitleWithAnimation.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(151576);
      return localViewTitleWithAnimation;
    }
    localViewTitleWithAnimation.setTitle(this.yjh.nDo);
    localViewTitleWithAnimation.setOnClickListener(paramOnClickListener);
    paramOnClickListener = new c.a();
    paramOnClickListener.idq = true;
    localViewTitleWithAnimation.getIconImageView().setBackground(null);
    localViewTitleWithAnimation.getIconImageView().setImageDrawable(null);
    if (this.yjh.GEe == 4)
    {
      localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762816));
      paramOnClickListener.idD = 2131689516;
      paramOnClickListener.hfi = true;
      com.tencent.mm.aw.a.a.aIP().a(this.yjh.GEf, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.aJc());
    }
    for (;;)
    {
      AppMethodBeat.o(151576);
      return localViewTitleWithAnimation;
      if (this.yjh.GEe == 3)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762817));
        paramOnClickListener.idD = 2131233888;
        paramOnClickListener.hfi = true;
        com.tencent.mm.aw.a.a.aIP().a(this.yjh.GEf, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.aJc());
      }
      else if (this.yjh.GEe == 1)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762820));
        paramOnClickListener.idD = 2131099687;
        com.tencent.mm.aw.a.a.aIP().a(this.yjh.GEf, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.aJc());
      }
      else if (this.yjh.GEe == 2)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762818));
        localViewTitleWithAnimation.getIconImageView().setImageResource(2131690016);
      }
      else if (this.yjh.GEe == 7)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762822));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(null);
        if (!bt.isNullOrNil(this.yjh.GEg)) {
          localViewTitleWithAnimation.setCompanyText(bt.x("@%s", new Object[] { this.yjh.GEg }));
        }
        paramOnClickListener.idD = 2131099687;
        com.tencent.mm.aw.a.a.aIP().a(this.yjh.GEf, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.aJc());
      }
      else if (this.yjh.GEe == 6)
      {
        localViewTitleWithAnimation.setTitle(bt.x(this.mContext.getString(2131762856), new Object[] { this.yjh.nDo }));
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762819));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(ao.k(this.mContext, 2131690677, this.mContext.getResources().getColor(2131099699)));
      }
      else if (this.yjh.GEe == 5)
      {
        localViewTitleWithAnimation.setTitle(bt.x(this.mContext.getString(2131762875), new Object[] { this.yjh.nDo }));
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762821));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(ao.k(this.mContext, 2131690336, this.mContext.getResources().getColor(2131099829)));
      }
      else
      {
        localViewTitleWithAnimation.fLO();
      }
    }
  }
  
  public final String On(int paramInt)
  {
    AppMethodBeat.i(195329);
    String str = this.mContext.getString(2131767145);
    if (!e.d.Ye(paramInt)) {
      str = this.mContext.getString(2131767143);
    }
    AppMethodBeat.o(195329);
    return str;
  }
  
  @SuppressLint({"ResourceType"})
  public final View a(View.OnClickListener paramOnClickListener, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(151575);
    this.yjo = paramInt2;
    paramOnClickListener = new ScanCodeSheetItemLogic.6(this, paramInt2, paramOnClickListener);
    if (this.yjh == null)
    {
      paramOnClickListener = a(paramOnClickListener, paramInt1, paramString);
      AppMethodBeat.o(151575);
      return paramOnClickListener;
    }
    paramOnClickListener = c(paramOnClickListener);
    AppMethodBeat.o(151575);
    return paramOnClickListener;
  }
  
  public final void bV(int paramInt, final String paramString)
  {
    AppMethodBeat.i(195330);
    this.yjp = true;
    this.yjh = null;
    h.LTJ.aZz("MicroMsg.ScanCodeSheetItemLogic");
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(195330);
      return;
    }
    if (this.yjl == null) {
      this.yjl = new c();
    }
    if (f.bT(paramInt, paramString))
    {
      if (1000L > 0L)
      {
        h.LTJ.aZz("MicroMsg.ScanCodeSheetItemLogic");
        h.LTJ.a(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(195326);
            h.LTJ.aP(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(195325);
                if ((ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this) != null) && (ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this) != ScanCodeSheetItemLogic.c(ScanCodeSheetItemLogic.this)))
                {
                  AppMethodBeat.o(195325);
                  return;
                }
                ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this, ScanCodeSheetItemLogic.c(ScanCodeSheetItemLogic.this));
                ScanCodeSheetItemLogic.b(ScanCodeSheetItemLogic.this, ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this));
                if (ScanCodeSheetItemLogic.e(ScanCodeSheetItemLogic.this) != null) {
                  ScanCodeSheetItemLogic.e(ScanCodeSheetItemLogic.this).bpj();
                }
                if (ScanCodeSheetItemLogic.f(ScanCodeSheetItemLogic.this) != null)
                {
                  ScanCodeSheetItemLogic.b localb = ScanCodeSheetItemLogic.f(ScanCodeSheetItemLogic.this);
                  String str = ScanCodeSheetItemLogic.4.this.yjq;
                  ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this);
                  localb.agP(str);
                }
                AppMethodBeat.o(195325);
              }
            });
            AppMethodBeat.o(195326);
          }
        }, 1000L, "MicroMsg.ScanCodeSheetItemLogic");
      }
      this.yjl.bL(paramInt, paramString).a(new d.b() {});
    }
    AppMethodBeat.o(195330);
  }
  
  public final void bW(int paramInt, final String paramString)
  {
    AppMethodBeat.i(151573);
    this.yjh = null;
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151573);
      return;
    }
    if (this.yjl == null) {
      this.yjl = new c();
    }
    if (f.bT(paramInt, paramString)) {
      this.yjl.bL(paramInt, paramString).a(new d.b() {});
    }
    AppMethodBeat.o(151573);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(195331);
    h.LTJ.aZz("MicroMsg.ScanCodeSheetItemLogic");
    this.yjh = null;
    this.yjp = false;
    AppMethodBeat.o(195331);
  }
  
  public final void q(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151574);
    bjr localbjr = new bjr();
    if ((paramInt == 0) && (!bt.cC(paramArrayOfByte))) {}
    for (;;)
    {
      try
      {
        localbjr.parseFrom(paramArrayOfByte);
        if ((bt.isNullOrNil(localbjr.GEf)) && (bt.isNullOrNil(localbjr.nDo))) {
          localbjr.Ret = -1;
        }
        this.yjh = localbjr;
        if (this.yjj != null) {
          this.yjj.bpj();
        }
        AppMethodBeat.o(151574);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        ad.e("MicroMsg.ScanCodeSheetItemLogic", "parse exception: s%", new Object[] { paramArrayOfByte.getMessage() });
      }
      localbjr.Ret = -1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void bpj();
  }
  
  public static abstract interface b
  {
    public abstract void agP(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic
 * JD-Core Version:    0.7.0.1
 */