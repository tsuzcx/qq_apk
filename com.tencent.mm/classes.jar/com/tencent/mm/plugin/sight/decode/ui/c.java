package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.zo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.aq.a.a;
import com.tencent.mm.plugin.aq.a.b;
import com.tencent.mm.plugin.aq.a.e;
import com.tencent.mm.plugin.aq.a.f;
import com.tencent.mm.plugin.aq.a.h;
import com.tencent.mm.plugin.aq.a.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;

public final class c
  extends com.tencent.mm.ui.base.i
  implements d.a
{
  public int JsJ;
  private TextView Jto;
  private boolean Jtp;
  public int fYU;
  public String fullPath;
  public String imagePath;
  private com.tencent.mm.model.d sUi;
  private k txH;
  public int wKJ;
  
  public c(Context paramContext)
  {
    super(paramContext, a.i.videodialog);
    AppMethodBeat.i(116131);
    this.txH = null;
    this.Jto = null;
    this.fYU = 0;
    this.JsJ = 0;
    this.wKJ = 0;
    this.Jtp = false;
    this.sUi = com.tencent.mm.model.d.bcs();
    AppMethodBeat.o(116131);
  }
  
  private void fIP()
  {
    AppMethodBeat.i(116133);
    Log.v("check", "onclick");
    if (this.txH.isPlaying())
    {
      this.txH.pause();
      this.sUi.fZ(false);
    }
    new MMHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116130);
        c.this.dismiss();
        AppMethodBeat.o(116130);
      }
    });
    AppMethodBeat.o(116133);
  }
  
  public final void bcu() {}
  
  public final void bcv() {}
  
  public final void bcw() {}
  
  public final void bcx() {}
  
  public final void dismiss()
  {
    AppMethodBeat.i(116134);
    Log.d("MicroMsg.VideoPopupHelper", "on dismiss");
    if (com.tencent.mm.booter.a.aql() != null) {
      com.tencent.mm.booter.a.aql().aqm();
    }
    if (this.txH != null)
    {
      this.txH.setVideoCallback(null);
      this.txH.stop();
      this.txH.onDetach();
      findViewById(a.e.video_container).setOnClickListener(null);
    }
    if ((!this.Jtp) && (isShowing()))
    {
      zo localzo = new zo();
      localzo.fYR.type = 0;
      localzo.fYR.fYS = this.JsJ;
      localzo.fYR.fYT = this.wKJ;
      localzo.fYR.fYU = this.fYU;
      EventCenter.instance.publish(localzo);
    }
    super.dismiss();
    this.sUi.fZ(true);
    AppMethodBeat.o(116134);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(116132);
    long l = System.currentTimeMillis();
    Log.d("MicroMsg.VideoPopupHelper", l + " initView beg");
    super.onCreate(paramBundle);
    getWindow().setFlags(16777216, 16777216);
    setContentView(a.f.shortvideoplayer);
    if (com.tencent.mm.booter.a.aql() != null) {
      com.tencent.mm.booter.a.aql().aqn();
    }
    Log.d("MicroMsg.VideoPopupHelper", com.tencent.mm.compatible.util.f.avC() + " initView: fullpath:" + this.fullPath + ", imagepath:" + this.imagePath);
    this.Jto = ((TextView)findViewById(a.e.tips_tv));
    findViewById(a.e.show_ad_sight).setVisibility(8);
    paramBundle = (ViewGroup)findViewById(a.e.video_container);
    paramBundle.setBackgroundResource(a.b.black);
    Log.i("MicroMsg.VideoPopupHelper", "getVideoView, is normal video");
    if (com.tencent.mm.compatible.util.d.qV(14)) {}
    for (this.txH = new VideoTextureView(getContext());; this.txH = new VideoSurfaceView(getContext()))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      paramBundle.addView((View)this.txH, localLayoutParams);
      this.txH.setVideoCallback(new k.a()
      {
        public final void eM(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int fE(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return 0;
        }
        
        public final void onCompletion()
        {
          AppMethodBeat.i(116127);
          Log.d("MicroMsg.VideoPopupHelper", "on completion");
          c.d(c.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116124);
              c.d(c.this).setVisibility(0);
              c.d(c.this).startAnimation(AnimationUtils.loadAnimation(c.this.getContext(), a.a.fast_faded_in));
              AppMethodBeat.o(116124);
            }
          });
          c.b(c.this).setLoop(true);
          c.a(c.this);
          AppMethodBeat.o(116127);
        }
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(116126);
          Log.e("MicroMsg.VideoPopupHelper", "on play video error, what %d extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          c.b(c.this).stop();
          CrashReportFactory.reportRawMessage(Base64.encodeToString((com.tencent.mm.plugin.sight.base.f.fIy() + "[SightPopupHelper] on play video error, what " + paramAnonymousInt1 + " extra " + paramAnonymousInt2 + ", path=" + Util.nullAs(c.c(c.this), "")).getBytes(), 2), "FullScreenPlaySight");
          final String str = c.c(c.this);
          com.tencent.mm.ay.i locali = com.tencent.mm.ay.q.bmh();
          float f = com.tencent.mm.ci.a.getDensity(c.this.getContext());
          c.this.getContext();
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116123);
              Object localObject1 = (ImageView)c.this.findViewById(a.e.videoplayer_maskview);
              ((ImageView)localObject1).setImageBitmap(this.HEA);
              ((ImageView)localObject1).setVisibility(0);
              Object localObject2 = new Intent();
              ((Intent)localObject2).setAction("android.intent.action.VIEW");
              FileProviderHelper.setIntentDataAndType(c.this.getContext(), (Intent)localObject2, new com.tencent.mm.vfs.q(str), "video/*", false);
              try
              {
                localObject1 = c.this.getContext();
                localObject2 = Intent.createChooser((Intent)localObject2, c.this.getContext().getString(a.h.app_video_for_icon));
                localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
                com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(116123);
                return;
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.VideoPopupHelper", "startActivity fail, activity not found");
                h.p(c.this.getContext(), a.h.no_match_application_msg, a.h.no_match_application_title);
                AppMethodBeat.o(116123);
              }
            }
          });
          AppMethodBeat.o(116126);
        }
        
        public final void qX()
        {
          AppMethodBeat.i(116125);
          Log.d("MicroMsg.VideoPopupHelper", com.tencent.mm.compatible.util.f.avC() + " onPrepared");
          c.a(c.this);
          AppMethodBeat.o(116125);
        }
      });
      findViewById(a.e.video_container).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(116128);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          c.e(c.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(116128);
        }
      });
      ((View)this.txH).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(116129);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          c.e(c.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(116129);
        }
      });
      if (this.fullPath != null)
      {
        this.txH.stop();
        this.txH.setVideoPath(this.fullPath);
      }
      Log.d("MicroMsg.VideoPopupHelper", System.currentTimeMillis() - l + " initView end");
      paramBundle = new zo();
      paramBundle.fYR.type = 1;
      EventCenter.instance.publish(paramBundle);
      AppMethodBeat.o(116132);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.c
 * JD-Core Version:    0.7.0.1
 */