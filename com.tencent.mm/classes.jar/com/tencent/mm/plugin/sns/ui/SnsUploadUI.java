package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
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
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.al.n;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.g.a.jk.a;
import com.tencent.mm.g.a.uf;
import com.tencent.mm.g.b.a.dw;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.k.a.a;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.tools.b.c.a;
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
  extends MMActivity
  implements LocationWidget.a
{
  private String desc;
  private int ite;
  private KeyboardLinearLayout rux;
  private long xKA;
  private long xKB;
  private int xKC;
  private com.tencent.mm.sdk.b.c<jk> xKD;
  private AtContactWidget xKk;
  private LocationWidget xKl;
  private RangeWidget xKm;
  private SnsUploadSayFooter xKn;
  private DynamicGridView xKo;
  private boolean xKp;
  private boolean xKq;
  boolean xKr;
  private Map<Integer, ab> xKs;
  private Map<String, List<String>> xKt;
  private Map<String, List<String>> xKu;
  private String xKv;
  private String xKw;
  private long xKx;
  private Runnable xKy;
  private FrameLayout xKz;
  private SnsUploadConfigView xkR;
  private int xnE;
  private String xoO;
  private boolean xoP;
  private String xpl;
  private int xpm;
  private int xpn;
  private SnsEditText xrU;
  private ab xrV;
  private LinearLayout xrW;
  private ArrayList<String> xrY;
  private boolean xrZ;
  private String xru;
  private String xrv;
  private String xrw;
  private boolean xsa;
  private long xsb;
  
  public SnsUploadUI()
  {
    AppMethodBeat.i(99593);
    this.xoP = false;
    this.xnE = 0;
    this.xsa = false;
    this.xsb = 0L;
    this.xrV = null;
    this.xru = "";
    this.xrv = "";
    this.xrw = "";
    this.xpm = 0;
    this.xpn = 0;
    this.xrZ = false;
    this.xKp = false;
    this.xKq = false;
    this.xKr = false;
    this.xpl = null;
    this.xoO = "";
    this.xKs = new HashMap();
    this.xKt = new HashMap();
    this.xKu = new HashMap();
    this.xKv = "";
    this.xKw = "";
    this.xKx = 3000L;
    this.xKy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176362);
        if (SnsUploadUI.a(SnsUploadUI.this) != null)
        {
          Object localObject = Parcel.obtain();
          SnsUploadUI.this.getIntent().putExtra("Kdescription", SnsUploadUI.a(SnsUploadUI.this).getText().toString());
          SnsUploadUI.this.getIntent().putExtra("KparseLen", SnsUploadUI.a(SnsUploadUI.this).getPasterLen());
          SnsUploadUI.this.getIntent().writeToParcel((Parcel)localObject, 0);
          localObject = ((Parcel)localObject).marshall();
          String str = ai.D((byte[])localObject);
          ad.d("MicroMsg.SnsUploadUI", "autoSaveDraft lastMd5:%s, newMd5:%s", new Object[] { SnsUploadUI.b(SnsUploadUI.this), str });
          if (!bt.kU(SnsUploadUI.b(SnsUploadUI.this), str))
          {
            SnsUploadUI.a(SnsUploadUI.this, str);
            SnsUploadUI.a(SnsUploadUI.this, (byte[])localObject, true);
          }
          com.tencent.mm.plugin.sns.model.af.dhI().postDelayed(SnsUploadUI.c(SnsUploadUI.this), SnsUploadUI.d(SnsUploadUI.this));
        }
        AppMethodBeat.o(176362);
      }
    };
    this.xKz = null;
    this.xKA = 0L;
    this.xKB = 0L;
    this.ite = 0;
    this.xKC = 0;
    this.xKD = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(jk paramAnonymousjk)
      {
        AppMethodBeat.i(176377);
        if ((paramAnonymousjk != null) && (bt.kU(paramAnonymousjk.dnA.dnB, SnsUploadUI.this.hashCode()))) {
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fxt, paramAnonymousjk.dnA.dnC);
        }
        AppMethodBeat.o(176377);
        return false;
      }
    };
    AppMethodBeat.o(99593);
  }
  
  private ab NI(int paramInt)
  {
    AppMethodBeat.i(99614);
    Object localObject1 = (ab)this.xKs.get(Integer.valueOf(paramInt));
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (paramInt != 0) {
        break label67;
      }
      localObject1 = new ak(this);
    }
    for (;;)
    {
      this.xKs.put(Integer.valueOf(paramInt), localObject1);
      localObject2 = localObject1;
      AppMethodBeat.o(99614);
      return localObject2;
      label67:
      if (paramInt == 14) {
        localObject1 = new af(this);
      }
    }
  }
  
  private void NJ(int paramInt)
  {
    AppMethodBeat.i(176389);
    com.tencent.mm.plugin.sns.k.f.wQY.wRg.kb(this.xoO);
    com.tencent.mm.plugin.sns.k.f.wQY.wRg.dWa = paramInt;
    if ((paramInt == 3) || (paramInt == 2)) {
      com.tencent.mm.plugin.sns.k.f.wQY.duV();
    }
    AppMethodBeat.o(176389);
  }
  
  private void VL()
  {
    AppMethodBeat.i(99601);
    this.xsa = getIntent().getBooleanExtra("KSnsPostManu", false);
    this.xsb = getIntent().getLongExtra("KTouchCameraTime", 0L);
    this.xnE = getIntent().getIntExtra("Ksnsupload_type", 0);
    this.xoP = getIntent().getBooleanExtra("Kis_take_photo", false);
    if (this.xoP) {}
    for (int i = 2;; i = 1)
    {
      this.xKC = i;
      this.xKp = getIntent().getBooleanExtra("need_result", false);
      this.xKq = getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false);
      this.xpl = getIntent().getStringExtra("Ksnsupload_canvas_info");
      this.xoO = getIntent().getStringExtra("KSessionID");
      if (!bt.isNullOrNil(this.xoO)) {
        break;
      }
      this.xoO = com.tencent.mm.plugin.sns.data.q.dsd();
      getIntent().putExtra("KSessionID", this.xoO);
      AppMethodBeat.o(99601);
      return;
    }
    this.xKC = 3;
    AppMethodBeat.o(99601);
  }
  
  private void aJ(Intent paramIntent)
  {
    List localList2 = null;
    AppMethodBeat.i(99606);
    this.xKm.a(5, -1, paramIntent, this.xKk);
    int i = paramIntent.getIntExtra("Ktag_range_index", 0);
    if (i >= 2)
    {
      this.xru = paramIntent.getStringExtra("Klabel_name_list");
      this.xrv = paramIntent.getStringExtra("Kother_user_name_list");
      this.xrw = paramIntent.getStringExtra("Kchat_room_name_list");
      if (bt.isNullOrNil(this.xru)) {
        break label275;
      }
    }
    label275:
    for (paramIntent = Arrays.asList(this.xru.split(","));; paramIntent = null)
    {
      List localList1;
      if (!bt.isNullOrNil(this.xrv))
      {
        localList1 = Arrays.asList(this.xrv.split(","));
        com.tencent.mm.plugin.sns.k.f.wQY.ft(localList1);
      }
      for (;;)
      {
        if (!bt.isNullOrNil(this.xrw)) {
          localList2 = Arrays.asList(this.xrw.split(","));
        }
        p(paramIntent, localList1);
        eI(localList2);
        if (i == 2)
        {
          this.xrZ = false;
          if ((this.xKt != null) && (!this.xKt.isEmpty())) {
            com.tencent.mm.plugin.sns.k.f.wQY.aD(this.xKt);
          }
          if ((this.xKu != null) && (!this.xKu.isEmpty())) {
            com.tencent.mm.plugin.sns.k.f.wQY.aC(this.xKu);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.k.f.wQY.MB(i);
          AppMethodBeat.o(99606);
          return;
          this.xrZ = true;
          break;
          if (!bt.gL(this.xrY)) {
            this.xrY.clear();
          }
        }
        localList1 = null;
      }
    }
  }
  
  private void ai(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(99615);
    ad.i("MicroMsg.SnsUploadUI", "attachWidget. share type %d, isManuSnsPost:%b", new Object[] { Integer.valueOf(this.xnE), Boolean.valueOf(this.xsa) });
    Object localObject;
    if ((this.xnE == 0) || (this.xnE == 14) || (this.xnE == 9))
    {
      localObject = Parcel.obtain();
      getIntent().writeToParcel((Parcel)localObject, 0);
      ((Parcel)localObject).marshall();
      if (this.xnE != 9) {
        break label452;
      }
      setMMTitle(getContext().getResources().getString(2131764021));
    }
    RelativeLayout.LayoutParams localLayoutParams;
    label452:
    int i;
    switch (this.xnE)
    {
    default: 
    case 0: 
    case 14: 
    case 1: 
    case 11: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 2: 
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
        this.xrV.af(paramBundle);
        if (!(this.xrV instanceof ak)) {
          break label815;
        }
        paramBundle = findViewById(2131304970);
        localObject = findViewById(2131304985);
        this.xKo = ((DynamicGridView)findViewById(2131305045));
        this.xKo.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(176375);
            boolean bool = SnsUploadUI.J(SnsUploadUI.this);
            AppMethodBeat.o(176375);
            return bool;
          }
        });
        paramBundle = ((ak)this.xrV).a(paramBundle, findViewById(2131298953), this.xKo, (View)localObject);
        this.xKo.setVisibility(0);
        localObject = findViewById(2131306994);
        localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        localLayoutParams.topMargin = 0;
        localLayoutParams.addRule(3, 2131305045);
        ((View)localObject).setLayoutParams(localLayoutParams);
        if ((this.xrV instanceof ac))
        {
          localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).width = -1;
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if (((this.xrV instanceof q)) || ((this.xrV instanceof o)) || ((this.xrV instanceof p)))
        {
          localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).width = -1;
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        dCO();
        if (this.xnE == 0) {
          dCM();
        }
        AppMethodBeat.o(99615);
        return;
        setMMTitle("");
        break;
        this.xKv = "draft_normal";
        this.xrV = NI(this.xnE);
        this.xrU.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(99580);
            if (SnsUploadUI.a(SnsUploadUI.this).getText().toString().trim().length() > 10)
            {
              paramAnonymousCharSequence = SnsUploadUI.this.findViewById(2131304985);
              if (paramAnonymousCharSequence != null) {
                paramAnonymousCharSequence.setVisibility(8);
              }
            }
            AppMethodBeat.o(99580);
          }
        });
        continue;
        this.xKv = "draft_normal";
        this.xrV = NI(this.xnE);
        continue;
        this.xrV = new ac(this);
        continue;
        this.xrV = new ae(this);
        continue;
        this.xrV = new al(this, 9);
        continue;
        this.xrV = new al(this, 12);
        continue;
        this.xrV = new q(this);
        continue;
        this.xrV = new o(this);
        continue;
        this.xrV = new r(this);
        continue;
        this.xrV = new p(this);
        continue;
        this.xrV = new al(this, 14);
        continue;
        this.xrV = new al(this, 13);
      }
    case 9: 
      this.xKv = "draft_text";
      localObject = bt.by(getIntent().getStringExtra("Kdescription"), "");
      i = bt.a(Integer.valueOf(getIntent().getIntExtra("KparseLen", 0)), 0);
      if ((localObject == null) || (bt.isNullOrNil(((String)localObject).trim()))) {
        break;
      }
    }
    for (;;)
    {
      this.xrV = new ag(this, bool);
      this.xrU.setPasterLen(i);
      this.xrU.setText(com.tencent.mm.ui.f.c.b.c(getContext(), (CharSequence)localObject, this.xrU.getTextSize()));
      this.xrU.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(176374);
          if (SnsUploadUI.a(SnsUploadUI.this).getText().toString().trim().length() > 0)
          {
            SnsUploadUI.this.enableOptionMenu(true);
            AppMethodBeat.o(176374);
            return;
          }
          SnsUploadUI.this.enableOptionMenu(false);
          AppMethodBeat.o(176374);
        }
      });
      break;
      this.xrV = new bj(this);
      break;
      label815:
      paramBundle = this.xrV.dyV();
      this.xrW = ((LinearLayout)findViewById(2131306993));
      this.xrW.setVisibility(0);
      this.xrW.setClipChildren(false);
      label876:
      float f;
      if (paramBundle != null)
      {
        ad.d("MicroMsg.SnsUploadUI", "will add widget view in widgetLL.");
        this.xrW.addView(paramBundle);
        if ((this.xnE == 9) || (this.xnE == 14))
        {
          localObject = findViewById(2131306994);
          localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
          localLayoutParams.addRule(3, 2131306993);
          f = com.tencent.mm.sdk.platformtools.f.aGH().density;
          if (this.xnE != 9) {
            break label974;
          }
        }
      }
      label974:
      for (i = 128;; i = 96)
      {
        localLayoutParams.topMargin = ((int)(i * f));
        ((View)localObject).setLayoutParams(localLayoutParams);
        break;
        this.xrW.setVisibility(8);
        break label876;
      }
      bool = false;
    }
  }
  
  private void crq()
  {
    AppMethodBeat.i(99598);
    if (((this.xnE == 0) && (((ak)this.xrV).dzY() > 0)) || ((this.xnE == 14) && ((this.xrV instanceof af)) && (!((af)this.xrV).xoQ)) || ((this.xnE == 9) && (!bt.isNullOrNil(this.xrU.getText().toString()))))
    {
      com.tencent.mm.ui.base.h.a(this, 2131764054, 0, 2131764056, 2131764055, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(99587);
          ad.i("MicroMsg.SnsUploadUI", "exitAndSave shareType:%s realtimeType:%s", new Object[] { Integer.valueOf(SnsUploadUI.h(SnsUploadUI.this)), Integer.valueOf(SnsUploadUI.this.getIntent().getIntExtra("Ksnsupload_type", -1)) });
          SnsUploadUI.a(SnsUploadUI.this, 1);
          paramAnonymousDialogInterface = Parcel.obtain();
          SnsUploadUI.this.getIntent().putExtra("Kdescription", SnsUploadUI.a(SnsUploadUI.this).getText().toString());
          SnsUploadUI.this.getIntent().putExtra("KparseLen", SnsUploadUI.a(SnsUploadUI.this).getPasterLen());
          SnsUploadUI.this.getIntent().writeToParcel(paramAnonymousDialogInterface, 0);
          paramAnonymousDialogInterface = paramAnonymousDialogInterface.marshall();
          SnsUploadUI.a(SnsUploadUI.this, paramAnonymousDialogInterface, false);
          SnsUploadUI.i(SnsUploadUI.this);
          switch (SnsUploadUI.h(SnsUploadUI.this))
          {
          default: 
            paramAnonymousInt = 0;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(paramAnonymousInt), SnsUploadUI.j(SnsUploadUI.this), Long.valueOf(bt.aGK()), Integer.valueOf(1) });
            SnsUploadUI.b(SnsUploadUI.this, 3);
            SnsUploadUI.k(SnsUploadUI.this);
            SnsUploadUI.l(SnsUploadUI.this);
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
          com.tencent.mm.plugin.sns.model.af.dhI().removeCallbacks(SnsUploadUI.c(SnsUploadUI.this));
          SnsUploadUI.a(SnsUploadUI.this, null, false);
          SnsUploadUI.i(SnsUploadUI.this);
          paramAnonymousDialogInterface = SnsUploadUI.this.getIntent().getStringExtra("KSightThumbPath");
          Object localObject = SnsUploadUI.this.getIntent().getStringExtra("KSightPath");
          if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqy, true))
          {
            com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.vtE;
            com.tencent.mm.plugin.recordvideo.e.b.alS((String)localObject);
            localObject = com.tencent.mm.plugin.recordvideo.e.b.vtE;
            com.tencent.mm.plugin.recordvideo.e.b.alS(paramAnonymousDialogInterface);
          }
          if ((SnsUploadUI.e(SnsUploadUI.this) instanceof ag)) {
            SnsUploadUI.a(SnsUploadUI.this).setText("");
          }
          switch (SnsUploadUI.h(SnsUploadUI.this))
          {
          default: 
            paramAnonymousInt = 0;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(paramAnonymousInt), SnsUploadUI.j(SnsUploadUI.this), Long.valueOf(bt.aGK()), Integer.valueOf(0) });
            SnsUploadUI.b(SnsUploadUI.this, 2);
            SnsUploadUI.k(SnsUploadUI.this);
            SnsUploadUI.m(SnsUploadUI.this);
            AppMethodBeat.o(99588);
            return;
            paramAnonymousInt = 2;
            continue;
            paramAnonymousInt = 4;
            continue;
            paramAnonymousInt = 6;
          }
        }
      }, 2131099903);
      AppMethodBeat.o(99598);
      return;
    }
    if (((this.xrV instanceof ac)) || ((this.xrV instanceof ae)))
    {
      if (!bt.isNullOrNil(this.xrU.getText().toString()))
      {
        com.tencent.mm.plugin.sns.model.af.dhI().removeCallbacks(this.xKy);
        Parcel localParcel = Parcel.obtain();
        getIntent().putExtra("Kdescription", this.xrU.getText().toString());
        getIntent().putExtra("KparseLen", this.xrU.getPasterLen());
        getIntent().writeToParcel(localParcel, 0);
        e(localParcel.marshall(), false);
        com.tencent.mm.plugin.report.service.h.vKh.f(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(7), this.xoO, Long.valueOf(bt.aGK()), Integer.valueOf(3) });
      }
      dCQ();
      NJ(2);
      dCR();
      dCN();
      AppMethodBeat.o(99598);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, 2131764053, 0, 2131755277, 2131755691, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(176381);
        com.tencent.mm.plugin.sns.model.af.dhI().removeCallbacks(SnsUploadUI.c(SnsUploadUI.this));
        SnsUploadUI.a(SnsUploadUI.this, null, false);
        SnsUploadUI.i(SnsUploadUI.this);
        SnsUploadUI.b(SnsUploadUI.this, 2);
        SnsUploadUI.k(SnsUploadUI.this);
        SnsUploadUI.m(SnsUploadUI.this);
        AppMethodBeat.o(176381);
      }
    }, null, 2131099904);
    AppMethodBeat.o(99598);
  }
  
  @TargetApi(11)
  private void dCM()
  {
    AppMethodBeat.i(99596);
    if (!(this.xrV instanceof ak))
    {
      ad.e("MicroMsg.SnsUploadUI", "!(widget instanceof PicWidget)");
      AppMethodBeat.o(99596);
      return;
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      ad.d("MicroMsg.SnsUploadUI", "sdk not support dragdrop event");
      AppMethodBeat.o(99596);
      return;
    }
    new SnsUploadUI.12(this).run();
    AppMethodBeat.o(99596);
  }
  
  private void dCN()
  {
    AppMethodBeat.i(99599);
    setResult(0, new Intent());
    finish();
    com.tencent.mm.plugin.sns.data.q.dse();
    AppMethodBeat.o(99599);
  }
  
  private void dCQ()
  {
    AppMethodBeat.i(176388);
    if (this.xnE == 9)
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fis, this.xoO);
      AppMethodBeat.o(176388);
      return;
    }
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fir, this.xoO);
    AppMethodBeat.o(176388);
  }
  
  private void dCR()
  {
    AppMethodBeat.i(176390);
    com.tencent.mm.plugin.expt.a.c localc = (com.tencent.mm.plugin.expt.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.c.class);
    localc.fq("startTime", this.xKB);
    localc.fq("endTime", bt.eGO());
    localc.fq("bussinessId", this.xoO);
    localc.fq("shareType", this.xnE);
    localc.fq("hadLocation", this.xKl.getShowFlag());
    localc.fq("desc", this.xrU.getText().toString());
    localc.fq("nextStep", this.ite);
    localc.fq("beforeStep", this.xKC);
    localc.fq("ContactTagCount", this.xpm);
    localc.fq("mIsBlackGroup", this.xrZ);
    if (this.xrY != null)
    {
      localObject1 = this.xrY.size();
      localc.fq("mContactNameList", (String)localObject1);
      if (!(this.xrV instanceof ak)) {
        break label423;
      }
      Object localObject2 = ((ak)this.xrV).dAa();
      if ((localObject2 == null) || (((Map)localObject2).isEmpty())) {
        break label423;
      }
      localObject1 = new StringBuilder();
      localObject2 = ((Map)localObject2).values().iterator();
      label355:
      if (!((Iterator)localObject2).hasNext()) {
        break label410;
      }
      if (!((Boolean)((Iterator)localObject2).next()).booleanValue()) {
        break label405;
      }
    }
    label405:
    for (int i = 1;; i = 2)
    {
      ((StringBuilder)localObject1).append(i).append("#");
      break label355;
      localObject1 = "0";
      break;
    }
    label410:
    localc.fq("picSource", ((StringBuilder)localObject1).toString());
    label423:
    if ((this.xrV instanceof af)) {
      if (!((af)this.xrV).dzt()) {
        break label467;
      }
    }
    label467:
    for (Object localObject1 = "1";; localObject1 = "2")
    {
      localc.fq("sightSource", (String)localObject1);
      AppMethodBeat.o(176390);
      return;
    }
  }
  
  private void e(final byte[] paramArrayOfByte, final boolean paramBoolean)
  {
    AppMethodBeat.i(176386);
    com.tencent.mm.plugin.sns.model.af.dhI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176380);
        long l = System.currentTimeMillis();
        if (paramBoolean) {
          com.tencent.mm.plugin.sns.model.af.dtB().b(SnsUploadUI.g(SnsUploadUI.this), paramArrayOfByte, 1);
        }
        for (;;)
        {
          ad.i("MicroMsg.SnsUploadUI", "saveDraft draftKey:%s, %s", new Object[] { SnsUploadUI.g(SnsUploadUI.this), Long.valueOf(bt.vM(l)) });
          AppMethodBeat.o(176380);
          return;
          com.tencent.mm.plugin.sns.model.af.dtB().b(SnsUploadUI.g(SnsUploadUI.this), paramArrayOfByte, 0);
        }
      }
    });
    AppMethodBeat.o(176386);
  }
  
  private void eI(List<String> paramList)
  {
    AppMethodBeat.i(99607);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(99607);
      return;
    }
    this.xKu.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str1 = (String)paramList.next();
      ArrayList localArrayList = new ArrayList();
      Object localObject = com.tencent.mm.model.q.rX(str1);
      if (localObject != null)
      {
        ad.d("MicroMsg.SnsUploadUI", "getContactNamesFromChatroom chatromm:%s membersCount:%s", new Object[] { str1, Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          if ((!this.xrY.contains(str2)) && (w.sD(str2)))
          {
            ad.i("MicroMsg.SnsUploadUI", "getContactNamesFromChatroom memberName:%s", new Object[] { str2 });
            this.xrY.add(str2);
            this.xpn += 1;
          }
          if (w.sD(str2)) {
            localArrayList.add(str2);
          }
        }
        ad.d("MicroMsg.SnsUploadUI", "%s , %s", new Object[] { str1, Integer.valueOf(localArrayList.size()) });
        this.xKu.put(str1, localArrayList);
      }
    }
    AppMethodBeat.o(99607);
  }
  
  private void p(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(99608);
    this.xrY = new ArrayList();
    this.xpm = 0;
    this.xKt.clear();
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
        localList = com.tencent.mm.plugin.label.a.a.cIS().aeL(com.tencent.mm.plugin.label.a.a.cIS().aeI(str1));
        if ((localList == null) || (localList.size() == 0)) {
          ad.e("MicroMsg.SnsUploadUI", "dz: getContactNamesFromLabelsAndOtherUserName,namelist get bu label is null");
        }
      }
      else
      {
        this.xrY = new ArrayList(localHashSet);
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
      if (bt.isNullOrNil((String)paramList1.next())) {
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
        this.xpm += 1;
        ad.d("MicroMsg.SnsUploadUI", "dz:name : %s", new Object[] { str2 });
      }
      this.xKt.put(str1, localList);
      break;
      this.xpm = i;
      this.xpn = 0;
      if ((paramList2 != null) && (paramList2.size() > 0))
      {
        paramList1 = paramList2.iterator();
        while (paramList1.hasNext())
        {
          paramList2 = (String)paramList1.next();
          if (!this.xrY.contains(paramList2))
          {
            this.xrY.add(paramList2);
            this.xpn += 1;
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
    ad.i("MicroMsg.SnsUploadUI", "updateSightConfig");
    getIntent().getExtras().clear();
    getIntent().putExtra("KSightPath", paramString1);
    getIntent().putExtra("KSightThumbPath", paramString2);
    getIntent().putExtra("sight_md5", paramString3);
    getIntent().putExtra("KSnsPostManu", true);
    getIntent().putExtra("Ksnsupload_type", 14);
    getIntent().putExtra("Kis_take_photo", false);
    getIntent().putExtra("KMMSightExtInfo", paramArrayOfByte);
    if (paramBoolean) {
      getIntent().putExtra("KSessionID", bt.eGO() + "_" + bt.Wl(5));
    }
    AppMethodBeat.o(99612);
  }
  
  public final void a(String paramString, boolean paramBoolean, int paramInt1, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int paramInt2)
  {
    AppMethodBeat.i(99611);
    ad.i("MicroMsg.SnsUploadUI", "updatePicConfig");
    getIntent().getExtras().clear();
    getIntent().putExtra("KTouchCameraTime", bt.aGK());
    getIntent().putExtra("KSnsPostManu", true);
    getIntent().putExtra("Ksnsupload_type", 0);
    getIntent().putExtra("KFilterId", paramInt1);
    if (!bt.isNullOrNil(paramString)) {
      getIntent().putExtra("sns_kemdia_path", paramString);
    }
    if (!bt.gL(paramArrayList1)) {
      getIntent().putExtra("sns_kemdia_path_list", paramArrayList1);
    }
    if (!bt.gL(paramArrayList2)) {
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
  
  public final void dCO()
  {
    AppMethodBeat.i(99600);
    if (this.xrV.dyU())
    {
      enableOptionMenu(true);
      AppMethodBeat.o(99600);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(99600);
  }
  
  public final void dCP()
  {
    AppMethodBeat.i(99613);
    ad.i("MicroMsg.SnsUploadUI", "resetWidget");
    if (this.xKo != null) {
      this.xKo.setVisibility(8);
    }
    if (this.xrW != null)
    {
      this.xrW.removeAllViews();
      this.xrW.setVisibility(8);
    }
    if (this.xrV != null) {
      this.xrV.dyW();
    }
    VL();
    ai(null);
    AppMethodBeat.o(99613);
  }
  
  public final ArrayList<Exif.a> dzi()
  {
    AppMethodBeat.i(99609);
    if ((this.xrV instanceof ak))
    {
      ak localak = (ak)this.xrV;
      Object localObject1 = localak.xqA.xqL;
      ArrayList localArrayList = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (Exif.a)localak.xqC.get(localObject2);
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
  
  public final boolean dzj()
  {
    return this.xoP;
  }
  
  public int getLayoutId()
  {
    return 2131495620;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99605);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.xrU != null) {
      this.xrU.clearFocus();
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
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtT, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(getContext(), "android.permission.ACCESS_COARSE_LOCATION", 64);
      }
      AppMethodBeat.o(99605);
      return;
    }
    if (this.xrV.j(paramInt1, paramIntent)) {
      dCO();
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
      aJ(paramIntent);
      AppMethodBeat.o(99605);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      getIntent().putExtras(paramIntent.getExtras());
      this.xKk.aG(paramIntent);
      AppMethodBeat.o(99605);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      boolean bool = paramIntent.getBooleanExtra("bind_facebook_succ", false);
      paramIntent = this.xkR;
      if (bool)
      {
        paramIntent.xJV = true;
        paramIntent.setSyncFacebook(true);
      }
      AppMethodBeat.o(99605);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      getIntent().putExtras(paramIntent.getExtras());
      this.xKl.aG(paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99595);
    ad.i("MicroMsg.SnsUploadUI", "onCreate");
    com.tencent.mm.pluginsdk.g.o(this);
    super.onCreate(paramBundle);
    setActionbarColor(getContext().getResources().getColor(2131099650));
    hideActionbarLine();
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    com.tencent.mm.plugin.sns.model.af.dtB().db.delete("snsDraft", "key!=? AND key!=? AND timestamp<?", new String[] { "draft_text", "draft_normal", String.valueOf(System.currentTimeMillis() - 86400000L) });
    Object localObject1;
    Object localObject2;
    label322:
    boolean bool;
    label610:
    int i;
    label729:
    label746:
    int m;
    label1096:
    int k;
    int j;
    switch (getIntent().getIntExtra("Ksnsupload_type", 0))
    {
    default: 
      if (!bt.isNullOrNil(this.xKv))
      {
        localObject1 = com.tencent.mm.plugin.sns.model.af.dtB().apL(this.xKv);
        if (localObject1 != null)
        {
          localObject1 = ((l)localObject1).field_draft;
          if (!bt.cw((byte[])localObject1))
          {
            localObject2 = Parcel.obtain();
            ((Parcel)localObject2).unmarshall((byte[])localObject1, 0, localObject1.length);
            ((Parcel)localObject2).setDataPosition(0);
            setIntent((Intent)Intent.CREATOR.createFromParcel((Parcel)localObject2));
          }
        }
      }
      VL();
      this.xrU = ((SnsEditText)findViewById(2131304971));
      if (!bt.isNullOrNil(getIntent().getStringExtra("Kdescription")))
      {
        this.xrU.setText(com.tencent.mm.ui.f.c.b.c(getContext(), getIntent().getStringExtra("Kdescription"), this.xrU.getTextSize()));
        if (this.xnE == 8)
        {
          localObject1 = getIntent().getStringExtra("Kdescription");
          this.xrU.setText(com.tencent.mm.ui.f.c.b.c(getContext(), (CharSequence)localObject1, this.xrU.getTextSize()));
        }
        this.xrU.setPasterLen(getIntent().getIntExtra("KparseLen", 0));
        this.rux = ((KeyboardLinearLayout)findViewById(2131304239));
        this.xKn = ((SnsUploadSayFooter)findViewById(2131304290));
        this.xKn.setMMEditText(this.xrU);
        this.xKn.setVisibility(4);
        this.xKz = ((FrameLayout)findViewById(2131304243));
        this.xKz.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(176382);
            DisplayMetrics localDisplayMetrics = new DisplayMetrics();
            SnsUploadUI.this.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
            com.tencent.mm.plugin.sns.model.af.dtj();
            com.tencent.mm.plugin.sns.storage.u.hl(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
            AppMethodBeat.o(176382);
          }
        });
        this.xrU.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(176383);
            SnsUploadUI.n(SnsUploadUI.this);
            AppMethodBeat.o(176383);
          }
        });
        this.xrU.setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(176384);
            SnsUploadUI.n(SnsUploadUI.this);
            AppMethodBeat.o(176384);
            return false;
          }
        });
        localObject1 = new boolean[1];
        localObject1[0] = 0;
        this.xrU.addTextChangedListener(new SnsUploadUI.2(this, new boolean[] { true }));
        localObject2 = (WrapScollview)findViewById(2131304376);
        ((WrapScollview)localObject2).setContentView(this.xrU);
        ((WrapScollview)localObject2).setDoComputeScrollDeltaToGetChildRectOnScreen(false);
        Object localObject3 = bt.by(getIntent().getStringExtra("reportSessionId"), "");
        this.xkR = ((SnsUploadConfigView)findViewById(2131298555));
        localObject2 = this.xkR;
        if ((this.xnE != 14) || (((String)localObject3).contains("wx5dfbe0a95623607b"))) {
          break label1681;
        }
        bool = true;
        ((SnsUploadConfigView)localObject2).xKb = bool;
        if (bool)
        {
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(2842, (com.tencent.mm.al.g)localObject2);
          localObject3 = new com.tencent.mm.plugin.sns.model.i();
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a((n)localObject3, 0);
        }
        ((SnsUploadConfigView)localObject2).xph.COJ = -1000.0F;
        ((SnsUploadConfigView)localObject2).xph.COI = -1000.0F;
        if (!((SnsUploadConfigView)localObject2).xEc)
        {
          com.tencent.mm.kernel.g.afC();
          i = bt.l((Integer)com.tencent.mm.kernel.g.afB().afk().get(68404, null));
          if ((i & 0x2) == 0) {
            break label1687;
          }
          bool = true;
          ((SnsUploadConfigView)localObject2).xJV = bool;
          if ((i & 0x8) == 0) {
            break label1693;
          }
          bool = true;
          ((SnsUploadConfigView)localObject2).xJW = bool;
          if (!com.tencent.mm.ax.b.azo()) {
            ((SnsUploadConfigView)localObject2).xJW = false;
          }
          if (!com.tencent.mm.model.u.arg()) {
            ((SnsUploadConfigView)localObject2).xJV = false;
          }
        }
        ((SnsUploadConfigView)localObject2).setSyncFacebook(false);
        ((SnsUploadConfigView)localObject2).dCG();
        ((SnsUploadConfigView)localObject2).dCI();
        ((SnsUploadConfigView)localObject2).dCH();
        if (((SnsUploadConfigView)localObject2).xJW) {
          ((SnsUploadConfigView)localObject2).xKc.a((a.a)localObject2);
        }
        if (this.xnE != 0)
        {
          localObject2 = this.xkR;
          ((SnsUploadConfigView)localObject2).xJQ.setVisibility(8);
          ((SnsUploadConfigView)localObject2).xJR.setVisibility(8);
          ((SnsUploadConfigView)localObject2).xJS.setVisibility(8);
          ((SnsUploadConfigView)localObject2).xJT.setVisibility(8);
        }
        if (this.xnE == 9) {
          this.xkR.xJS.setVisibility(0);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(99572);
            SnsUploadUI.o(SnsUploadUI.this);
            AppMethodBeat.o(99572);
            return true;
          }
        });
        addTextOptionMenu(0, getString(2131763959), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(176366);
            if (SnsUploadUI.this.isFinishing())
            {
              ad.i("MicroMsg.SnsUploadUI", "skip commit, is finishing");
              AppMethodBeat.o(176366);
              return false;
            }
            if (System.currentTimeMillis() - SnsUploadUI.p(SnsUploadUI.this) < 500L)
            {
              ad.i("MicroMsg.SnsUploadUI", "skip commit, click frequently");
              AppMethodBeat.o(176366);
              return false;
            }
            if (SnsUploadUI.q(SnsUploadUI.this))
            {
              ad.i("MicroMsg.SnsUploadUI", "skip commit, has commited");
              AppMethodBeat.o(176366);
              return false;
            }
            com.tencent.mm.plugin.sns.model.af.dhI().removeCallbacks(SnsUploadUI.c(SnsUploadUI.this));
            SnsUploadUI.a(SnsUploadUI.this, null, false);
            SnsUploadUI.i(SnsUploadUI.this);
            if (this.isK[0] != 0) {
              this.isK[0] = false;
            }
            for (;;)
            {
              SnsUploadUI.a(SnsUploadUI.this, System.currentTimeMillis());
              com.tencent.mm.plugin.report.service.g.KI(22);
              paramAnonymousMenuItem = com.tencent.mm.ui.tools.b.c.d(SnsUploadUI.a(SnsUploadUI.this)).aaj(com.tencent.mm.m.b.YE());
              paramAnonymousMenuItem.HuM = true;
              paramAnonymousMenuItem.a(new c.a()
              {
                public final void CH(String paramAnonymous2String)
                {
                  AppMethodBeat.i(176364);
                  ad.i("MicroMsg.SnsUploadUI", "commit after check");
                  SnsUploadUI.a(SnsUploadUI.this, 3);
                  SnsUploadUI.r(SnsUploadUI.this);
                  int i = SnsUploadUI.s(SnsUploadUI.this).getSyncFlag();
                  com.tencent.mm.kernel.g.afC();
                  com.tencent.mm.kernel.g.afB().afk().set(68404, Integer.valueOf(i));
                  SnsUploadUI.b(SnsUploadUI.this, SnsUploadUI.a(SnsUploadUI.this).getText().toString());
                  i = SnsUploadUI.a(SnsUploadUI.this).getPasterLen();
                  int j = SnsUploadUI.s(SnsUploadUI.this).getPrivated();
                  int k = SnsUploadUI.s(SnsUploadUI.this).getSyncFlag();
                  SnsUploadUI.t(SnsUploadUI.this);
                  if (SnsUploadUI.u(SnsUploadUI.this)) {
                    SnsUploadUI.this.setResult(-1, new Intent());
                  }
                  if ((SnsUploadUI.e(SnsUploadUI.this) instanceof ak)) {
                    ((ak)SnsUploadUI.e(SnsUploadUI.this)).xqG = SnsUploadUI.v(SnsUploadUI.this).getCurLocation();
                  }
                  if ((SnsUploadUI.e(SnsUploadUI.this) instanceof ag)) {
                    SnsUploadUI.a(SnsUploadUI.this).setText("");
                  }
                  SnsUploadUI.w(SnsUploadUI.this);
                  paramAnonymous2String = new PInt();
                  Object localObject;
                  if ((SnsUploadUI.e(SnsUploadUI.this) instanceof a))
                  {
                    localObject = new Bundle();
                    ((Bundle)localObject).putInt("param_is_privated", j);
                    ((Bundle)localObject).putString("param_description", SnsUploadUI.x(SnsUploadUI.this));
                    ((Bundle)localObject).putStringArrayList("param_with_list", new ArrayList(SnsUploadUI.y(SnsUploadUI.this).getAtList()));
                    ((Bundle)localObject).putInt("param_paste_len", i);
                  }
                  for (;;)
                  {
                    try
                    {
                      ((Bundle)localObject).putByteArray("param_localtion", SnsUploadUI.v(SnsUploadUI.this).getLocation().toByteArray());
                      ((Bundle)localObject).putBoolean("param_is_black_group", SnsUploadUI.z(SnsUploadUI.this));
                      ((Bundle)localObject).putStringArrayList("param_group_user", SnsUploadUI.A(SnsUploadUI.this));
                      ((Bundle)localObject).putInt("param_contact_tag_count", SnsUploadUI.B(SnsUploadUI.this));
                      ((Bundle)localObject).putInt("param_temp_user_count", SnsUploadUI.C(SnsUploadUI.this));
                      paramAnonymous2String.value = ((a)SnsUploadUI.e(SnsUploadUI.this)).getContentType();
                      SnsUploadUI.e(SnsUploadUI.this);
                      SnsUploadUI.E(SnsUploadUI.this);
                      localObject = com.tencent.mm.plugin.report.service.h.vKh;
                      long l1 = SnsUploadUI.F(SnsUploadUI.this);
                      long l2 = bt.aGK();
                      if (!SnsUploadUI.G(SnsUploadUI.this)) {
                        break label1088;
                      }
                      i = 0;
                      ((com.tencent.mm.plugin.report.service.h)localObject).f(13303, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymous2String.value), "" });
                      l1 = SnsUploadUI.F(SnsUploadUI.this);
                      l2 = bt.aGK();
                      if (!SnsUploadUI.G(SnsUploadUI.this)) {
                        break label1093;
                      }
                      i = 0;
                      ad.d("MicroMsg.SnsUploadUI", "reprot timelinePostAction(13303), %d, %d, %d, %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymous2String.value) });
                      com.tencent.mm.plugin.report.service.h.vKh.kvStat(10910, "1");
                      if (!bt.isNullOrNil(SnsUploadUI.H(SnsUploadUI.this)))
                      {
                        if (!SnsUploadUI.z(SnsUploadUI.this)) {
                          break label1098;
                        }
                        com.tencent.mm.plugin.report.service.h.vKh.f(11455, new Object[] { "", SnsUploadUI.H(SnsUploadUI.this), Integer.valueOf(-1), Integer.valueOf(-1) });
                      }
                      if (SnsUploadUI.I(SnsUploadUI.this))
                      {
                        localObject = new Intent(SnsUploadUI.this, SnsTimeLineUI.class);
                        ((Intent)localObject).putExtra("sns_resume_state", false);
                        ((Intent)localObject).putExtra("sns_timeline_NeedFirstLoadint", true);
                        ((Intent)localObject).addFlags(67108864);
                        paramAnonymous2String = SnsUploadUI.this;
                        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/sns/ui/SnsUploadUI$12$1", "doWhenOK", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymous2String.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$12$1", "doWhenOK", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      }
                      com.tencent.mm.pluginsdk.ui.tools.o.aX(SnsUploadUI.this.getIntent());
                      paramAnonymous2String = new uf();
                      com.tencent.mm.sdk.b.a.ESL.l(paramAnonymous2String);
                      SnsUploadUI.b(SnsUploadUI.this, 1);
                      SnsUploadUI.k(SnsUploadUI.this);
                      com.tencent.mm.plugin.sns.data.q.dse();
                      AppMethodBeat.o(176364);
                      return;
                    }
                    catch (IOException localIOException)
                    {
                      ad.printErrStackTrace("MicroMsg.SnsUploadUI", localIOException, "parse location error", new Object[0]);
                      continue;
                    }
                    SnsUploadUI.e(SnsUploadUI.this).a(j, k, SnsUploadUI.s(SnsUploadUI.this).getTwitterAccessToken(), SnsUploadUI.x(SnsUploadUI.this), SnsUploadUI.y(SnsUploadUI.this).getAtList(), SnsUploadUI.v(SnsUploadUI.this).getLocation(), null, i, SnsUploadUI.z(SnsUploadUI.this), SnsUploadUI.A(SnsUploadUI.this), paramAnonymous2String, SnsUploadUI.D(SnsUploadUI.this), SnsUploadUI.B(SnsUploadUI.this), SnsUploadUI.C(SnsUploadUI.this));
                    continue;
                    label1088:
                    i = 1;
                    continue;
                    label1093:
                    i = 1;
                    continue;
                    label1098:
                    com.tencent.mm.plugin.report.service.h.vKh.f(11455, new Object[] { SnsUploadUI.H(SnsUploadUI.this), "", Integer.valueOf(-1), Integer.valueOf(-1) });
                  }
                }
                
                public final void aKr() {}
                
                public final void ck(String paramAnonymous2String)
                {
                  AppMethodBeat.i(176365);
                  com.tencent.mm.ui.base.h.j(SnsUploadUI.this, 2131764058, 2131764059);
                  AppMethodBeat.o(176365);
                }
              });
              AppMethodBeat.o(176366);
              return false;
              com.tencent.mm.plugin.normsg.a.b.ufs.hK("ce_sns_upload", "<SnsUpload>");
              paramAnonymousMenuItem = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.b.ufs.a("ce_sns_upload", paramAnonymousMenuItem);
              com.tencent.mm.plugin.normsg.a.b.ufs.ajw("ce_sns_upload");
            }
          }
        }, null, new SnsUploadUI.5(this, (boolean[])localObject1), r.b.FOB);
        findViewById(2131306218).setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(176367);
            ad.d("MicroMsg.SnsUploadUI", "upload_content onTouch");
            if (SnsUploadUI.J(SnsUploadUI.this))
            {
              AppMethodBeat.o(176367);
              return true;
            }
            AppMethodBeat.o(176367);
            return false;
          }
        });
        this.xKk = ((AtContactWidget)findViewById(2131296956));
        this.xKk.xkR = this.xkR;
        this.xKl = ((LocationWidget)findViewById(2131301546));
        this.xKl.setLocationWidgetListener(this);
        switch (this.xnE)
        {
        default: 
          this.xKm.xkR = this.xkR;
          this.xKm.setRangeTipClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(176368);
              SnsUploadUI.K(SnsUploadUI.this);
              AppMethodBeat.o(176368);
            }
          });
          this.xKl.aG(getIntent());
          this.xKk.aG(getIntent());
          com.tencent.mm.plugin.sns.k.f.wQY.MB(0);
          com.tencent.mm.plugin.sns.k.f.wQY.wRg.dVK = 2;
          aJ(getIntent());
          hideVKB();
          ai(paramBundle);
          paramBundle = com.tencent.mm.plugin.sns.model.af.dtB().apL(this.xKv);
          if ((paramBundle != null) && ((paramBundle.field_extFlag & 0x1) == 1))
          {
            m = 0;
            k = 2;
            i = m;
            j = k;
            switch (this.xnE)
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
      com.tencent.mm.plugin.report.service.h.vKh.f(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(i), this.xoO, Long.valueOf(bt.aGK()), Integer.valueOf(j) });
      com.tencent.mm.pluginsdk.g.p(this);
      paramBundle = Parcel.obtain();
      getIntent().writeToParcel(paramBundle, 0);
      this.xKw = ai.D(paramBundle.marshall());
      this.xKx = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psm, 3000L);
      this.xKB = bt.eGO();
      this.xKr = false;
      AppMethodBeat.o(99595);
      return;
      localObject1 = bw.K(bt.by(getIntent().getStringExtra("fav_note_xml"), ""), "favlocalid");
      if ((localObject1 == null) || (((Map)localObject1).size() == 0)) {
        break;
      }
      localObject1 = (String)((Map)localObject1).get(".favlocalid");
      if (bt.kU((String)localObject1, "0")) {
        break;
      }
      this.xKv = ((String)localObject1);
      break;
      localObject2 = bt.by(getIntent().getStringExtra("Ksnsupload_link"), "");
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = bt.by(getIntent().getStringExtra("ShareUrlOpen"), "");
      }
      localObject2 = localObject1;
      if (bt.isNullOrNil((String)localObject1)) {
        localObject2 = bt.by(getIntent().getStringExtra("ShareUrlOriginal"), "");
      }
      if (!bt.isNullOrNil((String)localObject2)) {
        this.xKv = com.tencent.mm.plugin.sns.data.q.anV((String)localObject2);
      }
      if (!getIntent().getBooleanExtra("ksnsis_appbrand", false)) {
        break;
      }
      this.xKv = null;
      break;
      this.xKv = bt.by(getIntent().getStringExtra("Ksnsupload_musicid"), "");
      break;
      if ((this.xrU == null) || (paramBundle == null)) {
        break label322;
      }
      localObject1 = paramBundle.getString("contentdesc");
      if (localObject1 == null) {
        break label322;
      }
      this.xrU.setText((CharSequence)localObject1);
      break label322;
      label1681:
      bool = false;
      break label610;
      label1687:
      bool = false;
      break label729;
      label1693:
      bool = false;
      break label746;
      this.xKm = ((RangeWidget)findViewById(2131303713));
      findViewById(2131303714).setVisibility(8);
      break label1096;
      this.xKm = ((RangeWidget)findViewById(2131303713));
      findViewById(2131303714).setVisibility(8);
      break label1096;
      this.xKm = ((RangeWidget)findViewById(2131303713));
      findViewById(2131303714).setVisibility(8);
      this.xKk.setVisibility(8);
      break label1096;
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
    Object localObject;
    if (this.xkR != null)
    {
      localObject = this.xkR;
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(2842, (com.tencent.mm.al.g)localObject);
    }
    if (this.xrV != null) {
      this.xrV.dyW();
    }
    if (this.xKl != null) {
      this.xKl.stop();
    }
    if (this.xKn != null)
    {
      localObject = this.xKn;
      if (((SnsUploadSayFooter)localObject).fSY != null)
      {
        ((SnsUploadSayFooter)localObject).fSY.exm();
        ((SnsUploadSayFooter)localObject).fSY.destroy();
      }
    }
    this.xKs.clear();
    com.tencent.mm.plugin.normsg.a.b.ufs.ajt("ie_sns_upload");
    com.tencent.mm.plugin.sns.data.q.dse();
    com.tencent.mm.sdk.b.a.ESL.d(this.xKD);
    AppMethodBeat.o(99604);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99597);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      paramKeyEvent = this.xKn;
      if ((paramKeyEvent.dCK()) || (paramKeyEvent.getVisibility() == 0)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        this.xKn.dCL();
        AppMethodBeat.o(99597);
        return true;
      }
      crq();
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
    AppMethodBeat.o(99602);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(99610);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.SnsUploadUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(99610);
      return;
    }
    ad.i("MicroMsg.SnsUploadUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(99610);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        this.xKl.dzf();
        AppMethodBeat.o(99610);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131755691), false, new SnsUploadUI.9(this), new SnsUploadUI.10(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99603);
    super.onResume();
    this.xKn.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176369);
        com.tencent.mm.compatible.util.i.v(SnsUploadUI.this);
        AppMethodBeat.o(176369);
      }
    });
    if ((this.xrV != null) && ((this.xrV instanceof af)))
    {
      af localaf = (af)this.xrV;
      if (localaf.xoJ != null)
      {
        if (!localaf.xoQ)
        {
          localaf.dzr();
          AppMethodBeat.o(99603);
          return;
        }
        localaf.dzs();
      }
    }
    AppMethodBeat.o(99603);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(99594);
    if (paramBundle != null)
    {
      if (this.xrU != null) {
        paramBundle.putString("contentdesc", this.xrU.getText().toString());
      }
      this.xrV.ag(paramBundle);
    }
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(99594);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(176385);
    super.onStart();
    com.tencent.mm.plugin.sns.model.af.dhI().postDelayed(this.xKy, this.xKx);
    AppMethodBeat.o(176385);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(176387);
    super.onStop();
    com.tencent.mm.plugin.sns.model.af.dhI().removeCallbacks(this.xKy);
    AppMethodBeat.o(176387);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI
 * JD-Core Version:    0.7.0.1
 */