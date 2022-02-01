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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
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
  public static int[] Aeo = { 2131763871, 2131763869, 2131763865, 2131763856 };
  private com.tencent.mm.ui.base.p AeA;
  private String AeB;
  private int AeC;
  private ArrayList<String> AeD;
  private ArrayList<String> AeE;
  private ArrayList<Long> AeF;
  private ArrayList<String[]> AeG;
  private AnimatedExpandableListView Aen;
  private ArrayList<String> Aep;
  private String Aeq;
  private String Aer;
  private int Aeu;
  private boolean Aev;
  private boolean Aew;
  private boolean Aex;
  private boolean Aey;
  private int Aez;
  public int AxS;
  public int AxT;
  public int AxU;
  public int AxV;
  private List<String> AxW;
  a AxX;
  List<String> AxY;
  
  public JsapiSnsLabelUI()
  {
    AppMethodBeat.i(100142);
    this.AxS = 0;
    this.AxT = 1;
    this.AxU = 2;
    this.AxV = 3;
    this.AxW = Arrays.asList("public,private,visible,invisible".split(","));
    this.Aeu = this.AxS;
    this.Aew = false;
    this.Aex = false;
    this.Aey = false;
    this.AxY = new ArrayList();
    AppMethodBeat.o(100142);
  }
  
  private String RB(int paramInt)
  {
    AppMethodBeat.i(100153);
    if ((paramInt >= this.AxY.size()) || (paramInt < 0))
    {
      AppMethodBeat.o(100153);
      return "";
    }
    String str = (String)this.AxY.get(paramInt);
    AppMethodBeat.o(100153);
    return str;
  }
  
  private static String aBb(String paramString)
  {
    AppMethodBeat.i(100154);
    Object localObject = bt.lO(paramString, ",");
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
          localJSONObject.put("displayName", zf(str));
          localJSONObject.put("avatar", aBd(str));
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
  
  private static String aBc(String paramString)
  {
    AppMethodBeat.i(100155);
    Object localObject1 = bt.lO(paramString, ",");
    paramString = new JSONObject();
    com.tencent.mm.plugin.label.a.b localb = com.tencent.mm.plugin.label.a.a.dfo();
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
          localObject2 = localb.aop(localb.aom((String)localObject2));
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              String str = (String)((Iterator)localObject2).next();
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("username", str);
              localJSONObject.put("displayName", zf(str));
              localJSONObject.put("avatar", aBd(str));
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
  
  private static String aBd(String paramString)
  {
    AppMethodBeat.i(100157);
    paramString = com.tencent.mm.ak.p.aEx().Dj(paramString);
    if (paramString != null)
    {
      paramString = paramString.aEr();
      AppMethodBeat.o(100157);
      return paramString;
    }
    AppMethodBeat.o(100157);
    return "";
  }
  
  private void aR(Intent paramIntent)
  {
    AppMethodBeat.i(100152);
    eck();
    paramIntent.putExtra("Klabel_name_list", aBc(this.Aeq));
    paramIntent.putExtra("Kother_user_name_list", aBb(this.Aer));
    paramIntent.putExtra("k_select_group", RB(this.AxX.AeQ));
    AppMethodBeat.o(100152);
  }
  
  private boolean ecd()
  {
    AppMethodBeat.i(100148);
    boolean bool2 = false;
    int i = this.AxX.AeQ;
    boolean bool1;
    if (this.AxX.AeQ != this.Aeu) {
      if (((i == this.AxU) && ((this.AxX.AeS.size() != 0) || (this.AxX.AeU.size() != 0))) || ((i == this.AxV) && ((this.AxX.AeT.size() != 0) || (this.AxX.AeV.size() != 0)))) {
        bool1 = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(100148);
      return bool1;
      if (i != this.AxT)
      {
        bool1 = bool2;
        if (i != this.AxS) {}
      }
      else
      {
        bool1 = true;
        continue;
        if ((i != this.AxU) || (this.AxX.AeS.size() == 0) || ((bt.m(this.AxX.AeS, ",").equals(this.Aeq)) && (bt.m(this.AxX.AeU, ",").equals(this.Aer))))
        {
          bool1 = bool2;
          if (i != this.AxV) {
            continue;
          }
          bool1 = bool2;
          if (this.AxX.AeT.size() == 0) {
            continue;
          }
          if (bt.m(this.AxX.AeT, ",").equals(this.Aeq))
          {
            bool1 = bool2;
            if (bt.m(this.AxX.AeV, ",").equals(this.Aer)) {
              continue;
            }
          }
        }
        bool1 = true;
      }
    }
  }
  
  private void ece()
  {
    AppMethodBeat.i(100150);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ktag_range_index", this.Aeu);
    aR(localIntent);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(100150);
  }
  
  private static int ecg()
  {
    AppMethodBeat.i(100161);
    com.tencent.mm.kernel.g.ajD();
    int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(335874, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(100161);
    return i;
  }
  
  private static void ech()
  {
    AppMethodBeat.i(100162);
    com.tencent.mm.kernel.g.ajD();
    int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(335874, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajC().ajl().set(335874, Integer.valueOf(i + 1));
    AppMethodBeat.o(100162);
  }
  
  private void eci()
  {
    AppMethodBeat.i(100163);
    com.tencent.mm.plugin.report.service.g.yhR.f(11455, new Object[] { "", "", Integer.valueOf(this.AeC), Integer.valueOf(0) });
    ech();
    this.AeE = null;
    this.Aey = false;
    this.Aex = false;
    if ((this.AeA != null) && (this.AeA.isShowing())) {
      this.AeA.dismiss();
    }
    if (this.Aew)
    {
      this.Aew = false;
      AppMethodBeat.o(100163);
      return;
    }
    int i = 2131763879;
    if (ecg() > 1) {
      i = 2131763878;
    }
    h.a(this, i, 2131755835, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(100163);
  }
  
  private void ecj()
  {
    AppMethodBeat.i(100165);
    if ((this.Aep == null) || (this.Aep.isEmpty()))
    {
      if (this.AxX.AeS != null) {
        this.AxX.AeS.clear();
      }
      if (this.AxX.AeT != null) {
        this.AxX.AeT.clear();
      }
      AppMethodBeat.o(100165);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    String str;
    if ((this.AxY.size() > 0) && ("visible".equals(RB(this.Aeu))) && (this.AxX.AeS != null))
    {
      localIterator = this.AxX.AeS.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.Aep.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.AxX.AeS.removeAll(localArrayList);
      AppMethodBeat.o(100165);
      return;
    }
    if ((this.AxY.size() > 0) && ("invisible".equals(RB(this.Aeu))))
    {
      localIterator = this.AxX.AeT.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.Aep.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.AxX.AeT.removeAll(localArrayList);
    }
    AppMethodBeat.o(100165);
  }
  
  private void eck()
  {
    AppMethodBeat.i(100166);
    if ((this.Aep == null) || (this.Aep.isEmpty()))
    {
      this.Aeq = "";
      AppMethodBeat.o(100166);
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    if (this.Aeq != null)
    {
      ArrayList localArrayList2 = bt.U(this.Aeq.split(","));
      if (localArrayList2 != null)
      {
        Iterator localIterator = localArrayList2.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!this.Aep.contains(str)) {
            localArrayList1.add(str);
          }
        }
        localArrayList2.removeAll(localArrayList1);
        this.Aeq = bt.m(localArrayList2, ",");
      }
    }
    AppMethodBeat.o(100166);
  }
  
  private void fX(List<String[]> paramList)
  {
    AppMethodBeat.i(100164);
    if ((this.AeE == null) || (this.AeE.size() == 0))
    {
      AppMethodBeat.o(100164);
      return;
    }
    Iterator localIterator = this.AeE.iterator();
    paramList = paramList.iterator();
    ArrayList localArrayList1 = new ArrayList(this.AeE.size());
    ArrayList localArrayList2 = new ArrayList(this.AeE.size());
    while (localIterator.hasNext())
    {
      localArrayList1.add(com.tencent.mm.plugin.label.a.a.dfo().aom((String)localIterator.next()));
      localArrayList2.add(bt.m(Arrays.asList((Object[])paramList.next()), ","));
      this.Aex = true;
    }
    com.tencent.mm.plugin.label.a.a.dfo().n(localArrayList1, localArrayList2);
    AppMethodBeat.o(100164);
  }
  
  private static int[] gd(List<Integer> paramList)
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
    if (ecd())
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
    ece();
    AppMethodBeat.o(100149);
  }
  
  private static String zf(String paramString)
  {
    AppMethodBeat.i(100156);
    paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf(paramString);
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
  
  final void ecf()
  {
    AppMethodBeat.i(100151);
    Intent localIntent = new Intent();
    if (this.AxX.AeQ == this.AxU)
    {
      this.Aeq = bt.m(this.AxX.AeS, ",");
      this.Aer = bt.m(this.AxX.AeU, ",");
      aR(localIntent);
    }
    for (;;)
    {
      localIntent.putExtra("k_select_group", RB(this.AxX.AeQ));
      localIntent.putExtra("k_select_index", this.AxX.AeQ);
      localIntent.putExtra("Ktag_range_index", this.AxX.AeQ);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(100151);
      return;
      if (this.AxX.AeQ == this.AxV)
      {
        this.Aeq = bt.m(this.AxX.AeT, ",");
        this.Aer = bt.m(this.AxX.AeV, ",");
        aR(localIntent);
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
    this.Aen = ((AnimatedExpandableListView)findViewById(2131304991));
    this.Aep = ((ArrayList)com.tencent.mm.plugin.label.a.a.dfo().dfj());
    this.AxX.AeR = bool;
    this.AxX.az(this.Aep);
    ecj();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    localLayoutParams.height = getResources().getDimensionPixelSize(2131165483);
    View localView = new View(this);
    localView.setLayoutParams(localLayoutParams);
    this.Aen.addHeaderView(localView);
    this.Aen.setAdapter(this.AxX);
    this.Aen.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
    {
      public final boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100134);
        int i = JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeQ;
        ad.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt) });
        if ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, paramAnonymousInt).equals("visible")) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, paramAnonymousInt).equals("invisible")))
        {
          if ((JsapiSnsLabelUI.b(JsapiSnsLabelUI.this) != null) && (JsapiSnsLabelUI.b(JsapiSnsLabelUI.this).size() != 0) && (JsapiSnsLabelUI.eej() == 0))
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
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, h.b(JsapiSnsLabelUI.this, JsapiSnsLabelUI.this.getString(2131763867), false, null));
            ad.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
            AppMethodBeat.o(100134);
            return true;
          }
          if ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeP == null) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeP.size() == 0))
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
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).afx(paramAnonymousInt);
            }
            for (;;)
            {
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeQ = paramAnonymousInt;
              AppMethodBeat.o(100134);
              return true;
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).afw(paramAnonymousInt);
            }
          }
          if (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("visible"))
          {
            JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).collapseGroup(i);
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeS.clear();
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeU.clear();
          }
          for (;;)
          {
            JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100133);
                JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).afw(paramAnonymousInt);
                AppMethodBeat.o(100133);
              }
            });
            break;
            if (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("invisible"))
            {
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).collapseGroup(i);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeT.clear();
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeV.clear();
            }
          }
        }
        if ((i >= 0) && ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("visible")) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("invisible")))) {
          JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).afx(i);
        }
        JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeQ = paramAnonymousInt;
        AppMethodBeat.o(100134);
        return false;
      }
    });
    this.Aen.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
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
          a.aAP(paramAnonymousExpandableListView);
          if (paramAnonymousInt1 == JsapiSnsLabelUI.this.AxU) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, 1, JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeS, paramAnonymousExpandableListView, paramAnonymousView);
          } else if (paramAnonymousInt1 == JsapiSnsLabelUI.this.AxV) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, 2, JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeT, paramAnonymousExpandableListView, paramAnonymousView);
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
        String str1 = bt.m(paramAnonymousMenuItem.AxX.AeS, ",");
        String str2 = bt.m(paramAnonymousMenuItem.AxX.AeU, ",");
        String str3 = bt.m(paramAnonymousMenuItem.AxX.AeT, ",");
        String str4 = bt.m(paramAnonymousMenuItem.AxX.AeV, ",");
        if (((paramAnonymousMenuItem.AxX.AeQ == paramAnonymousMenuItem.AxU) && (paramAnonymousMenuItem.AxX.AeS.size() == 0) && (paramAnonymousMenuItem.AxX.AeU.size() == 0)) || ((paramAnonymousMenuItem.AxX.AeQ == paramAnonymousMenuItem.AxV) && (paramAnonymousMenuItem.AxX.AeT.size() == 0) && (paramAnonymousMenuItem.AxX.AeV.size() == 0))) {
          h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131763868), "", paramAnonymousMenuItem.getString(2131763880), null);
        }
        for (;;)
        {
          AppMethodBeat.o(100137);
          return true;
          if (((paramAnonymousMenuItem.AxX.AeQ == paramAnonymousMenuItem.AxU) && (bt.isNullOrNil(str1)) && (bt.isNullOrNil(str2))) || ((paramAnonymousMenuItem.AxX.AeQ == paramAnonymousMenuItem.AxV) && (bt.isNullOrNil(str3)) && (bt.isNullOrNil(str4)))) {
            h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131763868), "", paramAnonymousMenuItem.getString(2131763880), null);
          } else {
            paramAnonymousMenuItem.ecf();
          }
        }
      }
    }, null, s.b.JbS);
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
      this.Aer = new String(paramIntent);
      ad.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.Aez == this.AxU)
      {
        this.AxX.AeU.clear();
        if (!bt.isNullOrNil(paramIntent))
        {
          paramIntent = bt.U(paramIntent.split(","));
          this.AxX.AeU.addAll(paramIntent);
          this.AxX.AeQ = this.Aez;
        }
      }
      for (;;)
      {
        this.AxX.notifyDataSetChanged();
        this.Aen.expandGroup(this.Aez);
        AppMethodBeat.o(100147);
        return;
        if (this.Aez == this.AxV)
        {
          this.AxX.AeV.clear();
          if (!bt.isNullOrNil(paramIntent))
          {
            paramIntent = bt.U(paramIntent.split(","));
            this.AxX.AeV.addAll(paramIntent);
            this.AxX.AeQ = this.Aez;
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
      this.AeB = paramIntent.getStringExtra("k_sns_label_add_label");
      this.Aen.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100139);
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, (ArrayList)com.tencent.mm.plugin.label.a.a.dfo().dfj());
          if (JsapiSnsLabelUI.j(JsapiSnsLabelUI.this) == null) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, new ArrayList());
          }
          if (!bt.isNullOrNil(this.AeK)) {
            if (!JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).contains(this.AeK)) {
              JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).add(this.AeK);
            }
          }
          for (int i = JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).indexOf(this.AeK);; i = -1)
          {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).az(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
            JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeQ = JsapiSnsLabelUI.l(JsapiSnsLabelUI.this);
            if ((!bt.isNullOrNil(this.AeK)) && (i != -1))
            {
              if (JsapiSnsLabelUI.l(JsapiSnsLabelUI.this) != JsapiSnsLabelUI.this.AxU) {
                break label252;
              }
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeS.add(this.AeK);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeU.clear();
            }
            for (;;)
            {
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).notifyDataSetChanged();
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).expandGroup(JsapiSnsLabelUI.l(JsapiSnsLabelUI.this));
              JsapiSnsLabelUI.m(JsapiSnsLabelUI.this);
              AppMethodBeat.o(100139);
              return;
              label252:
              if (JsapiSnsLabelUI.l(JsapiSnsLabelUI.this) == JsapiSnsLabelUI.this.AxV)
              {
                JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeT.add(this.AeK);
                JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeV.clear();
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
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(292, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(635, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(638, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(290, this);
    this.AxX = new a(this);
    this.AxX.Aye = false;
    this.AxX.Ayd = new a.b()
    {
      public final void a(a.c paramAnonymousc)
      {
        AppMethodBeat.i(100130);
        int i = paramAnonymousc.Afd;
        int j = paramAnonymousc.Afe;
        JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i, j);
        AppMethodBeat.o(100130);
      }
    };
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      this.Aeu = this.AxS;
      this.AxX.style = 0;
      this.Aeq = null;
      this.Aer = null;
      this.AxX.AeQ = this.Aeu;
      if (this.AxX.style == 1) {
        findViewById(2131304992).setBackgroundResource(2131100017);
      }
      if (this.Aeu != this.AxU) {
        break label802;
      }
      if (!TextUtils.isEmpty(this.Aeq)) {
        this.AxX.AeS = bt.U(this.Aeq.split(","));
      }
      if (!TextUtils.isEmpty(this.Aer)) {
        this.AxX.AeU = bt.U(this.Aer.split(","));
      }
    }
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList;
    for (;;)
    {
      com.tencent.mm.kernel.g.ajD();
      this.Aev = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(335873, Boolean.TRUE)).booleanValue();
      if (this.Aev)
      {
        this.Aex = true;
        this.Aey = true;
        if (ecg() > 0) {
          this.Aew = true;
        }
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(new u(1), 0);
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
      this.AxY.clear();
      localObject1 = new ArrayList();
      localArrayList = new ArrayList();
      if (bool1)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[0]));
        localArrayList.add(Integer.valueOf(localObject2[0]));
        this.AxY.add(this.AxW.get(0));
      }
      if (bool2)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[1]));
        localArrayList.add(Integer.valueOf(localObject2[1]));
        this.AxY.add(this.AxW.get(1));
      }
      if (bool3)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[2]));
        localArrayList.add(Integer.valueOf(localObject2[2]));
        this.AxY.add(this.AxW.get(2));
      }
      if (bool4)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[3]));
        localArrayList.add(Integer.valueOf(localObject2[3]));
        this.AxY.add(this.AxW.get(3));
      }
      if (this.AxY.size() != 0) {
        break label874;
      }
      finish();
      AppMethodBeat.o(100144);
      return;
      if (paramBundle.hasExtra("k_title")) {
        setMMTitle(paramBundle.getStringExtra("k_title"));
      }
      this.Aeu = paramBundle.getIntExtra("KLabel_range_index", this.AxS);
      this.AxX.style = paramBundle.getIntExtra("k_sns_label_ui_style", 0);
      this.Aeq = paramBundle.getStringExtra("Klabel_name_list");
      this.Aer = paramBundle.getStringExtra("Kother_user_name_list");
      if (TextUtils.isEmpty(paramBundle.getStringExtra("k_sns_label_ui_title"))) {
        break;
      }
      setMMTitle(paramBundle.getStringExtra("k_sns_label_ui_title"));
      break;
      label802:
      if (this.Aeu == this.AxV)
      {
        if (!TextUtils.isEmpty(this.Aeq)) {
          this.AxX.AeT = bt.U(this.Aeq.split(","));
        }
        if (!TextUtils.isEmpty(this.Aer)) {
          this.AxX.AeV = bt.U(this.Aer.split(","));
        }
      }
    }
    label874:
    this.AxS = this.AxY.indexOf("public");
    this.AxT = this.AxY.indexOf("private");
    this.AxU = this.AxY.indexOf("visible");
    this.AxV = this.AxY.indexOf("invisible");
    if (this.AxX != null)
    {
      localObject2 = this.AxX;
      List localList = this.AxY;
      ((a)localObject2).Ayc = localList;
      ((a)localObject2).AxS = localList.indexOf("public");
      ((a)localObject2).AxT = localList.indexOf("private");
      ((a)localObject2).AxU = localList.indexOf("visible");
      ((a)localObject2).AxV = localList.indexOf("invisible");
      this.AxX.Ayb = ((List)localObject1).size();
      this.AxX.Aeo = gd((List)localObject1);
      this.AxX.AeO = gd(localArrayList);
      if (!TextUtils.isEmpty(paramBundle))
      {
        this.AxX.AeQ = this.AxY.indexOf(paramBundle);
        if (paramBundle.equals("visible"))
        {
          if (!TextUtils.isEmpty(this.Aeq)) {
            this.AxX.AeS = bt.U(this.Aeq.split(","));
          }
          if (!TextUtils.isEmpty(this.Aer)) {
            this.AxX.AeU = bt.U(this.Aer.split(","));
          }
          this.Aen.expandGroup(this.AxY.indexOf(paramBundle));
          AppMethodBeat.o(100144);
          return;
        }
        if (paramBundle.equals("invisible"))
        {
          if (!TextUtils.isEmpty(this.Aeq)) {
            this.AxX.AeT = bt.U(this.Aeq.split(","));
          }
          if (!TextUtils.isEmpty(this.Aer)) {
            this.AxX.AeV = bt.U(this.Aer.split(","));
          }
          this.Aen.expandGroup(this.AxY.indexOf(paramBundle));
        }
      }
    }
    label1265:
    AppMethodBeat.o(100144);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(100158);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(292, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(635, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(638, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(290, this);
    super.onDestroy();
    AppMethodBeat.o(100158);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(100159);
    if ((this.AxX != null) && (this.AeB == null) && (this.Aen != null)) {
      this.Aen.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100131);
          com.tencent.mm.plugin.label.a.a.dfo().aox();
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, (ArrayList)com.tencent.mm.plugin.label.a.a.dfo().dfj());
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).az(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
          JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
          if (((JsapiSnsLabelUI.j(JsapiSnsLabelUI.this) == null) || (JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).size() == 0)) && ((JsapiSnsLabelUI.p(JsapiSnsLabelUI.this) == null) || (JsapiSnsLabelUI.p(JsapiSnsLabelUI.this).length() == 0)) && (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeQ != JsapiSnsLabelUI.this.AxS) && (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeQ != JsapiSnsLabelUI.this.AxT)) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeQ = JsapiSnsLabelUI.this.AxS;
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
    if (!this.Aex)
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
        localObject = ag.dUk().getCursor();
        this.AeC = ((Cursor)localObject).getCount();
        if (this.AeC > 0)
        {
          ((Cursor)localObject).moveToFirst();
          v localv = new v();
          paramInt1 = ((Cursor)localObject).getCount();
          this.AeE = new ArrayList(paramInt1);
          this.AeD = new ArrayList(paramInt1);
          this.AeG = new ArrayList(paramInt1);
          this.AeF = new ArrayList(paramInt1);
          if (!((Cursor)localObject).isAfterLast())
          {
            localv.convertFrom((Cursor)localObject);
            if ((localv.field_memberList != null) && (localv.field_memberList.length() != 0))
            {
              this.AeG.add(localv.field_memberList.split(","));
              paramn = localv.field_tagName;
              ArrayList localArrayList = this.AeE;
              paramString = com.tencent.mm.plugin.label.a.a.dfo().dfl();
              if (paramString == null)
              {
                paramString = paramn;
                label297:
                localArrayList.add(paramString);
                this.AeD.add(paramn);
                this.AeF.add(Long.valueOf(localv.field_tagId));
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
          if (this.AeD.size() != 0) {
            break label508;
          }
          paramInt1 = 0;
          if (paramInt1 != 0) {}
        }
        else if (this.Aey)
        {
          this.AxX.AeQ = this.Aez;
          this.Aen.afw(this.Aez);
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(335873, Boolean.FALSE);
        }
        ((Cursor)localObject).close();
        if (this.Aew)
        {
          this.Aex = true;
          com.tencent.mm.plugin.label.a.a.dfo().ek(this.AeE);
        }
      }
      for (;;)
      {
        this.Aey = false;
        AppMethodBeat.o(100160);
        return;
        label508:
        paramInt1 = 1;
        break;
        this.Aex = false;
        continue;
        eci();
        ad.i("MicroMsg.SnsLabelUI", "dz: error at get sns tag list!");
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        fX(this.AeG);
        AppMethodBeat.o(100160);
        return;
      }
      eci();
      ad.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
      AppMethodBeat.o(100160);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.AeD.iterator();
        paramn = this.AeF.iterator();
        while (paramString.hasNext())
        {
          long l = ((Long)paramn.next()).longValue();
          localObject = (String)paramString.next();
          if (l != 0L)
          {
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.a(new com.tencent.mm.plugin.sns.model.w(l, (String)localObject), 0);
          }
        }
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(335874, Integer.valueOf(0));
        this.Aep = ((ArrayList)com.tencent.mm.plugin.label.a.a.dfo().dfj());
        paramString = com.tencent.mm.plugin.report.service.g.yhR;
        paramInt2 = this.AeC;
        if (this.AeE == null) {}
        for (paramInt1 = 0;; paramInt1 = this.AeE.size())
        {
          paramString.f(11455, new Object[] { "", "", Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
          this.Aen.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100132);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeQ = JsapiSnsLabelUI.l(JsapiSnsLabelUI.this);
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
                    a.aAP((String)((Iterator)localObject).next());
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
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).az(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
              JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).notifyDataSetChanged();
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).afw(JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).AeQ);
              if ((JsapiSnsLabelUI.r(JsapiSnsLabelUI.this) != null) && (JsapiSnsLabelUI.r(JsapiSnsLabelUI.this).isShowing())) {
                JsapiSnsLabelUI.r(JsapiSnsLabelUI.this).dismiss();
              }
              AppMethodBeat.o(100132);
            }
          }, 600L);
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(335873, Boolean.FALSE);
          AppMethodBeat.o(100160);
          return;
        }
      }
      eci();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI
 * JD-Core Version:    0.7.0.1
 */