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
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.g.a.ka.a;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.b.a.gn;
import com.tencent.mm.g.b.a.gq;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.model.j;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.k.a.a;
import com.tencent.mm.ui.s.b;
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

@i
@com.tencent.mm.ui.base.a(17)
public class SnsUploadUI
  extends MMActivity
  implements LocationWidget.a
{
  private AtContactWidget AFX;
  private LocationWidget AFY;
  private RangeWidget AFZ;
  private SnsUploadSayFooter AGa;
  private DynamicGridView AGb;
  private boolean AGc;
  private boolean AGd;
  boolean AGe;
  private Map<Integer, ac> AGf;
  private Map<String, List<String>> AGg;
  private Map<String, List<String>> AGh;
  private boolean AGi;
  private String AGj;
  private long AGk;
  private Runnable AGl;
  private FrameLayout AGm;
  private long AGn;
  private long AGo;
  private int AGp;
  private com.tencent.mm.sdk.b.c<ka> AGq;
  private SnsUploadConfigView Agc;
  private int AiS;
  private String AkC;
  private int AkD;
  private int AkE;
  private String Akg;
  private boolean Akh;
  private String AmN;
  private String AmO;
  private String AmP;
  private SnsEditText Ann;
  private ac Ano;
  private LinearLayout Anp;
  private ArrayList<String> Ans;
  private boolean Ant;
  private boolean Anu;
  private long Anv;
  private String desc;
  private int jpl;
  private boolean rHX;
  private KeyboardLinearLayout tKV;
  private String zCT;
  
  public SnsUploadUI()
  {
    AppMethodBeat.i(99593);
    this.Akh = false;
    this.AiS = 0;
    this.Anu = false;
    this.Anv = 0L;
    this.Ano = null;
    this.AmN = "";
    this.AmO = "";
    this.AmP = "";
    this.AkD = 0;
    this.AkE = 0;
    this.Ant = false;
    this.AGc = false;
    this.AGd = false;
    this.AGe = false;
    this.AkC = null;
    this.Akg = "";
    this.rHX = false;
    this.AGf = new HashMap();
    this.AGg = new HashMap();
    this.AGh = new HashMap();
    this.AGi = false;
    this.zCT = "";
    this.AGj = "";
    this.AGk = 3000L;
    this.AGl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176362);
        if (SnsUploadUI.a(SnsUploadUI.this) != null)
        {
          Object localObject = Parcel.obtain();
          SnsUploadUI.this.getIntent().putExtra("Kdescription", SnsUploadUI.a(SnsUploadUI.this).getText().toString());
          SnsUploadUI.this.getIntent().putExtra("KparseLen", SnsUploadUI.a(SnsUploadUI.this).getPasterLen());
          SnsUploadUI.b(SnsUploadUI.this);
          SnsUploadUI.this.getIntent().writeToParcel((Parcel)localObject, 0);
          localObject = ((Parcel)localObject).marshall();
          String str = com.tencent.mm.sdk.platformtools.aj.B((byte[])localObject);
          ae.d("MicroMsg.SnsUploadUI", "autoSaveDraft lastMd5:%s, newMd5:%s", new Object[] { SnsUploadUI.c(SnsUploadUI.this), str });
          if (!bu.lX(SnsUploadUI.c(SnsUploadUI.this), str))
          {
            SnsUploadUI.a(SnsUploadUI.this, str);
            SnsUploadUI.a(SnsUploadUI.this, (byte[])localObject, 1);
          }
          com.tencent.mm.plugin.sns.model.ah.dJc().postDelayed(SnsUploadUI.d(SnsUploadUI.this), SnsUploadUI.e(SnsUploadUI.this));
        }
        AppMethodBeat.o(176362);
      }
    };
    this.AGm = null;
    this.AGn = 0L;
    this.AGo = 0L;
    this.jpl = 0;
    this.AGp = 0;
    this.AGq = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(ka paramAnonymouska)
      {
        AppMethodBeat.i(176377);
        if ((paramAnonymouska != null) && (bu.lX(paramAnonymouska.dya.dyb, SnsUploadUI.this.hashCode()))) {
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.JdR, paramAnonymouska.dya.dyc);
        }
        AppMethodBeat.o(176377);
        return false;
      }
    };
    AppMethodBeat.o(99593);
  }
  
  private ac Sc(int paramInt)
  {
    AppMethodBeat.i(99614);
    Object localObject1 = (ac)this.AGf.get(Integer.valueOf(paramInt));
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (paramInt != 0) {
        break label67;
      }
      localObject1 = new an(this);
    }
    for (;;)
    {
      this.AGf.put(Integer.valueOf(paramInt), localObject1);
      localObject2 = localObject1;
      AppMethodBeat.o(99614);
      return localObject2;
      label67:
      if (paramInt == 14) {
        localObject1 = new ai(this);
      }
    }
  }
  
  private void Sd(int paramInt)
  {
    AppMethodBeat.i(176389);
    com.tencent.mm.plugin.sns.j.e.zKO.zKY.pC(this.Akg);
    com.tencent.mm.plugin.sns.j.e.zKO.zKY.epT = paramInt;
    if ((paramInt == 3) || (paramInt == 2)) {
      com.tencent.mm.plugin.sns.j.e.zKO.dZi();
    }
    AppMethodBeat.o(176389);
  }
  
  private void Z(final byte[] paramArrayOfByte, final int paramInt)
  {
    AppMethodBeat.i(220017);
    com.tencent.mm.plugin.sns.model.ah.dJc().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176380);
        long l = System.currentTimeMillis();
        com.tencent.mm.plugin.sns.model.ah.dXL().b(SnsUploadUI.h(SnsUploadUI.this), paramArrayOfByte, paramInt);
        ae.i("MicroMsg.SnsUploadUI", "saveDraft draftKey:%s, %s", new Object[] { SnsUploadUI.h(SnsUploadUI.this), Long.valueOf(bu.DD(l)) });
        AppMethodBeat.o(176380);
      }
    });
    AppMethodBeat.o(220017);
  }
  
  private void Zm()
  {
    AppMethodBeat.i(99601);
    this.Anu = getIntent().getBooleanExtra("KSnsPostManu", false);
    this.Anv = getIntent().getLongExtra("KTouchCameraTime", 0L);
    this.AiS = getIntent().getIntExtra("Ksnsupload_type", 0);
    this.Akh = getIntent().getBooleanExtra("Kis_take_photo", false);
    if (this.Akh) {}
    for (int i = 2;; i = 1)
    {
      this.AGp = i;
      this.AGc = getIntent().getBooleanExtra("need_result", false);
      this.AGd = getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false);
      this.AkC = getIntent().getStringExtra("Ksnsupload_canvas_info");
      this.Akg = getIntent().getStringExtra("KSessionID");
      this.rHX = getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
      if (!bu.isNullOrNil(this.Akg)) {
        break;
      }
      this.Akg = com.tencent.mm.plugin.sns.data.r.dWp();
      getIntent().putExtra("KSessionID", this.Akg);
      AppMethodBeat.o(99601);
      return;
    }
    this.AGp = 3;
    AppMethodBeat.o(99601);
  }
  
  private void aR(Intent paramIntent)
  {
    List localList2 = null;
    AppMethodBeat.i(99606);
    this.AFZ.a(5, -1, paramIntent, this.AFX);
    int i = paramIntent.getIntExtra("Ktag_range_index", 0);
    if (i >= 2)
    {
      this.AmN = paramIntent.getStringExtra("Klabel_name_list");
      this.AmO = paramIntent.getStringExtra("Kother_user_name_list");
      this.AmP = paramIntent.getStringExtra("Kchat_room_name_list");
      if (bu.isNullOrNil(this.AmN)) {
        break label275;
      }
    }
    label275:
    for (paramIntent = Arrays.asList(this.AmN.split(","));; paramIntent = null)
    {
      List localList1;
      if (!bu.isNullOrNil(this.AmO))
      {
        localList1 = Arrays.asList(this.AmO.split(","));
        com.tencent.mm.plugin.sns.j.e.zKO.fW(localList1);
      }
      for (;;)
      {
        if (!bu.isNullOrNil(this.AmP)) {
          localList2 = Arrays.asList(this.AmP.split(","));
        }
        p(paramIntent, localList1);
        fk(localList2);
        if (i == 2)
        {
          this.Ant = false;
          if ((this.AGg != null) && (!this.AGg.isEmpty())) {
            com.tencent.mm.plugin.sns.j.e.zKO.aQ(this.AGg);
          }
          if ((this.AGh != null) && (!this.AGh.isEmpty())) {
            com.tencent.mm.plugin.sns.j.e.zKO.aP(this.AGh);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.j.e.zKO.QS(i);
          AppMethodBeat.o(99606);
          return;
          this.Ant = true;
          break;
          if (!bu.ht(this.Ans)) {
            this.Ans.clear();
          }
        }
        localList1 = null;
      }
    }
  }
  
  private void at(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(99615);
    ae.i("MicroMsg.SnsUploadUI", "attachWidget. share type %d, isManuSnsPost:%b", new Object[] { Integer.valueOf(this.AiS), Boolean.valueOf(this.Anu) });
    Object localObject;
    if ((this.AiS == 0) || (this.AiS == 14) || (this.AiS == 9))
    {
      localObject = Parcel.obtain();
      getIntent().writeToParcel((Parcel)localObject, 0);
      ((Parcel)localObject).marshall();
      if (this.AiS != 9) {
        break label466;
      }
      setMMTitle(getContext().getResources().getString(2131764021));
    }
    RelativeLayout.LayoutParams localLayoutParams;
    label466:
    int i;
    switch (this.AiS)
    {
    default: 
    case 0: 
    case 14: 
    case 1: 
    case 11: 
    case 15: 
    case 16: 
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
        this.Ano.aq(paramBundle);
        if (!(this.Ano instanceof an)) {
          break label859;
        }
        paramBundle = findViewById(2131304970);
        localObject = findViewById(2131304985);
        this.AGb = ((DynamicGridView)findViewById(2131305045));
        this.AGb.setOnTouchListener(new SnsUploadUI.14(this));
        paramBundle = ((an)this.Ano).a(paramBundle, findViewById(2131298953), this.AGb, (View)localObject);
        this.AGb.setVisibility(0);
        localObject = findViewById(2131306994);
        localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        localLayoutParams.topMargin = 0;
        localLayoutParams.addRule(3, 2131305045);
        ((View)localObject).setLayoutParams(localLayoutParams);
        if (((this.Ano instanceof ad)) || ((this.Ano instanceof af)))
        {
          localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).width = -1;
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if (((this.Ano instanceof q)) || ((this.Ano instanceof o)) || ((this.Ano instanceof p)))
        {
          localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).width = -1;
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        ehl();
        if (this.AiS == 0) {
          ehi();
        }
        AppMethodBeat.o(99615);
        return;
        setMMTitle("");
        break;
        this.zCT = "draft_normal";
        this.Ano = Sc(this.AiS);
        this.Ann.addTextChangedListener(new TextWatcher()
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
        this.zCT = "draft_normal";
        this.Ano = Sc(this.AiS);
        continue;
        this.Ano = new ad(this);
        continue;
        this.Ano = new ah(this);
        continue;
        this.Ano = new ao(this, 9);
        continue;
        this.Ano = new ao(this, 12);
        continue;
        this.Ano = new q(this);
        continue;
        this.Ano = new o(this);
        continue;
        this.Ano = new r(this);
        continue;
        this.Ano = new p(this);
        continue;
        this.Ano = new ao(this, 14);
        continue;
        this.Ano = new ao(this, 13);
      }
    case 9: 
      this.zCT = "draft_text";
      localObject = bu.bI(getIntent().getStringExtra("Kdescription"), "");
      i = bu.a(Integer.valueOf(getIntent().getIntExtra("KparseLen", 0)), 0);
      if ((localObject == null) || (bu.isNullOrNil(((String)localObject).trim()))) {
        break;
      }
    }
    for (;;)
    {
      this.Ano = new aj(this, bool);
      this.Ann.setPasterLen(i);
      this.Ann.setText(com.tencent.mm.ui.f.c.b.c(getContext(), (CharSequence)localObject, this.Ann.getTextSize()));
      this.Ann.addTextChangedListener(new TextWatcher()
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
      this.Ano = new bm(this);
      break;
      this.Ano = new af(this);
      break;
      this.Ano = new t(this);
      break;
      label859:
      paramBundle = this.Ano.edm();
      this.Anp = ((LinearLayout)findViewById(2131306993));
      this.Anp.setVisibility(0);
      this.Anp.setClipChildren(false);
      label920:
      float f;
      if (paramBundle != null)
      {
        ae.d("MicroMsg.SnsUploadUI", "will add widget view in widgetLL.");
        this.Anp.addView(paramBundle);
        if ((this.AiS == 9) || (this.AiS == 14))
        {
          localObject = findViewById(2131306994);
          localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
          localLayoutParams.addRule(3, 2131306993);
          f = com.tencent.mm.sdk.platformtools.h.aRe().density;
          if (this.AiS != 9) {
            break label1018;
          }
        }
      }
      label1018:
      for (i = 128;; i = 96)
      {
        localLayoutParams.topMargin = ((int)(i * f));
        ((View)localObject).setLayoutParams(localLayoutParams);
        break;
        this.Anp.setVisibility(8);
        break label920;
      }
      bool = false;
    }
  }
  
  private void cMH()
  {
    AppMethodBeat.i(99598);
    if (((this.AiS == 0) && (((an)this.Ano).eep() > 0)) || ((this.AiS == 14) && ((this.Ano instanceof ai)) && (!((ai)this.Ano).Aki)) || ((this.AiS == 9) && (!bu.isNullOrNil(this.Ann.getText().toString()))))
    {
      com.tencent.mm.ui.base.h.a(this, 2131764054, 0, 2131764056, 2131764055, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(99587);
          ae.i("MicroMsg.SnsUploadUI", "exitAndSave shareType:%s realtimeType:%s", new Object[] { Integer.valueOf(SnsUploadUI.i(SnsUploadUI.this)), Integer.valueOf(SnsUploadUI.this.getIntent().getIntExtra("Ksnsupload_type", -1)) });
          SnsUploadUI.a(SnsUploadUI.this, 1);
          paramAnonymousDialogInterface = Parcel.obtain();
          SnsUploadUI.this.getIntent().putExtra("Kdescription", SnsUploadUI.a(SnsUploadUI.this).getText().toString());
          SnsUploadUI.this.getIntent().putExtra("KparseLen", SnsUploadUI.a(SnsUploadUI.this).getPasterLen());
          SnsUploadUI.b(SnsUploadUI.this);
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
            com.tencent.mm.plugin.report.service.g.yxI.f(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(paramAnonymousInt), SnsUploadUI.k(SnsUploadUI.this), Long.valueOf(bu.aRi()), Integer.valueOf(1) });
            SnsUploadUI.b(SnsUploadUI.this, 3);
            SnsUploadUI.l(SnsUploadUI.this);
            if (SnsUploadUI.m(SnsUploadUI.this))
            {
              com.tencent.mm.plugin.sns.j.e.zKO.zLy.eqy = 2L;
              com.tencent.mm.plugin.sns.j.e.zKO.dZq();
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
          com.tencent.mm.plugin.sns.model.ah.dJc().removeCallbacks(SnsUploadUI.d(SnsUploadUI.this));
          SnsUploadUI.a(SnsUploadUI.this, null, 0);
          SnsUploadUI.j(SnsUploadUI.this);
          paramAnonymousDialogInterface = SnsUploadUI.this.getIntent().getStringExtra("KSightThumbPath");
          Object localObject = SnsUploadUI.this.getIntent().getStringExtra("KSightPath");
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFX, true))
          {
            com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.yhe;
            com.tencent.mm.plugin.recordvideo.e.b.axi((String)localObject);
            localObject = com.tencent.mm.plugin.recordvideo.e.b.yhe;
            com.tencent.mm.plugin.recordvideo.e.b.axi(paramAnonymousDialogInterface);
          }
          if ((SnsUploadUI.f(SnsUploadUI.this) instanceof aj)) {
            SnsUploadUI.a(SnsUploadUI.this).setText("");
          }
          switch (SnsUploadUI.i(SnsUploadUI.this))
          {
          default: 
            paramAnonymousInt = 0;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(paramAnonymousInt), SnsUploadUI.k(SnsUploadUI.this), Long.valueOf(bu.aRi()), Integer.valueOf(0) });
            SnsUploadUI.b(SnsUploadUI.this, 2);
            SnsUploadUI.l(SnsUploadUI.this);
            if (SnsUploadUI.m(SnsUploadUI.this))
            {
              com.tencent.mm.plugin.sns.j.e.zKO.zLy.eqy = 3L;
              com.tencent.mm.plugin.sns.j.e.zKO.dZq();
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
      }, 2131099903);
      AppMethodBeat.o(99598);
      return;
    }
    if (((this.Ano instanceof ad)) || ((this.Ano instanceof ah)))
    {
      if (!bu.isNullOrNil(this.Ann.getText().toString()))
      {
        com.tencent.mm.plugin.sns.model.ah.dJc().removeCallbacks(this.AGl);
        Parcel localParcel = Parcel.obtain();
        getIntent().putExtra("Kdescription", this.Ann.getText().toString());
        getIntent().putExtra("KparseLen", this.Ann.getPasterLen());
        ehj();
        getIntent().writeToParcel(localParcel, 0);
        Z(localParcel.marshall(), 0);
        com.tencent.mm.plugin.report.service.g.yxI.f(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(7), this.Akg, Long.valueOf(bu.aRi()), Integer.valueOf(3) });
      }
      ehn();
      Sd(2);
      if (this.AGi)
      {
        com.tencent.mm.plugin.sns.j.e.zKO.zLy.eqy = 2L;
        com.tencent.mm.plugin.sns.j.e.zKO.dZq();
      }
      eho();
      ehk();
      AppMethodBeat.o(99598);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, 2131764053, 0, 2131755277, 2131755691, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(176381);
        com.tencent.mm.plugin.sns.model.ah.dJc().removeCallbacks(SnsUploadUI.d(SnsUploadUI.this));
        SnsUploadUI.a(SnsUploadUI.this, null, 0);
        SnsUploadUI.j(SnsUploadUI.this);
        SnsUploadUI.b(SnsUploadUI.this, 2);
        SnsUploadUI.l(SnsUploadUI.this);
        if (SnsUploadUI.m(SnsUploadUI.this))
        {
          com.tencent.mm.plugin.sns.j.e.zKO.zLy.eqy = 3L;
          com.tencent.mm.plugin.sns.j.e.zKO.dZq();
        }
        SnsUploadUI.o(SnsUploadUI.this);
        AppMethodBeat.o(176381);
      }
    }, null, 2131099904);
    AppMethodBeat.o(99598);
  }
  
  @TargetApi(11)
  private void ehi()
  {
    AppMethodBeat.i(99596);
    if (!(this.Ano instanceof an))
    {
      ae.e("MicroMsg.SnsUploadUI", "!(widget instanceof PicWidget)");
      AppMethodBeat.o(99596);
      return;
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      ae.d("MicroMsg.SnsUploadUI", "sdk not support dragdrop event");
      AppMethodBeat.o(99596);
      return;
    }
    new SnsUploadUI.12(this).run();
    AppMethodBeat.o(99596);
  }
  
  private void ehj()
  {
    AppMethodBeat.i(220016);
    getIntent().putExtra("Kis_retry_edit", false);
    AppMethodBeat.o(220016);
  }
  
  private void ehk()
  {
    AppMethodBeat.i(99599);
    if (this.rHX)
    {
      com.tencent.mm.plugin.sns.j.e locale = com.tencent.mm.plugin.sns.j.e.zKO;
      com.tencent.mm.plugin.sns.j.e.a(10, "", 0, 0, ch.aDb(), 0);
    }
    setResult(0, new Intent());
    finish();
    com.tencent.mm.plugin.sns.data.r.dWq();
    AppMethodBeat.o(99599);
  }
  
  private void ehn()
  {
    AppMethodBeat.i(176388);
    if (this.AiS == 9)
    {
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMV, this.Akg);
      AppMethodBeat.o(176388);
      return;
    }
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMU, this.Akg);
    AppMethodBeat.o(176388);
  }
  
  private void eho()
  {
    AppMethodBeat.i(176390);
    com.tencent.mm.plugin.expt.b.c localc = (com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.c.class);
    localc.fR("startTime", this.AGo);
    localc.fR("endTime", bu.fpO());
    localc.fR("bussinessId", this.Akg);
    localc.fR("shareType", this.AiS);
    localc.fR("hadLocation", this.AFY.getShowFlag());
    localc.fR("desc", this.Ann.getText().toString());
    localc.fR("nextStep", this.jpl);
    localc.fR("beforeStep", this.AGp);
    localc.fR("ContactTagCount", this.AkD);
    localc.fR("mIsBlackGroup", this.Ant);
    if (this.Ans != null)
    {
      localObject1 = this.Ans.size();
      localc.fR("mContactNameList", (String)localObject1);
      if (!(this.Ano instanceof an)) {
        break label423;
      }
      Object localObject2 = ((an)this.Ano).eer();
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
    localc.fR("picSource", ((StringBuilder)localObject1).toString());
    label423:
    if ((this.Ano instanceof ai)) {
      if (!((ai)this.Ano).edJ()) {
        break label467;
      }
    }
    label467:
    for (Object localObject1 = "1";; localObject1 = "2")
    {
      localc.fR("sightSource", (String)localObject1);
      AppMethodBeat.o(176390);
      return;
    }
  }
  
  private void fk(List<String> paramList)
  {
    AppMethodBeat.i(99607);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(99607);
      return;
    }
    this.AGh.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str1 = (String)paramList.next();
      ArrayList localArrayList = new ArrayList();
      Object localObject = com.tencent.mm.model.r.zB(str1);
      if (localObject != null)
      {
        ae.d("MicroMsg.SnsUploadUI", "getContactNamesFromChatroom chatromm:%s membersCount:%s", new Object[] { str1, Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          if ((!this.Ans.contains(str2)) && (x.An(str2)))
          {
            ae.i("MicroMsg.SnsUploadUI", "getContactNamesFromChatroom memberName:%s", new Object[] { str2 });
            this.Ans.add(str2);
            this.AkE += 1;
          }
          if (x.An(str2)) {
            localArrayList.add(str2);
          }
        }
        ae.d("MicroMsg.SnsUploadUI", "%s , %s", new Object[] { str1, Integer.valueOf(localArrayList.size()) });
        this.AGh.put(str1, localArrayList);
      }
    }
    AppMethodBeat.o(99607);
  }
  
  private void p(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(99608);
    this.Ans = new ArrayList();
    this.AkD = 0;
    this.AGg.clear();
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
        localList = com.tencent.mm.plugin.label.a.a.dig().apr(com.tencent.mm.plugin.label.a.a.dig().apo(str1));
        if ((localList == null) || (localList.size() == 0)) {
          ae.e("MicroMsg.SnsUploadUI", "dz: getContactNamesFromLabelsAndOtherUserName,namelist get bu label is null");
        }
      }
      else
      {
        this.Ans = new ArrayList(localHashSet);
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
      if (bu.isNullOrNil((String)paramList1.next())) {
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
        this.AkD += 1;
        ae.d("MicroMsg.SnsUploadUI", "dz:name : %s", new Object[] { str2 });
      }
      this.AGg.put(str1, localList);
      break;
      this.AkD = i;
      this.AkE = 0;
      if ((paramList2 != null) && (paramList2.size() > 0))
      {
        paramList1 = paramList2.iterator();
        while (paramList1.hasNext())
        {
          paramList2 = (String)paramList1.next();
          if (!this.Ans.contains(paramList2))
          {
            this.Ans.add(paramList2);
            this.AkE += 1;
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
    ae.i("MicroMsg.SnsUploadUI", "updateSightConfig");
    getIntent().getExtras().clear();
    getIntent().putExtra("KSightPath", paramString1);
    getIntent().putExtra("KSightThumbPath", paramString2);
    getIntent().putExtra("sight_md5", paramString3);
    getIntent().putExtra("KSnsPostManu", true);
    getIntent().putExtra("Ksnsupload_type", 14);
    getIntent().putExtra("Kis_take_photo", false);
    getIntent().putExtra("KMMSightExtInfo", paramArrayOfByte);
    if (paramBoolean) {
      getIntent().putExtra("KSessionID", bu.fpO() + "_" + bu.abf(5));
    }
    AppMethodBeat.o(99612);
  }
  
  public final void a(String paramString, boolean paramBoolean, int paramInt1, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int paramInt2)
  {
    AppMethodBeat.i(99611);
    ae.i("MicroMsg.SnsUploadUI", "updatePicConfig");
    getIntent().getExtras().clear();
    getIntent().putExtra("KTouchCameraTime", bu.aRi());
    getIntent().putExtra("KSnsPostManu", true);
    getIntent().putExtra("Ksnsupload_type", 0);
    getIntent().putExtra("KFilterId", paramInt1);
    if (!bu.isNullOrNil(paramString)) {
      getIntent().putExtra("sns_kemdia_path", paramString);
    }
    if (!bu.ht(paramArrayList1)) {
      getIntent().putExtra("sns_kemdia_path_list", paramArrayList1);
    }
    if (!bu.ht(paramArrayList2)) {
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
  
  public final ArrayList<Exif.a> edA()
  {
    AppMethodBeat.i(99609);
    if ((this.Ano instanceof an))
    {
      an localan = (an)this.Ano;
      Object localObject1 = localan.AlT.Ame;
      ArrayList localArrayList = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (Exif.a)localan.AlV.get(localObject2);
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
  
  public final boolean edB()
  {
    return this.Akh;
  }
  
  public final void ehl()
  {
    AppMethodBeat.i(99600);
    if (this.Ano.edl())
    {
      enableOptionMenu(true);
      AppMethodBeat.o(99600);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(99600);
  }
  
  public final void ehm()
  {
    AppMethodBeat.i(99613);
    ae.i("MicroMsg.SnsUploadUI", "resetWidget");
    if (this.AGb != null) {
      this.AGb.setVisibility(8);
    }
    if (this.Anp != null)
    {
      this.Anp.removeAllViews();
      this.Anp.setVisibility(8);
    }
    if (this.Ano != null) {
      this.Ano.edo();
    }
    Zm();
    at(null);
    AppMethodBeat.o(99613);
  }
  
  public int getLayoutId()
  {
    return 2131495620;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99605);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.Ann != null) {
      this.Ann.clearFocus();
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
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYR, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(getContext(), "android.permission.ACCESS_COARSE_LOCATION", 64);
      }
      AppMethodBeat.o(99605);
      return;
    }
    if (this.Ano.k(paramInt1, paramIntent)) {
      ehl();
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
      aR(paramIntent);
      AppMethodBeat.o(99605);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      getIntent().putExtras(paramIntent.getExtras());
      this.AFX.aO(paramIntent);
      AppMethodBeat.o(99605);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      boolean bool = paramIntent.getBooleanExtra("bind_facebook_succ", false);
      paramIntent = this.Agc;
      if (bool)
      {
        paramIntent.AFI = true;
        paramIntent.setSyncFacebook(true);
      }
      AppMethodBeat.o(99605);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      String str1 = bu.bI(paramIntent.getStringExtra("get_poi_name"), "");
      String str2 = bu.bI(paramIntent.getStringExtra("get_city"), "");
      if (bu.isNullOrNil(str1)) {
        getIntent().removeExtra("get_poi_name");
      }
      if (bu.isNullOrNil(str2)) {
        getIntent().removeExtra("get_city");
      }
      getIntent().putExtras(paramIntent.getExtras());
      this.AFY.aO(paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99595);
    ae.i("MicroMsg.SnsUploadUI", "onCreate");
    com.tencent.mm.pluginsdk.h.q(this);
    super.onCreate(paramBundle);
    setActionbarColor(getContext().getResources().getColor(2131099650));
    hideActionbarLine();
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    com.tencent.mm.plugin.sns.model.ah.dXL().db.delete("snsDraft", "key!=? AND key!=? AND timestamp<?", new String[] { "draft_text", "draft_normal", String.valueOf(System.currentTimeMillis() - 86400000L) });
    this.AGi = getIntent().getBooleanExtra("Kis_retry_edit", false);
    Object localObject1;
    Object localObject2;
    label345:
    boolean bool;
    label633:
    int i;
    label752:
    int m;
    label769:
    label1124:
    int k;
    int j;
    switch (getIntent().getIntExtra("Ksnsupload_type", 0))
    {
    default: 
      if ((!bu.isNullOrNil(this.zCT)) && (!this.AGi))
      {
        localObject1 = com.tencent.mm.plugin.sns.model.ah.dXL().aBs(this.zCT);
        if (localObject1 != null)
        {
          localObject1 = ((l)localObject1).field_draft;
          if (!bu.cF((byte[])localObject1))
          {
            localObject2 = Parcel.obtain();
            ((Parcel)localObject2).unmarshall((byte[])localObject1, 0, localObject1.length);
            ((Parcel)localObject2).setDataPosition(0);
            setIntent((Intent)Intent.CREATOR.createFromParcel((Parcel)localObject2));
          }
        }
      }
      Zm();
      this.Ann = ((SnsEditText)findViewById(2131304971));
      if (!bu.isNullOrNil(getIntent().getStringExtra("Kdescription")))
      {
        this.Ann.setText(com.tencent.mm.ui.f.c.b.c(getContext(), getIntent().getStringExtra("Kdescription"), this.Ann.getTextSize()));
        if (this.AiS == 8)
        {
          localObject1 = getIntent().getStringExtra("Kdescription");
          this.Ann.setText(com.tencent.mm.ui.f.c.b.c(getContext(), (CharSequence)localObject1, this.Ann.getTextSize()));
        }
        this.Ann.setPasterLen(getIntent().getIntExtra("KparseLen", 0));
        this.tKV = ((KeyboardLinearLayout)findViewById(2131304239));
        this.AGa = ((SnsUploadSayFooter)findViewById(2131304290));
        this.AGa.setMMEditText(this.Ann);
        this.AGa.setVisibility(4);
        this.AGm = ((FrameLayout)findViewById(2131304243));
        this.AGm.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(176382);
            DisplayMetrics localDisplayMetrics = new DisplayMetrics();
            SnsUploadUI.this.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
            com.tencent.mm.plugin.sns.model.ah.dXt();
            u.hO(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
            AppMethodBeat.o(176382);
          }
        });
        this.Ann.setOnClickListener(new SnsUploadUI.21(this));
        this.Ann.setOnLongClickListener(new SnsUploadUI.22(this));
        localObject1 = new boolean[1];
        localObject1[0] = 0;
        this.Ann.addTextChangedListener(new SnsUploadUI.2(this, new boolean[] { true }));
        localObject2 = (WrapScollview)findViewById(2131304376);
        ((WrapScollview)localObject2).setContentView(this.Ann);
        ((WrapScollview)localObject2).setDoComputeScrollDeltaToGetChildRectOnScreen(false);
        Object localObject3 = bu.bI(getIntent().getStringExtra("reportSessionId"), "");
        this.Agc = ((SnsUploadConfigView)findViewById(2131298555));
        localObject2 = this.Agc;
        if ((this.AiS != 14) || (((String)localObject3).contains("wx5dfbe0a95623607b"))) {
          break label1709;
        }
        bool = true;
        ((SnsUploadConfigView)localObject2).AFO = bool;
        if (bool)
        {
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajQ().gDv.a(2842, (com.tencent.mm.ak.f)localObject2);
          localObject3 = new j();
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajQ().gDv.a((n)localObject3, 0);
        }
        ((SnsUploadConfigView)localObject2).Aky.Gha = -1000.0F;
        ((SnsUploadConfigView)localObject2).Aky.GgZ = -1000.0F;
        if (!((SnsUploadConfigView)localObject2).sVq)
        {
          com.tencent.mm.kernel.g.ajS();
          i = bu.o((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(68404, null));
          if ((i & 0x2) == 0) {
            break label1715;
          }
          bool = true;
          ((SnsUploadConfigView)localObject2).AFI = bool;
          if ((i & 0x8) == 0) {
            break label1721;
          }
          bool = true;
          ((SnsUploadConfigView)localObject2).AFJ = bool;
          if (!com.tencent.mm.aw.b.aJG()) {
            ((SnsUploadConfigView)localObject2).AFJ = false;
          }
          if (!v.aBf()) {
            ((SnsUploadConfigView)localObject2).AFI = false;
          }
        }
        ((SnsUploadConfigView)localObject2).setSyncFacebook(false);
        ((SnsUploadConfigView)localObject2).ehc();
        ((SnsUploadConfigView)localObject2).ehe();
        ((SnsUploadConfigView)localObject2).ehd();
        if (((SnsUploadConfigView)localObject2).AFJ) {
          ((SnsUploadConfigView)localObject2).AFP.a((a.a)localObject2);
        }
        if (this.AiS != 0)
        {
          localObject2 = this.Agc;
          ((SnsUploadConfigView)localObject2).AFD.setVisibility(8);
          ((SnsUploadConfigView)localObject2).AFE.setVisibility(8);
          ((SnsUploadConfigView)localObject2).AFF.setVisibility(8);
          ((SnsUploadConfigView)localObject2).AFG.setVisibility(8);
        }
        if (this.AiS == 9) {
          this.Agc.AFF.setVisibility(0);
        }
        setBackBtn(new SnsUploadUI.3(this));
        addTextOptionMenu(0, getString(2131763959), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(176366);
            if (SnsUploadUI.this.isFinishing())
            {
              ae.i("MicroMsg.SnsUploadUI", "skip commit, is finishing");
              AppMethodBeat.o(176366);
              return false;
            }
            if ((SnsUploadUI.f(SnsUploadUI.this) != null) && (!SnsUploadUI.f(SnsUploadUI.this).edn()))
            {
              ae.i("MicroMsg.SnsUploadUI", "skip commit, beforeCommit: false");
              AppMethodBeat.o(176366);
              return false;
            }
            if (System.currentTimeMillis() - SnsUploadUI.r(SnsUploadUI.this) < 500L)
            {
              ae.i("MicroMsg.SnsUploadUI", "skip commit, click frequently");
              AppMethodBeat.o(176366);
              return false;
            }
            if (SnsUploadUI.s(SnsUploadUI.this))
            {
              ae.i("MicroMsg.SnsUploadUI", "skip commit, has commited");
              AppMethodBeat.o(176366);
              return false;
            }
            com.tencent.mm.plugin.sns.model.ah.dJc().removeCallbacks(SnsUploadUI.d(SnsUploadUI.this));
            paramAnonymousMenuItem = Parcel.obtain();
            SnsUploadUI.this.getIntent().putExtra("Kdescription", SnsUploadUI.a(SnsUploadUI.this).getText().toString());
            SnsUploadUI.this.getIntent().putExtra("KparseLen", SnsUploadUI.a(SnsUploadUI.this).getPasterLen());
            SnsUploadUI.b(SnsUploadUI.this);
            SnsUploadUI.this.getIntent().writeToParcel(paramAnonymousMenuItem, 0);
            paramAnonymousMenuItem = paramAnonymousMenuItem.marshall();
            SnsUploadUI.a(SnsUploadUI.this, paramAnonymousMenuItem, 2);
            SnsUploadUI.j(SnsUploadUI.this);
            if (this.joR[0] != 0) {
              this.joR[0] = false;
            }
            for (;;)
            {
              SnsUploadUI.a(SnsUploadUI.this, System.currentTimeMillis());
              com.tencent.mm.plugin.report.service.f.OP(22);
              paramAnonymousMenuItem = com.tencent.mm.ui.tools.b.c.d(SnsUploadUI.a(SnsUploadUI.this)).afD(com.tencent.mm.n.b.ack());
              paramAnonymousMenuItem.LiL = true;
              paramAnonymousMenuItem.a(new c.a()
              {
                public final void Ky(String paramAnonymous2String)
                {
                  AppMethodBeat.i(176364);
                  ae.i("MicroMsg.SnsUploadUI", "commit after check");
                  SnsUploadUI.a(SnsUploadUI.this, 3);
                  SnsUploadUI.t(SnsUploadUI.this);
                  int i = SnsUploadUI.u(SnsUploadUI.this).getSyncFlag();
                  com.tencent.mm.kernel.g.ajS();
                  com.tencent.mm.kernel.g.ajR().ajA().set(68404, Integer.valueOf(i));
                  SnsUploadUI.b(SnsUploadUI.this, SnsUploadUI.a(SnsUploadUI.this).getText().toString());
                  i = SnsUploadUI.a(SnsUploadUI.this).getPasterLen();
                  int j = SnsUploadUI.u(SnsUploadUI.this).getPrivated();
                  int k = SnsUploadUI.u(SnsUploadUI.this).getSyncFlag();
                  SnsUploadUI.v(SnsUploadUI.this);
                  if (SnsUploadUI.w(SnsUploadUI.this)) {
                    SnsUploadUI.this.setResult(-1, new Intent());
                  }
                  if ((SnsUploadUI.f(SnsUploadUI.this) instanceof an)) {
                    ((an)SnsUploadUI.f(SnsUploadUI.this)).AlZ = SnsUploadUI.x(SnsUploadUI.this).getCurLocation();
                  }
                  if ((SnsUploadUI.f(SnsUploadUI.this) instanceof aj)) {
                    SnsUploadUI.a(SnsUploadUI.this).setText("");
                  }
                  SnsUploadUI.y(SnsUploadUI.this);
                  paramAnonymous2String = new PInt();
                  Object localObject;
                  if ((SnsUploadUI.f(SnsUploadUI.this) instanceof a))
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
                      paramAnonymous2String.value = ((a)SnsUploadUI.f(SnsUploadUI.this)).getContentType();
                      SnsUploadUI.f(SnsUploadUI.this);
                      SnsUploadUI.G(SnsUploadUI.this);
                      localObject = com.tencent.mm.plugin.report.service.g.yxI;
                      long l1 = SnsUploadUI.H(SnsUploadUI.this);
                      long l2 = bu.aRi();
                      if (!SnsUploadUI.I(SnsUploadUI.this)) {
                        break label1111;
                      }
                      i = 0;
                      ((com.tencent.mm.plugin.report.service.g)localObject).f(13303, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymous2String.value), "" });
                      l1 = SnsUploadUI.H(SnsUploadUI.this);
                      l2 = bu.aRi();
                      if (!SnsUploadUI.I(SnsUploadUI.this)) {
                        break label1116;
                      }
                      i = 0;
                      ae.d("MicroMsg.SnsUploadUI", "reprot timelinePostAction(13303), %d, %d, %d, %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymous2String.value) });
                      com.tencent.mm.plugin.report.service.g.yxI.kvStat(10910, "1");
                      if (!bu.isNullOrNil(SnsUploadUI.J(SnsUploadUI.this)))
                      {
                        if (!SnsUploadUI.B(SnsUploadUI.this)) {
                          break label1121;
                        }
                        com.tencent.mm.plugin.report.service.g.yxI.f(11455, new Object[] { "", SnsUploadUI.J(SnsUploadUI.this), Integer.valueOf(-1), Integer.valueOf(-1) });
                      }
                      if (SnsUploadUI.K(SnsUploadUI.this))
                      {
                        localObject = new Intent(SnsUploadUI.this, SnsTimeLineUI.class);
                        ((Intent)localObject).putExtra("sns_resume_state", false);
                        ((Intent)localObject).putExtra("sns_timeline_NeedFirstLoadint", true);
                        ((Intent)localObject).addFlags(67108864);
                        paramAnonymous2String = SnsUploadUI.this;
                        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/sns/ui/SnsUploadUI$12$1", "doWhenOK", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymous2String.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$12$1", "doWhenOK", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      }
                      com.tencent.mm.pluginsdk.ui.tools.o.be(SnsUploadUI.this.getIntent());
                      paramAnonymous2String = new vm();
                      com.tencent.mm.sdk.b.a.IvT.l(paramAnonymous2String);
                      SnsUploadUI.b(SnsUploadUI.this, 1);
                      SnsUploadUI.l(SnsUploadUI.this);
                      if (!SnsUploadUI.m(SnsUploadUI.this)) {
                        break label1169;
                      }
                      com.tencent.mm.plugin.sns.j.e.zKO.zLy.eqy = 1L;
                      com.tencent.mm.plugin.sns.data.r.dWq();
                      AppMethodBeat.o(176364);
                      return;
                    }
                    catch (IOException localIOException)
                    {
                      ae.printErrStackTrace("MicroMsg.SnsUploadUI", localIOException, "parse location error", new Object[0]);
                      continue;
                    }
                    SnsUploadUI.f(SnsUploadUI.this).a(j, k, SnsUploadUI.u(SnsUploadUI.this).getTwitterAccessToken(), SnsUploadUI.z(SnsUploadUI.this), SnsUploadUI.A(SnsUploadUI.this).getAtList(), SnsUploadUI.x(SnsUploadUI.this).getLocation(), null, i, SnsUploadUI.B(SnsUploadUI.this), SnsUploadUI.C(SnsUploadUI.this), paramAnonymous2String, SnsUploadUI.F(SnsUploadUI.this), SnsUploadUI.D(SnsUploadUI.this), SnsUploadUI.E(SnsUploadUI.this));
                    continue;
                    label1111:
                    i = 1;
                    continue;
                    label1116:
                    i = 1;
                    continue;
                    label1121:
                    com.tencent.mm.plugin.report.service.g.yxI.f(11455, new Object[] { SnsUploadUI.J(SnsUploadUI.this), "", Integer.valueOf(-1), Integer.valueOf(-1) });
                    continue;
                    label1169:
                    com.tencent.mm.plugin.sns.j.e.zKO.zLy.pE(SnsUploadUI.k(SnsUploadUI.this));
                    com.tencent.mm.plugin.sns.j.e.zKO.zLx.pE(SnsUploadUI.k(SnsUploadUI.this));
                  }
                }
                
                public final void aUT() {}
                
                public final void cW(String paramAnonymous2String)
                {
                  AppMethodBeat.i(176365);
                  com.tencent.mm.ui.base.h.l(SnsUploadUI.this, 2131764058, 2131764059);
                  AppMethodBeat.o(176365);
                }
              });
              AppMethodBeat.o(176366);
              return false;
              com.tencent.mm.plugin.normsg.a.b.wJt.iu("ce_sns_upload", "<SnsUpload>");
              paramAnonymousMenuItem = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.b.wJt.a("ce_sns_upload", paramAnonymousMenuItem);
              com.tencent.mm.plugin.normsg.a.b.wJt.auH("ce_sns_upload");
            }
          }
        }, null, new SnsUploadUI.5(this, (boolean[])localObject1), s.b.JwA);
        findViewById(2131306218).setOnTouchListener(new SnsUploadUI.6(this));
        this.AFX = ((AtContactWidget)findViewById(2131296956));
        this.AFX.Agc = this.Agc;
        this.AFY = ((LocationWidget)findViewById(2131301546));
        this.AFY.setLocationWidgetListener(this);
        switch (this.AiS)
        {
        default: 
          this.AFZ.Agc = this.Agc;
          this.AFZ.setRangeTipClickListener(new SnsUploadUI.7(this));
          this.AFY.aO(getIntent());
          this.AFX.aO(getIntent());
          com.tencent.mm.plugin.sns.j.e.zKO.QS(0);
          com.tencent.mm.plugin.sns.j.e.zKO.zKY.epD = 2;
          aR(getIntent());
          hideVKB();
          at(paramBundle);
          paramBundle = com.tencent.mm.plugin.sns.model.ah.dXL().aBs(this.zCT);
          if ((paramBundle != null) && ((paramBundle.field_extFlag & 0x1) == 1))
          {
            m = 0;
            k = 2;
            i = m;
            j = k;
            switch (this.AiS)
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
      com.tencent.mm.plugin.report.service.g.yxI.f(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(i), this.Akg, Long.valueOf(bu.aRi()), Integer.valueOf(j) });
      com.tencent.mm.pluginsdk.h.r(this);
      paramBundle = Parcel.obtain();
      getIntent().writeToParcel(paramBundle, 0);
      this.AGj = com.tencent.mm.sdk.platformtools.aj.B(paramBundle.marshall());
      this.AGk = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qIE, 3000L);
      this.AGo = bu.fpO();
      this.AGe = false;
      AppMethodBeat.o(99595);
      return;
      localObject1 = bx.M(bu.bI(getIntent().getStringExtra("fav_note_xml"), ""), "favlocalid");
      if ((localObject1 == null) || (((Map)localObject1).size() == 0)) {
        break;
      }
      localObject1 = (String)((Map)localObject1).get(".favlocalid");
      if (bu.lX((String)localObject1, "0")) {
        break;
      }
      this.zCT = ((String)localObject1);
      break;
      localObject2 = bu.bI(getIntent().getStringExtra("Ksnsupload_link"), "");
      localObject1 = localObject2;
      if (bu.isNullOrNil((String)localObject2)) {
        localObject1 = bu.bI(getIntent().getStringExtra("ShareUrlOpen"), "");
      }
      localObject2 = localObject1;
      if (bu.isNullOrNil((String)localObject1)) {
        localObject2 = bu.bI(getIntent().getStringExtra("ShareUrlOriginal"), "");
      }
      if (!bu.isNullOrNil((String)localObject2)) {
        this.zCT = com.tencent.mm.plugin.sns.data.r.azD((String)localObject2);
      }
      if (!getIntent().getBooleanExtra("ksnsis_appbrand", false)) {
        break;
      }
      this.zCT = null;
      break;
      this.zCT = bu.bI(getIntent().getStringExtra("Ksnsupload_musicid"), "");
      break;
      if ((this.Ann == null) || (paramBundle == null)) {
        break label345;
      }
      localObject1 = paramBundle.getString("contentdesc");
      if (localObject1 == null) {
        break label345;
      }
      this.Ann.setText((CharSequence)localObject1);
      break label345;
      label1709:
      bool = false;
      break label633;
      label1715:
      bool = false;
      break label752;
      label1721:
      bool = false;
      break label769;
      this.AFZ = ((RangeWidget)findViewById(2131303713));
      findViewById(2131303714).setVisibility(8);
      break label1124;
      this.AFZ = ((RangeWidget)findViewById(2131303713));
      findViewById(2131303714).setVisibility(8);
      break label1124;
      this.AFZ = ((RangeWidget)findViewById(2131303713));
      findViewById(2131303714).setVisibility(8);
      this.AFX.setVisibility(8);
      break label1124;
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
    if (this.Agc != null)
    {
      localObject = this.Agc;
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.b(2842, (com.tencent.mm.ak.f)localObject);
    }
    if (this.Ano != null) {
      this.Ano.edo();
    }
    if (this.AFY != null) {
      this.AFY.stop();
    }
    if (this.AGa != null)
    {
      localObject = this.AGa;
      if (((SnsUploadSayFooter)localObject).qdo != null)
      {
        ((SnsUploadSayFooter)localObject).qdo.ffs();
        ((SnsUploadSayFooter)localObject).qdo.destroy();
      }
    }
    this.AGf.clear();
    com.tencent.mm.plugin.normsg.a.b.wJt.auE("ie_sns_upload");
    com.tencent.mm.plugin.sns.data.r.dWq();
    com.tencent.mm.sdk.b.a.IvT.d(this.AGq);
    AppMethodBeat.o(99604);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99597);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      paramKeyEvent = this.AGa;
      if ((paramKeyEvent.ehg()) || (paramKeyEvent.getVisibility() == 0)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        this.AGa.ehh();
        AppMethodBeat.o(99597);
        return true;
      }
      cMH();
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
      ae.i("MicroMsg.SnsUploadUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(99610);
      return;
    }
    ae.i("MicroMsg.SnsUploadUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(99610);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        this.AFY.edx();
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
    this.AGa.post(new SnsUploadUI.8(this));
    if ((this.Ano != null) && ((this.Ano instanceof ai)))
    {
      ai localai = (ai)this.Ano;
      if (localai.Akb != null)
      {
        if (!localai.Aki)
        {
          localai.edH();
          AppMethodBeat.o(99603);
          return;
        }
        localai.edI();
      }
    }
    AppMethodBeat.o(99603);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(99594);
    if (paramBundle != null)
    {
      if (this.Ann != null) {
        paramBundle.putString("contentdesc", this.Ann.getText().toString());
      }
      this.Ano.ar(paramBundle);
    }
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(99594);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(176385);
    super.onStart();
    com.tencent.mm.plugin.sns.model.ah.dJc().postDelayed(this.AGl, this.AGk);
    AppMethodBeat.o(176385);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(176387);
    super.onStop();
    com.tencent.mm.plugin.sns.model.ah.dJc().removeCallbacks(this.AGl);
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