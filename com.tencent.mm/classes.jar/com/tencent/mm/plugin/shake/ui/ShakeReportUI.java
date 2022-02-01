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
import com.tencent.mm.g.a.ea;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eh;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.az;
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
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
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
  private static List<h.a> fnb;
  private com.tencent.mm.modelgeo.d fmW;
  private boolean fmZ;
  private Map<String, h.a> fna;
  private b.a fnd;
  private ImageView fxQ;
  private com.tencent.mm.av.a.a hJM;
  private boolean iMq;
  private com.tencent.mm.pluginsdk.j.d shakeSensor;
  private boolean udt;
  private View xAA;
  private View xAB;
  private View xAC;
  private Animation xAD;
  private Animation xAE;
  private Animation xAF;
  private Animation xAG;
  private View xAH;
  private View xAI;
  private MMImageView xAJ;
  private TextView xAK;
  private ImageView xAL;
  private String xAM;
  private Bitmap xAN;
  private Dialog xAO;
  private ImageView xAP;
  private com.tencent.mm.plugin.shake.b.d xAQ;
  private ImageView xAR;
  private ImageView xAS;
  private ImageView xAT;
  private ImageView xAU;
  private ImageView xAV;
  private ImageView xAW;
  private TextView xAX;
  private int xAY;
  private int xAZ;
  private boolean xAj;
  private boolean xAk;
  private boolean xAl;
  private boolean xAm;
  private boolean xAn;
  private boolean xAo;
  private boolean xAp;
  private int xAq;
  private c xAr;
  private com.tencent.mm.plugin.shake.b.l xAs;
  private com.tencent.mm.pluginsdk.ui.f xAt;
  private View xAu;
  private View xAv;
  private TextView xAw;
  private TextView xAx;
  private TextView xAy;
  private View xAz;
  private View xBa;
  private ImageView xBb;
  private ImageView xBc;
  private ImageView xBd;
  private ImageView xBe;
  private View xBf;
  private View xBg;
  private View xBh;
  private View xBi;
  private View xBj;
  private int xBk;
  private com.tencent.mm.plugin.shake.c.b.a xBl;
  private boolean xBm;
  @SuppressLint({"UseSparseArrays"})
  private Map<Integer, Boolean> xBn;
  private boolean xBo;
  private boolean xBp;
  private boolean xBq;
  private boolean xBr;
  private int xBs;
  private long xBt;
  private boolean xBu;
  private com.tencent.mm.sdk.b.c xBv;
  private com.tencent.mm.sdk.b.c xBw;
  private View.OnClickListener xBx;
  
  static
  {
    AppMethodBeat.i(28541);
    fnb = new CopyOnWriteArrayList();
    AppMethodBeat.o(28541);
  }
  
  public ShakeReportUI()
  {
    AppMethodBeat.i(28483);
    this.xAj = false;
    this.xAk = false;
    this.xAm = false;
    this.xAn = false;
    this.xAo = false;
    this.xAp = false;
    this.xAq = 22;
    this.xAs = new com.tencent.mm.plugin.shake.b.l();
    this.xAH = null;
    this.xAI = null;
    this.xAJ = null;
    this.xAK = null;
    this.xAL = null;
    this.xAM = "";
    this.xAN = null;
    this.xAP = null;
    this.hJM = null;
    this.xAQ = null;
    this.xAY = 1;
    this.xAZ = 0;
    this.xBj = null;
    this.xBk = 0;
    this.xBm = false;
    this.xBn = new HashMap();
    this.xBo = false;
    this.xBp = false;
    this.xBq = false;
    this.xBr = false;
    this.xBs = 1;
    this.iMq = true;
    this.fmZ = false;
    this.fnd = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(28446);
        if (paramAnonymousBoolean)
        {
          ac.d("MicroMsg.ShakeReportUI", "on location get ok");
          az.ayM();
          com.tencent.mm.model.c.agA().set(ah.a.GEV, String.valueOf(paramAnonymousFloat2));
          az.ayM();
          com.tencent.mm.model.c.agA().set(ah.a.GEW, String.valueOf(paramAnonymousFloat1));
          az.ayM();
          com.tencent.mm.model.c.agA().set(ah.a.GHB, String.valueOf(paramAnonymousDouble2));
          ShakeReportUI.a(ShakeReportUI.this);
          if (ShakeReportUI.b(ShakeReportUI.this) != null) {
            ShakeReportUI.b(ShakeReportUI.this).c(ShakeReportUI.c(ShakeReportUI.this));
          }
        }
        for (;;)
        {
          AppMethodBeat.o(28446);
          return false;
          if ((!ShakeReportUI.d(ShakeReportUI.this)) && (!com.tencent.mm.modelgeo.d.aEM()))
          {
            ShakeReportUI.e(ShakeReportUI.this);
            com.tencent.mm.ui.base.h.a(ShakeReportUI.this, ShakeReportUI.this.getString(2131760082), ShakeReportUI.this.getString(2131755906), ShakeReportUI.this.getString(2131760598), ShakeReportUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(28445);
                com.tencent.mm.modelgeo.d.cE(ShakeReportUI.this);
                AppMethodBeat.o(28445);
              }
            }, null);
          }
          ac.w("MicroMsg.ShakeReportUI", "getLocation fail");
        }
      }
    };
    this.fna = new ConcurrentHashMap();
    this.xBt = 0L;
    this.xBu = false;
    this.xBv = new com.tencent.mm.sdk.b.c() {};
    this.xBw = new com.tencent.mm.sdk.b.c() {};
    this.xBx = new View.OnClickListener()
    {
      public long xzO = 0L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28467);
        if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)ShakeReportUI.r(ShakeReportUI.this).getTag()))
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
          if (System.currentTimeMillis() - this.xzO > 3000L)
          {
            this.xzO = System.currentTimeMillis();
            if ((paramAnonymousView.field_reserved3 == null) || (paramAnonymousView.field_reserved3.split(",").length != 3) || (paramAnonymousView.field_reserved3.split(",")[0] == null) || (paramAnonymousView.field_reserved3.split(",")[0].equals(""))) {
              break label259;
            }
            localObject1 = paramAnonymousView.field_reserved3.split(",");
            localObject2 = new ut();
            ((ut)localObject2).dxt.userName = localObject1[0];
            ((ut)localObject2).dxt.dxv = com.tencent.mm.sdk.platformtools.bs.bG(localObject1[1], "");
            ((ut)localObject2).dxt.dxw = com.tencent.mm.sdk.platformtools.bs.getInt(localObject1[2], 0);
            ((ut)localObject2).dxt.scene = 1077;
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
          }
          for (;;)
          {
            localObject1 = ShakeReportUI.E(ShakeReportUI.this).xxj;
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
            com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ai.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          }
        }
        az.ayM();
        Object localObject2 = com.tencent.mm.model.c.awB().aNt((String)localObject1);
        if (com.tencent.mm.n.b.ln(((com.tencent.mm.g.c.av)localObject2).field_type))
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", (String)localObject1);
          paramAnonymousView.putExtra("Sns_from_Scene", 22);
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            if (((com.tencent.mm.storage.ai)localObject2).fad())
            {
              com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, (String)localObject1 + "," + ShakeReportUI.O(ShakeReportUI.this));
              paramAnonymousView.putExtra("Contact_Scene", ShakeReportUI.O(ShakeReportUI.this));
            }
            com.tencent.mm.plugin.shake.a.iyx.c(paramAnonymousView, ShakeReportUI.this);
          }
          AppMethodBeat.o(28467);
          return;
        }
        if ((paramAnonymousView.field_reserved1 & 0x8) > 0) {
          com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, paramAnonymousView.field_username + "," + ShakeReportUI.O(ShakeReportUI.this));
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
        com.tencent.mm.plugin.shake.a.iyx.c((Intent)localObject1, ShakeReportUI.this);
        AppMethodBeat.o(28467);
      }
    };
    AppMethodBeat.o(28483);
  }
  
  private void NQ(int paramInt)
  {
    AppMethodBeat.i(28503);
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      qx(bool);
      if (paramInt != 2) {
        break;
      }
      qw(true);
      AppMethodBeat.o(28503);
      return;
    }
    qw(false);
    AppMethodBeat.o(28503);
  }
  
  private void a(com.tencent.mm.plugin.shake.c.a.e parame)
  {
    AppMethodBeat.i(28508);
    this.xBl = com.tencent.mm.plugin.shake.c.b.a.a(this, parame, new DialogInterface.OnCancelListener()new com.tencent.mm.plugin.shake.c.b.a.b
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
      public final void dkf()
      {
        AppMethodBeat.i(28466);
        ShakeReportUI.b(ShakeReportUI.this, true);
        ShakeReportUI.M(ShakeReportUI.this).setText("");
        AppMethodBeat.o(28466);
      }
    });
    AppMethodBeat.o(28508);
  }
  
  private void ast(String paramString)
  {
    AppMethodBeat.i(28505);
    this.xAm = false;
    if (this.xAl) {
      bc.aF(getContext(), 2131763595);
    }
    if (this.xAG == null) {
      this.xAG = AnimationUtils.loadAnimation(getContext(), 2130772040);
    }
    NQ(2);
    if ((paramString != null) && (paramString.length() > 1)) {
      this.xAx.setText(paramString);
    }
    for (;;)
    {
      this.xAx.startAnimation(this.xAG);
      this.xAp = true;
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28463);
          ShakeReportUI.K(ShakeReportUI.this);
          ShakeReportUI.d(ShakeReportUI.this, false);
          AppMethodBeat.o(28463);
        }
      }, this.xAG.getDuration());
      AppMethodBeat.o(28505);
      return;
      this.xAx.setText(2131763561);
    }
  }
  
  private void bz(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(28519);
    this.xAm = false;
    if (this.xAG == null) {
      this.xAG = AnimationUtils.loadAnimation(getContext(), 2130772040);
    }
    NQ(2);
    qw(true);
    if ((paramString != null) && (paramString.length() > 1)) {
      this.xAx.setText(paramString);
    }
    for (;;)
    {
      this.xAp = true;
      AppMethodBeat.o(28519);
      return;
      if (paramBoolean)
      {
        this.xAx.setText(2131763551);
      }
      else
      {
        this.xAx.setText("");
        qw(false);
      }
    }
  }
  
  private void c(com.tencent.mm.plugin.shake.b.d paramd)
  {
    AppMethodBeat.i(28513);
    if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramd.field_username))
    {
      AppMethodBeat.o(28513);
      return;
    }
    this.xAu.setTag(paramd.field_username);
    this.xAu.setVisibility(0);
    az.ayM();
    com.tencent.mm.storage.ai localai = com.tencent.mm.model.c.awB().aNt(paramd.field_username);
    Object localObject2 = new StringBuilder().append(paramd.field_nickname);
    Object localObject1;
    label156:
    label212:
    label363:
    int i;
    if (com.tencent.mm.n.b.ln(localai.field_type))
    {
      localObject1 = getString(2131763588);
      localObject2 = (String)localObject1;
      if (paramd.field_sex != 1) {
        break label500;
      }
      this.xAu.setContentDescription((String)localObject2 + paramd.field_distance + getContext().getString(2131763617));
      TextView localTextView = (TextView)this.xAu.findViewById(2131304689);
      AppCompatActivity localAppCompatActivity = getContext();
      StringBuilder localStringBuilder = new StringBuilder().append(paramd.field_nickname);
      if (!com.tencent.mm.n.b.ln(localai.field_type)) {
        break label585;
      }
      localObject1 = getString(2131763588);
      localTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localAppCompatActivity, (String)localObject1, localTextView.getTextSize()));
      if (this.fxQ != null)
      {
        if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject2)) {
          break label591;
        }
        this.fxQ.setContentDescription(String.format(getString(2131763543), new Object[] { localObject2 }));
      }
      label277:
      ((TextView)this.xAu.findViewById(2131304687)).setText(paramd.field_distance);
      com.tencent.mm.pluginsdk.ui.a.b.c((ImageView)this.xAu.findViewById(2131304688), paramd.field_username);
      localObject1 = (ImageView)this.xAu.findViewById(2131304691);
      if (paramd.field_reserved1 == 0) {
        break label608;
      }
      ((ImageView)localObject1).setVisibility(0);
      ((ImageView)localObject1).setImageBitmap(BackwardSupportUtil.b.n(ar.a.hny.nR(paramd.field_reserved1), 2.0F));
      if ((paramd.field_reserved1 != 0) || (paramd.field_sex == 0)) {
        break label624;
      }
      if (paramd.field_sex != 1) {
        break label617;
      }
      i = 2131690323;
      label389:
      localObject1 = com.tencent.mm.cc.a.l(this, i);
      this.xAu.findViewById(2131304690).setVisibility(0);
      ((ImageView)this.xAu.findViewById(2131304690)).setImageDrawable((Drawable)localObject1);
    }
    for (;;)
    {
      if (paramd.getProvince() == null)
      {
        ac.e("MicroMsg.ShakeReportUI", "PROVINCE NULL");
        paramd.field_province = "";
      }
      if (paramd.getCity() == null)
      {
        ac.e("MicroMsg.ShakeReportUI", "CITY NULL");
        paramd.field_city = "";
      }
      this.xAu.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772129));
      AppMethodBeat.o(28513);
      return;
      localObject1 = "";
      break;
      label500:
      if (paramd.field_sex == 2)
      {
        this.xAu.setContentDescription((String)localObject2 + paramd.field_distance + getContext().getString(2131763616));
        break label156;
      }
      this.xAu.setContentDescription((String)localObject2 + paramd.field_distance);
      break label156;
      label585:
      localObject1 = "";
      break label212;
      label591:
      this.fxQ.setContentDescription(getString(2131763544));
      break label277;
      label608:
      ((ImageView)localObject1).setVisibility(8);
      break label363;
      label617:
      i = 2131690322;
      break label389;
      label624:
      this.xAu.findViewById(2131304690).setVisibility(8);
    }
  }
  
  private void d(com.tencent.mm.plugin.shake.b.d paramd)
  {
    AppMethodBeat.i(28514);
    if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramd.field_username))
    {
      AppMethodBeat.o(28514);
      return;
    }
    this.xAu.setTag(paramd.field_username);
    ((TextView)this.xAu.findViewById(2131304689)).setText(paramd.field_username);
    this.xAu.setContentDescription(com.tencent.mm.sdk.platformtools.bs.nullAsNil(paramd.field_nickname));
    ((TextView)this.xAu.findViewById(2131304687)).setText(paramd.field_signature);
    this.hJM.loadImage(paramd.getProvince(), (ImageView)this.xAu.findViewById(2131304688));
    this.xAu.findViewById(2131304690).setVisibility(8);
    this.xAu.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772129));
    this.xAu.setVisibility(0);
    AppMethodBeat.o(28514);
  }
  
  private void dDU()
  {
    AppMethodBeat.i(28489);
    if (!dEi())
    {
      AppMethodBeat.o(28489);
      return;
    }
    if (BluetoothAdapter.getDefaultAdapter() != null)
    {
      Object localObject = com.tencent.mm.m.g.ZZ().ZQ();
      if (localObject != null)
      {
        this.xBt = System.currentTimeMillis();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          ac.i("MicroMsg.ShakeReportUI", "op=true,iBeacon = %s", new Object[] { str });
          ea localea = new ea();
          localea.ddO.ddQ = str;
          localea.ddO.ddN = true;
          com.tencent.mm.sdk.b.a.GpY.l(localea);
        }
      }
    }
    AppMethodBeat.o(28489);
  }
  
  private void dDV()
  {
    AppMethodBeat.i(28490);
    az.ayM();
    if (!com.tencent.mm.sdk.platformtools.bs.a((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GHq, null), false))
    {
      this.fna.clear();
      fnb = new CopyOnWriteArrayList();
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      Object localObject = com.tencent.mm.m.g.ZZ().ZQ();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          ea localea = new ea();
          ac.i("MicroMsg.ShakeReportUI", "op=false,iBeacon = %s", new Object[] { str });
          localea.ddO.ddQ = str;
          localea.ddO.ddN = false;
          com.tencent.mm.sdk.b.a.GpY.l(localea);
        }
      }
    }
    AppMethodBeat.o(28490);
  }
  
  private void dDW()
  {
    AppMethodBeat.i(28492);
    if (com.tencent.mm.ay.e.aGE())
    {
      az.ayM();
      if (com.tencent.mm.model.c.agA().getInt(4118, 0) == 0)
      {
        com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(getContext());
        locala.acF(2131755906);
        locala.acJ(2131763571);
        locala.acM(2131763570).b(new DialogInterface.OnClickListener()
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
        locala.yf(true);
        locala.e(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(28448);
            az.ayM();
            com.tencent.mm.model.c.agA().setInt(4118, 1);
            ShakeReportUI.t(ShakeReportUI.this).setVisibility(8);
            AppMethodBeat.o(28448);
          }
        });
        this.xAO = locala.fvp();
        this.xAO.show();
      }
    }
    AppMethodBeat.o(28492);
  }
  
  private void dDX()
  {
    AppMethodBeat.i(28493);
    az.ayM();
    int j = com.tencent.mm.sdk.platformtools.bs.a((Integer)com.tencent.mm.model.c.agA().get(12290, null), 0);
    ImageView localImageView = (ImageView)findViewById(2131304700);
    if ((this.xAN != null) && (!this.xAN.isRecycled())) {
      this.xAN.recycle();
    }
    az.ayM();
    Object localObject1;
    if (com.tencent.mm.sdk.platformtools.bs.k((Boolean)com.tencent.mm.model.c.agA().get(4110, null)))
    {
      localObject1 = new StringBuilder();
      az.ayM();
      localObject1 = com.tencent.mm.model.c.awL() + "default_shake_img_filename.jpg";
      if (com.tencent.mm.vfs.i.eA((String)localObject1))
      {
        this.xAN = u.FE((String)localObject1);
        localImageView.setImageDrawable(new BitmapDrawable(this.xAN));
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
              public final void kG(int paramAnonymous2Int)
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
        if (this.xAB == null) {
          this.xAB = findViewById(2131304683);
        }
        this.xAB.setOnClickListener(local7);
        if (this.xAC == null) {
          this.xAC = findViewById(2131304684);
        }
        this.xAC.setOnClickListener(local7);
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
            ac.w("MicroMsg.ShakeReportUI", "Bg decode exp:" + localIOException.getLocalizedMessage());
            Object localObject2 = null;
          }
        }
      }
      az.ayM();
      this.xAN = u.FE((String)com.tencent.mm.model.c.agA().get(4111, null));
      localImageView.setImageDrawable(new BitmapDrawable(this.xAN));
      break;
      i = 2131233995;
      break label179;
    }
  }
  
  private void dDY()
  {
    AppMethodBeat.i(28494);
    this.xAo = true;
    if ((this.xBl != null) && (this.xBl.isShowing()) && (!this.xBl.xyq)) {
      this.xAo = false;
    }
    ac.i("MicroMsg.ShakeReportUI", "tryStartShake");
    if ((this.shakeSensor != null) && (!this.shakeSensor.eMp()))
    {
      this.shakeSensor.a(new a(this));
      if ((this.shakeSensor.eMr()) && (this.xAw != null))
      {
        this.xAw.setText(getString(2131763534));
        AppMethodBeat.o(28494);
        return;
      }
      this.xAw.setText(getString(2131763596));
    }
    AppMethodBeat.o(28494);
  }
  
  private void dDZ()
  {
    AppMethodBeat.i(28496);
    if ((this.xAY == 3) && (com.tencent.mm.ay.e.aGD()))
    {
      this.xAY = 3;
      this.xAy.setText(2131763612);
      this.xAP.setBackgroundResource(2131233978);
      this.xAR.setBackgroundResource(2131233984);
      this.xAS.setBackgroundResource(2131233983);
      this.xAT.setBackgroundResource(2131233987);
      this.xAU.setBackgroundResource(2131233974);
      findViewById(2131304701).setVisibility(0);
      setMMTitle(2131763608);
      com.tencent.mm.plugin.report.service.h.wUl.f(11720, new Object[] { Integer.valueOf(2) });
      com.tencent.mm.plugin.report.service.h.wUl.n(834L, 2L, 1L);
    }
    for (;;)
    {
      l.b localb = this.xAs.a(this, this.xAY, this);
      if (!this.xAm) {
        qx(false);
      }
      if ((com.tencent.mm.plugin.shake.c.c.a.dDK()) && ((localb instanceof com.tencent.mm.plugin.shake.c.a.g)))
      {
        ((com.tencent.mm.plugin.shake.c.a.g)localb).setFromScene(this.xBk);
        if (this.xBk == 3)
        {
          ac.i("MicroMsg.ShakeReportUI", "open shake card from specialview");
          ((com.tencent.mm.plugin.shake.c.a.g)localb).WH(getIntent().getStringExtra("key_shake_card_ext_info"));
        }
      }
      AppMethodBeat.o(28496);
      return;
      if ((this.xAY == 4) && (com.tencent.mm.plugin.shake.d.a.k.dDj()))
      {
        this.xAY = 4;
        this.xAy.setText(2131763613);
        this.xAP.setBackgroundResource(2131233978);
        this.xAR.setBackgroundResource(2131233984);
        this.xAS.setBackgroundResource(2131233981);
        this.xAT.setBackgroundResource(2131233989);
        this.xAU.setBackgroundResource(2131233974);
        findViewById(2131304701).setVisibility(0);
        setMMTitle(2131763609);
        com.tencent.mm.plugin.report.service.h.wUl.f(11720, new Object[] { Integer.valueOf(3) });
        com.tencent.mm.plugin.report.service.h.wUl.n(834L, 3L, 1L);
      }
      else if ((this.xAY == 5) && (dEh()))
      {
        this.xAY = 5;
        this.xAy.setText(2131763611);
        this.xAP.setBackgroundResource(2131233980);
        this.xAR.setBackgroundResource(2131233984);
        this.xAS.setBackgroundResource(2131233981);
        this.xAT.setBackgroundResource(2131233987);
        this.xAU.setBackgroundResource(2131233974);
        findViewById(2131304701).setVisibility(0);
        setMMTitle(2131763607);
        com.tencent.mm.plugin.report.service.h.wUl.f(11720, new Object[] { Integer.valueOf(4) });
        com.tencent.mm.plugin.report.service.h.wUl.n(834L, 4L, 1L);
      }
      else if ((this.xAY == 6) && (com.tencent.mm.plugin.shake.c.c.a.dDK()))
      {
        this.xAY = 6;
        this.xAy.setText(2131763610);
        this.xAP.setBackgroundResource(2131233978);
        this.xAR.setBackgroundResource(2131233984);
        this.xAS.setBackgroundResource(2131233981);
        this.xAT.setBackgroundResource(2131233987);
        this.xAU.setBackgroundResource(2131233975);
        findViewById(2131304701).setVisibility(0);
        setMMTitle(2131763606);
        dEc();
        dEf();
        com.tencent.mm.plugin.report.service.h.wUl.f(11720, new Object[] { Integer.valueOf(5) });
        com.tencent.mm.plugin.report.service.h.wUl.n(834L, 5L, 1L);
      }
      else
      {
        this.xAY = 1;
        this.xAy.setText(2131763554);
        this.xAP.setBackgroundResource(2131233978);
        this.xAR.setBackgroundResource(2131233986);
        this.xAS.setBackgroundResource(2131233981);
        this.xAT.setBackgroundResource(2131233987);
        this.xAU.setBackgroundResource(2131233974);
        if (com.tencent.mm.ay.e.aGD()) {
          findViewById(2131304701).setVisibility(0);
        }
        setMMTitle(2131763605);
        com.tencent.mm.plugin.report.service.h.wUl.f(11720, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.h.wUl.n(834L, 1L, 1L);
      }
    }
  }
  
  private void dEa()
  {
    AppMethodBeat.i(28497);
    az.ayM();
    this.xAl = com.tencent.mm.sdk.platformtools.bs.k((Boolean)com.tencent.mm.model.c.agA().get(4112, null));
    if (this.xAl)
    {
      setTitleMuteIconVisibility(8);
      AppMethodBeat.o(28497);
      return;
    }
    setTitleMuteIconVisibility(0);
    AppMethodBeat.o(28497);
  }
  
  private void dEb()
  {
    AppMethodBeat.i(28517);
    if (com.tencent.mm.plugin.shake.c.c.a.dDK())
    {
      if (com.tencent.mm.y.c.aeH().cH(262155, 266259))
      {
        this.xAW.setVisibility(0);
        AppMethodBeat.o(28517);
        return;
      }
      this.xAW.setVisibility(8);
    }
    AppMethodBeat.o(28517);
  }
  
  private void dEc()
  {
    AppMethodBeat.i(28518);
    if ((this.xAY == 6) && (com.tencent.mm.plugin.shake.c.c.a.dDK()))
    {
      boolean bool1 = com.tencent.mm.y.c.aeH().cH(262154, 266258);
      boolean bool2 = com.tencent.mm.y.c.aeH().cH(262155, 266259);
      if (bool1)
      {
        bz(com.tencent.mm.plugin.shake.c.c.a.dDF(), true);
        AppMethodBeat.o(28518);
        return;
      }
      if (bool2)
      {
        bz(com.tencent.mm.plugin.shake.c.c.a.dDH(), true);
        AppMethodBeat.o(28518);
        return;
      }
      if (!this.xBm)
      {
        if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.dDD()))
        {
          bz(com.tencent.mm.plugin.shake.c.c.a.dDD(), true);
          AppMethodBeat.o(28518);
          return;
        }
        bz(getString(2131763551), true);
      }
    }
    AppMethodBeat.o(28518);
  }
  
  private void dEd()
  {
    AppMethodBeat.i(28520);
    if ((this.xBl != null) && (this.xBl.isShowing())) {
      this.xBl.dismiss();
    }
    this.xBl = null;
    AppMethodBeat.o(28520);
  }
  
  private void dEe()
  {
    int m = 1;
    AppMethodBeat.i(28521);
    boolean bool1 = com.tencent.mm.plugin.shake.c.c.a.dDg();
    boolean bool2 = com.tencent.mm.y.c.aeH().cH(262154, 266258);
    boolean bool3 = com.tencent.mm.y.c.aeH().cH(262155, 266259);
    if (getIntent().getBooleanExtra("shake_card", false)) {}
    for (int i = getIntent().getIntExtra("shake_card", 0);; i = 0)
    {
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
      int j;
      if (bool2)
      {
        j = 1;
        if (!bool1) {
          break label231;
        }
        k = 1;
        label87:
        localh.f(11668, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), com.tencent.mm.plugin.shake.c.c.a.dDG(), Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.dDC()) });
        localh = com.tencent.mm.plugin.report.service.h.wUl;
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
        localh.f(11668, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), com.tencent.mm.plugin.shake.c.c.a.dDG(), Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.dDC()) });
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
  
  private void dEf()
  {
    AppMethodBeat.i(28522);
    if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.dDE())) {
      this.xAX.setText(com.tencent.mm.plugin.shake.c.c.a.dDE());
    }
    AppMethodBeat.o(28522);
  }
  
  private void dEg()
  {
    AppMethodBeat.i(28523);
    label123:
    Object localObject;
    label167:
    label208:
    int i;
    if (com.tencent.mm.ay.e.aGD())
    {
      ac.i("MicroMsg.ShakeReportUI", "is not oversea user, show shake music");
      this.xBn.put(Integer.valueOf(3), Boolean.TRUE);
      findViewById(2131304716).setVisibility(0);
      if (com.tencent.mm.ay.e.aGE())
      {
        az.ayM();
        if (com.tencent.mm.model.c.agA().getInt(4118, 0) == 0) {
          this.xAV.setVisibility(0);
        }
      }
      else
      {
        if (!com.tencent.mm.plugin.shake.d.a.k.dDj()) {
          break label309;
        }
        this.xBn.put(Integer.valueOf(4), Boolean.TRUE);
        findViewById(2131304719).setVisibility(0);
        ac.i("MicroMsg.ShakeReportUI", "show shake tv tab");
        if (!com.tencent.mm.plugin.shake.c.c.a.dDK()) {
          break label350;
        }
        this.xBn.put(Integer.valueOf(6), Boolean.TRUE);
        findViewById(2131304706).setVisibility(0);
        ac.i("MicroMsg.ShakeReportUI", "show shake card tab");
        if (!dEh()) {
          break label392;
        }
        this.xBn.put(Integer.valueOf(5), Boolean.TRUE);
        this.xBj.setVisibility(0);
        ac.i("MicroMsg.ShakeReportUI", "[shakezb]show shake ibeacon tab");
        localObject = this.xBn.values().iterator();
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
      this.xAV.setVisibility(8);
      break;
      this.xBn.put(Integer.valueOf(3), Boolean.FALSE);
      findViewById(2131304716).setVisibility(8);
      ac.i("MicroMsg.ShakeReportUI", "is oversea user, hide shake music");
      break;
      this.xBn.put(Integer.valueOf(4), Boolean.FALSE);
      findViewById(2131304719).setVisibility(8);
      ac.i("MicroMsg.ShakeReportUI", "hide shake tv tab");
      break label123;
      label350:
      findViewById(2131304706).setVisibility(8);
      this.xBn.put(Integer.valueOf(6), Boolean.FALSE);
      ac.i("MicroMsg.ShakeReportUI", "hide shake card tab");
      break label167;
      this.xBn.put(Integer.valueOf(5), Boolean.FALSE);
      this.xBj.setVisibility(8);
      ac.i("MicroMsg.ShakeReportUI", "[shakezb]hide shake ibeacon tab");
      break label208;
      this.xAZ = i;
      localObject = (LinearLayout)findViewById(2131304701);
      if (i == 1) {
        ((LinearLayout)localObject).setVisibility(8);
      }
      while ((i > 4) && (this.xBu))
      {
        findViewById(2131304719).setVisibility(8);
        ac.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() > 0.");
        this.xAZ -= 1;
        AppMethodBeat.o(28523);
        return;
        ((LinearLayout)localObject).setVisibility(0);
      }
      if ((i > 4) && (!this.xBu))
      {
        this.xBj.setVisibility(8);
        this.xBo = false;
        this.xAZ -= 1;
        ac.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() <= 0.");
      }
      AppMethodBeat.o(28523);
      return;
    }
  }
  
  private boolean dEh()
  {
    AppMethodBeat.i(28524);
    ac.i("MicroMsg.ShakeReportUI", "[shakezb] isChineseAppLang :" + com.tencent.mm.sdk.platformtools.ab.eUK() + " ,getApplicationLanguage[en or zh_CN or zh_HK or zh_TW is avaliable] :" + com.tencent.mm.sdk.platformtools.ab.eUO());
    if ((this.xBo) && (dEi()))
    {
      AppMethodBeat.o(28524);
      return true;
    }
    AppMethodBeat.o(28524);
    return false;
  }
  
  private static boolean dEi()
  {
    AppMethodBeat.i(28525);
    if ((com.tencent.mm.sdk.platformtools.ab.eUK()) || (com.tencent.mm.sdk.platformtools.ab.eUO().equals("en")) || (com.tencent.mm.sdk.platformtools.ab.eUO().equals("ja")))
    {
      AppMethodBeat.o(28525);
      return true;
    }
    AppMethodBeat.o(28525);
    return false;
  }
  
  private void dEj()
  {
    AppMethodBeat.i(28526);
    this.xBa.setVisibility(8);
    AppMethodBeat.o(28526);
  }
  
  private void dsQ()
  {
    AppMethodBeat.i(28486);
    dDX();
    az.ayM();
    com.tencent.mm.model.c.a(this);
    az.ayM();
    com.tencent.mm.model.c.agA().a(this);
    com.tencent.mm.plugin.shake.b.m.dDl().add(this);
    if (this.xAs.xxj != null) {
      this.xAs.xxj.resume();
    }
    dDY();
    new ao().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28471);
        if (ShakeReportUI.f(ShakeReportUI.this) != null) {
          ShakeReportUI.f(ShakeReportUI.this).eMq();
        }
        AppMethodBeat.o(28471);
      }
    }, 1000L);
    if (this.shakeSensor != null) {
      this.shakeSensor.eMq();
    }
    qw(false);
    qx(false);
    dEa();
    az.ayM();
    Object localObject = (String)com.tencent.mm.model.c.agA().get(327696, "1");
    if (com.tencent.mm.plugin.shake.d.a.k.dDj())
    {
      if (this.xAY == 4) {
        qs(true);
      }
      if (((String)localObject).equals("4")) {
        ey(findViewById(2131304719));
      }
    }
    boolean bool;
    if (((String)localObject).equals("3"))
    {
      ey(findViewById(2131304716));
      bool = com.tencent.mm.y.c.aeH().cH(262154, 266258);
      if ((!getIntent().getBooleanExtra("shake_music", false)) || (!com.tencent.mm.ay.e.aGD()) || (this.xAs.xxi == 3)) {
        break label357;
      }
      getIntent().putExtra("shake_music", false);
      this.xAY = 3;
    }
    for (;;)
    {
      dDZ();
      qt(true);
      ac.d("MicroMsg.ShakeReportUI", "isShakeGetConfigList = %s", new Object[] { Boolean.valueOf(com.tencent.mm.platformtools.ab.ivw) });
      if (com.tencent.mm.platformtools.ab.ivw)
      {
        localObject = new com.tencent.mm.bb.l(7);
        az.agi().a((com.tencent.mm.ak.n)localObject, 0);
      }
      dEj();
      dEg();
      dDU();
      AppMethodBeat.o(28486);
      return;
      if ((!((String)localObject).equals("6")) || (!com.tencent.mm.plugin.shake.c.c.a.dDK())) {
        break;
      }
      ey(findViewById(2131304706));
      break;
      label357:
      if ((getIntent().getBooleanExtra("shake_tv", false)) && (this.xAs.xxi != 4) && (com.tencent.mm.plugin.shake.d.a.k.dDj()))
      {
        getIntent().putExtra("shake_tv", false);
        this.xAY = 4;
      }
      else if ((this.xAs.xxi != 6) && (com.tencent.mm.plugin.shake.c.c.a.dDK()) && ((bool) || (getIntent().getBooleanExtra("shake_card", false))))
      {
        this.xBk = getIntent().getIntExtra("shake_card", 0);
        getIntent().putExtra("shake_card", false);
        ac.i("MicroMsg.ShakeReportUI", "onresume shake card tab is open, activity type is 0 or open from specialview");
        this.xAY = 6;
      }
    }
  }
  
  private void ey(View paramView)
  {
    AppMethodBeat.i(28509);
    if (paramView == null)
    {
      AppMethodBeat.o(28509);
      return;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, "", "");
    ac.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), com.tencent.mm.sdk.platformtools.bs.eWi(), this });
    if (!bool)
    {
      AppMethodBeat.o(28509);
      return;
    }
    bz("", false);
    if (paramView.getId() == 2131304710)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(11722, new Object[] { Integer.valueOf(1) });
      if (this.xAY != 1)
      {
        if (this.xAY == 4) {
          qs(false);
        }
        this.xAY = 1;
        dDZ();
        qu(false);
        if (this.xAu != null) {
          this.xAu.setVisibility(8);
        }
      }
    }
    do
    {
      for (;;)
      {
        qt(true);
        qx(false);
        dEj();
        AppMethodBeat.o(28509);
        return;
        if (paramView.getId() == 2131304716)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(11722, new Object[] { Integer.valueOf(2) });
          if ((!this.fmZ) && (this.fmW != null)) {
            this.fmW.a(this.fnd, true);
          }
          if ((!com.tencent.mm.r.a.ci(this)) && (!com.tencent.mm.r.a.cf(this)) && (!com.tencent.mm.r.a.ck(this)) && (this.xAY != 3))
          {
            if (this.xAY == 4) {
              qs(false);
            }
            this.xAY = 3;
            dDZ();
            qu(false);
            if (this.xAu != null) {
              this.xAu.setVisibility(8);
            }
          }
          dDW();
        }
        else
        {
          if (paramView.getId() != 2131304719) {
            break;
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(11722, new Object[] { Integer.valueOf(3) });
          if ((!this.fmZ) && (this.fmW != null)) {
            this.fmW.a(this.fnd, true);
          }
          if ((!com.tencent.mm.r.a.ci(this)) && (!com.tencent.mm.r.a.cf(this)) && (!com.tencent.mm.r.a.ck(this)) && (this.xAY != 4))
          {
            qs(true);
            this.xAY = 4;
            dDZ();
            qu(false);
            if (this.xAu != null) {
              this.xAu.setVisibility(8);
            }
          }
        }
      }
      if ((paramView.getId() != 2131304714) && (paramView.getId() != 2131304711)) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(11722, new Object[] { Integer.valueOf(4) });
    } while (this.xAY == 5);
    this.xAY = 5;
    dDZ();
    qu(false);
    if (this.xAu != null) {
      this.xAu.setVisibility(8);
    }
    if ((!Build.VERSION.RELEASE.equals("6.0")) && (!Build.VERSION.RELEASE.equals("6.0.0")) && (Build.VERSION.SDK_INT >= 23))
    {
      paramView = (LocationManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("location");
      if (paramView == null) {
        break label743;
      }
    }
    label743:
    for (bool = paramView.isProviderEnabled("gps");; bool = true)
    {
      if (!bool) {
        ast(getString(2131763565));
      }
      paramView = BluetoothAdapter.getDefaultAdapter();
      if ((paramView != null) && (paramView.getState() != 12))
      {
        ast(getString(2131763564));
        break;
      }
      if (paramView != null) {
        break;
      }
      ast(getString(2131763568));
      break;
      if (paramView.getId() != 2131304706) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(11722, new Object[] { Integer.valueOf(5) });
      if (this.xAY == 6) {
        break;
      }
      if (this.xAY == 4) {
        qs(false);
      }
      this.xAY = 6;
      dDZ();
      qu(false);
      if (this.xAu != null) {
        this.xAu.setVisibility(8);
      }
      com.tencent.mm.y.c.aeH().x(262155, false);
      this.xAW.setVisibility(8);
      break;
    }
  }
  
  private void qs(boolean paramBoolean)
  {
    AppMethodBeat.i(28495);
    String str = String.format("%1$s-shaketype-%2$d", new Object[] { getClass().getName(), Integer.valueOf(4) });
    ac.d("MicroMsg.ShakeReportUI", "activate change report , class name=" + str + ", isActive=" + paramBoolean);
    y.d(paramBoolean, new Intent().putExtra("classname", str));
    AppMethodBeat.o(28495);
  }
  
  private void qt(boolean paramBoolean)
  {
    AppMethodBeat.i(28498);
    qu(paramBoolean);
    qv(paramBoolean);
    AppMethodBeat.o(28498);
  }
  
  private void qu(boolean paramBoolean)
  {
    AppMethodBeat.i(28499);
    if (this.xAH == null) {
      this.xAH = findViewById(2131300604);
    }
    if ((this.xAs.xxi == 3) || (this.xAs.xxi == 4) || (this.xAs.xxi == 5) || (this.xAs.xxi == 6) || (!paramBoolean))
    {
      this.xAH.setVisibility(8);
      AppMethodBeat.o(28499);
      return;
    }
    int i = com.tencent.mm.bj.d.aJg().bQe();
    if (i <= 0)
    {
      this.xAH.setVisibility(8);
      AppMethodBeat.o(28499);
      return;
    }
    this.xAH.setVisibility(0);
    ((TextView)this.xAH.findViewById(2131304292)).setText(getResources().getQuantityString(2131623965, i, new Object[] { Integer.valueOf(i) }));
    this.xAH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28456);
        Object localObject = new Intent(ShakeReportUI.this, ShakeSayHiListUI.class);
        ((Intent)localObject).putExtra("IntentSayHiType", 1);
        paramAnonymousView = ShakeReportUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$16", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$16", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(28456);
      }
    });
    if (this.xAL == null) {
      this.xAL = ((ImageView)findViewById(2131302192));
    }
    bx localbx = com.tencent.mm.bj.d.aJg().fcD();
    if (localbx != null)
    {
      this.xAM = localbx.field_sayhiuser;
      com.tencent.mm.pluginsdk.ui.a.b.c(this.xAL, this.xAM);
    }
    AppMethodBeat.o(28499);
  }
  
  private void qv(boolean paramBoolean)
  {
    AppMethodBeat.i(28500);
    if (this.xAI == null) {
      this.xAI = findViewById(2131300605);
    }
    if (!paramBoolean)
    {
      this.xAI.setVisibility(8);
      AppMethodBeat.o(28500);
      return;
    }
    int i = com.tencent.mm.plugin.shake.b.m.dDm().bQe();
    if (i <= 0)
    {
      this.xAI.setVisibility(8);
      AppMethodBeat.o(28500);
      return;
    }
    if (this.xAK == null) {
      this.xAK = ((TextView)this.xAI.findViewById(2131304692));
    }
    this.xAK.setText(getString(2131763589, new Object[] { Integer.valueOf(i) }));
    this.xAI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28457);
        Object localObject = new Intent(ShakeReportUI.this, ShakeMsgListUI.class);
        ((Intent)localObject).putExtra("shake_msg_from", 1);
        ((Intent)localObject).putExtra("shake_msg_list_title", ShakeReportUI.this.getString(2131763637));
        paramAnonymousView = ShakeReportUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$17", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$17", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(28457);
      }
    });
    if (this.xAJ == null) {
      this.xAJ = ((MMImageView)findViewById(2131304698));
    }
    Object localObject = com.tencent.mm.plugin.shake.b.m.dDm().dDc();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.shake.b.f)localObject).field_thumburl;
      if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject)) {
        break label255;
      }
      localObject = new com.tencent.mm.plugin.shake.e.b((String)localObject);
      Bitmap localBitmap = u.a((s)localObject);
      this.xAJ.setTag(((com.tencent.mm.plugin.shake.e.b)localObject).aNn());
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        break label242;
      }
      this.xAJ.setImageBitmap(localBitmap);
    }
    for (;;)
    {
      this.xAI.setVisibility(0);
      AppMethodBeat.o(28500);
      return;
      label242:
      this.xAJ.setImageResource(2131689584);
      continue;
      label255:
      this.xAJ.setImageResource(2131689584);
    }
  }
  
  private void qw(boolean paramBoolean)
  {
    AppMethodBeat.i(28501);
    if (this.xAx != null)
    {
      if (paramBoolean)
      {
        this.xAx.setVisibility(0);
        AppMethodBeat.o(28501);
        return;
      }
      this.xAx.setVisibility(8);
      this.xAx.cancelLongPress();
    }
    AppMethodBeat.o(28501);
  }
  
  private void qx(boolean paramBoolean)
  {
    AppMethodBeat.i(28502);
    if (this.xAv != null)
    {
      if (paramBoolean)
      {
        this.xAv.setVisibility(0);
        AppMethodBeat.o(28502);
        return;
      }
      this.xAv.setVisibility(4);
    }
    AppMethodBeat.o(28502);
  }
  
  public final void a(int paramInt, final com.tencent.mm.plugin.shake.c.a.e parame, long paramLong)
  {
    AppMethodBeat.i(28507);
    this.xBm = true;
    if (paramInt == 1251)
    {
      if (parame == null)
      {
        AppMethodBeat.o(28507);
        return;
      }
      ac.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_GetLbsCard");
      com.tencent.mm.plugin.shake.c.c.a.dDf();
      dEg();
      dEb();
      dEe();
      this.xBk = 4;
      com.tencent.mm.plugin.shake.b.m.dDr().putValue("key_shake_card_item", parame);
      AppMethodBeat.o(28507);
      return;
    }
    Object localObject;
    if (paramInt == 1250)
    {
      if (parame == null)
      {
        this.xAQ = null;
        ast(null);
        AppMethodBeat.o(28507);
        return;
      }
      if (((parame == null) || (this.xAm)) && (!this.xAm))
      {
        this.xAQ = null;
        ast(null);
        AppMethodBeat.o(28507);
        return;
      }
      this.xAm = false;
      ac.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_ShakeCard");
      if (this.xAs.xxi == 6)
      {
        localObject = this.xAs.xxj;
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
      ac.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_OK");
      if (((com.tencent.mm.plugin.shake.c.a.g)localObject).nWg == 3)
      {
        ac.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is  MMBIZ_SHAKE_CARD_ACTION_TYPE_NO_CARD");
        if ((parame != null) && (!TextUtils.isEmpty(parame.xxL)))
        {
          ast(parame.xxL);
          AppMethodBeat.o(28507);
          return;
        }
        ast(getString(2131763550));
        AppMethodBeat.o(28507);
        return;
      }
      ac.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is " + ((com.tencent.mm.plugin.shake.c.a.g)localObject).nWg);
      NQ(3);
      if (parame.nWg == 1) {
        this.xAo = false;
      }
      if ((this.xBl != null) && (this.xBl.isShowing()))
      {
        AppMethodBeat.o(28507);
        return;
      }
      if (parame.xxN)
      {
        localObject = (ViewStub)findViewById(2131306441);
        if (localObject != null) {
          ((ViewStub)localObject).inflate();
        }
        ((ShakeEggAnimFrame)findViewById(2131297976)).aC(this);
        new ao().postDelayed(new Runnable()
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
      ac.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_ERR_REPORT");
      ast(getString(2131763550));
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
    dEa();
    if (!this.xAn) {
      qt(true);
    }
    AppMethodBeat.o(28511);
  }
  
  public final void ayD()
  {
    AppMethodBeat.i(28504);
    dDZ();
    AppMethodBeat.o(28504);
  }
  
  public final void d(List<com.tencent.mm.plugin.shake.b.d> paramList, long paramLong)
  {
    AppMethodBeat.i(28506);
    dEj();
    if ((paramList == null) || (!this.xAm) || (paramLong == 6L))
    {
      this.xAQ = null;
      if (paramLong == 6L)
      {
        ast(getString(2131763569));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 7L)
      {
        ast(getString(2131763567));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 8L)
      {
        ast(getString(2131763565));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 9L)
      {
        ast(getString(2131763564));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 10L)
      {
        ast(getString(2131763568));
        AppMethodBeat.o(28506);
        return;
      }
      ast(null);
      AppMethodBeat.o(28506);
      return;
    }
    this.xAm = false;
    if (paramList.size() > 0) {
      this.xAQ = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0));
    }
    int i;
    Object localObject;
    if (this.xAs.xxi == 1)
    {
      if ((paramList.size() > 0) && (((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_type != 0))
      {
        ast(null);
        AppMethodBeat.o(28506);
        return;
      }
      this.xAq = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).scene;
      i = paramList.size();
      if (i == 0)
      {
        ast(null);
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        localObject = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_username;
        String str = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_nickname;
        ac.i("MicroMsg.ShakeReportUI", "1 u:" + (String)localObject + " n:" + str + " d:" + ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_distance);
        if (this.xAl) {
          bc.aF(getContext(), 2131763587);
        }
        NQ(3);
        c((com.tencent.mm.plugin.shake.b.d)paramList.get(0));
        AppMethodBeat.o(28506);
        return;
      }
      if (this.xAl) {
        bc.aF(getContext(), 2131763587);
      }
      NQ(3);
      qu(false);
      paramList = new Intent(this, ShakeItemListUI.class);
      paramList.putExtra("_key_show_type_", -1);
      paramList.putExtra("_key_title_", getString(2131763582));
      paramList = new com.tencent.mm.hellhoundlib.b.a().ba(paramList);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramList.aeD(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramList.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(28506);
      return;
    }
    if (this.xAs.xxi == 3)
    {
      i = paramList.size();
      if (i == 0)
      {
        ast(getString(2131763594));
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        if (this.xAl) {
          bc.aF(getContext(), 2131763587);
        }
        NQ(3);
        if (((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_type == 4)
        {
          paramList = com.tencent.mm.plugin.shake.d.a.i.d(((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_lvbuffer, paramLong);
          com.tencent.mm.ay.a.d(paramList);
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_mode", 1);
          ((Intent)localObject).putExtra("key_offset", paramList.hNT);
          ((Intent)localObject).putExtra("music_player_beg_time", paramList.hOl);
          ((Intent)localObject).putExtra("key_scene", 3);
          if (com.tencent.mm.ay.e.aGE()) {
            ((Intent)localObject).putExtra("KGlobalShakeMusic", true);
          }
          com.tencent.mm.br.d.b(this, "music", ".ui.MusicMainUI", (Intent)localObject);
          AppMethodBeat.o(28506);
          return;
        }
        ac.w("MicroMsg.ShakeReportUI", "Unexpected type, ignore.");
      }
      AppMethodBeat.o(28506);
      return;
    }
    if (this.xAs.xxi == 4)
    {
      dEj();
      i = paramList.size();
      if (i == 0)
      {
        ast(getString(2131763638));
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        if (this.xAl) {
          bc.aF(getContext(), 2131763587);
        }
        NQ(3);
        com.tencent.mm.plugin.shake.d.a.k.a((com.tencent.mm.plugin.shake.b.d)paramList.get(0), this);
      }
      AppMethodBeat.o(28506);
      return;
    }
    if (this.xAs.xxi == 5) {
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
          if (this.xAl) {
            bc.aF(getContext(), 2131763587);
          }
          NQ(3);
          d((com.tencent.mm.plugin.shake.b.d)paramList.get(0));
          AppMethodBeat.o(28506);
          return;
        }
        if (this.xAl) {
          bc.aF(getContext(), 2131763587);
        }
        NQ(3);
        qu(false);
        localObject = new Intent(this, ShakeItemListUI.class);
        ((Intent)localObject).putExtra("_key_show_type_", -12);
        ((Intent)localObject).putExtra("_key_title_", getString(2131763580));
        ((Intent)localObject).putExtra("_key_show_from_shake_", true);
        ((Intent)localObject).putExtra("_ibeacon_new_insert_size", paramList.size());
        paramList = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramList.aeD(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramList.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(28506);
        return;
      }
      ast(null);
      AppMethodBeat.o(28506);
      return;
      ast(getString(2131763569));
    }
  }
  
  public final void dDu()
  {
    AppMethodBeat.i(28516);
    com.tencent.mm.plugin.shake.c.c.a.dDf();
    dEb();
    dEc();
    dEf();
    dEg();
    dEe();
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
    com.tencent.mm.plugin.shake.c.c.a.dDf();
    this.xBn.put(Integer.valueOf(1), Boolean.TRUE);
    this.xBn.put(Integer.valueOf(3), Boolean.FALSE);
    this.xBn.put(Integer.valueOf(4), Boolean.FALSE);
    this.xBn.put(Integer.valueOf(5), Boolean.FALSE);
    this.xBn.put(Integer.valueOf(6), Boolean.FALSE);
    this.hJM = new com.tencent.mm.av.a.a(this);
    this.xAw = ((TextView)findViewById(2131304704));
    this.xAv = findViewById(2131304720);
    this.xAx = ((TextView)findViewById(2131304699));
    this.xAy = ((TextView)findViewById(2131304703));
    this.xBa = findViewById(2131304734);
    this.xBb = ((ImageView)findViewById(2131304722));
    this.xBc = ((ImageView)findViewById(2131304724));
    this.xBd = ((ImageView)findViewById(2131304726));
    this.xBe = ((ImageView)findViewById(2131304728));
    this.xBf = findViewById(2131304723);
    this.xBg = findViewById(2131304725);
    this.xBh = findViewById(2131304727);
    this.xBi = findViewById(2131304729);
    this.xAu = findViewById(2131304702);
    this.xAu.setOnClickListener(this.xBx);
    this.fxQ = ((ImageView)this.xAu.findViewById(2131304688));
    this.fxQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28477);
        if (ShakeReportUI.q(ShakeReportUI.this) != 5)
        {
          Object localObject = new Intent(ShakeReportUI.this.getContext(), ProfileHdHeadImg.class);
          ((Intent)localObject).putExtra("username", (String)ShakeReportUI.r(ShakeReportUI.this).getTag());
          paramAnonymousView = ShakeReportUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(28477);
      }
    });
    dDX();
    Object localObject = View.inflate(getContext(), 2131495416, null);
    this.xAO = new com.tencent.mm.ui.base.i(getContext(), 2131821723);
    this.xAO.setContentView((View)localObject);
    this.xAO.setOnCancelListener(new DialogInterface.OnCancelListener()
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
            az.ayM();
            com.tencent.mm.model.c.agA().set(4117, Boolean.TRUE);
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
    az.ayM();
    boolean bool1 = com.tencent.mm.sdk.platformtools.bs.l((Boolean)com.tencent.mm.model.c.agA().get(4108, null));
    az.ayM();
    boolean bool2 = com.tencent.mm.sdk.platformtools.bs.l((Boolean)com.tencent.mm.model.c.agA().get(4117, null));
    if (!bool1)
    {
      ((View)localObject).setVisibility(0);
      this.xAO.show();
      az.ayM();
      com.tencent.mm.model.c.agA().set(4108, Boolean.TRUE);
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
      if ((!this.xBr) && (!this.xBp)) {
        break label772;
      }
    }
    label772:
    for (this.xAP = ((ImageView)findViewById(2131304713));; this.xAP = ((ImageView)findViewById(2131304712)))
    {
      this.xAR = ((ImageView)findViewById(2131304709));
      this.xAS = ((ImageView)findViewById(2131304715));
      this.xAT = ((ImageView)findViewById(2131304718));
      this.xAU = ((ImageView)findViewById(2131304705));
      this.xAX = ((TextView)findViewById(2131304708));
      this.xAW = ((ImageView)findViewById(2131304707));
      this.xAV = ((ImageView)findViewById(2131304717));
      dEf();
      this.xBj.setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304714).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304710).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304716).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304719).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304706).setOnClickListener((View.OnClickListener)localObject);
      com.tencent.mm.sdk.b.a.GpY.c(this.xBv);
      com.tencent.mm.sdk.b.a.GpY.c(this.xBw);
      dEb();
      dEe();
      dEj();
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
          az.ayM();
          com.tencent.mm.model.c.agA().set(4117, Boolean.TRUE);
          AppMethodBeat.o(28452);
          return false;
        }
      });
      break;
    }
  }
  
  public final void k(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(28515);
    if ((paramString == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(28515);
      return;
    }
    if ((this.xAJ != null) && (this.xAJ.getTag() != null) && (paramString.equals((String)this.xAJ.getTag()))) {
      this.xAJ.setImageBitmap(paramBitmap);
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
      az.ayM();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.model.c.awL() + "custom_shake_img_filename.jpg");
      com.tencent.mm.plugin.shake.a.iyx.a(localIntent, 2, this, paramIntent);
      AppMethodBeat.o(28510);
      return;
    case 2: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(28510);
        return;
      }
      paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
      az.ayM();
      com.tencent.mm.model.c.agA().set(4110, Boolean.FALSE);
      az.ayM();
      com.tencent.mm.model.c.agA().set(4111, paramIntent);
      dDX();
      AppMethodBeat.o(28510);
      return;
    }
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
      {
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRN, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
        this.iMq = false;
        AppMethodBeat.o(28510);
        return;
      }
      this.iMq = true;
      finish();
      AppMethodBeat.o(28510);
      return;
    }
    this.iMq = true;
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
    this.fmW = com.tencent.mm.modelgeo.d.aEL();
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GEV, "");
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GEW, "");
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GHB, "");
    this.xBj = findViewById(2131304711);
    paramBundle = com.tencent.mm.model.bs.azs();
    Object localObject1 = com.tencent.mm.sdk.platformtools.bs.nullAsNil(paramBundle.provinceCode);
    Object localObject2 = com.tencent.mm.sdk.platformtools.bs.nullAsNil(paramBundle.cityCode);
    paramBundle = com.tencent.mm.m.g.ZZ().ag("IBeacon", "GatedLaunch");
    int i;
    int j;
    if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramBundle))
    {
      this.xBp = false;
      this.xBq = false;
      if (paramBundle != null) {}
      try
      {
        paramBundle = new JSONObject(paramBundle);
        i = paramBundle.getInt("gatedlaunch");
        az.agM();
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
            Object localObject3 = com.tencent.mm.plugin.shake.b.m.dDl();
            ((com.tencent.mm.plugin.shake.b.e)localObject3).dDb();
            ((com.tencent.mm.plugin.shake.b.e)localObject3).a((com.tencent.mm.plugin.shake.b.d)localObject2, true);
            localObject3 = new LinkedList();
            ((List)localObject3).add(localObject2);
            d((List)localObject3, 1L);
            az.ayM();
            com.tencent.mm.model.c.agA().set(ah.a.GHm, "");
            paramBundle = paramBundle + "," + localObject1[4] + localObject1[5] + localObject1[6];
            az.ayM();
            com.tencent.mm.model.c.agA().set(ah.a.GHn, paramBundle);
            this.xAr = new c(getBodyView());
            this.shakeSensor = new com.tencent.mm.pluginsdk.j.d();
            if (!this.shakeSensor.eMr()) {
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
            if (com.tencent.mm.plugin.shake.a.iyy != null) {
              com.tencent.mm.plugin.shake.a.iyy.Lj();
            }
            u.b(this);
            ac.i("MicroMsg.ShakeReportUI", "%s", new Object[] { getResources().getDisplayMetrics().toString() });
            i = com.tencent.mm.plugin.shake.b.m.dDm().bQe();
            com.tencent.mm.plugin.report.service.h.wUl.f(11317, new Object[] { Integer.valueOf(i), e.dEl() });
            com.tencent.mm.plugin.report.service.h.wUl.f(11710, new Object[] { Integer.valueOf(1) });
            com.tencent.mm.plugin.report.service.h.wUl.n(834L, 0L, 1L);
            AppMethodBeat.o(28484);
            return;
            if (i != 4) {
              continue;
            }
            this.xBp = true;
            this.xBq = true;
            continue;
            paramBundle = paramBundle;
            ac.e("MicroMsg.ShakeReportUI", "[shakezb]parse dymanic setting json fail!!");
            this.xBp = false;
            this.xBq = false;
            continue;
            this.xBs = 1;
            continue;
            com.tencent.mm.plugin.report.service.h.wUl.f(13139, new Object[] { localObject1, localObject2, Integer.valueOf(0), Integer.valueOf(this.xBs), Integer.valueOf(i), Integer.valueOf(j) });
            continue;
            if (paramBundle == null) {
              continue;
            }
            paramBundle.getState();
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            ac.e("MicroMsg.ShakeReportUI", "[kevinkma]parst shakeItem error!");
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
          this.xBp = true;
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
        this.xBp = true;
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
            this.xBq = true;
            this.xBp = true;
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
        this.xBq = true;
        this.xBp = true;
        break label1585;
        if (i == 3)
        {
          this.xBp = true;
          this.xBq = false;
          label493:
          if (az.agM())
          {
            az.ayM();
            if (((Integer)com.tencent.mm.model.c.agA().get(ah.a.GHt, Integer.valueOf(0))).intValue() == 1) {
              this.xBr = true;
            }
          }
          paramBundle = BluetoothAdapter.getDefaultAdapter();
          boolean bool = com.tencent.mm.sdk.platformtools.ai.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
          if ((paramBundle == null) || (!bool) || (Build.VERSION.SDK_INT < 18) || (paramBundle.getState() != 12)) {
            break label1450;
          }
          this.xBs = 0;
          if ((paramBundle == null) || (paramBundle.getState() != 12)) {
            break label1554;
          }
          i = 1;
          if (!bool) {
            break label1549;
          }
          j = 1;
          if (!this.xBp) {
            break label1458;
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(13139, new Object[] { localObject1, localObject2, Integer.valueOf(1), Integer.valueOf(this.xBs), Integer.valueOf(i), Integer.valueOf(j) });
          if ((this.xBr) || (this.xBp))
          {
            this.xBo = true;
            this.xBj = findViewById(2131304714);
            if (this.xBq)
            {
              if ((paramBundle != null) && (paramBundle.getState() == 12)) {
                break label1516;
              }
              this.xBo = false;
            }
          }
          paramBundle = com.tencent.mm.plugin.shake.b.m.dDq();
          if (paramBundle.nTa == null) {
            paramBundle.nTa = new ArrayList();
          }
          paramBundle.nTa.add(new WeakReference(this));
          paramBundle = Boolean.FALSE;
          long l3 = com.tencent.mm.sdk.platformtools.bs.aNx();
          long l2 = 0L;
          long l1 = 0L;
          if (az.agM())
          {
            az.ayM();
            com.tencent.mm.model.c.agA().set(ah.a.GHq, Boolean.TRUE);
            az.ayM();
            bool = com.tencent.mm.sdk.platformtools.bs.a((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GHo, null), false);
            az.ayM();
            l2 = com.tencent.mm.sdk.platformtools.bs.a((Long)com.tencent.mm.model.c.agA().get(ah.a.GHp, null), 0L);
            az.ayM();
            l1 = com.tencent.mm.sdk.platformtools.bs.a((Long)com.tencent.mm.model.c.agA().get(ah.a.GHj, null), 0L);
            paramBundle = Boolean.valueOf(bool);
          }
          if ((!paramBundle.booleanValue()) || (l3 - l2 >= l1)) {
            break label1542;
          }
          this.xAY = 5;
          this.xBo = true;
          this.xAm = true;
          initView();
          dDZ();
          az.ayM();
          paramBundle = com.tencent.mm.sdk.platformtools.bs.bG((String)com.tencent.mm.model.c.agA().get(ah.a.GHn, null), "");
          az.ayM();
          localObject1 = com.tencent.mm.sdk.platformtools.bs.bG((String)com.tencent.mm.model.c.agA().get(ah.a.GHm, null), "");
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
    if ((this.xAN != null) && (!this.xAN.isRecycled())) {
      this.xAN.recycle();
    }
    if ((this.xAO != null) && (this.xAO.isShowing()))
    {
      this.xAO.dismiss();
      this.xAO = null;
    }
    if (this.xAs.xxj != null) {
      this.xAs.xxj.dCP();
    }
    if (this.shakeSensor != null)
    {
      this.shakeSensor.bXB();
      this.shakeSensor = null;
    }
    Object localObject = j.a(null);
    if (j.icd)
    {
      j.icd = false;
      if (!((j)localObject).xzl.dDM()) {
        ac.e("Micromsg.ShakeMusicMgr", "release MusicFingerPrintRecorder error");
      }
    }
    j.xzm = null;
    u.c(this);
    com.tencent.mm.sdk.b.a.GpY.d(this.xBv);
    com.tencent.mm.sdk.b.a.GpY.d(this.xBw);
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GHq, Boolean.FALSE);
    dDV();
    if (com.tencent.mm.plugin.shake.c.c.a.dDK()) {
      com.tencent.mm.y.c.aeH().x(262154, false);
    }
    dEd();
    localObject = com.tencent.mm.plugin.shake.b.m.dDq();
    int i;
    if (((com.tencent.mm.plugin.shake.c.a.f)localObject).nTa != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < ((com.tencent.mm.plugin.shake.c.a.f)localObject).nTa.size())
      {
        WeakReference localWeakReference = (WeakReference)((com.tencent.mm.plugin.shake.c.a.f)localObject).nTa.get(i);
        if (localWeakReference != null)
        {
          f.a locala = (f.a)localWeakReference.get();
          if ((locala != null) && (locala.equals(this))) {
            ((com.tencent.mm.plugin.shake.c.a.f)localObject).nTa.remove(localWeakReference);
          }
        }
      }
      else
      {
        localObject = com.tencent.mm.plugin.shake.b.m.dDr();
        ((com.tencent.mm.plugin.shake.c.a.d)localObject).fmX = -85.0F;
        ((com.tencent.mm.plugin.shake.c.a.d)localObject).fmY = -1000.0F;
        if (this.fmW != null) {
          this.fmW.c(this.fnd);
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
    az.ayM();
    com.tencent.mm.model.c.b(this);
    az.ayM();
    com.tencent.mm.model.c.agA().b(this);
    com.tencent.mm.plugin.shake.b.m.dDl().remove(this);
    if (this.xAs.xxj != null) {
      this.xAs.xxj.pause();
    }
    this.xAo = false;
    if (this.shakeSensor != null) {
      this.shakeSensor.bXB();
    }
    this.xAr.dDR();
    if (this.xAY != 5)
    {
      az.ayM();
      com.tencent.mm.model.c.agA().set(327696, this.xAY);
    }
    if (this.xAY == 4) {
      qs(false);
    }
    dDV();
    super.onPause();
    AppMethodBeat.o(28487);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(28527);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.ShakeReportUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(28527);
      return;
    }
    ac.i("MicroMsg.ShakeReportUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$27", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
          dsQ();
          AppMethodBeat.o(28527);
          return;
        }
        this.iMq = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28470);
            paramAnonymousDialogInterface = ShakeReportUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$29", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
    if (this.iMq) {
      if (com.tencent.mm.aw.b.CQ((String)com.tencent.mm.kernel.g.agR().agA().get(274436, null)))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.ACCESS_COARSE_LOCATION"))
        {
          if (!((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRN, Boolean.FALSE)).booleanValue())
          {
            com.tencent.mm.plugin.account.a.b.a.b(this, getString(2131760740, new Object[] { com.tencent.mm.sdk.platformtools.ab.eUO() }), 30764, true);
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
        ac.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkposition[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), com.tencent.mm.sdk.platformtools.bs.eWi(), this });
        if (!bool)
        {
          AppMethodBeat.o(28485);
          return;
        }
      }
    }
    dsQ();
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
    private final long[] iwT;
    private long lastShakeTime;
    private Vibrator njY;
    WeakReference<ShakeReportUI> xBF;
    
    public a(ShakeReportUI paramShakeReportUI)
    {
      AppMethodBeat.i(28481);
      this.lastShakeTime = com.tencent.mm.sdk.platformtools.bs.Gn();
      this.iwT = new long[] { 300L, 200L, 300L, 200L };
      this.xBF = new WeakReference(paramShakeReportUI);
      AppMethodBeat.o(28481);
    }
    
    public final void onRelease() {}
    
    public final void onShake(boolean paramBoolean)
    {
      AppMethodBeat.i(28482);
      ShakeReportUI localShakeReportUI = (ShakeReportUI)this.xBF.get();
      if (localShakeReportUI == null)
      {
        AppMethodBeat.o(28482);
        return;
      }
      if (localShakeReportUI.isFinishing())
      {
        ac.e("MicroMsg.ShakeReportUI", "ui finished");
        AppMethodBeat.o(28482);
        return;
      }
      if (!ShakeReportUI.v(localShakeReportUI))
      {
        ac.i("MicroMsg.ShakeReportUI", "tryShake the status is can's shake");
        AppMethodBeat.o(28482);
        return;
      }
      ShakeReportUI.w(localShakeReportUI);
      long l = com.tencent.mm.sdk.platformtools.bs.aO(this.lastShakeTime);
      if (l < 1200L)
      {
        ac.i("MicroMsg.ShakeReportUI", "tryStartShake delay too short:".concat(String.valueOf(l)));
        AppMethodBeat.o(28482);
        return;
      }
      ac.w("MicroMsg.ShakeReportUI", "tryStartShake delaytoo enough:".concat(String.valueOf(l)));
      this.lastShakeTime = com.tencent.mm.sdk.platformtools.bs.Gn();
      Object localObject;
      if (ShakeReportUI.x(localShakeReportUI) != null)
      {
        localObject = ShakeReportUI.x(localShakeReportUI);
        if (((c)localObject).view != null) {
          ((c)localObject).view.setKeepScreenOn(true);
        }
        ((c)localObject).cLS.au(30000L, 30000L);
      }
      if (ShakeReportUI.y(localShakeReportUI) != null)
      {
        localObject = ShakeReportUI.y(localShakeReportUI);
        if (((com.tencent.mm.pluginsdk.ui.f)localObject).DnG != null) {
          ((com.tencent.mm.pluginsdk.ui.f)localObject).DnG.dismiss();
        }
      }
      if (ShakeReportUI.z(localShakeReportUI))
      {
        localObject = (ShakeReportUI)this.xBF.get();
        if (localObject != null) {
          bc.aF((Context)localObject, 2131763618);
        }
      }
      for (;;)
      {
        reset();
        ShakeReportUI.A(localShakeReportUI);
        AppMethodBeat.o(28482);
        return;
        localObject = (ShakeReportUI)this.xBF.get();
        if (localObject != null)
        {
          if (this.njY == null) {
            this.njY = ((Vibrator)((ShakeReportUI)localObject).getSystemService("vibrator"));
          }
          if (this.njY != null) {
            this.njY.vibrate(this.iwT, -1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI
 * JD-Core Version:    0.7.0.1
 */