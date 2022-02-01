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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.protocal.protobuf.bkj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  public bkj yzd;
  public final bkj yze;
  private a yzf;
  private b yzg;
  public d yzh;
  private HashMap<String, bkj> yzi;
  private MutableLiveData<bkj> yzj;
  private int yzk;
  private boolean yzl;
  
  public ScanCodeSheetItemLogic(Context paramContext)
  {
    AppMethodBeat.i(151569);
    this.yze = new bkj();
    this.yzi = new HashMap();
    this.yzj = new MutableLiveData();
    this.yzl = false;
    this.mContext = paramContext;
    AppMethodBeat.o(151569);
  }
  
  public ScanCodeSheetItemLogic(Context paramContext, a parama)
  {
    AppMethodBeat.i(151570);
    this.yze = new bkj();
    this.yzi = new HashMap();
    this.yzj = new MutableLiveData();
    this.yzl = false;
    this.mContext = paramContext;
    this.yzf = parama;
    AppMethodBeat.o(151570);
  }
  
  public ScanCodeSheetItemLogic(Context paramContext, b paramb)
  {
    AppMethodBeat.i(151571);
    this.yze = new bkj();
    this.yzi = new HashMap();
    this.yzj = new MutableLiveData();
    this.yzl = false;
    this.mContext = paramContext;
    this.yzg = paramb;
    AppMethodBeat.o(151571);
  }
  
  @SuppressLint({"ResourceType"})
  private View a(View.OnClickListener paramOnClickListener, int paramInt, String paramString)
  {
    AppMethodBeat.i(151577);
    Object localObject = new ViewTitleWithAnimation(this.mContext);
    ((ViewTitleWithAnimation)localObject).startLoading();
    ((ViewTitleWithAnimation)localObject).setOnClickListener(paramOnClickListener);
    if (g.bM(paramInt, paramString))
    {
      ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131689516);
      ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762816));
    }
    for (;;)
    {
      AppMethodBeat.o(151577);
      return localObject;
      if (g.bN(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762817));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131233888);
      }
      else if (g.bO(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762820));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131099687);
      }
      else if (g.bP(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762818));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131690016);
      }
      else if (g.bQ(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762822));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131099687);
      }
      else if (g.bS(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762819));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(ao.k(this.mContext, 2131690677, this.mContext.getResources().getColor(2131099700)));
      }
      else
      {
        if (!g.bR(paramInt, paramString)) {
          break;
        }
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131762821));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(ao.k(this.mContext, 2131690336, this.mContext.getResources().getColor(2131099829)));
      }
    }
    paramString = this.mContext.getString(2131762857);
    if (!e.d.YK(paramInt)) {
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
    if ((this.yzd.Ret != 0) || (bu.isNullOrNil(this.yzd.nIJ)))
    {
      localViewTitleWithAnimation.fQi();
      localViewTitleWithAnimation.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(151576);
      return localViewTitleWithAnimation;
    }
    localViewTitleWithAnimation.setTitle(this.yzd.nIJ);
    localViewTitleWithAnimation.setOnClickListener(paramOnClickListener);
    paramOnClickListener = new c.a();
    paramOnClickListener.igj = true;
    localViewTitleWithAnimation.getIconImageView().setBackground(null);
    localViewTitleWithAnimation.getIconImageView().setImageDrawable(null);
    if (this.yzd.GXH == 4)
    {
      localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762816));
      paramOnClickListener.igv = 2131689516;
      paramOnClickListener.hhW = true;
      com.tencent.mm.av.a.a.aJh().a(this.yzd.GXI, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.aJu());
    }
    for (;;)
    {
      AppMethodBeat.o(151576);
      return localViewTitleWithAnimation;
      if (this.yzd.GXH == 3)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762817));
        paramOnClickListener.igv = 2131233888;
        paramOnClickListener.hhW = true;
        com.tencent.mm.av.a.a.aJh().a(this.yzd.GXI, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.aJu());
      }
      else if (this.yzd.GXH == 1)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762820));
        paramOnClickListener.igv = 2131099687;
        com.tencent.mm.av.a.a.aJh().a(this.yzd.GXI, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.aJu());
      }
      else if (this.yzd.GXH == 2)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762818));
        localViewTitleWithAnimation.getIconImageView().setImageResource(2131690016);
      }
      else if (this.yzd.GXH == 7)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762822));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(null);
        if (!bu.isNullOrNil(this.yzd.GXJ)) {
          localViewTitleWithAnimation.setCompanyText(bu.x("@%s", new Object[] { this.yzd.GXJ }));
        }
        paramOnClickListener.igv = 2131099687;
        com.tencent.mm.av.a.a.aJh().a(this.yzd.GXI, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.aJu());
      }
      else if (this.yzd.GXH == 6)
      {
        localViewTitleWithAnimation.setTitle(bu.x(this.mContext.getString(2131762856), new Object[] { this.yzd.nIJ }));
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762819));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(ao.k(this.mContext, 2131690677, this.mContext.getResources().getColor(2131099699)));
      }
      else if (this.yzd.GXH == 5)
      {
        localViewTitleWithAnimation.setTitle(bu.x(this.mContext.getString(2131762875), new Object[] { this.yzd.nIJ }));
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131762821));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(ao.k(this.mContext, 2131690336, this.mContext.getResources().getColor(2131099829)));
      }
      else
      {
        localViewTitleWithAnimation.fQi();
      }
    }
  }
  
  public final String OT(int paramInt)
  {
    AppMethodBeat.i(218782);
    String str = this.mContext.getString(2131767145);
    if (!e.d.YK(paramInt)) {
      str = this.mContext.getString(2131767143);
    }
    AppMethodBeat.o(218782);
    return str;
  }
  
  @SuppressLint({"ResourceType"})
  public final View a(View.OnClickListener paramOnClickListener, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(151575);
    this.yzk = paramInt2;
    paramOnClickListener = new ScanCodeSheetItemLogic.6(this, paramInt2, paramOnClickListener);
    if (this.yzd == null)
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
    AppMethodBeat.i(218783);
    this.yzl = true;
    this.yzd = null;
    h.MqF.bbc("MicroMsg.ScanCodeSheetItemLogic");
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(218783);
      return;
    }
    if (this.yzh == null) {
      this.yzh = new d();
    }
    if (g.bT(paramInt, paramString))
    {
      if (1000L > 0L)
      {
        h.MqF.bbc("MicroMsg.ScanCodeSheetItemLogic");
        h.MqF.a(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(218779);
            h.MqF.aM(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(218778);
                if ((ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this) != null) && (ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this) != ScanCodeSheetItemLogic.c(ScanCodeSheetItemLogic.this)))
                {
                  AppMethodBeat.o(218778);
                  return;
                }
                ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this, ScanCodeSheetItemLogic.c(ScanCodeSheetItemLogic.this));
                ScanCodeSheetItemLogic.b(ScanCodeSheetItemLogic.this, ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this));
                if (ScanCodeSheetItemLogic.e(ScanCodeSheetItemLogic.this) != null) {
                  ScanCodeSheetItemLogic.e(ScanCodeSheetItemLogic.this).bpT();
                }
                if (ScanCodeSheetItemLogic.f(ScanCodeSheetItemLogic.this) != null)
                {
                  ScanCodeSheetItemLogic.b localb = ScanCodeSheetItemLogic.f(ScanCodeSheetItemLogic.this);
                  String str = ScanCodeSheetItemLogic.4.this.yzm;
                  ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this);
                  localb.ahM(str);
                }
                AppMethodBeat.o(218778);
              }
            });
            AppMethodBeat.o(218779);
          }
        }, 1000L, "MicroMsg.ScanCodeSheetItemLogic");
      }
      this.yzh.bL(paramInt, paramString).a(new d.b() {});
    }
    AppMethodBeat.o(218783);
  }
  
  public final void bW(int paramInt, final String paramString)
  {
    AppMethodBeat.i(151573);
    this.yzd = null;
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151573);
      return;
    }
    if (this.yzh == null) {
      this.yzh = new d();
    }
    if (g.bT(paramInt, paramString)) {
      this.yzh.bL(paramInt, paramString).a(new d.b() {});
    }
    AppMethodBeat.o(151573);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(218784);
    h.MqF.bbc("MicroMsg.ScanCodeSheetItemLogic");
    this.yzd = null;
    this.yzl = false;
    AppMethodBeat.o(218784);
  }
  
  public final void q(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151574);
    bkj localbkj = new bkj();
    if ((paramInt == 0) && (!bu.cF(paramArrayOfByte))) {}
    for (;;)
    {
      try
      {
        localbkj.parseFrom(paramArrayOfByte);
        if ((bu.isNullOrNil(localbkj.GXI)) && (bu.isNullOrNil(localbkj.nIJ))) {
          localbkj.Ret = -1;
        }
        this.yzd = localbkj;
        if (this.yzf != null) {
          this.yzf.bpT();
        }
        AppMethodBeat.o(151574);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        ae.e("MicroMsg.ScanCodeSheetItemLogic", "parse exception: s%", new Object[] { paramArrayOfByte.getMessage() });
      }
      localbkj.Ret = -1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void bpT();
  }
  
  public static abstract interface b
  {
    public abstract void ahM(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic
 * JD-Core Version:    0.7.0.1
 */