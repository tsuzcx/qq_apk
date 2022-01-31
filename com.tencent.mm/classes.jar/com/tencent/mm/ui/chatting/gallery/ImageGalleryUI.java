package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager.e;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.R.a;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.al;
import com.tencent.mm.h.a.as;
import com.tencent.mm.h.a.as.b;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.h.a.gp;
import com.tencent.mm.h.a.gp.b;
import com.tencent.mm.h.a.mz;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMNewPhotoEditUI;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import junit.framework.Assert;

@com.tencent.mm.kernel.j
@com.tencent.mm.ui.base.a(3)
public class ImageGalleryUI
  extends MMActivity
  implements View.OnClickListener, am.a
{
  public long bIt;
  protected String chatroomName;
  private View contentView;
  private int gGr;
  private int gGs;
  public long idK;
  com.tencent.mm.ui.tools.e itA;
  int itB = 0;
  int itC = 0;
  int itD = 0;
  int itE = 0;
  Bundle ity;
  private boolean itz = false;
  private n.d jfN = new ImageGalleryUI.5(this);
  protected MMViewPager kJC;
  public boolean kax = false;
  private com.tencent.mm.sdk.b.c kbV = new ImageGalleryUI.1(this);
  private ImageView kgw;
  private ah mHandler = new ah(Looper.getMainLooper());
  private boolean mfb;
  private com.tencent.mm.ui.widget.a.d oOK;
  private String oOL;
  private String oOO;
  private boolean oOP = false;
  private com.tencent.mm.sdk.b.c oOV = new ImageGalleryUI.12(this);
  int oVF;
  int oVG;
  int oVH = 0;
  private float oVI = 1.0F;
  private int oVJ = 0;
  private int oVK = 0;
  protected String talker;
  private HashSet<Long> vpy = new HashSet();
  private boolean vrP = false;
  protected boolean vrQ = false;
  public c vtH;
  private final boolean vtS = false;
  private c.b vvH;
  private RelativeLayout vvI;
  private RelativeLayout vvJ;
  private boolean vvK;
  private boolean vvL = false;
  private ImageView vvM;
  private RelativeLayout vvN;
  private RelativeLayout vvO;
  private FrameLayout vvP;
  View vvQ;
  Button vvR;
  Button vvS;
  View vvT;
  private View vvU;
  protected VideoPlayerSeekBar vvV;
  private boolean vvW;
  private MultiTouchImageView vvX;
  private WxImageView vvY;
  int vvZ = 0;
  int vwa = 0;
  boolean vwb;
  ArrayList<Integer> vwc = new ArrayList();
  protected boolean vwd = false;
  protected boolean vwe = false;
  private boolean vwf;
  private String vwg = null;
  public ImageGalleryUI.a vwh;
  private View vwi;
  private CheckBox vwj;
  private View vwk;
  private boolean vwl = true;
  private int vwm = 0;
  private ViewPager.e vwn = new ViewPager.e()
  {
    private boolean vwy = false;
    
    public final void Q(int paramAnonymousInt)
    {
      y.d("MicroMsg.ImageGalleryUI", "onPageScrollStateChanged: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
      if (paramAnonymousInt == 2)
      {
        this.vwy = true;
        ImageGalleryUI.C(ImageGalleryUI.this);
        ImageGalleryUI.D(ImageGalleryUI.this);
        ImageGalleryUI.E(ImageGalleryUI.this);
      }
      if (paramAnonymousInt == 0)
      {
        if (this.vwy) {
          ImageGalleryUI.this.cGw();
        }
        this.vwy = false;
      }
      if (ImageGalleryUI.f(ImageGalleryUI.this) != null)
      {
        Object localObject = ImageGalleryUI.f(ImageGalleryUI.this);
        if (((c)localObject).vtO != null)
        {
          localObject = ((c)localObject).vtO;
          ((e)localObject).lf = paramAnonymousInt;
          if (((e)localObject).vva != null) {
            ((e)localObject).vva.Q(paramAnonymousInt);
          }
        }
      }
    }
    
    public final void R(int paramAnonymousInt)
    {
      if (ImageGalleryUI.f(ImageGalleryUI.this) == null) {}
      label514:
      label531:
      for (;;)
      {
        return;
        ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.f(ImageGalleryUI.this).rX(paramAnonymousInt));
        ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.f(ImageGalleryUI.this).rY(paramAnonymousInt));
        Object localObject1;
        Object localObject2;
        label231:
        long l;
        if ((ImageGalleryUI.l(ImageGalleryUI.this) == null) && (ImageGalleryUI.m(ImageGalleryUI.this) != null))
        {
          ImageGalleryUI.b(ImageGalleryUI.this, true);
          localObject1 = ImageGalleryUI.f(ImageGalleryUI.this).Gs(paramAnonymousInt);
          if (localObject1 == null) {
            y.e("MicroMsg.ImageGalleryUI", "onPageSelected the view is null, position = %s ", new Object[] { Integer.valueOf(paramAnonymousInt) });
          }
          ImageGalleryUI.r(ImageGalleryUI.this);
          ImageGalleryUI.e(ImageGalleryUI.this, paramAnonymousInt);
          if (ImageGalleryUI.f(ImageGalleryUI.this) != null)
          {
            localObject2 = ImageGalleryUI.f(ImageGalleryUI.this);
            ((c)localObject2).vtP.cGd();
            ((c)localObject2).vtQ.cGd();
            localObject2 = ImageGalleryUI.f(ImageGalleryUI.this).GW(paramAnonymousInt);
            if (((c.be((bi)localObject2)) || (c.bh((bi)localObject2))) && (localObject1 != null) && (((View)localObject1).getTag() != null))
            {
              if (!ImageGalleryUI.B(ImageGalleryUI.this)) {
                break label404;
              }
              ((k)((View)localObject1).getTag()).vxw.cAy();
            }
            if (localObject2 != null) {
              ImageGalleryUI.this.ib(((cs)localObject2).field_msgId);
            }
            if (ImageGalleryUI.f(ImageGalleryUI.this) == null) {
              break label503;
            }
            localObject1 = ImageGalleryUI.f(ImageGalleryUI.this).h((bi)localObject2, false);
            ImageGalleryUI.f(ImageGalleryUI.this);
            if (!c.a((bi)localObject2, (com.tencent.mm.as.e)localObject1)) {
              break label427;
            }
            localObject1 = com.tencent.mm.as.f.a((com.tencent.mm.as.e)localObject1);
            int i = ((com.tencent.mm.as.e)localObject1).ebK;
            int j = ((com.tencent.mm.as.e)localObject1).offset;
            if (i == 0) {
              break label421;
            }
            l = j * 100L / i - 1L;
            label327:
            i = Math.max(1, (int)l);
            y.d("MicroMsg.ImageGalleryUI", "jacks loading hd from imgInfo : %d, time: %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()) });
            ImageGalleryUI.this.HD(i);
          }
        }
        for (;;)
        {
          if (ImageGalleryUI.f(ImageGalleryUI.this) == null) {
            break label531;
          }
          ImageGalleryUI.f(ImageGalleryUI.this).R(paramAnonymousInt);
          return;
          ImageGalleryUI.b(ImageGalleryUI.this, false);
          break;
          label404:
          ((k)((View)localObject1).getTag()).vxv.cAy();
          break label231;
          label421:
          l = 0L;
          break label327;
          label427:
          if ((localObject2 != null) && (!((bi)localObject2).aRQ()) && (ImageGalleryUI.f(ImageGalleryUI.this).bj((bi)localObject2)))
          {
            ImageGalleryUI.this.gs(false);
          }
          else
          {
            ImageGalleryUI.this.gs(true);
            for (;;)
            {
              if (localObject2 != null) {
                break label514;
              }
              y.e("MicroMsg.ImageGalleryUI", "update footer fail, msg is null, position = " + paramAnonymousInt);
              break;
              label503:
              y.e("MicroMsg.ImageGalleryUI", "[arthurdan.ImageGallery] Notice!!! adapter is null");
            }
            ImageGalleryUI.this.by((bi)localObject2);
            ImageGalleryUI.g(ImageGalleryUI.this);
          }
        }
      }
    }
    
    public final void a(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
  };
  boolean vwo = false;
  am vwp = new am(new ImageGalleryUI.7(this), false);
  private HashMap<Long, String> vwq = new HashMap();
  private boolean vwr = false;
  private boolean vws = false;
  private am vwt;
  private boolean vwu = false;
  private boolean vwv = false;
  
  private void HA(int paramInt)
  {
    y.i("MicroMsg.ImageGalleryUI", "enterGrid source : " + paramInt);
    if (this.vtH == null)
    {
      y.w("MicroMsg.ImageGalleryUI", "try to enterGrid, but adapter is NULL");
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.a(219L, 13L, 1L, true);
    int i = this.vtH.getRealCount();
    if (this.vtH.cFU() == null)
    {
      y.e("MicroMsg.ImageGalleryUI", "msgInfo is null");
      return;
    }
    int j = this.vtH.vtK.Ht(this.kJC.getCurrentItem());
    if (!this.vwd)
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this.mController.uMN, MediaHistoryGalleryUI.class);
      localIntent.addFlags(67108864);
      localIntent.putExtra("kintent_intent_source", paramInt);
      localIntent.putExtra("kintent_talker", cGi());
      localIntent.putExtra("kintent_image_count", i);
      localIntent.putExtra("kintent_image_index", j);
      localIntent.putExtra("key_biz_chat_id", this.idK);
      localIntent.putExtra("key_is_biz_chat", this.kax);
      startActivity(localIntent);
      this.mHandler.postDelayed(new ImageGalleryUI.8(this), 50L);
      return;
    }
    aBR();
  }
  
  static Animation HC(int paramInt)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(paramInt);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator(10.0F));
    return localAlphaAnimation;
  }
  
  private static void W(View paramView, int paramInt)
  {
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
  }
  
  private View a(c paramc, MMViewPager paramMMViewPager)
  {
    boolean bool1;
    if (paramc == null)
    {
      bool1 = true;
      if (paramMMViewPager != null) {
        break label63;
      }
    }
    label63:
    for (boolean bool2 = true;; bool2 = false)
    {
      y.d("MicroMsg.ImageGalleryUI", "get current view adapter is null %b, gallery is null %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((paramc == null) || (paramMMViewPager == null)) {
        break label154;
      }
      if (paramc.cFU() != null) {
        break label69;
      }
      return null;
      bool1 = false;
      break;
    }
    label69:
    Object localObject;
    if ((paramc.cFU().ctB()) || (paramc.cFU().cvr()))
    {
      MultiTouchImageView localMultiTouchImageView = paramc.rX(paramMMViewPager.getCurrentItem());
      localObject = localMultiTouchImageView;
      if (localMultiTouchImageView == null) {
        localObject = paramc.rY(paramMMViewPager.getCurrentItem());
      }
    }
    for (;;)
    {
      return localObject;
      if ((paramc.cFU().aRQ()) || (paramc.cFU().aRR()))
      {
        localObject = paramc.Hn(paramMMViewPager.getCurrentItem());
        continue;
        label154:
        y.w("MicroMsg.ImageGalleryUI", "%d get current view but adapter or gallery is null", new Object[] { Integer.valueOf(hashCode()) });
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  private void aBR()
  {
    if ((this.vvL) || (this.vtH == null))
    {
      y.i("MicroMsg.ImageGalleryUI", "isRunningExitAnimation");
      return;
    }
    if (this.vvK)
    {
      finish();
      com.tencent.mm.ui.base.b.gJ(this.mController.uMN);
      return;
    }
    y.i("MicroMsg.ImageGalleryUI", "runExitAnimation");
    int k = this.kJC.getWidth() / 2;
    int j = this.kJC.getHeight() / 2;
    this.vtH.cFS();
    Object localObject1;
    int n;
    int i;
    int m;
    label427:
    label438:
    Object localObject2;
    if (this.vwd)
    {
      localObject1 = new gp();
      ((gp)localObject1).bOq.bIt = this.vtH.GW(this.kJC.getCurrentItem()).field_msgId;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      n = ((gp)localObject1).bOr.bGW;
      i = ((gp)localObject1).bOr.bGX;
      k = ((gp)localObject1).bOr.bGU;
      j = ((gp)localObject1).bOr.bGV;
      this.oVF = this.kJC.getWidth();
      this.oVG = this.kJC.getHeight();
      if (this.vtH.cFU() != null)
      {
        if ((this.vtH.cFU().aRR()) || (this.vtH.cFU().aRQ())) {
          this.oVG = ((int)(this.oVF / n * i));
        }
        if ((this.vtH.cFU().ctB()) || (this.vtH.cFU().cvr()))
        {
          this.vvX = this.vtH.rX(this.kJC.getCurrentItem());
          if (this.vvX == null)
          {
            localObject1 = this.vtH.rY(this.kJC.getCurrentItem());
            if (localObject1 != null) {
              this.vvY = ((WxImageView)localObject1);
            }
          }
        }
      }
      if (this.vvX == null) {
        break label880;
      }
      this.oVG = ((int)(this.oVF / this.vvX.getImageWidth() * this.vvX.getImageHeight()));
      m = i;
      if (this.oVG > this.kJC.getHeight())
      {
        m = i;
        if (this.oVG < this.kJC.getHeight() * 1.5D)
        {
          if (this.vwd)
          {
            this.oVH = (this.oVG - this.kJC.getHeight());
            m = i;
          }
        }
        else {
          this.oVG = this.kJC.getHeight();
        }
      }
      else
      {
        localObject1 = this.itA;
        i = this.vvZ;
        int i1 = this.vwa;
        ((com.tencent.mm.ui.tools.e)localObject1).wcC = i;
        ((com.tencent.mm.ui.tools.e)localObject1).wcD = i1;
        ((com.tencent.mm.ui.tools.e)localObject1).wcE = 0;
        ((com.tencent.mm.ui.tools.e)localObject1).wcF = 0;
        this.itA.wcB = this.oVH;
        this.itA.fH(this.oVF, this.oVG);
        this.itA.E(k, j, n, m);
        localObject1 = this.kJC;
        localObject2 = a(this.vtH, this.kJC);
        if (localObject2 == null) {
          break label1018;
        }
        localObject1 = localObject2;
        if (this.oVI != 1.0D)
        {
          this.itA.wcx = (1.0F / this.oVI);
          if (this.oVJ == 0)
          {
            localObject1 = localObject2;
            if (this.oVK == 0) {}
          }
          else
          {
            i = (int)(this.kJC.getWidth() / 2 * (1.0F - this.oVI));
            j = this.oVJ;
            k = (int)(this.kJC.getHeight() / 2 + this.oVK - this.oVG / 2 * this.oVI);
            this.itA.fI(i + j, k);
            localObject1 = localObject2;
          }
        }
        label658:
        this.itA.a((View)localObject1, this.kgw, new ImageGalleryUI.2(this), null);
      }
    }
    else
    {
      localObject1 = this.vtH.GW(this.kJC.getCurrentItem());
      if (localObject1 == null) {
        break label1021;
      }
      localObject2 = new as();
      ((as)localObject2).bGS.bFH = ((bi)localObject1);
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
      m = ((as)localObject2).bGT.bGW;
      i = ((as)localObject2).bGT.bGX;
      k = ((as)localObject2).bGT.bGU;
      j = ((as)localObject2).bGT.bGV;
    }
    for (;;)
    {
      if ((k == 0) && (j == 0))
      {
        k = this.kJC.getWidth() / 2;
        j = this.kJC.getHeight() / 2;
        n = m;
        break;
      }
      if (localObject1 != null)
      {
        if (((cs)localObject1).field_isSend == 0) {
          this.vvZ = com.tencent.mm.cb.a.fromDPToPix(this.mController.uMN, 5);
        }
        if (((cs)localObject1).field_isSend == 1) {
          this.vwa = com.tencent.mm.cb.a.fromDPToPix(this.mController.uMN, 5);
        }
      }
      n = m;
      break;
      m = this.kJC.getHeight() * i / this.oVG;
      break label427;
      label880:
      m = i;
      if (this.vvY == null) {
        break label438;
      }
      this.oVG = ((int)(this.oVF / this.vvY.getImageWidth() * this.vvY.getImageHeight()));
      m = i;
      if (this.oVG <= this.kJC.getHeight()) {
        break label438;
      }
      m = i;
      if (this.oVG < this.kJC.getHeight() * 1.5D)
      {
        if (!this.vwd) {
          break label999;
        }
        this.oVH = (this.oVG - this.kJC.getHeight());
      }
      label999:
      for (m = i;; m = this.kJC.getHeight() * i / this.oVG)
      {
        this.oVG = this.kJC.getHeight();
        break;
      }
      label1018:
      break label658;
      label1021:
      i = 0;
      m = 0;
    }
  }
  
  private boolean adE(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    if (!this.vwf) {
      return true;
    }
    String[] arrayOfString = ((String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.utn, "")).split("\\|");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((!bk.bl(str)) && (paramString.startsWith(str)))
        {
          y.i("MicroMsg.ImageGalleryUI", "curDealQBarStr:%s, blockQrcodeStr:%s", new Object[] { paramString, str });
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  private void cGA()
  {
    String str1 = getIntent().getStringExtra("GalleryUI_FromUser");
    String str2 = getIntent().getStringExtra("GalleryUI_ToUser");
    Intent localIntent = new Intent();
    bi localbi = this.vtH.cFU();
    String str3 = e.d(localbi, e.bt(localbi));
    y.i("MicroMsg.ImageGalleryUI", "edit image path:%s msgId:%s", new Object[] { str3, Long.valueOf(localbi.field_msgId) });
    localIntent.putExtra("before_photo_edit", str3);
    localIntent.putExtra("GalleryUI_FromUser", str1);
    localIntent.putExtra("GalleryUI_ToUser", str2);
    localIntent.putExtra("GalleryUI_ToUser", str2);
    localIntent.putExtra("from_scene", 291);
    localIntent.putExtra("after_photo_edit", "");
    localIntent.setClass(this, MMNewPhotoEditUI.class);
    startActivityForResult(localIntent, 4369);
    overridePendingTransition(0, 0);
  }
  
  private ImageGalleryUI cGg()
  {
    if (this.vvN == null) {
      this.vvN = ((RelativeLayout)((ViewStub)findViewById(R.h.goto_grid_gallery_ll)).inflate());
    }
    return this;
  }
  
  private ImageGalleryUI cGh()
  {
    if (this.vvO == null)
    {
      this.vvO = ((RelativeLayout)((ViewStub)findViewById(R.h.image_footer_download_rl)).inflate());
      this.vvO.findViewById(R.h.download_and_save_icon).setOnClickListener(this);
    }
    return this;
  }
  
  private String cGi()
  {
    if ((this.chatroomName != null) && (this.chatroomName.length() > 0)) {
      return this.chatroomName;
    }
    return this.talker;
  }
  
  private void cGj()
  {
    if ((this.vtH == null) || (this.vvK)) {}
    while ((!this.vtH.cFT()) || (cGg().vvN == null)) {
      return;
    }
    if (h.a.cGc().khC)
    {
      cGl();
      return;
    }
    if (this.vrP)
    {
      cGl();
      return;
    }
    y.d("MicroMsg.ImageGalleryUI", "%d show enter grid is video %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(cGm()) });
    cGk();
    cGw();
  }
  
  private void cGk()
  {
    int j = 0;
    W(cGg().vvN, 0);
    Object localObject = null;
    if (this.vtH != null) {
      localObject = this.vtH.cFU();
    }
    int i = 1;
    if (this.vvH != c.b.vuo) {
      i = 0;
    }
    if ((localObject != null) && (bf.k((bi)localObject))) {
      i = 0;
    }
    for (;;)
    {
      localObject = cGh().vvO;
      if (i != 0) {}
      for (i = j;; i = 8)
      {
        W((View)localObject, i);
        return;
      }
    }
  }
  
  private void cGl()
  {
    W(cGg().vvN, 8);
    W(cGh().vvO, 8);
  }
  
  private boolean cGm()
  {
    return this.vvH == c.b.vup;
  }
  
  public static void cGq() {}
  
  private void cGt()
  {
    if ((cGg().vvN == null) || (!this.vwu) || (cGm())) {
      return;
    }
    if (cGg().vvN.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.ImageGalleryUI", "fadeInEnterGirdBtn: %B %s", new Object[] { Boolean.valueOf(bool), bk.csb() });
      cGg().vvN.startAnimation(cGv());
      cGh().vvO.startAnimation(cGv());
      this.vwu = false;
      return;
    }
  }
  
  private void cGu()
  {
    boolean bool = true;
    if ((cGg().vvP == null) || (!this.vwv)) {
      return;
    }
    if (cGg().vvP.getVisibility() == 0) {}
    for (;;)
    {
      y.d("MicroMsg.ImageGalleryUI", "fadeInPositionAtChatRecordBtn: %B", new Object[] { Boolean.valueOf(bool) });
      cGg().vvP.startAnimation(cGv());
      this.vwv = false;
      return;
      bool = false;
    }
  }
  
  private static Animation cGv()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(150L);
    localAlphaAnimation.setFillAfter(true);
    return localAlphaAnimation;
  }
  
  private void cGx()
  {
    y.d("MicroMsg.ImageGalleryUI", "jacks stop Hide Timer");
    this.vwt.stopTimer();
  }
  
  private void cGy()
  {
    boolean bool = ak.gw(this);
    int i = ak.gv(this);
    y.i("MicroMsg.ImageGalleryUI", "%d handleVerticalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.mfb), Boolean.valueOf(bool), Integer.valueOf(i) });
    if ((this.mfb) && (bool))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.vvI.getLayoutParams());
      localLayoutParams.addRule(12);
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, i);
      this.vvI.setLayoutParams(localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(this.vvJ.getLayoutParams());
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, 0, localLayoutParams.bottomMargin);
      this.vvJ.setLayoutParams(localLayoutParams);
    }
  }
  
  private void cGz()
  {
    boolean bool = ak.gw(this);
    int i = ak.gv(this);
    y.i("MicroMsg.ImageGalleryUI", "%d handleHorizontalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.mfb), Boolean.valueOf(bool), Integer.valueOf(i) });
    if ((this.mfb) && (bool))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.vvI.getLayoutParams());
      localLayoutParams.addRule(12);
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, i, 0);
      this.vvI.setLayoutParams(localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(this.vvJ.getLayoutParams());
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, i, localLayoutParams.bottomMargin);
      this.vvJ.setLayoutParams(localLayoutParams);
    }
  }
  
  private static int dK(View paramView)
  {
    if (paramView != null) {
      return paramView.getVisibility();
    }
    return 8;
  }
  
  private static void dL(View paramView)
  {
    if (com.tencent.mm.compatible.util.d.gF(16))
    {
      paramView.setBackground(null);
      return;
    }
    paramView.setBackgroundDrawable(null);
  }
  
  private static boolean f(bi parambi, com.tencent.mm.as.e parame)
  {
    if (parame == null) {}
    for (;;)
    {
      return false;
      try
      {
        if ((c.b(parambi, parame) == 0) && (parame.Or()))
        {
          boolean bool = parambi.cvx();
          if (!bool) {
            return true;
          }
        }
      }
      catch (NullPointerException parambi)
      {
        y.e("MicroMsg.ImageGalleryUI", "error:" + parambi);
      }
    }
    return false;
  }
  
  private void nr(boolean paramBoolean)
  {
    y.d("MicroMsg.ImageGalleryUI", "switch tool bar bg %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.vvJ.setBackgroundResource(R.g.image_gallery_video_top_bg);
      this.vvI.setBackgroundResource(R.g.image_gallery_video_bottom_bg);
      return;
    }
    dL(this.vvJ);
    dL(this.vvI);
  }
  
  public final void HB(int paramInt)
  {
    if (cGf().vvU == null) {
      return;
    }
    cGf().vvU.post(new ImageGalleryUI.9(this, paramInt));
  }
  
  public final void HD(int paramInt)
  {
    gs(true);
    cGp();
    cGe().vvQ.setVisibility(0);
    cGe().vvR.setVisibility(8);
    cGe().vvS.setVisibility(0);
    cGe().vvT.setVisibility(8);
    cGr();
    cGs();
    cGe().vvS.setText(paramInt + "%");
  }
  
  public final void Hz(int paramInt)
  {
    by(this.vtH.GW(paramInt));
  }
  
  public final boolean bOu()
  {
    return cGf().vvV.bNU;
  }
  
  /* Error */
  public final void by(bi parambi)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: aload_1
    //   7: invokestatic 1269	com/tencent/mm/ui/chatting/gallery/c:bk	(Lcom/tencent/mm/storage/bi;)Lcom/tencent/mm/ui/chatting/gallery/c$b;
    //   10: putfield 941	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vvH	Lcom/tencent/mm/ui/chatting/gallery/c$b;
    //   13: ldc_w 276
    //   16: new 278	java/lang/StringBuilder
    //   19: dup
    //   20: ldc_w 1271
    //   23: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 941	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vvH	Lcom/tencent/mm/ui/chatting/gallery/c$b;
    //   30: invokevirtual 1084	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 297	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: invokestatic 921	com/tencent/mm/ui/chatting/gallery/h$a:cGc	()Lcom/tencent/mm/ui/chatting/gallery/h;
    //   42: getfield 926	com/tencent/mm/ui/chatting/gallery/h:khC	Z
    //   45: ifeq +24 -> 69
    //   48: aload_0
    //   49: getfield 1122	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vwj	Landroid/widget/CheckBox;
    //   52: ifnull +17 -> 69
    //   55: aload_0
    //   56: getfield 1122	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vwj	Landroid/widget/CheckBox;
    //   59: invokestatic 921	com/tencent/mm/ui/chatting/gallery/h$a:cGc	()Lcom/tencent/mm/ui/chatting/gallery/h;
    //   62: aload_1
    //   63: invokevirtual 1274	com/tencent/mm/ui/chatting/gallery/h:bx	(Lcom/tencent/mm/storage/bi;)Z
    //   66: invokevirtual 1279	android/widget/CheckBox:setChecked	(Z)V
    //   69: getstatic 1283	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$13:vtY	[I
    //   72: aload_0
    //   73: getfield 941	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vvH	Lcom/tencent/mm/ui/chatting/gallery/c$b;
    //   76: invokevirtual 1286	com/tencent/mm/ui/chatting/gallery/c$b:ordinal	()I
    //   79: iaload
    //   80: istore_3
    //   81: iload_3
    //   82: tableswitch	default:+30 -> 112, 1:+33->115, 2:+163->245, 3:+729->811, 4:+740->822
    //   113: monitorexit
    //   114: return
    //   115: aload_0
    //   116: invokevirtual 1112	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:cGp	()V
    //   119: aload_0
    //   120: getfield 456	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vvQ	Landroid/view/View;
    //   123: bipush 8
    //   125: invokestatic 939	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:W	(Landroid/view/View;I)V
    //   128: aload_0
    //   129: iconst_1
    //   130: invokevirtual 1289	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:ns	(Z)V
    //   133: aload_1
    //   134: invokestatic 1295	com/tencent/mm/ui/chatting/gallery/j:bz	(Lcom/tencent/mm/storage/bi;)Lcom/tencent/mm/modelvideo/s;
    //   137: astore_1
    //   138: aload_1
    //   139: ifnull -27 -> 112
    //   142: aload_0
    //   143: invokevirtual 1214	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:cGf	()Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryUI;
    //   146: getfield 1260	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vvV	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   149: aload_1
    //   150: getfield 1300	com/tencent/mm/modelvideo/s:eHH	I
    //   153: invokevirtual 1303	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVideoTotalTime	(I)V
    //   156: iload 4
    //   158: istore_3
    //   159: aload_0
    //   160: getfield 299	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vtH	Lcom/tencent/mm/ui/chatting/gallery/c;
    //   163: invokevirtual 1095	com/tencent/mm/ui/chatting/gallery/c:cFV	()Lcom/tencent/mm/ui/chatting/gallery/k;
    //   166: ifnull +39 -> 205
    //   169: iload 4
    //   171: istore_3
    //   172: aload_0
    //   173: getfield 299	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vtH	Lcom/tencent/mm/ui/chatting/gallery/c;
    //   176: invokevirtual 1095	com/tencent/mm/ui/chatting/gallery/c:cFV	()Lcom/tencent/mm/ui/chatting/gallery/k;
    //   179: getfield 1307	com/tencent/mm/ui/chatting/gallery/k:vxj	Lcom/tencent/mm/pluginsdk/ui/tools/f;
    //   182: ifnull +23 -> 205
    //   185: aload_0
    //   186: getfield 299	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vtH	Lcom/tencent/mm/ui/chatting/gallery/c;
    //   189: invokevirtual 1095	com/tencent/mm/ui/chatting/gallery/c:cFV	()Lcom/tencent/mm/ui/chatting/gallery/k;
    //   192: getfield 1307	com/tencent/mm/ui/chatting/gallery/k:vxj	Lcom/tencent/mm/pluginsdk/ui/tools/f;
    //   195: invokeinterface 1312 1 0
    //   200: sipush 1000
    //   203: idiv
    //   204: istore_3
    //   205: aload_0
    //   206: invokevirtual 1214	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:cGf	()Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryUI;
    //   209: getfield 1260	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vvV	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   212: iload_3
    //   213: invokevirtual 1315	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:seek	(I)V
    //   216: goto -104 -> 112
    //   219: astore_1
    //   220: aload_0
    //   221: monitorexit
    //   222: aload_1
    //   223: athrow
    //   224: astore_1
    //   225: ldc_w 276
    //   228: aload_1
    //   229: ldc_w 588
    //   232: iconst_0
    //   233: anewarray 478	java/lang/Object
    //   236: invokestatic 1319	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: iload 4
    //   241: istore_3
    //   242: goto -37 -> 205
    //   245: aload_0
    //   246: getfield 299	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vtH	Lcom/tencent/mm/ui/chatting/gallery/c;
    //   249: aload_1
    //   250: iconst_0
    //   251: invokevirtual 801	com/tencent/mm/ui/chatting/gallery/c:h	(Lcom/tencent/mm/storage/bi;Z)Lcom/tencent/mm/as/e;
    //   254: astore 10
    //   256: aload_0
    //   257: invokevirtual 1112	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:cGp	()V
    //   260: aload_0
    //   261: invokespecial 1087	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:cGj	()V
    //   264: aload 10
    //   266: ifnonnull +15 -> 281
    //   269: ldc_w 276
    //   272: ldc_w 1321
    //   275: invokestatic 304	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: goto -166 -> 112
    //   281: aload_0
    //   282: getfield 339	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:kJC	Lcom/tencent/mm/ui/base/MMViewPager;
    //   285: invokevirtual 344	com/tencent/mm/ui/base/MMViewPager:getCurrentItem	()I
    //   288: pop
    //   289: aload_1
    //   290: aload 10
    //   292: invokestatic 1323	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:f	(Lcom/tencent/mm/storage/bi;Lcom/tencent/mm/as/e;)Z
    //   295: ifeq +415 -> 710
    //   298: aload_1
    //   299: invokevirtual 1079	com/tencent/mm/storage/bi:cvx	()Z
    //   302: ifne +408 -> 710
    //   305: aload 10
    //   307: invokevirtual 1326	com/tencent/mm/as/e:Oq	()Z
    //   310: ifeq +400 -> 710
    //   313: aload_0
    //   314: invokevirtual 450	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:cGe	()Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryUI;
    //   317: getfield 1231	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vvR	Landroid/widget/Button;
    //   320: iconst_0
    //   321: invokevirtual 1234	android/widget/Button:setVisibility	(I)V
    //   324: aload_0
    //   325: invokevirtual 450	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:cGe	()Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryUI;
    //   328: getfield 1236	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vvS	Landroid/widget/Button;
    //   331: bipush 8
    //   333: invokevirtual 1234	android/widget/Button:setVisibility	(I)V
    //   336: aload_0
    //   337: invokevirtual 450	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:cGe	()Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryUI;
    //   340: getfield 453	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vvT	Landroid/view/View;
    //   343: bipush 8
    //   345: invokevirtual 463	android/view/View:setVisibility	(I)V
    //   348: aload_0
    //   349: getfield 220	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vwq	Ljava/util/HashMap;
    //   352: aload 10
    //   354: getfield 1329	com/tencent/mm/as/e:enp	J
    //   357: invokestatic 858	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   360: invokevirtual 1330	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   363: checkcast 780	java/lang/String
    //   366: astore 9
    //   368: aload 9
    //   370: astore 8
    //   372: aload 9
    //   374: ifnonnull +65 -> 439
    //   377: aload 10
    //   379: getfield 806	com/tencent/mm/as/e:enA	Ljava/lang/String;
    //   382: ldc_w 808
    //   385: invokestatic 814	com/tencent/mm/sdk/platformtools/bn:s	(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   388: astore 8
    //   390: aload 8
    //   392: ifnonnull +159 -> 551
    //   395: ldc_w 276
    //   398: ldc_w 1332
    //   401: iconst_1
    //   402: anewarray 478	java/lang/Object
    //   405: dup
    //   406: iconst_0
    //   407: aload 10
    //   409: getfield 806	com/tencent/mm/as/e:enA	Ljava/lang/String;
    //   412: aastore
    //   413: invokestatic 1334	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   416: iconst_m1
    //   417: istore_3
    //   418: goto +438 -> 856
    //   421: aload_0
    //   422: getfield 220	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vwq	Ljava/util/HashMap;
    //   425: aload 10
    //   427: getfield 1329	com/tencent/mm/as/e:enp	J
    //   430: invokestatic 858	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   433: aload 8
    //   435: invokevirtual 1338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   438: pop
    //   439: aload_0
    //   440: invokevirtual 450	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:cGe	()Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryUI;
    //   443: getfield 1231	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vvR	Landroid/widget/Button;
    //   446: aload_0
    //   447: getstatic 1343	com/tencent/mm/R$l:cropimage_view_hd_img_detail	I
    //   450: iconst_1
    //   451: anewarray 478	java/lang/Object
    //   454: dup
    //   455: iconst_0
    //   456: aload 8
    //   458: aastore
    //   459: invokevirtual 1347	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   462: invokevirtual 1252	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   465: aload_0
    //   466: getfield 456	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vvQ	Landroid/view/View;
    //   469: iconst_0
    //   470: invokestatic 939	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:W	(Landroid/view/View;I)V
    //   473: aload_0
    //   474: getfield 1349	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vwb	Z
    //   477: ifeq +245 -> 722
    //   480: aload 10
    //   482: invokevirtual 1326	com/tencent/mm/as/e:Oq	()Z
    //   485: ifeq +237 -> 722
    //   488: aload_0
    //   489: getfield 299	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vtH	Lcom/tencent/mm/ui/chatting/gallery/c;
    //   492: invokevirtual 328	com/tencent/mm/ui/chatting/gallery/c:cFU	()Lcom/tencent/mm/storage/bi;
    //   495: ifnull +227 -> 722
    //   498: aload_1
    //   499: getfield 629	com/tencent/mm/h/c/cs:field_msgId	J
    //   502: aload_0
    //   503: getfield 299	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vtH	Lcom/tencent/mm/ui/chatting/gallery/c;
    //   506: invokevirtual 328	com/tencent/mm/ui/chatting/gallery/c:cFU	()Lcom/tencent/mm/storage/bi;
    //   509: getfield 629	com/tencent/mm/h/c/cs:field_msgId	J
    //   512: lcmp
    //   513: ifne +209 -> 722
    //   516: ldc_w 276
    //   519: ldc_w 1351
    //   522: iconst_1
    //   523: anewarray 478	java/lang/Object
    //   526: dup
    //   527: iconst_0
    //   528: aload_1
    //   529: getfield 629	com/tencent/mm/h/c/cs:field_msgId	J
    //   532: invokestatic 858	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   535: aastore
    //   536: invokestatic 548	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   539: aload_0
    //   540: invokespecial 251	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:cGA	()V
    //   543: aload_0
    //   544: iconst_0
    //   545: putfield 1349	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vwb	Z
    //   548: goto -436 -> 112
    //   551: aload 8
    //   553: ldc_w 1353
    //   556: invokeinterface 821 2 0
    //   561: checkcast 780	java/lang/String
    //   564: iconst_0
    //   565: invokestatic 1357	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   568: istore 4
    //   570: iload 4
    //   572: istore_3
    //   573: iload 4
    //   575: ifne +281 -> 856
    //   578: aload 8
    //   580: ldc_w 1359
    //   583: invokeinterface 821 2 0
    //   588: checkcast 780	java/lang/String
    //   591: iconst_0
    //   592: invokestatic 1357	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   595: istore_3
    //   596: goto +260 -> 856
    //   599: new 1361	java/math/BigDecimal
    //   602: dup
    //   603: lload 6
    //   605: invokespecial 1363	java/math/BigDecimal:<init>	(J)V
    //   608: astore 8
    //   610: aload 8
    //   612: new 1361	java/math/BigDecimal
    //   615: dup
    //   616: ldc_w 1364
    //   619: invokespecial 1366	java/math/BigDecimal:<init>	(I)V
    //   622: iconst_2
    //   623: iconst_0
    //   624: invokevirtual 1370	java/math/BigDecimal:divide	(Ljava/math/BigDecimal;II)Ljava/math/BigDecimal;
    //   627: invokevirtual 1374	java/math/BigDecimal:floatValue	()F
    //   630: fstore_2
    //   631: fload_2
    //   632: fconst_1
    //   633: fcmpl
    //   634: ifle +29 -> 663
    //   637: new 278	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 1243	java/lang/StringBuilder:<init>	()V
    //   644: fload_2
    //   645: f2i
    //   646: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   649: ldc_w 1376
    //   652: invokevirtual 1248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   658: astore 8
    //   660: goto -239 -> 421
    //   663: aload 8
    //   665: new 1361	java/math/BigDecimal
    //   668: dup
    //   669: sipush 1024
    //   672: invokespecial 1366	java/math/BigDecimal:<init>	(I)V
    //   675: iconst_2
    //   676: iconst_0
    //   677: invokevirtual 1370	java/math/BigDecimal:divide	(Ljava/math/BigDecimal;II)Ljava/math/BigDecimal;
    //   680: invokevirtual 1374	java/math/BigDecimal:floatValue	()F
    //   683: fstore_2
    //   684: new 278	java/lang/StringBuilder
    //   687: dup
    //   688: invokespecial 1243	java/lang/StringBuilder:<init>	()V
    //   691: fload_2
    //   692: f2i
    //   693: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   696: ldc_w 1377
    //   699: invokevirtual 1248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: astore 8
    //   707: goto -286 -> 421
    //   710: aload_0
    //   711: getfield 456	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vvQ	Landroid/view/View;
    //   714: bipush 8
    //   716: invokestatic 939	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:W	(Landroid/view/View;I)V
    //   719: goto -246 -> 473
    //   722: aload_0
    //   723: getfield 299	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vtH	Lcom/tencent/mm/ui/chatting/gallery/c;
    //   726: invokevirtual 328	com/tencent/mm/ui/chatting/gallery/c:cFU	()Lcom/tencent/mm/storage/bi;
    //   729: astore 8
    //   731: aload_0
    //   732: getfield 1349	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vwb	Z
    //   735: istore 5
    //   737: aload_1
    //   738: getfield 629	com/tencent/mm/h/c/cs:field_msgId	J
    //   741: lstore 6
    //   743: aload 8
    //   745: ifnonnull +54 -> 799
    //   748: ldc_w 1379
    //   751: astore_1
    //   752: ldc_w 276
    //   755: ldc_w 1381
    //   758: iconst_4
    //   759: anewarray 478	java/lang/Object
    //   762: dup
    //   763: iconst_0
    //   764: iload 5
    //   766: invokestatic 484	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   769: aastore
    //   770: dup
    //   771: iconst_1
    //   772: lload 6
    //   774: invokestatic 858	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   777: aastore
    //   778: dup
    //   779: iconst_2
    //   780: aload_1
    //   781: aastore
    //   782: dup
    //   783: iconst_3
    //   784: aload 10
    //   786: invokevirtual 1326	com/tencent/mm/as/e:Oq	()Z
    //   789: invokestatic 484	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   792: aastore
    //   793: invokestatic 527	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   796: goto -684 -> 112
    //   799: aload 8
    //   801: getfield 629	com/tencent/mm/h/c/cs:field_msgId	J
    //   804: invokestatic 858	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   807: astore_1
    //   808: goto -56 -> 752
    //   811: aload_0
    //   812: invokevirtual 1112	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:cGp	()V
    //   815: aload_0
    //   816: invokespecial 1087	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:cGj	()V
    //   819: goto -707 -> 112
    //   822: aload_0
    //   823: invokevirtual 1112	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:cGp	()V
    //   826: aload_0
    //   827: invokespecial 1087	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:cGj	()V
    //   830: aload_0
    //   831: getfield 456	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vvQ	Landroid/view/View;
    //   834: bipush 8
    //   836: invokestatic 939	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:W	(Landroid/view/View;I)V
    //   839: aload_0
    //   840: getfield 299	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:vtH	Lcom/tencent/mm/ui/chatting/gallery/c;
    //   843: aload_0
    //   844: getfield 339	com/tencent/mm/ui/chatting/gallery/ImageGalleryUI:kJC	Lcom/tencent/mm/ui/base/MMViewPager;
    //   847: invokevirtual 344	com/tencent/mm/ui/base/MMViewPager:getCurrentItem	()I
    //   850: invokevirtual 1384	com/tencent/mm/ui/chatting/gallery/c:Hs	(I)V
    //   853: goto -741 -> 112
    //   856: iload_3
    //   857: i2l
    //   858: lstore 6
    //   860: lload 6
    //   862: lconst_0
    //   863: lcmp
    //   864: ifge -265 -> 599
    //   867: ldc_w 588
    //   870: astore 8
    //   872: goto -451 -> 421
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	875	0	this	ImageGalleryUI
    //   0	875	1	parambi	bi
    //   630	62	2	f	float
    //   80	777	3	i	int
    //   1	573	4	j	int
    //   735	30	5	bool	boolean
    //   603	1	6	localObject1	Object
    //   741	120	6	l	long
    //   370	501	8	localObject2	Object
    //   366	7	9	str	String
    //   254	531	10	locale	com.tencent.mm.as.e
    // Exception table:
    //   from	to	target	type
    //   5	69	219	finally
    //   69	81	219	finally
    //   115	138	219	finally
    //   142	156	219	finally
    //   159	169	219	finally
    //   172	205	219	finally
    //   205	216	219	finally
    //   225	239	219	finally
    //   245	264	219	finally
    //   269	278	219	finally
    //   281	368	219	finally
    //   377	390	219	finally
    //   395	416	219	finally
    //   421	439	219	finally
    //   439	473	219	finally
    //   473	548	219	finally
    //   551	570	219	finally
    //   578	596	219	finally
    //   599	631	219	finally
    //   637	660	219	finally
    //   663	707	219	finally
    //   710	719	219	finally
    //   722	743	219	finally
    //   752	796	219	finally
    //   799	808	219	finally
    //   811	819	219	finally
    //   822	853	219	finally
    //   159	169	224	java/lang/Exception
    //   172	205	224	java/lang/Exception
  }
  
  final ImageGalleryUI cGe()
  {
    if (this.vvQ == null)
    {
      this.vvQ = ((ViewStub)findViewById(R.h.image_footer_root)).inflate();
      this.vvR = ((Button)this.vvQ.findViewById(R.h.cropimage_function_btn));
      this.vvS = ((Button)this.vvQ.findViewById(R.h.cropimage_hd_loadding_btn));
      this.vvT = this.vvQ.findViewById(R.h.cropimage_hd_loadding_done_root);
    }
    return this;
  }
  
  protected final ImageGalleryUI cGf()
  {
    if (this.vvU == null)
    {
      this.vvU = ((ViewStub)findViewById(R.h.video_footer_root)).inflate();
      this.vvV = ((VideoPlayerSeekBar)findViewById(R.h.video_player_seek_bar));
      this.vvV.setPlayBtnOnClickListener(this);
    }
    return this;
  }
  
  protected final void cGn()
  {
    if (this.vwo) {
      this.vwp.S(4000L, 4000L);
    }
  }
  
  public final void cGo()
  {
    y.i("MicroMsg.ImageGalleryUI", "show video tool bar");
    gs(true);
    nr(true);
    W(this.vvQ, 8);
    W(cGf().vvU, 0);
    W(this.vvM, 0);
    cGg().vvN.clearAnimation();
    if (this.vvK) {
      cGl();
    }
    for (;;)
    {
      cGx();
      this.vwo = true;
      cGn();
      return;
      cGk();
    }
  }
  
  public final void cGp()
  {
    y.i("MicroMsg.ImageGalleryUI", "hide video tool bar");
    nr(false);
    W(cGf().vvU, 8);
    W(this.vvM, 8);
    if (cGm())
    {
      cGx();
      cGl();
    }
    this.vwo = false;
  }
  
  final void cGr()
  {
    if ((cGg().vvN == null) || (this.vwu)) {
      return;
    }
    if (this.vvN.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.ImageGalleryUI", "fadeOutEnterGirdBtn: %B", new Object[] { Boolean.valueOf(bool) });
      Animation localAnimation = HC(300);
      localAnimation.setFillAfter(false);
      localAnimation.setAnimationListener(new ImageGalleryUI.10(this));
      cGg().vvN.startAnimation(localAnimation);
      this.vwu = true;
      return;
    }
  }
  
  final void cGs()
  {
    if ((cGg().vvP == null) || (this.vwv)) {
      return;
    }
    cGg().vvP.startAnimation(HC(300));
    this.vwv = true;
  }
  
  protected final void cGw()
  {
    if ((dK(this.vvQ) == 0) && (dK(this.vvR) == 0)) {}
    for (int i = 1; (i != 0) || (this.vtH == null); i = 0) {
      return;
    }
    y.d("MicroMsg.ImageGalleryUI", "jacks start Hide Timer");
    this.vwt.S(4000L, 4000L);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
    {
      if (this.oOK != null)
      {
        this.oOK.bFp();
        this.oOK = null;
        return true;
      }
      nq(true);
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void finish()
  {
    this.vpy.clear();
    super.finish();
  }
  
  public final int getCurrentItem()
  {
    return this.kJC.getCurrentItem();
  }
  
  protected final int getForceOrientation()
  {
    return 2;
  }
  
  protected final int getLayoutId()
  {
    return R.i.image_gallery;
  }
  
  public final void gs(boolean paramBoolean)
  {
    int i = 8;
    if (((paramBoolean) && (this.vvI.getVisibility() == 0)) || ((!paramBoolean) && (this.vvI.getVisibility() == 8))) {
      return;
    }
    Object localObject = this.vvI;
    if (paramBoolean) {
      i = 0;
    }
    ((RelativeLayout)localObject).setVisibility(i);
    localObject = this.mController.uMN;
    if (paramBoolean) {}
    for (i = R.a.alpha_in;; i = R.a.alpha_out)
    {
      localObject = AnimationUtils.loadAnimation((Context)localObject, i);
      this.vvI.startAnimation((Animation)localObject);
      return;
    }
  }
  
  public final int ia(long paramLong)
  {
    if (bk.bl(this.vwg)) {
      return 0;
    }
    try
    {
      int j = u.h(paramLong, this.vwg);
      int i = j;
      if (j == -1)
      {
        this.vwg = null;
        i = 0;
      }
      y.d("MicroMsg.ImageGalleryUI", "get enter video op code %d %s", new Object[] { Integer.valueOf(i), this.vwg });
      return i;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ImageGalleryUI", "get enter video op code error : " + localException.toString());
    }
    return 0;
  }
  
  public final void ib(long paramLong)
  {
    if ((bk.bl(this.vwg)) || (paramLong == 0L)) {}
    while (u.h(paramLong, this.vwg) != -1) {
      return;
    }
    this.vwg = null;
    y.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[] { this.vwg });
  }
  
  protected final void initView()
  {
    this.itA = new com.tencent.mm.ui.tools.e(this.mController.uMN);
    this.vwt = new am(this, false);
    this.itz = false;
    this.talker = getIntent().getStringExtra("img_gallery_talker");
    this.vwd = getIntent().getBooleanExtra("img_gallery_enter_from_grid", false);
    this.vrQ = getIntent().getBooleanExtra("img_gallery_enter_from_chatting_ui", false);
    this.vwf = getIntent().getBooleanExtra("img_gallery_enter_from_appbrand_service_chatting_ui", false);
    this.vrP = getIntent().getBooleanExtra("show_search_chat_content_result", false);
    this.kax = getIntent().getBooleanExtra("key_is_biz_chat", false);
    this.idK = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.vvK = getIntent().getBooleanExtra("img_preview_only", false);
    if (!this.vvK)
    {
      localObject1 = "MicroMsg.ImageGalleryUI initView, talker is null, stack = " + bk.csb();
      if (this.talker == null) {
        break label368;
      }
    }
    long l;
    label368:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue((String)localObject1, bool);
      this.chatroomName = getIntent().getStringExtra("img_gallery_chatroom_name");
      this.vwe = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
      this.vwg = getIntent().getStringExtra("img_gallery_enter_video_opcode");
      bool = getIntent().getBooleanExtra("img_gallery_is_restransmit_after_download", false);
      localObject2 = getIntent().getStringExtra("img_gallery_directly_send_name");
      this.bIt = getIntent().getLongExtra("img_gallery_msg_id", 0L);
      l = getIntent().getLongExtra("img_gallery_msg_svr_id", 0L);
      if ((this.bIt > 0L) || (l != 0L)) {
        break;
      }
      y.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.bIt + ", msgSvrId = " + l + ", stack = " + bk.csb());
      finish();
      return;
    }
    if (this.bIt == 0L)
    {
      au.Hx();
      this.bIt = com.tencent.mm.model.c.Fy().O(cGi(), l).field_msgId;
    }
    au.Hx();
    Object localObject1 = com.tencent.mm.model.c.Fy().fd(this.bIt);
    if (((cs)localObject1).field_msgId <= 0L)
    {
      y.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.bIt + ", msgSvrId = " + l + ", stack = " + bk.csb());
      finish();
      return;
    }
    this.vtH = new c(this, this.bIt, cGi(), this.kax, this.idK, bool, (String)localObject2, Boolean.valueOf(this.vwe));
    this.vtH.vtS = false;
    this.vtH.vtM = getIntent().getBooleanExtra("start_chatting_ui", true);
    this.vtH.vtR = new ImageGalleryUI.14(this);
    this.vvI = ((RelativeLayout)findViewById(R.h.cropimage_function_bar));
    this.vvJ = ((RelativeLayout)findViewById(R.h.cropimage_fuction_top_bar));
    int j = this.vvJ.getPaddingTop();
    int i = j;
    if (ak.gC(this.mController.uMN)) {
      i = j + ak.gB(this.mController.uMN);
    }
    this.vvJ.setPadding(0, i, 0, 0);
    this.vvM = ((ImageView)findViewById(R.h.video_close_btn));
    this.vvM.setOnClickListener(this);
    Object localObject2 = getWindowManager().getDefaultDisplay();
    j = ((Display)localObject2).getWidth();
    int k = ((Display)localObject2).getHeight();
    if (j < k)
    {
      i = 1;
      y.d("MicroMsg.ImageGalleryUI", "%d is vertical screen orient %d [%d, %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (i != 0) {
        break label1088;
      }
      i = 0;
      label747:
      if (i == 0) {
        break label1093;
      }
      cGy();
      label755:
      this.kgw = ((ImageView)findViewById(R.h.gallery_bg));
      this.kgw.setLayerType(2, null);
      this.kJC = ((MMViewPager)findViewById(R.h.gallery));
      this.kJC.setLayerType(2, null);
      this.kJC.setVerticalFadingEdgeEnabled(false);
      this.kJC.setHorizontalFadingEdgeEnabled(false);
      this.kJC.setSingleClickOverListener(new ImageGalleryUI.15(this));
      if (!this.vvK)
      {
        this.kJC.setOnPageChangeListener(this.vwn);
        this.kJC.setLongClickOverListener(new ImageGalleryUI.16(this));
      }
      this.kJC.setOffscreenPageLimit(1);
      this.kJC.setAdapter(this.vtH);
      Hz(100000);
      this.kJC.setCurrentItem(100000);
      this.kJC.postDelayed(new ImageGalleryUI.17(this), 0L);
      if (h.a.cGc().khC)
      {
        this.vwi = ((ViewStub)findViewById(R.h.selected_title_bar)).inflate();
        this.vwi.setVisibility(0);
        this.vwj = ((CheckBox)this.vwi.findViewById(R.h.media_cbx));
        this.vwk = this.vwi.findViewById(R.h.media_cbx_clickarea);
      }
      this.vwb = getIntent().getBooleanExtra("img_gallery_enter_PhotoEditUI", false);
      localObject1 = this.vtH.h((bi)localObject1, true);
      if (localObject1 == null) {
        y.e("MicroMsg.ImageGalleryUI", "[initView] imgInfo is null!!! isSoonEnterPhotoEdit:%s", new Object[] { Boolean.valueOf(this.vwb) });
      }
      if ((!this.vwb) || (localObject1 == null) || (!((com.tencent.mm.as.e)localObject1).Oq())) {
        break label1100;
      }
      cGA();
      this.vwb = false;
    }
    for (;;)
    {
      this.kJC.setOnTouchListener(new ImageGalleryUI.18(this));
      return;
      i = 0;
      break;
      label1088:
      i = 1;
      break label747;
      label1093:
      cGz();
      break label755;
      label1100:
      if (this.vwb) {
        y.w("MicroMsg.ImageGalleryUI", "img not GetCompleted!");
      }
    }
  }
  
  public final boolean noActionBar()
  {
    return true;
  }
  
  protected final void nq(boolean paramBoolean)
  {
    if (this.vtH == null) {
      break label7;
    }
    label7:
    label421:
    label831:
    label854:
    label861:
    for (;;)
    {
      return;
      if (this.vwm >= 0)
      {
        Object localObject2 = this.vtH.GW(this.vwm);
        int i = this.vtH.vtO.bs((bi)localObject2);
        if ((i == 5) || (i == 6))
        {
          y.w("MicroMsg.ImageGalleryUI", "jacks fail downloaded img, return");
          return;
        }
        if (this.vtH.bj((bi)localObject2))
        {
          y.w("MicroMsg.ImageGalleryUI", "jacks downloading, return");
          return;
        }
        if ((c.bf((bi)localObject2)) && (j.bz((bi)localObject2) == null))
        {
          y.w("MicroMsg.ImageGalleryUI", "video info is null, return now.");
          return;
        }
        Object localObject1 = new ArrayList();
        Object localObject3 = new ArrayList();
        ((List)localObject1).add(Integer.valueOf(0));
        ((List)localObject3).add(getString(R.l.retransmits));
        if (com.tencent.mm.br.d.SP("favorite"))
        {
          ((List)localObject1).add(Integer.valueOf(2));
          ((List)localObject3).add(getString(R.l.plugin_favorite_opt));
        }
        if ((c.be((bi)localObject2)) || (c.bi((bi)localObject2)))
        {
          ((List)localObject1).add(Integer.valueOf(1));
          ((List)localObject3).add(getString(R.l.save_img_to_local));
          if ((c.be((bi)localObject2)) || (c.bg((bi)localObject2)))
          {
            do localdo = new do();
            localdo.bJZ.bIt = ((cs)localObject2).field_msgId;
            com.tencent.mm.sdk.b.a.udP.m(localdo);
            if ((localdo.bKa.bJy) || (com.tencent.mm.pluginsdk.model.app.g.S(this.mController.uMN, ((bi)localObject2).getType())))
            {
              ((List)localObject1).add(Integer.valueOf(4));
              ((List)localObject3).add(getString(R.l.chatting_long_click_menu_open));
            }
          }
          if (c.be((bi)localObject2))
          {
            ((List)localObject1).add(Integer.valueOf(6));
            ((List)localObject3).add(getString(R.l.chatting_image_long_click_photo_edit));
          }
          if ((this.oOO != null) && (adE(this.oOO)))
          {
            ((List)localObject1).add(Integer.valueOf(3));
            if (!com.tencent.mm.plugin.scanner.a.wM(this.gGr)) {
              break label753;
            }
            ((List)localObject3).add(getString(R.l.recog_qbar_of_image_file));
          }
          if (bf.k((bi)localObject2))
          {
            ((List)localObject1).clear();
            ((List)localObject3).clear();
          }
          if ((!this.vrP) && (!this.kax) && (!h.a.cGc().khC) && (!this.vwf))
          {
            ((List)localObject1).add(Integer.valueOf(5));
            ((List)localObject3).add(getString(R.l.chatting_image_long_click_goto_chat));
          }
          if ((this.oOK == null) || (!this.oOP)) {
            break label831;
          }
          this.oOP = false;
          this.oOK.phH = new ImageGalleryUI.3(this, (List)localObject1, (List)localObject3);
          if (((List)localObject1).size() == 0) {
            break;
          }
          this.oOK.phI = this.jfN;
          this.oOK.wmU = new ImageGalleryUI.4(this);
          this.oOK.cfU();
          if (((!c.be((bi)localObject2)) && (!c.bi((bi)localObject2))) || (true != paramBoolean) || (au.Dk().KG() == 0)) {
            break;
          }
          localObject1 = null;
          if (!c.be((bi)localObject2)) {
            break label854;
          }
          localObject3 = this.vtH.h((bi)localObject2, true);
          if (localObject3 == null) {}
        }
        for (localObject1 = e.d((bi)localObject2, (com.tencent.mm.as.e)localObject3);; localObject1 = c.bo((bi)localObject2))
        {
          if (localObject1 == null) {
            break label861;
          }
          localObject2 = new mz();
          ((mz)localObject2).bWF.filePath = ((String)localObject1);
          this.oOL = ((String)localObject1);
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
          return;
          if ((c.bf((bi)localObject2)) || (c.bg((bi)localObject2)))
          {
            ((List)localObject1).add(Integer.valueOf(1));
            ((List)localObject3).add(getString(R.l.save_video_to_local));
            break;
          }
          ((List)localObject1).add(Integer.valueOf(1));
          ((List)localObject3).add(getString(R.l.save_to_local));
          break;
          label753:
          if (com.tencent.mm.plugin.scanner.a.aD(this.gGr, this.oOO))
          {
            ((List)localObject3).add(getString(R.l.recog_wxcode_of_image_file));
            break label421;
          }
          if (com.tencent.mm.plugin.scanner.a.wL(this.gGr))
          {
            ((List)localObject3).add(getString(R.l.recog_barcode_of_image_file));
            break label421;
          }
          ((List)localObject3).add(getString(R.l.recog_qbar_of_image_file));
          break label421;
          this.oOK = new com.tencent.mm.ui.widget.a.d(this.mController.uMN, 1, false);
          break label517;
        }
      }
    }
  }
  
  public final void ns(boolean paramBoolean)
  {
    try
    {
      VideoPlayerSeekBar localVideoPlayerSeekBar = cGf().vvV;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localVideoPlayerSeekBar.setIsPlay(paramBoolean);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ImageGalleryUI", "set video state iv error : " + localException.toString());
    }
  }
  
  public void onBackPressed()
  {
    y.i("MicroMsg.ImageGalleryUI", "onBackPressed");
    if (this.vwd)
    {
      HA(1);
      return;
    }
    try
    {
      h.a.cGc().detach();
      aBR();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ImageGalleryUI", localException.getMessage());
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = true;
    if (this.vtH == null) {}
    do
    {
      return;
      if (paramView.getId() == R.h.goto_grid_gallery_ll)
      {
        HA(0);
        return;
      }
      if (paramView.getId() == R.h.download_and_save_icon)
      {
        y.i("MicroMsg.ImageGalleryUI", "[oreh download_and_save] hdImg suc, curPos:%d", new Object[] { Integer.valueOf(this.kJC.getCurrentItem()) });
        W(cGh().vvO, 8);
        paramView = this.vtH.GW(this.kJC.getCurrentItem());
        com.tencent.mm.as.e locale = this.vtH.h(paramView, false);
        this.kJC.getCurrentItem();
        if ((f(paramView, locale)) && (!paramView.cvx()) && (locale.Oq()))
        {
          this.vtH.as(this.kJC.getCurrentItem(), true);
          return;
        }
        c.b(this.mController.uMN, this.vtH.cFU(), true);
        return;
      }
      if (paramView.getId() == R.h.cropimage_function_btn)
      {
        this.vtH.as(this.kJC.getCurrentItem(), false);
        return;
      }
      if (paramView.getId() == R.h.cropimage_hd_loadding_btn)
      {
        this.vtH.Hr(this.kJC.getCurrentItem());
        Hz(this.kJC.getCurrentItem());
        cGt();
        cGu();
        cGw();
        return;
      }
      if (paramView.getId() == R.h.actionbar_up_indicator)
      {
        onBackPressed();
        return;
      }
      if (paramView.getId() == R.h.video_close_btn)
      {
        onBackPressed();
        return;
      }
      if (paramView.getId() == R.h.media_cbx_clickarea)
      {
        boolean bool2 = this.vwj.isChecked();
        if ((!bool2) && (h.a.cGc().khB.size() >= 9))
        {
          Toast.makeText(this, getResources().getString(R.l.gallery_select_limit, new Object[] { Integer.valueOf(9) }), 1).show();
          return;
        }
        paramView = this.vwj;
        if (!bool2) {}
        for (;;)
        {
          paramView.setChecked(bool1);
          if (!this.vwj.isChecked()) {
            break;
          }
          h.a.cGc().bv(this.vtH.cFU());
          return;
          bool1 = false;
        }
        h.a.cGc().bw(this.vtH.cFU());
        return;
      }
    } while (paramView.getId() != R.h.play_btn);
    this.vtH.Ho(this.kJC.getCurrentItem());
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      y.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is vertical screen", new Object[] { Integer.valueOf(hashCode()) });
      cGy();
    }
    while (paramConfiguration.orientation != 2) {
      return;
    }
    y.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is horizontal screen", new Object[] { Integer.valueOf(hashCode()) });
    cGz();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    long l = System.currentTimeMillis();
    this.vwl = true;
    super.onCreate(paramBundle);
    if (com.tencent.mm.compatible.util.d.gF(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (this.mfb = true;; this.mfb = false)
    {
      initView();
      this.ity = paramBundle;
      com.tencent.mm.sdk.b.a.udP.c(this.kbV);
      com.tencent.mm.sdk.b.a.udP.c(this.oOV);
      this.vvL = false;
      y.d("MicroMsg.ImageGalleryUI", "ImageGallery onCreate spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
      getWindow().setFlags(1024, 1024);
    }
  }
  
  protected final void onCreateBeforeSetContentView()
  {
    super.onCreateBeforeSetContentView();
  }
  
  protected void onDestroy()
  {
    y.i("MicroMsg.ImageGalleryUI", "%d image gallery ui on destroy", new Object[] { Integer.valueOf(hashCode()) });
    if (this.vtH != null)
    {
      this.vtH.detach();
      this.vtH = null;
    }
    cGx();
    this.vwp.stopTimer();
    com.tencent.mm.sdk.b.a.udP.d(this.kbV);
    com.tencent.mm.sdk.b.a.udP.d(this.oOV);
    if (this.vvV != null) {
      this.vvV.setPlayBtnOnClickListener(null);
    }
    this.vvV = null;
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 82) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    y.i("MicroMsg.ImageGalleryUI", "on pause");
    super.onPause();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(2048, 2048);
    }
    Object localObject;
    if ((!isFinishing()) && (this.vtH != null))
    {
      localObject = this.vtH;
      ((c)localObject).vtP.vwM.sendEmptyMessageDelayed(1, 200L);
      ((c)localObject).vtQ.cGd();
    }
    if (this.oOO != null)
    {
      localObject = new al();
      ((al)localObject).bGD.activity = this;
      ((al)localObject).bGD.bGE = this.oOO;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      this.oOO = null;
      this.gGs = 0;
      this.gGr = 0;
    }
    com.tencent.mm.graphics.b.d.dDu.BM();
    o.Dh(2);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().clearFlags(2048);
    }
    if ((!this.vwl) && (this.vtH != null)) {
      Hz(this.kJC.getCurrentItem());
    }
    this.vwl = false;
    if (this.vtH != null) {
      this.vtH.cFW();
    }
    o.Dh(1);
  }
  
  public void onStart()
  {
    this.vwe = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
    if (!this.vvK)
    {
      Bundle localBundle = this.ity;
      if (!this.itz)
      {
        this.itz = true;
        if (Build.VERSION.SDK_INT >= 12)
        {
          this.itB = getIntent().getIntExtra("img_gallery_top", 0);
          this.itC = getIntent().getIntExtra("img_gallery_left", 0);
          this.itD = getIntent().getIntExtra("img_gallery_width", 0);
          this.itE = getIntent().getIntExtra("img_gallery_height", 0);
          if ((this.itB == 0) && (this.itC == 0) && (this.itD == 0) && (this.itE == 0))
          {
            bi localbi = this.vtH.GW(this.kJC.getCurrentItem());
            if (localbi != null)
            {
              as localas = new as();
              localas.bGS.bFH = localbi;
              com.tencent.mm.sdk.b.a.udP.m(localas);
              this.itD = localas.bGT.bGW;
              this.itE = localas.bGT.bGX;
              this.itC = localas.bGT.bGU;
              this.itB = localas.bGT.bGV;
            }
          }
          this.itA.E(this.itC, this.itB, this.itD, this.itE);
          if (localBundle == null) {
            this.kJC.getViewTreeObserver().addOnPreDrawListener(new ImageGalleryUI.19(this));
          }
        }
      }
    }
    super.onStart();
  }
  
  public final boolean tC()
  {
    cGr();
    cGs();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI
 * JD-Core Version:    0.7.0.1
 */