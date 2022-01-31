package com.tencent.mm.plugin.subapp.ui.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.SpinnerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.an;
import com.tencent.mm.g.a.bv;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.la;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.x;
import com.tencent.mm.model.x.b;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class GestureGalleryUI
  extends MMActivity
  implements x.b
{
  private String flC;
  private String flu;
  private boolean isAnimated;
  private com.tencent.mm.ui.tools.e kip;
  private ImageView kuA;
  private Bundle kuF;
  private int kuG;
  private int kuH;
  private int kuI;
  private int kuJ;
  private ak mHandler;
  private com.tencent.mm.sdk.b.c mwt;
  private String rGA;
  private String rGB;
  private com.tencent.mm.sdk.b.c rGI;
  private volatile String rGw;
  private String rGz;
  private float rOd;
  private int rOe;
  private int rOf;
  private AdapterView.OnItemSelectedListener sYA;
  private a sYh;
  MMGestureGallery sYi;
  private String sYj;
  private x sYk;
  private boolean sYl;
  private boolean sYm;
  private com.tencent.mm.ui.widget.b.d sYn;
  private volatile boolean sYo;
  private int sYp;
  private int sYq;
  private int sYr;
  private final Set<Integer> sYs;
  private final Set<Integer> sYt;
  private boolean sYu;
  private com.tencent.mm.sdk.b.c<bv> sYv;
  private List<String> sYw;
  private int sYx;
  private int sYy;
  private boolean sYz;
  private int type;
  
  public GestureGalleryUI()
  {
    AppMethodBeat.i(25401);
    this.sYl = false;
    this.sYm = false;
    this.flu = "";
    this.flC = null;
    this.sYs = new HashSet();
    this.sYt = new HashSet();
    this.sYu = false;
    this.isAnimated = false;
    this.kuG = 0;
    this.kuH = 0;
    this.kuI = 0;
    this.kuJ = 0;
    this.mHandler = new ak();
    this.sYv = new GestureGalleryUI.1(this);
    this.sYw = new ArrayList();
    this.type = 0;
    this.sYx = -1;
    this.sYy = -1;
    this.rOd = 1.0F;
    this.rOe = 0;
    this.rOf = 0;
    this.sYz = false;
    this.sYA = new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(153673);
        GestureGalleryUI.c(GestureGalleryUI.this, paramAnonymousInt);
        GestureGalleryUI.this.setMMTitle(GestureGalleryUI.r(GestureGalleryUI.this) + 1 + " / " + GestureGalleryUI.s(GestureGalleryUI.this).size());
        ab.d("MicroMsg.GestureGalleryUI", "pos:".concat(String.valueOf(paramAnonymousInt)));
        GestureGalleryUI.e(GestureGalleryUI.this, GestureGalleryUI.v(GestureGalleryUI.this).c((String)GestureGalleryUI.s(GestureGalleryUI.this).get(paramAnonymousInt), GestureGalleryUI.t(GestureGalleryUI.this), paramAnonymousInt, GestureGalleryUI.u(GestureGalleryUI.this)));
        if (bo.isNullOrNil(GestureGalleryUI.c(GestureGalleryUI.this))) {
          GestureGalleryUI.e(GestureGalleryUI.this, (String)GestureGalleryUI.s(GestureGalleryUI.this).get(paramAnonymousInt));
        }
        GestureGalleryUI.e(GestureGalleryUI.this);
        AppMethodBeat.o(153673);
      }
      
      public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    };
    this.mwt = new com.tencent.mm.sdk.b.c() {};
    this.rGI = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(25401);
  }
  
  private static void fe(Context paramContext)
  {
    AppMethodBeat.i(138616);
    if ((Build.VERSION.SDK_INT < 19) || (Build.VERSION.SDK_INT > 22))
    {
      AppMethodBeat.o(138616);
      return;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(138616);
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
      AppMethodBeat.o(138616);
      return;
    }
    AppMethodBeat.o(138616);
  }
  
  public final void bdV()
  {
    AppMethodBeat.i(25410);
    if ((this.sYi.getSelectedItemPosition() != this.sYy) || (!this.sYu))
    {
      finish();
      overridePendingTransition(0, 0);
      AppMethodBeat.o(25410);
      return;
    }
    if ((this.sYz) || (this.sYh == null))
    {
      ab.i("MicroMsg.GestureGalleryUI", "isRunningExitAnimation");
      AppMethodBeat.o(25410);
      return;
    }
    ab.i("MicroMsg.GestureGalleryUI", "runExitAnimation");
    int k = this.sYi.getWidth();
    int i = this.sYi.getHeight();
    int j = this.sYi.getSelectedItemPosition();
    Object localObject = (String)this.sYw.get(j);
    if (com.tencent.mm.vfs.e.cN((String)localObject))
    {
      if (bo.isNullOrNil((String)localObject)) {
        break label410;
      }
      localObject = com.tencent.mm.sdk.platformtools.d.aoT((String)localObject);
      float f = k / ((BitmapFactory.Options)localObject).outWidth;
      j = (int)(((BitmapFactory.Options)localObject).outHeight * f);
      i = j;
      if (j > this.sYi.getHeight())
      {
        if (j < this.sYi.getHeight() * 2.5D) {
          this.kuJ = (this.sYi.getHeight() * this.kuJ / j);
        }
        i = this.sYi.getHeight();
      }
    }
    label410:
    for (;;)
    {
      this.kip.hO(k, i);
      this.kip.L(this.kuH, this.kuG, this.kuI, this.kuJ);
      if (this.rOd != 1.0D)
      {
        this.kip.AuR = (1.0F / this.rOd);
        if ((this.rOe != 0) || (this.rOf != 0))
        {
          j = (int)(this.sYi.getWidth() / 2 * (1.0F - this.rOd));
          k = this.rOe;
          i = (int)(this.sYi.getHeight() / 2 + this.rOf - i / 2 * this.rOd);
          this.kip.hQ(j + k, i);
        }
      }
      this.kip.a(this.sYi, this.kuA, new GestureGalleryUI.13(this), null);
      AppMethodBeat.o(25410);
      return;
      localObject = this.sYk.c((String)localObject, this.type, j, this.flC);
      break;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25411);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ab.d("MicroMsg.GestureGalleryUI", "dispatchKeyEvent");
      bdV();
      AppMethodBeat.o(25411);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(25411);
    return bool;
  }
  
  public final void g(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25402);
    if (this.sYh != null)
    {
      if (paramInt == this.sYi.getSelectedItemPosition())
      {
        this.sYj = paramString2;
        ab.d("MicroMsg.GestureGalleryUI", "onDownSucc, curFilename:%s, url:%s", new Object[] { this.sYj, paramString1 });
      }
      this.sYh.notifyDataSetChanged();
    }
    AppMethodBeat.o(25402);
  }
  
  public int getLayoutId()
  {
    return 2130970516;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25408);
    String str1 = bo.nullAsNil(getIntent().getStringExtra("nowUrl"));
    this.type = getIntent().getIntExtra("type", 0);
    Object localObject = getIntent().getStringArrayExtra("urlList");
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = bo.nullAsNil(getIntent().getStringExtra("htmlData"));
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
          ab.d("MicroMsg.GestureGalleryUI", "start:" + j + " end:" + i + " url:" + str2);
          this.sYw.add(str2);
          continue;
          this.sYw = Arrays.asList((Object[])localObject);
        }
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < this.sYw.size())
      {
        if (str1.equals(this.sYw.get(i))) {
          this.sYx = i;
        }
      }
      else
      {
        this.sYy = this.sYx;
        if (getIntent().getIntExtra("currentPos", -1) >= 0) {
          this.sYy = getIntent().getIntExtra("currentPos", -1);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(25383);
            GestureGalleryUI.this.bdV();
            AppMethodBeat.o(25383);
            return true;
          }
        });
        this.kuA = ((ImageView)findViewById(2131822135));
        this.kuA.setLayerType(2, null);
        this.sYh = new a();
        this.sYi = ((MMGestureGallery)findViewById(2131822137));
        this.sYi.setVisibility(0);
        this.sYi.setVerticalFadingEdgeEnabled(false);
        this.sYi.setHorizontalFadingEdgeEnabled(false);
        this.sYi.setAdapter(this.sYh);
        this.sYi.setSelection(this.sYx);
        this.sYi.setOnItemSelectedListener(this.sYA);
        this.sYi.setSingleClickOverListener(new MMGestureGallery.f()
        {
          public final void bdW()
          {
            AppMethodBeat.i(25384);
            GestureGalleryUI.this.bdV();
            AppMethodBeat.o(25384);
          }
        });
        i = getIntent().getIntExtra("nevNext", 1);
        this.sYi.setLongClickOverListener(new GestureGalleryUI.11(this, i));
        this.kip = new com.tencent.mm.ui.tools.e(this);
        AppMethodBeat.o(25408);
        return;
      }
      i += 1;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25403);
    super.onCreate(paramBundle);
    this.kuF = paramBundle;
    this.sYv.alive();
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setFlags(1024, 1024);
      getWindow().addFlags(67108864);
    }
    fullScreenNoTitleBar(true);
    this.sYl = getIntent().getBooleanExtra("isFromWebView", false);
    this.sYm = getIntent().getBooleanExtra("isOuntLink", false);
    this.flu = getIntent().getStringExtra("IsFromWebViewReffer");
    this.sYo = getIntent().getBooleanExtra("shouldShowScanQrCodeMenu", false);
    this.sYu = getIntent().getBooleanExtra("shouldRunDragAnimation", false);
    this.sYr = getIntent().getIntExtra("scanQrCodeGetA8KeyScene", 0);
    paramBundle = getIntent().getIntArrayExtra("scanCodeTypes");
    int i;
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      i = 0;
      while (i < paramBundle.length)
      {
        this.sYs.add(Integer.valueOf(paramBundle[i]));
        i += 1;
      }
    }
    paramBundle = getIntent().getIntArrayExtra("scanResultCodeTypes");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      i = 0;
      while (i < paramBundle.length)
      {
        this.sYt.add(Integer.valueOf(paramBundle[i]));
        i += 1;
      }
    }
    this.flC = getIntent().getStringExtra("cookie");
    ab.d("MicroMsg.GestureGalleryUI", "isFromWebView: %b, isFromWebViewReffer:%s, cookie = %s", new Object[] { Boolean.valueOf(this.sYl), this.flu, this.flC });
    this.sYk = new x(this.sYl, this.flu);
    paramBundle = this.sYk;
    ab.d("MicroMsg.GetPicService", "addListener :" + hashCode());
    paramBundle.flw = this;
    com.tencent.mm.sdk.b.a.ymk.c(this.mwt);
    com.tencent.mm.sdk.b.a.ymk.c(this.rGI);
    initView();
    this.sYz = false;
    AppMethodBeat.o(25403);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25404);
    super.onDestroy();
    x localx = this.sYk;
    ab.d("MicroMsg.GetPicService", "removeListener :" + hashCode());
    localx.flw = null;
    localx = this.sYk;
    if (localx.fls != null) {
      localx.fls.flA = true;
    }
    localx.fls = null;
    com.tencent.mm.sdk.b.a.ymk.d(this.mwt);
    com.tencent.mm.sdk.b.a.ymk.d(this.rGI);
    this.sYv.dead();
    fe(this);
    AppMethodBeat.o(25404);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(25405);
    super.onPause();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(2048, 2048);
    }
    o.La(2);
    AppMethodBeat.o(25405);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25406);
    super.onResume();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().clearFlags(2048);
    }
    o.La(1);
    AppMethodBeat.o(25406);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(25409);
    Bundle localBundle = this.kuF;
    if ((this.isAnimated) || (!this.sYu)) {}
    for (;;)
    {
      super.onStart();
      AppMethodBeat.o(25409);
      return;
      this.isAnimated = true;
      this.kuG = getIntent().getIntExtra("img_gallery_top", 0);
      this.kuH = getIntent().getIntExtra("img_gallery_left", 0);
      this.kuI = getIntent().getIntExtra("img_gallery_width", 0);
      this.kuJ = getIntent().getIntExtra("img_gallery_height", 0);
      this.kip.L(this.kuH, this.kuG, this.kuI, this.kuJ);
      if (localBundle == null) {
        this.sYi.getViewTreeObserver().addOnPreDrawListener(new GestureGalleryUI.12(this));
      }
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(25407);
    super.onStop();
    if (this.rGz != null)
    {
      an localan = new an();
      localan.cnQ.activity = this;
      localan.cnQ.cnR = this.rGz;
      com.tencent.mm.sdk.b.a.ymk.l(localan);
      this.rGz = null;
      this.sYq = 0;
      this.sYp = 0;
    }
    AppMethodBeat.o(25407);
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
    
    private View Gm(int paramInt)
    {
      AppMethodBeat.i(25399);
      int i = GestureGalleryUI.a(GestureGalleryUI.this).getFirstVisiblePosition();
      int j = GestureGalleryUI.a(GestureGalleryUI.this).getChildCount();
      if ((paramInt < i) || (paramInt > j + i - 1))
      {
        localView = GestureGalleryUI.a(GestureGalleryUI.this).getAdapter().getView(paramInt, null, GestureGalleryUI.a(GestureGalleryUI.this));
        AppMethodBeat.o(25399);
        return localView;
      }
      View localView = GestureGalleryUI.a(GestureGalleryUI.this).getChildAt(paramInt - i);
      AppMethodBeat.o(25399);
      return localView;
    }
    
    public final View cGX()
    {
      AppMethodBeat.i(25398);
      View localView = Gm(GestureGalleryUI.this.sYi.getSelectedItemPosition());
      AppMethodBeat.o(25398);
      return localView;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(25396);
      ab.d("MicroMsg.GestureGalleryUI", "lstpicurl:" + GestureGalleryUI.s(GestureGalleryUI.this).size());
      int i = GestureGalleryUI.s(GestureGalleryUI.this).size();
      AppMethodBeat.o(25396);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25397);
      AppMethodBeat.o(25397);
      return Integer.valueOf(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(25400);
      GestureGalleryUI.a.a locala;
      View localView;
      if (paramView == null)
      {
        locala = new GestureGalleryUI.a.a(this);
        localView = View.inflate(GestureGalleryUI.this, 2130970517, null);
        locala.rRL = ((ProgressBar)localView.findViewById(2131821246));
        locala.sYF = ((MMAnimateView)localView.findViewById(2131820629));
        localView.setTag(locala);
      }
      Object localObject;
      for (;;)
      {
        localView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        paramView = (String)GestureGalleryUI.s(GestureGalleryUI.this).get(paramInt);
        localObject = paramView;
        if (!com.tencent.mm.vfs.e.cN(paramView)) {
          localObject = GestureGalleryUI.v(GestureGalleryUI.this).c(paramView, GestureGalleryUI.t(GestureGalleryUI.this), paramInt, GestureGalleryUI.u(GestureGalleryUI.this));
        }
        if (bo.isNullOrNil((String)localObject)) {
          break label600;
        }
        locala.rRL.setVisibility(8);
        if (localObject != null) {
          break;
        }
        paramView = null;
        if ((!GestureGalleryUI.w(GestureGalleryUI.this)) || ((paramView != null) && (!paramView.isRecycled()))) {
          break label357;
        }
        GestureGalleryUI.this.finish();
        AppMethodBeat.o(25400);
        return localView;
        locala = (GestureGalleryUI.a.a)paramView.getTag();
        localView = paramView;
      }
      paramView = new BitmapFactory.Options();
      paramView.inJustDecodeBounds = true;
      paramView = BitmapFactory.decodeFile((String)localObject, paramView);
      if (paramView != null)
      {
        ab.i("MicroMsg.GestureGalleryUI", "recycle bitmap:%s", new Object[] { paramView.toString() });
        paramView.recycle();
      }
      paramView = com.tencent.mm.sdk.platformtools.d.aoV((String)localObject);
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = paramView;
        if (MMNativeJpeg.IsJpegFile((String)localObject))
        {
          paramViewGroup = paramView;
          if (MMNativeJpeg.isProgressive((String)localObject))
          {
            paramViewGroup = MMNativeJpeg.decodeAsBitmap((String)localObject);
            if (paramViewGroup != null) {
              break label351;
            }
          }
        }
      }
      label351:
      for (boolean bool = true;; bool = false)
      {
        ab.i("MicroMsg.GestureGalleryUI", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(bool) });
        paramView = paramViewGroup;
        if (paramViewGroup != null) {
          break;
        }
        ab.e("MicroMsg.GestureGalleryUI", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(localObject)));
        paramView = null;
        break;
      }
      label357:
      if ((paramView != null) && (!paramView.isRecycled()) && ((paramView.getWidth() > 1024) || (paramView.getHeight() > 1024))) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (r.aoY((String)localObject))) {
          if (paramInt == GestureGalleryUI.x(GestureGalleryUI.this)) {
            GestureGalleryUI.y(GestureGalleryUI.this);
          }
        }
        for (;;)
        {
          try
          {
            locala.sYF.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            locala.sYF.setVisibility(0);
            locala.sYF.setImageFilePath((String)localObject);
            AppMethodBeat.o(25400);
            return localView;
          }
          catch (Exception paramViewGroup)
          {
            ab.e("MicroMsg.GestureGalleryUI", bo.l(paramViewGroup));
            locala.sYF.setVisibility(0);
            locala.sYF.setImageBitmap(paramView);
            continue;
          }
          if ((paramView != null) && (!paramView.isRecycled()))
          {
            locala.sYF.setVisibility(8);
            paramViewGroup = new MultiTouchImageView(GestureGalleryUI.this, paramView.getWidth(), paramView.getHeight());
            if (Build.VERSION.SDK_INT == 20) {
              paramViewGroup.setLayerType(1, null);
            }
            for (;;)
            {
              paramViewGroup.setEnableHorLongBmpMode(false);
              paramViewGroup.setLayoutParams(new Gallery.LayoutParams(-1, -1));
              paramViewGroup.setImageBitmap(paramView);
              AppMethodBeat.o(25400);
              return paramViewGroup;
              com.tencent.mm.sdk.platformtools.n.x(paramViewGroup, paramView.getWidth(), paramView.getHeight());
            }
            label600:
            locala.rRL.setVisibility(0);
            locala.sYF.setVisibility(8);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI
 * JD-Core Version:    0.7.0.1
 */