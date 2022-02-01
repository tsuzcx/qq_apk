package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
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
import com.tencent.mm.by.c;
import com.tencent.mm.f.c.et;
import com.tencent.mm.graphics.a.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.chatting.a.a;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.q;
import java.util.HashMap;

public final class p
{
  int JJO;
  public f WRu;
  public f.b WVA;
  public HashMap<String, Boolean> WVB;
  public RelativeLayout WVC;
  public k WVD;
  public ImageView WVE;
  public ImageView WVF;
  public MMPinProgressBtn WVG;
  public View WVH;
  public RelativeLayout WVI;
  public ImageView WVJ;
  public ImageView WVK;
  public k WVL;
  public MMPinProgressBtn WVM;
  public TextView WVN;
  public RelativeLayout WVO;
  public TextView WVP;
  public LinearLayout WVQ;
  public TextView WVR;
  public TextView WVS;
  public ImageView WVT;
  public ProgressBar WVU;
  public ProgressBar WVV;
  public LinearLayout WVW;
  public TextView WVX;
  public ImageView WVY;
  public MultiTouchImageView WVZ;
  public WxImageView WWa;
  public boolean WWb;
  int WWc;
  int WWd;
  public View convertView;
  long createTime;
  String fLi;
  String fileId;
  public int mPosition;
  public TextView wOf;
  
  @TargetApi(11)
  public p(f paramf, View paramView)
  {
    AppMethodBeat.i(36331);
    this.WVB = new HashMap();
    this.JJO = 0;
    this.WWc = 0;
    this.WWd = 0;
    this.fLi = "";
    this.convertView = paramView;
    this.WRu = paramf;
    this.WVZ = ((MultiTouchImageView)paramView.findViewById(R.h.image));
    this.WWa = ((WxImageView)paramView.findViewById(R.h.wx_image));
    this.WVV = ((ProgressBar)paramView.findViewById(R.h.dIG));
    if (this.WWa != null) {
      this.WWa.setForceTileFlag(d.jVC);
    }
    AppMethodBeat.o(36331);
  }
  
  public static void aR(View paramView, int paramInt)
  {
    AppMethodBeat.i(36332);
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(36332);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, long paramLong)
  {
    this.JJO = paramInt1;
    this.WWc = paramInt2;
    this.WWd = paramInt3;
    this.fLi = paramString1;
    this.fileId = paramString2;
    this.createTime = paramLong;
  }
  
  public final void d(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(36337);
    Log.i("MicroMsg.ImageGalleryViewHolder", "%d switch video model isVideoPlay[%b] alpha[%f]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
    if (paramBoolean)
    {
      View localView = (View)hSL().WVL;
      localView.setAlpha(paramFloat);
      aR(localView, 0);
      if (paramFloat >= 1.0D)
      {
        aR(hSL().WVJ, 8);
        aR(hSL().WVK, 8);
      }
      AppMethodBeat.o(36337);
      return;
    }
    aR((View)hSL().WVL, 8);
    aR(hSL().WVJ, 0);
    aR(hSL().WVK, 0);
    AppMethodBeat.o(36337);
  }
  
  public final p hSI()
  {
    AppMethodBeat.i(36333);
    if (this.WVQ == null)
    {
      this.WVQ = ((LinearLayout)((ViewStub)this.convertView.findViewById(R.h.dII)).inflate());
      this.WVU = ((ProgressBar)this.WVQ.findViewById(R.h.downloading_pb));
      this.WVR = ((TextView)this.WVQ.findViewById(R.h.downloading_percent_tv));
      this.WVS = ((TextView)this.WVQ.findViewById(R.h.dFl));
      this.WVT = ((ImageView)this.WVQ.findViewById(R.h.dFm));
    }
    AppMethodBeat.o(36333);
    return this;
  }
  
  public final p hSJ()
  {
    AppMethodBeat.i(36334);
    if (this.WVW == null)
    {
      this.WVW = ((LinearLayout)((ViewStub)this.convertView.findViewById(R.h.dIH)).inflate());
      this.WVY = ((ImageView)this.WVW.findViewById(R.h.dFc));
      this.WVX = ((TextView)this.WVW.findViewById(R.h.dFd));
    }
    AppMethodBeat.o(36334);
    return this;
  }
  
  public final p hSK()
  {
    AppMethodBeat.i(36335);
    if (this.WVC == null)
    {
      this.WVC = ((RelativeLayout)((ViewStub)this.convertView.findViewById(R.h.dVj)).inflate());
      this.WVD = com.tencent.mm.pluginsdk.ui.tools.x.jH(this.convertView.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      this.WVC.addView((View)this.WVD, localLayoutParams);
      ((View)this.WVD).setVisibility(8);
      this.WVH = this.WVC.findViewById(R.h.tips_tv);
      this.WVH.setVisibility(8);
      this.wOf = ((TextView)this.WVC.findViewById(R.h.show_ad_sight));
      this.WVG = ((MMPinProgressBtn)this.WVC.findViewById(R.h.sight_downloading_pb));
      this.WVG.setVisibility(8);
      this.WVE = ((ImageView)this.WVC.findViewById(R.h.sight_image));
      this.WVF = ((ImageView)this.WVC.findViewById(R.h.videoplayer_icon));
      this.WVD.setVideoCallback(new k.a()
      {
        public final void eM(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int fE(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return 0;
        }
        
        public final void onCompletion()
        {
          AppMethodBeat.i(36320);
          p.this.WVD.start();
          p.this.WVH.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36318);
              if ((p.this.WVH == null) || (p.this.WVH.getVisibility() == 0))
              {
                AppMethodBeat.o(36318);
                return;
              }
              if ((p.this.WVH.getTag() != null) && ((p.this.WVH.getTag() instanceof w)))
              {
                w localw = (w)p.this.WVH.getTag();
                if ((localw.mhZ != null) && (!Util.isNullOrNil(localw.mhZ.lor)))
                {
                  p.this.WVH.setVisibility(8);
                  AppMethodBeat.o(36318);
                  return;
                }
                if ((localw.mhZ != null) && (!Util.isNullOrNil(localw.mhZ.lou)) && (!Util.isNullOrNil(localw.mhZ.lov)))
                {
                  p.this.WVH.setVisibility(8);
                  AppMethodBeat.o(36318);
                  return;
                }
              }
              p.this.WVH.setVisibility(0);
              p.this.WVH.startAnimation(AnimationUtils.loadAnimation(p.this.WVH.getContext(), R.a.fast_faded_in));
              AppMethodBeat.o(36318);
            }
          });
          AppMethodBeat.o(36320);
        }
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(36319);
          p.this.WVD.stop();
          final String str = (String)((View)p.this.WVD).getTag();
          CrashReportFactory.reportRawMessage(Base64.encodeToString((com.tencent.mm.plugin.sight.base.f.fIy() + "[ImageGallery] on play sight error, what=" + paramAnonymousInt1 + ", extra=" + paramAnonymousInt2 + ", path=" + Util.nullAs(str, "")).getBytes(), 2), "FullScreenPlaySight");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36317);
              if (Util.isNullOrNil(str))
              {
                com.tencent.mm.ui.base.h.p(p.this.WRu.WQV, R.l.video_file_play_faile, R.l.ewD);
                AppMethodBeat.o(36317);
                return;
              }
              Object localObject = new Intent();
              ((Intent)localObject).setAction("android.intent.action.VIEW");
              FileProviderHelper.setIntentDataAndType(p.this.WRu.WQV, (Intent)localObject, new q(str), "video/*", false);
              try
              {
                ImageGalleryUI localImageGalleryUI = p.this.WRu.WQV;
                localObject = Intent.createChooser((Intent)localObject, p.this.WRu.WQV.getContext().getString(R.l.favorite_video));
                localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(localImageGalleryUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                localImageGalleryUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(localImageGalleryUI, "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(36317);
                return;
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.ImageGalleryViewHolder", "startActivity fail, activity not found");
                com.tencent.mm.ui.base.h.p(p.this.WRu.WQV, R.l.favorite_no_match_msg, R.l.favorite_no_match_title);
                AppMethodBeat.o(36317);
              }
            }
          });
          p.this.WVB.put(str, Boolean.TRUE);
          AppMethodBeat.o(36319);
        }
        
        public final void qX() {}
      });
      this.wOf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(36322);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          w localw;
          eor localeor;
          Intent localIntent;
          int i;
          if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof ca)))
          {
            ca localca = (ca)paramAnonymousView.getTag();
            com.tencent.mm.ui.chatting.a.a(a.a.WvV, localca);
            localw = y.Yk(localca.field_imgPath);
            localeor = localw.mhZ;
            if ((localeor == null) || (ae.isNullOrNil(localeor.lor))) {
              break label507;
            }
            s.bqB();
            paramAnonymousView = com.tencent.mm.modelvideo.x.XU(localca.field_imgPath);
            localIntent = new Intent();
            localIntent.putExtra("KFromTimeLine", false);
            localIntent.putExtra("KStremVideoUrl", localeor.lor);
            localIntent.putExtra("KThumUrl", localeor.low);
            localIntent.putExtra("KThumbPath", paramAnonymousView);
            localIntent.putExtra("KMediaId", "fakeid_" + localca.field_msgId);
            localIntent.putExtra("KMediaVideoTime", localeor.SAk);
            localIntent.putExtra("KMediaTitle", localeor.lot);
            localIntent.putExtra("StreamWording", localeor.lou);
            localIntent.putExtra("StremWebUrl", localeor.lov);
            localObject = localca.field_talker;
            boolean bool = ab.Lj((String)localObject);
            if (!bool) {
              break label464;
            }
            paramAnonymousView = bq.RL(localca.field_content);
            localIntent.putExtra("KSta_StremVideoAduxInfo", localeor.lox);
            localIntent.putExtra("KSta_StremVideoPublishId", localeor.loy);
            localIntent.putExtra("KSta_SourceType", 1);
            if (!bool) {
              break label470;
            }
            i = a.b.Wwe.value;
            label322:
            localIntent.putExtra("KSta_Scene", i);
            localIntent.putExtra("KSta_FromUserName", paramAnonymousView);
            localIntent.putExtra("KSta_ChatName", (String)localObject);
            localIntent.putExtra("KSta_MsgId", localca.field_msgSvrId);
            localIntent.putExtra("KSta_SnsStatExtStr", localw.fUk);
            if (bool) {
              localIntent.putExtra("KSta_ChatroomMembercount", v.Pu((String)localObject));
            }
            if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuU, 0) <= 0) {
              break label480;
            }
            c.b(p.this.WRu.WQV.getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
            Log.i("MicroMsg.ImageGalleryViewHolder", "use new stream video play UI");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(36322);
            return;
            label464:
            paramAnonymousView = (View)localObject;
            break;
            label470:
            i = a.b.Wwd.value;
            break label322;
            label480:
            c.b(p.this.WRu.WQV.getContext(), "sns", ".ui.VideoAdPlayerUI", localIntent);
            continue;
            label507:
            if ((localeor != null) && (!Util.isNullOrNil(localeor.lou)) && (!Util.isNullOrNil(localeor.lov)))
            {
              Log.i("MicroMsg.ImageGalleryViewHolder", "moreBtn click,opening " + localeor.lov);
              paramAnonymousView = new Intent();
              localObject = new Bundle();
              ((Bundle)localObject).putString("key_snsad_statextstr", localw.fUk);
              paramAnonymousView.putExtra("jsapiargs", (Bundle)localObject);
              paramAnonymousView.putExtra("rawUrl", localeor.lov);
              paramAnonymousView.putExtra("useJs", true);
              new MMHandler(Looper.getMainLooper()).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(36321);
                  c.b(p.this.WRu.WQV.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                  AppMethodBeat.o(36321);
                }
              });
            }
          }
        }
      });
    }
    AppMethodBeat.o(36335);
    return this;
  }
  
  public final p hSL()
  {
    AppMethodBeat.i(36336);
    if (this.WVI == null)
    {
      if (this.WWa != null) {
        this.WWa.setVisibility(8);
      }
      if (this.WVZ != null) {
        this.WVZ.setVisibility(8);
      }
      this.WVI = ((RelativeLayout)((ViewStub)this.convertView.findViewById(R.h.video_root)).inflate());
      this.WVJ = ((ImageView)this.WVI.findViewById(R.h.video_image));
      this.WVK = ((ImageView)this.WVI.findViewById(R.h.video_wait_play_btn));
      this.WVK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(36323);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (p.this.WRu != null)
          {
            Log.i("MicroMsg.ImageGalleryViewHolder", "%d video wait play on click, play video %d", new Object[] { Integer.valueOf(p.this.hashCode()), Integer.valueOf(p.this.mPosition) });
            p.this.WRu.avV(p.this.mPosition);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36323);
        }
      });
      if (!o.isEnabled()) {
        break label291;
      }
      this.WVL = new ThumbPlayerVideoView(this.convertView.getContext());
    }
    for (;;)
    {
      this.WVN = ((TextView)this.convertView.findViewById(R.h.dDF));
      this.WVL.setPlayProgressCallback(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.WVI.addView((View)this.WVL, 1, localLayoutParams);
      this.WVM = ((MMPinProgressBtn)this.WVI.findViewById(R.h.dYM));
      this.WVM.setVisibility(8);
      ((View)this.WVL).setVisibility(8);
      this.WVO = ((RelativeLayout)this.convertView.findViewById(R.h.dYP));
      this.WVP = ((TextView)this.convertView.findViewById(R.h.dYQ));
      this.WVL.setVideoCallback(new k.a()
      {
        public final void eM(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int fE(final int paramAnonymousInt1, final int paramAnonymousInt2)
        {
          AppMethodBeat.i(36329);
          Log.i("MicroMsg.ImageGalleryViewHolder", "dkvideo onplaytime:%d total:%d,%d size:%d cnt:%d user:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(p.this.JJO), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(p.this.WWc), Integer.valueOf(p.this.WWd), p.this.fLi });
          bh.aHJ().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36325);
              com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
              int j = p.this.WWc;
              if (paramAnonymousInt2 <= 0) {}
              for (int i = p.this.JJO * 1000;; i = paramAnonymousInt2)
              {
                localh.a(12084, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(1), p.this.fLi, Integer.valueOf(p.this.WWd), p.this.fileId, Long.valueOf(p.this.createTime) });
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
          p.this.WRu.WQV.WTa.n(p.this.WRu.hRF(), 7);
          p.this.WRu.WQV.WTa.mfx = 4;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36324);
              p.this.WRu.WQV.setVideoStateIv(true);
              f localf = p.this.WRu;
              int i = p.this.mPosition;
              localf.WRb.avQ(i);
              p.this.WRu.WRb.hRC();
              AppMethodBeat.o(36324);
            }
          });
          AppMethodBeat.o(36328);
        }
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(36327);
          Log.w("MicroMsg.ImageGalleryViewHolder", "play video error what : " + paramAnonymousInt1 + " extra: " + paramAnonymousInt2);
          if (p.this.WRu != null) {
            p.this.WRu.WRb.cv(paramAnonymousInt1, paramAnonymousInt2);
          }
          p.this.WRu.WQV.WTa.mfx = 4;
          p.this.WRu.WQV.WTa.Quv = ("what : " + paramAnonymousInt1 + " extra: " + paramAnonymousInt2);
          com.tencent.mm.plugin.report.service.h.IzE.a(12084, new Object[] { Integer.valueOf(p.this.WWc), Integer.valueOf(p.this.JJO * 1000), Integer.valueOf(0), Integer.valueOf(4), p.this.fLi, Integer.valueOf(p.this.WWd), p.this.fileId, Long.valueOf(p.this.createTime) });
          AppMethodBeat.o(36327);
        }
        
        public final void qX()
        {
          AppMethodBeat.i(36326);
          if (p.this.WRu != null) {
            p.this.WRu.WRb.hRB();
          }
          AppMethodBeat.o(36326);
        }
      });
      AppMethodBeat.o(36336);
      return this;
      label291:
      com.tencent.mm.modelcontrol.e.bkp();
      if (com.tencent.mm.modelcontrol.e.bkB())
      {
        this.WVL = new VideoPlayerTextureView(this.convertView.getContext());
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 150L, 1L, false);
      }
      else
      {
        this.WVL = new VideoTextureView(this.convertView.getContext());
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 151L, 1L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.p
 * JD-Core Version:    0.7.0.1
 */