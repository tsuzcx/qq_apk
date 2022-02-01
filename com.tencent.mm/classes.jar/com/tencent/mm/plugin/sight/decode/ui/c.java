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
import com.tencent.mm.g.a.xg;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.vfs.k;

public final class c
  extends com.tencent.mm.ui.base.i
  implements d.a
{
  public int dMN;
  public String hgD;
  public String imagePath;
  private com.tencent.mm.pluginsdk.ui.tools.h oNV;
  private com.tencent.mm.model.d ozB;
  public int rES;
  private TextView ziS;
  private boolean ziT;
  public int zin;
  
  public c(Context paramContext)
  {
    super(paramContext, 2131821761);
    AppMethodBeat.i(116131);
    this.oNV = null;
    this.ziS = null;
    this.dMN = 0;
    this.zin = 0;
    this.rES = 0;
    this.ziT = false;
    this.ozB = new com.tencent.mm.model.d();
    AppMethodBeat.o(116131);
  }
  
  private void closePopup()
  {
    AppMethodBeat.i(116133);
    ae.v("check", "onclick");
    if (this.oNV.isPlaying())
    {
      this.oNV.pause();
      this.ozB.ez(false);
    }
    new aq().post(new Runnable()
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
  
  public final void aAo() {}
  
  public final void aAp() {}
  
  public final void aAq() {}
  
  public final void aAr() {}
  
  public final void dismiss()
  {
    AppMethodBeat.i(116134);
    ae.d("MicroMsg.VideoPopupHelper", "on dismiss");
    if (com.tencent.mm.booter.a.WB() != null) {
      com.tencent.mm.booter.a.WB().WC();
    }
    if (this.oNV != null)
    {
      this.oNV.setVideoCallback(null);
      this.oNV.stop();
      this.oNV.onDetach();
      findViewById(2131306317).setOnClickListener(null);
    }
    if ((!this.ziT) && (isShowing()))
    {
      xg localxg = new xg();
      localxg.dMK.type = 0;
      localxg.dMK.dML = this.zin;
      localxg.dMK.dMM = this.rES;
      localxg.dMK.dMN = this.dMN;
      com.tencent.mm.sdk.b.a.IvT.l(localxg);
    }
    super.dismiss();
    this.ozB.ez(true);
    AppMethodBeat.o(116134);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(116132);
    long l = System.currentTimeMillis();
    ae.d("MicroMsg.VideoPopupHelper", l + " initView beg");
    super.onCreate(paramBundle);
    getWindow().setFlags(16777216, 16777216);
    setContentView(2131495434);
    if (com.tencent.mm.booter.a.WB() != null) {
      com.tencent.mm.booter.a.WB().WD();
    }
    ae.d("MicroMsg.VideoPopupHelper", f.abq() + " initView: fullpath:" + this.hgD + ", imagepath:" + this.imagePath);
    this.ziS = ((TextView)findViewById(2131305896));
    findViewById(2131304777).setVisibility(8);
    paramBundle = (ViewGroup)findViewById(2131306317);
    paramBundle.setBackgroundResource(2131100017);
    ae.i("MicroMsg.VideoPopupHelper", "getVideoView, is normal video");
    if (com.tencent.mm.compatible.util.d.lA(14)) {}
    for (this.oNV = new VideoTextureView(getContext());; this.oNV = new VideoSurfaceView(getContext()))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      paramBundle.addView((View)this.oNV, localLayoutParams);
      this.oNV.setVideoCallback(new h.a()
      {
        public final int eU(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return 0;
        }
        
        public final void eb(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void onCompletion()
        {
          AppMethodBeat.i(116127);
          ae.d("MicroMsg.VideoPopupHelper", "on completion");
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
          ae.e("MicroMsg.VideoPopupHelper", "on play video error, what %d extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          c.b(c.this).stop();
          com.tencent.mm.sdk.a.b.O(Base64.encodeToString((e.dTw() + "[SightPopupHelper] on play video error, what " + paramAnonymousInt1 + " extra " + paramAnonymousInt2 + ", path=" + bu.bI(c.c(c.this), "")).getBytes(), 2), "FullScreenPlaySight");
          final String str = c.c(c.this);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116123);
              Object localObject1 = (ImageView)c.this.findViewById(2131306415);
              ((ImageView)localObject1).setImageBitmap(this.xIs);
              ((ImageView)localObject1).setVisibility(0);
              Object localObject2 = new Intent();
              ((Intent)localObject2).setAction("android.intent.action.VIEW");
              o.a(c.this.getContext(), (Intent)localObject2, new k(str), "video/*");
              try
              {
                localObject1 = c.this.getContext();
                localObject2 = Intent.createChooser((Intent)localObject2, c.this.getContext().getString(2131755927));
                localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(116123);
                return;
              }
              catch (Exception localException)
              {
                ae.e("MicroMsg.VideoPopupHelper", "startActivity fail, activity not found");
                com.tencent.mm.ui.base.h.l(c.this.getContext(), 2131761623, 2131761624);
                AppMethodBeat.o(116123);
              }
            }
          });
          AppMethodBeat.o(116126);
        }
        
        public final void ta()
        {
          AppMethodBeat.i(116125);
          ae.d("MicroMsg.VideoPopupHelper", f.abq() + " onPrepared");
          c.a(c.this);
          AppMethodBeat.o(116125);
        }
      });
      findViewById(2131306317).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(116128);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          c.e(c.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(116128);
        }
      });
      ((View)this.oNV).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(116129);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          c.e(c.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(116129);
        }
      });
      if (this.hgD != null)
      {
        this.oNV.stop();
        this.oNV.setVideoPath(this.hgD);
      }
      ae.d("MicroMsg.VideoPopupHelper", System.currentTimeMillis() - l + " initView end");
      paramBundle = new xg();
      paramBundle.dMK.type = 1;
      com.tencent.mm.sdk.b.a.IvT.l(paramBundle);
      AppMethodBeat.o(116132);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.c
 * JD-Core Version:    0.7.0.1
 */