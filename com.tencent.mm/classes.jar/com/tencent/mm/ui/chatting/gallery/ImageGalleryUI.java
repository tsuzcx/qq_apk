package com.tencent.mm.ui.chatting.gallery;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextPaint;
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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.y;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.o;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.g.a.ba;
import com.tencent.mm.g.a.ba.b;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.dy.b;
import com.tencent.mm.g.a.hu;
import com.tencent.mm.g.a.hu.b;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.g.a.sd.a;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.b.a.by;
import com.tencent.mm.g.c.ff;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.plugin.webview.ui.tools.media.g.a;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.b;
import com.tencent.mm.ui.base.MMViewPager.c;
import com.tencent.mm.ui.base.MMViewPager.e;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(3)
public class ImageGalleryUI
  extends MMActivity
  implements View.OnClickListener, a.a<String, com.tencent.mm.plugin.scanner.word.b>
{
  public com.tencent.mm.plugin.webview.ui.tools.media.d CAG;
  public View CKs;
  int HJK;
  private HashSet<Long> HTz;
  private boolean HXs;
  protected boolean HXt;
  public b HZU;
  private boolean Iae;
  private final boolean Iaf;
  private b.b IbW;
  private RelativeLayout IbX;
  private boolean IbY;
  private boolean IbZ;
  private com.tencent.mm.sdk.b.c IcA;
  private View IcB;
  private CheckBox IcC;
  private View IcD;
  private boolean IcE;
  private int IcF;
  private boolean IcG;
  private ViewPager.OnPageChangeListener IcH;
  public TextView IcI;
  public View IcJ;
  public ImageView IcK;
  boolean IcL;
  private HashMap<Long, String> IcM;
  private boolean IcN;
  private boolean IcO;
  public f Ica;
  private View Icb;
  private View Icc;
  private View Icd;
  private View Ice;
  private View Icf;
  View Icg;
  Button Ich;
  Button Ici;
  View Icj;
  int Ick;
  int Icl;
  boolean Icm;
  ArrayList<Integer> Icn;
  private boolean Ico;
  protected boolean Icp;
  protected boolean Icq;
  private boolean Icr;
  private int Ics;
  private boolean Ict;
  private String Icu;
  private boolean Icv;
  private ScanCodeSheetItemLogic Icw;
  private by Icx;
  private Map<Integer, Boolean> Icy;
  public a Icz;
  protected String chatroomName;
  private View contentView;
  public ImageView fxQ;
  private ImageView iBF;
  private boolean isAnimated;
  private int kYy;
  private int kYz;
  private ao mHandler;
  public long msgId;
  public TextView nMU;
  public MMNeat7extView nMV;
  private com.tencent.mm.ui.widget.a.e ngY;
  public long nxq;
  Bundle ocU;
  com.tencent.mm.ui.tools.e ocV;
  int ocW;
  int ocX;
  int ocY;
  int ocZ;
  private n.d piv;
  public boolean qKh;
  private com.tencent.mm.sdk.b.c qMM;
  private com.tencent.mm.plugin.scanner.word.a qOU;
  private volatile int qOV;
  private int qOW;
  private ImageView qOY;
  private ImageView qOZ;
  private ImageView qPa;
  private ValueAnimator qPb;
  private com.tencent.mm.sdk.b.c<se> qPc;
  private n qPd;
  private RelativeLayout qUO;
  com.tencent.mm.sdk.platformtools.au qUX;
  public View rcw;
  protected MMViewPager sRJ;
  protected String talker;
  private boolean uJg;
  int yIO;
  int yIP;
  int yIQ;
  private float yIR;
  private int yIS;
  private int yIT;
  private String yzo;
  private com.tencent.mm.sdk.b.c yzx;
  protected RedesignVideoPlayerSeekBar zRK;
  private boolean zRU;
  
  public ImageGalleryUI()
  {
    AppMethodBeat.i(36149);
    this.zRU = false;
    this.IbZ = false;
    this.Ica = new f();
    this.yIQ = 0;
    this.Ick = 0;
    this.Icl = 0;
    this.ocW = 0;
    this.ocX = 0;
    this.ocY = 0;
    this.ocZ = 0;
    this.Icn = new ArrayList();
    this.HXs = false;
    this.qKh = false;
    this.Icp = false;
    this.HXt = false;
    this.Icq = false;
    this.isAnimated = false;
    this.Iae = false;
    this.qOW = 0;
    this.Iaf = false;
    this.Icu = null;
    this.Icx = new by();
    this.Icy = new HashMap();
    this.qMM = new com.tencent.mm.sdk.b.c() {};
    this.IcA = new ImageGalleryUI.12(this);
    this.yzx = new ImageGalleryUI.23(this);
    this.qPd = new ImageGalleryUI.30(this);
    this.IcE = true;
    this.yIR = 1.0F;
    this.yIS = 0;
    this.yIT = 0;
    this.piv = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(196575);
        if ((ImageGalleryUI.this == null) || (ImageGalleryUI.this.isDestroyed()) || (ImageGalleryUI.this.isFinishing()))
        {
          ac.i("MicroMsg.ImageGalleryUI", "receive onMMMenuItemSelected but activity is invalid");
          AppMethodBeat.o(196575);
          return;
        }
        ac.i("MicroMsg.ImageGalleryUI", "curTransState %d", new Object[] { Integer.valueOf(ImageGalleryUI.g(ImageGalleryUI.this)) });
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(196575);
          return;
          paramAnonymousMenuItem = ImageGalleryUI.i(ImageGalleryUI.this).fpg();
          Object localObject;
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.crt()))
          {
            localObject = com.tencent.mm.modelvideo.u.Ej(paramAnonymousMenuItem.field_imgPath);
            if ((localObject != null) && (((s)localObject).status != 199) && (((s)localObject).status != 199))
            {
              ImageGalleryUI.b(ImageGalleryUI.this, com.tencent.mm.modelvideo.u.f(paramAnonymousMenuItem.field_msgId, 1));
              ImageGalleryUI.i(ImageGalleryUI.this).abp(ImageGalleryUI.this.sRJ.getCurrentItem());
            }
          }
          for (;;)
          {
            if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cru()))
            {
              localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.CKm;
              com.tencent.mm.plugin.webview.ui.tools.media.a.aC(1, ImageGalleryUI.A(ImageGalleryUI.this), ImageGalleryUI.B(ImageGalleryUI.this));
              paramAnonymousMenuItem = j.cl(paramAnonymousMenuItem);
              if (paramAnonymousMenuItem != null)
              {
                localObject = com.tencent.mm.plugin.webview.ui.tools.media.g.CLj;
                g.a.ad(paramAnonymousMenuItem.DWG, paramAnonymousMenuItem.DWF, ImageGalleryUI.this.Ica.nLA);
              }
            }
            AppMethodBeat.o(196575);
            return;
            ImageGalleryUI.i(ImageGalleryUI.this).abk(ImageGalleryUI.this.sRJ.getCurrentItem());
            continue;
            ImageGalleryUI.i(ImageGalleryUI.this).abk(ImageGalleryUI.this.sRJ.getCurrentItem());
          }
          paramAnonymousMenuItem = ImageGalleryUI.i(ImageGalleryUI.this).fpg();
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.crt()))
          {
            localObject = com.tencent.mm.modelvideo.u.Ej(paramAnonymousMenuItem.field_imgPath);
            if ((localObject != null) && (((s)localObject).status != 199) && (((s)localObject).status != 199))
            {
              ImageGalleryUI.b(ImageGalleryUI.this, com.tencent.mm.modelvideo.u.f(paramAnonymousMenuItem.field_msgId, 2));
              ImageGalleryUI.i(ImageGalleryUI.this).abp(ImageGalleryUI.this.sRJ.getCurrentItem());
              AppMethodBeat.o(196575);
              return;
            }
            paramAnonymousMenuItem = new ArrayList();
            paramAnonymousMenuItem.add(ImageGalleryUI.i(ImageGalleryUI.this).fpg());
            b.f(ImageGalleryUI.this.getContext(), paramAnonymousMenuItem);
            AppMethodBeat.o(196575);
            return;
          }
          paramAnonymousMenuItem = new ArrayList();
          paramAnonymousMenuItem.add(ImageGalleryUI.i(ImageGalleryUI.this).fpg());
          com.tencent.mm.modelstat.b.hUE.T((com.tencent.mm.storage.bo)paramAnonymousMenuItem.get(0));
          b.f(ImageGalleryUI.this.getContext(), paramAnonymousMenuItem);
          AppMethodBeat.o(196575);
          return;
          ImageGalleryUI.i(ImageGalleryUI.this).abl(ImageGalleryUI.this.sRJ.getCurrentItem());
          AppMethodBeat.o(196575);
          return;
          if (com.tencent.mm.br.d.aCT("favorite"))
          {
            ImageGalleryUI.i(ImageGalleryUI.this).abm(ImageGalleryUI.this.sRJ.getCurrentItem());
            paramAnonymousMenuItem = ImageGalleryUI.i(ImageGalleryUI.this).fpg();
            if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cru()))
            {
              paramAnonymousMenuItem = com.tencent.mm.plugin.webview.ui.tools.media.a.CKm;
              com.tencent.mm.plugin.webview.ui.tools.media.a.aC(2, ImageGalleryUI.A(ImageGalleryUI.this), ImageGalleryUI.B(ImageGalleryUI.this));
            }
            AppMethodBeat.o(196575);
            return;
            ImageGalleryUI.D(ImageGalleryUI.this);
            AppMethodBeat.o(196575);
            return;
            if (ImageGalleryUI.i(ImageGalleryUI.this) != null)
            {
              if (b.j(ImageGalleryUI.i(ImageGalleryUI.this).fpg())) {
                ImageGalleryUI.E(ImageGalleryUI.this);
              }
              AppMethodBeat.o(196575);
              return;
              ImageGalleryUI.F(ImageGalleryUI.this);
            }
          }
        }
      }
    };
    this.qPc = new ImageGalleryUI.16(this);
    this.IcF = 0;
    this.IcG = false;
    this.IcH = new ViewPager.OnPageChangeListener()
    {
      private boolean IcW;
      
      public final void onPageScrollStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(196581);
        ac.d("MicroMsg.ImageGalleryUI", "onPageScrollStateChanged: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 2) {
          ImageGalleryUI.b(ImageGalleryUI.this, true);
        }
        if (paramAnonymousInt == 0)
        {
          this.IcW = false;
          if (ImageGalleryUI.N(ImageGalleryUI.this)) {
            ImageGalleryUI.this.fpx();
          }
          ImageGalleryUI.b(ImageGalleryUI.this, false);
        }
        if (ImageGalleryUI.i(ImageGalleryUI.this) != null)
        {
          Object localObject = ImageGalleryUI.i(ImageGalleryUI.this);
          if (((b)localObject).Iaa != null)
          {
            localObject = ((b)localObject).Iaa;
            ((d)localObject).mScrollState = paramAnonymousInt;
            if (((d)localObject).Ibp != null) {
              ((d)localObject).Ibp.onPageScrollStateChanged(paramAnonymousInt);
            }
          }
        }
        AppMethodBeat.o(196581);
      }
      
      public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        AppMethodBeat.i(196580);
        ac.v("MicroMsg.ImageGalleryUI", "position: %d, positionOffset: %f, positionOffsetPixels: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Float.valueOf(paramAnonymousFloat), Integer.valueOf(paramAnonymousInt2) });
        if ((!this.IcW) && (paramAnonymousInt2 > 0))
        {
          this.IcW = true;
          ImageGalleryUI.this.fpy();
        }
        AppMethodBeat.o(196580);
      }
      
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(196579);
        if (ImageGalleryUI.i(ImageGalleryUI.this) == null)
        {
          AppMethodBeat.o(196579);
          return;
        }
        long l;
        if (ImageGalleryUI.G(ImageGalleryUI.this) != paramAnonymousInt)
        {
          ImageGalleryUI.H(ImageGalleryUI.this);
          ImageGalleryUI.I(ImageGalleryUI.this);
          l = System.currentTimeMillis();
          ImageGalleryUI.a(ImageGalleryUI.this, new by());
          ImageGalleryUI.J(ImageGalleryUI.this).dNF = l;
          ImageGalleryUI.J(ImageGalleryUI.this).dNG = 2L;
          ImageGalleryUI.J(ImageGalleryUI.this).jT(com.tencent.mm.model.u.axw() + "_" + l);
          ImageGalleryUI.K(ImageGalleryUI.this);
          if (ImageGalleryUI.g(ImageGalleryUI.this) == 1) {
            ImageGalleryUI.h(ImageGalleryUI.this);
          }
          ImageGalleryUI.L(ImageGalleryUI.this);
          ImageGalleryUI.k(ImageGalleryUI.this);
        }
        if (ImageGalleryUI.i(ImageGalleryUI.this).QZ(paramAnonymousInt) == null) {
          ac.e("MicroMsg.ImageGalleryUI", "onPageSelected the view is null, position = %s ", new Object[] { Integer.valueOf(paramAnonymousInt) });
        }
        ImageGalleryUI.u(ImageGalleryUI.this);
        ImageGalleryUI.e(ImageGalleryUI.this, ImageGalleryUI.G(ImageGalleryUI.this));
        ImageGalleryUI.this.Ica.a(ImageGalleryUI.this, ImageGalleryUI.G(ImageGalleryUI.this), paramAnonymousInt);
        ImageGalleryUI.f(ImageGalleryUI.this, paramAnonymousInt);
        Object localObject1;
        Object localObject2;
        int i;
        boolean bool;
        if (ImageGalleryUI.i(ImageGalleryUI.this) != null)
        {
          localObject1 = ImageGalleryUI.i(ImageGalleryUI.this);
          ((b)localObject1).Iab.MT();
          ((b)localObject1).Iac.MT();
          localObject1 = ImageGalleryUI.i(ImageGalleryUI.this).aaP(paramAnonymousInt);
          if (localObject1 != null)
          {
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Wm(((com.tencent.mm.g.c.dy)localObject1).field_talker);
            localObject2 = ImageGalleryUI.this;
            ImageGalleryUI.i(ImageGalleryUI.this);
            ImageGalleryUI.a((ImageGalleryUI)localObject2, b.bV((com.tencent.mm.storage.bo)localObject1));
          }
          if ((b.j((com.tencent.mm.storage.bo)localObject1)) || (b.bS((com.tencent.mm.storage.bo)localObject1)))
          {
            localObject2 = ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.i(ImageGalleryUI.this), ImageGalleryUI.this.sRJ);
            if ((localObject2 != null) && ((localObject2 instanceof com.tencent.mm.ui.base.g)))
            {
              if (!(localObject2 instanceof MultiTouchImageView)) {
                break label805;
              }
              ((MultiTouchImageView)localObject2).fij();
            }
            localObject2 = ImageGalleryUI.a(ImageGalleryUI.this);
            i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("EnableSessionPicTranslation", 0);
            Object localObject3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("PicTranslationSupportUserLanguage");
            if (i != 1) {
              break label827;
            }
            bool = true;
            label481:
            ac.i("MicroMsg.ScannerHelper", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool), localObject3, ab.eUO() });
            if ((i != 1) || (bs.isNullOrNil((String)localObject3))) {
              break label833;
            }
            localObject3 = ((String)localObject3).split(";");
            if ((localObject3 == null) || (!Arrays.asList((Object[])localObject3).contains(ab.eUO()))) {
              break label833;
            }
            i = 1;
            label559:
            if (i != 0)
            {
              if (ImageGalleryUI.M(ImageGalleryUI.this) == null) {
                ImageGalleryUI.a(ImageGalleryUI.this, new ImageWordScanDetailEngine(ImageGalleryUI.this));
              }
              if (!bs.isNullOrNil((String)localObject2)) {
                ImageGalleryUI.M(ImageGalleryUI.this).a(localObject2, ImageGalleryUI.this);
              }
            }
            ImageGalleryUI.aQA((String)localObject2);
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).af((com.tencent.mm.storage.bo)localObject1);
          }
          if (localObject1 != null) {
            ImageGalleryUI.this.Bs(((com.tencent.mm.g.c.dy)localObject1).field_msgId);
          }
          if (ImageGalleryUI.i(ImageGalleryUI.this) == null) {
            break label855;
          }
          localObject2 = ImageGalleryUI.i(ImageGalleryUI.this).g((com.tencent.mm.storage.bo)localObject1, false);
          ImageGalleryUI.i(ImageGalleryUI.this);
          if (!b.b((com.tencent.mm.storage.bo)localObject1, (com.tencent.mm.av.e)localObject2)) {
            break label863;
          }
          localObject1 = com.tencent.mm.av.f.a((com.tencent.mm.av.e)localObject2);
          i = ((com.tencent.mm.av.e)localObject1).hux;
          int j = ((com.tencent.mm.av.e)localObject1).offset;
          if (i == 0) {
            break label849;
          }
          l = j * 100L / i - 1L;
          label734:
          i = Math.max(1, (int)l);
          ac.d("MicroMsg.ImageGalleryUI", "jacks loading hd from imgInfo : %d, time: %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()) });
          ImageGalleryUI.this.abE(i);
        }
        for (;;)
        {
          if (ImageGalleryUI.i(ImageGalleryUI.this) != null) {
            ImageGalleryUI.i(ImageGalleryUI.this).onPageSelected(paramAnonymousInt);
          }
          AppMethodBeat.o(196579);
          return;
          label805:
          if (!(localObject2 instanceof WxImageView)) {
            break;
          }
          ((WxImageView)localObject2).fij();
          break;
          label827:
          bool = false;
          break label481;
          label833:
          if (com.tencent.mm.protocal.d.DIg)
          {
            i = 1;
            break label559;
          }
          i = 0;
          break label559;
          label849:
          l = 0L;
          break label734;
          label855:
          ac.e("MicroMsg.ImageGalleryUI", "[arthurdan.ImageGallery] Notice!!! adapter is null");
          label863:
          if (localObject1 == null)
          {
            ac.e("MicroMsg.ImageGalleryUI", "update footer fail, msg is null, position = ".concat(String.valueOf(paramAnonymousInt)));
          }
          else
          {
            ImageGalleryUI.this.cj((com.tencent.mm.storage.bo)localObject1);
            ImageGalleryUI.a(ImageGalleryUI.this, (com.tencent.mm.storage.bo)localObject1);
            ImageGalleryUI.this.fpx();
          }
        }
      }
    };
    this.CKs = null;
    this.IcL = false;
    this.qUX = new com.tencent.mm.sdk.platformtools.au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(196582);
        if (ImageGalleryUI.O(ImageGalleryUI.this)) {
          ImageGalleryUI.this.fpy();
        }
        AppMethodBeat.o(196582);
        return false;
      }
    }, false);
    this.IcM = new HashMap();
    this.IcN = false;
    this.IcO = false;
    this.mHandler = new ao(Looper.getMainLooper());
    this.HTz = new HashSet();
    AppMethodBeat.o(36149);
  }
  
  private static String Bq(long paramLong)
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
      ac.d("MicroMsg.ImageGalleryUI", "get current view adapter is null %b, gallery is null %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((paramb == null) || (paramMMViewPager == null)) {
        break label182;
      }
      if (paramb.fpg() != null) {
        break label81;
      }
      AppMethodBeat.o(36164);
      return null;
      bool1 = false;
      break;
    }
    label81:
    Object localObject;
    if ((paramb.fpg().eZm()) || (paramb.fpg().fbG()))
    {
      MultiTouchImageView localMultiTouchImageView = paramb.Gb(paramMMViewPager.getCurrentItem());
      localObject = localMultiTouchImageView;
      if (localMultiTouchImageView == null) {
        localObject = paramb.Gc(paramMMViewPager.getCurrentItem());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(36164);
      return localObject;
      if ((paramb.fpg().crt()) || (paramb.fpg().crv()) || (paramb.fpg().cru()))
      {
        localObject = paramb.abn(paramMMViewPager.getCurrentItem());
        continue;
        label182:
        ac.w("MicroMsg.ImageGalleryUI", "%d get current view but adapter or gallery is null", new Object[] { Integer.valueOf(hashCode()) });
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  private static void aE(View paramView, int paramInt)
  {
    AppMethodBeat.i(36156);
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(36156);
  }
  
  private boolean aQy(String paramString)
  {
    AppMethodBeat.i(36169);
    if (this.Ics == 1)
    {
      AppMethodBeat.o(36169);
      return false;
    }
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(36169);
      return false;
    }
    if (!this.Icr)
    {
      AppMethodBeat.o(36169);
      return true;
    }
    String[] arrayOfString = ((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GJC, "")).split("\\|");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((!bs.isNullOrNil(str)) && (paramString.startsWith(str)))
        {
          ac.i("MicroMsg.ImageGalleryUI", "curDealQBarStr:%s, blockQrcodeStr:%s", new Object[] { paramString, str });
          AppMethodBeat.o(36169);
          return false;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(36169);
    return true;
  }
  
  private void aQz(String paramString)
  {
    AppMethodBeat.i(36213);
    paramString = RecordConfigProvider.iv(paramString, "");
    paramString.scene = this.Ics;
    Object localObject = new UICustomParam.a();
    ((UICustomParam.a)localObject).YX();
    ((UICustomParam.a)localObject).YW();
    ((UICustomParam.a)localObject).cN(true);
    paramString.wqu = ((UICustomParam.a)localObject).fKH;
    localObject = com.tencent.mm.plugin.recordvideo.jumper.a.wqR;
    com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4369, 2130772137, -1, paramString, 1, 2);
    AppMethodBeat.o(36213);
  }
  
  private void abA(int paramInt)
  {
    AppMethodBeat.i(36181);
    com.tencent.mm.storage.bo localbo = this.HZU.aaP(paramInt);
    if ((localbo == null) || (!localbo.cru()) || (this.Iae))
    {
      AppMethodBeat.o(36181);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(new h.c(localbo.field_talker, "update", localbo));
    AppMethodBeat.o(36181);
  }
  
  private void abB(int paramInt)
  {
    AppMethodBeat.i(36189);
    ac.i("MicroMsg.ImageGalleryUI", "enterGrid source : ".concat(String.valueOf(paramInt)));
    if (this.HZU == null)
    {
      ac.w("MicroMsg.ImageGalleryUI", "try to enterGrid, but adapter is NULL");
      AppMethodBeat.o(36189);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(219L, 13L, 1L, true);
    int i = this.HZU.getRealCount();
    if (this.HZU.fpg() == null)
    {
      ac.e("MicroMsg.ImageGalleryUI", "msgInfo is null");
      AppMethodBeat.o(36189);
      return;
    }
    int j = this.HZU.HZW.abt(this.sRJ.getCurrentItem());
    if (!this.Icp)
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), MediaHistoryGalleryUI.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("kintent_intent_source", paramInt);
      ((Intent)localObject).putExtra("kintent_talker", fpv());
      ((Intent)localObject).putExtra("kintent_image_count", i);
      ((Intent)localObject).putExtra("kintent_image_index", j);
      ((Intent)localObject).putExtra("key_biz_chat_id", this.nxq);
      ((Intent)localObject).putExtra("key_is_biz_chat", this.qKh);
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "enterGrid", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "enterGrid", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196583);
          ImageGalleryUI.this.finish();
          AppMethodBeat.o(196583);
        }
      }, 50L);
      AppMethodBeat.o(36189);
      return;
    }
    bSg();
    AppMethodBeat.o(36189);
  }
  
  static Animation abD(int paramInt)
  {
    AppMethodBeat.i(36199);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(paramInt);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator(10.0F));
    AppMethodBeat.o(36199);
    return localAlphaAnimation;
  }
  
  private void abF(int paramInt)
  {
    AppMethodBeat.i(36209);
    if (this.CKs != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.CKs.getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, paramInt, 0);
      this.CKs.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(36209);
  }
  
  private void bSg()
  {
    AppMethodBeat.i(36165);
    if ((this.zRU) || (this.HZU == null))
    {
      ac.i("MicroMsg.ImageGalleryUI", "isRunningExitAnimation");
      AppMethodBeat.o(36165);
      return;
    }
    xr(true);
    if (this.IbY)
    {
      finish();
      com.tencent.mm.ui.base.b.jS(getContext());
      AppMethodBeat.o(36165);
      return;
    }
    ac.i("MicroMsg.ImageGalleryUI", "runExitAnimation");
    int k = this.sRJ.getWidth() / 2;
    int j = this.sRJ.getHeight() / 2;
    this.HZU.fpf();
    Object localObject1;
    int m;
    int i;
    int n;
    if (!fjY())
    {
      if (this.Icp)
      {
        localObject1 = new hu();
        ((hu)localObject1).diO.msgId = this.HZU.aaP(this.sRJ.getCurrentItem()).field_msgId;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        m = ((hu)localObject1).diP.daH;
        i = ((hu)localObject1).diP.daI;
        k = ((hu)localObject1).diP.daF;
        j = ((hu)localObject1).diP.daG;
        this.yIO = this.sRJ.getWidth();
        this.yIP = this.sRJ.getHeight();
        n = i;
        if (this.HZU.fpg() != null)
        {
          if ((this.HZU.fpg().crv()) || (this.HZU.fpg().crt()) || (this.HZU.fpg().cru())) {
            this.yIP = ((int)(this.yIO / m * i));
          }
          if (!this.HZU.fpg().eZm())
          {
            n = i;
            if (!this.HZU.fpg().fbG()) {}
          }
          else
          {
            localObject1 = (com.tencent.mm.ui.base.g)a(this.HZU, this.sRJ);
            n = i;
            if (localObject1 != null)
            {
              float f = this.yIO / ((com.tencent.mm.ui.base.g)localObject1).getImageWidth();
              this.yIP = ((int)(((com.tencent.mm.ui.base.g)localObject1).getImageHeight() * f));
              n = i;
              if (this.yIP > this.sRJ.getHeight())
              {
                n = i;
                if (this.yIP < this.sRJ.getHeight() * 1.5D)
                {
                  if (!this.Icp) {
                    break label874;
                  }
                  this.yIQ = (this.yIP - this.sRJ.getHeight());
                  n = i;
                }
                label440:
                this.yIP = this.sRJ.getHeight();
              }
            }
          }
        }
        this.ocV.jO(this.Ick, this.Icl);
        this.ocV.IRl = this.yIQ;
        this.ocV.jN(this.yIO, this.yIP);
        this.ocV.R(k, j, m, n);
        localObject1 = this.sRJ;
        localObject2 = a(this.HZU, this.sRJ);
        if (localObject2 == null) {
          break label893;
        }
        localObject1 = localObject2;
        if (this.yIR != 1.0D)
        {
          this.ocV.IRh = (1.0F / this.yIR);
          if (this.yIS == 0)
          {
            localObject1 = localObject2;
            if (this.yIT == 0) {}
          }
          else
          {
            i = (int)(this.sRJ.getWidth() / 2 * (1.0F - this.yIR));
            j = this.yIS;
            k = (int)(this.sRJ.getHeight() / 2 + this.yIT - this.yIP / 2 * this.yIR);
            this.ocV.jP(i + j, k);
            localObject1 = localObject2;
          }
        }
        label647:
        fpy();
        this.ocV.a((View)localObject1, this.iBF, new e.c()
        {
          public final void onAnimationEnd()
          {
            AppMethodBeat.i(196567);
            ac.i("MicroMsg.ImageGalleryUI", "runExitAnimation onAnimationEnd");
            ImageGalleryUI.t(ImageGalleryUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(196565);
                ImageGalleryUI.this.finish();
                ImageGalleryUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.o(196565);
              }
            });
            ImageGalleryUI.a(ImageGalleryUI.this, false);
            AppMethodBeat.o(196567);
          }
          
          public final void onAnimationStart()
          {
            AppMethodBeat.i(196566);
            ImageGalleryUI.a(ImageGalleryUI.this, true);
            new ao().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(196564);
                View localView = ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.i(ImageGalleryUI.this), ImageGalleryUI.this.sRJ);
                if ((localView != null) && ((localView instanceof com.tencent.mm.ui.base.g)))
                {
                  if ((localView instanceof MultiTouchImageView))
                  {
                    ((MultiTouchImageView)localView).fij();
                    AppMethodBeat.o(196564);
                    return;
                  }
                  if ((localView instanceof WxImageView)) {
                    ((WxImageView)localView).fij();
                  }
                }
                AppMethodBeat.o(196564);
              }
            }, 20L);
            AppMethodBeat.o(196566);
          }
        }, null);
        AppMethodBeat.o(36165);
        return;
      }
      localObject1 = this.HZU.aaP(this.sRJ.getCurrentItem());
      if (localObject1 == null) {
        break label896;
      }
      Object localObject2 = new ba();
      ((ba)localObject2).daD.cZc = ((com.tencent.mm.storage.bo)localObject1);
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
      m = ((ba)localObject2).daE.daH;
      i = ((ba)localObject2).daE.daI;
      k = ((ba)localObject2).daE.daF;
      j = ((ba)localObject2).daE.daG;
    }
    for (;;)
    {
      if ((k == 0) && (j == 0))
      {
        k = this.sRJ.getWidth() / 2;
        j = this.sRJ.getHeight() / 2;
        break;
      }
      if (localObject1 != null)
      {
        if (((com.tencent.mm.g.c.dy)localObject1).field_isSend == 0) {
          this.Ick = com.tencent.mm.cc.a.fromDPToPix(getContext(), 5);
        }
        if (((com.tencent.mm.g.c.dy)localObject1).field_isSend == 1) {
          this.Icl = com.tencent.mm.cc.a.fromDPToPix(getContext(), 5);
        }
      }
      break;
      m = this.ocY;
      i = this.ocZ;
      k = this.ocX;
      j = this.ocW;
      break;
      label874:
      n = this.sRJ.getHeight() * i / this.yIP;
      break label440;
      label893:
      break label647;
      label896:
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
      ac.d("MicroMsg.ImageGalleryUI", "%d is vertical screen orient %d [%d, %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(36211);
      return false;
    }
    AppMethodBeat.o(36211);
    return true;
  }
  
  private String cqG()
  {
    AppMethodBeat.i(36166);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    com.tencent.mm.storage.bo localbo;
    if (this.HZU != null)
    {
      localbo = this.HZU.aaP(this.IcF);
      if (!b.j(localbo)) {
        break label74;
      }
      com.tencent.mm.av.e locale = this.HZU.g(localbo, true);
      localObject1 = localObject2;
      if (locale != null) {
        localObject1 = d.a(localbo, locale);
      }
    }
    for (;;)
    {
      localObject1 = bs.nullAsNil((String)localObject1);
      AppMethodBeat.o(36166);
      return localObject1;
      label74:
      localObject1 = localObject2;
      if (b.bT(localbo)) {
        localObject1 = b.l(localbo);
      }
    }
  }
  
  private void cqU()
  {
    AppMethodBeat.i(36171);
    this.qPb.setRepeatMode(1);
    this.qPb.setRepeatCount(0);
    this.qPb.end();
    AppMethodBeat.o(36171);
  }
  
  private void crG()
  {
    AppMethodBeat.i(36183);
    ac.i("MicroMsg.ImageGalleryUI", "show video tool bar");
    xt(true);
    aE(this.Icg, 4);
    aE(fpr().zRK, 0);
    aE(this.Icb, 0);
    if (this.IbY) {
      fpy();
    }
    if (this.HZU != null)
    {
      com.tencent.mm.storage.bo localbo = this.HZU.fpg();
      if ((localbo != null) && (localbo.cru())) {
        aE(this.CKs, 0);
      }
    }
    AppMethodBeat.o(36183);
  }
  
  private void eFZ()
  {
    boolean bool = true;
    AppMethodBeat.i(36196);
    if (this.IbX.getVisibility() == 0) {}
    for (;;)
    {
      ac.d("MicroMsg.ImageGalleryUI", "fadeOutOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      Animation localAnimation = abD(150);
      localAnimation.setFillAfter(false);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(196584);
          if (!ImageGalleryUI.O(ImageGalleryUI.this)) {
            ImageGalleryUI.this.fpz();
          }
          AppMethodBeat.o(196584);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.IbX.clearAnimation();
      this.IbX.startAnimation(localAnimation);
      AppMethodBeat.o(36196);
      return;
      bool = false;
    }
  }
  
  private void eGb()
  {
    AppMethodBeat.i(36207);
    final View localView = getWindow().getDecorView();
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(196585);
        localView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        ImageGalleryUI.S(ImageGalleryUI.this);
        AppMethodBeat.o(196585);
      }
    });
    AppMethodBeat.o(36207);
  }
  
  private void eGc()
  {
    AppMethodBeat.i(36208);
    final View localView = getWindow().getDecorView();
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(36139);
        localView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i = com.tencent.mm.cc.a.ig(ImageGalleryUI.this);
        int j = com.tencent.mm.cc.a.ih(ImageGalleryUI.this);
        ac.i("MicroMsg.ImageGalleryUI", "handleHorizontalUI width = %d, height = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if ((i <= j) || ((com.tencent.mm.compatible.util.d.kZ(24)) && (ImageGalleryUI.this.isInMultiWindowMode())))
        {
          ImageGalleryUI.S(ImageGalleryUI.this);
          AppMethodBeat.o(36139);
          return;
        }
        ImageGalleryUI.T(ImageGalleryUI.this);
        AppMethodBeat.o(36139);
      }
    });
    AppMethodBeat.o(36208);
  }
  
  private static boolean f(com.tencent.mm.storage.bo parambo, com.tencent.mm.av.e parame)
  {
    AppMethodBeat.i(36179);
    if (parame == null)
    {
      AppMethodBeat.o(36179);
      return false;
    }
    try
    {
      if ((b.c(parambo, parame) == 0) && (parame.aFa()))
      {
        boolean bool = parambo.fbQ();
        if (!bool)
        {
          AppMethodBeat.o(36179);
          return true;
        }
      }
    }
    catch (NullPointerException parambo)
    {
      ac.e("MicroMsg.ImageGalleryUI", "error:".concat(String.valueOf(parambo)));
      AppMethodBeat.o(36179);
    }
    return false;
  }
  
  private boolean fjY()
  {
    return this.HJK == 1;
  }
  
  private int fpA()
  {
    if (this.Iae)
    {
      locala = com.tencent.mm.plugin.webview.ui.tools.media.a.CKm;
      return 2;
    }
    com.tencent.mm.plugin.webview.ui.tools.media.a locala = com.tencent.mm.plugin.webview.ui.tools.media.a.CKm;
    return 1;
  }
  
  private int fpB()
  {
    if (this.IbZ) {
      return 2;
    }
    return 3;
  }
  
  private boolean fpC()
  {
    return this.IbW == b.b.IaF;
  }
  
  private void fpF()
  {
    boolean bool = true;
    AppMethodBeat.i(36197);
    if (this.IbX.getVisibility() == 0) {}
    for (;;)
    {
      ac.d("MicroMsg.ImageGalleryUI", "fadeInOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      this.IbX.clearAnimation();
      this.IbX.startAnimation(fpG());
      AppMethodBeat.o(36197);
      return;
      bool = false;
    }
  }
  
  private static Animation fpG()
  {
    AppMethodBeat.i(36198);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(150L);
    localAlphaAnimation.setFillAfter(true);
    AppMethodBeat.o(36198);
    return localAlphaAnimation;
  }
  
  private void fpI()
  {
    AppMethodBeat.i(36210);
    if (this.CKs != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.CKs.getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, 0, 0);
      this.CKs.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(36210);
  }
  
  private void fpJ()
  {
    AppMethodBeat.i(36212);
    com.tencent.mm.storage.bo localbo = this.HZU.fpg();
    String str = d.a(localbo, d.k(localbo));
    ac.i("MicroMsg.ImageGalleryUI", "edit image path:%s msgId:%s", new Object[] { str, Long.valueOf(localbo.field_msgId) });
    aQz(str);
    AppMethodBeat.o(36212);
  }
  
  private ImageGalleryUI fps()
  {
    AppMethodBeat.i(36154);
    if (this.Icc == null) {
      this.Icc = findViewById(2131299498);
    }
    AppMethodBeat.o(36154);
    return this;
  }
  
  private ImageGalleryUI fpt()
  {
    AppMethodBeat.i(36155);
    if (this.Ice == null) {
      this.Ice = findViewById(2131299194);
    }
    AppMethodBeat.o(36155);
    return this;
  }
  
  private void fpu()
  {
    boolean bool2 = false;
    AppMethodBeat.i(196594);
    this.Icx.dNI = 1L;
    this.Icx.dNJ = 1L;
    if (this.Icy.containsKey(Integer.valueOf(1))) {}
    for (boolean bool1 = ((Boolean)this.Icy.get(Integer.valueOf(1))).booleanValue();; bool1 = false)
    {
      if (this.Icy.containsKey(Integer.valueOf(2))) {
        bool2 = ((Boolean)this.Icy.get(Integer.valueOf(2))).booleanValue();
      }
      if ((bool1) && (bool2)) {
        this.Icx.dNI = 4L;
      }
      for (;;)
      {
        this.Icx.aHZ();
        AppMethodBeat.o(196594);
        return;
        if (bool1)
        {
          this.Icx.dNI = 3L;
          if (this.Ict) {
            this.Icx.dNJ = 3L;
          }
        }
        else if (bool2)
        {
          this.Icx.dNI = 2L;
        }
      }
    }
  }
  
  private String fpv()
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
  
  private boolean fpw()
  {
    AppMethodBeat.i(36168);
    if (this.Icr)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if (this.Ics == 1)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if (this.Iae)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if ((!this.HXs) && (!this.qKh) && (!h.a.fpp().qSw))
    {
      AppMethodBeat.o(36168);
      return true;
    }
    AppMethodBeat.o(36168);
    return false;
  }
  
  private static int k(com.tencent.mm.av.e parame)
  {
    AppMethodBeat.i(36187);
    Map localMap = bv.L(parame.hGY, "msg");
    if (localMap == null)
    {
      ac.e("MicroMsg.ImageGalleryUI", "parse cdnInfo failed. [%s]", new Object[] { parame.hGY });
      AppMethodBeat.o(36187);
      return -1;
    }
    int j = bs.getInt((String)localMap.get(".msg.img.$hdlength"), 0);
    int i = j;
    if (j == 0) {
      i = bs.getInt((String)localMap.get(".msg.img.$tphdlength"), 0);
    }
    AppMethodBeat.o(36187);
    return i;
  }
  
  private void mC(boolean paramBoolean)
  {
    int i = 8;
    AppMethodBeat.i(36178);
    if (this.qUO == null)
    {
      AppMethodBeat.o(36178);
      return;
    }
    if (((paramBoolean) && (this.qUO.getVisibility() == 0)) || ((!paramBoolean) && (this.qUO.getVisibility() == 8)))
    {
      AppMethodBeat.o(36178);
      return;
    }
    Object localObject = this.qUO;
    if (paramBoolean) {
      i = 0;
    }
    ((RelativeLayout)localObject).setVisibility(i);
    localObject = getContext();
    if (paramBoolean) {}
    for (i = 2130771981;; i = 2130771982)
    {
      localObject = AnimationUtils.loadAnimation((Context)localObject, i);
      this.qUO.startAnimation((Animation)localObject);
      AppMethodBeat.o(36178);
      return;
    }
  }
  
  private void xq(boolean paramBoolean)
  {
    AppMethodBeat.i(196596);
    String str = cqG();
    Object localObject;
    label76:
    label247:
    label254:
    sd.a locala;
    if (((this.qOW == 0) || (this.qOW == 2)) && (!bs.isNullOrNil(str)))
    {
      localObject = new com.tencent.mm.g.b.a.bo();
      long l;
      if (this.qOW == 2)
      {
        l = 1L;
        ((com.tencent.mm.g.b.a.bo)localObject).dHY = l;
        ((com.tencent.mm.g.b.a.bo)localObject).dCQ = 3L;
        if (!paramBoolean) {
          break label247;
        }
        l = 10L;
        ((com.tencent.mm.g.b.a.bo)localObject).dNc = l;
        ((com.tencent.mm.g.b.a.bo)localObject).aHZ();
        this.qOV = ((int)(com.tencent.mm.model.u.axw().hashCode() + System.currentTimeMillis()));
        localObject = ((com.tencent.mm.plugin.scanner.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.scanner.d.class)).getTranslationResult(str);
        if ((localObject == null) || (!com.tencent.mm.vfs.i.eA(((ff)localObject).field_resultFile))) {
          break label259;
        }
        if (this.HZU.aaP(this.IcF) == null) {
          break label389;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("original_file_path", str);
        ((Intent)localObject).putExtra("msg_id", this.HZU.aaP(this.IcF).field_msgId);
        if (!paramBoolean) {
          break label254;
        }
      }
      for (i = 10;; i = 4)
      {
        ((Intent)localObject).putExtra("translate_source", i);
        startActivity(TranslationResultUI.class, (Intent)localObject);
        finish();
        overridePendingTransition(2130771986, 2130771986);
        AppMethodBeat.o(196596);
        return;
        l = 0L;
        break;
        l = 4L;
        break label76;
      }
      label259:
      if ((com.tencent.mm.kernel.g.agi().aBK() == 6) || (com.tencent.mm.kernel.g.agi().aBK() == 4)) {
        break label396;
      }
      com.tencent.mm.ui.base.h.c(this, getString(2131755828), "", true);
      xr(false);
      ac.i("MicroMsg.ImageGalleryUI", "try to translate img %s, sessionId %d", new Object[] { str, Integer.valueOf(this.qOV) });
      localObject = new sd();
      locala = ((sd)localObject).dve;
      if (!paramBoolean) {
        break label455;
      }
    }
    label389:
    label396:
    label455:
    for (int i = 7;; i = 1)
    {
      locala.scene = i;
      ((sd)localObject).dve.filePath = str;
      ((sd)localObject).dve.daq = this.qOV;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(196596);
      return;
      this.qOW = 1;
      this.qOY.setVisibility(0);
      this.qOZ.setVisibility(0);
      this.qPa.setVisibility(0);
      fpy();
      this.qPb.setRepeatMode(1);
      this.qPb.setRepeatCount(-1);
      this.qPb.start();
      break;
    }
  }
  
  private void xr(boolean paramBoolean)
  {
    AppMethodBeat.i(36170);
    this.qOW = 0;
    this.qOY.setVisibility(8);
    this.qOZ.setVisibility(8);
    this.qPa.setVisibility(8);
    if (!paramBoolean)
    {
      fpD();
      fpx();
    }
    cqU();
    AppMethodBeat.o(36170);
  }
  
  private void xs(boolean paramBoolean)
  {
    AppMethodBeat.i(36177);
    if (this.IbW != b.b.IaE)
    {
      aE(this.Icg, 4);
      AppMethodBeat.o(36177);
      return;
    }
    Object localObject = null;
    if (this.HZU != null) {
      localObject = this.HZU.fpg();
    }
    if (localObject == null)
    {
      aE(this.Icg, 4);
      AppMethodBeat.o(36177);
      return;
    }
    com.tencent.mm.av.e locale = this.HZU.g((com.tencent.mm.storage.bo)localObject, false);
    if (paramBoolean)
    {
      this.sRJ.getCurrentItem();
      if ((f((com.tencent.mm.storage.bo)localObject, locale)) && (!((com.tencent.mm.storage.bo)localObject).fbQ()) && (locale.aEZ()))
      {
        fpq().Ich.setVisibility(0);
        fpq().Ici.setVisibility(8);
        fpq().Icj.setVisibility(8);
        String str = (String)this.IcM.get(Long.valueOf(locale.dcd));
        localObject = str;
        if (str == null)
        {
          localObject = Bq(k(locale));
          this.IcM.put(Long.valueOf(locale.dcd), localObject);
        }
        fpq().Ich.setText(getString(2131757973, new Object[] { localObject }));
        aE(this.Icg, 0);
        AppMethodBeat.o(36177);
        return;
      }
    }
    aE(this.Icg, 4);
    AppMethodBeat.o(36177);
  }
  
  private static void xt(boolean paramBoolean)
  {
    AppMethodBeat.i(36185);
    ac.d("MicroMsg.ImageGalleryUI", "switch tool bar bg %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(36185);
  }
  
  public final int Br(long paramLong)
  {
    AppMethodBeat.i(36204);
    if (bs.isNullOrNil(this.Icu))
    {
      AppMethodBeat.o(36204);
      return 0;
    }
    try
    {
      int j = com.tencent.mm.modelvideo.u.g(paramLong, this.Icu);
      int i = j;
      if (j == -1)
      {
        this.Icu = null;
        i = 0;
      }
      ac.d("MicroMsg.ImageGalleryUI", "get enter video op code %d %s", new Object[] { Integer.valueOf(i), this.Icu });
      AppMethodBeat.o(36204);
      return i;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.ImageGalleryUI", "get enter video op code error : " + localException.toString());
      AppMethodBeat.o(36204);
    }
    return 0;
  }
  
  public final void Bs(long paramLong)
  {
    AppMethodBeat.i(36205);
    if ((bs.isNullOrNil(this.Icu)) || (paramLong == 0L))
    {
      AppMethodBeat.o(36205);
      return;
    }
    if (this.Icv)
    {
      this.Icu = com.tencent.mm.modelvideo.u.f(paramLong, 3);
      ac.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[] { this.Icu });
      AppMethodBeat.o(36205);
      return;
    }
    if (com.tencent.mm.modelvideo.u.g(paramLong, this.Icu) == -1)
    {
      this.Icu = null;
      ac.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[] { this.Icu });
    }
    AppMethodBeat.o(36205);
  }
  
  public final void abC(int paramInt)
  {
    AppMethodBeat.i(36194);
    if (fpr().zRK == null)
    {
      AppMethodBeat.o(36194);
      return;
    }
    fpr().zRK.post(new ImageGalleryUI.24(this, paramInt));
    AppMethodBeat.o(36194);
  }
  
  public final void abE(int paramInt)
  {
    AppMethodBeat.i(36200);
    crF();
    fpx();
    fpq().Icg.setVisibility(0);
    fpq().Ich.setVisibility(8);
    fpq().Ici.setVisibility(0);
    fpq().Icj.setVisibility(8);
    fpq().Ici.setText(paramInt + "%");
    AppMethodBeat.o(36200);
  }
  
  public final void abz(int paramInt)
  {
    AppMethodBeat.i(36180);
    cj(this.HZU.aaP(paramInt));
    AppMethodBeat.o(36180);
  }
  
  protected final void cOM()
  {
    AppMethodBeat.i(196595);
    int i = this.IcF;
    if (this.HZU == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.ImageGalleryUI", "showMenu mSelectedPos %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      if (this.HZU != null) {
        break;
      }
      AppMethodBeat.o(196595);
      return;
    }
    if (this.IcF < 0)
    {
      AppMethodBeat.o(196595);
      return;
    }
    com.tencent.mm.storage.bo localbo = this.HZU.aaP(this.IcF);
    i = this.HZU.Iaa.cc(localbo);
    if ((i == 5) || (i == 6))
    {
      ac.w("MicroMsg.ImageGalleryUI", "jacks fail downloaded img, return");
      AppMethodBeat.o(196595);
      return;
    }
    Object localObject1 = this.HZU;
    if (localbo != null)
    {
      localObject1 = ((b)localObject1).g(localbo, false);
      if (localObject1 != null) {
        if ((localbo == null) || (localObject1 == null)) {
          bool = false;
        }
      }
    }
    while (bool)
    {
      ac.w("MicroMsg.ImageGalleryUI", "jacks downloading, return");
      AppMethodBeat.o(196595);
      return;
      if ((o.aFy().a(((com.tencent.mm.av.e)localObject1).dcd, localbo.field_msgId, 0)) || (b.b(localbo, (com.tencent.mm.av.e)localObject1)))
      {
        bool = true;
      }
      else
      {
        bool = false;
        continue;
        localObject1 = j.ck(localbo);
        if ((localObject1 != null) && (localObject1 != null))
        {
          i = ((s)localObject1).status;
          int j = com.tencent.mm.modelvideo.u.g((s)localObject1);
          if (((i == 112) || (i == 122)) && (j < 100)) {}
          for (bool = true;; bool = false)
          {
            ac.i("MicroMsg.ImageGalleryAdapter", "it is video downloading %b, status %d, download progress %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
            break;
          }
        }
        bool = false;
      }
    }
    if (b.m(localbo))
    {
      if ((j.ck(localbo) == null) && (!localbo.cru()))
      {
        ac.w("MicroMsg.ImageGalleryUI", "video info is null, return now.");
        AppMethodBeat.o(196595);
        return;
      }
      if (localbo.cru())
      {
        localObject1 = com.tencent.mm.plugin.webview.ui.tools.media.a.CKm;
        com.tencent.mm.plugin.webview.ui.tools.media.a.iS(fpB(), fpA());
      }
    }
    localObject1 = new ArrayList();
    final ArrayList localArrayList = new ArrayList();
    if (!bk.y(localbo))
    {
      ((List)localObject1).add(Integer.valueOf(0));
      localArrayList.add(getString(2131762566));
    }
    if (com.tencent.mm.br.d.aCT("favorite"))
    {
      ((List)localObject1).add(Integer.valueOf(2));
      localArrayList.add(getString(2131761941));
    }
    long l;
    if (!bk.y(localbo))
    {
      if ((b.j(localbo)) || (b.bT(localbo)))
      {
        ((List)localObject1).add(Integer.valueOf(1));
        localArrayList.add(getString(2131762781));
      }
    }
    else
    {
      Object localObject2;
      if ((this.Icy.containsKey(Integer.valueOf(1))) && (((Boolean)this.Icy.get(Integer.valueOf(1))).booleanValue()) && (!bs.isNullOrNil(cqG())))
      {
        ((List)localObject1).add(Integer.valueOf(7));
        localArrayList.add(getString(2131757184));
        localObject2 = new com.tencent.mm.g.b.a.bo();
        if (this.qOW != 2) {
          break label1143;
        }
        l = 1L;
        label627:
        ((com.tencent.mm.g.b.a.bo)localObject2).dHY = l;
        ((com.tencent.mm.g.b.a.bo)localObject2).dCQ = 2L;
        ((com.tencent.mm.g.b.a.bo)localObject2).dNc = 4L;
        ((com.tencent.mm.g.b.a.bo)localObject2).aHZ();
      }
      if ((b.j(localbo)) || (b.bR(localbo)))
      {
        localObject2 = new com.tencent.mm.g.a.dy();
        ((com.tencent.mm.g.a.dy)localObject2).ddK.msgId = localbo.field_msgId;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
        if ((((com.tencent.mm.g.a.dy)localObject2).ddL.ddj) || (com.tencent.mm.pluginsdk.model.app.h.am(getContext(), localbo.getType())))
        {
          ((List)localObject1).add(Integer.valueOf(4));
          localArrayList.add(getString(2131757228));
        }
      }
      if (b.j(localbo))
      {
        if (this.Ics != 1) {
          break label1149;
        }
        i = 0;
        label774:
        if (i != 0)
        {
          ((List)localObject1).add(Integer.valueOf(6));
          localArrayList.add(getString(2131757183));
        }
      }
      if ((this.Icy.containsKey(Integer.valueOf(2))) && (((Boolean)this.Icy.get(Integer.valueOf(2))).booleanValue()) && (aQy(this.yzo)))
      {
        ((List)localObject1).add(Integer.valueOf(3));
        localArrayList.add(this.Icw.ML(this.kYy));
      }
      if ((fpw()) && (!fjY()))
      {
        ((List)localObject1).add(Integer.valueOf(5));
        localArrayList.add(getString(2131757182));
      }
      if ((!bk.x(localbo)) || (fjY())) {
        break label1154;
      }
      ((List)localObject1).clear();
      localArrayList.clear();
      if (fpw())
      {
        ((List)localObject1).add(Integer.valueOf(5));
        localArrayList.add(getString(2131757182));
      }
    }
    label1143:
    label1149:
    while (!bk.z(localbo))
    {
      if (this.ngY == null) {
        this.ngY = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
      }
      this.ngY.ISu = new n.c()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(196568);
          ImageGalleryUI.f(ImageGalleryUI.this).setFooterView(null);
          paramAnonymousl.clear();
          int i = 0;
          if (i < this.piA.size())
          {
            if (((Integer)this.piA.get(i)).intValue() == 3)
            {
              com.tencent.mm.ui.widget.a.e locale = ImageGalleryUI.f(ImageGalleryUI.this);
              ImageGalleryUI localImageGalleryUI = ImageGalleryUI.this;
              localArrayList.get(i);
              locale.setFooterView(ImageGalleryUI.y(localImageGalleryUI));
            }
            for (;;)
            {
              i += 1;
              break;
              paramAnonymousl.c(((Integer)this.piA.get(i)).intValue(), (CharSequence)localArrayList.get(i));
            }
          }
          AppMethodBeat.o(196568);
        }
      };
      if (((List)localObject1).size() != 0) {
        break label1169;
      }
      ac.w("MicroMsg.ImageGalleryUI", "show menu itemIds.size() == 0");
      AppMethodBeat.o(196595);
      return;
      if ((b.m(localbo)) || (b.bR(localbo)))
      {
        if (localbo.cru()) {
          break;
        }
        ((List)localObject1).add(Integer.valueOf(1));
        localArrayList.add(getString(2131762784));
        break;
      }
      ((List)localObject1).add(Integer.valueOf(1));
      localArrayList.add(getString(2131762783));
      break;
      l = 0L;
      break label627;
      i = 1;
      break label774;
    }
    label1154:
    AppMethodBeat.o(196595);
    return;
    label1169:
    this.ngY.ISv = this.piv;
    this.ngY.Ihj = new e.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(196569);
        ImageGalleryUI.z(ImageGalleryUI.this);
        ImageGalleryUI.e(ImageGalleryUI.this).wVE = null;
        AppMethodBeat.o(196569);
      }
    };
    this.ngY.Jfm = new e.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(196573);
        if (ImageGalleryUI.i(ImageGalleryUI.this) == null)
        {
          AppMethodBeat.o(196573);
          return;
        }
        Object localObject = ImageGalleryUI.i(ImageGalleryUI.this).fpg();
        if ((localObject != null) && (((com.tencent.mm.storage.bo)localObject).cru()))
        {
          localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.CKm;
          com.tencent.mm.plugin.webview.ui.tools.media.a.aC(3, ImageGalleryUI.A(ImageGalleryUI.this), ImageGalleryUI.B(ImageGalleryUI.this));
        }
        AppMethodBeat.o(196573);
      }
    };
    this.ngY.cED();
    AppMethodBeat.o(196595);
  }
  
  public final void cj(com.tencent.mm.storage.bo parambo)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(36186);
        this.IbW = b.bV(parambo);
        ac.i("MicroMsg.ImageGalleryUI", "updateFooterInfo currGalleryType : " + this.IbW);
        if ((h.a.fpp().qSw) && (this.IcC != null)) {
          this.IcC.setChecked(h.a.fpp().ci(parambo));
        }
        switch (29.Iao[this.IbW.ordinal()])
        {
        case 1: 
          AppMethodBeat.o(36186);
          return;
        }
      }
      finally {}
      aE(this.Icg, 4);
      setVideoStateIv(true);
      parambo = j.ck(parambo);
      if (parambo == null)
      {
        AppMethodBeat.o(36186);
      }
      else
      {
        fpr().zRK.setVideoTotalTime(parambo.hpy);
        int i = j;
        try
        {
          if (this.HZU.fph() != null)
          {
            i = j;
            if (this.HZU.fph().IdK != null) {
              i = this.HZU.fph().IdK.getCurrentPosition() / 1000;
            }
          }
        }
        catch (Exception parambo)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.ImageGalleryUI", parambo, "", new Object[0]);
            i = j;
          }
        }
        fpr().zRK.seek(i);
        AppMethodBeat.o(36186);
        continue;
        com.tencent.mm.av.e locale = this.HZU.g(parambo, false);
        crF();
        fpx();
        if (locale == null)
        {
          ac.w("MicroMsg.ImageGalleryUI", "updateFooterInfo img info is null");
          AppMethodBeat.o(36186);
        }
        else if ((this.Icm) && (locale.aEZ()) && (this.HZU.fpg() != null) && (parambo.field_msgId == this.HZU.fpg().field_msgId))
        {
          ac.i("MicroMsg.ImageGalleryUI", "get image successfully! -> gotoPhotoEditUI msgId:%s", new Object[] { Long.valueOf(parambo.field_msgId) });
          fpJ();
          this.Icm = false;
          AppMethodBeat.o(36186);
        }
        else
        {
          com.tencent.mm.storage.bo localbo = this.HZU.fpg();
          boolean bool = this.Icm;
          long l = parambo.field_msgId;
          if (localbo == null) {}
          for (parambo = "null";; parambo = Long.valueOf(localbo.field_msgId))
          {
            ac.w("MicroMsg.ImageGalleryUI", "isSoonEnterPhotoEdit:%s msgId:%s curMsgId:%s getCompleted:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l), parambo, Boolean.valueOf(locale.aEZ()) });
            AppMethodBeat.o(36186);
            break;
          }
          crF();
          fpx();
          AppMethodBeat.o(36186);
          continue;
          crF();
          fpx();
          aE(this.Icg, 4);
          this.HZU.abs(this.sRJ.getCurrentItem());
        }
      }
    }
  }
  
  public final void crF()
  {
    AppMethodBeat.i(36184);
    ac.i("MicroMsg.ImageGalleryUI", "hide video tool bar");
    xt(false);
    aE(fpr().zRK, 8);
    aE(this.Icb, 8);
    aE(this.CKs, 8);
    AppMethodBeat.o(36184);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(36195);
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
    {
      if (this.ngY != null)
      {
        this.ngY.bmi();
        this.ngY = null;
      }
      for (;;)
      {
        AppMethodBeat.o(36195);
        return true;
        if ((this.qOW == 0) || (this.qOW == 2)) {
          cOM();
        } else {
          cOM();
        }
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(36195);
    return bool;
  }
  
  public final boolean een()
  {
    AppMethodBeat.i(36193);
    boolean bool = fpr().zRK.caY();
    AppMethodBeat.o(36193);
    return bool;
  }
  
  public void finish()
  {
    AppMethodBeat.i(36203);
    this.HTz.clear();
    super.finish();
    AppMethodBeat.o(36203);
  }
  
  protected final void fpD()
  {
    AppMethodBeat.i(36182);
    if (this.IcL)
    {
      if (fpC())
      {
        this.qUX.au(3000L, 3000L);
        AppMethodBeat.o(36182);
        return;
      }
      this.qUX.au(5000L, 5000L);
    }
    AppMethodBeat.o(36182);
  }
  
  public final b fpE()
  {
    return this.HZU;
  }
  
  public final void fpH()
  {
    AppMethodBeat.i(36201);
    crF();
    fpq().Icg.setVisibility(0);
    fpq().Ich.setVisibility(8);
    fpq().Ici.setVisibility(0);
    fpq().Icj.setVisibility(8);
    fpq().Ici.setText("0%");
    AppMethodBeat.o(36201);
  }
  
  final ImageGalleryUI fpq()
  {
    AppMethodBeat.i(36152);
    if (this.Icg == null)
    {
      this.Icg = findViewById(2131300930);
      this.Ich = ((Button)this.Icg.findViewById(2131298876));
      this.Ici = ((Button)this.Icg.findViewById(2131298877));
      this.Icj = this.Icg.findViewById(2131298878);
      TextView localTextView = (TextView)this.Icg.findViewById(2131298872);
      this.Ich.getPaint().setFakeBoldText(true);
      this.Ici.getPaint().setFakeBoldText(true);
      localTextView.getPaint().setFakeBoldText(true);
      float f = Math.min(1.125F, com.tencent.mm.cc.a.eb(this));
      this.Ich.setTextSize(1, 12.0F * f);
      this.Ici.setTextSize(1, f * 12.0F);
    }
    AppMethodBeat.o(36152);
    return this;
  }
  
  protected final ImageGalleryUI fpr()
  {
    AppMethodBeat.i(36153);
    if (this.zRK == null)
    {
      this.zRK = ((RedesignVideoPlayerSeekBar)findViewById(2131306375));
      this.zRK.setPlayBtnOnClickListener(this);
    }
    AppMethodBeat.o(36153);
    return this;
  }
  
  public final void fpx()
  {
    int j = 0;
    AppMethodBeat.i(36174);
    if (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) {
      ac.d("MicroMsg.ImageGalleryUI", "showOpLayer %s", new Object[] { bs.eWi() });
    }
    if (this.HZU != null) {}
    for (Object localObject1 = this.HZU.fpg();; localObject1 = null)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(36174);
        return;
      }
      if (bk.z((com.tencent.mm.storage.bo)localObject1))
      {
        ac.w("MicroMsg.ImageGalleryUI", "ignore show opLayer");
        AppMethodBeat.o(36174);
        return;
      }
      if (!this.IcL) {
        fpF();
      }
      this.IcL = true;
      this.IbX.setVisibility(0);
      fpD();
      long l;
      if (!fjY())
      {
        this.Icd.setVisibility(0);
        Object localObject2 = fps().Icc;
        if (this.Ico)
        {
          i = 0;
          aE((View)localObject2, i);
          if ((!this.Icy.containsKey(Integer.valueOf(2))) || (((Boolean)this.Icy.get(Integer.valueOf(2))).booleanValue()) || (!this.Ict)) {
            break label375;
          }
          localObject2 = new com.tencent.mm.g.b.a.bo();
          if (this.qOW != 2) {
            break label359;
          }
          l = 1L;
          label216:
          ((com.tencent.mm.g.b.a.bo)localObject2).dHY = l;
          ((com.tencent.mm.g.b.a.bo)localObject2).dCQ = 8L;
          ((com.tencent.mm.g.b.a.bo)localObject2).dNc = 10L;
          ((com.tencent.mm.g.b.a.bo)localObject2).aHZ();
        }
      }
      label359:
      label375:
      for (int i = 0;; i = 8)
      {
        if (i != this.Icf.getVisibility()) {
          this.Icf.setVisibility(i);
        }
        if (this.IbW != b.b.IaE) {}
        for (i = 0;; i = 1)
        {
          if ((bk.x((com.tencent.mm.storage.bo)localObject1)) || (bk.y((com.tencent.mm.storage.bo)localObject1))) {
            i = 0;
          }
          if (fjY()) {
            i = 0;
          }
          localObject1 = fpt().Ice;
          if (i != 0) {}
          for (i = j;; i = 8)
          {
            aE((View)localObject1, i);
            if (fpC()) {
              crG();
            }
            mC(true);
            xs(true);
            AppMethodBeat.o(36174);
            return;
            i = 8;
            break;
            l = 0L;
            break label216;
          }
        }
      }
    }
  }
  
  public final void fpy()
  {
    AppMethodBeat.i(36175);
    if (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) {
      ac.d("MicroMsg.ImageGalleryUI", "hideOpLayer %s", new Object[] { bs.eWi() });
    }
    if (!this.IcL)
    {
      AppMethodBeat.o(36175);
      return;
    }
    this.IcL = false;
    eFZ();
    AppMethodBeat.o(36175);
  }
  
  public final void fpz()
  {
    AppMethodBeat.i(36176);
    this.qUX.stopTimer();
    this.Icd.setVisibility(8);
    fps().Icc.clearAnimation();
    aE(fps().Icc, 8);
    aE(fpt().Ice, 8);
    this.Icf.setVisibility(8);
    crF();
    mC(false);
    xs(false);
    this.IbX.setVisibility(8);
    AppMethodBeat.o(36176);
  }
  
  public final int getCurrentItem()
  {
    AppMethodBeat.i(210140);
    int i = this.sRJ.getCurrentItem();
    AppMethodBeat.o(210140);
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
    this.ocV = new com.tencent.mm.ui.tools.e(getContext());
    this.isAnimated = false;
    this.talker = getIntent().getStringExtra("img_gallery_talker");
    this.Icp = getIntent().getBooleanExtra("img_gallery_enter_from_grid", false);
    this.HXt = getIntent().getBooleanExtra("img_gallery_enter_from_chatting_ui", false);
    this.Icr = getIntent().getBooleanExtra("img_gallery_enter_from_appbrand_service_chatting_ui", false);
    this.HXs = getIntent().getBooleanExtra("show_search_chat_content_result", false);
    this.Ico = getIntent().getBooleanExtra("show_enter_grid", true);
    this.qKh = getIntent().getBooleanExtra("key_is_biz_chat", false);
    this.nxq = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.IbY = getIntent().getBooleanExtra("img_preview_only", false);
    this.Ics = getIntent().getIntExtra("img_gallery_enter_from_scene", 0);
    this.HJK = getIntent().getIntExtra("msg_type", 0);
    if ((!this.IbY) && (bs.isNullOrNil(this.talker))) {
      ac.e("MicroMsg.ImageGalleryUI", " initView, talker is null. intent: " + getIntent());
    }
    this.chatroomName = getIntent().getStringExtra("img_gallery_chatroom_name");
    this.Icq = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
    this.Icu = getIntent().getStringExtra("img_gallery_enter_video_opcode");
    boolean bool2 = getIntent().getBooleanExtra("img_gallery_is_restransmit_after_download", false);
    String str = getIntent().getStringExtra("img_gallery_directly_send_name");
    this.qOZ = ((ImageView)findViewById(2131304342));
    this.qPa = ((ImageView)findViewById(2131304340));
    Object localObject = (FrameLayout.LayoutParams)this.qPa.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).bottomMargin += ap.ej(this);
    this.qPa.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.qPa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196590);
        paramAnonymousView = new com.tencent.mm.g.a.au();
        paramAnonymousView.dap.scene = 1;
        paramAnonymousView.dap.daq = ImageGalleryUI.j(ImageGalleryUI.this);
        com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
        ImageGalleryUI.h(ImageGalleryUI.this);
        ImageGalleryUI.k(ImageGalleryUI.this);
        AppMethodBeat.o(196590);
      }
    });
    this.qOY = ((ImageView)findViewById(2131304343));
    this.qPb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.qPb.setDuration(5000L);
    this.qPb.addListener(new ImageGalleryUI.5(this));
    int i = getWindowManager().getDefaultDisplay().getHeight();
    this.qPb.addUpdateListener(new ImageGalleryUI.6(this, i));
    this.msgId = getIntent().getLongExtra("img_gallery_msg_id", 0L);
    this.Iae = getIntent().getBooleanExtra("img_gallery_is_mp_video_without_msg", false);
    long l = getIntent().getLongExtra("img_gallery_msg_svr_id", 0L);
    if (!this.Iae)
    {
      if ((this.msgId <= 0L) && (l == 0L))
      {
        ac.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.msgId + ", msgSvrId = " + l + ", stack = " + bs.eWi());
        finish();
        AppMethodBeat.o(36163);
        return;
      }
      if (this.msgId == 0L)
      {
        az.ayM();
        this.msgId = com.tencent.mm.model.c.awD().aF(fpv(), l).field_msgId;
      }
      az.ayM();
      localObject = com.tencent.mm.model.c.awD().vP(this.msgId);
      if (((com.tencent.mm.g.c.dy)localObject).field_msgId <= 0L)
      {
        ac.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.msgId + ", msgSvrId = " + l + ", stack = " + bs.eWi());
        finish();
        AppMethodBeat.o(36163);
      }
    }
    else
    {
      localObject = j.e(this.talker, this);
    }
    for (;;)
    {
      boolean bool1;
      if (Br(this.msgId) == 3)
      {
        bool1 = true;
        this.Icv = bool1;
        this.HZU = new b(this, this.msgId, fpv(), this.qKh, this.nxq, bool2, str, Boolean.valueOf(this.Icq), this.HJK);
        this.HZU.Iaf = false;
        this.HZU.HZY = getIntent().getBooleanExtra("start_chatting_ui", true);
        this.HZU.Iad = new b.c()
        {
          public final void rB()
          {
            AppMethodBeat.i(196591);
            if (ImageGalleryUI.i(ImageGalleryUI.this) == null)
            {
              AppMethodBeat.o(196591);
              return;
            }
            ImageGalleryUI.this.fpx();
            ImageGalleryUI.l(ImageGalleryUI.this);
            ImageGalleryUI.i(ImageGalleryUI.this).onPageSelected(100000);
            AppMethodBeat.o(196591);
          }
        };
        this.qUO = ((RelativeLayout)findViewById(2131298875));
        this.IbX = ((RelativeLayout)findViewById(2131298880));
        this.qUO.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView) {}
        });
        this.Icb = findViewById(2131306316);
        this.Icb.setOnClickListener(this);
        this.Icd = findViewById(2131306373);
        this.Icf = findViewById(2131307467);
        if (!bj(this)) {
          break label1294;
        }
        eGb();
        label924:
        this.iBF = ((ImageView)findViewById(2131300336));
        this.sRJ = ((MMViewPager)findViewById(2131300335));
        this.sRJ.setVerticalFadingEdgeEnabled(false);
        this.sRJ.setHorizontalFadingEdgeEnabled(false);
        this.sRJ.setSingleClickOverListener(new MMViewPager.e()
        {
          public final void aOd()
          {
            AppMethodBeat.i(196592);
            ImageGalleryUI.m(ImageGalleryUI.this);
            AppMethodBeat.o(196592);
          }
          
          public final void cNW()
          {
            AppMethodBeat.i(196593);
            ImageGalleryUI.n(ImageGalleryUI.this);
            AppMethodBeat.o(196593);
          }
        });
        if (!this.IbY)
        {
          this.sRJ.setOnPageChangeListener(this.IcH);
          this.sRJ.setLongClickOverListener(new MMViewPager.c()
          {
            public final void aOe()
            {
              AppMethodBeat.i(196552);
              if (ImageGalleryUI.g(ImageGalleryUI.this) == 1)
              {
                AppMethodBeat.o(196552);
                return;
              }
              ImageGalleryUI.o(ImageGalleryUI.this);
              com.tencent.mm.g.b.a.bo localbo;
              if ((ImageGalleryUI.g(ImageGalleryUI.this) == 0) || (ImageGalleryUI.g(ImageGalleryUI.this) == 2))
              {
                localbo = new com.tencent.mm.g.b.a.bo();
                if (ImageGalleryUI.g(ImageGalleryUI.this) != 2) {
                  break label117;
                }
              }
              label117:
              for (long l = 1L;; l = 0L)
              {
                localbo.dHY = l;
                localbo.dCQ = 1L;
                localbo.dNc = 4L;
                localbo.aHZ();
                ImageGalleryUI.aQA(ImageGalleryUI.a(ImageGalleryUI.this));
                ImageGalleryUI.this.cOM();
                AppMethodBeat.o(196552);
                return;
              }
            }
          });
        }
        this.sRJ.setOffscreenPageLimit(1);
        this.sRJ.setAdapter(this.HZU);
        abz(100000);
        this.sRJ.setCurrentItem(100000);
        this.sRJ.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(196553);
            if (ImageGalleryUI.i(ImageGalleryUI.this) == null)
            {
              AppMethodBeat.o(196553);
              return;
            }
            if ((h.a.fpp().qSw) && (ImageGalleryUI.p(ImageGalleryUI.this) != null))
            {
              ImageGalleryUI.p(ImageGalleryUI.this).setChecked(h.a.fpp().ci(ImageGalleryUI.i(ImageGalleryUI.this).fpg()));
              ImageGalleryUI.q(ImageGalleryUI.this).setOnClickListener(ImageGalleryUI.this);
            }
            if (ImageGalleryUI.this.sRJ.getCurrentItem() != 100000)
            {
              AppMethodBeat.o(196553);
              return;
            }
            ImageGalleryUI.this.fpD();
            b.b localb = b.bV(ImageGalleryUI.i(ImageGalleryUI.this).aaP(100000));
            if ((!ImageGalleryUI.this.Icq) && (localb == b.b.IaF)) {
              ImageGalleryUI.i(ImageGalleryUI.this).abo(100000);
            }
            if (localb == b.b.IaG) {
              ImageGalleryUI.i(ImageGalleryUI.this).abs(100000);
            }
            AppMethodBeat.o(196553);
          }
        }, 0L);
        if (h.a.fpp().qSw)
        {
          this.IcB = ((ViewStub)findViewById(2131304544)).inflate();
          this.IcB.setVisibility(0);
          this.IcC = ((CheckBox)this.IcB.findViewById(2131302204));
          this.IcD = this.IcB.findViewById(2131302205);
        }
        this.Icm = getIntent().getBooleanExtra("img_gallery_enter_PhotoEditUI", false);
        localObject = this.HZU.g((com.tencent.mm.storage.bo)localObject, true);
        if (localObject == null) {
          ac.e("MicroMsg.ImageGalleryUI", "[initView] imgInfo is null!!! isSoonEnterPhotoEdit:%s", new Object[] { Boolean.valueOf(this.Icm) });
        }
        if ((!this.Icm) || (localObject == null) || (!((com.tencent.mm.av.e)localObject).aEZ())) {
          break label1301;
        }
        fpJ();
        this.Icm = false;
      }
      for (;;)
      {
        this.sRJ.setOnTouchListener(new ImageGalleryUI.4(this));
        if (fjY())
        {
          this.Icd.setVisibility(8);
          aE(fps().Icc, 8);
          aE(fpt().Ice, 8);
          aE(this.Icf, 8);
        }
        AppMethodBeat.o(36163);
        return;
        bool1 = false;
        break;
        label1294:
        eGc();
        break label924;
        label1301:
        if (this.Icm) {
          ac.w("MicroMsg.ImageGalleryUI", "img not GetCompleted!");
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
    if ((this.CAG != null) && (this.CAG.c(this, paramInt1, paramInt2, paramIntent)))
    {
      AppMethodBeat.o(36173);
      return;
    }
    AppMethodBeat.o(36173);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(36161);
    ac.i("MicroMsg.ImageGalleryUI", "onBackPressed");
    if (this.Icp)
    {
      abB(1);
      AppMethodBeat.o(36161);
      return;
    }
    try
    {
      h.a.fpp().detach();
      bSg();
      AppMethodBeat.o(36161);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.ImageGalleryUI", localException.getMessage());
      finish();
      AppMethodBeat.o(36161);
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = true;
    AppMethodBeat.i(36191);
    if (this.HZU == null)
    {
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131299498)
    {
      abB(0);
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131306373)
    {
      this.IbZ = false;
      cOM();
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131299194)
    {
      ac.i("MicroMsg.ImageGalleryUI", "[oreh download_and_save] hdImg suc, curPos:%d", new Object[] { Integer.valueOf(this.sRJ.getCurrentItem()) });
      paramView = this.HZU.aaP(this.sRJ.getCurrentItem());
      com.tencent.mm.av.e locale = this.HZU.g(paramView, false);
      this.sRJ.getCurrentItem();
      if ((f(paramView, locale)) && (!paramView.fbQ()) && (locale.aEZ()))
      {
        this.HZU.aZ(this.sRJ.getCurrentItem(), true);
        AppMethodBeat.o(36191);
        return;
      }
      b.c(getContext(), this.HZU.fpg(), true);
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131298876)
    {
      this.qOW = 2;
      this.qOV = 0;
      this.HZU.aZ(this.sRJ.getCurrentItem(), false);
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131298877)
    {
      this.HZU.abr(this.sRJ.getCurrentItem());
      abz(this.sRJ.getCurrentItem());
      fpx();
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131296416)
    {
      onBackPressed();
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131306316)
    {
      onBackPressed();
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131302205)
    {
      boolean bool2 = this.IcC.isChecked();
      if ((!bool2) && (h.a.fpp().qSv.size() >= 9))
      {
        Toast.makeText(this, getResources().getString(2131759803, new Object[] { Integer.valueOf(9) }), 1).show();
        AppMethodBeat.o(36191);
        return;
      }
      paramView = this.IcC;
      if (!bool2) {}
      for (;;)
      {
        paramView.setChecked(bool1);
        if (!this.IcC.isChecked()) {
          break;
        }
        h.a.fpp().cg(this.HZU.fpg());
        AppMethodBeat.o(36191);
        return;
        bool1 = false;
      }
      h.a.fpp().ch(this.HZU.fpg());
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131303281)
    {
      this.HZU.fph();
      this.HZU.abo(this.sRJ.getCurrentItem());
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131307467) {
      xq(true);
    }
    AppMethodBeat.o(36191);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(36206);
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      ac.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is vertical screen", new Object[] { Integer.valueOf(hashCode()) });
      eGb();
      AppMethodBeat.o(36206);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      ac.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is horizontal screen", new Object[] { Integer.valueOf(hashCode()) });
      eGc();
      AppMethodBeat.o(36206);
      return;
    }
    AppMethodBeat.o(36206);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(36157);
    requestWindowFeature(1);
    long l1 = System.currentTimeMillis();
    this.IcE = true;
    super.onCreate(paramBundle);
    long l2 = System.currentTimeMillis();
    this.Icx.dNF = l2;
    this.Icx.dNG = 1L;
    this.Icx.jT(com.tencent.mm.model.u.axw() + "_" + l2);
    if (com.tencent.mm.compatible.util.d.kZ(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (this.uJg = true;; this.uJg = false)
    {
      setLightNavigationbarIcon();
      initView();
      this.ocU = paramBundle;
      com.tencent.mm.sdk.b.a.GpY.c(this.qMM);
      com.tencent.mm.sdk.b.a.GpY.c(this.IcA);
      com.tencent.mm.sdk.b.a.GpY.c(this.yzx);
      com.tencent.mm.sdk.b.a.GpY.c(this.qPc);
      this.zRU = false;
      this.Icw = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a()
      {
        public final void bly()
        {
          AppMethodBeat.i(196589);
          if ((ImageGalleryUI.f(ImageGalleryUI.this) != null) && (ImageGalleryUI.f(ImageGalleryUI.this).isShowing())) {
            ImageGalleryUI.this.cOM();
          }
          AppMethodBeat.o(196589);
        }
      });
      ac.d("MicroMsg.ImageGalleryUI", "ImageGallery onCreate spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
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
    ac.i("MicroMsg.ImageGalleryUI", "%d image gallery ui on destroy", new Object[] { Integer.valueOf(hashCode()) });
    try
    {
      if (this.HZU != null)
      {
        abA(this.IcF);
        this.Ica.a(this, this.IcF, 0);
        this.HZU.detach();
        this.HZU = null;
      }
      this.qUX.stopTimer();
      cqU();
      this.qPb.removeAllUpdateListeners();
      com.tencent.mm.sdk.b.a.GpY.d(this.qMM);
      com.tencent.mm.sdk.b.a.GpY.d(this.IcA);
      com.tencent.mm.sdk.b.a.GpY.d(this.yzx);
      com.tencent.mm.sdk.b.a.GpY.d(this.qPc);
      com.tencent.mm.kernel.g.agQ().b(this.qPd);
      qf localqf = new qf();
      localqf.dtk.activity = this;
      com.tencent.mm.sdk.b.a.GpY.l(localqf);
      if (this.zRK != null) {
        this.zRK.setPlayBtnOnClickListener(null);
      }
      this.zRK = null;
      fpu();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.ImageGalleryUI", localException, "", new Object[0]);
      }
    }
    if (com.tencent.mm.graphics.b.c.gaZ.gbe) {
      com.tencent.mm.graphics.b.c.gaZ.stop();
    }
    super.onDestroy();
    AppMethodBeat.o(36160);
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
    ac.i("MicroMsg.ImageGalleryUI", "on pause");
    super.onPause();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(2048, 2048);
    }
    if ((!isFinishing()) && (this.HZU != null))
    {
      b localb = this.HZU;
      localb.Iab.Idl.sendEmptyMessageDelayed(1, 200L);
      localb.Iac.MT();
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
    if ((!this.IcE) && (this.HZU != null)) {
      abz(this.sRJ.getCurrentItem());
    }
    this.IcE = false;
    if (this.HZU != null) {
      this.HZU.fpi();
    }
    com.tencent.mm.kernel.g.agQ().a(this.qPd);
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    AppMethodBeat.o(36158);
  }
  
  public void onStart()
  {
    boolean bool = true;
    AppMethodBeat.i(36159);
    this.Icq = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
    Bundle localBundle;
    if (!this.IbY)
    {
      localBundle = this.ocU;
      ac.i("MicroMsg.ImageGalleryUI", "[handleAnimation] isAnimated:" + this.isAnimated);
      if (!this.isAnimated)
      {
        this.isAnimated = true;
        if (Build.VERSION.SDK_INT >= 12)
        {
          this.ocW = getIntent().getIntExtra("img_gallery_top", 0);
          this.ocX = getIntent().getIntExtra("img_gallery_left", 0);
          this.ocY = getIntent().getIntExtra("img_gallery_width", 0);
          this.ocZ = getIntent().getIntExtra("img_gallery_height", 0);
          if ((this.ocW == 0) && (this.ocX == 0) && (this.ocY == 0) && (this.ocZ == 0))
          {
            com.tencent.mm.storage.bo localbo = this.HZU.aaP(this.sRJ.getCurrentItem());
            if (localbo != null)
            {
              ba localba = new ba();
              localba.daD.cZc = localbo;
              com.tencent.mm.sdk.b.a.GpY.l(localba);
              this.ocY = localba.daE.daH;
              this.ocZ = localba.daE.daI;
              this.ocX = localba.daE.daF;
              this.ocW = localba.daE.daG;
            }
          }
          this.ocV.R(this.ocX, this.ocW, this.ocY, this.ocZ);
          if (localBundle != null) {
            break label343;
          }
        }
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.ImageGalleryUI", "[handleAnimation] savedInstanceState is null?%s", new Object[] { Boolean.valueOf(bool) });
      if (localBundle == null) {
        this.sRJ.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(196561);
            ImageGalleryUI.this.sRJ.getViewTreeObserver().removeOnPreDrawListener(this);
            ac.i("MicroMsg.ImageGalleryUI", "[handleAnimation] -> onPreDraw, isBackFromGrid:" + ImageGalleryUI.this.Icq);
            ImageGalleryUI.this.yIO = ImageGalleryUI.this.sRJ.getWidth();
            ImageGalleryUI.this.yIP = ImageGalleryUI.this.sRJ.getHeight();
            if (ImageGalleryUI.i(ImageGalleryUI.this).fpg().crv()) {
              ImageGalleryUI.this.yIP = ((int)(ImageGalleryUI.this.yIO / ImageGalleryUI.this.ocY * ImageGalleryUI.this.ocZ));
            }
            if (ImageGalleryUI.i(ImageGalleryUI.this).fpg().eZm())
            {
              com.tencent.mm.ui.base.g localg = (com.tencent.mm.ui.base.g)ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.i(ImageGalleryUI.this), ImageGalleryUI.this.sRJ);
              if (localg != null)
              {
                ImageGalleryUI localImageGalleryUI = ImageGalleryUI.this;
                float f = ImageGalleryUI.this.yIO / localg.getImageWidth();
                localImageGalleryUI.yIP = ((int)(localg.getImageHeight() * f));
                if (ImageGalleryUI.this.yIP > ImageGalleryUI.this.sRJ.getHeight()) {
                  ImageGalleryUI.this.yIP = ImageGalleryUI.this.sRJ.getHeight();
                }
              }
            }
            ImageGalleryUI.this.ocV.jN(ImageGalleryUI.this.yIO, ImageGalleryUI.this.yIP);
            if (!ImageGalleryUI.this.Icq) {
              ImageGalleryUI.this.ocV.a(ImageGalleryUI.this.sRJ, ImageGalleryUI.s(ImageGalleryUI.this), new e.c()
              {
                public final void onAnimationEnd()
                {
                  AppMethodBeat.i(196560);
                  ImageGalleryUI.t(ImageGalleryUI.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(196558);
                      if (ImageGalleryUI.this.Icz != null) {
                        ImageGalleryUI.this.Icz.o(Boolean.FALSE);
                      }
                      AppMethodBeat.o(196558);
                    }
                  });
                  AppMethodBeat.o(196560);
                }
                
                public final void onAnimationStart()
                {
                  AppMethodBeat.i(196559);
                  if (ImageGalleryUI.this.Icz != null) {
                    ImageGalleryUI.this.Icz.o(Boolean.TRUE);
                  }
                  AppMethodBeat.o(196559);
                }
              });
            }
            ImageGalleryUI.u(ImageGalleryUI.this);
            AppMethodBeat.o(196561);
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
    com.tencent.mm.graphics.b.d.gbh.aeu();
    if (com.tencent.mm.graphics.b.c.gaZ.gbe) {
      com.tencent.mm.graphics.b.c.gaZ.stop();
    }
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
      RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = fpr().zRK;
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
      ac.e("MicroMsg.ImageGalleryUI", "set video state iv error : " + localException.toString());
      AppMethodBeat.o(36192);
    }
  }
  
  public static abstract interface a
  {
    public abstract void o(Boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI
 * JD-Core Version:    0.7.0.1
 */