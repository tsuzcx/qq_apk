package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import java.io.Serializable;

final class q$a
  extends com.tencent.mm.sdk.d.d
  implements Serializable
{
  c ynD;
  c ynE;
  c ynF;
  c ynG;
  c ynH;
  c ynI;
  c ynJ;
  c ynK;
  c ynL;
  
  protected q$a(q paramq, String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    AppMethodBeat.i(96551);
    this.ynD = new c();
    this.ynE = new g();
    this.ynF = new e();
    this.ynG = new h();
    this.ynH = new i();
    this.ynI = new f();
    this.ynJ = new b();
    this.ynK = new a();
    this.ynL = new d();
    a(this.ynE);
    a(this.ynD);
    a(this.ynF);
    a(this.ynG);
    a(this.ynH);
    a(this.ynI);
    a(this.ynJ);
    a(this.ynK);
    a(this.ynL);
    b(this.ynL);
    AppMethodBeat.o(96551);
  }
  
  final class a
    extends com.tencent.mm.sdk.d.b
  {
    a() {}
    
    public final void enter()
    {
      AppMethodBeat.i(96513);
      super.enter();
      ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DisableUnsupportPlatformState enter, idx=" + q.b(q.a.this.ynC).yii);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96512);
          q.c(q.a.this.ynC).setVisibility(8);
          q.d(q.a.this.ynC).setEnabled(false);
          Button localButton = q.d(q.a.this.ynC);
          if (!TextUtils.isEmpty(q.b(q.a.this.ynC).yhY)) {}
          for (String str = q.b(q.a.this.ynC).yhY;; str = "暂不支持安卓手机")
          {
            localButton.setText(str);
            q.d(q.a.this.ynC).setVisibility(0);
            AppMethodBeat.o(96512);
            return;
          }
        }
      });
      AppMethodBeat.o(96513);
    }
  }
  
  final class b
    extends com.tencent.mm.sdk.d.b
  {
    b() {}
    
    public final void enter()
    {
      AppMethodBeat.i(96515);
      super.enter();
      ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DoNetSceneState enter, idx=" + q.b(q.a.this.ynC).yii);
      AdLandingPagesProxy.getInstance().doAdChannelScene(q.b(q.a.this.ynC).JG, q.b(q.a.this.ynC).channelId, q.a.this.ynC.ynB, q.b(q.a.this.ynC).yhU);
      ac.i("LogStateTransitionState", "[DoNetSceneState], appid=" + q.b(q.a.this.ynC).djj + ", pkg=" + q.b(q.a.this.ynC).JG + ", channelId=" + q.b(q.a.this.ynC).channelId + ", useGameDownloadWidget=" + q.b(q.a.this.ynC).yhU + ", hash=" + hashCode());
      AppMethodBeat.o(96515);
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(96514);
      ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DoNetSceneState msg=" + paramMessage.what + ", idx=" + q.b(q.a.this.ynC).yii);
      ac.i("LogStateTransitionState", hashCode() + "[DoNetSceneState]recv msg.what " + paramMessage.what);
      if (AdLandingPagesProxy.getInstance().isApkExist(q.b(q.a.this.ynC).djj))
      {
        q.a.this.b(q.a.this.ynG);
        AppMethodBeat.o(96514);
        return true;
      }
      switch (paramMessage.what)
      {
      case 7: 
      case 8: 
      case 9: 
      default: 
        AppMethodBeat.o(96514);
        return false;
      case 6: 
        q.a.this.b(q.a.this.ynE);
        AppMethodBeat.o(96514);
        return true;
      case 5: 
        q.a.a(q.a.this, q.a.this.ynC.context.getString(2131763750));
        q.a.this.b(q.a.this.ynI);
        AppMethodBeat.o(96514);
        return true;
      }
      q.a.this.b(q.a.this.ynE);
      AppMethodBeat.o(96514);
      return true;
    }
  }
  
  final class c
    extends com.tencent.mm.sdk.d.b
  {
    AdLandingPagesProxy.a ynQ;
    
    c() {}
    
    public final void enter()
    {
      AppMethodBeat.i(96527);
      super.enter();
      ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DownloadingState enter, idx=" + q.b(q.a.this.ynC).yii);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96516);
          q.d(q.a.this.ynC).setVisibility(8);
          q.c(q.a.this.ynC).setVisibility(0);
          AppMethodBeat.o(96516);
        }
      });
      if ((AdLandingPagesProxy.getInstance().isPaused(q.b(q.a.this.ynC).djj)) || (AdLandingPagesProxy.getInstance().isDownloading(q.b(q.a.this.ynC).djj)))
      {
        if (this.ynQ == null) {
          this.ynQ = new a((byte)0);
        }
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96517);
            q.c(q.a.this.ynC).setProgress(AdLandingPagesProxy.getInstance().getTaskProgress(q.b(q.a.this.ynC).djj));
            AppMethodBeat.o(96517);
          }
        });
        if (!AdLandingPagesProxy.getInstance().resumeTask(q.b(q.a.this.ynC).djj, this.ynQ, q.a.this.ynC.dKH().yeO, q.a.this.ynC.dKH().jyU, q.a.this.ynC.dKH().dtx))
        {
          AdLandingPagesProxy.getInstance().stopTask(q.b(q.a.this.ynC).djj);
          q.a.this.b(q.a.this.ynD);
          AppMethodBeat.o(96527);
        }
      }
      else
      {
        if (TextUtils.isEmpty(q.b(q.a.this.ynC).downloadUrl))
        {
          q.a.this.b(q.a.this.ynJ);
          AppMethodBeat.o(96527);
          return;
        }
        if (AdLandingPagesProxy.getInstance().isApkExist(q.b(q.a.this.ynC).djj))
        {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96518);
              q.c(q.a.this.ynC).setProgress(100);
              AppMethodBeat.o(96518);
            }
          });
          q.a.this.b(q.a.this.ynG);
          AppMethodBeat.o(96527);
          return;
        }
        AdLandingPagesProxy.getInstance().stopTask(q.b(q.a.this.ynC).djj);
        this.ynQ = new a((byte)0);
        AdLandingPagesProxy.getInstance().startDownload(q.b(q.a.this.ynC).djj, q.b(q.a.this.ynC).yhT, q.b(q.a.this.ynC).JG, q.b(q.a.this.ynC).md5, q.b(q.a.this.ynC).downloadUrl, q.b(q.a.this.ynC).yhV, q.b(q.a.this.ynC).yhW, this.ynQ, q.a.this.ynC.dKH().yeO, q.a.this.ynC.dKH().jyU, q.a.this.ynC.dKH().dtx, q.b(q.a.this.ynC).yhU);
      }
      AppMethodBeat.o(96527);
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(96528);
      if (paramMessage.what != 1) {
        ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DownloadingState, msg=" + paramMessage.what + ", idx=" + q.b(q.a.this.ynC).yii);
      }
      ac.i("LogStateTransitionState", hashCode() + "[DownloadingState] recv msg.what " + paramMessage.what);
      switch (paramMessage.what)
      {
      case 2: 
      case 4: 
      case 5: 
      case 6: 
      default: 
        AppMethodBeat.o(96528);
        return false;
      case 0: 
        if ((AdLandingPagesProxy.getInstance().pauseTask(q.b(q.a.this.ynC).djj)) && (AdLandingPagesProxy.getInstance().isPaused(q.b(q.a.this.ynC).djj))) {
          q.a.this.b(q.a.this.ynF);
        }
        AppMethodBeat.o(96528);
        return true;
      case 1: 
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96519);
            if (this.val$progress >= 0) {
              q.c(q.a.this.ynC).setProgress(this.val$progress);
            }
            AppMethodBeat.o(96519);
          }
        });
        AppMethodBeat.o(96528);
        return true;
      case 3: 
        q.a.this.b(q.a.this.ynH);
        AppMethodBeat.o(96528);
        return true;
      case 7: 
        q.a.this.b(q.a.this.ynF);
        AppMethodBeat.o(96528);
        return true;
      case 8: 
        q.a.a(q.a.this, q.a.this.ynC.context.getString(2131763750));
        q.a.this.b(q.a.this.ynI);
        AppMethodBeat.o(96528);
        return true;
      }
      q.a.this.ynC.dKP();
      q.a.this.b(q.a.this.ynG);
      AppMethodBeat.o(96528);
      return true;
    }
    
    final class a
      implements AdLandingPagesProxy.a
    {
      private a() {}
      
      public final void Og(int paramInt)
      {
        AppMethodBeat.i(96521);
        if (paramInt % 20 == 0) {
          ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "progress:" + paramInt + ", idx=" + q.b(q.a.this.ynC).yii);
        }
        q.a locala = q.a(q.a.this.ynC);
        d.c localc = locala.GuZ;
        if (localc != null) {
          localc.sendMessage(Message.obtain(locala.GuZ, 1, paramInt, 0));
        }
        AppMethodBeat.o(96521);
      }
      
      public final void dGU()
      {
        AppMethodBeat.i(96522);
        ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "paused, idx=" + q.b(q.a.this.ynC).yii);
        q.a(q.a.this.ynC).Yv(7);
        AppMethodBeat.o(96522);
      }
      
      public final void dGV()
      {
        AppMethodBeat.i(96523);
        ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "stopped, idx=" + q.b(q.a.this.ynC).yii);
        AppMethodBeat.o(96523);
      }
      
      public final void dGW()
      {
        AppMethodBeat.i(96524);
        ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "succeed, idx=" + q.b(q.a.this.ynC).yii);
        q.a(q.a.this.ynC).Yv(9);
        AppMethodBeat.o(96524);
      }
      
      public final void dGX()
      {
        AppMethodBeat.i(96525);
        ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "failed, idx=" + q.b(q.a.this.ynC).yii);
        q.a(q.a.this.ynC).Yv(8);
        AppMethodBeat.o(96525);
      }
      
      public final void dGY()
      {
        AppMethodBeat.i(96526);
        ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "resumed, idx=" + q.b(q.a.this.ynC).yii);
        q.a(q.a.this.ynC).Yv(13);
        AppMethodBeat.o(96526);
      }
      
      public final void start()
      {
        AppMethodBeat.i(96520);
        ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "start, idx=" + q.b(q.a.this.ynC).yii);
        AppMethodBeat.o(96520);
      }
    }
  }
  
  final class d
    extends com.tencent.mm.sdk.d.b
  {
    d() {}
    
    public final void enter()
    {
      AppMethodBeat.i(96529);
      super.enter();
      ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "InitState enter, idx=" + q.b(q.a.this.ynC).yii);
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b localb = q.b(q.a.this.ynC);
      int i;
      if ((localb.yhX == 0) || (localb.yhX == 2)) {
        i = 1;
      }
      while (i != 0) {
        if (AdLandingPagesProxy.getInstance().isApkExist(q.b(q.a.this.ynC).djj))
        {
          q.a.this.b(q.a.this.ynG);
          AppMethodBeat.o(96529);
          return;
          i = 0;
        }
        else
        {
          if (AdLandingPagesProxy.getInstance().isPkgInstalled(q.b(q.a.this.ynC).JG))
          {
            q.a.this.b(q.a.this.ynH);
            AppMethodBeat.o(96529);
            return;
          }
          q.a.this.b(q.a.this.ynJ);
          AppMethodBeat.o(96529);
          return;
        }
      }
      q.a.this.b(q.a.this.ynK);
      AppMethodBeat.o(96529);
    }
  }
  
  final class e
    extends com.tencent.mm.sdk.d.b
  {
    e() {}
    
    public final void enter()
    {
      AppMethodBeat.i(96532);
      super.enter();
      ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "PauseState enter, idx=" + q.b(q.a.this.ynC).yii);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96530);
          q.c(q.a.this.ynC).setVisibility(8);
          q.d(q.a.this.ynC).setVisibility(0);
          q.d(q.a.this.ynC).setText(2131763749);
          AppMethodBeat.o(96530);
        }
      });
      AppMethodBeat.o(96532);
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(96533);
      ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "PauseState, msg=" + paramMessage.what + ", idx=" + q.b(q.a.this.ynC).yii);
      ac.i("LogStateTransitionState", hashCode() + "[PauseState] recv msg.what " + paramMessage.what);
      switch (paramMessage.what)
      {
      default: 
        AppMethodBeat.o(96533);
        return false;
      case 0: 
        if (AdLandingPagesProxy.getInstance().isDownloading(q.b(q.a.this.ynC).djj)) {
          q.a.a(q.a.this, q.a.this.ynC.context.getString(2131763748));
        }
        for (;;)
        {
          AppMethodBeat.o(96533);
          return true;
          if (!NetStatusUtil.isWifi(q.a.this.ynC.context))
          {
            ac.i("LogStateTransitionState", "download not in wifi!");
            com.tencent.mm.plugin.sns.data.h.a(q.a.this.ynC.dnn, q.a.this.ynC.appId, 0, 1, q.a.this.ynC.dtx, q.a.this.ynC.xOm, 1);
            com.tencent.mm.ui.base.h.a(q.a.this.ynC.context, 2131766086, 2131766087, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(96531);
                q.a.this.Yv(12);
                com.tencent.mm.plugin.sns.data.h.a(q.f(q.a.this.ynC), q.g(q.a.this.ynC), 1, 1, q.h(q.a.this.ynC), q.i(q.a.this.ynC), 1);
                com.tencent.mm.modelstat.d.d(10, "AdLandingPageDownloadApkBtnComp_PAUSE_MSG_BTN_CLICK", q.a.e.this.hashCode());
                AppMethodBeat.o(96531);
              }
            }, null);
          }
          else
          {
            int i = q.b(q.a.this.ynC).yik;
            ac.i("MicroMsg.AdLandingPageDownloadApkBtnComp.GroceryDownload", "showDownloadTip = ".concat(String.valueOf(i)));
            if (i == 1) {
              q.a.a(q.a.this, 1);
            } else {
              q.a.this.Yv(12);
            }
          }
        }
      case 3: 
        q.a.this.b(q.a.this.ynH);
        AppMethodBeat.o(96533);
        return true;
      case 8: 
        q.a.a(q.a.this, q.a.this.ynC.context.getString(2131763750));
        q.a.this.b(q.a.this.ynI);
        AppMethodBeat.o(96533);
        return true;
      case 12: 
        q.a.this.b(q.a.this.ynD);
        AppMethodBeat.o(96533);
        return true;
      }
      q.a.this.b(q.a.this.ynD);
      AppMethodBeat.o(96533);
      return true;
    }
  }
  
  final class f
    extends com.tencent.mm.sdk.d.b
  {
    f() {}
    
    public final void enter()
    {
      AppMethodBeat.i(96535);
      super.enter();
      ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ReDownloadState enter, idx=" + q.b(q.a.this.ynC).yii);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96534);
          q.c(q.a.this.ynC).setVisibility(8);
          q.d(q.a.this.ynC).setVisibility(0);
          q.d(q.a.this.ynC).setText(2131763755);
          AppMethodBeat.o(96534);
        }
      });
      AppMethodBeat.o(96535);
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(96536);
      ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ReDownloadState, msg=" + paramMessage.what + ", idx=" + q.b(q.a.this.ynC).yii);
      ac.i("LogStateTransitionState", hashCode() + "[ReDownloadState] recv msg.what " + paramMessage.what);
      switch (paramMessage.what)
      {
      default: 
        AppMethodBeat.o(96536);
        return false;
      }
      q.a.this.b(q.a.this.ynJ);
      AppMethodBeat.o(96536);
      return true;
    }
  }
  
  final class g
    extends com.tencent.mm.sdk.d.b
  {
    g() {}
    
    public final void enter()
    {
      AppMethodBeat.i(96543);
      super.enter();
      ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToDownloadState enter, idx=" + q.b(q.a.this.ynC).yii);
      ap.f(new q.a.g.1(this));
      if (AdLandingPagesProxy.getInstance().isPkgInstalled(q.b(q.a.this.ynC).JG))
      {
        q.a.this.b(q.a.this.ynH);
        AppMethodBeat.o(96543);
        return;
      }
      if (AdLandingPagesProxy.getInstance().isApkExist(q.b(q.a.this.ynC).djj))
      {
        q.a.this.b(q.a.this.ynG);
        AppMethodBeat.o(96543);
        return;
      }
      if (AdLandingPagesProxy.getInstance().isDownloading(q.b(q.a.this.ynC).djj))
      {
        q.a.this.b(q.a.this.ynD);
        AppMethodBeat.o(96543);
        return;
      }
      if (AdLandingPagesProxy.getInstance().isPaused(q.b(q.a.this.ynC).djj))
      {
        q.a.this.b(q.a.this.ynF);
        AppMethodBeat.o(96543);
        return;
      }
      ap.f(new q.a.g.2(this));
      boolean bool;
      if (q.a.this.ynC.yny) {
        if (q.a.this.ynC.dKH().ykb) {
          bool = q.b(q.a.this.ynC).yij;
        }
      }
      for (;;)
      {
        if ((bool) && (q.a.this.ynC.ynz))
        {
          q.a.this.ynC.ynz = false;
          ap.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96540);
              try
              {
                double d = (float)q.b(q.a.this.ynC).fileSize / 1024.0F / 1024.0F;
                if (d > 0.0D) {
                  str = String.format("%.1f", new Object[] { Double.valueOf(d) });
                }
                for (String str = q.a.this.ynC.context.getString(2131763738, new Object[] { q.b(q.a.this.ynC).yhV, str });; str = q.a.this.ynC.context.getString(2131763737, new Object[] { q.b(q.a.this.ynC).yhV }))
                {
                  com.tencent.mm.plugin.sns.data.h.a(q.f(q.a.this.ynC), q.g(q.a.this.ynC), 0, 0, q.h(q.a.this.ynC), q.i(q.a.this.ynC), 1);
                  com.tencent.mm.ui.base.h.a(q.a.this.ynC.context, str, "", new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(96539);
                      q.a(q.a.this.ynC).Yv(0);
                      com.tencent.mm.plugin.sns.data.h.a(q.f(q.a.this.ynC), q.g(q.a.this.ynC), 1, 0, q.h(q.a.this.ynC), q.i(q.a.this.ynC), 1);
                      AppMethodBeat.o(96539);
                    }
                  }, null);
                  AppMethodBeat.o(96540);
                  return;
                }
                return;
              }
              catch (Exception localException)
              {
                ac.e("LogStateTransitionState", "showAutoDownloadDialog exp=" + localException.toString());
                AppMethodBeat.o(96540);
              }
            }
          }, 800L);
        }
        AppMethodBeat.o(96543);
        return;
        if (q.b(q.a.this.ynC).yii == 0)
        {
          bool = true;
        }
        else
        {
          bool = false;
          continue;
          bool = false;
        }
      }
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(96544);
      ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToDownloadState, msg=" + paramMessage.what + ", idx=" + q.b(q.a.this.ynC).yii);
      ac.i("LogStateTransitionState", hashCode() + "[ToDownloadState]recv msg.what " + paramMessage.what);
      switch (paramMessage.what)
      {
      default: 
        AppMethodBeat.o(96544);
        return false;
      case 0: 
        if (AdLandingPagesProxy.getInstance().isDownloading(q.b(q.a.this.ynC).djj)) {
          q.a.a(q.a.this, q.a.this.ynC.context.getString(2131763748));
        }
        for (;;)
        {
          AppMethodBeat.o(96544);
          return true;
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96542);
              if (!NetStatusUtil.isWifi(q.a.this.ynC.context))
              {
                ac.i("LogStateTransitionState", "download not in wifi!");
                com.tencent.mm.plugin.sns.data.h.a(q.f(q.a.this.ynC), q.g(q.a.this.ynC), 0, 0, q.h(q.a.this.ynC), q.i(q.a.this.ynC), 1);
                com.tencent.mm.ui.base.h.a(q.a.this.ynC.context, 2131766086, 2131766087, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(96541);
                    q.a(q.a.this.ynC).Yv(12);
                    com.tencent.mm.plugin.sns.data.h.a(q.f(q.a.this.ynC), q.g(q.a.this.ynC), 1, 0, q.h(q.a.this.ynC), q.i(q.a.this.ynC), 1);
                    com.tencent.mm.modelstat.d.d(10, "AdLandingPageDownloadApkBtnComp_TODOWLOAD_MSG_BTN_CLICK", q.a.g.this.hashCode());
                    AppMethodBeat.o(96541);
                  }
                }, null);
                AppMethodBeat.o(96542);
                return;
              }
              int i = q.b(q.a.this.ynC).yik;
              ac.i("MicroMsg.AdLandingPageDownloadApkBtnComp.GroceryDownload", "showDownloadTip = ".concat(String.valueOf(i)));
              if (i == 1)
              {
                if (AdLandingPagesProxy.getInstance().isPaused(q.b(q.a.this.ynC).djj))
                {
                  q.a.a(q.a.this, 1);
                  AppMethodBeat.o(96542);
                  return;
                }
                q.a.a(q.a.this, 0);
                AppMethodBeat.o(96542);
                return;
              }
              q.a(q.a.this.ynC).Yv(12);
              AppMethodBeat.o(96542);
            }
          });
        }
      case 3: 
        q.a.this.b(q.a.this.ynH);
        AppMethodBeat.o(96544);
        return true;
      case 11: 
        q.a.this.b(q.a.this.ynE);
        AppMethodBeat.o(96544);
        return true;
      }
      q.a.this.b(q.a.this.ynD);
      AppMethodBeat.o(96544);
      return true;
    }
  }
  
  final class h
    extends com.tencent.mm.sdk.d.b
  {
    private boolean ynX;
    
    h() {}
    
    public final void enter()
    {
      AppMethodBeat.i(96546);
      ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToInstallState enter, idx=" + q.b(q.a.this.ynC).yii);
      super.enter();
      if (!AdLandingPagesProxy.getInstance().isApkExist(q.b(q.a.this.ynC).djj))
      {
        q.a.this.b(q.a.this.ynE);
        AppMethodBeat.o(96546);
        return;
      }
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96545);
          q.c(q.a.this.ynC).setVisibility(8);
          q.d(q.a.this.ynC).setVisibility(0);
          q.d(q.a.this.ynC).setText(2131763751);
          AppMethodBeat.o(96545);
        }
      });
      this.ynX = true;
      AppMethodBeat.o(96546);
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(96547);
      ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToInstallState, msg=" + paramMessage.what + ", idx=" + q.b(q.a.this.ynC).yii);
      ac.i("LogStateTransitionState", hashCode() + "[ToInstallState] recv msg.what " + paramMessage.what);
      switch (paramMessage.what)
      {
      case 1: 
      default: 
        AppMethodBeat.o(96547);
        return false;
      case 0: 
        if (AdLandingPagesProxy.getInstance().installApp(q.a.this.ynC.context, q.b(q.a.this.ynC).djj, q.b(q.a.this.ynC).JG, q.b(q.a.this.ynC).md5, q.b(q.a.this.ynC).downloadUrl))
        {
          this.ynX = true;
          AppMethodBeat.o(96547);
          return true;
        }
        q.a.a(q.a.this, q.a.this.ynC.context.getString(2131763752));
        q.a.this.b(q.a.this.ynI);
        AppMethodBeat.o(96547);
        return true;
      case 2: 
        if (!AdLandingPagesProxy.getInstance().isApkExist(q.b(q.a.this.ynC).djj)) {
          q.a.this.b(q.a.this.ynE);
        }
        AppMethodBeat.o(96547);
        return true;
      }
      if (this.ynX) {
        this.ynX = false;
      }
      q.a.this.b(q.a.this.ynH);
      AppMethodBeat.o(96547);
      return true;
    }
  }
  
  final class i
    extends com.tencent.mm.sdk.d.b
  {
    i() {}
    
    public final void enter()
    {
      AppMethodBeat.i(96549);
      super.enter();
      ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToOpenState enter, idx=" + q.b(q.a.this.ynC).yii);
      if (AdLandingPagesProxy.getInstance().isPkgInstalled(q.b(q.a.this.ynC).JG))
      {
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96548);
            q.c(q.a.this.ynC).setVisibility(8);
            q.d(q.a.this.ynC).setVisibility(0);
            q.d(q.a.this.ynC).setText(2131763753);
            AppMethodBeat.o(96548);
          }
        });
        AppMethodBeat.o(96549);
        return;
      }
      q.a.this.b(q.a.this.ynG);
      AppMethodBeat.o(96549);
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(96550);
      ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToOpenState, msg=" + paramMessage.what + ", idx=" + q.b(q.a.this.ynC).yii);
      ac.i("LogStateTransitionState", hashCode() + "[ToOpenState] recv msg.what " + paramMessage.what);
      switch (paramMessage.what)
      {
      default: 
        AppMethodBeat.o(96550);
        return false;
      case 0: 
        if (j.a(q.a.this.ynC.context, q.b(q.a.this.ynC).djj, q.b(q.a.this.ynC).JG, "", q.b(q.a.this.ynC).yfc, q.a.this.ynC.dtx, q.a.this.ynC.xOm, q.a.this.ynC.dnn, 1))
        {
          AppMethodBeat.o(96550);
          return true;
        }
        q.a.a(q.a.this, q.a.this.ynC.context.getString(2131763754));
        q.a.this.b(q.a.this.ynH);
        AppMethodBeat.o(96550);
        return true;
      }
      q.a.this.b(q.a.this.ynE);
      AppMethodBeat.o(96550);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q.a
 * JD-Core Version:    0.7.0.1
 */