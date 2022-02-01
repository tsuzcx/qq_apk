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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.f.a.lg;
import com.tencent.mm.f.a.xs;
import com.tencent.mm.f.b.a.mt;
import com.tencent.mm.f.b.a.mw;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cst;
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
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.edittext.a.e;
import com.tencent.mm.ui.widget.pulldown.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@com.tencent.mm.kernel.k
@com.tencent.mm.ui.base.a(17)
public class SnsUploadUI
  extends MMSecDataActivity
  implements LocationWidget.a
{
  private KeyboardLinearLayout BNW;
  private String JZY;
  private SnsUploadConfigView KBH;
  private int KGN;
  private int KGO;
  private String KGq;
  private boolean KGr;
  private af KJR;
  private LinearLayout KJS;
  private ArrayList<String> KJU;
  private boolean KJV;
  private boolean KJW;
  private long KJX;
  private String KJq;
  private String KJr;
  private String KJs;
  private LocationWidget LdA;
  private RangeWidget LdB;
  private SnsUploadSayFooter LdC;
  private DynamicGridView LdD;
  private String LdE;
  private boolean LdF;
  private boolean LdG;
  boolean LdH;
  private Map<Integer, af> LdI;
  private Map<String, List<String>> LdJ;
  private Map<String, List<String>> LdK;
  private boolean LdL;
  private String LdM;
  private long LdN;
  private Runnable LdO;
  private FrameLayout LdP;
  private long LdQ;
  private long LdR;
  private int LdS;
  private IListener<lg> LdT;
  private com.tencent.mm.ui.widget.cedit.api.c Ldy;
  private AtContactWidget Ldz;
  private String canvasInfo;
  private String desc;
  private String mSessionId;
  private int nfn;
  private boolean wNV;
  private int yAT;
  
  public SnsUploadUI()
  {
    AppMethodBeat.i(99593);
    this.KGr = false;
    this.yAT = 0;
    this.KJW = false;
    this.KJX = 0L;
    this.KJR = null;
    this.KJq = "";
    this.LdE = "";
    this.KJr = "";
    this.KJs = "";
    this.KGN = 0;
    this.KGO = 0;
    this.KJV = false;
    this.LdF = false;
    this.LdG = false;
    this.LdH = false;
    this.canvasInfo = null;
    this.KGq = "";
    this.wNV = false;
    this.LdI = new HashMap();
    this.LdJ = new HashMap();
    this.LdK = new HashMap();
    this.LdL = false;
    this.JZY = "";
    this.LdM = "";
    this.LdN = 3000L;
    this.LdO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176362);
        if ((SnsUploadUI.a(SnsUploadUI.this) != null) && (SnsUploadUI.b(SnsUploadUI.this) != null) && (SnsUploadUI.b(SnsUploadUI.this).fTz()))
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
          com.tencent.mm.plugin.sns.model.aj.etE().postDelayed(SnsUploadUI.e(SnsUploadUI.this), SnsUploadUI.f(SnsUploadUI.this));
        }
        AppMethodBeat.o(176362);
      }
    };
    this.LdP = null;
    this.LdQ = 0L;
    this.LdR = 0L;
    this.nfn = 0;
    this.LdS = 0;
    this.LdT = new SnsUploadUI.27(this);
    AppMethodBeat.o(99593);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    AppMethodBeat.i(267672);
    com.tencent.mm.plugin.websearch.a.b.a(1, 1, z.bcZ(), paramString2, 1, "", paramString3, paramInt, paramString1, paramLong);
    AppMethodBeat.o(267672);
  }
  
  private void aB(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(99615);
    Log.i("MicroMsg.SnsUploadUI", "attachWidget. share type %d, isManuSnsPost:%b", new Object[] { Integer.valueOf(this.yAT), Boolean.valueOf(this.KJW) });
    Object localObject;
    if ((this.yAT == 0) || (this.yAT == 14) || (this.yAT == 9))
    {
      localObject = Parcel.obtain();
      getIntent().writeToParcel((Parcel)localObject, 0);
      ((Parcel)localObject).marshall();
      if (this.yAT != 9) {
        break label516;
      }
      setMMTitle(getContext().getResources().getString(i.j.sns_text_title));
    }
    RelativeLayout.LayoutParams localLayoutParams;
    label516:
    int i;
    switch (this.yAT)
    {
    default: 
    case 0: 
    case 28: 
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
    case 29: 
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
        this.KJR.ay(paramBundle);
        if ((!(this.KJR instanceof as)) || ((this.KJR instanceof w))) {
          break label979;
        }
        paramBundle = findViewById(i.f.sns_desc_container_frame);
        localObject = findViewById(i.f.sns_img_tips);
        this.LdD = ((DynamicGridView)findViewById(i.f.sns_preview_img_dynamicgrid));
        this.LdD.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(293011);
            boolean bool = SnsUploadUI.L(SnsUploadUI.this);
            AppMethodBeat.o(293011);
            return bool;
          }
        });
        paramBundle = ((as)this.KJR).a(paramBundle, findViewById(i.f.del_area), this.LdD, (View)localObject);
        this.LdD.setVisibility(0);
        localObject = findViewById(i.f.widget_line);
        localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        localLayoutParams.topMargin = 0;
        localLayoutParams.addRule(3, i.f.sns_preview_img_dynamicgrid);
        ((View)localObject).setLayoutParams(localLayoutParams);
        if (((this.KJR instanceof ag)) || ((this.KJR instanceof ai)))
        {
          localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).width = -1;
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if (((this.KJR instanceof q)) || ((this.KJR instanceof o)) || ((this.KJR instanceof p)))
        {
          localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).width = -1;
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        fXY();
        if (this.yAT == 0) {
          fXV();
        }
        AppMethodBeat.o(99615);
        return;
        setMMTitle("");
        break;
        this.JZY = "draft_normal";
        this.KJR = ahv(this.yAT);
        this.Ldy.addTextChangedListener(new SnsUploadUI.17(this));
        continue;
        this.JZY = "draft_normal";
        this.KJR = ahv(this.yAT);
        continue;
        this.KJR = new ag(this);
        continue;
        this.KJR = new am(this);
        continue;
        this.KJR = new al(this);
        continue;
        this.KJR = new at(this, 9);
        continue;
        this.KJR = new at(this, 12);
        continue;
        this.KJR = new q(this);
        continue;
        this.KJR = new o(this);
        continue;
        this.KJR = new r(this);
        continue;
        this.KJR = new p(this);
        continue;
        this.KJR = new at(this, 14);
        continue;
        this.KJR = new at(this, 13);
      }
    case 9: 
      this.JZY = "draft_text";
      localObject = Util.nullAs(getIntent().getStringExtra("Kdescription"), "");
      i = Util.nullAs(Integer.valueOf(getIntent().getIntExtra("KparseLen", 0)), 0);
      if ((localObject == null) || (Util.isNullOrNil(((String)localObject).trim()))) {
        break;
      }
    }
    for (;;)
    {
      this.KJR = new ao(this, bool);
      this.Ldy.setPasterLen(i);
      this.Ldy.setText(com.tencent.mm.ui.h.c.b.c(getContext(), (CharSequence)localObject, this.Ldy.getTextSize()));
      this.Ldy.addTextChangedListener(new SnsUploadUI.18(this));
      break;
      this.KJR = new bs(this);
      break;
      this.KJR = new ai(this);
      break;
      this.KJR = new v(this);
      break;
      this.KJR = new aj(this);
      break;
      this.KJR = new u(this);
      break;
      this.KJR = new t(this);
      break;
      label979:
      paramBundle = this.KJR.fTx();
      this.KJS = ((LinearLayout)findViewById(i.f.widget_content));
      this.KJS.setVisibility(0);
      this.KJS.setClipChildren(false);
      label1040:
      float f;
      if (paramBundle != null)
      {
        Log.d("MicroMsg.SnsUploadUI", "will add widget view in widgetLL.");
        this.KJS.addView(paramBundle);
        if ((this.yAT == 9) || (this.yAT == 14))
        {
          localObject = findViewById(i.f.widget_line);
          localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
          localLayoutParams.addRule(3, i.f.widget_content);
          f = BitmapUtil.getDefaultDisplayMetrics().density;
          if (this.yAT != 9) {
            break label1138;
          }
        }
      }
      label1138:
      for (i = 128;; i = 96)
      {
        localLayoutParams.topMargin = ((int)(i * f));
        ((View)localObject).setLayoutParams(localLayoutParams);
        break;
        this.KJS.setVisibility(8);
        break label1040;
      }
      bool = false;
    }
  }
  
  private void ad(final byte[] paramArrayOfByte, final int paramInt)
  {
    AppMethodBeat.i(267671);
    com.tencent.mm.plugin.sns.model.aj.fwa().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176380);
        long l = System.currentTimeMillis();
        com.tencent.mm.plugin.sns.model.aj.fOP().b(SnsUploadUI.h(SnsUploadUI.this), paramArrayOfByte, paramInt);
        Log.i("MicroMsg.SnsUploadUI", "saveDraft draftKey:%s, %s", new Object[] { SnsUploadUI.h(SnsUploadUI.this), Long.valueOf(Util.milliSecondsToNow(l)) });
        AppMethodBeat.o(176380);
      }
    });
    AppMethodBeat.o(267671);
  }
  
  private af ahv(int paramInt)
  {
    AppMethodBeat.i(99614);
    Object localObject1 = (af)this.LdI.get(Integer.valueOf(paramInt));
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (paramInt != 0) {
        break label67;
      }
      localObject1 = new as(this);
    }
    for (;;)
    {
      this.LdI.put(Integer.valueOf(paramInt), localObject1);
      localObject2 = localObject1;
      AppMethodBeat.o(99614);
      return localObject2;
      label67:
      if (paramInt == 14) {
        localObject1 = new an(this);
      } else if (paramInt == 28) {
        localObject1 = new w(this);
      }
    }
  }
  
  private void ahw(int paramInt)
  {
    AppMethodBeat.i(176389);
    com.tencent.mm.plugin.sns.k.g.Kia.Kik.Dw(this.KGq);
    com.tencent.mm.plugin.sns.k.g.Kia.Kik.gVK = paramInt;
    if ((paramInt == 3) || (paramInt == 2)) {
      com.tencent.mm.plugin.sns.k.g.Kia.fQp();
    }
    AppMethodBeat.o(176389);
  }
  
  private void ata()
  {
    AppMethodBeat.i(99601);
    this.KJW = getIntent().getBooleanExtra("KSnsPostManu", false);
    this.KJX = getIntent().getLongExtra("KTouchCameraTime", 0L);
    this.yAT = getIntent().getIntExtra("Ksnsupload_type", 0);
    this.KGr = getIntent().getBooleanExtra("Kis_take_photo", false);
    int i;
    if (this.KGr)
    {
      i = 2;
      this.LdS = i;
      this.LdF = getIntent().getBooleanExtra("need_result", false);
      this.LdG = getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false);
      this.canvasInfo = getIntent().getStringExtra("Ksnsupload_canvas_info");
      this.KGq = getIntent().getStringExtra("KSessionID");
      this.wNV = getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
      if (!Util.isNullOrNil(this.KGq)) {
        break label234;
      }
      this.KGq = com.tencent.mm.plugin.sns.data.t.fNp();
      getIntent().putExtra("KSessionID", this.KGq);
    }
    for (;;)
    {
      this.mSessionId = com.tencent.mm.plugin.fts.a.d.Sx(79);
      Object localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject = (com.tencent.mm.plugin.sns.j.j)com.tencent.mm.plugin.secdata.ui.a.a.c(this, 2, com.tencent.mm.plugin.sns.j.j.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.sns.j.j)localObject).sessionId = this.mSessionId;
      }
      AppMethodBeat.o(99601);
      return;
      i = 1;
      break;
      label234:
      this.LdS = 3;
    }
  }
  
  private void bb(Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(99606);
    this.LdB.a(5, -1, paramIntent, this.Ldz);
    int i = paramIntent.getIntExtra("Ktag_range_index", 0);
    if (i >= 2)
    {
      this.KJq = paramIntent.getStringExtra("Klabel_name_list");
      this.LdE = paramIntent.getStringExtra("KNew_label_name_list");
      this.KJr = paramIntent.getStringExtra("Kother_user_name_list");
      this.KJs = paramIntent.getStringExtra("Kchat_room_name_list");
      if (Util.isNullOrNil(this.KJq)) {
        break label359;
      }
    }
    label220:
    label359:
    for (List localList = Arrays.asList(this.KJq.split(","));; localList = null)
    {
      Object localObject1;
      if (!Util.isNullOrNil(this.KJr))
      {
        localObject1 = Arrays.asList(this.KJr.split(","));
        com.tencent.mm.plugin.sns.k.g.Kia.hC((List)localObject1);
      }
      for (;;)
      {
        paramIntent = (Intent)localObject1;
        if (!Util.isNullOrNil(this.LdE))
        {
          if (localObject1 == null) {
            paramIntent = Arrays.asList(this.LdE.split(","));
          }
        }
        else
        {
          localObject1 = localObject2;
          if (!Util.isNullOrNil(this.KJs)) {
            localObject1 = Arrays.asList(this.KJs.split(","));
          }
          com.tencent.mm.plugin.sns.model.aj.fwa().post(new SnsUploadUI.14(this, localList, paramIntent, (List)localObject1));
          if (i != 2) {
            break label326;
          }
          this.KJV = false;
          if ((this.LdJ != null) && (!this.LdJ.isEmpty())) {
            com.tencent.mm.plugin.sns.k.g.Kia.aJ(this.LdJ);
          }
          if ((this.LdK != null) && (!this.LdK.isEmpty())) {
            com.tencent.mm.plugin.sns.k.g.Kia.aI(this.LdK);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.k.g.Kia.agg(i);
          AppMethodBeat.o(99606);
          return;
          paramIntent = new ArrayList();
          paramIntent.addAll((Collection)localObject1);
          paramIntent.addAll(Arrays.asList(this.LdE.split(",")));
          break;
          this.KJV = true;
          break label220;
          if (!Util.isNullOrNil(this.KJU)) {
            this.KJU.clear();
          }
        }
        localObject1 = null;
      }
    }
  }
  
  private void dEl()
  {
    AppMethodBeat.i(99598);
    final boolean bool = getIntent().getBooleanExtra("KThrid_app", false);
    Object localObject = Util.nullAs(getIntent().getStringExtra("Ksnsupload_appid"), "");
    if (((this.yAT == 0) && ((((as)this.KJR).fUM() > 0) || (!Util.isNullOrNil(this.Ldy.getText().toString())))) || ((this.yAT == 14) && ((this.KJR instanceof an)) && ((!((an)this.KJR).KGs) || (!Util.isNullOrNil(this.Ldy.getText().toString())))) || ((this.yAT == 9) && (!Util.isNullOrNil(this.Ldy.getText().toString()))) || (((this.KJR instanceof v)) && (!((v)this.KJR).fTC())))
    {
      com.tencent.mm.ui.base.h.a(this, i.j.sns_upload_exit_and_save_tips, 0, i.j.sns_upload_exit_save, i.j.sns_upload_exit_not_save, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            com.tencent.mm.plugin.report.service.h.IzE.a(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(paramAnonymousInt), SnsUploadUI.k(SnsUploadUI.this), Long.valueOf(Util.nowSecond()), Integer.valueOf(1) });
            SnsUploadUI.b(SnsUploadUI.this, 3);
            SnsUploadUI.l(SnsUploadUI.this);
            if (SnsUploadUI.m(SnsUploadUI.this))
            {
              com.tencent.mm.plugin.sns.k.g.Kia.KiK.gWv = 2L;
              com.tencent.mm.plugin.sns.k.g.Kia.fQx();
            }
            if ((SnsUploadUI.b(SnsUploadUI.this) instanceof v))
            {
              com.tencent.mm.plugin.sns.k.g.Kia.KiO.goQ = 3L;
              com.tencent.mm.plugin.sns.k.g.Kia.fQy();
            }
            if ((bool) && (this.val$appId.equals("wxa5e0de08d96cc09d")))
            {
              com.tencent.mm.plugin.sns.k.g.Kia.KiQ.goQ = 3L;
              com.tencent.mm.plugin.sns.k.g.Kia.fQz();
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
          com.tencent.mm.plugin.sns.model.aj.etE().removeCallbacks(SnsUploadUI.e(SnsUploadUI.this));
          SnsUploadUI.a(SnsUploadUI.this, null, 0);
          SnsUploadUI.j(SnsUploadUI.this);
          paramAnonymousDialogInterface = SnsUploadUI.this.getIntent().getStringExtra("KSightThumbPath");
          Object localObject = SnsUploadUI.this.getIntent().getStringExtra("KSightPath");
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGi, true))
          {
            com.tencent.mm.plugin.recordvideo.e.d locald = com.tencent.mm.plugin.recordvideo.e.d.IeU;
            com.tencent.mm.plugin.recordvideo.e.d.aWk((String)localObject);
            localObject = com.tencent.mm.plugin.recordvideo.e.d.IeU;
            com.tencent.mm.plugin.recordvideo.e.d.aWk(paramAnonymousDialogInterface);
          }
          if ((SnsUploadUI.b(SnsUploadUI.this) instanceof ao)) {
            SnsUploadUI.a(SnsUploadUI.this).setText("");
          }
          switch (SnsUploadUI.i(SnsUploadUI.this))
          {
          default: 
            paramAnonymousInt = 0;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(paramAnonymousInt), SnsUploadUI.k(SnsUploadUI.this), Long.valueOf(Util.nowSecond()), Integer.valueOf(0) });
            SnsUploadUI.b(SnsUploadUI.this, 2);
            SnsUploadUI.l(SnsUploadUI.this);
            if (SnsUploadUI.m(SnsUploadUI.this))
            {
              com.tencent.mm.plugin.sns.k.g.Kia.KiK.gWv = 3L;
              com.tencent.mm.plugin.sns.k.g.Kia.fQx();
            }
            if ((SnsUploadUI.b(SnsUploadUI.this) instanceof v))
            {
              com.tencent.mm.plugin.sns.k.g.Kia.KiO.goQ = 3L;
              com.tencent.mm.plugin.sns.k.g.Kia.fQy();
            }
            if ((bool) && (this.val$appId.equals("wxa5e0de08d96cc09d")))
            {
              com.tencent.mm.plugin.sns.k.g.Kia.KiQ.goQ = 3L;
              com.tencent.mm.plugin.sns.k.g.Kia.fQz();
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
      }, i.c.alert_btn_color_no);
      AppMethodBeat.o(99598);
      return;
    }
    if (((this.KJR instanceof ag)) || ((this.KJR instanceof am)) || ((this.KJR instanceof al)))
    {
      if (!Util.isNullOrNil(this.Ldy.getText().toString()))
      {
        com.tencent.mm.plugin.sns.model.aj.etE().removeCallbacks(this.LdO);
        localObject = Parcel.obtain();
        getIntent().putExtra("Kdescription", this.Ldy.getText().toString());
        getIntent().putExtra("KparseLen", this.Ldy.getPasterLen());
        fXW();
        getIntent().writeToParcel((Parcel)localObject, 0);
        ad(((Parcel)localObject).marshall(), 0);
        com.tencent.mm.plugin.report.service.h.IzE.a(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(7), this.KGq, Long.valueOf(Util.nowSecond()), Integer.valueOf(3) });
      }
      fYa();
      ahw(2);
      if (this.LdL)
      {
        com.tencent.mm.plugin.sns.k.g.Kia.KiK.gWv = 2L;
        com.tencent.mm.plugin.sns.k.g.Kia.fQx();
      }
      fYb();
      fXX();
      AppMethodBeat.o(99598);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, i.j.sns_upload_cancel_tips, 0, i.j.app_alert_exit, i.j.app_cancel, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(176381);
        com.tencent.mm.plugin.sns.model.aj.etE().removeCallbacks(SnsUploadUI.e(SnsUploadUI.this));
        SnsUploadUI.a(SnsUploadUI.this, null, 0);
        SnsUploadUI.j(SnsUploadUI.this);
        SnsUploadUI.b(SnsUploadUI.this, 2);
        SnsUploadUI.l(SnsUploadUI.this);
        if (SnsUploadUI.m(SnsUploadUI.this))
        {
          com.tencent.mm.plugin.sns.k.g.Kia.KiK.gWv = 3L;
          com.tencent.mm.plugin.sns.k.g.Kia.fQx();
        }
        if ((SnsUploadUI.b(SnsUploadUI.this) instanceof v))
        {
          com.tencent.mm.plugin.sns.k.g.Kia.KiO.goQ = 3L;
          com.tencent.mm.plugin.sns.k.g.Kia.fQy();
        }
        if ((bool) && (this.val$appId.equals("wxa5e0de08d96cc09d")))
        {
          com.tencent.mm.plugin.sns.k.g.Kia.KiQ.goQ = 3L;
          com.tencent.mm.plugin.sns.k.g.Kia.fQz();
        }
        SnsUploadUI.o(SnsUploadUI.this);
        AppMethodBeat.o(176381);
      }
    }, null, i.c.alert_btn_color_warn);
    AppMethodBeat.o(99598);
  }
  
  @TargetApi(11)
  private void fXV()
  {
    AppMethodBeat.i(99596);
    if (!(this.KJR instanceof as))
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
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymous2View);
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymous2DragEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
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
                      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
                      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      ((SnsUploadUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
                      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    else if (((ClipData.Item)localObject2).getUri() != null)
                    {
                      localObject1 = new com.tencent.mm.pluginsdk.ui.tools.v(SnsUploadUI.this.getContext(), ((ClipData.Item)localObject2).getUri());
                      if ((((com.tencent.mm.pluginsdk.ui.tools.v)localObject1).fileType != 0) && (((com.tencent.mm.pluginsdk.ui.tools.v)localObject1).filePath != null)) {}
                      switch (((com.tencent.mm.pluginsdk.ui.tools.v)localObject1).fileType)
                      {
                      default: 
                        break;
                      case 3: 
                        paramAnonymous2DragEvent.add(((com.tencent.mm.pluginsdk.ui.tools.v)localObject1).filePath);
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
                ((as)SnsUploadUI.b(SnsUploadUI.this)).c(paramAnonymous2DragEvent, 0, false);
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
  
  private void fXW()
  {
    AppMethodBeat.i(267670);
    getIntent().putExtra("Kis_retry_edit", false);
    AppMethodBeat.o(267670);
  }
  
  private void fXX()
  {
    AppMethodBeat.i(99599);
    if (this.wNV)
    {
      com.tencent.mm.plugin.sns.k.g localg = com.tencent.mm.plugin.sns.k.g.Kia;
      com.tencent.mm.plugin.sns.k.g.a(10, "", 0, 0, cm.bfD(), 0);
    }
    setResult(0, new Intent());
    finish();
    com.tencent.mm.plugin.sns.data.t.fNq();
    AppMethodBeat.o(99599);
  }
  
  private void fYa()
  {
    AppMethodBeat.i(176388);
    if (this.yAT == 9)
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.ViX, this.KGq);
      AppMethodBeat.o(176388);
      return;
    }
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.ViW, this.KGq);
    AppMethodBeat.o(176388);
  }
  
  private void fYb()
  {
    AppMethodBeat.i(176390);
    com.tencent.mm.plugin.expt.b.c localc = (com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.c.class);
    localc.gy("startTime", this.LdR);
    localc.gy("endTime", Util.nowMilliSecond());
    localc.gy("bussinessId", this.KGq);
    localc.gy("shareType", this.yAT);
    localc.gy("hadLocation", this.LdA.getShowFlag());
    localc.gy("desc", this.Ldy.getText().toString());
    localc.gy("nextStep", this.nfn);
    localc.gy("beforeStep", this.LdS);
    localc.gy("ContactTagCount", this.KGN);
    localc.gy("mIsBlackGroup", this.KJV);
    if (this.KJU != null)
    {
      localObject1 = this.KJU.size();
      localc.gy("mContactNameList", (String)localObject1);
      if (!(this.KJR instanceof as)) {
        break label425;
      }
      Object localObject2 = ((as)this.KJR).fUP();
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
    localc.gy("picSource", ((StringBuilder)localObject1).toString());
    label425:
    if ((this.KJR instanceof an)) {
      if (!((an)this.KJR).fTY()) {
        break label469;
      }
    }
    label469:
    for (Object localObject1 = "1";; localObject1 = "2")
    {
      localc.gy("sightSource", (String)localObject1);
      AppMethodBeat.o(176390);
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
  
  public final ArrayList<Exif.a> fTP()
  {
    AppMethodBeat.i(99609);
    if ((this.KJR instanceof as))
    {
      as localas = (as)this.KJR;
      Object localObject1 = localas.KIw.KIH;
      ArrayList localArrayList = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (Exif.a)localas.KIy.get(localObject2);
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
  
  public final boolean fTQ()
  {
    return this.KGr;
  }
  
  public final void fXY()
  {
    AppMethodBeat.i(99600);
    if (this.KJR.fTw())
    {
      enableOptionMenu(true);
      AppMethodBeat.o(99600);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(99600);
  }
  
  public final void fXZ()
  {
    AppMethodBeat.i(99613);
    Log.i("MicroMsg.SnsUploadUI", "resetWidget");
    if (this.LdD != null) {
      this.LdD.setVisibility(8);
    }
    if (this.KJS != null)
    {
      this.KJS.removeAllViews();
      this.KJS.setVisibility(8);
    }
    if (this.KJR != null) {
      this.KJR.fTA();
    }
    ata();
    aB(null);
    AppMethodBeat.o(99613);
  }
  
  public int getLayoutId()
  {
    return i.g.sns_upload_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99605);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.Ldy != null) {
      this.Ldy.clearFocus();
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
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvE, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(getContext(), "android.permission.ACCESS_FINE_LOCATION", 64);
      }
      AppMethodBeat.o(99605);
      return;
    }
    if (this.KJR.k(paramInt1, paramIntent)) {
      fXY();
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
      this.Ldz.aY(paramIntent);
      AppMethodBeat.o(99605);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      boolean bool = paramIntent.getBooleanExtra("bind_facebook_succ", false);
      paramIntent = this.KBH;
      if (bool)
      {
        paramIntent.Ldj = true;
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
      this.LdA.aY(paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99595);
    Log.i("MicroMsg.SnsUploadUI", "onCreate");
    com.tencent.mm.pluginsdk.h.r(this);
    super.onCreate(paramBundle);
    setActionbarColor(getContext().getResources().getColor(i.c.BG_2));
    setNavigationbarColor(getContext().getResources().getColor(i.c.BG_2));
    hideActionbarLine();
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    com.tencent.mm.plugin.sns.model.aj.fOP().db.delete("snsDraft", "key!=? AND key!=? AND timestamp<?", new String[] { "draft_text", "draft_normal", String.valueOf(System.currentTimeMillis() - 86400000L) });
    this.LdL = getIntent().getBooleanExtra("Kis_retry_edit", false);
    Object localObject1;
    Object localObject2;
    label551:
    boolean bool;
    label864:
    int i;
    label983:
    label1000:
    label1396:
    int m;
    int k;
    int j;
    switch (getIntent().getIntExtra("Ksnsupload_type", 0))
    {
    default: 
      if ((!Util.isNullOrNil(this.JZY)) && (!this.LdL))
      {
        localObject1 = com.tencent.mm.plugin.sns.model.aj.fOP().bbm(this.JZY);
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
      ata();
      this.Ldy = ((com.tencent.mm.ui.widget.cedit.api.c)findViewById(i.f.sns_desc_tv));
      this.Ldy.refresh(((PluginWebSearch)com.tencent.mm.kernel.h.ag(PluginWebSearch.class)).isUseSysEditText());
      this.Ldy.getInputExtras(true).putInt("wechat_scene", 3);
      this.Ldy.getInputExtras(true).putBoolean("if_support_wx_emoji", true);
      localObject1 = getBounceView();
      if (localObject1 != null) {
        ((e)localObject1).a(new SnsUploadUI.8(this));
      }
      localObject1 = new SnsUploadUI.9(this);
      this.Ldy.a(((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseBrands(), ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseItems(), LocaleUtil.getCurrentLanguage(getContext()), (a.e)localObject1);
      this.Ldy.addTextChangedListener(new SnsUploadUI.10(this));
      if (!Util.isNullOrNil(getIntent().getStringExtra("Kdescription")))
      {
        this.Ldy.setText(com.tencent.mm.ui.h.c.b.c(getContext(), getIntent().getStringExtra("Kdescription"), this.Ldy.getTextSize()));
        if (this.yAT == 8)
        {
          localObject1 = getIntent().getStringExtra("Kdescription");
          this.Ldy.setText(com.tencent.mm.ui.h.c.b.c(getContext(), (CharSequence)localObject1, this.Ldy.getTextSize()));
        }
        this.Ldy.setPasterLen(getIntent().getIntExtra("KparseLen", 0));
        this.BNW = ((KeyboardLinearLayout)findViewById(i.f.root));
        this.LdC = ((SnsUploadSayFooter)findViewById(i.f.say_footer));
        this.LdC.setMMEditText(this.Ldy);
        this.LdC.setVisibility(4);
        this.LdP = ((FrameLayout)findViewById(i.f.root_fr));
        this.LdP.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(176382);
            DisplayMetrics localDisplayMetrics = new DisplayMetrics();
            SnsUploadUI.this.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
            com.tencent.mm.plugin.sns.model.aj.fOx();
            com.tencent.mm.plugin.sns.storage.r.jR(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
            AppMethodBeat.o(176382);
          }
        });
        localObject1 = new SnsUploadUI.25(this);
        this.Ldy.setOnClickListener((View.OnClickListener)localObject1);
        localObject1 = new SnsUploadUI.26(this);
        this.Ldy.setOnLongClickListener((View.OnLongClickListener)localObject1);
        localObject1 = new boolean[1];
        localObject1[0] = 0;
        this.Ldy.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(176363);
            if (this.LdV[0] != 0)
            {
              this.LdV[0] = false;
              com.tencent.mm.plugin.normsg.a.d.GxJ.aTh("ie_sns_upload");
            }
            com.tencent.mm.plugin.normsg.a.d.GxJ.aTi("ie_sns_upload");
            AppMethodBeat.o(176363);
          }
        });
        localObject2 = (WrapScollview)findViewById(i.f.scroll_view);
        ((WrapScollview)localObject2).setContentView(this.Ldy.hZx());
        ((WrapScollview)localObject2).setDoComputeScrollDeltaToGetChildRectOnScreen(false);
        Object localObject3 = Util.nullAs(getIntent().getStringExtra("reportSessionId"), "");
        this.KBH = ((SnsUploadConfigView)findViewById(i.f.config_view));
        localObject2 = this.KBH;
        if ((this.yAT != 14) || (((String)localObject3).contains("wx5dfbe0a95623607b"))) {
          break label2047;
        }
        bool = true;
        ((SnsUploadConfigView)localObject2).Ldp = bool;
        if (bool)
        {
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(2842, (com.tencent.mm.an.i)localObject2);
          localObject3 = new com.tencent.mm.plugin.sns.model.j();
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)localObject3, 0);
        }
        ((SnsUploadConfigView)localObject2).KGJ.ScP = -1000.0F;
        ((SnsUploadConfigView)localObject2).KGJ.ScO = -1000.0F;
        if (!((SnsUploadConfigView)localObject2).ABX)
        {
          com.tencent.mm.kernel.h.aHH();
          i = Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(68404, null));
          if ((i & 0x2) == 0) {
            break label2053;
          }
          bool = true;
          ((SnsUploadConfigView)localObject2).Ldj = bool;
          if ((i & 0x8) == 0) {
            break label2059;
          }
          bool = true;
          ((SnsUploadConfigView)localObject2).Ldk = bool;
          if (!com.tencent.mm.az.b.isOverseasUser()) {
            ((SnsUploadConfigView)localObject2).Ldk = false;
          }
          if (!z.bdE()) {
            ((SnsUploadConfigView)localObject2).Ldj = false;
          }
        }
        ((SnsUploadConfigView)localObject2).setSyncFacebook(false);
        ((SnsUploadConfigView)localObject2).fXR();
        ((SnsUploadConfigView)localObject2).fXT();
        ((SnsUploadConfigView)localObject2).fXS();
        if (((SnsUploadConfigView)localObject2).Ldk) {
          ((SnsUploadConfigView)localObject2).Ldq.a((com.tencent.mm.ui.q.a.a)localObject2);
        }
        if (this.yAT != 0)
        {
          localObject2 = this.KBH;
          ((SnsUploadConfigView)localObject2).Lde.setVisibility(8);
          ((SnsUploadConfigView)localObject2).Ldf.setVisibility(8);
          ((SnsUploadConfigView)localObject2).Ldg.setVisibility(8);
          ((SnsUploadConfigView)localObject2).Ldh.setVisibility(8);
        }
        if (this.yAT == 9) {
          this.KBH.Ldg.setVisibility(0);
        }
        setBackBtn(new SnsUploadUI.3(this));
        addTextOptionMenu(0, getString(i.j.sns_send), new MenuItem.OnMenuItemClickListener()
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
            if ((SnsUploadUI.b(SnsUploadUI.this) != null) && (!SnsUploadUI.b(SnsUploadUI.this).fTy()))
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
            com.tencent.mm.plugin.sns.model.aj.etE().removeCallbacks(SnsUploadUI.e(SnsUploadUI.this));
            paramAnonymousMenuItem = Parcel.obtain();
            SnsUploadUI.this.getIntent().putExtra("Kdescription", SnsUploadUI.a(SnsUploadUI.this).getText().toString());
            SnsUploadUI.this.getIntent().putExtra("KparseLen", SnsUploadUI.a(SnsUploadUI.this).getPasterLen());
            SnsUploadUI.c(SnsUploadUI.this);
            SnsUploadUI.this.getIntent().writeToParcel(paramAnonymousMenuItem, 0);
            paramAnonymousMenuItem = paramAnonymousMenuItem.marshall();
            SnsUploadUI.a(SnsUploadUI.this, paramAnonymousMenuItem, 2);
            SnsUploadUI.j(SnsUploadUI.this);
            if (this.nez[0] != 0) {
              this.nez[0] = false;
            }
            for (;;)
            {
              SnsUploadUI.a(SnsUploadUI.this, System.currentTimeMillis());
              com.tencent.mm.plugin.report.service.g.ada(22);
              com.tencent.mm.ui.widget.cedit.api.d.a(SnsUploadUI.a(SnsUploadUI.this)).axx(com.tencent.mm.n.c.awC()).Hh(true).a(new c.a()
              {
                public final void abc(String paramAnonymous2String)
                {
                  AppMethodBeat.i(176364);
                  Log.i("MicroMsg.SnsUploadUI", "commit after check");
                  SnsUploadUI.a(SnsUploadUI.this, 3);
                  SnsUploadUI.t(SnsUploadUI.this);
                  int i = SnsUploadUI.u(SnsUploadUI.this).getSyncFlag();
                  com.tencent.mm.kernel.h.aHH();
                  com.tencent.mm.kernel.h.aHG().aHp().i(68404, Integer.valueOf(i));
                  SnsUploadUI.b(SnsUploadUI.this, SnsUploadUI.a(SnsUploadUI.this).getText().toString());
                  i = SnsUploadUI.a(SnsUploadUI.this).getPasterLen();
                  int j = SnsUploadUI.u(SnsUploadUI.this).getPrivated();
                  int k = SnsUploadUI.u(SnsUploadUI.this).getSyncFlag();
                  SnsUploadUI.v(SnsUploadUI.this);
                  if (SnsUploadUI.w(SnsUploadUI.this)) {
                    SnsUploadUI.this.setResult(-1, new Intent());
                  }
                  if ((SnsUploadUI.b(SnsUploadUI.this) instanceof as)) {
                    ((as)SnsUploadUI.b(SnsUploadUI.this)).KIC = SnsUploadUI.x(SnsUploadUI.this).getCurLocation();
                  }
                  if ((SnsUploadUI.b(SnsUploadUI.this) instanceof ao)) {
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
                      paramAnonymous2String.value = ((a)SnsUploadUI.b(SnsUploadUI.this)).fPM();
                      SnsUploadUI.b(SnsUploadUI.this);
                      SnsUploadUI.G(SnsUploadUI.this);
                      localObject = com.tencent.mm.plugin.report.service.h.IzE;
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
                      com.tencent.mm.plugin.report.service.h.IzE.kvStat(10910, "1");
                      if (!Util.isNullOrNil(SnsUploadUI.J(SnsUploadUI.this)))
                      {
                        if (!SnsUploadUI.B(SnsUploadUI.this)) {
                          break label1127;
                        }
                        com.tencent.mm.plugin.report.service.h.IzE.a(11455, new Object[] { "", SnsUploadUI.J(SnsUploadUI.this), Integer.valueOf(-1), Integer.valueOf(-1) });
                      }
                      if (SnsUploadUI.K(SnsUploadUI.this))
                      {
                        localObject = new Intent(SnsUploadUI.this, SnsTimeLineUI.class);
                        ((Intent)localObject).putExtra("sns_resume_state", false);
                        ((Intent)localObject).putExtra("sns_timeline_NeedFirstLoadint", true);
                        ((Intent)localObject).addFlags(67108864);
                        paramAnonymous2String = SnsUploadUI.this;
                        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2String, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/sns/ui/SnsUploadUI$12$1", "doWhenOK", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymous2String.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2String, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$12$1", "doWhenOK", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      }
                      s.br(SnsUploadUI.this.getIntent());
                      paramAnonymous2String = new xs();
                      EventCenter.instance.publish(paramAnonymous2String);
                      SnsUploadUI.b(SnsUploadUI.this, 1);
                      SnsUploadUI.l(SnsUploadUI.this);
                      if (!SnsUploadUI.m(SnsUploadUI.this)) {
                        break label1175;
                      }
                      com.tencent.mm.plugin.sns.k.g.Kia.KiK.gWv = 1L;
                      com.tencent.mm.plugin.sns.data.t.fNq();
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
                    com.tencent.mm.plugin.report.service.h.IzE.a(11455, new Object[] { SnsUploadUI.J(SnsUploadUI.this), "", Integer.valueOf(-1), Integer.valueOf(-1) });
                    continue;
                    label1175:
                    com.tencent.mm.plugin.sns.k.g.Kia.KiK.Dy(SnsUploadUI.k(SnsUploadUI.this));
                    com.tencent.mm.plugin.sns.k.g.Kia.KiJ.Dy(SnsUploadUI.k(SnsUploadUI.this));
                  }
                }
                
                public final void abd(String paramAnonymous2String) {}
                
                public final void dN(String paramAnonymous2String)
                {
                  AppMethodBeat.i(176365);
                  com.tencent.mm.ui.base.h.p(SnsUploadUI.this, i.j.sns_upload_post_text_invalid_more, i.j.sns_upload_post_text_invalid_title);
                  AppMethodBeat.o(176365);
                }
              });
              AppMethodBeat.o(176366);
              return false;
              com.tencent.mm.plugin.normsg.a.d.GxJ.jr("ce_sns_upload", "<SnsUpload>");
              paramAnonymousMenuItem = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.d.GxJ.a("ce_sns_upload", paramAnonymousMenuItem);
              com.tencent.mm.plugin.normsg.a.d.GxJ.aTm("ce_sns_upload");
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
              this.nez[0] = true;
              com.tencent.mm.plugin.normsg.a.d.GxJ.jr("ce_sns_upload", "<SnsUpload>");
              continue;
              com.tencent.mm.plugin.normsg.a.d.GxJ.a("ce_sns_upload", paramAnonymousMotionEvent);
              com.tencent.mm.plugin.normsg.a.d.GxJ.aTm("ce_sns_upload");
            }
          }
        }, w.b.Wao);
        findViewById(i.f.upload_content).setOnTouchListener(new SnsUploadUI.6(this));
        this.Ldz = ((AtContactWidget)findViewById(i.f.at_contact_widget));
        this.Ldz.KBH = this.KBH;
        this.LdA = ((LocationWidget)findViewById(i.f.location_widget));
        this.LdA.setLocationWidgetListener(this);
        switch (this.yAT)
        {
        case 26: 
        default: 
          this.LdB.KBH = this.KBH;
          this.LdB.setRangeTipClickListener(new SnsUploadUI.7(this));
          this.LdA.aY(getIntent());
          this.Ldz.aY(getIntent());
          com.tencent.mm.plugin.sns.k.g.Kia.agg(0);
          com.tencent.mm.plugin.sns.k.g.Kia.Kik.gVu = 2;
          bb(getIntent());
          hideVKB();
          aB(paramBundle);
          paramBundle = com.tencent.mm.plugin.sns.model.aj.fOP().bbm(this.JZY);
          if ((paramBundle != null) && ((paramBundle.field_extFlag & 0x1) == 1))
          {
            m = 0;
            k = 2;
            i = m;
            j = k;
            switch (this.yAT)
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
      com.tencent.mm.plugin.report.service.h.IzE.a(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(i), this.KGq, Long.valueOf(Util.nowSecond()), Integer.valueOf(j) });
      com.tencent.mm.pluginsdk.h.s(this);
      paramBundle = Parcel.obtain();
      getIntent().writeToParcel(paramBundle, 0);
      this.LdM = MD5Util.getMD5String(paramBundle.marshall());
      this.LdN = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vNf, 3000L);
      this.LdR = Util.nowMilliSecond();
      this.LdH = false;
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
      this.JZY = ((String)localObject1);
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
        this.JZY = com.tencent.mm.plugin.sns.data.t.aZw((String)localObject2);
      }
      if (getIntent().getBooleanExtra("ksnsis_appbrand", false)) {
        this.JZY = null;
      }
      if (!getIntent().getBooleanExtra("KSnsIsUploadAdLandingPage", false)) {
        break;
      }
      this.JZY = null;
      break;
      this.JZY = Util.nullAs(getIntent().getStringExtra("Ksnsupload_musicid"), "");
      break;
      if ((this.Ldy == null) || (paramBundle == null)) {
        break label551;
      }
      localObject1 = paramBundle.getString("contentdesc");
      if (localObject1 == null) {
        break label551;
      }
      this.Ldy.setText((CharSequence)localObject1);
      break label551;
      label2047:
      bool = false;
      break label864;
      label2053:
      bool = false;
      break label983;
      label2059:
      bool = false;
      break label1000;
      this.LdB = ((RangeWidget)findViewById(i.f.rang_widget_bottom));
      findViewById(i.f.rang_widget_top).setVisibility(8);
      break label1396;
      this.LdB = ((RangeWidget)findViewById(i.f.rang_widget_bottom));
      findViewById(i.f.rang_widget_top).setVisibility(8);
      break label1396;
      this.LdB = ((RangeWidget)findViewById(i.f.rang_widget_bottom));
      findViewById(i.f.rang_widget_top).setVisibility(8);
      break label1396;
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
    if (this.KBH != null)
    {
      localObject = this.KBH;
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(2842, (com.tencent.mm.an.i)localObject);
    }
    if (this.KJR != null) {
      this.KJR.fTA();
    }
    if (this.LdA != null) {
      this.LdA.stop();
    }
    if (this.LdC != null)
    {
      localObject = this.LdC;
      if (((SnsUploadSayFooter)localObject).jPN != null)
      {
        ((SnsUploadSayFooter)localObject).jPN.hjm();
        ((SnsUploadSayFooter)localObject).jPN.destroy();
      }
    }
    this.LdI.clear();
    com.tencent.mm.plugin.normsg.a.d.GxJ.aTj("ie_sns_upload");
    com.tencent.mm.plugin.sns.data.t.fNq();
    EventCenter.instance.removeListener(this.LdT);
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
    localObject = (com.tencent.mm.plugin.sns.j.j)com.tencent.mm.plugin.secdata.ui.a.a.c(this, 2, com.tencent.mm.plugin.sns.j.j.class);
    if ((localObject == null) || (((com.tencent.mm.plugin.sns.j.j)localObject).fWh <= 0)) {}
    for (;;)
    {
      this.Ldy.destroy();
      AppMethodBeat.o(99604);
      return;
      ((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.secdata.g.class)).updateWithSave(2, "SnsPostEnd_" + ((com.tencent.mm.plugin.sns.j.j)localObject).fWh, (com.tencent.mm.cd.a)localObject, new com.tencent.mm.plugin.secdata.i() {});
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99597);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      paramKeyEvent = this.LdC;
      if ((paramKeyEvent.fXU()) || (paramKeyEvent.getVisibility() == 0)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        this.LdC.aDK();
        AppMethodBeat.o(99597);
        return true;
      }
      dEl();
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
    this.Ldy.onPause();
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
        this.LdA.fTM();
        AppMethodBeat.o(99610);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(i.j.permission_location_request_again_msg), getString(i.j.permission_tips_title), getString(i.j.jump_to_settings), getString(i.j.app_cancel), false, new SnsUploadUI.15(this), new SnsUploadUI.16(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99603);
    super.onResume();
    this.LdC.post(new SnsUploadUI.11(this));
    an localan;
    if ((this.KJR != null) && ((this.KJR instanceof an)))
    {
      localan = (an)this.KJR;
      if (localan.KGl != null)
      {
        if (localan.KGs) {
          break label97;
        }
        localan.fTW();
      }
    }
    for (;;)
    {
      this.Ldy.refresh(((PluginWebSearch)com.tencent.mm.kernel.h.ag(PluginWebSearch.class)).isUseSysEditText());
      AppMethodBeat.o(99603);
      return;
      label97:
      localan.fTX();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(99594);
    if (paramBundle != null)
    {
      if (this.Ldy != null) {
        paramBundle.putString("contentdesc", this.Ldy.getText().toString());
      }
      this.KJR.az(paramBundle);
    }
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(99594);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(176385);
    super.onStart();
    com.tencent.mm.plugin.sns.model.aj.etE().postDelayed(this.LdO, this.LdN);
    AppMethodBeat.o(176385);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(176387);
    super.onStop();
    com.tencent.mm.plugin.sns.model.aj.etE().removeCallbacks(this.LdO);
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