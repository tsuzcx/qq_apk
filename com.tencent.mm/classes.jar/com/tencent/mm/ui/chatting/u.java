package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Resources;
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
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.pluginsdk.i.j;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.pluginsdk.ui.tools.m.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;

public final class u
{
  public ChatFooterCustom JWJ;
  public FrameLayout JWK;
  public FrameLayout JWL;
  public TextView JWM;
  public ImageView JWN;
  a JWO;
  public boolean JWP;
  String JWQ;
  public String JWR;
  public View.OnClickListener JWS;
  public View.OnClickListener JWT;
  private m.a JWU;
  Context mContext;
  public LinearLayout pVM;
  long qmk;
  SharedPreferences sp;
  public int uFA;
  public String xxj;
  String xxk;
  String xxl;
  
  public u(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(34622);
    this.pVM = null;
    this.JWO = a.JWY;
    this.uFA = -1;
    this.JWQ = null;
    this.qmk = -1L;
    this.JWS = new u.1(this);
    this.JWT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34610);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        switch (u.8.JWX[u.this.JWO.ordinal()])
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34610);
          return;
          com.tencent.mm.plugin.report.service.g.yxI.f(11288, new Object[] { Integer.valueOf(6) });
          paramAnonymousView = u.this;
          if (!az.isConnected(paramAnonymousView.mContext))
          {
            h.a(paramAnonymousView.mContext, com.tencent.mm.cb.a.az(paramAnonymousView.mContext, 2131757089), "", com.tencent.mm.cb.a.az(paramAnonymousView.mContext, 2131757084), null);
          }
          else if (!az.isWifi(paramAnonymousView.mContext))
          {
            h.a(paramAnonymousView.mContext, 2131757086, 0, 2131757082, 2131757081, new u.3(paramAnonymousView), null);
          }
          else
          {
            h.a(paramAnonymousView.mContext, 2131757087, 0, 2131757082, 2131757081, new u.4(paramAnonymousView), null);
            continue;
            paramAnonymousView = u.this;
            ae.i("MicroMsg.ChattingQQMailFooterHandler", "dz[cancelDownload]");
            f.cdA().ui(paramAnonymousView.qmk);
            paramAnonymousView.fFN();
            continue;
            com.tencent.mm.plugin.report.service.g.yxI.f(11288, new Object[] { Integer.valueOf(7) });
            paramAnonymousView = u.this;
            ae.i("MicroMsg.ChattingQQMailFooterHandler", "dz[installQQMail]");
            j.aM(paramAnonymousView.mContext, paramAnonymousView.JWQ);
            continue;
            com.tencent.mm.plugin.report.service.g.yxI.f(11288, new Object[] { Integer.valueOf(5) });
            u localu = u.this;
            ae.i("MicroMsg.ChattingQQMailFooterHandler", "dz[openQQMail]");
            ae.i("MicroMsg.ChattingQQMailFooterHandler", "mQQMailScheme = %s", new Object[] { localu.JWR });
            if (bu.isNullOrNil(localu.JWR)) {
              paramAnonymousView = localu.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
            }
            for (;;)
            {
              ae.i("MicroMsg.ChattingQQMailFooterHandler", "intent = %s", new Object[] { paramAnonymousView });
              com.tencent.mm.ch.a.post(new u.5(localu, paramAnonymousView));
              break;
              localObject = new Intent();
              ((Intent)localObject).setData(Uri.parse(localu.JWR));
              ((Intent)localObject).addFlags(268435456);
              if (Build.VERSION.SDK_INT >= 11) {
                ((Intent)localObject).addFlags(32768);
              }
              paramAnonymousView = (View)localObject;
              if (!bu.aj(localu.mContext, (Intent)localObject)) {
                paramAnonymousView = localu.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
              }
            }
            if (u.this.JWP) {
              u.a(u.this);
            }
          }
        }
      }
    };
    this.JWU = new m.a()
    {
      public final void dFG()
      {
        AppMethodBeat.i(34617);
        u.this.JWM.setText(2131757092);
        AppMethodBeat.o(34617);
      }
      
      public final void onSuccess(int paramAnonymousInt)
      {
        AppMethodBeat.i(34616);
        u.this.uFA = paramAnonymousInt;
        u.this.fFO();
        AppMethodBeat.o(34616);
      }
    };
    this.mContext = paramChatFooterCustom.getContext();
    this.JWJ = paramChatFooterCustom;
    AppMethodBeat.o(34622);
  }
  
  public final void fFM()
  {
    AppMethodBeat.i(34623);
    if (this.JWO == a.JXc)
    {
      this.JWN.setImageResource(2131691054);
      AppMethodBeat.o(34623);
      return;
    }
    this.JWN.setImageResource(2131691055);
    AppMethodBeat.o(34623);
  }
  
  public final void fFN()
  {
    AppMethodBeat.i(34624);
    Object localObject;
    if (q.s(this.mContext, "com.tencent.androidqqmail")) {
      localObject = a.JXc;
    }
    for (;;)
    {
      this.JWO = ((a)localObject);
      fFM();
      ae.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initRightBtnTv: status:%s]", new Object[] { this.JWO.toString() });
      switch (8.JWX[this.JWO.ordinal()])
      {
      default: 
        m.a(this.JWU);
        AppMethodBeat.o(34624);
        return;
        this.sp = this.mContext.getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.g.abv());
        this.qmk = this.sp.getLong("qqmail_downloadid", -1L);
        if (this.qmk < 0L)
        {
          if (bu.isNullOrNil(this.xxj)) {
            localObject = a.JXd;
          } else {
            localObject = a.JWZ;
          }
        }
        else
        {
          localObject = f.cdA().uj(this.qmk);
          int i = ((FileDownloadTaskInfo)localObject).status;
          this.JWQ = ((FileDownloadTaskInfo)localObject).path;
          switch (i)
          {
          case 2: 
          default: 
            if (bu.isNullOrNil(this.xxj)) {
              localObject = a.JXd;
            }
            break;
          case 3: 
            if (o.fB(this.JWQ)) {
              localObject = a.JXb;
            } else if (bu.isNullOrNil(this.xxj)) {
              localObject = a.JXd;
            } else {
              localObject = a.JWZ;
            }
            break;
          case 1: 
            localObject = a.JXa;
            continue;
            localObject = a.JWZ;
          }
        }
        break;
      }
    }
    this.JWM.setText(2131757085);
    AppMethodBeat.o(34624);
    return;
    this.JWM.setText(2131757083);
    AppMethodBeat.o(34624);
    return;
    m.a(this.JWU);
    AppMethodBeat.o(34624);
  }
  
  public final void fFO()
  {
    AppMethodBeat.i(34625);
    if (this.uFA == 0)
    {
      this.JWM.setText(2131757092);
      AppMethodBeat.o(34625);
      return;
    }
    if (this.uFA > 99)
    {
      this.JWM.setText(2131757091);
      AppMethodBeat.o(34625);
      return;
    }
    this.JWM.setText(String.format(com.tencent.mm.cb.a.az(this.mContext, 2131757090), new Object[] { Integer.valueOf(this.uFA) }));
    AppMethodBeat.o(34625);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(34621);
      JWY = new a("DEFAULT", 0);
      JWZ = new a("NEED_DOWNLOAD", 1);
      JXa = new a("DOWNLOADING", 2);
      JXb = new a("NEED_INSTALL", 3);
      JXc = new a("INSTALLED", 4);
      JXd = new a("NO_URL", 5);
      JXe = new a[] { JWY, JWZ, JXa, JXb, JXc, JXd };
      AppMethodBeat.o(34621);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.u
 * JD-Core Version:    0.7.0.1
 */