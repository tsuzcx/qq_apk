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
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.ru;
import com.tencent.mm.g.a.ru.a;
import com.tencent.mm.g.b.a.ao;
import com.tencent.mm.g.c.fb;
import com.tencent.mm.media.model.AppBrandMediaSource;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.aa.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanEngineImpl;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
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

@com.tencent.mm.ui.base.a(3)
public class GestureGalleryUI
  extends MMActivity
  implements aa.b, com.tencent.mm.plugin.scanner.word.a.a<String, Integer>, a.a
{
  private boolean gLh;
  private String gMF;
  private String gMQ;
  private boolean isAnimated;
  private String kkH;
  private ScanCodeSheetItemLogic kxs;
  private ap mHandler;
  private ImageView nzQ;
  private Bundle nzU;
  private com.tencent.mm.ui.tools.e nzV;
  private int nzW;
  private int nzX;
  private int nzY;
  private int nzZ;
  private boolean qeg;
  private com.tencent.mm.sdk.b.c qej;
  private long tiV;
  private int type;
  private String xmA;
  private com.tencent.mm.sdk.b.c xmF;
  private volatile String xmt;
  private String xmw;
  private String xmx;
  private String xmy;
  private String xmz;
  private int xni;
  private float xwb;
  private int xwc;
  private int xwd;
  private a yDY;
  MMGestureGallery yDZ;
  private com.tencent.mm.sdk.b.c<ca> yEA;
  private List<String> yEB;
  private List<AppBrandMediaSource> yEC;
  private int yED;
  private int yEE;
  private String yEF;
  private boolean yEG;
  private AdapterView.OnItemSelectedListener yEH;
  private b yEI;
  private String yEa;
  private aa yEb;
  private boolean yEc;
  private boolean yEd;
  private boolean yEe;
  private boolean yEf;
  private com.tencent.mm.ui.widget.a.e yEg;
  private volatile boolean yEh;
  private int yEi;
  private int yEj;
  private int yEk;
  private final Set<Integer> yEl;
  private final Set<Integer> yEm;
  private boolean yEn;
  private TextView yEo;
  private a yEp;
  private com.tencent.mm.plugin.webview.j.g yEq;
  private String yEr;
  GestureGalleryUI.a.a yEs;
  private boolean yEt;
  private RelativeLayout yEu;
  private PressAlphaImageView yEv;
  RedesignVideoPlayerSeekBar yEw;
  private long yEx;
  private c yEy;
  boolean yEz;
  
  public GestureGalleryUI()
  {
    AppMethodBeat.i(29091);
    this.yEc = false;
    this.yEd = false;
    this.gMF = "";
    this.gMQ = null;
    this.yEe = false;
    this.yEf = true;
    this.xni = 0;
    this.yEl = new HashSet();
    this.yEm = new HashSet();
    this.yEn = false;
    this.isAnimated = false;
    this.nzW = 0;
    this.nzX = 0;
    this.nzY = 0;
    this.nzZ = 0;
    this.mHandler = new ap();
    this.yEr = "";
    this.gLh = false;
    this.yEt = false;
    this.tiV = 0L;
    this.yEx = 0L;
    this.yEy = c.yEY;
    this.yEz = false;
    this.yEA = new com.tencent.mm.sdk.b.c() {};
    this.yEB = new ArrayList();
    this.yEC = new ArrayList();
    this.type = 0;
    this.yED = -1;
    this.yEE = -1;
    this.kkH = null;
    this.yEF = null;
    this.xwb = 1.0F;
    this.xwc = 0;
    this.xwd = 0;
    this.yEG = false;
    this.yEH = new AdapterView.OnItemSelectedListener()
    {
      VideoView yEN;
      
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29070);
        GestureGalleryUI.f(GestureGalleryUI.this, paramAnonymousInt);
        GestureGalleryUI.I(GestureGalleryUI.this).setText(GestureGalleryUI.c(GestureGalleryUI.this) + 1 + "/" + GestureGalleryUI.m(GestureGalleryUI.this).getCount());
        GestureGalleryUI.this.setMMTitle(GestureGalleryUI.c(GestureGalleryUI.this) + 1 + " / " + GestureGalleryUI.J(GestureGalleryUI.this).size());
        ad.d("MicroMsg.GestureGalleryUI", "pos:".concat(String.valueOf(paramAnonymousInt)));
        GestureGalleryUI.c(GestureGalleryUI.this, (String)GestureGalleryUI.J(GestureGalleryUI.this).get(paramAnonymousInt));
        GestureGalleryUI.d(GestureGalleryUI.this, "");
        GestureGalleryUI.b(GestureGalleryUI.this, false);
        if (this.yEN != null)
        {
          this.yEN.stopPlayback();
          this.yEN = null;
        }
        GestureGalleryUI.K(GestureGalleryUI.this).setIsPlay(false);
        GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.c.yEY);
        if ((paramAnonymousView != null) && (paramAnonymousView.getTag() != null))
        {
          paramAnonymousAdapterView = (GestureGalleryUI.a.a)paramAnonymousView.getTag();
          if ((paramAnonymousAdapterView != null) && (GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousInt)))
          {
            this.yEN = paramAnonymousAdapterView.yEU;
            GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousAdapterView);
            paramAnonymousAdapterView.ryD.setVisibility(0);
            paramAnonymousAdapterView.xoG.setVisibility(0);
            paramAnonymousAdapterView.yES.setVisibility(8);
            paramAnonymousAdapterView.yEV.setVisibility(8);
          }
        }
        else
        {
          if (!GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousInt)) {
            break label389;
          }
          GestureGalleryUI.d(GestureGalleryUI.this, GestureGalleryUI.t(GestureGalleryUI.this));
        }
        for (;;)
        {
          ad.i("MicroMsg.GestureGalleryUI", "curFilename:%s", new Object[] { GestureGalleryUI.j(GestureGalleryUI.this) });
          GestureGalleryUI.l(GestureGalleryUI.this);
          GestureGalleryUI.a(GestureGalleryUI.this, false);
          AppMethodBeat.o(29070);
          return;
          if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.ryD == null)) {
            break;
          }
          paramAnonymousAdapterView.ryD.setVisibility(8);
          break;
          label389:
          GestureGalleryUI.d(GestureGalleryUI.this, GestureGalleryUI.x(GestureGalleryUI.this).c((String)GestureGalleryUI.J(GestureGalleryUI.this).get(paramAnonymousInt), GestureGalleryUI.v(GestureGalleryUI.this), paramAnonymousInt, GestureGalleryUI.w(GestureGalleryUI.this)));
          if (bt.isNullOrNil(GestureGalleryUI.j(GestureGalleryUI.this))) {
            GestureGalleryUI.d(GestureGalleryUI.this, (String)GestureGalleryUI.J(GestureGalleryUI.this).get(paramAnonymousInt));
          }
        }
      }
      
      public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    };
    this.qej = new com.tencent.mm.sdk.b.c() {};
    this.xmF = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(29091);
  }
  
  private void cka()
  {
    AppMethodBeat.i(179724);
    ad.i("MicroMsg.GestureGalleryUI", "pauseVideo");
    if (this.yEs != null)
    {
      this.yEx = (this.yEw.getmPosition() * 1000);
      ad.i("MicroMsg.GestureGalleryUI", "pauseVideo currentVideoPos：%d", new Object[] { Long.valueOf(this.yEx) });
      this.yEs.yEU.pause();
      this.yEs.xoG.setVisibility(0);
      if ((this.yEy != c.yFa) && (this.yEy != c.yFb)) {
        break label133;
      }
      this.yEy = c.yFc;
      this.yEz = true;
    }
    for (;;)
    {
      this.yEw.setIsPlay(false);
      dMq();
      AppMethodBeat.o(179724);
      return;
      label133:
      c localc = c.yFc;
    }
  }
  
  private boolean dMn()
  {
    AppMethodBeat.i(169766);
    if ((this.yEh) && (!bt.isNullOrNil(this.xmw)))
    {
      AppMethodBeat.o(169766);
      return true;
    }
    AppMethodBeat.o(169766);
    return false;
  }
  
  private String dMo()
  {
    AppMethodBeat.i(179723);
    if ((this.yED < 0) || (this.yEC == null) || (this.yEC.size() == 0))
    {
      AppMethodBeat.o(179723);
      return "";
    }
    String str = ((AppBrandMediaSource)this.yEC.get(this.yED)).url;
    ad.i("MicroMsg.GestureGalleryUI", "playVideo  url :%s", new Object[] { str });
    if ((str != null) && (str.startsWith("http")))
    {
      Object localObject;
      if (com.tencent.mm.plugin.z.a.yYV == null)
      {
        localObject = new File(com.tencent.mm.loader.j.b.aiX());
        if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
          ((File)localObject).mkdir();
        }
        localObject = new HttpProxyCacheServer.Builder(this).maxCacheSize(134217728L).cacheDirectory((File)localObject).build();
        com.tencent.mm.plugin.z.a.yYV = (HttpProxyCacheServer)localObject;
      }
      for (;;)
      {
        localObject = ((HttpProxyCacheServer)localObject).getProxyUrl(str);
        AppMethodBeat.o(179723);
        return localObject;
        localObject = com.tencent.mm.plugin.z.a.yYV;
      }
    }
    AppMethodBeat.o(179723);
    return str;
  }
  
  private void dMp()
  {
    AppMethodBeat.i(179725);
    dMq();
    this.yEI = new b((byte)0);
    b localb = this.yEI;
    localb.isStop = false;
    com.tencent.mm.sdk.g.b.c(localb, "gesture_gallery_ui_video_update_progress");
    AppMethodBeat.o(179725);
  }
  
  private void dMq()
  {
    if (this.yEI != null) {
      this.yEI.isStop = true;
    }
  }
  
  private static void gi(Context paramContext)
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
  
  private void qY(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(29102);
    if (this.yEg == null) {
      this.yEg = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
    }
    this.yEg.HrX = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(29085);
        GestureGalleryUI.a(GestureGalleryUI.this).setFooterView(null);
        paramAnonymousl.clear();
        Object localObject;
        ao localao;
        if (!GestureGalleryUI.p(GestureGalleryUI.this))
        {
          paramAnonymousl.jj(1, 2131762163);
          if (GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.c(GestureGalleryUI.this)))
          {
            paramAnonymousl.jj(2, 2131762784);
            paramAnonymousl.jj(3, 2131761941);
          }
        }
        else if ((GestureGalleryUI.q(GestureGalleryUI.this)) && (!bt.isNullOrNil(GestureGalleryUI.j(GestureGalleryUI.this))))
        {
          paramAnonymousl.jj(4, 2131757184);
          localObject = GestureGalleryUI.e(GestureGalleryUI.this);
          localao = new ao();
          if (((a)localObject).qgu != 2) {
            break label244;
          }
          l = 1L;
          label132:
          localao.dKe = l;
          localao.dFd = 2L;
          if (!((a)localObject).yDU) {
            break label249;
          }
        }
        label244:
        label249:
        for (long l = 6L;; l = 5L)
        {
          localao.dMB = l;
          localao.aBj();
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
          paramAnonymousl.jj(2, 2131762781);
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
    this.yEg.HrY = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(29066);
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          AppMethodBeat.o(29066);
          return;
        case 1: 
          if (bt.isNullOrNil(GestureGalleryUI.j(GestureGalleryUI.this)))
          {
            ad.w("MicroMsg.GestureGalleryUI", "share image to friend fail, imgPath is null");
            AppMethodBeat.o(29066);
            return;
          }
          GestureGalleryUI.d(GestureGalleryUI.this, 1);
          if (com.tencent.mm.sdk.platformtools.t.aFm(GestureGalleryUI.j(GestureGalleryUI.this)))
          {
            paramAnonymousMenuItem = i.aEN(GestureGalleryUI.j(GestureGalleryUI.this));
            paramAnonymousMenuItem = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(paramAnonymousMenuItem);
            if (paramAnonymousMenuItem != null) {
              break label1360;
            }
            paramAnonymousMenuItem = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
            aj.getContext();
            paramAnonymousMenuItem = paramAnonymousMenuItem.TB(GestureGalleryUI.j(GestureGalleryUI.this));
            paramAnonymousMenuItem = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(paramAnonymousMenuItem);
          }
          break;
        }
        label192:
        label205:
        label1360:
        for (;;)
        {
          long l;
          Object localObject1;
          Object localObject2;
          if (paramAnonymousMenuItem == null)
          {
            l = 0L;
            if (paramAnonymousMenuItem != null) {
              break label317;
            }
            localObject1 = GestureGalleryUI.j(GestureGalleryUI.this);
            localObject2 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
            if (((com.tencent.mm.sdk.platformtools.f.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2) == null) || (((BitmapFactory.Options)localObject2).outHeight <= com.tencent.mm.m.b.YI())) && (((BitmapFactory.Options)localObject2).outWidth <= com.tencent.mm.m.b.YI())) {
              break label1355;
            }
          }
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            if ((l > com.tencent.mm.m.b.YJ()) || (paramAnonymousInt != 0))
            {
              h.a(GestureGalleryUI.this.getContext(), GestureGalleryUI.this.getString(2131758246), "", GestureGalleryUI.this.getString(2131760315), null);
              AppMethodBeat.o(29066);
              return;
              l = i.aMN(paramAnonymousMenuItem.gaa());
              break label192;
              localObject1 = paramAnonymousMenuItem.gaa();
              break label205;
            }
            localObject1 = new Intent();
            if (paramAnonymousMenuItem == null) {}
            for (paramAnonymousMenuItem = "";; paramAnonymousMenuItem = paramAnonymousMenuItem.JS())
            {
              ((Intent)localObject1).putExtra("Retr_File_Name", paramAnonymousMenuItem);
              ((Intent)localObject1).putExtra("Retr_Msg_Type", 5);
              ((Intent)localObject1).putExtra("Retr_MsgImgScene", 1);
              com.tencent.mm.plugin.subapp.b.hYt.k((Intent)localObject1, GestureGalleryUI.this.getContext());
              AppMethodBeat.o(29066);
              return;
            }
            if (GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.c(GestureGalleryUI.this)))
            {
              com.tencent.mm.sdk.g.b.c(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(179704);
                  ad.i("MicroMsg.GestureGalleryUI", "send video to friend");
                  final String str = i.aEN(GestureGalleryUI.t(GestureGalleryUI.this));
                  str = com.tencent.mm.loader.j.b.ais() + str + ".mp4";
                  if (!new com.tencent.mm.vfs.e(str).exists())
                  {
                    if (i.lC(GestureGalleryUI.t(GestureGalleryUI.this), str) < 0L)
                    {
                      ad.e("MicroMsg.GestureGalleryUI", "copy file fail origin path:%s", new Object[] { GestureGalleryUI.t(GestureGalleryUI.this) });
                      AppMethodBeat.o(179704);
                      return;
                    }
                    com.tencent.mm.pluginsdk.ui.tools.q.k(str, GestureGalleryUI.this);
                  }
                  GestureGalleryUI.this.runOnUiThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(179703);
                      long l = -1L;
                      Object localObject = new com.tencent.mm.vfs.e(str);
                      if (((com.tencent.mm.vfs.e)localObject).exists()) {
                        l = ((com.tencent.mm.vfs.e)localObject).length();
                      }
                      ad.i("MicroMsg.GestureGalleryUI", "send video to file size :%d, MaxSendVideoSize:%d", new Object[] { Long.valueOf(l), Integer.valueOf(com.tencent.mm.m.b.YK()) });
                      if (l <= 0L)
                      {
                        h.a(GestureGalleryUI.this.getContext(), GestureGalleryUI.this.getString(2131759798), "", GestureGalleryUI.this.getString(2131760315), null);
                        AppMethodBeat.o(179703);
                        return;
                      }
                      if (l > com.tencent.mm.m.b.YK())
                      {
                        h.a(GestureGalleryUI.this.getContext(), GestureGalleryUI.this.getString(2131759816), "", GestureGalleryUI.this.getString(2131760315), null);
                        AppMethodBeat.o(179703);
                        return;
                      }
                      ad.i("MicroMsg.GestureGalleryUI", "select contact in SelectConversationUI");
                      localObject = new Intent();
                      ((Intent)localObject).putExtra("image_path", GestureGalleryUI.t(GestureGalleryUI.this));
                      ((Intent)localObject).putExtra("Retr_Msg_Type", 1);
                      ((Intent)localObject).putExtra("Select_Conv_Type", 3);
                      ((Intent)localObject).putExtra("select_is_ret", true);
                      ((Intent)localObject).putExtra("mutil_select_is_ret", true);
                      com.tencent.mm.bs.d.c(GestureGalleryUI.this.getContext(), ".ui.transmit.SelectConversationUI", (Intent)localObject, 1);
                      AppMethodBeat.o(179703);
                    }
                  });
                  AppMethodBeat.o(179704);
                }
              }, "");
              AppMethodBeat.o(29066);
              return;
            }
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Retr_File_Name", GestureGalleryUI.j(GestureGalleryUI.this));
            paramAnonymousMenuItem.putExtra("Retr_Compress_Type", 0);
            paramAnonymousMenuItem.putExtra("Retr_Msg_Type", 0);
            com.tencent.mm.plugin.subapp.b.hYt.k(paramAnonymousMenuItem, GestureGalleryUI.this.getContext());
            AppMethodBeat.o(29066);
            return;
            if ((GestureGalleryUI.j(GestureGalleryUI.this) == null) || (GestureGalleryUI.j(GestureGalleryUI.this).equals(""))) {
              break;
            }
            GestureGalleryUI.d(GestureGalleryUI.this, 2);
            az.arV();
            if (!com.tencent.mm.model.c.isSDCardAvailable())
            {
              com.tencent.mm.ui.base.t.g(GestureGalleryUI.this, null);
              AppMethodBeat.o(29066);
              return;
            }
            if (GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.c(GestureGalleryUI.this)))
            {
              com.tencent.mm.platformtools.p.b(GestureGalleryUI.this, GestureGalleryUI.t(GestureGalleryUI.this), new p.a()
              {
                public final void bv(String paramAnonymous2String1, String paramAnonymous2String2)
                {
                  AppMethodBeat.i(191260);
                  Toast.makeText(GestureGalleryUI.this, GestureGalleryUI.this.getString(2131764683, new Object[] { paramAnonymous2String2 }), 1).show();
                  com.tencent.mm.pluginsdk.ui.tools.q.k(paramAnonymous2String2, GestureGalleryUI.this);
                  AppMethodBeat.o(191260);
                }
                
                public final void bw(String paramAnonymous2String1, String paramAnonymous2String2)
                {
                  AppMethodBeat.i(191261);
                  Toast.makeText(GestureGalleryUI.this, GestureGalleryUI.this.getString(2131764682), 1).show();
                  AppMethodBeat.o(191261);
                }
              });
              AppMethodBeat.o(29066);
              return;
            }
            com.tencent.mm.pluginsdk.ui.tools.q.j(GestureGalleryUI.j(GestureGalleryUI.this), GestureGalleryUI.this);
            AppMethodBeat.o(29066);
            return;
            GestureGalleryUI.d(GestureGalleryUI.this, 3);
            if (GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.c(GestureGalleryUI.this)))
            {
              localObject1 = new cs();
              paramAnonymousMenuItem = ((AppBrandMediaSource)GestureGalleryUI.u(GestureGalleryUI.this).get(GestureGalleryUI.c(GestureGalleryUI.this))).gsg;
              if (i.eK(paramAnonymousMenuItem)) {}
              for (;;)
              {
                com.tencent.mm.pluginsdk.model.g.a((cs)localObject1, 1, GestureGalleryUI.j(GestureGalleryUI.this), paramAnonymousMenuItem, "", "", true);
                ((cs)localObject1).deQ.activity = GestureGalleryUI.this;
                ((cs)localObject1).deQ.deW = 32;
                com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
                AppMethodBeat.o(29066);
                return;
                paramAnonymousMenuItem = GestureGalleryUI.x(GestureGalleryUI.this).c(paramAnonymousMenuItem, GestureGalleryUI.v(GestureGalleryUI.this), GestureGalleryUI.c(GestureGalleryUI.this), GestureGalleryUI.w(GestureGalleryUI.this));
              }
            }
            paramAnonymousMenuItem = new cs();
            com.tencent.mm.pluginsdk.model.g.a(paramAnonymousMenuItem, 1, GestureGalleryUI.j(GestureGalleryUI.this));
            paramAnonymousMenuItem.deQ.activity = GestureGalleryUI.this;
            paramAnonymousMenuItem.deQ.deW = 32;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousMenuItem);
            AppMethodBeat.o(29066);
            return;
            GestureGalleryUI.d(GestureGalleryUI.this, 6);
            paramAnonymousMenuItem = GestureGalleryUI.e(GestureGalleryUI.this);
            localObject1 = paramAnonymousMenuItem.yDT.ciZ();
            if (((paramAnonymousMenuItem.qgu != 0) && (paramAnonymousMenuItem.qgu != 2)) || (bt.isNullOrNil((String)localObject1))) {
              break;
            }
            localObject2 = new ao();
            if (paramAnonymousMenuItem.qgu == 2)
            {
              l = 1L;
              ((ao)localObject2).dKe = l;
              ((ao)localObject2).dFd = 3L;
              if (!paramAnonymousMenuItem.yDU) {
                break label1148;
              }
            }
            label1148:
            for (l = 6L;; l = 5L)
            {
              ((ao)localObject2).dMB = l;
              ((ao)localObject2).aBj();
              paramAnonymousMenuItem.qgt = ((int)(u.aqG().hashCode() + System.currentTimeMillis()));
              localObject2 = ((com.tencent.mm.plugin.scanner.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.scanner.c.class)).getTranslationResult((String)localObject1);
              if ((localObject2 == null) || (!i.eK(((fb)localObject2).field_resultFile))) {
                break label1155;
              }
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("original_file_path", (String)localObject1);
              ((Intent)localObject2).setClass(paramAnonymousMenuItem.activity, TranslationResultUI.class);
              localObject1 = paramAnonymousMenuItem.activity;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousMenuItem.activity.finish();
              paramAnonymousMenuItem.activity.overridePendingTransition(2130771986, 2130771986);
              AppMethodBeat.o(29066);
              return;
              l = 0L;
              break;
            }
            ru.a locala;
            if ((com.tencent.mm.kernel.g.aeS().auR() != 6) && (com.tencent.mm.kernel.g.aeS().auR() != 4))
            {
              h.c(paramAnonymousMenuItem.activity, paramAnonymousMenuItem.activity.getString(2131755828), "", true);
              paramAnonymousMenuItem.cjl();
              ad.i("MicroMsg.GestureGalleryTransLogic", "try to translate img %s, sessionId %d", new Object[] { localObject1, Integer.valueOf(paramAnonymousMenuItem.qgt) });
              localObject2 = new ru();
              locala = ((ru)localObject2).dxr;
              if (!paramAnonymousMenuItem.yDU) {
                break label1350;
              }
            }
            for (paramAnonymousInt = 6;; paramAnonymousInt = 5)
            {
              locala.scene = paramAnonymousInt;
              ((ru)localObject2).dxr.filePath = ((String)localObject1);
              ((ru)localObject2).dxr.dcS = paramAnonymousMenuItem.qgt;
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
              break;
              paramAnonymousMenuItem.qgu = 1;
              paramAnonymousMenuItem.qgw.setVisibility(0);
              paramAnonymousMenuItem.qgx.setVisibility(0);
              paramAnonymousMenuItem.qgy.setVisibility(0);
              paramAnonymousMenuItem.qgz.setRepeatMode(1);
              paramAnonymousMenuItem.qgz.setRepeatCount(-1);
              paramAnonymousMenuItem.qgz.start();
              break label1201;
            }
          }
        }
      }
    };
    this.yEg.GHn = new e.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(29067);
        GestureGalleryUI.d(GestureGalleryUI.this, 5);
        GestureGalleryUI.y(GestureGalleryUI.this);
        GestureGalleryUI.z(GestureGalleryUI.this);
        GestureGalleryUI.A(GestureGalleryUI.this);
        GestureGalleryUI.B(GestureGalleryUI.this);
        GestureGalleryUI.b(GestureGalleryUI.this, null);
        GestureGalleryUI.e(GestureGalleryUI.this, 0);
        GestureGalleryUI.C(GestureGalleryUI.this);
        GestureGalleryUI.D(GestureGalleryUI.this);
        GestureGalleryUI.E(GestureGalleryUI.this).vLD = null;
        AppMethodBeat.o(29067);
      }
    };
    if (!getContext().isFinishing()) {
      if ((!this.gLh) || (dMn()) || (this.qeg)) {
        break label273;
      }
    }
    Object localObject;
    String str;
    for (;;)
    {
      if (i != 0) {
        this.yEg.csG();
      }
      if ((this.yEh) && (bt.isNullOrNil(this.xmw)) && (az.aeS().auR() != 0))
      {
        localObject = new pj();
        ((pj)localObject).duX.dcQ = System.currentTimeMillis();
        ((pj)localObject).duX.filePath = this.yEa;
        ((pj)localObject).duX.duY = new HashSet(this.yEl);
        this.xmt = this.yEa;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      if (bt.isNullOrNil(this.yEa)) {
        break label315;
      }
      com.tencent.mm.kernel.g.afC();
      if ((com.tencent.mm.kernel.g.afA().gcy.auR() == 0) || (!paramBoolean)) {
        break label315;
      }
      localObject = this.yEp;
      str = this.yEa;
      if ((((a)localObject).activity != null) && (!((a)localObject).activity.isFinishing())) {
        break;
      }
      AppMethodBeat.o(29102);
      return;
      label273:
      i = 1;
    }
    if (((a)localObject).qgs == null) {
      ((a)localObject).qgs = new ImageWordScanEngineImpl(((a)localObject).activity);
    }
    ((a)localObject).qgs.a(str, ((a)localObject).qgr);
    label315:
    AppMethodBeat.o(29102);
  }
  
  public final void bKT()
  {
    AppMethodBeat.i(29100);
    if ((this.yDZ.getSelectedItemPosition() != this.yEE) || (!this.yEn))
    {
      finish();
      overridePendingTransition(0, 0);
      AppMethodBeat.o(29100);
      return;
    }
    if ((this.yEG) || (this.yDY == null))
    {
      ad.i("MicroMsg.GestureGalleryUI", "isRunningExitAnimation");
      AppMethodBeat.o(29100);
      return;
    }
    ad.i("MicroMsg.GestureGalleryUI", "runExitAnimation");
    int k = this.yDZ.getWidth();
    int i = this.yDZ.getHeight();
    int j = this.yDZ.getSelectedItemPosition();
    Object localObject = (String)this.yEB.get(j);
    if (i.eK((String)localObject))
    {
      if (bt.isNullOrNil((String)localObject)) {
        break label412;
      }
      localObject = com.tencent.mm.sdk.platformtools.f.aFf((String)localObject);
      float f = k / ((BitmapFactory.Options)localObject).outWidth;
      j = (int)(((BitmapFactory.Options)localObject).outHeight * f);
      i = j;
      if (j > this.yDZ.getHeight())
      {
        if (j < this.yDZ.getHeight() * 2.5D) {
          this.nzZ = (this.yDZ.getHeight() * this.nzZ / j);
        }
        i = this.yDZ.getHeight();
      }
    }
    label412:
    for (;;)
    {
      this.nzV.jB(k, i);
      this.nzV.P(this.nzX, this.nzW, this.nzY, this.nzZ);
      if (this.xwb != 1.0D)
      {
        this.nzV.HqK = (1.0F / this.xwb);
        if ((this.xwc != 0) || (this.xwd != 0))
        {
          j = (int)(this.yDZ.getWidth() / 2 * (1.0F - this.xwb));
          k = this.xwc;
          i = (int)(this.yDZ.getHeight() / 2 + this.xwd - i / 2 * this.xwb);
          this.nzV.jD(j + k, i);
        }
      }
      this.nzV.a(this.yDZ, this.nzQ, new e.c()
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
              View localView = GestureGalleryUI.m(GestureGalleryUI.this).dMr();
              if ((localView instanceof MultiTouchImageView)) {
                ((MultiTouchImageView)localView).eSz();
              }
              AppMethodBeat.o(29079);
            }
          }, 20L);
          AppMethodBeat.o(29081);
        }
      }, null);
      AppMethodBeat.o(29100);
      return;
      localObject = this.yEb.c((String)localObject, this.type, j, this.gMQ);
      break;
    }
  }
  
  public final String ciZ()
  {
    return this.yEa;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29101);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.GestureGalleryUI", "dispatchKeyEvent");
      bKT();
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
    this.kkH = bt.nullAsNil(getIntent().getStringExtra("nowUrlPath"));
    this.yEF = bt.nullAsNil(getIntent().getStringExtra("nowWebUrl"));
    this.type = getIntent().getIntExtra("type", 0);
    Object localObject = getIntent().getParcelableArrayListExtra("mediaSource");
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.yEC.clear();
      this.yEC.addAll((Collection)localObject);
    }
    localObject = getIntent().getStringArrayExtra("urlList");
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
          this.yEB.add(str2);
          continue;
          this.yEB = Arrays.asList((Object[])localObject);
        }
      }
    }
    final int i = 0;
    for (;;)
    {
      if (i < this.yEB.size())
      {
        if (str1.equals(this.yEB.get(i))) {
          this.yED = i;
        }
      }
      else
      {
        this.yEE = this.yED;
        if (getIntent().getIntExtra("currentPos", -1) >= 0) {
          this.yEE = getIntent().getIntExtra("currentPos", -1);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(29074);
            GestureGalleryUI.this.bKT();
            AppMethodBeat.o(29074);
            return true;
          }
        });
        this.yEo = ((TextView)findViewById(2131303133));
        this.nzQ = ((ImageView)findViewById(2131300336));
        this.yEu = ((RelativeLayout)findViewById(2131306407));
        this.yEw = ((RedesignVideoPlayerSeekBar)findViewById(2131306375));
        this.yEv = ((PressAlphaImageView)findViewById(2131306316));
        this.yEv.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(179707);
            GestureGalleryUI.this.bKT();
            AppMethodBeat.o(179707);
          }
        });
        this.yEw.setPlayBtnOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(179708);
            if (GestureGalleryUI.K(GestureGalleryUI.this).bTK())
            {
              GestureGalleryUI.S(GestureGalleryUI.this);
              AppMethodBeat.o(179708);
              return;
            }
            GestureGalleryUI.T(GestureGalleryUI.this);
            AppMethodBeat.o(179708);
          }
        });
        this.yEw.setVideoTotalTime(0);
        this.yEw.seek(0);
        this.yEw.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
        {
          public final void bcv() {}
          
          public final void rZ(int paramAnonymousInt)
          {
            AppMethodBeat.i(179709);
            if (GestureGalleryUI.U(GestureGalleryUI.this) != null) {
              GestureGalleryUI.U(GestureGalleryUI.this).yEU.seekTo(paramAnonymousInt * 1000);
            }
            AppMethodBeat.o(179709);
          }
        });
        this.yDY = new a();
        this.yDZ = ((MMGestureGallery)findViewById(2131300335));
        this.yDZ.setVisibility(0);
        this.yDZ.setVerticalFadingEdgeEnabled(false);
        this.yDZ.setHorizontalFadingEdgeEnabled(false);
        this.yDZ.setAdapter(this.yDY);
        this.yDZ.setSelection(this.yED);
        this.yDZ.setOnItemSelectedListener(this.yEH);
        this.yDZ.setSingleClickOverListener(new MMGestureGallery.f()
        {
          public final void aHo()
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
              if (GestureGalleryUI.e(GestureGalleryUI.this).qgu != 1) {
                GestureGalleryUI.this.bKT();
              }
              AppMethodBeat.o(29075);
              return;
            }
          }
        });
        i = getIntent().getIntExtra("nevNext", 1);
        this.yDZ.setLongClickOverListener(new MMGestureGallery.c()
        {
          public final void aHp()
          {
            boolean bool2 = true;
            AppMethodBeat.i(29077);
            if (GestureGalleryUI.e(GestureGalleryUI.this).qgu == 1)
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
            GestureGalleryUI.a(GestureGalleryUI.this, new com.tencent.mm.plugin.webview.j.g());
            GestureGalleryUI.h(GestureGalleryUI.this).reset(2);
            Object localObject1;
            if (1 == i)
            {
              localObject1 = y.arz().E("basescanui@datacenter", true);
              ((y.b)localObject1).m("key_basescanui_screen_x", Integer.valueOf(GestureGalleryUI.i(GestureGalleryUI.this).getXDown()));
              ((y.b)localObject1).m("key_basescanui_screen_y", Integer.valueOf(GestureGalleryUI.i(GestureGalleryUI.this).getYDown()));
              if ((GestureGalleryUI.e(GestureGalleryUI.this).qgu == 0) || (GestureGalleryUI.e(GestureGalleryUI.this).qgu == 2))
              {
                localObject1 = GestureGalleryUI.e(GestureGalleryUI.this);
                Object localObject2 = new ao();
                long l;
                label233:
                boolean bool1;
                if (((a)localObject1).qgu == 2)
                {
                  l = 1L;
                  ((ao)localObject2).dKe = l;
                  ((ao)localObject2).dFd = 1L;
                  if (!((a)localObject1).yDU) {
                    break label392;
                  }
                  l = 6L;
                  ((ao)localObject2).dMB = l;
                  ((ao)localObject2).aBj();
                  localObject1 = GestureGalleryUI.this;
                  int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("EnableWebviewPicTranslation", 0);
                  localObject2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("PicTranslationSupportUserLanguage");
                  if (i != 1) {
                    break label400;
                  }
                  bool1 = true;
                  label299:
                  ad.i("MicroMsg.ScannerHelper", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool1), localObject2, ac.eFu() });
                  if ((i != 1) || (bt.isNullOrNil((String)localObject2))) {
                    break label405;
                  }
                  localObject2 = ((String)localObject2).split(";");
                  if ((localObject2 == null) || (!Arrays.asList((Object[])localObject2).contains(ac.eFu()))) {
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
                  if (!com.tencent.mm.protocal.d.CpO) {
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
              h.b(GestureGalleryUI.this, null, (String[])localObject1, "", new h.c()
              {
                public final void kM(int paramAnonymous2Int)
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
                    com.tencent.mm.plugin.subapp.b.hYt.k(localIntent, localGestureGalleryUI.getContext());
                  }
                }
              });
            }
            AppMethodBeat.o(29077);
          }
        });
        this.nzV = new com.tencent.mm.ui.tools.e(this);
        AppMethodBeat.o(29098);
        return;
      }
      i += 1;
    }
  }
  
  public final void j(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(29092);
    if (this.yDY != null)
    {
      if (paramInt == this.yDZ.getSelectedItemPosition())
      {
        this.yEa = paramString2;
        ad.d("MicroMsg.GestureGalleryUI", "onDownSucc, curFilename:%s, url:%s", new Object[] { this.yEa, paramString1 });
      }
      this.yDY.notifyDataSetChanged();
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
      final Runnable local19;
      label82:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        local19 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179716);
            this.qcu.dismiss();
            AppMethodBeat.o(179716);
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
      Iterator localIterator = bt.S(((String)localObject).split(",")).iterator();
      while (localIterator.hasNext())
      {
        final String str2 = (String)localIterator.next();
        String str1 = ((AppBrandMediaSource)this.yEC.get(this.yED)).gsg;
        localObject = str1;
        if (!i.eK(str1)) {
          localObject = this.yEb.c(str1, this.type, this.yED, this.gMQ);
        }
        ad.i("MicroMsg.GestureGalleryUI", "onActivityResult,  sendVideo video:%s,  thumbFilename:%s", new Object[] { dMo(), localObject });
        com.tencent.mm.kernel.g.afE().ax(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179717);
            j.cOB().a(GestureGalleryUI.this.getContext(), str2, GestureGalleryUI.t(GestureGalleryUI.this), this.yEO, 1, (int)GestureGalleryUI.V(GestureGalleryUI.this), "", "");
            aq.f(local19);
            AppMethodBeat.o(179717);
          }
          
          public final String toString()
          {
            AppMethodBeat.i(179718);
            String str = super.toString() + "send video";
            AppMethodBeat.o(179718);
            return str;
          }
        });
        if (!bt.isNullOrNil(paramIntent)) {
          j.cOB().W(str2, paramIntent, w.tq(str2));
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
    this.nzU = paramBundle;
    this.yEA.alive();
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setFlags(1024, 1024);
      getWindow().addFlags(67108864);
    }
    fullScreenNoTitleBar(true);
    this.yEe = getIntent().getBooleanExtra("isFromAppBrand", false);
    this.gLh = getIntent().getBooleanExtra("forBidForward", false);
    this.yEc = getIntent().getBooleanExtra("isFromWebView", false);
    this.yEf = getIntent().getBooleanExtra("showmenu", true);
    this.yEd = getIntent().getBooleanExtra("isOuntLink", false);
    this.gMF = getIntent().getStringExtra("IsFromWebViewReffer");
    this.yEh = getIntent().getBooleanExtra("shouldShowScanQrCodeMenu", false);
    this.yEn = getIntent().getBooleanExtra("shouldRunDragAnimation", false);
    this.yEk = getIntent().getIntExtra("scanQrCodeGetA8KeyScene", 0);
    paramBundle = getIntent().getIntArrayExtra("scanCodeTypes");
    int i;
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      i = 0;
      while (i < paramBundle.length)
      {
        this.yEl.add(Integer.valueOf(paramBundle[i]));
        i += 1;
      }
    }
    paramBundle = getIntent().getIntArrayExtra("scanResultCodeTypes");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      i = 0;
      while (i < paramBundle.length)
      {
        this.yEm.add(Integer.valueOf(paramBundle[i]));
        i += 1;
      }
    }
    this.yEp = new a(this, this, this, this.yEd);
    this.gMQ = getIntent().getStringExtra("cookie");
    ad.d("MicroMsg.GestureGalleryUI", "isFromWebView: %b, isFromWebViewReffer:%s, cookie = %s, forbidForward=%b", new Object[] { Boolean.valueOf(this.yEc), this.gMF, this.gMQ, Boolean.valueOf(this.gLh) });
    this.yEb = new aa(this.yEc, this.gMF);
    paramBundle = this.yEb;
    ad.d("MicroMsg.GetPicService", "addListener :" + hashCode());
    paramBundle.gMH = this;
    com.tencent.mm.sdk.b.a.ESL.c(this.qej);
    com.tencent.mm.sdk.b.a.ESL.c(this.xmF);
    initView();
    this.yEG = false;
    if (this.yEe) {
      getWindow().setBackgroundDrawableResource(2131231318);
    }
    this.kxs = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a()
    {
      public final void beE()
      {
        AppMethodBeat.i(29065);
        if ((GestureGalleryUI.a(GestureGalleryUI.this) != null) && (GestureGalleryUI.a(GestureGalleryUI.this).isShowing())) {
          GestureGalleryUI.b(GestureGalleryUI.this);
        }
        AppMethodBeat.o(29065);
      }
    });
    AppMethodBeat.o(29093);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29094);
    super.onDestroy();
    Object localObject = this.yEb;
    ad.d("MicroMsg.GetPicService", "removeListener :" + hashCode());
    ((aa)localObject).gMH = null;
    localObject = this.yEb;
    if (((aa)localObject).gMD != null) {
      ((aa)localObject).gMD.gML = true;
    }
    ((aa)localObject).gMD = null;
    com.tencent.mm.sdk.b.a.ESL.d(this.qej);
    com.tencent.mm.sdk.b.a.ESL.d(this.xmF);
    this.yEA.dead();
    gi(this);
    if (this.yEp != null)
    {
      localObject = this.yEp;
      ((a)localObject).cjn();
      ((a)localObject).qgz.removeAllUpdateListeners();
      ((a)localObject).qgA.dead();
      com.tencent.mm.kernel.g.afA().b(((a)localObject).qgB);
      ((a)localObject).qgr = null;
      ((a)localObject).activity = null;
      ((a)localObject).yDT = null;
    }
    localObject = new pw();
    ((pw)localObject).dvy.activity = this;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    ad.i("MicroMsg.GestureGalleryUI", "stopVideo");
    if (this.yEs != null)
    {
      this.yEs.yEU.stopPlayback();
      this.yEy = c.yFe;
      this.yEw.setIsPlay(false);
      this.yEw.setIplaySeekCallback(null);
      this.yEs.xoG.setVisibility(0);
      this.yEs.raa.setVisibility(0);
      this.yEs.yEU.setVisibility(8);
    }
    dMq();
    AppMethodBeat.o(29094);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29095);
    super.onPause();
    cka();
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
    Bundle localBundle = this.nzU;
    if ((this.isAnimated) || (!this.yEn)) {}
    for (;;)
    {
      super.onStart();
      AppMethodBeat.o(29099);
      return;
      this.isAnimated = true;
      this.nzW = getIntent().getIntExtra("img_gallery_top", 0);
      this.nzX = getIntent().getIntExtra("img_gallery_left", 0);
      this.nzY = getIntent().getIntExtra("img_gallery_width", 0);
      this.nzZ = getIntent().getIntExtra("img_gallery_height", 0);
      this.nzV.P(this.nzX, this.nzW, this.nzY, this.nzZ);
      if (localBundle == null) {
        this.yDZ.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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
    if (this.xmw != null)
    {
      ar localar = new ar();
      localar.dcN.activity = this;
      localar.dcN.dcO = this.xmw;
      com.tencent.mm.sdk.b.a.ESL.l(localar);
      this.xmw = null;
      this.yEj = 0;
      this.yEi = 0;
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
    
    private View OT(int paramInt)
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
    
    public final View dMr()
    {
      AppMethodBeat.i(29088);
      View localView = OT(GestureGalleryUI.this.yDZ.getSelectedItemPosition());
      AppMethodBeat.o(29088);
      return localView;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(29086);
      ad.d("MicroMsg.GestureGalleryUI", "lstpicurl:" + GestureGalleryUI.J(GestureGalleryUI.this).size());
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
      if ((GestureGalleryUI.u(GestureGalleryUI.this) != null) && (!GestureGalleryUI.u(GestureGalleryUI.this).isEmpty()) && (GestureGalleryUI.u(GestureGalleryUI.this).size() > paramInt)) {}
      for (Object localObject2 = (AppBrandMediaSource)GestureGalleryUI.u(GestureGalleryUI.this).get(paramInt);; localObject2 = null)
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
        if ((paramView == null) || ((i != 0) && (paramViewGroup != null) && (paramViewGroup.yEU == null)))
        {
          localObject1 = new a();
          localView = View.inflate(GestureGalleryUI.this, 2131495191, null);
          ((a)localObject1).yES = ((ProgressBar)localView.findViewById(2131303535));
          ((a)localObject1).yET = ((MMAnimateView)localView.findViewById(2131300914));
          ((a)localObject1).raa = ((ImageView)localView.findViewById(2131305793));
          ((a)localObject1).ryD = localView.findViewById(2131306319);
          ((a)localObject1).yEU = ((VideoView)localView.findViewById(2131306410));
          ((a)localObject1).xoG = ((ImageView)localView.findViewById(2131306413));
          ((a)localObject1).yEV = localView.findViewById(2131306339);
          ((a)localObject1).yEW = ((TextView)localView.findViewById(2131306340));
          if (i != 0)
          {
            ((a)localObject1).raa.setVisibility(8);
            ((a)localObject1).raa = ((ImageView)localView.findViewById(2131306347));
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
            paramView = ((AppBrandMediaSource)localObject2).gsg;
            j = 1;
          }
          paramViewGroup = paramView;
          if (!i.eK(paramView))
          {
            paramView = GestureGalleryUI.x(GestureGalleryUI.this).c(paramView, GestureGalleryUI.v(GestureGalleryUI.this), paramInt, GestureGalleryUI.w(GestureGalleryUI.this));
            paramViewGroup = paramView;
            if (paramInt == GestureGalleryUI.L(GestureGalleryUI.this))
            {
              paramViewGroup = paramView;
              if (bt.isNullOrNil(paramView))
              {
                paramViewGroup = paramView;
                if (i.eK(GestureGalleryUI.M(GestureGalleryUI.this))) {
                  paramViewGroup = GestureGalleryUI.M(GestureGalleryUI.this);
                }
              }
            }
          }
          for (i = 1;; i = k)
          {
            ((a)localObject1).yEU.setVisibility(8);
            ((a)localObject1).yEU.stopPlayback();
            if (j != 0)
            {
              ((a)localObject1).ryD.setVisibility(0);
              GestureGalleryUI.b(GestureGalleryUI.this, (a)localObject1);
              if (bt.isNullOrNil(paramViewGroup)) {
                break label1368;
              }
              ((a)localObject1).yES.setVisibility(8);
              if ((GestureGalleryUI.u(GestureGalleryUI.this) != null) && (!GestureGalleryUI.u(GestureGalleryUI.this).isEmpty())) {
                TextUtils.isEmpty(((AppBrandMediaSource)GestureGalleryUI.u(GestureGalleryUI.this).get(paramInt)).gsg);
              }
              if (paramViewGroup != null) {
                break label600;
              }
              paramView = null;
            }
            for (;;)
            {
              if ((!GestureGalleryUI.N(GestureGalleryUI.this)) || ((paramView != null) && (!paramView.isRecycled()))) {
                break label830;
              }
              GestureGalleryUI.this.finish();
              AppMethodBeat.o(29090);
              return localView;
              ((a)localObject1).ryD.setVisibility(8);
              break;
              label600:
              localObject2 = com.tencent.mm.aw.a.a.ayO().yu(paramViewGroup + "_" + i.aMN(paramViewGroup));
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
                localObject2 = com.tencent.mm.sdk.platformtools.f.aFi(paramViewGroup);
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
                com.tencent.mm.aw.a.a.ayO().i(paramViewGroup + "_" + i.aMN(paramViewGroup), paramView);
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
                k = ai.cf(GestureGalleryUI.this.getContext()).x;
                m = ai.cf(GestureGalleryUI.this.getContext()).y;
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
              if (!com.tencent.mm.sdk.platformtools.t.aFm(paramViewGroup)) {
                break label1111;
              }
              if (paramInt == GestureGalleryUI.L(GestureGalleryUI.this)) {
                GestureGalleryUI.O(GestureGalleryUI.this);
              }
            }
            label1353:
            for (;;)
            {
              try
              {
                ((a)localObject1).yET.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((a)localObject1).raa.setVisibility(8);
                ((a)localObject1).yET.setVisibility(0);
                localObject2 = ((a)localObject1).yET;
                ((MMAnimateView)localObject2).spn = GestureGalleryUI.f(GestureGalleryUI.this);
                ((MMAnimateView)localObject2).gE(paramViewGroup, null);
                AppMethodBeat.o(29090);
                return localView;
                k = 0;
              }
              catch (Exception paramViewGroup)
              {
                ad.e("MicroMsg.GestureGalleryUI", bt.m(paramViewGroup));
                ((a)localObject1).yET.setVisibility(0);
                ((a)localObject1).raa.setVisibility(8);
                ((a)localObject1).yET.setImageBitmap(paramView);
                continue;
              }
              label1111:
              if ((i != 0) && (paramView != null) && (!paramView.isRecycled()))
              {
                ((a)localObject1).yES.setVisibility(0);
                ((a)localObject1).raa.setVisibility(0);
                ((a)localObject1).raa.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((a)localObject1).raa.setImageBitmap(paramView);
              }
              else if ((j != 0) && (paramView != null) && (!paramView.isRecycled()))
              {
                ((a)localObject1).yES.setVisibility(8);
                ((a)localObject1).raa.setVisibility(0);
                ((a)localObject1).raa.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((a)localObject1).raa.setImageBitmap(paramView);
              }
              else if ((paramView != null) && (!paramView.isRecycled()))
              {
                ((a)localObject1).yET.setVisibility(8);
                ((a)localObject1).raa.setVisibility(8);
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
                  com.tencent.mm.sdk.platformtools.p.z(paramViewGroup, paramView.getWidth(), paramView.getHeight());
                }
                label1368:
                ((a)localObject1).yES.setVisibility(0);
                ((a)localObject1).yET.setVisibility(8);
                ((a)localObject1).raa.setVisibility(8);
                ((a)localObject1).ryD.setVisibility(8);
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
      ImageView raa;
      View ryD;
      ImageView xoG;
      ProgressBar yES;
      MMAnimateView yET;
      VideoView yEU;
      View yEV;
      TextView yEW;
      
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
          if ((GestureGalleryUI.W(GestureGalleryUI.this) == GestureGalleryUI.c.yFa) || (GestureGalleryUI.W(GestureGalleryUI.this) == GestureGalleryUI.c.yEZ) || (GestureGalleryUI.W(GestureGalleryUI.this) == GestureGalleryUI.c.yFb))
          {
            GestureGalleryUI localGestureGalleryUI = GestureGalleryUI.this;
            if (localGestureGalleryUI.yEs != null) {
              localGestureGalleryUI.yEw.post(new GestureGalleryUI.18(localGestureGalleryUI));
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
      yEY = new c("Idle", 0);
      yEZ = new c("Prepared", 1);
      yFa = new c("Start", 2);
      yFb = new c("Resume", 3);
      yFc = new c("Paused", 4);
      yFd = new c("Complete", 5);
      yFe = new c("Stop", 6);
      yFf = new c("Error", 7);
      yFg = new c[] { yEY, yEZ, yFa, yFb, yFc, yFd, yFe, yFf };
      AppMethodBeat.o(179722);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI
 * JD-Core Version:    0.7.0.1
 */