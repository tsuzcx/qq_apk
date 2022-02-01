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
import com.tencent.mm.g.a.ee;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.el;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.c;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bv;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.platformtools.ac;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.ce;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h.c;
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
  implements ay, u.a, l.a, f.a, k.a, n.b
{
  private static List<h.a> fHn;
  private com.tencent.mm.modelgeo.d fHi;
  private boolean fHl;
  private Map<String, h.a> fHm;
  private b.a fHp;
  private ImageView fTj;
  private com.tencent.mm.av.a.a ifv;
  private boolean jit;
  private com.tencent.mm.pluginsdk.l.d shakeSensor;
  private boolean vsk;
  private Animation zfA;
  private View zfB;
  private View zfC;
  private MMImageView zfD;
  private TextView zfE;
  private ImageView zfF;
  private String zfG;
  private Bitmap zfH;
  private Dialog zfI;
  private ImageView zfJ;
  private com.tencent.mm.plugin.shake.b.d zfK;
  private ImageView zfL;
  private ImageView zfM;
  private ImageView zfN;
  private ImageView zfO;
  private ImageView zfP;
  private ImageView zfQ;
  private TextView zfR;
  private int zfS;
  private int zfT;
  private View zfU;
  private ImageView zfV;
  private ImageView zfW;
  private ImageView zfX;
  private ImageView zfY;
  private View zfZ;
  private boolean zfd;
  private boolean zfe;
  private boolean zff;
  private boolean zfg;
  private boolean zfh;
  private boolean zfi;
  private boolean zfj;
  private int zfk;
  private c zfl;
  private com.tencent.mm.plugin.shake.b.l zfm;
  private com.tencent.mm.pluginsdk.ui.g zfn;
  private View zfo;
  private View zfp;
  private TextView zfq;
  private TextView zfr;
  private TextView zfs;
  private View zft;
  private View zfu;
  private View zfv;
  private View zfw;
  private Animation zfx;
  private Animation zfy;
  private Animation zfz;
  private View zga;
  private View zgb;
  private View zgc;
  private View zgd;
  private int zge;
  private com.tencent.mm.plugin.shake.c.b.a zgf;
  private boolean zgg;
  @SuppressLint({"UseSparseArrays"})
  private Map<Integer, Boolean> zgh;
  private boolean zgi;
  private boolean zgj;
  private boolean zgk;
  private boolean zgl;
  private int zgm;
  private long zgn;
  private boolean zgo;
  private com.tencent.mm.sdk.b.c zgp;
  private com.tencent.mm.sdk.b.c zgq;
  private View.OnClickListener zgr;
  
  static
  {
    AppMethodBeat.i(28541);
    fHn = new CopyOnWriteArrayList();
    AppMethodBeat.o(28541);
  }
  
  public ShakeReportUI()
  {
    AppMethodBeat.i(28483);
    this.zfd = false;
    this.zfe = false;
    this.zfg = false;
    this.zfh = false;
    this.zfi = false;
    this.zfj = false;
    this.zfk = 22;
    this.zfm = new com.tencent.mm.plugin.shake.b.l();
    this.zfB = null;
    this.zfC = null;
    this.zfD = null;
    this.zfE = null;
    this.zfF = null;
    this.zfG = "";
    this.zfH = null;
    this.zfJ = null;
    this.ifv = null;
    this.zfK = null;
    this.zfS = 1;
    this.zfT = 0;
    this.zgd = null;
    this.zge = 0;
    this.zgg = false;
    this.zgh = new HashMap();
    this.zgi = false;
    this.zgj = false;
    this.zgk = false;
    this.zgl = false;
    this.zgm = 1;
    this.jit = true;
    this.fHl = false;
    this.fHp = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(28446);
        if (paramAnonymousBoolean)
        {
          ae.d("MicroMsg.ShakeReportUI", "on location get ok");
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(am.a.ILJ, String.valueOf(paramAnonymousFloat2));
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(am.a.ILK, String.valueOf(paramAnonymousFloat1));
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(am.a.IOq, String.valueOf(paramAnonymousDouble2));
          ShakeReportUI.a(ShakeReportUI.this);
          if (ShakeReportUI.b(ShakeReportUI.this) != null) {
            ShakeReportUI.b(ShakeReportUI.this).c(ShakeReportUI.c(ShakeReportUI.this));
          }
        }
        for (;;)
        {
          AppMethodBeat.o(28446);
          return false;
          if ((!ShakeReportUI.d(ShakeReportUI.this)) && (!com.tencent.mm.modelgeo.d.aIi()))
          {
            ShakeReportUI.e(ShakeReportUI.this);
            com.tencent.mm.ui.base.h.a(ShakeReportUI.this, ShakeReportUI.this.getString(2131760082), ShakeReportUI.this.getString(2131755906), ShakeReportUI.this.getString(2131760598), ShakeReportUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(28445);
                com.tencent.mm.modelgeo.d.cD(ShakeReportUI.this);
                AppMethodBeat.o(28445);
              }
            }, null);
          }
          ae.w("MicroMsg.ShakeReportUI", "getLocation fail");
        }
      }
    };
    this.fHm = new ConcurrentHashMap();
    this.zgn = 0L;
    this.zgo = false;
    this.zgp = new com.tencent.mm.sdk.b.c() {};
    this.zgq = new com.tencent.mm.sdk.b.c() {};
    this.zgr = new View.OnClickListener()
    {
      public long zeI = 0L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28467);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        if (bu.isNullOrNil((String)ShakeReportUI.r(ShakeReportUI.this).getTag()))
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
          if (System.currentTimeMillis() - this.zeI > 3000L)
          {
            this.zeI = System.currentTimeMillis();
            if ((paramAnonymousView.field_reserved3 == null) || (paramAnonymousView.field_reserved3.split(",").length != 3) || (paramAnonymousView.field_reserved3.split(",")[0] == null) || (paramAnonymousView.field_reserved3.split(",")[0].equals(""))) {
              break label324;
            }
            localObject1 = paramAnonymousView.field_reserved3.split(",");
            localObject2 = new vq();
            ((vq)localObject2).dKT.userName = localObject1[0];
            ((vq)localObject2).dKT.dKV = bu.bI(localObject1[1], "");
            ((vq)localObject2).dKT.dKW = bu.getInt(localObject1[2], 0);
            ((vq)localObject2).dKT.scene = 1077;
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
          }
          for (;;)
          {
            localObject1 = ShakeReportUI.E(ShakeReportUI.this).zce;
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
            com.tencent.mm.br.d.b(ak.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          }
        }
        bc.aCg();
        Object localObject2 = com.tencent.mm.model.c.azF().BH((String)localObject1);
        if (com.tencent.mm.contact.c.lO(((com.tencent.mm.g.c.aw)localObject2).field_type))
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", (String)localObject1);
          paramAnonymousView.putExtra("Sns_from_Scene", 22);
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            if (((an)localObject2).fug())
            {
              com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, (String)localObject1 + "," + ShakeReportUI.O(ShakeReportUI.this));
              paramAnonymousView.putExtra("Contact_Scene", ShakeReportUI.O(ShakeReportUI.this));
            }
            com.tencent.mm.plugin.shake.a.iUz.c(paramAnonymousView, ShakeReportUI.this);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28467);
          return;
          if ((paramAnonymousView.field_reserved1 & 0x8) > 0) {
            com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, paramAnonymousView.field_username + "," + ShakeReportUI.O(ShakeReportUI.this));
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
          com.tencent.mm.plugin.shake.a.iUz.c((Intent)localObject1, ShakeReportUI.this);
        }
      }
    };
    AppMethodBeat.o(28483);
  }
  
  private void Qa(int paramInt)
  {
    AppMethodBeat.i(28503);
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      rg(bool);
      if (paramInt != 2) {
        break;
      }
      rf(true);
      AppMethodBeat.o(28503);
      return;
    }
    rf(false);
    AppMethodBeat.o(28503);
  }
  
  private void a(com.tencent.mm.plugin.shake.c.a.e parame)
  {
    AppMethodBeat.i(28508);
    this.zgf = com.tencent.mm.plugin.shake.c.b.a.a(this, parame, new DialogInterface.OnCancelListener()new com.tencent.mm.plugin.shake.c.b.a.b
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
      public final void dxH()
      {
        AppMethodBeat.i(28466);
        ShakeReportUI.b(ShakeReportUI.this, true);
        ShakeReportUI.M(ShakeReportUI.this).setText("");
        AppMethodBeat.o(28466);
      }
    });
    AppMethodBeat.o(28508);
  }
  
  private void ayJ(String paramString)
  {
    AppMethodBeat.i(28505);
    this.zfg = false;
    if (this.zff) {
      be.aI(getContext(), 2131763595);
    }
    if (this.zfA == null) {
      this.zfA = AnimationUtils.loadAnimation(getContext(), 2130772040);
    }
    Qa(2);
    if ((paramString != null) && (paramString.length() > 1)) {
      this.zfr.setText(paramString);
    }
    for (;;)
    {
      this.zfr.startAnimation(this.zfA);
      this.zfj = true;
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28463);
          ShakeReportUI.K(ShakeReportUI.this);
          ShakeReportUI.d(ShakeReportUI.this, false);
          AppMethodBeat.o(28463);
        }
      }, this.zfA.getDuration());
      AppMethodBeat.o(28505);
      return;
      this.zfr.setText(2131763561);
    }
  }
  
  private void bK(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(28519);
    this.zfg = false;
    if (this.zfA == null) {
      this.zfA = AnimationUtils.loadAnimation(getContext(), 2130772040);
    }
    Qa(2);
    rf(true);
    if ((paramString != null) && (paramString.length() > 1)) {
      this.zfr.setText(paramString);
    }
    for (;;)
    {
      this.zfj = true;
      AppMethodBeat.o(28519);
      return;
      if (paramBoolean)
      {
        this.zfr.setText(2131763551);
      }
      else
      {
        this.zfr.setText("");
        rf(false);
      }
    }
  }
  
  private void c(com.tencent.mm.plugin.shake.b.d paramd)
  {
    AppMethodBeat.i(28513);
    if (bu.isNullOrNil(paramd.field_username))
    {
      AppMethodBeat.o(28513);
      return;
    }
    this.zfo.setTag(paramd.field_username);
    this.zfo.setVisibility(0);
    bc.aCg();
    an localan = com.tencent.mm.model.c.azF().BH(paramd.field_username);
    Object localObject2 = new StringBuilder().append(paramd.field_nickname);
    Object localObject1;
    label156:
    label212:
    label363:
    int i;
    if (com.tencent.mm.contact.c.lO(localan.field_type))
    {
      localObject1 = getString(2131763588);
      localObject2 = (String)localObject1;
      if (paramd.field_sex != 1) {
        break label500;
      }
      this.zfo.setContentDescription((String)localObject2 + paramd.field_distance + getContext().getString(2131763617));
      TextView localTextView = (TextView)this.zfo.findViewById(2131304689);
      AppCompatActivity localAppCompatActivity = getContext();
      StringBuilder localStringBuilder = new StringBuilder().append(paramd.field_nickname);
      if (!com.tencent.mm.contact.c.lO(localan.field_type)) {
        break label585;
      }
      localObject1 = getString(2131763588);
      localTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localAppCompatActivity, (String)localObject1, localTextView.getTextSize()));
      if (this.fTj != null)
      {
        if (bu.isNullOrNil((String)localObject2)) {
          break label591;
        }
        this.fTj.setContentDescription(String.format(getString(2131763543), new Object[] { localObject2 }));
      }
      label277:
      ((TextView)this.zfo.findViewById(2131304687)).setText(paramd.field_distance);
      com.tencent.mm.pluginsdk.ui.a.b.c((ImageView)this.zfo.findViewById(2131304688), paramd.field_username);
      localObject1 = (ImageView)this.zfo.findViewById(2131304691);
      if (paramd.field_reserved1 == 0) {
        break label608;
      }
      ((ImageView)localObject1).setVisibility(0);
      ((ImageView)localObject1).setImageBitmap(BackwardSupportUtil.b.p(au.a.hII.ou(paramd.field_reserved1), 2.0F));
      if ((paramd.field_reserved1 != 0) || (paramd.field_sex == 0)) {
        break label624;
      }
      if (paramd.field_sex != 1) {
        break label617;
      }
      i = 2131690323;
      label389:
      localObject1 = com.tencent.mm.cb.a.l(this, i);
      this.zfo.findViewById(2131304690).setVisibility(0);
      ((ImageView)this.zfo.findViewById(2131304690)).setImageDrawable((Drawable)localObject1);
    }
    for (;;)
    {
      if (paramd.getProvince() == null)
      {
        ae.e("MicroMsg.ShakeReportUI", "PROVINCE NULL");
        paramd.field_province = "";
      }
      if (paramd.getCity() == null)
      {
        ae.e("MicroMsg.ShakeReportUI", "CITY NULL");
        paramd.field_city = "";
      }
      this.zfo.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772129));
      AppMethodBeat.o(28513);
      return;
      localObject1 = "";
      break;
      label500:
      if (paramd.field_sex == 2)
      {
        this.zfo.setContentDescription((String)localObject2 + paramd.field_distance + getContext().getString(2131763616));
        break label156;
      }
      this.zfo.setContentDescription((String)localObject2 + paramd.field_distance);
      break label156;
      label585:
      localObject1 = "";
      break label212;
      label591:
      this.fTj.setContentDescription(getString(2131763544));
      break label277;
      label608:
      ((ImageView)localObject1).setVisibility(8);
      break label363;
      label617:
      i = 2131690322;
      break label389;
      label624:
      this.zfo.findViewById(2131304690).setVisibility(8);
    }
  }
  
  private void d(com.tencent.mm.plugin.shake.b.d paramd)
  {
    AppMethodBeat.i(28514);
    if (bu.isNullOrNil(paramd.field_username))
    {
      AppMethodBeat.o(28514);
      return;
    }
    this.zfo.setTag(paramd.field_username);
    ((TextView)this.zfo.findViewById(2131304689)).setText(paramd.field_username);
    this.zfo.setContentDescription(bu.nullAsNil(paramd.field_nickname));
    ((TextView)this.zfo.findViewById(2131304687)).setText(paramd.field_signature);
    this.ifv.loadImage(paramd.getProvince(), (ImageView)this.zfo.findViewById(2131304688));
    this.zfo.findViewById(2131304690).setVisibility(8);
    this.zfo.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772129));
    this.zfo.setVisibility(0);
    AppMethodBeat.o(28514);
  }
  
  private void dGE()
  {
    AppMethodBeat.i(28486);
    dSX();
    bc.aCg();
    com.tencent.mm.model.c.a(this);
    bc.aCg();
    com.tencent.mm.model.c.ajA().a(this);
    com.tencent.mm.plugin.shake.b.m.dSl().add(this);
    if (this.zfm.zce != null) {
      this.zfm.zce.resume();
    }
    dSY();
    new aq().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28471);
        if (ShakeReportUI.f(ShakeReportUI.this) != null) {
          ShakeReportUI.f(ShakeReportUI.this).ffb();
        }
        AppMethodBeat.o(28471);
      }
    }, 1000L);
    if (this.shakeSensor != null) {
      this.shakeSensor.ffb();
    }
    rf(false);
    rg(false);
    dTa();
    bc.aCg();
    Object localObject = (String)com.tencent.mm.model.c.ajA().get(327696, "1");
    if (com.tencent.mm.plugin.shake.d.a.k.dSj())
    {
      if (this.zfS == 4) {
        rb(true);
      }
      if (((String)localObject).equals("4")) {
        eK(findViewById(2131304719));
      }
    }
    boolean bool;
    if (((String)localObject).equals("3"))
    {
      eK(findViewById(2131304716));
      bool = com.tencent.mm.y.c.ahI().cJ(262154, 266258);
      if ((!getIntent().getBooleanExtra("shake_music", false)) || (!com.tencent.mm.ay.e.aKh()) || (this.zfm.zcd == 3)) {
        break label357;
      }
      getIntent().putExtra("shake_music", false);
      this.zfS = 3;
    }
    for (;;)
    {
      dSZ();
      rc(true);
      ae.d("MicroMsg.ShakeReportUI", "isShakeGetConfigList = %s", new Object[] { Boolean.valueOf(ac.iRx) });
      if (ac.iRx)
      {
        localObject = new com.tencent.mm.bb.l(7);
        bc.ajj().a((com.tencent.mm.ak.n)localObject, 0);
      }
      dTj();
      dTg();
      dSU();
      AppMethodBeat.o(28486);
      return;
      if ((!((String)localObject).equals("6")) || (!com.tencent.mm.plugin.shake.c.c.a.dSK())) {
        break;
      }
      eK(findViewById(2131304706));
      break;
      label357:
      if ((getIntent().getBooleanExtra("shake_tv", false)) && (this.zfm.zcd != 4) && (com.tencent.mm.plugin.shake.d.a.k.dSj()))
      {
        getIntent().putExtra("shake_tv", false);
        this.zfS = 4;
      }
      else if ((this.zfm.zcd != 6) && (com.tencent.mm.plugin.shake.c.c.a.dSK()) && ((bool) || (getIntent().getBooleanExtra("shake_card", false))))
      {
        this.zge = getIntent().getIntExtra("shake_card", 0);
        getIntent().putExtra("shake_card", false);
        ae.i("MicroMsg.ShakeReportUI", "onresume shake card tab is open, activity type is 0 or open from specialview");
        this.zfS = 6;
      }
    }
  }
  
  private void dSU()
  {
    AppMethodBeat.i(28489);
    if (!dTi())
    {
      AppMethodBeat.o(28489);
      return;
    }
    if (BluetoothAdapter.getDefaultAdapter() != null)
    {
      Object localObject = com.tencent.mm.n.g.acM().acC();
      if (localObject != null)
      {
        this.zgn = System.currentTimeMillis();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          ae.i("MicroMsg.ShakeReportUI", "op=true,iBeacon = %s", new Object[] { str });
          ee localee = new ee();
          localee.dqp.dqr = str;
          localee.dqp.dqo = true;
          com.tencent.mm.sdk.b.a.IvT.l(localee);
        }
      }
    }
    AppMethodBeat.o(28489);
  }
  
  private void dSV()
  {
    AppMethodBeat.i(28490);
    bc.aCg();
    if (!bu.a((Boolean)com.tencent.mm.model.c.ajA().get(am.a.IOf, null), false))
    {
      this.fHm.clear();
      fHn = new CopyOnWriteArrayList();
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      Object localObject = com.tencent.mm.n.g.acM().acC();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          ee localee = new ee();
          ae.i("MicroMsg.ShakeReportUI", "op=false,iBeacon = %s", new Object[] { str });
          localee.dqp.dqr = str;
          localee.dqp.dqo = false;
          com.tencent.mm.sdk.b.a.IvT.l(localee);
        }
      }
    }
    AppMethodBeat.o(28490);
  }
  
  private void dSW()
  {
    AppMethodBeat.i(28492);
    if (com.tencent.mm.ay.e.aKi())
    {
      bc.aCg();
      if (com.tencent.mm.model.c.ajA().getInt(4118, 0) == 0)
      {
        com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(getContext());
        locala.afN(2131755906);
        locala.afR(2131763571);
        locala.afU(2131763570).c(new DialogInterface.OnClickListener()
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
        locala.zf(true);
        locala.e(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(28448);
            bc.aCg();
            com.tencent.mm.model.c.ajA().setInt(4118, 1);
            ShakeReportUI.t(ShakeReportUI.this).setVisibility(8);
            AppMethodBeat.o(28448);
          }
        });
        this.zfI = locala.fQv();
        this.zfI.show();
      }
    }
    AppMethodBeat.o(28492);
  }
  
  private void dSX()
  {
    AppMethodBeat.i(28493);
    bc.aCg();
    int j = bu.a((Integer)com.tencent.mm.model.c.ajA().get(12290, null), 0);
    ImageView localImageView = (ImageView)findViewById(2131304700);
    if ((this.zfH != null) && (!this.zfH.isRecycled())) {
      this.zfH.recycle();
    }
    bc.aCg();
    Object localObject1;
    if (bu.n((Boolean)com.tencent.mm.model.c.ajA().get(4110, null)))
    {
      localObject1 = new StringBuilder();
      bc.aCg();
      localObject1 = com.tencent.mm.model.c.azQ() + "default_shake_img_filename.jpg";
      if (com.tencent.mm.vfs.o.fB((String)localObject1))
      {
        this.zfH = u.Js((String)localObject1);
        localImageView.setImageDrawable(new BitmapDrawable(this.zfH));
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
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
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
            localObject = ShakeReportUI.this.getString(2131763575);
            h.c local1 = new h.c()
            {
              public final void lh(int paramAnonymous2Int)
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
            com.tencent.mm.ui.base.h.c(paramAnonymousView, null, new String[] { localObject }, "", local1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(28455);
          }
        };
        ((ImageView)localObject1).setOnClickListener(local7);
        localImageView.setOnClickListener(local7);
        if (this.zfv == null) {
          this.zfv = findViewById(2131304683);
        }
        this.zfv.setOnClickListener(local7);
        if (this.zfw == null) {
          this.zfw = findViewById(2131304684);
        }
        this.zfw.setOnClickListener(local7);
        AppMethodBeat.o(28493);
        return;
        try
        {
          localObject1 = new BitmapDrawable(com.tencent.mm.sdk.platformtools.h.decodeStream(getContext().getAssets().open("resource/shakehideimg_man.jpg")));
          localImageView.setImageDrawable((Drawable)localObject1);
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ae.w("MicroMsg.ShakeReportUI", "Bg decode exp:" + localIOException.getLocalizedMessage());
            Object localObject2 = null;
          }
        }
      }
      bc.aCg();
      this.zfH = u.Js((String)com.tencent.mm.model.c.ajA().get(4111, null));
      localImageView.setImageDrawable(new BitmapDrawable(this.zfH));
      break;
      i = 2131233995;
      break label179;
    }
  }
  
  private void dSY()
  {
    AppMethodBeat.i(28494);
    this.zfi = true;
    if ((this.zgf != null) && (this.zgf.isShowing()) && (!this.zgf.zdl)) {
      this.zfi = false;
    }
    ae.i("MicroMsg.ShakeReportUI", "tryStartShake");
    if ((this.shakeSensor != null) && (!this.shakeSensor.ffa()))
    {
      this.shakeSensor.a(new a(this));
      if ((this.shakeSensor.ffc()) && (this.zfq != null))
      {
        this.zfq.setText(getString(2131763534));
        AppMethodBeat.o(28494);
        return;
      }
      this.zfq.setText(getString(2131763596));
    }
    AppMethodBeat.o(28494);
  }
  
  private void dSZ()
  {
    AppMethodBeat.i(28496);
    if ((this.zfS == 3) && (com.tencent.mm.ay.e.aKh()))
    {
      this.zfS = 3;
      this.zfs.setText(2131763612);
      this.zfJ.setBackgroundResource(2131233978);
      this.zfL.setBackgroundResource(2131233984);
      this.zfM.setBackgroundResource(2131233983);
      this.zfN.setBackgroundResource(2131233987);
      this.zfO.setBackgroundResource(2131233974);
      findViewById(2131304701).setVisibility(0);
      setMMTitle(2131763608);
      com.tencent.mm.plugin.report.service.g.yxI.f(11720, new Object[] { Integer.valueOf(2) });
      com.tencent.mm.plugin.report.service.g.yxI.n(834L, 2L, 1L);
    }
    for (;;)
    {
      l.b localb = this.zfm.a(this, this.zfS, this);
      if (!this.zfg) {
        rg(false);
      }
      if ((com.tencent.mm.plugin.shake.c.c.a.dSK()) && ((localb instanceof com.tencent.mm.plugin.shake.c.a.g)))
      {
        ((com.tencent.mm.plugin.shake.c.a.g)localb).setFromScene(this.zge);
        if (this.zge == 3)
        {
          ae.i("MicroMsg.ShakeReportUI", "open shake card from specialview");
          ((com.tencent.mm.plugin.shake.c.a.g)localb).abf(getIntent().getStringExtra("key_shake_card_ext_info"));
        }
      }
      AppMethodBeat.o(28496);
      return;
      if ((this.zfS == 4) && (com.tencent.mm.plugin.shake.d.a.k.dSj()))
      {
        this.zfS = 4;
        this.zfs.setText(2131763613);
        this.zfJ.setBackgroundResource(2131233978);
        this.zfL.setBackgroundResource(2131233984);
        this.zfM.setBackgroundResource(2131233981);
        this.zfN.setBackgroundResource(2131233989);
        this.zfO.setBackgroundResource(2131233974);
        findViewById(2131304701).setVisibility(0);
        setMMTitle(2131763609);
        com.tencent.mm.plugin.report.service.g.yxI.f(11720, new Object[] { Integer.valueOf(3) });
        com.tencent.mm.plugin.report.service.g.yxI.n(834L, 3L, 1L);
      }
      else if ((this.zfS == 5) && (dTh()))
      {
        this.zfS = 5;
        this.zfs.setText(2131763611);
        this.zfJ.setBackgroundResource(2131233980);
        this.zfL.setBackgroundResource(2131233984);
        this.zfM.setBackgroundResource(2131233981);
        this.zfN.setBackgroundResource(2131233987);
        this.zfO.setBackgroundResource(2131233974);
        findViewById(2131304701).setVisibility(0);
        setMMTitle(2131763607);
        com.tencent.mm.plugin.report.service.g.yxI.f(11720, new Object[] { Integer.valueOf(4) });
        com.tencent.mm.plugin.report.service.g.yxI.n(834L, 4L, 1L);
      }
      else if ((this.zfS == 6) && (com.tencent.mm.plugin.shake.c.c.a.dSK()))
      {
        this.zfS = 6;
        this.zfs.setText(2131763610);
        this.zfJ.setBackgroundResource(2131233978);
        this.zfL.setBackgroundResource(2131233984);
        this.zfM.setBackgroundResource(2131233981);
        this.zfN.setBackgroundResource(2131233987);
        this.zfO.setBackgroundResource(2131233975);
        findViewById(2131304701).setVisibility(0);
        setMMTitle(2131763606);
        dTc();
        dTf();
        com.tencent.mm.plugin.report.service.g.yxI.f(11720, new Object[] { Integer.valueOf(5) });
        com.tencent.mm.plugin.report.service.g.yxI.n(834L, 5L, 1L);
      }
      else
      {
        this.zfS = 1;
        this.zfs.setText(2131763554);
        this.zfJ.setBackgroundResource(2131233978);
        this.zfL.setBackgroundResource(2131233986);
        this.zfM.setBackgroundResource(2131233981);
        this.zfN.setBackgroundResource(2131233987);
        this.zfO.setBackgroundResource(2131233974);
        if (com.tencent.mm.ay.e.aKh()) {
          findViewById(2131304701).setVisibility(0);
        }
        setMMTitle(2131763605);
        com.tencent.mm.plugin.report.service.g.yxI.f(11720, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.g.yxI.n(834L, 1L, 1L);
      }
    }
  }
  
  private void dTa()
  {
    AppMethodBeat.i(28497);
    bc.aCg();
    this.zff = bu.n((Boolean)com.tencent.mm.model.c.ajA().get(4112, null));
    if (this.zff)
    {
      setTitleMuteIconVisibility(8);
      AppMethodBeat.o(28497);
      return;
    }
    setTitleMuteIconVisibility(0);
    AppMethodBeat.o(28497);
  }
  
  private void dTb()
  {
    AppMethodBeat.i(28517);
    if (com.tencent.mm.plugin.shake.c.c.a.dSK())
    {
      if (com.tencent.mm.y.c.ahI().cJ(262155, 266259))
      {
        this.zfQ.setVisibility(0);
        AppMethodBeat.o(28517);
        return;
      }
      this.zfQ.setVisibility(8);
    }
    AppMethodBeat.o(28517);
  }
  
  private void dTc()
  {
    AppMethodBeat.i(28518);
    if ((this.zfS == 6) && (com.tencent.mm.plugin.shake.c.c.a.dSK()))
    {
      boolean bool1 = com.tencent.mm.y.c.ahI().cJ(262154, 266258);
      boolean bool2 = com.tencent.mm.y.c.ahI().cJ(262155, 266259);
      if (bool1)
      {
        bK(com.tencent.mm.plugin.shake.c.c.a.dSF(), true);
        AppMethodBeat.o(28518);
        return;
      }
      if (bool2)
      {
        bK(com.tencent.mm.plugin.shake.c.c.a.dSH(), true);
        AppMethodBeat.o(28518);
        return;
      }
      if (!this.zgg)
      {
        if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.dSD()))
        {
          bK(com.tencent.mm.plugin.shake.c.c.a.dSD(), true);
          AppMethodBeat.o(28518);
          return;
        }
        bK(getString(2131763551), true);
      }
    }
    AppMethodBeat.o(28518);
  }
  
  private void dTd()
  {
    AppMethodBeat.i(28520);
    if ((this.zgf != null) && (this.zgf.isShowing())) {
      this.zgf.dismiss();
    }
    this.zgf = null;
    AppMethodBeat.o(28520);
  }
  
  private void dTe()
  {
    int m = 1;
    AppMethodBeat.i(28521);
    boolean bool1 = com.tencent.mm.plugin.shake.c.c.a.dSg();
    boolean bool2 = com.tencent.mm.y.c.ahI().cJ(262154, 266258);
    boolean bool3 = com.tencent.mm.y.c.ahI().cJ(262155, 266259);
    if (getIntent().getBooleanExtra("shake_card", false)) {}
    for (int i = getIntent().getIntExtra("shake_card", 0);; i = 0)
    {
      com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
      int j;
      if (bool2)
      {
        j = 1;
        if (!bool1) {
          break label231;
        }
        k = 1;
        label87:
        localg.f(11668, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), com.tencent.mm.plugin.shake.c.c.a.dSG(), Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.dSC()) });
        localg = com.tencent.mm.plugin.report.service.g.yxI;
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
        localg.f(11668, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), com.tencent.mm.plugin.shake.c.c.a.dSG(), Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.dSC()) });
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
  
  private void dTf()
  {
    AppMethodBeat.i(28522);
    if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.dSE())) {
      this.zfR.setText(com.tencent.mm.plugin.shake.c.c.a.dSE());
    }
    AppMethodBeat.o(28522);
  }
  
  private void dTg()
  {
    AppMethodBeat.i(28523);
    label123:
    Object localObject;
    label167:
    label208:
    int i;
    if (com.tencent.mm.ay.e.aKh())
    {
      ae.i("MicroMsg.ShakeReportUI", "is not oversea user, show shake music");
      this.zgh.put(Integer.valueOf(3), Boolean.TRUE);
      findViewById(2131304716).setVisibility(0);
      if (com.tencent.mm.ay.e.aKi())
      {
        bc.aCg();
        if (com.tencent.mm.model.c.ajA().getInt(4118, 0) == 0) {
          this.zfP.setVisibility(0);
        }
      }
      else
      {
        if (!com.tencent.mm.plugin.shake.d.a.k.dSj()) {
          break label309;
        }
        this.zgh.put(Integer.valueOf(4), Boolean.TRUE);
        findViewById(2131304719).setVisibility(0);
        ae.i("MicroMsg.ShakeReportUI", "show shake tv tab");
        if (!com.tencent.mm.plugin.shake.c.c.a.dSK()) {
          break label350;
        }
        this.zgh.put(Integer.valueOf(6), Boolean.TRUE);
        findViewById(2131304706).setVisibility(0);
        ae.i("MicroMsg.ShakeReportUI", "show shake card tab");
        if (!dTh()) {
          break label392;
        }
        this.zgh.put(Integer.valueOf(5), Boolean.TRUE);
        this.zgd.setVisibility(0);
        ae.i("MicroMsg.ShakeReportUI", "[shakezb]show shake ibeacon tab");
        localObject = this.zgh.values().iterator();
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
      this.zfP.setVisibility(8);
      break;
      this.zgh.put(Integer.valueOf(3), Boolean.FALSE);
      findViewById(2131304716).setVisibility(8);
      ae.i("MicroMsg.ShakeReportUI", "is oversea user, hide shake music");
      break;
      this.zgh.put(Integer.valueOf(4), Boolean.FALSE);
      findViewById(2131304719).setVisibility(8);
      ae.i("MicroMsg.ShakeReportUI", "hide shake tv tab");
      break label123;
      label350:
      findViewById(2131304706).setVisibility(8);
      this.zgh.put(Integer.valueOf(6), Boolean.FALSE);
      ae.i("MicroMsg.ShakeReportUI", "hide shake card tab");
      break label167;
      this.zgh.put(Integer.valueOf(5), Boolean.FALSE);
      this.zgd.setVisibility(8);
      ae.i("MicroMsg.ShakeReportUI", "[shakezb]hide shake ibeacon tab");
      break label208;
      this.zfT = i;
      localObject = (LinearLayout)findViewById(2131304701);
      if (i == 1) {
        ((LinearLayout)localObject).setVisibility(8);
      }
      while ((i > 4) && (this.zgo))
      {
        findViewById(2131304719).setVisibility(8);
        ae.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() > 0.");
        this.zfT -= 1;
        AppMethodBeat.o(28523);
        return;
        ((LinearLayout)localObject).setVisibility(0);
      }
      if ((i > 4) && (!this.zgo))
      {
        this.zgd.setVisibility(8);
        this.zgi = false;
        this.zfT -= 1;
        ae.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() <= 0.");
      }
      AppMethodBeat.o(28523);
      return;
    }
  }
  
  private boolean dTh()
  {
    AppMethodBeat.i(28524);
    ae.i("MicroMsg.ShakeReportUI", "[shakezb] isChineseAppLang :" + ad.foi() + " ,getApplicationLanguage[en or zh_CN or zh_HK or zh_TW is avaliable] :" + ad.fom());
    if ((this.zgi) && (dTi()))
    {
      AppMethodBeat.o(28524);
      return true;
    }
    AppMethodBeat.o(28524);
    return false;
  }
  
  private static boolean dTi()
  {
    AppMethodBeat.i(28525);
    if ((ad.foi()) || (ad.fom().equals("en")) || (ad.fom().equals("ja")))
    {
      AppMethodBeat.o(28525);
      return true;
    }
    AppMethodBeat.o(28525);
    return false;
  }
  
  private void dTj()
  {
    AppMethodBeat.i(28526);
    this.zfU.setVisibility(8);
    AppMethodBeat.o(28526);
  }
  
  private void eK(View paramView)
  {
    AppMethodBeat.i(28509);
    if (paramView == null)
    {
      AppMethodBeat.o(28509);
      return;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, "", "");
    ae.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this });
    if (!bool)
    {
      AppMethodBeat.o(28509);
      return;
    }
    bK("", false);
    if (paramView.getId() == 2131304710)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11722, new Object[] { Integer.valueOf(1) });
      if (this.zfS != 1)
      {
        if (this.zfS == 4) {
          rb(false);
        }
        this.zfS = 1;
        dSZ();
        rd(false);
        if (this.zfo != null) {
          this.zfo.setVisibility(8);
        }
      }
    }
    do
    {
      for (;;)
      {
        rc(true);
        rg(false);
        dTj();
        AppMethodBeat.o(28509);
        return;
        if (paramView.getId() == 2131304716)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(11722, new Object[] { Integer.valueOf(2) });
          if ((!this.fHl) && (this.fHi != null)) {
            this.fHi.a(this.fHp, true);
          }
          if ((!com.tencent.mm.r.a.ch(this)) && (!com.tencent.mm.r.a.cf(this)) && (!com.tencent.mm.r.a.cj(this)) && (this.zfS != 3))
          {
            if (this.zfS == 4) {
              rb(false);
            }
            this.zfS = 3;
            dSZ();
            rd(false);
            if (this.zfo != null) {
              this.zfo.setVisibility(8);
            }
          }
          dSW();
        }
        else
        {
          if (paramView.getId() != 2131304719) {
            break;
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(11722, new Object[] { Integer.valueOf(3) });
          if ((!this.fHl) && (this.fHi != null)) {
            this.fHi.a(this.fHp, true);
          }
          if ((!com.tencent.mm.r.a.ch(this)) && (!com.tencent.mm.r.a.cf(this)) && (!com.tencent.mm.r.a.cj(this)) && (this.zfS != 4))
          {
            rb(true);
            this.zfS = 4;
            dSZ();
            rd(false);
            if (this.zfo != null) {
              this.zfo.setVisibility(8);
            }
          }
        }
      }
      if ((paramView.getId() != 2131304714) && (paramView.getId() != 2131304711)) {
        break;
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(11722, new Object[] { Integer.valueOf(4) });
    } while (this.zfS == 5);
    this.zfS = 5;
    dSZ();
    rd(false);
    if (this.zfo != null) {
      this.zfo.setVisibility(8);
    }
    if ((!Build.VERSION.RELEASE.equals("6.0")) && (!Build.VERSION.RELEASE.equals("6.0.0")) && (Build.VERSION.SDK_INT >= 23))
    {
      paramView = (LocationManager)ak.getContext().getSystemService("location");
      if (paramView == null) {
        break label743;
      }
    }
    label743:
    for (bool = paramView.isProviderEnabled("gps");; bool = true)
    {
      if (!bool) {
        ayJ(getString(2131763565));
      }
      paramView = BluetoothAdapter.getDefaultAdapter();
      if ((paramView != null) && (paramView.getState() != 12))
      {
        ayJ(getString(2131763564));
        break;
      }
      if (paramView != null) {
        break;
      }
      ayJ(getString(2131763568));
      break;
      if (paramView.getId() != 2131304706) {
        break;
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(11722, new Object[] { Integer.valueOf(5) });
      if (this.zfS == 6) {
        break;
      }
      if (this.zfS == 4) {
        rb(false);
      }
      this.zfS = 6;
      dSZ();
      rd(false);
      if (this.zfo != null) {
        this.zfo.setVisibility(8);
      }
      com.tencent.mm.y.c.ahI().x(262155, false);
      this.zfQ.setVisibility(8);
      break;
    }
  }
  
  private void rb(boolean paramBoolean)
  {
    AppMethodBeat.i(28495);
    String str = String.format("%1$s-shaketype-%2$d", new Object[] { getClass().getName(), Integer.valueOf(4) });
    ae.d("MicroMsg.ShakeReportUI", "activate change report , class name=" + str + ", isActive=" + paramBoolean);
    y.d(paramBoolean, new Intent().putExtra("classname", str));
    AppMethodBeat.o(28495);
  }
  
  private void rc(boolean paramBoolean)
  {
    AppMethodBeat.i(28498);
    rd(paramBoolean);
    re(paramBoolean);
    AppMethodBeat.o(28498);
  }
  
  private void rd(boolean paramBoolean)
  {
    AppMethodBeat.i(28499);
    if (this.zfB == null) {
      this.zfB = findViewById(2131300604);
    }
    if ((this.zfm.zcd == 3) || (this.zfm.zcd == 4) || (this.zfm.zcd == 5) || (this.zfm.zcd == 6) || (!paramBoolean))
    {
      this.zfB.setVisibility(8);
      AppMethodBeat.o(28499);
      return;
    }
    int i = com.tencent.mm.bj.d.aMO().bVY();
    if (i <= 0)
    {
      this.zfB.setVisibility(8);
      AppMethodBeat.o(28499);
      return;
    }
    this.zfB.setVisibility(0);
    ((TextView)this.zfB.findViewById(2131304292)).setText(getResources().getQuantityString(2131623965, i, new Object[] { Integer.valueOf(i) }));
    this.zfB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28456);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        localObject = new Intent(ShakeReportUI.this, ShakeSayHiListUI.class);
        ((Intent)localObject).putExtra("IntentSayHiType", 1);
        paramAnonymousView = ShakeReportUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$16", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$16", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28456);
      }
    });
    if (this.zfF == null) {
      this.zfF = ((ImageView)findViewById(2131302192));
    }
    ce localce = com.tencent.mm.bj.d.aMO().fwL();
    if (localce != null)
    {
      this.zfG = localce.field_sayhiuser;
      com.tencent.mm.pluginsdk.ui.a.b.c(this.zfF, this.zfG);
    }
    AppMethodBeat.o(28499);
  }
  
  private void re(boolean paramBoolean)
  {
    AppMethodBeat.i(28500);
    if (this.zfC == null) {
      this.zfC = findViewById(2131300605);
    }
    if (!paramBoolean)
    {
      this.zfC.setVisibility(8);
      AppMethodBeat.o(28500);
      return;
    }
    int i = com.tencent.mm.plugin.shake.b.m.dSm().bVY();
    if (i <= 0)
    {
      this.zfC.setVisibility(8);
      AppMethodBeat.o(28500);
      return;
    }
    if (this.zfE == null) {
      this.zfE = ((TextView)this.zfC.findViewById(2131304692));
    }
    this.zfE.setText(getString(2131763589, new Object[] { Integer.valueOf(i) }));
    this.zfC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28457);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        localObject = new Intent(ShakeReportUI.this, ShakeMsgListUI.class);
        ((Intent)localObject).putExtra("shake_msg_from", 1);
        ((Intent)localObject).putExtra("shake_msg_list_title", ShakeReportUI.this.getString(2131763637));
        paramAnonymousView = ShakeReportUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$17", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$17", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28457);
      }
    });
    if (this.zfD == null) {
      this.zfD = ((MMImageView)findViewById(2131304698));
    }
    Object localObject = com.tencent.mm.plugin.shake.b.m.dSm().dSc();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.shake.b.f)localObject).field_thumburl;
      if (bu.isNullOrNil((String)localObject)) {
        break label255;
      }
      localObject = new com.tencent.mm.plugin.shake.e.b((String)localObject);
      Bitmap localBitmap = u.a((s)localObject);
      this.zfD.setTag(((com.tencent.mm.plugin.shake.e.b)localObject).aQX());
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        break label242;
      }
      this.zfD.setImageBitmap(localBitmap);
    }
    for (;;)
    {
      this.zfC.setVisibility(0);
      AppMethodBeat.o(28500);
      return;
      label242:
      this.zfD.setImageResource(2131689584);
      continue;
      label255:
      this.zfD.setImageResource(2131689584);
    }
  }
  
  private void rf(boolean paramBoolean)
  {
    AppMethodBeat.i(28501);
    if (this.zfr != null)
    {
      if (paramBoolean)
      {
        this.zfr.setVisibility(0);
        AppMethodBeat.o(28501);
        return;
      }
      this.zfr.setVisibility(8);
      this.zfr.cancelLongPress();
    }
    AppMethodBeat.o(28501);
  }
  
  private void rg(boolean paramBoolean)
  {
    AppMethodBeat.i(28502);
    if (this.zfp != null)
    {
      if (paramBoolean)
      {
        this.zfp.setVisibility(0);
        AppMethodBeat.o(28502);
        return;
      }
      this.zfp.setVisibility(4);
    }
    AppMethodBeat.o(28502);
  }
  
  public final void a(int paramInt, final com.tencent.mm.plugin.shake.c.a.e parame, long paramLong)
  {
    AppMethodBeat.i(28507);
    this.zgg = true;
    if (paramInt == 1251)
    {
      if (parame == null)
      {
        AppMethodBeat.o(28507);
        return;
      }
      ae.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_GetLbsCard");
      com.tencent.mm.plugin.shake.c.c.a.dSf();
      dTg();
      dTb();
      dTe();
      this.zge = 4;
      com.tencent.mm.plugin.shake.b.m.dSr().putValue("key_shake_card_item", parame);
      AppMethodBeat.o(28507);
      return;
    }
    Object localObject;
    if (paramInt == 1250)
    {
      if (parame == null)
      {
        this.zfK = null;
        ayJ(null);
        AppMethodBeat.o(28507);
        return;
      }
      if (((parame == null) || (this.zfg)) && (!this.zfg))
      {
        this.zfK = null;
        ayJ(null);
        AppMethodBeat.o(28507);
        return;
      }
      this.zfg = false;
      ae.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_ShakeCard");
      if (this.zfm.zcd == 6)
      {
        localObject = this.zfm.zce;
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
      ae.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_OK");
      if (((com.tencent.mm.plugin.shake.c.a.g)localObject).oGc == 3)
      {
        ae.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is  MMBIZ_SHAKE_CARD_ACTION_TYPE_NO_CARD");
        if ((parame != null) && (!TextUtils.isEmpty(parame.zcG)))
        {
          ayJ(parame.zcG);
          AppMethodBeat.o(28507);
          return;
        }
        ayJ(getString(2131763550));
        AppMethodBeat.o(28507);
        return;
      }
      ae.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is " + ((com.tencent.mm.plugin.shake.c.a.g)localObject).oGc);
      Qa(3);
      if (parame.oGc == 1) {
        this.zfi = false;
      }
      if ((this.zgf != null) && (this.zgf.isShowing()))
      {
        AppMethodBeat.o(28507);
        return;
      }
      if (parame.zcI)
      {
        localObject = (ViewStub)findViewById(2131306441);
        if (localObject != null) {
          ((ViewStub)localObject).inflate();
        }
        ((ShakeEggAnimFrame)findViewById(2131297976)).aD(this);
        new aq().postDelayed(new Runnable()
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
      ae.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_ERR_REPORT");
      ayJ(getString(2131763550));
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
    dTa();
    if (!this.zfh) {
      rc(true);
    }
    AppMethodBeat.o(28511);
  }
  
  public final void aBX()
  {
    AppMethodBeat.i(28504);
    dSZ();
    AppMethodBeat.o(28504);
  }
  
  public final void d(List<com.tencent.mm.plugin.shake.b.d> paramList, long paramLong)
  {
    AppMethodBeat.i(28506);
    dTj();
    if ((paramList == null) || (!this.zfg) || (paramLong == 6L))
    {
      this.zfK = null;
      if (paramLong == 6L)
      {
        ayJ(getString(2131763569));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 7L)
      {
        ayJ(getString(2131763567));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 8L)
      {
        ayJ(getString(2131763565));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 9L)
      {
        ayJ(getString(2131763564));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 10L)
      {
        ayJ(getString(2131763568));
        AppMethodBeat.o(28506);
        return;
      }
      ayJ(null);
      AppMethodBeat.o(28506);
      return;
    }
    this.zfg = false;
    if (paramList.size() > 0) {
      this.zfK = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0));
    }
    int i;
    Object localObject;
    if (this.zfm.zcd == 1)
    {
      if ((paramList.size() > 0) && (((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_type != 0))
      {
        ayJ(null);
        AppMethodBeat.o(28506);
        return;
      }
      this.zfk = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).scene;
      i = paramList.size();
      if (i == 0)
      {
        ayJ(null);
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        localObject = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_username;
        String str = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_nickname;
        ae.i("MicroMsg.ShakeReportUI", "1 u:" + (String)localObject + " n:" + str + " d:" + ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_distance);
        if (this.zff) {
          be.aI(getContext(), 2131763587);
        }
        Qa(3);
        c((com.tencent.mm.plugin.shake.b.d)paramList.get(0));
        AppMethodBeat.o(28506);
        return;
      }
      if (this.zff) {
        be.aI(getContext(), 2131763587);
      }
      Qa(3);
      rd(false);
      paramList = new Intent(this, ShakeItemListUI.class);
      paramList.putExtra("_key_show_type_", -1);
      paramList.putExtra("_key_title_", getString(2131763582));
      paramList = new com.tencent.mm.hellhoundlib.b.a().bc(paramList);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramList.ahE(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramList.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(28506);
      return;
    }
    if (this.zfm.zcd == 3)
    {
      i = paramList.size();
      if (i == 0)
      {
        ayJ(getString(2131763594));
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        if (this.zff) {
          be.aI(getContext(), 2131763587);
        }
        Qa(3);
        if (((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_type == 4)
        {
          paramList = com.tencent.mm.plugin.shake.d.a.i.d(((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_lvbuffer, paramLong);
          com.tencent.mm.ay.a.d(paramList);
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_mode", 1);
          ((Intent)localObject).putExtra("key_offset", paramList.ika);
          ((Intent)localObject).putExtra("music_player_beg_time", paramList.iks);
          ((Intent)localObject).putExtra("key_scene", 3);
          if (com.tencent.mm.ay.e.aKi()) {
            ((Intent)localObject).putExtra("KGlobalShakeMusic", true);
          }
          com.tencent.mm.br.d.b(this, "music", ".ui.MusicMainUI", (Intent)localObject);
          AppMethodBeat.o(28506);
          return;
        }
        ae.w("MicroMsg.ShakeReportUI", "Unexpected type, ignore.");
      }
      AppMethodBeat.o(28506);
      return;
    }
    if (this.zfm.zcd == 4)
    {
      dTj();
      i = paramList.size();
      if (i == 0)
      {
        ayJ(getString(2131763638));
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        if (this.zff) {
          be.aI(getContext(), 2131763587);
        }
        Qa(3);
        com.tencent.mm.plugin.shake.d.a.k.a((com.tencent.mm.plugin.shake.b.d)paramList.get(0), this);
      }
      AppMethodBeat.o(28506);
      return;
    }
    if (this.zfm.zcd == 5) {
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
          if (this.zff) {
            be.aI(getContext(), 2131763587);
          }
          Qa(3);
          d((com.tencent.mm.plugin.shake.b.d)paramList.get(0));
          AppMethodBeat.o(28506);
          return;
        }
        if (this.zff) {
          be.aI(getContext(), 2131763587);
        }
        Qa(3);
        rd(false);
        localObject = new Intent(this, ShakeItemListUI.class);
        ((Intent)localObject).putExtra("_key_show_type_", -12);
        ((Intent)localObject).putExtra("_key_title_", getString(2131763580));
        ((Intent)localObject).putExtra("_key_show_from_shake_", true);
        ((Intent)localObject).putExtra("_ibeacon_new_insert_size", paramList.size());
        paramList = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramList.ahE(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramList.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(28506);
        return;
      }
      ayJ(null);
      AppMethodBeat.o(28506);
      return;
      ayJ(getString(2131763569));
    }
  }
  
  public final void dSu()
  {
    AppMethodBeat.i(28516);
    com.tencent.mm.plugin.shake.c.c.a.dSf();
    dTb();
    dTc();
    dTf();
    dTg();
    dTe();
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
    com.tencent.mm.plugin.shake.c.c.a.dSf();
    this.zgh.put(Integer.valueOf(1), Boolean.TRUE);
    this.zgh.put(Integer.valueOf(3), Boolean.FALSE);
    this.zgh.put(Integer.valueOf(4), Boolean.FALSE);
    this.zgh.put(Integer.valueOf(5), Boolean.FALSE);
    this.zgh.put(Integer.valueOf(6), Boolean.FALSE);
    this.ifv = new com.tencent.mm.av.a.a(this);
    this.zfq = ((TextView)findViewById(2131304704));
    this.zfp = findViewById(2131304720);
    this.zfr = ((TextView)findViewById(2131304699));
    this.zfs = ((TextView)findViewById(2131304703));
    this.zfU = findViewById(2131304734);
    this.zfV = ((ImageView)findViewById(2131304722));
    this.zfW = ((ImageView)findViewById(2131304724));
    this.zfX = ((ImageView)findViewById(2131304726));
    this.zfY = ((ImageView)findViewById(2131304728));
    this.zfZ = findViewById(2131304723);
    this.zga = findViewById(2131304725);
    this.zgb = findViewById(2131304727);
    this.zgc = findViewById(2131304729);
    this.zfo = findViewById(2131304702);
    this.zfo.setOnClickListener(this.zgr);
    this.fTj = ((ImageView)this.zfo.findViewById(2131304688));
    this.fTj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28477);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (ShakeReportUI.q(ShakeReportUI.this) != 5)
        {
          localObject = new Intent(ShakeReportUI.this.getContext(), ProfileHdHeadImg.class);
          ((Intent)localObject).putExtra("username", (String)ShakeReportUI.r(ShakeReportUI.this).getTag());
          paramAnonymousView = ShakeReportUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28477);
      }
    });
    dSX();
    Object localObject = View.inflate(getContext(), 2131495416, null);
    this.zfI = new com.tencent.mm.ui.base.i(getContext(), 2131821723);
    this.zfI.setContentView((View)localObject);
    this.zfI.setOnCancelListener(new DialogInterface.OnCancelListener()
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
            bc.aCg();
            com.tencent.mm.model.c.ajA().set(4117, Boolean.TRUE);
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
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ShakeReportUI.s(ShakeReportUI.this).cancel();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28451);
      }
    });
    bc.aCg();
    boolean bool1 = bu.o((Boolean)com.tencent.mm.model.c.ajA().get(4108, null));
    bc.aCg();
    boolean bool2 = bu.o((Boolean)com.tencent.mm.model.c.ajA().get(4117, null));
    if (!bool1)
    {
      ((View)localObject).setVisibility(0);
      this.zfI.show();
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(4108, Boolean.TRUE);
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
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ShakeReportUI.a(ShakeReportUI.this, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28480);
        }
      };
      if ((!this.zgl) && (!this.zgj)) {
        break label772;
      }
    }
    label772:
    for (this.zfJ = ((ImageView)findViewById(2131304713));; this.zfJ = ((ImageView)findViewById(2131304712)))
    {
      this.zfL = ((ImageView)findViewById(2131304709));
      this.zfM = ((ImageView)findViewById(2131304715));
      this.zfN = ((ImageView)findViewById(2131304718));
      this.zfO = ((ImageView)findViewById(2131304705));
      this.zfR = ((TextView)findViewById(2131304708));
      this.zfQ = ((ImageView)findViewById(2131304707));
      this.zfP = ((ImageView)findViewById(2131304717));
      dTf();
      this.zgd.setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304714).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304710).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304716).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304719).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304706).setOnClickListener((View.OnClickListener)localObject);
      com.tencent.mm.sdk.b.a.IvT.c(this.zgp);
      com.tencent.mm.sdk.b.a.IvT.c(this.zgq);
      dTb();
      dTe();
      dTj();
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
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(4117, Boolean.TRUE);
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
    if ((this.zfD != null) && (this.zfD.getTag() != null) && (paramString.equals((String)this.zfD.getTag()))) {
      this.zfD.setImageBitmap(paramBitmap);
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
      bc.aCg();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.model.c.azQ() + "custom_shake_img_filename.jpg");
      com.tencent.mm.plugin.shake.a.iUz.a(localIntent, 2, this, paramIntent);
      AppMethodBeat.o(28510);
      return;
    case 2: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(28510);
        return;
      }
      paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(4110, Boolean.FALSE);
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(4111, paramIntent);
      dSX();
      AppMethodBeat.o(28510);
      return;
    }
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
      {
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYR, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
        this.jit = false;
        AppMethodBeat.o(28510);
        return;
      }
      this.jit = true;
      finish();
      AppMethodBeat.o(28510);
      return;
    }
    this.jit = true;
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
    this.fHi = com.tencent.mm.modelgeo.d.aIh();
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.ILJ, "");
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.ILK, "");
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IOq, "");
    this.zgd = findViewById(2131304711);
    paramBundle = bv.aCL();
    Object localObject1 = bu.nullAsNil(paramBundle.provinceCode);
    Object localObject2 = bu.nullAsNil(paramBundle.cityCode);
    paramBundle = com.tencent.mm.n.g.acM().ah("IBeacon", "GatedLaunch");
    int i;
    int j;
    if (!bu.isNullOrNil(paramBundle))
    {
      this.zgj = false;
      this.zgk = false;
      if (paramBundle != null) {}
      try
      {
        paramBundle = new JSONObject(paramBundle);
        i = paramBundle.getInt("gatedlaunch");
        bc.ajM();
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
            Object localObject3 = com.tencent.mm.plugin.shake.b.m.dSl();
            ((com.tencent.mm.plugin.shake.b.e)localObject3).dSb();
            ((com.tencent.mm.plugin.shake.b.e)localObject3).a((com.tencent.mm.plugin.shake.b.d)localObject2, true);
            localObject3 = new LinkedList();
            ((List)localObject3).add(localObject2);
            d((List)localObject3, 1L);
            bc.aCg();
            com.tencent.mm.model.c.ajA().set(am.a.IOb, "");
            paramBundle = paramBundle + "," + localObject1[4] + localObject1[5] + localObject1[6];
            bc.aCg();
            com.tencent.mm.model.c.ajA().set(am.a.IOc, paramBundle);
            this.zfl = new c(getBodyView());
            this.shakeSensor = new com.tencent.mm.pluginsdk.l.d();
            if (!this.shakeSensor.ffc()) {
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
            if (com.tencent.mm.plugin.shake.a.iUA != null) {
              com.tencent.mm.plugin.shake.a.iUA.MM();
            }
            u.b(this);
            ae.i("MicroMsg.ShakeReportUI", "%s", new Object[] { getResources().getDisplayMetrics().toString() });
            i = com.tencent.mm.plugin.shake.b.m.dSm().bVY();
            com.tencent.mm.plugin.report.service.g.yxI.f(11317, new Object[] { Integer.valueOf(i), e.dTl() });
            com.tencent.mm.plugin.report.service.g.yxI.f(11710, new Object[] { Integer.valueOf(1) });
            com.tencent.mm.plugin.report.service.g.yxI.n(834L, 0L, 1L);
            AppMethodBeat.o(28484);
            return;
            if (i != 4) {
              continue;
            }
            this.zgj = true;
            this.zgk = true;
            continue;
            paramBundle = paramBundle;
            ae.e("MicroMsg.ShakeReportUI", "[shakezb]parse dymanic setting json fail!!");
            this.zgj = false;
            this.zgk = false;
            continue;
            this.zgm = 1;
            continue;
            com.tencent.mm.plugin.report.service.g.yxI.f(13139, new Object[] { localObject1, localObject2, Integer.valueOf(0), Integer.valueOf(this.zgm), Integer.valueOf(i), Integer.valueOf(j) });
            continue;
            if (paramBundle == null) {
              continue;
            }
            paramBundle.getState();
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            ae.e("MicroMsg.ShakeReportUI", "[kevinkma]parst shakeItem error!");
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
          this.zgj = true;
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
        this.zgj = true;
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
            this.zgk = true;
            this.zgj = true;
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
        this.zgk = true;
        this.zgj = true;
        break label1585;
        if (i == 3)
        {
          this.zgj = true;
          this.zgk = false;
          label493:
          if (bc.ajM())
          {
            bc.aCg();
            if (((Integer)com.tencent.mm.model.c.ajA().get(am.a.IOi, Integer.valueOf(0))).intValue() == 1) {
              this.zgl = true;
            }
          }
          paramBundle = BluetoothAdapter.getDefaultAdapter();
          boolean bool = ak.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
          if ((paramBundle == null) || (!bool) || (Build.VERSION.SDK_INT < 18) || (paramBundle.getState() != 12)) {
            break label1450;
          }
          this.zgm = 0;
          if ((paramBundle == null) || (paramBundle.getState() != 12)) {
            break label1554;
          }
          i = 1;
          if (!bool) {
            break label1549;
          }
          j = 1;
          if (!this.zgj) {
            break label1458;
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(13139, new Object[] { localObject1, localObject2, Integer.valueOf(1), Integer.valueOf(this.zgm), Integer.valueOf(i), Integer.valueOf(j) });
          if ((this.zgl) || (this.zgj))
          {
            this.zgi = true;
            this.zgd = findViewById(2131304714);
            if (this.zgk)
            {
              if ((paramBundle != null) && (paramBundle.getState() == 12)) {
                break label1516;
              }
              this.zgi = false;
            }
          }
          paramBundle = com.tencent.mm.plugin.shake.b.m.dSq();
          if (paramBundle.oCX == null) {
            paramBundle.oCX = new ArrayList();
          }
          paramBundle.oCX.add(new WeakReference(this));
          paramBundle = Boolean.FALSE;
          long l3 = bu.aRi();
          long l2 = 0L;
          long l1 = 0L;
          if (bc.ajM())
          {
            bc.aCg();
            com.tencent.mm.model.c.ajA().set(am.a.IOf, Boolean.TRUE);
            bc.aCg();
            bool = bu.a((Boolean)com.tencent.mm.model.c.ajA().get(am.a.IOd, null), false);
            bc.aCg();
            l2 = bu.a((Long)com.tencent.mm.model.c.ajA().get(am.a.IOe, null), 0L);
            bc.aCg();
            l1 = bu.a((Long)com.tencent.mm.model.c.ajA().get(am.a.INY, null), 0L);
            paramBundle = Boolean.valueOf(bool);
          }
          if ((!paramBundle.booleanValue()) || (l3 - l2 >= l1)) {
            break label1542;
          }
          this.zfS = 5;
          this.zgi = true;
          this.zfg = true;
          initView();
          dSZ();
          bc.aCg();
          paramBundle = bu.bI((String)com.tencent.mm.model.c.ajA().get(am.a.IOc, null), "");
          bc.aCg();
          localObject1 = bu.bI((String)com.tencent.mm.model.c.ajA().get(am.a.IOb, null), "");
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
    if ((this.zfH != null) && (!this.zfH.isRecycled())) {
      this.zfH.recycle();
    }
    if ((this.zfI != null) && (this.zfI.isShowing()))
    {
      this.zfI.dismiss();
      this.zfI = null;
    }
    if (this.zfm.zce != null) {
      this.zfm.zce.dRP();
    }
    if (this.shakeSensor != null)
    {
      this.shakeSensor.cdt();
      this.shakeSensor = null;
    }
    Object localObject = j.a(null);
    if (j.iys)
    {
      j.iys = false;
      if (!((j)localObject).zef.dSM()) {
        ae.e("Micromsg.ShakeMusicMgr", "release MusicFingerPrintRecorder error");
      }
    }
    j.zeg = null;
    u.c(this);
    com.tencent.mm.sdk.b.a.IvT.d(this.zgp);
    com.tencent.mm.sdk.b.a.IvT.d(this.zgq);
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IOf, Boolean.FALSE);
    dSV();
    if (com.tencent.mm.plugin.shake.c.c.a.dSK()) {
      com.tencent.mm.y.c.ahI().x(262154, false);
    }
    dTd();
    localObject = com.tencent.mm.plugin.shake.b.m.dSq();
    int i;
    if (((com.tencent.mm.plugin.shake.c.a.f)localObject).oCX != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < ((com.tencent.mm.plugin.shake.c.a.f)localObject).oCX.size())
      {
        WeakReference localWeakReference = (WeakReference)((com.tencent.mm.plugin.shake.c.a.f)localObject).oCX.get(i);
        if (localWeakReference != null)
        {
          f.a locala = (f.a)localWeakReference.get();
          if ((locala != null) && (locala.equals(this))) {
            ((com.tencent.mm.plugin.shake.c.a.f)localObject).oCX.remove(localWeakReference);
          }
        }
      }
      else
      {
        localObject = com.tencent.mm.plugin.shake.b.m.dSr();
        ((com.tencent.mm.plugin.shake.c.a.d)localObject).fHj = -85.0F;
        ((com.tencent.mm.plugin.shake.c.a.d)localObject).fHk = -1000.0F;
        if (this.fHi != null) {
          this.fHi.c(this.fHp);
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
    bc.aCg();
    com.tencent.mm.model.c.b(this);
    bc.aCg();
    com.tencent.mm.model.c.ajA().b(this);
    com.tencent.mm.plugin.shake.b.m.dSl().remove(this);
    if (this.zfm.zce != null) {
      this.zfm.zce.pause();
    }
    this.zfi = false;
    if (this.shakeSensor != null) {
      this.shakeSensor.cdt();
    }
    this.zfl.dSR();
    if (this.zfS != 5)
    {
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(327696, this.zfS);
    }
    if (this.zfS == 4) {
      rb(false);
    }
    dSV();
    super.onPause();
    AppMethodBeat.o(28487);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(28527);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ae.i("MicroMsg.ShakeReportUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(28527);
      return;
    }
    ae.i("MicroMsg.ShakeReportUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$27", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
          dGE();
          AppMethodBeat.o(28527);
          return;
        }
        this.jit = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28470);
            paramAnonymousDialogInterface = ShakeReportUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$29", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
    if (this.jit) {
      if (com.tencent.mm.aw.b.Gw((String)com.tencent.mm.kernel.g.ajR().ajA().get(274436, null)))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.ACCESS_COARSE_LOCATION"))
        {
          if (!((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYR, Boolean.FALSE)).booleanValue())
          {
            com.tencent.mm.plugin.account.a.b.a.b(this, getString(2131760740, new Object[] { ad.fom() }), 30764, true);
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
        ae.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkposition[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this });
        if (!bool)
        {
          AppMethodBeat.o(28485);
          return;
        }
      }
    }
    dGE();
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
    private final long[] iSV;
    private long lastShakeTime;
    private Vibrator nQa;
    WeakReference<ShakeReportUI> zgz;
    
    public a(ShakeReportUI paramShakeReportUI)
    {
      AppMethodBeat.i(28481);
      this.lastShakeTime = bu.HQ();
      this.iSV = new long[] { 300L, 200L, 300L, 200L };
      this.zgz = new WeakReference(paramShakeReportUI);
      AppMethodBeat.o(28481);
    }
    
    public final void onRelease() {}
    
    public final void onShake(boolean paramBoolean)
    {
      AppMethodBeat.i(28482);
      ShakeReportUI localShakeReportUI = (ShakeReportUI)this.zgz.get();
      if (localShakeReportUI == null)
      {
        AppMethodBeat.o(28482);
        return;
      }
      if (localShakeReportUI.isFinishing())
      {
        ae.e("MicroMsg.ShakeReportUI", "ui finished");
        AppMethodBeat.o(28482);
        return;
      }
      if (!ShakeReportUI.v(localShakeReportUI))
      {
        ae.i("MicroMsg.ShakeReportUI", "tryShake the status is can's shake");
        AppMethodBeat.o(28482);
        return;
      }
      ShakeReportUI.w(localShakeReportUI);
      long l = bu.aO(this.lastShakeTime);
      if (l < 1200L)
      {
        ae.i("MicroMsg.ShakeReportUI", "tryStartShake delay too short:".concat(String.valueOf(l)));
        AppMethodBeat.o(28482);
        return;
      }
      ae.w("MicroMsg.ShakeReportUI", "tryStartShake delaytoo enough:".concat(String.valueOf(l)));
      this.lastShakeTime = bu.HQ();
      Object localObject;
      if (ShakeReportUI.x(localShakeReportUI) != null)
      {
        localObject = ShakeReportUI.x(localShakeReportUI);
        if (((c)localObject).view != null) {
          ((c)localObject).view.setKeepScreenOn(true);
        }
        ((c)localObject).cYd.ay(30000L, 30000L);
      }
      if (ShakeReportUI.y(localShakeReportUI) != null)
      {
        localObject = ShakeReportUI.y(localShakeReportUI);
        if (((com.tencent.mm.pluginsdk.ui.g)localObject).Flg != null) {
          ((com.tencent.mm.pluginsdk.ui.g)localObject).Flg.dismiss();
        }
      }
      if (ShakeReportUI.z(localShakeReportUI))
      {
        localObject = (ShakeReportUI)this.zgz.get();
        if (localObject != null) {
          be.aI((Context)localObject, 2131763618);
        }
      }
      for (;;)
      {
        reset();
        ShakeReportUI.A(localShakeReportUI);
        AppMethodBeat.o(28482);
        return;
        localObject = (ShakeReportUI)this.zgz.get();
        if (localObject != null)
        {
          if (this.nQa == null) {
            this.nQa = ((Vibrator)((ShakeReportUI)localObject).getSystemService("vibrator"));
          }
          if (this.nQa != null) {
            this.nQa.vibrate(this.iSV, -1);
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