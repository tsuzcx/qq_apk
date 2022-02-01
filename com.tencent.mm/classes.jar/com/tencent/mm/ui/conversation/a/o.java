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
import com.tencent.mm.g.a.ma;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.am;
import java.lang.ref.WeakReference;

public final class o
  extends b
{
  boolean HhA;
  boolean HhB;
  String HhC;
  av HhD;
  c<ma> HhE;
  boolean HhF;
  private TextView Hhq;
  private TextView Hhr;
  private ImageView Hhs;
  private ImageView Hht;
  private ImageView Hhu;
  private ProgressBar Hhv;
  String Hhw;
  private boolean Hhx;
  int Hhy;
  boolean Hhz;
  private ProgressDialog fpP;
  private TextView hJe;
  private boolean hls;
  TextView ica;
  private TextView itt;
  private ImageView kXS;
  View pf;
  int yTV;
  
  public o(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38844);
    this.fpP = null;
    this.hls = false;
    this.Hhx = false;
    this.yTV = 0;
    this.pf = null;
    this.HhF = false;
    initialize();
    AppMethodBeat.o(38844);
  }
  
  private void initialize()
  {
    AppMethodBeat.i(38845);
    if ((!this.Hhx) && (this.view != null))
    {
      this.pf = this.view.findViewById(2131302984);
      this.ica = ((TextView)this.view.findViewById(2131302979));
      this.hJe = ((TextView)this.view.findViewById(2131302980));
      this.itt = ((TextView)this.view.findViewById(2131302981));
      this.Hhq = ((TextView)this.view.findViewById(2131302978));
      this.Hhv = ((ProgressBar)this.view.findViewById(2131302983));
      this.kXS = ((ImageView)this.view.findViewById(2131302982));
      this.Hhs = ((ImageView)this.view.findViewById(2131298370));
      this.Hht = ((ImageView)this.view.findViewById(2131300228));
      this.Hhu = ((ImageView)this.view.findViewById(2131304824));
      this.Hhr = ((TextView)this.view.findViewById(2131299471));
      this.Hhs.setVisibility(8);
      this.Hhx = true;
    }
    AppMethodBeat.o(38845);
  }
  
  private static boolean k(Object paramObject, int paramInt)
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
  
  public final boolean boZ()
  {
    boolean bool3 = true;
    int i = 0;
    AppMethodBeat.i(38847);
    final int j = az.aeS().auR();
    Object localObject = az.aeS().getNetworkServerIp();
    this.Hhw = String.format("http://w.mail.qq.com/cgi-bin/report_mm?failuretype=1&devicetype=2&clientversion=%s&os=%s&username=%s&iport=%s&t=weixin_bulletin&f=xhtml&lang=%s", new Object[] { "0x" + Integer.toHexString(com.tencent.mm.protocal.d.CpK), com.tencent.mm.protocal.d.glX, u.aqG(), localObject, ac.eFu() });
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
      ((Context)this.BZM.get()).getResources().getColor(2131099676);
      if (bool1)
      {
        this.itt.setVisibility(8);
        this.ica.setVisibility(0);
        this.pf.setBackgroundResource(2131234376);
        localObject = new LinearLayout.LayoutParams(this.kXS.getLayoutParams());
        ((LinearLayout.LayoutParams)localObject).setMargins(com.tencent.mm.cd.a.fromDPToPix((Context)this.BZM.get(), 28), 0, com.tencent.mm.cd.a.fromDPToPix((Context)this.BZM.get(), 24), 0);
        this.kXS.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (k(this.kXS.getTag(), 2131690397))
        {
          this.kXS.setTag(Integer.valueOf(2131690397));
          this.kXS.setImageDrawable(am.i((Context)this.BZM.get(), 2131690397, ((Context)this.BZM.get()).getResources().getColor(2131099803)));
        }
        this.Hht.setVisibility(8);
        this.Hhu.setVisibility(8);
        this.Hhr.setVisibility(8);
      }
      bool2 = bool1;
      if (!bool1)
      {
        this.Hhs.setVisibility(8);
        bool2 = bool1;
        if (ab.hUW)
        {
          j = ay.getBackgroundLimitType((Context)this.BZM.get());
          if ((!ay.isLimited(j)) || (this.HhF)) {
            break;
          }
          this.ica.setText(((Context)this.BZM.get()).getString(2131762019));
          this.hJe.setText(((Context)this.BZM.get()).getString(2131762018));
          this.hJe.setVisibility(0);
          this.Hhq.setVisibility(8);
          this.Hhv.setVisibility(8);
          this.kXS.setVisibility(0);
          this.Hhs.setVisibility(0);
          this.pf.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(38840);
              try
              {
                ay.startSettingItent((Context)o.this.BZM.get(), j);
                AppMethodBeat.o(38840);
                return;
              }
              catch (Exception paramAnonymousView)
              {
                ad.printErrStackTrace("MicroMsg.NetWarnView", paramAnonymousView, "", new Object[0]);
                AppMethodBeat.o(38840);
              }
            }
          });
          this.Hhs.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(38843);
              MMAppMgr.a((Context)o.this.BZM.get(), j, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(38841);
                  try
                  {
                    o.this.pf.setVisibility(8);
                    o.this.HhF = true;
                    ay.startSettingItent((Context)o.this.BZM.get(), o.7.this.val$type);
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
                  o.this.pf.setVisibility(8);
                  o.this.HhF = true;
                  AppMethodBeat.o(38842);
                }
              });
              AppMethodBeat.o(38843);
            }
          });
          bool1 = bool3;
          label537:
          bool2 = bool1;
        }
      }
      if (k(this.Hhu.getTag(), 2131689878))
      {
        this.Hhu.setTag(Integer.valueOf(2131689878));
        this.Hhu.setImageResource(2131689878);
      }
      if (k(this.Hhs.getTag(), 2131689878))
      {
        this.Hhs.setTag(Integer.valueOf(2131689878));
        this.Hhs.setImageResource(2131231325);
      }
      localObject = this.pf;
      if (!bool2) {}
      break;
    }
    for (;;)
    {
      ((View)localObject).setVisibility(i);
      AppMethodBeat.o(38847);
      return bool2;
      this.ica.setText(2131761535);
      this.hJe.setVisibility(8);
      this.Hhq.setVisibility(8);
      this.Hhv.setVisibility(8);
      this.kXS.setVisibility(0);
      this.pf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38837);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("title", ((Context)o.this.BZM.get()).getString(2131761535));
          paramAnonymousView.putExtra("rawUrl", ((Context)o.this.BZM.get()).getString(2131761532));
          paramAnonymousView.putExtra("showShare", false);
          com.tencent.mm.bs.d.b((Context)o.this.BZM.get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          AppMethodBeat.o(38837);
        }
      });
      bool1 = true;
      break;
      this.ica.setText(2131761531);
      this.hJe.setVisibility(8);
      this.Hhq.setVisibility(8);
      this.Hhv.setVisibility(0);
      this.kXS.setVisibility(0);
      bool1 = true;
      break;
      if (this.yTV == 1) {
        this.ica.setText(((Context)this.BZM.get()).getResources().getString(2131761534, new Object[] { Integer.valueOf(this.Hhy) }));
      }
      for (;;)
      {
        this.hJe.setVisibility(8);
        this.Hhq.setVisibility(8);
        this.Hhv.setVisibility(8);
        this.kXS.setVisibility(0);
        this.pf.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(38838);
            o.a(o.this, o.this.yTV);
            o.this.yTV = 1;
            if (o.this.HhE == null)
            {
              paramAnonymousView = o.this;
              paramAnonymousView.HhE = new o.1(paramAnonymousView);
              com.tencent.mm.sdk.b.a.ESL.b(paramAnonymousView.HhE);
            }
            if (o.this.HhD == null)
            {
              paramAnonymousView = o.this;
              paramAnonymousView.HhD = new av(new o.2(paramAnonymousView), true);
              paramAnonymousView.HhD.av(1000L, 1000L);
            }
            AppMethodBeat.o(38838);
          }
        });
        bool1 = true;
        break;
        this.ica.setText(2131761533);
      }
      this.ica.setText(2131761536);
      this.hJe.setText(((Context)this.BZM.get()).getString(2131761537));
      this.hJe.setVisibility(0);
      this.Hhq.setVisibility(8);
      this.Hhv.setVisibility(8);
      this.kXS.setVisibility(0);
      this.pf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38839);
          if (!bt.bX((Context)o.this.BZM.get(), o.this.Hhw))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("title", ((Context)o.this.BZM.get()).getString(2131761538));
            paramAnonymousView.putExtra("rawUrl", ((Context)o.this.BZM.get()).getString(2131761532));
            paramAnonymousView.putExtra("showShare", false);
            com.tencent.mm.bs.d.b((Context)o.this.BZM.get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          }
          AppMethodBeat.o(38839);
        }
      });
      bool1 = true;
      break;
      this.Hhs.setVisibility(8);
      break label537;
      i = 8;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38849);
    fcS();
    if (this.HhE != null) {
      com.tencent.mm.sdk.b.a.ESL.d(this.HhE);
    }
    AppMethodBeat.o(38849);
  }
  
  final void fcS()
  {
    AppMethodBeat.i(38846);
    if (this.HhD != null)
    {
      this.HhD.stopTimer();
      this.HhD = null;
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
    if (this.pf != null) {
      this.pf.setVisibility(paramInt);
    }
    AppMethodBeat.o(38850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.o
 * JD-Core Version:    0.7.0.1
 */