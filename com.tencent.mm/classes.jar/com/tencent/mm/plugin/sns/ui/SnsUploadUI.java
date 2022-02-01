package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.mm;
import com.tencent.mm.autogen.mmdata.rpt.SnsPublishProcessStruct;
import com.tencent.mm.autogen.mmdata.rpt.pv;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.comm.b.e;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.secdata.g;
import com.tencent.mm.plugin.secdata.i;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.statistics.h.a;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.plugin.sns.ui.widget.Tiger2022Helper;
import com.tencent.mm.plugin.sns.ui.widget.Tiger2022Helper.a;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.widget.edittext.a.e;
import com.tencent.mm.ui.y.b;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.ai;

@com.tencent.mm.kernel.k
@com.tencent.mm.ui.base.a(17)
public class SnsUploadUI
  extends MMSecDataActivity
  implements LocationWidget.a
{
  private boolean Akx;
  private int DnR;
  private KeyboardLinearLayout HxM;
  private String Qxh;
  private com.tencent.mm.ui.widget.cedit.api.c RDH;
  private AtContactWidget RDI;
  private LocationWidget RDJ;
  private RangeWidget RDK;
  private SnsUploadSayFooter RDL;
  private DynamicGridView RDM;
  private String RDN;
  private boolean RDO;
  private boolean RDP;
  boolean RDQ;
  private Map<Integer, ag> RDR;
  private ConcurrentHashMap<String, List<String>> RDS;
  private Map<String, List<String>> RDT;
  private boolean RDU;
  private String RDV;
  private long RDW;
  private Runnable RDX;
  private FrameLayout RDY;
  private long RDZ;
  private long REa;
  private int REb;
  private IListener<mm> REc;
  private SnsUploadConfigView Rbp;
  private String RfQ;
  private boolean RfR;
  private int Rgo;
  private int Rgp;
  private String RiR;
  private String RiS;
  private String RiT;
  private ag Rjt;
  private LinearLayout Rju;
  private ArrayList<String> Rjw;
  private boolean Rjx;
  private boolean Rjy;
  private long Rjz;
  private boolean akiR;
  private String canvasInfo;
  private String desc;
  private String mSessionId;
  private int qcv;
  
  public SnsUploadUI()
  {
    AppMethodBeat.i(99593);
    this.RfR = false;
    this.DnR = 0;
    this.Rjy = false;
    this.Rjz = 0L;
    this.Rjt = null;
    this.RiR = "";
    this.RDN = "";
    this.RiS = "";
    this.RiT = "";
    this.Rgo = 0;
    this.Rgp = 0;
    this.Rjx = false;
    this.RDO = false;
    this.RDP = false;
    this.RDQ = false;
    this.canvasInfo = null;
    this.RfQ = "";
    this.Akx = false;
    this.RDR = new HashMap();
    this.RDS = new ConcurrentHashMap();
    this.RDT = new HashMap();
    this.RDU = false;
    this.akiR = false;
    this.Qxh = "";
    this.RDV = "";
    this.RDW = 3000L;
    this.RDX = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176362);
        if ((SnsUploadUI.a(SnsUploadUI.this) != null) && (SnsUploadUI.b(SnsUploadUI.this) != null) && (SnsUploadUI.b(SnsUploadUI.this).hlS()))
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
          al.fAG().postDelayed(SnsUploadUI.e(SnsUploadUI.this), SnsUploadUI.f(SnsUploadUI.this));
        }
        AppMethodBeat.o(176362);
      }
    };
    this.RDY = null;
    this.RDZ = 0L;
    this.REa = 0L;
    this.qcv = 0;
    this.REb = 0;
    this.REc = new SnsUploadUI.28(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(99593);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    AppMethodBeat.i(308140);
    com.tencent.mm.plugin.websearch.b.b.a(1, 1, z.bAM(), paramString2, 1, "", paramString3, paramInt, paramString1, paramLong);
    AppMethodBeat.o(308140);
  }
  
  private void aNi()
  {
    int i = 1;
    AppMethodBeat.i(99601);
    this.Rjy = getIntent().getBooleanExtra("KSnsPostManu", false);
    this.Rjz = getIntent().getLongExtra("KTouchCameraTime", 0L);
    this.DnR = getIntent().getIntExtra("Ksnsupload_type", 0);
    Log.i("MicroMsg.SnsUploadUI", "initData shareType:%s", new Object[] { Integer.valueOf(this.DnR) });
    this.RfR = getIntent().getBooleanExtra("Kis_take_photo", false);
    if (this.RfR) {
      i = 2;
    }
    this.REb = i;
    this.RDO = getIntent().getBooleanExtra("need_result", false);
    this.RDP = getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false);
    this.canvasInfo = getIntent().getStringExtra("Ksnsupload_canvas_info");
    this.RfQ = getIntent().getStringExtra("KSessionID");
    this.Akx = getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
    if (Util.isNullOrNil(this.RfQ))
    {
      this.RfQ = com.tencent.mm.plugin.sns.data.t.heR();
      getIntent().putExtra("KSessionID", this.RfQ);
    }
    for (;;)
    {
      this.mSessionId = com.tencent.mm.plugin.fts.a.d.We(79);
      Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject = (com.tencent.mm.plugin.sns.k.j)com.tencent.mm.plugin.secdata.ui.a.a.c(this, 2, com.tencent.mm.plugin.sns.k.j.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.sns.k.j)localObject).sessionId = this.mSessionId;
      }
      AppMethodBeat.o(99601);
      return;
      this.REb = 3;
    }
  }
  
  private void ae(final byte[] paramArrayOfByte, final int paramInt)
  {
    AppMethodBeat.i(308128);
    al.gHI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176380);
        long l = System.currentTimeMillis();
        al.hgJ().b(SnsUploadUI.h(SnsUploadUI.this), paramArrayOfByte, paramInt);
        Log.i("MicroMsg.SnsUploadUI", "saveDraft draftKey:%s, %s", new Object[] { SnsUploadUI.h(SnsUploadUI.this), Long.valueOf(Util.milliSecondsToNow(l)) });
        AppMethodBeat.o(176380);
      }
    });
    AppMethodBeat.o(308128);
  }
  
  private ag amp(int paramInt)
  {
    AppMethodBeat.i(99614);
    Object localObject = (ag)this.RDR.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      if (paramInt == 0)
      {
        at localat = new at(this);
        localObject = localat;
        if (this.akiR)
        {
          ((at)localat).lyL = 1;
          localObject = localat;
        }
        this.RDR.put(Integer.valueOf(paramInt), localObject);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(99614);
      return localObject;
      if (paramInt == 14)
      {
        localObject = new ao(this);
        break;
      }
      if (paramInt == 28)
      {
        localObject = new w(this);
        break;
      }
      break;
    }
  }
  
  private void amq(int paramInt)
  {
    AppMethodBeat.i(176389);
    com.tencent.mm.plugin.sns.statistics.j.QFS.QGd.xc(this.RfQ);
    com.tencent.mm.plugin.sns.statistics.j.QFS.QGd.jpg = paramInt;
    if ((paramInt == 3) || (paramInt == 2)) {
      com.tencent.mm.plugin.sns.statistics.j.QFS.hin();
    }
    AppMethodBeat.o(176389);
  }
  
  private void bB(Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(99606);
    this.RDK.a(5, -1, paramIntent, this.RDI);
    Object localObject1 = this.RDI;
    boolean bool;
    int i;
    if (this.RDK.getLabelRange() == 0)
    {
      bool = true;
      ((AtContactWidget)localObject1).DY(bool);
      i = paramIntent.getIntExtra("Ktag_range_index", 0);
      if (i < 2) {
        break label369;
      }
      this.RiR = paramIntent.getStringExtra("Klabel_name_list");
      this.RDN = paramIntent.getStringExtra("KNew_label_name_list");
      this.RiS = paramIntent.getStringExtra("Kother_user_name_list");
      this.RiT = paramIntent.getStringExtra("Kchat_room_name_list");
      if (Util.isNullOrNil(this.RiR)) {
        break label395;
      }
    }
    label395:
    for (List localList = Arrays.asList(this.RiR.split(","));; localList = null)
    {
      if (!Util.isNullOrNil(this.RiS))
      {
        localObject1 = Arrays.asList(this.RiS.split(","));
        com.tencent.mm.plugin.sns.statistics.j.QFS.kD((List)localObject1);
      }
      for (;;)
      {
        paramIntent = (Intent)localObject1;
        if (!Util.isNullOrNil(this.RDN))
        {
          if (localObject1 == null) {
            paramIntent = Arrays.asList(this.RDN.split(","));
          }
        }
        else
        {
          label193:
          localObject1 = localObject2;
          if (!Util.isNullOrNil(this.RiT)) {
            localObject1 = Arrays.asList(this.RiT.split(","));
          }
          al.gHI().post(new SnsUploadUI.15(this, localList, paramIntent, (List)localObject1));
          if (i != 2) {
            break label361;
          }
          this.Rjx = false;
          label251:
          if ((this.RDS != null) && (!this.RDS.isEmpty())) {
            com.tencent.mm.plugin.sns.statistics.j.QFS.ba(this.RDS);
          }
          if ((this.RDT != null) && (!this.RDT.isEmpty())) {
            com.tencent.mm.plugin.sns.statistics.j.QFS.aZ(this.RDT);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.statistics.j.QFS.akX(i);
          AppMethodBeat.o(99606);
          return;
          bool = false;
          break;
          paramIntent = new ArrayList();
          paramIntent.addAll((Collection)localObject1);
          paramIntent.addAll(Arrays.asList(this.RDN.split(",")));
          break label193;
          label361:
          this.Rjx = true;
          break label251;
          label369:
          if (!Util.isNullOrNil(this.Rjw)) {
            this.Rjw.clear();
          }
        }
        localObject1 = null;
      }
    }
  }
  
  private void bc(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(99615);
    Log.i("MicroMsg.SnsUploadUI", "attachWidget. share type %d, isManuSnsPost:%b", new Object[] { Integer.valueOf(this.DnR), Boolean.valueOf(this.Rjy) });
    Object localObject;
    if ((this.DnR == 0) || (this.DnR == 14) || (this.DnR == 9))
    {
      localObject = Parcel.obtain();
      getIntent().writeToParcel((Parcel)localObject, 0);
      ((Parcel)localObject).marshall();
      if (this.DnR != 9) {
        break label520;
      }
      setMMTitle(getContext().getResources().getString(b.j.sns_text_title));
    }
    RelativeLayout.LayoutParams localLayoutParams;
    label520:
    int i;
    switch (this.DnR)
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
        this.Rjt.aZ(paramBundle);
        if ((!(this.Rjt instanceof at)) || ((this.Rjt instanceof w))) {
          break label998;
        }
        paramBundle = findViewById(b.f.sns_desc_container_frame);
        localObject = findViewById(b.f.sns_img_tips);
        this.RDM = ((DynamicGridView)findViewById(b.f.sns_preview_img_dynamicgrid));
        this.RDM.setOnTouchListener(new SnsUploadUI.27(this));
        paramBundle = ((at)this.Rjt).a(paramBundle, findViewById(b.f.del_area), this.RDM, (View)localObject);
        this.RDM.setVisibility(0);
        localObject = findViewById(b.f.widget_line);
        localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        localLayoutParams.topMargin = 0;
        localLayoutParams.addRule(3, b.f.sns_preview_img_dynamicgrid);
        ((View)localObject).setLayoutParams(localLayoutParams);
        if (((this.Rjt instanceof ah)) || ((this.Rjt instanceof aj)))
        {
          localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).width = -1;
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if (((this.Rjt instanceof q)) || ((this.Rjt instanceof o)) || ((this.Rjt instanceof p)))
        {
          localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).width = -1;
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        hqt();
        if (this.DnR == 0) {
          hqq();
        }
        AppMethodBeat.o(99615);
        return;
        setMMTitle("");
        break;
        this.Qxh = "draft_normal";
        this.Rjt = amp(this.DnR);
        this.RDH.addTextChangedListener(new SnsUploadUI.18(this));
        continue;
        this.Qxh = "draft_normal";
        this.Rjt = amp(this.DnR);
        continue;
        this.Rjt = new ah(this);
        continue;
        this.Rjt = new an(this);
        continue;
        this.Rjt = new am(this);
        continue;
        this.Rjt = new au(this, 9);
        continue;
        this.Rjt = new au(this, 12);
        continue;
        this.Rjt = new q(this);
        continue;
        this.Rjt = new o(this);
        continue;
        this.Rjt = new r(this);
        continue;
        this.Rjt = new p(this);
        continue;
        this.Rjt = new au(this, 14);
        continue;
        this.Rjt = new au(this, 13);
      }
    case 9: 
      this.Qxh = "draft_text";
      localObject = Util.nullAs(getIntent().getStringExtra("Kdescription"), "");
      i = Util.nullAs(Integer.valueOf(getIntent().getIntExtra("KparseLen", 0)), 0);
      if ((localObject == null) || (Util.isNullOrNil(((String)localObject).trim()))) {
        break;
      }
    }
    for (;;)
    {
      this.Rjt = new ap(this, bool);
      this.RDH.setPasterLen(i);
      this.RDH.setText(com.tencent.mm.ui.i.c.b.c(getContext(), (CharSequence)localObject, this.RDH.getTextSize()));
      this.RDH.addTextChangedListener(new SnsUploadUI.19(this));
      break;
      this.Rjt = new bt(this);
      break;
      this.Rjt = new aj(this);
      break;
      this.Rjt = new v(this);
      break;
      this.Rjt = new ak(this);
      break;
      this.Rjt = new x(this);
      break;
      this.Rjt = new u(this);
      break;
      this.Rjt = new t(this);
      break;
      label998:
      paramBundle = this.Rjt.hlQ();
      this.Rju = ((LinearLayout)findViewById(b.f.widget_content));
      this.Rju.setVisibility(0);
      this.Rju.setClipChildren(false);
      label1059:
      float f;
      if (paramBundle != null)
      {
        Log.d("MicroMsg.SnsUploadUI", "will add widget view in widgetLL.");
        this.Rju.addView(paramBundle);
        if ((this.DnR == 9) || (this.DnR == 14))
        {
          localObject = findViewById(b.f.widget_line);
          localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
          localLayoutParams.addRule(3, b.f.widget_content);
          f = BitmapUtil.getDefaultDisplayMetrics().density;
          if (this.DnR != 9) {
            break label1157;
          }
        }
      }
      label1157:
      for (i = 128;; i = 96)
      {
        localLayoutParams.topMargin = ((int)(i * f));
        ((View)localObject).setLayoutParams(localLayoutParams);
        break;
        this.Rju.setVisibility(8);
        break label1059;
      }
      bool = false;
    }
  }
  
  private void eHy()
  {
    AppMethodBeat.i(99598);
    final boolean bool = getIntent().getBooleanExtra("KThrid_app", false);
    Object localObject = Util.nullAs(getIntent().getStringExtra("Ksnsupload_appid"), "");
    if (((this.DnR == 0) && ((((at)this.Rjt).hnd() > 0) || (!Util.isNullOrNil(this.RDH.getText().toString())))) || ((this.DnR == 14) && ((this.Rjt instanceof ao)) && ((!((ao)this.Rjt).RfS) || (!Util.isNullOrNil(this.RDH.getText().toString())))) || ((this.DnR == 9) && (!Util.isNullOrNil(this.RDH.getText().toString()))) || (((this.Rjt instanceof v)) && (!((v)this.Rjt).hlV())))
    {
      com.tencent.mm.ui.base.k.a(this, b.j.sns_upload_exit_and_save_tips, 0, b.j.sns_upload_exit_save, b.j.sns_upload_exit_not_save, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            com.tencent.mm.plugin.report.service.h.OAn.b(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(paramAnonymousInt), SnsUploadUI.k(SnsUploadUI.this), Long.valueOf(Util.nowSecond()), Integer.valueOf(1) });
            SnsUploadUI.b(SnsUploadUI.this, 3);
            SnsUploadUI.l(SnsUploadUI.this);
            if (SnsUploadUI.m(SnsUploadUI.this))
            {
              com.tencent.mm.plugin.sns.statistics.j.QFS.QGE.jpR = 2L;
              com.tencent.mm.plugin.sns.statistics.j.QFS.hiv();
            }
            if ((SnsUploadUI.b(SnsUploadUI.this) instanceof v))
            {
              com.tencent.mm.plugin.sns.statistics.j.QFS.QGI.iyr = 3L;
              com.tencent.mm.plugin.sns.statistics.j.QFS.hiw();
            }
            if ((bool) && (this.etl.equals("wxa5e0de08d96cc09d")))
            {
              com.tencent.mm.plugin.sns.statistics.j.QFS.QGK.iyr = 3L;
              com.tencent.mm.plugin.sns.statistics.j.QFS.hix();
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
          al.fAG().removeCallbacks(SnsUploadUI.e(SnsUploadUI.this));
          SnsUploadUI.a(SnsUploadUI.this, null, 0);
          SnsUploadUI.j(SnsUploadUI.this);
          paramAnonymousDialogInterface = SnsUploadUI.this.getIntent().getStringExtra("KSightThumbPath");
          Object localObject = SnsUploadUI.this.getIntent().getStringExtra("KSightPath");
          if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVQ, true))
          {
            com.tencent.mm.plugin.recordvideo.util.f localf = com.tencent.mm.plugin.recordvideo.util.f.Obq;
            com.tencent.mm.plugin.recordvideo.util.f.aTt((String)localObject);
            localObject = com.tencent.mm.plugin.recordvideo.util.f.Obq;
            com.tencent.mm.plugin.recordvideo.util.f.aTt(paramAnonymousDialogInterface);
          }
          if ((SnsUploadUI.b(SnsUploadUI.this) instanceof ap)) {
            SnsUploadUI.a(SnsUploadUI.this).setText("");
          }
          switch (SnsUploadUI.i(SnsUploadUI.this))
          {
          default: 
            paramAnonymousInt = 0;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(paramAnonymousInt), SnsUploadUI.k(SnsUploadUI.this), Long.valueOf(Util.nowSecond()), Integer.valueOf(0) });
            SnsUploadUI.b(SnsUploadUI.this, 2);
            SnsUploadUI.l(SnsUploadUI.this);
            if (SnsUploadUI.m(SnsUploadUI.this))
            {
              com.tencent.mm.plugin.sns.statistics.j.QFS.QGE.jpR = 3L;
              com.tencent.mm.plugin.sns.statistics.j.QFS.hiv();
            }
            if ((SnsUploadUI.b(SnsUploadUI.this) instanceof v))
            {
              com.tencent.mm.plugin.sns.statistics.j.QFS.QGI.iyr = 3L;
              com.tencent.mm.plugin.sns.statistics.j.QFS.hiw();
            }
            if ((bool) && (this.etl.equals("wxa5e0de08d96cc09d")))
            {
              com.tencent.mm.plugin.sns.statistics.j.QFS.QGK.iyr = 3L;
              com.tencent.mm.plugin.sns.statistics.j.QFS.hix();
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
      }, b.c.alert_btn_color_no);
      AppMethodBeat.o(99598);
      return;
    }
    if (((this.Rjt instanceof ah)) || ((this.Rjt instanceof an)) || ((this.Rjt instanceof am)))
    {
      if (!Util.isNullOrNil(this.RDH.getText().toString()))
      {
        al.fAG().removeCallbacks(this.RDX);
        localObject = Parcel.obtain();
        getIntent().putExtra("Kdescription", this.RDH.getText().toString());
        getIntent().putExtra("KparseLen", this.RDH.getPasterLen());
        hqr();
        getIntent().writeToParcel((Parcel)localObject, 0);
        ae(((Parcel)localObject).marshall(), 0);
        com.tencent.mm.plugin.report.service.h.OAn.b(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(7), this.RfQ, Long.valueOf(Util.nowSecond()), Integer.valueOf(3) });
      }
      hqv();
      amq(2);
      if (this.RDU)
      {
        com.tencent.mm.plugin.sns.statistics.j.QFS.QGE.jpR = 2L;
        com.tencent.mm.plugin.sns.statistics.j.QFS.hiv();
      }
      hqw();
      hqs();
      AppMethodBeat.o(99598);
      return;
    }
    com.tencent.mm.ui.base.k.a(this, b.j.sns_upload_cancel_tips, 0, b.j.app_alert_exit, b.j.app_cancel, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(176381);
        SnsUploadUI.a(SnsUploadUI.this, 4);
        al.fAG().removeCallbacks(SnsUploadUI.e(SnsUploadUI.this));
        SnsUploadUI.a(SnsUploadUI.this, null, 0);
        SnsUploadUI.j(SnsUploadUI.this);
        SnsUploadUI.b(SnsUploadUI.this, 2);
        SnsUploadUI.l(SnsUploadUI.this);
        if (SnsUploadUI.m(SnsUploadUI.this))
        {
          com.tencent.mm.plugin.sns.statistics.j.QFS.QGE.jpR = 3L;
          com.tencent.mm.plugin.sns.statistics.j.QFS.hiv();
        }
        if ((SnsUploadUI.b(SnsUploadUI.this) instanceof v))
        {
          com.tencent.mm.plugin.sns.statistics.j.QFS.QGI.iyr = 3L;
          com.tencent.mm.plugin.sns.statistics.j.QFS.hiw();
        }
        if ((bool) && (this.etl.equals("wxa5e0de08d96cc09d")))
        {
          com.tencent.mm.plugin.sns.statistics.j.QFS.QGK.iyr = 3L;
          com.tencent.mm.plugin.sns.statistics.j.QFS.hix();
        }
        SnsUploadUI.o(SnsUploadUI.this);
        AppMethodBeat.o(176381);
      }
    }, null, b.c.alert_btn_color_warn);
    AppMethodBeat.o(99598);
  }
  
  private void hqq()
  {
    AppMethodBeat.i(99596);
    if (!(this.Rjt instanceof at))
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
    new SnsUploadUI.12(this).run();
    AppMethodBeat.o(99596);
  }
  
  private void hqr()
  {
    AppMethodBeat.i(308124);
    getIntent().putExtra("Kis_retry_edit", false);
    AppMethodBeat.o(308124);
  }
  
  private void hqs()
  {
    AppMethodBeat.i(99599);
    if (this.Akx)
    {
      com.tencent.mm.plugin.sns.statistics.j localj = com.tencent.mm.plugin.sns.statistics.j.QFS;
      com.tencent.mm.plugin.sns.statistics.j.a(10, "", 0, 0, cn.bDv(), 0);
    }
    setResult(0, new Intent());
    finish();
    com.tencent.mm.plugin.sns.data.t.heS();
    AppMethodBeat.o(99599);
  }
  
  private void hqv()
  {
    AppMethodBeat.i(176388);
    if (this.DnR == 9)
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acKr, this.RfQ);
      AppMethodBeat.o(176388);
      return;
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acKq, this.RfQ);
    AppMethodBeat.o(176388);
  }
  
  private void hqw()
  {
    AppMethodBeat.i(176390);
    e.xfd.a("SnsPublishProcess", "opresult_", Integer.valueOf(this.qcv), com.tencent.mm.plugin.comm.b.c.xeS);
    com.tencent.mm.plugin.expt.b.d locald = (com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class);
    locald.he("startTime", this.REa);
    locald.he("endTime", Util.nowMilliSecond());
    locald.he("bussinessId", this.RfQ);
    locald.he("shareType", this.DnR);
    locald.he("hadLocation", this.RDJ.getShowFlag());
    locald.he("desc", this.RDH.getText().toString());
    locald.he("nextStep", this.qcv);
    locald.he("beforeStep", this.REb);
    locald.he("ContactTagCount", this.Rgo);
    locald.he("mIsBlackGroup", this.Rjx);
    if (this.Rjw != null)
    {
      localObject1 = this.Rjw.size();
      locald.he("mContactNameList", (String)localObject1);
      if (!(this.Rjt instanceof at)) {
        break label447;
      }
      Object localObject2 = ((at)this.Rjt).hnf();
      if ((localObject2 == null) || (((Map)localObject2).isEmpty())) {
        break label447;
      }
      localObject1 = new StringBuilder();
      localObject2 = ((Map)localObject2).values().iterator();
      label379:
      if (!((Iterator)localObject2).hasNext()) {
        break label434;
      }
      if (!((Boolean)((Iterator)localObject2).next()).booleanValue()) {
        break label429;
      }
    }
    label429:
    for (int i = 1;; i = 2)
    {
      ((StringBuilder)localObject1).append(i).append("#");
      break label379;
      localObject1 = "0";
      break;
    }
    label434:
    locald.he("picSource", ((StringBuilder)localObject1).toString());
    label447:
    if ((this.Rjt instanceof ao)) {
      if (!((ao)this.Rjt).hms()) {
        break label491;
      }
    }
    label491:
    for (Object localObject1 = "1";; localObject1 = "2")
    {
      locald.he("sightSource", (String)localObject1);
      AppMethodBeat.o(176390);
      return;
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(308265);
    Log.i("MicroMsg.SnsUploadUI", "updateSightConfig");
    getIntent().getExtras().clear();
    getIntent().putExtra("KSightPath", paramString1);
    getIntent().putExtra("KSightThumbPath", paramString2);
    getIntent().putExtra("sight_md5", paramString3);
    getIntent().putExtra("KSnsPostManu", true);
    getIntent().putExtra("Ksnsupload_type", 14);
    getIntent().putExtra("Kis_take_photo", paramBoolean2);
    getIntent().putExtra("KMMSightExtInfo", paramArrayOfByte);
    if (paramBoolean1) {
      getIntent().putExtra("KSessionID", Util.nowMilliSecond() + "_" + Util.getRandomString(5));
    }
    AppMethodBeat.o(308265);
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
  
  public final void b(SightCaptureResult paramSightCaptureResult)
  {
    AppMethodBeat.i(308267);
    String str2 = paramSightCaptureResult.KTN;
    String str3 = paramSightCaptureResult.KTO;
    Object localObject = null;
    getIntent().putExtra("KSightThumbPath", paramSightCaptureResult.KTO);
    getIntent().putExtra("KSnsFrom", 17);
    String str1;
    if (!Util.isNullOrNil(paramSightCaptureResult.KTQ)) {
      str1 = paramSightCaptureResult.KTQ;
    }
    try
    {
      for (;;)
      {
        paramSightCaptureResult = paramSightCaptureResult.KTS.toByteArray();
        a(str2, str3, str1, paramSightCaptureResult, true, true);
        hqu();
        AppMethodBeat.o(308267);
        return;
        str1 = y.bub(str2);
      }
    }
    catch (Exception paramSightCaptureResult)
    {
      for (;;)
      {
        Log.i("MicroMsg.SnsUploadUI", "put sight extinfo to snsuploadui error: %s", new Object[] { paramSightCaptureResult.getMessage() });
        paramSightCaptureResult = localObject;
      }
    }
  }
  
  public int getLayoutId()
  {
    return b.g.sns_upload_ui;
  }
  
  public final ArrayList<Exif.a> hmi()
  {
    AppMethodBeat.i(99609);
    if ((this.Rjt instanceof at))
    {
      at localat = (at)this.Rjt;
      Object localObject1 = localat.RhW.Rih;
      ArrayList localArrayList = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (Exif.a)localat.RhY.get(localObject2);
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
  
  public final boolean hmj()
  {
    return this.RfR;
  }
  
  public final void hqt()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(99600);
    int i = Tiger2022Helper.bC(this.RDH.getText());
    if (this.akiR)
    {
      if (i > 0) {}
      for (;;)
      {
        enableOptionMenu(bool1);
        AppMethodBeat.o(99600);
        return;
        bool1 = false;
      }
    }
    if ((this.Rjt != null) && (this.Rjt.hlP())) {}
    for (bool1 = bool2;; bool1 = false)
    {
      enableOptionMenu(bool1);
      AppMethodBeat.o(99600);
      return;
    }
  }
  
  public final void hqu()
  {
    AppMethodBeat.i(99613);
    Log.i("MicroMsg.SnsUploadUI", "resetWidget");
    if (this.RDM != null) {
      this.RDM.setVisibility(8);
    }
    if (this.Rju != null)
    {
      this.Rju.removeAllViews();
      this.Rju.setVisibility(8);
    }
    if (this.Rjt != null) {
      this.Rjt.hlT();
    }
    aNi();
    bc(null);
    AppMethodBeat.o(99613);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    AppMethodBeat.i(99605);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    e.xfd.a("SnsPublishProcess", "editPageTimes", Integer.valueOf(1), com.tencent.mm.plugin.comm.b.c.xeT);
    Object localObject = com.tencent.mm.plugin.sns.statistics.h.QFO;
    int i;
    switch (paramInt1)
    {
    case 8: 
    default: 
      i = -1;
    }
    for (;;)
    {
      if (i != -1) {
        e.xfd.a("SnsPublishProcess", "actionTrace_", Integer.valueOf(i), com.tencent.mm.plugin.comm.b.c.xeU);
      }
      if (this.RDH != null) {
        this.RDH.clearFocus();
      }
      if (paramInt2 == -1) {
        break;
      }
      AppMethodBeat.o(99605);
      return;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 6;
      continue;
      i = 8;
      continue;
      i = 7;
      continue;
      i = 9;
    }
    if (paramInt1 == 30764)
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acXn, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(getContext(), "android.permission.ACCESS_FINE_LOCATION", 64);
      }
      AppMethodBeat.o(99605);
      return;
    }
    if (this.Rjt.n(paramInt1, paramIntent)) {
      hqt();
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
      bB(paramIntent);
      AppMethodBeat.o(99605);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      getIntent().putExtras(paramIntent.getExtras());
      localObject = this.RDI;
      if (this.RDK.getLabelRange() == 0)
      {
        bool1 = true;
        ((AtContactWidget)localObject).d(paramIntent, bool1);
        localObject = this.RDK;
        if (Util.isNullOrNil(paramIntent.getStringExtra("Select_Contact"))) {
          break label456;
        }
      }
      label456:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ((RangeWidget)localObject).RiV = bool1;
        AppMethodBeat.o(99605);
        return;
        bool1 = false;
        break;
      }
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      bool1 = paramIntent.getBooleanExtra("bind_facebook_succ", false);
      paramIntent = this.Rbp;
      if (bool1)
      {
        paramIntent.RDs = true;
        paramIntent.setSyncFacebook(true);
      }
      AppMethodBeat.o(99605);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99605);
        return;
      }
      localObject = Util.nullAs(paramIntent.getStringExtra("get_poi_name"), "");
      String str = Util.nullAs(paramIntent.getStringExtra("get_city"), "");
      if (Util.isNullOrNil((String)localObject)) {
        getIntent().removeExtra("get_poi_name");
      }
      if (Util.isNullOrNil(str)) {
        getIntent().removeExtra("get_city");
      }
      getIntent().putExtras(paramIntent.getExtras());
      this.RDJ.by(paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99595);
    Log.i("MicroMsg.SnsUploadUI", "onCreate");
    e.xfd.a("SnsPublishProcess", "editPageTimes", Integer.valueOf(1), com.tencent.mm.plugin.comm.b.c.xeT);
    com.tencent.mm.pluginsdk.h.w(this);
    super.onCreate(paramBundle);
    Object localObject1 = com.tencent.mm.plugin.sns.statistics.h.QFO;
    com.tencent.mm.plugin.sns.statistics.h.DT(false);
    localObject1 = e.xfd;
    localObject1 = ai.cz(SnsPublishProcessStruct.class).klu();
    kotlin.g.b.s.checkNotNull(localObject1);
    e.a.gt("SnsPublishProcess", (String)localObject1);
    localObject1 = com.tencent.mm.plugin.sns.data.t.heR();
    Object localObject2 = e.xfd;
    kotlin.g.b.s.s(localObject1, "sessionId");
    ((e.a)localObject2).f("SnsPublishProcess", "sessionid_", localObject1);
    localObject2 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.I("moment_sessionid_", localObject1);
    e.xfd.a("SnsPublishProcess", "actionTrace_", Integer.valueOf(1), com.tencent.mm.plugin.comm.b.c.xeU);
    localObject1 = e.xfd;
    int i;
    label464:
    label859:
    boolean bool1;
    label654:
    label1172:
    label1308:
    label1708:
    label1771:
    int j;
    if (SnsTimeLineUI.hpL())
    {
      i = 0;
      ((e.a)localObject1).f("SnsPublishProcess", "ifShowActionSheet", Integer.valueOf(i));
      e.xfd.f("SnsTemplate", "sessionID", com.tencent.mm.plugin.sns.data.t.heR());
      setActionbarColor(getContext().getResources().getColor(b.c.BG_2));
      setNavigationbarColor(getContext().getResources().getColor(b.c.BG_2));
      hideActionbarLine();
      getIntent().setExtrasClassLoader(getClass().getClassLoader());
      al.hgJ().db.delete("snsDraft", "key!=? AND key!=? AND timestamp<?", new String[] { "draft_text", "draft_normal", String.valueOf(System.currentTimeMillis() - 86400000L) });
      this.RDU = getIntent().getBooleanExtra("Kis_retry_edit", false);
      this.akiR = getIntent().getBooleanExtra("is_tiger2022", false);
      if (getIntent().getBooleanExtra("is_from_tiger2022_live", false))
      {
        localObject1 = com.tencent.mm.plugin.sns.statistics.h.QFO;
        e.xfd.f("SnsPublishProcess", "fromPage", Integer.valueOf(6));
      }
      switch (getIntent().getIntExtra("Ksnsupload_type", 0))
      {
      default: 
        if ((!Util.isNullOrNil(this.Qxh)) && (!this.RDU))
        {
          localObject1 = al.hgJ().aZP(this.Qxh);
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.sns.storage.s)localObject1).field_draft;
            if (!Util.isNullOrNil((byte[])localObject1))
            {
              localObject2 = Parcel.obtain();
              ((Parcel)localObject2).unmarshall((byte[])localObject1, 0, localObject1.length);
              ((Parcel)localObject2).setDataPosition(0);
              setIntent((Intent)Intent.CREATOR.createFromParcel((Parcel)localObject2));
            }
          }
        }
        aNi();
        if (this.akiR)
        {
          findViewById(b.f.sns_desc_tv).setVisibility(8);
          this.RDH = ((com.tencent.mm.ui.widget.cedit.api.c)findViewById(b.f.tiger2022_text));
          localObject1 = new Tiger2022Helper.a(this);
          this.RDH.setFilters(new InputFilter[] { localObject1 });
          this.RDH.setVisibility(0);
          this.RDH.addTextChangedListener(new TextWatcher()
          {
            public final void afterTextChanged(Editable paramAnonymousEditable) {}
            
            public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
            
            public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              AppMethodBeat.i(369925);
              SnsUploadUI.this.hqt();
              AppMethodBeat.o(369925);
            }
          });
          this.RDH.jEJ();
          this.RDH.refresh(((PluginWebSearch)com.tencent.mm.kernel.h.az(PluginWebSearch.class)).isUseSysEditText());
          this.RDH.getInputExtras(true).putInt("wechat_scene", 3);
          this.RDH.getInputExtras(true).putBoolean("if_support_wx_emoji", true);
          localObject1 = getBounceView();
          if (localObject1 != null) {
            ((com.tencent.mm.ui.widget.pulldown.f)localObject1).a(new SnsUploadUI.9(this));
          }
          localObject1 = new SnsUploadUI.10(this);
          this.RDH.a(((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseBrands(), ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseItems(), LocaleUtil.getCurrentLanguage(getContext()), (a.e)localObject1);
          this.RDH.addTextChangedListener(new SnsUploadUI.11(this));
          if (Util.isNullOrNil(getIntent().getStringExtra("Kdescription"))) {
            break label2515;
          }
          this.RDH.setText(com.tencent.mm.ui.i.c.b.c(getContext(), getIntent().getStringExtra("Kdescription"), this.RDH.getTextSize()));
          if (this.DnR == 8)
          {
            localObject1 = getIntent().getStringExtra("Kdescription");
            this.RDH.setText(com.tencent.mm.ui.i.c.b.c(getContext(), (CharSequence)localObject1, this.RDH.getTextSize()));
          }
          this.RDH.setPasterLen(getIntent().getIntExtra("KparseLen", 0));
          this.HxM = ((KeyboardLinearLayout)findViewById(b.f.root));
          this.RDL = ((SnsUploadSayFooter)findViewById(b.f.say_footer));
          this.RDL.setMMEditText(this.RDH);
          this.RDL.setVisibility(4);
          this.RDY = ((FrameLayout)findViewById(b.f.root_fr));
          this.RDY.post(new SnsUploadUI.25(this));
          localObject1 = new SnsUploadUI.26(this);
          this.RDH.setOnClickListener((View.OnClickListener)localObject1);
          localObject1 = new SnsUploadUI.2(this);
          this.RDH.setOnLongClickListener((View.OnLongClickListener)localObject1);
          localObject1 = new boolean[1];
          localObject1[0] = 0;
          this.RDH.addTextChangedListener(new SnsUploadUI.3(this, new boolean[] { true }));
          localObject2 = (WrapScollview)findViewById(b.f.scroll_view);
          ((WrapScollview)localObject2).setContentView(this.RDH.jEG());
          ((WrapScollview)localObject2).setDoComputeScrollDeltaToGetChildRectOnScreen(false);
          Object localObject3 = Util.nullAs(getIntent().getStringExtra("reportSessionId"), "");
          this.Rbp = ((SnsUploadConfigView)findViewById(b.f.config_view));
          localObject2 = this.Rbp;
          if ((this.DnR != 14) || (((String)localObject3).contains("wx5dfbe0a95623607b"))) {
            break label2554;
          }
          bool1 = true;
          ((SnsUploadConfigView)localObject2).RDy = bool1;
          if (bool1)
          {
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(2842, (com.tencent.mm.am.h)localObject2);
            localObject3 = new com.tencent.mm.plugin.sns.model.j();
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject3, 0);
          }
          ((SnsUploadConfigView)localObject2).Rgk.ZaH = -1000.0F;
          ((SnsUploadConfigView)localObject2).Rgk.ZaG = -1000.0F;
          if (!((SnsUploadConfigView)localObject2).Gdb)
          {
            com.tencent.mm.kernel.h.baF();
            i = Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(68404, null));
            if ((i & 0x2) == 0) {
              break label2560;
            }
            bool1 = true;
            label1291:
            ((SnsUploadConfigView)localObject2).RDs = bool1;
            if ((i & 0x8) == 0) {
              break label2566;
            }
            bool1 = true;
            ((SnsUploadConfigView)localObject2).RDt = bool1;
            if (!com.tencent.mm.au.b.isOverseasUser()) {
              ((SnsUploadConfigView)localObject2).RDt = false;
            }
            if (!z.bBw()) {
              ((SnsUploadConfigView)localObject2).RDs = false;
            }
          }
          ((SnsUploadConfigView)localObject2).setSyncFacebook(false);
          ((SnsUploadConfigView)localObject2).hqm();
          ((SnsUploadConfigView)localObject2).hqo();
          ((SnsUploadConfigView)localObject2).hqn();
          if (((SnsUploadConfigView)localObject2).RDt) {
            ((SnsUploadConfigView)localObject2).RDz.a((com.tencent.mm.ui.q.a.a)localObject2);
          }
          if (this.DnR != 0)
          {
            localObject2 = this.Rbp;
            ((SnsUploadConfigView)localObject2).RDn.setVisibility(8);
            ((SnsUploadConfigView)localObject2).RDo.setVisibility(8);
            ((SnsUploadConfigView)localObject2).RDp.setVisibility(8);
            ((SnsUploadConfigView)localObject2).RDq.setVisibility(8);
          }
          if (this.DnR == 9) {
            this.Rbp.RDp.setVisibility(0);
          }
          setBackBtn(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(176366);
              SnsUploadUI.q(SnsUploadUI.this);
              AppMethodBeat.o(176366);
              return true;
            }
          });
          addTextOptionMenu(0, getString(b.j.sns_send), new SnsUploadUI.5(this, (boolean[])localObject1), null, new SnsUploadUI.6(this, (boolean[])localObject1), y.b.adEJ);
          findViewById(b.f.upload_content).setOnTouchListener(new SnsUploadUI.7(this));
          this.RDI = ((AtContactWidget)findViewById(b.f.at_contact_widget));
          this.RDI.Rbp = this.Rbp;
          this.RDJ = ((LocationWidget)findViewById(b.f.location_widget));
          this.RDJ.setLocationWidgetListener(this);
          switch (this.DnR)
          {
          case 26: 
          default: 
            this.RDK.Rbp = this.Rbp;
            this.RDK.setRangeTipClickListener(new SnsUploadUI.8(this));
            this.RDJ.by(getIntent());
            localObject1 = this.RDI;
            localObject2 = getIntent();
            if (this.RDK.getLabelRange() == 0)
            {
              bool1 = true;
              ((AtContactWidget)localObject1).d((Intent)localObject2, bool1);
              com.tencent.mm.plugin.sns.statistics.j.QFS.akX(0);
              com.tencent.mm.plugin.sns.statistics.j.QFS.QGd.joQ = 2;
              bB(getIntent());
              hideVKB();
              bc(paramBundle);
              paramBundle = al.hgJ().aZP(this.Qxh);
              if (paramBundle != null)
              {
                if (!Util.isNullOrNil(paramBundle.field_draft))
                {
                  localObject1 = com.tencent.mm.plugin.sns.statistics.h.QFO;
                  com.tencent.mm.plugin.sns.statistics.h.DT(true);
                }
                if ((paramBundle.field_extFlag & 0x1) != 1) {}
              }
              switch (this.DnR)
              {
              case 2: 
              case 3: 
              case 4: 
              case 5: 
              case 6: 
              case 7: 
              case 8: 
              case 10: 
              case 12: 
              case 13: 
              case 18: 
              case 19: 
              case 20: 
              case 22: 
              case 24: 
              case 25: 
              case 26: 
              case 29: 
              default: 
                i = 0;
                j = 2;
                label2004:
                com.tencent.mm.plugin.report.service.h.OAn.b(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(i), this.RfQ, Long.valueOf(Util.nowSecond()), Integer.valueOf(j) });
                com.tencent.mm.pluginsdk.h.x(this);
                paramBundle = Parcel.obtain();
                getIntent().writeToParcel(paramBundle, 0);
                this.RDV = MD5Util.getMD5String(paramBundle.marshall());
                this.RDW = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zfe, 3000L);
                this.REa = Util.nowMilliSecond();
                this.RDQ = false;
                getIntent().getBooleanExtra("KThrid_app", false);
                if (getIntent().getIntExtra("KSnsFrom", 0) == 17)
                {
                  bool1 = true;
                  label2149:
                  if (getIntent().getIntExtra("KSnsFrom", 0) != 14) {
                    break label2699;
                  }
                }
                break;
              }
            }
            break;
          }
        }
        break;
      }
    }
    label2560:
    label2566:
    label2699:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramBundle = com.tencent.mm.plugin.sns.statistics.h.QFO;
      h.a.a(this.DnR, bool1, bool2, this.RDU, this.Rjy, "com.tencent.phoenix".equals(getIntent().getStringExtra("SendAppMessageWrapper_PkgName")), this.akiR);
      if (getIntent().hasExtra("KSnsVideoTempalteInfo")) {
        e.xfd.f("SnsPublishProcess", "ifMiaojian", Integer.valueOf(2));
      }
      AppMethodBeat.o(99595);
      return;
      i = 1;
      break;
      localObject1 = XmlParser.parseXml(Util.nullAs(getIntent().getStringExtra("fav_note_xml"), ""), "favlocalid", null);
      if ((localObject1 == null) || (((Map)localObject1).size() == 0)) {
        break label464;
      }
      localObject1 = (String)((Map)localObject1).get(".favlocalid");
      if (Util.isEqual((String)localObject1, "0")) {
        break label464;
      }
      this.Qxh = ((String)localObject1);
      break label464;
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
        this.Qxh = com.tencent.mm.plugin.sns.data.t.aXH((String)localObject2);
      }
      if (getIntent().getBooleanExtra("ksnsis_appbrand", false)) {
        this.Qxh = null;
      }
      if (!getIntent().getBooleanExtra("KSnsIsUploadAdLandingPage", false)) {
        break label464;
      }
      this.Qxh = null;
      break label464;
      this.Qxh = Util.nullAs(getIntent().getStringExtra("Ksnsupload_musicid"), "");
      break label464;
      this.RDH = ((com.tencent.mm.ui.widget.cedit.api.c)findViewById(b.f.sns_desc_tv));
      com.tencent.mm.ui.widget.cedit.api.d.a(this.RDH).aEg(com.tencent.mm.k.c.aRc()).a(null);
      break label654;
      label2515:
      if ((this.RDH == null) || (paramBundle == null)) {
        break label859;
      }
      localObject1 = paramBundle.getString("contentdesc");
      if (localObject1 == null) {
        break label859;
      }
      this.RDH.setText((CharSequence)localObject1);
      break label859;
      label2554:
      bool1 = false;
      break label1172;
      bool1 = false;
      break label1291;
      bool1 = false;
      break label1308;
      this.RDK = ((RangeWidget)findViewById(b.f.rang_widget_bottom));
      findViewById(b.f.rang_widget_top).setVisibility(8);
      break label1708;
      this.RDK = ((RangeWidget)findViewById(b.f.rang_widget_bottom));
      findViewById(b.f.rang_widget_top).setVisibility(8);
      break label1708;
      this.RDK = ((RangeWidget)findViewById(b.f.rang_widget_bottom));
      findViewById(b.f.rang_widget_top).setVisibility(8);
      break label1708;
      bool1 = false;
      break label1771;
      i = 1;
      j = 2;
      break label2004;
      i = 3;
      j = 2;
      break label2004;
      i = 5;
      j = 2;
      break label2004;
      j = 3;
      i = 0;
      break label2004;
      bool1 = false;
      break label2149;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99604);
    super.onDestroy();
    Object localObject;
    if (this.Rbp != null)
    {
      localObject = this.Rbp;
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(2842, (com.tencent.mm.am.h)localObject);
    }
    if (this.Rjt != null) {
      this.Rjt.hlT();
    }
    if (this.RDJ != null) {
      this.RDJ.stop();
    }
    if (this.RDL != null)
    {
      localObject = this.RDL;
      if (((SnsUploadSayFooter)localObject).moD != null)
      {
        ((SnsUploadSayFooter)localObject).moD.iKg();
        ((SnsUploadSayFooter)localObject).moD.destroy();
      }
    }
    this.RDR.clear();
    com.tencent.mm.plugin.normsg.a.d.MtP.aQj("ie_sns_upload");
    com.tencent.mm.plugin.sns.data.t.heS();
    this.REc.dead();
    this.RDH.destroy();
    e.xfd.a("SnsPublishProcess", "editPageStaytime_", Long.valueOf(getActivityBrowseTimeMs()), com.tencent.mm.plugin.comm.b.c.xeT);
    if (this.qcv != 3)
    {
      localObject = com.tencent.mm.plugin.sns.statistics.h.QFO;
      h.a.aZm(null);
    }
    AppMethodBeat.o(99604);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99597);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      paramKeyEvent = this.RDL;
      if ((paramKeyEvent.hqp()) || (paramKeyEvent.getVisibility() == 0)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        this.RDL.aWI();
        AppMethodBeat.o(99597);
        return true;
      }
      eHy();
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
    this.RDH.onPause();
    AppMethodBeat.o(99602);
  }
  
  public void onPreDestroyed()
  {
    AppMethodBeat.i(308250);
    super.onPreDestroyed();
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
    localObject = (com.tencent.mm.plugin.sns.k.j)com.tencent.mm.plugin.secdata.ui.a.a.c(this, 2, com.tencent.mm.plugin.sns.k.j.class);
    if ((localObject == null) || (((com.tencent.mm.plugin.sns.k.j)localObject).icg <= 0))
    {
      AppMethodBeat.o(308250);
      return;
    }
    ((g)com.tencent.mm.kernel.h.az(g.class)).updateWithSave(2, "SnsPostEnd_" + ((com.tencent.mm.plugin.sns.k.j)localObject).icg, (com.tencent.mm.bx.a)localObject, new i() {});
    AppMethodBeat.o(308250);
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
        this.RDJ.hmf();
        AppMethodBeat.o(99610);
        return;
      }
      com.tencent.mm.ui.base.k.a(this, getString(b.j.permission_location_request_again_msg), getString(b.j.permission_tips_title), getString(b.j.jump_to_settings), getString(b.j.app_cancel), false, new SnsUploadUI.16(this), new SnsUploadUI.17(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99603);
    super.onResume();
    this.RDL.post(new SnsUploadUI.13(this));
    ao localao;
    if ((this.Rjt != null) && ((this.Rjt instanceof ao)))
    {
      localao = (ao)this.Rjt;
      if (localao.RfL != null)
      {
        if (localao.RfS) {
          break label97;
        }
        localao.hmq();
      }
    }
    for (;;)
    {
      this.RDH.refresh(((PluginWebSearch)com.tencent.mm.kernel.h.az(PluginWebSearch.class)).isUseSysEditText());
      AppMethodBeat.o(99603);
      return;
      label97:
      localao.hmr();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(99594);
    if (paramBundle != null)
    {
      if (this.RDH != null) {
        paramBundle.putString("contentdesc", this.RDH.getText().toString());
      }
      this.Rjt.ba(paramBundle);
    }
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(99594);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(176385);
    super.onStart();
    al.fAG().postDelayed(this.RDX, this.RDW);
    AppMethodBeat.o(176385);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(176387);
    super.onStop();
    al.fAG().removeCallbacks(this.RDX);
    AppMethodBeat.o(176387);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI
 * JD-Core Version:    0.7.0.1
 */