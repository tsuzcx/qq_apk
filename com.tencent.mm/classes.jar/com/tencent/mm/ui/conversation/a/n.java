package com.tencent.mm.ui.conversation.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.ki;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public final class n
  extends b
{
  private ProgressDialog dnm = null;
  TextView eXO;
  private TextView eXP;
  private boolean esC = false;
  private TextView foy;
  private ImageView gSx;
  View hNa = null;
  int pIS = 0;
  private TextView vVd;
  private TextView vVe;
  private ImageView vVf;
  private ImageView vVg;
  private ImageView vVh;
  private ProgressBar vVi;
  String vVj;
  private boolean vVk = false;
  int vVl;
  boolean vVm;
  boolean vVn;
  boolean vVo;
  String vVp;
  am vVq;
  com.tencent.mm.sdk.b.c<ki> vVr;
  boolean vVs = false;
  
  public n(Context paramContext)
  {
    super(paramContext);
    initialize();
  }
  
  private void initialize()
  {
    if ((!this.vVk) && (this.view != null))
    {
      this.hNa = this.view.findViewById(R.h.nwview);
      this.eXO = ((TextView)this.view.findViewById(R.h.nw_detail));
      this.eXP = ((TextView)this.view.findViewById(R.h.nw_detail_tip));
      this.foy = ((TextView)this.view.findViewById(R.h.nw_hint_tip));
      this.vVd = ((TextView)this.view.findViewById(R.h.nw_btn));
      this.vVi = ((ProgressBar)this.view.findViewById(R.h.nw_prog));
      this.gSx = ((ImageView)this.view.findViewById(R.h.nw_icon));
      this.vVf = ((ImageView)this.view.findViewById(R.h.close_icon));
      this.vVg = ((ImageView)this.view.findViewById(R.h.forward_icon));
      this.vVh = ((ImageView)this.view.findViewById(R.h.silent_icon));
      this.vVe = ((TextView)this.view.findViewById(R.h.empty_space));
      this.vVf.setVisibility(8);
      this.vVk = true;
    }
  }
  
  public final boolean apu()
  {
    int j = 0;
    int i = au.Dk().KG();
    Object localObject = au.Dk().getNetworkServerIp();
    this.vVj = String.format("http://w.mail.qq.com/cgi-bin/report_mm?failuretype=1&devicetype=2&clientversion=%s&os=%s&username=%s&iport=%s&t=weixin_bulletin&f=xhtml&lang=%s", new Object[] { "0x" + Integer.toHexString(com.tencent.mm.protocal.d.spa), com.tencent.mm.protocal.d.dOM, q.Gj(), localObject, x.cqJ() });
    initialize();
    y.i("MicroMsg.NetWarnView", "update st:%d", new Object[] { Integer.valueOf(i) });
    boolean bool1;
    boolean bool2;
    switch (i)
    {
    case 1: 
    case 4: 
    default: 
      bool1 = false;
      if (bool1)
      {
        this.foy.setVisibility(8);
        this.eXO.setVisibility(0);
        this.hNa.setBackgroundResource(R.g.tips_bar_red_selector);
        localObject = new LinearLayout.LayoutParams(this.gSx.getLayoutParams());
        ((LinearLayout.LayoutParams)localObject).setMargins(com.tencent.mm.cb.a.fromDPToPix((Context)this.sdy.get(), 10), 0, com.tencent.mm.cb.a.fromDPToPix((Context)this.sdy.get(), 4), 0);
        this.gSx.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.gSx.setImageResource(R.k.tipsbar_icon_warning);
        this.vVg.setVisibility(8);
        this.vVh.setVisibility(8);
        this.vVe.setVisibility(8);
        bool2 = bool1;
        label274:
        bool1 = bool2;
        if (!bool2)
        {
          this.vVf.setVisibility(8);
          bool1 = bool2;
          if (ae.eSj)
          {
            i = aq.getBackgroundLimitType((Context)this.sdy.get());
            if ((!aq.isLimited(i)) || (this.vVs)) {
              break label1293;
            }
            this.eXO.setText(((Context)this.sdy.get()).getString(R.l.process_limited_warn_title));
            this.eXP.setText(((Context)this.sdy.get()).getString(R.l.process_limited_warn_message));
            this.eXP.setVisibility(0);
            this.vVd.setVisibility(8);
            this.vVi.setVisibility(8);
            this.gSx.setVisibility(0);
            this.vVf.setVisibility(0);
            this.hNa.setOnClickListener(new n.7(this, i));
            this.vVf.setOnClickListener(new n.8(this, i));
            bool1 = true;
          }
        }
        label450:
        this.vVh.setImageResource(R.k.chat_mute_notify_normal);
        this.vVf.setImageResource(R.g.bottle_close_frame_state);
        localObject = this.hNa;
        if (!bool1) {
          break label1308;
        }
      }
      break;
    }
    label1025:
    label1288:
    label1293:
    label1308:
    for (i = j;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      return bool1;
      this.eXO.setText(R.l.net_warn_no_network);
      this.eXP.setVisibility(8);
      this.vVd.setVisibility(8);
      this.vVi.setVisibility(8);
      this.gSx.setVisibility(0);
      this.hNa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("title", ((Context)n.this.sdy.get()).getString(R.l.net_warn_no_network));
          paramAnonymousView.putExtra("rawUrl", ((Context)n.this.sdy.get()).getString(R.l.net_warn_detail_doc));
          paramAnonymousView.putExtra("showShare", false);
          com.tencent.mm.br.d.b((Context)n.this.sdy.get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        }
      });
      bool1 = true;
      break;
      this.eXO.setText(R.l.net_warn_connecting);
      this.eXP.setVisibility(8);
      this.vVd.setVisibility(8);
      this.vVi.setVisibility(0);
      this.gSx.setVisibility(0);
      bool1 = true;
      break;
      if (this.pIS == 1) {
        this.eXO.setText(((Context)this.sdy.get()).getResources().getString(R.l.net_warn_diagnose_doing, new Object[] { Integer.valueOf(this.vVl) }));
      }
      for (;;)
      {
        this.eXP.setVisibility(8);
        this.vVd.setVisibility(8);
        this.vVi.setVisibility(8);
        this.gSx.setVisibility(0);
        this.hNa.setOnClickListener(new n.4(this));
        bool1 = true;
        break;
        this.eXO.setText(R.l.net_warn_diagnose_begin);
      }
      this.eXO.setText(R.l.net_warn_server_down);
      this.eXP.setText(((Context)this.sdy.get()).getString(R.l.net_warn_server_down_tip));
      this.eXP.setVisibility(0);
      this.vVd.setVisibility(8);
      this.vVi.setVisibility(8);
      this.gSx.setVisibility(0);
      this.hNa.setOnClickListener(new n.5(this));
      bool1 = true;
      break;
      au.Hx();
      if (com.tencent.mm.model.c.Fs())
      {
        au.Hx();
        if (l.jb(com.tencent.mm.model.c.Ft()))
        {
          localObject = au.Dk();
          au.Hx();
          ((p)localObject).a(new l(com.tencent.mm.model.c.Ft()), 0);
          bool2 = bool1;
          break label274;
        }
      }
      au.Hx();
      bool2 = bool1;
      if (!com.tencent.mm.model.c.Fs()) {
        break label274;
      }
      bool2 = bool1;
      if (ah.bl(l.ezp)) {
        break label274;
      }
      bool2 = bool1;
      if (l.Qs()) {
        break label274;
      }
      this.hNa.setBackgroundResource(R.g.tips_bar_white_selector);
      localObject = new LinearLayout.LayoutParams(this.gSx.getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).setMargins(com.tencent.mm.cb.a.fromDPToPix((Context)this.sdy.get(), 22), 0, com.tencent.mm.cb.a.fromDPToPix((Context)this.sdy.get(), 20), 0);
      this.gSx.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.eXO.setVisibility(8);
      this.eXP.setVisibility(8);
      this.foy.setVisibility(0);
      if (q.hH(q.Gp())) {
        if ((!l.Qv()) && (l.Qt()))
        {
          this.foy.setText(l.ezw);
          this.vVd.setVisibility(8);
          this.vVi.setVisibility(8);
          this.gSx.setPadding(0, 0, 0, 0);
          if (l.Qr() != 1) {
            break label1216;
          }
          this.gSx.setImageResource(R.k.connectkeyboad_banner_icon_pc);
          label1071:
          this.gSx.setVisibility(0);
          this.vVg.setVisibility(8);
          this.vVh.setVisibility(8);
          localObject = this.vVe;
          if (!q.hH(q.Gp())) {
            break label1288;
          }
        }
      }
      for (i = 8;; i = 0)
      {
        ((TextView)localObject).setVisibility(i);
        localObject = new Intent();
        ((Intent)localObject).putExtra("intent.key.online_version", l.Qu());
        this.hNa.setOnClickListener(new n.6(this, (Intent)localObject));
        bool2 = true;
        break;
        this.foy.setText(l.ezp);
        break label1025;
        if ((!l.Qv()) && (l.Qt()))
        {
          this.foy.setText(l.ezx);
          break label1025;
        }
        this.foy.setText(l.ezs);
        break label1025;
        label1216:
        if (l.Qr() == 2)
        {
          if (l.Qt())
          {
            this.gSx.setImageResource(R.k.connectkeyboad_banner_icon_maclock);
            break label1071;
          }
          this.gSx.setImageResource(R.k.connectkeyboad_banner_icon_mac);
          break label1071;
        }
        if (l.Qr() == 3)
        {
          this.gSx.setImageResource(R.k.connectkeyboad_banner_icon_ipad);
          break label1071;
        }
        this.gSx.setImageResource(R.k.tipsbar_icon_default);
        break label1071;
      }
      this.vVf.setVisibility(8);
      bool1 = bool2;
      break label450;
    }
  }
  
  final void cIw()
  {
    if (this.vVq != null)
    {
      this.vVq.stopTimer();
      this.vVq = null;
    }
  }
  
  public final void destroy()
  {
    cIw();
    if (this.vVr != null) {
      com.tencent.mm.sdk.b.a.udP.d(this.vVr);
    }
  }
  
  public final int getLayoutId()
  {
    return R.i.net_warn_item;
  }
  
  public final int getOrder()
  {
    return 2;
  }
  
  public final void setVisibility(int paramInt)
  {
    if (this.hNa != null) {
      this.hNa.setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.n
 * JD-Core Version:    0.7.0.1
 */