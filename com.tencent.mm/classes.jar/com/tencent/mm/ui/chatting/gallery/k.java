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
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class k
{
  public b GAA;
  public b.b GDC;
  public HashMap<String, Boolean> GDD;
  public RelativeLayout GDE;
  public com.tencent.mm.pluginsdk.ui.tools.h GDF;
  public ImageView GDG;
  public ImageView GDH;
  public MMPinProgressBtn GDI;
  public View GDJ;
  public RelativeLayout GDK;
  public ImageView GDL;
  public ImageView GDM;
  public com.tencent.mm.pluginsdk.ui.tools.h GDN;
  public MMPinProgressBtn GDO;
  public TextView GDP;
  public RelativeLayout GDQ;
  public TextView GDR;
  public LinearLayout GDS;
  public TextView GDT;
  public TextView GDU;
  public ImageView GDV;
  public ProgressBar GDW;
  public ProgressBar GDX;
  public LinearLayout GDY;
  public TextView GDZ;
  public ImageView GEa;
  public MultiTouchImageView GEb;
  public WxImageView GEc;
  public boolean GEd;
  int GEe;
  int GEf;
  long createTime;
  String dpv;
  String fileId;
  public int mPosition;
  public TextView qhu;
  public View rLd;
  int xcL;
  
  @TargetApi(11)
  public k(b paramb, View paramView)
  {
    AppMethodBeat.i(36331);
    this.GDD = new HashMap();
    this.xcL = 0;
    this.GEe = 0;
    this.GEf = 0;
    this.dpv = "";
    this.rLd = paramView;
    this.GAA = paramb;
    this.GEb = ((MultiTouchImageView)paramView.findViewById(2131300914));
    this.GEc = ((WxImageView)paramView.findViewById(2131307106));
    this.GDX = ((ProgressBar)paramView.findViewById(2131300931));
    if (this.GEc != null) {
      this.GEc.setForceTileFlag(c.fWh);
    }
    AppMethodBeat.o(36331);
  }
  
  public static void aD(View paramView, int paramInt)
  {
    AppMethodBeat.i(36332);
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(36332);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, long paramLong)
  {
    this.xcL = paramInt1;
    this.GEe = paramInt2;
    this.GEf = paramInt3;
    this.dpv = paramString1;
    this.fileId = paramString2;
    this.createTime = paramLong;
  }
  
  public final void b(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(36337);
    ad.i("MicroMsg.ImageGalleryViewHolder", "%d switch video model isVideoPlay[%b] alpha[%f]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
    if (paramBoolean)
    {
      View localView = (View)fac().GDN;
      localView.setAlpha(paramFloat);
      aD(localView, 0);
      if (paramFloat >= 1.0D)
      {
        aD(fac().GDL, 8);
        aD(fac().GDM, 8);
      }
      AppMethodBeat.o(36337);
      return;
    }
    aD((View)fac().GDN, 8);
    aD(fac().GDL, 0);
    aD(fac().GDM, 0);
    AppMethodBeat.o(36337);
  }
  
  public final k eZZ()
  {
    AppMethodBeat.i(36333);
    if (this.GDS == null)
    {
      this.GDS = ((LinearLayout)((ViewStub)this.rLd.findViewById(2131300934)).inflate());
      this.GDW = ((ProgressBar)this.GDS.findViewById(2131299229));
      this.GDT = ((TextView)this.GDS.findViewById(2131299230));
      this.GDU = ((TextView)this.GDS.findViewById(2131299228));
      this.GDV = ((ImageView)this.GDS.findViewById(2131299231));
    }
    AppMethodBeat.o(36333);
    return this;
  }
  
  public final k faa()
  {
    AppMethodBeat.i(36334);
    if (this.GDY == null)
    {
      this.GDY = ((LinearLayout)((ViewStub)this.rLd.findViewById(2131300932)).inflate());
      this.GEa = ((ImageView)this.GDY.findViewById(2131299204));
      this.GDZ = ((TextView)this.GDY.findViewById(2131299205));
    }
    AppMethodBeat.o(36334);
    return this;
  }
  
  public final k fab()
  {
    AppMethodBeat.i(36335);
    if (this.GDE == null)
    {
      this.GDE = ((RelativeLayout)((ViewStub)this.rLd.findViewById(2131304816)).inflate());
      this.GDF = t.ho(this.rLd.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      this.GDE.addView((View)this.GDF, localLayoutParams);
      ((View)this.GDF).setVisibility(8);
      this.GDJ = this.GDE.findViewById(2131305896);
      this.GDJ.setVisibility(8);
      this.qhu = ((TextView)this.GDE.findViewById(2131304777));
      this.GDI = ((MMPinProgressBtn)this.GDE.findViewById(2131304805));
      this.GDI.setVisibility(8);
      this.GDG = ((ImageView)this.GDE.findViewById(2131304812));
      this.GDH = ((ImageView)this.GDE.findViewById(2131306414));
      this.GDF.setVideoCallback(new h.a()
      {
        public final void dY(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int eM(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return 0;
        }
        
        public final void onCompletion()
        {
          AppMethodBeat.i(36320);
          k.this.GDF.start();
          k.this.GDJ.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36318);
              if ((k.this.GDJ == null) || (k.this.GDJ.getVisibility() == 0))
              {
                AppMethodBeat.o(36318);
                return;
              }
              if ((k.this.GDJ.getTag() != null) && ((k.this.GDJ.getTag() instanceof s)))
              {
                s locals = (s)k.this.GDJ.getTag();
                if ((locals.hAq != null) && (!bt.isNullOrNil(locals.hAq.gJv)))
                {
                  k.this.GDJ.setVisibility(8);
                  AppMethodBeat.o(36318);
                  return;
                }
                if ((locals.hAq != null) && (!bt.isNullOrNil(locals.hAq.gJy)) && (!bt.isNullOrNil(locals.hAq.gJz)))
                {
                  k.this.GDJ.setVisibility(8);
                  AppMethodBeat.o(36318);
                  return;
                }
              }
              k.this.GDJ.setVisibility(0);
              k.this.GDJ.startAnimation(AnimationUtils.loadAnimation(k.this.GDJ.getContext(), 2130772047));
              AppMethodBeat.o(36318);
            }
          });
          AppMethodBeat.o(36320);
        }
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(36319);
          k.this.GDF.stop();
          final String str = (String)((View)k.this.GDF).getTag();
          com.tencent.mm.sdk.a.b.M(Base64.encodeToString((com.tencent.mm.plugin.sight.base.e.dqn() + "[ImageGallery] on play sight error, what=" + paramAnonymousInt1 + ", extra=" + paramAnonymousInt2 + ", path=" + bt.by(str, "")).getBytes(), 2), "FullScreenPlaySight");
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36317);
              if (bt.isNullOrNil(str))
              {
                com.tencent.mm.ui.base.h.j(k.this.GAA.GAa, 2131764680, 2131757274);
                AppMethodBeat.o(36317);
                return;
              }
              Object localObject = new Intent();
              ((Intent)localObject).setAction("android.intent.action.VIEW");
              m.a(k.this.GAA.GAa, (Intent)localObject, new com.tencent.mm.vfs.e(str), "video/*");
              try
              {
                ImageGalleryUI localImageGalleryUI = k.this.GAA.GAa;
                localObject = Intent.createChooser((Intent)localObject, k.this.GAA.GAa.getContext().getString(2131759030));
                localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(localImageGalleryUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                localImageGalleryUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
                com.tencent.mm.hellhoundlib.a.a.a(localImageGalleryUI, "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(36317);
                return;
              }
              catch (Exception localException)
              {
                ad.e("MicroMsg.ImageGalleryViewHolder", "startActivity fail, activity not found");
                com.tencent.mm.ui.base.h.j(k.this.GAA.GAa, 2131758931, 2131758932);
                AppMethodBeat.o(36317);
              }
            }
          });
          k.this.GDD.put(str, Boolean.TRUE);
          AppMethodBeat.o(36319);
        }
        
        public final void rq() {}
      });
      this.qhu.setOnClickListener(new k.2(this));
    }
    AppMethodBeat.o(36335);
    return this;
  }
  
  public final k fac()
  {
    AppMethodBeat.i(36336);
    if (this.GDK == null)
    {
      if (this.GEc != null) {
        this.GEc.setVisibility(8);
      }
      if (this.GEb != null) {
        this.GEb.setVisibility(8);
      }
      this.GDK = ((RelativeLayout)((ViewStub)this.rLd.findViewById(2131306392)).inflate());
      this.GDL = ((ImageView)this.GDK.findViewById(2131306347));
      this.GDM = ((ImageView)this.GDK.findViewById(2131306413));
      this.GDM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(36323);
          if (k.this.GAA != null)
          {
            ad.i("MicroMsg.ImageGalleryViewHolder", "%d video wait play on click, play video %d", new Object[] { Integer.valueOf(k.this.hashCode()), Integer.valueOf(k.this.mPosition) });
            k.this.GAA.Zc(k.this.mPosition);
          }
          AppMethodBeat.o(36323);
        }
      });
      d.awT();
      if (!d.axf()) {
        break label309;
      }
      this.GDN = new VideoPlayerTextureView(this.rLd.getContext());
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 150L, 1L, false);
    }
    for (;;)
    {
      this.GDP = ((TextView)this.rLd.findViewById(2131298943));
      this.GDN.setPlayProgressCallback(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.GDK.addView((View)this.GDN, 1, localLayoutParams);
      this.GDO = ((MMPinProgressBtn)this.GDK.findViewById(2131306331));
      this.GDO.setVisibility(8);
      ((View)this.GDN).setVisibility(8);
      this.GDQ = ((RelativeLayout)this.rLd.findViewById(2131306339));
      this.GDR = ((TextView)this.rLd.findViewById(2131306340));
      this.GDN.setVideoCallback(new h.a()
      {
        public final void dY(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int eM(final int paramAnonymousInt1, final int paramAnonymousInt2)
        {
          AppMethodBeat.i(36329);
          ad.i("MicroMsg.ImageGalleryViewHolder", "dkvideo onplaytime:%d total:%d,%d size:%d cnt:%d user:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(k.this.xcL), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(k.this.GEe), Integer.valueOf(k.this.GEf), k.this.dpv });
          az.afE().ax(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36325);
              com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
              int j = k.this.GEe;
              if (paramAnonymousInt2 <= 0) {}
              for (int i = k.this.xcL * 1000;; i = paramAnonymousInt2)
              {
                localh.f(12084, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(1), k.this.dpv, Integer.valueOf(k.this.GEf), k.this.fileId, Long.valueOf(k.this.createTime) });
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
          k.this.GAA.GAa.GCg.i(k.this.GAA.eZr(), 7);
          k.this.GAA.GAa.GCg.hxT = 4;
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36324);
              k.this.GAA.GAa.setVideoStateIv(true);
              b localb = k.this.GAA;
              int i = k.this.mPosition;
              localb.GAg.Zu(i);
              k.this.GAA.GAg.eZV();
              AppMethodBeat.o(36324);
            }
          });
          AppMethodBeat.o(36328);
        }
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(36327);
          ad.w("MicroMsg.ImageGalleryViewHolder", "play video error what : " + paramAnonymousInt1 + " extra: " + paramAnonymousInt2);
          if (k.this.GAA != null) {
            k.this.GAA.GAg.ju(paramAnonymousInt1, paramAnonymousInt2);
          }
          k.this.GAA.GAa.GCg.hxT = 4;
          k.this.GAA.GAa.GCg.nlX = ("what : " + paramAnonymousInt1 + " extra: " + paramAnonymousInt2);
          com.tencent.mm.plugin.report.service.h.vKh.f(12084, new Object[] { Integer.valueOf(k.this.GEe), Integer.valueOf(k.this.xcL * 1000), Integer.valueOf(0), Integer.valueOf(4), k.this.dpv, Integer.valueOf(k.this.GEf), k.this.fileId, Long.valueOf(k.this.createTime) });
          AppMethodBeat.o(36327);
        }
        
        public final void rq()
        {
          AppMethodBeat.i(36326);
          if (k.this.GAA != null) {
            k.this.GAA.GAg.eZU();
          }
          AppMethodBeat.o(36326);
        }
      });
      AppMethodBeat.o(36336);
      return this;
      label309:
      this.GDN = new VideoTextureView(this.rLd.getContext());
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 151L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k
 * JD-Core Version:    0.7.0.1
 */