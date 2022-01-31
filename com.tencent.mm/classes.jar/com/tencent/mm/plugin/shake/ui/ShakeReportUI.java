package com.tencent.mm.plugin.shake.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.Cursor;
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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.dq;
import com.tencent.mm.h.a.dr;
import com.tencent.mm.h.a.dx;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.c;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bn;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.d.a.h.a;
import com.tencent.mm.plugin.shake.d.a.k.1;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c.a;
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
  implements aq, x.a, l.a, com.tencent.mm.plugin.shake.c.a.f.a, j.a, m.b
{
  private static List<h.a> die = new CopyOnWriteArrayList();
  private com.tencent.mm.modelgeo.c dhZ;
  private boolean dic = false;
  private Map<String, h.a> did = new ConcurrentHashMap();
  private a.a dig = new a.a()
  {
    public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
    {
      if (paramAnonymousBoolean)
      {
        y.d("MicroMsg.ShakeReportUI", "on location get ok");
        com.tencent.mm.model.au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.uoP, String.valueOf(paramAnonymousFloat2));
        com.tencent.mm.model.au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.uoQ, String.valueOf(paramAnonymousFloat1));
        com.tencent.mm.model.au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.urr, String.valueOf(paramAnonymousDouble2));
        ShakeReportUI.a(ShakeReportUI.this);
        if (ShakeReportUI.b(ShakeReportUI.this) != null) {
          ShakeReportUI.b(ShakeReportUI.this).c(ShakeReportUI.c(ShakeReportUI.this));
        }
      }
      for (;;)
      {
        return false;
        y.w("MicroMsg.ShakeReportUI", "getLocation fail");
      }
    }
  };
  private ImageView dpY;
  private com.tencent.mm.as.a.a eqj = null;
  private boolean fht = true;
  private com.tencent.mm.pluginsdk.i.c mBT;
  private boolean obW = false;
  private boolean obX = false;
  private boolean obY;
  private boolean obZ = false;
  private String ocA = "";
  private Bitmap ocB = null;
  private Dialog ocC;
  private ImageView ocD = null;
  private com.tencent.mm.plugin.shake.b.d ocE = null;
  private ImageView ocF;
  private ImageView ocG;
  private ImageView ocH;
  private ImageView ocI;
  private ImageView ocJ;
  private ImageView ocK;
  private TextView ocL;
  private int ocM = 1;
  private int ocN = 0;
  private View ocO;
  private ImageView ocP;
  private ImageView ocQ;
  private ImageView ocR;
  private ImageView ocS;
  private View ocT;
  private View ocU;
  private View ocV;
  private View ocW;
  private View ocX = null;
  private int ocY = 0;
  private com.tencent.mm.plugin.shake.c.b.a ocZ;
  private boolean oca = false;
  private boolean ocb = false;
  private boolean occ = false;
  private int ocd = 22;
  private c oce;
  private com.tencent.mm.plugin.shake.b.l ocf = new com.tencent.mm.plugin.shake.b.l();
  private com.tencent.mm.pluginsdk.ui.f ocg;
  private View och;
  private View oci;
  private TextView ocj;
  private TextView ock;
  private TextView ocl;
  private View ocm;
  private View ocn;
  private View oco;
  private View ocp;
  private Animation ocr;
  private Animation ocs;
  private Animation oct;
  private Animation ocu;
  private View ocv = null;
  private View ocw = null;
  private MMImageView ocx = null;
  private TextView ocy = null;
  private ImageView ocz = null;
  private boolean oda = false;
  @SuppressLint({"UseSparseArrays"})
  private Map<Integer, Boolean> odb = new HashMap();
  private boolean odc = false;
  private boolean odd = false;
  private boolean ode = false;
  private boolean odf = false;
  private int odg = 1;
  private long odh = 0L;
  private boolean odi = false;
  private com.tencent.mm.sdk.b.c odj = new com.tencent.mm.sdk.b.c() {};
  private com.tencent.mm.sdk.b.c odk = new com.tencent.mm.sdk.b.c() {};
  private View.OnClickListener odl = new ShakeReportUI.18(this);
  
  private void MC(String paramString)
  {
    this.obZ = false;
    if (this.obY) {
      com.tencent.mm.sdk.platformtools.au.G(this.mController.uMN, R.l.shake_nomatch);
    }
    if (this.ocu == null) {
      this.ocu = AnimationUtils.loadAnimation(this.mController.uMN, R.a.faded_out);
    }
    xs(2);
    if ((paramString != null) && (paramString.length() > 1)) {
      this.ock.setText(paramString);
    }
    for (;;)
    {
      this.ock.startAnimation(this.ocu);
      this.occ = true;
      ai.l(new ShakeReportUI.14(this), this.ocu.getDuration());
      return;
      this.ock.setText(R.l.shake_getfial);
    }
  }
  
  private void a(com.tencent.mm.plugin.shake.c.a.e parame)
  {
    this.ocZ = com.tencent.mm.plugin.shake.c.b.a.a(this, parame, new ShakeReportUI.16(this), new ShakeReportUI.17(this));
  }
  
  private void aV(String paramString, boolean paramBoolean)
  {
    this.obZ = false;
    if (this.ocu == null) {
      this.ocu = AnimationUtils.loadAnimation(this.mController.uMN, R.a.faded_out);
    }
    xs(2);
    iL(true);
    if ((paramString != null) && (paramString.length() > 1)) {
      this.ock.setText(paramString);
    }
    for (;;)
    {
      this.occ = true;
      return;
      if (paramBoolean)
      {
        this.ock.setText(R.l.shake_card_init_tips);
      }
      else
      {
        this.ock.setText("");
        iL(false);
      }
    }
  }
  
  private void bAD()
  {
    if (!bAP()) {
      break label6;
    }
    for (;;)
    {
      label6:
      return;
      if (BluetoothAdapter.getDefaultAdapter() != null)
      {
        Object localObject = com.tencent.mm.m.g.AB().Aq();
        if (localObject == null) {
          break;
        }
        this.odh = System.currentTimeMillis();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          y.i("MicroMsg.ShakeReportUI", "op=true,iBeacon = %s", new Object[] { str });
          dq localdq = new dq();
          localdq.bKd.bKf = str;
          localdq.bKd.bKc = true;
          com.tencent.mm.sdk.b.a.udP.m(localdq);
        }
      }
    }
  }
  
  private void bAE()
  {
    com.tencent.mm.model.au.Hx();
    if (!Boolean.valueOf(bk.a((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.ure, null), false)).booleanValue())
    {
      this.did.clear();
      die = new CopyOnWriteArrayList();
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      Object localObject = com.tencent.mm.m.g.AB().Aq();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          dq localdq = new dq();
          y.i("MicroMsg.ShakeReportUI", "op=false,iBeacon = %s", new Object[] { str });
          localdq.bKd.bKf = str;
          localdq.bKd.bKc = false;
          com.tencent.mm.sdk.b.a.udP.m(localdq);
        }
      }
    }
  }
  
  private void bAF()
  {
    com.tencent.mm.model.au.Hx();
    int j = bk.a((Integer)com.tencent.mm.model.c.Dz().get(12290, null), 0);
    ImageView localImageView = (ImageView)findViewById(R.h.shake_report_bg_img);
    if ((this.ocB != null) && (!this.ocB.isRecycled())) {
      this.ocB.recycle();
    }
    com.tencent.mm.model.au.Hx();
    Object localObject1;
    if (bk.c((Boolean)com.tencent.mm.model.c.Dz().get(4110, null)))
    {
      localObject1 = new StringBuilder();
      com.tencent.mm.model.au.Hx();
      localObject1 = com.tencent.mm.model.c.FG() + "default_shake_img_filename.jpg";
      if (com.tencent.mm.vfs.e.bK((String)localObject1))
      {
        this.ocB = com.tencent.mm.platformtools.x.pg((String)localObject1);
        localImageView.setImageDrawable(new BitmapDrawable(this.ocB));
        localObject1 = (ImageView)findViewById(R.h.shake_logo_up);
        localImageView = (ImageView)findViewById(R.h.shake_logo_down);
        if (j != 2) {
          break label382;
        }
        i = R.g.shake_logo_female_up;
        label173:
        ((ImageView)localObject1).setImageResource(i);
        if (j != 2) {
          break label389;
        }
      }
    }
    label389:
    for (int i = R.g.shake_logo_female_down;; i = R.g.shake_logo_down)
    {
      for (;;)
      {
        localImageView.setImageResource(i);
        ShakeReportUI.7 local7 = new ShakeReportUI.7(this);
        ((ImageView)localObject1).setOnClickListener(local7);
        localImageView.setOnClickListener(local7);
        if (this.oco == null) {
          this.oco = findViewById(R.h.shake_line_down);
        }
        this.oco.setOnClickListener(local7);
        if (this.ocp == null) {
          this.ocp = findViewById(R.h.shake_line_up);
        }
        this.ocp.setOnClickListener(local7);
        return;
        try
        {
          localObject1 = new BitmapDrawable(com.tencent.mm.sdk.platformtools.c.decodeStream(this.mController.uMN.getAssets().open("resource/shakehideimg_man.jpg")));
          localImageView.setImageDrawable((Drawable)localObject1);
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            y.w("MicroMsg.ShakeReportUI", "Bg decode exp:" + localIOException.getLocalizedMessage());
            Object localObject2 = null;
          }
        }
      }
      com.tencent.mm.model.au.Hx();
      this.ocB = com.tencent.mm.platformtools.x.pg((String)com.tencent.mm.model.c.Dz().get(4111, null));
      localImageView.setImageDrawable(new BitmapDrawable(this.ocB));
      break;
      label382:
      i = R.g.shake_logo_up;
      break label173;
    }
  }
  
  private void bAG()
  {
    if ((this.ocM == 3) && (com.tencent.mm.av.d.PB()))
    {
      this.ocM = 3;
      this.ocl.setText(R.l.shake_searching_music_tips);
      this.ocD.setBackgroundResource(R.g.shake_icon_ibeacon);
      this.ocF.setBackgroundResource(R.g.shake_icon_people);
      this.ocG.setBackgroundResource(R.g.shake_icon_music_hl);
      this.ocH.setBackgroundResource(R.g.shake_icon_tv);
      this.ocI.setBackgroundResource(R.g.shake_cardpack_icon);
      findViewById(R.h.shake_report_bottom_tabs_ll).setVisibility(0);
      setMMTitle(R.l.shake_report_title_music);
      com.tencent.mm.plugin.report.service.h.nFQ.f(11720, new Object[] { Integer.valueOf(2) });
      com.tencent.mm.plugin.report.service.h.nFQ.h(834L, 2L, 1L);
    }
    Object localObject1;
    int i;
    Object localObject2;
    for (;;)
    {
      localObject1 = this.ocf;
      i = this.ocM;
      if (i != ((com.tencent.mm.plugin.shake.b.l)localObject1).nYS) {
        break;
      }
      localObject1 = ((com.tencent.mm.plugin.shake.b.l)localObject1).nYT;
      if (!this.obZ) {
        iM(false);
      }
      if ((com.tencent.mm.plugin.shake.c.c.a.bAt()) && ((localObject1 instanceof com.tencent.mm.plugin.shake.c.a.g)))
      {
        localObject2 = (com.tencent.mm.plugin.shake.c.a.g)localObject1;
        i = this.ocY;
        ((com.tencent.mm.plugin.shake.c.a.g)localObject2).drX = i;
        y.i("MicroMsg.ShakeCardService", "ShakeCardService from_scene:" + i);
        if (this.ocY == 3)
        {
          y.i("MicroMsg.ShakeReportUI", "open shake card from specialview");
          localObject1 = (com.tencent.mm.plugin.shake.c.a.g)localObject1;
          localObject2 = getIntent().getStringExtra("key_shake_card_ext_info");
          if ((localObject2 == null) || (((String)localObject2).length() > 256)) {
            break label973;
          }
          y.i("MicroMsg.ShakeCardService", "ShakeCardService mExtInfo:" + ((com.tencent.mm.plugin.shake.c.a.g)localObject1).ghS);
          ((com.tencent.mm.plugin.shake.c.a.g)localObject1).ghS = ((String)localObject2);
        }
      }
      return;
      if ((this.ocM == 4) && (com.tencent.mm.plugin.shake.d.a.k.bzS()))
      {
        this.ocM = 4;
        this.ocl.setText(R.l.shake_searching_tv_tips);
        this.ocD.setBackgroundResource(R.g.shake_icon_ibeacon);
        this.ocF.setBackgroundResource(R.g.shake_icon_people);
        this.ocG.setBackgroundResource(R.g.shake_icon_music);
        this.ocH.setBackgroundResource(R.g.shake_icon_tv_hl);
        this.ocI.setBackgroundResource(R.g.shake_cardpack_icon);
        findViewById(R.h.shake_report_bottom_tabs_ll).setVisibility(0);
        setMMTitle(R.l.shake_report_title_tv);
        com.tencent.mm.plugin.report.service.h.nFQ.f(11720, new Object[] { Integer.valueOf(3) });
        com.tencent.mm.plugin.report.service.h.nFQ.h(834L, 3L, 1L);
      }
      else if ((this.ocM == 5) && (bAO()))
      {
        this.ocM = 5;
        this.ocl.setText(R.l.shake_searching_ibeacon_tips);
        this.ocD.setBackgroundResource(R.g.shake_icon_ibeacon_hl);
        this.ocF.setBackgroundResource(R.g.shake_icon_people);
        this.ocG.setBackgroundResource(R.g.shake_icon_music);
        this.ocH.setBackgroundResource(R.g.shake_icon_tv);
        this.ocI.setBackgroundResource(R.g.shake_cardpack_icon);
        findViewById(R.h.shake_report_bottom_tabs_ll).setVisibility(0);
        setMMTitle(R.l.shake_report_title_ibeacon);
        com.tencent.mm.plugin.report.service.h.nFQ.f(11720, new Object[] { Integer.valueOf(4) });
        com.tencent.mm.plugin.report.service.h.nFQ.h(834L, 4L, 1L);
      }
      else if ((this.ocM == 6) && (com.tencent.mm.plugin.shake.c.c.a.bAt()))
      {
        this.ocM = 6;
        this.ocl.setText(R.l.shake_searching_card_tips);
        this.ocD.setBackgroundResource(R.g.shake_icon_ibeacon);
        this.ocF.setBackgroundResource(R.g.shake_icon_people);
        this.ocG.setBackgroundResource(R.g.shake_icon_music);
        this.ocH.setBackgroundResource(R.g.shake_icon_tv);
        this.ocI.setBackgroundResource(R.g.shake_cardpack_iconhl);
        findViewById(R.h.shake_report_bottom_tabs_ll).setVisibility(0);
        setMMTitle(R.l.shake_report_title_card);
        bAJ();
        bAM();
        com.tencent.mm.plugin.report.service.h.nFQ.f(11720, new Object[] { Integer.valueOf(5) });
        com.tencent.mm.plugin.report.service.h.nFQ.h(834L, 5L, 1L);
      }
      else
      {
        this.ocM = 1;
        this.ocl.setText(R.l.shake_finding);
        this.ocD.setBackgroundResource(R.g.shake_icon_ibeacon);
        this.ocF.setBackgroundResource(R.g.shake_icon_people_hl);
        this.ocG.setBackgroundResource(R.g.shake_icon_music);
        this.ocH.setBackgroundResource(R.g.shake_icon_tv);
        this.ocI.setBackgroundResource(R.g.shake_cardpack_icon);
        if (com.tencent.mm.av.d.PB()) {
          findViewById(R.h.shake_report_bottom_tabs_ll).setVisibility(0);
        }
        setMMTitle(R.l.shake_report_title);
        com.tencent.mm.plugin.report.service.h.nFQ.f(11720, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.h.nFQ.h(834L, 1L, 1L);
      }
    }
    if (((com.tencent.mm.plugin.shake.b.l)localObject1).nYT != null) {
      ((com.tencent.mm.plugin.shake.b.l)localObject1).nYT.bzH();
    }
    switch (i)
    {
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.shake.b.l)localObject1).nYS = i;
      ((com.tencent.mm.plugin.shake.b.l)localObject1).nYT.init();
      localObject1 = ((com.tencent.mm.plugin.shake.b.l)localObject1).nYT;
      break;
      ((com.tencent.mm.plugin.shake.b.l)localObject1).nYT = new com.tencent.mm.plugin.shake.b.c(this, this);
      continue;
      ((com.tencent.mm.plugin.shake.b.l)localObject1).nYT = com.tencent.mm.plugin.shake.d.a.j.a(this);
      continue;
      ((com.tencent.mm.plugin.shake.b.l)localObject1).nYT = new com.tencent.mm.plugin.shake.d.a.l(this, this);
      continue;
      ((com.tencent.mm.plugin.shake.b.l)localObject1).nYT = new com.tencent.mm.plugin.shake.d.a.h(this);
      continue;
      ((com.tencent.mm.plugin.shake.b.l)localObject1).nYT = new com.tencent.mm.plugin.shake.c.a.g(this);
    }
    label973:
    y.i("MicroMsg.ShakeCardService", "ShakeCardService ext_info size > 256 byte, extinfo:" + (String)localObject2);
  }
  
  private void bAH()
  {
    com.tencent.mm.model.au.Hx();
    this.obY = bk.c((Boolean)com.tencent.mm.model.c.Dz().get(4112, null));
    if (this.obY)
    {
      setTitleMuteIconVisibility(8);
      return;
    }
    setTitleMuteIconVisibility(0);
  }
  
  private void bAI()
  {
    if (com.tencent.mm.plugin.shake.c.c.a.bAt())
    {
      if (com.tencent.mm.y.c.BS().bc(262155, 266259)) {
        this.ocK.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.ocK.setVisibility(8);
  }
  
  private void bAJ()
  {
    boolean bool2;
    if ((this.ocM == 6) && (com.tencent.mm.plugin.shake.c.c.a.bAt()))
    {
      boolean bool1 = com.tencent.mm.y.c.BS().bc(262154, 266258);
      bool2 = com.tencent.mm.y.c.BS().bc(262155, 266259);
      if (!bool1) {
        break label54;
      }
      aV(com.tencent.mm.plugin.shake.c.c.a.bAo(), true);
    }
    label54:
    do
    {
      return;
      if (bool2)
      {
        aV(com.tencent.mm.plugin.shake.c.c.a.bAq(), true);
        return;
      }
    } while (this.oda);
    if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.bAm()))
    {
      aV(com.tencent.mm.plugin.shake.c.c.a.bAm(), true);
      return;
    }
    aV(getString(R.l.shake_card_init_tips), true);
  }
  
  private void bAK()
  {
    if ((this.ocZ != null) && (this.ocZ.isShowing())) {
      this.ocZ.dismiss();
    }
    this.ocZ = null;
  }
  
  private void bAL()
  {
    int m = 1;
    boolean bool1 = com.tencent.mm.plugin.shake.c.c.a.bzP();
    boolean bool2 = com.tencent.mm.y.c.BS().bc(262154, 266258);
    boolean bool3 = com.tencent.mm.y.c.BS().bc(262155, 266259);
    if (getIntent().getBooleanExtra("shake_card", false)) {}
    for (int i = getIntent().getIntExtra("shake_card", 0);; i = 0)
    {
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.nFQ;
      int j;
      if (bool2)
      {
        j = 1;
        if (!bool1) {
          break label219;
        }
        k = 1;
        label81:
        localh.f(11668, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), com.tencent.mm.plugin.shake.c.c.a.bAp(), Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.bAl()) });
        localh = com.tencent.mm.plugin.report.service.h.nFQ;
        if (!bool3) {
          break label224;
        }
        j = 1;
        label149:
        if (!bool1) {
          break label229;
        }
      }
      label219:
      label224:
      label229:
      for (int k = m;; k = 0)
      {
        localh.f(11668, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), com.tencent.mm.plugin.shake.c.c.a.bAp(), Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.bAl()) });
        return;
        j = 0;
        break;
        k = 0;
        break label81;
        j = 0;
        break label149;
      }
    }
  }
  
  private void bAM()
  {
    if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.bAn())) {
      this.ocL.setText(com.tencent.mm.plugin.shake.c.c.a.bAn());
    }
  }
  
  private void bAN()
  {
    label119:
    Object localObject;
    label164:
    label206:
    int i;
    if (com.tencent.mm.av.d.PB())
    {
      y.i("MicroMsg.ShakeReportUI", "is not oversea user, show shake music");
      this.odb.put(Integer.valueOf(3), Boolean.valueOf(true));
      findViewById(R.h.shake_report_tab_music_ll).setVisibility(0);
      if (com.tencent.mm.av.d.PC())
      {
        com.tencent.mm.model.au.Hx();
        if (com.tencent.mm.model.c.Dz().getInt(4118, 0) == 0) {
          this.ocJ.setVisibility(0);
        }
      }
      else
      {
        if (!com.tencent.mm.plugin.shake.d.a.k.bzS()) {
          break label308;
        }
        this.odb.put(Integer.valueOf(4), Boolean.valueOf(true));
        findViewById(R.h.shake_report_tab_tv_ll).setVisibility(0);
        y.i("MicroMsg.ShakeReportUI", "show shake tv tab");
        if (!com.tencent.mm.plugin.shake.c.c.a.bAt()) {
          break label350;
        }
        this.odb.put(Integer.valueOf(6), Boolean.valueOf(true));
        findViewById(R.h.shake_report_tab_card_ll).setVisibility(0);
        y.i("MicroMsg.ShakeReportUI", "show shake card tab");
        if (!bAO()) {
          break label393;
        }
        this.odb.put(Integer.valueOf(5), Boolean.valueOf(true));
        this.ocX.setVisibility(0);
        y.i("MicroMsg.ShakeReportUI", "[shakezb]show shake ibeacon tab");
        localObject = this.odb.values().iterator();
        i = 0;
        label223:
        if (!((Iterator)localObject).hasNext()) {
          break label432;
        }
        if (!((Boolean)((Iterator)localObject).next()).booleanValue()) {
          break label557;
        }
        i += 1;
      }
    }
    label393:
    label557:
    for (;;)
    {
      break label223;
      this.ocJ.setVisibility(8);
      break;
      this.odb.put(Integer.valueOf(3), Boolean.valueOf(false));
      findViewById(R.h.shake_report_tab_music_ll).setVisibility(8);
      y.i("MicroMsg.ShakeReportUI", "is oversea user, hide shake music");
      break;
      label308:
      this.odb.put(Integer.valueOf(4), Boolean.valueOf(false));
      findViewById(R.h.shake_report_tab_tv_ll).setVisibility(8);
      y.i("MicroMsg.ShakeReportUI", "hide shake tv tab");
      break label119;
      label350:
      findViewById(R.h.shake_report_tab_card_ll).setVisibility(8);
      this.odb.put(Integer.valueOf(6), Boolean.valueOf(false));
      y.i("MicroMsg.ShakeReportUI", "hide shake card tab");
      break label164;
      this.odb.put(Integer.valueOf(5), Boolean.valueOf(false));
      this.ocX.setVisibility(8);
      y.i("MicroMsg.ShakeReportUI", "[shakezb]hide shake ibeacon tab");
      break label206;
      label432:
      this.ocN = i;
      localObject = (LinearLayout)findViewById(R.h.shake_report_bottom_tabs_ll);
      if (i == 1)
      {
        ((LinearLayout)localObject).setVisibility(8);
        if ((i <= 4) || (!this.odi)) {
          break label511;
        }
        findViewById(R.h.shake_report_tab_tv_ll).setVisibility(8);
        y.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() > 0.");
        this.ocN -= 1;
      }
      label511:
      while ((i <= 4) || (this.odi))
      {
        return;
        ((LinearLayout)localObject).setVisibility(0);
        break;
      }
      this.ocX.setVisibility(8);
      this.odc = false;
      this.ocN -= 1;
      y.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() <= 0.");
      return;
    }
  }
  
  private boolean bAO()
  {
    y.i("MicroMsg.ShakeReportUI", "[shakezb] isChineseAppLang :" + com.tencent.mm.sdk.platformtools.x.cqF() + " ,getApplicationLanguage[en or zh_CN or zh_HK or zh_TW is avaliable] :" + com.tencent.mm.sdk.platformtools.x.cqJ());
    return (this.odc) && (bAP());
  }
  
  private static boolean bAP()
  {
    return (com.tencent.mm.sdk.platformtools.x.cqF()) || (com.tencent.mm.sdk.platformtools.x.cqJ().equals("en")) || (com.tencent.mm.sdk.platformtools.x.cqJ().equals("ja"));
  }
  
  private void bAQ()
  {
    this.ocO.setVisibility(8);
  }
  
  private void buJ()
  {
    bAF();
    com.tencent.mm.model.au.Hx();
    com.tencent.mm.model.c.a(this);
    com.tencent.mm.model.au.Hx();
    com.tencent.mm.model.c.Dz().a(this);
    com.tencent.mm.plugin.shake.b.m.bzU().c(this);
    if (this.ocf.nYT != null) {
      this.ocf.nYT.resume();
    }
    this.ocb = true;
    if ((this.ocZ != null) && (this.ocZ.isShowing()) && (!this.ocZ.oab)) {
      this.ocb = false;
    }
    y.i("MicroMsg.ShakeReportUI", "tryStartShake");
    Object localObject;
    label290:
    boolean bool;
    if ((this.mBT != null) && (!this.mBT.clU()))
    {
      this.mBT.a(new ShakeReportUI.a(this));
      if ((this.mBT.clW()) && (this.ocj != null)) {
        this.ocj.setText(getString(R.l.shake_a_friend));
      }
    }
    else
    {
      new ah().postDelayed(new ShakeReportUI.22(this), 1000L);
      if (this.mBT != null) {
        this.mBT.clV();
      }
      iL(false);
      iM(false);
      bAH();
      com.tencent.mm.model.au.Hx();
      localObject = (String)com.tencent.mm.model.c.Dz().get(327696, "1");
      if (com.tencent.mm.plugin.shake.d.a.k.bzS())
      {
        if (this.ocM == 4) {
          iI(true);
        }
        if (((String)localObject).equals("4")) {
          cL(findViewById(R.h.shake_report_tab_tv_ll));
        }
      }
      if (!((String)localObject).equals("3")) {
        break label437;
      }
      cL(findViewById(R.h.shake_report_tab_music_ll));
      bool = com.tencent.mm.y.c.BS().bc(262154, 266258);
      if ((!getIntent().getBooleanExtra("shake_music", false)) || (!com.tencent.mm.av.d.PB()) || (this.ocf.nYS == 3)) {
        break label467;
      }
      getIntent().putExtra("shake_music", false);
      this.ocM = 3;
    }
    for (;;)
    {
      bAG();
      iJ(true);
      y.d("MicroMsg.ShakeReportUI", "isShakeGetConfigList = %s", new Object[] { Boolean.valueOf(com.tencent.mm.platformtools.ae.eSF) });
      if (com.tencent.mm.platformtools.ae.eSF)
      {
        localObject = new com.tencent.mm.az.k(7);
        com.tencent.mm.model.au.Dk().a((com.tencent.mm.ah.m)localObject, 0);
      }
      bAQ();
      bAN();
      bAD();
      return;
      this.ocj.setText(getString(R.l.shake_not_support));
      break;
      label437:
      if ((!((String)localObject).equals("6")) || (!com.tencent.mm.plugin.shake.c.c.a.bAt())) {
        break label290;
      }
      cL(findViewById(R.h.shake_report_tab_card_ll));
      break label290;
      label467:
      if ((getIntent().getBooleanExtra("shake_tv", false)) && (this.ocf.nYS != 4) && (com.tencent.mm.plugin.shake.d.a.k.bzS()))
      {
        getIntent().putExtra("shake_tv", false);
        this.ocM = 4;
      }
      else if ((this.ocf.nYS != 6) && (com.tencent.mm.plugin.shake.c.c.a.bAt()) && ((bool) || (getIntent().getBooleanExtra("shake_card", false))))
      {
        this.ocY = getIntent().getIntExtra("shake_card", 0);
        getIntent().putExtra("shake_card", false);
        y.i("MicroMsg.ShakeReportUI", "onresume shake card tab is open, activity type is 0 or open from specialview");
        this.ocM = 6;
      }
    }
  }
  
  private void cL(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 80, "", "");
      y.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this });
    } while (!bool);
    aV("", false);
    if (paramView.getId() == R.h.shake_report_tab_friend_ll)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(11722, new Object[] { Integer.valueOf(1) });
      if (this.ocM != 1)
      {
        if (this.ocM == 4) {
          iI(false);
        }
        this.ocM = 1;
        bAG();
        iK(false);
        if (this.och != null) {
          this.och.setVisibility(8);
        }
      }
    }
    do
    {
      for (;;)
      {
        iJ(true);
        iM(false);
        bAQ();
        return;
        if (paramView.getId() == R.h.shake_report_tab_music_ll)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.f(11722, new Object[] { Integer.valueOf(2) });
          if ((!this.dic) && (this.dhZ != null)) {
            this.dhZ.a(this.dig, true);
          }
          if ((!com.tencent.mm.r.a.bk(this)) && (!com.tencent.mm.r.a.bi(this)) && (this.ocM != 3))
          {
            if (this.ocM == 4) {
              iI(false);
            }
            this.ocM = 3;
            bAG();
            iK(false);
            if (this.och != null) {
              this.och.setVisibility(8);
            }
          }
          if (com.tencent.mm.av.d.PC())
          {
            com.tencent.mm.model.au.Hx();
            if (com.tencent.mm.model.c.Dz().getInt(4118, 0) == 0)
            {
              paramView = new c.a(this.mController.uMN);
              paramView.Ip(R.l.app_tip);
              paramView.Iq(R.l.shake_info_music);
              paramView.Is(R.l.shake_info_known).a(new ShakeReportUI.2(this));
              paramView.nW(true);
              paramView.e(new ShakeReportUI.3(this));
              this.ocC = paramView.aoP();
              this.ocC.show();
            }
          }
        }
        else
        {
          if (paramView.getId() != R.h.shake_report_tab_tv_ll) {
            break;
          }
          com.tencent.mm.plugin.report.service.h.nFQ.f(11722, new Object[] { Integer.valueOf(3) });
          if ((!this.dic) && (this.dhZ != null)) {
            this.dhZ.a(this.dig, true);
          }
          if ((!com.tencent.mm.r.a.bk(this)) && (!com.tencent.mm.r.a.bi(this)) && (this.ocM != 4))
          {
            iI(true);
            this.ocM = 4;
            bAG();
            iK(false);
            if (this.och != null) {
              this.och.setVisibility(8);
            }
          }
        }
      }
      if ((paramView.getId() != R.h.shake_report_tab_ibeacon_ll) && (paramView.getId() != R.h.shake_report_tab_ibeacon_first_ll)) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(11722, new Object[] { Integer.valueOf(4) });
    } while (this.ocM == 5);
    this.ocM = 5;
    bAG();
    iK(false);
    if (this.och != null) {
      this.och.setVisibility(8);
    }
    if ((!Build.VERSION.RELEASE.equals("6.0")) && (!Build.VERSION.RELEASE.equals("6.0.0")) && (Build.VERSION.SDK_INT >= 23))
    {
      paramView = (LocationManager)com.tencent.mm.sdk.platformtools.ae.getContext().getSystemService("location");
      if (paramView == null) {
        break label807;
      }
    }
    label807:
    for (boolean bool = paramView.isProviderEnabled("gps");; bool = true)
    {
      if (!bool) {
        MC(getString(R.l.shake_ibeacon_gps_off));
      }
      paramView = BluetoothAdapter.getDefaultAdapter();
      if ((paramView != null) && (paramView.getState() != 12))
      {
        MC(getString(R.l.shake_ibeacon_bluetooth_off));
        break;
      }
      if (paramView != null) {
        break;
      }
      MC(getString(R.l.shake_ibeacon_not_support));
      break;
      if (paramView.getId() != R.h.shake_report_tab_card_ll) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(11722, new Object[] { Integer.valueOf(5) });
      if (this.ocM == 6) {
        break;
      }
      if (this.ocM == 4) {
        iI(false);
      }
      this.ocM = 6;
      bAG();
      iK(false);
      if (this.och != null) {
        this.och.setVisibility(8);
      }
      com.tencent.mm.y.c.BS().w(262155, false);
      this.ocK.setVisibility(8);
      break;
    }
  }
  
  private void iI(boolean paramBoolean)
  {
    String str = String.format("%1$s-shaketype-%2$d", new Object[] { getClass().getName(), Integer.valueOf(4) });
    y.d("MicroMsg.ShakeReportUI", "activate change report , class name=" + str + ", isActive=" + paramBoolean);
    com.tencent.mm.ui.base.x.b(paramBoolean, new Intent().putExtra("classname", str));
  }
  
  private void iJ(boolean paramBoolean)
  {
    Object localObject1 = null;
    iK(paramBoolean);
    if (this.ocw == null) {
      this.ocw = findViewById(R.h.goto_shake_msg_btn);
    }
    if (!paramBoolean)
    {
      this.ocw.setVisibility(8);
      return;
    }
    int i = com.tencent.mm.plugin.shake.b.m.bzV().aAo();
    if (i <= 0)
    {
      this.ocw.setVisibility(8);
      return;
    }
    if (this.ocy == null) {
      this.ocy = ((TextView)this.ocw.findViewById(R.h.shake_msg_count));
    }
    this.ocy.setText(getString(R.l.shake_msg_count_text, new Object[] { Integer.valueOf(i) }));
    this.ocw.setOnClickListener(new ShakeReportUI.9(this));
    if (this.ocx == null) {
      this.ocx = ((MMImageView)findViewById(R.h.shake_msg_thumb));
    }
    Object localObject2 = com.tencent.mm.plugin.shake.b.m.bzV();
    String str = "SELECT * FROM " + ((com.tencent.mm.plugin.shake.b.g)localObject2).getTableName() + " where status != 1 ORDER BY rowid DESC LIMIT 1";
    localObject2 = ((com.tencent.mm.plugin.shake.b.g)localObject2).dXw.a(str, null, 2);
    if (localObject2 == null)
    {
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.shake.b.f)localObject1).field_thumburl;
        if (bk.bl((String)localObject1)) {
          break label320;
        }
        localObject1 = new com.tencent.mm.plugin.shake.e.b((String)localObject1);
        localObject2 = com.tencent.mm.platformtools.x.a((v)localObject1);
        this.ocx.setTag(((com.tencent.mm.plugin.shake.e.b)localObject1).UQ());
        if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled())) {
          this.ocx.setImageBitmap((Bitmap)localObject2);
        }
      }
      else
      {
        label264:
        this.ocw.setVisibility(0);
      }
    }
    else
    {
      if (!((Cursor)localObject2).moveToFirst()) {
        break label333;
      }
      localObject1 = new com.tencent.mm.plugin.shake.b.f();
      ((com.tencent.mm.plugin.shake.b.f)localObject1).d((Cursor)localObject2);
    }
    for (;;)
    {
      ((Cursor)localObject2).close();
      break;
      this.ocx.setImageResource(R.k.app_attach_file_icon_webpage);
      break label264;
      label320:
      this.ocx.setImageResource(R.k.app_attach_file_icon_webpage);
      break label264;
      label333:
      localObject1 = null;
    }
  }
  
  private void iK(boolean paramBoolean)
  {
    if (this.ocv == null) {
      this.ocv = findViewById(R.h.goto_sayhi_btn);
    }
    if ((this.ocf.nYS == 3) || (this.ocf.nYS == 4) || (this.ocf.nYS == 5) || (this.ocf.nYS == 6) || (!paramBoolean)) {
      this.ocv.setVisibility(8);
    }
    bt localbt;
    do
    {
      return;
      int i = com.tencent.mm.bh.d.Sa().aAo();
      if (i <= 0)
      {
        this.ocv.setVisibility(8);
        return;
      }
      this.ocv.setVisibility(0);
      ((TextView)this.ocv.findViewById(R.h.say_hi_count)).setText(getResources().getQuantityString(R.j.say_hi_count_text_quantity, i, new Object[] { Integer.valueOf(i) }));
      this.ocv.setOnClickListener(new ShakeReportUI.8(this));
      if (this.ocz == null) {
        this.ocz = ((ImageView)findViewById(R.h.match_dlg_img));
      }
      localbt = com.tencent.mm.bh.d.Sa().cwd();
    } while (localbt == null);
    this.ocA = localbt.field_sayhiuser;
    a.b.a(this.ocz, this.ocA);
  }
  
  private void iL(boolean paramBoolean)
  {
    if (this.ock != null)
    {
      if (paramBoolean) {
        this.ock.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.ock.setVisibility(8);
    this.ock.cancelLongPress();
  }
  
  private void iM(boolean paramBoolean)
  {
    if (this.oci != null)
    {
      if (paramBoolean) {
        this.oci.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.oci.setVisibility(4);
  }
  
  private void xs(int paramInt)
  {
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      iM(bool);
      if (paramInt != 2) {
        break;
      }
      iL(true);
      return;
    }
    iL(false);
  }
  
  public final void Hn()
  {
    bAG();
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.shake.c.a.e parame, long paramLong)
  {
    this.oda = true;
    if (paramInt == 1251) {
      if (parame != null) {}
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            y.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_GetLbsCard");
            com.tencent.mm.plugin.shake.c.c.a.bzO();
            bAN();
            bAI();
            bAL();
            this.ocY = 4;
            com.tencent.mm.plugin.shake.b.m.bAa().putValue("key_shake_card_item", parame);
            return;
          } while (paramInt != 1250);
          if (parame == null)
          {
            this.ocE = null;
            MC(null);
            return;
          }
          if (((parame == null) || (this.obZ)) && (!this.obZ))
          {
            this.ocE = null;
            MC(null);
            return;
          }
          this.obZ = false;
          y.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_ShakeCard");
        } while (this.ocf.nYS != 6);
        localObject = this.ocf.nYT;
      } while ((localObject == null) || (!(localObject instanceof com.tencent.mm.plugin.shake.c.a.g)));
      localObject = (com.tencent.mm.plugin.shake.c.a.g)localObject;
      switch ((int)paramLong)
      {
      default: 
        return;
      case 1: 
        y.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_OK");
        if (((com.tencent.mm.plugin.shake.c.a.g)localObject).imX == 3)
        {
          y.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is  MMBIZ_SHAKE_CARD_ACTION_TYPE_NO_CARD");
          if ((parame != null) && (!TextUtils.isEmpty(parame.nZv)))
          {
            MC(parame.nZv);
            return;
          }
          MC(getString(R.l.shake_card_fail_tip));
          return;
        }
        y.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is " + ((com.tencent.mm.plugin.shake.c.a.g)localObject).imX);
        xs(3);
        if (parame.imX == 1) {
          this.ocb = false;
        }
        break;
      }
    } while ((this.ocZ != null) && (this.ocZ.isShowing()));
    if (parame.nZx)
    {
      localObject = (ViewStub)findViewById(R.h.viewstub_egg_animframe);
      if (localObject != null) {
        ((ViewStub)localObject).inflate();
      }
      ((ShakeEggAnimFrame)findViewById(R.h.chatting_anim_iv)).L(this);
      new ah().postDelayed(new ShakeReportUI.15(this, parame), 1000L);
      return;
    }
    a(parame);
    return;
    y.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_ERR_REPORT");
    MC(getString(R.l.shake_card_fail_tip));
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    a("", null);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.l paraml)
  {
    bAH();
    if (!this.oca) {
      iJ(true);
    }
  }
  
  public final void a(List<com.tencent.mm.plugin.shake.b.d> paramList, long paramLong)
  {
    bAQ();
    if ((paramList == null) || (!this.obZ) || (paramLong == 6L))
    {
      this.ocE = null;
      if (paramLong == 6L) {
        MC(getString(R.l.shake_ibeacon_over_frequency_tips));
      }
    }
    label522:
    label582:
    label737:
    label767:
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              return;
              if (paramLong == 7L)
              {
                MC(getString(R.l.shake_ibeacon_no_activity));
                return;
              }
              if (paramLong == 8L)
              {
                MC(getString(R.l.shake_ibeacon_gps_off));
                return;
              }
              if (paramLong == 9L)
              {
                MC(getString(R.l.shake_ibeacon_bluetooth_off));
                return;
              }
              if (paramLong == 10L)
              {
                MC(getString(R.l.shake_ibeacon_not_support));
                return;
              }
              MC(null);
              return;
              this.obZ = false;
              if (paramList.size() > 0) {
                this.ocE = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0));
              }
              if (this.ocf.nYS != 1) {
                break label1101;
              }
              if ((paramList.size() > 0) && (((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_type != 0))
              {
                MC(null);
                return;
              }
              this.ocd = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).scene;
              i = paramList.size();
              if (i == 0)
              {
                MC(null);
                return;
              }
              if (i != 1) {
                break;
              }
              localObject1 = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_username;
              localObject2 = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_nickname;
              y.i("MicroMsg.ShakeReportUI", "1 u:" + (String)localObject1 + " n:" + (String)localObject2 + " d:" + ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_distance);
              if (this.obY) {
                com.tencent.mm.sdk.platformtools.au.G(this.mController.uMN, R.l.shake_match);
              }
              xs(3);
              localObject1 = (com.tencent.mm.plugin.shake.b.d)paramList.get(0);
            } while (bk.bl(((com.tencent.mm.plugin.shake.b.d)localObject1).field_username));
            this.och.setTag(((com.tencent.mm.plugin.shake.b.d)localObject1).field_username);
            this.och.setVisibility(0);
            com.tencent.mm.model.au.Hx();
            Object localObject2 = com.tencent.mm.model.c.Fw().abl(((com.tencent.mm.plugin.shake.b.d)localObject1).field_username);
            Object localObject3 = new StringBuilder().append(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
            if (com.tencent.mm.n.a.gR(((ao)localObject2).field_type))
            {
              paramList = getString(R.l.shake_match_isfriend);
              localObject3 = paramList;
              if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex != 1) {
                break label880;
              }
              this.och.setContentDescription((String)localObject3 + ((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance + this.mController.uMN.getString(R.l.shake_sex_male));
              TextView localTextView = (TextView)this.och.findViewById(R.h.shake_match_dlg_nickname);
              AppCompatActivity localAppCompatActivity = this.mController.uMN;
              StringBuilder localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
              if (!com.tencent.mm.n.a.gR(((ao)localObject2).field_type)) {
                break label971;
              }
              paramList = getString(R.l.shake_match_isfriend);
              localTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.a(localAppCompatActivity, paramList, localTextView.getTextSize()));
              if (this.dpY != null)
              {
                if (bk.bl((String)localObject3)) {
                  break label977;
                }
                this.dpY.setContentDescription(String.format(getString(R.l.shake_avatar), new Object[] { localObject3 }));
              }
              ((TextView)this.och.findViewById(R.h.shake_match_dlg_distance)).setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance);
              a.b.a((ImageView)this.och.findViewById(R.h.shake_match_dlg_img), ((com.tencent.mm.plugin.shake.b.d)localObject1).field_username);
              paramList = (ImageView)this.och.findViewById(R.h.shake_match_dlg_vinfo_iv);
              if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1 == 0) {
                break label994;
              }
              paramList.setVisibility(0);
              paramList.setImageBitmap(BackwardSupportUtil.b.e(am.a.dVA.hL(((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1), 2.0F));
              if ((((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1 != 0) || (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex == 0)) {
                break label1011;
              }
              if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex != 1) {
                break label1003;
              }
              i = R.k.ic_sex_male;
              paramList = com.tencent.mm.cb.a.g(this, i);
              this.och.findViewById(R.h.shake_match_dlg_sex_iv).setVisibility(0);
              ((ImageView)this.och.findViewById(R.h.shake_match_dlg_sex_iv)).setImageDrawable(paramList);
            }
            for (;;)
            {
              if (((com.tencent.mm.plugin.shake.b.d)localObject1).getProvince() == null)
              {
                y.e("MicroMsg.ShakeReportUI", "PROVINCE NULL");
                ((com.tencent.mm.plugin.shake.b.d)localObject1).field_province = "";
              }
              if (((com.tencent.mm.plugin.shake.b.d)localObject1).getCity() == null)
              {
                y.e("MicroMsg.ShakeReportUI", "CITY NULL");
                ((com.tencent.mm.plugin.shake.b.d)localObject1).field_city = "";
              }
              this.och.startAnimation(AnimationUtils.loadAnimation(this.mController.uMN, R.a.shake_report_dlg_translate_in));
              return;
              paramList = "";
              break;
              if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex == 2)
              {
                this.och.setContentDescription((String)localObject3 + ((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance + this.mController.uMN.getString(R.l.shake_sex_female));
                break label522;
              }
              this.och.setContentDescription((String)localObject3 + ((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance);
              break label522;
              paramList = "";
              break label582;
              this.dpY.setContentDescription(getString(R.l.shake_avatar_unknow));
              break label647;
              paramList.setVisibility(8);
              break label737;
              i = R.k.ic_sex_female;
              break label767;
              this.och.findViewById(R.h.shake_match_dlg_sex_iv).setVisibility(8);
            }
            if (this.obY) {
              com.tencent.mm.sdk.platformtools.au.G(this.mController.uMN, R.l.shake_match);
            }
            xs(3);
            iK(false);
            paramList = new Intent(this, ShakeItemListUI.class);
            paramList.putExtra("_key_show_type_", -1);
            paramList.putExtra("_key_title_", getString(R.l.shake_item_shake_person_list));
            startActivity(paramList);
            return;
            if (this.ocf.nYS != 3) {
              break;
            }
            i = paramList.size();
            if (i == 0)
            {
              MC(getString(R.l.shake_music_no_match));
              return;
            }
          } while (i != 1);
          if (this.obY) {
            com.tencent.mm.sdk.platformtools.au.G(this.mController.uMN, R.l.shake_match);
          }
          xs(3);
          if (((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_type == 4)
          {
            paramList = com.tencent.mm.plugin.shake.d.a.i.d(((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_lvbuffer, paramLong);
            com.tencent.mm.av.a.c(paramList);
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("key_mode", 1);
            ((Intent)localObject1).putExtra("key_offset", paramList.euy);
            ((Intent)localObject1).putExtra("music_player_beg_time", paramList.euQ);
            ((Intent)localObject1).putExtra("key_scene", 3);
            if (com.tencent.mm.av.d.PC()) {
              ((Intent)localObject1).putExtra("KGlobalShakeMusic", true);
            }
            com.tencent.mm.br.d.b(this, "music", ".ui.MusicMainUI", (Intent)localObject1);
            return;
          }
          y.w("MicroMsg.ShakeReportUI", "Unexpected type, ignore.");
          return;
          if (this.ocf.nYS != 4) {
            break;
          }
          bAQ();
          i = paramList.size();
          if (i == 0)
          {
            MC(getString(R.l.shake_tv_no_match));
            return;
          }
        } while (i != 1);
        if (this.obY) {
          com.tencent.mm.sdk.platformtools.au.G(this.mController.uMN, R.l.shake_match);
        }
        xs(3);
        paramList = (com.tencent.mm.plugin.shake.b.d)paramList.get(0);
        new ah().postDelayed(new k.1(paramList, this), 100L);
        return;
      } while (this.ocf.nYS != 5);
      switch ((int)paramLong)
      {
      default: 
        return;
      case 1: 
        if ((paramList.isEmpty()) || (((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_type != 11)) {
          break label1767;
        }
        if (paramList.size() != 1) {
          break label1665;
        }
        if (this.obY) {
          com.tencent.mm.sdk.platformtools.au.G(this.mController.uMN, R.l.shake_match);
        }
        xs(3);
        paramList = (com.tencent.mm.plugin.shake.b.d)paramList.get(0);
      }
    } while (bk.bl(paramList.field_username));
    label647:
    label880:
    label1011:
    this.och.setTag(paramList.field_username);
    label971:
    label977:
    label994:
    label1003:
    ((TextView)this.och.findViewById(R.h.shake_match_dlg_nickname)).setText(paramList.field_username);
    label1101:
    this.och.setContentDescription(bk.pm(paramList.field_nickname));
    ((TextView)this.och.findViewById(R.h.shake_match_dlg_distance)).setText(paramList.field_signature);
    this.eqj.a(paramList.getProvince(), (ImageView)this.och.findViewById(R.h.shake_match_dlg_img));
    this.och.findViewById(R.h.shake_match_dlg_sex_iv).setVisibility(8);
    this.och.startAnimation(AnimationUtils.loadAnimation(this.mController.uMN, R.a.shake_report_dlg_translate_in));
    this.och.setVisibility(0);
    return;
    label1665:
    if (this.obY) {
      com.tencent.mm.sdk.platformtools.au.G(this.mController.uMN, R.l.shake_match);
    }
    xs(3);
    iK(false);
    Object localObject1 = new Intent(this, ShakeItemListUI.class);
    ((Intent)localObject1).putExtra("_key_show_type_", -12);
    ((Intent)localObject1).putExtra("_key_title_", getString(R.l.shake_item_shake_ibeacon));
    ((Intent)localObject1).putExtra("_key_show_from_shake_", true);
    ((Intent)localObject1).putExtra("_ibeacon_new_insert_size", paramList.size());
    startActivity((Intent)localObject1);
    return;
    label1767:
    MC(null);
    return;
    MC(getString(R.l.shake_ibeacon_over_frequency_tips));
  }
  
  public final void bAd()
  {
    com.tencent.mm.plugin.shake.c.c.a.bzO();
    bAI();
    bAJ();
    bAM();
    bAN();
    bAL();
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.shake_report;
  }
  
  protected final void initView()
  {
    com.tencent.mm.plugin.shake.c.c.a.bzO();
    this.odb.put(Integer.valueOf(1), Boolean.valueOf(true));
    this.odb.put(Integer.valueOf(3), Boolean.valueOf(false));
    this.odb.put(Integer.valueOf(4), Boolean.valueOf(false));
    this.odb.put(Integer.valueOf(5), Boolean.valueOf(false));
    this.odb.put(Integer.valueOf(6), Boolean.valueOf(false));
    this.eqj = new com.tencent.mm.as.a.a(this);
    this.ocj = ((TextView)findViewById(R.h.shake_report_static));
    this.oci = findViewById(R.h.shake_report_waiting);
    this.ock = ((TextView)findViewById(R.h.shake_report_anim));
    this.ocl = ((TextView)findViewById(R.h.shake_report_shaking_tips));
    this.ocO = findViewById(R.h.shake_tv_history_ll);
    this.ocP = ((ImageView)findViewById(R.h.shake_tv_history_icon1));
    this.ocQ = ((ImageView)findViewById(R.h.shake_tv_history_icon2));
    this.ocR = ((ImageView)findViewById(R.h.shake_tv_history_icon3));
    this.ocS = ((ImageView)findViewById(R.h.shake_tv_history_icon_more));
    this.ocT = findViewById(R.h.shake_tv_history_icon1_ll);
    this.ocU = findViewById(R.h.shake_tv_history_icon2_ll);
    this.ocV = findViewById(R.h.shake_tv_history_icon3_ll);
    this.ocW = findViewById(R.h.shake_tv_history_icon_more_ll);
    this.och = findViewById(R.h.shake_report_card);
    this.och.setOnClickListener(this.odl);
    this.dpY = ((ImageView)this.och.findViewById(R.h.shake_match_dlg_img));
    this.dpY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (ShakeReportUI.o(ShakeReportUI.this) != 5)
        {
          ShakeReportUI.a(ShakeReportUI.this, new com.tencent.mm.pluginsdk.ui.f(ShakeReportUI.this, (String)ShakeReportUI.p(ShakeReportUI.this).getTag(), null, com.tencent.mm.pluginsdk.ui.f.a.rZN));
          ShakeReportUI.q(ShakeReportUI.this).cmi();
        }
      }
    });
    bAF();
    Object localObject = View.inflate(this.mController.uMN, R.i.shake_info_dialog_view, null);
    this.ocC = new com.tencent.mm.ui.base.i(this.mController.uMN, R.m.mmalertdialog);
    this.ocC.setContentView((View)localObject);
    this.ocC.setOnCancelListener(new ShakeReportUI.4(this));
    ((Button)((View)localObject).findViewById(R.h.shake_info_close)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        ShakeReportUI.r(ShakeReportUI.this).cancel();
      }
    });
    com.tencent.mm.model.au.Hx();
    boolean bool1 = bk.d((Boolean)com.tencent.mm.model.c.Dz().get(4108, null));
    com.tencent.mm.model.au.Hx();
    boolean bool2 = bk.d((Boolean)com.tencent.mm.model.c.Dz().get(4117, null));
    if (!bool1)
    {
      ((View)localObject).setVisibility(0);
      this.ocC.show();
      com.tencent.mm.model.au.Hx();
      com.tencent.mm.model.c.Dz().o(4108, Boolean.valueOf(true));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          ShakeReportUI.a(ShakeReportUI.this, false);
          ShakeReportUI.this.finish();
          return true;
        }
      });
      addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, new ShakeReportUI.28(this));
      localObject = new ShakeReportUI.29(this);
      if ((!this.odf) && (!this.odd)) {
        break label772;
      }
    }
    label772:
    for (this.ocD = ((ImageView)findViewById(R.h.shake_report_tab_ibeacon_image_view));; this.ocD = ((ImageView)findViewById(R.h.shake_report_tab_ibeacon_image_first_view)))
    {
      this.ocF = ((ImageView)findViewById(R.h.shake_report_tab_friend));
      this.ocG = ((ImageView)findViewById(R.h.shake_report_tab_music));
      this.ocH = ((ImageView)findViewById(R.h.shake_report_tab_tv));
      this.ocI = ((ImageView)findViewById(R.h.shake_report_tab_card));
      this.ocL = ((TextView)findViewById(R.h.shake_report_tab_card_tv));
      this.ocK = ((ImageView)findViewById(R.h.shake_report_tab_card_red_dot));
      this.ocJ = ((ImageView)findViewById(R.h.shake_report_tab_music_red_dot));
      bAM();
      this.ocX.setOnClickListener((View.OnClickListener)localObject);
      findViewById(R.h.shake_report_tab_ibeacon_ll).setOnClickListener((View.OnClickListener)localObject);
      findViewById(R.h.shake_report_tab_friend_ll).setOnClickListener((View.OnClickListener)localObject);
      findViewById(R.h.shake_report_tab_music_ll).setOnClickListener((View.OnClickListener)localObject);
      findViewById(R.h.shake_report_tab_tv_ll).setOnClickListener((View.OnClickListener)localObject);
      findViewById(R.h.shake_report_tab_card_ll).setOnClickListener((View.OnClickListener)localObject);
      com.tencent.mm.sdk.b.a.udP.c(this.odj);
      com.tencent.mm.sdk.b.a.udP.c(this.odk);
      bAI();
      bAL();
      bAQ();
      return;
      if (bool2) {
        break;
      }
      Looper.myQueue().addIdleHandler(new ShakeReportUI.6(this));
      break;
    }
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    if ((paramString == null) || (paramBitmap == null) || (paramBitmap.isRecycled())) {}
    while ((this.ocx == null) || (this.ocx.getTag() == null) || (!paramString.equals((String)this.ocx.getTag()))) {
      return;
    }
    this.ocx.setImageBitmap(paramBitmap);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return;
        } while (paramIntent == null);
        Intent localIntent = new Intent();
        localIntent.putExtra("CropImageMode", 4);
        localIntent.putExtra("CropImage_Filter", true);
        localIntent.putExtra("CropImage_DirectlyIntoFilter", true);
        StringBuilder localStringBuilder = new StringBuilder();
        com.tencent.mm.model.au.Hx();
        localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.model.c.FG() + "custom_shake_img_filename.jpg");
        com.tencent.mm.plugin.shake.a.eUR.a(localIntent, 2, this, paramIntent);
        return;
      } while (paramIntent == null);
      paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
      com.tencent.mm.model.au.Hx();
      com.tencent.mm.model.c.Dz().o(4110, Boolean.valueOf(false));
      com.tencent.mm.model.au.Hx();
      com.tencent.mm.model.c.Dz().o(4111, paramIntent);
      bAF();
      return;
    }
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
      {
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uzP, Boolean.valueOf(true));
        com.tencent.mm.pluginsdk.permission.a.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
        this.fht = false;
        return;
      }
      this.fht = true;
      finish();
      return;
    }
    this.fht = true;
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.shake_report_title);
    ta(getResources().getColor(R.e.dark_actionbar_color));
    czo();
    this.dhZ = com.tencent.mm.modelgeo.c.Ob();
    com.tencent.mm.model.au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.uoP, "");
    com.tencent.mm.model.au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.uoQ, "");
    com.tencent.mm.model.au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.urr, "");
    this.ocX = findViewById(R.h.shake_report_tab_ibeacon_first_ll);
    paramBundle = bn.Id();
    Object localObject1 = bk.pm(paramBundle.dXv);
    Object localObject2 = bk.pm(paramBundle.dXu);
    paramBundle = com.tencent.mm.m.g.AB().H("IBeacon", "GatedLaunch");
    int i;
    int j;
    if (!bk.bl(paramBundle))
    {
      this.odd = false;
      this.ode = false;
      if (paramBundle != null) {}
      try
      {
        paramBundle = new JSONObject(paramBundle);
        i = paramBundle.getInt("gatedlaunch");
        com.tencent.mm.model.au.DK();
        if (i == 0) {
          break label473;
        }
        if (i != 1) {
          break label311;
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
            label283:
            label311:
            label332:
            ((com.tencent.mm.plugin.shake.b.d)localObject2).field_lvbuffer = (String.valueOf(localObject1[4]) + "," + String.valueOf(localObject1[5]) + "," + String.valueOf(localObject1[6])).getBytes("utf-8");
            ((com.tencent.mm.plugin.shake.b.d)localObject2).field_insertBatch = 2;
            Object localObject3 = com.tencent.mm.plugin.shake.b.m.bzU();
            ((com.tencent.mm.plugin.shake.b.e)localObject3).bzM();
            ((com.tencent.mm.plugin.shake.b.e)localObject3).a((com.tencent.mm.plugin.shake.b.d)localObject2, true);
            localObject3 = new LinkedList();
            ((List)localObject3).add(localObject2);
            a((List)localObject3, 1L);
            com.tencent.mm.model.au.Hx();
            com.tencent.mm.model.c.Dz().c(ac.a.ura, "");
            paramBundle = paramBundle + "," + localObject1[4] + localObject1[5] + localObject1[6];
            com.tencent.mm.model.au.Hx();
            com.tencent.mm.model.c.Dz().c(ac.a.urb, paramBundle);
            this.oce = new c(this.mController.uMz);
            this.mBT = new com.tencent.mm.pluginsdk.i.c(this);
            if (!this.mBT.clW()) {
              com.tencent.mm.ui.base.h.a(this, R.l.shake_not_support, R.l.app_tip, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  ShakeReportUI.this.finish();
                }
              });
            }
            if (com.tencent.mm.plugin.shake.a.eUS != null) {
              com.tencent.mm.plugin.shake.a.eUS.tk();
            }
            com.tencent.mm.platformtools.x.b(this);
            y.i("MicroMsg.ShakeReportUI", "%s", new Object[] { getResources().getDisplayMetrics().toString() });
            i = com.tencent.mm.plugin.shake.b.m.bzV().aAo();
            com.tencent.mm.plugin.report.service.h.nFQ.f(11317, new Object[] { Integer.valueOf(i), e.bAS() });
            com.tencent.mm.plugin.report.service.h.nFQ.f(11710, new Object[] { Integer.valueOf(1) });
            com.tencent.mm.plugin.report.service.h.nFQ.h(834L, 0L, 1L);
            return;
            if (i != 4) {
              continue;
            }
            this.odd = true;
            this.ode = true;
            continue;
            paramBundle = paramBundle;
            y.e("MicroMsg.ShakeReportUI", "[shakezb]parse dymanic setting json fail!!");
            this.odd = false;
            this.ode = false;
            continue;
            this.odg = 1;
            continue;
            com.tencent.mm.plugin.report.service.h.nFQ.f(13139, new Object[] { localObject1, localObject2, Integer.valueOf(0), Integer.valueOf(this.odg), Integer.valueOf(i), Integer.valueOf(j) });
            continue;
            if (paramBundle == null) {
              continue;
            }
            paramBundle.getState();
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            y.e("MicroMsg.ShakeReportUI", "[kevinkma]parst shakeItem error!");
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
          this.odd = true;
          break label1543;
        }
        if ((!str.equals(localObject1)) || (j != 0)) {
          break label1543;
        }
        localObject3 = ((JSONObject)localObject3).getJSONArray("cities");
        m = ((JSONArray)localObject3).length();
        j = 0;
        if (j >= m) {
          break label1543;
        }
        if (!((JSONArray)localObject3).getString(j).equals(localObject2)) {
          break label1555;
        }
        this.odd = true;
        break label1555;
        if (i == 2)
        {
          paramBundle = paramBundle.getJSONArray("citylist");
          k = paramBundle.length();
          i = 0;
          if (i >= k) {
            break label473;
          }
          localObject3 = paramBundle.getJSONObject(i);
          str = ((JSONObject)localObject3).getString("province");
          j = ((JSONObject)localObject3).getInt("allgatedlaunch");
          if ((str.equals(localObject1)) && (j == 1))
          {
            this.ode = true;
            this.odd = true;
            break label1562;
          }
          if ((!str.equals(localObject1)) || (j != 0)) {
            break label1562;
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
          break label1569;
        }
        this.ode = true;
        this.odd = true;
        break label1569;
        if (i == 3)
        {
          this.odd = true;
          this.ode = false;
          label473:
          if (com.tencent.mm.model.au.DK())
          {
            com.tencent.mm.model.au.Hx();
            if (((Integer)com.tencent.mm.model.c.Dz().get(ac.a.urh, Integer.valueOf(0))).intValue() == 1) {
              this.odf = true;
            }
          }
          paramBundle = BluetoothAdapter.getDefaultAdapter();
          boolean bool = com.tencent.mm.sdk.platformtools.ae.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
          if ((paramBundle == null) || (!bool) || (Build.VERSION.SDK_INT < 18) || (paramBundle.getState() != 12)) {
            break label1434;
          }
          this.odg = 0;
          if ((paramBundle == null) || (paramBundle.getState() != 12)) {
            break label1538;
          }
          i = 1;
          if (!bool) {
            break label1533;
          }
          j = 1;
          if (!this.odd) {
            break label1442;
          }
          com.tencent.mm.plugin.report.service.h.nFQ.f(13139, new Object[] { localObject1, localObject2, Integer.valueOf(1), Integer.valueOf(this.odg), Integer.valueOf(i), Integer.valueOf(j) });
          if ((this.odf) || (this.odd))
          {
            this.odc = true;
            this.ocX = findViewById(R.h.shake_report_tab_ibeacon_ll);
            if (this.ode)
            {
              if ((paramBundle != null) && (paramBundle.getState() == 12)) {
                break label1500;
              }
              this.odc = false;
            }
          }
          paramBundle = com.tencent.mm.plugin.shake.b.m.bzZ();
          if (paramBundle.fKm == null) {
            paramBundle.fKm = new ArrayList();
          }
          if (this != null) {
            paramBundle.fKm.add(new WeakReference(this));
          }
          paramBundle = Boolean.valueOf(false);
          long l3 = bk.UX();
          long l2 = 0L;
          long l1 = 0L;
          if (com.tencent.mm.model.au.DK())
          {
            com.tencent.mm.model.au.Hx();
            com.tencent.mm.model.c.Dz().c(ac.a.ure, Boolean.valueOf(true));
            com.tencent.mm.model.au.Hx();
            bool = bk.a((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.urc, null), false);
            com.tencent.mm.model.au.Hx();
            l2 = bk.a((Long)com.tencent.mm.model.c.Dz().get(ac.a.urd, null), 0L);
            com.tencent.mm.model.au.Hx();
            l1 = bk.a((Long)com.tencent.mm.model.c.Dz().get(ac.a.uqX, null), 0L);
            paramBundle = Boolean.valueOf(bool);
          }
          if ((!paramBundle.booleanValue()) || (l3 - l2 >= l1)) {
            break label1526;
          }
          this.ocM = 5;
          this.odc = true;
          this.obZ = true;
          initView();
          bAG();
          com.tencent.mm.model.au.Hx();
          paramBundle = bk.aM((String)com.tencent.mm.model.c.Dz().get(ac.a.urb, null), "");
          com.tencent.mm.model.au.Hx();
          localObject1 = bk.aM((String)com.tencent.mm.model.c.Dz().get(ac.a.ura, null), "");
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
        label1434:
        label1442:
        label1500:
        label1526:
        label1533:
        paramBundle = null;
        label1538:
        label1543:
        break;
        label1555:
        j += 1;
        break label283;
      }
      label1562:
      i += 1;
      break label332;
      label1569:
      j += 1;
    }
  }
  
  protected void onDestroy()
  {
    if ((this.ocB != null) && (!this.ocB.isRecycled())) {
      this.ocB.recycle();
    }
    if ((this.ocC != null) && (this.ocC.isShowing()))
    {
      this.ocC.dismiss();
      this.ocC = null;
    }
    if (this.ocf.nYT != null) {
      this.ocf.nYT.bzH();
    }
    if (this.mBT != null)
    {
      this.mBT.aFJ();
      this.mBT = null;
    }
    Object localObject = com.tencent.mm.plugin.shake.d.a.j.a(null);
    if (com.tencent.mm.plugin.shake.d.a.j.isInited)
    {
      com.tencent.mm.plugin.shake.d.a.j.isInited = false;
      if (!((com.tencent.mm.plugin.shake.d.a.j)localObject).oaW.bAv()) {
        y.e("Micromsg.ShakeMusicMgr", "release MusicFingerPrintRecorder error");
      }
    }
    com.tencent.mm.plugin.shake.d.a.j.oaX = null;
    com.tencent.mm.platformtools.x.c(this);
    com.tencent.mm.sdk.b.a.udP.d(this.odj);
    com.tencent.mm.sdk.b.a.udP.d(this.odk);
    com.tencent.mm.model.au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.ure, Boolean.valueOf(false));
    bAE();
    if (com.tencent.mm.plugin.shake.c.c.a.bAt()) {
      com.tencent.mm.y.c.BS().w(262154, false);
    }
    bAK();
    localObject = com.tencent.mm.plugin.shake.b.m.bzZ();
    if ((((com.tencent.mm.plugin.shake.c.a.f)localObject).fKm == null) || (this == null)) {}
    label329:
    for (;;)
    {
      localObject = com.tencent.mm.plugin.shake.b.m.bAa();
      ((com.tencent.mm.plugin.shake.c.a.d)localObject).dia = -85.0F;
      ((com.tencent.mm.plugin.shake.c.a.d)localObject).dib = -1000.0F;
      if (this.dhZ != null) {
        this.dhZ.c(this.dig);
      }
      super.onDestroy();
      return;
      int i = 0;
      for (;;)
      {
        if (i >= ((com.tencent.mm.plugin.shake.c.a.f)localObject).fKm.size()) {
          break label329;
        }
        WeakReference localWeakReference = (WeakReference)((com.tencent.mm.plugin.shake.c.a.f)localObject).fKm.get(i);
        if (localWeakReference != null)
        {
          com.tencent.mm.plugin.shake.c.a.f.a locala = (com.tencent.mm.plugin.shake.c.a.f.a)localWeakReference.get();
          if ((locala != null) && (locala.equals(this)))
          {
            ((com.tencent.mm.plugin.shake.c.a.f)localObject).fKm.remove(localWeakReference);
            break;
          }
        }
        i += 1;
      }
    }
  }
  
  protected void onPause()
  {
    com.tencent.mm.model.au.Hx();
    com.tencent.mm.model.c.b(this);
    com.tencent.mm.model.au.Hx();
    com.tencent.mm.model.c.Dz().b(this);
    com.tencent.mm.plugin.shake.b.m.bzU().d(this);
    if (this.ocf.nYT != null) {
      this.ocf.nYT.pause();
    }
    this.ocb = false;
    if (this.mBT != null) {
      this.mBT.aFJ();
    }
    this.oce.bAB();
    if (this.ocM != 5)
    {
      com.tencent.mm.model.au.Hx();
      com.tencent.mm.model.c.Dz().o(327696, this.ocM);
    }
    if (this.ocM == 4) {
      iI(false);
    }
    bAE();
    super.onPause();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      if (paramArrayOfInt == null)
      {
        i = -1;
        y.w("MicroMsg.ShakeReportUI", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, bk.csb() });
      }
    }
    do
    {
      return;
      i = paramArrayOfInt.length;
      break;
      y.i("MicroMsg.ShakeReportUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
      switch (paramInt)
      {
      default: 
        return;
      case 64: 
        if (paramArrayOfInt[0] != 0) {
          break label201;
        }
        buJ();
        return;
      }
    } while (paramArrayOfInt[0] == 0);
    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new ShakeReportUI.19(this), new ShakeReportUI.20(this));
    return;
    label201:
    this.fht = false;
    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new ShakeReportUI.21(this), new ShakeReportUI.23(this));
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.fht)
    {
      if (!com.tencent.mm.at.b.mC((String)com.tencent.mm.kernel.g.DP().Dz().get(274436, null))) {
        break label104;
      }
      if (com.tencent.mm.pluginsdk.permission.a.j(this, "android.permission.ACCESS_COARSE_LOCATION")) {
        break label152;
      }
      if (((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uzP, Boolean.valueOf(false))).booleanValue()) {
        break label94;
      }
      com.tencent.mm.plugin.account.a.b.a.b(this, getString(R.l.location_use_scene_gdpr_url, new Object[] { com.tencent.mm.sdk.platformtools.x.cqJ() }), 30764, true);
    }
    label94:
    label104:
    boolean bool;
    do
    {
      return;
      com.tencent.mm.pluginsdk.permission.a.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
      return;
      bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "");
      y.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkposition[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this });
    } while (!bool);
    label152:
    buJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI
 * JD-Core Version:    0.7.0.1
 */