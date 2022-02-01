package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.a.c;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class k
{
  public b KkX;
  public b.b KoA;
  public HashMap<String, Boolean> KoB;
  public RelativeLayout KoC;
  public com.tencent.mm.pluginsdk.ui.tools.h KoD;
  public ImageView KoE;
  public ImageView KoF;
  public MMPinProgressBtn KoG;
  public View KoH;
  public RelativeLayout KoI;
  public ImageView KoJ;
  public ImageView KoK;
  public com.tencent.mm.pluginsdk.ui.tools.h KoL;
  public MMPinProgressBtn KoM;
  public TextView KoN;
  public RelativeLayout KoO;
  public TextView KoP;
  public LinearLayout KoQ;
  public TextView KoR;
  public TextView KoS;
  public ImageView KoT;
  public ProgressBar KoU;
  public ProgressBar KoV;
  public LinearLayout KoW;
  public TextView KoX;
  public ImageView KoY;
  public MultiTouchImageView KoZ;
  public WxImageView Kpa;
  public boolean Kpb;
  int Kpc;
  int Kpd;
  long createTime;
  String dzZ;
  String fileId;
  public int mPosition;
  public TextView rIh;
  public View uan;
  int zXJ;
  
  @TargetApi(11)
  public k(b paramb, View paramView)
  {
    AppMethodBeat.i(36331);
    this.KoB = new HashMap();
    this.zXJ = 0;
    this.Kpc = 0;
    this.Kpd = 0;
    this.dzZ = "";
    this.uan = paramView;
    this.KkX = paramb;
    this.KoZ = ((MultiTouchImageView)paramView.findViewById(2131300914));
    this.Kpa = ((WxImageView)paramView.findViewById(2131307106));
    this.KoV = ((ProgressBar)paramView.findViewById(2131300931));
    if (this.Kpa != null) {
      this.Kpa.setForceTileFlag(c.gxf);
    }
    AppMethodBeat.o(36331);
  }
  
  public static void aH(View paramView, int paramInt)
  {
    AppMethodBeat.i(36332);
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(36332);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, long paramLong)
  {
    this.zXJ = paramInt1;
    this.Kpc = paramInt2;
    this.Kpd = paramInt3;
    this.dzZ = paramString1;
    this.fileId = paramString2;
    this.createTime = paramLong;
  }
  
  public final void c(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(36337);
    ae.i("MicroMsg.ImageGalleryViewHolder", "%d switch video model isVideoPlay[%b] alpha[%f]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
    if (paramBoolean)
    {
      View localView = (View)fKM().KoL;
      localView.setAlpha(paramFloat);
      aH(localView, 0);
      if (paramFloat >= 1.0D)
      {
        aH(fKM().KoJ, 8);
        aH(fKM().KoK, 8);
      }
      AppMethodBeat.o(36337);
      return;
    }
    aH((View)fKM().KoL, 8);
    aH(fKM().KoJ, 0);
    aH(fKM().KoK, 0);
    AppMethodBeat.o(36337);
  }
  
  public final k fKJ()
  {
    AppMethodBeat.i(36333);
    if (this.KoQ == null)
    {
      this.KoQ = ((LinearLayout)((ViewStub)this.uan.findViewById(2131300934)).inflate());
      this.KoU = ((ProgressBar)this.KoQ.findViewById(2131299229));
      this.KoR = ((TextView)this.KoQ.findViewById(2131299230));
      this.KoS = ((TextView)this.KoQ.findViewById(2131299228));
      this.KoT = ((ImageView)this.KoQ.findViewById(2131299231));
    }
    AppMethodBeat.o(36333);
    return this;
  }
  
  public final k fKK()
  {
    AppMethodBeat.i(36334);
    if (this.KoW == null)
    {
      this.KoW = ((LinearLayout)((ViewStub)this.uan.findViewById(2131300932)).inflate());
      this.KoY = ((ImageView)this.KoW.findViewById(2131299204));
      this.KoX = ((TextView)this.KoW.findViewById(2131299205));
    }
    AppMethodBeat.o(36334);
    return this;
  }
  
  public final k fKL()
  {
    AppMethodBeat.i(36335);
    if (this.KoC == null)
    {
      this.KoC = ((RelativeLayout)((ViewStub)this.uan.findViewById(2131304816)).inflate());
      this.KoD = t.hK(this.uan.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      this.KoC.addView((View)this.KoD, localLayoutParams);
      ((View)this.KoD).setVisibility(8);
      this.KoH = this.KoC.findViewById(2131305896);
      this.KoH.setVisibility(8);
      this.rIh = ((TextView)this.KoC.findViewById(2131304777));
      this.KoG = ((MMPinProgressBtn)this.KoC.findViewById(2131304805));
      this.KoG.setVisibility(8);
      this.KoE = ((ImageView)this.KoC.findViewById(2131304812));
      this.KoF = ((ImageView)this.KoC.findViewById(2131306414));
      this.KoD.setVideoCallback(new h.a()
      {
        public final int eU(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return 0;
        }
        
        public final void eb(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void onCompletion()
        {
          AppMethodBeat.i(36320);
          k.this.KoD.start();
          k.this.KoH.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36318);
              if ((k.this.KoH == null) || (k.this.KoH.getVisibility() == 0))
              {
                AppMethodBeat.o(36318);
                return;
              }
              if ((k.this.KoH.getTag() != null) && ((k.this.KoH.getTag() instanceof s)))
              {
                s locals = (s)k.this.KoH.getTag();
                if ((locals.ixh != null) && (!bu.isNullOrNil(locals.ixh.hET)))
                {
                  k.this.KoH.setVisibility(8);
                  AppMethodBeat.o(36318);
                  return;
                }
                if ((locals.ixh != null) && (!bu.isNullOrNil(locals.ixh.hEW)) && (!bu.isNullOrNil(locals.ixh.hEX)))
                {
                  k.this.KoH.setVisibility(8);
                  AppMethodBeat.o(36318);
                  return;
                }
              }
              k.this.KoH.setVisibility(0);
              k.this.KoH.startAnimation(AnimationUtils.loadAnimation(k.this.KoH.getContext(), 2130772047));
              AppMethodBeat.o(36318);
            }
          });
          AppMethodBeat.o(36320);
        }
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(36319);
          k.this.KoD.stop();
          final String str = (String)((View)k.this.KoD).getTag();
          com.tencent.mm.sdk.a.b.O(Base64.encodeToString((e.dTw() + "[ImageGallery] on play sight error, what=" + paramAnonymousInt1 + ", extra=" + paramAnonymousInt2 + ", path=" + bu.bI(str, "")).getBytes(), 2), "FullScreenPlaySight");
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36317);
              if (bu.isNullOrNil(str))
              {
                com.tencent.mm.ui.base.h.l(k.this.KkX.Kkw, 2131764680, 2131757274);
                AppMethodBeat.o(36317);
                return;
              }
              Object localObject = new Intent();
              ((Intent)localObject).setAction("android.intent.action.VIEW");
              o.a(k.this.KkX.Kkw, (Intent)localObject, new com.tencent.mm.vfs.k(str), "video/*");
              try
              {
                ImageGalleryUI localImageGalleryUI = k.this.KkX.Kkw;
                localObject = Intent.createChooser((Intent)localObject, k.this.KkX.Kkw.getContext().getString(2131759030));
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(localImageGalleryUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                localImageGalleryUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(localImageGalleryUI, "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(36317);
                return;
              }
              catch (Exception localException)
              {
                ae.e("MicroMsg.ImageGalleryViewHolder", "startActivity fail, activity not found");
                com.tencent.mm.ui.base.h.l(k.this.KkX.Kkw, 2131758931, 2131758932);
                AppMethodBeat.o(36317);
              }
            }
          });
          k.this.KoB.put(str, Boolean.TRUE);
          AppMethodBeat.o(36319);
        }
        
        public final void ta() {}
      });
      this.rIh.setOnClickListener(new k.2(this));
    }
    AppMethodBeat.o(36335);
    return this;
  }
  
  public final k fKM()
  {
    AppMethodBeat.i(36336);
    if (this.KoI == null)
    {
      if (this.Kpa != null) {
        this.Kpa.setVisibility(8);
      }
      if (this.KoZ != null) {
        this.KoZ.setVisibility(8);
      }
      this.KoI = ((RelativeLayout)((ViewStub)this.uan.findViewById(2131306392)).inflate());
      this.KoJ = ((ImageView)this.KoI.findViewById(2131306347));
      this.KoK = ((ImageView)this.KoI.findViewById(2131306413));
      this.KoK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(36323);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (k.this.KkX != null)
          {
            ae.i("MicroMsg.ImageGalleryViewHolder", "%d video wait play on click, play video %d", new Object[] { Integer.valueOf(k.this.hashCode()), Integer.valueOf(k.this.mPosition) });
            k.this.KkX.aeh(k.this.mPosition);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36323);
        }
      });
      d.aHh();
      if (!d.aHt()) {
        break label309;
      }
      this.KoL = new VideoPlayerTextureView(this.uan.getContext());
      g.yxI.idkeyStat(354L, 150L, 1L, false);
    }
    for (;;)
    {
      this.KoN = ((TextView)this.uan.findViewById(2131298943));
      this.KoL.setPlayProgressCallback(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.KoI.addView((View)this.KoL, 1, localLayoutParams);
      this.KoM = ((MMPinProgressBtn)this.KoI.findViewById(2131306331));
      this.KoM.setVisibility(8);
      ((View)this.KoL).setVisibility(8);
      this.KoO = ((RelativeLayout)this.uan.findViewById(2131306339));
      this.KoP = ((TextView)this.uan.findViewById(2131306340));
      this.KoL.setVideoCallback(new h.a()
      {
        public final int eU(final int paramAnonymousInt1, final int paramAnonymousInt2)
        {
          AppMethodBeat.i(36329);
          ae.i("MicroMsg.ImageGalleryViewHolder", "dkvideo onplaytime:%d total:%d,%d size:%d cnt:%d user:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(k.this.zXJ), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(k.this.Kpc), Integer.valueOf(k.this.Kpd), k.this.dzZ });
          bc.ajU().aw(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36325);
              g localg = g.yxI;
              int j = k.this.Kpc;
              if (paramAnonymousInt2 <= 0) {}
              for (int i = k.this.zXJ * 1000;; i = paramAnonymousInt2)
              {
                localg.f(12084, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(1), k.this.dzZ, Integer.valueOf(k.this.Kpd), k.this.fileId, Long.valueOf(k.this.createTime) });
                AppMethodBeat.o(36325);
                return;
              }
            }
          });
          AppMethodBeat.o(36329);
          return 0;
        }
        
        public final void eb(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void onCompletion()
        {
          AppMethodBeat.i(36328);
          k.this.KkX.Kkw.KmD.i(k.this.KkX.fJS(), 7);
          k.this.KkX.Kkw.KmD.iuK = 4;
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36324);
              k.this.KkX.Kkw.setVideoStateIv(true);
              b localb = k.this.KkX;
              int i = k.this.mPosition;
              localb.KkC.aeA(i);
              k.this.KkX.KkC.fKF();
              AppMethodBeat.o(36324);
            }
          });
          AppMethodBeat.o(36328);
        }
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(36327);
          ae.w("MicroMsg.ImageGalleryViewHolder", "play video error what : " + paramAnonymousInt1 + " extra: " + paramAnonymousInt2);
          if (k.this.KkX != null) {
            k.this.KkX.KkC.jW(paramAnonymousInt1, paramAnonymousInt2);
          }
          k.this.KkX.Kkw.KmD.iuK = 4;
          k.this.KkX.Kkw.KmD.oxZ = ("what : " + paramAnonymousInt1 + " extra: " + paramAnonymousInt2);
          g.yxI.f(12084, new Object[] { Integer.valueOf(k.this.Kpc), Integer.valueOf(k.this.zXJ * 1000), Integer.valueOf(0), Integer.valueOf(4), k.this.dzZ, Integer.valueOf(k.this.Kpd), k.this.fileId, Long.valueOf(k.this.createTime) });
          AppMethodBeat.o(36327);
        }
        
        public final void ta()
        {
          AppMethodBeat.i(36326);
          if (k.this.KkX != null) {
            k.this.KkX.KkC.fKE();
          }
          AppMethodBeat.o(36326);
        }
      });
      AppMethodBeat.o(36336);
      return this;
      label309:
      this.KoL = new VideoTextureView(this.uan.getContext());
      g.yxI.idkeyStat(354L, 151L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k
 * JD-Core Version:    0.7.0.1
 */