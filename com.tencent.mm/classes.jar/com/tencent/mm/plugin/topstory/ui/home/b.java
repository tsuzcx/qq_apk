package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.e;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.topstory.a.e.a;
import com.tencent.mm.plugin.topstory.ui.d.b;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.plugin.topstory.ui.webview.e.10;
import com.tencent.mm.plugin.topstory.ui.webview.e.7;
import com.tencent.mm.plugin.topstory.ui.webview.e.9;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryViewPager;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.protocal.protobuf.cko;
import com.tencent.mm.protocal.protobuf.cku;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView.d;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class b
  implements a
{
  protected cko cKi;
  boolean cvo;
  private n fyJ;
  protected ThreeDotsLoadingView iTR;
  List<b.a> rQS;
  protected FrameLayout rwD;
  int stw;
  protected MMActivity tfZ;
  protected boolean tga;
  protected com.tencent.mm.plugin.topstory.ui.webview.c tgb;
  protected TopStoryWebView tgc;
  protected com.tencent.mm.plugin.topstory.ui.webview.e tgd;
  protected View tge;
  protected View tgf;
  protected List<d.b> tgg;
  View tgh;
  int tgi;
  long tgj;
  boolean tgk;
  private LinearLayout tgl;
  TopStoryViewPager tgm;
  View tgn;
  int tgo;
  boolean tgp;
  boolean tgq;
  private boolean tgr;
  private boolean tgs;
  private boolean tgt;
  protected com.tencent.mm.sdk.b.c<tq> tgu;
  protected e.a tgv;
  
  public b(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(1601);
    this.tgg = new ArrayList();
    this.tgi = 0;
    this.tgj = 0L;
    this.tgk = false;
    this.cvo = false;
    this.rQS = new ArrayList();
    this.stw = -1;
    this.tgo = 0;
    this.tgp = false;
    this.tgq = true;
    this.tgu = new b.5(this);
    this.tgv = new b.6(this);
    this.fyJ = new b.7(this);
    this.tfZ = paramMMActivity;
    this.tga = paramBoolean;
    AppMethodBeat.o(1601);
  }
  
  static Bitmap a(TopStoryWebView paramTopStoryWebView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(1622);
    try
    {
      long l = System.currentTimeMillis();
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
      paramTopStoryWebView.drawCanvas(new Canvas(localBitmap));
      ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "captureWebView success, cost:" + (System.currentTimeMillis() - l));
      com.tencent.mm.plugin.topstory.a.a.b.cIB();
      paramTopStoryWebView = localBitmap;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        paramTopStoryWebView = null;
        ab.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localThrowable, "captureWebView error", new Object[0]);
        com.tencent.mm.plugin.topstory.a.a.b.cIB();
      }
    }
    AppMethodBeat.o(1622);
    return paramTopStoryWebView;
  }
  
  public final boolean Gx(int paramInt)
  {
    AppMethodBeat.i(1605);
    if (paramInt == 4)
    {
      onBackBtnClick();
      AppMethodBeat.o(1605);
      return true;
    }
    AppMethodBeat.o(1605);
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.topstory.ui.webview.c paramc, TopStoryWebView paramTopStoryWebView, com.tencent.mm.plugin.topstory.ui.webview.e parame, cko paramcko)
  {
    AppMethodBeat.i(1619);
    this.tgb = paramc;
    this.tgc = paramTopStoryWebView;
    this.tgd = parame;
    this.tgd.tlT = this;
    this.cKi = paramcko;
    paramc = this.tgb;
    paramc.tlT = this;
    com.tencent.mm.kernel.g.Rc().a(2582, paramc.tma);
    com.tencent.mm.kernel.g.Rc().a(2802, paramc.tiS);
    com.tencent.mm.kernel.g.Rc().a(2906, paramc.tlZ);
    paramc = new FrameLayout.LayoutParams(-1, -1);
    this.rwD.addView(this.tgc, paramc);
    AppMethodBeat.o(1619);
  }
  
  final void aL(String paramString, long paramLong)
  {
    AppMethodBeat.i(1620);
    this.tgh.setVisibility(0);
    cku localcku = new cku();
    localcku.cDC = paramString;
    localcku.xUH = paramLong;
    an.a(localcku, 107, 5, 0, 0L, "");
    AppMethodBeat.o(1620);
  }
  
  public final void aej(String paramString)
  {
    AppMethodBeat.i(1613);
    Iterator localIterator = this.rQS.iterator();
    while (localIterator.hasNext())
    {
      b.a locala = (b.a)localIterator.next();
      if (locala.tgP != null)
      {
        locala.tgQ = 0;
        ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "invalid cache when onSearchDataReady");
      }
    }
    this.tgt = true;
    this.tgd.aej(paramString);
    AppMethodBeat.o(1613);
  }
  
  public final void aek(String paramString)
  {
    AppMethodBeat.i(1614);
    al.d(new e.7(this.tgd, paramString));
    AppMethodBeat.o(1614);
  }
  
  public final void ael(String paramString)
  {
    AppMethodBeat.i(1615);
    al.d(new e.10(this.tgd, paramString));
    AppMethodBeat.o(1615);
  }
  
  public final void aem(String paramString)
  {
    AppMethodBeat.i(1616);
    al.d(new e.9(this.tgd, paramString));
    AppMethodBeat.o(1616);
  }
  
  public final void an(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    for (;;)
    {
      Object localObject2;
      final b.a locala;
      label136:
      label142:
      final d.b localb;
      try
      {
        AppMethodBeat.i(1623);
        localObject2 = new StringBuilder("changeView, from ");
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = "viewpager";
          ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", (String)localObject1);
          if (paramInt == this.stw)
          {
            ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "changeView return");
            AppMethodBeat.o(1623);
          }
        }
        else
        {
          localObject1 = "tab";
          continue;
          this.stw = paramInt;
          locala = (b.a)this.rQS.get(i);
          if (this.tgn.getParent() == ((b.a)this.rQS.get(i)).tgO) {
            if (locala.tgQ <= 0)
            {
              paramInt = 1;
              locala.tgQ = 2;
              localb = (d.b)this.tgg.get(this.stw);
              this.tgq = false;
              localObject2 = "";
              localObject1 = localObject2;
              if (localb.category == 100)
              {
                localObject1 = localObject2;
                if (localb.tfM > 0) {
                  localObject1 = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cIm();
                }
              }
              if (paramInt == 0) {
                break label345;
              }
              com.tencent.mm.sdk.g.d.ysm.b(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(1586);
                  Bitmap localBitmap = b.a(b.this.tgc, locala.tgO.getWidth(), locala.tgO.getHeight());
                  b.this.tfZ.runOnUiThread(new b.8.1(this, localBitmap));
                  AppMethodBeat.o(1586);
                }
              }, "CaptureWebViewTask");
              label247:
              if (!bo.isNullOrNil(localb.tfP)) {
                break label478;
              }
              localObject1 = localb.tfO;
              label265:
              an.b(localb.category, this.tgi, (String)localObject1, this.cKi.hng, paramBoolean);
              AppMethodBeat.o(1623);
              continue;
              i = 0;
            }
          }
        }
      }
      finally {}
      label345:
      label478:
      do
      {
        break;
        locala.tgP.setVisibility(0);
        ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "changeView cacheworked");
        paramInt = 0;
        break label136;
        locala.tgP.setVisibility(0);
        paramInt = j;
        break label142;
        if (this.tgn.getParent() != null)
        {
          ((ViewGroup)this.tgn.getParent()).removeView(this.tgn);
          ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "remove view from:".concat(String.valueOf(i)));
        }
        localObject2 = new FrameLayout.LayoutParams(-1, -1);
        ((b.a)this.rQS.get(this.stw)).tgO.addView(this.tgn, (ViewGroup.LayoutParams)localObject2);
        ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "add view to:" + this.stw);
        this.tgd.k(localb.tfL, localb.tfM, localb.tfN, str1);
        break label247;
        String str2 = localb.tfP;
        break label265;
      } while (paramInt != 0);
      final int i = 1;
    }
  }
  
  public final MMActivity bMN()
  {
    return this.tfZ;
  }
  
  public final void cIJ()
  {
    this.tgr = true;
  }
  
  public final void cIK()
  {
    AppMethodBeat.i(1612);
    this.tgs = true;
    al.d(new b.2(this));
    AppMethodBeat.o(1612);
  }
  
  public final void cIL()
  {
    AppMethodBeat.i(1618);
    this.tfZ.runOnUiThread(new b.4(this));
    AppMethodBeat.o(1618);
  }
  
  public final void cIM()
  {
    AppMethodBeat.i(1604);
    if ((this.tgq) && (this.rQS.size() > 0))
    {
      int i = this.stw;
      this.tgm.postDelayed(new b.16(this, i), 100L);
      AppMethodBeat.o(1604);
      return;
    }
    this.tgq = true;
    AppMethodBeat.o(1604);
  }
  
  public final int cIN()
  {
    return this.tgo;
  }
  
  public final void cIO()
  {
    AppMethodBeat.i(141933);
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("path", "good-look-history");
      ((JSONObject)localObject2).put("subscene", 6);
      ((JSONObject)localObject2).put("tagId", 10802);
      ((JSONObject)localObject2).put("nickname", URLEncoder.encode((String)com.tencent.mm.kernel.g.RL().Ru().get(4, null), "UTF-8"));
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("scene", "21");
      ((HashMap)localObject1).put("sessionId", this.cKi.cpW);
      ((HashMap)localObject1).put("extParams", ((JSONObject)localObject2).toString());
      ((HashMap)localObject1).put("extInfo", ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cIq());
      ((HashMap)localObject1).put("profile", "1");
    }
    catch (Exception localException)
    {
      try
      {
        ((HashMap)localObject1).put("deviceName", URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf8"));
        ((HashMap)localObject1).put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
        ((HashMap)localObject1).put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
        ((HashMap)localObject1).put("ostype", com.tencent.mm.protocal.d.whD);
        localObject2 = new cko();
        ((cko)localObject2).xUt = com.tencent.mm.plugin.topstory.ui.d.cII();
        ((cko)localObject2).scene = 21;
        ((cko)localObject2).hng = "";
        ((cko)localObject2).cnv = "";
        ((cko)localObject2).cpW = this.cKi.cpW;
        ((cko)localObject2).cCW = this.cKi.cCW;
        ((cko)localObject2).xUv = 2;
        ((cko)localObject2).url = com.tencent.mm.plugin.topstory.a.g.o((HashMap)localObject1);
        ((cko)localObject2).xUw = "";
        ((cko)localObject2).bWu = 10802;
        ((cko)localObject2).xUx = com.tencent.mm.plugin.websearch.api.aa.bXn();
        ((cko)localObject2).nHx = ah.getContext().getResources().getColor(2131690709);
        Object localObject1 = new up();
        ((up)localObject1).key = "rec_category";
        ((up)localObject1).wMM = this.cKi.bWu;
        ((up)localObject1).wMN = String.valueOf(this.cKi.bWu);
        ((cko)localObject2).uIO.add(localObject1);
        com.tencent.mm.plugin.topstory.ui.d.a(ah.getContext(), (cko)localObject2, "", false);
        AppMethodBeat.o(141933);
        return;
        localException = localException;
        ab.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "goUserProfiler", new Object[0]);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localUnsupportedEncodingException, "", new Object[0]);
        }
      }
    }
  }
  
  final void cIP()
  {
    AppMethodBeat.i(1607);
    if (this.tgd != null)
    {
      this.tgd.cKz();
      cIL();
    }
    AppMethodBeat.o(1607);
  }
  
  protected boolean cIQ()
  {
    return true;
  }
  
  public final void gf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(1617);
    this.tfZ.runOnUiThread(new b.3(this, paramInt1, paramInt2));
    AppMethodBeat.o(1617);
  }
  
  public final void gg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(1603);
    an.m("", 0, 0, paramInt1);
    String str = com.tencent.mm.plugin.websearch.api.aa.IZ(paramInt1);
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("topStoryScene", String.valueOf(this.cKi.scene));
      localHashMap.put("deviceName", URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf8"));
      localHashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
      localHashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
      localHashMap.put("from", URLEncoder.encode(this.tfZ.getString(2131304321), "utf8"));
      com.tencent.mm.kernel.g.RJ();
      localHashMap.put("uin", com.tencent.mm.kernel.a.QC());
      localHashMap.put("timeZone", URLEncoder.encode(bo.dtS(), "utf8"));
      localHashMap.put("ostype", com.tencent.mm.protocal.d.whD);
      localHashMap.put("subScene", String.valueOf(paramInt2));
      localHashMap.put("extInfo", ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cIq());
      label227:
      ((j)com.tencent.mm.kernel.g.E(j.class)).a(this.tfZ, paramInt1, "", str, localHashMap, this.tfZ.getResources().getString(2131304337), this.tfZ.getResources().getColor(2131689496));
      AppMethodBeat.o(1603);
      return;
    }
    catch (Exception localException)
    {
      break label227;
    }
  }
  
  protected final void onBackBtnClick()
  {
    AppMethodBeat.i(1606);
    if (this.tgk)
    {
      cIP();
      AppMethodBeat.o(1606);
      return;
    }
    if (this.tgs) {
      com.tencent.mm.plugin.topstory.a.h.a(this.cKi, "uiBackBtnClick", System.currentTimeMillis());
    }
    for (;;)
    {
      an.Jw(19);
      if (!this.tga) {
        break;
      }
      this.tfZ.finish();
      AppMethodBeat.o(1606);
      return;
      if (this.tgr)
      {
        if (this.tgt) {
          com.tencent.mm.plugin.topstory.a.h.a(this.cKi, "uiBackBtnClickWithoutH5Ready", System.currentTimeMillis());
        } else {
          com.tencent.mm.plugin.topstory.a.h.a(this.cKi, "uiBackBtnClickWithoutDataReady", System.currentTimeMillis());
        }
      }
      else {
        com.tencent.mm.plugin.topstory.a.h.a(this.cKi, "uiBackBtnClickWithoutGetSearchData", System.currentTimeMillis());
      }
    }
    this.tfZ.moveTaskToBack(true);
    AppMethodBeat.o(1606);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(1602);
    ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onCreate");
    this.tfZ.getSupportActionBar().hide();
    this.cKi = new cko();
    TextView localTextView;
    View localView3;
    View localView2;
    try
    {
      this.cKi.parseFrom(this.tfZ.getIntent().getByteArrayExtra("key_context"));
      if (!bo.isNullOrNil(this.cKi.xUt))
      {
        ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "Create HomeContext Success %s", new Object[] { this.cKi.xUt });
        this.tgg = com.tencent.mm.plugin.topstory.ui.d.aeh(this.tfZ.getIntent().getStringExtra("key_tabconfig"));
        if (!this.tgg.isEmpty()) {
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().a(this.tgv);
        }
        this.tgu.alive();
        com.tencent.mm.kernel.g.RK().a(this.fyJ);
        ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.ui.b.class)).setHaokanEventListener(new b.1(this));
        an.Jw(17);
        this.tgn = LayoutInflater.from(this.tfZ).inflate(2130971025, null);
        this.rwD = ((FrameLayout)this.tgn.findViewById(2131828588));
        if (((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr() == null) {
          break label835;
        }
        if (!((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().thD) {
          ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().a(this.cKi, true);
        }
        ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().b(this);
        this.tge = this.tgn.findViewById(2131828589);
        this.iTR = ((ThreeDotsLoadingView)this.tgn.findViewById(2131821346));
        if ((Build.VERSION.SDK_INT >= 21) && (!com.tencent.mm.sdk.h.b.Mo()))
        {
          this.tfZ.getWindow().setStatusBarColor(this.tfZ.getResources().getColor(2131689496));
          this.tfZ.supportLightStatusBar();
        }
        localTextView = (TextView)this.tfZ.findViewById(2131828578);
        localView3 = this.tfZ.findViewById(2131820988);
        View localView1 = this.tfZ.findViewById(2131828581);
        localView2 = this.tfZ.findViewById(2131828582);
        this.tgh = this.tfZ.findViewById(2131828583);
        paramBundle = this.tfZ.findViewById(2131828575);
        this.tgf = this.tfZ.findViewById(2131828576);
        this.tgm = ((TopStoryViewPager)this.tfZ.findViewById(2131828577));
        this.tgl = ((LinearLayout)this.tfZ.findViewById(2131828574));
        if (this.tgg.isEmpty()) {
          break label1408;
        }
        localTabLayout = (TabLayout)this.tfZ.findViewById(2131828580);
        localObject = this.tgg.iterator();
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label900;
          }
          localb = (d.b)((Iterator)localObject).next();
          localb.tfQ = localTabLayout.bE();
          localb.tfQ.P(2130971024);
          localb.titleTv = ((TextView)localb.tfQ.lX.findViewById(2131828584));
          localb.tfR = localb.tfQ.lX.findViewById(2131828587);
          localb.tfS = ((TextView)localb.tfQ.lX.findViewById(2131828585));
          localb.tfT = localb.tfQ.lX.findViewById(2131828586);
          localb.titleTv.setText(localb.cyA);
          if (localb.tfN <= 0) {
            break;
          }
          paramBundle = localb.tfN;
          if (localb.tfN > 99) {
            paramBundle = "99+";
          }
          localb.tfS.setText(paramBundle);
          localb.tfS.setVisibility(0);
          localb.tfT.setVisibility(8);
          localTabLayout.a(localb.tfQ, false);
        }
      }
    }
    catch (Exception localException)
    {
      TabLayout localTabLayout;
      Object localObject;
      for (;;)
      {
        d.b localb;
        ab.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "initData use intent", new Object[0]);
        if (paramBundle != null)
        {
          try
          {
            this.cKi.parseFrom(paramBundle.getByteArray("key_context"));
          }
          catch (IOException paramBundle)
          {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", paramBundle, "initData use savedInstanceState", new Object[0]);
          }
          continue;
          ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "Create HomeContext Fail");
          this.tfZ.finish();
          continue;
          label835:
          paramBundle = new d();
          paramBundle.a(this.cKi, true);
          paramBundle.b(this);
          continue;
          if (localb.tfM > 0)
          {
            localb.tfS.setText("");
            localb.tfS.setVisibility(4);
            localb.tfT.setVisibility(0);
          }
        }
      }
      label900:
      localTabLayout.a(new b.12(this));
      this.tgm.setVisibility(0);
      int i = 0;
      while (i < this.tgg.size())
      {
        paramBundle = new b.a();
        paramBundle.tgN = LayoutInflater.from(this.tfZ).inflate(2130971021, null);
        paramBundle.tgP = ((ImageView)paramBundle.tgN.findViewById(2131828573));
        paramBundle.tgO = ((FrameLayout)paramBundle.tgN.findViewById(2131828572));
        this.rQS.add(paramBundle);
        i += 1;
      }
      this.tgm.setAdapter(new b.13(this));
      this.tgm.addOnPageChangeListener(new b.14(this, localTabLayout));
      this.tgc.AEe = new MMWebView.d()
      {
        public final void onWebViewScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(1599);
          ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onWebViewScrollChanged %s,   %s", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt4) });
          b.a locala = (b.a)b.this.rQS.get(b.this.stw);
          locala.tgQ -= 1;
          AppMethodBeat.o(1599);
        }
      };
      i = this.tfZ.getIntent().getIntExtra("key_chosetab", 0);
      paramBundle = this.tgg.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (d.b)paramBundle.next();
        if (((d.b)localObject).category == i) {
          ((d.b)localObject).tfQ.select();
        }
      }
      if (localTabLayout.getSelectedTabPosition() < 0) {
        localTabLayout.K(0).select();
      }
      localTextView.setText("");
      paramBundle = com.tencent.mm.sdk.platformtools.aa.dsG();
      if ((!paramBundle.equals("zh_TW")) && (!paramBundle.equals("zh_HK")) && (!paramBundle.equals("zh_CN"))) {
        this.tfZ.findViewById(2131828579).setVisibility(8);
      }
    }
    localView3.setOnClickListener(new b.10(this));
    ((ImageView)this.tfZ.findViewById(2131820989)).getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    this.iTR.dOV();
    label1288:
    boolean bool;
    if (cIQ())
    {
      paramBundle = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cIo();
      if (bo.isNullOrNil(paramBundle))
      {
        this.tgh.setVisibility(8);
        if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lSx, 0) != 1) {
          break label1492;
        }
        bool = true;
        label1312:
        if (!bool) {
          break label1497;
        }
        localException.setVisibility(8);
        paramBundle = localView2;
        label1326:
        paramBundle.setVisibility(0);
        paramBundle.setOnClickListener(new b.11(this, bool));
      }
    }
    for (;;)
    {
      if (this.cKi.nHx != 0)
      {
        this.tfZ.findViewById(2131820952).setBackgroundColor(this.cKi.nHx);
        this.tfZ.setActionbarColor(this.cKi.nHx);
      }
      com.tencent.mm.plugin.topstory.ui.d.c(this.cKi, "uiOnCreate", System.currentTimeMillis());
      AppMethodBeat.o(1602);
      return;
      label1408:
      this.tgm.setVisibility(8);
      this.tgl.addView(this.tgn, -1, -1);
      localTextView.setText(this.cKi.xUw);
      localTextView.setTextColor(-16777216);
      paramBundle.setOnClickListener(new b.9(this));
      break;
      aL(paramBundle, ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cIp());
      break label1288;
      label1492:
      bool = false;
      break label1312;
      label1497:
      localView2.setVisibility(8);
      paramBundle = localException;
      break label1326;
      localView2.setVisibility(8);
    }
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(1610);
    try
    {
      if ((this.cKi.bWu == 100) && (this.tgd != null)) {
        com.tencent.mm.plugin.topstory.ui.webview.a.a(this.tgd, "onWebCommendLeaveFromFindPage", "");
      }
      if ((this.tgc.getParent() != null) && (this.tgc.getParent().equals(this.rwD)))
      {
        ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "webViewContainer remove topstoryWebview");
        this.rwD.removeView(this.tgc);
      }
    }
    catch (Exception localException)
    {
      label84:
      Object localObject;
      long l;
      break label84;
    }
    if (this.tgc != null) {
      this.tgc.onDestroy();
    }
    localObject = this.cKi;
    l = this.tfZ.getActivityBrowseTimeMs();
    if (l > 0L)
    {
      localObject = String.format("%s,%s,%s,%s", new Object[] { Integer.valueOf(((cko)localObject).scene), Long.valueOf(l), Integer.valueOf(((cko)localObject).bWu), Integer.valueOf(((cko)localObject).xUv) });
      ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomePageBrowseTime 15018 %s", new Object[] { localObject });
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(15018, (String)localObject);
    }
    com.tencent.mm.plugin.topstory.a.h.a(this.cKi, "uiOnDestroy", System.currentTimeMillis());
    an.Jw(18);
    localObject = this.tgb;
    ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).tlT = null;
    ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).tlV = null;
    com.tencent.mm.kernel.g.Rc().b(1943, (f)localObject);
    com.tencent.mm.kernel.g.Rc().b(2582, ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).tma);
    com.tencent.mm.kernel.g.Rc().b(2802, ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).tiS);
    com.tencent.mm.kernel.g.Rc().b(2906, ((com.tencent.mm.plugin.topstory.ui.webview.c)localObject).tlZ);
    this.tgu.dead();
    com.tencent.mm.kernel.g.RK().b(this.fyJ);
    ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.ui.b.class)).setHaokanEventListener(null);
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().b(this.tgv);
    AppMethodBeat.o(1610);
  }
  
  protected final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(1611);
    cko localcko = new cko();
    try
    {
      localcko.parseFrom(paramIntent.getByteArrayExtra("key_context"));
      this.cKi.cpW = localcko.cpW;
      this.cKi.cCW = localcko.cCW;
      this.cKi.scene = localcko.scene;
      this.cKi.ohe = localcko.ohe;
      this.cKi.xUx = com.tencent.mm.plugin.websearch.api.aa.bXn();
      com.tencent.mm.plugin.topstory.a.h.a(this.cKi, "uiOnNewIntent", System.currentTimeMillis());
      an.Jw(20);
      this.tgd.aet("onNewIntent");
      AppMethodBeat.o(1611);
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        this.tfZ.finish();
      }
    }
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(1609);
    com.tencent.mm.plugin.topstory.a.h.a(this.cKi, "uiOnPause", System.currentTimeMillis());
    this.tgd.aet("onPause");
    if (this.tgc != null) {
      this.tgc.onPause();
    }
    this.cvo = true;
    AppMethodBeat.o(1609);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(1608);
    com.tencent.mm.plugin.topstory.a.h.a(this.cKi, "uiOnResume", System.currentTimeMillis());
    this.tgd.aet("onResume");
    if (this.tgc != null) {
      this.tgc.onResume();
    }
    com.tencent.mm.cn.d.awo("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    Iterator localIterator = this.tgg.iterator();
    while (localIterator.hasNext())
    {
      d.b localb = (d.b)localIterator.next();
      if (localb.tfN > 0)
      {
        if (localb.category == 110) {
          an.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cIg(), 107, 2, localb.tfN, 0L, "");
        }
      }
      else if (localb.tfM > 0) {
        if (localb.category == 110)
        {
          an.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cHZ(), 107, 1, 0, 0L, "");
        }
        else if (localb.category == 100)
        {
          cku localcku = new cku();
          localcku.cDC = localb.tfO;
          an.a(localcku, 107, 3, 0, 0L, "");
        }
      }
    }
    this.cvo = false;
    this.tgp = false;
    AppMethodBeat.o(1608);
  }
  
  protected final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(1621);
    try
    {
      paramBundle.putByteArray("key_context", this.cKi.toByteArray());
      ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onSaveInstanceState %s", new Object[] { this.cKi.xUt });
      AppMethodBeat.o(1621);
      return;
    }
    catch (Exception paramBundle)
    {
      ab.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", paramBundle, "onSaveInstanceState", new Object[0]);
      AppMethodBeat.o(1621);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b
 * JD-Core Version:    0.7.0.1
 */