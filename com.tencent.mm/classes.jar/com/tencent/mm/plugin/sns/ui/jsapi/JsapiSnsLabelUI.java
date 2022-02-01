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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r.b;
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
  implements com.tencent.mm.al.g
{
  public static int[] xAe = { 2131763871, 2131763869, 2131763865, 2131763856 };
  private AnimatedExpandableListView xAd;
  private ArrayList<String> xAf;
  private String xAg;
  private String xAh;
  private int xAk;
  private boolean xAl;
  private boolean xAm;
  private boolean xAn;
  private boolean xAo;
  private int xAp;
  private com.tencent.mm.ui.base.p xAq;
  private String xAr;
  private int xAs;
  private ArrayList<String> xAt;
  private ArrayList<String> xAu;
  private ArrayList<Long> xAv;
  private ArrayList<String[]> xAw;
  public int xSX;
  public int xSY;
  public int xSZ;
  public int xTa;
  private List<String> xTb;
  a xTc;
  List<String> xTd;
  
  public JsapiSnsLabelUI()
  {
    AppMethodBeat.i(100142);
    this.xSX = 0;
    this.xSY = 1;
    this.xSZ = 2;
    this.xTa = 3;
    this.xTb = Arrays.asList("public,private,visible,invisible".split(","));
    this.xAk = this.xSX;
    this.xAm = false;
    this.xAn = false;
    this.xAo = false;
    this.xTd = new ArrayList();
    AppMethodBeat.o(100142);
  }
  
  private String NO(int paramInt)
  {
    AppMethodBeat.i(100153);
    if ((paramInt >= this.xTd.size()) || (paramInt < 0))
    {
      AppMethodBeat.o(100153);
      return "";
    }
    String str = (String)this.xTd.get(paramInt);
    AppMethodBeat.o(100153);
    return str;
  }
  
  private void aK(Intent paramIntent)
  {
    AppMethodBeat.i(100152);
    dBw();
    paramIntent.putExtra("Klabel_name_list", aqM(this.xAg));
    paramIntent.putExtra("Kother_user_name_list", aqL(this.xAh));
    paramIntent.putExtra("k_select_group", NO(this.xTc.xAG));
    AppMethodBeat.o(100152);
  }
  
  private static String aqL(String paramString)
  {
    AppMethodBeat.i(100154);
    Object localObject = bt.kS(paramString, ",");
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
          localJSONObject.put("displayName", sh(str));
          localJSONObject.put("avatar", aqN(str));
          paramString.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          ad.printErrStackTrace("MicroMsg.SnsLabelUI", localJSONException, "", new Object[0]);
        }
      }
    }
    paramString = paramString.toString();
    AppMethodBeat.o(100154);
    return paramString;
  }
  
  private static String aqM(String paramString)
  {
    AppMethodBeat.i(100155);
    Object localObject1 = bt.kS(paramString, ",");
    paramString = new JSONObject();
    com.tencent.mm.plugin.label.a.b localb = com.tencent.mm.plugin.label.a.a.cIS();
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
          localObject2 = localb.aeL(localb.aeI((String)localObject2));
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              String str = (String)((Iterator)localObject2).next();
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("username", str);
              localJSONObject.put("displayName", sh(str));
              localJSONObject.put("avatar", aqN(str));
              localJSONArray.put(localJSONObject);
            }
          }
        }
        catch (JSONException localJSONException)
        {
          ad.printErrStackTrace("MicroMsg.SnsLabelUI", localJSONException, "", new Object[0]);
        }
      }
    }
    paramString = paramString.toString();
    AppMethodBeat.o(100155);
    return paramString;
  }
  
  private static String aqN(String paramString)
  {
    AppMethodBeat.i(100157);
    paramString = com.tencent.mm.ak.p.auF().we(paramString);
    if (paramString != null)
    {
      paramString = paramString.auy();
      AppMethodBeat.o(100157);
      return paramString;
    }
    AppMethodBeat.o(100157);
    return "";
  }
  
  private boolean dBp()
  {
    AppMethodBeat.i(100148);
    boolean bool2 = false;
    int i = this.xTc.xAG;
    boolean bool1;
    if (this.xTc.xAG != this.xAk) {
      if (((i == this.xSZ) && ((this.xTc.xAI.size() != 0) || (this.xTc.xAK.size() != 0))) || ((i == this.xTa) && ((this.xTc.xAJ.size() != 0) || (this.xTc.xAL.size() != 0)))) {
        bool1 = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(100148);
      return bool1;
      if (i != this.xSY)
      {
        bool1 = bool2;
        if (i != this.xSX) {}
      }
      else
      {
        bool1 = true;
        continue;
        if ((i != this.xSZ) || (this.xTc.xAI.size() == 0) || ((bt.n(this.xTc.xAI, ",").equals(this.xAg)) && (bt.n(this.xTc.xAK, ",").equals(this.xAh))))
        {
          bool1 = bool2;
          if (i != this.xTa) {
            continue;
          }
          bool1 = bool2;
          if (this.xTc.xAJ.size() == 0) {
            continue;
          }
          if (bt.n(this.xTc.xAJ, ",").equals(this.xAg))
          {
            bool1 = bool2;
            if (bt.n(this.xTc.xAL, ",").equals(this.xAh)) {
              continue;
            }
          }
        }
        bool1 = true;
      }
    }
  }
  
  private void dBq()
  {
    AppMethodBeat.i(100150);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ktag_range_index", this.xAk);
    aK(localIntent);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(100150);
  }
  
  private static int dBs()
  {
    AppMethodBeat.i(100161);
    com.tencent.mm.kernel.g.afC();
    int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(335874, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(100161);
    return i;
  }
  
  private static void dBt()
  {
    AppMethodBeat.i(100162);
    com.tencent.mm.kernel.g.afC();
    int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(335874, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afk().set(335874, Integer.valueOf(i + 1));
    AppMethodBeat.o(100162);
  }
  
  private void dBu()
  {
    AppMethodBeat.i(100163);
    com.tencent.mm.plugin.report.service.h.vKh.f(11455, new Object[] { "", "", Integer.valueOf(this.xAs), Integer.valueOf(0) });
    dBt();
    this.xAu = null;
    this.xAo = false;
    this.xAn = false;
    if ((this.xAq != null) && (this.xAq.isShowing())) {
      this.xAq.dismiss();
    }
    if (this.xAm)
    {
      this.xAm = false;
      AppMethodBeat.o(100163);
      return;
    }
    int i = 2131763879;
    if (dBs() > 1) {
      i = 2131763878;
    }
    com.tencent.mm.ui.base.h.a(this, i, 2131755835, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(100163);
  }
  
  private void dBv()
  {
    AppMethodBeat.i(100165);
    if ((this.xAf == null) || (this.xAf.isEmpty()))
    {
      if (this.xTc.xAI != null) {
        this.xTc.xAI.clear();
      }
      if (this.xTc.xAJ != null) {
        this.xTc.xAJ.clear();
      }
      AppMethodBeat.o(100165);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    String str;
    if ((this.xTd.size() > 0) && ("visible".equals(NO(this.xAk))) && (this.xTc.xAI != null))
    {
      localIterator = this.xTc.xAI.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.xAf.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.xTc.xAI.removeAll(localArrayList);
      AppMethodBeat.o(100165);
      return;
    }
    if ((this.xTd.size() > 0) && ("invisible".equals(NO(this.xAk))))
    {
      localIterator = this.xTc.xAJ.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.xAf.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.xTc.xAJ.removeAll(localArrayList);
    }
    AppMethodBeat.o(100165);
  }
  
  private void dBw()
  {
    AppMethodBeat.i(100166);
    if ((this.xAf == null) || (this.xAf.isEmpty()))
    {
      this.xAg = "";
      AppMethodBeat.o(100166);
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    if (this.xAg != null)
    {
      ArrayList localArrayList2 = bt.S(this.xAg.split(","));
      if (localArrayList2 != null)
      {
        Iterator localIterator = localArrayList2.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!this.xAf.contains(str)) {
            localArrayList1.add(str);
          }
        }
        localArrayList2.removeAll(localArrayList1);
        this.xAg = bt.n(localArrayList2, ",");
      }
    }
    AppMethodBeat.o(100166);
  }
  
  private void fE(List<String[]> paramList)
  {
    AppMethodBeat.i(100164);
    if ((this.xAu == null) || (this.xAu.size() == 0))
    {
      AppMethodBeat.o(100164);
      return;
    }
    Iterator localIterator = this.xAu.iterator();
    paramList = paramList.iterator();
    ArrayList localArrayList1 = new ArrayList(this.xAu.size());
    ArrayList localArrayList2 = new ArrayList(this.xAu.size());
    while (localIterator.hasNext())
    {
      localArrayList1.add(com.tencent.mm.plugin.label.a.a.cIS().aeI((String)localIterator.next()));
      localArrayList2.add(bt.n(Arrays.asList((Object[])paramList.next()), ","));
      this.xAn = true;
    }
    com.tencent.mm.plugin.label.a.a.cIS().n(localArrayList1, localArrayList2);
    AppMethodBeat.o(100164);
  }
  
  private static int[] fK(List<Integer> paramList)
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
    if (dBp())
    {
      com.tencent.mm.ui.base.h.a(this, true, getString(2131763862), "", getString(2131763861), getString(2131763860), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    dBq();
    AppMethodBeat.o(100149);
  }
  
  private static String sh(String paramString)
  {
    AppMethodBeat.i(100156);
    paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sh(paramString);
    AppMethodBeat.o(100156);
    return paramString;
  }
  
  final void dBr()
  {
    AppMethodBeat.i(100151);
    Intent localIntent = new Intent();
    if (this.xTc.xAG == this.xSZ)
    {
      this.xAg = bt.n(this.xTc.xAI, ",");
      this.xAh = bt.n(this.xTc.xAK, ",");
      aK(localIntent);
    }
    for (;;)
    {
      localIntent.putExtra("k_select_group", NO(this.xTc.xAG));
      localIntent.putExtra("k_select_index", this.xTc.xAG);
      localIntent.putExtra("Ktag_range_index", this.xTc.xAG);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(100151);
      return;
      if (this.xTc.xAG == this.xTa)
      {
        this.xAg = bt.n(this.xTc.xAJ, ",");
        this.xAh = bt.n(this.xTc.xAL, ",");
        aK(localIntent);
      }
    }
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
  
  public int getLayoutId()
  {
    return 2131495554;
  }
  
  public void initView()
  {
    AppMethodBeat.i(100146);
    boolean bool = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
    this.xAd = ((AnimatedExpandableListView)findViewById(2131304991));
    this.xAf = ((ArrayList)com.tencent.mm.plugin.label.a.a.cIS().cIN());
    this.xTc.xAH = bool;
    this.xTc.ap(this.xAf);
    dBv();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    localLayoutParams.height = getResources().getDimensionPixelSize(2131165483);
    View localView = new View(this);
    localView.setLayoutParams(localLayoutParams);
    this.xAd.addHeaderView(localView);
    this.xAd.setAdapter(this.xTc);
    this.xAd.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
    {
      public final boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100134);
        int i = JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAG;
        ad.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt) });
        if ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, paramAnonymousInt).equals("visible")) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, paramAnonymousInt).equals("invisible")))
        {
          if ((JsapiSnsLabelUI.b(JsapiSnsLabelUI.this) != null) && (JsapiSnsLabelUI.b(JsapiSnsLabelUI.this).size() != 0) && (JsapiSnsLabelUI.dDr() == 0))
          {
            JsapiSnsLabelUI.b(JsapiSnsLabelUI.this, paramAnonymousInt);
            JsapiSnsLabelUI.c(JsapiSnsLabelUI.this);
            ad.i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
            AppMethodBeat.o(100134);
            return true;
          }
          if (JsapiSnsLabelUI.d(JsapiSnsLabelUI.this))
          {
            JsapiSnsLabelUI.e(JsapiSnsLabelUI.this);
            JsapiSnsLabelUI.b(JsapiSnsLabelUI.this, paramAnonymousInt);
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, com.tencent.mm.ui.base.h.b(JsapiSnsLabelUI.this, JsapiSnsLabelUI.this.getString(2131763867), false, null));
            ad.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
            AppMethodBeat.o(100134);
            return true;
          }
          if ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAF == null) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAF.size() == 0))
          {
            JsapiSnsLabelUI.b(JsapiSnsLabelUI.this, paramAnonymousInt);
            JsapiSnsLabelUI.f(JsapiSnsLabelUI.this);
            ad.i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
            AppMethodBeat.o(100134);
            return true;
          }
          if (i == paramAnonymousInt)
          {
            if (JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).isGroupExpanded(paramAnonymousInt)) {
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).aaL(paramAnonymousInt);
            }
            for (;;)
            {
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAG = paramAnonymousInt;
              AppMethodBeat.o(100134);
              return true;
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).aaK(paramAnonymousInt);
            }
          }
          if (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("visible"))
          {
            JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).collapseGroup(i);
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAI.clear();
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAK.clear();
          }
          for (;;)
          {
            JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100133);
                JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).aaK(paramAnonymousInt);
                AppMethodBeat.o(100133);
              }
            });
            break;
            if (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("invisible"))
            {
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).collapseGroup(i);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAJ.clear();
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAL.clear();
            }
          }
        }
        if ((i >= 0) && ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("visible")) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("invisible")))) {
          JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).aaL(i);
        }
        JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAG = paramAnonymousInt;
        AppMethodBeat.o(100134);
        return false;
      }
    });
    this.xAd.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
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
          a.aqz(paramAnonymousExpandableListView);
          if (paramAnonymousInt1 == JsapiSnsLabelUI.this.xSZ) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, 1, JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAI, paramAnonymousExpandableListView, paramAnonymousView);
          } else if (paramAnonymousInt1 == JsapiSnsLabelUI.this.xTa) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, 2, JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAJ, paramAnonymousExpandableListView, paramAnonymousView);
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
        String str1 = bt.n(paramAnonymousMenuItem.xTc.xAI, ",");
        String str2 = bt.n(paramAnonymousMenuItem.xTc.xAK, ",");
        String str3 = bt.n(paramAnonymousMenuItem.xTc.xAJ, ",");
        String str4 = bt.n(paramAnonymousMenuItem.xTc.xAL, ",");
        if (((paramAnonymousMenuItem.xTc.xAG == paramAnonymousMenuItem.xSZ) && (paramAnonymousMenuItem.xTc.xAI.size() == 0) && (paramAnonymousMenuItem.xTc.xAK.size() == 0)) || ((paramAnonymousMenuItem.xTc.xAG == paramAnonymousMenuItem.xTa) && (paramAnonymousMenuItem.xTc.xAJ.size() == 0) && (paramAnonymousMenuItem.xTc.xAL.size() == 0))) {
          com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131763868), "", paramAnonymousMenuItem.getString(2131763880), null);
        }
        for (;;)
        {
          AppMethodBeat.o(100137);
          return true;
          if (((paramAnonymousMenuItem.xTc.xAG == paramAnonymousMenuItem.xSZ) && (bt.isNullOrNil(str1)) && (bt.isNullOrNil(str2))) || ((paramAnonymousMenuItem.xTc.xAG == paramAnonymousMenuItem.xTa) && (bt.isNullOrNil(str3)) && (bt.isNullOrNil(str4)))) {
            com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131763868), "", paramAnonymousMenuItem.getString(2131763880), null);
          } else {
            paramAnonymousMenuItem.dBr();
          }
        }
      }
    }, null, r.b.FOB);
    AppMethodBeat.o(100146);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(100147);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if ((paramInt2 == -1) && (paramInt1 == 4003))
    {
      ad.i("MicroMsg.SnsLabelUI", "the Activity completed");
      localObject = paramIntent.getStringExtra("Select_Contacts_To_Create_New_Label");
      if (!bt.isNullOrNil((String)localObject))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("Select_Contact", (String)localObject);
        d.b(getContext(), "label", ".ui.ContactLabelEditUI", paramIntent, 4002);
        AppMethodBeat.o(100147);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      this.xAh = new String(paramIntent);
      ad.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.xAp == this.xSZ)
      {
        this.xTc.xAK.clear();
        if (!bt.isNullOrNil(paramIntent))
        {
          paramIntent = bt.S(paramIntent.split(","));
          this.xTc.xAK.addAll(paramIntent);
          this.xTc.xAG = this.xAp;
        }
      }
      for (;;)
      {
        this.xTc.notifyDataSetChanged();
        this.xAd.expandGroup(this.xAp);
        AppMethodBeat.o(100147);
        return;
        if (this.xAp == this.xTa)
        {
          this.xTc.xAL.clear();
          if (!bt.isNullOrNil(paramIntent))
          {
            paramIntent = bt.S(paramIntent.split(","));
            this.xTc.xAL.addAll(paramIntent);
            this.xTc.xAG = this.xAp;
          }
        }
      }
    }
    if ((paramInt2 == -1) && (paramInt1 == 4001))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      ad.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (!bt.isNullOrNil(paramIntent))
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
      this.xAr = paramIntent.getStringExtra("k_sns_label_add_label");
      this.xAd.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100139);
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, (ArrayList)com.tencent.mm.plugin.label.a.a.cIS().cIN());
          if (JsapiSnsLabelUI.j(JsapiSnsLabelUI.this) == null) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, new ArrayList());
          }
          if (!bt.isNullOrNil(this.xAA)) {
            if (!JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).contains(this.xAA)) {
              JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).add(this.xAA);
            }
          }
          for (int i = JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).indexOf(this.xAA);; i = -1)
          {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).ap(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
            JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAG = JsapiSnsLabelUI.l(JsapiSnsLabelUI.this);
            if ((!bt.isNullOrNil(this.xAA)) && (i != -1))
            {
              if (JsapiSnsLabelUI.l(JsapiSnsLabelUI.this) != JsapiSnsLabelUI.this.xSZ) {
                break label252;
              }
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAI.add(this.xAA);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAK.clear();
            }
            for (;;)
            {
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).notifyDataSetChanged();
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).expandGroup(JsapiSnsLabelUI.l(JsapiSnsLabelUI.this));
              JsapiSnsLabelUI.m(JsapiSnsLabelUI.this);
              AppMethodBeat.o(100139);
              return;
              label252:
              if (JsapiSnsLabelUI.l(JsapiSnsLabelUI.this) == JsapiSnsLabelUI.this.xTa)
              {
                JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAJ.add(this.xAA);
                JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAL.clear();
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
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(292, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(635, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(638, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(290, this);
    this.xTc = new a(this);
    this.xTc.xTj = false;
    this.xTc.xTi = new a.b()
    {
      public final void a(a.c paramAnonymousc)
      {
        AppMethodBeat.i(100130);
        int i = paramAnonymousc.xAT;
        int j = paramAnonymousc.xAU;
        JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i, j);
        AppMethodBeat.o(100130);
      }
    };
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      this.xAk = this.xSX;
      this.xTc.style = 0;
      this.xAg = null;
      this.xAh = null;
      this.xTc.xAG = this.xAk;
      if (this.xTc.style == 1) {
        findViewById(2131304992).setBackgroundResource(2131100017);
      }
      if (this.xAk != this.xSZ) {
        break label801;
      }
      if (!TextUtils.isEmpty(this.xAg)) {
        this.xTc.xAI = bt.S(this.xAg.split(","));
      }
      if (!TextUtils.isEmpty(this.xAh)) {
        this.xTc.xAK = bt.S(this.xAh.split(","));
      }
    }
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList;
    for (;;)
    {
      com.tencent.mm.kernel.g.afC();
      this.xAl = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(335873, Boolean.TRUE)).booleanValue();
      if (this.xAl)
      {
        this.xAn = true;
        this.xAo = true;
        if (dBs() > 0) {
          this.xAm = true;
        }
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(new u(1), 0);
      }
      initView();
      localObject1 = getIntent();
      if (localObject1 == null) {
        break label1264;
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
      this.xTd.clear();
      localObject1 = new ArrayList();
      localArrayList = new ArrayList();
      if (bool1)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[0]));
        localArrayList.add(Integer.valueOf(localObject2[0]));
        this.xTd.add(this.xTb.get(0));
      }
      if (bool2)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[1]));
        localArrayList.add(Integer.valueOf(localObject2[1]));
        this.xTd.add(this.xTb.get(1));
      }
      if (bool3)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[2]));
        localArrayList.add(Integer.valueOf(localObject2[2]));
        this.xTd.add(this.xTb.get(2));
      }
      if (bool4)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[3]));
        localArrayList.add(Integer.valueOf(localObject2[3]));
        this.xTd.add(this.xTb.get(3));
      }
      if (this.xTd.size() != 0) {
        break label873;
      }
      finish();
      AppMethodBeat.o(100144);
      return;
      if (paramBundle.hasExtra("k_title")) {
        setMMTitle(paramBundle.getStringExtra("k_title"));
      }
      this.xAk = paramBundle.getIntExtra("KLabel_range_index", this.xSX);
      this.xTc.style = paramBundle.getIntExtra("k_sns_label_ui_style", 0);
      this.xAg = paramBundle.getStringExtra("Klabel_name_list");
      this.xAh = paramBundle.getStringExtra("Kother_user_name_list");
      if (TextUtils.isEmpty(paramBundle.getStringExtra("k_sns_label_ui_title"))) {
        break;
      }
      setMMTitle(paramBundle.getStringExtra("k_sns_label_ui_title"));
      break;
      label801:
      if (this.xAk == this.xTa)
      {
        if (!TextUtils.isEmpty(this.xAg)) {
          this.xTc.xAJ = bt.S(this.xAg.split(","));
        }
        if (!TextUtils.isEmpty(this.xAh)) {
          this.xTc.xAL = bt.S(this.xAh.split(","));
        }
      }
    }
    label873:
    this.xSX = this.xTd.indexOf("public");
    this.xSY = this.xTd.indexOf("private");
    this.xSZ = this.xTd.indexOf("visible");
    this.xTa = this.xTd.indexOf("invisible");
    if (this.xTc != null)
    {
      localObject2 = this.xTc;
      List localList = this.xTd;
      ((a)localObject2).xTh = localList;
      ((a)localObject2).xSX = localList.indexOf("public");
      ((a)localObject2).xSY = localList.indexOf("private");
      ((a)localObject2).xSZ = localList.indexOf("visible");
      ((a)localObject2).xTa = localList.indexOf("invisible");
      this.xTc.xTg = ((List)localObject1).size();
      this.xTc.xAe = fK((List)localObject1);
      this.xTc.xAE = fK(localArrayList);
      if (!TextUtils.isEmpty(paramBundle))
      {
        this.xTc.xAG = this.xTd.indexOf(paramBundle);
        if (paramBundle.equals("visible"))
        {
          if (!TextUtils.isEmpty(this.xAg)) {
            this.xTc.xAI = bt.S(this.xAg.split(","));
          }
          if (!TextUtils.isEmpty(this.xAh)) {
            this.xTc.xAK = bt.S(this.xAh.split(","));
          }
          this.xAd.expandGroup(this.xTd.indexOf(paramBundle));
          AppMethodBeat.o(100144);
          return;
        }
        if (paramBundle.equals("invisible"))
        {
          if (!TextUtils.isEmpty(this.xAg)) {
            this.xTc.xAJ = bt.S(this.xAg.split(","));
          }
          if (!TextUtils.isEmpty(this.xAh)) {
            this.xTc.xAL = bt.S(this.xAh.split(","));
          }
          this.xAd.expandGroup(this.xTd.indexOf(paramBundle));
        }
      }
    }
    label1264:
    AppMethodBeat.o(100144);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(100158);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(292, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(635, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(638, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(290, this);
    super.onDestroy();
    AppMethodBeat.o(100158);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(100159);
    if ((this.xTc != null) && (this.xAr == null) && (this.xAd != null)) {
      this.xAd.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100131);
          com.tencent.mm.plugin.label.a.a.cIS().ayP();
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, (ArrayList)com.tencent.mm.plugin.label.a.a.cIS().cIN());
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).ap(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
          JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
          if (((JsapiSnsLabelUI.j(JsapiSnsLabelUI.this) == null) || (JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).size() == 0)) && ((JsapiSnsLabelUI.p(JsapiSnsLabelUI.this) == null) || (JsapiSnsLabelUI.p(JsapiSnsLabelUI.this).length() == 0)) && (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAG != JsapiSnsLabelUI.this.xSX) && (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAG != JsapiSnsLabelUI.this.xSY)) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAG = JsapiSnsLabelUI.this.xSX;
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
    ad.i("MicroMsg.SnsLabelUI", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!this.xAn)
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
        localObject = af.dtA().getCursor();
        this.xAs = ((Cursor)localObject).getCount();
        if (this.xAs > 0)
        {
          ((Cursor)localObject).moveToFirst();
          v localv = new v();
          paramInt1 = ((Cursor)localObject).getCount();
          this.xAu = new ArrayList(paramInt1);
          this.xAt = new ArrayList(paramInt1);
          this.xAw = new ArrayList(paramInt1);
          this.xAv = new ArrayList(paramInt1);
          if (!((Cursor)localObject).isAfterLast())
          {
            localv.convertFrom((Cursor)localObject);
            if ((localv.field_memberList != null) && (localv.field_memberList.length() != 0))
            {
              this.xAw.add(localv.field_memberList.split(","));
              paramn = localv.field_tagName;
              ArrayList localArrayList = this.xAu;
              paramString = com.tencent.mm.plugin.label.a.a.cIS().cIP();
              if (paramString == null)
              {
                paramString = paramn;
                label297:
                localArrayList.add(paramString);
                this.xAt.add(paramn);
                this.xAv.add(Long.valueOf(localv.field_tagId));
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
              ad.e("MicroMsg.SnsLabelUI", "dz:snstaginfo memberlist is null.");
            }
          }
          ((Cursor)localObject).close();
          if (this.xAt.size() != 0) {
            break label508;
          }
          paramInt1 = 0;
          if (paramInt1 != 0) {}
        }
        else if (this.xAo)
        {
          this.xTc.xAG = this.xAp;
          this.xAd.aaK(this.xAp);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(335873, Boolean.FALSE);
        }
        ((Cursor)localObject).close();
        if (this.xAm)
        {
          this.xAn = true;
          com.tencent.mm.plugin.label.a.a.cIS().dT(this.xAu);
        }
      }
      for (;;)
      {
        this.xAo = false;
        AppMethodBeat.o(100160);
        return;
        label508:
        paramInt1 = 1;
        break;
        this.xAn = false;
        continue;
        dBu();
        ad.i("MicroMsg.SnsLabelUI", "dz: error at get sns tag list!");
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        fE(this.xAw);
        AppMethodBeat.o(100160);
        return;
      }
      dBu();
      ad.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
      AppMethodBeat.o(100160);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.xAt.iterator();
        paramn = this.xAv.iterator();
        while (paramString.hasNext())
        {
          long l = ((Long)paramn.next()).longValue();
          localObject = (String)paramString.next();
          if (l != 0L)
          {
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(new com.tencent.mm.plugin.sns.model.w(l, (String)localObject), 0);
          }
        }
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(335874, Integer.valueOf(0));
        this.xAf = ((ArrayList)com.tencent.mm.plugin.label.a.a.cIS().cIN());
        paramString = com.tencent.mm.plugin.report.service.h.vKh;
        paramInt2 = this.xAs;
        if (this.xAu == null) {}
        for (paramInt1 = 0;; paramInt1 = this.xAu.size())
        {
          paramString.f(11455, new Object[] { "", "", Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
          this.xAd.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100132);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAG = JsapiSnsLabelUI.l(JsapiSnsLabelUI.this);
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
                    a.aqz((String)((Iterator)localObject).next());
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
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).ap(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
              JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).notifyDataSetChanged();
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).aaK(JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).xAG);
              if ((JsapiSnsLabelUI.r(JsapiSnsLabelUI.this) != null) && (JsapiSnsLabelUI.r(JsapiSnsLabelUI.this).isShowing())) {
                JsapiSnsLabelUI.r(JsapiSnsLabelUI.this).dismiss();
              }
              AppMethodBeat.o(100132);
            }
          }, 600L);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(335873, Boolean.FALSE);
          AppMethodBeat.o(100160);
          return;
        }
      }
      dBu();
      ad.i("MicroMsg.SnsLabelUI", "dz: error at modify label list!");
      AppMethodBeat.o(100160);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        ad.i("MicroMsg.SnsLabelUI", "dz: error at delete tag list!");
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