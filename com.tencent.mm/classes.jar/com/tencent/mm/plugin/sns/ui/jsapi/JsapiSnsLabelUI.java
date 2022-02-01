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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
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
  implements com.tencent.mm.ak.g
{
  public static int[] yMS = { 2131763871, 2131763869, 2131763865, 2131763856 };
  private AnimatedExpandableListView yMR;
  private ArrayList<String> yMT;
  private String yMU;
  private String yMV;
  private int yMY;
  private boolean yMZ;
  private boolean yNa;
  private boolean yNb;
  private boolean yNc;
  private int yNd;
  private com.tencent.mm.ui.base.p yNe;
  private String yNf;
  private int yNg;
  private ArrayList<String> yNh;
  private ArrayList<String> yNi;
  private ArrayList<Long> yNj;
  private ArrayList<String[]> yNk;
  public int zfT;
  public int zfU;
  public int zfV;
  public int zfW;
  private List<String> zfX;
  a zfY;
  List<String> zfZ;
  
  public JsapiSnsLabelUI()
  {
    AppMethodBeat.i(100142);
    this.zfT = 0;
    this.zfU = 1;
    this.zfV = 2;
    this.zfW = 3;
    this.zfX = Arrays.asList("public,private,visible,invisible".split(","));
    this.yMY = this.zfT;
    this.yNa = false;
    this.yNb = false;
    this.yNc = false;
    this.zfZ = new ArrayList();
    AppMethodBeat.o(100142);
  }
  
  private String PS(int paramInt)
  {
    AppMethodBeat.i(100153);
    if ((paramInt >= this.zfZ.size()) || (paramInt < 0))
    {
      AppMethodBeat.o(100153);
      return "";
    }
    String str = (String)this.zfZ.get(paramInt);
    AppMethodBeat.o(100153);
    return str;
  }
  
  private void aM(Intent paramIntent)
  {
    AppMethodBeat.i(100152);
    dPT();
    paramIntent.putExtra("Klabel_name_list", avV(this.yMU));
    paramIntent.putExtra("Kother_user_name_list", avU(this.yMV));
    paramIntent.putExtra("k_select_group", PS(this.zfY.yNu));
    AppMethodBeat.o(100152);
  }
  
  private static String avU(String paramString)
  {
    AppMethodBeat.i(100154);
    Object localObject = bs.lp(paramString, ",");
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
          localJSONObject.put("displayName", wk(str));
          localJSONObject.put("avatar", avW(str));
          paramString.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          ac.printErrStackTrace("MicroMsg.SnsLabelUI", localJSONException, "", new Object[0]);
        }
      }
    }
    paramString = paramString.toString();
    AppMethodBeat.o(100154);
    return paramString;
  }
  
  private static String avV(String paramString)
  {
    AppMethodBeat.i(100155);
    Object localObject1 = bs.lp(paramString, ",");
    paramString = new JSONObject();
    com.tencent.mm.plugin.label.a.b localb = com.tencent.mm.plugin.label.a.a.cWd();
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
          localObject2 = localb.ajD(localb.ajA((String)localObject2));
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              String str = (String)((Iterator)localObject2).next();
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("username", str);
              localJSONObject.put("displayName", wk(str));
              localJSONObject.put("avatar", avW(str));
              localJSONArray.put(localJSONObject);
            }
          }
        }
        catch (JSONException localJSONException)
        {
          ac.printErrStackTrace("MicroMsg.SnsLabelUI", localJSONException, "", new Object[0]);
        }
      }
    }
    paramString = paramString.toString();
    AppMethodBeat.o(100155);
    return paramString;
  }
  
  private static String avW(String paramString)
  {
    AppMethodBeat.i(100157);
    paramString = com.tencent.mm.aj.p.aBw().Ak(paramString);
    if (paramString != null)
    {
      paramString = paramString.aBp();
      AppMethodBeat.o(100157);
      return paramString;
    }
    AppMethodBeat.o(100157);
    return "";
  }
  
  private boolean dPM()
  {
    AppMethodBeat.i(100148);
    boolean bool2 = false;
    int i = this.zfY.yNu;
    boolean bool1;
    if (this.zfY.yNu != this.yMY) {
      if (((i == this.zfV) && ((this.zfY.yNw.size() != 0) || (this.zfY.yNy.size() != 0))) || ((i == this.zfW) && ((this.zfY.yNx.size() != 0) || (this.zfY.yNz.size() != 0)))) {
        bool1 = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(100148);
      return bool1;
      if (i != this.zfU)
      {
        bool1 = bool2;
        if (i != this.zfT) {}
      }
      else
      {
        bool1 = true;
        continue;
        if ((i != this.zfV) || (this.zfY.yNw.size() == 0) || ((bs.n(this.zfY.yNw, ",").equals(this.yMU)) && (bs.n(this.zfY.yNy, ",").equals(this.yMV))))
        {
          bool1 = bool2;
          if (i != this.zfW) {
            continue;
          }
          bool1 = bool2;
          if (this.zfY.yNx.size() == 0) {
            continue;
          }
          if (bs.n(this.zfY.yNx, ",").equals(this.yMU))
          {
            bool1 = bool2;
            if (bs.n(this.zfY.yNz, ",").equals(this.yMV)) {
              continue;
            }
          }
        }
        bool1 = true;
      }
    }
  }
  
  private void dPN()
  {
    AppMethodBeat.i(100150);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ktag_range_index", this.yMY);
    aM(localIntent);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(100150);
  }
  
  private static int dPP()
  {
    AppMethodBeat.i(100161);
    com.tencent.mm.kernel.g.agS();
    int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(335874, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(100161);
    return i;
  }
  
  private static void dPQ()
  {
    AppMethodBeat.i(100162);
    com.tencent.mm.kernel.g.agS();
    int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(335874, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agA().set(335874, Integer.valueOf(i + 1));
    AppMethodBeat.o(100162);
  }
  
  private void dPR()
  {
    AppMethodBeat.i(100163);
    com.tencent.mm.plugin.report.service.h.wUl.f(11455, new Object[] { "", "", Integer.valueOf(this.yNg), Integer.valueOf(0) });
    dPQ();
    this.yNi = null;
    this.yNc = false;
    this.yNb = false;
    if ((this.yNe != null) && (this.yNe.isShowing())) {
      this.yNe.dismiss();
    }
    if (this.yNa)
    {
      this.yNa = false;
      AppMethodBeat.o(100163);
      return;
    }
    int i = 2131763879;
    if (dPP() > 1) {
      i = 2131763878;
    }
    com.tencent.mm.ui.base.h.a(this, i, 2131755835, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(100163);
  }
  
  private void dPS()
  {
    AppMethodBeat.i(100165);
    if ((this.yMT == null) || (this.yMT.isEmpty()))
    {
      if (this.zfY.yNw != null) {
        this.zfY.yNw.clear();
      }
      if (this.zfY.yNx != null) {
        this.zfY.yNx.clear();
      }
      AppMethodBeat.o(100165);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    String str;
    if ((this.zfZ.size() > 0) && ("visible".equals(PS(this.yMY))) && (this.zfY.yNw != null))
    {
      localIterator = this.zfY.yNw.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.yMT.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.zfY.yNw.removeAll(localArrayList);
      AppMethodBeat.o(100165);
      return;
    }
    if ((this.zfZ.size() > 0) && ("invisible".equals(PS(this.yMY))))
    {
      localIterator = this.zfY.yNx.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.yMT.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.zfY.yNx.removeAll(localArrayList);
    }
    AppMethodBeat.o(100165);
  }
  
  private void dPT()
  {
    AppMethodBeat.i(100166);
    if ((this.yMT == null) || (this.yMT.isEmpty()))
    {
      this.yMU = "";
      AppMethodBeat.o(100166);
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    if (this.yMU != null)
    {
      ArrayList localArrayList2 = bs.S(this.yMU.split(","));
      if (localArrayList2 != null)
      {
        Iterator localIterator = localArrayList2.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!this.yMT.contains(str)) {
            localArrayList1.add(str);
          }
        }
        localArrayList2.removeAll(localArrayList1);
        this.yMU = bs.n(localArrayList2, ",");
      }
    }
    AppMethodBeat.o(100166);
  }
  
  private void fM(List<String[]> paramList)
  {
    AppMethodBeat.i(100164);
    if ((this.yNi == null) || (this.yNi.size() == 0))
    {
      AppMethodBeat.o(100164);
      return;
    }
    Iterator localIterator = this.yNi.iterator();
    paramList = paramList.iterator();
    ArrayList localArrayList1 = new ArrayList(this.yNi.size());
    ArrayList localArrayList2 = new ArrayList(this.yNi.size());
    while (localIterator.hasNext())
    {
      localArrayList1.add(com.tencent.mm.plugin.label.a.a.cWd().ajA((String)localIterator.next()));
      localArrayList2.add(bs.n(Arrays.asList((Object[])paramList.next()), ","));
      this.yNb = true;
    }
    com.tencent.mm.plugin.label.a.a.cWd().m(localArrayList1, localArrayList2);
    AppMethodBeat.o(100164);
  }
  
  private static int[] fS(List<Integer> paramList)
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
    if (dPM())
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
    dPN();
    AppMethodBeat.o(100149);
  }
  
  private static String wk(String paramString)
  {
    AppMethodBeat.i(100156);
    paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk(paramString);
    AppMethodBeat.o(100156);
    return paramString;
  }
  
  final void dPO()
  {
    AppMethodBeat.i(100151);
    Intent localIntent = new Intent();
    if (this.zfY.yNu == this.zfV)
    {
      this.yMU = bs.n(this.zfY.yNw, ",");
      this.yMV = bs.n(this.zfY.yNy, ",");
      aM(localIntent);
    }
    for (;;)
    {
      localIntent.putExtra("k_select_group", PS(this.zfY.yNu));
      localIntent.putExtra("k_select_index", this.zfY.yNu);
      localIntent.putExtra("Ktag_range_index", this.zfY.yNu);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(100151);
      return;
      if (this.zfY.yNu == this.zfW)
      {
        this.yMU = bs.n(this.zfY.yNx, ",");
        this.yMV = bs.n(this.zfY.yNz, ",");
        aM(localIntent);
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
    this.yMR = ((AnimatedExpandableListView)findViewById(2131304991));
    this.yMT = ((ArrayList)com.tencent.mm.plugin.label.a.a.cWd().cVY());
    this.zfY.yNv = bool;
    this.zfY.aB(this.yMT);
    dPS();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    localLayoutParams.height = getResources().getDimensionPixelSize(2131165483);
    View localView = new View(this);
    localView.setLayoutParams(localLayoutParams);
    this.yMR.addHeaderView(localView);
    this.yMR.setAdapter(this.zfY);
    this.yMR.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
    {
      public final boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100134);
        int i = JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNu;
        ac.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt) });
        if ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, paramAnonymousInt).equals("visible")) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, paramAnonymousInt).equals("invisible")))
        {
          if ((JsapiSnsLabelUI.b(JsapiSnsLabelUI.this) != null) && (JsapiSnsLabelUI.b(JsapiSnsLabelUI.this).size() != 0) && (JsapiSnsLabelUI.dRP() == 0))
          {
            JsapiSnsLabelUI.b(JsapiSnsLabelUI.this, paramAnonymousInt);
            JsapiSnsLabelUI.c(JsapiSnsLabelUI.this);
            ac.i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
            AppMethodBeat.o(100134);
            return true;
          }
          if (JsapiSnsLabelUI.d(JsapiSnsLabelUI.this))
          {
            JsapiSnsLabelUI.e(JsapiSnsLabelUI.this);
            JsapiSnsLabelUI.b(JsapiSnsLabelUI.this, paramAnonymousInt);
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, com.tencent.mm.ui.base.h.b(JsapiSnsLabelUI.this, JsapiSnsLabelUI.this.getString(2131763867), false, null));
            ac.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
            AppMethodBeat.o(100134);
            return true;
          }
          if ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNt == null) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNt.size() == 0))
          {
            JsapiSnsLabelUI.b(JsapiSnsLabelUI.this, paramAnonymousInt);
            JsapiSnsLabelUI.f(JsapiSnsLabelUI.this);
            ac.i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
            AppMethodBeat.o(100134);
            return true;
          }
          if (i == paramAnonymousInt)
          {
            if (JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).isGroupExpanded(paramAnonymousInt)) {
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).acW(paramAnonymousInt);
            }
            for (;;)
            {
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNu = paramAnonymousInt;
              AppMethodBeat.o(100134);
              return true;
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).acV(paramAnonymousInt);
            }
          }
          if (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("visible"))
          {
            JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).collapseGroup(i);
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNw.clear();
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNy.clear();
          }
          for (;;)
          {
            JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100133);
                JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).acV(paramAnonymousInt);
                AppMethodBeat.o(100133);
              }
            });
            break;
            if (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("invisible"))
            {
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).collapseGroup(i);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNx.clear();
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNz.clear();
            }
          }
        }
        if ((i >= 0) && ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("visible")) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("invisible")))) {
          JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).acW(i);
        }
        JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNu = paramAnonymousInt;
        AppMethodBeat.o(100134);
        return false;
      }
    });
    this.yMR.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
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
          a.avI(paramAnonymousExpandableListView);
          if (paramAnonymousInt1 == JsapiSnsLabelUI.this.zfV) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, 1, JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNw, paramAnonymousExpandableListView, paramAnonymousView);
          } else if (paramAnonymousInt1 == JsapiSnsLabelUI.this.zfW) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, 2, JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNx, paramAnonymousExpandableListView, paramAnonymousView);
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
        String str1 = bs.n(paramAnonymousMenuItem.zfY.yNw, ",");
        String str2 = bs.n(paramAnonymousMenuItem.zfY.yNy, ",");
        String str3 = bs.n(paramAnonymousMenuItem.zfY.yNx, ",");
        String str4 = bs.n(paramAnonymousMenuItem.zfY.yNz, ",");
        if (((paramAnonymousMenuItem.zfY.yNu == paramAnonymousMenuItem.zfV) && (paramAnonymousMenuItem.zfY.yNw.size() == 0) && (paramAnonymousMenuItem.zfY.yNy.size() == 0)) || ((paramAnonymousMenuItem.zfY.yNu == paramAnonymousMenuItem.zfW) && (paramAnonymousMenuItem.zfY.yNx.size() == 0) && (paramAnonymousMenuItem.zfY.yNz.size() == 0))) {
          com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131763868), "", paramAnonymousMenuItem.getString(2131763880), null);
        }
        for (;;)
        {
          AppMethodBeat.o(100137);
          return true;
          if (((paramAnonymousMenuItem.zfY.yNu == paramAnonymousMenuItem.zfV) && (bs.isNullOrNil(str1)) && (bs.isNullOrNil(str2))) || ((paramAnonymousMenuItem.zfY.yNu == paramAnonymousMenuItem.zfW) && (bs.isNullOrNil(str3)) && (bs.isNullOrNil(str4)))) {
            com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131763868), "", paramAnonymousMenuItem.getString(2131763880), null);
          } else {
            paramAnonymousMenuItem.dPO();
          }
        }
      }
    }, null, s.b.Hom);
    AppMethodBeat.o(100146);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(100147);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if ((paramInt2 == -1) && (paramInt1 == 4003))
    {
      ac.i("MicroMsg.SnsLabelUI", "the Activity completed");
      localObject = paramIntent.getStringExtra("Select_Contacts_To_Create_New_Label");
      if (!bs.isNullOrNil((String)localObject))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("Select_Contact", (String)localObject);
        d.b(getContext(), "label", ".ui.ContactLabelEditUI", paramIntent, 4002);
        AppMethodBeat.o(100147);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      this.yMV = new String(paramIntent);
      ac.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.yNd == this.zfV)
      {
        this.zfY.yNy.clear();
        if (!bs.isNullOrNil(paramIntent))
        {
          paramIntent = bs.S(paramIntent.split(","));
          this.zfY.yNy.addAll(paramIntent);
          this.zfY.yNu = this.yNd;
        }
      }
      for (;;)
      {
        this.zfY.notifyDataSetChanged();
        this.yMR.expandGroup(this.yNd);
        AppMethodBeat.o(100147);
        return;
        if (this.yNd == this.zfW)
        {
          this.zfY.yNz.clear();
          if (!bs.isNullOrNil(paramIntent))
          {
            paramIntent = bs.S(paramIntent.split(","));
            this.zfY.yNz.addAll(paramIntent);
            this.zfY.yNu = this.yNd;
          }
        }
      }
    }
    if ((paramInt2 == -1) && (paramInt1 == 4001))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      ac.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (!bs.isNullOrNil(paramIntent))
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
      this.yNf = paramIntent.getStringExtra("k_sns_label_add_label");
      this.yMR.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100139);
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, (ArrayList)com.tencent.mm.plugin.label.a.a.cWd().cVY());
          if (JsapiSnsLabelUI.j(JsapiSnsLabelUI.this) == null) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, new ArrayList());
          }
          if (!bs.isNullOrNil(this.yNo)) {
            if (!JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).contains(this.yNo)) {
              JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).add(this.yNo);
            }
          }
          for (int i = JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).indexOf(this.yNo);; i = -1)
          {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).aB(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
            JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNu = JsapiSnsLabelUI.l(JsapiSnsLabelUI.this);
            if ((!bs.isNullOrNil(this.yNo)) && (i != -1))
            {
              if (JsapiSnsLabelUI.l(JsapiSnsLabelUI.this) != JsapiSnsLabelUI.this.zfV) {
                break label252;
              }
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNw.add(this.yNo);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNy.clear();
            }
            for (;;)
            {
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).notifyDataSetChanged();
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).expandGroup(JsapiSnsLabelUI.l(JsapiSnsLabelUI.this));
              JsapiSnsLabelUI.m(JsapiSnsLabelUI.this);
              AppMethodBeat.o(100139);
              return;
              label252:
              if (JsapiSnsLabelUI.l(JsapiSnsLabelUI.this) == JsapiSnsLabelUI.this.zfW)
              {
                JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNx.add(this.yNo);
                JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNz.clear();
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
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(292, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(635, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(638, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(290, this);
    this.zfY = new a(this);
    this.zfY.zgf = false;
    this.zfY.zge = new a.b()
    {
      public final void a(a.c paramAnonymousc)
      {
        AppMethodBeat.i(100130);
        int i = paramAnonymousc.yNH;
        int j = paramAnonymousc.yNI;
        JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i, j);
        AppMethodBeat.o(100130);
      }
    };
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      this.yMY = this.zfT;
      this.zfY.style = 0;
      this.yMU = null;
      this.yMV = null;
      this.zfY.yNu = this.yMY;
      if (this.zfY.style == 1) {
        findViewById(2131304992).setBackgroundResource(2131100017);
      }
      if (this.yMY != this.zfV) {
        break label801;
      }
      if (!TextUtils.isEmpty(this.yMU)) {
        this.zfY.yNw = bs.S(this.yMU.split(","));
      }
      if (!TextUtils.isEmpty(this.yMV)) {
        this.zfY.yNy = bs.S(this.yMV.split(","));
      }
    }
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList;
    for (;;)
    {
      com.tencent.mm.kernel.g.agS();
      this.yMZ = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(335873, Boolean.TRUE)).booleanValue();
      if (this.yMZ)
      {
        this.yNb = true;
        this.yNc = true;
        if (dPP() > 0) {
          this.yNa = true;
        }
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(new u(1), 0);
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
      this.zfZ.clear();
      localObject1 = new ArrayList();
      localArrayList = new ArrayList();
      if (bool1)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[0]));
        localArrayList.add(Integer.valueOf(localObject2[0]));
        this.zfZ.add(this.zfX.get(0));
      }
      if (bool2)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[1]));
        localArrayList.add(Integer.valueOf(localObject2[1]));
        this.zfZ.add(this.zfX.get(1));
      }
      if (bool3)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[2]));
        localArrayList.add(Integer.valueOf(localObject2[2]));
        this.zfZ.add(this.zfX.get(2));
      }
      if (bool4)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[3]));
        localArrayList.add(Integer.valueOf(localObject2[3]));
        this.zfZ.add(this.zfX.get(3));
      }
      if (this.zfZ.size() != 0) {
        break label873;
      }
      finish();
      AppMethodBeat.o(100144);
      return;
      if (paramBundle.hasExtra("k_title")) {
        setMMTitle(paramBundle.getStringExtra("k_title"));
      }
      this.yMY = paramBundle.getIntExtra("KLabel_range_index", this.zfT);
      this.zfY.style = paramBundle.getIntExtra("k_sns_label_ui_style", 0);
      this.yMU = paramBundle.getStringExtra("Klabel_name_list");
      this.yMV = paramBundle.getStringExtra("Kother_user_name_list");
      if (TextUtils.isEmpty(paramBundle.getStringExtra("k_sns_label_ui_title"))) {
        break;
      }
      setMMTitle(paramBundle.getStringExtra("k_sns_label_ui_title"));
      break;
      label801:
      if (this.yMY == this.zfW)
      {
        if (!TextUtils.isEmpty(this.yMU)) {
          this.zfY.yNx = bs.S(this.yMU.split(","));
        }
        if (!TextUtils.isEmpty(this.yMV)) {
          this.zfY.yNz = bs.S(this.yMV.split(","));
        }
      }
    }
    label873:
    this.zfT = this.zfZ.indexOf("public");
    this.zfU = this.zfZ.indexOf("private");
    this.zfV = this.zfZ.indexOf("visible");
    this.zfW = this.zfZ.indexOf("invisible");
    if (this.zfY != null)
    {
      localObject2 = this.zfY;
      List localList = this.zfZ;
      ((a)localObject2).zgd = localList;
      ((a)localObject2).zfT = localList.indexOf("public");
      ((a)localObject2).zfU = localList.indexOf("private");
      ((a)localObject2).zfV = localList.indexOf("visible");
      ((a)localObject2).zfW = localList.indexOf("invisible");
      this.zfY.zgc = ((List)localObject1).size();
      this.zfY.yMS = fS((List)localObject1);
      this.zfY.yNs = fS(localArrayList);
      if (!TextUtils.isEmpty(paramBundle))
      {
        this.zfY.yNu = this.zfZ.indexOf(paramBundle);
        if (paramBundle.equals("visible"))
        {
          if (!TextUtils.isEmpty(this.yMU)) {
            this.zfY.yNw = bs.S(this.yMU.split(","));
          }
          if (!TextUtils.isEmpty(this.yMV)) {
            this.zfY.yNy = bs.S(this.yMV.split(","));
          }
          this.yMR.expandGroup(this.zfZ.indexOf(paramBundle));
          AppMethodBeat.o(100144);
          return;
        }
        if (paramBundle.equals("invisible"))
        {
          if (!TextUtils.isEmpty(this.yMU)) {
            this.zfY.yNx = bs.S(this.yMU.split(","));
          }
          if (!TextUtils.isEmpty(this.yMV)) {
            this.zfY.yNz = bs.S(this.yMV.split(","));
          }
          this.yMR.expandGroup(this.zfZ.indexOf(paramBundle));
        }
      }
    }
    label1264:
    AppMethodBeat.o(100144);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(100158);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(292, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(635, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(638, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(290, this);
    super.onDestroy();
    AppMethodBeat.o(100158);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(100159);
    if ((this.zfY != null) && (this.yNf == null) && (this.yMR != null)) {
      this.yMR.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100131);
          com.tencent.mm.plugin.label.a.a.cWd().alK();
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, (ArrayList)com.tencent.mm.plugin.label.a.a.cWd().cVY());
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).aB(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
          JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
          if (((JsapiSnsLabelUI.j(JsapiSnsLabelUI.this) == null) || (JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).size() == 0)) && ((JsapiSnsLabelUI.p(JsapiSnsLabelUI.this) == null) || (JsapiSnsLabelUI.p(JsapiSnsLabelUI.this).length() == 0)) && (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNu != JsapiSnsLabelUI.this.zfT) && (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNu != JsapiSnsLabelUI.this.zfU)) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNu = JsapiSnsLabelUI.this.zfT;
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
    ac.i("MicroMsg.SnsLabelUI", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!this.yNb)
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
        localObject = af.dHX().getCursor();
        this.yNg = ((Cursor)localObject).getCount();
        if (this.yNg > 0)
        {
          ((Cursor)localObject).moveToFirst();
          v localv = new v();
          paramInt1 = ((Cursor)localObject).getCount();
          this.yNi = new ArrayList(paramInt1);
          this.yNh = new ArrayList(paramInt1);
          this.yNk = new ArrayList(paramInt1);
          this.yNj = new ArrayList(paramInt1);
          if (!((Cursor)localObject).isAfterLast())
          {
            localv.convertFrom((Cursor)localObject);
            if ((localv.field_memberList != null) && (localv.field_memberList.length() != 0))
            {
              this.yNk.add(localv.field_memberList.split(","));
              paramn = localv.field_tagName;
              ArrayList localArrayList = this.yNi;
              paramString = com.tencent.mm.plugin.label.a.a.cWd().cWa();
              if (paramString == null)
              {
                paramString = paramn;
                label297:
                localArrayList.add(paramString);
                this.yNh.add(paramn);
                this.yNj.add(Long.valueOf(localv.field_tagId));
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
              ac.e("MicroMsg.SnsLabelUI", "dz:snstaginfo memberlist is null.");
            }
          }
          ((Cursor)localObject).close();
          if (this.yNh.size() != 0) {
            break label508;
          }
          paramInt1 = 0;
          if (paramInt1 != 0) {}
        }
        else if (this.yNc)
        {
          this.zfY.yNu = this.yNd;
          this.yMR.acV(this.yNd);
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(335873, Boolean.FALSE);
        }
        ((Cursor)localObject).close();
        if (this.yNa)
        {
          this.yNb = true;
          com.tencent.mm.plugin.label.a.a.cWd().dX(this.yNi);
        }
      }
      for (;;)
      {
        this.yNc = false;
        AppMethodBeat.o(100160);
        return;
        label508:
        paramInt1 = 1;
        break;
        this.yNb = false;
        continue;
        dPR();
        ac.i("MicroMsg.SnsLabelUI", "dz: error at get sns tag list!");
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        fM(this.yNk);
        AppMethodBeat.o(100160);
        return;
      }
      dPR();
      ac.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
      AppMethodBeat.o(100160);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.yNh.iterator();
        paramn = this.yNj.iterator();
        while (paramString.hasNext())
        {
          long l = ((Long)paramn.next()).longValue();
          localObject = (String)paramString.next();
          if (l != 0L)
          {
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.a(new com.tencent.mm.plugin.sns.model.w(l, (String)localObject), 0);
          }
        }
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(335874, Integer.valueOf(0));
        this.yMT = ((ArrayList)com.tencent.mm.plugin.label.a.a.cWd().cVY());
        paramString = com.tencent.mm.plugin.report.service.h.wUl;
        paramInt2 = this.yNg;
        if (this.yNi == null) {}
        for (paramInt1 = 0;; paramInt1 = this.yNi.size())
        {
          paramString.f(11455, new Object[] { "", "", Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
          this.yMR.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100132);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNu = JsapiSnsLabelUI.l(JsapiSnsLabelUI.this);
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
                    a.avI((String)((Iterator)localObject).next());
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
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).aB(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
              JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).notifyDataSetChanged();
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).acV(JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).yNu);
              if ((JsapiSnsLabelUI.r(JsapiSnsLabelUI.this) != null) && (JsapiSnsLabelUI.r(JsapiSnsLabelUI.this).isShowing())) {
                JsapiSnsLabelUI.r(JsapiSnsLabelUI.this).dismiss();
              }
              AppMethodBeat.o(100132);
            }
          }, 600L);
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(335873, Boolean.FALSE);
          AppMethodBeat.o(100160);
          return;
        }
      }
      dPR();
      ac.i("MicroMsg.SnsLabelUI", "dz: error at modify label list!");
      AppMethodBeat.o(100160);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        ac.i("MicroMsg.SnsLabelUI", "dz: error at delete tag list!");
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