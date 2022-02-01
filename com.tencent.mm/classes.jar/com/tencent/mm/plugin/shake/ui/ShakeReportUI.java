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
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
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
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.bb.n;
import com.tencent.mm.g.a.ei;
import com.tencent.mm.g.a.eo;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.c;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.c.a.f.a;
import com.tencent.mm.plugin.shake.d.a.h.a;
import com.tencent.mm.plugin.shake.d.a.j;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.d.a.k.1;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cl;
import com.tencent.mm.storage.cm;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.p;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ShakeReportUI
  extends MMActivity
  implements bc, u.a, l.a, f.a, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
{
  private static List<h.a> gmy;
  private boolean DjV;
  private boolean DjW;
  private boolean DjX;
  private boolean DjY;
  private boolean DjZ;
  private Dialog DkA;
  private ImageView DkB;
  private com.tencent.mm.plugin.shake.b.d DkC;
  private ImageView DkD;
  private ImageView DkE;
  private ImageView DkF;
  private ImageView DkG;
  private ImageView DkH;
  private ImageView DkI;
  private TextView DkJ;
  private int DkK;
  private int DkL;
  private View DkM;
  private ImageView DkN;
  private ImageView DkO;
  private ImageView DkP;
  private ImageView DkQ;
  private View DkR;
  private View DkS;
  private View DkT;
  private View DkU;
  private int DkV;
  private com.tencent.mm.plugin.shake.c.b.a DkW;
  private boolean DkX;
  @SuppressLint({"UseSparseArrays"})
  private Map<Integer, Boolean> DkY;
  private boolean DkZ;
  private boolean Dka;
  private boolean Dkb;
  private int Dkc;
  private c Dkd;
  private com.tencent.mm.plugin.shake.b.l Dke;
  private com.tencent.mm.pluginsdk.ui.g Dkf;
  private View Dkg;
  private View Dkh;
  private TextView Dki;
  private TextView Dkj;
  private TextView Dkk;
  private View Dkl;
  private View Dkm;
  private View Dkn;
  private View Dko;
  private Animation Dkp;
  private Animation Dkq;
  private Animation Dkr;
  private Animation Dks;
  private View Dkt;
  private View Dku;
  private MMImageView Dkv;
  private TextView Dkw;
  private ImageView Dkx;
  private String Dky;
  private Bitmap Dkz;
  private boolean Dla;
  private boolean Dlb;
  private boolean Dlc;
  private int Dld;
  private long Dle;
  private boolean Dlf;
  private IListener Dlg;
  private IListener Dlh;
  private View.OnClickListener Dli;
  private b.a gmA;
  private com.tencent.mm.modelgeo.d gmt;
  private boolean gmw;
  private Map<String, h.a> gmx;
  private ImageView gyr;
  private com.tencent.mm.av.a.a jaq;
  private boolean kgv;
  private com.tencent.mm.pluginsdk.l.d shakeSensor;
  private boolean uSu;
  
  static
  {
    AppMethodBeat.i(28541);
    gmy = new CopyOnWriteArrayList();
    AppMethodBeat.o(28541);
  }
  
  public ShakeReportUI()
  {
    AppMethodBeat.i(28483);
    this.DjV = false;
    this.DjW = false;
    this.DjY = false;
    this.DjZ = false;
    this.Dka = false;
    this.Dkb = false;
    this.Dkc = 22;
    this.Dke = new com.tencent.mm.plugin.shake.b.l();
    this.Dkt = null;
    this.Dku = null;
    this.Dkv = null;
    this.Dkw = null;
    this.Dkx = null;
    this.Dky = "";
    this.Dkz = null;
    this.DkB = null;
    this.jaq = null;
    this.DkC = null;
    this.DkK = 1;
    this.DkL = 0;
    this.DkV = 0;
    this.DkX = false;
    this.DkY = new HashMap();
    this.DkZ = false;
    this.Dla = false;
    this.Dlb = false;
    this.Dlc = false;
    this.Dld = 1;
    this.kgv = true;
    this.gmw = false;
    this.gmA = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(28446);
        if (paramAnonymousBoolean)
        {
          Log.d("MicroMsg.ShakeReportUI", "on location get ok");
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(ar.a.NTL, String.valueOf(paramAnonymousFloat2));
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(ar.a.NTM, String.valueOf(paramAnonymousFloat1));
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(ar.a.NWs, String.valueOf(paramAnonymousDouble2));
          ShakeReportUI.a(ShakeReportUI.this);
          if (ShakeReportUI.b(ShakeReportUI.this) != null) {
            ShakeReportUI.b(ShakeReportUI.this).c(ShakeReportUI.c(ShakeReportUI.this));
          }
        }
        for (;;)
        {
          AppMethodBeat.o(28446);
          return false;
          if ((!ShakeReportUI.d(ShakeReportUI.this)) && (!com.tencent.mm.modelgeo.d.bcc()))
          {
            ShakeReportUI.e(ShakeReportUI.this);
            com.tencent.mm.ui.base.h.a(ShakeReportUI.this, ShakeReportUI.this.getString(2131761461), ShakeReportUI.this.getString(2131755998), ShakeReportUI.this.getString(2131762043), ShakeReportUI.this.getString(2131755761), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(28445);
                com.tencent.mm.modelgeo.d.cZ(ShakeReportUI.this);
                AppMethodBeat.o(28445);
              }
            }, null);
          }
          Log.w("MicroMsg.ShakeReportUI", "getLocation fail");
        }
      }
    };
    this.gmx = new ConcurrentHashMap();
    this.Dle = 0L;
    this.Dlf = false;
    this.Dlg = new IListener() {};
    this.Dlh = new IListener() {};
    this.Dli = new View.OnClickListener()
    {
      public long DjA = 0L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28467);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        if (Util.isNullOrNil((String)ShakeReportUI.r(ShakeReportUI.this).getTag()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28467);
          return;
        }
        if (ShakeReportUI.N(ShakeReportUI.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28467);
          return;
        }
        paramAnonymousView = ShakeReportUI.N(ShakeReportUI.this);
        localObject1 = paramAnonymousView.field_username;
        if (11 == paramAnonymousView.field_type)
        {
          if (System.currentTimeMillis() - this.DjA > 3000L)
          {
            this.DjA = System.currentTimeMillis();
            if ((paramAnonymousView.field_reserved3 == null) || (paramAnonymousView.field_reserved3.split(",").length != 3) || (paramAnonymousView.field_reserved3.split(",")[0] == null) || (paramAnonymousView.field_reserved3.split(",")[0].equals(""))) {
              break label324;
            }
            localObject1 = paramAnonymousView.field_reserved3.split(",");
            localObject2 = new wq();
            ((wq)localObject2).ecI.userName = localObject1[0];
            ((wq)localObject2).ecI.ecK = Util.nullAs(localObject1[1], "");
            ((wq)localObject2).ecI.ecL = Util.getInt(localObject1[2], 0);
            ((wq)localObject2).ecI.scene = 1077;
            EventCenter.instance.publish((IEvent)localObject2);
          }
          for (;;)
          {
            localObject1 = ShakeReportUI.E(ShakeReportUI.this).DgW;
            if ((localObject1 != null) && ((localObject1 instanceof com.tencent.mm.plugin.shake.d.a.h)))
            {
              com.tencent.mm.plugin.shake.d.a.h.a(paramAnonymousView);
              com.tencent.mm.plugin.shake.d.a.h.b(paramAnonymousView);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(28467);
            return;
            label324:
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("rawUrl", paramAnonymousView.getCity());
            ((Intent)localObject1).putExtra("scene", 27);
            ((Intent)localObject1).putExtra("stastic_scene", 5);
            com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          }
        }
        bg.aVF();
        Object localObject2 = com.tencent.mm.model.c.aSN().Kn((String)localObject1);
        if (com.tencent.mm.contact.c.oR(((ax)localObject2).field_type))
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", (String)localObject1);
          paramAnonymousView.putExtra("Sns_from_Scene", 22);
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            if (((as)localObject2).gBM())
            {
              com.tencent.mm.plugin.report.service.h.CyF.kvStat(10298, (String)localObject1 + "," + ShakeReportUI.O(ShakeReportUI.this));
              paramAnonymousView.putExtra("Contact_Scene", ShakeReportUI.O(ShakeReportUI.this));
            }
            com.tencent.mm.plugin.shake.a.jRt.c(paramAnonymousView, ShakeReportUI.this);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28467);
          return;
          if ((paramAnonymousView.field_reserved1 & 0x8) > 0) {
            com.tencent.mm.plugin.report.service.h.CyF.kvStat(10298, paramAnonymousView.field_username + "," + ShakeReportUI.O(ShakeReportUI.this));
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
          com.tencent.mm.plugin.shake.a.jRt.c((Intent)localObject1, ShakeReportUI.this);
        }
      }
    };
    AppMethodBeat.o(28483);
  }
  
  private void XD(int paramInt)
  {
    AppMethodBeat.i(28503);
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      uC(bool);
      if (paramInt != 2) {
        break;
      }
      uB(true);
      AppMethodBeat.o(28503);
      return;
    }
    uB(false);
    AppMethodBeat.o(28503);
  }
  
  private void a(com.tencent.mm.plugin.shake.c.a.e parame)
  {
    AppMethodBeat.i(28508);
    this.DkW = com.tencent.mm.plugin.shake.c.b.a.a(this, parame, new DialogInterface.OnCancelListener()new com.tencent.mm.plugin.shake.c.b.a.b
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
      public final void exp()
      {
        AppMethodBeat.i(28466);
        ShakeReportUI.b(ShakeReportUI.this, true);
        ShakeReportUI.M(ShakeReportUI.this).setText("");
        AppMethodBeat.o(28466);
      }
    });
    AppMethodBeat.o(28508);
  }
  
  private void aNt(String paramString)
  {
    AppMethodBeat.i(28505);
    this.DjY = false;
    if (this.DjX) {
      PlaySound.play(getContext(), 2131765783);
    }
    if (this.Dks == null) {
      this.Dks = AnimationUtils.loadAnimation(getContext(), 2130772050);
    }
    XD(2);
    if ((paramString != null) && (paramString.length() > 1)) {
      this.Dkj.setText(paramString);
    }
    for (;;)
    {
      this.Dkj.startAnimation(this.Dks);
      this.Dkb = true;
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28463);
          ShakeReportUI.K(ShakeReportUI.this);
          ShakeReportUI.d(ShakeReportUI.this, false);
          AppMethodBeat.o(28463);
        }
      }, this.Dks.getDuration());
      AppMethodBeat.o(28505);
      return;
      this.Dkj.setText(2131765749);
    }
  }
  
  private void cb(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(28519);
    this.DjY = false;
    if (this.Dks == null) {
      this.Dks = AnimationUtils.loadAnimation(getContext(), 2130772050);
    }
    XD(2);
    uB(true);
    if ((paramString != null) && (paramString.length() > 1)) {
      this.Dkj.setText(paramString);
    }
    for (;;)
    {
      this.Dkb = true;
      AppMethodBeat.o(28519);
      return;
      if (paramBoolean)
      {
        this.Dkj.setText(2131765739);
      }
      else
      {
        this.Dkj.setText("");
        uB(false);
      }
    }
  }
  
  private void eHs()
  {
    AppMethodBeat.i(28486);
    eUW();
    bg.aVF();
    com.tencent.mm.model.c.a(this);
    bg.aVF();
    com.tencent.mm.model.c.azQ().add(this);
    com.tencent.mm.plugin.shake.b.m.eUm().add(this);
    if (this.Dke.DgW != null) {
      this.Dke.DgW.resume();
    }
    eUX();
    new MMHandler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28471);
        if (ShakeReportUI.f(ShakeReportUI.this) != null) {
          ShakeReportUI.f(ShakeReportUI.this).gol();
        }
        AppMethodBeat.o(28471);
      }
    }, 1000L);
    if (this.shakeSensor != null) {
      this.shakeSensor.gol();
    }
    uB(false);
    uC(false);
    eUZ();
    bg.aVF();
    Object localObject = (String)com.tencent.mm.model.c.azQ().get(327696, "1");
    if (k.eUk())
    {
      if (this.DkK == 4) {
        ux(true);
      }
      if (((String)localObject).equals("4")) {
        eW(findViewById(2131307776));
      }
    }
    boolean bool;
    if (((String)localObject).equals("3"))
    {
      eW(findViewById(2131307773));
      bool = com.tencent.mm.y.c.axV().cP(262154, 266258);
      if ((!getIntent().getBooleanExtra("shake_music", false)) || (!com.tencent.mm.ay.e.bek()) || (this.Dke.DgV == 3)) {
        break label353;
      }
      getIntent().putExtra("shake_music", false);
      this.DkK = 3;
    }
    for (;;)
    {
      eUY();
      uy(true);
      Log.d("MicroMsg.ShakeReportUI", "isShakeGetConfigList = %s", new Object[] { Boolean.valueOf(ac.jOs) });
      if (ac.jOs)
      {
        localObject = new n(7);
        bg.azz().a((q)localObject, 0);
      }
      eVi();
      eVf();
      AppMethodBeat.o(28486);
      return;
      if ((!((String)localObject).equals("6")) || (!com.tencent.mm.plugin.shake.c.c.a.eUL())) {
        break;
      }
      eW(findViewById(2131307763));
      break;
      label353:
      if ((getIntent().getBooleanExtra("shake_tv", false)) && (this.Dke.DgV != 4) && (k.eUk()))
      {
        getIntent().putExtra("shake_tv", false);
        this.DkK = 4;
      }
      else if ((this.Dke.DgV != 6) && (com.tencent.mm.plugin.shake.c.c.a.eUL()) && ((bool) || (getIntent().getBooleanExtra("shake_card", false))))
      {
        this.DkV = getIntent().getIntExtra("shake_card", 0);
        getIntent().putExtra("shake_card", false);
        Log.i("MicroMsg.ShakeReportUI", "onresume shake card tab is open, activity type is 0 or open from specialview");
        this.DkK = 6;
      }
    }
  }
  
  private void eUV()
  {
    AppMethodBeat.i(28492);
    if (com.tencent.mm.ay.e.bel())
    {
      bg.aVF();
      if (com.tencent.mm.model.c.azQ().getInt(4118, 0) == 0)
      {
        com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(getContext());
        locala.aoO(2131755998);
        locala.aoS(2131765759);
        locala.aoV(2131765758).c(new ShakeReportUI.2(this));
        locala.Dk(true);
        locala.f(new ShakeReportUI.3(this));
        this.DkA = locala.hbn();
        this.DkA.show();
      }
    }
    AppMethodBeat.o(28492);
  }
  
  private void eUW()
  {
    AppMethodBeat.i(28493);
    bg.aVF();
    int j = Util.nullAs((Integer)com.tencent.mm.model.c.azQ().get(12290, null), 0);
    ImageView localImageView = (ImageView)findViewById(2131307757);
    if ((this.Dkz != null) && (!this.Dkz.isRecycled())) {
      this.Dkz.recycle();
    }
    bg.aVF();
    Object localObject1;
    if (Util.nullAsTrue((Boolean)com.tencent.mm.model.c.azQ().get(4110, null)))
    {
      localObject1 = new StringBuilder();
      bg.aVF();
      localObject1 = com.tencent.mm.model.c.aSY() + "default_shake_img_filename.jpg";
      if (com.tencent.mm.vfs.s.YS((String)localObject1))
      {
        this.Dkz = u.Sq((String)localObject1);
        localImageView.setImageDrawable(new BitmapDrawable(this.Dkz));
        localObject1 = (ImageView)findViewById(2131307743);
        localImageView = (ImageView)findViewById(2131307742);
        if (j != 2) {
          break label391;
        }
        i = 2131234831;
        label179:
        ((ImageView)localObject1).setImageResource(i);
        if (j != 2) {
          break label398;
        }
      }
    }
    label391:
    label398:
    for (int i = 2131234830;; i = 2131234829)
    {
      for (;;)
      {
        localImageView.setImageResource(i);
        View.OnClickListener local7 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(28455);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            if (!ShakeReportUI.u(ShakeReportUI.this))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(28455);
              return;
            }
            ShakeReportUI.b(ShakeReportUI.this, false);
            ShakeReportUI.c(ShakeReportUI.this, true);
            ShakeReportUI.d(ShakeReportUI.this, false);
            paramAnonymousView = ShakeReportUI.this.getContext();
            localObject = ShakeReportUI.this.getString(2131765763);
            h.d local1 = new h.d()
            {
              public final void oj(int paramAnonymous2Int)
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
                  com.tencent.mm.pluginsdk.ui.tools.s.c(ShakeReportUI.this, 1, null);
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
            com.tencent.mm.ui.base.h.c(paramAnonymousView, null, new String[] { localObject }, "", local1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(28455);
          }
        };
        ((ImageView)localObject1).setOnClickListener(local7);
        localImageView.setOnClickListener(local7);
        if (this.Dkn == null) {
          this.Dkn = findViewById(2131307739);
        }
        this.Dkn.setOnClickListener(local7);
        if (this.Dko == null) {
          this.Dko = findViewById(2131307740);
        }
        this.Dko.setOnClickListener(local7);
        AppMethodBeat.o(28493);
        return;
        try
        {
          localObject1 = new BitmapDrawable(BackwardSupportUtil.BitmapFactory.decodeStream(getContext().getAssets().open("resource/shakehideimg_man.jpg")));
          localImageView.setImageDrawable((Drawable)localObject1);
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.w("MicroMsg.ShakeReportUI", "Bg decode exp:" + localIOException.getLocalizedMessage());
            Object localObject2 = null;
          }
        }
      }
      bg.aVF();
      this.Dkz = u.Sq((String)com.tencent.mm.model.c.azQ().get(4111, null));
      localImageView.setImageDrawable(new BitmapDrawable(this.Dkz));
      break;
      i = 2131234832;
      break label179;
    }
  }
  
  private void eUX()
  {
    AppMethodBeat.i(28494);
    this.Dka = true;
    if ((this.DkW != null) && (this.DkW.isShowing()) && (!this.DkW.Did)) {
      this.Dka = false;
    }
    Log.i("MicroMsg.ShakeReportUI", "tryStartShake");
    if ((this.shakeSensor != null) && (!this.shakeSensor.gok()))
    {
      this.shakeSensor.a(new a(this));
      if ((this.shakeSensor.gom()) && (this.Dki != null))
      {
        this.Dki.setText(getString(2131765722));
        AppMethodBeat.o(28494);
        return;
      }
      this.Dki.setText(getString(2131765784));
    }
    AppMethodBeat.o(28494);
  }
  
  private void eUY()
  {
    AppMethodBeat.i(28496);
    if ((this.DkK == 3) && (com.tencent.mm.ay.e.bek()))
    {
      this.DkK = 3;
      this.Dkk.setText(2131765800);
      this.DkB.setBackgroundResource(2131234815);
      this.DkD.setBackgroundResource(2131234821);
      this.DkE.setBackgroundResource(2131234820);
      this.DkF.setBackgroundResource(2131234824);
      this.DkG.setBackgroundResource(2131234811);
      findViewById(2131307758).setVisibility(0);
      setMMTitle(2131765796);
      com.tencent.mm.plugin.report.service.h.CyF.a(11720, new Object[] { Integer.valueOf(2) });
      com.tencent.mm.plugin.report.service.h.CyF.n(834L, 2L, 1L);
    }
    for (;;)
    {
      l.b localb = this.Dke.a(this, this.DkK, this);
      if (!this.DjY) {
        uC(false);
      }
      if ((com.tencent.mm.plugin.shake.c.c.a.eUL()) && ((localb instanceof com.tencent.mm.plugin.shake.c.a.g)))
      {
        ((com.tencent.mm.plugin.shake.c.a.g)localb).setFromScene(this.DkV);
        if (this.DkV == 3)
        {
          Log.i("MicroMsg.ShakeReportUI", "open shake card from specialview");
          ((com.tencent.mm.plugin.shake.c.a.g)localb).Rv(getIntent().getStringExtra("key_shake_card_ext_info"));
        }
      }
      AppMethodBeat.o(28496);
      return;
      if ((this.DkK == 4) && (k.eUk()))
      {
        this.DkK = 4;
        this.Dkk.setText(2131765801);
        this.DkB.setBackgroundResource(2131234815);
        this.DkD.setBackgroundResource(2131234821);
        this.DkE.setBackgroundResource(2131234818);
        this.DkF.setBackgroundResource(2131234826);
        this.DkG.setBackgroundResource(2131234811);
        findViewById(2131307758).setVisibility(0);
        setMMTitle(2131765797);
        com.tencent.mm.plugin.report.service.h.CyF.a(11720, new Object[] { Integer.valueOf(3) });
        com.tencent.mm.plugin.report.service.h.CyF.n(834L, 3L, 1L);
      }
      else if ((this.DkK == 5) && (eVg()))
      {
        this.DkK = 5;
        this.Dkk.setText(2131765799);
        this.DkB.setBackgroundResource(2131234817);
        this.DkD.setBackgroundResource(2131234821);
        this.DkE.setBackgroundResource(2131234818);
        this.DkF.setBackgroundResource(2131234824);
        this.DkG.setBackgroundResource(2131234811);
        findViewById(2131307758).setVisibility(0);
        setMMTitle(2131765795);
        com.tencent.mm.plugin.report.service.h.CyF.a(11720, new Object[] { Integer.valueOf(4) });
        com.tencent.mm.plugin.report.service.h.CyF.n(834L, 4L, 1L);
      }
      else if ((this.DkK == 6) && (com.tencent.mm.plugin.shake.c.c.a.eUL()))
      {
        this.DkK = 6;
        this.Dkk.setText(2131765798);
        this.DkB.setBackgroundResource(2131234815);
        this.DkD.setBackgroundResource(2131234821);
        this.DkE.setBackgroundResource(2131234818);
        this.DkF.setBackgroundResource(2131234824);
        this.DkG.setBackgroundResource(2131234812);
        findViewById(2131307758).setVisibility(0);
        setMMTitle(2131765794);
        eVb();
        eVe();
        com.tencent.mm.plugin.report.service.h.CyF.a(11720, new Object[] { Integer.valueOf(5) });
        com.tencent.mm.plugin.report.service.h.CyF.n(834L, 5L, 1L);
      }
      else
      {
        this.DkK = 1;
        this.Dkk.setText(2131765742);
        this.DkB.setBackgroundResource(2131234815);
        this.DkD.setBackgroundResource(2131234823);
        this.DkE.setBackgroundResource(2131234818);
        this.DkF.setBackgroundResource(2131234824);
        this.DkG.setBackgroundResource(2131234811);
        if (com.tencent.mm.ay.e.bek()) {
          findViewById(2131307758).setVisibility(0);
        }
        setMMTitle(2131765793);
        com.tencent.mm.plugin.report.service.h.CyF.a(11720, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.h.CyF.n(834L, 1L, 1L);
      }
    }
  }
  
  private void eUZ()
  {
    AppMethodBeat.i(28497);
    bg.aVF();
    this.DjX = Util.nullAsTrue((Boolean)com.tencent.mm.model.c.azQ().get(4112, null));
    if (this.DjX)
    {
      setTitleMuteIconVisibility(8);
      AppMethodBeat.o(28497);
      return;
    }
    setTitleMuteIconVisibility(0);
    AppMethodBeat.o(28497);
  }
  
  private void eVa()
  {
    AppMethodBeat.i(28517);
    if (com.tencent.mm.plugin.shake.c.c.a.eUL())
    {
      if (com.tencent.mm.y.c.axV().cP(262155, 266259))
      {
        this.DkI.setVisibility(0);
        AppMethodBeat.o(28517);
        return;
      }
      this.DkI.setVisibility(8);
    }
    AppMethodBeat.o(28517);
  }
  
  private void eVb()
  {
    AppMethodBeat.i(28518);
    if ((this.DkK == 6) && (com.tencent.mm.plugin.shake.c.c.a.eUL()))
    {
      boolean bool1 = com.tencent.mm.y.c.axV().cP(262154, 266258);
      boolean bool2 = com.tencent.mm.y.c.axV().cP(262155, 266259);
      if (bool1)
      {
        cb(com.tencent.mm.plugin.shake.c.c.a.eUG(), true);
        AppMethodBeat.o(28518);
        return;
      }
      if (bool2)
      {
        cb(com.tencent.mm.plugin.shake.c.c.a.eUI(), true);
        AppMethodBeat.o(28518);
        return;
      }
      if (!this.DkX)
      {
        if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.eUE()))
        {
          cb(com.tencent.mm.plugin.shake.c.c.a.eUE(), true);
          AppMethodBeat.o(28518);
          return;
        }
        cb(getString(2131765739), true);
      }
    }
    AppMethodBeat.o(28518);
  }
  
  private void eVc()
  {
    AppMethodBeat.i(28520);
    if ((this.DkW != null) && (this.DkW.isShowing())) {
      this.DkW.dismiss();
    }
    this.DkW = null;
    AppMethodBeat.o(28520);
  }
  
  private void eVd()
  {
    int m = 1;
    AppMethodBeat.i(28521);
    boolean bool1 = com.tencent.mm.plugin.shake.c.c.a.eUh();
    boolean bool2 = com.tencent.mm.y.c.axV().cP(262154, 266258);
    boolean bool3 = com.tencent.mm.y.c.axV().cP(262155, 266259);
    if (getIntent().getBooleanExtra("shake_card", false)) {}
    for (int i = getIntent().getIntExtra("shake_card", 0);; i = 0)
    {
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
      int j;
      if (bool2)
      {
        j = 1;
        if (!bool1) {
          break label231;
        }
        k = 1;
        label87:
        localh.a(11668, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), com.tencent.mm.plugin.shake.c.c.a.eUH(), Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.eUD()) });
        localh = com.tencent.mm.plugin.report.service.h.CyF;
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
        localh.a(11668, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), com.tencent.mm.plugin.shake.c.c.a.eUH(), Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.eUD()) });
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
  
  private void eVe()
  {
    AppMethodBeat.i(28522);
    if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.eUF())) {
      this.DkJ.setText(com.tencent.mm.plugin.shake.c.c.a.eUF());
    }
    AppMethodBeat.o(28522);
  }
  
  private void eVf()
  {
    AppMethodBeat.i(28523);
    label123:
    Object localObject;
    label167:
    int i;
    if (com.tencent.mm.ay.e.bek())
    {
      Log.i("MicroMsg.ShakeReportUI", "is not oversea user, show shake music");
      this.DkY.put(Integer.valueOf(3), Boolean.TRUE);
      findViewById(2131307773).setVisibility(0);
      if (com.tencent.mm.ay.e.bel())
      {
        bg.aVF();
        if (com.tencent.mm.model.c.azQ().getInt(4118, 0) == 0) {
          this.DkH.setVisibility(0);
        }
      }
      else
      {
        if (!k.eUk()) {
          break label268;
        }
        this.DkY.put(Integer.valueOf(4), Boolean.TRUE);
        findViewById(2131307776).setVisibility(0);
        Log.i("MicroMsg.ShakeReportUI", "show shake tv tab");
        if (!com.tencent.mm.plugin.shake.c.c.a.eUL()) {
          break label309;
        }
        this.DkY.put(Integer.valueOf(6), Boolean.TRUE);
        findViewById(2131307763).setVisibility(0);
        Log.i("MicroMsg.ShakeReportUI", "show shake card tab");
        localObject = this.DkY.values().iterator();
        i = 0;
        label184:
        if (!((Iterator)localObject).hasNext()) {
          break label351;
        }
        if (!((Boolean)((Iterator)localObject).next()).booleanValue()) {
          break label479;
        }
        i += 1;
      }
    }
    label268:
    label309:
    label479:
    for (;;)
    {
      break label184;
      this.DkH.setVisibility(8);
      break;
      this.DkY.put(Integer.valueOf(3), Boolean.FALSE);
      findViewById(2131307773).setVisibility(8);
      Log.i("MicroMsg.ShakeReportUI", "is oversea user, hide shake music");
      break;
      this.DkY.put(Integer.valueOf(4), Boolean.FALSE);
      findViewById(2131307776).setVisibility(8);
      Log.i("MicroMsg.ShakeReportUI", "hide shake tv tab");
      break label123;
      findViewById(2131307763).setVisibility(8);
      this.DkY.put(Integer.valueOf(6), Boolean.FALSE);
      Log.i("MicroMsg.ShakeReportUI", "hide shake card tab");
      break label167;
      label351:
      this.DkL = i;
      localObject = (LinearLayout)findViewById(2131307758);
      if (i == 1) {
        ((LinearLayout)localObject).setVisibility(8);
      }
      while ((i > 4) && (this.Dlf))
      {
        findViewById(2131307776).setVisibility(8);
        Log.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() > 0.");
        this.DkL -= 1;
        AppMethodBeat.o(28523);
        return;
        ((LinearLayout)localObject).setVisibility(0);
      }
      if ((i > 4) && (!this.Dlf))
      {
        this.DkZ = false;
        this.DkL -= 1;
        Log.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() <= 0.");
      }
      AppMethodBeat.o(28523);
      return;
    }
  }
  
  private boolean eVg()
  {
    AppMethodBeat.i(28524);
    Log.i("MicroMsg.ShakeReportUI", "[shakezb] isChineseAppLang :" + LocaleUtil.isChineseAppLang() + " ,getApplicationLanguage[en or zh_CN or zh_HK or zh_TW is avaliable] :" + LocaleUtil.getApplicationLanguage());
    if ((this.DkZ) && (eVh()))
    {
      AppMethodBeat.o(28524);
      return true;
    }
    AppMethodBeat.o(28524);
    return false;
  }
  
  private static boolean eVh()
  {
    AppMethodBeat.i(28525);
    if ((LocaleUtil.isChineseAppLang()) || (LocaleUtil.getApplicationLanguage().equals("en")) || (LocaleUtil.getApplicationLanguage().equals("ja")))
    {
      AppMethodBeat.o(28525);
      return true;
    }
    AppMethodBeat.o(28525);
    return false;
  }
  
  private void eVi()
  {
    AppMethodBeat.i(28526);
    this.DkM.setVisibility(8);
    AppMethodBeat.o(28526);
  }
  
  private void eW(View paramView)
  {
    AppMethodBeat.i(28509);
    if (paramView == null)
    {
      AppMethodBeat.o(28509);
      return;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, "", "");
    Log.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this });
    if (!bool)
    {
      AppMethodBeat.o(28509);
      return;
    }
    cb("", false);
    if (paramView.getId() == 2131307767)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(11722, new Object[] { Integer.valueOf(1) });
      if (this.DkK != 1)
      {
        if (this.DkK == 4) {
          ux(false);
        }
        this.DkK = 1;
        eUY();
        uz(false);
        if (this.Dkg != null) {
          this.Dkg.setVisibility(8);
        }
      }
    }
    do
    {
      for (;;)
      {
        uy(true);
        uC(false);
        eVi();
        AppMethodBeat.o(28509);
        return;
        if (paramView.getId() == 2131307773)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(11722, new Object[] { Integer.valueOf(2) });
          if ((!this.gmw) && (this.gmt != null)) {
            this.gmt.a(this.gmA, true);
          }
          if ((!com.tencent.mm.q.a.cC(this)) && (!com.tencent.mm.q.a.cA(this)) && (!com.tencent.mm.q.a.cE(this)) && (this.DkK != 3))
          {
            if (this.DkK == 4) {
              ux(false);
            }
            this.DkK = 3;
            eUY();
            uz(false);
            if (this.Dkg != null) {
              this.Dkg.setVisibility(8);
            }
          }
          eUV();
        }
        else
        {
          if (paramView.getId() != 2131307776) {
            break;
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(11722, new Object[] { Integer.valueOf(3) });
          if ((!this.gmw) && (this.gmt != null)) {
            this.gmt.a(this.gmA, true);
          }
          if ((!com.tencent.mm.q.a.cC(this)) && (!com.tencent.mm.q.a.cA(this)) && (!com.tencent.mm.q.a.cE(this)) && (this.DkK != 4))
          {
            ux(true);
            this.DkK = 4;
            eUY();
            uz(false);
            if (this.Dkg != null) {
              this.Dkg.setVisibility(8);
            }
          }
        }
      }
      if ((paramView.getId() != 2131307771) && (paramView.getId() != 2131307768)) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(11722, new Object[] { Integer.valueOf(4) });
    } while (this.DkK == 5);
    this.DkK = 5;
    eUY();
    uz(false);
    if (this.Dkg != null) {
      this.Dkg.setVisibility(8);
    }
    if ((!Build.VERSION.RELEASE.equals("6.0")) && (!Build.VERSION.RELEASE.equals("6.0.0")) && (Build.VERSION.SDK_INT >= 23))
    {
      paramView = (LocationManager)MMApplicationContext.getContext().getSystemService("location");
      if (paramView == null) {
        break label743;
      }
    }
    label743:
    for (bool = paramView.isProviderEnabled("gps");; bool = true)
    {
      if (!bool) {
        aNt(getString(2131765753));
      }
      paramView = BluetoothAdapter.getDefaultAdapter();
      if ((paramView != null) && (paramView.getState() != 12))
      {
        aNt(getString(2131765752));
        break;
      }
      if (paramView != null) {
        break;
      }
      aNt(getString(2131765756));
      break;
      if (paramView.getId() != 2131307763) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(11722, new Object[] { Integer.valueOf(5) });
      if (this.DkK == 6) {
        break;
      }
      if (this.DkK == 4) {
        ux(false);
      }
      this.DkK = 6;
      eUY();
      uz(false);
      if (this.Dkg != null) {
        this.Dkg.setVisibility(8);
      }
      com.tencent.mm.y.c.axV().B(262155, false);
      this.DkI.setVisibility(8);
      break;
    }
  }
  
  private void uA(boolean paramBoolean)
  {
    AppMethodBeat.i(28500);
    if (this.Dku == null) {
      this.Dku = findViewById(2131302158);
    }
    if (!paramBoolean)
    {
      this.Dku.setVisibility(8);
      AppMethodBeat.o(28500);
      return;
    }
    int i = com.tencent.mm.plugin.shake.b.m.eUn().ctM();
    if (i <= 0)
    {
      this.Dku.setVisibility(8);
      AppMethodBeat.o(28500);
      return;
    }
    if (this.Dkw == null) {
      this.Dkw = ((TextView)this.Dku.findViewById(2131307749));
    }
    this.Dkw.setText(getString(2131765777, new Object[] { Integer.valueOf(i) }));
    this.Dku.setOnClickListener(new ShakeReportUI.9(this));
    if (this.Dkv == null) {
      this.Dkv = ((MMImageView)findViewById(2131307755));
    }
    Object localObject = com.tencent.mm.plugin.shake.b.m.eUn().eUd();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.shake.b.f)localObject).field_thumburl;
      if (Util.isNullOrNil((String)localObject)) {
        break label255;
      }
      localObject = new com.tencent.mm.plugin.shake.e.b((String)localObject);
      Bitmap localBitmap = u.a((com.tencent.mm.platformtools.s)localObject);
      this.Dkv.setTag(((com.tencent.mm.plugin.shake.e.b)localObject).blC());
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        break label242;
      }
      this.Dkv.setImageBitmap(localBitmap);
    }
    for (;;)
    {
      this.Dku.setVisibility(0);
      AppMethodBeat.o(28500);
      return;
      label242:
      this.Dkv.setImageResource(2131689587);
      continue;
      label255:
      this.Dkv.setImageResource(2131689587);
    }
  }
  
  private void uB(boolean paramBoolean)
  {
    AppMethodBeat.i(28501);
    if (this.Dkj != null)
    {
      if (paramBoolean)
      {
        this.Dkj.setVisibility(0);
        AppMethodBeat.o(28501);
        return;
      }
      this.Dkj.setVisibility(8);
      this.Dkj.cancelLongPress();
    }
    AppMethodBeat.o(28501);
  }
  
  private void uC(boolean paramBoolean)
  {
    AppMethodBeat.i(28502);
    if (this.Dkh != null)
    {
      if (paramBoolean)
      {
        this.Dkh.setVisibility(0);
        AppMethodBeat.o(28502);
        return;
      }
      this.Dkh.setVisibility(4);
    }
    AppMethodBeat.o(28502);
  }
  
  private void ux(boolean paramBoolean)
  {
    AppMethodBeat.i(28495);
    String str = String.format("%1$s-shaketype-%2$d", new Object[] { getClass().getName(), Integer.valueOf(4) });
    Log.d("MicroMsg.ShakeReportUI", "activate change report , class name=" + str + ", isActive=" + paramBoolean);
    aa.d(paramBoolean, new Intent().putExtra("classname", str));
    AppMethodBeat.o(28495);
  }
  
  private void uy(boolean paramBoolean)
  {
    AppMethodBeat.i(28498);
    uz(paramBoolean);
    uA(paramBoolean);
    AppMethodBeat.o(28498);
  }
  
  private void uz(boolean paramBoolean)
  {
    AppMethodBeat.i(28499);
    if (this.Dkt == null) {
      this.Dkt = findViewById(2131302157);
    }
    if ((this.Dke.DgV == 3) || (this.Dke.DgV == 4) || (this.Dke.DgV == 5) || (this.Dke.DgV == 6) || (!paramBoolean))
    {
      this.Dkt.setVisibility(8);
      AppMethodBeat.o(28499);
      return;
    }
    int i = com.tencent.mm.bj.d.bgP().ctM();
    if (i <= 0)
    {
      this.Dkt.setVisibility(8);
      AppMethodBeat.o(28499);
      return;
    }
    this.Dkt.setVisibility(0);
    ((TextView)this.Dkt.findViewById(2131307220)).setText(getResources().getQuantityString(2131623965, i, new Object[] { Integer.valueOf(i) }));
    this.Dkt.setOnClickListener(new ShakeReportUI.8(this));
    if (this.Dkx == null) {
      this.Dkx = ((ImageView)findViewById(2131304534));
    }
    cl localcl = com.tencent.mm.bj.d.bgP().gEx();
    if (localcl != null)
    {
      this.Dky = localcl.field_sayhiuser;
      com.tencent.mm.pluginsdk.ui.a.b.c(this.Dkx, this.Dky);
    }
    AppMethodBeat.o(28499);
  }
  
  public final void a(int paramInt, final com.tencent.mm.plugin.shake.c.a.e parame, long paramLong)
  {
    AppMethodBeat.i(28507);
    this.DkX = true;
    if (paramInt == 1251)
    {
      if (parame == null)
      {
        AppMethodBeat.o(28507);
        return;
      }
      Log.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_GetLbsCard");
      com.tencent.mm.plugin.shake.c.c.a.eUg();
      eVf();
      eVa();
      eVd();
      this.DkV = 4;
      com.tencent.mm.plugin.shake.b.m.eUs().putValue("key_shake_card_item", parame);
      AppMethodBeat.o(28507);
      return;
    }
    Object localObject;
    if (paramInt == 1250)
    {
      if (parame == null)
      {
        this.DkC = null;
        aNt(null);
        AppMethodBeat.o(28507);
        return;
      }
      if (((parame == null) || (this.DjY)) && (!this.DjY))
      {
        this.DkC = null;
        aNt(null);
        AppMethodBeat.o(28507);
        return;
      }
      this.DjY = false;
      Log.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_ShakeCard");
      if (this.Dke.DgV == 6)
      {
        localObject = this.Dke.DgW;
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
      Log.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_OK");
      if (((com.tencent.mm.plugin.shake.c.a.g)localObject).pTI == 3)
      {
        Log.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is  MMBIZ_SHAKE_CARD_ACTION_TYPE_NO_CARD");
        if ((parame != null) && (!TextUtils.isEmpty(parame.Dhy)))
        {
          aNt(parame.Dhy);
          AppMethodBeat.o(28507);
          return;
        }
        aNt(getString(2131765738));
        AppMethodBeat.o(28507);
        return;
      }
      Log.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is " + ((com.tencent.mm.plugin.shake.c.a.g)localObject).pTI);
      XD(3);
      if (parame.pTI == 1) {
        this.Dka = false;
      }
      if ((this.DkW != null) && (this.DkW.isShowing()))
      {
        AppMethodBeat.o(28507);
        return;
      }
      if (parame.DhA)
      {
        localObject = (ViewStub)findViewById(2131309875);
        if (localObject != null) {
          ((ViewStub)localObject).inflate();
        }
        ((ShakeEggAnimFrame)findViewById(2131298317)).aE(this);
        new MMHandler().postDelayed(new Runnable()
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
      Log.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_ERR_REPORT");
      aNt(getString(2131765738));
    }
  }
  
  public final void aVw()
  {
    AppMethodBeat.i(28504);
    eUY();
    AppMethodBeat.o(28504);
  }
  
  public final void eUv()
  {
    AppMethodBeat.i(28516);
    com.tencent.mm.plugin.shake.c.c.a.eUg();
    eVa();
    eVb();
    eVe();
    eVf();
    eVd();
    AppMethodBeat.o(28516);
  }
  
  public final void f(List<com.tencent.mm.plugin.shake.b.d> paramList, long paramLong)
  {
    AppMethodBeat.i(28506);
    eVi();
    if ((paramList == null) || (!this.DjY) || (paramLong == 6L))
    {
      this.DkC = null;
      if (paramLong == 6L)
      {
        aNt(getString(2131765757));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 7L)
      {
        aNt(getString(2131765755));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 8L)
      {
        aNt(getString(2131765753));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 9L)
      {
        aNt(getString(2131765752));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 10L)
      {
        aNt(getString(2131765756));
        AppMethodBeat.o(28506);
        return;
      }
      aNt(null);
      AppMethodBeat.o(28506);
      return;
    }
    this.DjY = false;
    if (paramList.size() > 0) {
      this.DkC = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0));
    }
    int i;
    Object localObject1;
    if (this.Dke.DgV == 1)
    {
      if ((paramList.size() > 0) && (((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_type != 0))
      {
        aNt(null);
        AppMethodBeat.o(28506);
        return;
      }
      this.Dkc = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).scene;
      i = paramList.size();
      if (i == 0)
      {
        aNt(null);
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        localObject1 = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_username;
        Object localObject2 = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_nickname;
        Log.i("MicroMsg.ShakeReportUI", "1 u:" + (String)localObject1 + " n:" + (String)localObject2 + " d:" + ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_distance);
        if (this.DjX) {
          PlaySound.play(getContext(), 2131765775);
        }
        XD(3);
        localObject1 = (com.tencent.mm.plugin.shake.b.d)paramList.get(0);
        Object localObject3;
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_username))
        {
          this.Dkg.setTag(((com.tencent.mm.plugin.shake.b.d)localObject1).field_username);
          this.Dkg.setVisibility(0);
          bg.aVF();
          localObject2 = com.tencent.mm.model.c.aSN().Kn(((com.tencent.mm.plugin.shake.b.d)localObject1).field_username);
          localObject3 = new StringBuilder().append(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
          if (!com.tencent.mm.contact.c.oR(((ax)localObject2).field_type)) {
            break label922;
          }
          paramList = getString(2131765776);
          localObject3 = paramList;
          if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex != 1) {
            break label928;
          }
          this.Dkg.setContentDescription((String)localObject3 + ((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance + getContext().getString(2131765805));
          label570:
          TextView localTextView = (TextView)this.Dkg.findViewById(2131307746);
          AppCompatActivity localAppCompatActivity = getContext();
          StringBuilder localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
          if (!com.tencent.mm.contact.c.oR(((ax)localObject2).field_type)) {
            break label1016;
          }
          paramList = getString(2131765776);
          label627:
          localTextView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(localAppCompatActivity, paramList, localTextView.getTextSize()));
          if (this.gyr != null)
          {
            if (Util.isNullOrNil((String)localObject3)) {
              break label1022;
            }
            this.gyr.setContentDescription(String.format(getString(2131765731), new Object[] { localObject3 }));
          }
          label692:
          ((TextView)this.Dkg.findViewById(2131307744)).setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance);
          com.tencent.mm.pluginsdk.ui.a.b.c((ImageView)this.Dkg.findViewById(2131307745), ((com.tencent.mm.plugin.shake.b.d)localObject1).field_username);
          paramList = (ImageView)this.Dkg.findViewById(2131307748);
          if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1 == 0) {
            break label1039;
          }
          paramList.setVisibility(0);
          paramList.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile(ay.a.iDs.rV(((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1), 2.0F));
          label782:
          if ((((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1 != 0) || (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex == 0)) {
            break label1056;
          }
          if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex != 1) {
            break label1048;
          }
          i = 2131690428;
          label812:
          paramList = com.tencent.mm.cb.a.l(this, i);
          this.Dkg.findViewById(2131307747).setVisibility(0);
          ((ImageView)this.Dkg.findViewById(2131307747)).setImageDrawable(paramList);
        }
        for (;;)
        {
          if (((com.tencent.mm.plugin.shake.b.d)localObject1).getProvince() == null)
          {
            Log.e("MicroMsg.ShakeReportUI", "PROVINCE NULL");
            ((com.tencent.mm.plugin.shake.b.d)localObject1).field_province = "";
          }
          if (((com.tencent.mm.plugin.shake.b.d)localObject1).getCity() == null)
          {
            Log.e("MicroMsg.ShakeReportUI", "CITY NULL");
            ((com.tencent.mm.plugin.shake.b.d)localObject1).field_city = "";
          }
          this.Dkg.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772153));
          AppMethodBeat.o(28506);
          return;
          label922:
          paramList = "";
          break;
          label928:
          if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex == 2)
          {
            this.Dkg.setContentDescription((String)localObject3 + ((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance + getContext().getString(2131765804));
            break label570;
          }
          this.Dkg.setContentDescription((String)localObject3 + ((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance);
          break label570;
          label1016:
          paramList = "";
          break label627;
          label1022:
          this.gyr.setContentDescription(getString(2131765732));
          break label692;
          label1039:
          paramList.setVisibility(8);
          break label782;
          label1048:
          i = 2131690427;
          break label812;
          label1056:
          this.Dkg.findViewById(2131307747).setVisibility(8);
        }
      }
      if (this.DjX) {
        PlaySound.play(getContext(), 2131765775);
      }
      XD(3);
      uz(false);
      paramList = new Intent(this, ShakeItemListUI.class);
      paramList.putExtra("_key_show_type_", -1);
      paramList.putExtra("_key_title_", getString(2131765770));
      paramList = new com.tencent.mm.hellhoundlib.b.a().bl(paramList);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramList.axQ(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramList.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(28506);
      return;
    }
    if (this.Dke.DgV == 3)
    {
      i = paramList.size();
      if (i == 0)
      {
        aNt(getString(2131765782));
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        if (this.DjX) {
          PlaySound.play(getContext(), 2131765775);
        }
        XD(3);
        if (((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_type == 4)
        {
          paramList = com.tencent.mm.plugin.shake.d.a.i.e(((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_lvbuffer, paramLong);
          com.tencent.mm.ay.a.d(paramList);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_mode", 1);
          ((Intent)localObject1).putExtra("key_offset", paramList.jeW);
          ((Intent)localObject1).putExtra("music_player_beg_time", paramList.jfo);
          ((Intent)localObject1).putExtra("key_scene", 3);
          if (com.tencent.mm.ay.e.bel()) {
            ((Intent)localObject1).putExtra("KGlobalShakeMusic", true);
          }
          com.tencent.mm.br.c.b(this, "music", ".ui.MusicMainUI", (Intent)localObject1);
          AppMethodBeat.o(28506);
          return;
        }
        Log.w("MicroMsg.ShakeReportUI", "Unexpected type, ignore.");
      }
      AppMethodBeat.o(28506);
      return;
    }
    if (this.Dke.DgV == 4)
    {
      eVi();
      i = paramList.size();
      if (i == 0)
      {
        aNt(getString(2131765826));
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        if (this.DjX) {
          PlaySound.play(getContext(), 2131765775);
        }
        XD(3);
        paramList = (com.tencent.mm.plugin.shake.b.d)paramList.get(0);
        new MMHandler().postDelayed(new k.1(paramList, this), 100L);
      }
      AppMethodBeat.o(28506);
      return;
    }
    if (this.Dke.DgV == 5) {
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
          if (this.DjX) {
            PlaySound.play(getContext(), 2131765775);
          }
          XD(3);
          paramList = (com.tencent.mm.plugin.shake.b.d)paramList.get(0);
          if (!Util.isNullOrNil(paramList.field_username))
          {
            this.Dkg.setTag(paramList.field_username);
            ((TextView)this.Dkg.findViewById(2131307746)).setText(paramList.field_username);
            this.Dkg.setContentDescription(Util.nullAsNil(paramList.field_nickname));
            ((TextView)this.Dkg.findViewById(2131307744)).setText(paramList.field_signature);
            this.jaq.loadImage(paramList.getProvince(), (ImageView)this.Dkg.findViewById(2131307745));
            this.Dkg.findViewById(2131307747).setVisibility(8);
            this.Dkg.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772153));
            this.Dkg.setVisibility(0);
          }
          AppMethodBeat.o(28506);
          return;
        }
        if (this.DjX) {
          PlaySound.play(getContext(), 2131765775);
        }
        XD(3);
        uz(false);
        localObject1 = new Intent(this, ShakeItemListUI.class);
        ((Intent)localObject1).putExtra("_key_show_type_", -12);
        ((Intent)localObject1).putExtra("_key_title_", getString(2131765768));
        ((Intent)localObject1).putExtra("_key_show_from_shake_", true);
        ((Intent)localObject1).putExtra("_ibeacon_new_insert_size", paramList.size());
        paramList = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramList.axQ(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramList.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(28506);
        return;
      }
      aNt(null);
      AppMethodBeat.o(28506);
      return;
      aNt(getString(2131765757));
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496288;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28491);
    com.tencent.mm.plugin.shake.c.c.a.eUg();
    this.DkY.put(Integer.valueOf(1), Boolean.TRUE);
    this.DkY.put(Integer.valueOf(3), Boolean.FALSE);
    this.DkY.put(Integer.valueOf(4), Boolean.FALSE);
    this.DkY.put(Integer.valueOf(5), Boolean.FALSE);
    this.DkY.put(Integer.valueOf(6), Boolean.FALSE);
    this.jaq = new com.tencent.mm.av.a.a(this);
    this.Dki = ((TextView)findViewById(2131307761));
    this.Dkh = findViewById(2131307777);
    this.Dkj = ((TextView)findViewById(2131307756));
    this.Dkk = ((TextView)findViewById(2131307760));
    this.DkM = findViewById(2131307791);
    this.DkN = ((ImageView)findViewById(2131307779));
    this.DkO = ((ImageView)findViewById(2131307781));
    this.DkP = ((ImageView)findViewById(2131307783));
    this.DkQ = ((ImageView)findViewById(2131307785));
    this.DkR = findViewById(2131307780);
    this.DkS = findViewById(2131307782);
    this.DkT = findViewById(2131307784);
    this.DkU = findViewById(2131307786);
    this.Dkg = findViewById(2131307759);
    this.Dkg.setOnClickListener(this.Dli);
    this.gyr = ((ImageView)this.Dkg.findViewById(2131307745));
    this.gyr.setOnClickListener(new ShakeReportUI.26(this));
    eUW();
    Object localObject = View.inflate(getContext(), 2131496284, null);
    this.DkA = new com.tencent.mm.ui.base.i(getContext(), 2131821772);
    this.DkA.setContentView((View)localObject);
    this.DkA.setOnCancelListener(new ShakeReportUI.4(this));
    ((Button)((View)localObject).findViewById(2131307735)).setOnClickListener(new ShakeReportUI.5(this));
    bg.aVF();
    boolean bool1 = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.azQ().get(4108, null));
    bg.aVF();
    boolean bool2 = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.azQ().get(4117, null));
    if (!bool1)
    {
      ((View)localObject).setVisibility(0);
      this.DkA.show();
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(4108, Boolean.TRUE);
      setBackBtn(new ShakeReportUI.27(this));
      addIconOptionMenu(0, 2131755153, 2131689513, new ShakeReportUI.28(this));
      localObject = new ShakeReportUI.29(this);
      if ((!this.Dlc) && (!this.Dla)) {
        break label742;
      }
    }
    label742:
    for (this.DkB = ((ImageView)findViewById(2131307770));; this.DkB = ((ImageView)findViewById(2131307769)))
    {
      this.DkD = ((ImageView)findViewById(2131307766));
      this.DkE = ((ImageView)findViewById(2131307772));
      this.DkF = ((ImageView)findViewById(2131307775));
      this.DkG = ((ImageView)findViewById(2131307762));
      this.DkJ = ((TextView)findViewById(2131307765));
      this.DkI = ((ImageView)findViewById(2131307764));
      this.DkH = ((ImageView)findViewById(2131307774));
      eVe();
      findViewById(2131307771).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131307767).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131307773).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131307776).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131307763).setOnClickListener((View.OnClickListener)localObject);
      eVa();
      eVd();
      eVi();
      AppMethodBeat.o(28491);
      return;
      if (bool2) {
        break;
      }
      Looper.myQueue().addIdleHandler(new ShakeReportUI.6(this));
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
    if ((this.Dkv != null) && (this.Dkv.getTag() != null) && (paramString.equals((String)this.Dkv.getTag()))) {
      this.Dkv.setImageBitmap(paramBitmap);
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
      bg.aVF();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.model.c.aSY() + "custom_shake_img_filename.jpg");
      com.tencent.mm.plugin.shake.a.jRt.a(localIntent, 2, this, paramIntent);
      AppMethodBeat.o(28510);
      return;
    case 2: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(28510);
        return;
      }
      paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(4110, Boolean.FALSE);
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(4111, paramIntent);
      eUW();
      AppMethodBeat.o(28510);
      return;
    }
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
      {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oho, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_FINE_LOCATION", 64);
        this.kgv = false;
        AppMethodBeat.o(28510);
        return;
      }
      this.kgv = true;
      finish();
      AppMethodBeat.o(28510);
      return;
    }
    this.kgv = true;
    finish();
    AppMethodBeat.o(28510);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28484);
    super.onCreate(paramBundle);
    setMMTitle(2131765793);
    setActionbarColor(getResources().getColor(2131099743));
    setNavigationbarColor(getResources().getColor(2131099743));
    hideActionbarLine();
    this.gmt = com.tencent.mm.modelgeo.d.bca();
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NTL, "");
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NTM, "");
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NWs, "");
    paramBundle = com.tencent.mm.plugin.shake.b.m.eUr();
    if (paramBundle.pQG == null) {
      paramBundle.pQG = new ArrayList();
    }
    paramBundle.pQG.add(new WeakReference(this));
    initView();
    this.Dkd = new c(getBodyView());
    this.shakeSensor = new com.tencent.mm.pluginsdk.l.d();
    if (!this.shakeSensor.gom()) {
      com.tencent.mm.ui.base.h.a(this, 2131765784, 2131755998, new ShakeReportUI.12(this));
    }
    if (com.tencent.mm.plugin.shake.a.jRu != null) {
      com.tencent.mm.plugin.shake.a.jRu.WZ();
    }
    u.b(this);
    Log.i("MicroMsg.ShakeReportUI", "%s", new Object[] { getResources().getDisplayMetrics().toString() });
    int i = com.tencent.mm.plugin.shake.b.m.eUn().ctM();
    com.tencent.mm.plugin.report.service.h.CyF.a(11317, new Object[] { Integer.valueOf(i), e.eVk() });
    com.tencent.mm.plugin.report.service.h.CyF.a(11710, new Object[] { Integer.valueOf(1) });
    com.tencent.mm.plugin.report.service.h.CyF.n(834L, 0L, 1L);
    AppMethodBeat.o(28484);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28488);
    if ((this.Dkz != null) && (!this.Dkz.isRecycled())) {
      this.Dkz.recycle();
    }
    if ((this.DkA != null) && (this.DkA.isShowing()))
    {
      this.DkA.dismiss();
      this.DkA = null;
    }
    if (this.Dke.DgW != null) {
      this.Dke.DgW.eTQ();
    }
    if (this.shakeSensor != null)
    {
      this.shakeSensor.cBo();
      this.shakeSensor = null;
    }
    Object localObject = j.a(null);
    if (j.iCs)
    {
      j.iCs = false;
      if (!((j)localObject).DiX.eUN()) {
        Log.e("Micromsg.ShakeMusicMgr", "release MusicFingerPrintRecorder error");
      }
    }
    j.DiY = null;
    u.c(this);
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NWh, Boolean.FALSE);
    if (com.tencent.mm.plugin.shake.c.c.a.eUL()) {
      com.tencent.mm.y.c.axV().B(262154, false);
    }
    eVc();
    localObject = com.tencent.mm.plugin.shake.b.m.eUr();
    int i;
    if (((com.tencent.mm.plugin.shake.c.a.f)localObject).pQG != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < ((com.tencent.mm.plugin.shake.c.a.f)localObject).pQG.size())
      {
        WeakReference localWeakReference = (WeakReference)((com.tencent.mm.plugin.shake.c.a.f)localObject).pQG.get(i);
        if (localWeakReference != null)
        {
          f.a locala = (f.a)localWeakReference.get();
          if ((locala != null) && (locala.equals(this))) {
            ((com.tencent.mm.plugin.shake.c.a.f)localObject).pQG.remove(localWeakReference);
          }
        }
      }
      else
      {
        localObject = com.tencent.mm.plugin.shake.b.m.eUs();
        ((com.tencent.mm.plugin.shake.c.a.d)localObject).gmu = -85.0F;
        ((com.tencent.mm.plugin.shake.c.a.d)localObject).gmv = -1000.0F;
        if (this.gmt != null) {
          this.gmt.c(this.gmA);
        }
        super.onDestroy();
        AppMethodBeat.o(28488);
        return;
      }
      i += 1;
    }
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(28512);
    onNotifyChange("", null);
    AppMethodBeat.o(28512);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(28511);
    eUZ();
    if (!this.DjZ) {
      uy(true);
    }
    AppMethodBeat.o(28511);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(28487);
    bg.aVF();
    com.tencent.mm.model.c.b(this);
    bg.aVF();
    com.tencent.mm.model.c.azQ().remove(this);
    com.tencent.mm.plugin.shake.b.m.eUm().remove(this);
    if (this.Dke.DgW != null) {
      this.Dke.DgW.pause();
    }
    this.Dka = false;
    if (this.shakeSensor != null) {
      this.shakeSensor.cBo();
    }
    this.Dkd.eUS();
    if (this.DkK != 5)
    {
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(327696, this.DkK);
    }
    if (this.DkK == 4) {
      ux(false);
    }
    super.onPause();
    AppMethodBeat.o(28487);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(28527);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.ShakeReportUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(28527);
      return;
    }
    Log.i("MicroMsg.ShakeReportUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28527);
      return;
      if (paramArrayOfInt[0] != 0)
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131763876), getString(2131763890), getString(2131762043), getString(2131756929), false, new ShakeReportUI.19(this), new ShakeReportUI.20(this));
        AppMethodBeat.o(28527);
        return;
        if (paramArrayOfInt[0] == 0)
        {
          eHs();
          AppMethodBeat.o(28527);
          return;
        }
        this.kgv = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131763874), getString(2131763890), getString(2131762043), getString(2131756929), false, new ShakeReportUI.21(this), new ShakeReportUI.23(this));
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28485);
    super.onResume();
    if (this.kgv) {
      if (com.tencent.mm.aw.b.Pi((String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null)))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.ACCESS_FINE_LOCATION"))
        {
          if (!((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oho, Boolean.FALSE)).booleanValue())
          {
            com.tencent.mm.plugin.account.a.b.a.b(this, getString(2131762481, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
            AppMethodBeat.o(28485);
            return;
          }
          com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_FINE_LOCATION", 64);
          AppMethodBeat.o(28485);
        }
      }
      else
      {
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_FINE_LOCATION", 64, "", "");
        Log.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkposition[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this });
        if (!bool)
        {
          AppMethodBeat.o(28485);
          return;
        }
      }
    }
    eHs();
    AppMethodBeat.o(28485);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends com.tencent.mm.pluginsdk.l.d.a
  {
    WeakReference<ShakeReportUI> Dlq;
    private final long[] VIRBRATOR_PATTERN;
    private long lastShakeTime;
    private Vibrator paT;
    
    public a(ShakeReportUI paramShakeReportUI)
    {
      AppMethodBeat.i(28481);
      this.lastShakeTime = Util.currentTicks();
      this.VIRBRATOR_PATTERN = new long[] { 300L, 200L, 300L, 200L };
      this.Dlq = new WeakReference(paramShakeReportUI);
      AppMethodBeat.o(28481);
    }
    
    public final void onRelease() {}
    
    public final void onShake(boolean paramBoolean)
    {
      AppMethodBeat.i(28482);
      ShakeReportUI localShakeReportUI = (ShakeReportUI)this.Dlq.get();
      if (localShakeReportUI == null)
      {
        AppMethodBeat.o(28482);
        return;
      }
      if (localShakeReportUI.isFinishing())
      {
        Log.e("MicroMsg.ShakeReportUI", "ui finished");
        AppMethodBeat.o(28482);
        return;
      }
      if (!ShakeReportUI.v(localShakeReportUI))
      {
        Log.i("MicroMsg.ShakeReportUI", "tryShake the status is can's shake");
        AppMethodBeat.o(28482);
        return;
      }
      ShakeReportUI.w(localShakeReportUI);
      long l = Util.ticksToNow(this.lastShakeTime);
      if (l < 1200L)
      {
        Log.i("MicroMsg.ShakeReportUI", "tryStartShake delay too short:".concat(String.valueOf(l)));
        AppMethodBeat.o(28482);
        return;
      }
      Log.w("MicroMsg.ShakeReportUI", "tryStartShake delaytoo enough:".concat(String.valueOf(l)));
      this.lastShakeTime = Util.currentTicks();
      Object localObject;
      if (ShakeReportUI.x(localShakeReportUI) != null)
      {
        localObject = ShakeReportUI.x(localShakeReportUI);
        if (((c)localObject).view != null) {
          ((c)localObject).view.setKeepScreenOn(true);
        }
        ((c)localObject).timer.startTimer(30000L);
      }
      if (ShakeReportUI.y(localShakeReportUI) != null)
      {
        localObject = ShakeReportUI.y(localShakeReportUI);
        if (((com.tencent.mm.pluginsdk.ui.g)localObject).KbY != null) {
          ((com.tencent.mm.pluginsdk.ui.g)localObject).KbY.dismiss();
        }
      }
      if (ShakeReportUI.z(localShakeReportUI))
      {
        localObject = (ShakeReportUI)this.Dlq.get();
        if (localObject != null) {
          PlaySound.play((Context)localObject, 2131765806);
        }
      }
      for (;;)
      {
        reset();
        ShakeReportUI.A(localShakeReportUI);
        AppMethodBeat.o(28482);
        return;
        localObject = (ShakeReportUI)this.Dlq.get();
        if (localObject != null)
        {
          if (this.paT == null) {
            this.paT = ((Vibrator)((ShakeReportUI)localObject).getSystemService("vibrator"));
          }
          if (this.paT != null) {
            this.paT.vibrate(this.VIRBRATOR_PATTERN, -1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI
 * JD-Core Version:    0.7.0.1
 */