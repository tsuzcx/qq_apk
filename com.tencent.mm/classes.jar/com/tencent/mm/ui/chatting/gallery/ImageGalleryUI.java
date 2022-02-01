package com.tencent.mm.ui.chatting.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextPaint;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
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
import androidx.lifecycle.q;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.autogen.a.be;
import com.tencent.mm.autogen.a.bf.a;
import com.tencent.mm.autogen.a.bg;
import com.tencent.mm.autogen.a.bt.b;
import com.tencent.mm.autogen.a.ex;
import com.tencent.mm.autogen.a.ex.b;
import com.tencent.mm.autogen.a.ki;
import com.tencent.mm.autogen.a.ki.b;
import com.tencent.mm.autogen.a.pv;
import com.tencent.mm.autogen.a.pv.a;
import com.tencent.mm.autogen.a.tm;
import com.tencent.mm.autogen.a.tn;
import com.tencent.mm.autogen.a.tn.a;
import com.tencent.mm.autogen.a.to;
import com.tencent.mm.autogen.a.to.a;
import com.tencent.mm.autogen.a.tz;
import com.tencent.mm.autogen.a.wg;
import com.tencent.mm.autogen.a.wg.a;
import com.tencent.mm.autogen.a.wh;
import com.tencent.mm.autogen.a.wh.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.b.gy;
import com.tencent.mm.autogen.mmdata.rpt.hj;
import com.tencent.mm.autogen.mmdata.rpt.ol;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelvideo.ae;
import com.tencent.mm.modelvideo.ae.a;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.appbrand.openmaterial.i.a;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.emoji.h.g;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView.b;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.b;
import com.tencent.mm.plugin.scanner.e.a;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.e.e;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.a;
import com.tencent.mm.ui.base.MMViewPager.c;
import com.tencent.mm.ui.base.MMViewPager.d;
import com.tencent.mm.ui.base.MMViewPager.f;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.chatting.gallery.scan.ImageScanCodeManager.mNotifyDealQBarStrResultListener.1;
import com.tencent.mm.ui.chatting.gallery.scan.ImageScanCodeManager.mScanQRCodeFailEventListener.1;
import com.tencent.mm.ui.chatting.gallery.scan.ImageScanCodeManager.mScanQRCodeResultEventListener.1;
import com.tencent.mm.ui.chatting.gallery.scan.e.c;
import com.tencent.mm.ui.chatting.gallery.scan.i.b;
import com.tencent.mm.ui.chatting.gallery.view.FullScreenStatusMaskView;
import com.tencent.mm.ui.chatting.gallery.view.SearchImageBubbleView;
import com.tencent.mm.ui.chatting.viewitems.an;
import com.tencent.mm.ui.tools.f.c;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@com.tencent.mm.kernel.k
@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class ImageGalleryUI
  extends MMActivity
  implements View.OnClickListener, a.a<String, com.tencent.mm.plugin.scanner.word.b>
{
  public View AMj;
  public boolean Aet;
  private int AjA;
  private ImageView AjC;
  private ImageView AjD;
  private ImageView AjE;
  private ValueAnimator AjF;
  private IListener<wh> AjG;
  private com.tencent.mm.network.p AjH;
  private com.tencent.mm.plugin.scanner.word.a Ajy;
  private volatile int Ajz;
  private RelativeLayout ApZ;
  MTimerHandler Aqi;
  private Long GYk;
  private Long GYm;
  protected MMViewPager HOP;
  public MMNeat7extView Ilr;
  private boolean KTF;
  private boolean RdV;
  private int RnK;
  private MultiCodeMaskView RnL;
  private long RnP;
  private com.tencent.mm.plugin.scanner.api.a.a RnQ;
  private com.tencent.mm.plugin.scanner.api.a.b RnR;
  private com.tencent.mm.plugin.scanner.api.a.c RnS;
  int Roe;
  int Rof;
  int Rog;
  private float Roh;
  private int Roi;
  private int Roj;
  private View SGO;
  protected RedesignVideoPlayerSeekBar SGW;
  private boolean SHh;
  private com.tencent.mm.plugin.appbrand.openmaterial.i WVA;
  public com.tencent.mm.plugin.webview.ui.tools.media.d WYF;
  public View XlK;
  protected View XlQ;
  private boolean aeAK;
  private final boolean aeAL;
  public h aeAg;
  private u aeBT;
  private boolean aeCA;
  private boolean aeCB;
  private boolean aeCC;
  public l aeCD;
  private int aeCE;
  private int aeCF;
  private int aeCG;
  private int aeCH;
  private long aeCI;
  private boolean aeCJ;
  private int aeCK;
  private View aeCL;
  private View aeCM;
  private Button aeCN;
  private Button aeCO;
  private View aeCP;
  private TextView aeCQ;
  private FullScreenStatusMaskView aeCR;
  private boolean aeCS;
  private View aeCT;
  private View aeCU;
  private View aeCV;
  private View aeCW;
  private View aeCX;
  private View aeCY;
  private SearchImageBubbleView aeCZ;
  private h.b aeCy;
  private RelativeLayout aeCz;
  private com.tencent.mm.ui.chatting.gallery.scan.e aeDA;
  private com.tencent.mm.ui.chatting.gallery.scan.g aeDB;
  private com.tencent.mm.ui.chatting.gallery.scan.h aeDC;
  private com.tencent.mm.ui.chatting.gallery.scan.c aeDD;
  public b aeDE;
  private View aeDF;
  private CheckBox aeDG;
  private View aeDH;
  private boolean aeDI;
  private final c aeDJ;
  private String aeDK;
  private AppBrandOpenMaterialCollection aeDL;
  d aeDM;
  private int aeDN;
  private boolean aeDO;
  private boolean aeDP;
  private ViewPager.OnPageChangeListener aeDQ;
  public TextView aeDR;
  public View aeDS;
  public ImageView aeDT;
  private boolean aeDU;
  boolean aeDV;
  private HashMap<Long, String> aeDW;
  private boolean aeDX;
  private boolean aeDY;
  View aeDa;
  Button aeDb;
  Button aeDc;
  View aeDd;
  int aeDe;
  int aeDf;
  boolean aeDg;
  ArrayList<Integer> aeDh;
  private com.tencent.mm.ui.chatting.gallery.scan.l aeDi;
  private boolean aeDj;
  private com.tencent.mm.ui.chatting.gallery.scan.i aeDk;
  private com.tencent.mm.ui.chatting.gallery.scan.f aeDl;
  private int aeDm;
  private com.tencent.mm.plugin.scanner.api.f aeDn;
  private com.tencent.mm.ui.chatting.gallery.scan.j aeDo;
  private boolean aeDp;
  protected boolean aeDq;
  protected boolean aeDr;
  private boolean aeDs;
  private int aeDt;
  private int aeDu;
  private boolean aeDv;
  private String aeDw;
  private boolean aeDx;
  private Long aeDy;
  private ScanCodeSheetItemLogic aeDz;
  int aedW;
  private HashSet<Long> aeqJ;
  private boolean aewt;
  protected boolean aewu;
  protected String chatroomName;
  private View contentView;
  private Drawable cpD;
  private boolean isAnimated;
  public ImageView lKK;
  private MMHandler mHandler;
  public long msgId;
  public TextView nicknameTv;
  private ImageView pIB;
  protected String talker;
  public long vEb;
  private com.tencent.mm.ui.widget.a.f vlk;
  Bundle wAX;
  com.tencent.mm.ui.tools.f wAY;
  int wAZ;
  int wBa;
  int wBb;
  int wBc;
  private u.i xVp;
  
  public ImageGalleryUI()
  {
    AppMethodBeat.i(36149);
    this.SHh = false;
    this.aeCB = false;
    this.aeCC = true;
    this.aeCD = new l();
    this.aeCE = 0;
    this.aeCF = 0;
    this.aeCG = 0;
    this.aeCH = 0;
    this.aeCI = 0L;
    this.aeCJ = false;
    this.aeCK = 0;
    this.aeCL = null;
    this.aeCS = false;
    this.Rog = 0;
    this.aeDe = 0;
    this.aeDf = 0;
    this.wAZ = 0;
    this.wBa = 0;
    this.wBb = 0;
    this.wBc = 0;
    this.aeDh = new ArrayList();
    this.aewt = false;
    this.Aet = false;
    this.aeDi = new com.tencent.mm.ui.chatting.gallery.scan.l();
    this.aeDj = false;
    this.aeDl = new com.tencent.mm.ui.chatting.gallery.scan.f();
    this.aeDm = 0;
    this.aeDo = new com.tencent.mm.ui.chatting.gallery.scan.j();
    this.aeDq = false;
    this.aewu = false;
    this.aeDr = false;
    this.isAnimated = false;
    this.aeAK = false;
    this.aeDt = -1;
    this.RnK = 0;
    this.AjA = 0;
    this.aeAL = false;
    this.aeDw = null;
    this.GYk = Long.valueOf(0L);
    this.aeDy = Long.valueOf(0L);
    this.GYm = Long.valueOf(0L);
    this.aeDA = new com.tencent.mm.ui.chatting.gallery.scan.e();
    this.aeDB = new com.tencent.mm.ui.chatting.gallery.scan.g()
    {
      public final void b(tn paramAnonymoustn)
      {
        AppMethodBeat.i(254714);
        String str1 = ImageGalleryUI.a(ImageGalleryUI.this);
        String str2 = com.tencent.mm.vfs.y.n(str1, false);
        if ((str2 == null) || (!str2.equals(paramAnonymoustn.hXh.filePath)))
        {
          Log.e("MicroMsg.ImageGalleryUI", "not same filepath");
          AppMethodBeat.o(254714);
          return;
        }
        ImageGalleryUI.c(ImageGalleryUI.this).jwc();
        Log.i("MicroMsg.ImageGalleryUI", "scanCode onFailed result: %s, curPath: %s, path: %s", new Object[] { paramAnonymoustn.hXh.result, str2, str1 });
        if (ImageGalleryUI.e(ImageGalleryUI.this).aDe(2) != 1) {
          ImageGalleryUI.e(ImageGalleryUI.this).ou(2, 2);
        }
        ImageGalleryUI.a(ImageGalleryUI.this, 2);
        if ((!ImageGalleryUI.g(ImageGalleryUI.this)) && (ImageGalleryUI.f(ImageGalleryUI.this) != null) && (ImageGalleryUI.f(ImageGalleryUI.this).isShowing()) && (ImageGalleryUI.h(ImageGalleryUI.this) != null))
        {
          Log.i("MicroMsg.ImageGalleryUI", "scanCode onFailed, show enhance bottomSheet");
          ImageGalleryUI.h(ImageGalleryUI.this).a(i.a.trv);
        }
        AppMethodBeat.o(254714);
      }
      
      public final void g(to paramAnonymousto)
      {
        AppMethodBeat.i(254710);
        Object localObject1 = ImageGalleryUI.a(ImageGalleryUI.this);
        String str = com.tencent.mm.vfs.y.n((String)localObject1, false);
        if ((str == null) || (!str.equals(paramAnonymousto.hXi.filePath)))
        {
          Log.e("MicroMsg.ImageGalleryUI", "not same filepath");
          AppMethodBeat.o(254710);
          return;
        }
        ImageGalleryUI.a(ImageGalleryUI.this, Long.valueOf(System.currentTimeMillis()));
        ImageGalleryUI.b(ImageGalleryUI.this, Long.valueOf(System.currentTimeMillis() - ImageGalleryUI.b(ImageGalleryUI.this).longValue()));
        ImageGalleryUI.c(ImageGalleryUI.this).jwc();
        Object localObject2 = com.tencent.mm.pluginsdk.ui.tools.o.YtW;
        localObject2 = com.tencent.mm.pluginsdk.ui.tools.o.b(paramAnonymousto);
        Log.i("MicroMsg.ImageGalleryUI", "scanCode onSuccess data size: %d, recognizeType: %d, curPath: %s, path: %s", new Object[] { Integer.valueOf(((ArrayList)localObject2).size()), Integer.valueOf(paramAnonymousto.hXi.hXg), str, localObject1 });
        if (!Util.isNullOrNil((List)localObject2))
        {
          localObject1 = ImageGalleryUI.d(ImageGalleryUI.this);
          kotlin.g.b.s.u(paramAnonymousto, "event");
          ((com.tencent.mm.ui.chatting.gallery.scan.l)localObject1).reset();
          localObject2 = com.tencent.mm.pluginsdk.ui.tools.o.YtW;
          ((com.tencent.mm.ui.chatting.gallery.scan.l)localObject1).aeHr = com.tencent.mm.pluginsdk.ui.tools.o.b(paramAnonymousto);
          ImageGalleryUI.d(ImageGalleryUI.this).hDg = str;
          ImageGalleryUI.e(ImageGalleryUI.this).ou(2, 1);
          ImageGalleryUI.e(ImageGalleryUI.this).e(2, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(254401);
              if ((ImageGalleryUI.f(ImageGalleryUI.this) != null) && (ImageGalleryUI.f(ImageGalleryUI.this).isShowing()))
              {
                ImageGalleryUI.this.cxQ();
                if ((ImageGalleryUI.g(ImageGalleryUI.this)) && (ImageGalleryUI.h(ImageGalleryUI.this) != null))
                {
                  Log.i("MicroMsg.ImageGalleryUI", "scanCode onSuccess, hide enhance bottomSheet");
                  ImageGalleryUI.h(ImageGalleryUI.this).a(i.a.trx);
                  AppMethodBeat.o(254401);
                }
              }
              else
              {
                ImageGalleryUI.a(ImageGalleryUI.this, 2);
              }
              AppMethodBeat.o(254401);
            }
          });
          if (2 != paramAnonymousto.hXi.hXg) {
            break label590;
          }
          if (ImageGalleryUI.d(ImageGalleryUI.this).aeHr.size() != 1) {
            break label422;
          }
          paramAnonymousto = (ImageQBarDataBean)ImageGalleryUI.d(ImageGalleryUI.this).aeHr.get(0);
          ImageGalleryUI.d(ImageGalleryUI.this).aeHt = paramAnonymousto;
          ImageGalleryUI.d(ImageGalleryUI.this).aeHs = null;
          ImageGalleryUI.i(ImageGalleryUI.this).b(paramAnonymousto.hDb, ImageGalleryUI.a(ImageGalleryUI.this, paramAnonymousto.OGQ));
        }
        for (;;)
        {
          if ((!ImageGalleryUI.g(ImageGalleryUI.this)) && (!com.tencent.mm.model.bt.S(ImageGalleryUI.this.aeAg.aBV(ImageGalleryUI.j(ImageGalleryUI.this)))) && (ImageGalleryUI.f(ImageGalleryUI.this) != null) && (ImageGalleryUI.f(ImageGalleryUI.this).isShowing()) && (ImageGalleryUI.h(ImageGalleryUI.this) != null))
          {
            Log.i("MicroMsg.ImageGalleryUI", "scanCode onSuccess, show enhance bottomSheet");
            ImageGalleryUI.h(ImageGalleryUI.this).a(i.a.trv);
          }
          AppMethodBeat.o(254710);
          return;
          label422:
          paramAnonymousto = (ArrayList)com.tencent.mm.plugin.scanner.i.a(ImageGalleryUI.this, ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.aeAg, ImageGalleryUI.this.HOP), ImageGalleryUI.d(ImageGalleryUI.this).aeHr, 0).bsC;
          if (paramAnonymousto.size() == 1)
          {
            paramAnonymousto = (ImageQBarDataBean)paramAnonymousto.get(0);
            ImageGalleryUI.d(ImageGalleryUI.this).aeHs = paramAnonymousto;
            ImageGalleryUI.d(ImageGalleryUI.this).aeHt = paramAnonymousto;
            ImageGalleryUI.i(ImageGalleryUI.this).b(paramAnonymousto.hDb, ImageGalleryUI.a(ImageGalleryUI.this, paramAnonymousto.OGQ));
          }
          else
          {
            ImageGalleryUI.d(ImageGalleryUI.this).aeHs = null;
            ImageGalleryUI.d(ImageGalleryUI.this).aeHt = null;
            if ((ImageGalleryUI.f(ImageGalleryUI.this) != null) && (ImageGalleryUI.f(ImageGalleryUI.this).isShowing()))
            {
              ImageGalleryUI.this.cxQ();
              continue;
              label590:
              if (3 == paramAnonymousto.hXi.hXg)
              {
                ImageGalleryUI.d(ImageGalleryUI.this).aeHt = null;
                ImageGalleryUI.d(ImageGalleryUI.this).aeHs = null;
                ImageGalleryUI.a(ImageGalleryUI.this, true);
              }
            }
          }
        }
      }
    };
    this.aeDC = new com.tencent.mm.ui.chatting.gallery.scan.h()
    {
      public final void a(pv paramAnonymouspv)
      {
        int i = 1;
        AppMethodBeat.i(254664);
        Log.i("MicroMsg.ImageGalleryUI", "handleCode callback notifyEvent: %d", new Object[] { Integer.valueOf(paramAnonymouspv.hSZ.hSW) });
        if (ImageGalleryUI.l(ImageGalleryUI.k(ImageGalleryUI.this)) != null) {
          ImageGalleryUI.l(ImageGalleryUI.k(ImageGalleryUI.this)).setOnClickListener(ImageGalleryUI.this);
        }
        if ((paramAnonymouspv.hSZ.activity != ImageGalleryUI.this) || (ImageGalleryUI.d(ImageGalleryUI.this).aeHr.isEmpty()) || (!paramAnonymouspv.hSZ.hBi.equals(((ImageQBarDataBean)ImageGalleryUI.d(ImageGalleryUI.this).aeHr.get(0)).OGQ)))
        {
          Log.e("MicroMsg.ImageGalleryUI", "handleCode callback not the same");
          AppMethodBeat.o(254664);
          return;
        }
        switch (paramAnonymouspv.hSZ.hSW)
        {
        default: 
          AppMethodBeat.o(254664);
          return;
        case 0: 
        case 1: 
        case 2: 
          ImageGalleryUI.m(ImageGalleryUI.this).aDc(2);
          ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.o(ImageGalleryUI.n(ImageGalleryUI.this)), 8);
          AppMethodBeat.o(254664);
          return;
        }
        paramAnonymouspv = paramAnonymouspv.hSZ.hTa;
        if (paramAnonymouspv != null) {}
        for (boolean bool = paramAnonymouspv.getBoolean("key_scan_qr_code_result", true);; bool = true)
        {
          paramAnonymouspv = ImageGalleryUI.m(ImageGalleryUI.this);
          if (bool) {}
          for (;;)
          {
            paramAnonymouspv.aDc(i);
            ImageGalleryUI.this.finish();
            break;
            i = 2;
          }
        }
      }
    };
    this.aeBT = new u()
    {
      public final void aT(long paramAnonymousLong, int paramAnonymousInt)
      {
        AppMethodBeat.i(254604);
        Log.i("MicroMsg.ImageGalleryUI", "alvinluo onImageDownloaded msgId: %d, currentMsgId: %d, compressType: %d", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(ImageGalleryUI.p(ImageGalleryUI.this)), Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousLong == ImageGalleryUI.p(ImageGalleryUI.this)) && (!j.aCM(paramAnonymousInt))) {
          ImageGalleryUI.a(ImageGalleryUI.this, paramAnonymousLong);
        }
        AppMethodBeat.o(254604);
      }
      
      public final void b(long paramAnonymousLong, View paramAnonymousView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(254599);
        if ((paramAnonymousView != null) && (paramAnonymousBitmap != null) && (!Util.isNullOrNil(paramAnonymousString)))
        {
          Log.i("MicroMsg.ImageGalleryUI", "alvinluo onImageLoaded msgId: %d, currentMsgId: %d, imagePath: %s, bitmap: %s", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(ImageGalleryUI.p(ImageGalleryUI.this)), paramAnonymousString, Integer.valueOf(paramAnonymousBitmap.hashCode()) });
          ImageGalleryUI.a(ImageGalleryUI.this, paramAnonymousView, paramAnonymousString, paramAnonymousBitmap, ImageGalleryUI.q(ImageGalleryUI.this));
          if (paramAnonymousLong == ImageGalleryUI.p(ImageGalleryUI.this)) {
            ImageGalleryUI.a(ImageGalleryUI.this, paramAnonymousLong);
          }
        }
        AppMethodBeat.o(254599);
      }
    };
    this.aeDD = new com.tencent.mm.ui.chatting.gallery.scan.c()
    {
      public final void bBn(String paramAnonymousString)
      {
        AppMethodBeat.i(254527);
        if (ImageGalleryUI.this.aeAg == null)
        {
          AppMethodBeat.o(254527);
          return;
        }
        Object localObject1 = ImageGalleryUI.this.aeAg.aBV(ImageGalleryUI.j(ImageGalleryUI.this));
        if (localObject1 == null)
        {
          AppMethodBeat.o(254527);
          return;
        }
        boolean bool = au.bwE(((fi)localObject1).field_talker);
        Object localObject3 = ImageGalleryUI.m(ImageGalleryUI.this);
        long l = ((fi)localObject1).field_msgSvrId;
        int i;
        Object localObject2;
        if (bool)
        {
          i = 2;
          localObject2 = ImageGalleryUI.o((cc)localObject1, bool);
          if (!bool) {
            break label241;
          }
          localObject1 = ((fi)localObject1).field_talker;
          label101:
          localObject3 = ((com.tencent.mm.ui.chatting.gallery.scan.e)localObject3).aeGz;
          if (localObject3 != null)
          {
            String str = String.valueOf(System.currentTimeMillis());
            kotlin.g.b.s.u(str, "<set-?>");
            ((e.c)localObject3).sessionId = str;
            ((e.c)localObject3).msgId = l;
            ((e.c)localObject3).scene = 67;
            ((e.c)localObject3).chatType = i;
            if (localObject2 != null) {
              break label248;
            }
            localObject2 = "";
          }
        }
        label241:
        label248:
        for (;;)
        {
          kotlin.g.b.s.u(localObject2, "<set-?>");
          ((e.c)localObject3).aeGE = ((String)localObject2);
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          kotlin.g.b.s.u(localObject2, "<set-?>");
          ((e.c)localObject3).xEn = ((String)localObject2);
          localObject1 = paramAnonymousString;
          if (paramAnonymousString == null) {
            localObject1 = "";
          }
          kotlin.g.b.s.u(localObject1, "<set-?>");
          ((e.c)localObject3).imagePath = ((String)localObject1);
          AppMethodBeat.o(254527);
          return;
          i = 1;
          break;
          localObject1 = "";
          break label101;
        }
      }
    };
    this.RnP = 0L;
    this.RnQ = null;
    this.RnR = ((com.tencent.mm.plugin.scanner.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.scanner.api.b.class)).gPz();
    this.RnS = new com.tencent.mm.plugin.scanner.api.a.c()
    {
      public final void gPE()
      {
        AppMethodBeat.i(254428);
        ImageGalleryUI.r(ImageGalleryUI.this);
        AppMethodBeat.o(254428);
      }
      
      public final void gPF()
      {
        AppMethodBeat.i(254440);
        Log.i("MicroMsg.ImageGalleryUI", "alvinluo dealWithImageOcr onDialogShow");
        ImageGalleryUI.t(ImageGalleryUI.this);
        AppMethodBeat.o(254440);
      }
      
      public final void gPG() {}
      
      public final void gPH()
      {
        AppMethodBeat.i(254437);
        ImageGalleryUI.s(ImageGalleryUI.this);
        AppMethodBeat.o(254437);
      }
      
      public final void gPI()
      {
        AppMethodBeat.i(254431);
        ImageGalleryUI.s(ImageGalleryUI.this);
        ImageGalleryUI.t(ImageGalleryUI.this);
        AppMethodBeat.o(254431);
      }
    };
    this.AjH = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(254426);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(254755);
            if ((com.tencent.mm.kernel.h.aZW().bFQ() != 6) && (com.tencent.mm.kernel.h.aZW().bFQ() != 4))
            {
              if (ImageGalleryUI.u(ImageGalleryUI.this) == 1)
              {
                com.tencent.mm.ui.base.k.c(ImageGalleryUI.this, ImageGalleryUI.this.getString(R.l.app_network_unavailable), "", true);
                ImageGalleryUI.v(ImageGalleryUI.this);
                ImageGalleryUI.m(ImageGalleryUI.this).aDc(2);
                AppMethodBeat.o(254755);
              }
            }
            else
            {
              if (ImageGalleryUI.this.aeAg == null)
              {
                AppMethodBeat.o(254755);
                return;
              }
              int i = ImageGalleryUI.this.getCurrentItem();
              cc localcc = ImageGalleryUI.this.aeAg.aBV(i);
              if ((localcc != null) && (localcc.dSI()))
              {
                if ((ImageGalleryUI.this.aeAg.jve() == null) && (ImageGalleryUI.this.aeAg.jve().jwq() == null))
                {
                  AppMethodBeat.o(254755);
                  return;
                }
                if ((ImageGalleryUI.this.aeAg.jve().jwq().aeFs.getVisibility() == 0) || (ImageGalleryUI.this.aeAg.jve().jwq().aeFB.getVisibility() == 0)) {
                  ImageGalleryUI.this.aeAg.aCE(i);
                }
              }
            }
            AppMethodBeat.o(254755);
          }
        });
        AppMethodBeat.o(254426);
      }
    };
    this.aeDI = true;
    this.Roh = 1.0F;
    this.Roi = 0;
    this.Roj = 0;
    this.aeDJ = new c((byte)0);
    this.aeDK = null;
    this.aeDL = null;
    this.WVA = null;
    this.aeDM = null;
    this.xVp = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(254577);
        if ((ImageGalleryUI.this == null) || (ImageGalleryUI.this.isDestroyed()) || (ImageGalleryUI.this.isFinishing()))
        {
          Log.i("MicroMsg.ImageGalleryUI", "receive onMMMenuItemSelected but activity is invalid");
          AppMethodBeat.o(254577);
          return;
        }
        ImageGalleryUI.aa(ImageGalleryUI.this).reset();
        Log.i("MicroMsg.ImageGalleryUI", "curTransState %d", new Object[] { Integer.valueOf(ImageGalleryUI.u(ImageGalleryUI.this)) });
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(254577);
          return;
          paramAnonymousMenuItem = ImageGalleryUI.this.aeAg.jvd();
          Object localObject = com.tencent.mm.model.bt.X(paramAnonymousMenuItem);
          if ((Util.isNullOrNil((String)localObject)) || (paramAnonymousMenuItem.field_isSend == 1))
          {
            ImageGalleryUI.a(ImageGalleryUI.this, paramAnonymousMenuItem);
            AppMethodBeat.o(254577);
            return;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(17509, new Object[] { Integer.valueOf(3), localObject });
          com.tencent.mm.ui.base.k.a(ImageGalleryUI.this.getContext(), R.l.gUu, R.l.gUv, R.l.app_view_detail, R.l.gzo, true, new ImageGalleryUI.27.1(this, (String)localObject), new ImageGalleryUI.27.2(this, paramAnonymousMenuItem, (String)localObject));
          AppMethodBeat.o(254577);
          return;
          paramAnonymousMenuItem = ImageGalleryUI.this.aeAg.jvd();
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.dSI()))
          {
            localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.XlE;
            com.tencent.mm.plugin.webview.ui.tools.media.a.bs(4, ImageGalleryUI.ac(ImageGalleryUI.this), ImageGalleryUI.ad(ImageGalleryUI.this));
            paramAnonymousMenuItem = p.dc(paramAnonymousMenuItem);
            if (paramAnonymousMenuItem != null) {
              ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(paramAnonymousMenuItem, ImageGalleryUI.this, ImageGalleryUI.this.aeCD.XlS);
            }
            AppMethodBeat.o(254577);
            return;
            paramAnonymousMenuItem = ImageGalleryUI.this.aeAg.jvd();
            if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.dSH()))
            {
              localObject = com.tencent.mm.modelvideo.ab.Qo(paramAnonymousMenuItem.field_imgPath);
              if ((localObject != null) && (((com.tencent.mm.modelvideo.z)localObject).status != 199) && (((com.tencent.mm.modelvideo.z)localObject).status != 199))
              {
                ImageGalleryUI.b(ImageGalleryUI.this, com.tencent.mm.modelvideo.ab.o(paramAnonymousMenuItem.field_msgId, 2));
                ImageGalleryUI.this.aeAg.aCF(ImageGalleryUI.this.HOP.getCurrentItem());
              }
            }
            for (;;)
            {
              if (com.tencent.mm.model.bt.H(paramAnonymousMenuItem))
              {
                localObject = new ol();
                ((ol)localObject).inO = paramAnonymousMenuItem.field_msgSvrId;
                ((ol)localObject).iUM = paramAnonymousMenuItem.getType();
                ((ol)localObject).jjm = com.tencent.mm.model.bt.G(paramAnonymousMenuItem);
                ((ol)localObject).ikE = 7L;
                ((ol)localObject).bMH();
              }
              AppMethodBeat.o(254577);
              return;
              localObject = new ArrayList();
              ((List)localObject).add(ImageGalleryUI.this.aeAg.jvd());
              h.g(ImageGalleryUI.this.getContext(), (List)localObject);
              continue;
              localObject = new ArrayList();
              ((List)localObject).add(ImageGalleryUI.this.aeAg.jvd());
              com.tencent.mm.modelstat.b.oUZ.as((cc)((List)localObject).get(0));
              h.g(ImageGalleryUI.this.getContext(), (List)localObject);
            }
            ImageGalleryUI.this.aeAg.aCB(ImageGalleryUI.this.HOP.getCurrentItem());
            AppMethodBeat.o(254577);
            return;
            if (com.tencent.mm.br.c.blq("favorite"))
            {
              ImageGalleryUI.this.aeAg.aCC(ImageGalleryUI.this.HOP.getCurrentItem());
              paramAnonymousMenuItem = ImageGalleryUI.this.aeAg.jvd();
              if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.dSI()))
              {
                paramAnonymousMenuItem = com.tencent.mm.plugin.webview.ui.tools.media.a.XlE;
                com.tencent.mm.plugin.webview.ui.tools.media.a.bs(2, ImageGalleryUI.ac(ImageGalleryUI.this), ImageGalleryUI.ad(ImageGalleryUI.this));
              }
              AppMethodBeat.o(254577);
              return;
              ImageGalleryUI.ag(ImageGalleryUI.this);
              AppMethodBeat.o(254577);
              return;
              if (ImageGalleryUI.this.aeAg != null)
              {
                if (h.j(ImageGalleryUI.this.aeAg.jvd())) {
                  ImageGalleryUI.ah(ImageGalleryUI.this);
                }
                AppMethodBeat.o(254577);
                return;
                if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(ImageGalleryUI.this.getContext()))
                {
                  ImageGalleryUI.ai(ImageGalleryUI.this);
                  AppMethodBeat.o(254577);
                  return;
                  Log.i("MicroMsg.ImageGalleryUI", "request deal QBAR string");
                  if ((ImageGalleryUI.f(ImageGalleryUI.this) != null) && (ImageGalleryUI.f(ImageGalleryUI.this).isShowing())) {
                    ImageGalleryUI.f(ImageGalleryUI.this).cyW();
                  }
                  paramAnonymousMenuItem = Util.safeFormatString("%d,%d", new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
                  Log.i("MicroMsg.ImageGalleryUI", "18684 report:".concat(String.valueOf(paramAnonymousMenuItem)));
                  com.tencent.mm.plugin.report.service.h.OAn.kvStat(18684, paramAnonymousMenuItem);
                  ImageGalleryUI.a(ImageGalleryUI.this, false);
                  AppMethodBeat.o(254577);
                  return;
                  ImageGalleryUI.b(ImageGalleryUI.this, System.currentTimeMillis());
                  AppMethodBeat.o(254577);
                  return;
                  ImageGalleryUI.aj(ImageGalleryUI.this);
                }
              }
            }
          }
        }
      }
    };
    this.AjG = new IListener(com.tencent.mm.app.f.hfK) {};
    this.aeDN = 0;
    this.aeDO = false;
    this.aeDP = true;
    this.aeDQ = new ViewPager.OnPageChangeListener()
    {
      private boolean aeEi = false;
      
      public final void onPageScrollStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(254587);
        Log.d("MicroMsg.ImageGalleryUI", "onPageScrollStateChanged: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 2) {
          ImageGalleryUI.d(ImageGalleryUI.this, true);
        }
        if (paramAnonymousInt == 0)
        {
          this.aeEi = false;
          ImageGalleryUI.ar(ImageGalleryUI.this);
          ImageGalleryUI.d(ImageGalleryUI.this, false);
        }
        if (ImageGalleryUI.this.aeAg != null)
        {
          h localh = ImageGalleryUI.this.aeAg;
          if (localh.aeAG != null)
          {
            j localj = localh.aeAG;
            localj.mScrollState = paramAnonymousInt;
            if (localj.aeBV != null) {
              localj.aeBV.onPageScrollStateChanged(paramAnonymousInt);
            }
          }
          if (localh.aeAH != null) {
            localh.aeAH.mScrollState = paramAnonymousInt;
          }
        }
        AppMethodBeat.o(254587);
      }
      
      public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        AppMethodBeat.i(254582);
        Log.v("MicroMsg.ImageGalleryUI", "position: %d, positionOffset: %f, positionOffsetPixels: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Float.valueOf(paramAnonymousFloat), Integer.valueOf(paramAnonymousInt2) });
        if ((!this.aeEi) && (paramAnonymousInt2 > 0)) {
          this.aeEi = true;
        }
        AppMethodBeat.o(254582);
      }
      
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(254572);
        Log.v("MicroMsg.ImageGalleryUI", "onPageChange position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (ImageGalleryUI.this.aeAg == null)
        {
          AppMethodBeat.o(254572);
          return;
        }
        ImageGalleryUI.ak(ImageGalleryUI.this).setVisibility(8);
        Object localObject1 = ImageGalleryUI.this.aeAg;
        if (((h)localObject1).aeAH != null) {
          ((h)localObject1).aeAH.jva();
        }
        if (ImageGalleryUI.j(ImageGalleryUI.this) != paramAnonymousInt)
        {
          if ((ImageGalleryUI.f(ImageGalleryUI.this) != null) && (ImageGalleryUI.f(ImageGalleryUI.this).isShowing())) {
            ImageGalleryUI.f(ImageGalleryUI.this).cyW();
          }
          ImageGalleryUI.this.jvW();
          if (!ImageGalleryUI.al(ImageGalleryUI.this))
          {
            ImageGalleryUI.am(ImageGalleryUI.this);
            localObject1 = ImageGalleryUI.k(ImageGalleryUI.this.aeAg.jvd());
            ImageGalleryUI.m(ImageGalleryUI.this).b(2, (com.tencent.mm.modelimage.h)localObject1);
            ImageGalleryUI.an(ImageGalleryUI.this);
          }
          ImageGalleryUI.ao(ImageGalleryUI.this);
          ImageGalleryUI.b(ImageGalleryUI.this, false);
          if (ImageGalleryUI.u(ImageGalleryUI.this) == 1) {
            ImageGalleryUI.v(ImageGalleryUI.this);
          }
          ImageGalleryUI.ap(ImageGalleryUI.this);
          ImageGalleryUI.E(ImageGalleryUI.this);
        }
        if (ImageGalleryUI.this.aeAg.aAZ(paramAnonymousInt) == null) {
          Log.e("MicroMsg.ImageGalleryUI", "onPageSelected the view is null, position = %s ", new Object[] { Integer.valueOf(paramAnonymousInt) });
        }
        ImageGalleryUI.P(ImageGalleryUI.this);
        ImageGalleryUI.e(ImageGalleryUI.this, ImageGalleryUI.j(ImageGalleryUI.this));
        ImageGalleryUI.this.aeCD.a(ImageGalleryUI.this, ImageGalleryUI.j(ImageGalleryUI.this), paramAnonymousInt);
        ImageGalleryUI.f(ImageGalleryUI.this, paramAnonymousInt);
        label502:
        long l;
        if (ImageGalleryUI.this.aeAg != null)
        {
          localObject1 = ImageGalleryUI.this.aeAg;
          ((h)localObject1).aeAH.stopAll();
          ((h)localObject1).aeAI.stopAll();
          localObject1 = ImageGalleryUI.this.aeAg.aBV(paramAnonymousInt);
          if (localObject1 != null)
          {
            ImageGalleryUI.c(ImageGalleryUI.this, ((fi)localObject1).field_msgId);
            ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(((fi)localObject1).field_talker);
            ImageGalleryUI.a(ImageGalleryUI.this, h.dk((cc)localObject1));
          }
          if ((h.j((cc)localObject1)) || (h.dh((cc)localObject1)))
          {
            localObject2 = ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.aeAg, ImageGalleryUI.this.HOP);
            if ((localObject2 != null) && ((localObject2 instanceof com.tencent.mm.ui.base.i)))
            {
              if (!(localObject2 instanceof MultiTouchImageView)) {
                break label711;
              }
              ((MultiTouchImageView)localObject2).jma();
            }
            String str = ImageGalleryUI.a(ImageGalleryUI.this);
            if (!com.tencent.mm.plugin.scanner.n.gPr()) {
              break label730;
            }
            ImageGalleryUI.a(ImageGalleryUI.this, str, false);
            ImageGalleryUI.a(ImageGalleryUI.this, (View)localObject2, com.tencent.mm.vfs.y.n(str, false), null, ImageGalleryUI.q(ImageGalleryUI.this));
            ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).aJ((cc)localObject1);
            ImageGalleryUI.a(ImageGalleryUI.this, ((fi)localObject1).field_msgId);
          }
          if (localObject1 != null) {
            ImageGalleryUI.this.Ao(((fi)localObject1).field_msgId);
          }
          if (ImageGalleryUI.this.aeAg == null) {
            break label751;
          }
          localObject2 = ImageGalleryUI.this.aeAg.j((cc)localObject1, false);
          if (!h.b((cc)localObject1, (com.tencent.mm.modelimage.h)localObject2)) {
            break label759;
          }
          localObject1 = com.tencent.mm.modelimage.i.a((com.tencent.mm.modelimage.h)localObject2);
          int i = ((com.tencent.mm.modelimage.h)localObject1).osy;
          int j = ((com.tencent.mm.modelimage.h)localObject1).offset;
          if (i == 0) {
            break label745;
          }
          l = j * 100L / i - 1L;
          label640:
          i = Math.max(1, (int)l);
          Log.d("MicroMsg.ImageGalleryUI", "jacks loading hd from imgInfo : %d, time: %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()) });
          ImageGalleryUI.this.aCU(i);
        }
        for (;;)
        {
          if (ImageGalleryUI.this.aeAg != null) {
            ImageGalleryUI.this.aeAg.onPageSelected(paramAnonymousInt);
          }
          AppMethodBeat.o(254572);
          return;
          label711:
          if (!(localObject2 instanceof WxImageView)) {
            break;
          }
          ((WxImageView)localObject2).jma();
          break;
          label730:
          ImageGalleryUI.e(ImageGalleryUI.this).ou(1, 2);
          break label502;
          label745:
          l = 0L;
          break label640;
          label751:
          Log.e("MicroMsg.ImageGalleryUI", "[arthurdan.ImageGallery] Notice!!! adapter is null");
          label759:
          if (localObject1 != null) {
            break label782;
          }
          Log.e("MicroMsg.ImageGalleryUI", "update footer fail, msg is null, position = ".concat(String.valueOf(paramAnonymousInt)));
        }
        label782:
        Object localObject2 = ImageGalleryUI.this;
        if (!ImageGalleryUI.al(ImageGalleryUI.this)) {}
        for (boolean bool = true;; bool = false)
        {
          ((ImageGalleryUI)localObject2).n((cc)localObject1, bool);
          ImageGalleryUI.aq(ImageGalleryUI.this);
          break;
        }
      }
    };
    this.XlK = null;
    this.aeDU = false;
    this.aeDV = false;
    this.Aqi = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(254494);
        if (ImageGalleryUI.as(ImageGalleryUI.this)) {
          ImageGalleryUI.this.jvH();
        }
        AppMethodBeat.o(254494);
        return false;
      }
    }, false);
    this.aeDW = new HashMap();
    this.aeDX = false;
    this.aeDY = false;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.aeqJ = new HashSet();
    AppMethodBeat.o(36149);
  }
  
  private static String Al(long paramLong)
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
  
  private static String Am(long paramLong)
  {
    AppMethodBeat.i(254752);
    if (paramLong < 0L)
    {
      AppMethodBeat.o(254752);
      return "";
    }
    Object localObject = new BigDecimal(paramLong);
    float f = ((BigDecimal)localObject).divide(new BigDecimal(1073741824), 1, 0).floatValue();
    if (f > 1.0F)
    {
      localObject = (int)f + "GB";
      AppMethodBeat.o(254752);
      return localObject;
    }
    f = ((BigDecimal)localObject).divide(new BigDecimal(1048576), 0, 0).floatValue();
    if (f > 1.0F)
    {
      localObject = (int)f + "MB";
      AppMethodBeat.o(254752);
      return localObject;
    }
    f = ((BigDecimal)localObject).divide(new BigDecimal(1024), 0, 0).floatValue();
    localObject = (int)f + "KB";
    AppMethodBeat.o(254752);
    return localObject;
  }
  
  private static void J(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(254629);
    if (paramView == null)
    {
      AppMethodBeat.o(254629);
      return;
    }
    Log.d("MicroMsg.ImageGalleryUI", "alvinluo showButton view: %s, withAnimation: %b", new Object[] { paramView, Boolean.valueOf(paramBoolean) });
    paramView.setVisibility(0);
    if (paramBoolean)
    {
      paramView.setAlpha(0.0F);
      com.tencent.mm.ui.chatting.gallery.scan.k.ll(paramView);
      AppMethodBeat.o(254629);
      return;
    }
    paramView.setAlpha(1.0F);
    AppMethodBeat.o(254629);
  }
  
  private void K(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(254631);
    Log.d("MicroMsg.ImageGalleryUI", "alvinluo hideButton view: %s, withAnimation: %b", new Object[] { paramView, Boolean.valueOf(paramBoolean) });
    if (paramView == null)
    {
      AppMethodBeat.o(254631);
      return;
    }
    if (!paramBoolean)
    {
      bn(paramView, 8);
      com.tencent.mm.ui.chatting.gallery.scan.k.ln(paramView);
      AppMethodBeat.o(254631);
      return;
    }
    if (paramView.getVisibility() == 0) {
      com.tencent.mm.ui.chatting.gallery.scan.k.lm(paramView);
    }
    AppMethodBeat.o(254631);
  }
  
  private void Mi(final boolean paramBoolean)
  {
    AppMethodBeat.i(254544);
    Object localObject2;
    Object localObject1;
    int i;
    if (this.aeDk != null)
    {
      this.aeDi.aeHu = paramBoolean;
      this.aeDi.hDf = getIntent().getBundleExtra("_stat_obj");
      localObject2 = this.aeDi.hDf;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        Log.i("MicroMsg.ImageGalleryUI", "addStatInfo4AppBrand, statObj is null");
        localObject1 = new Bundle();
        this.aeDi.hDf = ((Bundle)localObject1);
      }
      if (1 != this.aeDu) {
        break label340;
      }
      Log.i("MicroMsg.ImageGalleryUI", "addStatInfo4AppBrand, from app brand");
      ((Bundle)localObject1).putInt("LaunchCodeScene_ScanScene", 5);
      localObject2 = this.aeDi;
      Log.i("MicroMsg.ImageGalleryUI", "talker: %s, chatroom: %s", new Object[] { this.talker, this.chatroomName });
      i = -1;
      if ((Util.isNullOrNil(this.chatroomName)) || (!au.bwE(this.chatroomName))) {
        break label404;
      }
      Log.d("MicroMsg.ImageGalleryUI", "is chatroom: %s", new Object[] { this.chatroomName });
      localObject1 = this.chatroomName;
      i = 2;
      label192:
      ((com.tencent.mm.ui.chatting.gallery.scan.l)localObject2).sourceType = i;
      kotlin.g.b.s.u(localObject1, "<set-?>");
      ((com.tencent.mm.ui.chatting.gallery.scan.l)localObject2).source = ((String)localObject1);
      localObject1 = this.aeDi;
      if ((this.aeAg != null) && (this.aeAg.jvd() != null)) {
        break label559;
      }
    }
    for (;;)
    {
      localObject1 = this.aeDk;
      localObject2 = a(this.aeAg, this.HOP);
      com.tencent.mm.ui.chatting.gallery.scan.l locall = this.aeDi;
      com.tencent.mm.plugin.scanner.h local26 = new com.tencent.mm.plugin.scanner.h()
      {
        public final void a(ImageQBarDataBean paramAnonymousImageQBarDataBean, ArrayList<ImageQBarDataBean> paramAnonymousArrayList)
        {
          AppMethodBeat.i(254567);
          ImageGalleryUI.y(ImageGalleryUI.this).a(ImageGalleryUI.d(ImageGalleryUI.this), paramAnonymousImageQBarDataBean, ImageGalleryUI.z(ImageGalleryUI.this));
          paramAnonymousArrayList = com.tencent.mm.plugin.scanner.j.OGP;
          com.tencent.mm.plugin.scanner.j.b(ImageGalleryUI.w(ImageGalleryUI.this).longValue(), ImageGalleryUI.d(ImageGalleryUI.this).aeHr.size(), 0, 2, "");
          paramAnonymousArrayList = com.tencent.mm.plugin.scanner.j.OGP;
          com.tencent.mm.plugin.scanner.j.a(ImageGalleryUI.w(ImageGalleryUI.this).longValue(), 1, ImageGalleryUI.d(ImageGalleryUI.this).aeHr, paramAnonymousImageQBarDataBean, ImageGalleryUI.x(ImageGalleryUI.this).longValue(), paramBoolean);
          AppMethodBeat.o(254567);
        }
        
        public final void a(ArrayList<PointF> paramAnonymousArrayList, ArrayList<ImageQBarDataBean> paramAnonymousArrayList1, ArrayList<ImageQBarDataBean> paramAnonymousArrayList2)
        {
          AppMethodBeat.i(254578);
          if (ImageGalleryUI.this.HOP != null) {
            ImageGalleryUI.af(ImageGalleryUI.ae(ImageGalleryUI.this)).a(paramAnonymousArrayList2, paramAnonymousArrayList, paramAnonymousArrayList1, ImageGalleryUI.this.HOP.getMeasuredHeight());
          }
          for (;;)
          {
            ImageGalleryUI.this.wa(false);
            paramAnonymousArrayList1 = com.tencent.mm.plugin.scanner.j.OGP;
            com.tencent.mm.plugin.scanner.j.b(ImageGalleryUI.w(ImageGalleryUI.this).longValue(), paramAnonymousArrayList2.size(), paramAnonymousArrayList.size(), 2, "");
            if (paramAnonymousArrayList.size() > 1)
            {
              paramAnonymousArrayList = com.tencent.mm.plugin.scanner.j.OGP;
              com.tencent.mm.plugin.scanner.j.a(ImageGalleryUI.w(ImageGalleryUI.this).longValue(), 11, paramAnonymousArrayList2, null, ImageGalleryUI.x(ImageGalleryUI.this).longValue(), paramBoolean);
            }
            AppMethodBeat.o(254578);
            return;
            ImageGalleryUI.af(ImageGalleryUI.ae(ImageGalleryUI.this)).a(paramAnonymousArrayList2, paramAnonymousArrayList, paramAnonymousArrayList1, ImageGalleryUI.af(ImageGalleryUI.ae(ImageGalleryUI.this)).getRootView().getHeight());
          }
        }
      };
      kotlin.g.b.s.u(locall, "codeResult");
      if (((com.tencent.mm.ui.chatting.gallery.scan.i)localObject1).aeGR)
      {
        Log.i("MicroMsg.ImageScanCodeManager", kotlin.g.b.s.X("handleCode  qBarDataList:", Integer.valueOf(locall.aeHr.size())));
        com.tencent.mm.plugin.scanner.i.a((Context)((com.tencent.mm.ui.chatting.gallery.scan.i)localObject1).hHU, (View)localObject2, locall.aeHr, 0, local26);
      }
      AppMethodBeat.o(254544);
      return;
      label340:
      if (jvL())
      {
        localObject2 = jvx();
        Log.i("MicroMsg.ImageGalleryUI", "addStatInfo4AppBrand, from chat, username: ".concat(String.valueOf(localObject2)));
        ((Bundle)localObject1).putInt("LaunchCodeScene_ScanScene", 1);
        ((Bundle)localObject1).putString("LaunchCodeScene_Username", (String)localObject2);
        break;
      }
      Log.i("MicroMsg.ImageGalleryUI", "addStatInfo4AppBrand, others");
      break;
      label404:
      if (!Util.isNullOrNil(this.talker))
      {
        if (com.tencent.mm.model.ab.IS(this.talker))
        {
          Log.d("MicroMsg.ImageGalleryUI", "is biz: %s", new Object[] { this.talker });
          int j = 4;
          i = j;
          if (((com.tencent.mm.ui.chatting.gallery.scan.l)localObject2).hDf != null)
          {
            ((com.tencent.mm.ui.chatting.gallery.scan.l)localObject2).hDf.putString("img_gallery_talker", this.talker);
            i = j;
          }
        }
        for (;;)
        {
          localObject1 = this.talker;
          break;
          if (au.bwE(this.talker))
          {
            Log.d("MicroMsg.ImageGalleryUI", "taler is chatroom: %s", new Object[] { this.talker });
            i = 2;
          }
          else
          {
            Log.d("MicroMsg.ImageGalleryUI", "is single chat: %s", new Object[] { this.talker });
            i = 1;
          }
        }
      }
      Log.e("MicroMsg.ImageGalleryUI", "unknow source");
      localObject1 = "";
      break label192;
      label559:
      localObject2 = this.aeAg.j(this.aeAg.jvd(), true);
      if ((localObject2 != null) && (!Util.isNullOrNil(((com.tencent.mm.modelimage.h)localObject2).oGC)))
      {
        localObject2 = XmlParser.parseXml(((com.tencent.mm.modelimage.h)localObject2).oGC, "msg", null);
        if (localObject2 != null)
        {
          ((com.tencent.mm.ui.chatting.gallery.scan.l)localObject1).hDe = ((String)((Map)localObject2).get(".msg.img.$aeskey"));
          ((com.tencent.mm.ui.chatting.gallery.scan.l)localObject1).imagePath = ((String)((Map)localObject2).get(".msg.img.$cdnmidimgurl"));
        }
      }
    }
  }
  
  private void Mj(boolean paramBoolean)
  {
    AppMethodBeat.i(254565);
    String str = dRR();
    Object localObject2;
    label76:
    Object localObject1;
    if (((this.AjA == 0) || (this.AjA == 2)) && (!Util.isNullOrNil(str)))
    {
      localObject2 = new hj();
      long l;
      if (this.AjA == 2)
      {
        l = 1L;
        ((hj)localObject2).iqr = l;
        ((hj)localObject2).ikE = 3L;
        if (!paramBoolean) {
          break label327;
        }
        l = 10L;
        ((hj)localObject2).iOd = l;
        localObject1 = j.k(this.aeAg.jvd());
        if (localObject1 != null)
        {
          ((hj)localObject2).rq(((com.tencent.mm.modelimage.h)localObject1).getFileId());
          ((hj)localObject2).rr(((com.tencent.mm.modelimage.h)localObject1).getAesKey());
        }
        ((hj)localObject2).bMH();
        this.Ajz = ((int)(com.tencent.mm.model.z.bAM().hashCode() + System.currentTimeMillis()));
        localObject2 = ((com.tencent.mm.plugin.scanner.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.scanner.f.class)).getTranslationResult(str);
        if ((localObject2 == null) || (!com.tencent.mm.vfs.y.ZC(((gy)localObject2).field_resultFile))) {
          break label339;
        }
        if (this.aeAg.aBV(this.aeDN) == null) {
          break label466;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("original_file_path", str);
        ((Intent)localObject2).putExtra("msg_id", this.aeAg.aBV(this.aeDN).field_msgId);
        if (!paramBoolean) {
          break label334;
        }
      }
      label327:
      label334:
      for (i = 10;; i = 4)
      {
        ((Intent)localObject2).putExtra("translate_source", i);
        if (localObject1 != null)
        {
          ((Intent)localObject2).putExtra("fileid", ((com.tencent.mm.modelimage.h)localObject1).getFileId());
          ((Intent)localObject2).putExtra("aeskey", ((com.tencent.mm.modelimage.h)localObject1).getAesKey());
        }
        startActivity(TranslationResultUI.class, (Intent)localObject2);
        finish();
        i = R.a.anim_not_change;
        overridePendingTransition(i, i);
        this.aeDA.aDc(1);
        AppMethodBeat.o(254565);
        return;
        l = 0L;
        break;
        l = 4L;
        break label76;
      }
      label339:
      if ((com.tencent.mm.kernel.h.aZW().bFQ() == 6) || (com.tencent.mm.kernel.h.aZW().bFQ() == 4)) {
        break label473;
      }
      com.tencent.mm.ui.base.k.c(this, getString(R.l.app_network_unavailable), "", true);
      Ml(false);
      Log.i("MicroMsg.ImageGalleryUI", "try to translate img %s, sessionId %d", new Object[] { str, Integer.valueOf(this.Ajz) });
      localObject1 = new wg();
      localObject2 = ((wg)localObject1).hZR;
      if (!paramBoolean) {
        break label485;
      }
    }
    label466:
    label473:
    label485:
    for (int i = 7;; i = 1)
    {
      ((wg.a)localObject2).scene = i;
      ((wg)localObject1).hZR.filePath = str;
      ((wg)localObject1).hZR.hBm = this.Ajz;
      ((wg)localObject1).publish();
      AppMethodBeat.o(254565);
      return;
      this.AjA = 1;
      dSf();
      break;
    }
  }
  
  private void Mk(boolean paramBoolean)
  {
    AppMethodBeat.i(254581);
    this.AjC.setVisibility(8);
    this.AjD.setVisibility(8);
    this.AjE.setVisibility(8);
    if (!paramBoolean)
    {
      jvR();
      Mn(false);
    }
    AppMethodBeat.o(254581);
  }
  
  private void Ml(boolean paramBoolean)
  {
    AppMethodBeat.i(36170);
    this.AjA = 0;
    Mm(paramBoolean);
    AppMethodBeat.o(36170);
  }
  
  private void Mm(boolean paramBoolean)
  {
    AppMethodBeat.i(254596);
    Mk(paramBoolean);
    this.AjF.setRepeatMode(1);
    this.AjF.setRepeatCount(0);
    this.AjF.end();
    AppMethodBeat.o(254596);
  }
  
  private void Mn(boolean paramBoolean)
  {
    AppMethodBeat.i(254617);
    if (BuildInfo.IS_FLAVOR_RED) {
      Log.d("MicroMsg.ImageGalleryUI", "showOpLayer isShowOpToolbar: %b, pageChanged: %b, %s", new Object[] { Boolean.valueOf(this.aeDV), Boolean.valueOf(paramBoolean), Util.getStack() });
    }
    if (this.aeCA)
    {
      AppMethodBeat.o(254617);
      return;
    }
    if (this.aeAg != null) {}
    for (cc localcc = this.aeAg.jvd();; localcc = null)
    {
      if (localcc == null)
      {
        AppMethodBeat.o(254617);
        return;
      }
      if (com.tencent.mm.model.bt.O(localcc))
      {
        Log.w("MicroMsg.ImageGalleryUI", "ignore show opLayer");
        AppMethodBeat.o(254617);
        return;
      }
      if (!this.aeDV) {
        jvT();
      }
      for (boolean bool = false;; bool = true)
      {
        this.aeCE = 0;
        this.aeDV = true;
        this.aeCz.setVisibility(0);
        jvR();
        jvK();
        m(localcc, paramBoolean);
        if (!paramBoolean) {
          cI(0, true);
        }
        for (;;)
        {
          if (jvP()) {
            dSV();
          }
          wa(true);
          Ms(true);
          AppMethodBeat.o(254617);
          return;
          if (!jvQ()) {
            cJ(0, bool);
          }
        }
      }
    }
  }
  
  private boolean Mo(boolean paramBoolean)
  {
    AppMethodBeat.i(254658);
    if (!this.aeDj)
    {
      AppMethodBeat.o(254658);
      return false;
    }
    boolean bool2 = joe();
    boolean bool3 = this.aeDl.qt(2);
    if ((bool3) && (!bool2) && (!jvz())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.v("MicroMsg.ImageGalleryUI", "showScanCodeButton showQRCodeResult: %b, isFromQuoteMsg: %b, show: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (!bool1) {
        break;
      }
      this.aeDA.aCZ(2);
      if (jvr().aeCX.getVisibility() != 0) {
        bn(jvr().aeCX, 0);
      }
      AppMethodBeat.o(254658);
      return true;
    }
    if (paramBoolean) {
      bn(jvr().aeCX, 8);
    }
    AppMethodBeat.o(254658);
    return false;
  }
  
  private boolean Mp(boolean paramBoolean)
  {
    AppMethodBeat.i(254662);
    if (!jvL())
    {
      AppMethodBeat.o(254662);
      return false;
    }
    boolean bool2 = this.aeDl.qt(1);
    boolean bool1;
    hj localhj;
    if ((this.aeDv) && (bool2) && (!jvz()))
    {
      bool1 = true;
      Log.v("MicroMsg.ImageGalleryUI", "showScanTranslateButton showQuickTrans: %b, showTranslateResult: %b, show: %b", new Object[] { Boolean.valueOf(this.aeDv), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (!bool1) {
        break label232;
      }
      localhj = new hj();
      if (this.AjA != 2) {
        break label226;
      }
    }
    label226:
    for (long l = 1L;; l = 0L)
    {
      localhj.iqr = l;
      localhj.ikE = 8L;
      localhj.iOd = 10L;
      if (this.aeAg != null)
      {
        com.tencent.mm.modelimage.h localh = j.k(this.aeAg.jvd());
        if (localh != null)
        {
          localhj.rq(localh.getFileId());
          localhj.rr(localh.getAesKey());
        }
      }
      localhj.bMH();
      this.aeDA.aCZ(3);
      if (this.aeCW.getVisibility() != 0) {
        bn(this.aeCW, 0);
      }
      AppMethodBeat.o(254662);
      return true;
      bool1 = false;
      break;
    }
    label232:
    if (paramBoolean) {
      bn(this.aeCW, 8);
    }
    AppMethodBeat.o(254662);
    return false;
  }
  
  private boolean Mq(boolean paramBoolean)
  {
    AppMethodBeat.i(254667);
    if ((!jvL()) || (!com.tencent.mm.ui.chatting.gallery.scan.d.jwB()))
    {
      AppMethodBeat.o(254667);
      return false;
    }
    boolean bool = aj.aBu();
    if ((!joe()) && (!jvz()) && (this.aeDl.qt(4)) && (!bool)) {}
    for (bool = true;; bool = false)
    {
      Log.i("MicroMsg.ImageGalleryUI", "alvinluo showSearchImageButton showButton: %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      bn(jvu().SGO, 0);
      this.aeDA.aDd(3);
      AppMethodBeat.o(254667);
      return true;
    }
    if (paramBoolean) {
      bn(jvu().SGO, 8);
    }
    AppMethodBeat.o(254667);
    return false;
  }
  
  private boolean Mr(boolean paramBoolean)
  {
    AppMethodBeat.i(254673);
    if ((!jvL()) || (!com.tencent.mm.ui.chatting.gallery.scan.d.jwC()))
    {
      AppMethodBeat.o(254673);
      return false;
    }
    boolean bool;
    label113:
    Object localObject;
    int i;
    if ((!joe()) && (!jvz()) && (this.aeDn != null) && (!Util.isNullOrNil(this.aeDn.OMP)) && (this.aeDl.qt(3)))
    {
      bool = true;
      Log.i("MicroMsg.ImageGalleryUI", "alvinluo showSearchImageBubbleView showBubble: %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label393;
      }
      if (this.aeCz.getVisibility() != 0) {
        break label366;
      }
      paramBoolean = true;
      localObject = jvu().SGO;
      if (!paramBoolean) {
        break label371;
      }
      i = 0;
      label128:
      bn((View)localObject, i);
      localObject = jvv().aeCZ;
      if (!paramBoolean) {
        break label377;
      }
      i = 0;
      label150:
      bn((View)localObject, i);
      int k = this.HOP.getMeasuredWidth();
      int j = k - (this.aeCE + 1) * this.aeCF - this.aeCH;
      i = j;
      if (this.aeCE > 1) {
        i = j - this.aeCE * this.aeCG;
      }
      Log.i("MicroMsg.ImageGalleryUI", "alvinluo showSearchImageBubbleView visible: %b, galleryWidth: %d, showButtonCount: %d, viewPositionX: %d, bottomBtnSize: %d, bottomBtnRightExtrMargin: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(k), Integer.valueOf(this.aeCE), Integer.valueOf(i), Integer.valueOf(this.aeCF), Integer.valueOf(this.aeCH) });
      localObject = jvv().aeCZ;
      ((SearchImageBubbleView)localObject).setViewWidth(k);
      ((SearchImageBubbleView)localObject).setBubbleText(this.aeDn.OMP);
      ((SearchImageBubbleView)localObject).ov(this.aeCF, this.aeCF);
      ((SearchImageBubbleView)localObject).aDj(i);
      ((SearchImageBubbleView)localObject).setBubbleClickListener(this);
      if (!paramBoolean) {
        break label383;
      }
      ((SearchImageBubbleView)localObject).show();
    }
    for (;;)
    {
      this.aeDA.aDd(4);
      this.aeDA.aDd(3);
      AppMethodBeat.o(254673);
      return true;
      bool = false;
      break;
      label366:
      paramBoolean = false;
      break label113;
      label371:
      i = 8;
      break label128;
      label377:
      i = 8;
      break label150;
      label383:
      ((SearchImageBubbleView)localObject).setVisibility(8);
    }
    label393:
    if (paramBoolean) {
      bn(jvv().aeCZ, 8);
    }
    AppMethodBeat.o(254673);
    return false;
  }
  
  private void Ms(boolean paramBoolean)
  {
    AppMethodBeat.i(36177);
    if ((this.aeCy != h.b.aeBi) || (jvz()))
    {
      bn(this.aeDa, 4);
      AppMethodBeat.o(36177);
      return;
    }
    Object localObject = null;
    if (this.aeAg != null) {
      localObject = this.aeAg.jvd();
    }
    if ((localObject == null) || (com.tencent.mm.model.bt.H((cc)localObject)))
    {
      bn(this.aeDa, 4);
      AppMethodBeat.o(36177);
      return;
    }
    com.tencent.mm.modelimage.h localh = this.aeAg.j((cc)localObject, false);
    if (paramBoolean)
    {
      this.HOP.getCurrentItem();
      if ((f((cc)localObject, localh)) && (!((cc)localObject).isClean()) && (localh.bJD()))
      {
        jvn().aeDb.setVisibility(0);
        jvn().aeDc.setVisibility(8);
        jvn().aeDd.setVisibility(8);
        String str = (String)this.aeDW.get(Long.valueOf(localh.localId));
        localObject = str;
        if (str == null)
        {
          localObject = Al(h(localh));
          this.aeDW.put(Long.valueOf(localh.localId), localObject);
        }
        jvn().aeDb.setText(getString(R.l.gDD, new Object[] { localObject }));
        bn(this.aeDa, 0);
        AppMethodBeat.o(36177);
        return;
      }
    }
    bn(this.aeDa, 4);
    AppMethodBeat.o(36177);
  }
  
  private static void Mt(boolean paramBoolean)
  {
    AppMethodBeat.i(36185);
    Log.d("MicroMsg.ImageGalleryUI", "switch tool bar bg %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(36185);
  }
  
  private View a(h paramh, MMViewPager paramMMViewPager)
  {
    AppMethodBeat.i(36164);
    boolean bool1;
    if (paramh == null)
    {
      bool1 = true;
      if (paramMMViewPager != null) {
        break label75;
      }
    }
    label75:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.d("MicroMsg.ImageGalleryUI", "get current view adapter is null %b, gallery is null %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((paramh == null) || (paramMMViewPager == null)) {
        break label182;
      }
      if (paramh.jvd() != null) {
        break label81;
      }
      AppMethodBeat.o(36164);
      return null;
      bool1 = false;
      break;
    }
    label81:
    Object localObject;
    if ((paramh.jvd().iYk()) || (paramh.jvd().jbK()))
    {
      MultiTouchImageView localMultiTouchImageView = paramh.WN(paramMMViewPager.getCurrentItem());
      localObject = localMultiTouchImageView;
      if (localMultiTouchImageView == null) {
        localObject = paramh.WO(paramMMViewPager.getCurrentItem());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(36164);
      return localObject;
      if ((paramh.jvd().dSH()) || (paramh.jvd().dSJ()) || (paramh.jvd().dSI()))
      {
        localObject = paramh.aCD(paramMMViewPager.getCurrentItem());
        continue;
        label182:
        Log.w("MicroMsg.ImageGalleryUI", "%d get current view but adapter or gallery is null", new Object[] { Integer.valueOf(hashCode()) });
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  private void a(View paramView, String paramString, Bitmap paramBitmap, int paramInt, com.tencent.mm.ui.chatting.gallery.scan.g paramg)
  {
    AppMethodBeat.i(254611);
    Log.d("MicroMsg.ImageGalleryUI", "doScanImageQRCode  recognizeType:".concat(String.valueOf(paramInt)));
    if (this.aeDk != null)
    {
      this.GYm = Long.valueOf(System.currentTimeMillis());
      Object localObject1 = this.aeDJ;
      Log.i("MicroMsg.ImageGalleryUI", "onScanStart#ScanState, realScanImgPath: ".concat(String.valueOf(paramString)));
      Object localObject2;
      int i;
      if (!Util.isEqual(com.tencent.mm.vfs.y.n(((c)localObject1).aeDZ.dRR(), false), paramString))
      {
        Log.i("MicroMsg.ImageGalleryUI", "onScanStart#ScanState, not match");
        localObject1 = this.aeDk;
        if (!((com.tencent.mm.ui.chatting.gallery.scan.i)localObject1).aeGR) {
          break label743;
        }
        localObject2 = (CharSequence)paramString;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label410;
        }
        i = 1;
      }
      for (;;)
      {
        if (i == 0)
        {
          localObject2 = new i.b();
          ((i.b)localObject2).hBk = System.currentTimeMillis();
          kotlin.g.b.s.u(paramString, "<set-?>");
          ((i.b)localObject2).imagePath = paramString;
          ((i.b)localObject2).bitmap = paramBitmap;
          ((i.b)localObject2).hXg = paramInt;
          Log.i("MicroMsg.ImageScanCodeManager", "alvinluo scanCode session: %d, imagePath: %s, bitmap: %s, getCodePosition: %b", new Object[] { Long.valueOf(((i.b)localObject2).hBk), paramString, paramBitmap, Boolean.TRUE });
          if ((paramView instanceof com.tencent.mm.ui.base.i)) {
            Log.d("MicroMsg.ImageScanCodeManager", "alvinluo scanCode imageSize: %d, %d, screen: %d, %d, current: %s", new Object[] { Integer.valueOf(((com.tencent.mm.ui.base.i)paramView).getImageWidth()), Integer.valueOf(((com.tencent.mm.ui.base.i)paramView).getImageHeight()), Integer.valueOf(com.tencent.mm.cd.a.ms((Context)((com.tencent.mm.ui.chatting.gallery.scan.i)localObject1).hHU)), Integer.valueOf(com.tencent.mm.cd.a.mt((Context)((com.tencent.mm.ui.chatting.gallery.scan.i)localObject1).hHU)), paramView });
          }
          ((i.b)localObject2).bitmap = null;
          if (com.tencent.mm.ui.chatting.gallery.scan.i.a((i.b)localObject2))
          {
            paramView = (com.tencent.mm.ui.chatting.gallery.scan.i.c)((com.tencent.mm.ui.chatting.gallery.scan.i)localObject1).aeGU.get(((i.b)localObject2).imagePath);
            if (paramView != null)
            {
              Log.i("MicroMsg.ImageScanCodeManager", "alvinluo scanCode get result from cache %s", new Object[] { ((i.b)localObject2).imagePath });
              if ((paramView.success) && (paramView.aeHa != null))
              {
                if (paramg != null)
                {
                  paramView = paramView.aeHa;
                  kotlin.g.b.s.checkNotNull(paramView);
                  paramg.g(paramView);
                }
                AppMethodBeat.o(254611);
                return;
                ((c)localObject1).mState = 1;
                break;
                label410:
                i = 0;
                continue;
              }
              if ((!paramView.success) && (paramView.aeHb != null))
              {
                if (paramg != null)
                {
                  paramView = paramView.aeHb;
                  kotlin.g.b.s.checkNotNull(paramView);
                  paramg.b(paramView);
                }
                AppMethodBeat.o(254611);
                return;
              }
              paramView = ((i.b)localObject2).imagePath;
              ((com.tencent.mm.ui.chatting.gallery.scan.i)localObject1).aeGU.remove(paramView);
            }
          }
          Log.i("MicroMsg.ImageScanCodeManager", "doScanCode from decoder  recognizeType:" + ((i.b)localObject2).hXg + "   path:" + ((i.b)localObject2).imagePath);
          if (!Util.isNullOrNil(((i.b)localObject2).imagePath))
          {
            paramView = ((i.b)localObject2).imagePath;
            if (!((com.tencent.mm.ui.chatting.gallery.scan.i)localObject1).aeGT.containsKey(paramView)) {
              ((Map)((com.tencent.mm.ui.chatting.gallery.scan.i)localObject1).aeGT).put(paramView, new ArrayList());
            }
            paramString = ((com.tencent.mm.ui.chatting.gallery.scan.i)localObject1).aeGT.get(paramView);
            kotlin.g.b.s.checkNotNull(paramString);
            if (!((ArrayList)paramString).contains(paramg))
            {
              paramString = ((com.tencent.mm.ui.chatting.gallery.scan.i)localObject1).aeGT.get(paramView);
              kotlin.g.b.s.checkNotNull(paramString);
              ((ArrayList)paramString).add(paramg);
            }
            if (((com.tencent.mm.ui.chatting.gallery.scan.i)localObject1).aeGS.containsKey(paramView))
            {
              Log.w("MicroMsg.ImageScanCodeManager", "alvinluo scanCode image %s is already decoding and ignore", new Object[] { ((i.b)localObject2).imagePath });
              AppMethodBeat.o(254611);
              return;
            }
            ((Map)((com.tencent.mm.ui.chatting.gallery.scan.i)localObject1).aeGS).put(paramView, localObject2);
            paramView = new tm();
            paramView.hXd.hBk = ((i.b)localObject2).hBk;
            paramView.hXd.filePath = ((i.b)localObject2).imagePath;
            paramView.hXd.bitmap = ((i.b)localObject2).bitmap;
            paramView.hXd.hXf = true;
            paramView.hXd.hXg = ((i.b)localObject2).hXg;
            paramView.publish();
          }
        }
      }
    }
    label743:
    AppMethodBeat.o(254611);
  }
  
  private static boolean a(com.tencent.mm.modelvideo.z paramz, cc paramcc)
  {
    AppMethodBeat.i(254737);
    if (paramz == null)
    {
      AppMethodBeat.o(254737);
      return false;
    }
    if ((paramcc == null) || (paramcc.field_isSend == 1))
    {
      AppMethodBeat.o(254737);
      return false;
    }
    paramz = paramz.oYk;
    if (Util.isNullOrNil(paramz))
    {
      AppMethodBeat.o(254737);
      return true;
    }
    com.tencent.mm.modelvideo.z localz = com.tencent.mm.modelvideo.ab.Qo(paramz);
    if (localz == null)
    {
      AppMethodBeat.o(254737);
      return true;
    }
    d locald = d.aeAp;
    paramcc = d.Ai(paramcc.field_msgId);
    if ((paramcc != null) && (!paramcc.mhq))
    {
      AppMethodBeat.o(254737);
      return false;
    }
    if (localz.status == 143)
    {
      AppMethodBeat.o(254737);
      return false;
    }
    if (localz.status != 199)
    {
      AppMethodBeat.o(254737);
      return true;
    }
    v.bOh();
    if (!com.tencent.mm.vfs.y.ZC(com.tencent.mm.modelvideo.aa.PX(paramz)))
    {
      AppMethodBeat.o(254737);
      return true;
    }
    AppMethodBeat.o(254737);
    return false;
  }
  
  private boolean aCO(int paramInt)
  {
    AppMethodBeat.i(254465);
    boolean bool = this.aeDl.aDg(paramInt);
    AppMethodBeat.o(254465);
    return bool;
  }
  
  private void aCQ(int paramInt)
  {
    AppMethodBeat.i(36181);
    cc localcc = this.aeAg.aBV(paramInt);
    if ((localcc == null) || (!localcc.dSI()) || (this.aeAK))
    {
      AppMethodBeat.o(36181);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(new com.tencent.mm.plugin.messenger.foundation.a.a.i.c(localcc.field_talker, "update", localcc));
    AppMethodBeat.o(36181);
  }
  
  private void aCR(int paramInt)
  {
    AppMethodBeat.i(36189);
    Log.i("MicroMsg.ImageGalleryUI", "enterGrid source : ".concat(String.valueOf(paramInt)));
    if (this.aeAg == null)
    {
      Log.w("MicroMsg.ImageGalleryUI", "try to enterGrid, but adapter is NULL");
      AppMethodBeat.o(36189);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 13L, 1L, true);
    int i = this.aeAg.getRealCount();
    if (this.aeAg.jvd() == null)
    {
      Log.e("MicroMsg.ImageGalleryUI", "msgInfo is null");
      AppMethodBeat.o(36189);
      return;
    }
    int j = this.aeAg.aeAC.aCJ(this.HOP.getCurrentItem());
    if (!this.aeDq)
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), MediaHistoryGalleryUI.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("kintent_intent_source", paramInt);
      ((Intent)localObject).putExtra("kintent_talker", jvx());
      ((Intent)localObject).putExtra("kintent_image_count", i);
      ((Intent)localObject).putExtra("kintent_image_index", j);
      ((Intent)localObject).putExtra("key_biz_chat_id", this.vEb);
      ((Intent)localObject).putExtra("key_is_biz_chat", this.Aet);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "enterGrid", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "enterGrid", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(254482);
          ImageGalleryUI.this.finish();
          AppMethodBeat.o(254482);
        }
      }, 50L);
      AppMethodBeat.o(36189);
      return;
    }
    dmJ();
    AppMethodBeat.o(36189);
  }
  
  static Animation aCT(int paramInt)
  {
    AppMethodBeat.i(36199);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(paramInt);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator(10.0F));
    AppMethodBeat.o(36199);
    return localAlphaAnimation;
  }
  
  private void aCW(int paramInt)
  {
    AppMethodBeat.i(36209);
    if (this.XlK != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.XlK.getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, paramInt, 0);
      this.XlK.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(36209);
  }
  
  private void aS(long paramLong, int paramInt)
  {
    AppMethodBeat.i(254770);
    Log.i("MicroMsg.ImageGalleryUI", "dealWithSearchImage sessionId: %s, fromSource: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    cc localcc = this.aeAg.jvd();
    com.tencent.mm.plugin.websearch.api.o localo = new com.tencent.mm.plugin.websearch.api.o();
    localo.sessionId = paramLong;
    localo.context = this;
    localo.hTm = localcc;
    localo.hDy = paramInt;
    ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(localo);
    AppMethodBeat.o(254770);
  }
  
  private void bBk(String paramString)
  {
    AppMethodBeat.i(254602);
    if (this.Ajy == null) {
      this.Ajy = new ImageWordScanDetailEngine(this);
    }
    if (!Util.isNullOrNil(paramString))
    {
      Object localObject = com.tencent.mm.plugin.scanner.util.g.PiK;
      localObject = com.tencent.mm.plugin.scanner.util.g.aVg(paramString);
      if ((localObject != null) && (com.tencent.worddetect.a.qd(((Point)localObject).x, ((Point)localObject).y)))
      {
        Log.i("MicroMsg.ImageGalleryUI", "doScanWordDetectImage image overRatioLimit: %s", new Object[] { localObject });
        this.RdV = ((com.tencent.mm.plugin.scanner.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.scanner.api.c.class)).gPA();
        this.RnK = 1;
        t(0, false, this.RdV);
        AppMethodBeat.o(254602);
        return;
      }
      this.Ajy.a(paramString, this);
      AppMethodBeat.o(254602);
      return;
    }
    this.aeDl.ou(1, 2);
    AppMethodBeat.o(254602);
  }
  
  private e.a bBl(String paramString)
  {
    AppMethodBeat.i(254615);
    int i;
    if ((!Util.isNullOrNil(this.chatroomName)) || (au.bwE(this.talker)))
    {
      i = 1;
      if (i == 0) {
        break label87;
      }
      if (!Util.isNullOrNil(this.chatroomName)) {
        break label79;
      }
    }
    label79:
    for (String str = this.talker;; str = this.chatroomName)
    {
      paramString = new e.a(paramString);
      paramString.sessionType = 2;
      paramString.uWs = str;
      AppMethodBeat.o(254615);
      return paramString;
      i = 0;
      break;
    }
    label87:
    str = this.talker;
    paramString = new e.a(paramString);
    paramString.sessionType = 1;
    paramString.uWs = str;
    AppMethodBeat.o(254615);
    return paramString;
  }
  
  private void bBm(String paramString)
  {
    AppMethodBeat.i(36213);
    paramString = RecordConfigProvider.lj(paramString, "");
    paramString.scene = this.aeDu;
    Object localObject = new UICustomParam.a();
    ((UICustomParam.a)localObject).aQw();
    ((UICustomParam.a)localObject).aQv();
    ((UICustomParam.a)localObject).eL(true);
    paramString.NHR = ((UICustomParam.a)localObject).lZB;
    localObject = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
    com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4369, R.a.sight_slide_bottom_in, -1, paramString, 1, 2);
    AppMethodBeat.o(36213);
  }
  
  private void bn(View paramView, int paramInt)
  {
    AppMethodBeat.i(36156);
    if (paramView != null)
    {
      if ((paramView == jvu().SGO) && (aj.aBu()))
      {
        paramView.setVisibility(8);
        AppMethodBeat.o(36156);
        return;
      }
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(36156);
  }
  
  private void cI(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(254624);
    if ((joe()) || (jvz()))
    {
      AppMethodBeat.o(254624);
      return;
    }
    if ((this.aeAg != null) && (this.aeAg.aBV(this.aeDN) != null) && (!isFinishing()) && (com.tencent.mm.model.bt.T(this.aeAg.aBV(this.aeDN))))
    {
      AppMethodBeat.o(254624);
      return;
    }
    Log.d("MicroMsg.ImageGalleryUI", "alvinluo checkShowQuickButton fromType: %d, needHide: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Object localObject1 = null;
    if (Mo(paramBoolean))
    {
      localObject1 = jvr().aeCX;
      paramInt = 2;
    }
    for (;;)
    {
      int i = this.aeCK;
      Object localObject2;
      label154:
      Object localObject3;
      if (localObject1 != null)
      {
        localObject2 = Float.valueOf(((View)localObject1).getAlpha());
        if (localObject1 == null) {
          break label447;
        }
        localObject3 = Integer.valueOf(((View)localObject1).getVisibility());
        label169:
        Log.i("MicroMsg.ImageGalleryUI", "alvinluo checkShowQuickButton showType: %d, currentQuickButtonType: %d, targetView: %s, targetView.alpha: %s, targetView.visibility: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), localObject1, localObject2, localObject3 });
        if (paramInt == 0) {
          break label465;
        }
        i = this.aeCK;
        if (paramInt != this.aeCK)
        {
          if ((this.aeCK != 0) && ((paramInt != 3) || (localObject1 == null) || (((View)localObject1).getVisibility() == 0))) {
            break label455;
          }
          paramBoolean = true;
          label255:
          this.aeDm = 0;
          J((View)localObject1, paramBoolean);
          int j = jvv().aeCZ.getVisibility();
          cJ(paramInt, false);
          if (this.aeCK == 3)
          {
            bn(jvv().aeCZ, j);
            K(jvv().aeCZ, true);
          }
          this.aeCK = paramInt;
          this.aeCL = ((View)localObject1);
        }
        if (paramInt == 3)
        {
          localObject1 = jvu().SGO;
          if ((i != 0) || (jvn().SGO.getVisibility() == 0)) {
            break label460;
          }
        }
      }
      label447:
      label455:
      label460:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        J((View)localObject1, paramBoolean);
        AppMethodBeat.o(254624);
        return;
        if (Mr(paramBoolean))
        {
          localObject1 = jvv().aeCZ;
          paramInt = 3;
          break;
        }
        if (Mp(paramBoolean))
        {
          localObject1 = this.aeCW;
          paramInt = 1;
          break;
        }
        if (!cK(paramInt, paramBoolean)) {
          break label574;
        }
        paramInt = 4;
        localObject1 = jvu().SGO;
        break;
        localObject2 = "null";
        break label154;
        localObject3 = "null";
        break label169;
        paramBoolean = false;
        break label255;
      }
      label465:
      if (this.aeDl.jwE())
      {
        Log.i("MicroMsg.ImageGalleryUI", "alvinluo checkShowQuickButton isAllValid and hideQuickButton");
        localObject1 = this.aeCL;
        if ((this.aeCK == 0) || (this.aeCL == null)) {
          break label564;
        }
        paramBoolean = true;
        K((View)localObject1, paramBoolean);
        if (this.aeCK == 3)
        {
          localObject1 = jvu().SGO;
          if (jvn().SGO.getVisibility() != 0) {
            break label569;
          }
        }
      }
      label564:
      label569:
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        K((View)localObject1, paramBoolean);
        jvJ();
        AppMethodBeat.o(254624);
        return;
        paramBoolean = false;
        break;
      }
      label574:
      paramInt = 0;
    }
  }
  
  private void cJ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(254638);
    if ((joe()) || (jvz()))
    {
      AppMethodBeat.o(254638);
      return;
    }
    Log.i("MicroMsg.ImageGalleryUI", "alvinluo hideQuickButton showType: %d, withAnimation: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramInt != 2) {
      K(jvr().aeCX, paramBoolean);
    }
    if (paramInt != 3) {
      K(jvv().aeCZ, paramBoolean);
    }
    if (paramInt != 1) {
      K(this.aeCW, paramBoolean);
    }
    if (paramInt != 4) {
      K(jvu().SGO, paramBoolean);
    }
    if (paramInt == 0) {
      jvJ();
    }
    AppMethodBeat.o(254638);
  }
  
  private boolean cK(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(254683);
    if ((!jvL()) || (!com.tencent.mm.ui.chatting.gallery.scan.d.jwB()))
    {
      AppMethodBeat.o(254683);
      return false;
    }
    this.aeDl.ou(4, 2);
    boolean bool = this.aeDl.uB(4);
    Log.i("MicroMsg.ImageGalleryUI", "alvinluo checkShowSearchImageButton fromType: %s, isSearchButtonValid: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    if (bool)
    {
      this.aeDl.ou(4, 1);
      if (this.aeDl.qt(4))
      {
        this.aeDl.aDh(4);
        paramBoolean = Mq(paramBoolean);
        AppMethodBeat.o(254683);
        return paramBoolean;
      }
    }
    AppMethodBeat.o(254683);
    return false;
  }
  
  private boolean cb(Activity paramActivity)
  {
    AppMethodBeat.i(36211);
    paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
    int j = paramActivity.getWidth();
    int k = paramActivity.getHeight();
    if (j < k) {}
    for (int i = 1;; i = 0)
    {
      Log.d("MicroMsg.ImageGalleryUI", "%d is vertical screen orient %d [%d, %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(36211);
      return false;
    }
    AppMethodBeat.o(36211);
    return true;
  }
  
  private boolean cf(ArrayList<ImageQBarDataBean> paramArrayList)
  {
    AppMethodBeat.i(254557);
    if (this.aeDu == 1)
    {
      AppMethodBeat.o(254557);
      return false;
    }
    if ((this.aeDi == null) || (Util.isNullOrNil(this.aeDi.aeHr)))
    {
      AppMethodBeat.o(254557);
      return false;
    }
    if (paramArrayList.size() <= 0)
    {
      AppMethodBeat.o(254557);
      return false;
    }
    if (paramArrayList.size() > 1)
    {
      AppMethodBeat.o(254557);
      return true;
    }
    paramArrayList = ((ImageQBarDataBean)paramArrayList.get(0)).OGQ;
    if (!this.aeDs)
    {
      AppMethodBeat.o(254557);
      return true;
    }
    String[] arrayOfString = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNO, "")).split("\\|");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((!Util.isNullOrNil(str)) && (paramArrayList.startsWith(str)))
        {
          Log.i("MicroMsg.ImageGalleryUI", "curDealQBarStr:%s, blockQrcodeStr:%s", new Object[] { paramArrayList, str });
          AppMethodBeat.o(254557);
          return false;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(254557);
    return true;
  }
  
  private String dRR()
  {
    AppMethodBeat.i(36166);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    cc localcc;
    if (this.aeAg != null)
    {
      localcc = this.aeAg.aBV(this.aeDN);
      if (!h.j(localcc)) {
        break label74;
      }
      com.tencent.mm.modelimage.h localh = this.aeAg.j(localcc, true);
      localObject1 = localObject2;
      if (localh != null) {
        localObject1 = j.a(localcc, localh);
      }
    }
    for (;;)
    {
      localObject1 = Util.nullAsNil((String)localObject1);
      AppMethodBeat.o(36166);
      return localObject1;
      label74:
      localObject1 = localObject2;
      if (h.dh(localcc)) {
        localObject1 = h.l(localcc);
      }
    }
  }
  
  private void dSV()
  {
    int i = 4;
    AppMethodBeat.i(36183);
    Log.i("MicroMsg.ImageGalleryUI", "show video tool bar");
    Mt(true);
    bn(this.aeDa, 4);
    bn(jvo().SGW, 0);
    bn(jvo().XlQ, 0);
    Object localObject = this.aeCM;
    if (this.aeCS) {}
    for (;;)
    {
      bn((View)localObject, i);
      jvS();
      if (this.aeCA) {
        jvH();
      }
      if (this.aeAg != null)
      {
        localObject = this.aeAg.jvd();
        if ((localObject != null) && (((cc)localObject).dSI())) {
          bn(this.XlK, 0);
        }
      }
      AppMethodBeat.o(36183);
      return;
      i = 0;
    }
  }
  
  private void dSf()
  {
    AppMethodBeat.i(254591);
    jvF();
    this.AjF.setRepeatMode(1);
    this.AjF.setRepeatCount(-1);
    this.AjF.start();
    AppMethodBeat.o(254591);
  }
  
  private void dmJ()
  {
    AppMethodBeat.i(36165);
    if ((this.SHh) || (this.aeAg == null))
    {
      Log.i("MicroMsg.ImageGalleryUI", "isRunningExitAnimation");
      AppMethodBeat.o(36165);
      return;
    }
    Ml(true);
    hoc();
    if (this.aeCA)
    {
      finish();
      com.tencent.mm.ui.base.b.ne(getContext());
      AppMethodBeat.o(36165);
      return;
    }
    Log.i("MicroMsg.ImageGalleryUI", "runExitAnimation");
    int k = this.HOP.getWidth() / 2;
    int j = this.HOP.getHeight() / 2;
    this.aeAg.jvc();
    Object localObject1;
    int m;
    int i;
    int n;
    if (!joe())
    {
      if (this.aeDq)
      {
        localObject1 = new ki();
        ((ki)localObject1).hLU.msgId = this.aeAg.aBV(this.HOP.getCurrentItem()).field_msgId;
        ((ki)localObject1).publish();
        m = ((ki)localObject1).hLV.hBL;
        i = ((ki)localObject1).hLV.hBM;
        k = ((ki)localObject1).hLV.hBJ;
        j = ((ki)localObject1).hLV.hBK;
        this.Roe = this.HOP.getWidth();
        this.Rof = this.HOP.getHeight();
        n = i;
        if (this.aeAg.jvd() != null)
        {
          if ((this.aeAg.jvd().dSJ()) || (this.aeAg.jvd().dSH()) || (this.aeAg.jvd().dSI())) {
            this.Rof = ((int)(this.Roe / m * i));
          }
          if (!this.aeAg.jvd().iYk())
          {
            n = i;
            if (!this.aeAg.jvd().jbK()) {}
          }
          else
          {
            localObject1 = (com.tencent.mm.ui.base.i)a(this.aeAg, this.HOP);
            n = i;
            if (localObject1 != null)
            {
              float f = this.Roe / ((com.tencent.mm.ui.base.i)localObject1).getImageWidth();
              this.Rof = ((int)(((com.tencent.mm.ui.base.i)localObject1).getImageHeight() * f));
              n = i;
              if (this.Rof > this.HOP.getHeight())
              {
                n = i;
                if (this.Rof < this.HOP.getHeight() * 1.5D)
                {
                  if (!this.aeDq) {
                    break label880;
                  }
                  this.Rog = (this.Rof - this.HOP.getHeight());
                  n = i;
                }
                label442:
                this.Rof = this.HOP.getHeight();
              }
            }
          }
        }
        this.wAY.oD(this.aeDe, this.aeDf);
        this.wAY.afIk = this.Rog;
        this.wAY.oC(this.Roe, this.Rof);
        this.wAY.af(k, j, m, n);
        localObject1 = this.HOP;
        localObject2 = a(this.aeAg, this.HOP);
        if (localObject2 == null) {
          break label899;
        }
        localObject1 = localObject2;
        if (this.Roh != 1.0D)
        {
          this.wAY.afIg = (1.0F / this.Roh);
          if (this.Roi == 0)
          {
            localObject1 = localObject2;
            if (this.Roj == 0) {}
          }
          else
          {
            i = (int)(this.HOP.getWidth() / 2 * (1.0F - this.Roh));
            j = this.Roi;
            k = (int)(this.HOP.getHeight() / 2 + this.Roj - this.Rof / 2 * this.Roh);
            this.wAY.oE(i + j, k);
            localObject1 = localObject2;
          }
        }
        label649:
        if (this.aeDV) {
          jvI();
        }
        this.wAY.a((View)localObject1, this.pIB, new f.c()
        {
          public final void onAnimationEnd()
          {
            AppMethodBeat.i(254616);
            Log.i("MicroMsg.ImageGalleryUI", "runExitAnimation onAnimationEnd");
            ImageGalleryUI.O(ImageGalleryUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(254592);
                ImageGalleryUI.this.finish();
                ImageGalleryUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.o(254592);
              }
            });
            ImageGalleryUI.c(ImageGalleryUI.this, false);
            AppMethodBeat.o(254616);
          }
          
          public final void onAnimationStart()
          {
            AppMethodBeat.i(254613);
            ImageGalleryUI.c(ImageGalleryUI.this, true);
            new MMHandler().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36124);
                View localView = ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.aeAg, ImageGalleryUI.this.HOP);
                if ((localView != null) && ((localView instanceof com.tencent.mm.ui.base.i)))
                {
                  if ((localView instanceof MultiTouchImageView))
                  {
                    ((MultiTouchImageView)localView).jma();
                    AppMethodBeat.o(36124);
                    return;
                  }
                  if ((localView instanceof WxImageView)) {
                    ((WxImageView)localView).jma();
                  }
                }
                AppMethodBeat.o(36124);
              }
            }, 20L);
            AppMethodBeat.o(254613);
          }
        }, null);
        AppMethodBeat.o(36165);
        return;
      }
      localObject1 = this.aeAg.aBV(this.HOP.getCurrentItem());
      if (localObject1 == null) {
        break label902;
      }
      Object localObject2 = new com.tencent.mm.autogen.a.bt();
      ((com.tencent.mm.autogen.a.bt)localObject2).hBH.hzO = ((cc)localObject1);
      ((com.tencent.mm.autogen.a.bt)localObject2).publish();
      m = ((com.tencent.mm.autogen.a.bt)localObject2).hBI.hBL;
      i = ((com.tencent.mm.autogen.a.bt)localObject2).hBI.hBM;
      k = ((com.tencent.mm.autogen.a.bt)localObject2).hBI.hBJ;
      j = ((com.tencent.mm.autogen.a.bt)localObject2).hBI.hBK;
    }
    for (;;)
    {
      if ((k == 0) && (j == 0))
      {
        k = this.HOP.getWidth() / 2;
        j = this.HOP.getHeight() / 2;
        break;
      }
      if (localObject1 != null)
      {
        if (((fi)localObject1).field_isSend == 0) {
          this.aeDe = com.tencent.mm.cd.a.fromDPToPix(getContext(), 5);
        }
        if (((fi)localObject1).field_isSend == 1) {
          this.aeDf = com.tencent.mm.cd.a.fromDPToPix(getContext(), 5);
        }
      }
      break;
      m = this.wBb;
      i = this.wBc;
      k = this.wBa;
      j = this.wAZ;
      break;
      label880:
      n = this.HOP.getHeight() * i / this.Rof;
      break label442;
      label899:
      break label649;
      label902:
      i = 0;
      m = 0;
    }
  }
  
  private static boolean f(cc paramcc, com.tencent.mm.modelimage.h paramh)
  {
    AppMethodBeat.i(36179);
    if (paramh == null)
    {
      AppMethodBeat.o(36179);
      return false;
    }
    try
    {
      if ((h.c(paramcc, paramh) == 0) && (paramh.bJE()))
      {
        boolean bool = paramcc.isClean();
        if (!bool)
        {
          AppMethodBeat.o(36179);
          return true;
        }
      }
    }
    catch (NullPointerException paramcc)
    {
      Log.e("MicroMsg.ImageGalleryUI", "error:".concat(String.valueOf(paramcc)));
      AppMethodBeat.o(36179);
    }
    return false;
  }
  
  private static int h(com.tencent.mm.modelimage.h paramh)
  {
    AppMethodBeat.i(36187);
    Map localMap = XmlParser.parseXml(paramh.oGC, "msg", null);
    if (localMap == null)
    {
      Log.e("MicroMsg.ImageGalleryUI", "parse cdnInfo failed. [%s]", new Object[] { paramh.oGC });
      AppMethodBeat.o(36187);
      return -1;
    }
    int j = Util.getInt((String)localMap.get(".msg.img.$hdlength"), 0);
    int i = j;
    if (j == 0) {
      i = Util.getInt((String)localMap.get(".msg.img.$tphdlength"), 0);
    }
    AppMethodBeat.o(36187);
    return i;
  }
  
  private void hnZ()
  {
    AppMethodBeat.i(254467);
    this.aeCC = true;
    if (this.HOP != null)
    {
      this.HOP.setEnableGalleryScale(true);
      this.HOP.setSingleMode(false);
    }
    AppMethodBeat.o(254467);
  }
  
  private boolean hoc()
  {
    AppMethodBeat.i(254470);
    hnZ();
    if ((this.RnQ != null) && (this.RnQ.tP(this.RnP)))
    {
      this.RnP = 0L;
      AppMethodBeat.o(254470);
      return true;
    }
    AppMethodBeat.o(254470);
    return false;
  }
  
  private void iBA()
  {
    boolean bool = true;
    AppMethodBeat.i(36196);
    if (this.aeCz.getVisibility() == 0) {}
    for (;;)
    {
      Log.d("MicroMsg.ImageGalleryUI", "fadeOutOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      Animation localAnimation = aCT(150);
      localAnimation.setFillAfter(false);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(254464);
          if (!ImageGalleryUI.as(ImageGalleryUI.this)) {
            ImageGalleryUI.this.jvI();
          }
          AppMethodBeat.o(254464);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.aeCz.clearAnimation();
      this.aeCz.startAnimation(localAnimation);
      AppMethodBeat.o(36196);
      return;
      bool = false;
    }
  }
  
  private void iBC()
  {
    AppMethodBeat.i(36207);
    final View localView = getWindow().getDecorView();
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(254414);
        localView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        ImageGalleryUI.aB(ImageGalleryUI.this);
        AppMethodBeat.o(254414);
      }
    });
    AppMethodBeat.o(36207);
  }
  
  private void iBD()
  {
    AppMethodBeat.i(36208);
    final View localView = getWindow().getDecorView();
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(254419);
        localView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i = com.tencent.mm.cd.a.ms(ImageGalleryUI.this);
        int j = com.tencent.mm.cd.a.mt(ImageGalleryUI.this);
        Log.i("MicroMsg.ImageGalleryUI", "handleHorizontalUI width = %d, height = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if ((i <= j) || ((com.tencent.mm.compatible.util.d.rb(24)) && (ImageGalleryUI.this.isInMultiWindowMode())))
        {
          ImageGalleryUI.aB(ImageGalleryUI.this);
          AppMethodBeat.o(254419);
          return;
        }
        ImageGalleryUI.aC(ImageGalleryUI.this);
        AppMethodBeat.o(254419);
      }
    });
    AppMethodBeat.o(36208);
  }
  
  private boolean joe()
  {
    return this.aedW == 1;
  }
  
  private void jvA()
  {
    AppMethodBeat.i(254511);
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(this, 1, false);
    localf.Vtg = new u.g()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
      {
        AppMethodBeat.i(254609);
        paramAnonymouss.clear();
        cc localcc = ImageGalleryUI.this.aeAg.jvd();
        String str2;
        String str1;
        if ((!com.tencent.mm.model.bt.J(localcc)) && (!com.tencent.mm.model.bt.S(localcc)) && (!com.tencent.mm.model.bt.T(localcc)))
        {
          paramAnonymouss.c(0, ImageGalleryUI.this.getString(R.l.retransmits));
          str2 = ImageGalleryUI.this.getString(R.l.save_to_local);
          if ((!h.j(localcc)) && (!h.dh(localcc))) {
            break label139;
          }
          str1 = ImageGalleryUI.this.getString(R.l.save_img_to_local);
        }
        for (;;)
        {
          if (!localcc.dSI()) {
            paramAnonymouss.c(1, str1);
          }
          paramAnonymouss.a(5, ImageGalleryUI.this.getString(R.l.gxC), R.k.icons_outlined_chats);
          AppMethodBeat.o(254609);
          return;
          label139:
          if (!h.m(localcc))
          {
            str1 = str2;
            if (!h.df(localcc)) {}
          }
          else
          {
            str1 = str2;
            if (!localcc.dSI()) {
              str1 = ImageGalleryUI.this.getString(R.l.save_video_to_local);
            }
          }
        }
      }
    };
    localf.GAC = this.xVp;
    localf.dDn();
    AppMethodBeat.o(254511);
  }
  
  private boolean jvB()
  {
    AppMethodBeat.i(254520);
    if (2 != this.aeDJ.get())
    {
      Log.i("MicroMsg.ImageGalleryUI", "isNeedHideAppBrandEntrance, not scanned");
      AppMethodBeat.o(254520);
      return true;
    }
    if (!aCO(2))
    {
      Log.i("MicroMsg.ImageGalleryUI", "isNeedHideAppBrandEntrance, code not found");
      AppMethodBeat.o(254520);
      return false;
    }
    if (this.aeDi.aeHr.isEmpty())
    {
      AppMethodBeat.o(254520);
      return false;
    }
    Iterator localIterator = this.aeDi.aeHr.iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      Object localObject = (ImageQBarDataBean)localIterator.next();
      int i = ((ImageQBarDataBean)localObject).hDb;
      localObject = ((ImageQBarDataBean)localObject).OGQ;
      if ((com.tencent.mm.plugin.scanner.k.cL(i, (String)localObject)) || (com.tencent.mm.plugin.scanner.k.cN(i, (String)localObject)) || (com.tencent.mm.plugin.scanner.k.cM(i, (String)localObject)) || (com.tencent.mm.plugin.scanner.k.cO(i, (String)localObject)))
      {
        bool = true;
      }
      else if (com.tencent.mm.plugin.scanner.k.cK(i, (String)localObject))
      {
        bool = true;
      }
      else if (com.tencent.mm.plugin.scanner.k.cR(i, (String)localObject))
      {
        bool = true;
      }
      else if (com.tencent.mm.plugin.scanner.k.cQ(i, (String)localObject))
      {
        bool = true;
      }
      else
      {
        if (!e.e.avx(i)) {
          break label229;
        }
        bool = true;
      }
    }
    label229:
    for (;;)
    {
      break;
      AppMethodBeat.o(254520);
      return bool;
    }
  }
  
  private d jvC()
  {
    AppMethodBeat.i(254525);
    if (this.aeDM == null) {
      this.aeDM = new d(this);
    }
    d locald = this.aeDM;
    AppMethodBeat.o(254525);
    return locald;
  }
  
  private void jvD()
  {
    AppMethodBeat.i(254533);
    Log.d("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet");
    if (this.vlk == null)
    {
      Log.w("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, bottomSheet is null");
      AppMethodBeat.o(254533);
      return;
    }
    if ((com.tencent.mm.model.bt.S(this.aeAg.aBV(this.aeDN))) || (com.tencent.mm.model.bt.T(this.aeAg.aBV(this.aeDN))))
    {
      AppMethodBeat.o(254533);
      return;
    }
    Object localObject2 = dRR();
    if (Util.isNullOrNil((String)localObject2))
    {
      if (this.aeAg == null) {
        break label565;
      }
      localObject1 = this.aeAg.aBV(this.aeDN);
      if (!h.m((cc)localObject1)) {
        break label565;
      }
      v.bOh();
    }
    label565:
    for (Object localObject1 = com.tencent.mm.modelvideo.aa.PX(((fi)localObject1).field_imgPath);; localObject1 = null)
    {
      localObject2 = Util.nullAsNil((String)localObject1);
      for (localObject1 = com.tencent.mm.plugin.appbrand.openmaterial.model.b.trY; Util.isNullOrNil((String)localObject2); localObject1 = com.tencent.mm.plugin.appbrand.openmaterial.model.b.trX)
      {
        Log.w("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, curMaterialPath is empty");
        AppMethodBeat.o(254533);
        return;
      }
      Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, curMaterialPath: %s, scene: %s", new Object[] { localObject2, localObject1 });
      com.tencent.mm.plugin.appbrand.service.j localj = (com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.j.class);
      if (localj == null)
      {
        Log.w("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, openMaterialService is null");
        AppMethodBeat.o(254533);
        return;
      }
      if (!localj.c((com.tencent.mm.plugin.appbrand.openmaterial.model.b)localObject1))
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, openMaterialService is not enabled");
        AppMethodBeat.o(254533);
        return;
      }
      if ((com.tencent.mm.plugin.appbrand.openmaterial.model.b.trX == localObject1) && (2 == this.aeDJ.get()) && (jvB()))
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, can not enhance bottomSheet");
        AppMethodBeat.o(254533);
        return;
      }
      if (((String)localObject2).equals(this.aeDK))
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, already fetchOpenMaterials");
        if (this.aeDL == null)
        {
          Log.w("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, cachedOpenMaterialCollection is null");
          AppMethodBeat.o(254533);
          return;
        }
        if (!localj.a(this.vlk, this.aeDL))
        {
          Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, not need enhance");
          AppMethodBeat.o(254533);
          return;
        }
        localObject2 = this.aeAg.jvb();
        if ((localObject2 != null) && (w.aeGm != localObject2))
        {
          if (this.WVA != null) {
            this.WVA.dead();
          }
          this.WVA = localj.a((com.tencent.mm.plugin.appbrand.openmaterial.model.b)localObject1, this, this.vlk, this.aeDL, null, jvC());
          if ((com.tencent.mm.plugin.appbrand.openmaterial.model.b.trX == localObject1) && (jvB()))
          {
            Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, hide enhance bottomSheet");
            this.WVA.a(i.a.trx);
          }
        }
        AppMethodBeat.o(254533);
        return;
      }
      MaterialModel localMaterialModel = MaterialModel.aes((String)localObject2);
      if (localMaterialModel == null)
      {
        Log.w("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, materialModel is null");
        AppMethodBeat.o(254533);
        return;
      }
      if (!localj.aen(localMaterialModel.mimeType))
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, openMaterialService is not support " + localMaterialModel.mimeType);
        AppMethodBeat.o(254533);
        return;
      }
      localj.a(localMaterialModel, new a(this, (String)localObject2, localj, (com.tencent.mm.plugin.appbrand.openmaterial.model.b)localObject1));
      AppMethodBeat.o(254533);
      return;
    }
  }
  
  private boolean jvE()
  {
    AppMethodBeat.i(36168);
    if (this.aeDs)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if (this.aeDu == 1)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if (this.aeAK)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if ((!this.aewt) && (!this.Aet) && (!n.a.jvm().Ano))
    {
      AppMethodBeat.o(36168);
      return true;
    }
    AppMethodBeat.o(36168);
    return false;
  }
  
  private void jvF()
  {
    AppMethodBeat.i(254569);
    this.AjC.setVisibility(0);
    this.AjD.setVisibility(0);
    this.AjE.setVisibility(0);
    jvH();
    AppMethodBeat.o(254569);
  }
  
  private void jvJ()
  {
    this.aeCK = 0;
    this.aeCL = null;
  }
  
  private void jvK()
  {
    int k = 8;
    int j = 1;
    AppMethodBeat.i(254647);
    if ((joe()) || (jvz()))
    {
      AppMethodBeat.o(254647);
      return;
    }
    View localView = this.aeCU;
    int i;
    if (this.aeCS)
    {
      i = 8;
      bn(localView, i);
      localView = jvp().aeCT;
      i = k;
      if (this.aeDp)
      {
        i = k;
        if (!this.aeCS) {
          i = 0;
        }
      }
      bn(localView, i);
      k = this.aeCE;
      if (this.aeCS) {
        break label140;
      }
      i = 1;
      label105:
      if ((!this.aeDp) || (this.aeCS)) {
        break label145;
      }
    }
    for (;;)
    {
      this.aeCE = (i + j + k);
      AppMethodBeat.o(254647);
      return;
      i = 0;
      break;
      label140:
      i = 0;
      break label105;
      label145:
      j = 0;
    }
  }
  
  private boolean jvL()
  {
    return (this.aewu) || (this.aeDq);
  }
  
  private void jvM()
  {
    AppMethodBeat.i(254678);
    if (jvv().aeCZ.getVisibility() == 0) {
      Mr(true);
    }
    AppMethodBeat.o(254678);
  }
  
  private int jvN()
  {
    if (this.aeDt == 0)
    {
      locala = com.tencent.mm.plugin.webview.ui.tools.media.a.XlE;
      return 2;
    }
    if (this.aeDt == 1)
    {
      locala = com.tencent.mm.plugin.webview.ui.tools.media.a.XlE;
      return 4;
    }
    com.tencent.mm.plugin.webview.ui.tools.media.a locala = com.tencent.mm.plugin.webview.ui.tools.media.a.XlE;
    return 1;
  }
  
  private int jvO()
  {
    if (this.aeCB) {
      return 3;
    }
    return 4;
  }
  
  private boolean jvP()
  {
    return this.aeCy == h.b.aeBj;
  }
  
  private boolean jvQ()
  {
    return (this.aeCy == h.b.aeBi) || (this.aeCy == h.b.aeBl);
  }
  
  private void jvS()
  {
    AppMethodBeat.i(254727);
    cc localcc = this.aeAg.jvd();
    com.tencent.mm.modelvideo.z localz = com.tencent.mm.modelvideo.ab.Qo(localcc.field_imgPath);
    Object localObject;
    ae localae;
    if ((localz != null) && (this.aeCO.getVisibility() != 0))
    {
      localObject = ae.pbN;
      localae = ae.a.Qv(localz.bOu());
      if ((localae == null) || (Util.isNullOrNil(localae.pbQ)) || (!a(localz, localcc))) {
        break label288;
      }
      if (cn.bDu() - localcc.getCreateTime() <= 432000000L) {
        break label181;
      }
      this.aeCN.setText(getString(R.l.gRl));
      this.aeCN.setEnabled(false);
      if (this.cpD != null)
      {
        this.aeCN.setGravity(16);
        this.aeCN.setCompoundDrawables(this.cpD, null, null, null);
      }
      bn(this.aeCN, 0);
    }
    for (;;)
    {
      if ((localcc != null) && (localcc.isClean())) {
        bn(this.aeCN, 8);
      }
      AppMethodBeat.o(254727);
      return;
      label181:
      String str = (String)this.aeDW.get(Long.valueOf(localz.pbc));
      localObject = str;
      if (str == null)
      {
        localObject = Am(localae.pbT);
        this.aeDW.put(Long.valueOf(localz.pbc), localObject);
      }
      this.aeCN.setGravity(17);
      this.aeCN.setCompoundDrawables(null, null, null, null);
      this.aeCN.setEnabled(true);
      this.aeCN.setText(getString(R.l.gXG, new Object[] { localObject }));
      break;
      label288:
      if (k(localz))
      {
        this.aeCN.setText(getString(R.l.gRm));
        this.aeCN.setEnabled(false);
        if (this.cpD != null)
        {
          this.aeCN.setGravity(16);
          this.aeCN.setCompoundDrawables(this.cpD, null, null, null);
        }
        bn(this.aeCN, 0);
        if (this.aeCP.getVisibility() == 0)
        {
          this.aeCP.clearAnimation();
          this.aeCP.setVisibility(8);
        }
      }
      else
      {
        bn(this.aeCN, 8);
      }
    }
  }
  
  private void jvT()
  {
    boolean bool = true;
    AppMethodBeat.i(36197);
    if (this.aeCz.getVisibility() == 0) {}
    for (;;)
    {
      Log.d("MicroMsg.ImageGalleryUI", "fadeInOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      this.aeCz.clearAnimation();
      this.aeCz.startAnimation(jvU());
      AppMethodBeat.o(36197);
      return;
      bool = false;
    }
  }
  
  private static Animation jvU()
  {
    AppMethodBeat.i(36198);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(150L);
    localAlphaAnimation.setFillAfter(true);
    AppMethodBeat.o(36198);
    return localAlphaAnimation;
  }
  
  private void jvY()
  {
    AppMethodBeat.i(36210);
    if (this.XlK != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.XlK.getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, 0, 0);
      this.XlK.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(36210);
  }
  
  private void jvZ()
  {
    AppMethodBeat.i(36212);
    cc localcc = this.aeAg.jvd();
    String str = j.a(localcc, j.k(localcc));
    Log.i("MicroMsg.ImageGalleryUI", "edit image path:%s msgId:%s", new Object[] { str, Long.valueOf(localcc.field_msgId) });
    bBm(str);
    AppMethodBeat.o(36212);
  }
  
  private ImageGalleryUI jvp()
  {
    AppMethodBeat.i(36154);
    if (this.aeCT == null) {
      this.aeCT = findViewById(R.h.fGH);
    }
    AppMethodBeat.o(36154);
    return this;
  }
  
  private ImageGalleryUI jvq()
  {
    AppMethodBeat.i(36155);
    if (this.aeCV == null) {
      this.aeCV = findViewById(R.h.fGb);
    }
    AppMethodBeat.o(36155);
    return this;
  }
  
  private ImageGalleryUI jvr()
  {
    AppMethodBeat.i(254450);
    if (this.aeCX == null) {
      this.aeCX = findViewById(R.h.fIZ);
    }
    AppMethodBeat.o(254450);
    return this;
  }
  
  private ImageGalleryUI jvs()
  {
    AppMethodBeat.i(254452);
    if (this.aeCY == null) {
      this.aeCY = findViewById(R.h.scan_success_dot_view);
    }
    AppMethodBeat.o(254452);
    return this;
  }
  
  private ImageGalleryUI jvt()
  {
    AppMethodBeat.i(254455);
    if (this.RnL == null)
    {
      this.RnL = ((MultiCodeMaskView)findViewById(R.h.multi_code_mask_view));
      this.RnL.setOnMultiCodeMaskViewListener(new MultiCodeMaskView.b()
      {
        public final void a(ArrayList<ImageQBarDataBean> paramAnonymousArrayList, ImageQBarDataBean paramAnonymousImageQBarDataBean, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(254430);
          if (ImageGalleryUI.y(ImageGalleryUI.this) != null) {
            ImageGalleryUI.y(ImageGalleryUI.this).a(ImageGalleryUI.d(ImageGalleryUI.this), paramAnonymousImageQBarDataBean, ImageGalleryUI.z(ImageGalleryUI.this));
          }
          if (paramAnonymousBoolean) {}
          for (int i = 1;; i = 2)
          {
            com.tencent.mm.plugin.scanner.j localj = com.tencent.mm.plugin.scanner.j.OGP;
            com.tencent.mm.plugin.scanner.j.a(ImageGalleryUI.w(ImageGalleryUI.this).longValue(), i, paramAnonymousArrayList, paramAnonymousImageQBarDataBean, ImageGalleryUI.x(ImageGalleryUI.this).longValue(), ImageGalleryUI.d(ImageGalleryUI.this).aeHu);
            AppMethodBeat.o(254430);
            return;
          }
        }
        
        public final void aF(ArrayList<ImageQBarDataBean> paramAnonymousArrayList)
        {
          AppMethodBeat.i(254427);
          com.tencent.mm.plugin.scanner.j localj = com.tencent.mm.plugin.scanner.j.OGP;
          com.tencent.mm.plugin.scanner.j.a(ImageGalleryUI.w(ImageGalleryUI.this).longValue(), 3, paramAnonymousArrayList, null, ImageGalleryUI.x(ImageGalleryUI.this).longValue(), ImageGalleryUI.d(ImageGalleryUI.this).aeHu);
          AppMethodBeat.o(254427);
        }
      });
    }
    AppMethodBeat.o(254455);
    return this;
  }
  
  private ImageGalleryUI jvu()
  {
    AppMethodBeat.i(254458);
    if (this.SGO == null) {
      this.SGO = findViewById(R.h.fJa);
    }
    AppMethodBeat.o(254458);
    return this;
  }
  
  private ImageGalleryUI jvv()
  {
    AppMethodBeat.i(254460);
    if (this.aeCZ == null) {
      this.aeCZ = ((SearchImageBubbleView)findViewById(R.h.fVx));
    }
    AppMethodBeat.o(254460);
    return this;
  }
  
  private void jvw()
  {
    int i = 2;
    AppMethodBeat.i(254463);
    boolean bool1 = aCO(1);
    boolean bool2 = aCO(2);
    if ((bool1) && (bool2)) {
      i = 4;
    }
    for (;;)
    {
      this.aeDA.aDa(i);
      AppMethodBeat.o(254463);
      return;
      if (bool1) {
        i = 3;
      } else if (!bool2) {
        i = 1;
      }
    }
  }
  
  private String jvx()
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
  
  private boolean jvz()
  {
    AppMethodBeat.i(254487);
    this.aedW = getIntent().getIntExtra("msg_type", 0);
    if (this.aedW == 2)
    {
      AppMethodBeat.o(254487);
      return true;
    }
    AppMethodBeat.o(254487);
    return false;
  }
  
  protected static com.tencent.mm.modelimage.h k(cc paramcc)
  {
    AppMethodBeat.i(369650);
    paramcc = j.k(paramcc);
    AppMethodBeat.o(369650);
    return paramcc;
  }
  
  private static boolean k(com.tencent.mm.modelvideo.z paramz)
  {
    AppMethodBeat.i(254731);
    if (paramz == null)
    {
      AppMethodBeat.o(254731);
      return false;
    }
    paramz = com.tencent.mm.modelvideo.ab.Qo(paramz.oYk);
    if (paramz == null)
    {
      AppMethodBeat.o(254731);
      return false;
    }
    if (paramz.status == 143)
    {
      AppMethodBeat.o(254731);
      return true;
    }
    AppMethodBeat.o(254731);
    return false;
  }
  
  private static String l(cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(254474);
    if (paramcc.field_isSend == 1)
    {
      paramcc = com.tencent.mm.model.z.bAM();
      AppMethodBeat.o(254474);
      return paramcc;
    }
    if (paramBoolean)
    {
      paramcc = br.JJ(paramcc.field_content);
      AppMethodBeat.o(254474);
      return paramcc;
    }
    paramcc = paramcc.field_talker;
    AppMethodBeat.o(254474);
    return paramcc;
  }
  
  private void m(cc paramcc, boolean paramBoolean)
  {
    int k = 1;
    AppMethodBeat.i(254653);
    if (this.aeCy != h.b.aeBi) {}
    for (int i = 0;; i = 1)
    {
      if ((com.tencent.mm.model.bt.F(paramcc)) || (com.tencent.mm.model.bt.N(paramcc)) || (com.tencent.mm.model.bt.S(paramcc)) || (com.tencent.mm.model.bt.T(paramcc))) {
        i = 0;
      }
      if ((joe()) || (jvz())) {
        i = 0;
      }
      paramcc = jvq().aeCV;
      label97:
      int j;
      if (paramBoolean) {
        if (i != 0) {
          if (paramcc.getVisibility() != 0)
          {
            paramBoolean = true;
            J(paramcc, paramBoolean);
            j = this.aeCE;
            if (i == 0) {
              break label163;
            }
          }
        }
      }
      label163:
      for (i = k;; i = 0)
      {
        this.aeCE = (j + i);
        AppMethodBeat.o(254653);
        return;
        paramBoolean = false;
        break;
        K(paramcc, true);
        break label97;
        if (i != 0) {}
        for (j = 0;; j = 8)
        {
          bn(paramcc, j);
          break;
        }
      }
    }
  }
  
  private void t(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 3;
    AppMethodBeat.i(254446);
    if (paramBoolean1)
    {
      final boolean bool = com.tencent.mm.plugin.scanner.n.ahG(paramInt);
      if (this.aeDl.aDe(1) == 5)
      {
        this.aeDl.ou(1, 3);
        cI(1, false);
        AppMethodBeat.o(254446);
        return;
      }
      com.tencent.mm.ui.chatting.gallery.scan.f localf = this.aeDl;
      paramInt = i;
      if (bool) {
        paramInt = 1;
      }
      localf.ou(1, paramInt);
      this.aeDl.e(1, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(254434);
          if (bool)
          {
            ImageGalleryUI.b(ImageGalleryUI.this, true);
            ImageGalleryUI.a(ImageGalleryUI.this, 1);
          }
          AppMethodBeat.o(254434);
        }
      });
      if (!bool) {
        cI(1, false);
      }
    }
    for (;;)
    {
      if (((paramBoolean2) || (paramBoolean1)) && (this.vlk != null) && (this.vlk.isShowing())) {
        cxQ();
      }
      AppMethodBeat.o(254446);
      return;
      this.aeDl.ou(1, 2);
      cI(1, false);
    }
  }
  
  public final int An(long paramLong)
  {
    AppMethodBeat.i(36204);
    if (Util.isNullOrNil(this.aeDw))
    {
      AppMethodBeat.o(36204);
      return 0;
    }
    try
    {
      int j = com.tencent.mm.modelvideo.ab.i(paramLong, this.aeDw);
      int i = j;
      if (j == -1)
      {
        this.aeDw = null;
        i = 0;
      }
      Log.d("MicroMsg.ImageGalleryUI", "get enter video op code %d %s", new Object[] { Integer.valueOf(i), this.aeDw });
      AppMethodBeat.o(36204);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ImageGalleryUI", "get enter video op code error : " + localException.toString());
      AppMethodBeat.o(36204);
    }
    return 0;
  }
  
  public final void Ao(long paramLong)
  {
    AppMethodBeat.i(36205);
    if ((Util.isNullOrNil(this.aeDw)) || (paramLong == 0L))
    {
      AppMethodBeat.o(36205);
      return;
    }
    if (this.aeDx)
    {
      this.aeDw = com.tencent.mm.modelvideo.ab.o(paramLong, 3);
      Log.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[] { this.aeDw });
      AppMethodBeat.o(36205);
      return;
    }
    if (com.tencent.mm.modelvideo.ab.i(paramLong, this.aeDw) == -1)
    {
      this.aeDw = null;
      Log.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[] { this.aeDw });
    }
    AppMethodBeat.o(36205);
  }
  
  public final void aCP(int paramInt)
  {
    AppMethodBeat.i(36180);
    n(this.aeAg.aBV(paramInt), false);
    AppMethodBeat.o(36180);
  }
  
  public final void aCS(final int paramInt)
  {
    AppMethodBeat.i(36194);
    if (jvo().SGW == null)
    {
      AppMethodBeat.o(36194);
      return;
    }
    jvo().SGW.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(254466);
        if (ImageGalleryUI.this.aeAg == null)
        {
          AppMethodBeat.o(254466);
          return;
        }
        h localh = ImageGalleryUI.this.aeAg;
        int i = paramInt;
        localh.aeAH.aCx(i);
        AppMethodBeat.o(254466);
      }
    });
    AppMethodBeat.o(36194);
  }
  
  public final void aCU(int paramInt)
  {
    AppMethodBeat.i(36200);
    dSU();
    Mn(false);
    jvn().aeDa.setVisibility(0);
    jvn().aeDb.setVisibility(8);
    jvn().aeDc.setVisibility(0);
    jvn().aeDd.setVisibility(8);
    jvn().aeDc.setText(paramInt + "%");
    AppMethodBeat.o(36200);
  }
  
  public final void aCV(final int paramInt)
  {
    AppMethodBeat.i(255273);
    com.tencent.mm.plugin.gallery.model.e.fAo().postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(254435);
        if (ImageGalleryUI.at(ImageGalleryUI.this))
        {
          AppMethodBeat.o(254435);
          return;
        }
        int i = paramInt;
        if (i >= 100) {
          i = 99;
        }
        for (;;)
        {
          ImageGalleryUI.this.jvG();
          ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.au(ImageGalleryUI.this), 8);
          Object localObject = ImageGalleryUI.av(ImageGalleryUI.this).getDisplay();
          if ((localObject != null) && (((Display)localObject).getRotation() != 0) && (((Display)localObject).getRotation() != 2) && (ImageGalleryUI.ak(ImageGalleryUI.this).getVisibility() != 0))
          {
            localObject = (RelativeLayout.LayoutParams)ImageGalleryUI.this.SGW.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject).addRule(1, R.h.gbZ);
            ImageGalleryUI.this.SGW.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.ak(ImageGalleryUI.this), 0);
          ImageGalleryUI.ak(ImageGalleryUI.this).setText(ImageGalleryUI.this.getString(R.l.gXH, new Object[] { i + "%" }));
          AppMethodBeat.o(254435);
          return;
        }
      }
    });
    AppMethodBeat.o(255273);
  }
  
  public final void bBj(String paramString)
  {
    AppMethodBeat.i(255213);
    this.aeCS = true;
    if (!Util.isNullOrNil(paramString))
    {
      this.aeCR.setMessage(paramString);
      paramString = this.aeCR;
      paramString.vfR.setVisibility(8);
      paramString.Xxy.setVisibility(0);
    }
    this.aeCR.setVisibility(0);
    AppMethodBeat.o(255213);
  }
  
  protected final void cxQ()
  {
    AppMethodBeat.i(255226);
    int i = this.aeDN;
    if (this.aeAg == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.ImageGalleryUI", "showMenu mSelectedPos %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      if (this.aeAg != null) {
        break;
      }
      AppMethodBeat.o(255226);
      return;
    }
    if (this.aeDN < 0)
    {
      AppMethodBeat.o(255226);
      return;
    }
    if (this.aeAg.aBV(this.aeDN) == null) {}
    for (final cc localcc = this.aeAg.jvd(); localcc == null; localcc = this.aeAg.aBV(this.aeDN))
    {
      Log.i("MicroMsg.ImageGalleryUI", "showMenu msg is null");
      AppMethodBeat.o(255226);
      return;
    }
    if (com.tencent.mm.model.bt.H(localcc))
    {
      jvA();
      AppMethodBeat.o(255226);
      return;
    }
    i = this.aeAg.aeAG.dr(localcc);
    if ((i == 5) || (i == 6))
    {
      Log.w("MicroMsg.ImageGalleryUI", "jacks fail downloaded img, return");
      AppMethodBeat.o(255226);
      return;
    }
    if (this.aeAg.dj(localcc))
    {
      Log.w("MicroMsg.ImageGalleryUI", "jacks downloading, return");
      AppMethodBeat.o(255226);
      return;
    }
    if (h.m(localcc))
    {
      if ((p.dd(localcc) == null) && (!localcc.dSI()))
      {
        Log.w("MicroMsg.ImageGalleryUI", "video info is null, return now.");
        AppMethodBeat.o(255226);
        return;
      }
      if (localcc.dSI())
      {
        com.tencent.mm.plugin.webview.ui.tools.media.a locala = com.tencent.mm.plugin.webview.ui.tools.media.a.XlE;
        com.tencent.mm.plugin.webview.ui.tools.media.a.nv(jvO(), jvN());
      }
    }
    if (this.vlk == null) {
      this.vlk = new com.tencent.mm.ui.widget.a.f(getContext(), 0, true);
    }
    if ((com.tencent.mm.model.bt.F(localcc)) && (!joe())) {
      if (jvE()) {
        this.vlk.GAz = new u.g()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
          {
            AppMethodBeat.i(254606);
            paramAnonymouss.clear();
            paramAnonymouss.a(5, ImageGalleryUI.this.getString(R.l.gxC), R.k.icons_outlined_chats);
            AppMethodBeat.o(254606);
          }
        };
      }
    }
    for (;;)
    {
      this.vlk.GAC = this.xVp;
      this.vlk.agem = this.xVp;
      this.vlk.ageq = this.xVp;
      this.vlk.aeLi = new f.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(254597);
          ImageGalleryUI.ab(ImageGalleryUI.this);
          ImageGalleryUI.i(ImageGalleryUI.this).onDismiss();
          e.c localc = ImageGalleryUI.m(ImageGalleryUI.this).aeGz;
          if (localc != null) {
            localc.aeGH.put("1,2", Boolean.FALSE);
          }
          ImageGalleryUI.aa(ImageGalleryUI.this).reset();
          ImageGalleryUI.d(ImageGalleryUI.this).aeHs = null;
          ImageGalleryUI.d(ImageGalleryUI.this).aeHt = null;
          AppMethodBeat.o(254597);
        }
      };
      this.vlk.ages = new f.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(254588);
          if (ImageGalleryUI.this.aeAg == null)
          {
            AppMethodBeat.o(254588);
            return;
          }
          Object localObject = ImageGalleryUI.this.aeAg.jvd();
          if ((localObject != null) && (((cc)localObject).dSI()))
          {
            localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.XlE;
            com.tencent.mm.plugin.webview.ui.tools.media.a.bs(3, ImageGalleryUI.ac(ImageGalleryUI.this), ImageGalleryUI.ad(ImageGalleryUI.this));
          }
          AppMethodBeat.o(254588);
        }
      };
      this.vlk.dDn();
      AppMethodBeat.o(255226);
      return;
      if (com.tencent.mm.model.bt.O(localcc))
      {
        AppMethodBeat.o(255226);
        return;
      }
      jvD();
      this.vlk.Vtg = new u.g()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
        {
          AppMethodBeat.i(254608);
          paramAnonymouss.clear();
          if (com.tencent.mm.model.bt.T(localcc))
          {
            AppMethodBeat.o(254608);
            return;
          }
          if ((!com.tencent.mm.model.bt.N(localcc)) && (!com.tencent.mm.model.bt.S(localcc)))
          {
            paramAnonymouss.a(0, ImageGalleryUI.this.getString(R.l.retransmits), R.k.icons_filled_share, ImageGalleryUI.this.getResources().getColor(R.e.Brand));
            if ((localcc != null) && (localcc.dSI()) && (com.tencent.mm.pluginsdk.ui.tools.aa.iOM())) {
              paramAnonymouss.a(10, ImageGalleryUI.this.getString(R.l.readerapp_alert_share_to_timeline), R.k.bottomsheet_icon_moment, 0);
            }
          }
          if (com.tencent.mm.br.c.blq("favorite")) {
            paramAnonymouss.a(2, ImageGalleryUI.this.getString(R.l.plugin_favorite_opt), R.k.bottomsheet_icon_fav, 0);
          }
          if ((((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch()) && (h.j(localcc)) && (!aj.aBu()))
          {
            paramAnonymouss.a(11, ImageGalleryUI.this.getString(R.l.gyE), R.k.icons_filled_search_logo, ImageGalleryUI.this.getResources().getColor(R.e.Red));
            com.tencent.threadpool.h.ahAA.bm(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(254729);
                ImageGalleryUI.m(ImageGalleryUI.this).aDd(2);
                AppMethodBeat.o(254729);
              }
            });
          }
          AppMethodBeat.o(254608);
        }
      };
      this.vlk.GAz = new u.g()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
        {
          AppMethodBeat.i(254607);
          paramAnonymouss.clear();
          if (com.tencent.mm.model.bt.T(localcc))
          {
            if ((ImageGalleryUI.V(ImageGalleryUI.this)) && (!ImageGalleryUI.W(ImageGalleryUI.this)) && (!au.bwZ(ImageGalleryUI.this.talker))) {
              paramAnonymouss.a(5, ImageGalleryUI.this.getString(R.l.gxC), R.k.icons_outlined_chats);
            }
            AppMethodBeat.o(254607);
            return;
          }
          Object localObject;
          if ((!com.tencent.mm.model.bt.N(localcc)) && (!com.tencent.mm.model.bt.S(localcc)))
          {
            localObject = null;
            if ((!h.j(localcc)) && (!h.dh(localcc))) {
              break label567;
            }
            localObject = ImageGalleryUI.this.getString(R.l.save_img_to_local);
            if (!localcc.dSI()) {
              paramAnonymouss.a(1, (CharSequence)localObject, R.k.icons_outlined_download);
            }
          }
          if ((h.j(localcc)) && (ImageGalleryUI.X(ImageGalleryUI.this))) {
            paramAnonymouss.a(6, ImageGalleryUI.this.getString(R.l.chatting_image_long_click_photo_edit), R.k.icons_outlined_pencil);
          }
          if ((ImageGalleryUI.V(ImageGalleryUI.this)) && (!ImageGalleryUI.W(ImageGalleryUI.this)) && (!au.bwZ(ImageGalleryUI.this.talker))) {
            paramAnonymouss.a(5, ImageGalleryUI.this.getString(R.l.gxC), R.k.icons_outlined_chats);
          }
          long l;
          if (((com.tencent.mm.plugin.scanner.n.gPv()) || (ImageGalleryUI.d(ImageGalleryUI.this, 1))) && (!Util.isNullOrNil(ImageGalleryUI.a(ImageGalleryUI.this))))
          {
            paramAnonymouss.a(7, ImageGalleryUI.this.getString(R.l.chatting_image_long_click_photo_trans_short), R.k.icons_outlined_translate);
            localObject = new hj();
            if (ImageGalleryUI.u(ImageGalleryUI.this) == 2)
            {
              l = 1L;
              label317:
              ((hj)localObject).iqr = l;
              ((hj)localObject).ikE = 2L;
              ((hj)localObject).iOd = 4L;
              com.tencent.mm.modelimage.h localh = ImageGalleryUI.k(ImageGalleryUI.this.aeAg.jvd());
              if (localh != null)
              {
                ((hj)localObject).rq(localh.getFileId());
                ((hj)localObject).rr(localh.getAesKey());
              }
              ((hj)localObject).bMH();
            }
          }
          else if (ImageGalleryUI.Y(ImageGalleryUI.this))
          {
            paramAnonymouss.a(12, ImageGalleryUI.this.getString(R.l.chatting_image_long_click_image_ocr), R.k.icons_outlined_ocr);
            boolean bool = au.bwE(localcc.field_talker);
            localObject = ImageGalleryUI.aa(ImageGalleryUI.this);
            if (!bool) {
              break label632;
            }
          }
          label567:
          label632:
          for (int i = 2;; i = 1)
          {
            ((com.tencent.mm.plugin.scanner.api.a.b)localObject).aZ(2, i, ImageGalleryUI.Z(ImageGalleryUI.this));
            if ((h.j(localcc)) || (h.df(localcc)))
            {
              localObject = new ex();
              ((ex)localObject).hFc.msgId = localcc.field_msgId;
              ((ex)localObject).publish();
              if ((((ex)localObject).hFd.hEn) || (com.tencent.mm.pluginsdk.model.app.h.bj(ImageGalleryUI.this.getContext(), localcc.getType()))) {
                paramAnonymouss.a(4, ImageGalleryUI.this.getString(R.l.gyu), R.k.icons_outlined_open);
              }
            }
            AppMethodBeat.o(254607);
            return;
            if ((h.m(localcc)) || (h.df(localcc)))
            {
              if (localcc.dSI()) {
                break;
              }
              localObject = ImageGalleryUI.this.getString(R.l.save_video_to_local);
              break;
            }
            localObject = ImageGalleryUI.this.getString(R.l.save_to_local);
            break;
            l = 0L;
            break label317;
          }
        }
      };
      this.vlk.agel = new u.g()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
        {
          AppMethodBeat.i(254601);
          paramAnonymouss.clear();
          if ((ImageGalleryUI.d(ImageGalleryUI.this, 2)) && (ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.d(ImageGalleryUI.this).aeHr))) {
            ImageGalleryUI.i(ImageGalleryUI.this).a(ImageGalleryUI.d(ImageGalleryUI.this).aeHr, ImageGalleryUI.d(ImageGalleryUI.this).aeHs, ImageGalleryUI.f(ImageGalleryUI.this), paramAnonymouss, 3);
          }
          AppMethodBeat.o(254601);
        }
      };
    }
  }
  
  public final void dSU()
  {
    AppMethodBeat.i(36184);
    Log.i("MicroMsg.ImageGalleryUI", "hide video tool bar");
    Mt(false);
    bn(jvo().SGW, 8);
    bn(jvo().XlQ, 8);
    bn(this.aeCM, 8);
    bn(this.XlK, 8);
    bn(this.aeCN, 8);
    AppMethodBeat.o(36184);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(36195);
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
    {
      if (this.vlk != null)
      {
        this.vlk.cyW();
        this.vlk = null;
      }
      for (;;)
      {
        AppMethodBeat.o(36195);
        return true;
        if ((this.AjA == 0) || (this.AjA == 2)) {
          cxQ();
        } else {
          cxQ();
        }
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(36195);
    return bool;
  }
  
  public void finish()
  {
    AppMethodBeat.i(36203);
    this.aeqJ.clear();
    super.finish();
    AppMethodBeat.o(36203);
  }
  
  public final boolean fjy()
  {
    AppMethodBeat.i(36193);
    boolean bool = jvo().SGW.dxE();
    AppMethodBeat.o(36193);
    return bool;
  }
  
  public final int getCurrentItem()
  {
    AppMethodBeat.i(369652);
    int i = this.HOP.getCurrentItem();
    AppMethodBeat.o(369652);
    return i;
  }
  
  public int getForceOrientation()
  {
    return 2;
  }
  
  public int getLayoutId()
  {
    return R.i.gkw;
  }
  
  public void initView()
  {
    AppMethodBeat.i(36163);
    this.wAY = new com.tencent.mm.ui.tools.f(getContext());
    this.isAnimated = false;
    this.talker = getIntent().getStringExtra("img_gallery_talker");
    this.aeDq = getIntent().getBooleanExtra("img_gallery_enter_from_grid", false);
    this.aewu = getIntent().getBooleanExtra("img_gallery_enter_from_chatting_ui", false);
    this.aeDs = getIntent().getBooleanExtra("img_gallery_enter_from_appbrand_service_chatting_ui", false);
    this.aewt = getIntent().getBooleanExtra("show_search_chat_content_result", false);
    this.aeDp = getIntent().getBooleanExtra("show_enter_grid", true);
    this.Aet = getIntent().getBooleanExtra("key_is_biz_chat", false);
    this.vEb = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.aeCA = getIntent().getBooleanExtra("img_preview_only", false);
    this.aeDu = getIntent().getIntExtra("img_gallery_enter_from_scene", 0);
    this.aedW = getIntent().getIntExtra("msg_type", 0);
    if ((!this.aeCA) && (Util.isNullOrNil(this.talker))) {
      Log.e("MicroMsg.ImageGalleryUI", " initView, talker is null. intent: " + getIntent());
    }
    this.chatroomName = getIntent().getStringExtra("img_gallery_chatroom_name");
    this.aeDr = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
    this.aeDw = getIntent().getStringExtra("img_gallery_enter_video_opcode");
    boolean bool2 = getIntent().getBooleanExtra("img_gallery_is_restransmit_after_download", false);
    Object localObject2 = getIntent().getStringExtra("img_gallery_directly_send_name");
    this.AjD = ((ImageView)findViewById(R.h.scan_translate_layer));
    this.AjE = ((ImageView)findViewById(R.h.scan_translate_close_btn));
    Object localObject1 = (FrameLayout.LayoutParams)this.AjE.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject1).bottomMargin += com.tencent.mm.ui.bf.bk(this);
    this.AjE.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.AjE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(254692);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((ImageGalleryUI.B(ImageGalleryUI.this) != null) && (!ImageGalleryUI.B(ImageGalleryUI.this).gPD())) {
          ImageGalleryUI.C(ImageGalleryUI.this);
        }
        paramAnonymousView = new bg();
        paramAnonymousView.hBl.scene = 1;
        paramAnonymousView.hBl.hBm = ImageGalleryUI.D(ImageGalleryUI.this);
        paramAnonymousView.publish();
        ImageGalleryUI.v(ImageGalleryUI.this);
        ImageGalleryUI.E(ImageGalleryUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(254692);
      }
    });
    this.AjC = ((ImageView)findViewById(R.h.scan_translate_line));
    this.AjF = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.AjF.setDuration(5000L);
    this.AjF.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(254628);
        ImageGalleryUI.M(ImageGalleryUI.this).setAlpha(0.0F);
        AppMethodBeat.o(254628);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(254625);
        ImageGalleryUI.M(ImageGalleryUI.this).setAlpha(0.0F);
        AppMethodBeat.o(254625);
      }
    });
    final int i = getWindowManager().getDefaultDisplay().getHeight();
    this.AjF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(254618);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f <= 0.1F) {
          ImageGalleryUI.M(ImageGalleryUI.this).setAlpha(f * 10.0F);
        }
        for (;;)
        {
          ImageGalleryUI.M(ImageGalleryUI.this).setTranslationY(f * (i - ImageGalleryUI.M(ImageGalleryUI.this).getHeight()));
          AppMethodBeat.o(254618);
          return;
          if (f >= 0.9F) {
            ImageGalleryUI.M(ImageGalleryUI.this).setAlpha((1.0F - f) * 10.0F);
          }
        }
      }
    });
    this.msgId = getIntent().getLongExtra("img_gallery_msg_id", 0L);
    this.aeAK = getIntent().getBooleanExtra("img_gallery_is_mp_video_without_msg", false);
    this.aeDt = getIntent().getIntExtra("img_gallery_mp_video_click_from", 2);
    long l = getIntent().getLongExtra("img_gallery_msg_svr_id", 0L);
    Object localObject3;
    boolean bool1;
    if (!this.aeAK)
    {
      if ((this.msgId <= 0L) && (l == 0L))
      {
        Log.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.msgId + ", msgSvrId = " + l + ", stack = " + Util.getStack());
        finish();
        AppMethodBeat.o(36163);
        return;
      }
      if (this.msgId == 0L)
      {
        bh.bCz();
        this.msgId = com.tencent.mm.model.c.bzD().aU(jvx(), l).field_msgId;
      }
      bh.bCz();
      localObject1 = com.tencent.mm.model.c.bzD().sl(this.msgId);
      if ((localObject1 == null) || (((fi)localObject1).field_msgId <= 0L))
      {
        Log.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.msgId + ", msgSvrId = " + l + ", stack = " + Util.getStack());
        finish();
        AppMethodBeat.o(36163);
        return;
      }
      if (!((cc)localObject1).dSH()) {
        break label2029;
      }
      localObject3 = ae.pbN;
      localObject3 = ae.a.Qv(((fi)localObject1).field_reserved);
      if ((localObject3 != null) && (((ae)localObject3).pbO))
      {
        bool1 = true;
        this.aeCS = bool1;
      }
    }
    label780:
    label794:
    label936:
    label975:
    label1511:
    label2029:
    for (;;)
    {
      if (An(this.msgId) == 3)
      {
        bool1 = true;
        this.aeDx = bool1;
        if (com.tencent.mm.n.a.aTj()) {
          this.aeDx = true;
        }
        this.aeAg = new h(this, this.msgId, jvx(), this.Aet, this.vEb, bool2, (String)localObject2, Boolean.valueOf(this.aeDr), this.aedW);
        this.aeAg.aeAL = false;
        this.aeAg.aeAE = getIntent().getBooleanExtra("start_chatting_ui", true);
        this.aeAg.aeAJ = new h.c()
        {
          public final void Qz()
          {
            AppMethodBeat.i(254679);
            if (ImageGalleryUI.this.aeAg == null)
            {
              AppMethodBeat.o(254679);
              return;
            }
            ImageGalleryUI.this.jvG();
            ImageGalleryUI.F(ImageGalleryUI.this);
            ImageGalleryUI.this.aeAg.onPageSelected(h.a.aeAT);
            AppMethodBeat.o(254679);
          }
        };
        localObject2 = this.aeAg;
        localObject3 = this.aeBT;
        if (((h)localObject2).aeAG != null) {
          ((h)localObject2).aeAG.aeBT = ((u)localObject3);
        }
        com.tencent.mm.ui.chatting.gallery.scan.d.init();
        if (this.aeCA) {
          break label1950;
        }
        bool1 = true;
        this.aeDk = new com.tencent.mm.ui.chatting.gallery.scan.i(this, bool1);
        this.aeDl = new com.tencent.mm.ui.chatting.gallery.scan.f();
        if ((!com.tencent.mm.ui.chatting.gallery.scan.d.jwA()) || (!jvL())) {
          break label1955;
        }
        bool1 = true;
        this.aeDj = bool1;
        Log.i("MicroMsg.ImageGalleryUI", "initScanCode isPreviewOnly: %b, canShowScanCodeButton: %b, isEnterFromChattingUI: %b, isEnterFromGrid: %b", new Object[] { Boolean.valueOf(this.aeCA), Boolean.valueOf(this.aeDj), Boolean.valueOf(this.aewu), Boolean.valueOf(this.aeDq) });
        this.aeCE = 0;
        this.aeCF = getResources().getDimensionPixelSize(R.f.flC);
        this.aeCG = getResources().getDimensionPixelSize(R.f.flB);
        this.ApZ = ((RelativeLayout)findViewById(R.h.cropimage_function_bar));
        this.aeCz = ((RelativeLayout)findViewById(R.h.fEn));
        this.ApZ.setOnClickListener(new ImageGalleryUI.6(this));
        this.aeCN = ((Button)findViewById(R.h.gbW));
        this.aeCN.setOnClickListener(this);
        Object localObject4 = com.tencent.mm.svg.a.a.j(getResources(), R.k.icons_filled_error);
        localObject2 = new Rect(0, 0, com.tencent.mm.cd.a.bs(this, R.f.Edge_2_5_A), com.tencent.mm.cd.a.bs(this, R.f.Edge_2_5_A));
        localObject3 = new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        if (localObject4 != null)
        {
          this.cpD = new BitmapDrawable(getResources(), (Bitmap)localObject4);
          this.cpD.setBounds((Rect)localObject2);
          this.cpD.mutate().setColorFilter((ColorFilter)localObject3);
        }
        this.aeCO = ((Button)findViewById(R.h.gbZ));
        this.aeCO.setOnClickListener(this);
        localObject4 = com.tencent.mm.svg.a.a.j(getResources(), R.k.icons_filled_close);
        if (localObject4 != null)
        {
          localObject4 = new BitmapDrawable(getResources(), (Bitmap)localObject4);
          ((Drawable)localObject4).setBounds((Rect)localObject2);
          ((Drawable)localObject4).mutate().setColorFilter((ColorFilter)localObject3);
          this.aeCO.setGravity(16);
          this.aeCO.setCompoundDrawablesRelative(null, null, (Drawable)localObject4, null);
        }
        this.aeCP = findViewById(R.h.gbY);
        this.aeCQ = ((TextView)findViewById(R.h.gca));
        ((TextView)findViewById(R.h.gbX)).getPaint().setFakeBoldText(true);
        this.aeCN.getPaint().setFakeBoldText(true);
        this.aeCO.getPaint().setFakeBoldText(true);
        float f = Math.min(1.125F, com.tencent.mm.cd.a.getScaleSize(this));
        this.aeCN.setTextSize(1, 12.0F * f);
        this.aeCO.setTextSize(1, f * 12.0F);
        this.aeCM = findViewById(R.h.video_close_btn);
        this.aeCM.setOnClickListener(this);
        this.aeCR = ((FullScreenStatusMaskView)findViewById(R.h.fSL));
        this.aeCU = findViewById(R.h.video_player_more_iv);
        this.aeCW = findViewById(R.h.fJb);
        if (this.aeCS)
        {
          bBj(null);
          this.aeCM.addOnLayoutChangeListener(new ImageGalleryUI..ExternalSyntheticLambda0(this));
        }
        if (!cb(this)) {
          break label1960;
        }
        iBC();
        this.pIB = ((ImageView)findViewById(R.h.gallery_bg));
        this.HOP = ((MMViewPager)findViewById(R.h.gallery));
        this.HOP.setVerticalFadingEdgeEnabled(false);
        this.HOP.setHorizontalFadingEdgeEnabled(false);
        this.HOP.setSingleClickOverListener(new MMViewPager.f()
        {
          public final void fBN()
          {
            AppMethodBeat.i(254674);
            ImageGalleryUI.I(ImageGalleryUI.this);
            AppMethodBeat.o(254674);
          }
          
          public final void singleClickOver()
          {
            AppMethodBeat.i(254670);
            if (ImageGalleryUI.G(ImageGalleryUI.this)) {
              ImageGalleryUI.H(ImageGalleryUI.this);
            }
            AppMethodBeat.o(254670);
          }
        });
        this.HOP.setDoubleClickListener(new MMViewPager.a()
        {
          public final boolean an(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(254676);
            if (ImageGalleryUI.B(ImageGalleryUI.this) != null)
            {
              boolean bool = ImageGalleryUI.B(ImageGalleryUI.this).onDoubleTap(paramAnonymousMotionEvent);
              AppMethodBeat.o(254676);
              return bool;
            }
            AppMethodBeat.o(254676);
            return false;
          }
        });
        if (!jvz()) {
          break label1967;
        }
        jvI();
        this.pIB.setVisibility(8);
        this.HOP.setOffscreenPageLimit(1);
        this.HOP.setAdapter(this.aeAg);
        aCP(h.a.aeAT);
        this.HOP.setCurrentItem(h.a.aeAT);
        this.HOP.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(254668);
            if (ImageGalleryUI.this.aeAg == null)
            {
              AppMethodBeat.o(254668);
              return;
            }
            if ((n.a.jvm().Ano) && (ImageGalleryUI.K(ImageGalleryUI.this) != null))
            {
              ImageGalleryUI.K(ImageGalleryUI.this).setChecked(n.a.jvm().dx(ImageGalleryUI.this.aeAg.jvd()));
              ImageGalleryUI.L(ImageGalleryUI.this).setOnClickListener(ImageGalleryUI.this);
            }
            int i = h.a.aeAT;
            if (ImageGalleryUI.this.HOP.getCurrentItem() != i)
            {
              AppMethodBeat.o(254668);
              return;
            }
            ImageGalleryUI.this.jvR();
            h.b localb = h.dk(ImageGalleryUI.this.aeAg.aBV(i));
            if ((!ImageGalleryUI.this.aeDr) && (localb == h.b.aeBj)) {
              ImageGalleryUI.this.aeAg.aCE(i);
            }
            if (localb == h.b.aeBk) {
              ImageGalleryUI.this.aeAg.aCI(i);
            }
            AppMethodBeat.o(254668);
          }
        }, 0L);
        if (n.a.jvm().Ano)
        {
          this.aeDF = ((ViewStub)findViewById(R.h.fVP)).inflate();
          this.aeDF.setVisibility(0);
          this.aeDG = ((CheckBox)this.aeDF.findViewById(R.h.media_cbx));
          this.aeDH = this.aeDF.findViewById(R.h.media_cbx_clickarea);
        }
        this.aeDg = getIntent().getBooleanExtra("img_gallery_enter_PhotoEditUI", false);
        localObject1 = this.aeAg.j((cc)localObject1, true);
        if (localObject1 == null) {
          Log.e("MicroMsg.ImageGalleryUI", "[initView] imgInfo is null!!! isSoonEnterPhotoEdit:%s", new Object[] { Boolean.valueOf(this.aeDg) });
        }
        if ((!this.aeDg) || (localObject1 == null) || (!((com.tencent.mm.modelimage.h)localObject1).bJD())) {
          break label2010;
        }
        jvZ();
        this.aeDg = false;
      }
      for (;;)
      {
        this.HOP.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(254665);
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(254665);
              return false;
              paramAnonymousView = ad.bCb().M("basescanui@datacenter", true);
              PointF localPointF = com.tencent.mm.plugin.scanner.util.p.f(ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.aeAg, ImageGalleryUI.this.HOP), paramAnonymousMotionEvent.getRawX(), paramAnonymousMotionEvent.getRawY());
              if (localPointF != null)
              {
                paramAnonymousView.q("key_basescanui_touch_normalize_x", Float.valueOf(localPointF.x));
                paramAnonymousView.q("key_basescanui_touch_normalize_y", Float.valueOf(localPointF.y));
              }
              else
              {
                Log.e("MicroMsg.ImageGalleryUI", "alvinluo get touchCoordinate is invalid");
                paramAnonymousView.q("key_basescanui_screen_position", Boolean.TRUE);
                paramAnonymousView.q("key_basescanui_screen_x", Float.valueOf(paramAnonymousMotionEvent.getRawX()));
                paramAnonymousView.q("key_basescanui_screen_y", Float.valueOf(paramAnonymousMotionEvent.getRawY()));
              }
            }
          }
        });
        if ((joe()) || (jvz()))
        {
          this.aeCU.setVisibility(8);
          bn(jvp().aeCT, 8);
          bn(jvq().aeCV, 8);
          bn(this.aeCW, 8);
          bn(jvr().aeCX, 8);
          bn(jvu().SGO, 8);
          bn(jvv().aeCZ, 8);
        }
        AppMethodBeat.o(36163);
        return;
        bool1 = false;
        break;
        localObject1 = p.g(this.talker, this);
        break label780;
        bool1 = false;
        break label794;
        bool1 = false;
        break label936;
        bool1 = false;
        break label975;
        iBD();
        break label1511;
        if (!this.aeCA)
        {
          this.HOP.setOnPageChangeListener(this.aeDQ);
          this.HOP.setLongClickOverListener(new MMViewPager.d()
          {
            public final void longClickOver()
            {
              AppMethodBeat.i(254671);
              if ((ImageGalleryUI.B(ImageGalleryUI.this) != null) && (ImageGalleryUI.B(ImageGalleryUI.this).gPD()))
              {
                AppMethodBeat.o(254671);
                return;
              }
              if (ImageGalleryUI.u(ImageGalleryUI.this) == 1)
              {
                AppMethodBeat.o(254671);
                return;
              }
              ImageGalleryUI.J(ImageGalleryUI.this);
              Object localObject;
              long l;
              if ((ImageGalleryUI.u(ImageGalleryUI.this) == 0) || (ImageGalleryUI.u(ImageGalleryUI.this) == 2))
              {
                localObject = new hj();
                if (ImageGalleryUI.u(ImageGalleryUI.this) == 2)
                {
                  l = 1L;
                  ((hj)localObject).iqr = l;
                  ((hj)localObject).ikE = 1L;
                  ((hj)localObject).iOd = 4L;
                  if (ImageGalleryUI.this.aeAg != null)
                  {
                    com.tencent.mm.modelimage.h localh = ImageGalleryUI.k(ImageGalleryUI.this.aeAg.jvd());
                    if (localh != null)
                    {
                      ((hj)localObject).rq(localh.getFileId());
                      ((hj)localObject).rr(localh.getAesKey());
                    }
                  }
                  ((hj)localObject).bMH();
                }
              }
              else
              {
                localObject = ImageGalleryUI.a(ImageGalleryUI.this);
                ImageGalleryUI.a(ImageGalleryUI.this, com.tencent.mm.vfs.y.n((String)localObject, false), ImageGalleryUI.q(ImageGalleryUI.this));
                if (!com.tencent.mm.plugin.scanner.n.gPr()) {
                  break label235;
                }
                ImageGalleryUI.a(ImageGalleryUI.this, (String)localObject, true);
              }
              for (;;)
              {
                ImageGalleryUI.this.cxQ();
                AppMethodBeat.o(254671);
                return;
                l = 0L;
                break;
                label235:
                ImageGalleryUI.e(ImageGalleryUI.this).ou(1, 2);
              }
            }
          });
          break label1605;
        }
        jvI();
        break label1605;
        if (this.aeDg) {
          Log.w("MicroMsg.ImageGalleryUI", "img not GetCompleted!");
        }
      }
    }
  }
  
  public final void jvG()
  {
    AppMethodBeat.i(369651);
    Mn(false);
    AppMethodBeat.o(369651);
  }
  
  public final void jvH()
  {
    AppMethodBeat.i(36175);
    if (BuildInfo.IS_FLAVOR_RED) {
      Log.d("MicroMsg.ImageGalleryUI", "hideOpLayer isShowOpToolbar: %b, %s", new Object[] { Boolean.valueOf(this.aeDV), Util.getStack() });
    }
    if (!this.aeDV)
    {
      AppMethodBeat.o(36175);
      return;
    }
    this.aeDV = false;
    iBA();
    AppMethodBeat.o(36175);
  }
  
  public final void jvI()
  {
    AppMethodBeat.i(36176);
    this.Aqi.stopTimer();
    this.aeCU.setVisibility(8);
    this.aeCQ.setTextColor(com.tencent.mm.cd.a.w(this, R.e.BW_100_Alpha_0_6_5));
    jvp().aeCT.clearAnimation();
    bn(jvp().aeCT, 8);
    bn(jvq().aeCV, 8);
    this.aeCW.setVisibility(8);
    bn(jvr().aeCX, 8);
    bn(jvu().SGO, 8);
    bn(jvv().aeCZ, 8);
    dSU();
    wa(false);
    Ms(false);
    this.aeCz.setVisibility(8);
    AppMethodBeat.o(36176);
  }
  
  protected final void jvR()
  {
    AppMethodBeat.i(36182);
    if (this.aeDV) {
      if (jvP())
      {
        if (this.aeCR.getVisibility() != 0)
        {
          this.Aqi.startTimer(3000L);
          AppMethodBeat.o(36182);
        }
      }
      else {
        this.Aqi.startTimer(5000L);
      }
    }
    AppMethodBeat.o(36182);
  }
  
  public final void jvV()
  {
    AppMethodBeat.i(255277);
    this.aeCQ.setVisibility(0);
    this.aeCQ.setTextColor(-1);
    com.tencent.threadpool.h.ahAA.o(new ImageGalleryUI..ExternalSyntheticLambda1(this), 2000L);
    AppMethodBeat.o(255277);
  }
  
  public final void jvW()
  {
    AppMethodBeat.i(255281);
    this.aeCQ.setVisibility(8);
    this.aeCQ.setTextColor(-1);
    AppMethodBeat.o(255281);
  }
  
  public final void jvX()
  {
    AppMethodBeat.i(36201);
    dSU();
    jvn().aeDa.setVisibility(0);
    jvn().aeDb.setVisibility(8);
    jvn().aeDc.setVisibility(0);
    jvn().aeDd.setVisibility(8);
    jvn().aeDc.setText("0%");
    AppMethodBeat.o(36201);
  }
  
  final ImageGalleryUI jvn()
  {
    AppMethodBeat.i(36152);
    if (this.aeDa == null)
    {
      this.aeDa = findViewById(R.h.fKa);
      this.aeDb = ((Button)this.aeDa.findViewById(R.h.fEk));
      this.aeDc = ((Button)this.aeDa.findViewById(R.h.fEl));
      this.aeDd = this.aeDa.findViewById(R.h.fEm);
      TextView localTextView = (TextView)this.aeDa.findViewById(R.h.fEj);
      this.aeDb.getPaint().setFakeBoldText(true);
      this.aeDc.getPaint().setFakeBoldText(true);
      localTextView.getPaint().setFakeBoldText(true);
      float f = Math.min(1.125F, com.tencent.mm.cd.a.getScaleSize(this));
      this.aeDb.setTextSize(1, 12.0F * f);
      this.aeDc.setTextSize(1, f * 12.0F);
    }
    AppMethodBeat.o(36152);
    return this;
  }
  
  protected final ImageGalleryUI jvo()
  {
    AppMethodBeat.i(36153);
    if (this.SGW == null)
    {
      this.SGW = ((RedesignVideoPlayerSeekBar)findViewById(R.h.video_player_seek_bar));
      this.XlQ = findViewById(R.h.tool_bar_mask);
      this.SGW.setPlayBtnOnClickListener(this);
    }
    AppMethodBeat.o(36153);
    return this;
  }
  
  public final void jvy()
  {
    AppMethodBeat.i(255216);
    this.aeCS = false;
    this.aeCR.setVisibility(8);
    AppMethodBeat.o(255216);
  }
  
  public final void n(cc paramcc, boolean paramBoolean)
  {
    label151:
    int i;
    Object localObject1;
    label389:
    Object localObject2;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(255249);
        if ((paramcc == null) || (!paramcc.dSI()))
        {
          if (this.XlK != null) {
            this.XlK.setVisibility(8);
          }
          this.aeCy = h.dk(paramcc);
          Log.i("MicroMsg.ImageGalleryUI", "updateFooterInfo currGalleryType: %s, pageChanged: %b", new Object[] { this.aeCy, Boolean.valueOf(paramBoolean) });
          if ((n.a.jvm().Ano) && (this.aeDG != null)) {
            this.aeDG.setChecked(n.a.jvm().dx(paramcc));
          }
        }
        switch (44.aeAP[this.aeCy.ordinal()])
        {
        case 1: 
          Mn(paramBoolean);
          AppMethodBeat.o(255249);
          return;
          if (this.XlK == null)
          {
            this.XlK = ((ViewStub)findViewById(R.h.fIY)).inflate();
            this.AMj = findViewById(R.h.mp_video_avatar_layout);
            this.lKK = ((ImageView)findViewById(R.h.mp_video_avatar_iv));
            this.aeDT = ((ImageView)findViewById(R.h.mp_video_right_arrow_iv));
            this.nicknameTv = ((TextView)findViewById(R.h.mp_video_nickname_tv));
            this.Ilr = ((MMNeat7extView)findViewById(R.h.mp_video_title_tv));
            this.aeDR = ((TextView)findViewById(R.h.mp_video_view_article_tv));
            this.nicknameTv.getPaint().setFakeBoldText(true);
            this.aeDR.getPaint().setFakeBoldText(true);
            this.Ilr.getPaint().setFakeBoldText(true);
            this.aeDS = findViewById(R.h.mp_video_view_article_layout);
            this.XlK.setOnClickListener(new ImageGalleryUI.30(this));
          }
          boolean bool = com.tencent.mm.ui.bf.bg(this);
          i = com.tencent.mm.ui.bf.bk(this);
          if ((this.KTF) && (bool))
          {
            if (cb(this)) {
              jvY();
            }
          }
          else
          {
            localObject1 = p.dc(paramcc);
            if (localObject1 != null) {
              break label389;
            }
            Log.w("MicroMsg.ImageGalleryUI", "fillMpVideoInfoLayout mpShareVideoInfo is null");
            continue;
          }
          aCW(i);
        }
      }
      finally {}
      continue;
      this.Ilr.aZ(((com.tencent.mm.message.y)localObject1).title);
      localObject2 = new k.b();
      ((k.b)localObject2).iab = ((com.tencent.mm.message.y)localObject1).nUF;
      ((k.b)localObject2).iaa = ((com.tencent.mm.message.y)localObject1).hEE;
      an.a(this, (k.b)localObject2, this.lKK, this.nicknameTv);
      this.AMj.setOnClickListener(new ImageGalleryUI.31(this, (com.tencent.mm.message.y)localObject1));
      this.aeDS.setOnClickListener(new ImageGalleryUI.32(this, (com.tencent.mm.message.y)localObject1));
      com.tencent.mm.ui.tools.o.F(this.AMj, 0.7F);
      com.tencent.mm.ui.tools.o.F(this.aeDS, 0.7F);
      if (((com.tencent.mm.message.y)localObject1).YMm != null)
      {
        ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(((com.tencent.mm.message.y)localObject1).YMm, -1, 2, new Object[0]);
        this.aeDS.setVisibility(0);
      }
      for (;;)
      {
        localObject1 = (LinearLayout.LayoutParams)this.aeDT.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).height = ((int)(this.aeDR.getTextSize() * 1.45D));
        ((LinearLayout.LayoutParams)localObject1).width = ((LinearLayout.LayoutParams)localObject1).height;
        this.aeDT.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (!this.aeAK) {
          break;
        }
        Mn(false);
        dSV();
        break;
        this.aeDS.setVisibility(8);
      }
      bn(this.aeDa, 4);
      setVideoStateIv(true);
      paramcc = p.dd(paramcc);
      if (paramcc != null) {
        break;
      }
      AppMethodBeat.o(255249);
    }
    jvo().SGW.setVideoTotalTime(paramcc.omT);
    for (;;)
    {
      try
      {
        if ((this.aeAg.jve() == null) || (this.aeAg.jve().aeFr == null)) {
          break label1011;
        }
        i = this.aeAg.jve().aeFr.getCurrentPosition() / 1000;
        jvo().SGW.seek(i);
      }
      catch (Exception paramcc)
      {
        Log.printErrStackTrace("MicroMsg.ImageGalleryUI", paramcc, "", new Object[0]);
        break label1011;
      }
      localObject1 = this.aeAg.j(paramcc, false);
      dSU();
      Mn(paramBoolean);
      if (localObject1 == null)
      {
        Log.w("MicroMsg.ImageGalleryUI", "updateFooterInfo img info is null");
        AppMethodBeat.o(255249);
        break label151;
      }
      if ((this.aeDg) && (((com.tencent.mm.modelimage.h)localObject1).bJD()) && (this.aeAg.jvd() != null) && (paramcc.field_msgId == this.aeAg.jvd().field_msgId))
      {
        Log.i("MicroMsg.ImageGalleryUI", "get image successfully! -> gotoPhotoEditUI msgId:%s", new Object[] { Long.valueOf(paramcc.field_msgId) });
        jvZ();
        this.aeDg = false;
        AppMethodBeat.o(255249);
        break label151;
      }
      localObject2 = this.aeAg.jvd();
      paramBoolean = this.aeDg;
      long l = paramcc.field_msgId;
      if (localObject2 == null) {}
      for (paramcc = "null";; paramcc = Long.valueOf(((fi)localObject2).field_msgId))
      {
        Log.w("MicroMsg.ImageGalleryUI", "isSoonEnterPhotoEdit:%s msgId:%s curMsgId:%s getCompleted:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l), paramcc, Boolean.valueOf(((com.tencent.mm.modelimage.h)localObject1).bJD()) });
        AppMethodBeat.o(255249);
        break;
      }
      dSU();
      break;
      dSU();
      Mn(paramBoolean);
      bn(this.aeDa, 4);
      this.aeAg.aCI(this.HOP.getCurrentItem());
      AppMethodBeat.o(255249);
      break label151;
      break;
      label1011:
      i = 0;
    }
  }
  
  public boolean noActionBar()
  {
    AppMethodBeat.i(255183);
    if (!jvz())
    {
      AppMethodBeat.o(255183);
      return true;
    }
    AppMethodBeat.o(255183);
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(36173);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.WYF != null) && (this.WYF.d(this, paramInt1, paramInt2, paramIntent)))
    {
      AppMethodBeat.o(36173);
      return;
    }
    AppMethodBeat.o(36173);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(36161);
    Log.i("MicroMsg.ImageGalleryUI", "onBackPressed");
    if (hoc())
    {
      AppMethodBeat.o(36161);
      return;
    }
    if (jvt().RnL.getVisibility() == 0)
    {
      jvt().RnL.P(this.GYk.longValue(), this.aeDi.aeHu);
      AppMethodBeat.o(36161);
      return;
    }
    jvy();
    if (this.aeDq)
    {
      aCR(1);
      AppMethodBeat.o(36161);
      return;
    }
    try
    {
      n.a.jvm().detach();
      dmJ();
      AppMethodBeat.o(36161);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ImageGalleryUI", localException.getMessage());
      finish();
      AppMethodBeat.o(36161);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(36191);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    if (this.aeAg == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == R.h.fGH) {
      aCR(0);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36191);
      return;
      if (paramView.getId() == R.h.video_player_more_iv)
      {
        this.aeCB = false;
        cxQ();
        if ((aCO(2)) && (cf(this.aeDi.aeHr))) {
          if (this.aeDi.aeHr.size() == 1)
          {
            paramView = (ImageQBarDataBean)this.aeDi.aeHr.get(0);
            this.aeDi.aeHt = paramView;
            this.aeDi.aeHs = null;
            this.aeDz.b(paramView.hDb, bBl(paramView.OGQ));
          }
          else
          {
            paramView = (ArrayList)com.tencent.mm.plugin.scanner.i.a(this, a(this.aeAg, this.HOP), this.aeDi.aeHr, 0).bsC;
            if (paramView.size() == 1)
            {
              paramView = (ImageQBarDataBean)paramView.get(0);
              this.aeDi.aeHs = paramView;
              this.aeDi.aeHt = paramView;
              this.aeDz.b(paramView.hDb, bBl(paramView.OGQ));
            }
            else
            {
              this.aeDi.aeHs = null;
              this.aeDi.aeHt = null;
            }
          }
        }
      }
      else if (paramView.getId() == R.h.fGb)
      {
        Log.i("MicroMsg.ImageGalleryUI", "[oreh download_and_save] hdImg suc, curPos:%d", new Object[] { Integer.valueOf(this.HOP.getCurrentItem()) });
        paramView = this.aeAg.aBV(this.HOP.getCurrentItem());
        localObject = this.aeAg.j(paramView, false);
        this.HOP.getCurrentItem();
        if ((f(paramView, (com.tencent.mm.modelimage.h)localObject)) && (!paramView.isClean()) && (((com.tencent.mm.modelimage.h)localObject).bJD())) {
          this.aeAg.cH(this.HOP.getCurrentItem(), true);
        } else {
          h.b(getContext(), this.aeAg.jvd(), true);
        }
      }
      else if (paramView.getId() == R.h.fEk)
      {
        this.AjA = 2;
        this.Ajz = 0;
        this.aeAg.cH(this.HOP.getCurrentItem(), false);
      }
      else if (paramView.getId() == R.h.fEl)
      {
        this.aeAg.aCH(this.HOP.getCurrentItem());
        aCP(this.HOP.getCurrentItem());
      }
      else if (paramView.getId() == R.h.actionbar_up_indicator)
      {
        onBackPressed();
      }
      else if (paramView.getId() == R.h.video_close_btn)
      {
        onBackPressed();
      }
      else if (paramView.getId() == R.h.media_cbx_clickarea)
      {
        boolean bool = this.aeDG.isChecked();
        if ((!bool) && (n.a.jvm().Ann.size() >= 9))
        {
          Toast.makeText(this, getResources().getString(R.l.gallery_select_limit, new Object[] { Integer.valueOf(9) }), 1).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36191);
          return;
        }
        paramView = this.aeDG;
        if (!bool) {}
        for (bool = true;; bool = false)
        {
          paramView.setChecked(bool);
          if (!this.aeDG.isChecked()) {
            break label707;
          }
          n.a.jvm().dv(this.aeAg.jvd());
          break;
        }
        label707:
        n.a.jvm().dw(this.aeAg.jvd());
      }
      else if (paramView.getId() == R.h.play_btn)
      {
        this.aeAg.jve();
        this.aeAg.aCE(this.HOP.getCurrentItem());
      }
      else if (paramView.getId() == R.h.fJb)
      {
        if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(getContext()))
        {
          this.aeDA.aDb(3);
          Mj(true);
        }
      }
      else
      {
        int j;
        if (paramView.getId() == R.h.fIZ)
        {
          if (this.aeDJ.mState == 1)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(36191);
            return;
          }
          this.aeDA.aDb(2);
          if (this.aeDi.aeHr.size() == 3)
          {
            i = getWindow().getDecorView().getHeight();
            j = getWindow().getDecorView().getWidth();
            paramView = ad.bCb().M("basescanui@datacenter", true);
            localObject = com.tencent.mm.plugin.scanner.util.p.f(a(this.aeAg, this.HOP), j / 2, i / 2);
            if (localObject != null)
            {
              paramView.q("key_basescanui_touch_normalize_x", Float.valueOf(((PointF)localObject).x));
              paramView.q("key_basescanui_touch_normalize_y", Float.valueOf(((PointF)localObject).y));
            }
            a(a(this.aeAg, this.HOP), com.tencent.mm.vfs.y.n(dRR(), false), null, 3, this.aeDB);
          }
          else
          {
            Mi(true);
          }
        }
        else if (paramView.getId() == R.h.fJa)
        {
          jvu().SGO.setOnClickListener(null);
          aS(System.currentTimeMillis(), 3);
        }
        else if (paramView.getId() == R.h.fVw)
        {
          jvv().aeCZ.setBubbleClickListener(null);
          aS(System.currentTimeMillis(), 4);
        }
        else
        {
          if (paramView.getId() == R.h.gbW)
          {
            paramView = this.aeAg;
            j = this.HOP.getCurrentItem();
            if (paramView.aeAH != null) {
              paramView.aeAH.aCy(j);
            }
            paramView = this.aeAg.jvd().field_imgPath;
            if (Util.isNullOrNil(paramView)) {}
            for (;;)
            {
              aCV(i);
              break;
              paramView = com.tencent.mm.modelvideo.ab.Qo(paramView);
              if (paramView != null) {
                i = com.tencent.mm.modelvideo.ab.h(paramView);
              }
            }
          }
          if (paramView.getId() == R.h.gbZ)
          {
            paramView = this.aeAg;
            i = this.HOP.getCurrentItem();
            if (paramView.aeAH != null) {
              paramView.aeAH.aCz(i);
            }
            bn(this.aeCO, 8);
            paramView = getContentView().getDisplay();
            if ((paramView != null) && (paramView.getRotation() != 0) && (paramView.getRotation() != 2))
            {
              paramView = (RelativeLayout.LayoutParams)this.SGW.getLayoutParams();
              paramView.addRule(1, R.h.gbW);
              this.SGW.setLayoutParams(paramView);
            }
            Mn(false);
          }
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(36206);
    super.onConfigurationChanged(paramConfiguration);
    if (this.RnQ != null) {
      this.RnQ.onConfigurationChanged(paramConfiguration);
    }
    if (paramConfiguration.orientation == 1)
    {
      Log.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is vertical screen", new Object[] { Integer.valueOf(hashCode()) });
      this.aeCJ = true;
      iBC();
      AppMethodBeat.o(36206);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      Log.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is horizontal screen", new Object[] { Integer.valueOf(hashCode()) });
      this.aeCJ = true;
      iBD();
      AppMethodBeat.o(36206);
      return;
    }
    AppMethodBeat.o(36206);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(36157);
    requestWindowFeature(1);
    aw.bW(this);
    if (jvz()) {
      setTheme(R.m.MMTheme_Holo_ImageGalleyUI2);
    }
    long l = System.currentTimeMillis();
    this.aeDI = true;
    super.onCreate(paramBundle);
    if (jvz())
    {
      setMMTitle("");
      addIconOptionMenu(0, h.g.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(254423);
          ImageGalleryUI.A(ImageGalleryUI.this);
          AppMethodBeat.o(254423);
          return true;
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(254685);
          ImageGalleryUI.this.finish();
          AppMethodBeat.o(254685);
          return true;
        }
      });
      initView();
      if (this.aeAg != null)
      {
        com.tencent.mm.modelimage.h localh = j.k(this.aeAg.jvd());
        this.aeDA.b(1, localh);
      }
      this.wAX = paramBundle;
      this.AjG.alive();
      this.SHh = false;
      this.aeDz = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.b()
      {
        public final void auF(String paramAnonymousString)
        {
          AppMethodBeat.i(254689);
          if ((ImageGalleryUI.f(ImageGalleryUI.this) != null) && (ImageGalleryUI.f(ImageGalleryUI.this).isShowing()) && (ImageGalleryUI.d(ImageGalleryUI.this).aeHt != null) && (Util.isEqual(paramAnonymousString, ImageGalleryUI.d(ImageGalleryUI.this).aeHt.OGQ))) {
            ImageGalleryUI.this.cxQ();
          }
          ImageGalleryUI.d(ImageGalleryUI.this).aeHt = null;
          AppMethodBeat.o(254689);
        }
      });
      Log.d("MicroMsg.ImageGalleryUI", "ImageGallery onCreate spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(36157);
      return;
    }
    if (com.tencent.mm.compatible.util.d.rb(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (this.KTF = true;; this.KTF = false)
    {
      setLightNavigationbarIcon();
      break;
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
    Log.i("MicroMsg.ImageGalleryUI", "%d image gallery ui on destroy", new Object[] { Integer.valueOf(hashCode()) });
    Object localObject2;
    Object localObject3;
    Object localObject4;
    long l;
    try
    {
      if (this.aeAg != null)
      {
        aCQ(this.aeDN);
        this.aeCD.a(this, this.aeDN, 0);
        this.aeAg.detach();
        this.aeAg = null;
      }
      this.Aqi.stopTimer();
      Mm(false);
      this.AjF.removeAllUpdateListeners();
      this.AjG.dead();
      com.tencent.mm.kernel.h.baD().b(this.AjH);
      Object localObject1 = new tz();
      ((tz)localObject1).hXO.activity = this;
      ((tz)localObject1).publish();
      if (this.SGW != null) {
        this.SGW.setPlayBtnOnClickListener(null);
      }
      this.SGW = null;
      jvw();
      if (this.aeDk != null)
      {
        localObject1 = this.aeDk;
        if (((com.tencent.mm.ui.chatting.gallery.scan.i)localObject1).aeGR)
        {
          ((com.tencent.mm.ui.chatting.gallery.scan.i)localObject1).aeGX.dead();
          ((com.tencent.mm.ui.chatting.gallery.scan.i)localObject1).aeGY.dead();
          ((com.tencent.mm.ui.chatting.gallery.scan.i)localObject1).aeGZ.dead();
        }
        localObject2 = ((com.tencent.mm.ui.chatting.gallery.scan.i)localObject1).aeGS.keySet();
        kotlin.g.b.s.s(localObject2, "scanCodeRequestMap.keys");
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            Object localObject5 = (String)((Iterator)localObject2).next();
            localObject3 = (i.b)((com.tencent.mm.ui.chatting.gallery.scan.i)localObject1).aeGS.get(localObject5);
            localObject4 = new com.tencent.mm.autogen.a.bf();
            ((com.tencent.mm.autogen.a.bf)localObject4).hBj.filePath = ((String)localObject5);
            localObject5 = ((com.tencent.mm.autogen.a.bf)localObject4).hBj;
            if (localObject3 == null)
            {
              l = 0L;
              ((bf.a)localObject5).hBk = l;
              ((com.tencent.mm.autogen.a.bf)localObject4).publish();
              continue;
              if (!com.tencent.mm.graphics.b.c.mvH.mvL) {
                break;
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ImageGalleryUI", localException, "", new Object[0]);
    }
    for (;;)
    {
      com.tencent.mm.graphics.b.c.mvH.stop();
      super.onDestroy();
      AppMethodBeat.o(36160);
      return;
      l = ((i.b)localObject3).hBk;
      break;
      localException.aeGS.clear();
      localException.aeGT.clear();
      localException.aeGU.clear();
      Log.v("MicroMsg.ImageScanCodeManager", "releaseHandleCode");
      localObject2 = localException.aeGV.keySet();
      kotlin.g.b.s.s(localObject2, "handleCodeRequestMap.keys");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = new be();
        ((be)localObject4).hBh.activity = localException.hHU;
        ((be)localObject4).hBh.hBi = ((String)localObject3);
        ((be)localObject4).publish();
      }
      localException.aeGW.clear();
      if (this.aeDo != null)
      {
        com.tencent.mm.ui.chatting.gallery.scan.j localj = this.aeDo;
        Log.d("MicroMsg.ImageSearchPreviewManager", "alvinluo release previewImage request size: %s", new Object[] { Integer.valueOf(localj.aeHg.size()) });
        localObject2 = ((Map)localj.aeHg).entrySet().iterator();
        while (((Iterator)localObject2).hasNext()) {
          com.tencent.mm.ui.chatting.gallery.scan.j.tO(((Number)((Map.Entry)((Iterator)localObject2).next()).getKey()).longValue());
        }
        localj.aeHf.clear();
      }
      if (this.RnQ != null) {
        this.RnQ.release();
      }
      com.tencent.mm.ui.chatting.gallery.scan.k.release();
      jvt().RnL.gPk();
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
    Log.i("MicroMsg.ImageGalleryUI", "on pause");
    super.onPause();
    if ((!jvz()) && (Build.VERSION.SDK_INT >= 21)) {
      getWindow().setFlags(2048, 2048);
    }
    if ((!isFinishing()) && (this.aeAg != null)) {
      this.aeAg.jvf();
    }
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    jvv().aeCZ.setBubbleClickListener(this);
    jvu().SGO.setOnClickListener(this);
    AppMethodBeat.o(36150);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(36158);
    super.onResume();
    if (this.aeAg != null) {
      if (!this.aeAg.aeAK) {
        break label128;
      }
    }
    label128:
    for (int i = 0;; i = 100000)
    {
      h.a.aeAT = i;
      if ((!jvz()) && (Build.VERSION.SDK_INT >= 21)) {
        getWindow().clearFlags(2048);
      }
      if ((!this.aeDI) && (this.aeAg != null)) {
        aCP(this.HOP.getCurrentItem());
      }
      this.aeDI = false;
      if (this.aeAg != null) {
        this.aeAg.aeAH.onResume();
      }
      com.tencent.mm.kernel.h.baD().a(this.AjH);
      com.tencent.mm.plugin.ball.f.f.d(true, true, true);
      AppMethodBeat.o(36158);
      return;
    }
  }
  
  public void onStart()
  {
    boolean bool = true;
    AppMethodBeat.i(36159);
    this.aeDr = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
    Bundle localBundle;
    if ((!this.aeCA) && (!jvz()))
    {
      localBundle = this.wAX;
      Log.i("MicroMsg.ImageGalleryUI", "[handleAnimation] isAnimated:" + this.isAnimated);
      if (!this.isAnimated)
      {
        this.isAnimated = true;
        if (Build.VERSION.SDK_INT >= 12)
        {
          this.wAZ = getIntent().getIntExtra("img_gallery_top", 0);
          this.wBa = getIntent().getIntExtra("img_gallery_left", 0);
          this.wBb = getIntent().getIntExtra("img_gallery_width", 0);
          this.wBc = getIntent().getIntExtra("img_gallery_height", 0);
          if ((this.wAZ == 0) && (this.wBa == 0) && (this.wBb == 0) && (this.wBc == 0))
          {
            cc localcc = this.aeAg.aBV(this.HOP.getCurrentItem());
            if (localcc != null)
            {
              com.tencent.mm.autogen.a.bt localbt = new com.tencent.mm.autogen.a.bt();
              localbt.hBH.hzO = localcc;
              localbt.publish();
              this.wBb = localbt.hBI.hBL;
              this.wBc = localbt.hBI.hBM;
              this.wBa = localbt.hBI.hBJ;
              this.wAZ = localbt.hBI.hBK;
            }
          }
          this.wAY.af(this.wBa, this.wAZ, this.wBb, this.wBc);
          if (localBundle != null) {
            break label347;
          }
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.ImageGalleryUI", "[handleAnimation] savedInstanceState is null?%s", new Object[] { Boolean.valueOf(bool) });
      if (localBundle == null) {
        this.HOP.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(254621);
            ImageGalleryUI.this.HOP.getViewTreeObserver().removeOnPreDrawListener(this);
            Log.i("MicroMsg.ImageGalleryUI", "[handleAnimation] -> onPreDraw, isBackFromGrid:" + ImageGalleryUI.this.aeDr);
            ImageGalleryUI.this.Roe = ImageGalleryUI.this.HOP.getWidth();
            ImageGalleryUI.this.Rof = ImageGalleryUI.this.HOP.getHeight();
            if (ImageGalleryUI.this.aeAg.jvd().dSJ()) {
              ImageGalleryUI.this.Rof = ((int)(ImageGalleryUI.this.Roe / ImageGalleryUI.this.wBb * ImageGalleryUI.this.wBc));
            }
            if (ImageGalleryUI.this.aeAg.jvd().iYk())
            {
              com.tencent.mm.ui.base.i locali = (com.tencent.mm.ui.base.i)ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.aeAg, ImageGalleryUI.this.HOP);
              if (locali != null)
              {
                ImageGalleryUI localImageGalleryUI = ImageGalleryUI.this;
                float f = ImageGalleryUI.this.Roe / locali.getImageWidth();
                localImageGalleryUI.Rof = ((int)(locali.getImageHeight() * f));
                if (ImageGalleryUI.this.Rof > ImageGalleryUI.this.HOP.getHeight()) {
                  ImageGalleryUI.this.Rof = ImageGalleryUI.this.HOP.getHeight();
                }
              }
            }
            ImageGalleryUI.this.wAY.oC(ImageGalleryUI.this.Roe, ImageGalleryUI.this.Rof);
            if (!ImageGalleryUI.this.aeDr) {
              ImageGalleryUI.this.wAY.a(ImageGalleryUI.this.HOP, ImageGalleryUI.N(ImageGalleryUI.this), new f.c()
              {
                public final void onAnimationEnd()
                {
                  AppMethodBeat.i(254583);
                  ImageGalleryUI.O(ImageGalleryUI.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(254702);
                      if (ImageGalleryUI.this.aeDE != null) {
                        ImageGalleryUI.this.aeDE.M(Boolean.FALSE);
                      }
                      AppMethodBeat.o(254702);
                    }
                  });
                  AppMethodBeat.o(254583);
                }
                
                public final void onAnimationStart()
                {
                  AppMethodBeat.i(254576);
                  if (ImageGalleryUI.this.aeDE != null) {
                    ImageGalleryUI.this.aeDE.M(Boolean.TRUE);
                  }
                  AppMethodBeat.o(254576);
                }
              });
            }
            ImageGalleryUI.P(ImageGalleryUI.this);
            AppMethodBeat.o(254621);
            return true;
          }
        });
      }
      super.onStart();
      AppMethodBeat.o(36159);
      return;
      label347:
      bool = false;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(36151);
    super.onStop();
    com.tencent.mm.graphics.b.d.mvO.aYb();
    if (com.tencent.mm.graphics.b.c.mvH.mvL) {
      com.tencent.mm.graphics.b.c.mvH.stop();
    }
    bn(jvs().aeCY, 8);
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
      RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = jvo().SGW;
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
      Log.e("MicroMsg.ImageGalleryUI", "set video state iv error : " + localException.toString());
      AppMethodBeat.o(36192);
    }
  }
  
  public final void wa(boolean paramBoolean)
  {
    int i = 8;
    AppMethodBeat.i(36178);
    if (this.ApZ == null)
    {
      AppMethodBeat.o(36178);
      return;
    }
    if (((paramBoolean) && (this.ApZ.getVisibility() == 0)) || ((!paramBoolean) && (this.ApZ.getVisibility() == 8)))
    {
      AppMethodBeat.o(36178);
      return;
    }
    Object localObject = this.ApZ;
    if (paramBoolean) {
      i = 0;
    }
    ((RelativeLayout)localObject).setVisibility(i);
    localObject = getContext();
    if (paramBoolean) {}
    for (i = R.a.alpha_in;; i = R.a.alpha_out)
    {
      localObject = AnimationUtils.loadAnimation((Context)localObject, i);
      this.ApZ.startAnimation((Animation)localObject);
      AppMethodBeat.o(36178);
      return;
    }
  }
  
  static final class a
    implements com.tencent.mm.plugin.appbrand.openmaterial.j
  {
    private final com.tencent.mm.plugin.appbrand.service.j WVQ;
    private final WeakReference<ImageGalleryUI> YtG;
    private final String aeEo;
    private final com.tencent.mm.plugin.appbrand.openmaterial.model.b trb;
    
    public a(ImageGalleryUI paramImageGalleryUI, String paramString, com.tencent.mm.plugin.appbrand.service.j paramj, com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb)
    {
      AppMethodBeat.i(254767);
      this.YtG = new WeakReference(paramImageGalleryUI);
      this.aeEo = paramString;
      this.WVQ = paramj;
      this.trb = paramb;
      AppMethodBeat.o(254767);
    }
    
    public final void a(boolean paramBoolean, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(254779);
      ImageGalleryUI localImageGalleryUI = (ImageGalleryUI)this.YtG.get();
      if (localImageGalleryUI == null)
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet#onMyOpenMaterialsGot, ui is null");
        AppMethodBeat.o(254779);
        return;
      }
      if (!paramBoolean)
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet#onMyOpenMaterialsGot, fail");
        AppMethodBeat.o(254779);
        return;
      }
      if (ImageGalleryUI.f(localImageGalleryUI) == null)
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet#onMyOpenMaterialsGot, bottomSheet is null");
        AppMethodBeat.o(254779);
        return;
      }
      ImageGalleryUI.c(localImageGalleryUI, this.aeEo);
      ImageGalleryUI.a(localImageGalleryUI, paramAppBrandOpenMaterialCollection);
      if (!this.WVQ.a(ImageGalleryUI.f(localImageGalleryUI), paramAppBrandOpenMaterialCollection))
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet#onMyOpenMaterialsGot, not need enhance");
        AppMethodBeat.o(254779);
        return;
      }
      if (localImageGalleryUI.aeAg != null) {}
      for (paramAppBrandOpenMaterialCollection = localImageGalleryUI.aeAg.jvb();; paramAppBrandOpenMaterialCollection = null)
      {
        if ((paramAppBrandOpenMaterialCollection != null) && (w.aeGm != paramAppBrandOpenMaterialCollection))
        {
          if (ImageGalleryUI.h(localImageGalleryUI) != null) {
            ImageGalleryUI.h(localImageGalleryUI).dead();
          }
          ImageGalleryUI.a(localImageGalleryUI, this.WVQ.a(this.trb, localImageGalleryUI, ImageGalleryUI.f(localImageGalleryUI), ImageGalleryUI.T(localImageGalleryUI), null, ImageGalleryUI.U(localImageGalleryUI)));
          if ((com.tencent.mm.plugin.appbrand.openmaterial.model.b.trX == this.trb) && (ImageGalleryUI.g(localImageGalleryUI)))
          {
            Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet#onMyOpenMaterialsGot, hide enhance bottomSheet");
            ImageGalleryUI.h(localImageGalleryUI).a(i.a.trx);
          }
        }
        AppMethodBeat.o(254779);
        return;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void M(Boolean paramBoolean);
  }
  
  final class c
  {
    volatile int mState = 0;
    
    private c() {}
    
    public final int get()
    {
      AppMethodBeat.i(254760);
      int i = this.mState;
      Log.i("MicroMsg.ImageGalleryUI", "get#ScanState, state: ".concat(String.valueOf(i)));
      AppMethodBeat.o(254760);
      return i;
    }
    
    public final void jwc()
    {
      AppMethodBeat.i(254765);
      Log.i("MicroMsg.ImageGalleryUI", "onScanFinishPathChecked#ScanState");
      this.mState = 2;
      AppMethodBeat.o(254765);
    }
  }
  
  static final class d
    implements com.tencent.mm.plugin.appbrand.openmaterial.k
  {
    final WeakReference<ImageGalleryUI> YtG;
    Runnable aeEp;
    cc aeEq;
    
    public d(ImageGalleryUI paramImageGalleryUI)
    {
      AppMethodBeat.i(254753);
      this.aeEp = null;
      this.aeEq = null;
      this.YtG = new WeakReference(paramImageGalleryUI);
      AppMethodBeat.o(254753);
    }
    
    public final void an(Runnable paramRunnable)
    {
      AppMethodBeat.i(254763);
      Log.i("MicroMsg.ImageGalleryUI", "executeOrDefer");
      ImageGalleryUI localImageGalleryUI = (ImageGalleryUI)this.YtG.get();
      if (localImageGalleryUI == null)
      {
        Log.i("MicroMsg.ImageGalleryUI", "executeOrDefer, ui is null");
        AppMethodBeat.o(254763);
        return;
      }
      cc localcc = localImageGalleryUI.aeAg.jvd();
      if ((localcc != null) && (localcc.dSH()))
      {
        com.tencent.mm.modelvideo.z localz = com.tencent.mm.modelvideo.ab.Qo(localcc.field_imgPath);
        if ((localz != null) && (localz.status != 199) && (localz.status != 199))
        {
          Log.i("MicroMsg.ImageGalleryUI", "executeOrDefer, video start download and waiting");
          ImageGalleryUI.b(localImageGalleryUI, com.tencent.mm.modelvideo.ab.o(localcc.field_msgId, 4));
          localImageGalleryUI.aeAg.aCF(localImageGalleryUI.HOP.getCurrentItem());
          this.aeEp = paramRunnable;
          this.aeEq = localcc;
          AppMethodBeat.o(254763);
          return;
        }
        com.tencent.mm.plugin.appbrand.openmaterial.k.trz.an(paramRunnable);
        AppMethodBeat.o(254763);
        return;
      }
      com.tencent.mm.plugin.appbrand.openmaterial.k.trz.an(paramRunnable);
      AppMethodBeat.o(254763);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI
 * JD-Core Version:    0.7.0.1
 */