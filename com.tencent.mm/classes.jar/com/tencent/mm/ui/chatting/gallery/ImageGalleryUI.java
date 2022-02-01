package com.tencent.mm.ui.chatting.gallery;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.y;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.bd;
import com.tencent.mm.g.a.bd.b;
import com.tencent.mm.g.a.ib;
import com.tencent.mm.g.a.ib.b;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.mx.a;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qd.a;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qe.a;
import com.tencent.mm.g.a.qq;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.g.a.sp.a;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.g.a.sq.a;
import com.tencent.mm.g.b.a.ce;
import com.tencent.mm.g.b.a.cp;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.5;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.b;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.b;
import com.tencent.mm.ui.base.MMViewPager.c;
import com.tencent.mm.ui.base.MMViewPager.e;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.gallery.a.g.b;
import com.tencent.mm.ui.chatting.gallery.a.g.d;
import com.tencent.mm.ui.chatting.gallery.a.g.e;
import com.tencent.mm.ui.chatting.gallery.a.g.f;
import com.tencent.mm.ui.chatting.gallery.a.g.g;
import com.tencent.mm.ui.chatting.gallery.a.i.a;
import com.tencent.mm.ui.chatting.viewitems.af;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import d.g.b.p;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(3)
public class ImageGalleryUI
  extends MMActivity
  implements View.OnClickListener, a.a<String, com.tencent.mm.plugin.scanner.word.b>
{
  int Aai;
  int Aaj;
  int Aak;
  private float Aal;
  private int Aam;
  private int Aan;
  protected RedesignVideoPlayerSeekBar Bjp;
  private boolean Bjz;
  public com.tencent.mm.plugin.webview.ui.tools.media.e Eeo;
  public View Eof;
  private HashSet<Long> JHX;
  private boolean JMy;
  protected boolean JMz;
  public b JPj;
  private boolean JPt;
  private final boolean JPu;
  private n JQG;
  View JRA;
  Button JRB;
  Button JRC;
  View JRD;
  int JRE;
  int JRF;
  boolean JRG;
  ArrayList<Integer> JRH;
  private com.tencent.mm.ui.chatting.gallery.a.i JRI;
  private boolean JRJ;
  private com.tencent.mm.ui.chatting.gallery.a.g JRK;
  private com.tencent.mm.ui.chatting.gallery.a.c JRL;
  private boolean JRM;
  protected boolean JRN;
  protected boolean JRO;
  private boolean JRP;
  private int JRQ;
  private int JRR;
  private boolean JRS;
  private String JRT;
  private boolean JRU;
  private ScanCodeSheetItemLogic JRV;
  private cp JRW;
  private com.tencent.mm.ui.chatting.gallery.a.b JRX;
  private com.tencent.mm.ui.chatting.gallery.a.d JRY;
  private com.tencent.mm.ui.chatting.gallery.a.f JRZ;
  private b.b JRo;
  private RelativeLayout JRp;
  private boolean JRq;
  private boolean JRr;
  public f JRs;
  private View JRt;
  private View JRu;
  private View JRv;
  private View JRw;
  private View JRx;
  private View JRy;
  private View JRz;
  public a JSa;
  private View JSb;
  private CheckBox JSc;
  private View JSd;
  private boolean JSe;
  private int JSf;
  private boolean JSg;
  private boolean JSh;
  private ViewPager.OnPageChangeListener JSi;
  public TextView JSj;
  public View JSk;
  public ImageView JSl;
  boolean JSm;
  private HashMap<Long, String> JSn;
  private boolean JSo;
  private boolean JSp;
  int JxB;
  protected String chatroomName;
  private View contentView;
  public ImageView fRd;
  private ImageView iUP;
  private boolean isAnimated;
  private ap mHandler;
  public long msgId;
  private com.tencent.mm.ui.widget.a.e nHu;
  public long nYO;
  Bundle oGn;
  com.tencent.mm.ui.tools.e oGo;
  int oGp;
  int oGq;
  int oGr;
  int oGs;
  public TextView opA;
  public MMNeat7extView opB;
  private n.e pLV;
  private RelativeLayout rFc;
  com.tencent.mm.sdk.platformtools.av rFl;
  public View rPF;
  public boolean ruj;
  private com.tencent.mm.plugin.scanner.word.a ryT;
  private volatile int ryU;
  private int ryV;
  private ImageView ryX;
  private ImageView ryY;
  private ImageView ryZ;
  private ValueAnimator rza;
  private com.tencent.mm.sdk.b.c<sq> rzb;
  private com.tencent.mm.network.n rzc;
  protected MMViewPager tOn;
  protected String talker;
  private boolean vMm;
  
  public ImageGalleryUI()
  {
    AppMethodBeat.i(36149);
    this.Bjz = false;
    this.JRr = false;
    this.JRs = new f();
    this.Aak = 0;
    this.JRE = 0;
    this.JRF = 0;
    this.oGp = 0;
    this.oGq = 0;
    this.oGr = 0;
    this.oGs = 0;
    this.JRH = new ArrayList();
    this.JMy = false;
    this.ruj = false;
    this.JRI = new com.tencent.mm.ui.chatting.gallery.a.i();
    this.JRJ = false;
    this.JRL = new com.tencent.mm.ui.chatting.gallery.a.c();
    this.JRN = false;
    this.JMz = false;
    this.JRO = false;
    this.isAnimated = false;
    this.JPt = false;
    this.JRQ = -1;
    this.ryV = 0;
    this.JPu = false;
    this.JRT = null;
    this.JRW = new cp();
    this.JRX = new com.tencent.mm.ui.chatting.gallery.a.b();
    this.JRY = new com.tencent.mm.ui.chatting.gallery.a.d()
    {
      public final void b(qd paramAnonymousqd)
      {
        AppMethodBeat.i(194151);
        String str = com.tencent.mm.vfs.i.k(ImageGalleryUI.a(ImageGalleryUI.this), false);
        if ((str == null) || (!str.equals(paramAnonymousqd.dEG.filePath)))
        {
          ad.e("MicroMsg.ImageGalleryUI", "not same filepath");
          AppMethodBeat.o(194151);
          return;
        }
        ad.i("MicroMsg.ImageGalleryUI", "scanCode onFailed result: %s", new Object[] { paramAnonymousqd.dEG.result });
        ImageGalleryUI.c(ImageGalleryUI.this).updateStatus(2, false);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194149);
            ImageGalleryUI.this.fGe();
            AppMethodBeat.o(194149);
          }
        });
        AppMethodBeat.o(194151);
      }
      
      public final void b(qe paramAnonymousqe)
      {
        AppMethodBeat.i(194150);
        Object localObject = com.tencent.mm.vfs.i.k(ImageGalleryUI.a(ImageGalleryUI.this), false);
        if ((localObject == null) || (!((String)localObject).equals(paramAnonymousqe.dEH.filePath)))
        {
          ad.e("MicroMsg.ImageGalleryUI", "not same filepath");
          AppMethodBeat.o(194150);
          return;
        }
        ad.i("MicroMsg.ImageGalleryUI", "scanCode onSuccess result: %s, recognizeType: %d", new Object[] { paramAnonymousqe.dEH.result, Integer.valueOf(paramAnonymousqe.dEH.dEF) });
        if (!bt.isNullOrNil(paramAnonymousqe.dEH.result))
        {
          localObject = ImageGalleryUI.b(ImageGalleryUI.this);
          p.h(paramAnonymousqe, "event");
          ((com.tencent.mm.ui.chatting.gallery.a.i)localObject).ymV = paramAnonymousqe.dEH.result;
          ((com.tencent.mm.ui.chatting.gallery.a.i)localObject).dnt = paramAnonymousqe.dEH.dnt;
          ((com.tencent.mm.ui.chatting.gallery.a.i)localObject).dnu = paramAnonymousqe.dEH.dnu;
          i.a locala = new i.a();
          locala.JUP = new PointF(paramAnonymousqe.dEH.dEK / paramAnonymousqe.dEH.dEI, paramAnonymousqe.dEH.dEL / paramAnonymousqe.dEH.dEJ);
          locala.JUQ = paramAnonymousqe.dEH.dEI;
          locala.JUR = paramAnonymousqe.dEH.dEJ;
          ((com.tencent.mm.ui.chatting.gallery.a.i)localObject).JUM = locala;
          ad.d("MicroMsg.ImageGalleryUI", "scanCode onSuccess codePointInfo: %s", new Object[] { ImageGalleryUI.b(ImageGalleryUI.this).JUM });
          ImageGalleryUI.c(ImageGalleryUI.this).updateStatus(2, true);
          ImageGalleryUI.c(ImageGalleryUI.this).e(2, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(194148);
              if ((ImageGalleryUI.d(ImageGalleryUI.this) != null) && (ImageGalleryUI.d(ImageGalleryUI.this).isShowing()))
              {
                ImageGalleryUI.this.cXp();
                AppMethodBeat.o(194148);
                return;
              }
              ImageGalleryUI.this.fGe();
              AppMethodBeat.o(194148);
            }
          });
          if (2 == paramAnonymousqe.dEH.dEF) {
            ImageGalleryUI.e(ImageGalleryUI.this).bV(ImageGalleryUI.b(ImageGalleryUI.this).dnt, ImageGalleryUI.b(ImageGalleryUI.this).ymV);
          }
        }
        AppMethodBeat.o(194150);
      }
    };
    this.JRZ = new com.tencent.mm.ui.chatting.gallery.a.f()
    {
      public final void a(mx paramAnonymousmx)
      {
        int i = 1;
        AppMethodBeat.i(194152);
        ad.i("MicroMsg.ImageGalleryUI", "handleCode callback notifyEvent: %d", new Object[] { Integer.valueOf(paramAnonymousmx.dAR.dAP) });
        if (ImageGalleryUI.g(ImageGalleryUI.f(ImageGalleryUI.this)) != null) {
          ImageGalleryUI.g(ImageGalleryUI.f(ImageGalleryUI.this)).setOnClickListener(ImageGalleryUI.this);
        }
        if ((paramAnonymousmx.dAR.activity != ImageGalleryUI.this) || (!paramAnonymousmx.dAR.dlG.equals(ImageGalleryUI.b(ImageGalleryUI.this).ymV)))
        {
          ad.e("MicroMsg.ImageGalleryUI", "handleCode callback not the same");
          AppMethodBeat.o(194152);
          return;
        }
        switch (paramAnonymousmx.dAR.dAP)
        {
        default: 
          AppMethodBeat.o(194152);
          return;
        case 0: 
        case 1: 
        case 2: 
          ImageGalleryUI.h(ImageGalleryUI.this).adZ(2);
          ImageGalleryUI.gm(ImageGalleryUI.j(ImageGalleryUI.i(ImageGalleryUI.this)));
          AppMethodBeat.o(194152);
          return;
        }
        paramAnonymousmx = paramAnonymousmx.dAR.dAS;
        if (paramAnonymousmx != null) {}
        for (boolean bool = paramAnonymousmx.getBoolean("key_scan_qr_code_result", true);; bool = true)
        {
          paramAnonymousmx = ImageGalleryUI.h(ImageGalleryUI.this);
          if (bool) {}
          for (;;)
          {
            paramAnonymousmx.adZ(i);
            ImageGalleryUI.this.finish();
            break;
            i = 2;
          }
        }
      }
    };
    this.JQG = new n()
    {
      public final void b(View paramAnonymousView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(194167);
        if ((paramAnonymousView != null) && (paramAnonymousBitmap != null) && (!bt.isNullOrNil(paramAnonymousString)))
        {
          ad.i("MicroMsg.ImageGalleryUI", "alvinluo onImageLoaded imagePath: %s, bitmap: %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousBitmap.hashCode()) });
          ImageGalleryUI.a(ImageGalleryUI.this, paramAnonymousView, paramAnonymousString, paramAnonymousBitmap, ImageGalleryUI.k(ImageGalleryUI.this));
        }
        AppMethodBeat.o(194167);
      }
    };
    this.rzc = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(36144);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36143);
            if ((com.tencent.mm.kernel.g.aiU().aEN() != 6) && (com.tencent.mm.kernel.g.aiU().aEN() != 4))
            {
              if (ImageGalleryUI.l(ImageGalleryUI.this) == 1)
              {
                com.tencent.mm.ui.base.h.c(ImageGalleryUI.this, ImageGalleryUI.this.getString(2131755828), "", true);
                ImageGalleryUI.m(ImageGalleryUI.this);
                ImageGalleryUI.h(ImageGalleryUI.this).adZ(2);
                AppMethodBeat.o(36143);
              }
            }
            else
            {
              if (ImageGalleryUI.this.JPj == null)
              {
                AppMethodBeat.o(36143);
                return;
              }
              int i = ImageGalleryUI.this.getCurrentItem();
              bu localbu = ImageGalleryUI.this.JPj.ada(i);
              if ((localbu != null) && (localbu.cxg()))
              {
                if (ImageGalleryUI.this.JPj.fFM() == null) {
                  ImageGalleryUI.this.JPj.fFM().fGB();
                }
                if ((ImageGalleryUI.this.JPj.fFM().fGB().JTm.getVisibility() == 0) || (ImageGalleryUI.this.JPj.fFM().fGB().JTv.getVisibility() == 0)) {
                  ImageGalleryUI.this.JPj.adA(i);
                }
              }
            }
            AppMethodBeat.o(36143);
          }
        });
        AppMethodBeat.o(36144);
      }
    };
    this.JSe = true;
    this.Aal = 1.0F;
    this.Aam = 0;
    this.Aan = 0;
    this.pLV = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(194160);
        if ((ImageGalleryUI.this == null) || (ImageGalleryUI.this.isDestroyed()) || (ImageGalleryUI.this.isFinishing()))
        {
          ad.i("MicroMsg.ImageGalleryUI", "receive onMMMenuItemSelected but activity is invalid");
          AppMethodBeat.o(194160);
          return;
        }
        ad.i("MicroMsg.ImageGalleryUI", "curTransState %d", new Object[] { Integer.valueOf(ImageGalleryUI.l(ImageGalleryUI.this)) });
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(194160);
          return;
          paramAnonymousMenuItem = ImageGalleryUI.this.JPj.fFL();
          Object localObject;
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cxf()))
          {
            localObject = com.tencent.mm.modelvideo.u.Hy(paramAnonymousMenuItem.field_imgPath);
            if ((localObject != null) && (((s)localObject).status != 199) && (((s)localObject).status != 199))
            {
              ImageGalleryUI.b(ImageGalleryUI.this, com.tencent.mm.modelvideo.u.f(paramAnonymousMenuItem.field_msgId, 1));
              ImageGalleryUI.this.JPj.adB(ImageGalleryUI.this.tOn.getCurrentItem());
            }
          }
          for (;;)
          {
            if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cxg()))
            {
              localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.EnZ;
              com.tencent.mm.plugin.webview.ui.tools.media.a.aE(1, ImageGalleryUI.G(ImageGalleryUI.this), ImageGalleryUI.H(ImageGalleryUI.this));
              paramAnonymousMenuItem = j.cr(paramAnonymousMenuItem);
              if (paramAnonymousMenuItem != null)
              {
                localObject = com.tencent.mm.plugin.webview.ui.tools.media.h.Epa;
                com.tencent.mm.plugin.webview.ui.tools.media.h.a.i(1, paramAnonymousMenuItem.FCc, paramAnonymousMenuItem.FCb, ImageGalleryUI.this.JRs.oog);
              }
            }
            AppMethodBeat.o(194160);
            return;
            ImageGalleryUI.this.JPj.adw(ImageGalleryUI.this.tOn.getCurrentItem());
            continue;
            ImageGalleryUI.this.JPj.adw(ImageGalleryUI.this.tOn.getCurrentItem());
          }
          paramAnonymousMenuItem = ImageGalleryUI.this.JPj.fFL();
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cxg()))
          {
            localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.EnZ;
            com.tencent.mm.plugin.webview.ui.tools.media.a.aE(4, ImageGalleryUI.G(ImageGalleryUI.this), ImageGalleryUI.H(ImageGalleryUI.this));
            paramAnonymousMenuItem = j.cr(paramAnonymousMenuItem);
            if (paramAnonymousMenuItem != null) {
              ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramAnonymousMenuItem, ImageGalleryUI.this, ImageGalleryUI.this.JRs.oog);
            }
            AppMethodBeat.o(194160);
            return;
            paramAnonymousMenuItem = ImageGalleryUI.this.JPj.fFL();
            if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cxf()))
            {
              localObject = com.tencent.mm.modelvideo.u.Hy(paramAnonymousMenuItem.field_imgPath);
              if ((localObject != null) && (((s)localObject).status != 199) && (((s)localObject).status != 199))
              {
                ImageGalleryUI.b(ImageGalleryUI.this, com.tencent.mm.modelvideo.u.f(paramAnonymousMenuItem.field_msgId, 2));
                ImageGalleryUI.this.JPj.adB(ImageGalleryUI.this.tOn.getCurrentItem());
                AppMethodBeat.o(194160);
                return;
              }
              paramAnonymousMenuItem = new ArrayList();
              paramAnonymousMenuItem.add(ImageGalleryUI.this.JPj.fFL());
              b.f(ImageGalleryUI.this.getContext(), paramAnonymousMenuItem);
              AppMethodBeat.o(194160);
              return;
            }
            paramAnonymousMenuItem = new ArrayList();
            paramAnonymousMenuItem.add(ImageGalleryUI.this.JPj.fFL());
            com.tencent.mm.modelstat.b.inZ.W((bu)paramAnonymousMenuItem.get(0));
            b.f(ImageGalleryUI.this.getContext(), paramAnonymousMenuItem);
            AppMethodBeat.o(194160);
            return;
            ImageGalleryUI.this.JPj.adx(ImageGalleryUI.this.tOn.getCurrentItem());
            AppMethodBeat.o(194160);
            return;
            if (com.tencent.mm.bs.d.aIu("favorite"))
            {
              ImageGalleryUI.this.JPj.ady(ImageGalleryUI.this.tOn.getCurrentItem());
              paramAnonymousMenuItem = ImageGalleryUI.this.JPj.fFL();
              if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cxg()))
              {
                paramAnonymousMenuItem = com.tencent.mm.plugin.webview.ui.tools.media.a.EnZ;
                com.tencent.mm.plugin.webview.ui.tools.media.a.aE(2, ImageGalleryUI.G(ImageGalleryUI.this), ImageGalleryUI.H(ImageGalleryUI.this));
              }
              AppMethodBeat.o(194160);
              return;
              ImageGalleryUI.J(ImageGalleryUI.this);
              AppMethodBeat.o(194160);
              return;
              if (ImageGalleryUI.this.JPj != null)
              {
                if (b.j(ImageGalleryUI.this.JPj.fFL())) {
                  ImageGalleryUI.K(ImageGalleryUI.this);
                }
                AppMethodBeat.o(194160);
                return;
                ImageGalleryUI.L(ImageGalleryUI.this);
                AppMethodBeat.o(194160);
                return;
                ad.i("MicroMsg.ImageGalleryUI", "request deal QBAR string");
                if ((ImageGalleryUI.d(ImageGalleryUI.this) != null) && (ImageGalleryUI.d(ImageGalleryUI.this).isShowing())) {
                  ImageGalleryUI.d(ImageGalleryUI.this).bpT();
                }
                paramAnonymousMenuItem = bt.x("%d,%d", new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
                ad.i("MicroMsg.ImageGalleryUI", "18684 report:".concat(String.valueOf(paramAnonymousMenuItem)));
                com.tencent.mm.plugin.report.service.g.yhR.kvStat(18684, paramAnonymousMenuItem);
                ImageGalleryUI.I(ImageGalleryUI.this);
                AppMethodBeat.o(194160);
                return;
                paramAnonymousMenuItem = new com.tencent.mm.plugin.websearch.api.o();
                paramAnonymousMenuItem.context = ImageGalleryUI.this;
                paramAnonymousMenuItem.dBd = ImageGalleryUI.this.JPj.fFL();
                paramAnonymousMenuItem.dnM = 2;
                ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(paramAnonymousMenuItem);
              }
            }
          }
        }
      }
    };
    this.rzb = new com.tencent.mm.sdk.b.c() {};
    this.JSf = 0;
    this.JSg = false;
    this.JSh = true;
    this.JSi = new ViewPager.OnPageChangeListener()
    {
      private boolean JSx = false;
      
      public final void onPageScrollStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(194166);
        ad.d("MicroMsg.ImageGalleryUI", "onPageScrollStateChanged: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 2) {
          ImageGalleryUI.c(ImageGalleryUI.this, true);
        }
        if (paramAnonymousInt == 0)
        {
          this.JSx = false;
          if (ImageGalleryUI.T(ImageGalleryUI.this)) {
            ImageGalleryUI.this.fGe();
          }
          ImageGalleryUI.c(ImageGalleryUI.this, false);
        }
        if (ImageGalleryUI.this.JPj != null)
        {
          Object localObject = ImageGalleryUI.this.JPj;
          if (((b)localObject).JPp != null)
          {
            localObject = ((b)localObject).JPp;
            ((d)localObject).mScrollState = paramAnonymousInt;
            if (((d)localObject).JQH != null) {
              ((d)localObject).JQH.onPageScrollStateChanged(paramAnonymousInt);
            }
          }
        }
        AppMethodBeat.o(194166);
      }
      
      public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        AppMethodBeat.i(194165);
        ad.v("MicroMsg.ImageGalleryUI", "position: %d, positionOffset: %f, positionOffsetPixels: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Float.valueOf(paramAnonymousFloat), Integer.valueOf(paramAnonymousInt2) });
        if ((!this.JSx) && (paramAnonymousInt2 > 0)) {
          this.JSx = true;
        }
        AppMethodBeat.o(194165);
      }
      
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(194164);
        if (ImageGalleryUI.this.JPj == null)
        {
          AppMethodBeat.o(194164);
          return;
        }
        if (ImageGalleryUI.M(ImageGalleryUI.this) != paramAnonymousInt)
        {
          if ((ImageGalleryUI.d(ImageGalleryUI.this) != null) && (ImageGalleryUI.d(ImageGalleryUI.this).isShowing())) {
            ImageGalleryUI.d(ImageGalleryUI.this).bpT();
          }
          if (!ImageGalleryUI.N(ImageGalleryUI.this))
          {
            ImageGalleryUI.O(ImageGalleryUI.this);
            ImageGalleryUI.h(ImageGalleryUI.this).adV(2);
          }
          ImageGalleryUI.P(ImageGalleryUI.this);
          ImageGalleryUI.a(ImageGalleryUI.this, false);
          ImageGalleryUI.Q(ImageGalleryUI.this);
          if (ImageGalleryUI.l(ImageGalleryUI.this) == 1) {
            ImageGalleryUI.m(ImageGalleryUI.this);
          }
          ImageGalleryUI.R(ImageGalleryUI.this);
          ImageGalleryUI.o(ImageGalleryUI.this);
        }
        if (ImageGalleryUI.this.JPj.SJ(paramAnonymousInt) == null) {
          ad.e("MicroMsg.ImageGalleryUI", "onPageSelected the view is null, position = %s ", new Object[] { Integer.valueOf(paramAnonymousInt) });
        }
        ImageGalleryUI.y(ImageGalleryUI.this);
        ImageGalleryUI.c(ImageGalleryUI.this, ImageGalleryUI.M(ImageGalleryUI.this));
        ImageGalleryUI.this.JRs.a(ImageGalleryUI.this, ImageGalleryUI.M(ImageGalleryUI.this), paramAnonymousInt);
        ImageGalleryUI.d(ImageGalleryUI.this, paramAnonymousInt);
        Object localObject1;
        Object localObject2;
        int i;
        boolean bool;
        label447:
        long l;
        if (ImageGalleryUI.this.JPj != null)
        {
          localObject1 = ImageGalleryUI.this.JPj;
          ((b)localObject1).JPq.OC();
          ((b)localObject1).JPr.OC();
          localObject1 = ImageGalleryUI.this.JPj.ada(paramAnonymousInt);
          if (localObject1 != null)
          {
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ZT(((ei)localObject1).field_talker);
            ImageGalleryUI.a(ImageGalleryUI.this, b.cb((bu)localObject1));
          }
          if ((b.j((bu)localObject1)) || (b.bZ((bu)localObject1)))
          {
            localObject2 = ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.JPj, ImageGalleryUI.this.tOn);
            if ((localObject2 != null) && ((localObject2 instanceof com.tencent.mm.ui.base.g)))
            {
              if (!(localObject2 instanceof MultiTouchImageView)) {
                break label781;
              }
              ((MultiTouchImageView)localObject2).fyy();
            }
            String str = ImageGalleryUI.a(ImageGalleryUI.this);
            i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("EnableSessionPicTranslation", 0);
            Object localObject3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("PicTranslationSupportUserLanguage");
            if (i != 1) {
              break label803;
            }
            bool = true;
            ad.i("MicroMsg.ScannerHelper", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool), localObject3, ac.fks() });
            if ((i != 1) || (bt.isNullOrNil((String)localObject3))) {
              break label809;
            }
            localObject3 = ((String)localObject3).split(";");
            if ((localObject3 == null) || (!Arrays.asList((Object[])localObject3).contains(ac.fks()))) {
              break label809;
            }
            i = 1;
            label525:
            if (i != 0)
            {
              if (ImageGalleryUI.S(ImageGalleryUI.this) == null) {
                ImageGalleryUI.a(ImageGalleryUI.this, new ImageWordScanDetailEngine(ImageGalleryUI.this));
              }
              if (!bt.isNullOrNil(str)) {
                ImageGalleryUI.S(ImageGalleryUI.this).a(str, ImageGalleryUI.this);
              }
            }
            ImageGalleryUI.a(ImageGalleryUI.this, (View)localObject2, com.tencent.mm.vfs.i.k(str, false), null, ImageGalleryUI.k(ImageGalleryUI.this));
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ai((bu)localObject1);
          }
          if (localObject1 != null) {
            ImageGalleryUI.this.Ek(((ei)localObject1).field_msgId);
          }
          if (ImageGalleryUI.this.JPj == null) {
            break label831;
          }
          localObject2 = ImageGalleryUI.this.JPj.g((bu)localObject1, false);
          if (!b.b((bu)localObject1, (com.tencent.mm.aw.g)localObject2)) {
            break label839;
          }
          localObject1 = com.tencent.mm.aw.h.a((com.tencent.mm.aw.g)localObject2);
          i = ((com.tencent.mm.aw.g)localObject1).hMP;
          int j = ((com.tencent.mm.aw.g)localObject1).offset;
          if (i == 0) {
            break label825;
          }
          l = j * 100L / i - 1L;
          label710:
          i = Math.max(1, (int)l);
          ad.d("MicroMsg.ImageGalleryUI", "jacks loading hd from imgInfo : %d, time: %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()) });
          ImageGalleryUI.this.adQ(i);
        }
        for (;;)
        {
          if (ImageGalleryUI.this.JPj != null) {
            ImageGalleryUI.this.JPj.onPageSelected(paramAnonymousInt);
          }
          AppMethodBeat.o(194164);
          return;
          label781:
          if (!(localObject2 instanceof WxImageView)) {
            break;
          }
          ((WxImageView)localObject2).fyy();
          break;
          label803:
          bool = false;
          break label447;
          label809:
          if (com.tencent.mm.protocal.d.Fnn)
          {
            i = 1;
            break label525;
          }
          i = 0;
          break label525;
          label825:
          l = 0L;
          break label710;
          label831:
          ad.e("MicroMsg.ImageGalleryUI", "[arthurdan.ImageGallery] Notice!!! adapter is null");
          label839:
          if (localObject1 == null)
          {
            ad.e("MicroMsg.ImageGalleryUI", "update footer fail, msg is null, position = ".concat(String.valueOf(paramAnonymousInt)));
          }
          else
          {
            ImageGalleryUI.this.cp((bu)localObject1);
            ImageGalleryUI.this.fGe();
          }
        }
      }
    };
    this.Eof = null;
    this.JSm = false;
    this.rFl = new com.tencent.mm.sdk.platformtools.av(new com.tencent.mm.sdk.platformtools.av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(194171);
        if (ImageGalleryUI.U(ImageGalleryUI.this)) {
          ImageGalleryUI.this.fGf();
        }
        AppMethodBeat.o(194171);
        return false;
      }
    }, false);
    this.JSn = new HashMap();
    this.JSo = false;
    this.JSp = false;
    this.mHandler = new ap(Looper.getMainLooper());
    this.JHX = new HashSet();
    AppMethodBeat.o(36149);
  }
  
  private static String Ei(long paramLong)
  {
    AppMethodBeat.i(36188);
    if (paramLong < 0L)
    {
      AppMethodBeat.o(36188);
      return "";
    }
    Object localObject = new BigDecimal(paramLong);
    float f = ((BigDecimal)localObject).divide(new BigDecimal(1048576), 2, 0).floatValue();
    if (f > 1.0F)
    {
      localObject = (int)f + "M";
      AppMethodBeat.o(36188);
      return localObject;
    }
    f = ((BigDecimal)localObject).divide(new BigDecimal(1024), 2, 0).floatValue();
    localObject = (int)f + "K";
    AppMethodBeat.o(36188);
    return localObject;
  }
  
  private View a(b paramb, MMViewPager paramMMViewPager)
  {
    AppMethodBeat.i(36164);
    boolean bool1;
    if (paramb == null)
    {
      bool1 = true;
      if (paramMMViewPager != null) {
        break label75;
      }
    }
    label75:
    for (boolean bool2 = true;; bool2 = false)
    {
      ad.d("MicroMsg.ImageGalleryUI", "get current view adapter is null %b, gallery is null %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((paramb == null) || (paramMMViewPager == null)) {
        break label182;
      }
      if (paramb.fFL() != null) {
        break label81;
      }
      AppMethodBeat.o(36164);
      return null;
      bool1 = false;
      break;
    }
    label81:
    Object localObject;
    if ((paramb.fFL().fpi()) || (paramb.fFL().frK()))
    {
      MultiTouchImageView localMultiTouchImageView = paramb.Hq(paramMMViewPager.getCurrentItem());
      localObject = localMultiTouchImageView;
      if (localMultiTouchImageView == null) {
        localObject = paramb.Hr(paramMMViewPager.getCurrentItem());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(36164);
      return localObject;
      if ((paramb.fFL().cxf()) || (paramb.fFL().cxh()) || (paramb.fFL().cxg()))
      {
        localObject = paramb.adz(paramMMViewPager.getCurrentItem());
        continue;
        label182:
        ad.w("MicroMsg.ImageGalleryUI", "%d get current view but adapter or gallery is null", new Object[] { Integer.valueOf(hashCode()) });
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  private void a(View paramView, String paramString, Bitmap paramBitmap, int paramInt, com.tencent.mm.ui.chatting.gallery.a.d paramd)
  {
    AppMethodBeat.i(194187);
    if (this.JRK != null) {
      if (paramInt == 1)
      {
        if (this.JRJ)
        {
          this.JRK.a(paramView, paramString, paramBitmap, true, paramInt, paramd);
          AppMethodBeat.o(194187);
        }
      }
      else {
        this.JRK.a(paramView, paramString, paramBitmap, false, paramInt, paramd);
      }
    }
    AppMethodBeat.o(194187);
  }
  
  private static void aG(View paramView, int paramInt)
  {
    AppMethodBeat.i(36156);
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(36156);
  }
  
  private boolean aWr(String paramString)
  {
    AppMethodBeat.i(36169);
    if (this.JRR == 1)
    {
      AppMethodBeat.o(36169);
      return false;
    }
    if ((this.JRI == null) || (bt.isNullOrNil(this.JRI.ymV)))
    {
      AppMethodBeat.o(36169);
      return false;
    }
    if (!this.JRP)
    {
      AppMethodBeat.o(36169);
      return true;
    }
    String[] arrayOfString = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IvU, "")).split("\\|");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((!bt.isNullOrNil(str)) && (paramString.startsWith(str)))
        {
          ad.i("MicroMsg.ImageGalleryUI", "curDealQBarStr:%s, blockQrcodeStr:%s", new Object[] { paramString, str });
          AppMethodBeat.o(36169);
          return false;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(36169);
    return true;
  }
  
  private void aWs(String paramString)
  {
    AppMethodBeat.i(36213);
    paramString = RecordConfigProvider.iI(paramString, "");
    paramString.scene = this.JRR;
    Object localObject = new UICustomParam.a();
    ((UICustomParam.a)localObject).aby();
    ((UICustomParam.a)localObject).abx();
    ((UICustomParam.a)localObject).cP(true);
    paramString.xyk = ((UICustomParam.a)localObject).gei;
    localObject = com.tencent.mm.plugin.recordvideo.jumper.a.xyI;
    com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4369, 2130772137, -1, paramString, 1, 2);
    AppMethodBeat.o(36213);
  }
  
  private void adM(int paramInt)
  {
    AppMethodBeat.i(36181);
    bu localbu = this.JPj.ada(paramInt);
    if ((localbu == null) || (!localbu.cxg()) || (this.JPt))
    {
      AppMethodBeat.o(36181);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(new i.c(localbu.field_talker, "update", localbu));
    AppMethodBeat.o(36181);
  }
  
  private void adN(int paramInt)
  {
    AppMethodBeat.i(36189);
    ad.i("MicroMsg.ImageGalleryUI", "enterGrid source : ".concat(String.valueOf(paramInt)));
    if (this.JPj == null)
    {
      ad.w("MicroMsg.ImageGalleryUI", "try to enterGrid, but adapter is NULL");
      AppMethodBeat.o(36189);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(219L, 13L, 1L, true);
    int i = this.JPj.getRealCount();
    if (this.JPj.fFL() == null)
    {
      ad.e("MicroMsg.ImageGalleryUI", "msgInfo is null");
      AppMethodBeat.o(36189);
      return;
    }
    int j = this.JPj.JPl.adF(this.tOn.getCurrentItem());
    if (!this.JRN)
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), MediaHistoryGalleryUI.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("kintent_intent_source", paramInt);
      ((Intent)localObject).putExtra("kintent_talker", fGc());
      ((Intent)localObject).putExtra("kintent_image_count", i);
      ((Intent)localObject).putExtra("kintent_image_index", j);
      ((Intent)localObject).putExtra("key_biz_chat_id", this.nYO);
      ((Intent)localObject).putExtra("key_is_biz_chat", this.ruj);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "enterGrid", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "enterGrid", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194172);
          ImageGalleryUI.this.finish();
          AppMethodBeat.o(194172);
        }
      }, 50L);
      AppMethodBeat.o(36189);
      return;
    }
    bWL();
    AppMethodBeat.o(36189);
  }
  
  static Animation adP(int paramInt)
  {
    AppMethodBeat.i(36199);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(paramInt);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator(10.0F));
    AppMethodBeat.o(36199);
    return localAlphaAnimation;
  }
  
  private void adR(int paramInt)
  {
    AppMethodBeat.i(36209);
    if (this.Eof != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Eof.getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, paramInt, 0);
      this.Eof.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(36209);
  }
  
  private void bWL()
  {
    AppMethodBeat.i(36165);
    if ((this.Bjz) || (this.JPj == null))
    {
      ad.i("MicroMsg.ImageGalleryUI", "isRunningExitAnimation");
      AppMethodBeat.o(36165);
      return;
    }
    ye(true);
    if (this.JRq)
    {
      finish();
      com.tencent.mm.ui.base.b.kd(getContext());
      AppMethodBeat.o(36165);
      return;
    }
    ad.i("MicroMsg.ImageGalleryUI", "runExitAnimation");
    int k = this.tOn.getWidth() / 2;
    int j = this.tOn.getHeight() / 2;
    this.JPj.fFK();
    Object localObject1;
    int m;
    int i;
    int n;
    if (!fAn())
    {
      if (this.JRN)
      {
        localObject1 = new ib();
        ((ib)localObject1).duA.msgId = this.JPj.ada(this.tOn.getCurrentItem()).field_msgId;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
        m = ((ib)localObject1).duB.dmb;
        i = ((ib)localObject1).duB.dmc;
        k = ((ib)localObject1).duB.dlZ;
        j = ((ib)localObject1).duB.dma;
        this.Aai = this.tOn.getWidth();
        this.Aaj = this.tOn.getHeight();
        n = i;
        if (this.JPj.fFL() != null)
        {
          if ((this.JPj.fFL().cxh()) || (this.JPj.fFL().cxf()) || (this.JPj.fFL().cxg())) {
            this.Aaj = ((int)(this.Aai / m * i));
          }
          if (!this.JPj.fFL().fpi())
          {
            n = i;
            if (!this.JPj.fFL().frK()) {}
          }
          else
          {
            localObject1 = (com.tencent.mm.ui.base.g)a(this.JPj, this.tOn);
            n = i;
            if (localObject1 != null)
            {
              float f = this.Aai / ((com.tencent.mm.ui.base.g)localObject1).getImageWidth();
              this.Aaj = ((int)(((com.tencent.mm.ui.base.g)localObject1).getImageHeight() * f));
              n = i;
              if (this.Aaj > this.tOn.getHeight())
              {
                n = i;
                if (this.Aaj < this.tOn.getHeight() * 1.5D)
                {
                  if (!this.JRN) {
                    break label881;
                  }
                  this.Aak = (this.Aaj - this.tOn.getHeight());
                  n = i;
                }
                label440:
                this.Aaj = this.tOn.getHeight();
              }
            }
          }
        }
        this.oGo.ka(this.JRE, this.JRF);
        this.oGo.KIp = this.Aak;
        this.oGo.jZ(this.Aai, this.Aaj);
        this.oGo.R(k, j, m, n);
        localObject1 = this.tOn;
        localObject2 = a(this.JPj, this.tOn);
        if (localObject2 == null) {
          break label900;
        }
        localObject1 = localObject2;
        if (this.Aal != 1.0D)
        {
          this.oGo.KIl = (1.0F / this.Aal);
          if (this.Aam == 0)
          {
            localObject1 = localObject2;
            if (this.Aan == 0) {}
          }
          else
          {
            i = (int)(this.tOn.getWidth() / 2 * (1.0F - this.Aal));
            j = this.Aam;
            k = (int)(this.tOn.getHeight() / 2 + this.Aan - this.Aaj / 2 * this.Aal);
            this.oGo.kb(i + j, k);
            localObject1 = localObject2;
          }
        }
        label647:
        if (this.JSm) {
          fGg();
        }
        this.oGo.a((View)localObject1, this.iUP, new e.c()
        {
          public final void onAnimationEnd()
          {
            AppMethodBeat.i(36118);
            ad.i("MicroMsg.ImageGalleryUI", "runExitAnimation onAnimationEnd");
            ImageGalleryUI.x(ImageGalleryUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36116);
                ImageGalleryUI.this.finish();
                ImageGalleryUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.o(36116);
              }
            });
            ImageGalleryUI.b(ImageGalleryUI.this, false);
            AppMethodBeat.o(36118);
          }
          
          public final void onAnimationStart()
          {
            AppMethodBeat.i(36117);
            ImageGalleryUI.b(ImageGalleryUI.this, true);
            new ap().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36115);
                View localView = ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.JPj, ImageGalleryUI.this.tOn);
                if ((localView != null) && ((localView instanceof com.tencent.mm.ui.base.g)))
                {
                  if ((localView instanceof MultiTouchImageView))
                  {
                    ((MultiTouchImageView)localView).fyy();
                    AppMethodBeat.o(36115);
                    return;
                  }
                  if ((localView instanceof WxImageView)) {
                    ((WxImageView)localView).fyy();
                  }
                }
                AppMethodBeat.o(36115);
              }
            }, 20L);
            AppMethodBeat.o(36117);
          }
        }, null);
        AppMethodBeat.o(36165);
        return;
      }
      localObject1 = this.JPj.ada(this.tOn.getCurrentItem());
      if (localObject1 == null) {
        break label903;
      }
      Object localObject2 = new bd();
      ((bd)localObject2).dlX.dku = ((bu)localObject1);
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
      m = ((bd)localObject2).dlY.dmb;
      i = ((bd)localObject2).dlY.dmc;
      k = ((bd)localObject2).dlY.dlZ;
      j = ((bd)localObject2).dlY.dma;
    }
    for (;;)
    {
      if ((k == 0) && (j == 0))
      {
        k = this.tOn.getWidth() / 2;
        j = this.tOn.getHeight() / 2;
        break;
      }
      if (localObject1 != null)
      {
        if (((ei)localObject1).field_isSend == 0) {
          this.JRE = com.tencent.mm.cc.a.fromDPToPix(getContext(), 5);
        }
        if (((ei)localObject1).field_isSend == 1) {
          this.JRF = com.tencent.mm.cc.a.fromDPToPix(getContext(), 5);
        }
      }
      break;
      m = this.oGr;
      i = this.oGs;
      k = this.oGq;
      j = this.oGp;
      break;
      label881:
      n = this.tOn.getHeight() * i / this.Aaj;
      break label440;
      label900:
      break label647;
      label903:
      i = 0;
      m = 0;
    }
  }
  
  private boolean bj(Activity paramActivity)
  {
    AppMethodBeat.i(36211);
    paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
    int j = paramActivity.getWidth();
    int k = paramActivity.getHeight();
    if (j < k) {}
    for (int i = 1;; i = 0)
    {
      ad.d("MicroMsg.ImageGalleryUI", "%d is vertical screen orient %d [%d, %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(36211);
      return false;
    }
    AppMethodBeat.o(36211);
    return true;
  }
  
  private void cwE()
  {
    AppMethodBeat.i(36171);
    this.rza.setRepeatMode(1);
    this.rza.setRepeatCount(0);
    this.rza.end();
    AppMethodBeat.o(36171);
  }
  
  private String cwq()
  {
    AppMethodBeat.i(36166);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    bu localbu;
    if (this.JPj != null)
    {
      localbu = this.JPj.ada(this.JSf);
      if (!b.j(localbu)) {
        break label74;
      }
      com.tencent.mm.aw.g localg = this.JPj.g(localbu, true);
      localObject1 = localObject2;
      if (localg != null) {
        localObject1 = d.a(localbu, localg);
      }
    }
    for (;;)
    {
      localObject1 = bt.nullAsNil((String)localObject1);
      AppMethodBeat.o(36166);
      return localObject1;
      label74:
      localObject1 = localObject2;
      if (b.bZ(localbu)) {
        localObject1 = b.l(localbu);
      }
    }
  }
  
  private void cxs()
  {
    AppMethodBeat.i(36183);
    ad.i("MicroMsg.ImageGalleryUI", "show video tool bar");
    yg(true);
    aG(this.JRA, 4);
    aG(fFW().Bjp, 0);
    aG(this.JRt, 0);
    if (this.JRq) {
      fGf();
    }
    if (this.JPj != null)
    {
      bu localbu = this.JPj.fFL();
      if ((localbu != null) && (localbu.cxg())) {
        aG(this.Eof, 0);
      }
    }
    AppMethodBeat.o(36183);
  }
  
  private void eUV()
  {
    boolean bool = true;
    AppMethodBeat.i(36196);
    if (this.JRp.getVisibility() == 0) {}
    for (;;)
    {
      ad.d("MicroMsg.ImageGalleryUI", "fadeOutOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      Animation localAnimation = adP(150);
      localAnimation.setFillAfter(false);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(194174);
          if (!ImageGalleryUI.U(ImageGalleryUI.this)) {
            ImageGalleryUI.this.fGg();
          }
          AppMethodBeat.o(194174);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.JRp.clearAnimation();
      this.JRp.startAnimation(localAnimation);
      AppMethodBeat.o(36196);
      return;
      bool = false;
    }
  }
  
  private void eUX()
  {
    AppMethodBeat.i(36207);
    View localView = getWindow().getDecorView();
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new ImageGalleryUI.31(this, localView));
    AppMethodBeat.o(36207);
  }
  
  private void eUY()
  {
    AppMethodBeat.i(36208);
    View localView = getWindow().getDecorView();
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new ImageGalleryUI.32(this, localView));
    AppMethodBeat.o(36208);
  }
  
  private static boolean f(bu parambu, com.tencent.mm.aw.g paramg)
  {
    AppMethodBeat.i(36179);
    if (paramg == null)
    {
      AppMethodBeat.o(36179);
      return false;
    }
    try
    {
      if ((b.c(parambu, paramg) == 0) && (paramg.aIj()))
      {
        boolean bool = parambu.frT();
        if (!bool)
        {
          AppMethodBeat.o(36179);
          return true;
        }
      }
    }
    catch (NullPointerException parambu)
    {
      ad.e("MicroMsg.ImageGalleryUI", "error:".concat(String.valueOf(parambu)));
      AppMethodBeat.o(36179);
    }
    return false;
  }
  
  private boolean fAn()
  {
    return this.JxB == 1;
  }
  
  private ImageGalleryUI fFX()
  {
    AppMethodBeat.i(36154);
    if (this.JRu == null) {
      this.JRu = findViewById(2131299498);
    }
    AppMethodBeat.o(36154);
    return this;
  }
  
  private ImageGalleryUI fFY()
  {
    AppMethodBeat.i(36155);
    if (this.JRw == null) {
      this.JRw = findViewById(2131299194);
    }
    AppMethodBeat.o(36155);
    return this;
  }
  
  private ImageGalleryUI fFZ()
  {
    AppMethodBeat.i(194181);
    if (this.JRy == null) {
      this.JRy = findViewById(2131308314);
    }
    AppMethodBeat.o(194181);
    return this;
  }
  
  private ImageGalleryUI fGa()
  {
    AppMethodBeat.i(194182);
    if (this.JRz == null) {
      this.JRz = findViewById(2131304331);
    }
    AppMethodBeat.o(194182);
    return this;
  }
  
  private void fGb()
  {
    int i = 2;
    AppMethodBeat.i(194183);
    boolean bool1 = this.JRL.aea(1);
    boolean bool2 = this.JRL.aea(2);
    if ((bool1) && (bool2)) {
      i = 4;
    }
    for (;;)
    {
      this.JRX.adX(i);
      AppMethodBeat.o(194183);
      return;
      if (bool1) {
        i = 3;
      } else if (!bool2) {
        i = 1;
      }
    }
  }
  
  private String fGc()
  {
    AppMethodBeat.i(36162);
    if ((this.chatroomName != null) && (this.chatroomName.length() > 0))
    {
      str = this.chatroomName;
      AppMethodBeat.o(36162);
      return str;
    }
    String str = this.talker;
    AppMethodBeat.o(36162);
    return str;
  }
  
  private boolean fGd()
  {
    AppMethodBeat.i(36168);
    if (this.JRP)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if (this.JRR == 1)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if (this.JPt)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if ((!this.JMy) && (!this.ruj) && (!h.a.fFU().rCy))
    {
      AppMethodBeat.o(36168);
      return true;
    }
    AppMethodBeat.o(36168);
    return false;
  }
  
  private void fGh()
  {
    AppMethodBeat.i(194188);
    if (!this.JRJ)
    {
      AppMethodBeat.o(194188);
      return;
    }
    boolean bool2 = fAn();
    boolean bool3 = this.JRL.la(2);
    if ((bool3) && (!bool2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.v("MicroMsg.ImageGalleryUI", "showScanCodeButton showQRCodeResult: %b, isFromQuoteMsg: %b, show: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (!bool1) {
        break;
      }
      this.JRX.adW(2);
      if (fFZ().JRy.getVisibility() != 0) {
        aG(fFZ().JRy, 0);
      }
      aG(this.JRx, 8);
      AppMethodBeat.o(194188);
      return;
    }
    aG(fFZ().JRy, 8);
    AppMethodBeat.o(194188);
  }
  
  private void fGi()
  {
    AppMethodBeat.i(194189);
    if (!fGj())
    {
      AppMethodBeat.o(194189);
      return;
    }
    boolean bool2 = this.JRL.la(1);
    boolean bool1;
    ce localce;
    if ((this.JRS) && (bool2) && (!fAn()))
    {
      bool1 = true;
      ad.v("MicroMsg.ImageGalleryUI", "showScanTranslateButton showQuickTrans: %b, showTranslateResult: %b, show: %b", new Object[] { Boolean.valueOf(this.JRS), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (!bool1) {
        break label192;
      }
      localce = new ce();
      if (this.ryV != 2) {
        break label187;
      }
    }
    label187:
    for (long l = 1L;; l = 0L)
    {
      localce.dVd = l;
      localce.dPl = 8L;
      localce.eca = 10L;
      localce.aLk();
      this.JRX.adW(3);
      if (this.JRx.getVisibility() != 0) {
        aG(this.JRx, 0);
      }
      aG(fFZ().JRy, 8);
      AppMethodBeat.o(194189);
      return;
      bool1 = false;
      break;
    }
    label192:
    aG(this.JRx, 8);
    AppMethodBeat.o(194189);
  }
  
  private boolean fGj()
  {
    return (this.JMz) || (this.JRN);
  }
  
  private int fGk()
  {
    if (this.JRQ == 0)
    {
      locala = com.tencent.mm.plugin.webview.ui.tools.media.a.EnZ;
      return 2;
    }
    if (this.JRQ == 1)
    {
      locala = com.tencent.mm.plugin.webview.ui.tools.media.a.EnZ;
      return 4;
    }
    com.tencent.mm.plugin.webview.ui.tools.media.a locala = com.tencent.mm.plugin.webview.ui.tools.media.a.EnZ;
    return 1;
  }
  
  private int fGl()
  {
    if (this.JRr) {
      return 3;
    }
    return 4;
  }
  
  private boolean fGm()
  {
    return this.JRo == b.b.JPW;
  }
  
  private void fGo()
  {
    boolean bool = true;
    AppMethodBeat.i(36197);
    if (this.JRp.getVisibility() == 0) {}
    for (;;)
    {
      ad.d("MicroMsg.ImageGalleryUI", "fadeInOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      this.JRp.clearAnimation();
      this.JRp.startAnimation(fGp());
      AppMethodBeat.o(36197);
      return;
      bool = false;
    }
  }
  
  private static Animation fGp()
  {
    AppMethodBeat.i(36198);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(150L);
    localAlphaAnimation.setFillAfter(true);
    AppMethodBeat.o(36198);
    return localAlphaAnimation;
  }
  
  private void fGr()
  {
    AppMethodBeat.i(36210);
    if (this.Eof != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Eof.getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, 0, 0);
      this.Eof.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(36210);
  }
  
  private void fGs()
  {
    AppMethodBeat.i(36212);
    bu localbu = this.JPj.fFL();
    String str = d.a(localbu, d.k(localbu));
    ad.i("MicroMsg.ImageGalleryUI", "edit image path:%s msgId:%s", new Object[] { str, Long.valueOf(localbu.field_msgId) });
    aWs(str);
    AppMethodBeat.o(36212);
  }
  
  private static int g(com.tencent.mm.aw.g paramg)
  {
    AppMethodBeat.i(36187);
    Map localMap = bw.M(paramg.hZI, "msg");
    if (localMap == null)
    {
      ad.e("MicroMsg.ImageGalleryUI", "parse cdnInfo failed. [%s]", new Object[] { paramg.hZI });
      AppMethodBeat.o(36187);
      return -1;
    }
    int j = bt.getInt((String)localMap.get(".msg.img.$hdlength"), 0);
    int i = j;
    if (j == 0) {
      i = bt.getInt((String)localMap.get(".msg.img.$tphdlength"), 0);
    }
    AppMethodBeat.o(36187);
    return i;
  }
  
  private void mU(boolean paramBoolean)
  {
    int i = 8;
    AppMethodBeat.i(36178);
    if (this.rFc == null)
    {
      AppMethodBeat.o(36178);
      return;
    }
    if (((paramBoolean) && (this.rFc.getVisibility() == 0)) || ((!paramBoolean) && (this.rFc.getVisibility() == 8)))
    {
      AppMethodBeat.o(36178);
      return;
    }
    Object localObject = this.rFc;
    if (paramBoolean) {
      i = 0;
    }
    ((RelativeLayout)localObject).setVisibility(i);
    localObject = getContext();
    if (paramBoolean) {}
    for (i = 2130771981;; i = 2130771982)
    {
      localObject = AnimationUtils.loadAnimation((Context)localObject, i);
      this.rFc.startAnimation((Animation)localObject);
      AppMethodBeat.o(36178);
      return;
    }
  }
  
  private void yc(boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(194185);
    Object localObject2;
    Object localObject1;
    if (this.JRK != null)
    {
      this.JRI.JUN = paramBoolean;
      this.JRI.dnx = getIntent().getBundleExtra("_stat_obj");
      localObject2 = this.JRI;
      ad.i("MicroMsg.ImageGalleryUI", "talker: %s, chatroom: %s", new Object[] { this.talker, this.chatroomName });
      localObject1 = "";
      if ((bt.isNullOrNil(this.chatroomName)) || (!w.vF(this.chatroomName))) {
        break label294;
      }
      ad.d("MicroMsg.ImageGalleryUI", "is chatroom: %s", new Object[] { this.chatroomName });
      localObject1 = this.chatroomName;
      ((com.tencent.mm.ui.chatting.gallery.a.i)localObject2).sourceType = i;
      p.h(localObject1, "<set-?>");
      ((com.tencent.mm.ui.chatting.gallery.a.i)localObject2).source = ((String)localObject1);
      localObject1 = this.JRI;
      if ((this.JPj != null) && (this.JPj.fFL() != null)) {
        break label444;
      }
    }
    for (;;)
    {
      localObject1 = this.JRK;
      localObject2 = a(this.JPj, this.tOn);
      com.tencent.mm.ui.chatting.gallery.a.i locali = this.JRI;
      com.tencent.mm.ui.chatting.gallery.a.h local18 = new com.tencent.mm.ui.chatting.gallery.a.h()
      {
        public final void a(PointF paramAnonymousPointF, AnimatorListenerAdapter paramAnonymousAnimatorListenerAdapter)
        {
          AppMethodBeat.i(194159);
          com.tencent.mm.ui.chatting.gallery.a.j.a(ImageGalleryUI.j(ImageGalleryUI.i(ImageGalleryUI.this)), paramAnonymousPointF.x, paramAnonymousPointF.y, paramAnonymousAnimatorListenerAdapter);
          AppMethodBeat.o(194159);
        }
      };
      Object localObject3 = this.JRZ;
      p.h(locali, "codeResult");
      if (((com.tencent.mm.ui.chatting.gallery.a.g)localObject1).JUw)
      {
        ad.i("MicroMsg.ImageScanCodeManager", "alvinluo handleCode %s", new Object[] { locali.ymV });
        localObject3 = new g.d((com.tencent.mm.ui.chatting.gallery.a.g)localObject1, (com.tencent.mm.ui.chatting.gallery.a.f)localObject3);
        com.tencent.mm.ui.chatting.gallery.a.j localj = com.tencent.mm.ui.chatting.gallery.a.j.JUS;
        com.tencent.mm.ui.chatting.gallery.a.j.a((Context)((com.tencent.mm.ui.chatting.gallery.a.g)localObject1).dsa, (View)localObject2, locali, local18, (com.tencent.mm.ui.chatting.gallery.a.a)localObject3);
      }
      AppMethodBeat.o(194185);
      return;
      label294:
      if (!bt.isNullOrNil(this.talker))
      {
        if (w.zE(this.talker))
        {
          ad.d("MicroMsg.ImageGalleryUI", "is biz: %s", new Object[] { this.talker });
          int j = 4;
          i = j;
          if (((com.tencent.mm.ui.chatting.gallery.a.i)localObject2).dnx != null)
          {
            ((com.tencent.mm.ui.chatting.gallery.a.i)localObject2).dnx.putString("img_gallery_talker", this.talker);
            i = j;
          }
        }
        for (;;)
        {
          localObject1 = this.talker;
          break;
          if (w.vF(this.talker))
          {
            ad.d("MicroMsg.ImageGalleryUI", "taler is chatroom: %s", new Object[] { this.talker });
          }
          else
          {
            ad.d("MicroMsg.ImageGalleryUI", "is single chat: %s", new Object[] { this.talker });
            i = 1;
          }
        }
      }
      ad.e("MicroMsg.ImageGalleryUI", "unknow source");
      i = -1;
      break;
      label444:
      localObject2 = this.JPj.g(this.JPj.fFL(), true);
      if ((localObject2 != null) && (!bt.isNullOrNil(((com.tencent.mm.aw.g)localObject2).hZI)))
      {
        localObject2 = bw.M(((com.tencent.mm.aw.g)localObject2).hZI, "msg");
        if (localObject2 != null)
        {
          ((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).dnw = ((String)((Map)localObject2).get(".msg.img.$aeskey"));
          ((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).imagePath = ((String)((Map)localObject2).get(".msg.img.$cdnmidimgurl"));
        }
      }
    }
  }
  
  private void yd(boolean paramBoolean)
  {
    AppMethodBeat.i(194186);
    String str = cwq();
    Object localObject;
    label76:
    label255:
    sp.a locala;
    if (((this.ryV == 0) || (this.ryV == 2)) && (!bt.isNullOrNil(str)))
    {
      localObject = new ce();
      long l;
      if (this.ryV == 2)
      {
        l = 1L;
        ((ce)localObject).dVd = l;
        ((ce)localObject).dPl = 3L;
        if (!paramBoolean) {
          break label255;
        }
        l = 10L;
        ((ce)localObject).eca = l;
        ((ce)localObject).aLk();
        this.ryU = ((int)(com.tencent.mm.model.u.aAm().hashCode() + System.currentTimeMillis()));
        localObject = ((com.tencent.mm.plugin.scanner.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.scanner.d.class)).getTranslationResult(str);
        if ((localObject == null) || (!com.tencent.mm.vfs.i.fv(((fp)localObject).field_resultFile))) {
          break label267;
        }
        if (this.JPj.ada(this.JSf) == null) {
          break label397;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("original_file_path", str);
        ((Intent)localObject).putExtra("msg_id", this.JPj.ada(this.JSf).field_msgId);
        if (!paramBoolean) {
          break label262;
        }
      }
      label262:
      for (i = 10;; i = 4)
      {
        ((Intent)localObject).putExtra("translate_source", i);
        startActivity(TranslationResultUI.class, (Intent)localObject);
        finish();
        overridePendingTransition(2130771986, 2130771986);
        this.JRX.adZ(1);
        AppMethodBeat.o(194186);
        return;
        l = 0L;
        break;
        l = 4L;
        break label76;
      }
      label267:
      if ((com.tencent.mm.kernel.g.aiU().aEN() == 6) || (com.tencent.mm.kernel.g.aiU().aEN() == 4)) {
        break label404;
      }
      com.tencent.mm.ui.base.h.c(this, getString(2131755828), "", true);
      ye(false);
      ad.i("MicroMsg.ImageGalleryUI", "try to translate img %s, sessionId %d", new Object[] { str, Integer.valueOf(this.ryU) });
      localObject = new sp();
      locala = ((sp)localObject).dHf;
      if (!paramBoolean) {
        break label463;
      }
    }
    label397:
    label404:
    label463:
    for (int i = 7;; i = 1)
    {
      locala.scene = i;
      ((sp)localObject).dHf.filePath = str;
      ((sp)localObject).dHf.dlK = this.ryU;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(194186);
      return;
      this.ryV = 1;
      this.ryX.setVisibility(0);
      this.ryY.setVisibility(0);
      this.ryZ.setVisibility(0);
      fGf();
      this.rza.setRepeatMode(1);
      this.rza.setRepeatCount(-1);
      this.rza.start();
      break;
    }
  }
  
  private void ye(boolean paramBoolean)
  {
    AppMethodBeat.i(36170);
    this.ryV = 0;
    this.ryX.setVisibility(8);
    this.ryY.setVisibility(8);
    this.ryZ.setVisibility(8);
    if (!paramBoolean)
    {
      fGn();
      fGe();
    }
    cwE();
    AppMethodBeat.o(36170);
  }
  
  private void yf(boolean paramBoolean)
  {
    AppMethodBeat.i(36177);
    if (this.JRo != b.b.JPV)
    {
      aG(this.JRA, 4);
      AppMethodBeat.o(36177);
      return;
    }
    Object localObject = null;
    if (this.JPj != null) {
      localObject = this.JPj.fFL();
    }
    if (localObject == null)
    {
      aG(this.JRA, 4);
      AppMethodBeat.o(36177);
      return;
    }
    com.tencent.mm.aw.g localg = this.JPj.g((bu)localObject, false);
    if (paramBoolean)
    {
      this.tOn.getCurrentItem();
      if ((f((bu)localObject, localg)) && (!((bu)localObject).frT()) && (localg.aIi()))
      {
        fFV().JRB.setVisibility(0);
        fFV().JRC.setVisibility(8);
        fFV().JRD.setVisibility(8);
        String str = (String)this.JSn.get(Long.valueOf(localg.dnz));
        localObject = str;
        if (str == null)
        {
          localObject = Ei(g(localg));
          this.JSn.put(Long.valueOf(localg.dnz), localObject);
        }
        fFV().JRB.setText(getString(2131757973, new Object[] { localObject }));
        aG(this.JRA, 0);
        AppMethodBeat.o(36177);
        return;
      }
    }
    aG(this.JRA, 4);
    AppMethodBeat.o(36177);
  }
  
  private static void yg(boolean paramBoolean)
  {
    AppMethodBeat.i(36185);
    ad.d("MicroMsg.ImageGalleryUI", "switch tool bar bg %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(36185);
  }
  
  public final int Ej(long paramLong)
  {
    AppMethodBeat.i(36204);
    if (bt.isNullOrNil(this.JRT))
    {
      AppMethodBeat.o(36204);
      return 0;
    }
    try
    {
      int j = com.tencent.mm.modelvideo.u.g(paramLong, this.JRT);
      int i = j;
      if (j == -1)
      {
        this.JRT = null;
        i = 0;
      }
      ad.d("MicroMsg.ImageGalleryUI", "get enter video op code %d %s", new Object[] { Integer.valueOf(i), this.JRT });
      AppMethodBeat.o(36204);
      return i;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ImageGalleryUI", "get enter video op code error : " + localException.toString());
      AppMethodBeat.o(36204);
    }
    return 0;
  }
  
  public final void Ek(long paramLong)
  {
    AppMethodBeat.i(36205);
    if ((bt.isNullOrNil(this.JRT)) || (paramLong == 0L))
    {
      AppMethodBeat.o(36205);
      return;
    }
    if (this.JRU)
    {
      this.JRT = com.tencent.mm.modelvideo.u.f(paramLong, 3);
      ad.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[] { this.JRT });
      AppMethodBeat.o(36205);
      return;
    }
    if (com.tencent.mm.modelvideo.u.g(paramLong, this.JRT) == -1)
    {
      this.JRT = null;
      ad.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[] { this.JRT });
    }
    AppMethodBeat.o(36205);
  }
  
  public final void adL(int paramInt)
  {
    AppMethodBeat.i(36180);
    cp(this.JPj.ada(paramInt));
    AppMethodBeat.o(36180);
  }
  
  public final void adO(final int paramInt)
  {
    AppMethodBeat.i(36194);
    if (fFW().Bjp == null)
    {
      AppMethodBeat.o(36194);
      return;
    }
    fFW().Bjp.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194173);
        if (ImageGalleryUI.this.JPj == null)
        {
          AppMethodBeat.o(194173);
          return;
        }
        b localb = ImageGalleryUI.this.JPj;
        int i = paramInt;
        localb.JPq.pause(i);
        AppMethodBeat.o(194173);
      }
    });
    AppMethodBeat.o(36194);
  }
  
  public final void adQ(int paramInt)
  {
    AppMethodBeat.i(36200);
    cxr();
    fGe();
    fFV().JRA.setVisibility(0);
    fFV().JRB.setVisibility(8);
    fFV().JRC.setVisibility(0);
    fFV().JRD.setVisibility(8);
    fFV().JRC.setText(paramInt + "%");
    AppMethodBeat.o(36200);
  }
  
  protected final void cXp()
  {
    AppMethodBeat.i(194184);
    int i = this.JSf;
    if (this.JPj == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.ImageGalleryUI", "showMenu mSelectedPos %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      if (this.JPj != null) {
        break;
      }
      AppMethodBeat.o(194184);
      return;
    }
    if (this.JSf < 0)
    {
      AppMethodBeat.o(194184);
      return;
    }
    bu localbu = this.JPj.ada(this.JSf);
    i = this.JPj.JPp.ci(localbu);
    if ((i == 5) || (i == 6))
    {
      ad.w("MicroMsg.ImageGalleryUI", "jacks fail downloaded img, return");
      AppMethodBeat.o(194184);
      return;
    }
    Object localObject = this.JPj;
    if (localbu != null)
    {
      localObject = ((b)localObject).g(localbu, false);
      if (localObject != null) {
        if ((localbu == null) || (localObject == null)) {
          bool = false;
        }
      }
    }
    while (bool)
    {
      ad.w("MicroMsg.ImageGalleryUI", "jacks downloading, return");
      AppMethodBeat.o(194184);
      return;
      if ((com.tencent.mm.aw.q.aIG().a(((com.tencent.mm.aw.g)localObject).dnz, localbu.field_msgId, 0)) || (b.b(localbu, (com.tencent.mm.aw.g)localObject)))
      {
        bool = true;
      }
      else
      {
        bool = false;
        continue;
        localObject = j.cq(localbu);
        if ((localObject != null) && (localObject != null))
        {
          i = ((s)localObject).status;
          int j = com.tencent.mm.modelvideo.u.g((s)localObject);
          if (((i == 112) || (i == 122)) && (j < 100)) {}
          for (bool = true;; bool = false)
          {
            ad.i("MicroMsg.ImageGalleryAdapter", "it is video downloading %b, status %d, download progress %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
            break;
          }
        }
        bool = false;
      }
    }
    if (b.m(localbu))
    {
      if ((j.cq(localbu) == null) && (!localbu.cxg()))
      {
        ad.w("MicroMsg.ImageGalleryUI", "video info is null, return now.");
        AppMethodBeat.o(194184);
        return;
      }
      if (localbu.cxg())
      {
        localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.EnZ;
        com.tencent.mm.plugin.webview.ui.tools.media.a.jf(fGl(), fGk());
      }
    }
    if (this.nHu == null) {
      this.nHu = new com.tencent.mm.ui.widget.a.e(getContext(), 0, true);
    }
    if ((bl.z(localbu)) && (!fAn())) {
      if (fGd()) {
        this.nHu.KWs = new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
          {
            AppMethodBeat.i(36119);
            paramAnonymousl.a(5, ImageGalleryUI.this.getString(2131757182), 2131690532);
            AppMethodBeat.o(36119);
          }
        };
      }
    }
    for (;;)
    {
      this.nHu.KJz = this.pLV;
      this.nHu.KWv = this.pLV;
      this.nHu.KWw = this.pLV;
      this.nHu.JXC = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(194157);
          ImageGalleryUI.F(ImageGalleryUI.this);
          ImageGalleryUI.e(ImageGalleryUI.this).onDismiss();
          AppMethodBeat.o(194157);
        }
      };
      this.nHu.KWx = new e.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(194158);
          if (ImageGalleryUI.this.JPj == null)
          {
            AppMethodBeat.o(194158);
            return;
          }
          Object localObject = ImageGalleryUI.this.JPj.fFL();
          if ((localObject != null) && (((bu)localObject).cxg()))
          {
            localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.EnZ;
            com.tencent.mm.plugin.webview.ui.tools.media.a.aE(3, ImageGalleryUI.G(ImageGalleryUI.this), ImageGalleryUI.H(ImageGalleryUI.this));
          }
          AppMethodBeat.o(194158);
        }
      };
      this.nHu.cMW();
      AppMethodBeat.o(194184);
      return;
      if (bl.B(localbu))
      {
        AppMethodBeat.o(194184);
        return;
      }
      this.nHu.KJy = new ImageGalleryUI.13(this, localbu);
      this.nHu.KWs = new ImageGalleryUI.14(this, localbu);
      this.nHu.KWt = new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(194156);
          paramAnonymousl.clear();
          ScanCodeSheetItemLogic localScanCodeSheetItemLogic;
          int i;
          String str1;
          Object localObject;
          if ((ImageGalleryUI.c(ImageGalleryUI.this).aea(2)) && (ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.b(ImageGalleryUI.this).ymV)))
          {
            localScanCodeSheetItemLogic = ImageGalleryUI.e(ImageGalleryUI.this);
            i = ImageGalleryUI.b(ImageGalleryUI.this).dnt;
            str1 = ImageGalleryUI.b(ImageGalleryUI.this).ymV;
            localObject = ImageGalleryUI.d(ImageGalleryUI.this);
            if ((localScanCodeSheetItemLogic.yjh != null) && ((bt.lQ(localScanCodeSheetItemLogic.yjh.GtD, str1)) || (localScanCodeSheetItemLogic.yjh == localScanCodeSheetItemLogic.yji))) {
              break label276;
            }
            if (com.tencent.mm.plugin.scanner.f.bT(i, str1))
            {
              localObject = new m(paramAnonymousl.mContext, 3, 0);
              ((m)localObject).Jma = true;
              paramAnonymousl.JlY.add(localObject);
            }
          }
          else if ((ImageGalleryUI.c(ImageGalleryUI.this).aea(1)) && (!bt.isNullOrNil(ImageGalleryUI.a(ImageGalleryUI.this))))
          {
            paramAnonymousl.a(7, ImageGalleryUI.this.getString(2131757184), 2131690669);
            paramAnonymousl = new ce();
            if (ImageGalleryUI.l(ImageGalleryUI.this) != 2) {
              break label1025;
            }
          }
          label1025:
          for (long l = 1L;; l = 0L)
          {
            paramAnonymousl.dVd = l;
            paramAnonymousl.dPl = 2L;
            paramAnonymousl.eca = 4L;
            paramAnonymousl.aLk();
            AppMethodBeat.o(194156);
            return;
            paramAnonymousl.a(3, localScanCodeSheetItemLogic.On(i), 2131690640);
            break;
            label276:
            if ((localScanCodeSheetItemLogic.yjh.Ret != 0) || (bt.isNullOrNil(localScanCodeSheetItemLogic.yjh.nDo)))
            {
              if ((com.tencent.mm.plugin.scanner.f.bN(i, str1)) || (com.tencent.mm.plugin.scanner.f.bP(i, str1)) || (com.tencent.mm.plugin.scanner.f.bO(i, str1)) || (com.tencent.mm.plugin.scanner.f.bQ(i, str1)))
              {
                paramAnonymousl.a(3, localScanCodeSheetItemLogic.mContext.getString(2131767145), 2131690640, localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099732));
                break;
              }
              if (com.tencent.mm.plugin.scanner.f.bM(i, str1))
              {
                paramAnonymousl.a(3, localScanCodeSheetItemLogic.mContext.getString(2131767147), 2131690640, localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099732));
                break;
              }
              if (com.tencent.mm.plugin.scanner.f.bS(i, str1))
              {
                paramAnonymousl.a(3, localScanCodeSheetItemLogic.mContext.getString(2131767144), 2131690680, localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099732));
                break;
              }
              if (com.tencent.mm.plugin.scanner.f.bR(i, str1))
              {
                paramAnonymousl.a(3, localScanCodeSheetItemLogic.mContext.getString(2131767146), 2131690628, localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099732));
                break;
              }
              localObject = localScanCodeSheetItemLogic.mContext.getString(2131767145);
              if (!e.d.Ye(i)) {
                localObject = localScanCodeSheetItemLogic.mContext.getString(2131767143);
              }
              paramAnonymousl.a(3, (CharSequence)localObject, 2131690640, localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099732));
              break;
            }
            str1 = localScanCodeSheetItemLogic.yjh.nDo;
            ((com.tencent.mm.ui.widget.a.e)localObject).KWy = new ScanCodeSheetItemLogic.5(localScanCodeSheetItemLogic);
            if (localScanCodeSheetItemLogic.yjh.GEe == 4)
            {
              paramAnonymousl.a(str1, localScanCodeSheetItemLogic.mContext.getString(2131767138), 0);
              break;
            }
            if (localScanCodeSheetItemLogic.yjh.GEe == 3)
            {
              paramAnonymousl.a(str1, localScanCodeSheetItemLogic.mContext.getString(2131767140), 0);
              break;
            }
            if (localScanCodeSheetItemLogic.yjh.GEe == 1)
            {
              paramAnonymousl.a(str1, localScanCodeSheetItemLogic.mContext.getString(2131767149), 0);
              break;
            }
            if (localScanCodeSheetItemLogic.yjh.GEe == 2)
            {
              paramAnonymousl.a(str1, localScanCodeSheetItemLogic.mContext.getString(2131767142), localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099732));
              break;
            }
            if (localScanCodeSheetItemLogic.yjh.GEe == 7)
            {
              localObject = new SpannableStringBuilder();
              str1 = str1 + " ";
              ((SpannableStringBuilder)localObject).append(str1);
              String str2 = "@" + localScanCodeSheetItemLogic.yjh.GEg;
              ((SpannableStringBuilder)localObject).append(str2);
              ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099777)), str1.length(), str1.length() + str2.length(), 33);
              paramAnonymousl.a((CharSequence)localObject, localScanCodeSheetItemLogic.mContext.getString(2131767151), 0);
              break;
            }
            if (localScanCodeSheetItemLogic.yjh.GEe == 6)
            {
              paramAnonymousl.a(bt.x(localScanCodeSheetItemLogic.mContext.getString(2131762856), new Object[] { localScanCodeSheetItemLogic.yjh.nDo }), localScanCodeSheetItemLogic.mContext.getString(2131767148), localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099732));
              break;
            }
            if (localScanCodeSheetItemLogic.yjh.GEe != 5) {
              break;
            }
            paramAnonymousl.a(bt.x(localScanCodeSheetItemLogic.mContext.getString(2131762875), new Object[] { localScanCodeSheetItemLogic.yjh.nDo }), localScanCodeSheetItemLogic.mContext.getString(2131767150), localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099732));
            break;
          }
        }
      };
    }
  }
  
  public final void cp(bu parambu)
  {
    label146:
    boolean bool;
    int i;
    Object localObject1;
    label382:
    Object localObject2;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(36186);
        if ((parambu == null) || (!parambu.cxg()))
        {
          if (this.Eof != null) {
            this.Eof.setVisibility(8);
          }
          this.JRo = b.cb(parambu);
          ad.i("MicroMsg.ImageGalleryUI", "updateFooterInfo currGalleryType : " + this.JRo);
          if ((h.a.fFU().rCy) && (this.JSc != null)) {
            this.JSc.setChecked(h.a.fFU().co(parambu));
          }
        }
        switch (34.JPD[this.JRo.ordinal()])
        {
        case 1: 
          AppMethodBeat.o(36186);
          return;
          if (this.Eof == null)
          {
            this.Eof = ((ViewStub)findViewById(2131300342)).inflate();
            this.rPF = findViewById(2131302498);
            this.fRd = ((ImageView)findViewById(2131302497));
            this.JSl = ((ImageView)findViewById(2131302510));
            this.opA = ((TextView)findViewById(2131302508));
            this.opB = ((MMNeat7extView)findViewById(2131302513));
            this.JSj = ((TextView)findViewById(2131302515));
            this.opA.getPaint().setFakeBoldText(true);
            this.JSj.getPaint().setFakeBoldText(true);
            this.opB.getPaint().setFakeBoldText(true);
            this.JSk = findViewById(2131302514);
            this.Eof.setOnClickListener(new ImageGalleryUI.23(this));
          }
          bool = ar.jR(this);
          i = ar.ej(this);
          if ((this.vMm) && (bool))
          {
            if (bj(this)) {
              fGr();
            }
          }
          else
          {
            localObject1 = j.cr(parambu);
            if (localObject1 != null) {
              break label382;
            }
            ad.w("MicroMsg.ImageGalleryUI", "fillMpVideoInfoLayout mpShareVideoInfo is null");
            continue;
          }
          adR(i);
        }
      }
      finally {}
      continue;
      this.opB.ar(((y)localObject1).title);
      localObject2 = new k.b();
      ((k.b)localObject2).dHp = ((y)localObject1).hDe;
      ((k.b)localObject2).dHo = ((y)localObject1).doK;
      af.a(this, (k.b)localObject2, this.fRd, this.opA);
      this.rPF.setOnClickListener(new ImageGalleryUI.24(this, (y)localObject1));
      this.JSk.setOnClickListener(new ImageGalleryUI.25(this, (y)localObject1));
      com.tencent.mm.ui.tools.o.gU(this.rPF);
      com.tencent.mm.ui.tools.o.gU(this.JSk);
      if (((y)localObject1).FCb != null)
      {
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(((y)localObject1).FCb, -1, 2, new Object[0]);
        this.JSk.setVisibility(0);
      }
      for (;;)
      {
        localObject1 = (LinearLayout.LayoutParams)this.JSl.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).height = ((int)(this.JSj.getTextSize() * 1.45D));
        ((LinearLayout.LayoutParams)localObject1).width = ((LinearLayout.LayoutParams)localObject1).height;
        this.JSl.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (!this.JPt) {
          break;
        }
        fGe();
        cxs();
        break;
        this.JSk.setVisibility(8);
      }
      aG(this.JRA, 4);
      setVideoStateIv(true);
      parambu = j.cq(parambu);
      if (parambu != null) {
        break;
      }
      AppMethodBeat.o(36186);
    }
    fFW().Bjp.setVideoTotalTime(parambu.hHQ);
    for (;;)
    {
      try
      {
        if ((this.JPj.fFM() == null) || (this.JPj.fFM().JTl == null)) {
          break label1003;
        }
        i = this.JPj.fFM().JTl.getCurrentPosition() / 1000;
        fFW().Bjp.seek(i);
        AppMethodBeat.o(36186);
      }
      catch (Exception parambu)
      {
        ad.printErrStackTrace("MicroMsg.ImageGalleryUI", parambu, "", new Object[0]);
        break label1003;
      }
      localObject1 = this.JPj.g(parambu, false);
      cxr();
      fGe();
      if (localObject1 == null)
      {
        ad.w("MicroMsg.ImageGalleryUI", "updateFooterInfo img info is null");
        AppMethodBeat.o(36186);
        break label146;
      }
      if ((this.JRG) && (((com.tencent.mm.aw.g)localObject1).aIi()) && (this.JPj.fFL() != null) && (parambu.field_msgId == this.JPj.fFL().field_msgId))
      {
        ad.i("MicroMsg.ImageGalleryUI", "get image successfully! -> gotoPhotoEditUI msgId:%s", new Object[] { Long.valueOf(parambu.field_msgId) });
        fGs();
        this.JRG = false;
        AppMethodBeat.o(36186);
        break label146;
      }
      localObject2 = this.JPj.fFL();
      bool = this.JRG;
      long l = parambu.field_msgId;
      if (localObject2 == null) {}
      for (parambu = "null";; parambu = Long.valueOf(((ei)localObject2).field_msgId))
      {
        ad.w("MicroMsg.ImageGalleryUI", "isSoonEnterPhotoEdit:%s msgId:%s curMsgId:%s getCompleted:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l), parambu, Boolean.valueOf(((com.tencent.mm.aw.g)localObject1).aIi()) });
        AppMethodBeat.o(36186);
        break;
      }
      cxr();
      fGe();
      AppMethodBeat.o(36186);
      break label146;
      cxr();
      fGe();
      aG(this.JRA, 4);
      this.JPj.adE(this.tOn.getCurrentItem());
      break;
      break;
      label1003:
      i = 0;
    }
  }
  
  public final void cxr()
  {
    AppMethodBeat.i(36184);
    ad.i("MicroMsg.ImageGalleryUI", "hide video tool bar");
    yg(false);
    aG(fFW().Bjp, 8);
    aG(this.JRt, 8);
    aG(this.Eof, 8);
    AppMethodBeat.o(36184);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(36195);
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
    {
      if (this.nHu != null)
      {
        this.nHu.bpT();
        this.nHu = null;
      }
      for (;;)
      {
        AppMethodBeat.o(36195);
        return true;
        if ((this.ryV == 0) || (this.ryV == 2)) {
          cXp();
        } else {
          cXp();
        }
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(36195);
    return bool;
  }
  
  public final boolean eqE()
  {
    AppMethodBeat.i(36193);
    boolean bool = fFW().Bjp.cfC();
    AppMethodBeat.o(36193);
    return bool;
  }
  
  final ImageGalleryUI fFV()
  {
    AppMethodBeat.i(36152);
    if (this.JRA == null)
    {
      this.JRA = findViewById(2131300930);
      this.JRB = ((Button)this.JRA.findViewById(2131298876));
      this.JRC = ((Button)this.JRA.findViewById(2131298877));
      this.JRD = this.JRA.findViewById(2131298878);
      TextView localTextView = (TextView)this.JRA.findViewById(2131298872);
      this.JRB.getPaint().setFakeBoldText(true);
      this.JRC.getPaint().setFakeBoldText(true);
      localTextView.getPaint().setFakeBoldText(true);
      float f = Math.min(1.125F, com.tencent.mm.cc.a.eb(this));
      this.JRB.setTextSize(1, 12.0F * f);
      this.JRC.setTextSize(1, f * 12.0F);
    }
    AppMethodBeat.o(36152);
    return this;
  }
  
  protected final ImageGalleryUI fFW()
  {
    AppMethodBeat.i(36153);
    if (this.Bjp == null)
    {
      this.Bjp = ((RedesignVideoPlayerSeekBar)findViewById(2131306375));
      this.Bjp.setPlayBtnOnClickListener(this);
    }
    AppMethodBeat.o(36153);
    return this;
  }
  
  public final void fGe()
  {
    int j = 0;
    AppMethodBeat.i(36174);
    if (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) {
      ad.d("MicroMsg.ImageGalleryUI", "showOpLayer %s", new Object[] { bt.flS() });
    }
    if (this.JRq)
    {
      AppMethodBeat.o(36174);
      return;
    }
    if (this.JPj != null) {}
    for (Object localObject = this.JPj.fFL();; localObject = null)
    {
      if (localObject == null)
      {
        AppMethodBeat.o(36174);
        return;
      }
      if (bl.B((bu)localObject))
      {
        ad.w("MicroMsg.ImageGalleryUI", "ignore show opLayer");
        AppMethodBeat.o(36174);
        return;
      }
      if (!this.JSm) {
        fGo();
      }
      this.JSm = true;
      this.JRp.setVisibility(0);
      fGn();
      if (!fAn())
      {
        this.JRv.setVisibility(0);
        View localView = fFX().JRu;
        if (this.JRM)
        {
          i = 0;
          aG(localView, i);
        }
      }
      else
      {
        fGi();
        fGh();
        if (this.JRo == b.b.JPV) {
          break label267;
        }
      }
      label267:
      for (int i = 0;; i = 1)
      {
        if ((bl.z((bu)localObject)) || (bl.A((bu)localObject))) {
          i = 0;
        }
        if (fAn()) {
          i = 0;
        }
        localObject = fFY().JRw;
        if (i != 0) {}
        for (i = j;; i = 8)
        {
          aG((View)localObject, i);
          if (fGm()) {
            cxs();
          }
          mU(true);
          yf(true);
          AppMethodBeat.o(36174);
          return;
          i = 8;
          break;
        }
      }
    }
  }
  
  public final void fGf()
  {
    AppMethodBeat.i(36175);
    if (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) {
      ad.d("MicroMsg.ImageGalleryUI", "hideOpLayer %s", new Object[] { bt.flS() });
    }
    if (!this.JSm)
    {
      AppMethodBeat.o(36175);
      return;
    }
    this.JSm = false;
    eUV();
    AppMethodBeat.o(36175);
  }
  
  public final void fGg()
  {
    AppMethodBeat.i(36176);
    this.rFl.stopTimer();
    this.JRv.setVisibility(8);
    fFX().JRu.clearAnimation();
    aG(fFX().JRu, 8);
    aG(fFY().JRw, 8);
    this.JRx.setVisibility(8);
    aG(fFZ().JRy, 8);
    cxr();
    mU(false);
    yf(false);
    this.JRp.setVisibility(8);
    AppMethodBeat.o(36176);
  }
  
  protected final void fGn()
  {
    AppMethodBeat.i(36182);
    if (this.JSm)
    {
      if (fGm())
      {
        this.rFl.az(3000L, 3000L);
        AppMethodBeat.o(36182);
        return;
      }
      this.rFl.az(5000L, 5000L);
    }
    AppMethodBeat.o(36182);
  }
  
  public final void fGq()
  {
    AppMethodBeat.i(36201);
    cxr();
    fFV().JRA.setVisibility(0);
    fFV().JRB.setVisibility(8);
    fFV().JRC.setVisibility(0);
    fFV().JRD.setVisibility(8);
    fFV().JRC.setText("0%");
    AppMethodBeat.o(36201);
  }
  
  public void finish()
  {
    AppMethodBeat.i(36203);
    this.JHX.clear();
    super.finish();
    AppMethodBeat.o(36203);
  }
  
  public final int getCurrentItem()
  {
    AppMethodBeat.i(221407);
    int i = this.tOn.getCurrentItem();
    AppMethodBeat.o(221407);
    return i;
  }
  
  public int getForceOrientation()
  {
    return 2;
  }
  
  public int getLayoutId()
  {
    return 2131494460;
  }
  
  public void initView()
  {
    AppMethodBeat.i(36163);
    this.oGo = new com.tencent.mm.ui.tools.e(getContext());
    this.isAnimated = false;
    this.talker = getIntent().getStringExtra("img_gallery_talker");
    this.JRN = getIntent().getBooleanExtra("img_gallery_enter_from_grid", false);
    this.JMz = getIntent().getBooleanExtra("img_gallery_enter_from_chatting_ui", false);
    this.JRP = getIntent().getBooleanExtra("img_gallery_enter_from_appbrand_service_chatting_ui", false);
    this.JMy = getIntent().getBooleanExtra("show_search_chat_content_result", false);
    this.JRM = getIntent().getBooleanExtra("show_enter_grid", true);
    this.ruj = getIntent().getBooleanExtra("key_is_biz_chat", false);
    this.nYO = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.JRq = getIntent().getBooleanExtra("img_preview_only", false);
    this.JRR = getIntent().getIntExtra("img_gallery_enter_from_scene", 0);
    this.JxB = getIntent().getIntExtra("msg_type", 0);
    if ((!this.JRq) && (bt.isNullOrNil(this.talker))) {
      ad.e("MicroMsg.ImageGalleryUI", " initView, talker is null. intent: " + getIntent());
    }
    this.chatroomName = getIntent().getStringExtra("img_gallery_chatroom_name");
    this.JRO = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
    this.JRT = getIntent().getStringExtra("img_gallery_enter_video_opcode");
    boolean bool2 = getIntent().getBooleanExtra("img_gallery_is_restransmit_after_download", false);
    Object localObject2 = getIntent().getStringExtra("img_gallery_directly_send_name");
    this.ryY = ((ImageView)findViewById(2131304342));
    this.ryZ = ((ImageView)findViewById(2131304340));
    Object localObject1 = (FrameLayout.LayoutParams)this.ryZ.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject1).bottomMargin += ar.ej(this);
    this.ryZ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.ryZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(36146);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new aw();
        paramAnonymousView.dlJ.scene = 1;
        paramAnonymousView.dlJ.dlK = ImageGalleryUI.n(ImageGalleryUI.this);
        com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
        ImageGalleryUI.m(ImageGalleryUI.this);
        ImageGalleryUI.o(ImageGalleryUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(36146);
      }
    });
    this.ryX = ((ImageView)findViewById(2131304343));
    this.rza = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.rza.setDuration(5000L);
    this.rza.addListener(new ImageGalleryUI.6(this));
    int i = getWindowManager().getDefaultDisplay().getHeight();
    this.rza.addUpdateListener(new ImageGalleryUI.7(this, i));
    this.msgId = getIntent().getLongExtra("img_gallery_msg_id", 0L);
    this.JPt = getIntent().getBooleanExtra("img_gallery_is_mp_video_without_msg", false);
    this.JRQ = getIntent().getIntExtra("img_gallery_mp_video_click_from", 2);
    long l = getIntent().getLongExtra("img_gallery_msg_svr_id", 0L);
    if (!this.JPt)
    {
      if ((this.msgId <= 0L) && (l == 0L))
      {
        ad.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.msgId + ", msgSvrId = " + l + ", stack = " + bt.flS());
        finish();
        AppMethodBeat.o(36163);
        return;
      }
      if (this.msgId == 0L)
      {
        ba.aBQ();
        this.msgId = com.tencent.mm.model.c.azs().aI(fGc(), l).field_msgId;
      }
      ba.aBQ();
      localObject1 = com.tencent.mm.model.c.azs().xY(this.msgId);
      if (((ei)localObject1).field_msgId <= 0L)
      {
        ad.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.msgId + ", msgSvrId = " + l + ", stack = " + bt.flS());
        finish();
        AppMethodBeat.o(36163);
      }
    }
    else
    {
      localObject1 = j.f(this.talker, this);
    }
    for (;;)
    {
      boolean bool1;
      if (Ej(this.msgId) == 3)
      {
        bool1 = true;
        this.JRU = bool1;
        this.JPj = new b(this, this.msgId, fGc(), this.ruj, this.nYO, bool2, (String)localObject2, Boolean.valueOf(this.JRO), this.JxB);
        this.JPj.JPu = false;
        this.JPj.JPn = getIntent().getBooleanExtra("start_chatting_ui", true);
        this.JPj.JPs = new b.c()
        {
          public final void ta()
          {
            AppMethodBeat.i(36147);
            if (ImageGalleryUI.this.JPj == null)
            {
              AppMethodBeat.o(36147);
              return;
            }
            ImageGalleryUI.this.fGe();
            ImageGalleryUI.p(ImageGalleryUI.this);
            ImageGalleryUI.this.JPj.onPageSelected(b.a.JPE);
            AppMethodBeat.o(36147);
          }
        };
        localObject2 = this.JPj;
        n localn = this.JQG;
        if (((b)localObject2).JPp != null) {
          ((b)localObject2).JPp.JQG = localn;
        }
        com.tencent.mm.ui.chatting.gallery.a.e.init();
        if (this.JRq) {
          break label1440;
        }
        bool1 = true;
        label885:
        this.JRK = new com.tencent.mm.ui.chatting.gallery.a.g(this, bool1);
        this.JRL = new com.tencent.mm.ui.chatting.gallery.a.c();
        if ((!com.tencent.mm.ui.chatting.gallery.a.e.fGS()) || (!fGj())) {
          break label1445;
        }
        bool1 = true;
        label924:
        this.JRJ = bool1;
        ad.i("MicroMsg.ImageGalleryUI", "initScanCode isPreviewOnly: %b, canShowScanCodeButton: %b", new Object[] { Boolean.valueOf(this.JRq), Boolean.valueOf(this.JRJ) });
        this.rFc = ((RelativeLayout)findViewById(2131298875));
        this.JRp = ((RelativeLayout)findViewById(2131298880));
        this.rFc.setOnClickListener(new ImageGalleryUI.39(this));
        this.JRt = findViewById(2131306316);
        this.JRt.setOnClickListener(this);
        this.JRv = findViewById(2131306373);
        this.JRx = findViewById(2131307467);
        if (!bj(this)) {
          break label1450;
        }
        eUX();
        label1058:
        this.iUP = ((ImageView)findViewById(2131300336));
        this.tOn = ((MMViewPager)findViewById(2131300335));
        this.tOn.setVerticalFadingEdgeEnabled(false);
        this.tOn.setHorizontalFadingEdgeEnabled(false);
        this.tOn.setSingleClickOverListener(new MMViewPager.e()
        {
          public final void aRp()
          {
            AppMethodBeat.i(36101);
            ImageGalleryUI.q(ImageGalleryUI.this);
            AppMethodBeat.o(36101);
          }
          
          public final void cWo()
          {
            AppMethodBeat.i(36102);
            ImageGalleryUI.r(ImageGalleryUI.this);
            AppMethodBeat.o(36102);
          }
        });
        if (this.JRq) {
          break label1457;
        }
        this.tOn.setOnPageChangeListener(this.JSi);
        this.tOn.setLongClickOverListener(new MMViewPager.c()
        {
          public final void aRq()
          {
            AppMethodBeat.i(36103);
            if (ImageGalleryUI.l(ImageGalleryUI.this) == 1)
            {
              AppMethodBeat.o(36103);
              return;
            }
            ImageGalleryUI.s(ImageGalleryUI.this);
            Object localObject;
            if ((ImageGalleryUI.l(ImageGalleryUI.this) == 0) || (ImageGalleryUI.l(ImageGalleryUI.this) == 2))
            {
              localObject = new ce();
              if (ImageGalleryUI.l(ImageGalleryUI.this) != 2) {
                break label134;
              }
            }
            label134:
            for (long l = 1L;; l = 0L)
            {
              ((ce)localObject).dVd = l;
              ((ce)localObject).dPl = 1L;
              ((ce)localObject).eca = 4L;
              ((ce)localObject).aLk();
              localObject = ImageGalleryUI.a(ImageGalleryUI.this);
              ImageGalleryUI.a(ImageGalleryUI.this, com.tencent.mm.vfs.i.k((String)localObject, false), ImageGalleryUI.k(ImageGalleryUI.this));
              ImageGalleryUI.this.cXp();
              AppMethodBeat.o(36103);
              return;
            }
          }
        });
        label1150:
        this.tOn.setOffscreenPageLimit(1);
        this.tOn.setAdapter(this.JPj);
        adL(b.a.JPE);
        this.tOn.setCurrentItem(b.a.JPE);
        this.tOn.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36104);
            if (ImageGalleryUI.this.JPj == null)
            {
              AppMethodBeat.o(36104);
              return;
            }
            if ((h.a.fFU().rCy) && (ImageGalleryUI.t(ImageGalleryUI.this) != null))
            {
              ImageGalleryUI.t(ImageGalleryUI.this).setChecked(h.a.fFU().co(ImageGalleryUI.this.JPj.fFL()));
              ImageGalleryUI.u(ImageGalleryUI.this).setOnClickListener(ImageGalleryUI.this);
            }
            int i = b.a.JPE;
            if (ImageGalleryUI.this.tOn.getCurrentItem() != i)
            {
              AppMethodBeat.o(36104);
              return;
            }
            ImageGalleryUI.this.fGn();
            b.b localb = b.cb(ImageGalleryUI.this.JPj.ada(i));
            if ((!ImageGalleryUI.this.JRO) && (localb == b.b.JPW)) {
              ImageGalleryUI.this.JPj.adA(i);
            }
            if (localb == b.b.JPX) {
              ImageGalleryUI.this.JPj.adE(i);
            }
            AppMethodBeat.o(36104);
          }
        }, 0L);
        if (h.a.fFU().rCy)
        {
          this.JSb = ((ViewStub)findViewById(2131304544)).inflate();
          this.JSb.setVisibility(0);
          this.JSc = ((CheckBox)this.JSb.findViewById(2131302204));
          this.JSd = this.JSb.findViewById(2131302205);
        }
        this.JRG = getIntent().getBooleanExtra("img_gallery_enter_PhotoEditUI", false);
        localObject1 = this.JPj.g((bu)localObject1, true);
        if (localObject1 == null) {
          ad.e("MicroMsg.ImageGalleryUI", "[initView] imgInfo is null!!! isSoonEnterPhotoEdit:%s", new Object[] { Boolean.valueOf(this.JRG) });
        }
        if ((!this.JRG) || (localObject1 == null) || (!((com.tencent.mm.aw.g)localObject1).aIi())) {
          break label1464;
        }
        fGs();
        this.JRG = false;
      }
      for (;;)
      {
        this.tOn.setOnTouchListener(new ImageGalleryUI.5(this));
        if (fAn())
        {
          this.JRv.setVisibility(8);
          aG(fFX().JRu, 8);
          aG(fFY().JRw, 8);
          aG(this.JRx, 8);
          aG(fFZ().JRy, 8);
        }
        AppMethodBeat.o(36163);
        return;
        bool1 = false;
        break;
        label1440:
        bool1 = false;
        break label885;
        label1445:
        bool1 = false;
        break label924;
        label1450:
        eUY();
        break label1058;
        label1457:
        fGg();
        break label1150;
        label1464:
        if (this.JRG) {
          ad.w("MicroMsg.ImageGalleryUI", "img not GetCompleted!");
        }
      }
    }
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(36173);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.Eeo != null) && (this.Eeo.c(this, paramInt1, paramInt2, paramIntent)))
    {
      AppMethodBeat.o(36173);
      return;
    }
    AppMethodBeat.o(36173);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(36161);
    ad.i("MicroMsg.ImageGalleryUI", "onBackPressed");
    if (this.JRN)
    {
      adN(1);
      AppMethodBeat.o(36161);
      return;
    }
    try
    {
      h.a.fFU().detach();
      bWL();
      AppMethodBeat.o(36161);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ImageGalleryUI", localException.getMessage());
      finish();
      AppMethodBeat.o(36161);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(36191);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    if (this.JPj == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131299498) {
      adN(0);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36191);
      return;
      if (paramView.getId() == 2131306373)
      {
        this.JRr = false;
        cXp();
        if ((this.JRL.aea(2)) && (aWr(this.JRI.ymV))) {
          this.JRV.bV(this.JRI.dnt, this.JRI.ymV);
        }
      }
      else if (paramView.getId() == 2131299194)
      {
        ad.i("MicroMsg.ImageGalleryUI", "[oreh download_and_save] hdImg suc, curPos:%d", new Object[] { Integer.valueOf(this.tOn.getCurrentItem()) });
        paramView = this.JPj.ada(this.tOn.getCurrentItem());
        localObject = this.JPj.g(paramView, false);
        this.tOn.getCurrentItem();
        if ((f(paramView, (com.tencent.mm.aw.g)localObject)) && (!paramView.frT()) && (((com.tencent.mm.aw.g)localObject).aIi())) {
          this.JPj.bg(this.tOn.getCurrentItem(), true);
        } else {
          b.c(getContext(), this.JPj.fFL(), true);
        }
      }
      else if (paramView.getId() == 2131298876)
      {
        this.ryV = 2;
        this.ryU = 0;
        this.JPj.bg(this.tOn.getCurrentItem(), false);
      }
      else if (paramView.getId() == 2131298877)
      {
        this.JPj.adD(this.tOn.getCurrentItem());
        adL(this.tOn.getCurrentItem());
        fGe();
      }
      else if (paramView.getId() == 2131296416)
      {
        onBackPressed();
      }
      else if (paramView.getId() == 2131306316)
      {
        onBackPressed();
      }
      else if (paramView.getId() == 2131302205)
      {
        boolean bool = this.JSc.isChecked();
        if ((!bool) && (h.a.fFU().rCx.size() >= 9))
        {
          Toast.makeText(this, getResources().getString(2131759803, new Object[] { Integer.valueOf(9) }), 1).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36191);
          return;
        }
        paramView = this.JSc;
        if (!bool) {}
        for (bool = true;; bool = false)
        {
          paramView.setChecked(bool);
          if (!this.JSc.isChecked()) {
            break label552;
          }
          h.a.fFU().cm(this.JPj.fFL());
          break;
        }
        label552:
        h.a.fFU().cn(this.JPj.fFL());
      }
      else if (paramView.getId() == 2131303281)
      {
        this.JPj.fFM();
        this.JPj.adA(this.tOn.getCurrentItem());
      }
      else if (paramView.getId() == 2131307467)
      {
        this.JRX.adY(3);
        yd(true);
      }
      else if (paramView.getId() == 2131308314)
      {
        fFZ().JRy.setOnClickListener(null);
        this.JRX.adY(2);
        yc(true);
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(36206);
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      ad.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is vertical screen", new Object[] { Integer.valueOf(hashCode()) });
      eUX();
      AppMethodBeat.o(36206);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      ad.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is horizontal screen", new Object[] { Integer.valueOf(hashCode()) });
      eUY();
      AppMethodBeat.o(36206);
      return;
    }
    AppMethodBeat.o(36206);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(36157);
    requestWindowFeature(1);
    long l = System.currentTimeMillis();
    this.JSe = true;
    super.onCreate(paramBundle);
    this.JRX.adV(1);
    if (com.tencent.mm.compatible.util.d.ly(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (this.vMm = true;; this.vMm = false)
    {
      setLightNavigationbarIcon();
      initView();
      this.oGn = paramBundle;
      com.tencent.mm.sdk.b.a.IbL.c(this.rzb);
      this.Bjz = false;
      this.JRV = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.b()
      {
        public final void agP(String paramAnonymousString)
        {
          AppMethodBeat.i(194180);
          if ((ImageGalleryUI.d(ImageGalleryUI.this) != null) && (ImageGalleryUI.d(ImageGalleryUI.this).isShowing()) && (bt.lQ(paramAnonymousString, ImageGalleryUI.b(ImageGalleryUI.this).ymV))) {
            ImageGalleryUI.this.cXp();
          }
          AppMethodBeat.o(194180);
        }
      });
      ad.d("MicroMsg.ImageGalleryUI", "ImageGallery onCreate spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(36157);
      return;
      getWindow().setFlags(1024, 1024);
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(36172);
    super.onCreateBeforeSetContentView();
    AppMethodBeat.o(36172);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(36160);
    ad.i("MicroMsg.ImageGalleryUI", "%d image gallery ui on destroy", new Object[] { Integer.valueOf(hashCode()) });
    Object localObject2;
    Object localObject3;
    Object localObject4;
    long l;
    try
    {
      if (this.JPj != null)
      {
        adM(this.JSf);
        this.JRs.a(this, this.JSf, 0);
        this.JPj.detach();
        this.JPj = null;
      }
      this.rFl.stopTimer();
      cwE();
      this.rza.removeAllUpdateListeners();
      com.tencent.mm.sdk.b.a.IbL.d(this.rzb);
      com.tencent.mm.kernel.g.ajB().b(this.rzc);
      Object localObject1 = new qq();
      ((qq)localObject1).dFm.activity = this;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      if (this.Bjp != null) {
        this.Bjp.setPlayBtnOnClickListener(null);
      }
      this.Bjp = null;
      fGb();
      if (this.JRK != null)
      {
        localObject1 = this.JRK;
        if (((com.tencent.mm.ui.chatting.gallery.a.g)localObject1).JUw)
        {
          ((com.tencent.mm.ui.chatting.gallery.a.g)localObject1).JUC.dead();
          ((com.tencent.mm.ui.chatting.gallery.a.g)localObject1).JUD.dead();
          ((com.tencent.mm.ui.chatting.gallery.a.g)localObject1).JUE.dead();
        }
        localObject2 = ((com.tencent.mm.ui.chatting.gallery.a.g)localObject1).JUx.keySet();
        p.g(localObject2, "scanCodeRequestMap.keys");
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label365;
          }
          Object localObject5 = (String)((Iterator)localObject2).next();
          localObject3 = (g.b)((com.tencent.mm.ui.chatting.gallery.a.g)localObject1).JUx.get(localObject5);
          localObject4 = new com.tencent.mm.g.a.av();
          ((com.tencent.mm.g.a.av)localObject4).dlH.filePath = ((String)localObject5);
          localObject5 = ((com.tencent.mm.g.a.av)localObject4).dlH;
          if (localObject3 == null) {
            break;
          }
          l = ((g.b)localObject3).dlI;
          ((com.tencent.mm.g.a.av.a)localObject5).dlI = l;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject4);
        }
      }
      if (!com.tencent.mm.graphics.b.c.guJ.guO) {}
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.ImageGalleryUI", localException, "", new Object[0]);
    }
    for (;;)
    {
      com.tencent.mm.graphics.b.c.guJ.stop();
      super.onDestroy();
      AppMethodBeat.o(36160);
      return;
      l = 0L;
      break;
      label365:
      localException.JUx.clear();
      localException.JUy.clear();
      localException.JUz.clear();
      ad.v("MicroMsg.ImageScanCodeManager", "releaseHandleCode");
      localObject2 = localException.JUA.keySet();
      p.g(localObject2, "handleCodeRequestMap.keys");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = new au();
        ((au)localObject4).dlF.activity = localException.dsa;
        ((au)localObject4).dlF.dlG = ((String)localObject3);
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject4);
      }
      localException.JUB.clear();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(36202);
    if (paramInt == 82)
    {
      AppMethodBeat.o(36202);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(36202);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(36150);
    ad.i("MicroMsg.ImageGalleryUI", "on pause");
    super.onPause();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(2048, 2048);
    }
    if ((!isFinishing()) && (this.JPj != null))
    {
      b localb = this.JPj;
      localb.JPq.JSN.sendEmptyMessageDelayed(1, 200L);
      localb.JPr.OC();
    }
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    AppMethodBeat.o(36150);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(36158);
    super.onResume();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().clearFlags(2048);
    }
    if ((!this.JSe) && (this.JPj != null)) {
      adL(this.tOn.getCurrentItem());
    }
    this.JSe = false;
    if (this.JPj != null) {
      this.JPj.fFN();
    }
    com.tencent.mm.kernel.g.ajB().a(this.rzc);
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    AppMethodBeat.o(36158);
  }
  
  public void onStart()
  {
    boolean bool = true;
    AppMethodBeat.i(36159);
    this.JRO = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
    Bundle localBundle;
    if (!this.JRq)
    {
      localBundle = this.oGn;
      ad.i("MicroMsg.ImageGalleryUI", "[handleAnimation] isAnimated:" + this.isAnimated);
      if (!this.isAnimated)
      {
        this.isAnimated = true;
        if (Build.VERSION.SDK_INT >= 12)
        {
          this.oGp = getIntent().getIntExtra("img_gallery_top", 0);
          this.oGq = getIntent().getIntExtra("img_gallery_left", 0);
          this.oGr = getIntent().getIntExtra("img_gallery_width", 0);
          this.oGs = getIntent().getIntExtra("img_gallery_height", 0);
          if ((this.oGp == 0) && (this.oGq == 0) && (this.oGr == 0) && (this.oGs == 0))
          {
            bu localbu = this.JPj.ada(this.tOn.getCurrentItem());
            if (localbu != null)
            {
              bd localbd = new bd();
              localbd.dlX.dku = localbu;
              com.tencent.mm.sdk.b.a.IbL.l(localbd);
              this.oGr = localbd.dlY.dmb;
              this.oGs = localbd.dlY.dmc;
              this.oGq = localbd.dlY.dlZ;
              this.oGp = localbd.dlY.dma;
            }
          }
          this.oGo.R(this.oGq, this.oGp, this.oGr, this.oGs);
          if (localBundle != null) {
            break label343;
          }
        }
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.ImageGalleryUI", "[handleAnimation] savedInstanceState is null?%s", new Object[] { Boolean.valueOf(bool) });
      if (localBundle == null) {
        this.tOn.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(36112);
            ImageGalleryUI.this.tOn.getViewTreeObserver().removeOnPreDrawListener(this);
            ad.i("MicroMsg.ImageGalleryUI", "[handleAnimation] -> onPreDraw, isBackFromGrid:" + ImageGalleryUI.this.JRO);
            ImageGalleryUI.this.Aai = ImageGalleryUI.this.tOn.getWidth();
            ImageGalleryUI.this.Aaj = ImageGalleryUI.this.tOn.getHeight();
            if (ImageGalleryUI.this.JPj.fFL().cxh()) {
              ImageGalleryUI.this.Aaj = ((int)(ImageGalleryUI.this.Aai / ImageGalleryUI.this.oGr * ImageGalleryUI.this.oGs));
            }
            if (ImageGalleryUI.this.JPj.fFL().fpi())
            {
              com.tencent.mm.ui.base.g localg = (com.tencent.mm.ui.base.g)ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.JPj, ImageGalleryUI.this.tOn);
              if (localg != null)
              {
                ImageGalleryUI localImageGalleryUI = ImageGalleryUI.this;
                float f = ImageGalleryUI.this.Aai / localg.getImageWidth();
                localImageGalleryUI.Aaj = ((int)(localg.getImageHeight() * f));
                if (ImageGalleryUI.this.Aaj > ImageGalleryUI.this.tOn.getHeight()) {
                  ImageGalleryUI.this.Aaj = ImageGalleryUI.this.tOn.getHeight();
                }
              }
            }
            ImageGalleryUI.this.oGo.jZ(ImageGalleryUI.this.Aai, ImageGalleryUI.this.Aaj);
            if (!ImageGalleryUI.this.JRO) {
              ImageGalleryUI.this.oGo.a(ImageGalleryUI.this.tOn, ImageGalleryUI.w(ImageGalleryUI.this), new e.c()
              {
                public final void onAnimationEnd()
                {
                  AppMethodBeat.i(36111);
                  ImageGalleryUI.x(ImageGalleryUI.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(36109);
                      if (ImageGalleryUI.this.JSa != null) {
                        ImageGalleryUI.this.JSa.r(Boolean.FALSE);
                      }
                      AppMethodBeat.o(36109);
                    }
                  });
                  AppMethodBeat.o(36111);
                }
                
                public final void onAnimationStart()
                {
                  AppMethodBeat.i(36110);
                  if (ImageGalleryUI.this.JSa != null) {
                    ImageGalleryUI.this.JSa.r(Boolean.TRUE);
                  }
                  AppMethodBeat.o(36110);
                }
              });
            }
            ImageGalleryUI.y(ImageGalleryUI.this);
            AppMethodBeat.o(36112);
            return true;
          }
        });
      }
      super.onStart();
      AppMethodBeat.o(36159);
      return;
      label343:
      bool = false;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(36151);
    super.onStop();
    com.tencent.mm.graphics.b.d.guR.ahg();
    if (com.tencent.mm.graphics.b.c.guJ.guO) {
      com.tencent.mm.graphics.b.c.guJ.stop();
    }
    aG(fGa().JRz, 8);
    AppMethodBeat.o(36151);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setVideoStateIv(boolean paramBoolean)
  {
    AppMethodBeat.i(36192);
    try
    {
      RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = fFW().Bjp;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localRedesignVideoPlayerSeekBar.setIsPlay(paramBoolean);
        AppMethodBeat.o(36192);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ImageGalleryUI", "set video state iv error : " + localException.toString());
      AppMethodBeat.o(36192);
    }
  }
  
  public static abstract interface a
  {
    public abstract void r(Boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI
 * JD-Core Version:    0.7.0.1
 */