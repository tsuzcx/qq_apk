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
import com.tencent.mm.ak.n;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.g.a.jr.a;
import com.tencent.mm.g.a.up;
import com.tencent.mm.g.b.a.fm;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ah.a;
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
  private String desc;
  private int iTj;
  private KeyboardLinearLayout sDp;
  private String xVI;
  private int yAv;
  private String yBF;
  private boolean yBG;
  private String yCb;
  private int yCc;
  private int yCd;
  private SnsEditText yEK;
  private ab yEL;
  private LinearLayout yEM;
  private ArrayList<String> yEO;
  private boolean yEP;
  private boolean yEQ;
  private long yER;
  private String yEk;
  private String yEl;
  private String yEm;
  private AtContactWidget yXa;
  private LocationWidget yXb;
  private RangeWidget yXc;
  private SnsUploadSayFooter yXd;
  private DynamicGridView yXe;
  private boolean yXf;
  private boolean yXg;
  boolean yXh;
  private Map<Integer, ab> yXi;
  private Map<String, List<String>> yXj;
  private Map<String, List<String>> yXk;
  private String yXl;
  private long yXm;
  private Runnable yXn;
  private FrameLayout yXo;
  private long yXp;
  private long yXq;
  private int yXr;
  private com.tencent.mm.sdk.b.c<jr> yXs;
  private SnsUploadConfigView yxJ;
  
  public SnsUploadUI()
  {
    AppMethodBeat.i(99593);
    this.yBG = false;
    this.yAv = 0;
    this.yEQ = false;
    this.yER = 0L;
    this.yEL = null;
    this.yEk = "";
    this.yEl = "";
    this.yEm = "";
    this.yCc = 0;
    this.yCd = 0;
    this.yEP = false;
    this.yXf = false;
    this.yXg = false;
    this.yXh = false;
    this.yCb = null;
    this.yBF = "";
    this.yXi = new HashMap();
    this.yXj = new HashMap();
    this.yXk = new HashMap();
    this.xVI = "";
    this.yXl = "";
    this.yXm = 3000L;
    this.yXn = new Runnable()
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
          String str = ah.B((byte[])localObject);
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SnsUploadUI", "autoSaveDraft lastMd5:%s, newMd5:%s", new Object[] { SnsUploadUI.b(SnsUploadUI.this), str });
          if (!bs.lr(SnsUploadUI.b(SnsUploadUI.this), str))
          {
            SnsUploadUI.a(SnsUploadUI.this, str);
            SnsUploadUI.a(SnsUploadUI.this, (byte[])localObject, 1);
          }
          com.tencent.mm.plugin.sns.model.af.dvq().postDelayed(SnsUploadUI.c(SnsUploadUI.this), SnsUploadUI.d(SnsUploadUI.this));
        }
        AppMethodBeat.o(176362);
      }
    };
    this.yXo = null;
    this.yXp = 0L;
    this.yXq = 0L;
    this.iTj = 0;
    this.yXr = 0;
    this.yXs = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(jr paramAnonymousjr)
      {
        AppMethodBeat.i(176377);
        if ((paramAnonymousjr != null) && (bs.lr(paramAnonymousjr.dli.dlj, SnsUploadUI.this.hashCode()))) {
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GWn, paramAnonymousjr.dli.dlk);
        }
        AppMethodBeat.o(176377);
        return false;
      }
    };
    AppMethodBeat.o(99593);
  }
  
  private ab PM(int paramInt)
  {
    AppMethodBeat.i(99614);
    Object localObject1 = (ab)this.yXi.get(Integer.valueOf(paramInt));
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
      this.yXi.put(Integer.valueOf(paramInt), localObject1);
      localObject2 = localObject1;
      AppMethodBeat.o(99614);
      return localObject2;
      label67:
      if (paramInt == 14) {
        localObject1 = new af(this);
      }
    }
  }
  
  private void PN(int paramInt)
  {
    AppMethodBeat.i(176389);
    com.tencent.mm.plugin.sns.j.f.ydE.ydM.mT(this.yBF);
    com.tencent.mm.plugin.sns.j.f.ydE.ydM.dXV = paramInt;
    if ((paramInt == 3) || (paramInt == 2)) {
      com.tencent.mm.plugin.sns.j.f.ydE.dJu();
    }
    AppMethodBeat.o(176389);
  }
  
  private void V(final byte[] paramArrayOfByte, final int paramInt)
  {
    AppMethodBeat.i(200606);
    com.tencent.mm.plugin.sns.model.af.dvq().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176380);
        long l = System.currentTimeMillis();
        com.tencent.mm.plugin.sns.model.af.dHY().b(SnsUploadUI.g(SnsUploadUI.this), paramArrayOfByte, paramInt);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsUploadUI", "saveDraft draftKey:%s, %s", new Object[] { SnsUploadUI.g(SnsUploadUI.this), Long.valueOf(bs.Ap(l)) });
        AppMethodBeat.o(176380);
      }
    });
    AppMethodBeat.o(200606);
  }
  
  private void WJ()
  {
    AppMethodBeat.i(99601);
    this.yEQ = getIntent().getBooleanExtra("KSnsPostManu", false);
    this.yER = getIntent().getLongExtra("KTouchCameraTime", 0L);
    this.yAv = getIntent().getIntExtra("Ksnsupload_type", 0);
    this.yBG = getIntent().getBooleanExtra("Kis_take_photo", false);
    if (this.yBG) {}
    for (int i = 2;; i = 1)
    {
      this.yXr = i;
      this.yXf = getIntent().getBooleanExtra("need_result", false);
      this.yXg = getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false);
      this.yCb = getIntent().getStringExtra("Ksnsupload_canvas_info");
      this.yBF = getIntent().getStringExtra("KSessionID");
      if (!bs.isNullOrNil(this.yBF)) {
        break;
      }
      this.yBF = com.tencent.mm.plugin.sns.data.q.dGC();
      getIntent().putExtra("KSessionID", this.yBF);
      AppMethodBeat.o(99601);
      return;
    }
    this.yXr = 3;
    AppMethodBeat.o(99601);
  }
  
  private void aL(Intent paramIntent)
  {
    List localList2 = null;
    AppMethodBeat.i(99606);
    this.yXc.a(5, -1, paramIntent, this.yXa);
    int i = paramIntent.getIntExtra("Ktag_range_index", 0);
    if (i >= 2)
    {
      this.yEk = paramIntent.getStringExtra("Klabel_name_list");
      this.yEl = paramIntent.getStringExtra("Kother_user_name_list");
      this.yEm = paramIntent.getStringExtra("Kchat_room_name_list");
      if (bs.isNullOrNil(this.yEk)) {
        break label275;
      }
    }
    label275:
    for (paramIntent = Arrays.asList(this.yEk.split(","));; paramIntent = null)
    {
      List localList1;
      if (!bs.isNullOrNil(this.yEl))
      {
        localList1 = Arrays.asList(this.yEl.split(","));
        com.tencent.mm.plugin.sns.j.f.ydE.fB(localList1);
      }
      for (;;)
      {
        if (!bs.isNullOrNil(this.yEm)) {
          localList2 = Arrays.asList(this.yEm.split(","));
        }
        o(paramIntent, localList1);
        eN(localList2);
        if (i == 2)
        {
          this.yEP = false;
          if ((this.yXj != null) && (!this.yXj.isEmpty())) {
            com.tencent.mm.plugin.sns.j.f.ydE.aH(this.yXj);
          }
          if ((this.yXk != null) && (!this.yXk.isEmpty())) {
            com.tencent.mm.plugin.sns.j.f.ydE.aG(this.yXk);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.j.f.ydE.OD(i);
          AppMethodBeat.o(99606);
          return;
          this.yEP = true;
          break;
          if (!bs.gY(this.yEO)) {
            this.yEO.clear();
          }
        }
        localList1 = null;
      }
    }
  }
  
  private void an(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(99615);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsUploadUI", "attachWidget. share type %d, isManuSnsPost:%b", new Object[] { Integer.valueOf(this.yAv), Boolean.valueOf(this.yEQ) });
    Object localObject;
    if ((this.yAv == 0) || (this.yAv == 14) || (this.yAv == 9))
    {
      localObject = Parcel.obtain();
      getIntent().writeToParcel((Parcel)localObject, 0);
      ((Parcel)localObject).marshall();
      if (this.yAv != 9) {
        break label452;
      }
      setMMTitle(getContext().getResources().getString(2131764021));
    }
    RelativeLayout.LayoutParams localLayoutParams;
    label452:
    int i;
    switch (this.yAv)
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
        this.yEL.ak(paramBundle);
        if (!(this.yEL instanceof ak)) {
          break label815;
        }
        paramBundle = findViewById(2131304970);
        localObject = findViewById(2131304985);
        this.yXe = ((DynamicGridView)findViewById(2131305045));
        this.yXe.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(176375);
            boolean bool = SnsUploadUI.J(SnsUploadUI.this);
            AppMethodBeat.o(176375);
            return bool;
          }
        });
        paramBundle = ((ak)this.yEL).a(paramBundle, findViewById(2131298953), this.yXe, (View)localObject);
        this.yXe.setVisibility(0);
        localObject = findViewById(2131306994);
        localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        localLayoutParams.topMargin = 0;
        localLayoutParams.addRule(3, 2131305045);
        ((View)localObject).setLayoutParams(localLayoutParams);
        if ((this.yEL instanceof ac))
        {
          localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).width = -1;
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if (((this.yEL instanceof q)) || ((this.yEL instanceof o)) || ((this.yEL instanceof p)))
        {
          localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).width = -1;
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        dRl();
        if (this.yAv == 0) {
          dRj();
        }
        AppMethodBeat.o(99615);
        return;
        setMMTitle("");
        break;
        this.xVI = "draft_normal";
        this.yEL = PM(this.yAv);
        this.yEK.addTextChangedListener(new TextWatcher()
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
        this.xVI = "draft_normal";
        this.yEL = PM(this.yAv);
        continue;
        this.yEL = new ac(this);
        continue;
        this.yEL = new ae(this);
        continue;
        this.yEL = new al(this, 9);
        continue;
        this.yEL = new al(this, 12);
        continue;
        this.yEL = new q(this);
        continue;
        this.yEL = new o(this);
        continue;
        this.yEL = new r(this);
        continue;
        this.yEL = new p(this);
        continue;
        this.yEL = new al(this, 14);
        continue;
        this.yEL = new al(this, 13);
      }
    case 9: 
      this.xVI = "draft_text";
      localObject = bs.bG(getIntent().getStringExtra("Kdescription"), "");
      i = bs.a(Integer.valueOf(getIntent().getIntExtra("KparseLen", 0)), 0);
      if ((localObject == null) || (bs.isNullOrNil(((String)localObject).trim()))) {
        break;
      }
    }
    for (;;)
    {
      this.yEL = new ag(this, bool);
      this.yEK.setPasterLen(i);
      this.yEK.setText(com.tencent.mm.ui.f.c.b.c(getContext(), (CharSequence)localObject, this.yEK.getTextSize()));
      this.yEK.addTextChangedListener(new TextWatcher()
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
      this.yEL = new bj(this);
      break;
      label815:
      paramBundle = this.yEL.dNs();
      this.yEM = ((LinearLayout)findViewById(2131306993));
      this.yEM.setVisibility(0);
      this.yEM.setClipChildren(false);
      label876:
      float f;
      if (paramBundle != null)
      {
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SnsUploadUI", "will add widget view in widgetLL.");
        this.yEM.addView(paramBundle);
        if ((this.yAv == 9) || (this.yAv == 14))
        {
          localObject = findViewById(2131306994);
          localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
          localLayoutParams.addRule(3, 2131306993);
          f = com.tencent.mm.sdk.platformtools.f.aNu().density;
          if (this.yAv != 9) {
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
        this.yEM.setVisibility(8);
        break label876;
      }
      bool = false;
    }
  }
  
  private void cCf()
  {
    AppMethodBeat.i(99598);
    if (((this.yAv == 0) && (((ak)this.yEL).dOv() > 0)) || ((this.yAv == 14) && ((this.yEL instanceof af)) && (!((af)this.yEL).yBH)) || ((this.yAv == 9) && (!bs.isNullOrNil(this.yEK.getText().toString()))))
    {
      com.tencent.mm.ui.base.h.a(this, 2131764054, 0, 2131764056, 2131764055, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(99587);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsUploadUI", "exitAndSave shareType:%s realtimeType:%s", new Object[] { Integer.valueOf(SnsUploadUI.h(SnsUploadUI.this)), Integer.valueOf(SnsUploadUI.this.getIntent().getIntExtra("Ksnsupload_type", -1)) });
          SnsUploadUI.a(SnsUploadUI.this, 1);
          paramAnonymousDialogInterface = Parcel.obtain();
          SnsUploadUI.this.getIntent().putExtra("Kdescription", SnsUploadUI.a(SnsUploadUI.this).getText().toString());
          SnsUploadUI.this.getIntent().putExtra("KparseLen", SnsUploadUI.a(SnsUploadUI.this).getPasterLen());
          SnsUploadUI.this.getIntent().writeToParcel(paramAnonymousDialogInterface, 0);
          paramAnonymousDialogInterface = paramAnonymousDialogInterface.marshall();
          SnsUploadUI.a(SnsUploadUI.this, paramAnonymousDialogInterface, 0);
          SnsUploadUI.i(SnsUploadUI.this);
          switch (SnsUploadUI.h(SnsUploadUI.this))
          {
          default: 
            paramAnonymousInt = 0;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(paramAnonymousInt), SnsUploadUI.j(SnsUploadUI.this), Long.valueOf(bs.aNx()), Integer.valueOf(1) });
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
          com.tencent.mm.plugin.sns.model.af.dvq().removeCallbacks(SnsUploadUI.c(SnsUploadUI.this));
          SnsUploadUI.a(SnsUploadUI.this, null, 0);
          SnsUploadUI.i(SnsUploadUI.this);
          paramAnonymousDialogInterface = SnsUploadUI.this.getIntent().getStringExtra("KSightThumbPath");
          Object localObject = SnsUploadUI.this.getIntent().getStringExtra("KSightPath");
          if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUl, true))
          {
            com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.wDE;
            com.tencent.mm.plugin.recordvideo.e.b.aqT((String)localObject);
            localObject = com.tencent.mm.plugin.recordvideo.e.b.wDE;
            com.tencent.mm.plugin.recordvideo.e.b.aqT(paramAnonymousDialogInterface);
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
            com.tencent.mm.plugin.report.service.h.wUl.f(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(paramAnonymousInt), SnsUploadUI.j(SnsUploadUI.this), Long.valueOf(bs.aNx()), Integer.valueOf(0) });
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
    if (((this.yEL instanceof ac)) || ((this.yEL instanceof ae)))
    {
      if (!bs.isNullOrNil(this.yEK.getText().toString()))
      {
        com.tencent.mm.plugin.sns.model.af.dvq().removeCallbacks(this.yXn);
        Parcel localParcel = Parcel.obtain();
        getIntent().putExtra("Kdescription", this.yEK.getText().toString());
        getIntent().putExtra("KparseLen", this.yEK.getPasterLen());
        getIntent().writeToParcel(localParcel, 0);
        V(localParcel.marshall(), 0);
        com.tencent.mm.plugin.report.service.h.wUl.f(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(7), this.yBF, Long.valueOf(bs.aNx()), Integer.valueOf(3) });
      }
      dRn();
      PN(2);
      dRo();
      dRk();
      AppMethodBeat.o(99598);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, 2131764053, 0, 2131755277, 2131755691, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(176381);
        com.tencent.mm.plugin.sns.model.af.dvq().removeCallbacks(SnsUploadUI.c(SnsUploadUI.this));
        SnsUploadUI.a(SnsUploadUI.this, null, 0);
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
  private void dRj()
  {
    AppMethodBeat.i(99596);
    if (!(this.yEL instanceof ak))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SnsUploadUI", "!(widget instanceof PicWidget)");
      AppMethodBeat.o(99596);
      return;
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SnsUploadUI", "sdk not support dragdrop event");
      AppMethodBeat.o(99596);
      return;
    }
    new SnsUploadUI.12(this).run();
    AppMethodBeat.o(99596);
  }
  
  private void dRk()
  {
    AppMethodBeat.i(99599);
    setResult(0, new Intent());
    finish();
    com.tencent.mm.plugin.sns.data.q.dGD();
    AppMethodBeat.o(99599);
  }
  
  private void dRn()
  {
    AppMethodBeat.i(176388);
    if (this.yAv == 9)
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GGh, this.yBF);
      AppMethodBeat.o(176388);
      return;
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GGg, this.yBF);
    AppMethodBeat.o(176388);
  }
  
  private void dRo()
  {
    AppMethodBeat.i(176390);
    com.tencent.mm.plugin.expt.a.c localc = (com.tencent.mm.plugin.expt.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.c.class);
    localc.fD("startTime", this.yXq);
    localc.fD("endTime", bs.eWj());
    localc.fD("bussinessId", this.yBF);
    localc.fD("shareType", this.yAv);
    localc.fD("hadLocation", this.yXb.getShowFlag());
    localc.fD("desc", this.yEK.getText().toString());
    localc.fD("nextStep", this.iTj);
    localc.fD("beforeStep", this.yXr);
    localc.fD("ContactTagCount", this.yCc);
    localc.fD("mIsBlackGroup", this.yEP);
    if (this.yEO != null)
    {
      localObject1 = this.yEO.size();
      localc.fD("mContactNameList", (String)localObject1);
      if (!(this.yEL instanceof ak)) {
        break label423;
      }
      Object localObject2 = ((ak)this.yEL).dOx();
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
    localc.fD("picSource", ((StringBuilder)localObject1).toString());
    label423:
    if ((this.yEL instanceof af)) {
      if (!((af)this.yEL).dNQ()) {
        break label467;
      }
    }
    label467:
    for (Object localObject1 = "1";; localObject1 = "2")
    {
      localc.fD("sightSource", (String)localObject1);
      AppMethodBeat.o(176390);
      return;
    }
  }
  
  private void eN(List<String> paramList)
  {
    AppMethodBeat.i(99607);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(99607);
      return;
    }
    this.yXk.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str1 = (String)paramList.next();
      ArrayList localArrayList = new ArrayList();
      Object localObject = com.tencent.mm.model.q.wa(str1);
      if (localObject != null)
      {
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SnsUploadUI", "getContactNamesFromChatroom chatromm:%s membersCount:%s", new Object[] { str1, Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          if ((!this.yEO.contains(str2)) && (w.wG(str2)))
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsUploadUI", "getContactNamesFromChatroom memberName:%s", new Object[] { str2 });
            this.yEO.add(str2);
            this.yCd += 1;
          }
          if (w.wG(str2)) {
            localArrayList.add(str2);
          }
        }
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SnsUploadUI", "%s , %s", new Object[] { str1, Integer.valueOf(localArrayList.size()) });
        this.yXk.put(str1, localArrayList);
      }
    }
    AppMethodBeat.o(99607);
  }
  
  private void o(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(99608);
    this.yEO = new ArrayList();
    this.yCc = 0;
    this.yXj.clear();
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
        localList = com.tencent.mm.plugin.label.a.a.cWd().ajD(com.tencent.mm.plugin.label.a.a.cWd().ajA(str1));
        if ((localList == null) || (localList.size() == 0)) {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SnsUploadUI", "dz: getContactNamesFromLabelsAndOtherUserName,namelist get bu label is null");
        }
      }
      else
      {
        this.yEO = new ArrayList(localHashSet);
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
      if (bs.isNullOrNil((String)paramList1.next())) {
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
        this.yCc += 1;
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SnsUploadUI", "dz:name : %s", new Object[] { str2 });
      }
      this.yXj.put(str1, localList);
      break;
      this.yCc = i;
      this.yCd = 0;
      if ((paramList2 != null) && (paramList2.size() > 0))
      {
        paramList1 = paramList2.iterator();
        while (paramList1.hasNext())
        {
          paramList2 = (String)paramList1.next();
          if (!this.yEO.contains(paramList2))
          {
            this.yEO.add(paramList2);
            this.yCd += 1;
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsUploadUI", "updateSightConfig");
    getIntent().getExtras().clear();
    getIntent().putExtra("KSightPath", paramString1);
    getIntent().putExtra("KSightThumbPath", paramString2);
    getIntent().putExtra("sight_md5", paramString3);
    getIntent().putExtra("KSnsPostManu", true);
    getIntent().putExtra("Ksnsupload_type", 14);
    getIntent().putExtra("Kis_take_photo", false);
    getIntent().putExtra("KMMSightExtInfo", paramArrayOfByte);
    if (paramBoolean) {
      getIntent().putExtra("KSessionID", bs.eWj() + "_" + bs.Yu(5));
    }
    AppMethodBeat.o(99612);
  }
  
  public final void a(String paramString, boolean paramBoolean, int paramInt1, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int paramInt2)
  {
    AppMethodBeat.i(99611);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsUploadUI", "updatePicConfig");
    getIntent().getExtras().clear();
    getIntent().putExtra("KTouchCameraTime", bs.aNx());
    getIntent().putExtra("KSnsPostManu", true);
    getIntent().putExtra("Ksnsupload_type", 0);
    getIntent().putExtra("KFilterId", paramInt1);
    if (!bs.isNullOrNil(paramString)) {
      getIntent().putExtra("sns_kemdia_path", paramString);
    }
    if (!bs.gY(paramArrayList1)) {
      getIntent().putExtra("sns_kemdia_path_list", paramArrayList1);
    }
    if (!bs.gY(paramArrayList2)) {
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
  
  public final ArrayList<Exif.a> dNF()
  {
    AppMethodBeat.i(99609);
    if ((this.yEL instanceof ak))
    {
      ak localak = (ak)this.yEL;
      Object localObject1 = localak.yDq.yDB;
      ArrayList localArrayList = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (Exif.a)localak.yDs.get(localObject2);
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
  
  public final boolean dNG()
  {
    return this.yBG;
  }
  
  public final void dRl()
  {
    AppMethodBeat.i(99600);
    if (this.yEL.dNr())
    {
      enableOptionMenu(true);
      AppMethodBeat.o(99600);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(99600);
  }
  
  public final void dRm()
  {
    AppMethodBeat.i(99613);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsUploadUI", "resetWidget");
    if (this.yXe != null) {
      this.yXe.setVisibility(8);
    }
    if (this.yEM != null)
    {
      this.yEM.removeAllViews();
      this.yEM.setVisibility(8);
    }
    if (this.yEL != null) {
      this.yEL.dNt();
    }
    WJ();
    an(null);
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
    if (this.yEK != null) {
      this.yEK.clearFocus();
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
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRN, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(getContext(), "android.permission.ACCESS_COARSE_LOCATION", 64);
      }
      AppMethodBeat.o(99605);
      return;
    }
    if (this.yEL.k(paramInt1, paramIntent)) {
      dRl();
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
      aL(paramIntent);
      AppMethodBeat.o(99605);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      getIntent().putExtras(paramIntent.getExtras());
      this.yXa.aI(paramIntent);
      AppMethodBeat.o(99605);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      boolean bool = paramIntent.getBooleanExtra("bind_facebook_succ", false);
      paramIntent = this.yxJ;
      if (bool)
      {
        paramIntent.yWL = true;
        paramIntent.setSyncFacebook(true);
      }
      AppMethodBeat.o(99605);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      String str1 = bs.bG(paramIntent.getStringExtra("get_poi_name"), "");
      String str2 = bs.bG(paramIntent.getStringExtra("get_city"), "");
      if (bs.isNullOrNil(str1)) {
        getIntent().removeExtra("get_poi_name");
      }
      if (bs.isNullOrNil(str2)) {
        getIntent().removeExtra("get_city");
      }
      getIntent().putExtras(paramIntent.getExtras());
      this.yXb.aI(paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99595);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsUploadUI", "onCreate");
    com.tencent.mm.pluginsdk.g.o(this);
    super.onCreate(paramBundle);
    setActionbarColor(getContext().getResources().getColor(2131099650));
    hideActionbarLine();
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    com.tencent.mm.plugin.sns.model.af.dHY().db.delete("snsDraft", "key!=? AND key!=? AND timestamp<?", new String[] { "draft_text", "draft_normal", String.valueOf(System.currentTimeMillis() - 86400000L) });
    int i = getIntent().getIntExtra("Ksnsupload_type", 0);
    boolean bool = getIntent().getBooleanExtra("Kis_retry_edit", false);
    Object localObject1;
    Object localObject2;
    label343:
    label631:
    label767:
    int m;
    label750:
    int k;
    label1116:
    int j;
    switch (i)
    {
    default: 
      if ((!bs.isNullOrNil(this.xVI)) && (!bool))
      {
        localObject1 = com.tencent.mm.plugin.sns.model.af.dHY().auU(this.xVI);
        if (localObject1 != null)
        {
          localObject1 = ((l)localObject1).field_draft;
          if (!bs.cv((byte[])localObject1))
          {
            localObject2 = Parcel.obtain();
            ((Parcel)localObject2).unmarshall((byte[])localObject1, 0, localObject1.length);
            ((Parcel)localObject2).setDataPosition(0);
            setIntent((Intent)Intent.CREATOR.createFromParcel((Parcel)localObject2));
          }
        }
      }
      WJ();
      this.yEK = ((SnsEditText)findViewById(2131304971));
      if (!bs.isNullOrNil(getIntent().getStringExtra("Kdescription")))
      {
        this.yEK.setText(com.tencent.mm.ui.f.c.b.c(getContext(), getIntent().getStringExtra("Kdescription"), this.yEK.getTextSize()));
        if (this.yAv == 8)
        {
          localObject1 = getIntent().getStringExtra("Kdescription");
          this.yEK.setText(com.tencent.mm.ui.f.c.b.c(getContext(), (CharSequence)localObject1, this.yEK.getTextSize()));
        }
        this.yEK.setPasterLen(getIntent().getIntExtra("KparseLen", 0));
        this.sDp = ((KeyboardLinearLayout)findViewById(2131304239));
        this.yXd = ((SnsUploadSayFooter)findViewById(2131304290));
        this.yXd.setMMEditText(this.yEK);
        this.yXd.setVisibility(4);
        this.yXo = ((FrameLayout)findViewById(2131304243));
        this.yXo.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(176382);
            DisplayMetrics localDisplayMetrics = new DisplayMetrics();
            SnsUploadUI.this.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
            com.tencent.mm.plugin.sns.model.af.dHG();
            com.tencent.mm.plugin.sns.storage.u.hu(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
            AppMethodBeat.o(176382);
          }
        });
        this.yEK.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(176383);
            SnsUploadUI.n(SnsUploadUI.this);
            AppMethodBeat.o(176383);
          }
        });
        this.yEK.setOnLongClickListener(new View.OnLongClickListener()
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
        this.yEK.addTextChangedListener(new SnsUploadUI.2(this, new boolean[] { true }));
        localObject2 = (WrapScollview)findViewById(2131304376);
        ((WrapScollview)localObject2).setContentView(this.yEK);
        ((WrapScollview)localObject2).setDoComputeScrollDeltaToGetChildRectOnScreen(false);
        Object localObject3 = bs.bG(getIntent().getStringExtra("reportSessionId"), "");
        this.yxJ = ((SnsUploadConfigView)findViewById(2131298555));
        localObject2 = this.yxJ;
        if ((this.yAv != 14) || (((String)localObject3).contains("wx5dfbe0a95623607b"))) {
          break label1701;
        }
        bool = true;
        ((SnsUploadConfigView)localObject2).yWR = bool;
        if (bool)
        {
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(2842, (com.tencent.mm.ak.g)localObject2);
          localObject3 = new com.tencent.mm.plugin.sns.model.i();
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject3, 0);
        }
        ((SnsUploadConfigView)localObject2).yBX.Ehu = -1000.0F;
        ((SnsUploadConfigView)localObject2).yBX.Eht = -1000.0F;
        if (!((SnsUploadConfigView)localObject2).yQQ)
        {
          com.tencent.mm.kernel.g.agS();
          i = bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(68404, null));
          if ((i & 0x2) == 0) {
            break label1707;
          }
          bool = true;
          ((SnsUploadConfigView)localObject2).yWL = bool;
          if ((i & 0x8) == 0) {
            break label1713;
          }
          bool = true;
          ((SnsUploadConfigView)localObject2).yWM = bool;
          if (!com.tencent.mm.aw.b.aGf()) {
            ((SnsUploadConfigView)localObject2).yWM = false;
          }
          if (!com.tencent.mm.model.u.axW()) {
            ((SnsUploadConfigView)localObject2).yWL = false;
          }
        }
        ((SnsUploadConfigView)localObject2).setSyncFacebook(false);
        ((SnsUploadConfigView)localObject2).dRd();
        ((SnsUploadConfigView)localObject2).dRf();
        ((SnsUploadConfigView)localObject2).dRe();
        if (((SnsUploadConfigView)localObject2).yWM) {
          ((SnsUploadConfigView)localObject2).yWS.a((a.a)localObject2);
        }
        if (this.yAv != 0)
        {
          localObject2 = this.yxJ;
          ((SnsUploadConfigView)localObject2).yWG.setVisibility(8);
          ((SnsUploadConfigView)localObject2).yWH.setVisibility(8);
          ((SnsUploadConfigView)localObject2).yWI.setVisibility(8);
          ((SnsUploadConfigView)localObject2).yWJ.setVisibility(8);
        }
        if (this.yAv == 9) {
          this.yxJ.yWI.setVisibility(0);
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
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsUploadUI", "skip commit, is finishing");
              AppMethodBeat.o(176366);
              return false;
            }
            if (System.currentTimeMillis() - SnsUploadUI.p(SnsUploadUI.this) < 500L)
            {
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsUploadUI", "skip commit, click frequently");
              AppMethodBeat.o(176366);
              return false;
            }
            if (SnsUploadUI.q(SnsUploadUI.this))
            {
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsUploadUI", "skip commit, has commited");
              AppMethodBeat.o(176366);
              return false;
            }
            com.tencent.mm.plugin.sns.model.af.dvq().removeCallbacks(SnsUploadUI.c(SnsUploadUI.this));
            paramAnonymousMenuItem = Parcel.obtain();
            SnsUploadUI.this.getIntent().putExtra("Kdescription", SnsUploadUI.a(SnsUploadUI.this).getText().toString());
            SnsUploadUI.this.getIntent().putExtra("KparseLen", SnsUploadUI.a(SnsUploadUI.this).getPasterLen());
            SnsUploadUI.this.getIntent().writeToParcel(paramAnonymousMenuItem, 0);
            paramAnonymousMenuItem = paramAnonymousMenuItem.marshall();
            SnsUploadUI.a(SnsUploadUI.this, paramAnonymousMenuItem, 2);
            SnsUploadUI.i(SnsUploadUI.this);
            if (this.iSP[0] != 0) {
              this.iSP[0] = false;
            }
            for (;;)
            {
              SnsUploadUI.a(SnsUploadUI.this, System.currentTimeMillis());
              com.tencent.mm.plugin.report.service.g.MH(22);
              paramAnonymousMenuItem = com.tencent.mm.ui.tools.b.c.d(SnsUploadUI.a(SnsUploadUI.this)).acw(com.tencent.mm.m.b.ZB());
              paramAnonymousMenuItem.IVj = true;
              paramAnonymousMenuItem.a(new c.a()
              {
                public final void GK(String paramAnonymous2String)
                {
                  AppMethodBeat.i(176364);
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsUploadUI", "commit after check");
                  SnsUploadUI.a(SnsUploadUI.this, 3);
                  SnsUploadUI.r(SnsUploadUI.this);
                  int i = SnsUploadUI.s(SnsUploadUI.this).getSyncFlag();
                  com.tencent.mm.kernel.g.agS();
                  com.tencent.mm.kernel.g.agR().agA().set(68404, Integer.valueOf(i));
                  SnsUploadUI.b(SnsUploadUI.this, SnsUploadUI.a(SnsUploadUI.this).getText().toString());
                  i = SnsUploadUI.a(SnsUploadUI.this).getPasterLen();
                  int j = SnsUploadUI.s(SnsUploadUI.this).getPrivated();
                  int k = SnsUploadUI.s(SnsUploadUI.this).getSyncFlag();
                  SnsUploadUI.t(SnsUploadUI.this);
                  if (SnsUploadUI.u(SnsUploadUI.this)) {
                    SnsUploadUI.this.setResult(-1, new Intent());
                  }
                  if ((SnsUploadUI.e(SnsUploadUI.this) instanceof ak)) {
                    ((ak)SnsUploadUI.e(SnsUploadUI.this)).yDw = SnsUploadUI.v(SnsUploadUI.this).getCurLocation();
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
                      localObject = com.tencent.mm.plugin.report.service.h.wUl;
                      long l1 = SnsUploadUI.F(SnsUploadUI.this);
                      long l2 = bs.aNx();
                      if (!SnsUploadUI.G(SnsUploadUI.this)) {
                        break label1088;
                      }
                      i = 0;
                      ((com.tencent.mm.plugin.report.service.h)localObject).f(13303, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymous2String.value), "" });
                      l1 = SnsUploadUI.F(SnsUploadUI.this);
                      l2 = bs.aNx();
                      if (!SnsUploadUI.G(SnsUploadUI.this)) {
                        break label1093;
                      }
                      i = 0;
                      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SnsUploadUI", "reprot timelinePostAction(13303), %d, %d, %d, %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymous2String.value) });
                      com.tencent.mm.plugin.report.service.h.wUl.kvStat(10910, "1");
                      if (!bs.isNullOrNil(SnsUploadUI.H(SnsUploadUI.this)))
                      {
                        if (!SnsUploadUI.z(SnsUploadUI.this)) {
                          break label1098;
                        }
                        com.tencent.mm.plugin.report.service.h.wUl.f(11455, new Object[] { "", SnsUploadUI.H(SnsUploadUI.this), Integer.valueOf(-1), Integer.valueOf(-1) });
                      }
                      if (SnsUploadUI.I(SnsUploadUI.this))
                      {
                        localObject = new Intent(SnsUploadUI.this, SnsTimeLineUI.class);
                        ((Intent)localObject).putExtra("sns_resume_state", false);
                        ((Intent)localObject).putExtra("sns_timeline_NeedFirstLoadint", true);
                        ((Intent)localObject).addFlags(67108864);
                        paramAnonymous2String = SnsUploadUI.this;
                        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/sns/ui/SnsUploadUI$12$1", "doWhenOK", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymous2String.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2String, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$12$1", "doWhenOK", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      }
                      com.tencent.mm.pluginsdk.ui.tools.o.aY(SnsUploadUI.this.getIntent());
                      paramAnonymous2String = new up();
                      com.tencent.mm.sdk.b.a.GpY.l(paramAnonymous2String);
                      SnsUploadUI.b(SnsUploadUI.this, 1);
                      SnsUploadUI.k(SnsUploadUI.this);
                      com.tencent.mm.plugin.sns.data.q.dGD();
                      AppMethodBeat.o(176364);
                      return;
                    }
                    catch (IOException localIOException)
                    {
                      com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.SnsUploadUI", localIOException, "parse location error", new Object[0]);
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
                    com.tencent.mm.plugin.report.service.h.wUl.f(11455, new Object[] { SnsUploadUI.H(SnsUploadUI.this), "", Integer.valueOf(-1), Integer.valueOf(-1) });
                  }
                }
                
                public final void aRi() {}
                
                public final void ca(String paramAnonymous2String)
                {
                  AppMethodBeat.i(176365);
                  com.tencent.mm.ui.base.h.l(SnsUploadUI.this, 2131764058, 2131764059);
                  AppMethodBeat.o(176365);
                }
              });
              AppMethodBeat.o(176366);
              return false;
              com.tencent.mm.plugin.normsg.a.b.vor.id("ce_sns_upload", "<SnsUpload>");
              paramAnonymousMenuItem = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.b.vor.a("ce_sns_upload", paramAnonymousMenuItem);
              com.tencent.mm.plugin.normsg.a.b.vor.aou("ce_sns_upload");
            }
          }
        }, null, new SnsUploadUI.5(this, (boolean[])localObject1), s.b.Hom);
        findViewById(2131306218).setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(176367);
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SnsUploadUI", "upload_content onTouch");
            if (SnsUploadUI.J(SnsUploadUI.this))
            {
              AppMethodBeat.o(176367);
              return true;
            }
            AppMethodBeat.o(176367);
            return false;
          }
        });
        this.yXa = ((AtContactWidget)findViewById(2131296956));
        this.yXa.yxJ = this.yxJ;
        this.yXb = ((LocationWidget)findViewById(2131301546));
        this.yXb.setLocationWidgetListener(this);
        switch (this.yAv)
        {
        default: 
          this.yXc.yxJ = this.yxJ;
          this.yXc.setRangeTipClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(176368);
              SnsUploadUI.K(SnsUploadUI.this);
              AppMethodBeat.o(176368);
            }
          });
          this.yXb.aI(getIntent());
          this.yXa.aI(getIntent());
          com.tencent.mm.plugin.sns.j.f.ydE.OD(0);
          com.tencent.mm.plugin.sns.j.f.ydE.ydM.dXF = 2;
          aL(getIntent());
          hideVKB();
          an(paramBundle);
          paramBundle = com.tencent.mm.plugin.sns.model.af.dHY().auU(this.xVI);
          if ((paramBundle != null) && ((paramBundle.field_extFlag & 0x1) == 1))
          {
            m = 0;
            k = 2;
            i = m;
            j = k;
            switch (this.yAv)
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
      com.tencent.mm.plugin.report.service.h.wUl.f(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(i), this.yBF, Long.valueOf(bs.aNx()), Integer.valueOf(j) });
      com.tencent.mm.pluginsdk.g.p(this);
      paramBundle = Parcel.obtain();
      getIntent().writeToParcel(paramBundle, 0);
      this.yXl = ah.B(paramBundle.marshall());
      this.yXm = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWr, 3000L);
      this.yXq = bs.eWj();
      this.yXh = false;
      AppMethodBeat.o(99595);
      return;
      localObject1 = bv.L(bs.bG(getIntent().getStringExtra("fav_note_xml"), ""), "favlocalid");
      if ((localObject1 == null) || (((Map)localObject1).size() == 0)) {
        break;
      }
      localObject1 = (String)((Map)localObject1).get(".favlocalid");
      if (bs.lr((String)localObject1, "0")) {
        break;
      }
      this.xVI = ((String)localObject1);
      break;
      localObject2 = bs.bG(getIntent().getStringExtra("Ksnsupload_link"), "");
      localObject1 = localObject2;
      if (bs.isNullOrNil((String)localObject2)) {
        localObject1 = bs.bG(getIntent().getStringExtra("ShareUrlOpen"), "");
      }
      localObject2 = localObject1;
      if (bs.isNullOrNil((String)localObject1)) {
        localObject2 = bs.bG(getIntent().getStringExtra("ShareUrlOriginal"), "");
      }
      if (!bs.isNullOrNil((String)localObject2)) {
        this.xVI = com.tencent.mm.plugin.sns.data.q.ath((String)localObject2);
      }
      if (!getIntent().getBooleanExtra("ksnsis_appbrand", false)) {
        break;
      }
      this.xVI = null;
      break;
      this.xVI = bs.bG(getIntent().getStringExtra("Ksnsupload_musicid"), "");
      break;
      if ((this.yEK == null) || (paramBundle == null)) {
        break label343;
      }
      localObject1 = paramBundle.getString("contentdesc");
      if (localObject1 == null) {
        break label343;
      }
      this.yEK.setText((CharSequence)localObject1);
      break label343;
      label1701:
      bool = false;
      break label631;
      label1707:
      bool = false;
      break label750;
      label1713:
      bool = false;
      break label767;
      this.yXc = ((RangeWidget)findViewById(2131303713));
      findViewById(2131303714).setVisibility(8);
      break label1116;
      this.yXc = ((RangeWidget)findViewById(2131303713));
      findViewById(2131303714).setVisibility(8);
      break label1116;
      this.yXc = ((RangeWidget)findViewById(2131303713));
      findViewById(2131303714).setVisibility(8);
      this.yXa.setVisibility(8);
      break label1116;
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
    if (this.yxJ != null)
    {
      localObject = this.yxJ;
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(2842, (com.tencent.mm.ak.g)localObject);
    }
    if (this.yEL != null) {
      this.yEL.dNt();
    }
    if (this.yXb != null) {
      this.yXb.stop();
    }
    if (this.yXd != null)
    {
      localObject = this.yXd;
      if (((SnsUploadSayFooter)localObject).fWT != null)
      {
        ((SnsUploadSayFooter)localObject).fWT.eMG();
        ((SnsUploadSayFooter)localObject).fWT.destroy();
      }
    }
    this.yXi.clear();
    com.tencent.mm.plugin.normsg.a.b.vor.aor("ie_sns_upload");
    com.tencent.mm.plugin.sns.data.q.dGD();
    com.tencent.mm.sdk.b.a.GpY.d(this.yXs);
    AppMethodBeat.o(99604);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99597);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      paramKeyEvent = this.yXd;
      if ((paramKeyEvent.dRh()) || (paramKeyEvent.getVisibility() == 0)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        this.yXd.dRi();
        AppMethodBeat.o(99597);
        return true;
      }
      cCf();
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
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsUploadUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(99610);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsUploadUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(99610);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        this.yXb.dNC();
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
    this.yXd.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176369);
        com.tencent.mm.compatible.util.i.v(SnsUploadUI.this);
        AppMethodBeat.o(176369);
      }
    });
    if ((this.yEL != null) && ((this.yEL instanceof af)))
    {
      af localaf = (af)this.yEL;
      if (localaf.yBA != null)
      {
        if (!localaf.yBH)
        {
          localaf.dNO();
          AppMethodBeat.o(99603);
          return;
        }
        localaf.dNP();
      }
    }
    AppMethodBeat.o(99603);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(99594);
    if (paramBundle != null)
    {
      if (this.yEK != null) {
        paramBundle.putString("contentdesc", this.yEK.getText().toString());
      }
      this.yEL.al(paramBundle);
    }
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(99594);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(176385);
    super.onStart();
    com.tencent.mm.plugin.sns.model.af.dvq().postDelayed(this.yXn, this.yXm);
    AppMethodBeat.o(176385);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(176387);
    super.onStop();
    com.tencent.mm.plugin.sns.model.af.dvq().removeCallbacks(this.yXn);
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