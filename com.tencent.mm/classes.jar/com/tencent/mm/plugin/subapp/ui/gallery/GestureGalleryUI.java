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
import com.tencent.mm.g.a.as;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.g.a.sd.a;
import com.tencent.mm.g.b.a.bo;
import com.tencent.mm.g.c.ff;
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
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
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
  implements aa.b, com.tencent.mm.plugin.scanner.word.a.a<String, com.tencent.mm.plugin.scanner.word.b>, a.a
{
  private boolean hlH;
  private String hnf;
  private String hnq;
  private boolean isAnimated;
  private String kLZ;
  private ScanCodeSheetItemLogic kYG;
  private ao mHandler;
  private ImageView ocQ;
  private Bundle ocU;
  private com.tencent.mm.ui.tools.e ocV;
  private int ocW;
  private int ocX;
  private int ocY;
  private int ocZ;
  private boolean qMJ;
  private com.tencent.mm.sdk.b.c qMM;
  private int type;
  private long urm;
  private float yIR;
  private int yIS;
  private int yIT;
  private int yzZ;
  private volatile String yzl;
  private String yzo;
  private String yzp;
  private String yzq;
  private String yzr;
  private String yzs;
  private com.tencent.mm.sdk.b.c yzx;
  private final Set<Integer> zRA;
  private boolean zRB;
  private TextView zRC;
  private a zRD;
  private com.tencent.mm.plugin.webview.j.g zRE;
  private String zRF;
  GestureGalleryUI.a.a zRG;
  private boolean zRH;
  private RelativeLayout zRI;
  private PressAlphaImageView zRJ;
  RedesignVideoPlayerSeekBar zRK;
  private long zRL;
  private c zRM;
  boolean zRN;
  private com.tencent.mm.sdk.b.c<ca> zRO;
  private List<String> zRP;
  private List<AppBrandMediaSource> zRQ;
  private int zRR;
  private int zRS;
  private String zRT;
  private boolean zRU;
  private AdapterView.OnItemSelectedListener zRV;
  private b zRW;
  private a zRm;
  MMGestureGallery zRn;
  private String zRo;
  private aa zRp;
  private boolean zRq;
  private boolean zRr;
  private boolean zRs;
  private boolean zRt;
  private com.tencent.mm.ui.widget.a.e zRu;
  private volatile boolean zRv;
  private int zRw;
  private int zRx;
  private int zRy;
  private final Set<Integer> zRz;
  
  public GestureGalleryUI()
  {
    AppMethodBeat.i(29091);
    this.zRq = false;
    this.zRr = false;
    this.hnf = "";
    this.hnq = null;
    this.zRs = false;
    this.zRt = true;
    this.yzZ = 0;
    this.zRz = new HashSet();
    this.zRA = new HashSet();
    this.zRB = false;
    this.isAnimated = false;
    this.ocW = 0;
    this.ocX = 0;
    this.ocY = 0;
    this.ocZ = 0;
    this.mHandler = new ao();
    this.zRF = "";
    this.hlH = false;
    this.zRH = false;
    this.urm = 0L;
    this.zRL = 0L;
    this.zRM = c.zSm;
    this.zRN = false;
    this.zRO = new GestureGalleryUI.10(this);
    this.zRP = new ArrayList();
    this.zRQ = new ArrayList();
    this.type = 0;
    this.zRR = -1;
    this.zRS = -1;
    this.kLZ = null;
    this.zRT = null;
    this.yIR = 1.0F;
    this.yIS = 0;
    this.yIT = 0;
    this.zRU = false;
    this.zRV = new AdapterView.OnItemSelectedListener()
    {
      VideoView zSb;
      
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29070);
        GestureGalleryUI.f(GestureGalleryUI.this, paramAnonymousInt);
        GestureGalleryUI.I(GestureGalleryUI.this).setText(GestureGalleryUI.c(GestureGalleryUI.this) + 1 + "/" + GestureGalleryUI.m(GestureGalleryUI.this).getCount());
        GestureGalleryUI.this.setMMTitle(GestureGalleryUI.c(GestureGalleryUI.this) + 1 + " / " + GestureGalleryUI.J(GestureGalleryUI.this).size());
        ac.d("MicroMsg.GestureGalleryUI", "pos:".concat(String.valueOf(paramAnonymousInt)));
        GestureGalleryUI.c(GestureGalleryUI.this, (String)GestureGalleryUI.J(GestureGalleryUI.this).get(paramAnonymousInt));
        GestureGalleryUI.d(GestureGalleryUI.this, "");
        GestureGalleryUI.b(GestureGalleryUI.this, false);
        if (this.zSb != null)
        {
          this.zSb.stopPlayback();
          this.zSb = null;
        }
        GestureGalleryUI.K(GestureGalleryUI.this).setIsPlay(false);
        GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.c.zSm);
        if ((paramAnonymousView != null) && (paramAnonymousView.getTag() != null))
        {
          paramAnonymousAdapterView = (GestureGalleryUI.a.a)paramAnonymousView.getTag();
          if ((paramAnonymousAdapterView != null) && (GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousInt)))
          {
            this.zSb = paramAnonymousAdapterView.zSi;
            GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousAdapterView);
            paramAnonymousAdapterView.sHv.setVisibility(0);
            paramAnonymousAdapterView.yBx.setVisibility(0);
            paramAnonymousAdapterView.zSg.setVisibility(8);
            paramAnonymousAdapterView.zSj.setVisibility(8);
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
          ac.i("MicroMsg.GestureGalleryUI", "curFilename:%s", new Object[] { GestureGalleryUI.j(GestureGalleryUI.this) });
          GestureGalleryUI.l(GestureGalleryUI.this);
          GestureGalleryUI.a(GestureGalleryUI.this, false);
          AppMethodBeat.o(29070);
          return;
          if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.sHv == null)) {
            break;
          }
          paramAnonymousAdapterView.sHv.setVisibility(8);
          break;
          label389:
          GestureGalleryUI.d(GestureGalleryUI.this, GestureGalleryUI.x(GestureGalleryUI.this).c((String)GestureGalleryUI.J(GestureGalleryUI.this).get(paramAnonymousInt), GestureGalleryUI.v(GestureGalleryUI.this), paramAnonymousInt, GestureGalleryUI.w(GestureGalleryUI.this)));
          if (bs.isNullOrNil(GestureGalleryUI.j(GestureGalleryUI.this))) {
            GestureGalleryUI.d(GestureGalleryUI.this, (String)GestureGalleryUI.J(GestureGalleryUI.this).get(paramAnonymousInt));
          }
        }
      }
      
      public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    };
    this.qMM = new com.tencent.mm.sdk.b.c() {};
    this.yzx = new GestureGalleryUI.8(this);
    AppMethodBeat.o(29091);
  }
  
  private void crH()
  {
    AppMethodBeat.i(179724);
    ac.i("MicroMsg.GestureGalleryUI", "pauseVideo");
    if (this.zRG != null)
    {
      this.zRL = (this.zRK.getmPosition() * 1000);
      ac.i("MicroMsg.GestureGalleryUI", "pauseVideo currentVideoPos：%d", new Object[] { Long.valueOf(this.zRL) });
      this.zRG.zSi.pause();
      this.zRG.yBx.setVisibility(0);
      if ((this.zRM != c.zSo) && (this.zRM != c.zSp)) {
        break label133;
      }
      this.zRM = c.zSq;
      this.zRN = true;
    }
    for (;;)
    {
      this.zRK.setIsPlay(false);
      eaQ();
      AppMethodBeat.o(179724);
      return;
      label133:
      c localc = c.zSq;
    }
  }
  
  private boolean eaN()
  {
    AppMethodBeat.i(169766);
    if ((this.zRv) && (!bs.isNullOrNil(this.yzo)))
    {
      AppMethodBeat.o(169766);
      return true;
    }
    AppMethodBeat.o(169766);
    return false;
  }
  
  private String eaO()
  {
    AppMethodBeat.i(179723);
    if ((this.zRR < 0) || (this.zRQ == null) || (this.zRQ.size() == 0))
    {
      AppMethodBeat.o(179723);
      return "";
    }
    String str = ((AppBrandMediaSource)this.zRQ.get(this.zRR)).url;
    ac.i("MicroMsg.GestureGalleryUI", "playVideo  url :%s", new Object[] { str });
    if ((str != null) && (str.startsWith("http")))
    {
      Object localObject;
      if (com.tencent.mm.plugin.z.a.AmK == null)
      {
        localObject = new File(com.tencent.mm.loader.j.b.apX());
        if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
          ((File)localObject).mkdir();
        }
        localObject = new HttpProxyCacheServer.Builder(this).maxCacheSize(134217728L).cacheDirectory((File)localObject).build();
        com.tencent.mm.plugin.z.a.AmK = (HttpProxyCacheServer)localObject;
      }
      for (;;)
      {
        localObject = ((HttpProxyCacheServer)localObject).getProxyUrl(str);
        AppMethodBeat.o(179723);
        return localObject;
        localObject = com.tencent.mm.plugin.z.a.AmK;
      }
    }
    AppMethodBeat.o(179723);
    return str;
  }
  
  private void eaP()
  {
    AppMethodBeat.i(179725);
    eaQ();
    this.zRW = new b((byte)0);
    b localb = this.zRW;
    localb.isStop = false;
    com.tencent.mm.sdk.g.b.c(localb, "gesture_gallery_ui_video_update_progress");
    AppMethodBeat.o(179725);
  }
  
  private void eaQ()
  {
    if (this.zRW != null) {
      this.zRW.isStop = true;
    }
  }
  
  private static void gu(Context paramContext)
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
  
  private void rW(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(29102);
    if (this.zRu == null) {
      this.zRu = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
    }
    this.zRu.ISu = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(29085);
        GestureGalleryUI.a(GestureGalleryUI.this).setFooterView(null);
        paramAnonymousl.clear();
        Object localObject;
        bo localbo;
        if (!GestureGalleryUI.p(GestureGalleryUI.this))
        {
          paramAnonymousl.jw(1, 2131762163);
          if (GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.c(GestureGalleryUI.this)))
          {
            paramAnonymousl.jw(2, 2131762784);
            paramAnonymousl.jw(3, 2131761941);
          }
        }
        else if ((GestureGalleryUI.q(GestureGalleryUI.this)) && (!bs.isNullOrNil(GestureGalleryUI.j(GestureGalleryUI.this))))
        {
          paramAnonymousl.jw(4, 2131757184);
          localObject = GestureGalleryUI.e(GestureGalleryUI.this);
          localbo = new bo();
          if (((a)localObject).qOW != 2) {
            break label244;
          }
          l = 1L;
          label132:
          localbo.dHY = l;
          localbo.dCQ = 2L;
          if (!((a)localObject).zRi) {
            break label249;
          }
        }
        label244:
        label249:
        for (long l = 6L;; l = 5L)
        {
          localbo.dNc = l;
          localbo.aHZ();
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
          paramAnonymousl.jw(2, 2131762781);
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
    this.zRu.ISv = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        paramAnonymousInt = 6;
        AppMethodBeat.i(29066);
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          AppMethodBeat.o(29066);
          return;
        case 1: 
          if (bs.isNullOrNil(GestureGalleryUI.j(GestureGalleryUI.this)))
          {
            ac.w("MicroMsg.GestureGalleryUI", "share image to friend fail, imgPath is null");
            AppMethodBeat.o(29066);
            return;
          }
          GestureGalleryUI.d(GestureGalleryUI.this, 1);
          if (s.aKD(GestureGalleryUI.j(GestureGalleryUI.this)))
          {
            paramAnonymousMenuItem = i.aKe(GestureGalleryUI.j(GestureGalleryUI.this));
            paramAnonymousMenuItem = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(paramAnonymousMenuItem);
            if (paramAnonymousMenuItem != null) {
              break label1382;
            }
            paramAnonymousMenuItem = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
            ai.getContext();
            paramAnonymousMenuItem = paramAnonymousMenuItem.XN(GestureGalleryUI.j(GestureGalleryUI.this));
            paramAnonymousMenuItem = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(paramAnonymousMenuItem);
          }
          break;
        }
        label192:
        label205:
        label1372:
        label1377:
        label1382:
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
            if (((com.tencent.mm.sdk.platformtools.f.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2) == null) || (((BitmapFactory.Options)localObject2).outHeight <= com.tencent.mm.m.b.ZF())) && (((BitmapFactory.Options)localObject2).outWidth <= com.tencent.mm.m.b.ZF())) {
              break label1377;
            }
          }
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            if ((l > com.tencent.mm.m.b.ZG()) || (paramAnonymousInt != 0))
            {
              h.a(GestureGalleryUI.this.getContext(), GestureGalleryUI.this.getString(2131758246), "", GestureGalleryUI.this.getString(2131760315), null);
              AppMethodBeat.o(29066);
              return;
              l = i.aSp(paramAnonymousMenuItem.ghd());
              break label192;
              localObject1 = paramAnonymousMenuItem.ghd();
              break label205;
            }
            localObject1 = new Intent();
            if (paramAnonymousMenuItem == null) {}
            for (paramAnonymousMenuItem = "";; paramAnonymousMenuItem = paramAnonymousMenuItem.JC())
            {
              ((Intent)localObject1).putExtra("Retr_File_Name", paramAnonymousMenuItem);
              ((Intent)localObject1).putExtra("Retr_Msg_Type", 5);
              ((Intent)localObject1).putExtra("Retr_MsgImgScene", 1);
              com.tencent.mm.plugin.subapp.b.iyx.k((Intent)localObject1, GestureGalleryUI.this.getContext());
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
                  ac.i("MicroMsg.GestureGalleryUI", "send video to friend");
                  final String str = i.aKe(GestureGalleryUI.t(GestureGalleryUI.this));
                  str = com.tencent.mm.loader.j.b.aps() + str + ".mp4";
                  if (!new com.tencent.mm.vfs.e(str).exists())
                  {
                    if (i.lZ(GestureGalleryUI.t(GestureGalleryUI.this), str) < 0L)
                    {
                      ac.e("MicroMsg.GestureGalleryUI", "copy file fail origin path:%s", new Object[] { GestureGalleryUI.t(GestureGalleryUI.this) });
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
                      ac.i("MicroMsg.GestureGalleryUI", "send video to file size :%d, MaxSendVideoSize:%d", new Object[] { Long.valueOf(l), Integer.valueOf(com.tencent.mm.m.b.ZH()) });
                      if (l <= 0L)
                      {
                        h.a(GestureGalleryUI.this.getContext(), GestureGalleryUI.this.getString(2131759798), "", GestureGalleryUI.this.getString(2131760315), null);
                        AppMethodBeat.o(179703);
                        return;
                      }
                      if (l > com.tencent.mm.m.b.ZH())
                      {
                        h.a(GestureGalleryUI.this.getContext(), GestureGalleryUI.this.getString(2131759816), "", GestureGalleryUI.this.getString(2131760315), null);
                        AppMethodBeat.o(179703);
                        return;
                      }
                      ac.i("MicroMsg.GestureGalleryUI", "select contact in SelectConversationUI");
                      localObject = new Intent();
                      ((Intent)localObject).putExtra("image_path", GestureGalleryUI.t(GestureGalleryUI.this));
                      ((Intent)localObject).putExtra("Retr_Msg_Type", 1);
                      ((Intent)localObject).putExtra("Select_Conv_Type", 3);
                      ((Intent)localObject).putExtra("select_is_ret", true);
                      ((Intent)localObject).putExtra("mutil_select_is_ret", true);
                      com.tencent.mm.br.d.c(GestureGalleryUI.this.getContext(), ".ui.transmit.SelectConversationUI", (Intent)localObject, 1);
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
            com.tencent.mm.plugin.subapp.b.iyx.k(paramAnonymousMenuItem, GestureGalleryUI.this.getContext());
            AppMethodBeat.o(29066);
            return;
            if ((GestureGalleryUI.j(GestureGalleryUI.this) == null) || (GestureGalleryUI.j(GestureGalleryUI.this).equals(""))) {
              break;
            }
            GestureGalleryUI.d(GestureGalleryUI.this, 2);
            az.ayM();
            if (!com.tencent.mm.model.c.isSDCardAvailable())
            {
              t.g(GestureGalleryUI.this, null);
              AppMethodBeat.o(29066);
              return;
            }
            if (GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.c(GestureGalleryUI.this)))
            {
              com.tencent.mm.platformtools.p.b(GestureGalleryUI.this, GestureGalleryUI.t(GestureGalleryUI.this), new p.a()
              {
                public final void bD(String paramAnonymous2String1, String paramAnonymous2String2)
                {
                  AppMethodBeat.i(196089);
                  Toast.makeText(GestureGalleryUI.this, GestureGalleryUI.this.getString(2131764683, new Object[] { com.tencent.mm.sdk.f.b.aLU(paramAnonymous2String2) }), 1).show();
                  com.tencent.mm.pluginsdk.ui.tools.q.k(paramAnonymous2String2, GestureGalleryUI.this);
                  AppMethodBeat.o(196089);
                }
                
                public final void bE(String paramAnonymous2String1, String paramAnonymous2String2)
                {
                  AppMethodBeat.i(196090);
                  Toast.makeText(GestureGalleryUI.this, GestureGalleryUI.this.getString(2131764682), 1).show();
                  AppMethodBeat.o(196090);
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
              paramAnonymousMenuItem = ((AppBrandMediaSource)GestureGalleryUI.u(GestureGalleryUI.this).get(GestureGalleryUI.c(GestureGalleryUI.this))).gSO;
              if (i.eA(paramAnonymousMenuItem)) {}
              for (;;)
              {
                com.tencent.mm.pluginsdk.model.g.a((cs)localObject1, 1, GestureGalleryUI.j(GestureGalleryUI.this), paramAnonymousMenuItem, "", "", true);
                ((cs)localObject1).dck.activity = GestureGalleryUI.this;
                ((cs)localObject1).dck.dcq = 32;
                com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
                AppMethodBeat.o(29066);
                return;
                paramAnonymousMenuItem = GestureGalleryUI.x(GestureGalleryUI.this).c(paramAnonymousMenuItem, GestureGalleryUI.v(GestureGalleryUI.this), GestureGalleryUI.c(GestureGalleryUI.this), GestureGalleryUI.w(GestureGalleryUI.this));
              }
            }
            paramAnonymousMenuItem = new cs();
            com.tencent.mm.pluginsdk.model.g.a(paramAnonymousMenuItem, 1, GestureGalleryUI.j(GestureGalleryUI.this));
            paramAnonymousMenuItem.dck.activity = GestureGalleryUI.this;
            paramAnonymousMenuItem.dck.dcq = 32;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousMenuItem);
            AppMethodBeat.o(29066);
            return;
            GestureGalleryUI.d(GestureGalleryUI.this, 6);
            paramAnonymousMenuItem = GestureGalleryUI.e(GestureGalleryUI.this);
            localObject1 = paramAnonymousMenuItem.zRh.cqG();
            if (((paramAnonymousMenuItem.qOW != 0) && (paramAnonymousMenuItem.qOW != 2)) || (bs.isNullOrNil((String)localObject1))) {
              break;
            }
            localObject2 = new bo();
            if (paramAnonymousMenuItem.qOW == 2)
            {
              l = 1L;
              ((bo)localObject2).dHY = l;
              ((bo)localObject2).dCQ = 3L;
              if (!paramAnonymousMenuItem.zRi) {
                break label1168;
              }
              l = 6L;
              ((bo)localObject2).dNc = l;
              ((bo)localObject2).aHZ();
              paramAnonymousMenuItem.qOV = ((int)(u.axw().hashCode() + System.currentTimeMillis()));
              localObject2 = ((com.tencent.mm.plugin.scanner.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.scanner.d.class)).getTranslationResult((String)localObject1);
              if ((localObject2 == null) || (!i.eA(((ff)localObject2).field_resultFile))) {
                break label1180;
              }
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("original_file_path", (String)localObject1);
              if (!paramAnonymousMenuItem.zRi) {
                break label1175;
              }
            }
            for (paramAnonymousInt = 6;; paramAnonymousInt = 5)
            {
              ((Intent)localObject2).putExtra("translate_source", paramAnonymousInt);
              ((Intent)localObject2).setClass(paramAnonymousMenuItem.activity, TranslationResultUI.class);
              localObject1 = paramAnonymousMenuItem.activity;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousMenuItem.activity.finish();
              paramAnonymousMenuItem.activity.overridePendingTransition(2130771986, 2130771986);
              AppMethodBeat.o(29066);
              return;
              l = 0L;
              break;
              l = 5L;
              break label936;
            }
            sd.a locala;
            if ((com.tencent.mm.kernel.g.agi().aBK() != 6) && (com.tencent.mm.kernel.g.agi().aBK() != 4))
            {
              h.c(paramAnonymousMenuItem.activity, paramAnonymousMenuItem.activity.getString(2131755828), "", true);
              paramAnonymousMenuItem.cqS();
              ac.i("MicroMsg.GestureGalleryTransLogic", "try to translate img %s, sessionId %d", new Object[] { localObject1, Integer.valueOf(paramAnonymousMenuItem.qOV) });
              localObject2 = new sd();
              locala = ((sd)localObject2).dve;
              if (!paramAnonymousMenuItem.zRi) {
                break label1372;
              }
            }
            for (;;)
            {
              locala.scene = paramAnonymousInt;
              ((sd)localObject2).dve.filePath = ((String)localObject1);
              ((sd)localObject2).dve.daq = paramAnonymousMenuItem.qOV;
              com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
              break;
              paramAnonymousMenuItem.qOW = 1;
              paramAnonymousMenuItem.qOY.setVisibility(0);
              paramAnonymousMenuItem.qOZ.setVisibility(0);
              paramAnonymousMenuItem.qPa.setVisibility(0);
              paramAnonymousMenuItem.qPb.setRepeatMode(1);
              paramAnonymousMenuItem.qPb.setRepeatCount(-1);
              paramAnonymousMenuItem.qPb.start();
              break label1226;
              paramAnonymousInt = 5;
            }
          }
        }
      }
    };
    this.zRu.Ihj = new e.b()
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
        GestureGalleryUI.E(GestureGalleryUI.this).wVE = null;
        AppMethodBeat.o(29067);
      }
    };
    if (!getContext().isFinishing()) {
      if ((!this.hlH) || (eaN()) || (this.qMJ)) {
        break label273;
      }
    }
    Object localObject;
    String str;
    for (;;)
    {
      if (i != 0) {
        this.zRu.cED();
      }
      if ((this.zRv) && (bs.isNullOrNil(this.yzo)) && (az.agi().aBK() != 0))
      {
        localObject = new ps();
        ((ps)localObject).dsJ.dao = System.currentTimeMillis();
        ((ps)localObject).dsJ.filePath = this.zRo;
        ((ps)localObject).dsJ.dsK = new HashSet(this.zRz);
        this.yzl = this.zRo;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      }
      if (bs.isNullOrNil(this.zRo)) {
        break label315;
      }
      com.tencent.mm.kernel.g.agS();
      if ((com.tencent.mm.kernel.g.agQ().ghe.aBK() == 0) || (!paramBoolean)) {
        break label315;
      }
      localObject = this.zRD;
      str = this.zRo;
      if ((((a)localObject).activity != null) && (!((a)localObject).activity.isFinishing())) {
        break;
      }
      AppMethodBeat.o(29102);
      return;
      label273:
      i = 1;
    }
    if (((a)localObject).qOU == null) {
      ((a)localObject).qOU = new ImageWordScanDetailEngine(((a)localObject).activity);
    }
    ((a)localObject).qOU.a(str, ((a)localObject).qOT);
    label315:
    AppMethodBeat.o(29102);
  }
  
  public final void bSg()
  {
    AppMethodBeat.i(29100);
    if ((this.zRn.getSelectedItemPosition() != this.zRS) || (!this.zRB))
    {
      finish();
      overridePendingTransition(0, 0);
      AppMethodBeat.o(29100);
      return;
    }
    if ((this.zRU) || (this.zRm == null))
    {
      ac.i("MicroMsg.GestureGalleryUI", "isRunningExitAnimation");
      AppMethodBeat.o(29100);
      return;
    }
    ac.i("MicroMsg.GestureGalleryUI", "runExitAnimation");
    int k = this.zRn.getWidth();
    int i = this.zRn.getHeight();
    int j = this.zRn.getSelectedItemPosition();
    Object localObject = (String)this.zRP.get(j);
    if (i.eA((String)localObject))
    {
      if (bs.isNullOrNil((String)localObject)) {
        break label412;
      }
      localObject = com.tencent.mm.sdk.platformtools.f.aKw((String)localObject);
      float f = k / ((BitmapFactory.Options)localObject).outWidth;
      j = (int)(((BitmapFactory.Options)localObject).outHeight * f);
      i = j;
      if (j > this.zRn.getHeight())
      {
        if (j < this.zRn.getHeight() * 2.5D) {
          this.ocZ = (this.zRn.getHeight() * this.ocZ / j);
        }
        i = this.zRn.getHeight();
      }
    }
    label412:
    for (;;)
    {
      this.ocV.jN(k, i);
      this.ocV.R(this.ocX, this.ocW, this.ocY, this.ocZ);
      if (this.yIR != 1.0D)
      {
        this.ocV.IRh = (1.0F / this.yIR);
        if ((this.yIS != 0) || (this.yIT != 0))
        {
          j = (int)(this.zRn.getWidth() / 2 * (1.0F - this.yIR));
          k = this.yIS;
          i = (int)(this.zRn.getHeight() / 2 + this.yIT - i / 2 * this.yIR);
          this.ocV.jP(j + k, i);
        }
      }
      this.ocV.a(this.zRn, this.ocQ, new e.c()
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
              View localView = GestureGalleryUI.m(GestureGalleryUI.this).eaR();
              if ((localView instanceof MultiTouchImageView)) {
                ((MultiTouchImageView)localView).fij();
              }
              AppMethodBeat.o(29079);
            }
          }, 20L);
          AppMethodBeat.o(29081);
        }
      }, null);
      AppMethodBeat.o(29100);
      return;
      localObject = this.zRp.c((String)localObject, this.type, j, this.hnq);
      break;
    }
  }
  
  public final String cqG()
  {
    return this.zRo;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29101);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ac.d("MicroMsg.GestureGalleryUI", "dispatchKeyEvent");
      bSg();
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
    String str1 = bs.nullAsNil(getIntent().getStringExtra("nowUrl"));
    this.kLZ = bs.nullAsNil(getIntent().getStringExtra("nowUrlPath"));
    this.zRT = bs.nullAsNil(getIntent().getStringExtra("nowWebUrl"));
    this.type = getIntent().getIntExtra("type", 0);
    Object localObject = getIntent().getParcelableArrayListExtra("mediaSource");
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.zRQ.clear();
      this.zRQ.addAll((Collection)localObject);
    }
    localObject = getIntent().getStringArrayExtra("urlList");
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = bs.nullAsNil(getIntent().getStringExtra("htmlData"));
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
          ac.d("MicroMsg.GestureGalleryUI", "start:" + j + " end:" + i + " url:" + str2);
          this.zRP.add(str2);
          continue;
          this.zRP = Arrays.asList((Object[])localObject);
        }
      }
    }
    final int i = 0;
    for (;;)
    {
      if (i < this.zRP.size())
      {
        if (str1.equals(this.zRP.get(i))) {
          this.zRR = i;
        }
      }
      else
      {
        this.zRS = this.zRR;
        if (getIntent().getIntExtra("currentPos", -1) >= 0) {
          this.zRS = getIntent().getIntExtra("currentPos", -1);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(29074);
            GestureGalleryUI.this.bSg();
            AppMethodBeat.o(29074);
            return true;
          }
        });
        this.zRC = ((TextView)findViewById(2131303133));
        this.ocQ = ((ImageView)findViewById(2131300336));
        this.zRI = ((RelativeLayout)findViewById(2131306407));
        this.zRK = ((RedesignVideoPlayerSeekBar)findViewById(2131306375));
        this.zRJ = ((PressAlphaImageView)findViewById(2131306316));
        this.zRJ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(179707);
            GestureGalleryUI.this.bSg();
            AppMethodBeat.o(179707);
          }
        });
        this.zRK.setPlayBtnOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(179708);
            if (GestureGalleryUI.K(GestureGalleryUI.this).caY())
            {
              GestureGalleryUI.S(GestureGalleryUI.this);
              AppMethodBeat.o(179708);
              return;
            }
            GestureGalleryUI.T(GestureGalleryUI.this);
            AppMethodBeat.o(179708);
          }
        });
        this.zRK.setVideoTotalTime(0);
        this.zRK.seek(0);
        this.zRK.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
        {
          public final void anR() {}
          
          public final void nn(int paramAnonymousInt)
          {
            AppMethodBeat.i(179709);
            if (GestureGalleryUI.U(GestureGalleryUI.this) != null) {
              GestureGalleryUI.U(GestureGalleryUI.this).zSi.seekTo(paramAnonymousInt * 1000);
            }
            AppMethodBeat.o(179709);
          }
        });
        this.zRm = new a();
        this.zRn = ((MMGestureGallery)findViewById(2131300335));
        this.zRn.setVisibility(0);
        this.zRn.setVerticalFadingEdgeEnabled(false);
        this.zRn.setHorizontalFadingEdgeEnabled(false);
        this.zRn.setAdapter(this.zRm);
        this.zRn.setSelection(this.zRR);
        this.zRn.setOnItemSelectedListener(this.zRV);
        this.zRn.setSingleClickOverListener(new MMGestureGallery.f()
        {
          public final void aOd()
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
              if (GestureGalleryUI.e(GestureGalleryUI.this).qOW != 1) {
                GestureGalleryUI.this.bSg();
              }
              AppMethodBeat.o(29075);
              return;
            }
          }
        });
        i = getIntent().getIntExtra("nevNext", 1);
        this.zRn.setLongClickOverListener(new MMGestureGallery.c()
        {
          public final void aOe()
          {
            boolean bool2 = true;
            AppMethodBeat.i(29077);
            if (GestureGalleryUI.e(GestureGalleryUI.this).qOW == 1)
            {
              AppMethodBeat.o(29077);
              return;
            }
            if ((GestureGalleryUI.f(GestureGalleryUI.this)) && (!GestureGalleryUI.g(GestureGalleryUI.this)))
            {
              ac.e("MicroMsg.GestureGalleryUI", "is from appbrand, but showmenu is false, don't show menu");
              AppMethodBeat.o(29077);
              return;
            }
            GestureGalleryUI.a(GestureGalleryUI.this, new com.tencent.mm.plugin.webview.j.g());
            GestureGalleryUI.h(GestureGalleryUI.this).reset(2);
            Object localObject1;
            if (1 == i)
            {
              localObject1 = y.ayq().F("basescanui@datacenter", true);
              ((y.b)localObject1).l("key_basescanui_screen_x", Integer.valueOf(GestureGalleryUI.i(GestureGalleryUI.this).getXDown()));
              ((y.b)localObject1).l("key_basescanui_screen_y", Integer.valueOf(GestureGalleryUI.i(GestureGalleryUI.this).getYDown()));
              if ((GestureGalleryUI.e(GestureGalleryUI.this).qOW == 0) || (GestureGalleryUI.e(GestureGalleryUI.this).qOW == 2))
              {
                localObject1 = GestureGalleryUI.e(GestureGalleryUI.this);
                Object localObject2 = new bo();
                long l;
                label233:
                boolean bool1;
                if (((a)localObject1).qOW == 2)
                {
                  l = 1L;
                  ((bo)localObject2).dHY = l;
                  ((bo)localObject2).dCQ = 1L;
                  if (!((a)localObject1).zRi) {
                    break label392;
                  }
                  l = 6L;
                  ((bo)localObject2).dNc = l;
                  ((bo)localObject2).aHZ();
                  localObject1 = GestureGalleryUI.this;
                  int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("EnableWebviewPicTranslation", 0);
                  localObject2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("PicTranslationSupportUserLanguage");
                  if (i != 1) {
                    break label400;
                  }
                  bool1 = true;
                  label299:
                  ac.i("MicroMsg.ScannerHelper", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool1), localObject2, ab.eUO() });
                  if ((i != 1) || (bs.isNullOrNil((String)localObject2))) {
                    break label405;
                  }
                  localObject2 = ((String)localObject2).split(";");
                  if ((localObject2 == null) || (!Arrays.asList((Object[])localObject2).contains(ab.eUO()))) {
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
                  if (!com.tencent.mm.protocal.d.DIg) {
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
                public final void kG(int paramAnonymous2Int)
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
                    com.tencent.mm.plugin.subapp.b.iyx.k(localIntent, localGestureGalleryUI.getContext());
                  }
                }
              });
            }
            AppMethodBeat.o(29077);
          }
        });
        this.ocV = new com.tencent.mm.ui.tools.e(this);
        AppMethodBeat.o(29098);
        return;
      }
      i += 1;
    }
  }
  
  public final void k(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(29092);
    if (this.zRm != null)
    {
      if (paramInt == this.zRn.getSelectedItemPosition())
      {
        this.zRo = paramString2;
        ac.d("MicroMsg.GestureGalleryUI", "onDownSucc, curFilename:%s, url:%s", new Object[] { this.zRo, paramString1 });
      }
      this.zRm.notifyDataSetChanged();
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
            this.qLa.dismiss();
            AppMethodBeat.o(179716);
          }
        };
        if (!bs.isNullOrNil((String)localObject)) {
          break label93;
        }
        AppMethodBeat.o(179726);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label93:
      Iterator localIterator = bs.S(((String)localObject).split(",")).iterator();
      while (localIterator.hasNext())
      {
        final String str2 = (String)localIterator.next();
        String str1 = ((AppBrandMediaSource)this.zRQ.get(this.zRR)).gSO;
        localObject = str1;
        if (!i.eA(str1)) {
          localObject = this.zRp.c(str1, this.type, this.zRR, this.hnq);
        }
        ac.i("MicroMsg.GestureGalleryUI", "onActivityResult,  sendVideo video:%s,  thumbFilename:%s", new Object[] { eaO(), localObject });
        com.tencent.mm.kernel.g.agU().az(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179717);
            j.dck().a(GestureGalleryUI.this.getContext(), str2, GestureGalleryUI.t(GestureGalleryUI.this), this.zSc, 1, (int)GestureGalleryUI.V(GestureGalleryUI.this), "", "");
            ap.f(local19);
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
        if (!bs.isNullOrNil(paramIntent)) {
          j.dck().X(str2, paramIntent, w.xt(str2));
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
    this.ocU = paramBundle;
    this.zRO.alive();
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setFlags(1024, 1024);
      getWindow().addFlags(67108864);
    }
    fullScreenNoTitleBar(true);
    this.zRs = getIntent().getBooleanExtra("isFromAppBrand", false);
    this.hlH = getIntent().getBooleanExtra("forBidForward", false);
    this.zRq = getIntent().getBooleanExtra("isFromWebView", false);
    this.zRt = getIntent().getBooleanExtra("showmenu", true);
    this.zRr = getIntent().getBooleanExtra("isOuntLink", false);
    this.hnf = getIntent().getStringExtra("IsFromWebViewReffer");
    this.zRv = getIntent().getBooleanExtra("shouldShowScanQrCodeMenu", false);
    this.zRB = getIntent().getBooleanExtra("shouldRunDragAnimation", false);
    this.zRy = getIntent().getIntExtra("scanQrCodeGetA8KeyScene", 0);
    paramBundle = getIntent().getIntArrayExtra("scanCodeTypes");
    int i;
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      i = 0;
      while (i < paramBundle.length)
      {
        this.zRz.add(Integer.valueOf(paramBundle[i]));
        i += 1;
      }
    }
    paramBundle = getIntent().getIntArrayExtra("scanResultCodeTypes");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      i = 0;
      while (i < paramBundle.length)
      {
        this.zRA.add(Integer.valueOf(paramBundle[i]));
        i += 1;
      }
    }
    this.zRD = new a(this, this, this, this.zRr);
    this.hnq = getIntent().getStringExtra("cookie");
    ac.d("MicroMsg.GestureGalleryUI", "isFromWebView: %b, isFromWebViewReffer:%s, cookie = %s, forbidForward=%b", new Object[] { Boolean.valueOf(this.zRq), this.hnf, this.hnq, Boolean.valueOf(this.hlH) });
    this.zRp = new aa(this.zRq, this.hnf);
    paramBundle = this.zRp;
    ac.d("MicroMsg.GetPicService", "addListener :" + hashCode());
    paramBundle.hnh = this;
    com.tencent.mm.sdk.b.a.GpY.c(this.qMM);
    com.tencent.mm.sdk.b.a.GpY.c(this.yzx);
    initView();
    this.zRU = false;
    if (this.zRs) {
      getWindow().setBackgroundDrawableResource(2131231318);
    }
    this.kYG = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a()
    {
      public final void bly()
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
    Object localObject = this.zRp;
    ac.d("MicroMsg.GetPicService", "removeListener :" + hashCode());
    ((aa)localObject).hnh = null;
    localObject = this.zRp;
    if (((aa)localObject).hnd != null) {
      ((aa)localObject).hnd.hnl = true;
    }
    ((aa)localObject).hnd = null;
    com.tencent.mm.sdk.b.a.GpY.d(this.qMM);
    com.tencent.mm.sdk.b.a.GpY.d(this.yzx);
    this.zRO.dead();
    gu(this);
    if (this.zRD != null)
    {
      localObject = this.zRD;
      ((a)localObject).cqU();
      ((a)localObject).qPb.removeAllUpdateListeners();
      ((a)localObject).qPc.dead();
      com.tencent.mm.kernel.g.agQ().b(((a)localObject).qPd);
      ((a)localObject).qOT = null;
      ((a)localObject).activity = null;
      ((a)localObject).zRh = null;
    }
    localObject = new qf();
    ((qf)localObject).dtk.activity = this;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    ac.i("MicroMsg.GestureGalleryUI", "stopVideo");
    if (this.zRG != null)
    {
      this.zRG.zSi.stopPlayback();
      this.zRM = c.zSs;
      this.zRK.setIsPlay(false);
      this.zRK.setIplaySeekCallback(null);
      this.zRG.yBx.setVisibility(0);
      this.zRG.sil.setVisibility(0);
      this.zRG.zSi.setVisibility(8);
    }
    eaQ();
    AppMethodBeat.o(29094);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29095);
    super.onPause();
    crH();
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
    Bundle localBundle = this.ocU;
    if ((this.isAnimated) || (!this.zRB)) {}
    for (;;)
    {
      super.onStart();
      AppMethodBeat.o(29099);
      return;
      this.isAnimated = true;
      this.ocW = getIntent().getIntExtra("img_gallery_top", 0);
      this.ocX = getIntent().getIntExtra("img_gallery_left", 0);
      this.ocY = getIntent().getIntExtra("img_gallery_width", 0);
      this.ocZ = getIntent().getIntExtra("img_gallery_height", 0);
      this.ocV.R(this.ocX, this.ocW, this.ocY, this.ocZ);
      if (localBundle == null) {
        this.zRn.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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
    if (this.yzo != null)
    {
      as localas = new as();
      localas.dal.activity = this;
      localas.dal.dam = this.yzo;
      com.tencent.mm.sdk.b.a.GpY.l(localas);
      this.yzo = null;
      this.zRx = 0;
      this.zRw = 0;
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
    
    private View QZ(int paramInt)
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
    
    public final View eaR()
    {
      AppMethodBeat.i(29088);
      View localView = QZ(GestureGalleryUI.this.zRn.getSelectedItemPosition());
      AppMethodBeat.o(29088);
      return localView;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(29086);
      ac.d("MicroMsg.GestureGalleryUI", "lstpicurl:" + GestureGalleryUI.J(GestureGalleryUI.this).size());
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
        if ((paramView == null) || ((i != 0) && (paramViewGroup != null) && (paramViewGroup.zSi == null)))
        {
          localObject1 = new a();
          localView = View.inflate(GestureGalleryUI.this, 2131495191, null);
          ((a)localObject1).zSg = ((ProgressBar)localView.findViewById(2131303535));
          ((a)localObject1).zSh = ((MMAnimateView)localView.findViewById(2131300914));
          ((a)localObject1).sil = ((ImageView)localView.findViewById(2131305793));
          ((a)localObject1).sHv = localView.findViewById(2131306319);
          ((a)localObject1).zSi = ((VideoView)localView.findViewById(2131306410));
          ((a)localObject1).yBx = ((ImageView)localView.findViewById(2131306413));
          ((a)localObject1).zSj = localView.findViewById(2131306339);
          ((a)localObject1).zSk = ((TextView)localView.findViewById(2131306340));
          if (i != 0)
          {
            ((a)localObject1).sil.setVisibility(8);
            ((a)localObject1).sil = ((ImageView)localView.findViewById(2131306347));
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
            paramView = ((AppBrandMediaSource)localObject2).gSO;
            j = 1;
          }
          paramViewGroup = paramView;
          if (!i.eA(paramView))
          {
            paramView = GestureGalleryUI.x(GestureGalleryUI.this).c(paramView, GestureGalleryUI.v(GestureGalleryUI.this), paramInt, GestureGalleryUI.w(GestureGalleryUI.this));
            paramViewGroup = paramView;
            if (paramInt == GestureGalleryUI.L(GestureGalleryUI.this))
            {
              paramViewGroup = paramView;
              if (bs.isNullOrNil(paramView))
              {
                paramViewGroup = paramView;
                if (i.eA(GestureGalleryUI.M(GestureGalleryUI.this))) {
                  paramViewGroup = GestureGalleryUI.M(GestureGalleryUI.this);
                }
              }
            }
          }
          for (i = 1;; i = k)
          {
            ((a)localObject1).zSi.setVisibility(8);
            ((a)localObject1).zSi.stopPlayback();
            if (j != 0)
            {
              ((a)localObject1).sHv.setVisibility(0);
              GestureGalleryUI.b(GestureGalleryUI.this, (a)localObject1);
              if (bs.isNullOrNil(paramViewGroup)) {
                break label1368;
              }
              ((a)localObject1).zSg.setVisibility(8);
              if ((GestureGalleryUI.u(GestureGalleryUI.this) != null) && (!GestureGalleryUI.u(GestureGalleryUI.this).isEmpty())) {
                TextUtils.isEmpty(((AppBrandMediaSource)GestureGalleryUI.u(GestureGalleryUI.this).get(paramInt)).gSO);
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
              ((a)localObject1).sHv.setVisibility(8);
              break;
              label600:
              localObject2 = com.tencent.mm.av.a.a.aFG().Cz(paramViewGroup + "_" + i.aSp(paramViewGroup));
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
                  ac.i("MicroMsg.GestureGalleryUI", "recycle bitmap:%s", new Object[] { paramView.toString() });
                  paramView.recycle();
                }
                localObject2 = com.tencent.mm.sdk.platformtools.f.aKz(paramViewGroup);
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
                  ac.i("MicroMsg.GestureGalleryUI", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(bool) });
                  if (paramView != null) {
                    break label793;
                  }
                  ac.e("MicroMsg.GestureGalleryUI", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramViewGroup)));
                  paramView = null;
                  break;
                }
                label793:
                com.tencent.mm.av.a.a.aFG().h(paramViewGroup + "_" + i.aSp(paramViewGroup), paramView);
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
                k = aj.cl(GestureGalleryUI.this.getContext()).x;
                m = aj.cl(GestureGalleryUI.this.getContext()).y;
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
              if (!s.aKD(paramViewGroup)) {
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
                ((a)localObject1).zSh.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((a)localObject1).sil.setVisibility(8);
                ((a)localObject1).zSh.setVisibility(0);
                localObject2 = ((a)localObject1).zSh;
                ((MMAnimateView)localObject2).txg = GestureGalleryUI.f(GestureGalleryUI.this);
                ((MMAnimateView)localObject2).gV(paramViewGroup, null);
                AppMethodBeat.o(29090);
                return localView;
                k = 0;
              }
              catch (Exception paramViewGroup)
              {
                ac.e("MicroMsg.GestureGalleryUI", bs.m(paramViewGroup));
                ((a)localObject1).zSh.setVisibility(0);
                ((a)localObject1).sil.setVisibility(8);
                ((a)localObject1).zSh.setImageBitmap(paramView);
                continue;
              }
              label1111:
              if ((i != 0) && (paramView != null) && (!paramView.isRecycled()))
              {
                ((a)localObject1).zSg.setVisibility(0);
                ((a)localObject1).sil.setVisibility(0);
                ((a)localObject1).sil.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((a)localObject1).sil.setImageBitmap(paramView);
              }
              else if ((j != 0) && (paramView != null) && (!paramView.isRecycled()))
              {
                ((a)localObject1).zSg.setVisibility(8);
                ((a)localObject1).sil.setVisibility(0);
                ((a)localObject1).sil.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((a)localObject1).sil.setImageBitmap(paramView);
              }
              else if ((paramView != null) && (!paramView.isRecycled()))
              {
                ((a)localObject1).zSh.setVisibility(8);
                ((a)localObject1).sil.setVisibility(8);
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
                ((a)localObject1).zSg.setVisibility(0);
                ((a)localObject1).zSh.setVisibility(8);
                ((a)localObject1).sil.setVisibility(8);
                ((a)localObject1).sHv.setVisibility(8);
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
      View sHv;
      ImageView sil;
      ImageView yBx;
      ProgressBar zSg;
      MMAnimateView zSh;
      VideoView zSi;
      View zSj;
      TextView zSk;
      
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
      ac.i("MicroMsg.GestureGalleryUI", "start run play progress task");
      for (;;)
      {
        if (this.isStop) {
          break label127;
        }
        try
        {
          if ((GestureGalleryUI.W(GestureGalleryUI.this) == GestureGalleryUI.c.zSo) || (GestureGalleryUI.W(GestureGalleryUI.this) == GestureGalleryUI.c.zSn) || (GestureGalleryUI.W(GestureGalleryUI.this) == GestureGalleryUI.c.zSp))
          {
            GestureGalleryUI localGestureGalleryUI = GestureGalleryUI.this;
            if (localGestureGalleryUI.zRG != null) {
              localGestureGalleryUI.zRK.post(new GestureGalleryUI.18(localGestureGalleryUI));
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.e("MicroMsg.GestureGalleryUI", "PlayProgressTask run exception:" + localException.getMessage());
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
      zSm = new c("Idle", 0);
      zSn = new c("Prepared", 1);
      zSo = new c("Start", 2);
      zSp = new c("Resume", 3);
      zSq = new c("Paused", 4);
      zSr = new c("Complete", 5);
      zSs = new c("Stop", 6);
      zSt = new c("Error", 7);
      zSu = new c[] { zSm, zSn, zSo, zSp, zSq, zSr, zSs, zSt };
      AppMethodBeat.o(179722);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI
 * JD-Core Version:    0.7.0.1
 */