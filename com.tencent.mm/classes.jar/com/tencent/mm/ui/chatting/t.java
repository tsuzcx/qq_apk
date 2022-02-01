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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;

public final class t
{
  public ChatFooterCustom JBS;
  public FrameLayout JBT;
  public FrameLayout JBU;
  public TextView JBV;
  public ImageView JBW;
  a JBX;
  public boolean JBY;
  String JBZ;
  public String JCa;
  public View.OnClickListener JCb;
  public View.OnClickListener JCc;
  private m.a JCd;
  Context mContext;
  public LinearLayout pPh;
  long qfF;
  SharedPreferences sp;
  public int uuf;
  public String xhr;
  String xhs;
  String xht;
  
  public t(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(34622);
    this.pPh = null;
    this.JBX = a.JCh;
    this.uuf = -1;
    this.JBZ = null;
    this.qfF = -1L;
    this.JCb = new t.1(this);
    this.JCc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34610);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        switch (t.8.JCg[t.this.JBX.ordinal()])
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34610);
          return;
          com.tencent.mm.plugin.report.service.g.yhR.f(11288, new Object[] { Integer.valueOf(6) });
          paramAnonymousView = t.this;
          if (!ay.isConnected(paramAnonymousView.mContext))
          {
            h.a(paramAnonymousView.mContext, com.tencent.mm.cc.a.az(paramAnonymousView.mContext, 2131757089), "", com.tencent.mm.cc.a.az(paramAnonymousView.mContext, 2131757084), null);
          }
          else if (!ay.isWifi(paramAnonymousView.mContext))
          {
            h.a(paramAnonymousView.mContext, 2131757086, 0, 2131757082, 2131757081, new t.3(paramAnonymousView), null);
          }
          else
          {
            h.a(paramAnonymousView.mContext, 2131757087, 0, 2131757082, 2131757081, new t.4(paramAnonymousView), null);
            continue;
            paramAnonymousView = t.this;
            ad.i("MicroMsg.ChattingQQMailFooterHandler", "dz[cancelDownload]");
            f.ccl().tR(paramAnonymousView.qfF);
            paramAnonymousView.fBL();
            continue;
            com.tencent.mm.plugin.report.service.g.yhR.f(11288, new Object[] { Integer.valueOf(7) });
            paramAnonymousView = t.this;
            ad.i("MicroMsg.ChattingQQMailFooterHandler", "dz[installQQMail]");
            j.aK(paramAnonymousView.mContext, paramAnonymousView.JBZ);
            continue;
            com.tencent.mm.plugin.report.service.g.yhR.f(11288, new Object[] { Integer.valueOf(5) });
            t localt = t.this;
            ad.i("MicroMsg.ChattingQQMailFooterHandler", "dz[openQQMail]");
            ad.i("MicroMsg.ChattingQQMailFooterHandler", "mQQMailScheme = %s", new Object[] { localt.JCa });
            if (bt.isNullOrNil(localt.JCa)) {
              paramAnonymousView = localt.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
            }
            for (;;)
            {
              ad.i("MicroMsg.ChattingQQMailFooterHandler", "intent = %s", new Object[] { paramAnonymousView });
              com.tencent.mm.ci.a.post(new t.5(localt, paramAnonymousView));
              break;
              localObject = new Intent();
              ((Intent)localObject).setData(Uri.parse(localt.JCa));
              ((Intent)localObject).addFlags(268435456);
              if (Build.VERSION.SDK_INT >= 11) {
                ((Intent)localObject).addFlags(32768);
              }
              paramAnonymousView = (View)localObject;
              if (!bt.aj(localt.mContext, (Intent)localObject)) {
                paramAnonymousView = localt.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
              }
            }
            if (t.this.JBY) {
              t.a(t.this);
            }
          }
        }
      }
    };
    this.JCd = new m.a()
    {
      public final void dCp()
      {
        AppMethodBeat.i(34617);
        t.this.JBV.setText(2131757092);
        AppMethodBeat.o(34617);
      }
      
      public final void onSuccess(int paramAnonymousInt)
      {
        AppMethodBeat.i(34616);
        t.this.uuf = paramAnonymousInt;
        t.this.fBM();
        AppMethodBeat.o(34616);
      }
    };
    this.mContext = paramChatFooterCustom.getContext();
    this.JBS = paramChatFooterCustom;
    AppMethodBeat.o(34622);
  }
  
  public final void fBK()
  {
    AppMethodBeat.i(34623);
    if (this.JBX == a.JCl)
    {
      this.JBW.setImageResource(2131691054);
      AppMethodBeat.o(34623);
      return;
    }
    this.JBW.setImageResource(2131691055);
    AppMethodBeat.o(34623);
  }
  
  public final void fBL()
  {
    AppMethodBeat.i(34624);
    Object localObject;
    if (q.s(this.mContext, "com.tencent.androidqqmail")) {
      localObject = a.JCl;
    }
    for (;;)
    {
      this.JBX = ((a)localObject);
      fBK();
      ad.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initRightBtnTv: status:%s]", new Object[] { this.JBX.toString() });
      switch (8.JCg[this.JBX.ordinal()])
      {
      default: 
        m.a(this.JCd);
        AppMethodBeat.o(34624);
        return;
        this.sp = this.mContext.getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.g.abm());
        this.qfF = this.sp.getLong("qqmail_downloadid", -1L);
        if (this.qfF < 0L)
        {
          if (bt.isNullOrNil(this.xhr)) {
            localObject = a.JCm;
          } else {
            localObject = a.JCi;
          }
        }
        else
        {
          localObject = f.ccl().tS(this.qfF);
          int i = ((FileDownloadTaskInfo)localObject).status;
          this.JBZ = ((FileDownloadTaskInfo)localObject).path;
          switch (i)
          {
          case 2: 
          default: 
            if (bt.isNullOrNil(this.xhr)) {
              localObject = a.JCm;
            }
            break;
          case 3: 
            if (i.fv(this.JBZ)) {
              localObject = a.JCk;
            } else if (bt.isNullOrNil(this.xhr)) {
              localObject = a.JCm;
            } else {
              localObject = a.JCi;
            }
            break;
          case 1: 
            localObject = a.JCj;
            continue;
            localObject = a.JCi;
          }
        }
        break;
      }
    }
    this.JBV.setText(2131757085);
    AppMethodBeat.o(34624);
    return;
    this.JBV.setText(2131757083);
    AppMethodBeat.o(34624);
    return;
    m.a(this.JCd);
    AppMethodBeat.o(34624);
  }
  
  public final void fBM()
  {
    AppMethodBeat.i(34625);
    if (this.uuf == 0)
    {
      this.JBV.setText(2131757092);
      AppMethodBeat.o(34625);
      return;
    }
    if (this.uuf > 99)
    {
      this.JBV.setText(2131757091);
      AppMethodBeat.o(34625);
      return;
    }
    this.JBV.setText(String.format(com.tencent.mm.cc.a.az(this.mContext, 2131757090), new Object[] { Integer.valueOf(this.uuf) }));
    AppMethodBeat.o(34625);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(34621);
      JCh = new a("DEFAULT", 0);
      JCi = new a("NEED_DOWNLOAD", 1);
      JCj = new a("DOWNLOADING", 2);
      JCk = new a("NEED_INSTALL", 3);
      JCl = new a("INSTALLED", 4);
      JCm = new a("NO_URL", 5);
      JCn = new a[] { JCh, JCi, JCj, JCk, JCl, JCm };
      AppMethodBeat.o(34621);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t
 * JD-Core Version:    0.7.0.1
 */