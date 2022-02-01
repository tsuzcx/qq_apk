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
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager.OnPageChangeListener;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.y;
import com.tencent.mm.av.q;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.ax.a;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.bf.b;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.b;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.g.a.ir.b;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.np.a;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.qy.a;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.qz.a;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.g.a.to;
import com.tencent.mm.g.a.to.a;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.g.a.tp.a;
import com.tencent.mm.g.b.a.ep;
import com.tencent.mm.g.b.a.jc;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
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
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.a;
import com.tencent.mm.ui.base.MMViewPager.c;
import com.tencent.mm.ui.base.MMViewPager.d;
import com.tencent.mm.ui.base.MMViewPager.f;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.chatting.gallery.a.f.c;
import com.tencent.mm.ui.chatting.gallery.a.j.b;
import com.tencent.mm.ui.chatting.gallery.a.j.d;
import com.tencent.mm.ui.chatting.gallery.a.j.e;
import com.tencent.mm.ui.chatting.gallery.a.j.f;
import com.tencent.mm.ui.chatting.gallery.a.j.g;
import com.tencent.mm.ui.chatting.gallery.a.n.a;
import com.tencent.mm.ui.chatting.gallery.view.SearchImageBubbleView;
import com.tencent.mm.ui.chatting.viewitems.al;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(3)
public class ImageGalleryUI
  extends MMActivity
  implements View.OnClickListener, a.a<String, com.tencent.mm.plugin.scanner.word.b>
{
  int EAA;
  int EAB;
  private float EAC;
  private int EAD;
  private int EAE;
  private long EAl;
  private com.tencent.mm.plugin.scanner.api.a.a EAm;
  private com.tencent.mm.plugin.scanner.api.a.b EAn;
  private com.tencent.mm.plugin.scanner.api.a.c EAo;
  int EAz;
  private boolean Erb;
  private boolean FLK;
  protected RedesignVideoPlayerSeekBar FLz;
  private com.tencent.mm.plugin.appbrand.openmaterial.h Jgz;
  public com.tencent.mm.plugin.webview.ui.tools.media.e JjJ;
  public View JvM;
  protected View JvS;
  int Pdu;
  private HashSet<Long> Poq;
  private boolean Ptq;
  protected boolean Ptr;
  private boolean PwE;
  private final boolean PwF;
  public b Pwu;
  private n PxO;
  private boolean PyA;
  public f PyB;
  private int PyC;
  private int PyD;
  private int PyE;
  private int PyF;
  private long PyG;
  private boolean PyH;
  private int PyI;
  private View PyJ;
  private View PyK;
  private View PyL;
  private View PyM;
  private View PyN;
  private View PyO;
  private View PyP;
  private View PyQ;
  private View PyR;
  private SearchImageBubbleView PyS;
  View PyT;
  Button PyU;
  Button PyV;
  View PyW;
  int PyX;
  int PyY;
  boolean PyZ;
  private b.b Pyw;
  private RelativeLayout Pyx;
  private boolean Pyy;
  private boolean Pyz;
  private boolean PzA;
  private String PzB;
  private AppBrandOpenMaterialCollection PzC;
  c PzD;
  private int PzE;
  private boolean PzF;
  private boolean PzG;
  private ViewPager.OnPageChangeListener PzH;
  public TextView PzI;
  public View PzJ;
  public ImageView PzK;
  private boolean PzL;
  boolean PzM;
  private HashMap<Long, String> PzN;
  private boolean PzO;
  private boolean PzP;
  ArrayList<Integer> Pza;
  private com.tencent.mm.ui.chatting.gallery.a.n Pzb;
  private boolean Pzc;
  private com.tencent.mm.ui.chatting.gallery.a.j Pzd;
  private com.tencent.mm.ui.chatting.gallery.a.g Pze;
  private int Pzf;
  private com.tencent.mm.plugin.scanner.api.f Pzg;
  private com.tencent.mm.ui.chatting.gallery.a.l Pzh;
  private boolean Pzi;
  protected boolean Pzj;
  protected boolean Pzk;
  private boolean Pzl;
  private int Pzm;
  private int Pzn;
  private boolean Pzo;
  private String Pzp;
  private boolean Pzq;
  private ScanCodeSheetItemLogic Pzr;
  private com.tencent.mm.ui.chatting.gallery.a.f Pzs;
  private com.tencent.mm.ui.chatting.gallery.a.h Pzt;
  private com.tencent.mm.ui.chatting.gallery.a.i Pzu;
  private com.tencent.mm.ui.chatting.gallery.a.c Pzv;
  public b Pzw;
  private View Pzx;
  private CheckBox Pzy;
  private View Pzz;
  protected String chatroomName;
  private View contentView;
  public ImageView gyr;
  private boolean isAnimated;
  private ImageView jUG;
  private MMHandler mHandler;
  public long msgId;
  private com.tencent.mm.ui.widget.a.e oXS;
  public TextView pIN;
  public MMNeat7extView pIO;
  public long ppv;
  Bundle qaD;
  com.tencent.mm.ui.tools.e qaE;
  int qaF;
  int qaG;
  int qaH;
  int qaI;
  private o.g rjz;
  public View tFX;
  protected String talker;
  public boolean tca;
  private com.tencent.mm.plugin.scanner.word.a tgL;
  private volatile int tgM;
  private int tgN;
  private ImageView tgP;
  private ImageView tgQ;
  private ImageView tgR;
  private ValueAnimator tgS;
  private IListener<tp> tgT;
  private com.tencent.mm.network.p tgU;
  private RelativeLayout tmY;
  MTimerHandler tnh;
  protected MMViewPager xqs;
  private boolean zss;
  
  public ImageGalleryUI()
  {
    AppMethodBeat.i(36149);
    this.FLK = false;
    this.Pyz = false;
    this.PyA = true;
    this.PyB = new f();
    this.PyC = 0;
    this.PyD = 0;
    this.PyE = 0;
    this.PyF = 0;
    this.PyG = 0L;
    this.PyH = false;
    this.PyI = 0;
    this.PyJ = null;
    this.EAB = 0;
    this.PyX = 0;
    this.PyY = 0;
    this.qaF = 0;
    this.qaG = 0;
    this.qaH = 0;
    this.qaI = 0;
    this.Pza = new ArrayList();
    this.Ptq = false;
    this.tca = false;
    this.Pzb = new com.tencent.mm.ui.chatting.gallery.a.n();
    this.Pzc = false;
    this.Pze = new com.tencent.mm.ui.chatting.gallery.a.g();
    this.Pzf = 0;
    this.Pzh = new com.tencent.mm.ui.chatting.gallery.a.l();
    this.Pzj = false;
    this.Ptr = false;
    this.Pzk = false;
    this.isAnimated = false;
    this.PwE = false;
    this.Pzm = -1;
    this.tgN = 0;
    this.PwF = false;
    this.Pzp = null;
    this.Pzs = new com.tencent.mm.ui.chatting.gallery.a.f();
    this.Pzt = new com.tencent.mm.ui.chatting.gallery.a.h()
    {
      public final void b(qy paramAnonymousqy)
      {
        AppMethodBeat.i(233301);
        String str1 = ImageGalleryUI.a(ImageGalleryUI.this);
        String str2 = com.tencent.mm.vfs.s.k(str1, false);
        if ((str2 == null) || (!str2.equals(paramAnonymousqy.dXy.filePath)))
        {
          Log.e("MicroMsg.ImageGalleryUI", "not same filepath");
          AppMethodBeat.o(233301);
          return;
        }
        Log.i("MicroMsg.ImageGalleryUI", "scanCode onFailed result: %s, curPath: %s, path: %s", new Object[] { paramAnonymousqy.dXy.result, str2, str1 });
        if (ImageGalleryUI.c(ImageGalleryUI.this).ans(2) != 1) {
          ImageGalleryUI.c(ImageGalleryUI.this).li(2, 2);
        }
        ImageGalleryUI.a(ImageGalleryUI.this, 2);
        AppMethodBeat.o(233301);
      }
      
      public final void b(qz paramAnonymousqz)
      {
        AppMethodBeat.i(233300);
        Object localObject1 = ImageGalleryUI.a(ImageGalleryUI.this);
        Object localObject2 = com.tencent.mm.vfs.s.k((String)localObject1, false);
        if ((localObject2 == null) || (!((String)localObject2).equals(paramAnonymousqz.dXz.filePath)))
        {
          Log.e("MicroMsg.ImageGalleryUI", "not same filepath");
          AppMethodBeat.o(233300);
          return;
        }
        Log.i("MicroMsg.ImageGalleryUI", "scanCode onSuccess result: %s, recognizeType: %d, curPath: %s, path: %s", new Object[] { paramAnonymousqz.dXz.result, Integer.valueOf(paramAnonymousqz.dXz.dXx), localObject2, localObject1 });
        if (!Util.isNullOrNil(paramAnonymousqz.dXz.result))
        {
          localObject1 = ImageGalleryUI.b(ImageGalleryUI.this);
          kotlin.g.b.p.h(paramAnonymousqz, "event");
          ((com.tencent.mm.ui.chatting.gallery.a.n)localObject1).CFJ = paramAnonymousqz.dXz.result;
          ((com.tencent.mm.ui.chatting.gallery.a.n)localObject1).dFL = paramAnonymousqz.dXz.dFL;
          ((com.tencent.mm.ui.chatting.gallery.a.n)localObject1).dFM = paramAnonymousqz.dXz.dFM;
          localObject2 = new n.a();
          ((n.a)localObject2).PDf = new PointF(paramAnonymousqz.dXz.dXC / paramAnonymousqz.dXz.dXA, paramAnonymousqz.dXz.dXD / paramAnonymousqz.dXz.dXB);
          ((n.a)localObject2).PDg = paramAnonymousqz.dXz.dXA;
          ((n.a)localObject2).PDh = paramAnonymousqz.dXz.dXB;
          ((com.tencent.mm.ui.chatting.gallery.a.n)localObject1).PDc = ((n.a)localObject2);
          Log.d("MicroMsg.ImageGalleryUI", "scanCode onSuccess codePointInfo: %s", new Object[] { ImageGalleryUI.b(ImageGalleryUI.this).PDc });
          ImageGalleryUI.c(ImageGalleryUI.this).li(2, 1);
          ImageGalleryUI.c(ImageGalleryUI.this).e(2, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(233299);
              if ((ImageGalleryUI.d(ImageGalleryUI.this) != null) && (ImageGalleryUI.d(ImageGalleryUI.this).isShowing()))
              {
                ImageGalleryUI.this.dTH();
                AppMethodBeat.o(233299);
                return;
              }
              ImageGalleryUI.a(ImageGalleryUI.this, 2);
              AppMethodBeat.o(233299);
            }
          });
          if (2 == paramAnonymousqz.dXz.dXx) {
            ImageGalleryUI.e(ImageGalleryUI.this).cl(ImageGalleryUI.b(ImageGalleryUI.this).dFL, ImageGalleryUI.b(ImageGalleryUI.this).CFJ);
          }
        }
        AppMethodBeat.o(233300);
      }
    };
    this.Pzu = new com.tencent.mm.ui.chatting.gallery.a.i()
    {
      public final void a(np paramAnonymousnp)
      {
        int i = 1;
        AppMethodBeat.i(233314);
        Log.i("MicroMsg.ImageGalleryUI", "handleCode callback notifyEvent: %d", new Object[] { Integer.valueOf(paramAnonymousnp.dTL.dTJ) });
        if (ImageGalleryUI.g(ImageGalleryUI.f(ImageGalleryUI.this)) != null) {
          ImageGalleryUI.g(ImageGalleryUI.f(ImageGalleryUI.this)).setOnClickListener(ImageGalleryUI.this);
        }
        if ((paramAnonymousnp.dTL.activity != ImageGalleryUI.this) || (!paramAnonymousnp.dTL.dDX.equals(ImageGalleryUI.b(ImageGalleryUI.this).CFJ)))
        {
          Log.e("MicroMsg.ImageGalleryUI", "handleCode callback not the same");
          AppMethodBeat.o(233314);
          return;
        }
        switch (paramAnonymousnp.dTL.dTJ)
        {
        default: 
          AppMethodBeat.o(233314);
          return;
        case 0: 
        case 1: 
        case 2: 
          ImageGalleryUI.h(ImageGalleryUI.this).anq(2);
          ImageGalleryUI.gD(ImageGalleryUI.j(ImageGalleryUI.i(ImageGalleryUI.this)));
          AppMethodBeat.o(233314);
          return;
        }
        paramAnonymousnp = paramAnonymousnp.dTL.dTM;
        if (paramAnonymousnp != null) {}
        for (boolean bool = paramAnonymousnp.getBoolean("key_scan_qr_code_result", true);; bool = true)
        {
          paramAnonymousnp = ImageGalleryUI.h(ImageGalleryUI.this);
          if (bool) {}
          for (;;)
          {
            paramAnonymousnp.anq(i);
            ImageGalleryUI.this.finish();
            break;
            i = 2;
          }
        }
      }
    };
    this.PxO = new n()
    {
      public final void ar(long paramAnonymousLong, int paramAnonymousInt)
      {
        AppMethodBeat.i(233334);
        Log.i("MicroMsg.ImageGalleryUI", "alvinluo onImageDownloaded msgId: %d, currentMsgId: %d, compressType: %d", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(ImageGalleryUI.k(ImageGalleryUI.this)), Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousLong == ImageGalleryUI.k(ImageGalleryUI.this)) && (!d.amZ(paramAnonymousInt))) {
          ImageGalleryUI.a(ImageGalleryUI.this, paramAnonymousLong);
        }
        AppMethodBeat.o(233334);
      }
      
      public final void b(long paramAnonymousLong, View paramAnonymousView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(233333);
        if ((paramAnonymousView != null) && (paramAnonymousBitmap != null) && (!Util.isNullOrNil(paramAnonymousString)))
        {
          Log.i("MicroMsg.ImageGalleryUI", "alvinluo onImageLoaded msgId: %d, currentMsgId: %d, imagePath: %s, bitmap: %s", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(ImageGalleryUI.k(ImageGalleryUI.this)), paramAnonymousString, Integer.valueOf(paramAnonymousBitmap.hashCode()) });
          ImageGalleryUI.a(ImageGalleryUI.this, paramAnonymousView, paramAnonymousString, paramAnonymousBitmap, ImageGalleryUI.l(ImageGalleryUI.this));
          if (paramAnonymousLong == ImageGalleryUI.k(ImageGalleryUI.this)) {
            ImageGalleryUI.a(ImageGalleryUI.this, paramAnonymousLong);
          }
        }
        AppMethodBeat.o(233333);
      }
    };
    this.Pzv = new com.tencent.mm.ui.chatting.gallery.a.c()
    {
      public final void bmZ(String paramAnonymousString)
      {
        AppMethodBeat.i(233349);
        if (ImageGalleryUI.this.Pwu == null)
        {
          AppMethodBeat.o(233349);
          return;
        }
        Object localObject1 = ImageGalleryUI.this.Pwu.amt(ImageGalleryUI.m(ImageGalleryUI.this));
        if (localObject1 == null)
        {
          AppMethodBeat.o(233349);
          return;
        }
        boolean bool = ab.Eq(((eo)localObject1).field_talker);
        Object localObject3 = ImageGalleryUI.h(ImageGalleryUI.this);
        long l = ((eo)localObject1).field_msgSvrId;
        int i;
        Object localObject2;
        if (bool)
        {
          i = 2;
          localObject2 = ImageGalleryUI.n((ca)localObject1, bool);
          if (!bool) {
            break label241;
          }
          localObject1 = ((eo)localObject1).field_talker;
          label101:
          localObject3 = ((com.tencent.mm.ui.chatting.gallery.a.f)localObject3).PBY;
          if (localObject3 == null) {
            break label248;
          }
          String str = String.valueOf(System.currentTimeMillis());
          kotlin.g.b.p.h(str, "<set-?>");
          ((f.c)localObject3).sessionId = str;
          ((f.c)localObject3).msgId = l;
          ((f.c)localObject3).scene = 67;
          ((f.c)localObject3).chatType = i;
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
          kotlin.g.b.p.h(localObject2, "<set-?>");
          ((f.c)localObject3).PCe = ((String)localObject2);
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          kotlin.g.b.p.h(localObject2, "<set-?>");
          ((f.c)localObject3).qUK = ((String)localObject2);
          localObject1 = paramAnonymousString;
          if (paramAnonymousString == null) {
            localObject1 = "";
          }
          kotlin.g.b.p.h(localObject1, "<set-?>");
          ((f.c)localObject3).imagePath = ((String)localObject1);
          AppMethodBeat.o(233349);
          return;
          i = 1;
          break;
          localObject1 = "";
          break label101;
          AppMethodBeat.o(233349);
          return;
        }
      }
    };
    this.EAl = 0L;
    this.EAm = null;
    this.EAn = ((com.tencent.mm.plugin.scanner.api.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.scanner.api.b.class)).eOT();
    this.EAo = new com.tencent.mm.plugin.scanner.api.a.c()
    {
      public final void eOW()
      {
        AppMethodBeat.i(233359);
        ImageGalleryUI.n(ImageGalleryUI.this);
        AppMethodBeat.o(233359);
      }
      
      public final void eOX()
      {
        AppMethodBeat.i(233362);
        ImageGalleryUI.p(ImageGalleryUI.this);
        AppMethodBeat.o(233362);
      }
      
      public final void eOY()
      {
        AppMethodBeat.i(233361);
        ImageGalleryUI.o(ImageGalleryUI.this);
        AppMethodBeat.o(233361);
      }
      
      public final void eOZ()
      {
        AppMethodBeat.i(233360);
        ImageGalleryUI.o(ImageGalleryUI.this);
        ImageGalleryUI.p(ImageGalleryUI.this);
        AppMethodBeat.o(233360);
      }
    };
    this.tgU = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(233365);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(233364);
            if ((com.tencent.mm.kernel.g.azz().aYS() != 6) && (com.tencent.mm.kernel.g.azz().aYS() != 4))
            {
              if (ImageGalleryUI.q(ImageGalleryUI.this) == 1)
              {
                com.tencent.mm.ui.base.h.c(ImageGalleryUI.this, ImageGalleryUI.this.getString(2131755914), "", true);
                ImageGalleryUI.r(ImageGalleryUI.this);
                ImageGalleryUI.h(ImageGalleryUI.this).anq(2);
                AppMethodBeat.o(233364);
              }
            }
            else
            {
              if (ImageGalleryUI.this.Pwu == null)
              {
                AppMethodBeat.o(233364);
                return;
              }
              int i = ImageGalleryUI.this.getCurrentItem();
              ca localca = ImageGalleryUI.this.Pwu.amt(i);
              if ((localca != null) && (localca.cWK()))
              {
                if (ImageGalleryUI.this.Pwu.gSh() == null) {
                  ImageGalleryUI.this.Pwu.gSh().gTe();
                }
                if ((ImageGalleryUI.this.Pwu.gSh().gTe().PAP.getVisibility() == 0) || (ImageGalleryUI.this.Pwu.gSh().gTe().PAY.getVisibility() == 0)) {
                  ImageGalleryUI.this.Pwu.amS(i);
                }
              }
            }
            AppMethodBeat.o(233364);
          }
        });
        AppMethodBeat.o(233365);
      }
    };
    this.PzA = true;
    this.EAC = 1.0F;
    this.EAD = 0;
    this.EAE = 0;
    this.PzB = null;
    this.PzC = null;
    this.Jgz = null;
    this.PzD = null;
    this.rjz = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(233337);
        if ((ImageGalleryUI.this == null) || (ImageGalleryUI.this.isDestroyed()) || (ImageGalleryUI.this.isFinishing()))
        {
          Log.i("MicroMsg.ImageGalleryUI", "receive onMMMenuItemSelected but activity is invalid");
          AppMethodBeat.o(233337);
          return;
        }
        ImageGalleryUI.S(ImageGalleryUI.this).reset();
        Log.i("MicroMsg.ImageGalleryUI", "curTransState %d", new Object[] { Integer.valueOf(ImageGalleryUI.q(ImageGalleryUI.this)) });
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(233337);
          return;
          paramAnonymousMenuItem = ImageGalleryUI.this.Pwu.gSg();
          Object localObject;
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cWJ()))
          {
            localObject = u.QN(paramAnonymousMenuItem.field_imgPath);
            if ((localObject != null) && (((com.tencent.mm.modelvideo.s)localObject).status != 199) && (((com.tencent.mm.modelvideo.s)localObject).status != 199))
            {
              ImageGalleryUI.a(ImageGalleryUI.this, u.f(paramAnonymousMenuItem.field_msgId, 1));
              ImageGalleryUI.this.Pwu.amT(ImageGalleryUI.this.xqs.getCurrentItem());
            }
          }
          for (;;)
          {
            if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cWK()))
            {
              localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.JvG;
              com.tencent.mm.plugin.webview.ui.tools.media.a.aN(1, ImageGalleryUI.U(ImageGalleryUI.this), ImageGalleryUI.V(ImageGalleryUI.this));
              localObject = j.cG(paramAnonymousMenuItem);
              if (localObject != null)
              {
                com.tencent.mm.plugin.webview.ui.tools.media.h.a locala = com.tencent.mm.plugin.webview.ui.tools.media.h.JwJ;
                com.tencent.mm.plugin.webview.ui.tools.media.h.a.i(1, ((y)localObject).KOf, ((y)localObject).KOe, ImageGalleryUI.this.PyB.pHu);
              }
            }
            if (br.D(paramAnonymousMenuItem))
            {
              localObject = new jc();
              ((jc)localObject).emN = paramAnonymousMenuItem.field_msgSvrId;
              ((jc)localObject).eLn = paramAnonymousMenuItem.getType();
              ((jc)localObject).eQu = br.C(paramAnonymousMenuItem);
              ((jc)localObject).ejA = 5L;
              ((jc)localObject).bfK();
            }
            AppMethodBeat.o(233337);
            return;
            ImageGalleryUI.this.Pwu.amO(ImageGalleryUI.this.xqs.getCurrentItem());
            continue;
            ImageGalleryUI.this.Pwu.amO(ImageGalleryUI.this.xqs.getCurrentItem());
          }
          paramAnonymousMenuItem = ImageGalleryUI.this.Pwu.gSg();
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cWK()))
          {
            localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.JvG;
            com.tencent.mm.plugin.webview.ui.tools.media.a.aN(4, ImageGalleryUI.U(ImageGalleryUI.this), ImageGalleryUI.V(ImageGalleryUI.this));
            paramAnonymousMenuItem = j.cG(paramAnonymousMenuItem);
            if (paramAnonymousMenuItem != null) {
              ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramAnonymousMenuItem, ImageGalleryUI.this, ImageGalleryUI.this.PyB.pHu);
            }
            AppMethodBeat.o(233337);
            return;
            paramAnonymousMenuItem = ImageGalleryUI.this.Pwu.gSg();
            if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cWJ()))
            {
              localObject = u.QN(paramAnonymousMenuItem.field_imgPath);
              if ((localObject != null) && (((com.tencent.mm.modelvideo.s)localObject).status != 199) && (((com.tencent.mm.modelvideo.s)localObject).status != 199))
              {
                ImageGalleryUI.a(ImageGalleryUI.this, u.f(paramAnonymousMenuItem.field_msgId, 2));
                ImageGalleryUI.this.Pwu.amT(ImageGalleryUI.this.xqs.getCurrentItem());
              }
            }
            for (;;)
            {
              if (br.D(paramAnonymousMenuItem))
              {
                localObject = new jc();
                ((jc)localObject).emN = paramAnonymousMenuItem.field_msgSvrId;
                ((jc)localObject).eLn = paramAnonymousMenuItem.getType();
                ((jc)localObject).eQu = br.C(paramAnonymousMenuItem);
                ((jc)localObject).ejA = 7L;
                ((jc)localObject).bfK();
              }
              AppMethodBeat.o(233337);
              return;
              localObject = new ArrayList();
              ((List)localObject).add(ImageGalleryUI.this.Pwu.gSg());
              b.f(ImageGalleryUI.this.getContext(), (List)localObject);
              continue;
              localObject = new ArrayList();
              ((List)localObject).add(ImageGalleryUI.this.Pwu.gSg());
              com.tencent.mm.modelstat.b.jmd.af((ca)((List)localObject).get(0));
              b.f(ImageGalleryUI.this.getContext(), (List)localObject);
            }
            ImageGalleryUI.this.Pwu.amP(ImageGalleryUI.this.xqs.getCurrentItem());
            AppMethodBeat.o(233337);
            return;
            if (com.tencent.mm.br.c.aZU("favorite"))
            {
              ImageGalleryUI.this.Pwu.amQ(ImageGalleryUI.this.xqs.getCurrentItem());
              paramAnonymousMenuItem = ImageGalleryUI.this.Pwu.gSg();
              if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cWK()))
              {
                paramAnonymousMenuItem = com.tencent.mm.plugin.webview.ui.tools.media.a.JvG;
                com.tencent.mm.plugin.webview.ui.tools.media.a.aN(2, ImageGalleryUI.U(ImageGalleryUI.this), ImageGalleryUI.V(ImageGalleryUI.this));
              }
              AppMethodBeat.o(233337);
              return;
              ImageGalleryUI.X(ImageGalleryUI.this);
              AppMethodBeat.o(233337);
              return;
              if (ImageGalleryUI.this.Pwu != null)
              {
                if (b.j(ImageGalleryUI.this.Pwu.gSg())) {
                  ImageGalleryUI.Y(ImageGalleryUI.this);
                }
                AppMethodBeat.o(233337);
                return;
                if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(ImageGalleryUI.this.getContext()))
                {
                  ImageGalleryUI.Z(ImageGalleryUI.this);
                  AppMethodBeat.o(233337);
                  return;
                  Log.i("MicroMsg.ImageGalleryUI", "request deal QBAR string");
                  if ((ImageGalleryUI.d(ImageGalleryUI.this) != null) && (ImageGalleryUI.d(ImageGalleryUI.this).isShowing())) {
                    ImageGalleryUI.d(ImageGalleryUI.this).bMo();
                  }
                  paramAnonymousMenuItem = Util.safeFormatString("%d,%d", new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
                  Log.i("MicroMsg.ImageGalleryUI", "18684 report:".concat(String.valueOf(paramAnonymousMenuItem)));
                  com.tencent.mm.plugin.report.service.h.CyF.kvStat(18684, paramAnonymousMenuItem);
                  ImageGalleryUI.W(ImageGalleryUI.this);
                  AppMethodBeat.o(233337);
                  return;
                  ImageGalleryUI.b(ImageGalleryUI.this, System.currentTimeMillis());
                  AppMethodBeat.o(233337);
                  return;
                  ImageGalleryUI.aa(ImageGalleryUI.this);
                }
              }
            }
          }
        }
      }
    };
    this.tgT = new IListener() {};
    this.PzE = 0;
    this.PzF = false;
    this.PzG = true;
    this.PzH = new ViewPager.OnPageChangeListener()
    {
      private boolean PzX = false;
      
      public final void onPageScrollStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(233343);
        Log.d("MicroMsg.ImageGalleryUI", "onPageScrollStateChanged: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 2) {
          ImageGalleryUI.c(ImageGalleryUI.this, true);
        }
        if (paramAnonymousInt == 0)
        {
          this.PzX = false;
          ImageGalleryUI.ai(ImageGalleryUI.this);
          ImageGalleryUI.c(ImageGalleryUI.this, false);
        }
        if (ImageGalleryUI.this.Pwu != null)
        {
          Object localObject = ImageGalleryUI.this.Pwu;
          if (((b)localObject).PwA != null)
          {
            localObject = ((b)localObject).PwA;
            ((d)localObject).mScrollState = paramAnonymousInt;
            if (((d)localObject).PxQ != null) {
              ((d)localObject).PxQ.onPageScrollStateChanged(paramAnonymousInt);
            }
          }
        }
        AppMethodBeat.o(233343);
      }
      
      public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        AppMethodBeat.i(233342);
        Log.v("MicroMsg.ImageGalleryUI", "position: %d, positionOffset: %f, positionOffsetPixels: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Float.valueOf(paramAnonymousFloat), Integer.valueOf(paramAnonymousInt2) });
        if ((!this.PzX) && (paramAnonymousInt2 > 0)) {
          this.PzX = true;
        }
        AppMethodBeat.o(233342);
      }
      
      public final void onPageSelected(int paramAnonymousInt)
      {
        boolean bool2 = true;
        AppMethodBeat.i(233341);
        Log.v("MicroMsg.ImageGalleryUI", "onPageChange position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (ImageGalleryUI.this.Pwu == null)
        {
          AppMethodBeat.o(233341);
          return;
        }
        Object localObject1;
        if (ImageGalleryUI.m(ImageGalleryUI.this) != paramAnonymousInt)
        {
          if ((ImageGalleryUI.d(ImageGalleryUI.this) != null) && (ImageGalleryUI.d(ImageGalleryUI.this).isShowing())) {
            ImageGalleryUI.d(ImageGalleryUI.this).bMo();
          }
          if (!ImageGalleryUI.ab(ImageGalleryUI.this))
          {
            ImageGalleryUI.ac(ImageGalleryUI.this);
            localObject1 = ImageGalleryUI.k(ImageGalleryUI.this.Pwu.gSg());
            ImageGalleryUI.h(ImageGalleryUI.this).b(2, (com.tencent.mm.av.g)localObject1);
            ImageGalleryUI.ad(ImageGalleryUI.this);
          }
          ImageGalleryUI.ae(ImageGalleryUI.this);
          ImageGalleryUI.a(ImageGalleryUI.this, false);
          if (ImageGalleryUI.q(ImageGalleryUI.this) == 1) {
            ImageGalleryUI.r(ImageGalleryUI.this);
          }
          ImageGalleryUI.af(ImageGalleryUI.this);
          ImageGalleryUI.v(ImageGalleryUI.this);
        }
        if (ImageGalleryUI.this.Pwu.abm(paramAnonymousInt) == null) {
          Log.e("MicroMsg.ImageGalleryUI", "onPageSelected the view is null, position = %s ", new Object[] { Integer.valueOf(paramAnonymousInt) });
        }
        ImageGalleryUI.H(ImageGalleryUI.this);
        ImageGalleryUI.e(ImageGalleryUI.this, ImageGalleryUI.m(ImageGalleryUI.this));
        ImageGalleryUI.this.PyB.a(ImageGalleryUI.this, ImageGalleryUI.m(ImageGalleryUI.this), paramAnonymousInt);
        ImageGalleryUI.f(ImageGalleryUI.this, paramAnonymousInt);
        label463:
        int i;
        label465:
        long l;
        if (ImageGalleryUI.this.Pwu != null)
        {
          localObject1 = ImageGalleryUI.this.Pwu;
          ((b)localObject1).PwB.stopAll();
          ((b)localObject1).PwC.stopAll();
          localObject1 = ImageGalleryUI.this.Pwu.amt(paramAnonymousInt);
          if (localObject1 != null)
          {
            ImageGalleryUI.c(ImageGalleryUI.this, ((eo)localObject1).field_msgId);
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(((eo)localObject1).field_talker);
            ImageGalleryUI.a(ImageGalleryUI.this, b.cr((ca)localObject1));
          }
          if ((b.j((ca)localObject1)) || (b.cp((ca)localObject1)))
          {
            localObject2 = ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.Pwu, ImageGalleryUI.this.xqs);
            if ((localObject2 != null) && ((localObject2 instanceof com.tencent.mm.ui.base.g)))
            {
              if (!(localObject2 instanceof MultiTouchImageView)) {
                break label733;
              }
              ((MultiTouchImageView)localObject2).gKy();
            }
            String str = ImageGalleryUI.a(ImageGalleryUI.this);
            if (com.tencent.mm.plugin.scanner.i.eOO()) {
              break label755;
            }
            Log.i("MicroMsg.ScannerHelper", "Word Detect Closed");
            i = 0;
            if (i != 0)
            {
              if (ImageGalleryUI.ag(ImageGalleryUI.this) == null) {
                ImageGalleryUI.a(ImageGalleryUI.this, new ImageWordScanDetailEngine(ImageGalleryUI.this));
              }
              if (Util.isNullOrNil(str)) {
                break label905;
              }
              ImageGalleryUI.ag(ImageGalleryUI.this).a(str, ImageGalleryUI.this);
            }
            label524:
            ImageGalleryUI.a(ImageGalleryUI.this, (View)localObject2, com.tencent.mm.vfs.s.k(str, false), null, ImageGalleryUI.l(ImageGalleryUI.this));
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).as((ca)localObject1);
            ImageGalleryUI.a(ImageGalleryUI.this, ((eo)localObject1).field_msgId);
          }
          if (localObject1 != null) {
            ImageGalleryUI.this.NR(((eo)localObject1).field_msgId);
          }
          if (ImageGalleryUI.this.Pwu == null) {
            break label926;
          }
          localObject2 = ImageGalleryUI.this.Pwu.i((ca)localObject1, false);
          if (!b.b((ca)localObject1, (com.tencent.mm.av.g)localObject2)) {
            break label934;
          }
          localObject1 = com.tencent.mm.av.h.a((com.tencent.mm.av.g)localObject2);
          i = ((com.tencent.mm.av.g)localObject1).iKP;
          int j = ((com.tencent.mm.av.g)localObject1).offset;
          if (i == 0) {
            break label920;
          }
          l = j * 100L / i - 1L;
          label662:
          i = Math.max(1, (int)l);
          Log.d("MicroMsg.ImageGalleryUI", "jacks loading hd from imgInfo : %d, time: %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()) });
          ImageGalleryUI.this.ani(i);
        }
        for (;;)
        {
          if (ImageGalleryUI.this.Pwu != null) {
            ImageGalleryUI.this.Pwu.onPageSelected(paramAnonymousInt);
          }
          AppMethodBeat.o(233341);
          return;
          label733:
          if (!(localObject2 instanceof WxImageView)) {
            break;
          }
          ((WxImageView)localObject2).gKy();
          break;
          label755:
          i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("EnableSessionPicTranslation", 0);
          Object localObject3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("PicTranslationSupportUserLanguage");
          if (i == 1) {}
          for (bool1 = true;; bool1 = false)
          {
            Log.i("MicroMsg.ScannerHelper", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool1), localObject3, LocaleUtil.getApplicationLanguage() });
            if ((i != 1) || (Util.isNullOrNil((String)localObject3))) {
              break label894;
            }
            localObject3 = ((String)localObject3).split(";");
            if ((localObject3 == null) || (!Arrays.asList((Object[])localObject3).contains(LocaleUtil.getApplicationLanguage()))) {
              break label894;
            }
            i = 1;
            break;
          }
          label894:
          if (!com.tencent.mm.protocal.d.KyS) {
            break label463;
          }
          i = 1;
          break label465;
          label905:
          ImageGalleryUI.c(ImageGalleryUI.this).li(1, 2);
          break label524;
          label920:
          l = 0L;
          break label662;
          label926:
          Log.e("MicroMsg.ImageGalleryUI", "[arthurdan.ImageGallery] Notice!!! adapter is null");
          label934:
          if (localObject1 != null) {
            break label957;
          }
          Log.e("MicroMsg.ImageGalleryUI", "update footer fail, msg is null, position = ".concat(String.valueOf(paramAnonymousInt)));
        }
        label957:
        Object localObject2 = ImageGalleryUI.this;
        if (!ImageGalleryUI.ab(ImageGalleryUI.this)) {}
        for (boolean bool1 = bool2;; bool1 = false)
        {
          ((ImageGalleryUI)localObject2).m((ca)localObject1, bool1);
          ImageGalleryUI.ah(ImageGalleryUI.this);
          break;
        }
      }
    };
    this.JvM = null;
    this.PzL = false;
    this.PzM = false;
    this.tnh = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(233351);
        if (ImageGalleryUI.aj(ImageGalleryUI.this)) {
          ImageGalleryUI.this.gSG();
        }
        AppMethodBeat.o(233351);
        return false;
      }
    }, false);
    this.PzN = new HashMap();
    this.PzO = false;
    this.PzP = false;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.Poq = new HashSet();
    AppMethodBeat.o(36149);
  }
  
  private static void B(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(233395);
    if (paramView == null)
    {
      AppMethodBeat.o(233395);
      return;
    }
    Log.d("MicroMsg.ImageGalleryUI", "alvinluo showButton view: %s, withAnimation: %b", new Object[] { paramView, Boolean.valueOf(paramBoolean) });
    paramView.setVisibility(0);
    if (paramBoolean)
    {
      paramView.setAlpha(0.0F);
      com.tencent.mm.ui.chatting.gallery.a.m.gE(paramView);
      AppMethodBeat.o(233395);
      return;
    }
    paramView.setAlpha(1.0F);
    AppMethodBeat.o(233395);
  }
  
  private void BY(boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(233385);
    Object localObject2;
    Object localObject1;
    if (this.Pzd != null)
    {
      this.Pzb.PDd = paramBoolean;
      this.Pzb.dFP = getIntent().getBundleExtra("_stat_obj");
      localObject2 = this.Pzb;
      Log.i("MicroMsg.ImageGalleryUI", "talker: %s, chatroom: %s", new Object[] { this.talker, this.chatroomName });
      localObject1 = "";
      if ((Util.isNullOrNil(this.chatroomName)) || (!ab.Eq(this.chatroomName))) {
        break label294;
      }
      Log.d("MicroMsg.ImageGalleryUI", "is chatroom: %s", new Object[] { this.chatroomName });
      localObject1 = this.chatroomName;
      ((com.tencent.mm.ui.chatting.gallery.a.n)localObject2).sourceType = i;
      kotlin.g.b.p.h(localObject1, "<set-?>");
      ((com.tencent.mm.ui.chatting.gallery.a.n)localObject2).source = ((String)localObject1);
      localObject1 = this.Pzb;
      if ((this.Pwu != null) && (this.Pwu.gSg() != null)) {
        break label444;
      }
    }
    for (;;)
    {
      localObject1 = this.Pzd;
      localObject2 = a(this.Pwu, this.xqs);
      com.tencent.mm.ui.chatting.gallery.a.n localn = this.Pzb;
      com.tencent.mm.ui.chatting.gallery.a.k local25 = new com.tencent.mm.ui.chatting.gallery.a.k()
      {
        public final void a(PointF paramAnonymousPointF, AnimatorListenerAdapter paramAnonymousAnimatorListenerAdapter)
        {
          AppMethodBeat.i(233336);
          com.tencent.mm.ui.chatting.gallery.a.o.a(ImageGalleryUI.j(ImageGalleryUI.i(ImageGalleryUI.this)), paramAnonymousPointF.x, paramAnonymousPointF.y, paramAnonymousAnimatorListenerAdapter);
          AppMethodBeat.o(233336);
        }
      };
      Object localObject3 = this.Pzu;
      kotlin.g.b.p.h(localn, "codeResult");
      if (((com.tencent.mm.ui.chatting.gallery.a.j)localObject1).PCs)
      {
        Log.i("MicroMsg.ImageScanCodeManager", "alvinluo handleCode %s", new Object[] { localn.CFJ });
        localObject3 = new j.d((com.tencent.mm.ui.chatting.gallery.a.j)localObject1, (com.tencent.mm.ui.chatting.gallery.a.i)localObject3);
        com.tencent.mm.ui.chatting.gallery.a.o localo = com.tencent.mm.ui.chatting.gallery.a.o.PDi;
        com.tencent.mm.ui.chatting.gallery.a.o.a((Context)((com.tencent.mm.ui.chatting.gallery.a.j)localObject1).dKq, (View)localObject2, localn, local25, (com.tencent.mm.ui.chatting.gallery.a.d)localObject3);
      }
      AppMethodBeat.o(233385);
      return;
      label294:
      if (!Util.isNullOrNil(this.talker))
      {
        if (ab.IT(this.talker))
        {
          Log.d("MicroMsg.ImageGalleryUI", "is biz: %s", new Object[] { this.talker });
          int j = 4;
          i = j;
          if (((com.tencent.mm.ui.chatting.gallery.a.n)localObject2).dFP != null)
          {
            ((com.tencent.mm.ui.chatting.gallery.a.n)localObject2).dFP.putString("img_gallery_talker", this.talker);
            i = j;
          }
        }
        for (;;)
        {
          localObject1 = this.talker;
          break;
          if (ab.Eq(this.talker))
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
      label444:
      localObject2 = this.Pwu.i(this.Pwu.gSg(), true);
      if ((localObject2 != null) && (!Util.isNullOrNil(((com.tencent.mm.av.g)localObject2).iXy)))
      {
        localObject2 = XmlParser.parseXml(((com.tencent.mm.av.g)localObject2).iXy, "msg", null);
        if (localObject2 != null)
        {
          ((com.tencent.mm.ui.chatting.gallery.a.n)localObject1).dFO = ((String)((Map)localObject2).get(".msg.img.$aeskey"));
          ((com.tencent.mm.ui.chatting.gallery.a.n)localObject1).imagePath = ((String)((Map)localObject2).get(".msg.img.$cdnmidimgurl"));
        }
      }
    }
  }
  
  private void BZ(boolean paramBoolean)
  {
    AppMethodBeat.i(233386);
    String str = cVV();
    Object localObject2;
    label76:
    Object localObject1;
    if (((this.tgN == 0) || (this.tgN == 2)) && (!Util.isNullOrNil(str)))
    {
      localObject2 = new ep();
      long l;
      if (this.tgN == 2)
      {
        l = 1L;
        ((ep)localObject2).erW = l;
        ((ep)localObject2).ejA = 3L;
        if (!paramBoolean) {
          break label327;
        }
        l = 10L;
        ((ep)localObject2).eDV = l;
        localObject1 = d.k(this.Pwu.gSg());
        if (localObject1 != null)
        {
          ((ep)localObject2).rK(((com.tencent.mm.av.g)localObject1).getFileId());
          ((ep)localObject2).rL(((com.tencent.mm.av.g)localObject1).getAesKey());
        }
        ((ep)localObject2).bfK();
        this.tgM = ((int)(com.tencent.mm.model.z.aTY().hashCode() + System.currentTimeMillis()));
        localObject2 = ((com.tencent.mm.plugin.scanner.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.scanner.e.class)).getTranslationResult(str);
        if ((localObject2 == null) || (!com.tencent.mm.vfs.s.YS(((fx)localObject2).field_resultFile))) {
          break label339;
        }
        if (this.Pwu.amt(this.PzE) == null) {
          break label469;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("original_file_path", str);
        ((Intent)localObject2).putExtra("msg_id", this.Pwu.amt(this.PzE).field_msgId);
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
          ((Intent)localObject2).putExtra("fileid", ((com.tencent.mm.av.g)localObject1).getFileId());
          ((Intent)localObject2).putExtra("aeskey", ((com.tencent.mm.av.g)localObject1).getAesKey());
        }
        startActivity(TranslationResultUI.class, (Intent)localObject2);
        finish();
        overridePendingTransition(2130771986, 2130771986);
        this.Pzs.anq(1);
        AppMethodBeat.o(233386);
        return;
        l = 0L;
        break;
        l = 4L;
        break label76;
      }
      label339:
      if ((com.tencent.mm.kernel.g.azz().aYS() == 6) || (com.tencent.mm.kernel.g.azz().aYS() == 4)) {
        break label476;
      }
      com.tencent.mm.ui.base.h.c(this, getString(2131755914), "", true);
      Cb(false);
      Log.i("MicroMsg.ImageGalleryUI", "try to translate img %s, sessionId %d", new Object[] { str, Integer.valueOf(this.tgM) });
      localObject1 = new to();
      localObject2 = ((to)localObject1).dZY;
      if (!paramBoolean) {
        break label488;
      }
    }
    label469:
    label476:
    label488:
    for (int i = 7;; i = 1)
    {
      ((to.a)localObject2).scene = i;
      ((to)localObject1).dZY.filePath = str;
      ((to)localObject1).dZY.dEb = this.tgM;
      EventCenter.instance.publish((IEvent)localObject1);
      AppMethodBeat.o(233386);
      return;
      this.tgN = 1;
      cWi();
      break;
    }
  }
  
  private static void C(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(233396);
    Log.d("MicroMsg.ImageGalleryUI", "alvinluo hideButton view: %s, withAnimation: %b", new Object[] { paramView, Boolean.valueOf(paramBoolean) });
    if (paramView == null)
    {
      AppMethodBeat.o(233396);
      return;
    }
    if (!paramBoolean)
    {
      aL(paramView, 8);
      com.tencent.mm.ui.chatting.gallery.a.m.gG(paramView);
      AppMethodBeat.o(233396);
      return;
    }
    if (paramView.getVisibility() == 0) {
      com.tencent.mm.ui.chatting.gallery.a.m.gF(paramView);
    }
    AppMethodBeat.o(233396);
  }
  
  private void Ca(boolean paramBoolean)
  {
    AppMethodBeat.i(233388);
    this.tgP.setVisibility(8);
    this.tgQ.setVisibility(8);
    this.tgR.setVisibility(8);
    if (!paramBoolean)
    {
      gSQ();
      Cd(false);
    }
    AppMethodBeat.o(233388);
  }
  
  private void Cb(boolean paramBoolean)
  {
    AppMethodBeat.i(36170);
    this.tgN = 0;
    Cc(paramBoolean);
    AppMethodBeat.o(36170);
  }
  
  private void Cc(boolean paramBoolean)
  {
    AppMethodBeat.i(233390);
    Ca(paramBoolean);
    this.tgS.setRepeatMode(1);
    this.tgS.setRepeatCount(0);
    this.tgS.end();
    AppMethodBeat.o(233390);
  }
  
  private void Cd(boolean paramBoolean)
  {
    AppMethodBeat.i(233393);
    if (BuildInfo.IS_FLAVOR_RED) {
      Log.d("MicroMsg.ImageGalleryUI", "showOpLayer isShowOpToolbar: %b, pageChanged: %b, %s", new Object[] { Boolean.valueOf(this.PzM), Boolean.valueOf(paramBoolean), Util.getStack() });
    }
    if (this.Pyy)
    {
      AppMethodBeat.o(233393);
      return;
    }
    if (this.Pwu != null) {}
    for (ca localca = this.Pwu.gSg();; localca = null)
    {
      if (localca == null)
      {
        AppMethodBeat.o(233393);
        return;
      }
      if (br.K(localca))
      {
        Log.w("MicroMsg.ImageGalleryUI", "ignore show opLayer");
        AppMethodBeat.o(233393);
        return;
      }
      if (!this.PzM) {
        gSR();
      }
      for (boolean bool = false;; bool = true)
      {
        this.PyC = 0;
        this.PzM = true;
        this.Pyx.setVisibility(0);
        gSQ();
        gSJ();
        l(localca, paramBoolean);
        if (!paramBoolean) {
          bI(0, true);
        }
        for (;;)
        {
          if (gSO()) {
            cWW();
          }
          pF(true);
          Ci(true);
          AppMethodBeat.o(233393);
          return;
          if (!gSP()) {
            bJ(0, bool);
          }
        }
      }
    }
  }
  
  private boolean Ce(boolean paramBoolean)
  {
    AppMethodBeat.i(233400);
    if (!this.Pzc)
    {
      AppMethodBeat.o(233400);
      return false;
    }
    boolean bool2 = gMw();
    boolean bool3 = this.Pze.oe(2);
    if ((bool3) && (!bool2) && (!gSA())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.v("MicroMsg.ImageGalleryUI", "showScanCodeButton showQRCodeResult: %b, isFromQuoteMsg: %b, show: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (!bool1) {
        break;
      }
      this.Pzs.ann(2);
      if (gSu().PyP.getVisibility() != 0) {
        aL(gSu().PyP, 0);
      }
      AppMethodBeat.o(233400);
      return true;
    }
    if (paramBoolean) {
      aL(gSu().PyP, 8);
    }
    AppMethodBeat.o(233400);
    return false;
  }
  
  private boolean Cf(boolean paramBoolean)
  {
    AppMethodBeat.i(233401);
    if (!gSK())
    {
      AppMethodBeat.o(233401);
      return false;
    }
    boolean bool2 = this.Pze.oe(1);
    boolean bool1;
    ep localep;
    if ((this.Pzo) && (bool2) && (!gSA()))
    {
      bool1 = true;
      Log.v("MicroMsg.ImageGalleryUI", "showScanTranslateButton showQuickTrans: %b, showTranslateResult: %b, show: %b", new Object[] { Boolean.valueOf(this.Pzo), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (!bool1) {
        break label231;
      }
      localep = new ep();
      if (this.tgN != 2) {
        break label225;
      }
    }
    label225:
    for (long l = 1L;; l = 0L)
    {
      localep.erW = l;
      localep.ejA = 8L;
      localep.eDV = 10L;
      if (this.Pwu != null)
      {
        com.tencent.mm.av.g localg = d.k(this.Pwu.gSg());
        if (localg != null)
        {
          localep.rK(localg.getFileId());
          localep.rL(localg.getAesKey());
        }
      }
      localep.bfK();
      this.Pzs.ann(3);
      if (this.PyO.getVisibility() != 0) {
        aL(this.PyO, 0);
      }
      AppMethodBeat.o(233401);
      return true;
      bool1 = false;
      break;
    }
    label231:
    if (paramBoolean) {
      aL(this.PyO, 8);
    }
    AppMethodBeat.o(233401);
    return false;
  }
  
  private boolean Cg(boolean paramBoolean)
  {
    AppMethodBeat.i(233402);
    if ((!gSK()) || (!com.tencent.mm.ui.chatting.gallery.a.e.gTs()))
    {
      AppMethodBeat.o(233402);
      return false;
    }
    if ((!gMw()) && (!gSA()) && (this.Pze.oe(4))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ImageGalleryUI", "alvinluo showSearchImageButton showButton: %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      aL(gSw().PyR, 0);
      this.Pzs.anr(3);
      AppMethodBeat.o(233402);
      return true;
    }
    if (paramBoolean) {
      aL(gSw().PyR, 8);
    }
    AppMethodBeat.o(233402);
    return false;
  }
  
  private boolean Ch(boolean paramBoolean)
  {
    AppMethodBeat.i(233403);
    if ((!gSK()) || (!com.tencent.mm.ui.chatting.gallery.a.e.gTt()))
    {
      AppMethodBeat.o(233403);
      return false;
    }
    boolean bool;
    label113:
    Object localObject;
    int i;
    if ((!gMw()) && (!gSA()) && (this.Pzg != null) && (!Util.isNullOrNil(this.Pzg.CBb)) && (this.Pze.oe(3)))
    {
      bool = true;
      Log.i("MicroMsg.ImageGalleryUI", "alvinluo showSearchImageBubbleView showBubble: %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label391;
      }
      if (this.Pyx.getVisibility() != 0) {
        break label364;
      }
      paramBoolean = true;
      localObject = gSw().PyR;
      if (!paramBoolean) {
        break label369;
      }
      i = 0;
      label128:
      aL((View)localObject, i);
      localObject = gSx().PyS;
      if (!paramBoolean) {
        break label375;
      }
      i = 0;
      label149:
      aL((View)localObject, i);
      int k = this.xqs.getMeasuredWidth();
      int j = k - (this.PyC + 1) * this.PyD - this.PyF;
      i = j;
      if (this.PyC > 1) {
        i = j - this.PyC * this.PyE;
      }
      Log.i("MicroMsg.ImageGalleryUI", "alvinluo showSearchImageBubbleView visible: %b, galleryWidth: %d, showButtonCount: %d, viewPositionX: %d, bottomBtnSize: %d, bottomBtnRightExtrMargin: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(k), Integer.valueOf(this.PyC), Integer.valueOf(i), Integer.valueOf(this.PyD), Integer.valueOf(this.PyF) });
      localObject = gSx().PyS;
      ((SearchImageBubbleView)localObject).setViewWidth(k);
      ((SearchImageBubbleView)localObject).setBubbleText(this.Pzg.CBb);
      ((SearchImageBubbleView)localObject).lj(this.PyD, this.PyD);
      ((SearchImageBubbleView)localObject).setAnchorViewPosition$255f295(i);
      ((SearchImageBubbleView)localObject).setBubbleClickListener(this);
      if (!paramBoolean) {
        break label381;
      }
      ((SearchImageBubbleView)localObject).show();
    }
    for (;;)
    {
      this.Pzs.anr(4);
      this.Pzs.anr(3);
      AppMethodBeat.o(233403);
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
      aL(gSx().PyS, 8);
    }
    AppMethodBeat.o(233403);
    return false;
  }
  
  private void Ci(boolean paramBoolean)
  {
    AppMethodBeat.i(36177);
    if ((this.Pyw != b.b.Pxd) || (gSA()))
    {
      aL(this.PyT, 4);
      AppMethodBeat.o(36177);
      return;
    }
    Object localObject = null;
    if (this.Pwu != null) {
      localObject = this.Pwu.gSg();
    }
    if ((localObject == null) || (br.D((ca)localObject)))
    {
      aL(this.PyT, 4);
      AppMethodBeat.o(36177);
      return;
    }
    com.tencent.mm.av.g localg = this.Pwu.i((ca)localObject, false);
    if (paramBoolean)
    {
      this.xqs.getCurrentItem();
      if ((f((ca)localObject, localg)) && (!((ca)localObject).gDB()) && (localg.bcu()))
      {
        gSq().PyU.setVisibility(0);
        gSq().PyV.setVisibility(8);
        gSq().PyW.setVisibility(8);
        String str = (String)this.PzN.get(Long.valueOf(localg.localId));
        localObject = str;
        if (str == null)
        {
          localObject = NP(g(localg));
          this.PzN.put(Long.valueOf(localg.localId), localObject);
        }
        gSq().PyU.setText(getString(2131758222, new Object[] { localObject }));
        aL(this.PyT, 0);
        AppMethodBeat.o(36177);
        return;
      }
    }
    aL(this.PyT, 4);
    AppMethodBeat.o(36177);
  }
  
  private static void Cj(boolean paramBoolean)
  {
    AppMethodBeat.i(36185);
    Log.d("MicroMsg.ImageGalleryUI", "switch tool bar bg %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(36185);
  }
  
  private static String NP(long paramLong)
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
      Log.d("MicroMsg.ImageGalleryUI", "get current view adapter is null %b, gallery is null %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((paramb == null) || (paramMMViewPager == null)) {
        break label182;
      }
      if (paramb.gSg() != null) {
        break label81;
      }
      AppMethodBeat.o(36164);
      return null;
      bool1 = false;
      break;
    }
    label81:
    Object localObject;
    if ((paramb.gSg().gAz()) || (paramb.gSg().gDr()))
    {
      MultiTouchImageView localMultiTouchImageView = paramb.NQ(paramMMViewPager.getCurrentItem());
      localObject = localMultiTouchImageView;
      if (localMultiTouchImageView == null) {
        localObject = paramb.NR(paramMMViewPager.getCurrentItem());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(36164);
      return localObject;
      if ((paramb.gSg().cWJ()) || (paramb.gSg().cWL()) || (paramb.gSg().cWK()))
      {
        localObject = paramb.amR(paramMMViewPager.getCurrentItem());
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
  
  private void a(View paramView, String paramString, Bitmap paramBitmap, int paramInt, com.tencent.mm.ui.chatting.gallery.a.h paramh)
  {
    AppMethodBeat.i(233391);
    if (this.Pzd != null) {
      if (paramInt == 1)
      {
        if (this.Pzc)
        {
          this.Pzd.a(paramView, paramString, paramBitmap, true, paramInt, paramh);
          AppMethodBeat.o(233391);
        }
      }
      else {
        this.Pzd.a(paramView, paramString, paramBitmap, false, paramInt, paramh);
      }
    }
    AppMethodBeat.o(233391);
  }
  
  private static void aL(View paramView, int paramInt)
  {
    AppMethodBeat.i(36156);
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(36156);
  }
  
  private boolean anc(int paramInt)
  {
    AppMethodBeat.i(233377);
    if (this.Pze.ans(paramInt) != 2)
    {
      AppMethodBeat.o(233377);
      return true;
    }
    AppMethodBeat.o(233377);
    return false;
  }
  
  private void ane(int paramInt)
  {
    AppMethodBeat.i(36181);
    ca localca = this.Pwu.amt(paramInt);
    if ((localca == null) || (!localca.cWK()) || (this.PwE))
    {
      AppMethodBeat.o(36181);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(new i.c(localca.field_talker, "update", localca));
    AppMethodBeat.o(36181);
  }
  
  private void anf(int paramInt)
  {
    AppMethodBeat.i(36189);
    Log.i("MicroMsg.ImageGalleryUI", "enterGrid source : ".concat(String.valueOf(paramInt)));
    if (this.Pwu == null)
    {
      Log.w("MicroMsg.ImageGalleryUI", "try to enterGrid, but adapter is NULL");
      AppMethodBeat.o(36189);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(219L, 13L, 1L, true);
    int i = this.Pwu.getRealCount();
    if (this.Pwu.gSg() == null)
    {
      Log.e("MicroMsg.ImageGalleryUI", "msgInfo is null");
      AppMethodBeat.o(36189);
      return;
    }
    int j = this.Pwu.Pww.amX(this.xqs.getCurrentItem());
    if (!this.Pzj)
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), MediaHistoryGalleryUI.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("kintent_intent_source", paramInt);
      ((Intent)localObject).putExtra("kintent_talker", gSz());
      ((Intent)localObject).putExtra("kintent_image_count", i);
      ((Intent)localObject).putExtra("kintent_image_index", j);
      ((Intent)localObject).putExtra("key_biz_chat_id", this.ppv);
      ((Intent)localObject).putExtra("key_is_biz_chat", this.tca);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "enterGrid", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "enterGrid", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(233352);
          ImageGalleryUI.this.finish();
          AppMethodBeat.o(233352);
        }
      }, 50L);
      AppMethodBeat.o(36189);
      return;
    }
    cvQ();
    AppMethodBeat.o(36189);
  }
  
  static Animation anh(int paramInt)
  {
    AppMethodBeat.i(36199);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(paramInt);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator(10.0F));
    AppMethodBeat.o(36199);
    return localAlphaAnimation;
  }
  
  private void anj(int paramInt)
  {
    AppMethodBeat.i(36209);
    if (this.JvM != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.JvM.getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, paramInt, 0);
      this.JvM.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(36209);
  }
  
  private void aq(long paramLong, int paramInt)
  {
    AppMethodBeat.i(233409);
    Log.i("MicroMsg.ImageGalleryUI", "dealWithSearchImage sessionId: %s, fromSource: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    ca localca = this.Pwu.gSg();
    com.tencent.mm.plugin.websearch.api.o localo = new com.tencent.mm.plugin.websearch.api.o();
    localo.sessionId = paramLong;
    localo.context = this;
    localo.dTX = localca;
    localo.dGf = paramInt;
    ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(localo);
    AppMethodBeat.o(233409);
  }
  
  private void bI(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(233394);
    if ((gMw()) || (gSA()))
    {
      AppMethodBeat.o(233394);
      return;
    }
    Log.d("MicroMsg.ImageGalleryUI", "alvinluo checkShowQuickButton fromType: %d, needHide: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Object localObject1 = null;
    if (Ce(paramBoolean))
    {
      localObject1 = gSu().PyP;
      paramInt = 2;
    }
    for (;;)
    {
      int i = this.PyI;
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
        i = this.PyI;
        if (paramInt != this.PyI)
        {
          if ((this.PyI != 0) && ((paramInt != 3) || (localObject1 == null) || (((View)localObject1).getVisibility() == 0))) {
            break label401;
          }
          paramBoolean = true;
          label203:
          this.Pzf = 0;
          B((View)localObject1, paramBoolean);
          int j = gSx().PyS.getVisibility();
          bJ(paramInt, false);
          if (this.PyI == 3)
          {
            aL(gSx().PyS, j);
            C(gSx().PyS, true);
          }
          this.PyI = paramInt;
          this.PyJ = ((View)localObject1);
        }
        if (paramInt == 3)
        {
          localObject1 = gSw().PyR;
          if ((i != 0) || (gSq().PyR.getVisibility() == 0)) {
            break label406;
          }
        }
      }
      label393:
      label401:
      label406:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        B((View)localObject1, paramBoolean);
        AppMethodBeat.o(233394);
        return;
        if (Ch(paramBoolean))
        {
          localObject1 = gSx().PyS;
          paramInt = 3;
          break;
        }
        if (Cf(paramBoolean))
        {
          localObject1 = this.PyO;
          paramInt = 1;
          break;
        }
        if (!bK(paramInt, paramBoolean)) {
          break label518;
        }
        paramInt = 4;
        localObject1 = gSw().PyR;
        break;
        localObject2 = "null";
        break label102;
        localObject3 = "null";
        break label117;
        paramBoolean = false;
        break label203;
      }
      label411:
      if (this.Pze.gTv())
      {
        Log.i("MicroMsg.ImageGalleryUI", "alvinluo checkShowQuickButton isAllValid and hideQuickButton");
        localObject1 = this.PyJ;
        if ((this.PyI == 0) || (this.PyJ == null)) {
          break label508;
        }
        paramBoolean = true;
        C((View)localObject1, paramBoolean);
        if (this.PyI == 3)
        {
          localObject1 = gSw().PyR;
          if (gSq().PyR.getVisibility() != 0) {
            break label513;
          }
        }
      }
      label513:
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        C((View)localObject1, paramBoolean);
        gSI();
        AppMethodBeat.o(233394);
        return;
        label508:
        paramBoolean = false;
        break;
      }
      label518:
      paramInt = 0;
    }
  }
  
  private void bJ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(233397);
    if ((gMw()) || (gSA()))
    {
      AppMethodBeat.o(233397);
      return;
    }
    Log.i("MicroMsg.ImageGalleryUI", "alvinluo hideQuickButton showType: %d, withAnimation: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramInt != 2) {
      C(gSu().PyP, paramBoolean);
    }
    if (paramInt != 3) {
      C(gSx().PyS, paramBoolean);
    }
    if (paramInt != 1) {
      C(this.PyO, paramBoolean);
    }
    if (paramInt != 4) {
      C(gSw().PyR, paramBoolean);
    }
    if (paramInt == 0) {
      gSI();
    }
    AppMethodBeat.o(233397);
  }
  
  private boolean bK(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(233405);
    if ((!gSK()) || (!com.tencent.mm.ui.chatting.gallery.a.e.gTs()))
    {
      AppMethodBeat.o(233405);
      return false;
    }
    this.Pze.li(4, 2);
    boolean bool = this.Pze.isValid(4);
    Log.i("MicroMsg.ImageGalleryUI", "alvinluo checkShowSearchImageButton fromType: %s, isSearchButtonValid: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    if (bool)
    {
      this.Pze.li(4, 1);
      if (this.Pze.oe(4))
      {
        this.Pze.anu(4);
        paramBoolean = Cg(paramBoolean);
        AppMethodBeat.o(233405);
        return paramBoolean;
      }
    }
    AppMethodBeat.o(233405);
    return false;
  }
  
  private boolean bmX(String paramString)
  {
    AppMethodBeat.i(36169);
    if (this.Pzn == 1)
    {
      AppMethodBeat.o(36169);
      return false;
    }
    if ((this.Pzb == null) || (Util.isNullOrNil(this.Pzb.CFJ)))
    {
      AppMethodBeat.o(36169);
      return false;
    }
    if (!this.Pzl)
    {
      AppMethodBeat.o(36169);
      return true;
    }
    String[] arrayOfString = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NYt, "")).split("\\|");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((!Util.isNullOrNil(str)) && (paramString.startsWith(str)))
        {
          Log.i("MicroMsg.ImageGalleryUI", "curDealQBarStr:%s, blockQrcodeStr:%s", new Object[] { paramString, str });
          AppMethodBeat.o(36169);
          return false;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(36169);
    return true;
  }
  
  private void bmY(String paramString)
  {
    AppMethodBeat.i(36213);
    paramString = RecordConfigProvider.jA(paramString, "");
    paramString.scene = this.Pzn;
    Object localObject = new UICustomParam.a();
    ((UICustomParam.a)localObject).apE();
    ((UICustomParam.a)localObject).apD();
    ((UICustomParam.a)localObject).dz(true);
    paramString.BOn = ((UICustomParam.a)localObject).gLU;
    localObject = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
    com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4369, 2130772161, -1, paramString, 1, 2);
    AppMethodBeat.o(36213);
  }
  
  private boolean bq(Activity paramActivity)
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
  
  private String cVV()
  {
    AppMethodBeat.i(36166);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    ca localca;
    if (this.Pwu != null)
    {
      localca = this.Pwu.amt(this.PzE);
      if (!b.j(localca)) {
        break label74;
      }
      com.tencent.mm.av.g localg = this.Pwu.i(localca, true);
      localObject1 = localObject2;
      if (localg != null) {
        localObject1 = d.a(localca, localg);
      }
    }
    for (;;)
    {
      localObject1 = Util.nullAsNil((String)localObject1);
      AppMethodBeat.o(36166);
      return localObject1;
      label74:
      localObject1 = localObject2;
      if (b.cp(localca)) {
        localObject1 = b.l(localca);
      }
    }
  }
  
  private void cWW()
  {
    AppMethodBeat.i(36183);
    Log.i("MicroMsg.ImageGalleryUI", "show video tool bar");
    Cj(true);
    aL(this.PyT, 4);
    aL(gSr().FLz, 0);
    aL(gSr().JvS, 0);
    aL(this.PyK, 0);
    if (this.Pyy) {
      gSG();
    }
    if (this.Pwu != null)
    {
      ca localca = this.Pwu.gSg();
      if ((localca != null) && (localca.cWK())) {
        aL(this.JvM, 0);
      }
    }
    AppMethodBeat.o(36183);
  }
  
  private void cWi()
  {
    AppMethodBeat.i(233389);
    gSE();
    this.tgS.setRepeatMode(1);
    this.tgS.setRepeatCount(-1);
    this.tgS.start();
    AppMethodBeat.o(233389);
  }
  
  private void cvQ()
  {
    AppMethodBeat.i(36165);
    if ((this.FLK) || (this.Pwu == null))
    {
      Log.i("MicroMsg.ImageGalleryUI", "isRunningExitAnimation");
      AppMethodBeat.o(36165);
      return;
    }
    Cb(true);
    fhB();
    if (this.Pyy)
    {
      finish();
      com.tencent.mm.ui.base.b.kc(getContext());
      AppMethodBeat.o(36165);
      return;
    }
    Log.i("MicroMsg.ImageGalleryUI", "runExitAnimation");
    int k = this.xqs.getWidth() / 2;
    int j = this.xqs.getHeight() / 2;
    this.Pwu.gSf();
    Object localObject1;
    int m;
    int i;
    int n;
    if (!gMw())
    {
      if (this.Pzj)
      {
        localObject1 = new ir();
        ((ir)localObject1).dNm.msgId = this.Pwu.amt(this.xqs.getCurrentItem()).field_msgId;
        EventCenter.instance.publish((IEvent)localObject1);
        m = ((ir)localObject1).dNn.dEs;
        i = ((ir)localObject1).dNn.dEt;
        k = ((ir)localObject1).dNn.dEq;
        j = ((ir)localObject1).dNn.dEr;
        this.EAz = this.xqs.getWidth();
        this.EAA = this.xqs.getHeight();
        n = i;
        if (this.Pwu.gSg() != null)
        {
          if ((this.Pwu.gSg().cWL()) || (this.Pwu.gSg().cWJ()) || (this.Pwu.gSg().cWK())) {
            this.EAA = ((int)(this.EAz / m * i));
          }
          if (!this.Pwu.gSg().gAz())
          {
            n = i;
            if (!this.Pwu.gSg().gDr()) {}
          }
          else
          {
            localObject1 = (com.tencent.mm.ui.base.g)a(this.Pwu, this.xqs);
            n = i;
            if (localObject1 != null)
            {
              float f = this.EAz / ((com.tencent.mm.ui.base.g)localObject1).getImageWidth();
              this.EAA = ((int)(((com.tencent.mm.ui.base.g)localObject1).getImageHeight() * f));
              n = i;
              if (this.EAA > this.xqs.getHeight())
              {
                n = i;
                if (this.EAA < this.xqs.getHeight() * 1.5D)
                {
                  if (!this.Pzj) {
                    break label886;
                  }
                  this.EAB = (this.EAA - this.xqs.getHeight());
                  n = i;
                }
                label445:
                this.EAA = this.xqs.getHeight();
              }
            }
          }
        }
        this.qaE.lt(this.PyX, this.PyY);
        this.qaE.QtK = this.EAB;
        this.qaE.ls(this.EAz, this.EAA);
        this.qaE.Q(k, j, m, n);
        localObject1 = this.xqs;
        localObject2 = a(this.Pwu, this.xqs);
        if (localObject2 == null) {
          break label905;
        }
        localObject1 = localObject2;
        if (this.EAC != 1.0D)
        {
          this.qaE.QtG = (1.0F / this.EAC);
          if (this.EAD == 0)
          {
            localObject1 = localObject2;
            if (this.EAE == 0) {}
          }
          else
          {
            i = (int)(this.xqs.getWidth() / 2 * (1.0F - this.EAC));
            j = this.EAD;
            k = (int)(this.xqs.getHeight() / 2 + this.EAE - this.EAA / 2 * this.EAC);
            this.qaE.lu(i + j, k);
            localObject1 = localObject2;
          }
        }
        label652:
        if (this.PzM) {
          gSH();
        }
        this.qaE.a((View)localObject1, this.jUG, new e.c()
        {
          public final void onAnimationEnd()
          {
            AppMethodBeat.i(233325);
            Log.i("MicroMsg.ImageGalleryUI", "runExitAnimation onAnimationEnd");
            ImageGalleryUI.G(ImageGalleryUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(233323);
                ImageGalleryUI.this.finish();
                ImageGalleryUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.o(233323);
              }
            });
            ImageGalleryUI.b(ImageGalleryUI.this, false);
            AppMethodBeat.o(233325);
          }
          
          public final void onAnimationStart()
          {
            AppMethodBeat.i(233324);
            ImageGalleryUI.b(ImageGalleryUI.this, true);
            new MMHandler().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(233322);
                View localView = ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.Pwu, ImageGalleryUI.this.xqs);
                if ((localView != null) && ((localView instanceof com.tencent.mm.ui.base.g)))
                {
                  if ((localView instanceof MultiTouchImageView))
                  {
                    ((MultiTouchImageView)localView).gKy();
                    AppMethodBeat.o(233322);
                    return;
                  }
                  if ((localView instanceof WxImageView)) {
                    ((WxImageView)localView).gKy();
                  }
                }
                AppMethodBeat.o(233322);
              }
            }, 20L);
            AppMethodBeat.o(233324);
          }
        }, null);
        AppMethodBeat.o(36165);
        return;
      }
      localObject1 = this.Pwu.amt(this.xqs.getCurrentItem());
      if (localObject1 == null) {
        break label908;
      }
      Object localObject2 = new bf();
      ((bf)localObject2).dEo.dCM = ((ca)localObject1);
      EventCenter.instance.publish((IEvent)localObject2);
      m = ((bf)localObject2).dEp.dEs;
      i = ((bf)localObject2).dEp.dEt;
      k = ((bf)localObject2).dEp.dEq;
      j = ((bf)localObject2).dEp.dEr;
    }
    for (;;)
    {
      if ((k == 0) && (j == 0))
      {
        k = this.xqs.getWidth() / 2;
        j = this.xqs.getHeight() / 2;
        break;
      }
      if (localObject1 != null)
      {
        if (((eo)localObject1).field_isSend == 0) {
          this.PyX = com.tencent.mm.cb.a.fromDPToPix(getContext(), 5);
        }
        if (((eo)localObject1).field_isSend == 1) {
          this.PyY = com.tencent.mm.cb.a.fromDPToPix(getContext(), 5);
        }
      }
      break;
      m = this.qaH;
      i = this.qaI;
      k = this.qaG;
      j = this.qaF;
      break;
      label886:
      n = this.xqs.getHeight() * i / this.EAA;
      break label445;
      label905:
      break label652;
      label908:
      i = 0;
      m = 0;
    }
  }
  
  private static boolean f(ca paramca, com.tencent.mm.av.g paramg)
  {
    AppMethodBeat.i(36179);
    if (paramg == null)
    {
      AppMethodBeat.o(36179);
      return false;
    }
    try
    {
      if ((b.c(paramca, paramg) == 0) && (paramg.bcv()))
      {
        boolean bool = paramca.gDB();
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
  
  private void fhA()
  {
    AppMethodBeat.i(233378);
    this.PyA = true;
    if (this.xqs != null)
    {
      this.xqs.setEnableGalleryScale(true);
      this.xqs.setSingleMode(false);
    }
    AppMethodBeat.o(233378);
  }
  
  private boolean fhB()
  {
    AppMethodBeat.i(233379);
    fhA();
    if ((this.EAm != null) && (this.EAm.It(this.EAl)))
    {
      this.EAl = 0L;
      AppMethodBeat.o(233379);
      return true;
    }
    AppMethodBeat.o(233379);
    return false;
  }
  
  private static int g(com.tencent.mm.av.g paramg)
  {
    AppMethodBeat.i(36187);
    Map localMap = XmlParser.parseXml(paramg.iXy, "msg", null);
    if (localMap == null)
    {
      Log.e("MicroMsg.ImageGalleryUI", "parse cdnInfo failed. [%s]", new Object[] { paramg.iXy });
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
  
  private boolean gMw()
  {
    return this.Pdu == 1;
  }
  
  private boolean gSA()
  {
    AppMethodBeat.i(233381);
    this.Pdu = getIntent().getIntExtra("msg_type", 0);
    if (this.Pdu == 2)
    {
      AppMethodBeat.o(233381);
      return true;
    }
    AppMethodBeat.o(233381);
    return false;
  }
  
  private void gSB()
  {
    AppMethodBeat.i(233382);
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this, 1, false);
    locale.HLX = new o.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
      {
        AppMethodBeat.i(233326);
        ca localca = ImageGalleryUI.this.Pwu.gSg();
        String str2;
        String str1;
        if (!br.F(localca))
        {
          paramAnonymousm.d(0, ImageGalleryUI.this.getString(2131764635));
          str2 = ImageGalleryUI.this.getString(2131764870);
          if ((!b.j(localca)) && (!b.cp(localca))) {
            break label114;
          }
          str1 = ImageGalleryUI.this.getString(2131764866);
        }
        for (;;)
        {
          if (!localca.cWK()) {
            paramAnonymousm.d(1, str1);
          }
          paramAnonymousm.b(5, ImageGalleryUI.this.getString(2131757386), 2131690757);
          AppMethodBeat.o(233326);
          return;
          label114:
          if (!b.m(localca))
          {
            str1 = str2;
            if (!b.cn(localca)) {}
          }
          else
          {
            str1 = str2;
            if (!localca.cWK()) {
              str1 = ImageGalleryUI.this.getString(2131764871);
            }
          }
        }
      }
    };
    locale.HLY = this.rjz;
    locale.dGm();
    AppMethodBeat.o(233382);
  }
  
  private c gSC()
  {
    AppMethodBeat.i(233383);
    if (this.PzD == null) {
      this.PzD = new c((byte)0);
    }
    c localc = this.PzD;
    AppMethodBeat.o(233383);
    return localc;
  }
  
  private boolean gSD()
  {
    AppMethodBeat.i(36168);
    if (this.Pzl)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if (this.Pzn == 1)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if (this.PwE)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if ((!this.Ptq) && (!this.tca) && (!h.a.gSp().tku))
    {
      AppMethodBeat.o(36168);
      return true;
    }
    AppMethodBeat.o(36168);
    return false;
  }
  
  private void gSE()
  {
    AppMethodBeat.i(233387);
    this.tgP.setVisibility(0);
    this.tgQ.setVisibility(0);
    this.tgR.setVisibility(0);
    gSG();
    AppMethodBeat.o(233387);
  }
  
  private void gSI()
  {
    this.PyI = 0;
    this.PyJ = null;
  }
  
  private void gSJ()
  {
    int j = 0;
    AppMethodBeat.i(233398);
    if ((gMw()) || (gSA()))
    {
      AppMethodBeat.o(233398);
      return;
    }
    aL(this.PyM, 0);
    View localView = gSs().PyL;
    if (this.Pzi) {}
    for (int i = 0;; i = 8)
    {
      aL(localView, i);
      int k = this.PyC;
      i = j;
      if (this.Pzi) {
        i = 1;
      }
      this.PyC = (k + (i + 1));
      AppMethodBeat.o(233398);
      return;
    }
  }
  
  private boolean gSK()
  {
    return (this.Ptr) || (this.Pzj);
  }
  
  private void gSL()
  {
    AppMethodBeat.i(233404);
    if (gSx().PyS.getVisibility() == 0) {
      Ch(true);
    }
    AppMethodBeat.o(233404);
  }
  
  private int gSM()
  {
    if (this.Pzm == 0)
    {
      locala = com.tencent.mm.plugin.webview.ui.tools.media.a.JvG;
      return 2;
    }
    if (this.Pzm == 1)
    {
      locala = com.tencent.mm.plugin.webview.ui.tools.media.a.JvG;
      return 4;
    }
    com.tencent.mm.plugin.webview.ui.tools.media.a locala = com.tencent.mm.plugin.webview.ui.tools.media.a.JvG;
    return 1;
  }
  
  private int gSN()
  {
    if (this.Pyz) {
      return 3;
    }
    return 4;
  }
  
  private boolean gSO()
  {
    return this.Pyw == b.b.Pxe;
  }
  
  private boolean gSP()
  {
    return (this.Pyw == b.b.Pxd) || (this.Pyw == b.b.Pxg);
  }
  
  private void gSR()
  {
    boolean bool = true;
    AppMethodBeat.i(36197);
    if (this.Pyx.getVisibility() == 0) {}
    for (;;)
    {
      Log.d("MicroMsg.ImageGalleryUI", "fadeInOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      this.Pyx.clearAnimation();
      this.Pyx.startAnimation(gSS());
      AppMethodBeat.o(36197);
      return;
      bool = false;
    }
  }
  
  private static Animation gSS()
  {
    AppMethodBeat.i(36198);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(150L);
    localAlphaAnimation.setFillAfter(true);
    AppMethodBeat.o(36198);
    return localAlphaAnimation;
  }
  
  private void gSU()
  {
    AppMethodBeat.i(36210);
    if (this.JvM != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.JvM.getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, 0, 0);
      this.JvM.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(36210);
  }
  
  private void gSV()
  {
    AppMethodBeat.i(36212);
    ca localca = this.Pwu.gSg();
    String str = d.a(localca, d.k(localca));
    Log.i("MicroMsg.ImageGalleryUI", "edit image path:%s msgId:%s", new Object[] { str, Long.valueOf(localca.field_msgId) });
    bmY(str);
    AppMethodBeat.o(36212);
  }
  
  private ImageGalleryUI gSs()
  {
    AppMethodBeat.i(36154);
    if (this.PyL == null) {
      this.PyL = findViewById(2131300134);
    }
    AppMethodBeat.o(36154);
    return this;
  }
  
  private ImageGalleryUI gSt()
  {
    AppMethodBeat.i(36155);
    if (this.PyN == null) {
      this.PyN = findViewById(2131299750);
    }
    AppMethodBeat.o(36155);
    return this;
  }
  
  private ImageGalleryUI gSu()
  {
    AppMethodBeat.i(233371);
    if (this.PyP == null) {
      this.PyP = findViewById(2131301862);
    }
    AppMethodBeat.o(233371);
    return this;
  }
  
  private ImageGalleryUI gSv()
  {
    AppMethodBeat.i(233372);
    if (this.PyQ == null) {
      this.PyQ = findViewById(2131307262);
    }
    AppMethodBeat.o(233372);
    return this;
  }
  
  private ImageGalleryUI gSw()
  {
    AppMethodBeat.i(233373);
    if (this.PyR == null) {
      this.PyR = findViewById(2131301863);
    }
    AppMethodBeat.o(233373);
    return this;
  }
  
  private ImageGalleryUI gSx()
  {
    AppMethodBeat.i(233374);
    if (this.PyS == null) {
      this.PyS = ((SearchImageBubbleView)findViewById(2131307394));
    }
    AppMethodBeat.o(233374);
    return this;
  }
  
  private void gSy()
  {
    int i = 2;
    AppMethodBeat.i(233376);
    boolean bool1 = anc(1);
    boolean bool2 = anc(2);
    if ((bool1) && (bool2)) {
      i = 4;
    }
    for (;;)
    {
      this.Pzs.ano(i);
      AppMethodBeat.o(233376);
      return;
      if (bool1) {
        i = 3;
      } else if (!bool2) {
        i = 1;
      }
    }
  }
  
  private String gSz()
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
  
  private void ghN()
  {
    boolean bool = true;
    AppMethodBeat.i(36196);
    if (this.Pyx.getVisibility() == 0) {}
    for (;;)
    {
      Log.d("MicroMsg.ImageGalleryUI", "fadeOutOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      Animation localAnimation = anh(150);
      localAnimation.setFillAfter(false);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(233354);
          if (!ImageGalleryUI.aj(ImageGalleryUI.this)) {
            ImageGalleryUI.this.gSH();
          }
          AppMethodBeat.o(233354);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.Pyx.clearAnimation();
      this.Pyx.startAnimation(localAnimation);
      AppMethodBeat.o(36196);
      return;
      bool = false;
    }
  }
  
  private void ghP()
  {
    AppMethodBeat.i(36207);
    final View localView = getWindow().getDecorView();
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(233356);
        localView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        ImageGalleryUI.an(ImageGalleryUI.this);
        AppMethodBeat.o(233356);
      }
    });
    AppMethodBeat.o(36207);
  }
  
  private void ghQ()
  {
    AppMethodBeat.i(36208);
    final View localView = getWindow().getDecorView();
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(233357);
        localView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i = com.tencent.mm.cb.a.jn(ImageGalleryUI.this);
        int j = com.tencent.mm.cb.a.jo(ImageGalleryUI.this);
        Log.i("MicroMsg.ImageGalleryUI", "handleHorizontalUI width = %d, height = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if ((i <= j) || ((com.tencent.mm.compatible.util.d.oD(24)) && (ImageGalleryUI.this.isInMultiWindowMode())))
        {
          ImageGalleryUI.an(ImageGalleryUI.this);
          AppMethodBeat.o(233357);
          return;
        }
        ImageGalleryUI.ao(ImageGalleryUI.this);
        AppMethodBeat.o(233357);
      }
    });
    AppMethodBeat.o(36208);
  }
  
  protected static com.tencent.mm.av.g k(ca paramca)
  {
    AppMethodBeat.i(258288);
    paramca = d.k(paramca);
    AppMethodBeat.o(258288);
    return paramca;
  }
  
  private static String k(ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(233380);
    if (paramca.field_isSend == 1)
    {
      paramca = com.tencent.mm.model.z.aTY();
      AppMethodBeat.o(233380);
      return paramca;
    }
    if (paramBoolean)
    {
      paramca = bp.Ks(paramca.field_content);
      AppMethodBeat.o(233380);
      return paramca;
    }
    paramca = paramca.field_talker;
    AppMethodBeat.o(233380);
    return paramca;
  }
  
  private void l(ca paramca, boolean paramBoolean)
  {
    int k = 1;
    AppMethodBeat.i(233399);
    if (this.Pyw != b.b.Pxd) {}
    for (int i = 0;; i = 1)
    {
      if ((br.B(paramca)) || (br.J(paramca))) {
        i = 0;
      }
      if ((gMw()) || (gSA())) {
        i = 0;
      }
      paramca = gSt().PyN;
      label83:
      int j;
      if (paramBoolean) {
        if (i != 0) {
          if (paramca.getVisibility() != 0)
          {
            paramBoolean = true;
            B(paramca, paramBoolean);
            j = this.PyC;
            if (i == 0) {
              break label147;
            }
          }
        }
      }
      label147:
      for (i = k;; i = 0)
      {
        this.PyC = (j + i);
        AppMethodBeat.o(233399);
        return;
        paramBoolean = false;
        break;
        C(paramca, true);
        break label83;
        if (i != 0) {}
        for (j = 0;; j = 8)
        {
          aL(paramca, j);
          break;
        }
      }
    }
  }
  
  private void pF(boolean paramBoolean)
  {
    int i = 8;
    AppMethodBeat.i(36178);
    if (this.tmY == null)
    {
      AppMethodBeat.o(36178);
      return;
    }
    if (((paramBoolean) && (this.tmY.getVisibility() == 0)) || ((!paramBoolean) && (this.tmY.getVisibility() == 8)))
    {
      AppMethodBeat.o(36178);
      return;
    }
    Object localObject = this.tmY;
    if (paramBoolean) {
      i = 0;
    }
    ((RelativeLayout)localObject).setVisibility(i);
    localObject = getContext();
    if (paramBoolean) {}
    for (i = 2130771981;; i = 2130771982)
    {
      localObject = AnimationUtils.loadAnimation((Context)localObject, i);
      this.tmY.startAnimation((Animation)localObject);
      AppMethodBeat.o(36178);
      return;
    }
  }
  
  public final int NQ(long paramLong)
  {
    AppMethodBeat.i(36204);
    if (Util.isNullOrNil(this.Pzp))
    {
      AppMethodBeat.o(36204);
      return 0;
    }
    try
    {
      int j = u.g(paramLong, this.Pzp);
      int i = j;
      if (j == -1)
      {
        this.Pzp = null;
        i = 0;
      }
      Log.d("MicroMsg.ImageGalleryUI", "get enter video op code %d %s", new Object[] { Integer.valueOf(i), this.Pzp });
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
  
  public final void NR(long paramLong)
  {
    AppMethodBeat.i(36205);
    if ((Util.isNullOrNil(this.Pzp)) || (paramLong == 0L))
    {
      AppMethodBeat.o(36205);
      return;
    }
    if (this.Pzq)
    {
      this.Pzp = u.f(paramLong, 3);
      Log.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[] { this.Pzp });
      AppMethodBeat.o(36205);
      return;
    }
    if (u.g(paramLong, this.Pzp) == -1)
    {
      this.Pzp = null;
      Log.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[] { this.Pzp });
    }
    AppMethodBeat.o(36205);
  }
  
  public final void and(int paramInt)
  {
    AppMethodBeat.i(36180);
    m(this.Pwu.amt(paramInt), false);
    AppMethodBeat.o(36180);
  }
  
  public final void ang(final int paramInt)
  {
    AppMethodBeat.i(36194);
    if (gSr().FLz == null)
    {
      AppMethodBeat.o(36194);
      return;
    }
    gSr().FLz.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(233353);
        if (ImageGalleryUI.this.Pwu == null)
        {
          AppMethodBeat.o(233353);
          return;
        }
        b localb = ImageGalleryUI.this.Pwu;
        int i = paramInt;
        localb.PwB.pause(i);
        AppMethodBeat.o(233353);
      }
    });
    AppMethodBeat.o(36194);
  }
  
  public final void ani(int paramInt)
  {
    AppMethodBeat.i(36200);
    cWV();
    Cd(false);
    gSq().PyT.setVisibility(0);
    gSq().PyU.setVisibility(8);
    gSq().PyV.setVisibility(0);
    gSq().PyW.setVisibility(8);
    gSq().PyV.setText(paramInt + "%");
    AppMethodBeat.o(36200);
  }
  
  public final void cWV()
  {
    AppMethodBeat.i(36184);
    Log.i("MicroMsg.ImageGalleryUI", "hide video tool bar");
    Cj(false);
    aL(gSr().FLz, 8);
    aL(gSr().JvS, 8);
    aL(this.PyK, 8);
    aL(this.JvM, 8);
    AppMethodBeat.o(36184);
  }
  
  public final boolean dFG()
  {
    AppMethodBeat.i(36193);
    boolean bool = gSr().FLz.cEF();
    AppMethodBeat.o(36193);
    return bool;
  }
  
  protected final void dTH()
  {
    AppMethodBeat.i(233384);
    int i = this.PzE;
    if (this.Pwu == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.ImageGalleryUI", "showMenu mSelectedPos %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      if (this.Pwu != null) {
        break;
      }
      AppMethodBeat.o(233384);
      return;
    }
    if (this.PzE < 0)
    {
      AppMethodBeat.o(233384);
      return;
    }
    if (this.Pwu.amt(this.PzE) == null) {}
    for (final ca localca = this.Pwu.gSg(); localca == null; localca = this.Pwu.amt(this.PzE))
    {
      Log.i("MicroMsg.ImageGalleryUI", "showMenu msg is null");
      AppMethodBeat.o(233384);
      return;
    }
    if (br.D(localca))
    {
      gSB();
      AppMethodBeat.o(233384);
      return;
    }
    i = this.Pwu.PwA.cy(localca);
    if ((i == 5) || (i == 6))
    {
      Log.w("MicroMsg.ImageGalleryUI", "jacks fail downloaded img, return");
      AppMethodBeat.o(233384);
      return;
    }
    Object localObject1 = this.Pwu;
    if (localca != null)
    {
      localObject1 = ((b)localObject1).i(localca, false);
      if (localObject1 != null) {
        if ((localca == null) || (localObject1 == null)) {
          bool = false;
        }
      }
    }
    while (bool)
    {
      Log.w("MicroMsg.ImageGalleryUI", "jacks downloading, return");
      AppMethodBeat.o(233384);
      return;
      if ((q.bcS().a(((com.tencent.mm.av.g)localObject1).localId, localca.field_msgId, 0)) || (b.b(localca, (com.tencent.mm.av.g)localObject1)))
      {
        bool = true;
      }
      else
      {
        bool = false;
        continue;
        localObject1 = j.cF(localca);
        if ((localObject1 != null) && (localObject1 != null))
        {
          i = ((com.tencent.mm.modelvideo.s)localObject1).status;
          int j = u.g((com.tencent.mm.modelvideo.s)localObject1);
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
    if (b.m(localca))
    {
      if ((j.cF(localca) == null) && (!localca.cWK()))
      {
        Log.w("MicroMsg.ImageGalleryUI", "video info is null, return now.");
        AppMethodBeat.o(233384);
        return;
      }
      if (localca.cWK())
      {
        localObject1 = com.tencent.mm.plugin.webview.ui.tools.media.a.JvG;
        com.tencent.mm.plugin.webview.ui.tools.media.a.kr(gSN(), gSM());
      }
    }
    if (this.oXS == null) {
      this.oXS = new com.tencent.mm.ui.widget.a.e(getContext(), 0, true);
    }
    Log.d("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet");
    label543:
    Object localObject2;
    if (this.oXS == null)
    {
      Log.w("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, bottomSheet is null");
      if ((br.B(localca)) && (!gMw()))
      {
        if (gSD()) {
          this.oXS.QNH = new o.f()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
            {
              AppMethodBeat.i(233327);
              paramAnonymousm.b(5, ImageGalleryUI.this.getString(2131757386), 2131690757);
              AppMethodBeat.o(233327);
            }
          };
        }
        this.oXS.HLY = this.rjz;
        this.oXS.QNK = this.rjz;
        this.oXS.QNM = this.rjz;
        this.oXS.PGl = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(233332);
            ImageGalleryUI.T(ImageGalleryUI.this);
            ImageGalleryUI.e(ImageGalleryUI.this).onDismiss();
            Object localObject = ImageGalleryUI.h(ImageGalleryUI.this).PBY;
            if (localObject != null)
            {
              localObject = ((f.c)localObject).PCh;
              if (localObject != null) {
                ((HashMap)localObject).put("1,2", Boolean.FALSE);
              }
            }
            ImageGalleryUI.S(ImageGalleryUI.this).reset();
            AppMethodBeat.o(233332);
          }
        };
        this.oXS.QNO = new e.a()
        {
          public final void onClick()
          {
            AppMethodBeat.i(233335);
            if (ImageGalleryUI.this.Pwu == null)
            {
              AppMethodBeat.o(233335);
              return;
            }
            Object localObject = ImageGalleryUI.this.Pwu.gSg();
            if ((localObject != null) && (((ca)localObject).cWK()))
            {
              localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.JvG;
              com.tencent.mm.plugin.webview.ui.tools.media.a.aN(3, ImageGalleryUI.U(ImageGalleryUI.this), ImageGalleryUI.V(ImageGalleryUI.this));
            }
            AppMethodBeat.o(233335);
          }
        };
        this.oXS.dGm();
        AppMethodBeat.o(233384);
      }
    }
    else
    {
      localObject2 = cVV();
      if (Util.isNullOrNil((String)localObject2))
      {
        if (this.Pwu == null) {
          break label1061;
        }
        localObject1 = this.Pwu.amt(this.PzE);
        if (!b.m((ca)localObject1)) {
          break label1061;
        }
        com.tencent.mm.modelvideo.o.bhj();
      }
    }
    label1061:
    for (localObject1 = com.tencent.mm.modelvideo.t.Qw(((eo)localObject1).field_imgPath);; localObject1 = null)
    {
      localObject2 = Util.nullAsNil((String)localObject1);
      for (localObject1 = com.tencent.mm.plugin.appbrand.openmaterial.model.b.nlO;; localObject1 = com.tencent.mm.plugin.appbrand.openmaterial.model.b.nlN)
      {
        if (!Util.isNullOrNil((String)localObject2)) {
          break label716;
        }
        Log.w("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, curMaterialPath is empty");
        break;
      }
      label716:
      Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, curMaterialPath: %s, scene: %s", new Object[] { localObject2, localObject1 });
      com.tencent.mm.plugin.appbrand.service.i locali = (com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.i.class);
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
      if (((String)localObject2).equals(this.PzB))
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, already fetchOpenMaterials");
        if (this.PzC == null)
        {
          Log.w("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, cachedOpenMaterialCollection is null");
          break;
        }
        localObject2 = this.Pwu.gSe();
        if ((localObject2 == null) || (p.PBM == localObject2)) {
          break;
        }
        if (this.Jgz != null) {
          this.Jgz.dead();
        }
        this.Jgz = locali.a((com.tencent.mm.plugin.appbrand.openmaterial.model.b)localObject1, this, this.oXS, this.PzC, null, gSC());
        break;
      }
      MaterialModel localMaterialModel = MaterialModel.adq((String)localObject2);
      if (localMaterialModel == null)
      {
        Log.w("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, materialModel is null");
        break;
      }
      if (!locali.adl(localMaterialModel.mimeType))
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet, openMaterialService is not support " + localMaterialModel.mimeType);
        break;
      }
      locali.a(localMaterialModel, new a(this, (String)localObject2, locali, (com.tencent.mm.plugin.appbrand.openmaterial.model.b)localObject1));
      break;
      if (br.K(localca))
      {
        AppMethodBeat.o(233384);
        return;
      }
      this.oXS.HLX = new o.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
        {
          AppMethodBeat.i(233329);
          paramAnonymousm.clear();
          if (!br.J(localca))
          {
            paramAnonymousm.a(0, ImageGalleryUI.this.getString(2131764635), 2131690674, ImageGalleryUI.this.getResources().getColor(2131099710));
            if ((localca != null) && (localca.cWK()) && (com.tencent.mm.pluginsdk.ui.tools.z.gsM())) {
              paramAnonymousm.a(10, ImageGalleryUI.this.getString(2131764185), 2131689830, 0);
            }
          }
          if (com.tencent.mm.br.c.aZU("favorite")) {
            paramAnonymousm.a(2, ImageGalleryUI.this.getString(2131763947), 2131689821, 0);
          }
          if ((((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch()) && (b.j(localca)))
          {
            paramAnonymousm.a(11, ImageGalleryUI.this.getString(2131757451), 2131690670, ImageGalleryUI.this.getResources().getColor(2131099818));
            com.tencent.f.h.RTc.aX(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(233328);
                ImageGalleryUI.h(ImageGalleryUI.this).anr(2);
                AppMethodBeat.o(233328);
              }
            });
          }
          AppMethodBeat.o(233329);
        }
      };
      this.oXS.QNH = new o.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
        {
          AppMethodBeat.i(233330);
          paramAnonymousm.clear();
          Object localObject;
          if (!br.J(localca))
          {
            localObject = null;
            if ((!b.j(localca)) && (!b.cp(localca))) {
              break label467;
            }
            localObject = ImageGalleryUI.this.getString(2131764866);
            if (!localca.cWK()) {
              paramAnonymousm.b(1, (CharSequence)localObject, 2131690789);
            }
          }
          if ((b.j(localca)) && (ImageGalleryUI.O(ImageGalleryUI.this))) {
            paramAnonymousm.b(6, ImageGalleryUI.this.getString(2131757388), 2131690881);
          }
          if ((ImageGalleryUI.P(ImageGalleryUI.this)) && (!ImageGalleryUI.Q(ImageGalleryUI.this)) && (!as.bjw(ImageGalleryUI.this.talker))) {
            paramAnonymousm.b(5, ImageGalleryUI.this.getString(2131757386), 2131690757);
          }
          long l;
          if ((ImageGalleryUI.d(ImageGalleryUI.this, 1)) && (!Util.isNullOrNil(ImageGalleryUI.a(ImageGalleryUI.this))))
          {
            paramAnonymousm.b(7, ImageGalleryUI.this.getString(2131757390), 2131690925);
            localObject = new ep();
            if (ImageGalleryUI.q(ImageGalleryUI.this) == 2)
            {
              l = 1L;
              label225:
              ((ep)localObject).erW = l;
              ((ep)localObject).ejA = 2L;
              ((ep)localObject).eDV = 4L;
              com.tencent.mm.av.g localg = ImageGalleryUI.k(ImageGalleryUI.this.Pwu.gSg());
              if (localg != null)
              {
                ((ep)localObject).rK(localg.getFileId());
                ((ep)localObject).rL(localg.getAesKey());
              }
              ((ep)localObject).bfK();
            }
          }
          else if (ImageGalleryUI.R(ImageGalleryUI.this))
          {
            paramAnonymousm.b(12, ImageGalleryUI.this.getString(2131757387), 2131690856);
            boolean bool = ab.Eq(localca.field_talker);
            localObject = ImageGalleryUI.S(ImageGalleryUI.this);
            if (!bool) {
              break label530;
            }
          }
          label530:
          for (int i = 2;; i = 1)
          {
            ((com.tencent.mm.plugin.scanner.api.a.b)localObject).hY(2, i);
            if ((b.j(localca)) || (b.cn(localca)))
            {
              localObject = new ef();
              ((ef)localObject).dHy.msgId = localca.field_msgId;
              EventCenter.instance.publish((IEvent)localObject);
              if ((((ef)localObject).dHz.dGX) || (com.tencent.mm.pluginsdk.model.app.h.ay(ImageGalleryUI.this.getContext(), localca.getType()))) {
                paramAnonymousm.b(4, ImageGalleryUI.this.getString(2131757440), 2131690860);
              }
            }
            AppMethodBeat.o(233330);
            return;
            label467:
            if ((b.m(localca)) || (b.cn(localca)))
            {
              if (localca.cWK()) {
                break;
              }
              localObject = ImageGalleryUI.this.getString(2131764871);
              break;
            }
            localObject = ImageGalleryUI.this.getString(2131764870);
            break;
            l = 0L;
            break label225;
          }
        }
      };
      this.oXS.QNJ = new ImageGalleryUI.21(this);
      break label543;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(36195);
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
    {
      if (this.oXS != null)
      {
        this.oXS.bMo();
        this.oXS = null;
      }
      for (;;)
      {
        AppMethodBeat.o(36195);
        return true;
        if ((this.tgN == 0) || (this.tgN == 2)) {
          dTH();
        } else {
          dTH();
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
    this.Poq.clear();
    super.finish();
    AppMethodBeat.o(36203);
  }
  
  public final void gSF()
  {
    AppMethodBeat.i(258287);
    Cd(false);
    AppMethodBeat.o(258287);
  }
  
  public final void gSG()
  {
    AppMethodBeat.i(36175);
    if (BuildInfo.IS_FLAVOR_RED) {
      Log.d("MicroMsg.ImageGalleryUI", "hideOpLayer isShowOpToolbar: %b, %s", new Object[] { Boolean.valueOf(this.PzM), Util.getStack() });
    }
    if (!this.PzM)
    {
      AppMethodBeat.o(36175);
      return;
    }
    this.PzM = false;
    ghN();
    AppMethodBeat.o(36175);
  }
  
  public final void gSH()
  {
    AppMethodBeat.i(36176);
    this.tnh.stopTimer();
    this.PyM.setVisibility(8);
    gSs().PyL.clearAnimation();
    aL(gSs().PyL, 8);
    aL(gSt().PyN, 8);
    this.PyO.setVisibility(8);
    aL(gSu().PyP, 8);
    aL(gSw().PyR, 8);
    aL(gSx().PyS, 8);
    cWV();
    pF(false);
    Ci(false);
    this.Pyx.setVisibility(8);
    AppMethodBeat.o(36176);
  }
  
  protected final void gSQ()
  {
    AppMethodBeat.i(36182);
    if (this.PzM)
    {
      if (gSO())
      {
        this.tnh.startTimer(3000L);
        AppMethodBeat.o(36182);
        return;
      }
      this.tnh.startTimer(5000L);
    }
    AppMethodBeat.o(36182);
  }
  
  public final void gST()
  {
    AppMethodBeat.i(36201);
    cWV();
    gSq().PyT.setVisibility(0);
    gSq().PyU.setVisibility(8);
    gSq().PyV.setVisibility(0);
    gSq().PyW.setVisibility(8);
    gSq().PyV.setText("0%");
    AppMethodBeat.o(36201);
  }
  
  final ImageGalleryUI gSq()
  {
    AppMethodBeat.i(36152);
    if (this.PyT == null)
    {
      this.PyT = findViewById(2131302560);
      this.PyU = ((Button)this.PyT.findViewById(2131299351));
      this.PyV = ((Button)this.PyT.findViewById(2131299352));
      this.PyW = this.PyT.findViewById(2131299353);
      TextView localTextView = (TextView)this.PyT.findViewById(2131299347);
      this.PyU.getPaint().setFakeBoldText(true);
      this.PyV.getPaint().setFakeBoldText(true);
      localTextView.getPaint().setFakeBoldText(true);
      float f = Math.min(1.125F, com.tencent.mm.cb.a.ez(this));
      this.PyU.setTextSize(1, 12.0F * f);
      this.PyV.setTextSize(1, f * 12.0F);
    }
    AppMethodBeat.o(36152);
    return this;
  }
  
  protected final ImageGalleryUI gSr()
  {
    AppMethodBeat.i(36153);
    if (this.FLz == null)
    {
      this.FLz = ((RedesignVideoPlayerSeekBar)findViewById(2131309804));
      this.JvS = findViewById(2131309282);
      this.FLz.setPlayBtnOnClickListener(this);
    }
    AppMethodBeat.o(36153);
    return this;
  }
  
  public final int getCurrentItem()
  {
    AppMethodBeat.i(258289);
    int i = this.xqs.getCurrentItem();
    AppMethodBeat.o(258289);
    return i;
  }
  
  public int getForceOrientation()
  {
    return 2;
  }
  
  public int getLayoutId()
  {
    return 2131495049;
  }
  
  public void initView()
  {
    AppMethodBeat.i(36163);
    this.qaE = new com.tencent.mm.ui.tools.e(getContext());
    this.isAnimated = false;
    this.talker = getIntent().getStringExtra("img_gallery_talker");
    this.Pzj = getIntent().getBooleanExtra("img_gallery_enter_from_grid", false);
    this.Ptr = getIntent().getBooleanExtra("img_gallery_enter_from_chatting_ui", false);
    this.Pzl = getIntent().getBooleanExtra("img_gallery_enter_from_appbrand_service_chatting_ui", false);
    this.Ptq = getIntent().getBooleanExtra("show_search_chat_content_result", false);
    this.Pzi = getIntent().getBooleanExtra("show_enter_grid", true);
    this.tca = getIntent().getBooleanExtra("key_is_biz_chat", false);
    this.ppv = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.Pyy = getIntent().getBooleanExtra("img_preview_only", false);
    this.Pzn = getIntent().getIntExtra("img_gallery_enter_from_scene", 0);
    this.Pdu = getIntent().getIntExtra("msg_type", 0);
    if ((!this.Pyy) && (Util.isNullOrNil(this.talker))) {
      Log.e("MicroMsg.ImageGalleryUI", " initView, talker is null. intent: " + getIntent());
    }
    this.chatroomName = getIntent().getStringExtra("img_gallery_chatroom_name");
    this.Pzk = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
    this.Pzp = getIntent().getStringExtra("img_gallery_enter_video_opcode");
    boolean bool2 = getIntent().getBooleanExtra("img_gallery_is_restransmit_after_download", false);
    Object localObject2 = getIntent().getStringExtra("img_gallery_directly_send_name");
    this.tgQ = ((ImageView)findViewById(2131307274));
    this.tgR = ((ImageView)findViewById(2131307272));
    Object localObject1 = (FrameLayout.LayoutParams)this.tgR.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject1).bottomMargin += au.aD(this);
    this.tgR.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.tgR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(233303);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ImageGalleryUI.t(ImageGalleryUI.this);
        paramAnonymousView = new ay();
        paramAnonymousView.dEa.scene = 1;
        paramAnonymousView.dEa.dEb = ImageGalleryUI.u(ImageGalleryUI.this);
        EventCenter.instance.publish(paramAnonymousView);
        ImageGalleryUI.r(ImageGalleryUI.this);
        ImageGalleryUI.v(ImageGalleryUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(233303);
      }
    });
    this.tgP = ((ImageView)findViewById(2131307275));
    this.tgS = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.tgS.setDuration(5000L);
    this.tgS.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(233313);
        ImageGalleryUI.E(ImageGalleryUI.this).setAlpha(0.0F);
        AppMethodBeat.o(233313);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(233312);
        ImageGalleryUI.E(ImageGalleryUI.this).setAlpha(0.0F);
        AppMethodBeat.o(233312);
      }
    });
    final int i = getWindowManager().getDefaultDisplay().getHeight();
    this.tgS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(233315);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f <= 0.1F) {
          ImageGalleryUI.E(ImageGalleryUI.this).setAlpha(f * 10.0F);
        }
        for (;;)
        {
          ImageGalleryUI.E(ImageGalleryUI.this).setTranslationY(f * (i - ImageGalleryUI.E(ImageGalleryUI.this).getHeight()));
          AppMethodBeat.o(233315);
          return;
          if (f >= 0.9F) {
            ImageGalleryUI.E(ImageGalleryUI.this).setAlpha((1.0F - f) * 10.0F);
          }
        }
      }
    });
    this.msgId = getIntent().getLongExtra("img_gallery_msg_id", 0L);
    this.PwE = getIntent().getBooleanExtra("img_gallery_is_mp_video_without_msg", false);
    this.Pzm = getIntent().getIntExtra("img_gallery_mp_video_click_from", 2);
    long l = getIntent().getLongExtra("img_gallery_msg_svr_id", 0L);
    if (!this.PwE)
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
        bg.aVF();
        this.msgId = com.tencent.mm.model.c.aSQ().aJ(gSz(), l).field_msgId;
      }
      bg.aVF();
      localObject1 = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
      if (((eo)localObject1).field_msgId <= 0L)
      {
        Log.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.msgId + ", msgSvrId = " + l + ", stack = " + Util.getStack());
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
      if (NQ(this.msgId) == 3)
      {
        bool1 = true;
        this.Pzq = bool1;
        if (com.tencent.mm.q.a.aty()) {
          this.Pzq = true;
        }
        this.Pwu = new b(this, this.msgId, gSz(), this.tca, this.ppv, bool2, (String)localObject2, Boolean.valueOf(this.Pzk), this.Pdu);
        this.Pwu.PwF = false;
        this.Pwu.Pwy = getIntent().getBooleanExtra("start_chatting_ui", true);
        this.Pwu.PwD = new b.c()
        {
          public final void tf()
          {
            AppMethodBeat.i(233304);
            if (ImageGalleryUI.this.Pwu == null)
            {
              AppMethodBeat.o(233304);
              return;
            }
            ImageGalleryUI.this.gSF();
            ImageGalleryUI.w(ImageGalleryUI.this);
            ImageGalleryUI.this.Pwu.onPageSelected(b.a.PwO);
            AppMethodBeat.o(233304);
          }
        };
        localObject2 = this.Pwu;
        n localn = this.PxO;
        if (((b)localObject2).PwA != null) {
          ((b)localObject2).PwA.PxO = localn;
        }
        com.tencent.mm.ui.chatting.gallery.a.e.init();
        if (this.Pyy) {
          break label1537;
        }
        bool1 = true;
        label896:
        this.Pzd = new com.tencent.mm.ui.chatting.gallery.a.j(this, bool1);
        this.Pze = new com.tencent.mm.ui.chatting.gallery.a.g();
        if ((!com.tencent.mm.ui.chatting.gallery.a.e.gTr()) || (!gSK())) {
          break label1542;
        }
        bool1 = true;
        label935:
        this.Pzc = bool1;
        Log.i("MicroMsg.ImageGalleryUI", "initScanCode isPreviewOnly: %b, canShowScanCodeButton: %b, isEnterFromChattingUI: %b, isEnterFromGrid: %b", new Object[] { Boolean.valueOf(this.Pyy), Boolean.valueOf(this.Pzc), Boolean.valueOf(this.Ptr), Boolean.valueOf(this.Pzj) });
        this.PyC = 0;
        this.PyD = getResources().getDimensionPixelSize(2131166057);
        this.PyE = getResources().getDimensionPixelSize(2131166056);
        this.tmY = ((RelativeLayout)findViewById(2131299350));
        this.Pyx = ((RelativeLayout)findViewById(2131299355));
        this.tmY.setOnClickListener(new ImageGalleryUI.5(this));
        this.PyK = findViewById(2131309735);
        this.PyK.setOnClickListener(this);
        this.PyM = findViewById(2131309802);
        this.PyO = findViewById(2131301864);
        if (!bq(this)) {
          break label1547;
        }
        ghP();
        label1122:
        this.jUG = ((ImageView)findViewById(2131301854));
        this.xqs = ((MMViewPager)findViewById(2131301853));
        this.xqs.setVerticalFadingEdgeEnabled(false);
        this.xqs.setHorizontalFadingEdgeEnabled(false);
        this.xqs.setSingleClickOverListener(new MMViewPager.f()
        {
          public final void bmt()
          {
            AppMethodBeat.i(233306);
            if (ImageGalleryUI.x(ImageGalleryUI.this)) {
              ImageGalleryUI.y(ImageGalleryUI.this);
            }
            AppMethodBeat.o(233306);
          }
          
          public final void dSr()
          {
            AppMethodBeat.i(233307);
            ImageGalleryUI.z(ImageGalleryUI.this);
            AppMethodBeat.o(233307);
          }
        });
        this.xqs.setDoubleClickListener(new MMViewPager.a()
        {
          public final boolean ab(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(233308);
            if (ImageGalleryUI.A(ImageGalleryUI.this) != null)
            {
              boolean bool = ImageGalleryUI.A(ImageGalleryUI.this).onDoubleTap(paramAnonymousMotionEvent);
              AppMethodBeat.o(233308);
              return bool;
            }
            AppMethodBeat.o(233308);
            return false;
          }
        });
        if (!gSA()) {
          break label1554;
        }
        gSH();
        this.jUG.setVisibility(8);
        label1216:
        this.xqs.setOffscreenPageLimit(1);
        this.xqs.setAdapter(this.Pwu);
        and(b.a.PwO);
        this.xqs.setCurrentItem(b.a.PwO);
        this.xqs.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(233310);
            if (ImageGalleryUI.this.Pwu == null)
            {
              AppMethodBeat.o(233310);
              return;
            }
            if ((h.a.gSp().tku) && (ImageGalleryUI.C(ImageGalleryUI.this) != null))
            {
              ImageGalleryUI.C(ImageGalleryUI.this).setChecked(h.a.gSp().cE(ImageGalleryUI.this.Pwu.gSg()));
              ImageGalleryUI.D(ImageGalleryUI.this).setOnClickListener(ImageGalleryUI.this);
            }
            int i = b.a.PwO;
            if (ImageGalleryUI.this.xqs.getCurrentItem() != i)
            {
              AppMethodBeat.o(233310);
              return;
            }
            ImageGalleryUI.this.gSQ();
            b.b localb = b.cr(ImageGalleryUI.this.Pwu.amt(i));
            if ((!ImageGalleryUI.this.Pzk) && (localb == b.b.Pxe)) {
              ImageGalleryUI.this.Pwu.amS(i);
            }
            if (localb == b.b.Pxf) {
              ImageGalleryUI.this.Pwu.amW(i);
            }
            AppMethodBeat.o(233310);
          }
        }, 0L);
        if (h.a.gSp().tku)
        {
          this.Pzx = ((ViewStub)findViewById(2131307570)).inflate();
          this.Pzx.setVisibility(0);
          this.Pzy = ((CheckBox)this.Pzx.findViewById(2131304550));
          this.Pzz = this.Pzx.findViewById(2131304551);
        }
        this.PyZ = getIntent().getBooleanExtra("img_gallery_enter_PhotoEditUI", false);
        localObject1 = this.Pwu.i((ca)localObject1, true);
        if (localObject1 == null) {
          Log.e("MicroMsg.ImageGalleryUI", "[initView] imgInfo is null!!! isSoonEnterPhotoEdit:%s", new Object[] { Boolean.valueOf(this.PyZ) });
        }
        if ((!this.PyZ) || (localObject1 == null) || (!((com.tencent.mm.av.g)localObject1).bcu())) {
          break label1597;
        }
        gSV();
        this.PyZ = false;
      }
      for (;;)
      {
        this.xqs.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(233311);
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(233311);
              return false;
              paramAnonymousView = ad.aVe().G("basescanui@datacenter", true);
              PointF localPointF = com.tencent.mm.plugin.scanner.util.m.e(ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.Pwu, ImageGalleryUI.this.xqs), paramAnonymousMotionEvent.getRawX(), paramAnonymousMotionEvent.getRawY());
              if (localPointF != null)
              {
                paramAnonymousView.l("key_basescanui_touch_normalize_x", Float.valueOf(localPointF.x));
                paramAnonymousView.l("key_basescanui_touch_normalize_y", Float.valueOf(localPointF.y));
              }
              else
              {
                Log.e("MicroMsg.ImageGalleryUI", "alvinluo get touchCoordinate is invalid");
                paramAnonymousView.l("key_basescanui_screen_position", Boolean.TRUE);
                paramAnonymousView.l("key_basescanui_screen_x", Float.valueOf(paramAnonymousMotionEvent.getRawX()));
                paramAnonymousView.l("key_basescanui_screen_y", Float.valueOf(paramAnonymousMotionEvent.getRawY()));
              }
            }
          }
        });
        if ((gMw()) || (gSA()))
        {
          this.PyM.setVisibility(8);
          aL(gSs().PyL, 8);
          aL(gSt().PyN, 8);
          aL(this.PyO, 8);
          aL(gSu().PyP, 8);
          aL(gSw().PyR, 8);
          aL(gSx().PyS, 8);
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
        ghQ();
        break label1122;
        label1554:
        if (!this.Pyy)
        {
          this.xqs.setOnPageChangeListener(this.PzH);
          this.xqs.setLongClickOverListener(new MMViewPager.d()
          {
            public final void bmu()
            {
              AppMethodBeat.i(233309);
              if ((ImageGalleryUI.A(ImageGalleryUI.this) != null) && (ImageGalleryUI.A(ImageGalleryUI.this).eOV()))
              {
                AppMethodBeat.o(233309);
                return;
              }
              if (ImageGalleryUI.q(ImageGalleryUI.this) == 1)
              {
                AppMethodBeat.o(233309);
                return;
              }
              ImageGalleryUI.B(ImageGalleryUI.this);
              Object localObject;
              if ((ImageGalleryUI.q(ImageGalleryUI.this) == 0) || (ImageGalleryUI.q(ImageGalleryUI.this) == 2))
              {
                localObject = new ep();
                if (ImageGalleryUI.q(ImageGalleryUI.this) != 2) {
                  break label205;
                }
              }
              label205:
              for (long l = 1L;; l = 0L)
              {
                ((ep)localObject).erW = l;
                ((ep)localObject).ejA = 1L;
                ((ep)localObject).eDV = 4L;
                com.tencent.mm.av.g localg = ImageGalleryUI.k(ImageGalleryUI.this.Pwu.gSg());
                if (localg != null)
                {
                  ((ep)localObject).rK(localg.getFileId());
                  ((ep)localObject).rL(localg.getAesKey());
                }
                ((ep)localObject).bfK();
                localObject = ImageGalleryUI.a(ImageGalleryUI.this);
                ImageGalleryUI.a(ImageGalleryUI.this, com.tencent.mm.vfs.s.k((String)localObject, false), ImageGalleryUI.l(ImageGalleryUI.this));
                ImageGalleryUI.this.dTH();
                AppMethodBeat.o(233309);
                return;
              }
            }
          });
          break label1216;
        }
        gSH();
        break label1216;
        label1597:
        if (this.PyZ) {
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
        AppMethodBeat.i(233407);
        if ((paramca == null) || (!paramca.cWK()))
        {
          if (this.JvM != null) {
            this.JvM.setVisibility(8);
          }
          this.Pyw = b.cr(paramca);
          Log.i("MicroMsg.ImageGalleryUI", "updateFooterInfo currGalleryType: %s, pageChanged: %b", new Object[] { this.Pyw, Boolean.valueOf(paramBoolean) });
          if ((h.a.gSp().tku) && (this.Pzy != null)) {
            this.Pzy.setChecked(h.a.gSp().cE(paramca));
          }
        }
        switch (41.PwJ[this.Pyw.ordinal()])
        {
        case 1: 
          Cd(paramBoolean);
          AppMethodBeat.o(233407);
          return;
          if (this.JvM == null)
          {
            this.JvM = ((ViewStub)findViewById(2131301861)).inflate();
            this.tFX = findViewById(2131304926);
            this.gyr = ((ImageView)findViewById(2131304925));
            this.PzK = ((ImageView)findViewById(2131304938));
            this.pIN = ((TextView)findViewById(2131304936));
            this.pIO = ((MMNeat7extView)findViewById(2131304941));
            this.PzI = ((TextView)findViewById(2131304943));
            this.pIN.getPaint().setFakeBoldText(true);
            this.PzI.getPaint().setFakeBoldText(true);
            this.pIO.getPaint().setFakeBoldText(true);
            this.PzJ = findViewById(2131304942);
            this.JvM.setOnClickListener(new ImageGalleryUI.30(this));
          }
          boolean bool = au.aA(this);
          i = au.aD(this);
          if ((this.zss) && (bool))
          {
            if (bq(this)) {
              gSU();
            }
          }
          else
          {
            localObject1 = j.cG(paramca);
            if (localObject1 != null) {
              break label389;
            }
            Log.w("MicroMsg.ImageGalleryUI", "fillMpVideoInfoLayout mpShareVideoInfo is null");
            continue;
          }
          anj(i);
        }
      }
      finally {}
      continue;
      this.pIO.aw(((y)localObject1).title);
      localObject2 = new k.b();
      ((k.b)localObject2).eah = ((y)localObject1).iAg;
      ((k.b)localObject2).eag = ((y)localObject1).dHc;
      al.a(this, (k.b)localObject2, this.gyr, this.pIN);
      this.tFX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(233346);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if ((this.PzY == null) || (Util.isNullOrNil(this.PzY.dHc)))
          {
            Log.w("MicroMsg.ImageGalleryUI", "srcUserName is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(233346);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", this.PzY.dHc);
          paramAnonymousView.putExtra("Contact_Scene", 163);
          paramAnonymousView.putExtra("force_get_contact", true);
          paramAnonymousView.putExtra("key_use_new_contact_profile", true);
          com.tencent.mm.br.c.b(ImageGalleryUI.this.Pwu.Pwv, "profile", ".ui.ContactInfoUI", paramAnonymousView);
          com.tencent.mm.plugin.report.service.h.CyF.a(18589, new Object[] { Integer.valueOf(1), Integer.valueOf(ImageGalleryUI.V(ImageGalleryUI.this)) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(233346);
        }
      });
      this.PzJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(233347);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = new Intent();
          int i = ImageGalleryUI.this.getIntent().getIntExtra("KOpenArticleSceneFromScene", 1);
          paramAnonymousView.putExtra("srcUsername", this.PzY.dHc);
          paramAnonymousView.putExtra("srcDisplayname", this.PzY.iAg);
          localObject = com.tencent.mm.ag.m.d(this.PzY.KOe, 139, i, (int)(System.currentTimeMillis() / 1000L));
          if (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(ImageGalleryUI.this, (String)localObject, -1, 139, i, paramAnonymousView))
          {
            paramAnonymousView.putExtra("rawUrl", (String)localObject);
            com.tencent.mm.br.c.b(ImageGalleryUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(18589, new Object[] { Integer.valueOf(15), Integer.valueOf(ImageGalleryUI.V(ImageGalleryUI.this)) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(233347);
        }
      });
      com.tencent.mm.ui.tools.o.hq(this.tFX);
      com.tencent.mm.ui.tools.o.hq(this.PzJ);
      if (((y)localObject1).KOe != null)
      {
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(((y)localObject1).KOe, -1, 2, new Object[0]);
        this.PzJ.setVisibility(0);
      }
      for (;;)
      {
        localObject1 = (LinearLayout.LayoutParams)this.PzK.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).height = ((int)(this.PzI.getTextSize() * 1.45D));
        ((LinearLayout.LayoutParams)localObject1).width = ((LinearLayout.LayoutParams)localObject1).height;
        this.PzK.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (!this.PwE) {
          break;
        }
        Cd(false);
        cWW();
        break;
        this.PzJ.setVisibility(8);
      }
      aL(this.PyT, 4);
      setVideoStateIv(true);
      paramca = j.cF(paramca);
      if (paramca != null) {
        break;
      }
      AppMethodBeat.o(233407);
    }
    gSr().FLz.setVideoTotalTime(paramca.iFw);
    for (;;)
    {
      try
      {
        if ((this.Pwu.gSh() == null) || (this.Pwu.gSh().PAO == null)) {
          break label1003;
        }
        i = this.Pwu.gSh().PAO.getCurrentPosition() / 1000;
        gSr().FLz.seek(i);
      }
      catch (Exception paramca)
      {
        Log.printErrStackTrace("MicroMsg.ImageGalleryUI", paramca, "", new Object[0]);
        break label1003;
      }
      localObject1 = this.Pwu.i(paramca, false);
      cWV();
      Cd(paramBoolean);
      if (localObject1 == null)
      {
        Log.w("MicroMsg.ImageGalleryUI", "updateFooterInfo img info is null");
        AppMethodBeat.o(233407);
        break label151;
      }
      if ((this.PyZ) && (((com.tencent.mm.av.g)localObject1).bcu()) && (this.Pwu.gSg() != null) && (paramca.field_msgId == this.Pwu.gSg().field_msgId))
      {
        Log.i("MicroMsg.ImageGalleryUI", "get image successfully! -> gotoPhotoEditUI msgId:%s", new Object[] { Long.valueOf(paramca.field_msgId) });
        gSV();
        this.PyZ = false;
        AppMethodBeat.o(233407);
        break label151;
      }
      localObject2 = this.Pwu.gSg();
      paramBoolean = this.PyZ;
      long l = paramca.field_msgId;
      if (localObject2 == null) {}
      for (paramca = "null";; paramca = Long.valueOf(((eo)localObject2).field_msgId))
      {
        Log.w("MicroMsg.ImageGalleryUI", "isSoonEnterPhotoEdit:%s msgId:%s curMsgId:%s getCompleted:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l), paramca, Boolean.valueOf(((com.tencent.mm.av.g)localObject1).bcu()) });
        AppMethodBeat.o(233407);
        break;
      }
      cWV();
      break;
      cWV();
      Cd(paramBoolean);
      aL(this.PyT, 4);
      this.Pwu.amW(this.xqs.getCurrentItem());
      AppMethodBeat.o(233407);
      break label151;
      break;
      label1003:
      i = 0;
    }
  }
  
  public boolean noActionBar()
  {
    AppMethodBeat.i(233375);
    if (!gSA())
    {
      AppMethodBeat.o(233375);
      return true;
    }
    AppMethodBeat.o(233375);
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(36173);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.JjJ != null) && (this.JjJ.d(this, paramInt1, paramInt2, paramIntent)))
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
    if (fhB())
    {
      AppMethodBeat.o(36161);
      return;
    }
    if (this.Pzj)
    {
      anf(1);
      AppMethodBeat.o(36161);
      return;
    }
    try
    {
      h.a.gSp().detach();
      cvQ();
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
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if (this.Pwu == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131300134) {
      anf(0);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36191);
      return;
      if (paramView.getId() == 2131309802)
      {
        this.Pyz = false;
        dTH();
        if ((anc(2)) && (bmX(this.Pzb.CFJ))) {
          this.Pzr.cl(this.Pzb.dFL, this.Pzb.CFJ);
        }
      }
      else if (paramView.getId() == 2131299750)
      {
        Log.i("MicroMsg.ImageGalleryUI", "[oreh download_and_save] hdImg suc, curPos:%d", new Object[] { Integer.valueOf(this.xqs.getCurrentItem()) });
        paramView = this.Pwu.amt(this.xqs.getCurrentItem());
        localObject = this.Pwu.i(paramView, false);
        this.xqs.getCurrentItem();
        if ((f(paramView, (com.tencent.mm.av.g)localObject)) && (!paramView.gDB()) && (((com.tencent.mm.av.g)localObject).bcu())) {
          this.Pwu.bH(this.xqs.getCurrentItem(), true);
        } else {
          b.c(getContext(), this.Pwu.gSg(), true);
        }
      }
      else if (paramView.getId() == 2131299351)
      {
        this.tgN = 2;
        this.tgM = 0;
        this.Pwu.bH(this.xqs.getCurrentItem(), false);
      }
      else if (paramView.getId() == 2131299352)
      {
        this.Pwu.amV(this.xqs.getCurrentItem());
        and(this.xqs.getCurrentItem());
      }
      else if (paramView.getId() == 2131296448)
      {
        onBackPressed();
      }
      else if (paramView.getId() == 2131309735)
      {
        onBackPressed();
      }
      else if (paramView.getId() == 2131304551)
      {
        boolean bool = this.Pzy.isChecked();
        if ((!bool) && (h.a.gSp().tkt.size() >= 9))
        {
          Toast.makeText(this, getResources().getString(2131761131, new Object[] { Integer.valueOf(9) }), 1).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36191);
          return;
        }
        paramView = this.Pzy;
        if (!bool) {}
        for (bool = true;; bool = false)
        {
          paramView.setChecked(bool);
          if (!this.Pzy.isChecked()) {
            break label545;
          }
          h.a.gSp().cC(this.Pwu.gSg());
          break;
        }
        label545:
        h.a.gSp().cD(this.Pwu.gSg());
      }
      else if (paramView.getId() == 2131305954)
      {
        this.Pwu.gSh();
        this.Pwu.amS(this.xqs.getCurrentItem());
      }
      else if (paramView.getId() == 2131301864)
      {
        if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(getContext()))
        {
          this.Pzs.anp(3);
          BZ(true);
        }
      }
      else if (paramView.getId() == 2131301862)
      {
        gSu().PyP.setOnClickListener(null);
        this.Pzs.anp(2);
        BY(true);
      }
      else if (paramView.getId() == 2131301863)
      {
        gSw().PyR.setOnClickListener(null);
        aq(System.currentTimeMillis(), 3);
      }
      else if (paramView.getId() == 2131307393)
      {
        gSx().PyS.setBubbleClickListener(null);
        aq(System.currentTimeMillis(), 4);
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(36206);
    super.onConfigurationChanged(paramConfiguration);
    if (this.EAm != null) {
      this.EAm.onConfigurationChanged(paramConfiguration);
    }
    if (paramConfiguration.orientation == 1)
    {
      Log.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is vertical screen", new Object[] { Integer.valueOf(hashCode()) });
      this.PyH = true;
      ghP();
      AppMethodBeat.o(36206);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      Log.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is horizontal screen", new Object[] { Integer.valueOf(hashCode()) });
      this.PyH = true;
      ghQ();
      AppMethodBeat.o(36206);
      return;
    }
    AppMethodBeat.o(36206);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(36157);
    requestWindowFeature(1);
    com.tencent.mm.ui.ao.bm(this);
    if (gSA()) {
      setTheme(2131821161);
    }
    long l = System.currentTimeMillis();
    this.PzA = true;
    super.onCreate(paramBundle);
    if (gSA())
    {
      setMMTitle("");
      addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(233366);
          ImageGalleryUI.s(ImageGalleryUI.this);
          AppMethodBeat.o(233366);
          return true;
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(233367);
          ImageGalleryUI.this.finish();
          AppMethodBeat.o(233367);
          return true;
        }
      });
      initView();
      if (this.Pwu != null)
      {
        com.tencent.mm.av.g localg = d.k(this.Pwu.gSg());
        this.Pzs.b(1, localg);
      }
      this.qaD = paramBundle;
      EventCenter.instance.addListener(this.tgT);
      this.FLK = false;
      this.Pzr = new ScanCodeSheetItemLogic(this, new ImageGalleryUI.2(this));
      Log.d("MicroMsg.ImageGalleryUI", "ImageGallery onCreate spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(36157);
      return;
    }
    if (com.tencent.mm.compatible.util.d.oD(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (this.zss = true;; this.zss = false)
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
      if (this.Pwu != null)
      {
        ane(this.PzE);
        this.PyB.a(this, this.PzE, 0);
        this.Pwu.detach();
        this.Pwu = null;
      }
      this.tnh.stopTimer();
      Cc(false);
      this.tgS.removeAllUpdateListeners();
      EventCenter.instance.removeListener(this.tgT);
      com.tencent.mm.kernel.g.aAg().b(this.tgU);
      Object localObject1 = new rl();
      ((rl)localObject1).dYc.activity = this;
      EventCenter.instance.publish((IEvent)localObject1);
      if (this.FLz != null) {
        this.FLz.setPlayBtnOnClickListener(null);
      }
      this.FLz = null;
      gSy();
      if (this.Pzd != null)
      {
        localObject1 = this.Pzd;
        if (((com.tencent.mm.ui.chatting.gallery.a.j)localObject1).PCs)
        {
          ((com.tencent.mm.ui.chatting.gallery.a.j)localObject1).PCy.dead();
          ((com.tencent.mm.ui.chatting.gallery.a.j)localObject1).PCz.dead();
          ((com.tencent.mm.ui.chatting.gallery.a.j)localObject1).PCA.dead();
        }
        localObject2 = ((com.tencent.mm.ui.chatting.gallery.a.j)localObject1).PCt.keySet();
        kotlin.g.b.p.g(localObject2, "scanCodeRequestMap.keys");
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            Object localObject5 = (String)((Iterator)localObject2).next();
            localObject3 = (j.b)((com.tencent.mm.ui.chatting.gallery.a.j)localObject1).PCt.get(localObject5);
            localObject4 = new ax();
            ((ax)localObject4).dDY.filePath = ((String)localObject5);
            localObject5 = ((ax)localObject4).dDY;
            if (localObject3 != null)
            {
              l = ((j.b)localObject3).dDZ;
              ((ax.a)localObject5).dDZ = l;
              EventCenter.instance.publish((IEvent)localObject4);
              continue;
              if (!com.tencent.mm.graphics.b.c.hke.hki) {
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
      com.tencent.mm.graphics.b.c.hke.stop();
      super.onDestroy();
      AppMethodBeat.o(36160);
      return;
      l = 0L;
      break;
      localException.PCt.clear();
      localException.PCu.clear();
      localException.PCv.clear();
      Log.v("MicroMsg.ImageScanCodeManager", "releaseHandleCode");
      localObject2 = localException.PCw.keySet();
      kotlin.g.b.p.g(localObject2, "handleCodeRequestMap.keys");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = new aw();
        ((aw)localObject4).dDW.activity = localException.dKq;
        ((aw)localObject4).dDW.dDX = ((String)localObject3);
        EventCenter.instance.publish((IEvent)localObject4);
      }
      localException.PCx.clear();
      if (this.Pzh != null)
      {
        com.tencent.mm.ui.chatting.gallery.a.l locall = this.Pzh;
        Log.d("MicroMsg.ImageSearchPreviewManager", "alvinluo release previewImage session size: %d", new Object[] { Integer.valueOf(locall.PCJ.size()) });
        localObject2 = ((Map)locall.PCL).entrySet().iterator();
        while (((Iterator)localObject2).hasNext()) {
          com.tencent.mm.ui.chatting.gallery.a.l.Is(((Number)((Map.Entry)((Iterator)localObject2).next()).getKey()).longValue());
        }
        locall.PCK.clear();
        locall.PCJ.clear();
      }
      if (this.EAm != null) {
        this.EAm.release();
      }
      com.tencent.mm.ui.chatting.gallery.a.m.release();
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
    if ((!gSA()) && (Build.VERSION.SDK_INT >= 21)) {
      getWindow().setFlags(2048, 2048);
    }
    if ((!isFinishing()) && (this.Pwu != null))
    {
      b localb = this.Pwu;
      localb.PwB.PAq.sendEmptyMessageDelayed(1, 200L);
      localb.PwC.stopAll();
    }
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    gSx().PyS.setBubbleClickListener(this);
    gSw().PyR.setOnClickListener(this);
    AppMethodBeat.o(36150);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(36158);
    super.onResume();
    if (this.Pwu != null) {
      if (!this.Pwu.PwE) {
        break label125;
      }
    }
    label125:
    for (int i = 0;; i = 100000)
    {
      b.a.PwO = i;
      if ((!gSA()) && (Build.VERSION.SDK_INT >= 21)) {
        getWindow().clearFlags(2048);
      }
      if ((!this.PzA) && (this.Pwu != null)) {
        and(this.xqs.getCurrentItem());
      }
      this.PzA = false;
      if (this.Pwu != null) {
        this.Pwu.gSi();
      }
      com.tencent.mm.kernel.g.aAg().a(this.tgU);
      com.tencent.mm.plugin.ball.f.f.e(true, true, true);
      AppMethodBeat.o(36158);
      return;
    }
  }
  
  public void onStart()
  {
    boolean bool = true;
    AppMethodBeat.i(36159);
    this.Pzk = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
    Bundle localBundle;
    if ((!this.Pyy) && (!gSA()))
    {
      localBundle = this.qaD;
      Log.i("MicroMsg.ImageGalleryUI", "[handleAnimation] isAnimated:" + this.isAnimated);
      if (!this.isAnimated)
      {
        this.isAnimated = true;
        if (Build.VERSION.SDK_INT >= 12)
        {
          this.qaF = getIntent().getIntExtra("img_gallery_top", 0);
          this.qaG = getIntent().getIntExtra("img_gallery_left", 0);
          this.qaH = getIntent().getIntExtra("img_gallery_width", 0);
          this.qaI = getIntent().getIntExtra("img_gallery_height", 0);
          if ((this.qaF == 0) && (this.qaG == 0) && (this.qaH == 0) && (this.qaI == 0))
          {
            ca localca = this.Pwu.amt(this.xqs.getCurrentItem());
            if (localca != null)
            {
              bf localbf = new bf();
              localbf.dEo.dCM = localca;
              EventCenter.instance.publish(localbf);
              this.qaH = localbf.dEp.dEs;
              this.qaI = localbf.dEp.dEt;
              this.qaG = localbf.dEp.dEq;
              this.qaF = localbf.dEp.dEr;
            }
          }
          this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
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
        this.xqs.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(233319);
            ImageGalleryUI.this.xqs.getViewTreeObserver().removeOnPreDrawListener(this);
            Log.i("MicroMsg.ImageGalleryUI", "[handleAnimation] -> onPreDraw, isBackFromGrid:" + ImageGalleryUI.this.Pzk);
            ImageGalleryUI.this.EAz = ImageGalleryUI.this.xqs.getWidth();
            ImageGalleryUI.this.EAA = ImageGalleryUI.this.xqs.getHeight();
            if (ImageGalleryUI.this.Pwu.gSg().cWL()) {
              ImageGalleryUI.this.EAA = ((int)(ImageGalleryUI.this.EAz / ImageGalleryUI.this.qaH * ImageGalleryUI.this.qaI));
            }
            if (ImageGalleryUI.this.Pwu.gSg().gAz())
            {
              com.tencent.mm.ui.base.g localg = (com.tencent.mm.ui.base.g)ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.Pwu, ImageGalleryUI.this.xqs);
              if (localg != null)
              {
                ImageGalleryUI localImageGalleryUI = ImageGalleryUI.this;
                float f = ImageGalleryUI.this.EAz / localg.getImageWidth();
                localImageGalleryUI.EAA = ((int)(localg.getImageHeight() * f));
                if (ImageGalleryUI.this.EAA > ImageGalleryUI.this.xqs.getHeight()) {
                  ImageGalleryUI.this.EAA = ImageGalleryUI.this.xqs.getHeight();
                }
              }
            }
            ImageGalleryUI.this.qaE.ls(ImageGalleryUI.this.EAz, ImageGalleryUI.this.EAA);
            if (!ImageGalleryUI.this.Pzk) {
              ImageGalleryUI.this.qaE.a(ImageGalleryUI.this.xqs, ImageGalleryUI.F(ImageGalleryUI.this), new e.c()
              {
                public final void onAnimationEnd()
                {
                  AppMethodBeat.i(233318);
                  ImageGalleryUI.G(ImageGalleryUI.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(233316);
                      if (ImageGalleryUI.this.Pzw != null) {
                        ImageGalleryUI.this.Pzw.t(Boolean.FALSE);
                      }
                      AppMethodBeat.o(233316);
                    }
                  });
                  AppMethodBeat.o(233318);
                }
                
                public final void onAnimationStart()
                {
                  AppMethodBeat.i(233317);
                  if (ImageGalleryUI.this.Pzw != null) {
                    ImageGalleryUI.this.Pzw.t(Boolean.TRUE);
                  }
                  AppMethodBeat.o(233317);
                }
              });
            }
            ImageGalleryUI.H(ImageGalleryUI.this);
            AppMethodBeat.o(233319);
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
    com.tencent.mm.graphics.b.d.hkl.axH();
    if (com.tencent.mm.graphics.b.c.hke.hki) {
      com.tencent.mm.graphics.b.c.hke.stop();
    }
    aL(gSv().PyQ, 8);
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
      RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = gSr().FLz;
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
    implements com.tencent.mm.plugin.appbrand.openmaterial.i
  {
    private final WeakReference<ImageGalleryUI> Kwe;
    private final com.tencent.mm.plugin.appbrand.service.i Kwf;
    private final String PAc;
    private final com.tencent.mm.plugin.appbrand.openmaterial.model.b nkA;
    
    public a(ImageGalleryUI paramImageGalleryUI, String paramString, com.tencent.mm.plugin.appbrand.service.i parami, com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb)
    {
      AppMethodBeat.i(233368);
      this.Kwe = new WeakReference(paramImageGalleryUI);
      this.PAc = paramString;
      this.Kwf = parami;
      this.nkA = paramb;
      AppMethodBeat.o(233368);
    }
    
    public final void a(boolean paramBoolean, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(233369);
      ImageGalleryUI localImageGalleryUI = (ImageGalleryUI)this.Kwe.get();
      if (localImageGalleryUI == null)
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet#onMyOpenMaterialsGot, ui is null");
        AppMethodBeat.o(233369);
        return;
      }
      if (!paramBoolean)
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet#onMyOpenMaterialsGot, fail");
        AppMethodBeat.o(233369);
        return;
      }
      if (ImageGalleryUI.d(localImageGalleryUI) == null)
      {
        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet#onMyOpenMaterialsGot, bottomSheet is null");
        AppMethodBeat.o(233369);
        return;
      }
      ImageGalleryUI.b(localImageGalleryUI, this.PAc);
      ImageGalleryUI.a(localImageGalleryUI, paramAppBrandOpenMaterialCollection);
      if (localImageGalleryUI.Pwu != null) {}
      for (paramAppBrandOpenMaterialCollection = localImageGalleryUI.Pwu.gSe();; paramAppBrandOpenMaterialCollection = null)
      {
        if ((paramAppBrandOpenMaterialCollection != null) && (p.PBM != paramAppBrandOpenMaterialCollection))
        {
          if (ImageGalleryUI.L(localImageGalleryUI) != null) {
            ImageGalleryUI.L(localImageGalleryUI).dead();
          }
          ImageGalleryUI.a(localImageGalleryUI, this.Kwf.a(this.nkA, localImageGalleryUI, ImageGalleryUI.d(localImageGalleryUI), ImageGalleryUI.M(localImageGalleryUI), null, ImageGalleryUI.N(localImageGalleryUI)));
        }
        AppMethodBeat.o(233369);
        return;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void t(Boolean paramBoolean);
  }
  
  final class c
    implements com.tencent.mm.plugin.appbrand.openmaterial.j
  {
    Runnable PAd = null;
    ca PAe = null;
    
    private c() {}
    
    public final void ae(Runnable paramRunnable)
    {
      AppMethodBeat.i(233370);
      Log.i("MicroMsg.ImageGalleryUI", "executeOrDefer");
      ca localca = ImageGalleryUI.this.Pwu.gSg();
      if ((localca != null) && (localca.cWJ()))
      {
        com.tencent.mm.modelvideo.s locals = u.QN(localca.field_imgPath);
        if ((locals != null) && (locals.status != 199) && (locals.status != 199))
        {
          Log.i("MicroMsg.ImageGalleryUI", "executeOrDefer, video start download and waiting");
          ImageGalleryUI.a(ImageGalleryUI.this, u.f(localca.field_msgId, 4));
          ImageGalleryUI.this.Pwu.amT(ImageGalleryUI.this.xqs.getCurrentItem());
          this.PAd = paramRunnable;
          this.PAe = localca;
          AppMethodBeat.o(233370);
          return;
        }
        com.tencent.mm.plugin.appbrand.openmaterial.j.nlj.ae(paramRunnable);
        AppMethodBeat.o(233370);
        return;
      }
      com.tencent.mm.plugin.appbrand.openmaterial.j.nlj.ae(paramRunnable);
      AppMethodBeat.o(233370);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI
 * JD-Core Version:    0.7.0.1
 */