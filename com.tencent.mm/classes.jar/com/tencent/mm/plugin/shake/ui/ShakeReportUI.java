package com.tencent.mm.plugin.shake.ui;

import android.animation.AnimatorSet;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.mz;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.shake.c.a.j.a;
import com.tencent.mm.plugin.shake.c.a.k.b;
import com.tencent.mm.plugin.shake.c.a.n;
import com.tencent.mm.plugin.shake.c.a.n.1;
import com.tencent.mm.plugin.shake.model.l.a;
import com.tencent.mm.plugin.shake.model.l.b;
import com.tencent.mm.pluginsdk.l.d.a;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.protocal.protobuf.dlk;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cp;
import com.tencent.mm.storage.cq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.ag;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.i;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@com.tencent.mm.ui.base.a(32)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class ShakeReportUI
  extends MMActivity
  implements bd, r.a, l.a, com.tencent.mm.plugin.shake.shakecard.a.e.a, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
{
  private static List<j.a> lsD;
  private boolean EPk;
  private boolean OXt;
  private k.b PAT;
  private boolean PCA;
  private int PCB;
  private c PCC;
  private com.tencent.mm.plugin.shake.model.l PCD;
  private com.tencent.mm.pluginsdk.ui.g PCE;
  private View PCF;
  private View PCG;
  private TextView PCH;
  private TextView PCI;
  private TextView PCJ;
  private View PCK;
  private View PCL;
  private View PCM;
  private View PCN;
  private Animation PCO;
  private Animation PCP;
  private Animation PCQ;
  private Animation PCR;
  private Animation PCS;
  private Animation PCT;
  private Animation PCU;
  private Animation PCV;
  private Animation PCW;
  private boolean PCX;
  private int PCY;
  private View PCZ;
  private boolean PCu;
  private boolean PCv;
  private boolean PCw;
  private boolean PCx;
  private boolean PCy;
  private boolean PCz;
  private Dialog PDA;
  private WeImageView PDB;
  private TextView PDC;
  private com.tencent.mm.plugin.shake.model.d PDD;
  private WeImageView PDE;
  private TextView PDF;
  private WeImageView PDG;
  private TextView PDH;
  private WeImageView PDI;
  private TextView PDJ;
  private WeImageView PDK;
  private ImageView PDL;
  private ImageView PDM;
  private TextView PDN;
  private int PDO;
  private int PDP;
  private View PDQ;
  private ImageView PDR;
  private ImageView PDS;
  private ImageView PDT;
  private ImageView PDU;
  private View PDV;
  private View PDW;
  private View PDX;
  private View PDY;
  private int PDZ;
  private View PDa;
  private View PDb;
  private View PDc;
  private View PDd;
  private AnimatorSet PDe;
  private AnimatorSet PDf;
  private AnimatorSet PDg;
  private Boolean PDh;
  private MMAnimateView PDi;
  private MMAnimateView PDj;
  private ImageView PDk;
  private boolean PDl;
  private TextView PDm;
  private TextView PDn;
  private int PDo;
  private WeImageView PDp;
  private WeImageView PDq;
  private WeImageView PDr;
  private WeImageView PDs;
  private View PDt;
  private View PDu;
  private MMImageView PDv;
  private TextView PDw;
  private ImageView PDx;
  private String PDy;
  private Bitmap PDz;
  private com.tencent.mm.plugin.shake.shakecard.ui.a PEa;
  private boolean PEb;
  private Map<Integer, Boolean> PEc;
  private boolean PEd;
  private boolean PEe;
  private boolean PEf;
  private boolean PEg;
  private int PEh;
  private boolean PEi;
  private boolean PEj;
  private boolean PEk;
  private View.OnClickListener PEl;
  private int bVs;
  private ImageView lKK;
  private boolean lsB;
  private Map<String, j.a> lsC;
  private b.a lsF;
  private com.tencent.mm.modelgeo.d lsy;
  private com.tencent.mm.modelimage.loader.a oJu;
  private IListener rDF;
  private com.tencent.mm.pluginsdk.l.d shakeSensor;
  private long startTime;
  private com.tencent.mm.aw.f tie;
  
  static
  {
    AppMethodBeat.i(28541);
    lsD = new CopyOnWriteArrayList();
    AppMethodBeat.o(28541);
  }
  
  public ShakeReportUI()
  {
    AppMethodBeat.i(28483);
    this.PCu = false;
    this.PCv = false;
    this.PCx = false;
    this.PCy = false;
    this.PCz = false;
    this.PCA = false;
    this.PCB = 22;
    this.PCD = new com.tencent.mm.plugin.shake.model.l();
    this.PCX = false;
    this.PCY = 1;
    this.PDh = Boolean.FALSE;
    this.PDt = null;
    this.PDu = null;
    this.PDv = null;
    this.PDw = null;
    this.PDx = null;
    this.PDy = "";
    this.PDz = null;
    this.PDB = null;
    this.oJu = null;
    this.PDD = null;
    this.PDO = 1;
    this.PDP = 0;
    this.PDZ = 0;
    this.PEb = false;
    this.PEc = new HashMap();
    this.PEd = false;
    this.PEe = false;
    this.PEf = false;
    this.PEg = false;
    this.PEh = 1;
    this.OXt = true;
    this.PEi = false;
    this.lsB = false;
    this.lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(273586);
        if (paramAnonymousBoolean)
        {
          Log.d("MicroMsg.ShakeReportUI", "on location get ok");
          bh.bCz();
          com.tencent.mm.model.c.ban().set(at.a.acJf, String.valueOf(paramAnonymousFloat2));
          bh.bCz();
          com.tencent.mm.model.c.ban().set(at.a.acJg, String.valueOf(paramAnonymousFloat1));
          bh.bCz();
          com.tencent.mm.model.c.ban().set(at.a.acLM, String.valueOf(paramAnonymousDouble2));
          ShakeReportUI.a(ShakeReportUI.this);
          if (ShakeReportUI.b(ShakeReportUI.this) != null) {
            ShakeReportUI.b(ShakeReportUI.this).a(ShakeReportUI.c(ShakeReportUI.this));
          }
        }
        for (;;)
        {
          AppMethodBeat.o(273586);
          return false;
          if ((!ShakeReportUI.d(ShakeReportUI.this)) && (!com.tencent.mm.modelgeo.d.bJm()))
          {
            ShakeReportUI.e(ShakeReportUI.this);
            k.a(ShakeReportUI.this, ShakeReportUI.this.getString(R.l.gps_disable_tip), ShakeReportUI.this.getString(R.l.app_tip), ShakeReportUI.this.getString(R.l.jump_to_settings), ShakeReportUI.this.getString(R.l.app_cancel), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(28445);
                com.tencent.mm.modelgeo.d.dP(ShakeReportUI.this);
                AppMethodBeat.o(28445);
              }
            }, null);
          }
          Log.w("MicroMsg.ShakeReportUI", "getLocation fail");
        }
      }
    };
    this.lsC = new ConcurrentHashMap();
    this.PEj = false;
    this.PEk = false;
    this.rDF = new IListener(com.tencent.mm.app.f.hfK) {};
    this.PEl = new ShakeReportUI.16(this);
    AppMethodBeat.o(28483);
  }
  
  private void CU(boolean paramBoolean)
  {
    AppMethodBeat.i(28495);
    String str = String.format("%1$s-shaketype-%2$d", new Object[] { getClass().getName(), Integer.valueOf(3) });
    Log.d("MicroMsg.ShakeReportUI", "activate change report , class name=" + str + ", isActive=" + paramBoolean);
    ag.d(paramBoolean, new Intent().putExtra("classname", str));
    AppMethodBeat.o(28495);
  }
  
  private void CV(boolean paramBoolean)
  {
    AppMethodBeat.i(273572);
    int i;
    if (paramBoolean)
    {
      i = com.tencent.mm.cd.a.w(this, R.e.BW_100_Alpha_0_8);
      this.PDG.setImageResource(R.k.icons_filled_music);
    }
    for (;;)
    {
      this.PDH.setTextColor(i);
      this.PDG.setIconColor(i);
      AppMethodBeat.o(273572);
      return;
      i = com.tencent.mm.cd.a.w(this, R.e.BW_100_Alpha_0_3);
      this.PDG.setImageResource(R.k.icons_outlined_music);
    }
  }
  
  private void CW(boolean paramBoolean)
  {
    AppMethodBeat.i(273574);
    int i;
    if (paramBoolean)
    {
      i = com.tencent.mm.cd.a.w(this, R.e.BW_100_Alpha_0_8);
      this.PDE.setImageResource(R.k.icons_filled_me);
    }
    for (;;)
    {
      this.PDE.setIconColor(i);
      this.PDF.setTextColor(i);
      AppMethodBeat.o(273574);
      return;
      i = com.tencent.mm.cd.a.w(this, R.e.BW_100_Alpha_0_3);
      this.PDE.setImageResource(R.k.icons_outlined_me);
    }
  }
  
  private void CX(boolean paramBoolean)
  {
    AppMethodBeat.i(273576);
    int i;
    if (paramBoolean)
    {
      i = com.tencent.mm.cd.a.w(this, R.e.BW_100_Alpha_0_8);
      this.PDI.setImageResource(R.k.icons_filled_tv);
    }
    for (;;)
    {
      this.PDI.setIconColor(i);
      this.PDJ.setTextColor(i);
      AppMethodBeat.o(273576);
      return;
      i = com.tencent.mm.cd.a.w(this, R.e.BW_100_Alpha_0_3);
      this.PDI.setImageResource(R.k.icons_outlined_tv);
    }
  }
  
  private void CY(boolean paramBoolean)
  {
    AppMethodBeat.i(273579);
    if (paramBoolean) {}
    for (int i = com.tencent.mm.cd.a.w(this, R.e.BW_100_Alpha_0_8);; i = com.tencent.mm.cd.a.w(this, R.e.BW_100_Alpha_0_3))
    {
      this.PDC.setTextColor(i);
      AppMethodBeat.o(273579);
      return;
    }
  }
  
  private void CZ(boolean paramBoolean)
  {
    AppMethodBeat.i(273581);
    int i;
    if (paramBoolean)
    {
      i = com.tencent.mm.cd.a.w(this, R.e.BW_100_Alpha_0_8);
      this.PDK.setImageResource(R.k.icons_outlined_cards_offers);
    }
    for (;;)
    {
      this.PDN.setTextColor(i);
      AppMethodBeat.o(273581);
      return;
      i = com.tencent.mm.cd.a.w(this, R.e.BW_100_Alpha_0_3);
      this.PDK.setImageResource(R.k.icons_filled_cards_offers);
    }
  }
  
  private void Da(boolean paramBoolean)
  {
    AppMethodBeat.i(28498);
    Db(paramBoolean);
    Dc(paramBoolean);
    AppMethodBeat.o(28498);
  }
  
  private void Db(boolean paramBoolean)
  {
    AppMethodBeat.i(28499);
    if (this.PDt == null) {
      this.PDt = findViewById(R.h.goto_sayhi_btn);
    }
    if ((this.PCD.Pzr == 2) || (this.PCD.Pzr == 3) || (this.PCD.Pzr == 4) || (this.PCD.Pzr == 5) || (!paramBoolean))
    {
      this.PDt.setVisibility(8);
      AppMethodBeat.o(28499);
      return;
    }
    int i = com.tencent.mm.modelverify.d.bNK().dkF();
    if (i <= 0)
    {
      this.PDt.setVisibility(8);
      AppMethodBeat.o(28499);
      return;
    }
    this.PDt.setVisibility(0);
    ((TextView)this.PDt.findViewById(R.h.say_hi_count)).setText(getResources().getQuantityString(R.j.say_hi_count_text_quantity, i, new Object[] { Integer.valueOf(i) }));
    this.PDt.setOnClickListener(new ShakeReportUI.4(this));
    if (this.PDx == null) {
      this.PDx = ((ImageView)findViewById(R.h.match_dlg_img));
    }
    cp localcp = com.tencent.mm.modelverify.d.bNK().jcR();
    if (localcp != null)
    {
      this.PDy = localcp.field_sayhiuser;
      com.tencent.mm.pluginsdk.ui.a.b.g(this.PDx, this.PDy);
    }
    AppMethodBeat.o(28499);
  }
  
  private void Dc(boolean paramBoolean)
  {
    AppMethodBeat.i(28500);
    if (this.PDu == null) {
      this.PDu = findViewById(R.h.fJk);
    }
    if (!paramBoolean)
    {
      this.PDu.setVisibility(8);
      AppMethodBeat.o(28500);
      return;
    }
    int i = com.tencent.mm.plugin.shake.model.m.gXe().dkF();
    if (i <= 0)
    {
      this.PDu.setVisibility(8);
      AppMethodBeat.o(28500);
      return;
    }
    if (this.PDw == null) {
      this.PDw = ((TextView)this.PDu.findViewById(R.h.fWo));
    }
    this.PDw.setText(getString(R.l.gVC, new Object[] { Integer.valueOf(i) }));
    this.PDu.setOnClickListener(new ShakeReportUI.5(this));
    if (this.PDv == null) {
      this.PDv = ((MMImageView)findViewById(R.h.fWu));
    }
    Object localObject = com.tencent.mm.plugin.shake.model.m.gXe().gWT();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.shake.model.f)localObject).field_thumburl;
      if (Util.isNullOrNil((String)localObject)) {
        break label255;
      }
      localObject = new com.tencent.mm.plugin.shake.d.c((String)localObject);
      Bitmap localBitmap = r.a((com.tencent.mm.platformtools.p)localObject);
      this.PDv.setTag(((com.tencent.mm.plugin.shake.d.c)localObject).bTE());
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        break label242;
      }
      this.PDv.setImageBitmap(localBitmap);
    }
    for (;;)
    {
      this.PDu.setVisibility(0);
      AppMethodBeat.o(28500);
      return;
      label242:
      this.PDv.setImageResource(R.k.app_attach_file_icon_webpage);
      continue;
      label255:
      this.PDv.setImageResource(R.k.app_attach_file_icon_webpage);
    }
  }
  
  private void Dd(boolean paramBoolean)
  {
    AppMethodBeat.i(28501);
    if (this.PCI != null)
    {
      if (paramBoolean)
      {
        this.PCI.setVisibility(0);
        AppMethodBeat.o(28501);
        return;
      }
      this.PCI.setVisibility(8);
      this.PCI.cancelLongPress();
    }
    AppMethodBeat.o(28501);
  }
  
  private void De(boolean paramBoolean)
  {
    AppMethodBeat.i(28502);
    if (this.PCG != null)
    {
      if (paramBoolean)
      {
        this.PCG.setVisibility(0);
        AppMethodBeat.o(28502);
        return;
      }
      this.PCG.setVisibility(4);
    }
    AppMethodBeat.o(28502);
  }
  
  private void a(com.tencent.mm.plugin.shake.shakecard.a.d paramd)
  {
    AppMethodBeat.i(28508);
    this.PEa = com.tencent.mm.plugin.shake.shakecard.ui.a.a(this, paramd, new DialogInterface.OnCancelListener()new com.tencent.mm.plugin.shake.shakecard.ui.a.b
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(273559);
        paramAnonymousDialogInterface.dismiss();
        ShakeReportUI.a(ShakeReportUI.this, true);
        ShakeReportUI.D(ShakeReportUI.this);
        ShakeReportUI.E(ShakeReportUI.this).setText("");
        AppMethodBeat.o(273559);
      }
    }, new com.tencent.mm.plugin.shake.shakecard.ui.a.b()
    {
      public final void gtj()
      {
        AppMethodBeat.i(273562);
        ShakeReportUI.a(ShakeReportUI.this, true);
        ShakeReportUI.E(ShakeReportUI.this).setText("");
        AppMethodBeat.o(273562);
      }
    });
    AppMethodBeat.o(28508);
  }
  
  private void aVT(String paramString)
  {
    AppMethodBeat.i(28505);
    this.PCx = false;
    if (this.PCw) {
      PlaySound.play(getContext(), R.l.shake_nomatch);
    }
    if (this.PCQ == null) {
      this.PCQ = AnimationUtils.loadAnimation(getContext(), R.a.faded_out);
    }
    ajk(2);
    if ((paramString != null) && (paramString.length() > 1)) {
      this.PCI.setText(paramString);
    }
    for (;;)
    {
      this.PCI.startAnimation(this.PCQ);
      this.PCA = true;
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28460);
          ShakeReportUI.C(ShakeReportUI.this);
          ShakeReportUI.l(ShakeReportUI.this);
          AppMethodBeat.o(28460);
        }
      }, this.PCQ.getDuration());
      paramString = new mz();
      paramString.jcL = this.PCD.gXb();
      com.tencent.mm.plugin.shake.a locala = com.tencent.mm.plugin.shake.a.PyM;
      com.tencent.mm.plugin.shake.a.a(14, paramString);
      AppMethodBeat.o(28505);
      return;
      this.PCI.setText(R.l.gVm);
    }
  }
  
  private void ajj(int paramInt)
  {
    AppMethodBeat.i(273591);
    if (this.PDh.booleanValue())
    {
      AppMethodBeat.o(273591);
      return;
    }
    o.runOnUiThread(new ShakeReportUI..ExternalSyntheticLambda6(this, paramInt));
    AppMethodBeat.o(273591);
  }
  
  private void ajk(int paramInt)
  {
    AppMethodBeat.i(28503);
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      De(bool);
      if (paramInt != 2) {
        break;
      }
      Dd(true);
      AppMethodBeat.o(28503);
      return;
    }
    Dd(false);
    AppMethodBeat.o(28503);
  }
  
  private void cL(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(28519);
    this.PCx = false;
    if (this.PCQ == null) {
      this.PCQ = AnimationUtils.loadAnimation(getContext(), R.a.faded_out);
    }
    ajk(2);
    Dd(true);
    if ((paramString != null) && (paramString.length() > 1)) {
      this.PCI.setText(paramString);
    }
    for (;;)
    {
      this.PCA = true;
      AppMethodBeat.o(28519);
      return;
      if (paramBoolean)
      {
        this.PCI.setText(R.l.gVf);
      }
      else
      {
        this.PCI.setText("");
        Dd(false);
      }
    }
  }
  
  private boolean fuM()
  {
    AppMethodBeat.i(273610);
    if (this.PEi)
    {
      AppMethodBeat.o(273610);
      return false;
    }
    this.PEi = true;
    if (this.OXt) {
      if (com.tencent.mm.au.b.OE((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null))) {
        if (!com.tencent.mm.pluginsdk.permission.b.s(this, "android.permission.ACCESS_FINE_LOCATION")) {
          if (!((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXn, Boolean.FALSE)).booleanValue()) {
            com.tencent.mm.plugin.account.sdk.c.a.b(this, getString(R.l.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(273610);
      return true;
      com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_FINE_LOCATION", 64);
      continue;
      this.PEi = false;
      continue;
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_FINE_LOCATION", 64, getString(R.l.gVI));
      Log.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkposition[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this });
      if (bool) {
        this.PEi = false;
      }
      AppMethodBeat.o(273610);
      return bool;
      this.PEi = false;
    }
  }
  
  private void gFj()
  {
    AppMethodBeat.i(28486);
    gXM();
    bh.bCz();
    com.tencent.mm.model.c.a(this);
    bh.bCz();
    com.tencent.mm.model.c.ban().add(this);
    com.tencent.mm.plugin.shake.model.m.gXd().add(this);
    if (this.PCD.Pzs != null) {
      this.PCD.Pzs.resume();
    }
    gXN();
    new MMHandler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28471);
        if (ShakeReportUI.f(ShakeReportUI.this) != null) {
          ShakeReportUI.f(ShakeReportUI.this).iJU();
        }
        AppMethodBeat.o(28471);
      }
    }, 1000L);
    if (this.shakeSensor != null) {
      this.shakeSensor.iJU();
    }
    Dd(false);
    De(false);
    gXP();
    bh.bCz();
    Object localObject = (String)com.tencent.mm.model.c.ban().d(327696, "1");
    if (n.gXa())
    {
      if (this.PDO == 3) {
        CU(true);
      }
      if (((String)localObject).equals("3")) {
        jc(findViewById(R.h.fXc));
      }
    }
    boolean bool;
    if (((String)localObject).equals("2"))
    {
      jc(findViewById(R.h.fWY));
      bool = com.tencent.mm.aa.c.aYo().dW(262154, 266258);
      if ((!getIntent().getBooleanExtra("shake_music", false)) || (!com.tencent.mm.aw.e.bLs()) || (this.PCD.Pzr == 2)) {
        break label377;
      }
      getIntent().putExtra("shake_music", false);
      this.PDO = 2;
    }
    for (;;)
    {
      gXO();
      Da(true);
      Log.d("MicroMsg.ShakeReportUI", "isShakeGetConfigList = %s", new Object[] { Boolean.valueOf(z.pCc) });
      if (z.pCc)
      {
        localObject = new com.tencent.mm.modelpackage.p(7);
        bh.aZW().a((com.tencent.mm.am.p)localObject, 0);
      }
      gYa();
      gXX();
      AppMethodBeat.o(28486);
      return;
      if (((String)localObject).equals("5"))
      {
        if (!com.tencent.mm.plugin.shake.shakecard.b.a.gXC()) {
          break;
        }
        jc(findViewById(R.h.fWL));
        break;
      }
      if (!((String)localObject).equals("1")) {
        break;
      }
      jc(findViewById(R.h.fWP));
      break;
      label377:
      if ((getIntent().getBooleanExtra("shake_tv", false)) && (this.PCD.Pzr != 3) && (n.gXa()))
      {
        getIntent().putExtra("shake_tv", false);
        this.PDO = 3;
      }
      else if ((this.PCD.Pzr != 5) && (com.tencent.mm.plugin.shake.shakecard.b.a.gXC()) && ((bool) || (getIntent().getBooleanExtra("shake_card", false))))
      {
        this.PDZ = getIntent().getIntExtra("shake_card", 0);
        getIntent().putExtra("shake_card", false);
        Log.i("MicroMsg.ShakeReportUI", "onresume shake card tab is open, activity type is 0 or open from specialview");
        this.PDO = 5;
      }
    }
  }
  
  private void gXL()
  {
    AppMethodBeat.i(28492);
    if (com.tencent.mm.aw.e.bLt())
    {
      bh.bCz();
      if (com.tencent.mm.model.c.ban().getInt(4118, 0) == 0)
      {
        com.tencent.mm.ui.widget.a.e.a locala = new com.tencent.mm.ui.widget.a.e.a(getContext());
        locala.aEK(R.l.app_tip);
        locala.aEO(R.l.gVw);
        locala.aER(R.l.gVv).c(new ShakeReportUI.25(this));
        locala.NC(true);
        locala.e(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(273548);
            bh.bCz();
            com.tencent.mm.model.c.ban().setInt(4118, 1);
            ShakeReportUI.j(ShakeReportUI.this).setVisibility(8);
            AppMethodBeat.o(273548);
          }
        });
        this.PDA = locala.jHH();
        this.PDA.show();
      }
    }
    AppMethodBeat.o(28492);
  }
  
  private void gXM()
  {
    AppMethodBeat.i(28493);
    bh.bCz();
    int j = Util.nullAs((Integer)com.tencent.mm.model.c.ban().d(12290, null), 0);
    if ((this.PDz != null) && (!this.PDz.isRecycled())) {
      this.PDz.recycle();
    }
    bh.bCz();
    Object localObject;
    WeImageView localWeImageView;
    if (!Util.nullAsTrue((Boolean)com.tencent.mm.model.c.ban().d(4110, null)))
    {
      this.PDl = true;
      this.PDk.setVisibility(0);
      bh.bCz();
      this.PDz = r.Sg((String)com.tencent.mm.model.c.ban().d(4111, null));
      this.PDk.setImageDrawable(new BitmapDrawable(this.PDz));
      this.PDn.setVisibility(0);
      localObject = y.bi("assets:///flower_song.wxam", 0, -1);
      this.PDj.g((byte[])localObject, "");
      localObject = y.bi("assets:///flower_people_and_tv.wxam", 0, -1);
      this.PDi.g((byte[])localObject, "");
      localObject = (WeImageView)findViewById(R.h.fWi);
      localWeImageView = (WeImageView)findViewById(R.h.fWh);
      if (j != 2) {
        break label286;
      }
      i = R.g.fph;
      label210:
      ((WeImageView)localObject).setImageResource(i);
      if (j != 2) {
        break label293;
      }
    }
    label286:
    label293:
    for (int i = R.g.fpg;; i = R.g.fpe)
    {
      localWeImageView.setImageResource(i);
      View.OnClickListener local3 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(273587);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeReportUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          if (!ShakeReportUI.k(ShakeReportUI.this))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(273587);
            return;
          }
          ShakeReportUI.a(ShakeReportUI.this, false);
          ShakeReportUI.b(ShakeReportUI.this, true);
          ShakeReportUI.l(ShakeReportUI.this);
          paramAnonymousView = ShakeReportUI.this.getContext();
          localObject = ShakeReportUI.this.getString(R.l.gVx);
          k.d local1 = new k.d()
          {
            public final void qz(int paramAnonymous2Int)
            {
              AppMethodBeat.i(273553);
              ShakeReportUI.a(ShakeReportUI.this, true);
              switch (paramAnonymous2Int)
              {
              }
              for (;;)
              {
                AppMethodBeat.o(273553);
                return;
                com.tencent.mm.plugin.shake.a locala = com.tencent.mm.plugin.shake.a.PyM;
                com.tencent.mm.plugin.shake.a.a(13, null);
                t.d(ShakeReportUI.this, 1, null);
              }
            }
          };
          new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(273554);
              ShakeReportUI.a(ShakeReportUI.this, true);
              AppMethodBeat.o(273554);
            }
          };
          k.c(paramAnonymousView, null, new String[] { localObject }, "", local1);
          paramAnonymousView = com.tencent.mm.plugin.shake.a.PyM;
          com.tencent.mm.plugin.shake.a.a(12, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(273587);
        }
      };
      ((WeImageView)localObject).setOnClickListener(local3);
      localWeImageView.setOnClickListener(local3);
      AppMethodBeat.o(28493);
      return;
      this.PDl = false;
      this.PDk.setVisibility(8);
      this.PDn.setVisibility(8);
      break;
      i = R.g.fpf;
      break label210;
    }
  }
  
  private void gXN()
  {
    AppMethodBeat.i(28494);
    this.PCz = true;
    if ((this.PEa != null) && (this.PEa.isShowing()) && (!this.PEa.PAz)) {
      this.PCz = false;
    }
    Log.i("MicroMsg.ShakeReportUI", "tryStartShake");
    if ((this.shakeSensor != null) && (!this.shakeSensor.hdD()))
    {
      this.shakeSensor.a(new a(this));
      if ((this.shakeSensor.hdE()) && (this.PCH != null))
      {
        this.PCH.setText(getString(R.l.gVc));
        AppMethodBeat.o(28494);
        return;
      }
      this.PCH.setText(getString(R.l.gVH));
    }
    AppMethodBeat.o(28494);
  }
  
  private void gXO()
  {
    AppMethodBeat.i(28496);
    if ((this.PDO == 2) && (com.tencent.mm.aw.e.bLs()))
    {
      this.PDO = 2;
      this.PCJ.setText(R.l.gVL);
      this.PDo = R.l.gVL;
      this.PDK.setBackgroundResource(R.g.fpd);
      CV(true);
      CW(false);
      CX(false);
      CZ(false);
      CY(false);
      if (this.PCy)
      {
        MMHandler.createFreeHandler(getMainLooper()).postDelayed(new ShakeReportUI..ExternalSyntheticLambda3(this), 400L);
        findViewById(R.h.fWF).setVisibility(0);
        com.tencent.mm.plugin.report.service.h.OAn.b(11720, new Object[] { Integer.valueOf(2) });
        com.tencent.mm.plugin.report.service.h.OAn.p(834L, 2L, 1L);
      }
    }
    for (;;)
    {
      l.b localb = this.PCD.a(this, this.PDO, this);
      if (!this.PCx) {
        De(false);
      }
      if ((localb instanceof com.tencent.mm.plugin.shake.c.a.m)) {
        ((com.tencent.mm.plugin.shake.c.a.m)localb).PAT = this.PAT;
      }
      if ((com.tencent.mm.plugin.shake.shakecard.b.a.gXC()) && ((localb instanceof com.tencent.mm.plugin.shake.shakecard.a.f)))
      {
        ((com.tencent.mm.plugin.shake.shakecard.a.f)localb).setFromScene(this.PDZ);
        if (this.PDZ == 3)
        {
          Log.i("MicroMsg.ShakeReportUI", "open shake card from specialview");
          ((com.tencent.mm.plugin.shake.shakecard.a.f)localb).QX(getIntent().getStringExtra("key_shake_card_ext_info"));
        }
      }
      AppMethodBeat.o(28496);
      return;
      this.PCK.setBackgroundColor(com.tencent.mm.cd.a.w(getContext(), R.e.fkY));
      break;
      if ((this.PDO == 3) && (n.gXa()))
      {
        this.PDO = 3;
        this.PCJ.setText(R.l.gVM);
        this.PDo = R.l.gVM;
        CX(true);
        CV(false);
        CW(false);
        CZ(false);
        CY(false);
        if (this.PCy) {
          MMHandler.createFreeHandler(getMainLooper()).postDelayed(new ShakeReportUI..ExternalSyntheticLambda4(this), 1500L);
        }
        for (;;)
        {
          findViewById(R.h.fWF).setVisibility(0);
          com.tencent.mm.plugin.report.service.h.OAn.b(11720, new Object[] { Integer.valueOf(3) });
          com.tencent.mm.plugin.report.service.h.OAn.p(834L, 3L, 1L);
          new mz();
          break;
          this.PCK.setBackgroundColor(0);
        }
      }
      if ((this.PDO == 4) && (gXY()))
      {
        this.PDO = 4;
        this.PCJ.setText(R.l.gVK);
        this.PDo = R.l.gVK;
        CX(false);
        CW(false);
        CV(false);
        CY(true);
        CZ(false);
        findViewById(R.h.fWF).setVisibility(0);
        com.tencent.mm.plugin.report.service.h.OAn.b(11720, new Object[] { Integer.valueOf(4) });
        com.tencent.mm.plugin.report.service.h.OAn.p(834L, 4L, 1L);
      }
      else
      {
        if ((this.PDO != 5) || (!com.tencent.mm.plugin.shake.shakecard.b.a.gXC())) {
          break label660;
        }
        this.PDO = 5;
        this.PCJ.setText(R.l.gVJ);
        this.PDo = R.l.gVJ;
        CX(false);
        CV(false);
        CW(false);
        CZ(true);
        CY(false);
        findViewById(R.h.fWF).setVisibility(0);
        gXT();
        gXW();
        com.tencent.mm.plugin.report.service.h.OAn.b(11720, new Object[] { Integer.valueOf(5) });
        com.tencent.mm.plugin.report.service.h.OAn.p(834L, 5L, 1L);
      }
    }
    label660:
    this.PDO = 1;
    this.PCJ.setText(R.l.gVk);
    this.PDo = R.l.gVk;
    CW(true);
    CX(false);
    CV(false);
    CZ(false);
    CY(false);
    if (this.PCy) {
      MMHandler.createFreeHandler(getMainLooper()).postDelayed(new ShakeReportUI..ExternalSyntheticLambda5(this), 1500L);
    }
    for (;;)
    {
      if (com.tencent.mm.aw.e.bLs()) {
        findViewById(R.h.fWF).setVisibility(0);
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(11720, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.plugin.report.service.h.OAn.p(834L, 1L, 1L);
      break;
      this.PCK.setBackgroundColor(0);
    }
  }
  
  private void gXP()
  {
    AppMethodBeat.i(28497);
    bh.bCz();
    this.PCw = Util.nullAsTrue((Boolean)com.tencent.mm.model.c.ban().d(4112, null));
    if (this.PCw)
    {
      setTitleMuteIconVisibility(8);
      AppMethodBeat.o(28497);
      return;
    }
    setTitleMuteIconVisibility(0);
    AppMethodBeat.o(28497);
  }
  
  private void gXQ()
  {
    AppMethodBeat.i(273594);
    if (!this.PCy)
    {
      AppMethodBeat.o(273594);
      return;
    }
    Animation.AnimationListener local10 = new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(28459);
        ShakeReportUI.B(ShakeReportUI.this);
        ShakeReportUI.e(ShakeReportUI.this, false);
        ShakeReportUI.d(ShakeReportUI.this, false);
        AppMethodBeat.o(28459);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(28458);
        AppMethodBeat.o(28458);
      }
    };
    this.PCX = false;
    if ((this.PDO == 2) && (com.tencent.mm.aw.e.bLs()))
    {
      if (this.PCW == null)
      {
        this.PCW = AnimationUtils.loadAnimation(getContext(), R.a.fjI);
        this.PCW.setAnimationListener(local10);
      }
      if (this.PCU == null) {
        this.PCU = AnimationUtils.loadAnimation(getContext(), R.a.fjL);
      }
      this.PCM.startAnimation(this.PCU);
      this.PCL.startAnimation(this.PCW);
      AppMethodBeat.o(273594);
      return;
    }
    if (this.PCS == null)
    {
      this.PCS = AnimationUtils.loadAnimation(getContext(), R.a.fjH);
      this.PCS.setAnimationListener(local10);
    }
    if (this.PCR == null) {
      this.PCR = AnimationUtils.loadAnimation(getContext(), R.a.fjM);
    }
    this.PCM.startAnimation(this.PCR);
    this.PCL.startAnimation(this.PCS);
    AppMethodBeat.o(273594);
  }
  
  private boolean gXR()
  {
    AppMethodBeat.i(273606);
    if (this.PEi)
    {
      AppMethodBeat.o(273606);
      return false;
    }
    this.PEi = true;
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, getString(R.l.gVU));
    Log.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this });
    if (bool) {
      this.PEi = false;
    }
    AppMethodBeat.o(273606);
    return bool;
  }
  
  private void gXS()
  {
    AppMethodBeat.i(28517);
    if (com.tencent.mm.plugin.shake.shakecard.b.a.gXC())
    {
      if (com.tencent.mm.aa.c.aYo().dW(262155, 266259))
      {
        this.PDM.setVisibility(0);
        AppMethodBeat.o(28517);
        return;
      }
      this.PDM.setVisibility(8);
    }
    AppMethodBeat.o(28517);
  }
  
  private void gXT()
  {
    AppMethodBeat.i(28518);
    if ((this.PDO == 5) && (com.tencent.mm.plugin.shake.shakecard.b.a.gXC()))
    {
      boolean bool1 = com.tencent.mm.aa.c.aYo().dW(262154, 266258);
      boolean bool2 = com.tencent.mm.aa.c.aYo().dW(262155, 266259);
      if (bool1)
      {
        cL(com.tencent.mm.plugin.shake.shakecard.b.a.gXy(), true);
        AppMethodBeat.o(28518);
        return;
      }
      if (bool2)
      {
        cL(com.tencent.mm.plugin.shake.shakecard.b.a.gXA(), true);
        AppMethodBeat.o(28518);
        return;
      }
      if (!this.PEb)
      {
        if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.shakecard.b.a.gXw()))
        {
          cL(com.tencent.mm.plugin.shake.shakecard.b.a.gXw(), true);
          AppMethodBeat.o(28518);
          return;
        }
        cL(getString(R.l.gVf), true);
      }
    }
    AppMethodBeat.o(28518);
  }
  
  private void gXU()
  {
    AppMethodBeat.i(28520);
    if ((this.PEa != null) && (this.PEa.isShowing())) {
      this.PEa.dismiss();
    }
    this.PEa = null;
    AppMethodBeat.o(28520);
  }
  
  private void gXV()
  {
    int m = 1;
    AppMethodBeat.i(28521);
    boolean bool1 = com.tencent.mm.plugin.shake.shakecard.b.a.gWX();
    boolean bool2 = com.tencent.mm.aa.c.aYo().dW(262154, 266258);
    boolean bool3 = com.tencent.mm.aa.c.aYo().dW(262155, 266259);
    if (getIntent().getBooleanExtra("shake_card", false)) {}
    for (int i = getIntent().getIntExtra("shake_card", 0);; i = 0)
    {
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
      int j;
      if (bool2)
      {
        j = 1;
        if (!bool1) {
          break label231;
        }
        k = 1;
        label87:
        localh.b(11668, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), com.tencent.mm.plugin.shake.shakecard.b.a.gXz(), Integer.valueOf(com.tencent.mm.plugin.shake.shakecard.b.a.gXv()) });
        localh = com.tencent.mm.plugin.report.service.h.OAn;
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
        localh.b(11668, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), com.tencent.mm.plugin.shake.shakecard.b.a.gXz(), Integer.valueOf(com.tencent.mm.plugin.shake.shakecard.b.a.gXv()) });
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
  
  private void gXW()
  {
    AppMethodBeat.i(28522);
    if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.shakecard.b.a.gXx())) {
      this.PDN.setText(com.tencent.mm.plugin.shake.shakecard.b.a.gXx());
    }
    AppMethodBeat.o(28522);
  }
  
  private void gXX()
  {
    AppMethodBeat.i(28523);
    label123:
    Object localObject;
    label166:
    int i;
    if (com.tencent.mm.aw.e.bLs())
    {
      Log.i("MicroMsg.ShakeReportUI", "is not oversea user, show shake music");
      this.PEc.put(Integer.valueOf(2), Boolean.TRUE);
      findViewById(R.h.fWY).setVisibility(0);
      if (com.tencent.mm.aw.e.bLt())
      {
        bh.bCz();
        if (com.tencent.mm.model.c.ban().getInt(4118, 0) == 0) {
          this.PDL.setVisibility(0);
        }
      }
      else
      {
        if (!n.gXa()) {
          break label267;
        }
        this.PEc.put(Integer.valueOf(3), Boolean.TRUE);
        findViewById(R.h.fXc).setVisibility(0);
        Log.i("MicroMsg.ShakeReportUI", "show shake tv tab");
        if (!com.tencent.mm.plugin.shake.shakecard.b.a.gXC()) {
          break label308;
        }
        this.PEc.put(Integer.valueOf(5), Boolean.TRUE);
        findViewById(R.h.fWL).setVisibility(0);
        Log.i("MicroMsg.ShakeReportUI", "show shake card tab");
        localObject = this.PEc.values().iterator();
        i = 0;
        label183:
        if (!((Iterator)localObject).hasNext()) {
          break label349;
        }
        if (!((Boolean)((Iterator)localObject).next()).booleanValue()) {
          break label477;
        }
        i += 1;
      }
    }
    label267:
    label308:
    label477:
    for (;;)
    {
      break label183;
      this.PDL.setVisibility(8);
      break;
      this.PEc.put(Integer.valueOf(2), Boolean.FALSE);
      findViewById(R.h.fWY).setVisibility(8);
      Log.i("MicroMsg.ShakeReportUI", "is oversea user, hide shake music");
      break;
      this.PEc.put(Integer.valueOf(3), Boolean.FALSE);
      findViewById(R.h.fXc).setVisibility(8);
      Log.i("MicroMsg.ShakeReportUI", "hide shake tv tab");
      break label123;
      findViewById(R.h.fWL).setVisibility(8);
      this.PEc.put(Integer.valueOf(5), Boolean.FALSE);
      Log.i("MicroMsg.ShakeReportUI", "hide shake card tab");
      break label166;
      label349:
      this.PDP = i;
      localObject = (LinearLayout)findViewById(R.h.fWF);
      if (i == 1) {
        ((LinearLayout)localObject).setVisibility(8);
      }
      while ((i > 4) && (this.PEj))
      {
        findViewById(R.h.fXc).setVisibility(8);
        Log.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() > 0.");
        this.PDP -= 1;
        AppMethodBeat.o(28523);
        return;
        ((LinearLayout)localObject).setVisibility(0);
      }
      if ((i > 4) && (!this.PEj))
      {
        this.PEd = false;
        this.PDP -= 1;
        Log.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() <= 0.");
      }
      AppMethodBeat.o(28523);
      return;
    }
  }
  
  private boolean gXY()
  {
    AppMethodBeat.i(28524);
    Log.i("MicroMsg.ShakeReportUI", "[shakezb] isChineseAppLang :" + LocaleUtil.isChineseAppLang() + " ,getApplicationLanguage[en or zh_CN or zh_HK or zh_TW is avaliable] :" + LocaleUtil.getApplicationLanguage());
    if ((this.PEd) && (gXZ()))
    {
      AppMethodBeat.o(28524);
      return true;
    }
    AppMethodBeat.o(28524);
    return false;
  }
  
  private static boolean gXZ()
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
  
  private void gYa()
  {
    AppMethodBeat.i(273626);
    this.PDQ.setVisibility(8);
    AppMethodBeat.o(273626);
  }
  
  private void jc(View paramView)
  {
    AppMethodBeat.i(28509);
    if (paramView == null)
    {
      AppMethodBeat.o(28509);
      return;
    }
    cL("", false);
    if (this.PCX) {
      gXQ();
    }
    if (paramView.getId() == R.h.fWP)
    {
      fuM();
      com.tencent.mm.plugin.report.service.h.OAn.b(11722, new Object[] { Integer.valueOf(1) });
      if (this.PDO != 1)
      {
        if (this.PDO == 3) {
          CU(false);
        }
        this.PDO = 1;
        gXO();
        Db(false);
        if (this.PCF != null) {
          this.PCF.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      Da(true);
      De(false);
      gYa();
      AppMethodBeat.o(28509);
      return;
      if (paramView.getId() == R.h.fWY)
      {
        gXR();
        com.tencent.mm.plugin.report.service.h.OAn.b(11722, new Object[] { Integer.valueOf(2) });
        if ((!this.lsB) && (this.lsy != null))
        {
          this.lsy.a(this.lsF, true, false);
          com.tencent.mm.plugin.report.service.l.kK(22, 10);
        }
        if ((!com.tencent.mm.n.a.dm(this)) && (!com.tencent.mm.n.a.dl(this)) && (!com.tencent.mm.n.a.dp(this)) && (this.PDO != 2))
        {
          if (this.PDO == 3) {
            CU(false);
          }
          this.PDO = 2;
          gXO();
          Db(false);
          if (this.PCF != null) {
            this.PCF.setVisibility(8);
          }
        }
        gXL();
        paramView = com.tencent.mm.plugin.shake.a.PyM;
        com.tencent.mm.plugin.shake.a.a(251, null);
      }
      else if (paramView.getId() == R.h.fXc)
      {
        gXR();
        com.tencent.mm.plugin.report.service.h.OAn.b(11722, new Object[] { Integer.valueOf(3) });
        if ((!this.lsB) && (this.lsy != null))
        {
          this.lsy.a(this.lsF, true, false);
          com.tencent.mm.plugin.report.service.l.kK(22, 10);
        }
        if ((!com.tencent.mm.n.a.dm(this)) && (!com.tencent.mm.n.a.dl(this)) && (!com.tencent.mm.n.a.dp(this)) && (this.PDO != 3))
        {
          CU(true);
          this.PDO = 3;
          gXO();
          Db(false);
          if (this.PCF != null) {
            this.PCF.setVisibility(8);
          }
        }
        paramView = com.tencent.mm.plugin.shake.a.PyM;
        com.tencent.mm.plugin.shake.a.a(301, null);
      }
      else if ((paramView.getId() == R.h.fWV) || (paramView.getId() == R.h.fWR))
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(11722, new Object[] { Integer.valueOf(4) });
        if (this.PDO != 4)
        {
          this.PDO = 4;
          gXO();
          Db(false);
          if (this.PCF != null) {
            this.PCF.setVisibility(8);
          }
          if ((!Build.VERSION.RELEASE.equals("6.0")) && (!Build.VERSION.RELEASE.equals("6.0.0")) && (Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.modelgeo.d.bJm())) {
            aVT(getString(R.l.gVq));
          }
          paramView = BluetoothAdapter.getDefaultAdapter();
          if ((paramView != null) && (paramView.getState() != 12)) {
            aVT(getString(R.l.gVp));
          } else if (paramView == null) {
            aVT(getString(R.l.gVt));
          }
        }
      }
      else if (paramView.getId() == R.h.fWL)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(11722, new Object[] { Integer.valueOf(5) });
        if (this.PDO != 5)
        {
          if (this.PDO == 3) {
            CU(false);
          }
          this.PDO = 5;
          gXO();
          Db(false);
          if (this.PCF != null) {
            this.PCF.setVisibility(8);
          }
          com.tencent.mm.aa.c.aYo().R(262155, false);
          this.PDM.setVisibility(8);
        }
      }
    }
  }
  
  public final void a(int paramInt, final com.tencent.mm.plugin.shake.shakecard.a.d paramd, long paramLong)
  {
    AppMethodBeat.i(28507);
    this.PEb = true;
    if (paramInt == 1251)
    {
      if (paramd == null)
      {
        AppMethodBeat.o(28507);
        return;
      }
      Log.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_GetLbsCard");
      com.tencent.mm.plugin.shake.shakecard.b.a.gWW();
      gXX();
      gXS();
      gXV();
      this.PDZ = 4;
      com.tencent.mm.plugin.shake.model.m.gXj().z("key_shake_card_item", paramd);
      AppMethodBeat.o(28507);
      return;
    }
    Object localObject;
    if (paramInt == 1250)
    {
      if (paramd == null)
      {
        this.PDD = null;
        aVT(null);
        AppMethodBeat.o(28507);
        return;
      }
      if (((paramd == null) || (this.PCx)) && (!this.PCx))
      {
        this.PDD = null;
        aVT(null);
        AppMethodBeat.o(28507);
        return;
      }
      this.PCx = false;
      Log.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_ShakeCard");
      if (this.PCD.Pzr == 5)
      {
        localObject = this.PCD.Pzs;
        if ((localObject != null) && ((localObject instanceof com.tencent.mm.plugin.shake.shakecard.a.f)))
        {
          localObject = (com.tencent.mm.plugin.shake.shakecard.a.f)localObject;
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
      if (((com.tencent.mm.plugin.shake.shakecard.a.f)localObject).wuj == 3)
      {
        Log.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is  MMBIZ_SHAKE_CARD_ACTION_TYPE_NO_CARD");
        if ((paramd != null) && (!TextUtils.isEmpty(paramd.PzU)))
        {
          aVT(paramd.PzU);
          AppMethodBeat.o(28507);
          return;
        }
        aVT(getString(R.l.gVe));
        AppMethodBeat.o(28507);
        return;
      }
      Log.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is " + ((com.tencent.mm.plugin.shake.shakecard.a.f)localObject).wuj);
      ajk(3);
      if (paramd.wuj == 1) {
        this.PCz = false;
      }
      if ((this.PEa != null) && (this.PEa.isShowing()))
      {
        AppMethodBeat.o(28507);
        return;
      }
      if (paramd.PzW)
      {
        localObject = (ViewStub)findViewById(R.h.gcf);
        if (localObject != null) {
          ((ViewStub)localObject).inflate();
        }
        ((ShakeEggAnimFrame)findViewById(R.h.fvK)).bm(this);
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28462);
            ShakeReportUI.a(ShakeReportUI.this, paramd);
            AppMethodBeat.o(28462);
          }
        }, 1000L);
        AppMethodBeat.o(28507);
        return;
      }
      a(paramd);
      AppMethodBeat.o(28507);
      return;
      Log.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_ERR_REPORT");
      aVT(getString(R.l.gVe));
    }
  }
  
  public final void g(List<com.tencent.mm.plugin.shake.model.d> paramList, long paramLong)
  {
    AppMethodBeat.i(28506);
    gXQ();
    gYa();
    if ((paramList == null) || (!this.PCx) || (paramLong == 6L))
    {
      this.PDD = null;
      if (paramLong == 6L)
      {
        aVT(getString(R.l.gVu));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 7L)
      {
        aVT(getString(R.l.gVs));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 8L)
      {
        aVT(getString(R.l.gVq));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 9L)
      {
        aVT(getString(R.l.gVp));
        AppMethodBeat.o(28506);
        return;
      }
      if (paramLong == 10L)
      {
        aVT(getString(R.l.gVt));
        AppMethodBeat.o(28506);
        return;
      }
      aVT(null);
      AppMethodBeat.o(28506);
      return;
    }
    this.PCx = false;
    if (paramList.size() > 0) {
      this.PDD = ((com.tencent.mm.plugin.shake.model.d)paramList.get(0));
    }
    int i;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    label548:
    Object localObject4;
    Object localObject5;
    Object localObject6;
    if (this.PCD.Pzr == 1)
    {
      if ((paramList.size() > 0) && (((com.tencent.mm.plugin.shake.model.d)paramList.get(0)).field_type != 0))
      {
        aVT(null);
        AppMethodBeat.o(28506);
        return;
      }
      this.PCB = ((com.tencent.mm.plugin.shake.model.d)paramList.get(0)).scene;
      i = paramList.size();
      if (i == 0)
      {
        aVT(null);
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        localObject1 = (com.tencent.mm.plugin.shake.model.d)paramList.get(0);
        paramList = ((com.tencent.mm.plugin.shake.model.d)localObject1).field_username;
        localObject2 = ((com.tencent.mm.plugin.shake.model.d)localObject1).field_nickname;
        Log.i("MicroMsg.ShakeReportUI", "1 u:" + paramList + " n:" + (String)localObject2 + " d:" + ((com.tencent.mm.plugin.shake.model.d)localObject1).field_distance);
        if (this.PCw) {
          PlaySound.play(getContext(), R.l.shake_match);
        }
        ajk(3);
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.shake.model.d)localObject1).field_username))
        {
          this.PCF.setTag(((com.tencent.mm.plugin.shake.model.d)localObject1).field_username);
          this.PCF.setVisibility(0);
          bh.bCz();
          localObject2 = com.tencent.mm.model.c.bzA().JE(((com.tencent.mm.plugin.shake.model.d)localObject1).field_username);
          localObject3 = new StringBuilder().append(((com.tencent.mm.plugin.shake.model.d)localObject1).field_nickname);
          if (!com.tencent.mm.contact.d.rs(((az)localObject2).field_type)) {
            break label1003;
          }
          paramList = getString(R.l.gVB);
          localObject3 = paramList;
          if (((com.tencent.mm.plugin.shake.model.d)localObject1).field_sex != 1) {
            break label1010;
          }
          this.PCF.setContentDescription((String)localObject3 + ((com.tencent.mm.plugin.shake.model.d)localObject1).field_distance + getContext().getString(R.l.shake_sex_male));
          localObject4 = (TextView)this.PCF.findViewById(R.h.fWl);
          localObject5 = getContext();
          localObject6 = new StringBuilder().append(((com.tencent.mm.plugin.shake.model.d)localObject1).field_nickname);
          if (!com.tencent.mm.contact.d.rs(((az)localObject2).field_type)) {
            break label1098;
          }
          paramList = getString(R.l.gVB);
          label605:
          ((TextView)localObject4).setText(com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject5, paramList, ((TextView)localObject4).getTextSize()));
          if (this.lKK != null)
          {
            if (Util.isNullOrNil((String)localObject3)) {
              break label1105;
            }
            this.lKK.setContentDescription(String.format(getString(R.l.shake_avatar), new Object[] { localObject3 }));
          }
          label670:
          ((TextView)this.PCF.findViewById(R.h.fWj)).setText(((com.tencent.mm.plugin.shake.model.d)localObject1).field_distance);
          com.tencent.mm.pluginsdk.ui.a.b.g((ImageView)this.PCF.findViewById(R.h.fWk), ((com.tencent.mm.plugin.shake.model.d)localObject1).field_username);
          paramList = (ImageView)this.PCF.findViewById(R.h.fWn);
          if (((com.tencent.mm.plugin.shake.model.d)localObject1).field_reserved1 == 0) {
            break label1122;
          }
          paramList.setVisibility(0);
          paramList.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile(az.a.okR.vd(((com.tencent.mm.plugin.shake.model.d)localObject1).field_reserved1), 2.0F));
          label760:
          if ((((com.tencent.mm.plugin.shake.model.d)localObject1).field_reserved1 != 0) || (((com.tencent.mm.plugin.shake.model.d)localObject1).field_sex == 0)) {
            break label1139;
          }
          if (((com.tencent.mm.plugin.shake.model.d)localObject1).field_sex != 1) {
            break label1131;
          }
          i = R.k.ic_sex_male;
          label790:
          paramList = com.tencent.mm.cd.a.m(this, i);
          this.PCF.findViewById(R.h.fWm).setVisibility(0);
          ((ImageView)this.PCF.findViewById(R.h.fWm)).setImageDrawable(paramList);
          label828:
          if (((com.tencent.mm.plugin.shake.model.d)localObject1).getProvince() == null)
          {
            Log.e("MicroMsg.ShakeReportUI", "PROVINCE NULL");
            ((com.tencent.mm.plugin.shake.model.d)localObject1).field_province = "";
          }
          if (((com.tencent.mm.plugin.shake.model.d)localObject1).getCity() == null)
          {
            Log.e("MicroMsg.ShakeReportUI", "CITY NULL");
            ((com.tencent.mm.plugin.shake.model.d)localObject1).field_city = "";
          }
          this.PCF.startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.fjC));
          paramList = new mz();
          paramList.jcL = this.PCD.gXb();
          localObject2 = paramList.vv(((com.tencent.mm.plugin.shake.model.d)localObject1).field_username);
          ((mz)localObject2).jcH = this.PDD.field_sex;
          if (!Util.isNullOrNil(this.PDD.field_signature)) {
            break label1157;
          }
        }
        label1157:
        for (paramLong = 1L;; paramLong = 2L)
        {
          ((mz)localObject2).jcJ = paramLong;
          ((mz)localObject2).vw(((com.tencent.mm.plugin.shake.model.d)localObject1).field_distance);
          paramList.jcG = 1L;
          paramList.jcL = this.PCD.gXb();
          localObject1 = com.tencent.mm.plugin.shake.a.PyM;
          com.tencent.mm.plugin.shake.a.a(3, paramList);
          AppMethodBeat.o(28506);
          return;
          label1003:
          paramList = "";
          break;
          label1010:
          if (((com.tencent.mm.plugin.shake.model.d)localObject1).field_sex == 2)
          {
            this.PCF.setContentDescription((String)localObject3 + ((com.tencent.mm.plugin.shake.model.d)localObject1).field_distance + getContext().getString(R.l.shake_sex_female));
            break label548;
          }
          this.PCF.setContentDescription((String)localObject3 + ((com.tencent.mm.plugin.shake.model.d)localObject1).field_distance);
          break label548;
          label1098:
          paramList = "";
          break label605;
          label1105:
          this.lKK.setContentDescription(getString(R.l.shake_avatar_unknow));
          break label670;
          label1122:
          paramList.setVisibility(8);
          break label760;
          label1131:
          i = R.k.ic_sex_female;
          break label790;
          label1139:
          this.PCF.findViewById(R.h.fWm).setVisibility(8);
          break label828;
        }
      }
      if (this.PCw) {
        PlaySound.play(getContext(), R.l.shake_match);
      }
      ajk(3);
      Db(false);
      paramList = new Intent(this, ShakeItemListUI.class);
      paramList.putExtra("_key_show_type_", -1);
      paramList.putExtra("_key_title_", getString(R.l.gVA));
      paramList = new com.tencent.mm.hellhoundlib.b.a().cG(paramList);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramList.aYi(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramList.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI", "onShakeGetReturn", "(Ljava/util/List;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(28506);
      return;
    }
    float f;
    if (this.PCD.Pzr == 2)
    {
      i = paramList.size();
      if (i == 0)
      {
        aVT(getString(R.l.gVG));
        AppMethodBeat.o(28506);
        return;
      }
      if (i == 1)
      {
        if (this.PCw) {
          PlaySound.play(getContext(), R.l.shake_match);
        }
        ajk(3);
        if (((com.tencent.mm.plugin.shake.model.d)paramList.get(0)).field_type == 4)
        {
          localObject2 = new dlk();
          localObject3 = System.currentTimeMillis();
          localObject1 = new mz();
          ((mz)localObject1).jcL = this.PCD.gXb();
          ((mz)localObject1).jcM = ((mz)localObject1).F("SharkSessionID", (String)localObject3, true);
          do
          {
            try
            {
              ((dlk)localObject2).parseFrom(((com.tencent.mm.plugin.shake.model.d)paramList.get(0)).field_lvbuffer);
              if ((((dlk)localObject2).aaRA != null) && (((dlk)localObject2).aaRA.size() == 1))
              {
                localObject5 = (dli)((dlk)localObject2).aaRA.get(0);
                localObject6 = com.tencent.mm.plugin.shake.c.a.l.a((dli)localObject5);
                localObject4 = new Intent();
                paramList = Long.valueOf(System.currentTimeMillis() - this.startTime);
                if (((dli)localObject5).ZTB != null)
                {
                  com.tencent.mm.aw.a.d((com.tencent.mm.aw.f)localObject6);
                  ((Intent)localObject4).putExtra("key_copyright", true);
                  paramList = Long.valueOf(paramList.longValue() + 700L);
                  ((Intent)localObject4).putExtra("copyright_report", 1);
                  ((mz)localObject1).jcT = 1L;
                  f = ((com.tencent.mm.aw.f)localObject6).oOw;
                  ((Intent)localObject4).putExtra("key_offset", Float.parseFloat(String.valueOf(paramList)) + f);
                  ((Intent)localObject4).putExtra("key_pure", ((dli)localObject5).aaRw);
                  ((Intent)localObject4).putExtra("key_byuser", ((dli)localObject5).type);
                  ((Intent)localObject4).putExtra("key_duration", ((dli)localObject5).aaRq);
                  paramList = com.tencent.mm.plugin.shake.a.PyM;
                  ((Intent)localObject4).putExtra("report_sessionid", com.tencent.mm.plugin.shake.a.gWF());
                  ((Intent)localObject4).putExtra("shake_sessionid", (String)localObject3);
                  if (this.tie != null) {
                    ((Intent)localObject4).putExtra("key_hasPre", true);
                  }
                  com.tencent.mm.br.c.b(this, "mv", ".ui.shake.MusicMainUINew", (Intent)localObject4, 4);
                }
              }
              while (((dlk)localObject2).aaRA == null) {
                for (;;)
                {
                  if ((((dlk)localObject2).aaRA != null) && (((dlk)localObject2).aaRA.size() > 0))
                  {
                    paramList = (dli)((dlk)localObject2).aaRA.get(0);
                    ((mz)localObject1).jcQ = ((mz)localObject1).F("ToSongDataurl", paramList.ZTB, true);
                    ((mz)localObject1).jcP = ((mz)localObject1).F("ToSongWeburl", paramList.ZTB, true);
                    ((mz)localObject1).jcN = ((mz)localObject1).F("ToSongName", paramList.ZTw, true);
                    ((mz)localObject1).jcO = ((mz)localObject1).F("ToSongSinger", paramList.ZTx, true);
                    ((mz)localObject1).jcF = ((mz)localObject1).F("ToSongOrTv", paramList.ZTv, true);
                    paramList = com.tencent.mm.plugin.shake.a.PyM;
                    com.tencent.mm.plugin.shake.a.a(3, (mz)localObject1);
                  }
                  AppMethodBeat.o(28506);
                  return;
                  com.tencent.mm.aw.a.d((com.tencent.mm.aw.f)localObject6);
                  paramList = Long.valueOf(paramList.longValue() + 800L);
                  ((Intent)localObject4).putExtra("copyright_report", 3);
                  ((mz)localObject1).jcT = 3L;
                }
              }
            }
            catch (IOException paramList)
            {
              AppMethodBeat.o(28506);
              return;
            }
          } while (((dlk)localObject2).aaRA.size() <= 1);
          paramList = (dli)((dlk)localObject2).aaRA.get(0);
          localObject4 = com.tencent.mm.plugin.shake.c.a.l.a(paramList);
          com.tencent.mm.aw.a.d((com.tencent.mm.aw.f)localObject4);
          localObject5 = new ArrayList();
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (i < ((dlk)localObject2).aaRA.size())
      {
        localObject6 = com.tencent.mm.plugin.shake.c.a.l.a((dli)((dlk)localObject2).aaRA.get(i));
        if (localObject4 != null) {
          ((List)localObject5).add(localObject6);
        }
      }
      else
      {
        localObject6 = new Intent();
        paramLong = System.currentTimeMillis();
        long l = this.startTime;
        f = ((com.tencent.mm.aw.f)localObject4).oOw;
        ((Intent)localObject6).putExtra("key_offset", Float.parseFloat(String.valueOf(Long.valueOf(paramLong - l))) + f + 800.0F);
        ((Intent)localObject6).putExtra("key_pure", paramList.aaRw);
        ((Intent)localObject6).putExtra("key_recommend_list", (Serializable)localObject5);
        ((Intent)localObject6).putExtra("key_byuser", paramList.type);
        ((Intent)localObject6).putExtra("key_duration", paramList.aaRq);
        ((Intent)localObject6).putExtra("duration", paramList.aaRq);
        paramList = com.tencent.mm.plugin.shake.a.PyM;
        ((Intent)localObject6).putExtra("report_sessionid", com.tencent.mm.plugin.shake.a.gWF());
        ((Intent)localObject6).putExtra("shake_sessionid", (String)localObject3);
        ((Intent)localObject6).putExtra("copyright_report", 2);
        if (this.tie != null) {
          ((Intent)localObject6).putExtra("key_hasPre", true);
        }
        com.tencent.mm.br.c.b(this, "mv", ".ui.shake.MusicMainUINew", (Intent)localObject6, 4);
        ((mz)localObject1).jcT = 2L;
        break;
        Log.w("MicroMsg.ShakeReportUI", "Unexpected type, ignore.");
        AppMethodBeat.o(28506);
        return;
        if (this.PCD.Pzr == 3)
        {
          gYa();
          i = paramList.size();
          if (i == 0)
          {
            aVT(getString(R.l.gVV));
            AppMethodBeat.o(28506);
            return;
          }
          if (i == 1)
          {
            if (this.PCw) {
              PlaySound.play(getContext(), R.l.shake_match);
            }
            ajk(3);
            paramList = (com.tencent.mm.plugin.shake.model.d)paramList.get(0);
            new MMHandler().postDelayed(new n.1(paramList, this), 100L);
            paramList = new mz();
            paramList.jcG = 1L;
            paramList.jcL = this.PCD.gXb();
            localObject1 = com.tencent.mm.plugin.shake.a.PyM;
            com.tencent.mm.plugin.shake.a.a(3, paramList);
          }
        }
        AppMethodBeat.o(28506);
        return;
      }
      i += 1;
    }
  }
  
  public final void gXm()
  {
    AppMethodBeat.i(28516);
    com.tencent.mm.plugin.shake.shakecard.b.a.gWW();
    gXS();
    gXT();
    gXW();
    gXX();
    gXV();
    AppMethodBeat.o(28516);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.gof;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28491);
    com.tencent.mm.plugin.shake.shakecard.b.a.gWW();
    this.PEc.put(Integer.valueOf(1), Boolean.TRUE);
    this.PEc.put(Integer.valueOf(2), Boolean.FALSE);
    this.PEc.put(Integer.valueOf(3), Boolean.FALSE);
    this.PEc.put(Integer.valueOf(4), Boolean.FALSE);
    this.PEc.put(Integer.valueOf(5), Boolean.FALSE);
    this.oJu = new com.tencent.mm.modelimage.loader.a(this);
    this.PCH = ((TextView)findViewById(R.h.fWJ));
    this.PCG = findViewById(R.h.fXe);
    this.PCI = ((TextView)findViewById(R.h.fWA));
    this.PCJ = ((TextView)findViewById(R.h.fWI));
    this.PDQ = findViewById(R.h.fXs);
    this.PDR = ((ImageView)findViewById(R.h.fXg));
    this.PDS = ((ImageView)findViewById(R.h.fXi));
    this.PDT = ((ImageView)findViewById(R.h.fXk));
    this.PDU = ((ImageView)findViewById(R.h.fXm));
    this.PDV = findViewById(R.h.fXh);
    this.PDW = findViewById(R.h.fXj);
    this.PDX = findViewById(R.h.fXl);
    this.PDY = findViewById(R.h.fXn);
    this.PDb = findViewById(R.h.fWz);
    this.PDi = ((MMAnimateView)findViewById(R.h.fWB));
    this.PDa = findViewById(R.h.fWv);
    this.PCZ = findViewById(R.h.fOT);
    this.PDj = ((MMAnimateView)findViewById(R.h.fWH));
    this.PDc = findViewById(R.h.fWx);
    this.PDd = findViewById(R.h.fWw);
    this.PCK = findViewById(R.h.fXt);
    this.PCL = findViewById(R.h.fWc);
    this.PCN = findViewById(R.h.fWy);
    this.PDp = ((WeImageView)findViewById(R.h.fRB));
    this.PDq = ((WeImageView)findViewById(R.h.fRC));
    this.PDr = ((WeImageView)findViewById(R.h.fOS));
    this.PDs = ((WeImageView)findViewById(R.h.fOU));
    this.PCF = findViewById(R.h.fWG);
    this.PCF.setOnClickListener(this.PEl);
    this.PDk = ((ImageView)findViewById(R.h.fWC));
    this.PDm = ((TextView)findViewById(R.h.fWE));
    this.PDn = ((TextView)findViewById(R.h.fWD));
    this.lKK = ((ImageView)this.PCF.findViewById(R.h.fWk));
    this.lKK.setOnClickListener(new ShakeReportUI.22(this));
    gXM();
    Object localObject = View.inflate(getContext(), R.i.goc, null);
    this.PDA = new i(getContext(), R.m.mmalertdialog);
    this.PDA.setContentView((View)localObject);
    this.PDA.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(273547);
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
        {
          public final boolean queueIdle()
          {
            AppMethodBeat.i(273569);
            aa.s(ShakeReportUI.this, ShakeReportUI.this.getString(R.l.gVP));
            bh.bCz();
            com.tencent.mm.model.c.ban().B(4117, Boolean.TRUE);
            AppMethodBeat.o(273569);
            return false;
          }
        });
        AppMethodBeat.o(273547);
      }
    });
    ((Button)((View)localObject).findViewById(R.h.fWe)).setOnClickListener(new ShakeReportUI.28(this));
    bh.bCz();
    boolean bool1 = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.ban().d(4108, Boolean.TRUE));
    bh.bCz();
    boolean bool2 = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.ban().d(4117, null));
    if (!bool1)
    {
      ((View)localObject).setVisibility(0);
      this.PDA.show();
      bh.bCz();
      com.tencent.mm.model.c.ban().B(4108, Boolean.TRUE);
      int i = com.tencent.mm.cd.a.mt(getContext());
      int k = com.tencent.mm.cd.a.ms(getContext());
      int j = bf.getStatusBarHeight(this);
      k -= 50;
      localObject = (RelativeLayout.LayoutParams)this.PDi.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)(i * 0.35D), 0, 0);
      this.PDi.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int m = com.tencent.mm.cd.a.bs(getContext(), R.f.Edge_14A);
      localObject = (RelativeLayout.LayoutParams)this.PDm.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)(i * 0.35D) + m, 0, 0);
      this.PDm.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.PDa.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)(0.2D * i), 0, 0);
      ((RelativeLayout.LayoutParams)localObject).height = k;
      this.PDa.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (FrameLayout.LayoutParams)this.PDn.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).setMargins(0, (int)(i * 0.35D) + m, 0, 0);
      this.PDn.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.PDc.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = k;
      ((RelativeLayout.LayoutParams)localObject).height = k;
      this.PDc.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.PCK.setPadding(0, j, 0, 0);
      this.PCZ.setPadding(0, j, 0, 0);
      localObject = new ShakeReportUI..ExternalSyntheticLambda0(this);
      ShakeReportUI..ExternalSyntheticLambda1 localExternalSyntheticLambda1 = new ShakeReportUI..ExternalSyntheticLambda1(this);
      this.PDp.setOnClickListener((View.OnClickListener)localObject);
      this.PDr.setOnClickListener((View.OnClickListener)localObject);
      this.PDq.setOnClickListener(localExternalSyntheticLambda1);
      this.PDs.setOnClickListener(localExternalSyntheticLambda1);
      localObject = new ShakeReportUI.24(this);
      if ((!this.PEg) && (!this.PEe)) {
        break label1301;
      }
      this.PDB = ((WeImageView)findViewById(R.h.fWU));
    }
    for (this.PDC = ((TextView)findViewById(R.h.fWW));; this.PDC = ((TextView)findViewById(R.h.fWS)))
    {
      this.PDE = ((WeImageView)findViewById(R.h.fWO));
      this.PDF = ((TextView)findViewById(R.h.fWQ));
      this.PDG = ((WeImageView)findViewById(R.h.fWX));
      this.PDH = ((TextView)findViewById(R.h.fXa));
      this.PDI = ((WeImageView)findViewById(R.h.fXb));
      this.PDJ = ((TextView)findViewById(R.h.fXd));
      this.PDK = ((WeImageView)findViewById(R.h.fWK));
      this.PDN = ((TextView)findViewById(R.h.fWN));
      this.PDM = ((ImageView)findViewById(R.h.fWM));
      this.PDL = ((ImageView)findViewById(R.h.fWZ));
      gXW();
      findViewById(R.h.fWV).setOnClickListener((View.OnClickListener)localObject);
      findViewById(R.h.fWP).setOnClickListener((View.OnClickListener)localObject);
      findViewById(R.h.fWY).setOnClickListener((View.OnClickListener)localObject);
      findViewById(R.h.fXc).setOnClickListener((View.OnClickListener)localObject);
      findViewById(R.h.fWL).setOnClickListener((View.OnClickListener)localObject);
      gXS();
      gXV();
      gYa();
      AppMethodBeat.o(28491);
      return;
      if (bool2) {
        break;
      }
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(273583);
          aa.s(ShakeReportUI.this, ShakeReportUI.this.getString(R.l.gVP));
          bh.bCz();
          com.tencent.mm.model.c.ban().B(4117, Boolean.TRUE);
          AppMethodBeat.o(273583);
          return false;
        }
      });
      break;
      label1301:
      this.PDB = ((WeImageView)findViewById(R.h.fWT));
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
    if ((this.PDv != null) && (this.PDv.getTag() != null) && (paramString.equals((String)this.PDv.getTag()))) {
      this.PDv.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(28515);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(28510);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28510);
      return;
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
      bh.bCz();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.model.c.bzL() + "custom_shake_img_filename.jpg");
      com.tencent.mm.plugin.shake.b.pFn.a(localIntent, 2, this, paramIntent);
      AppMethodBeat.o(28510);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(28510);
        return;
      }
      paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
      bh.bCz();
      com.tencent.mm.model.c.ban().B(4110, Boolean.FALSE);
      bh.bCz();
      com.tencent.mm.model.c.ban().B(4111, paramIntent);
      gXM();
      AppMethodBeat.o(28510);
      return;
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acXn, Boolean.TRUE);
          com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_FINE_LOCATION", 64);
          this.OXt = false;
          AppMethodBeat.o(28510);
          return;
        }
        this.OXt = true;
        finish();
        AppMethodBeat.o(28510);
        return;
      }
      this.OXt = true;
      finish();
      AppMethodBeat.o(28510);
      return;
      if ((paramInt2 == 1) && (this.tie != null))
      {
        com.tencent.mm.aw.a.c(this.tie);
        paramIntent = this.tie;
        com.tencent.mm.plugin.music.model.b.aOT(paramIntent.oOM);
        localIntent = new Intent();
        localIntent.putExtra("key_mv_song_name", paramIntent.oOx);
        localIntent.putExtra("key_mv_song_lyric", paramIntent.oOE);
        localIntent.putExtra("key_mv_album_cover_url", paramIntent.oOA);
        com.tencent.mm.plugin.music.model.b.aK(localIntent.getExtras());
        paramIntent = com.tencent.mm.plugin.music.model.c.LLZ;
        com.tencent.mm.plugin.music.model.c.gnP();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28484);
    com.tencent.mm.pluginsdk.h.w(this);
    super.onCreate(paramBundle);
    setActionbarColor(0);
    getWindow().getDecorView().setSystemUiVisibility(1792);
    com.tencent.mm.ui.statusbar.d.g(getWindow());
    hideActionbarLine();
    hideActionBarOperationArea();
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    setNavigationbarColor(0);
    paramBundle = com.tencent.mm.plugin.shake.a.PyM;
    com.tencent.mm.plugin.shake.a.agL(getIntent().getIntExtra("enter_from_scene", 1));
    hideTitleView();
    hideActionbarLine();
    this.lsy = com.tencent.mm.modelgeo.d.bJl();
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acJf, "");
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acJg, "");
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acLM, "");
    paramBundle = com.tencent.mm.plugin.shake.model.m.gXi();
    if (paramBundle.eNV == null) {
      paramBundle.eNV = new ArrayList();
    }
    paramBundle.eNV.add(new WeakReference(this));
    initView();
    this.PCC = new c(getBodyView());
    this.shakeSensor = new com.tencent.mm.pluginsdk.l.d();
    if (!this.shakeSensor.hdE()) {
      k.a(this, R.l.gVH, R.l.app_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(28461);
          ShakeReportUI.this.finish();
          AppMethodBeat.o(28461);
        }
      });
    }
    if (com.tencent.mm.plugin.shake.b.pFo != null) {
      com.tencent.mm.plugin.shake.b.pFo.aDx();
    }
    r.b(this);
    Log.i("MicroMsg.ShakeReportUI", "%s", new Object[] { getResources().getDisplayMetrics().toString() });
    int i = com.tencent.mm.plugin.shake.model.m.gXe().dkF();
    com.tencent.mm.plugin.report.service.h.OAn.b(11317, new Object[] { Integer.valueOf(i), e.gYf() });
    com.tencent.mm.plugin.report.service.h.OAn.b(11710, new Object[] { Integer.valueOf(1) });
    com.tencent.mm.plugin.report.service.h.OAn.p(834L, 0L, 1L);
    paramBundle = com.tencent.mm.plugin.shake.a.PyM;
    com.tencent.mm.plugin.shake.a.a(1, null);
    this.PAT = new ShakeReportUI..ExternalSyntheticLambda2(this);
    AppMethodBeat.o(28484);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28488);
    if ((this.PDz != null) && (!this.PDz.isRecycled())) {
      this.PDz.recycle();
    }
    if ((this.PDA != null) && (this.PDA.isShowing()))
    {
      this.PDA.dismiss();
      this.PDA = null;
    }
    if (this.PCD.Pzs != null) {
      this.PCD.Pzs.gWH();
    }
    if (this.shakeSensor != null)
    {
      this.shakeSensor.cuD();
      this.shakeSensor = null;
    }
    com.tencent.mm.plugin.shake.c.a.m.a(null);
    com.tencent.mm.plugin.shake.c.a.m.PBC = null;
    r.c(this);
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acLB, Boolean.FALSE);
    if (com.tencent.mm.plugin.shake.shakecard.b.a.gXC()) {
      com.tencent.mm.aa.c.aYo().R(262154, false);
    }
    gXU();
    Object localObject = com.tencent.mm.plugin.shake.model.m.gXi();
    int i;
    if (((com.tencent.mm.plugin.shake.shakecard.a.e)localObject).eNV != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < ((com.tencent.mm.plugin.shake.shakecard.a.e)localObject).eNV.size())
      {
        WeakReference localWeakReference = (WeakReference)((com.tencent.mm.plugin.shake.shakecard.a.e)localObject).eNV.get(i);
        if (localWeakReference != null)
        {
          com.tencent.mm.plugin.shake.shakecard.a.e.a locala = (com.tencent.mm.plugin.shake.shakecard.a.e.a)localWeakReference.get();
          if ((locala != null) && (locala.equals(this))) {
            ((com.tencent.mm.plugin.shake.shakecard.a.e)localObject).eNV.remove(localWeakReference);
          }
        }
      }
      else
      {
        localObject = com.tencent.mm.plugin.shake.model.m.gXj();
        ((com.tencent.mm.plugin.shake.shakecard.a.c)localObject).lsz = -85.0F;
        ((com.tencent.mm.plugin.shake.shakecard.a.c)localObject).lsA = -1000.0F;
        if (this.lsy != null) {
          this.lsy.a(this.lsF);
        }
        this.rDF.dead();
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
    gXP();
    if (!this.PCy) {
      Da(true);
    }
    AppMethodBeat.o(28511);
  }
  
  public void onNotifyUserStatusChange()
  {
    AppMethodBeat.i(28504);
    gXO();
    AppMethodBeat.o(28504);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(28487);
    bh.bCz();
    com.tencent.mm.model.c.b(this);
    bh.bCz();
    com.tencent.mm.model.c.ban().remove(this);
    com.tencent.mm.plugin.shake.model.m.gXd().remove(this);
    if (this.PCD.Pzs != null) {
      this.PCD.Pzs.pause();
    }
    this.PCz = false;
    if (this.shakeSensor != null) {
      this.shakeSensor.cuD();
    }
    this.PCC.gXI();
    if (this.PDO != 4)
    {
      bh.bCz();
      com.tencent.mm.model.c.ban().B(327696, this.PDO);
    }
    if (this.PDO == 3) {
      CU(false);
    }
    this.rDF.dead();
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
      if (paramArrayOfInt[0] == 0)
      {
        this.PEi = false;
        AppMethodBeat.o(28527);
        return;
      }
      k.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(273561);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.pluginsdk.permission.b.lx(ShakeReportUI.this.getContext());
          ShakeReportUI.J(ShakeReportUI.this);
          AppMethodBeat.o(273561);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(28468);
          paramAnonymousDialogInterface.dismiss();
          ShakeReportUI.J(ShakeReportUI.this);
          AppMethodBeat.o(28468);
        }
      });
      AppMethodBeat.o(28527);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        gFj();
        this.PEi = false;
        AppMethodBeat.o(28527);
        return;
      }
      this.OXt = false;
      k.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(28469);
          com.tencent.mm.pluginsdk.permission.b.lx(ShakeReportUI.this.getContext());
          ShakeReportUI.K(ShakeReportUI.this);
          ShakeReportUI.J(ShakeReportUI.this);
          AppMethodBeat.o(28469);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(28470);
          ShakeReportUI.K(ShakeReportUI.this);
          ShakeReportUI.J(ShakeReportUI.this);
          AppMethodBeat.o(28470);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28485);
    super.onResume();
    this.rDF.alive();
    gFj();
    AppMethodBeat.o(28485);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(274097);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.shake.a.a.class);
    AppMethodBeat.o(274097);
  }
  
  static final class a
    extends d.a
  {
    WeakReference<ShakeReportUI> PEr;
    private final long[] VIRBRATOR_PATTERN;
    private long lastShakeTime;
    private Vibrator uAL;
    
    public a(ShakeReportUI paramShakeReportUI)
    {
      AppMethodBeat.i(28481);
      this.lastShakeTime = Util.currentTicks();
      this.VIRBRATOR_PATTERN = new long[] { 300L, 200L, 300L, 200L };
      this.PEr = new WeakReference(paramShakeReportUI);
      AppMethodBeat.o(28481);
    }
    
    public final void onRelease() {}
    
    public final void onShake(boolean paramBoolean)
    {
      AppMethodBeat.i(28482);
      ShakeReportUI localShakeReportUI = (ShakeReportUI)this.PEr.get();
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
      if (!ShakeReportUI.m(localShakeReportUI))
      {
        Log.i("MicroMsg.ShakeReportUI", "tryShake the status is can's shake");
        AppMethodBeat.o(28482);
        return;
      }
      ShakeReportUI.n(localShakeReportUI);
      if (ShakeReportUI.g(localShakeReportUI) == 1) {
        paramBoolean = ShakeReportUI.o(localShakeReportUI);
      }
      for (;;)
      {
        if (!paramBoolean)
        {
          AppMethodBeat.o(28482);
          return;
          if ((ShakeReportUI.g(localShakeReportUI) == 2) || (ShakeReportUI.g(localShakeReportUI) == 3)) {
            paramBoolean = ShakeReportUI.p(localShakeReportUI);
          }
        }
        else
        {
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
          if (ShakeReportUI.q(localShakeReportUI) != null)
          {
            localObject = ShakeReportUI.q(localShakeReportUI);
            if (((c)localObject).view != null) {
              ((c)localObject).view.setKeepScreenOn(true);
            }
            ((c)localObject).timer.startTimer(30000L);
          }
          if (ShakeReportUI.r(localShakeReportUI) != null)
          {
            ShakeReportUI.r(localShakeReportUI);
            AppMethodBeat.o(28482);
            throw null;
          }
          if (ShakeReportUI.s(localShakeReportUI))
          {
            localObject = (ShakeReportUI)this.PEr.get();
            if (localObject != null) {
              PlaySound.play((Context)localObject, R.l.shake_sound_male);
            }
          }
          for (;;)
          {
            reset();
            ShakeReportUI.t(localShakeReportUI);
            AppMethodBeat.o(28482);
            return;
            localObject = (ShakeReportUI)this.PEr.get();
            if (localObject != null)
            {
              if (this.uAL == null) {
                this.uAL = ((Vibrator)((ShakeReportUI)localObject).getSystemService("vibrator"));
              }
              if (this.uAL != null) {
                this.uAL.vibrate(this.VIRBRATOR_PATTERN, -1);
              }
            }
          }
        }
        paramBoolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI
 * JD-Core Version:    0.7.0.1
 */