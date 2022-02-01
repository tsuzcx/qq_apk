package com.tencent.mm.ui.conversation.banner;

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
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.pk;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.bb;
import java.lang.ref.WeakReference;

public final class n
  extends com.tencent.mm.pluginsdk.ui.a.b
{
  private static final String Pro;
  private int TRa;
  private TextView aftF;
  private TextView aftG;
  private ImageView aftH;
  private ImageView aftI;
  private ImageView aftJ;
  private ProgressBar aftK;
  private String aftL;
  private boolean aftM;
  private int aftN;
  private boolean aftO;
  private boolean aftP;
  private boolean aftQ;
  private String aftR;
  private MTimerHandler aftS;
  private IListener<pk> aftT;
  private boolean aftU;
  private View doN;
  private ProgressDialog lzP;
  private boolean oLU;
  private TextView pJJ;
  private TextView plr;
  private TextView qcL;
  private ImageView ttT;
  
  static
  {
    AppMethodBeat.i(257208);
    Pro = "http://" + WeChatHosts.domainString(R.l.host_w_mail_qq_com) + "/cgi-bin/report_mm?failuretype=1&devicetype=2&clientversion=%s&os=%s&username=%s&iport=%s&t=weixin_bulletin&f=xhtml&lang=%s";
    AppMethodBeat.o(257208);
  }
  
  public n(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38844);
    this.lzP = null;
    this.oLU = false;
    this.aftM = false;
    this.TRa = 0;
    this.doN = null;
    this.aftU = false;
    initialize();
    AppMethodBeat.o(38844);
  }
  
  private void initialize()
  {
    AppMethodBeat.i(38845);
    if ((!this.aftM) && (this.view != null))
    {
      this.doN = this.view.findViewById(R.h.fSF);
      this.pJJ = ((TextView)this.view.findViewById(R.h.fSB));
      this.plr = ((TextView)this.view.findViewById(R.h.fSC));
      this.qcL = ((TextView)this.view.findViewById(R.h.fSD));
      this.aftF = ((TextView)this.view.findViewById(R.h.nw_btn));
      this.aftK = ((ProgressBar)this.view.findViewById(R.h.fSE));
      this.ttT = ((ImageView)this.view.findViewById(R.h.nw_icon));
      this.aftH = ((ImageView)this.view.findViewById(R.h.close_icon));
      this.aftI = ((ImageView)this.view.findViewById(R.h.fIN));
      this.aftJ = ((ImageView)this.view.findViewById(R.h.fXK));
      this.aftG = ((TextView)this.view.findViewById(R.h.fGE));
      this.aftH.setVisibility(8);
      this.aftM = true;
    }
    AppMethodBeat.o(38845);
  }
  
  private void jBg()
  {
    AppMethodBeat.i(38846);
    if (this.aftS != null)
    {
      this.aftS.stopTimer();
      this.aftS = null;
    }
    AppMethodBeat.o(38846);
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
  
  public final boolean cMa()
  {
    boolean bool3 = true;
    int i = 0;
    AppMethodBeat.i(38847);
    final int j = bh.aZW().bFQ();
    Object localObject = bh.aZW().getNetworkServerIp();
    this.aftL = String.format(Pro, new Object[] { "0x" + Integer.toHexString(d.Yxh), d.nsC, com.tencent.mm.model.z.bAM(), localObject, LocaleUtil.getApplicationLanguage() });
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
      ((Context)this.Ydi.get()).getResources().getColor(R.e.BW_50);
      if (bool1)
      {
        this.qcL.setVisibility(8);
        this.pJJ.setVisibility(0);
        this.doN.setBackgroundResource(R.g.tips_bar_red_selector);
        localObject = new LinearLayout.LayoutParams(this.ttT.getLayoutParams());
        ((LinearLayout.LayoutParams)localObject).setMargins(com.tencent.mm.cd.a.fromDPToPix((Context)this.Ydi.get(), 28), 0, com.tencent.mm.cd.a.fromDPToPix((Context)this.Ydi.get(), 24), 0);
        this.ttT.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (w(this.ttT.getTag(), R.k.icons_filled_error))
        {
          this.ttT.setTag(Integer.valueOf(R.k.icons_filled_error));
          this.ttT.setImageDrawable(bb.m((Context)this.Ydi.get(), R.k.icons_filled_error, ((Context)this.Ydi.get()).getResources().getColor(R.e.Red)));
        }
        this.aftI.setVisibility(8);
        this.aftJ.setVisibility(8);
        this.aftG.setVisibility(8);
      }
      bool2 = bool1;
      if (!bool1)
      {
        this.aftH.setVisibility(8);
        bool2 = bool1;
        if (com.tencent.mm.platformtools.z.pBF)
        {
          j = NetStatusUtil.getBackgroundLimitType((Context)this.Ydi.get());
          if ((!NetStatusUtil.isLimited(j)) || (this.aftU)) {
            break;
          }
          this.pJJ.setText(((Context)this.Ydi.get()).getString(R.l.gRZ));
          this.plr.setText(((Context)this.Ydi.get()).getString(R.l.gRY));
          this.plr.setVisibility(0);
          this.aftF.setVisibility(8);
          this.aftK.setVisibility(8);
          this.ttT.setVisibility(0);
          this.aftH.setVisibility(0);
          this.doN.setOnClickListener(new n.5(this, j));
          this.aftH.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(38843);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/NetWarnBanner$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              MMAppMgr.a((Context)n.x(n.this).get(), j, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(38841);
                  try
                  {
                    n.y(n.this).setVisibility(8);
                    n.z(n.this);
                    NetStatusUtil.startSettingItent((Context)n.A(n.this).get(), n.6.this.val$type);
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
                  n.y(n.this).setVisibility(8);
                  n.z(n.this);
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
      if (w(this.aftJ.getTag(), R.k.chat_mute_notify_normal))
      {
        this.aftJ.setTag(Integer.valueOf(R.k.chat_mute_notify_normal));
        this.aftJ.setImageResource(R.k.chat_mute_notify_normal);
      }
      if (w(this.aftH.getTag(), R.k.chat_mute_notify_normal))
      {
        this.aftH.setTag(Integer.valueOf(R.k.chat_mute_notify_normal));
        this.aftH.setImageResource(R.g.fmO);
      }
      localObject = this.doN;
      if (!bool2) {}
      break;
    }
    for (;;)
    {
      ((View)localObject).setVisibility(i);
      AppMethodBeat.o(38847);
      return bool2;
      this.pJJ.setText(R.l.net_warn_no_network);
      this.plr.setVisibility(8);
      this.aftF.setVisibility(8);
      this.aftK.setVisibility(8);
      this.ttT.setVisibility(0);
      this.doN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38837);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/NetWarnBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("title", ((Context)n.k(n.this).get()).getString(R.l.net_warn_no_network));
          paramAnonymousView.putExtra("rawUrl", ((Context)n.l(n.this).get()).getString(R.l.net_warn_detail_doc));
          paramAnonymousView.putExtra("neverGetA8Key", true);
          paramAnonymousView.putExtra("showShare", false);
          c.b((Context)n.m(n.this).get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38837);
        }
      });
      bool1 = true;
      break;
      this.pJJ.setText(R.l.net_warn_connecting);
      this.plr.setVisibility(8);
      this.aftF.setVisibility(8);
      this.aftK.setVisibility(0);
      this.ttT.setVisibility(0);
      bool1 = true;
      break;
      if (this.TRa == 1) {
        this.pJJ.setText(((Context)this.Ydi.get()).getResources().getString(R.l.net_warn_diagnose_doing, new Object[] { Integer.valueOf(this.aftN) }));
      }
      for (;;)
      {
        this.plr.setVisibility(8);
        this.aftF.setVisibility(8);
        this.aftK.setVisibility(8);
        this.ttT.setVisibility(0);
        this.doN.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(38838);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/NetWarnBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            n.c(n.this, n.h(n.this));
            n.b(n.this, 1);
            if (n.n(n.this) == null) {
              n.o(n.this);
            }
            if (n.p(n.this) == null) {
              n.q(n.this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38838);
          }
        });
        bool1 = true;
        break;
        this.pJJ.setText(R.l.net_warn_diagnose_begin);
      }
      this.pJJ.setText(R.l.net_warn_server_down);
      this.plr.setText(((Context)this.Ydi.get()).getString(R.l.net_warn_server_down_tip));
      this.plr.setVisibility(0);
      this.aftF.setVisibility(8);
      this.aftK.setVisibility(8);
      this.ttT.setVisibility(0);
      this.doN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38839);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/NetWarnBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (!Util.jump((Context)n.r(n.this).get(), n.s(n.this)))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("title", ((Context)n.t(n.this).get()).getString(R.l.net_warn_server_failed));
            paramAnonymousView.putExtra("rawUrl", ((Context)n.u(n.this).get()).getString(R.l.net_warn_detail_doc));
            paramAnonymousView.putExtra("showShare", false);
            c.b((Context)n.v(n.this).get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38839);
        }
      });
      bool1 = true;
      break;
      this.aftH.setVisibility(8);
      break label541;
      i = 8;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38849);
    jBg();
    if (this.aftT != null) {
      this.aftT.dead();
    }
    AppMethodBeat.o(38849);
  }
  
  public final int getLayoutId()
  {
    return R.i.gms;
  }
  
  public final int getOrder()
  {
    return 4;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38850);
    if (this.doN != null) {
      this.doN.setVisibility(paramInt);
    }
    AppMethodBeat.o(38850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.banner.n
 * JD-Core Version:    0.7.0.1
 */