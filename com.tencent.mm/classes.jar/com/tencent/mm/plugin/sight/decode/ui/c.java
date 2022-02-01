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
import com.tencent.mm.av.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;

public final class c
  extends com.tencent.mm.ui.base.i
  implements d.a
{
  private TextView DnJ;
  private boolean DnK;
  public int Dne;
  public int eeF;
  public String fullPath;
  public String imagePath;
  private com.tencent.mm.model.d pNk;
  private j qbJ;
  public int tex;
  
  public c(Context paramContext)
  {
    super(paramContext, 2131821817);
    AppMethodBeat.i(116131);
    this.qbJ = null;
    this.DnJ = null;
    this.eeF = 0;
    this.Dne = 0;
    this.tex = 0;
    this.DnK = false;
    this.pNk = new com.tencent.mm.model.d();
    AppMethodBeat.o(116131);
  }
  
  private void eVM()
  {
    AppMethodBeat.i(116133);
    Log.v("check", "onclick");
    if (this.qbJ.isPlaying())
    {
      this.qbJ.pause();
      this.pNk.fp(false);
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
  
  public final void aTw() {}
  
  public final void aTx() {}
  
  public final void aTy() {}
  
  public final void aTz() {}
  
  public final void dismiss()
  {
    AppMethodBeat.i(116134);
    Log.d("MicroMsg.VideoPopupHelper", "on dismiss");
    if (com.tencent.mm.booter.a.akp() != null) {
      com.tencent.mm.booter.a.akp().akq();
    }
    if (this.qbJ != null)
    {
      this.qbJ.setVideoCallback(null);
      this.qbJ.stop();
      this.qbJ.onDetach();
      findViewById(2131309736).setOnClickListener(null);
    }
    if ((!this.DnK) && (isShowing()))
    {
      yh localyh = new yh();
      localyh.eeC.type = 0;
      localyh.eeC.eeD = this.Dne;
      localyh.eeC.eeE = this.tex;
      localyh.eeC.eeF = this.eeF;
      EventCenter.instance.publish(localyh);
    }
    super.dismiss();
    this.pNk.fp(true);
    AppMethodBeat.o(116134);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(116132);
    long l = System.currentTimeMillis();
    Log.d("MicroMsg.VideoPopupHelper", l + " initView beg");
    super.onCreate(paramBundle);
    getWindow().setFlags(16777216, 16777216);
    setContentView(2131496306);
    if (com.tencent.mm.booter.a.akp() != null) {
      com.tencent.mm.booter.a.akp().akr();
    }
    Log.d("MicroMsg.VideoPopupHelper", f.app() + " initView: fullpath:" + this.fullPath + ", imagepath:" + this.imagePath);
    this.DnJ = ((TextView)findViewById(2131309187));
    findViewById(2131307859).setVisibility(8);
    paramBundle = (ViewGroup)findViewById(2131309736);
    paramBundle.setBackgroundResource(2131100042);
    Log.i("MicroMsg.VideoPopupHelper", "getVideoView, is normal video");
    if (com.tencent.mm.compatible.util.d.oD(14)) {}
    for (this.qbJ = new VideoTextureView(getContext());; this.qbJ = new VideoSurfaceView(getContext()))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      paramBundle.addView((View)this.qbJ, localLayoutParams);
      this.qbJ.setVideoCallback(new j.a()
      {
        public final void eo(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int fh(int paramAnonymousInt1, int paramAnonymousInt2)
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
              c.d(c.this).startAnimation(AnimationUtils.loadAnimation(c.this.getContext(), 2130772059));
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
          CrashReportFactory.reportRawMessage(Base64.encodeToString((e.eVv() + "[SightPopupHelper] on play video error, what " + paramAnonymousInt1 + " extra " + paramAnonymousInt2 + ", path=" + Util.nullAs(c.c(c.this), "")).getBytes(), 2), "FullScreenPlaySight");
          final String str = c.c(c.this);
          com.tencent.mm.av.i locali = q.bcR();
          float f = com.tencent.mm.cb.a.getDensity(c.this.getContext());
          c.this.getContext();
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116123);
              Object localObject1 = (ImageView)c.this.findViewById(2131309846);
              ((ImageView)localObject1).setImageBitmap(this.BIt);
              ((ImageView)localObject1).setVisibility(0);
              Object localObject2 = new Intent();
              ((Intent)localObject2).setAction("android.intent.action.VIEW");
              FileProviderHelper.setIntentDataAndType(c.this.getContext(), (Intent)localObject2, new o(str), "video/*", false);
              try
              {
                localObject1 = c.this.getContext();
                localObject2 = Intent.createChooser((Intent)localObject2, c.this.getContext().getString(2131756019));
                localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(116123);
                return;
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.VideoPopupHelper", "startActivity fail, activity not found");
                h.n(c.this.getContext(), 2131763591, 2131763592);
                AppMethodBeat.o(116123);
              }
            }
          });
          AppMethodBeat.o(116126);
        }
        
        public final void tf()
        {
          AppMethodBeat.i(116125);
          Log.d("MicroMsg.VideoPopupHelper", f.app() + " onPrepared");
          c.a(c.this);
          AppMethodBeat.o(116125);
        }
      });
      findViewById(2131309736).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(116128);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          c.e(c.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(116128);
        }
      });
      ((View)this.qbJ).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(116129);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          c.e(c.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(116129);
        }
      });
      if (this.fullPath != null)
      {
        this.qbJ.stop();
        this.qbJ.setVideoPath(this.fullPath);
      }
      Log.d("MicroMsg.VideoPopupHelper", System.currentTimeMillis() - l + " initView end");
      paramBundle = new yh();
      paramBundle.eeC.type = 1;
      EventCenter.instance.publish(paramBundle);
      AppMethodBeat.o(116132);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.c
 * JD-Core Version:    0.7.0.1
 */