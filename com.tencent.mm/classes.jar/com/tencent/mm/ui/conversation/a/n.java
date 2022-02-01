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
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.oc;
import com.tencent.mm.model.bh;
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
import com.tencent.mm.ui.au;
import java.lang.ref.WeakReference;

public final class n
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private static final String Jgw;
  private int Nen;
  private TextView XFH;
  private TextView XFI;
  private ImageView XFJ;
  private ImageView XFK;
  private ImageView XFL;
  private ProgressBar XFM;
  private String XFN;
  private boolean XFO;
  private int XFP;
  private boolean XFQ;
  private boolean XFR;
  private boolean XFS;
  private String XFT;
  private MTimerHandler XFU;
  private IListener<oc> XFV;
  private boolean XFW;
  private View bvK;
  private ProgressDialog iXX;
  private boolean lTb;
  private TextView mNb;
  private TextView mrM;
  private TextView nfC;
  private ImageView qps;
  
  static
  {
    AppMethodBeat.i(245985);
    Jgw = "http://" + WeChatHosts.domainString(R.l.host_w_mail_qq_com) + "/cgi-bin/report_mm?failuretype=1&devicetype=2&clientversion=%s&os=%s&username=%s&iport=%s&t=weixin_bulletin&f=xhtml&lang=%s";
    AppMethodBeat.o(245985);
  }
  
  public n(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38844);
    this.iXX = null;
    this.lTb = false;
    this.XFO = false;
    this.Nen = 0;
    this.bvK = null;
    this.XFW = false;
    initialize();
    AppMethodBeat.o(38844);
  }
  
  private void hWO()
  {
    AppMethodBeat.i(38846);
    if (this.XFU != null)
    {
      this.XFU.stopTimer();
      this.XFU = null;
    }
    AppMethodBeat.o(38846);
  }
  
  private void initialize()
  {
    AppMethodBeat.i(38845);
    if ((!this.XFO) && (this.view != null))
    {
      this.bvK = this.view.findViewById(R.h.dQA);
      this.mNb = ((TextView)this.view.findViewById(R.h.dQw));
      this.mrM = ((TextView)this.view.findViewById(R.h.dQx));
      this.nfC = ((TextView)this.view.findViewById(R.h.dQy));
      this.XFH = ((TextView)this.view.findViewById(R.h.nw_btn));
      this.XFM = ((ProgressBar)this.view.findViewById(R.h.dQz));
      this.qps = ((ImageView)this.view.findViewById(R.h.nw_icon));
      this.XFJ = ((ImageView)this.view.findViewById(R.h.close_icon));
      this.XFK = ((ImageView)this.view.findViewById(R.h.dHD));
      this.XFL = ((ImageView)this.view.findViewById(R.h.dVo));
      this.XFI = ((TextView)this.view.findViewById(R.h.dFy));
      this.XFJ.setVisibility(8);
      this.XFO = true;
    }
    AppMethodBeat.o(38845);
  }
  
  private static boolean w(Object paramObject, int paramInt)
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
  
  public final boolean ckL()
  {
    boolean bool3 = true;
    int i = 0;
    AppMethodBeat.i(38847);
    final int j = bh.aGY().bih();
    Object localObject = bh.aGY().getNetworkServerIp();
    this.XFN = String.format(Jgw, new Object[] { "0x" + Integer.toHexString(d.RAD), d.kQZ, z.bcZ(), localObject, LocaleUtil.getApplicationLanguage() });
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
      ((Context)this.Rhc.get()).getResources().getColor(R.e.BW_50);
      if (bool1)
      {
        this.nfC.setVisibility(8);
        this.mNb.setVisibility(0);
        this.bvK.setBackgroundResource(R.g.tips_bar_red_selector);
        localObject = new LinearLayout.LayoutParams(this.qps.getLayoutParams());
        ((LinearLayout.LayoutParams)localObject).setMargins(com.tencent.mm.ci.a.fromDPToPix((Context)this.Rhc.get(), 28), 0, com.tencent.mm.ci.a.fromDPToPix((Context)this.Rhc.get(), 24), 0);
        this.qps.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (w(this.qps.getTag(), R.k.icons_filled_error))
        {
          this.qps.setTag(Integer.valueOf(R.k.icons_filled_error));
          this.qps.setImageDrawable(au.o((Context)this.Rhc.get(), R.k.icons_filled_error, ((Context)this.Rhc.get()).getResources().getColor(R.e.Red)));
        }
        this.XFK.setVisibility(8);
        this.XFL.setVisibility(8);
        this.XFI.setVisibility(8);
      }
      bool2 = bool1;
      if (!bool1)
      {
        this.XFJ.setVisibility(8);
        bool2 = bool1;
        if (ac.mFe)
        {
          j = NetStatusUtil.getBackgroundLimitType((Context)this.Rhc.get());
          if ((!NetStatusUtil.isLimited(j)) || (this.XFW)) {
            break;
          }
          this.mNb.setText(((Context)this.Rhc.get()).getString(R.l.ePx));
          this.mrM.setText(((Context)this.Rhc.get()).getString(R.l.ePw));
          this.mrM.setVisibility(0);
          this.XFH.setVisibility(8);
          this.XFM.setVisibility(8);
          this.qps.setVisibility(0);
          this.XFJ.setVisibility(0);
          this.bvK.setOnClickListener(new n.6(this, j));
          this.XFJ.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(38843);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/NetWarnBanner$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              MMAppMgr.a((Context)n.w(n.this).get(), j, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(38841);
                  try
                  {
                    n.x(n.this).setVisibility(8);
                    n.y(n.this);
                    NetStatusUtil.startSettingItent((Context)n.z(n.this).get(), n.7.this.val$type);
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
                  n.x(n.this).setVisibility(8);
                  n.y(n.this);
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
      if (w(this.XFL.getTag(), R.k.chat_mute_notify_normal))
      {
        this.XFL.setTag(Integer.valueOf(R.k.chat_mute_notify_normal));
        this.XFL.setImageResource(R.k.chat_mute_notify_normal);
      }
      if (w(this.XFJ.getTag(), R.k.chat_mute_notify_normal))
      {
        this.XFJ.setTag(Integer.valueOf(R.k.chat_mute_notify_normal));
        this.XFJ.setImageResource(R.g.dmC);
      }
      localObject = this.bvK;
      if (!bool2) {}
      break;
    }
    for (;;)
    {
      ((View)localObject).setVisibility(i);
      AppMethodBeat.o(38847);
      return bool2;
      this.mNb.setText(R.l.net_warn_no_network);
      this.mrM.setVisibility(8);
      this.XFH.setVisibility(8);
      this.XFM.setVisibility(8);
      this.qps.setVisibility(0);
      this.bvK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38837);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/NetWarnBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("title", ((Context)n.j(n.this).get()).getString(R.l.net_warn_no_network));
          paramAnonymousView.putExtra("rawUrl", ((Context)n.k(n.this).get()).getString(R.l.net_warn_detail_doc));
          paramAnonymousView.putExtra("neverGetA8Key", true);
          paramAnonymousView.putExtra("showShare", false);
          c.b((Context)n.l(n.this).get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38837);
        }
      });
      bool1 = true;
      break;
      this.mNb.setText(R.l.net_warn_connecting);
      this.mrM.setVisibility(8);
      this.XFH.setVisibility(8);
      this.XFM.setVisibility(0);
      this.qps.setVisibility(0);
      bool1 = true;
      break;
      if (this.Nen == 1) {
        this.mNb.setText(((Context)this.Rhc.get()).getResources().getString(R.l.net_warn_diagnose_doing, new Object[] { Integer.valueOf(this.XFP) }));
      }
      for (;;)
      {
        this.mrM.setVisibility(8);
        this.XFH.setVisibility(8);
        this.XFM.setVisibility(8);
        this.qps.setVisibility(0);
        this.bvK.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(38838);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/NetWarnBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            n.c(n.this, n.g(n.this));
            n.b(n.this, 1);
            if (n.m(n.this) == null) {
              n.n(n.this);
            }
            if (n.o(n.this) == null) {
              n.p(n.this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38838);
          }
        });
        bool1 = true;
        break;
        this.mNb.setText(R.l.net_warn_diagnose_begin);
      }
      this.mNb.setText(R.l.net_warn_server_down);
      this.mrM.setText(((Context)this.Rhc.get()).getString(R.l.net_warn_server_down_tip));
      this.mrM.setVisibility(0);
      this.XFH.setVisibility(8);
      this.XFM.setVisibility(8);
      this.qps.setVisibility(0);
      this.bvK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38839);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/NetWarnBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!Util.jump((Context)n.q(n.this).get(), n.r(n.this)))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("title", ((Context)n.s(n.this).get()).getString(R.l.net_warn_server_failed));
            paramAnonymousView.putExtra("rawUrl", ((Context)n.t(n.this).get()).getString(R.l.net_warn_detail_doc));
            paramAnonymousView.putExtra("showShare", false);
            c.b((Context)n.u(n.this).get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38839);
        }
      });
      bool1 = true;
      break;
      this.XFJ.setVisibility(8);
      break label541;
      i = 8;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38849);
    hWO();
    if (this.XFV != null) {
      EventCenter.instance.removeListener(this.XFV);
    }
    AppMethodBeat.o(38849);
  }
  
  public final int getLayoutId()
  {
    return R.i.ejr;
  }
  
  public final int getOrder()
  {
    return 4;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38850);
    if (this.bvK != null) {
      this.bvK.setVisibility(paramInt);
    }
    AppMethodBeat.o(38850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.n
 * JD-Core Version:    0.7.0.1
 */