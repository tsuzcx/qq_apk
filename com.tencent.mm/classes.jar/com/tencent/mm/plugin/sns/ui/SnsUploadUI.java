package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.ah.f;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.ui.i.a.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@com.tencent.mm.kernel.j
@com.tencent.mm.ui.base.a(17)
public class SnsUploadUI
  extends MMActivity
  implements LocationWidget.a
{
  private String desc;
  private KeyboardLinearLayout kCd;
  private SnsUploadConfigView oNv;
  private String oQO = "";
  private boolean oQP = false;
  private int oQa = 0;
  private String oSV = "";
  private String oSW = "";
  private SnsEditText oTp;
  private y oTq = null;
  private LinearLayout oTr;
  private int oTt = 0;
  private int oTu = 0;
  private ArrayList<String> oTv;
  private boolean oTw = false;
  private boolean oTy = false;
  private long oTz = 0L;
  private AtContactWidget pje;
  private LocationWidget pjf;
  private RangeWidget pjg;
  private SnsUploadSayFooter pjh;
  private DynamicGridView pji;
  private boolean pjj = false;
  private boolean pjk = false;
  private String pjl = null;
  private Map<Integer, y> pjm = new HashMap();
  private FrameLayout pjn = null;
  private long pjo = 0L;
  
  private void H(Bundle paramBundle)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsUploadUI", "attachWidget. share type %d, isManuSnsPost:%b", new Object[] { Integer.valueOf(this.oQa), Boolean.valueOf(this.oTy) });
    Object localObject;
    if ((this.oQa == 0) || (this.oQa == 14) || (this.oQa == 9))
    {
      localObject = Parcel.obtain();
      getIntent().writeToParcel((Parcel)localObject, 0);
      ((Parcel)localObject).marshall();
      if (this.oQa != 9) {
        break label444;
      }
      setMMTitle(this.mController.uMN.getResources().getString(i.j.sns_text_title));
    }
    RelativeLayout.LayoutParams localLayoutParams;
    label444:
    int i;
    switch (this.oQa)
    {
    default: 
    case 0: 
    case 14: 
    case 1: 
    case 11: 
    case 15: 
    case 16: 
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
        this.oTq.E(paramBundle);
        if (!(this.oTq instanceof a)) {
          break label804;
        }
        paramBundle = findViewById(i.f.sns_desc_container_frame);
        localObject = findViewById(i.f.sns_img_tips);
        this.pji = ((DynamicGridView)findViewById(i.f.sns_preview_img_dynamicgrid));
        this.pji.setOnTouchListener(new SnsUploadUI.9(this));
        paramBundle = ((a)this.oTq).a(paramBundle, findViewById(i.f.del_area), this.pji, (View)localObject);
        this.pji.setVisibility(0);
        localObject = findViewById(i.f.widget_line);
        localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        localLayoutParams.topMargin = 0;
        localLayoutParams.addRule(3, i.f.sns_preview_img_dynamicgrid);
        ((View)localObject).setLayoutParams(localLayoutParams);
        if ((this.oTq instanceof z))
        {
          localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).width = -1;
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if (((this.oTq instanceof o)) || ((this.oTq instanceof m)) || ((this.oTq instanceof n)))
        {
          localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).width = -1;
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        bKb();
        if (this.oQa == 0)
        {
          if ((this.oTq instanceof ag)) {
            break label968;
          }
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsUploadUI", "!(widget instanceof PicWidget)");
        }
        return;
        setMMTitle("");
        break;
        this.oTq = yX(this.oQa);
        this.oTp.addTextChangedListener(new SnsUploadUI.7(this));
        continue;
        this.oTq = yX(this.oQa);
        continue;
        this.oTq = new z(this);
        continue;
        this.oTq = new ab(this);
        continue;
        this.oTq = new ah(this, 9);
        continue;
        this.oTq = new ah(this, 12);
        continue;
        this.oTq = new o(this);
        continue;
        this.oTq = new m(this);
        continue;
        this.oTq = new p(this);
        continue;
        this.oTq = new n(this);
        continue;
        this.oTq = new ah(this, 14);
        continue;
        this.oTq = new ah(this, 13);
      }
    case 9: 
      g.DQ();
      localObject = bk.aM((String)g.DP().Dz().get(68408, ""), "");
      g.DQ();
      i = bk.a((Integer)g.DP().Dz().get(7489, Integer.valueOf(0)), 0);
      if (bk.bl((String)localObject)) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.oTq = new ad(this, bool);
      this.oTp.setPasterLen(i);
      this.oTp.setText(com.tencent.mm.ui.e.c.b.d(this.mController.uMN, (CharSequence)localObject, this.oTp.getTextSize()));
      this.oTp.addTextChangedListener(new SnsUploadUI.8(this));
      break;
      this.oTq = new bd(this);
      break;
      label804:
      paramBundle = this.oTq.bHr();
      this.oTr = ((LinearLayout)findViewById(i.f.widget_content));
      this.oTr.setVisibility(0);
      this.oTr.setClipChildren(false);
      label864:
      float f;
      if (paramBundle != null)
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsUploadUI", "will add widget view in widgetLL.");
        this.oTr.addView(paramBundle);
        if ((this.oQa == 9) || (this.oQa == 14))
        {
          localObject = findViewById(i.f.widget_line);
          localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
          localLayoutParams.addRule(3, i.f.widget_content);
          f = c.cqp().density;
          if (this.oQa != 9) {
            break label962;
          }
        }
      }
      label962:
      for (i = 128;; i = 96)
      {
        localLayoutParams.topMargin = ((int)(i * f));
        ((View)localObject).setLayoutParams(localLayoutParams);
        break;
        this.oTr.setVisibility(8);
        break label864;
      }
      label968:
      if (Build.VERSION.SDK_INT < 11)
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsUploadUI", "sdk not support dragdrop event");
        return;
      }
      new Runnable()
      {
        public final void run()
        {
          SnsUploadUI.10.1 local1 = new SnsUploadUI.10.1(this);
          if (SnsUploadUI.e(SnsUploadUI.this) != null) {
            SnsUploadUI.e(SnsUploadUI.this).setOnDragListener(local1);
          }
        }
      }.run();
      return;
    }
  }
  
  private void W(Intent paramIntent)
  {
    Object localObject1 = null;
    this.pjg.a(5, -1, paramIntent, this.pje);
    int j = paramIntent.getIntExtra("Ktag_range_index", 0);
    if (j >= 2)
    {
      this.oSV = paramIntent.getStringExtra("Klabel_name_list");
      this.oSW = paramIntent.getStringExtra("Kother_user_name_list");
      if (bk.bl(this.oSV)) {
        break label448;
      }
    }
    label445:
    label448:
    for (paramIntent = Arrays.asList(this.oSV.split(","));; paramIntent = null)
    {
      if (!bk.bl(this.oSW)) {
        localObject1 = Arrays.asList(this.oSW.split(","));
      }
      this.oTv = new ArrayList();
      this.oTt = 0;
      HashSet localHashSet;
      Object localObject2;
      int i;
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        Iterator localIterator = paramIntent.iterator();
        localHashSet = new HashSet();
        if (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          localObject2 = com.tencent.mm.plugin.label.a.a.bdA().Go(com.tencent.mm.plugin.label.a.a.bdA().Gl((String)localObject2));
          if ((localObject2 == null) || (((List)localObject2).size() == 0)) {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsUploadUI", "dz: getContactNamesFromLabelsAndOtherUserName,namelist get bu label is null");
          }
        }
        else
        {
          this.oTv = new ArrayList(localHashSet);
        }
      }
      else
      {
        if (paramIntent == null) {
          break label345;
        }
        paramIntent = paramIntent.iterator();
        i = 0;
        label240:
        if (!paramIntent.hasNext()) {
          break label340;
        }
        if (bk.bl((String)paramIntent.next())) {
          break label445;
        }
        i += 1;
      }
      for (;;)
      {
        break label240;
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          localHashSet.add(str);
          this.oTt += 1;
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsUploadUI", "dz:name : %s", new Object[] { str });
        }
        break;
        label340:
        this.oTt = i;
        label345:
        this.oTu = 0;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          paramIntent = ((List)localObject1).iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            if (!this.oTv.contains(localObject1))
            {
              this.oTv.add(localObject1);
              this.oTu += 1;
            }
          }
        }
        if (j == 2)
        {
          this.oTw = false;
          return;
        }
        this.oTw = true;
        return;
      }
    }
  }
  
  private void bJZ()
  {
    if (((this.oQa == 0) && (((ag)this.oTq).oSd.oSo.size() > 0)) || ((this.oQa == 14) && ((this.oTq instanceof ac)) && (!((ac)this.oTq).oQQ)) || ((this.oQa == 9) && (!bk.bl(this.oTp.getText().toString()))))
    {
      h.a(this, i.j.sns_upload_exit_and_save_tips, 0, i.j.sns_upload_exit_save, i.j.sns_upload_exit_not_save, true, new SnsUploadUI.11(this), new SnsUploadUI.12(this), i.c.alert_btn_color_no);
      return;
    }
    h.a(this, i.j.sns_upload_cancel_tips, 0, i.j.app_alert_exit, i.j.app_cancel, false, new SnsUploadUI.13(this), null, i.c.alert_btn_color_warn);
  }
  
  private void bKa()
  {
    setResult(0, new Intent());
    finish();
  }
  
  private void xK()
  {
    this.oTy = getIntent().getBooleanExtra("KSnsPostManu", false);
    this.oTz = getIntent().getLongExtra("KTouchCameraTime", 0L);
    this.oQa = getIntent().getIntExtra("Ksnsupload_type", 0);
    this.oQP = getIntent().getBooleanExtra("Kis_take_photo", false);
    this.pjj = getIntent().getBooleanExtra("need_result", false);
    this.pjk = getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false);
    this.pjl = getIntent().getStringExtra("Ksnsupload_canvas_info");
    this.oQO = getIntent().getStringExtra("KSessionID");
    if (bk.bl(this.oQO))
    {
      this.oQO = (bk.UY() + "_" + bk.Fe(5));
      getIntent().putExtra("KSessionID", this.oQO);
    }
  }
  
  private y yX(int paramInt)
  {
    Object localObject1 = (y)this.pjm.get(Integer.valueOf(paramInt));
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (paramInt != 0) {
        break label55;
      }
      localObject1 = new ag(this);
    }
    for (;;)
    {
      this.pjm.put(Integer.valueOf(paramInt), localObject1);
      localObject2 = localObject1;
      return localObject2;
      label55:
      if (paramInt == 14) {
        localObject1 = new ac(this);
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    getIntent().getExtras().clear();
    getIntent().putExtra("KSightPath", paramString1);
    getIntent().putExtra("KSightThumbPath", paramString2);
    getIntent().putExtra("sight_md5", paramString3);
    getIntent().putExtra("KSnsPostManu", true);
    getIntent().putExtra("Ksnsupload_type", 14);
    getIntent().putExtra("Kis_take_photo", false);
    getIntent().putExtra("KMMSightExtInfo", paramArrayOfByte);
    if (paramBoolean) {
      getIntent().putExtra("KSessionID", bk.UY() + "_" + bk.Fe(5));
    }
  }
  
  public final void a(String paramString, boolean paramBoolean, int paramInt1, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int paramInt2)
  {
    getIntent().getExtras().clear();
    getIntent().putExtra("KTouchCameraTime", bk.UX());
    getIntent().putExtra("KSnsPostManu", true);
    getIntent().putExtra("Ksnsupload_type", 0);
    getIntent().putExtra("KFilterId", paramInt1);
    if (!bk.bl(paramString)) {
      getIntent().putExtra("sns_kemdia_path", paramString);
    }
    if (!bk.dk(paramArrayList1)) {
      getIntent().putExtra("sns_kemdia_path_list", paramArrayList1);
    }
    if (!bk.dk(paramArrayList2)) {
      getIntent().putStringArrayListExtra("sns_media_latlong_list", paramArrayList2);
    }
    if (paramBoolean) {
      getIntent().putExtra("Kis_take_photo", paramBoolean);
    }
    if (paramInt2 != 0) {
      getIntent().putExtra("Ksnsupload_source", 11);
    }
  }
  
  public final ArrayList<Exif.a> bHD()
  {
    if ((this.oTq instanceof ag))
    {
      ag localag = (ag)this.oTq;
      Object localObject1 = localag.oSd.oSo;
      ArrayList localArrayList = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (Exif.a)localag.oSf.get(localObject2);
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public final boolean bHE()
  {
    return this.oQP;
  }
  
  public final void bKb()
  {
    if (this.oTq.bHq())
    {
      enableOptionMenu(true);
      return;
    }
    enableOptionMenu(false);
  }
  
  public final void bKc()
  {
    if (this.pji != null) {
      this.pji.setVisibility(8);
    }
    if (this.oTr != null)
    {
      this.oTr.removeAllViews();
      this.oTr.setVisibility(8);
    }
    if (this.oTq != null) {
      this.oTq.bHs();
    }
    xK();
    H(null);
  }
  
  protected final int getLayoutId()
  {
    return i.g.sns_upload_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.oTp != null) {
      this.oTp.clearFocus();
    }
    if (paramInt2 != -1) {}
    do
    {
      boolean bool;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (paramInt1 != 30764) {
                  break;
                }
                paramIntent = paramIntent.getBundleExtra("result_data");
              } while ((paramIntent == null) || (!paramIntent.getString("go_next", "").equals("gdpr_auth_location")));
              g.DP().Dz().c(ac.a.uzP, Boolean.valueOf(true));
              com.tencent.mm.pluginsdk.permission.a.b(this.mController.uMN, "android.permission.ACCESS_COARSE_LOCATION", 64);
              return;
              if (this.oTq.d(paramInt1, paramIntent)) {
                bKb();
              }
              switch (paramInt1)
              {
              case 7: 
              case 9: 
              default: 
                return;
              }
            } while (paramIntent == null);
            getIntent().putExtras(paramIntent.getExtras());
            W(paramIntent);
            return;
          } while (paramIntent == null);
          getIntent().putExtras(paramIntent.getExtras());
          this.pje.U(paramIntent);
          return;
        } while (paramIntent == null);
        bool = paramIntent.getBooleanExtra("bind_facebook_succ", false);
        paramIntent = this.oNv;
      } while (!bool);
      paramIntent.piQ = true;
      paramIntent.setSyncFacebook(true);
      return;
    } while (paramIntent == null);
    getIntent().putExtras(paramIntent.getExtras());
    this.pjf.U(paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    com.tencent.mm.pluginsdk.e.k(this);
    super.onCreate(paramBundle);
    ta(this.mController.uMN.getResources().getColor(i.c.white));
    czo();
    getIntent().getExtras().setClassLoader(getClass().getClassLoader());
    xK();
    this.oTp = ((SnsEditText)findViewById(i.f.sns_desc_tv));
    Object localObject1;
    boolean bool1;
    if (!bk.bl(getIntent().getStringExtra(e.h.uHV)))
    {
      this.oTp.setText(com.tencent.mm.ui.e.c.b.d(this.mController.uMN, getIntent().getStringExtra(e.h.uHV), this.oTp.getTextSize()));
      if (this.oQa == 8)
      {
        localObject1 = getIntent().getStringExtra(e.h.uHV);
        this.oTp.setText(com.tencent.mm.ui.e.c.b.d(this.mController.uMN, (CharSequence)localObject1, this.oTp.getTextSize()));
      }
      this.kCd = ((KeyboardLinearLayout)findViewById(i.f.root));
      this.pjh = ((SnsUploadSayFooter)findViewById(i.f.say_footer));
      this.pjh.setMMEditText(this.oTp);
      this.pjh.setVisibility(8);
      this.pjn = ((FrameLayout)findViewById(i.f.root_fr));
      this.pjn.post(new SnsUploadUI.14(this));
      this.oTp.setOnClickListener(new SnsUploadUI.15(this));
      this.oTp.setOnLongClickListener(new SnsUploadUI.16(this));
      localObject1 = (WrapScollview)findViewById(i.f.scroll_view);
      ((WrapScollview)localObject1).setContentView(this.oTp);
      ((WrapScollview)localObject1).setDoComputeScrollDeltaToGetChildRectOnScreen(false);
      Object localObject2 = bk.aM(getIntent().getStringExtra("reportSessionId"), "");
      this.oNv = ((SnsUploadConfigView)findViewById(i.f.config_view));
      localObject1 = this.oNv;
      if ((this.oQa != 14) || (((String)localObject2).contains("wx5dfbe0a95623607b"))) {
        break label933;
      }
      bool1 = true;
      label362:
      ((SnsUploadConfigView)localObject1).piW = bool1;
      if (bool1)
      {
        g.DQ();
        g.DO().dJT.a(2842, (f)localObject1);
        localObject2 = new com.tencent.mm.plugin.sns.model.j();
        g.DQ();
        g.DO().dJT.a((com.tencent.mm.ah.m)localObject2, 0);
      }
      ((SnsUploadConfigView)localObject1).piX.sGK = -1000.0F;
      ((SnsUploadConfigView)localObject1).piX.sGJ = -1000.0F;
      if (!((SnsUploadConfigView)localObject1).pcF)
      {
        g.DQ();
        int i = bk.g((Integer)g.DP().Dz().get(68404, null));
        if ((i & 0x2) == 0) {
          break label938;
        }
        bool1 = true;
        label478:
        ((SnsUploadConfigView)localObject1).piQ = bool1;
        if ((i & 0x8) == 0) {
          break label943;
        }
        bool1 = bool2;
        label494:
        ((SnsUploadConfigView)localObject1).piR = bool1;
        if (!com.tencent.mm.at.b.Pf()) {
          ((SnsUploadConfigView)localObject1).piR = false;
        }
        if (!q.GI()) {
          ((SnsUploadConfigView)localObject1).piQ = false;
        }
      }
      ((SnsUploadConfigView)localObject1).setSyncFacebook(false);
      ((SnsUploadConfigView)localObject1).bJT();
      ((SnsUploadConfigView)localObject1).bJV();
      ((SnsUploadConfigView)localObject1).bJU();
      if (((SnsUploadConfigView)localObject1).piR) {
        ((SnsUploadConfigView)localObject1).piY.a((a.a)localObject1);
      }
      if (this.oQa != 0)
      {
        localObject1 = this.oNv;
        ((SnsUploadConfigView)localObject1).piL.setVisibility(8);
        ((SnsUploadConfigView)localObject1).piM.setVisibility(8);
        ((SnsUploadConfigView)localObject1).piN.setVisibility(8);
        ((SnsUploadConfigView)localObject1).piO.setVisibility(8);
      }
      if (this.oQa == 9) {
        this.oNv.piN.setVisibility(0);
      }
      setBackBtn(new SnsUploadUI.17(this));
      a(0, getString(i.j.sns_send), new SnsUploadUI.2(this), s.b.uNx);
      findViewById(i.f.upload_content).setOnTouchListener(new SnsUploadUI.3(this));
      this.pje = ((AtContactWidget)findViewById(i.f.at_contact_widget));
      this.pje.oNv = this.oNv;
      this.pjf = ((LocationWidget)findViewById(i.f.location_widget));
      this.pjf.setLocationWidgetListener(this);
      switch (this.oQa)
      {
      }
    }
    for (;;)
    {
      this.pjg.oNv = this.oNv;
      this.pjf.U(getIntent());
      this.pje.U(getIntent());
      W(getIntent());
      XM();
      H(paramBundle);
      this.kCd.setOnkbdStateListener(new SnsUploadUI.1(this));
      com.tencent.mm.pluginsdk.e.l(this);
      return;
      if ((this.oTp == null) || (paramBundle == null)) {
        break;
      }
      localObject1 = paramBundle.getString("contentdesc");
      if (localObject1 == null) {
        break;
      }
      this.oTp.setText((CharSequence)localObject1);
      break;
      label933:
      bool1 = false;
      break label362;
      label938:
      bool1 = false;
      break label478;
      label943:
      bool1 = false;
      break label494;
      this.pjg = ((RangeWidget)findViewById(i.f.rang_widget_bottom));
      findViewById(i.f.rang_widget_top).setVisibility(8);
      continue;
      this.pjg = ((RangeWidget)findViewById(i.f.rang_widget_bottom));
      findViewById(i.f.rang_widget_top).setVisibility(8);
      continue;
      this.pjg = ((RangeWidget)findViewById(i.f.rang_widget_bottom));
      findViewById(i.f.rang_widget_top).setVisibility(8);
      this.pje.setVisibility(8);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject;
    if (this.oNv != null)
    {
      localObject = this.oNv;
      g.DQ();
      g.DO().dJT.b(2842, (f)localObject);
    }
    if (this.oTq != null) {
      this.oTq.bHs();
    }
    if (this.pjf != null) {
      this.pjf.stop();
    }
    if (this.pjh != null)
    {
      localObject = this.pjh;
      if (((SnsUploadSayFooter)localObject).jpC != null)
      {
        ((SnsUploadSayFooter)localObject).jpC.sj();
        ((SnsUploadSayFooter)localObject).jpC.destroy();
      }
    }
    this.pjm.clear();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      paramKeyEvent = this.pjh;
      if ((paramKeyEvent.bJX()) || (paramKeyEvent.getVisibility() == 0)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        this.pjh.bJY();
        return true;
      }
      bJZ();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    if (this.oQa == 9)
    {
      String str = this.oTp.getText().toString().trim();
      g.DQ();
      g.DP().Dz().o(68408, str);
      if (bk.bl(str)) {
        break label82;
      }
      g.DQ();
      g.DP().Dz().o(7489, Integer.valueOf(this.oTp.getPasterLen()));
    }
    for (;;)
    {
      super.XM();
      super.onPause();
      return;
      label82:
      g.DQ();
      g.DP().Dz().o(7489, Integer.valueOf(0));
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsUploadUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      this.pjf.bHA();
      return;
    }
    h.a(this, getString(i.j.permission_location_request_again_msg), getString(i.j.permission_tips_title), getString(i.j.jump_to_settings), getString(i.j.app_cancel), false, new DialogInterface.OnClickListener()new SnsUploadUI.6
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        SnsUploadUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        paramAnonymousDialogInterface.dismiss();
      }
    }, new SnsUploadUI.6(this));
  }
  
  protected void onResume()
  {
    super.onResume();
    this.pjh.post(new SnsUploadUI.4(this));
    ac localac;
    if ((this.oTq != null) && ((this.oTq instanceof ac)))
    {
      localac = (ac)this.oTq;
      if (localac.oQJ != null)
      {
        if (localac.oQQ) {
          break label64;
        }
        localac.bHH();
      }
    }
    return;
    label64:
    localac.bHI();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.oTp != null) {
      paramBundle.putString("contentdesc", this.oTp.getText().toString());
    }
    paramBundle.getString("contentdesc");
    this.oTq.F(paramBundle);
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI
 * JD-Core Version:    0.7.0.1
 */