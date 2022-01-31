package com.tencent.mm.plugin.sns.ui.jsapi;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsapiSnsLabelUI
  extends MMActivity
  implements f
{
  public static int[] rRO = { 2131303862, 2131303860, 2131303856, 2131303847 };
  private AnimatedExpandableListView rRN;
  private ArrayList<String> rRP;
  private String rRQ;
  private String rRR;
  private int rRU;
  private boolean rRV;
  private boolean rRW;
  private boolean rRX;
  private boolean rRY;
  private int rRZ;
  private com.tencent.mm.ui.base.p rSa;
  private String rSb;
  private int rSc;
  private ArrayList<String> rSd;
  private ArrayList<String> rSe;
  private ArrayList<Long> rSf;
  private ArrayList<String[]> rSg;
  public int siV;
  public int siW;
  public int siX;
  public int siY;
  private List<String> siZ;
  a sja;
  List<String> sjb;
  
  public JsapiSnsLabelUI()
  {
    AppMethodBeat.i(40184);
    this.siV = 0;
    this.siW = 1;
    this.siX = 2;
    this.siY = 3;
    this.siZ = Arrays.asList("public,private,visible,invisible".split(","));
    this.rRU = this.siV;
    this.rRW = false;
    this.rRX = false;
    this.rRY = false;
    this.sjb = new ArrayList();
    AppMethodBeat.o(40184);
  }
  
  private String Fj(int paramInt)
  {
    AppMethodBeat.i(138390);
    if ((paramInt >= this.sjb.size()) || (paramInt < 0))
    {
      AppMethodBeat.o(138390);
      return "";
    }
    String str = (String)this.sjb.get(paramInt);
    AppMethodBeat.o(138390);
    return str;
  }
  
  private static String acn(String paramString)
  {
    AppMethodBeat.i(40195);
    Object localObject = bo.ih(paramString, ",");
    paramString = new JSONArray();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("username", str);
          localJSONObject.put("displayName", nE(str));
          localJSONObject.put("avatar", acp(str));
          paramString.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          ab.printErrStackTrace("MicroMsg.SnsLabelUI", localJSONException, "", new Object[0]);
        }
      }
    }
    paramString = paramString.toString();
    AppMethodBeat.o(40195);
    return paramString;
  }
  
  private static String aco(String paramString)
  {
    AppMethodBeat.i(40196);
    Object localObject1 = bo.ih(paramString, ",");
    paramString = new JSONObject();
    com.tencent.mm.plugin.label.a.b localb = com.tencent.mm.plugin.label.a.a.bKV();
    localObject1 = ((List)localObject1).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        JSONArray localJSONArray = new JSONArray();
        try
        {
          paramString.put((String)localObject2, localJSONArray);
          localObject2 = localb.RR(localb.RO((String)localObject2));
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              String str = (String)((Iterator)localObject2).next();
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("username", str);
              localJSONObject.put("displayName", nE(str));
              localJSONObject.put("avatar", acp(str));
              localJSONArray.put(localJSONObject);
            }
          }
        }
        catch (JSONException localJSONException)
        {
          ab.printErrStackTrace("MicroMsg.SnsLabelUI", localJSONException, "", new Object[0]);
        }
      }
    }
    paramString = paramString.toString();
    AppMethodBeat.o(40196);
    return paramString;
  }
  
  private static String acp(String paramString)
  {
    AppMethodBeat.i(40198);
    paramString = o.adg().rj(paramString);
    if (paramString != null)
    {
      paramString = paramString.acY();
      AppMethodBeat.o(40198);
      return paramString;
    }
    AppMethodBeat.o(40198);
    return "";
  }
  
  private void aq(Intent paramIntent)
  {
    AppMethodBeat.i(40194);
    cvz();
    paramIntent.putExtra("Klabel_name_list", aco(this.rRQ));
    paramIntent.putExtra("Kother_user_name_list", acn(this.rRR));
    paramIntent.putExtra("k_select_group", Fj(this.sja.rSq));
    AppMethodBeat.o(40194);
  }
  
  private boolean cvs()
  {
    AppMethodBeat.i(40190);
    boolean bool2 = false;
    int i = this.sja.rSq;
    boolean bool1;
    if (this.sja.rSq != this.rRU) {
      if (((i == this.siX) && ((this.sja.rSs.size() != 0) || (this.sja.rSu.size() != 0))) || ((i == this.siY) && ((this.sja.rSt.size() != 0) || (this.sja.rSv.size() != 0)))) {
        bool1 = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(40190);
      return bool1;
      if (i != this.siW)
      {
        bool1 = bool2;
        if (i != this.siV) {}
      }
      else
      {
        bool1 = true;
        continue;
        if ((i != this.siX) || (this.sja.rSs.size() == 0) || ((bo.d(this.sja.rSs, ",").equals(this.rRQ)) && (bo.d(this.sja.rSu, ",").equals(this.rRR))))
        {
          bool1 = bool2;
          if (i != this.siY) {
            continue;
          }
          bool1 = bool2;
          if (this.sja.rSt.size() == 0) {
            continue;
          }
          if (bo.d(this.sja.rSt, ",").equals(this.rRQ))
          {
            bool1 = bool2;
            if (bo.d(this.sja.rSv, ",").equals(this.rRR)) {
              continue;
            }
          }
        }
        bool1 = true;
      }
    }
  }
  
  private void cvt()
  {
    AppMethodBeat.i(40192);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ktag_range_index", this.rRU);
    aq(localIntent);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(40192);
  }
  
  private static int cvv()
  {
    AppMethodBeat.i(40202);
    g.RM();
    int i = ((Integer)g.RL().Ru().get(335874, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(40202);
    return i;
  }
  
  private static void cvw()
  {
    AppMethodBeat.i(40203);
    g.RM();
    int i = ((Integer)g.RL().Ru().get(335874, Integer.valueOf(0))).intValue();
    g.RM();
    g.RL().Ru().set(335874, Integer.valueOf(i + 1));
    AppMethodBeat.o(40203);
  }
  
  private void cvx()
  {
    AppMethodBeat.i(40204);
    com.tencent.mm.plugin.report.service.h.qsU.e(11455, new Object[] { "", "", Integer.valueOf(this.rSc), Integer.valueOf(0) });
    cvw();
    this.rSe = null;
    this.rRY = false;
    this.rRX = false;
    if ((this.rSa != null) && (this.rSa.isShowing())) {
      this.rSa.dismiss();
    }
    if (this.rRW)
    {
      this.rRW = false;
      AppMethodBeat.o(40204);
      return;
    }
    int i = 2131303870;
    if (cvv() > 1) {
      i = 2131303869;
    }
    com.tencent.mm.ui.base.h.a(this, i, 2131297018, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(40204);
  }
  
  private void cvy()
  {
    AppMethodBeat.i(40206);
    if ((this.rRP == null) || (this.rRP.isEmpty()))
    {
      if (this.sja.rSs != null) {
        this.sja.rSs.clear();
      }
      if (this.sja.rSt != null) {
        this.sja.rSt.clear();
      }
      AppMethodBeat.o(40206);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    String str;
    if ((this.sjb.size() > 0) && ("visible".equals(Fj(this.rRU))) && (this.sja.rSs != null))
    {
      localIterator = this.sja.rSs.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.rRP.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.sja.rSs.removeAll(localArrayList);
      AppMethodBeat.o(40206);
      return;
    }
    if ((this.sjb.size() > 0) && ("invisible".equals(Fj(this.rRU))))
    {
      localIterator = this.sja.rSt.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.rRP.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.sja.rSt.removeAll(localArrayList);
    }
    AppMethodBeat.o(40206);
  }
  
  private void cvz()
  {
    AppMethodBeat.i(40207);
    if ((this.rRP == null) || (this.rRP.isEmpty()))
    {
      this.rRQ = "";
      AppMethodBeat.o(40207);
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    if (this.rRQ != null)
    {
      ArrayList localArrayList2 = bo.P(this.rRQ.split(","));
      if (localArrayList2 != null)
      {
        Iterator localIterator = localArrayList2.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!this.rRP.contains(str)) {
            localArrayList1.add(str);
          }
        }
        localArrayList2.removeAll(localArrayList1);
        this.rRQ = bo.d(localArrayList2, ",");
      }
    }
    AppMethodBeat.o(40207);
  }
  
  private void dn(List<String[]> paramList)
  {
    AppMethodBeat.i(40205);
    if ((this.rSe == null) || (this.rSe.size() == 0))
    {
      AppMethodBeat.o(40205);
      return;
    }
    Iterator localIterator = this.rSe.iterator();
    paramList = paramList.iterator();
    ArrayList localArrayList1 = new ArrayList(this.rSe.size());
    ArrayList localArrayList2 = new ArrayList(this.rSe.size());
    while (localIterator.hasNext())
    {
      localArrayList1.add(com.tencent.mm.plugin.label.a.a.bKV().RO((String)localIterator.next()));
      localArrayList2.add(bo.d(Arrays.asList((Object[])paramList.next()), ","));
      this.rRX = true;
    }
    com.tencent.mm.plugin.label.a.a.bKV().j(localArrayList1, localArrayList2);
    AppMethodBeat.o(40205);
  }
  
  private static int[] ds(List<Integer> paramList)
  {
    AppMethodBeat.i(40187);
    int[] arrayOfInt = new int[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfInt[i] = ((Integer)paramList.get(i)).intValue();
      i += 1;
    }
    AppMethodBeat.o(40187);
    return arrayOfInt;
  }
  
  private void goBack()
  {
    AppMethodBeat.i(40191);
    if (cvs())
    {
      com.tencent.mm.ui.base.h.a(this, true, getString(2131303853), "", getString(2131303852), getString(2131303851), new JsapiSnsLabelUI.11(this), new JsapiSnsLabelUI.12(this));
      AppMethodBeat.o(40191);
      return;
    }
    cvt();
    AppMethodBeat.o(40191);
  }
  
  private static String nE(String paramString)
  {
    AppMethodBeat.i(40197);
    paramString = ((com.tencent.mm.plugin.messenger.a.b)g.E(com.tencent.mm.plugin.messenger.a.b.class)).nE(paramString);
    AppMethodBeat.o(40197);
    return paramString;
  }
  
  final void cvu()
  {
    AppMethodBeat.i(40193);
    Intent localIntent = new Intent();
    if (this.sja.rSq == this.siX)
    {
      this.rRQ = bo.d(this.sja.rSs, ",");
      this.rRR = bo.d(this.sja.rSu, ",");
      aq(localIntent);
    }
    for (;;)
    {
      localIntent.putExtra("k_select_group", Fj(this.sja.rSq));
      localIntent.putExtra("k_select_index", this.sja.rSq);
      localIntent.putExtra("Ktag_range_index", this.sja.rSq);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(40193);
      return;
      if (this.sja.rSq == this.siY)
      {
        this.rRQ = bo.d(this.sja.rSt, ",");
        this.rRR = bo.d(this.sja.rSv, ",");
        aq(localIntent);
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(40185);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      goBack();
      AppMethodBeat.o(40185);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(40185);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2130970831;
  }
  
  public void initView()
  {
    AppMethodBeat.i(40188);
    boolean bool = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
    this.rRN = ((AnimatedExpandableListView)findViewById(2131828013));
    this.rRP = ((ArrayList)com.tencent.mm.plugin.label.a.a.bKV().bKQ());
    this.sja.rSr = bool;
    this.sja.S(this.rRP);
    cvy();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    localLayoutParams.height = getResources().getDimensionPixelSize(2131427775);
    View localView = new View(this);
    localView.setLayoutParams(localLayoutParams);
    this.rRN.addHeaderView(localView);
    this.rRN.setAdapter(this.sja);
    this.rRN.setOnGroupClickListener(new JsapiSnsLabelUI.5(this));
    this.rRN.setOnChildClickListener(new JsapiSnsLabelUI.6(this));
    setBackBtn(new JsapiSnsLabelUI.7(this));
    addTextOptionMenu(0, getString(2131303849), new JsapiSnsLabelUI.8(this), null, q.b.zby);
    AppMethodBeat.o(40188);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(40189);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if ((paramInt2 == -1) && (paramInt1 == 4003))
    {
      ab.i("MicroMsg.SnsLabelUI", "the Activity completed");
      localObject = paramIntent.getStringExtra("Select_Contacts_To_Create_New_Label");
      if (!bo.isNullOrNil((String)localObject))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("Select_Contact", (String)localObject);
        d.b(getContext(), "label", ".ui.ContactLabelEditUI", paramIntent, 4002);
        AppMethodBeat.o(40189);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      this.rRR = new String(paramIntent);
      ab.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.rRZ == this.siX)
      {
        this.sja.rSu.clear();
        if (!bo.isNullOrNil(paramIntent))
        {
          paramIntent = bo.P(paramIntent.split(","));
          this.sja.rSu.addAll(paramIntent);
          this.sja.rSq = this.rRZ;
        }
      }
      for (;;)
      {
        this.sja.notifyDataSetChanged();
        this.rRN.expandGroup(this.rRZ);
        AppMethodBeat.o(40189);
        return;
        if (this.rRZ == this.siY)
        {
          this.sja.rSv.clear();
          if (!bo.isNullOrNil(paramIntent))
          {
            paramIntent = bo.P(paramIntent.split(","));
            this.sja.rSv.addAll(paramIntent);
            this.sja.rSq = this.rRZ;
          }
        }
      }
    }
    if ((paramInt2 == -1) && (paramInt1 == 4001))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      ab.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (!bo.isNullOrNil(paramIntent))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("Select_Contact", paramIntent);
        d.b(this, "label", ".ui.ContactLabelEditUI", (Intent)localObject, 4002);
      }
      AppMethodBeat.o(40189);
      return;
    }
    if ((paramInt2 == 0) && (paramInt1 == 4002) && (paramIntent != null))
    {
      localObject = paramIntent.getStringExtra("k_sns_label_add_label");
      this.rSb = paramIntent.getStringExtra("k_sns_label_add_label");
      this.rRN.postDelayed(new JsapiSnsLabelUI.10(this, (String)localObject), 600L);
    }
    AppMethodBeat.o(40189);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(40186);
    super.onCreate(paramBundle);
    setMMTitle(2131304001);
    g.RM();
    g.RK().eHt.a(292, this);
    g.RM();
    g.RK().eHt.a(635, this);
    g.RM();
    g.RK().eHt.a(638, this);
    g.RM();
    g.RK().eHt.a(290, this);
    this.sja = new a(this);
    this.sja.sjh = false;
    this.sja.sjg = new JsapiSnsLabelUI.1(this);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      this.rRU = this.siV;
      this.sja.style = 0;
      this.rRQ = null;
      this.rRR = null;
      this.sja.rSq = this.rRU;
      if (this.sja.style == 1) {
        findViewById(2131828012).setBackgroundResource(2131689763);
      }
      if (this.rRU != this.siX) {
        break label802;
      }
      if (!TextUtils.isEmpty(this.rRQ)) {
        this.sja.rSs = bo.P(this.rRQ.split(","));
      }
      if (!TextUtils.isEmpty(this.rRR)) {
        this.sja.rSu = bo.P(this.rRR.split(","));
      }
    }
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList;
    for (;;)
    {
      g.RM();
      this.rRV = ((Boolean)g.RL().Ru().get(335873, Boolean.TRUE)).booleanValue();
      if (this.rRV)
      {
        this.rRX = true;
        this.rRY = true;
        if (cvv() > 0) {
          this.rRW = true;
        }
        g.RM();
        g.RK().eHt.a(new v(1), 0);
      }
      initView();
      localObject1 = getIntent();
      if (localObject1 == null) {
        break label1265;
      }
      paramBundle = ((Intent)localObject1).getStringExtra("k_select_group");
      boolean bool1 = ((Intent)localObject1).getBooleanExtra("k_show_public", true);
      boolean bool2 = ((Intent)localObject1).getBooleanExtra("k_show_private", true);
      boolean bool3 = ((Intent)localObject1).getBooleanExtra("k_show_include", true);
      boolean bool4 = ((Intent)localObject1).getBooleanExtra("k_show_exclude", true);
      localObject2 = new int[4];
      Object tmp413_411 = localObject2;
      tmp413_411[0] = 2131303862;
      Object tmp418_413 = tmp413_411;
      tmp418_413[1] = 2131303860;
      Object tmp423_418 = tmp418_413;
      tmp423_418[2] = 2131303856;
      Object tmp428_423 = tmp423_418;
      tmp428_423[3] = 2131303847;
      tmp428_423;
      this.sjb.clear();
      localObject1 = new ArrayList();
      localArrayList = new ArrayList();
      if (bool1)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[0]));
        localArrayList.add(Integer.valueOf(localObject2[0]));
        this.sjb.add(this.siZ.get(0));
      }
      if (bool2)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[1]));
        localArrayList.add(Integer.valueOf(localObject2[1]));
        this.sjb.add(this.siZ.get(1));
      }
      if (bool3)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[2]));
        localArrayList.add(Integer.valueOf(localObject2[2]));
        this.sjb.add(this.siZ.get(2));
      }
      if (bool4)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[3]));
        localArrayList.add(Integer.valueOf(localObject2[3]));
        this.sjb.add(this.siZ.get(3));
      }
      if (this.sjb.size() != 0) {
        break label874;
      }
      finish();
      AppMethodBeat.o(40186);
      return;
      if (paramBundle.hasExtra("k_title")) {
        setMMTitle(paramBundle.getStringExtra("k_title"));
      }
      this.rRU = paramBundle.getIntExtra("KLabel_range_index", this.siV);
      this.sja.style = paramBundle.getIntExtra("k_sns_label_ui_style", 0);
      this.rRQ = paramBundle.getStringExtra("Klabel_name_list");
      this.rRR = paramBundle.getStringExtra("Kother_user_name_list");
      if (TextUtils.isEmpty(paramBundle.getStringExtra("k_sns_label_ui_title"))) {
        break;
      }
      setMMTitle(paramBundle.getStringExtra("k_sns_label_ui_title"));
      break;
      label802:
      if (this.rRU == this.siY)
      {
        if (!TextUtils.isEmpty(this.rRQ)) {
          this.sja.rSt = bo.P(this.rRQ.split(","));
        }
        if (!TextUtils.isEmpty(this.rRR)) {
          this.sja.rSv = bo.P(this.rRR.split(","));
        }
      }
    }
    label874:
    this.siV = this.sjb.indexOf("public");
    this.siW = this.sjb.indexOf("private");
    this.siX = this.sjb.indexOf("visible");
    this.siY = this.sjb.indexOf("invisible");
    if (this.sja != null)
    {
      localObject2 = this.sja;
      List localList = this.sjb;
      ((a)localObject2).sjf = localList;
      ((a)localObject2).siV = localList.indexOf("public");
      ((a)localObject2).siW = localList.indexOf("private");
      ((a)localObject2).siX = localList.indexOf("visible");
      ((a)localObject2).siY = localList.indexOf("invisible");
      this.sja.sje = ((List)localObject1).size();
      this.sja.rRO = ds((List)localObject1);
      this.sja.rSo = ds(localArrayList);
      if (!TextUtils.isEmpty(paramBundle))
      {
        this.sja.rSq = this.sjb.indexOf(paramBundle);
        if (paramBundle.equals("visible"))
        {
          if (!TextUtils.isEmpty(this.rRQ)) {
            this.sja.rSs = bo.P(this.rRQ.split(","));
          }
          if (!TextUtils.isEmpty(this.rRR)) {
            this.sja.rSu = bo.P(this.rRR.split(","));
          }
          this.rRN.expandGroup(this.sjb.indexOf(paramBundle));
          AppMethodBeat.o(40186);
          return;
        }
        if (paramBundle.equals("invisible"))
        {
          if (!TextUtils.isEmpty(this.rRQ)) {
            this.sja.rSt = bo.P(this.rRQ.split(","));
          }
          if (!TextUtils.isEmpty(this.rRR)) {
            this.sja.rSv = bo.P(this.rRR.split(","));
          }
          this.rRN.expandGroup(this.sjb.indexOf(paramBundle));
        }
      }
    }
    label1265:
    AppMethodBeat.o(40186);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(40199);
    g.RM();
    g.RK().eHt.b(292, this);
    g.RM();
    g.RK().eHt.b(635, this);
    g.RM();
    g.RK().eHt.b(638, this);
    g.RM();
    g.RK().eHt.b(290, this);
    super.onDestroy();
    AppMethodBeat.o(40199);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(40200);
    if ((this.sja != null) && (this.rSb == null) && (this.rRN != null)) {
      this.rRN.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(40173);
          com.tencent.mm.plugin.label.a.a.bKV().ahN();
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, (ArrayList)com.tencent.mm.plugin.label.a.a.bKV().bKQ());
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).S(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
          JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
          if (((JsapiSnsLabelUI.j(JsapiSnsLabelUI.this) == null) || (JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).size() == 0)) && ((JsapiSnsLabelUI.p(JsapiSnsLabelUI.this) == null) || (JsapiSnsLabelUI.p(JsapiSnsLabelUI.this).length() == 0)) && (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).rSq != JsapiSnsLabelUI.this.siV) && (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).rSq != JsapiSnsLabelUI.this.siW)) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).rSq = JsapiSnsLabelUI.this.siV;
          }
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).notifyDataSetChanged();
          JsapiSnsLabelUI.m(JsapiSnsLabelUI.this);
          AppMethodBeat.o(40173);
        }
      }, 600L);
    }
    super.onResume();
    AppMethodBeat.o(40200);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(40201);
    ab.i("MicroMsg.SnsLabelUI", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!this.rRX)
    {
      AppMethodBeat.o(40201);
      return;
    }
    switch (paramm.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(40201);
      return;
      Object localObject;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = ag.cpl().getCursor();
        this.rSc = ((Cursor)localObject).getCount();
        if (this.rSc > 0)
        {
          ((Cursor)localObject).moveToFirst();
          t localt = new t();
          paramInt1 = ((Cursor)localObject).getCount();
          this.rSe = new ArrayList(paramInt1);
          this.rSd = new ArrayList(paramInt1);
          this.rSg = new ArrayList(paramInt1);
          this.rSf = new ArrayList(paramInt1);
          if (!((Cursor)localObject).isAfterLast())
          {
            localt.convertFrom((Cursor)localObject);
            if ((localt.field_memberList != null) && (localt.field_memberList.length() != 0))
            {
              this.rSg.add(localt.field_memberList.split(","));
              paramm = localt.field_tagName;
              ArrayList localArrayList = this.rSe;
              paramString = com.tencent.mm.plugin.label.a.a.bKV().bKS();
              if (paramString == null)
              {
                paramString = paramm;
                label297:
                localArrayList.add(paramString);
                this.rSd.add(paramm);
                this.rSf.add(Long.valueOf(localt.field_tagId));
              }
            }
            for (;;)
            {
              ((Cursor)localObject).moveToNext();
              break;
              if (!paramString.contains(paramm))
              {
                paramString = paramm;
                break label297;
              }
              paramString = String.format(getString(2131303850), new Object[] { paramm });
              break label297;
              ab.e("MicroMsg.SnsLabelUI", "dz:snstaginfo memberlist is null.");
            }
          }
          ((Cursor)localObject).close();
          if (this.rSd.size() != 0) {
            break label508;
          }
          paramInt1 = 0;
          if (paramInt1 != 0) {}
        }
        else if (this.rRY)
        {
          this.sja.rSq = this.rRZ;
          this.rRN.Ro(this.rRZ);
          g.RM();
          g.RL().Ru().set(335873, Boolean.FALSE);
        }
        ((Cursor)localObject).close();
        if (this.rRW)
        {
          this.rRX = true;
          com.tencent.mm.plugin.label.a.a.bKV().cc(this.rSe);
        }
      }
      for (;;)
      {
        this.rRY = false;
        AppMethodBeat.o(40201);
        return;
        label508:
        paramInt1 = 1;
        break;
        this.rRX = false;
        continue;
        cvx();
        ab.i("MicroMsg.SnsLabelUI", "dz: error at get sns tag list!");
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        dn(this.rSg);
        AppMethodBeat.o(40201);
        return;
      }
      cvx();
      ab.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
      AppMethodBeat.o(40201);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.rSd.iterator();
        paramm = this.rSf.iterator();
        while (paramString.hasNext())
        {
          long l = ((Long)paramm.next()).longValue();
          localObject = (String)paramString.next();
          if (l != 0L)
          {
            g.RM();
            g.RK().eHt.a(new x(l, (String)localObject), 0);
          }
        }
        g.RM();
        g.RL().Ru().set(335874, Integer.valueOf(0));
        this.rRP = ((ArrayList)com.tencent.mm.plugin.label.a.a.bKV().bKQ());
        paramString = com.tencent.mm.plugin.report.service.h.qsU;
        paramInt2 = this.rSc;
        if (this.rSe == null) {}
        for (paramInt1 = 0;; paramInt1 = this.rSe.size())
        {
          paramString.e(11455, new Object[] { "", "", Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
          this.rRN.postDelayed(new JsapiSnsLabelUI.3(this), 600L);
          g.RM();
          g.RL().Ru().set(335873, Boolean.FALSE);
          AppMethodBeat.o(40201);
          return;
        }
      }
      cvx();
      ab.i("MicroMsg.SnsLabelUI", "dz: error at modify label list!");
      AppMethodBeat.o(40201);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        ab.i("MicroMsg.SnsLabelUI", "dz: error at delete tag list!");
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI
 * JD-Core Version:    0.7.0.1
 */