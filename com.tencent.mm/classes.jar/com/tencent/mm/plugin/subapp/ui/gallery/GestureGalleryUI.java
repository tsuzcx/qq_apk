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
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.g.a.to;
import com.tencent.mm.g.a.to.a;
import com.tencent.mm.g.b.a.ep;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.media.model.AppBrandMediaSource;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ag.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.tools.PressAlphaImageView;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
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
  implements ag.b, com.tencent.mm.plugin.scanner.word.a.a<String, com.tencent.mm.plugin.scanner.word.b>, a.a
{
  private float EAC;
  private int EAD;
  private int EAE;
  private int EqZ;
  private volatile String Eqk;
  private String Eqn;
  private String Eqo;
  private String Eqp;
  private String Eqq;
  private String Eqr;
  private IListener Eqy;
  private a FKY;
  MMGestureGallery FKZ;
  private long FLA;
  private c FLB;
  boolean FLC;
  private boolean FLD;
  private IListener<cf> FLE;
  private List<String> FLF;
  private List<AppBrandMediaSource> FLG;
  private int FLH;
  private int FLI;
  private String FLJ;
  private boolean FLK;
  private AdapterView.OnItemSelectedListener FLL;
  private View FLM;
  private b FLN;
  private int FLa;
  private String FLb;
  private ag FLc;
  private boolean FLd;
  private boolean FLe;
  private boolean FLf;
  private boolean FLg;
  private JSONArray FLh;
  private com.tencent.mm.ui.widget.a.e FLi;
  private volatile boolean FLj;
  private int FLk;
  private int FLl;
  private int FLm;
  private final Set<Integer> FLn;
  private final Set<Integer> FLo;
  private boolean FLp;
  private TextView FLq;
  private a FLr;
  private com.tencent.mm.plugin.webview.k.i FLs;
  private String FLt;
  GestureGalleryUI.a.a FLu;
  private boolean FLv;
  private RelativeLayout FLw;
  private RelativeLayout FLx;
  private PressAlphaImageView FLy;
  RedesignVideoPlayerSeekBar FLz;
  private boolean iAS;
  private String iCZ;
  private String iDk;
  private boolean isAnimated;
  private MMHandler mHandler;
  private ScanCodeSheetItemLogic mHu;
  private String msl;
  private long pLQ;
  private Bundle qaD;
  private com.tencent.mm.ui.tools.e qaE;
  private int qaF;
  private int qaG;
  private int qaH;
  private int qaI;
  private ImageView qaz;
  private boolean teC;
  private IListener teF;
  private int type;
  
  public GestureGalleryUI()
  {
    AppMethodBeat.i(29091);
    this.FLd = false;
    this.FLe = false;
    this.iCZ = "";
    this.iDk = null;
    this.FLf = false;
    this.FLg = true;
    this.FLh = null;
    this.EqZ = 0;
    this.FLn = new HashSet();
    this.FLo = new HashSet();
    this.FLp = false;
    this.isAnimated = false;
    this.qaF = 0;
    this.qaG = 0;
    this.qaH = 0;
    this.qaI = 0;
    this.mHandler = new MMHandler();
    this.FLt = "";
    this.iAS = false;
    this.FLv = false;
    this.pLQ = 0L;
    this.FLA = 0L;
    this.FLB = c.FMc;
    this.FLC = false;
    this.FLD = false;
    this.FLE = new GestureGalleryUI.10(this);
    this.FLF = new ArrayList();
    this.FLG = new ArrayList();
    this.type = 0;
    this.FLH = -1;
    this.FLI = -1;
    this.msl = null;
    this.FLJ = null;
    this.EAC = 1.0F;
    this.EAD = 0;
    this.EAE = 0;
    this.FLK = false;
    this.FLL = new AdapterView.OnItemSelectedListener()
    {
      VideoView FLR;
      
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(232082);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$16", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        GestureGalleryUI.f(GestureGalleryUI.this, paramAnonymousInt);
        GestureGalleryUI.I(GestureGalleryUI.this).setText(GestureGalleryUI.c(GestureGalleryUI.this) + 1 + "/" + GestureGalleryUI.m(GestureGalleryUI.this).getCount());
        GestureGalleryUI.this.setMMTitle(GestureGalleryUI.c(GestureGalleryUI.this) + 1 + " / " + GestureGalleryUI.J(GestureGalleryUI.this).size());
        Log.d("MicroMsg.GestureGalleryUI", "pos:".concat(String.valueOf(paramAnonymousInt)));
        GestureGalleryUI.c(GestureGalleryUI.this, (String)GestureGalleryUI.J(GestureGalleryUI.this).get(paramAnonymousInt));
        GestureGalleryUI.d(GestureGalleryUI.this, "");
        GestureGalleryUI.b(GestureGalleryUI.this, false);
        if (this.FLR != null)
        {
          this.FLR.stopPlayback();
          this.FLR = null;
        }
        GestureGalleryUI.K(GestureGalleryUI.this).setIsPlay(false);
        GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.c.FMc);
        if ((paramAnonymousView != null) && (paramAnonymousView.getTag() != null))
        {
          paramAnonymousAdapterView = (GestureGalleryUI.a.a)paramAnonymousView.getTag();
          if ((paramAnonymousAdapterView != null) && (GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousInt)))
          {
            this.FLR = paramAnonymousAdapterView.FLY;
            GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousAdapterView);
            paramAnonymousAdapterView.xgq.setVisibility(0);
            paramAnonymousAdapterView.EsM.setVisibility(0);
            paramAnonymousAdapterView.FLW.setVisibility(8);
            paramAnonymousAdapterView.FLZ.setVisibility(8);
          }
        }
        else
        {
          if (!GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousInt)) {
            break label459;
          }
          GestureGalleryUI.d(GestureGalleryUI.this, GestureGalleryUI.E(GestureGalleryUI.this));
          GestureGalleryUI.g(GestureGalleryUI.this, paramAnonymousInt);
        }
        for (;;)
        {
          Log.i("MicroMsg.GestureGalleryUI", "curFilename:%s", new Object[] { GestureGalleryUI.j(GestureGalleryUI.this) });
          GestureGalleryUI.l(GestureGalleryUI.this);
          GestureGalleryUI.a(GestureGalleryUI.this, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$16", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(232082);
          return;
          if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.xgq == null)) {
            break;
          }
          paramAnonymousAdapterView.xgq.setVisibility(8);
          break;
          label459:
          GestureGalleryUI.d(GestureGalleryUI.this, GestureGalleryUI.N(GestureGalleryUI.this).c((String)GestureGalleryUI.J(GestureGalleryUI.this).get(paramAnonymousInt), GestureGalleryUI.L(GestureGalleryUI.this), paramAnonymousInt, GestureGalleryUI.M(GestureGalleryUI.this)));
          if (Util.isNullOrNil(GestureGalleryUI.j(GestureGalleryUI.this))) {
            GestureGalleryUI.d(GestureGalleryUI.this, (String)GestureGalleryUI.J(GestureGalleryUI.this).get(paramAnonymousInt));
          }
          GestureGalleryUI.g(GestureGalleryUI.this, paramAnonymousInt);
          if ((GestureGalleryUI.O(GestureGalleryUI.this) != null) && (GestureGalleryUI.P(GestureGalleryUI.this) != null) && (GestureGalleryUI.P(GestureGalleryUI.this).length() > GestureGalleryUI.Q(GestureGalleryUI.this))) {
            if (GestureGalleryUI.P(GestureGalleryUI.this).optJSONObject(GestureGalleryUI.Q(GestureGalleryUI.this)).has("jumpType")) {
              GestureGalleryUI.O(GestureGalleryUI.this).setVisibility(0);
            } else {
              GestureGalleryUI.O(GestureGalleryUI.this).setVisibility(8);
            }
          }
        }
      }
      
      public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    };
    this.teF = new IListener() {};
    this.Eqy = new GestureGalleryUI.11(this);
    AppMethodBeat.o(29091);
  }
  
  private boolean abl(int paramInt)
  {
    AppMethodBeat.i(232102);
    if ((this.FLG != null) && (this.FLG.size() > paramInt) && (this.FLG.get(paramInt) != null) && ("video".endsWith(((AppBrandMediaSource)this.FLG.get(paramInt)).igV)))
    {
      AppMethodBeat.o(232102);
      return true;
    }
    AppMethodBeat.o(232102);
    return false;
  }
  
  private void cWX()
  {
    AppMethodBeat.i(179724);
    Log.i("MicroMsg.GestureGalleryUI", "pauseVideo");
    if (this.FLu != null)
    {
      this.FLA = (this.FLz.getmPosition() * 1000);
      Log.i("MicroMsg.GestureGalleryUI", "pauseVideo currentVideoPos：%d", new Object[] { Long.valueOf(this.FLA) });
      this.FLu.FLY.pause();
      this.FLu.EsM.setVisibility(0);
      if ((this.FLB != c.FMe) && (this.FLB != c.FMf)) {
        break label133;
      }
      this.FLB = c.FMg;
      this.FLC = true;
    }
    for (;;)
    {
      this.FLz.setIsPlay(false);
      fto();
      AppMethodBeat.o(179724);
      return;
      label133:
      c localc = c.FMg;
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
  
  private boolean ftl()
  {
    AppMethodBeat.i(169766);
    if ((this.FLj) && (!Util.isNullOrNil(this.Eqn)))
    {
      AppMethodBeat.o(169766);
      return true;
    }
    AppMethodBeat.o(169766);
    return false;
  }
  
  private String ftm()
  {
    AppMethodBeat.i(179723);
    if ((this.FLH < 0) || (this.FLG == null) || (this.FLG.size() == 0))
    {
      AppMethodBeat.o(179723);
      return "";
    }
    String str = ((AppBrandMediaSource)this.FLG.get(this.FLH)).url;
    Log.i("MicroMsg.GestureGalleryUI", "playVideo  url :%s", new Object[] { str });
    if ((str != null) && (str.startsWith("http")))
    {
      Object localObject;
      if (com.tencent.mm.plugin.z.a.GwW == null)
      {
        localObject = new File(com.tencent.mm.loader.j.b.aLA());
        if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
          ((File)localObject).mkdir();
        }
        localObject = new HttpProxyCacheServer.Builder(this).maxCacheSize(134217728L).cacheDirectory((File)localObject).build();
        com.tencent.mm.plugin.z.a.GwW = (HttpProxyCacheServer)localObject;
      }
      for (;;)
      {
        localObject = ((HttpProxyCacheServer)localObject).getProxyUrl(str);
        AppMethodBeat.o(179723);
        return localObject;
        localObject = com.tencent.mm.plugin.z.a.GwW;
      }
    }
    AppMethodBeat.o(179723);
    return str;
  }
  
  private void ftn()
  {
    AppMethodBeat.i(179725);
    fto();
    this.FLN = new b((byte)0);
    b localb = this.FLN;
    localb.isStop = false;
    ThreadPool.post(localb, "gesture_gallery_ui_video_update_progress");
    AppMethodBeat.o(179725);
  }
  
  private void fto()
  {
    if (this.FLN != null) {
      this.FLN.isStop = true;
    }
  }
  
  private void wd(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(29102);
    if (this.FLi == null) {
      this.FLi = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
    }
    this.FLi.HLX = new o.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
      {
        AppMethodBeat.i(29085);
        GestureGalleryUI.a(GestureGalleryUI.this).setFooterView(null);
        paramAnonymousm.clear();
        Object localObject;
        ep localep;
        if (!GestureGalleryUI.p(GestureGalleryUI.this))
        {
          paramAnonymousm.kV(1, 2131764184);
          if (GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.c(GestureGalleryUI.this)))
          {
            paramAnonymousm.kV(2, 2131764871);
            paramAnonymousm.kV(3, 2131763947);
          }
        }
        else if ((GestureGalleryUI.q(GestureGalleryUI.this)) && (!Util.isNullOrNil(GestureGalleryUI.j(GestureGalleryUI.this))))
        {
          paramAnonymousm.kV(4, 2131757389);
          localObject = GestureGalleryUI.e(GestureGalleryUI.this);
          localep = new ep();
          if (((a)localObject).tgN != 2) {
            break label244;
          }
          l = 1L;
          label132:
          localep.erW = l;
          localep.ejA = 2L;
          if (!((a)localObject).FKU) {
            break label249;
          }
        }
        label244:
        label249:
        for (long l = 6L;; l = 5L)
        {
          localep.eDV = l;
          localep.bfK();
          if (!GestureGalleryUI.r(GestureGalleryUI.this)) {
            break label266;
          }
          localObject = GestureGalleryUI.s(GestureGalleryUI.this);
          GestureGalleryUI.a(GestureGalleryUI.this).setFooterView((View)localObject);
          if (!(localObject instanceof ViewTitleWithAnimation)) {
            break label266;
          }
          if (paramAnonymousm.size() <= 1) {
            break label256;
          }
          ((ViewTitleWithAnimation)localObject).setTopPaddingVisibility(0);
          AppMethodBeat.o(29085);
          return;
          paramAnonymousm.kV(2, 2131764866);
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
    this.FLi.HLY = new o.g()
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
          } while (!WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(GestureGalleryUI.this.getContext()));
          GestureGalleryUI.d(GestureGalleryUI.this, 6);
          paramAnonymousMenuItem = GestureGalleryUI.e(GestureGalleryUI.this);
          localObject1 = paramAnonymousMenuItem.FKT.cVV();
        } while (((paramAnonymousMenuItem.tgN != 0) && (paramAnonymousMenuItem.tgN != 2)) || (Util.isNullOrNil((String)localObject1)));
        Object localObject2 = new ep();
        long l;
        if (paramAnonymousMenuItem.tgN == 2)
        {
          l = 1L;
          ((ep)localObject2).erW = l;
          ((ep)localObject2).ejA = 3L;
          if (!paramAnonymousMenuItem.FKU) {
            break label418;
          }
          l = 6L;
          label204:
          ((ep)localObject2).eDV = l;
          ((ep)localObject2).bfK();
          paramAnonymousMenuItem.tgM = ((int)(com.tencent.mm.model.z.aTY().hashCode() + System.currentTimeMillis()));
          localObject2 = ((com.tencent.mm.plugin.scanner.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.scanner.e.class)).getTranslationResult((String)localObject1);
          if ((localObject2 == null) || (!com.tencent.mm.vfs.s.YS(((fx)localObject2).field_resultFile))) {
            break label430;
          }
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("original_file_path", (String)localObject1);
          if (!paramAnonymousMenuItem.FKU) {
            break label425;
          }
        }
        label418:
        label425:
        for (paramAnonymousInt = 6;; paramAnonymousInt = 5)
        {
          ((Intent)localObject2).putExtra("translate_source", paramAnonymousInt);
          ((Intent)localObject2).setClass(paramAnonymousMenuItem.activity, TranslationResultUI.class);
          localObject1 = paramAnonymousMenuItem.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.activity.finish();
          paramAnonymousMenuItem.activity.overridePendingTransition(2130771986, 2130771986);
          AppMethodBeat.o(29066);
          return;
          l = 0L;
          break;
          l = 5L;
          break label204;
        }
        label430:
        label475:
        to.a locala;
        if ((com.tencent.mm.kernel.g.azz().aYS() != 6) && (com.tencent.mm.kernel.g.azz().aYS() != 4))
        {
          h.c(paramAnonymousMenuItem.activity, paramAnonymousMenuItem.activity.getString(2131755914), "", true);
          paramAnonymousMenuItem.cWh();
          Log.i("MicroMsg.GestureGalleryTransLogic", "try to translate img %s, sessionId %d", new Object[] { localObject1, Integer.valueOf(paramAnonymousMenuItem.tgM) });
          localObject2 = new to();
          locala = ((to)localObject2).dZY;
          if (!paramAnonymousMenuItem.FKU) {
            break label621;
          }
        }
        for (;;)
        {
          locala.scene = paramAnonymousInt;
          ((to)localObject2).dZY.filePath = ((String)localObject1);
          ((to)localObject2).dZY.dEb = paramAnonymousMenuItem.tgM;
          EventCenter.instance.publish((IEvent)localObject2);
          break;
          paramAnonymousMenuItem.tgN = 1;
          paramAnonymousMenuItem.tgP.setVisibility(0);
          paramAnonymousMenuItem.tgQ.setVisibility(0);
          paramAnonymousMenuItem.tgR.setVisibility(0);
          paramAnonymousMenuItem.tgS.setRepeatMode(1);
          paramAnonymousMenuItem.tgS.setRepeatCount(-1);
          paramAnonymousMenuItem.tgS.start();
          break label475;
          label621:
          paramAnonymousInt = 5;
        }
      }
    };
    this.FLi.PGl = new e.b()
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
        GestureGalleryUI.D(GestureGalleryUI.this);
        AppMethodBeat.o(29067);
      }
    };
    if (!getContext().isFinishing()) {
      if ((!this.iAS) || (ftl()) || (this.teC)) {
        break label273;
      }
    }
    Object localObject;
    String str;
    for (;;)
    {
      if (i != 0) {
        this.FLi.dGm();
      }
      if ((this.FLj) && (Util.isNullOrNil(this.Eqn)) && (bg.azz().aYS() != 0))
      {
        localObject = new qx();
        ((qx)localObject).dXu.dDZ = System.currentTimeMillis();
        ((qx)localObject).dXu.filePath = this.FLb;
        ((qx)localObject).dXu.dXv = new HashSet(this.FLn);
        this.Eqk = this.FLb;
        EventCenter.instance.publish((IEvent)localObject);
      }
      if (Util.isNullOrNil(this.FLb)) {
        break label315;
      }
      com.tencent.mm.kernel.g.aAi();
      if ((com.tencent.mm.kernel.g.aAg().hqi.aYS() == 0) || (!paramBoolean)) {
        break label315;
      }
      localObject = this.FLr;
      str = this.FLb;
      if ((((a)localObject).activity != null) && (!((a)localObject).activity.isFinishing())) {
        break;
      }
      AppMethodBeat.o(29102);
      return;
      label273:
      i = 1;
    }
    if (((a)localObject).tgL == null) {
      ((a)localObject).tgL = new ImageWordScanDetailEngine(((a)localObject).activity);
    }
    ((a)localObject).tgL.a(str, ((a)localObject).tgK);
    label315:
    AppMethodBeat.o(29102);
  }
  
  private void xV(int paramInt)
  {
    AppMethodBeat.i(232101);
    if ((this.FLs == null) || (Util.isNullOrNil(this.FLJ)))
    {
      AppMethodBeat.o(232101);
      return;
    }
    this.FLs.url = this.FLJ;
    this.FLs.ehX = this.FLm;
    if (!Util.isNullOrNil(this.Eqn))
    {
      this.FLs.JBD = true;
      this.FLs.ahn(this.FLk);
      this.FLs.scanResult = this.Eqn;
    }
    String str = com.tencent.mm.pluginsdk.ui.tools.z.bfG(this.FLt);
    this.FLs.zfq = str;
    this.FLs.pl(paramInt);
    AppMethodBeat.o(232101);
  }
  
  public final String cVV()
  {
    return this.FLb;
  }
  
  public final void cvQ()
  {
    AppMethodBeat.i(29100);
    if ((this.FKZ.getSelectedItemPosition() != this.FLI) || (!this.FLp))
    {
      finish();
      overridePendingTransition(0, 0);
      AppMethodBeat.o(29100);
      return;
    }
    if ((this.FLK) || (this.FKY == null))
    {
      Log.i("MicroMsg.GestureGalleryUI", "isRunningExitAnimation");
      AppMethodBeat.o(29100);
      return;
    }
    Log.i("MicroMsg.GestureGalleryUI", "runExitAnimation");
    int k = this.FKZ.getWidth();
    int i = this.FKZ.getHeight();
    int j = this.FKZ.getSelectedItemPosition();
    Object localObject = (String)this.FLF.get(j);
    if (com.tencent.mm.vfs.s.YS((String)localObject))
    {
      if (Util.isNullOrNil((String)localObject)) {
        break label412;
      }
      localObject = BitmapUtil.getImageOptions((String)localObject);
      float f = k / ((BitmapFactory.Options)localObject).outWidth;
      j = (int)(((BitmapFactory.Options)localObject).outHeight * f);
      i = j;
      if (j > this.FKZ.getHeight())
      {
        if (j < this.FKZ.getHeight() * 2.5D) {
          this.qaI = (this.FKZ.getHeight() * this.qaI / j);
        }
        i = this.FKZ.getHeight();
      }
    }
    label412:
    for (;;)
    {
      this.qaE.ls(k, i);
      this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
      if (this.EAC != 1.0D)
      {
        this.qaE.QtG = (1.0F / this.EAC);
        if ((this.EAD != 0) || (this.EAE != 0))
        {
          j = (int)(this.FKZ.getWidth() / 2 * (1.0F - this.EAC));
          k = this.EAD;
          i = (int)(this.FKZ.getHeight() / 2 + this.EAE - i / 2 * this.EAC);
          this.qaE.lu(j + k, i);
        }
      }
      this.qaE.a(this.FKZ, this.qaz, new e.c()
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
              View localView = GestureGalleryUI.m(GestureGalleryUI.this).ftp();
              if ((localView instanceof MultiTouchImageView)) {
                ((MultiTouchImageView)localView).gKy();
              }
              AppMethodBeat.o(29079);
            }
          }, 20L);
          AppMethodBeat.o(29081);
        }
      }, null);
      AppMethodBeat.o(29100);
      return;
      localObject = this.FLc.c((String)localObject, this.type, j, this.iDk);
      break;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29101);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.GestureGalleryUI", "dispatchKeyEvent");
      cvQ();
      AppMethodBeat.o(29101);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(29101);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2131496033;
  }
  
  public final void i(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(29092);
    if (this.FKY != null)
    {
      if (paramInt == this.FKZ.getSelectedItemPosition())
      {
        this.FLb = paramString2;
        this.FLa = paramInt;
        Log.d("MicroMsg.GestureGalleryUI", "onDownSucc, curFilename:%s, url:%s", new Object[] { this.FLb, paramString1 });
      }
      this.FKY.notifyDataSetChanged();
    }
    AppMethodBeat.o(29092);
  }
  
  public void initView()
  {
    AppMethodBeat.i(29098);
    String str1 = Util.nullAsNil(getIntent().getStringExtra("nowUrl"));
    this.msl = Util.nullAsNil(getIntent().getStringExtra("nowUrlPath"));
    this.FLJ = Util.nullAsNil(getIntent().getStringExtra("nowWebUrl"));
    this.type = getIntent().getIntExtra("type", 0);
    Object localObject = getIntent().getParcelableArrayListExtra("mediaSource");
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.FLG.clear();
      this.FLG.addAll((Collection)localObject);
    }
    localObject = getIntent().getStringArrayExtra("urlList");
    final int i;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = Util.nullAsNil(getIntent().getStringExtra("htmlData"));
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
          Log.d("MicroMsg.GestureGalleryUI", "start:" + j + " end:" + i + " url:" + str2);
          this.FLF.add(str2);
          continue;
          this.FLF = Arrays.asList((Object[])localObject);
        }
      }
    }
    localObject = getIntent().getStringExtra("pageInfos");
    if (!Util.isNullOrNil((String)localObject)) {}
    try
    {
      this.FLh = new JSONArray((String)localObject);
      label302:
      i = 0;
      for (;;)
      {
        if (i < this.FLF.size())
        {
          if (str1.equals(this.FLF.get(i))) {
            this.FLH = i;
          }
        }
        else
        {
          this.FLI = this.FLH;
          if (getIntent().getIntExtra("currentPos", -1) >= 0) {
            this.FLI = getIntent().getIntExtra("currentPos", -1);
          }
          setBackBtn(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(29074);
              GestureGalleryUI.this.cvQ();
              AppMethodBeat.o(29074);
              return true;
            }
          });
          this.FLq = ((TextView)findViewById(2131305770));
          this.qaz = ((ImageView)findViewById(2131301854));
          this.FLx = ((RelativeLayout)findViewById(2131309838));
          this.FLz = ((RedesignVideoPlayerSeekBar)findViewById(2131309804));
          this.FLy = ((PressAlphaImageView)findViewById(2131309735));
          this.FLy.setOnClickListener(new GestureGalleryUI.15(this));
          this.FLz.setPlayBtnOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(232090);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              if (GestureGalleryUI.K(GestureGalleryUI.this).cEF()) {
                GestureGalleryUI.aa(GestureGalleryUI.this);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(232090);
                return;
                GestureGalleryUI.ab(GestureGalleryUI.this);
              }
            }
          });
          this.FLz.setVideoTotalTime(0);
          this.FLz.seek(0);
          this.FLz.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
          {
            public final void aJq() {}
            
            public final void rk(int paramAnonymousInt)
            {
              AppMethodBeat.i(232091);
              if (GestureGalleryUI.ac(GestureGalleryUI.this) != null) {
                GestureGalleryUI.ac(GestureGalleryUI.this).FLY.seekTo(paramAnonymousInt * 1000);
              }
              AppMethodBeat.o(232091);
            }
          });
          this.FKY = new a();
          this.FKZ = ((MMGestureGallery)findViewById(2131301853));
          this.FKZ.setVisibility(0);
          this.FKZ.setVerticalFadingEdgeEnabled(false);
          this.FKZ.setHorizontalFadingEdgeEnabled(false);
          this.FKZ.setAdapter(this.FKY);
          this.FKZ.setSelection(this.FLH);
          this.FKZ.setOnItemSelectedListener(this.FLL);
          this.FKZ.setSingleClickOverListener(new MMGestureGallery.f()
          {
            public final void bmt()
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
                if (GestureGalleryUI.e(GestureGalleryUI.this).tgN != 1) {
                  GestureGalleryUI.this.cvQ();
                }
                AppMethodBeat.o(29075);
                return;
              }
            }
          });
          i = getIntent().getIntExtra("nevNext", 1);
          this.FKZ.setLongClickOverListener(new MMGestureGallery.c()
          {
            public final void bmu()
            {
              boolean bool2 = true;
              AppMethodBeat.i(29077);
              if (GestureGalleryUI.e(GestureGalleryUI.this).tgN == 1)
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
              GestureGalleryUI.a(GestureGalleryUI.this, new com.tencent.mm.plugin.webview.k.i());
              GestureGalleryUI.h(GestureGalleryUI.this).reset(2);
              Object localObject1;
              if (1 == i)
              {
                localObject1 = ad.aVe().G("basescanui@datacenter", true);
                ((ad.b)localObject1).l("key_basescanui_screen_position", Boolean.TRUE);
                ((ad.b)localObject1).l("key_basescanui_screen_x", Float.valueOf(GestureGalleryUI.i(GestureGalleryUI.this).getXDown()));
                ((ad.b)localObject1).l("key_basescanui_screen_y", Float.valueOf(GestureGalleryUI.i(GestureGalleryUI.this).getYDown()));
                if ((GestureGalleryUI.e(GestureGalleryUI.this).tgN == 0) || (GestureGalleryUI.e(GestureGalleryUI.this).tgN == 2))
                {
                  localObject1 = GestureGalleryUI.e(GestureGalleryUI.this);
                  Object localObject2 = new ep();
                  if (((a)localObject1).tgN == 2)
                  {
                    l = 1L;
                    ((ep)localObject2).erW = l;
                    ((ep)localObject2).ejA = 1L;
                    if (!((a)localObject1).FKU) {
                      break label299;
                    }
                  }
                  label280:
                  label299:
                  for (long l = 6L;; l = 5L)
                  {
                    ((ep)localObject2).eDV = l;
                    ((ep)localObject2).bfK();
                    localObject1 = GestureGalleryUI.this;
                    if (com.tencent.mm.plugin.scanner.i.eOO()) {
                      break label307;
                    }
                    Log.i("MicroMsg.ScannerHelper", "Word Detect Closed");
                    bool1 = false;
                    GestureGalleryUI.c((GestureGalleryUI)localObject1, bool1);
                    AppMethodBeat.o(29077);
                    return;
                    l = 0L;
                    break;
                  }
                  label307:
                  int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("EnableWebviewPicTranslation", 0);
                  localObject2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("PicTranslationSupportUserLanguage");
                  if (i == 1) {}
                  for (boolean bool1 = true;; bool1 = false)
                  {
                    Log.i("MicroMsg.ScannerHelper", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool1), localObject2, LocaleUtil.getApplicationLanguage() });
                    if ((i == 1) && (!Util.isNullOrNil((String)localObject2)))
                    {
                      localObject2 = ((String)localObject2).split(";");
                      if (localObject2 != null)
                      {
                        bool1 = bool2;
                        if (Arrays.asList((Object[])localObject2).contains(LocaleUtil.getApplicationLanguage())) {
                          break label280;
                        }
                      }
                    }
                    if (!com.tencent.mm.protocal.d.KyS) {
                      break;
                    }
                    bool1 = bool2;
                    break label280;
                  }
                }
                GestureGalleryUI.b(GestureGalleryUI.this);
                AppMethodBeat.o(29077);
                return;
              }
              if (2 == i)
              {
                localObject1 = GestureGalleryUI.this.getContext().getResources().getStringArray(2130903085);
                h.b(GestureGalleryUI.this, null, (String[])localObject1, "", new h.d()
                {
                  public final void oj(int paramAnonymous2Int)
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
                      com.tencent.mm.plugin.subapp.b.jRt.k(localIntent, localGestureGalleryUI.getContext());
                    }
                  }
                });
              }
              AppMethodBeat.o(29077);
            }
          });
          this.qaE = new com.tencent.mm.ui.tools.e(this);
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
      final Runnable local25;
      label82:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        local25 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(232098);
            this.tcT.dismiss();
            AppMethodBeat.o(232098);
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
        String str1 = ((AppBrandMediaSource)this.FLG.get(this.FLH)).igW;
        localObject = str1;
        if (!com.tencent.mm.vfs.s.YS(str1)) {
          localObject = this.FLc.c(str1, this.type, this.FLH, this.iDk);
        }
        Log.i("MicroMsg.GestureGalleryUI", "onActivityResult,  sendVideo video:%s,  thumbFilename:%s", new Object[] { ftm(), localObject });
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(232099);
            com.tencent.mm.plugin.messenger.a.g.eir().a(GestureGalleryUI.this.getContext(), str2, GestureGalleryUI.E(GestureGalleryUI.this), this.FLS, 1, (int)GestureGalleryUI.ad(GestureGalleryUI.this), "", "");
            MMHandlerThread.postToMainThread(local25);
            AppMethodBeat.o(232099);
          }
          
          public final String toString()
          {
            AppMethodBeat.i(232100);
            String str = super.toString() + "send video";
            AppMethodBeat.o(232100);
            return str;
          }
        });
        if (!Util.isNullOrNil(paramIntent)) {
          com.tencent.mm.plugin.messenger.a.g.eir().ad(str2, paramIntent, ab.JG(str2));
        }
      }
      com.tencent.mm.ui.widget.snackbar.b.r(this, getString(2131760708));
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
    this.qaD = paramBundle;
    this.FLE.alive();
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setFlags(1024, 1024);
      getWindow().addFlags(67108864);
    }
    fullScreenNoTitleBar(true);
    this.FLf = getIntent().getBooleanExtra("isFromAppBrand", false);
    this.FLD = getIntent().getBooleanExtra("isFromAppBrandMpWebView", false);
    this.iAS = getIntent().getBooleanExtra("forBidForward", false);
    this.FLd = getIntent().getBooleanExtra("isFromWebView", false);
    this.FLg = getIntent().getBooleanExtra("showmenu", true);
    this.FLe = getIntent().getBooleanExtra("isOuntLink", false);
    this.iCZ = getIntent().getStringExtra("IsFromWebViewReffer");
    this.FLj = getIntent().getBooleanExtra("shouldShowScanQrCodeMenu", false);
    this.FLp = getIntent().getBooleanExtra("shouldRunDragAnimation", false);
    this.FLm = getIntent().getIntExtra("scanQrCodeGetA8KeyScene", 0);
    paramBundle = getIntent().getIntArrayExtra("scanCodeTypes");
    int i;
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      i = 0;
      while (i < paramBundle.length)
      {
        this.FLn.add(Integer.valueOf(paramBundle[i]));
        i += 1;
      }
    }
    paramBundle = getIntent().getIntArrayExtra("scanResultCodeTypes");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      i = 0;
      while (i < paramBundle.length)
      {
        this.FLo.add(Integer.valueOf(paramBundle[i]));
        i += 1;
      }
    }
    this.FLr = new a(this, this, this, this.FLe);
    this.iDk = getIntent().getStringExtra("cookie");
    Log.d("MicroMsg.GestureGalleryUI", "isFromWebView: %b, isFromWebViewReffer:%s, cookie = %s, forbidForward=%b", new Object[] { Boolean.valueOf(this.FLd), this.iCZ, this.iDk, Boolean.valueOf(this.iAS) });
    this.FLc = new ag(this.FLd, this.iCZ);
    paramBundle = this.FLc;
    Log.d("MicroMsg.GetPicService", "addListener :" + hashCode());
    paramBundle.iDb = this;
    EventCenter.instance.addListener(this.teF);
    EventCenter.instance.addListener(this.Eqy);
    initView();
    this.FLK = false;
    if (this.FLf) {
      getWindow().setBackgroundDrawableResource(2131231381);
    }
    this.mHu = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a()
    {
      public final void bLz()
      {
        AppMethodBeat.i(29065);
        if ((GestureGalleryUI.a(GestureGalleryUI.this) != null) && (GestureGalleryUI.a(GestureGalleryUI.this).isShowing())) {
          GestureGalleryUI.b(GestureGalleryUI.this);
        }
        AppMethodBeat.o(29065);
      }
    });
    this.FLw = ((RelativeLayout)findViewById(2131302538));
    if (this.FLh != null)
    {
      this.FLM = findViewById(2131308312);
      this.FLw.setVisibility(0);
      ((TextView)findViewById(2131306569)).setTextSize(1, 12.0F);
      this.FLM.setOnClickListener(new GestureGalleryUI.12(this));
      findViewById(2131302587).setOnClickListener(new GestureGalleryUI.13(this));
      findViewById(2131299750).setOnClickListener(new GestureGalleryUI.14(this));
      AppMethodBeat.o(29093);
      return;
    }
    this.FLw.setVisibility(8);
    AppMethodBeat.o(29093);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29094);
    super.onDestroy();
    Object localObject = this.FLc;
    Log.d("MicroMsg.GetPicService", "removeListener :" + hashCode());
    ((ag)localObject).iDb = null;
    localObject = this.FLc;
    if (((ag)localObject).iCX != null) {
      ((ag)localObject).iCX.iDf = true;
    }
    ((ag)localObject).iCX = null;
    EventCenter.instance.removeListener(this.teF);
    EventCenter.instance.removeListener(this.Eqy);
    this.FLE.dead();
    fixInputMethodManagerLeak(this);
    if (this.FLr != null)
    {
      localObject = this.FLr;
      ((a)localObject).cWj();
      ((a)localObject).tgS.removeAllUpdateListeners();
      ((a)localObject).tgT.dead();
      com.tencent.mm.kernel.g.aAg().b(((a)localObject).tgU);
      ((a)localObject).tgK = null;
      ((a)localObject).activity = null;
      ((a)localObject).FKT = null;
    }
    localObject = new rl();
    ((rl)localObject).dYc.activity = this;
    EventCenter.instance.publish((IEvent)localObject);
    Log.i("MicroMsg.GestureGalleryUI", "stopVideo");
    if (this.FLu != null)
    {
      this.FLu.FLY.stopPlayback();
      this.FLB = c.FMi;
      this.FLz.setIsPlay(false);
      this.FLz.setIplaySeekCallback(null);
      this.FLu.EsM.setVisibility(0);
      this.FLu.wCz.setVisibility(0);
      this.FLu.FLY.setVisibility(8);
    }
    fto();
    AppMethodBeat.o(29094);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29095);
    super.onPause();
    cWX();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(2048, 2048);
    }
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    AppMethodBeat.o(29095);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29096);
    super.onResume();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().clearFlags(2048);
    }
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    AppMethodBeat.o(29096);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(29099);
    Bundle localBundle = this.qaD;
    if ((this.isAnimated) || (!this.FLp)) {}
    for (;;)
    {
      super.onStart();
      AppMethodBeat.o(29099);
      return;
      this.isAnimated = true;
      this.qaF = getIntent().getIntExtra("img_gallery_top", 0);
      this.qaG = getIntent().getIntExtra("img_gallery_left", 0);
      this.qaH = getIntent().getIntExtra("img_gallery_width", 0);
      this.qaI = getIntent().getIntExtra("img_gallery_height", 0);
      this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
      if (localBundle == null) {
        this.FKZ.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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
    if (this.Eqn != null)
    {
      aw localaw = new aw();
      localaw.dDW.activity = this;
      localaw.dDW.dDX = this.Eqn;
      EventCenter.instance.publish(localaw);
      this.Eqn = null;
      this.FLl = 0;
      this.FLk = 0;
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
    
    private View abm(int paramInt)
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
    
    public final View ftp()
    {
      AppMethodBeat.i(29088);
      View localView = abm(GestureGalleryUI.this.FKZ.getSelectedItemPosition());
      AppMethodBeat.o(29088);
      return localView;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(29086);
      Log.d("MicroMsg.GestureGalleryUI", "lstpicurl:" + GestureGalleryUI.J(GestureGalleryUI.this).size());
      int i = GestureGalleryUI.J(GestureGalleryUI.this).size();
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
      if ((GestureGalleryUI.R(GestureGalleryUI.this) != null) && (!GestureGalleryUI.R(GestureGalleryUI.this).isEmpty()) && (GestureGalleryUI.R(GestureGalleryUI.this).size() > paramInt)) {}
      for (Object localObject2 = (AppBrandMediaSource)GestureGalleryUI.R(GestureGalleryUI.this).get(paramInt);; localObject2 = null)
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
        if ((paramView == null) || ((i != 0) && (paramViewGroup != null) && (paramViewGroup.FLY == null)))
        {
          localObject1 = new a();
          localView = View.inflate(GestureGalleryUI.this, 2131496034, null);
          ((a)localObject1).FLW = ((ProgressBar)localView.findViewById(2131306302));
          ((a)localObject1).FLX = ((MMAnimateView)localView.findViewById(2131302526));
          ((a)localObject1).wCz = ((ImageView)localView.findViewById(2131309068));
          ((a)localObject1).xgq = localView.findViewById(2131309738);
          ((a)localObject1).FLY = ((VideoView)localView.findViewById(2131309841));
          ((a)localObject1).EsM = ((ImageView)localView.findViewById(2131309844));
          ((a)localObject1).FLZ = localView.findViewById(2131309763);
          ((a)localObject1).FMa = ((TextView)localView.findViewById(2131309764));
          if (i != 0)
          {
            ((a)localObject1).wCz.setVisibility(8);
            ((a)localObject1).wCz = ((ImageView)localView.findViewById(2131309773));
          }
          localView.setTag(localObject1);
        }
        for (;;)
        {
          localView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
          paramView = (String)GestureGalleryUI.J(GestureGalleryUI.this).get(paramInt);
          int k = 0;
          j = i;
          if (i != 0)
          {
            paramView = ((AppBrandMediaSource)localObject2).igW;
            j = 1;
          }
          paramViewGroup = paramView;
          if (!com.tencent.mm.vfs.s.YS(paramView))
          {
            paramView = GestureGalleryUI.N(GestureGalleryUI.this).c(paramView, GestureGalleryUI.L(GestureGalleryUI.this), paramInt, GestureGalleryUI.M(GestureGalleryUI.this));
            paramViewGroup = paramView;
            if (paramInt == GestureGalleryUI.S(GestureGalleryUI.this))
            {
              paramViewGroup = paramView;
              if (Util.isNullOrNil(paramView))
              {
                paramViewGroup = paramView;
                if (com.tencent.mm.vfs.s.YS(GestureGalleryUI.T(GestureGalleryUI.this))) {
                  paramViewGroup = GestureGalleryUI.T(GestureGalleryUI.this);
                }
              }
            }
          }
          for (i = 1;; i = k)
          {
            ((a)localObject1).FLY.setVisibility(8);
            ((a)localObject1).FLY.stopPlayback();
            if (j != 0)
            {
              ((a)localObject1).xgq.setVisibility(0);
              GestureGalleryUI.b(GestureGalleryUI.this, (a)localObject1);
              if (Util.isNullOrNil(paramViewGroup)) {
                break label1368;
              }
              ((a)localObject1).FLW.setVisibility(8);
              if ((GestureGalleryUI.R(GestureGalleryUI.this) != null) && (!GestureGalleryUI.R(GestureGalleryUI.this).isEmpty())) {
                TextUtils.isEmpty(((AppBrandMediaSource)GestureGalleryUI.R(GestureGalleryUI.this).get(paramInt)).igW);
              }
              if (paramViewGroup != null) {
                break label600;
              }
              paramView = null;
            }
            for (;;)
            {
              if ((!GestureGalleryUI.U(GestureGalleryUI.this)) || ((paramView != null) && (!paramView.isRecycled()))) {
                break label830;
              }
              GestureGalleryUI.this.finish();
              AppMethodBeat.o(29090);
              return localView;
              ((a)localObject1).xgq.setVisibility(8);
              break;
              label600:
              localObject2 = com.tencent.mm.av.a.a.bdb().OQ(paramViewGroup + "_" + com.tencent.mm.vfs.s.boW(paramViewGroup));
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
                        break label787;
                      }
                    }
                  }
                }
                label787:
                for (boolean bool = true;; bool = false)
                {
                  Log.i("MicroMsg.GestureGalleryUI", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(bool) });
                  if (paramView != null) {
                    break label793;
                  }
                  Log.e("MicroMsg.GestureGalleryUI", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramViewGroup)));
                  paramView = null;
                  break;
                }
                label793:
                com.tencent.mm.av.a.a.bdb().h(paramViewGroup + "_" + com.tencent.mm.vfs.s.boW(paramViewGroup), paramView);
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
                k = ao.az(GestureGalleryUI.this.getContext()).x;
                m = ao.az(GestureGalleryUI.this.getContext()).y;
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
              if (!ImgUtil.isGif(paramViewGroup)) {
                break label1111;
              }
              if (paramInt == GestureGalleryUI.S(GestureGalleryUI.this)) {
                GestureGalleryUI.V(GestureGalleryUI.this);
              }
            }
            label1353:
            for (;;)
            {
              try
              {
                ((a)localObject1).FLX.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((a)localObject1).wCz.setVisibility(8);
                ((a)localObject1).FLX.setVisibility(0);
                localObject2 = ((a)localObject1).FLX;
                ((MMAnimateView)localObject2).ydP = GestureGalleryUI.f(GestureGalleryUI.this);
                ((MMAnimateView)localObject2).hV(paramViewGroup, null);
                AppMethodBeat.o(29090);
                return localView;
                k = 0;
              }
              catch (Exception paramViewGroup)
              {
                Log.e("MicroMsg.GestureGalleryUI", Util.stackTraceToString(paramViewGroup));
                ((a)localObject1).FLX.setVisibility(0);
                ((a)localObject1).wCz.setVisibility(8);
                ((a)localObject1).FLX.setImageBitmap(paramView);
                continue;
              }
              label1111:
              if ((i != 0) && (paramView != null) && (!paramView.isRecycled()))
              {
                ((a)localObject1).FLW.setVisibility(0);
                ((a)localObject1).wCz.setVisibility(0);
                ((a)localObject1).wCz.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((a)localObject1).wCz.setImageBitmap(paramView);
              }
              else if ((j != 0) && (paramView != null) && (!paramView.isRecycled()))
              {
                ((a)localObject1).FLW.setVisibility(8);
                ((a)localObject1).wCz.setVisibility(0);
                ((a)localObject1).wCz.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((a)localObject1).wCz.setImageBitmap(paramView);
              }
              else if ((paramView != null) && (!paramView.isRecycled()))
              {
                ((a)localObject1).FLX.setVisibility(8);
                ((a)localObject1).wCz.setVisibility(8);
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
                  ForceGpuUtil.decideLayerType(paramViewGroup, paramView.getWidth(), paramView.getHeight());
                }
                label1368:
                ((a)localObject1).FLW.setVisibility(0);
                ((a)localObject1).FLX.setVisibility(8);
                ((a)localObject1).wCz.setVisibility(8);
                ((a)localObject1).xgq.setVisibility(8);
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
      ImageView EsM;
      ProgressBar FLW;
      MMAnimateView FLX;
      VideoView FLY;
      View FLZ;
      TextView FMa;
      ImageView wCz;
      View xgq;
      
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
          if ((GestureGalleryUI.ae(GestureGalleryUI.this) == GestureGalleryUI.c.FMe) || (GestureGalleryUI.ae(GestureGalleryUI.this) == GestureGalleryUI.c.FMd) || (GestureGalleryUI.ae(GestureGalleryUI.this) == GestureGalleryUI.c.FMf))
          {
            GestureGalleryUI localGestureGalleryUI = GestureGalleryUI.this;
            if (localGestureGalleryUI.FLu != null) {
              localGestureGalleryUI.FLz.post(new GestureGalleryUI.24(localGestureGalleryUI));
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
      FMc = new c("Idle", 0);
      FMd = new c("Prepared", 1);
      FMe = new c("Start", 2);
      FMf = new c("Resume", 3);
      FMg = new c("Paused", 4);
      FMh = new c("Complete", 5);
      FMi = new c("Stop", 6);
      FMj = new c("Error", 7);
      FMk = new c[] { FMc, FMd, FMe, FMf, FMg, FMh, FMi, FMj };
      AppMethodBeat.o(179722);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI
 * JD-Core Version:    0.7.0.1
 */