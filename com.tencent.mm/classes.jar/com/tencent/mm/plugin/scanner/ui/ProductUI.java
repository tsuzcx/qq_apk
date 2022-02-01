package com.tencent.mm.plugin.scanner.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.p.b;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.e;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.l.h;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.l.k;
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.plugin.scanner.model.x;
import com.tencent.mm.plugin.scanner.model.y;
import com.tencent.mm.plugin.scanner.o;
import com.tencent.mm.plugin.scanner.util.q.a;
import com.tencent.mm.protocal.protobuf.pp;
import com.tencent.mm.protocal.protobuf.pr;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.e;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductUI
  extends MMPreference
  implements com.tencent.mm.am.h, r.a
{
  private boolean CZq;
  private ImageView DST;
  private boolean EDF;
  private boolean EPk;
  private List<MusicPreference> LLA;
  private View OZA;
  private TextView OZB;
  private ImageView OZC;
  private View OZD;
  private LinearLayout OZE;
  private ImageView OZF;
  private q.a OZG;
  private View OZH;
  private int OZI;
  private int OZJ;
  private a OZK;
  private boolean OZL;
  private HashMap<String, Boolean> OZM;
  private d.a OZN;
  private String OZO;
  private boolean OZP;
  private String OZQ;
  private boolean OZR;
  private boolean OZS;
  private com.tencent.mm.plugin.scanner.history.a.a OZT;
  private cl.a OZU;
  private MusicPreference.a OZV;
  private ImageView OZz;
  private b.a lsF;
  private com.tencent.mm.modelgeo.d lsy;
  protected ProgressDialog lzP;
  private int mScene;
  private long mStartTime;
  private long msgId;
  private boolean owu;
  private TextView pQn;
  private IListener rDF;
  protected com.tencent.mm.ui.base.preference.f screen;
  private TextView titleTv;
  private String xOk;
  
  public ProductUI()
  {
    AppMethodBeat.i(51876);
    this.OZI = 0;
    this.lzP = null;
    this.OZL = false;
    this.OZP = false;
    this.OZR = false;
    this.EDF = false;
    this.OZS = false;
    this.owu = false;
    this.lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(314553);
        if (paramAnonymousBoolean)
        {
          Log.i("MicroMsg.scanner.ProductUI", "getLocation suc");
          if (ProductUI.a(ProductUI.this) != null)
          {
            Log.i("MicroMsg.scanner.ProductUI", "do getActionInfoScene, lng=" + paramAnonymousFloat1 + ", lat=" + paramAnonymousFloat2);
            com.tencent.mm.plugin.scanner.model.q localq = new com.tencent.mm.plugin.scanner.model.q(ProductUI.b(ProductUI.this), y.kg(ProductUI.a(ProductUI.this).PjJ), ProductUI.c(ProductUI.this), ProductUI.d(ProductUI.this), paramAnonymousFloat1, paramAnonymousFloat2);
            com.tencent.mm.kernel.h.aZW().a(localq, 0);
          }
          if (ProductUI.e(ProductUI.this) != null) {
            ProductUI.e(ProductUI.this).a(ProductUI.f(ProductUI.this));
          }
          if (!ProductUI.g(ProductUI.this))
          {
            ProductUI.h(ProductUI.this);
            com.tencent.mm.modelstat.n.a(2011, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
          }
          AppMethodBeat.o(314553);
          return false;
        }
        if ((!ProductUI.i(ProductUI.this)) && (!com.tencent.mm.modelgeo.d.bJm()))
        {
          ProductUI.j(ProductUI.this);
          k.a(ProductUI.this, ProductUI.this.getString(l.i.gps_disable_tip), ProductUI.this.getString(l.i.app_tip), ProductUI.this.getString(l.i.jump_to_settings), ProductUI.this.getString(l.i.app_cancel), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(51850);
              com.tencent.mm.modelgeo.d.dP(ProductUI.this);
              AppMethodBeat.o(51850);
            }
          }, null);
        }
        Log.w("MicroMsg.scanner.ProductUI", "getLocation fail");
        AppMethodBeat.o(314553);
        return false;
      }
    };
    this.OZU = new ProductUI.8(this);
    this.OZV = new MusicPreference.a()
    {
      public final void d(MusicPreference paramAnonymousMusicPreference)
      {
        AppMethodBeat.i(51854);
        if (paramAnonymousMusicPreference == null)
        {
          Log.e("MicroMsg.scanner.ProductUI", "onMusicPrefClick, musicPref == null");
          AppMethodBeat.o(51854);
          return;
        }
        if ((Util.isNullOrNil(paramAnonymousMusicPreference.OQS)) && (Util.isNullOrNil(paramAnonymousMusicPreference.OQT)))
        {
          Log.w("MicroMsg.scanner.ProductUI", "wifiurl = null,  wapurl = null");
          if (!Util.isNullOrNil(paramAnonymousMusicPreference.OQU)) {
            ProductUI.a(ProductUI.this, paramAnonymousMusicPreference.OQU);
          }
          AppMethodBeat.o(51854);
          return;
        }
        String str1 = String.format("%s_cd_%s", new Object[] { paramAnonymousMusicPreference.OQS, paramAnonymousMusicPreference.mKey });
        int j;
        ArrayList localArrayList;
        int i;
        label193:
        MusicPreference localMusicPreference;
        String str2;
        if (!ProductUI.aVc(str1))
        {
          if (paramAnonymousMusicPreference.getTitle() == null)
          {
            Log.e("MicroMsg.scanner.ProductUI", "onPlayBtnClick, getTitle() == null");
            AppMethodBeat.o(51854);
            return;
          }
          j = -1;
          if (ProductUI.o(ProductUI.this) == null)
          {
            str1 = null;
            paramAnonymousMusicPreference = String.format("%s_cd_%s", new Object[] { paramAnonymousMusicPreference.OQS, paramAnonymousMusicPreference.mKey });
            localArrayList = new ArrayList();
            Iterator localIterator = ProductUI.p(ProductUI.this).iterator();
            i = 0;
            if (!localIterator.hasNext()) {
              break label330;
            }
            localMusicPreference = (MusicPreference)localIterator.next();
            str2 = String.format("%s_cd_%s", new Object[] { localMusicPreference.OQS, localMusicPreference.mKey });
            if (!paramAnonymousMusicPreference.equals(str2)) {
              break label381;
            }
            j = i;
          }
        }
        label330:
        label381:
        for (;;)
        {
          localArrayList.add(com.tencent.mm.aw.g.a(5, str1, localMusicPreference.getTitle().toString(), "", localMusicPreference.OQU, localMusicPreference.OQT, localMusicPreference.OQS, str2, com.tencent.mm.kernel.h.baE().mCJ, str1, "", "wx482a4001c37e2b74"));
          i += 1;
          break label193;
          str1 = ProductUI.o(ProductUI.this).bTC();
          break;
          if (j < 0)
          {
            AppMethodBeat.o(51854);
            return;
          }
          com.tencent.mm.aw.a.o(localArrayList, j);
          for (;;)
          {
            ProductUI.q(ProductUI.this);
            AppMethodBeat.o(51854);
            return;
            com.tencent.mm.aw.a.bLi();
            Log.d("MicroMsg.scanner.ProductUI", "isTheSameId, playMusicId : [%s]", new Object[] { str1 });
          }
        }
      }
    };
    this.CZq = true;
    this.rDF = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(51876);
  }
  
  private static void A(View paramView, float paramFloat)
  {
    AppMethodBeat.i(51898);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    paramView.startAnimation(localAlphaAnimation);
    AppMethodBeat.o(51898);
  }
  
  private void G(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(51894);
    this.xOk = paramString1;
    this.OZO = paramString2;
    paramString1 = new com.tencent.mm.plugin.scanner.model.r(paramString1, this.mScene, paramString2);
    com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
    if (!paramBoolean)
    {
      paramString2 = getContext();
      getString(l.i.app_tip);
      this.lzP = k.b(paramString2, getString(l.i.gUc), true, new ProductUI.7(this, paramString1));
    }
    AppMethodBeat.o(51894);
  }
  
  private void a(q.a parama)
  {
    AppMethodBeat.i(51883);
    if (parama == null)
    {
      Log.e("MicroMsg.scanner.ProductUI", "refreshViewByProduct(), pd == null");
      finish();
      AppMethodBeat.o(51883);
      return;
    }
    if (!Util.isNullOrNil(parama.field_thumburl)) {
      this.OZK = new a(parama);
    }
    gSy();
    if ((!Util.isNullOrNil(parama.field_introtitle)) && (!Util.isNullOrNil(parama.field_introlink)))
    {
      this.pQn.setText(parama.field_introtitle);
      this.pQn.setOnClickListener(new ProductUI.15(this, parama));
      this.pQn.setVisibility(0);
      this.OZI = this.OZG.field_functionType;
      if (parama.field_xmlType != 3) {
        break label399;
      }
      this.titleTv.setText(parama.field_title);
      if (Util.isNullOrNil(parama.field_certification)) {
        break label312;
      }
      this.OZB.setText(parama.field_certification);
      this.OZC.setVisibility(0);
      label166:
      if ((parama.field_type != 1) && (parama.field_type != 2)) {
        break label359;
      }
      this.DST = ((ImageView)findViewById(l.f.OJc));
      findViewById(l.f.OJc).setVisibility(0);
      findViewById(l.f.OJf).setVisibility(8);
      label219:
      if (!Util.isNullOrNil(parama.field_playurl))
      {
        ImageView localImageView = (ImageView)findViewById(l.f.OIY);
        localImageView.setVisibility(0);
        localImageView.setOnClickListener(new ProductUI.16(this, parama));
      }
      addIconOptionMenu(0, l.h.icons_outlined_more, new ProductUI.2(this));
    }
    for (;;)
    {
      Log.v("MicroMsg.scanner.ProductUI", "start postToMainThread initBodyView");
      MMHandlerThread.postToMainThread(new ProductUI.3(this, parama));
      AppMethodBeat.o(51883);
      return;
      this.pQn.setVisibility(8);
      break;
      label312:
      this.OZB.setText(parama.field_source);
      this.OZC.setVisibility(8);
      this.OZD.setOnClickListener(null);
      this.OZD.setBackgroundDrawable(null);
      this.OZD.setFocusable(false);
      break label166;
      label359:
      this.DST = ((ImageView)findViewById(l.f.OJf));
      findViewById(l.f.OJf).setVisibility(0);
      findViewById(l.f.OJc).setVisibility(8);
      break label219;
      label399:
      if (parama.field_xmlType == 4)
      {
        this.DST = ((ImageView)findViewById(l.f.OJf));
        findViewById(l.f.OJf).setVisibility(0);
        findViewById(l.f.OJc).setVisibility(8);
        this.DST.setImageResource(l.h.scan_without_commodity_icon);
        this.DST.setBackgroundResource(l.h.scan_without_commodity_icon);
        this.titleTv.setText(l.i.OLe);
        this.OZB.setText(null);
      }
    }
  }
  
  private static boolean aUY(String paramString)
  {
    AppMethodBeat.i(51889);
    com.tencent.mm.aw.f localf = com.tencent.mm.aw.a.bLn();
    if ((localf != null) && (localf.oOt == 5) && (paramString.equals(localf.oOv)) && (com.tencent.mm.aw.a.bLk()))
    {
      AppMethodBeat.o(51889);
      return true;
    }
    AppMethodBeat.o(51889);
    return false;
  }
  
  private static String aUZ(String paramString)
  {
    AppMethodBeat.i(51893);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(51893);
      return null;
    }
    try
    {
      String str = Uri.parse(paramString).getQueryParameter("p");
      AppMethodBeat.o(51893);
      return str;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.scanner.ProductUI", paramString + ";" + localException.getLocalizedMessage());
      AppMethodBeat.o(51893);
    }
    return null;
  }
  
  private static boolean aVa(String paramString)
  {
    AppMethodBeat.i(51895);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString);
    if ((paramString != null) && ((int)paramString.maN > 0) && (com.tencent.mm.contact.d.rs(paramString.field_type)))
    {
      AppMethodBeat.o(51895);
      return true;
    }
    AppMethodBeat.o(51895);
    return false;
  }
  
  private void aVb(String paramString)
  {
    AppMethodBeat.i(51896);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("jsapi_args_appid", x.ahM(this.OZI));
    localIntent.putExtra("jsapiargs", localBundle);
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("pay_channel", 3);
    localIntent.putExtra("geta8key_scene", cxN());
    com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(51896);
  }
  
  private void b(q.a parama)
  {
    AppMethodBeat.i(51885);
    if ((parama == null) || (parama.PjJ == null) || (parama.PjJ.size() == 0) || (this.screen == null))
    {
      AppMethodBeat.o(51885);
      return;
    }
    this.screen.removeAll();
    int i = 0;
    while (i < parama.PjJ.size())
    {
      Object localObject2 = (com.tencent.mm.plugin.scanner.model.a)parama.PjJ.get(i);
      Object localObject1;
      Object localObject3;
      if ((localObject2 != null) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).sXD != null) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).sXD.size() != 0) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).OQO != 1) && (((com.tencent.mm.plugin.scanner.model.a)localObject2).OQQ))
      {
        if (i != 0)
        {
          localObject1 = new Preference(this);
          ((Preference)localObject1).setLayoutResource(l.g.OKm);
          this.screen.c((Preference)localObject1);
        }
        if ((!Util.isNullOrNil(((com.tencent.mm.plugin.scanner.model.a)localObject2).title)) && ((((com.tencent.mm.plugin.scanner.model.a)localObject2).type == 6) || (((com.tencent.mm.plugin.scanner.model.a)localObject2).type == 7)))
        {
          localObject1 = new CategoryWithTitlePreference(this);
          ((CategoryWithTitlePreference)localObject1).setTitle(((com.tencent.mm.plugin.scanner.model.a)localObject2).title);
          this.screen.c((Preference)localObject1);
        }
        if (((com.tencent.mm.plugin.scanner.model.a)localObject2).type != 6) {
          break label353;
        }
        localObject1 = new ArrayList();
        j = 0;
        while (j < ((com.tencent.mm.plugin.scanner.model.a)localObject2).sXD.size())
        {
          localObject3 = (a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).sXD.get(j);
          if (((a.a)localObject3).type == 10) {
            ((List)localObject1).add(localObject3);
          }
          j += 1;
        }
        if (((List)localObject1).size() > 0)
        {
          localObject2 = new g(this);
          ((g)localObject2).setKey(i * 100);
          ((g)localObject2).MRS = ((List)localObject1);
          this.screen.c((Preference)localObject2);
        }
      }
      i += 1;
      continue;
      label353:
      int j = 0;
      label355:
      a.a locala;
      if (j < ((com.tencent.mm.plugin.scanner.model.a)localObject2).sXD.size())
      {
        localObject3 = i * 100 + j;
        locala = (a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).sXD.get(j);
        if (locala.type == 11)
        {
          this.OZP = true;
          this.OZQ = locala.name;
        }
        if (locala.hAN != 2)
        {
          if (locala.hAN != 1) {
            break label509;
          }
          if (!Util.isNullOrNil(locala.image))
          {
            localObject1 = new b(this);
            ((b)localObject1).setKey((String)localObject3);
            ((b)localObject1).OXh = locala.image;
            ((b)localObject1).screen = this.screen;
            this.screen.c((Preference)localObject1);
          }
        }
      }
      label1181:
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
          ((MusicPreference)localObject1).OQS = locala.OQS;
          ((MusicPreference)localObject1).OQT = locala.OQT;
          ((MusicPreference)localObject1).OQU = locala.OQU;
          if (!aUY(String.format("%s_cd_%s", new Object[] { locala.OQS, localObject3 })))
          {
            ((MusicPreference)localObject1).Ch(false);
            ((MusicPreference)localObject1).OZf = this.OZV;
            this.screen.c((Preference)localObject1);
            this.rDF.alive();
            if (this.LLA == null) {
              this.LLA = new ArrayList();
            }
            if (this.CZq) {
              this.LLA.add(localObject1);
            }
          }
        }
        for (;;)
        {
          label610:
          if ((j >= ((com.tencent.mm.plugin.scanner.model.a)localObject2).sXD.size() - 1) || (locala.type == 12) || (((a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).sXD.get(j + 1)).type == 12) || (((a.a)((com.tencent.mm.plugin.scanner.model.a)localObject2).sXD.get(j + 1)).hAN == 1) || (!d(j, ((com.tencent.mm.plugin.scanner.model.a)localObject2).sXD))) {
            break label1181;
          }
          localObject1 = new f(this);
          this.screen.c((Preference)localObject1);
          break;
          ((MusicPreference)localObject1).Ch(true);
          break label610;
          if (locala.type == 6)
          {
            localObject1 = new d(this);
            ((d)localObject1).setKey((String)localObject3);
            ((d)localObject1).mTitle = locala.name;
            ((d)localObject1).aS(locala.desc);
            this.screen.c((Preference)localObject1);
            ((d)localObject1).OYU = this.OZN;
          }
          else if (locala.type == 12)
          {
            localObject1 = new e(this);
            ((e)localObject1).setKey((String)localObject3);
            ((e)localObject1).OXh = locala.thumburl;
            ((e)localObject1).screen = this.screen;
            this.screen.c((Preference)localObject1);
          }
          else
          {
            if (locala.type == 2)
            {
              if (aVa(locala.username)) {}
              for (localObject1 = locala.OQZ;; localObject1 = locala.OQY)
              {
                a locala1 = new a(this);
                locala1.setKey((String)localObject3);
                locala1.setTitle((CharSequence)localObject1);
                locala1.aS(locala.desc);
                locala1.OXe = locala.nUO;
                this.screen.c(locala1);
                break;
              }
            }
            if (locala.type == 22)
            {
              localObject1 = new c(this);
              ((c)localObject1).setKey((String)localObject3);
              if (!Util.isNullOrNil(locala.nickname)) {
                ((c)localObject1).wPR = (locala.nickname + ":");
              }
              ((c)localObject1).mContent = locala.content;
              ((c)localObject1).OYK = locala.thumburl;
              this.screen.c((Preference)localObject1);
            }
            else
            {
              localObject1 = new a(this);
              ((a)localObject1).setKey((String)localObject3);
              ((a)localObject1).setTitle(locala.name);
              ((a)localObject1).aS(locala.desc);
              ((a)localObject1).OXe = locala.nUO;
              ((a)localObject1).xOn = locala.iconUrl;
              this.screen.c((Preference)localObject1);
            }
          }
        }
      }
    }
    this.screen.notifyDataSetChanged();
    Log.d("MicroMsg.scanner.ProductUI", "initBodyView finish");
    if (this.LLA != null) {
      this.CZq = false;
    }
    AppMethodBeat.o(51885);
  }
  
  private void cY(int paramInt, String paramString)
  {
    AppMethodBeat.i(51890);
    if (this.OZG == null)
    {
      AppMethodBeat.o(51890);
      return;
    }
    paramString = new com.tencent.mm.plugin.scanner.model.v(this.OZG.field_productid, "", paramInt, paramString, 0, 0);
    com.tencent.mm.kernel.h.aZW().a(paramString, 0);
    AppMethodBeat.o(51890);
  }
  
  private int cxN()
  {
    if (this.OZI == 4) {
      return 11;
    }
    if (this.OZI == 3) {
      return 12;
    }
    return 0;
  }
  
  private static boolean d(int paramInt, LinkedList<a.a> paramLinkedList)
  {
    AppMethodBeat.i(51886);
    if (paramLinkedList != null)
    {
      paramInt += 1;
      while (paramInt < paramLinkedList.size())
      {
        if (((a.a)paramLinkedList.get(paramInt)).hAN != 2)
        {
          AppMethodBeat.o(51886);
          return true;
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(51886);
    return false;
  }
  
  private void gSA()
  {
    AppMethodBeat.i(51887);
    if ((this.OZG == null) || (this.OZG.PjJ == null) || (this.OZG.PjJ.size() == 0) || (this.screen == null))
    {
      AppMethodBeat.o(51887);
      return;
    }
    int i = 0;
    while (i < this.OZG.PjJ.size())
    {
      com.tencent.mm.plugin.scanner.model.a locala = (com.tencent.mm.plugin.scanner.model.a)this.OZG.PjJ.get(i);
      if ((locala != null) && (locala.sXD != null) && (locala.sXD.size() != 0))
      {
        int j = 0;
        if (j < locala.sXD.size())
        {
          a.a locala1 = (a.a)locala.sXD.get(j);
          MusicPreference localMusicPreference;
          if (locala1.type == 5)
          {
            String str = i * 100 + j;
            localMusicPreference = (MusicPreference)this.screen.bAi(str);
            if (localMusicPreference != null)
            {
              if (aUY(String.format("%s_cd_%s", new Object[] { locala1.OQS, str }))) {
                break label221;
              }
              localMusicPreference.Ch(false);
            }
          }
          for (;;)
          {
            j += 1;
            break;
            label221:
            localMusicPreference.Ch(true);
          }
        }
      }
      i += 1;
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(51887);
  }
  
  private int gSB()
  {
    if (this.OZI == 3) {
      return 47;
    }
    return 49;
  }
  
  private void gSC()
  {
    AppMethodBeat.i(51897);
    if (this.OZG != null)
    {
      Log.i("MicroMsg.scanner.ProductUI", "doUpdateActionLogic, flag=:" + this.OZG.field_getaction);
      if ((this.OZG.field_getaction & 0x2) > 0)
      {
        this.lsy = com.tencent.mm.modelgeo.d.bJl();
        if (this.lsy != null)
        {
          this.lsy.a(this.lsF, true, false);
          l.kK(22, 10);
          AppMethodBeat.o(51897);
        }
      }
      else if ((this.OZG.field_getaction & 0x1) > 0)
      {
        com.tencent.mm.plugin.scanner.model.q localq = new com.tencent.mm.plugin.scanner.model.q(this.xOk, y.kg(this.OZG.PjJ), this.mScene, this.OZO, 0.0D, 0.0D);
        com.tencent.mm.kernel.h.aZW().a(localq, 0);
      }
    }
    AppMethodBeat.o(51897);
  }
  
  private void gSD()
  {
    AppMethodBeat.i(51899);
    if (!com.tencent.mm.plugin.scanner.util.f.gTZ())
    {
      Log.e("MicroMsg.scanner.ProductUI", "mHistoryItem ScanHistoryUtil.shouldShowHistoryList() is false!");
      AppMethodBeat.o(51899);
      return;
    }
    com.tencent.mm.plugin.scanner.history.a.a locala = new com.tencent.mm.plugin.scanner.history.a.a();
    locala.field_productId = this.xOk;
    if (!o.gPw().gPy().get(locala, new String[0])) {}
    for (boolean bool = o.gPw().gPy().insert(this.OZT); bool; bool = o.gPw().gPy().update(this.OZT, new String[0]))
    {
      Log.i("MicroMsg.scanner.ProductUI", "mHistoryItem insert success!");
      this.EDF = true;
      AppMethodBeat.o(51899);
      return;
    }
    Log.e("MicroMsg.scanner.ProductUI", "mHistoryItem insert fail!");
    AppMethodBeat.o(51899);
  }
  
  private void gSy()
  {
    AppMethodBeat.i(51882);
    this.OZJ = getContext().getResources().getDimensionPixelSize(l.d.OIb);
    if ((this.OZG != null) && ((this.OZG.field_type == 1) || (this.OZG.field_type == 2)))
    {
      this.OZJ = getContext().getResources().getDimensionPixelSize(l.d.OIc);
      Object localObject = this.OZz.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.OZJ;
      this.OZz.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.OZA.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.OZJ;
      this.OZE.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout)findViewById(l.f.OJa);
      ViewGroup.LayoutParams localLayoutParams = ((RelativeLayout)localObject).getLayoutParams();
      localLayoutParams.height = this.OZJ;
      ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
      localObject = this.OZE.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = this.OZJ;
      this.OZE.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(51882);
  }
  
  private void gSz()
  {
    AppMethodBeat.i(51884);
    this.msgId = getIntent().getLongExtra("key_ProductUI_chatting_msgId", 0L);
    if ((this.msgId > 0L) && (com.tencent.mm.kernel.h.baz()))
    {
      cc localcc = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(this.msgId);
      if ((localcc != null) && (localcc.field_msgId > 0L))
      {
        localcc.BT(this.OZK.bTC());
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(this.msgId, localcc);
      }
    }
    AppMethodBeat.o(51884);
  }
  
  public int getHeaderResourceId()
  {
    return l.g.OKt;
  }
  
  public int getLayoutId()
  {
    return l.g.OIX;
  }
  
  public int getResourceId()
  {
    return l.k.OLS;
  }
  
  public void initView()
  {
    AppMethodBeat.i(51881);
    setMMTitle(l.i.OLq);
    this.screen = getPreferenceScreen();
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().setBackgroundDrawable(null);
      getSupportActionBar().getCustomView();
    }
    setBackBtn(new ProductUI.9(this));
    this.titleTv = ((TextView)findViewById(l.f.OJh));
    this.OZz = ((ImageView)findViewById(l.f.OIZ));
    this.OZA = findViewById(l.f.OJe);
    this.OZC = ((ImageView)findViewById(l.f.OIW));
    this.OZH = findViewById(l.f.OIT);
    this.OZE = ((LinearLayout)findViewById(l.f.OJd));
    this.OZF = ((ImageView)findViewById(l.f.OJb));
    this.OZD = findViewById(l.f.OIV);
    A(this.OZH, 0.0F);
    Object localObject;
    String str;
    if (com.tencent.mm.cd.a.mp(getContext()))
    {
      this.titleTv.setTextSize(0, getContext().getResources().getDimensionPixelSize(l.d.DialogTitleTextSize) * com.tencent.mm.cd.a.mf(getContext()));
      this.OZB = ((TextView)findViewById(l.f.OIU));
      this.pQn = ((TextView)findViewById(l.f.OJr));
      this.OZM = new HashMap();
      this.OZN = new d.a()
      {
        public final Boolean aUW(String paramAnonymousString)
        {
          AppMethodBeat.i(51864);
          if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0))
          {
            paramAnonymousString = (Boolean)ProductUI.k(ProductUI.this).get(paramAnonymousString);
            AppMethodBeat.o(51864);
            return paramAnonymousString;
          }
          AppMethodBeat.o(51864);
          return null;
        }
        
        public final void c(String paramAnonymousString, Boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(51863);
          if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0)) {
            ProductUI.k(ProductUI.this).put(paramAnonymousString, paramAnonymousBoolean);
          }
          AppMethodBeat.o(51863);
        }
        
        public final void gSx()
        {
          AppMethodBeat.i(51865);
          if (ProductUI.this.screen != null) {
            ProductUI.this.screen.notifyDataSetChanged();
          }
          AppMethodBeat.o(51865);
        }
      };
      this.OZT = new com.tencent.mm.plugin.scanner.history.a.a();
      this.OZT.field_ScanTime = System.currentTimeMillis();
      this.OZT.field_scene = this.mScene;
      if (this.mScene != 5) {
        break label431;
      }
      this.OZR = true;
      localObject = getIntent().getStringExtra("key_Qrcode_Url");
      str = aUZ((String)localObject);
      this.OZT.field_qrcodeUrl = ((String)localObject);
      this.OZT.field_productId = str;
      G(str, (String)localObject, false);
    }
    label775:
    for (;;)
    {
      findViewById(l.f.OJg).setOnClickListener(new ProductUI.11(this));
      findViewById(l.f.OIX).setOnClickListener(new ProductUI.12(this));
      this.OZD.setOnClickListener(new ProductUI.14(this));
      new b();
      AppMethodBeat.o(51881);
      return;
      this.titleTv.setTextSize(0, com.tencent.mm.cd.a.br(getContext(), l.d.DialogTitleTextSize));
      break;
      label431:
      if (this.mScene == 4)
      {
        localObject = getIntent().getStringExtra("key_product_id");
        str = getIntent().getStringExtra("key_Qrcode_Url");
        if (!Util.isNullOrNil((String)localObject))
        {
          G((String)localObject, str, false);
        }
        else
        {
          Log.e("MicroMsg.scanner.ProductUI", "jsapi jump finish productId null");
          finish();
          AppMethodBeat.o(51881);
        }
      }
      else
      {
        this.OZS = getIntent().getBooleanExtra("key_is_from_barcode", false);
        this.OZR = getIntent().getBooleanExtra("key_need_add_to_history", false);
        localObject = getIntent().getStringExtra("key_Product_xml");
        if (!Util.isNullOrNil((String)localObject))
        {
          int i = getIntent().getIntExtra("key_Product_funcType", 0);
          this.OZG = x.gI((String)localObject, i);
          if (this.OZG == null)
          {
            Log.e("MicroMsg.scanner.ProductUI", "initView(), product == null");
            finish();
            AppMethodBeat.o(51881);
            return;
          }
          this.xOk = this.OZG.field_productid;
          this.OZO = this.OZG.field_extinfo;
          if ((this.OZR) && (!TextUtils.isEmpty(this.xOk)))
          {
            this.OZT.field_xmlContent = ((String)localObject);
            this.OZT.field_qrcodeUrl = this.OZO;
            this.OZT.field_productId = this.xOk;
            this.OZT.field_funcType = i;
            gSD();
          }
          for (;;)
          {
            localObject = this.OZG;
            getIntent().getBooleanExtra("key_ProductUI_addToDB", true);
            a((q.a)localObject);
            if ((i != 0) || (Util.isNullOrNil(this.OZG.field_productid))) {
              break label775;
            }
            G(this.OZG.field_productid, this.OZG.field_extinfo, true);
            break;
            Log.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.OZR + " mProductId:" + this.xOk);
          }
          gSC();
        }
        else
        {
          localObject = getIntent().getStringExtra("key_Product_ID");
          if (Util.isNullOrNil((String)localObject)) {
            break label810;
          }
          G((String)localObject, null, false);
        }
      }
    }
    label810:
    Log.e("MicroMsg.scanner.ProductUI", "normal finish productId null");
    finish();
    AppMethodBeat.o(51881);
  }
  
  public final void k(final String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(51891);
    if ((!Util.isNullOrNil(paramString)) && (this.OZG != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.d("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=".concat(String.valueOf(paramString)));
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(51858);
          if ((paramString.equals(ProductUI.a(ProductUI.this).field_thumburl)) && (ProductUI.s(ProductUI.this) != null)) {
            Log.i("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=" + paramString);
          }
          try
          {
            ProductUI.s(ProductUI.this).setImageBitmap(paramBitmap);
            ProductUI.s(ProductUI.this).setBackgroundDrawable(null);
            ProductUI.s(ProductUI.this).setBackgroundColor(-1);
            ProductUI.t(ProductUI.this);
            ProductUI.u(ProductUI.this);
            if ((paramString.equals(ProductUI.a(ProductUI.this).field_headerbackgroundurl)) && (ProductUI.v(ProductUI.this) != null)) {
              ProductUI.v(ProductUI.this).setImageBitmap(paramBitmap);
            }
            AppMethodBeat.o(51858);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e("MicroMsg.scanner.ProductUI", "onGetPictureFinish : [%s]", new Object[] { localException.getLocalizedMessage() });
            }
          }
        }
      });
    }
    AppMethodBeat.o(51891);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51877);
    super.onCreate(paramBundle);
    this.mStartTime = Util.nowSecond();
    this.mScene = getIntent().getIntExtra("key_ProductUI_getProductInfoScene", 0);
    com.tencent.mm.platformtools.r.b(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("scanproductinfo", this.OZU, true);
    initView();
    AppMethodBeat.o(51877);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51880);
    com.tencent.mm.platformtools.r.c(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("scanproductinfo", this.OZU, true);
    this.rDF.dead();
    if (this.lsy != null) {
      this.lsy.a(this.lsF);
    }
    cY(10100, Util.nowSecond() - this.mStartTime);
    super.onDestroy();
    AppMethodBeat.o(51880);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51879);
    com.tencent.mm.kernel.h.aZW().b(1063, this);
    com.tencent.mm.kernel.h.aZW().b(1068, this);
    super.onPause();
    AppMethodBeat.o(51879);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(51888);
    Log.i("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick item: [%s]", new Object[] { paramPreference.mKey });
    if ((this.OZG == null) || (this.OZG.PjJ == null))
    {
      Log.e("MicroMsg.scanner.ProductUI", "product == null || product.actionlist == null");
      AppMethodBeat.o(51888);
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
        Log.v("MicroMsg.scanner.ProductUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        if ((j < 0) || (j >= this.OZG.PjJ.size()))
        {
          Log.w("MicroMsg.scanner.ProductUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(this.OZG.PjJ.size()) });
          AppMethodBeat.o(51888);
          return false;
        }
        locala = (com.tencent.mm.plugin.scanner.model.a)this.OZG.PjJ.get(j);
        if (locala == null)
        {
          Log.w("MicroMsg.scanner.ProductUI", "actionList == null");
          AppMethodBeat.o(51888);
          return false;
        }
        if ((k < 0) || (k >= locala.sXD.size()))
        {
          Log.w("MicroMsg.scanner.ProductUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(locala.sXD.size()) });
          AppMethodBeat.o(51888);
          return false;
        }
        locala1 = (a.a)locala.sXD.get(k);
        if (locala1 == null)
        {
          Log.w("MicroMsg.scanner.ProductUI", "action == null");
          AppMethodBeat.o(51888);
          return false;
        }
        Log.i("MicroMsg.scanner.ProductUI", "action.type = [%s]", new Object[] { Integer.valueOf(locala1.type) });
        localIntent = new Intent();
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
          Log.d("MicroMsg.scanner.ProductUI", "Default go url:" + locala1.link);
          if (Util.isNullOrNil(locala1.link)) {
            break label1271;
          }
          aVb(locala1.link);
        }
      }
      catch (Exception paramf)
      {
        com.tencent.mm.plugin.scanner.model.a locala;
        Log.e("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick, [%s]", new Object[] { paramf.getMessage() });
        Log.printErrStackTrace("MicroMsg.scanner.ProductUI", paramf, "", new Object[0]);
        AppMethodBeat.o(51888);
        return false;
      }
      paramf = new com.tencent.mm.plugin.scanner.model.v(this.OZG.field_productid, locala1.OQV, locala1.type, paramf, locala.sXD.size(), locala1.hAN);
      com.tencent.mm.kernel.h.aZW().a(paramf, 0);
      AppMethodBeat.o(51888);
      return true;
      paramPreference = locala1.link;
      paramf = paramPreference;
      if (!Util.isNullOrNil(locala1.link))
      {
        aVb(locala1.link);
        paramf = paramPreference;
        continue;
        paramPreference = locala1.username;
        paramf = paramPreference;
        if (!Util.isNullOrNil(locala1.username))
        {
          paramf = locala1.username;
          if (aVa(paramf))
          {
            localIntent = new Intent();
            localIntent.putExtra("Chat_User", paramf);
            localIntent.putExtra("finish_direct", true);
            localIntent.putExtra("add_scene", gSB());
            com.tencent.mm.plugin.scanner.m.dFc().d(localIntent, getContext());
            paramf = paramPreference;
          }
          else if (TextUtils.isEmpty(paramf))
          {
            Log.v("MicroMsg.scanner.ProductUI", "username is null");
            paramf = paramPreference;
          }
          else
          {
            localIntent = new Intent();
            localIntent.putExtra("Contact_User", paramf);
            localIntent.putExtra("force_get_contact", true);
            localIntent.putExtra("Contact_Scene", gSB());
            com.tencent.mm.plugin.scanner.m.dFc().c(localIntent, this);
            paramf = paramPreference;
            continue;
            paramf = locala1.OQU;
            localIntent.putExtra("rawUrl", locala1.OQU);
            localIntent.putExtra("geta8key_scene", cxN());
            com.tencent.mm.plugin.scanner.m.dFc().h(localIntent, this);
            com.tencent.mm.aw.a.bLi();
            gSA();
            continue;
            paramPreference = locala1.productid;
            paramf = paramPreference;
            if (!Util.isNullOrNil(locala1.productid))
            {
              localIntent.putExtra("key_product_id", locala1.productid);
              localIntent.putExtra("key_product_scene", 12);
              com.tencent.mm.br.c.b(this, "product", ".ui.MallProductUI", localIntent);
              paramf = paramPreference;
              continue;
              paramf = locala1.productid;
              localIntent.putExtra("key_card_id", locala1.OQX);
              localIntent.putExtra("key_card_ext", locala1.OQW);
              localIntent.putExtra("key_from_scene", 9);
              com.tencent.mm.br.c.b(this, "card", ".ui.CardDetailUI", localIntent);
              continue;
              localIntent.setClass(this, ProductFurtherInfoUI.class);
              localIntent.putExtra("key_Product_xml", this.OZG.field_xml);
              localIntent.putExtra("key_title", locala1.name);
              paramf = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
              com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramf.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramf = null;
              continue;
              paramf = locala1.OQP;
              localIntent.setClass(this, ProductPurchaseAreaUI.class);
              localIntent.putExtra("key_Product_xml", this.OZG.field_xml);
              localIntent.putExtra("referkey", locala1.OQP);
              localIntent.putExtra("key_Product_funcType", this.OZI);
              paramPreference = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
              com.tencent.mm.hellhoundlib.a.a.b(this, paramPreference.aYi(), "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramPreference.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              continue;
              paramPreference = locala1.link;
              paramf = paramPreference;
              if (!Util.isNullOrNil(locala1.link))
              {
                aVb(locala1.link);
                paramf = paramPreference;
                continue;
                paramf = null;
                continue;
                continue;
                label1271:
                paramf = null;
              }
            }
          }
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(51878);
    super.onResume();
    com.tencent.mm.kernel.h.aZW().a(1063, this);
    com.tencent.mm.kernel.h.aZW().a(1068, this);
    AppMethodBeat.o(51878);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(51892);
    if (paramp == null)
    {
      Log.w("MicroMsg.scanner.ProductUI", "scene == null");
      AppMethodBeat.o(51892);
      return;
    }
    if (paramp.getType() == 1063)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.scanner.ProductUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(51892);
        return;
      }
      paramString = (com.tencent.mm.plugin.scanner.model.r)paramp;
      if ((paramString.rr != null) && (c.c.b(paramString.rr.otC) != null)) {}
      for (paramString = (pr)c.c.b(paramString.rr.otC); paramString == null; paramString = null)
      {
        Log.w("MicroMsg.scanner.ProductUI", "onSceneEnd productInfo == null");
        AppMethodBeat.o(51892);
        return;
      }
      if (paramString.YTf != null)
      {
        Log.d("MicroMsg.scanner.ProductUI", "onSceneEnd  productInfo.DescXML != null");
        paramp = x.gI(paramString.YTf, this.OZI);
        if ((this.OZG != null) && (this.OZG.field_xml != null) && (paramp != null) && (paramp.field_xml != null) && (!this.OZG.field_xml.equals(paramp.field_xml)))
        {
          this.OZG = paramp;
          a(this.OZG);
        }
        for (;;)
        {
          if ((this.lzP != null) && (this.lzP.isShowing())) {
            this.lzP.dismiss();
          }
          gSC();
          if ((!this.OZR) || (this.EDF) || (TextUtils.isEmpty(this.xOk))) {
            break;
          }
          this.OZT.field_xmlContent = paramString.YTf;
          this.OZT.field_funcType = this.OZI;
          gSD();
          AppMethodBeat.o(51892);
          return;
          if ((paramp != null) && (paramp.field_xml != null))
          {
            this.OZG = paramp;
            a(this.OZG);
          }
        }
        Log.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.OZR + " mProductId:" + this.xOk + "  hasAddToHistory:" + this.EDF);
      }
      AppMethodBeat.o(51892);
      return;
    }
    if ((paramp.getType() == 1068) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((pp)c.c.b(((com.tencent.mm.plugin.scanner.model.q)paramp).rr.otC)).YTe;
      if ((this.OZG != null) && (y.c(this.OZG.PjJ, y.kh(paramString)))) {
        b(this.OZG);
      }
    }
    AppMethodBeat.o(51892);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
    implements com.tencent.mm.platformtools.p
  {
    private q.a OZG;
    
    public a(q.a parama)
    {
      this.OZG = parama;
    }
    
    public final Bitmap a(Bitmap paramBitmap, p.a parama, String paramString)
    {
      AppMethodBeat.i(51872);
      if (p.a.pAS == parama) {}
      try
      {
        BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, bTC(), false);
        AppMethodBeat.o(51872);
        return paramBitmap;
      }
      catch (IOException parama)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.scanner.ProductUI", parama, "", new Object[0]);
        }
      }
    }
    
    public final void a(p.a parama) {}
    
    public final p.b bTB()
    {
      return null;
    }
    
    public final String bTC()
    {
      AppMethodBeat.i(51871);
      String str = o.gPw().lG(this.OZG.field_thumburl, "@S");
      AppMethodBeat.o(51871);
      return str;
    }
    
    public final String bTD()
    {
      if (this.OZG == null) {
        return "";
      }
      return this.OZG.field_thumburl;
    }
    
    public final String bTE()
    {
      if (this.OZG == null) {
        return "";
      }
      return this.OZG.field_thumburl;
    }
    
    public final boolean bTF()
    {
      return false;
    }
    
    public final boolean bTG()
    {
      return false;
    }
    
    public final Bitmap bTH()
    {
      AppMethodBeat.i(51873);
      if (MMApplicationContext.getContext() == null)
      {
        AppMethodBeat.o(51873);
        return null;
      }
      Bitmap localBitmap = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), l.e.nosdcard_chatting_bg);
      AppMethodBeat.o(51873);
      return localBitmap;
    }
    
    public final void bTI() {}
    
    public final void bTJ() {}
    
    public final String getCacheKey()
    {
      if (this.OZG == null) {
        return "";
      }
      return this.OZG.field_thumburl;
    }
  }
  
  final class b
  {
    ProductScrollView Pac;
    boolean Pad;
    private ProductScrollView.a Pae;
    int mActionBarHeight;
    
    public b()
    {
      AppMethodBeat.i(51875);
      this.Pae = new ProductScrollView.a()
      {
        public final void dHa()
        {
          float f3 = 1.0F;
          AppMethodBeat.i(51874);
          ProductUI.b localb = ProductUI.b.this;
          int i = localb.Pac.getScrollY();
          float f1;
          label65:
          float f2;
          if (i < 0)
          {
            f1 = -1.0F;
            Log.v("MicroMsg.ProductUI.HeaderEffectHelper", "rate=".concat(String.valueOf(f1)));
            if (f1 != 1.0F) {
              break label211;
            }
            if (!localb.Pad)
            {
              localb.Pad = true;
              if (ProductUI.x(localb.OZW) != null)
              {
                float f4 = 1.0F - f1 - 0.2F;
                f2 = f4;
                if (f4 <= 0.0F) {
                  f2 = 0.0F;
                }
                if (f1 == 0.0F) {
                  f2 = 1.0F;
                }
                ProductUI.B(ProductUI.x(localb.OZW), f2);
              }
              if (ProductUI.y(localb.OZW) != null)
              {
                if (f1 != 0.0F) {
                  break label220;
                }
                f2 = 0.0F;
              }
            }
          }
          for (;;)
          {
            ProductUI.B(ProductUI.y(localb.OZW), f2);
            AppMethodBeat.o(51874);
            return;
            if ((i >= ProductUI.z(localb.OZW) - localb.mActionBarHeight) || (ProductUI.z(localb.OZW) == 0.0F))
            {
              f1 = 1.0F;
              break;
            }
            f1 = i * 1.37F / ProductUI.z(localb.OZW);
            break;
            label211:
            localb.Pad = false;
            break label65;
            label220:
            f2 = f3;
            if (f1 >= 0.0F)
            {
              f1 += 0.2F;
              f2 = f3;
              if (f1 <= 1.0F) {
                f2 = f1;
              }
            }
          }
        }
      };
      this.Pac = ((ProductScrollView)ProductUI.this.findViewById(l.f.OJi));
      this.Pac.setOnScrollListener(this.Pae);
      this.mActionBarHeight = ProductUI.w(ProductUI.this);
      AppMethodBeat.o(51875);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI
 * JD-Core Version:    0.7.0.1
 */