package com.tencent.mm.plugin.shake.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
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
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.dt;
import com.tencent.mm.g.a.du;
import com.tencent.mm.g.a.ea;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.c;
import com.tencent.mm.model.as;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.c.a.f.a;
import com.tencent.mm.plugin.shake.d.a.h.a;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.ui.widget.b.c.a;
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
  implements as, x.a, l.a, f.a, k.a, n.b
{
  private static List<h.a> dZy;
  private b.a dZA;
  private com.tencent.mm.modelgeo.d dZt;
  private boolean dZw;
  private Map<String, h.a> dZx;
  private ImageView ehv;
  private com.tencent.mm.at.a.a fGJ;
  private boolean gzb;
  private boolean ogA;
  private Animation qQA;
  private View qQB;
  private View qQC;
  private MMImageView qQD;
  private TextView qQE;
  private ImageView qQF;
  private String qQG;
  private Bitmap qQH;
  private Dialog qQI;
  private ImageView qQJ;
  private com.tencent.mm.plugin.shake.b.d qQK;
  private ImageView qQL;
  private ImageView qQM;
  private ImageView qQN;
  private ImageView qQO;
  private ImageView qQP;
  private ImageView qQQ;
  private TextView qQR;
  private int qQS;
  private int qQT;
  private View qQU;
  private ImageView qQV;
  private ImageView qQW;
  private ImageView qQX;
  private ImageView qQY;
  private View qQZ;
  private boolean qQd;
  private boolean qQe;
  private boolean qQf;
  private boolean qQg;
  private boolean qQh;
  private boolean qQi;
  private boolean qQj;
  private int qQk;
  private c qQl;
  private l qQm;
  private com.tencent.mm.pluginsdk.ui.f qQn;
  private View qQo;
  private View qQp;
  private TextView qQq;
  private TextView qQr;
  private TextView qQs;
  private View qQt;
  private View qQu;
  private View qQv;
  private View qQw;
  private Animation qQx;
  private Animation qQy;
  private Animation qQz;
  private View qRa;
  private View qRb;
  private View qRc;
  private View qRd;
  private int qRe;
  private com.tencent.mm.plugin.shake.c.b.a qRf;
  private boolean qRg;
  @SuppressLint({"UseSparseArrays"})
  private Map<Integer, Boolean> qRh;
  private boolean qRi;
  private boolean qRj;
  private boolean qRk;
  private boolean qRl;
  private int qRm;
  private long qRn;
  private boolean qRo;
  private com.tencent.mm.sdk.b.c qRp;
  private com.tencent.mm.sdk.b.c qRq;
  private View.OnClickListener qRr;
  private com.tencent.mm.pluginsdk.i.d shakeSensor;
  
  static
  {
    AppMethodBeat.i(24872);
    dZy = new CopyOnWriteArrayList();
    AppMethodBeat.o(24872);
  }
  
  public ShakeReportUI()
  {
    AppMethodBeat.i(24814);
    this.qQd = false;
    this.qQe = false;
    this.qQg = false;
    this.qQh = false;
    this.qQi = false;
    this.qQj = false;
    this.qQk = 22;
    this.qQm = new l();
    this.qQB = null;
    this.qQC = null;
    this.qQD = null;
    this.qQE = null;
    this.qQF = null;
    this.qQG = "";
    this.qQH = null;
    this.qQJ = null;
    this.fGJ = null;
    this.qQK = null;
    this.qQS = 1;
    this.qQT = 0;
    this.qRd = null;
    this.qRe = 0;
    this.qRg = false;
    this.qRh = new HashMap();
    this.qRi = false;
    this.qRj = false;
    this.qRk = false;
    this.qRl = false;
    this.qRm = 1;
    this.gzb = true;
    this.dZw = false;
    this.dZA = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(24775);
        if (paramAnonymousBoolean)
        {
          ab.d("MicroMsg.ShakeReportUI", "on location get ok");
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yyL, String.valueOf(paramAnonymousFloat2));
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yyM, String.valueOf(paramAnonymousFloat1));
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yBq, String.valueOf(paramAnonymousDouble2));
          ShakeReportUI.a(ShakeReportUI.this);
          if (ShakeReportUI.b(ShakeReportUI.this) != null) {
            ShakeReportUI.b(ShakeReportUI.this).c(ShakeReportUI.c(ShakeReportUI.this));
          }
        }
        for (;;)
        {
          AppMethodBeat.o(24775);
          return false;
          if ((!ShakeReportUI.d(ShakeReportUI.this)) && (!com.tencent.mm.modelgeo.d.agR()))
          {
            ShakeReportUI.e(ShakeReportUI.this);
            com.tencent.mm.ui.base.h.a(ShakeReportUI.this, ShakeReportUI.this.getString(2131300538), ShakeReportUI.this.getString(2131297087), ShakeReportUI.this.getString(2131300996), ShakeReportUI.this.getString(2131296888), false, new ShakeReportUI.1.1(this), null);
          }
          ab.w("MicroMsg.ShakeReportUI", "getLocation fail");
        }
      }
    };
    this.dZx = new ConcurrentHashMap();
    this.qRn = 0L;
    this.qRo = false;
    this.qRp = new com.tencent.mm.sdk.b.c() {};
    this.qRq = new com.tencent.mm.sdk.b.c() {};
    this.qRr = new ShakeReportUI.18(this);
    AppMethodBeat.o(24814);
  }
  
  private void Ds(int paramInt)
  {
    AppMethodBeat.i(24834);
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      kQ(bool);
      if (paramInt != 2) {
        break;
      }
      kP(true);
      AppMethodBeat.o(24834);
      return;
    }
    kP(false);
    AppMethodBeat.o(24834);
  }
  
  private void Zk(String paramString)
  {
    AppMethodBeat.i(24836);
    this.qQg = false;
    if (this.qQf) {
      ay.ax(getContext(), 2131303613);
    }
    if (this.qQA == null) {
      this.qQA = AnimationUtils.loadAnimation(getContext(), 2131034174);
    }
    Ds(2);
    if ((paramString != null) && (paramString.length() > 1)) {
      this.qQr.setText(paramString);
    }
    for (;;)
    {
      this.qQr.startAnimation(this.qQA);
      this.qQj = true;
      al.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24792);
          ShakeReportUI.K(ShakeReportUI.this);
          ShakeReportUI.d(ShakeReportUI.this, false);
          AppMethodBeat.o(24792);
        }
      }, this.qQA.getDuration());
      AppMethodBeat.o(24836);
      return;
      this.qQr.setText(2131303579);
    }
  }
  
  private void a(com.tencent.mm.plugin.shake.c.a.e parame)
  {
    AppMethodBeat.i(24839);
    this.qRf = com.tencent.mm.plugin.shake.c.b.a.a(this, parame, new ShakeReportUI.16(this), new ShakeReportUI.17(this));
    AppMethodBeat.o(24839);
  }
  
  private void bk(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(24850);
    this.qQg = false;
    if (this.qQA == null) {
      this.qQA = AnimationUtils.loadAnimation(getContext(), 2131034174);
    }
    Ds(2);
    kP(true);
    if ((paramString != null) && (paramString.length() > 1)) {
      this.qQr.setText(paramString);
    }
    for (;;)
    {
      this.qQj = true;
      AppMethodBeat.o(24850);
      return;
      if (paramBoolean)
      {
        this.qQr.setText(2131303569);
      }
      else
      {
        this.qQr.setText("");
        kP(false);
      }
    }
  }
  
  private void c(com.tencent.mm.plugin.shake.b.d paramd)
  {
    AppMethodBeat.i(24844);
    if (bo.isNullOrNil(paramd.field_username))
    {
      AppMethodBeat.o(24844);
      return;
    }
    this.qQo.setTag(paramd.field_username);
    this.qQo.setVisibility(0);
    aw.aaz();
    ad localad = com.tencent.mm.model.c.YA().arw(paramd.field_username);
    Object localObject2 = new StringBuilder().append(paramd.field_nickname);
    Object localObject1;
    label156:
    label212:
    label363:
    int i;
    if (com.tencent.mm.n.a.je(localad.field_type))
    {
      localObject1 = getString(2131303606);
      localObject2 = (String)localObject1;
      if (paramd.field_sex != 1) {
        break label500;
      }
      this.qQo.setContentDescription((String)localObject2 + paramd.field_distance + getContext().getString(2131303635));
      TextView localTextView = (TextView)this.qQo.findViewById(2131827726);
      AppCompatActivity localAppCompatActivity = getContext();
      StringBuilder localStringBuilder = new StringBuilder().append(paramd.field_nickname);
      if (!com.tencent.mm.n.a.je(localad.field_type)) {
        break label585;
      }
      localObject1 = getString(2131303606);
      localTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.b(localAppCompatActivity, (String)localObject1, localTextView.getTextSize()));
      if (this.ehv != null)
      {
        if (bo.isNullOrNil((String)localObject2)) {
          break label591;
        }
        this.ehv.setContentDescription(String.format(getString(2131303561), new Object[] { localObject2 }));
      }
      label277:
      ((TextView)this.qQo.findViewById(2131827729)).setText(paramd.field_distance);
      a.b.c((ImageView)this.qQo.findViewById(2131827725), paramd.field_username);
      localObject1 = (ImageView)this.qQo.findViewById(2131827728);
      if (paramd.field_reserved1 == 0) {
        break label608;
      }
      ((ImageView)localObject1).setVisibility(0);
      ((ImageView)localObject1).setImageBitmap(BackwardSupportUtil.b.k(ao.a.flK.kx(paramd.field_reserved1), 2.0F));
      if ((paramd.field_reserved1 != 0) || (paramd.field_sex == 0)) {
        break label624;
      }
      if (paramd.field_sex != 1) {
        break label617;
      }
      i = 2131231426;
      label389:
      localObject1 = com.tencent.mm.cb.a.k(this, i);
      this.qQo.findViewById(2131827727).setVisibility(0);
      ((ImageView)this.qQo.findViewById(2131827727)).setImageDrawable((Drawable)localObject1);
    }
    for (;;)
    {
      if (paramd.getProvince() == null)
      {
        ab.e("MicroMsg.ShakeReportUI", "PROVINCE NULL");
        paramd.field_province = "";
      }
      if (paramd.getCity() == null)
      {
        ab.e("MicroMsg.ShakeReportUI", "CITY NULL");
        paramd.field_city = "";
      }
      this.qQo.startAnimation(AnimationUtils.loadAnimation(getContext(), 2131034251));
      AppMethodBeat.o(24844);
      return;
      localObject1 = "";
      break;
      label500:
      if (paramd.field_sex == 2)
      {
        this.qQo.setContentDescription((String)localObject2 + paramd.field_distance + getContext().getString(2131303634));
        break label156;
      }
      this.qQo.setContentDescription((String)localObject2 + paramd.field_distance);
      break label156;
      label585:
      localObject1 = "";
      break label212;
      label591:
      this.ehv.setContentDescription(getString(2131303562));
      break label277;
      label608:
      ((ImageView)localObject1).setVisibility(8);
      break label363;
      label617:
      i = 2131231425;
      break label389;
      label624:
      this.qQo.findViewById(2131827727).setVisibility(8);
    }
  }
  
  private void ceV()
  {
    AppMethodBeat.i(24817);
    cma();
    aw.aaz();
    com.tencent.mm.model.c.a(this);
    aw.aaz();
    com.tencent.mm.model.c.Ru().a(this);
    com.tencent.mm.plugin.shake.b.m.cln().add(this);
    if (this.qQm.qNd != null) {
      this.qQm.qNd.resume();
    }
    cmb();
    new ak().postDelayed(new ShakeReportUI.22(this), 1000L);
    if (this.shakeSensor != null) {
      this.shakeSensor.dmK();
    }
    kP(false);
    kQ(false);
    cmd();
    aw.aaz();
    Object localObject = (String)com.tencent.mm.model.c.Ru().get(327696, "1");
    if (com.tencent.mm.plugin.shake.d.a.k.cll())
    {
      if (this.qQS == 4) {
        kL(true);
      }
      if (((String)localObject).equals("4")) {
        dB(findViewById(2131827742));
      }
    }
    boolean bool;
    if (((String)localObject).equals("3"))
    {
      dB(findViewById(2131827739));
      bool = com.tencent.mm.x.c.PJ().cd(262154, 266258);
      if ((!getIntent().getBooleanExtra("shake_music", false)) || (!com.tencent.mm.aw.d.aiE()) || (this.qQm.qNc == 3)) {
        break label357;
      }
      getIntent().putExtra("shake_music", false);
      this.qQS = 3;
    }
    for (;;)
    {
      cmc();
      kM(true);
      ab.d("MicroMsg.ShakeReportUI", "isShakeGetConfigList = %s", new Object[] { Boolean.valueOf(ae.gkA) });
      if (ae.gkA)
      {
        localObject = new com.tencent.mm.ba.k(7);
        aw.Rc().a((com.tencent.mm.ai.m)localObject, 0);
      }
      cmm();
      cmj();
      clX();
      AppMethodBeat.o(24817);
      return;
      if ((!((String)localObject).equals("6")) || (!com.tencent.mm.plugin.shake.c.c.a.clN())) {
        break;
      }
      dB(findViewById(2131827733));
      break;
      label357:
      if ((getIntent().getBooleanExtra("shake_tv", false)) && (this.qQm.qNc != 4) && (com.tencent.mm.plugin.shake.d.a.k.cll()))
      {
        getIntent().putExtra("shake_tv", false);
        this.qQS = 4;
      }
      else if ((this.qQm.qNc != 6) && (com.tencent.mm.plugin.shake.c.c.a.clN()) && ((bool) || (getIntent().getBooleanExtra("shake_card", false))))
      {
        this.qRe = getIntent().getIntExtra("shake_card", 0);
        getIntent().putExtra("shake_card", false);
        ab.i("MicroMsg.ShakeReportUI", "onresume shake card tab is open, activity type is 0 or open from specialview");
        this.qQS = 6;
      }
    }
  }
  
  private void clX()
  {
    AppMethodBeat.i(24820);
    if (!cml())
    {
      AppMethodBeat.o(24820);
      return;
    }
    if (BluetoothAdapter.getDefaultAdapter() != null)
    {
      Object localObject = com.tencent.mm.m.g.Nr().Ng();
      if (localObject != null)
      {
        this.qRn = System.currentTimeMillis();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          ab.i("MicroMsg.ShakeReportUI", "op=true,iBeacon = %s", new Object[] { str });
          dt localdt = new dt();
          localdt.crx.crz = str;
          localdt.crx.crw = true;
          com.tencent.mm.sdk.b.a.ymk.l(localdt);
        }
      }
    }
    AppMethodBeat.o(24820);
  }
  
  private void clY()
  {
    AppMethodBeat.i(24821);
    aw.aaz();
    if (!bo.a((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yBf, null), false))
    {
      this.dZx.clear();
      dZy = new CopyOnWriteArrayList();
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      Object localObject = com.tencent.mm.m.g.Nr().Ng();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          dt localdt = new dt();
          ab.i("MicroMsg.ShakeReportUI", "op=false,iBeacon = %s", new Object[] { str });
          localdt.crx.crz = str;
          localdt.crx.crw = false;
          com.tencent.mm.sdk.b.a.ymk.l(localdt);
        }
      }
    }
    AppMethodBeat.o(24821);
  }
  
  private void clZ()
  {
    AppMethodBeat.i(24823);
    if (com.tencent.mm.aw.d.aiF())
    {
      aw.aaz();
      if (com.tencent.mm.model.c.Ru().getInt(4118, 0) == 0)
      {
        c.a locala = new c.a(getContext());
        locala.Rb(2131297087);
        locala.Rf(2131303589);
        locala.Ri(2131303588).a(new ShakeReportUI.2(this));
        locala.rG(true);
        locala.e(new ShakeReportUI.3(this));
        this.qQI = locala.aLZ();
        this.qQI.show();
      }
    }
    AppMethodBeat.o(24823);
  }
  
  private void cma()
  {
    AppMethodBeat.i(24824);
    aw.aaz();
    int j = bo.a((Integer)com.tencent.mm.model.c.Ru().get(12290, null), 0);
    ImageView localImageView = (ImageView)findViewById(2131827712);
    if ((this.qQH != null) && (!this.qQH.isRecycled())) {
      this.qQH.recycle();
    }
    aw.aaz();
    Object localObject1;
    if (bo.d((Boolean)com.tencent.mm.model.c.Ru().get(4110, null)))
    {
      localObject1 = new StringBuilder();
      aw.aaz();
      localObject1 = com.tencent.mm.model.c.YK() + "default_shake_img_filename.jpg";
      if (com.tencent.mm.vfs.e.cN((String)localObject1))
      {
        this.qQH = x.wx((String)localObject1);
        localImageView.setImageDrawable(new BitmapDrawable(this.qQH));
        localObject1 = (ImageView)findViewById(2131827714);
        localImageView = (ImageView)findViewById(2131827717);
        if (j != 2) {
          break label391;
        }
        i = 2130840284;
        label179:
        ((ImageView)localObject1).setImageResource(i);
        if (j != 2) {
          break label398;
        }
      }
    }
    label391:
    label398:
    for (int i = 2130840283;; i = 2130840282)
    {
      for (;;)
      {
        localImageView.setImageResource(i);
        ShakeReportUI.7 local7 = new ShakeReportUI.7(this);
        ((ImageView)localObject1).setOnClickListener(local7);
        localImageView.setOnClickListener(local7);
        if (this.qQv == null) {
          this.qQv = findViewById(2131827722);
        }
        this.qQv.setOnClickListener(local7);
        if (this.qQw == null) {
          this.qQw = findViewById(2131827715);
        }
        this.qQw.setOnClickListener(local7);
        AppMethodBeat.o(24824);
        return;
        try
        {
          localObject1 = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.decodeStream(getContext().getAssets().open("resource/shakehideimg_man.jpg")));
          localImageView.setImageDrawable((Drawable)localObject1);
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ab.w("MicroMsg.ShakeReportUI", "Bg decode exp:" + localIOException.getLocalizedMessage());
            Object localObject2 = null;
          }
        }
      }
      aw.aaz();
      this.qQH = x.wx((String)com.tencent.mm.model.c.Ru().get(4111, null));
      localImageView.setImageDrawable(new BitmapDrawable(this.qQH));
      break;
      i = 2130840285;
      break label179;
    }
  }
  
  private void cmb()
  {
    AppMethodBeat.i(24825);
    this.qQi = true;
    if ((this.qRf != null) && (this.qRf.isShowing()) && (!this.qRf.qOk)) {
      this.qQi = false;
    }
    ab.i("MicroMsg.ShakeReportUI", "tryStartShake");
    if ((this.shakeSensor != null) && (!this.shakeSensor.dmJ()))
    {
      this.shakeSensor.a(new ShakeReportUI.a(this));
      if ((this.shakeSensor.dmL()) && (this.qQq != null))
      {
        this.qQq.setText(getString(2131303552));
        AppMethodBeat.o(24825);
        return;
      }
      this.qQq.setText(getString(2131303614));
    }
    AppMethodBeat.o(24825);
  }
  
  private void cmc()
  {
    AppMethodBeat.i(24827);
    if ((this.qQS == 3) && (com.tencent.mm.aw.d.aiE()))
    {
      this.qQS = 3;
      this.qQs.setText(2131303630);
      this.qQJ.setBackgroundResource(2130840268);
      this.qQL.setBackgroundResource(2130840274);
      this.qQM.setBackgroundResource(2130840273);
      this.qQN.setBackgroundResource(2130840277);
      this.qQO.setBackgroundResource(2130840264);
      findViewById(2131827730).setVisibility(0);
      setMMTitle(2131303626);
      com.tencent.mm.plugin.report.service.h.qsU.e(11720, new Object[] { Integer.valueOf(2) });
      com.tencent.mm.plugin.report.service.h.qsU.j(834L, 2L, 1L);
    }
    for (;;)
    {
      l.b localb = this.qQm.a(this, this.qQS, this);
      if (!this.qQg) {
        kQ(false);
      }
      if ((com.tencent.mm.plugin.shake.c.c.a.clN()) && ((localb instanceof com.tencent.mm.plugin.shake.c.a.g)))
      {
        ((com.tencent.mm.plugin.shake.c.a.g)localb).setFromScene(this.qRe);
        if (this.qRe == 3)
        {
          ab.i("MicroMsg.ShakeReportUI", "open shake card from specialview");
          ((com.tencent.mm.plugin.shake.c.a.g)localb).JN(getIntent().getStringExtra("key_shake_card_ext_info"));
        }
      }
      AppMethodBeat.o(24827);
      return;
      if ((this.qQS == 4) && (com.tencent.mm.plugin.shake.d.a.k.cll()))
      {
        this.qQS = 4;
        this.qQs.setText(2131303631);
        this.qQJ.setBackgroundResource(2130840268);
        this.qQL.setBackgroundResource(2130840274);
        this.qQM.setBackgroundResource(2130840271);
        this.qQN.setBackgroundResource(2130840279);
        this.qQO.setBackgroundResource(2130840264);
        findViewById(2131827730).setVisibility(0);
        setMMTitle(2131303627);
        com.tencent.mm.plugin.report.service.h.qsU.e(11720, new Object[] { Integer.valueOf(3) });
        com.tencent.mm.plugin.report.service.h.qsU.j(834L, 3L, 1L);
      }
      else if ((this.qQS == 5) && (cmk()))
      {
        this.qQS = 5;
        this.qQs.setText(2131303629);
        this.qQJ.setBackgroundResource(2130840270);
        this.qQL.setBackgroundResource(2130840274);
        this.qQM.setBackgroundResource(2130840271);
        this.qQN.setBackgroundResource(2130840277);
        this.qQO.setBackgroundResource(2130840264);
        findViewById(2131827730).setVisibility(0);
        setMMTitle(2131303625);
        com.tencent.mm.plugin.report.service.h.qsU.e(11720, new Object[] { Integer.valueOf(4) });
        com.tencent.mm.plugin.report.service.h.qsU.j(834L, 4L, 1L);
      }
      else if ((this.qQS == 6) && (com.tencent.mm.plugin.shake.c.c.a.clN()))
      {
        this.qQS = 6;
        this.qQs.setText(2131303628);
        this.qQJ.setBackgroundResource(2130840268);
        this.qQL.setBackgroundResource(2130840274);
        this.qQM.setBackgroundResource(2130840271);
        this.qQN.setBackgroundResource(2130840277);
        this.qQO.setBackgroundResource(2130840265);
        findViewById(2131827730).setVisibility(0);
        setMMTitle(2131303624);
        cmf();
        cmi();
        com.tencent.mm.plugin.report.service.h.qsU.e(11720, new Object[] { Integer.valueOf(5) });
        com.tencent.mm.plugin.report.service.h.qsU.j(834L, 5L, 1L);
      }
      else
      {
        this.qQS = 1;
        this.qQs.setText(2131303572);
        this.qQJ.setBackgroundResource(2130840268);
        this.qQL.setBackgroundResource(2130840276);
        this.qQM.setBackgroundResource(2130840271);
        this.qQN.setBackgroundResource(2130840277);
        this.qQO.setBackgroundResource(2130840264);
        if (com.tencent.mm.aw.d.aiE()) {
          findViewById(2131827730).setVisibility(0);
        }
        setMMTitle(2131303623);
        com.tencent.mm.plugin.report.service.h.qsU.e(11720, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.h.qsU.j(834L, 1L, 1L);
      }
    }
  }
  
  private void cmd()
  {
    AppMethodBeat.i(24828);
    aw.aaz();
    this.qQf = bo.d((Boolean)com.tencent.mm.model.c.Ru().get(4112, null));
    if (this.qQf)
    {
      setTitleMuteIconVisibility(8);
      AppMethodBeat.o(24828);
      return;
    }
    setTitleMuteIconVisibility(0);
    AppMethodBeat.o(24828);
  }
  
  private void cme()
  {
    AppMethodBeat.i(24848);
    if (com.tencent.mm.plugin.shake.c.c.a.clN())
    {
      if (com.tencent.mm.x.c.PJ().cd(262155, 266259))
      {
        this.qQQ.setVisibility(0);
        AppMethodBeat.o(24848);
        return;
      }
      this.qQQ.setVisibility(8);
    }
    AppMethodBeat.o(24848);
  }
  
  private void cmf()
  {
    AppMethodBeat.i(24849);
    if ((this.qQS == 6) && (com.tencent.mm.plugin.shake.c.c.a.clN()))
    {
      boolean bool1 = com.tencent.mm.x.c.PJ().cd(262154, 266258);
      boolean bool2 = com.tencent.mm.x.c.PJ().cd(262155, 266259);
      if (bool1)
      {
        bk(com.tencent.mm.plugin.shake.c.c.a.clI(), true);
        AppMethodBeat.o(24849);
        return;
      }
      if (bool2)
      {
        bk(com.tencent.mm.plugin.shake.c.c.a.clK(), true);
        AppMethodBeat.o(24849);
        return;
      }
      if (!this.qRg)
      {
        if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.clG()))
        {
          bk(com.tencent.mm.plugin.shake.c.c.a.clG(), true);
          AppMethodBeat.o(24849);
          return;
        }
        bk(getString(2131303569), true);
      }
    }
    AppMethodBeat.o(24849);
  }
  
  private void cmg()
  {
    AppMethodBeat.i(24851);
    if ((this.qRf != null) && (this.qRf.isShowing())) {
      this.qRf.dismiss();
    }
    this.qRf = null;
    AppMethodBeat.o(24851);
  }
  
  private void cmh()
  {
    int m = 1;
    AppMethodBeat.i(24852);
    boolean bool1 = com.tencent.mm.plugin.shake.c.c.a.cli();
    boolean bool2 = com.tencent.mm.x.c.PJ().cd(262154, 266258);
    boolean bool3 = com.tencent.mm.x.c.PJ().cd(262155, 266259);
    if (getIntent().getBooleanExtra("shake_card", false)) {}
    for (int i = getIntent().getIntExtra("shake_card", 0);; i = 0)
    {
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.qsU;
      int j;
      if (bool2)
      {
        j = 1;
        if (!bool1) {
          break label231;
        }
        k = 1;
        label87:
        localh.e(11668, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), com.tencent.mm.plugin.shake.c.c.a.clJ(), Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.clF()) });
        localh = com.tencent.mm.plugin.report.service.h.qsU;
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
        localh.e(11668, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), com.tencent.mm.plugin.shake.c.c.a.clJ(), Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.clF()) });
        AppMethodBeat.o(24852);
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
  
  private void cmi()
  {
    AppMethodBeat.i(24853);
    if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.clH())) {
      this.qQR.setText(com.tencent.mm.plugin.shake.c.c.a.clH());
    }
    AppMethodBeat.o(24853);
  }
  
  private void cmj()
  {
    AppMethodBeat.i(24854);
    label123:
    Object localObject;
    label167:
    label208:
    int i;
    if (com.tencent.mm.aw.d.aiE())
    {
      ab.i("MicroMsg.ShakeReportUI", "is not oversea user, show shake music");
      this.qRh.put(Integer.valueOf(3), Boolean.TRUE);
      findViewById(2131827739).setVisibility(0);
      if (com.tencent.mm.aw.d.aiF())
      {
        aw.aaz();
        if (com.tencent.mm.model.c.Ru().getInt(4118, 0) == 0) {
          this.qQP.setVisibility(0);
        }
      }
      else
      {
        if (!com.tencent.mm.plugin.shake.d.a.k.cll()) {
          break label309;
        }
        this.qRh.put(Integer.valueOf(4), Boolean.TRUE);
        findViewById(2131827742).setVisibility(0);
        ab.i("MicroMsg.ShakeReportUI", "show shake tv tab");
        if (!com.tencent.mm.plugin.shake.c.c.a.clN()) {
          break label350;
        }
        this.qRh.put(Integer.valueOf(6), Boolean.TRUE);
        findViewById(2131827733).setVisibility(0);
        ab.i("MicroMsg.ShakeReportUI", "show shake card tab");
        if (!cmk()) {
          break label392;
        }
        this.qRh.put(Integer.valueOf(5), Boolean.TRUE);
        this.qRd.setVisibility(0);
        ab.i("MicroMsg.ShakeReportUI", "[shakezb]show shake ibeacon tab");
        localObject = this.qRh.values().iterator();
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
      this.qQP.setVisibility(8);
      break;
      this.qRh.put(Integer.valueOf(3), Boolean.FALSE);
      findViewById(2131827739).setVisibility(8);
      ab.i("MicroMsg.ShakeReportUI", "is oversea user, hide shake music");
      break;
      this.qRh.put(Integer.valueOf(4), Boolean.FALSE);
      findViewById(2131827742).setVisibility(8);
      ab.i("MicroMsg.ShakeReportUI", "hide shake tv tab");
      break label123;
      label350:
      findViewById(2131827733).setVisibility(8);
      this.qRh.put(Integer.valueOf(6), Boolean.FALSE);
      ab.i("MicroMsg.ShakeReportUI", "hide shake card tab");
      break label167;
      this.qRh.put(Integer.valueOf(5), Boolean.FALSE);
      this.qRd.setVisibility(8);
      ab.i("MicroMsg.ShakeReportUI", "[shakezb]hide shake ibeacon tab");
      break label208;
      this.qQT = i;
      localObject = (LinearLayout)findViewById(2131827730);
      if (i == 1) {
        ((LinearLayout)localObject).setVisibility(8);
      }
      while ((i > 4) && (this.qRo))
      {
        findViewById(2131827742).setVisibility(8);
        ab.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() > 0.");
        this.qQT -= 1;
        AppMethodBeat.o(24854);
        return;
        ((LinearLayout)localObject).setVisibility(0);
      }
      if ((i > 4) && (!this.qRo))
      {
        this.qRd.setVisibility(8);
        this.qRi = false;
        this.qQT -= 1;
        ab.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() <= 0.");
      }
      AppMethodBeat.o(24854);
      return;
    }
  }
  
  private boolean cmk()
  {
    AppMethodBeat.i(24855);
    ab.i("MicroMsg.ShakeReportUI", "[shakezb] isChineseAppLang :" + aa.dsC() + " ,getApplicationLanguage[en or zh_CN or zh_HK or zh_TW is avaliable] :" + aa.dsG());
    if ((this.qRi) && (cml()))
    {
      AppMethodBeat.o(24855);
      return true;
    }
    AppMethodBeat.o(24855);
    return false;
  }
  
  private static boolean cml()
  {
    AppMethodBeat.i(24856);
    if ((aa.dsC()) || (aa.dsG().equals("en")) || (aa.dsG().equals("ja")))
    {
      AppMethodBeat.o(24856);
      return true;
    }
    AppMethodBeat.o(24856);
    return false;
  }
  
  private void cmm()
  {
    AppMethodBeat.i(24857);
    this.qQU.setVisibility(8);
    AppMethodBeat.o(24857);
  }
  
  private void d(com.tencent.mm.plugin.shake.b.d paramd)
  {
    AppMethodBeat.i(24845);
    if (bo.isNullOrNil(paramd.field_username))
    {
      AppMethodBeat.o(24845);
      return;
    }
    this.qQo.setTag(paramd.field_username);
    ((TextView)this.qQo.findViewById(2131827726)).setText(paramd.field_username);
    this.qQo.setContentDescription(bo.nullAsNil(paramd.field_nickname));
    ((TextView)this.qQo.findViewById(2131827729)).setText(paramd.field_signature);
    this.fGJ.a(paramd.getProvince(), (ImageView)this.qQo.findViewById(2131827725));
    this.qQo.findViewById(2131827727).setVisibility(8);
    this.qQo.startAnimation(AnimationUtils.loadAnimation(getContext(), 2131034251));
    this.qQo.setVisibility(0);
    AppMethodBeat.o(24845);
  }
  
  private void dB(View paramView)
  {
    AppMethodBeat.i(24840);
    if (paramView == null)
    {
      AppMethodBeat.o(24840);
      return;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, "", "");
    ab.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this });
    if (!bool)
    {
      AppMethodBeat.o(24840);
      return;
    }
    bk("", false);
    if (paramView.getId() == 2131827737)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(11722, new Object[] { Integer.valueOf(1) });
      if (this.qQS != 1)
      {
        if (this.qQS == 4) {
          kL(false);
        }
        this.qQS = 1;
        cmc();
        kN(false);
        if (this.qQo != null) {
          this.qQo.setVisibility(8);
        }
      }
    }
    do
    {
      for (;;)
      {
        kM(true);
        kQ(false);
        cmm();
        AppMethodBeat.o(24840);
        return;
        if (paramView.getId() == 2131827739)
        {
          com.tencent.mm.plugin.report.service.h.qsU.e(11722, new Object[] { Integer.valueOf(2) });
          if ((!this.dZw) && (this.dZt != null)) {
            this.dZt.a(this.dZA, true);
          }
          if ((!com.tencent.mm.r.a.bO(this)) && (!com.tencent.mm.r.a.bM(this)) && (this.qQS != 3))
          {
            if (this.qQS == 4) {
              kL(false);
            }
            this.qQS = 3;
            cmc();
            kN(false);
            if (this.qQo != null) {
              this.qQo.setVisibility(8);
            }
          }
          clZ();
        }
        else
        {
          if (paramView.getId() != 2131827742) {
            break;
          }
          com.tencent.mm.plugin.report.service.h.qsU.e(11722, new Object[] { Integer.valueOf(3) });
          if ((!this.dZw) && (this.dZt != null)) {
            this.dZt.a(this.dZA, true);
          }
          if ((!com.tencent.mm.r.a.bO(this)) && (!com.tencent.mm.r.a.bM(this)) && (this.qQS != 4))
          {
            kL(true);
            this.qQS = 4;
            cmc();
            kN(false);
            if (this.qQo != null) {
              this.qQo.setVisibility(8);
            }
          }
        }
      }
      if ((paramView.getId() != 2131827744) && (paramView.getId() != 2131827731)) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(11722, new Object[] { Integer.valueOf(4) });
    } while (this.qQS == 5);
    this.qQS = 5;
    cmc();
    kN(false);
    if (this.qQo != null) {
      this.qQo.setVisibility(8);
    }
    if ((!Build.VERSION.RELEASE.equals("6.0")) && (!Build.VERSION.RELEASE.equals("6.0.0")) && (Build.VERSION.SDK_INT >= 23))
    {
      paramView = (LocationManager)ah.getContext().getSystemService("location");
      if (paramView == null) {
        break label729;
      }
    }
    label729:
    for (bool = paramView.isProviderEnabled("gps");; bool = true)
    {
      if (!bool) {
        Zk(getString(2131303583));
      }
      paramView = BluetoothAdapter.getDefaultAdapter();
      if ((paramView != null) && (paramView.getState() != 12))
      {
        Zk(getString(2131303582));
        break;
      }
      if (paramView != null) {
        break;
      }
      Zk(getString(2131303586));
      break;
      if (paramView.getId() != 2131827733) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(11722, new Object[] { Integer.valueOf(5) });
      if (this.qQS == 6) {
        break;
      }
      if (this.qQS == 4) {
        kL(false);
      }
      this.qQS = 6;
      cmc();
      kN(false);
      if (this.qQo != null) {
        this.qQo.setVisibility(8);
      }
      com.tencent.mm.x.c.PJ().y(262155, false);
      this.qQQ.setVisibility(8);
      break;
    }
  }
  
  private void kL(boolean paramBoolean)
  {
    AppMethodBeat.i(24826);
    String str = String.format("%1$s-shaketype-%2$d", new Object[] { getClass().getName(), Integer.valueOf(4) });
    ab.d("MicroMsg.ShakeReportUI", "activate change report , class name=" + str + ", isActive=" + paramBoolean);
    y.d(paramBoolean, new Intent().putExtra("classname", str));
    AppMethodBeat.o(24826);
  }
  
  private void kM(boolean paramBoolean)
  {
    AppMethodBeat.i(24829);
    kN(paramBoolean);
    kO(paramBoolean);
    AppMethodBeat.o(24829);
  }
  
  private void kN(boolean paramBoolean)
  {
    AppMethodBeat.i(24830);
    if (this.qQB == null) {
      this.qQB = findViewById(2131824817);
    }
    if ((this.qQm.qNc == 3) || (this.qQm.qNc == 4) || (this.qQm.qNc == 5) || (this.qQm.qNc == 6) || (!paramBoolean))
    {
      this.qQB.setVisibility(8);
      AppMethodBeat.o(24830);
      return;
    }
    int i = com.tencent.mm.bi.d.alk().bbZ();
    if (i <= 0)
    {
      this.qQB.setVisibility(8);
      AppMethodBeat.o(24830);
      return;
    }
    this.qQB.setVisibility(0);
    ((TextView)this.qQB.findViewById(2131824819)).setText(getResources().getQuantityString(2131361819, i, new Object[] { Integer.valueOf(i) }));
    this.qQB.setOnClickListener(new ShakeReportUI.8(this));
    if (this.qQF == null) {
      this.qQF = ((ImageView)findViewById(2131824818));
    }
    bt localbt = com.tencent.mm.bi.d.alk().dyP();
    if (localbt != null)
    {
      this.qQG = localbt.field_sayhiuser;
      a.b.c(this.qQF, this.qQG);
    }
    AppMethodBeat.o(24830);
  }
  
  private void kO(boolean paramBoolean)
  {
    AppMethodBeat.i(24831);
    if (this.qQC == null) {
      this.qQC = findViewById(2131824820);
    }
    if (!paramBoolean)
    {
      this.qQC.setVisibility(8);
      AppMethodBeat.o(24831);
      return;
    }
    int i = com.tencent.mm.plugin.shake.b.m.clo().bbZ();
    if (i <= 0)
    {
      this.qQC.setVisibility(8);
      AppMethodBeat.o(24831);
      return;
    }
    if (this.qQE == null) {
      this.qQE = ((TextView)this.qQC.findViewById(2131824822));
    }
    this.qQE.setText(getString(2131303607, new Object[] { Integer.valueOf(i) }));
    this.qQC.setOnClickListener(new ShakeReportUI.9(this));
    if (this.qQD == null) {
      this.qQD = ((MMImageView)findViewById(2131824821));
    }
    Object localObject = com.tencent.mm.plugin.shake.b.m.clo().cle();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.shake.b.f)localObject).field_thumburl;
      if (bo.isNullOrNil((String)localObject)) {
        break label255;
      }
      localObject = new com.tencent.mm.plugin.shake.e.b((String)localObject);
      Bitmap localBitmap = x.a((v)localObject);
      this.qQD.setTag(((com.tencent.mm.plugin.shake.e.b)localObject).aop());
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        break label242;
      }
      this.qQD.setImageBitmap(localBitmap);
    }
    for (;;)
    {
      this.qQC.setVisibility(0);
      AppMethodBeat.o(24831);
      return;
      label242:
      this.qQD.setImageResource(2131230829);
      continue;
      label255:
      this.qQD.setImageResource(2131230829);
    }
  }
  
  private void kP(boolean paramBoolean)
  {
    AppMethodBeat.i(24832);
    if (this.qQr != null)
    {
      if (paramBoolean)
      {
        this.qQr.setVisibility(0);
        AppMethodBeat.o(24832);
        return;
      }
      this.qQr.setVisibility(8);
      this.qQr.cancelLongPress();
    }
    AppMethodBeat.o(24832);
  }
  
  private void kQ(boolean paramBoolean)
  {
    AppMethodBeat.i(24833);
    if (this.qQp != null)
    {
      if (paramBoolean)
      {
        this.qQp.setVisibility(0);
        AppMethodBeat.o(24833);
        return;
      }
      this.qQp.setVisibility(4);
    }
    AppMethodBeat.o(24833);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.shake.c.a.e parame, long paramLong)
  {
    AppMethodBeat.i(24838);
    this.qRg = true;
    if (paramInt == 1251)
    {
      if (parame == null)
      {
        AppMethodBeat.o(24838);
        return;
      }
      ab.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_GetLbsCard");
      com.tencent.mm.plugin.shake.c.c.a.clh();
      cmj();
      cme();
      cmh();
      this.qRe = 4;
      com.tencent.mm.plugin.shake.b.m.clt().putValue("key_shake_card_item", parame);
      AppMethodBeat.o(24838);
      return;
    }
    Object localObject;
    if (paramInt == 1250)
    {
      if (parame == null)
      {
        this.qQK = null;
        Zk(null);
        AppMethodBeat.o(24838);
        return;
      }
      if (((parame == null) || (this.qQg)) && (!this.qQg))
      {
        this.qQK = null;
        Zk(null);
        AppMethodBeat.o(24838);
        return;
      }
      this.qQg = false;
      ab.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_ShakeCard");
      if (this.qQm.qNc == 6)
      {
        localObject = this.qQm.qNd;
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
      AppMethodBeat.o(24838);
      return;
      ab.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_OK");
      if (((com.tencent.mm.plugin.shake.c.a.g)localObject).knS == 3)
      {
        ab.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is  MMBIZ_SHAKE_CARD_ACTION_TYPE_NO_CARD");
        if ((parame != null) && (!TextUtils.isEmpty(parame.qNF)))
        {
          Zk(parame.qNF);
          AppMethodBeat.o(24838);
          return;
        }
        Zk(getString(2131303568));
        AppMethodBeat.o(24838);
        return;
      }
      ab.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is " + ((com.tencent.mm.plugin.shake.c.a.g)localObject).knS);
      Ds(3);
      if (parame.knS == 1) {
        this.qQi = false;
      }
      if ((this.qRf != null) && (this.qRf.isShowing()))
      {
        AppMethodBeat.o(24838);
        return;
      }
      if (parame.qNH)
      {
        localObject = (ViewStub)findViewById(2131827723);
        if (localObject != null) {
          ((ViewStub)localObject).inflate();
        }
        ((ShakeEggAnimFrame)findViewById(2131822795)).ag(this);
        new ak().postDelayed(new ShakeReportUI.15(this, parame), 1000L);
        AppMethodBeat.o(24838);
        return;
      }
      a(parame);
      AppMethodBeat.o(24838);
      return;
      ab.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_ERR_REPORT");
      Zk(getString(2131303568));
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(24843);
    a("", null);
    AppMethodBeat.o(24843);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(24842);
    cmd();
    if (!this.qQh) {
      kM(true);
    }
    AppMethodBeat.o(24842);
  }
  
  public final void aaq()
  {
    AppMethodBeat.i(24835);
    cmc();
    AppMethodBeat.o(24835);
  }
  
  public final void b(List<com.tencent.mm.plugin.shake.b.d> paramList, long paramLong)
  {
    AppMethodBeat.i(24837);
    cmm();
    if ((paramList == null) || (!this.qQg) || (paramLong == 6L))
    {
      this.qQK = null;
      if (paramLong == 6L)
      {
        Zk(getString(2131303587));
        AppMethodBeat.o(24837);
        return;
      }
      if (paramLong == 7L)
      {
        Zk(getString(2131303585));
        AppMethodBeat.o(24837);
        return;
      }
      if (paramLong == 8L)
      {
        Zk(getString(2131303583));
        AppMethodBeat.o(24837);
        return;
      }
      if (paramLong == 9L)
      {
        Zk(getString(2131303582));
        AppMethodBeat.o(24837);
        return;
      }
      if (paramLong == 10L)
      {
        Zk(getString(2131303586));
        AppMethodBeat.o(24837);
        return;
      }
      Zk(null);
      AppMethodBeat.o(24837);
      return;
    }
    this.qQg = false;
    if (paramList.size() > 0) {
      this.qQK = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0));
    }
    int i;
    Object localObject;
    if (this.qQm.qNc == 1)
    {
      if ((paramList.size() > 0) && (((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_type != 0))
      {
        Zk(null);
        AppMethodBeat.o(24837);
        return;
      }
      this.qQk = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).scene;
      i = paramList.size();
      if (i == 0)
      {
        Zk(null);
        AppMethodBeat.o(24837);
        return;
      }
      if (i == 1)
      {
        localObject = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_username;
        String str = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_nickname;
        ab.i("MicroMsg.ShakeReportUI", "1 u:" + (String)localObject + " n:" + str + " d:" + ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_distance);
        if (this.qQf) {
          ay.ax(getContext(), 2131303605);
        }
        Ds(3);
        c((com.tencent.mm.plugin.shake.b.d)paramList.get(0));
        AppMethodBeat.o(24837);
        return;
      }
      if (this.qQf) {
        ay.ax(getContext(), 2131303605);
      }
      Ds(3);
      kN(false);
      paramList = new Intent(this, ShakeItemListUI.class);
      paramList.putExtra("_key_show_type_", -1);
      paramList.putExtra("_key_title_", getString(2131303600));
      startActivity(paramList);
      AppMethodBeat.o(24837);
      return;
    }
    if (this.qQm.qNc == 3)
    {
      i = paramList.size();
      if (i == 0)
      {
        Zk(getString(2131303612));
        AppMethodBeat.o(24837);
        return;
      }
      if (i == 1)
      {
        if (this.qQf) {
          ay.ax(getContext(), 2131303605);
        }
        Ds(3);
        if (((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_type == 4)
        {
          paramList = com.tencent.mm.plugin.shake.d.a.i.d(((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_lvbuffer, paramLong);
          com.tencent.mm.aw.a.c(paramList);
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_mode", 1);
          ((Intent)localObject).putExtra("key_offset", paramList.fKk);
          ((Intent)localObject).putExtra("music_player_beg_time", paramList.fKC);
          ((Intent)localObject).putExtra("key_scene", 3);
          if (com.tencent.mm.aw.d.aiF()) {
            ((Intent)localObject).putExtra("KGlobalShakeMusic", true);
          }
          com.tencent.mm.bq.d.b(this, "music", ".ui.MusicMainUI", (Intent)localObject);
          AppMethodBeat.o(24837);
          return;
        }
        ab.w("MicroMsg.ShakeReportUI", "Unexpected type, ignore.");
      }
      AppMethodBeat.o(24837);
      return;
    }
    if (this.qQm.qNc == 4)
    {
      cmm();
      i = paramList.size();
      if (i == 0)
      {
        Zk(getString(2131303656));
        AppMethodBeat.o(24837);
        return;
      }
      if (i == 1)
      {
        if (this.qQf) {
          ay.ax(getContext(), 2131303605);
        }
        Ds(3);
        com.tencent.mm.plugin.shake.d.a.k.a((com.tencent.mm.plugin.shake.b.d)paramList.get(0), this);
      }
      AppMethodBeat.o(24837);
      return;
    }
    if (this.qQm.qNc == 5) {
      switch ((int)paramLong)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(24837);
      return;
      if ((!paramList.isEmpty()) && (((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_type == 11))
      {
        if (paramList.size() == 1)
        {
          if (this.qQf) {
            ay.ax(getContext(), 2131303605);
          }
          Ds(3);
          d((com.tencent.mm.plugin.shake.b.d)paramList.get(0));
          AppMethodBeat.o(24837);
          return;
        }
        if (this.qQf) {
          ay.ax(getContext(), 2131303605);
        }
        Ds(3);
        kN(false);
        localObject = new Intent(this, ShakeItemListUI.class);
        ((Intent)localObject).putExtra("_key_show_type_", -12);
        ((Intent)localObject).putExtra("_key_title_", getString(2131303598));
        ((Intent)localObject).putExtra("_key_show_from_shake_", true);
        ((Intent)localObject).putExtra("_ibeacon_new_insert_size", paramList.size());
        startActivity((Intent)localObject);
        AppMethodBeat.o(24837);
        return;
      }
      Zk(null);
      AppMethodBeat.o(24837);
      return;
      Zk(getString(2131303587));
    }
  }
  
  public final void clw()
  {
    AppMethodBeat.i(24847);
    com.tencent.mm.plugin.shake.c.c.a.clh();
    cme();
    cmf();
    cmi();
    cmj();
    cmh();
    AppMethodBeat.o(24847);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130970717;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24822);
    com.tencent.mm.plugin.shake.c.c.a.clh();
    this.qRh.put(Integer.valueOf(1), Boolean.TRUE);
    this.qRh.put(Integer.valueOf(3), Boolean.FALSE);
    this.qRh.put(Integer.valueOf(4), Boolean.FALSE);
    this.qRh.put(Integer.valueOf(5), Boolean.FALSE);
    this.qRh.put(Integer.valueOf(6), Boolean.FALSE);
    this.fGJ = new com.tencent.mm.at.a.a(this);
    this.qQq = ((TextView)findViewById(2131827718));
    this.qQp = findViewById(2131827719);
    this.qQr = ((TextView)findViewById(2131827721));
    this.qQs = ((TextView)findViewById(2131827720));
    this.qQU = findViewById(2131827746);
    this.qQV = ((ImageView)findViewById(2131827748));
    this.qQW = ((ImageView)findViewById(2131827750));
    this.qQX = ((ImageView)findViewById(2131827752));
    this.qQY = ((ImageView)findViewById(2131827754));
    this.qQZ = findViewById(2131827747);
    this.qRa = findViewById(2131827749);
    this.qRb = findViewById(2131827751);
    this.qRc = findViewById(2131827753);
    this.qQo = findViewById(2131827724);
    this.qQo.setOnClickListener(this.qRr);
    this.ehv = ((ImageView)this.qQo.findViewById(2131827725));
    this.ehv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24808);
        if (ShakeReportUI.q(ShakeReportUI.this) != 5)
        {
          paramAnonymousView = new Intent(ShakeReportUI.this.getContext(), ProfileHdHeadImg.class);
          paramAnonymousView.putExtra("username", (String)ShakeReportUI.r(ShakeReportUI.this).getTag());
          ShakeReportUI.this.startActivity(paramAnonymousView);
        }
        AppMethodBeat.o(24808);
      }
    });
    cma();
    Object localObject = View.inflate(getContext(), 2130970713, null);
    this.qQI = new com.tencent.mm.ui.base.i(getContext(), 2131493881);
    this.qQI.setContentView((View)localObject);
    this.qQI.setOnCancelListener(new ShakeReportUI.4(this));
    ((Button)((View)localObject).findViewById(2131827705)).setOnClickListener(new ShakeReportUI.5(this));
    aw.aaz();
    boolean bool1 = bo.e((Boolean)com.tencent.mm.model.c.Ru().get(4108, null));
    aw.aaz();
    boolean bool2 = bo.e((Boolean)com.tencent.mm.model.c.Ru().get(4117, null));
    if (!bool1)
    {
      ((View)localObject).setVisibility(0);
      this.qQI.show();
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(4108, Boolean.TRUE);
      setBackBtn(new ShakeReportUI.27(this));
      addIconOptionMenu(0, 2131296408, 2131230758, new ShakeReportUI.28(this));
      localObject = new ShakeReportUI.29(this);
      if ((!this.qRl) && (!this.qRj)) {
        break label772;
      }
    }
    label772:
    for (this.qQJ = ((ImageView)findViewById(2131827745));; this.qQJ = ((ImageView)findViewById(2131827732)))
    {
      this.qQL = ((ImageView)findViewById(2131827738));
      this.qQM = ((ImageView)findViewById(2131827740));
      this.qQN = ((ImageView)findViewById(2131827743));
      this.qQO = ((ImageView)findViewById(2131827734));
      this.qQR = ((TextView)findViewById(2131827736));
      this.qQQ = ((ImageView)findViewById(2131827735));
      this.qQP = ((ImageView)findViewById(2131827741));
      cmi();
      this.qRd.setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131827744).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131827737).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131827739).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131827742).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131827733).setOnClickListener((View.OnClickListener)localObject);
      com.tencent.mm.sdk.b.a.ymk.c(this.qRp);
      com.tencent.mm.sdk.b.a.ymk.c(this.qRq);
      cme();
      cmh();
      cmm();
      AppMethodBeat.o(24822);
      return;
      if (bool2) {
        break;
      }
      Looper.myQueue().addIdleHandler(new ShakeReportUI.6(this));
      break;
    }
  }
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(24846);
    if ((paramString == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(24846);
      return;
    }
    if ((this.qQD != null) && (this.qQD.getTag() != null) && (paramString.equals((String)this.qQD.getTag()))) {
      this.qQD.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(24846);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24841);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(24841);
      return;
    case 1: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(24841);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("CropImageMode", 4);
      localIntent.putExtra("CropImage_Filter", true);
      localIntent.putExtra("CropImage_DirectlyIntoFilter", true);
      StringBuilder localStringBuilder = new StringBuilder();
      aw.aaz();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.model.c.YK() + "custom_shake_img_filename.jpg");
      com.tencent.mm.plugin.shake.a.gmO.a(localIntent, 2, this, paramIntent);
      AppMethodBeat.o(24841);
      return;
    case 2: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(24841);
        return;
      }
      paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(4110, Boolean.FALSE);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(4111, paramIntent);
      cma();
      AppMethodBeat.o(24841);
      return;
    }
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
      {
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKH, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
        this.gzb = false;
        AppMethodBeat.o(24841);
        return;
      }
      this.gzb = true;
      finish();
      AppMethodBeat.o(24841);
      return;
    }
    this.gzb = true;
    finish();
    AppMethodBeat.o(24841);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24815);
    super.onCreate(paramBundle);
    setMMTitle(2131303623);
    setActionbarColor(getResources().getColor(2131689915));
    setNavigationbarColor(getResources().getColor(2131689915));
    hideActionbarLine();
    this.dZt = com.tencent.mm.modelgeo.d.agQ();
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yyL, "");
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yyM, "");
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yBq, "");
    this.qRd = findViewById(2131827731);
    paramBundle = bp.aba();
    Object localObject1 = bo.nullAsNil(paramBundle.fnC);
    Object localObject2 = bo.nullAsNil(paramBundle.fnB);
    paramBundle = com.tencent.mm.m.g.Nr().R("IBeacon", "GatedLaunch");
    int i;
    int j;
    if (!bo.isNullOrNil(paramBundle))
    {
      this.qRj = false;
      this.qRk = false;
      if (paramBundle != null) {}
      try
      {
        paramBundle = new JSONObject(paramBundle);
        i = paramBundle.getInt("gatedlaunch");
        aw.RG();
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
            Object localObject3 = com.tencent.mm.plugin.shake.b.m.cln();
            ((com.tencent.mm.plugin.shake.b.e)localObject3).cld();
            ((com.tencent.mm.plugin.shake.b.e)localObject3).a((com.tencent.mm.plugin.shake.b.d)localObject2, true);
            localObject3 = new LinkedList();
            ((List)localObject3).add(localObject2);
            b((List)localObject3, 1L);
            aw.aaz();
            com.tencent.mm.model.c.Ru().set(ac.a.yBb, "");
            paramBundle = paramBundle + "," + localObject1[4] + localObject1[5] + localObject1[6];
            aw.aaz();
            com.tencent.mm.model.c.Ru().set(ac.a.yBc, paramBundle);
            this.qQl = new c(getBodyView());
            this.shakeSensor = new com.tencent.mm.pluginsdk.i.d();
            if (!this.shakeSensor.dmL()) {
              com.tencent.mm.ui.base.h.a(this, 2131303614, 2131297087, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(24790);
                  ShakeReportUI.this.finish();
                  AppMethodBeat.o(24790);
                }
              });
            }
            if (com.tencent.mm.plugin.shake.a.gmP != null) {
              com.tencent.mm.plugin.shake.a.gmP.BO();
            }
            x.b(this);
            ab.i("MicroMsg.ShakeReportUI", "%s", new Object[] { getResources().getDisplayMetrics().toString() });
            i = com.tencent.mm.plugin.shake.b.m.clo().bbZ();
            com.tencent.mm.plugin.report.service.h.qsU.e(11317, new Object[] { Integer.valueOf(i), e.cmo() });
            com.tencent.mm.plugin.report.service.h.qsU.e(11710, new Object[] { Integer.valueOf(1) });
            com.tencent.mm.plugin.report.service.h.qsU.j(834L, 0L, 1L);
            AppMethodBeat.o(24815);
            return;
            if (i != 4) {
              continue;
            }
            this.qRj = true;
            this.qRk = true;
            continue;
            paramBundle = paramBundle;
            ab.e("MicroMsg.ShakeReportUI", "[shakezb]parse dymanic setting json fail!!");
            this.qRj = false;
            this.qRk = false;
            continue;
            this.qRm = 1;
            continue;
            com.tencent.mm.plugin.report.service.h.qsU.e(13139, new Object[] { localObject1, localObject2, Integer.valueOf(0), Integer.valueOf(this.qRm), Integer.valueOf(i), Integer.valueOf(j) });
            continue;
            if (paramBundle == null) {
              continue;
            }
            paramBundle.getState();
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            ab.e("MicroMsg.ShakeReportUI", "[kevinkma]parst shakeItem error!");
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
          this.qRj = true;
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
        this.qRj = true;
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
            this.qRk = true;
            this.qRj = true;
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
        this.qRk = true;
        this.qRj = true;
        break label1585;
        if (i == 3)
        {
          this.qRj = true;
          this.qRk = false;
          label493:
          if (aw.RG())
          {
            aw.aaz();
            if (((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yBi, Integer.valueOf(0))).intValue() == 1) {
              this.qRl = true;
            }
          }
          paramBundle = BluetoothAdapter.getDefaultAdapter();
          boolean bool = ah.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
          if ((paramBundle == null) || (!bool) || (Build.VERSION.SDK_INT < 18) || (paramBundle.getState() != 12)) {
            break label1450;
          }
          this.qRm = 0;
          if ((paramBundle == null) || (paramBundle.getState() != 12)) {
            break label1554;
          }
          i = 1;
          if (!bool) {
            break label1549;
          }
          j = 1;
          if (!this.qRj) {
            break label1458;
          }
          com.tencent.mm.plugin.report.service.h.qsU.e(13139, new Object[] { localObject1, localObject2, Integer.valueOf(1), Integer.valueOf(this.qRm), Integer.valueOf(i), Integer.valueOf(j) });
          if ((this.qRl) || (this.qRj))
          {
            this.qRi = true;
            this.qRd = findViewById(2131827744);
            if (this.qRk)
            {
              if ((paramBundle != null) && (paramBundle.getState() == 12)) {
                break label1516;
              }
              this.qRi = false;
            }
          }
          paramBundle = com.tencent.mm.plugin.shake.b.m.cls();
          if (paramBundle.kkV == null) {
            paramBundle.kkV = new ArrayList();
          }
          paramBundle.kkV.add(new WeakReference(this));
          paramBundle = Boolean.FALSE;
          long l3 = bo.aox();
          long l2 = 0L;
          long l1 = 0L;
          if (aw.RG())
          {
            aw.aaz();
            com.tencent.mm.model.c.Ru().set(ac.a.yBf, Boolean.TRUE);
            aw.aaz();
            bool = bo.a((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yBd, null), false);
            aw.aaz();
            l2 = bo.a((Long)com.tencent.mm.model.c.Ru().get(ac.a.yBe, null), 0L);
            aw.aaz();
            l1 = bo.a((Long)com.tencent.mm.model.c.Ru().get(ac.a.yAY, null), 0L);
            paramBundle = Boolean.valueOf(bool);
          }
          if ((!paramBundle.booleanValue()) || (l3 - l2 >= l1)) {
            break label1542;
          }
          this.qQS = 5;
          this.qRi = true;
          this.qQg = true;
          initView();
          cmc();
          aw.aaz();
          paramBundle = bo.bf((String)com.tencent.mm.model.c.Ru().get(ac.a.yBc, null), "");
          aw.aaz();
          localObject1 = bo.bf((String)com.tencent.mm.model.c.Ru().get(ac.a.yBb, null), "");
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
    AppMethodBeat.i(24819);
    if ((this.qQH != null) && (!this.qQH.isRecycled())) {
      this.qQH.recycle();
    }
    if ((this.qQI != null) && (this.qQI.isShowing()))
    {
      this.qQI.dismiss();
      this.qQI = null;
    }
    if (this.qQm.qNd != null) {
      this.qQm.qNd.ckR();
    }
    if (this.shakeSensor != null)
    {
      this.shakeSensor.bjf();
      this.shakeSensor = null;
    }
    Object localObject = com.tencent.mm.plugin.shake.d.a.j.a(null);
    if (com.tencent.mm.plugin.shake.d.a.j.isInited)
    {
      com.tencent.mm.plugin.shake.d.a.j.isInited = false;
      if (!((com.tencent.mm.plugin.shake.d.a.j)localObject).qPf.clP()) {
        ab.e("Micromsg.ShakeMusicMgr", "release MusicFingerPrintRecorder error");
      }
    }
    com.tencent.mm.plugin.shake.d.a.j.qPg = null;
    x.c(this);
    com.tencent.mm.sdk.b.a.ymk.d(this.qRp);
    com.tencent.mm.sdk.b.a.ymk.d(this.qRq);
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yBf, Boolean.FALSE);
    clY();
    if (com.tencent.mm.plugin.shake.c.c.a.clN()) {
      com.tencent.mm.x.c.PJ().y(262154, false);
    }
    cmg();
    localObject = com.tencent.mm.plugin.shake.b.m.cls();
    int i;
    if (((com.tencent.mm.plugin.shake.c.a.f)localObject).kkV != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < ((com.tencent.mm.plugin.shake.c.a.f)localObject).kkV.size())
      {
        WeakReference localWeakReference = (WeakReference)((com.tencent.mm.plugin.shake.c.a.f)localObject).kkV.get(i);
        if (localWeakReference != null)
        {
          f.a locala = (f.a)localWeakReference.get();
          if ((locala != null) && (locala.equals(this))) {
            ((com.tencent.mm.plugin.shake.c.a.f)localObject).kkV.remove(localWeakReference);
          }
        }
      }
      else
      {
        localObject = com.tencent.mm.plugin.shake.b.m.clt();
        ((com.tencent.mm.plugin.shake.c.a.d)localObject).dZu = -85.0F;
        ((com.tencent.mm.plugin.shake.c.a.d)localObject).dZv = -1000.0F;
        if (this.dZt != null) {
          this.dZt.c(this.dZA);
        }
        super.onDestroy();
        AppMethodBeat.o(24819);
        return;
      }
      i += 1;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(24818);
    aw.aaz();
    com.tencent.mm.model.c.b(this);
    aw.aaz();
    com.tencent.mm.model.c.Ru().b(this);
    com.tencent.mm.plugin.shake.b.m.cln().remove(this);
    if (this.qQm.qNd != null) {
      this.qQm.qNd.pause();
    }
    this.qQi = false;
    if (this.shakeSensor != null) {
      this.shakeSensor.bjf();
    }
    this.qQl.clU();
    if (this.qQS != 5)
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(327696, this.qQS);
    }
    if (this.qQS == 4) {
      kL(false);
    }
    clY();
    super.onPause();
    AppMethodBeat.o(24818);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(24858);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.ShakeReportUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(24858);
      return;
    }
    ab.i("MicroMsg.ShakeReportUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24858);
      return;
      if (paramArrayOfInt[0] != 0)
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131302075), getString(2131302083), getString(2131300996), getString(2131297837), false, new ShakeReportUI.19(this), new ShakeReportUI.20(this));
        AppMethodBeat.o(24858);
        return;
        if (paramArrayOfInt[0] == 0)
        {
          ceV();
          AppMethodBeat.o(24858);
          return;
        }
        this.gzb = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131302073), getString(2131302083), getString(2131300996), getString(2131297837), false, new ShakeReportUI.21(this), new ShakeReportUI.23(this));
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(24816);
    super.onResume();
    if (this.gzb) {
      if (com.tencent.mm.au.b.tM((String)com.tencent.mm.kernel.g.RL().Ru().get(274436, null)))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.ACCESS_COARSE_LOCATION"))
        {
          if (!((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKH, Boolean.FALSE)).booleanValue())
          {
            com.tencent.mm.plugin.account.a.b.a.b(this, getString(2131306183, new Object[] { aa.dsG() }), 30764, true);
            AppMethodBeat.o(24816);
            return;
          }
          com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
          AppMethodBeat.o(24816);
        }
      }
      else
      {
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "");
        ab.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkposition[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this });
        if (!bool)
        {
          AppMethodBeat.o(24816);
          return;
        }
      }
    }
    ceV();
    AppMethodBeat.o(24816);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI
 * JD-Core Version:    0.7.0.1
 */