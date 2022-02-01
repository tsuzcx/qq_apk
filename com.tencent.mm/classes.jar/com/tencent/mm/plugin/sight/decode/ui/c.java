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
import com.tencent.mm.av.g;
import com.tencent.mm.av.o;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.model.d.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.ui.base.i;

public final class c
  extends i
  implements d.a
{
  public int dzm;
  public String gKe;
  public String imagePath;
  private com.tencent.mm.model.d nQt;
  private com.tencent.mm.pluginsdk.ui.tools.h odZ;
  public int qME;
  private TextView xDY;
  private boolean xDZ;
  public int xDt;
  
  public c(Context paramContext)
  {
    super(paramContext, 2131821761);
    AppMethodBeat.i(116131);
    this.odZ = null;
    this.xDY = null;
    this.dzm = 0;
    this.xDt = 0;
    this.qME = 0;
    this.xDZ = false;
    this.nQt = new com.tencent.mm.model.d();
    AppMethodBeat.o(116131);
  }
  
  private void dEN()
  {
    AppMethodBeat.i(116133);
    ac.v("check", "onclick");
    if (this.odZ.isPlaying())
    {
      this.odZ.pause();
      this.nQt.ev(false);
    }
    new ao().post(new Runnable()
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
  
  public final void axj() {}
  
  public final void axk() {}
  
  public final void axl() {}
  
  public final void axm() {}
  
  public final void dismiss()
  {
    AppMethodBeat.i(116134);
    ac.d("MicroMsg.VideoPopupHelper", "on dismiss");
    if (com.tencent.mm.booter.a.Uc() != null) {
      com.tencent.mm.booter.a.Uc().Ud();
    }
    if (this.odZ != null)
    {
      this.odZ.setVideoCallback(null);
      this.odZ.stop();
      this.odZ.onDetach();
      findViewById(2131306317).setOnClickListener(null);
    }
    if ((!this.xDZ) && (isShowing()))
    {
      wj localwj = new wj();
      localwj.dzj.type = 0;
      localwj.dzj.dzk = this.xDt;
      localwj.dzj.dzl = this.qME;
      localwj.dzj.dzm = this.dzm;
      com.tencent.mm.sdk.b.a.GpY.l(localwj);
    }
    super.dismiss();
    this.nQt.ev(true);
    AppMethodBeat.o(116134);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(116132);
    long l = System.currentTimeMillis();
    ac.d("MicroMsg.VideoPopupHelper", l + " initView beg");
    super.onCreate(paramBundle);
    getWindow().setFlags(16777216, 16777216);
    setContentView(2131495434);
    if (com.tencent.mm.booter.a.Uc() != null) {
      com.tencent.mm.booter.a.Uc().Ue();
    }
    ac.d("MicroMsg.VideoPopupHelper", f.YF() + " initView: fullpath:" + this.gKe + ", imagepath:" + this.imagePath);
    this.xDY = ((TextView)findViewById(2131305896));
    findViewById(2131304777).setVisibility(8);
    paramBundle = (ViewGroup)findViewById(2131306317);
    paramBundle.setBackgroundResource(2131100017);
    ac.i("MicroMsg.VideoPopupHelper", "getVideoView, is normal video");
    if (com.tencent.mm.compatible.util.d.kZ(14)) {}
    for (this.odZ = new VideoTextureView(getContext());; this.odZ = new VideoSurfaceView(getContext()))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      paramBundle.addView((View)this.odZ, localLayoutParams);
      this.odZ.setVideoCallback(new h.a()
      {
        public final void dZ(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int eP(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return 0;
        }
        
        public final void onCompletion()
        {
          AppMethodBeat.i(116127);
          ac.d("MicroMsg.VideoPopupHelper", "on completion");
          c.d(c.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116124);
              c.d(c.this).setVisibility(0);
              c.d(c.this).startAnimation(AnimationUtils.loadAnimation(c.this.getContext(), 2130772047));
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
          ac.e("MicroMsg.VideoPopupHelper", "on play video error, what %d extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          c.b(c.this).stop();
          b.N(Base64.encodeToString((com.tencent.mm.plugin.sight.base.e.dEw() + "[SightPopupHelper] on play video error, what " + paramAnonymousInt1 + " extra " + paramAnonymousInt2 + ", path=" + bs.bG(c.c(c.this), "")).getBytes(), 2), "FullScreenPlaySight");
          final String str = c.c(c.this);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116123);
              Object localObject1 = (ImageView)c.this.findViewById(2131306415);
              ((ImageView)localObject1).setImageBitmap(this.wkB);
              ((ImageView)localObject1).setVisibility(0);
              Object localObject2 = new Intent();
              ((Intent)localObject2).setAction("android.intent.action.VIEW");
              m.a(c.this.getContext(), (Intent)localObject2, new com.tencent.mm.vfs.e(str), "video/*");
              try
              {
                localObject1 = c.this.getContext();
                localObject2 = Intent.createChooser((Intent)localObject2, c.this.getContext().getString(2131755927));
                localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(116123);
                return;
              }
              catch (Exception localException)
              {
                ac.e("MicroMsg.VideoPopupHelper", "startActivity fail, activity not found");
                com.tencent.mm.ui.base.h.l(c.this.getContext(), 2131761623, 2131761624);
                AppMethodBeat.o(116123);
              }
            }
          });
          AppMethodBeat.o(116126);
        }
        
        public final void rB()
        {
          AppMethodBeat.i(116125);
          ac.d("MicroMsg.VideoPopupHelper", f.YF() + " onPrepared");
          c.a(c.this);
          AppMethodBeat.o(116125);
        }
      });
      findViewById(2131306317).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(116128);
          c.e(c.this);
          AppMethodBeat.o(116128);
        }
      });
      ((View)this.odZ).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(116129);
          c.e(c.this);
          AppMethodBeat.o(116129);
        }
      });
      if (this.gKe != null)
      {
        this.odZ.stop();
        this.odZ.setVideoPath(this.gKe);
      }
      ac.d("MicroMsg.VideoPopupHelper", System.currentTimeMillis() - l + " initView end");
      paramBundle = new wj();
      paramBundle.dzj.type = 1;
      com.tencent.mm.sdk.b.a.GpY.l(paramBundle);
      AppMethodBeat.o(116132);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.c
 * JD-Core Version:    0.7.0.1
 */