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
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w.b;
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
  implements i
{
  public static int[] KSE = { i.j.sns_label_public, i.j.sns_label_private, i.j.sns_label_include, i.j.sns_label_exclude };
  private com.tencent.mm.ui.base.s JII;
  private AnimatedExpandableListView KSD;
  private ArrayList<String> KSF;
  private String KSG;
  private String KSH;
  private int KSL;
  private boolean KSN;
  private boolean KSO;
  private boolean KSP;
  private boolean KSQ;
  private int KSR;
  private String KSS;
  private int KSU;
  private ArrayList<String> KSV;
  private ArrayList<String> KSW;
  private ArrayList<Long> KSX;
  private ArrayList<String[]> KSY;
  public int Los;
  public int Lot;
  public int Lou;
  public int Lov;
  private List<String> Low;
  a Lox;
  List<String> Loy;
  
  public JsapiSnsLabelUI()
  {
    AppMethodBeat.i(100142);
    this.Los = 0;
    this.Lot = 1;
    this.Lou = 2;
    this.Lov = 3;
    this.Low = Arrays.asList("public,private,visible,invisible".split(","));
    this.KSL = this.Los;
    this.KSO = false;
    this.KSP = false;
    this.KSQ = false;
    this.Loy = new ArrayList();
    AppMethodBeat.o(100142);
  }
  
  private static String PJ(String paramString)
  {
    AppMethodBeat.i(100156);
    paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(paramString);
    AppMethodBeat.o(100156);
    return paramString;
  }
  
  private String ahz(int paramInt)
  {
    AppMethodBeat.i(100153);
    if ((paramInt >= this.Loy.size()) || (paramInt < 0))
    {
      AppMethodBeat.o(100153);
      return "";
    }
    String str = (String)this.Loy.get(paramInt);
    AppMethodBeat.o(100153);
    return str;
  }
  
  private void bc(Intent paramIntent)
  {
    AppMethodBeat.i(100152);
    fWD();
    paramIntent.putExtra("Klabel_name_list", bct(this.KSG));
    paramIntent.putExtra("Kother_user_name_list", bcs(this.KSH));
    paramIntent.putExtra("k_select_group", ahz(this.Lox.KTi));
    AppMethodBeat.o(100152);
  }
  
  private static String bcs(String paramString)
  {
    AppMethodBeat.i(100154);
    Object localObject = Util.stringToList(paramString, ",");
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
          localJSONObject.put("displayName", PJ(str));
          localJSONObject.put("avatar", bcu(str));
          paramString.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          Log.printErrStackTrace("MicroMsg.SnsLabelUI", localJSONException, "", new Object[0]);
        }
      }
    }
    paramString = paramString.toString();
    AppMethodBeat.o(100154);
    return paramString;
  }
  
  private static String bct(String paramString)
  {
    AppMethodBeat.i(100155);
    Object localObject1 = Util.stringToList(paramString, ",");
    paramString = new JSONObject();
    com.tencent.mm.plugin.label.a.b localb = com.tencent.mm.plugin.label.a.a.eLe();
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
          localObject2 = localb.aMR(localb.aMO((String)localObject2));
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              String str = (String)((Iterator)localObject2).next();
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("username", str);
              localJSONObject.put("displayName", PJ(str));
              localJSONObject.put("avatar", bcu(str));
              localJSONArray.put(localJSONObject);
            }
          }
        }
        catch (JSONException localJSONException)
        {
          Log.printErrStackTrace("MicroMsg.SnsLabelUI", localJSONException, "", new Object[0]);
        }
      }
    }
    paramString = paramString.toString();
    AppMethodBeat.o(100155);
    return paramString;
  }
  
  private static String bcu(String paramString)
  {
    AppMethodBeat.i(100157);
    paramString = com.tencent.mm.am.q.bhP().TS(paramString);
    if (paramString != null)
    {
      paramString = paramString.bhI();
      AppMethodBeat.o(100157);
      return paramString;
    }
    AppMethodBeat.o(100157);
    return "";
  }
  
  private static void fWA()
  {
    AppMethodBeat.i(100162);
    com.tencent.mm.kernel.h.aHH();
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(335874, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().aHp().i(335874, Integer.valueOf(i + 1));
    AppMethodBeat.o(100162);
  }
  
  private void fWB()
  {
    AppMethodBeat.i(100163);
    com.tencent.mm.plugin.report.service.h.IzE.a(11455, new Object[] { "", "", Integer.valueOf(this.KSU), Integer.valueOf(0) });
    fWA();
    this.KSW = null;
    this.KSQ = false;
    this.KSP = false;
    if ((this.JII != null) && (this.JII.isShowing())) {
      this.JII.dismiss();
    }
    if (this.KSO)
    {
      this.KSO = false;
      AppMethodBeat.o(100163);
      return;
    }
    int i = i.j.sns_label_transform_failed_once;
    if (fWz() > 1) {
      i = i.j.sns_label_transform_failed_again;
    }
    com.tencent.mm.ui.base.h.a(this, i, i.j.app_ok, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(100163);
  }
  
  private void fWC()
  {
    AppMethodBeat.i(100165);
    if ((this.KSF == null) || (this.KSF.isEmpty()))
    {
      if (this.Lox.KTk != null) {
        this.Lox.KTk.clear();
      }
      if (this.Lox.KTl != null) {
        this.Lox.KTl.clear();
      }
      AppMethodBeat.o(100165);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    String str;
    if ((this.Loy.size() > 0) && ("visible".equals(ahz(this.KSL))) && (this.Lox.KTk != null))
    {
      localIterator = this.Lox.KTk.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.KSF.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.Lox.KTk.removeAll(localArrayList);
      AppMethodBeat.o(100165);
      return;
    }
    if ((this.Loy.size() > 0) && ("invisible".equals(ahz(this.KSL))))
    {
      localIterator = this.Lox.KTl.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.KSF.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.Lox.KTl.removeAll(localArrayList);
    }
    AppMethodBeat.o(100165);
  }
  
  private void fWD()
  {
    AppMethodBeat.i(100166);
    if ((this.KSF == null) || (this.KSF.isEmpty()))
    {
      this.KSG = "";
      AppMethodBeat.o(100166);
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    if (this.KSG != null)
    {
      ArrayList localArrayList2 = Util.stringsToList(this.KSG.split(","));
      if (localArrayList2 != null)
      {
        Iterator localIterator = localArrayList2.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!this.KSF.contains(str)) {
            localArrayList1.add(str);
          }
        }
        localArrayList2.removeAll(localArrayList1);
        this.KSG = Util.listToString(localArrayList2, ",");
      }
    }
    AppMethodBeat.o(100166);
  }
  
  private boolean fWw()
  {
    AppMethodBeat.i(100148);
    boolean bool2 = false;
    int i = this.Lox.KTi;
    boolean bool1;
    if (this.Lox.KTi != this.KSL) {
      if (((i == this.Lou) && ((this.Lox.KTk.size() != 0) || (this.Lox.KTm.size() != 0))) || ((i == this.Lov) && ((this.Lox.KTl.size() != 0) || (this.Lox.KTn.size() != 0)))) {
        bool1 = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(100148);
      return bool1;
      if (i != this.Lot)
      {
        bool1 = bool2;
        if (i != this.Los) {}
      }
      else
      {
        bool1 = true;
        continue;
        if ((i != this.Lou) || (this.Lox.KTk.size() == 0) || ((Util.listToString(this.Lox.KTk, ",").equals(this.KSG)) && (Util.listToString(this.Lox.KTm, ",").equals(this.KSH))))
        {
          bool1 = bool2;
          if (i != this.Lov) {
            continue;
          }
          bool1 = bool2;
          if (this.Lox.KTl.size() == 0) {
            continue;
          }
          if (Util.listToString(this.Lox.KTl, ",").equals(this.KSG))
          {
            bool1 = bool2;
            if (Util.listToString(this.Lox.KTn, ",").equals(this.KSH)) {
              continue;
            }
          }
        }
        bool1 = true;
      }
    }
  }
  
  private void fWx()
  {
    AppMethodBeat.i(100150);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ktag_range_index", this.KSL);
    bc(localIntent);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(100150);
  }
  
  private static int fWz()
  {
    AppMethodBeat.i(100161);
    com.tencent.mm.kernel.h.aHH();
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(335874, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(100161);
    return i;
  }
  
  private void goBack()
  {
    AppMethodBeat.i(100149);
    if (fWw())
    {
      com.tencent.mm.ui.base.h.a(this, true, getString(i.j.sns_label_goback_tip), "", getString(i.j.sns_label_goback_save), getString(i.j.sns_label_goback_notsave), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    fWx();
    AppMethodBeat.o(100149);
  }
  
  private void hM(List<String[]> paramList)
  {
    AppMethodBeat.i(100164);
    if ((this.KSW == null) || (this.KSW.size() == 0))
    {
      AppMethodBeat.o(100164);
      return;
    }
    Iterator localIterator = this.KSW.iterator();
    paramList = paramList.iterator();
    ArrayList localArrayList1 = new ArrayList(this.KSW.size());
    ArrayList localArrayList2 = new ArrayList(this.KSW.size());
    while (localIterator.hasNext())
    {
      localArrayList1.add(com.tencent.mm.plugin.label.a.a.eLe().aMO((String)localIterator.next()));
      localArrayList2.add(Util.listToString(Arrays.asList((Object[])paramList.next()), ","));
      this.KSP = true;
    }
    com.tencent.mm.plugin.label.a.a.eLe().s(localArrayList1, localArrayList2);
    AppMethodBeat.o(100164);
  }
  
  private static int[] hS(List<Integer> paramList)
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
  
  final void fWy()
  {
    AppMethodBeat.i(100151);
    Intent localIntent = new Intent();
    if (this.Lox.KTi == this.Lou)
    {
      this.KSG = Util.listToString(this.Lox.KTk, ",");
      this.KSH = Util.listToString(this.Lox.KTm, ",");
      bc(localIntent);
    }
    for (;;)
    {
      localIntent.putExtra("k_select_group", ahz(this.Lox.KTi));
      localIntent.putExtra("k_select_index", this.Lox.KTi);
      localIntent.putExtra("Ktag_range_index", this.Lox.KTi);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(100151);
      return;
      if (this.Lox.KTi == this.Lov)
      {
        this.KSG = Util.listToString(this.Lox.KTl, ",");
        this.KSH = Util.listToString(this.Lox.KTn, ",");
        bc(localIntent);
      }
    }
  }
  
  public int getLayoutId()
  {
    return i.g.sns_label;
  }
  
  public void initView()
  {
    AppMethodBeat.i(100146);
    boolean bool = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
    this.KSD = ((AnimatedExpandableListView)findViewById(i.f.sns_label_exlist));
    this.KSF = ((ArrayList)com.tencent.mm.plugin.label.a.a.eLe().eKZ());
    this.Lox.KTj = bool;
    this.Lox.bf(this.KSF);
    fWC();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    localLayoutParams.height = getResources().getDimensionPixelSize(i.d.LargerPadding);
    View localView = new View(this);
    localView.setLayoutParams(localLayoutParams);
    this.KSD.addHeaderView(localView);
    this.KSD.setAdapter(this.Lox);
    this.KSD.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
    {
      public final boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100134);
        int i = JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTi;
        Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt) });
        if ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, paramAnonymousInt).equals("visible")) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, paramAnonymousInt).equals("invisible")))
        {
          if ((JsapiSnsLabelUI.b(JsapiSnsLabelUI.this) != null) && (JsapiSnsLabelUI.b(JsapiSnsLabelUI.this).size() != 0) && (JsapiSnsLabelUI.fYC() == 0))
          {
            JsapiSnsLabelUI.b(JsapiSnsLabelUI.this, paramAnonymousInt);
            JsapiSnsLabelUI.c(JsapiSnsLabelUI.this);
            Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
            AppMethodBeat.o(100134);
            return true;
          }
          if (JsapiSnsLabelUI.d(JsapiSnsLabelUI.this))
          {
            JsapiSnsLabelUI.e(JsapiSnsLabelUI.this);
            JsapiSnsLabelUI.b(JsapiSnsLabelUI.this, paramAnonymousInt);
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, com.tencent.mm.ui.base.h.a(JsapiSnsLabelUI.this, JsapiSnsLabelUI.this.getString(i.j.sns_label_is_transforming), false, null));
            Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
            AppMethodBeat.o(100134);
            return true;
          }
          if ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTh == null) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTh.size() == 0))
          {
            JsapiSnsLabelUI.b(JsapiSnsLabelUI.this, paramAnonymousInt);
            JsapiSnsLabelUI.f(JsapiSnsLabelUI.this);
            Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
            AppMethodBeat.o(100134);
            return true;
          }
          if (i == paramAnonymousInt)
          {
            if (JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).isGroupExpanded(paramAnonymousInt)) {
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).ayz(paramAnonymousInt);
            }
            for (;;)
            {
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTi = paramAnonymousInt;
              AppMethodBeat.o(100134);
              return true;
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).ayy(paramAnonymousInt);
            }
          }
          if (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("visible"))
          {
            JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).collapseGroup(i);
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTk.clear();
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTm.clear();
          }
          for (;;)
          {
            JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100133);
                JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).ayy(paramAnonymousInt);
                AppMethodBeat.o(100133);
              }
            });
            break;
            if (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("invisible"))
            {
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).collapseGroup(i);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTl.clear();
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTn.clear();
            }
          }
        }
        if ((i >= 0) && ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("visible")) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("invisible")))) {
          JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).ayz(i);
        }
        JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTi = paramAnonymousInt;
        AppMethodBeat.o(100134);
        return false;
      }
    });
    this.KSD.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
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
          a.bcc(paramAnonymousExpandableListView);
          if (paramAnonymousInt1 == JsapiSnsLabelUI.this.Lou) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, 1, JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTk, paramAnonymousExpandableListView, paramAnonymousView);
          } else if (paramAnonymousInt1 == JsapiSnsLabelUI.this.Lov) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, 2, JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTl, paramAnonymousExpandableListView, paramAnonymousView);
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
    addTextOptionMenu(0, getString(i.j.sns_label_finish), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(100137);
        paramAnonymousMenuItem = JsapiSnsLabelUI.this;
        String str1 = Util.listToString(paramAnonymousMenuItem.Lox.KTk, ",");
        String str2 = Util.listToString(paramAnonymousMenuItem.Lox.KTm, ",");
        String str3 = Util.listToString(paramAnonymousMenuItem.Lox.KTl, ",");
        String str4 = Util.listToString(paramAnonymousMenuItem.Lox.KTn, ",");
        if (((paramAnonymousMenuItem.Lox.KTi == paramAnonymousMenuItem.Lou) && (paramAnonymousMenuItem.Lox.KTk.size() == 0) && (paramAnonymousMenuItem.Lox.KTm.size() == 0)) || ((paramAnonymousMenuItem.Lox.KTi == paramAnonymousMenuItem.Lov) && (paramAnonymousMenuItem.Lox.KTl.size() == 0) && (paramAnonymousMenuItem.Lox.KTn.size() == 0))) {
          com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(i.j.sns_label_need_select_one_least), "", paramAnonymousMenuItem.getString(i.j.sns_label_transform_ok), null);
        }
        for (;;)
        {
          AppMethodBeat.o(100137);
          return true;
          if (((paramAnonymousMenuItem.Lox.KTi == paramAnonymousMenuItem.Lou) && (Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2))) || ((paramAnonymousMenuItem.Lox.KTi == paramAnonymousMenuItem.Lov) && (Util.isNullOrNil(str3)) && (Util.isNullOrNil(str4)))) {
            com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(i.j.sns_label_need_select_one_least), "", paramAnonymousMenuItem.getString(i.j.sns_label_transform_ok), null);
          } else {
            paramAnonymousMenuItem.fWy();
          }
        }
      }
    }, null, w.b.Wao);
    AppMethodBeat.o(100146);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(100147);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if ((paramInt2 == -1) && (paramInt1 == 4003))
    {
      Log.i("MicroMsg.SnsLabelUI", "the Activity completed");
      localObject = paramIntent.getStringExtra("Select_Contacts_To_Create_New_Label");
      if (!Util.isNullOrNil((String)localObject))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("Select_Contact", (String)localObject);
        com.tencent.mm.by.c.b(getContext(), "label", ".ui.ContactLabelEditUI", paramIntent, 4002);
        AppMethodBeat.o(100147);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      this.KSH = new String(paramIntent);
      Log.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.KSR == this.Lou)
      {
        this.Lox.KTm.clear();
        if (!Util.isNullOrNil(paramIntent))
        {
          paramIntent = Util.stringsToList(paramIntent.split(","));
          this.Lox.KTm.addAll(paramIntent);
          this.Lox.KTi = this.KSR;
        }
      }
      for (;;)
      {
        this.Lox.notifyDataSetChanged();
        this.KSD.expandGroup(this.KSR);
        AppMethodBeat.o(100147);
        return;
        if (this.KSR == this.Lov)
        {
          this.Lox.KTn.clear();
          if (!Util.isNullOrNil(paramIntent))
          {
            paramIntent = Util.stringsToList(paramIntent.split(","));
            this.Lox.KTn.addAll(paramIntent);
            this.Lox.KTi = this.KSR;
          }
        }
      }
    }
    if ((paramInt2 == -1) && (paramInt1 == 4001))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      Log.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (!Util.isNullOrNil(paramIntent))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("Select_Contact", paramIntent);
        com.tencent.mm.by.c.b(this, "label", ".ui.ContactLabelEditUI", (Intent)localObject, 4002);
      }
      AppMethodBeat.o(100147);
      return;
    }
    if ((paramInt2 == 0) && (paramInt1 == 4002) && (paramIntent != null))
    {
      localObject = paramIntent.getStringExtra("k_sns_label_add_label");
      this.KSS = paramIntent.getStringExtra("k_sns_label_add_label");
      this.KSD.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100139);
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, (ArrayList)com.tencent.mm.plugin.label.a.a.eLe().eKZ());
          if (JsapiSnsLabelUI.j(JsapiSnsLabelUI.this) == null) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, new ArrayList());
          }
          if (!Util.isNullOrNil(this.KTc)) {
            if (!JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).contains(this.KTc)) {
              JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).add(this.KTc);
            }
          }
          for (int i = JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).indexOf(this.KTc);; i = -1)
          {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).bf(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
            JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTi = JsapiSnsLabelUI.l(JsapiSnsLabelUI.this);
            if ((!Util.isNullOrNil(this.KTc)) && (i != -1))
            {
              if (JsapiSnsLabelUI.l(JsapiSnsLabelUI.this) != JsapiSnsLabelUI.this.Lou) {
                break label252;
              }
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTk.add(this.KTc);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTm.clear();
            }
            for (;;)
            {
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).notifyDataSetChanged();
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).expandGroup(JsapiSnsLabelUI.l(JsapiSnsLabelUI.this));
              JsapiSnsLabelUI.m(JsapiSnsLabelUI.this);
              AppMethodBeat.o(100139);
              return;
              label252:
              if (JsapiSnsLabelUI.l(JsapiSnsLabelUI.this) == JsapiSnsLabelUI.this.Lov)
              {
                JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTl.add(this.KTc);
                JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTn.clear();
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
    setMMTitle(i.j.sns_tag_title);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(292, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(635, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(638, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(290, this);
    this.Lox = new a(this);
    this.Lox.LoE = false;
    this.Lox.LoD = new a.b()
    {
      public final void a(a.c paramAnonymousc)
      {
        AppMethodBeat.i(100130);
        int i = paramAnonymousc.KTy;
        int j = paramAnonymousc.KTz;
        JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i, j);
        AppMethodBeat.o(100130);
      }
    };
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      this.KSL = this.Los;
      this.Lox.style = 0;
      this.KSG = null;
      this.KSH = null;
      this.Lox.KTi = this.KSL;
      if (this.Lox.style == 1) {
        findViewById(i.f.sns_label_layout).setBackgroundResource(i.c.black);
      }
      if (this.KSL != this.Lou) {
        break label825;
      }
      if (!TextUtils.isEmpty(this.KSG)) {
        this.Lox.KTk = Util.stringsToList(this.KSG.split(","));
      }
      if (!TextUtils.isEmpty(this.KSH)) {
        this.Lox.KTm = Util.stringsToList(this.KSH.split(","));
      }
    }
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList;
    for (;;)
    {
      com.tencent.mm.kernel.h.aHH();
      this.KSN = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(335873, Boolean.TRUE)).booleanValue();
      if (this.KSN)
      {
        this.KSP = true;
        this.KSQ = true;
        if (fWz() > 0) {
          this.KSO = true;
        }
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(new w(1), 0);
      }
      initView();
      localObject1 = getIntent();
      if (localObject1 == null) {
        break label1288;
      }
      paramBundle = ((Intent)localObject1).getStringExtra("k_select_group");
      boolean bool1 = ((Intent)localObject1).getBooleanExtra("k_show_public", true);
      boolean bool2 = ((Intent)localObject1).getBooleanExtra("k_show_private", true);
      boolean bool3 = ((Intent)localObject1).getBooleanExtra("k_show_include", true);
      boolean bool4 = ((Intent)localObject1).getBooleanExtra("k_show_exclude", true);
      localObject2 = new int[4];
      localObject2[0] = i.j.sns_label_public;
      localObject2[1] = i.j.sns_label_private;
      localObject2[2] = i.j.sns_label_include;
      localObject2[3] = i.j.sns_label_exclude;
      int i = i.j.sns_label_public_hint;
      i = i.j.sns_label_private_hint;
      i = i.j.sns_label_include_hint;
      i = i.j.sns_label_exclude_hint;
      this.Loy.clear();
      localObject1 = new ArrayList();
      localArrayList = new ArrayList();
      if (bool1)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[0]));
        localArrayList.add(Integer.valueOf(localObject2[0]));
        this.Loy.add(this.Low.get(0));
      }
      if (bool2)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[1]));
        localArrayList.add(Integer.valueOf(localObject2[1]));
        this.Loy.add(this.Low.get(1));
      }
      if (bool3)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[2]));
        localArrayList.add(Integer.valueOf(localObject2[2]));
        this.Loy.add(this.Low.get(2));
      }
      if (bool4)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[3]));
        localArrayList.add(Integer.valueOf(localObject2[3]));
        this.Loy.add(this.Low.get(3));
      }
      if (this.Loy.size() != 0) {
        break label897;
      }
      finish();
      AppMethodBeat.o(100144);
      return;
      if (paramBundle.hasExtra("k_title")) {
        setMMTitle(paramBundle.getStringExtra("k_title"));
      }
      this.KSL = paramBundle.getIntExtra("KLabel_range_index", this.Los);
      this.Lox.style = paramBundle.getIntExtra("k_sns_label_ui_style", 0);
      this.KSG = paramBundle.getStringExtra("Klabel_name_list");
      this.KSH = paramBundle.getStringExtra("Kother_user_name_list");
      if (TextUtils.isEmpty(paramBundle.getStringExtra("k_sns_label_ui_title"))) {
        break;
      }
      setMMTitle(paramBundle.getStringExtra("k_sns_label_ui_title"));
      break;
      label825:
      if (this.KSL == this.Lov)
      {
        if (!TextUtils.isEmpty(this.KSG)) {
          this.Lox.KTl = Util.stringsToList(this.KSG.split(","));
        }
        if (!TextUtils.isEmpty(this.KSH)) {
          this.Lox.KTn = Util.stringsToList(this.KSH.split(","));
        }
      }
    }
    label897:
    this.Los = this.Loy.indexOf("public");
    this.Lot = this.Loy.indexOf("private");
    this.Lou = this.Loy.indexOf("visible");
    this.Lov = this.Loy.indexOf("invisible");
    if (this.Lox != null)
    {
      localObject2 = this.Lox;
      List localList = this.Loy;
      ((a)localObject2).LoC = localList;
      ((a)localObject2).Los = localList.indexOf("public");
      ((a)localObject2).Lot = localList.indexOf("private");
      ((a)localObject2).Lou = localList.indexOf("visible");
      ((a)localObject2).Lov = localList.indexOf("invisible");
      this.Lox.LoB = ((List)localObject1).size();
      this.Lox.KSE = hS((List)localObject1);
      this.Lox.KTg = hS(localArrayList);
      if (!TextUtils.isEmpty(paramBundle))
      {
        this.Lox.KTi = this.Loy.indexOf(paramBundle);
        if (paramBundle.equals("visible"))
        {
          if (!TextUtils.isEmpty(this.KSG)) {
            this.Lox.KTk = Util.stringsToList(this.KSG.split(","));
          }
          if (!TextUtils.isEmpty(this.KSH)) {
            this.Lox.KTm = Util.stringsToList(this.KSH.split(","));
          }
          this.KSD.expandGroup(this.Loy.indexOf(paramBundle));
          AppMethodBeat.o(100144);
          return;
        }
        if (paramBundle.equals("invisible"))
        {
          if (!TextUtils.isEmpty(this.KSG)) {
            this.Lox.KTl = Util.stringsToList(this.KSG.split(","));
          }
          if (!TextUtils.isEmpty(this.KSH)) {
            this.Lox.KTn = Util.stringsToList(this.KSH.split(","));
          }
          this.KSD.expandGroup(this.Loy.indexOf(paramBundle));
        }
      }
    }
    label1288:
    AppMethodBeat.o(100144);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(100158);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(292, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(635, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(638, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(290, this);
    super.onDestroy();
    AppMethodBeat.o(100158);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(100159);
    if ((this.Lox != null) && (this.KSS == null) && (this.KSD != null)) {
      this.KSD.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100131);
          com.tencent.mm.plugin.label.a.a.eLe().aPn();
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, (ArrayList)com.tencent.mm.plugin.label.a.a.eLe().eKZ());
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).bf(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
          JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
          if (((JsapiSnsLabelUI.j(JsapiSnsLabelUI.this) == null) || (JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).size() == 0)) && ((JsapiSnsLabelUI.p(JsapiSnsLabelUI.this) == null) || (JsapiSnsLabelUI.p(JsapiSnsLabelUI.this).length() == 0)) && (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTi != JsapiSnsLabelUI.this.Los) && (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTi != JsapiSnsLabelUI.this.Lot)) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTi = JsapiSnsLabelUI.this.Los;
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(100160);
    Log.i("MicroMsg.SnsLabelUI", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!this.KSP)
    {
      AppMethodBeat.o(100160);
      return;
    }
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(100160);
      return;
      Object localObject;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = aj.fOO().hK();
        this.KSU = ((Cursor)localObject).getCount();
        if (this.KSU > 0)
        {
          ((Cursor)localObject).moveToFirst();
          com.tencent.mm.plugin.sns.storage.s locals = new com.tencent.mm.plugin.sns.storage.s();
          paramInt1 = ((Cursor)localObject).getCount();
          this.KSW = new ArrayList(paramInt1);
          this.KSV = new ArrayList(paramInt1);
          this.KSY = new ArrayList(paramInt1);
          this.KSX = new ArrayList(paramInt1);
          if (!((Cursor)localObject).isAfterLast())
          {
            locals.convertFrom((Cursor)localObject);
            if ((locals.field_memberList != null) && (locals.field_memberList.length() != 0))
            {
              this.KSY.add(locals.field_memberList.split(","));
              paramq = locals.field_tagName;
              ArrayList localArrayList = this.KSW;
              paramString = com.tencent.mm.plugin.label.a.a.eLe().eLb();
              if (paramString == null)
              {
                paramString = paramq;
                label297:
                localArrayList.add(paramString);
                this.KSV.add(paramq);
                this.KSX.add(Long.valueOf(locals.field_tagId));
              }
            }
            for (;;)
            {
              ((Cursor)localObject).moveToNext();
              break;
              if (!paramString.contains(paramq))
              {
                paramString = paramq;
                break label297;
              }
              paramString = String.format(getString(i.j.sns_label_from_tag_suffix), new Object[] { paramq });
              break label297;
              Log.e("MicroMsg.SnsLabelUI", "dz:snstaginfo memberlist is null.");
            }
          }
          ((Cursor)localObject).close();
          if (this.KSV.size() != 0) {
            break label508;
          }
          paramInt1 = 0;
          if (paramInt1 != 0) {}
        }
        else if (this.KSQ)
        {
          this.Lox.KTi = this.KSR;
          this.KSD.ayy(this.KSR);
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().i(335873, Boolean.FALSE);
        }
        ((Cursor)localObject).close();
        if (this.KSO)
        {
          this.KSP = true;
          com.tencent.mm.plugin.label.a.a.eLe().fH(this.KSW);
        }
      }
      for (;;)
      {
        this.KSQ = false;
        AppMethodBeat.o(100160);
        return;
        label508:
        paramInt1 = 1;
        break;
        this.KSP = false;
        continue;
        fWB();
        Log.i("MicroMsg.SnsLabelUI", "dz: error at get sns tag list!");
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        hM(this.KSY);
        AppMethodBeat.o(100160);
        return;
      }
      fWB();
      Log.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
      AppMethodBeat.o(100160);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.KSV.iterator();
        paramq = this.KSX.iterator();
        while (paramString.hasNext())
        {
          long l = ((Long)paramq.next()).longValue();
          localObject = (String)paramString.next();
          if (l != 0L)
          {
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(new y(l, (String)localObject), 0);
          }
        }
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().i(335874, Integer.valueOf(0));
        this.KSF = ((ArrayList)com.tencent.mm.plugin.label.a.a.eLe().eKZ());
        paramString = com.tencent.mm.plugin.report.service.h.IzE;
        paramInt2 = this.KSU;
        if (this.KSW == null) {}
        for (paramInt1 = 0;; paramInt1 = this.KSW.size())
        {
          paramString.a(11455, new Object[] { "", "", Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
          this.KSD.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100132);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTi = JsapiSnsLabelUI.l(JsapiSnsLabelUI.this);
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
                    a.bcc((String)((Iterator)localObject).next());
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
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).bf(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
              JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).notifyDataSetChanged();
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).ayy(JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).KTi);
              if ((JsapiSnsLabelUI.r(JsapiSnsLabelUI.this) != null) && (JsapiSnsLabelUI.r(JsapiSnsLabelUI.this).isShowing())) {
                JsapiSnsLabelUI.r(JsapiSnsLabelUI.this).dismiss();
              }
              AppMethodBeat.o(100132);
            }
          }, 600L);
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().i(335873, Boolean.FALSE);
          AppMethodBeat.o(100160);
          return;
        }
      }
      fWB();
      Log.i("MicroMsg.SnsLabelUI", "dz: error at modify label list!");
      AppMethodBeat.o(100160);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Log.i("MicroMsg.SnsLabelUI", "dz: error at delete tag list!");
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI
 * JD-Core Version:    0.7.0.1
 */