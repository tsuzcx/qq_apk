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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.y;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.av;
import com.tencent.mm.g.a.av.a;
import com.tencent.mm.g.a.bd;
import com.tencent.mm.g.a.bd.b;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.g.a.ic.b;
import com.tencent.mm.g.a.my;
import com.tencent.mm.g.a.my.a;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qe.a;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.g.a.qf.a;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.g.a.sq.a;
import com.tencent.mm.g.a.sr;
import com.tencent.mm.g.a.sr.a;
import com.tencent.mm.g.b.a.ce;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
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
import com.tencent.mm.protocal.protobuf.bkj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.b;
import com.tencent.mm.ui.base.MMViewPager.c;
import com.tencent.mm.ui.base.MMViewPager.e;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.gallery.a.f.c;
import com.tencent.mm.ui.chatting.gallery.a.j.b;
import com.tencent.mm.ui.chatting.gallery.a.j.d;
import com.tencent.mm.ui.chatting.gallery.a.j.e;
import com.tencent.mm.ui.chatting.gallery.a.j.f;
import com.tencent.mm.ui.chatting.gallery.a.j.g;
import com.tencent.mm.ui.chatting.gallery.view.SearchImageBubbleView;
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
import java.util.Map.Entry;
import java.util.Set;

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(3)
public class ImageGalleryUI
  extends MMActivity
  implements View.OnClickListener, a.a<String, com.tencent.mm.plugin.scanner.word.b>
{
  private int ArA;
  int Arv;
  int Arw;
  int Arx;
  private float Ary;
  private int Arz;
  protected RedesignVideoPlayerSeekBar BAO;
  private boolean BAY;
  public View EGj;
  public com.tencent.mm.plugin.webview.ui.tools.media.e Ewq;
  int JSr;
  protected View Jip;
  private HashSet<Long> KcT;
  private boolean Khv;
  protected boolean Khw;
  private boolean KkF;
  private final boolean KkG;
  public b Kkv;
  private n KlR;
  private RelativeLayout KmA;
  private boolean KmB;
  private boolean KmC;
  public f KmD;
  private int KmE;
  private int KmF;
  private int KmG;
  private int KmH;
  private long KmI;
  private boolean KmJ;
  private int KmK;
  private View KmL;
  private View KmM;
  private View KmN;
  private View KmO;
  private View KmP;
  private View KmQ;
  private View KmR;
  private View KmS;
  private View KmT;
  private SearchImageBubbleView KmU;
  View KmV;
  Button KmW;
  Button KmX;
  View KmY;
  int KmZ;
  private b.b Kmz;
  private CheckBox KnA;
  private View KnB;
  private boolean KnC;
  private int KnD;
  private boolean KnE;
  private boolean KnF;
  private ViewPager.OnPageChangeListener KnG;
  public TextView KnH;
  public View KnI;
  public ImageView KnJ;
  private boolean KnK;
  boolean KnL;
  private HashMap<Long, String> KnM;
  private boolean KnN;
  private boolean KnO;
  int Kna;
  boolean Knb;
  ArrayList<Integer> Knc;
  private com.tencent.mm.ui.chatting.gallery.a.n Knd;
  private boolean Kne;
  private com.tencent.mm.ui.chatting.gallery.a.j Knf;
  private com.tencent.mm.ui.chatting.gallery.a.g Kng;
  private int Knh;
  private com.tencent.mm.plugin.scanner.api.d Kni;
  private com.tencent.mm.ui.chatting.gallery.a.l Knj;
  private boolean Knk;
  protected boolean Knl;
  protected boolean Knm;
  private boolean Knn;
  private int Kno;
  private int Knp;
  private boolean Knq;
  private String Knr;
  private boolean Kns;
  private ScanCodeSheetItemLogic Knt;
  private com.tencent.mm.ui.chatting.gallery.a.f Knu;
  private com.tencent.mm.ui.chatting.gallery.a.h Knv;
  private com.tencent.mm.ui.chatting.gallery.a.i Knw;
  private com.tencent.mm.ui.chatting.gallery.a.c Knx;
  public a Kny;
  private View Knz;
  protected String chatroomName;
  private View contentView;
  public ImageView fTj;
  private ImageView iXI;
  private boolean isAnimated;
  private aq mHandler;
  public long msgId;
  private com.tencent.mm.ui.widget.a.e nMW;
  Bundle oMP;
  com.tencent.mm.ui.tools.e oMQ;
  int oMR;
  int oMS;
  int oMT;
  int oMU;
  public long oex;
  public TextView ovs;
  public MMNeat7extView ovt;
  private n.e pSA;
  public boolean rCv;
  private com.tencent.mm.plugin.scanner.word.a rHe;
  private volatile int rHf;
  private int rHg;
  private ImageView rHi;
  private ImageView rHj;
  private ImageView rHk;
  private ValueAnimator rHl;
  private com.tencent.mm.sdk.b.c<sr> rHm;
  private com.tencent.mm.network.n rHn;
  private RelativeLayout rNn;
  com.tencent.mm.sdk.platformtools.aw rNw;
  public View rYg;
  protected MMViewPager tZe;
  protected String talker;
  private boolean vYq;
  
  public ImageGalleryUI()
  {
    AppMethodBeat.i(36149);
    this.BAY = false;
    this.KmC = false;
    this.KmD = new f();
    this.KmE = 0;
    this.KmF = 0;
    this.KmG = 0;
    this.KmH = 0;
    this.KmI = 0L;
    this.KmJ = false;
    this.KmK = 0;
    this.KmL = null;
    this.Arx = 0;
    this.KmZ = 0;
    this.Kna = 0;
    this.oMR = 0;
    this.oMS = 0;
    this.oMT = 0;
    this.oMU = 0;
    this.Knc = new ArrayList();
    this.Khv = false;
    this.rCv = false;
    this.Knd = new com.tencent.mm.ui.chatting.gallery.a.n();
    this.Kne = false;
    this.Kng = new com.tencent.mm.ui.chatting.gallery.a.g();
    this.Knh = 0;
    this.Knj = new com.tencent.mm.ui.chatting.gallery.a.l();
    this.Knl = false;
    this.Khw = false;
    this.Knm = false;
    this.isAnimated = false;
    this.KkF = false;
    this.Kno = -1;
    this.rHg = 0;
    this.KkG = false;
    this.Knr = null;
    this.Knu = new com.tencent.mm.ui.chatting.gallery.a.f();
    this.Knv = new com.tencent.mm.ui.chatting.gallery.a.h()
    {
      public final void b(qe paramAnonymousqe)
      {
        AppMethodBeat.i(187489);
        String str = com.tencent.mm.vfs.o.k(ImageGalleryUI.a(ImageGalleryUI.this), false);
        if ((str == null) || (!str.equals(paramAnonymousqe.dFL.filePath)))
        {
          ae.e("MicroMsg.ImageGalleryUI", "not same filepath");
          AppMethodBeat.o(187489);
          return;
        }
        ae.i("MicroMsg.ImageGalleryUI", "scanCode onFailed result: %s", new Object[] { paramAnonymousqe.dFL.result });
        ImageGalleryUI.c(ImageGalleryUI.this).jY(2, 2);
        ImageGalleryUI.a(ImageGalleryUI.this, 2);
        AppMethodBeat.o(187489);
      }
      
      public final void b(qf paramAnonymousqf)
      {
        AppMethodBeat.i(187488);
        Object localObject = com.tencent.mm.vfs.o.k(ImageGalleryUI.a(ImageGalleryUI.this), false);
        if ((localObject == null) || (!((String)localObject).equals(paramAnonymousqf.dFM.filePath)))
        {
          ae.e("MicroMsg.ImageGalleryUI", "not same filepath");
          AppMethodBeat.o(187488);
          return;
        }
        ae.i("MicroMsg.ImageGalleryUI", "scanCode onSuccess result: %s, recognizeType: %d", new Object[] { paramAnonymousqf.dFM.result, Integer.valueOf(paramAnonymousqf.dFM.dFK) });
        if (!bu.isNullOrNil(paramAnonymousqf.dFM.result))
        {
          localObject = ImageGalleryUI.b(ImageGalleryUI.this);
          p.h(paramAnonymousqf, "event");
          ((com.tencent.mm.ui.chatting.gallery.a.n)localObject).yCU = paramAnonymousqf.dFM.result;
          ((com.tencent.mm.ui.chatting.gallery.a.n)localObject).dov = paramAnonymousqf.dFM.dov;
          ((com.tencent.mm.ui.chatting.gallery.a.n)localObject).dow = paramAnonymousqf.dFM.dow;
          com.tencent.mm.ui.chatting.gallery.a.n.a locala = new com.tencent.mm.ui.chatting.gallery.a.n.a();
          locala.KqW = new PointF(paramAnonymousqf.dFM.dFP / paramAnonymousqf.dFM.dFN, paramAnonymousqf.dFM.dFQ / paramAnonymousqf.dFM.dFO);
          locala.KqX = paramAnonymousqf.dFM.dFN;
          locala.KqY = paramAnonymousqf.dFM.dFO;
          ((com.tencent.mm.ui.chatting.gallery.a.n)localObject).KqT = locala;
          ae.d("MicroMsg.ImageGalleryUI", "scanCode onSuccess codePointInfo: %s", new Object[] { ImageGalleryUI.b(ImageGalleryUI.this).KqT });
          ImageGalleryUI.c(ImageGalleryUI.this).jY(2, 1);
          ImageGalleryUI.c(ImageGalleryUI.this).e(2, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187487);
              if ((ImageGalleryUI.d(ImageGalleryUI.this) != null) && (ImageGalleryUI.d(ImageGalleryUI.this).isShowing()))
              {
                ImageGalleryUI.this.cZZ();
                AppMethodBeat.o(187487);
                return;
              }
              ImageGalleryUI.a(ImageGalleryUI.this, 2);
              AppMethodBeat.o(187487);
            }
          });
          if (2 == paramAnonymousqf.dFM.dFK) {
            ImageGalleryUI.e(ImageGalleryUI.this).bV(ImageGalleryUI.b(ImageGalleryUI.this).dov, ImageGalleryUI.b(ImageGalleryUI.this).yCU);
          }
        }
        AppMethodBeat.o(187488);
      }
    };
    this.Knw = new com.tencent.mm.ui.chatting.gallery.a.i()
    {
      public final void a(my paramAnonymousmy)
      {
        int i = 1;
        AppMethodBeat.i(187509);
        ae.i("MicroMsg.ImageGalleryUI", "handleCode callback notifyEvent: %d", new Object[] { Integer.valueOf(paramAnonymousmy.dBW.dBU) });
        if (ImageGalleryUI.g(ImageGalleryUI.f(ImageGalleryUI.this)) != null) {
          ImageGalleryUI.g(ImageGalleryUI.f(ImageGalleryUI.this)).setOnClickListener(ImageGalleryUI.this);
        }
        if ((paramAnonymousmy.dBW.activity != ImageGalleryUI.this) || (!paramAnonymousmy.dBW.dmI.equals(ImageGalleryUI.b(ImageGalleryUI.this).yCU)))
        {
          ae.e("MicroMsg.ImageGalleryUI", "handleCode callback not the same");
          AppMethodBeat.o(187509);
          return;
        }
        switch (paramAnonymousmy.dBW.dBU)
        {
        default: 
          AppMethodBeat.o(187509);
          return;
        case 0: 
        case 1: 
        case 2: 
          ImageGalleryUI.h(ImageGalleryUI.this).aeH(2);
          ImageGalleryUI.gl(ImageGalleryUI.j(ImageGalleryUI.i(ImageGalleryUI.this)));
          AppMethodBeat.o(187509);
          return;
        }
        paramAnonymousmy = paramAnonymousmy.dBW.dBX;
        if (paramAnonymousmy != null) {}
        for (boolean bool = paramAnonymousmy.getBoolean("key_scan_qr_code_result", true);; bool = true)
        {
          paramAnonymousmy = ImageGalleryUI.h(ImageGalleryUI.this);
          if (bool) {}
          for (;;)
          {
            paramAnonymousmy.aeH(i);
            ImageGalleryUI.this.finish();
            break;
            i = 2;
          }
        }
      }
    };
    this.KlR = new n()
    {
      public final void ao(long paramAnonymousLong, int paramAnonymousInt)
      {
        AppMethodBeat.i(187523);
        ae.i("MicroMsg.ImageGalleryUI", "alvinluo onImageDownloaded msgId: %d, currentMsgId: %d, compressType: %d", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(ImageGalleryUI.k(ImageGalleryUI.this)), Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousLong == ImageGalleryUI.k(ImageGalleryUI.this)) && (!d.aep(paramAnonymousInt))) {
          ImageGalleryUI.a(ImageGalleryUI.this, paramAnonymousLong);
        }
        AppMethodBeat.o(187523);
      }
      
      public final void b(long paramAnonymousLong, View paramAnonymousView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(187522);
        if ((paramAnonymousView != null) && (paramAnonymousBitmap != null) && (!bu.isNullOrNil(paramAnonymousString)))
        {
          ae.i("MicroMsg.ImageGalleryUI", "alvinluo onImageLoaded msgId: %d, currentMsgId: %d, imagePath: %s, bitmap: %s", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(ImageGalleryUI.k(ImageGalleryUI.this)), paramAnonymousString, Integer.valueOf(paramAnonymousBitmap.hashCode()) });
          ImageGalleryUI.a(ImageGalleryUI.this, paramAnonymousView, paramAnonymousString, paramAnonymousBitmap, ImageGalleryUI.l(ImageGalleryUI.this));
          if (paramAnonymousLong == ImageGalleryUI.k(ImageGalleryUI.this)) {
            ImageGalleryUI.a(ImageGalleryUI.this, paramAnonymousLong);
          }
        }
        AppMethodBeat.o(187522);
      }
    };
    this.Knx = new com.tencent.mm.ui.chatting.gallery.a.c()
    {
      public final void aXU(String paramAnonymousString)
      {
        AppMethodBeat.i(187535);
        Object localObject1 = ImageGalleryUI.this.Kkv.adI(ImageGalleryUI.m(ImageGalleryUI.this));
        if (localObject1 == null)
        {
          AppMethodBeat.o(187535);
          return;
        }
        boolean bool = x.wb(((ei)localObject1).field_talker);
        Object localObject3 = ImageGalleryUI.h(ImageGalleryUI.this);
        long l = ((ei)localObject1).field_msgSvrId;
        int i;
        Object localObject2;
        if (bool)
        {
          i = 2;
          localObject2 = ImageGalleryUI.l((bv)localObject1, bool);
          if (!bool) {
            break label203;
          }
          localObject1 = ((ei)localObject1).field_talker;
          label85:
          localObject3 = ((com.tencent.mm.ui.chatting.gallery.a.f)localObject3).KpP;
          if (localObject3 == null) {
            break label210;
          }
          ((f.c)localObject3).msgId = l;
          ((f.c)localObject3).scene = 67;
          ((f.c)localObject3).chatType = i;
          if (localObject2 != null) {
            break label216;
          }
          localObject2 = "";
        }
        label203:
        label210:
        label216:
        for (;;)
        {
          p.h(localObject2, "<set-?>");
          ((f.c)localObject3).KpV = ((String)localObject2);
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          p.h(localObject2, "<set-?>");
          ((f.c)localObject3).pFr = ((String)localObject2);
          localObject1 = paramAnonymousString;
          if (paramAnonymousString == null) {
            localObject1 = "";
          }
          p.h(localObject1, "<set-?>");
          ((f.c)localObject3).imagePath = ((String)localObject1);
          AppMethodBeat.o(187535);
          return;
          i = 1;
          break;
          localObject1 = "";
          break label85;
          AppMethodBeat.o(187535);
          return;
        }
      }
    };
    this.rHn = new com.tencent.mm.network.n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(187542);
        com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187541);
            if ((com.tencent.mm.kernel.g.ajj().aFd() != 6) && (com.tencent.mm.kernel.g.ajj().aFd() != 4))
            {
              if (ImageGalleryUI.n(ImageGalleryUI.this) == 1)
              {
                com.tencent.mm.ui.base.h.c(ImageGalleryUI.this, ImageGalleryUI.this.getString(2131755828), "", true);
                ImageGalleryUI.o(ImageGalleryUI.this);
                ImageGalleryUI.h(ImageGalleryUI.this).aeH(2);
                AppMethodBeat.o(187541);
              }
            }
            else
            {
              if (ImageGalleryUI.this.Kkv == null)
              {
                AppMethodBeat.o(187541);
                return;
              }
              int i = ImageGalleryUI.this.getCurrentItem();
              bv localbv = ImageGalleryUI.this.Kkv.adI(i);
              if ((localbv != null) && (localbv.cyH()))
              {
                if (ImageGalleryUI.this.Kkv.fJT() == null) {
                  ImageGalleryUI.this.Kkv.fJT().fKM();
                }
                if ((ImageGalleryUI.this.Kkv.fJT().fKM().KoM.getVisibility() == 0) || (ImageGalleryUI.this.Kkv.fJT().fKM().KoV.getVisibility() == 0)) {
                  ImageGalleryUI.this.Kkv.aeh(i);
                }
              }
            }
            AppMethodBeat.o(187541);
          }
        });
        AppMethodBeat.o(187542);
      }
    };
    this.KnC = true;
    this.Ary = 1.0F;
    this.Arz = 0;
    this.ArA = 0;
    this.pSA = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(187518);
        if ((ImageGalleryUI.this == null) || (ImageGalleryUI.this.isDestroyed()) || (ImageGalleryUI.this.isFinishing()))
        {
          ae.i("MicroMsg.ImageGalleryUI", "receive onMMMenuItemSelected but activity is invalid");
          AppMethodBeat.o(187518);
          return;
        }
        ae.i("MicroMsg.ImageGalleryUI", "curTransState %d", new Object[] { Integer.valueOf(ImageGalleryUI.n(ImageGalleryUI.this)) });
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(187518);
          return;
          paramAnonymousMenuItem = ImageGalleryUI.this.Kkv.fJS();
          Object localObject;
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cyG()))
          {
            localObject = u.Ia(paramAnonymousMenuItem.field_imgPath);
            if ((localObject != null) && (((s)localObject).status != 199) && (((s)localObject).status != 199))
            {
              ImageGalleryUI.b(ImageGalleryUI.this, u.f(paramAnonymousMenuItem.field_msgId, 1));
              ImageGalleryUI.this.Kkv.aei(ImageGalleryUI.this.tZe.getCurrentItem());
            }
          }
          for (;;)
          {
            if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cyH()))
            {
              localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.EGd;
              com.tencent.mm.plugin.webview.ui.tools.media.a.aF(1, ImageGalleryUI.I(ImageGalleryUI.this), ImageGalleryUI.J(ImageGalleryUI.this));
              paramAnonymousMenuItem = j.cq(paramAnonymousMenuItem);
              if (paramAnonymousMenuItem != null)
              {
                localObject = com.tencent.mm.plugin.webview.ui.tools.media.h.EHf;
                com.tencent.mm.plugin.webview.ui.tools.media.h.a.i(1, paramAnonymousMenuItem.FUx, paramAnonymousMenuItem.FUw, ImageGalleryUI.this.KmD.otX);
              }
            }
            AppMethodBeat.o(187518);
            return;
            ImageGalleryUI.this.Kkv.aed(ImageGalleryUI.this.tZe.getCurrentItem());
            continue;
            ImageGalleryUI.this.Kkv.aed(ImageGalleryUI.this.tZe.getCurrentItem());
          }
          paramAnonymousMenuItem = ImageGalleryUI.this.Kkv.fJS();
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cyH()))
          {
            localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.EGd;
            com.tencent.mm.plugin.webview.ui.tools.media.a.aF(4, ImageGalleryUI.I(ImageGalleryUI.this), ImageGalleryUI.J(ImageGalleryUI.this));
            paramAnonymousMenuItem = j.cq(paramAnonymousMenuItem);
            if (paramAnonymousMenuItem != null) {
              ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramAnonymousMenuItem, ImageGalleryUI.this, ImageGalleryUI.this.KmD.otX);
            }
            AppMethodBeat.o(187518);
            return;
            paramAnonymousMenuItem = ImageGalleryUI.this.Kkv.fJS();
            if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cyG()))
            {
              localObject = u.Ia(paramAnonymousMenuItem.field_imgPath);
              if ((localObject != null) && (((s)localObject).status != 199) && (((s)localObject).status != 199))
              {
                ImageGalleryUI.b(ImageGalleryUI.this, u.f(paramAnonymousMenuItem.field_msgId, 2));
                ImageGalleryUI.this.Kkv.aei(ImageGalleryUI.this.tZe.getCurrentItem());
                AppMethodBeat.o(187518);
                return;
              }
              paramAnonymousMenuItem = new ArrayList();
              paramAnonymousMenuItem.add(ImageGalleryUI.this.Kkv.fJS());
              b.f(ImageGalleryUI.this.getContext(), paramAnonymousMenuItem);
              AppMethodBeat.o(187518);
              return;
            }
            paramAnonymousMenuItem = new ArrayList();
            paramAnonymousMenuItem.add(ImageGalleryUI.this.Kkv.fJS());
            com.tencent.mm.modelstat.b.iqT.V((bv)paramAnonymousMenuItem.get(0));
            b.f(ImageGalleryUI.this.getContext(), paramAnonymousMenuItem);
            AppMethodBeat.o(187518);
            return;
            ImageGalleryUI.this.Kkv.aee(ImageGalleryUI.this.tZe.getCurrentItem());
            AppMethodBeat.o(187518);
            return;
            if (com.tencent.mm.br.d.aJN("favorite"))
            {
              ImageGalleryUI.this.Kkv.aef(ImageGalleryUI.this.tZe.getCurrentItem());
              paramAnonymousMenuItem = ImageGalleryUI.this.Kkv.fJS();
              if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cyH()))
              {
                paramAnonymousMenuItem = com.tencent.mm.plugin.webview.ui.tools.media.a.EGd;
                com.tencent.mm.plugin.webview.ui.tools.media.a.aF(2, ImageGalleryUI.I(ImageGalleryUI.this), ImageGalleryUI.J(ImageGalleryUI.this));
              }
              AppMethodBeat.o(187518);
              return;
              ImageGalleryUI.L(ImageGalleryUI.this);
              AppMethodBeat.o(187518);
              return;
              if (ImageGalleryUI.this.Kkv != null)
              {
                if (b.j(ImageGalleryUI.this.Kkv.fJS())) {
                  ImageGalleryUI.M(ImageGalleryUI.this);
                }
                AppMethodBeat.o(187518);
                return;
                ImageGalleryUI.N(ImageGalleryUI.this);
                AppMethodBeat.o(187518);
                return;
                ae.i("MicroMsg.ImageGalleryUI", "request deal QBAR string");
                if ((ImageGalleryUI.d(ImageGalleryUI.this) != null) && (ImageGalleryUI.d(ImageGalleryUI.this).isShowing())) {
                  ImageGalleryUI.d(ImageGalleryUI.this).bqD();
                }
                paramAnonymousMenuItem = bu.x("%d,%d", new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
                ae.i("MicroMsg.ImageGalleryUI", "18684 report:".concat(String.valueOf(paramAnonymousMenuItem)));
                com.tencent.mm.plugin.report.service.g.yxI.kvStat(18684, paramAnonymousMenuItem);
                ImageGalleryUI.K(ImageGalleryUI.this);
                AppMethodBeat.o(187518);
                return;
                ImageGalleryUI.O(ImageGalleryUI.this);
              }
            }
          }
        }
      }
    };
    this.rHm = new com.tencent.mm.sdk.b.c() {};
    this.KnD = 0;
    this.KnE = false;
    this.KnF = true;
    this.KnG = new ViewPager.OnPageChangeListener()
    {
      private boolean KnW = false;
      
      public final void onPageScrollStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(187526);
        ae.d("MicroMsg.ImageGalleryUI", "onPageScrollStateChanged: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 2) {
          ImageGalleryUI.c(ImageGalleryUI.this, true);
        }
        if (paramAnonymousInt == 0)
        {
          this.KnW = false;
          ImageGalleryUI.W(ImageGalleryUI.this);
          ImageGalleryUI.c(ImageGalleryUI.this, false);
        }
        if (ImageGalleryUI.this.Kkv != null)
        {
          Object localObject = ImageGalleryUI.this.Kkv;
          if (((b)localObject).KkB != null)
          {
            localObject = ((b)localObject).KkB;
            ((d)localObject).mScrollState = paramAnonymousInt;
            if (((d)localObject).KlS != null) {
              ((d)localObject).KlS.onPageScrollStateChanged(paramAnonymousInt);
            }
          }
        }
        AppMethodBeat.o(187526);
      }
      
      public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        AppMethodBeat.i(187525);
        ae.v("MicroMsg.ImageGalleryUI", "position: %d, positionOffset: %f, positionOffsetPixels: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Float.valueOf(paramAnonymousFloat), Integer.valueOf(paramAnonymousInt2) });
        if ((!this.KnW) && (paramAnonymousInt2 > 0)) {
          this.KnW = true;
        }
        AppMethodBeat.o(187525);
      }
      
      public final void onPageSelected(int paramAnonymousInt)
      {
        boolean bool2 = true;
        AppMethodBeat.i(187524);
        ae.v("MicroMsg.ImageGalleryUI", "onPageChange position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (ImageGalleryUI.this.Kkv == null)
        {
          AppMethodBeat.o(187524);
          return;
        }
        if (ImageGalleryUI.m(ImageGalleryUI.this) != paramAnonymousInt)
        {
          if ((ImageGalleryUI.d(ImageGalleryUI.this) != null) && (ImageGalleryUI.d(ImageGalleryUI.this).isShowing())) {
            ImageGalleryUI.d(ImageGalleryUI.this).bqD();
          }
          if (!ImageGalleryUI.P(ImageGalleryUI.this))
          {
            ImageGalleryUI.Q(ImageGalleryUI.this);
            ImageGalleryUI.h(ImageGalleryUI.this).aeD(2);
            ImageGalleryUI.R(ImageGalleryUI.this);
          }
          ImageGalleryUI.S(ImageGalleryUI.this);
          ImageGalleryUI.a(ImageGalleryUI.this, false);
          if (ImageGalleryUI.n(ImageGalleryUI.this) == 1) {
            ImageGalleryUI.o(ImageGalleryUI.this);
          }
          ImageGalleryUI.T(ImageGalleryUI.this);
          ImageGalleryUI.q(ImageGalleryUI.this);
        }
        if (ImageGalleryUI.this.Kkv.Tq(paramAnonymousInt) == null) {
          ae.e("MicroMsg.ImageGalleryUI", "onPageSelected the view is null, position = %s ", new Object[] { Integer.valueOf(paramAnonymousInt) });
        }
        ImageGalleryUI.A(ImageGalleryUI.this);
        ImageGalleryUI.e(ImageGalleryUI.this, ImageGalleryUI.m(ImageGalleryUI.this));
        ImageGalleryUI.this.KmD.a(ImageGalleryUI.this, ImageGalleryUI.m(ImageGalleryUI.this), paramAnonymousInt);
        ImageGalleryUI.f(ImageGalleryUI.this, paramAnonymousInt);
        Object localObject1;
        int i;
        label483:
        label620:
        long l;
        if (ImageGalleryUI.this.Kkv != null)
        {
          localObject1 = ImageGalleryUI.this.Kkv;
          ((b)localObject1).KkC.OA();
          ((b)localObject1).KkD.OA();
          localObject1 = ImageGalleryUI.this.Kkv.adI(paramAnonymousInt);
          if (localObject1 != null)
          {
            ImageGalleryUI.b(ImageGalleryUI.this, ((ei)localObject1).field_msgId);
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aaK(((ei)localObject1).field_talker);
            ImageGalleryUI.a(ImageGalleryUI.this, b.cb((bv)localObject1));
          }
          if ((b.j((bv)localObject1)) || (b.bZ((bv)localObject1)))
          {
            localObject2 = ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.Kkv, ImageGalleryUI.this.tZe);
            if ((localObject2 != null) && ((localObject2 instanceof com.tencent.mm.ui.base.g)))
            {
              if (!(localObject2 instanceof MultiTouchImageView)) {
                break label829;
              }
              ((MultiTouchImageView)localObject2).fCA();
            }
            String str = ImageGalleryUI.a(ImageGalleryUI.this);
            i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("EnableSessionPicTranslation", 0);
            Object localObject3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("PicTranslationSupportUserLanguage");
            if (i != 1) {
              break label851;
            }
            bool1 = true;
            ae.i("MicroMsg.ScannerHelper", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool1), localObject3, ad.fom() });
            if ((i != 1) || (bu.isNullOrNil((String)localObject3))) {
              break label857;
            }
            localObject3 = ((String)localObject3).split(";");
            if ((localObject3 == null) || (!Arrays.asList((Object[])localObject3).contains(ad.fom()))) {
              break label857;
            }
            i = 1;
            label561:
            if (i != 0)
            {
              if (ImageGalleryUI.U(ImageGalleryUI.this) == null) {
                ImageGalleryUI.a(ImageGalleryUI.this, new ImageWordScanDetailEngine(ImageGalleryUI.this));
              }
              if (bu.isNullOrNil(str)) {
                break label873;
              }
              ImageGalleryUI.U(ImageGalleryUI.this).a(str, ImageGalleryUI.this);
            }
            ImageGalleryUI.a(ImageGalleryUI.this, (View)localObject2, com.tencent.mm.vfs.o.k(str, false), null, ImageGalleryUI.l(ImageGalleryUI.this));
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ah((bv)localObject1);
            ImageGalleryUI.a(ImageGalleryUI.this, ((ei)localObject1).field_msgId);
          }
          if (localObject1 != null) {
            ImageGalleryUI.this.EM(((ei)localObject1).field_msgId);
          }
          if (ImageGalleryUI.this.Kkv == null) {
            break label894;
          }
          localObject2 = ImageGalleryUI.this.Kkv.h((bv)localObject1, false);
          if (!b.b((bv)localObject1, (com.tencent.mm.av.g)localObject2)) {
            break label902;
          }
          localObject1 = com.tencent.mm.av.h.a((com.tencent.mm.av.g)localObject2);
          i = ((com.tencent.mm.av.g)localObject1).hPI;
          int j = ((com.tencent.mm.av.g)localObject1).offset;
          if (i == 0) {
            break label888;
          }
          l = j * 100L / i - 1L;
          label758:
          i = Math.max(1, (int)l);
          ae.d("MicroMsg.ImageGalleryUI", "jacks loading hd from imgInfo : %d, time: %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()) });
          ImageGalleryUI.this.aey(i);
        }
        for (;;)
        {
          if (ImageGalleryUI.this.Kkv != null) {
            ImageGalleryUI.this.Kkv.onPageSelected(paramAnonymousInt);
          }
          AppMethodBeat.o(187524);
          return;
          label829:
          if (!(localObject2 instanceof WxImageView)) {
            break;
          }
          ((WxImageView)localObject2).fCA();
          break;
          label851:
          bool1 = false;
          break label483;
          label857:
          if (com.tencent.mm.protocal.d.FFL)
          {
            i = 1;
            break label561;
          }
          i = 0;
          break label561;
          label873:
          ImageGalleryUI.c(ImageGalleryUI.this).jY(1, 2);
          break label620;
          label888:
          l = 0L;
          break label758;
          label894:
          ae.e("MicroMsg.ImageGalleryUI", "[arthurdan.ImageGallery] Notice!!! adapter is null");
          label902:
          if (localObject1 != null) {
            break label925;
          }
          ae.e("MicroMsg.ImageGalleryUI", "update footer fail, msg is null, position = ".concat(String.valueOf(paramAnonymousInt)));
        }
        label925:
        Object localObject2 = ImageGalleryUI.this;
        if (!ImageGalleryUI.P(ImageGalleryUI.this)) {}
        for (boolean bool1 = bool2;; bool1 = false)
        {
          ((ImageGalleryUI)localObject2).k((bv)localObject1, bool1);
          ImageGalleryUI.V(ImageGalleryUI.this);
          break;
        }
      }
    };
    this.EGj = null;
    this.KnK = false;
    this.KnL = false;
    this.rNw = new com.tencent.mm.sdk.platformtools.aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(187529);
        if (ImageGalleryUI.X(ImageGalleryUI.this)) {
          ImageGalleryUI.this.fKo();
        }
        AppMethodBeat.o(187529);
        return false;
      }
    }, false);
    this.KnM = new HashMap();
    this.KnN = false;
    this.KnO = false;
    this.mHandler = new aq(Looper.getMainLooper());
    this.KcT = new HashSet();
    AppMethodBeat.o(36149);
  }
  
  private static void A(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(187560);
    ae.d("MicroMsg.ImageGalleryUI", "alvinluo hideButton view: %s, withAnimation: %b", new Object[] { paramView, Boolean.valueOf(paramBoolean) });
    if (paramView == null)
    {
      AppMethodBeat.o(187560);
      return;
    }
    if (!paramBoolean)
    {
      aG(paramView, 8);
      com.tencent.mm.ui.chatting.gallery.a.m.go(paramView);
      AppMethodBeat.o(187560);
      return;
    }
    if (paramView.getVisibility() == 0) {
      com.tencent.mm.ui.chatting.gallery.a.m.gn(paramView);
    }
    AppMethodBeat.o(187560);
  }
  
  private static String EK(long paramLong)
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
      ae.d("MicroMsg.ImageGalleryUI", "get current view adapter is null %b, gallery is null %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((paramb == null) || (paramMMViewPager == null)) {
        break label182;
      }
      if (paramb.fJS() != null) {
        break label81;
      }
      AppMethodBeat.o(36164);
      return null;
      bool1 = false;
      break;
    }
    label81:
    Object localObject;
    if ((paramb.fJS().ftg()) || (paramb.fJS().fvK()))
    {
      MultiTouchImageView localMultiTouchImageView = paramb.HN(paramMMViewPager.getCurrentItem());
      localObject = localMultiTouchImageView;
      if (localMultiTouchImageView == null) {
        localObject = paramb.HO(paramMMViewPager.getCurrentItem());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(36164);
      return localObject;
      if ((paramb.fJS().cyG()) || (paramb.fJS().cyI()) || (paramb.fJS().cyH()))
      {
        localObject = paramb.aeg(paramMMViewPager.getCurrentItem());
        continue;
        label182:
        ae.w("MicroMsg.ImageGalleryUI", "%d get current view but adapter or gallery is null", new Object[] { Integer.valueOf(hashCode()) });
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  private void a(View paramView, String paramString, Bitmap paramBitmap, int paramInt, com.tencent.mm.ui.chatting.gallery.a.h paramh)
  {
    AppMethodBeat.i(187555);
    if (this.Knf != null) {
      if (paramInt == 1)
      {
        if (this.Kne)
        {
          this.Knf.a(paramView, paramString, paramBitmap, true, paramInt, paramh);
          AppMethodBeat.o(187555);
        }
      }
      else {
        this.Knf.a(paramView, paramString, paramBitmap, false, paramInt, paramh);
      }
    }
    AppMethodBeat.o(187555);
  }
  
  private static void aG(View paramView, int paramInt)
  {
    AppMethodBeat.i(36156);
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(36156);
  }
  
  private boolean aXS(String paramString)
  {
    AppMethodBeat.i(36169);
    if (this.Knp == 1)
    {
      AppMethodBeat.o(36169);
      return false;
    }
    if ((this.Knd == null) || (bu.isNullOrNil(this.Knd.yCU)))
    {
      AppMethodBeat.o(36169);
      return false;
    }
    if (!this.Knn)
    {
      AppMethodBeat.o(36169);
      return true;
    }
    String[] arrayOfString = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IQs, "")).split("\\|");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((!bu.isNullOrNil(str)) && (paramString.startsWith(str)))
        {
          ae.i("MicroMsg.ImageGalleryUI", "curDealQBarStr:%s, blockQrcodeStr:%s", new Object[] { paramString, str });
          AppMethodBeat.o(36169);
          return false;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(36169);
    return true;
  }
  
  private void aXT(String paramString)
  {
    AppMethodBeat.i(36213);
    paramString = RecordConfigProvider.iO(paramString, "");
    paramString.scene = this.Knp;
    Object localObject = new UICustomParam.a();
    ((UICustomParam.a)localObject).abH();
    ((UICustomParam.a)localObject).abG();
    ((UICustomParam.a)localObject).cP(true);
    paramString.xOh = ((UICustomParam.a)localObject).ggq;
    localObject = com.tencent.mm.plugin.recordvideo.jumper.a.xOE;
    com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4369, 2130772137, -1, paramString, 1, 2);
    AppMethodBeat.o(36213);
  }
  
  private boolean aes(int paramInt)
  {
    AppMethodBeat.i(187551);
    if (this.Kng.aeI(paramInt) != 2)
    {
      AppMethodBeat.o(187551);
      return true;
    }
    AppMethodBeat.o(187551);
    return false;
  }
  
  private void aeu(int paramInt)
  {
    AppMethodBeat.i(36181);
    bv localbv = this.Kkv.adI(paramInt);
    if ((localbv == null) || (!localbv.cyH()) || (this.KkF))
    {
      AppMethodBeat.o(36181);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(new i.c(localbv.field_talker, "update", localbv));
    AppMethodBeat.o(36181);
  }
  
  private void aev(int paramInt)
  {
    AppMethodBeat.i(36189);
    ae.i("MicroMsg.ImageGalleryUI", "enterGrid source : ".concat(String.valueOf(paramInt)));
    if (this.Kkv == null)
    {
      ae.w("MicroMsg.ImageGalleryUI", "try to enterGrid, but adapter is NULL");
      AppMethodBeat.o(36189);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 13L, 1L, true);
    int i = this.Kkv.getRealCount();
    if (this.Kkv.fJS() == null)
    {
      ae.e("MicroMsg.ImageGalleryUI", "msgInfo is null");
      AppMethodBeat.o(36189);
      return;
    }
    int j = this.Kkv.Kkx.aem(this.tZe.getCurrentItem());
    if (!this.Knl)
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), MediaHistoryGalleryUI.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("kintent_intent_source", paramInt);
      ((Intent)localObject).putExtra("kintent_talker", fKl());
      ((Intent)localObject).putExtra("kintent_image_count", i);
      ((Intent)localObject).putExtra("kintent_image_index", j);
      ((Intent)localObject).putExtra("key_biz_chat_id", this.oex);
      ((Intent)localObject).putExtra("key_is_biz_chat", this.rCv);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "enterGrid", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "enterGrid", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187530);
          ImageGalleryUI.this.finish();
          AppMethodBeat.o(187530);
        }
      }, 50L);
      AppMethodBeat.o(36189);
      return;
    }
    bYa();
    AppMethodBeat.o(36189);
  }
  
  static Animation aex(int paramInt)
  {
    AppMethodBeat.i(36199);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(paramInt);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator(10.0F));
    AppMethodBeat.o(36199);
    return localAlphaAnimation;
  }
  
  private void aez(int paramInt)
  {
    AppMethodBeat.i(36209);
    if (this.EGj != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.EGj.getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, paramInt, 0);
      this.EGj.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(36209);
  }
  
  private void bYa()
  {
    AppMethodBeat.i(36165);
    if ((this.BAY) || (this.Kkv == null))
    {
      ae.i("MicroMsg.ImageGalleryUI", "isRunningExitAnimation");
      AppMethodBeat.o(36165);
      return;
    }
    yl(true);
    if (this.KmB)
    {
      finish();
      com.tencent.mm.ui.base.b.kk(getContext());
      AppMethodBeat.o(36165);
      return;
    }
    ae.i("MicroMsg.ImageGalleryUI", "runExitAnimation");
    int k = this.tZe.getWidth() / 2;
    int j = this.tZe.getHeight() / 2;
    this.Kkv.fJR();
    Object localObject1;
    int m;
    int i;
    int n;
    if (!fEp())
    {
      if (this.Knl)
      {
        localObject1 = new ic();
        ((ic)localObject1).dvF.msgId = this.Kkv.adI(this.tZe.getCurrentItem()).field_msgId;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
        m = ((ic)localObject1).dvG.dnd;
        i = ((ic)localObject1).dvG.dne;
        k = ((ic)localObject1).dvG.dnb;
        j = ((ic)localObject1).dvG.dnc;
        this.Arv = this.tZe.getWidth();
        this.Arw = this.tZe.getHeight();
        n = i;
        if (this.Kkv.fJS() != null)
        {
          if ((this.Kkv.fJS().cyI()) || (this.Kkv.fJS().cyG()) || (this.Kkv.fJS().cyH())) {
            this.Arw = ((int)(this.Arv / m * i));
          }
          if (!this.Kkv.fJS().ftg())
          {
            n = i;
            if (!this.Kkv.fJS().fvK()) {}
          }
          else
          {
            localObject1 = (com.tencent.mm.ui.base.g)a(this.Kkv, this.tZe);
            n = i;
            if (localObject1 != null)
            {
              float f = this.Arv / ((com.tencent.mm.ui.base.g)localObject1).getImageWidth();
              this.Arw = ((int)(((com.tencent.mm.ui.base.g)localObject1).getImageHeight() * f));
              n = i;
              if (this.Arw > this.tZe.getHeight())
              {
                n = i;
                if (this.Arw < this.tZe.getHeight() * 1.5D)
                {
                  if (!this.Knl) {
                    break label881;
                  }
                  this.Arx = (this.Arw - this.tZe.getHeight());
                  n = i;
                }
                label440:
                this.Arw = this.tZe.getHeight();
              }
            }
          }
        }
        this.oMQ.kh(this.KmZ, this.Kna);
        this.oMQ.LeJ = this.Arx;
        this.oMQ.kg(this.Arv, this.Arw);
        this.oMQ.R(k, j, m, n);
        localObject1 = this.tZe;
        localObject2 = a(this.Kkv, this.tZe);
        if (localObject2 == null) {
          break label900;
        }
        localObject1 = localObject2;
        if (this.Ary != 1.0D)
        {
          this.oMQ.LeF = (1.0F / this.Ary);
          if (this.Arz == 0)
          {
            localObject1 = localObject2;
            if (this.ArA == 0) {}
          }
          else
          {
            i = (int)(this.tZe.getWidth() / 2 * (1.0F - this.Ary));
            j = this.Arz;
            k = (int)(this.tZe.getHeight() / 2 + this.ArA - this.Arw / 2 * this.Ary);
            this.oMQ.ki(i + j, k);
            localObject1 = localObject2;
          }
        }
        label647:
        if (this.KnL) {
          fKp();
        }
        this.oMQ.a((View)localObject1, this.iXI, new e.c()
        {
          public final void onAnimationEnd()
          {
            AppMethodBeat.i(187508);
            ae.i("MicroMsg.ImageGalleryUI", "runExitAnimation onAnimationEnd");
            ImageGalleryUI.z(ImageGalleryUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(187506);
                ImageGalleryUI.this.finish();
                ImageGalleryUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.o(187506);
              }
            });
            ImageGalleryUI.b(ImageGalleryUI.this, false);
            AppMethodBeat.o(187508);
          }
          
          public final void onAnimationStart()
          {
            AppMethodBeat.i(187507);
            ImageGalleryUI.b(ImageGalleryUI.this, true);
            new aq().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(187505);
                View localView = ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.Kkv, ImageGalleryUI.this.tZe);
                if ((localView != null) && ((localView instanceof com.tencent.mm.ui.base.g)))
                {
                  if ((localView instanceof MultiTouchImageView))
                  {
                    ((MultiTouchImageView)localView).fCA();
                    AppMethodBeat.o(187505);
                    return;
                  }
                  if ((localView instanceof WxImageView)) {
                    ((WxImageView)localView).fCA();
                  }
                }
                AppMethodBeat.o(187505);
              }
            }, 20L);
            AppMethodBeat.o(187507);
          }
        }, null);
        AppMethodBeat.o(36165);
        return;
      }
      localObject1 = this.Kkv.adI(this.tZe.getCurrentItem());
      if (localObject1 == null) {
        break label903;
      }
      Object localObject2 = new bd();
      ((bd)localObject2).dmZ.dlw = ((bv)localObject1);
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
      m = ((bd)localObject2).dna.dnd;
      i = ((bd)localObject2).dna.dne;
      k = ((bd)localObject2).dna.dnb;
      j = ((bd)localObject2).dna.dnc;
    }
    for (;;)
    {
      if ((k == 0) && (j == 0))
      {
        k = this.tZe.getWidth() / 2;
        j = this.tZe.getHeight() / 2;
        break;
      }
      if (localObject1 != null)
      {
        if (((ei)localObject1).field_isSend == 0) {
          this.KmZ = com.tencent.mm.cb.a.fromDPToPix(getContext(), 5);
        }
        if (((ei)localObject1).field_isSend == 1) {
          this.Kna = com.tencent.mm.cb.a.fromDPToPix(getContext(), 5);
        }
      }
      break;
      m = this.oMT;
      i = this.oMU;
      k = this.oMS;
      j = this.oMR;
      break;
      label881:
      n = this.tZe.getHeight() * i / this.Arw;
      break label440;
      label900:
      break label647;
      label903:
      i = 0;
      m = 0;
    }
  }
  
  private boolean bk(Activity paramActivity)
  {
    AppMethodBeat.i(36211);
    paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
    int j = paramActivity.getWidth();
    int k = paramActivity.getHeight();
    if (j < k) {}
    for (int i = 1;; i = 0)
    {
      ae.d("MicroMsg.ImageGalleryUI", "%d is vertical screen orient %d [%d, %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(36211);
      return false;
    }
    AppMethodBeat.o(36211);
    return true;
  }
  
  private void bn(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(187558);
    if (fEp())
    {
      AppMethodBeat.o(187558);
      return;
    }
    ae.d("MicroMsg.ImageGalleryUI", "alvinluo checkShowQuickButton fromType: %d, needHide: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Object localObject1 = null;
    if (yn(paramBoolean))
    {
      localObject1 = fKg().KmR;
      paramInt = 2;
    }
    for (;;)
    {
      int i = this.KmK;
      Object localObject2;
      label95:
      Object localObject3;
      if (localObject1 != null)
      {
        localObject2 = Float.valueOf(((View)localObject1).getAlpha());
        if (localObject1 == null) {
          break label386;
        }
        localObject3 = Integer.valueOf(((View)localObject1).getVisibility());
        label110:
        ae.i("MicroMsg.ImageGalleryUI", "alvinluo checkShowQuickButton showType: %d, currentQuickButtonType: %d, targetView: %s, targetView.alpha: %s, targetView.visibility: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), localObject1, localObject2, localObject3 });
        if (paramInt == 0) {
          break label404;
        }
        i = this.KmK;
        if (paramInt != this.KmK)
        {
          if ((this.KmK != 0) && ((paramInt != 3) || (localObject1 == null) || (((View)localObject1).getVisibility() == 0))) {
            break label394;
          }
          paramBoolean = true;
          label196:
          this.Knh = 0;
          z((View)localObject1, paramBoolean);
          int j = fKj().KmU.getVisibility();
          bo(paramInt, false);
          if (this.KmK == 3)
          {
            aG(fKj().KmU, j);
            A(fKj().KmU, true);
          }
          this.KmK = paramInt;
          this.KmL = ((View)localObject1);
        }
        if (paramInt == 3)
        {
          localObject1 = fKi().KmT;
          if ((i != 0) || (fKc().KmT.getVisibility() == 0)) {
            break label399;
          }
        }
      }
      label386:
      label394:
      label399:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        z((View)localObject1, paramBoolean);
        AppMethodBeat.o(187558);
        return;
        if (yq(paramBoolean))
        {
          localObject1 = fKj().KmU;
          paramInt = 3;
          break;
        }
        if (yo(paramBoolean))
        {
          localObject1 = this.KmQ;
          paramInt = 1;
          break;
        }
        if (!bp(paramInt, paramBoolean)) {
          break label511;
        }
        paramInt = 4;
        localObject1 = fKi().KmT;
        break;
        localObject2 = "null";
        break label95;
        localObject3 = "null";
        break label110;
        paramBoolean = false;
        break label196;
      }
      label404:
      if (this.Kng.fLd())
      {
        ae.i("MicroMsg.ImageGalleryUI", "alvinluo checkShowQuickButton isAllValid and hideQuickButton");
        localObject1 = this.KmL;
        if ((this.KmK == 0) || (this.KmL == null)) {
          break label501;
        }
        paramBoolean = true;
        A((View)localObject1, paramBoolean);
        if (this.KmK == 3)
        {
          localObject1 = fKi().KmT;
          if (fKc().KmT.getVisibility() != 0) {
            break label506;
          }
        }
      }
      label501:
      label506:
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        A((View)localObject1, paramBoolean);
        fKq();
        AppMethodBeat.o(187558);
        return;
        paramBoolean = false;
        break;
      }
      label511:
      paramInt = 0;
    }
  }
  
  private void bo(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(187561);
    if (fEp())
    {
      AppMethodBeat.o(187561);
      return;
    }
    ae.i("MicroMsg.ImageGalleryUI", "alvinluo hideQuickButton showType: %d, withAnimation: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramInt != 2) {
      A(fKg().KmR, paramBoolean);
    }
    if (paramInt != 3) {
      A(fKj().KmU, paramBoolean);
    }
    if (paramInt != 1) {
      A(this.KmQ, paramBoolean);
    }
    if (paramInt != 4) {
      A(fKi().KmT, paramBoolean);
    }
    if (paramInt == 0) {
      fKq();
    }
    AppMethodBeat.o(187561);
  }
  
  private boolean bp(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(187569);
    if ((!fKs()) || (!com.tencent.mm.ui.chatting.gallery.a.e.fLa()))
    {
      AppMethodBeat.o(187569);
      return false;
    }
    this.Kng.jY(4, 2);
    boolean bool = this.Kng.isValid(4);
    ae.i("MicroMsg.ImageGalleryUI", "alvinluo checkShowSearchImageButton fromType: %s, isSearchButtonValid: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    if (bool)
    {
      this.Kng.jY(4, 1);
      if (this.Kng.lc(4))
      {
        this.Kng.aeJ(4);
        paramBoolean = yp(paramBoolean);
        AppMethodBeat.o(187569);
        return paramBoolean;
      }
    }
    AppMethodBeat.o(187569);
    return false;
  }
  
  private String cxR()
  {
    AppMethodBeat.i(36166);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    bv localbv;
    if (this.Kkv != null)
    {
      localbv = this.Kkv.adI(this.KnD);
      if (!b.j(localbv)) {
        break label74;
      }
      com.tencent.mm.av.g localg = this.Kkv.h(localbv, true);
      localObject1 = localObject2;
      if (localg != null) {
        localObject1 = d.a(localbv, localg);
      }
    }
    for (;;)
    {
      localObject1 = bu.nullAsNil((String)localObject1);
      AppMethodBeat.o(36166);
      return localObject1;
      label74:
      localObject1 = localObject2;
      if (b.bZ(localbv)) {
        localObject1 = b.l(localbv);
      }
    }
  }
  
  private void cyT()
  {
    AppMethodBeat.i(36183);
    ae.i("MicroMsg.ImageGalleryUI", "show video tool bar");
    ys(true);
    aG(this.KmV, 4);
    aG(fKd().BAO, 0);
    aG(fKd().Jip, 0);
    aG(this.KmM, 0);
    if (this.KmB) {
      fKo();
    }
    if (this.Kkv != null)
    {
      bv localbv = this.Kkv.fJS();
      if ((localbv != null) && (localbv.cyH())) {
        aG(this.EGj, 0);
      }
    }
    AppMethodBeat.o(36183);
  }
  
  private void cyf()
  {
    AppMethodBeat.i(36171);
    this.rHl.setRepeatMode(1);
    this.rHl.setRepeatCount(0);
    this.rHl.end();
    AppMethodBeat.o(36171);
  }
  
  private void eYI()
  {
    boolean bool = true;
    AppMethodBeat.i(36196);
    if (this.KmA.getVisibility() == 0) {}
    for (;;)
    {
      ae.d("MicroMsg.ImageGalleryUI", "fadeOutOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      Animation localAnimation = aex(150);
      localAnimation.setFillAfter(false);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(187532);
          if (!ImageGalleryUI.X(ImageGalleryUI.this)) {
            ImageGalleryUI.this.fKp();
          }
          AppMethodBeat.o(187532);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.KmA.clearAnimation();
      this.KmA.startAnimation(localAnimation);
      AppMethodBeat.o(36196);
      return;
      bool = false;
    }
  }
  
  private void eYK()
  {
    AppMethodBeat.i(36207);
    final View localView = getWindow().getDecorView();
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(187537);
        localView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        ImageGalleryUI.ab(ImageGalleryUI.this);
        AppMethodBeat.o(187537);
      }
    });
    AppMethodBeat.o(36207);
  }
  
  private void eYL()
  {
    AppMethodBeat.i(36208);
    final View localView = getWindow().getDecorView();
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(187538);
        localView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i = com.tencent.mm.cb.a.iu(ImageGalleryUI.this);
        int j = com.tencent.mm.cb.a.iv(ImageGalleryUI.this);
        ae.i("MicroMsg.ImageGalleryUI", "handleHorizontalUI width = %d, height = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if ((i <= j) || ((com.tencent.mm.compatible.util.d.lA(24)) && (ImageGalleryUI.this.isInMultiWindowMode())))
        {
          ImageGalleryUI.ab(ImageGalleryUI.this);
          AppMethodBeat.o(187538);
          return;
        }
        ImageGalleryUI.ac(ImageGalleryUI.this);
        AppMethodBeat.o(187538);
      }
    });
    AppMethodBeat.o(36208);
  }
  
  private static boolean f(bv parambv, com.tencent.mm.av.g paramg)
  {
    AppMethodBeat.i(36179);
    if (paramg == null)
    {
      AppMethodBeat.o(36179);
      return false;
    }
    try
    {
      if ((b.c(parambv, paramg) == 0) && (paramg.aIB()))
      {
        boolean bool = parambv.fvU();
        if (!bool)
        {
          AppMethodBeat.o(36179);
          return true;
        }
      }
    }
    catch (NullPointerException parambv)
    {
      ae.e("MicroMsg.ImageGalleryUI", "error:".concat(String.valueOf(parambv)));
      AppMethodBeat.o(36179);
    }
    return false;
  }
  
  private boolean fEp()
  {
    return this.JSr == 1;
  }
  
  private static Animation fKA()
  {
    AppMethodBeat.i(36198);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(150L);
    localAlphaAnimation.setFillAfter(true);
    AppMethodBeat.o(36198);
    return localAlphaAnimation;
  }
  
  private void fKC()
  {
    AppMethodBeat.i(36210);
    if (this.EGj != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.EGj.getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, 0, 0);
      this.EGj.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(36210);
  }
  
  private void fKD()
  {
    AppMethodBeat.i(36212);
    bv localbv = this.Kkv.fJS();
    String str = d.a(localbv, d.k(localbv));
    ae.i("MicroMsg.ImageGalleryUI", "edit image path:%s msgId:%s", new Object[] { str, Long.valueOf(localbv.field_msgId) });
    aXT(str);
    AppMethodBeat.o(36212);
  }
  
  private ImageGalleryUI fKe()
  {
    AppMethodBeat.i(36154);
    if (this.KmN == null) {
      this.KmN = findViewById(2131299498);
    }
    AppMethodBeat.o(36154);
    return this;
  }
  
  private ImageGalleryUI fKf()
  {
    AppMethodBeat.i(36155);
    if (this.KmP == null) {
      this.KmP = findViewById(2131299194);
    }
    AppMethodBeat.o(36155);
    return this;
  }
  
  private ImageGalleryUI fKg()
  {
    AppMethodBeat.i(187546);
    if (this.KmR == null) {
      this.KmR = findViewById(2131308314);
    }
    AppMethodBeat.o(187546);
    return this;
  }
  
  private ImageGalleryUI fKh()
  {
    AppMethodBeat.i(187547);
    if (this.KmS == null) {
      this.KmS = findViewById(2131304331);
    }
    AppMethodBeat.o(187547);
    return this;
  }
  
  private ImageGalleryUI fKi()
  {
    AppMethodBeat.i(187548);
    if (this.KmT == null) {
      this.KmT = findViewById(2131308491);
    }
    AppMethodBeat.o(187548);
    return this;
  }
  
  private ImageGalleryUI fKj()
  {
    AppMethodBeat.i(187549);
    if (this.KmU == null) {
      this.KmU = ((SearchImageBubbleView)findViewById(2131308518));
    }
    AppMethodBeat.o(187549);
    return this;
  }
  
  private void fKk()
  {
    int i = 2;
    AppMethodBeat.i(187550);
    boolean bool1 = aes(1);
    boolean bool2 = aes(2);
    if ((bool1) && (bool2)) {
      i = 4;
    }
    for (;;)
    {
      this.Knu.aeF(i);
      AppMethodBeat.o(187550);
      return;
      if (bool1) {
        i = 3;
      } else if (!bool2) {
        i = 1;
      }
    }
  }
  
  private String fKl()
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
  
  private boolean fKm()
  {
    AppMethodBeat.i(36168);
    if (this.Knn)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if (this.Knp == 1)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if (this.KkF)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if ((!this.Khv) && (!this.rCv) && (!h.a.fKb().rKJ))
    {
      AppMethodBeat.o(36168);
      return true;
    }
    AppMethodBeat.o(36168);
    return false;
  }
  
  private void fKq()
  {
    this.KmK = 0;
    this.KmL = null;
  }
  
  private void fKr()
  {
    int j = 0;
    AppMethodBeat.i(187562);
    if (fEp())
    {
      AppMethodBeat.o(187562);
      return;
    }
    aG(this.KmO, 0);
    View localView = fKe().KmN;
    if (this.Knk) {}
    for (int i = 0;; i = 8)
    {
      aG(localView, i);
      int k = this.KmE;
      i = j;
      if (this.Knk) {
        i = 1;
      }
      this.KmE = (k + (i + 1));
      AppMethodBeat.o(187562);
      return;
    }
  }
  
  private boolean fKs()
  {
    return (this.Khw) || (this.Knl);
  }
  
  private void fKt()
  {
    AppMethodBeat.i(187568);
    if (fKj().KmU.getVisibility() == 0) {
      yq(true);
    }
    AppMethodBeat.o(187568);
  }
  
  private int fKu()
  {
    if (this.Kno == 0)
    {
      locala = com.tencent.mm.plugin.webview.ui.tools.media.a.EGd;
      return 2;
    }
    if (this.Kno == 1)
    {
      locala = com.tencent.mm.plugin.webview.ui.tools.media.a.EGd;
      return 4;
    }
    com.tencent.mm.plugin.webview.ui.tools.media.a locala = com.tencent.mm.plugin.webview.ui.tools.media.a.EGd;
    return 1;
  }
  
  private int fKv()
  {
    if (this.KmC) {
      return 3;
    }
    return 4;
  }
  
  private boolean fKw()
  {
    return this.Kmz == b.b.Klh;
  }
  
  private boolean fKx()
  {
    return (this.Kmz == b.b.Klg) || (this.Kmz == b.b.Klj);
  }
  
  private void fKz()
  {
    boolean bool = true;
    AppMethodBeat.i(36197);
    if (this.KmA.getVisibility() == 0) {}
    for (;;)
    {
      ae.d("MicroMsg.ImageGalleryUI", "fadeInOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      this.KmA.clearAnimation();
      this.KmA.startAnimation(fKA());
      AppMethodBeat.o(36197);
      return;
      bool = false;
    }
  }
  
  private static int g(com.tencent.mm.av.g paramg)
  {
    AppMethodBeat.i(36187);
    Map localMap = bx.M(paramg.icA, "msg");
    if (localMap == null)
    {
      ae.e("MicroMsg.ImageGalleryUI", "parse cdnInfo failed. [%s]", new Object[] { paramg.icA });
      AppMethodBeat.o(36187);
      return -1;
    }
    int j = bu.getInt((String)localMap.get(".msg.img.$hdlength"), 0);
    int i = j;
    if (j == 0) {
      i = bu.getInt((String)localMap.get(".msg.img.$tphdlength"), 0);
    }
    AppMethodBeat.o(36187);
    return i;
  }
  
  private void j(bv parambv, boolean paramBoolean)
  {
    int k = 1;
    AppMethodBeat.i(187563);
    if (this.Kmz != b.b.Klg) {}
    for (int i = 0;; i = 1)
    {
      if ((bn.z(parambv)) || (bn.A(parambv))) {
        i = 0;
      }
      if (fEp()) {
        i = 0;
      }
      parambv = fKf().KmP;
      label76:
      int j;
      if (paramBoolean) {
        if (i != 0) {
          if (parambv.getVisibility() != 0)
          {
            paramBoolean = true;
            z(parambv, paramBoolean);
            j = this.KmE;
            if (i == 0) {
              break label140;
            }
          }
        }
      }
      label140:
      for (i = k;; i = 0)
      {
        this.KmE = (j + i);
        AppMethodBeat.o(187563);
        return;
        paramBoolean = false;
        break;
        A(parambv, true);
        break label76;
        if (i != 0) {}
        for (j = 0;; j = 8)
        {
          aG(parambv, j);
          break;
        }
      }
    }
  }
  
  private void mY(boolean paramBoolean)
  {
    int i = 8;
    AppMethodBeat.i(36178);
    if (this.rNn == null)
    {
      AppMethodBeat.o(36178);
      return;
    }
    if (((paramBoolean) && (this.rNn.getVisibility() == 0)) || ((!paramBoolean) && (this.rNn.getVisibility() == 8)))
    {
      AppMethodBeat.o(36178);
      return;
    }
    Object localObject = this.rNn;
    if (paramBoolean) {
      i = 0;
    }
    ((RelativeLayout)localObject).setVisibility(i);
    localObject = getContext();
    if (paramBoolean) {}
    for (i = 2130771981;; i = 2130771982)
    {
      localObject = AnimationUtils.loadAnimation((Context)localObject, i);
      this.rNn.startAnimation((Animation)localObject);
      AppMethodBeat.o(36178);
      return;
    }
  }
  
  private void yj(boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(187553);
    Object localObject2;
    Object localObject1;
    if (this.Knf != null)
    {
      this.Knd.KqU = paramBoolean;
      this.Knd.doz = getIntent().getBundleExtra("_stat_obj");
      localObject2 = this.Knd;
      ae.i("MicroMsg.ImageGalleryUI", "talker: %s, chatroom: %s", new Object[] { this.talker, this.chatroomName });
      localObject1 = "";
      if ((bu.isNullOrNil(this.chatroomName)) || (!x.wb(this.chatroomName))) {
        break label294;
      }
      ae.d("MicroMsg.ImageGalleryUI", "is chatroom: %s", new Object[] { this.chatroomName });
      localObject1 = this.chatroomName;
      ((com.tencent.mm.ui.chatting.gallery.a.n)localObject2).sourceType = i;
      p.h(localObject1, "<set-?>");
      ((com.tencent.mm.ui.chatting.gallery.a.n)localObject2).source = ((String)localObject1);
      localObject1 = this.Knd;
      if ((this.Kkv != null) && (this.Kkv.fJS() != null)) {
        break label444;
      }
    }
    for (;;)
    {
      localObject1 = this.Knf;
      localObject2 = a(this.Kkv, this.tZe);
      com.tencent.mm.ui.chatting.gallery.a.n localn = this.Knd;
      com.tencent.mm.ui.chatting.gallery.a.k local19 = new com.tencent.mm.ui.chatting.gallery.a.k()
      {
        public final void a(PointF paramAnonymousPointF, AnimatorListenerAdapter paramAnonymousAnimatorListenerAdapter)
        {
          AppMethodBeat.i(187517);
          com.tencent.mm.ui.chatting.gallery.a.o.a(ImageGalleryUI.j(ImageGalleryUI.i(ImageGalleryUI.this)), paramAnonymousPointF.x, paramAnonymousPointF.y, paramAnonymousAnimatorListenerAdapter);
          AppMethodBeat.o(187517);
        }
      };
      Object localObject3 = this.Knw;
      p.h(localn, "codeResult");
      if (((com.tencent.mm.ui.chatting.gallery.a.j)localObject1).Kqj)
      {
        ae.i("MicroMsg.ImageScanCodeManager", "alvinluo handleCode %s", new Object[] { localn.yCU });
        localObject3 = new j.d((com.tencent.mm.ui.chatting.gallery.a.j)localObject1, (com.tencent.mm.ui.chatting.gallery.a.i)localObject3);
        com.tencent.mm.ui.chatting.gallery.a.o localo = com.tencent.mm.ui.chatting.gallery.a.o.KqZ;
        com.tencent.mm.ui.chatting.gallery.a.o.a((Context)((com.tencent.mm.ui.chatting.gallery.a.j)localObject1).dtg, (View)localObject2, localn, local19, (com.tencent.mm.ui.chatting.gallery.a.d)localObject3);
      }
      AppMethodBeat.o(187553);
      return;
      label294:
      if (!bu.isNullOrNil(this.talker))
      {
        if (x.Ao(this.talker))
        {
          ae.d("MicroMsg.ImageGalleryUI", "is biz: %s", new Object[] { this.talker });
          int j = 4;
          i = j;
          if (((com.tencent.mm.ui.chatting.gallery.a.n)localObject2).doz != null)
          {
            ((com.tencent.mm.ui.chatting.gallery.a.n)localObject2).doz.putString("img_gallery_talker", this.talker);
            i = j;
          }
        }
        for (;;)
        {
          localObject1 = this.talker;
          break;
          if (x.wb(this.talker))
          {
            ae.d("MicroMsg.ImageGalleryUI", "taler is chatroom: %s", new Object[] { this.talker });
          }
          else
          {
            ae.d("MicroMsg.ImageGalleryUI", "is single chat: %s", new Object[] { this.talker });
            i = 1;
          }
        }
      }
      ae.e("MicroMsg.ImageGalleryUI", "unknow source");
      i = -1;
      break;
      label444:
      localObject2 = this.Kkv.h(this.Kkv.fJS(), true);
      if ((localObject2 != null) && (!bu.isNullOrNil(((com.tencent.mm.av.g)localObject2).icA)))
      {
        localObject2 = bx.M(((com.tencent.mm.av.g)localObject2).icA, "msg");
        if (localObject2 != null)
        {
          ((com.tencent.mm.ui.chatting.gallery.a.n)localObject1).doy = ((String)((Map)localObject2).get(".msg.img.$aeskey"));
          ((com.tencent.mm.ui.chatting.gallery.a.n)localObject1).imagePath = ((String)((Map)localObject2).get(".msg.img.$cdnmidimgurl"));
        }
      }
    }
  }
  
  private void yk(boolean paramBoolean)
  {
    AppMethodBeat.i(187554);
    String str = cxR();
    Object localObject;
    label76:
    label255:
    sq.a locala;
    if (((this.rHg == 0) || (this.rHg == 2)) && (!bu.isNullOrNil(str)))
    {
      localObject = new ce();
      long l;
      if (this.rHg == 2)
      {
        l = 1L;
        ((ce)localObject).dWt = l;
        ((ce)localObject).dQB = 3L;
        if (!paramBoolean) {
          break label255;
        }
        l = 10L;
        ((ce)localObject).edv = l;
        ((ce)localObject).aLH();
        this.rHf = ((int)(v.aAC().hashCode() + System.currentTimeMillis()));
        localObject = ((com.tencent.mm.plugin.scanner.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.scanner.e.class)).getTranslationResult(str);
        if ((localObject == null) || (!com.tencent.mm.vfs.o.fB(((fp)localObject).field_resultFile))) {
          break label267;
        }
        if (this.Kkv.adI(this.KnD) == null) {
          break label397;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("original_file_path", str);
        ((Intent)localObject).putExtra("msg_id", this.Kkv.adI(this.KnD).field_msgId);
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
        this.Knu.aeH(1);
        AppMethodBeat.o(187554);
        return;
        l = 0L;
        break;
        l = 4L;
        break label76;
      }
      label267:
      if ((com.tencent.mm.kernel.g.ajj().aFd() == 6) || (com.tencent.mm.kernel.g.ajj().aFd() == 4)) {
        break label404;
      }
      com.tencent.mm.ui.base.h.c(this, getString(2131755828), "", true);
      yl(false);
      ae.i("MicroMsg.ImageGalleryUI", "try to translate img %s, sessionId %d", new Object[] { str, Integer.valueOf(this.rHf) });
      localObject = new sq();
      locala = ((sq)localObject).dIl;
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
      ((sq)localObject).dIl.filePath = str;
      ((sq)localObject).dIl.dmM = this.rHf;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(187554);
      return;
      this.rHg = 1;
      this.rHi.setVisibility(0);
      this.rHj.setVisibility(0);
      this.rHk.setVisibility(0);
      fKo();
      this.rHl.setRepeatMode(1);
      this.rHl.setRepeatCount(-1);
      this.rHl.start();
      break;
    }
  }
  
  private void yl(boolean paramBoolean)
  {
    AppMethodBeat.i(36170);
    this.rHg = 0;
    this.rHi.setVisibility(8);
    this.rHj.setVisibility(8);
    this.rHk.setVisibility(8);
    if (!paramBoolean)
    {
      fKy();
      ym(false);
    }
    cyf();
    AppMethodBeat.o(36170);
  }
  
  private void ym(boolean paramBoolean)
  {
    AppMethodBeat.i(187557);
    if (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) {
      ae.d("MicroMsg.ImageGalleryUI", "showOpLayer isShowOpToolbar: %b, pageChanged: %b, %s", new Object[] { Boolean.valueOf(this.KnL), Boolean.valueOf(paramBoolean), bu.fpN() });
    }
    if (this.KmB)
    {
      AppMethodBeat.o(187557);
      return;
    }
    if (this.Kkv != null) {}
    for (bv localbv = this.Kkv.fJS();; localbv = null)
    {
      if (localbv == null)
      {
        AppMethodBeat.o(187557);
        return;
      }
      if (bn.B(localbv))
      {
        ae.w("MicroMsg.ImageGalleryUI", "ignore show opLayer");
        AppMethodBeat.o(187557);
        return;
      }
      if (!this.KnL) {
        fKz();
      }
      for (boolean bool = false;; bool = true)
      {
        this.KmE = 0;
        this.KnL = true;
        this.KmA.setVisibility(0);
        fKy();
        fKr();
        j(localbv, paramBoolean);
        if (!paramBoolean) {
          bn(0, true);
        }
        for (;;)
        {
          if (fKw()) {
            cyT();
          }
          mY(true);
          yr(true);
          AppMethodBeat.o(187557);
          return;
          if (!fKx()) {
            bo(0, bool);
          }
        }
      }
    }
  }
  
  private boolean yn(boolean paramBoolean)
  {
    AppMethodBeat.i(187564);
    if (!this.Kne)
    {
      AppMethodBeat.o(187564);
      return false;
    }
    boolean bool2 = fEp();
    boolean bool3 = this.Kng.lc(2);
    if ((bool3) && (!bool2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ae.v("MicroMsg.ImageGalleryUI", "showScanCodeButton showQRCodeResult: %b, isFromQuoteMsg: %b, show: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (!bool1) {
        break;
      }
      this.Knu.aeE(2);
      if (fKg().KmR.getVisibility() != 0) {
        aG(fKg().KmR, 0);
      }
      AppMethodBeat.o(187564);
      return true;
    }
    if (paramBoolean) {
      aG(fKg().KmR, 8);
    }
    AppMethodBeat.o(187564);
    return false;
  }
  
  private boolean yo(boolean paramBoolean)
  {
    AppMethodBeat.i(187565);
    if (!fKs())
    {
      AppMethodBeat.o(187565);
      return false;
    }
    boolean bool2 = this.Kng.lc(1);
    boolean bool1;
    ce localce;
    if ((this.Knq) && (bool2) && (!fEp()))
    {
      bool1 = true;
      ae.v("MicroMsg.ImageGalleryUI", "showScanTranslateButton showQuickTrans: %b, showTranslateResult: %b, show: %b", new Object[] { Boolean.valueOf(this.Knq), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (!bool1) {
        break label185;
      }
      localce = new ce();
      if (this.rHg != 2) {
        break label179;
      }
    }
    label179:
    for (long l = 1L;; l = 0L)
    {
      localce.dWt = l;
      localce.dQB = 8L;
      localce.edv = 10L;
      localce.aLH();
      this.Knu.aeE(3);
      if (this.KmQ.getVisibility() != 0) {
        aG(this.KmQ, 0);
      }
      AppMethodBeat.o(187565);
      return true;
      bool1 = false;
      break;
    }
    label185:
    if (paramBoolean) {
      aG(this.KmQ, 8);
    }
    AppMethodBeat.o(187565);
    return false;
  }
  
  private boolean yp(boolean paramBoolean)
  {
    AppMethodBeat.i(187566);
    if ((!fKs()) || (!com.tencent.mm.ui.chatting.gallery.a.e.fLa()))
    {
      AppMethodBeat.o(187566);
      return false;
    }
    if ((!fEp()) && (this.Kng.lc(4))) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.ImageGalleryUI", "alvinluo showSearchImageButton showButton: %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      aG(fKi().KmT, 0);
      this.Knu.jX(1, 3);
      AppMethodBeat.o(187566);
      return true;
    }
    if (paramBoolean) {
      aG(fKi().KmT, 8);
    }
    AppMethodBeat.o(187566);
    return false;
  }
  
  private boolean yq(boolean paramBoolean)
  {
    AppMethodBeat.i(187567);
    if ((!fKs()) || (!com.tencent.mm.ui.chatting.gallery.a.e.fLb()))
    {
      AppMethodBeat.o(187567);
      return false;
    }
    boolean bool;
    label106:
    Object localObject;
    int i;
    if ((!fEp()) && (this.Kni != null) && (!bu.isNullOrNil(this.Kni.yzS)) && (this.Kng.lc(3)))
    {
      bool = true;
      ae.i("MicroMsg.ImageGalleryUI", "alvinluo showSearchImageBubbleView showBubble: %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label377;
      }
      if (this.KmA.getVisibility() != 0) {
        break label350;
      }
      paramBoolean = true;
      localObject = fKi().KmT;
      if (!paramBoolean) {
        break label355;
      }
      i = 0;
      label121:
      aG((View)localObject, i);
      localObject = fKj().KmU;
      if (!paramBoolean) {
        break label361;
      }
      i = 0;
      label142:
      aG((View)localObject, i);
      int k = this.tZe.getMeasuredWidth();
      int j = k - (this.KmE + 1) * this.KmF - this.KmH;
      i = j;
      if (this.KmE > 1) {
        i = j - this.KmE * this.KmG;
      }
      ae.i("MicroMsg.ImageGalleryUI", "alvinluo showSearchImageBubbleView visible: %b, galleryWidth: %d, showButtonCount: %d, viewPositionX: %d, bottomBtnSize: %d, bottomBtnRightExtrMargin: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(k), Integer.valueOf(this.KmE), Integer.valueOf(i), Integer.valueOf(this.KmF), Integer.valueOf(this.KmH) });
      localObject = fKj().KmU;
      ((SearchImageBubbleView)localObject).setViewWidth(k);
      ((SearchImageBubbleView)localObject).setBubbleText(this.Kni.yzS);
      ((SearchImageBubbleView)localObject).jZ(this.KmF, this.KmF);
      ((SearchImageBubbleView)localObject).setAnchorViewPosition$255f295(i);
      ((SearchImageBubbleView)localObject).setBubbleClickListener(this);
      if (!paramBoolean) {
        break label367;
      }
      ((SearchImageBubbleView)localObject).show();
    }
    for (;;)
    {
      this.Knu.jX(1, 4);
      AppMethodBeat.o(187567);
      return true;
      bool = false;
      break;
      label350:
      paramBoolean = false;
      break label106;
      label355:
      i = 8;
      break label121;
      label361:
      i = 8;
      break label142;
      label367:
      ((SearchImageBubbleView)localObject).setVisibility(8);
    }
    label377:
    if (paramBoolean) {
      aG(fKj().KmU, 8);
    }
    AppMethodBeat.o(187567);
    return false;
  }
  
  private void yr(boolean paramBoolean)
  {
    AppMethodBeat.i(36177);
    if (this.Kmz != b.b.Klg)
    {
      aG(this.KmV, 4);
      AppMethodBeat.o(36177);
      return;
    }
    Object localObject = null;
    if (this.Kkv != null) {
      localObject = this.Kkv.fJS();
    }
    if (localObject == null)
    {
      aG(this.KmV, 4);
      AppMethodBeat.o(36177);
      return;
    }
    com.tencent.mm.av.g localg = this.Kkv.h((bv)localObject, false);
    if (paramBoolean)
    {
      this.tZe.getCurrentItem();
      if ((f((bv)localObject, localg)) && (!((bv)localObject).fvU()) && (localg.aIA()))
      {
        fKc().KmW.setVisibility(0);
        fKc().KmX.setVisibility(8);
        fKc().KmY.setVisibility(8);
        String str = (String)this.KnM.get(Long.valueOf(localg.doE));
        localObject = str;
        if (str == null)
        {
          localObject = EK(g(localg));
          this.KnM.put(Long.valueOf(localg.doE), localObject);
        }
        fKc().KmW.setText(getString(2131757973, new Object[] { localObject }));
        aG(this.KmV, 0);
        AppMethodBeat.o(36177);
        return;
      }
    }
    aG(this.KmV, 4);
    AppMethodBeat.o(36177);
  }
  
  private static void ys(boolean paramBoolean)
  {
    AppMethodBeat.i(36185);
    ae.d("MicroMsg.ImageGalleryUI", "switch tool bar bg %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(36185);
  }
  
  private void yt(boolean paramBoolean)
  {
    AppMethodBeat.i(187572);
    ae.i("MicroMsg.ImageGalleryUI", "dealWithSearchImage fromButton: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.websearch.api.o localo = new com.tencent.mm.plugin.websearch.api.o();
    localo.context = this;
    localo.dCi = this.Kkv.fJS();
    if (paramBoolean) {}
    for (int i = 3;; i = 2)
    {
      localo.doR = i;
      ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(localo);
      AppMethodBeat.o(187572);
      return;
    }
  }
  
  private static void z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(187559);
    if (paramView == null)
    {
      AppMethodBeat.o(187559);
      return;
    }
    ae.d("MicroMsg.ImageGalleryUI", "alvinluo showButton view: %s, withAnimation: %b", new Object[] { paramView, Boolean.valueOf(paramBoolean) });
    paramView.setVisibility(0);
    if (paramBoolean)
    {
      paramView.setAlpha(0.0F);
      com.tencent.mm.ui.chatting.gallery.a.m.gm(paramView);
      AppMethodBeat.o(187559);
      return;
    }
    paramView.setAlpha(1.0F);
    AppMethodBeat.o(187559);
  }
  
  public final int EL(long paramLong)
  {
    AppMethodBeat.i(36204);
    if (bu.isNullOrNil(this.Knr))
    {
      AppMethodBeat.o(36204);
      return 0;
    }
    try
    {
      int j = u.g(paramLong, this.Knr);
      int i = j;
      if (j == -1)
      {
        this.Knr = null;
        i = 0;
      }
      ae.d("MicroMsg.ImageGalleryUI", "get enter video op code %d %s", new Object[] { Integer.valueOf(i), this.Knr });
      AppMethodBeat.o(36204);
      return i;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.ImageGalleryUI", "get enter video op code error : " + localException.toString());
      AppMethodBeat.o(36204);
    }
    return 0;
  }
  
  public final void EM(long paramLong)
  {
    AppMethodBeat.i(36205);
    if ((bu.isNullOrNil(this.Knr)) || (paramLong == 0L))
    {
      AppMethodBeat.o(36205);
      return;
    }
    if (this.Kns)
    {
      this.Knr = u.f(paramLong, 3);
      ae.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[] { this.Knr });
      AppMethodBeat.o(36205);
      return;
    }
    if (u.g(paramLong, this.Knr) == -1)
    {
      this.Knr = null;
      ae.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[] { this.Knr });
    }
    AppMethodBeat.o(36205);
  }
  
  public final void aet(int paramInt)
  {
    AppMethodBeat.i(36180);
    k(this.Kkv.adI(paramInt), false);
    AppMethodBeat.o(36180);
  }
  
  public final void aew(final int paramInt)
  {
    AppMethodBeat.i(36194);
    if (fKd().BAO == null)
    {
      AppMethodBeat.o(36194);
      return;
    }
    fKd().BAO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187531);
        if (ImageGalleryUI.this.Kkv == null)
        {
          AppMethodBeat.o(187531);
          return;
        }
        b localb = ImageGalleryUI.this.Kkv;
        int i = paramInt;
        localb.KkC.pause(i);
        AppMethodBeat.o(187531);
      }
    });
    AppMethodBeat.o(36194);
  }
  
  public final void aey(int paramInt)
  {
    AppMethodBeat.i(36200);
    cyS();
    ym(false);
    fKc().KmV.setVisibility(0);
    fKc().KmW.setVisibility(8);
    fKc().KmX.setVisibility(0);
    fKc().KmY.setVisibility(8);
    fKc().KmX.setText(paramInt + "%");
    AppMethodBeat.o(36200);
  }
  
  protected final void cZZ()
  {
    AppMethodBeat.i(187552);
    int i = this.KnD;
    if (this.Kkv == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.ImageGalleryUI", "showMenu mSelectedPos %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      if (this.Kkv != null) {
        break;
      }
      AppMethodBeat.o(187552);
      return;
    }
    if (this.KnD < 0)
    {
      AppMethodBeat.o(187552);
      return;
    }
    bv localbv = this.Kkv.adI(this.KnD);
    i = this.Kkv.KkB.ci(localbv);
    if ((i == 5) || (i == 6))
    {
      ae.w("MicroMsg.ImageGalleryUI", "jacks fail downloaded img, return");
      AppMethodBeat.o(187552);
      return;
    }
    Object localObject = this.Kkv;
    if (localbv != null)
    {
      localObject = ((b)localObject).h(localbv, false);
      if (localObject != null) {
        if ((localbv == null) || (localObject == null)) {
          bool = false;
        }
      }
    }
    while (bool)
    {
      ae.w("MicroMsg.ImageGalleryUI", "jacks downloading, return");
      AppMethodBeat.o(187552);
      return;
      if ((com.tencent.mm.av.q.aIY().a(((com.tencent.mm.av.g)localObject).doE, localbv.field_msgId, 0)) || (b.b(localbv, (com.tencent.mm.av.g)localObject)))
      {
        bool = true;
      }
      else
      {
        bool = false;
        continue;
        localObject = j.cp(localbv);
        if ((localObject != null) && (localObject != null))
        {
          i = ((s)localObject).status;
          int j = u.g((s)localObject);
          if (((i == 112) || (i == 122)) && (j < 100)) {}
          for (bool = true;; bool = false)
          {
            ae.i("MicroMsg.ImageGalleryAdapter", "it is video downloading %b, status %d, download progress %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
            break;
          }
        }
        bool = false;
      }
    }
    if (b.m(localbv))
    {
      if ((j.cp(localbv) == null) && (!localbv.cyH()))
      {
        ae.w("MicroMsg.ImageGalleryUI", "video info is null, return now.");
        AppMethodBeat.o(187552);
        return;
      }
      if (localbv.cyH())
      {
        localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.EGd;
        com.tencent.mm.plugin.webview.ui.tools.media.a.jj(fKv(), fKu());
      }
    }
    if (this.nMW == null) {
      this.nMW = new com.tencent.mm.ui.widget.a.e(getContext(), 0, true);
    }
    if ((bn.z(localbv)) && (!fEp())) {
      if (fKm()) {
        this.nMW.LsQ = new ImageGalleryUI.13(this);
      }
    }
    for (;;)
    {
      this.nMW.LfT = this.pSA;
      this.nMW.LsT = this.pSA;
      this.nMW.LsU = this.pSA;
      this.nMW.KtV = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(187515);
          ImageGalleryUI.H(ImageGalleryUI.this);
          ImageGalleryUI.e(ImageGalleryUI.this).onDismiss();
          AppMethodBeat.o(187515);
        }
      };
      this.nMW.LsV = new e.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(187516);
          if (ImageGalleryUI.this.Kkv == null)
          {
            AppMethodBeat.o(187516);
            return;
          }
          Object localObject = ImageGalleryUI.this.Kkv.fJS();
          if ((localObject != null) && (((bv)localObject).cyH()))
          {
            localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.EGd;
            com.tencent.mm.plugin.webview.ui.tools.media.a.aF(3, ImageGalleryUI.I(ImageGalleryUI.this), ImageGalleryUI.J(ImageGalleryUI.this));
          }
          AppMethodBeat.o(187516);
        }
      };
      this.nMW.cPF();
      AppMethodBeat.o(187552);
      return;
      if (bn.B(localbv))
      {
        AppMethodBeat.o(187552);
        return;
      }
      this.nMW.LfS = new ImageGalleryUI.14(this, localbv);
      this.nMW.LsQ = new ImageGalleryUI.15(this, localbv);
      this.nMW.LsR = new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(187514);
          paramAnonymousl.clear();
          ScanCodeSheetItemLogic localScanCodeSheetItemLogic;
          int i;
          String str1;
          Object localObject;
          if ((ImageGalleryUI.d(ImageGalleryUI.this, 2)) && (ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.b(ImageGalleryUI.this).yCU)))
          {
            localScanCodeSheetItemLogic = ImageGalleryUI.e(ImageGalleryUI.this);
            i = ImageGalleryUI.b(ImageGalleryUI.this).dov;
            str1 = ImageGalleryUI.b(ImageGalleryUI.this).yCU;
            localObject = ImageGalleryUI.d(ImageGalleryUI.this);
            if ((localScanCodeSheetItemLogic.yzd != null) && ((bu.lX(localScanCodeSheetItemLogic.yzd.GNc, str1)) || (localScanCodeSheetItemLogic.yzd == localScanCodeSheetItemLogic.yze))) {
              break label270;
            }
            if (com.tencent.mm.plugin.scanner.g.bT(i, str1))
            {
              localObject = new com.tencent.mm.ui.base.m(paramAnonymousl.mContext, 3, 0);
              ((com.tencent.mm.ui.base.m)localObject).JGO = true;
              paramAnonymousl.JGM.add(localObject);
            }
          }
          else if ((ImageGalleryUI.d(ImageGalleryUI.this, 1)) && (!bu.isNullOrNil(ImageGalleryUI.a(ImageGalleryUI.this))))
          {
            paramAnonymousl.a(7, ImageGalleryUI.this.getString(2131757184), 2131690669);
            paramAnonymousl = new ce();
            if (ImageGalleryUI.n(ImageGalleryUI.this) != 2) {
              break label1018;
            }
          }
          label270:
          label1018:
          for (long l = 1L;; l = 0L)
          {
            paramAnonymousl.dWt = l;
            paramAnonymousl.dQB = 2L;
            paramAnonymousl.edv = 4L;
            paramAnonymousl.aLH();
            AppMethodBeat.o(187514);
            return;
            paramAnonymousl.a(3, localScanCodeSheetItemLogic.OT(i), 2131690640);
            break;
            if ((localScanCodeSheetItemLogic.yzd.Ret != 0) || (bu.isNullOrNil(localScanCodeSheetItemLogic.yzd.nIJ)))
            {
              if ((com.tencent.mm.plugin.scanner.g.bN(i, str1)) || (com.tencent.mm.plugin.scanner.g.bP(i, str1)) || (com.tencent.mm.plugin.scanner.g.bO(i, str1)) || (com.tencent.mm.plugin.scanner.g.bQ(i, str1)))
              {
                paramAnonymousl.a(3, localScanCodeSheetItemLogic.mContext.getString(2131767145), 2131690640, localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099732));
                break;
              }
              if (com.tencent.mm.plugin.scanner.g.bM(i, str1))
              {
                paramAnonymousl.a(3, localScanCodeSheetItemLogic.mContext.getString(2131767147), 2131690640, localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099732));
                break;
              }
              if (com.tencent.mm.plugin.scanner.g.bS(i, str1))
              {
                paramAnonymousl.a(3, localScanCodeSheetItemLogic.mContext.getString(2131767144), 2131690680, localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099732));
                break;
              }
              if (com.tencent.mm.plugin.scanner.g.bR(i, str1))
              {
                paramAnonymousl.a(3, localScanCodeSheetItemLogic.mContext.getString(2131767146), 2131690628, localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099732));
                break;
              }
              localObject = localScanCodeSheetItemLogic.mContext.getString(2131767145);
              if (!e.d.YK(i)) {
                localObject = localScanCodeSheetItemLogic.mContext.getString(2131767143);
              }
              paramAnonymousl.a(3, (CharSequence)localObject, 2131690640, localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099732));
              break;
            }
            str1 = localScanCodeSheetItemLogic.yzd.nIJ;
            ((com.tencent.mm.ui.widget.a.e)localObject).LsW = new ScanCodeSheetItemLogic.5(localScanCodeSheetItemLogic);
            if (localScanCodeSheetItemLogic.yzd.GXH == 4)
            {
              paramAnonymousl.a(str1, localScanCodeSheetItemLogic.mContext.getString(2131767138), 0);
              break;
            }
            if (localScanCodeSheetItemLogic.yzd.GXH == 3)
            {
              paramAnonymousl.a(str1, localScanCodeSheetItemLogic.mContext.getString(2131767140), 0);
              break;
            }
            if (localScanCodeSheetItemLogic.yzd.GXH == 1)
            {
              paramAnonymousl.a(str1, localScanCodeSheetItemLogic.mContext.getString(2131767149), 0);
              break;
            }
            if (localScanCodeSheetItemLogic.yzd.GXH == 2)
            {
              paramAnonymousl.a(str1, localScanCodeSheetItemLogic.mContext.getString(2131767142), localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099732));
              break;
            }
            if (localScanCodeSheetItemLogic.yzd.GXH == 7)
            {
              localObject = new SpannableStringBuilder();
              str1 = str1 + " ";
              ((SpannableStringBuilder)localObject).append(str1);
              String str2 = "@" + localScanCodeSheetItemLogic.yzd.GXJ;
              ((SpannableStringBuilder)localObject).append(str2);
              ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099777)), str1.length(), str1.length() + str2.length(), 33);
              paramAnonymousl.a((CharSequence)localObject, localScanCodeSheetItemLogic.mContext.getString(2131767151), 0);
              break;
            }
            if (localScanCodeSheetItemLogic.yzd.GXH == 6)
            {
              paramAnonymousl.a(bu.x(localScanCodeSheetItemLogic.mContext.getString(2131762856), new Object[] { localScanCodeSheetItemLogic.yzd.nIJ }), localScanCodeSheetItemLogic.mContext.getString(2131767148), localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099732));
              break;
            }
            if (localScanCodeSheetItemLogic.yzd.GXH != 5) {
              break;
            }
            paramAnonymousl.a(bu.x(localScanCodeSheetItemLogic.mContext.getString(2131762875), new Object[] { localScanCodeSheetItemLogic.yzd.nIJ }), localScanCodeSheetItemLogic.mContext.getString(2131767150), localScanCodeSheetItemLogic.mContext.getResources().getColor(2131099732));
            break;
          }
        }
      };
    }
  }
  
  public final void cyS()
  {
    AppMethodBeat.i(36184);
    ae.i("MicroMsg.ImageGalleryUI", "hide video tool bar");
    ys(false);
    aG(fKd().BAO, 8);
    aG(fKd().Jip, 8);
    aG(this.KmM, 8);
    aG(this.EGj, 8);
    AppMethodBeat.o(36184);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(36195);
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
    {
      if (this.nMW != null)
      {
        this.nMW.bqD();
        this.nMW = null;
      }
      for (;;)
      {
        AppMethodBeat.o(36195);
        return true;
        if ((this.rHg == 0) || (this.rHg == 2)) {
          cZZ();
        } else {
          cZZ();
        }
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(36195);
    return bool;
  }
  
  public final boolean eul()
  {
    AppMethodBeat.i(36193);
    boolean bool = fKd().BAO.cgS();
    AppMethodBeat.o(36193);
    return bool;
  }
  
  public final void fKB()
  {
    AppMethodBeat.i(36201);
    cyS();
    fKc().KmV.setVisibility(0);
    fKc().KmW.setVisibility(8);
    fKc().KmX.setVisibility(0);
    fKc().KmY.setVisibility(8);
    fKc().KmX.setText("0%");
    AppMethodBeat.o(36201);
  }
  
  final ImageGalleryUI fKc()
  {
    AppMethodBeat.i(36152);
    if (this.KmV == null)
    {
      this.KmV = findViewById(2131300930);
      this.KmW = ((Button)this.KmV.findViewById(2131298876));
      this.KmX = ((Button)this.KmV.findViewById(2131298877));
      this.KmY = this.KmV.findViewById(2131298878);
      TextView localTextView = (TextView)this.KmV.findViewById(2131298872);
      this.KmW.getPaint().setFakeBoldText(true);
      this.KmX.getPaint().setFakeBoldText(true);
      localTextView.getPaint().setFakeBoldText(true);
      float f = Math.min(1.125F, com.tencent.mm.cb.a.ef(this));
      this.KmW.setTextSize(1, 12.0F * f);
      this.KmX.setTextSize(1, f * 12.0F);
    }
    AppMethodBeat.o(36152);
    return this;
  }
  
  protected final ImageGalleryUI fKd()
  {
    AppMethodBeat.i(36153);
    if (this.BAO == null)
    {
      this.BAO = ((RedesignVideoPlayerSeekBar)findViewById(2131306375));
      this.Jip = findViewById(2131308530);
      this.BAO.setPlayBtnOnClickListener(this);
    }
    AppMethodBeat.o(36153);
    return this;
  }
  
  public final void fKn()
  {
    AppMethodBeat.i(224195);
    ym(false);
    AppMethodBeat.o(224195);
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(36175);
    if (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) {
      ae.d("MicroMsg.ImageGalleryUI", "hideOpLayer isShowOpToolbar: %b, %s", new Object[] { Boolean.valueOf(this.KnL), bu.fpN() });
    }
    if (!this.KnL)
    {
      AppMethodBeat.o(36175);
      return;
    }
    this.KnL = false;
    eYI();
    AppMethodBeat.o(36175);
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(36176);
    this.rNw.stopTimer();
    this.KmO.setVisibility(8);
    fKe().KmN.clearAnimation();
    aG(fKe().KmN, 8);
    aG(fKf().KmP, 8);
    this.KmQ.setVisibility(8);
    aG(fKg().KmR, 8);
    aG(fKi().KmT, 8);
    aG(fKj().KmU, 8);
    cyS();
    mY(false);
    yr(false);
    this.KmA.setVisibility(8);
    AppMethodBeat.o(36176);
  }
  
  protected final void fKy()
  {
    AppMethodBeat.i(36182);
    if (this.KnL)
    {
      if (fKw())
      {
        this.rNw.ay(3000L, 3000L);
        AppMethodBeat.o(36182);
        return;
      }
      this.rNw.ay(5000L, 5000L);
    }
    AppMethodBeat.o(36182);
  }
  
  public void finish()
  {
    AppMethodBeat.i(36203);
    this.KcT.clear();
    super.finish();
    AppMethodBeat.o(36203);
  }
  
  public final int getCurrentItem()
  {
    AppMethodBeat.i(224196);
    int i = this.tZe.getCurrentItem();
    AppMethodBeat.o(224196);
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
    this.oMQ = new com.tencent.mm.ui.tools.e(getContext());
    this.isAnimated = false;
    this.talker = getIntent().getStringExtra("img_gallery_talker");
    this.Knl = getIntent().getBooleanExtra("img_gallery_enter_from_grid", false);
    this.Khw = getIntent().getBooleanExtra("img_gallery_enter_from_chatting_ui", false);
    this.Knn = getIntent().getBooleanExtra("img_gallery_enter_from_appbrand_service_chatting_ui", false);
    this.Khv = getIntent().getBooleanExtra("show_search_chat_content_result", false);
    this.Knk = getIntent().getBooleanExtra("show_enter_grid", true);
    this.rCv = getIntent().getBooleanExtra("key_is_biz_chat", false);
    this.oex = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.KmB = getIntent().getBooleanExtra("img_preview_only", false);
    this.Knp = getIntent().getIntExtra("img_gallery_enter_from_scene", 0);
    this.JSr = getIntent().getIntExtra("msg_type", 0);
    if ((!this.KmB) && (bu.isNullOrNil(this.talker))) {
      ae.e("MicroMsg.ImageGalleryUI", " initView, talker is null. intent: " + getIntent());
    }
    this.chatroomName = getIntent().getStringExtra("img_gallery_chatroom_name");
    this.Knm = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
    this.Knr = getIntent().getStringExtra("img_gallery_enter_video_opcode");
    boolean bool2 = getIntent().getBooleanExtra("img_gallery_is_restransmit_after_download", false);
    Object localObject2 = getIntent().getStringExtra("img_gallery_directly_send_name");
    this.rHj = ((ImageView)findViewById(2131304342));
    this.rHk = ((ImageView)findViewById(2131304340));
    Object localObject1 = (FrameLayout.LayoutParams)this.rHk.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject1).bottomMargin += com.tencent.mm.ui.ar.en(this);
    this.rHk.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.rHk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187544);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new com.tencent.mm.g.a.aw();
        paramAnonymousView.dmL.scene = 1;
        paramAnonymousView.dmL.dmM = ImageGalleryUI.p(ImageGalleryUI.this);
        com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
        ImageGalleryUI.o(ImageGalleryUI.this);
        ImageGalleryUI.q(ImageGalleryUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187544);
      }
    });
    this.rHi = ((ImageView)findViewById(2131304343));
    this.rHl = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.rHl.setDuration(5000L);
    this.rHl.addListener(new ImageGalleryUI.7(this));
    int i = getWindowManager().getDefaultDisplay().getHeight();
    this.rHl.addUpdateListener(new ImageGalleryUI.8(this, i));
    this.msgId = getIntent().getLongExtra("img_gallery_msg_id", 0L);
    this.KkF = getIntent().getBooleanExtra("img_gallery_is_mp_video_without_msg", false);
    this.Kno = getIntent().getIntExtra("img_gallery_mp_video_click_from", 2);
    long l = getIntent().getLongExtra("img_gallery_msg_svr_id", 0L);
    if (!this.KkF)
    {
      if ((this.msgId <= 0L) && (l == 0L))
      {
        ae.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.msgId + ", msgSvrId = " + l + ", stack = " + bu.fpN());
        finish();
        AppMethodBeat.o(36163);
        return;
      }
      if (this.msgId == 0L)
      {
        bc.aCg();
        this.msgId = com.tencent.mm.model.c.azI().aJ(fKl(), l).field_msgId;
      }
      bc.aCg();
      localObject1 = com.tencent.mm.model.c.azI().ys(this.msgId);
      if (((ei)localObject1).field_msgId <= 0L)
      {
        ae.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.msgId + ", msgSvrId = " + l + ", stack = " + bu.fpN());
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
      if (EL(this.msgId) == 3)
      {
        bool1 = true;
        this.Kns = bool1;
        this.Kkv = new b(this, this.msgId, fKl(), this.rCv, this.oex, bool2, (String)localObject2, Boolean.valueOf(this.Knm), this.JSr);
        this.Kkv.KkG = false;
        this.Kkv.Kkz = getIntent().getBooleanExtra("start_chatting_ui", true);
        this.Kkv.KkE = new b.c()
        {
          public final void ta()
          {
            AppMethodBeat.i(187545);
            if (ImageGalleryUI.this.Kkv == null)
            {
              AppMethodBeat.o(187545);
              return;
            }
            ImageGalleryUI.this.fKn();
            ImageGalleryUI.r(ImageGalleryUI.this);
            ImageGalleryUI.this.Kkv.onPageSelected(b.a.KkQ);
            AppMethodBeat.o(187545);
          }
        };
        localObject2 = this.Kkv;
        n localn = this.KlR;
        if (((b)localObject2).KkB != null) {
          ((b)localObject2).KkB.KlR = localn;
        }
        com.tencent.mm.ui.chatting.gallery.a.e.init();
        if (this.KmB) {
          break label1517;
        }
        bool1 = true;
        label885:
        this.Knf = new com.tencent.mm.ui.chatting.gallery.a.j(this, bool1);
        this.Kng = new com.tencent.mm.ui.chatting.gallery.a.g();
        if ((!com.tencent.mm.ui.chatting.gallery.a.e.fKZ()) || (!fKs())) {
          break label1522;
        }
        bool1 = true;
        label924:
        this.Kne = bool1;
        ae.i("MicroMsg.ImageGalleryUI", "initScanCode isPreviewOnly: %b, canShowScanCodeButton: %b, isEnterFromChattingUI: %b, isEnterFromGrid: %b", new Object[] { Boolean.valueOf(this.KmB), Boolean.valueOf(this.Kne), Boolean.valueOf(this.Khw), Boolean.valueOf(this.Knl) });
        this.KmE = 0;
        this.KmF = getResources().getDimensionPixelSize(2131167081);
        this.KmG = getResources().getDimensionPixelSize(2131167080);
        this.rNn = ((RelativeLayout)findViewById(2131298875));
        this.KmA = ((RelativeLayout)findViewById(2131298880));
        this.rNn.setOnClickListener(new ImageGalleryUI.2(this));
        this.KmM = findViewById(2131306316);
        this.KmM.setOnClickListener(this);
        this.KmO = findViewById(2131306373);
        this.KmQ = findViewById(2131307467);
        if (!bk(this)) {
          break label1527;
        }
        eYK();
        label1111:
        this.iXI = ((ImageView)findViewById(2131300336));
        this.tZe = ((MMViewPager)findViewById(2131300335));
        this.tZe.setVerticalFadingEdgeEnabled(false);
        this.tZe.setHorizontalFadingEdgeEnabled(false);
        this.tZe.setSingleClickOverListener(new MMViewPager.e()
        {
          public final void aRO()
          {
            AppMethodBeat.i(187491);
            ImageGalleryUI.s(ImageGalleryUI.this);
            AppMethodBeat.o(187491);
          }
          
          public final void cYT()
          {
            AppMethodBeat.i(187492);
            ImageGalleryUI.t(ImageGalleryUI.this);
            AppMethodBeat.o(187492);
          }
        });
        if (this.KmB) {
          break label1534;
        }
        this.tZe.setOnPageChangeListener(this.KnG);
        this.tZe.setLongClickOverListener(new MMViewPager.c()
        {
          public final void aRP()
          {
            AppMethodBeat.i(187493);
            if (ImageGalleryUI.n(ImageGalleryUI.this) == 1)
            {
              AppMethodBeat.o(187493);
              return;
            }
            ImageGalleryUI.u(ImageGalleryUI.this);
            Object localObject;
            if ((ImageGalleryUI.n(ImageGalleryUI.this) == 0) || (ImageGalleryUI.n(ImageGalleryUI.this) == 2))
            {
              localObject = new ce();
              if (ImageGalleryUI.n(ImageGalleryUI.this) != 2) {
                break label134;
              }
            }
            label134:
            for (long l = 1L;; l = 0L)
            {
              ((ce)localObject).dWt = l;
              ((ce)localObject).dQB = 1L;
              ((ce)localObject).edv = 4L;
              ((ce)localObject).aLH();
              localObject = ImageGalleryUI.a(ImageGalleryUI.this);
              ImageGalleryUI.a(ImageGalleryUI.this, com.tencent.mm.vfs.o.k((String)localObject, false), ImageGalleryUI.l(ImageGalleryUI.this));
              ImageGalleryUI.this.cZZ();
              AppMethodBeat.o(187493);
              return;
            }
          }
        });
        label1203:
        this.tZe.setOffscreenPageLimit(1);
        this.tZe.setAdapter(this.Kkv);
        aet(b.a.KkQ);
        this.tZe.setCurrentItem(b.a.KkQ);
        this.tZe.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187494);
            if (ImageGalleryUI.this.Kkv == null)
            {
              AppMethodBeat.o(187494);
              return;
            }
            if ((h.a.fKb().rKJ) && (ImageGalleryUI.v(ImageGalleryUI.this) != null))
            {
              ImageGalleryUI.v(ImageGalleryUI.this).setChecked(h.a.fKb().co(ImageGalleryUI.this.Kkv.fJS()));
              ImageGalleryUI.w(ImageGalleryUI.this).setOnClickListener(ImageGalleryUI.this);
            }
            int i = b.a.KkQ;
            if (ImageGalleryUI.this.tZe.getCurrentItem() != i)
            {
              AppMethodBeat.o(187494);
              return;
            }
            ImageGalleryUI.this.fKy();
            b.b localb = b.cb(ImageGalleryUI.this.Kkv.adI(i));
            if ((!ImageGalleryUI.this.Knm) && (localb == b.b.Klh)) {
              ImageGalleryUI.this.Kkv.aeh(i);
            }
            if (localb == b.b.Kli) {
              ImageGalleryUI.this.Kkv.ael(i);
            }
            AppMethodBeat.o(187494);
          }
        }, 0L);
        if (h.a.fKb().rKJ)
        {
          this.Knz = ((ViewStub)findViewById(2131304544)).inflate();
          this.Knz.setVisibility(0);
          this.KnA = ((CheckBox)this.Knz.findViewById(2131302204));
          this.KnB = this.Knz.findViewById(2131302205);
        }
        this.Knb = getIntent().getBooleanExtra("img_gallery_enter_PhotoEditUI", false);
        localObject1 = this.Kkv.h((bv)localObject1, true);
        if (localObject1 == null) {
          ae.e("MicroMsg.ImageGalleryUI", "[initView] imgInfo is null!!! isSoonEnterPhotoEdit:%s", new Object[] { Boolean.valueOf(this.Knb) });
        }
        if ((!this.Knb) || (localObject1 == null) || (!((com.tencent.mm.av.g)localObject1).aIA())) {
          break label1541;
        }
        fKD();
        this.Knb = false;
      }
      for (;;)
      {
        this.tZe.setOnTouchListener(new ImageGalleryUI.6(this));
        if (fEp())
        {
          this.KmO.setVisibility(8);
          aG(fKe().KmN, 8);
          aG(fKf().KmP, 8);
          aG(this.KmQ, 8);
          aG(fKg().KmR, 8);
          aG(fKi().KmT, 8);
          aG(fKj().KmU, 8);
        }
        AppMethodBeat.o(36163);
        return;
        bool1 = false;
        break;
        label1517:
        bool1 = false;
        break label885;
        label1522:
        bool1 = false;
        break label924;
        label1527:
        eYL();
        break label1111;
        label1534:
        fKp();
        break label1203;
        label1541:
        if (this.Knb) {
          ae.w("MicroMsg.ImageGalleryUI", "img not GetCompleted!");
        }
      }
    }
  }
  
  public final void k(bv parambv, boolean paramBoolean)
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
        AppMethodBeat.i(187570);
        if ((parambv == null) || (!parambv.cyH()))
        {
          if (this.EGj != null) {
            this.EGj.setVisibility(8);
          }
          this.Kmz = b.cb(parambv);
          ae.i("MicroMsg.ImageGalleryUI", "updateFooterInfo currGalleryType: %s, pageChanged: %b", new Object[] { this.Kmz, Boolean.valueOf(paramBoolean) });
          if ((h.a.fKb().rKJ) && (this.KnA != null)) {
            this.KnA.setChecked(h.a.fKb().co(parambv));
          }
        }
        switch (36.KkK[this.Kmz.ordinal()])
        {
        case 1: 
          ym(paramBoolean);
          AppMethodBeat.o(187570);
          return;
          if (this.EGj == null)
          {
            this.EGj = ((ViewStub)findViewById(2131300342)).inflate();
            this.rYg = findViewById(2131302498);
            this.fTj = ((ImageView)findViewById(2131302497));
            this.KnJ = ((ImageView)findViewById(2131302510));
            this.ovs = ((TextView)findViewById(2131302508));
            this.ovt = ((MMNeat7extView)findViewById(2131302513));
            this.KnH = ((TextView)findViewById(2131302515));
            this.ovs.getPaint().setFakeBoldText(true);
            this.KnH.getPaint().setFakeBoldText(true);
            this.ovt.getPaint().setFakeBoldText(true);
            this.KnI = findViewById(2131302514);
            this.EGj.setOnClickListener(new ImageGalleryUI.25(this));
          }
          boolean bool = com.tencent.mm.ui.ar.jY(this);
          i = com.tencent.mm.ui.ar.en(this);
          if ((this.vYq) && (bool))
          {
            if (bk(this)) {
              fKC();
            }
          }
          else
          {
            localObject1 = j.cq(parambv);
            if (localObject1 != null) {
              break label389;
            }
            ae.w("MicroMsg.ImageGalleryUI", "fillMpVideoInfoLayout mpShareVideoInfo is null");
            continue;
          }
          aez(i);
        }
      }
      finally {}
      continue;
      this.ovt.aq(((y)localObject1).title);
      localObject2 = new k.b();
      ((k.b)localObject2).dIu = ((y)localObject1).hFW;
      ((k.b)localObject2).dIt = ((y)localObject1).dpP;
      af.a(this, (k.b)localObject2, this.fTj, this.ovs);
      this.rYg.setOnClickListener(new ImageGalleryUI.26(this, (y)localObject1));
      this.KnI.setOnClickListener(new ImageGalleryUI.27(this, (y)localObject1));
      com.tencent.mm.ui.tools.o.gZ(this.rYg);
      com.tencent.mm.ui.tools.o.gZ(this.KnI);
      if (((y)localObject1).FUw != null)
      {
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(((y)localObject1).FUw, -1, 2, new Object[0]);
        this.KnI.setVisibility(0);
      }
      for (;;)
      {
        localObject1 = (LinearLayout.LayoutParams)this.KnJ.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).height = ((int)(this.KnH.getTextSize() * 1.45D));
        ((LinearLayout.LayoutParams)localObject1).width = ((LinearLayout.LayoutParams)localObject1).height;
        this.KnJ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (!this.KkF) {
          break;
        }
        ym(false);
        cyT();
        break;
        this.KnI.setVisibility(8);
      }
      aG(this.KmV, 4);
      setVideoStateIv(true);
      parambv = j.cp(parambv);
      if (parambv != null) {
        break;
      }
      AppMethodBeat.o(187570);
    }
    fKd().BAO.setVideoTotalTime(parambv.hKI);
    for (;;)
    {
      try
      {
        if ((this.Kkv.fJT() == null) || (this.Kkv.fJT().KoL == null)) {
          break label1003;
        }
        i = this.Kkv.fJT().KoL.getCurrentPosition() / 1000;
        fKd().BAO.seek(i);
      }
      catch (Exception parambv)
      {
        ae.printErrStackTrace("MicroMsg.ImageGalleryUI", parambv, "", new Object[0]);
        break label1003;
      }
      localObject1 = this.Kkv.h(parambv, false);
      cyS();
      ym(paramBoolean);
      if (localObject1 == null)
      {
        ae.w("MicroMsg.ImageGalleryUI", "updateFooterInfo img info is null");
        AppMethodBeat.o(187570);
        break label151;
      }
      if ((this.Knb) && (((com.tencent.mm.av.g)localObject1).aIA()) && (this.Kkv.fJS() != null) && (parambv.field_msgId == this.Kkv.fJS().field_msgId))
      {
        ae.i("MicroMsg.ImageGalleryUI", "get image successfully! -> gotoPhotoEditUI msgId:%s", new Object[] { Long.valueOf(parambv.field_msgId) });
        fKD();
        this.Knb = false;
        AppMethodBeat.o(187570);
        break label151;
      }
      localObject2 = this.Kkv.fJS();
      paramBoolean = this.Knb;
      long l = parambv.field_msgId;
      if (localObject2 == null) {}
      for (parambv = "null";; parambv = Long.valueOf(((ei)localObject2).field_msgId))
      {
        ae.w("MicroMsg.ImageGalleryUI", "isSoonEnterPhotoEdit:%s msgId:%s curMsgId:%s getCompleted:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l), parambv, Boolean.valueOf(((com.tencent.mm.av.g)localObject1).aIA()) });
        AppMethodBeat.o(187570);
        break;
      }
      cyS();
      break;
      cyS();
      ym(paramBoolean);
      aG(this.KmV, 4);
      this.Kkv.ael(this.tZe.getCurrentItem());
      AppMethodBeat.o(187570);
      break label151;
      break;
      label1003:
      i = 0;
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
    if ((this.Ewq != null) && (this.Ewq.d(this, paramInt1, paramInt2, paramIntent)))
    {
      AppMethodBeat.o(36173);
      return;
    }
    AppMethodBeat.o(36173);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(36161);
    ae.i("MicroMsg.ImageGalleryUI", "onBackPressed");
    if (this.Knl)
    {
      aev(1);
      AppMethodBeat.o(36161);
      return;
    }
    try
    {
      h.a.fKb().detach();
      bYa();
      AppMethodBeat.o(36161);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.ImageGalleryUI", localException.getMessage());
      finish();
      AppMethodBeat.o(36161);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(36191);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if (this.Kkv == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131299498) {
      aev(0);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36191);
      return;
      if (paramView.getId() == 2131306373)
      {
        this.KmC = false;
        cZZ();
        if ((aes(2)) && (aXS(this.Knd.yCU))) {
          this.Knt.bV(this.Knd.dov, this.Knd.yCU);
        }
      }
      else if (paramView.getId() == 2131299194)
      {
        ae.i("MicroMsg.ImageGalleryUI", "[oreh download_and_save] hdImg suc, curPos:%d", new Object[] { Integer.valueOf(this.tZe.getCurrentItem()) });
        paramView = this.Kkv.adI(this.tZe.getCurrentItem());
        localObject = this.Kkv.h(paramView, false);
        this.tZe.getCurrentItem();
        if ((f(paramView, (com.tencent.mm.av.g)localObject)) && (!paramView.fvU()) && (((com.tencent.mm.av.g)localObject).aIA())) {
          this.Kkv.bm(this.tZe.getCurrentItem(), true);
        } else {
          b.c(getContext(), this.Kkv.fJS(), true);
        }
      }
      else if (paramView.getId() == 2131298876)
      {
        this.rHg = 2;
        this.rHf = 0;
        this.Kkv.bm(this.tZe.getCurrentItem(), false);
      }
      else if (paramView.getId() == 2131298877)
      {
        this.Kkv.aek(this.tZe.getCurrentItem());
        aet(this.tZe.getCurrentItem());
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
        boolean bool = this.KnA.isChecked();
        if ((!bool) && (h.a.fKb().rKI.size() >= 9))
        {
          Toast.makeText(this, getResources().getString(2131759803, new Object[] { Integer.valueOf(9) }), 1).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36191);
          return;
        }
        paramView = this.KnA;
        if (!bool) {}
        for (bool = true;; bool = false)
        {
          paramView.setChecked(bool);
          if (!this.KnA.isChecked()) {
            break label545;
          }
          h.a.fKb().cm(this.Kkv.fJS());
          break;
        }
        label545:
        h.a.fKb().cn(this.Kkv.fJS());
      }
      else if (paramView.getId() == 2131303281)
      {
        this.Kkv.fJT();
        this.Kkv.aeh(this.tZe.getCurrentItem());
      }
      else if (paramView.getId() == 2131307467)
      {
        this.Knu.aeG(3);
        yk(true);
      }
      else if (paramView.getId() == 2131308314)
      {
        fKg().KmR.setOnClickListener(null);
        this.Knu.aeG(2);
        yj(true);
      }
      else if (paramView.getId() == 2131308491)
      {
        fKi().KmT.setOnClickListener(null);
        paramView = this.Knu.KpP;
        if (paramView != null) {
          paramView.doj = 3;
        }
        this.Knu.jX(2, 3);
        yt(true);
        this.Knu.jX(3, 3);
      }
      else if (paramView.getId() == 2131308517)
      {
        fKj().KmU.setBubbleClickListener(null);
        this.Knu.jX(2, 4);
        yt(true);
        this.Knu.jX(3, 4);
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(36206);
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      ae.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is vertical screen", new Object[] { Integer.valueOf(hashCode()) });
      this.KmJ = true;
      eYK();
      AppMethodBeat.o(36206);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      ae.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is horizontal screen", new Object[] { Integer.valueOf(hashCode()) });
      this.KmJ = true;
      eYL();
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
    this.KnC = true;
    super.onCreate(paramBundle);
    this.Knu.aeD(1);
    if (com.tencent.mm.compatible.util.d.lA(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (this.vYq = true;; this.vYq = false)
    {
      setLightNavigationbarIcon();
      initView();
      this.oMP = paramBundle;
      com.tencent.mm.sdk.b.a.IvT.c(this.rHm);
      this.BAY = false;
      this.Knt = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.b()
      {
        public final void ahM(String paramAnonymousString)
        {
          AppMethodBeat.i(187543);
          if ((ImageGalleryUI.d(ImageGalleryUI.this) != null) && (ImageGalleryUI.d(ImageGalleryUI.this).isShowing()) && (bu.lX(paramAnonymousString, ImageGalleryUI.b(ImageGalleryUI.this).yCU))) {
            ImageGalleryUI.this.cZZ();
          }
          AppMethodBeat.o(187543);
        }
      });
      ae.d("MicroMsg.ImageGalleryUI", "ImageGallery onCreate spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
    ae.i("MicroMsg.ImageGalleryUI", "%d image gallery ui on destroy", new Object[] { Integer.valueOf(hashCode()) });
    Object localObject2;
    Object localObject3;
    Object localObject4;
    long l;
    try
    {
      if (this.Kkv != null)
      {
        aeu(this.KnD);
        this.KmD.a(this, this.KnD, 0);
        this.Kkv.detach();
        this.Kkv = null;
      }
      this.rNw.stopTimer();
      cyf();
      this.rHl.removeAllUpdateListeners();
      com.tencent.mm.sdk.b.a.IvT.d(this.rHm);
      com.tencent.mm.kernel.g.ajQ().b(this.rHn);
      Object localObject1 = new qr();
      ((qr)localObject1).dGr.activity = this;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      if (this.BAO != null) {
        this.BAO.setPlayBtnOnClickListener(null);
      }
      this.BAO = null;
      fKk();
      if (this.Knf != null)
      {
        localObject1 = this.Knf;
        if (((com.tencent.mm.ui.chatting.gallery.a.j)localObject1).Kqj)
        {
          ((com.tencent.mm.ui.chatting.gallery.a.j)localObject1).Kqp.dead();
          ((com.tencent.mm.ui.chatting.gallery.a.j)localObject1).Kqq.dead();
          ((com.tencent.mm.ui.chatting.gallery.a.j)localObject1).Kqr.dead();
        }
        localObject2 = ((com.tencent.mm.ui.chatting.gallery.a.j)localObject1).Kqk.keySet();
        p.g(localObject2, "scanCodeRequestMap.keys");
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            Object localObject5 = (String)((Iterator)localObject2).next();
            localObject3 = (j.b)((com.tencent.mm.ui.chatting.gallery.a.j)localObject1).Kqk.get(localObject5);
            localObject4 = new av();
            ((av)localObject4).dmJ.filePath = ((String)localObject5);
            localObject5 = ((av)localObject4).dmJ;
            if (localObject3 != null)
            {
              l = ((j.b)localObject3).dmK;
              ((av.a)localObject5).dmK = l;
              com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject4);
              continue;
              if (!com.tencent.mm.graphics.b.c.gxq.gxv) {
                break;
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.ImageGalleryUI", localException, "", new Object[0]);
    }
    for (;;)
    {
      com.tencent.mm.graphics.b.c.gxq.stop();
      super.onDestroy();
      AppMethodBeat.o(36160);
      return;
      l = 0L;
      break;
      localException.Kqk.clear();
      localException.Kql.clear();
      localException.Kqm.clear();
      ae.v("MicroMsg.ImageScanCodeManager", "releaseHandleCode");
      localObject2 = localException.Kqn.keySet();
      p.g(localObject2, "handleCodeRequestMap.keys");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = new au();
        ((au)localObject4).dmH.activity = localException.dtg;
        ((au)localObject4).dmH.dmI = ((String)localObject3);
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject4);
      }
      localException.Kqo.clear();
      if (this.Knj != null)
      {
        com.tencent.mm.ui.chatting.gallery.a.l locall = this.Knj;
        ae.d("MicroMsg.ImageSearchPreviewManager", "alvinluo release previewImage session size: %d", new Object[] { Integer.valueOf(locall.KqA.size()) });
        localObject2 = ((Map)locall.KqC).entrySet().iterator();
        while (((Iterator)localObject2).hasNext()) {
          com.tencent.mm.ui.chatting.gallery.a.l.zs(((Number)((Map.Entry)((Iterator)localObject2).next()).getKey()).longValue());
        }
        locall.KqB.clear();
        locall.KqA.clear();
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
    ae.i("MicroMsg.ImageGalleryUI", "on pause");
    super.onPause();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(2048, 2048);
    }
    if ((!isFinishing()) && (this.Kkv != null))
    {
      b localb = this.Kkv;
      localb.KkC.Kon.sendEmptyMessageDelayed(1, 200L);
      localb.KkD.OA();
    }
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    fKj().KmU.setBubbleClickListener(this);
    fKi().KmT.setOnClickListener(this);
    AppMethodBeat.o(36150);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(36158);
    super.onResume();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().clearFlags(2048);
    }
    if ((!this.KnC) && (this.Kkv != null)) {
      aet(this.tZe.getCurrentItem());
    }
    this.KnC = false;
    if (this.Kkv != null) {
      this.Kkv.fJU();
    }
    com.tencent.mm.kernel.g.ajQ().a(this.rHn);
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    AppMethodBeat.o(36158);
  }
  
  public void onStart()
  {
    boolean bool = true;
    AppMethodBeat.i(36159);
    this.Knm = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
    Bundle localBundle;
    if (!this.KmB)
    {
      localBundle = this.oMP;
      ae.i("MicroMsg.ImageGalleryUI", "[handleAnimation] isAnimated:" + this.isAnimated);
      if (!this.isAnimated)
      {
        this.isAnimated = true;
        if (Build.VERSION.SDK_INT >= 12)
        {
          this.oMR = getIntent().getIntExtra("img_gallery_top", 0);
          this.oMS = getIntent().getIntExtra("img_gallery_left", 0);
          this.oMT = getIntent().getIntExtra("img_gallery_width", 0);
          this.oMU = getIntent().getIntExtra("img_gallery_height", 0);
          if ((this.oMR == 0) && (this.oMS == 0) && (this.oMT == 0) && (this.oMU == 0))
          {
            bv localbv = this.Kkv.adI(this.tZe.getCurrentItem());
            if (localbv != null)
            {
              bd localbd = new bd();
              localbd.dmZ.dlw = localbv;
              com.tencent.mm.sdk.b.a.IvT.l(localbd);
              this.oMT = localbd.dna.dnd;
              this.oMU = localbd.dna.dne;
              this.oMS = localbd.dna.dnb;
              this.oMR = localbd.dna.dnc;
            }
          }
          this.oMQ.R(this.oMS, this.oMR, this.oMT, this.oMU);
          if (localBundle != null) {
            break label343;
          }
        }
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.ImageGalleryUI", "[handleAnimation] savedInstanceState is null?%s", new Object[] { Boolean.valueOf(bool) });
      if (localBundle == null) {
        this.tZe.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(187502);
            ImageGalleryUI.this.tZe.getViewTreeObserver().removeOnPreDrawListener(this);
            ae.i("MicroMsg.ImageGalleryUI", "[handleAnimation] -> onPreDraw, isBackFromGrid:" + ImageGalleryUI.this.Knm);
            ImageGalleryUI.this.Arv = ImageGalleryUI.this.tZe.getWidth();
            ImageGalleryUI.this.Arw = ImageGalleryUI.this.tZe.getHeight();
            if (ImageGalleryUI.this.Kkv.fJS().cyI()) {
              ImageGalleryUI.this.Arw = ((int)(ImageGalleryUI.this.Arv / ImageGalleryUI.this.oMT * ImageGalleryUI.this.oMU));
            }
            if (ImageGalleryUI.this.Kkv.fJS().ftg())
            {
              com.tencent.mm.ui.base.g localg = (com.tencent.mm.ui.base.g)ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.Kkv, ImageGalleryUI.this.tZe);
              if (localg != null)
              {
                ImageGalleryUI localImageGalleryUI = ImageGalleryUI.this;
                float f = ImageGalleryUI.this.Arv / localg.getImageWidth();
                localImageGalleryUI.Arw = ((int)(localg.getImageHeight() * f));
                if (ImageGalleryUI.this.Arw > ImageGalleryUI.this.tZe.getHeight()) {
                  ImageGalleryUI.this.Arw = ImageGalleryUI.this.tZe.getHeight();
                }
              }
            }
            ImageGalleryUI.this.oMQ.kg(ImageGalleryUI.this.Arv, ImageGalleryUI.this.Arw);
            if (!ImageGalleryUI.this.Knm) {
              ImageGalleryUI.this.oMQ.a(ImageGalleryUI.this.tZe, ImageGalleryUI.y(ImageGalleryUI.this), new e.c()
              {
                public final void onAnimationEnd()
                {
                  AppMethodBeat.i(187501);
                  ImageGalleryUI.z(ImageGalleryUI.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(187499);
                      if (ImageGalleryUI.this.Kny != null) {
                        ImageGalleryUI.this.Kny.r(Boolean.FALSE);
                      }
                      AppMethodBeat.o(187499);
                    }
                  });
                  AppMethodBeat.o(187501);
                }
                
                public final void onAnimationStart()
                {
                  AppMethodBeat.i(187500);
                  if (ImageGalleryUI.this.Kny != null) {
                    ImageGalleryUI.this.Kny.r(Boolean.TRUE);
                  }
                  AppMethodBeat.o(187500);
                }
              });
            }
            ImageGalleryUI.A(ImageGalleryUI.this);
            AppMethodBeat.o(187502);
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
    com.tencent.mm.graphics.b.d.gxy.ahv();
    if (com.tencent.mm.graphics.b.c.gxq.gxv) {
      com.tencent.mm.graphics.b.c.gxq.stop();
    }
    aG(fKh().KmS, 8);
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
      RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = fKd().BAO;
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
      ae.e("MicroMsg.ImageGalleryUI", "set video state iv error : " + localException.toString());
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