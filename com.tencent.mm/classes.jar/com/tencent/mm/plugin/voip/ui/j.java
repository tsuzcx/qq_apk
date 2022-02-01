package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.c.a.a;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.threadpool.i;

public final class j
{
  private a Lvx;
  public boolean Lvy = false;
  MTimerHandler Lvz;
  public VoipViewFragment UKx;
  private Intent intent;
  
  public final void Bh(int paramInt)
  {
    AppMethodBeat.i(184080);
    if (this.UKx != null)
    {
      String str = String.format("%02d:%02d", new Object[] { Integer.valueOf(paramInt / 60), Integer.valueOf(paramInt % 60) });
      this.UKx.aNF(str);
    }
    AppMethodBeat.o(184080);
  }
  
  public final void GH(final boolean paramBoolean)
  {
    AppMethodBeat.i(292478);
    if ((this.UKx != null) && (!this.Lvy))
    {
      com.tencent.threadpool.h.ahAA.bFQ("showIcon");
      com.tencent.threadpool.h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184077);
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184076);
              if ((j.this.UKx != null) && (!j.this.Lvy))
              {
                Object localObject = j.this.UKx;
                boolean bool = j.6.this.val$show;
                localObject = ((VoipViewFragment)localObject).getCurrentView();
                if (localObject != null) {
                  ((BaseSmallView)localObject).GH(bool);
                }
              }
              AppMethodBeat.o(184076);
            }
          });
          AppMethodBeat.o(184077);
        }
      }, "showIcon");
    }
    AppMethodBeat.o(292478);
  }
  
  public final void a(final Intent paramIntent, final boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(292443);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.VoipVoiceMiniManager", "showMini, intent cannot be null!");
      AppMethodBeat.o(292443);
      return;
    }
    if (parama == null)
    {
      Log.e("MicroMsg.VoipVoiceMiniManager", "showMini, VoipMiniCallBack cannot be null!");
      AppMethodBeat.o(292443);
      return;
    }
    this.intent = paramIntent;
    this.Lvx = parama;
    if (!com.tencent.mm.compatible.e.b.dh(MMApplicationContext.getContext()))
    {
      Log.e("MicroMsg.VoipVoiceMiniManager", "mini, permission denied");
      Context localContext = MMApplicationContext.getContext();
      RequestFloatWindowPermissionDialog.a(localContext, localContext.getString(b.g.voip_float_permission_alert_content), new RequestFloatWindowPermissionDialog.a()
      {
        public final void a(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(184065);
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          parama.fQT();
          if (parama.fQS()) {
            j.this.d(paramIntent, paramBoolean, this.Uvf);
          }
          AppMethodBeat.o(184065);
        }
        
        public final void b(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(184066);
          parama.fQU();
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          AppMethodBeat.o(184066);
        }
        
        public final void c(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(185955);
          parama.fQU();
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          AppMethodBeat.o(185955);
        }
      }, com.tencent.mm.bq.a.aQB());
      AppMethodBeat.o(292443);
      return;
    }
    parama.fQT();
    d(paramIntent, paramBoolean, false);
    AppMethodBeat.o(292443);
  }
  
  public final void aNF(String paramString)
  {
    AppMethodBeat.i(292460);
    if (this.UKx != null) {
      this.UKx.aNF(paramString);
    }
    AppMethodBeat.o(292460);
  }
  
  public final BaseSmallView br(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(292493);
    if (this.UKx != null)
    {
      BaseSmallView localBaseSmallView = this.UKx.br(paramBoolean1, paramBoolean2);
      AppMethodBeat.o(292493);
      return localBaseSmallView;
    }
    AppMethodBeat.o(292493);
    return null;
  }
  
  final void d(final Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(184079);
    Log.i("MicroMsg.VoipVoiceMiniManager", "mini now..");
    if (this.UKx != null)
    {
      this.Lvx.a(paramIntent, this.UKx.br(paramBoolean1, false));
      AppMethodBeat.o(184079);
      return;
    }
    this.UKx = new VoipViewFragment(MMApplicationContext.getContext());
    this.Lvy = false;
    if (this.Lvz != null) {
      this.Lvz.stopTimer();
    }
    this.UKx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(184069);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        a.a.Uvh.hVt();
        if (com.tencent.mm.plugin.voip.f.h.ibz())
        {
          paramAnonymousView = SubCoreVoip.hVp().UBE.toUser;
          if (TextUtils.isEmpty(paramAnonymousView))
          {
            Log.w("MicroMsg.VoipVoiceMiniManager", "null talkName");
            paramAnonymousView = null;
            if (paramAnonymousView != null)
            {
              localObject = MMApplicationContext.getContext();
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject).startActivity((Intent)paramAnonymousView.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
        }
        for (;;)
        {
          j.this.Lvz = new MTimerHandler(new MTimerHandler.CallBack()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(184067);
              Log.i("MicroMsg.VoipVoiceMiniManager", "click small view and time is up we remove it..");
              j.this.jb(false);
              if (j.this.Lvz != null) {
                j.this.Lvz.stopTimer();
              }
              AppMethodBeat.o(184067);
              return true;
            }
          }, false);
          j.this.Lvz.startTimer(2000L);
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184068);
              j.this.jb(false);
              AppMethodBeat.o(184068);
            }
          }, 200L);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(184069);
          return;
          paramAnonymousView = ((com.tencent.mm.plugin.flutter.voip.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.flutter.voip.a.a.class)).aQ(MMApplicationContext.getContext(), paramAnonymousView);
          break;
          paramIntent.addFlags(268435456);
          paramAnonymousView = MMApplicationContext.getContext();
          localObject = paramIntent;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    });
    if (paramBoolean1) {
      a.a.Uvh.a(4, paramBoolean2, this.UKx);
    }
    for (;;)
    {
      this.Lvx.a(paramIntent, this.UKx.br(paramBoolean1, false));
      AppMethodBeat.o(184079);
      return;
      a.a.Uvh.a(8, paramBoolean2, this.UKx);
    }
  }
  
  public final void ghz()
  {
    AppMethodBeat.i(184082);
    if (this.UKx != null)
    {
      this.Lvy = true;
      com.tencent.threadpool.h.ahAA.bFQ("showIcon");
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184071);
          BaseSmallView localBaseSmallView;
          if (j.this.UKx != null)
          {
            localBaseSmallView = j.this.UKx.getCurrentView();
            if (localBaseSmallView != null) {
              break label62;
            }
          }
          label62:
          for (boolean bool = false;; bool = localBaseSmallView.ghw())
          {
            if (bool) {
              com.tencent.threadpool.h.ahAA.o(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(184070);
                  j.this.jb(true);
                  AppMethodBeat.o(184070);
                }
              }, 2000L);
            }
            AppMethodBeat.o(184071);
            return;
          }
        }
      });
      AppMethodBeat.o(184082);
      return;
    }
    jb(true);
    AppMethodBeat.o(184082);
  }
  
  public final void jb(boolean paramBoolean)
  {
    AppMethodBeat.i(184084);
    Log.i("MicroMsg.VoipVoiceMiniManager", "dismiss now.. isFinish: %b, smallView: %s", new Object[] { Boolean.valueOf(paramBoolean), this.UKx });
    if (this.UKx != null)
    {
      if (paramBoolean) {
        a.a.Uvh.b(this.UKx);
      }
      if (this.UKx != null)
      {
        this.UKx.setOnClickListener(null);
        this.UKx = null;
        AppMethodBeat.o(184084);
      }
    }
    else if (paramBoolean)
    {
      a.a.Uvh.cYp();
    }
    AppMethodBeat.o(184084);
  }
  
  public final void updateText(String paramString)
  {
    AppMethodBeat.i(184081);
    if (this.UKx != null) {
      this.UKx.updateText(paramString);
    }
    AppMethodBeat.o(184081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.j
 * JD-Core Version:    0.7.0.1
 */