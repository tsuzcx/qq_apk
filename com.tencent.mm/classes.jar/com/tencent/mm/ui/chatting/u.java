package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.pluginsdk.ui.tools.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class u
{
  public String Bxl;
  String Bxm;
  String Bxn;
  public ChatFooterCustom PhX;
  public FrameLayout PhY;
  public FrameLayout PhZ;
  public TextView Pia;
  public ImageView Pib;
  a Pic;
  public boolean Pid;
  String Pie;
  public String Pif;
  public View.OnClickListener Pig;
  public View.OnClickListener Pih;
  private o.a Pii;
  Context mContext;
  long rDg;
  public LinearLayout rmL;
  private SharedPreferences sp;
  public int xXB;
  
  public u(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(34622);
    this.rmL = null;
    this.Pic = a.Pim;
    this.xXB = -1;
    this.Pie = null;
    this.rDg = -1L;
    this.Pig = new u.1(this);
    this.Pih = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34610);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        switch (u.8.Pil[u.this.Pic.ordinal()])
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34610);
          return;
          com.tencent.mm.plugin.report.service.h.CyF.a(11288, new Object[] { Integer.valueOf(6) });
          paramAnonymousView = u.this;
          if (!NetStatusUtil.isConnected(paramAnonymousView.mContext))
          {
            com.tencent.mm.ui.base.h.a(paramAnonymousView.mContext, com.tencent.mm.cb.a.aI(paramAnonymousView.mContext, 2131757290), "", com.tencent.mm.cb.a.aI(paramAnonymousView.mContext, 2131757285), null);
          }
          else if (!NetStatusUtil.isWifi(paramAnonymousView.mContext))
          {
            com.tencent.mm.ui.base.h.a(paramAnonymousView.mContext, 2131757287, 0, 2131757283, 2131757282, new u.3(paramAnonymousView), null);
          }
          else
          {
            com.tencent.mm.ui.base.h.a(paramAnonymousView.mContext, 2131757288, 0, 2131757283, 2131757282, new u.4(paramAnonymousView), null);
            continue;
            paramAnonymousView = u.this;
            Log.i("MicroMsg.ChattingQQMailFooterHandler", "dz[cancelDownload]");
            f.cBv().Cn(paramAnonymousView.rDg);
            paramAnonymousView.gNS();
            continue;
            com.tencent.mm.plugin.report.service.h.CyF.a(11288, new Object[] { Integer.valueOf(7) });
            paramAnonymousView = u.this;
            Log.i("MicroMsg.ChattingQQMailFooterHandler", "dz[installQQMail]");
            com.tencent.mm.pluginsdk.i.g.aZ(paramAnonymousView.mContext, paramAnonymousView.Pie);
            continue;
            com.tencent.mm.plugin.report.service.h.CyF.a(11288, new Object[] { Integer.valueOf(5) });
            u localu = u.this;
            Log.i("MicroMsg.ChattingQQMailFooterHandler", "dz[openQQMail]");
            Log.i("MicroMsg.ChattingQQMailFooterHandler", "mQQMailScheme = %s", new Object[] { localu.Pif });
            if (Util.isNullOrNil(localu.Pif)) {
              paramAnonymousView = localu.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
            }
            for (;;)
            {
              Log.i("MicroMsg.ChattingQQMailFooterHandler", "intent = %s", new Object[] { paramAnonymousView });
              com.tencent.mm.ch.a.post(new u.5(localu, paramAnonymousView));
              break;
              localObject = new Intent();
              ((Intent)localObject).setData(Uri.parse(localu.Pif));
              ((Intent)localObject).addFlags(268435456);
              if (Build.VERSION.SDK_INT >= 11) {
                ((Intent)localObject).addFlags(32768);
              }
              paramAnonymousView = (View)localObject;
              if (!Util.isIntentAvailable(localu.mContext, (Intent)localObject)) {
                paramAnonymousView = localu.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
              }
            }
            if (u.this.Pid) {
              u.a(u.this);
            }
          }
        }
      }
    };
    this.Pii = new o.a()
    {
      public final void eGv()
      {
        AppMethodBeat.i(34617);
        u.this.Pia.setText(2131757293);
        AppMethodBeat.o(34617);
      }
      
      public final void onSuccess(int paramAnonymousInt)
      {
        AppMethodBeat.i(34616);
        u.this.xXB = paramAnonymousInt;
        u.this.gNT();
        AppMethodBeat.o(34616);
      }
    };
    this.mContext = paramChatFooterCustom.getContext();
    this.PhX = paramChatFooterCustom;
    AppMethodBeat.o(34622);
  }
  
  public final void gNR()
  {
    AppMethodBeat.i(34623);
    if (this.Pic == a.Piq)
    {
      this.Pib.setImageResource(2131691356);
      AppMethodBeat.o(34623);
      return;
    }
    this.Pib.setImageResource(2131691357);
    AppMethodBeat.o(34623);
  }
  
  public final void gNS()
  {
    AppMethodBeat.i(34624);
    Object localObject;
    if (q.s(this.mContext, "com.tencent.androidqqmail")) {
      localObject = a.Piq;
    }
    for (;;)
    {
      this.Pic = ((a)localObject);
      gNR();
      Log.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initRightBtnTv: status:%s]", new Object[] { this.Pic.toString() });
      switch (8.Pil[this.Pic.ordinal()])
      {
      default: 
        o.a(this.Pii);
        AppMethodBeat.o(34624);
        return;
        this.sp = this.mContext.getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.g.aps());
        this.rDg = this.sp.getLong("qqmail_downloadid", -1L);
        if (this.rDg < 0L)
        {
          if (Util.isNullOrNil(this.Bxl)) {
            localObject = a.Pir;
          } else {
            localObject = a.Pin;
          }
        }
        else
        {
          localObject = f.cBv().Co(this.rDg);
          int i = ((FileDownloadTaskInfo)localObject).status;
          this.Pie = ((FileDownloadTaskInfo)localObject).path;
          switch (i)
          {
          case 2: 
          default: 
            if (Util.isNullOrNil(this.Bxl)) {
              localObject = a.Pir;
            }
            break;
          case 3: 
            if (s.YS(this.Pie)) {
              localObject = a.Pip;
            } else if (Util.isNullOrNil(this.Bxl)) {
              localObject = a.Pir;
            } else {
              localObject = a.Pin;
            }
            break;
          case 1: 
            localObject = a.Pio;
            continue;
            localObject = a.Pin;
          }
        }
        break;
      }
    }
    this.Pia.setText(2131757286);
    AppMethodBeat.o(34624);
    return;
    this.Pia.setText(2131757284);
    AppMethodBeat.o(34624);
    return;
    o.a(this.Pii);
    AppMethodBeat.o(34624);
  }
  
  public final void gNT()
  {
    AppMethodBeat.i(34625);
    if (this.xXB == 0)
    {
      this.Pia.setText(2131757293);
      AppMethodBeat.o(34625);
      return;
    }
    if (this.xXB > 99)
    {
      this.Pia.setText(2131757292);
      AppMethodBeat.o(34625);
      return;
    }
    this.Pia.setText(String.format(com.tencent.mm.cb.a.aI(this.mContext, 2131757291), new Object[] { Integer.valueOf(this.xXB) }));
    AppMethodBeat.o(34625);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(34621);
      Pim = new a("DEFAULT", 0);
      Pin = new a("NEED_DOWNLOAD", 1);
      Pio = new a("DOWNLOADING", 2);
      Pip = new a("NEED_INSTALL", 3);
      Piq = new a("INSTALLED", 4);
      Pir = new a("NO_URL", 5);
      Pis = new a[] { Pim, Pin, Pio, Pip, Piq, Pir };
      AppMethodBeat.o(34621);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.u
 * JD-Core Version:    0.7.0.1
 */