package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.sns.model.j;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e.j;
import com.tencent.mm.ui.j.a.a;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.Arrays;
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
  private String desc;
  private KeyboardLinearLayout mYa;
  private SnsUploadConfigView rFe;
  private int rHM;
  private String rIA;
  private boolean rIB;
  private String rKQ;
  private String rKR;
  private String rKS;
  private SnsEditText rLm;
  private y rLn;
  private LinearLayout rLo;
  private int rLq;
  private int rLr;
  private ArrayList<String> rLs;
  private boolean rLt;
  private boolean rLv;
  private long rLw;
  private AtContactWidget sbG;
  private LocationWidget sbH;
  private RangeWidget sbI;
  private SnsUploadSayFooter sbJ;
  private DynamicGridView sbK;
  private boolean sbL;
  private boolean sbM;
  private String sbN;
  private Map<Integer, y> sbO;
  private FrameLayout sbP;
  private long sbQ;
  
  public SnsUploadUI()
  {
    AppMethodBeat.i(39757);
    this.rIB = false;
    this.rHM = 0;
    this.rLv = false;
    this.rLw = 0L;
    this.rLn = null;
    this.rKQ = "";
    this.rKR = "";
    this.rKS = "";
    this.rLq = 0;
    this.rLr = 0;
    this.rLt = false;
    this.sbL = false;
    this.sbM = false;
    this.sbN = null;
    this.rIA = "";
    this.sbO = new HashMap();
    this.sbP = null;
    this.sbQ = 0L;
    AppMethodBeat.o(39757);
  }
  
  private y Fe(int paramInt)
  {
    AppMethodBeat.i(39777);
    Object localObject1 = (y)this.sbO.get(Integer.valueOf(paramInt));
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (paramInt != 0) {
        break label65;
      }
      localObject1 = new ag(this);
    }
    for (;;)
    {
      this.sbO.put(Integer.valueOf(paramInt), localObject1);
      localObject2 = localObject1;
      AppMethodBeat.o(39777);
      return localObject2;
      label65:
      if (paramInt == 14) {
        localObject1 = new ac(this);
      }
    }
  }
  
  private void Kc()
  {
    AppMethodBeat.i(39765);
    this.rLv = getIntent().getBooleanExtra("KSnsPostManu", false);
    this.rLw = getIntent().getLongExtra("KTouchCameraTime", 0L);
    this.rHM = getIntent().getIntExtra("Ksnsupload_type", 0);
    this.rIB = getIntent().getBooleanExtra("Kis_take_photo", false);
    this.sbL = getIntent().getBooleanExtra("need_result", false);
    this.sbM = getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false);
    this.sbN = getIntent().getStringExtra("Ksnsupload_canvas_info");
    this.rIA = getIntent().getStringExtra("KSessionID");
    if (bo.isNullOrNil(this.rIA))
    {
      this.rIA = (bo.aoy() + "_" + bo.Ng(5));
      getIntent().putExtra("KSessionID", this.rIA);
    }
    AppMethodBeat.o(39765);
  }
  
  private void Y(Bundle paramBundle)
  {
    AppMethodBeat.i(39778);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SnsUploadUI", "attachWidget. share type %d, isManuSnsPost:%b", new Object[] { Integer.valueOf(this.rHM), Boolean.valueOf(this.rLv) });
    Object localObject;
    if ((this.rHM == 0) || (this.rHM == 14) || (this.rHM == 9))
    {
      localObject = Parcel.obtain();
      getIntent().writeToParcel((Parcel)localObject, 0);
      ((Parcel)localObject).marshall();
      if (this.rHM != 9) {
        break label440;
      }
      setMMTitle(getContext().getResources().getString(2131304004));
    }
    RelativeLayout.LayoutParams localLayoutParams;
    label440:
    int i;
    switch (this.rHM)
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
        this.rLn.V(paramBundle);
        if (!(this.rLn instanceof a)) {
          break label797;
        }
        paramBundle = findViewById(2131828172);
        localObject = findViewById(2131828174);
        this.sbK = ((DynamicGridView)findViewById(2131828170));
        this.sbK.setOnTouchListener(new SnsUploadUI.13(this));
        paramBundle = ((a)this.rLn).a(paramBundle, findViewById(2131828181), this.sbK, (View)localObject);
        this.sbK.setVisibility(0);
        localObject = findViewById(2131828176);
        localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        localLayoutParams.topMargin = 0;
        localLayoutParams.addRule(3, 2131828170);
        ((View)localObject).setLayoutParams(localLayoutParams);
        if ((this.rLn instanceof z))
        {
          localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).width = -1;
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if (((this.rLn instanceof o)) || ((this.rLn instanceof m)) || ((this.rLn instanceof n)))
        {
          localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).width = -1;
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        cwD();
        if (this.rHM == 0) {
          cwA();
        }
        AppMethodBeat.o(39778);
        return;
        setMMTitle("");
        break;
        this.rLn = Fe(this.rHM);
        this.rLm.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(145660);
            if (SnsUploadUI.f(SnsUploadUI.this).getText().toString().trim().length() > 10)
            {
              paramAnonymousCharSequence = SnsUploadUI.this.findViewById(2131828174);
              if (paramAnonymousCharSequence != null) {
                paramAnonymousCharSequence.setVisibility(8);
              }
            }
            AppMethodBeat.o(145660);
          }
        });
        continue;
        this.rLn = Fe(this.rHM);
        continue;
        this.rLn = new z(this);
        continue;
        this.rLn = new ab(this);
        continue;
        this.rLn = new ah(this, 9);
        continue;
        this.rLn = new ah(this, 12);
        continue;
        this.rLn = new o(this);
        continue;
        this.rLn = new m(this);
        continue;
        this.rLn = new p(this);
        continue;
        this.rLn = new n(this);
        continue;
        this.rLn = new ah(this, 14);
        continue;
        this.rLn = new ah(this, 13);
      }
    case 9: 
      g.RM();
      localObject = bo.bf((String)g.RL().Ru().get(68408, ""), "");
      g.RM();
      i = bo.a((Integer)g.RL().Ru().get(7489, Integer.valueOf(0)), 0);
      if (bo.isNullOrNil((String)localObject)) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.rLn = new ad(this, bool);
      this.rLm.setPasterLen(i);
      this.rLm.setText(com.tencent.mm.ui.f.c.b.c(getContext(), (CharSequence)localObject, this.rLm.getTextSize()));
      this.rLm.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(145661);
          if (SnsUploadUI.f(SnsUploadUI.this).getText().toString().trim().length() > 0)
          {
            SnsUploadUI.this.enableOptionMenu(true);
            AppMethodBeat.o(145661);
            return;
          }
          SnsUploadUI.this.enableOptionMenu(false);
          AppMethodBeat.o(145661);
        }
      });
      break;
      this.rLn = new bb(this);
      break;
      label797:
      paramBundle = this.rLn.ctv();
      this.rLo = ((LinearLayout)findViewById(2131828084));
      this.rLo.setVisibility(0);
      this.rLo.setClipChildren(false);
      label858:
      float f;
      if (paramBundle != null)
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SnsUploadUI", "will add widget view in widgetLL.");
        this.rLo.addView(paramBundle);
        if ((this.rHM == 9) || (this.rHM == 14))
        {
          localObject = findViewById(2131828176);
          localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
          localLayoutParams.addRule(3, 2131828084);
          f = d.aow().density;
          if (this.rHM != 9) {
            break label956;
          }
        }
      }
      label956:
      for (i = 128;; i = 96)
      {
        localLayoutParams.topMargin = ((int)(i * f));
        ((View)localObject).setLayoutParams(localLayoutParams);
        break;
        this.rLo.setVisibility(8);
        break label858;
      }
    }
  }
  
  private void ap(Intent paramIntent)
  {
    List localList2 = null;
    AppMethodBeat.i(39770);
    this.sbI.a(5, -1, paramIntent, this.sbG);
    int i = paramIntent.getIntExtra("Ktag_range_index", 0);
    if (i >= 2)
    {
      this.rKQ = paramIntent.getStringExtra("Klabel_name_list");
      this.rKR = paramIntent.getStringExtra("Kother_user_name_list");
      this.rKS = paramIntent.getStringExtra("Kchat_room_name_list");
      if (bo.isNullOrNil(this.rKQ)) {
        break label207;
      }
    }
    label207:
    for (paramIntent = Arrays.asList(this.rKQ.split(","));; paramIntent = null)
    {
      if (!bo.isNullOrNil(this.rKR)) {}
      for (List localList1 = Arrays.asList(this.rKR.split(","));; localList1 = null)
      {
        if (!bo.isNullOrNil(this.rKS)) {
          localList2 = Arrays.asList(this.rKS.split(","));
        }
        m(paramIntent, localList1);
        jdMethod_do(localList2);
        if (i == 2)
        {
          this.rLt = false;
          AppMethodBeat.o(39770);
          return;
        }
        this.rLt = true;
        AppMethodBeat.o(39770);
        return;
        if (!bo.es(this.rLs)) {
          this.rLs.clear();
        }
        AppMethodBeat.o(39770);
        return;
      }
    }
  }
  
  @TargetApi(11)
  private void cwA()
  {
    AppMethodBeat.i(39760);
    if (!(this.rLn instanceof ag))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SnsUploadUI", "!(widget instanceof PicWidget)");
      AppMethodBeat.o(39760);
      return;
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SnsUploadUI", "sdk not support dragdrop event");
      AppMethodBeat.o(39760);
      return;
    }
    new SnsUploadUI.12(this).run();
    AppMethodBeat.o(39760);
  }
  
  private void cwB()
  {
    AppMethodBeat.i(39762);
    if (((this.rHM == 0) && (((ag)this.rLn).cup() > 0)) || ((this.rHM == 14) && ((this.rLn instanceof ac)) && (!((ac)this.rLn).rIC)) || ((this.rHM == 9) && (!bo.isNullOrNil(this.rLm.getText().toString()))))
    {
      h.a(this, 2131304033, 0, 2131304035, 2131304034, true, new SnsUploadUI.14(this), new SnsUploadUI.15(this), 2131689666);
      AppMethodBeat.o(39762);
      return;
    }
    h.a(this, 2131304032, 0, 2131296542, 2131296888, false, new SnsUploadUI.16(this), null, 2131689667);
    AppMethodBeat.o(39762);
  }
  
  private void cwC()
  {
    AppMethodBeat.i(39763);
    setResult(0, new Intent());
    finish();
    AppMethodBeat.o(39763);
  }
  
  private void jdMethod_do(List<String> paramList)
  {
    AppMethodBeat.i(145664);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(145664);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (String)paramList.next();
      Object localObject2 = com.tencent.mm.model.n.nu((String)localObject1);
      if (localObject2 != null)
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SnsUploadUI", "getContactNamesFromChatroom chatromm:%s membersCount:%s", new Object[] { localObject1, Integer.valueOf(((List)localObject2).size()) });
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if ((!this.rLs.contains(localObject2)) && (t.nT((String)localObject2)))
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SnsUploadUI", "getContactNamesFromChatroom memberName:%s", new Object[] { localObject2 });
            this.rLs.add(localObject2);
            this.rLr += 1;
          }
        }
      }
    }
    AppMethodBeat.o(145664);
  }
  
  private void m(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(39771);
    this.rLs = new ArrayList();
    this.rLq = 0;
    HashSet localHashSet;
    Object localObject;
    int i;
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      Iterator localIterator = paramList1.iterator();
      localHashSet = new HashSet();
      if (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localObject = com.tencent.mm.plugin.label.a.a.bKV().RR(com.tencent.mm.plugin.label.a.a.bKV().RO((String)localObject));
        if ((localObject == null) || (((List)localObject).size() == 0)) {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SnsUploadUI", "dz: getContactNamesFromLabelsAndOtherUserName,namelist get bu label is null");
        }
      }
      else
      {
        this.rLs = new ArrayList(localHashSet);
      }
    }
    else
    {
      if (paramList1 == null) {
        break label250;
      }
      paramList1 = paramList1.iterator();
      i = 0;
      label144:
      if (!paramList1.hasNext()) {
        break label245;
      }
      if (bo.isNullOrNil((String)paramList1.next())) {
        break label334;
      }
      i += 1;
    }
    label334:
    for (;;)
    {
      break label144;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localHashSet.add(str);
        this.rLq += 1;
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SnsUploadUI", "dz:name : %s", new Object[] { str });
      }
      break;
      label245:
      this.rLq = i;
      label250:
      this.rLr = 0;
      if ((paramList2 != null) && (paramList2.size() > 0))
      {
        paramList1 = paramList2.iterator();
        while (paramList1.hasNext())
        {
          paramList2 = (String)paramList1.next();
          if (!this.rLs.contains(paramList2))
          {
            this.rLs.add(paramList2);
            this.rLr += 1;
          }
        }
      }
      AppMethodBeat.o(39771);
      return;
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(39775);
    getIntent().getExtras().clear();
    getIntent().putExtra("KSightPath", paramString1);
    getIntent().putExtra("KSightThumbPath", paramString2);
    getIntent().putExtra("sight_md5", paramString3);
    getIntent().putExtra("KSnsPostManu", true);
    getIntent().putExtra("Ksnsupload_type", 14);
    getIntent().putExtra("Kis_take_photo", false);
    getIntent().putExtra("KMMSightExtInfo", paramArrayOfByte);
    if (paramBoolean) {
      getIntent().putExtra("KSessionID", bo.aoy() + "_" + bo.Ng(5));
    }
    AppMethodBeat.o(39775);
  }
  
  public final void a(String paramString, boolean paramBoolean, int paramInt1, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int paramInt2)
  {
    AppMethodBeat.i(39774);
    getIntent().getExtras().clear();
    getIntent().putExtra("KTouchCameraTime", bo.aox());
    getIntent().putExtra("KSnsPostManu", true);
    getIntent().putExtra("Ksnsupload_type", 0);
    getIntent().putExtra("KFilterId", paramInt1);
    if (!bo.isNullOrNil(paramString)) {
      getIntent().putExtra("sns_kemdia_path", paramString);
    }
    if (!bo.es(paramArrayList1)) {
      getIntent().putExtra("sns_kemdia_path_list", paramArrayList1);
    }
    if (!bo.es(paramArrayList2)) {
      getIntent().putStringArrayListExtra("sns_media_latlong_list", paramArrayList2);
    }
    if (paramBoolean) {
      getIntent().putExtra("Kis_take_photo", paramBoolean);
    }
    if (paramInt2 != 0) {
      getIntent().putExtra("Ksnsupload_source", 11);
    }
    AppMethodBeat.o(39774);
  }
  
  public final ArrayList<Exif.a> ctJ()
  {
    AppMethodBeat.i(39772);
    if ((this.rLn instanceof ag))
    {
      ag localag = (ag)this.rLn;
      Object localObject1 = localag.rJW.rKh;
      ArrayList localArrayList = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (Exif.a)localag.rJY.get(localObject2);
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
      }
      AppMethodBeat.o(39772);
      return localArrayList;
    }
    AppMethodBeat.o(39772);
    return null;
  }
  
  public final boolean ctK()
  {
    return this.rIB;
  }
  
  public final void cwD()
  {
    AppMethodBeat.i(39764);
    if (this.rLn.ctu())
    {
      enableOptionMenu(true);
      AppMethodBeat.o(39764);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(39764);
  }
  
  public final void cwE()
  {
    AppMethodBeat.i(39776);
    if (this.sbK != null) {
      this.sbK.setVisibility(8);
    }
    if (this.rLo != null)
    {
      this.rLo.removeAllViews();
      this.rLo.setVisibility(8);
    }
    if (this.rLn != null) {
      this.rLn.ctw();
    }
    Kc();
    Y(null);
    AppMethodBeat.o(39776);
  }
  
  public int getLayoutId()
  {
    return 2130970893;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(39769);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.rLm != null) {
      this.rLm.clearFocus();
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(39769);
      return;
    }
    if (paramInt1 == 30764)
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
      {
        g.RL().Ru().set(ac.a.yKH, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(getContext(), "android.permission.ACCESS_COARSE_LOCATION", 64);
      }
      AppMethodBeat.o(39769);
      return;
    }
    if (this.rLn.j(paramInt1, paramIntent)) {
      cwD();
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(39769);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(39769);
        return;
      }
      getIntent().putExtras(paramIntent.getExtras());
      ap(paramIntent);
      AppMethodBeat.o(39769);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(39769);
        return;
      }
      getIntent().putExtras(paramIntent.getExtras());
      this.sbG.an(paramIntent);
      AppMethodBeat.o(39769);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(39769);
        return;
      }
      boolean bool = paramIntent.getBooleanExtra("bind_facebook_succ", false);
      paramIntent = this.rFe;
      if (bool)
      {
        paramIntent.sbs = true;
        paramIntent.setSyncFacebook(true);
      }
      AppMethodBeat.o(39769);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(39769);
        return;
      }
      getIntent().putExtras(paramIntent.getExtras());
      this.sbH.an(paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(39759);
    com.tencent.mm.pluginsdk.f.m(this);
    super.onCreate(paramBundle);
    setActionbarColor(getContext().getResources().getColor(2131690709));
    hideActionbarLine();
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    Kc();
    this.rLm = ((SnsEditText)findViewById(2131825537));
    Object localObject1;
    boolean bool1;
    if (!bo.isNullOrNil(getIntent().getStringExtra(e.j.yVi)))
    {
      this.rLm.setText(com.tencent.mm.ui.f.c.b.c(getContext(), getIntent().getStringExtra(e.j.yVi), this.rLm.getTextSize()));
      if (this.rHM == 8)
      {
        localObject1 = getIntent().getStringExtra(e.j.yVi);
        this.rLm.setText(com.tencent.mm.ui.f.c.b.c(getContext(), (CharSequence)localObject1, this.rLm.getTextSize()));
      }
      this.rLm.setPasterLen(getIntent().getIntExtra("KparseLen", 0));
      this.mYa = ((KeyboardLinearLayout)findViewById(2131821003));
      this.sbJ = ((SnsUploadSayFooter)findViewById(2131828085));
      this.sbJ.setMMEditText(this.rLm);
      this.sbJ.setVisibility(8);
      this.sbP = ((FrameLayout)findViewById(2131828083));
      this.sbP.post(new SnsUploadUI.17(this));
      this.rLm.setOnClickListener(new SnsUploadUI.18(this));
      this.rLm.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(39755);
          SnsUploadUI.l(SnsUploadUI.this);
          AppMethodBeat.o(39755);
          return false;
        }
      });
      localObject1 = new boolean[1];
      localObject1[0] = 0;
      this.rLm.addTextChangedListener(new SnsUploadUI.20(this, new boolean[] { true }));
      Object localObject2 = (WrapScollview)findViewById(2131824115);
      ((WrapScollview)localObject2).setContentView(this.rLm);
      ((WrapScollview)localObject2).setDoComputeScrollDeltaToGetChildRectOnScreen(false);
      Object localObject3 = bo.bf(getIntent().getStringExtra("reportSessionId"), "");
      this.rFe = ((SnsUploadConfigView)findViewById(2131828180));
      localObject2 = this.rFe;
      if ((this.rHM != 14) || (((String)localObject3).contains("wx5dfbe0a95623607b"))) {
        break label1010;
      }
      bool1 = true;
      label406:
      ((SnsUploadConfigView)localObject2).sby = bool1;
      if (bool1)
      {
        g.RM();
        g.RK().eHt.a(2842, (com.tencent.mm.ai.f)localObject2);
        localObject3 = new j();
        g.RM();
        g.RK().eHt.a((com.tencent.mm.ai.m)localObject3, 0);
      }
      ((SnsUploadConfigView)localObject2).sbz.wDi = -1000.0F;
      ((SnsUploadConfigView)localObject2).sbz.wDh = -1000.0F;
      if (!((SnsUploadConfigView)localObject2).rVp)
      {
        g.RM();
        int i = bo.g((Integer)g.RL().Ru().get(68404, null));
        if ((i & 0x2) == 0) {
          break label1015;
        }
        bool1 = true;
        label522:
        ((SnsUploadConfigView)localObject2).sbs = bool1;
        if ((i & 0x8) == 0) {
          break label1020;
        }
        bool1 = bool2;
        label538:
        ((SnsUploadConfigView)localObject2).sbt = bool1;
        if (!com.tencent.mm.au.b.aih()) {
          ((SnsUploadConfigView)localObject2).sbt = false;
        }
        if (!r.ZM()) {
          ((SnsUploadConfigView)localObject2).sbs = false;
        }
      }
      ((SnsUploadConfigView)localObject2).setSyncFacebook(false);
      ((SnsUploadConfigView)localObject2).cwx();
      ((SnsUploadConfigView)localObject2).cwz();
      ((SnsUploadConfigView)localObject2).cwy();
      if (((SnsUploadConfigView)localObject2).sbt) {
        ((SnsUploadConfigView)localObject2).sbA.a((a.a)localObject2);
      }
      if (this.rHM != 0)
      {
        localObject2 = this.rFe;
        ((SnsUploadConfigView)localObject2).sbn.setVisibility(8);
        ((SnsUploadConfigView)localObject2).sbo.setVisibility(8);
        ((SnsUploadConfigView)localObject2).sbp.setVisibility(8);
        ((SnsUploadConfigView)localObject2).sbq.setVisibility(8);
      }
      if (this.rHM == 9) {
        this.rFe.sbp.setVisibility(0);
      }
      setBackBtn(new SnsUploadUI.2(this));
      addTextOptionMenu(0, getString(2131303945), new SnsUploadUI.3(this, (boolean[])localObject1), null, new SnsUploadUI.4(this, (boolean[])localObject1), q.b.zby);
      findViewById(2131828169).setOnTouchListener(new SnsUploadUI.5(this));
      this.sbG = ((AtContactWidget)findViewById(2131828177));
      this.sbG.rFe = this.rFe;
      this.sbH = ((LocationWidget)findViewById(2131828082));
      this.sbH.setLocationWidgetListener(this);
      switch (this.rHM)
      {
      }
    }
    for (;;)
    {
      this.sbI.rFe = this.rFe;
      this.sbI.setRangeTipClickListener(new SnsUploadUI.6(this));
      this.sbH.an(getIntent());
      this.sbG.an(getIntent());
      ap(getIntent());
      hideVKB();
      Y(paramBundle);
      this.mYa.setOnkbdStateListener(new SnsUploadUI.1(this));
      com.tencent.mm.pluginsdk.f.n(this);
      AppMethodBeat.o(39759);
      return;
      if ((this.rLm == null) || (paramBundle == null)) {
        break;
      }
      localObject1 = paramBundle.getString("contentdesc");
      if (localObject1 == null) {
        break;
      }
      this.rLm.setText((CharSequence)localObject1);
      break;
      label1010:
      bool1 = false;
      break label406;
      label1015:
      bool1 = false;
      break label522;
      label1020:
      bool1 = false;
      break label538;
      this.sbI = ((RangeWidget)findViewById(2131828178));
      findViewById(2131828171).setVisibility(8);
      continue;
      this.sbI = ((RangeWidget)findViewById(2131828178));
      findViewById(2131828171).setVisibility(8);
      continue;
      this.sbI = ((RangeWidget)findViewById(2131828178));
      findViewById(2131828171).setVisibility(8);
      this.sbG.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39768);
    super.onDestroy();
    Object localObject;
    if (this.rFe != null)
    {
      localObject = this.rFe;
      g.RM();
      g.RK().eHt.b(2842, (com.tencent.mm.ai.f)localObject);
    }
    if (this.rLn != null) {
      this.rLn.ctw();
    }
    if (this.sbH != null) {
      this.sbH.stop();
    }
    if (this.sbJ != null)
    {
      localObject = this.sbJ;
      if (((SnsUploadSayFooter)localObject).eys != null)
      {
        ((SnsUploadSayFooter)localObject).eys.Ay();
        ((SnsUploadSayFooter)localObject).eys.destroy();
      }
    }
    this.sbO.clear();
    com.tencent.mm.plugin.normsg.a.b.pgQ.VX("ie_sns_upload");
    AppMethodBeat.o(39768);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(39761);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      paramKeyEvent = this.sbJ;
      if ((paramKeyEvent.bad()) || (paramKeyEvent.getVisibility() == 0)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        this.sbJ.bae();
        AppMethodBeat.o(39761);
        return true;
      }
      cwB();
      AppMethodBeat.o(39761);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(39761);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39766);
    if (this.rHM == 9)
    {
      String str = this.rLm.getText().toString().trim();
      g.RM();
      g.RL().Ru().set(68408, str);
      if (bo.isNullOrNil(str)) {
        break label94;
      }
      g.RM();
      g.RL().Ru().set(7489, Integer.valueOf(this.rLm.getPasterLen()));
    }
    for (;;)
    {
      super.hideVKB();
      super.onPause();
      AppMethodBeat.o(39766);
      return;
      label94:
      g.RM();
      g.RL().Ru().set(7489, Integer.valueOf(0));
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(39773);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SnsUploadUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(39773);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SnsUploadUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(39773);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        this.sbH.ctG();
        AppMethodBeat.o(39773);
        return;
      }
      h.a(this, getString(2131302073), getString(2131302083), getString(2131300996), getString(2131296888), false, new SnsUploadUI.8(this), new SnsUploadUI.9(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39767);
    super.onResume();
    this.sbJ.post(new SnsUploadUI.7(this));
    if ((this.rLn != null) && ((this.rLn instanceof ac)))
    {
      ac localac = (ac)this.rLn;
      if (localac.rIv != null)
      {
        if (!localac.rIC)
        {
          localac.ctN();
          AppMethodBeat.o(39767);
          return;
        }
        localac.ctO();
      }
    }
    AppMethodBeat.o(39767);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(39758);
    if (paramBundle != null)
    {
      if (this.rLm != null) {
        paramBundle.putString("contentdesc", this.rLm.getText().toString());
      }
      this.rLn.W(paramBundle);
    }
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(39758);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI
 * JD-Core Version:    0.7.0.1
 */