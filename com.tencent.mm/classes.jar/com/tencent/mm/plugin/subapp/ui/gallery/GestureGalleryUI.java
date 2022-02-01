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
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.danikula.videocache.HttpProxyCacheServer;
import com.danikula.videocache.HttpProxyCacheServer.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.my;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.g.a.sq.a;
import com.tencent.mm.g.b.a.ce;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.media.model.AppBrandMediaSource;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ac.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.tools.PressAlphaImageView;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
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
public class GestureGalleryUI
  extends MMActivity
  implements ac.b, com.tencent.mm.plugin.scanner.word.a.a<String, com.tencent.mm.plugin.scanner.word.b>, a.a
{
  private volatile String AhJ;
  private String AhM;
  private String AhN;
  private String AhO;
  private String AhP;
  private String AhQ;
  private c AhV;
  private int Aiw;
  private int ArA;
  private float Ary;
  private int Arz;
  private int BAA;
  private int BAB;
  private final Set<Integer> BAC;
  private final Set<Integer> BAD;
  private boolean BAE;
  private TextView BAF;
  private a BAG;
  private com.tencent.mm.plugin.webview.j.h BAH;
  private String BAI;
  GestureGalleryUI.a.a BAJ;
  private boolean BAK;
  private RelativeLayout BAL;
  private RelativeLayout BAM;
  private PressAlphaImageView BAN;
  RedesignVideoPlayerSeekBar BAO;
  private long BAP;
  private c BAQ;
  boolean BAR;
  private c<cd> BAS;
  private List<String> BAT;
  private List<AppBrandMediaSource> BAU;
  private int BAV;
  private int BAW;
  private String BAX;
  private boolean BAY;
  private AdapterView.OnItemSelectedListener BAZ;
  private a BAn;
  MMGestureGallery BAo;
  private int BAp;
  private String BAq;
  private ac BAr;
  private boolean BAs;
  private boolean BAt;
  private boolean BAu;
  private boolean BAv;
  private JSONArray BAw;
  private com.tencent.mm.ui.widget.a.e BAx;
  private volatile boolean BAy;
  private int BAz;
  private View BBa;
  private b BBb;
  private boolean hGJ;
  private String hIA;
  private String hIp;
  private boolean isAnimated;
  private ScanCodeSheetItemLogic lAg;
  private String lmo;
  private aq mHandler;
  private ImageView oML;
  private Bundle oMP;
  private com.tencent.mm.ui.tools.e oMQ;
  private int oMR;
  private int oMS;
  private int oMT;
  private int oMU;
  private long oym;
  private boolean rEX;
  private c rFa;
  private int type;
  
  public GestureGalleryUI()
  {
    AppMethodBeat.i(29091);
    this.BAs = false;
    this.BAt = false;
    this.hIp = "";
    this.hIA = null;
    this.BAu = false;
    this.BAv = true;
    this.BAw = null;
    this.Aiw = 0;
    this.BAC = new HashSet();
    this.BAD = new HashSet();
    this.BAE = false;
    this.isAnimated = false;
    this.oMR = 0;
    this.oMS = 0;
    this.oMT = 0;
    this.oMU = 0;
    this.mHandler = new aq();
    this.BAI = "";
    this.hGJ = false;
    this.BAK = false;
    this.oym = 0L;
    this.BAP = 0L;
    this.BAQ = c.BBq;
    this.BAR = false;
    this.BAS = new GestureGalleryUI.10(this);
    this.BAT = new ArrayList();
    this.BAU = new ArrayList();
    this.type = 0;
    this.BAV = -1;
    this.BAW = -1;
    this.lmo = null;
    this.BAX = null;
    this.Ary = 1.0F;
    this.Arz = 0;
    this.ArA = 0;
    this.BAY = false;
    this.BAZ = new AdapterView.OnItemSelectedListener()
    {
      VideoView BBf;
      
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(186647);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$16", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        GestureGalleryUI.f(GestureGalleryUI.this, paramAnonymousInt);
        GestureGalleryUI.H(GestureGalleryUI.this).setText(GestureGalleryUI.c(GestureGalleryUI.this) + 1 + "/" + GestureGalleryUI.m(GestureGalleryUI.this).getCount());
        GestureGalleryUI.this.setMMTitle(GestureGalleryUI.c(GestureGalleryUI.this) + 1 + " / " + GestureGalleryUI.I(GestureGalleryUI.this).size());
        ae.d("MicroMsg.GestureGalleryUI", "pos:".concat(String.valueOf(paramAnonymousInt)));
        GestureGalleryUI.c(GestureGalleryUI.this, (String)GestureGalleryUI.I(GestureGalleryUI.this).get(paramAnonymousInt));
        GestureGalleryUI.d(GestureGalleryUI.this, "");
        GestureGalleryUI.b(GestureGalleryUI.this, false);
        if (this.BBf != null)
        {
          this.BBf.stopPlayback();
          this.BBf = null;
        }
        GestureGalleryUI.J(GestureGalleryUI.this).setIsPlay(false);
        GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.c.BBq);
        if ((paramAnonymousView != null) && (paramAnonymousView.getTag() != null))
        {
          paramAnonymousAdapterView = (GestureGalleryUI.a.a)paramAnonymousView.getTag();
          if ((paramAnonymousAdapterView != null) && (GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousInt)))
          {
            this.BBf = paramAnonymousAdapterView.BBm;
            GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousAdapterView);
            paramAnonymousAdapterView.tPf.setVisibility(0);
            paramAnonymousAdapterView.AjY.setVisibility(0);
            paramAnonymousAdapterView.BBk.setVisibility(8);
            paramAnonymousAdapterView.BBn.setVisibility(8);
          }
        }
        else
        {
          if (!GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousInt)) {
            break label459;
          }
          GestureGalleryUI.d(GestureGalleryUI.this, GestureGalleryUI.D(GestureGalleryUI.this));
          GestureGalleryUI.g(GestureGalleryUI.this, paramAnonymousInt);
        }
        for (;;)
        {
          ae.i("MicroMsg.GestureGalleryUI", "curFilename:%s", new Object[] { GestureGalleryUI.j(GestureGalleryUI.this) });
          GestureGalleryUI.l(GestureGalleryUI.this);
          GestureGalleryUI.a(GestureGalleryUI.this, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$16", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(186647);
          return;
          if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.tPf == null)) {
            break;
          }
          paramAnonymousAdapterView.tPf.setVisibility(8);
          break;
          label459:
          GestureGalleryUI.d(GestureGalleryUI.this, GestureGalleryUI.M(GestureGalleryUI.this).c((String)GestureGalleryUI.I(GestureGalleryUI.this).get(paramAnonymousInt), GestureGalleryUI.K(GestureGalleryUI.this), paramAnonymousInt, GestureGalleryUI.L(GestureGalleryUI.this)));
          if (bu.isNullOrNil(GestureGalleryUI.j(GestureGalleryUI.this))) {
            GestureGalleryUI.d(GestureGalleryUI.this, (String)GestureGalleryUI.I(GestureGalleryUI.this).get(paramAnonymousInt));
          }
          GestureGalleryUI.g(GestureGalleryUI.this, paramAnonymousInt);
          if ((GestureGalleryUI.N(GestureGalleryUI.this) != null) && (GestureGalleryUI.O(GestureGalleryUI.this) != null) && (GestureGalleryUI.O(GestureGalleryUI.this).length() > GestureGalleryUI.P(GestureGalleryUI.this))) {
            if (GestureGalleryUI.O(GestureGalleryUI.this).optJSONObject(GestureGalleryUI.P(GestureGalleryUI.this)).has("jumpType")) {
              GestureGalleryUI.N(GestureGalleryUI.this).setVisibility(0);
            } else {
              GestureGalleryUI.N(GestureGalleryUI.this).setVisibility(8);
            }
          }
        }
      }
      
      public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    };
    this.rFa = new c() {};
    this.AhV = new c() {};
    AppMethodBeat.o(29091);
  }
  
  private boolean Tp(int paramInt)
  {
    AppMethodBeat.i(186667);
    if ((this.BAU != null) && (this.BAU.size() > paramInt) && (this.BAU.get(paramInt) != null) && ("video".endsWith(((AppBrandMediaSource)this.BAU.get(paramInt)).hnC)))
    {
      AppMethodBeat.o(186667);
      return true;
    }
    AppMethodBeat.o(186667);
    return false;
  }
  
  private void cyU()
  {
    AppMethodBeat.i(179724);
    ae.i("MicroMsg.GestureGalleryUI", "pauseVideo");
    if (this.BAJ != null)
    {
      this.BAP = (this.BAO.getmPosition() * 1000);
      ae.i("MicroMsg.GestureGalleryUI", "pauseVideo currentVideoPos：%d", new Object[] { Long.valueOf(this.BAP) });
      this.BAJ.BBm.pause();
      this.BAJ.AjY.setVisibility(0);
      if ((this.BAQ != c.BBs) && (this.BAQ != c.BBt)) {
        break label133;
      }
      this.BAQ = c.BBu;
      this.BAR = true;
    }
    for (;;)
    {
      this.BAO.setIsPlay(false);
      eqP();
      AppMethodBeat.o(179724);
      return;
      label133:
      c localc = c.BBu;
    }
  }
  
  private boolean eqM()
  {
    AppMethodBeat.i(169766);
    if ((this.BAy) && (!bu.isNullOrNil(this.AhM)))
    {
      AppMethodBeat.o(169766);
      return true;
    }
    AppMethodBeat.o(169766);
    return false;
  }
  
  private String eqN()
  {
    AppMethodBeat.i(179723);
    if ((this.BAV < 0) || (this.BAU == null) || (this.BAU.size() == 0))
    {
      AppMethodBeat.o(179723);
      return "";
    }
    String str = ((AppBrandMediaSource)this.BAU.get(this.BAV)).url;
    ae.i("MicroMsg.GestureGalleryUI", "playVideo  url :%s", new Object[] { str });
    if ((str != null) && (str.startsWith("http")))
    {
      Object localObject;
      if (com.tencent.mm.plugin.ab.a.BWn == null)
      {
        localObject = new File(com.tencent.mm.loader.j.b.ata());
        if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
          ((File)localObject).mkdir();
        }
        localObject = new HttpProxyCacheServer.Builder(this).maxCacheSize(134217728L).cacheDirectory((File)localObject).build();
        com.tencent.mm.plugin.ab.a.BWn = (HttpProxyCacheServer)localObject;
      }
      for (;;)
      {
        localObject = ((HttpProxyCacheServer)localObject).getProxyUrl(str);
        AppMethodBeat.o(179723);
        return localObject;
        localObject = com.tencent.mm.plugin.ab.a.BWn;
      }
    }
    AppMethodBeat.o(179723);
    return str;
  }
  
  private void eqO()
  {
    AppMethodBeat.i(179725);
    eqP();
    this.BBb = new b((byte)0);
    b localb = this.BBb;
    localb.isStop = false;
    com.tencent.mm.sdk.g.b.c(localb, "gesture_gallery_ui_video_update_progress");
    AppMethodBeat.o(179725);
  }
  
  private void eqP()
  {
    if (this.BBb != null) {
      this.BBb.isStop = true;
    }
  }
  
  private static void gC(Context paramContext)
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
  
  private void sJ(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(29102);
    if (this.BAx == null) {
      this.BAx = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
    }
    this.BAx.LfS = new n.d()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(29085);
        GestureGalleryUI.a(GestureGalleryUI.this).setFooterView(null);
        paramAnonymousl.clear();
        Object localObject;
        ce localce;
        if (!GestureGalleryUI.p(GestureGalleryUI.this))
        {
          paramAnonymousl.jM(1, 2131762163);
          if (GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.c(GestureGalleryUI.this)))
          {
            paramAnonymousl.jM(2, 2131762784);
            paramAnonymousl.jM(3, 2131761941);
          }
        }
        else if ((GestureGalleryUI.q(GestureGalleryUI.this)) && (!bu.isNullOrNil(GestureGalleryUI.j(GestureGalleryUI.this))))
        {
          paramAnonymousl.jM(4, 2131757184);
          localObject = GestureGalleryUI.e(GestureGalleryUI.this);
          localce = new ce();
          if (((a)localObject).rHg != 2) {
            break label244;
          }
          l = 1L;
          label132:
          localce.dWt = l;
          localce.dQB = 2L;
          if (!((a)localObject).BAj) {
            break label249;
          }
        }
        label244:
        label249:
        for (long l = 6L;; l = 5L)
        {
          localce.edv = l;
          localce.aLH();
          if (!GestureGalleryUI.r(GestureGalleryUI.this)) {
            break label266;
          }
          localObject = GestureGalleryUI.s(GestureGalleryUI.this);
          GestureGalleryUI.a(GestureGalleryUI.this).setFooterView((View)localObject);
          if (!(localObject instanceof ViewTitleWithAnimation)) {
            break label266;
          }
          if (paramAnonymousl.size() <= 1) {
            break label256;
          }
          ((ViewTitleWithAnimation)localObject).setTopPaddingVisibility(0);
          AppMethodBeat.o(29085);
          return;
          paramAnonymousl.jM(2, 2131762781);
          break;
          l = 0L;
          break label132;
        }
        label256:
        ((ViewTitleWithAnimation)localObject).setTopPaddingVisibility(8);
        label266:
        AppMethodBeat.o(29085);
      }
    };
    this.BAx.LfT = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        paramAnonymousInt = 6;
        AppMethodBeat.i(29066);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        Object localObject1;
        do
        {
          AppMethodBeat.o(29066);
          return;
          GestureGalleryUI.t(GestureGalleryUI.this);
          AppMethodBeat.o(29066);
          return;
          GestureGalleryUI.u(GestureGalleryUI.this);
          AppMethodBeat.o(29066);
          return;
          GestureGalleryUI.v(GestureGalleryUI.this);
          AppMethodBeat.o(29066);
          return;
          GestureGalleryUI.d(GestureGalleryUI.this, 6);
          paramAnonymousMenuItem = GestureGalleryUI.e(GestureGalleryUI.this);
          localObject1 = paramAnonymousMenuItem.BAi.cxR();
        } while (((paramAnonymousMenuItem.rHg != 0) && (paramAnonymousMenuItem.rHg != 2)) || (bu.isNullOrNil((String)localObject1)));
        Object localObject2 = new ce();
        long l;
        if (paramAnonymousMenuItem.rHg == 2)
        {
          l = 1L;
          ((ce)localObject2).dWt = l;
          ((ce)localObject2).dQB = 3L;
          if (!paramAnonymousMenuItem.BAj) {
            break label402;
          }
          l = 6L;
          label188:
          ((ce)localObject2).edv = l;
          ((ce)localObject2).aLH();
          paramAnonymousMenuItem.rHf = ((int)(v.aAC().hashCode() + System.currentTimeMillis()));
          localObject2 = ((com.tencent.mm.plugin.scanner.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.scanner.e.class)).getTranslationResult((String)localObject1);
          if ((localObject2 == null) || (!o.fB(((fp)localObject2).field_resultFile))) {
            break label414;
          }
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("original_file_path", (String)localObject1);
          if (!paramAnonymousMenuItem.BAj) {
            break label409;
          }
        }
        label402:
        label409:
        for (paramAnonymousInt = 6;; paramAnonymousInt = 5)
        {
          ((Intent)localObject2).putExtra("translate_source", paramAnonymousInt);
          ((Intent)localObject2).setClass(paramAnonymousMenuItem.activity, TranslationResultUI.class);
          localObject1 = paramAnonymousMenuItem.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.activity.finish();
          paramAnonymousMenuItem.activity.overridePendingTransition(2130771986, 2130771986);
          AppMethodBeat.o(29066);
          return;
          l = 0L;
          break;
          l = 5L;
          break label188;
        }
        label414:
        label459:
        sq.a locala;
        if ((com.tencent.mm.kernel.g.ajj().aFd() != 6) && (com.tencent.mm.kernel.g.ajj().aFd() != 4))
        {
          com.tencent.mm.ui.base.h.c(paramAnonymousMenuItem.activity, paramAnonymousMenuItem.activity.getString(2131755828), "", true);
          paramAnonymousMenuItem.cyd();
          ae.i("MicroMsg.GestureGalleryTransLogic", "try to translate img %s, sessionId %d", new Object[] { localObject1, Integer.valueOf(paramAnonymousMenuItem.rHf) });
          localObject2 = new sq();
          locala = ((sq)localObject2).dIl;
          if (!paramAnonymousMenuItem.BAj) {
            break label603;
          }
        }
        for (;;)
        {
          locala.scene = paramAnonymousInt;
          ((sq)localObject2).dIl.filePath = ((String)localObject1);
          ((sq)localObject2).dIl.dmM = paramAnonymousMenuItem.rHf;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
          break;
          paramAnonymousMenuItem.rHg = 1;
          paramAnonymousMenuItem.rHi.setVisibility(0);
          paramAnonymousMenuItem.rHj.setVisibility(0);
          paramAnonymousMenuItem.rHk.setVisibility(0);
          paramAnonymousMenuItem.rHl.setRepeatMode(1);
          paramAnonymousMenuItem.rHl.setRepeatCount(-1);
          paramAnonymousMenuItem.rHl.start();
          break label459;
          label603:
          paramAnonymousInt = 5;
        }
      }
    };
    this.BAx.KtV = new e.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(29067);
        GestureGalleryUI.d(GestureGalleryUI.this, 5);
        GestureGalleryUI.w(GestureGalleryUI.this);
        GestureGalleryUI.x(GestureGalleryUI.this);
        GestureGalleryUI.y(GestureGalleryUI.this);
        GestureGalleryUI.z(GestureGalleryUI.this);
        GestureGalleryUI.b(GestureGalleryUI.this, null);
        GestureGalleryUI.e(GestureGalleryUI.this, 0);
        GestureGalleryUI.A(GestureGalleryUI.this);
        GestureGalleryUI.B(GestureGalleryUI.this);
        GestureGalleryUI.C(GestureGalleryUI.this).onDismiss();
        AppMethodBeat.o(29067);
      }
    };
    if (!getContext().isFinishing()) {
      if ((!this.hGJ) || (eqM()) || (this.rEX)) {
        break label273;
      }
    }
    Object localObject;
    String str;
    for (;;)
    {
      if (i != 0) {
        this.BAx.cPF();
      }
      if ((this.BAy) && (bu.isNullOrNil(this.AhM)) && (bc.ajj().aFd() != 0))
      {
        localObject = new qd();
        ((qd)localObject).dFH.dmK = System.currentTimeMillis();
        ((qd)localObject).dFH.filePath = this.BAq;
        ((qd)localObject).dFH.dFI = new HashSet(this.BAC);
        this.AhJ = this.BAq;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      }
      if (bu.isNullOrNil(this.BAq)) {
        break label315;
      }
      com.tencent.mm.kernel.g.ajS();
      if ((com.tencent.mm.kernel.g.ajQ().gDv.aFd() == 0) || (!paramBoolean)) {
        break label315;
      }
      localObject = this.BAG;
      str = this.BAq;
      if ((((a)localObject).activity != null) && (!((a)localObject).activity.isFinishing())) {
        break;
      }
      AppMethodBeat.o(29102);
      return;
      label273:
      i = 1;
    }
    if (((a)localObject).rHe == null) {
      ((a)localObject).rHe = new ImageWordScanDetailEngine(((a)localObject).activity);
    }
    ((a)localObject).rHe.a(str, ((a)localObject).rHd);
    label315:
    AppMethodBeat.o(29102);
  }
  
  private void tW(int paramInt)
  {
    AppMethodBeat.i(186666);
    if ((this.BAH == null) || (bu.isNullOrNil(this.BAX)))
    {
      AppMethodBeat.o(186666);
      return;
    }
    this.BAH.url = this.BAX;
    this.BAH.dPU = this.BAB;
    if (!bu.isNullOrNil(this.AhM))
    {
      this.BAH.ELK = true;
      this.BAH.YC(this.BAz);
      this.BAH.scanResult = this.AhM;
    }
    String str = com.tencent.mm.pluginsdk.ui.tools.x.aPc(this.BAI);
    this.BAH.vKk = str;
    this.BAH.md(paramInt);
    AppMethodBeat.o(186666);
  }
  
  public final void bYa()
  {
    AppMethodBeat.i(29100);
    if ((this.BAo.getSelectedItemPosition() != this.BAW) || (!this.BAE))
    {
      finish();
      overridePendingTransition(0, 0);
      AppMethodBeat.o(29100);
      return;
    }
    if ((this.BAY) || (this.BAn == null))
    {
      ae.i("MicroMsg.GestureGalleryUI", "isRunningExitAnimation");
      AppMethodBeat.o(29100);
      return;
    }
    ae.i("MicroMsg.GestureGalleryUI", "runExitAnimation");
    int k = this.BAo.getWidth();
    int i = this.BAo.getHeight();
    int j = this.BAo.getSelectedItemPosition();
    Object localObject = (String)this.BAT.get(j);
    if (o.fB((String)localObject))
    {
      if (bu.isNullOrNil((String)localObject)) {
        break label412;
      }
      localObject = com.tencent.mm.sdk.platformtools.h.aRz((String)localObject);
      float f = k / ((BitmapFactory.Options)localObject).outWidth;
      j = (int)(((BitmapFactory.Options)localObject).outHeight * f);
      i = j;
      if (j > this.BAo.getHeight())
      {
        if (j < this.BAo.getHeight() * 2.5D) {
          this.oMU = (this.BAo.getHeight() * this.oMU / j);
        }
        i = this.BAo.getHeight();
      }
    }
    label412:
    for (;;)
    {
      this.oMQ.kg(k, i);
      this.oMQ.R(this.oMS, this.oMR, this.oMT, this.oMU);
      if (this.Ary != 1.0D)
      {
        this.oMQ.LeF = (1.0F / this.Ary);
        if ((this.Arz != 0) || (this.ArA != 0))
        {
          j = (int)(this.BAo.getWidth() / 2 * (1.0F - this.Ary));
          k = this.Arz;
          i = (int)(this.BAo.getHeight() / 2 + this.ArA - i / 2 * this.Ary);
          this.oMQ.ki(j + k, i);
        }
      }
      this.oMQ.a(this.BAo, this.oML, new e.c()
      {
        public final void onAnimationEnd()
        {
          AppMethodBeat.i(29082);
          GestureGalleryUI.n(GestureGalleryUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29080);
              GestureGalleryUI.this.finish();
              GestureGalleryUI.this.overridePendingTransition(0, 0);
              AppMethodBeat.o(29080);
            }
          });
          GestureGalleryUI.d(GestureGalleryUI.this, false);
          AppMethodBeat.o(29082);
        }
        
        public final void onAnimationStart()
        {
          AppMethodBeat.i(29081);
          GestureGalleryUI.d(GestureGalleryUI.this, true);
          GestureGalleryUI.n(GestureGalleryUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29079);
              View localView = GestureGalleryUI.m(GestureGalleryUI.this).eqQ();
              if ((localView instanceof MultiTouchImageView)) {
                ((MultiTouchImageView)localView).fCA();
              }
              AppMethodBeat.o(29079);
            }
          }, 20L);
          AppMethodBeat.o(29081);
        }
      }, null);
      AppMethodBeat.o(29100);
      return;
      localObject = this.BAr.c((String)localObject, this.type, j, this.hIA);
      break;
    }
  }
  
  public final String cxR()
  {
    return this.BAq;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29101);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ae.d("MicroMsg.GestureGalleryUI", "dispatchKeyEvent");
      bYa();
      AppMethodBeat.o(29101);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(29101);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2131495190;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29098);
    String str1 = bu.nullAsNil(getIntent().getStringExtra("nowUrl"));
    this.lmo = bu.nullAsNil(getIntent().getStringExtra("nowUrlPath"));
    this.BAX = bu.nullAsNil(getIntent().getStringExtra("nowWebUrl"));
    this.type = getIntent().getIntExtra("type", 0);
    Object localObject = getIntent().getParcelableArrayListExtra("mediaSource");
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.BAU.clear();
      this.BAU.addAll((Collection)localObject);
    }
    localObject = getIntent().getStringArrayExtra("urlList");
    final int i;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = bu.nullAsNil(getIntent().getStringExtra("htmlData"));
      i = 0;
    }
    while (i >= 0)
    {
      int j = ((String)localObject).indexOf("weixin://viewimage/", i);
      if (j >= 0)
      {
        i = ((String)localObject).indexOf("\"", j);
        if (i >= 0)
        {
          String str2 = ((String)localObject).substring(j + 19, i);
          ae.d("MicroMsg.GestureGalleryUI", "start:" + j + " end:" + i + " url:" + str2);
          this.BAT.add(str2);
          continue;
          this.BAT = Arrays.asList((Object[])localObject);
        }
      }
    }
    localObject = getIntent().getStringExtra("pageInfos");
    if (!bu.isNullOrNil((String)localObject)) {}
    try
    {
      this.BAw = new JSONArray((String)localObject);
      label302:
      i = 0;
      for (;;)
      {
        if (i < this.BAT.size())
        {
          if (str1.equals(this.BAT.get(i))) {
            this.BAV = i;
          }
        }
        else
        {
          this.BAW = this.BAV;
          if (getIntent().getIntExtra("currentPos", -1) >= 0) {
            this.BAW = getIntent().getIntExtra("currentPos", -1);
          }
          setBackBtn(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(29074);
              GestureGalleryUI.this.bYa();
              AppMethodBeat.o(29074);
              return true;
            }
          });
          this.BAF = ((TextView)findViewById(2131303133));
          this.oML = ((ImageView)findViewById(2131300336));
          this.BAM = ((RelativeLayout)findViewById(2131306407));
          this.BAO = ((RedesignVideoPlayerSeekBar)findViewById(2131306375));
          this.BAN = ((PressAlphaImageView)findViewById(2131306316));
          this.BAN.setOnClickListener(new GestureGalleryUI.15(this));
          this.BAO.setPlayBtnOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(186655);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              if (GestureGalleryUI.J(GestureGalleryUI.this).cgS()) {
                GestureGalleryUI.Y(GestureGalleryUI.this);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(186655);
                return;
                GestureGalleryUI.Z(GestureGalleryUI.this);
              }
            }
          });
          this.BAO.setVideoTotalTime(0);
          this.BAO.seek(0);
          this.BAO.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
          {
            public final void aqS() {}
            
            public final void nP(int paramAnonymousInt)
            {
              AppMethodBeat.i(186656);
              if (GestureGalleryUI.aa(GestureGalleryUI.this) != null) {
                GestureGalleryUI.aa(GestureGalleryUI.this).BBm.seekTo(paramAnonymousInt * 1000);
              }
              AppMethodBeat.o(186656);
            }
          });
          this.BAn = new a();
          this.BAo = ((MMGestureGallery)findViewById(2131300335));
          this.BAo.setVisibility(0);
          this.BAo.setVerticalFadingEdgeEnabled(false);
          this.BAo.setHorizontalFadingEdgeEnabled(false);
          this.BAo.setAdapter(this.BAn);
          this.BAo.setSelection(this.BAV);
          this.BAo.setOnItemSelectedListener(this.BAZ);
          this.BAo.setSingleClickOverListener(new MMGestureGallery.f()
          {
            public final void aRO()
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
                if (GestureGalleryUI.e(GestureGalleryUI.this).rHg != 1) {
                  GestureGalleryUI.this.bYa();
                }
                AppMethodBeat.o(29075);
                return;
              }
            }
          });
          i = getIntent().getIntExtra("nevNext", 1);
          this.BAo.setLongClickOverListener(new MMGestureGallery.c()
          {
            public final void aRP()
            {
              boolean bool2 = true;
              AppMethodBeat.i(29077);
              if (GestureGalleryUI.e(GestureGalleryUI.this).rHg == 1)
              {
                AppMethodBeat.o(29077);
                return;
              }
              if ((GestureGalleryUI.f(GestureGalleryUI.this)) && (!GestureGalleryUI.g(GestureGalleryUI.this)))
              {
                ae.e("MicroMsg.GestureGalleryUI", "is from appbrand, but showmenu is false, don't show menu");
                AppMethodBeat.o(29077);
                return;
              }
              GestureGalleryUI.a(GestureGalleryUI.this, new com.tencent.mm.plugin.webview.j.h());
              GestureGalleryUI.h(GestureGalleryUI.this).reset(2);
              Object localObject1;
              if (1 == i)
              {
                localObject1 = z.aBG().F("basescanui@datacenter", true);
                ((z.b)localObject1).k("key_basescanui_screen_x", Integer.valueOf(GestureGalleryUI.i(GestureGalleryUI.this).getXDown()));
                ((z.b)localObject1).k("key_basescanui_screen_y", Integer.valueOf(GestureGalleryUI.i(GestureGalleryUI.this).getYDown()));
                if ((GestureGalleryUI.e(GestureGalleryUI.this).rHg == 0) || (GestureGalleryUI.e(GestureGalleryUI.this).rHg == 2))
                {
                  localObject1 = GestureGalleryUI.e(GestureGalleryUI.this);
                  Object localObject2 = new ce();
                  long l;
                  label233:
                  boolean bool1;
                  if (((a)localObject1).rHg == 2)
                  {
                    l = 1L;
                    ((ce)localObject2).dWt = l;
                    ((ce)localObject2).dQB = 1L;
                    if (!((a)localObject1).BAj) {
                      break label392;
                    }
                    l = 6L;
                    ((ce)localObject2).edv = l;
                    ((ce)localObject2).aLH();
                    localObject1 = GestureGalleryUI.this;
                    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("EnableWebviewPicTranslation", 0);
                    localObject2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("PicTranslationSupportUserLanguage");
                    if (i != 1) {
                      break label400;
                    }
                    bool1 = true;
                    label299:
                    ae.i("MicroMsg.ScannerHelper", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool1), localObject2, ad.fom() });
                    if ((i != 1) || (bu.isNullOrNil((String)localObject2))) {
                      break label405;
                    }
                    localObject2 = ((String)localObject2).split(";");
                    if ((localObject2 == null) || (!Arrays.asList((Object[])localObject2).contains(ad.fom()))) {
                      break label405;
                    }
                    bool1 = bool2;
                  }
                  for (;;)
                  {
                    GestureGalleryUI.c((GestureGalleryUI)localObject1, bool1);
                    AppMethodBeat.o(29077);
                    return;
                    l = 0L;
                    break;
                    label392:
                    l = 5L;
                    break label233;
                    label400:
                    bool1 = false;
                    break label299;
                    label405:
                    bool1 = bool2;
                    if (!com.tencent.mm.protocal.d.FFL) {
                      bool1 = false;
                    }
                  }
                }
                GestureGalleryUI.b(GestureGalleryUI.this);
                AppMethodBeat.o(29077);
                return;
              }
              if (2 == i)
              {
                localObject1 = GestureGalleryUI.this.getContext().getResources().getStringArray(2130903084);
                com.tencent.mm.ui.base.h.b(GestureGalleryUI.this, null, (String[])localObject1, "", new h.c()
                {
                  public final void lh(int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(29076);
                    switch (paramAnonymous2Int)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(29076);
                      return;
                      GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.j(GestureGalleryUI.this));
                      AppMethodBeat.o(29076);
                      return;
                      GestureGalleryUI localGestureGalleryUI = GestureGalleryUI.this;
                      String str = GestureGalleryUI.j(GestureGalleryUI.this);
                      if ((str == null) || (str.length() == 0))
                      {
                        AppMethodBeat.o(29076);
                        return;
                      }
                      Intent localIntent = new Intent();
                      localIntent.putExtra("Retr_File_Name", str);
                      localIntent.putExtra("Retr_Msg_Type", 0);
                      localIntent.putExtra("Retr_Compress_Type", 0);
                      com.tencent.mm.plugin.subapp.b.iUz.k(localIntent, localGestureGalleryUI.getContext());
                    }
                  }
                });
              }
              AppMethodBeat.o(29077);
            }
          });
          this.oMQ = new com.tencent.mm.ui.tools.e(this);
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
  
  public final void j(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(29092);
    if (this.BAn != null)
    {
      if (paramInt == this.BAo.getSelectedItemPosition())
      {
        this.BAq = paramString2;
        this.BAp = paramInt;
        ae.d("MicroMsg.GestureGalleryUI", "onDownSucc, curFilename:%s, url:%s", new Object[] { this.BAq, paramString1 });
      }
      this.BAn.notifyDataSetChanged();
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
      final Runnable local25;
      label82:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        local25 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186663);
            this.rDo.dismiss();
            AppMethodBeat.o(186663);
          }
        };
        if (!bu.isNullOrNil((String)localObject)) {
          break label93;
        }
        AppMethodBeat.o(179726);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label93:
      Iterator localIterator = bu.U(((String)localObject).split(",")).iterator();
      while (localIterator.hasNext())
      {
        final String str2 = (String)localIterator.next();
        String str1 = ((AppBrandMediaSource)this.BAU.get(this.BAV)).hnD;
        localObject = str1;
        if (!o.fB(str1)) {
          localObject = this.BAr.c(str1, this.type, this.BAV, this.hIA);
        }
        ae.i("MicroMsg.GestureGalleryUI", "onActivityResult,  sendVideo video:%s,  thumbFilename:%s", new Object[] { eqN(), localObject });
        com.tencent.mm.kernel.g.ajU().aw(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186664);
            com.tencent.mm.plugin.messenger.a.g.doC().a(GestureGalleryUI.this.getContext(), str2, GestureGalleryUI.D(GestureGalleryUI.this), this.BBg, 1, (int)GestureGalleryUI.ab(GestureGalleryUI.this), "", "");
            ar.f(local25);
            AppMethodBeat.o(186664);
          }
          
          public final String toString()
          {
            AppMethodBeat.i(186665);
            String str = super.toString() + "send video";
            AppMethodBeat.o(186665);
            return str;
          }
        });
        if (!bu.isNullOrNil(paramIntent)) {
          com.tencent.mm.plugin.messenger.a.g.doC().aa(str2, paramIntent, com.tencent.mm.model.x.Bb(str2));
        }
      }
      com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131759420));
      AppMethodBeat.o(179726);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(179726);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29093);
    super.onCreate(paramBundle);
    this.oMP = paramBundle;
    this.BAS.alive();
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setFlags(1024, 1024);
      getWindow().addFlags(67108864);
    }
    fullScreenNoTitleBar(true);
    this.BAu = getIntent().getBooleanExtra("isFromAppBrand", false);
    this.hGJ = getIntent().getBooleanExtra("forBidForward", false);
    this.BAs = getIntent().getBooleanExtra("isFromWebView", false);
    this.BAv = getIntent().getBooleanExtra("showmenu", true);
    this.BAt = getIntent().getBooleanExtra("isOuntLink", false);
    this.hIp = getIntent().getStringExtra("IsFromWebViewReffer");
    this.BAy = getIntent().getBooleanExtra("shouldShowScanQrCodeMenu", false);
    this.BAE = getIntent().getBooleanExtra("shouldRunDragAnimation", false);
    this.BAB = getIntent().getIntExtra("scanQrCodeGetA8KeyScene", 0);
    paramBundle = getIntent().getIntArrayExtra("scanCodeTypes");
    int i;
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      i = 0;
      while (i < paramBundle.length)
      {
        this.BAC.add(Integer.valueOf(paramBundle[i]));
        i += 1;
      }
    }
    paramBundle = getIntent().getIntArrayExtra("scanResultCodeTypes");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      i = 0;
      while (i < paramBundle.length)
      {
        this.BAD.add(Integer.valueOf(paramBundle[i]));
        i += 1;
      }
    }
    this.BAG = new a(this, this, this, this.BAt);
    this.hIA = getIntent().getStringExtra("cookie");
    ae.d("MicroMsg.GestureGalleryUI", "isFromWebView: %b, isFromWebViewReffer:%s, cookie = %s, forbidForward=%b", new Object[] { Boolean.valueOf(this.BAs), this.hIp, this.hIA, Boolean.valueOf(this.hGJ) });
    this.BAr = new ac(this.BAs, this.hIp);
    paramBundle = this.BAr;
    ae.d("MicroMsg.GetPicService", "addListener :" + hashCode());
    paramBundle.hIr = this;
    com.tencent.mm.sdk.b.a.IvT.c(this.rFa);
    com.tencent.mm.sdk.b.a.IvT.c(this.AhV);
    initView();
    this.BAY = false;
    if (this.BAu) {
      getWindow().setBackgroundDrawableResource(2131231318);
    }
    this.lAg = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a()
    {
      public final void bpT()
      {
        AppMethodBeat.i(29065);
        if ((GestureGalleryUI.a(GestureGalleryUI.this) != null) && (GestureGalleryUI.a(GestureGalleryUI.this).isShowing())) {
          GestureGalleryUI.b(GestureGalleryUI.this);
        }
        AppMethodBeat.o(29065);
      }
    });
    this.BAL = ((RelativeLayout)findViewById(2131308329));
    if (this.BAw != null)
    {
      this.BBa = findViewById(2131308432);
      this.BAL.setVisibility(0);
      ((TextView)findViewById(2131308379)).setTextSize(1, 12.0F);
      this.BBa.setOnClickListener(new GestureGalleryUI.12(this));
      findViewById(2131308330).setOnClickListener(new GestureGalleryUI.13(this));
      findViewById(2131299194).setOnClickListener(new GestureGalleryUI.14(this));
      AppMethodBeat.o(29093);
      return;
    }
    this.BAL.setVisibility(8);
    AppMethodBeat.o(29093);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29094);
    super.onDestroy();
    Object localObject = this.BAr;
    ae.d("MicroMsg.GetPicService", "removeListener :" + hashCode());
    ((ac)localObject).hIr = null;
    localObject = this.BAr;
    if (((ac)localObject).hIn != null) {
      ((ac)localObject).hIn.hIv = true;
    }
    ((ac)localObject).hIn = null;
    com.tencent.mm.sdk.b.a.IvT.d(this.rFa);
    com.tencent.mm.sdk.b.a.IvT.d(this.AhV);
    this.BAS.dead();
    gC(this);
    if (this.BAG != null)
    {
      localObject = this.BAG;
      ((a)localObject).cyf();
      ((a)localObject).rHl.removeAllUpdateListeners();
      ((a)localObject).rHm.dead();
      com.tencent.mm.kernel.g.ajQ().b(((a)localObject).rHn);
      ((a)localObject).rHd = null;
      ((a)localObject).activity = null;
      ((a)localObject).BAi = null;
    }
    localObject = new qr();
    ((qr)localObject).dGr.activity = this;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    ae.i("MicroMsg.GestureGalleryUI", "stopVideo");
    if (this.BAJ != null)
    {
      this.BAJ.BBm.stopPlayback();
      this.BAQ = c.BBw;
      this.BAO.setIsPlay(false);
      this.BAO.setIplaySeekCallback(null);
      this.BAJ.AjY.setVisibility(0);
      this.BAJ.tpC.setVisibility(0);
      this.BAJ.BBm.setVisibility(8);
    }
    eqP();
    AppMethodBeat.o(29094);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29095);
    super.onPause();
    cyU();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(2048, 2048);
    }
    f.e(false, true, true);
    AppMethodBeat.o(29095);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29096);
    super.onResume();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().clearFlags(2048);
    }
    f.e(true, true, true);
    AppMethodBeat.o(29096);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(29099);
    Bundle localBundle = this.oMP;
    if ((this.isAnimated) || (!this.BAE)) {}
    for (;;)
    {
      super.onStart();
      AppMethodBeat.o(29099);
      return;
      this.isAnimated = true;
      this.oMR = getIntent().getIntExtra("img_gallery_top", 0);
      this.oMS = getIntent().getIntExtra("img_gallery_left", 0);
      this.oMT = getIntent().getIntExtra("img_gallery_width", 0);
      this.oMU = getIntent().getIntExtra("img_gallery_height", 0);
      this.oMQ.R(this.oMS, this.oMR, this.oMT, this.oMU);
      if (localBundle == null) {
        this.BAo.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(29078);
            GestureGalleryUI.i(GestureGalleryUI.this).getViewTreeObserver().removeOnPreDrawListener(this);
            GestureGalleryUI.k(GestureGalleryUI.this).a(GestureGalleryUI.i(GestureGalleryUI.this), null, null);
            GestureGalleryUI.l(GestureGalleryUI.this);
            AppMethodBeat.o(29078);
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
    if (this.AhM != null)
    {
      au localau = new au();
      localau.dmH.activity = this;
      localau.dmH.dmI = this.AhM;
      com.tencent.mm.sdk.b.a.IvT.l(localau);
      this.AhM = null;
      this.BAA = 0;
      this.BAz = 0;
    }
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
    
    private View Tq(int paramInt)
    {
      AppMethodBeat.i(29089);
      int i = GestureGalleryUI.i(GestureGalleryUI.this).getFirstVisiblePosition();
      int j = GestureGalleryUI.i(GestureGalleryUI.this).getChildCount();
      if ((paramInt < i) || (paramInt > j + i - 1))
      {
        localView = GestureGalleryUI.i(GestureGalleryUI.this).getAdapter().getView(paramInt, null, GestureGalleryUI.i(GestureGalleryUI.this));
        AppMethodBeat.o(29089);
        return localView;
      }
      View localView = GestureGalleryUI.i(GestureGalleryUI.this).getChildAt(paramInt - i);
      AppMethodBeat.o(29089);
      return localView;
    }
    
    public final View eqQ()
    {
      AppMethodBeat.i(29088);
      View localView = Tq(GestureGalleryUI.this.BAo.getSelectedItemPosition());
      AppMethodBeat.o(29088);
      return localView;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(29086);
      ae.d("MicroMsg.GestureGalleryUI", "lstpicurl:" + GestureGalleryUI.I(GestureGalleryUI.this).size());
      int i = GestureGalleryUI.I(GestureGalleryUI.this).size();
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
      if ((GestureGalleryUI.Q(GestureGalleryUI.this) != null) && (!GestureGalleryUI.Q(GestureGalleryUI.this).isEmpty()) && (GestureGalleryUI.Q(GestureGalleryUI.this).size() > paramInt)) {}
      for (Object localObject2 = (AppBrandMediaSource)GestureGalleryUI.Q(GestureGalleryUI.this).get(paramInt);; localObject2 = null)
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
        if ((paramView == null) || ((i != 0) && (paramViewGroup != null) && (paramViewGroup.BBm == null)))
        {
          localObject1 = new a();
          localView = View.inflate(GestureGalleryUI.this, 2131495191, null);
          ((a)localObject1).BBk = ((ProgressBar)localView.findViewById(2131303535));
          ((a)localObject1).BBl = ((MMAnimateView)localView.findViewById(2131300914));
          ((a)localObject1).tpC = ((ImageView)localView.findViewById(2131305793));
          ((a)localObject1).tPf = localView.findViewById(2131306319);
          ((a)localObject1).BBm = ((VideoView)localView.findViewById(2131306410));
          ((a)localObject1).AjY = ((ImageView)localView.findViewById(2131306413));
          ((a)localObject1).BBn = localView.findViewById(2131306339);
          ((a)localObject1).BBo = ((TextView)localView.findViewById(2131306340));
          if (i != 0)
          {
            ((a)localObject1).tpC.setVisibility(8);
            ((a)localObject1).tpC = ((ImageView)localView.findViewById(2131306347));
          }
          localView.setTag(localObject1);
        }
        for (;;)
        {
          localView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
          paramView = (String)GestureGalleryUI.I(GestureGalleryUI.this).get(paramInt);
          int k = 0;
          j = i;
          if (i != 0)
          {
            paramView = ((AppBrandMediaSource)localObject2).hnD;
            j = 1;
          }
          paramViewGroup = paramView;
          if (!o.fB(paramView))
          {
            paramView = GestureGalleryUI.M(GestureGalleryUI.this).c(paramView, GestureGalleryUI.K(GestureGalleryUI.this), paramInt, GestureGalleryUI.L(GestureGalleryUI.this));
            paramViewGroup = paramView;
            if (paramInt == GestureGalleryUI.R(GestureGalleryUI.this))
            {
              paramViewGroup = paramView;
              if (bu.isNullOrNil(paramView))
              {
                paramViewGroup = paramView;
                if (o.fB(GestureGalleryUI.S(GestureGalleryUI.this))) {
                  paramViewGroup = GestureGalleryUI.S(GestureGalleryUI.this);
                }
              }
            }
          }
          for (i = 1;; i = k)
          {
            ((a)localObject1).BBm.setVisibility(8);
            ((a)localObject1).BBm.stopPlayback();
            if (j != 0)
            {
              ((a)localObject1).tPf.setVisibility(0);
              GestureGalleryUI.b(GestureGalleryUI.this, (a)localObject1);
              if (bu.isNullOrNil(paramViewGroup)) {
                break label1368;
              }
              ((a)localObject1).BBk.setVisibility(8);
              if ((GestureGalleryUI.Q(GestureGalleryUI.this) != null) && (!GestureGalleryUI.Q(GestureGalleryUI.this).isEmpty())) {
                TextUtils.isEmpty(((AppBrandMediaSource)GestureGalleryUI.Q(GestureGalleryUI.this).get(paramInt)).hnD);
              }
              if (paramViewGroup != null) {
                break label600;
              }
              paramView = null;
            }
            for (;;)
            {
              if ((!GestureGalleryUI.T(GestureGalleryUI.this)) || ((paramView != null) && (!paramView.isRecycled()))) {
                break label830;
              }
              GestureGalleryUI.this.finish();
              AppMethodBeat.o(29090);
              return localView;
              ((a)localObject1).tPf.setVisibility(8);
              break;
              label600:
              localObject2 = com.tencent.mm.av.a.a.aJh().Gf(paramViewGroup + "_" + o.aZR(paramViewGroup));
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
                  ae.i("MicroMsg.GestureGalleryUI", "recycle bitmap:%s", new Object[] { paramView.toString() });
                  paramView.recycle();
                }
                localObject2 = com.tencent.mm.sdk.platformtools.h.aRC(paramViewGroup);
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
                        break label787;
                      }
                    }
                  }
                }
                label787:
                for (boolean bool = true;; bool = false)
                {
                  ae.i("MicroMsg.GestureGalleryUI", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(bool) });
                  if (paramView != null) {
                    break label793;
                  }
                  ae.e("MicroMsg.GestureGalleryUI", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramViewGroup)));
                  paramView = null;
                  break;
                }
                label793:
                com.tencent.mm.av.a.a.aJh().h(paramViewGroup + "_" + o.aZR(paramViewGroup), paramView);
              }
            }
            label830:
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
                k = al.ck(GestureGalleryUI.this.getContext()).x;
                m = al.ck(GestureGalleryUI.this.getContext()).y;
                long l = paramView.getWidth() * paramView.getHeight();
                if ((GestureGalleryUI.f(GestureGalleryUI.this)) && (!paramView.isRecycled()) && (l < k * m))
                {
                  k = 1;
                  if (k == 0) {
                    break label1111;
                  }
                }
              }
            }
            else
            {
              if (!u.aRG(paramViewGroup)) {
                break label1111;
              }
              if (paramInt == GestureGalleryUI.R(GestureGalleryUI.this)) {
                GestureGalleryUI.U(GestureGalleryUI.this);
              }
            }
            label1353:
            for (;;)
            {
              try
              {
                ((a)localObject1).BBl.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((a)localObject1).tpC.setVisibility(8);
                ((a)localObject1).BBl.setVisibility(0);
                localObject2 = ((a)localObject1).BBl;
                ((MMAnimateView)localObject2).uLv = GestureGalleryUI.f(GestureGalleryUI.this);
                ((MMAnimateView)localObject2).ho(paramViewGroup, null);
                AppMethodBeat.o(29090);
                return localView;
                k = 0;
              }
              catch (Exception paramViewGroup)
              {
                ae.e("MicroMsg.GestureGalleryUI", bu.o(paramViewGroup));
                ((a)localObject1).BBl.setVisibility(0);
                ((a)localObject1).tpC.setVisibility(8);
                ((a)localObject1).BBl.setImageBitmap(paramView);
                continue;
              }
              label1111:
              if ((i != 0) && (paramView != null) && (!paramView.isRecycled()))
              {
                ((a)localObject1).BBk.setVisibility(0);
                ((a)localObject1).tpC.setVisibility(0);
                ((a)localObject1).tpC.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((a)localObject1).tpC.setImageBitmap(paramView);
              }
              else if ((j != 0) && (paramView != null) && (!paramView.isRecycled()))
              {
                ((a)localObject1).BBk.setVisibility(8);
                ((a)localObject1).tpC.setVisibility(0);
                ((a)localObject1).tpC.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((a)localObject1).tpC.setImageBitmap(paramView);
              }
              else if ((paramView != null) && (!paramView.isRecycled()))
              {
                ((a)localObject1).BBl.setVisibility(8);
                ((a)localObject1).tpC.setVisibility(8);
                paramViewGroup = new MultiTouchImageView(GestureGalleryUI.this, paramView.getWidth(), paramView.getHeight(), (byte)0);
                if (i != 0)
                {
                  paramViewGroup.setEnabled(false);
                  if (Build.VERSION.SDK_INT != 20) {
                    break label1353;
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
                  r.z(paramViewGroup, paramView.getWidth(), paramView.getHeight());
                }
                label1368:
                ((a)localObject1).BBk.setVisibility(0);
                ((a)localObject1).BBl.setVisibility(8);
                ((a)localObject1).tpC.setVisibility(8);
                ((a)localObject1).tPf.setVisibility(8);
              }
            }
          }
          localObject1 = paramViewGroup;
          localView = paramView;
        }
      }
    }
    
    public final class a
    {
      ImageView AjY;
      ProgressBar BBk;
      MMAnimateView BBl;
      VideoView BBm;
      View BBn;
      TextView BBo;
      View tPf;
      ImageView tpC;
      
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
      ae.i("MicroMsg.GestureGalleryUI", "start run play progress task");
      for (;;)
      {
        if (this.isStop) {
          break label127;
        }
        try
        {
          if ((GestureGalleryUI.ac(GestureGalleryUI.this) == GestureGalleryUI.c.BBs) || (GestureGalleryUI.ac(GestureGalleryUI.this) == GestureGalleryUI.c.BBr) || (GestureGalleryUI.ac(GestureGalleryUI.this) == GestureGalleryUI.c.BBt))
          {
            GestureGalleryUI localGestureGalleryUI = GestureGalleryUI.this;
            if (localGestureGalleryUI.BAJ != null) {
              localGestureGalleryUI.BAO.post(new GestureGalleryUI.24(localGestureGalleryUI));
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.e("MicroMsg.GestureGalleryUI", "PlayProgressTask run exception:" + localException.getMessage());
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
      BBq = new c("Idle", 0);
      BBr = new c("Prepared", 1);
      BBs = new c("Start", 2);
      BBt = new c("Resume", 3);
      BBu = new c("Paused", 4);
      BBv = new c("Complete", 5);
      BBw = new c("Stop", 6);
      BBx = new c("Error", 7);
      BBy = new c[] { BBq, BBr, BBs, BBt, BBu, BBv, BBw, BBx };
      AppMethodBeat.o(179722);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI
 * JD-Core Version:    0.7.0.1
 */