package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.graphics.a.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.pluginsdk.ui.tools.w;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.u;
import java.util.HashMap;

public final class r
{
  public TextView AkH;
  int Qbs;
  public h aeAZ;
  public ProgressBar aeFA;
  public ProgressBar aeFB;
  public LinearLayout aeFC;
  public TextView aeFD;
  public ImageView aeFE;
  public MultiTouchImageView aeFF;
  public WxImageView aeFG;
  public boolean aeFH;
  int aeFI;
  int aeFJ;
  public h.b aeFg;
  public HashMap<String, Boolean> aeFh;
  public RelativeLayout aeFi;
  public i aeFj;
  public ImageView aeFk;
  public ImageView aeFl;
  public MMPinProgressBtn aeFm;
  public View aeFn;
  public RelativeLayout aeFo;
  public ImageView aeFp;
  public ImageView aeFq;
  public i aeFr;
  public MMPinProgressBtn aeFs;
  public TextView aeFt;
  public RelativeLayout aeFu;
  public TextView aeFv;
  public LinearLayout aeFw;
  public TextView aeFx;
  public TextView aeFy;
  public ImageView aeFz;
  public View convertView;
  long createTime;
  String fileId;
  String hQQ;
  public int mPosition;
  
  public r(h paramh, View paramView)
  {
    AppMethodBeat.i(36331);
    this.aeFh = new HashMap();
    this.Qbs = 0;
    this.aeFI = 0;
    this.aeFJ = 0;
    this.hQQ = "";
    this.convertView = paramView;
    this.aeAZ = paramh;
    this.aeFF = ((MultiTouchImageView)paramView.findViewById(R.h.image));
    this.aeFG = ((WxImageView)paramView.findViewById(R.h.wx_image));
    this.aeFB = ((ProgressBar)paramView.findViewById(R.h.fKb));
    if (this.aeFG != null) {
      this.aeFG.setForceTileFlag(d.mvw);
    }
    AppMethodBeat.o(36331);
  }
  
  public static void bo(View paramView, int paramInt)
  {
    AppMethodBeat.i(36332);
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(36332);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, long paramLong)
  {
    this.Qbs = paramInt1;
    this.aeFI = paramInt2;
    this.aeFJ = paramInt3;
    this.hQQ = paramString1;
    this.fileId = paramString2;
    this.createTime = paramLong;
  }
  
  public final void d(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(36337);
    Log.i("MicroMsg.ImageGalleryViewHolder", "%d switch video model isVideoPlay[%b] alpha[%f]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
    if (paramBoolean)
    {
      View localView = (View)jwq().aeFr;
      localView.setAlpha(paramFloat);
      bo(localView, 0);
      if (paramFloat >= 1.0D)
      {
        bo(jwq().aeFp, 8);
        bo(jwq().aeFq, 8);
      }
      AppMethodBeat.o(36337);
      return;
    }
    bo((View)jwq().aeFr, 8);
    bo(jwq().aeFp, 0);
    bo(jwq().aeFq, 0);
    AppMethodBeat.o(36337);
  }
  
  public final r jwn()
  {
    AppMethodBeat.i(36333);
    if (this.aeFw == null)
    {
      this.aeFw = ((LinearLayout)((ViewStub)this.convertView.findViewById(R.h.fKd)).inflate());
      this.aeFA = ((ProgressBar)this.aeFw.findViewById(R.h.downloading_pb));
      this.aeFx = ((TextView)this.aeFw.findViewById(R.h.downloading_percent_tv));
      this.aeFy = ((TextView)this.aeFw.findViewById(R.h.fGp));
      this.aeFz = ((ImageView)this.aeFw.findViewById(R.h.fGq));
    }
    AppMethodBeat.o(36333);
    return this;
  }
  
  public final r jwo()
  {
    AppMethodBeat.i(36334);
    if (this.aeFC == null)
    {
      this.aeFC = ((LinearLayout)((ViewStub)this.convertView.findViewById(R.h.fKc)).inflate());
      this.aeFE = ((ImageView)this.aeFC.findViewById(R.h.fGg));
      this.aeFD = ((TextView)this.aeFC.findViewById(R.h.fGh));
    }
    AppMethodBeat.o(36334);
    return this;
  }
  
  public final r jwp()
  {
    AppMethodBeat.i(36335);
    if (this.aeFi == null)
    {
      this.aeFi = ((RelativeLayout)((ViewStub)this.convertView.findViewById(R.h.fXF)).inflate());
      this.aeFj = w.lG(this.convertView.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      this.aeFi.addView((View)this.aeFj, localLayoutParams);
      ((View)this.aeFj).setVisibility(8);
      this.aeFn = this.aeFi.findViewById(R.h.tips_tv);
      this.aeFn.setVisibility(8);
      this.AkH = ((TextView)this.aeFi.findViewById(R.h.show_ad_sight));
      this.aeFm = ((MMPinProgressBtn)this.aeFi.findViewById(R.h.sight_downloading_pb));
      this.aeFm.setVisibility(8);
      this.aeFk = ((ImageView)this.aeFi.findViewById(R.h.sight_image));
      this.aeFl = ((ImageView)this.aeFi.findViewById(R.h.videoplayer_icon));
      this.aeFj.setVideoCallback(new i.a()
      {
        public final void Qz() {}
        
        public final void fG(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int gw(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return 0;
        }
        
        public final void onCompletion()
        {
          AppMethodBeat.i(36320);
          r.this.aeFj.start();
          r.this.aeFn.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36318);
              if ((r.this.aeFn == null) || (r.this.aeFn.getVisibility() == 0))
              {
                AppMethodBeat.o(36318);
                return;
              }
              if ((r.this.aeFn.getTag() != null) && ((r.this.aeFn.getTag() instanceof z)))
              {
                z localz = (z)r.this.aeFn.getTag();
                if ((localz.pbk != null) && (!Util.isNullOrNil(localz.pbk.nTu)))
                {
                  r.this.aeFn.setVisibility(8);
                  AppMethodBeat.o(36318);
                  return;
                }
                if ((localz.pbk != null) && (!Util.isNullOrNil(localz.pbk.nTx)) && (!Util.isNullOrNil(localz.pbk.nTy)))
                {
                  r.this.aeFn.setVisibility(8);
                  AppMethodBeat.o(36318);
                  return;
                }
              }
              r.this.aeFn.setVisibility(0);
              r.this.aeFn.startAnimation(AnimationUtils.loadAnimation(r.this.aeFn.getContext(), R.a.fast_faded_in));
              AppMethodBeat.o(36318);
            }
          });
          AppMethodBeat.o(36320);
        }
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(36319);
          r.this.aeFj.stop();
          final String str = (String)((View)r.this.aeFj).getTag();
          CrashReportFactory.reportRawMessage(Base64.encodeToString((f.gYr() + "[ImageGallery] on play sight error, what=" + paramAnonymousInt1 + ", extra=" + paramAnonymousInt2 + ", path=" + Util.nullAs(str, "")).getBytes(), 2), "FullScreenPlaySight");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36317);
              if (Util.isNullOrNil(str))
              {
                k.s(r.this.aeAZ.aeAB, R.l.video_file_play_faile, R.l.gze);
                AppMethodBeat.o(36317);
                return;
              }
              Object localObject = new Intent();
              ((Intent)localObject).setAction("android.intent.action.VIEW");
              FileProviderHelper.setIntentDataAndType(r.this.aeAZ.aeAB, (Intent)localObject, new u(str), "video/*", false);
              try
              {
                ImageGalleryUI localImageGalleryUI = r.this.aeAZ.aeAB;
                localObject = Intent.createChooser((Intent)localObject, r.this.aeAZ.aeAB.getContext().getString(R.l.favorite_video));
                localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(localImageGalleryUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                localImageGalleryUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(localImageGalleryUI, "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(36317);
                return;
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.ImageGalleryViewHolder", "startActivity fail, activity not found");
                k.s(r.this.aeAZ.aeAB, R.l.favorite_no_match_msg, R.l.favorite_no_match_title);
                AppMethodBeat.o(36317);
              }
            }
          });
          r.this.aeFh.put(str, Boolean.TRUE);
          AppMethodBeat.o(36319);
        }
      });
      this.AkH.setOnClickListener(new r.2(this));
    }
    AppMethodBeat.o(36335);
    return this;
  }
  
  public final r jwq()
  {
    AppMethodBeat.i(36336);
    if (this.aeFo == null)
    {
      if (this.aeFG != null) {
        this.aeFG.setVisibility(8);
      }
      if (this.aeFF != null) {
        this.aeFF.setVisibility(8);
      }
      this.aeFo = ((RelativeLayout)((ViewStub)this.convertView.findViewById(R.h.video_root)).inflate());
      this.aeFp = ((ImageView)this.aeFo.findViewById(R.h.video_image));
      this.aeFq = ((ImageView)this.aeFo.findViewById(R.h.video_wait_play_btn));
      this.aeFq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(36323);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (r.this.aeAZ != null)
          {
            Log.i("MicroMsg.ImageGalleryViewHolder", "%d video wait play on click, play video %d", new Object[] { Integer.valueOf(r.this.hashCode()), Integer.valueOf(r.this.mPosition) });
            r.this.aeAZ.aCE(r.this.mPosition);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36323);
        }
      });
      if (!q.isEnabled()) {
        break label291;
      }
      this.aeFr = new ThumbPlayerVideoView(this.convertView.getContext());
    }
    for (;;)
    {
      this.aeFt = ((TextView)this.convertView.findViewById(R.h.fEw));
      this.aeFr.setPlayProgressCallback(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.aeFo.addView((View)this.aeFr, 1, localLayoutParams);
      this.aeFs = ((MMPinProgressBtn)this.aeFo.findViewById(R.h.gbA));
      this.aeFs.setVisibility(8);
      ((View)this.aeFr).setVisibility(8);
      this.aeFu = ((RelativeLayout)this.convertView.findViewById(R.h.gbD));
      this.aeFv = ((TextView)this.convertView.findViewById(R.h.gbE));
      this.aeFr.setVideoCallback(new i.a()
      {
        public final void Qz()
        {
          AppMethodBeat.i(36326);
          if (r.this.aeAZ != null) {
            r.this.aeAZ.aeAH.juY();
          }
          AppMethodBeat.o(36326);
        }
        
        public final void fG(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int gw(final int paramAnonymousInt1, final int paramAnonymousInt2)
        {
          AppMethodBeat.i(36329);
          Log.i("MicroMsg.ImageGalleryViewHolder", "dkvideo onplaytime:%d total:%d,%d size:%d cnt:%d user:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(r.this.Qbs), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(r.this.aeFI), Integer.valueOf(r.this.aeFJ), r.this.hQQ });
          bh.baH().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36325);
              com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
              int j = r.this.aeFI;
              if (paramAnonymousInt2 <= 0) {}
              for (int i = r.this.Qbs * 1000;; i = paramAnonymousInt2)
              {
                localh.b(12084, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(1), r.this.hQQ, Integer.valueOf(r.this.aeFJ), r.this.fileId, Long.valueOf(r.this.createTime) });
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
          r.this.aeAZ.aeAB.aeCD.n(r.this.aeAZ.jvd(), 7);
          r.this.aeAZ.aeAB.aeCD.oYt = 4;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36324);
              r.this.aeAZ.aeAB.setVideoStateIv(true);
              h localh = r.this.aeAZ;
              int i = r.this.mPosition;
              localh.aeAH.aCw(i);
              r.this.aeAZ.aeAH.juZ();
              AppMethodBeat.o(36324);
            }
          });
          AppMethodBeat.o(36328);
        }
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(36327);
          Log.w("MicroMsg.ImageGalleryViewHolder", "play video error what : " + paramAnonymousInt1 + " extra: " + paramAnonymousInt2);
          if (r.this.aeAZ != null) {
            r.this.aeAZ.aeAH.di(paramAnonymousInt1, paramAnonymousInt2);
          }
          r.this.aeAZ.aeAB.aeCD.oYt = 4;
          r.this.aeAZ.aeAB.aeCD.Xmv = ("what : " + paramAnonymousInt1 + " extra: " + paramAnonymousInt2);
          com.tencent.mm.plugin.report.service.h.OAn.b(12084, new Object[] { Integer.valueOf(r.this.aeFI), Integer.valueOf(r.this.Qbs * 1000), Integer.valueOf(0), Integer.valueOf(4), r.this.hQQ, Integer.valueOf(r.this.aeFJ), r.this.fileId, Long.valueOf(r.this.createTime) });
          AppMethodBeat.o(36327);
        }
      });
      AppMethodBeat.o(36336);
      return this;
      label291:
      e.bIg();
      if (e.bIv())
      {
        this.aeFr = new VideoPlayerTextureView(this.convertView.getContext());
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 150L, 1L, false);
      }
      else
      {
        this.aeFr = new VideoTextureView(this.convertView.getContext());
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 151L, 1L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.r
 * JD-Core Version:    0.7.0.1
 */