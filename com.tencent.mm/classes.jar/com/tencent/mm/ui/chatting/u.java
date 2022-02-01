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
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.pluginsdk.ui.tools.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class u
{
  public int Dcg;
  public String HrG;
  String HrH;
  String HrI;
  public FrameLayout WBA;
  public FrameLayout WBB;
  public TextView WBC;
  public ImageView WBD;
  a WBE;
  public boolean WBF;
  String WBG;
  public String WBH;
  public View.OnClickListener WBI;
  public View.OnClickListener WBJ;
  private q.a WBK;
  public ChatFooterCustom WBz;
  Context mContext;
  private SharedPreferences sp;
  public LinearLayout uPX;
  long viQ;
  
  public u(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(34622);
    this.uPX = null;
    this.WBE = a.WBO;
    this.Dcg = -1;
    this.WBG = null;
    this.viQ = -1L;
    this.WBI = new u.1(this);
    this.WBJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34610);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        switch (u.8.WBN[u.this.WBE.ordinal()])
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34610);
          return;
          com.tencent.mm.plugin.report.service.h.IzE.a(11288, new Object[] { Integer.valueOf(6) });
          paramAnonymousView = u.this;
          if (!NetStatusUtil.isConnected(paramAnonymousView.mContext))
          {
            com.tencent.mm.ui.base.h.a(paramAnonymousView.mContext, com.tencent.mm.ci.a.ba(paramAnonymousView.mContext, R.l.euj), "", com.tencent.mm.ci.a.ba(paramAnonymousView.mContext, R.l.eue), null);
          }
          else if (!NetStatusUtil.isWifi(paramAnonymousView.mContext))
          {
            com.tencent.mm.ui.base.h.a(paramAnonymousView.mContext, R.l.eug, 0, R.l.euc, R.l.eub, new u.3(paramAnonymousView), null);
          }
          else
          {
            com.tencent.mm.ui.base.h.a(paramAnonymousView.mContext, R.l.euh, 0, R.l.euc, R.l.eub, new u.4(paramAnonymousView), null);
            continue;
            paramAnonymousView = u.this;
            Log.i("MicroMsg.ChattingQQMailFooterHandler", "dz[cancelDownload]");
            f.cPZ().Iw(paramAnonymousView.viQ);
            paramAnonymousView.hNb();
            continue;
            com.tencent.mm.plugin.report.service.h.IzE.a(11288, new Object[] { Integer.valueOf(7) });
            paramAnonymousView = u.this;
            Log.i("MicroMsg.ChattingQQMailFooterHandler", "dz[installQQMail]");
            com.tencent.mm.pluginsdk.j.g.bl(paramAnonymousView.mContext, paramAnonymousView.WBG);
            continue;
            com.tencent.mm.plugin.report.service.h.IzE.a(11288, new Object[] { Integer.valueOf(5) });
            u localu = u.this;
            Log.i("MicroMsg.ChattingQQMailFooterHandler", "dz[openQQMail]");
            Log.i("MicroMsg.ChattingQQMailFooterHandler", "mQQMailScheme = %s", new Object[] { localu.WBH });
            if (Util.isNullOrNil(localu.WBH)) {
              paramAnonymousView = localu.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
            }
            for (;;)
            {
              Log.i("MicroMsg.ChattingQQMailFooterHandler", "intent = %s", new Object[] { paramAnonymousView });
              com.tencent.mm.co.a.post(new u.5(localu, paramAnonymousView));
              break;
              localObject = new Intent();
              ((Intent)localObject).setData(Uri.parse(localu.WBH));
              ((Intent)localObject).addFlags(268435456);
              if (Build.VERSION.SDK_INT >= 11) {
                ((Intent)localObject).addFlags(32768);
              }
              paramAnonymousView = (View)localObject;
              if (!Util.isIntentAvailable(localu.mContext, (Intent)localObject)) {
                paramAnonymousView = localu.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
              }
            }
            if (u.this.WBF) {
              u.a(u.this);
            }
          }
        }
      }
    };
    this.WBK = new q.a()
    {
      public final void XN()
      {
        AppMethodBeat.i(34617);
        u.this.WBC.setText(R.l.chatfooter_mail_without_unread_count);
        AppMethodBeat.o(34617);
      }
      
      public final void onSuccess(int paramAnonymousInt)
      {
        AppMethodBeat.i(34616);
        u.this.Dcg = paramAnonymousInt;
        u.this.hNc();
        AppMethodBeat.o(34616);
      }
    };
    this.mContext = paramChatFooterCustom.getContext();
    this.WBz = paramChatFooterCustom;
    AppMethodBeat.o(34622);
  }
  
  public final void hNa()
  {
    AppMethodBeat.i(34623);
    if (this.WBE == a.WBS)
    {
      this.WBD.setImageResource(R.k.promo_icon_qqmail);
      AppMethodBeat.o(34623);
      return;
    }
    this.WBD.setImageResource(R.k.promo_icon_qqmail_uninstall);
    AppMethodBeat.o(34623);
  }
  
  public final void hNb()
  {
    AppMethodBeat.i(34624);
    Object localObject;
    if (com.tencent.mm.pluginsdk.model.app.q.u(this.mContext, "com.tencent.androidqqmail")) {
      localObject = a.WBS;
    }
    for (;;)
    {
      this.WBE = ((a)localObject);
      hNa();
      Log.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initRightBtnTv: status:%s]", new Object[] { this.WBE.toString() });
      switch (8.WBN[this.WBE.ordinal()])
      {
      default: 
        com.tencent.mm.pluginsdk.ui.tools.q.a(this.WBK);
        AppMethodBeat.o(34624);
        return;
        this.sp = this.mContext.getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.g.avK());
        this.viQ = this.sp.getLong("qqmail_downloadid", -1L);
        if (this.viQ < 0L)
        {
          if (Util.isNullOrNil(this.HrG)) {
            localObject = a.WBT;
          } else {
            localObject = a.WBP;
          }
        }
        else
        {
          localObject = f.cPZ().Ix(this.viQ);
          int i = ((FileDownloadTaskInfo)localObject).status;
          this.WBG = ((FileDownloadTaskInfo)localObject).path;
          switch (i)
          {
          case 2: 
          default: 
            if (Util.isNullOrNil(this.HrG)) {
              localObject = a.WBT;
            }
            break;
          case 3: 
            if (com.tencent.mm.vfs.u.agG(this.WBG)) {
              localObject = a.WBR;
            } else if (Util.isNullOrNil(this.HrG)) {
              localObject = a.WBT;
            } else {
              localObject = a.WBP;
            }
            break;
          case 1: 
            localObject = a.WBQ;
            continue;
            localObject = a.WBP;
          }
        }
        break;
      }
    }
    this.WBC.setText(R.l.euf);
    AppMethodBeat.o(34624);
    return;
    this.WBC.setText(R.l.eud);
    AppMethodBeat.o(34624);
    return;
    com.tencent.mm.pluginsdk.ui.tools.q.a(this.WBK);
    AppMethodBeat.o(34624);
  }
  
  public final void hNc()
  {
    AppMethodBeat.i(34625);
    if (this.Dcg == 0)
    {
      this.WBC.setText(R.l.chatfooter_mail_without_unread_count);
      AppMethodBeat.o(34625);
      return;
    }
    if (this.Dcg > 99)
    {
      this.WBC.setText(R.l.eul);
      AppMethodBeat.o(34625);
      return;
    }
    this.WBC.setText(String.format(com.tencent.mm.ci.a.ba(this.mContext, R.l.euk), new Object[] { Integer.valueOf(this.Dcg) }));
    AppMethodBeat.o(34625);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(34621);
      WBO = new a("DEFAULT", 0);
      WBP = new a("NEED_DOWNLOAD", 1);
      WBQ = new a("DOWNLOADING", 2);
      WBR = new a("NEED_INSTALL", 3);
      WBS = new a("INSTALLED", 4);
      WBT = new a("NO_URL", 5);
      WBU = new a[] { WBO, WBP, WBQ, WBR, WBS, WBT };
      AppMethodBeat.o(34621);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.u
 * JD-Core Version:    0.7.0.1
 */