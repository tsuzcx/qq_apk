package com.tencent.mm.ui.chatting.gallery;

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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.q;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.f.a.ay;
import com.tencent.mm.f.a.az;
import com.tencent.mm.f.a.az.a;
import com.tencent.mm.f.a.ba;
import com.tencent.mm.f.a.bk;
import com.tencent.mm.f.a.bk.b;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.f.a.jh;
import com.tencent.mm.f.a.jh.b;
import com.tencent.mm.f.a.ol;
import com.tencent.mm.f.a.ol.a;
import com.tencent.mm.f.a.rx;
import com.tencent.mm.f.a.ry;
import com.tencent.mm.f.a.ry.a;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.f.a.rz.a;
import com.tencent.mm.f.a.sk;
import com.tencent.mm.f.a.uq;
import com.tencent.mm.f.a.uq.a;
import com.tencent.mm.f.a.ur;
import com.tencent.mm.f.a.ur.a;
import com.tencent.mm.f.b.a.fo;
import com.tencent.mm.f.b.a.ll;
import com.tencent.mm.f.c.et;
import com.tencent.mm.f.c.ge;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.appbrand.openmaterial.j.a;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.comm.c.g;
import com.tencent.mm.plugin.emoji.i.g;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView.b;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.b;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.plugin.webview.ui.tools.media.h.a;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
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
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.a;
import com.tencent.mm.ui.base.MMViewPager.c;
import com.tencent.mm.ui.base.MMViewPager.d;
import com.tencent.mm.ui.base.MMViewPager.f;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.gallery.a.e.c;
import com.tencent.mm.ui.chatting.gallery.a.i.b;
import com.tencent.mm.ui.chatting.gallery.a.i.d;
import com.tencent.mm.ui.chatting.gallery.a.i.e;
import com.tencent.mm.ui.chatting.gallery.a.i.f;
import com.tencent.mm.ui.chatting.gallery.view.SearchImageBubbleView;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
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
  private Long BrO;
  private Long BrQ;
  protected MMViewPager CcM;
  private boolean EXT;
  public MMNeat7extView HyV;
  private boolean KEt;
  private MultiCodeMaskView KNZ;
  private long KOc;
  private com.tencent.mm.plugin.scanner.api.a.a KOd;
  private com.tencent.mm.plugin.scanner.api.a.b KOe;
  private com.tencent.mm.plugin.scanner.api.a.c KOf;
  int KOr;
  int KOs;
  int KOt;
  private float KOu;
  private int KOv;
  private int KOw;
  private boolean MfK;
  private View Mfr;
  protected RedesignVideoPlayerSeekBar Mfz;
  private com.tencent.mm.plugin.appbrand.openmaterial.j QdJ;
  public com.tencent.mm.plugin.webview.ui.tools.media.e QgI;
  public View Qtt;
  protected View Qtz;
  private HashSet<Long> WID;
  private boolean WNT;
  protected boolean WNU;
  public f WQM;
  private boolean WRe;
  private final boolean WRf;
  private f.b WSV;
  private RelativeLayout WSW;
  private boolean WSX;
  private boolean WSY;
  private boolean WSZ;
  private s WSo;
  private boolean WTA;
  private com.tencent.mm.ui.chatting.gallery.a.i WTB;
  private com.tencent.mm.ui.chatting.gallery.a.f WTC;
  private int WTD;
  private com.tencent.mm.plugin.scanner.api.f WTE;
  private com.tencent.mm.ui.chatting.gallery.a.j WTF;
  private boolean WTG;
  protected boolean WTH;
  protected boolean WTI;
  private boolean WTJ;
  private int WTK;
  private int WTL;
  private boolean WTM;
  private String WTN;
  private boolean WTO;
  private Long WTP;
  private ScanCodeSheetItemLogic WTQ;
  private com.tencent.mm.ui.chatting.gallery.a.e WTR;
  private com.tencent.mm.ui.chatting.gallery.a.g WTS;
  private com.tencent.mm.ui.chatting.gallery.a.h WTT;
  private com.tencent.mm.ui.chatting.gallery.a.c WTU;
  public b WTV;
  private View WTW;
  private CheckBox WTX;
  private View WTY;
  private boolean WTZ;
  public j WTa;
  private int WTb;
  private int WTc;
  private int WTd;
  private int WTe;
  private long WTf;
  private boolean WTg;
  private int WTh;
  private View WTi;
  private View WTj;
  private View WTk;
  private View WTl;
  private View WTm;
  private View WTn;
  private View WTo;
  private View WTp;
  private SearchImageBubbleView WTq;
  View WTr;
  Button WTs;
  Button WTt;
  View WTu;
  int WTv;
  int WTw;
  boolean WTx;
  ArrayList<Integer> WTy;
  private com.tencent.mm.ui.chatting.gallery.a.l WTz;
  private final c WUa;
  private String WUb;
  private AppBrandOpenMaterialCollection WUc;
  d WUd;
  private int WUe;
  private boolean WUf;
  private boolean WUg;
  private ViewPager.OnPageChangeListener WUh;
  public TextView WUi;
  public View WUj;
  public ImageView WUk;
  private boolean WUl;
  boolean WUm;
  private HashMap<Long, String> WUn;
  private boolean WUo;
  private boolean WUp;
  int WwF;
  protected String chatroomName;
  private View contentView;
  private boolean isAnimated;
  public ImageView jiu;
  private MMHandler mHandler;
  private ImageView mLT;
  public long msgId;
  private com.tencent.mm.ui.widget.a.e rZT;
  public long syu;
  protected String talker;
  Bundle twA;
  com.tencent.mm.ui.tools.f twB;
  int twC;
  int twD;
  int twE;
  int twF;
  private q.g uMM;
  public boolean wIf;
  private com.tencent.mm.plugin.scanner.word.a wNb;
  private volatile int wNc;
  private int wNd;
  private ImageView wNf;
  private ImageView wNg;
  private ImageView wNh;
  private ValueAnimator wNi;
  private IListener<ur> wNj;
  private com.tencent.mm.network.p wNk;
  MTimerHandler wTF;
  private RelativeLayout wTw;
  public View xoJ;
  public TextView xoK;
  
  public ImageGalleryUI()
  {
    AppMethodBeat.i(36149);
    this.MfK = false;
    this.WSY = false;
    this.WSZ = true;
    this.WTa = new j();
    this.WTb = 0;
    this.WTc = 0;
    this.WTd = 0;
    this.WTe = 0;
    this.WTf = 0L;
    this.WTg = false;
    this.WTh = 0;
    this.WTi = null;
    this.KOt = 0;
    this.WTv = 0;
    this.WTw = 0;
    this.twC = 0;
    this.twD = 0;
    this.twE = 0;
    this.twF = 0;
    this.WTy = new ArrayList();
    this.WNT = false;
    this.wIf = false;
    this.WTz = new com.tencent.mm.ui.chatting.gallery.a.l();
    this.WTA = false;
    this.WTC = new com.tencent.mm.ui.chatting.gallery.a.f();
    this.WTD = 0;
    this.WTF = new com.tencent.mm.ui.chatting.gallery.a.j();
    this.WTH = false;
    this.WNU = false;
    this.WTI = false;
    this.isAnimated = false;
    this.WRe = false;
    this.WTK = -1;
    this.wNd = 0;
    this.WRf = false;
    this.WTN = null;
    this.BrO = Long.valueOf(0L);
    this.WTP = Long.valueOf(0L);
    this.BrQ = Long.valueOf(0L);
    this.WTR = new com.tencent.mm.ui.chatting.gallery.a.e();
    this.WTS = new com.tencent.mm.ui.chatting.gallery.a.g()
    {
      public final void b(ry paramAnonymousry)
      {
        AppMethodBeat.i(219121);
        String str1 = ImageGalleryUI.a(ImageGalleryUI.this);
        String str2 = com.tencent.mm.vfs.u.n(str1, false);
        if ((str2 == null) || (!str2.equals(paramAnonymousry.fRk.filePath)))
        {
          Log.e("MicroMsg.ImageGalleryUI", "not same filepath");
          AppMethodBeat.o(219121);
          return;
        }
        ImageGalleryUI.c(ImageGalleryUI.this).hSz();
        Log.i("MicroMsg.ImageGalleryUI", "scanCode onFailed result: %s, curPath: %s, path: %s", new Object[] { paramAnonymousry.fRk.result, str2, str1 });
        if (ImageGalleryUI.e(ImageGalleryUI.this).awu(2) != 1) {
          ImageGalleryUI.e(ImageGalleryUI.this).mA(2, 2);
        }
        ImageGalleryUI.a(ImageGalleryUI.this, 2);
        if ((!ImageGalleryUI.g(ImageGalleryUI.this)) && (ImageGalleryUI.f(ImageGalleryUI.this) != null) && (ImageGalleryUI.f(ImageGalleryUI.this).isShowing()) && (ImageGalleryUI.h(ImageGalleryUI.this) != null))
        {
          Log.i("MicroMsg.ImageGalleryUI", "scanCode onFailed, show enhance bottomSheet");
          ImageGalleryUI.h(ImageGalleryUI.this).a(j.a.qmM);
        }
        AppMethodBeat.o(219121);
      }
      
      public final void g(rz paramAnonymousrz)
      {
        AppMethodBeat.i(219109);
        Object localObject1 = ImageGalleryUI.a(ImageGalleryUI.this);
        String str = com.tencent.mm.vfs.u.n((String)localObject1, false);
        if ((str == null) || (!str.equals(paramAnonymousrz.fRl.filePath)))
        {
          Log.e("MicroMsg.ImageGalleryUI", "not same filepath");
          AppMethodBeat.o(219109);
          return;
        }
        ImageGalleryUI.a(ImageGalleryUI.this, Long.valueOf(System.currentTimeMillis()));
        ImageGalleryUI.b(ImageGalleryUI.this, Long.valueOf(System.currentTimeMillis() - ImageGalleryUI.b(ImageGalleryUI.this).longValue()));
        ImageGalleryUI.c(ImageGalleryUI.this).hSz();
        Object localObject2 = com.tencent.mm.pluginsdk.ui.tools.p.RxG;
        localObject2 = com.tencent.mm.pluginsdk.ui.tools.p.b(paramAnonymousrz);
        Log.i("MicroMsg.ImageGalleryUI", "scanCode onSuccess data size: %d, recognizeType: %d, curPath: %s, path: %s", new Object[] { Integer.valueOf(((ArrayList)localObject2).size()), Integer.valueOf(paramAnonymousrz.fRl.fRj), str, localObject1 });
        if (!Util.isNullOrNil((List)localObject2))
        {
          localObject1 = ImageGalleryUI.d(ImageGalleryUI.this);
          kotlin.g.b.p.k(paramAnonymousrz, "event");
          ((com.tencent.mm.ui.chatting.gallery.a.l)localObject1).reset();
          localObject2 = com.tencent.mm.pluginsdk.ui.tools.p.RxG;
          ((com.tencent.mm.ui.chatting.gallery.a.l)localObject1).WXT = com.tencent.mm.pluginsdk.ui.tools.p.b(paramAnonymousrz);
          ImageGalleryUI.d(ImageGalleryUI.this).fyx = str;
          ImageGalleryUI.e(ImageGalleryUI.this).mA(2, 1);
          ImageGalleryUI.e(ImageGalleryUI.this).e(2, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(269492);
              if ((ImageGalleryUI.f(ImageGalleryUI.this) != null) && (ImageGalleryUI.f(ImageGalleryUI.this).isShowing()))
              {
                ImageGalleryUI.this.bXF();
                if ((ImageGalleryUI.g(ImageGalleryUI.this)) && (ImageGalleryUI.h(ImageGalleryUI.this) != null))
                {
                  Log.i("MicroMsg.ImageGalleryUI", "scanCode onSuccess, hide enhance bottomSheet");
                  ImageGalleryUI.h(ImageGalleryUI.this).a(j.a.qmO);
                  AppMethodBeat.o(269492);
                }
              }
              else
              {
                ImageGalleryUI.a(ImageGalleryUI.this, 2);
              }
              AppMethodBeat.o(269492);
            }
          });
          if (2 != paramAnonymousrz.fRl.fRj) {
            break label576;
          }
          if (ImageGalleryUI.d(ImageGalleryUI.this).WXT.size() != 1) {
            break label415;
          }
          paramAnonymousrz = (ImageQBarDataBean)ImageGalleryUI.d(ImageGalleryUI.this).WXT.get(0);
          ImageGalleryUI.d(ImageGalleryUI.this).WXV = paramAnonymousrz;
          ImageGalleryUI.d(ImageGalleryUI.this).WXU = null;
          ImageGalleryUI.i(ImageGalleryUI.this).ck(paramAnonymousrz.fys, paramAnonymousrz.IAH);
        }
        for (;;)
        {
          if ((!ImageGalleryUI.g(ImageGalleryUI.this)) && (!bs.P(ImageGalleryUI.this.WQM.avt(ImageGalleryUI.j(ImageGalleryUI.this)))) && (ImageGalleryUI.f(ImageGalleryUI.this) != null) && (ImageGalleryUI.f(ImageGalleryUI.this).isShowing()) && (ImageGalleryUI.h(ImageGalleryUI.this) != null))
          {
            Log.i("MicroMsg.ImageGalleryUI", "scanCode onSuccess, show enhance bottomSheet");
            ImageGalleryUI.h(ImageGalleryUI.this).a(j.a.qmM);
          }
          AppMethodBeat.o(219109);
          return;
          label415:
          paramAnonymousrz = (ArrayList)com.tencent.mm.plugin.scanner.i.a(ImageGalleryUI.this, ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.WQM, ImageGalleryUI.this.CcM), ImageGalleryUI.d(ImageGalleryUI.this).WXT, 0).Mx;
          if (paramAnonymousrz.size() == 1)
          {
            paramAnonymousrz = (ImageQBarDataBean)paramAnonymousrz.get(0);
            ImageGalleryUI.d(ImageGalleryUI.this).WXU = paramAnonymousrz;
            ImageGalleryUI.d(ImageGalleryUI.this).WXV = paramAnonymousrz;
            ImageGalleryUI.i(ImageGalleryUI.this).ck(paramAnonymousrz.fys, paramAnonymousrz.IAH);
          }
          else
          {
            ImageGalleryUI.d(ImageGalleryUI.this).WXU = null;
            ImageGalleryUI.d(ImageGalleryUI.this).WXV = null;
            if ((ImageGalleryUI.f(ImageGalleryUI.this) != null) && (ImageGalleryUI.f(ImageGalleryUI.this).isShowing()))
            {
              ImageGalleryUI.this.bXF();
              continue;
              label576:
              if (3 == paramAnonymousrz.fRl.fRj)
              {
                ImageGalleryUI.d(ImageGalleryUI.this).WXV = null;
                ImageGalleryUI.d(ImageGalleryUI.this).WXU = null;
                ImageGalleryUI.a(ImageGalleryUI.this, true);
              }
            }
          }
        }
      }
    };
    this.WTT = new com.tencent.mm.ui.chatting.gallery.a.h()
    {
      public final void a(ol paramAnonymousol)
      {
        int i = 1;
        AppMethodBeat.i(198772);
        Log.i("MicroMsg.ImageGalleryUI", "handleCode callback notifyEvent: %d", new Object[] { Integer.valueOf(paramAnonymousol.fNm.fNk) });
        if (ImageGalleryUI.l(ImageGalleryUI.k(ImageGalleryUI.this)) != null) {
          ImageGalleryUI.l(ImageGalleryUI.k(ImageGalleryUI.this)).setOnClickListener(ImageGalleryUI.this);
        }
        if ((paramAnonymousol.fNm.activity != ImageGalleryUI.this) || (!paramAnonymousol.fNm.fwI.equals(((ImageQBarDataBean)ImageGalleryUI.d(ImageGalleryUI.this).WXT.get(0)).IAH)))
        {
          Log.e("MicroMsg.ImageGalleryUI", "handleCode callback not the same");
          AppMethodBeat.o(198772);
          return;
        }
        switch (paramAnonymousol.fNm.fNk)
        {
        default: 
          AppMethodBeat.o(198772);
          return;
        case 0: 
        case 1: 
        case 2: 
          ImageGalleryUI.m(ImageGalleryUI.this).aws(2);
          ImageGalleryUI.hO(ImageGalleryUI.o(ImageGalleryUI.n(ImageGalleryUI.this)));
          AppMethodBeat.o(198772);
          return;
        }
        paramAnonymousol = paramAnonymousol.fNm.fNn;
        if (paramAnonymousol != null) {}
        for (boolean bool = paramAnonymousol.getBoolean("key_scan_qr_code_result", true);; bool = true)
        {
          paramAnonymousol = ImageGalleryUI.m(ImageGalleryUI.this);
          if (bool) {}
          for (;;)
          {
            paramAnonymousol.aws(i);
            ImageGalleryUI.this.finish();
            break;
            i = 2;
          }
        }
      }
    };
    this.WSo = new s()
    {
      public final void aB(long paramAnonymousLong, int paramAnonymousInt)
      {
        AppMethodBeat.i(274242);
        Log.i("MicroMsg.ImageGalleryUI", "alvinluo onImageDownloaded msgId: %d, currentMsgId: %d, compressType: %d", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(ImageGalleryUI.p(ImageGalleryUI.this)), Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousLong == ImageGalleryUI.p(ImageGalleryUI.this)) && (!h.awd(paramAnonymousInt))) {
          ImageGalleryUI.a(ImageGalleryUI.this, paramAnonymousLong);
        }
        AppMethodBeat.o(274242);
      }
      
      public final void b(long paramAnonymousLong, View paramAnonymousView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(274241);
        if ((paramAnonymousView != null) && (paramAnonymousBitmap != null) && (!Util.isNullOrNil(paramAnonymousString)))
        {
          Log.i("MicroMsg.ImageGalleryUI", "alvinluo onImageLoaded msgId: %d, currentMsgId: %d, imagePath: %s, bitmap: %s", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(ImageGalleryUI.p(ImageGalleryUI.this)), paramAnonymousString, Integer.valueOf(paramAnonymousBitmap.hashCode()) });
          ImageGalleryUI.a(ImageGalleryUI.this, paramAnonymousView, paramAnonymousString, paramAnonymousBitmap, ImageGalleryUI.q(ImageGalleryUI.this));
          if (paramAnonymousLong == ImageGalleryUI.p(ImageGalleryUI.this)) {
            ImageGalleryUI.a(ImageGalleryUI.this, paramAnonymousLong);
          }
        }
        AppMethodBeat.o(274241);
      }
    };
    this.WTU = new com.tencent.mm.ui.chatting.gallery.a.c()
    {
      public final void bzz(String paramAnonymousString)
      {
        AppMethodBeat.i(272778);
        if (ImageGalleryUI.this.WQM == null)
        {
          AppMethodBeat.o(272778);
          return;
        }
        Object localObject1 = ImageGalleryUI.this.WQM.avt(ImageGalleryUI.j(ImageGalleryUI.this));
        if (localObject1 == null)
        {
          AppMethodBeat.o(272778);
          return;
        }
        boolean bool = com.tencent.mm.model.ab.Lj(((et)localObject1).field_talker);
        Object localObject3 = ImageGalleryUI.m(ImageGalleryUI.this);
        long l = ((et)localObject1).field_msgSvrId;
        int i;
        Object localObject2;
        if (bool)
        {
          i = 2;
          localObject2 = ImageGalleryUI.n((ca)localObject1, bool);
          if (!bool) {
            break label241;
          }
          localObject1 = ((et)localObject1).field_talker;
          label101:
          localObject3 = ((com.tencent.mm.ui.chatting.gallery.a.e)localObject3).WWU;
          if (localObject3 == null) {
            break label248;
          }
          String str = String.valueOf(System.currentTimeMillis());
          kotlin.g.b.p.k(str, "<set-?>");
          ((e.c)localObject3).sessionId = str;
          ((e.c)localObject3).msgId = l;
          ((e.c)localObject3).scene = 67;
          ((e.c)localObject3).chatType = i;
          if (localObject2 != null) {
            break label254;
          }
          localObject2 = "";
        }
        label241:
        label248:
        label254:
        for (;;)
        {
          kotlin.g.b.p.k(localObject2, "<set-?>");
          ((e.c)localObject3).WXa = ((String)localObject2);
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          kotlin.g.b.p.k(localObject2, "<set-?>");
          ((e.c)localObject3).uxC = ((String)localObject2);
          localObject1 = paramAnonymousString;
          if (paramAnonymousString == null) {
            localObject1 = "";
          }
          kotlin.g.b.p.k(localObject1, "<set-?>");
          ((e.c)localObject3).imagePath = ((String)localObject1);
          AppMethodBeat.o(272778);
          return;
          i = 1;
          break;
          localObject1 = "";
          break label101;
          AppMethodBeat.o(272778);
          return;
        }
      }
    };
    this.KOc = 0L;
    this.KOd = null;
    this.KOe = ((com.tencent.mm.plugin.scanner.api.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.scanner.api.b.class)).fBV();
    this.KOf = new com.tencent.mm.plugin.scanner.api.a.c()
    {
      public final void fBY()
      {
        AppMethodBeat.i(288497);
        ImageGalleryUI.r(ImageGalleryUI.this);
        AppMethodBeat.o(288497);
      }
      
      public final void fBZ()
      {
        AppMethodBeat.i(288500);
        Log.i("MicroMsg.ImageGalleryUI", "alvinluo dealWithImageOcr onDialogShow");
        ImageGalleryUI.t(ImageGalleryUI.this);
        AppMethodBeat.o(288500);
      }
      
      public final void fCa()
      {
        AppMethodBeat.i(288499);
        ImageGalleryUI.s(ImageGalleryUI.this);
        AppMethodBeat.o(288499);
      }
      
      public final void fCb()
      {
        AppMethodBeat.i(288498);
        ImageGalleryUI.s(ImageGalleryUI.this);
        ImageGalleryUI.t(ImageGalleryUI.this);
        AppMethodBeat.o(288498);
      }
    };
    this.wNk = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(282373);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(271065);
            if ((com.tencent.mm.kernel.h.aGY().bih() != 6) && (com.tencent.mm.kernel.h.aGY().bih() != 4))
            {
              if (ImageGalleryUI.u(ImageGalleryUI.this) == 1)
              {
                com.tencent.mm.ui.base.h.c(ImageGalleryUI.this, ImageGalleryUI.this.getString(R.l.app_network_unavailable), "", true);
                ImageGalleryUI.v(ImageGalleryUI.this);
                ImageGalleryUI.m(ImageGalleryUI.this).aws(2);
                AppMethodBeat.o(271065);
              }
            }
            else
            {
              if (ImageGalleryUI.this.WQM == null)
              {
                AppMethodBeat.o(271065);
                return;
              }
              int i = ImageGalleryUI.this.getCurrentItem();
              ca localca = ImageGalleryUI.this.WQM.avt(i);
              if ((localca != null) && (localca.dlS()))
              {
                if (ImageGalleryUI.this.WQM.hRG() == null) {
                  ImageGalleryUI.this.WQM.hRG().hSL();
                }
                if ((ImageGalleryUI.this.WQM.hRG().hSL().WVM.getVisibility() == 0) || (ImageGalleryUI.this.WQM.hRG().hSL().WVV.getVisibility() == 0)) {
                  ImageGalleryUI.this.WQM.avV(i);
                }
              }
            }
            AppMethodBeat.o(271065);
          }
        });
        AppMethodBeat.o(282373);
      }
    };
    this.WTZ = true;
    this.KOu = 1.0F;
    this.KOv = 0;
    this.KOw = 0;
    this.WUa = new c((byte)0);
    this.WUb = null;
    this.WUc = null;
    this.QdJ = null;
    this.WUd = null;
    this.uMM = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(270976);
        if ((ImageGalleryUI.this == null) || (ImageGalleryUI.this.isDestroyed()) || (ImageGalleryUI.this.isFinishing()))
        {
          Log.i("MicroMsg.ImageGalleryUI", "receive onMMMenuItemSelected but activity is invalid");
          AppMethodBeat.o(270976);
          return;
        }
        ImageGalleryUI.Z(ImageGalleryUI.this).reset();
        Log.i("MicroMsg.ImageGalleryUI", "curTransState %d", new Object[] { Integer.valueOf(ImageGalleryUI.u(ImageGalleryUI.this)) });
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(270976);
          return;
          paramAnonymousMenuItem = ImageGalleryUI.this.WQM.hRF();
          Object localObject;
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.dlR()))
          {
            localObject = com.tencent.mm.modelvideo.y.Yk(paramAnonymousMenuItem.field_imgPath);
            if ((localObject != null) && (((w)localObject).status != 199) && (((w)localObject).status != 199))
            {
              ImageGalleryUI.a(ImageGalleryUI.this, com.tencent.mm.modelvideo.y.g(paramAnonymousMenuItem.field_msgId, 1));
              ImageGalleryUI.this.WQM.avW(ImageGalleryUI.this.CcM.getCurrentItem());
            }
          }
          for (;;)
          {
            if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.dlS()))
            {
              localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.Qtn;
              com.tencent.mm.plugin.webview.ui.tools.media.a.aR(1, ImageGalleryUI.ab(ImageGalleryUI.this), ImageGalleryUI.ac(ImageGalleryUI.this));
              localObject = n.cG(paramAnonymousMenuItem);
              if (localObject != null)
              {
                h.a locala = com.tencent.mm.plugin.webview.ui.tools.media.h.Quy;
                h.a.i(1, ((com.tencent.mm.aj.y)localObject).RPa, ((com.tencent.mm.aj.y)localObject).ROZ, ImageGalleryUI.this.WTa.QtB);
              }
            }
            if (bs.F(paramAnonymousMenuItem))
            {
              localObject = new ll();
              ((ll)localObject).ghT = paramAnonymousMenuItem.field_msgSvrId;
              ((ll)localObject).gKR = paramAnonymousMenuItem.getType();
              ((ll)localObject).gQQ = bs.E(paramAnonymousMenuItem);
              ((ll)localObject).gef = 5L;
              ((ll)localObject).bpa();
            }
            AppMethodBeat.o(270976);
            return;
            ImageGalleryUI.this.WQM.avR(ImageGalleryUI.this.CcM.getCurrentItem());
            continue;
            ImageGalleryUI.this.WQM.avR(ImageGalleryUI.this.CcM.getCurrentItem());
          }
          paramAnonymousMenuItem = ImageGalleryUI.this.WQM.hRF();
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.dlS()))
          {
            localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.Qtn;
            com.tencent.mm.plugin.webview.ui.tools.media.a.aR(4, ImageGalleryUI.ab(ImageGalleryUI.this), ImageGalleryUI.ac(ImageGalleryUI.this));
            paramAnonymousMenuItem = n.cG(paramAnonymousMenuItem);
            if (paramAnonymousMenuItem != null) {
              ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(paramAnonymousMenuItem, ImageGalleryUI.this, ImageGalleryUI.this.WTa.QtB);
            }
            AppMethodBeat.o(270976);
            return;
            paramAnonymousMenuItem = ImageGalleryUI.this.WQM.hRF();
            if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.dlR()))
            {
              localObject = com.tencent.mm.modelvideo.y.Yk(paramAnonymousMenuItem.field_imgPath);
              if ((localObject != null) && (((w)localObject).status != 199) && (((w)localObject).status != 199))
              {
                ImageGalleryUI.a(ImageGalleryUI.this, com.tencent.mm.modelvideo.y.g(paramAnonymousMenuItem.field_msgId, 2));
                ImageGalleryUI.this.WQM.avW(ImageGalleryUI.this.CcM.getCurrentItem());
              }
            }
            for (;;)
            {
              if (bs.F(paramAnonymousMenuItem))
              {
                localObject = new ll();
                ((ll)localObject).ghT = paramAnonymousMenuItem.field_msgSvrId;
                ((ll)localObject).gKR = paramAnonymousMenuItem.getType();
                ((ll)localObject).gQQ = bs.E(paramAnonymousMenuItem);
                ((ll)localObject).gef = 7L;
                ((ll)localObject).bpa();
              }
              AppMethodBeat.o(270976);
              return;
              localObject = new ArrayList();
              ((List)localObject).add(ImageGalleryUI.this.WQM.hRF());
              f.f(ImageGalleryUI.this.getContext(), (List)localObject);
              continue;
              localObject = new ArrayList();
              ((List)localObject).add(ImageGalleryUI.this.WQM.hRF());
              com.tencent.mm.modelstat.b.mcf.an((ca)((List)localObject).get(0));
              f.f(ImageGalleryUI.this.getContext(), (List)localObject);
            }
            ImageGalleryUI.this.WQM.avS(ImageGalleryUI.this.CcM.getCurrentItem());
            AppMethodBeat.o(270976);
            return;
            if (com.tencent.mm.by.c.blP("favorite"))
            {
              ImageGalleryUI.this.WQM.avT(ImageGalleryUI.this.CcM.getCurrentItem());
              paramAnonymousMenuItem = ImageGalleryUI.this.WQM.hRF();
              if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.dlS()))
              {
                paramAnonymousMenuItem = com.tencent.mm.plugin.webview.ui.tools.media.a.Qtn;
                com.tencent.mm.plugin.webview.ui.tools.media.a.aR(2, ImageGalleryUI.ab(ImageGalleryUI.this), ImageGalleryUI.ac(ImageGalleryUI.this));
              }
              AppMethodBeat.o(270976);
              return;
              ImageGalleryUI.af(ImageGalleryUI.this);
              AppMethodBeat.o(270976);
              return;
              if (ImageGalleryUI.this.WQM != null)
              {
                if (f.j(ImageGalleryUI.this.WQM.hRF())) {
                  ImageGalleryUI.ag(ImageGalleryUI.this);
                }
                AppMethodBeat.o(270976);
                return;
                if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(ImageGalleryUI.this.getContext()))
                {
                  ImageGalleryUI.ah(ImageGalleryUI.this);
                  AppMethodBeat.o(270976);
                  return;
                  Log.i("MicroMsg.ImageGalleryUI", "request deal QBAR string");
                  if ((ImageGalleryUI.f(ImageGalleryUI.this) != null) && (ImageGalleryUI.f(ImageGalleryUI.this).isShowing())) {
                    ImageGalleryUI.f(ImageGalleryUI.this).bYF();
                  }
                  paramAnonymousMenuItem = Util.safeFormatString("%d,%d", new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
                  Log.i("MicroMsg.ImageGalleryUI", "18684 report:".concat(String.valueOf(paramAnonymousMenuItem)));
                  com.tencent.mm.plugin.report.service.h.IzE.kvStat(18684, paramAnonymousMenuItem);
                  ImageGalleryUI.a(ImageGalleryUI.this, false);
                  AppMethodBeat.o(270976);
                  return;
                  ImageGalleryUI.b(ImageGalleryUI.this, System.currentTimeMillis());
                  AppMethodBeat.o(270976);
                  return;
                  ImageGalleryUI.ai(ImageGalleryUI.this);
                }
              }
            }
          }
        }
      }
    };
    this.wNj = new IListener() {};
    this.WUe = 0;
    this.WUf = false;
    this.WUg = true;
    this.WUh = new ViewPager.OnPageChangeListener()
    {
      private boolean WUy = false;
      
      public final void onPageScrollStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(205856);
        Log.d("MicroMsg.ImageGalleryUI", "onPageScrollStateChanged: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 2) {
          ImageGalleryUI.d(ImageGalleryUI.this, true);
        }
        if (paramAnonymousInt == 0)
        {
          this.WUy = false;
          ImageGalleryUI.ap(ImageGalleryUI.this);
          ImageGalleryUI.d(ImageGalleryUI.this, false);
        }
        if (ImageGalleryUI.this.WQM != null)
        {
          Object localObject = ImageGalleryUI.this.WQM;
          if (((f)localObject).WRa != null)
          {
            localObject = ((f)localObject).WRa;
            ((h)localObject).mScrollState = paramAnonymousInt;
            if (((h)localObject).WSq != null) {
              ((h)localObject).WSq.onPageScrollStateChanged(paramAnonymousInt);
            }
          }
        }
        AppMethodBeat.o(205856);
      }
      
      public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        AppMethodBeat.i(205854);
        Log.v("MicroMsg.ImageGalleryUI", "position: %d, positionOffset: %f, positionOffsetPixels: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Float.valueOf(paramAnonymousFloat), Integer.valueOf(paramAnonymousInt2) });
        if ((!this.WUy) && (paramAnonymousInt2 > 0)) {
          this.WUy = true;
        }
        AppMethodBeat.o(205854);
      }
      
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(205853);
        Log.v("MicroMsg.ImageGalleryUI", "onPageChange position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (ImageGalleryUI.this.WQM == null)
        {
          AppMethodBeat.o(205853);
          return;
        }
        Object localObject1;
        if (ImageGalleryUI.j(ImageGalleryUI.this) != paramAnonymousInt)
        {
          if ((ImageGalleryUI.f(ImageGalleryUI.this) != null) && (ImageGalleryUI.f(ImageGalleryUI.this).isShowing())) {
            ImageGalleryUI.f(ImageGalleryUI.this).bYF();
          }
          if (!ImageGalleryUI.aj(ImageGalleryUI.this))
          {
            ImageGalleryUI.ak(ImageGalleryUI.this);
            localObject1 = ImageGalleryUI.k(ImageGalleryUI.this.WQM.hRF());
            ImageGalleryUI.m(ImageGalleryUI.this).b(2, (com.tencent.mm.ay.g)localObject1);
            ImageGalleryUI.al(ImageGalleryUI.this);
          }
          ImageGalleryUI.am(ImageGalleryUI.this);
          ImageGalleryUI.b(ImageGalleryUI.this, false);
          if (ImageGalleryUI.u(ImageGalleryUI.this) == 1) {
            ImageGalleryUI.v(ImageGalleryUI.this);
          }
          ImageGalleryUI.an(ImageGalleryUI.this);
          ImageGalleryUI.E(ImageGalleryUI.this);
        }
        if (ImageGalleryUI.this.WQM.aiI(paramAnonymousInt) == null) {
          Log.e("MicroMsg.ImageGalleryUI", "onPageSelected the view is null, position = %s ", new Object[] { Integer.valueOf(paramAnonymousInt) });
        }
        ImageGalleryUI.P(ImageGalleryUI.this);
        ImageGalleryUI.e(ImageGalleryUI.this, ImageGalleryUI.j(ImageGalleryUI.this));
        ImageGalleryUI.this.WTa.a(ImageGalleryUI.this, ImageGalleryUI.j(ImageGalleryUI.this), paramAnonymousInt);
        ImageGalleryUI.f(ImageGalleryUI.this, paramAnonymousInt);
        label461:
        long l;
        if (ImageGalleryUI.this.WQM != null)
        {
          localObject1 = ImageGalleryUI.this.WQM;
          ((f)localObject1).WRb.stopAll();
          ((f)localObject1).WRc.stopAll();
          localObject1 = ImageGalleryUI.this.WQM.avt(paramAnonymousInt);
          if (localObject1 != null)
          {
            ImageGalleryUI.c(ImageGalleryUI.this, ((et)localObject1).field_msgId);
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(((et)localObject1).field_talker);
            ImageGalleryUI.a(ImageGalleryUI.this, f.cN((ca)localObject1));
          }
          if ((f.j((ca)localObject1)) || (f.cL((ca)localObject1)))
          {
            localObject2 = ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.WQM, ImageGalleryUI.this.CcM);
            if ((localObject2 != null) && ((localObject2 instanceof com.tencent.mm.ui.base.g)))
            {
              if (!(localObject2 instanceof MultiTouchImageView)) {
                break label670;
              }
              ((MultiTouchImageView)localObject2).hJx();
            }
            String str = ImageGalleryUI.a(ImageGalleryUI.this);
            if (!com.tencent.mm.plugin.scanner.n.fBN()) {
              break label692;
            }
            ImageGalleryUI.a(ImageGalleryUI.this, str, false);
            ImageGalleryUI.a(ImageGalleryUI.this, (View)localObject2, com.tencent.mm.vfs.u.n(str, false), null, ImageGalleryUI.q(ImageGalleryUI.this));
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).aA((ca)localObject1);
            ImageGalleryUI.a(ImageGalleryUI.this, ((et)localObject1).field_msgId);
          }
          if (localObject1 != null) {
            ImageGalleryUI.this.Wd(((et)localObject1).field_msgId);
          }
          if (ImageGalleryUI.this.WQM == null) {
            break label713;
          }
          localObject2 = ImageGalleryUI.this.WQM.i((ca)localObject1, false);
          if (!f.b((ca)localObject1, (com.tencent.mm.ay.g)localObject2)) {
            break label721;
          }
          localObject1 = com.tencent.mm.ay.h.a((com.tencent.mm.ay.g)localObject2);
          int i = ((com.tencent.mm.ay.g)localObject1).lAW;
          int j = ((com.tencent.mm.ay.g)localObject1).offset;
          if (i == 0) {
            break label707;
          }
          l = j * 100L / i - 1L;
          label599:
          i = Math.max(1, (int)l);
          Log.d("MicroMsg.ImageGalleryUI", "jacks loading hd from imgInfo : %d, time: %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()) });
          ImageGalleryUI.this.awl(i);
        }
        for (;;)
        {
          if (ImageGalleryUI.this.WQM != null) {
            ImageGalleryUI.this.WQM.onPageSelected(paramAnonymousInt);
          }
          AppMethodBeat.o(205853);
          return;
          label670:
          if (!(localObject2 instanceof WxImageView)) {
            break;
          }
          ((WxImageView)localObject2).hJx();
          break;
          label692:
          ImageGalleryUI.e(ImageGalleryUI.this).mA(1, 2);
          break label461;
          label707:
          l = 0L;
          break label599;
          label713:
          Log.e("MicroMsg.ImageGalleryUI", "[arthurdan.ImageGallery] Notice!!! adapter is null");
          label721:
          if (localObject1 != null) {
            break label744;
          }
          Log.e("MicroMsg.ImageGalleryUI", "update footer fail, msg is null, position = ".concat(String.valueOf(paramAnonymousInt)));
        }
        label744:
        Object localObject2 = ImageGalleryUI.this;
        if (!ImageGalleryUI.aj(ImageGalleryUI.this)) {}
        for (boolean bool = true;; bool = false)
        {
          ((ImageGalleryUI)localObject2).m((ca)localObject1, bool);
          ImageGalleryUI.ao(ImageGalleryUI.this);
          break;
        }
      }
    };
    this.Qtt = null;
    this.WUl = false;
    this.WUm = false;
    this.wTF = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(280369);
        if (ImageGalleryUI.aq(ImageGalleryUI.this)) {
          ImageGalleryUI.this.hSh();
        }
        AppMethodBeat.o(280369);
        return false;
      }
    }, false);
    this.WUn = new HashMap();
    this.WUo = false;
    this.WUp = false;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.WID = new HashSet();
    AppMethodBeat.o(36149);
  }
  
  private static void D(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(289136);
    if (paramView == null)
    {
      AppMethodBeat.o(289136);
      return;
    }
    Log.d("MicroMsg.ImageGalleryUI", "alvinluo showButton view: %s, withAnimation: %b", new Object[] { paramView, Boolean.valueOf(paramBoolean) });
    paramView.setVisibility(0);
    if (paramBoolean)
    {
      paramView.setAlpha(0.0F);
      com.tencent.mm.ui.chatting.gallery.a.k.hP(paramView);
      AppMethodBeat.o(289136);
      return;
    }
    paramView.setAlpha(1.0F);
    AppMethodBeat.o(289136);
  }
  
  private static void E(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(289137);
    Log.d("MicroMsg.ImageGalleryUI", "alvinluo hideButton view: %s, withAnimation: %b", new Object[] { paramView, Boolean.valueOf(paramBoolean) });
    if (paramView == null)
    {
      AppMethodBeat.o(289137);
      return;
    }
    if (!paramBoolean)
    {
      aQ(paramView, 8);
      com.tencent.mm.ui.chatting.gallery.a.k.hR(paramView);
      AppMethodBeat.o(289137);
      return;
    }
    if (paramView.getVisibility() == 0) {
      com.tencent.mm.ui.chatting.gallery.a.k.hQ(paramView);
    }
    AppMethodBeat.o(289137);
  }
  
  private boolean GA(boolean paramBoolean)
  {
    AppMethodBeat.i(289143);
    if (!hSl())
    {
      AppMethodBeat.o(289143);
      return false;
    }
    boolean bool2 = this.WTC.qt(1);
    boolean bool1;
    fo localfo;
    if ((this.WTM) && (bool2) && (!hSa()))
    {
      bool1 = true;
      Log.v("MicroMsg.ImageGalleryUI", "showScanTranslateButton showQuickTrans: %b, showTranslateResult: %b, show: %b", new Object[] { Boolean.valueOf(this.WTM), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (!bool1) {
        break label231;
      }
      localfo = new fo();
      if (this.wNd != 2) {
        break label225;
      }
    }
    label225:
    for (long l = 1L;; l = 0L)
    {
      localfo.gnP = l;
      localfo.gef = 8L;
      localfo.gBe = 10L;
      if (this.WQM != null)
      {
        com.tencent.mm.ay.g localg = h.k(this.WQM.hRF());
        if (localg != null)
        {
          localfo.uU(localg.getFileId());
          localfo.uV(localg.getAesKey());
        }
      }
      localfo.bpa();
      this.WTR.awp(3);
      if (this.WTn.getVisibility() != 0) {
        aQ(this.WTn, 0);
      }
      AppMethodBeat.o(289143);
      return true;
      bool1 = false;
      break;
    }
    label231:
    if (paramBoolean) {
      aQ(this.WTn, 8);
    }
    AppMethodBeat.o(289143);
    return false;
  }
  
  private boolean GB(boolean paramBoolean)
  {
    AppMethodBeat.i(289146);
    if ((!hSl()) || (!com.tencent.mm.ui.chatting.gallery.a.d.hSY()))
    {
      AppMethodBeat.o(289146);
      return false;
    }
    if ((!hLD()) && (!hSa()) && (this.WTC.qt(4))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ImageGalleryUI", "alvinluo showSearchImageButton showButton: %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      aQ(hRW().Mfr, 0);
      this.WTR.awt(3);
      AppMethodBeat.o(289146);
      return true;
    }
    if (paramBoolean) {
      aQ(hRW().Mfr, 8);
    }
    AppMethodBeat.o(289146);
    return false;
  }
  
  private boolean GC(boolean paramBoolean)
  {
    AppMethodBeat.i(289148);
    if ((!hSl()) || (!com.tencent.mm.ui.chatting.gallery.a.d.hSZ()))
    {
      AppMethodBeat.o(289148);
      return false;
    }
    boolean bool;
    label113:
    Object localObject;
    int i;
    if ((!hLD()) && (!hSa()) && (this.WTE != null) && (!Util.isNullOrNil(this.WTE.IGH)) && (this.WTC.qt(3)))
    {
      bool = true;
      Log.i("MicroMsg.ImageGalleryUI", "alvinluo showSearchImageBubbleView showBubble: %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label391;
      }
      if (this.WSW.getVisibility() != 0) {
        break label364;
      }
      paramBoolean = true;
      localObject = hRW().Mfr;
      if (!paramBoolean) {
        break label369;
      }
      i = 0;
      label128:
      aQ((View)localObject, i);
      localObject = hRX().WTq;
      if (!paramBoolean) {
        break label375;
      }
      i = 0;
      label149:
      aQ((View)localObject, i);
      int k = this.CcM.getMeasuredWidth();
      int j = k - (this.WTb + 1) * this.WTc - this.WTe;
      i = j;
      if (this.WTb > 1) {
        i = j - this.WTb * this.WTd;
      }
      Log.i("MicroMsg.ImageGalleryUI", "alvinluo showSearchImageBubbleView visible: %b, galleryWidth: %d, showButtonCount: %d, viewPositionX: %d, bottomBtnSize: %d, bottomBtnRightExtrMargin: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(k), Integer.valueOf(this.WTb), Integer.valueOf(i), Integer.valueOf(this.WTc), Integer.valueOf(this.WTe) });
      localObject = hRX().WTq;
      ((SearchImageBubbleView)localObject).setViewWidth(k);
      ((SearchImageBubbleView)localObject).setBubbleText(this.WTE.IGH);
      ((SearchImageBubbleView)localObject).mB(this.WTc, this.WTc);
      ((SearchImageBubbleView)localObject).awA(i);
      ((SearchImageBubbleView)localObject).setBubbleClickListener(this);
      if (!paramBoolean) {
        break label381;
      }
      ((SearchImageBubbleView)localObject).show();
    }
    for (;;)
    {
      this.WTR.awt(4);
      this.WTR.awt(3);
      AppMethodBeat.o(289148);
      return true;
      bool = false;
      break;
      label364:
      paramBoolean = false;
      break label113;
      label369:
      i = 8;
      break label128;
      label375:
      i = 8;
      break label149;
      label381:
      ((SearchImageBubbleView)localObject).setVisibility(8);
    }
    label391:
    if (paramBoolean) {
      aQ(hRX().WTq, 8);
    }
    AppMethodBeat.o(289148);
    return false;
  }
  
  private void GD(boolean paramBoolean)
  {
    AppMethodBeat.i(36177);
    if ((this.WSV != f.b.WRD) || (hSa()))
    {
      aQ(this.WTr, 4);
      AppMethodBeat.o(36177);
      return;
    }
    Object localObject = null;
    if (this.WQM != null) {
      localObject = this.WQM.hRF();
    }
    if ((localObject == null) || (bs.F((ca)localObject)))
    {
      aQ(this.WTr, 4);
      AppMethodBeat.o(36177);
      return;
    }
    com.tencent.mm.ay.g localg = this.WQM.i((ca)localObject, false);
    if (paramBoolean)
    {
      this.CcM.getCurrentItem();
      if ((f((ca)localObject, localg)) && (!((ca)localObject).Ic()) && (localg.blJ()))
      {
        hRP().WTs.setVisibility(0);
        hRP().WTt.setVisibility(8);
        hRP().WTu.setVisibility(8);
        String str = (String)this.WUn.get(Long.valueOf(localg.localId));
        localObject = str;
        if (str == null)
        {
          localObject = Wb(g(localg));
          this.WUn.put(Long.valueOf(localg.localId), localObject);
        }
        hRP().WTs.setText(getString(R.l.eAD, new Object[] { localObject }));
        aQ(this.WTr, 0);
        AppMethodBeat.o(36177);
        return;
      }
    }
    aQ(this.WTr, 4);
    AppMethodBeat.o(36177);
  }
  
  private static void GE(boolean paramBoolean)
  {
    AppMethodBeat.i(36185);
    Log.d("MicroMsg.ImageGalleryUI", "switch tool bar bg %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(36185);
  }
  
  private void Gt(final boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(289113);
    Object localObject2;
    Object localObject1;
    if (this.WTB != null)
    {
      this.WTz.WXW = paramBoolean;
      this.WTz.fyw = getIntent().getBundleExtra("_stat_obj");
      localObject2 = this.WTz;
      Log.i("MicroMsg.ImageGalleryUI", "talker: %s, chatroom: %s", new Object[] { this.talker, this.chatroomName });
      localObject1 = "";
      if ((Util.isNullOrNil(this.chatroomName)) || (!com.tencent.mm.model.ab.Lj(this.chatroomName))) {
        break label279;
      }
      Log.d("MicroMsg.ImageGalleryUI", "is chatroom: %s", new Object[] { this.chatroomName });
      localObject1 = this.chatroomName;
      ((com.tencent.mm.ui.chatting.gallery.a.l)localObject2).sourceType = i;
      kotlin.g.b.p.k(localObject1, "<set-?>");
      ((com.tencent.mm.ui.chatting.gallery.a.l)localObject2).source = ((String)localObject1);
      localObject1 = this.WTz;
      if ((this.WQM != null) && (this.WQM.hRF() != null)) {
        break label429;
      }
    }
    for (;;)
    {
      localObject1 = this.WTB;
      localObject2 = a(this.WQM, this.CcM);
      com.tencent.mm.ui.chatting.gallery.a.l locall = this.WTz;
      com.tencent.mm.plugin.scanner.h local26 = new com.tencent.mm.plugin.scanner.h()
      {
        public final void a(ImageQBarDataBean paramAnonymousImageQBarDataBean, ArrayList<ImageQBarDataBean> paramAnonymousArrayList)
        {
          AppMethodBeat.i(276243);
          ImageGalleryUI.y(ImageGalleryUI.this).a(ImageGalleryUI.d(ImageGalleryUI.this), paramAnonymousImageQBarDataBean, ImageGalleryUI.z(ImageGalleryUI.this));
          paramAnonymousArrayList = com.tencent.mm.plugin.scanner.j.IAG;
          com.tencent.mm.plugin.scanner.j.b(ImageGalleryUI.w(ImageGalleryUI.this).longValue(), ImageGalleryUI.d(ImageGalleryUI.this).WXT.size(), 0, 2, "");
          paramAnonymousArrayList = com.tencent.mm.plugin.scanner.j.IAG;
          com.tencent.mm.plugin.scanner.j.a(ImageGalleryUI.w(ImageGalleryUI.this).longValue(), 1, ImageGalleryUI.d(ImageGalleryUI.this).WXT, paramAnonymousImageQBarDataBean, ImageGalleryUI.x(ImageGalleryUI.this).longValue(), paramBoolean);
          AppMethodBeat.o(276243);
        }
        
        public final void a(ArrayList<PointF> paramAnonymousArrayList, ArrayList<ImageQBarDataBean> paramAnonymousArrayList1, ArrayList<ImageQBarDataBean> paramAnonymousArrayList2)
        {
          AppMethodBeat.i(276245);
          if (ImageGalleryUI.this.CcM != null) {
            ImageGalleryUI.ae(ImageGalleryUI.ad(ImageGalleryUI.this)).a(paramAnonymousArrayList2, paramAnonymousArrayList, paramAnonymousArrayList1, ImageGalleryUI.this.CcM.getMeasuredHeight());
          }
          for (;;)
          {
            ImageGalleryUI.this.sa(false);
            paramAnonymousArrayList1 = com.tencent.mm.plugin.scanner.j.IAG;
            com.tencent.mm.plugin.scanner.j.b(ImageGalleryUI.w(ImageGalleryUI.this).longValue(), paramAnonymousArrayList2.size(), paramAnonymousArrayList.size(), 2, "");
            if (paramAnonymousArrayList.size() > 1)
            {
              paramAnonymousArrayList = com.tencent.mm.plugin.scanner.j.IAG;
              com.tencent.mm.plugin.scanner.j.a(ImageGalleryUI.w(ImageGalleryUI.this).longValue(), 11, paramAnonymousArrayList2, null, ImageGalleryUI.x(ImageGalleryUI.this).longValue(), paramBoolean);
            }
            AppMethodBeat.o(276245);
            return;
            ImageGalleryUI.ae(ImageGalleryUI.ad(ImageGalleryUI.this)).a(paramAnonymousArrayList2, paramAnonymousArrayList, paramAnonymousArrayList1, ImageGalleryUI.ae(ImageGalleryUI.ad(ImageGalleryUI.this)).getRootView().getHeight());
          }
        }
      };
      kotlin.g.b.p.k(locall, "codeResult");
      if (((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).WXo)
      {
        Log.i("MicroMsg.ImageScanCodeManager", "handleCode  qBarDataList:" + locall.WXT.size());
        com.tencent.mm.plugin.scanner.i.a((Context)((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).fDf, (View)localObject2, locall.WXT, 0, local26);
      }
      AppMethodBeat.o(289113);
      return;
      label279:
      if (!Util.isNullOrNil(this.talker))
      {
        if (com.tencent.mm.model.ab.Qm(this.talker))
        {
          Log.d("MicroMsg.ImageGalleryUI", "is biz: %s", new Object[] { this.talker });
          int j = 4;
          i = j;
          if (((com.tencent.mm.ui.chatting.gallery.a.l)localObject2).fyw != null)
          {
            ((com.tencent.mm.ui.chatting.gallery.a.l)localObject2).fyw.putString("img_gallery_talker", this.talker);
            i = j;
          }
        }
        for (;;)
        {
          localObject1 = this.talker;
          break;
          if (com.tencent.mm.model.ab.Lj(this.talker))
          {
            Log.d("MicroMsg.ImageGalleryUI", "taler is chatroom: %s", new Object[] { this.talker });
          }
          else
          {
            Log.d("MicroMsg.ImageGalleryUI", "is single chat: %s", new Object[] { this.talker });
            i = 1;
          }
        }
      }
      Log.e("MicroMsg.ImageGalleryUI", "unknow source");
      i = -1;
      break;
      label429:
      localObject2 = this.WQM.i(this.WQM.hRF(), true);
      if ((localObject2 != null) && (!Util.isNullOrNil(((com.tencent.mm.ay.g)localObject2).lNS)))
      {
        localObject2 = XmlParser.parseXml(((com.tencent.mm.ay.g)localObject2).lNS, "msg", null);
        if (localObject2 != null)
        {
          ((com.tencent.mm.ui.chatting.gallery.a.l)localObject1).fyv = ((String)((Map)localObject2).get(".msg.img.$aeskey"));
          ((com.tencent.mm.ui.chatting.gallery.a.l)localObject1).imagePath = ((String)((Map)localObject2).get(".msg.img.$cdnmidimgurl"));
        }
      }
    }
  }
  
  private void Gu(boolean paramBoolean)
  {
    AppMethodBeat.i(289120);
    String str = dlb();
    Object localObject2;
    label76:
    Object localObject1;
    if (((this.wNd == 0) || (this.wNd == 2)) && (!Util.isNullOrNil(str)))
    {
      localObject2 = new fo();
      long l;
      if (this.wNd == 2)
      {
        l = 1L;
        ((fo)localObject2).gnP = l;
        ((fo)localObject2).gef = 3L;
        if (!paramBoolean) {
          break label327;
        }
        l = 10L;
        ((fo)localObject2).gBe = l;
        localObject1 = h.k(this.WQM.hRF());
        if (localObject1 != null)
        {
          ((fo)localObject2).uU(((com.tencent.mm.ay.g)localObject1).getFileId());
          ((fo)localObject2).uV(((com.tencent.mm.ay.g)localObject1).getAesKey());
        }
        ((fo)localObject2).bpa();
        this.wNc = ((int)(z.bcZ().hashCode() + System.currentTimeMillis()));
        localObject2 = ((com.tencent.mm.plugin.scanner.f)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.scanner.f.class)).getTranslationResult(str);
        if ((localObject2 == null) || (!com.tencent.mm.vfs.u.agG(((ge)localObject2).field_resultFile))) {
          break label339;
        }
        if (this.WQM.avt(this.WUe) == null) {
          break label469;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("original_file_path", str);
        ((Intent)localObject2).putExtra("msg_id", this.WQM.avt(this.WUe).field_msgId);
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
          ((Intent)localObject2).putExtra("fileid", ((com.tencent.mm.ay.g)localObject1).getFileId());
          ((Intent)localObject2).putExtra("aeskey", ((com.tencent.mm.ay.g)localObject1).getAesKey());
        }
        startActivity(TranslationResultUI.class, (Intent)localObject2);
        finish();
        i = R.a.anim_not_change;
        overridePendingTransition(i, i);
        this.WTR.aws(1);
        AppMethodBeat.o(289120);
        return;
        l = 0L;
        break;
        l = 4L;
        break label76;
      }
      label339:
      if ((com.tencent.mm.kernel.h.aGY().bih() == 6) || (com.tencent.mm.kernel.h.aGY().bih() == 4)) {
        break label476;
      }
      com.tencent.mm.ui.base.h.c(this, getString(R.l.app_network_unavailable), "", true);
      Gw(false);
      Log.i("MicroMsg.ImageGalleryUI", "try to translate img %s, sessionId %d", new Object[] { str, Integer.valueOf(this.wNc) });
      localObject1 = new uq();
      localObject2 = ((uq)localObject1).fTT;
      if (!paramBoolean) {
        break label488;
      }
    }
    label469:
    label476:
    label488:
    for (int i = 7;; i = 1)
    {
      ((uq.a)localObject2).scene = i;
      ((uq)localObject1).fTT.filePath = str;
      ((uq)localObject1).fTT.fwM = this.wNc;
      EventCenter.instance.publish((IEvent)localObject1);
      AppMethodBeat.o(289120);
      return;
      this.wNd = 1;
      dlp();
      break;
    }
  }
  
  private void Gv(boolean paramBoolean)
  {
    AppMethodBeat.i(289122);
    this.wNf.setVisibility(8);
    this.wNg.setVisibility(8);
    this.wNh.setVisibility(8);
    if (!paramBoolean)
    {
      hSs();
      Gy(false);
    }
    AppMethodBeat.o(289122);
  }
  
  private void Gw(boolean paramBoolean)
  {
    AppMethodBeat.i(36170);
    this.wNd = 0;
    Gx(paramBoolean);
    AppMethodBeat.o(36170);
  }
  
  private void Gx(boolean paramBoolean)
  {
    AppMethodBeat.i(289124);
    Gv(paramBoolean);
    this.wNi.setRepeatMode(1);
    this.wNi.setRepeatCount(0);
    this.wNi.end();
    AppMethodBeat.o(289124);
  }
  
  private void Gy(boolean paramBoolean)
  {
    AppMethodBeat.i(289132);
    if (BuildInfo.IS_FLAVOR_RED) {
      Log.d("MicroMsg.ImageGalleryUI", "showOpLayer isShowOpToolbar: %b, pageChanged: %b, %s", new Object[] { Boolean.valueOf(this.WUm), Boolean.valueOf(paramBoolean), Util.getStack() });
    }
    if (this.WSX)
    {
      AppMethodBeat.o(289132);
      return;
    }
    if (this.WQM != null) {}
    for (ca localca = this.WQM.hRF();; localca = null)
    {
      if (localca == null)
      {
        AppMethodBeat.o(289132);
        return;
      }
      if (bs.M(localca))
      {
        Log.w("MicroMsg.ImageGalleryUI", "ignore show opLayer");
        AppMethodBeat.o(289132);
        return;
      }
      if (!this.WUm) {
        hSu();
      }
      for (boolean bool = false;; bool = true)
      {
        this.WTb = 0;
        this.WUm = true;
        this.WSW.setVisibility(0);
        hSs();
        hSk();
        l(localca, paramBoolean);
        if (!paramBoolean) {
          bV(0, true);
        }
        for (;;)
        {
          if (hSq()) {
            dme();
          }
          sa(true);
          GD(true);
          AppMethodBeat.o(289132);
          return;
          if (!hSr()) {
            bW(0, bool);
          }
        }
      }
    }
  }
  
  private boolean Gz(boolean paramBoolean)
  {
    AppMethodBeat.i(289141);
    if (!this.WTA)
    {
      AppMethodBeat.o(289141);
      return false;
    }
    boolean bool2 = hLD();
    boolean bool3 = this.WTC.qt(2);
    if ((bool3) && (!bool2) && (!hSa())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.v("MicroMsg.ImageGalleryUI", "showScanCodeButton showQRCodeResult: %b, isFromQuoteMsg: %b, show: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (!bool1) {
        break;
      }
      this.WTR.awp(2);
      if (hRT().WTo.getVisibility() != 0) {
        aQ(hRT().WTo, 0);
      }
      AppMethodBeat.o(289141);
      return true;
    }
    if (paramBoolean) {
      aQ(hRT().WTo, 8);
    }
    AppMethodBeat.o(289141);
    return false;
  }
  
  private static String Wb(long paramLong)
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
  
  private View a(f paramf, MMViewPager paramMMViewPager)
  {
    AppMethodBeat.i(36164);
    boolean bool1;
    if (paramf == null)
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
      if ((paramf == null) || (paramMMViewPager == null)) {
        break label182;
      }
      if (paramf.hRF() != null) {
        break label81;
      }
      AppMethodBeat.o(36164);
      return null;
      bool1 = false;
      break;
    }
    label81:
    Object localObject;
    if ((paramf.hRF().hwG()) || (paramf.hRF().hzF()))
    {
      MultiTouchImageView localMultiTouchImageView = paramf.Tf(paramMMViewPager.getCurrentItem());
      localObject = localMultiTouchImageView;
      if (localMultiTouchImageView == null) {
        localObject = paramf.Tg(paramMMViewPager.getCurrentItem());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(36164);
      return localObject;
      if ((paramf.hRF().dlR()) || (paramf.hRF().dlT()) || (paramf.hRF().dlS()))
      {
        localObject = paramf.avU(paramMMViewPager.getCurrentItem());
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
  
  private void a(View paramView, String paramString, Bitmap paramBitmap, int paramInt, com.tencent.mm.ui.chatting.gallery.a.g paramg)
  {
    AppMethodBeat.i(289127);
    Log.d("MicroMsg.ImageGalleryUI", "doScanImageQRCode  recognizeType:".concat(String.valueOf(paramInt)));
    if (this.WTB != null)
    {
      this.BrQ = Long.valueOf(System.currentTimeMillis());
      Object localObject1 = this.WUa;
      Log.i("MicroMsg.ImageGalleryUI", "onScanStart#ScanState, realScanImgPath: ".concat(String.valueOf(paramString)));
      Object localObject2;
      int i;
      if (!Util.isEqual(com.tencent.mm.vfs.u.n(((c)localObject1).WUq.dlb(), false), paramString))
      {
        Log.i("MicroMsg.ImageGalleryUI", "onScanStart#ScanState, not match");
        localObject1 = this.WTB;
        if (!((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).WXo) {
          break label775;
        }
        localObject2 = (CharSequence)paramString;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label413;
        }
        i = 1;
      }
      for (;;)
      {
        if (i == 0)
        {
          localObject2 = new i.b();
          ((i.b)localObject2).fwK = System.currentTimeMillis();
          kotlin.g.b.p.k(paramString, "<set-?>");
          ((i.b)localObject2).imagePath = paramString;
          ((i.b)localObject2).bitmap = paramBitmap;
          ((i.b)localObject2).fRj = paramInt;
          Log.i("MicroMsg.ImageScanCodeManager", "alvinluo scanCode session: %d, imagePath: %s, bitmap: %s, getCodePosition: %b", new Object[] { Long.valueOf(((i.b)localObject2).fwK), paramString, paramBitmap, Boolean.TRUE });
          if ((paramView instanceof com.tencent.mm.ui.base.g)) {
            Log.d("MicroMsg.ImageScanCodeManager", "alvinluo scanCode imageSize: %d, %d, screen: %d, %d, current: %s", new Object[] { Integer.valueOf(((com.tencent.mm.ui.base.g)paramView).getImageWidth()), Integer.valueOf(((com.tencent.mm.ui.base.g)paramView).getImageHeight()), Integer.valueOf(com.tencent.mm.ci.a.kr((Context)((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).fDf)), Integer.valueOf(com.tencent.mm.ci.a.ks((Context)((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).fDf)), paramView });
          }
          ((i.b)localObject2).bitmap = null;
          if (com.tencent.mm.ui.chatting.gallery.a.i.a((i.b)localObject2))
          {
            paramView = (com.tencent.mm.ui.chatting.gallery.a.i.c)((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).WXr.get(((i.b)localObject2).imagePath);
            if (paramView != null)
            {
              Log.i("MicroMsg.ImageScanCodeManager", "alvinluo scanCode get result from cache %s", new Object[] { ((i.b)localObject2).imagePath });
              if ((paramView.success) && (paramView.WXy != null))
              {
                if (paramg != null)
                {
                  paramView = paramView.WXy;
                  if (paramView == null) {
                    kotlin.g.b.p.iCn();
                  }
                  paramg.g(paramView);
                  AppMethodBeat.o(289127);
                  return;
                  ((c)localObject1).mState = 1;
                  break;
                  label413:
                  i = 0;
                  continue;
                }
                AppMethodBeat.o(289127);
                return;
              }
              if ((!paramView.success) && (paramView.WXz != null))
              {
                if (paramg != null)
                {
                  paramView = paramView.WXz;
                  if (paramView == null) {
                    kotlin.g.b.p.iCn();
                  }
                  paramg.b(paramView);
                  AppMethodBeat.o(289127);
                  return;
                }
                AppMethodBeat.o(289127);
                return;
              }
              paramView = ((i.b)localObject2).imagePath;
              ((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).WXr.remove(paramView);
            }
          }
          Log.i("MicroMsg.ImageScanCodeManager", "doScanCode from decoder  recognizeType:" + ((i.b)localObject2).fRj + "   path:" + ((i.b)localObject2).imagePath);
          if (!Util.isNullOrNil(((i.b)localObject2).imagePath))
          {
            paramView = ((i.b)localObject2).imagePath;
            if (!((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).WXq.containsKey(paramView)) {
              ((Map)((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).WXq).put(paramView, new ArrayList());
            }
            paramString = ((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).WXq.get(paramView);
            if (paramString == null) {
              kotlin.g.b.p.iCn();
            }
            if (!((ArrayList)paramString).contains(paramg))
            {
              paramString = ((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).WXq.get(paramView);
              if (paramString == null) {
                kotlin.g.b.p.iCn();
              }
              ((ArrayList)paramString).add(paramg);
            }
            if (((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).WXp.containsKey(paramView))
            {
              Log.w("MicroMsg.ImageScanCodeManager", "alvinluo scanCode image %s is already decoding and ignore", new Object[] { ((i.b)localObject2).imagePath });
              AppMethodBeat.o(289127);
              return;
            }
            ((Map)((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).WXp).put(paramView, localObject2);
            paramView = new rx();
            paramView.fRg.fwK = ((i.b)localObject2).fwK;
            paramView.fRg.filePath = ((i.b)localObject2).imagePath;
            paramView.fRg.bitmap = ((i.b)localObject2).bitmap;
            paramView.fRg.fRi = true;
            paramView.fRg.fRj = ((i.b)localObject2).fRj;
            EventCenter.instance.publish((IEvent)paramView);
          }
        }
      }
    }
    label775:
    AppMethodBeat.o(289127);
  }
  
  private void aA(long paramLong, int paramInt)
  {
    AppMethodBeat.i(289165);
    Log.i("MicroMsg.ImageGalleryUI", "dealWithSearchImage sessionId: %s, fromSource: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    ca localca = this.WQM.hRF();
    com.tencent.mm.plugin.websearch.api.o localo = new com.tencent.mm.plugin.websearch.api.o();
    localo.sessionId = paramLong;
    localo.context = this;
    localo.fNz = localca;
    localo.fyP = paramInt;
    ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(localo);
    AppMethodBeat.o(289165);
  }
  
  private static void aQ(View paramView, int paramInt)
  {
    AppMethodBeat.i(36156);
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(36156);
  }
  
  private boolean awf(int paramInt)
  {
    AppMethodBeat.i(289095);
    boolean bool = this.WTC.aww(paramInt);
    AppMethodBeat.o(289095);
    return bool;
  }
  
  private void awh(int paramInt)
  {
    AppMethodBeat.i(36181);
    ca localca = this.WQM.avt(paramInt);
    if ((localca == null) || (!localca.dlS()) || (this.WRe))
    {
      AppMethodBeat.o(36181);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(new com.tencent.mm.plugin.messenger.foundation.a.a.i.c(localca.field_talker, "update", localca));
    AppMethodBeat.o(36181);
  }
  
  private void awi(int paramInt)
  {
    AppMethodBeat.i(36189);
    Log.i("MicroMsg.ImageGalleryUI", "enterGrid source : ".concat(String.valueOf(paramInt)));
    if (this.WQM == null)
    {
      Log.w("MicroMsg.ImageGalleryUI", "try to enterGrid, but adapter is NULL");
      AppMethodBeat.o(36189);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 13L, 1L, true);
    int i = this.WQM.getRealCount();
    if (this.WQM.hRF() == null)
    {
      Log.e("MicroMsg.ImageGalleryUI", "msgInfo is null");
      AppMethodBeat.o(36189);
      return;
    }
    int j = this.WQM.WQW.awa(this.CcM.getCurrentItem());
    if (!this.WTH)
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), MediaHistoryGalleryUI.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("kintent_intent_source", paramInt);
      ((Intent)localObject).putExtra("kintent_talker", hRZ());
      ((Intent)localObject).putExtra("kintent_image_count", i);
      ((Intent)localObject).putExtra("kintent_image_index", j);
      ((Intent)localObject).putExtra("key_biz_chat_id", this.syu);
      ((Intent)localObject).putExtra("key_is_biz_chat", this.wIf);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "enterGrid", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "enterGrid", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(289339);
          ImageGalleryUI.this.finish();
          AppMethodBeat.o(289339);
        }
      }, 50L);
      AppMethodBeat.o(36189);
      return;
    }
    cJs();
    AppMethodBeat.o(36189);
  }
  
  static Animation awk(int paramInt)
  {
    AppMethodBeat.i(36199);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(paramInt);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator(10.0F));
    AppMethodBeat.o(36199);
    return localAlphaAnimation;
  }
  
  private void awm(int paramInt)
  {
    AppMethodBeat.i(36209);
    if (this.Qtt != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Qtt.getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, paramInt, 0);
      this.Qtt.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(36209);
  }
  
  private boolean bF(ArrayList<ImageQBarDataBean> paramArrayList)
  {
    AppMethodBeat.i(289116);
    if (this.WTL == 1)
    {
      AppMethodBeat.o(289116);
      return false;
    }
    if ((this.WTz == null) || (Util.isNullOrNil(this.WTz.WXT)))
    {
      AppMethodBeat.o(289116);
      return false;
    }
    if (paramArrayList.size() <= 0)
    {
      AppMethodBeat.o(289116);
      return false;
    }
    if (paramArrayList.size() > 1)
    {
      AppMethodBeat.o(289116);
      return true;
    }
    paramArrayList = ((ImageQBarDataBean)paramArrayList.get(0)).IAH;
    if (!this.WTJ)
    {
      AppMethodBeat.o(289116);
      return true;
    }
    String[] arrayOfString = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vmt, "")).split("\\|");
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
          AppMethodBeat.o(289116);
          return false;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(289116);
    return true;
  }
  
  private void bV(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(289135);
    if ((hLD()) || (hSa()))
    {
      AppMethodBeat.o(289135);
      return;
    }
    Log.d("MicroMsg.ImageGalleryUI", "alvinluo checkShowQuickButton fromType: %d, needHide: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Object localObject1 = null;
    if (Gz(paramBoolean))
    {
      localObject1 = hRT().WTo;
      paramInt = 2;
    }
    for (;;)
    {
      int i = this.WTh;
      Object localObject2;
      label102:
      Object localObject3;
      if (localObject1 != null)
      {
        localObject2 = Float.valueOf(((View)localObject1).getAlpha());
        if (localObject1 == null) {
          break label393;
        }
        localObject3 = Integer.valueOf(((View)localObject1).getVisibility());
        label117:
        Log.i("MicroMsg.ImageGalleryUI", "alvinluo checkShowQuickButton showType: %d, currentQuickButtonType: %d, targetView: %s, targetView.alpha: %s, targetView.visibility: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), localObject1, localObject2, localObject3 });
        if (paramInt == 0) {
          break label411;
        }
        i = this.WTh;
        if (paramInt != this.WTh)
        {
          if ((this.WTh != 0) && ((paramInt != 3) || (localObject1 == null) || (((View)localObject1).getVisibility() == 0))) {
            break label401;
          }
          paramBoolean = true;
          label203:
          this.WTD = 0;
          D((View)localObject1, paramBoolean);
          int j = hRX().WTq.getVisibility();
          bW(paramInt, false);
          if (this.WTh == 3)
          {
            aQ(hRX().WTq, j);
            E(hRX().WTq, true);
          }
          this.WTh = paramInt;
          this.WTi = ((View)localObject1);
        }
        if (paramInt == 3)
        {
          localObject1 = hRW().Mfr;
          if ((i != 0) || (hRP().Mfr.getVisibility() == 0)) {
            break label406;
          }
        }
      }
      label393:
      label401:
      label406:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        D((View)localObject1, paramBoolean);
        AppMethodBeat.o(289135);
        return;
        if (GC(paramBoolean))
        {
          localObject1 = hRX().WTq;
          paramInt = 3;
          break;
        }
        if (GA(paramBoolean))
        {
          localObject1 = this.WTn;
          paramInt = 1;
          break;
        }
        if (!bX(paramInt, paramBoolean)) {
          break label518;
        }
        paramInt = 4;
        localObject1 = hRW().Mfr;
        break;
        localObject2 = "null";
        break label102;
        localObject3 = "null";
        break label117;
        paramBoolean = false;
        break label203;
      }
      label411:
      if (this.WTC.hTb())
      {
        Log.i("MicroMsg.ImageGalleryUI", "alvinluo checkShowQuickButton isAllValid and hideQuickButton");
        localObject1 = this.WTi;
        if ((this.WTh == 0) || (this.WTi == null)) {
          break label508;
        }
        paramBoolean = true;
        E((View)localObject1, paramBoolean);
        if (this.WTh == 3)
        {
          localObject1 = hRW().Mfr;
          if (hRP().Mfr.getVisibility() != 0) {
            break label513;
          }
        }
      }
      label513:
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        E((View)localObject1, paramBoolean);
        hSj();
        AppMethodBeat.o(289135);
        return;
        label508:
        paramBoolean = false;
        break;
      }
      label518:
      paramInt = 0;
    }
  }
  
  private void bW(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(289138);
    if ((hLD()) || (hSa()))
    {
      AppMethodBeat.o(289138);
      return;
    }
    Log.i("MicroMsg.ImageGalleryUI", "alvinluo hideQuickButton showType: %d, withAnimation: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramInt != 2) {
      E(hRT().WTo, paramBoolean);
    }
    if (paramInt != 3) {
      E(hRX().WTq, paramBoolean);
    }
    if (paramInt != 1) {
      E(this.WTn, paramBoolean);
    }
    if (paramInt != 4) {
      E(hRW().Mfr, paramBoolean);
    }
    if (paramInt == 0) {
      hSj();
    }
    AppMethodBeat.o(289138);
  }
  
  private boolean bX(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(289150);
    if ((!hSl()) || (!com.tencent.mm.ui.chatting.gallery.a.d.hSY()))
    {
      AppMethodBeat.o(289150);
      return false;
    }
    this.WTC.mA(4, 2);
    boolean bool = this.WTC.uB(4);
    Log.i("MicroMsg.ImageGalleryUI", "alvinluo checkShowSearchImageButton fromType: %s, isSearchButtonValid: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    if (bool)
    {
      this.WTC.mA(4, 1);
      if (this.WTC.qt(4))
      {
        this.WTC.awx(4);
        paramBoolean = GB(paramBoolean);
        AppMethodBeat.o(289150);
        return paramBoolean;
      }
    }
    AppMethodBeat.o(289150);
    return false;
  }
  
  private boolean bx(Activity paramActivity)
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
  
  private void bzx(String paramString)
  {
    AppMethodBeat.i(289126);
    if (this.wNb == null) {
      this.wNb = new ImageWordScanDetailEngine(this);
    }
    if (!Util.isNullOrNil(paramString))
    {
      this.wNb.a(paramString, this);
      AppMethodBeat.o(289126);
      return;
    }
    this.WTC.mA(1, 2);
    AppMethodBeat.o(289126);
  }
  
  private void bzy(String paramString)
  {
    AppMethodBeat.i(36213);
    paramString = RecordConfigProvider.jO(paramString, "");
    paramString.scene = this.WTL;
    Object localObject = new UICustomParam.a();
    ((UICustomParam.a)localObject).avX();
    ((UICustomParam.a)localObject).avW();
    ((UICustomParam.a)localObject).dZ(true);
    paramString.HKT = ((UICustomParam.a)localObject).jwj;
    localObject = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
    com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4369, R.a.sight_slide_bottom_in, -1, paramString, 1, 2);
    AppMethodBeat.o(36213);
  }
  
  private void cJs()
  {
    AppMethodBeat.i(36165);
    if ((this.MfK) || (this.WQM == null))
    {
      Log.i("MicroMsg.ImageGalleryUI", "isRunningExitAnimation");
      AppMethodBeat.o(36165);
      return;
    }
    Gw(true);
    fVO();
    if (this.WSX)
    {
      finish();
      com.tencent.mm.ui.base.b.la(getContext());
      AppMethodBeat.o(36165);
      return;
    }
    Log.i("MicroMsg.ImageGalleryUI", "runExitAnimation");
    int k = this.CcM.getWidth() / 2;
    int j = this.CcM.getHeight() / 2;
    this.WQM.hRE();
    Object localObject1;
    int m;
    int i;
    int n;
    if (!hLD())
    {
      if (this.WTH)
      {
        localObject1 = new jh();
        ((jh)localObject1).fGy.msgId = this.WQM.avt(this.CcM.getCurrentItem()).field_msgId;
        EventCenter.instance.publish((IEvent)localObject1);
        m = ((jh)localObject1).fGz.fxg;
        i = ((jh)localObject1).fGz.fxh;
        k = ((jh)localObject1).fGz.fxe;
        j = ((jh)localObject1).fGz.fxf;
        this.KOr = this.CcM.getWidth();
        this.KOs = this.CcM.getHeight();
        n = i;
        if (this.WQM.hRF() != null)
        {
          if ((this.WQM.hRF().dlT()) || (this.WQM.hRF().dlR()) || (this.WQM.hRF().dlS())) {
            this.KOs = ((int)(this.KOr / m * i));
          }
          if (!this.WQM.hRF().hwG())
          {
            n = i;
            if (!this.WQM.hRF().hzF()) {}
          }
          else
          {
            localObject1 = (com.tencent.mm.ui.base.g)a(this.WQM, this.CcM);
            n = i;
            if (localObject1 != null)
            {
              float f = this.KOr / ((com.tencent.mm.ui.base.g)localObject1).getImageWidth();
              this.KOs = ((int)(((com.tencent.mm.ui.base.g)localObject1).getImageHeight() * f));
              n = i;
              if (this.KOs > this.CcM.getHeight())
              {
                n = i;
                if (this.KOs < this.CcM.getHeight() * 1.5D)
                {
                  if (!this.WTH) {
                    break label886;
                  }
                  this.KOt = (this.KOs - this.CcM.getHeight());
                  n = i;
                }
                label445:
                this.KOs = this.CcM.getHeight();
              }
            }
          }
        }
        this.twB.mK(this.WTv, this.WTw);
        this.twB.XRW = this.KOt;
        this.twB.mJ(this.KOr, this.KOs);
        this.twB.V(k, j, m, n);
        localObject1 = this.CcM;
        localObject2 = a(this.WQM, this.CcM);
        if (localObject2 == null) {
          break label905;
        }
        localObject1 = localObject2;
        if (this.KOu != 1.0D)
        {
          this.twB.XRS = (1.0F / this.KOu);
          if (this.KOv == 0)
          {
            localObject1 = localObject2;
            if (this.KOw == 0) {}
          }
          else
          {
            i = (int)(this.CcM.getWidth() / 2 * (1.0F - this.KOu));
            j = this.KOv;
            k = (int)(this.CcM.getHeight() / 2 + this.KOw - this.KOs / 2 * this.KOu);
            this.twB.mL(i + j, k);
            localObject1 = localObject2;
          }
        }
        label652:
        if (this.WUm) {
          hSi();
        }
        this.twB.a((View)localObject1, this.mLT, new com.tencent.mm.ui.tools.f.c()
        {
          public final void onAnimationEnd()
          {
            AppMethodBeat.i(266093);
            Log.i("MicroMsg.ImageGalleryUI", "runExitAnimation onAnimationEnd");
            ImageGalleryUI.O(ImageGalleryUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(269631);
                ImageGalleryUI.this.finish();
                ImageGalleryUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.o(269631);
              }
            });
            ImageGalleryUI.c(ImageGalleryUI.this, false);
            AppMethodBeat.o(266093);
          }
          
          public final void onAnimationStart()
          {
            AppMethodBeat.i(266092);
            ImageGalleryUI.c(ImageGalleryUI.this, true);
            new MMHandler().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36124);
                View localView = ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.WQM, ImageGalleryUI.this.CcM);
                if ((localView != null) && ((localView instanceof com.tencent.mm.ui.base.g)))
                {
                  if ((localView instanceof MultiTouchImageView))
                  {
                    ((MultiTouchImageView)localView).hJx();
                    AppMethodBeat.o(36124);
                    return;
                  }
                  if ((localView instanceof WxImageView)) {
                    ((WxImageView)localView).hJx();
                  }
                }
                AppMethodBeat.o(36124);
              }
            }, 20L);
            AppMethodBeat.o(266092);
          }
        }, null);
        AppMethodBeat.o(36165);
        return;
      }
      localObject1 = this.WQM.avt(this.CcM.getCurrentItem());
      if (localObject1 == null) {
        break label908;
      }
      Object localObject2 = new bk();
      ((bk)localObject2).fxc.fvt = ((ca)localObject1);
      EventCenter.instance.publish((IEvent)localObject2);
      m = ((bk)localObject2).fxd.fxg;
      i = ((bk)localObject2).fxd.fxh;
      k = ((bk)localObject2).fxd.fxe;
      j = ((bk)localObject2).fxd.fxf;
    }
    for (;;)
    {
      if ((k == 0) && (j == 0))
      {
        k = this.CcM.getWidth() / 2;
        j = this.CcM.getHeight() / 2;
        break;
      }
      if (localObject1 != null)
      {
        if (((et)localObject1).field_isSend == 0) {
          this.WTv = com.tencent.mm.ci.a.fromDPToPix(getContext(), 5);
        }
        if (((et)localObject1).field_isSend == 1) {
          this.WTw = com.tencent.mm.ci.a.fromDPToPix(getContext(), 5);
        }
      }
      break;
      m = this.twE;
      i = this.twF;
      k = this.twD;
      j = this.twC;
      break;
      label886:
      n = this.CcM.getHeight() * i / this.KOs;
      break label445;
      label905:
      break label652;
      label908:
      i = 0;
      m = 0;
    }
  }
  
  private String dlb()
  {
    AppMethodBeat.i(36166);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    ca localca;
    if (this.WQM != null)
    {
      localca = this.WQM.avt(this.WUe);
      if (!f.j(localca)) {
        break label74;
      }
      com.tencent.mm.ay.g localg = this.WQM.i(localca, true);
      localObject1 = localObject2;
      if (localg != null) {
        localObject1 = h.a(localca, localg);
      }
    }
    for (;;)
    {
      localObject1 = Util.nullAsNil((String)localObject1);
      AppMethodBeat.o(36166);
      return localObject1;
      label74:
      localObject1 = localObject2;
      if (f.cL(localca)) {
        localObject1 = f.l(localca);
      }
    }
  }
  
  private void dlp()
  {
    AppMethodBeat.i(289123);
    hSf();
    this.wNi.setRepeatMode(1);
    this.wNi.setRepeatCount(-1);
    this.wNi.start();
    AppMethodBeat.o(289123);
  }
  
  private void dme()
  {
    AppMethodBeat.i(36183);
    Log.i("MicroMsg.ImageGalleryUI", "show video tool bar");
    GE(true);
    aQ(this.WTr, 4);
    aQ(hRQ().Mfz, 0);
    aQ(hRQ().Qtz, 0);
    aQ(this.WTj, 0);
    if (this.WSX) {
      hSh();
    }
    if (this.WQM != null)
    {
      ca localca = this.WQM.hRF();
      if ((localca != null) && (localca.dlS())) {
        aQ(this.Qtt, 0);
      }
    }
    AppMethodBeat.o(36183);
  }
  
  private static boolean f(ca paramca, com.tencent.mm.ay.g paramg)
  {
    AppMethodBeat.i(36179);
    if (paramg == null)
    {
      AppMethodBeat.o(36179);
      return false;
    }
    try
    {
      if ((f.c(paramca, paramg) == 0) && (paramg.blK()))
      {
        boolean bool = paramca.Ic();
        if (!bool)
        {
          AppMethodBeat.o(36179);
          return true;
        }
      }
    }
    catch (NullPointerException paramca)
    {
      Log.e("MicroMsg.ImageGalleryUI", "error:".concat(String.valueOf(paramca)));
      AppMethodBeat.o(36179);
    }
    return false;
  }
  
  private void fVL()
  {
    AppMethodBeat.i(289097);
    this.WSZ = true;
    if (this.CcM != null)
    {
      this.CcM.setEnableGalleryScale(true);
      this.CcM.setSingleMode(false);
    }
    AppMethodBeat.o(289097);
  }
  
  private boolean fVO()
  {
    AppMethodBeat.i(289098);
    fVL();
    if ((this.KOd != null) && (this.KOd.PN(this.KOc)))
    {
      this.KOc = 0L;
      AppMethodBeat.o(289098);
      return true;
    }
    AppMethodBeat.o(289098);
    return false;
  }
  
  private static int g(com.tencent.mm.ay.g paramg)
  {
    AppMethodBeat.i(36187);
    Map localMap = XmlParser.parseXml(paramg.lNS, "msg", null);
    if (localMap == null)
    {
      Log.e("MicroMsg.ImageGalleryUI", "parse cdnInfo failed. [%s]", new Object[] { paramg.lNS });
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
  
  private boolean hLD()
  {
    return this.WwF == 1;
  }
  
  private ImageGalleryUI hRR()
  {
    AppMethodBeat.i(36154);
    if (this.WTk == null) {
      this.WTk = findViewById(R.h.dFB);
    }
    AppMethodBeat.o(36154);
    return this;
  }
  
  private ImageGalleryUI hRS()
  {
    AppMethodBeat.i(36155);
    if (this.WTm == null) {
      this.WTm = findViewById(R.h.dEX);
    }
    AppMethodBeat.o(36155);
    return this;
  }
  
  private ImageGalleryUI hRT()
  {
    AppMethodBeat.i(289087);
    if (this.WTo == null) {
      this.WTo = findViewById(R.h.dHN);
    }
    AppMethodBeat.o(289087);
    return this;
  }
  
  private ImageGalleryUI hRU()
  {
    AppMethodBeat.i(289088);
    if (this.WTp == null) {
      this.WTp = findViewById(R.h.scan_success_dot_view);
    }
    AppMethodBeat.o(289088);
    return this;
  }
  
  private ImageGalleryUI hRV()
  {
    AppMethodBeat.i(289089);
    if (this.KNZ == null)
    {
      this.KNZ = ((MultiCodeMaskView)findViewById(R.h.multi_code_mask_view));
      this.KNZ.setOnMultiCodeMaskViewListener(new MultiCodeMaskView.b()
      {
        public final void a(ArrayList<ImageQBarDataBean> paramAnonymousArrayList, ImageQBarDataBean paramAnonymousImageQBarDataBean, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(282470);
          if (ImageGalleryUI.y(ImageGalleryUI.this) != null) {
            ImageGalleryUI.y(ImageGalleryUI.this).a(ImageGalleryUI.d(ImageGalleryUI.this), paramAnonymousImageQBarDataBean, ImageGalleryUI.z(ImageGalleryUI.this));
          }
          if (paramAnonymousBoolean) {}
          for (int i = 1;; i = 2)
          {
            com.tencent.mm.plugin.scanner.j localj = com.tencent.mm.plugin.scanner.j.IAG;
            com.tencent.mm.plugin.scanner.j.a(ImageGalleryUI.w(ImageGalleryUI.this).longValue(), i, paramAnonymousArrayList, paramAnonymousImageQBarDataBean, ImageGalleryUI.x(ImageGalleryUI.this).longValue(), ImageGalleryUI.d(ImageGalleryUI.this).WXW);
            AppMethodBeat.o(282470);
            return;
          }
        }
        
        public final void as(ArrayList<ImageQBarDataBean> paramAnonymousArrayList)
        {
          AppMethodBeat.i(282469);
          com.tencent.mm.plugin.scanner.j localj = com.tencent.mm.plugin.scanner.j.IAG;
          com.tencent.mm.plugin.scanner.j.a(ImageGalleryUI.w(ImageGalleryUI.this).longValue(), 3, paramAnonymousArrayList, null, ImageGalleryUI.x(ImageGalleryUI.this).longValue(), ImageGalleryUI.d(ImageGalleryUI.this).WXW);
          AppMethodBeat.o(282469);
        }
      });
    }
    AppMethodBeat.o(289089);
    return this;
  }
  
  private ImageGalleryUI hRW()
  {
    AppMethodBeat.i(289090);
    if (this.Mfr == null) {
      this.Mfr = findViewById(R.h.dHO);
    }
    AppMethodBeat.o(289090);
    return this;
  }
  
  private ImageGalleryUI hRX()
  {
    AppMethodBeat.i(289091);
    if (this.WTq == null) {
      this.WTq = ((SearchImageBubbleView)findViewById(R.h.dTp));
    }
    AppMethodBeat.o(289091);
    return this;
  }
  
  private void hRY()
  {
    int i = 2;
    AppMethodBeat.i(289094);
    boolean bool1 = awf(1);
    boolean bool2 = awf(2);
    if ((bool1) && (bool2)) {
      i = 4;
    }
    for (;;)
    {
      this.WTR.awq(i);
      AppMethodBeat.o(289094);
      return;
      if (bool1) {
        i = 3;
      } else if (!bool2) {
        i = 1;
      }
    }
  }
  
  private String hRZ()
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
  
  private boolean hSa()
  {
    AppMethodBeat.i(289101);
    this.WwF = getIntent().getIntExtra("msg_type", 0);
    if (this.WwF == 2)
    {
      AppMethodBeat.o(289101);
      return true;
    }
    AppMethodBeat.o(289101);
    return false;
  }
  
  private void hSb()
  {
    AppMethodBeat.i(289103);
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this, 1, false);
    locale.ODT = new q.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
      {
        AppMethodBeat.i(277598);
        ca localca = ImageGalleryUI.this.WQM.hRF();
        String str2;
        String str1;
        if ((!bs.H(localca)) && (!bs.P(localca)))
        {
          paramAnonymouso.d(0, ImageGalleryUI.this.getString(R.l.retransmits));
          str2 = ImageGalleryUI.this.getString(R.l.save_to_local);
          if ((!f.j(localca)) && (!f.cL(localca))) {
            break label127;
          }
          str1 = ImageGalleryUI.this.getString(R.l.save_img_to_local);
        }
        for (;;)
        {
          if (!localca.dlS()) {
            paramAnonymouso.d(1, str1);
          }
          paramAnonymouso.b(5, ImageGalleryUI.this.getString(R.l.evc), R.k.icons_outlined_chats);
          AppMethodBeat.o(277598);
          return;
          label127:
          if (!f.m(localca))
          {
            str1 = str2;
            if (!f.cJ(localca)) {}
          }
          else
          {
            str1 = str2;
            if (!localca.dlS()) {
              str1 = ImageGalleryUI.this.getString(R.l.save_video_to_local);
            }
          }
        }
      }
    };
    locale.ODU = this.uMM;
    locale.eik();
    AppMethodBeat.o(289103);
  }
  
  private boolean hSc()
  {
    AppMethodBeat.i(289104);
    if (2 != this.WUa.get())
    {
      Log.i("MicroMsg.ImageGalleryUI", "isNeedHideAppBrandEntrance, not scanned");
      AppMethodBeat.o(289104);
      return true;
    }
    if (!awf(2))
    {
      Log.i("MicroMsg.ImageGalleryUI", "isNeedHideAppBrandEntrance, code not found");
      AppMethodBeat.o(289104);
      return false;
    }
    if (this.WTz.WXT.isEmpty())
    {
      AppMethodBeat.o(289104);
      return false;
    }
    Iterator localIterator = this.WTz.WXT.iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      Object localObject = (ImageQBarDataBean)localIterator.next();
      int i = ((ImageQBarDataBean)localObject).fys;
      localObject = ((ImageQBarDataBean)localObject).IAH;
      if ((com.tencent.mm.plugin.scanner.k.bZ(i, (String)localObject)) || (com.tencent.mm.plugin.scanner.k.cb(i, (String)localObject)) || (com.tencent.mm.plugin.scanner.k.ca(i, (String)localObject)) || (com.tencent.mm.plugin.scanner.k.cc(i, (String)localObject)))
      {
        bool = true;
      }
      else if (com.tencent.mm.plugin.scanner.k.bY(i, (String)localObject))
      {
        bool = true;
      }
      else if (com.tencent.mm.plugin.scanner.k.cf(i, (String)localObject))
      {
        bool = true;
      }
      else if (com.tencent.mm.plugin.scanner.k.ce(i, (String)localObject))
      {
        bool = true;
      }
      else
      {
        if (!e.d.apt(i)) {
          break label229;
        }
        bool = true;
      }
    }
    label229:
    for (;;)
    {
      break;
      AppMethodBeat.o(289104);
      return bool;
    }
  }
  
  private d hSd()
  {
    AppMethodBeat.i(289105);
    if (this.WUd == null) {
      this.WUd = new d(this);
    }
    d locald = this.WUd;
    AppMethodBeat.o(289105);
    return locald;
  }
  
  private boolean hSe()
  {
    AppMethodBeat.i(36168);
    if (this.WTJ)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if (this.WTL == 1)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if (this.WRe)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if ((!this.WNT) && (!this.wIf) && (!l.a.hRO().wQL))
    {
      AppMethodBeat.o(36168);
      return true;
    }
    AppMethodBeat.o(36168);
    return false;
  }
  
  private void hSf()
  {
    AppMethodBeat.i(289121);
    this.wNf.setVisibility(0);
    this.wNg.setVisibility(0);
    this.wNh.setVisibility(0);
    hSh();
    AppMethodBeat.o(289121);
  }
  
  private void hSj()
  {
    this.WTh = 0;
    this.WTi = null;
  }
  
  private void hSk()
  {
    int j = 0;
    AppMethodBeat.i(289139);
    if ((hLD()) || (hSa()))
    {
      AppMethodBeat.o(289139);
      return;
    }
    aQ(this.WTl, 0);
    View localView = hRR().WTk;
    if (this.WTG) {}
    for (int i = 0;; i = 8)
    {
      aQ(localView, i);
      int k = this.WTb;
      i = j;
      if (this.WTG) {
        i = 1;
      }
      this.WTb = (k + (i + 1));
      AppMethodBeat.o(289139);
      return;
    }
  }
  
  private boolean hSl()
  {
    return (this.WNU) || (this.WTH);
  }
  
  private void hSm()
  {
    AppMethodBeat.i(289149);
    if (hRX().WTq.getVisibility() == 0) {
      GC(true);
    }
    AppMethodBeat.o(289149);
  }
  
  private int hSn()
  {
    if (this.WTK == 0)
    {
      locala = com.tencent.mm.plugin.webview.ui.tools.media.a.Qtn;
      return 2;
    }
    if (this.WTK == 1)
    {
      locala = com.tencent.mm.plugin.webview.ui.tools.media.a.Qtn;
      return 4;
    }
    com.tencent.mm.plugin.webview.ui.tools.media.a locala = com.tencent.mm.plugin.webview.ui.tools.media.a.Qtn;
    return 1;
  }
  
  private int hSo()
  {
    if (this.WSY) {
      return 3;
    }
    return 4;
  }
  
  private boolean hSq()
  {
    return this.WSV == f.b.WRE;
  }
  
  private boolean hSr()
  {
    return (this.WSV == f.b.WRD) || (this.WSV == f.b.WRG);
  }
  
  private void hSu()
  {
    boolean bool = true;
    AppMethodBeat.i(36197);
    if (this.WSW.getVisibility() == 0) {}
    for (;;)
    {
      Log.d("MicroMsg.ImageGalleryUI", "fadeInOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      this.WSW.clearAnimation();
      this.WSW.startAnimation(hSv());
      AppMethodBeat.o(36197);
      return;
      bool = false;
    }
  }
  
  private static Animation hSv()
  {
    AppMethodBeat.i(36198);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(150L);
    localAlphaAnimation.setFillAfter(true);
    AppMethodBeat.o(36198);
    return localAlphaAnimation;
  }
  
  private void hSx()
  {
    AppMethodBeat.i(36210);
    if (this.Qtt != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Qtt.getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, 0, 0);
      this.Qtt.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(36210);
  }
  
  private void hSy()
  {
    AppMethodBeat.i(36212);
    ca localca = this.WQM.hRF();
    String str = h.a(localca, h.k(localca));
    Log.i("MicroMsg.ImageGalleryUI", "edit image path:%s msgId:%s", new Object[] { str, Long.valueOf(localca.field_msgId) });
    bzy(str);
    AppMethodBeat.o(36212);
  }
  
  private void hbl()
  {
    boolean bool = true;
    AppMethodBeat.i(36196);
    if (this.WSW.getVisibility() == 0) {}
    for (;;)
    {
      Log.d("MicroMsg.ImageGalleryUI", "fadeOutOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      Animation localAnimation = awk(150);
      localAnimation.setFillAfter(false);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(273566);
          if (!ImageGalleryUI.aq(ImageGalleryUI.this)) {
            ImageGalleryUI.this.hSi();
          }
          AppMethodBeat.o(273566);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.WSW.clearAnimation();
      this.WSW.startAnimation(localAnimation);
      AppMethodBeat.o(36196);
      return;
      bool = false;
    }
  }
  
  private void hbn()
  {
    AppMethodBeat.i(36207);
    final View localView = getWindow().getDecorView();
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(231892);
        localView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        ImageGalleryUI.au(ImageGalleryUI.this);
        AppMethodBeat.o(231892);
      }
    });
    AppMethodBeat.o(36207);
  }
  
  private void hbo()
  {
    AppMethodBeat.i(36208);
    final View localView = getWindow().getDecorView();
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(289795);
        localView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i = com.tencent.mm.ci.a.kr(ImageGalleryUI.this);
        int j = com.tencent.mm.ci.a.ks(ImageGalleryUI.this);
        Log.i("MicroMsg.ImageGalleryUI", "handleHorizontalUI width = %d, height = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if ((i <= j) || ((com.tencent.mm.compatible.util.d.qV(24)) && (ImageGalleryUI.this.isInMultiWindowMode())))
        {
          ImageGalleryUI.au(ImageGalleryUI.this);
          AppMethodBeat.o(289795);
          return;
        }
        ImageGalleryUI.av(ImageGalleryUI.this);
        AppMethodBeat.o(289795);
      }
    });
    AppMethodBeat.o(36208);
  }
  
  protected static com.tencent.mm.ay.g k(ca paramca)
  {
    AppMethodBeat.i(293361);
    paramca = h.k(paramca);
    AppMethodBeat.o(293361);
    return paramca;
  }
  
  private static String k(ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(289099);
    if (paramca.field_isSend == 1)
    {
      paramca = z.bcZ();
      AppMethodBeat.o(289099);
      return paramca;
    }
    if (paramBoolean)
    {
      paramca = bq.RL(paramca.field_content);
      AppMethodBeat.o(289099);
      return paramca;
    }
    paramca = paramca.field_talker;
    AppMethodBeat.o(289099);
    return paramca;
  }
  
  private void l(ca paramca, boolean paramBoolean)
  {
    int k = 1;
    AppMethodBeat.i(289140);
    if (this.WSV != f.b.WRD) {}
    for (int i = 0;; i = 1)
    {
      if ((bs.D(paramca)) || (bs.L(paramca)) || (bs.P(paramca))) {
        i = 0;
      }
      if ((hLD()) || (hSa())) {
        i = 0;
      }
      paramca = hRS().WTm;
      label90:
      int j;
      if (paramBoolean) {
        if (i != 0) {
          if (paramca.getVisibility() != 0)
          {
            paramBoolean = true;
            D(paramca, paramBoolean);
            j = this.WTb;
            if (i == 0) {
              break label154;
            }
          }
        }
      }
      label154:
      for (i = k;; i = 0)
      {
        this.WTb = (j + i);
        AppMethodBeat.o(289140);
        return;
        paramBoolean = false;
        break;
        E(paramca, true);
        break label90;
        if (i != 0) {}
        for (j = 0;; j = 8)
        {
          aQ(paramca, j);
          break;
        }
      }
    }
  }
  
  public final int Wc(long paramLong)
  {
    AppMethodBeat.i(36204);
    if (Util.isNullOrNil(this.WTN))
    {
      AppMethodBeat.o(36204);
      return 0;
    }
    try
    {
      int j = com.tencent.mm.modelvideo.y.h(paramLong, this.WTN);
      int i = j;
      if (j == -1)
      {
        this.WTN = null;
        i = 0;
      }
      Log.d("MicroMsg.ImageGalleryUI", "get enter video op code %d %s", new Object[] { Integer.valueOf(i), this.WTN });
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
  
  public final void Wd(long paramLong)
  {
    AppMethodBeat.i(36205);
    if ((Util.isNullOrNil(this.WTN)) || (paramLong == 0L))
    {
      AppMethodBeat.o(36205);
      return;
    }
    if (this.WTO)
    {
      this.WTN = com.tencent.mm.modelvideo.y.g(paramLong, 3);
      Log.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[] { this.WTN });
      AppMethodBeat.o(36205);
      return;
    }
    if (com.tencent.mm.modelvideo.y.h(paramLong, this.WTN) == -1)
    {
      this.WTN = null;
      Log.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[] { this.WTN });
    }
    AppMethodBeat.o(36205);
  }
  
  public final void awg(int paramInt)
  {
    AppMethodBeat.i(36180);
    m(this.WQM.avt(paramInt), false);
    AppMethodBeat.o(36180);
  }
  
  public final void awj(final int paramInt)
  {
    AppMethodBeat.i(36194);
    if (hRQ().Mfz == null)
    {
      AppMethodBeat.o(36194);
      return;
    }
    hRQ().Mfz.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(289587);
        if (ImageGalleryUI.this.WQM == null)
        {
          AppMethodBeat.o(289587);
          return;
        }
        f localf = ImageGalleryUI.this.WQM;
        int i = paramInt;
        localf.WRb.MX(i);
        AppMethodBeat.o(289587);
      }
    });
    AppMethodBeat.o(36194);
  }
  
  public final void awl(int paramInt)
  {
    AppMethodBeat.i(36200);
    dmd();
    Gy(false);
    hRP().WTr.setVisibility(0);
    hRP().WTs.setVisibility(8);
    hRP().WTt.setVisibility(0);
    hRP().WTu.setVisibility(8);
    hRP().WTt.setText(paramInt + "%");
    AppMethodBeat.o(36200);
  }
  
  protected final void bXF()
  {
    AppMethodBeat.i(289109);
    int i = this.WUe;
    if (this.WQM == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.ImageGalleryUI", "showMenu mSelectedPos %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      if (this.WQM != null) {
        break;
      }
      AppMethodBeat.o(289109);
      return;
    }
    if (this.WUe < 0)
    {
      AppMethodBeat.o(289109);
      return;
    }
    if (this.WQM.avt(this.WUe) == null) {}
    for (final ca localca = this.WQM.hRF(); localca == null; localca = this.WQM.avt(this.WUe))
    {
      Log.i("MicroMsg.ImageGalleryUI", "showMenu msg is null");
      AppMethodBeat.o(289109);
      return;
    }
    if (bs.F(localca))
    {
      hSb();
      AppMethodBeat.o(289109);
      return;
    }
    i = this.WQM.WRa.cU(localca);
    if ((i == 5) || (i == 6))
    {
      Log.w("MicroMsg.ImageGalleryUI", "jacks fail downloaded img, return");
      AppMethodBeat.o(289109);
      return;
    }
    Object localObject1 = this.WQM;
    if (localca != null)
    {
      localObject1 = ((f)localObject1).i(localca, false);
      if (localObject1 != null) {
        if ((localca == null) || (localObject1 == null)) {
          bool = false;
        }
      }
    }
    while (bool)
    {
      Log.w("MicroMsg.ImageGalleryUI", "jacks downloading, return");
      AppMethodBeat.o(289109);
      return;
      if ((q.bmi().a(((com.tencent.mm.ay.g)localObject1).localId, localca.field_msgId, 0)) || (f.b(localca, (com.tencent.mm.ay.g)localObject1)))
      {
        bool = true;
      }
      else
      {
        bool = false;
        continue;
        localObject1 = e.cH(localca);
        if ((localObject1 != null) && (localObject1 != null))
        {
          i = ((w)localObject1).status;
          int j = com.tencent.mm.modelvideo.y.g((w)localObject1);
          if (((i == 112) || (i == 122)) && (j < 100)) {}
          for (bool = true;; bool = false)
          {
            Log.i("MicroMsg.ImageGalleryAdapter", "it is video downloading %b, status %d, download progress %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
            break;
          }
        }
        bool = false;
      }
    }
    if (f.m(localca))
    {
      if ((n.cH(localca) == null) && (!localca.dlS()))
      {
        Log.w("MicroMsg.ImageGalleryUI", "video info is null, return now.");
        AppMethodBeat.o(289109);
        return;
      }
      if (localca.dlS())
      {
        localObject1 = com.tencent.mm.plugin.webview.ui.tools.media.a.Qtn;
        com.tencent.mm.plugin.webview.ui.tools.media.a.lL(hSo(), hSn());
      }
    }
    if (this.rZT == null) {
      this.rZT = new com.tencent.mm.ui.widget.a.e(getContext(), 0, true);
    }
    if ((bs.D(localca)) && (!hLD()))
    {
      if (hSe()) {
        this.rZT.Ymx = new q.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
          {
            AppMethodBeat.i(195962);
            paramAnonymouso.b(5, ImageGalleryUI.this.getString(R.l.evc), R.k.icons_outlined_chats);
            AppMethodBeat.o(195962);
          }
        };
      }
      this.rZT.ODU = this.uMM;
      this.rZT.YmA = this.uMM;
      this.rZT.YmC = this.uMM;
      this.rZT.XbB = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(278995);
          ImageGalleryUI.aa(ImageGalleryUI.this);
          ImageGalleryUI.i(ImageGalleryUI.this).onDismiss();
          Object localObject = ImageGalleryUI.m(ImageGalleryUI.this).WWU;
          if (localObject != null)
          {
            localObject = ((e.c)localObject).WXd;
            if (localObject != null) {
              ((HashMap)localObject).put("1,2", Boolean.FALSE);
            }
          }
          ImageGalleryUI.Z(ImageGalleryUI.this).reset();
          ImageGalleryUI.d(ImageGalleryUI.this).WXU = null;
          ImageGalleryUI.d(ImageGalleryUI.this).WXV = null;
          AppMethodBeat.o(278995);
        }
      };
      this.rZT.YmE = new e.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(285829);
          if (ImageGalleryUI.this.WQM == null)
          {
            AppMethodBeat.o(285829);
            return;
          }
          Object localObject = ImageGalleryUI.this.WQM.hRF();
          if ((localObject != null) && (((ca)localObject).dlS()))
          {
            localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.Qtn;
            com.tencent.mm.plugin.webview.ui.tools.media.a.aR(3, ImageGalleryUI.ab(ImageGalleryUI.this), ImageGalleryUI.ac(ImageGalleryUI.this));
          }
          AppMethodBeat.o(285829);
        }
      };
      this.rZT.eik();
      AppMethodBeat.o(289109);
      return;
    }
    if (bs.M(localca))
    {
      AppMethodBeat.o(289109);
      return;
    }
    Log.d("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet");
    if (this.rZT == null) {
      Log.w("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, bottomSheet is null");
    }
    while (bs.P(this.WQM.avt(this.WUe)))
    {
      this.rZT.ODT = new q.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
        {
          AppMethodBeat.i(292221);
          paramAnonymouso.clear();
          if ((!bs.L(localca)) && (!bs.P(localca)))
          {
            paramAnonymouso.a(0, ImageGalleryUI.this.getString(R.l.retransmits), R.k.icons_filled_share, ImageGalleryUI.this.getResources().getColor(R.e.Brand));
            if ((localca != null) && (localca.dlS()) && (com.tencent.mm.pluginsdk.ui.tools.ab.hnU())) {
              paramAnonymouso.a(10, ImageGalleryUI.this.getString(R.l.readerapp_alert_share_to_timeline), R.k.bottomsheet_icon_moment, 0);
            }
          }
          if (com.tencent.mm.by.c.blP("favorite")) {
            paramAnonymouso.a(2, ImageGalleryUI.this.getString(R.l.plugin_favorite_opt), R.k.bottomsheet_icon_fav, 0);
          }
          if ((((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch()) && (f.j(localca)))
          {
            paramAnonymouso.a(11, ImageGalleryUI.this.getString(R.l.ewe), R.k.icons_filled_search_logo, ImageGalleryUI.this.getResources().getColor(R.e.Red));
            com.tencent.e.h.ZvG.be(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(262733);
                ImageGalleryUI.m(ImageGalleryUI.this).awt(2);
                AppMethodBeat.o(262733);
              }
            });
          }
          AppMethodBeat.o(292221);
        }
      };
      this.rZT.Ymx = new q.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
        {
          AppMethodBeat.i(265619);
          paramAnonymouso.clear();
          Object localObject;
          if ((!bs.L(localca)) && (!bs.P(localca)))
          {
            localObject = null;
            if ((!f.j(localca)) && (!f.cL(localca))) {
              break label495;
            }
            localObject = ImageGalleryUI.this.getString(R.l.save_img_to_local);
            if (!localca.dlS()) {
              paramAnonymouso.b(1, (CharSequence)localObject, R.k.icons_outlined_download);
            }
          }
          if ((f.j(localca)) && (ImageGalleryUI.V(ImageGalleryUI.this))) {
            paramAnonymouso.b(6, ImageGalleryUI.this.getString(R.l.chatting_image_long_click_photo_edit), R.k.icons_outlined_pencil);
          }
          if ((ImageGalleryUI.W(ImageGalleryUI.this)) && (!ImageGalleryUI.X(ImageGalleryUI.this)) && (!as.bvS(ImageGalleryUI.this.talker))) {
            paramAnonymouso.b(5, ImageGalleryUI.this.getString(R.l.evc), R.k.icons_outlined_chats);
          }
          long l;
          if (((com.tencent.mm.plugin.scanner.n.fBR()) || (ImageGalleryUI.d(ImageGalleryUI.this, 1))) && (!Util.isNullOrNil(ImageGalleryUI.a(ImageGalleryUI.this))))
          {
            paramAnonymouso.b(7, ImageGalleryUI.this.getString(R.l.chatting_image_long_click_photo_trans_short), R.k.icons_outlined_translate);
            localObject = new fo();
            if (ImageGalleryUI.u(ImageGalleryUI.this) == 2)
            {
              l = 1L;
              label249:
              ((fo)localObject).gnP = l;
              ((fo)localObject).gef = 2L;
              ((fo)localObject).gBe = 4L;
              com.tencent.mm.ay.g localg = ImageGalleryUI.k(ImageGalleryUI.this.WQM.hRF());
              if (localg != null)
              {
                ((fo)localObject).uU(localg.getFileId());
                ((fo)localObject).uV(localg.getAesKey());
              }
              ((fo)localObject).bpa();
            }
          }
          else if (ImageGalleryUI.Y(ImageGalleryUI.this))
          {
            paramAnonymouso.b(12, ImageGalleryUI.this.getString(R.l.chatting_image_long_click_image_ocr), R.k.icons_outlined_ocr);
            boolean bool = com.tencent.mm.model.ab.Lj(localca.field_talker);
            localObject = ImageGalleryUI.Z(ImageGalleryUI.this);
            if (!bool) {
              break label560;
            }
          }
          label560:
          for (int i = 2;; i = 1)
          {
            ((com.tencent.mm.plugin.scanner.api.a.b)localObject).jc(2, i);
            if ((f.j(localca)) || (f.cJ(localca)))
            {
              localObject = new em();
              ((em)localObject).fAp.msgId = localca.field_msgId;
              EventCenter.instance.publish((IEvent)localObject);
              if ((((em)localObject).fAq.fzO) || (com.tencent.mm.pluginsdk.model.app.h.aQ(ImageGalleryUI.this.getContext(), localca.getType()))) {
                paramAnonymouso.b(4, ImageGalleryUI.this.getString(R.l.evU), R.k.icons_outlined_open);
              }
            }
            AppMethodBeat.o(265619);
            return;
            label495:
            if ((f.m(localca)) || (f.cJ(localca)))
            {
              if (localca.dlS()) {
                break;
              }
              localObject = ImageGalleryUI.this.getString(R.l.save_video_to_local);
              break;
            }
            localObject = ImageGalleryUI.this.getString(R.l.save_to_local);
            break;
            l = 0L;
            break label249;
          }
        }
      };
      this.rZT.Ymz = new q.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
        {
          AppMethodBeat.i(276714);
          paramAnonymouso.clear();
          if ((ImageGalleryUI.d(ImageGalleryUI.this, 2)) && (ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.d(ImageGalleryUI.this).WXT)))
          {
            ScanCodeSheetItemLogic localScanCodeSheetItemLogic = ImageGalleryUI.i(ImageGalleryUI.this);
            ArrayList localArrayList = ImageGalleryUI.d(ImageGalleryUI.this).WXT;
            ImageQBarDataBean localImageQBarDataBean = ImageGalleryUI.d(ImageGalleryUI.this).WXU;
            com.tencent.mm.ui.widget.a.e locale = ImageGalleryUI.f(ImageGalleryUI.this);
            if (!localArrayList.isEmpty())
            {
              if (localArrayList.size() > 1)
              {
                if (localImageQBarDataBean != null)
                {
                  localScanCodeSheetItemLogic.a(localImageQBarDataBean.fys, localImageQBarDataBean.IAH, locale, paramAnonymouso);
                  AppMethodBeat.o(276714);
                  return;
                }
                paramAnonymouso.b(3, ScanCodeSheetItemLogic.hb(localArrayList), c.g.icons_outlined_qr_code);
                AppMethodBeat.o(276714);
                return;
              }
              localScanCodeSheetItemLogic.a(((ImageQBarDataBean)localArrayList.get(0)).fys, ((ImageQBarDataBean)localArrayList.get(0)).IAH, locale, paramAnonymouso);
            }
          }
          AppMethodBeat.o(276714);
        }
      };
      break;
    }
    Object localObject2 = dlb();
    if (Util.isNullOrNil((String)localObject2))
    {
      if (this.WQM == null) {
        break label1150;
      }
      localObject1 = this.WQM.avt(this.WUe);
      if (!f.m((ca)localObject1)) {
        break label1150;
      }
      com.tencent.mm.modelvideo.s.bqB();
    }
    label800:
    label1150:
    for (localObject1 = x.XT(((et)localObject1).field_imgPath);; localObject1 = null)
    {
      localObject2 = Util.nullAsNil((String)localObject1);
      for (localObject1 = com.tencent.mm.plugin.appbrand.openmaterial.model.b.qnr;; localObject1 = com.tencent.mm.plugin.appbrand.openmaterial.model.b.qnq)
      {
        if (!Util.isNullOrNil((String)localObject2)) {
          break label800;
        }
        Log.w("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, curMaterialPath is empty");
        break;
      }
      Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, curMaterialPath: %s, scene: %s", new Object[] { localObject2, localObject1 });
      com.tencent.mm.plugin.appbrand.service.i locali = (com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.i.class);
      if (locali == null)
      {
        Log.w("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, openMaterialService is null");
        break;
      }
      if (!locali.c((com.tencent.mm.plugin.appbrand.openmaterial.model.b)localObject1))
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, openMaterialService is not enabled");
        break;
      }
      if ((com.tencent.mm.plugin.appbrand.openmaterial.model.b.qnq == localObject1) && (2 == this.WUa.get()) && (hSc()))
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, can not enhance bottomSheet");
        break;
      }
      if (((String)localObject2).equals(this.WUb))
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, already fetchOpenMaterials");
        if (this.WUc == null)
        {
          Log.w("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, cachedOpenMaterialCollection is null");
          break;
        }
        if (!locali.a(this.rZT, this.WUc))
        {
          Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, not need enhance");
          break;
        }
        localObject2 = this.WQM.hRD();
        if ((localObject2 == null) || (u.WWI == localObject2)) {
          break;
        }
        if (this.QdJ != null) {
          this.QdJ.dead();
        }
        this.QdJ = locali.a((com.tencent.mm.plugin.appbrand.openmaterial.model.b)localObject1, this, this.rZT, this.WUc, null, hSd());
        if ((com.tencent.mm.plugin.appbrand.openmaterial.model.b.qnq != localObject1) || (!hSc())) {
          break;
        }
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, hide enhance bottomSheet");
        this.QdJ.a(j.a.qmO);
        break;
      }
      MaterialModel localMaterialModel = MaterialModel.all((String)localObject2);
      if (localMaterialModel == null)
      {
        Log.w("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, materialModel is null");
        break;
      }
      locali.alg(localMaterialModel.mimeType);
      locali.a(localMaterialModel, new a(this, (String)localObject2, locali, (com.tencent.mm.plugin.appbrand.openmaterial.model.b)localObject1));
      break;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(36195);
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
    {
      if (this.rZT != null)
      {
        this.rZT.bYF();
        this.rZT = null;
      }
      for (;;)
      {
        AppMethodBeat.o(36195);
        return true;
        if ((this.wNd == 0) || (this.wNd == 2)) {
          bXF();
        } else {
          bXF();
        }
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(36195);
    return bool;
  }
  
  public final void dmd()
  {
    AppMethodBeat.i(36184);
    Log.i("MicroMsg.ImageGalleryUI", "hide video tool bar");
    GE(false);
    aQ(hRQ().Mfz, 8);
    aQ(hRQ().Qtz, 8);
    aQ(this.WTj, 8);
    aQ(this.Qtt, 8);
    AppMethodBeat.o(36184);
  }
  
  public final boolean ehu()
  {
    AppMethodBeat.i(36193);
    boolean bool = hRQ().Mfz.cTl();
    AppMethodBeat.o(36193);
    return bool;
  }
  
  public void finish()
  {
    AppMethodBeat.i(36203);
    this.WID.clear();
    super.finish();
    AppMethodBeat.o(36203);
  }
  
  public final int getCurrentItem()
  {
    AppMethodBeat.i(293363);
    int i = this.CcM.getCurrentItem();
    AppMethodBeat.o(293363);
    return i;
  }
  
  public int getForceOrientation()
  {
    return 2;
  }
  
  public int getLayoutId()
  {
    return R.i.ehB;
  }
  
  final ImageGalleryUI hRP()
  {
    AppMethodBeat.i(36152);
    if (this.WTr == null)
    {
      this.WTr = findViewById(R.h.dIF);
      this.WTs = ((Button)this.WTr.findViewById(R.h.dDt));
      this.WTt = ((Button)this.WTr.findViewById(R.h.dDu));
      this.WTu = this.WTr.findViewById(R.h.dDv);
      TextView localTextView = (TextView)this.WTr.findViewById(R.h.dDs);
      this.WTs.getPaint().setFakeBoldText(true);
      this.WTt.getPaint().setFakeBoldText(true);
      localTextView.getPaint().setFakeBoldText(true);
      float f = Math.min(1.125F, com.tencent.mm.ci.a.ez(this));
      this.WTs.setTextSize(1, 12.0F * f);
      this.WTt.setTextSize(1, f * 12.0F);
    }
    AppMethodBeat.o(36152);
    return this;
  }
  
  protected final ImageGalleryUI hRQ()
  {
    AppMethodBeat.i(36153);
    if (this.Mfz == null)
    {
      this.Mfz = ((RedesignVideoPlayerSeekBar)findViewById(R.h.video_player_seek_bar));
      this.Qtz = findViewById(R.h.tool_bar_mask);
      this.Mfz.setPlayBtnOnClickListener(this);
    }
    AppMethodBeat.o(36153);
    return this;
  }
  
  public final void hSg()
  {
    AppMethodBeat.i(293360);
    Gy(false);
    AppMethodBeat.o(293360);
  }
  
  public final void hSh()
  {
    AppMethodBeat.i(36175);
    if (BuildInfo.IS_FLAVOR_RED) {
      Log.d("MicroMsg.ImageGalleryUI", "hideOpLayer isShowOpToolbar: %b, %s", new Object[] { Boolean.valueOf(this.WUm), Util.getStack() });
    }
    if (!this.WUm)
    {
      AppMethodBeat.o(36175);
      return;
    }
    this.WUm = false;
    hbl();
    AppMethodBeat.o(36175);
  }
  
  public final void hSi()
  {
    AppMethodBeat.i(36176);
    this.wTF.stopTimer();
    this.WTl.setVisibility(8);
    hRR().WTk.clearAnimation();
    aQ(hRR().WTk, 8);
    aQ(hRS().WTm, 8);
    this.WTn.setVisibility(8);
    aQ(hRT().WTo, 8);
    aQ(hRW().Mfr, 8);
    aQ(hRX().WTq, 8);
    dmd();
    sa(false);
    GD(false);
    this.WSW.setVisibility(8);
    AppMethodBeat.o(36176);
  }
  
  protected final boolean hSp()
  {
    return this.WUm;
  }
  
  protected final void hSs()
  {
    AppMethodBeat.i(36182);
    if (this.WUm)
    {
      if (hSq())
      {
        this.wTF.startTimer(3000L);
        AppMethodBeat.o(36182);
        return;
      }
      this.wTF.startTimer(5000L);
    }
    AppMethodBeat.o(36182);
  }
  
  protected final void hSt()
  {
    AppMethodBeat.i(293362);
    this.wTF.stopTimer();
    AppMethodBeat.o(293362);
  }
  
  public final void hSw()
  {
    AppMethodBeat.i(36201);
    dmd();
    hRP().WTr.setVisibility(0);
    hRP().WTs.setVisibility(8);
    hRP().WTt.setVisibility(0);
    hRP().WTu.setVisibility(8);
    hRP().WTt.setText("0%");
    AppMethodBeat.o(36201);
  }
  
  public void initView()
  {
    AppMethodBeat.i(36163);
    this.twB = new com.tencent.mm.ui.tools.f(getContext());
    this.isAnimated = false;
    this.talker = getIntent().getStringExtra("img_gallery_talker");
    this.WTH = getIntent().getBooleanExtra("img_gallery_enter_from_grid", false);
    this.WNU = getIntent().getBooleanExtra("img_gallery_enter_from_chatting_ui", false);
    this.WTJ = getIntent().getBooleanExtra("img_gallery_enter_from_appbrand_service_chatting_ui", false);
    this.WNT = getIntent().getBooleanExtra("show_search_chat_content_result", false);
    this.WTG = getIntent().getBooleanExtra("show_enter_grid", true);
    this.wIf = getIntent().getBooleanExtra("key_is_biz_chat", false);
    this.syu = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.WSX = getIntent().getBooleanExtra("img_preview_only", false);
    this.WTL = getIntent().getIntExtra("img_gallery_enter_from_scene", 0);
    this.WwF = getIntent().getIntExtra("msg_type", 0);
    if ((!this.WSX) && (Util.isNullOrNil(this.talker))) {
      Log.e("MicroMsg.ImageGalleryUI", " initView, talker is null. intent: " + getIntent());
    }
    this.chatroomName = getIntent().getStringExtra("img_gallery_chatroom_name");
    this.WTI = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
    this.WTN = getIntent().getStringExtra("img_gallery_enter_video_opcode");
    boolean bool2 = getIntent().getBooleanExtra("img_gallery_is_restransmit_after_download", false);
    Object localObject2 = getIntent().getStringExtra("img_gallery_directly_send_name");
    this.wNg = ((ImageView)findViewById(R.h.scan_translate_layer));
    this.wNh = ((ImageView)findViewById(R.h.scan_translate_close_btn));
    Object localObject1 = (FrameLayout.LayoutParams)this.wNh.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject1).bottomMargin += ax.aB(this);
    this.wNh.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.wNh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(281838);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((ImageGalleryUI.B(ImageGalleryUI.this) != null) && (!ImageGalleryUI.B(ImageGalleryUI.this).fBX())) {
          ImageGalleryUI.C(ImageGalleryUI.this);
        }
        paramAnonymousView = new ba();
        paramAnonymousView.fwL.scene = 1;
        paramAnonymousView.fwL.fwM = ImageGalleryUI.D(ImageGalleryUI.this);
        EventCenter.instance.publish(paramAnonymousView);
        ImageGalleryUI.v(ImageGalleryUI.this);
        ImageGalleryUI.E(ImageGalleryUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(281838);
      }
    });
    this.wNf = ((ImageView)findViewById(R.h.scan_translate_line));
    this.wNi = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.wNi.setDuration(5000L);
    this.wNi.addListener(new ImageGalleryUI.13(this));
    int i = getWindowManager().getDefaultDisplay().getHeight();
    this.wNi.addUpdateListener(new ImageGalleryUI.14(this, i));
    this.msgId = getIntent().getLongExtra("img_gallery_msg_id", 0L);
    this.WRe = getIntent().getBooleanExtra("img_gallery_is_mp_video_without_msg", false);
    this.WTK = getIntent().getIntExtra("img_gallery_mp_video_click_from", 2);
    long l = getIntent().getLongExtra("img_gallery_msg_svr_id", 0L);
    if (!this.WRe)
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
        bh.beI();
        this.msgId = com.tencent.mm.model.c.bbO().aL(hRZ(), l).field_msgId;
      }
      bh.beI();
      localObject1 = com.tencent.mm.model.c.bbO().Oq(this.msgId);
      if (((et)localObject1).field_msgId <= 0L)
      {
        Log.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.msgId + ", msgSvrId = " + l + ", stack = " + Util.getStack());
        finish();
        AppMethodBeat.o(36163);
      }
    }
    else
    {
      localObject1 = n.f(this.talker, this);
    }
    for (;;)
    {
      boolean bool1;
      if (Wc(this.msgId) == 3)
      {
        bool1 = true;
        this.WTO = bool1;
        if (com.tencent.mm.q.a.aAo()) {
          this.WTO = true;
        }
        this.WQM = new f(this, this.msgId, hRZ(), this.wIf, this.syu, bool2, (String)localObject2, Boolean.valueOf(this.WTI), this.WwF);
        this.WQM.WRf = false;
        this.WQM.WQY = getIntent().getBooleanExtra("start_chatting_ui", true);
        this.WQM.WRd = new f.c()
        {
          public final void qX()
          {
            AppMethodBeat.i(283255);
            if (ImageGalleryUI.this.WQM == null)
            {
              AppMethodBeat.o(283255);
              return;
            }
            ImageGalleryUI.this.hSg();
            ImageGalleryUI.F(ImageGalleryUI.this);
            ImageGalleryUI.this.WQM.onPageSelected(f.a.WRo);
            AppMethodBeat.o(283255);
          }
        };
        localObject2 = this.WQM;
        s locals = this.WSo;
        if (((f)localObject2).WRa != null) {
          ((f)localObject2).WRa.WSo = locals;
        }
        com.tencent.mm.ui.chatting.gallery.a.d.init();
        if (this.WSX) {
          break label1537;
        }
        bool1 = true;
        label896:
        this.WTB = new com.tencent.mm.ui.chatting.gallery.a.i(this, bool1);
        this.WTC = new com.tencent.mm.ui.chatting.gallery.a.f();
        if ((!com.tencent.mm.ui.chatting.gallery.a.d.hSX()) || (!hSl())) {
          break label1542;
        }
        bool1 = true;
        label935:
        this.WTA = bool1;
        Log.i("MicroMsg.ImageGalleryUI", "initScanCode isPreviewOnly: %b, canShowScanCodeButton: %b, isEnterFromChattingUI: %b, isEnterFromGrid: %b", new Object[] { Boolean.valueOf(this.WSX), Boolean.valueOf(this.WTA), Boolean.valueOf(this.WNU), Boolean.valueOf(this.WTH) });
        this.WTb = 0;
        this.WTc = getResources().getDimensionPixelSize(R.f.dlm);
        this.WTd = getResources().getDimensionPixelSize(R.f.dll);
        this.wTw = ((RelativeLayout)findViewById(R.h.cropimage_function_bar));
        this.WSW = ((RelativeLayout)findViewById(R.h.dDw));
        this.wTw.setOnClickListener(new ImageGalleryUI.6(this));
        this.WTj = findViewById(R.h.video_close_btn);
        this.WTj.setOnClickListener(this);
        this.WTl = findViewById(R.h.video_player_more_iv);
        this.WTn = findViewById(R.h.dHP);
        if (!bx(this)) {
          break label1547;
        }
        hbn();
        label1122:
        this.mLT = ((ImageView)findViewById(R.h.gallery_bg));
        this.CcM = ((MMViewPager)findViewById(R.h.gallery));
        this.CcM.setVerticalFadingEdgeEnabled(false);
        this.CcM.setHorizontalFadingEdgeEnabled(false);
        this.CcM.setSingleClickOverListener(new MMViewPager.f()
        {
          public final void bwB()
          {
            AppMethodBeat.i(288588);
            if (ImageGalleryUI.G(ImageGalleryUI.this)) {
              ImageGalleryUI.H(ImageGalleryUI.this);
            }
            AppMethodBeat.o(288588);
          }
          
          public final void euS()
          {
            AppMethodBeat.i(288589);
            ImageGalleryUI.I(ImageGalleryUI.this);
            AppMethodBeat.o(288589);
          }
        });
        this.CcM.setDoubleClickListener(new MMViewPager.a()
        {
          public final boolean ak(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(221189);
            if (ImageGalleryUI.B(ImageGalleryUI.this) != null)
            {
              boolean bool = ImageGalleryUI.B(ImageGalleryUI.this).onDoubleTap(paramAnonymousMotionEvent);
              AppMethodBeat.o(221189);
              return bool;
            }
            AppMethodBeat.o(221189);
            return false;
          }
        });
        if (!hSa()) {
          break label1554;
        }
        hSi();
        this.mLT.setVisibility(8);
        label1216:
        this.CcM.setOffscreenPageLimit(1);
        this.CcM.setAdapter(this.WQM);
        awg(f.a.WRo);
        this.CcM.setCurrentItem(f.a.WRo);
        this.CcM.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(273957);
            if (ImageGalleryUI.this.WQM == null)
            {
              AppMethodBeat.o(273957);
              return;
            }
            if ((l.a.hRO().wQL) && (ImageGalleryUI.K(ImageGalleryUI.this) != null))
            {
              ImageGalleryUI.K(ImageGalleryUI.this).setChecked(l.a.hRO().da(ImageGalleryUI.this.WQM.hRF()));
              ImageGalleryUI.L(ImageGalleryUI.this).setOnClickListener(ImageGalleryUI.this);
            }
            int i = f.a.WRo;
            if (ImageGalleryUI.this.CcM.getCurrentItem() != i)
            {
              AppMethodBeat.o(273957);
              return;
            }
            ImageGalleryUI.this.hSs();
            f.b localb = f.cN(ImageGalleryUI.this.WQM.avt(i));
            if ((!ImageGalleryUI.this.WTI) && (localb == f.b.WRE)) {
              ImageGalleryUI.this.WQM.avV(i);
            }
            if (localb == f.b.WRF) {
              ImageGalleryUI.this.WQM.avZ(i);
            }
            AppMethodBeat.o(273957);
          }
        }, 0L);
        if (l.a.hRO().wQL)
        {
          this.WTW = ((ViewStub)findViewById(R.h.dTH)).inflate();
          this.WTW.setVisibility(0);
          this.WTX = ((CheckBox)this.WTW.findViewById(R.h.media_cbx));
          this.WTY = this.WTW.findViewById(R.h.media_cbx_clickarea);
        }
        this.WTx = getIntent().getBooleanExtra("img_gallery_enter_PhotoEditUI", false);
        localObject1 = this.WQM.i((ca)localObject1, true);
        if (localObject1 == null) {
          Log.e("MicroMsg.ImageGalleryUI", "[initView] imgInfo is null!!! isSoonEnterPhotoEdit:%s", new Object[] { Boolean.valueOf(this.WTx) });
        }
        if ((!this.WTx) || (localObject1 == null) || (!((com.tencent.mm.ay.g)localObject1).blJ())) {
          break label1597;
        }
        hSy();
        this.WTx = false;
      }
      for (;;)
      {
        this.CcM.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(287521);
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(287521);
              return false;
              paramAnonymousView = ad.beh().I("basescanui@datacenter", true);
              PointF localPointF = com.tencent.mm.plugin.scanner.util.n.g(ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.WQM, ImageGalleryUI.this.CcM), paramAnonymousMotionEvent.getRawX(), paramAnonymousMotionEvent.getRawY());
              if (localPointF != null)
              {
                paramAnonymousView.k("key_basescanui_touch_normalize_x", Float.valueOf(localPointF.x));
                paramAnonymousView.k("key_basescanui_touch_normalize_y", Float.valueOf(localPointF.y));
              }
              else
              {
                Log.e("MicroMsg.ImageGalleryUI", "alvinluo get touchCoordinate is invalid");
                paramAnonymousView.k("key_basescanui_screen_position", Boolean.TRUE);
                paramAnonymousView.k("key_basescanui_screen_x", Float.valueOf(paramAnonymousMotionEvent.getRawX()));
                paramAnonymousView.k("key_basescanui_screen_y", Float.valueOf(paramAnonymousMotionEvent.getRawY()));
              }
            }
          }
        });
        if ((hLD()) || (hSa()))
        {
          this.WTl.setVisibility(8);
          aQ(hRR().WTk, 8);
          aQ(hRS().WTm, 8);
          aQ(this.WTn, 8);
          aQ(hRT().WTo, 8);
          aQ(hRW().Mfr, 8);
          aQ(hRX().WTq, 8);
        }
        AppMethodBeat.o(36163);
        return;
        bool1 = false;
        break;
        label1537:
        bool1 = false;
        break label896;
        label1542:
        bool1 = false;
        break label935;
        label1547:
        hbo();
        break label1122;
        label1554:
        if (!this.WSX)
        {
          this.CcM.setOnPageChangeListener(this.WUh);
          this.CcM.setLongClickOverListener(new MMViewPager.d()
          {
            public final void bwC()
            {
              AppMethodBeat.i(200512);
              if ((ImageGalleryUI.B(ImageGalleryUI.this) != null) && (ImageGalleryUI.B(ImageGalleryUI.this).fBX()))
              {
                AppMethodBeat.o(200512);
                return;
              }
              if (ImageGalleryUI.u(ImageGalleryUI.this) == 1)
              {
                AppMethodBeat.o(200512);
                return;
              }
              ImageGalleryUI.J(ImageGalleryUI.this);
              Object localObject;
              long l;
              if ((ImageGalleryUI.u(ImageGalleryUI.this) == 0) || (ImageGalleryUI.u(ImageGalleryUI.this) == 2))
              {
                localObject = new fo();
                if (ImageGalleryUI.u(ImageGalleryUI.this) == 2)
                {
                  l = 1L;
                  ((fo)localObject).gnP = l;
                  ((fo)localObject).gef = 1L;
                  ((fo)localObject).gBe = 4L;
                  if (ImageGalleryUI.this.WQM != null)
                  {
                    com.tencent.mm.ay.g localg = ImageGalleryUI.k(ImageGalleryUI.this.WQM.hRF());
                    if (localg != null)
                    {
                      ((fo)localObject).uU(localg.getFileId());
                      ((fo)localObject).uV(localg.getAesKey());
                    }
                  }
                  ((fo)localObject).bpa();
                }
              }
              else
              {
                localObject = ImageGalleryUI.a(ImageGalleryUI.this);
                ImageGalleryUI.a(ImageGalleryUI.this, com.tencent.mm.vfs.u.n((String)localObject, false), ImageGalleryUI.q(ImageGalleryUI.this));
                if (!com.tencent.mm.plugin.scanner.n.fBN()) {
                  break label235;
                }
                ImageGalleryUI.a(ImageGalleryUI.this, (String)localObject, true);
              }
              for (;;)
              {
                ImageGalleryUI.this.bXF();
                AppMethodBeat.o(200512);
                return;
                l = 0L;
                break;
                label235:
                ImageGalleryUI.e(ImageGalleryUI.this).mA(1, 2);
              }
            }
          });
          break label1216;
        }
        hSi();
        break label1216;
        label1597:
        if (this.WTx) {
          Log.w("MicroMsg.ImageGalleryUI", "img not GetCompleted!");
        }
      }
    }
  }
  
  public final void m(ca paramca, boolean paramBoolean)
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
        AppMethodBeat.i(289159);
        if ((paramca == null) || (!paramca.dlS()))
        {
          if (this.Qtt != null) {
            this.Qtt.setVisibility(8);
          }
          this.WSV = f.cN(paramca);
          Log.i("MicroMsg.ImageGalleryUI", "updateFooterInfo currGalleryType: %s, pageChanged: %b", new Object[] { this.WSV, Boolean.valueOf(paramBoolean) });
          if ((l.a.hRO().wQL) && (this.WTX != null)) {
            this.WTX.setChecked(l.a.hRO().da(paramca));
          }
        }
        switch (42.WRj[this.WSV.ordinal()])
        {
        case 1: 
          Gy(paramBoolean);
          AppMethodBeat.o(289159);
          return;
          if (this.Qtt == null)
          {
            this.Qtt = ((ViewStub)findViewById(R.h.dHM)).inflate();
            this.xoJ = findViewById(R.h.mp_video_avatar_layout);
            this.jiu = ((ImageView)findViewById(R.h.mp_video_avatar_iv));
            this.WUk = ((ImageView)findViewById(R.h.mp_video_right_arrow_iv));
            this.xoK = ((TextView)findViewById(R.h.mp_video_nickname_tv));
            this.HyV = ((MMNeat7extView)findViewById(R.h.mp_video_title_tv));
            this.WUi = ((TextView)findViewById(R.h.mp_video_view_article_tv));
            this.xoK.getPaint().setFakeBoldText(true);
            this.WUi.getPaint().setFakeBoldText(true);
            this.HyV.getPaint().setFakeBoldText(true);
            this.WUj = findViewById(R.h.mp_video_view_article_layout);
            this.Qtt.setOnClickListener(new ImageGalleryUI.31(this));
          }
          boolean bool = ax.av(this);
          i = ax.aB(this);
          if ((this.EXT) && (bool))
          {
            if (bx(this)) {
              hSx();
            }
          }
          else
          {
            localObject1 = n.cG(paramca);
            if (localObject1 != null) {
              break label389;
            }
            Log.w("MicroMsg.ImageGalleryUI", "fillMpVideoInfoLayout mpShareVideoInfo is null");
            continue;
          }
          awm(i);
        }
      }
      finally {}
      continue;
      this.HyV.aL(((com.tencent.mm.aj.y)localObject1).title);
      localObject2 = new k.b();
      ((k.b)localObject2).fUe = ((com.tencent.mm.aj.y)localObject1).lpC;
      ((k.b)localObject2).fUd = ((com.tencent.mm.aj.y)localObject1).fzT;
      com.tencent.mm.ui.chatting.viewitems.ao.a(this, (k.b)localObject2, this.jiu, this.xoK);
      this.xoJ.setOnClickListener(new ImageGalleryUI.32(this, (com.tencent.mm.aj.y)localObject1));
      this.WUj.setOnClickListener(new ImageGalleryUI.33(this, (com.tencent.mm.aj.y)localObject1));
      com.tencent.mm.ui.tools.p.E(this.xoJ, 0.7F);
      com.tencent.mm.ui.tools.p.E(this.WUj, 0.7F);
      if (((com.tencent.mm.aj.y)localObject1).ROZ != null)
      {
        ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(((com.tencent.mm.aj.y)localObject1).ROZ, -1, 2, new Object[0]);
        this.WUj.setVisibility(0);
      }
      for (;;)
      {
        localObject1 = (LinearLayout.LayoutParams)this.WUk.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).height = ((int)(this.WUi.getTextSize() * 1.45D));
        ((LinearLayout.LayoutParams)localObject1).width = ((LinearLayout.LayoutParams)localObject1).height;
        this.WUk.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (!this.WRe) {
          break;
        }
        Gy(false);
        dme();
        break;
        this.WUj.setVisibility(8);
      }
      aQ(this.WTr, 4);
      setVideoStateIv(true);
      paramca = n.cH(paramca);
      if (paramca != null) {
        break;
      }
      AppMethodBeat.o(289159);
    }
    hRQ().Mfz.setVideoTotalTime(paramca.lvw);
    for (;;)
    {
      try
      {
        if ((this.WQM.hRG() == null) || (this.WQM.hRG().WVL == null)) {
          break label1009;
        }
        i = this.WQM.hRG().WVL.getCurrentPosition() / 1000;
        hRQ().Mfz.seek(i);
      }
      catch (Exception paramca)
      {
        Log.printErrStackTrace("MicroMsg.ImageGalleryUI", paramca, "", new Object[0]);
        break label1009;
      }
      localObject1 = this.WQM.i(paramca, false);
      dmd();
      Gy(paramBoolean);
      if (localObject1 == null)
      {
        Log.w("MicroMsg.ImageGalleryUI", "updateFooterInfo img info is null");
        AppMethodBeat.o(289159);
        break label151;
      }
      if ((this.WTx) && (((com.tencent.mm.ay.g)localObject1).blJ()) && (this.WQM.hRF() != null) && (paramca.field_msgId == this.WQM.hRF().field_msgId))
      {
        Log.i("MicroMsg.ImageGalleryUI", "get image successfully! -> gotoPhotoEditUI msgId:%s", new Object[] { Long.valueOf(paramca.field_msgId) });
        hSy();
        this.WTx = false;
        AppMethodBeat.o(289159);
        break label151;
      }
      localObject2 = this.WQM.hRF();
      paramBoolean = this.WTx;
      long l = paramca.field_msgId;
      if (localObject2 == null) {}
      for (paramca = "null";; paramca = Long.valueOf(((et)localObject2).field_msgId))
      {
        Log.w("MicroMsg.ImageGalleryUI", "isSoonEnterPhotoEdit:%s msgId:%s curMsgId:%s getCompleted:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l), paramca, Boolean.valueOf(((com.tencent.mm.ay.g)localObject1).blJ()) });
        AppMethodBeat.o(289159);
        break;
      }
      dmd();
      break;
      dmd();
      Gy(paramBoolean);
      aQ(this.WTr, 4);
      this.WQM.avZ(this.CcM.getCurrentItem());
      AppMethodBeat.o(289159);
      break label151;
      break;
      label1009:
      i = 0;
    }
  }
  
  public boolean noActionBar()
  {
    AppMethodBeat.i(289092);
    if (!hSa())
    {
      AppMethodBeat.o(289092);
      return true;
    }
    AppMethodBeat.o(289092);
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(36173);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.QgI != null) && (this.QgI.c(this, paramInt1, paramInt2, paramIntent)))
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
    if (fVO())
    {
      AppMethodBeat.o(36161);
      return;
    }
    if (hRV().KNZ.getVisibility() == 0)
    {
      hRV().KNZ.F(this.BrO.longValue(), this.WTz.WXW);
      AppMethodBeat.o(36161);
      return;
    }
    if (this.WTH)
    {
      awi(1);
      AppMethodBeat.o(36161);
      return;
    }
    try
    {
      l.a.hRO().detach();
      cJs();
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
    AppMethodBeat.i(36191);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    if (this.WQM == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == R.h.dFB) {
      awi(0);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36191);
      return;
      if (paramView.getId() == R.h.video_player_more_iv)
      {
        this.WSY = false;
        bXF();
        if ((awf(2)) && (bF(this.WTz.WXT))) {
          if (this.WTz.WXT.size() == 1)
          {
            paramView = (ImageQBarDataBean)this.WTz.WXT.get(0);
            this.WTz.WXV = paramView;
            this.WTz.WXU = null;
            this.WTQ.ck(paramView.fys, paramView.IAH);
          }
          else
          {
            paramView = (ArrayList)com.tencent.mm.plugin.scanner.i.a(this, a(this.WQM, this.CcM), this.WTz.WXT, 0).Mx;
            if (paramView.size() == 1)
            {
              paramView = (ImageQBarDataBean)paramView.get(0);
              this.WTz.WXU = paramView;
              this.WTz.WXV = paramView;
              this.WTQ.ck(paramView.fys, paramView.IAH);
            }
            else
            {
              this.WTz.WXU = null;
              this.WTz.WXV = null;
            }
          }
        }
      }
      else if (paramView.getId() == R.h.dEX)
      {
        Log.i("MicroMsg.ImageGalleryUI", "[oreh download_and_save] hdImg suc, curPos:%d", new Object[] { Integer.valueOf(this.CcM.getCurrentItem()) });
        paramView = this.WQM.avt(this.CcM.getCurrentItem());
        localObject = this.WQM.i(paramView, false);
        this.CcM.getCurrentItem();
        if ((f(paramView, (com.tencent.mm.ay.g)localObject)) && (!paramView.Ic()) && (((com.tencent.mm.ay.g)localObject).blJ())) {
          this.WQM.bU(this.CcM.getCurrentItem(), true);
        } else {
          f.c(getContext(), this.WQM.hRF(), true);
        }
      }
      else if (paramView.getId() == R.h.dDt)
      {
        this.wNd = 2;
        this.wNc = 0;
        this.WQM.bU(this.CcM.getCurrentItem(), false);
      }
      else if (paramView.getId() == R.h.dDu)
      {
        this.WQM.avY(this.CcM.getCurrentItem());
        awg(this.CcM.getCurrentItem());
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
        boolean bool = this.WTX.isChecked();
        if ((!bool) && (l.a.hRO().wQK.size() >= 9))
        {
          Toast.makeText(this, getResources().getString(R.l.gallery_select_limit, new Object[] { Integer.valueOf(9) }), 1).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36191);
          return;
        }
        paramView = this.WTX;
        if (!bool) {}
        for (bool = true;; bool = false)
        {
          paramView.setChecked(bool);
          if (!this.WTX.isChecked()) {
            break label697;
          }
          l.a.hRO().cY(this.WQM.hRF());
          break;
        }
        label697:
        l.a.hRO().cZ(this.WQM.hRF());
      }
      else if (paramView.getId() == R.h.play_btn)
      {
        this.WQM.hRG();
        this.WQM.avV(this.CcM.getCurrentItem());
      }
      else if (paramView.getId() == R.h.dHP)
      {
        if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(getContext()))
        {
          this.WTR.awr(3);
          Gu(true);
        }
      }
      else if (paramView.getId() == R.h.dHN)
      {
        if (this.WUa.mState == 1)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36191);
          return;
        }
        this.WTR.awr(2);
        if (this.WTz.WXT.size() == 3)
        {
          int i = getWindow().getDecorView().getHeight();
          int j = getWindow().getDecorView().getWidth();
          paramView = ad.beh().I("basescanui@datacenter", true);
          localObject = com.tencent.mm.plugin.scanner.util.n.g(a(this.WQM, this.CcM), j / 2, i / 2);
          if (localObject != null)
          {
            paramView.k("key_basescanui_touch_normalize_x", Float.valueOf(((PointF)localObject).x));
            paramView.k("key_basescanui_touch_normalize_y", Float.valueOf(((PointF)localObject).y));
          }
          a(a(this.WQM, this.CcM), com.tencent.mm.vfs.u.n(dlb(), false), null, 3, this.WTS);
        }
        else
        {
          Gt(true);
        }
      }
      else if (paramView.getId() == R.h.dHO)
      {
        hRW().Mfr.setOnClickListener(null);
        aA(System.currentTimeMillis(), 3);
      }
      else if (paramView.getId() == R.h.dTo)
      {
        hRX().WTq.setBubbleClickListener(null);
        aA(System.currentTimeMillis(), 4);
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(36206);
    super.onConfigurationChanged(paramConfiguration);
    if (this.KOd != null) {
      this.KOd.onConfigurationChanged(paramConfiguration);
    }
    if (paramConfiguration.orientation == 1)
    {
      Log.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is vertical screen", new Object[] { Integer.valueOf(hashCode()) });
      this.WTg = true;
      hbn();
      AppMethodBeat.o(36206);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      Log.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is horizontal screen", new Object[] { Integer.valueOf(hashCode()) });
      this.WTg = true;
      hbo();
      AppMethodBeat.o(36206);
      return;
    }
    AppMethodBeat.o(36206);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(36157);
    requestWindowFeature(1);
    ar.bs(this);
    if (hSa()) {
      setTheme(R.m.MMTheme_Holo_ImageGalleyUI2);
    }
    long l = System.currentTimeMillis();
    this.WTZ = true;
    super.onCreate(paramBundle);
    if (hSa())
    {
      setMMTitle("");
      addIconOptionMenu(0, i.g.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(289264);
          ImageGalleryUI.A(ImageGalleryUI.this);
          AppMethodBeat.o(289264);
          return true;
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(273292);
          ImageGalleryUI.this.finish();
          AppMethodBeat.o(273292);
          return true;
        }
      });
      initView();
      if (this.WQM != null)
      {
        com.tencent.mm.ay.g localg = h.k(this.WQM.hRF());
        this.WTR.b(1, localg);
      }
      this.twA = paramBundle;
      EventCenter.instance.addListener(this.wNj);
      this.MfK = false;
      this.WTQ = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.b()
      {
        public final void aAx(String paramAnonymousString)
        {
          AppMethodBeat.i(280628);
          if ((ImageGalleryUI.f(ImageGalleryUI.this) != null) && (ImageGalleryUI.f(ImageGalleryUI.this).isShowing()) && (ImageGalleryUI.d(ImageGalleryUI.this).WXV != null) && (Util.isEqual(paramAnonymousString, ImageGalleryUI.d(ImageGalleryUI.this).WXV.IAH))) {
            ImageGalleryUI.this.bXF();
          }
          ImageGalleryUI.d(ImageGalleryUI.this).WXV = null;
          AppMethodBeat.o(280628);
        }
      });
      Log.d("MicroMsg.ImageGalleryUI", "ImageGallery onCreate spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(36157);
      return;
    }
    if (com.tencent.mm.compatible.util.d.qV(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (this.EXT = true;; this.EXT = false)
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
      if (this.WQM != null)
      {
        awh(this.WUe);
        this.WTa.a(this, this.WUe, 0);
        this.WQM.detach();
        this.WQM = null;
      }
      this.wTF.stopTimer();
      Gx(false);
      this.wNi.removeAllUpdateListeners();
      EventCenter.instance.removeListener(this.wNj);
      com.tencent.mm.kernel.h.aHF().b(this.wNk);
      Object localObject1 = new sk();
      ((sk)localObject1).fRT.activity = this;
      EventCenter.instance.publish((IEvent)localObject1);
      if (this.Mfz != null) {
        this.Mfz.setPlayBtnOnClickListener(null);
      }
      this.Mfz = null;
      hRY();
      if (this.WTB != null)
      {
        localObject1 = this.WTB;
        if (((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).WXo)
        {
          ((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).WXu.dead();
          ((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).WXv.dead();
          ((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).WXw.dead();
        }
        localObject2 = ((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).WXp.keySet();
        kotlin.g.b.p.j(localObject2, "scanCodeRequestMap.keys");
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            Object localObject5 = (String)((Iterator)localObject2).next();
            localObject3 = (i.b)((com.tencent.mm.ui.chatting.gallery.a.i)localObject1).WXp.get(localObject5);
            localObject4 = new az();
            ((az)localObject4).fwJ.filePath = ((String)localObject5);
            localObject5 = ((az)localObject4).fwJ;
            if (localObject3 != null)
            {
              l = ((i.b)localObject3).fwK;
              ((az.a)localObject5).fwK = l;
              EventCenter.instance.publish((IEvent)localObject4);
              continue;
              if (!com.tencent.mm.graphics.b.c.jVN.jVR) {
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
      com.tencent.mm.graphics.b.c.jVN.stop();
      super.onDestroy();
      AppMethodBeat.o(36160);
      return;
      l = 0L;
      break;
      localException.WXp.clear();
      localException.WXq.clear();
      localException.WXr.clear();
      Log.v("MicroMsg.ImageScanCodeManager", "releaseHandleCode");
      localObject2 = localException.WXs.keySet();
      kotlin.g.b.p.j(localObject2, "handleCodeRequestMap.keys");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = new ay();
        ((ay)localObject4).fwH.activity = localException.fDf;
        ((ay)localObject4).fwH.fwI = ((String)localObject3);
        EventCenter.instance.publish((IEvent)localObject4);
      }
      localException.WXt.clear();
      if (this.WTF != null)
      {
        com.tencent.mm.ui.chatting.gallery.a.j localj = this.WTF;
        Log.d("MicroMsg.ImageSearchPreviewManager", "alvinluo release previewImage request size: %s", new Object[] { Integer.valueOf(localj.WXD.size()) });
        localObject2 = ((Map)localj.WXD).entrySet().iterator();
        while (((Iterator)localObject2).hasNext()) {
          com.tencent.mm.ui.chatting.gallery.a.j.PM(((Number)((Map.Entry)((Iterator)localObject2).next()).getKey()).longValue());
        }
        localj.WXC.clear();
      }
      if (this.KOd != null) {
        this.KOd.release();
      }
      com.tencent.mm.ui.chatting.gallery.a.k.release();
      hRV().KNZ.fBH();
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
    if ((!hSa()) && (Build.VERSION.SDK_INT >= 21)) {
      getWindow().setFlags(2048, 2048);
    }
    if ((!isFinishing()) && (this.WQM != null)) {
      this.WQM.hRH();
    }
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    hRX().WTq.setBubbleClickListener(this);
    hRW().Mfr.setOnClickListener(this);
    AppMethodBeat.o(36150);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(36158);
    super.onResume();
    if (this.WQM != null) {
      if (!this.WQM.WRe) {
        break label128;
      }
    }
    label128:
    for (int i = 0;; i = 100000)
    {
      f.a.WRo = i;
      if ((!hSa()) && (Build.VERSION.SDK_INT >= 21)) {
        getWindow().clearFlags(2048);
      }
      if ((!this.WTZ) && (this.WQM != null)) {
        awg(this.CcM.getCurrentItem());
      }
      this.WTZ = false;
      if (this.WQM != null) {
        this.WQM.WRb.onResume();
      }
      com.tencent.mm.kernel.h.aHF().a(this.wNk);
      com.tencent.mm.plugin.ball.f.f.d(true, true, true);
      AppMethodBeat.o(36158);
      return;
    }
  }
  
  public void onStart()
  {
    boolean bool = true;
    AppMethodBeat.i(36159);
    this.WTI = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
    Bundle localBundle;
    if ((!this.WSX) && (!hSa()))
    {
      localBundle = this.twA;
      Log.i("MicroMsg.ImageGalleryUI", "[handleAnimation] isAnimated:" + this.isAnimated);
      if (!this.isAnimated)
      {
        this.isAnimated = true;
        if (Build.VERSION.SDK_INT >= 12)
        {
          this.twC = getIntent().getIntExtra("img_gallery_top", 0);
          this.twD = getIntent().getIntExtra("img_gallery_left", 0);
          this.twE = getIntent().getIntExtra("img_gallery_width", 0);
          this.twF = getIntent().getIntExtra("img_gallery_height", 0);
          if ((this.twC == 0) && (this.twD == 0) && (this.twE == 0) && (this.twF == 0))
          {
            ca localca = this.WQM.avt(this.CcM.getCurrentItem());
            if (localca != null)
            {
              bk localbk = new bk();
              localbk.fxc.fvt = localca;
              EventCenter.instance.publish(localbk);
              this.twE = localbk.fxd.fxg;
              this.twF = localbk.fxd.fxh;
              this.twD = localbk.fxd.fxe;
              this.twC = localbk.fxd.fxf;
            }
          }
          this.twB.V(this.twD, this.twC, this.twE, this.twF);
          if (localBundle != null) {
            break label350;
          }
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.ImageGalleryUI", "[handleAnimation] savedInstanceState is null?%s", new Object[] { Boolean.valueOf(bool) });
      if (localBundle == null) {
        this.CcM.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(284201);
            ImageGalleryUI.this.CcM.getViewTreeObserver().removeOnPreDrawListener(this);
            Log.i("MicroMsg.ImageGalleryUI", "[handleAnimation] -> onPreDraw, isBackFromGrid:" + ImageGalleryUI.this.WTI);
            ImageGalleryUI.this.KOr = ImageGalleryUI.this.CcM.getWidth();
            ImageGalleryUI.this.KOs = ImageGalleryUI.this.CcM.getHeight();
            if (ImageGalleryUI.this.WQM.hRF().dlT()) {
              ImageGalleryUI.this.KOs = ((int)(ImageGalleryUI.this.KOr / ImageGalleryUI.this.twE * ImageGalleryUI.this.twF));
            }
            if (ImageGalleryUI.this.WQM.hRF().hwG())
            {
              com.tencent.mm.ui.base.g localg = (com.tencent.mm.ui.base.g)ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.WQM, ImageGalleryUI.this.CcM);
              if (localg != null)
              {
                ImageGalleryUI localImageGalleryUI = ImageGalleryUI.this;
                float f = ImageGalleryUI.this.KOr / localg.getImageWidth();
                localImageGalleryUI.KOs = ((int)(localg.getImageHeight() * f));
                if (ImageGalleryUI.this.KOs > ImageGalleryUI.this.CcM.getHeight()) {
                  ImageGalleryUI.this.KOs = ImageGalleryUI.this.CcM.getHeight();
                }
              }
            }
            ImageGalleryUI.this.twB.mJ(ImageGalleryUI.this.KOr, ImageGalleryUI.this.KOs);
            if (!ImageGalleryUI.this.WTI) {
              ImageGalleryUI.this.twB.a(ImageGalleryUI.this.CcM, ImageGalleryUI.N(ImageGalleryUI.this), new com.tencent.mm.ui.tools.f.c()
              {
                public final void onAnimationEnd()
                {
                  AppMethodBeat.i(271182);
                  ImageGalleryUI.O(ImageGalleryUI.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(269542);
                      if (ImageGalleryUI.this.WTV != null) {
                        ImageGalleryUI.this.WTV.A(Boolean.FALSE);
                      }
                      AppMethodBeat.o(269542);
                    }
                  });
                  AppMethodBeat.o(271182);
                }
                
                public final void onAnimationStart()
                {
                  AppMethodBeat.i(271180);
                  if (ImageGalleryUI.this.WTV != null) {
                    ImageGalleryUI.this.WTV.A(Boolean.TRUE);
                  }
                  AppMethodBeat.o(271180);
                }
              });
            }
            ImageGalleryUI.P(ImageGalleryUI.this);
            AppMethodBeat.o(284201);
            return true;
          }
        });
      }
      super.onStart();
      AppMethodBeat.o(36159);
      return;
      label350:
      bool = false;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(36151);
    super.onStop();
    com.tencent.mm.graphics.b.d.jVU.aEZ();
    if (com.tencent.mm.graphics.b.c.jVN.jVR) {
      com.tencent.mm.graphics.b.c.jVN.stop();
    }
    aQ(hRU().WTp, 8);
    AppMethodBeat.o(36151);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void sa(boolean paramBoolean)
  {
    int i = 8;
    AppMethodBeat.i(36178);
    if (this.wTw == null)
    {
      AppMethodBeat.o(36178);
      return;
    }
    if (((paramBoolean) && (this.wTw.getVisibility() == 0)) || ((!paramBoolean) && (this.wTw.getVisibility() == 8)))
    {
      AppMethodBeat.o(36178);
      return;
    }
    Object localObject = this.wTw;
    if (paramBoolean) {
      i = 0;
    }
    ((RelativeLayout)localObject).setVisibility(i);
    localObject = getContext();
    if (paramBoolean) {}
    for (i = R.a.alpha_in;; i = R.a.alpha_out)
    {
      localObject = AnimationUtils.loadAnimation((Context)localObject, i);
      this.wTw.startAnimation((Animation)localObject);
      AppMethodBeat.o(36178);
      return;
    }
  }
  
  public final void setVideoStateIv(boolean paramBoolean)
  {
    AppMethodBeat.i(36192);
    try
    {
      RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = hRQ().Mfz;
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
  
  static final class a
    implements com.tencent.mm.plugin.appbrand.openmaterial.k
  {
    private final com.tencent.mm.plugin.appbrand.service.i QdV;
    private final WeakReference<ImageGalleryUI> Rxt;
    private final String WUD;
    private final com.tencent.mm.plugin.appbrand.openmaterial.model.b qlY;
    
    public a(ImageGalleryUI paramImageGalleryUI, String paramString, com.tencent.mm.plugin.appbrand.service.i parami, com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb)
    {
      AppMethodBeat.i(281437);
      this.Rxt = new WeakReference(paramImageGalleryUI);
      this.WUD = paramString;
      this.QdV = parami;
      this.qlY = paramb;
      AppMethodBeat.o(281437);
    }
    
    public final void a(boolean paramBoolean, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(281439);
      ImageGalleryUI localImageGalleryUI = (ImageGalleryUI)this.Rxt.get();
      if (localImageGalleryUI == null)
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet#onMyOpenMaterialsGot, ui is null");
        AppMethodBeat.o(281439);
        return;
      }
      if (!paramBoolean)
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet#onMyOpenMaterialsGot, fail");
        AppMethodBeat.o(281439);
        return;
      }
      if (ImageGalleryUI.f(localImageGalleryUI) == null)
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet#onMyOpenMaterialsGot, bottomSheet is null");
        AppMethodBeat.o(281439);
        return;
      }
      ImageGalleryUI.b(localImageGalleryUI, this.WUD);
      ImageGalleryUI.a(localImageGalleryUI, paramAppBrandOpenMaterialCollection);
      if (!this.QdV.a(ImageGalleryUI.f(localImageGalleryUI), paramAppBrandOpenMaterialCollection))
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet#onMyOpenMaterialsGot, not need enhance");
        AppMethodBeat.o(281439);
        return;
      }
      if (localImageGalleryUI.WQM != null) {}
      for (paramAppBrandOpenMaterialCollection = localImageGalleryUI.WQM.hRD();; paramAppBrandOpenMaterialCollection = null)
      {
        if ((paramAppBrandOpenMaterialCollection != null) && (u.WWI != paramAppBrandOpenMaterialCollection))
        {
          if (ImageGalleryUI.h(localImageGalleryUI) != null) {
            ImageGalleryUI.h(localImageGalleryUI).dead();
          }
          ImageGalleryUI.a(localImageGalleryUI, this.QdV.a(this.qlY, localImageGalleryUI, ImageGalleryUI.f(localImageGalleryUI), ImageGalleryUI.T(localImageGalleryUI), null, ImageGalleryUI.U(localImageGalleryUI)));
          if ((com.tencent.mm.plugin.appbrand.openmaterial.model.b.qnq == this.qlY) && (ImageGalleryUI.g(localImageGalleryUI)))
          {
            Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet#onMyOpenMaterialsGot, hide enhance bottomSheet");
            ImageGalleryUI.h(localImageGalleryUI).a(j.a.qmO);
          }
        }
        AppMethodBeat.o(281439);
        return;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void A(Boolean paramBoolean);
  }
  
  final class c
  {
    volatile int mState = 0;
    
    private c() {}
    
    public final int get()
    {
      AppMethodBeat.i(288224);
      int i = this.mState;
      Log.i("MicroMsg.ImageGalleryUI", "get#ScanState, state: ".concat(String.valueOf(i)));
      AppMethodBeat.o(288224);
      return i;
    }
    
    public final void hSz()
    {
      AppMethodBeat.i(288225);
      Log.i("MicroMsg.ImageGalleryUI", "onScanFinishPathChecked#ScanState");
      this.mState = 2;
      AppMethodBeat.o(288225);
    }
  }
  
  static final class d
    implements com.tencent.mm.plugin.appbrand.openmaterial.l
  {
    final WeakReference<ImageGalleryUI> Rxt;
    Runnable WUE;
    ca WUF;
    
    public d(ImageGalleryUI paramImageGalleryUI)
    {
      AppMethodBeat.i(288331);
      this.WUE = null;
      this.WUF = null;
      this.Rxt = new WeakReference(paramImageGalleryUI);
      AppMethodBeat.o(288331);
    }
    
    public final void ah(Runnable paramRunnable)
    {
      AppMethodBeat.i(288332);
      Log.i("MicroMsg.ImageGalleryUI", "executeOrDefer");
      ImageGalleryUI localImageGalleryUI = (ImageGalleryUI)this.Rxt.get();
      if (localImageGalleryUI == null)
      {
        Log.i("MicroMsg.ImageGalleryUI", "executeOrDefer, ui is null");
        AppMethodBeat.o(288332);
        return;
      }
      ca localca = localImageGalleryUI.WQM.hRF();
      if ((localca != null) && (localca.dlR()))
      {
        w localw = com.tencent.mm.modelvideo.y.Yk(localca.field_imgPath);
        if ((localw != null) && (localw.status != 199) && (localw.status != 199))
        {
          Log.i("MicroMsg.ImageGalleryUI", "executeOrDefer, video start download and waiting");
          ImageGalleryUI.a(localImageGalleryUI, com.tencent.mm.modelvideo.y.g(localca.field_msgId, 4));
          localImageGalleryUI.WQM.avW(localImageGalleryUI.CcM.getCurrentItem());
          this.WUE = paramRunnable;
          this.WUF = localca;
          AppMethodBeat.o(288332);
          return;
        }
        com.tencent.mm.plugin.appbrand.openmaterial.l.qmQ.ah(paramRunnable);
        AppMethodBeat.o(288332);
        return;
      }
      com.tencent.mm.plugin.appbrand.openmaterial.l.qmQ.ah(paramRunnable);
      AppMethodBeat.o(288332);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI
 * JD-Core Version:    0.7.0.1
 */