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
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.GreenManUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.ar;
import java.lang.ref.WeakReference;

public final class o
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private static final String DaV;
  private int GrC;
  private TextView QiB;
  private TextView QiC;
  private ImageView QiD;
  private ImageView QiE;
  private ImageView QiF;
  private ProgressBar QiG;
  private String QiH;
  private boolean QiI;
  private int QiJ;
  private boolean QiK;
  private boolean QiL;
  private boolean QiM;
  private String QiN;
  private MTimerHandler QiO;
  private IListener<nk> QiP;
  private boolean QiQ;
  private ProgressDialog gtM;
  private TextView jBR;
  private TextView jVO;
  private boolean jcC;
  private TextView knK;
  private ImageView nnL;
  private View sc;
  
  static
  {
    AppMethodBeat.i(234288);
    DaV = "http://" + WeChatHosts.domainString(2131761746) + "/cgi-bin/report_mm?failuretype=1&devicetype=2&clientversion=%s&os=%s&username=%s&iport=%s&t=weixin_bulletin&f=xhtml&lang=%s";
    AppMethodBeat.o(234288);
  }
  
  public o(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38844);
    this.gtM = null;
    this.jcC = false;
    this.QiI = false;
    this.GrC = 0;
    this.sc = null;
    this.QiQ = false;
    initialize();
    AppMethodBeat.o(38844);
  }
  
  private void gWm()
  {
    AppMethodBeat.i(38846);
    if (this.QiO != null)
    {
      this.QiO.stopTimer();
      this.QiO = null;
    }
    AppMethodBeat.o(38846);
  }
  
  private void initialize()
  {
    AppMethodBeat.i(38845);
    if ((!this.QiI) && (this.view != null))
    {
      this.sc = this.view.findViewById(2131305573);
      this.jVO = ((TextView)this.view.findViewById(2131305568));
      this.jBR = ((TextView)this.view.findViewById(2131305569));
      this.knK = ((TextView)this.view.findViewById(2131305570));
      this.QiB = ((TextView)this.view.findViewById(2131305567));
      this.QiG = ((ProgressBar)this.view.findViewById(2131305572));
      this.nnL = ((ImageView)this.view.findViewById(2131305571));
      this.QiD = ((ImageView)this.view.findViewById(2131298778));
      this.QiE = ((ImageView)this.view.findViewById(2131301702));
      this.QiF = ((ImageView)this.view.findViewById(2131307908));
      this.QiC = ((TextView)this.view.findViewById(2131300100));
      this.QiD.setVisibility(8);
      this.QiI = true;
    }
    AppMethodBeat.o(38845);
  }
  
  private static boolean q(Object paramObject, int paramInt)
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
  
  public final boolean bYa()
  {
    boolean bool3 = true;
    int i = 0;
    AppMethodBeat.i(38847);
    final int j = bg.azz().aYS();
    Object localObject = bg.azz().getNetworkServerIp();
    this.QiH = String.format(DaV, new Object[] { "0x" + Integer.toHexString(d.KyO), d.ics, z.aTY(), localObject, LocaleUtil.getApplicationLanguage() });
    initialize();
    Log.i("MicroMsg.NetWarnView", "update st:%d", new Object[] { Integer.valueOf(j) });
    boolean bool1;
    boolean bool2;
    switch (j)
    {
    case 1: 
    case 4: 
    default: 
      bool1 = false;
      ((Context)this.Kgr.get()).getResources().getColor(2131099683);
      if (bool1)
      {
        this.knK.setVisibility(8);
        this.jVO.setVisibility(0);
        this.sc.setBackgroundResource(2131235298);
        localObject = new LinearLayout.LayoutParams(this.nnL.getLayoutParams());
        ((LinearLayout.LayoutParams)localObject).setMargins(com.tencent.mm.cb.a.fromDPToPix((Context)this.Kgr.get(), 28), 0, com.tencent.mm.cb.a.fromDPToPix((Context)this.Kgr.get(), 24), 0);
        this.nnL.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (q(this.nnL.getTag(), 2131690547))
        {
          this.nnL.setTag(Integer.valueOf(2131690547));
          this.nnL.setImageDrawable(ar.m((Context)this.Kgr.get(), 2131690547, ((Context)this.Kgr.get()).getResources().getColor(2131099818)));
        }
        this.QiE.setVisibility(8);
        this.QiF.setVisibility(8);
        this.QiC.setVisibility(8);
      }
      bool2 = bool1;
      if (!bool1)
      {
        this.QiD.setVisibility(8);
        bool2 = bool1;
        if (ac.jNV)
        {
          j = NetStatusUtil.getBackgroundLimitType((Context)this.Kgr.get());
          if ((!NetStatusUtil.isLimited(j)) || (this.QiQ)) {
            break;
          }
          this.jVO.setText(((Context)this.Kgr.get()).getString(2131764029));
          this.jBR.setText(((Context)this.Kgr.get()).getString(2131764028));
          this.jBR.setVisibility(0);
          this.QiB.setVisibility(8);
          this.QiG.setVisibility(8);
          this.nnL.setVisibility(0);
          this.QiD.setVisibility(0);
          this.sc.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(38840);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              try
              {
                NetStatusUtil.startSettingItent((Context)o.v(o.this).get(), j);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(38840);
                return;
              }
              catch (Exception paramAnonymousView)
              {
                for (;;)
                {
                  Log.printErrStackTrace("MicroMsg.NetWarnView", paramAnonymousView, "", new Object[0]);
                }
              }
            }
          });
          this.QiD.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(38843);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              MMAppMgr.a((Context)o.w(o.this).get(), j, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(38841);
                  try
                  {
                    o.x(o.this).setVisibility(8);
                    o.y(o.this);
                    NetStatusUtil.startSettingItent((Context)o.z(o.this).get(), o.7.this.val$type);
                    AppMethodBeat.o(38841);
                    return;
                  }
                  catch (Exception paramAnonymous2DialogInterface)
                  {
                    Log.printErrStackTrace("MicroMsg.NetWarnView", paramAnonymous2DialogInterface, "", new Object[0]);
                    AppMethodBeat.o(38841);
                  }
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(38842);
                  o.x(o.this).setVisibility(8);
                  o.y(o.this);
                  AppMethodBeat.o(38842);
                }
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(38843);
            }
          });
          bool1 = bool3;
          label541:
          bool2 = bool1;
        }
      }
      if (q(this.QiF.getTag(), 2131689893))
      {
        this.QiF.setTag(Integer.valueOf(2131689893));
        this.QiF.setImageResource(2131689893);
      }
      if (q(this.QiD.getTag(), 2131689893))
      {
        this.QiD.setTag(Integer.valueOf(2131689893));
        this.QiD.setImageResource(2131231385);
      }
      localObject = this.sc;
      if (!bool2) {}
      break;
    }
    for (;;)
    {
      ((View)localObject).setVisibility(i);
      AppMethodBeat.o(38847);
      return bool2;
      this.jVO.setText(2131763501);
      this.jBR.setVisibility(8);
      this.QiB.setVisibility(8);
      this.QiG.setVisibility(8);
      this.nnL.setVisibility(0);
      this.sc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38837);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("title", ((Context)o.j(o.this).get()).getString(2131763501));
          paramAnonymousView.putExtra("rawUrl", ((Context)o.k(o.this).get()).getString(2131763498));
          paramAnonymousView.putExtra("neverGetA8Key", true);
          paramAnonymousView.putExtra("showShare", false);
          c.b((Context)o.l(o.this).get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38837);
        }
      });
      bool1 = true;
      break;
      this.jVO.setText(2131763497);
      this.jBR.setVisibility(8);
      this.QiB.setVisibility(8);
      this.QiG.setVisibility(0);
      this.nnL.setVisibility(0);
      bool1 = true;
      break;
      if (this.GrC == 1) {
        this.jVO.setText(((Context)this.Kgr.get()).getResources().getString(2131763500, new Object[] { Integer.valueOf(this.QiJ) }));
      }
      for (;;)
      {
        this.jBR.setVisibility(8);
        this.QiB.setVisibility(8);
        this.QiG.setVisibility(8);
        this.nnL.setVisibility(0);
        this.sc.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(38838);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            o.c(o.this, o.g(o.this));
            o.b(o.this, 1);
            if (o.m(o.this) == null) {
              o.n(o.this);
            }
            if (o.o(o.this) == null) {
              o.p(o.this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38838);
          }
        });
        bool1 = true;
        break;
        this.jVO.setText(2131763499);
      }
      this.jVO.setText(2131763502);
      this.jBR.setText(((Context)this.Kgr.get()).getString(2131763503));
      this.jBR.setVisibility(0);
      this.QiB.setVisibility(8);
      this.QiG.setVisibility(8);
      this.nnL.setVisibility(0);
      this.sc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38839);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (!Util.jump((Context)o.q(o.this).get(), o.r(o.this)))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("title", ((Context)o.s(o.this).get()).getString(2131763504));
            paramAnonymousView.putExtra("rawUrl", ((Context)o.t(o.this).get()).getString(2131763498));
            paramAnonymousView.putExtra("showShare", false);
            c.b((Context)o.u(o.this).get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38839);
        }
      });
      bool1 = true;
      break;
      this.QiD.setVisibility(8);
      break label541;
      i = 8;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38849);
    gWm();
    if (this.QiP != null) {
      EventCenter.instance.removeListener(this.QiP);
    }
    AppMethodBeat.o(38849);
  }
  
  public final int getLayoutId()
  {
    return 2131495836;
  }
  
  public final int getOrder()
  {
    return 4;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38850);
    if (this.sc != null) {
      this.sc.setVisibility(paramInt);
    }
    AppMethodBeat.o(38850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.o
 * JD-Core Version:    0.7.0.1
 */