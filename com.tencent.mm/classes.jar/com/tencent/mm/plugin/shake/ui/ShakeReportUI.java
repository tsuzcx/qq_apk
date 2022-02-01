package com.tencent.mm.plugin.shake.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dz;
import com.tencent.mm.g.a.ea;
import com.tencent.mm.g.a.eg;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bs;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.c.a.f.a;
import com.tencent.mm.plugin.shake.d.a.h.a;
import com.tencent.mm.plugin.shake.d.a.j;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.y;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShakeReportUI
  extends MMActivity
  implements com.tencent.mm.model.av, u.a, l.a, f.a, k.a, n.b
{
  private static List<h.a> fjH;
  private com.tencent.mm.modelgeo.d fjC;
  private boolean fjF;
  private Map<String, h.a> fjG;
  private b.a fjJ;
  private ImageView fuj;
  private com.tencent.mm.aw.a.a hjj;
  private boolean imk;
  private boolean sVh;
  private com.tencent.mm.pluginsdk.j.d shakeSensor;
  private boolean woS;
  private boolean woT;
  private boolean woU;
  private boolean woV;
  private boolean woW;
  private boolean woX;
  private boolean woY;
  private int woZ;
  private ImageView wpA;
  private ImageView wpB;
  private ImageView wpC;
  private ImageView wpD;
  private ImageView wpE;
  private ImageView wpF;
  private TextView wpG;
  private int wpH;
  private int wpI;
  private View wpJ;
  private ImageView wpK;
  private ImageView wpL;
  private ImageView wpM;
  private ImageView wpN;
  private View wpO;
  private View wpP;
  private View wpQ;
  private View wpR;
  private View wpS;
  private int wpT;
  private com.tencent.mm.plugin.shake.c.b.a wpU;
  private boolean wpV;
  @SuppressLint({"UseSparseArrays"})
  private Map<Integer, Boolean> wpW;
  private boolean wpX;
  private boolean wpY;
  private boolean wpZ;
  private c wpa;
  private com.tencent.mm.plugin.shake.b.l wpb;
  private com.tencent.mm.pluginsdk.ui.f wpc;
  private View wpd;
  private View wpe;
  private TextView wpf;
  private TextView wpg;
  private TextView wph;
  private View wpi;
  private View wpj;
  private View wpk;
  private View wpl;
  private Animation wpm;
  private Animation wpn;
  private Animation wpo;
  private Animation wpp;
  private View wpq;
  private View wpr;
  private MMImageView wps;
  private TextView wpt;
  private ImageView wpu;
  private String wpv;
  private Bitmap wpw;
  private Dialog wpx;
  private ImageView wpy;
  private com.tencent.mm.plugin.shake.b.d wpz;
  private boolean wqa;
  private int wqb;
  private long wqc;
  private boolean wqd;
  private com.tencent.mm.sdk.b.c wqe;
  private com.tencent.mm.sdk.b.c wqf;
  private View.OnClickListener wqg;
  
  static
  {
    AppMethodBeat.i(28541);
    fjH = new CopyOnWriteArrayList();
    AppMethodBeat.o(28541);
  }
  
  public ShakeReportUI()
  {
    AppMethodBeat.i(28483);
    this.woS = false;
    this.woT = false;
    this.woV = false;
    this.woW = false;
    this.woX = false;
    this.woY = false;
    this.woZ = 22;
    this.wpb = new com.tencent.mm.plugin.shake.b.l();
    this.wpq = null;
    this.wpr = null;
    this.wps = null;
    this.wpt = null;
    this.wpu = null;
    this.wpv = "";
    this.wpw = null;
    this.wpy = null;
    this.hjj = null;
    this.wpz = null;
    this.wpH = 1;
    this.wpI = 0;
    this.wpS = null;
    this.wpT = 0;
    this.wpV = false;
    this.wpW = new HashMap();
    this.wpX = false;
    this.wpY = false;
    this.wpZ = false;
    this.wqa = false;
    this.wqb = 1;
    this.imk = true;
    this.fjF = false;
    this.fjJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(28446);
        if (paramAnonymousBoolean)
        {
          ad.d("MicroMsg.ShakeReportUI", "on location get ok");
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.Fhg, String.valueOf(paramAnonymousFloat2));
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.Fhh, String.valueOf(paramAnonymousFloat1));
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.FjM, String.valueOf(paramAnonymousDouble2));
          ShakeReportUI.a(ShakeReportUI.this);
          if (ShakeReportUI.b(ShakeReportUI.this) != null) {
            ShakeReportUI.b(ShakeReportUI.this).c(ShakeReportUI.c(ShakeReportUI.this));
          }
        }
        for (;;)
        {
          AppMethodBeat.o(28446);
          return false;
          if ((!ShakeReportUI.d(ShakeReportUI.this)) && (!com.tencent.mm.modelgeo.d.axU()))
          {
            ShakeReportUI.e(ShakeReportUI.this);
            com.tencent.mm.ui.base.h.a(ShakeReportUI.this, ShakeReportUI.this.getString(2131760082), ShakeReportUI.this.getString(2131755906), ShakeReportUI.this.getString(2131760598), ShakeReportUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(28445);
                com.tencent.mm.modelgeo.d.cv(ShakeReportUI.this);
                AppMethodBeat.o(28445);
              }
            }, null);
          }
          ad.w("MicroMsg.ShakeReportUI", "getLocation fail");
        }
      }
    };
    this.fjG = new ConcurrentHashMap();
    this.wqc = 0L;
    this.wqd = false;
    this.wqe = new com.tencent.mm.sdk.b.c() {};
    this.wqf = new com.tencent.mm.sdk.b.c() {};
    this.wqg = new View.OnClickListener()
    {
      public long wox = 0L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28467);
        if (bt.isNullOrNil((String)ShakeReportUI.r(ShakeReportUI.this).getTag()))
        {
          AppMethodBeat.o(28467);
          return;
        }
        if (ShakeReportUI.N(ShakeReportUI.this) == null)
        {
          AppMethodBeat.o(28467);
          return;
        }
        paramAnonymousView = ShakeReportUI.N(ShakeReportUI.this);
        Object localObject1 = paramAnonymousView.field_username;
        if (11 == paramAnonymousView.field_type)
        {
          if (System.currentTimeMillis() - this.wox > 3000L)
          {
            this.wox = System.currentTimeMillis();
            if ((paramAnonymousView.field_reserved3 == null) || (paramAnonymousView.field_reserved3.split(",").length != 3) || (paramAnonymousView.field_reserved3.split(",")[0] == null) || (paramAnonymousView.field_reserved3.split(",")[0].equals(""))) {
              break label259;
            }
            localObject1 = paramAnonymousView.field_reserved3.split(",");
            localObject2 = new uj();
            ((uj)localObject2).dzH.userName = localObject1[0];
            ((uj)localObject2).dzH.dzJ = bt.by(localObject1[1], "");
            ((uj)localObject2).dzH.dzK = bt.getInt(localObject1[2], 0);
            ((uj)localObject2).dzH.scene = 1077;
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
          }
          for (;;)
          {
            localObject1 = ShakeReportUI.E(ShakeReportUI.this).wlT;
            if ((localObject1 != null) && ((localObject1 instanceof com.tencent.mm.plugin.shake.d.a.h)))
            {
              com.tencent.mm.plugin.shake.d.a.h.a(paramAnonymousView);
              com.tencent.mm.plugin.shake.d.a.h.b(paramAnonymousView);
            }
            AppMethodBeat.o(28467);
            return;
            label259:
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("rawUrl", paramAnonymousView.getCity());
            ((Intent)localObject1).putExtra("scene", 27);
            ((Intent)localObject1).putExtra("stastic_scene", 5);
            com.tencent.mm.bs.d.b(aj.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          }
        }
        az.arV();
        Object localObject2 = com.tencent.mm.model.c.apM().aHY((String)localObject1);
        if (com.tencent.mm.n.b.ls(((au)localObject2).field_type))
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", (String)localObject1);
          paramAnonymousView.putExtra("Sns_from_Scene", 22);
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            if (((af)localObject2).eKB())
            {
              com.tencent.mm.plugin.report.service.h.vKh.kvStat(10298, (String)localObject1 + "," + ShakeReportUI.O(ShakeReportUI.this));
              paramAnonymousView.putExtra("Contact_Scene", ShakeReportUI.O(ShakeReportUI.this));
            }
            com.tencent.mm.plugin.shake.a.hYt.c(paramAnonymousView, ShakeReportUI.this);
          }
          AppMethodBeat.o(28467);
          return;
        }
        if ((paramAnonymousView.field_reserved1 & 0x8) > 0) {
          com.tencent.mm.plugin.report.service.h.vKh.kvStat(10298, paramAnonymousView.field_username + "," + ShakeReportUI.O(ShakeReportUI.this));
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Contact_User", paramAnonymousView.field_username);
        ((Intent)localObject1).putExtra("Contact_Nick", paramAnonymousView.field_nickname);
        ((Intent)localObject1).putExtra("Contact_Distance", paramAnonymousView.field_distance);
        ((Intent)localObject1).putExtra("Contact_Signature", paramAnonymousView.field_signature);
        ((Intent)localObject1).putExtra("Contact_Province", paramAnonymousView.getProvince());
        ((Intent)localObject1).putExtra("Contact_City", paramAnonymousView.getCity());
        ((Intent)localObject1).putExtra("Contact_Sex", paramAnonymousView.field_sex);
        ((Intent)localObject1).putExtra("Contact_IsLBSFriend", true);
        ((Intent)localObject1).putExtra("Contact_VUser_Info", paramAnonymousView.field_reserved3);
        ((Intent)localObject1).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.field_reserved1);
        ((Intent)localObject1).putExtra("Contact_KSnsIFlag", paramAnonymousView.field_snsFlag);
        ((Intent)localObject1).putExtra("Contact_KSnsBgUrl", paramAnonymousView.field_sns_bgurl);
        ((Intent)localObject1).putExtra("Contact_Scene", ShakeReportUI.O(ShakeReportUI.this));
        ((Intent)localObject1).putExtra("Sns_from_Scene", 22);
        com.tencent.mm.plugin.shake.a.hYt.c((Intent)localObject1, ShakeReportUI.this);
        AppMethodBeat.o(28467);
      }
    };
    AppMethodBeat.o(28483);
  }
  
  private void LQ(int paramInt)
  {
    AppMethodBeat.i(28503);
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      py(bool);
      if (paramInt != 2) {
        break;
      }
      px(true);
      AppMethodBeat.o(28503);
      return;
    }
    px(false);
    AppMethodBeat.o(28503);
  }
  
  private void a(com.tencent.mm.plugin.shake.c.a.e parame)
  {
    AppMethodBeat.i(28508);
    this.wpU = com.tencent.mm.plugin.shake.c.b.a.a(this, parame, new DialogInterface.OnCancelListener()new com.tencent.mm.plugin.shake.c.b.a.b
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(28465);
        paramAnonymousDialogInterface.dismiss();
        ShakeReportUI.b(ShakeReportUI.this, true);
        ShakeReportUI.L(ShakeReportUI.this);
        ShakeReportUI.M(ShakeReportUI.this).setText("");
        AppMethodBeat.o(28465);
      }
    }, new com.tencent.mm.plugin.shake.c.b.a.b()
    {
      public final void cWw()
      {
        AppMethodBeat.i(28466);
        ShakeReportUI.b(ShakeReportUI.this, true);
        ShakeReportUI.M(ShakeReportUI.this).setText("");
        AppMethodBeat.o(28466);
      }
    });
    AppMethodBeat.o(28508);
  }
  
  private void ank(String paramString)
  {
    AppMethodBeat.i(28505);
    this.woV = false;
    if (this.woU) {
      bd.az(getContext(), 2131763595);
    }
    if (this.wpp == null) {
      this.wpp = AnimationUtils.loadAnimation(getContext(), 2130772040);
    }
    LQ(2);
    if ((paramString != null) && (paramString.length() > 1)) {
      this.wpg.setText(paramString);
    }
    for (;;)
    {
      this.wpg.startAnimation(this.wpp);
      this.woY = true;
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28463);
          ShakeReportUI.K(ShakeReportUI.this);
          ShakeReportUI.d(ShakeReportUI.this, false);
          AppMethodBeat.o(28463);
        }
      }, this.wpp.getDuration());
      AppMethodBeat.o(28505);
      return;
      this.wpg.setText(2131763561);
    }
  }
  
  private void bs(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(28519);
    this.woV = false;
    if (this.wpp == null) {
      this.wpp = AnimationUtils.loadAnimation(getContext(), 2130772040);
    }
    LQ(2);
    px(true);
    if ((paramString != null) && (paramString.length() > 1)) {
      this.wpg.setText(paramString);
    }
    for (;;)
    {
      this.woY = true;
      AppMethodBeat.o(28519);
      return;
      if (paramBoolean)
      {
        this.wpg.setText(2131763551);
      }
      else
      {
        this.wpg.setText("");
        px(false);
      }
    }
  }
  
  private void c(com.tencent.mm.plugin.shake.b.d paramd)
  {
    AppMethodBeat.i(28513);
    if (bt.isNullOrNil(paramd.field_username))
    {
      AppMethodBeat.o(28513);
      return;
    }
    this.wpd.setTag(paramd.field_username);
    this.wpd.setVisibility(0);
    az.arV();
    af localaf = com.tencent.mm.model.c.apM().aHY(paramd.field_username);
    Object localObject2 = new StringBuilder().append(paramd.field_nickname);
    Object localObject1;
    label156:
    label212:
    label363:
    int i;
    if (com.tencent.mm.n.b.ls(localaf.field_type))
    {
      localObject1 = getString(2131763588);
      localObject2 = (String)localObject1;
      if (paramd.field_sex != 1) {
        break label500;
      }
      this.wpd.setContentDescription((String)localObject2 + paramd.field_distance + getContext().getString(2131763617));
      TextView localTextView = (TextView)this.wpd.findViewById(2131304689);
      AppCompatActivity localAppCompatActivity = getContext();
      StringBuilder localStringBuilder = new StringBuilder().append(paramd.field_nickname);
      if (!com.tencent.mm.n.b.ls(localaf.field_type)) {
        break label585;
      }
      localObject1 = getString(2131763588);
      localTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localAppCompatActivity, (String)localObject1, localTextView.getTextSize()));
      if (this.fuj != null)
      {
        if (bt.isNullOrNil((String)localObject2)) {
          break label591;
        }
        this.fuj.setContentDescription(String.format(getString(2131763543), new Object[] { localObject2 }));
      }
      label277:
      ((TextView)this.wpd.findViewById(2131304687)).setText(paramd.field_distance);
      com.tencent.mm.pluginsdk.ui.a.b.c((ImageView)this.wpd.findViewById(2131304688), paramd.field_username);
      localObject1 = (ImageView)this.wpd.findViewById(2131304691);
      if (paramd.field_reserved1 == 0) {
        break label608;
      }
      ((ImageView)localObject1).setVisibility(0);
      ((ImageView)localObject1).setImageBitmap(BackwardSupportUtil.b.n(ar.a.gMY.nd(paramd.field_reserved1), 2.0F));
      if ((paramd.field_reserved1 != 0) || (paramd.field_sex == 0)) {
        break label624;
      }
      if (paramd.field_sex != 1) {
        break label617;
      }
      i = 2131690323;
      label389:
      localObject1 = com.tencent.mm.cd.a.l(this, i);
      this.wpd.findViewById(2131304690).setVisibility(0);
      ((ImageView)this.wpd.findViewById(2131304690)).setImageDrawable((Drawable)localObject1);
    }
    for (;;)
    {
      if (paramd.getProvince() == null)
      {
        ad.e("MicroMsg.ShakeReportUI", "PROVINCE NULL");
        paramd.field_province = "";
      }
      if (paramd.getCity() == null)
      {
        ad.e("MicroMsg.ShakeReportUI", "CITY NULL");
        paramd.field_city = "";
      }
      this.wpd.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772129));
      AppMethodBeat.o(28513);
      return;
      localObject1 = "";
      break;
      label500:
      if (paramd.field_sex == 2)
      {
        this.wpd.setContentDescription((String)localObject2 + paramd.field_distance + getContext().getString(2131763616));
        break label156;
      }
      this.wpd.setContentDescription((String)localObject2 + paramd.field_distance);
      break label156;
      label585:
      localObject1 = "";
      break label212;
      label591:
      this.fuj.setContentDescription(getString(2131763544));
      break label277;
      label608:
      ((ImageView)localObject1).setVisibility(8);
      break label363;
      label617:
      i = 2131690322;
      break label389;
      label624:
      this.wpd.findViewById(2131304690).setVisibility(8);
    }
  }
  
  private void d(com.tencent.mm.plugin.shake.b.d paramd)
  {
    AppMethodBeat.i(28514);
    if (bt.isNullOrNil(paramd.field_username))
    {
      AppMethodBeat.o(28514);
      return;
    }
    this.wpd.setTag(paramd.field_username);
    ((TextView)this.wpd.findViewById(2131304689)).setText(paramd.field_username);
    this.wpd.setContentDescription(bt.nullAsNil(paramd.field_nickname));
    ((TextView)this.wpd.findViewById(2131304687)).setText(paramd.field_signature);
    this.hjj.loadImage(paramd.getProvince(), (ImageView)this.wpd.findViewById(2131304688));
    this.wpd.findViewById(2131304690).setVisibility(8);
    this.wpd.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772129));
    this.wpd.setVisibility(0);
    AppMethodBeat.o(28514);
  }
  
  private void dfj()
  {
    AppMethodBeat.i(28486);
    dpN();
    az.arV();
    com.tencent.mm.model.c.a(this);
    az.arV();
    com.tencent.mm.model.c.afk().a(this);
    com.tencent.mm.plugin.shake.b.m.dpb().add(this);
    if (this.wpb.wlT != null) {
      this.wpb.wlT.resume();
    }
    dpO();
    new ap().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28471);
        if (ShakeReportUI.f(ShakeReportUI.this) != null) {
          ShakeReportUI.f(ShakeReportUI.this).ewW();
        }
        AppMethodBeat.o(28471);
      }
    }, 1000L);
    if (this.shakeSensor != null) {
      this.shakeSensor.ewW();
    }
    px(false);
    py(false);
    dpQ();
    az.arV();
    Object localObject = (String)com.tencent.mm.model.c.afk().get(327696, "1");
    if (com.tencent.mm.plugin.shake.d.a.k.doZ())
    {
      if (this.wpH == 4) {
        pt(true);
      }
      if (((String)localObject).equals("4")) {
        en(findViewById(2131304719));
      }
    }
    boolean bool;
    if (((String)localObject).equals("3"))
    {
      en(findViewById(2131304716));
      bool = com.tencent.mm.z.c.adr().cJ(262154, 266258);
      if ((!getIntent().getBooleanExtra("shake_music", false)) || (!com.tencent.mm.az.e.azN()) || (this.wpb.wlS == 3)) {
        break label357;
      }
      getIntent().putExtra("shake_music", false);
      this.wpH = 3;
    }
    for (;;)
    {
      dpP();
      pu(true);
      ad.d("MicroMsg.ShakeReportUI", "isShakeGetConfigList = %s", new Object[] { Boolean.valueOf(com.tencent.mm.platformtools.ab.hVs) });
      if (com.tencent.mm.platformtools.ab.hVs)
      {
        localObject = new com.tencent.mm.bc.l(7);
        az.aeS().a((com.tencent.mm.al.n)localObject, 0);
      }
      dpZ();
      dpW();
      dpK();
      AppMethodBeat.o(28486);
      return;
      if ((!((String)localObject).equals("6")) || (!com.tencent.mm.plugin.shake.c.c.a.dpA())) {
        break;
      }
      en(findViewById(2131304706));
      break;
      label357:
      if ((getIntent().getBooleanExtra("shake_tv", false)) && (this.wpb.wlS != 4) && (com.tencent.mm.plugin.shake.d.a.k.doZ()))
      {
        getIntent().putExtra("shake_tv", false);
        this.wpH = 4;
      }
      else if ((this.wpb.wlS != 6) && (com.tencent.mm.plugin.shake.c.c.a.dpA()) && ((bool) || (getIntent().getBooleanExtra("shake_card", false))))
      {
        this.wpT = getIntent().getIntExtra("shake_card", 0);
        getIntent().putExtra("shake_card", false);
        ad.i("MicroMsg.ShakeReportUI", "onresume shake card tab is open, activity type is 0 or open from specialview");
        this.wpH = 6;
      }
    }
  }
  
  private void dpK()
  {
    AppMethodBeat.i(28489);
    if (!dpY())
    {
      AppMethodBeat.o(28489);
      return;
    }
    if (BluetoothAdapter.getDefaultAdapter() != null)
    {
      Object localObject = com.tencent.mm.m.g.Ze().YT();
      if (localObject != null)
      {
        this.wqc = System.currentTimeMillis();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          ad.i("MicroMsg.ShakeReportUI", "op=true,iBeacon = %s", new Object[] { str });
          dz localdz = new dz();
          localdz.dgt.dgv = str;
          localdz.dgt.dgs = true;
          com.tencent.mm.sdk.b.a.ESL.l(localdz);
        }
      }
    }
    AppMethodBeat.o(28489);
  }
  
  private void dpL()
  {
    AppMethodBeat.i(28490);
    az.arV();
    if (!bt.a((Boolean)com.tencent.mm.model.c.afk().get(ae.a.FjB, null), false))
    {
      this.fjG.clear();
      fjH = new CopyOnWriteArrayList();
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      Object localObject = com.tencent.mm.m.g.Ze().YT();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          dz localdz = new dz();
          ad.i("MicroMsg.ShakeReportUI", "op=false,iBeacon = %s", new Object[] { str });
          localdz.dgt.dgv = str;
          localdz.dgt.dgs = false;
          com.tencent.mm.sdk.b.a.ESL.l(localdz);
        }
      }
    }
    AppMethodBeat.o(28490);
  }
  
  private void dpM()
  {
    AppMethodBeat.i(28492);
    if (com.tencent.mm.az.e.azO())
    {
      az.arV();
      if (com.tencent.mm.model.c.afk().getInt(4118, 0) == 0)
      {
        com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(getContext());
        locala.aau(2131755906);
        locala.aay(2131763571);
        locala.aaB(2131763570).b(new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28447);
            if (ShakeReportUI.s(ShakeReportUI.this) != null) {
              ShakeReportUI.s(ShakeReportUI.this).cancel();
            }
            AppMethodBeat.o(28447);
          }
        });
        locala.wX(true);
        locala.e(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(28448);
            az.arV();
            com.tencent.mm.model.c.afk().setInt(4118, 1);
            ShakeReportUI.t(ShakeReportUI.this).setVisibility(8);
            AppMethodBeat.o(28448);
          }
        });
        this.wpx = locala.fft();
        this.wpx.show();
      }
    }
    AppMethodBeat.o(28492);
  }
  
  private void dpN()
  {
    AppMethodBeat.i(28493);
    az.arV();
    int j = bt.a((Integer)com.tencent.mm.model.c.afk().get(12290, null), 0);
    ImageView localImageView = (ImageView)findViewById(2131304700);
    if ((this.wpw != null) && (!this.wpw.isRecycled())) {
      this.wpw.recycle();
    }
    az.arV();
    Object localObject1;
    if (bt.k((Boolean)com.tencent.mm.model.c.afk().get(4110, null)))
    {
      localObject1 = new StringBuilder();
      az.arV();
      localObject1 = com.tencent.mm.model.c.apW() + "default_shake_img_filename.jpg";
      if (com.tencent.mm.vfs.i.eK((String)localObject1))
      {
        this.wpw = u.BA((String)localObject1);
        localImageView.setImageDrawable(new BitmapDrawable(this.wpw));
        localObject1 = (ImageView)findViewById(2131304686);
        localImageView = (ImageView)findViewById(2131304685);
        if (j != 2) {
          break label391;
        }
        i = 2131233994;
        label179:
        ((ImageView)localObject1).setImageResource(i);
        if (j != 2) {
          break label398;
        }
      }
    }
    label391:
    label398:
    for (int i = 2131233993;; i = 2131233992)
    {
      for (;;)
      {
        localImageView.setImageResource(i);
        View.OnClickListener local7 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(28455);
            if (!ShakeReportUI.u(ShakeReportUI.this))
            {
              AppMethodBeat.o(28455);
              return;
            }
            ShakeReportUI.b(ShakeReportUI.this, false);
            ShakeReportUI.c(ShakeReportUI.this, true);
            ShakeReportUI.d(ShakeReportUI.this, false);
            paramAnonymousView = ShakeReportUI.this.getContext();
            String str = ShakeReportUI.this.getString(2131763575);
            h.c local1 = new h.c()
            {
              public final void kM(int paramAnonymous2Int)
              {
                AppMethodBeat.i(28453);
                ShakeReportUI.b(ShakeReportUI.this, true);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(28453);
                  return;
                  com.tencent.mm.pluginsdk.ui.tools.q.c(ShakeReportUI.this, 1, null);
                }
              }
            };
            new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(28454);
                ShakeReportUI.b(ShakeReportUI.this, true);
                AppMethodBeat.o(28454);
              }
            };
            com.tencent.mm.ui.base.h.c(paramAnonymousView, null, new String[] { str }, "", local1);
            AppMethodBeat.o(28455);
          }
        };
        ((ImageView)localObject1).setOnClickListener(local7);
        localImageView.setOnClickListener(local7);
        if (this.wpk == null) {
          this.wpk = findViewById(2131304683);
        }
        this.wpk.setOnClickListener(local7);
        if (this.wpl == null) {
          this.wpl = findViewById(2131304684);
        }
        this.wpl.setOnClickListener(local7);
        AppMethodBeat.o(28493);
        return;
        try
        {
          localObject1 = new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.decodeStream(getContext().getAssets().open("resource/shakehideimg_man.jpg")));
          localImageView.setImageDrawable((Drawable)localObject1);
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ad.w("MicroMsg.ShakeReportUI", "Bg decode exp:" + localIOException.getLocalizedMessage());
            Object localObject2 = null;
          }
        }
      }
      az.arV();
      this.wpw = u.BA((String)com.tencent.mm.model.c.afk().get(4111, null));
      localImageView.setImageDrawable(new BitmapDrawable(this.wpw));
      break;
      i = 2131233995;
      break label179;
    }
  }
  
  private void dpO()
  {
    AppMethodBeat.i(28494);
    this.woX = true;
    if ((this.wpU != null) && (this.wpU.isShowing()) && (!this.wpU.wna)) {
      this.woX = false;
    }
    ad.i("MicroMsg.ShakeReportUI", "tryStartShake");
    if ((this.shakeSensor != null) && (!this.shakeSensor.ewV()))
    {
      this.shakeSensor.a(new a(this));
      if ((this.shakeSensor.ewX()) && (this.wpf != null))
      {
        this.wpf.setText(getString(2131763534));
        AppMethodBeat.o(28494);
        return;
      }
      this.wpf.setText(getString(2131763596));
    }
    AppMethodBeat.o(28494);
  }
  
  private void dpP()
  {
    AppMethodBeat.i(28496);
    if ((this.wpH == 3) && (com.tencent.mm.az.e.azN()))
    {
      this.wpH = 3;
      this.wph.setText(2131763612);
      this.wpy.setBackgroundResource(2131233978);
      this.wpA.setBackgroundResource(2131233984);
      this.wpB.setBackgroundResource(2131233983);
      this.wpC.setBackgroundResource(2131233987);
      this.wpD.setBackgroundResource(2131233974);
      findViewById(2131304701).setVisibility(0);
      setMMTitle(2131763608);
      com.tencent.mm.plugin.report.service.h.vKh.f(11720, new Object[] { Integer.valueOf(2) });
      com.tencent.mm.plugin.report.service.h.vKh.m(834L, 2L, 1L);
    }
    for (;;)
    {
      l.b localb = this.wpb.a(this, this.wpH, this);
      if (!this.woV) {
        py(false);
      }
      if ((com.tencent.mm.plugin.shake.c.c.a.dpA()) && ((localb instanceof com.tencent.mm.plugin.shake.c.a.g)))
      {
        ((com.tencent.mm.plugin.shake.c.a.g)localb).setFromScene(this.wpT);
        if (this.wpT == 3)
        {
          ad.i("MicroMsg.ShakeReportUI", "open shake card from specialview");
          ((com.tencent.mm.plugin.shake.c.a.g)localb).Sv(getIntent().getStringExtra("key_shake_card_ext_info"));
        }
      }
      AppMethodBeat.o(28496);
      return;
      if ((this.wpH == 4) && (com.tencent.mm.plugin.shake.d.a.k.doZ()))
      {
        this.wpH = 4;
        this.wph.setText(2131763613);
        this.wpy.setBackgroundResource(2131233978);
        this.wpA.setBackgroundResource(2131233984);
        this.wpB.setBackgroundResource(2131233981);
        this.wpC.setBackgroundResource(2131233989);
        this.wpD.setBackgroundResource(2131233974);
        findViewById(2131304701).setVisibility(0);
        setMMTitle(2131763609);
        com.tencent.mm.plugin.report.service.h.vKh.f(11720, new Object[] { Integer.valueOf(3) });
        com.tencent.mm.plugin.report.service.h.vKh.m(834L, 3L, 1L);
      }
      else if ((this.wpH == 5) && (dpX()))
      {
        this.wpH = 5;
        this.wph.setText(2131763611);
        this.wpy.setBackgroundResource(2131233980);
        this.wpA.setBackgroundResource(2131233984);
        this.wpB.setBackgroundResource(2131233981);
        this.wpC.setBackgroundResource(2131233987);
        this.wpD.setBackgroundResource(2131233974);
        findViewById(2131304701).setVisibility(0);
        setMMTitle(2131763607);
        com.tencent.mm.plugin.report.service.h.vKh.f(11720, new Object[] { Integer.valueOf(4) });
        com.tencent.mm.plugin.report.service.h.vKh.m(834L, 4L, 1L);
      }
      else if ((this.wpH == 6) && (com.tencent.mm.plugin.shake.c.c.a.dpA()))
      {
        this.wpH = 6;
        this.wph.setText(2131763610);
        this.wpy.setBackgroundResource(2131233978);
        this.wpA.setBackgroundResource(2131233984);
        this.wpB.setBackgroundResource(2131233981);
        this.wpC.setBackgroundResource(2131233987);
        this.wpD.setBackgroundResource(2131233975);
        findViewById(2131304701).setVisibility(0);
        setMMTitle(2131763606);
        dpS();
        dpV();
        com.tencent.mm.plugin.report.service.h.vKh.f(11720, new Object[] { Integer.valueOf(5) });
        com.tencent.mm.plugin.report.service.h.vKh.m(834L, 5L, 1L);
      }
      else
      {
        this.wpH = 1;
        this.wph.setText(2131763554);
        this.wpy.setBackgroundResource(2131233978);
        this.wpA.setBackgroundResource(2131233986);
        this.wpB.setBackgroundResource(2131233981);
        this.wpC.setBackgroundResource(2131233987);
        this.wpD.setBackgroundResource(2131233974);
        if (com.tencent.mm.az.e.azN()) {
          findViewById(2131304701).setVisibility(0);
        }
        setMMTitle(2131763605);
        com.tencent.mm.plugin.report.service.h.vKh.f(11720, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.h.vKh.m(834L, 1L, 1L);
      }
    }
  }
  
  private void dpQ()
  {
    AppMethodBeat.i(28497);
    az.arV();
    this.woU = bt.k((Boolean)com.tencent.mm.model.c.afk().get(4112, null));
    if (this.woU)
    {
      setTitleMuteIconVisibility(8);
      AppMethodBeat.o(28497);
      return;
    }
    setTitleMuteIconVisibility(0);
    AppMethodBeat.o(28497);
  }
  
  private void dpR()
  {
    AppMethodBeat.i(28517);
    if (com.tencent.mm.plugin.shake.c.c.a.dpA())
    {
      if (com.tencent.mm.z.c.adr().cJ(262155, 266259))
      {
        this.wpF.setVisibility(0);
        AppMethodBeat.o(28517);
        return;
      }
      this.wpF.setVisibility(8);
    }
    AppMethodBeat.o(28517);
  }
  
  private void dpS()
  {
    AppMethodBeat.i(28518);
    if ((this.wpH == 6) && (com.tencent.mm.plugin.shake.c.c.a.dpA()))
    {
      boolean bool1 = com.tencent.mm.z.c.adr().cJ(262154, 266258);
      boolean bool2 = com.tencent.mm.z.c.adr().cJ(262155, 266259);
      if (bool1)
      {
        bs(com.tencent.mm.plugin.shake.c.c.a.dpv(), true);
        AppMethodBeat.o(28518);
        return;
      }
      if (bool2)
      {
        bs(com.tencent.mm.plugin.shake.c.c.a.dpx(), true);
        AppMethodBeat.o(28518);
        return;
      }
      if (!this.wpV)
      {
        if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.dpt()))
        {
          bs(com.tencent.mm.plugin.shake.c.c.a.dpt(), true);
          AppMethodBeat.o(28518);
          return;
        }
        bs(getString(2131763551), true);
      }
    }
    AppMethodBeat.o(28518);
  }
  
  private void dpT()
  {
    AppMethodBeat.i(28520);
    if ((this.wpU != null) && (this.wpU.isShowing())) {
      this.wpU.dismiss();
    }
    this.wpU = null;
    AppMethodBeat.o(28520);
  }
  
  private void dpU()
  {
    int m = 1;
    AppMethodBeat.i(28521);
    boolean bool1 = com.tencent.mm.plugin.shake.c.c.a.doW();
    boolean bool2 = com.tencent.mm.z.c.adr().cJ(262154, 266258);
    boolean bool3 = com.tencent.mm.z.c.adr().cJ(262155, 266259);
    if (getIntent().getBooleanExtra("shake_card", false)) {}
    for (int i = getIntent().getIntExtra("shake_card", 0);; i = 0)
    {
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
      int j;
      if (bool2)
      {
        j = 1;
        if (!bool1) {
          break label231;
        }
        k = 1;
        label87:
        localh.f(11668, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), com.tencent.mm.plugin.shake.c.c.a.dpw(), Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.dps()) });
        localh = com.tencent.mm.plugin.report.service.h.vKh;
        if (!bool3) {
          break label236;
        }
        j = 1;
        label155:
        if (!bool1) {
          break label241;
        }
      }
      label231:
      label236:
      label241:
      for (int k = m;; k = 0)
      {
        localh.f(11668, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), com.tencent.mm.plugin.shake.c.c.a.dpw(), Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.dps()) });
        AppMethodBeat.o(28521);
        return;
        j = 0;
        break;
        k = 0;
        break label87;
        j = 0;
        break label155;
      }
    }
  }
  
  private void dpV()
  {
    AppMethodBeat.i(28522);
    if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.dpu())) {
      this.wpG.setText(com.tencent.mm.plugin.shake.c.c.a.dpu());
    }
    AppMethodBeat.o(28522);
  }
  
  private void dpW()
  {
    AppMethodBeat.i(28523);
    label123:
    Object localObject;
    label167:
    label208:
    int i;
    if (com.tencent.mm.az.e.azN())
    {
      ad.i("MicroMsg.ShakeReportUI", "is not oversea user, show shake music");
      this.wpW.put(Integer.valueOf(3), Boolean.TRUE);
      findViewById(2131304716).setVisibility(0);
      if (com.tencent.mm.az.e.azO())
      {
        az.arV();
        if (com.tencent.mm.model.c.afk().getInt(4118, 0) == 0) {
          this.wpE.setVisibility(0);
        }
      }
      else
      {
        if (!com.tencent.mm.plugin.shake.d.a.k.doZ()) {
          break label309;
        }
        this.wpW.put(Integer.valueOf(4), Boolean.TRUE);
        findViewById(2131304719).setVisibility(0);
        ad.i("MicroMsg.ShakeReportUI", "show shake tv tab");
        if (!com.tencent.mm.plugin.shake.c.c.a.dpA()) {
          break label350;
        }
        this.wpW.put(Integer.valueOf(6), Boolean.TRUE);
        findViewById(2131304706).setVisibility(0);
        ad.i("MicroMsg.ShakeReportUI", "show shake card tab");
        if (!dpX()) {
          break label392;
        }
        this.wpW.put(Integer.valueOf(5), Boolean.TRUE);
        this.wpS.setVisibility(0);
        ad.i("MicroMsg.ShakeReportUI", "[shakezb]show shake ibeacon tab");
        localObject = this.wpW.values().iterator();
        i = 0;
        label225:
        if (!((Iterator)localObject).hasNext()) {
          break label430;
        }
        if (!((Boolean)((Iterator)localObject).next()).booleanValue()) {
          break label567;
        }
        i += 1;
      }
    }
    label309:
    label567:
    for (;;)
    {
      break label225;
      this.wpE.setVisibility(8);
      break;
      this.wpW.put(Integer.valueOf(3), Boolean.FALSE);
      findViewById(2131304716).setVisibility(8);
      ad.i("MicroMsg.ShakeReportUI", "is oversea user, hide shake music");
      break;
      this.wpW.put(Integer.valueOf(4), Boolean.FALSE);
      findViewById(2131304719).setVisibility(8);
      ad.i("MicroMsg.ShakeReportUI", "hide shake tv tab");
      break label123;
      label350:
      findViewById(2131304706).setVisibility(8);
      this.wpW.put(Integer.valueOf(6), Boolean.FALSE);
      ad.i("MicroMsg.ShakeReportUI", "hide shake card tab");
      break label167;
      this.wpW.put(Integer.valueOf(5), Boolean.FALSE);
      this.wpS.setVisibility(8);
      ad.i("MicroMsg.ShakeReportUI", "[shakezb]hide shake ibeacon tab");
      break label208;
      this.wpI = i;
      localObject = (LinearLayout)findViewById(2131304701);
      if (i == 1) {
        ((LinearLayout)localObject).setVisibility(8);
      }
      while ((i > 4) && (this.wqd))
      {
        findViewById(2131304719).setVisibility(8);
        ad.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() > 0.");
        this.wpI -= 1;
        AppMethodBeat.o(28523);
        return;
        ((LinearLayout)localObject).setVisibility(0);
      }
      if ((i > 4) && (!this.wqd))
      {
        this.wpS.setVisibility(8);
        this.wpX = false;
        this.wpI -= 1;
        ad.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() <= 0.");
      }
      AppMethodBeat.o(28523);
      return;
    }
  }
  
  private boolean dpX()
  {
    AppMethodBeat.i(28524);
    ad.i("MicroMsg.ShakeReportUI", "[shakezb] isChineseAppLang :" + ac.eFq() + " ,getApplicationLanguage[en or zh_CN or zh_HK or zh_TW is avaliable] :" + ac.eFu());
    if ((this.wpX) && (dpY()))
    {
      AppMethodBeat.o(28524);
      return true;
    }
    AppMethodBeat.o(28524);
    return false;
  }
  
  private static boolean dpY()
  {
    AppMethodBeat.i(28525);
    if ((ac.eFq()) || (ac.eFu().equals("en")) || (ac.eFu().equals("ja")))
    {
      AppMethodBeat.o(28525);
      return true;
    }
    AppMethodBeat.o(28525);
    return false;
  }
  
  private void dpZ()
  {
    AppMethodBeat.i(28526);
    this.wpJ.setVisibility(8);
    AppMethodBeat.o(28526);
  }
  
  private void en(View paramView)
  {
    AppMethodBeat.i(28509);
    if (paramView == null)
    {
      AppMethodBeat.o(28509);
      return;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, "", "");
    ad.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this });
    if (!bool)
    {
      AppMethodBeat.o(28509);
      return;
    }
    bs("", false);
    if (paramView.getId() == 2131304710)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(11722, new Object[] { Integer.valueOf(1) });
      if (this.wpH != 1)
      {
        if (this.wpH == 4) {
          pt(false);
        }
        this.wpH = 1;
        dpP();
        pv(false);
        if (this.wpd != null) {
          this.wpd.setVisibility(8);
        }
      }
    }
    do
    {
      for (;;)
      {
        pu(true);
        py(false);
        dpZ();
        AppMethodBeat.o(28509);
        return;
        if (paramView.getId() == 2131304716)
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(11722, new Object[] { Integer.valueOf(2) });
          if ((!this.fjF) && (this.fjC != null)) {
            this.fjC.a(this.fjJ, true);
          }
          if ((!com.tencent.mm.r.a.ce(this)) && (!com.tencent.mm.r.a.cc(this)) && (this.wpH != 3))
          {
            if (this.wpH == 4) {
              pt(false);
            }
            this.wpH = 3;
            dpP();
            pv(false);
            if (this.wpd != null) {
              this.wpd.setVisibility(8);
            }
          }
          dpM();
        }
        else
        {
          if (paramView.getId() != 2131304719) {
            break;
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(11722, new Object[] { Integer.valueOf(3) });
          if ((!this.fjF) && (this.fjC != null)) {
            this.fjC.a(this.fjJ, true);
          }
          if ((!com.tencent.mm.r.a.ce(this)) && (!com.tencent.mm.r.a.cc(this)) && (this.wpH != 4))
          {
            pt(true);
            this.wpH = 4;
            dpP();
            pv(false);
            if (this.wpd != null) {
              this.wpd.setVisibility(8);
            }
          }
        }
      }
      if ((paramView.getId() != 2131304714) && (paramView.getId() != 2131304711)) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(11722, new Object[] { Integer.valueOf(4) });
    } while (this.wpH == 5);
    this.wpH = 5;
    dpP();
    pv(false);
    if (this.wpd != null) {
      this.wpd.setVisibility(8);
    }
    if ((!Build.VERSION.RELEASE.equals("6.0")) && (!Build.VERSION.RELEASE.equals("6.0.0")) && (Build.VERSION.SDK_INT >= 23))
    {
      paramView = (LocationManager)aj.getContext().getSystemService("location");
      if (paramView == null) {
        break label729;
      }
    }
    label729:
    for (bool = paramView.isProviderEnabled("gps");; bool = true)
    {
      if (!bool) {
        ank(getString(2131763565));
      }
      paramView = BluetoothAdapter.getDefaultAdapter();
      if ((paramView != null) && (paramView.getState() != 12))
      {
        ank(getString(2131763564));
        break;
      }
      if (paramView != null) {
        break;
      }
      ank(getString(2131763568));
      break;
      if (paramView.getId() != 2131304706) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(11722, new Object[] { Integer.valueOf(5) });
      if (this.wpH == 6) {
        break;
      }
      if (this.wpH == 4) {
        pt(false);
      }
      this.wpH = 6;
      dpP();
      pv(false);
      if (this.wpd != null) {
        this.wpd.setVisibility(8);
      }
      com.tencent.mm.z.c.adr().x(262155, false);
      this.wpF.setVisibility(8);
      break;
    }
  }
  
  private void pt(boolean paramBoolean)
  {
    AppMethodBeat.i(28495);
    String str = String.format("%1$s-shaketype-%2$d", new Object[] { getClass().getName(), Integer.valueOf(4) });
    ad.d("MicroMsg.ShakeReportUI", "activate change report , class name=" + str + ", isActive=" + paramBoolean);
    y.d(paramBoolean, new Intent().putExtra("classname", str));
    AppMethodBeat.o(28495);
  }
  
  private void pu(boolean paramBoolean)
  {
    AppMethodBeat.i(28498);
    pv(paramBoolean);
    pw(paramBoolean);
    AppMethodBeat.o(28498);
  }
  
  private void pv(boolean paramBoolean)
  {
    AppMethodBeat.i(28499);
    if (this.wpq == null) {
      this.wpq = findViewById(2131300604);
    }
    if ((this.wpb.wlS == 3) || (this.wpb.wlS == 4) || (this.wpb.wlS == 5) || (this.wpb.wlS == 6) || (!paramBoolean))
    {
      this.wpq.setVisibility(8);
      AppMethodBeat.o(28499);
      return;
    }
    int i = com.tencent.mm.bk.d.aCq().bIR();
    if (i <= 0)
    {
      this.wpq.setVisibility(8);
      AppMethodBeat.o(28499);
      return;
    }
    this.wpq.setVisibility(0);
    ((TextView)this.wpq.findViewById(2131304292)).setText(getResources().getQuantityString(2131623965, i, new Object[] { Integer.valueOf(i) }));
    this.wpq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28456);
        Object localObject = new Intent(ShakeReportUI.this, ShakeSayHiListUI.class);
        ((Intent)localObject).putExtra("IntentSayHiType", 1);
        paramAnonymousView = ShakeReportUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$16", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$16", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(28456);
      }
    });
    if (this.wpu == null) {
      this.wpu = ((ImageView)findViewById(2131302192));
    }
    bu localbu = com.tencent.mm.bk.d.aCq().eMZ();
    if (localbu != null)
    {
      this.wpv = localbu.field_sayhiuser;
      com.tencent.mm.pluginsdk.ui.a.b.c(this.wpu, this.wpv);
    }
    AppMethodBeat.o(28499);
  }
  
  private void pw(boolean paramBoolean)
  {
    AppMethodBeat.i(28500);
    if (this.wpr == null) {
      this.wpr = findViewById(2131300605);
    }
    if (!paramBoolean)
    {
      this.wpr.setVisibility(8);
      AppMethodBeat.o(28500);
      return;
    }
    int i = com.tencent.mm.plugin.shake.b.m.dpc().bIR();
    if (i <= 0)
    {
      this.wpr.setVisibility(8);
      AppMethodBeat.o(28500);
      return;
    }
    if (this.wpt == null) {
      this.wpt = ((TextView)this.wpr.findViewById(2131304692));
    }
    this.wpt.setText(getString(2131763589, new Object[] { Integer.valueOf(i) }));
    this.wpr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28457);
        Object localObject = new Intent(ShakeReportUI.this, ShakeMsgListUI.class);
        ((Intent)localObject).putExtra("shake_msg_from", 1);
        ((Intent)localObject).putExtra("shake_msg_list_title", ShakeReportUI.this.getString(2131763637));
        paramAnonymousView = ShakeReportUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$17", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$17", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(28457);
      }
    });
    if (this.wps == null) {
      this.wps = ((MMImageView)findViewById(2131304698));
    }
    Object localObject = com.tencent.mm.plugin.shake.b.m.dpc().doS();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.shake.b.f)localObject).field_thumburl;
      if (bt.isNullOrNil((String)localObject)) {
        break label255;
      }
      localObject = new com.tencent.mm.plugin.shake.e.b((String)localObject);
      Bitmap localBitmap = u.a((s)localObject);
      this.wps.setTag(((com.tencent.mm.plugin.shake.e.b)localObject).aGA());
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        break label242;
      }
      this.wps.setImageBitmap(localBitmap);
    }
    for (;;)
    {
      this.wpr.setVisibility(0);
      AppMethodBeat.o(28500);
      return;
      label242:
      this.wps.setImageResource(2131689584);
      continue;
      label255:
      this.wps.setImageResource(2131689584);
    }
  }
  
  private void px(boolean paramBoolean)
  {
    AppMethodBeat.i(28501);
    if (this.wpg != null)
    {
      if (paramBoolean)
      {
        this.wpg.setVisibility(0);
        AppMethodBeat.o(28501);
        return;
      }
      this.wpg.setVisibility(8);
      this.wpg.cancelLongPress();
    }
    AppMethodBeat.o(28501);
  }
  
  private void py(boolean paramBoolean)
  {
    AppMethodBeat.i(28502);
    if (this.wpe != null)
    {
      if (paramBoolean)
      {
        this.wpe.setVisibility(0);
        AppMethodBeat.o(28502);
        return;
      }
      this.wpe.setVisibility(4);
    }
    AppMethodBeat.o(28502);
  }
  
  public final void a(int paramInt, final com.tencent.mm.plugin.shake.c.a.e parame, long paramLong)
  {
    AppMethodBeat.i(28507);
    this.wpV = true;
    if (paramInt == 1251)
    {
      if (parame == null)
      {
        AppMethodBeat.o(28507);
        return;
      }
      ad.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_GetLbsCard");
      com.tencent.mm.plugin.shake.c.c.a.doV();
      dpW();
      dpR();
      dpU();
      this.wpT = 4;
      com.tencent.mm.plugin.shake.b.m.dph().putValue("key_shake_card_item", parame);
      AppMethodBeat.o(28507);
      return;
    }
    Object localObject;
    if (paramInt == 1250)
    {
      if (parame == null)
      {
        this.wpz = null;
        ank(null);
        AppMethodBeat.o(28507);
        return;
      }
      if (((parame == null) || (this.woV)) && (!this.woV))
      {
        this.wpz = null;
        ank(null);
        AppMethodBeat.o(28507);
        return;
      }
      this.woV = false;
      ad.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_ShakeCard");
      if (this.wpb.wlS == 6)
      {
        localObject = this.wpb.wlT;
        if ((localObject != null) && ((localObject instanceof com.tencent.mm.plugin.shake.c.a.g)))
        {
          localObject = (com.tencent.mm.plugin.shake.c.a.g)localObject;
          switch ((int)paramLong)
          {
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(28507);
      return;
      ad.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_OK");
      if (((com.tencent.mm.plugin.shake.c.a.g)localObject).ntg == 3)
      {
        ad.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is  MMBIZ_SHAKE_CARD_ACTION_TYPE_NO_CARD");
        if ((parame != null) && (!TextUtils.isEmpty(parame.wmv)))
        {
          ank(parame.wmv);
          AppMethodBeat.o(28507);
          return;
        }
        ank(getString(2131763550));
        AppMethodBeat.o(28507);
        return;
      }
      ad.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is " + ((com.tencent.mm.plugin.shake.c.a.g)localObject).ntg);
      LQ(3);
      if (parame.ntg == 1) {
        this.woX = false;
      }
      if ((this.wpU != null) && (this.wpU.isShowing()))
      {
        AppMethodBeat.o(28507);
        return;
      }
      if (parame.wmx)
      {
        localObject = (ViewStub)findViewById(2131306441);
        if (localObject != null) {
          ((ViewStub)localObject).inflate();
        }
        ((ShakeEggAnimFrame)findViewById(2131297976)).ay(this);
        new ap().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28464);
            ShakeReportUI.a(ShakeReportUI.this, parame);
            AppMethodBeat.o(28464);
          }
        }, 1000L);
        AppMethodBeat.o(28507);
        return;
      }
      a(parame);
      AppMethodBeat.o(28507);
      return;
      ad.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_ERR_REPORT");
      ank(getString(2131763550));
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(28512);
    a("", null);
    AppMethodBeat.o(28512);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(28511);
    dpQ();
    if (!this.woW) {
      pu(true);
    }
    AppMethodBeat.o(28511);
  }
  
  public final void arM()
  {
    AppMethodBeat.i(28504);
    dpP();
    AppMethodBeat.o(28504);
  }
  
  public final void c(List<com.tencent.mm.plugin.shake.b.d> paramList, long paramLong)
  {
    AppMethodBeat.i(28506);
    dpZ();
    if ((paramList == null) || (!this.woV) || (paramLong == 6L))
    {
      this.wpz = null;
      if (paramLong == 6L)
      {
        ank(getString(2131763569));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 7L)
      {
        ank(getString(2131763567));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 8L)
      {
        ank(getString(2131763565));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 9L)
      {
        ank(getString(2131763564));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 10L)
      {
        ank(getString(2131763568));
        AppMethodBeat.o(28506);
        return;
      }
      ank(null);
      AppMethodBeat.o(28506);
      return;
    }
    this.woV = false;
    if (paramList.size() > 0) {
      this.wpz = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0));
    }
    int i;
    Object localObject;
    if (this.wpb.wlS == 1)
    {
      if ((paramList.size() > 0) && (((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_type != 0))
      {
        ank(null);
        AppMethodBeat.o(28506);
        return;
      }
      this.woZ = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).scene;
      i = paramList.size();
      if (i == 0)
      {
        ank(null);
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        localObject = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_username;
        String str = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_nickname;
        ad.i("MicroMsg.ShakeReportUI", "1 u:" + (String)localObject + " n:" + str + " d:" + ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_distance);
        if (this.woU) {
          bd.az(getContext(), 2131763587);
        }
        LQ(3);
        c((com.tencent.mm.plugin.shake.b.d)paramList.get(0));
        AppMethodBeat.o(28506);
        return;
      }
      if (this.woU) {
        bd.az(getContext(), 2131763587);
      }
      LQ(3);
      pv(false);
      paramList = new Intent(this, ShakeItemListUI.class);
      paramList.putExtra("_key_show_type_", -1);
      paramList.putExtra("_key_title_", getString(2131763582));
      paramList = new com.tencent.mm.hellhoundlib.b.a().bd(paramList);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramList.adn(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramList.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(28506);
      return;
    }
    if (this.wpb.wlS == 3)
    {
      i = paramList.size();
      if (i == 0)
      {
        ank(getString(2131763594));
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        if (this.woU) {
          bd.az(getContext(), 2131763587);
        }
        LQ(3);
        if (((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_type == 4)
        {
          paramList = com.tencent.mm.plugin.shake.d.a.i.d(((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_lvbuffer, paramLong);
          com.tencent.mm.az.a.d(paramList);
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_mode", 1);
          ((Intent)localObject).putExtra("key_offset", paramList.hnq);
          ((Intent)localObject).putExtra("music_player_beg_time", paramList.hnI);
          ((Intent)localObject).putExtra("key_scene", 3);
          if (com.tencent.mm.az.e.azO()) {
            ((Intent)localObject).putExtra("KGlobalShakeMusic", true);
          }
          com.tencent.mm.bs.d.b(this, "music", ".ui.MusicMainUI", (Intent)localObject);
          AppMethodBeat.o(28506);
          return;
        }
        ad.w("MicroMsg.ShakeReportUI", "Unexpected type, ignore.");
      }
      AppMethodBeat.o(28506);
      return;
    }
    if (this.wpb.wlS == 4)
    {
      dpZ();
      i = paramList.size();
      if (i == 0)
      {
        ank(getString(2131763638));
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        if (this.woU) {
          bd.az(getContext(), 2131763587);
        }
        LQ(3);
        com.tencent.mm.plugin.shake.d.a.k.a((com.tencent.mm.plugin.shake.b.d)paramList.get(0), this);
      }
      AppMethodBeat.o(28506);
      return;
    }
    if (this.wpb.wlS == 5) {
      switch ((int)paramLong)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(28506);
      return;
      if ((!paramList.isEmpty()) && (((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_type == 11))
      {
        if (paramList.size() == 1)
        {
          if (this.woU) {
            bd.az(getContext(), 2131763587);
          }
          LQ(3);
          d((com.tencent.mm.plugin.shake.b.d)paramList.get(0));
          AppMethodBeat.o(28506);
          return;
        }
        if (this.woU) {
          bd.az(getContext(), 2131763587);
        }
        LQ(3);
        pv(false);
        localObject = new Intent(this, ShakeItemListUI.class);
        ((Intent)localObject).putExtra("_key_show_type_", -12);
        ((Intent)localObject).putExtra("_key_title_", getString(2131763580));
        ((Intent)localObject).putExtra("_key_show_from_shake_", true);
        ((Intent)localObject).putExtra("_ibeacon_new_insert_size", paramList.size());
        paramList = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramList.adn(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramList.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(28506);
        return;
      }
      ank(null);
      AppMethodBeat.o(28506);
      return;
      ank(getString(2131763569));
    }
  }
  
  public final void dpk()
  {
    AppMethodBeat.i(28516);
    com.tencent.mm.plugin.shake.c.c.a.doV();
    dpR();
    dpS();
    dpV();
    dpW();
    dpU();
    AppMethodBeat.o(28516);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495420;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28491);
    com.tencent.mm.plugin.shake.c.c.a.doV();
    this.wpW.put(Integer.valueOf(1), Boolean.TRUE);
    this.wpW.put(Integer.valueOf(3), Boolean.FALSE);
    this.wpW.put(Integer.valueOf(4), Boolean.FALSE);
    this.wpW.put(Integer.valueOf(5), Boolean.FALSE);
    this.wpW.put(Integer.valueOf(6), Boolean.FALSE);
    this.hjj = new com.tencent.mm.aw.a.a(this);
    this.wpf = ((TextView)findViewById(2131304704));
    this.wpe = findViewById(2131304720);
    this.wpg = ((TextView)findViewById(2131304699));
    this.wph = ((TextView)findViewById(2131304703));
    this.wpJ = findViewById(2131304734);
    this.wpK = ((ImageView)findViewById(2131304722));
    this.wpL = ((ImageView)findViewById(2131304724));
    this.wpM = ((ImageView)findViewById(2131304726));
    this.wpN = ((ImageView)findViewById(2131304728));
    this.wpO = findViewById(2131304723);
    this.wpP = findViewById(2131304725);
    this.wpQ = findViewById(2131304727);
    this.wpR = findViewById(2131304729);
    this.wpd = findViewById(2131304702);
    this.wpd.setOnClickListener(this.wqg);
    this.fuj = ((ImageView)this.wpd.findViewById(2131304688));
    this.fuj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28477);
        if (ShakeReportUI.q(ShakeReportUI.this) != 5)
        {
          Object localObject = new Intent(ShakeReportUI.this.getContext(), ProfileHdHeadImg.class);
          ((Intent)localObject).putExtra("username", (String)ShakeReportUI.r(ShakeReportUI.this).getTag());
          paramAnonymousView = ShakeReportUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(28477);
      }
    });
    dpN();
    Object localObject = View.inflate(getContext(), 2131495416, null);
    this.wpx = new com.tencent.mm.ui.base.i(getContext(), 2131821723);
    this.wpx.setContentView((View)localObject);
    this.wpx.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(28450);
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
        {
          public final boolean queueIdle()
          {
            AppMethodBeat.i(28449);
            t.m(ShakeReportUI.this, ShakeReportUI.this.getString(2131763614));
            az.arV();
            com.tencent.mm.model.c.afk().set(4117, Boolean.TRUE);
            AppMethodBeat.o(28449);
            return false;
          }
        });
        AppMethodBeat.o(28450);
      }
    });
    ((Button)((View)localObject).findViewById(2131304679)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28451);
        ShakeReportUI.s(ShakeReportUI.this).cancel();
        AppMethodBeat.o(28451);
      }
    });
    az.arV();
    boolean bool1 = bt.l((Boolean)com.tencent.mm.model.c.afk().get(4108, null));
    az.arV();
    boolean bool2 = bt.l((Boolean)com.tencent.mm.model.c.afk().get(4117, null));
    if (!bool1)
    {
      ((View)localObject).setVisibility(0);
      this.wpx.show();
      az.arV();
      com.tencent.mm.model.c.afk().set(4108, Boolean.TRUE);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(28478);
          ShakeReportUI.a(ShakeReportUI.this, false);
          ShakeReportUI.this.finish();
          AppMethodBeat.o(28478);
          return true;
        }
      });
      addIconOptionMenu(0, 2131755135, 2131689511, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(28479);
          ShakeReportUI.a(ShakeReportUI.this, false);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.setClass(ShakeReportUI.this, ShakePersonalInfoUI.class);
          ShakeReportUI.this.startActivityForResult(paramAnonymousMenuItem, 3);
          AppMethodBeat.o(28479);
          return true;
        }
      });
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(28480);
          ShakeReportUI.a(ShakeReportUI.this, paramAnonymousView);
          AppMethodBeat.o(28480);
        }
      };
      if ((!this.wqa) && (!this.wpY)) {
        break label772;
      }
    }
    label772:
    for (this.wpy = ((ImageView)findViewById(2131304713));; this.wpy = ((ImageView)findViewById(2131304712)))
    {
      this.wpA = ((ImageView)findViewById(2131304709));
      this.wpB = ((ImageView)findViewById(2131304715));
      this.wpC = ((ImageView)findViewById(2131304718));
      this.wpD = ((ImageView)findViewById(2131304705));
      this.wpG = ((TextView)findViewById(2131304708));
      this.wpF = ((ImageView)findViewById(2131304707));
      this.wpE = ((ImageView)findViewById(2131304717));
      dpV();
      this.wpS.setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304714).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304710).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304716).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304719).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304706).setOnClickListener((View.OnClickListener)localObject);
      com.tencent.mm.sdk.b.a.ESL.c(this.wqe);
      com.tencent.mm.sdk.b.a.ESL.c(this.wqf);
      dpR();
      dpU();
      dpZ();
      AppMethodBeat.o(28491);
      return;
      if (bool2) {
        break;
      }
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(28452);
          t.m(ShakeReportUI.this, ShakeReportUI.this.getString(2131763614));
          az.arV();
          com.tencent.mm.model.c.afk().set(4117, Boolean.TRUE);
          AppMethodBeat.o(28452);
          return false;
        }
      });
      break;
    }
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(28515);
    if ((paramString == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(28515);
      return;
    }
    if ((this.wps != null) && (this.wps.getTag() != null) && (paramString.equals((String)this.wps.getTag()))) {
      this.wps.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(28515);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(28510);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(28510);
      return;
    case 1: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(28510);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("CropImageMode", 4);
      localIntent.putExtra("CropImage_Filter", true);
      localIntent.putExtra("CropImage_DirectlyIntoFilter", true);
      StringBuilder localStringBuilder = new StringBuilder();
      az.arV();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.model.c.apW() + "custom_shake_img_filename.jpg");
      com.tencent.mm.plugin.shake.a.hYt.a(localIntent, 2, this, paramIntent);
      AppMethodBeat.o(28510);
      return;
    case 2: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(28510);
        return;
      }
      paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
      az.arV();
      com.tencent.mm.model.c.afk().set(4110, Boolean.FALSE);
      az.arV();
      com.tencent.mm.model.c.afk().set(4111, paramIntent);
      dpN();
      AppMethodBeat.o(28510);
      return;
    }
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
      {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtT, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
        this.imk = false;
        AppMethodBeat.o(28510);
        return;
      }
      this.imk = true;
      finish();
      AppMethodBeat.o(28510);
      return;
    }
    this.imk = true;
    finish();
    AppMethodBeat.o(28510);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28484);
    super.onCreate(paramBundle);
    setMMTitle(2131763605);
    setActionbarColor(getResources().getColor(2131100196));
    setNavigationbarColor(getResources().getColor(2131100196));
    hideActionbarLine();
    this.fjC = com.tencent.mm.modelgeo.d.axT();
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.Fhg, "");
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.Fhh, "");
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FjM, "");
    this.wpS = findViewById(2131304711);
    paramBundle = bs.asB();
    Object localObject1 = bt.nullAsNil(paramBundle.provinceCode);
    Object localObject2 = bt.nullAsNil(paramBundle.cityCode);
    paramBundle = com.tencent.mm.m.g.Ze().ad("IBeacon", "GatedLaunch");
    int i;
    int j;
    if (!bt.isNullOrNil(paramBundle))
    {
      this.wpY = false;
      this.wpZ = false;
      if (paramBundle != null) {}
      try
      {
        paramBundle = new JSONObject(paramBundle);
        i = paramBundle.getInt("gatedlaunch");
        az.afw();
        if (i == 0) {
          break label493;
        }
        if (i != 1) {
          break label331;
        }
        paramBundle = paramBundle.getJSONArray("citylist");
        k = paramBundle.length();
        i = 0;
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          try
          {
            int k;
            String str;
            int m;
            label303:
            label331:
            label352:
            ((com.tencent.mm.plugin.shake.b.d)localObject2).field_lvbuffer = (String.valueOf(localObject1[4]) + "," + String.valueOf(localObject1[5]) + "," + String.valueOf(localObject1[6])).getBytes("utf-8");
            ((com.tencent.mm.plugin.shake.b.d)localObject2).field_insertBatch = 2;
            Object localObject3 = com.tencent.mm.plugin.shake.b.m.dpb();
            ((com.tencent.mm.plugin.shake.b.e)localObject3).doR();
            ((com.tencent.mm.plugin.shake.b.e)localObject3).a((com.tencent.mm.plugin.shake.b.d)localObject2, true);
            localObject3 = new LinkedList();
            ((List)localObject3).add(localObject2);
            c((List)localObject3, 1L);
            az.arV();
            com.tencent.mm.model.c.afk().set(ae.a.Fjx, "");
            paramBundle = paramBundle + "," + localObject1[4] + localObject1[5] + localObject1[6];
            az.arV();
            com.tencent.mm.model.c.afk().set(ae.a.Fjy, paramBundle);
            this.wpa = new c(getBodyView());
            this.shakeSensor = new com.tencent.mm.pluginsdk.j.d();
            if (!this.shakeSensor.ewX()) {
              com.tencent.mm.ui.base.h.a(this, 2131763596, 2131755906, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(28461);
                  ShakeReportUI.this.finish();
                  AppMethodBeat.o(28461);
                }
              });
            }
            if (com.tencent.mm.plugin.shake.a.hYu != null) {
              com.tencent.mm.plugin.shake.a.hYu.Ll();
            }
            u.b(this);
            ad.i("MicroMsg.ShakeReportUI", "%s", new Object[] { getResources().getDisplayMetrics().toString() });
            i = com.tencent.mm.plugin.shake.b.m.dpc().bIR();
            com.tencent.mm.plugin.report.service.h.vKh.f(11317, new Object[] { Integer.valueOf(i), e.dqb() });
            com.tencent.mm.plugin.report.service.h.vKh.f(11710, new Object[] { Integer.valueOf(1) });
            com.tencent.mm.plugin.report.service.h.vKh.m(834L, 0L, 1L);
            AppMethodBeat.o(28484);
            return;
            if (i != 4) {
              continue;
            }
            this.wpY = true;
            this.wpZ = true;
            continue;
            paramBundle = paramBundle;
            ad.e("MicroMsg.ShakeReportUI", "[shakezb]parse dymanic setting json fail!!");
            this.wpY = false;
            this.wpZ = false;
            continue;
            this.wqb = 1;
            continue;
            com.tencent.mm.plugin.report.service.h.vKh.f(13139, new Object[] { localObject1, localObject2, Integer.valueOf(0), Integer.valueOf(this.wqb), Integer.valueOf(i), Integer.valueOf(j) });
            continue;
            if (paramBundle == null) {
              continue;
            }
            paramBundle.getState();
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            ad.e("MicroMsg.ShakeReportUI", "[kevinkma]parst shakeItem error!");
            continue;
          }
          initView();
          continue;
          j = 0;
          continue;
          i = 0;
          continue;
          i += 1;
        }
      }
      if (i < k)
      {
        localObject3 = paramBundle.getJSONObject(i);
        str = ((JSONObject)localObject3).getString("province");
        j = ((JSONObject)localObject3).getInt("allgatedlaunch");
        if ((str.equals(localObject1)) && (j == 1))
        {
          this.wpY = true;
          break label1559;
        }
        if ((!str.equals(localObject1)) || (j != 0)) {
          break label1559;
        }
        localObject3 = ((JSONObject)localObject3).getJSONArray("cities");
        m = ((JSONArray)localObject3).length();
        j = 0;
        if (j >= m) {
          break label1559;
        }
        if (!((JSONArray)localObject3).getString(j).equals(localObject2)) {
          break label1571;
        }
        this.wpY = true;
        break label1571;
        if (i == 2)
        {
          paramBundle = paramBundle.getJSONArray("citylist");
          k = paramBundle.length();
          i = 0;
          if (i >= k) {
            break label493;
          }
          localObject3 = paramBundle.getJSONObject(i);
          str = ((JSONObject)localObject3).getString("province");
          j = ((JSONObject)localObject3).getInt("allgatedlaunch");
          if ((str.equals(localObject1)) && (j == 1))
          {
            this.wpZ = true;
            this.wpY = true;
            break label1578;
          }
          if ((!str.equals(localObject1)) || (j != 0)) {
            break label1578;
          }
          localObject3 = ((JSONObject)localObject3).getJSONArray("cities");
          m = ((JSONArray)localObject3).length();
          j = 0;
        }
      }
    }
    for (;;)
    {
      if (j < m)
      {
        if (!((JSONArray)localObject3).getString(j).equals(localObject2)) {
          break label1585;
        }
        this.wpZ = true;
        this.wpY = true;
        break label1585;
        if (i == 3)
        {
          this.wpY = true;
          this.wpZ = false;
          label493:
          if (az.afw())
          {
            az.arV();
            if (((Integer)com.tencent.mm.model.c.afk().get(ae.a.FjE, Integer.valueOf(0))).intValue() == 1) {
              this.wqa = true;
            }
          }
          paramBundle = BluetoothAdapter.getDefaultAdapter();
          boolean bool = aj.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
          if ((paramBundle == null) || (!bool) || (Build.VERSION.SDK_INT < 18) || (paramBundle.getState() != 12)) {
            break label1450;
          }
          this.wqb = 0;
          if ((paramBundle == null) || (paramBundle.getState() != 12)) {
            break label1554;
          }
          i = 1;
          if (!bool) {
            break label1549;
          }
          j = 1;
          if (!this.wpY) {
            break label1458;
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(13139, new Object[] { localObject1, localObject2, Integer.valueOf(1), Integer.valueOf(this.wqb), Integer.valueOf(i), Integer.valueOf(j) });
          if ((this.wqa) || (this.wpY))
          {
            this.wpX = true;
            this.wpS = findViewById(2131304714);
            if (this.wpZ)
            {
              if ((paramBundle != null) && (paramBundle.getState() == 12)) {
                break label1516;
              }
              this.wpX = false;
            }
          }
          paramBundle = com.tencent.mm.plugin.shake.b.m.dpg();
          if (paramBundle.nqa == null) {
            paramBundle.nqa = new ArrayList();
          }
          paramBundle.nqa.add(new WeakReference(this));
          paramBundle = Boolean.FALSE;
          long l3 = bt.aGK();
          long l2 = 0L;
          long l1 = 0L;
          if (az.afw())
          {
            az.arV();
            com.tencent.mm.model.c.afk().set(ae.a.FjB, Boolean.TRUE);
            az.arV();
            bool = bt.a((Boolean)com.tencent.mm.model.c.afk().get(ae.a.Fjz, null), false);
            az.arV();
            l2 = bt.a((Long)com.tencent.mm.model.c.afk().get(ae.a.FjA, null), 0L);
            az.arV();
            l1 = bt.a((Long)com.tencent.mm.model.c.afk().get(ae.a.Fju, null), 0L);
            paramBundle = Boolean.valueOf(bool);
          }
          if ((!paramBundle.booleanValue()) || (l3 - l2 >= l1)) {
            break label1542;
          }
          this.wpH = 5;
          this.wpX = true;
          this.woV = true;
          initView();
          dpP();
          az.arV();
          paramBundle = bt.by((String)com.tencent.mm.model.c.afk().get(ae.a.Fjy, null), "");
          az.arV();
          localObject1 = bt.by((String)com.tencent.mm.model.c.afk().get(ae.a.Fjx, null), "");
          if ((localObject1 != null) && (!((String)localObject1).equals("")))
          {
            localObject1 = ((String)localObject1).split(",");
            localObject2 = new com.tencent.mm.plugin.shake.b.d();
            ((com.tencent.mm.plugin.shake.b.d)localObject2).field_type = 11;
            ((com.tencent.mm.plugin.shake.b.d)localObject2).field_username = localObject1[0];
            ((com.tencent.mm.plugin.shake.b.d)localObject2).field_nickname = localObject1[0];
            ((com.tencent.mm.plugin.shake.b.d)localObject2).field_signature = localObject1[1];
            ((com.tencent.mm.plugin.shake.b.d)localObject2).field_province = localObject1[2];
            ((com.tencent.mm.plugin.shake.b.d)localObject2).field_city = localObject1[3];
            ((com.tencent.mm.plugin.shake.b.d)localObject2).field_sex = 1;
          }
        }
        label1450:
        label1458:
        label1516:
        paramBundle = null;
        label1542:
        label1549:
        label1554:
        label1559:
        break;
        label1571:
        j += 1;
        break label303;
      }
      label1578:
      i += 1;
      break label352;
      label1585:
      j += 1;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28488);
    if ((this.wpw != null) && (!this.wpw.isRecycled())) {
      this.wpw.recycle();
    }
    if ((this.wpx != null) && (this.wpx.isShowing()))
    {
      this.wpx.dismiss();
      this.wpx = null;
    }
    if (this.wpb.wlT != null) {
      this.wpb.wlT.doF();
    }
    if (this.shakeSensor != null)
    {
      this.shakeSensor.bQk();
      this.shakeSensor = null;
    }
    Object localObject = j.a(null);
    if (j.hBC)
    {
      j.hBC = false;
      if (!((j)localObject).wnU.dpC()) {
        ad.e("Micromsg.ShakeMusicMgr", "release MusicFingerPrintRecorder error");
      }
    }
    j.wnV = null;
    u.c(this);
    com.tencent.mm.sdk.b.a.ESL.d(this.wqe);
    com.tencent.mm.sdk.b.a.ESL.d(this.wqf);
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FjB, Boolean.FALSE);
    dpL();
    if (com.tencent.mm.plugin.shake.c.c.a.dpA()) {
      com.tencent.mm.z.c.adr().x(262154, false);
    }
    dpT();
    localObject = com.tencent.mm.plugin.shake.b.m.dpg();
    int i;
    if (((com.tencent.mm.plugin.shake.c.a.f)localObject).nqa != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < ((com.tencent.mm.plugin.shake.c.a.f)localObject).nqa.size())
      {
        WeakReference localWeakReference = (WeakReference)((com.tencent.mm.plugin.shake.c.a.f)localObject).nqa.get(i);
        if (localWeakReference != null)
        {
          f.a locala = (f.a)localWeakReference.get();
          if ((locala != null) && (locala.equals(this))) {
            ((com.tencent.mm.plugin.shake.c.a.f)localObject).nqa.remove(localWeakReference);
          }
        }
      }
      else
      {
        localObject = com.tencent.mm.plugin.shake.b.m.dph();
        ((com.tencent.mm.plugin.shake.c.a.d)localObject).fjD = -85.0F;
        ((com.tencent.mm.plugin.shake.c.a.d)localObject).fjE = -1000.0F;
        if (this.fjC != null) {
          this.fjC.c(this.fjJ);
        }
        super.onDestroy();
        AppMethodBeat.o(28488);
        return;
      }
      i += 1;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(28487);
    az.arV();
    com.tencent.mm.model.c.b(this);
    az.arV();
    com.tencent.mm.model.c.afk().b(this);
    com.tencent.mm.plugin.shake.b.m.dpb().remove(this);
    if (this.wpb.wlT != null) {
      this.wpb.wlT.pause();
    }
    this.woX = false;
    if (this.shakeSensor != null) {
      this.shakeSensor.bQk();
    }
    this.wpa.dpH();
    if (this.wpH != 5)
    {
      az.arV();
      com.tencent.mm.model.c.afk().set(327696, this.wpH);
    }
    if (this.wpH == 4) {
      pt(false);
    }
    dpL();
    super.onPause();
    AppMethodBeat.o(28487);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(28527);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.ShakeReportUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(28527);
      return;
    }
    ad.i("MicroMsg.ShakeReportUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28527);
      return;
      if (paramArrayOfInt[0] != 0)
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28468);
            paramAnonymousDialogInterface.dismiss();
            paramAnonymousDialogInterface = ShakeReportUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$27", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$27", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(28468);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28469);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(28469);
          }
        });
        AppMethodBeat.o(28527);
        return;
        if (paramArrayOfInt[0] == 0)
        {
          dfj();
          AppMethodBeat.o(28527);
          return;
        }
        this.imk = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28470);
            paramAnonymousDialogInterface = ShakeReportUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$29", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$29", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ShakeReportUI.P(ShakeReportUI.this);
            ShakeReportUI.this.finish();
            AppMethodBeat.o(28470);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28472);
            ShakeReportUI.P(ShakeReportUI.this);
            ShakeReportUI.this.finish();
            AppMethodBeat.o(28472);
          }
        });
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28485);
    super.onResume();
    if (this.imk) {
      if (com.tencent.mm.ax.b.yL((String)com.tencent.mm.kernel.g.afB().afk().get(274436, null)))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.ACCESS_COARSE_LOCATION"))
        {
          if (!((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FtT, Boolean.FALSE)).booleanValue())
          {
            com.tencent.mm.plugin.account.a.b.a.b(this, getString(2131760740, new Object[] { ac.eFu() }), 30764, true);
            AppMethodBeat.o(28485);
            return;
          }
          com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
          AppMethodBeat.o(28485);
        }
      }
      else
      {
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "");
        ad.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkposition[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this });
        if (!bool)
        {
          AppMethodBeat.o(28485);
          return;
        }
      }
    }
    dfj();
    AppMethodBeat.o(28485);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends com.tencent.mm.pluginsdk.j.d.a
  {
    private final long[] hWP;
    private long lastShakeTime;
    private Vibrator mHT;
    WeakReference<ShakeReportUI> wqo;
    
    public a(ShakeReportUI paramShakeReportUI)
    {
      AppMethodBeat.i(28481);
      this.lastShakeTime = bt.GC();
      this.hWP = new long[] { 300L, 200L, 300L, 200L };
      this.wqo = new WeakReference(paramShakeReportUI);
      AppMethodBeat.o(28481);
    }
    
    public final void onRelease() {}
    
    public final void onShake(boolean paramBoolean)
    {
      AppMethodBeat.i(28482);
      ShakeReportUI localShakeReportUI = (ShakeReportUI)this.wqo.get();
      if (localShakeReportUI == null)
      {
        AppMethodBeat.o(28482);
        return;
      }
      if (localShakeReportUI.isFinishing())
      {
        ad.e("MicroMsg.ShakeReportUI", "ui finished");
        AppMethodBeat.o(28482);
        return;
      }
      if (!ShakeReportUI.v(localShakeReportUI))
      {
        ad.i("MicroMsg.ShakeReportUI", "tryShake the status is can's shake");
        AppMethodBeat.o(28482);
        return;
      }
      ShakeReportUI.w(localShakeReportUI);
      long l = bt.aS(this.lastShakeTime);
      if (l < 1200L)
      {
        ad.i("MicroMsg.ShakeReportUI", "tryStartShake delay too short:".concat(String.valueOf(l)));
        AppMethodBeat.o(28482);
        return;
      }
      ad.w("MicroMsg.ShakeReportUI", "tryStartShake delaytoo enough:".concat(String.valueOf(l)));
      this.lastShakeTime = bt.GC();
      Object localObject;
      if (ShakeReportUI.x(localShakeReportUI) != null)
      {
        localObject = ShakeReportUI.x(localShakeReportUI);
        if (((c)localObject).view != null) {
          ((c)localObject).view.setKeepScreenOn(true);
        }
        ((c)localObject).cOx.av(30000L, 30000L);
      }
      if (ShakeReportUI.y(localShakeReportUI) != null)
      {
        localObject = ShakeReportUI.y(localShakeReportUI);
        if (((com.tencent.mm.pluginsdk.ui.f)localObject).BVp != null) {
          ((com.tencent.mm.pluginsdk.ui.f)localObject).BVp.dismiss();
        }
      }
      if (ShakeReportUI.z(localShakeReportUI))
      {
        localObject = (ShakeReportUI)this.wqo.get();
        if (localObject != null) {
          bd.az((Context)localObject, 2131763618);
        }
      }
      for (;;)
      {
        reset();
        ShakeReportUI.A(localShakeReportUI);
        AppMethodBeat.o(28482);
        return;
        localObject = (ShakeReportUI)this.wqo.get();
        if (localObject != null)
        {
          if (this.mHT == null) {
            this.mHT = ((Vibrator)((ShakeReportUI)localObject).getSystemService("vibrator"));
          }
          if (this.mHT != null) {
            this.mHT.vibrate(this.hWP, -1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI
 * JD-Core Version:    0.7.0.1
 */