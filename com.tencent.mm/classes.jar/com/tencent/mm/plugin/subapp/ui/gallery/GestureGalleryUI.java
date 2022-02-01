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
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
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
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import com.b.a.f.a;
import com.b.a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.c;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ay;
import com.tencent.mm.f.a.cj;
import com.tencent.mm.f.a.ol;
import com.tencent.mm.f.a.rx;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.f.a.sk;
import com.tencent.mm.f.a.uq;
import com.tencent.mm.f.a.uq.a;
import com.tencent.mm.f.b.a.ah;
import com.tencent.mm.f.b.a.fo;
import com.tencent.mm.f.c.ge;
import com.tencent.mm.media.model.AppBrandMediaSource;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ag.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView.b;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
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
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.tools.PressAlphaImageView;
import com.tencent.mm.ui.tools.f.c;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
import com.tencent.mm.vfs.q;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class GestureGalleryUI
  extends MMActivity
  implements ag.b, com.tencent.mm.plugin.scanner.word.a.a<String, com.tencent.mm.plugin.scanner.word.b>, a.a
{
  private String BrJ;
  private com.tencent.mm.plugin.webview.k.m BrK;
  public Long BrO;
  public Long BrP;
  private Long BrQ;
  private volatile String KDA;
  private IListener KDP;
  private MultiCodeMaskView KNZ;
  private float KOu;
  private int KOv;
  private int KOw;
  private a MeV;
  MMGestureGallery MeW;
  private int MeX;
  private String MeY;
  private ag MeZ;
  private long MfA;
  private c MfB;
  boolean MfC;
  private boolean MfD;
  private IListener<cj> MfE;
  private List<String> MfF;
  private List<AppBrandMediaSource> MfG;
  private int MfH;
  private int MfI;
  private String MfJ;
  private boolean MfK;
  private AdapterView.OnItemSelectedListener MfL;
  private View MfM;
  private b MfN;
  private boolean Mfa;
  private boolean Mfb;
  private boolean Mfc;
  private boolean Mfd;
  private boolean Mfe;
  private boolean Mff;
  private boolean Mfg;
  private JSONArray Mfh;
  private long Mfi;
  private com.tencent.mm.ui.widget.a.e Mfj;
  private volatile boolean Mfk;
  private ArrayList<ImageQBarDataBean> Mfl;
  private ImageQBarDataBean Mfm;
  private int Mfn;
  private final Set<Integer> Mfo;
  private final Set<Integer> Mfp;
  private boolean Mfq;
  private View Mfr;
  private TextView Mfs;
  private a Mft;
  GestureGalleryUI.a.a Mfu;
  private boolean Mfv;
  private RelativeLayout Mfw;
  private RelativeLayout Mfx;
  private PressAlphaImageView Mfy;
  RedesignVideoPlayerSeekBar Mfz;
  private boolean isAnimated;
  private boolean lqq;
  private String lsZ;
  private String ltk;
  private MMHandler mHandler;
  private int mScene;
  private ScanCodeSheetItemLogic oxq;
  private String pqt;
  private long sTg;
  private Bundle twA;
  private com.tencent.mm.ui.tools.f twB;
  private int twC;
  private int twD;
  private int twE;
  private int twF;
  private ImageView tww;
  private int type;
  private boolean wKO;
  private boolean wKP;
  private IListener wKS;
  
  public GestureGalleryUI()
  {
    AppMethodBeat.i(29091);
    this.Mfa = false;
    this.Mfb = false;
    this.lsZ = "";
    this.ltk = null;
    this.Mfc = false;
    this.Mfd = false;
    this.Mfe = true;
    this.Mff = false;
    this.Mfg = false;
    this.Mfh = null;
    this.Mfl = new ArrayList();
    this.Mfm = null;
    this.Mfo = new HashSet();
    this.Mfp = new HashSet();
    this.Mfq = false;
    this.isAnimated = false;
    this.twC = 0;
    this.twD = 0;
    this.twE = 0;
    this.twF = 0;
    this.mHandler = new MMHandler();
    this.wKP = com.tencent.mm.plugin.scanner.n.fBR();
    this.BrJ = "";
    this.lqq = false;
    this.Mfv = false;
    this.sTg = 0L;
    this.MfA = 0L;
    this.MfB = c.Mge;
    this.MfC = false;
    this.MfD = false;
    this.BrO = Long.valueOf(0L);
    this.BrP = Long.valueOf(0L);
    this.BrQ = Long.valueOf(0L);
    this.MfE = new GestureGalleryUI.12(this);
    this.MfF = new ArrayList();
    this.MfG = new ArrayList();
    this.type = 0;
    this.MfH = -1;
    this.MfI = -1;
    this.pqt = null;
    this.MfJ = null;
    this.KOu = 1.0F;
    this.KOv = 0;
    this.KOw = 0;
    this.MfK = false;
    this.MfL = new AdapterView.OnItemSelectedListener()
    {
      VideoView MfT;
      
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(292426);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$17", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        GestureGalleryUI.h(GestureGalleryUI.this, paramAnonymousInt);
        GestureGalleryUI.E(GestureGalleryUI.this).setText(GestureGalleryUI.c(GestureGalleryUI.this) + 1 + "/" + GestureGalleryUI.i(GestureGalleryUI.this).getCount());
        GestureGalleryUI.this.setMMTitle(GestureGalleryUI.c(GestureGalleryUI.this) + 1 + " / " + GestureGalleryUI.F(GestureGalleryUI.this).size());
        Log.d("MicroMsg.GestureGalleryUI", "pos:".concat(String.valueOf(paramAnonymousInt)));
        GestureGalleryUI.b(GestureGalleryUI.this, (String)GestureGalleryUI.F(GestureGalleryUI.this).get(paramAnonymousInt));
        GestureGalleryUI.c(GestureGalleryUI.this, "");
        GestureGalleryUI.b(GestureGalleryUI.this, false);
        if (this.MfT != null)
        {
          this.MfT.stopPlayback();
          this.MfT = null;
        }
        GestureGalleryUI.G(GestureGalleryUI.this).setIsPlay(false);
        GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.c.Mge);
        if ((paramAnonymousView != null) && (paramAnonymousView.getTag() != null))
        {
          paramAnonymousAdapterView = (GestureGalleryUI.a.a)paramAnonymousView.getTag();
          if ((paramAnonymousAdapterView != null) && (GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousInt)))
          {
            this.MfT = paramAnonymousAdapterView.Mga;
            GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousAdapterView);
            paramAnonymousAdapterView.BSB.setVisibility(0);
            paramAnonymousAdapterView.KGj.setVisibility(0);
            paramAnonymousAdapterView.MfY.setVisibility(8);
            paramAnonymousAdapterView.Mgb.setVisibility(8);
          }
        }
        else
        {
          if (!GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousInt)) {
            break label459;
          }
          GestureGalleryUI.c(GestureGalleryUI.this, GestureGalleryUI.C(GestureGalleryUI.this));
          GestureGalleryUI.i(GestureGalleryUI.this, paramAnonymousInt);
        }
        for (;;)
        {
          Log.i("MicroMsg.GestureGalleryUI", "curFilename:%s", new Object[] { GestureGalleryUI.k(GestureGalleryUI.this) });
          GestureGalleryUI.m(GestureGalleryUI.this);
          GestureGalleryUI.a(GestureGalleryUI.this, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$17", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(292426);
          return;
          if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.BSB == null)) {
            break;
          }
          paramAnonymousAdapterView.BSB.setVisibility(8);
          break;
          label459:
          GestureGalleryUI.c(GestureGalleryUI.this, GestureGalleryUI.J(GestureGalleryUI.this).c((String)GestureGalleryUI.F(GestureGalleryUI.this).get(paramAnonymousInt), GestureGalleryUI.H(GestureGalleryUI.this), paramAnonymousInt, GestureGalleryUI.I(GestureGalleryUI.this)));
          if (Util.isNullOrNil(GestureGalleryUI.k(GestureGalleryUI.this))) {
            GestureGalleryUI.c(GestureGalleryUI.this, (String)GestureGalleryUI.F(GestureGalleryUI.this).get(paramAnonymousInt));
          }
          GestureGalleryUI.i(GestureGalleryUI.this, paramAnonymousInt);
          if ((GestureGalleryUI.K(GestureGalleryUI.this) != null) && (GestureGalleryUI.L(GestureGalleryUI.this) != null) && (GestureGalleryUI.L(GestureGalleryUI.this).length() > GestureGalleryUI.M(GestureGalleryUI.this))) {
            if (GestureGalleryUI.L(GestureGalleryUI.this).optJSONObject(GestureGalleryUI.M(GestureGalleryUI.this)).has("jumpType")) {
              GestureGalleryUI.K(GestureGalleryUI.this).setVisibility(0);
            } else {
              GestureGalleryUI.K(GestureGalleryUI.this).setVisibility(8);
            }
          }
        }
      }
      
      public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    };
    this.wKS = new IListener() {};
    this.KDP = new IListener() {};
    AppMethodBeat.o(29091);
  }
  
  private void a(int paramInt, ImageQBarDataBean paramImageQBarDataBean)
  {
    AppMethodBeat.i(281322);
    if ((this.BrK == null) || (Util.isNullOrNil(this.MfJ)))
    {
      AppMethodBeat.o(281322);
      return;
    }
    this.BrK.url = this.MfJ;
    this.BrK.gco = this.Mfn;
    if (paramImageQBarDataBean != null)
    {
      this.BrK.QAl = true;
      this.BrK.apf(paramImageQBarDataBean.fys);
      this.BrK.scanResult = paramImageQBarDataBean.IAH;
    }
    paramImageQBarDataBean = com.tencent.mm.pluginsdk.ui.tools.ab.aXb(this.BrJ);
    this.BrK.EKt = paramImageQBarDataBean;
    this.BrK.rE(paramInt);
    AppMethodBeat.o(281322);
  }
  
  private void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2, Bundle paramBundle)
  {
    AppMethodBeat.i(281323);
    if ((!this.Mfc) && (!this.MfD))
    {
      AppMethodBeat.o(281323);
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
    paramBundle = com.tencent.mm.plugin.scanner.a.IAB;
    com.tencent.mm.plugin.scanner.a.a(str3, i, str1, this.MfD, str2, paramInt, paramString, paramBoolean1, paramBoolean2, this.MfJ);
    AppMethodBeat.o(281323);
  }
  
  private void aiG(int paramInt)
  {
    AppMethodBeat.i(281319);
    ah localah1 = new ah();
    ah localah2 = localah1.iX(com.tencent.mm.plugin.fts.a.e.NF(this.Mfi)).iY("");
    localah2.giu = paramInt;
    localah2.geN = 1;
    localah1.iZ("");
    localah1.ja("");
    if (this.mScene != 0) {}
    for (paramInt = this.mScene;; paramInt = 83)
    {
      localah1.ggl = paramInt;
      localah1.gix = 0;
      localah1.jb(com.tencent.mm.b.g.getMD5(this.MeY));
      localah1.giA = System.currentTimeMillis();
      localah1.bpa();
      com.tencent.mm.plugin.websearch.api.ar.a(localah1);
      AppMethodBeat.o(281319);
      return;
    }
  }
  
  private boolean aiH(int paramInt)
  {
    AppMethodBeat.i(281325);
    if ((this.MfG != null) && (this.MfG.size() > paramInt) && (this.MfG.get(paramInt) != null) && ("video".endsWith(((AppBrandMediaSource)this.MfG.get(paramInt)).kVJ)))
    {
      AppMethodBeat.o(281325);
      return true;
    }
    AppMethodBeat.o(281325);
    return false;
  }
  
  private void dmf()
  {
    AppMethodBeat.i(179724);
    Log.i("MicroMsg.GestureGalleryUI", "pauseVideo");
    if (this.Mfu != null)
    {
      this.MfA = (this.Mfz.getmPosition() * 1000);
      Log.i("MicroMsg.GestureGalleryUI", "pauseVideo currentVideoPos：%d", new Object[] { Long.valueOf(this.MfA) });
      this.Mfu.Mga.pause();
      this.Mfu.KGj.setVisibility(0);
      if ((this.MfB != c.Mgg) && (this.MfB != c.Mgh)) {
        break label133;
      }
      this.MfB = c.Mgi;
      this.MfC = true;
    }
    for (;;)
    {
      this.Mfz.setIsPlay(false);
      ghO();
      AppMethodBeat.o(179724);
      return;
      label133:
      c localc = c.Mgi;
    }
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
        Object localObject2 = ((Field)localObject1).get(localInputMethodManager);
        if ((localObject2 != null) && ((localObject2 instanceof View)))
        {
          if (((View)localObject2).getContext() != paramContext) {
            break label149;
          }
          ((Field)localObject1).set(localInputMethodManager, null);
        }
      }
      catch (Throwable localThrowable)
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
    AppMethodBeat.i(281326);
    Object localObject = i.a(this, this.MeV.ghP(), this.Mfl, 0);
    if (((ArrayList)((kotlin.o)localObject).Mx).size() == 1) {}
    for (localObject = (ImageQBarDataBean)((ArrayList)((kotlin.o)localObject).Mx).get(0);; localObject = null)
    {
      AppMethodBeat.o(281326);
      return localObject;
    }
  }
  
  private GestureGalleryUI ghK()
  {
    AppMethodBeat.i(281320);
    if (this.Mfr == null) {
      this.Mfr = findViewById(R.h.dHO);
    }
    AppMethodBeat.o(281320);
    return this;
  }
  
  private boolean ghL()
  {
    AppMethodBeat.i(169766);
    if ((this.Mfk) && (!Util.isNullOrNil(this.Mfl)))
    {
      AppMethodBeat.o(169766);
      return true;
    }
    AppMethodBeat.o(169766);
    return false;
  }
  
  private String ghM()
  {
    AppMethodBeat.i(179723);
    if ((this.MfH < 0) || (this.MfG == null) || (this.MfG.size() == 0))
    {
      AppMethodBeat.o(179723);
      return "";
    }
    String str = ((AppBrandMediaSource)this.MfG.get(this.MfH)).url;
    Log.i("MicroMsg.GestureGalleryUI", "playVideo  url :%s", new Object[] { str });
    if ((str != null) && (str.startsWith("http")))
    {
      Object localObject;
      if (com.tencent.mm.plugin.at.a.Nkp == null)
      {
        localObject = new File(com.tencent.mm.loader.j.b.aTF());
        if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
          ((File)localObject).mkdir();
        }
        f.a locala = new f.a(this);
        locala.aFa = new com.b.a.a.g(134217728L);
        locala.aEY = ((File)l.checkNotNull(localObject));
        localObject = new com.b.a.f(new com.b.a.c(locala.aEY, locala.aEZ, locala.aFa, locala.aFb, locala.aFc), (byte)0);
        com.tencent.mm.plugin.at.a.Nkp = (com.b.a.f)localObject;
      }
      for (;;)
      {
        localObject = ((com.b.a.f)localObject).aQ(str);
        AppMethodBeat.o(179723);
        return localObject;
        localObject = com.tencent.mm.plugin.at.a.Nkp;
      }
    }
    AppMethodBeat.o(179723);
    return str;
  }
  
  private void ghN()
  {
    AppMethodBeat.i(179725);
    ghO();
    this.MfN = new b((byte)0);
    b localb = this.MfN;
    localb.isStop = false;
    ThreadPool.post(localb, "gesture_gallery_ui_video_update_progress");
    AppMethodBeat.o(179725);
  }
  
  private void ghO()
  {
    if (this.MfN != null) {
      this.MfN.isStop = true;
    }
  }
  
  private void zJ(boolean paramBoolean)
  {
    AppMethodBeat.i(29102);
    if (this.Mfj == null) {
      this.Mfj = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
    }
    this.Mfj.ODT = new q.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
      {
        AppMethodBeat.i(286241);
        GestureGalleryUI.a(GestureGalleryUI.this).setFooterView(null);
        paramAnonymouso.clear();
        Object localObject;
        fo localfo;
        if (!GestureGalleryUI.p(GestureGalleryUI.this))
        {
          paramAnonymouso.mn(1, R.l.readerapp_alert_retransmit);
          if (GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.c(GestureGalleryUI.this)))
          {
            paramAnonymouso.mn(2, R.l.save_video_to_local);
            paramAnonymouso.mn(3, R.l.plugin_favorite_opt);
          }
        }
        else if (((GestureGalleryUI.q(GestureGalleryUI.this)) || (GestureGalleryUI.r(GestureGalleryUI.this))) && (!Util.isNullOrNil(GestureGalleryUI.k(GestureGalleryUI.this))))
        {
          paramAnonymouso.mn(4, R.l.chatting_image_long_click_photo_trans);
          localObject = GestureGalleryUI.e(GestureGalleryUI.this);
          localfo = new fo();
          if (((a)localObject).wNd != 2) {
            break label293;
          }
          l = 1L;
          label145:
          localfo.gnP = l;
          localfo.gef = 2L;
          if (!((a)localObject).MeR) {
            break label298;
          }
        }
        label293:
        label298:
        for (long l = 6L;; l = 5L)
        {
          localfo.gBe = l;
          localfo.bpa();
          if (!GestureGalleryUI.f(GestureGalleryUI.this))
          {
            paramAnonymouso.add(0, 6, 0, GestureGalleryUI.this.getString(i.j.find_friends_search));
            GestureGalleryUI.s(GestureGalleryUI.this);
          }
          if (!GestureGalleryUI.t(GestureGalleryUI.this)) {
            break label315;
          }
          localObject = GestureGalleryUI.u(GestureGalleryUI.this);
          GestureGalleryUI.a(GestureGalleryUI.this).setFooterView((View)localObject);
          if (!(localObject instanceof ViewTitleWithAnimation)) {
            break label315;
          }
          if (paramAnonymouso.size() <= 1) {
            break label305;
          }
          ((ViewTitleWithAnimation)localObject).setTopPaddingVisibility(0);
          AppMethodBeat.o(286241);
          return;
          paramAnonymouso.mn(2, R.l.save_img_to_local);
          break;
          l = 0L;
          break label145;
        }
        label305:
        ((ViewTitleWithAnimation)localObject).setTopPaddingVisibility(8);
        label315:
        AppMethodBeat.o(286241);
      }
    };
    this.Mfj.ODU = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        paramAnonymousInt = 6;
        AppMethodBeat.i(278940);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(278940);
          return;
          GestureGalleryUI.v(GestureGalleryUI.this);
          GestureGalleryUI.e(GestureGalleryUI.this, 1);
          AppMethodBeat.o(278940);
          return;
          GestureGalleryUI.w(GestureGalleryUI.this);
          GestureGalleryUI.e(GestureGalleryUI.this, 2);
          AppMethodBeat.o(278940);
          return;
          GestureGalleryUI.e(GestureGalleryUI.this, 3);
          GestureGalleryUI.x(GestureGalleryUI.this);
          AppMethodBeat.o(278940);
          return;
          if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(GestureGalleryUI.this.getContext()))
          {
            GestureGalleryUI.f(GestureGalleryUI.this, 6);
            paramAnonymousMenuItem = GestureGalleryUI.e(GestureGalleryUI.this);
            Object localObject1 = paramAnonymousMenuItem.MeQ.dlb();
            Object localObject2;
            label232:
            uq.a locala;
            if (((paramAnonymousMenuItem.wNd == 0) || (paramAnonymousMenuItem.wNd == 2)) && (!Util.isNullOrNil((String)localObject1)))
            {
              localObject2 = new fo();
              long l;
              if (paramAnonymousMenuItem.wNd == 2)
              {
                l = 1L;
                ((fo)localObject2).gnP = l;
                ((fo)localObject2).gef = 3L;
                if (!paramAnonymousMenuItem.MeR) {
                  break label449;
                }
                l = 6L;
                ((fo)localObject2).gBe = l;
                ((fo)localObject2).bpa();
                paramAnonymousMenuItem.wNc = ((int)(z.bcZ().hashCode() + System.currentTimeMillis()));
                localObject2 = ((com.tencent.mm.plugin.scanner.f)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.scanner.f.class)).getTranslationResult((String)localObject1);
                if ((localObject2 == null) || (!com.tencent.mm.vfs.u.agG(((ge)localObject2).field_resultFile))) {
                  break label461;
                }
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("original_file_path", (String)localObject1);
                if (!paramAnonymousMenuItem.MeR) {
                  break label456;
                }
              }
              label449:
              label456:
              for (paramAnonymousInt = 6;; paramAnonymousInt = 5)
              {
                ((Intent)localObject2).putExtra("translate_source", paramAnonymousInt);
                ((Intent)localObject2).setClass(paramAnonymousMenuItem.activity, TranslationResultUI.class);
                localObject1 = paramAnonymousMenuItem.activity;
                localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
                com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousMenuItem.activity.finish();
                paramAnonymousMenuItem = paramAnonymousMenuItem.activity;
                paramAnonymousInt = R.a.anim_not_change;
                paramAnonymousMenuItem.overridePendingTransition(paramAnonymousInt, paramAnonymousInt);
                AppMethodBeat.o(278940);
                return;
                l = 0L;
                break;
                l = 5L;
                break label232;
              }
              label461:
              if ((com.tencent.mm.kernel.h.aGY().bih() == 6) || (com.tencent.mm.kernel.h.aGY().bih() == 4)) {
                break label602;
              }
              com.tencent.mm.ui.base.h.c(paramAnonymousMenuItem.activity, paramAnonymousMenuItem.activity.getString(R.l.app_network_unavailable), "", true);
              paramAnonymousMenuItem.dlo();
              Log.i("MicroMsg.GestureGalleryTransLogic", "try to translate img %s, sessionId %d", new Object[] { localObject1, Integer.valueOf(paramAnonymousMenuItem.wNc) });
              localObject2 = new uq();
              locala = ((uq)localObject2).fTT;
              if (!paramAnonymousMenuItem.MeR) {
                break label657;
              }
            }
            for (;;)
            {
              locala.scene = paramAnonymousInt;
              ((uq)localObject2).fTT.filePath = ((String)localObject1);
              ((uq)localObject2).fTT.fwM = paramAnonymousMenuItem.wNc;
              EventCenter.instance.publish((IEvent)localObject2);
              AppMethodBeat.o(278940);
              return;
              label602:
              paramAnonymousMenuItem.wNd = 1;
              paramAnonymousMenuItem.wNf.setVisibility(0);
              paramAnonymousMenuItem.wNg.setVisibility(0);
              paramAnonymousMenuItem.wNh.setVisibility(0);
              paramAnonymousMenuItem.wNi.setRepeatMode(1);
              paramAnonymousMenuItem.wNi.setRepeatCount(-1);
              paramAnonymousMenuItem.wNi.start();
              break;
              label657:
              paramAnonymousInt = 5;
            }
            GestureGalleryUI.f(GestureGalleryUI.this, 7);
            GestureGalleryUI.b(GestureGalleryUI.this, 15);
          }
        }
      }
    };
    this.Mfj.XbB = new e.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(286166);
        GestureGalleryUI.f(GestureGalleryUI.this, 5);
        GestureGalleryUI.a(GestureGalleryUI.this, null);
        GestureGalleryUI.y(GestureGalleryUI.this).clear();
        GestureGalleryUI.z(GestureGalleryUI.this);
        GestureGalleryUI.A(GestureGalleryUI.this).onDismiss();
        GestureGalleryUI.B(GestureGalleryUI.this);
        AppMethodBeat.o(286166);
      }
    };
    if (!getContext().isFinishing()) {
      if ((!this.lqq) || (ghL()) || (this.wKO)) {
        break label298;
      }
    }
    Object localObject;
    String str;
    label298:
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        this.Mfj.eik();
      }
      if ((this.Mfk) && (Util.isNullOrNil(this.Mfl)) && (bh.aGY().bih() != 0))
      {
        localObject = new rx();
        ((rx)localObject).fRg.fwK = System.currentTimeMillis();
        ((rx)localObject).fRg.filePath = this.MeY;
        ((rx)localObject).fRg.fRh = new HashSet(this.Mfo);
        ((rx)localObject).fRg.fRi = true;
        this.KDA = this.MeY;
        EventCenter.instance.publish((IEvent)localObject);
        this.BrQ = Long.valueOf(System.currentTimeMillis());
      }
      if (Util.isNullOrNil(this.MeY)) {
        break label341;
      }
      com.tencent.mm.kernel.h.aHH();
      if ((com.tencent.mm.kernel.h.aHF().kcd.bih() == 0) || (!paramBoolean) || (this.wKP)) {
        break label341;
      }
      localObject = this.Mft;
      str = this.MeY;
      if ((((a)localObject).activity != null) && (!((a)localObject).activity.isFinishing())) {
        break;
      }
      AppMethodBeat.o(29102);
      return;
    }
    if (((a)localObject).wNb == null) {
      ((a)localObject).wNb = new ImageWordScanDetailEngine(((a)localObject).activity, (byte)0);
    }
    ((a)localObject).wNb.a(str, ((a)localObject).wNa);
    label341:
    AppMethodBeat.o(29102);
  }
  
  public final void cJs()
  {
    AppMethodBeat.i(29100);
    if ((this.MeW.getSelectedItemPosition() != this.MfI) || (!this.Mfq))
    {
      finish();
      overridePendingTransition(0, 0);
      AppMethodBeat.o(29100);
      return;
    }
    if ((this.MfK) || (this.MeV == null))
    {
      Log.i("MicroMsg.GestureGalleryUI", "isRunningExitAnimation");
      AppMethodBeat.o(29100);
      return;
    }
    Log.i("MicroMsg.GestureGalleryUI", "runExitAnimation");
    int k = this.MeW.getWidth();
    int i = this.MeW.getHeight();
    int j = this.MeW.getSelectedItemPosition();
    Object localObject = (String)this.MfF.get(j);
    if (com.tencent.mm.vfs.u.agG((String)localObject))
    {
      if (Util.isNullOrNil((String)localObject)) {
        break label412;
      }
      localObject = BitmapUtil.getImageOptions((String)localObject);
      float f = k / ((BitmapFactory.Options)localObject).outWidth;
      j = (int)(((BitmapFactory.Options)localObject).outHeight * f);
      i = j;
      if (j > this.MeW.getHeight())
      {
        if (j < this.MeW.getHeight() * 2.5D) {
          this.twF = (this.MeW.getHeight() * this.twF / j);
        }
        i = this.MeW.getHeight();
      }
    }
    label412:
    for (;;)
    {
      this.twB.mJ(k, i);
      this.twB.V(this.twD, this.twC, this.twE, this.twF);
      if (this.KOu != 1.0D)
      {
        this.twB.XRS = (1.0F / this.KOu);
        if ((this.KOv != 0) || (this.KOw != 0))
        {
          j = (int)(this.MeW.getWidth() / 2 * (1.0F - this.KOu));
          k = this.KOv;
          i = (int)(this.MeW.getHeight() / 2 + this.KOw - i / 2 * this.KOu);
          this.twB.mL(j + k, i);
        }
      }
      this.twB.a(this.MeW, this.tww, new f.c()
      {
        public final void onAnimationEnd()
        {
          AppMethodBeat.i(272624);
          GestureGalleryUI.n(GestureGalleryUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(292404);
              GestureGalleryUI.this.finish();
              GestureGalleryUI.this.overridePendingTransition(0, 0);
              AppMethodBeat.o(292404);
            }
          });
          GestureGalleryUI.d(GestureGalleryUI.this, false);
          AppMethodBeat.o(272624);
        }
        
        public final void onAnimationStart()
        {
          AppMethodBeat.i(272623);
          GestureGalleryUI.d(GestureGalleryUI.this, true);
          GestureGalleryUI.n(GestureGalleryUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(286679);
              View localView = GestureGalleryUI.i(GestureGalleryUI.this).ghP();
              if ((localView instanceof MultiTouchImageView)) {
                ((MultiTouchImageView)localView).hJx();
              }
              AppMethodBeat.o(286679);
            }
          }, 20L);
          AppMethodBeat.o(272623);
        }
      }, null);
      AppMethodBeat.o(29100);
      return;
      localObject = this.MeZ.c((String)localObject, this.type, j, this.ltk);
      break;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29101);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.GestureGalleryUI", "dispatchKeyEvent");
      if ((this.KNZ != null) && (this.KNZ.getVisibility() == 0))
      {
        this.KNZ.F(this.BrO.longValue(), false);
        AppMethodBeat.o(29101);
        return true;
      }
      cJs();
      AppMethodBeat.o(29101);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(29101);
    return bool;
  }
  
  public final String dlb()
  {
    return this.MeY;
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(281317);
    if ((this.Mfc) || (this.Mfd))
    {
      i = getIntent().getIntExtra("KOrientation", -1);
      AppMethodBeat.o(281317);
      return i;
    }
    int i = super.getForceOrientation();
    AppMethodBeat.o(281317);
    return i;
  }
  
  public int getLayoutId()
  {
    return R.i.ekl;
  }
  
  public final void i(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(29092);
    if (this.MeV != null)
    {
      if (paramInt == this.MeW.getSelectedItemPosition())
      {
        this.MeY = paramString2;
        this.MeX = paramInt;
        Log.d("MicroMsg.GestureGalleryUI", "onDownSucc, curFilename:%s, url:%s", new Object[] { this.MeY, paramString1 });
      }
      this.MeV.notifyDataSetChanged();
    }
    AppMethodBeat.o(29092);
  }
  
  public void initView()
  {
    AppMethodBeat.i(29098);
    String str1 = Util.nullAsNil(getIntent().getStringExtra("nowUrl"));
    this.pqt = Util.nullAsNil(getIntent().getStringExtra("nowUrlPath"));
    this.MfJ = Util.nullAsNil(getIntent().getStringExtra("nowWebUrl"));
    this.type = getIntent().getIntExtra("type", 0);
    Object localObject = getIntent().getParcelableArrayListExtra("mediaSource");
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.MfG.clear();
      this.MfG.addAll((Collection)localObject);
    }
    localObject = getIntent().getStringArrayExtra("urlList");
    final int i;
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
          this.MfF.add(str2);
          continue;
          this.MfF = Arrays.asList((Object[])localObject);
        }
      }
    }
    localObject = getIntent().getStringExtra("pageInfos");
    if (!Util.isNullOrNil((String)localObject)) {}
    try
    {
      this.Mfh = new JSONArray((String)localObject);
      label302:
      i = 0;
      for (;;)
      {
        if (i < this.MfF.size())
        {
          if (str1.equals(this.MfF.get(i))) {
            this.MfH = i;
          }
        }
        else
        {
          this.MfI = this.MfH;
          if (getIntent().getIntExtra("currentPos", -1) >= 0) {
            this.MfI = getIntent().getIntExtra("currentPos", -1);
          }
          setBackBtn(new GestureGalleryUI.23(this));
          this.Mfs = ((TextView)findViewById(R.h.dQT));
          i = ax.F(getContext(), R.f.LargestPadding);
          j = com.tencent.mm.ci.a.aZ(getContext(), R.f.SmallestPadding);
          Log.d("MicroMsg.GestureGalleryUI", "page indicator Y is " + String.valueOf(new StringBuilder().append(this.Mfs.getY()).append(" pixel now").toString()));
          ((RelativeLayout.LayoutParams)this.Mfs.getLayoutParams()).topMargin = (i + j);
          this.tww = ((ImageView)findViewById(R.h.gallery_bg));
          this.Mfx = ((RelativeLayout)findViewById(R.h.dZa));
          this.Mfz = ((RedesignVideoPlayerSeekBar)findViewById(R.h.video_player_seek_bar));
          this.Mfy = ((PressAlphaImageView)findViewById(R.h.video_close_btn));
          this.Mfy.setOnClickListener(new GestureGalleryUI.16(this));
          this.Mfz.setPlayBtnOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(289926);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if (GestureGalleryUI.G(GestureGalleryUI.this).cTl()) {
                GestureGalleryUI.X(GestureGalleryUI.this);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(289926);
                return;
                GestureGalleryUI.Y(GestureGalleryUI.this);
              }
            }
          });
          this.Mfz.setVideoTotalTime(0);
          this.Mfz.seek(0);
          this.Mfz.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
          {
            public final void aRo() {}
            
            public final void tY(int paramAnonymousInt)
            {
              AppMethodBeat.i(208290);
              if (GestureGalleryUI.Z(GestureGalleryUI.this) != null) {
                GestureGalleryUI.Z(GestureGalleryUI.this).Mga.seekTo(paramAnonymousInt * 1000);
              }
              AppMethodBeat.o(208290);
            }
          });
          this.MeV = new a();
          this.MeW = ((MMGestureGallery)findViewById(R.h.gallery));
          this.MeW.setVisibility(0);
          this.MeW.setVerticalFadingEdgeEnabled(false);
          this.MeW.setHorizontalFadingEdgeEnabled(false);
          this.MeW.setAdapter(this.MeV);
          this.MeW.setSelection(this.MfH);
          this.MeW.setOnItemSelectedListener(this.MfL);
          this.MeW.setSingleClickOverListener(new MMGestureGallery.f()
          {
            public final void bwB()
            {
              boolean bool2 = true;
              AppMethodBeat.i(29075);
              if (GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.c(GestureGalleryUI.this))) {}
              for (int i = 1;; i = 0)
              {
                if (i != 0)
                {
                  GestureGalleryUI localGestureGalleryUI = GestureGalleryUI.this;
                  if (!GestureGalleryUI.d(GestureGalleryUI.this))
                  {
                    bool1 = true;
                    GestureGalleryUI.a(localGestureGalleryUI, bool1);
                    localGestureGalleryUI = GestureGalleryUI.this;
                    if (GestureGalleryUI.d(GestureGalleryUI.this)) {
                      break label92;
                    }
                  }
                  label92:
                  for (boolean bool1 = bool2;; bool1 = false)
                  {
                    GestureGalleryUI.b(localGestureGalleryUI, bool1);
                    AppMethodBeat.o(29075);
                    return;
                    bool1 = false;
                    break;
                  }
                }
                if (GestureGalleryUI.e(GestureGalleryUI.this).wNd != 1) {
                  GestureGalleryUI.this.cJs();
                }
                AppMethodBeat.o(29075);
                return;
              }
            }
          });
          i = getIntent().getIntExtra("nevNext", 1);
          this.MeW.setLongClickOverListener(new MMGestureGallery.c()
          {
            public final void bwC()
            {
              AppMethodBeat.i(29077);
              if (GestureGalleryUI.e(GestureGalleryUI.this).wNd == 1)
              {
                AppMethodBeat.o(29077);
                return;
              }
              if ((GestureGalleryUI.f(GestureGalleryUI.this)) && (!GestureGalleryUI.g(GestureGalleryUI.this)))
              {
                Log.e("MicroMsg.GestureGalleryUI", "is from appbrand, but showmenu is false, don't show menu");
                AppMethodBeat.o(29077);
                return;
              }
              GestureGalleryUI.a(GestureGalleryUI.this, new com.tencent.mm.plugin.webview.k.m());
              GestureGalleryUI.h(GestureGalleryUI.this).fs(2);
              Object localObject1;
              if (1 == i)
              {
                localObject1 = ad.beh().I("basescanui@datacenter", true);
                Object localObject2 = com.tencent.mm.plugin.scanner.util.n.g(GestureGalleryUI.i(GestureGalleryUI.this).ghP(), GestureGalleryUI.j(GestureGalleryUI.this).getXDown(), GestureGalleryUI.j(GestureGalleryUI.this).getYDown());
                if (localObject2 != null)
                {
                  ((ad.b)localObject1).k("key_basescanui_touch_normalize_x", Float.valueOf(((PointF)localObject2).x));
                  ((ad.b)localObject1).k("key_basescanui_touch_normalize_y", Float.valueOf(((PointF)localObject2).y));
                }
                if ((GestureGalleryUI.e(GestureGalleryUI.this).wNd == 0) || (GestureGalleryUI.e(GestureGalleryUI.this).wNd == 2))
                {
                  localObject1 = GestureGalleryUI.e(GestureGalleryUI.this);
                  localObject2 = new fo();
                  if (((a)localObject1).wNd == 2)
                  {
                    l = 1L;
                    ((fo)localObject2).gnP = l;
                    ((fo)localObject2).gef = 1L;
                    if (!((a)localObject1).MeR) {
                      break label288;
                    }
                  }
                  label288:
                  for (long l = 6L;; l = 5L)
                  {
                    ((fo)localObject2).gBe = l;
                    ((fo)localObject2).bpa();
                    GestureGalleryUI.c(GestureGalleryUI.this, com.tencent.mm.plugin.scanner.n.fBQ());
                    AppMethodBeat.o(29077);
                    return;
                    l = 0L;
                    break;
                  }
                }
                GestureGalleryUI.b(GestureGalleryUI.this);
                AppMethodBeat.o(29077);
                return;
              }
              if (2 == i)
              {
                localObject1 = GestureGalleryUI.this.getContext().getResources().getStringArray(R.c.djU);
                com.tencent.mm.ui.base.h.b(GestureGalleryUI.this, null, (String[])localObject1, "", new h.d()
                {
                  public final void qy(int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(29076);
                    switch (paramAnonymous2Int)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(29076);
                      return;
                      GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.k(GestureGalleryUI.this));
                      AppMethodBeat.o(29076);
                      return;
                      GestureGalleryUI localGestureGalleryUI = GestureGalleryUI.this;
                      String str = GestureGalleryUI.k(GestureGalleryUI.this);
                      if ((str == null) || (str.length() == 0))
                      {
                        AppMethodBeat.o(29076);
                        return;
                      }
                      Intent localIntent = new Intent();
                      localIntent.putExtra("Retr_File_Name", str);
                      localIntent.putExtra("Retr_Msg_Type", 0);
                      localIntent.putExtra("Retr_Compress_Type", 0);
                      com.tencent.mm.plugin.subapp.b.mIG.j(localIntent, localGestureGalleryUI.getContext());
                    }
                  }
                });
              }
              AppMethodBeat.o(29077);
            }
          });
          this.twB = new com.tencent.mm.ui.tools.f(this);
          ghK().Mfr.setOnClickListener(new GestureGalleryUI.30(this));
          if (ghK().Mfr.getVisibility() == 0) {
            aiG(16);
          }
          this.KNZ = ((MultiCodeMaskView)findViewById(R.h.multi_code_mask_view));
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
      final Runnable local26;
      label82:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        local26 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(287014);
            this.wJe.dismiss();
            AppMethodBeat.o(287014);
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
        String str1 = ((AppBrandMediaSource)this.MfG.get(this.MfH)).kVK;
        localObject = str1;
        if (!com.tencent.mm.vfs.u.agG(str1)) {
          localObject = this.MeZ.c(str1, this.type, this.MfH, this.ltk);
        }
        Log.i("MicroMsg.GestureGalleryUI", "onActivityResult,  sendVideo video:%s,  thumbFilename:%s", new Object[] { ghM(), localObject });
        com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(273200);
            com.tencent.mm.plugin.messenger.a.g.eRW().a(GestureGalleryUI.this.getContext(), str2, GestureGalleryUI.C(GestureGalleryUI.this), this.MfU, 1, (int)GestureGalleryUI.aa(GestureGalleryUI.this), "", "");
            MMHandlerThread.postToMainThread(local26);
            AppMethodBeat.o(273200);
          }
          
          public final String toString()
          {
            AppMethodBeat.i(273201);
            String str = super.toString() + "send video";
            AppMethodBeat.o(273201);
            return str;
          }
        });
        if (!Util.isNullOrNil(paramIntent)) {
          com.tencent.mm.plugin.messenger.a.g.eRW().ai(str2, paramIntent, com.tencent.mm.model.ab.QZ(str2));
        }
      }
      com.tencent.mm.ui.widget.snackbar.b.r(this, getString(R.l.finish_sent));
      AppMethodBeat.o(179726);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(179726);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(281316);
    if ((this.KNZ != null) && (this.KNZ.getVisibility() == 0))
    {
      this.KNZ.F(this.BrO.longValue(), false);
      AppMethodBeat.o(281316);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(281316);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29093);
    super.onCreate(paramBundle);
    this.twA = paramBundle;
    this.MfE.alive();
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setFlags(1024, 1024);
      getWindow().addFlags(67108864);
    }
    fullScreenNoTitleBar(true);
    this.Mfc = getIntent().getBooleanExtra("isFromAppBrand", false);
    this.Mfd = getIntent().getBooleanExtra("isFromAppBrandGame", false);
    this.MfD = getIntent().getBooleanExtra("isFromAppBrandWebView", false);
    this.lqq = getIntent().getBooleanExtra("forBidForward", false);
    this.Mfa = getIntent().getBooleanExtra("isFromWebView", false);
    this.Mfe = getIntent().getBooleanExtra("showmenu", true);
    this.Mff = getIntent().getBooleanExtra("isFromSimilarImg", false);
    this.Mfg = getIntent().getBooleanExtra("isOfficialAccountImg", false);
    this.Mfb = getIntent().getBooleanExtra("isOuntLink", false);
    this.lsZ = getIntent().getStringExtra("IsFromWebViewReffer");
    this.Mfk = getIntent().getBooleanExtra("shouldShowScanQrCodeMenu", false);
    this.Mfq = getIntent().getBooleanExtra("shouldRunDragAnimation", false);
    this.Mfn = getIntent().getIntExtra("scanQrCodeGetA8KeyScene", 40);
    paramBundle = getIntent().getIntArrayExtra("scanCodeTypes");
    this.mScene = getIntent().getIntExtra("KScene", 0);
    this.Mfi = com.tencent.mm.plugin.fts.a.d.Sw(67);
    int i;
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      i = 0;
      while (i < paramBundle.length)
      {
        this.Mfo.add(Integer.valueOf(paramBundle[i]));
        i += 1;
      }
    }
    paramBundle = getIntent().getIntArrayExtra("scanResultCodeTypes");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      i = 0;
      while (i < paramBundle.length)
      {
        this.Mfp.add(Integer.valueOf(paramBundle[i]));
        i += 1;
      }
    }
    this.Mft = new a(this, this, this, this.Mfb);
    this.ltk = getIntent().getStringExtra("cookie");
    Log.d("MicroMsg.GestureGalleryUI", "isFromWebView: %b, isFromWebViewReffer:%s, cookie = %s, forbidForward=%b", new Object[] { Boolean.valueOf(this.Mfa), this.lsZ, this.ltk, Boolean.valueOf(this.lqq) });
    this.MeZ = new ag(this.Mfa, this.lsZ);
    paramBundle = this.MeZ;
    Log.d("MicroMsg.GetPicService", "addListener :" + hashCode());
    paramBundle.ltb = this;
    EventCenter.instance.addListener(this.wKS);
    EventCenter.instance.addListener(this.KDP);
    initView();
    this.MfK = false;
    if (this.Mfc) {
      getWindow().setBackgroundDrawableResource(R.g.black);
    }
    this.oxq = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a()
    {
      public final void bPS()
      {
        AppMethodBeat.i(29065);
        if ((GestureGalleryUI.a(GestureGalleryUI.this) != null) && (GestureGalleryUI.a(GestureGalleryUI.this).isShowing())) {
          GestureGalleryUI.b(GestureGalleryUI.this);
        }
        GestureGalleryUI.a(GestureGalleryUI.this, null);
        AppMethodBeat.o(29065);
      }
    });
    this.Mfw = ((RelativeLayout)findViewById(R.h.dID));
    if (this.Mfh != null)
    {
      this.MfM = findViewById(R.h.dVA);
      this.Mfw.setVisibility(0);
      ((TextView)findViewById(R.h.dSd)).setTextSize(1, 12.0F);
      this.MfM.setOnClickListener(new GestureGalleryUI.13(this));
      findViewById(R.h.dIQ).setOnClickListener(new GestureGalleryUI.14(this));
      findViewById(R.h.dEX).setOnClickListener(new GestureGalleryUI.15(this));
      AppMethodBeat.o(29093);
      return;
    }
    this.Mfw.setVisibility(8);
    AppMethodBeat.o(29093);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29094);
    super.onDestroy();
    Object localObject = this.MeZ;
    Log.d("MicroMsg.GetPicService", "removeListener :" + hashCode());
    ((ag)localObject).ltb = null;
    localObject = this.MeZ;
    if (((ag)localObject).lsX != null) {
      ((ag)localObject).lsX.ltf = true;
    }
    ((ag)localObject).lsX = null;
    EventCenter.instance.removeListener(this.wKS);
    EventCenter.instance.removeListener(this.KDP);
    this.MfE.dead();
    fixInputMethodManagerLeak(this);
    if (this.Mft != null)
    {
      localObject = this.Mft;
      ((a)localObject).dlq();
      ((a)localObject).wNi.removeAllUpdateListeners();
      ((a)localObject).wNj.dead();
      com.tencent.mm.kernel.h.aHF().b(((a)localObject).wNk);
      ((a)localObject).wNa = null;
      ((a)localObject).activity = null;
      ((a)localObject).MeQ = null;
    }
    localObject = new sk();
    ((sk)localObject).fRT.activity = this;
    EventCenter.instance.publish((IEvent)localObject);
    Log.i("MicroMsg.GestureGalleryUI", "stopVideo");
    if (this.Mfu != null)
    {
      this.Mfu.Mga.stopPlayback();
      this.MfB = c.Mgk;
      this.Mfz.setIsPlay(false);
      this.Mfz.setIplaySeekCallback(null);
      this.Mfu.KGj.setVisibility(0);
      this.Mfu.Bth.setVisibility(0);
      this.Mfu.Mga.setVisibility(8);
    }
    ghO();
    AppMethodBeat.o(29094);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29095);
    super.onPause();
    dmf();
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
    Bundle localBundle = this.twA;
    if ((this.isAnimated) || (!this.Mfq)) {}
    for (;;)
    {
      super.onStart();
      AppMethodBeat.o(29099);
      return;
      this.isAnimated = true;
      this.twC = getIntent().getIntExtra("img_gallery_top", 0);
      this.twD = getIntent().getIntExtra("img_gallery_left", 0);
      this.twE = getIntent().getIntExtra("img_gallery_width", 0);
      this.twF = getIntent().getIntExtra("img_gallery_height", 0);
      this.twB.V(this.twD, this.twC, this.twE, this.twF);
      if (localBundle == null) {
        this.MeW.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(270111);
            GestureGalleryUI.j(GestureGalleryUI.this).getViewTreeObserver().removeOnPreDrawListener(this);
            GestureGalleryUI.l(GestureGalleryUI.this).a(GestureGalleryUI.j(GestureGalleryUI.this), null, null);
            GestureGalleryUI.m(GestureGalleryUI.this);
            AppMethodBeat.o(270111);
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
    if (this.Mfm != null)
    {
      ay localay = new ay();
      localay.fwH.activity = this;
      localay.fwH.fwI = this.Mfm.IAH;
      EventCenter.instance.publish(localay);
      this.Mfm = null;
    }
    this.Mfl.clear();
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
    
    private View aiI(int paramInt)
    {
      AppMethodBeat.i(29089);
      int i = GestureGalleryUI.j(GestureGalleryUI.this).getFirstVisiblePosition();
      int j = GestureGalleryUI.j(GestureGalleryUI.this).getChildCount();
      if ((paramInt < i) || (paramInt > j + i - 1))
      {
        localView = GestureGalleryUI.j(GestureGalleryUI.this).getAdapter().getView(paramInt, null, GestureGalleryUI.j(GestureGalleryUI.this));
        AppMethodBeat.o(29089);
        return localView;
      }
      View localView = GestureGalleryUI.j(GestureGalleryUI.this).getChildAt(paramInt - i);
      AppMethodBeat.o(29089);
      return localView;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(29086);
      Log.d("MicroMsg.GestureGalleryUI", "lstpicurl:" + GestureGalleryUI.F(GestureGalleryUI.this).size());
      int i = GestureGalleryUI.F(GestureGalleryUI.this).size();
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
      if ((GestureGalleryUI.N(GestureGalleryUI.this) != null) && (!GestureGalleryUI.N(GestureGalleryUI.this).isEmpty()) && (GestureGalleryUI.N(GestureGalleryUI.this).size() > paramInt)) {}
      for (Object localObject2 = (AppBrandMediaSource)GestureGalleryUI.N(GestureGalleryUI.this).get(paramInt);; localObject2 = null)
      {
        int j = 0;
        int i = j;
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
        Object localObject1;
        View localView;
        if ((paramView == null) || ((i != 0) && (paramViewGroup != null) && (paramViewGroup.Mga == null)))
        {
          localObject1 = new a();
          localView = View.inflate(GestureGalleryUI.this, R.i.ekm, null);
          ((a)localObject1).MfY = ((ProgressBar)localView.findViewById(R.h.progressbar));
          ((a)localObject1).MfZ = ((MMAnimateView)localView.findViewById(R.h.image));
          ((a)localObject1).Bth = ((ImageView)localView.findViewById(R.h.dWU));
          ((a)localObject1).BSB = localView.findViewById(R.h.dYF);
          ((a)localObject1).Mga = ((VideoView)localView.findViewById(R.h.video_view));
          ((a)localObject1).KGj = ((ImageView)localView.findViewById(R.h.video_wait_play_btn));
          ((a)localObject1).Mgb = localView.findViewById(R.h.dYP);
          ((a)localObject1).Mgc = ((TextView)localView.findViewById(R.h.dYQ));
          if (i != 0)
          {
            ((a)localObject1).Bth.setVisibility(8);
            ((a)localObject1).Bth = ((ImageView)localView.findViewById(R.h.video_image));
          }
          localView.setTag(localObject1);
        }
        for (;;)
        {
          localView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
          paramView = (String)GestureGalleryUI.F(GestureGalleryUI.this).get(paramInt);
          int k = 0;
          j = i;
          if (i != 0)
          {
            paramView = ((AppBrandMediaSource)localObject2).kVK;
            j = 1;
          }
          paramViewGroup = paramView;
          if (!com.tencent.mm.vfs.u.agG(paramView))
          {
            paramView = GestureGalleryUI.J(GestureGalleryUI.this).c(paramView, GestureGalleryUI.H(GestureGalleryUI.this), paramInt, GestureGalleryUI.I(GestureGalleryUI.this));
            paramViewGroup = paramView;
            if (paramInt == GestureGalleryUI.O(GestureGalleryUI.this))
            {
              paramViewGroup = paramView;
              if (Util.isNullOrNil(paramView))
              {
                paramViewGroup = paramView;
                if (com.tencent.mm.vfs.u.agG(GestureGalleryUI.P(GestureGalleryUI.this))) {
                  paramViewGroup = GestureGalleryUI.P(GestureGalleryUI.this);
                }
              }
            }
          }
          for (i = 1;; i = k)
          {
            ((a)localObject1).Mga.setVisibility(8);
            ((a)localObject1).Mga.stopPlayback();
            if (j != 0)
            {
              ((a)localObject1).BSB.setVisibility(0);
              GestureGalleryUI.b(GestureGalleryUI.this, (a)localObject1);
              if (Util.isNullOrNil(paramViewGroup)) {
                break label1378;
              }
              ((a)localObject1).MfY.setVisibility(8);
              if ((GestureGalleryUI.N(GestureGalleryUI.this) != null) && (!GestureGalleryUI.N(GestureGalleryUI.this).isEmpty())) {
                TextUtils.isEmpty(((AppBrandMediaSource)GestureGalleryUI.N(GestureGalleryUI.this).get(paramInt)).kVK);
              }
              if (paramViewGroup != null) {
                break label610;
              }
              paramView = null;
            }
            for (;;)
            {
              if ((!GestureGalleryUI.Q(GestureGalleryUI.this)) || ((paramView != null) && (!paramView.isRecycled()))) {
                break label840;
              }
              GestureGalleryUI.this.finish();
              AppMethodBeat.o(29090);
              return localView;
              ((a)localObject1).BSB.setVisibility(8);
              break;
              label610:
              localObject2 = com.tencent.mm.ay.a.a.bms().Wo(paramViewGroup + "_" + com.tencent.mm.vfs.u.bBQ(paramViewGroup));
              if (localObject2 != null)
              {
                paramView = (View)localObject2;
                if (!((Bitmap)localObject2).isRecycled()) {}
              }
              else
              {
                paramView = new BitmapFactory.Options();
                paramView.inJustDecodeBounds = true;
                paramView = BitmapFactory.decodeFile(paramViewGroup, paramView);
                if (paramView != null)
                {
                  Log.i("MicroMsg.GestureGalleryUI", "recycle bitmap:%s", new Object[] { paramView.toString() });
                  paramView.recycle();
                }
                localObject2 = BitmapUtil.getBitmapNative(paramViewGroup);
                paramView = (View)localObject2;
                if (localObject2 == null)
                {
                  paramView = (View)localObject2;
                  if (MMNativeJpeg.IsJpegFile(paramViewGroup))
                  {
                    paramView = (View)localObject2;
                    if (MMNativeJpeg.isProgressive(paramViewGroup))
                    {
                      paramView = MMNativeJpeg.decodeAsBitmap(paramViewGroup);
                      if (paramView != null) {
                        break label797;
                      }
                    }
                  }
                }
                label797:
                for (boolean bool = true;; bool = false)
                {
                  Log.i("MicroMsg.GestureGalleryUI", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(bool) });
                  if (paramView != null) {
                    break label803;
                  }
                  Log.e("MicroMsg.GestureGalleryUI", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramViewGroup)));
                  paramView = null;
                  break;
                }
                label803:
                com.tencent.mm.ay.a.a.bms().h(paramViewGroup + "_" + com.tencent.mm.vfs.u.bBQ(paramViewGroup), paramView);
              }
            }
            label840:
            int m = 0;
            k = m;
            if (paramView != null)
            {
              k = m;
              if (!paramView.isRecycled()) {
                if (paramView.getWidth() <= 1024)
                {
                  k = m;
                  if (paramView.getHeight() <= 1024) {}
                }
                else
                {
                  k = 1;
                }
              }
            }
            if (k != 0)
            {
              if (paramView != null)
              {
                k = com.tencent.mm.ui.ar.au(GestureGalleryUI.this.getContext()).x;
                m = com.tencent.mm.ui.ar.au(GestureGalleryUI.this.getContext()).y;
                long l = paramView.getWidth() * paramView.getHeight();
                if ((GestureGalleryUI.f(GestureGalleryUI.this)) && (!paramView.isRecycled()) && (l < k * m))
                {
                  k = 1;
                  if (k == 0) {
                    break label1121;
                  }
                }
              }
            }
            else
            {
              if (!ImgUtil.isGif(paramViewGroup)) {
                break label1121;
              }
              if (paramInt == GestureGalleryUI.O(GestureGalleryUI.this)) {
                GestureGalleryUI.R(GestureGalleryUI.this);
              }
            }
            label1363:
            for (;;)
            {
              try
              {
                ((a)localObject1).MfZ.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((a)localObject1).Bth.setVisibility(8);
                ((a)localObject1).MfZ.setVisibility(0);
                localObject2 = ((a)localObject1).MfZ;
                ((MMAnimateView)localObject2).DmW = GestureGalleryUI.f(GestureGalleryUI.this);
                ((MMAnimateView)localObject2).ie(paramViewGroup, null);
                AppMethodBeat.o(29090);
                return localView;
                k = 0;
              }
              catch (Exception paramViewGroup)
              {
                Log.e("MicroMsg.GestureGalleryUI", Util.stackTraceToString(paramViewGroup));
                ((a)localObject1).MfZ.setVisibility(0);
                ((a)localObject1).Bth.setVisibility(8);
                ((a)localObject1).MfZ.setImageBitmap(paramView);
                continue;
              }
              label1121:
              if ((i != 0) && (paramView != null) && (!paramView.isRecycled()))
              {
                ((a)localObject1).MfY.setVisibility(0);
                ((a)localObject1).Bth.setVisibility(0);
                ((a)localObject1).Bth.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((a)localObject1).Bth.setImageBitmap(paramView);
              }
              else if ((j != 0) && (paramView != null) && (!paramView.isRecycled()))
              {
                ((a)localObject1).MfY.setVisibility(8);
                ((a)localObject1).Bth.setVisibility(0);
                ((a)localObject1).Bth.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((a)localObject1).Bth.setImageBitmap(paramView);
              }
              else if ((paramView != null) && (!paramView.isRecycled()))
              {
                ((a)localObject1).MfZ.setVisibility(8);
                ((a)localObject1).Bth.setVisibility(8);
                paramViewGroup = new MultiTouchImageView(GestureGalleryUI.this, paramView.getWidth(), paramView.getHeight(), (byte)0);
                if (i != 0)
                {
                  paramViewGroup.setEnabled(false);
                  if (Build.VERSION.SDK_INT != 20) {
                    break label1363;
                  }
                  paramViewGroup.setLayerType(1, null);
                }
                for (;;)
                {
                  paramViewGroup.setEnableHorLongBmpMode(false);
                  paramViewGroup.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                  paramViewGroup.setImageBitmap(paramView);
                  AppMethodBeat.o(29090);
                  return paramViewGroup;
                  paramViewGroup.setEnabled(true);
                  break;
                  ForceGpuUtil.decideLayerType(paramViewGroup, paramView.getWidth(), paramView.getHeight());
                }
                label1378:
                ((a)localObject1).MfY.setVisibility(0);
                ((a)localObject1).MfZ.setVisibility(8);
                ((a)localObject1).Bth.setVisibility(8);
                ((a)localObject1).BSB.setVisibility(8);
              }
            }
          }
          localObject1 = paramViewGroup;
          localView = paramView;
        }
      }
    }
    
    public final View ghP()
    {
      AppMethodBeat.i(29088);
      View localView = aiI(GestureGalleryUI.this.MeW.getSelectedItemPosition());
      AppMethodBeat.o(29088);
      return localView;
    }
    
    public final class a
    {
      View BSB;
      ImageView Bth;
      ImageView KGj;
      ProgressBar MfY;
      MMAnimateView MfZ;
      VideoView Mga;
      View Mgb;
      TextView Mgc;
      
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
          if ((GestureGalleryUI.ab(GestureGalleryUI.this) == GestureGalleryUI.c.Mgg) || (GestureGalleryUI.ab(GestureGalleryUI.this) == GestureGalleryUI.c.Mgf) || (GestureGalleryUI.ab(GestureGalleryUI.this) == GestureGalleryUI.c.Mgh))
          {
            GestureGalleryUI localGestureGalleryUI = GestureGalleryUI.this;
            if (localGestureGalleryUI.Mfu != null) {
              localGestureGalleryUI.Mfz.post(new GestureGalleryUI.25(localGestureGalleryUI));
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
      Mge = new c("Idle", 0);
      Mgf = new c("Prepared", 1);
      Mgg = new c("Start", 2);
      Mgh = new c("Resume", 3);
      Mgi = new c("Paused", 4);
      Mgj = new c("Complete", 5);
      Mgk = new c("Stop", 6);
      Mgl = new c("Error", 7);
      Mgm = new c[] { Mge, Mgf, Mgg, Mgh, Mgi, Mgj, Mgk, Mgl };
      AppMethodBeat.o(179722);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI
 * JD-Core Version:    0.7.0.1
 */