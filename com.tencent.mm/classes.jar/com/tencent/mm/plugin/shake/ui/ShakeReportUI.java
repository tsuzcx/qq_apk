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
import com.tencent.mm.g.a.ed;
import com.tencent.mm.g.a.ee;
import com.tencent.mm.g.a.ek;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.c;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.c.a.f.a;
import com.tencent.mm.plugin.shake.d.a.h.a;
import com.tencent.mm.plugin.shake.d.a.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.ce;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.o;
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
  implements com.tencent.mm.model.aw, u.a, l.a, f.a, k.a, n.b
{
  private static List<h.a> fFj;
  private com.tencent.mm.modelgeo.d fFe;
  private boolean fFh;
  private Map<String, h.a> fFi;
  private b.a fFl;
  private ImageView fRd;
  private com.tencent.mm.aw.a.a icC;
  private boolean jfA;
  private com.tencent.mm.pluginsdk.l.d shakeSensor;
  private boolean vgd;
  private boolean yOT;
  private boolean yOU;
  private boolean yOV;
  private boolean yOW;
  private boolean yOX;
  private boolean yOY;
  private boolean yOZ;
  private com.tencent.mm.plugin.shake.b.d yPA;
  private ImageView yPB;
  private ImageView yPC;
  private ImageView yPD;
  private ImageView yPE;
  private ImageView yPF;
  private ImageView yPG;
  private TextView yPH;
  private int yPI;
  private int yPJ;
  private View yPK;
  private ImageView yPL;
  private ImageView yPM;
  private ImageView yPN;
  private ImageView yPO;
  private View yPP;
  private View yPQ;
  private View yPR;
  private View yPS;
  private View yPT;
  private int yPU;
  private com.tencent.mm.plugin.shake.c.b.a yPV;
  private boolean yPW;
  @SuppressLint({"UseSparseArrays"})
  private Map<Integer, Boolean> yPX;
  private boolean yPY;
  private boolean yPZ;
  private int yPa;
  private c yPb;
  private com.tencent.mm.plugin.shake.b.l yPc;
  private com.tencent.mm.pluginsdk.ui.g yPd;
  private View yPe;
  private View yPf;
  private TextView yPg;
  private TextView yPh;
  private TextView yPi;
  private View yPj;
  private View yPk;
  private View yPl;
  private View yPm;
  private Animation yPn;
  private Animation yPo;
  private Animation yPp;
  private Animation yPq;
  private View yPr;
  private View yPs;
  private MMImageView yPt;
  private TextView yPu;
  private ImageView yPv;
  private String yPw;
  private Bitmap yPx;
  private Dialog yPy;
  private ImageView yPz;
  private boolean yQa;
  private boolean yQb;
  private int yQc;
  private long yQd;
  private boolean yQe;
  private com.tencent.mm.sdk.b.c yQf;
  private com.tencent.mm.sdk.b.c yQg;
  private View.OnClickListener yQh;
  
  static
  {
    AppMethodBeat.i(28541);
    fFj = new CopyOnWriteArrayList();
    AppMethodBeat.o(28541);
  }
  
  public ShakeReportUI()
  {
    AppMethodBeat.i(28483);
    this.yOT = false;
    this.yOU = false;
    this.yOW = false;
    this.yOX = false;
    this.yOY = false;
    this.yOZ = false;
    this.yPa = 22;
    this.yPc = new com.tencent.mm.plugin.shake.b.l();
    this.yPr = null;
    this.yPs = null;
    this.yPt = null;
    this.yPu = null;
    this.yPv = null;
    this.yPw = "";
    this.yPx = null;
    this.yPz = null;
    this.icC = null;
    this.yPA = null;
    this.yPI = 1;
    this.yPJ = 0;
    this.yPT = null;
    this.yPU = 0;
    this.yPW = false;
    this.yPX = new HashMap();
    this.yPY = false;
    this.yPZ = false;
    this.yQa = false;
    this.yQb = false;
    this.yQc = 1;
    this.jfA = true;
    this.fFh = false;
    this.fFl = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(28446);
        if (paramAnonymousBoolean)
        {
          ad.d("MicroMsg.ShakeReportUI", "on location get ok");
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(al.a.Irn, String.valueOf(paramAnonymousFloat2));
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(al.a.Iro, String.valueOf(paramAnonymousFloat1));
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(al.a.ItT, String.valueOf(paramAnonymousDouble2));
          ShakeReportUI.a(ShakeReportUI.this);
          if (ShakeReportUI.b(ShakeReportUI.this) != null) {
            ShakeReportUI.b(ShakeReportUI.this).c(ShakeReportUI.c(ShakeReportUI.this));
          }
        }
        for (;;)
        {
          AppMethodBeat.o(28446);
          return false;
          if ((!ShakeReportUI.d(ShakeReportUI.this)) && (!com.tencent.mm.modelgeo.d.aHR()))
          {
            ShakeReportUI.e(ShakeReportUI.this);
            com.tencent.mm.ui.base.h.a(ShakeReportUI.this, ShakeReportUI.this.getString(2131760082), ShakeReportUI.this.getString(2131755906), ShakeReportUI.this.getString(2131760598), ShakeReportUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(28445);
                com.tencent.mm.modelgeo.d.cB(ShakeReportUI.this);
                AppMethodBeat.o(28445);
              }
            }, null);
          }
          ad.w("MicroMsg.ShakeReportUI", "getLocation fail");
        }
      }
    };
    this.fFi = new ConcurrentHashMap();
    this.yQd = 0L;
    this.yQe = false;
    this.yQf = new com.tencent.mm.sdk.b.c() {};
    this.yQg = new com.tencent.mm.sdk.b.c() {};
    this.yQh = new View.OnClickListener()
    {
      public long yOy = 0L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28467);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)ShakeReportUI.r(ShakeReportUI.this).getTag()))
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
          if (System.currentTimeMillis() - this.yOy > 3000L)
          {
            this.yOy = System.currentTimeMillis();
            if ((paramAnonymousView.field_reserved3 == null) || (paramAnonymousView.field_reserved3.split(",").length != 3) || (paramAnonymousView.field_reserved3.split(",")[0] == null) || (paramAnonymousView.field_reserved3.split(",")[0].equals(""))) {
              break label324;
            }
            localObject1 = paramAnonymousView.field_reserved3.split(",");
            localObject2 = new vm();
            ((vm)localObject2).dJF.userName = localObject1[0];
            ((vm)localObject2).dJF.dJH = com.tencent.mm.sdk.platformtools.bt.bI(localObject1[1], "");
            ((vm)localObject2).dJF.dJI = com.tencent.mm.sdk.platformtools.bt.getInt(localObject1[2], 0);
            ((vm)localObject2).dJF.scene = 1077;
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
          }
          for (;;)
          {
            localObject1 = ShakeReportUI.E(ShakeReportUI.this).yLU;
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
            com.tencent.mm.bs.d.b(aj.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          }
        }
        ba.aBQ();
        Object localObject2 = com.tencent.mm.model.c.azp().Bf((String)localObject1);
        if (com.tencent.mm.o.b.lM(((com.tencent.mm.g.c.aw)localObject2).field_type))
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", (String)localObject1);
          paramAnonymousView.putExtra("Sns_from_Scene", 22);
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            if (((am)localObject2).fqg())
            {
              com.tencent.mm.plugin.report.service.g.yhR.kvStat(10298, (String)localObject1 + "," + ShakeReportUI.O(ShakeReportUI.this));
              paramAnonymousView.putExtra("Contact_Scene", ShakeReportUI.O(ShakeReportUI.this));
            }
            com.tencent.mm.plugin.shake.a.iRG.c(paramAnonymousView, ShakeReportUI.this);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28467);
          return;
          if ((paramAnonymousView.field_reserved1 & 0x8) > 0) {
            com.tencent.mm.plugin.report.service.g.yhR.kvStat(10298, paramAnonymousView.field_username + "," + ShakeReportUI.O(ShakeReportUI.this));
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
          com.tencent.mm.plugin.shake.a.iRG.c((Intent)localObject1, ShakeReportUI.this);
        }
      }
    };
    AppMethodBeat.o(28483);
  }
  
  private void Pt(int paramInt)
  {
    AppMethodBeat.i(28503);
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      qZ(bool);
      if (paramInt != 2) {
        break;
      }
      qY(true);
      AppMethodBeat.o(28503);
      return;
    }
    qY(false);
    AppMethodBeat.o(28503);
  }
  
  private void a(com.tencent.mm.plugin.shake.c.a.e parame)
  {
    AppMethodBeat.i(28508);
    this.yPV = com.tencent.mm.plugin.shake.c.b.a.a(this, parame, new DialogInterface.OnCancelListener()new com.tencent.mm.plugin.shake.c.b.a.b
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
      public final void dur()
      {
        AppMethodBeat.i(28466);
        ShakeReportUI.b(ShakeReportUI.this, true);
        ShakeReportUI.M(ShakeReportUI.this).setText("");
        AppMethodBeat.o(28466);
      }
    });
    AppMethodBeat.o(28508);
  }
  
  private void axt(String paramString)
  {
    AppMethodBeat.i(28505);
    this.yOW = false;
    if (this.yOV) {
      bd.aI(getContext(), 2131763595);
    }
    if (this.yPq == null) {
      this.yPq = AnimationUtils.loadAnimation(getContext(), 2130772040);
    }
    Pt(2);
    if ((paramString != null) && (paramString.length() > 1)) {
      this.yPh.setText(paramString);
    }
    for (;;)
    {
      this.yPh.startAnimation(this.yPq);
      this.yOZ = true;
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28463);
          ShakeReportUI.K(ShakeReportUI.this);
          ShakeReportUI.d(ShakeReportUI.this, false);
          AppMethodBeat.o(28463);
        }
      }, this.yPq.getDuration());
      AppMethodBeat.o(28505);
      return;
      this.yPh.setText(2131763561);
    }
  }
  
  private void bG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(28519);
    this.yOW = false;
    if (this.yPq == null) {
      this.yPq = AnimationUtils.loadAnimation(getContext(), 2130772040);
    }
    Pt(2);
    qY(true);
    if ((paramString != null) && (paramString.length() > 1)) {
      this.yPh.setText(paramString);
    }
    for (;;)
    {
      this.yOZ = true;
      AppMethodBeat.o(28519);
      return;
      if (paramBoolean)
      {
        this.yPh.setText(2131763551);
      }
      else
      {
        this.yPh.setText("");
        qY(false);
      }
    }
  }
  
  private void c(com.tencent.mm.plugin.shake.b.d paramd)
  {
    AppMethodBeat.i(28513);
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramd.field_username))
    {
      AppMethodBeat.o(28513);
      return;
    }
    this.yPe.setTag(paramd.field_username);
    this.yPe.setVisibility(0);
    ba.aBQ();
    am localam = com.tencent.mm.model.c.azp().Bf(paramd.field_username);
    Object localObject2 = new StringBuilder().append(paramd.field_nickname);
    Object localObject1;
    label156:
    label212:
    label363:
    int i;
    if (com.tencent.mm.o.b.lM(localam.field_type))
    {
      localObject1 = getString(2131763588);
      localObject2 = (String)localObject1;
      if (paramd.field_sex != 1) {
        break label500;
      }
      this.yPe.setContentDescription((String)localObject2 + paramd.field_distance + getContext().getString(2131763617));
      TextView localTextView = (TextView)this.yPe.findViewById(2131304689);
      AppCompatActivity localAppCompatActivity = getContext();
      StringBuilder localStringBuilder = new StringBuilder().append(paramd.field_nickname);
      if (!com.tencent.mm.o.b.lM(localam.field_type)) {
        break label585;
      }
      localObject1 = getString(2131763588);
      localTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localAppCompatActivity, (String)localObject1, localTextView.getTextSize()));
      if (this.fRd != null)
      {
        if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject2)) {
          break label591;
        }
        this.fRd.setContentDescription(String.format(getString(2131763543), new Object[] { localObject2 }));
      }
      label277:
      ((TextView)this.yPe.findViewById(2131304687)).setText(paramd.field_distance);
      com.tencent.mm.pluginsdk.ui.a.b.c((ImageView)this.yPe.findViewById(2131304688), paramd.field_username);
      localObject1 = (ImageView)this.yPe.findViewById(2131304691);
      if (paramd.field_reserved1 == 0) {
        break label608;
      }
      ((ImageView)localObject1).setVisibility(0);
      ((ImageView)localObject1).setImageBitmap(BackwardSupportUtil.b.o(as.a.hFQ.or(paramd.field_reserved1), 2.0F));
      if ((paramd.field_reserved1 != 0) || (paramd.field_sex == 0)) {
        break label624;
      }
      if (paramd.field_sex != 1) {
        break label617;
      }
      i = 2131690323;
      label389:
      localObject1 = com.tencent.mm.cc.a.l(this, i);
      this.yPe.findViewById(2131304690).setVisibility(0);
      ((ImageView)this.yPe.findViewById(2131304690)).setImageDrawable((Drawable)localObject1);
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
      this.yPe.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772129));
      AppMethodBeat.o(28513);
      return;
      localObject1 = "";
      break;
      label500:
      if (paramd.field_sex == 2)
      {
        this.yPe.setContentDescription((String)localObject2 + paramd.field_distance + getContext().getString(2131763616));
        break label156;
      }
      this.yPe.setContentDescription((String)localObject2 + paramd.field_distance);
      break label156;
      label585:
      localObject1 = "";
      break label212;
      label591:
      this.fRd.setContentDescription(getString(2131763544));
      break label277;
      label608:
      ((ImageView)localObject1).setVisibility(8);
      break label363;
      label617:
      i = 2131690322;
      break label389;
      label624:
      this.yPe.findViewById(2131304690).setVisibility(8);
    }
  }
  
  private void d(com.tencent.mm.plugin.shake.b.d paramd)
  {
    AppMethodBeat.i(28514);
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramd.field_username))
    {
      AppMethodBeat.o(28514);
      return;
    }
    this.yPe.setTag(paramd.field_username);
    ((TextView)this.yPe.findViewById(2131304689)).setText(paramd.field_username);
    this.yPe.setContentDescription(com.tencent.mm.sdk.platformtools.bt.nullAsNil(paramd.field_nickname));
    ((TextView)this.yPe.findViewById(2131304687)).setText(paramd.field_signature);
    this.icC.loadImage(paramd.getProvince(), (ImageView)this.yPe.findViewById(2131304688));
    this.yPe.findViewById(2131304690).setVisibility(8);
    this.yPe.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772129));
    this.yPe.setVisibility(0);
    AppMethodBeat.o(28514);
  }
  
  private void dDn()
  {
    AppMethodBeat.i(28486);
    dPA();
    ba.aBQ();
    com.tencent.mm.model.c.a(this);
    ba.aBQ();
    com.tencent.mm.model.c.ajl().a(this);
    com.tencent.mm.plugin.shake.b.m.dOO().add(this);
    if (this.yPc.yLU != null) {
      this.yPc.yLU.resume();
    }
    dPB();
    new ap().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28471);
        if (ShakeReportUI.f(ShakeReportUI.this) != null) {
          ShakeReportUI.f(ShakeReportUI.this).fbn();
        }
        AppMethodBeat.o(28471);
      }
    }, 1000L);
    if (this.shakeSensor != null) {
      this.shakeSensor.fbn();
    }
    qY(false);
    qZ(false);
    dPD();
    ba.aBQ();
    Object localObject = (String)com.tencent.mm.model.c.ajl().get(327696, "1");
    if (com.tencent.mm.plugin.shake.d.a.k.dOM())
    {
      if (this.yPI == 4) {
        qU(true);
      }
      if (((String)localObject).equals("4")) {
        eK(findViewById(2131304719));
      }
    }
    boolean bool;
    if (((String)localObject).equals("3"))
    {
      eK(findViewById(2131304716));
      bool = com.tencent.mm.z.c.aht().cJ(262154, 266258);
      if ((!getIntent().getBooleanExtra("shake_music", false)) || (!com.tencent.mm.az.e.aJO()) || (this.yPc.yLT == 3)) {
        break label357;
      }
      getIntent().putExtra("shake_music", false);
      this.yPI = 3;
    }
    for (;;)
    {
      dPC();
      qV(true);
      ad.d("MicroMsg.ShakeReportUI", "isShakeGetConfigList = %s", new Object[] { Boolean.valueOf(com.tencent.mm.platformtools.ac.iOD) });
      if (com.tencent.mm.platformtools.ac.iOD)
      {
        localObject = new com.tencent.mm.bc.l(7);
        ba.aiU().a((com.tencent.mm.al.n)localObject, 0);
      }
      dPM();
      dPJ();
      dPx();
      AppMethodBeat.o(28486);
      return;
      if ((!((String)localObject).equals("6")) || (!com.tencent.mm.plugin.shake.c.c.a.dPn())) {
        break;
      }
      eK(findViewById(2131304706));
      break;
      label357:
      if ((getIntent().getBooleanExtra("shake_tv", false)) && (this.yPc.yLT != 4) && (com.tencent.mm.plugin.shake.d.a.k.dOM()))
      {
        getIntent().putExtra("shake_tv", false);
        this.yPI = 4;
      }
      else if ((this.yPc.yLT != 6) && (com.tencent.mm.plugin.shake.c.c.a.dPn()) && ((bool) || (getIntent().getBooleanExtra("shake_card", false))))
      {
        this.yPU = getIntent().getIntExtra("shake_card", 0);
        getIntent().putExtra("shake_card", false);
        ad.i("MicroMsg.ShakeReportUI", "onresume shake card tab is open, activity type is 0 or open from specialview");
        this.yPI = 6;
      }
    }
  }
  
  private void dPA()
  {
    AppMethodBeat.i(28493);
    ba.aBQ();
    int j = com.tencent.mm.sdk.platformtools.bt.a((Integer)com.tencent.mm.model.c.ajl().get(12290, null), 0);
    ImageView localImageView = (ImageView)findViewById(2131304700);
    if ((this.yPx != null) && (!this.yPx.isRecycled())) {
      this.yPx.recycle();
    }
    ba.aBQ();
    Object localObject1;
    if (com.tencent.mm.sdk.platformtools.bt.n((Boolean)com.tencent.mm.model.c.ajl().get(4110, null)))
    {
      localObject1 = new StringBuilder();
      ba.aBQ();
      localObject1 = com.tencent.mm.model.c.azA() + "default_shake_img_filename.jpg";
      if (com.tencent.mm.vfs.i.fv((String)localObject1))
      {
        this.yPx = u.IT((String)localObject1);
        localImageView.setImageDrawable(new BitmapDrawable(this.yPx));
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
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
              public final void lf(int paramAnonymous2Int)
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
        if (this.yPl == null) {
          this.yPl = findViewById(2131304683);
        }
        this.yPl.setOnClickListener(local7);
        if (this.yPm == null) {
          this.yPm = findViewById(2131304684);
        }
        this.yPm.setOnClickListener(local7);
        AppMethodBeat.o(28493);
        return;
        try
        {
          localObject1 = new BitmapDrawable(com.tencent.mm.sdk.platformtools.g.decodeStream(getContext().getAssets().open("resource/shakehideimg_man.jpg")));
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
      ba.aBQ();
      this.yPx = u.IT((String)com.tencent.mm.model.c.ajl().get(4111, null));
      localImageView.setImageDrawable(new BitmapDrawable(this.yPx));
      break;
      i = 2131233995;
      break label179;
    }
  }
  
  private void dPB()
  {
    AppMethodBeat.i(28494);
    this.yOY = true;
    if ((this.yPV != null) && (this.yPV.isShowing()) && (!this.yPV.yNb)) {
      this.yOY = false;
    }
    ad.i("MicroMsg.ShakeReportUI", "tryStartShake");
    if ((this.shakeSensor != null) && (!this.shakeSensor.fbm()))
    {
      this.shakeSensor.a(new a(this));
      if ((this.shakeSensor.fbo()) && (this.yPg != null))
      {
        this.yPg.setText(getString(2131763534));
        AppMethodBeat.o(28494);
        return;
      }
      this.yPg.setText(getString(2131763596));
    }
    AppMethodBeat.o(28494);
  }
  
  private void dPC()
  {
    AppMethodBeat.i(28496);
    if ((this.yPI == 3) && (com.tencent.mm.az.e.aJO()))
    {
      this.yPI = 3;
      this.yPi.setText(2131763612);
      this.yPz.setBackgroundResource(2131233978);
      this.yPB.setBackgroundResource(2131233984);
      this.yPC.setBackgroundResource(2131233983);
      this.yPD.setBackgroundResource(2131233987);
      this.yPE.setBackgroundResource(2131233974);
      findViewById(2131304701).setVisibility(0);
      setMMTitle(2131763608);
      com.tencent.mm.plugin.report.service.g.yhR.f(11720, new Object[] { Integer.valueOf(2) });
      com.tencent.mm.plugin.report.service.g.yhR.n(834L, 2L, 1L);
    }
    for (;;)
    {
      l.b localb = this.yPc.a(this, this.yPI, this);
      if (!this.yOW) {
        qZ(false);
      }
      if ((com.tencent.mm.plugin.shake.c.c.a.dPn()) && ((localb instanceof com.tencent.mm.plugin.shake.c.a.g)))
      {
        ((com.tencent.mm.plugin.shake.c.a.g)localb).setFromScene(this.yPU);
        if (this.yPU == 3)
        {
          ad.i("MicroMsg.ShakeReportUI", "open shake card from specialview");
          ((com.tencent.mm.plugin.shake.c.a.g)localb).aao(getIntent().getStringExtra("key_shake_card_ext_info"));
        }
      }
      AppMethodBeat.o(28496);
      return;
      if ((this.yPI == 4) && (com.tencent.mm.plugin.shake.d.a.k.dOM()))
      {
        this.yPI = 4;
        this.yPi.setText(2131763613);
        this.yPz.setBackgroundResource(2131233978);
        this.yPB.setBackgroundResource(2131233984);
        this.yPC.setBackgroundResource(2131233981);
        this.yPD.setBackgroundResource(2131233989);
        this.yPE.setBackgroundResource(2131233974);
        findViewById(2131304701).setVisibility(0);
        setMMTitle(2131763609);
        com.tencent.mm.plugin.report.service.g.yhR.f(11720, new Object[] { Integer.valueOf(3) });
        com.tencent.mm.plugin.report.service.g.yhR.n(834L, 3L, 1L);
      }
      else if ((this.yPI == 5) && (dPK()))
      {
        this.yPI = 5;
        this.yPi.setText(2131763611);
        this.yPz.setBackgroundResource(2131233980);
        this.yPB.setBackgroundResource(2131233984);
        this.yPC.setBackgroundResource(2131233981);
        this.yPD.setBackgroundResource(2131233987);
        this.yPE.setBackgroundResource(2131233974);
        findViewById(2131304701).setVisibility(0);
        setMMTitle(2131763607);
        com.tencent.mm.plugin.report.service.g.yhR.f(11720, new Object[] { Integer.valueOf(4) });
        com.tencent.mm.plugin.report.service.g.yhR.n(834L, 4L, 1L);
      }
      else if ((this.yPI == 6) && (com.tencent.mm.plugin.shake.c.c.a.dPn()))
      {
        this.yPI = 6;
        this.yPi.setText(2131763610);
        this.yPz.setBackgroundResource(2131233978);
        this.yPB.setBackgroundResource(2131233984);
        this.yPC.setBackgroundResource(2131233981);
        this.yPD.setBackgroundResource(2131233987);
        this.yPE.setBackgroundResource(2131233975);
        findViewById(2131304701).setVisibility(0);
        setMMTitle(2131763606);
        dPF();
        dPI();
        com.tencent.mm.plugin.report.service.g.yhR.f(11720, new Object[] { Integer.valueOf(5) });
        com.tencent.mm.plugin.report.service.g.yhR.n(834L, 5L, 1L);
      }
      else
      {
        this.yPI = 1;
        this.yPi.setText(2131763554);
        this.yPz.setBackgroundResource(2131233978);
        this.yPB.setBackgroundResource(2131233986);
        this.yPC.setBackgroundResource(2131233981);
        this.yPD.setBackgroundResource(2131233987);
        this.yPE.setBackgroundResource(2131233974);
        if (com.tencent.mm.az.e.aJO()) {
          findViewById(2131304701).setVisibility(0);
        }
        setMMTitle(2131763605);
        com.tencent.mm.plugin.report.service.g.yhR.f(11720, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.g.yhR.n(834L, 1L, 1L);
      }
    }
  }
  
  private void dPD()
  {
    AppMethodBeat.i(28497);
    ba.aBQ();
    this.yOV = com.tencent.mm.sdk.platformtools.bt.n((Boolean)com.tencent.mm.model.c.ajl().get(4112, null));
    if (this.yOV)
    {
      setTitleMuteIconVisibility(8);
      AppMethodBeat.o(28497);
      return;
    }
    setTitleMuteIconVisibility(0);
    AppMethodBeat.o(28497);
  }
  
  private void dPE()
  {
    AppMethodBeat.i(28517);
    if (com.tencent.mm.plugin.shake.c.c.a.dPn())
    {
      if (com.tencent.mm.z.c.aht().cJ(262155, 266259))
      {
        this.yPG.setVisibility(0);
        AppMethodBeat.o(28517);
        return;
      }
      this.yPG.setVisibility(8);
    }
    AppMethodBeat.o(28517);
  }
  
  private void dPF()
  {
    AppMethodBeat.i(28518);
    if ((this.yPI == 6) && (com.tencent.mm.plugin.shake.c.c.a.dPn()))
    {
      boolean bool1 = com.tencent.mm.z.c.aht().cJ(262154, 266258);
      boolean bool2 = com.tencent.mm.z.c.aht().cJ(262155, 266259);
      if (bool1)
      {
        bG(com.tencent.mm.plugin.shake.c.c.a.dPi(), true);
        AppMethodBeat.o(28518);
        return;
      }
      if (bool2)
      {
        bG(com.tencent.mm.plugin.shake.c.c.a.dPk(), true);
        AppMethodBeat.o(28518);
        return;
      }
      if (!this.yPW)
      {
        if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.dPg()))
        {
          bG(com.tencent.mm.plugin.shake.c.c.a.dPg(), true);
          AppMethodBeat.o(28518);
          return;
        }
        bG(getString(2131763551), true);
      }
    }
    AppMethodBeat.o(28518);
  }
  
  private void dPG()
  {
    AppMethodBeat.i(28520);
    if ((this.yPV != null) && (this.yPV.isShowing())) {
      this.yPV.dismiss();
    }
    this.yPV = null;
    AppMethodBeat.o(28520);
  }
  
  private void dPH()
  {
    int m = 1;
    AppMethodBeat.i(28521);
    boolean bool1 = com.tencent.mm.plugin.shake.c.c.a.dOJ();
    boolean bool2 = com.tencent.mm.z.c.aht().cJ(262154, 266258);
    boolean bool3 = com.tencent.mm.z.c.aht().cJ(262155, 266259);
    if (getIntent().getBooleanExtra("shake_card", false)) {}
    for (int i = getIntent().getIntExtra("shake_card", 0);; i = 0)
    {
      com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
      int j;
      if (bool2)
      {
        j = 1;
        if (!bool1) {
          break label231;
        }
        k = 1;
        label87:
        localg.f(11668, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), com.tencent.mm.plugin.shake.c.c.a.dPj(), Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.dPf()) });
        localg = com.tencent.mm.plugin.report.service.g.yhR;
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
        localg.f(11668, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), com.tencent.mm.plugin.shake.c.c.a.dPj(), Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.dPf()) });
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
  
  private void dPI()
  {
    AppMethodBeat.i(28522);
    if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.dPh())) {
      this.yPH.setText(com.tencent.mm.plugin.shake.c.c.a.dPh());
    }
    AppMethodBeat.o(28522);
  }
  
  private void dPJ()
  {
    AppMethodBeat.i(28523);
    label123:
    Object localObject;
    label167:
    label208:
    int i;
    if (com.tencent.mm.az.e.aJO())
    {
      ad.i("MicroMsg.ShakeReportUI", "is not oversea user, show shake music");
      this.yPX.put(Integer.valueOf(3), Boolean.TRUE);
      findViewById(2131304716).setVisibility(0);
      if (com.tencent.mm.az.e.aJP())
      {
        ba.aBQ();
        if (com.tencent.mm.model.c.ajl().getInt(4118, 0) == 0) {
          this.yPF.setVisibility(0);
        }
      }
      else
      {
        if (!com.tencent.mm.plugin.shake.d.a.k.dOM()) {
          break label309;
        }
        this.yPX.put(Integer.valueOf(4), Boolean.TRUE);
        findViewById(2131304719).setVisibility(0);
        ad.i("MicroMsg.ShakeReportUI", "show shake tv tab");
        if (!com.tencent.mm.plugin.shake.c.c.a.dPn()) {
          break label350;
        }
        this.yPX.put(Integer.valueOf(6), Boolean.TRUE);
        findViewById(2131304706).setVisibility(0);
        ad.i("MicroMsg.ShakeReportUI", "show shake card tab");
        if (!dPK()) {
          break label392;
        }
        this.yPX.put(Integer.valueOf(5), Boolean.TRUE);
        this.yPT.setVisibility(0);
        ad.i("MicroMsg.ShakeReportUI", "[shakezb]show shake ibeacon tab");
        localObject = this.yPX.values().iterator();
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
      this.yPF.setVisibility(8);
      break;
      this.yPX.put(Integer.valueOf(3), Boolean.FALSE);
      findViewById(2131304716).setVisibility(8);
      ad.i("MicroMsg.ShakeReportUI", "is oversea user, hide shake music");
      break;
      this.yPX.put(Integer.valueOf(4), Boolean.FALSE);
      findViewById(2131304719).setVisibility(8);
      ad.i("MicroMsg.ShakeReportUI", "hide shake tv tab");
      break label123;
      label350:
      findViewById(2131304706).setVisibility(8);
      this.yPX.put(Integer.valueOf(6), Boolean.FALSE);
      ad.i("MicroMsg.ShakeReportUI", "hide shake card tab");
      break label167;
      this.yPX.put(Integer.valueOf(5), Boolean.FALSE);
      this.yPT.setVisibility(8);
      ad.i("MicroMsg.ShakeReportUI", "[shakezb]hide shake ibeacon tab");
      break label208;
      this.yPJ = i;
      localObject = (LinearLayout)findViewById(2131304701);
      if (i == 1) {
        ((LinearLayout)localObject).setVisibility(8);
      }
      while ((i > 4) && (this.yQe))
      {
        findViewById(2131304719).setVisibility(8);
        ad.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() > 0.");
        this.yPJ -= 1;
        AppMethodBeat.o(28523);
        return;
        ((LinearLayout)localObject).setVisibility(0);
      }
      if ((i > 4) && (!this.yQe))
      {
        this.yPT.setVisibility(8);
        this.yPY = false;
        this.yPJ -= 1;
        ad.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() <= 0.");
      }
      AppMethodBeat.o(28523);
      return;
    }
  }
  
  private boolean dPK()
  {
    AppMethodBeat.i(28524);
    ad.i("MicroMsg.ShakeReportUI", "[shakezb] isChineseAppLang :" + com.tencent.mm.sdk.platformtools.ac.fko() + " ,getApplicationLanguage[en or zh_CN or zh_HK or zh_TW is avaliable] :" + com.tencent.mm.sdk.platformtools.ac.fks());
    if ((this.yPY) && (dPL()))
    {
      AppMethodBeat.o(28524);
      return true;
    }
    AppMethodBeat.o(28524);
    return false;
  }
  
  private static boolean dPL()
  {
    AppMethodBeat.i(28525);
    if ((com.tencent.mm.sdk.platformtools.ac.fko()) || (com.tencent.mm.sdk.platformtools.ac.fks().equals("en")) || (com.tencent.mm.sdk.platformtools.ac.fks().equals("ja")))
    {
      AppMethodBeat.o(28525);
      return true;
    }
    AppMethodBeat.o(28525);
    return false;
  }
  
  private void dPM()
  {
    AppMethodBeat.i(28526);
    this.yPK.setVisibility(8);
    AppMethodBeat.o(28526);
  }
  
  private void dPx()
  {
    AppMethodBeat.i(28489);
    if (!dPL())
    {
      AppMethodBeat.o(28489);
      return;
    }
    if (BluetoothAdapter.getDefaultAdapter() != null)
    {
      Object localObject = com.tencent.mm.n.g.acB().acr();
      if (localObject != null)
      {
        this.yQd = System.currentTimeMillis();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          ad.i("MicroMsg.ShakeReportUI", "op=true,iBeacon = %s", new Object[] { str });
          ed localed = new ed();
          localed.dpk.dpm = str;
          localed.dpk.dpj = true;
          com.tencent.mm.sdk.b.a.IbL.l(localed);
        }
      }
    }
    AppMethodBeat.o(28489);
  }
  
  private void dPy()
  {
    AppMethodBeat.i(28490);
    ba.aBQ();
    if (!com.tencent.mm.sdk.platformtools.bt.a((Boolean)com.tencent.mm.model.c.ajl().get(al.a.ItI, null), false))
    {
      this.fFi.clear();
      fFj = new CopyOnWriteArrayList();
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      Object localObject = com.tencent.mm.n.g.acB().acr();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          ed localed = new ed();
          ad.i("MicroMsg.ShakeReportUI", "op=false,iBeacon = %s", new Object[] { str });
          localed.dpk.dpm = str;
          localed.dpk.dpj = false;
          com.tencent.mm.sdk.b.a.IbL.l(localed);
        }
      }
    }
    AppMethodBeat.o(28490);
  }
  
  private void dPz()
  {
    AppMethodBeat.i(28492);
    if (com.tencent.mm.az.e.aJP())
    {
      ba.aBQ();
      if (com.tencent.mm.model.c.ajl().getInt(4118, 0) == 0)
      {
        com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(getContext());
        locala.afe(2131755906);
        locala.afi(2131763571);
        locala.afl(2131763570).c(new DialogInterface.OnClickListener()
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
        locala.yR(true);
        locala.e(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(28448);
            ba.aBQ();
            com.tencent.mm.model.c.ajl().setInt(4118, 1);
            ShakeReportUI.t(ShakeReportUI.this).setVisibility(8);
            AppMethodBeat.o(28448);
          }
        });
        this.yPy = locala.fMb();
        this.yPy.show();
      }
    }
    AppMethodBeat.o(28492);
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
    ad.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), com.tencent.mm.sdk.platformtools.bt.flS(), this });
    if (!bool)
    {
      AppMethodBeat.o(28509);
      return;
    }
    bG("", false);
    if (paramView.getId() == 2131304710)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11722, new Object[] { Integer.valueOf(1) });
      if (this.yPI != 1)
      {
        if (this.yPI == 4) {
          qU(false);
        }
        this.yPI = 1;
        dPC();
        qW(false);
        if (this.yPe != null) {
          this.yPe.setVisibility(8);
        }
      }
    }
    do
    {
      for (;;)
      {
        qV(true);
        qZ(false);
        dPM();
        AppMethodBeat.o(28509);
        return;
        if (paramView.getId() == 2131304716)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(11722, new Object[] { Integer.valueOf(2) });
          if ((!this.fFh) && (this.fFe != null)) {
            this.fFe.a(this.fFl, true);
          }
          if ((!com.tencent.mm.s.a.cf(this)) && (!com.tencent.mm.s.a.cd(this)) && (!com.tencent.mm.s.a.ch(this)) && (this.yPI != 3))
          {
            if (this.yPI == 4) {
              qU(false);
            }
            this.yPI = 3;
            dPC();
            qW(false);
            if (this.yPe != null) {
              this.yPe.setVisibility(8);
            }
          }
          dPz();
        }
        else
        {
          if (paramView.getId() != 2131304719) {
            break;
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(11722, new Object[] { Integer.valueOf(3) });
          if ((!this.fFh) && (this.fFe != null)) {
            this.fFe.a(this.fFl, true);
          }
          if ((!com.tencent.mm.s.a.cf(this)) && (!com.tencent.mm.s.a.cd(this)) && (!com.tencent.mm.s.a.ch(this)) && (this.yPI != 4))
          {
            qU(true);
            this.yPI = 4;
            dPC();
            qW(false);
            if (this.yPe != null) {
              this.yPe.setVisibility(8);
            }
          }
        }
      }
      if ((paramView.getId() != 2131304714) && (paramView.getId() != 2131304711)) {
        break;
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(11722, new Object[] { Integer.valueOf(4) });
    } while (this.yPI == 5);
    this.yPI = 5;
    dPC();
    qW(false);
    if (this.yPe != null) {
      this.yPe.setVisibility(8);
    }
    if ((!Build.VERSION.RELEASE.equals("6.0")) && (!Build.VERSION.RELEASE.equals("6.0.0")) && (Build.VERSION.SDK_INT >= 23))
    {
      paramView = (LocationManager)aj.getContext().getSystemService("location");
      if (paramView == null) {
        break label743;
      }
    }
    label743:
    for (bool = paramView.isProviderEnabled("gps");; bool = true)
    {
      if (!bool) {
        axt(getString(2131763565));
      }
      paramView = BluetoothAdapter.getDefaultAdapter();
      if ((paramView != null) && (paramView.getState() != 12))
      {
        axt(getString(2131763564));
        break;
      }
      if (paramView != null) {
        break;
      }
      axt(getString(2131763568));
      break;
      if (paramView.getId() != 2131304706) {
        break;
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(11722, new Object[] { Integer.valueOf(5) });
      if (this.yPI == 6) {
        break;
      }
      if (this.yPI == 4) {
        qU(false);
      }
      this.yPI = 6;
      dPC();
      qW(false);
      if (this.yPe != null) {
        this.yPe.setVisibility(8);
      }
      com.tencent.mm.z.c.aht().x(262155, false);
      this.yPG.setVisibility(8);
      break;
    }
  }
  
  private void qU(boolean paramBoolean)
  {
    AppMethodBeat.i(28495);
    String str = String.format("%1$s-shaketype-%2$d", new Object[] { getClass().getName(), Integer.valueOf(4) });
    ad.d("MicroMsg.ShakeReportUI", "activate change report , class name=" + str + ", isActive=" + paramBoolean);
    y.d(paramBoolean, new Intent().putExtra("classname", str));
    AppMethodBeat.o(28495);
  }
  
  private void qV(boolean paramBoolean)
  {
    AppMethodBeat.i(28498);
    qW(paramBoolean);
    qX(paramBoolean);
    AppMethodBeat.o(28498);
  }
  
  private void qW(boolean paramBoolean)
  {
    AppMethodBeat.i(28499);
    if (this.yPr == null) {
      this.yPr = findViewById(2131300604);
    }
    if ((this.yPc.yLT == 3) || (this.yPc.yLT == 4) || (this.yPc.yLT == 5) || (this.yPc.yLT == 6) || (!paramBoolean))
    {
      this.yPr.setVisibility(8);
      AppMethodBeat.o(28499);
      return;
    }
    int i = com.tencent.mm.bk.d.aMq().bUJ();
    if (i <= 0)
    {
      this.yPr.setVisibility(8);
      AppMethodBeat.o(28499);
      return;
    }
    this.yPr.setVisibility(0);
    ((TextView)this.yPr.findViewById(2131304292)).setText(getResources().getQuantityString(2131623965, i, new Object[] { Integer.valueOf(i) }));
    this.yPr.setOnClickListener(new ShakeReportUI.8(this));
    if (this.yPv == null) {
      this.yPv = ((ImageView)findViewById(2131302192));
    }
    cd localcd = com.tencent.mm.bk.d.aMq().fsK();
    if (localcd != null)
    {
      this.yPw = localcd.field_sayhiuser;
      com.tencent.mm.pluginsdk.ui.a.b.c(this.yPv, this.yPw);
    }
    AppMethodBeat.o(28499);
  }
  
  private void qX(boolean paramBoolean)
  {
    AppMethodBeat.i(28500);
    if (this.yPs == null) {
      this.yPs = findViewById(2131300605);
    }
    if (!paramBoolean)
    {
      this.yPs.setVisibility(8);
      AppMethodBeat.o(28500);
      return;
    }
    int i = com.tencent.mm.plugin.shake.b.m.dOP().bUJ();
    if (i <= 0)
    {
      this.yPs.setVisibility(8);
      AppMethodBeat.o(28500);
      return;
    }
    if (this.yPu == null) {
      this.yPu = ((TextView)this.yPs.findViewById(2131304692));
    }
    this.yPu.setText(getString(2131763589, new Object[] { Integer.valueOf(i) }));
    this.yPs.setOnClickListener(new ShakeReportUI.9(this));
    if (this.yPt == null) {
      this.yPt = ((MMImageView)findViewById(2131304698));
    }
    Object localObject = com.tencent.mm.plugin.shake.b.m.dOP().dOF();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.shake.b.f)localObject).field_thumburl;
      if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject)) {
        break label255;
      }
      localObject = new com.tencent.mm.plugin.shake.e.b((String)localObject);
      Bitmap localBitmap = u.a((s)localObject);
      this.yPt.setTag(((com.tencent.mm.plugin.shake.e.b)localObject).aQy());
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        break label242;
      }
      this.yPt.setImageBitmap(localBitmap);
    }
    for (;;)
    {
      this.yPs.setVisibility(0);
      AppMethodBeat.o(28500);
      return;
      label242:
      this.yPt.setImageResource(2131689584);
      continue;
      label255:
      this.yPt.setImageResource(2131689584);
    }
  }
  
  private void qY(boolean paramBoolean)
  {
    AppMethodBeat.i(28501);
    if (this.yPh != null)
    {
      if (paramBoolean)
      {
        this.yPh.setVisibility(0);
        AppMethodBeat.o(28501);
        return;
      }
      this.yPh.setVisibility(8);
      this.yPh.cancelLongPress();
    }
    AppMethodBeat.o(28501);
  }
  
  private void qZ(boolean paramBoolean)
  {
    AppMethodBeat.i(28502);
    if (this.yPf != null)
    {
      if (paramBoolean)
      {
        this.yPf.setVisibility(0);
        AppMethodBeat.o(28502);
        return;
      }
      this.yPf.setVisibility(4);
    }
    AppMethodBeat.o(28502);
  }
  
  public final void a(int paramInt, final com.tencent.mm.plugin.shake.c.a.e parame, long paramLong)
  {
    AppMethodBeat.i(28507);
    this.yPW = true;
    if (paramInt == 1251)
    {
      if (parame == null)
      {
        AppMethodBeat.o(28507);
        return;
      }
      ad.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_GetLbsCard");
      com.tencent.mm.plugin.shake.c.c.a.dOI();
      dPJ();
      dPE();
      dPH();
      this.yPU = 4;
      com.tencent.mm.plugin.shake.b.m.dOU().putValue("key_shake_card_item", parame);
      AppMethodBeat.o(28507);
      return;
    }
    Object localObject;
    if (paramInt == 1250)
    {
      if (parame == null)
      {
        this.yPA = null;
        axt(null);
        AppMethodBeat.o(28507);
        return;
      }
      if (((parame == null) || (this.yOW)) && (!this.yOW))
      {
        this.yPA = null;
        axt(null);
        AppMethodBeat.o(28507);
        return;
      }
      this.yOW = false;
      ad.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_ShakeCard");
      if (this.yPc.yLT == 6)
      {
        localObject = this.yPc.yLU;
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
      if (((com.tencent.mm.plugin.shake.c.a.g)localObject).ozA == 3)
      {
        ad.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is  MMBIZ_SHAKE_CARD_ACTION_TYPE_NO_CARD");
        if ((parame != null) && (!TextUtils.isEmpty(parame.yMw)))
        {
          axt(parame.yMw);
          AppMethodBeat.o(28507);
          return;
        }
        axt(getString(2131763550));
        AppMethodBeat.o(28507);
        return;
      }
      ad.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is " + ((com.tencent.mm.plugin.shake.c.a.g)localObject).ozA);
      Pt(3);
      if (parame.ozA == 1) {
        this.yOY = false;
      }
      if ((this.yPV != null) && (this.yPV.isShowing()))
      {
        AppMethodBeat.o(28507);
        return;
      }
      if (parame.yMy)
      {
        localObject = (ViewStub)findViewById(2131306441);
        if (localObject != null) {
          ((ViewStub)localObject).inflate();
        }
        ((ShakeEggAnimFrame)findViewById(2131297976)).aC(this);
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
      axt(getString(2131763550));
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
    dPD();
    if (!this.yOX) {
      qV(true);
    }
    AppMethodBeat.o(28511);
  }
  
  public final void aBH()
  {
    AppMethodBeat.i(28504);
    dPC();
    AppMethodBeat.o(28504);
  }
  
  public final void d(List<com.tencent.mm.plugin.shake.b.d> paramList, long paramLong)
  {
    AppMethodBeat.i(28506);
    dPM();
    if ((paramList == null) || (!this.yOW) || (paramLong == 6L))
    {
      this.yPA = null;
      if (paramLong == 6L)
      {
        axt(getString(2131763569));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 7L)
      {
        axt(getString(2131763567));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 8L)
      {
        axt(getString(2131763565));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 9L)
      {
        axt(getString(2131763564));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 10L)
      {
        axt(getString(2131763568));
        AppMethodBeat.o(28506);
        return;
      }
      axt(null);
      AppMethodBeat.o(28506);
      return;
    }
    this.yOW = false;
    if (paramList.size() > 0) {
      this.yPA = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0));
    }
    int i;
    Object localObject;
    if (this.yPc.yLT == 1)
    {
      if ((paramList.size() > 0) && (((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_type != 0))
      {
        axt(null);
        AppMethodBeat.o(28506);
        return;
      }
      this.yPa = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).scene;
      i = paramList.size();
      if (i == 0)
      {
        axt(null);
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        localObject = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_username;
        String str = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_nickname;
        ad.i("MicroMsg.ShakeReportUI", "1 u:" + (String)localObject + " n:" + str + " d:" + ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_distance);
        if (this.yOV) {
          bd.aI(getContext(), 2131763587);
        }
        Pt(3);
        c((com.tencent.mm.plugin.shake.b.d)paramList.get(0));
        AppMethodBeat.o(28506);
        return;
      }
      if (this.yOV) {
        bd.aI(getContext(), 2131763587);
      }
      Pt(3);
      qW(false);
      paramList = new Intent(this, ShakeItemListUI.class);
      paramList.putExtra("_key_show_type_", -1);
      paramList.putExtra("_key_title_", getString(2131763582));
      paramList = new com.tencent.mm.hellhoundlib.b.a().bc(paramList);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramList.ahp(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramList.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(28506);
      return;
    }
    if (this.yPc.yLT == 3)
    {
      i = paramList.size();
      if (i == 0)
      {
        axt(getString(2131763594));
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        if (this.yOV) {
          bd.aI(getContext(), 2131763587);
        }
        Pt(3);
        if (((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_type == 4)
        {
          paramList = com.tencent.mm.plugin.shake.d.a.i.d(((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_lvbuffer, paramLong);
          com.tencent.mm.az.a.d(paramList);
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_mode", 1);
          ((Intent)localObject).putExtra("key_offset", paramList.ihh);
          ((Intent)localObject).putExtra("music_player_beg_time", paramList.ihz);
          ((Intent)localObject).putExtra("key_scene", 3);
          if (com.tencent.mm.az.e.aJP()) {
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
    if (this.yPc.yLT == 4)
    {
      dPM();
      i = paramList.size();
      if (i == 0)
      {
        axt(getString(2131763638));
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        if (this.yOV) {
          bd.aI(getContext(), 2131763587);
        }
        Pt(3);
        com.tencent.mm.plugin.shake.d.a.k.a((com.tencent.mm.plugin.shake.b.d)paramList.get(0), this);
      }
      AppMethodBeat.o(28506);
      return;
    }
    if (this.yPc.yLT == 5) {
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
          if (this.yOV) {
            bd.aI(getContext(), 2131763587);
          }
          Pt(3);
          d((com.tencent.mm.plugin.shake.b.d)paramList.get(0));
          AppMethodBeat.o(28506);
          return;
        }
        if (this.yOV) {
          bd.aI(getContext(), 2131763587);
        }
        Pt(3);
        qW(false);
        localObject = new Intent(this, ShakeItemListUI.class);
        ((Intent)localObject).putExtra("_key_show_type_", -12);
        ((Intent)localObject).putExtra("_key_title_", getString(2131763580));
        ((Intent)localObject).putExtra("_key_show_from_shake_", true);
        ((Intent)localObject).putExtra("_ibeacon_new_insert_size", paramList.size());
        paramList = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramList.ahp(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramList.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(28506);
        return;
      }
      axt(null);
      AppMethodBeat.o(28506);
      return;
      axt(getString(2131763569));
    }
  }
  
  public final void dOX()
  {
    AppMethodBeat.i(28516);
    com.tencent.mm.plugin.shake.c.c.a.dOI();
    dPE();
    dPF();
    dPI();
    dPJ();
    dPH();
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
    com.tencent.mm.plugin.shake.c.c.a.dOI();
    this.yPX.put(Integer.valueOf(1), Boolean.TRUE);
    this.yPX.put(Integer.valueOf(3), Boolean.FALSE);
    this.yPX.put(Integer.valueOf(4), Boolean.FALSE);
    this.yPX.put(Integer.valueOf(5), Boolean.FALSE);
    this.yPX.put(Integer.valueOf(6), Boolean.FALSE);
    this.icC = new com.tencent.mm.aw.a.a(this);
    this.yPg = ((TextView)findViewById(2131304704));
    this.yPf = findViewById(2131304720);
    this.yPh = ((TextView)findViewById(2131304699));
    this.yPi = ((TextView)findViewById(2131304703));
    this.yPK = findViewById(2131304734);
    this.yPL = ((ImageView)findViewById(2131304722));
    this.yPM = ((ImageView)findViewById(2131304724));
    this.yPN = ((ImageView)findViewById(2131304726));
    this.yPO = ((ImageView)findViewById(2131304728));
    this.yPP = findViewById(2131304723);
    this.yPQ = findViewById(2131304725);
    this.yPR = findViewById(2131304727);
    this.yPS = findViewById(2131304729);
    this.yPe = findViewById(2131304702);
    this.yPe.setOnClickListener(this.yQh);
    this.fRd = ((ImageView)this.yPe.findViewById(2131304688));
    this.fRd.setOnClickListener(new ShakeReportUI.26(this));
    dPA();
    Object localObject = View.inflate(getContext(), 2131495416, null);
    this.yPy = new com.tencent.mm.ui.base.i(getContext(), 2131821723);
    this.yPy.setContentView((View)localObject);
    this.yPy.setOnCancelListener(new ShakeReportUI.4(this));
    ((Button)((View)localObject).findViewById(2131304679)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28451);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeReportUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ShakeReportUI.s(ShakeReportUI.this).cancel();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28451);
      }
    });
    ba.aBQ();
    boolean bool1 = com.tencent.mm.sdk.platformtools.bt.o((Boolean)com.tencent.mm.model.c.ajl().get(4108, null));
    ba.aBQ();
    boolean bool2 = com.tencent.mm.sdk.platformtools.bt.o((Boolean)com.tencent.mm.model.c.ajl().get(4117, null));
    if (!bool1)
    {
      ((View)localObject).setVisibility(0);
      this.yPy.show();
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(4108, Boolean.TRUE);
      setBackBtn(new ShakeReportUI.27(this));
      addIconOptionMenu(0, 2131755135, 2131689511, new ShakeReportUI.28(this));
      localObject = new ShakeReportUI.29(this);
      if ((!this.yQb) && (!this.yPZ)) {
        break label772;
      }
    }
    label772:
    for (this.yPz = ((ImageView)findViewById(2131304713));; this.yPz = ((ImageView)findViewById(2131304712)))
    {
      this.yPB = ((ImageView)findViewById(2131304709));
      this.yPC = ((ImageView)findViewById(2131304715));
      this.yPD = ((ImageView)findViewById(2131304718));
      this.yPE = ((ImageView)findViewById(2131304705));
      this.yPH = ((TextView)findViewById(2131304708));
      this.yPG = ((ImageView)findViewById(2131304707));
      this.yPF = ((ImageView)findViewById(2131304717));
      dPI();
      this.yPT.setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304714).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304710).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304716).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304719).setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131304706).setOnClickListener((View.OnClickListener)localObject);
      com.tencent.mm.sdk.b.a.IbL.c(this.yQf);
      com.tencent.mm.sdk.b.a.IbL.c(this.yQg);
      dPE();
      dPH();
      dPM();
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
    if ((this.yPt != null) && (this.yPt.getTag() != null) && (paramString.equals((String)this.yPt.getTag()))) {
      this.yPt.setImageBitmap(paramBitmap);
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
      ba.aBQ();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.model.c.azA() + "custom_shake_img_filename.jpg");
      com.tencent.mm.plugin.shake.a.iRG.a(localIntent, 2, this, paramIntent);
      AppMethodBeat.o(28510);
      return;
    case 2: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(28510);
        return;
      }
      paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(4110, Boolean.FALSE);
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(4111, paramIntent);
      dPA();
      AppMethodBeat.o(28510);
      return;
    }
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
      {
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IEr, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
        this.jfA = false;
        AppMethodBeat.o(28510);
        return;
      }
      this.jfA = true;
      finish();
      AppMethodBeat.o(28510);
      return;
    }
    this.jfA = true;
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
    this.fFe = com.tencent.mm.modelgeo.d.aHQ();
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Irn, "");
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iro, "");
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.ItT, "");
    this.yPT = findViewById(2131304711);
    paramBundle = com.tencent.mm.model.bt.aCv();
    Object localObject1 = com.tencent.mm.sdk.platformtools.bt.nullAsNil(paramBundle.provinceCode);
    Object localObject2 = com.tencent.mm.sdk.platformtools.bt.nullAsNil(paramBundle.cityCode);
    paramBundle = com.tencent.mm.n.g.acB().ah("IBeacon", "GatedLaunch");
    int i;
    int j;
    if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramBundle))
    {
      this.yPZ = false;
      this.yQa = false;
      if (paramBundle != null) {}
      try
      {
        paramBundle = new JSONObject(paramBundle);
        i = paramBundle.getInt("gatedlaunch");
        ba.ajx();
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
            Object localObject3 = com.tencent.mm.plugin.shake.b.m.dOO();
            ((com.tencent.mm.plugin.shake.b.e)localObject3).dOE();
            ((com.tencent.mm.plugin.shake.b.e)localObject3).a((com.tencent.mm.plugin.shake.b.d)localObject2, true);
            localObject3 = new LinkedList();
            ((List)localObject3).add(localObject2);
            d((List)localObject3, 1L);
            ba.aBQ();
            com.tencent.mm.model.c.ajl().set(al.a.ItE, "");
            paramBundle = paramBundle + "," + localObject1[4] + localObject1[5] + localObject1[6];
            ba.aBQ();
            com.tencent.mm.model.c.ajl().set(al.a.ItF, paramBundle);
            this.yPb = new c(getBodyView());
            this.shakeSensor = new com.tencent.mm.pluginsdk.l.d();
            if (!this.shakeSensor.fbo()) {
              com.tencent.mm.ui.base.h.a(this, 2131763596, 2131755906, new ShakeReportUI.12(this));
            }
            if (com.tencent.mm.plugin.shake.a.iRH != null) {
              com.tencent.mm.plugin.shake.a.iRH.MR();
            }
            u.b(this);
            ad.i("MicroMsg.ShakeReportUI", "%s", new Object[] { getResources().getDisplayMetrics().toString() });
            i = com.tencent.mm.plugin.shake.b.m.dOP().bUJ();
            com.tencent.mm.plugin.report.service.g.yhR.f(11317, new Object[] { Integer.valueOf(i), e.dPO() });
            com.tencent.mm.plugin.report.service.g.yhR.f(11710, new Object[] { Integer.valueOf(1) });
            com.tencent.mm.plugin.report.service.g.yhR.n(834L, 0L, 1L);
            AppMethodBeat.o(28484);
            return;
            if (i != 4) {
              continue;
            }
            this.yPZ = true;
            this.yQa = true;
            continue;
            paramBundle = paramBundle;
            ad.e("MicroMsg.ShakeReportUI", "[shakezb]parse dymanic setting json fail!!");
            this.yPZ = false;
            this.yQa = false;
            continue;
            this.yQc = 1;
            continue;
            com.tencent.mm.plugin.report.service.g.yhR.f(13139, new Object[] { localObject1, localObject2, Integer.valueOf(0), Integer.valueOf(this.yQc), Integer.valueOf(i), Integer.valueOf(j) });
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
          this.yPZ = true;
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
        this.yPZ = true;
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
            this.yQa = true;
            this.yPZ = true;
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
        this.yQa = true;
        this.yPZ = true;
        break label1585;
        if (i == 3)
        {
          this.yPZ = true;
          this.yQa = false;
          label493:
          if (ba.ajx())
          {
            ba.aBQ();
            if (((Integer)com.tencent.mm.model.c.ajl().get(al.a.ItL, Integer.valueOf(0))).intValue() == 1) {
              this.yQb = true;
            }
          }
          paramBundle = BluetoothAdapter.getDefaultAdapter();
          boolean bool = aj.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
          if ((paramBundle == null) || (!bool) || (Build.VERSION.SDK_INT < 18) || (paramBundle.getState() != 12)) {
            break label1450;
          }
          this.yQc = 0;
          if ((paramBundle == null) || (paramBundle.getState() != 12)) {
            break label1554;
          }
          i = 1;
          if (!bool) {
            break label1549;
          }
          j = 1;
          if (!this.yPZ) {
            break label1458;
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(13139, new Object[] { localObject1, localObject2, Integer.valueOf(1), Integer.valueOf(this.yQc), Integer.valueOf(i), Integer.valueOf(j) });
          if ((this.yQb) || (this.yPZ))
          {
            this.yPY = true;
            this.yPT = findViewById(2131304714);
            if (this.yQa)
            {
              if ((paramBundle != null) && (paramBundle.getState() == 12)) {
                break label1516;
              }
              this.yPY = false;
            }
          }
          paramBundle = com.tencent.mm.plugin.shake.b.m.dOT();
          if (paramBundle.owv == null) {
            paramBundle.owv = new ArrayList();
          }
          paramBundle.owv.add(new WeakReference(this));
          paramBundle = Boolean.FALSE;
          long l3 = com.tencent.mm.sdk.platformtools.bt.aQJ();
          long l2 = 0L;
          long l1 = 0L;
          if (ba.ajx())
          {
            ba.aBQ();
            com.tencent.mm.model.c.ajl().set(al.a.ItI, Boolean.TRUE);
            ba.aBQ();
            bool = com.tencent.mm.sdk.platformtools.bt.a((Boolean)com.tencent.mm.model.c.ajl().get(al.a.ItG, null), false);
            ba.aBQ();
            l2 = com.tencent.mm.sdk.platformtools.bt.a((Long)com.tencent.mm.model.c.ajl().get(al.a.ItH, null), 0L);
            ba.aBQ();
            l1 = com.tencent.mm.sdk.platformtools.bt.a((Long)com.tencent.mm.model.c.ajl().get(al.a.ItB, null), 0L);
            paramBundle = Boolean.valueOf(bool);
          }
          if ((!paramBundle.booleanValue()) || (l3 - l2 >= l1)) {
            break label1542;
          }
          this.yPI = 5;
          this.yPY = true;
          this.yOW = true;
          initView();
          dPC();
          ba.aBQ();
          paramBundle = com.tencent.mm.sdk.platformtools.bt.bI((String)com.tencent.mm.model.c.ajl().get(al.a.ItF, null), "");
          ba.aBQ();
          localObject1 = com.tencent.mm.sdk.platformtools.bt.bI((String)com.tencent.mm.model.c.ajl().get(al.a.ItE, null), "");
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
    if ((this.yPx != null) && (!this.yPx.isRecycled())) {
      this.yPx.recycle();
    }
    if ((this.yPy != null) && (this.yPy.isShowing()))
    {
      this.yPy.dismiss();
      this.yPy = null;
    }
    if (this.yPc.yLU != null) {
      this.yPc.yLU.dOs();
    }
    if (this.shakeSensor != null)
    {
      this.shakeSensor.cce();
      this.shakeSensor = null;
    }
    Object localObject = j.a(null);
    if (j.ivz)
    {
      j.ivz = false;
      if (!((j)localObject).yNV.dPp()) {
        ad.e("Micromsg.ShakeMusicMgr", "release MusicFingerPrintRecorder error");
      }
    }
    j.yNW = null;
    u.c(this);
    com.tencent.mm.sdk.b.a.IbL.d(this.yQf);
    com.tencent.mm.sdk.b.a.IbL.d(this.yQg);
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.ItI, Boolean.FALSE);
    dPy();
    if (com.tencent.mm.plugin.shake.c.c.a.dPn()) {
      com.tencent.mm.z.c.aht().x(262154, false);
    }
    dPG();
    localObject = com.tencent.mm.plugin.shake.b.m.dOT();
    int i;
    if (((com.tencent.mm.plugin.shake.c.a.f)localObject).owv != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < ((com.tencent.mm.plugin.shake.c.a.f)localObject).owv.size())
      {
        WeakReference localWeakReference = (WeakReference)((com.tencent.mm.plugin.shake.c.a.f)localObject).owv.get(i);
        if (localWeakReference != null)
        {
          f.a locala = (f.a)localWeakReference.get();
          if ((locala != null) && (locala.equals(this))) {
            ((com.tencent.mm.plugin.shake.c.a.f)localObject).owv.remove(localWeakReference);
          }
        }
      }
      else
      {
        localObject = com.tencent.mm.plugin.shake.b.m.dOU();
        ((com.tencent.mm.plugin.shake.c.a.d)localObject).fFf = -85.0F;
        ((com.tencent.mm.plugin.shake.c.a.d)localObject).fFg = -1000.0F;
        if (this.fFe != null) {
          this.fFe.c(this.fFl);
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
    ba.aBQ();
    com.tencent.mm.model.c.b(this);
    ba.aBQ();
    com.tencent.mm.model.c.ajl().b(this);
    com.tencent.mm.plugin.shake.b.m.dOO().remove(this);
    if (this.yPc.yLU != null) {
      this.yPc.yLU.pause();
    }
    this.yOY = false;
    if (this.shakeSensor != null) {
      this.shakeSensor.cce();
    }
    this.yPb.dPu();
    if (this.yPI != 5)
    {
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(327696, this.yPI);
    }
    if (this.yPI == 4) {
      qU(false);
    }
    dPy();
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
        com.tencent.mm.ui.base.h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131756766), false, new ShakeReportUI.19(this), new ShakeReportUI.20(this));
        AppMethodBeat.o(28527);
        return;
        if (paramArrayOfInt[0] == 0)
        {
          dDn();
          AppMethodBeat.o(28527);
          return;
        }
        this.jfA = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new ShakeReportUI.21(this), new ShakeReportUI.23(this));
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28485);
    super.onResume();
    if (this.jfA) {
      if (com.tencent.mm.ax.b.FU((String)com.tencent.mm.kernel.g.ajC().ajl().get(274436, null)))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.ACCESS_COARSE_LOCATION"))
        {
          if (!((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IEr, Boolean.FALSE)).booleanValue())
          {
            com.tencent.mm.plugin.account.a.b.a.b(this, getString(2131760740, new Object[] { com.tencent.mm.sdk.platformtools.ac.fks() }), 30764, true);
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
        ad.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkposition[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), com.tencent.mm.sdk.platformtools.bt.flS(), this });
        if (!bool)
        {
          AppMethodBeat.o(28485);
          return;
        }
      }
    }
    dDn();
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
    private final long[] iQc;
    private long lastShakeTime;
    private Vibrator nKv;
    WeakReference<ShakeReportUI> yQp;
    
    public a(ShakeReportUI paramShakeReportUI)
    {
      AppMethodBeat.i(28481);
      this.lastShakeTime = com.tencent.mm.sdk.platformtools.bt.HI();
      this.iQc = new long[] { 300L, 200L, 300L, 200L };
      this.yQp = new WeakReference(paramShakeReportUI);
      AppMethodBeat.o(28481);
    }
    
    public final void onRelease() {}
    
    public final void onShake(boolean paramBoolean)
    {
      AppMethodBeat.i(28482);
      ShakeReportUI localShakeReportUI = (ShakeReportUI)this.yQp.get();
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
      long l = com.tencent.mm.sdk.platformtools.bt.aO(this.lastShakeTime);
      if (l < 1200L)
      {
        ad.i("MicroMsg.ShakeReportUI", "tryStartShake delay too short:".concat(String.valueOf(l)));
        AppMethodBeat.o(28482);
        return;
      }
      ad.w("MicroMsg.ShakeReportUI", "tryStartShake delaytoo enough:".concat(String.valueOf(l)));
      this.lastShakeTime = com.tencent.mm.sdk.platformtools.bt.HI();
      Object localObject;
      if (ShakeReportUI.x(localShakeReportUI) != null)
      {
        localObject = ShakeReportUI.x(localShakeReportUI);
        if (((c)localObject).view != null) {
          ((c)localObject).view.setKeepScreenOn(true);
        }
        ((c)localObject).cXg.az(30000L, 30000L);
      }
      if (ShakeReportUI.y(localShakeReportUI) != null)
      {
        localObject = ShakeReportUI.y(localShakeReportUI);
        if (((com.tencent.mm.pluginsdk.ui.g)localObject).ESL != null) {
          ((com.tencent.mm.pluginsdk.ui.g)localObject).ESL.dismiss();
        }
      }
      if (ShakeReportUI.z(localShakeReportUI))
      {
        localObject = (ShakeReportUI)this.yQp.get();
        if (localObject != null) {
          bd.aI((Context)localObject, 2131763618);
        }
      }
      for (;;)
      {
        reset();
        ShakeReportUI.A(localShakeReportUI);
        AppMethodBeat.o(28482);
        return;
        localObject = (ShakeReportUI)this.yQp.get();
        if (localObject != null)
        {
          if (this.nKv == null) {
            this.nKv = ((Vibrator)((ShakeReportUI)localObject).getSystemService("vibrator"));
          }
          if (this.nKv != null) {
            this.nKv.vibrate(this.iQc, -1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI
 * JD-Core Version:    0.7.0.1
 */