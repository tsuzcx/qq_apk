package com.tencent.mm.ui.conversation.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.ao;
import java.lang.ref.WeakReference;

public final class o
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  int BQU;
  boolean KVA;
  private TextView KVl;
  private TextView KVm;
  private ImageView KVn;
  private ImageView KVo;
  private ImageView KVp;
  private ProgressBar KVq;
  String KVr;
  private boolean KVs;
  int KVt;
  boolean KVu;
  boolean KVv;
  boolean KVw;
  String KVx;
  aw KVy;
  c<mt> KVz;
  private ProgressDialog fOC;
  private TextView iFO;
  TextView iYj;
  private boolean ihH;
  private TextView jpA;
  private ImageView mdt;
  View rY;
  
  public o(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38844);
    this.fOC = null;
    this.ihH = false;
    this.KVs = false;
    this.BQU = 0;
    this.rY = null;
    this.KVA = false;
    initialize();
    AppMethodBeat.o(38844);
  }
  
  private void initialize()
  {
    AppMethodBeat.i(38845);
    if ((!this.KVs) && (this.view != null))
    {
      this.rY = this.view.findViewById(2131302984);
      this.iYj = ((TextView)this.view.findViewById(2131302979));
      this.iFO = ((TextView)this.view.findViewById(2131302980));
      this.jpA = ((TextView)this.view.findViewById(2131302981));
      this.KVl = ((TextView)this.view.findViewById(2131302978));
      this.KVq = ((ProgressBar)this.view.findViewById(2131302983));
      this.mdt = ((ImageView)this.view.findViewById(2131302982));
      this.KVn = ((ImageView)this.view.findViewById(2131298370));
      this.KVo = ((ImageView)this.view.findViewById(2131300228));
      this.KVp = ((ImageView)this.view.findViewById(2131304824));
      this.KVm = ((TextView)this.view.findViewById(2131299471));
      this.KVn.setVisibility(8);
      this.KVs = true;
    }
    AppMethodBeat.o(38845);
  }
  
  private static boolean o(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(38848);
    if (paramObject == null)
    {
      AppMethodBeat.o(38848);
      return true;
    }
    if (((Integer)paramObject).intValue() != paramInt)
    {
      AppMethodBeat.o(38848);
      return true;
    }
    AppMethodBeat.o(38848);
    return false;
  }
  
  public final boolean bAV()
  {
    boolean bool3 = true;
    int i = 0;
    AppMethodBeat.i(38847);
    final int j = bc.ajj().aFd();
    Object localObject = bc.ajj().getNetworkServerIp();
    this.KVr = String.format("http://w.mail.qq.com/cgi-bin/report_mm?failuretype=1&devicetype=2&clientversion=%s&os=%s&username=%s&iport=%s&t=weixin_bulletin&f=xhtml&lang=%s", new Object[] { "0x" + Integer.toHexString(com.tencent.mm.protocal.d.FFH), com.tencent.mm.protocal.d.hjv, v.aAC(), localObject, ad.fom() });
    initialize();
    ae.i("MicroMsg.NetWarnView", "update st:%d", new Object[] { Integer.valueOf(j) });
    boolean bool1;
    boolean bool2;
    switch (j)
    {
    case 1: 
    case 4: 
    default: 
      bool1 = false;
      ((Context)this.FpA.get()).getResources().getColor(2131099676);
      if (bool1)
      {
        this.jpA.setVisibility(8);
        this.iYj.setVisibility(0);
        this.rY.setBackgroundResource(2131234376);
        localObject = new LinearLayout.LayoutParams(this.mdt.getLayoutParams());
        ((LinearLayout.LayoutParams)localObject).setMargins(com.tencent.mm.cb.a.fromDPToPix((Context)this.FpA.get(), 28), 0, com.tencent.mm.cb.a.fromDPToPix((Context)this.FpA.get(), 24), 0);
        this.mdt.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (o(this.mdt.getTag(), 2131690397))
        {
          this.mdt.setTag(Integer.valueOf(2131690397));
          this.mdt.setImageDrawable(ao.k((Context)this.FpA.get(), 2131690397, ((Context)this.FpA.get()).getResources().getColor(2131099803)));
        }
        this.KVo.setVisibility(8);
        this.KVp.setVisibility(8);
        this.KVm.setVisibility(8);
      }
      bool2 = bool1;
      if (!bool1)
      {
        this.KVn.setVisibility(8);
        bool2 = bool1;
        if (ac.iRb)
        {
          j = az.getBackgroundLimitType((Context)this.FpA.get());
          if ((!az.isLimited(j)) || (this.KVA)) {
            break;
          }
          this.iYj.setText(((Context)this.FpA.get()).getString(2131762019));
          this.iFO.setText(((Context)this.FpA.get()).getString(2131762018));
          this.iFO.setVisibility(0);
          this.KVl.setVisibility(8);
          this.KVq.setVisibility(8);
          this.mdt.setVisibility(0);
          this.KVn.setVisibility(0);
          this.rY.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(38840);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              try
              {
                az.startSettingItent((Context)o.this.FpA.get(), j);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(38840);
                return;
              }
              catch (Exception paramAnonymousView)
              {
                for (;;)
                {
                  ae.printErrStackTrace("MicroMsg.NetWarnView", paramAnonymousView, "", new Object[0]);
                }
              }
            }
          });
          this.KVn.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(38843);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              MMAppMgr.a((Context)o.this.FpA.get(), j, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(38841);
                  try
                  {
                    o.this.rY.setVisibility(8);
                    o.this.KVA = true;
                    az.startSettingItent((Context)o.this.FpA.get(), o.7.this.val$type);
                    AppMethodBeat.o(38841);
                    return;
                  }
                  catch (Exception paramAnonymous2DialogInterface)
                  {
                    ae.printErrStackTrace("MicroMsg.NetWarnView", paramAnonymous2DialogInterface, "", new Object[0]);
                    AppMethodBeat.o(38841);
                  }
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(38842);
                  o.this.rY.setVisibility(8);
                  o.this.KVA = true;
                  AppMethodBeat.o(38842);
                }
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(38843);
            }
          });
          bool1 = bool3;
          label537:
          bool2 = bool1;
        }
      }
      if (o(this.KVp.getTag(), 2131689878))
      {
        this.KVp.setTag(Integer.valueOf(2131689878));
        this.KVp.setImageResource(2131689878);
      }
      if (o(this.KVn.getTag(), 2131689878))
      {
        this.KVn.setTag(Integer.valueOf(2131689878));
        this.KVn.setImageResource(2131231325);
      }
      localObject = this.rY;
      if (!bool2) {}
      break;
    }
    for (;;)
    {
      ((View)localObject).setVisibility(i);
      AppMethodBeat.o(38847);
      return bool2;
      this.iYj.setText(2131761535);
      this.iFO.setVisibility(8);
      this.KVl.setVisibility(8);
      this.KVq.setVisibility(8);
      this.mdt.setVisibility(0);
      this.rY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38837);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("title", ((Context)o.this.FpA.get()).getString(2131761535));
          paramAnonymousView.putExtra("rawUrl", ((Context)o.this.FpA.get()).getString(2131761532));
          paramAnonymousView.putExtra("showShare", false);
          com.tencent.mm.br.d.b((Context)o.this.FpA.get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38837);
        }
      });
      bool1 = true;
      break;
      this.iYj.setText(2131761531);
      this.iFO.setVisibility(8);
      this.KVl.setVisibility(8);
      this.KVq.setVisibility(0);
      this.mdt.setVisibility(0);
      bool1 = true;
      break;
      if (this.BQU == 1) {
        this.iYj.setText(((Context)this.FpA.get()).getResources().getString(2131761534, new Object[] { Integer.valueOf(this.KVt) }));
      }
      for (;;)
      {
        this.iFO.setVisibility(8);
        this.KVl.setVisibility(8);
        this.KVq.setVisibility(8);
        this.mdt.setVisibility(0);
        this.rY.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(38838);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            o.a(o.this, o.this.BQU);
            o.this.BQU = 1;
            if (o.this.KVz == null)
            {
              paramAnonymousView = o.this;
              paramAnonymousView.KVz = new o.1(paramAnonymousView);
              com.tencent.mm.sdk.b.a.IvT.b(paramAnonymousView.KVz);
            }
            if (o.this.KVy == null)
            {
              paramAnonymousView = o.this;
              paramAnonymousView.KVy = new aw(new o.2(paramAnonymousView), true);
              paramAnonymousView.KVy.ay(1000L, 1000L);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38838);
          }
        });
        bool1 = true;
        break;
        this.iYj.setText(2131761533);
      }
      this.iYj.setText(2131761536);
      this.iFO.setText(((Context)this.FpA.get()).getString(2131761537));
      this.iFO.setVisibility(0);
      this.KVl.setVisibility(8);
      this.KVq.setVisibility(8);
      this.mdt.setVisibility(0);
      this.rY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38839);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (!bu.ce((Context)o.this.FpA.get(), o.this.KVr))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("title", ((Context)o.this.FpA.get()).getString(2131761538));
            paramAnonymousView.putExtra("rawUrl", ((Context)o.this.FpA.get()).getString(2131761532));
            paramAnonymousView.putExtra("showShare", false);
            com.tencent.mm.br.d.b((Context)o.this.FpA.get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38839);
        }
      });
      bool1 = true;
      break;
      this.KVn.setVisibility(8);
      break label537;
      i = 8;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38849);
    fNS();
    if (this.KVz != null) {
      com.tencent.mm.sdk.b.a.IvT.d(this.KVz);
    }
    AppMethodBeat.o(38849);
  }
  
  final void fNS()
  {
    AppMethodBeat.i(38846);
    if (this.KVy != null)
    {
      this.KVy.stopTimer();
      this.KVy = null;
    }
    AppMethodBeat.o(38846);
  }
  
  public final int getLayoutId()
  {
    return 2131495006;
  }
  
  public final int getOrder()
  {
    return 4;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38850);
    if (this.rY != null) {
      this.rY.setVisibility(paramInt);
    }
    AppMethodBeat.o(38850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.o
 * JD-Core Version:    0.7.0.1
 */