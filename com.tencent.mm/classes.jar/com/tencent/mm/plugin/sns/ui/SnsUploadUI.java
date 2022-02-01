package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.g.b.a.kb;
import com.tencent.mm.g.b.a.ke;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.o.a.a;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.edittext.a.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(17)
public class SnsUploadUI
  extends MMSecDataActivity
  implements LocationWidget.a
{
  private String DMW;
  private com.tencent.mm.ui.widget.cedit.api.c EPE;
  private AtContactWidget EPF;
  private LocationWidget EPG;
  private RangeWidget EPH;
  private SnsUploadSayFooter EPI;
  private DynamicGridView EPJ;
  private boolean EPK;
  private boolean EPL;
  boolean EPM;
  private Map<Integer, ad> EPN;
  private Map<String, List<String>> EPO;
  private Map<String, List<String>> EPP;
  private boolean EPQ;
  private String EPR;
  private long EPS;
  private Runnable EPT;
  private FrameLayout EPU;
  private long EPV;
  private long EPW;
  private int EPX;
  private IListener<kp> EPY;
  private SnsUploadConfigView Eoy;
  private String EsT;
  private boolean EsU;
  private int Etq;
  private int Etr;
  private String EvA;
  private String EvB;
  private String Evz;
  private ad Ewa;
  private LinearLayout Ewb;
  private ArrayList<String> Ewd;
  private boolean Ewe;
  private boolean Ewf;
  private long Ewg;
  private String canvasInfo;
  private String desc;
  private int knv;
  private String mSessionId;
  private boolean thE;
  private int vjQ;
  private KeyboardLinearLayout xbW;
  
  public SnsUploadUI()
  {
    AppMethodBeat.i(99593);
    this.EsU = false;
    this.vjQ = 0;
    this.Ewf = false;
    this.Ewg = 0L;
    this.Ewa = null;
    this.Evz = "";
    this.EvA = "";
    this.EvB = "";
    this.Etq = 0;
    this.Etr = 0;
    this.Ewe = false;
    this.EPK = false;
    this.EPL = false;
    this.EPM = false;
    this.canvasInfo = null;
    this.EsT = "";
    this.thE = false;
    this.EPN = new HashMap();
    this.EPO = new HashMap();
    this.EPP = new HashMap();
    this.EPQ = false;
    this.DMW = "";
    this.EPR = "";
    this.EPS = 3000L;
    this.EPT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176362);
        if ((SnsUploadUI.a(SnsUploadUI.this) != null) && (SnsUploadUI.b(SnsUploadUI.this) != null) && (SnsUploadUI.b(SnsUploadUI.this).ffD()))
        {
          Object localObject = Parcel.obtain();
          SnsUploadUI.this.getIntent().putExtra("Kdescription", SnsUploadUI.a(SnsUploadUI.this).getText().toString());
          SnsUploadUI.this.getIntent().putExtra("KparseLen", SnsUploadUI.a(SnsUploadUI.this).getPasterLen());
          SnsUploadUI.c(SnsUploadUI.this);
          SnsUploadUI.this.getIntent().writeToParcel((Parcel)localObject, 0);
          localObject = ((Parcel)localObject).marshall();
          String str = MD5Util.getMD5String((byte[])localObject);
          Log.d("MicroMsg.SnsUploadUI", "autoSaveDraft lastMd5:%s, newMd5:%s", new Object[] { SnsUploadUI.d(SnsUploadUI.this), str });
          if (!Util.isEqual(SnsUploadUI.d(SnsUploadUI.this), str))
          {
            SnsUploadUI.a(SnsUploadUI.this, str);
            SnsUploadUI.a(SnsUploadUI.this, (byte[])localObject, 1);
          }
          com.tencent.mm.plugin.sns.model.aj.dRd().postDelayed(SnsUploadUI.e(SnsUploadUI.this), SnsUploadUI.f(SnsUploadUI.this));
        }
        AppMethodBeat.o(176362);
      }
    };
    this.EPU = null;
    this.EPV = 0L;
    this.EPW = 0L;
    this.knv = 0;
    this.EPX = 0;
    this.EPY = new SnsUploadUI.18(this);
    AppMethodBeat.o(99593);
  }
  
  private ad ZZ(int paramInt)
  {
    AppMethodBeat.i(99614);
    Object localObject1 = (ad)this.EPN.get(Integer.valueOf(paramInt));
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (paramInt != 0) {
        break label67;
      }
      localObject1 = new aq(this);
    }
    for (;;)
    {
      this.EPN.put(Integer.valueOf(paramInt), localObject1);
      localObject2 = localObject1;
      AppMethodBeat.o(99614);
      return localObject2;
      label67:
      if (paramInt == 14) {
        localObject1 = new al(this);
      }
    }
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    AppMethodBeat.i(203781);
    com.tencent.mm.plugin.websearch.a.b.a(1, 1, z.aTY(), paramString2, 1, "", paramString3, paramInt, paramString1, paramLong);
    AppMethodBeat.o(203781);
  }
  
  private void aF(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(99615);
    Log.i("MicroMsg.SnsUploadUI", "attachWidget. share type %d, isManuSnsPost:%b", new Object[] { Integer.valueOf(this.vjQ), Boolean.valueOf(this.Ewf) });
    Object localObject;
    if ((this.vjQ == 0) || (this.vjQ == 14) || (this.vjQ == 9))
    {
      localObject = Parcel.obtain();
      getIntent().writeToParcel((Parcel)localObject, 0);
      ((Parcel)localObject).marshall();
      if (this.vjQ != 9) {
        break label494;
      }
      setMMTitle(getContext().getResources().getString(2131766259));
    }
    RelativeLayout.LayoutParams localLayoutParams;
    label494:
    int i;
    switch (this.vjQ)
    {
    default: 
    case 0: 
    case 14: 
    case 1: 
    case 11: 
    case 15: 
    case 16: 
    case 18: 
    case 20: 
    case 22: 
    case 24: 
    case 26: 
    case 2: 
    case 25: 
    case 3: 
    case 6: 
    case 4: 
    case 10: 
    case 13: 
    case 12: 
    case 5: 
    case 7: 
      for (;;)
      {
        this.Ewa.aC(paramBundle);
        if (!(this.Ewa instanceof aq)) {
          break label942;
        }
        paramBundle = findViewById(2131308110);
        localObject = findViewById(2131308135);
        this.EPJ = ((DynamicGridView)findViewById(2131308196));
        this.EPJ.setOnTouchListener(new SnsUploadUI.17(this));
        paramBundle = ((aq)this.Ewa).a(paramBundle, findViewById(2131299447), this.EPJ, (View)localObject);
        this.EPJ.setVisibility(0);
        localObject = findViewById(2131310506);
        localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        localLayoutParams.topMargin = 0;
        localLayoutParams.addRule(3, 2131308196);
        ((View)localObject).setLayoutParams(localLayoutParams);
        if (((this.Ewa instanceof ae)) || ((this.Ewa instanceof ag)))
        {
          localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).width = -1;
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if (((this.Ewa instanceof q)) || ((this.Ewa instanceof o)) || ((this.Ewa instanceof p)))
        {
          localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).width = -1;
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        fjN();
        if (this.vjQ == 0) {
          fjK();
        }
        AppMethodBeat.o(99615);
        return;
        setMMTitle("");
        break;
        this.DMW = "draft_normal";
        this.Ewa = ZZ(this.vjQ);
        this.EPE.addTextChangedListener(new SnsUploadUI.15(this));
        continue;
        this.DMW = "draft_normal";
        this.Ewa = ZZ(this.vjQ);
        continue;
        this.Ewa = new ae(this);
        continue;
        this.Ewa = new ak(this);
        continue;
        this.Ewa = new aj(this);
        continue;
        this.Ewa = new ar(this, 9);
        continue;
        this.Ewa = new ar(this, 12);
        continue;
        this.Ewa = new q(this);
        continue;
        this.Ewa = new o(this);
        continue;
        this.Ewa = new r(this);
        continue;
        this.Ewa = new p(this);
        continue;
        this.Ewa = new ar(this, 14);
        continue;
        this.Ewa = new ar(this, 13);
      }
    case 9: 
      this.DMW = "draft_text";
      localObject = Util.nullAs(getIntent().getStringExtra("Kdescription"), "");
      i = Util.nullAs(Integer.valueOf(getIntent().getIntExtra("KparseLen", 0)), 0);
      if ((localObject == null) || (Util.isNullOrNil(((String)localObject).trim()))) {
        break;
      }
    }
    for (;;)
    {
      this.Ewa = new am(this, bool);
      this.EPE.setPasterLen(i);
      this.EPE.setText(com.tencent.mm.ui.g.c.b.c(getContext(), (CharSequence)localObject, this.EPE.getTextSize()));
      this.EPE.addTextChangedListener(new SnsUploadUI.16(this));
      break;
      this.Ewa = new bp(this);
      break;
      this.Ewa = new ag(this);
      break;
      this.Ewa = new u(this);
      break;
      this.Ewa = new ah(this);
      break;
      this.Ewa = new t(this);
      break;
      label942:
      paramBundle = this.Ewa.ffB();
      this.Ewb = ((LinearLayout)findViewById(2131310505));
      this.Ewb.setVisibility(0);
      this.Ewb.setClipChildren(false);
      label1003:
      float f;
      if (paramBundle != null)
      {
        Log.d("MicroMsg.SnsUploadUI", "will add widget view in widgetLL.");
        this.Ewb.addView(paramBundle);
        if ((this.vjQ == 9) || (this.vjQ == 14))
        {
          localObject = findViewById(2131310506);
          localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
          localLayoutParams.addRule(3, 2131310505);
          f = BitmapUtil.getDefaultDisplayMetrics().density;
          if (this.vjQ != 9) {
            break label1101;
          }
        }
      }
      label1101:
      for (i = 128;; i = 96)
      {
        localLayoutParams.topMargin = ((int)(i * f));
        ((View)localObject).setLayoutParams(localLayoutParams);
        break;
        this.Ewb.setVisibility(8);
        break label1003;
      }
      bool = false;
    }
  }
  
  private void aaa(int paramInt)
  {
    AppMethodBeat.i(176389);
    com.tencent.mm.plugin.sns.k.e.DUQ.DVa.xk(this.EsT);
    com.tencent.mm.plugin.sns.k.e.DUQ.DVa.eTw = paramInt;
    if ((paramInt == 3) || (paramInt == 2)) {
      com.tencent.mm.plugin.sns.k.e.DUQ.fcw();
    }
    AppMethodBeat.o(176389);
  }
  
  private void ac(final byte[] paramArrayOfByte, final int paramInt)
  {
    AppMethodBeat.i(203780);
    com.tencent.mm.plugin.sns.model.aj.eJP().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176380);
        long l = System.currentTimeMillis();
        com.tencent.mm.plugin.sns.model.aj.faV().b(SnsUploadUI.h(SnsUploadUI.this), paramArrayOfByte, paramInt);
        Log.i("MicroMsg.SnsUploadUI", "saveDraft draftKey:%s, %s", new Object[] { SnsUploadUI.h(SnsUploadUI.this), Long.valueOf(Util.milliSecondsToNow(l)) });
        AppMethodBeat.o(176380);
      }
    });
    AppMethodBeat.o(203780);
  }
  
  private void amZ()
  {
    AppMethodBeat.i(99601);
    this.Ewf = getIntent().getBooleanExtra("KSnsPostManu", false);
    this.Ewg = getIntent().getLongExtra("KTouchCameraTime", 0L);
    this.vjQ = getIntent().getIntExtra("Ksnsupload_type", 0);
    this.EsU = getIntent().getBooleanExtra("Kis_take_photo", false);
    int i;
    if (this.EsU)
    {
      i = 2;
      this.EPX = i;
      this.EPK = getIntent().getBooleanExtra("need_result", false);
      this.EPL = getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false);
      this.canvasInfo = getIntent().getStringExtra("Ksnsupload_canvas_info");
      this.EsT = getIntent().getStringExtra("KSessionID");
      this.thE = getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
      if (!Util.isNullOrNil(this.EsT)) {
        break label234;
      }
      this.EsT = com.tencent.mm.plugin.sns.data.r.eZx();
      getIntent().putExtra("KSessionID", this.EsT);
    }
    for (;;)
    {
      this.mSessionId = com.tencent.mm.plugin.fts.a.d.Nj(79);
      Object localObject = SecDataUIC.CWq;
      localObject = (com.tencent.mm.plugin.sns.j.j)SecDataUIC.a.c(this, 2, com.tencent.mm.plugin.sns.j.j.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.sns.j.j)localObject).sessionId = this.mSessionId;
      }
      AppMethodBeat.o(99601);
      return;
      i = 1;
      break;
      label234:
      this.EPX = 3;
    }
  }
  
  private void bb(Intent paramIntent)
  {
    List localList2 = null;
    AppMethodBeat.i(99606);
    this.EPH.a(5, -1, paramIntent, this.EPF);
    int i = paramIntent.getIntExtra("Ktag_range_index", 0);
    if (i >= 2)
    {
      this.Evz = paramIntent.getStringExtra("Klabel_name_list");
      this.EvA = paramIntent.getStringExtra("Kother_user_name_list");
      this.EvB = paramIntent.getStringExtra("Kchat_room_name_list");
      if (Util.isNullOrNil(this.Evz)) {
        break label275;
      }
    }
    label275:
    for (paramIntent = Arrays.asList(this.Evz.split(","));; paramIntent = null)
    {
      List localList1;
      if (!Util.isNullOrNil(this.EvA))
      {
        localList1 = Arrays.asList(this.EvA.split(","));
        com.tencent.mm.plugin.sns.k.e.DUQ.gT(localList1);
      }
      for (;;)
      {
        if (!Util.isNullOrNil(this.EvB)) {
          localList2 = Arrays.asList(this.EvB.split(","));
        }
        r(paramIntent, localList1);
        gg(localList2);
        if (i == 2)
        {
          this.Ewe = false;
          if ((this.EPO != null) && (!this.EPO.isEmpty())) {
            com.tencent.mm.plugin.sns.k.e.DUQ.aP(this.EPO);
          }
          if ((this.EPP != null) && (!this.EPP.isEmpty())) {
            com.tencent.mm.plugin.sns.k.e.DUQ.aO(this.EPP);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.k.e.DUQ.YP(i);
          AppMethodBeat.o(99606);
          return;
          this.Ewe = true;
          break;
          if (!Util.isNullOrNil(this.Ewd)) {
            this.Ewd.clear();
          }
        }
        localList1 = null;
      }
    }
  }
  
  private void dAM()
  {
    AppMethodBeat.i(99598);
    final boolean bool = getIntent().getBooleanExtra("KThrid_app", false);
    Object localObject = Util.nullAs(getIntent().getStringExtra("Ksnsupload_appid"), "");
    if (((this.vjQ == 0) && (((aq)this.Ewa).fgG() > 0)) || ((this.vjQ == 14) && ((this.Ewa instanceof al)) && (!((al)this.Ewa).EsV)) || ((this.vjQ == 9) && (!Util.isNullOrNil(this.EPE.getText().toString()))) || (((this.Ewa instanceof u)) && (!((u)this.Ewa).ffF())))
    {
      com.tencent.mm.ui.base.h.a(this, 2131766293, 0, 2131766295, 2131766294, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(99587);
          Log.i("MicroMsg.SnsUploadUI", "exitAndSave shareType:%s realtimeType:%s", new Object[] { Integer.valueOf(SnsUploadUI.i(SnsUploadUI.this)), Integer.valueOf(SnsUploadUI.this.getIntent().getIntExtra("Ksnsupload_type", -1)) });
          SnsUploadUI.a(SnsUploadUI.this, 1);
          paramAnonymousDialogInterface = Parcel.obtain();
          SnsUploadUI.this.getIntent().putExtra("Kdescription", SnsUploadUI.a(SnsUploadUI.this).getText().toString());
          SnsUploadUI.this.getIntent().putExtra("KparseLen", SnsUploadUI.a(SnsUploadUI.this).getPasterLen());
          SnsUploadUI.c(SnsUploadUI.this);
          SnsUploadUI.this.getIntent().writeToParcel(paramAnonymousDialogInterface, 0);
          paramAnonymousDialogInterface = paramAnonymousDialogInterface.marshall();
          SnsUploadUI.a(SnsUploadUI.this, paramAnonymousDialogInterface, 0);
          SnsUploadUI.j(SnsUploadUI.this);
          switch (SnsUploadUI.i(SnsUploadUI.this))
          {
          default: 
            paramAnonymousInt = 0;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(paramAnonymousInt), SnsUploadUI.k(SnsUploadUI.this), Long.valueOf(Util.nowSecond()), Integer.valueOf(1) });
            SnsUploadUI.b(SnsUploadUI.this, 3);
            SnsUploadUI.l(SnsUploadUI.this);
            if (SnsUploadUI.m(SnsUploadUI.this))
            {
              com.tencent.mm.plugin.sns.k.e.DUQ.DVA.eUb = 2L;
              com.tencent.mm.plugin.sns.k.e.DUQ.fcE();
            }
            if ((SnsUploadUI.b(SnsUploadUI.this) instanceof u))
            {
              com.tencent.mm.plugin.sns.k.e.DUQ.DVE.esJ = 3L;
              com.tencent.mm.plugin.sns.k.e.DUQ.fcF();
            }
            if ((bool) && (this.val$appId.equals("wxa5e0de08d96cc09d")))
            {
              com.tencent.mm.plugin.sns.k.e.DUQ.DVG.esJ = 3L;
              com.tencent.mm.plugin.sns.k.e.DUQ.fcG();
            }
            SnsUploadUI.n(SnsUploadUI.this);
            AppMethodBeat.o(99587);
            return;
            paramAnonymousInt = 1;
            continue;
            paramAnonymousInt = 3;
            continue;
            paramAnonymousInt = 5;
          }
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(99588);
          SnsUploadUI.a(SnsUploadUI.this, 2);
          com.tencent.mm.plugin.sns.model.aj.dRd().removeCallbacks(SnsUploadUI.e(SnsUploadUI.this));
          SnsUploadUI.a(SnsUploadUI.this, null, 0);
          SnsUploadUI.j(SnsUploadUI.this);
          paramAnonymousDialogInterface = SnsUploadUI.this.getIntent().getStringExtra("KSightThumbPath");
          Object localObject = SnsUploadUI.this.getIntent().getStringExtra("KSightPath");
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZk, true))
          {
            com.tencent.mm.plugin.recordvideo.e.c localc = com.tencent.mm.plugin.recordvideo.e.c.Cic;
            com.tencent.mm.plugin.recordvideo.e.c.aLG((String)localObject);
            localObject = com.tencent.mm.plugin.recordvideo.e.c.Cic;
            com.tencent.mm.plugin.recordvideo.e.c.aLG(paramAnonymousDialogInterface);
          }
          if ((SnsUploadUI.b(SnsUploadUI.this) instanceof am)) {
            SnsUploadUI.a(SnsUploadUI.this).setText("");
          }
          switch (SnsUploadUI.i(SnsUploadUI.this))
          {
          default: 
            paramAnonymousInt = 0;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(paramAnonymousInt), SnsUploadUI.k(SnsUploadUI.this), Long.valueOf(Util.nowSecond()), Integer.valueOf(0) });
            SnsUploadUI.b(SnsUploadUI.this, 2);
            SnsUploadUI.l(SnsUploadUI.this);
            if (SnsUploadUI.m(SnsUploadUI.this))
            {
              com.tencent.mm.plugin.sns.k.e.DUQ.DVA.eUb = 3L;
              com.tencent.mm.plugin.sns.k.e.DUQ.fcE();
            }
            if ((SnsUploadUI.b(SnsUploadUI.this) instanceof u))
            {
              com.tencent.mm.plugin.sns.k.e.DUQ.DVE.esJ = 3L;
              com.tencent.mm.plugin.sns.k.e.DUQ.fcF();
            }
            if ((bool) && (this.val$appId.equals("wxa5e0de08d96cc09d")))
            {
              com.tencent.mm.plugin.sns.k.e.DUQ.DVG.esJ = 3L;
              com.tencent.mm.plugin.sns.k.e.DUQ.fcG();
            }
            SnsUploadUI.o(SnsUploadUI.this);
            AppMethodBeat.o(99588);
            return;
            paramAnonymousInt = 2;
            continue;
            paramAnonymousInt = 4;
            continue;
            paramAnonymousInt = 6;
          }
        }
      }, 2131099921);
      AppMethodBeat.o(99598);
      return;
    }
    if (((this.Ewa instanceof ae)) || ((this.Ewa instanceof ak)) || ((this.Ewa instanceof aj)))
    {
      if (!Util.isNullOrNil(this.EPE.getText().toString()))
      {
        com.tencent.mm.plugin.sns.model.aj.dRd().removeCallbacks(this.EPT);
        localObject = Parcel.obtain();
        getIntent().putExtra("Kdescription", this.EPE.getText().toString());
        getIntent().putExtra("KparseLen", this.EPE.getPasterLen());
        fjL();
        getIntent().writeToParcel((Parcel)localObject, 0);
        ac(((Parcel)localObject).marshall(), 0);
        com.tencent.mm.plugin.report.service.h.CyF.a(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(7), this.EsT, Long.valueOf(Util.nowSecond()), Integer.valueOf(3) });
      }
      fjP();
      aaa(2);
      if (this.EPQ)
      {
        com.tencent.mm.plugin.sns.k.e.DUQ.DVA.eUb = 2L;
        com.tencent.mm.plugin.sns.k.e.DUQ.fcE();
      }
      fjQ();
      fjM();
      AppMethodBeat.o(99598);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, 2131766292, 0, 2131755312, 2131755761, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(176381);
        com.tencent.mm.plugin.sns.model.aj.dRd().removeCallbacks(SnsUploadUI.e(SnsUploadUI.this));
        SnsUploadUI.a(SnsUploadUI.this, null, 0);
        SnsUploadUI.j(SnsUploadUI.this);
        SnsUploadUI.b(SnsUploadUI.this, 2);
        SnsUploadUI.l(SnsUploadUI.this);
        if (SnsUploadUI.m(SnsUploadUI.this))
        {
          com.tencent.mm.plugin.sns.k.e.DUQ.DVA.eUb = 3L;
          com.tencent.mm.plugin.sns.k.e.DUQ.fcE();
        }
        if ((SnsUploadUI.b(SnsUploadUI.this) instanceof u))
        {
          com.tencent.mm.plugin.sns.k.e.DUQ.DVE.esJ = 3L;
          com.tencent.mm.plugin.sns.k.e.DUQ.fcF();
        }
        if ((bool) && (this.val$appId.equals("wxa5e0de08d96cc09d")))
        {
          com.tencent.mm.plugin.sns.k.e.DUQ.DVG.esJ = 3L;
          com.tencent.mm.plugin.sns.k.e.DUQ.fcG();
        }
        SnsUploadUI.o(SnsUploadUI.this);
        AppMethodBeat.o(176381);
      }
    }, null, 2131099922);
    AppMethodBeat.o(99598);
  }
  
  @TargetApi(11)
  private void fjK()
  {
    AppMethodBeat.i(99596);
    if (!(this.Ewa instanceof aq))
    {
      Log.e("MicroMsg.SnsUploadUI", "!(widget instanceof PicWidget)");
      AppMethodBeat.o(99596);
      return;
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      Log.d("MicroMsg.SnsUploadUI", "sdk not support dragdrop event");
      AppMethodBeat.o(99596);
      return;
    }
    new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99582);
        View.OnDragListener local1 = new View.OnDragListener()
        {
          public final boolean onDrag(View paramAnonymous2View, DragEvent paramAnonymous2DragEvent)
          {
            AppMethodBeat.i(99581);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymous2View);
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymous2DragEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
            boolean bool = false;
            int i = paramAnonymous2DragEvent.getAction();
            switch (i)
            {
            default: 
              Log.e("MicroMsg.SnsUploadUI", "Unknown action type received by OnDragListener.");
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
              AppMethodBeat.o(99581);
              return bool;
              bool = true;
              Log.i("MicroMsg.SnsUploadUI", "ACTION: [%s]", new Object[] { Integer.valueOf(i) });
              continue;
              Log.i("MicroMsg.SnsUploadUI", "ACTION_DROP");
              paramAnonymous2View = paramAnonymous2DragEvent.getClipData();
              if (paramAnonymous2View != null)
              {
                int j = paramAnonymous2View.getItemCount();
                paramAnonymous2DragEvent = new ArrayList();
                i = 0;
                if (i < j)
                {
                  Object localObject2 = paramAnonymous2View.getItemAt(i);
                  if (localObject2 == null) {
                    Log.e("MicroMsg.SnsUploadUI", "item == null");
                  }
                  for (;;)
                  {
                    i += 1;
                    break;
                    if (((ClipData.Item)localObject2).getIntent() != null)
                    {
                      localObject1 = SnsUploadUI.this;
                      localObject2 = ((ClipData.Item)localObject2).getIntent();
                      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
                      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      ((SnsUploadUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
                      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    else if (((ClipData.Item)localObject2).getUri() != null)
                    {
                      localObject1 = new com.tencent.mm.pluginsdk.ui.tools.t(SnsUploadUI.this.getContext(), ((ClipData.Item)localObject2).getUri());
                      if ((((com.tencent.mm.pluginsdk.ui.tools.t)localObject1).fileType != 0) && (((com.tencent.mm.pluginsdk.ui.tools.t)localObject1).filePath != null)) {}
                      switch (((com.tencent.mm.pluginsdk.ui.tools.t)localObject1).fileType)
                      {
                      default: 
                        break;
                      case 3: 
                        paramAnonymous2DragEvent.add(((com.tencent.mm.pluginsdk.ui.tools.t)localObject1).filePath);
                        continue;
                        Log.e("MicroMsg.SnsUploadUI", "get file path failed");
                      }
                    }
                  }
                }
                if (paramAnonymous2DragEvent.size() < 0)
                {
                  Log.e("MicroMsg.SnsUploadUI", "no image file available");
                  com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
                  AppMethodBeat.o(99581);
                  return true;
                }
                ((aq)SnsUploadUI.b(SnsUploadUI.this)).c(paramAnonymous2DragEvent, 0, false);
                bool = true;
              }
              else
              {
                bool = true;
              }
            }
          }
        };
        if (SnsUploadUI.g(SnsUploadUI.this) != null) {
          SnsUploadUI.g(SnsUploadUI.this).setOnDragListener(local1);
        }
        AppMethodBeat.o(99582);
      }
    }.run();
    AppMethodBeat.o(99596);
  }
  
  private void fjL()
  {
    AppMethodBeat.i(203779);
    getIntent().putExtra("Kis_retry_edit", false);
    AppMethodBeat.o(203779);
  }
  
  private void fjM()
  {
    AppMethodBeat.i(99599);
    if (this.thE)
    {
      com.tencent.mm.plugin.sns.k.e locale = com.tencent.mm.plugin.sns.k.e.DUQ;
      com.tencent.mm.plugin.sns.k.e.a(10, "", 0, 0, cl.aWz(), 0);
    }
    setResult(0, new Intent());
    finish();
    com.tencent.mm.plugin.sns.data.r.eZy();
    AppMethodBeat.o(99599);
  }
  
  private void fjP()
  {
    AppMethodBeat.i(176388);
    if (this.vjQ == 9)
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NUY, this.EsT);
      AppMethodBeat.o(176388);
      return;
    }
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NUX, this.EsT);
    AppMethodBeat.o(176388);
  }
  
  private void fjQ()
  {
    AppMethodBeat.i(176390);
    com.tencent.mm.plugin.expt.b.c localc = (com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class);
    localc.gk("startTime", this.EPW);
    localc.gk("endTime", Util.nowMilliSecond());
    localc.gk("bussinessId", this.EsT);
    localc.gk("shareType", this.vjQ);
    localc.gk("hadLocation", this.EPG.getShowFlag());
    localc.gk("desc", this.EPE.getText().toString());
    localc.gk("nextStep", this.knv);
    localc.gk("beforeStep", this.EPX);
    localc.gk("ContactTagCount", this.Etq);
    localc.gk("mIsBlackGroup", this.Ewe);
    if (this.Ewd != null)
    {
      localObject1 = this.Ewd.size();
      localc.gk("mContactNameList", (String)localObject1);
      if (!(this.Ewa instanceof aq)) {
        break label425;
      }
      Object localObject2 = ((aq)this.Ewa).fgI();
      if ((localObject2 == null) || (((Map)localObject2).isEmpty())) {
        break label425;
      }
      localObject1 = new StringBuilder();
      localObject2 = ((Map)localObject2).values().iterator();
      label357:
      if (!((Iterator)localObject2).hasNext()) {
        break label412;
      }
      if (!((Boolean)((Iterator)localObject2).next()).booleanValue()) {
        break label407;
      }
    }
    label407:
    for (int i = 1;; i = 2)
    {
      ((StringBuilder)localObject1).append(i).append("#");
      break label357;
      localObject1 = "0";
      break;
    }
    label412:
    localc.gk("picSource", ((StringBuilder)localObject1).toString());
    label425:
    if ((this.Ewa instanceof al)) {
      if (!((al)this.Ewa).fgb()) {
        break label469;
      }
    }
    label469:
    for (Object localObject1 = "1";; localObject1 = "2")
    {
      localc.gk("sightSource", (String)localObject1);
      AppMethodBeat.o(176390);
      return;
    }
  }
  
  private void gg(List<String> paramList)
  {
    AppMethodBeat.i(99607);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(99607);
      return;
    }
    this.EPP.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str1 = (String)paramList.next();
      ArrayList localArrayList = new ArrayList();
      Object localObject = v.Id(str1);
      if (localObject != null)
      {
        Log.d("MicroMsg.SnsUploadUI", "getContactNamesFromChatroom chatromm:%s membersCount:%s", new Object[] { str1, Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          if ((!this.Ewd.contains(str2)) && (ab.IS(str2)))
          {
            Log.i("MicroMsg.SnsUploadUI", "getContactNamesFromChatroom memberName:%s", new Object[] { str2 });
            this.Ewd.add(str2);
            this.Etr += 1;
          }
          if (ab.IS(str2)) {
            localArrayList.add(str2);
          }
        }
        Log.d("MicroMsg.SnsUploadUI", "%s , %s", new Object[] { str1, Integer.valueOf(localArrayList.size()) });
        this.EPP.put(str1, localArrayList);
      }
    }
    AppMethodBeat.o(99607);
  }
  
  private void r(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(99608);
    this.Ewd = new ArrayList();
    this.Etq = 0;
    this.EPO.clear();
    HashSet localHashSet;
    String str1;
    List localList;
    int i;
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      Iterator localIterator1 = paramList1.iterator();
      localHashSet = new HashSet();
      if (localIterator1.hasNext())
      {
        str1 = (String)localIterator1.next();
        localList = com.tencent.mm.plugin.label.a.a.ecg().aCK(com.tencent.mm.plugin.label.a.a.ecg().aCH(str1));
        if ((localList == null) || (localList.size() == 0)) {
          Log.e("MicroMsg.SnsUploadUI", "dz: getContactNamesFromLabelsAndOtherUserName,namelist get bu label is null");
        }
      }
      else
      {
        this.Ewd = new ArrayList(localHashSet);
      }
    }
    else
    {
      if (paramList1 == null) {
        break label276;
      }
      paramList1 = paramList1.iterator();
      i = 0;
      label153:
      if (!paramList1.hasNext()) {
        break label271;
      }
      if (Util.isNullOrNil((String)paramList1.next())) {
        break label360;
      }
      i += 1;
    }
    label271:
    label276:
    label360:
    for (;;)
    {
      break label153;
      Iterator localIterator2 = localList.iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localHashSet.add(str2);
        this.Etq += 1;
        Log.d("MicroMsg.SnsUploadUI", "dz:name : %s", new Object[] { str2 });
      }
      this.EPO.put(str1, localList);
      break;
      this.Etq = i;
      this.Etr = 0;
      if ((paramList2 != null) && (paramList2.size() > 0))
      {
        paramList1 = paramList2.iterator();
        while (paramList1.hasNext())
        {
          paramList2 = (String)paramList1.next();
          if (!this.Ewd.contains(paramList2))
          {
            this.Ewd.add(paramList2);
            this.Etr += 1;
          }
        }
      }
      AppMethodBeat.o(99608);
      return;
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(99612);
    Log.i("MicroMsg.SnsUploadUI", "updateSightConfig");
    getIntent().getExtras().clear();
    getIntent().putExtra("KSightPath", paramString1);
    getIntent().putExtra("KSightThumbPath", paramString2);
    getIntent().putExtra("sight_md5", paramString3);
    getIntent().putExtra("KSnsPostManu", true);
    getIntent().putExtra("Ksnsupload_type", 14);
    getIntent().putExtra("Kis_take_photo", false);
    getIntent().putExtra("KMMSightExtInfo", paramArrayOfByte);
    if (paramBoolean) {
      getIntent().putExtra("KSessionID", Util.nowMilliSecond() + "_" + Util.getRandomString(5));
    }
    AppMethodBeat.o(99612);
  }
  
  public final void a(String paramString, boolean paramBoolean, int paramInt1, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int paramInt2)
  {
    AppMethodBeat.i(99611);
    Log.i("MicroMsg.SnsUploadUI", "updatePicConfig");
    getIntent().getExtras().clear();
    getIntent().putExtra("KTouchCameraTime", Util.nowSecond());
    getIntent().putExtra("KSnsPostManu", true);
    getIntent().putExtra("Ksnsupload_type", 0);
    getIntent().putExtra("KFilterId", paramInt1);
    if (!Util.isNullOrNil(paramString)) {
      getIntent().putExtra("sns_kemdia_path", paramString);
    }
    if (!Util.isNullOrNil(paramArrayList1)) {
      getIntent().putExtra("sns_kemdia_path_list", paramArrayList1);
    }
    if (!Util.isNullOrNil(paramArrayList2)) {
      getIntent().putStringArrayListExtra("sns_media_latlong_list", paramArrayList2);
    }
    if (paramBoolean) {
      getIntent().putExtra("Kis_take_photo", paramBoolean);
    }
    if (paramInt2 != 0) {
      getIntent().putExtra("Ksnsupload_source", 11);
    }
    AppMethodBeat.o(99611);
  }
  
  public final ArrayList<Exif.a> ffS()
  {
    AppMethodBeat.i(99609);
    if ((this.Ewa instanceof aq))
    {
      aq localaq = (aq)this.Ewa;
      Object localObject1 = localaq.EuF.EuQ;
      ArrayList localArrayList = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (Exif.a)localaq.EuH.get(localObject2);
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
      }
      AppMethodBeat.o(99609);
      return localArrayList;
    }
    AppMethodBeat.o(99609);
    return null;
  }
  
  public final boolean ffT()
  {
    return this.EsU;
  }
  
  public final void fjN()
  {
    AppMethodBeat.i(99600);
    if (this.Ewa.ffA())
    {
      enableOptionMenu(true);
      AppMethodBeat.o(99600);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(99600);
  }
  
  public final void fjO()
  {
    AppMethodBeat.i(99613);
    Log.i("MicroMsg.SnsUploadUI", "resetWidget");
    if (this.EPJ != null) {
      this.EPJ.setVisibility(8);
    }
    if (this.Ewb != null)
    {
      this.Ewb.removeAllViews();
      this.Ewb.setVisibility(8);
    }
    if (this.Ewa != null) {
      this.Ewa.ffE();
    }
    amZ();
    aF(null);
    AppMethodBeat.o(99613);
  }
  
  public int getLayoutId()
  {
    return 2131496519;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99605);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.EPE != null) {
      this.EPE.clearFocus();
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(99605);
      return;
    }
    if (paramInt1 == 30764)
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
      {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oho, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(getContext(), "android.permission.ACCESS_FINE_LOCATION", 64);
      }
      AppMethodBeat.o(99605);
      return;
    }
    if (this.Ewa.k(paramInt1, paramIntent)) {
      fjN();
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(99605);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      getIntent().putExtras(paramIntent.getExtras());
      bb(paramIntent);
      AppMethodBeat.o(99605);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      getIntent().putExtras(paramIntent.getExtras());
      this.EPF.aY(paramIntent);
      AppMethodBeat.o(99605);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      boolean bool = paramIntent.getBooleanExtra("bind_facebook_succ", false);
      paramIntent = this.Eoy;
      if (bool)
      {
        paramIntent.EPo = true;
        paramIntent.setSyncFacebook(true);
      }
      AppMethodBeat.o(99605);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      String str1 = Util.nullAs(paramIntent.getStringExtra("get_poi_name"), "");
      String str2 = Util.nullAs(paramIntent.getStringExtra("get_city"), "");
      if (Util.isNullOrNil(str1)) {
        getIntent().removeExtra("get_poi_name");
      }
      if (Util.isNullOrNil(str2)) {
        getIntent().removeExtra("get_city");
      }
      getIntent().putExtras(paramIntent.getExtras());
      this.EPG.aY(paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99595);
    Log.i("MicroMsg.SnsUploadUI", "onCreate");
    com.tencent.mm.pluginsdk.h.q(this);
    super.onCreate(paramBundle);
    setActionbarColor(getContext().getResources().getColor(2131099650));
    hideActionbarLine();
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    com.tencent.mm.plugin.sns.model.aj.faV().db.delete("snsDraft", "key!=? AND key!=? AND timestamp<?", new String[] { "draft_text", "draft_normal", String.valueOf(System.currentTimeMillis() - 86400000L) });
    this.EPQ = getIntent().getBooleanExtra("Kis_retry_edit", false);
    Object localObject1;
    Object localObject2;
    label467:
    boolean bool;
    label780:
    int i;
    label899:
    label916:
    int m;
    label1296:
    int k;
    int j;
    switch (getIntent().getIntExtra("Ksnsupload_type", 0))
    {
    default: 
      if ((!Util.isNullOrNil(this.DMW)) && (!this.EPQ))
      {
        localObject1 = com.tencent.mm.plugin.sns.model.aj.faV().aQn(this.DMW);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.sns.storage.j)localObject1).field_draft;
          if (!Util.isNullOrNil((byte[])localObject1))
          {
            localObject2 = Parcel.obtain();
            ((Parcel)localObject2).unmarshall((byte[])localObject1, 0, localObject1.length);
            ((Parcel)localObject2).setDataPosition(0);
            setIntent((Intent)Intent.CREATOR.createFromParcel((Parcel)localObject2));
          }
        }
      }
      amZ();
      this.EPE = ((com.tencent.mm.ui.widget.cedit.api.c)findViewById(2131308111));
      this.EPE.refresh(((PluginWebSearch)com.tencent.mm.kernel.g.ah(PluginWebSearch.class)).isUseSysEditText());
      localObject1 = new SnsUploadUI.8(this);
      this.EPE.a(((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseBrands(), ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseItems(), LocaleUtil.getCurrentLanguage(getContext()), (a.e)localObject1);
      this.EPE.addTextChangedListener(new SnsUploadUI.9(this));
      if (!Util.isNullOrNil(getIntent().getStringExtra("Kdescription")))
      {
        this.EPE.setText(com.tencent.mm.ui.g.c.b.c(getContext(), getIntent().getStringExtra("Kdescription"), this.EPE.getTextSize()));
        if (this.vjQ == 8)
        {
          localObject1 = getIntent().getStringExtra("Kdescription");
          this.EPE.setText(com.tencent.mm.ui.g.c.b.c(getContext(), (CharSequence)localObject1, this.EPE.getTextSize()));
        }
        this.EPE.setPasterLen(getIntent().getIntExtra("KparseLen", 0));
        this.xbW = ((KeyboardLinearLayout)findViewById(2131307157));
        this.EPI = ((SnsUploadSayFooter)findViewById(2131307218));
        this.EPI.setMMEditText(this.EPE);
        this.EPI.setVisibility(4);
        this.EPU = ((FrameLayout)findViewById(2131307162));
        this.EPU.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(176382);
            DisplayMetrics localDisplayMetrics = new DisplayMetrics();
            SnsUploadUI.this.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
            com.tencent.mm.plugin.sns.model.aj.faD();
            com.tencent.mm.plugin.sns.storage.r.iI(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
            AppMethodBeat.o(176382);
          }
        });
        localObject1 = new SnsUploadUI.24(this);
        this.EPE.setOnClickListener((View.OnClickListener)localObject1);
        localObject1 = new SnsUploadUI.25(this);
        this.EPE.setOnLongClickListener((View.OnLongClickListener)localObject1);
        localObject1 = new boolean[1];
        localObject1[0] = 0;
        this.EPE.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(176363);
            if (this.EQa[0] != 0)
            {
              this.EQa[0] = false;
              com.tencent.mm.plugin.normsg.a.d.AEF.aIL("ie_sns_upload");
            }
            com.tencent.mm.plugin.normsg.a.d.AEF.aIM("ie_sns_upload");
            AppMethodBeat.o(176363);
          }
        });
        localObject2 = (WrapScollview)findViewById(2131307339);
        ((WrapScollview)localObject2).setContentView(this.EPE.gYG());
        ((WrapScollview)localObject2).setDoComputeScrollDeltaToGetChildRectOnScreen(false);
        Object localObject3 = Util.nullAs(getIntent().getStringExtra("reportSessionId"), "");
        this.Eoy = ((SnsUploadConfigView)findViewById(2131298989));
        localObject2 = this.Eoy;
        if ((this.vjQ != 14) || (((String)localObject3).contains("wx5dfbe0a95623607b"))) {
          break label1908;
        }
        bool = true;
        ((SnsUploadConfigView)localObject2).EPu = bool;
        if (bool)
        {
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.a(2842, (com.tencent.mm.ak.i)localObject2);
          localObject3 = new com.tencent.mm.plugin.sns.model.j();
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject3, 0);
        }
        ((SnsUploadConfigView)localObject2).Etm.LbD = -1000.0F;
        ((SnsUploadConfigView)localObject2).Etm.LbC = -1000.0F;
        if (!((SnsUploadConfigView)localObject2).vUk)
        {
          com.tencent.mm.kernel.g.aAi();
          i = Util.nullAsNil((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(68404, null));
          if ((i & 0x2) == 0) {
            break label1914;
          }
          bool = true;
          ((SnsUploadConfigView)localObject2).EPo = bool;
          if ((i & 0x8) == 0) {
            break label1920;
          }
          bool = true;
          ((SnsUploadConfigView)localObject2).EPp = bool;
          if (!com.tencent.mm.aw.b.isOverseasUser()) {
            ((SnsUploadConfigView)localObject2).EPp = false;
          }
          if (!z.aUC()) {
            ((SnsUploadConfigView)localObject2).EPo = false;
          }
        }
        ((SnsUploadConfigView)localObject2).setSyncFacebook(false);
        ((SnsUploadConfigView)localObject2).fjE();
        ((SnsUploadConfigView)localObject2).fjG();
        ((SnsUploadConfigView)localObject2).fjF();
        if (((SnsUploadConfigView)localObject2).EPp) {
          ((SnsUploadConfigView)localObject2).EPv.a((a.a)localObject2);
        }
        if (this.vjQ != 0)
        {
          localObject2 = this.Eoy;
          ((SnsUploadConfigView)localObject2).EPj.setVisibility(8);
          ((SnsUploadConfigView)localObject2).EPk.setVisibility(8);
          ((SnsUploadConfigView)localObject2).EPl.setVisibility(8);
          ((SnsUploadConfigView)localObject2).EPm.setVisibility(8);
        }
        if (this.vjQ == 9) {
          this.Eoy.EPl.setVisibility(0);
        }
        setBackBtn(new SnsUploadUI.3(this));
        addTextOptionMenu(0, getString(2131766193), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(176366);
            if (SnsUploadUI.this.isFinishing())
            {
              Log.i("MicroMsg.SnsUploadUI", "skip commit, is finishing");
              AppMethodBeat.o(176366);
              return false;
            }
            if ((SnsUploadUI.b(SnsUploadUI.this) != null) && (!SnsUploadUI.b(SnsUploadUI.this).ffC()))
            {
              Log.i("MicroMsg.SnsUploadUI", "skip commit, beforeCommit: false");
              AppMethodBeat.o(176366);
              return false;
            }
            if (System.currentTimeMillis() - SnsUploadUI.r(SnsUploadUI.this) < 500L)
            {
              Log.i("MicroMsg.SnsUploadUI", "skip commit, click frequently");
              AppMethodBeat.o(176366);
              return false;
            }
            if (SnsUploadUI.s(SnsUploadUI.this))
            {
              Log.i("MicroMsg.SnsUploadUI", "skip commit, has commited");
              AppMethodBeat.o(176366);
              return false;
            }
            com.tencent.mm.plugin.sns.model.aj.dRd().removeCallbacks(SnsUploadUI.e(SnsUploadUI.this));
            paramAnonymousMenuItem = Parcel.obtain();
            SnsUploadUI.this.getIntent().putExtra("Kdescription", SnsUploadUI.a(SnsUploadUI.this).getText().toString());
            SnsUploadUI.this.getIntent().putExtra("KparseLen", SnsUploadUI.a(SnsUploadUI.this).getPasterLen());
            SnsUploadUI.c(SnsUploadUI.this);
            SnsUploadUI.this.getIntent().writeToParcel(paramAnonymousMenuItem, 0);
            paramAnonymousMenuItem = paramAnonymousMenuItem.marshall();
            SnsUploadUI.a(SnsUploadUI.this, paramAnonymousMenuItem, 2);
            SnsUploadUI.j(SnsUploadUI.this);
            if (this.kmH[0] != 0) {
              this.kmH[0] = false;
            }
            for (;;)
            {
              SnsUploadUI.a(SnsUploadUI.this, System.currentTimeMillis());
              com.tencent.mm.plugin.report.service.g.Wl(22);
              com.tencent.mm.ui.widget.cedit.api.d.a(SnsUploadUI.a(SnsUploadUI.this)).aoq(com.tencent.mm.n.c.aqj()).CN(true).a(new c.a()
              {
                public final void Tw(String paramAnonymous2String)
                {
                  AppMethodBeat.i(176364);
                  Log.i("MicroMsg.SnsUploadUI", "commit after check");
                  SnsUploadUI.a(SnsUploadUI.this, 3);
                  SnsUploadUI.t(SnsUploadUI.this);
                  int i = SnsUploadUI.u(SnsUploadUI.this).getSyncFlag();
                  com.tencent.mm.kernel.g.aAi();
                  com.tencent.mm.kernel.g.aAh().azQ().set(68404, Integer.valueOf(i));
                  SnsUploadUI.b(SnsUploadUI.this, SnsUploadUI.a(SnsUploadUI.this).getText().toString());
                  i = SnsUploadUI.a(SnsUploadUI.this).getPasterLen();
                  int j = SnsUploadUI.u(SnsUploadUI.this).getPrivated();
                  int k = SnsUploadUI.u(SnsUploadUI.this).getSyncFlag();
                  SnsUploadUI.v(SnsUploadUI.this);
                  if (SnsUploadUI.w(SnsUploadUI.this)) {
                    SnsUploadUI.this.setResult(-1, new Intent());
                  }
                  if ((SnsUploadUI.b(SnsUploadUI.this) instanceof aq)) {
                    ((aq)SnsUploadUI.b(SnsUploadUI.this)).EuL = SnsUploadUI.x(SnsUploadUI.this).getCurLocation();
                  }
                  if ((SnsUploadUI.b(SnsUploadUI.this) instanceof am)) {
                    SnsUploadUI.a(SnsUploadUI.this).setText("");
                  }
                  SnsUploadUI.y(SnsUploadUI.this);
                  paramAnonymous2String = new PInt();
                  Object localObject;
                  if ((SnsUploadUI.b(SnsUploadUI.this) instanceof a))
                  {
                    localObject = new Bundle();
                    ((Bundle)localObject).putInt("param_is_privated", j);
                    ((Bundle)localObject).putString("param_description", SnsUploadUI.z(SnsUploadUI.this));
                    ((Bundle)localObject).putStringArrayList("param_with_list", new ArrayList(SnsUploadUI.A(SnsUploadUI.this).getAtList()));
                    ((Bundle)localObject).putInt("param_paste_len", i);
                  }
                  for (;;)
                  {
                    try
                    {
                      ((Bundle)localObject).putByteArray("param_localtion", SnsUploadUI.x(SnsUploadUI.this).getLocation().toByteArray());
                      ((Bundle)localObject).putBoolean("param_is_black_group", SnsUploadUI.B(SnsUploadUI.this));
                      ((Bundle)localObject).putStringArrayList("param_group_user", SnsUploadUI.C(SnsUploadUI.this));
                      ((Bundle)localObject).putInt("param_contact_tag_count", SnsUploadUI.D(SnsUploadUI.this));
                      ((Bundle)localObject).putInt("param_temp_user_count", SnsUploadUI.E(SnsUploadUI.this));
                      paramAnonymous2String.value = ((a)SnsUploadUI.b(SnsUploadUI.this)).getContentType();
                      SnsUploadUI.b(SnsUploadUI.this);
                      SnsUploadUI.G(SnsUploadUI.this);
                      localObject = com.tencent.mm.plugin.report.service.h.CyF;
                      long l1 = SnsUploadUI.H(SnsUploadUI.this);
                      long l2 = Util.nowSecond();
                      if (!SnsUploadUI.I(SnsUploadUI.this)) {
                        break label1117;
                      }
                      i = 0;
                      ((com.tencent.mm.plugin.report.service.h)localObject).a(13303, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymous2String.value), "" });
                      l1 = SnsUploadUI.H(SnsUploadUI.this);
                      l2 = Util.nowSecond();
                      if (!SnsUploadUI.I(SnsUploadUI.this)) {
                        break label1122;
                      }
                      i = 0;
                      Log.d("MicroMsg.SnsUploadUI", "reprot timelinePostAction(13303), %d, %d, %d, %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymous2String.value) });
                      com.tencent.mm.plugin.report.service.h.CyF.kvStat(10910, "1");
                      if (!Util.isNullOrNil(SnsUploadUI.J(SnsUploadUI.this)))
                      {
                        if (!SnsUploadUI.B(SnsUploadUI.this)) {
                          break label1127;
                        }
                        com.tencent.mm.plugin.report.service.h.CyF.a(11455, new Object[] { "", SnsUploadUI.J(SnsUploadUI.this), Integer.valueOf(-1), Integer.valueOf(-1) });
                      }
                      if (SnsUploadUI.K(SnsUploadUI.this))
                      {
                        localObject = new Intent(SnsUploadUI.this, SnsTimeLineUI.class);
                        ((Intent)localObject).putExtra("sns_resume_state", false);
                        ((Intent)localObject).putExtra("sns_timeline_NeedFirstLoadint", true);
                        ((Intent)localObject).addFlags(67108864);
                        paramAnonymous2String = SnsUploadUI.this;
                        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/sns/ui/SnsUploadUI$12$1", "doWhenOK", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymous2String.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$12$1", "doWhenOK", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      }
                      com.tencent.mm.pluginsdk.ui.tools.q.br(SnsUploadUI.this.getIntent());
                      paramAnonymous2String = new wm();
                      EventCenter.instance.publish(paramAnonymous2String);
                      SnsUploadUI.b(SnsUploadUI.this, 1);
                      SnsUploadUI.l(SnsUploadUI.this);
                      if (!SnsUploadUI.m(SnsUploadUI.this)) {
                        break label1175;
                      }
                      com.tencent.mm.plugin.sns.k.e.DUQ.DVA.eUb = 1L;
                      com.tencent.mm.plugin.sns.data.r.eZy();
                      AppMethodBeat.o(176364);
                      return;
                    }
                    catch (IOException localIOException)
                    {
                      Log.printErrStackTrace("MicroMsg.SnsUploadUI", localIOException, "parse location error", new Object[0]);
                      continue;
                    }
                    SnsUploadUI.b(SnsUploadUI.this).a(j, k, SnsUploadUI.u(SnsUploadUI.this).getTwitterAccessToken(), SnsUploadUI.z(SnsUploadUI.this), SnsUploadUI.A(SnsUploadUI.this).getAtList(), SnsUploadUI.x(SnsUploadUI.this).getLocation(), null, i, SnsUploadUI.B(SnsUploadUI.this), SnsUploadUI.C(SnsUploadUI.this), paramAnonymous2String, SnsUploadUI.F(SnsUploadUI.this), SnsUploadUI.D(SnsUploadUI.this), SnsUploadUI.E(SnsUploadUI.this));
                    continue;
                    label1117:
                    i = 1;
                    continue;
                    label1122:
                    i = 1;
                    continue;
                    label1127:
                    com.tencent.mm.plugin.report.service.h.CyF.a(11455, new Object[] { SnsUploadUI.J(SnsUploadUI.this), "", Integer.valueOf(-1), Integer.valueOf(-1) });
                    continue;
                    label1175:
                    com.tencent.mm.plugin.sns.k.e.DUQ.DVA.xm(SnsUploadUI.k(SnsUploadUI.this));
                    com.tencent.mm.plugin.sns.k.e.DUQ.DVz.xm(SnsUploadUI.k(SnsUploadUI.this));
                  }
                }
                
                public final void Tx(String paramAnonymous2String) {}
                
                public final void dv(String paramAnonymous2String)
                {
                  AppMethodBeat.i(176365);
                  com.tencent.mm.ui.base.h.n(SnsUploadUI.this, 2131766298, 2131766299);
                  AppMethodBeat.o(176365);
                }
              });
              AppMethodBeat.o(176366);
              return false;
              com.tencent.mm.plugin.normsg.a.d.AEF.jf("ce_sns_upload", "<SnsUpload>");
              paramAnonymousMenuItem = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.d.AEF.a("ce_sns_upload", paramAnonymousMenuItem);
              com.tencent.mm.plugin.normsg.a.d.AEF.aIQ("ce_sns_upload");
            }
          }
        }, null, new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(99574);
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(99574);
              return false;
              this.kmH[0] = true;
              com.tencent.mm.plugin.normsg.a.d.AEF.jf("ce_sns_upload", "<SnsUpload>");
              continue;
              com.tencent.mm.plugin.normsg.a.d.AEF.a("ce_sns_upload", paramAnonymousMotionEvent);
              com.tencent.mm.plugin.normsg.a.d.AEF.aIQ("ce_sns_upload");
            }
          }
        }, t.b.OGU);
        findViewById(2131309617).setOnTouchListener(new SnsUploadUI.6(this));
        this.EPF = ((AtContactWidget)findViewById(2131297065));
        this.EPF.Eoy = this.Eoy;
        this.EPG = ((LocationWidget)findViewById(2131303759));
        this.EPG.setLocationWidgetListener(this);
        switch (this.vjQ)
        {
        default: 
          this.EPH.Eoy = this.Eoy;
          this.EPH.setRangeTipClickListener(new SnsUploadUI.7(this));
          this.EPG.aY(getIntent());
          this.EPF.aY(getIntent());
          com.tencent.mm.plugin.sns.k.e.DUQ.YP(0);
          com.tencent.mm.plugin.sns.k.e.DUQ.DVa.eTg = 2;
          bb(getIntent());
          hideVKB();
          aF(paramBundle);
          paramBundle = com.tencent.mm.plugin.sns.model.aj.faV().aQn(this.DMW);
          if ((paramBundle != null) && ((paramBundle.field_extFlag & 0x1) == 1))
          {
            m = 0;
            k = 2;
            i = m;
            j = k;
            switch (this.vjQ)
            {
            default: 
              j = k;
              i = m;
            }
          }
          break;
        }
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(i), this.EsT, Long.valueOf(Util.nowSecond()), Integer.valueOf(j) });
      com.tencent.mm.pluginsdk.h.r(this);
      paramBundle = Parcel.obtain();
      getIntent().writeToParcel(paramBundle, 0);
      this.EPR = MD5Util.getMD5String(paramBundle.marshall());
      this.EPS = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sdL, 3000L);
      this.EPW = Util.nowMilliSecond();
      this.EPM = false;
      AppMethodBeat.o(99595);
      return;
      localObject1 = XmlParser.parseXml(Util.nullAs(getIntent().getStringExtra("fav_note_xml"), ""), "favlocalid", null);
      if ((localObject1 == null) || (((Map)localObject1).size() == 0)) {
        break;
      }
      localObject1 = (String)((Map)localObject1).get(".favlocalid");
      if (Util.isEqual((String)localObject1, "0")) {
        break;
      }
      this.DMW = ((String)localObject1);
      break;
      localObject2 = Util.nullAs(getIntent().getStringExtra("Ksnsupload_link"), "");
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = Util.nullAs(getIntent().getStringExtra("ShareUrlOpen"), "");
      }
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        localObject2 = Util.nullAs(getIntent().getStringExtra("ShareUrlOriginal"), "");
      }
      if (!Util.isNullOrNil((String)localObject2)) {
        this.DMW = com.tencent.mm.plugin.sns.data.r.aOA((String)localObject2);
      }
      if (!getIntent().getBooleanExtra("ksnsis_appbrand", false)) {
        break;
      }
      this.DMW = null;
      break;
      this.DMW = Util.nullAs(getIntent().getStringExtra("Ksnsupload_musicid"), "");
      break;
      if ((this.EPE == null) || (paramBundle == null)) {
        break label467;
      }
      localObject1 = paramBundle.getString("contentdesc");
      if (localObject1 == null) {
        break label467;
      }
      this.EPE.setText((CharSequence)localObject1);
      break label467;
      label1908:
      bool = false;
      break label780;
      label1914:
      bool = false;
      break label899;
      label1920:
      bool = false;
      break label916;
      this.EPH = ((RangeWidget)findViewById(2131306499));
      findViewById(2131306500).setVisibility(8);
      break label1296;
      this.EPH = ((RangeWidget)findViewById(2131306499));
      findViewById(2131306500).setVisibility(8);
      break label1296;
      this.EPH = ((RangeWidget)findViewById(2131306499));
      findViewById(2131306500).setVisibility(8);
      break label1296;
      i = 1;
      j = k;
      continue;
      i = 3;
      j = k;
      continue;
      i = 5;
      j = k;
      continue;
      j = 3;
      i = m;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99604);
    super.onDestroy();
    if (this.Eoy != null)
    {
      localObject = this.Eoy;
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.b(2842, (com.tencent.mm.ak.i)localObject);
    }
    if (this.Ewa != null) {
      this.Ewa.ffE();
    }
    if (this.EPG != null) {
      this.EPG.stop();
    }
    if (this.EPI != null)
    {
      localObject = this.EPI;
      if (((SnsUploadSayFooter)localObject).rum != null)
      {
        ((SnsUploadSayFooter)localObject).rum.goC();
        ((SnsUploadSayFooter)localObject).rum.destroy();
      }
    }
    this.EPN.clear();
    com.tencent.mm.plugin.normsg.a.d.AEF.aIN("ie_sns_upload");
    com.tencent.mm.plugin.sns.data.r.eZy();
    EventCenter.instance.removeListener(this.EPY);
    Object localObject = SecDataUIC.CWq;
    localObject = (com.tencent.mm.plugin.sns.j.j)SecDataUIC.a.c(this, 2, com.tencent.mm.plugin.sns.j.j.class);
    if ((localObject == null) || (((com.tencent.mm.plugin.sns.j.j)localObject).ecf <= 0)) {}
    for (;;)
    {
      this.EPE.destroy();
      AppMethodBeat.o(99604);
      return;
      ((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.secdata.g.class)).updateWithSave(2, "SnsPostEnd_" + ((com.tencent.mm.plugin.sns.j.j)localObject).ecf, (com.tencent.mm.bw.a)localObject, new SnsUploadUI.11(this));
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99597);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      paramKeyEvent = this.EPI;
      if ((paramKeyEvent.fjI()) || (paramKeyEvent.getVisibility() == 0)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        this.EPI.fjJ();
        AppMethodBeat.o(99597);
        return true;
      }
      dAM();
      AppMethodBeat.o(99597);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(99597);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99602);
    super.hideVKB();
    super.onPause();
    this.EPE.onPause();
    AppMethodBeat.o(99602);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(99610);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.SnsUploadUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(99610);
      return;
    }
    Log.i("MicroMsg.SnsUploadUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(99610);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        this.EPG.ffP();
        AppMethodBeat.o(99610);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131763874), getString(2131763890), getString(2131762043), getString(2131755761), false, new SnsUploadUI.13(this), new SnsUploadUI.14(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99603);
    super.onResume();
    this.EPI.post(new SnsUploadUI.10(this));
    al localal;
    if ((this.Ewa != null) && ((this.Ewa instanceof al)))
    {
      localal = (al)this.Ewa;
      if (localal.EsO != null)
      {
        if (localal.EsV) {
          break label97;
        }
        localal.ffZ();
      }
    }
    for (;;)
    {
      this.EPE.refresh(((PluginWebSearch)com.tencent.mm.kernel.g.ah(PluginWebSearch.class)).isUseSysEditText());
      AppMethodBeat.o(99603);
      return;
      label97:
      localal.fga();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(99594);
    if (paramBundle != null)
    {
      if (this.EPE != null) {
        paramBundle.putString("contentdesc", this.EPE.getText().toString());
      }
      this.Ewa.aD(paramBundle);
    }
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(99594);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(176385);
    super.onStart();
    com.tencent.mm.plugin.sns.model.aj.dRd().postDelayed(this.EPT, this.EPS);
    AppMethodBeat.o(176385);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(176387);
    super.onStop();
    com.tencent.mm.plugin.sns.model.aj.dRd().removeCallbacks(this.EPT);
    AppMethodBeat.o(176387);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI
 * JD-Core Version:    0.7.0.1
 */