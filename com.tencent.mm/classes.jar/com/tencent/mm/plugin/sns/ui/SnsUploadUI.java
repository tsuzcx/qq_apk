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
import com.tencent.mm.al.n;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.g.a.jz;
import com.tencent.mm.g.a.jz.a;
import com.tencent.mm.g.a.vi;
import com.tencent.mm.g.b.a.gl;
import com.tencent.mm.g.b.a.go;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.al.a;
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

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(17)
public class SnsUploadUI
  extends MMActivity
  implements LocationWidget.a
{
  private AtContactWidget AoK;
  private LocationWidget AoL;
  private RangeWidget AoM;
  private SnsUploadSayFooter AoN;
  private DynamicGridView AoO;
  private boolean AoP;
  private boolean AoQ;
  boolean AoR;
  private Map<Integer, ac> AoS;
  private Map<String, List<String>> AoT;
  private Map<String, List<String>> AoU;
  private boolean AoV;
  private String AoW;
  private long AoX;
  private Runnable AoY;
  private FrameLayout AoZ;
  private long Apa;
  private long Apb;
  private int Apc;
  private com.tencent.mm.sdk.b.c<jz> Apd;
  private String desc;
  private int jmr;
  private boolean rzM;
  private KeyboardLinearLayout tAe;
  private SnsUploadConfigView zOV;
  private int zRL;
  private String zSZ;
  private boolean zTa;
  private String zTv;
  private int zTw;
  private int zTx;
  private String zVF;
  private String zVG;
  private String zVH;
  private SnsEditText zWf;
  private ac zWg;
  private LinearLayout zWh;
  private ArrayList<String> zWj;
  private boolean zWk;
  private boolean zWl;
  private long zWm;
  private String zlE;
  
  public SnsUploadUI()
  {
    AppMethodBeat.i(99593);
    this.zTa = false;
    this.zRL = 0;
    this.zWl = false;
    this.zWm = 0L;
    this.zWg = null;
    this.zVF = "";
    this.zVG = "";
    this.zVH = "";
    this.zTw = 0;
    this.zTx = 0;
    this.zWk = false;
    this.AoP = false;
    this.AoQ = false;
    this.AoR = false;
    this.zTv = null;
    this.zSZ = "";
    this.rzM = false;
    this.AoS = new HashMap();
    this.AoT = new HashMap();
    this.AoU = new HashMap();
    this.AoV = false;
    this.zlE = "";
    this.AoW = "";
    this.AoX = 3000L;
    this.AoY = new Runnable()
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
          String str = com.tencent.mm.sdk.platformtools.ai.B((byte[])localObject);
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsUploadUI", "autoSaveDraft lastMd5:%s, newMd5:%s", new Object[] { SnsUploadUI.c(SnsUploadUI.this), str });
          if (!bt.lQ(SnsUploadUI.c(SnsUploadUI.this), str))
          {
            SnsUploadUI.a(SnsUploadUI.this, str);
            SnsUploadUI.a(SnsUploadUI.this, (byte[])localObject, 1);
          }
          ag.dFL().postDelayed(SnsUploadUI.d(SnsUploadUI.this), SnsUploadUI.e(SnsUploadUI.this));
        }
        AppMethodBeat.o(176362);
      }
    };
    this.AoZ = null;
    this.Apa = 0L;
    this.Apb = 0L;
    this.jmr = 0;
    this.Apc = 0;
    this.Apd = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(jz paramAnonymousjz)
      {
        AppMethodBeat.i(176377);
        if ((paramAnonymousjz != null) && (bt.lQ(paramAnonymousjz.dwV.dwW, SnsUploadUI.this.hashCode()))) {
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJl, paramAnonymousjz.dwV.dwX);
        }
        AppMethodBeat.o(176377);
        return false;
      }
    };
    AppMethodBeat.o(99593);
  }
  
  private ac Rv(int paramInt)
  {
    AppMethodBeat.i(99614);
    Object localObject1 = (ac)this.AoS.get(Integer.valueOf(paramInt));
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
      this.AoS.put(Integer.valueOf(paramInt), localObject1);
      localObject2 = localObject1;
      AppMethodBeat.o(99614);
      return localObject2;
      label67:
      if (paramInt == 14) {
        localObject1 = new ai(this);
      }
    }
  }
  
  private void Rw(int paramInt)
  {
    AppMethodBeat.i(176389);
    com.tencent.mm.plugin.sns.j.e.ztz.ztH.pg(this.zSZ);
    com.tencent.mm.plugin.sns.j.e.ztz.ztH.eom = paramInt;
    if ((paramInt == 3) || (paramInt == 2)) {
      com.tencent.mm.plugin.sns.j.e.ztz.dVH();
    }
    AppMethodBeat.o(176389);
  }
  
  private void V(final byte[] paramArrayOfByte, final int paramInt)
  {
    AppMethodBeat.i(198475);
    ag.dFL().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176380);
        long l = System.currentTimeMillis();
        ag.dUl().b(SnsUploadUI.h(SnsUploadUI.this), paramArrayOfByte, paramInt);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsUploadUI", "saveDraft draftKey:%s, %s", new Object[] { SnsUploadUI.h(SnsUploadUI.this), Long.valueOf(bt.Df(l)) });
        AppMethodBeat.o(176380);
      }
    });
    AppMethodBeat.o(198475);
  }
  
  private void Zd()
  {
    AppMethodBeat.i(99601);
    this.zWl = getIntent().getBooleanExtra("KSnsPostManu", false);
    this.zWm = getIntent().getLongExtra("KTouchCameraTime", 0L);
    this.zRL = getIntent().getIntExtra("Ksnsupload_type", 0);
    this.zTa = getIntent().getBooleanExtra("Kis_take_photo", false);
    if (this.zTa) {}
    for (int i = 2;; i = 1)
    {
      this.Apc = i;
      this.AoP = getIntent().getBooleanExtra("need_result", false);
      this.AoQ = getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false);
      this.zTv = getIntent().getStringExtra("Ksnsupload_canvas_info");
      this.zSZ = getIntent().getStringExtra("KSessionID");
      this.rzM = getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
      if (!bt.isNullOrNil(this.zSZ)) {
        break;
      }
      this.zSZ = com.tencent.mm.plugin.sns.data.q.dSP();
      getIntent().putExtra("KSessionID", this.zSZ);
      AppMethodBeat.o(99601);
      return;
    }
    this.Apc = 3;
    AppMethodBeat.o(99601);
  }
  
  private void aQ(Intent paramIntent)
  {
    List localList2 = null;
    AppMethodBeat.i(99606);
    this.AoM.a(5, -1, paramIntent, this.AoK);
    int i = paramIntent.getIntExtra("Ktag_range_index", 0);
    if (i >= 2)
    {
      this.zVF = paramIntent.getStringExtra("Klabel_name_list");
      this.zVG = paramIntent.getStringExtra("Kother_user_name_list");
      this.zVH = paramIntent.getStringExtra("Kchat_room_name_list");
      if (bt.isNullOrNil(this.zVF)) {
        break label275;
      }
    }
    label275:
    for (paramIntent = Arrays.asList(this.zVF.split(","));; paramIntent = null)
    {
      List localList1;
      if (!bt.isNullOrNil(this.zVG))
      {
        localList1 = Arrays.asList(this.zVG.split(","));
        com.tencent.mm.plugin.sns.j.e.ztz.fN(localList1);
      }
      for (;;)
      {
        if (!bt.isNullOrNil(this.zVH)) {
          localList2 = Arrays.asList(this.zVH.split(","));
        }
        p(paramIntent, localList1);
        fc(localList2);
        if (i == 2)
        {
          this.zWk = false;
          if ((this.AoT != null) && (!this.AoT.isEmpty())) {
            com.tencent.mm.plugin.sns.j.e.ztz.aK(this.AoT);
          }
          if ((this.AoU != null) && (!this.AoU.isEmpty())) {
            com.tencent.mm.plugin.sns.j.e.ztz.aJ(this.AoU);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.j.e.ztz.Ql(i);
          AppMethodBeat.o(99606);
          return;
          this.zWk = true;
          break;
          if (!bt.hj(this.zWj)) {
            this.zWj.clear();
          }
        }
        localList1 = null;
      }
    }
  }
  
  private void as(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(99615);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsUploadUI", "attachWidget. share type %d, isManuSnsPost:%b", new Object[] { Integer.valueOf(this.zRL), Boolean.valueOf(this.zWl) });
    Object localObject;
    if ((this.zRL == 0) || (this.zRL == 14) || (this.zRL == 9))
    {
      localObject = Parcel.obtain();
      getIntent().writeToParcel((Parcel)localObject, 0);
      ((Parcel)localObject).marshall();
      if (this.zRL != 9) {
        break label466;
      }
      setMMTitle(getContext().getResources().getString(2131764021));
    }
    RelativeLayout.LayoutParams localLayoutParams;
    label466:
    int i;
    switch (this.zRL)
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
        this.zWg.ap(paramBundle);
        if (!(this.zWg instanceof an)) {
          break label859;
        }
        paramBundle = findViewById(2131304970);
        localObject = findViewById(2131304985);
        this.AoO = ((DynamicGridView)findViewById(2131305045));
        this.AoO.setOnTouchListener(new SnsUploadUI.14(this));
        paramBundle = ((an)this.zWg).a(paramBundle, findViewById(2131298953), this.AoO, (View)localObject);
        this.AoO.setVisibility(0);
        localObject = findViewById(2131306994);
        localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        localLayoutParams.topMargin = 0;
        localLayoutParams.addRule(3, 2131305045);
        ((View)localObject).setLayoutParams(localLayoutParams);
        if (((this.zWg instanceof ad)) || ((this.zWg instanceof af)))
        {
          localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).width = -1;
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if (((this.zWg instanceof q)) || ((this.zWg instanceof o)) || ((this.zWg instanceof p)))
        {
          localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).width = -1;
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        edE();
        if (this.zRL == 0) {
          edB();
        }
        AppMethodBeat.o(99615);
        return;
        setMMTitle("");
        break;
        this.zlE = "draft_normal";
        this.zWg = Rv(this.zRL);
        this.zWf.addTextChangedListener(new TextWatcher()
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
        this.zlE = "draft_normal";
        this.zWg = Rv(this.zRL);
        continue;
        this.zWg = new ad(this);
        continue;
        this.zWg = new ah(this);
        continue;
        this.zWg = new ao(this, 9);
        continue;
        this.zWg = new ao(this, 12);
        continue;
        this.zWg = new q(this);
        continue;
        this.zWg = new o(this);
        continue;
        this.zWg = new r(this);
        continue;
        this.zWg = new p(this);
        continue;
        this.zWg = new ao(this, 14);
        continue;
        this.zWg = new ao(this, 13);
      }
    case 9: 
      this.zlE = "draft_text";
      localObject = bt.bI(getIntent().getStringExtra("Kdescription"), "");
      i = bt.a(Integer.valueOf(getIntent().getIntExtra("KparseLen", 0)), 0);
      if ((localObject == null) || (bt.isNullOrNil(((String)localObject).trim()))) {
        break;
      }
    }
    for (;;)
    {
      this.zWg = new aj(this, bool);
      this.zWf.setPasterLen(i);
      this.zWf.setText(com.tencent.mm.ui.f.c.b.c(getContext(), (CharSequence)localObject, this.zWf.getTextSize()));
      this.zWf.addTextChangedListener(new TextWatcher()
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
      this.zWg = new bm(this);
      break;
      this.zWg = new af(this);
      break;
      this.zWg = new t(this);
      break;
      label859:
      paramBundle = this.zWg.dZH();
      this.zWh = ((LinearLayout)findViewById(2131306993));
      this.zWh.setVisibility(0);
      this.zWh.setClipChildren(false);
      label920:
      float f;
      if (paramBundle != null)
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsUploadUI", "will add widget view in widgetLL.");
        this.zWh.addView(paramBundle);
        if ((this.zRL == 9) || (this.zRL == 14))
        {
          localObject = findViewById(2131306994);
          localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
          localLayoutParams.addRule(3, 2131306993);
          f = com.tencent.mm.sdk.platformtools.g.aQF().density;
          if (this.zRL != 9) {
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
        this.zWh.setVisibility(8);
        break label920;
      }
      bool = false;
    }
  }
  
  private void cKe()
  {
    AppMethodBeat.i(99598);
    if (((this.zRL == 0) && (((an)this.zWg).eaJ() > 0)) || ((this.zRL == 14) && ((this.zWg instanceof ai)) && (!((ai)this.zWg).zTb)) || ((this.zRL == 9) && (!bt.isNullOrNil(this.zWf.getText().toString()))))
    {
      com.tencent.mm.ui.base.h.a(this, 2131764054, 0, 2131764056, 2131764055, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(99587);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsUploadUI", "exitAndSave shareType:%s realtimeType:%s", new Object[] { Integer.valueOf(SnsUploadUI.i(SnsUploadUI.this)), Integer.valueOf(SnsUploadUI.this.getIntent().getIntExtra("Ksnsupload_type", -1)) });
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
            com.tencent.mm.plugin.report.service.g.yhR.f(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(paramAnonymousInt), SnsUploadUI.k(SnsUploadUI.this), Long.valueOf(bt.aQJ()), Integer.valueOf(1) });
            SnsUploadUI.b(SnsUploadUI.this, 3);
            SnsUploadUI.l(SnsUploadUI.this);
            if (SnsUploadUI.m(SnsUploadUI.this))
            {
              com.tencent.mm.plugin.sns.j.e.ztz.zuh.eoR = 2L;
              com.tencent.mm.plugin.sns.j.e.ztz.dVP();
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
          ag.dFL().removeCallbacks(SnsUploadUI.d(SnsUploadUI.this));
          SnsUploadUI.a(SnsUploadUI.this, null, 0);
          SnsUploadUI.j(SnsUploadUI.this);
          paramAnonymousDialogInterface = SnsUploadUI.this.getIntent().getStringExtra("KSightThumbPath");
          Object localObject = SnsUploadUI.this.getIntent().getStringExtra("KSightPath");
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyR, true))
          {
            com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.xRl;
            com.tencent.mm.plugin.recordvideo.e.b.avT((String)localObject);
            localObject = com.tencent.mm.plugin.recordvideo.e.b.xRl;
            com.tencent.mm.plugin.recordvideo.e.b.avT(paramAnonymousDialogInterface);
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
            com.tencent.mm.plugin.report.service.g.yhR.f(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(paramAnonymousInt), SnsUploadUI.k(SnsUploadUI.this), Long.valueOf(bt.aQJ()), Integer.valueOf(0) });
            SnsUploadUI.b(SnsUploadUI.this, 2);
            SnsUploadUI.l(SnsUploadUI.this);
            if (SnsUploadUI.m(SnsUploadUI.this))
            {
              com.tencent.mm.plugin.sns.j.e.ztz.zuh.eoR = 3L;
              com.tencent.mm.plugin.sns.j.e.ztz.dVP();
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
    if (((this.zWg instanceof ad)) || ((this.zWg instanceof ah)))
    {
      if (!bt.isNullOrNil(this.zWf.getText().toString()))
      {
        ag.dFL().removeCallbacks(this.AoY);
        Parcel localParcel = Parcel.obtain();
        getIntent().putExtra("Kdescription", this.zWf.getText().toString());
        getIntent().putExtra("KparseLen", this.zWf.getPasterLen());
        edC();
        getIntent().writeToParcel(localParcel, 0);
        V(localParcel.marshall(), 0);
        com.tencent.mm.plugin.report.service.g.yhR.f(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(7), this.zSZ, Long.valueOf(bt.aQJ()), Integer.valueOf(3) });
      }
      edG();
      Rw(2);
      if (this.AoV)
      {
        com.tencent.mm.plugin.sns.j.e.ztz.zuh.eoR = 2L;
        com.tencent.mm.plugin.sns.j.e.ztz.dVP();
      }
      edH();
      edD();
      AppMethodBeat.o(99598);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, 2131764053, 0, 2131755277, 2131755691, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(176381);
        ag.dFL().removeCallbacks(SnsUploadUI.d(SnsUploadUI.this));
        SnsUploadUI.a(SnsUploadUI.this, null, 0);
        SnsUploadUI.j(SnsUploadUI.this);
        SnsUploadUI.b(SnsUploadUI.this, 2);
        SnsUploadUI.l(SnsUploadUI.this);
        if (SnsUploadUI.m(SnsUploadUI.this))
        {
          com.tencent.mm.plugin.sns.j.e.ztz.zuh.eoR = 3L;
          com.tencent.mm.plugin.sns.j.e.ztz.dVP();
        }
        SnsUploadUI.o(SnsUploadUI.this);
        AppMethodBeat.o(176381);
      }
    }, null, 2131099904);
    AppMethodBeat.o(99598);
  }
  
  @TargetApi(11)
  private void edB()
  {
    AppMethodBeat.i(99596);
    if (!(this.zWg instanceof an))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsUploadUI", "!(widget instanceof PicWidget)");
      AppMethodBeat.o(99596);
      return;
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsUploadUI", "sdk not support dragdrop event");
      AppMethodBeat.o(99596);
      return;
    }
    new SnsUploadUI.12(this).run();
    AppMethodBeat.o(99596);
  }
  
  private void edC()
  {
    AppMethodBeat.i(198474);
    getIntent().putExtra("Kis_retry_edit", false);
    AppMethodBeat.o(198474);
  }
  
  private void edD()
  {
    AppMethodBeat.i(99599);
    if (this.rzM)
    {
      com.tencent.mm.plugin.sns.j.e locale = com.tencent.mm.plugin.sns.j.e.ztz;
      com.tencent.mm.plugin.sns.j.e.a(10, "", 0, 0, cf.aCL());
    }
    setResult(0, new Intent());
    finish();
    com.tencent.mm.plugin.sns.data.q.dSQ();
    AppMethodBeat.o(99599);
  }
  
  private void edG()
  {
    AppMethodBeat.i(176388);
    if (this.zRL == 9)
    {
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Isz, this.zSZ);
      AppMethodBeat.o(176388);
      return;
    }
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Isy, this.zSZ);
    AppMethodBeat.o(176388);
  }
  
  private void edH()
  {
    AppMethodBeat.i(176390);
    com.tencent.mm.plugin.expt.b.c localc = (com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.c.class);
    localc.fN("startTime", this.Apb);
    localc.fN("endTime", bt.flT());
    localc.fN("bussinessId", this.zSZ);
    localc.fN("shareType", this.zRL);
    localc.fN("hadLocation", this.AoL.getShowFlag());
    localc.fN("desc", this.zWf.getText().toString());
    localc.fN("nextStep", this.jmr);
    localc.fN("beforeStep", this.Apc);
    localc.fN("ContactTagCount", this.zTw);
    localc.fN("mIsBlackGroup", this.zWk);
    if (this.zWj != null)
    {
      localObject1 = this.zWj.size();
      localc.fN("mContactNameList", (String)localObject1);
      if (!(this.zWg instanceof an)) {
        break label423;
      }
      Object localObject2 = ((an)this.zWg).eaL();
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
    localc.fN("picSource", ((StringBuilder)localObject1).toString());
    label423:
    if ((this.zWg instanceof ai)) {
      if (!((ai)this.zWg).ead()) {
        break label467;
      }
    }
    label467:
    for (Object localObject1 = "1";; localObject1 = "2")
    {
      localc.fN("sightSource", (String)localObject1);
      AppMethodBeat.o(176390);
      return;
    }
  }
  
  private void fc(List<String> paramList)
  {
    AppMethodBeat.i(99607);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(99607);
      return;
    }
    this.AoU.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str1 = (String)paramList.next();
      ArrayList localArrayList = new ArrayList();
      Object localObject = com.tencent.mm.model.q.yR(str1);
      if (localObject != null)
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsUploadUI", "getContactNamesFromChatroom chatromm:%s membersCount:%s", new Object[] { str1, Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          if ((!this.zWj.contains(str2)) && (w.zD(str2)))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsUploadUI", "getContactNamesFromChatroom memberName:%s", new Object[] { str2 });
            this.zWj.add(str2);
            this.zTx += 1;
          }
          if (w.zD(str2)) {
            localArrayList.add(str2);
          }
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsUploadUI", "%s , %s", new Object[] { str1, Integer.valueOf(localArrayList.size()) });
        this.AoU.put(str1, localArrayList);
      }
    }
    AppMethodBeat.o(99607);
  }
  
  private void p(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(99608);
    this.zWj = new ArrayList();
    this.zTw = 0;
    this.AoT.clear();
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
        localList = com.tencent.mm.plugin.label.a.a.dfo().aop(com.tencent.mm.plugin.label.a.a.dfo().aom(str1));
        if ((localList == null) || (localList.size() == 0)) {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsUploadUI", "dz: getContactNamesFromLabelsAndOtherUserName,namelist get bu label is null");
        }
      }
      else
      {
        this.zWj = new ArrayList(localHashSet);
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
        this.zTw += 1;
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsUploadUI", "dz:name : %s", new Object[] { str2 });
      }
      this.AoT.put(str1, localList);
      break;
      this.zTw = i;
      this.zTx = 0;
      if ((paramList2 != null) && (paramList2.size() > 0))
      {
        paramList1 = paramList2.iterator();
        while (paramList1.hasNext())
        {
          paramList2 = (String)paramList1.next();
          if (!this.zWj.contains(paramList2))
          {
            this.zWj.add(paramList2);
            this.zTx += 1;
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsUploadUI", "updateSightConfig");
    getIntent().getExtras().clear();
    getIntent().putExtra("KSightPath", paramString1);
    getIntent().putExtra("KSightThumbPath", paramString2);
    getIntent().putExtra("sight_md5", paramString3);
    getIntent().putExtra("KSnsPostManu", true);
    getIntent().putExtra("Ksnsupload_type", 14);
    getIntent().putExtra("Kis_take_photo", false);
    getIntent().putExtra("KMMSightExtInfo", paramArrayOfByte);
    if (paramBoolean) {
      getIntent().putExtra("KSessionID", bt.flT() + "_" + bt.aaz(5));
    }
    AppMethodBeat.o(99612);
  }
  
  public final void a(String paramString, boolean paramBoolean, int paramInt1, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int paramInt2)
  {
    AppMethodBeat.i(99611);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsUploadUI", "updatePicConfig");
    getIntent().getExtras().clear();
    getIntent().putExtra("KTouchCameraTime", bt.aQJ());
    getIntent().putExtra("KSnsPostManu", true);
    getIntent().putExtra("Ksnsupload_type", 0);
    getIntent().putExtra("KFilterId", paramInt1);
    if (!bt.isNullOrNil(paramString)) {
      getIntent().putExtra("sns_kemdia_path", paramString);
    }
    if (!bt.hj(paramArrayList1)) {
      getIntent().putExtra("sns_kemdia_path_list", paramArrayList1);
    }
    if (!bt.hj(paramArrayList2)) {
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
  
  public final ArrayList<Exif.a> dZU()
  {
    AppMethodBeat.i(99609);
    if ((this.zWg instanceof an))
    {
      an localan = (an)this.zWg;
      Object localObject1 = localan.zUL.zUW;
      ArrayList localArrayList = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (Exif.a)localan.zUN.get(localObject2);
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
  
  public final boolean dZV()
  {
    return this.zTa;
  }
  
  public final void edE()
  {
    AppMethodBeat.i(99600);
    if (this.zWg.dZG())
    {
      enableOptionMenu(true);
      AppMethodBeat.o(99600);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(99600);
  }
  
  public final void edF()
  {
    AppMethodBeat.i(99613);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsUploadUI", "resetWidget");
    if (this.AoO != null) {
      this.AoO.setVisibility(8);
    }
    if (this.zWh != null)
    {
      this.zWh.removeAllViews();
      this.zWh.setVisibility(8);
    }
    if (this.zWg != null) {
      this.zWg.dZI();
    }
    Zd();
    as(null);
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
    if (this.zWf != null) {
      this.zWf.clearFocus();
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
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IEr, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(getContext(), "android.permission.ACCESS_COARSE_LOCATION", 64);
      }
      AppMethodBeat.o(99605);
      return;
    }
    if (this.zWg.k(paramInt1, paramIntent)) {
      edE();
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
      aQ(paramIntent);
      AppMethodBeat.o(99605);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      getIntent().putExtras(paramIntent.getExtras());
      this.AoK.aN(paramIntent);
      AppMethodBeat.o(99605);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      boolean bool = paramIntent.getBooleanExtra("bind_facebook_succ", false);
      paramIntent = this.zOV;
      if (bool)
      {
        paramIntent.Aov = true;
        paramIntent.setSyncFacebook(true);
      }
      AppMethodBeat.o(99605);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      String str1 = bt.bI(paramIntent.getStringExtra("get_poi_name"), "");
      String str2 = bt.bI(paramIntent.getStringExtra("get_city"), "");
      if (bt.isNullOrNil(str1)) {
        getIntent().removeExtra("get_poi_name");
      }
      if (bt.isNullOrNil(str2)) {
        getIntent().removeExtra("get_city");
      }
      getIntent().putExtras(paramIntent.getExtras());
      this.AoL.aN(paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99595);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsUploadUI", "onCreate");
    com.tencent.mm.pluginsdk.h.q(this);
    super.onCreate(paramBundle);
    setActionbarColor(getContext().getResources().getColor(2131099650));
    hideActionbarLine();
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    ag.dUl().db.delete("snsDraft", "key!=? AND key!=? AND timestamp<?", new String[] { "draft_text", "draft_normal", String.valueOf(System.currentTimeMillis() - 86400000L) });
    this.AoV = getIntent().getBooleanExtra("Kis_retry_edit", false);
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
      if ((!bt.isNullOrNil(this.zlE)) && (!this.AoV))
      {
        localObject1 = ag.dUl().aAb(this.zlE);
        if (localObject1 != null)
        {
          localObject1 = ((l)localObject1).field_draft;
          if (!bt.cC((byte[])localObject1))
          {
            localObject2 = Parcel.obtain();
            ((Parcel)localObject2).unmarshall((byte[])localObject1, 0, localObject1.length);
            ((Parcel)localObject2).setDataPosition(0);
            setIntent((Intent)Intent.CREATOR.createFromParcel((Parcel)localObject2));
          }
        }
      }
      Zd();
      this.zWf = ((SnsEditText)findViewById(2131304971));
      if (!bt.isNullOrNil(getIntent().getStringExtra("Kdescription")))
      {
        this.zWf.setText(com.tencent.mm.ui.f.c.b.c(getContext(), getIntent().getStringExtra("Kdescription"), this.zWf.getTextSize()));
        if (this.zRL == 8)
        {
          localObject1 = getIntent().getStringExtra("Kdescription");
          this.zWf.setText(com.tencent.mm.ui.f.c.b.c(getContext(), (CharSequence)localObject1, this.zWf.getTextSize()));
        }
        this.zWf.setPasterLen(getIntent().getIntExtra("KparseLen", 0));
        this.tAe = ((KeyboardLinearLayout)findViewById(2131304239));
        this.AoN = ((SnsUploadSayFooter)findViewById(2131304290));
        this.AoN.setMMEditText(this.zWf);
        this.AoN.setVisibility(4);
        this.AoZ = ((FrameLayout)findViewById(2131304243));
        this.AoZ.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(176382);
            DisplayMetrics localDisplayMetrics = new DisplayMetrics();
            SnsUploadUI.this.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
            ag.dTT();
            com.tencent.mm.plugin.sns.storage.u.hL(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
            AppMethodBeat.o(176382);
          }
        });
        this.zWf.setOnClickListener(new SnsUploadUI.21(this));
        this.zWf.setOnLongClickListener(new SnsUploadUI.22(this));
        localObject1 = new boolean[1];
        localObject1[0] = 0;
        this.zWf.addTextChangedListener(new SnsUploadUI.2(this, new boolean[] { true }));
        localObject2 = (WrapScollview)findViewById(2131304376);
        ((WrapScollview)localObject2).setContentView(this.zWf);
        ((WrapScollview)localObject2).setDoComputeScrollDeltaToGetChildRectOnScreen(false);
        Object localObject3 = bt.bI(getIntent().getStringExtra("reportSessionId"), "");
        this.zOV = ((SnsUploadConfigView)findViewById(2131298555));
        localObject2 = this.zOV;
        if ((this.zRL != 14) || (((String)localObject3).contains("wx5dfbe0a95623607b"))) {
          break label1709;
        }
        bool = true;
        ((SnsUploadConfigView)localObject2).AoB = bool;
        if (bool)
        {
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(2842, (com.tencent.mm.al.f)localObject2);
          localObject3 = new com.tencent.mm.plugin.sns.model.i();
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a((n)localObject3, 0);
        }
        ((SnsUploadConfigView)localObject2).zTr.FOB = -1000.0F;
        ((SnsUploadConfigView)localObject2).zTr.FOA = -1000.0F;
        if (!((SnsUploadConfigView)localObject2).sKd)
        {
          com.tencent.mm.kernel.g.ajD();
          i = bt.n((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(68404, null));
          if ((i & 0x2) == 0) {
            break label1715;
          }
          bool = true;
          ((SnsUploadConfigView)localObject2).Aov = bool;
          if ((i & 0x8) == 0) {
            break label1721;
          }
          bool = true;
          ((SnsUploadConfigView)localObject2).Aow = bool;
          if (!com.tencent.mm.ax.b.aJo()) {
            ((SnsUploadConfigView)localObject2).Aow = false;
          }
          if (!com.tencent.mm.model.u.aAP()) {
            ((SnsUploadConfigView)localObject2).Aov = false;
          }
        }
        ((SnsUploadConfigView)localObject2).setSyncFacebook(false);
        ((SnsUploadConfigView)localObject2).edv();
        ((SnsUploadConfigView)localObject2).edx();
        ((SnsUploadConfigView)localObject2).edw();
        if (((SnsUploadConfigView)localObject2).Aow) {
          ((SnsUploadConfigView)localObject2).AoC.a((a.a)localObject2);
        }
        if (this.zRL != 0)
        {
          localObject2 = this.zOV;
          ((SnsUploadConfigView)localObject2).Aoq.setVisibility(8);
          ((SnsUploadConfigView)localObject2).Aor.setVisibility(8);
          ((SnsUploadConfigView)localObject2).Aos.setVisibility(8);
          ((SnsUploadConfigView)localObject2).Aot.setVisibility(8);
        }
        if (this.zRL == 9) {
          this.zOV.Aos.setVisibility(0);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(99572);
            SnsUploadUI.q(SnsUploadUI.this);
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
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsUploadUI", "skip commit, is finishing");
              AppMethodBeat.o(176366);
              return false;
            }
            if (System.currentTimeMillis() - SnsUploadUI.r(SnsUploadUI.this) < 500L)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsUploadUI", "skip commit, click frequently");
              AppMethodBeat.o(176366);
              return false;
            }
            if (SnsUploadUI.s(SnsUploadUI.this))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsUploadUI", "skip commit, has commited");
              AppMethodBeat.o(176366);
              return false;
            }
            ag.dFL().removeCallbacks(SnsUploadUI.d(SnsUploadUI.this));
            paramAnonymousMenuItem = Parcel.obtain();
            SnsUploadUI.this.getIntent().putExtra("Kdescription", SnsUploadUI.a(SnsUploadUI.this).getText().toString());
            SnsUploadUI.this.getIntent().putExtra("KparseLen", SnsUploadUI.a(SnsUploadUI.this).getPasterLen());
            SnsUploadUI.b(SnsUploadUI.this);
            SnsUploadUI.this.getIntent().writeToParcel(paramAnonymousMenuItem, 0);
            paramAnonymousMenuItem = paramAnonymousMenuItem.marshall();
            SnsUploadUI.a(SnsUploadUI.this, paramAnonymousMenuItem, 2);
            SnsUploadUI.j(SnsUploadUI.this);
            if (this.jlX[0] != 0) {
              this.jlX[0] = false;
            }
            for (;;)
            {
              SnsUploadUI.a(SnsUploadUI.this, System.currentTimeMillis());
              com.tencent.mm.plugin.report.service.f.Oj(22);
              paramAnonymousMenuItem = com.tencent.mm.ui.tools.b.c.d(SnsUploadUI.a(SnsUploadUI.this)).aeU(com.tencent.mm.n.b.acb());
              paramAnonymousMenuItem.KMn = true;
              paramAnonymousMenuItem.a(new c.a()
              {
                public final void JZ(String paramAnonymous2String)
                {
                  AppMethodBeat.i(176364);
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsUploadUI", "commit after check");
                  SnsUploadUI.a(SnsUploadUI.this, 3);
                  SnsUploadUI.t(SnsUploadUI.this);
                  int i = SnsUploadUI.u(SnsUploadUI.this).getSyncFlag();
                  com.tencent.mm.kernel.g.ajD();
                  com.tencent.mm.kernel.g.ajC().ajl().set(68404, Integer.valueOf(i));
                  SnsUploadUI.b(SnsUploadUI.this, SnsUploadUI.a(SnsUploadUI.this).getText().toString());
                  i = SnsUploadUI.a(SnsUploadUI.this).getPasterLen();
                  int j = SnsUploadUI.u(SnsUploadUI.this).getPrivated();
                  int k = SnsUploadUI.u(SnsUploadUI.this).getSyncFlag();
                  SnsUploadUI.v(SnsUploadUI.this);
                  if (SnsUploadUI.w(SnsUploadUI.this)) {
                    SnsUploadUI.this.setResult(-1, new Intent());
                  }
                  if ((SnsUploadUI.f(SnsUploadUI.this) instanceof an)) {
                    ((an)SnsUploadUI.f(SnsUploadUI.this)).zUR = SnsUploadUI.x(SnsUploadUI.this).getCurLocation();
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
                      localObject = com.tencent.mm.plugin.report.service.g.yhR;
                      long l1 = SnsUploadUI.H(SnsUploadUI.this);
                      long l2 = bt.aQJ();
                      if (!SnsUploadUI.I(SnsUploadUI.this)) {
                        break label1111;
                      }
                      i = 0;
                      ((com.tencent.mm.plugin.report.service.g)localObject).f(13303, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymous2String.value), "" });
                      l1 = SnsUploadUI.H(SnsUploadUI.this);
                      l2 = bt.aQJ();
                      if (!SnsUploadUI.I(SnsUploadUI.this)) {
                        break label1116;
                      }
                      i = 0;
                      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsUploadUI", "reprot timelinePostAction(13303), %d, %d, %d, %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymous2String.value) });
                      com.tencent.mm.plugin.report.service.g.yhR.kvStat(10910, "1");
                      if (!bt.isNullOrNil(SnsUploadUI.J(SnsUploadUI.this)))
                      {
                        if (!SnsUploadUI.B(SnsUploadUI.this)) {
                          break label1121;
                        }
                        com.tencent.mm.plugin.report.service.g.yhR.f(11455, new Object[] { "", SnsUploadUI.J(SnsUploadUI.this), Integer.valueOf(-1), Integer.valueOf(-1) });
                      }
                      if (SnsUploadUI.K(SnsUploadUI.this))
                      {
                        localObject = new Intent(SnsUploadUI.this, SnsTimeLineUI.class);
                        ((Intent)localObject).putExtra("sns_resume_state", false);
                        ((Intent)localObject).putExtra("sns_timeline_NeedFirstLoadint", true);
                        ((Intent)localObject).addFlags(67108864);
                        paramAnonymous2String = SnsUploadUI.this;
                        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/sns/ui/SnsUploadUI$12$1", "doWhenOK", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymous2String.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$12$1", "doWhenOK", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      }
                      com.tencent.mm.pluginsdk.ui.tools.o.bd(SnsUploadUI.this.getIntent());
                      paramAnonymous2String = new vi();
                      com.tencent.mm.sdk.b.a.IbL.l(paramAnonymous2String);
                      SnsUploadUI.b(SnsUploadUI.this, 1);
                      SnsUploadUI.l(SnsUploadUI.this);
                      if (!SnsUploadUI.m(SnsUploadUI.this)) {
                        break label1169;
                      }
                      com.tencent.mm.plugin.sns.j.e.ztz.zuh.eoR = 1L;
                      com.tencent.mm.plugin.sns.data.q.dSQ();
                      AppMethodBeat.o(176364);
                      return;
                    }
                    catch (IOException localIOException)
                    {
                      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SnsUploadUI", localIOException, "parse location error", new Object[0]);
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
                    com.tencent.mm.plugin.report.service.g.yhR.f(11455, new Object[] { SnsUploadUI.J(SnsUploadUI.this), "", Integer.valueOf(-1), Integer.valueOf(-1) });
                    continue;
                    label1169:
                    com.tencent.mm.plugin.sns.j.e.ztz.zuh.pi(SnsUploadUI.k(SnsUploadUI.this));
                    com.tencent.mm.plugin.sns.j.e.ztz.zug.pi(SnsUploadUI.k(SnsUploadUI.this));
                  }
                }
                
                public final void aUu() {}
                
                public final void cU(String paramAnonymous2String)
                {
                  AppMethodBeat.i(176365);
                  com.tencent.mm.ui.base.h.l(SnsUploadUI.this, 2131764058, 2131764059);
                  AppMethodBeat.o(176365);
                }
              });
              AppMethodBeat.o(176366);
              return false;
              com.tencent.mm.plugin.normsg.a.b.wtJ.io("ce_sns_upload", "<SnsUpload>");
              paramAnonymousMenuItem = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.b.wtJ.a("ce_sns_upload", paramAnonymousMenuItem);
              com.tencent.mm.plugin.normsg.a.b.wtJ.atu("ce_sns_upload");
            }
          }
        }, null, new SnsUploadUI.5(this, (boolean[])localObject1), s.b.JbS);
        findViewById(2131306218).setOnTouchListener(new SnsUploadUI.6(this));
        this.AoK = ((AtContactWidget)findViewById(2131296956));
        this.AoK.zOV = this.zOV;
        this.AoL = ((LocationWidget)findViewById(2131301546));
        this.AoL.setLocationWidgetListener(this);
        switch (this.zRL)
        {
        default: 
          this.AoM.zOV = this.zOV;
          this.AoM.setRangeTipClickListener(new SnsUploadUI.7(this));
          this.AoL.aN(getIntent());
          this.AoK.aN(getIntent());
          com.tencent.mm.plugin.sns.j.e.ztz.Ql(0);
          com.tencent.mm.plugin.sns.j.e.ztz.ztH.enV = 2;
          aQ(getIntent());
          hideVKB();
          as(paramBundle);
          paramBundle = ag.dUl().aAb(this.zlE);
          if ((paramBundle != null) && ((paramBundle.field_extFlag & 0x1) == 1))
          {
            m = 0;
            k = 2;
            i = m;
            j = k;
            switch (this.zRL)
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
      com.tencent.mm.plugin.report.service.g.yhR.f(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(i), this.zSZ, Long.valueOf(bt.aQJ()), Integer.valueOf(j) });
      com.tencent.mm.pluginsdk.h.r(this);
      paramBundle = Parcel.obtain();
      getIntent().writeToParcel(paramBundle, 0);
      this.AoW = com.tencent.mm.sdk.platformtools.ai.B(paramBundle.marshall());
      this.AoX = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBl, 3000L);
      this.Apb = bt.flT();
      this.AoR = false;
      AppMethodBeat.o(99595);
      return;
      localObject1 = bw.M(bt.bI(getIntent().getStringExtra("fav_note_xml"), ""), "favlocalid");
      if ((localObject1 == null) || (((Map)localObject1).size() == 0)) {
        break;
      }
      localObject1 = (String)((Map)localObject1).get(".favlocalid");
      if (bt.lQ((String)localObject1, "0")) {
        break;
      }
      this.zlE = ((String)localObject1);
      break;
      localObject2 = bt.bI(getIntent().getStringExtra("Ksnsupload_link"), "");
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = bt.bI(getIntent().getStringExtra("ShareUrlOpen"), "");
      }
      localObject2 = localObject1;
      if (bt.isNullOrNil((String)localObject1)) {
        localObject2 = bt.bI(getIntent().getStringExtra("ShareUrlOriginal"), "");
      }
      if (!bt.isNullOrNil((String)localObject2)) {
        this.zlE = com.tencent.mm.plugin.sns.data.q.aym((String)localObject2);
      }
      if (!getIntent().getBooleanExtra("ksnsis_appbrand", false)) {
        break;
      }
      this.zlE = null;
      break;
      this.zlE = bt.bI(getIntent().getStringExtra("Ksnsupload_musicid"), "");
      break;
      if ((this.zWf == null) || (paramBundle == null)) {
        break label345;
      }
      localObject1 = paramBundle.getString("contentdesc");
      if (localObject1 == null) {
        break label345;
      }
      this.zWf.setText((CharSequence)localObject1);
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
      this.AoM = ((RangeWidget)findViewById(2131303713));
      findViewById(2131303714).setVisibility(8);
      break label1124;
      this.AoM = ((RangeWidget)findViewById(2131303713));
      findViewById(2131303714).setVisibility(8);
      break label1124;
      this.AoM = ((RangeWidget)findViewById(2131303713));
      findViewById(2131303714).setVisibility(8);
      this.AoK.setVisibility(8);
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
    if (this.zOV != null)
    {
      localObject = this.zOV;
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.b(2842, (com.tencent.mm.al.f)localObject);
    }
    if (this.zWg != null) {
      this.zWg.dZI();
    }
    if (this.AoL != null) {
      this.AoL.stop();
    }
    if (this.AoN != null)
    {
      localObject = this.AoN;
      if (((SnsUploadSayFooter)localObject).pWJ != null)
      {
        ((SnsUploadSayFooter)localObject).pWJ.fbE();
        ((SnsUploadSayFooter)localObject).pWJ.destroy();
      }
    }
    this.AoS.clear();
    com.tencent.mm.plugin.normsg.a.b.wtJ.atr("ie_sns_upload");
    com.tencent.mm.plugin.sns.data.q.dSQ();
    com.tencent.mm.sdk.b.a.IbL.d(this.Apd);
    AppMethodBeat.o(99604);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99597);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      paramKeyEvent = this.AoN;
      if ((paramKeyEvent.edz()) || (paramKeyEvent.getVisibility() == 0)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        this.AoN.edA();
        AppMethodBeat.o(99597);
        return true;
      }
      cKe();
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsUploadUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(99610);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsUploadUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(99610);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        this.AoL.dZR();
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
    this.AoN.post(new SnsUploadUI.8(this));
    if ((this.zWg != null) && ((this.zWg instanceof ai)))
    {
      ai localai = (ai)this.zWg;
      if (localai.zSU != null)
      {
        if (!localai.zTb)
        {
          localai.eab();
          AppMethodBeat.o(99603);
          return;
        }
        localai.eac();
      }
    }
    AppMethodBeat.o(99603);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(99594);
    if (paramBundle != null)
    {
      if (this.zWf != null) {
        paramBundle.putString("contentdesc", this.zWf.getText().toString());
      }
      this.zWg.aq(paramBundle);
    }
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(99594);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(176385);
    super.onStart();
    ag.dFL().postDelayed(this.AoY, this.AoX);
    AppMethodBeat.o(176385);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(176387);
    super.onStop();
    ag.dFL().removeCallbacks(this.AoY);
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