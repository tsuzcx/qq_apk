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
import com.tencent.mm.aw.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.xc;
import com.tencent.mm.model.d.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.n;

public final class c
  extends com.tencent.mm.ui.base.i
  implements d.a
{
  public int dLy;
  public String hdP;
  public String imagePath;
  private com.tencent.mm.pluginsdk.ui.tools.h oHt;
  private com.tencent.mm.model.d ota;
  public int rwG;
  private TextView ySI;
  private boolean ySJ;
  public int ySd;
  
  public c(Context paramContext)
  {
    super(paramContext, 2131821761);
    AppMethodBeat.i(116131);
    this.oHt = null;
    this.ySI = null;
    this.dLy = 0;
    this.ySd = 0;
    this.rwG = 0;
    this.ySJ = false;
    this.ota = new com.tencent.mm.model.d();
    AppMethodBeat.o(116131);
  }
  
  private void closePopup()
  {
    AppMethodBeat.i(116133);
    ad.v("check", "onclick");
    if (this.oHt.isPlaying())
    {
      this.oHt.pause();
      this.ota.ex(false);
    }
    new ap().post(new Runnable()
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
  
  public final void aAa() {}
  
  public final void aAb() {}
  
  public final void azY() {}
  
  public final void azZ() {}
  
  public final void dismiss()
  {
    AppMethodBeat.i(116134);
    ad.d("MicroMsg.VideoPopupHelper", "on dismiss");
    if (com.tencent.mm.booter.a.Wt() != null) {
      com.tencent.mm.booter.a.Wt().Wu();
    }
    if (this.oHt != null)
    {
      this.oHt.setVideoCallback(null);
      this.oHt.stop();
      this.oHt.onDetach();
      findViewById(2131306317).setOnClickListener(null);
    }
    if ((!this.ySJ) && (isShowing()))
    {
      xc localxc = new xc();
      localxc.dLv.type = 0;
      localxc.dLv.dLw = this.ySd;
      localxc.dLv.dLx = this.rwG;
      localxc.dLv.dLy = this.dLy;
      com.tencent.mm.sdk.b.a.IbL.l(localxc);
    }
    super.dismiss();
    this.ota.ex(true);
    AppMethodBeat.o(116134);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(116132);
    long l = System.currentTimeMillis();
    ad.d("MicroMsg.VideoPopupHelper", l + " initView beg");
    super.onCreate(paramBundle);
    getWindow().setFlags(16777216, 16777216);
    setContentView(2131495434);
    if (com.tencent.mm.booter.a.Wt() != null) {
      com.tencent.mm.booter.a.Wt().Wv();
    }
    ad.d("MicroMsg.VideoPopupHelper", f.abh() + " initView: fullpath:" + this.hdP + ", imagepath:" + this.imagePath);
    this.ySI = ((TextView)findViewById(2131305896));
    findViewById(2131304777).setVisibility(8);
    paramBundle = (ViewGroup)findViewById(2131306317);
    paramBundle.setBackgroundResource(2131100017);
    ad.i("MicroMsg.VideoPopupHelper", "getVideoView, is normal video");
    if (com.tencent.mm.compatible.util.d.ly(14)) {}
    for (this.oHt = new VideoTextureView(getContext());; this.oHt = new VideoSurfaceView(getContext()))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      paramBundle.addView((View)this.oHt, localLayoutParams);
      this.oHt.setVideoCallback(new h.a()
      {
        public final int eT(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return 0;
        }
        
        public final void eb(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void onCompletion()
        {
          AppMethodBeat.i(116127);
          ad.d("MicroMsg.VideoPopupHelper", "on completion");
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
          ad.e("MicroMsg.VideoPopupHelper", "on play video error, what %d extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          c.b(c.this).stop();
          com.tencent.mm.sdk.a.b.O(Base64.encodeToString((com.tencent.mm.plugin.sight.base.e.dPZ() + "[SightPopupHelper] on play video error, what " + paramAnonymousInt1 + " extra " + paramAnonymousInt2 + ", path=" + bt.bI(c.c(c.this), "")).getBytes(), 2), "FullScreenPlaySight");
          final String str = c.c(c.this);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116123);
              Object localObject1 = (ImageView)c.this.findViewById(2131306415);
              ((ImageView)localObject1).setImageBitmap(this.xsv);
              ((ImageView)localObject1).setVisibility(0);
              Object localObject2 = new Intent();
              ((Intent)localObject2).setAction("android.intent.action.VIEW");
              n.a(c.this.getContext(), (Intent)localObject2, new com.tencent.mm.vfs.e(str), "video/*");
              try
              {
                localObject1 = c.this.getContext();
                localObject2 = Intent.createChooser((Intent)localObject2, c.this.getContext().getString(2131755927));
                localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(116123);
                return;
              }
              catch (Exception localException)
              {
                ad.e("MicroMsg.VideoPopupHelper", "startActivity fail, activity not found");
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
          ad.d("MicroMsg.VideoPopupHelper", f.abh() + " onPrepared");
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          c.e(c.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(116128);
        }
      });
      ((View)this.oHt).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(116129);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          c.e(c.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/decode/ui/SightPopupHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(116129);
        }
      });
      if (this.hdP != null)
      {
        this.oHt.stop();
        this.oHt.setVideoPath(this.hdP);
      }
      ad.d("MicroMsg.VideoPopupHelper", System.currentTimeMillis() - l + " initView end");
      paramBundle = new xc();
      paramBundle.dLv.type = 1;
      com.tencent.mm.sdk.b.a.IbL.l(paramBundle);
      AppMethodBeat.o(116132);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.c
 * JD-Core Version:    0.7.0.1
 */