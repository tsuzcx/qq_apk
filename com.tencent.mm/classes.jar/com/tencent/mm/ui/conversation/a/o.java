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
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.ao;
import java.lang.ref.WeakReference;

public final class o
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  int Bzw;
  private TextView KyR;
  private TextView KyS;
  private ImageView KyT;
  private ImageView KyU;
  private ImageView KyV;
  private ProgressBar KyW;
  String KyX;
  private boolean KyY;
  int KyZ;
  boolean Kza;
  boolean Kzb;
  boolean Kzc;
  String Kzd;
  av Kze;
  c<ms> Kzf;
  boolean Kzg;
  private ProgressDialog fMu;
  private TextView iCV;
  TextView iVq;
  private boolean ieP;
  private TextView jmG;
  private ImageView lZa;
  View rY;
  
  public o(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38844);
    this.fMu = null;
    this.ieP = false;
    this.KyY = false;
    this.Bzw = 0;
    this.rY = null;
    this.Kzg = false;
    initialize();
    AppMethodBeat.o(38844);
  }
  
  private void initialize()
  {
    AppMethodBeat.i(38845);
    if ((!this.KyY) && (this.view != null))
    {
      this.rY = this.view.findViewById(2131302984);
      this.iVq = ((TextView)this.view.findViewById(2131302979));
      this.iCV = ((TextView)this.view.findViewById(2131302980));
      this.jmG = ((TextView)this.view.findViewById(2131302981));
      this.KyR = ((TextView)this.view.findViewById(2131302978));
      this.KyW = ((ProgressBar)this.view.findViewById(2131302983));
      this.lZa = ((ImageView)this.view.findViewById(2131302982));
      this.KyT = ((ImageView)this.view.findViewById(2131298370));
      this.KyU = ((ImageView)this.view.findViewById(2131300228));
      this.KyV = ((ImageView)this.view.findViewById(2131304824));
      this.KyS = ((TextView)this.view.findViewById(2131299471));
      this.KyT.setVisibility(8);
      this.KyY = true;
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
  
  public final boolean bAa()
  {
    boolean bool3 = true;
    int i = 0;
    AppMethodBeat.i(38847);
    final int j = ba.aiU().aEN();
    Object localObject = ba.aiU().getNetworkServerIp();
    this.KyX = String.format("http://w.mail.qq.com/cgi-bin/report_mm?failuretype=1&devicetype=2&clientversion=%s&os=%s&username=%s&iport=%s&t=weixin_bulletin&f=xhtml&lang=%s", new Object[] { "0x" + Integer.toHexString(com.tencent.mm.protocal.d.Fnj), com.tencent.mm.protocal.d.hgH, u.aAm(), localObject, com.tencent.mm.sdk.platformtools.ac.fks() });
    initialize();
    ad.i("MicroMsg.NetWarnView", "update st:%d", new Object[] { Integer.valueOf(j) });
    boolean bool1;
    boolean bool2;
    switch (j)
    {
    case 1: 
    case 4: 
    default: 
      bool1 = false;
      ((Context)this.EXg.get()).getResources().getColor(2131099676);
      if (bool1)
      {
        this.jmG.setVisibility(8);
        this.iVq.setVisibility(0);
        this.rY.setBackgroundResource(2131234376);
        localObject = new LinearLayout.LayoutParams(this.lZa.getLayoutParams());
        ((LinearLayout.LayoutParams)localObject).setMargins(com.tencent.mm.cc.a.fromDPToPix((Context)this.EXg.get(), 28), 0, com.tencent.mm.cc.a.fromDPToPix((Context)this.EXg.get(), 24), 0);
        this.lZa.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (o(this.lZa.getTag(), 2131690397))
        {
          this.lZa.setTag(Integer.valueOf(2131690397));
          this.lZa.setImageDrawable(ao.k((Context)this.EXg.get(), 2131690397, ((Context)this.EXg.get()).getResources().getColor(2131099803)));
        }
        this.KyU.setVisibility(8);
        this.KyV.setVisibility(8);
        this.KyS.setVisibility(8);
      }
      bool2 = bool1;
      if (!bool1)
      {
        this.KyT.setVisibility(8);
        bool2 = bool1;
        if (com.tencent.mm.platformtools.ac.iOh)
        {
          j = ay.getBackgroundLimitType((Context)this.EXg.get());
          if ((!ay.isLimited(j)) || (this.Kzg)) {
            break;
          }
          this.iVq.setText(((Context)this.EXg.get()).getString(2131762019));
          this.iCV.setText(((Context)this.EXg.get()).getString(2131762018));
          this.iCV.setVisibility(0);
          this.KyR.setVisibility(8);
          this.KyW.setVisibility(8);
          this.lZa.setVisibility(0);
          this.KyT.setVisibility(0);
          this.rY.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(38840);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              try
              {
                ay.startSettingItent((Context)o.this.EXg.get(), j);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(38840);
                return;
              }
              catch (Exception paramAnonymousView)
              {
                for (;;)
                {
                  ad.printErrStackTrace("MicroMsg.NetWarnView", paramAnonymousView, "", new Object[0]);
                }
              }
            }
          });
          this.KyT.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(38843);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              MMAppMgr.a((Context)o.this.EXg.get(), j, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(38841);
                  try
                  {
                    o.this.rY.setVisibility(8);
                    o.this.Kzg = true;
                    ay.startSettingItent((Context)o.this.EXg.get(), o.7.this.val$type);
                    AppMethodBeat.o(38841);
                    return;
                  }
                  catch (Exception paramAnonymous2DialogInterface)
                  {
                    ad.printErrStackTrace("MicroMsg.NetWarnView", paramAnonymous2DialogInterface, "", new Object[0]);
                    AppMethodBeat.o(38841);
                  }
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(38842);
                  o.this.rY.setVisibility(8);
                  o.this.Kzg = true;
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
      if (o(this.KyV.getTag(), 2131689878))
      {
        this.KyV.setTag(Integer.valueOf(2131689878));
        this.KyV.setImageResource(2131689878);
      }
      if (o(this.KyT.getTag(), 2131689878))
      {
        this.KyT.setTag(Integer.valueOf(2131689878));
        this.KyT.setImageResource(2131231325);
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
      this.iVq.setText(2131761535);
      this.iCV.setVisibility(8);
      this.KyR.setVisibility(8);
      this.KyW.setVisibility(8);
      this.lZa.setVisibility(0);
      this.rY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38837);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("title", ((Context)o.this.EXg.get()).getString(2131761535));
          paramAnonymousView.putExtra("rawUrl", ((Context)o.this.EXg.get()).getString(2131761532));
          paramAnonymousView.putExtra("showShare", false);
          com.tencent.mm.bs.d.b((Context)o.this.EXg.get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38837);
        }
      });
      bool1 = true;
      break;
      this.iVq.setText(2131761531);
      this.iCV.setVisibility(8);
      this.KyR.setVisibility(8);
      this.KyW.setVisibility(0);
      this.lZa.setVisibility(0);
      bool1 = true;
      break;
      if (this.Bzw == 1) {
        this.iVq.setText(((Context)this.EXg.get()).getResources().getString(2131761534, new Object[] { Integer.valueOf(this.KyZ) }));
      }
      for (;;)
      {
        this.iCV.setVisibility(8);
        this.KyR.setVisibility(8);
        this.KyW.setVisibility(8);
        this.lZa.setVisibility(0);
        this.rY.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(38838);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            o.a(o.this, o.this.Bzw);
            o.this.Bzw = 1;
            if (o.this.Kzf == null)
            {
              paramAnonymousView = o.this;
              paramAnonymousView.Kzf = new o.1(paramAnonymousView);
              com.tencent.mm.sdk.b.a.IbL.b(paramAnonymousView.Kzf);
            }
            if (o.this.Kze == null)
            {
              paramAnonymousView = o.this;
              paramAnonymousView.Kze = new av(new o.2(paramAnonymousView), true);
              paramAnonymousView.Kze.az(1000L, 1000L);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38838);
          }
        });
        bool1 = true;
        break;
        this.iVq.setText(2131761533);
      }
      this.iVq.setText(2131761536);
      this.iCV.setText(((Context)this.EXg.get()).getString(2131761537));
      this.iCV.setVisibility(0);
      this.KyR.setVisibility(8);
      this.KyW.setVisibility(8);
      this.lZa.setVisibility(0);
      this.rY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38839);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (!bt.cd((Context)o.this.EXg.get(), o.this.KyX))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("title", ((Context)o.this.EXg.get()).getString(2131761538));
            paramAnonymousView.putExtra("rawUrl", ((Context)o.this.EXg.get()).getString(2131761532));
            paramAnonymousView.putExtra("showShare", false);
            com.tencent.mm.bs.d.b((Context)o.this.EXg.get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38839);
        }
      });
      bool1 = true;
      break;
      this.KyT.setVisibility(8);
      break label537;
      i = 8;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38849);
    fJB();
    if (this.Kzf != null) {
      com.tencent.mm.sdk.b.a.IbL.d(this.Kzf);
    }
    AppMethodBeat.o(38849);
  }
  
  final void fJB()
  {
    AppMethodBeat.i(38846);
    if (this.Kze != null)
    {
      this.Kze.stopTimer();
      this.Kze = null;
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