package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.al;
import com.tencent.mm.h.a.mz;
import com.tencent.mm.h.a.nb;
import com.tencent.mm.model.au;
import com.tencent.mm.model.w;
import com.tencent.mm.model.w.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class GestureGalleryUI
  extends MMActivity
  implements w.b
{
  private String dVl = "";
  private String dVt = null;
  private c kbV = new c() {};
  private volatile String oOL;
  private String oOO;
  private c oOV = new GestureGalleryUI.2(this);
  private String pwA;
  private w pwB;
  private boolean pwC = false;
  private d pwD;
  private volatile boolean pwE;
  private int pwF;
  private int pwG;
  private int pwH;
  private final Set<Integer> pwI = new HashSet();
  private final Set<Integer> pwJ = new HashSet();
  private List<String> pwK = new ArrayList();
  private int pwL = -1;
  private AdapterView.OnItemSelectedListener pwM = new AdapterView.OnItemSelectedListener()
  {
    public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      GestureGalleryUI.a(GestureGalleryUI.this, paramAnonymousInt);
      GestureGalleryUI.this.setMMTitle(GestureGalleryUI.k(GestureGalleryUI.this) + 1 + " / " + GestureGalleryUI.l(GestureGalleryUI.this).size());
      y.d("MicroMsg.GestureGalleryUI", "pos:" + paramAnonymousInt);
      GestureGalleryUI.c(GestureGalleryUI.this, GestureGalleryUI.o(GestureGalleryUI.this).c((String)GestureGalleryUI.l(GestureGalleryUI.this).get(paramAnonymousInt), GestureGalleryUI.m(GestureGalleryUI.this), paramAnonymousInt, GestureGalleryUI.n(GestureGalleryUI.this)));
      if (bk.bl(GestureGalleryUI.c(GestureGalleryUI.this))) {
        GestureGalleryUI.c(GestureGalleryUI.this, (String)GestureGalleryUI.l(GestureGalleryUI.this).get(paramAnonymousInt));
      }
    }
    
    public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
  };
  private GestureGalleryUI.a pwy;
  private MMGestureGallery pwz;
  private int type = 0;
  
  public final void e(String paramString1, String paramString2, int paramInt)
  {
    if (this.pwy != null)
    {
      if (paramInt == this.pwz.getSelectedItemPosition())
      {
        this.pwA = paramString2;
        y.d("MicroMsg.GestureGalleryUI", "onDownSucc, curFilename:%s, url:%s", new Object[] { this.pwA, paramString1 });
      }
      this.pwy.notifyDataSetChanged();
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.readerapp_imageview;
  }
  
  protected final void initView()
  {
    String str1 = bk.pm(getIntent().getStringExtra("nowUrl"));
    this.type = getIntent().getIntExtra("type", 0);
    Object localObject = getIntent().getStringArrayExtra("urlList");
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = bk.pm(getIntent().getStringExtra("htmlData"));
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
          y.d("MicroMsg.GestureGalleryUI", "start:" + j + " end:" + i + " url:" + str2);
          this.pwK.add(str2);
          continue;
          this.pwK = Arrays.asList((Object[])localObject);
        }
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < this.pwK.size())
      {
        if (str1.equals(this.pwK.get(i))) {
          this.pwL = i;
        }
      }
      else
      {
        setBackBtn(new GestureGalleryUI.1(this));
        this.pwy = new GestureGalleryUI.a(this);
        this.pwz = ((MMGestureGallery)findViewById(R.h.gallery));
        this.pwz.setVisibility(0);
        this.pwz.setVerticalFadingEdgeEnabled(false);
        this.pwz.setHorizontalFadingEdgeEnabled(false);
        this.pwz.setAdapter(this.pwy);
        this.pwz.setSelection(this.pwL);
        this.pwz.setOnItemSelectedListener(this.pwM);
        this.pwz.setSingleClickOverListener(new MMGestureGallery.f()
        {
          public final void aBS()
          {
            GestureGalleryUI.this.finish();
          }
        });
        i = getIntent().getIntExtra("nevNext", 1);
        this.pwz.setLongClickOverListener(new GestureGalleryUI.4(this, i));
        return;
      }
      i += 1;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    fullScreenNoTitleBar(true);
    this.pwC = getIntent().getBooleanExtra("isFromWebView", false);
    this.dVl = getIntent().getStringExtra("IsFromWebViewReffer");
    this.pwE = getIntent().getBooleanExtra("shouldShowScanQrCodeMenu", false);
    this.pwH = getIntent().getIntExtra("scanQrCodeGetA8KeyScene", 0);
    paramBundle = getIntent().getIntArrayExtra("scanCodeTypes");
    int i;
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      i = 0;
      while (i < paramBundle.length)
      {
        this.pwI.add(Integer.valueOf(paramBundle[i]));
        i += 1;
      }
    }
    paramBundle = getIntent().getIntArrayExtra("scanResultCodeTypes");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      i = 0;
      while (i < paramBundle.length)
      {
        this.pwJ.add(Integer.valueOf(paramBundle[i]));
        i += 1;
      }
    }
    this.dVt = getIntent().getStringExtra("cookie");
    y.d("MicroMsg.GestureGalleryUI", "isFromWebView: %b, isFromWebViewReffer:%s, cookie = %s", new Object[] { Boolean.valueOf(this.pwC), this.dVl, this.dVt });
    this.pwB = new w(this.pwC, this.dVl);
    paramBundle = this.pwB;
    y.d("MicroMsg.GetPicService", "addListener :" + hashCode());
    paramBundle.dVn = this;
    com.tencent.mm.sdk.b.a.udP.c(this.kbV);
    com.tencent.mm.sdk.b.a.udP.c(this.oOV);
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    w localw = this.pwB;
    y.d("MicroMsg.GetPicService", "removeListener :" + hashCode());
    localw.dVn = null;
    localw = this.pwB;
    if (localw.dVj != null) {
      localw.dVj.dVr = true;
    }
    localw.dVj = null;
    com.tencent.mm.sdk.b.a.udP.d(this.kbV);
    com.tencent.mm.sdk.b.a.udP.d(this.oOV);
  }
  
  public void onPause()
  {
    super.onPause();
    o.Dh(2);
  }
  
  public void onResume()
  {
    super.onResume();
    o.Dh(1);
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.oOO != null)
    {
      al localal = new al();
      localal.bGD.activity = this;
      localal.bGD.bGE = this.oOO;
      com.tencent.mm.sdk.b.a.udP.m(localal);
      this.oOO = null;
      this.pwG = 0;
      this.pwF = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI
 * JD-Core Version:    0.7.0.1
 */