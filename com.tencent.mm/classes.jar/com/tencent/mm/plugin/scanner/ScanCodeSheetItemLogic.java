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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o.b;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.e;
import java.io.IOException;
import java.util.HashMap;

public class ScanCodeSheetItemLogic
  implements LifecycleObserver
{
  public bws CAh;
  public final bws CAi;
  private a CAj;
  private b CAk;
  public d CAl;
  private HashMap<String, bws> CAm;
  private MutableLiveData<bws> CAn;
  private int CAo;
  private boolean CAp;
  public Context mContext;
  
  public ScanCodeSheetItemLogic(Context paramContext)
  {
    AppMethodBeat.i(151569);
    this.CAi = new bws();
    this.CAm = new HashMap();
    this.CAn = new MutableLiveData();
    this.CAp = false;
    this.mContext = paramContext;
    AppMethodBeat.o(151569);
  }
  
  public ScanCodeSheetItemLogic(Context paramContext, a parama)
  {
    AppMethodBeat.i(151570);
    this.CAi = new bws();
    this.CAm = new HashMap();
    this.CAn = new MutableLiveData();
    this.CAp = false;
    this.mContext = paramContext;
    this.CAj = parama;
    AppMethodBeat.o(151570);
  }
  
  public ScanCodeSheetItemLogic(Context paramContext, b paramb)
  {
    AppMethodBeat.i(151571);
    this.CAi = new bws();
    this.CAm = new HashMap();
    this.CAn = new MutableLiveData();
    this.CAp = false;
    this.mContext = paramContext;
    this.CAk = paramb;
    AppMethodBeat.o(151571);
  }
  
  @SuppressLint({"ResourceType"})
  private View a(View.OnClickListener paramOnClickListener, int paramInt, String paramString)
  {
    AppMethodBeat.i(151577);
    Object localObject = new ViewTitleWithAnimation(this.mContext);
    ((ViewTitleWithAnimation)localObject).startLoading();
    ((ViewTitleWithAnimation)localObject).setOnClickListener(paramOnClickListener);
    if (g.ca(paramInt, paramString))
    {
      ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131689518);
      ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131764913));
    }
    for (;;)
    {
      AppMethodBeat.o(151577);
      return localObject;
      if (g.cb(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131764914));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131234714);
      }
      else if (g.cc(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131764917));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131099697);
      }
      else if (g.cd(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131764915));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131690046);
      }
      else if (g.ce(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131764919));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(null);
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageResource(2131099697);
      }
      else if (g.ch(paramInt, paramString))
      {
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131764916));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(ar.m(this.mContext, 2131690935, this.mContext.getResources().getColor(2131099711)));
      }
      else
      {
        if (!g.cg(paramInt, paramString)) {
          break;
        }
        ((ViewTitleWithAnimation)localObject).setSubTitle(this.mContext.getString(2131764918));
        ((ViewTitleWithAnimation)localObject).getIconImageView().setImageDrawable(ar.m(this.mContext, 2131690461, this.mContext.getResources().getColor(2131099845)));
      }
    }
    paramString = this.mContext.getString(2131764967);
    if (!e.d.ahw(paramInt)) {
      paramString = this.mContext.getString(2131764966);
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
    if ((this.CAh.Ret != 0) || (Util.isNullOrNil(this.CAh.UserName)))
    {
      localViewTitleWithAnimation.gZm();
      localViewTitleWithAnimation.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(151576);
      return localViewTitleWithAnimation;
    }
    localViewTitleWithAnimation.setTitle(this.CAh.UserName);
    localViewTitleWithAnimation.setOnClickListener(paramOnClickListener);
    paramOnClickListener = new c.a();
    paramOnClickListener.jbe = true;
    localViewTitleWithAnimation.getIconImageView().setBackground(null);
    localViewTitleWithAnimation.getIconImageView().setImageDrawable(null);
    if (this.CAh.Mcw == 4)
    {
      localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131764913));
      paramOnClickListener.jbq = 2131689518;
      paramOnClickListener.iaT = true;
      com.tencent.mm.av.a.a.bdb().a(this.CAh.Mcx, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.bdv());
    }
    for (;;)
    {
      AppMethodBeat.o(151576);
      return localViewTitleWithAnimation;
      if (this.CAh.Mcw == 3)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131764914));
        paramOnClickListener.jbq = 2131234714;
        paramOnClickListener.iaT = true;
        com.tencent.mm.av.a.a.bdb().a(this.CAh.Mcx, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.bdv());
      }
      else if (this.CAh.Mcw == 1)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131764917));
        paramOnClickListener.jbq = 2131099697;
        com.tencent.mm.av.a.a.bdb().a(this.CAh.Mcx, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.bdv());
      }
      else if (this.CAh.Mcw == 2)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131764915));
        localViewTitleWithAnimation.getIconImageView().setImageResource(2131690046);
      }
      else if (this.CAh.Mcw == 7)
      {
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131764919));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(null);
        if (!Util.isNullOrNil(this.CAh.Mcy)) {
          localViewTitleWithAnimation.setCompanyText(Util.safeFormatString("@%s", new Object[] { this.CAh.Mcy }));
        }
        paramOnClickListener.jbq = 2131099697;
        com.tencent.mm.av.a.a.bdb().a(this.CAh.Mcx, localViewTitleWithAnimation.getIconImageView(), paramOnClickListener.bdv());
      }
      else if (this.CAh.Mcw == 6)
      {
        localViewTitleWithAnimation.setTitle(Util.safeFormatString(this.mContext.getString(2131764964), new Object[] { this.CAh.UserName }));
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131764916));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(ar.m(this.mContext, 2131690935, this.mContext.getResources().getColor(2131099710)));
      }
      else if (this.CAh.Mcw == 5)
      {
        localViewTitleWithAnimation.setTitle(Util.safeFormatString(this.mContext.getString(2131764986), new Object[] { this.CAh.UserName }));
        localViewTitleWithAnimation.setSubTitle(this.mContext.getString(2131764918));
        localViewTitleWithAnimation.getIconImageView().setImageDrawable(ar.m(this.mContext, 2131690461, this.mContext.getResources().getColor(2131099845)));
      }
      else
      {
        localViewTitleWithAnimation.gZm();
      }
    }
  }
  
  public final String Wp(int paramInt)
  {
    AppMethodBeat.i(223709);
    String str = this.mContext.getString(2131764926);
    if (!e.d.ahw(paramInt)) {
      str = this.mContext.getString(2131764924);
    }
    AppMethodBeat.o(223709);
    return str;
  }
  
  @SuppressLint({"ResourceType"})
  public final View a(View.OnClickListener paramOnClickListener, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(151575);
    this.CAo = paramInt2;
    paramOnClickListener = new ScanCodeSheetItemLogic.6(this, paramInt2, paramOnClickListener);
    if (this.CAh == null)
    {
      paramOnClickListener = a(paramOnClickListener, paramInt1, paramString);
      AppMethodBeat.o(151575);
      return paramOnClickListener;
    }
    paramOnClickListener = d(paramOnClickListener);
    AppMethodBeat.o(151575);
    return paramOnClickListener;
  }
  
  public final void cl(int paramInt, final String paramString)
  {
    AppMethodBeat.i(223710);
    this.CAp = true;
    this.CAh = null;
    h.RTc.bqo("MicroMsg.ScanCodeSheetItemLogic");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(223710);
      return;
    }
    if (this.CAl == null) {
      this.CAl = new d();
    }
    if (g.ci(paramInt, paramString))
    {
      if (1000L > 0L)
      {
        h.RTc.bqo("MicroMsg.ScanCodeSheetItemLogic");
        h.RTc.a(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(223706);
            h.RTc.aV(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(223705);
                if ((ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this) != null) && (ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this) != ScanCodeSheetItemLogic.c(ScanCodeSheetItemLogic.this)))
                {
                  AppMethodBeat.o(223705);
                  return;
                }
                ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this, ScanCodeSheetItemLogic.c(ScanCodeSheetItemLogic.this));
                ScanCodeSheetItemLogic.b(ScanCodeSheetItemLogic.this, ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this));
                if (ScanCodeSheetItemLogic.e(ScanCodeSheetItemLogic.this) != null) {
                  ScanCodeSheetItemLogic.e(ScanCodeSheetItemLogic.this).bLz();
                }
                if (ScanCodeSheetItemLogic.f(ScanCodeSheetItemLogic.this) != null)
                {
                  ScanCodeSheetItemLogic.b localb = ScanCodeSheetItemLogic.f(ScanCodeSheetItemLogic.this);
                  String str = ScanCodeSheetItemLogic.4.this.CAq;
                  ScanCodeSheetItemLogic.a(ScanCodeSheetItemLogic.this);
                  localb.asu(str);
                }
                AppMethodBeat.o(223705);
              }
            });
            AppMethodBeat.o(223706);
          }
        }, 1000L, "MicroMsg.ScanCodeSheetItemLogic");
      }
      this.CAl.bZ(paramInt, paramString).a(new d.b() {});
    }
    AppMethodBeat.o(223710);
  }
  
  public final void cm(int paramInt, final String paramString)
  {
    AppMethodBeat.i(151573);
    this.CAh = null;
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151573);
      return;
    }
    if (this.CAl == null) {
      this.CAl = new d();
    }
    if (g.ci(paramInt, paramString)) {
      this.CAl.bZ(paramInt, paramString).a(new d.b() {});
    }
    AppMethodBeat.o(151573);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(223711);
    h.RTc.bqo("MicroMsg.ScanCodeSheetItemLogic");
    this.CAh = null;
    this.CAp = false;
    AppMethodBeat.o(223711);
  }
  
  public final void q(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151574);
    bws localbws = new bws();
    if ((paramInt == 0) && (!Util.isNullOrNil(paramArrayOfByte))) {}
    for (;;)
    {
      try
      {
        localbws.parseFrom(paramArrayOfByte);
        if ((Util.isNullOrNil(localbws.Mcx)) && (Util.isNullOrNil(localbws.UserName))) {
          localbws.Ret = -1;
        }
        this.CAh = localbws;
        if (this.CAj != null) {
          this.CAj.bLz();
        }
        AppMethodBeat.o(151574);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        Log.e("MicroMsg.ScanCodeSheetItemLogic", "parse exception: s%", new Object[] { paramArrayOfByte.getMessage() });
      }
      localbws.Ret = -1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void bLz();
  }
  
  public static abstract interface b
  {
    public abstract void asu(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic
 * JD-Core Version:    0.7.0.1
 */