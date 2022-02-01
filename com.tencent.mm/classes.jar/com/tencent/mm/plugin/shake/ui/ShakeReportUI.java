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
import android.os.MessageQueue.IdleHandler;
import android.os.Vibrator;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.be.o;
import com.tencent.mm.f.a.ep;
import com.tencent.mm.f.a.ev;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.c.a.e.a;
import com.tencent.mm.plugin.shake.d.a.h.a;
import com.tencent.mm.plugin.shake.d.a.j;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.d.a.k.1;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
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
import com.tencent.mm.storage.cm;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.w;
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
  implements bd, u.a, l.a, e.a, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
{
  private static List<h.a> iQH;
  private boolean JpA;
  private boolean JpB;
  private boolean JpC;
  private boolean JpD;
  private int JpE;
  private c JpF;
  private com.tencent.mm.plugin.shake.b.l JpG;
  private com.tencent.mm.pluginsdk.ui.g JpH;
  private View JpI;
  private View JpJ;
  private TextView JpK;
  private TextView JpL;
  private TextView JpM;
  private View JpN;
  private View JpO;
  private View JpP;
  private View JpQ;
  private Animation JpR;
  private Animation JpS;
  private Animation JpT;
  private Animation JpU;
  private View JpV;
  private View JpW;
  private MMImageView JpX;
  private TextView JpY;
  private ImageView JpZ;
  private boolean Jpx;
  private boolean Jpy;
  private boolean Jpz;
  @SuppressLint({"UseSparseArrays"})
  private Map<Integer, Boolean> JqA;
  private boolean JqB;
  private boolean JqC;
  private boolean JqD;
  private boolean JqE;
  private int JqF;
  private long JqG;
  private boolean JqH;
  private IListener JqI;
  private IListener JqJ;
  private View.OnClickListener JqK;
  private String Jqa;
  private Bitmap Jqb;
  private Dialog Jqc;
  private ImageView Jqd;
  private com.tencent.mm.plugin.shake.b.d Jqe;
  private ImageView Jqf;
  private ImageView Jqg;
  private ImageView Jqh;
  private ImageView Jqi;
  private ImageView Jqj;
  private ImageView Jqk;
  private TextView Jql;
  private int Jqm;
  private int Jqn;
  private View Jqo;
  private ImageView Jqp;
  private ImageView Jqq;
  private ImageView Jqr;
  private ImageView Jqs;
  private View Jqt;
  private View Jqu;
  private View Jqv;
  private View Jqw;
  private int Jqx;
  private com.tencent.mm.plugin.shake.c.b.a Jqy;
  private boolean Jqz;
  private com.tencent.mm.modelgeo.d iQC;
  private boolean iQF;
  private Map<String, h.a> iQG;
  private b.a iQJ;
  private ImageView jiu;
  private com.tencent.mm.ay.a.a lQK;
  private boolean mXU;
  private com.tencent.mm.pluginsdk.m.d shakeSensor;
  private boolean zHI;
  
  static
  {
    AppMethodBeat.i(28541);
    iQH = new CopyOnWriteArrayList();
    AppMethodBeat.o(28541);
  }
  
  public ShakeReportUI()
  {
    AppMethodBeat.i(28483);
    this.Jpx = false;
    this.Jpy = false;
    this.JpA = false;
    this.JpB = false;
    this.JpC = false;
    this.JpD = false;
    this.JpE = 22;
    this.JpG = new com.tencent.mm.plugin.shake.b.l();
    this.JpV = null;
    this.JpW = null;
    this.JpX = null;
    this.JpY = null;
    this.JpZ = null;
    this.Jqa = "";
    this.Jqb = null;
    this.Jqd = null;
    this.lQK = null;
    this.Jqe = null;
    this.Jqm = 1;
    this.Jqn = 0;
    this.Jqx = 0;
    this.Jqz = false;
    this.JqA = new HashMap();
    this.JqB = false;
    this.JqC = false;
    this.JqD = false;
    this.JqE = false;
    this.JqF = 1;
    this.mXU = true;
    this.iQF = false;
    this.iQJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(28446);
        if (paramAnonymousBoolean)
        {
          Log.d("MicroMsg.ShakeReportUI", "on location get ok");
          bh.beI();
          com.tencent.mm.model.c.aHp().set(ar.a.VhL, String.valueOf(paramAnonymousFloat2));
          bh.beI();
          com.tencent.mm.model.c.aHp().set(ar.a.VhM, String.valueOf(paramAnonymousFloat1));
          bh.beI();
          com.tencent.mm.model.c.aHp().set(ar.a.Vks, String.valueOf(paramAnonymousDouble2));
          ShakeReportUI.a(ShakeReportUI.this);
          if (ShakeReportUI.b(ShakeReportUI.this) != null) {
            ShakeReportUI.b(ShakeReportUI.this).b(ShakeReportUI.c(ShakeReportUI.this));
          }
        }
        for (;;)
        {
          AppMethodBeat.o(28446);
          return false;
          if ((!ShakeReportUI.d(ShakeReportUI.this)) && (!com.tencent.mm.modelgeo.d.blr()))
          {
            ShakeReportUI.e(ShakeReportUI.this);
            com.tencent.mm.ui.base.h.a(ShakeReportUI.this, ShakeReportUI.this.getString(R.l.gps_disable_tip), ShakeReportUI.this.getString(R.l.app_tip), ShakeReportUI.this.getString(R.l.jump_to_settings), ShakeReportUI.this.getString(R.l.app_cancel), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(28445);
                com.tencent.mm.modelgeo.d.cW(ShakeReportUI.this);
                AppMethodBeat.o(28445);
              }
            }, null);
          }
          Log.w("MicroMsg.ShakeReportUI", "getLocation fail");
        }
      }
    };
    this.iQG = new ConcurrentHashMap();
    this.JqG = 0L;
    this.JqH = false;
    this.JqI = new IListener() {};
    this.JqJ = new IListener() {};
    this.JqK = new View.OnClickListener()
    {
      public long Jpc = 0L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28467);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeReportUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
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
          if (System.currentTimeMillis() - this.Jpc > 3000L)
          {
            this.Jpc = System.currentTimeMillis();
            if ((paramAnonymousView.field_reserved3 == null) || (paramAnonymousView.field_reserved3.split(",").length != 3) || (paramAnonymousView.field_reserved3.split(",")[0] == null) || (paramAnonymousView.field_reserved3.split(",")[0].equals(""))) {
              break label324;
            }
            localObject1 = paramAnonymousView.field_reserved3.split(",");
            localObject2 = new xw();
            ((xw)localObject2).fWN.userName = localObject1[0];
            ((xw)localObject2).fWN.fWP = Util.nullAs(localObject1[1], "");
            ((xw)localObject2).fWN.fWQ = Util.getInt(localObject1[2], 0);
            ((xw)localObject2).fWN.scene = 1077;
            EventCenter.instance.publish((IEvent)localObject2);
          }
          for (;;)
          {
            localObject1 = ShakeReportUI.E(ShakeReportUI.this).JmC;
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
            com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          }
        }
        bh.beI();
        Object localObject2 = com.tencent.mm.model.c.bbL().RG((String)localObject1);
        if (com.tencent.mm.contact.d.rk(((ax)localObject2).field_type))
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", (String)localObject1);
          paramAnonymousView.putExtra("Sns_from_Scene", 22);
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            if (((as)localObject2).hxX())
            {
              com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, (String)localObject1 + "," + ShakeReportUI.O(ShakeReportUI.this));
              paramAnonymousView.putExtra("Contact_Scene", ShakeReportUI.O(ShakeReportUI.this));
            }
            com.tencent.mm.plugin.shake.a.mIG.c(paramAnonymousView, ShakeReportUI.this);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28467);
          return;
          if ((paramAnonymousView.field_reserved1 & 0x8) > 0) {
            com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, paramAnonymousView.field_username + "," + ShakeReportUI.O(ShakeReportUI.this));
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
          com.tencent.mm.plugin.shake.a.mIG.c((Intent)localObject1, ShakeReportUI.this);
        }
      }
    };
    AppMethodBeat.o(28483);
  }
  
  private void a(com.tencent.mm.plugin.shake.c.a.d paramd)
  {
    AppMethodBeat.i(28508);
    this.Jqy = com.tencent.mm.plugin.shake.c.b.a.a(this, paramd, new DialogInterface.OnCancelListener()new com.tencent.mm.plugin.shake.c.b.a.b
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
      public final void fiS()
      {
        AppMethodBeat.i(28466);
        ShakeReportUI.b(ShakeReportUI.this, true);
        ShakeReportUI.M(ShakeReportUI.this).setText("");
        AppMethodBeat.o(28466);
      }
    });
    AppMethodBeat.o(28508);
  }
  
  private void aYc(String paramString)
  {
    AppMethodBeat.i(28505);
    this.JpA = false;
    if (this.Jpz) {
      PlaySound.play(getContext(), R.l.shake_nomatch);
    }
    if (this.JpU == null) {
      this.JpU = AnimationUtils.loadAnimation(getContext(), R.a.faded_out);
    }
    aeC(2);
    if ((paramString != null) && (paramString.length() > 1)) {
      this.JpL.setText(paramString);
    }
    for (;;)
    {
      this.JpL.startAnimation(this.JpU);
      this.JpD = true;
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28463);
          ShakeReportUI.K(ShakeReportUI.this);
          ShakeReportUI.d(ShakeReportUI.this, false);
          AppMethodBeat.o(28463);
        }
      }, this.JpU.getDuration());
      AppMethodBeat.o(28505);
      return;
      this.JpL.setText(R.l.eSy);
    }
  }
  
  private void aeC(int paramInt)
  {
    AppMethodBeat.i(28503);
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ya(bool);
      if (paramInt != 2) {
        break;
      }
      xZ(true);
      AppMethodBeat.o(28503);
      return;
    }
    xZ(false);
    AppMethodBeat.o(28503);
  }
  
  private void cl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(28519);
    this.JpA = false;
    if (this.JpU == null) {
      this.JpU = AnimationUtils.loadAnimation(getContext(), R.a.faded_out);
    }
    aeC(2);
    xZ(true);
    if ((paramString != null) && (paramString.length() > 1)) {
      this.JpL.setText(paramString);
    }
    for (;;)
    {
      this.JpD = true;
      AppMethodBeat.o(28519);
      return;
      if (paramBoolean)
      {
        this.JpL.setText(R.l.eSu);
      }
      else
      {
        this.JpL.setText("");
        xZ(false);
      }
    }
  }
  
  private void fHW()
  {
    AppMethodBeat.i(28492);
    if (com.tencent.mm.bb.e.bnG())
    {
      bh.beI();
      if (com.tencent.mm.model.c.aHp().getInt(4118, 0) == 0)
      {
        com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(getContext());
        locala.ayc(R.l.app_tip);
        locala.ayg(R.l.eSI);
        locala.ayj(R.l.eSH).c(new DialogInterface.OnClickListener()
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
        locala.HG(true);
        locala.f(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(28448);
            bh.beI();
            com.tencent.mm.model.c.aHp().setInt(4118, 1);
            ShakeReportUI.t(ShakeReportUI.this).setVisibility(8);
            AppMethodBeat.o(28448);
          }
        });
        this.Jqc = locala.icu();
        this.Jqc.show();
      }
    }
    AppMethodBeat.o(28492);
  }
  
  private void fHX()
  {
    AppMethodBeat.i(28493);
    bh.beI();
    int j = Util.nullAs((Integer)com.tencent.mm.model.c.aHp().b(12290, null), 0);
    ImageView localImageView = (ImageView)findViewById(R.h.dUo);
    if ((this.Jqb != null) && (!this.Jqb.isRecycled())) {
      this.Jqb.recycle();
    }
    bh.beI();
    Object localObject1;
    if (Util.nullAsTrue((Boolean)com.tencent.mm.model.c.aHp().b(4110, null)))
    {
      localObject1 = new StringBuilder();
      bh.beI();
      localObject1 = com.tencent.mm.model.c.bbW() + "default_shake_img_filename.jpg";
      if (com.tencent.mm.vfs.u.agG((String)localObject1))
      {
        this.Jqb = com.tencent.mm.platformtools.u.ZS((String)localObject1);
        localImageView.setImageDrawable(new BitmapDrawable(this.Jqb));
        localObject1 = (ImageView)findViewById(R.h.doT);
        localImageView = (ImageView)findViewById(R.h.doQ);
        if (j != 2) {
          break label391;
        }
        i = R.g.doS;
        label179:
        ((ImageView)localObject1).setImageResource(i);
        if (j != 2) {
          break label398;
        }
      }
    }
    label391:
    label398:
    for (int i = R.g.doR;; i = R.g.doQ)
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
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeReportUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
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
            localObject = ShakeReportUI.this.getString(R.l.eSJ);
            h.d local1 = new h.d()
            {
              public final void qy(int paramAnonymous2Int)
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
                  com.tencent.mm.pluginsdk.ui.tools.u.d(ShakeReportUI.this, 1, null);
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
        if (this.JpP == null) {
          this.JpP = findViewById(R.h.dTZ);
        }
        this.JpP.setOnClickListener(local7);
        if (this.JpQ == null) {
          this.JpQ = findViewById(R.h.dUa);
        }
        this.JpQ.setOnClickListener(local7);
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
      bh.beI();
      this.Jqb = com.tencent.mm.platformtools.u.ZS((String)com.tencent.mm.model.c.aHp().b(4111, null));
      localImageView.setImageDrawable(new BitmapDrawable(this.Jqb));
      break;
      i = R.g.doT;
      break label179;
    }
  }
  
  private void fHY()
  {
    AppMethodBeat.i(28494);
    this.JpC = true;
    if ((this.Jqy != null) && (this.Jqy.isShowing()) && (!this.Jqy.JnJ)) {
      this.JpC = false;
    }
    Log.i("MicroMsg.ShakeReportUI", "tryStartShake");
    if ((this.shakeSensor != null) && (!this.shakeSensor.hiU()))
    {
      this.shakeSensor.a(new a(this));
      if ((this.shakeSensor.hiW()) && (this.JpK != null))
      {
        this.JpK.setText(getString(R.l.eSr));
        AppMethodBeat.o(28494);
        return;
      }
      this.JpK.setText(getString(R.l.eSU));
    }
    AppMethodBeat.o(28494);
  }
  
  private void fHZ()
  {
    AppMethodBeat.i(28496);
    if ((this.Jqm == 3) && (com.tencent.mm.bb.e.bnF()))
    {
      this.Jqm = 3;
      this.JpM.setText(R.l.eTb);
      this.Jqd.setBackgroundResource(R.g.doI);
      this.Jqf.setBackgroundResource(R.g.doM);
      this.Jqg.setBackgroundResource(R.g.doL);
      this.Jqh.setBackgroundResource(R.g.doO);
      this.Jqi.setBackgroundResource(R.g.doG);
      findViewById(R.h.dUp).setVisibility(0);
      setMMTitle(R.l.eSX);
      com.tencent.mm.plugin.report.service.h.IzE.a(11720, new Object[] { Integer.valueOf(2) });
      com.tencent.mm.plugin.report.service.h.IzE.p(834L, 2L, 1L);
    }
    for (;;)
    {
      l.b localb = this.JpG.a(this, this.Jqm, this);
      if (!this.JpA) {
        ya(false);
      }
      if ((com.tencent.mm.plugin.shake.c.c.a.fHM()) && ((localb instanceof com.tencent.mm.plugin.shake.c.a.f)))
      {
        ((com.tencent.mm.plugin.shake.c.a.f)localb).setFromScene(this.Jqx);
        if (this.Jqx == 3)
        {
          Log.i("MicroMsg.ShakeReportUI", "open shake card from specialview");
          ((com.tencent.mm.plugin.shake.c.a.f)localb).YS(getIntent().getStringExtra("key_shake_card_ext_info"));
        }
      }
      AppMethodBeat.o(28496);
      return;
      if ((this.Jqm == 4) && (k.fHm()))
      {
        this.Jqm = 4;
        this.JpM.setText(R.l.eTc);
        this.Jqd.setBackgroundResource(R.g.doI);
        this.Jqf.setBackgroundResource(R.g.doM);
        this.Jqg.setBackgroundResource(R.g.doK);
        this.Jqh.setBackgroundResource(R.g.doP);
        this.Jqi.setBackgroundResource(R.g.doG);
        findViewById(R.h.dUp).setVisibility(0);
        setMMTitle(R.l.eSY);
        com.tencent.mm.plugin.report.service.h.IzE.a(11720, new Object[] { Integer.valueOf(3) });
        com.tencent.mm.plugin.report.service.h.IzE.p(834L, 3L, 1L);
      }
      else if ((this.Jqm == 5) && (fIh()))
      {
        this.Jqm = 5;
        this.JpM.setText(R.l.eTa);
        this.Jqd.setBackgroundResource(R.g.doJ);
        this.Jqf.setBackgroundResource(R.g.doM);
        this.Jqg.setBackgroundResource(R.g.doK);
        this.Jqh.setBackgroundResource(R.g.doO);
        this.Jqi.setBackgroundResource(R.g.doG);
        findViewById(R.h.dUp).setVisibility(0);
        setMMTitle(R.l.eSW);
        com.tencent.mm.plugin.report.service.h.IzE.a(11720, new Object[] { Integer.valueOf(4) });
        com.tencent.mm.plugin.report.service.h.IzE.p(834L, 4L, 1L);
      }
      else if ((this.Jqm == 6) && (com.tencent.mm.plugin.shake.c.c.a.fHM()))
      {
        this.Jqm = 6;
        this.JpM.setText(R.l.eSZ);
        this.Jqd.setBackgroundResource(R.g.doI);
        this.Jqf.setBackgroundResource(R.g.doM);
        this.Jqg.setBackgroundResource(R.g.doK);
        this.Jqh.setBackgroundResource(R.g.doO);
        this.Jqi.setBackgroundResource(R.g.doH);
        findViewById(R.h.dUp).setVisibility(0);
        setMMTitle(R.l.eSV);
        fIc();
        fIf();
        com.tencent.mm.plugin.report.service.h.IzE.a(11720, new Object[] { Integer.valueOf(5) });
        com.tencent.mm.plugin.report.service.h.IzE.p(834L, 5L, 1L);
      }
      else
      {
        this.Jqm = 1;
        this.JpM.setText(R.l.eSw);
        this.Jqd.setBackgroundResource(R.g.doI);
        this.Jqf.setBackgroundResource(R.g.doN);
        this.Jqg.setBackgroundResource(R.g.doK);
        this.Jqh.setBackgroundResource(R.g.doO);
        this.Jqi.setBackgroundResource(R.g.doG);
        if (com.tencent.mm.bb.e.bnF()) {
          findViewById(R.h.dUp).setVisibility(0);
        }
        setMMTitle(R.l.shake_report_title);
        com.tencent.mm.plugin.report.service.h.IzE.a(11720, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.h.IzE.p(834L, 1L, 1L);
      }
    }
  }
  
  private void fIa()
  {
    AppMethodBeat.i(28497);
    bh.beI();
    this.Jpz = Util.nullAsTrue((Boolean)com.tencent.mm.model.c.aHp().b(4112, null));
    if (this.Jpz)
    {
      setTitleMuteIconVisibility(8);
      AppMethodBeat.o(28497);
      return;
    }
    setTitleMuteIconVisibility(0);
    AppMethodBeat.o(28497);
  }
  
  private void fIb()
  {
    AppMethodBeat.i(28517);
    if (com.tencent.mm.plugin.shake.c.c.a.fHM())
    {
      if (com.tencent.mm.aa.c.aFn().dk(262155, 266259))
      {
        this.Jqk.setVisibility(0);
        AppMethodBeat.o(28517);
        return;
      }
      this.Jqk.setVisibility(8);
    }
    AppMethodBeat.o(28517);
  }
  
  private void fIc()
  {
    AppMethodBeat.i(28518);
    if ((this.Jqm == 6) && (com.tencent.mm.plugin.shake.c.c.a.fHM()))
    {
      boolean bool1 = com.tencent.mm.aa.c.aFn().dk(262154, 266258);
      boolean bool2 = com.tencent.mm.aa.c.aFn().dk(262155, 266259);
      if (bool1)
      {
        cl(com.tencent.mm.plugin.shake.c.c.a.fHI(), true);
        AppMethodBeat.o(28518);
        return;
      }
      if (bool2)
      {
        cl(com.tencent.mm.plugin.shake.c.c.a.fHK(), true);
        AppMethodBeat.o(28518);
        return;
      }
      if (!this.Jqz)
      {
        if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.fHG()))
        {
          cl(com.tencent.mm.plugin.shake.c.c.a.fHG(), true);
          AppMethodBeat.o(28518);
          return;
        }
        cl(getString(R.l.eSu), true);
      }
    }
    AppMethodBeat.o(28518);
  }
  
  private void fId()
  {
    AppMethodBeat.i(28520);
    if ((this.Jqy != null) && (this.Jqy.isShowing())) {
      this.Jqy.dismiss();
    }
    this.Jqy = null;
    AppMethodBeat.o(28520);
  }
  
  private void fIe()
  {
    int m = 1;
    AppMethodBeat.i(28521);
    boolean bool1 = com.tencent.mm.plugin.shake.c.c.a.fHj();
    boolean bool2 = com.tencent.mm.aa.c.aFn().dk(262154, 266258);
    boolean bool3 = com.tencent.mm.aa.c.aFn().dk(262155, 266259);
    if (getIntent().getBooleanExtra("shake_card", false)) {}
    for (int i = getIntent().getIntExtra("shake_card", 0);; i = 0)
    {
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
      int j;
      if (bool2)
      {
        j = 1;
        if (!bool1) {
          break label231;
        }
        k = 1;
        label87:
        localh.a(11668, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), com.tencent.mm.plugin.shake.c.c.a.fHJ(), Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.fHF()) });
        localh = com.tencent.mm.plugin.report.service.h.IzE;
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
        localh.a(11668, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), com.tencent.mm.plugin.shake.c.c.a.fHJ(), Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.fHF()) });
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
  
  private void fIf()
  {
    AppMethodBeat.i(28522);
    if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.fHH())) {
      this.Jql.setText(com.tencent.mm.plugin.shake.c.c.a.fHH());
    }
    AppMethodBeat.o(28522);
  }
  
  private void fIg()
  {
    AppMethodBeat.i(28523);
    label123:
    Object localObject;
    label167:
    int i;
    if (com.tencent.mm.bb.e.bnF())
    {
      Log.i("MicroMsg.ShakeReportUI", "is not oversea user, show shake music");
      this.JqA.put(Integer.valueOf(3), Boolean.TRUE);
      findViewById(R.h.dUE).setVisibility(0);
      if (com.tencent.mm.bb.e.bnG())
      {
        bh.beI();
        if (com.tencent.mm.model.c.aHp().getInt(4118, 0) == 0) {
          this.Jqj.setVisibility(0);
        }
      }
      else
      {
        if (!k.fHm()) {
          break label268;
        }
        this.JqA.put(Integer.valueOf(4), Boolean.TRUE);
        findViewById(R.h.dUH).setVisibility(0);
        Log.i("MicroMsg.ShakeReportUI", "show shake tv tab");
        if (!com.tencent.mm.plugin.shake.c.c.a.fHM()) {
          break label309;
        }
        this.JqA.put(Integer.valueOf(6), Boolean.TRUE);
        findViewById(R.h.dUu).setVisibility(0);
        Log.i("MicroMsg.ShakeReportUI", "show shake card tab");
        localObject = this.JqA.values().iterator();
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
      this.Jqj.setVisibility(8);
      break;
      this.JqA.put(Integer.valueOf(3), Boolean.FALSE);
      findViewById(R.h.dUE).setVisibility(8);
      Log.i("MicroMsg.ShakeReportUI", "is oversea user, hide shake music");
      break;
      this.JqA.put(Integer.valueOf(4), Boolean.FALSE);
      findViewById(R.h.dUH).setVisibility(8);
      Log.i("MicroMsg.ShakeReportUI", "hide shake tv tab");
      break label123;
      findViewById(R.h.dUu).setVisibility(8);
      this.JqA.put(Integer.valueOf(6), Boolean.FALSE);
      Log.i("MicroMsg.ShakeReportUI", "hide shake card tab");
      break label167;
      label351:
      this.Jqn = i;
      localObject = (LinearLayout)findViewById(R.h.dUp);
      if (i == 1) {
        ((LinearLayout)localObject).setVisibility(8);
      }
      while ((i > 4) && (this.JqH))
      {
        findViewById(R.h.dUH).setVisibility(8);
        Log.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() > 0.");
        this.Jqn -= 1;
        AppMethodBeat.o(28523);
        return;
        ((LinearLayout)localObject).setVisibility(0);
      }
      if ((i > 4) && (!this.JqH))
      {
        this.JqB = false;
        this.Jqn -= 1;
        Log.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() <= 0.");
      }
      AppMethodBeat.o(28523);
      return;
    }
  }
  
  private boolean fIh()
  {
    AppMethodBeat.i(28524);
    Log.i("MicroMsg.ShakeReportUI", "[shakezb] isChineseAppLang :" + LocaleUtil.isChineseAppLang() + " ,getApplicationLanguage[en or zh_CN or zh_HK or zh_TW is avaliable] :" + LocaleUtil.getApplicationLanguage());
    if ((this.JqB) && (fIi()))
    {
      AppMethodBeat.o(28524);
      return true;
    }
    AppMethodBeat.o(28524);
    return false;
  }
  
  private static boolean fIi()
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
  
  private void fIj()
  {
    AppMethodBeat.i(28526);
    this.Jqo.setVisibility(8);
    AppMethodBeat.o(28526);
  }
  
  private void ftw()
  {
    AppMethodBeat.i(28486);
    fHX();
    bh.beI();
    com.tencent.mm.model.c.a(this);
    bh.beI();
    com.tencent.mm.model.c.aHp().add(this);
    com.tencent.mm.plugin.shake.b.m.fHo().add(this);
    if (this.JpG.JmC != null) {
      this.JpG.JmC.resume();
    }
    fHY();
    new MMHandler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28471);
        if (ShakeReportUI.f(ShakeReportUI.this) != null) {
          ShakeReportUI.f(ShakeReportUI.this).hiV();
        }
        AppMethodBeat.o(28471);
      }
    }, 1000L);
    if (this.shakeSensor != null) {
      this.shakeSensor.hiV();
    }
    xZ(false);
    ya(false);
    fIa();
    bh.beI();
    Object localObject = (String)com.tencent.mm.model.c.aHp().b(327696, "1");
    if (k.fHm())
    {
      if (this.Jqm == 4) {
        xV(true);
      }
      if (((String)localObject).equals("4")) {
        gb(findViewById(R.h.dUH));
      }
    }
    boolean bool;
    if (((String)localObject).equals("3"))
    {
      gb(findViewById(R.h.dUE));
      bool = com.tencent.mm.aa.c.aFn().dk(262154, 266258);
      if ((!getIntent().getBooleanExtra("shake_music", false)) || (!com.tencent.mm.bb.e.bnF()) || (this.JpG.JmB == 3)) {
        break label353;
      }
      getIntent().putExtra("shake_music", false);
      this.Jqm = 3;
    }
    for (;;)
    {
      fHZ();
      xW(true);
      Log.d("MicroMsg.ShakeReportUI", "isShakeGetConfigList = %s", new Object[] { Boolean.valueOf(com.tencent.mm.platformtools.ac.mFB) });
      if (com.tencent.mm.platformtools.ac.mFB)
      {
        localObject = new o(7);
        bh.aGY().a((q)localObject, 0);
      }
      fIj();
      fIg();
      AppMethodBeat.o(28486);
      return;
      if ((!((String)localObject).equals("6")) || (!com.tencent.mm.plugin.shake.c.c.a.fHM())) {
        break;
      }
      gb(findViewById(R.h.dUu));
      break;
      label353:
      if ((getIntent().getBooleanExtra("shake_tv", false)) && (this.JpG.JmB != 4) && (k.fHm()))
      {
        getIntent().putExtra("shake_tv", false);
        this.Jqm = 4;
      }
      else if ((this.JpG.JmB != 6) && (com.tencent.mm.plugin.shake.c.c.a.fHM()) && ((bool) || (getIntent().getBooleanExtra("shake_card", false))))
      {
        this.Jqx = getIntent().getIntExtra("shake_card", 0);
        getIntent().putExtra("shake_card", false);
        Log.i("MicroMsg.ShakeReportUI", "onresume shake card tab is open, activity type is 0 or open from specialview");
        this.Jqm = 6;
      }
    }
  }
  
  private void gb(View paramView)
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
    cl("", false);
    if (paramView.getId() == R.h.dUy)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11722, new Object[] { Integer.valueOf(1) });
      if (this.Jqm != 1)
      {
        if (this.Jqm == 4) {
          xV(false);
        }
        this.Jqm = 1;
        fHZ();
        xX(false);
        if (this.JpI != null) {
          this.JpI.setVisibility(8);
        }
      }
    }
    do
    {
      for (;;)
      {
        xW(true);
        ya(false);
        fIj();
        AppMethodBeat.o(28509);
        return;
        if (paramView.getId() == R.h.dUE)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(11722, new Object[] { Integer.valueOf(2) });
          if ((!this.iQF) && (this.iQC != null)) {
            this.iQC.a(this.iQJ, true);
          }
          if ((!com.tencent.mm.q.a.cy(this)) && (!com.tencent.mm.q.a.cw(this)) && (!com.tencent.mm.q.a.cB(this)) && (this.Jqm != 3))
          {
            if (this.Jqm == 4) {
              xV(false);
            }
            this.Jqm = 3;
            fHZ();
            xX(false);
            if (this.JpI != null) {
              this.JpI.setVisibility(8);
            }
          }
          fHW();
        }
        else
        {
          if (paramView.getId() != R.h.dUH) {
            break;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(11722, new Object[] { Integer.valueOf(3) });
          if ((!this.iQF) && (this.iQC != null)) {
            this.iQC.a(this.iQJ, true);
          }
          if ((!com.tencent.mm.q.a.cy(this)) && (!com.tencent.mm.q.a.cw(this)) && (!com.tencent.mm.q.a.cB(this)) && (this.Jqm != 4))
          {
            xV(true);
            this.Jqm = 4;
            fHZ();
            xX(false);
            if (this.JpI != null) {
              this.JpI.setVisibility(8);
            }
          }
        }
      }
      if ((paramView.getId() != R.h.dUC) && (paramView.getId() != R.h.dUz)) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(11722, new Object[] { Integer.valueOf(4) });
    } while (this.Jqm == 5);
    this.Jqm = 5;
    fHZ();
    xX(false);
    if (this.JpI != null) {
      this.JpI.setVisibility(8);
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
        aYc(getString(R.l.eSC));
      }
      paramView = BluetoothAdapter.getDefaultAdapter();
      if ((paramView != null) && (paramView.getState() != 12))
      {
        aYc(getString(R.l.eSB));
        break;
      }
      if (paramView != null) {
        break;
      }
      aYc(getString(R.l.eSF));
      break;
      if (paramView.getId() != R.h.dUu) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(11722, new Object[] { Integer.valueOf(5) });
      if (this.Jqm == 6) {
        break;
      }
      if (this.Jqm == 4) {
        xV(false);
      }
      this.Jqm = 6;
      fHZ();
      xX(false);
      if (this.JpI != null) {
        this.JpI.setVisibility(8);
      }
      com.tencent.mm.aa.c.aFn().D(262155, false);
      this.Jqk.setVisibility(8);
      break;
    }
  }
  
  private void xV(boolean paramBoolean)
  {
    AppMethodBeat.i(28495);
    String str = String.format("%1$s-shaketype-%2$d", new Object[] { getClass().getName(), Integer.valueOf(4) });
    Log.d("MicroMsg.ShakeReportUI", "activate change report , class name=" + str + ", isActive=" + paramBoolean);
    com.tencent.mm.ui.base.ac.d(paramBoolean, new Intent().putExtra("classname", str));
    AppMethodBeat.o(28495);
  }
  
  private void xW(boolean paramBoolean)
  {
    AppMethodBeat.i(28498);
    xX(paramBoolean);
    xY(paramBoolean);
    AppMethodBeat.o(28498);
  }
  
  private void xX(boolean paramBoolean)
  {
    AppMethodBeat.i(28499);
    if (this.JpV == null) {
      this.JpV = findViewById(R.h.goto_sayhi_btn);
    }
    if ((this.JpG.JmB == 3) || (this.JpG.JmB == 4) || (this.JpG.JmB == 5) || (this.JpG.JmB == 6) || (!paramBoolean))
    {
      this.JpV.setVisibility(8);
      AppMethodBeat.o(28499);
      return;
    }
    int i = com.tencent.mm.bl.d.bqe().cHo();
    if (i <= 0)
    {
      this.JpV.setVisibility(8);
      AppMethodBeat.o(28499);
      return;
    }
    this.JpV.setVisibility(0);
    ((TextView)this.JpV.findViewById(R.h.say_hi_count)).setText(getResources().getQuantityString(R.j.say_hi_count_text_quantity, i, new Object[] { Integer.valueOf(i) }));
    this.JpV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28456);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeReportUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = new Intent(ShakeReportUI.this, ShakeSayHiListUI.class);
        ((Intent)localObject).putExtra("IntentSayHiType", 1);
        paramAnonymousView = ShakeReportUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$16", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$16", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28456);
      }
    });
    if (this.JpZ == null) {
      this.JpZ = ((ImageView)findViewById(R.h.match_dlg_img));
    }
    cm localcm = com.tencent.mm.bl.d.bqe().hAO();
    if (localcm != null)
    {
      this.Jqa = localcm.field_sayhiuser;
      com.tencent.mm.pluginsdk.ui.a.b.c(this.JpZ, this.Jqa);
    }
    AppMethodBeat.o(28499);
  }
  
  private void xY(boolean paramBoolean)
  {
    AppMethodBeat.i(28500);
    if (this.JpW == null) {
      this.JpW = findViewById(R.h.dHX);
    }
    if (!paramBoolean)
    {
      this.JpW.setVisibility(8);
      AppMethodBeat.o(28500);
      return;
    }
    int i = com.tencent.mm.plugin.shake.b.m.fHp().cHo();
    if (i <= 0)
    {
      this.JpW.setVisibility(8);
      AppMethodBeat.o(28500);
      return;
    }
    if (this.JpY == null) {
      this.JpY = ((TextView)this.JpW.findViewById(R.h.dUg));
    }
    this.JpY.setText(getString(R.l.eSP, new Object[] { Integer.valueOf(i) }));
    this.JpW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28457);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeReportUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = new Intent(ShakeReportUI.this, ShakeMsgListUI.class);
        ((Intent)localObject).putExtra("shake_msg_from", 1);
        ((Intent)localObject).putExtra("shake_msg_list_title", ShakeReportUI.this.getString(R.l.eTi));
        paramAnonymousView = ShakeReportUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$17", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$17", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28457);
      }
    });
    if (this.JpX == null) {
      this.JpX = ((MMImageView)findViewById(R.h.dUm));
    }
    Object localObject = com.tencent.mm.plugin.shake.b.m.fHp().fHf();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.shake.b.f)localObject).field_thumburl;
      if (Util.isNullOrNil((String)localObject)) {
        break label255;
      }
      localObject = new com.tencent.mm.plugin.shake.e.b((String)localObject);
      Bitmap localBitmap = com.tencent.mm.platformtools.u.a((s)localObject);
      this.JpX.setTag(((com.tencent.mm.plugin.shake.e.b)localObject).bvs());
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        break label242;
      }
      this.JpX.setImageBitmap(localBitmap);
    }
    for (;;)
    {
      this.JpW.setVisibility(0);
      AppMethodBeat.o(28500);
      return;
      label242:
      this.JpX.setImageResource(R.k.app_attach_file_icon_webpage);
      continue;
      label255:
      this.JpX.setImageResource(R.k.app_attach_file_icon_webpage);
    }
  }
  
  private void xZ(boolean paramBoolean)
  {
    AppMethodBeat.i(28501);
    if (this.JpL != null)
    {
      if (paramBoolean)
      {
        this.JpL.setVisibility(0);
        AppMethodBeat.o(28501);
        return;
      }
      this.JpL.setVisibility(8);
      this.JpL.cancelLongPress();
    }
    AppMethodBeat.o(28501);
  }
  
  private void ya(boolean paramBoolean)
  {
    AppMethodBeat.i(28502);
    if (this.JpJ != null)
    {
      if (paramBoolean)
      {
        this.JpJ.setVisibility(0);
        AppMethodBeat.o(28502);
        return;
      }
      this.JpJ.setVisibility(4);
    }
    AppMethodBeat.o(28502);
  }
  
  public final void a(int paramInt, final com.tencent.mm.plugin.shake.c.a.d paramd, long paramLong)
  {
    AppMethodBeat.i(28507);
    this.Jqz = true;
    if (paramInt == 1251)
    {
      if (paramd == null)
      {
        AppMethodBeat.o(28507);
        return;
      }
      Log.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_GetLbsCard");
      com.tencent.mm.plugin.shake.c.c.a.fHi();
      fIg();
      fIb();
      fIe();
      this.Jqx = 4;
      com.tencent.mm.plugin.shake.b.m.fHu().r("key_shake_card_item", paramd);
      AppMethodBeat.o(28507);
      return;
    }
    Object localObject;
    if (paramInt == 1250)
    {
      if (paramd == null)
      {
        this.Jqe = null;
        aYc(null);
        AppMethodBeat.o(28507);
        return;
      }
      if (((paramd == null) || (this.JpA)) && (!this.JpA))
      {
        this.Jqe = null;
        aYc(null);
        AppMethodBeat.o(28507);
        return;
      }
      this.JpA = false;
      Log.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_ShakeCard");
      if (this.JpG.JmB == 6)
      {
        localObject = this.JpG.JmC;
        if ((localObject != null) && ((localObject instanceof com.tencent.mm.plugin.shake.c.a.f)))
        {
          localObject = (com.tencent.mm.plugin.shake.c.a.f)localObject;
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
      if (((com.tencent.mm.plugin.shake.c.a.f)localObject).tpK == 3)
      {
        Log.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is  MMBIZ_SHAKE_CARD_ACTION_TYPE_NO_CARD");
        if ((paramd != null) && (!TextUtils.isEmpty(paramd.Jne)))
        {
          aYc(paramd.Jne);
          AppMethodBeat.o(28507);
          return;
        }
        aYc(getString(R.l.eSt));
        AppMethodBeat.o(28507);
        return;
      }
      Log.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is " + ((com.tencent.mm.plugin.shake.c.a.f)localObject).tpK);
      aeC(3);
      if (paramd.tpK == 1) {
        this.JpC = false;
      }
      if ((this.Jqy != null) && (this.Jqy.isShowing()))
      {
        AppMethodBeat.o(28507);
        return;
      }
      if (paramd.Jng)
      {
        localObject = (ViewStub)findViewById(R.h.dZl);
        if (localObject != null) {
          ((ViewStub)localObject).inflate();
        }
        ((ShakeEggAnimFrame)findViewById(R.h.dvt)).aK(this);
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28464);
            ShakeReportUI.a(ShakeReportUI.this, paramd);
            AppMethodBeat.o(28464);
          }
        }, 1000L);
        AppMethodBeat.o(28507);
        return;
      }
      a(paramd);
      AppMethodBeat.o(28507);
      return;
      Log.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_ERR_REPORT");
      aYc(getString(R.l.eSt));
    }
  }
  
  public final void bez()
  {
    AppMethodBeat.i(28504);
    fHZ();
    AppMethodBeat.o(28504);
  }
  
  public final void e(List<com.tencent.mm.plugin.shake.b.d> paramList, long paramLong)
  {
    AppMethodBeat.i(28506);
    fIj();
    if ((paramList == null) || (!this.JpA) || (paramLong == 6L))
    {
      this.Jqe = null;
      if (paramLong == 6L)
      {
        aYc(getString(R.l.eSG));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 7L)
      {
        aYc(getString(R.l.eSE));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 8L)
      {
        aYc(getString(R.l.eSC));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 9L)
      {
        aYc(getString(R.l.eSB));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 10L)
      {
        aYc(getString(R.l.eSF));
        AppMethodBeat.o(28506);
        return;
      }
      aYc(null);
      AppMethodBeat.o(28506);
      return;
    }
    this.JpA = false;
    if (paramList.size() > 0) {
      this.Jqe = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0));
    }
    int i;
    Object localObject1;
    if (this.JpG.JmB == 1)
    {
      if ((paramList.size() > 0) && (((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_type != 0))
      {
        aYc(null);
        AppMethodBeat.o(28506);
        return;
      }
      this.JpE = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).scene;
      i = paramList.size();
      if (i == 0)
      {
        aYc(null);
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        localObject1 = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_username;
        Object localObject2 = ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_nickname;
        Log.i("MicroMsg.ShakeReportUI", "1 u:" + (String)localObject1 + " n:" + (String)localObject2 + " d:" + ((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_distance);
        if (this.Jpz) {
          PlaySound.play(getContext(), R.l.shake_match);
        }
        aeC(3);
        localObject1 = (com.tencent.mm.plugin.shake.b.d)paramList.get(0);
        Object localObject3;
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_username))
        {
          this.JpI.setTag(((com.tencent.mm.plugin.shake.b.d)localObject1).field_username);
          this.JpI.setVisibility(0);
          bh.beI();
          localObject2 = com.tencent.mm.model.c.bbL().RG(((com.tencent.mm.plugin.shake.b.d)localObject1).field_username);
          localObject3 = new StringBuilder().append(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
          if (!com.tencent.mm.contact.d.rk(((ax)localObject2).field_type)) {
            break label922;
          }
          paramList = getString(R.l.eSO);
          localObject3 = paramList;
          if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex != 1) {
            break label928;
          }
          this.JpI.setContentDescription((String)localObject3 + ((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance + getContext().getString(R.l.shake_sex_male));
          label570:
          TextView localTextView = (TextView)this.JpI.findViewById(R.h.dUd);
          AppCompatActivity localAppCompatActivity = getContext();
          StringBuilder localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
          if (!com.tencent.mm.contact.d.rk(((ax)localObject2).field_type)) {
            break label1016;
          }
          paramList = getString(R.l.eSO);
          label627:
          localTextView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(localAppCompatActivity, paramList, localTextView.getTextSize()));
          if (this.jiu != null)
          {
            if (Util.isNullOrNil((String)localObject3)) {
              break label1022;
            }
            this.jiu.setContentDescription(String.format(getString(R.l.shake_avatar), new Object[] { localObject3 }));
          }
          label692:
          ((TextView)this.JpI.findViewById(R.h.dUb)).setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance);
          com.tencent.mm.pluginsdk.ui.a.b.c((ImageView)this.JpI.findViewById(R.h.dUc), ((com.tencent.mm.plugin.shake.b.d)localObject1).field_username);
          paramList = (ImageView)this.JpI.findViewById(R.h.dUf);
          if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1 == 0) {
            break label1039;
          }
          paramList.setVisibility(0);
          paramList.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile(az.a.ltt.uS(((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1), 2.0F));
          label782:
          if ((((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1 != 0) || (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex == 0)) {
            break label1056;
          }
          if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex != 1) {
            break label1048;
          }
          i = R.k.ic_sex_male;
          label812:
          paramList = com.tencent.mm.ci.a.m(this, i);
          this.JpI.findViewById(R.h.dUe).setVisibility(0);
          ((ImageView)this.JpI.findViewById(R.h.dUe)).setImageDrawable(paramList);
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
          this.JpI.startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.djH));
          AppMethodBeat.o(28506);
          return;
          label922:
          paramList = "";
          break;
          label928:
          if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex == 2)
          {
            this.JpI.setContentDescription((String)localObject3 + ((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance + getContext().getString(R.l.shake_sex_female));
            break label570;
          }
          this.JpI.setContentDescription((String)localObject3 + ((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance);
          break label570;
          label1016:
          paramList = "";
          break label627;
          label1022:
          this.jiu.setContentDescription(getString(R.l.shake_avatar_unknow));
          break label692;
          label1039:
          paramList.setVisibility(8);
          break label782;
          label1048:
          i = R.k.ic_sex_female;
          break label812;
          label1056:
          this.JpI.findViewById(R.h.dUe).setVisibility(8);
        }
      }
      if (this.Jpz) {
        PlaySound.play(getContext(), R.l.shake_match);
      }
      aeC(3);
      xX(false);
      paramList = new Intent(this, ShakeItemListUI.class);
      paramList.putExtra("_key_show_type_", -1);
      paramList.putExtra("_key_title_", getString(R.l.eSN));
      paramList = new com.tencent.mm.hellhoundlib.b.a().bm(paramList);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramList.aFh(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramList.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(28506);
      return;
    }
    if (this.JpG.JmB == 3)
    {
      i = paramList.size();
      if (i == 0)
      {
        aYc(getString(R.l.eST));
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        if (this.Jpz) {
          PlaySound.play(getContext(), R.l.shake_match);
        }
        aeC(3);
        if (((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_type == 4)
        {
          paramList = com.tencent.mm.plugin.shake.d.a.i.f(((com.tencent.mm.plugin.shake.b.d)paramList.get(0)).field_lvbuffer, paramLong);
          com.tencent.mm.bb.a.d(paramList);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_mode", 1);
          ((Intent)localObject1).putExtra("key_offset", paramList.lVu);
          ((Intent)localObject1).putExtra("music_player_beg_time", paramList.lVM);
          ((Intent)localObject1).putExtra("key_scene", 3);
          if (com.tencent.mm.bb.e.bnG()) {
            ((Intent)localObject1).putExtra("KGlobalShakeMusic", true);
          }
          com.tencent.mm.by.c.b(this, "music", ".ui.MusicMainUI", (Intent)localObject1);
          AppMethodBeat.o(28506);
          return;
        }
        Log.w("MicroMsg.ShakeReportUI", "Unexpected type, ignore.");
      }
      AppMethodBeat.o(28506);
      return;
    }
    if (this.JpG.JmB == 4)
    {
      fIj();
      i = paramList.size();
      if (i == 0)
      {
        aYc(getString(R.l.eTj));
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        if (this.Jpz) {
          PlaySound.play(getContext(), R.l.shake_match);
        }
        aeC(3);
        paramList = (com.tencent.mm.plugin.shake.b.d)paramList.get(0);
        new MMHandler().postDelayed(new k.1(paramList, this), 100L);
      }
      AppMethodBeat.o(28506);
      return;
    }
    if (this.JpG.JmB == 5) {
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
          if (this.Jpz) {
            PlaySound.play(getContext(), R.l.shake_match);
          }
          aeC(3);
          paramList = (com.tencent.mm.plugin.shake.b.d)paramList.get(0);
          if (!Util.isNullOrNil(paramList.field_username))
          {
            this.JpI.setTag(paramList.field_username);
            ((TextView)this.JpI.findViewById(R.h.dUd)).setText(paramList.field_username);
            this.JpI.setContentDescription(Util.nullAsNil(paramList.field_nickname));
            ((TextView)this.JpI.findViewById(R.h.dUb)).setText(paramList.field_signature);
            this.lQK.loadImage(paramList.getProvince(), (ImageView)this.JpI.findViewById(R.h.dUc));
            this.JpI.findViewById(R.h.dUe).setVisibility(8);
            this.JpI.startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.djH));
            this.JpI.setVisibility(0);
          }
          AppMethodBeat.o(28506);
          return;
        }
        if (this.Jpz) {
          PlaySound.play(getContext(), R.l.shake_match);
        }
        aeC(3);
        xX(false);
        localObject1 = new Intent(this, ShakeItemListUI.class);
        ((Intent)localObject1).putExtra("_key_show_type_", -12);
        ((Intent)localObject1).putExtra("_key_title_", getString(R.l.eSM));
        ((Intent)localObject1).putExtra("_key_show_from_shake_", true);
        ((Intent)localObject1).putExtra("_ibeacon_new_insert_size", paramList.size());
        paramList = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramList.aFh(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramList.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(28506);
        return;
      }
      aYc(null);
      AppMethodBeat.o(28506);
      return;
      aYc(getString(R.l.eSG));
    }
  }
  
  public final void fHx()
  {
    AppMethodBeat.i(28516);
    com.tencent.mm.plugin.shake.c.c.a.fHi();
    fIb();
    fIc();
    fIf();
    fIg();
    fIe();
    AppMethodBeat.o(28516);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.ekX;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28491);
    com.tencent.mm.plugin.shake.c.c.a.fHi();
    this.JqA.put(Integer.valueOf(1), Boolean.TRUE);
    this.JqA.put(Integer.valueOf(3), Boolean.FALSE);
    this.JqA.put(Integer.valueOf(4), Boolean.FALSE);
    this.JqA.put(Integer.valueOf(5), Boolean.FALSE);
    this.JqA.put(Integer.valueOf(6), Boolean.FALSE);
    this.lQK = new com.tencent.mm.ay.a.a(this);
    this.JpK = ((TextView)findViewById(R.h.dUs));
    this.JpJ = findViewById(R.h.dUI);
    this.JpL = ((TextView)findViewById(R.h.dUn));
    this.JpM = ((TextView)findViewById(R.h.dUr));
    this.Jqo = findViewById(R.h.dUW);
    this.Jqp = ((ImageView)findViewById(R.h.dUK));
    this.Jqq = ((ImageView)findViewById(R.h.dUM));
    this.Jqr = ((ImageView)findViewById(R.h.dUO));
    this.Jqs = ((ImageView)findViewById(R.h.dUQ));
    this.Jqt = findViewById(R.h.dUL);
    this.Jqu = findViewById(R.h.dUN);
    this.Jqv = findViewById(R.h.dUP);
    this.Jqw = findViewById(R.h.dUR);
    this.JpI = findViewById(R.h.dUq);
    this.JpI.setOnClickListener(this.JqK);
    this.jiu = ((ImageView)this.JpI.findViewById(R.h.dUc));
    this.jiu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28477);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeReportUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (ShakeReportUI.q(ShakeReportUI.this) != 5)
        {
          localObject = new Intent(ShakeReportUI.this.getContext(), ProfileHdHeadImg.class);
          ((Intent)localObject).putExtra("username", (String)ShakeReportUI.r(ShakeReportUI.this).getTag());
          paramAnonymousView = ShakeReportUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28477);
      }
    });
    fHX();
    Object localObject = View.inflate(getContext(), R.i.ekU, null);
    this.Jqc = new com.tencent.mm.ui.base.i(getContext(), R.m.mmalertdialog);
    this.Jqc.setContentView((View)localObject);
    this.Jqc.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(28450);
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
        {
          public final boolean queueIdle()
          {
            AppMethodBeat.i(28449);
            w.q(ShakeReportUI.this, ShakeReportUI.this.getString(R.l.eTd));
            bh.beI();
            com.tencent.mm.model.c.aHp().i(4117, Boolean.TRUE);
            AppMethodBeat.o(28449);
            return false;
          }
        });
        AppMethodBeat.o(28450);
      }
    });
    ((Button)((View)localObject).findViewById(R.h.dTW)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28451);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeReportUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ShakeReportUI.s(ShakeReportUI.this).cancel();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28451);
      }
    });
    bh.beI();
    boolean bool1 = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.aHp().b(4108, null));
    bh.beI();
    boolean bool2 = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.aHp().b(4117, null));
    if (!bool1)
    {
      ((View)localObject).setVisibility(0);
      this.Jqc.show();
      bh.beI();
      com.tencent.mm.model.c.aHp().i(4108, Boolean.TRUE);
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
      addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, new MenuItem.OnMenuItemClickListener()
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
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeReportUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          ShakeReportUI.a(ShakeReportUI.this, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28480);
        }
      };
      if ((!this.JqE) && (!this.JqC)) {
        break label742;
      }
    }
    label742:
    for (this.Jqd = ((ImageView)findViewById(R.h.dUB));; this.Jqd = ((ImageView)findViewById(R.h.dUA)))
    {
      this.Jqf = ((ImageView)findViewById(R.h.dUx));
      this.Jqg = ((ImageView)findViewById(R.h.dUD));
      this.Jqh = ((ImageView)findViewById(R.h.dUG));
      this.Jqi = ((ImageView)findViewById(R.h.dUt));
      this.Jql = ((TextView)findViewById(R.h.dUw));
      this.Jqk = ((ImageView)findViewById(R.h.dUv));
      this.Jqj = ((ImageView)findViewById(R.h.dUF));
      fIf();
      findViewById(R.h.dUC).setOnClickListener((View.OnClickListener)localObject);
      findViewById(R.h.dUy).setOnClickListener((View.OnClickListener)localObject);
      findViewById(R.h.dUE).setOnClickListener((View.OnClickListener)localObject);
      findViewById(R.h.dUH).setOnClickListener((View.OnClickListener)localObject);
      findViewById(R.h.dUu).setOnClickListener((View.OnClickListener)localObject);
      fIb();
      fIe();
      fIj();
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
          w.q(ShakeReportUI.this, ShakeReportUI.this.getString(R.l.eTd));
          bh.beI();
          com.tencent.mm.model.c.aHp().i(4117, Boolean.TRUE);
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
    if ((this.JpX != null) && (this.JpX.getTag() != null) && (paramString.equals((String)this.JpX.getTag()))) {
      this.JpX.setImageBitmap(paramBitmap);
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
      bh.beI();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.model.c.bbW() + "custom_shake_img_filename.jpg");
      com.tencent.mm.plugin.shake.a.mIG.a(localIntent, 2, this, paramIntent);
      AppMethodBeat.o(28510);
      return;
    case 2: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(28510);
        return;
      }
      paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
      bh.beI();
      com.tencent.mm.model.c.aHp().i(4110, Boolean.FALSE);
      bh.beI();
      com.tencent.mm.model.c.aHp().i(4111, paramIntent);
      fHX();
      AppMethodBeat.o(28510);
      return;
    }
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
      {
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvE, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_FINE_LOCATION", 64);
        this.mXU = false;
        AppMethodBeat.o(28510);
        return;
      }
      this.mXU = true;
      finish();
      AppMethodBeat.o(28510);
      return;
    }
    this.mXU = true;
    finish();
    AppMethodBeat.o(28510);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28484);
    super.onCreate(paramBundle);
    setMMTitle(R.l.shake_report_title);
    setActionbarColor(getResources().getColor(R.e.Dark_3));
    setNavigationbarColor(getResources().getColor(R.e.Dark_3));
    hideActionbarLine();
    this.iQC = com.tencent.mm.modelgeo.d.blq();
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.VhL, "");
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.VhM, "");
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vks, "");
    paramBundle = com.tencent.mm.plugin.shake.b.m.fHt();
    if (paramBundle.cSF == null) {
      paramBundle.cSF = new ArrayList();
    }
    paramBundle.cSF.add(new WeakReference(this));
    initView();
    this.JpF = new c(getBodyView());
    this.shakeSensor = new com.tencent.mm.pluginsdk.m.d();
    if (!this.shakeSensor.hiW()) {
      com.tencent.mm.ui.base.h.a(this, R.l.eSU, R.l.app_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(28461);
          ShakeReportUI.this.finish();
          AppMethodBeat.o(28461);
        }
      });
    }
    if (com.tencent.mm.plugin.shake.a.mIH != null) {
      com.tencent.mm.plugin.shake.a.mIH.abC();
    }
    com.tencent.mm.platformtools.u.b(this);
    Log.i("MicroMsg.ShakeReportUI", "%s", new Object[] { getResources().getDisplayMetrics().toString() });
    int i = com.tencent.mm.plugin.shake.b.m.fHp().cHo();
    com.tencent.mm.plugin.report.service.h.IzE.a(11317, new Object[] { Integer.valueOf(i), e.fIl() });
    com.tencent.mm.plugin.report.service.h.IzE.a(11710, new Object[] { Integer.valueOf(1) });
    com.tencent.mm.plugin.report.service.h.IzE.p(834L, 0L, 1L);
    AppMethodBeat.o(28484);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28488);
    if ((this.Jqb != null) && (!this.Jqb.isRecycled())) {
      this.Jqb.recycle();
    }
    if ((this.Jqc != null) && (this.Jqc.isShowing()))
    {
      this.Jqc.dismiss();
      this.Jqc = null;
    }
    if (this.JpG.JmC != null) {
      this.JpG.JmC.fGS();
    }
    if (this.shakeSensor != null)
    {
      this.shakeSensor.cPS();
      this.shakeSensor = null;
    }
    Object localObject = j.a(null);
    if (j.lsn)
    {
      j.lsn = false;
      if (!((j)localObject).JoD.fHO()) {
        Log.e("Micromsg.ShakeMusicMgr", "release MusicFingerPrintRecorder error");
      }
    }
    j.JoE = null;
    com.tencent.mm.platformtools.u.c(this);
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vkh, Boolean.FALSE);
    if (com.tencent.mm.plugin.shake.c.c.a.fHM()) {
      com.tencent.mm.aa.c.aFn().D(262154, false);
    }
    fId();
    localObject = com.tencent.mm.plugin.shake.b.m.fHt();
    int i;
    if (((com.tencent.mm.plugin.shake.c.a.e)localObject).cSF != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < ((com.tencent.mm.plugin.shake.c.a.e)localObject).cSF.size())
      {
        WeakReference localWeakReference = (WeakReference)((com.tencent.mm.plugin.shake.c.a.e)localObject).cSF.get(i);
        if (localWeakReference != null)
        {
          e.a locala = (e.a)localWeakReference.get();
          if ((locala != null) && (locala.equals(this))) {
            ((com.tencent.mm.plugin.shake.c.a.e)localObject).cSF.remove(localWeakReference);
          }
        }
      }
      else
      {
        localObject = com.tencent.mm.plugin.shake.b.m.fHu();
        ((com.tencent.mm.plugin.shake.c.a.c)localObject).iQD = -85.0F;
        ((com.tencent.mm.plugin.shake.c.a.c)localObject).iQE = -1000.0F;
        if (this.iQC != null) {
          this.iQC.b(this.iQJ);
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
    fIa();
    if (!this.JpB) {
      xW(true);
    }
    AppMethodBeat.o(28511);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(28487);
    bh.beI();
    com.tencent.mm.model.c.b(this);
    bh.beI();
    com.tencent.mm.model.c.aHp().remove(this);
    com.tencent.mm.plugin.shake.b.m.fHo().remove(this);
    if (this.JpG.JmC != null) {
      this.JpG.JmC.pause();
    }
    this.JpC = false;
    if (this.shakeSensor != null) {
      this.shakeSensor.cPS();
    }
    this.JpF.fHT();
    if (this.Jqm != 5)
    {
      bh.beI();
      com.tencent.mm.model.c.aHp().i(327696, this.Jqm);
    }
    if (this.Jqm == 4) {
      xV(false);
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
        com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28468);
            paramAnonymousDialogInterface.dismiss();
            paramAnonymousDialogInterface = ShakeReportUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$27", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$27", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
          ftw();
          AppMethodBeat.o(28527);
          return;
        }
        this.mXU = false;
        com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(28470);
            paramAnonymousDialogInterface = ShakeReportUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$29", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$29", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    if (this.mXU) {
      if (com.tencent.mm.az.b.WF((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null)))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.ACCESS_FINE_LOCATION"))
        {
          if (!((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VvE, Boolean.FALSE)).booleanValue())
          {
            com.tencent.mm.plugin.account.sdk.b.a.b(this, getString(R.l.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
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
    ftw();
    AppMethodBeat.o(28485);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends com.tencent.mm.pluginsdk.m.d.a
  {
    WeakReference<ShakeReportUI> JqS;
    private final long[] VIRBRATOR_PATTERN;
    private long lastShakeTime;
    private Vibrator rqC;
    
    public a(ShakeReportUI paramShakeReportUI)
    {
      AppMethodBeat.i(28481);
      this.lastShakeTime = Util.currentTicks();
      this.VIRBRATOR_PATTERN = new long[] { 300L, 200L, 300L, 200L };
      this.JqS = new WeakReference(paramShakeReportUI);
      AppMethodBeat.o(28481);
    }
    
    public final void onRelease() {}
    
    public final void onShake(boolean paramBoolean)
    {
      AppMethodBeat.i(28482);
      ShakeReportUI localShakeReportUI = (ShakeReportUI)this.JqS.get();
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
        ShakeReportUI.y(localShakeReportUI);
        AppMethodBeat.o(28482);
        throw null;
      }
      if (ShakeReportUI.z(localShakeReportUI))
      {
        localObject = (ShakeReportUI)this.JqS.get();
        if (localObject != null) {
          PlaySound.play((Context)localObject, R.l.shake_sound_male);
        }
      }
      for (;;)
      {
        reset();
        ShakeReportUI.A(localShakeReportUI);
        AppMethodBeat.o(28482);
        return;
        localObject = (ShakeReportUI)this.JqS.get();
        if (localObject != null)
        {
          if (this.rqC == null) {
            this.rqC = ((Vibrator)((ShakeReportUI)localObject).getSystemService("vibrator"));
          }
          if (this.rqC != null) {
            this.rqC.vibrate(this.VIRBRATOR_PATTERN, -1);
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