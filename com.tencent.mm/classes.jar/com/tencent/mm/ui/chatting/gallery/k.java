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
import com.tencent.mm.model.az;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class k
{
  public b Iav;
  public HashMap<String, Boolean> IdA;
  public RelativeLayout IdB;
  public com.tencent.mm.pluginsdk.ui.tools.h IdC;
  public ImageView IdD;
  public ImageView IdE;
  public MMPinProgressBtn IdF;
  public View IdG;
  public RelativeLayout IdH;
  public ImageView IdI;
  public ImageView IdJ;
  public com.tencent.mm.pluginsdk.ui.tools.h IdK;
  public MMPinProgressBtn IdL;
  public TextView IdM;
  public RelativeLayout IdN;
  public TextView IdO;
  public LinearLayout IdP;
  public TextView IdQ;
  public TextView IdR;
  public ImageView IdS;
  public ProgressBar IdT;
  public ProgressBar IdU;
  public LinearLayout IdV;
  public TextView IdW;
  public ImageView IdX;
  public MultiTouchImageView IdY;
  public WxImageView IdZ;
  public b.b Idz;
  public boolean Iea;
  int Ieb;
  int Iec;
  long createTime;
  String dng;
  String fileId;
  public int mPosition;
  public TextView qPW;
  public View sSS;
  int ypz;
  
  @TargetApi(11)
  public k(b paramb, View paramView)
  {
    AppMethodBeat.i(36331);
    this.IdA = new HashMap();
    this.ypz = 0;
    this.Ieb = 0;
    this.Iec = 0;
    this.dng = "";
    this.sSS = paramView;
    this.Iav = paramb;
    this.IdY = ((MultiTouchImageView)paramView.findViewById(2131300914));
    this.IdZ = ((WxImageView)paramView.findViewById(2131307106));
    this.IdU = ((ProgressBar)paramView.findViewById(2131300931));
    if (this.IdZ != null) {
      this.IdZ.setForceTileFlag(c.gaO);
    }
    AppMethodBeat.o(36331);
  }
  
  public static void aF(View paramView, int paramInt)
  {
    AppMethodBeat.i(36332);
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(36332);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, long paramLong)
  {
    this.ypz = paramInt1;
    this.Ieb = paramInt2;
    this.Iec = paramInt3;
    this.dng = paramString1;
    this.fileId = paramString2;
    this.createTime = paramLong;
  }
  
  public final void c(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(36337);
    ac.i("MicroMsg.ImageGalleryViewHolder", "%d switch video model isVideoPlay[%b] alpha[%f]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
    if (paramBoolean)
    {
      View localView = (View)fpS().IdK;
      localView.setAlpha(paramFloat);
      aF(localView, 0);
      if (paramFloat >= 1.0D)
      {
        aF(fpS().IdI, 8);
        aF(fpS().IdJ, 8);
      }
      AppMethodBeat.o(36337);
      return;
    }
    aF((View)fpS().IdK, 8);
    aF(fpS().IdI, 0);
    aF(fpS().IdJ, 0);
    AppMethodBeat.o(36337);
  }
  
  public final k fpP()
  {
    AppMethodBeat.i(36333);
    if (this.IdP == null)
    {
      this.IdP = ((LinearLayout)((ViewStub)this.sSS.findViewById(2131300934)).inflate());
      this.IdT = ((ProgressBar)this.IdP.findViewById(2131299229));
      this.IdQ = ((TextView)this.IdP.findViewById(2131299230));
      this.IdR = ((TextView)this.IdP.findViewById(2131299228));
      this.IdS = ((ImageView)this.IdP.findViewById(2131299231));
    }
    AppMethodBeat.o(36333);
    return this;
  }
  
  public final k fpQ()
  {
    AppMethodBeat.i(36334);
    if (this.IdV == null)
    {
      this.IdV = ((LinearLayout)((ViewStub)this.sSS.findViewById(2131300932)).inflate());
      this.IdX = ((ImageView)this.IdV.findViewById(2131299204));
      this.IdW = ((TextView)this.IdV.findViewById(2131299205));
    }
    AppMethodBeat.o(36334);
    return this;
  }
  
  public final k fpR()
  {
    AppMethodBeat.i(36335);
    if (this.IdB == null)
    {
      this.IdB = ((RelativeLayout)((ViewStub)this.sSS.findViewById(2131304816)).inflate());
      this.IdC = t.hz(this.sSS.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      this.IdB.addView((View)this.IdC, localLayoutParams);
      ((View)this.IdC).setVisibility(8);
      this.IdG = this.IdB.findViewById(2131305896);
      this.IdG.setVisibility(8);
      this.qPW = ((TextView)this.IdB.findViewById(2131304777));
      this.IdF = ((MMPinProgressBtn)this.IdB.findViewById(2131304805));
      this.IdF.setVisibility(8);
      this.IdD = ((ImageView)this.IdB.findViewById(2131304812));
      this.IdE = ((ImageView)this.IdB.findViewById(2131306414));
      this.IdC.setVideoCallback(new h.a()
      {
        public final void dZ(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int eP(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return 0;
        }
        
        public final void onCompletion()
        {
          AppMethodBeat.i(36320);
          k.this.IdC.start();
          k.this.IdG.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36318);
              if ((k.this.IdG == null) || (k.this.IdG.getVisibility() == 0))
              {
                AppMethodBeat.o(36318);
                return;
              }
              if ((k.this.IdG.getTag() != null) && ((k.this.IdG.getTag() instanceof s)))
              {
                s locals = (s)k.this.IdG.getTag();
                if ((locals.iaR != null) && (!bs.isNullOrNil(locals.iaR.hjV)))
                {
                  k.this.IdG.setVisibility(8);
                  AppMethodBeat.o(36318);
                  return;
                }
                if ((locals.iaR != null) && (!bs.isNullOrNil(locals.iaR.hjY)) && (!bs.isNullOrNil(locals.iaR.hjZ)))
                {
                  k.this.IdG.setVisibility(8);
                  AppMethodBeat.o(36318);
                  return;
                }
              }
              k.this.IdG.setVisibility(0);
              k.this.IdG.startAnimation(AnimationUtils.loadAnimation(k.this.IdG.getContext(), 2130772047));
              AppMethodBeat.o(36318);
            }
          });
          AppMethodBeat.o(36320);
        }
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(36319);
          k.this.IdC.stop();
          final String str = (String)((View)k.this.IdC).getTag();
          com.tencent.mm.sdk.a.b.N(Base64.encodeToString((com.tencent.mm.plugin.sight.base.e.dEw() + "[ImageGallery] on play sight error, what=" + paramAnonymousInt1 + ", extra=" + paramAnonymousInt2 + ", path=" + bs.bG(str, "")).getBytes(), 2), "FullScreenPlaySight");
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36317);
              if (bs.isNullOrNil(str))
              {
                com.tencent.mm.ui.base.h.l(k.this.Iav.HZV, 2131764680, 2131757274);
                AppMethodBeat.o(36317);
                return;
              }
              Object localObject = new Intent();
              ((Intent)localObject).setAction("android.intent.action.VIEW");
              m.a(k.this.Iav.HZV, (Intent)localObject, new com.tencent.mm.vfs.e(str), "video/*");
              try
              {
                ImageGalleryUI localImageGalleryUI = k.this.Iav.HZV;
                localObject = Intent.createChooser((Intent)localObject, k.this.Iav.HZV.getContext().getString(2131759030));
                localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(localImageGalleryUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                localImageGalleryUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(localImageGalleryUI, "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(36317);
                return;
              }
              catch (Exception localException)
              {
                ac.e("MicroMsg.ImageGalleryViewHolder", "startActivity fail, activity not found");
                com.tencent.mm.ui.base.h.l(k.this.Iav.HZV, 2131758931, 2131758932);
                AppMethodBeat.o(36317);
              }
            }
          });
          k.this.IdA.put(str, Boolean.TRUE);
          AppMethodBeat.o(36319);
        }
        
        public final void rB() {}
      });
      this.qPW.setOnClickListener(new k.2(this));
    }
    AppMethodBeat.o(36335);
    return this;
  }
  
  public final k fpS()
  {
    AppMethodBeat.i(36336);
    if (this.IdH == null)
    {
      if (this.IdZ != null) {
        this.IdZ.setVisibility(8);
      }
      if (this.IdY != null) {
        this.IdY.setVisibility(8);
      }
      this.IdH = ((RelativeLayout)((ViewStub)this.sSS.findViewById(2131306392)).inflate());
      this.IdI = ((ImageView)this.IdH.findViewById(2131306347));
      this.IdJ = ((ImageView)this.IdH.findViewById(2131306413));
      this.IdJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(36323);
          if (k.this.Iav != null)
          {
            ac.i("MicroMsg.ImageGalleryViewHolder", "%d video wait play on click, play video %d", new Object[] { Integer.valueOf(k.this.hashCode()), Integer.valueOf(k.this.mPosition) });
            k.this.Iav.abo(k.this.mPosition);
          }
          AppMethodBeat.o(36323);
        }
      });
      d.aDL();
      if (!d.aDX()) {
        break label309;
      }
      this.IdK = new VideoPlayerTextureView(this.sSS.getContext());
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 150L, 1L, false);
    }
    for (;;)
    {
      this.IdM = ((TextView)this.sSS.findViewById(2131298943));
      this.IdK.setPlayProgressCallback(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.IdH.addView((View)this.IdK, 1, localLayoutParams);
      this.IdL = ((MMPinProgressBtn)this.IdH.findViewById(2131306331));
      this.IdL.setVisibility(8);
      ((View)this.IdK).setVisibility(8);
      this.IdN = ((RelativeLayout)this.sSS.findViewById(2131306339));
      this.IdO = ((TextView)this.sSS.findViewById(2131306340));
      this.IdK.setVideoCallback(new h.a()
      {
        public final void dZ(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int eP(final int paramAnonymousInt1, final int paramAnonymousInt2)
        {
          AppMethodBeat.i(36329);
          ac.i("MicroMsg.ImageGalleryViewHolder", "dkvideo onplaytime:%d total:%d,%d size:%d cnt:%d user:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(k.this.ypz), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(k.this.Ieb), Integer.valueOf(k.this.Iec), k.this.dng });
          az.agU().az(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36325);
              com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
              int j = k.this.Ieb;
              if (paramAnonymousInt2 <= 0) {}
              for (int i = k.this.ypz * 1000;; i = paramAnonymousInt2)
              {
                localh.f(12084, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(1), k.this.dng, Integer.valueOf(k.this.Iec), k.this.fileId, Long.valueOf(k.this.createTime) });
                AppMethodBeat.o(36325);
                return;
              }
            }
          });
          AppMethodBeat.o(36329);
          return 0;
        }
        
        public final void onCompletion()
        {
          AppMethodBeat.i(36328);
          k.this.Iav.HZV.Ica.i(k.this.Iav.fpg(), 7);
          k.this.Iav.HZV.Ica.hYu = 4;
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36324);
              k.this.Iav.HZV.setVideoStateIv(true);
              b localb = k.this.Iav;
              int i = k.this.mPosition;
              localb.Iab.abG(i);
              k.this.Iav.Iab.fpL();
              AppMethodBeat.o(36324);
            }
          });
          AppMethodBeat.o(36328);
        }
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(36327);
          ac.w("MicroMsg.ImageGalleryViewHolder", "play video error what : " + paramAnonymousInt1 + " extra: " + paramAnonymousInt2);
          if (k.this.Iav != null) {
            k.this.Iav.Iab.jG(paramAnonymousInt1, paramAnonymousInt2);
          }
          k.this.Iav.HZV.Ica.hYu = 4;
          k.this.Iav.HZV.Ica.nOX = ("what : " + paramAnonymousInt1 + " extra: " + paramAnonymousInt2);
          com.tencent.mm.plugin.report.service.h.wUl.f(12084, new Object[] { Integer.valueOf(k.this.Ieb), Integer.valueOf(k.this.ypz * 1000), Integer.valueOf(0), Integer.valueOf(4), k.this.dng, Integer.valueOf(k.this.Iec), k.this.fileId, Long.valueOf(k.this.createTime) });
          AppMethodBeat.o(36327);
        }
        
        public final void rB()
        {
          AppMethodBeat.i(36326);
          if (k.this.Iav != null) {
            k.this.Iav.Iab.fpK();
          }
          AppMethodBeat.o(36326);
        }
      });
      AppMethodBeat.o(36336);
      return this;
      label309:
      this.IdK = new VideoTextureView(this.sSS.getContext());
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 151L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k
 * JD-Core Version:    0.7.0.1
 */