package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
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
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.plugin.scanner.model.i;
import com.tencent.mm.plugin.scanner.util.q.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.la;
import com.tencent.mm.protocal.protobuf.lc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductUI
  extends MMPreference
  implements com.tencent.mm.ai.f, x.a
{
  private long cpO;
  private b.a dZA;
  private com.tencent.mm.modelgeo.d dZt;
  protected ProgressDialog eeN;
  private boolean fwx;
  private TextView guV;
  private com.tencent.mm.sdk.b.c hCe;
  private String liu;
  private int mScene;
  private long mStartTime;
  private List<MusicPreference> oZi;
  private boolean ogA;
  private ImageView qxH;
  private ImageView qxI;
  private View qxJ;
  private TextView qxK;
  private ImageView qxL;
  private View qxM;
  private LinearLayout qxN;
  private ImageView qxO;
  private q.a qxP;
  private View qxQ;
  private int qxR;
  private int qxS;
  private ProductUI.a qxT;
  private boolean qxU;
  private HashMap<String, Boolean> qxV;
  private e.a qxW;
  private String qxX;
  private boolean qxY;
  private String qxZ;
  private boolean qya;
  private boolean qyb;
  private boolean qyc;
  private com.tencent.mm.plugin.scanner.history.a.a qyd;
  private bz.a qye;
  private MusicPreference.a qyf;
  private boolean qyg;
  protected com.tencent.mm.ui.base.preference.f screen;
  private TextView titleTv;
  
  public ProductUI()
  {
    AppMethodBeat.i(81105);
    this.qxR = 0;
    this.eeN = null;
    this.qxU = false;
    this.qxY = false;
    this.qya = false;
    this.qyb = false;
    this.qyc = false;
    this.fwx = false;
    this.dZA = new ProductUI.1(this);
    this.qye = new bz.a()
    {
      public final void a(com.tencent.mm.ai.e.a paramAnonymousa)
      {
        AppMethodBeat.i(81090);
        Object localObject1 = aa.a(paramAnonymousa.eyJ.woR);
        ab.i("MicroMsg.scanner.ProductUI", "lo-scanner-onRecieveMsg");
        paramAnonymousa = ProductUI.a(ProductUI.this);
        Object localObject2;
        if ((paramAnonymousa != null) && (!bo.isNullOrNil((String)localObject1)))
        {
          localObject1 = br.F((String)localObject1, "sysmsg");
          localObject2 = (String)((Map)localObject1).get(".sysmsg.scanproductinfo.product.id");
          if ((!bo.isNullOrNil(paramAnonymousa.field_productid)) && (paramAnonymousa.field_productid.equals(localObject2))) {
            break label143;
          }
          ab.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: product id not match, productId=" + bo.nullAsNil((String)localObject2) + ", target=" + paramAnonymousa.field_productid);
        }
        for (;;)
        {
          al.d(new ProductUI.9.1(this));
          AppMethodBeat.o(81090);
          return;
          label143:
          localObject1 = com.tencent.mm.plugin.scanner.model.a.l((Map)localObject1, ".sysmsg.scanproductinfo.product");
          localObject2 = new HashMap();
          int i = 0;
          while (i < ((List)localObject1).size())
          {
            LinkedList localLinkedList = ((com.tencent.mm.plugin.scanner.model.a)((List)localObject1).get(i)).fQb;
            if (localLinkedList != null)
            {
              int j = 0;
              while (j < localLinkedList.size())
              {
                a.a locala = (a.a)localLinkedList.get(j);
                if (locala != null) {
                  ((Map)localObject2).put(locala.key, locala);
                }
                j += 1;
              }
            }
            i += 1;
          }
          ab.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: toUpdateSize=" + ((Map)localObject2).size());
          com.tencent.mm.plugin.scanner.model.m.b(paramAnonymousa.qDK, (Map)localObject2);
        }
      }
    };
    this.qyf = new ProductUI.4(this);
    this.qyg = true;
    this.hCe = new ProductUI.5(this);
    AppMethodBeat.o(81105);
  }
  
  private static boolean YC(String paramString)
  {
    AppMethodBeat.i(81118);
    com.tencent.mm.aw.e locale = com.tencent.mm.aw.a.aiz();
    if ((locale != null) && (locale.fKh == 5) && (paramString.equals(locale.fKj)) && (com.tencent.mm.aw.a.aiw()))
    {
      AppMethodBeat.o(81118);
      return true;
    }
    AppMethodBeat.o(81118);
    return false;
  }
  
  private static String YD(String paramString)
  {
    AppMethodBeat.i(81122);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(81122);
      return null;
    }
    try
    {
      String str = Uri.parse(paramString).getQueryParameter("p");
      AppMethodBeat.o(81122);
      return str;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.scanner.ProductUI", paramString + ";" + localException.getLocalizedMessage());
      AppMethodBeat.o(81122);
    }
    return null;
  }
  
  private static boolean YE(String paramString)
  {
    AppMethodBeat.i(81124);
    paramString = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(paramString);
    if ((paramString != null) && ((int)paramString.euF > 0) && (com.tencent.mm.n.a.je(paramString.field_type)))
    {
      AppMethodBeat.o(81124);
      return true;
    }
    AppMethodBeat.o(81124);
    return false;
  }
  
  private void YF(String paramString)
  {
    AppMethodBeat.i(81125);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("jsapi_args_appid", com.tencent.mm.plugin.scanner.model.k.CD(this.qxR));
    localIntent.putExtra("jsapiargs", localBundle);
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("pay_channel", 3);
    localIntent.putExtra("geta8key_scene", aGn());
    com.tencent.mm.bq.d.b(getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(81125);
  }
  
  private void a(q.a parama)
  {
    AppMethodBeat.i(81112);
    if (parama == null)
    {
      ab.e("MicroMsg.scanner.ProductUI", "refreshViewByProduct(), pd == null");
      finish();
      AppMethodBeat.o(81112);
      return;
    }
    if (!bo.isNullOrNil(parama.field_thumburl)) {
      this.qxT = new ProductUI.a(parama);
    }
    ciK();
    if ((!bo.isNullOrNil(parama.field_introtitle)) && (!bo.isNullOrNil(parama.field_introlink)))
    {
      this.guV.setText(parama.field_introtitle);
      this.guV.setOnClickListener(new ProductUI.15(this, parama));
      this.guV.setVisibility(0);
      this.qxR = this.qxP.field_functionType;
      if (parama.field_xmlType != 3) {
        break label403;
      }
      this.titleTv.setText(parama.field_title);
      if (bo.isNullOrNil(parama.field_certification)) {
        break label316;
      }
      this.qxK.setText(parama.field_certification);
      this.qxL.setVisibility(0);
      label169:
      if ((parama.field_type != 1) && (parama.field_type != 2)) {
        break label363;
      }
      this.qxH = ((ImageView)findViewById(2131826784));
      findViewById(2131826784).setVisibility(0);
      findViewById(2131826785).setVisibility(8);
      label222:
      if (!bo.isNullOrNil(parama.field_playurl))
      {
        ImageView localImageView = (ImageView)findViewById(2131826786);
        localImageView.setVisibility(0);
        localImageView.setOnClickListener(new ProductUI.16(this, parama));
      }
      addIconOptionMenu(0, 2130839668, new ProductUI.2(this));
    }
    for (;;)
    {
      ab.v("MicroMsg.scanner.ProductUI", "start postToMainThread initBodyView");
      al.d(new ProductUI.3(this, parama));
      AppMethodBeat.o(81112);
      return;
      this.guV.setVisibility(8);
      break;
      label316:
      this.qxK.setText(parama.field_source);
      this.qxL.setVisibility(8);
      this.qxM.setOnClickListener(null);
      this.qxM.setBackgroundDrawable(null);
      this.qxM.setFocusable(false);
      break label169;
      label363:
      this.qxH = ((ImageView)findViewById(2131826785));
      findViewById(2131826785).setVisibility(0);
      findViewById(2131826784).setVisibility(8);
      break label222;
      label403:
      if (parama.field_xmlType == 4)
      {
        this.qxH = ((ImageView)findViewById(2131826785));
        findViewById(2131826785).setVisibility(0);
        findViewById(2131826784).setVisibility(8);
        this.qxH.setImageResource(2131231941);
        this.qxH.setBackgroundResource(2131231941);
        this.titleTv.setText(2131302904);
        this.qxK.setText(null);
      }
    }
  }
  
  private int aGn()
  {
    if (this.qxR == 4) {
      return 11;
    }
    if (this.qxR == 3) {
      return 12;
    }
    return 0;
  }
  
  private void b(q.a parama)
  {
    AppMethodBeat.i(81114);
    if ((parama == null) || (parama.qDK == null) || (parama.qDK.size() == 0) || (this.screen == null))
    {
      AppMethodBeat.o(81114);
      return;
    }
    this.screen.removeAll();
    int i = 0;
    while (i < parama.qDK.size())
    {
      Object localObject2 = (com.tencent.mm.plugin.scanner.model.a)parama.qDK.get(i);
      Object localObject1;
      Object localObject3;
      if ((localObject2 != null) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).fQb != null) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).fQb.size() != 0) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).qtP != 1) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).qtR))
      {
        if (i != 0)
        {
          localObject1 = new Preference(this);
          ((Preference)localObject1).setLayoutResource(2130970436);
          this.screen.b((Preference)localObject1);
        }
        if ((!bo.isNullOrNil(((com.tencent.mm.plugin.scanner.model.a)localObject2).title)) && ((((com.tencent.mm.plugin.scanner.model.a)localObject2).type == 6) || (((com.tencent.mm.plugin.scanner.model.a)localObject2).type == 7)))
        {
          localObject1 = new CategoryWithTitlePreference(this);
          ((CategoryWithTitlePreference)localObject1).setTitle(((com.tencent.mm.plugin.scanner.model.a)localObject2).title);
          this.screen.b((Preference)localObject1);
        }
        if (((com.tencent.mm.plugin.scanner.model.a)localObject2).type != 6) {
          break label353;
        }
        localObject1 = new ArrayList();
        j = 0;
        while (j < ((com.tencent.mm.plugin.scanner.model.a)localObject2).fQb.size())
        {
          localObject3 = (a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).fQb.get(j);
          if (((a.a)localObject3).type == 10) {
            ((List)localObject1).add(localObject3);
          }
          j += 1;
        }
        if (((List)localObject1).size() > 0)
        {
          localObject2 = new h(this);
          ((h)localObject2).setKey(i * 100);
          ((h)localObject2).pvs = ((List)localObject1);
          this.screen.b((Preference)localObject2);
        }
      }
      i += 1;
      continue;
      label353:
      int j = 0;
      label355:
      a.a locala;
      if (j < ((com.tencent.mm.plugin.scanner.model.a)localObject2).fQb.size())
      {
        localObject3 = i * 100 + j;
        locala = (a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).fQb.get(j);
        if (locala.type == 11)
        {
          this.qxY = true;
          this.qxZ = locala.name;
        }
        if (locala.showType != 2)
        {
          if (locala.showType != 1) {
            break label509;
          }
          if (!bo.isNullOrNil(locala.image))
          {
            localObject1 = new b(this);
            ((b)localObject1).setKey((String)localObject3);
            ((b)localObject1).ljG = locala.image;
            ((b)localObject1).screen = this.screen;
            this.screen.b((Preference)localObject1);
          }
        }
      }
      label1185:
      for (;;)
      {
        j += 1;
        break label355;
        break;
        label509:
        if (locala.type == 5)
        {
          localObject1 = new MusicPreference(this);
          ((MusicPreference)localObject1).setKey((String)localObject3);
          ((MusicPreference)localObject1).setTitle(locala.name);
          ((MusicPreference)localObject1).qtT = locala.qtT;
          ((MusicPreference)localObject1).qtU = locala.qtU;
          ((MusicPreference)localObject1).qtV = locala.qtV;
          if (!YC(String.format("%s_cd_%s", new Object[] { locala.qtT, localObject3 })))
          {
            ((MusicPreference)localObject1).kB(false);
            ((MusicPreference)localObject1).qxn = this.qyf;
            this.screen.b((Preference)localObject1);
            com.tencent.mm.sdk.b.a.ymk.c(this.hCe);
            if (this.oZi == null) {
              this.oZi = new ArrayList();
            }
            if (this.qyg) {
              this.oZi.add(localObject1);
            }
          }
        }
        for (;;)
        {
          label610:
          if ((j >= ((com.tencent.mm.plugin.scanner.model.a)localObject2).fQb.size() - 1) || (locala.type == 12) || (((a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).fQb.get(j + 1)).type == 12) || (((a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).fQb.get(j + 1)).showType == 1) || (!d(j, ((com.tencent.mm.plugin.scanner.model.a)localObject2).fQb))) {
            break label1185;
          }
          localObject1 = new g(this);
          this.screen.b((Preference)localObject1);
          break;
          ((MusicPreference)localObject1).kB(true);
          break label610;
          if (locala.type == 6)
          {
            localObject1 = new e(this);
            ((e)localObject1).setKey((String)localObject3);
            ((e)localObject1).mTitle = locala.name;
            ((e)localObject1).setSummary(locala.desc);
            this.screen.b((Preference)localObject1);
            ((e)localObject1).qxc = this.qxW;
          }
          else if (locala.type == 12)
          {
            localObject1 = new f(this);
            ((f)localObject1).setKey((String)localObject3);
            ((f)localObject1).ljG = locala.thumburl;
            ((f)localObject1).screen = this.screen;
            this.screen.b((Preference)localObject1);
          }
          else
          {
            if (locala.type == 2)
            {
              if (YE(locala.username)) {}
              for (localObject1 = locala.quc;; localObject1 = locala.qub)
              {
                a locala1 = new a(this);
                locala1.setKey((String)localObject3);
                locala1.setTitle((CharSequence)localObject1);
                locala1.setSummary(locala.desc);
                locala1.qvw = locala.fjL;
                this.screen.b(locala1);
                break;
              }
            }
            if (locala.type == 22)
            {
              localObject1 = new d(this);
              ((d)localObject1).setKey((String)localObject3);
              if (!bo.isNullOrNil(locala.nickname)) {
                ((d)localObject1).kEW = (locala.nickname + ":");
              }
              ((d)localObject1).mContent = locala.content;
              ((d)localObject1).qwQ = locala.thumburl;
              this.screen.b((Preference)localObject1);
            }
            else
            {
              localObject1 = new a(this);
              ((a)localObject1).setKey((String)localObject3);
              ((a)localObject1).setTitle(locala.name);
              ((a)localObject1).setSummary(locala.desc);
              ((a)localObject1).qvw = locala.fjL;
              ((a)localObject1).lix = locala.iconUrl;
              this.screen.b((Preference)localObject1);
            }
          }
        }
      }
    }
    this.screen.notifyDataSetChanged();
    ab.d("MicroMsg.scanner.ProductUI", "initBodyView finish");
    if (this.oZi != null) {
      this.qyg = false;
    }
    AppMethodBeat.o(81114);
  }
  
  private void bb(int paramInt, String paramString)
  {
    AppMethodBeat.i(81119);
    if (this.qxP == null)
    {
      AppMethodBeat.o(81119);
      return;
    }
    paramString = new i(this.qxP.field_productid, "", paramInt, paramString, 0, 0);
    com.tencent.mm.kernel.g.Rc().a(paramString, 0);
    AppMethodBeat.o(81119);
  }
  
  private void ciK()
  {
    AppMethodBeat.i(81111);
    this.qxS = getContext().getResources().getDimensionPixelSize(2131428624);
    if ((this.qxP != null) && ((this.qxP.field_type == 1) || (this.qxP.field_type == 2)))
    {
      this.qxS = getContext().getResources().getDimensionPixelSize(2131428625);
      Object localObject = this.qxI.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.qxS;
      this.qxI.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.qxJ.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.qxS;
      this.qxN.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout)findViewById(2131826779);
      ViewGroup.LayoutParams localLayoutParams = ((RelativeLayout)localObject).getLayoutParams();
      localLayoutParams.height = this.qxS;
      ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
      localObject = this.qxN.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.qxS;
      this.qxN.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(81111);
  }
  
  private void ciL()
  {
    AppMethodBeat.i(81113);
    this.cpO = getIntent().getLongExtra("key_ProductUI_chatting_msgId", 0L);
    if ((this.cpO > 0L) && (com.tencent.mm.kernel.g.RG()))
    {
      bi localbi = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(this.cpO);
      if (localbi.field_msgId > 0L)
      {
        localbi.kk(this.qxT.aon());
        ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(this.cpO, localbi);
      }
    }
    AppMethodBeat.o(81113);
  }
  
  private void ciM()
  {
    AppMethodBeat.i(81116);
    if ((this.qxP == null) || (this.qxP.qDK == null) || (this.qxP.qDK.size() == 0) || (this.screen == null))
    {
      AppMethodBeat.o(81116);
      return;
    }
    int i = 0;
    while (i < this.qxP.qDK.size())
    {
      com.tencent.mm.plugin.scanner.model.a locala = (com.tencent.mm.plugin.scanner.model.a)this.qxP.qDK.get(i);
      if ((locala != null) && (locala.fQb != null) && (locala.fQb.size() != 0))
      {
        int j = 0;
        if (j < locala.fQb.size())
        {
          a.a locala1 = (a.a)locala.fQb.get(j);
          MusicPreference localMusicPreference;
          if (locala1.type == 5)
          {
            String str = i * 100 + j;
            localMusicPreference = (MusicPreference)this.screen.atx(str);
            if (localMusicPreference != null)
            {
              if (YC(String.format("%s_cd_%s", new Object[] { locala1.qtT, str }))) {
                break label221;
              }
              localMusicPreference.kB(false);
            }
          }
          for (;;)
          {
            j += 1;
            break;
            label221:
            localMusicPreference.kB(true);
          }
        }
      }
      i += 1;
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(81116);
  }
  
  private int ciN()
  {
    if (this.qxR == 3) {
      return 47;
    }
    return 49;
  }
  
  private void ciO()
  {
    AppMethodBeat.i(81127);
    if (this.qxP != null)
    {
      ab.i("MicroMsg.scanner.ProductUI", "doUpdateActionLogic, flag=:" + this.qxP.field_getaction);
      if ((this.qxP.field_getaction & 0x2) > 0)
      {
        this.dZt = com.tencent.mm.modelgeo.d.agQ();
        if (this.dZt != null)
        {
          this.dZt.b(this.dZA);
          AppMethodBeat.o(81127);
        }
      }
      else if ((this.qxP.field_getaction & 0x1) > 0)
      {
        com.tencent.mm.plugin.scanner.model.c localc = new com.tencent.mm.plugin.scanner.model.c(this.liu, com.tencent.mm.plugin.scanner.model.m.cR(this.qxP.qDK), this.mScene, this.qxX, 0.0D, 0.0D);
        com.tencent.mm.kernel.g.Rc().a(localc, 0);
      }
    }
    AppMethodBeat.o(81127);
  }
  
  private void ciP()
  {
    AppMethodBeat.i(81129);
    if (!com.tencent.mm.plugin.scanner.util.k.cjG())
    {
      ab.e("MicroMsg.scanner.ProductUI", "mHistoryItem ScanHistoryUtil.shouldShowHistoryList() is false!");
      AppMethodBeat.o(81129);
      return;
    }
    com.tencent.mm.plugin.scanner.history.a.a locala = new com.tencent.mm.plugin.scanner.history.a.a();
    locala.field_productId = this.liu;
    if (!com.tencent.mm.plugin.scanner.e.chX().cib().get(locala, new String[0])) {}
    for (boolean bool = com.tencent.mm.plugin.scanner.e.chX().cib().insert(this.qyd); bool; bool = com.tencent.mm.plugin.scanner.e.chX().cib().update(this.qyd, new String[0]))
    {
      ab.i("MicroMsg.scanner.ProductUI", "mHistoryItem insert success!");
      this.qyb = true;
      AppMethodBeat.o(81129);
      return;
    }
    ab.e("MicroMsg.scanner.ProductUI", "mHistoryItem insert fail!");
    AppMethodBeat.o(81129);
  }
  
  private static boolean d(int paramInt, LinkedList<a.a> paramLinkedList)
  {
    AppMethodBeat.i(81115);
    if (paramLinkedList != null)
    {
      paramInt += 1;
      while (paramInt < paramLinkedList.size())
      {
        if (((a.a)paramLinkedList.get(paramInt)).showType != 2)
        {
          AppMethodBeat.o(81115);
          return true;
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(81115);
    return false;
  }
  
  private static void p(View paramView, float paramFloat)
  {
    AppMethodBeat.i(81128);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    paramView.startAnimation(localAlphaAnimation);
    AppMethodBeat.o(81128);
  }
  
  private void u(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(81123);
    this.liu = paramString1;
    this.qxX = paramString2;
    paramString1 = new com.tencent.mm.plugin.scanner.model.d(paramString1, this.mScene, paramString2);
    com.tencent.mm.kernel.g.Rc().a(paramString1, 0);
    if (!paramBoolean)
    {
      paramString2 = getContext();
      getString(2131297087);
      this.eeN = com.tencent.mm.ui.base.h.b(paramString2, getString(2131302913), new ProductUI.8(this, paramString1));
    }
    AppMethodBeat.o(81123);
  }
  
  public int getHeaderResourceId()
  {
    return 2130970445;
  }
  
  public int getLayoutId()
  {
    return 2130970438;
  }
  
  public int getResourceId()
  {
    return 2131165258;
  }
  
  public void initView()
  {
    AppMethodBeat.i(81126);
    setMMTitle(2131302930);
    this.screen = getPreferenceScreen();
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().setBackgroundDrawable(null);
      getSupportActionBar();
    }
    setBackBtn(new ProductUI.10(this));
    this.titleTv = ((TextView)findViewById(2131826788));
    this.qxI = ((ImageView)findViewById(2131826780));
    this.qxJ = findViewById(2131826781);
    this.qxL = ((ImageView)findViewById(2131826790));
    this.qxQ = findViewById(2131826773);
    this.qxN = ((LinearLayout)findViewById(2131826782));
    this.qxO = ((ImageView)findViewById(2131826793));
    this.qxM = findViewById(2131826789);
    p(this.qxQ, 0.0F);
    Object localObject;
    String str;
    if (com.tencent.mm.cb.a.gt(getContext()))
    {
      this.titleTv.setTextSize(0, getContext().getResources().getDimensionPixelSize(2131427573) * com.tencent.mm.cb.a.gi(getContext()));
      this.qxK = ((TextView)findViewById(2131826791));
      this.guV = ((TextView)findViewById(2131826772));
      this.qxV = new HashMap();
      this.qxW = new ProductUI.11(this);
      this.qyd = new com.tencent.mm.plugin.scanner.history.a.a();
      this.qyd.field_ScanTime = System.currentTimeMillis();
      this.qyd.field_scene = this.mScene;
      if (this.mScene != 5) {
        break label428;
      }
      this.qya = true;
      localObject = getIntent().getStringExtra("key_Qrcode_Url");
      str = YD((String)localObject);
      this.qyd.field_qrcodeUrl = ((String)localObject);
      this.qyd.field_productId = str;
      u(str, (String)localObject, false);
    }
    label772:
    for (;;)
    {
      findViewById(2131826778).setOnClickListener(new ProductUI.12(this));
      findViewById(2131826792).setOnClickListener(new ProductUI.13(this));
      this.qxM.setOnClickListener(new ProductUI.14(this));
      new ProductUI.b(this);
      AppMethodBeat.o(81126);
      return;
      this.titleTv.setTextSize(0, com.tencent.mm.cb.a.ao(getContext(), 2131427573));
      break;
      label428:
      if (this.mScene == 4)
      {
        localObject = getIntent().getStringExtra("key_product_id");
        str = getIntent().getStringExtra("key_Qrcode_Url");
        if (!bo.isNullOrNil((String)localObject))
        {
          u((String)localObject, str, false);
        }
        else
        {
          ab.e("MicroMsg.scanner.ProductUI", "jsapi jump finish productId null");
          finish();
          AppMethodBeat.o(81126);
        }
      }
      else
      {
        this.qyc = getIntent().getBooleanExtra("key_is_from_barcode", false);
        this.qya = getIntent().getBooleanExtra("key_need_add_to_history", false);
        localObject = getIntent().getStringExtra("key_Product_xml");
        if (!bo.isNullOrNil((String)localObject))
        {
          int i = getIntent().getIntExtra("key_Product_funcType", 0);
          this.qxP = com.tencent.mm.plugin.scanner.model.k.dg((String)localObject, i);
          if (this.qxP == null)
          {
            ab.e("MicroMsg.scanner.ProductUI", "initView(), product == null");
            finish();
            AppMethodBeat.o(81126);
            return;
          }
          this.liu = this.qxP.field_productid;
          this.qxX = this.qxP.field_extinfo;
          if ((this.qya) && (!TextUtils.isEmpty(this.liu)))
          {
            this.qyd.field_xmlContent = ((String)localObject);
            this.qyd.field_qrcodeUrl = this.qxX;
            this.qyd.field_productId = this.liu;
            this.qyd.field_funcType = i;
            ciP();
          }
          for (;;)
          {
            localObject = this.qxP;
            getIntent().getBooleanExtra("key_ProductUI_addToDB", true);
            a((q.a)localObject);
            if ((i != 0) || (bo.isNullOrNil(this.qxP.field_productid))) {
              break label772;
            }
            u(this.qxP.field_productid, this.qxP.field_extinfo, true);
            break;
            ab.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.qya + " mProductId:" + this.liu);
          }
          ciO();
        }
        else
        {
          localObject = getIntent().getStringExtra("key_Product_ID");
          if (bo.isNullOrNil((String)localObject)) {
            break label807;
          }
          u((String)localObject, null, false);
        }
      }
    }
    label807:
    ab.e("MicroMsg.scanner.ProductUI", "normal finish productId null");
    finish();
    AppMethodBeat.o(81126);
  }
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(81120);
    if ((!bo.isNullOrNil(paramString)) && (this.qxP != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ab.d("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=".concat(String.valueOf(paramString)));
      al.d(new ProductUI.7(this, paramString, paramBitmap));
    }
    AppMethodBeat.o(81120);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(81106);
    super.onCreate(paramBundle);
    this.mStartTime = bo.aox();
    this.mScene = getIntent().getIntExtra("key_ProductUI_getProductInfoScene", 0);
    x.b(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("scanproductinfo", this.qye, true);
    initView();
    AppMethodBeat.o(81106);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(81109);
    x.c(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("scanproductinfo", this.qye, true);
    com.tencent.mm.sdk.b.a.ymk.d(this.hCe);
    if (this.dZt != null) {
      this.dZt.c(this.dZA);
    }
    bb(10100, bo.aox() - this.mStartTime);
    super.onDestroy();
    AppMethodBeat.o(81109);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(81108);
    com.tencent.mm.kernel.g.Rc().b(1063, this);
    com.tencent.mm.kernel.g.Rc().b(1068, this);
    super.onPause();
    AppMethodBeat.o(81108);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(81117);
    ab.i("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick item: [%s]", new Object[] { paramPreference.mKey });
    if ((this.qxP == null) || (this.qxP.qDK == null))
    {
      ab.e("MicroMsg.scanner.ProductUI", "product == null || product.actionlist == null");
      AppMethodBeat.o(81117);
      return false;
    }
    for (;;)
    {
      a.a locala1;
      Intent localIntent;
      try
      {
        int i = Integer.valueOf(paramPreference.mKey).intValue();
        int j = i / 100;
        int k = i % 100;
        ab.v("MicroMsg.scanner.ProductUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        if ((j < 0) || (j >= this.qxP.qDK.size()))
        {
          ab.w("MicroMsg.scanner.ProductUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(this.qxP.qDK.size()) });
          AppMethodBeat.o(81117);
          return false;
        }
        com.tencent.mm.plugin.scanner.model.a locala = (com.tencent.mm.plugin.scanner.model.a)this.qxP.qDK.get(j);
        if (locala == null)
        {
          ab.w("MicroMsg.scanner.ProductUI", "actionList == null");
          AppMethodBeat.o(81117);
          return false;
        }
        if ((k < 0) || (k >= locala.fQb.size()))
        {
          ab.w("MicroMsg.scanner.ProductUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(locala.fQb.size()) });
          AppMethodBeat.o(81117);
          return false;
        }
        locala1 = (a.a)locala.fQb.get(k);
        if (locala1 == null)
        {
          ab.w("MicroMsg.scanner.ProductUI", "action == null");
          AppMethodBeat.o(81117);
          return false;
        }
        ab.i("MicroMsg.scanner.ProductUI", "action.type = [%s]", new Object[] { Integer.valueOf(locala1.type) });
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
          ab.d("MicroMsg.scanner.ProductUI", "Default go url:" + locala1.link);
          paramf = paramPreference;
          if (!bo.isNullOrNil(locala1.link))
          {
            YF(locala1.link);
            paramf = paramPreference;
          }
        case 6: 
        case 7: 
        case 10: 
          paramf = new i(this.qxP.field_productid, locala1.qtW, locala1.type, paramf, locala.fQb.size(), locala1.showType);
          com.tencent.mm.kernel.g.Rc().a(paramf, 0);
          AppMethodBeat.o(81117);
          return true;
        }
      }
      catch (Exception paramf)
      {
        ab.e("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick, [%s]", new Object[] { paramf.getMessage() });
        ab.printErrStackTrace("MicroMsg.scanner.ProductUI", paramf, "", new Object[0]);
        AppMethodBeat.o(81117);
        return false;
      }
      paramPreference = locala1.link;
      paramf = paramPreference;
      if (!bo.isNullOrNil(locala1.link))
      {
        YF(locala1.link);
        paramf = paramPreference;
        continue;
        paramPreference = locala1.username;
        paramf = paramPreference;
        if (!bo.isNullOrNil(locala1.username))
        {
          paramf = locala1.username;
          if (YE(paramf))
          {
            localIntent = new Intent();
            localIntent.putExtra("Chat_User", paramf);
            localIntent.putExtra("finish_direct", true);
            localIntent.putExtra("add_scene", ciN());
            com.tencent.mm.plugin.scanner.c.gmO.d(localIntent, getContext());
            paramf = paramPreference;
          }
          else if (TextUtils.isEmpty(paramf))
          {
            ab.v("MicroMsg.scanner.ProductUI", "username is null");
            paramf = paramPreference;
          }
          else
          {
            localIntent = new Intent();
            localIntent.putExtra("Contact_User", paramf);
            localIntent.putExtra("force_get_contact", true);
            localIntent.putExtra("Contact_Scene", ciN());
            com.tencent.mm.plugin.scanner.c.gmO.c(localIntent, this);
            paramf = paramPreference;
            continue;
            paramf = locala1.qtV;
            localIntent.putExtra("rawUrl", locala1.qtV);
            localIntent.putExtra("geta8key_scene", aGn());
            com.tencent.mm.plugin.scanner.c.gmO.i(localIntent, this);
            com.tencent.mm.aw.a.aiu();
            ciM();
            continue;
            paramPreference = locala1.qtX;
            paramf = paramPreference;
            if (!bo.isNullOrNil(locala1.qtX))
            {
              localIntent.putExtra("key_product_id", locala1.qtX);
              localIntent.putExtra("key_product_scene", 12);
              com.tencent.mm.bq.d.b(this, "product", ".ui.MallProductUI", localIntent);
              paramf = paramPreference;
              continue;
              paramf = locala1.qtX;
              localIntent.putExtra("key_card_id", locala1.qtZ);
              localIntent.putExtra("key_card_ext", locala1.qtY);
              localIntent.putExtra("key_from_scene", 9);
              com.tencent.mm.bq.d.b(this, "card", ".ui.CardDetailUI", localIntent);
              continue;
              localIntent.setClass(this, ProductFurtherInfoUI.class);
              localIntent.putExtra("key_Product_xml", this.qxP.field_xml);
              localIntent.putExtra("key_title", locala1.name);
              startActivity(localIntent);
              paramf = paramPreference;
              continue;
              paramf = locala1.qtQ;
              localIntent.setClass(this, ProductPurchaseAreaUI.class);
              localIntent.putExtra("key_Product_xml", this.qxP.field_xml);
              localIntent.putExtra("referkey", locala1.qtQ);
              localIntent.putExtra("key_Product_funcType", this.qxR);
              startActivity(localIntent);
              continue;
              paramPreference = locala1.link;
              paramf = paramPreference;
              if (!bo.isNullOrNil(locala1.link))
              {
                YF(locala1.link);
                paramf = paramPreference;
              }
            }
          }
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(81107);
    super.onResume();
    com.tencent.mm.kernel.g.Rc().a(1063, this);
    com.tencent.mm.kernel.g.Rc().a(1068, this);
    AppMethodBeat.o(81107);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(81121);
    if (paramm == null)
    {
      ab.w("MicroMsg.scanner.ProductUI", "scene == null");
      AppMethodBeat.o(81121);
      return;
    }
    if (paramm.getType() == 1063)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.e("MicroMsg.scanner.ProductUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(81121);
        return;
      }
      paramString = (com.tencent.mm.plugin.scanner.model.d)paramm;
      if ((paramString.rr != null) && (paramString.rr.fsW.fta != null)) {}
      for (paramString = (lc)paramString.rr.fsW.fta; paramString == null; paramString = null)
      {
        ab.w("MicroMsg.scanner.ProductUI", "onSceneEnd productInfo == null");
        AppMethodBeat.o(81121);
        return;
      }
      if (paramString.wyR != null)
      {
        ab.d("MicroMsg.scanner.ProductUI", "onSceneEnd  productInfo.DescXML != null");
        paramm = com.tencent.mm.plugin.scanner.model.k.dg(paramString.wyR, this.qxR);
        if ((this.qxP != null) && (this.qxP.field_xml != null) && (paramm != null) && (paramm.field_xml != null) && (!this.qxP.field_xml.equals(paramm.field_xml)))
        {
          this.qxP = paramm;
          a(this.qxP);
        }
        for (;;)
        {
          if ((this.eeN != null) && (this.eeN.isShowing())) {
            this.eeN.dismiss();
          }
          ciO();
          if ((!this.qya) || (this.qyb) || (TextUtils.isEmpty(this.liu))) {
            break;
          }
          this.qyd.field_xmlContent = paramString.wyR;
          this.qyd.field_funcType = this.qxR;
          ciP();
          AppMethodBeat.o(81121);
          return;
          if ((paramm != null) && (paramm.field_xml != null))
          {
            this.qxP = paramm;
            a(this.qxP);
          }
        }
        ab.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.qya + " mProductId:" + this.liu + "  hasAddToHistory:" + this.qyb);
      }
      AppMethodBeat.o(81121);
      return;
    }
    if ((paramm.getType() == 1068) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((la)((com.tencent.mm.plugin.scanner.model.c)paramm).rr.fsW.fta).wyQ;
      if ((this.qxP != null) && (com.tencent.mm.plugin.scanner.model.m.b(this.qxP.qDK, com.tencent.mm.plugin.scanner.model.m.cS(paramString)))) {
        b(this.qxP);
      }
    }
    AppMethodBeat.o(81121);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI
 * JD-Core Version:    0.7.0.1
 */