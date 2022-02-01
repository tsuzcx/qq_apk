package com.tencent.mm.plugin.subapp.ui.gallery;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.PointF;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import com.b.a.f.a;
import com.b.a.l;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecodeResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.c;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.be;
import com.tencent.mm.autogen.a.cs;
import com.tencent.mm.autogen.a.pv;
import com.tencent.mm.autogen.a.tm;
import com.tencent.mm.autogen.a.to;
import com.tencent.mm.autogen.a.tz;
import com.tencent.mm.autogen.a.wg;
import com.tencent.mm.autogen.a.wg.a;
import com.tencent.mm.autogen.b.gy;
import com.tencent.mm.autogen.mmdata.rpt.ap;
import com.tencent.mm.autogen.mmdata.rpt.hj;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.media.model.AppBrandMediaSource;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ag.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView.b;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.plugin.scanner.n;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.tools.PressAlphaImageView;
import com.tencent.mm.ui.tools.f.c;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class GestureGalleryUI
  extends MMActivity
  implements ag.b, com.tencent.mm.plugin.scanner.word.a.a<String, com.tencent.mm.plugin.scanner.word.b>, a.a, a.b
{
  private static boolean SHj = true;
  private boolean Ahm;
  private IListener Ahp;
  private int Fdo;
  private String GYf;
  private com.tencent.mm.plugin.webview.k.q GYg;
  public Long GYk;
  public Long GYl;
  private Long GYm;
  private volatile String Rdf;
  private IListener Rdt;
  private MultiCodeMaskView RnL;
  private com.tencent.mm.plugin.scanner.api.a.b RnR;
  private float Roh;
  private int Roi;
  private int Roj;
  private boolean SGA;
  private JSONArray SGB;
  private long SGC;
  private com.tencent.mm.ui.widget.a.f SGD;
  private volatile boolean SGE;
  private ArrayList<ImageQBarDataBean> SGF;
  private ImageQBarDataBean SGG;
  private int SGH;
  private final Set<Integer> SGI;
  private final Set<Integer> SGJ;
  private final ConcurrentHashMap<String, Boolean> SGK;
  private final ConcurrentHashMap<String, Boolean> SGL;
  private final Set<String> SGM;
  private boolean SGN;
  private View SGO;
  private TextView SGP;
  private a SGQ;
  GestureGalleryUI.a.a SGR;
  private boolean SGS;
  private RelativeLayout SGT;
  private RelativeLayout SGU;
  private PressAlphaImageView SGV;
  RedesignVideoPlayerSeekBar SGW;
  private long SGX;
  private c SGY;
  boolean SGZ;
  private a SGp;
  private MMGestureGallery SGq;
  private int SGr;
  String SGs;
  private ag SGt;
  private boolean SGu;
  private boolean SGv;
  private boolean SGw;
  private boolean SGx;
  private boolean SGy;
  private boolean SGz;
  private boolean SHa;
  private boolean SHb;
  private IListener<cs> SHc;
  private List<String> SHd;
  private List<AppBrandMediaSource> SHe;
  private int SHf;
  private String SHg;
  private boolean SHh;
  private AdapterView.OnItemSelectedListener SHi;
  private View SHk;
  private b SHl;
  GestureDetector detector;
  private boolean isAnimated;
  private MMHandler mHandler;
  private int mScene;
  private boolean nVt;
  private String okK;
  private String okz;
  private ScanCodeSheetItemLogic rAP;
  private String svg;
  private int type;
  private long vYw;
  private ImageView wAT;
  private Bundle wAX;
  private com.tencent.mm.ui.tools.f wAY;
  private int wAZ;
  private int wBa;
  private int wBb;
  private int wBc;
  
  public GestureGalleryUI()
  {
    AppMethodBeat.i(29091);
    this.SGu = false;
    this.SGv = false;
    this.okz = "";
    this.okK = null;
    this.SGw = false;
    this.SGx = false;
    this.SGy = true;
    this.SGz = false;
    this.SGA = false;
    this.SGB = null;
    this.SGF = new ArrayList();
    this.SGG = null;
    this.SGI = new HashSet();
    this.SGJ = new HashSet();
    this.SGK = new ConcurrentHashMap();
    this.SGL = new ConcurrentHashMap();
    this.SGM = new HashSet();
    this.SGN = false;
    this.isAnimated = false;
    this.wAZ = 0;
    this.wBa = 0;
    this.wBb = 0;
    this.wBc = 0;
    this.mHandler = new MMHandler();
    this.Ahm = n.gPv();
    this.GYf = "";
    this.nVt = false;
    this.SGS = false;
    this.vYw = 0L;
    this.SGX = 0L;
    this.SGY = c.SHB;
    this.SGZ = false;
    this.SHa = false;
    this.SHb = false;
    this.GYk = Long.valueOf(0L);
    this.GYl = Long.valueOf(0L);
    this.GYm = Long.valueOf(0L);
    this.SHc = new GestureGalleryUI.3(this, com.tencent.mm.app.f.hfK);
    this.SHd = new ArrayList();
    this.SHe = new ArrayList();
    this.type = 0;
    this.Fdo = -1;
    this.SHf = -1;
    this.svg = null;
    this.SHg = null;
    this.Roh = 1.0F;
    this.Roi = 0;
    this.Roj = 0;
    this.SHh = false;
    this.SHi = new AdapterView.OnItemSelectedListener()
    {
      VideoView SHs;
      
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(292154);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$19", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        Log.i("MicroMsg.GestureGalleryUI", "onItemSelected  pos:".concat(String.valueOf(paramAnonymousInt)));
        GestureGalleryUI.i(GestureGalleryUI.this, paramAnonymousInt);
        GestureGalleryUI.D(GestureGalleryUI.this).setText(GestureGalleryUI.e(GestureGalleryUI.this) + 1 + "/" + GestureGalleryUI.k(GestureGalleryUI.this).getCount());
        GestureGalleryUI.this.setMMTitle(GestureGalleryUI.e(GestureGalleryUI.this) + 1 + " / " + GestureGalleryUI.E(GestureGalleryUI.this).size());
        Log.d("MicroMsg.GestureGalleryUI", "pos:".concat(String.valueOf(paramAnonymousInt)));
        GestureGalleryUI.b(GestureGalleryUI.this, (String)GestureGalleryUI.E(GestureGalleryUI.this).get(paramAnonymousInt));
        GestureGalleryUI.c(GestureGalleryUI.this, "");
        GestureGalleryUI.b(GestureGalleryUI.this, false);
        if (this.SHs != null)
        {
          this.SHs.stopPlayback();
          this.SHs = null;
        }
        GestureGalleryUI.F(GestureGalleryUI.this).setIsPlay(false);
        GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.c.SHB);
        if ((paramAnonymousView != null) && (paramAnonymousView.getTag() != null))
        {
          paramAnonymousAdapterView = (GestureGalleryUI.a.a)paramAnonymousView.getTag();
          if ((paramAnonymousAdapterView != null) && (GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousInt)))
          {
            this.SHs = paramAnonymousAdapterView.SHy;
            GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousAdapterView);
            paramAnonymousAdapterView.HEl.setVisibility(0);
            paramAnonymousAdapterView.RfJ.setVisibility(0);
            paramAnonymousAdapterView.SHw.setVisibility(8);
            paramAnonymousAdapterView.SHz.setVisibility(8);
          }
        }
        else
        {
          if (!GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousInt)) {
            break label480;
          }
          GestureGalleryUI.c(GestureGalleryUI.this, GestureGalleryUI.B(GestureGalleryUI.this));
          GestureGalleryUI.j(GestureGalleryUI.this, paramAnonymousInt);
        }
        for (;;)
        {
          Log.i("MicroMsg.GestureGalleryUI", "curFilename:%s", new Object[] { GestureGalleryUI.d(GestureGalleryUI.this) });
          GestureGalleryUI.j(GestureGalleryUI.this);
          GestureGalleryUI.a(GestureGalleryUI.this, false);
          GestureGalleryUI.M(GestureGalleryUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$19", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(292154);
          return;
          if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.HEl == null)) {
            break;
          }
          paramAnonymousAdapterView.HEl.setVisibility(8);
          break;
          label480:
          GestureGalleryUI.c(GestureGalleryUI.this, GestureGalleryUI.I(GestureGalleryUI.this).c((String)GestureGalleryUI.E(GestureGalleryUI.this).get(paramAnonymousInt), GestureGalleryUI.G(GestureGalleryUI.this), paramAnonymousInt, GestureGalleryUI.H(GestureGalleryUI.this)));
          if (Util.isNullOrNil(GestureGalleryUI.d(GestureGalleryUI.this))) {
            GestureGalleryUI.c(GestureGalleryUI.this, (String)GestureGalleryUI.E(GestureGalleryUI.this).get(paramAnonymousInt));
          }
          GestureGalleryUI.j(GestureGalleryUI.this, paramAnonymousInt);
          if ((GestureGalleryUI.J(GestureGalleryUI.this) != null) && (GestureGalleryUI.K(GestureGalleryUI.this) != null) && (GestureGalleryUI.K(GestureGalleryUI.this).length() > GestureGalleryUI.L(GestureGalleryUI.this))) {
            if (GestureGalleryUI.K(GestureGalleryUI.this).optJSONObject(GestureGalleryUI.L(GestureGalleryUI.this)).has("jumpType")) {
              GestureGalleryUI.J(GestureGalleryUI.this).setVisibility(0);
            } else {
              GestureGalleryUI.J(GestureGalleryUI.this).setVisibility(8);
            }
          }
        }
      }
      
      public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    };
    this.Ahp = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Rdt = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(29091);
  }
  
  private void a(int paramInt, ImageQBarDataBean paramImageQBarDataBean)
  {
    AppMethodBeat.i(292164);
    if ((this.GYg == null) || (Util.isNullOrNil(this.SHg)))
    {
      AppMethodBeat.o(292164);
      return;
    }
    this.GYg.url = this.SHg;
    this.GYg.iiA = this.SGH;
    if (paramImageQBarDataBean != null)
    {
      this.GYg.Xtt = true;
      this.GYg.avd(paramImageQBarDataBean.hDb);
      this.GYg.scanResult = paramImageQBarDataBean.OGQ;
    }
    paramImageQBarDataBean = aa.aUC(this.GYf);
    this.GYg.KEa = paramImageQBarDataBean;
    this.GYg.rG(paramInt);
    AppMethodBeat.o(292164);
  }
  
  private void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2, Bundle paramBundle)
  {
    AppMethodBeat.i(292173);
    if ((!this.SGw) && (!this.SHa))
    {
      AppMethodBeat.o(292173);
      return;
    }
    String str3 = getIntent().getStringExtra("wxaSessionId");
    int i = getIntent().getIntExtra("wxaScene", 0);
    String str2 = "";
    String str1 = "";
    if (paramBundle != null)
    {
      str2 = paramBundle.getString("wxappPathWithQuery");
      str1 = paramBundle.getString("stat_app_id");
    }
    paramBundle = com.tencent.mm.plugin.scanner.a.OGI;
    com.tencent.mm.plugin.scanner.a.a(str3, i, str1, this.SHa, str2, paramInt, paramString, paramBoolean1, paramBoolean2, this.SHg);
    AppMethodBeat.o(292173);
  }
  
  private void anH(int paramInt)
  {
    AppMethodBeat.i(292144);
    ap localap1 = new ap();
    ap localap2 = localap1.kC(com.tencent.mm.plugin.fts.a.e.rr(this.SGC)).kD("");
    localap2.ioZ = paramInt;
    localap2.ilm = 1;
    localap1.kE("");
    localap1.kF("");
    if (this.mScene != 0) {}
    for (paramInt = this.mScene;; paramInt = 83)
    {
      localap1.imW = paramInt;
      localap1.imM = 0;
      localap1.kG(com.tencent.mm.b.g.getMD5(this.SGs));
      localap1.ipe = System.currentTimeMillis();
      localap1.bMH();
      as.a(localap1);
      AppMethodBeat.o(292144);
      return;
    }
  }
  
  private boolean anI(int paramInt)
  {
    AppMethodBeat.i(292185);
    if ((this.SHe != null) && (this.SHe.size() > paramInt) && (this.SHe.get(paramInt) != null) && ("video".endsWith(((AppBrandMediaSource)this.SHe.get(paramInt)).nBd)))
    {
      AppMethodBeat.o(292185);
      return true;
    }
    AppMethodBeat.o(292185);
    return false;
  }
  
  private void dSW()
  {
    AppMethodBeat.i(179724);
    Log.i("MicroMsg.GestureGalleryUI", "pauseVideo");
    if (this.SGR != null)
    {
      this.SGX = (this.SGW.getmPosition() * 1000);
      Log.i("MicroMsg.GestureGalleryUI", "pauseVideo currentVideoPos：%d", new Object[] { Long.valueOf(this.SGX) });
      this.SGR.SHy.pause();
      this.SGR.RfJ.setVisibility(0);
      if ((this.SGY != c.SHD) && (this.SGY != c.SHE)) {
        break label133;
      }
      this.SGY = c.SHF;
      this.SGZ = true;
    }
    for (;;)
    {
      this.SGW.setIsPlay(false);
      hBq();
      AppMethodBeat.o(179724);
      return;
      label133:
      c localc = c.SHF;
    }
  }
  
  private void dcM()
  {
    AppMethodBeat.i(292157);
    if (this.SGD == null) {
      this.SGD = new com.tencent.mm.ui.widget.a.f(getContext(), 1, false);
    }
    this.SGD.Vtg = new u.g()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
      {
        AppMethodBeat.i(292145);
        GestureGalleryUI.b(GestureGalleryUI.this).setFooterView(null);
        paramAnonymouss.clear();
        Object localObject;
        hj localhj;
        if (!GestureGalleryUI.n(GestureGalleryUI.this))
        {
          paramAnonymouss.oh(1, R.l.readerapp_alert_retransmit);
          if (GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.e(GestureGalleryUI.this)))
          {
            paramAnonymouss.oh(2, R.l.save_video_to_local);
            paramAnonymouss.oh(3, R.l.plugin_favorite_opt);
          }
        }
        else if (((GestureGalleryUI.o(GestureGalleryUI.this)) || (GestureGalleryUI.p(GestureGalleryUI.this))) && (!Util.isNullOrNil(GestureGalleryUI.d(GestureGalleryUI.this))))
        {
          paramAnonymouss.oh(4, R.l.chatting_image_long_click_photo_trans);
          localObject = GestureGalleryUI.g(GestureGalleryUI.this);
          localhj = new hj();
          if (((a)localObject).AjA != 2) {
            break label347;
          }
          l = 1L;
          label145:
          localhj.iqr = l;
          localhj.ikE = 2L;
          if (!((a)localObject).SGl) {
            break label352;
          }
        }
        label347:
        label352:
        for (long l = 6L;; l = 5L)
        {
          localhj.iOd = l;
          localhj.bMH();
          if (GestureGalleryUI.q(GestureGalleryUI.this))
          {
            paramAnonymouss.a(12, GestureGalleryUI.this.getString(R.l.chatting_image_long_click_image_ocr), R.k.icons_outlined_ocr);
            GestureGalleryUI.e(GestureGalleryUI.this, 2);
          }
          if ((!GestureGalleryUI.r(GestureGalleryUI.this)) && (!((com.tencent.mm.api.r)com.tencent.mm.kernel.h.ax(com.tencent.mm.api.r.class)).aBu()))
          {
            paramAnonymouss.add(0, 6, 0, GestureGalleryUI.this.getString(b.j.find_friends_search));
            GestureGalleryUI.s(GestureGalleryUI.this);
          }
          if (!GestureGalleryUI.t(GestureGalleryUI.this)) {
            break label369;
          }
          localObject = GestureGalleryUI.u(GestureGalleryUI.this);
          GestureGalleryUI.b(GestureGalleryUI.this).setFooterView((View)localObject);
          if (!(localObject instanceof ViewTitleWithAnimation)) {
            break label369;
          }
          if (paramAnonymouss.size() <= 1) {
            break label359;
          }
          ((ViewTitleWithAnimation)localObject).setTopPaddingVisibility(0);
          AppMethodBeat.o(292145);
          return;
          paramAnonymouss.oh(2, R.l.save_img_to_local);
          break;
          l = 0L;
          break label145;
        }
        label359:
        ((ViewTitleWithAnimation)localObject).setTopPaddingVisibility(8);
        label369:
        AppMethodBeat.o(292145);
      }
    };
    this.SGD.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        paramAnonymousInt = 6;
        AppMethodBeat.i(292172);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(292172);
          return;
          GestureGalleryUI.v(GestureGalleryUI.this);
          GestureGalleryUI.f(GestureGalleryUI.this, 1);
          AppMethodBeat.o(292172);
          return;
          GestureGalleryUI.w(GestureGalleryUI.this);
          GestureGalleryUI.f(GestureGalleryUI.this, 2);
          AppMethodBeat.o(292172);
          return;
          GestureGalleryUI.f(GestureGalleryUI.this, 3);
          GestureGalleryUI.x(GestureGalleryUI.this);
          AppMethodBeat.o(292172);
          return;
          if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(GestureGalleryUI.this.getContext()))
          {
            GestureGalleryUI.g(GestureGalleryUI.this, 6);
            paramAnonymousMenuItem = GestureGalleryUI.g(GestureGalleryUI.this);
            Object localObject1 = paramAnonymousMenuItem.SGj.dRR();
            if (((paramAnonymousMenuItem.AjA == 0) || (paramAnonymousMenuItem.AjA == 2)) && (!Util.isNullOrNil((String)localObject1)))
            {
              localObject2 = new hj();
              long l;
              if (paramAnonymousMenuItem.AjA == 2)
              {
                l = 1L;
                ((hj)localObject2).iqr = l;
                ((hj)localObject2).ikE = 3L;
                if (!paramAnonymousMenuItem.SGl) {
                  break label473;
                }
                l = 6L;
                label256:
                ((hj)localObject2).iOd = l;
                ((hj)localObject2).bMH();
                paramAnonymousMenuItem.Ajz = ((int)(z.bAM().hashCode() + System.currentTimeMillis()));
                localObject2 = ((com.tencent.mm.plugin.scanner.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.scanner.f.class)).getTranslationResult((String)localObject1);
                if ((localObject2 == null) || (!y.ZC(((gy)localObject2).field_resultFile))) {
                  break label485;
                }
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("original_file_path", (String)localObject1);
                if (!paramAnonymousMenuItem.SGl) {
                  break label480;
                }
              }
              label473:
              label480:
              for (paramAnonymousInt = 6;; paramAnonymousInt = 5)
              {
                ((Intent)localObject2).putExtra("translate_source", paramAnonymousInt);
                ((Intent)localObject2).setClass(paramAnonymousMenuItem.activity, TranslationResultUI.class);
                localObject1 = paramAnonymousMenuItem.activity;
                localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
                com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransAndOcrLogic", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransAndOcrLogic", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousMenuItem.activity.finish();
                paramAnonymousMenuItem = paramAnonymousMenuItem.activity;
                paramAnonymousInt = R.a.anim_not_change;
                paramAnonymousMenuItem.overridePendingTransition(paramAnonymousInt, paramAnonymousInt);
                AppMethodBeat.o(292172);
                return;
                l = 0L;
                break;
                l = 5L;
                break label256;
              }
              label485:
              if ((com.tencent.mm.kernel.h.aZW().bFQ() == 6) || (com.tencent.mm.kernel.h.aZW().bFQ() == 4)) {
                break label623;
              }
              k.c(paramAnonymousMenuItem.activity, paramAnonymousMenuItem.activity.getString(R.l.app_network_unavailable), "", true);
              paramAnonymousMenuItem.dSe();
              Log.i("MicroMsg.GestureGalleryTransLogic", "try to translate img %s, sessionId %d", new Object[] { localObject1, Integer.valueOf(paramAnonymousMenuItem.Ajz) });
              localObject2 = new wg();
              localObject3 = ((wg)localObject2).hZR;
              if (!paramAnonymousMenuItem.SGl) {
                break label659;
              }
            }
            for (;;)
            {
              ((wg.a)localObject3).scene = paramAnonymousInt;
              ((wg)localObject2).hZR.filePath = ((String)localObject1);
              ((wg)localObject2).hZR.hBm = paramAnonymousMenuItem.Ajz;
              ((wg)localObject2).publish();
              AppMethodBeat.o(292172);
              return;
              label623:
              paramAnonymousMenuItem.AjA = 1;
              paramAnonymousMenuItem.AjC.setVisibility(0);
              paramAnonymousMenuItem.AjD.setVisibility(0);
              paramAnonymousMenuItem.AjE.setVisibility(0);
              paramAnonymousMenuItem.dSf();
              break;
              label659:
              paramAnonymousInt = 5;
            }
            GestureGalleryUI.g(GestureGalleryUI.this, 7);
            GestureGalleryUI.b(GestureGalleryUI.this, 15);
            AppMethodBeat.o(292172);
            return;
            paramAnonymousMenuItem = GestureGalleryUI.g(GestureGalleryUI.this);
            Object localObject3 = GestureGalleryUI.a(GestureGalleryUI.this);
            localObject1 = GestureGalleryUI.a(GestureGalleryUI.this).getSelectedView();
            Object localObject2 = GestureGalleryUI.this.SGs;
            if (paramAnonymousMenuItem.RnQ == null)
            {
              paramAnonymousMenuItem.RnQ = ((com.tencent.mm.plugin.scanner.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.scanner.api.c.class)).aQ(paramAnonymousMenuItem.activity, 1);
              paramAnonymousMenuItem.RnQ.iT((View)localObject3);
            }
            localObject3 = new com.tencent.mm.plugin.scanner.api.e();
            ((com.tencent.mm.plugin.scanner.api.e)localObject3).type = 12;
            ((com.tencent.mm.plugin.scanner.api.e)localObject3).sessionId = System.currentTimeMillis();
            ((com.tencent.mm.plugin.scanner.api.e)localObject3).OMG = 3;
            ((com.tencent.mm.plugin.scanner.api.e)localObject3).OMK = false;
            ((com.tencent.mm.plugin.scanner.api.e)localObject3).OML = true;
            ((com.tencent.mm.plugin.scanner.api.e)localObject3).source = 204;
            ((com.tencent.mm.plugin.scanner.api.e)localObject3).imagePath = ((String)localObject2);
            paramAnonymousMenuItem.AjC.setVisibility(0);
            paramAnonymousMenuItem.AjD.setVisibility(0);
            paramAnonymousMenuItem.AjE.setVisibility(0);
            paramAnonymousMenuItem.dSf();
            paramAnonymousMenuItem.RnQ.iU((View)localObject1);
            localObject1 = new com.tencent.mm.plugin.scanner.api.d();
            ((com.tencent.mm.plugin.scanner.api.d)localObject1).pvC = true;
            paramAnonymousMenuItem.RnP = paramAnonymousMenuItem.RnQ.a((com.tencent.mm.plugin.scanner.api.e)localObject3, (com.tencent.mm.plugin.scanner.api.d)localObject1, paramAnonymousMenuItem.RnS);
            GestureGalleryUI.e(GestureGalleryUI.this, 1);
          }
        }
      }
    };
    this.SGD.aeLi = new f.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(292135);
        GestureGalleryUI.g(GestureGalleryUI.this, 5);
        GestureGalleryUI.a(GestureGalleryUI.this, null);
        GestureGalleryUI.y(GestureGalleryUI.this).clear();
        GestureGalleryUI.z(GestureGalleryUI.this);
        GestureGalleryUI.A(GestureGalleryUI.this).onDismiss();
        AppMethodBeat.o(292135);
      }
    };
    if ((!getContext().isFinishing()) && (hBj())) {
      this.SGD.dDn();
    }
    if ((this.SGE) && (Util.isNullOrNil(this.SGF)) && (bh.aZW().bFQ() != 0))
    {
      tm localtm = new tm();
      localtm.hXd.hBk = System.currentTimeMillis();
      localtm.hXd.filePath = this.SGs;
      localtm.hXd.hXe = new HashSet(this.SGI);
      localtm.hXd.hXf = true;
      this.Rdf = this.SGs;
      localtm.publish();
      this.GYm = Long.valueOf(System.currentTimeMillis());
    }
    AppMethodBeat.o(292157);
  }
  
  private static void fixInputMethodManagerLeak(Context paramContext)
  {
    AppMethodBeat.i(29103);
    if ((Build.VERSION.SDK_INT < 19) || (Build.VERSION.SDK_INT > 22))
    {
      AppMethodBeat.o(29103);
      return;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(29103);
      return;
    }
    int i = 0;
    while (i < 3)
    {
      Object localObject1 = new String[] { "mCurRootView", "mServedView", "mNextServedView" }[i];
      try
      {
        localObject1 = localInputMethodManager.getClass().getDeclaredField((String)localObject1);
        if (!((Field)localObject1).isAccessible()) {
          ((Field)localObject1).setAccessible(true);
        }
        Object localObject3 = ((Field)localObject1).get(localInputMethodManager);
        if ((localObject3 != null) && ((localObject3 instanceof View)))
        {
          if (((View)localObject3).getContext() != paramContext) {
            break label149;
          }
          ((Field)localObject1).set(localInputMethodManager, null);
        }
      }
      finally
      {
        label142:
        break label142;
      }
      i += 1;
      continue;
      label149:
      AppMethodBeat.o(29103);
      return;
    }
    AppMethodBeat.o(29103);
  }
  
  private ImageQBarDataBean getQBarDataOnCurrentDisplay()
  {
    AppMethodBeat.i(292194);
    Object localObject = i.a(this, this.SGp.hBr(), this.SGF, 0);
    if (((ArrayList)((kotlin.r)localObject).bsC).size() == 1) {}
    for (localObject = (ImageQBarDataBean)((ArrayList)((kotlin.r)localObject).bsC).get(0);; localObject = null)
    {
      AppMethodBeat.o(292194);
      return localObject;
    }
  }
  
  private GestureGalleryUI hBi()
  {
    AppMethodBeat.i(292149);
    if (this.SGO == null) {
      this.SGO = findViewById(R.h.fJa);
    }
    AppMethodBeat.o(292149);
    return this;
  }
  
  private boolean hBj()
  {
    AppMethodBeat.i(292169);
    if (!this.nVt)
    {
      AppMethodBeat.o(292169);
      return true;
    }
    if ((!hBn()) && (!hBl()) && (!hBm()))
    {
      AppMethodBeat.o(292169);
      return false;
    }
    AppMethodBeat.o(292169);
    return true;
  }
  
  private void hBk()
  {
    AppMethodBeat.i(292176);
    if ((!Util.isNullOrNil(this.SGs)) && (!this.SGL.containsKey(this.SGs)))
    {
      com.tencent.mm.kernel.h.baF();
      if ((com.tencent.mm.kernel.h.baD().mCm.bFQ() != 0) && (n.gPu())) {
        try
        {
          Object localObject = com.tencent.mm.plugin.scanner.util.g.PiK;
          localObject = com.tencent.mm.plugin.scanner.util.g.aVg(this.svg);
          if ((localObject != null) && (com.tencent.worddetect.a.qd(((Point)localObject).x, ((Point)localObject).y)))
          {
            Log.i("MicroMsg.GestureGalleryUI", "doWordDetectImage image overRatioLimit: %s , imagePath:%s", new Object[] { localObject, this.SGs });
            this.SGL.put(this.SGs, Boolean.TRUE);
            this.SGK.put(this.SGs, Boolean.TRUE);
            this.SGM.add(this.SGs);
            AppMethodBeat.o(292176);
            return;
          }
          this.SGQ.scan(this.SGs);
          Log.i("MicroMsg.GestureGalleryUI", "photoTransLogic.scan :" + this.SGs);
          AppMethodBeat.o(292176);
          return;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.GestureGalleryUI", localException, "", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(292176);
  }
  
  private boolean hBl()
  {
    AppMethodBeat.i(292178);
    try
    {
      String str = this.SGs;
      if ((str == null) || (!this.SGK.containsKey(str))) {
        break label82;
      }
      bool = ((Boolean)this.SGK.get(str)).booleanValue();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("MicroMsg.GestureGalleryUI", "", new Object[] { localException });
        boolean bool = false;
      }
    }
    Log.i("MicroMsg.GestureGalleryUI", "isCurrentImgCanShowTransEntrance:".concat(String.valueOf(bool)));
    AppMethodBeat.o(292178);
    return bool;
  }
  
  private boolean hBm()
  {
    AppMethodBeat.i(292181);
    try
    {
      String str = this.SGs;
      if ((str == null) || (!this.SGL.containsKey(str))) {
        break label82;
      }
      bool = ((Boolean)this.SGL.get(str)).booleanValue();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("MicroMsg.GestureGalleryUI", "", new Object[] { localException });
        boolean bool = false;
      }
    }
    Log.i("MicroMsg.GestureGalleryUI", "isCurrentImgCanShowOCREntrance:".concat(String.valueOf(bool)));
    AppMethodBeat.o(292181);
    return bool;
  }
  
  private boolean hBn()
  {
    AppMethodBeat.i(169766);
    if ((this.SGE) && (!Util.isNullOrNil(this.SGF)))
    {
      AppMethodBeat.o(169766);
      return true;
    }
    AppMethodBeat.o(169766);
    return false;
  }
  
  private String hBo()
  {
    AppMethodBeat.i(179723);
    if ((this.Fdo < 0) || (this.SHe == null) || (this.SHe.size() == 0))
    {
      AppMethodBeat.o(179723);
      return "";
    }
    String str = ((AppBrandMediaSource)this.SHe.get(this.Fdo)).url;
    Log.i("MicroMsg.GestureGalleryUI", "playVideo  url :%s", new Object[] { str });
    if ((str != null) && (str.startsWith("http")))
    {
      Object localObject;
      if (com.tencent.mm.plugin.av.a.TXd == null)
      {
        localObject = new File(com.tencent.mm.loader.i.b.bnt());
        if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
          ((File)localObject).mkdir();
        }
        f.a locala = new f.a(this);
        locala.cAM = new com.b.a.a.g(134217728L);
        locala.cAK = ((File)l.checkNotNull(localObject));
        localObject = new com.b.a.f(new com.b.a.c(locala.cAK, locala.cAL, locala.cAM, locala.cAN, locala.cAO), (byte)0);
        com.tencent.mm.plugin.av.a.TXd = (com.b.a.f)localObject;
      }
      for (;;)
      {
        localObject = ((com.b.a.f)localObject).cd(str);
        AppMethodBeat.o(179723);
        return localObject;
        localObject = com.tencent.mm.plugin.av.a.TXd;
      }
    }
    AppMethodBeat.o(179723);
    return str;
  }
  
  private void hBp()
  {
    AppMethodBeat.i(179725);
    hBq();
    this.SHl = new b((byte)0);
    b localb = this.SHl;
    localb.isStop = false;
    ThreadPool.post(localb, "gesture_gallery_ui_video_update_progress");
    AppMethodBeat.o(179725);
  }
  
  private void hBq()
  {
    if (this.SHl != null) {
      this.SHl.isStop = true;
    }
  }
  
  public final String dRR()
  {
    return this.SGs;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29101);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.GestureGalleryUI", "dispatchKeyEvent");
      if ((this.RnL != null) && (this.RnL.getVisibility() == 0))
      {
        this.RnL.P(this.GYk.longValue(), false);
        AppMethodBeat.o(29101);
        return true;
      }
      dmJ();
      AppMethodBeat.o(29101);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(29101);
    return bool;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(292499);
    Object localObject = this.detector;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if (paramMotionEvent.getActionMasked() == 0)
    {
      localObject = this.SGq.getSelectedView();
      if ((localObject instanceof WxImageView)) {
        ((WxImageView)localObject).setInternalTouchEventConsumed(true);
      }
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(292499);
    return bool;
  }
  
  public final void dmJ()
  {
    AppMethodBeat.i(29100);
    if (this.SHb)
    {
      AppMethodBeat.o(29100);
      return;
    }
    if ((this.SGq.getSelectedItemPosition() != this.SHf) || (!this.SGN))
    {
      finish();
      overridePendingTransition(0, 0);
      AppMethodBeat.o(29100);
      return;
    }
    if ((this.SHh) || (this.SGp == null))
    {
      Log.i("MicroMsg.GestureGalleryUI", "isRunningExitAnimation");
      AppMethodBeat.o(29100);
      return;
    }
    Log.i("MicroMsg.GestureGalleryUI", "runExitAnimation");
    int k = this.SGq.getWidth();
    int i = this.SGq.getHeight();
    int j = this.SGq.getSelectedItemPosition();
    Object localObject = (String)this.SHd.get(j);
    if (y.ZC((String)localObject))
    {
      if (Util.isNullOrNil((String)localObject)) {
        break label426;
      }
      localObject = BitmapUtil.getImageOptions((String)localObject);
      float f = k / ((BitmapFactory.Options)localObject).outWidth;
      j = (int)(((BitmapFactory.Options)localObject).outHeight * f);
      i = j;
      if (j > this.SGq.getHeight())
      {
        if (j < this.SGq.getHeight() * 2.5D) {
          this.wBc = (this.SGq.getHeight() * this.wBc / j);
        }
        i = this.SGq.getHeight();
      }
    }
    label426:
    for (;;)
    {
      this.wAY.oC(k, i);
      this.wAY.af(this.wBa, this.wAZ, this.wBb, this.wBc);
      if (this.Roh != 1.0D)
      {
        this.wAY.afIg = (1.0F / this.Roh);
        if ((this.Roi != 0) || (this.Roj != 0))
        {
          j = (int)(this.SGq.getWidth() / 2 * (1.0F - this.Roh));
          k = this.Roi;
          i = (int)(this.SGq.getHeight() / 2 + this.Roj - i / 2 * this.Roh);
          this.wAY.oE(j + k, i);
        }
      }
      this.wAY.a(this.SGq, this.wAT, new f.c()
      {
        public final void onAnimationEnd()
        {
          AppMethodBeat.i(292126);
          GestureGalleryUI.l(GestureGalleryUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(179706);
              GestureGalleryUI.this.finish();
              GestureGalleryUI.this.overridePendingTransition(0, 0);
              AppMethodBeat.o(179706);
            }
          });
          GestureGalleryUI.c(GestureGalleryUI.this, false);
          AppMethodBeat.o(292126);
        }
        
        public final void onAnimationStart()
        {
          AppMethodBeat.i(292121);
          GestureGalleryUI.c(GestureGalleryUI.this, true);
          GestureGalleryUI.l(GestureGalleryUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(179704);
              View localView = GestureGalleryUI.k(GestureGalleryUI.this).hBr();
              if ((localView instanceof MultiTouchImageView)) {
                ((MultiTouchImageView)localView).jma();
              }
              AppMethodBeat.o(179704);
            }
          }, 20L);
          AppMethodBeat.o(292121);
        }
      }, null);
      AppMethodBeat.o(29100);
      return;
      localObject = this.SGt.c((String)localObject, this.type, j, this.okK);
      break;
    }
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(292527);
    if ((this.SGw) || (this.SGx))
    {
      i = getIntent().getIntExtra("KOrientation", -1);
      AppMethodBeat.o(292527);
      return i;
    }
    int i = super.getForceOrientation();
    AppMethodBeat.o(292527);
    return i;
  }
  
  public int getLayoutId()
  {
    return R.i.gnp;
  }
  
  public final void hBe()
  {
    this.SHb = true;
    if (this.SGq != null) {
      this.SGq.SHb = true;
    }
  }
  
  public final void hBf()
  {
    AppMethodBeat.i(292662);
    this.SHb = false;
    if (this.SGq != null) {
      this.SGq.SHb = false;
    }
    this.SGP.setVisibility(0);
    AppMethodBeat.o(292662);
  }
  
  public final void hBg()
  {
    AppMethodBeat.i(292671);
    this.SGP.setVisibility(4);
    AppMethodBeat.o(292671);
  }
  
  public final void hBh()
  {
    AppMethodBeat.i(292581);
    int i = getIntent().getIntExtra("nevNext", 1);
    if (this.SGQ.AjA == 1)
    {
      AppMethodBeat.o(292581);
      return;
    }
    if ((this.SGw) && (!this.SGy))
    {
      Log.e("MicroMsg.GestureGalleryUI", "is from appbrand, but showmenu is false, don't show menu");
      AppMethodBeat.o(292581);
      return;
    }
    this.GYg = new com.tencent.mm.plugin.webview.k.q();
    this.GYg.iF(2);
    if (1 == i)
    {
      Object localObject1 = ad.bCb().M("basescanui@datacenter", true);
      Object localObject2 = p.f(this.SGp.hBr(), this.SGq.getXDown(), this.SGq.getYDown());
      if (localObject2 != null)
      {
        ((ad.b)localObject1).q("key_basescanui_touch_normalize_x", Float.valueOf(((PointF)localObject2).x));
        ((ad.b)localObject1).q("key_basescanui_touch_normalize_y", Float.valueOf(((PointF)localObject2).y));
      }
      if ((this.SGQ.AjA == 0) || (this.SGQ.AjA == 2))
      {
        localObject1 = this.SGQ;
        localObject2 = new hj();
        if (((a)localObject1).AjA != 2) {
          break label263;
        }
        l = 1L;
        ((hj)localObject2).iqr = l;
        ((hj)localObject2).ikE = 1L;
        if (!((a)localObject1).SGl) {
          break label268;
        }
      }
      label263:
      label268:
      for (long l = 6L;; l = 5L)
      {
        ((hj)localObject2).iOd = l;
        ((hj)localObject2).bMH();
        dcM();
        AppMethodBeat.o(292581);
        return;
        l = 0L;
        break;
      }
    }
    if (2 == i) {
      k.b(this, null, getContext().getResources().getStringArray(R.c.fjV), "", new k.d()
      {
        public final void qz(int paramAnonymousInt)
        {
          AppMethodBeat.i(292078);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(292078);
            return;
            GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.d(GestureGalleryUI.this));
            AppMethodBeat.o(292078);
            return;
            GestureGalleryUI localGestureGalleryUI = GestureGalleryUI.this;
            String str = GestureGalleryUI.d(GestureGalleryUI.this);
            if ((str == null) || (str.length() == 0))
            {
              AppMethodBeat.o(292078);
              return;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("Retr_File_Name", str);
            localIntent.putExtra("Retr_Msg_Type", 0);
            localIntent.putExtra("Retr_Compress_Type", 0);
            com.tencent.mm.plugin.subapp.a.pFn.j(localIntent, localGestureGalleryUI.getContext());
          }
        }
      });
    }
    AppMethodBeat.o(292581);
  }
  
  public void initView()
  {
    AppMethodBeat.i(29098);
    String str1 = Util.nullAsNil(getIntent().getStringExtra("nowUrl"));
    this.svg = Util.nullAsNil(getIntent().getStringExtra("nowUrlPath"));
    this.SHg = Util.nullAsNil(getIntent().getStringExtra("nowWebUrl"));
    this.type = getIntent().getIntExtra("type", 0);
    Object localObject = getIntent().getParcelableArrayListExtra("mediaSource");
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.SHe.clear();
      this.SHe.addAll((Collection)localObject);
    }
    localObject = getIntent().getStringArrayExtra("urlList");
    int i;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = Util.nullAsNil(getIntent().getStringExtra("htmlData"));
      i = 0;
    }
    int j;
    while (i >= 0)
    {
      j = ((String)localObject).indexOf("weixin://viewimage/", i);
      if (j >= 0)
      {
        i = ((String)localObject).indexOf("\"", j);
        if (i >= 0)
        {
          String str2 = ((String)localObject).substring(j + 19, i);
          Log.d("MicroMsg.GestureGalleryUI", "start:" + j + " end:" + i + " url:" + str2);
          this.SHd.add(str2);
          continue;
          this.SHd = Arrays.asList((Object[])localObject);
        }
      }
    }
    localObject = getIntent().getStringExtra("pageInfos");
    if (!Util.isNullOrNil((String)localObject)) {}
    try
    {
      this.SGB = new JSONArray((String)localObject);
      label302:
      i = 0;
      for (;;)
      {
        if (i < this.SHd.size())
        {
          if (str1.equals(this.SHd.get(i))) {
            this.Fdo = i;
          }
        }
        else
        {
          this.SHf = this.Fdo;
          if (getIntent().getIntExtra("currentPos", -1) >= 0) {
            this.SHf = getIntent().getIntExtra("currentPos", -1);
          }
          setBackBtn(new GestureGalleryUI.31(this));
          this.SGP = ((TextView)findViewById(R.h.fSZ));
          i = bf.I(getContext(), R.f.LargestPadding);
          j = com.tencent.mm.cd.a.bs(getContext(), R.f.SmallestPadding);
          Log.d("MicroMsg.GestureGalleryUI", "page indicator Y is " + String.valueOf(new StringBuilder().append(this.SGP.getY()).append(" pixel now").toString()));
          ((RelativeLayout.LayoutParams)this.SGP.getLayoutParams()).topMargin = (i + j);
          this.wAT = ((ImageView)findViewById(R.h.gallery_bg));
          this.SGU = ((RelativeLayout)findViewById(R.h.gbP));
          this.SGW = ((RedesignVideoPlayerSeekBar)findViewById(R.h.video_player_seek_bar));
          this.SGV = ((PressAlphaImageView)findViewById(R.h.video_close_btn));
          this.SGV.setOnClickListener(new GestureGalleryUI.17(this));
          this.SGW.setPlayBtnOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(292151);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              if (GestureGalleryUI.F(GestureGalleryUI.this).dxE()) {
                GestureGalleryUI.X(GestureGalleryUI.this);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(292151);
                return;
                GestureGalleryUI.Y(GestureGalleryUI.this);
              }
            }
          });
          this.SGW.setVideoTotalTime(0);
          this.SGW.seek(0);
          this.SGW.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
          {
            public final void blc() {}
            
            public final void tS(int paramAnonymousInt)
            {
              AppMethodBeat.i(292170);
              if (GestureGalleryUI.Z(GestureGalleryUI.this) != null) {
                GestureGalleryUI.Z(GestureGalleryUI.this).SHy.seekTo(paramAnonymousInt * 1000);
              }
              AppMethodBeat.o(292170);
            }
            
            public final void tT(int paramAnonymousInt) {}
          });
          this.SGp = new a();
          this.SGq = ((MMGestureGallery)findViewById(R.h.gallery));
          this.SGq.setVisibility(0);
          this.SGq.setVerticalFadingEdgeEnabled(false);
          this.SGq.setHorizontalFadingEdgeEnabled(false);
          this.SGq.setAdapter(this.SGp);
          this.SGq.setSelection(this.Fdo);
          this.SGq.setOnItemSelectedListener(this.SHi);
          this.SGq.setSingleClickOverListener(new MMGestureGallery.f()
          {
            public final void singleClickOver()
            {
              boolean bool2 = true;
              AppMethodBeat.i(292098);
              if (GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.e(GestureGalleryUI.this))) {}
              for (int i = 1;; i = 0)
              {
                if (i != 0)
                {
                  GestureGalleryUI localGestureGalleryUI = GestureGalleryUI.this;
                  if (!GestureGalleryUI.f(GestureGalleryUI.this))
                  {
                    bool1 = true;
                    GestureGalleryUI.a(localGestureGalleryUI, bool1);
                    localGestureGalleryUI = GestureGalleryUI.this;
                    if (GestureGalleryUI.f(GestureGalleryUI.this)) {
                      break label90;
                    }
                  }
                  label90:
                  for (boolean bool1 = bool2;; bool1 = false)
                  {
                    GestureGalleryUI.b(localGestureGalleryUI, bool1);
                    AppMethodBeat.o(292098);
                    return;
                    bool1 = false;
                    break;
                  }
                }
                if (GestureGalleryUI.g(GestureGalleryUI.this).AjA != 1) {
                  GestureGalleryUI.this.dmJ();
                }
                AppMethodBeat.o(292098);
                return;
              }
            }
          });
          getIntent().getIntExtra("nevNext", 1);
          this.SGq.setLongClickOverListener(new MMGestureGallery.c()
          {
            public final void longClickOver()
            {
              AppMethodBeat.i(292092);
              if ((GestureGalleryUI.g(GestureGalleryUI.this).AjA == 1) || (GestureGalleryUI.h(GestureGalleryUI.this)))
              {
                AppMethodBeat.o(292092);
                return;
              }
              GestureGalleryUI.this.hBh();
              AppMethodBeat.o(292092);
            }
          });
          this.wAY = new com.tencent.mm.ui.tools.f(this);
          hBi().SGO.setOnClickListener(new GestureGalleryUI.34(this));
          if (hBi().SGO.getVisibility() == 0) {
            anH(16);
          }
          this.RnL = ((MultiCodeMaskView)findViewById(R.h.multi_code_mask_view));
          AppMethodBeat.o(29098);
          return;
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      break label302;
    }
  }
  
  public final void l(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(29092);
    if (this.SGp != null)
    {
      if (paramInt == this.SGq.getSelectedItemPosition())
      {
        this.SGs = paramString2;
        this.SGr = paramInt;
        Log.d("MicroMsg.GestureGalleryUI", "onDownSucc, curFilename:%s, url:%s", new Object[] { this.SGs, paramString1 });
        hBk();
      }
      this.SGp.notifyDataSetChanged();
    }
    AppMethodBeat.o(29092);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(179726);
    if ((paramInt1 == 1) && (-1 == paramInt2))
    {
      Object localObject;
      if (paramIntent == null)
      {
        localObject = null;
        if (paramIntent != null) {
          break label82;
        }
      }
      final Runnable local28;
      label82:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        local28 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(292117);
            this.Afz.dismiss();
            AppMethodBeat.o(292117);
          }
        };
        if (!Util.isNullOrNil((String)localObject)) {
          break label93;
        }
        AppMethodBeat.o(179726);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label93:
      Iterator localIterator = Util.stringsToList(((String)localObject).split(",")).iterator();
      while (localIterator.hasNext())
      {
        final String str2 = (String)localIterator.next();
        String str1 = ((AppBrandMediaSource)this.SHe.get(this.Fdo)).nBe;
        localObject = str1;
        if (!y.ZC(str1)) {
          localObject = this.SGt.c(str1, this.type, this.Fdo, this.okK);
        }
        Log.i("MicroMsg.GestureGalleryUI", "onActivityResult,  sendVideo video:%s,  thumbFilename:%s", new Object[] { hBo(), localObject });
        com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(292119);
            com.tencent.mm.plugin.messenger.a.g.gaI().a(GestureGalleryUI.this.getContext(), str2, GestureGalleryUI.B(GestureGalleryUI.this), this.SHt, 1, (int)GestureGalleryUI.aa(GestureGalleryUI.this), "", "");
            MMHandlerThread.postToMainThread(local28);
            AppMethodBeat.o(292119);
          }
          
          public final String toString()
          {
            AppMethodBeat.i(292125);
            String str = super.toString() + "send video";
            AppMethodBeat.o(292125);
            return str;
          }
        });
        if (!Util.isNullOrNil(paramIntent)) {
          com.tencent.mm.plugin.messenger.a.g.gaI().ap(str2, paramIntent, ab.IX(str2));
        }
      }
      com.tencent.mm.ui.widget.snackbar.b.u(this, getString(R.l.finish_sent));
      AppMethodBeat.o(179726);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(179726);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(292521);
    if ((this.RnL != null) && (this.RnL.getVisibility() == 0))
    {
      this.RnL.P(this.GYk.longValue(), false);
      AppMethodBeat.o(292521);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(292521);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29093);
    super.onCreate(paramBundle);
    this.wAX = paramBundle;
    this.SHc.alive();
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setFlags(1024, 1024);
      getWindow().addFlags(67108864);
    }
    fullScreenNoTitleBar(true);
    this.detector = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(292168);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(292168);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(292162);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(292162);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(292155);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(292155);
      }
      
      public final boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(292140);
        if ((GestureGalleryUI.a(GestureGalleryUI.this) != null) && ((GestureGalleryUI.a(GestureGalleryUI.this).getSelectedView() instanceof WxImageView)))
        {
          GestureGalleryUI.this.dmJ();
          AppMethodBeat.o(292140);
          return true;
        }
        AppMethodBeat.o(292140);
        return false;
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(292148);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(292148);
        return bool;
      }
    });
    this.SGw = getIntent().getBooleanExtra("isFromAppBrand", false);
    this.SGx = getIntent().getBooleanExtra("isFromAppBrandGame", false);
    this.SHa = getIntent().getBooleanExtra("isFromAppBrandWebView", false);
    this.nVt = getIntent().getBooleanExtra("forBidForward", false);
    this.SGu = getIntent().getBooleanExtra("isFromWebView", false);
    this.SGy = getIntent().getBooleanExtra("showmenu", true);
    this.SGz = getIntent().getBooleanExtra("isFromSimilarImg", false);
    this.SGA = getIntent().getBooleanExtra("isOfficialAccountImg", false);
    this.SGv = getIntent().getBooleanExtra("isOuntLink", false);
    this.okz = getIntent().getStringExtra("IsFromWebViewReffer");
    this.SGE = getIntent().getBooleanExtra("shouldShowScanQrCodeMenu", false);
    this.SGN = getIntent().getBooleanExtra("shouldRunDragAnimation", false);
    this.SGH = getIntent().getIntExtra("scanQrCodeGetA8KeyScene", 40);
    paramBundle = getIntent().getIntArrayExtra("scanCodeTypes");
    this.mScene = getIntent().getIntExtra("KScene", 0);
    this.SGC = com.tencent.mm.plugin.fts.a.d.Wd(67);
    int i;
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      i = 0;
      while (i < paramBundle.length)
      {
        this.SGI.add(Integer.valueOf(paramBundle[i]));
        i += 1;
      }
    }
    paramBundle = getIntent().getIntArrayExtra("scanResultCodeTypes");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      i = 0;
      while (i < paramBundle.length)
      {
        this.SGJ.add(Integer.valueOf(paramBundle[i]));
        i += 1;
      }
    }
    this.SGQ = new a(this, this, this, this, this.SGv);
    this.okK = getIntent().getStringExtra("cookie");
    Log.d("MicroMsg.GestureGalleryUI", "isFromWebView: %b, isFromWebViewReffer:%s, cookie = %s, forbidForward=%b", new Object[] { Boolean.valueOf(this.SGu), this.okz, this.okK, Boolean.valueOf(this.nVt) });
    this.SGt = new ag(this.SGu, this.okz);
    paramBundle = this.SGt;
    Log.d("MicroMsg.GetPicService", "addListener :" + hashCode());
    paramBundle.okB = this;
    this.Ahp.alive();
    this.Rdt.alive();
    initView();
    this.SHh = false;
    if (this.SGw) {
      getWindow().setBackgroundDrawableResource(R.g.black);
    }
    this.rAP = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a()
    {
      public final void onFetchedCodeInfo()
      {
        AppMethodBeat.i(292142);
        if ((GestureGalleryUI.b(GestureGalleryUI.this) != null) && (GestureGalleryUI.b(GestureGalleryUI.this).isShowing())) {
          GestureGalleryUI.c(GestureGalleryUI.this);
        }
        GestureGalleryUI.a(GestureGalleryUI.this, null);
        AppMethodBeat.o(292142);
      }
    });
    this.SGT = ((RelativeLayout)findViewById(R.h.fJV));
    if (this.SGB != null)
    {
      this.SHk = findViewById(R.h.fXW);
      this.SGT.setVisibility(0);
      ((TextView)findViewById(R.h.fUd)).setTextSize(1, 12.0F);
      this.SHk.setOnClickListener(new GestureGalleryUI.14(this));
      findViewById(R.h.fKl).setOnClickListener(new GestureGalleryUI.15(this));
      findViewById(R.h.fGb).setOnClickListener(new GestureGalleryUI.16(this));
      AppMethodBeat.o(29093);
      return;
    }
    this.SGT.setVisibility(8);
    AppMethodBeat.o(29093);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29094);
    super.onDestroy();
    Object localObject = this.SGt;
    Log.d("MicroMsg.GetPicService", "removeListener :" + hashCode());
    ((ag)localObject).okB = null;
    localObject = this.SGt;
    if (((ag)localObject).okx != null) {
      ((ag)localObject).okx.okF = true;
    }
    ((ag)localObject).okx = null;
    this.Ahp.dead();
    this.Rdt.dead();
    this.SHc.dead();
    fixInputMethodManagerLeak(this);
    if (this.SGQ != null)
    {
      localObject = this.SGQ;
      ((a)localObject).dSg();
      ((a)localObject).AjF.removeAllUpdateListeners();
      ((a)localObject).AjG.dead();
      ((a)localObject).hoc();
      com.tencent.mm.kernel.h.baD().b(((a)localObject).AjH);
      ((a)localObject).Ajx = null;
      ((a)localObject).activity = null;
      ((a)localObject).SGj = null;
      ((a)localObject).SGk = null;
    }
    localObject = new tz();
    ((tz)localObject).hXO.activity = this;
    ((tz)localObject).publish();
    Log.i("MicroMsg.GestureGalleryUI", "stopVideo");
    if (this.SGR != null)
    {
      this.SGR.SHy.stopPlayback();
      this.SGY = c.SHH;
      this.SGW.setIsPlay(false);
      this.SGW.setIplaySeekCallback(null);
      this.SGR.RfJ.setVisibility(0);
      this.SGR.Hai.setVisibility(0);
      this.SGR.SHy.setVisibility(8);
    }
    hBq();
    AppMethodBeat.o(29094);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29095);
    super.onPause();
    dSW();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(2048, 2048);
    }
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    AppMethodBeat.o(29095);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29096);
    super.onResume();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().clearFlags(2048);
    }
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    AppMethodBeat.o(29096);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(29099);
    Bundle localBundle = this.wAX;
    if ((this.isAnimated) || (!this.SGN)) {}
    for (;;)
    {
      super.onStart();
      AppMethodBeat.o(29099);
      return;
      this.isAnimated = true;
      this.wAZ = getIntent().getIntExtra("img_gallery_top", 0);
      this.wBa = getIntent().getIntExtra("img_gallery_left", 0);
      this.wBb = getIntent().getIntExtra("img_gallery_width", 0);
      this.wBc = getIntent().getIntExtra("img_gallery_height", 0);
      this.wAY.af(this.wBa, this.wAZ, this.wBb, this.wBc);
      if (localBundle == null) {
        this.SGq.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(292086);
            GestureGalleryUI.a(GestureGalleryUI.this).getViewTreeObserver().removeOnPreDrawListener(this);
            GestureGalleryUI.i(GestureGalleryUI.this).a(GestureGalleryUI.a(GestureGalleryUI.this), null, null);
            GestureGalleryUI.j(GestureGalleryUI.this);
            AppMethodBeat.o(292086);
            return true;
          }
        });
      }
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(29097);
    super.onStop();
    if (this.SGG != null)
    {
      be localbe = new be();
      localbe.hBh.activity = this;
      localbe.hBh.hBi = this.SGG.OGQ;
      localbe.publish();
      this.SGG = null;
    }
    this.SGF.clear();
    AppMethodBeat.o(29097);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    public a() {}
    
    private static void a(MultiTouchImageView paramMultiTouchImageView, Bitmap paramBitmap, boolean paramBoolean)
    {
      AppMethodBeat.i(292159);
      if (paramBitmap == null)
      {
        AppMethodBeat.o(292159);
        return;
      }
      if (paramBoolean)
      {
        paramMultiTouchImageView.setEnabled(false);
        if (Build.VERSION.SDK_INT != 20) {
          break label79;
        }
        paramMultiTouchImageView.setLayerType(1, null);
      }
      for (;;)
      {
        paramMultiTouchImageView.setEnableHorLongBmpMode(false);
        paramMultiTouchImageView.dU(paramBitmap.getWidth(), paramBitmap.getHeight());
        paramMultiTouchImageView.setImageBitmap(paramBitmap);
        paramMultiTouchImageView.setVisibility(0);
        AppMethodBeat.o(292159);
        return;
        paramMultiTouchImageView.setEnabled(true);
        break;
        label79:
        ForceGpuUtil.decideLayerType(paramMultiTouchImageView, paramBitmap.getWidth(), paramBitmap.getHeight());
      }
    }
    
    private static Bitmap bcH(String paramString)
    {
      boolean bool = true;
      AppMethodBeat.i(292165);
      if (paramString == null)
      {
        AppMethodBeat.o(292165);
        return null;
      }
      Log.i("MicroMsg.GestureGalleryUI", paramString);
      Object localObject = com.tencent.mm.modelimage.loader.a.bKl().Oo(paramString + "_" + y.bEl(paramString));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        AppMethodBeat.o(292165);
        return localObject;
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      Log.i("MicroMsg.GestureGalleryUI", String.valueOf(((BitmapFactory.Options)localObject).outWidth) + ", " + String.valueOf(((BitmapFactory.Options)localObject).outHeight));
      if (localBitmap != null)
      {
        Log.i("MicroMsg.GestureGalleryUI", "recycle bitmap:%s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
      localBitmap = BitmapUtil.getBitmapNative(paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = localBitmap;
        if (MMNativeJpeg.IsJpegFile(paramString))
        {
          localObject = localBitmap;
          if (MMNativeJpeg.isProgressive(paramString))
          {
            localObject = MMNativeJpeg.decodeAsBitmap(paramString);
            if (localObject != null) {
              break label241;
            }
          }
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.GestureGalleryUI", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(bool) });
        if (localObject != null) {
          break;
        }
        Log.e("MicroMsg.GestureGalleryUI", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(292165);
        return null;
        label241:
        bool = false;
      }
      com.tencent.mm.modelimage.loader.a.bKl().h(paramString + "_" + y.bEl(paramString), (Bitmap)localObject);
      AppMethodBeat.o(292165);
      return localObject;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(29086);
      Log.d("MicroMsg.GestureGalleryUI", "lstpicurl:" + GestureGalleryUI.E(GestureGalleryUI.this).size());
      int i = GestureGalleryUI.E(GestureGalleryUI.this).size();
      AppMethodBeat.o(29086);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(29087);
      AppMethodBeat.o(29087);
      return Integer.valueOf(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(29090);
      Object localObject2;
      int j;
      int i;
      Object localObject1;
      View localView;
      label362:
      int k;
      if ((GestureGalleryUI.N(GestureGalleryUI.this) != null) && (!GestureGalleryUI.N(GestureGalleryUI.this).isEmpty()) && (GestureGalleryUI.N(GestureGalleryUI.this).size() > paramInt))
      {
        localObject2 = (AppBrandMediaSource)GestureGalleryUI.N(GestureGalleryUI.this).get(paramInt);
        j = 0;
        i = j;
        if (localObject2 != null)
        {
          i = j;
          if (GestureGalleryUI.a(GestureGalleryUI.this, paramInt)) {
            i = 1;
          }
        }
        paramViewGroup = null;
        if (paramView != null) {
          paramViewGroup = (a)paramView.getTag();
        }
        if ((paramView == null) || ((i != 0) && (paramViewGroup != null) && (paramViewGroup.SHy == null)))
        {
          localObject1 = new a();
          localView = View.inflate(GestureGalleryUI.this, R.i.gnq, null);
          ((a)localObject1).SHw = ((ProgressBar)localView.findViewById(R.h.progressbar));
          ((a)localObject1).SHx = ((MMAnimateView)localView.findViewById(R.h.image));
          ((a)localObject1).Hai = ((ImageView)localView.findViewById(R.h.fZz));
          ((a)localObject1).HEl = localView.findViewById(R.h.gbt);
          ((a)localObject1).SHy = ((VideoView)localView.findViewById(R.h.video_view));
          ((a)localObject1).RfJ = ((ImageView)localView.findViewById(R.h.video_wait_play_btn));
          ((a)localObject1).SHz = localView.findViewById(R.h.gbD);
          ((a)localObject1).SHA = ((TextView)localView.findViewById(R.h.gbE));
          ((a)localObject1).RsB = ((MultiTouchImageView)localView.findViewById(R.h.multi_image));
          ((a)localObject1).HOl = ((WxImageView)localView.findViewById(R.h.wx_image));
          ((a)localObject1).HOl.setOnImageLoadEventListener(new com.tencent.mm.graphics.a.b()
          {
            public final void onImageLoadError(ImageDecodeResult paramAnonymousImageDecodeResult) {}
            
            public final void onImageLoaded(Bitmap paramAnonymousBitmap)
            {
              AppMethodBeat.i(292141);
              this.SHv.RsB.setVisibility(8);
              AppMethodBeat.o(292141);
            }
            
            public final void onPreviewLoadError(ImageDecodeResult paramAnonymousImageDecodeResult) {}
            
            public final void onPreviewLoaded() {}
            
            public final void onPreviewReleased() {}
            
            public final void onTileLoadError(ImageDecodeResult paramAnonymousImageDecodeResult) {}
          });
          if (i != 0)
          {
            ((a)localObject1).Hai.setVisibility(8);
            ((a)localObject1).Hai = ((ImageView)localView.findViewById(R.h.video_image));
          }
          localView.setTag(localObject1);
          localView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
          paramView = (String)GestureGalleryUI.E(GestureGalleryUI.this).get(paramInt);
          k = 0;
          j = i;
          if (i != 0)
          {
            paramView = ((AppBrandMediaSource)localObject2).nBe;
            j = 1;
          }
          paramViewGroup = paramView;
          if (!y.ZC(paramView))
          {
            paramView = GestureGalleryUI.I(GestureGalleryUI.this).c(paramView, GestureGalleryUI.G(GestureGalleryUI.this), paramInt, GestureGalleryUI.H(GestureGalleryUI.this));
            paramViewGroup = paramView;
            if (paramInt == GestureGalleryUI.O(GestureGalleryUI.this))
            {
              paramViewGroup = paramView;
              if (Util.isNullOrNil(paramView))
              {
                paramViewGroup = paramView;
                if (y.ZC(GestureGalleryUI.P(GestureGalleryUI.this)))
                {
                  paramView = GestureGalleryUI.P(GestureGalleryUI.this);
                  i = 1;
                  label498:
                  ((a)localObject1).SHy.setVisibility(8);
                  ((a)localObject1).SHy.stopPlayback();
                  if (j != 0)
                  {
                    ((a)localObject1).HEl.setVisibility(0);
                    GestureGalleryUI.b(GestureGalleryUI.this, (a)localObject1);
                    label539:
                    if (Util.isNullOrNil(paramView)) {
                      break label1271;
                    }
                  }
                }
              }
            }
          }
        }
      }
      label905:
      label1337:
      label1343:
      for (;;)
      {
        int m;
        try
        {
          ((a)localObject1).SHw.setVisibility(8);
          paramViewGroup = null;
          k = 0;
          if (!GestureGalleryUI.bcG(paramView))
          {
            if ((GestureGalleryUI.N(GestureGalleryUI.this) != null) && (!GestureGalleryUI.N(GestureGalleryUI.this).isEmpty())) {
              TextUtils.isEmpty(((AppBrandMediaSource)GestureGalleryUI.N(GestureGalleryUI.this).get(paramInt)).nBe);
            }
            paramViewGroup = bcH(paramView);
            if ((!GestureGalleryUI.Q(GestureGalleryUI.this)) || ((paramViewGroup != null) && (!paramViewGroup.isRecycled())) || (k != 0)) {
              continue;
            }
            GestureGalleryUI.this.finish();
            AppMethodBeat.o(29090);
            return localView;
            ((a)localObject1).HEl.setVisibility(8);
            break label539;
          }
          k = 1;
          continue;
          int n = 0;
          m = n;
          if (paramViewGroup != null)
          {
            m = n;
            if (!paramViewGroup.isRecycled())
            {
              if (paramViewGroup.getWidth() > 1024) {
                break label1337;
              }
              m = n;
              if (paramViewGroup.getHeight() > 1024) {
                break label1337;
              }
            }
          }
          label731:
          if (m != 0)
          {
            if (paramViewGroup != null)
            {
              m = aw.bf(GestureGalleryUI.this.getContext()).x;
              n = aw.bf(GestureGalleryUI.this.getContext()).y;
              long l = paramViewGroup.getWidth() * paramViewGroup.getHeight();
              if ((GestureGalleryUI.r(GestureGalleryUI.this)) && (!paramViewGroup.isRecycled()) && (l < m * n))
              {
                m = 1;
                break label1343;
              }
            }
          }
          else
          {
            if (!ImgUtil.isGif(paramView)) {
              break label973;
            }
            if (paramInt == GestureGalleryUI.O(GestureGalleryUI.this)) {
              GestureGalleryUI.R(GestureGalleryUI.this);
            }
          }
        }
        catch (Exception paramView)
        {
          Log.i("MicroMsg.GestureGalleryUI", "Catch Exception");
          continue;
        }
        try
        {
          ((a)localObject1).SHx.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
          ((a)localObject1).Hai.setVisibility(8);
          ((a)localObject1).SHx.setVisibility(0);
          localObject2 = ((a)localObject1).SHx;
          ((MMAnimateView)localObject2).JgG = GestureGalleryUI.r(GestureGalleryUI.this);
          ((MMAnimateView)localObject2).jl(paramView, null);
          AppMethodBeat.o(29090);
          return localView;
          m = 0;
        }
        catch (Exception paramView)
        {
          Log.e("MicroMsg.GestureGalleryUI", Util.stackTraceToString(paramView));
          ((a)localObject1).SHx.setVisibility(0);
          ((a)localObject1).Hai.setVisibility(8);
          ((a)localObject1).SHx.setImageBitmap(paramViewGroup);
          continue;
        }
        label973:
        label1271:
        while (m == 0)
        {
          if ((i != 0) && (paramViewGroup != null) && (!paramViewGroup.isRecycled()))
          {
            ((a)localObject1).SHw.setVisibility(0);
            a(((a)localObject1).RsB, paramViewGroup, true);
            break label905;
          }
          if ((j != 0) && (paramViewGroup != null) && (!paramViewGroup.isRecycled()))
          {
            ((a)localObject1).SHw.setVisibility(8);
            ((a)localObject1).Hai.setVisibility(0);
            ((a)localObject1).Hai.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            ((a)localObject1).Hai.setImageBitmap(paramViewGroup);
            break label905;
          }
          if ((paramViewGroup != null) && (!paramViewGroup.isRecycled()))
          {
            ((a)localObject1).Hai.setVisibility(8);
            ((a)localObject1).SHx.setVisibility(8);
            a(((a)localObject1).RsB, paramViewGroup, false);
            break label905;
          }
          if (k != 0)
          {
            if (((a)localObject1).HOl.getVisibility() != 8) {
              break label905;
            }
            if (paramInt == GestureGalleryUI.O(GestureGalleryUI.this))
            {
              paramViewGroup = bcH(GestureGalleryUI.P(GestureGalleryUI.this));
              a(((a)localObject1).RsB, paramViewGroup, true);
            }
            paramViewGroup = ((a)localObject1).HOl;
            localObject1 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
            localObject2 = MMBitmapFactory.decodeFile(paramView, (BitmapFactory.Options)localObject1);
            if (localObject2 != null) {
              ((Bitmap)localObject2).recycle();
            }
            paramViewGroup.setVisibility(0);
            paramViewGroup.setOnLongClickListener(new View.OnLongClickListener()
            {
              public final boolean onLongClick(View paramAnonymousView)
              {
                AppMethodBeat.i(292133);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$ImageAdapter$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
                GestureGalleryUI.this.hBh();
                com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$ImageAdapter$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(292133);
                return true;
              }
            });
            paramViewGroup.setOrientation(BackwardSupportUtil.ExifHelper.getExifOrientation(paramView));
            paramViewGroup.dU(((BitmapFactory.Options)localObject1).outWidth, ((BitmapFactory.Options)localObject1).outHeight);
            paramViewGroup.jma();
            paramViewGroup.a(paramView, null);
            break label905;
          }
          Log.e("MicroMsg.GestureGalleryUI", "load image failed");
          break label905;
          ((a)localObject1).SHw.setVisibility(0);
          ((a)localObject1).SHx.setVisibility(8);
          ((a)localObject1).Hai.setVisibility(8);
          ((a)localObject1).HEl.setVisibility(8);
          break label905;
          paramView = paramViewGroup;
          i = k;
          break label498;
          localObject1 = paramViewGroup;
          localView = paramView;
          break label362;
          localObject2 = null;
          break;
          m = 1;
          break label731;
        }
      }
    }
    
    public final View hBr()
    {
      AppMethodBeat.i(29088);
      View localView = null;
      if (GestureGalleryUI.a(GestureGalleryUI.this) != null) {
        localView = GestureGalleryUI.a(GestureGalleryUI.this).getSelectedView();
      }
      AppMethodBeat.o(29088);
      return localView;
    }
    
    public final class a
    {
      View HEl;
      WxImageView HOl;
      ImageView Hai;
      ImageView RfJ;
      MultiTouchImageView RsB;
      TextView SHA;
      ProgressBar SHw;
      MMAnimateView SHx;
      VideoView SHy;
      View SHz;
      
      public a() {}
    }
  }
  
  final class b
    implements Runnable
  {
    boolean isStop = true;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(179719);
      Log.i("MicroMsg.GestureGalleryUI", "start run play progress task");
      for (;;)
      {
        if (this.isStop) {
          break label127;
        }
        try
        {
          if ((GestureGalleryUI.ab(GestureGalleryUI.this) == GestureGalleryUI.c.SHD) || (GestureGalleryUI.ab(GestureGalleryUI.this) == GestureGalleryUI.c.SHC) || (GestureGalleryUI.ab(GestureGalleryUI.this) == GestureGalleryUI.c.SHE))
          {
            GestureGalleryUI localGestureGalleryUI = GestureGalleryUI.this;
            if (localGestureGalleryUI.SGR != null) {
              localGestureGalleryUI.SGW.post(new GestureGalleryUI.27(localGestureGalleryUI));
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.GestureGalleryUI", "PlayProgressTask run exception:" + localException.getMessage());
          }
        }
        try
        {
          Thread.sleep(200L);
        }
        catch (InterruptedException localInterruptedException) {}
      }
      label127:
      AppMethodBeat.o(179719);
    }
  }
  
  static enum c
  {
    static
    {
      AppMethodBeat.i(179722);
      SHB = new c("Idle", 0);
      SHC = new c("Prepared", 1);
      SHD = new c("Start", 2);
      SHE = new c("Resume", 3);
      SHF = new c("Paused", 4);
      SHG = new c("Complete", 5);
      SHH = new c("Stop", 6);
      SHI = new c("Error", 7);
      SHJ = new c[] { SHB, SHC, SHD, SHE, SHF, SHG, SHH, SHI };
      AppMethodBeat.o(179722);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI
 * JD-Core Version:    0.7.0.1
 */