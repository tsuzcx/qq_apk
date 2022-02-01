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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsapiSnsLabelUI
  extends MMActivity
  implements f
{
  public static int[] AvA = { 2131763871, 2131763869, 2131763865, 2131763856 };
  public int APl;
  public int APm;
  public int APn;
  public int APo;
  private List<String> APp;
  a APq;
  List<String> APr;
  private ArrayList<String> AvB;
  private String AvC;
  private String AvD;
  private int AvG;
  private boolean AvH;
  private boolean AvI;
  private boolean AvJ;
  private boolean AvK;
  private int AvL;
  private com.tencent.mm.ui.base.p AvM;
  private String AvN;
  private int AvO;
  private ArrayList<String> AvP;
  private ArrayList<String> AvQ;
  private ArrayList<Long> AvR;
  private ArrayList<String[]> AvS;
  private AnimatedExpandableListView Avz;
  
  public JsapiSnsLabelUI()
  {
    AppMethodBeat.i(100142);
    this.APl = 0;
    this.APm = 1;
    this.APn = 2;
    this.APo = 3;
    this.APp = Arrays.asList("public,private,visible,invisible".split(","));
    this.AvG = this.APl;
    this.AvI = false;
    this.AvJ = false;
    this.AvK = false;
    this.APr = new ArrayList();
    AppMethodBeat.o(100142);
  }
  
  private String Si(int paramInt)
  {
    AppMethodBeat.i(100153);
    if ((paramInt >= this.APr.size()) || (paramInt < 0))
    {
      AppMethodBeat.o(100153);
      return "";
    }
    String str = (String)this.APr.get(paramInt);
    AppMethodBeat.o(100153);
    return str;
  }
  
  private static String aCs(String paramString)
  {
    AppMethodBeat.i(100154);
    Object localObject = bu.lV(paramString, ",");
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
          localJSONObject.put("displayName", zP(str));
          localJSONObject.put("avatar", aCu(str));
          paramString.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          ae.printErrStackTrace("MicroMsg.SnsLabelUI", localJSONException, "", new Object[0]);
        }
      }
    }
    paramString = paramString.toString();
    AppMethodBeat.o(100154);
    return paramString;
  }
  
  private static String aCt(String paramString)
  {
    AppMethodBeat.i(100155);
    Object localObject1 = bu.lV(paramString, ",");
    paramString = new JSONObject();
    com.tencent.mm.plugin.label.a.b localb = com.tencent.mm.plugin.label.a.a.dig();
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
          localObject2 = localb.apr(localb.apo((String)localObject2));
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              String str = (String)((Iterator)localObject2).next();
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("username", str);
              localJSONObject.put("displayName", zP(str));
              localJSONObject.put("avatar", aCu(str));
              localJSONArray.put(localJSONObject);
            }
          }
        }
        catch (JSONException localJSONException)
        {
          ae.printErrStackTrace("MicroMsg.SnsLabelUI", localJSONException, "", new Object[0]);
        }
      }
    }
    paramString = paramString.toString();
    AppMethodBeat.o(100155);
    return paramString;
  }
  
  private static String aCu(String paramString)
  {
    AppMethodBeat.i(100157);
    paramString = com.tencent.mm.aj.p.aEN().DL(paramString);
    if (paramString != null)
    {
      paramString = paramString.aEH();
      AppMethodBeat.o(100157);
      return paramString;
    }
    AppMethodBeat.o(100157);
    return "";
  }
  
  private void aS(Intent paramIntent)
  {
    AppMethodBeat.i(100152);
    efR();
    paramIntent.putExtra("Klabel_name_list", aCt(this.AvC));
    paramIntent.putExtra("Kother_user_name_list", aCs(this.AvD));
    paramIntent.putExtra("k_select_group", Si(this.APq.Awc));
    AppMethodBeat.o(100152);
  }
  
  private boolean efK()
  {
    AppMethodBeat.i(100148);
    boolean bool2 = false;
    int i = this.APq.Awc;
    boolean bool1;
    if (this.APq.Awc != this.AvG) {
      if (((i == this.APn) && ((this.APq.Awe.size() != 0) || (this.APq.Awg.size() != 0))) || ((i == this.APo) && ((this.APq.Awf.size() != 0) || (this.APq.Awh.size() != 0)))) {
        bool1 = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(100148);
      return bool1;
      if (i != this.APm)
      {
        bool1 = bool2;
        if (i != this.APl) {}
      }
      else
      {
        bool1 = true;
        continue;
        if ((i != this.APn) || (this.APq.Awe.size() == 0) || ((bu.m(this.APq.Awe, ",").equals(this.AvC)) && (bu.m(this.APq.Awg, ",").equals(this.AvD))))
        {
          bool1 = bool2;
          if (i != this.APo) {
            continue;
          }
          bool1 = bool2;
          if (this.APq.Awf.size() == 0) {
            continue;
          }
          if (bu.m(this.APq.Awf, ",").equals(this.AvC))
          {
            bool1 = bool2;
            if (bu.m(this.APq.Awh, ",").equals(this.AvD)) {
              continue;
            }
          }
        }
        bool1 = true;
      }
    }
  }
  
  private void efL()
  {
    AppMethodBeat.i(100150);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ktag_range_index", this.AvG);
    aS(localIntent);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(100150);
  }
  
  private static int efN()
  {
    AppMethodBeat.i(100161);
    com.tencent.mm.kernel.g.ajS();
    int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(335874, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(100161);
    return i;
  }
  
  private static void efO()
  {
    AppMethodBeat.i(100162);
    com.tencent.mm.kernel.g.ajS();
    int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(335874, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().ajA().set(335874, Integer.valueOf(i + 1));
    AppMethodBeat.o(100162);
  }
  
  private void efP()
  {
    AppMethodBeat.i(100163);
    com.tencent.mm.plugin.report.service.g.yxI.f(11455, new Object[] { "", "", Integer.valueOf(this.AvO), Integer.valueOf(0) });
    efO();
    this.AvQ = null;
    this.AvK = false;
    this.AvJ = false;
    if ((this.AvM != null) && (this.AvM.isShowing())) {
      this.AvM.dismiss();
    }
    if (this.AvI)
    {
      this.AvI = false;
      AppMethodBeat.o(100163);
      return;
    }
    int i = 2131763879;
    if (efN() > 1) {
      i = 2131763878;
    }
    h.a(this, i, 2131755835, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(100163);
  }
  
  private void efQ()
  {
    AppMethodBeat.i(100165);
    if ((this.AvB == null) || (this.AvB.isEmpty()))
    {
      if (this.APq.Awe != null) {
        this.APq.Awe.clear();
      }
      if (this.APq.Awf != null) {
        this.APq.Awf.clear();
      }
      AppMethodBeat.o(100165);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    String str;
    if ((this.APr.size() > 0) && ("visible".equals(Si(this.AvG))) && (this.APq.Awe != null))
    {
      localIterator = this.APq.Awe.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.AvB.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.APq.Awe.removeAll(localArrayList);
      AppMethodBeat.o(100165);
      return;
    }
    if ((this.APr.size() > 0) && ("invisible".equals(Si(this.AvG))))
    {
      localIterator = this.APq.Awf.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.AvB.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.APq.Awf.removeAll(localArrayList);
    }
    AppMethodBeat.o(100165);
  }
  
  private void efR()
  {
    AppMethodBeat.i(100166);
    if ((this.AvB == null) || (this.AvB.isEmpty()))
    {
      this.AvC = "";
      AppMethodBeat.o(100166);
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    if (this.AvC != null)
    {
      ArrayList localArrayList2 = bu.U(this.AvC.split(","));
      if (localArrayList2 != null)
      {
        Iterator localIterator = localArrayList2.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!this.AvB.contains(str)) {
            localArrayList1.add(str);
          }
        }
        localArrayList2.removeAll(localArrayList1);
        this.AvC = bu.m(localArrayList2, ",");
      }
    }
    AppMethodBeat.o(100166);
  }
  
  private void gg(List<String[]> paramList)
  {
    AppMethodBeat.i(100164);
    if ((this.AvQ == null) || (this.AvQ.size() == 0))
    {
      AppMethodBeat.o(100164);
      return;
    }
    Iterator localIterator = this.AvQ.iterator();
    paramList = paramList.iterator();
    ArrayList localArrayList1 = new ArrayList(this.AvQ.size());
    ArrayList localArrayList2 = new ArrayList(this.AvQ.size());
    while (localIterator.hasNext())
    {
      localArrayList1.add(com.tencent.mm.plugin.label.a.a.dig().apo((String)localIterator.next()));
      localArrayList2.add(bu.m(Arrays.asList((Object[])paramList.next()), ","));
      this.AvJ = true;
    }
    com.tencent.mm.plugin.label.a.a.dig().n(localArrayList1, localArrayList2);
    AppMethodBeat.o(100164);
  }
  
  private static int[] gm(List<Integer> paramList)
  {
    AppMethodBeat.i(100145);
    int[] arrayOfInt = new int[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfInt[i] = ((Integer)paramList.get(i)).intValue();
      i += 1;
    }
    AppMethodBeat.o(100145);
    return arrayOfInt;
  }
  
  private void goBack()
  {
    AppMethodBeat.i(100149);
    if (efK())
    {
      h.a(this, true, getString(2131763862), "", getString(2131763861), getString(2131763860), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(100140);
          JsapiSnsLabelUI.n(JsapiSnsLabelUI.this);
          AppMethodBeat.o(100140);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(100141);
          JsapiSnsLabelUI.o(JsapiSnsLabelUI.this);
          AppMethodBeat.o(100141);
        }
      });
      AppMethodBeat.o(100149);
      return;
    }
    efL();
    AppMethodBeat.o(100149);
  }
  
  private static String zP(String paramString)
  {
    AppMethodBeat.i(100156);
    paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zP(paramString);
    AppMethodBeat.o(100156);
    return paramString;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(100143);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      goBack();
      AppMethodBeat.o(100143);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(100143);
    return bool;
  }
  
  final void efM()
  {
    AppMethodBeat.i(100151);
    Intent localIntent = new Intent();
    if (this.APq.Awc == this.APn)
    {
      this.AvC = bu.m(this.APq.Awe, ",");
      this.AvD = bu.m(this.APq.Awg, ",");
      aS(localIntent);
    }
    for (;;)
    {
      localIntent.putExtra("k_select_group", Si(this.APq.Awc));
      localIntent.putExtra("k_select_index", this.APq.Awc);
      localIntent.putExtra("Ktag_range_index", this.APq.Awc);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(100151);
      return;
      if (this.APq.Awc == this.APo)
      {
        this.AvC = bu.m(this.APq.Awf, ",");
        this.AvD = bu.m(this.APq.Awh, ",");
        aS(localIntent);
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131495554;
  }
  
  public void initView()
  {
    AppMethodBeat.i(100146);
    boolean bool = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
    this.Avz = ((AnimatedExpandableListView)findViewById(2131304991));
    this.AvB = ((ArrayList)com.tencent.mm.plugin.label.a.a.dig().dib());
    this.APq.Awd = bool;
    this.APq.aA(this.AvB);
    efQ();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    localLayoutParams.height = getResources().getDimensionPixelSize(2131165483);
    View localView = new View(this);
    localView.setLayoutParams(localLayoutParams);
    this.Avz.addHeaderView(localView);
    this.Avz.setAdapter(this.APq);
    this.Avz.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
    {
      public final boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100134);
        int i = JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awc;
        ae.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt) });
        if ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, paramAnonymousInt).equals("visible")) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, paramAnonymousInt).equals("invisible")))
        {
          if ((JsapiSnsLabelUI.b(JsapiSnsLabelUI.this) != null) && (JsapiSnsLabelUI.b(JsapiSnsLabelUI.this).size() != 0) && (JsapiSnsLabelUI.ehR() == 0))
          {
            JsapiSnsLabelUI.b(JsapiSnsLabelUI.this, paramAnonymousInt);
            JsapiSnsLabelUI.c(JsapiSnsLabelUI.this);
            ae.i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
            AppMethodBeat.o(100134);
            return true;
          }
          if (JsapiSnsLabelUI.d(JsapiSnsLabelUI.this))
          {
            JsapiSnsLabelUI.e(JsapiSnsLabelUI.this);
            JsapiSnsLabelUI.b(JsapiSnsLabelUI.this, paramAnonymousInt);
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, h.b(JsapiSnsLabelUI.this, JsapiSnsLabelUI.this.getString(2131763867), false, null));
            ae.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
            AppMethodBeat.o(100134);
            return true;
          }
          if ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awb == null) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awb.size() == 0))
          {
            JsapiSnsLabelUI.b(JsapiSnsLabelUI.this, paramAnonymousInt);
            JsapiSnsLabelUI.f(JsapiSnsLabelUI.this);
            ae.i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
            AppMethodBeat.o(100134);
            return true;
          }
          if (i == paramAnonymousInt)
          {
            if (JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).isGroupExpanded(paramAnonymousInt)) {
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).agg(paramAnonymousInt);
            }
            for (;;)
            {
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awc = paramAnonymousInt;
              AppMethodBeat.o(100134);
              return true;
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).agf(paramAnonymousInt);
            }
          }
          if (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("visible"))
          {
            JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).collapseGroup(i);
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awe.clear();
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awg.clear();
          }
          for (;;)
          {
            JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100133);
                JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).agf(paramAnonymousInt);
                AppMethodBeat.o(100133);
              }
            });
            break;
            if (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("invisible"))
            {
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).collapseGroup(i);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awf.clear();
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awh.clear();
            }
          }
        }
        if ((i >= 0) && ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("visible")) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("invisible")))) {
          JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).agg(i);
        }
        JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awc = paramAnonymousInt;
        AppMethodBeat.o(100134);
        return false;
      }
    });
    this.Avz.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
    {
      public final boolean onChildClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong)
      {
        AppMethodBeat.i(100135);
        if (paramAnonymousInt2 == JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).getChildrenCount(paramAnonymousInt1) - 1)
        {
          JsapiSnsLabelUI.b(JsapiSnsLabelUI.this, paramAnonymousInt1);
          JsapiSnsLabelUI.f(JsapiSnsLabelUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(100135);
          return false;
          paramAnonymousExpandableListView = (String)JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).getChild(paramAnonymousInt1, paramAnonymousInt2);
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this);
          a.aCg(paramAnonymousExpandableListView);
          if (paramAnonymousInt1 == JsapiSnsLabelUI.this.APn) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, 1, JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awe, paramAnonymousExpandableListView, paramAnonymousView);
          } else if (paramAnonymousInt1 == JsapiSnsLabelUI.this.APo) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, 2, JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awf, paramAnonymousExpandableListView, paramAnonymousView);
          }
        }
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(100136);
        JsapiSnsLabelUI.h(JsapiSnsLabelUI.this);
        AppMethodBeat.o(100136);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131763858), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(100137);
        paramAnonymousMenuItem = JsapiSnsLabelUI.this;
        String str1 = bu.m(paramAnonymousMenuItem.APq.Awe, ",");
        String str2 = bu.m(paramAnonymousMenuItem.APq.Awg, ",");
        String str3 = bu.m(paramAnonymousMenuItem.APq.Awf, ",");
        String str4 = bu.m(paramAnonymousMenuItem.APq.Awh, ",");
        if (((paramAnonymousMenuItem.APq.Awc == paramAnonymousMenuItem.APn) && (paramAnonymousMenuItem.APq.Awe.size() == 0) && (paramAnonymousMenuItem.APq.Awg.size() == 0)) || ((paramAnonymousMenuItem.APq.Awc == paramAnonymousMenuItem.APo) && (paramAnonymousMenuItem.APq.Awf.size() == 0) && (paramAnonymousMenuItem.APq.Awh.size() == 0))) {
          h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131763868), "", paramAnonymousMenuItem.getString(2131763880), null);
        }
        for (;;)
        {
          AppMethodBeat.o(100137);
          return true;
          if (((paramAnonymousMenuItem.APq.Awc == paramAnonymousMenuItem.APn) && (bu.isNullOrNil(str1)) && (bu.isNullOrNil(str2))) || ((paramAnonymousMenuItem.APq.Awc == paramAnonymousMenuItem.APo) && (bu.isNullOrNil(str3)) && (bu.isNullOrNil(str4)))) {
            h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131763868), "", paramAnonymousMenuItem.getString(2131763880), null);
          } else {
            paramAnonymousMenuItem.efM();
          }
        }
      }
    }, null, s.b.JwA);
    AppMethodBeat.o(100146);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(100147);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if ((paramInt2 == -1) && (paramInt1 == 4003))
    {
      ae.i("MicroMsg.SnsLabelUI", "the Activity completed");
      localObject = paramIntent.getStringExtra("Select_Contacts_To_Create_New_Label");
      if (!bu.isNullOrNil((String)localObject))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("Select_Contact", (String)localObject);
        d.b(getContext(), "label", ".ui.ContactLabelEditUI", paramIntent, 4002);
        AppMethodBeat.o(100147);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      this.AvD = new String(paramIntent);
      ae.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.AvL == this.APn)
      {
        this.APq.Awg.clear();
        if (!bu.isNullOrNil(paramIntent))
        {
          paramIntent = bu.U(paramIntent.split(","));
          this.APq.Awg.addAll(paramIntent);
          this.APq.Awc = this.AvL;
        }
      }
      for (;;)
      {
        this.APq.notifyDataSetChanged();
        this.Avz.expandGroup(this.AvL);
        AppMethodBeat.o(100147);
        return;
        if (this.AvL == this.APo)
        {
          this.APq.Awh.clear();
          if (!bu.isNullOrNil(paramIntent))
          {
            paramIntent = bu.U(paramIntent.split(","));
            this.APq.Awh.addAll(paramIntent);
            this.APq.Awc = this.AvL;
          }
        }
      }
    }
    if ((paramInt2 == -1) && (paramInt1 == 4001))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      ae.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (!bu.isNullOrNil(paramIntent))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("Select_Contact", paramIntent);
        d.b(this, "label", ".ui.ContactLabelEditUI", (Intent)localObject, 4002);
      }
      AppMethodBeat.o(100147);
      return;
    }
    if ((paramInt2 == 0) && (paramInt1 == 4002) && (paramIntent != null))
    {
      localObject = paramIntent.getStringExtra("k_sns_label_add_label");
      this.AvN = paramIntent.getStringExtra("k_sns_label_add_label");
      this.Avz.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100139);
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, (ArrayList)com.tencent.mm.plugin.label.a.a.dig().dib());
          if (JsapiSnsLabelUI.j(JsapiSnsLabelUI.this) == null) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, new ArrayList());
          }
          if (!bu.isNullOrNil(this.AvW)) {
            if (!JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).contains(this.AvW)) {
              JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).add(this.AvW);
            }
          }
          for (int i = JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).indexOf(this.AvW);; i = -1)
          {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).aA(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
            JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awc = JsapiSnsLabelUI.l(JsapiSnsLabelUI.this);
            if ((!bu.isNullOrNil(this.AvW)) && (i != -1))
            {
              if (JsapiSnsLabelUI.l(JsapiSnsLabelUI.this) != JsapiSnsLabelUI.this.APn) {
                break label252;
              }
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awe.add(this.AvW);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awg.clear();
            }
            for (;;)
            {
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).notifyDataSetChanged();
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).expandGroup(JsapiSnsLabelUI.l(JsapiSnsLabelUI.this));
              JsapiSnsLabelUI.m(JsapiSnsLabelUI.this);
              AppMethodBeat.o(100139);
              return;
              label252:
              if (JsapiSnsLabelUI.l(JsapiSnsLabelUI.this) == JsapiSnsLabelUI.this.APo)
              {
                JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awf.add(this.AvW);
                JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awh.clear();
              }
            }
          }
        }
      }, 600L);
    }
    AppMethodBeat.o(100147);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(100144);
    super.onCreate(paramBundle);
    setMMTitle(2131764018);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(292, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(635, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(638, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(290, this);
    this.APq = new a(this);
    this.APq.APx = false;
    this.APq.APw = new a.b()
    {
      public final void a(a.c paramAnonymousc)
      {
        AppMethodBeat.i(100130);
        int i = paramAnonymousc.Awp;
        int j = paramAnonymousc.Awq;
        JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i, j);
        AppMethodBeat.o(100130);
      }
    };
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      this.AvG = this.APl;
      this.APq.style = 0;
      this.AvC = null;
      this.AvD = null;
      this.APq.Awc = this.AvG;
      if (this.APq.style == 1) {
        findViewById(2131304992).setBackgroundResource(2131100017);
      }
      if (this.AvG != this.APn) {
        break label802;
      }
      if (!TextUtils.isEmpty(this.AvC)) {
        this.APq.Awe = bu.U(this.AvC.split(","));
      }
      if (!TextUtils.isEmpty(this.AvD)) {
        this.APq.Awg = bu.U(this.AvD.split(","));
      }
    }
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList;
    for (;;)
    {
      com.tencent.mm.kernel.g.ajS();
      this.AvH = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(335873, Boolean.TRUE)).booleanValue();
      if (this.AvH)
      {
        this.AvJ = true;
        this.AvK = true;
        if (efN() > 0) {
          this.AvI = true;
        }
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(new com.tencent.mm.plugin.sns.model.v(1), 0);
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
      tmp413_411[0] = 2131763871;
      Object tmp418_413 = tmp413_411;
      tmp418_413[1] = 2131763869;
      Object tmp423_418 = tmp418_413;
      tmp423_418[2] = 2131763865;
      Object tmp428_423 = tmp423_418;
      tmp428_423[3] = 2131763856;
      tmp428_423;
      this.APr.clear();
      localObject1 = new ArrayList();
      localArrayList = new ArrayList();
      if (bool1)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[0]));
        localArrayList.add(Integer.valueOf(localObject2[0]));
        this.APr.add(this.APp.get(0));
      }
      if (bool2)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[1]));
        localArrayList.add(Integer.valueOf(localObject2[1]));
        this.APr.add(this.APp.get(1));
      }
      if (bool3)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[2]));
        localArrayList.add(Integer.valueOf(localObject2[2]));
        this.APr.add(this.APp.get(2));
      }
      if (bool4)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[3]));
        localArrayList.add(Integer.valueOf(localObject2[3]));
        this.APr.add(this.APp.get(3));
      }
      if (this.APr.size() != 0) {
        break label874;
      }
      finish();
      AppMethodBeat.o(100144);
      return;
      if (paramBundle.hasExtra("k_title")) {
        setMMTitle(paramBundle.getStringExtra("k_title"));
      }
      this.AvG = paramBundle.getIntExtra("KLabel_range_index", this.APl);
      this.APq.style = paramBundle.getIntExtra("k_sns_label_ui_style", 0);
      this.AvC = paramBundle.getStringExtra("Klabel_name_list");
      this.AvD = paramBundle.getStringExtra("Kother_user_name_list");
      if (TextUtils.isEmpty(paramBundle.getStringExtra("k_sns_label_ui_title"))) {
        break;
      }
      setMMTitle(paramBundle.getStringExtra("k_sns_label_ui_title"));
      break;
      label802:
      if (this.AvG == this.APo)
      {
        if (!TextUtils.isEmpty(this.AvC)) {
          this.APq.Awf = bu.U(this.AvC.split(","));
        }
        if (!TextUtils.isEmpty(this.AvD)) {
          this.APq.Awh = bu.U(this.AvD.split(","));
        }
      }
    }
    label874:
    this.APl = this.APr.indexOf("public");
    this.APm = this.APr.indexOf("private");
    this.APn = this.APr.indexOf("visible");
    this.APo = this.APr.indexOf("invisible");
    if (this.APq != null)
    {
      localObject2 = this.APq;
      List localList = this.APr;
      ((a)localObject2).APv = localList;
      ((a)localObject2).APl = localList.indexOf("public");
      ((a)localObject2).APm = localList.indexOf("private");
      ((a)localObject2).APn = localList.indexOf("visible");
      ((a)localObject2).APo = localList.indexOf("invisible");
      this.APq.APu = ((List)localObject1).size();
      this.APq.AvA = gm((List)localObject1);
      this.APq.Awa = gm(localArrayList);
      if (!TextUtils.isEmpty(paramBundle))
      {
        this.APq.Awc = this.APr.indexOf(paramBundle);
        if (paramBundle.equals("visible"))
        {
          if (!TextUtils.isEmpty(this.AvC)) {
            this.APq.Awe = bu.U(this.AvC.split(","));
          }
          if (!TextUtils.isEmpty(this.AvD)) {
            this.APq.Awg = bu.U(this.AvD.split(","));
          }
          this.Avz.expandGroup(this.APr.indexOf(paramBundle));
          AppMethodBeat.o(100144);
          return;
        }
        if (paramBundle.equals("invisible"))
        {
          if (!TextUtils.isEmpty(this.AvC)) {
            this.APq.Awf = bu.U(this.AvC.split(","));
          }
          if (!TextUtils.isEmpty(this.AvD)) {
            this.APq.Awh = bu.U(this.AvD.split(","));
          }
          this.Avz.expandGroup(this.APr.indexOf(paramBundle));
        }
      }
    }
    label1265:
    AppMethodBeat.o(100144);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(100158);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(292, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(635, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(638, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(290, this);
    super.onDestroy();
    AppMethodBeat.o(100158);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(100159);
    if ((this.APq != null) && (this.AvN == null) && (this.Avz != null)) {
      this.Avz.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100131);
          com.tencent.mm.plugin.label.a.a.dig().aoM();
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, (ArrayList)com.tencent.mm.plugin.label.a.a.dig().dib());
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).aA(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
          JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
          if (((JsapiSnsLabelUI.j(JsapiSnsLabelUI.this) == null) || (JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).size() == 0)) && ((JsapiSnsLabelUI.p(JsapiSnsLabelUI.this) == null) || (JsapiSnsLabelUI.p(JsapiSnsLabelUI.this).length() == 0)) && (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awc != JsapiSnsLabelUI.this.APl) && (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awc != JsapiSnsLabelUI.this.APm)) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awc = JsapiSnsLabelUI.this.APl;
          }
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).notifyDataSetChanged();
          JsapiSnsLabelUI.m(JsapiSnsLabelUI.this);
          AppMethodBeat.o(100131);
        }
      }, 600L);
    }
    super.onResume();
    AppMethodBeat.o(100159);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(100160);
    ae.i("MicroMsg.SnsLabelUI", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!this.AvJ)
    {
      AppMethodBeat.o(100160);
      return;
    }
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(100160);
      return;
      Object localObject;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = ah.dXK().getCursor();
        this.AvO = ((Cursor)localObject).getCount();
        if (this.AvO > 0)
        {
          ((Cursor)localObject).moveToFirst();
          com.tencent.mm.plugin.sns.storage.v localv = new com.tencent.mm.plugin.sns.storage.v();
          paramInt1 = ((Cursor)localObject).getCount();
          this.AvQ = new ArrayList(paramInt1);
          this.AvP = new ArrayList(paramInt1);
          this.AvS = new ArrayList(paramInt1);
          this.AvR = new ArrayList(paramInt1);
          if (!((Cursor)localObject).isAfterLast())
          {
            localv.convertFrom((Cursor)localObject);
            if ((localv.field_memberList != null) && (localv.field_memberList.length() != 0))
            {
              this.AvS.add(localv.field_memberList.split(","));
              paramn = localv.field_tagName;
              ArrayList localArrayList = this.AvQ;
              paramString = com.tencent.mm.plugin.label.a.a.dig().did();
              if (paramString == null)
              {
                paramString = paramn;
                label297:
                localArrayList.add(paramString);
                this.AvP.add(paramn);
                this.AvR.add(Long.valueOf(localv.field_tagId));
              }
            }
            for (;;)
            {
              ((Cursor)localObject).moveToNext();
              break;
              if (!paramString.contains(paramn))
              {
                paramString = paramn;
                break label297;
              }
              paramString = String.format(getString(2131763859), new Object[] { paramn });
              break label297;
              ae.e("MicroMsg.SnsLabelUI", "dz:snstaginfo memberlist is null.");
            }
          }
          ((Cursor)localObject).close();
          if (this.AvP.size() != 0) {
            break label508;
          }
          paramInt1 = 0;
          if (paramInt1 != 0) {}
        }
        else if (this.AvK)
        {
          this.APq.Awc = this.AvL;
          this.Avz.agf(this.AvL);
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().set(335873, Boolean.FALSE);
        }
        ((Cursor)localObject).close();
        if (this.AvI)
        {
          this.AvJ = true;
          com.tencent.mm.plugin.label.a.a.dig().eo(this.AvQ);
        }
      }
      for (;;)
      {
        this.AvK = false;
        AppMethodBeat.o(100160);
        return;
        label508:
        paramInt1 = 1;
        break;
        this.AvJ = false;
        continue;
        efP();
        ae.i("MicroMsg.SnsLabelUI", "dz: error at get sns tag list!");
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        gg(this.AvS);
        AppMethodBeat.o(100160);
        return;
      }
      efP();
      ae.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
      AppMethodBeat.o(100160);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.AvP.iterator();
        paramn = this.AvR.iterator();
        while (paramString.hasNext())
        {
          long l = ((Long)paramn.next()).longValue();
          localObject = (String)paramString.next();
          if (l != 0L)
          {
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(new x(l, (String)localObject), 0);
          }
        }
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(335874, Integer.valueOf(0));
        this.AvB = ((ArrayList)com.tencent.mm.plugin.label.a.a.dig().dib());
        paramString = com.tencent.mm.plugin.report.service.g.yxI;
        paramInt2 = this.AvO;
        if (this.AvQ == null) {}
        for (paramInt1 = 0;; paramInt1 = this.AvQ.size())
        {
          paramString.f(11455, new Object[] { "", "", Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
          this.Avz.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100132);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awc = JsapiSnsLabelUI.l(JsapiSnsLabelUI.this);
              if (JsapiSnsLabelUI.b(JsapiSnsLabelUI.this) != null)
              {
                if (JsapiSnsLabelUI.j(JsapiSnsLabelUI.this) == null) {
                  JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, JsapiSnsLabelUI.b(JsapiSnsLabelUI.this));
                }
                for (;;)
                {
                  localObject = JsapiSnsLabelUI.b(JsapiSnsLabelUI.this).iterator();
                  while (((Iterator)localObject).hasNext())
                  {
                    JsapiSnsLabelUI.a(JsapiSnsLabelUI.this);
                    a.aCg((String)((Iterator)localObject).next());
                  }
                  JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).addAll(JsapiSnsLabelUI.b(JsapiSnsLabelUI.this));
                }
                Object localObject = new HashSet(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
                JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).clear();
                JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).addAll((Collection)localObject);
                JsapiSnsLabelUI.b(JsapiSnsLabelUI.this).clear();
                JsapiSnsLabelUI.q(JsapiSnsLabelUI.this);
                ((HashSet)localObject).clear();
              }
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).aA(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
              JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).notifyDataSetChanged();
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).agf(JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Awc);
              if ((JsapiSnsLabelUI.r(JsapiSnsLabelUI.this) != null) && (JsapiSnsLabelUI.r(JsapiSnsLabelUI.this).isShowing())) {
                JsapiSnsLabelUI.r(JsapiSnsLabelUI.this).dismiss();
              }
              AppMethodBeat.o(100132);
            }
          }, 600L);
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().set(335873, Boolean.FALSE);
          AppMethodBeat.o(100160);
          return;
        }
      }
      efP();
      ae.i("MicroMsg.SnsLabelUI", "dz: error at modify label list!");
      AppMethodBeat.o(100160);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        ae.i("MicroMsg.SnsLabelUI", "dz: error at delete tag list!");
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI
 * JD-Core Version:    0.7.0.1
 */