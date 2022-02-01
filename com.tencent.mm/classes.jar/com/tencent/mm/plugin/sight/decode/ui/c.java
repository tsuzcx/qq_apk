package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.abi;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.ar.a.a;
import com.tencent.mm.plugin.ar.a.b;
import com.tencent.mm.plugin.ar.a.e;
import com.tencent.mm.plugin.ar.a.f;
import com.tencent.mm.plugin.ar.a.h;
import com.tencent.mm.plugin.ar.a.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.u;

public final class c
  extends com.tencent.mm.ui.widget.a.i
  implements d.a
{
  public int Ahg;
  private boolean PGO;
  public int PGl;
  private TextView PtY;
  public String fullPath;
  public int ieW;
  public String imagePath;
  private com.tencent.mm.model.d vZw;
  private com.tencent.mm.pluginsdk.ui.tools.i wCd;
  
  public c(Context paramContext)
  {
    super(paramContext, a.i.videodialog);
    AppMethodBeat.i(116131);
    this.wCd = null;
    this.PtY = null;
    this.ieW = 0;
    this.PGl = 0;
    this.Ahg = 0;
    this.PGO = false;
    this.vZw = new com.tencent.mm.model.d();
    AppMethodBeat.o(116131);
  }
  
  private void gYI()
  {
    AppMethodBeat.i(116133);
    Log.v("check", "onclick");
    if (this.wCd.isPlaying())
    {
      this.wCd.pause();
      this.vZw.gR(false);
    }
    new MMHandler().post(new c.4(this));
    AppMethodBeat.o(116133);
  }
  
  public final void bAi() {}
  
  public final void bAj() {}
  
  public final void bAk() {}
  
  public final void bAl() {}
  
  public final void dismiss()
  {
    AppMethodBeat.i(116134);
    Log.d("MicroMsg.VideoPopupHelper", "on dismiss");
    if (com.tencent.mm.booter.a.aKj() != null) {
      com.tencent.mm.booter.a.aKj().aKk();
    }
    if (this.wCd != null)
    {
      this.wCd.setVideoCallback(null);
      this.wCd.stop();
      this.wCd.onDetach();
      findViewById(a.e.video_container).setOnClickListener(null);
    }
    if ((!this.PGO) && (isShowing()))
    {
      abi localabi = new abi();
      localabi.ieT.type = 0;
      localabi.ieT.ieU = this.PGl;
      localabi.ieT.ieV = this.Ahg;
      localabi.ieT.ieW = this.ieW;
      localabi.publish();
    }
    super.dismiss();
    this.vZw.gR(true);
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
    if (com.tencent.mm.booter.a.aKj() != null) {
      com.tencent.mm.booter.a.aKj().aKl();
    }
    Log.d("MicroMsg.VideoPopupHelper", com.tencent.mm.compatible.util.f.aPW() + " initView: fullpath:" + this.fullPath + ", imagepath:" + this.imagePath);
    this.PtY = ((TextView)findViewById(a.e.tips_tv));
    findViewById(a.e.show_ad_sight).setVisibility(8);
    paramBundle = (ViewGroup)findViewById(a.e.video_container);
    paramBundle.setBackgroundResource(a.b.black);
    Log.i("MicroMsg.VideoPopupHelper", "getVideoView, is normal video");
    if (com.tencent.mm.compatible.util.d.rb(14)) {}
    for (this.wCd = new VideoTextureView(getContext());; this.wCd = new VideoSurfaceView(getContext()))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      paramBundle.addView((View)this.wCd, localLayoutParams);
      this.wCd.setVideoCallback(new i.a()
      {
        public final void Qz()
        {
          AppMethodBeat.i(116125);
          Log.d("MicroMsg.VideoPopupHelper", com.tencent.mm.compatible.util.f.aPW() + " onPrepared");
          c.a(c.this);
          AppMethodBeat.o(116125);
        }
        
        public final void fG(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int gw(int paramAnonymousInt1, int paramAnonymousInt2)
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
          CrashReportFactory.reportRawMessage(Base64.encodeToString((com.tencent.mm.plugin.sight.base.f.gYr() + "[SightPopupHelper] on play video error, what " + paramAnonymousInt1 + " extra " + paramAnonymousInt2 + ", path=" + Util.nullAs(c.c(c.this), "")).getBytes(), 2), "FullScreenPlaySight");
          final String str = c.c(c.this);
          j localj = r.bKa();
          float f = com.tencent.mm.cd.a.getDensity(c.this.getContext());
          c.this.getContext();
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116123);
              Object localObject1 = (ImageView)c.this.findViewById(a.e.videoplayer_maskview);
              ((ImageView)localObject1).setImageBitmap(this.NCc);
              ((ImageView)localObject1).setVisibility(0);
              Object localObject2 = new Intent();
              ((Intent)localObject2).setAction("android.intent.action.VIEW");
              FileProviderHelper.setIntentDataAndType(c.this.getContext(), (Intent)localObject2, new u(str), "video/*", false);
              try
              {
                localObject1 = c.this.getContext();
                localObject2 = Intent.createChooser((Intent)localObject2, c.this.getContext().getString(a.h.app_video_for_icon));
                localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
                com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(116123);
                return;
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.VideoPopupHelper", "startActivity fail, activity not found");
                k.s(c.this.getContext(), a.h.no_match_application_msg, a.h.no_match_application_title);
                AppMethodBeat.o(116123);
              }
            }
          });
          AppMethodBeat.o(116126);
        }
      });
      findViewById(a.e.video_container).setOnClickListener(new c.2(this));
      ((View)this.wCd).setOnClickListener(new c.3(this));
      if (this.fullPath != null)
      {
        this.wCd.stop();
        this.wCd.setVideoPath(this.fullPath);
      }
      Log.d("MicroMsg.VideoPopupHelper", System.currentTimeMillis() - l + " initView end");
      paramBundle = new abi();
      paramBundle.ieT.type = 1;
      paramBundle.publish();
      AppMethodBeat.o(116132);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.c
 * JD-Core Version:    0.7.0.1
 */