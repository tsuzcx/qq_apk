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
import android.widget.VideoView;
import com.danikula.videocache.HttpProxyCacheServer;
import com.danikula.videocache.HttpProxyCacheServer.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qq;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.g.a.sp.a;
import com.tencent.mm.g.b.a.ce;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.media.model.AppBrandMediaSource;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ab.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
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
import com.tencent.mm.vfs.i;
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
  implements ab.b, com.tencent.mm.plugin.scanner.word.a.a<String, com.tencent.mm.plugin.scanner.word.b>, a.a
{
  private float Aal;
  private int Aam;
  private int Aan;
  private a BiO;
  MMGestureGallery BiP;
  private int BiQ;
  private String BiR;
  private ab BiS;
  private boolean BiT;
  private boolean BiU;
  private boolean BiV;
  private boolean BiW;
  private JSONArray BiX;
  private com.tencent.mm.ui.widget.a.e BiY;
  private volatile boolean BiZ;
  private AdapterView.OnItemSelectedListener BjA;
  private View BjB;
  private b BjC;
  private int Bja;
  private int Bjb;
  private int Bjc;
  private final Set<Integer> Bjd;
  private final Set<Integer> Bje;
  private boolean Bjf;
  private TextView Bjg;
  private a Bjh;
  private com.tencent.mm.plugin.webview.j.h Bji;
  private String Bjj;
  GestureGalleryUI.a.a Bjk;
  private boolean Bjl;
  private RelativeLayout Bjm;
  private RelativeLayout Bjn;
  private PressAlphaImageView Bjo;
  RedesignVideoPlayerSeekBar Bjp;
  private long Bjq;
  private c Bjr;
  boolean Bjs;
  private c<cd> Bjt;
  private List<String> Bju;
  private List<AppBrandMediaSource> Bjv;
  private int Bjw;
  private int Bjx;
  private String Bjy;
  private boolean Bjz;
  private boolean hDR;
  private String hFI;
  private String hFx;
  private boolean isAnimated;
  private String liC;
  private ScanCodeSheetItemLogic lvI;
  private ap mHandler;
  private ImageView oGj;
  private Bundle oGn;
  private com.tencent.mm.ui.tools.e oGo;
  private int oGp;
  private int oGq;
  private int oGr;
  private int oGs;
  private boolean rwL;
  private c rwO;
  private int type;
  private long vtP;
  private volatile String zQC;
  private String zQF;
  private String zQG;
  private String zQH;
  private String zQI;
  private String zQJ;
  private c zQO;
  private int zRp;
  
  public GestureGalleryUI()
  {
    AppMethodBeat.i(29091);
    this.BiT = false;
    this.BiU = false;
    this.hFx = "";
    this.hFI = null;
    this.BiV = false;
    this.BiW = true;
    this.BiX = null;
    this.zRp = 0;
    this.Bjd = new HashSet();
    this.Bje = new HashSet();
    this.Bjf = false;
    this.isAnimated = false;
    this.oGp = 0;
    this.oGq = 0;
    this.oGr = 0;
    this.oGs = 0;
    this.mHandler = new ap();
    this.Bjj = "";
    this.hDR = false;
    this.Bjl = false;
    this.vtP = 0L;
    this.Bjq = 0L;
    this.Bjr = c.BjR;
    this.Bjs = false;
    this.Bjt = new GestureGalleryUI.10(this);
    this.Bju = new ArrayList();
    this.Bjv = new ArrayList();
    this.type = 0;
    this.Bjw = -1;
    this.Bjx = -1;
    this.liC = null;
    this.Bjy = null;
    this.Aal = 1.0F;
    this.Aam = 0;
    this.Aan = 0;
    this.Bjz = false;
    this.BjA = new AdapterView.OnItemSelectedListener()
    {
      VideoView BjG;
      
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(193368);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$16", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        GestureGalleryUI.f(GestureGalleryUI.this, paramAnonymousInt);
        GestureGalleryUI.H(GestureGalleryUI.this).setText(GestureGalleryUI.c(GestureGalleryUI.this) + 1 + "/" + GestureGalleryUI.m(GestureGalleryUI.this).getCount());
        GestureGalleryUI.this.setMMTitle(GestureGalleryUI.c(GestureGalleryUI.this) + 1 + " / " + GestureGalleryUI.I(GestureGalleryUI.this).size());
        ad.d("MicroMsg.GestureGalleryUI", "pos:".concat(String.valueOf(paramAnonymousInt)));
        GestureGalleryUI.c(GestureGalleryUI.this, (String)GestureGalleryUI.I(GestureGalleryUI.this).get(paramAnonymousInt));
        GestureGalleryUI.d(GestureGalleryUI.this, "");
        GestureGalleryUI.b(GestureGalleryUI.this, false);
        if (this.BjG != null)
        {
          this.BjG.stopPlayback();
          this.BjG = null;
        }
        GestureGalleryUI.J(GestureGalleryUI.this).setIsPlay(false);
        GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.c.BjR);
        if ((paramAnonymousView != null) && (paramAnonymousView.getTag() != null))
        {
          paramAnonymousAdapterView = (GestureGalleryUI.a.a)paramAnonymousView.getTag();
          if ((paramAnonymousAdapterView != null) && (GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousInt)))
          {
            this.BjG = paramAnonymousAdapterView.BjN;
            GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousAdapterView);
            paramAnonymousAdapterView.tEo.setVisibility(0);
            paramAnonymousAdapterView.zSR.setVisibility(0);
            paramAnonymousAdapterView.BjL.setVisibility(8);
            paramAnonymousAdapterView.BjO.setVisibility(8);
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
          ad.i("MicroMsg.GestureGalleryUI", "curFilename:%s", new Object[] { GestureGalleryUI.j(GestureGalleryUI.this) });
          GestureGalleryUI.l(GestureGalleryUI.this);
          GestureGalleryUI.a(GestureGalleryUI.this, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$16", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(193368);
          return;
          if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.tEo == null)) {
            break;
          }
          paramAnonymousAdapterView.tEo.setVisibility(8);
          break;
          label459:
          GestureGalleryUI.d(GestureGalleryUI.this, GestureGalleryUI.M(GestureGalleryUI.this).c((String)GestureGalleryUI.I(GestureGalleryUI.this).get(paramAnonymousInt), GestureGalleryUI.K(GestureGalleryUI.this), paramAnonymousInt, GestureGalleryUI.L(GestureGalleryUI.this)));
          if (bt.isNullOrNil(GestureGalleryUI.j(GestureGalleryUI.this))) {
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
    this.rwO = new c() {};
    this.zQO = new c() {};
    AppMethodBeat.o(29091);
  }
  
  private boolean SI(int paramInt)
  {
    AppMethodBeat.i(193388);
    if ((this.Bjv != null) && (this.Bjv.size() > paramInt) && (this.Bjv.get(paramInt) != null) && ("video".endsWith(((AppBrandMediaSource)this.Bjv.get(paramInt)).hkO)))
    {
      AppMethodBeat.o(193388);
      return true;
    }
    AppMethodBeat.o(193388);
    return false;
  }
  
  private void cxt()
  {
    AppMethodBeat.i(179724);
    ad.i("MicroMsg.GestureGalleryUI", "pauseVideo");
    if (this.Bjk != null)
    {
      this.Bjq = (this.Bjp.getmPosition() * 1000);
      ad.i("MicroMsg.GestureGalleryUI", "pauseVideo currentVideoPos：%d", new Object[] { Long.valueOf(this.Bjq) });
      this.Bjk.BjN.pause();
      this.Bjk.zSR.setVisibility(0);
      if ((this.Bjr != c.BjT) && (this.Bjr != c.BjU)) {
        break label133;
      }
      this.Bjr = c.BjV;
      this.Bjs = true;
    }
    for (;;)
    {
      this.Bjp.setIsPlay(false);
      enh();
      AppMethodBeat.o(179724);
      return;
      label133:
      c localc = c.BjV;
    }
  }
  
  private boolean ene()
  {
    AppMethodBeat.i(169766);
    if ((this.BiZ) && (!bt.isNullOrNil(this.zQF)))
    {
      AppMethodBeat.o(169766);
      return true;
    }
    AppMethodBeat.o(169766);
    return false;
  }
  
  private String enf()
  {
    AppMethodBeat.i(179723);
    if ((this.Bjw < 0) || (this.Bjv == null) || (this.Bjv.size() == 0))
    {
      AppMethodBeat.o(179723);
      return "";
    }
    String str = ((AppBrandMediaSource)this.Bjv.get(this.Bjw)).url;
    ad.i("MicroMsg.GestureGalleryUI", "playVideo  url :%s", new Object[] { str });
    if ((str != null) && (str.startsWith("http")))
    {
      Object localObject;
      if (com.tencent.mm.plugin.ab.a.BEP == null)
      {
        localObject = new File(com.tencent.mm.loader.j.b.asL());
        if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
          ((File)localObject).mkdir();
        }
        localObject = new HttpProxyCacheServer.Builder(this).maxCacheSize(134217728L).cacheDirectory((File)localObject).build();
        com.tencent.mm.plugin.ab.a.BEP = (HttpProxyCacheServer)localObject;
      }
      for (;;)
      {
        localObject = ((HttpProxyCacheServer)localObject).getProxyUrl(str);
        AppMethodBeat.o(179723);
        return localObject;
        localObject = com.tencent.mm.plugin.ab.a.BEP;
      }
    }
    AppMethodBeat.o(179723);
    return str;
  }
  
  private void eng()
  {
    AppMethodBeat.i(179725);
    enh();
    this.BjC = new b((byte)0);
    b localb = this.BjC;
    localb.isStop = false;
    com.tencent.mm.sdk.g.b.c(localb, "gesture_gallery_ui_video_update_progress");
    AppMethodBeat.o(179725);
  }
  
  private void enh()
  {
    if (this.BjC != null) {
      this.BjC.isStop = true;
    }
  }
  
  private static void gx(Context paramContext)
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
  
  private void sC(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(29102);
    if (this.BiY == null) {
      this.BiY = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
    }
    this.BiY.KJy = new n.d()
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
          paramAnonymousl.jI(1, 2131762163);
          if (GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.c(GestureGalleryUI.this)))
          {
            paramAnonymousl.jI(2, 2131762784);
            paramAnonymousl.jI(3, 2131761941);
          }
        }
        else if ((GestureGalleryUI.q(GestureGalleryUI.this)) && (!bt.isNullOrNil(GestureGalleryUI.j(GestureGalleryUI.this))))
        {
          paramAnonymousl.jI(4, 2131757184);
          localObject = GestureGalleryUI.e(GestureGalleryUI.this);
          localce = new ce();
          if (((a)localObject).ryV != 2) {
            break label244;
          }
          l = 1L;
          label132:
          localce.dVd = l;
          localce.dPl = 2L;
          if (!((a)localObject).BiK) {
            break label249;
          }
        }
        label244:
        label249:
        for (long l = 6L;; l = 5L)
        {
          localce.eca = l;
          localce.aLk();
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
          paramAnonymousl.jI(2, 2131762781);
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
    this.BiY.KJz = new n.e()
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
          localObject1 = paramAnonymousMenuItem.BiJ.cwq();
        } while (((paramAnonymousMenuItem.ryV != 0) && (paramAnonymousMenuItem.ryV != 2)) || (bt.isNullOrNil((String)localObject1)));
        Object localObject2 = new ce();
        long l;
        if (paramAnonymousMenuItem.ryV == 2)
        {
          l = 1L;
          ((ce)localObject2).dVd = l;
          ((ce)localObject2).dPl = 3L;
          if (!paramAnonymousMenuItem.BiK) {
            break label402;
          }
          l = 6L;
          label188:
          ((ce)localObject2).eca = l;
          ((ce)localObject2).aLk();
          paramAnonymousMenuItem.ryU = ((int)(u.aAm().hashCode() + System.currentTimeMillis()));
          localObject2 = ((com.tencent.mm.plugin.scanner.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.scanner.d.class)).getTranslationResult((String)localObject1);
          if ((localObject2 == null) || (!i.fv(((fp)localObject2).field_resultFile))) {
            break label414;
          }
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("original_file_path", (String)localObject1);
          if (!paramAnonymousMenuItem.BiK) {
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
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
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
        sp.a locala;
        if ((com.tencent.mm.kernel.g.aiU().aEN() != 6) && (com.tencent.mm.kernel.g.aiU().aEN() != 4))
        {
          com.tencent.mm.ui.base.h.c(paramAnonymousMenuItem.activity, paramAnonymousMenuItem.activity.getString(2131755828), "", true);
          paramAnonymousMenuItem.cwC();
          ad.i("MicroMsg.GestureGalleryTransLogic", "try to translate img %s, sessionId %d", new Object[] { localObject1, Integer.valueOf(paramAnonymousMenuItem.ryU) });
          localObject2 = new sp();
          locala = ((sp)localObject2).dHf;
          if (!paramAnonymousMenuItem.BiK) {
            break label603;
          }
        }
        for (;;)
        {
          locala.scene = paramAnonymousInt;
          ((sp)localObject2).dHf.filePath = ((String)localObject1);
          ((sp)localObject2).dHf.dlK = paramAnonymousMenuItem.ryU;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
          break;
          paramAnonymousMenuItem.ryV = 1;
          paramAnonymousMenuItem.ryX.setVisibility(0);
          paramAnonymousMenuItem.ryY.setVisibility(0);
          paramAnonymousMenuItem.ryZ.setVisibility(0);
          paramAnonymousMenuItem.rza.setRepeatMode(1);
          paramAnonymousMenuItem.rza.setRepeatCount(-1);
          paramAnonymousMenuItem.rza.start();
          break label459;
          label603:
          paramAnonymousInt = 5;
        }
      }
    };
    this.BiY.JXC = new e.b()
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
      if ((!this.hDR) || (ene()) || (this.rwL)) {
        break label273;
      }
    }
    Object localObject;
    String str;
    for (;;)
    {
      if (i != 0) {
        this.BiY.cMW();
      }
      if ((this.BiZ) && (bt.isNullOrNil(this.zQF)) && (ba.aiU().aEN() != 0))
      {
        localObject = new qc();
        ((qc)localObject).dEC.dlI = System.currentTimeMillis();
        ((qc)localObject).dEC.filePath = this.BiR;
        ((qc)localObject).dEC.dED = new HashSet(this.Bjd);
        this.zQC = this.BiR;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      if (bt.isNullOrNil(this.BiR)) {
        break label315;
      }
      com.tencent.mm.kernel.g.ajD();
      if ((com.tencent.mm.kernel.g.ajB().gAO.aEN() == 0) || (!paramBoolean)) {
        break label315;
      }
      localObject = this.Bjh;
      str = this.BiR;
      if ((((a)localObject).activity != null) && (!((a)localObject).activity.isFinishing())) {
        break;
      }
      AppMethodBeat.o(29102);
      return;
      label273:
      i = 1;
    }
    if (((a)localObject).ryT == null) {
      ((a)localObject).ryT = new ImageWordScanDetailEngine(((a)localObject).activity);
    }
    ((a)localObject).ryT.a(str, ((a)localObject).ryS);
    label315:
    AppMethodBeat.o(29102);
  }
  
  private void tQ(int paramInt)
  {
    AppMethodBeat.i(193387);
    if ((this.Bji == null) || (bt.isNullOrNil(this.Bjy)))
    {
      AppMethodBeat.o(193387);
      return;
    }
    this.Bji.url = this.Bjy;
    this.Bji.dOE = this.Bjc;
    if (!bt.isNullOrNil(this.zQF))
    {
      this.Bji.Etq = true;
      this.Bji.XW(this.Bja);
      this.Bji.scanResult = this.zQF;
    }
    String str = x.aNF(this.Bjj);
    this.Bji.vyg = str;
    this.Bji.ma(paramInt);
    AppMethodBeat.o(193387);
  }
  
  public final void bWL()
  {
    AppMethodBeat.i(29100);
    if ((this.BiP.getSelectedItemPosition() != this.Bjx) || (!this.Bjf))
    {
      finish();
      overridePendingTransition(0, 0);
      AppMethodBeat.o(29100);
      return;
    }
    if ((this.Bjz) || (this.BiO == null))
    {
      ad.i("MicroMsg.GestureGalleryUI", "isRunningExitAnimation");
      AppMethodBeat.o(29100);
      return;
    }
    ad.i("MicroMsg.GestureGalleryUI", "runExitAnimation");
    int k = this.BiP.getWidth();
    int i = this.BiP.getHeight();
    int j = this.BiP.getSelectedItemPosition();
    Object localObject = (String)this.Bju.get(j);
    if (i.fv((String)localObject))
    {
      if (bt.isNullOrNil((String)localObject)) {
        break label412;
      }
      localObject = com.tencent.mm.sdk.platformtools.g.aQc((String)localObject);
      float f = k / ((BitmapFactory.Options)localObject).outWidth;
      j = (int)(((BitmapFactory.Options)localObject).outHeight * f);
      i = j;
      if (j > this.BiP.getHeight())
      {
        if (j < this.BiP.getHeight() * 2.5D) {
          this.oGs = (this.BiP.getHeight() * this.oGs / j);
        }
        i = this.BiP.getHeight();
      }
    }
    label412:
    for (;;)
    {
      this.oGo.jZ(k, i);
      this.oGo.R(this.oGq, this.oGp, this.oGr, this.oGs);
      if (this.Aal != 1.0D)
      {
        this.oGo.KIl = (1.0F / this.Aal);
        if ((this.Aam != 0) || (this.Aan != 0))
        {
          j = (int)(this.BiP.getWidth() / 2 * (1.0F - this.Aal));
          k = this.Aam;
          i = (int)(this.BiP.getHeight() / 2 + this.Aan - i / 2 * this.Aal);
          this.oGo.kb(j + k, i);
        }
      }
      this.oGo.a(this.BiP, this.oGj, new e.c()
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
              View localView = GestureGalleryUI.m(GestureGalleryUI.this).eni();
              if ((localView instanceof MultiTouchImageView)) {
                ((MultiTouchImageView)localView).fyy();
              }
              AppMethodBeat.o(29079);
            }
          }, 20L);
          AppMethodBeat.o(29081);
        }
      }, null);
      AppMethodBeat.o(29100);
      return;
      localObject = this.BiS.c((String)localObject, this.type, j, this.hFI);
      break;
    }
  }
  
  public final String cwq()
  {
    return this.BiR;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29101);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.GestureGalleryUI", "dispatchKeyEvent");
      bWL();
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
    String str1 = bt.nullAsNil(getIntent().getStringExtra("nowUrl"));
    this.liC = bt.nullAsNil(getIntent().getStringExtra("nowUrlPath"));
    this.Bjy = bt.nullAsNil(getIntent().getStringExtra("nowWebUrl"));
    this.type = getIntent().getIntExtra("type", 0);
    Object localObject = getIntent().getParcelableArrayListExtra("mediaSource");
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.Bjv.clear();
      this.Bjv.addAll((Collection)localObject);
    }
    localObject = getIntent().getStringArrayExtra("urlList");
    final int i;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = bt.nullAsNil(getIntent().getStringExtra("htmlData"));
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
          ad.d("MicroMsg.GestureGalleryUI", "start:" + j + " end:" + i + " url:" + str2);
          this.Bju.add(str2);
          continue;
          this.Bju = Arrays.asList((Object[])localObject);
        }
      }
    }
    localObject = getIntent().getStringExtra("pageInfos");
    if (!bt.isNullOrNil((String)localObject)) {}
    try
    {
      this.BiX = new JSONArray((String)localObject);
      label302:
      i = 0;
      for (;;)
      {
        if (i < this.Bju.size())
        {
          if (str1.equals(this.Bju.get(i))) {
            this.Bjw = i;
          }
        }
        else
        {
          this.Bjx = this.Bjw;
          if (getIntent().getIntExtra("currentPos", -1) >= 0) {
            this.Bjx = getIntent().getIntExtra("currentPos", -1);
          }
          setBackBtn(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(29074);
              GestureGalleryUI.this.bWL();
              AppMethodBeat.o(29074);
              return true;
            }
          });
          this.Bjg = ((TextView)findViewById(2131303133));
          this.oGj = ((ImageView)findViewById(2131300336));
          this.Bjn = ((RelativeLayout)findViewById(2131306407));
          this.Bjp = ((RedesignVideoPlayerSeekBar)findViewById(2131306375));
          this.Bjo = ((PressAlphaImageView)findViewById(2131306316));
          this.Bjo.setOnClickListener(new GestureGalleryUI.15(this));
          this.Bjp.setPlayBtnOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(193376);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              if (GestureGalleryUI.J(GestureGalleryUI.this).cfC()) {
                GestureGalleryUI.Y(GestureGalleryUI.this);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(193376);
                return;
                GestureGalleryUI.Z(GestureGalleryUI.this);
              }
            }
          });
          this.Bjp.setVideoTotalTime(0);
          this.Bjp.seek(0);
          this.Bjp.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
          {
            public final void aqD() {}
            
            public final void nM(int paramAnonymousInt)
            {
              AppMethodBeat.i(193377);
              if (GestureGalleryUI.aa(GestureGalleryUI.this) != null) {
                GestureGalleryUI.aa(GestureGalleryUI.this).BjN.seekTo(paramAnonymousInt * 1000);
              }
              AppMethodBeat.o(193377);
            }
          });
          this.BiO = new a();
          this.BiP = ((MMGestureGallery)findViewById(2131300335));
          this.BiP.setVisibility(0);
          this.BiP.setVerticalFadingEdgeEnabled(false);
          this.BiP.setHorizontalFadingEdgeEnabled(false);
          this.BiP.setAdapter(this.BiO);
          this.BiP.setSelection(this.Bjw);
          this.BiP.setOnItemSelectedListener(this.BjA);
          this.BiP.setSingleClickOverListener(new MMGestureGallery.f()
          {
            public final void aRp()
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
                if (GestureGalleryUI.e(GestureGalleryUI.this).ryV != 1) {
                  GestureGalleryUI.this.bWL();
                }
                AppMethodBeat.o(29075);
                return;
              }
            }
          });
          i = getIntent().getIntExtra("nevNext", 1);
          this.BiP.setLongClickOverListener(new MMGestureGallery.c()
          {
            public final void aRq()
            {
              boolean bool2 = true;
              AppMethodBeat.i(29077);
              if (GestureGalleryUI.e(GestureGalleryUI.this).ryV == 1)
              {
                AppMethodBeat.o(29077);
                return;
              }
              if ((GestureGalleryUI.f(GestureGalleryUI.this)) && (!GestureGalleryUI.g(GestureGalleryUI.this)))
              {
                ad.e("MicroMsg.GestureGalleryUI", "is from appbrand, but showmenu is false, don't show menu");
                AppMethodBeat.o(29077);
                return;
              }
              GestureGalleryUI.a(GestureGalleryUI.this, new com.tencent.mm.plugin.webview.j.h());
              GestureGalleryUI.h(GestureGalleryUI.this).reset(2);
              Object localObject1;
              if (1 == i)
              {
                localObject1 = y.aBq().F("basescanui@datacenter", true);
                ((y.b)localObject1).k("key_basescanui_screen_x", Integer.valueOf(GestureGalleryUI.i(GestureGalleryUI.this).getXDown()));
                ((y.b)localObject1).k("key_basescanui_screen_y", Integer.valueOf(GestureGalleryUI.i(GestureGalleryUI.this).getYDown()));
                if ((GestureGalleryUI.e(GestureGalleryUI.this).ryV == 0) || (GestureGalleryUI.e(GestureGalleryUI.this).ryV == 2))
                {
                  localObject1 = GestureGalleryUI.e(GestureGalleryUI.this);
                  Object localObject2 = new ce();
                  long l;
                  label233:
                  boolean bool1;
                  if (((a)localObject1).ryV == 2)
                  {
                    l = 1L;
                    ((ce)localObject2).dVd = l;
                    ((ce)localObject2).dPl = 1L;
                    if (!((a)localObject1).BiK) {
                      break label392;
                    }
                    l = 6L;
                    ((ce)localObject2).eca = l;
                    ((ce)localObject2).aLk();
                    localObject1 = GestureGalleryUI.this;
                    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("EnableWebviewPicTranslation", 0);
                    localObject2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("PicTranslationSupportUserLanguage");
                    if (i != 1) {
                      break label400;
                    }
                    bool1 = true;
                    label299:
                    ad.i("MicroMsg.ScannerHelper", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool1), localObject2, ac.fks() });
                    if ((i != 1) || (bt.isNullOrNil((String)localObject2))) {
                      break label405;
                    }
                    localObject2 = ((String)localObject2).split(";");
                    if ((localObject2 == null) || (!Arrays.asList((Object[])localObject2).contains(ac.fks()))) {
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
                    if (!com.tencent.mm.protocal.d.Fnn) {
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
                  public final void lf(int paramAnonymous2Int)
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
                      com.tencent.mm.plugin.subapp.b.iRG.k(localIntent, localGestureGalleryUI.getContext());
                    }
                  }
                });
              }
              AppMethodBeat.o(29077);
            }
          });
          this.oGo = new com.tencent.mm.ui.tools.e(this);
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
    if (this.BiO != null)
    {
      if (paramInt == this.BiP.getSelectedItemPosition())
      {
        this.BiR = paramString2;
        this.BiQ = paramInt;
        ad.d("MicroMsg.GestureGalleryUI", "onDownSucc, curFilename:%s, url:%s", new Object[] { this.BiR, paramString1 });
      }
      this.BiO.notifyDataSetChanged();
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
            AppMethodBeat.i(193384);
            this.rvc.dismiss();
            AppMethodBeat.o(193384);
          }
        };
        if (!bt.isNullOrNil((String)localObject)) {
          break label93;
        }
        AppMethodBeat.o(179726);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label93:
      Iterator localIterator = bt.U(((String)localObject).split(",")).iterator();
      while (localIterator.hasNext())
      {
        final String str2 = (String)localIterator.next();
        String str1 = ((AppBrandMediaSource)this.Bjv.get(this.Bjw)).hkP;
        localObject = str1;
        if (!i.fv(str1)) {
          localObject = this.BiS.c(str1, this.type, this.Bjw, this.hFI);
        }
        ad.i("MicroMsg.GestureGalleryUI", "onActivityResult,  sendVideo video:%s,  thumbFilename:%s", new Object[] { enf(), localObject });
        com.tencent.mm.kernel.g.ajF().ay(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193385);
            com.tencent.mm.plugin.messenger.a.g.dlD().a(GestureGalleryUI.this.getContext(), str2, GestureGalleryUI.D(GestureGalleryUI.this), this.BjH, 1, (int)GestureGalleryUI.ab(GestureGalleryUI.this), "", "");
            aq.f(local25);
            AppMethodBeat.o(193385);
          }
          
          public final String toString()
          {
            AppMethodBeat.i(193386);
            String str = super.toString() + "send video";
            AppMethodBeat.o(193386);
            return str;
          }
        });
        if (!bt.isNullOrNil(paramIntent)) {
          com.tencent.mm.plugin.messenger.a.g.dlD().aa(str2, paramIntent, w.Ar(str2));
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
    this.oGn = paramBundle;
    this.Bjt.alive();
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setFlags(1024, 1024);
      getWindow().addFlags(67108864);
    }
    fullScreenNoTitleBar(true);
    this.BiV = getIntent().getBooleanExtra("isFromAppBrand", false);
    this.hDR = getIntent().getBooleanExtra("forBidForward", false);
    this.BiT = getIntent().getBooleanExtra("isFromWebView", false);
    this.BiW = getIntent().getBooleanExtra("showmenu", true);
    this.BiU = getIntent().getBooleanExtra("isOuntLink", false);
    this.hFx = getIntent().getStringExtra("IsFromWebViewReffer");
    this.BiZ = getIntent().getBooleanExtra("shouldShowScanQrCodeMenu", false);
    this.Bjf = getIntent().getBooleanExtra("shouldRunDragAnimation", false);
    this.Bjc = getIntent().getIntExtra("scanQrCodeGetA8KeyScene", 0);
    paramBundle = getIntent().getIntArrayExtra("scanCodeTypes");
    int i;
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      i = 0;
      while (i < paramBundle.length)
      {
        this.Bjd.add(Integer.valueOf(paramBundle[i]));
        i += 1;
      }
    }
    paramBundle = getIntent().getIntArrayExtra("scanResultCodeTypes");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      i = 0;
      while (i < paramBundle.length)
      {
        this.Bje.add(Integer.valueOf(paramBundle[i]));
        i += 1;
      }
    }
    this.Bjh = new a(this, this, this, this.BiU);
    this.hFI = getIntent().getStringExtra("cookie");
    ad.d("MicroMsg.GestureGalleryUI", "isFromWebView: %b, isFromWebViewReffer:%s, cookie = %s, forbidForward=%b", new Object[] { Boolean.valueOf(this.BiT), this.hFx, this.hFI, Boolean.valueOf(this.hDR) });
    this.BiS = new ab(this.BiT, this.hFx);
    paramBundle = this.BiS;
    ad.d("MicroMsg.GetPicService", "addListener :" + hashCode());
    paramBundle.hFz = this;
    com.tencent.mm.sdk.b.a.IbL.c(this.rwO);
    com.tencent.mm.sdk.b.a.IbL.c(this.zQO);
    initView();
    this.Bjz = false;
    if (this.BiV) {
      getWindow().setBackgroundDrawableResource(2131231318);
    }
    this.lvI = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a()
    {
      public final void bpj()
      {
        AppMethodBeat.i(29065);
        if ((GestureGalleryUI.a(GestureGalleryUI.this) != null) && (GestureGalleryUI.a(GestureGalleryUI.this).isShowing())) {
          GestureGalleryUI.b(GestureGalleryUI.this);
        }
        AppMethodBeat.o(29065);
      }
    });
    this.Bjm = ((RelativeLayout)findViewById(2131308329));
    if (this.BiX != null)
    {
      this.BjB = findViewById(2131308432);
      this.Bjm.setVisibility(0);
      ((TextView)findViewById(2131308379)).setTextSize(1, 12.0F);
      this.BjB.setOnClickListener(new GestureGalleryUI.12(this));
      findViewById(2131308330).setOnClickListener(new GestureGalleryUI.13(this));
      findViewById(2131299194).setOnClickListener(new GestureGalleryUI.14(this));
      AppMethodBeat.o(29093);
      return;
    }
    this.Bjm.setVisibility(8);
    AppMethodBeat.o(29093);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29094);
    super.onDestroy();
    Object localObject = this.BiS;
    ad.d("MicroMsg.GetPicService", "removeListener :" + hashCode());
    ((ab)localObject).hFz = null;
    localObject = this.BiS;
    if (((ab)localObject).hFv != null) {
      ((ab)localObject).hFv.hFD = true;
    }
    ((ab)localObject).hFv = null;
    com.tencent.mm.sdk.b.a.IbL.d(this.rwO);
    com.tencent.mm.sdk.b.a.IbL.d(this.zQO);
    this.Bjt.dead();
    gx(this);
    if (this.Bjh != null)
    {
      localObject = this.Bjh;
      ((a)localObject).cwE();
      ((a)localObject).rza.removeAllUpdateListeners();
      ((a)localObject).rzb.dead();
      com.tencent.mm.kernel.g.ajB().b(((a)localObject).rzc);
      ((a)localObject).ryS = null;
      ((a)localObject).activity = null;
      ((a)localObject).BiJ = null;
    }
    localObject = new qq();
    ((qq)localObject).dFm.activity = this;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    ad.i("MicroMsg.GestureGalleryUI", "stopVideo");
    if (this.Bjk != null)
    {
      this.Bjk.BjN.stopPlayback();
      this.Bjr = c.BjX;
      this.Bjp.setIsPlay(false);
      this.Bjp.setIplaySeekCallback(null);
      this.Bjk.zSR.setVisibility(0);
      this.Bjk.teJ.setVisibility(0);
      this.Bjk.BjN.setVisibility(8);
    }
    enh();
    AppMethodBeat.o(29094);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29095);
    super.onPause();
    cxt();
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
    Bundle localBundle = this.oGn;
    if ((this.isAnimated) || (!this.Bjf)) {}
    for (;;)
    {
      super.onStart();
      AppMethodBeat.o(29099);
      return;
      this.isAnimated = true;
      this.oGp = getIntent().getIntExtra("img_gallery_top", 0);
      this.oGq = getIntent().getIntExtra("img_gallery_left", 0);
      this.oGr = getIntent().getIntExtra("img_gallery_width", 0);
      this.oGs = getIntent().getIntExtra("img_gallery_height", 0);
      this.oGo.R(this.oGq, this.oGp, this.oGr, this.oGs);
      if (localBundle == null) {
        this.BiP.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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
    if (this.zQF != null)
    {
      au localau = new au();
      localau.dlF.activity = this;
      localau.dlF.dlG = this.zQF;
      com.tencent.mm.sdk.b.a.IbL.l(localau);
      this.zQF = null;
      this.Bjb = 0;
      this.Bja = 0;
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
    
    private View SJ(int paramInt)
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
    
    public final View eni()
    {
      AppMethodBeat.i(29088);
      View localView = SJ(GestureGalleryUI.this.BiP.getSelectedItemPosition());
      AppMethodBeat.o(29088);
      return localView;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(29086);
      ad.d("MicroMsg.GestureGalleryUI", "lstpicurl:" + GestureGalleryUI.I(GestureGalleryUI.this).size());
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
        if ((paramView == null) || ((i != 0) && (paramViewGroup != null) && (paramViewGroup.BjN == null)))
        {
          localObject1 = new a();
          localView = View.inflate(GestureGalleryUI.this, 2131495191, null);
          ((a)localObject1).BjL = ((ProgressBar)localView.findViewById(2131303535));
          ((a)localObject1).BjM = ((MMAnimateView)localView.findViewById(2131300914));
          ((a)localObject1).teJ = ((ImageView)localView.findViewById(2131305793));
          ((a)localObject1).tEo = localView.findViewById(2131306319);
          ((a)localObject1).BjN = ((VideoView)localView.findViewById(2131306410));
          ((a)localObject1).zSR = ((ImageView)localView.findViewById(2131306413));
          ((a)localObject1).BjO = localView.findViewById(2131306339);
          ((a)localObject1).BjP = ((TextView)localView.findViewById(2131306340));
          if (i != 0)
          {
            ((a)localObject1).teJ.setVisibility(8);
            ((a)localObject1).teJ = ((ImageView)localView.findViewById(2131306347));
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
            paramView = ((AppBrandMediaSource)localObject2).hkP;
            j = 1;
          }
          paramViewGroup = paramView;
          if (!i.fv(paramView))
          {
            paramView = GestureGalleryUI.M(GestureGalleryUI.this).c(paramView, GestureGalleryUI.K(GestureGalleryUI.this), paramInt, GestureGalleryUI.L(GestureGalleryUI.this));
            paramViewGroup = paramView;
            if (paramInt == GestureGalleryUI.R(GestureGalleryUI.this))
            {
              paramViewGroup = paramView;
              if (bt.isNullOrNil(paramView))
              {
                paramViewGroup = paramView;
                if (i.fv(GestureGalleryUI.S(GestureGalleryUI.this))) {
                  paramViewGroup = GestureGalleryUI.S(GestureGalleryUI.this);
                }
              }
            }
          }
          for (i = 1;; i = k)
          {
            ((a)localObject1).BjN.setVisibility(8);
            ((a)localObject1).BjN.stopPlayback();
            if (j != 0)
            {
              ((a)localObject1).tEo.setVisibility(0);
              GestureGalleryUI.b(GestureGalleryUI.this, (a)localObject1);
              if (bt.isNullOrNil(paramViewGroup)) {
                break label1368;
              }
              ((a)localObject1).BjL.setVisibility(8);
              if ((GestureGalleryUI.Q(GestureGalleryUI.this) != null) && (!GestureGalleryUI.Q(GestureGalleryUI.this).isEmpty())) {
                TextUtils.isEmpty(((AppBrandMediaSource)GestureGalleryUI.Q(GestureGalleryUI.this).get(paramInt)).hkP);
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
              ((a)localObject1).tEo.setVisibility(8);
              break;
              label600:
              localObject2 = com.tencent.mm.aw.a.a.aIP().FD(paramViewGroup + "_" + i.aYo(paramViewGroup));
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
                  ad.i("MicroMsg.GestureGalleryUI", "recycle bitmap:%s", new Object[] { paramView.toString() });
                  paramView.recycle();
                }
                localObject2 = com.tencent.mm.sdk.platformtools.g.aQf(paramViewGroup);
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
                  ad.i("MicroMsg.GestureGalleryUI", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(bool) });
                  if (paramView != null) {
                    break label793;
                  }
                  ad.e("MicroMsg.GestureGalleryUI", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramViewGroup)));
                  paramView = null;
                  break;
                }
                label793:
                com.tencent.mm.aw.a.a.aIP().h(paramViewGroup + "_" + i.aYo(paramViewGroup), paramView);
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
                k = al.ci(GestureGalleryUI.this.getContext()).x;
                m = al.ci(GestureGalleryUI.this.getContext()).y;
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
              if (!t.aQj(paramViewGroup)) {
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
                ((a)localObject1).BjM.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((a)localObject1).teJ.setVisibility(8);
                ((a)localObject1).BjM.setVisibility(0);
                localObject2 = ((a)localObject1).BjM;
                ((MMAnimateView)localObject2).uzQ = GestureGalleryUI.f(GestureGalleryUI.this);
                ((MMAnimateView)localObject2).hh(paramViewGroup, null);
                AppMethodBeat.o(29090);
                return localView;
                k = 0;
              }
              catch (Exception paramViewGroup)
              {
                ad.e("MicroMsg.GestureGalleryUI", bt.n(paramViewGroup));
                ((a)localObject1).BjM.setVisibility(0);
                ((a)localObject1).teJ.setVisibility(8);
                ((a)localObject1).BjM.setImageBitmap(paramView);
                continue;
              }
              label1111:
              if ((i != 0) && (paramView != null) && (!paramView.isRecycled()))
              {
                ((a)localObject1).BjL.setVisibility(0);
                ((a)localObject1).teJ.setVisibility(0);
                ((a)localObject1).teJ.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((a)localObject1).teJ.setImageBitmap(paramView);
              }
              else if ((j != 0) && (paramView != null) && (!paramView.isRecycled()))
              {
                ((a)localObject1).BjL.setVisibility(8);
                ((a)localObject1).teJ.setVisibility(0);
                ((a)localObject1).teJ.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((a)localObject1).teJ.setImageBitmap(paramView);
              }
              else if ((paramView != null) && (!paramView.isRecycled()))
              {
                ((a)localObject1).BjM.setVisibility(8);
                ((a)localObject1).teJ.setVisibility(8);
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
                  com.tencent.mm.sdk.platformtools.q.A(paramViewGroup, paramView.getWidth(), paramView.getHeight());
                }
                label1368:
                ((a)localObject1).BjL.setVisibility(0);
                ((a)localObject1).BjM.setVisibility(8);
                ((a)localObject1).teJ.setVisibility(8);
                ((a)localObject1).tEo.setVisibility(8);
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
      ProgressBar BjL;
      MMAnimateView BjM;
      VideoView BjN;
      View BjO;
      TextView BjP;
      View tEo;
      ImageView teJ;
      ImageView zSR;
      
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
      ad.i("MicroMsg.GestureGalleryUI", "start run play progress task");
      for (;;)
      {
        if (this.isStop) {
          break label127;
        }
        try
        {
          if ((GestureGalleryUI.ac(GestureGalleryUI.this) == GestureGalleryUI.c.BjT) || (GestureGalleryUI.ac(GestureGalleryUI.this) == GestureGalleryUI.c.BjS) || (GestureGalleryUI.ac(GestureGalleryUI.this) == GestureGalleryUI.c.BjU))
          {
            GestureGalleryUI localGestureGalleryUI = GestureGalleryUI.this;
            if (localGestureGalleryUI.Bjk != null) {
              localGestureGalleryUI.Bjp.post(new GestureGalleryUI.24(localGestureGalleryUI));
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.GestureGalleryUI", "PlayProgressTask run exception:" + localException.getMessage());
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
      BjR = new c("Idle", 0);
      BjS = new c("Prepared", 1);
      BjT = new c("Start", 2);
      BjU = new c("Resume", 3);
      BjV = new c("Paused", 4);
      BjW = new c("Complete", 5);
      BjX = new c("Stop", 6);
      BjY = new c("Error", 7);
      BjZ = new c[] { BjR, BjS, BjT, BjU, BjV, BjW, BjX, BjY };
      AppMethodBeat.o(179722);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI
 * JD-Core Version:    0.7.0.1
 */