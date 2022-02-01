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
import com.tencent.mm.g.a.mj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.am;
import java.lang.ref.WeakReference;

public final class o
  extends b
{
  int AhK;
  private TextView IHJ;
  private TextView IHK;
  private ImageView IHL;
  private ImageView IHM;
  private ImageView IHN;
  private ProgressBar IHO;
  String IHP;
  private boolean IHQ;
  int IHR;
  boolean IHS;
  boolean IHT;
  boolean IHU;
  String IHV;
  au IHW;
  c<mj> IHX;
  boolean IHY;
  private ProgressDialog fts;
  private boolean hLV;
  TextView iCg;
  private TextView iTy;
  private TextView ijE;
  private ImageView lzC;
  View qe;
  
  public o(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38844);
    this.fts = null;
    this.hLV = false;
    this.IHQ = false;
    this.AhK = 0;
    this.qe = null;
    this.IHY = false;
    initialize();
    AppMethodBeat.o(38844);
  }
  
  private void initialize()
  {
    AppMethodBeat.i(38845);
    if ((!this.IHQ) && (this.view != null))
    {
      this.qe = this.view.findViewById(2131302984);
      this.iCg = ((TextView)this.view.findViewById(2131302979));
      this.ijE = ((TextView)this.view.findViewById(2131302980));
      this.iTy = ((TextView)this.view.findViewById(2131302981));
      this.IHJ = ((TextView)this.view.findViewById(2131302978));
      this.IHO = ((ProgressBar)this.view.findViewById(2131302983));
      this.lzC = ((ImageView)this.view.findViewById(2131302982));
      this.IHL = ((ImageView)this.view.findViewById(2131298370));
      this.IHM = ((ImageView)this.view.findViewById(2131300228));
      this.IHN = ((ImageView)this.view.findViewById(2131304824));
      this.IHK = ((TextView)this.view.findViewById(2131299471));
      this.IHL.setVisibility(8);
      this.IHQ = true;
    }
    AppMethodBeat.o(38845);
  }
  
  private static boolean n(Object paramObject, int paramInt)
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
  
  public final boolean bvU()
  {
    boolean bool3 = true;
    int i = 0;
    AppMethodBeat.i(38847);
    final int j = az.agi().aBK();
    Object localObject = az.agi().getNetworkServerIp();
    this.IHP = String.format("http://w.mail.qq.com/cgi-bin/report_mm?failuretype=1&devicetype=2&clientversion=%s&os=%s&username=%s&iport=%s&t=weixin_bulletin&f=xhtml&lang=%s", new Object[] { "0x" + Integer.toHexString(com.tencent.mm.protocal.d.DIc), com.tencent.mm.protocal.d.gMK, u.axw(), localObject, com.tencent.mm.sdk.platformtools.ab.eUO() });
    initialize();
    ac.i("MicroMsg.NetWarnView", "update st:%d", new Object[] { Integer.valueOf(j) });
    boolean bool1;
    boolean bool2;
    switch (j)
    {
    case 1: 
    case 4: 
    default: 
      bool1 = false;
      ((Context)this.Dsc.get()).getResources().getColor(2131099676);
      if (bool1)
      {
        this.iTy.setVisibility(8);
        this.iCg.setVisibility(0);
        this.qe.setBackgroundResource(2131234376);
        localObject = new LinearLayout.LayoutParams(this.lzC.getLayoutParams());
        ((LinearLayout.LayoutParams)localObject).setMargins(com.tencent.mm.cc.a.fromDPToPix((Context)this.Dsc.get(), 28), 0, com.tencent.mm.cc.a.fromDPToPix((Context)this.Dsc.get(), 24), 0);
        this.lzC.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (n(this.lzC.getTag(), 2131690397))
        {
          this.lzC.setTag(Integer.valueOf(2131690397));
          this.lzC.setImageDrawable(am.k((Context)this.Dsc.get(), 2131690397, ((Context)this.Dsc.get()).getResources().getColor(2131099803)));
        }
        this.IHM.setVisibility(8);
        this.IHN.setVisibility(8);
        this.IHK.setVisibility(8);
      }
      bool2 = bool1;
      if (!bool1)
      {
        this.IHL.setVisibility(8);
        bool2 = bool1;
        if (com.tencent.mm.platformtools.ab.iva)
        {
          j = ax.getBackgroundLimitType((Context)this.Dsc.get());
          if ((!ax.isLimited(j)) || (this.IHY)) {
            break;
          }
          this.iCg.setText(((Context)this.Dsc.get()).getString(2131762019));
          this.ijE.setText(((Context)this.Dsc.get()).getString(2131762018));
          this.ijE.setVisibility(0);
          this.IHJ.setVisibility(8);
          this.IHO.setVisibility(8);
          this.lzC.setVisibility(0);
          this.IHL.setVisibility(0);
          this.qe.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(38840);
              try
              {
                ax.startSettingItent((Context)o.this.Dsc.get(), j);
                AppMethodBeat.o(38840);
                return;
              }
              catch (Exception paramAnonymousView)
              {
                ac.printErrStackTrace("MicroMsg.NetWarnView", paramAnonymousView, "", new Object[0]);
                AppMethodBeat.o(38840);
              }
            }
          });
          this.IHL.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(38843);
              MMAppMgr.a((Context)o.this.Dsc.get(), j, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(38841);
                  try
                  {
                    o.this.qe.setVisibility(8);
                    o.this.IHY = true;
                    ax.startSettingItent((Context)o.this.Dsc.get(), o.7.this.val$type);
                    AppMethodBeat.o(38841);
                    return;
                  }
                  catch (Exception paramAnonymous2DialogInterface)
                  {
                    ac.printErrStackTrace("MicroMsg.NetWarnView", paramAnonymous2DialogInterface, "", new Object[0]);
                    AppMethodBeat.o(38841);
                  }
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(38842);
                  o.this.qe.setVisibility(8);
                  o.this.IHY = true;
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
      if (n(this.IHN.getTag(), 2131689878))
      {
        this.IHN.setTag(Integer.valueOf(2131689878));
        this.IHN.setImageResource(2131689878);
      }
      if (n(this.IHL.getTag(), 2131689878))
      {
        this.IHL.setTag(Integer.valueOf(2131689878));
        this.IHL.setImageResource(2131231325);
      }
      localObject = this.qe;
      if (!bool2) {}
      break;
    }
    for (;;)
    {
      ((View)localObject).setVisibility(i);
      AppMethodBeat.o(38847);
      return bool2;
      this.iCg.setText(2131761535);
      this.ijE.setVisibility(8);
      this.IHJ.setVisibility(8);
      this.IHO.setVisibility(8);
      this.lzC.setVisibility(0);
      this.qe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38837);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("title", ((Context)o.this.Dsc.get()).getString(2131761535));
          paramAnonymousView.putExtra("rawUrl", ((Context)o.this.Dsc.get()).getString(2131761532));
          paramAnonymousView.putExtra("showShare", false);
          com.tencent.mm.br.d.b((Context)o.this.Dsc.get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          AppMethodBeat.o(38837);
        }
      });
      bool1 = true;
      break;
      this.iCg.setText(2131761531);
      this.ijE.setVisibility(8);
      this.IHJ.setVisibility(8);
      this.IHO.setVisibility(0);
      this.lzC.setVisibility(0);
      bool1 = true;
      break;
      if (this.AhK == 1) {
        this.iCg.setText(((Context)this.Dsc.get()).getResources().getString(2131761534, new Object[] { Integer.valueOf(this.IHR) }));
      }
      for (;;)
      {
        this.ijE.setVisibility(8);
        this.IHJ.setVisibility(8);
        this.IHO.setVisibility(8);
        this.lzC.setVisibility(0);
        this.qe.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(38838);
            o.a(o.this, o.this.AhK);
            o.this.AhK = 1;
            if (o.this.IHX == null)
            {
              paramAnonymousView = o.this;
              paramAnonymousView.IHX = new o.1(paramAnonymousView);
              com.tencent.mm.sdk.b.a.GpY.b(paramAnonymousView.IHX);
            }
            if (o.this.IHW == null)
            {
              paramAnonymousView = o.this;
              paramAnonymousView.IHW = new au(new o.2(paramAnonymousView), true);
              paramAnonymousView.IHW.au(1000L, 1000L);
            }
            AppMethodBeat.o(38838);
          }
        });
        bool1 = true;
        break;
        this.iCg.setText(2131761533);
      }
      this.iCg.setText(2131761536);
      this.ijE.setText(((Context)this.Dsc.get()).getString(2131761537));
      this.ijE.setVisibility(0);
      this.IHJ.setVisibility(8);
      this.IHO.setVisibility(8);
      this.lzC.setVisibility(0);
      this.qe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38839);
          if (!bs.bY((Context)o.this.Dsc.get(), o.this.IHP))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("title", ((Context)o.this.Dsc.get()).getString(2131761538));
            paramAnonymousView.putExtra("rawUrl", ((Context)o.this.Dsc.get()).getString(2131761532));
            paramAnonymousView.putExtra("showShare", false);
            com.tencent.mm.br.d.b((Context)o.this.Dsc.get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          }
          AppMethodBeat.o(38839);
        }
      });
      bool1 = true;
      break;
      this.IHL.setVisibility(8);
      break label537;
      i = 8;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38849);
    fsN();
    if (this.IHX != null) {
      com.tencent.mm.sdk.b.a.GpY.d(this.IHX);
    }
    AppMethodBeat.o(38849);
  }
  
  final void fsN()
  {
    AppMethodBeat.i(38846);
    if (this.IHW != null)
    {
      this.IHW.stopTimer();
      this.IHW = null;
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
    if (this.qe != null) {
      this.qe.setVisibility(paramInt);
    }
    AppMethodBeat.o(38850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.o
 * JD-Core Version:    0.7.0.1
 */