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
import com.tencent.mm.model.ba;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class k
{
  public b JPM;
  public WxImageView JTA;
  public boolean JTB;
  int JTC;
  int JTD;
  public b.b JTa;
  public HashMap<String, Boolean> JTb;
  public RelativeLayout JTc;
  public com.tencent.mm.pluginsdk.ui.tools.h JTd;
  public ImageView JTe;
  public ImageView JTf;
  public MMPinProgressBtn JTg;
  public View JTh;
  public RelativeLayout JTi;
  public ImageView JTj;
  public ImageView JTk;
  public com.tencent.mm.pluginsdk.ui.tools.h JTl;
  public MMPinProgressBtn JTm;
  public TextView JTn;
  public RelativeLayout JTo;
  public TextView JTp;
  public LinearLayout JTq;
  public TextView JTr;
  public TextView JTs;
  public ImageView JTt;
  public ProgressBar JTu;
  public ProgressBar JTv;
  public LinearLayout JTw;
  public TextView JTx;
  public ImageView JTy;
  public MultiTouchImageView JTz;
  long createTime;
  String dyU;
  String fileId;
  public int mPosition;
  public TextView rzW;
  public View tPw;
  int zGB;
  
  @TargetApi(11)
  public k(b paramb, View paramView)
  {
    AppMethodBeat.i(36331);
    this.JTb = new HashMap();
    this.zGB = 0;
    this.JTC = 0;
    this.JTD = 0;
    this.dyU = "";
    this.tPw = paramView;
    this.JPM = paramb;
    this.JTz = ((MultiTouchImageView)paramView.findViewById(2131300914));
    this.JTA = ((WxImageView)paramView.findViewById(2131307106));
    this.JTv = ((ProgressBar)paramView.findViewById(2131300931));
    if (this.JTA != null) {
      this.JTA.setForceTileFlag(c.guy);
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
    this.zGB = paramInt1;
    this.JTC = paramInt2;
    this.JTD = paramInt3;
    this.dyU = paramString1;
    this.fileId = paramString2;
    this.createTime = paramLong;
  }
  
  public final void c(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(36337);
    ad.i("MicroMsg.ImageGalleryViewHolder", "%d switch video model isVideoPlay[%b] alpha[%f]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
    if (paramBoolean)
    {
      View localView = (View)fGB().JTl;
      localView.setAlpha(paramFloat);
      aH(localView, 0);
      if (paramFloat >= 1.0D)
      {
        aH(fGB().JTj, 8);
        aH(fGB().JTk, 8);
      }
      AppMethodBeat.o(36337);
      return;
    }
    aH((View)fGB().JTl, 8);
    aH(fGB().JTj, 0);
    aH(fGB().JTk, 0);
    AppMethodBeat.o(36337);
  }
  
  public final k fGA()
  {
    AppMethodBeat.i(36335);
    if (this.JTc == null)
    {
      this.JTc = ((RelativeLayout)((ViewStub)this.tPw.findViewById(2131304816)).inflate());
      this.JTd = t.hE(this.tPw.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      this.JTc.addView((View)this.JTd, localLayoutParams);
      ((View)this.JTd).setVisibility(8);
      this.JTh = this.JTc.findViewById(2131305896);
      this.JTh.setVisibility(8);
      this.rzW = ((TextView)this.JTc.findViewById(2131304777));
      this.JTg = ((MMPinProgressBtn)this.JTc.findViewById(2131304805));
      this.JTg.setVisibility(8);
      this.JTe = ((ImageView)this.JTc.findViewById(2131304812));
      this.JTf = ((ImageView)this.JTc.findViewById(2131306414));
      this.JTd.setVideoCallback(new h.a()
      {
        public final int eT(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return 0;
        }
        
        public final void eb(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void onCompletion()
        {
          AppMethodBeat.i(36320);
          k.this.JTd.start();
          k.this.JTh.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36318);
              if ((k.this.JTh == null) || (k.this.JTh.getVisibility() == 0))
              {
                AppMethodBeat.o(36318);
                return;
              }
              if ((k.this.JTh.getTag() != null) && ((k.this.JTh.getTag() instanceof s)))
              {
                s locals = (s)k.this.JTh.getTag();
                if ((locals.iun != null) && (!bt.isNullOrNil(locals.iun.hCe)))
                {
                  k.this.JTh.setVisibility(8);
                  AppMethodBeat.o(36318);
                  return;
                }
                if ((locals.iun != null) && (!bt.isNullOrNil(locals.iun.hCh)) && (!bt.isNullOrNil(locals.iun.hCi)))
                {
                  k.this.JTh.setVisibility(8);
                  AppMethodBeat.o(36318);
                  return;
                }
              }
              k.this.JTh.setVisibility(0);
              k.this.JTh.startAnimation(AnimationUtils.loadAnimation(k.this.JTh.getContext(), 2130772047));
              AppMethodBeat.o(36318);
            }
          });
          AppMethodBeat.o(36320);
        }
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(36319);
          k.this.JTd.stop();
          final String str = (String)((View)k.this.JTd).getTag();
          com.tencent.mm.sdk.a.b.O(Base64.encodeToString((com.tencent.mm.plugin.sight.base.e.dPZ() + "[ImageGallery] on play sight error, what=" + paramAnonymousInt1 + ", extra=" + paramAnonymousInt2 + ", path=" + bt.bI(str, "")).getBytes(), 2), "FullScreenPlaySight");
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36317);
              if (bt.isNullOrNil(str))
              {
                com.tencent.mm.ui.base.h.l(k.this.JPM.JPk, 2131764680, 2131757274);
                AppMethodBeat.o(36317);
                return;
              }
              Object localObject = new Intent();
              ((Intent)localObject).setAction("android.intent.action.VIEW");
              n.a(k.this.JPM.JPk, (Intent)localObject, new com.tencent.mm.vfs.e(str), "video/*");
              try
              {
                ImageGalleryUI localImageGalleryUI = k.this.JPM.JPk;
                localObject = Intent.createChooser((Intent)localObject, k.this.JPM.JPk.getContext().getString(2131759030));
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(localImageGalleryUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                localImageGalleryUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(localImageGalleryUI, "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(36317);
                return;
              }
              catch (Exception localException)
              {
                ad.e("MicroMsg.ImageGalleryViewHolder", "startActivity fail, activity not found");
                com.tencent.mm.ui.base.h.l(k.this.JPM.JPk, 2131758931, 2131758932);
                AppMethodBeat.o(36317);
              }
            }
          });
          k.this.JTb.put(str, Boolean.TRUE);
          AppMethodBeat.o(36319);
        }
        
        public final void ta() {}
      });
      this.rzW.setOnClickListener(new k.2(this));
    }
    AppMethodBeat.o(36335);
    return this;
  }
  
  public final k fGB()
  {
    AppMethodBeat.i(36336);
    if (this.JTi == null)
    {
      if (this.JTA != null) {
        this.JTA.setVisibility(8);
      }
      if (this.JTz != null) {
        this.JTz.setVisibility(8);
      }
      this.JTi = ((RelativeLayout)((ViewStub)this.tPw.findViewById(2131306392)).inflate());
      this.JTj = ((ImageView)this.JTi.findViewById(2131306347));
      this.JTk = ((ImageView)this.JTi.findViewById(2131306413));
      this.JTk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(36323);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (k.this.JPM != null)
          {
            ad.i("MicroMsg.ImageGalleryViewHolder", "%d video wait play on click, play video %d", new Object[] { Integer.valueOf(k.this.hashCode()), Integer.valueOf(k.this.mPosition) });
            k.this.JPM.adA(k.this.mPosition);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36323);
        }
      });
      d.aGQ();
      if (!d.aHc()) {
        break label309;
      }
      this.JTl = new VideoPlayerTextureView(this.tPw.getContext());
      g.yhR.idkeyStat(354L, 150L, 1L, false);
    }
    for (;;)
    {
      this.JTn = ((TextView)this.tPw.findViewById(2131298943));
      this.JTl.setPlayProgressCallback(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.JTi.addView((View)this.JTl, 1, localLayoutParams);
      this.JTm = ((MMPinProgressBtn)this.JTi.findViewById(2131306331));
      this.JTm.setVisibility(8);
      ((View)this.JTl).setVisibility(8);
      this.JTo = ((RelativeLayout)this.tPw.findViewById(2131306339));
      this.JTp = ((TextView)this.tPw.findViewById(2131306340));
      this.JTl.setVideoCallback(new h.a()
      {
        public final int eT(final int paramAnonymousInt1, final int paramAnonymousInt2)
        {
          AppMethodBeat.i(36329);
          ad.i("MicroMsg.ImageGalleryViewHolder", "dkvideo onplaytime:%d total:%d,%d size:%d cnt:%d user:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(k.this.zGB), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(k.this.JTC), Integer.valueOf(k.this.JTD), k.this.dyU });
          ba.ajF().ay(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36325);
              g localg = g.yhR;
              int j = k.this.JTC;
              if (paramAnonymousInt2 <= 0) {}
              for (int i = k.this.zGB * 1000;; i = paramAnonymousInt2)
              {
                localg.f(12084, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(1), k.this.dyU, Integer.valueOf(k.this.JTD), k.this.fileId, Long.valueOf(k.this.createTime) });
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
          k.this.JPM.JPk.JRs.i(k.this.JPM.fFL(), 7);
          k.this.JPM.JPk.JRs.irQ = 4;
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36324);
              k.this.JPM.JPk.setVideoStateIv(true);
              b localb = k.this.JPM;
              int i = k.this.mPosition;
              localb.JPq.adS(i);
              k.this.JPM.JPq.fGu();
              AppMethodBeat.o(36324);
            }
          });
          AppMethodBeat.o(36328);
        }
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(36327);
          ad.w("MicroMsg.ImageGalleryViewHolder", "play video error what : " + paramAnonymousInt1 + " extra: " + paramAnonymousInt2);
          if (k.this.JPM != null) {
            k.this.JPM.JPq.jS(paramAnonymousInt1, paramAnonymousInt2);
          }
          k.this.JPM.JPk.JRs.irQ = 4;
          k.this.JPM.JPk.JRs.orD = ("what : " + paramAnonymousInt1 + " extra: " + paramAnonymousInt2);
          g.yhR.f(12084, new Object[] { Integer.valueOf(k.this.JTC), Integer.valueOf(k.this.zGB * 1000), Integer.valueOf(0), Integer.valueOf(4), k.this.dyU, Integer.valueOf(k.this.JTD), k.this.fileId, Long.valueOf(k.this.createTime) });
          AppMethodBeat.o(36327);
        }
        
        public final void ta()
        {
          AppMethodBeat.i(36326);
          if (k.this.JPM != null) {
            k.this.JPM.JPq.fGt();
          }
          AppMethodBeat.o(36326);
        }
      });
      AppMethodBeat.o(36336);
      return this;
      label309:
      this.JTl = new VideoTextureView(this.tPw.getContext());
      g.yhR.idkeyStat(354L, 151L, 1L, false);
    }
  }
  
  public final k fGy()
  {
    AppMethodBeat.i(36333);
    if (this.JTq == null)
    {
      this.JTq = ((LinearLayout)((ViewStub)this.tPw.findViewById(2131300934)).inflate());
      this.JTu = ((ProgressBar)this.JTq.findViewById(2131299229));
      this.JTr = ((TextView)this.JTq.findViewById(2131299230));
      this.JTs = ((TextView)this.JTq.findViewById(2131299228));
      this.JTt = ((ImageView)this.JTq.findViewById(2131299231));
    }
    AppMethodBeat.o(36333);
    return this;
  }
  
  public final k fGz()
  {
    AppMethodBeat.i(36334);
    if (this.JTw == null)
    {
      this.JTw = ((LinearLayout)((ViewStub)this.tPw.findViewById(2131300932)).inflate());
      this.JTy = ((ImageView)this.JTw.findViewById(2131299204));
      this.JTx = ((TextView)this.JTw.findViewById(2131299205));
    }
    AppMethodBeat.o(36334);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k
 * JD-Core Version:    0.7.0.1
 */