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
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.pluginsdk.ui.tools.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.y;

public final class w
{
  public int IWA;
  public String Npt;
  String Npu;
  String Npv;
  public ChatFooterCustom aeiT;
  public FrameLayout aeiU;
  public FrameLayout aeiV;
  public TextView aeiW;
  public ImageView aeiX;
  a aeiY;
  public boolean aeiZ;
  String aeja;
  public String aejb;
  public View.OnClickListener aejc;
  public View.OnClickListener aejd;
  private p.a aeje;
  Context mContext;
  private SharedPreferences sp;
  public LinearLayout xYI;
  long yuP;
  
  public w(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(34622);
    this.xYI = null;
    this.aeiY = a.aeji;
    this.IWA = -1;
    this.aeja = null;
    this.yuP = -1L;
    this.aejc = new w.1(this);
    this.aejd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34610);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        switch (w.8.aejh[w.this.aeiY.ordinal()])
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34610);
          return;
          h.OAn.b(11288, new Object[] { Integer.valueOf(6) });
          paramAnonymousView = w.this;
          if (!NetStatusUtil.isConnected(paramAnonymousView.mContext))
          {
            k.a(paramAnonymousView.mContext, com.tencent.mm.cd.a.bt(paramAnonymousView.mContext, R.l.gwH), "", com.tencent.mm.cd.a.bt(paramAnonymousView.mContext, R.l.gwC), null);
          }
          else if (!NetStatusUtil.isWifi(paramAnonymousView.mContext))
          {
            k.a(paramAnonymousView.mContext, R.l.gwE, 0, R.l.gwA, R.l.gwz, new w.3(paramAnonymousView), null);
          }
          else
          {
            k.a(paramAnonymousView.mContext, R.l.gwF, 0, R.l.gwA, R.l.gwz, new w.4(paramAnonymousView), null);
            continue;
            paramAnonymousView = w.this;
            Log.i("MicroMsg.ChattingQQMailFooterHandler", "dz[cancelDownload]");
            f.duv().kR(paramAnonymousView.yuP);
            paramAnonymousView.jpE();
            continue;
            h.OAn.b(11288, new Object[] { Integer.valueOf(7) });
            paramAnonymousView = w.this;
            Log.i("MicroMsg.ChattingQQMailFooterHandler", "dz[installQQMail]");
            com.tencent.mm.pluginsdk.platformtools.g.bn(paramAnonymousView.mContext, paramAnonymousView.aeja);
            continue;
            h.OAn.b(11288, new Object[] { Integer.valueOf(5) });
            w localw = w.this;
            Log.i("MicroMsg.ChattingQQMailFooterHandler", "dz[openQQMail]");
            Log.i("MicroMsg.ChattingQQMailFooterHandler", "mQQMailScheme = %s", new Object[] { localw.aejb });
            if (Util.isNullOrNil(localw.aejb)) {
              paramAnonymousView = localw.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
            }
            for (;;)
            {
              Log.i("MicroMsg.ChattingQQMailFooterHandler", "intent = %s", new Object[] { paramAnonymousView });
              com.tencent.mm.ci.a.post(new w.5(localw, paramAnonymousView));
              break;
              localObject = new Intent();
              ((Intent)localObject).setData(Uri.parse(localw.aejb));
              ((Intent)localObject).addFlags(268435456);
              if (Build.VERSION.SDK_INT >= 11) {
                ((Intent)localObject).addFlags(32768);
              }
              paramAnonymousView = (View)localObject;
              if (!Util.isIntentAvailable(localw.mContext, (Intent)localObject)) {
                paramAnonymousView = localw.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
              }
            }
            if (w.this.aeiZ) {
              w.a(w.this);
            }
          }
        }
      }
    };
    this.aeje = new p.a()
    {
      public final void gEh()
      {
        AppMethodBeat.i(34617);
        w.this.aeiW.setText(R.l.chatfooter_mail_without_unread_count);
        AppMethodBeat.o(34617);
      }
      
      public final void onSuccess(int paramAnonymousInt)
      {
        AppMethodBeat.i(34616);
        w.this.IWA = paramAnonymousInt;
        w.this.jpF();
        AppMethodBeat.o(34616);
      }
    };
    this.mContext = paramChatFooterCustom.getContext();
    this.aeiT = paramChatFooterCustom;
    AppMethodBeat.o(34622);
  }
  
  public final void jpD()
  {
    AppMethodBeat.i(34623);
    if (this.aeiY == a.aejm)
    {
      this.aeiX.setImageResource(R.k.promo_icon_qqmail);
      AppMethodBeat.o(34623);
      return;
    }
    this.aeiX.setImageResource(R.k.promo_icon_qqmail_uninstall);
    AppMethodBeat.o(34623);
  }
  
  public final void jpE()
  {
    AppMethodBeat.i(34624);
    Object localObject;
    if (u.y(this.mContext, "com.tencent.androidqqmail")) {
      localObject = a.aejm;
    }
    for (;;)
    {
      this.aeiY = ((a)localObject);
      jpD();
      Log.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initRightBtnTv: status:%s]", new Object[] { this.aeiY.toString() });
      switch (8.aejh[this.aeiY.ordinal()])
      {
      default: 
        p.a(this.aeje);
        AppMethodBeat.o(34624);
        return;
        this.sp = this.mContext.getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.g.aQe());
        this.yuP = this.sp.getLong("qqmail_downloadid", -1L);
        if (this.yuP < 0L)
        {
          if (Util.isNullOrNil(this.Npt)) {
            localObject = a.aejn;
          } else {
            localObject = a.aejj;
          }
        }
        else
        {
          localObject = f.duv().kS(this.yuP);
          int i = ((FileDownloadTaskInfo)localObject).status;
          this.aeja = ((FileDownloadTaskInfo)localObject).path;
          switch (i)
          {
          case 2: 
          default: 
            if (Util.isNullOrNil(this.Npt)) {
              localObject = a.aejn;
            }
            break;
          case 3: 
            if (y.ZC(this.aeja)) {
              localObject = a.aejl;
            } else if (Util.isNullOrNil(this.Npt)) {
              localObject = a.aejn;
            } else {
              localObject = a.aejj;
            }
            break;
          case 1: 
            localObject = a.aejk;
            continue;
            localObject = a.aejj;
          }
        }
        break;
      }
    }
    this.aeiW.setText(R.l.gwD);
    AppMethodBeat.o(34624);
    return;
    this.aeiW.setText(R.l.gwB);
    AppMethodBeat.o(34624);
    return;
    p.a(this.aeje);
    AppMethodBeat.o(34624);
  }
  
  public final void jpF()
  {
    AppMethodBeat.i(34625);
    if (this.IWA == 0)
    {
      this.aeiW.setText(R.l.chatfooter_mail_without_unread_count);
      AppMethodBeat.o(34625);
      return;
    }
    if (this.IWA > 99)
    {
      this.aeiW.setText(R.l.gwJ);
      AppMethodBeat.o(34625);
      return;
    }
    this.aeiW.setText(String.format(com.tencent.mm.cd.a.bt(this.mContext, R.l.gwI), new Object[] { Integer.valueOf(this.IWA) }));
    AppMethodBeat.o(34625);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(34621);
      aeji = new a("DEFAULT", 0);
      aejj = new a("NEED_DOWNLOAD", 1);
      aejk = new a("DOWNLOADING", 2);
      aejl = new a("NEED_INSTALL", 3);
      aejm = new a("INSTALLED", 4);
      aejn = new a("NO_URL", 5);
      aejo = new a[] { aeji, aejj, aejk, aejl, aejm, aejn };
      AppMethodBeat.o(34621);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.w
 * JD-Core Version:    0.7.0.1
 */