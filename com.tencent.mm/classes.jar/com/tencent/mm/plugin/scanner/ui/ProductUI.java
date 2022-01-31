package com.tencent.mm.plugin.scanner.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.scanner.a.j;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.util.o.a;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.iy;
import com.tencent.mm.protocal.c.ja;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductUI
  extends MMPreference
  implements com.tencent.mm.ah.f, x.a
{
  private long bIt;
  private com.tencent.mm.modelgeo.c dhZ;
  private com.tencent.mm.modelgeo.a.a dig = new ProductUI.1(this);
  protected ProgressDialog dnm = null;
  protected com.tencent.mm.ui.base.preference.f dnn;
  private TextView eXr;
  private boolean egv = false;
  private TextView fdk;
  private int fzn;
  private com.tencent.mm.sdk.b.c giK = new ProductUI.5(this);
  private String iZD;
  private long mStartTime;
  private List<MusicPreference> mzc;
  private boolean nKA = false;
  private com.tencent.mm.plugin.scanner.history.a.a nKB;
  private bx.a nKC = new bx.a()
  {
    public final void a(com.tencent.mm.ah.e.a paramAnonymousa)
    {
      Object localObject1 = aa.a(paramAnonymousa.dBs.svH);
      y.i("MicroMsg.scanner.ProductUI", "lo-scanner-onRecieveMsg");
      paramAnonymousa = ProductUI.a(ProductUI.this);
      Object localObject2;
      if ((paramAnonymousa != null) && (!bk.bl((String)localObject1)))
      {
        localObject1 = bn.s((String)localObject1, "sysmsg");
        localObject2 = (String)((Map)localObject1).get(".sysmsg.scanproductinfo.product.id");
        if ((!bk.bl(paramAnonymousa.field_productid)) && (paramAnonymousa.field_productid.equals(localObject2))) {
          break label133;
        }
        y.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: product id not match, productId=" + bk.pm((String)localObject2) + ", target=" + paramAnonymousa.field_productid);
      }
      for (;;)
      {
        ai.d(new ProductUI.9.1(this));
        return;
        label133:
        localObject1 = com.tencent.mm.plugin.scanner.a.a.l((Map)localObject1, ".sysmsg.scanproductinfo.product");
        localObject2 = new HashMap();
        int i = 0;
        while (i < ((List)localObject1).size())
        {
          LinkedList localLinkedList = ((com.tencent.mm.plugin.scanner.a.a)((List)localObject1).get(i)).eAm;
          if (localLinkedList != null)
          {
            int j = 0;
            while (j < localLinkedList.size())
            {
              com.tencent.mm.plugin.scanner.a.a.a locala = (com.tencent.mm.plugin.scanner.a.a.a)localLinkedList.get(j);
              if (locala != null) {
                ((Map)localObject2).put(locala.key, locala);
              }
              j += 1;
            }
          }
          i += 1;
        }
        y.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: toUpdateSize=" + ((Map)localObject2).size());
        l.b(paramAnonymousa.nPR, (Map)localObject2);
      }
    }
  };
  private MusicPreference.a nKD = new ProductUI.4(this);
  private boolean nKE = true;
  private ImageView nKf;
  private ImageView nKg;
  private View nKh;
  private TextView nKi;
  private ImageView nKj;
  private View nKk;
  private LinearLayout nKl;
  private ImageView nKm;
  private o.a nKn;
  private View nKo;
  private int nKp = 0;
  private int nKq;
  private ProductUI.a nKr;
  private boolean nKs = false;
  private HashMap<String, Boolean> nKt;
  private e.a nKu;
  private String nKv;
  private boolean nKw = false;
  private String nKx;
  private boolean nKy = false;
  private boolean nKz = false;
  
  private static boolean Ma(String paramString)
  {
    com.tencent.mm.av.e locale = com.tencent.mm.av.a.Pw();
    return (locale != null) && (locale.euv == 5) && (paramString.equals(locale.eux)) && (com.tencent.mm.av.a.Pu());
  }
  
  private static String Mb(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    try
    {
      String str = Uri.parse(paramString).getQueryParameter("p");
      return str;
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.scanner.ProductUI", paramString + ";" + localException.getLocalizedMessage());
    }
    return null;
  }
  
  private static boolean Mc(String paramString)
  {
    au.Hx();
    paramString = com.tencent.mm.model.c.Fw().abl(paramString);
    return (paramString != null) && ((int)paramString.dBe > 0) && (com.tencent.mm.n.a.gR(paramString.field_type));
  }
  
  private void Md(String paramString)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("jsapi_args_appid", j.wN(this.nKp));
    localIntent.putExtra("jsapiargs", localBundle);
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("pay_channel", 3);
    localIntent.putExtra("geta8key_scene", alm());
    com.tencent.mm.br.d.b(this.mController.uMN, "webview", ".ui.tools.WebViewUI", localIntent);
  }
  
  private void a(final o.a parama)
  {
    if (parama == null)
    {
      y.e("MicroMsg.scanner.ProductUI", "refreshViewByProduct(), pd == null");
      finish();
      return;
    }
    if (!bk.bl(parama.field_thumburl)) {
      this.nKr = new ProductUI.a(parama);
    }
    this.nKq = this.mController.uMN.getResources().getDimensionPixelSize(R.f.product_ui_header_height);
    Object localObject;
    if ((this.nKn != null) && ((this.nKn.field_type == 1) || (this.nKn.field_type == 2)))
    {
      this.nKq = this.mController.uMN.getResources().getDimensionPixelSize(R.f.product_ui_header_movie_height);
      localObject = this.nKg.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.nKq;
      this.nKg.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.nKh.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.nKq;
      this.nKl.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout)findViewById(R.h.product_header_bg_mask);
      ViewGroup.LayoutParams localLayoutParams = ((RelativeLayout)localObject).getLayoutParams();
      localLayoutParams.height = this.nKq;
      ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
      localObject = this.nKl.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.nKq;
      this.nKl.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((!bk.bl(parama.field_introtitle)) && (!bk.bl(parama.field_introlink)))
    {
      this.fdk.setText(parama.field_introtitle);
      this.fdk.setOnClickListener(new ProductUI.15(this, parama));
      this.fdk.setVisibility(0);
      this.nKp = this.nKn.field_functionType;
      if (parama.field_xmlType != 3) {
        break label551;
      }
      this.eXr.setText(parama.field_title);
      if (bk.bl(parama.field_certification)) {
        break label464;
      }
      this.nKi.setText(parama.field_certification);
      this.nKj.setVisibility(0);
      label323:
      if ((parama.field_type != 1) && (parama.field_type != 2)) {
        break label511;
      }
      this.nKf = ((ImageView)findViewById(R.h.product_header_book_img));
      findViewById(R.h.product_header_book_img).setVisibility(0);
      findViewById(R.h.product_header_product_img).setVisibility(8);
      label376:
      if (!bk.bl(parama.field_playurl))
      {
        localObject = (ImageView)findViewById(R.h.product_detail_play_img);
        ((ImageView)localObject).setVisibility(0);
        ((ImageView)localObject).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            paramAnonymousView = new Intent("android.intent.action.VIEW");
            paramAnonymousView.setDataAndType(Uri.parse(parama.field_playurl), "video/*");
            ProductUI.this.startActivity(paramAnonymousView);
          }
        });
      }
      addIconOptionMenu(0, R.g.mm_title_btn_menu, new ProductUI.2(this));
    }
    for (;;)
    {
      y.v("MicroMsg.scanner.ProductUI", "start postToMainThread initBodyView");
      ai.d(new ProductUI.3(this, parama));
      return;
      this.fdk.setVisibility(8);
      break;
      label464:
      this.nKi.setText(parama.field_source);
      this.nKj.setVisibility(8);
      this.nKk.setOnClickListener(null);
      this.nKk.setBackgroundDrawable(null);
      this.nKk.setFocusable(false);
      break label323;
      label511:
      this.nKf = ((ImageView)findViewById(R.h.product_header_product_img));
      findViewById(R.h.product_header_product_img).setVisibility(0);
      findViewById(R.h.product_header_book_img).setVisibility(8);
      break label376;
      label551:
      if (parama.field_xmlType == 4)
      {
        this.nKf = ((ImageView)findViewById(R.h.product_header_product_img));
        findViewById(R.h.product_header_product_img).setVisibility(0);
        findViewById(R.h.product_header_book_img).setVisibility(8);
        this.nKf.setImageResource(R.k.scan_without_commodity_icon);
        this.nKf.setBackgroundResource(R.k.scan_without_commodity_icon);
        this.eXr.setText(R.l.scan_img_product_not_found);
        this.nKi.setText(null);
      }
    }
  }
  
  private void aE(int paramInt, String paramString)
  {
    if (this.nKn == null) {
      return;
    }
    paramString = new com.tencent.mm.plugin.scanner.a.i(this.nKn.field_productid, "", paramInt, paramString, 0, 0);
    au.Dk().a(paramString, 0);
  }
  
  private int alm()
  {
    if (this.nKp == 4) {
      return 11;
    }
    if (this.nKp == 3) {
      return 12;
    }
    return 0;
  }
  
  private void b(o.a parama)
  {
    if ((parama == null) || (parama.nPR == null) || (parama.nPR.size() == 0) || (this.dnn == null)) {}
    label341:
    label343:
    label497:
    do
    {
      return;
      this.dnn.removeAll();
      int i = 0;
      while (i < parama.nPR.size())
      {
        Object localObject2 = (com.tencent.mm.plugin.scanner.a.a)parama.nPR.get(i);
        Object localObject1;
        Object localObject3;
        if ((localObject2 != null) && (((com.tencent.mm.plugin.scanner.a.a)localObject2).eAm != null) && (((com.tencent.mm.plugin.scanner.a.a)localObject2).eAm.size() != 0) && (((com.tencent.mm.plugin.scanner.a.a)localObject2).nGz != 1) && (((com.tencent.mm.plugin.scanner.a.a)localObject2).nGB))
        {
          if (i != 0)
          {
            localObject1 = new Preference(this);
            ((Preference)localObject1).setLayoutResource(R.i.product_category_divider);
            this.dnn.a((Preference)localObject1);
          }
          if ((!bk.bl(((com.tencent.mm.plugin.scanner.a.a)localObject2).title)) && ((((com.tencent.mm.plugin.scanner.a.a)localObject2).type == 6) || (((com.tencent.mm.plugin.scanner.a.a)localObject2).type == 7)))
          {
            localObject1 = new CategoryWithTitlePreference(this);
            ((CategoryWithTitlePreference)localObject1).setTitle(((com.tencent.mm.plugin.scanner.a.a)localObject2).title);
            this.dnn.a((Preference)localObject1);
          }
          if (((com.tencent.mm.plugin.scanner.a.a)localObject2).type != 6) {
            break label341;
          }
          localObject1 = new ArrayList();
          j = 0;
          while (j < ((com.tencent.mm.plugin.scanner.a.a)localObject2).eAm.size())
          {
            localObject3 = (com.tencent.mm.plugin.scanner.a.a.a)((com.tencent.mm.plugin.scanner.a.a)localObject2).eAm.get(j);
            if (((com.tencent.mm.plugin.scanner.a.a.a)localObject3).type == 10) {
              ((List)localObject1).add(localObject3);
            }
            j += 1;
          }
          if (((List)localObject1).size() > 0)
          {
            localObject2 = new h(this);
            ((h)localObject2).setKey(i * 100);
            ((h)localObject2).mTm = ((List)localObject1);
            this.dnn.a((Preference)localObject2);
          }
        }
        i += 1;
        continue;
        int j = 0;
        com.tencent.mm.plugin.scanner.a.a.a locala;
        if (j < ((com.tencent.mm.plugin.scanner.a.a)localObject2).eAm.size())
        {
          localObject3 = i * 100 + j;
          locala = (com.tencent.mm.plugin.scanner.a.a.a)((com.tencent.mm.plugin.scanner.a.a)localObject2).eAm.get(j);
          if (locala.type == 11)
          {
            this.nKw = true;
            this.nKx = locala.name;
          }
          if (locala.showType != 2)
          {
            if (locala.showType != 1) {
              break label497;
            }
            if (!bk.bl(locala.image))
            {
              localObject1 = new b(this);
              ((b)localObject1).setKey((String)localObject3);
              ((b)localObject1).jaX = locala.image;
              ((b)localObject1).dnn = this.dnn;
              this.dnn.a((Preference)localObject1);
            }
          }
        }
        for (;;)
        {
          j += 1;
          break label343;
          break;
          if (locala.type == 5)
          {
            localObject1 = new MusicPreference(this);
            ((MusicPreference)localObject1).setKey((String)localObject3);
            ((MusicPreference)localObject1).setTitle(locala.name);
            ((MusicPreference)localObject1).nGD = locala.nGD;
            ((MusicPreference)localObject1).nGE = locala.nGE;
            ((MusicPreference)localObject1).nGF = locala.nGF;
            if (!Ma(String.format("%s_cd_%s", new Object[] { locala.nGD, localObject3 })))
            {
              ((MusicPreference)localObject1).iy(false);
              ((MusicPreference)localObject1).nJL = this.nKD;
              this.dnn.a((Preference)localObject1);
              com.tencent.mm.sdk.b.a.udP.c(this.giK);
              if (this.mzc == null) {
                this.mzc = new ArrayList();
              }
              if (this.nKE) {
                this.mzc.add(localObject1);
              }
            }
          }
          for (;;)
          {
            if ((j >= ((com.tencent.mm.plugin.scanner.a.a)localObject2).eAm.size() - 1) || (locala.type == 12) || (((com.tencent.mm.plugin.scanner.a.a.a)((com.tencent.mm.plugin.scanner.a.a)localObject2).eAm.get(j + 1)).type == 12) || (((com.tencent.mm.plugin.scanner.a.a.a)((com.tencent.mm.plugin.scanner.a.a)localObject2).eAm.get(j + 1)).showType == 1) || (!b(j, ((com.tencent.mm.plugin.scanner.a.a)localObject2).eAm))) {
              break label1173;
            }
            localObject1 = new g(this);
            this.dnn.a((Preference)localObject1);
            break;
            ((MusicPreference)localObject1).iy(true);
            break label598;
            if (locala.type == 6)
            {
              localObject1 = new e(this);
              ((e)localObject1).setKey((String)localObject3);
              ((e)localObject1).mTitle = locala.name;
              ((e)localObject1).setSummary(locala.desc);
              this.dnn.a((Preference)localObject1);
              ((e)localObject1).nJA = this.nKu;
            }
            else if (locala.type == 12)
            {
              localObject1 = new f(this);
              ((f)localObject1).setKey((String)localObject3);
              ((f)localObject1).jaX = locala.thumburl;
              ((f)localObject1).dnn = this.dnn;
              this.dnn.a((Preference)localObject1);
            }
            else
            {
              if (locala.type == 2)
              {
                if (Mc(locala.username)) {}
                for (localObject1 = locala.nGL;; localObject1 = locala.nGK)
                {
                  a locala1 = new a(this);
                  locala1.setKey((String)localObject3);
                  locala1.setTitle((CharSequence)localObject1);
                  locala1.setSummary(locala.desc);
                  locala1.nHW = locala.dTF;
                  this.dnn.a(locala1);
                  break;
                }
              }
              if (locala.type == 22)
              {
                localObject1 = new d(this);
                ((d)localObject1).setKey((String)localObject3);
                if (!bk.bl(locala.nickname)) {
                  ((d)localObject1).nzW = (locala.nickname + ":");
                }
                ((d)localObject1).kPW = locala.content;
                ((d)localObject1).nJo = locala.thumburl;
                this.dnn.a((Preference)localObject1);
              }
              else
              {
                localObject1 = new a(this);
                ((a)localObject1).setKey((String)localObject3);
                ((a)localObject1).setTitle(locala.name);
                ((a)localObject1).setSummary(locala.desc);
                ((a)localObject1).nHW = locala.dTF;
                ((a)localObject1).iZG = locala.iconUrl;
                this.dnn.a((Preference)localObject1);
              }
            }
          }
        }
      }
      this.dnn.notifyDataSetChanged();
      y.d("MicroMsg.scanner.ProductUI", "initBodyView finish");
    } while (this.mzc == null);
    label598:
    this.nKE = false;
    label1173:
  }
  
  private static boolean b(int paramInt, LinkedList<com.tencent.mm.plugin.scanner.a.a.a> paramLinkedList)
  {
    if (paramLinkedList != null)
    {
      paramInt += 1;
      while (paramInt < paramLinkedList.size())
      {
        if (((com.tencent.mm.plugin.scanner.a.a.a)paramLinkedList.get(paramInt)).showType != 2) {
          return true;
        }
        paramInt += 1;
      }
    }
    return false;
  }
  
  private void bxK()
  {
    this.bIt = getIntent().getLongExtra("key_ProductUI_chatting_msgId", 0L);
    if ((this.bIt > 0L) && (au.DK()))
    {
      au.Hx();
      bi localbi = com.tencent.mm.model.c.Fy().fd(this.bIt);
      if (localbi.field_msgId > 0L)
      {
        localbi.ed(this.nKr.UO());
        au.Hx();
        com.tencent.mm.model.c.Fy().a(this.bIt, localbi);
      }
    }
  }
  
  private void bxL()
  {
    if ((this.nKn == null) || (this.nKn.nPR == null) || (this.nKn.nPR.size() == 0) || (this.dnn == null)) {
      return;
    }
    int i = 0;
    while (i < this.nKn.nPR.size())
    {
      com.tencent.mm.plugin.scanner.a.a locala = (com.tencent.mm.plugin.scanner.a.a)this.nKn.nPR.get(i);
      if ((locala != null) && (locala.eAm != null) && (locala.eAm.size() != 0))
      {
        int j = 0;
        if (j < locala.eAm.size())
        {
          com.tencent.mm.plugin.scanner.a.a.a locala1 = (com.tencent.mm.plugin.scanner.a.a.a)locala.eAm.get(j);
          MusicPreference localMusicPreference;
          if (locala1.type == 5)
          {
            String str = i * 100 + j;
            localMusicPreference = (MusicPreference)this.dnn.add(str);
            if (localMusicPreference != null)
            {
              if (Ma(String.format("%s_cd_%s", new Object[] { locala1.nGD, str }))) {
                break label209;
              }
              localMusicPreference.iy(false);
            }
          }
          for (;;)
          {
            j += 1;
            break;
            label209:
            localMusicPreference.iy(true);
          }
        }
      }
      i += 1;
    }
    this.dnn.notifyDataSetChanged();
  }
  
  private int bxM()
  {
    if (this.nKp == 3) {
      return 47;
    }
    return 49;
  }
  
  private void bxN()
  {
    if (this.nKn != null)
    {
      y.i("MicroMsg.scanner.ProductUI", "doUpdateActionLogic, flag=:" + this.nKn.field_getaction);
      if ((this.nKn.field_getaction & 0x2) <= 0) {
        break label73;
      }
      this.dhZ = com.tencent.mm.modelgeo.c.Ob();
      if (this.dhZ != null) {
        this.dhZ.b(this.dig);
      }
    }
    label73:
    while ((this.nKn.field_getaction & 0x1) <= 0) {
      return;
    }
    com.tencent.mm.plugin.scanner.a.c localc = new com.tencent.mm.plugin.scanner.a.c(this.iZD, l.cn(this.nKn.nPR), this.fzn, this.nKv, 0.0D, 0.0D);
    au.Dk().a(localc, 0);
  }
  
  private void bxO()
  {
    if (!com.tencent.mm.plugin.scanner.util.i.byw())
    {
      y.e("MicroMsg.scanner.ProductUI", "mHistoryItem ScanHistoryUtil.shouldShowHistoryList() is false!");
      return;
    }
    com.tencent.mm.plugin.scanner.history.a.a locala = new com.tencent.mm.plugin.scanner.history.a.a();
    locala.field_productId = this.iZD;
    if (!com.tencent.mm.plugin.scanner.c.bxe().b(locala, new String[0])) {}
    for (boolean bool = com.tencent.mm.plugin.scanner.c.bxe().b(this.nKB); bool; bool = com.tencent.mm.plugin.scanner.c.bxe().c(this.nKB, new String[0]))
    {
      y.i("MicroMsg.scanner.ProductUI", "mHistoryItem insert success!");
      this.nKz = true;
      return;
    }
    y.e("MicroMsg.scanner.ProductUI", "mHistoryItem insert fail!");
  }
  
  private static void m(View paramView, float paramFloat)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    paramView.startAnimation(localAlphaAnimation);
  }
  
  private void q(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.iZD = paramString1;
    this.nKv = paramString2;
    paramString1 = new com.tencent.mm.plugin.scanner.a.d(paramString1, this.fzn, paramString2);
    au.Dk().a(paramString1, 0);
    if (!paramBoolean)
    {
      paramString2 = this.mController.uMN;
      getString(R.l.app_tip);
      this.dnm = com.tencent.mm.ui.base.h.b(paramString2, getString(R.l.scan_loading_tip), new ProductUI.8(this, paramString1));
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    y.i("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick item: [%s]", new Object[] { paramPreference.mKey });
    if ((this.nKn == null) || (this.nKn.nPR == null))
    {
      y.e("MicroMsg.scanner.ProductUI", "product == null || product.actionlist == null");
      return false;
    }
    for (;;)
    {
      com.tencent.mm.plugin.scanner.a.a.a locala1;
      Intent localIntent;
      try
      {
        int i = Integer.valueOf(paramPreference.mKey).intValue();
        int j = i / 100;
        int k = i % 100;
        y.v("MicroMsg.scanner.ProductUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        if ((j < 0) || (j >= this.nKn.nPR.size()))
        {
          y.w("MicroMsg.scanner.ProductUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(this.nKn.nPR.size()) });
          return false;
        }
        com.tencent.mm.plugin.scanner.a.a locala = (com.tencent.mm.plugin.scanner.a.a)this.nKn.nPR.get(j);
        if (locala == null)
        {
          y.w("MicroMsg.scanner.ProductUI", "actionList == null");
          return false;
        }
        if ((k < 0) || (k >= locala.eAm.size()))
        {
          y.w("MicroMsg.scanner.ProductUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(locala.eAm.size()) });
          return false;
        }
        locala1 = (com.tencent.mm.plugin.scanner.a.a.a)locala.eAm.get(k);
        if (locala1 == null)
        {
          y.w("MicroMsg.scanner.ProductUI", "action == null");
          return false;
        }
        y.i("MicroMsg.scanner.ProductUI", "action.type = [%s]", new Object[] { Integer.valueOf(locala1.type) });
        paramPreference = null;
        localIntent = new Intent();
        paramf = paramPreference;
        switch (locala1.type)
        {
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 20: 
          y.d("MicroMsg.scanner.ProductUI", "Default go url:" + locala1.eAl);
          paramf = paramPreference;
          if (!bk.bl(locala1.eAl))
          {
            Md(locala1.eAl);
            paramf = paramPreference;
          }
        case 6: 
        case 7: 
        case 10: 
          paramf = new com.tencent.mm.plugin.scanner.a.i(this.nKn.field_productid, locala1.nGG, locala1.type, paramf, locala.eAm.size(), locala1.showType);
          au.Dk().a(paramf, 0);
          return true;
        }
      }
      catch (Exception paramf)
      {
        y.e("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick, [%s]", new Object[] { paramf.getMessage() });
        y.printErrStackTrace("MicroMsg.scanner.ProductUI", paramf, "", new Object[0]);
        return false;
      }
      paramPreference = locala1.eAl;
      paramf = paramPreference;
      if (!bk.bl(locala1.eAl))
      {
        Md(locala1.eAl);
        paramf = paramPreference;
        continue;
        paramPreference = locala1.username;
        paramf = paramPreference;
        if (!bk.bl(locala1.username))
        {
          paramf = locala1.username;
          if (Mc(paramf))
          {
            localIntent = new Intent();
            localIntent.putExtra("Chat_User", paramf);
            localIntent.putExtra("finish_direct", true);
            localIntent.putExtra("add_scene", bxM());
            com.tencent.mm.plugin.scanner.b.eUR.e(localIntent, this.mController.uMN);
            paramf = paramPreference;
          }
          else if (TextUtils.isEmpty(paramf))
          {
            y.v("MicroMsg.scanner.ProductUI", "username is null");
            paramf = paramPreference;
          }
          else
          {
            localIntent = new Intent();
            localIntent.putExtra("Contact_User", paramf);
            localIntent.putExtra("force_get_contact", true);
            localIntent.putExtra("Contact_Scene", bxM());
            com.tencent.mm.plugin.scanner.b.eUR.d(localIntent, this);
            paramf = paramPreference;
            continue;
            paramf = locala1.nGF;
            localIntent.putExtra("rawUrl", locala1.nGF);
            localIntent.putExtra("geta8key_scene", alm());
            com.tencent.mm.plugin.scanner.b.eUR.j(localIntent, this);
            com.tencent.mm.av.a.Ps();
            bxL();
            continue;
            paramPreference = locala1.nGH;
            paramf = paramPreference;
            if (!bk.bl(locala1.nGH))
            {
              localIntent.putExtra("key_product_id", locala1.nGH);
              localIntent.putExtra("key_product_scene", 12);
              com.tencent.mm.br.d.b(this, "product", ".ui.MallProductUI", localIntent);
              paramf = paramPreference;
              continue;
              paramf = locala1.nGH;
              localIntent.putExtra("key_card_id", locala1.nGJ);
              localIntent.putExtra("key_card_ext", locala1.nGI);
              localIntent.putExtra("key_from_scene", 9);
              com.tencent.mm.br.d.b(this, "card", ".ui.CardDetailUI", localIntent);
              continue;
              localIntent.setClass(this, ProductFurtherInfoUI.class);
              localIntent.putExtra("key_Product_xml", this.nKn.field_xml);
              localIntent.putExtra("key_title", locala1.name);
              startActivity(localIntent);
              paramf = paramPreference;
              continue;
              paramf = locala1.nGA;
              localIntent.setClass(this, ProductPurchaseAreaUI.class);
              localIntent.putExtra("key_Product_xml", this.nKn.field_xml);
              localIntent.putExtra("referkey", locala1.nGA);
              localIntent.putExtra("key_Product_funcType", this.nKp);
              startActivity(localIntent);
              continue;
              paramPreference = locala1.eAl;
              paramf = paramPreference;
              if (!bk.bl(locala1.eAl))
              {
                Md(locala1.eAl);
                paramf = paramPreference;
              }
            }
          }
        }
      }
    }
  }
  
  public final int axE()
  {
    return R.i.product_header_view;
  }
  
  protected final int getLayoutId()
  {
    return R.i.product_detail;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.scan_product_detail_title);
    this.dnn = this.vdd;
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().setBackgroundDrawable(null);
      getSupportActionBar();
    }
    setBackBtn(new ProductUI.10(this));
    this.eXr = ((TextView)findViewById(R.h.product_title));
    this.nKg = ((ImageView)findViewById(R.h.product_header_bg));
    this.nKh = findViewById(R.h.product_header_mask);
    this.nKj = ((ImageView)findViewById(R.h.product_certification_icon));
    this.nKo = findViewById(R.h.product_actionbar_bg);
    this.nKl = ((LinearLayout)findViewById(R.h.product_header_ll));
    this.nKm = ((ImageView)findViewById(R.h.product_header_blur_area));
    this.nKk = findViewById(R.h.product_certification_area);
    m(this.nKo, 0.0F);
    Object localObject;
    String str;
    if (com.tencent.mm.cb.a.fh(this.mController.uMN))
    {
      this.eXr.setTextSize(0, this.mController.uMN.getResources().getDimensionPixelSize(R.f.DialogTitleTextSize) * 1.25F);
      this.nKi = ((TextView)findViewById(R.h.product_certification));
      this.fdk = ((TextView)findViewById(R.h.scan_product_intro));
      this.nKt = new HashMap();
      this.nKu = new ProductUI.11(this);
      this.nKB = new com.tencent.mm.plugin.scanner.history.a.a();
      this.nKB.field_ScanTime = System.currentTimeMillis();
      this.nKB.field_scene = this.fzn;
      if (this.fzn != 5) {
        break label421;
      }
      this.nKy = true;
      localObject = getIntent().getStringExtra("key_Qrcode_Url");
      str = Mb((String)localObject);
      this.nKB.field_qrcodeUrl = ((String)localObject);
      this.nKB.field_productId = str;
      q(str, (String)localObject, false);
    }
    for (;;)
    {
      findViewById(R.h.product_header_root).setOnClickListener(new ProductUI.12(this));
      findViewById(R.h.product_detail).setOnClickListener(new ProductUI.13(this));
      this.nKk.setOnClickListener(new ProductUI.14(this));
      new ProductUI.b(this);
      return;
      this.eXr.setTextSize(0, com.tencent.mm.cb.a.aa(this.mController.uMN, R.f.DialogTitleTextSize));
      break;
      label421:
      if (this.fzn == 4)
      {
        localObject = getIntent().getStringExtra("key_product_id");
        str = getIntent().getStringExtra("key_Qrcode_Url");
        if (!bk.bl((String)localObject))
        {
          q((String)localObject, str, false);
        }
        else
        {
          y.e("MicroMsg.scanner.ProductUI", "jsapi jump finish productId null");
          finish();
        }
      }
      else
      {
        this.nKA = getIntent().getBooleanExtra("key_is_from_barcode", false);
        this.nKy = getIntent().getBooleanExtra("key_need_add_to_history", false);
        localObject = getIntent().getStringExtra("key_Product_xml");
        if (!bk.bl((String)localObject))
        {
          int i = getIntent().getIntExtra("key_Product_funcType", 0);
          this.nKn = j.cm((String)localObject, i);
          if (this.nKn == null)
          {
            y.e("MicroMsg.scanner.ProductUI", "initView(), product == null");
            finish();
            return;
          }
          this.iZD = this.nKn.field_productid;
          this.nKv = this.nKn.field_extinfo;
          if ((this.nKy) && (!TextUtils.isEmpty(this.iZD)))
          {
            this.nKB.field_xmlContent = ((String)localObject);
            this.nKB.field_qrcodeUrl = this.nKv;
            this.nKB.field_productId = this.iZD;
            this.nKB.field_funcType = i;
            bxO();
          }
          for (;;)
          {
            localObject = this.nKn;
            getIntent().getBooleanExtra("key_ProductUI_addToDB", true);
            a((o.a)localObject);
            if ((i != 0) || (bk.bl(this.nKn.field_productid))) {
              break label753;
            }
            q(this.nKn.field_productid, this.nKn.field_extinfo, true);
            break;
            y.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.nKy + " mProductId:" + this.iZD);
          }
          label753:
          bxN();
        }
        else
        {
          localObject = getIntent().getStringExtra("key_Product_ID");
          if (bk.bl((String)localObject)) {
            break label788;
          }
          q((String)localObject, null, false);
        }
      }
    }
    label788:
    y.e("MicroMsg.scanner.ProductUI", "normal finish productId null");
    finish();
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    if ((!bk.bl(paramString)) && (this.nKn != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      y.d("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=" + paramString);
      ai.d(new ProductUI.7(this, paramString, paramBitmap));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mStartTime = bk.UX();
    this.fzn = getIntent().getIntExtra("key_ProductUI_getProductInfoScene", 0);
    x.b(this);
    au.getSysCmdMsgExtension().a("scanproductinfo", this.nKC, true);
    initView();
  }
  
  protected void onDestroy()
  {
    x.c(this);
    au.getSysCmdMsgExtension().b("scanproductinfo", this.nKC, true);
    com.tencent.mm.sdk.b.a.udP.d(this.giK);
    if (this.dhZ != null) {
      this.dhZ.c(this.dig);
    }
    aE(10100, bk.UX() - this.mStartTime);
    super.onDestroy();
  }
  
  protected void onPause()
  {
    au.Dk().b(1063, this);
    au.Dk().b(1068, this);
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    au.Dk().a(1063, this);
    au.Dk().a(1068, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if (paramm == null) {
      y.w("MicroMsg.scanner.ProductUI", "scene == null");
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramm.getType() != 1063) {
            break;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            y.e("MicroMsg.scanner.ProductUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
            return;
          }
          paramString = (com.tencent.mm.plugin.scanner.a.d)paramm;
          if ((paramString.dmK != null) && (paramString.dmK.ecF.ecN != null)) {}
          for (paramString = (ja)paramString.dmK.ecF.ecN; paramString == null; paramString = null)
          {
            y.w("MicroMsg.scanner.ProductUI", "onSceneEnd productInfo == null");
            return;
          }
        } while (paramString.sDp == null);
        y.d("MicroMsg.scanner.ProductUI", "onSceneEnd  productInfo.DescXML != null");
        paramm = j.cm(paramString.sDp, this.nKp);
        if ((this.nKn != null) && (this.nKn.field_xml != null) && (paramm != null) && (paramm.field_xml != null) && (!this.nKn.field_xml.equals(paramm.field_xml)))
        {
          this.nKn = paramm;
          a(this.nKn);
        }
        for (;;)
        {
          if ((this.dnm != null) && (this.dnm.isShowing())) {
            this.dnm.dismiss();
          }
          bxN();
          if ((!this.nKy) || (this.nKz) || (TextUtils.isEmpty(this.iZD))) {
            break;
          }
          this.nKB.field_xmlContent = paramString.sDp;
          this.nKB.field_funcType = this.nKp;
          bxO();
          return;
          if ((paramm != null) && (paramm.field_xml != null))
          {
            this.nKn = paramm;
            a(this.nKn);
          }
        }
        y.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.nKy + " mProductId:" + this.iZD + "  hasAddToHistory:" + this.nKz);
        return;
      } while ((paramm.getType() != 1068) || (paramInt1 != 0) || (paramInt2 != 0));
      paramString = ((iy)((com.tencent.mm.plugin.scanner.a.c)paramm).dmK.ecF.ecN).sDo;
    } while ((this.nKn == null) || (!l.b(this.nKn.nPR, l.co(paramString))));
    b(this.nKn);
  }
  
  public final int xj()
  {
    return R.o.prodect_detail_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI
 * JD-Core Version:    0.7.0.1
 */