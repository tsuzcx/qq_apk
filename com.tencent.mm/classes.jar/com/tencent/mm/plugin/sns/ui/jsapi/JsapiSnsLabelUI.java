package com.tencent.mm.plugin.sns.ui.jsapi;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.y;
import com.tencent.mm.plugin.sns.storage.ac;
import com.tencent.mm.plugin.sns.storage.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import com.tencent.mm.ui.y.b;
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
  implements com.tencent.mm.am.h
{
  public static int[] RsD = { b.j.sns_label_public, b.j.sns_label_private, b.j.sns_label_include, b.j.sns_label_exclude };
  private ArrayList<String> JXW;
  private com.tencent.mm.ui.base.w PZK;
  public int RPA;
  private List<String> RPB;
  a RPC;
  List<String> RPD;
  public int RPx;
  public int RPy;
  public int RPz;
  private AnimatedExpandableListView RsC;
  private String RsE;
  private String RsF;
  private int RsJ;
  private boolean RsL;
  private boolean RsM;
  private boolean RsN;
  private boolean RsO;
  private int RsP;
  private String RsQ;
  private int RsS;
  private ArrayList<String> RsT;
  private ArrayList<String> RsU;
  private ArrayList<Long> RsV;
  private ArrayList<String[]> RsW;
  
  public JsapiSnsLabelUI()
  {
    AppMethodBeat.i(100142);
    this.RPx = 0;
    this.RPy = 1;
    this.RPz = 2;
    this.RPA = 3;
    this.RPB = Arrays.asList("public,private,visible,invisible".split(","));
    this.RsJ = this.RPx;
    this.RsM = false;
    this.RsN = false;
    this.RsO = false;
    this.RPD = new ArrayList();
    AppMethodBeat.o(100142);
  }
  
  private String amv(int paramInt)
  {
    AppMethodBeat.i(100153);
    if ((paramInt >= this.RPD.size()) || (paramInt < 0))
    {
      AppMethodBeat.o(100153);
      return "";
    }
    String str = (String)this.RPD.get(paramInt);
    AppMethodBeat.o(100153);
    return str;
  }
  
  private void bC(Intent paramIntent)
  {
    AppMethodBeat.i(100152);
    hoU();
    paramIntent.putExtra("Klabel_name_list", bba(this.RsE));
    paramIntent.putExtra("Kother_user_name_list", baZ(this.RsF));
    paramIntent.putExtra("k_select_group", amv(this.RPC.Rtg));
    AppMethodBeat.o(100152);
  }
  
  private static String baZ(String paramString)
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
          localJSONObject.put("displayName", getDisplayName(str));
          localJSONObject.put("avatar", bbb(str));
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
  
  private static String bba(String paramString)
  {
    AppMethodBeat.i(100155);
    Object localObject1 = Util.stringToList(paramString, ",");
    paramString = new JSONObject();
    com.tencent.mm.plugin.label.a.b localb = com.tencent.mm.plugin.label.a.a.fTb();
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
          localObject2 = localb.aJK(localb.aJH((String)localObject2));
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              String str = (String)((Iterator)localObject2).next();
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("username", str);
              localJSONObject.put("displayName", getDisplayName(str));
              localJSONObject.put("avatar", bbb(str));
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
  
  private static String bbb(String paramString)
  {
    AppMethodBeat.i(100157);
    paramString = q.bFE().LS(paramString);
    if (paramString != null)
    {
      paramString = paramString.bFx();
      AppMethodBeat.o(100157);
      return paramString;
    }
    AppMethodBeat.o(100157);
    return "";
  }
  
  private static String getDisplayName(String paramString)
  {
    AppMethodBeat.i(100156);
    paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramString);
    AppMethodBeat.o(100156);
    return paramString;
  }
  
  private void goBack()
  {
    AppMethodBeat.i(100149);
    if (hoN())
    {
      com.tencent.mm.ui.base.k.a(this, true, getString(b.j.sns_label_goback_tip), "", getString(b.j.sns_label_goback_save), getString(b.j.sns_label_goback_notsave), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    hoO();
    AppMethodBeat.o(100149);
  }
  
  private boolean hoN()
  {
    AppMethodBeat.i(100148);
    boolean bool2 = false;
    int i = this.RPC.Rtg;
    boolean bool1;
    if (this.RPC.Rtg != this.RsJ) {
      if (((i == this.RPz) && ((this.RPC.Rti.size() != 0) || (this.RPC.Rtk.size() != 0))) || ((i == this.RPA) && ((this.RPC.Rtj.size() != 0) || (this.RPC.Rtl.size() != 0)))) {
        bool1 = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(100148);
      return bool1;
      if (i != this.RPy)
      {
        bool1 = bool2;
        if (i != this.RPx) {}
      }
      else
      {
        bool1 = true;
        continue;
        if ((i != this.RPz) || (this.RPC.Rti.size() == 0) || ((Util.listToString(this.RPC.Rti, ",").equals(this.RsE)) && (Util.listToString(this.RPC.Rtk, ",").equals(this.RsF))))
        {
          bool1 = bool2;
          if (i != this.RPA) {
            continue;
          }
          bool1 = bool2;
          if (this.RPC.Rtj.size() == 0) {
            continue;
          }
          if (Util.listToString(this.RPC.Rtj, ",").equals(this.RsE))
          {
            bool1 = bool2;
            if (Util.listToString(this.RPC.Rtl, ",").equals(this.RsF)) {
              continue;
            }
          }
        }
        bool1 = true;
      }
    }
  }
  
  private void hoO()
  {
    AppMethodBeat.i(100150);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ktag_range_index", this.RsJ);
    bC(localIntent);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(100150);
  }
  
  private static int hoQ()
  {
    AppMethodBeat.i(100161);
    com.tencent.mm.kernel.h.baF();
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().d(335874, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(100161);
    return i;
  }
  
  private static void hoR()
  {
    AppMethodBeat.i(100162);
    com.tencent.mm.kernel.h.baF();
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().d(335874, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().B(335874, Integer.valueOf(i + 1));
    AppMethodBeat.o(100162);
  }
  
  private void hoS()
  {
    AppMethodBeat.i(100163);
    com.tencent.mm.plugin.report.service.h.OAn.b(11455, new Object[] { "", "", Integer.valueOf(this.RsS), Integer.valueOf(0) });
    hoR();
    this.RsU = null;
    this.RsO = false;
    this.RsN = false;
    if ((this.PZK != null) && (this.PZK.isShowing())) {
      this.PZK.dismiss();
    }
    if (this.RsM)
    {
      this.RsM = false;
      AppMethodBeat.o(100163);
      return;
    }
    int i = b.j.sns_label_transform_failed_once;
    if (hoQ() > 1) {
      i = b.j.sns_label_transform_failed_again;
    }
    com.tencent.mm.ui.base.k.a(this, i, b.j.app_ok, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(100163);
  }
  
  private void hoT()
  {
    AppMethodBeat.i(100165);
    if ((this.JXW == null) || (this.JXW.isEmpty()))
    {
      if (this.RPC.Rti != null) {
        this.RPC.Rti.clear();
      }
      if (this.RPC.Rtj != null) {
        this.RPC.Rtj.clear();
      }
      AppMethodBeat.o(100165);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    String str;
    if ((this.RPD.size() > 0) && ("visible".equals(amv(this.RsJ))) && (this.RPC.Rti != null))
    {
      localIterator = this.RPC.Rti.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.JXW.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.RPC.Rti.removeAll(localArrayList);
      AppMethodBeat.o(100165);
      return;
    }
    if ((this.RPD.size() > 0) && ("invisible".equals(amv(this.RsJ))))
    {
      localIterator = this.RPC.Rtj.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.JXW.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.RPC.Rtj.removeAll(localArrayList);
    }
    AppMethodBeat.o(100165);
  }
  
  private void hoU()
  {
    AppMethodBeat.i(100166);
    if ((this.JXW == null) || (this.JXW.isEmpty()))
    {
      this.RsE = "";
      AppMethodBeat.o(100166);
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    if (this.RsE != null)
    {
      ArrayList localArrayList2 = Util.stringsToList(this.RsE.split(","));
      if (localArrayList2 != null)
      {
        Iterator localIterator = localArrayList2.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!this.JXW.contains(str)) {
            localArrayList1.add(str);
          }
        }
        localArrayList2.removeAll(localArrayList1);
        this.RsE = Util.listToString(localArrayList2, ",");
      }
    }
    AppMethodBeat.o(100166);
  }
  
  private void kN(List<String[]> paramList)
  {
    AppMethodBeat.i(100164);
    if ((this.RsU == null) || (this.RsU.size() == 0))
    {
      AppMethodBeat.o(100164);
      return;
    }
    Iterator localIterator = this.RsU.iterator();
    paramList = paramList.iterator();
    ArrayList localArrayList1 = new ArrayList(this.RsU.size());
    ArrayList localArrayList2 = new ArrayList(this.RsU.size());
    while (localIterator.hasNext())
    {
      localArrayList1.add(com.tencent.mm.plugin.label.a.a.fTb().aJH((String)localIterator.next()));
      localArrayList2.add(Util.listToString(Arrays.asList((String[])paramList.next()), ","));
      this.RsN = true;
    }
    com.tencent.mm.plugin.label.a.a.fTb().G(localArrayList1, localArrayList2);
    AppMethodBeat.o(100164);
  }
  
  private static int[] kT(List<Integer> paramList)
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
  
  public int getLayoutId()
  {
    return b.g.sns_label;
  }
  
  final void hoP()
  {
    AppMethodBeat.i(100151);
    Intent localIntent = new Intent();
    if (this.RPC.Rtg == this.RPz)
    {
      this.RsE = Util.listToString(this.RPC.Rti, ",");
      this.RsF = Util.listToString(this.RPC.Rtk, ",");
      bC(localIntent);
    }
    for (;;)
    {
      localIntent.putExtra("k_select_group", amv(this.RPC.Rtg));
      localIntent.putExtra("k_select_index", this.RPC.Rtg);
      localIntent.putExtra("Ktag_range_index", this.RPC.Rtg);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(100151);
      return;
      if (this.RPC.Rtg == this.RPA)
      {
        this.RsE = Util.listToString(this.RPC.Rtj, ",");
        this.RsF = Util.listToString(this.RPC.Rtl, ",");
        bC(localIntent);
      }
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(100146);
    boolean bool = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
    this.RsC = ((AnimatedExpandableListView)findViewById(b.f.sns_label_exlist));
    this.JXW = ((ArrayList)com.tencent.mm.plugin.label.a.a.fTb().fSW());
    this.RPC.Rth = bool;
    this.RPC.bF(this.JXW);
    hoT();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    localLayoutParams.height = getResources().getDimensionPixelSize(b.d.LargerPadding);
    View localView = new View(this);
    localView.setLayoutParams(localLayoutParams);
    this.RsC.addHeaderView(localView);
    this.RsC.setAdapter(this.RPC);
    this.RsC.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
    {
      public final boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100134);
        int i = JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rtg;
        Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt) });
        if ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, paramAnonymousInt).equals("visible")) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, paramAnonymousInt).equals("invisible")))
        {
          if ((JsapiSnsLabelUI.b(JsapiSnsLabelUI.this) != null) && (JsapiSnsLabelUI.b(JsapiSnsLabelUI.this).size() != 0) && (JsapiSnsLabelUI.hrh() == 0))
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
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, com.tencent.mm.ui.base.k.a(JsapiSnsLabelUI.this, JsapiSnsLabelUI.this.getString(b.j.sns_label_is_transforming), false, null));
            Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
            AppMethodBeat.o(100134);
            return true;
          }
          if ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rtf == null) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rtf.size() == 0))
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
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).aFj(paramAnonymousInt);
            }
            for (;;)
            {
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rtg = paramAnonymousInt;
              AppMethodBeat.o(100134);
              return true;
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).aFi(paramAnonymousInt);
            }
          }
          if (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("visible"))
          {
            JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).collapseGroup(i);
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rti.clear();
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rtk.clear();
          }
          for (;;)
          {
            JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100133);
                JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).aFi(paramAnonymousInt);
                AppMethodBeat.o(100133);
              }
            });
            break;
            if (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("invisible"))
            {
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).collapseGroup(i);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rtj.clear();
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rtl.clear();
            }
          }
        }
        if ((i >= 0) && ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("visible")) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("invisible")))) {
          JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).aFj(i);
        }
        JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rtg = paramAnonymousInt;
        AppMethodBeat.o(100134);
        return false;
      }
    });
    this.RsC.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
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
          a.baH(paramAnonymousExpandableListView);
          if (paramAnonymousInt1 == JsapiSnsLabelUI.this.RPz) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, 1, JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rti, paramAnonymousExpandableListView, paramAnonymousView);
          } else if (paramAnonymousInt1 == JsapiSnsLabelUI.this.RPA) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, 2, JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rtj, paramAnonymousExpandableListView, paramAnonymousView);
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
    addTextOptionMenu(0, getString(b.j.sns_label_finish), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(100137);
        paramAnonymousMenuItem = JsapiSnsLabelUI.this;
        String str1 = Util.listToString(paramAnonymousMenuItem.RPC.Rti, ",");
        String str2 = Util.listToString(paramAnonymousMenuItem.RPC.Rtk, ",");
        String str3 = Util.listToString(paramAnonymousMenuItem.RPC.Rtj, ",");
        String str4 = Util.listToString(paramAnonymousMenuItem.RPC.Rtl, ",");
        if (((paramAnonymousMenuItem.RPC.Rtg == paramAnonymousMenuItem.RPz) && (paramAnonymousMenuItem.RPC.Rti.size() == 0) && (paramAnonymousMenuItem.RPC.Rtk.size() == 0)) || ((paramAnonymousMenuItem.RPC.Rtg == paramAnonymousMenuItem.RPA) && (paramAnonymousMenuItem.RPC.Rtj.size() == 0) && (paramAnonymousMenuItem.RPC.Rtl.size() == 0))) {
          com.tencent.mm.ui.base.k.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(b.j.sns_label_need_select_one_least), "", paramAnonymousMenuItem.getString(b.j.sns_label_transform_ok), null);
        }
        for (;;)
        {
          AppMethodBeat.o(100137);
          return true;
          if (((paramAnonymousMenuItem.RPC.Rtg == paramAnonymousMenuItem.RPz) && (Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2))) || ((paramAnonymousMenuItem.RPC.Rtg == paramAnonymousMenuItem.RPA) && (Util.isNullOrNil(str3)) && (Util.isNullOrNil(str4)))) {
            com.tencent.mm.ui.base.k.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(b.j.sns_label_need_select_one_least), "", paramAnonymousMenuItem.getString(b.j.sns_label_transform_ok), null);
          } else {
            paramAnonymousMenuItem.hoP();
          }
        }
      }
    }, null, y.b.adEJ);
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
        com.tencent.mm.br.c.b(getContext(), "label", ".ui.ContactLabelEditUI", paramIntent, 4002);
        AppMethodBeat.o(100147);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      this.RsF = new String(paramIntent);
      Log.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.RsP == this.RPz)
      {
        this.RPC.Rtk.clear();
        if (!Util.isNullOrNil(paramIntent))
        {
          paramIntent = Util.stringsToList(paramIntent.split(","));
          this.RPC.Rtk.addAll(paramIntent);
          this.RPC.Rtg = this.RsP;
        }
      }
      for (;;)
      {
        this.RPC.notifyDataSetChanged();
        this.RsC.expandGroup(this.RsP);
        AppMethodBeat.o(100147);
        return;
        if (this.RsP == this.RPA)
        {
          this.RPC.Rtl.clear();
          if (!Util.isNullOrNil(paramIntent))
          {
            paramIntent = Util.stringsToList(paramIntent.split(","));
            this.RPC.Rtl.addAll(paramIntent);
            this.RPC.Rtg = this.RsP;
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
        com.tencent.mm.br.c.b(this, "label", ".ui.ContactLabelEditUI", (Intent)localObject, 4002);
      }
      AppMethodBeat.o(100147);
      return;
    }
    if ((paramInt2 == 0) && (paramInt1 == 4002) && (paramIntent != null))
    {
      localObject = paramIntent.getStringExtra("k_sns_label_add_label");
      this.RsQ = paramIntent.getStringExtra("k_sns_label_add_label");
      this.RsC.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100139);
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, (ArrayList)com.tencent.mm.plugin.label.a.a.fTb().fSW());
          if (JsapiSnsLabelUI.j(JsapiSnsLabelUI.this) == null) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, new ArrayList());
          }
          if (!Util.isNullOrNil(this.Rta)) {
            if (!JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).contains(this.Rta)) {
              JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).add(this.Rta);
            }
          }
          for (int i = JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).indexOf(this.Rta);; i = -1)
          {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).bF(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
            JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rtg = JsapiSnsLabelUI.l(JsapiSnsLabelUI.this);
            if ((!Util.isNullOrNil(this.Rta)) && (i != -1))
            {
              if (JsapiSnsLabelUI.l(JsapiSnsLabelUI.this) != JsapiSnsLabelUI.this.RPz) {
                break label252;
              }
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rti.add(this.Rta);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rtk.clear();
            }
            for (;;)
            {
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).notifyDataSetChanged();
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).expandGroup(JsapiSnsLabelUI.l(JsapiSnsLabelUI.this));
              JsapiSnsLabelUI.m(JsapiSnsLabelUI.this);
              AppMethodBeat.o(100139);
              return;
              label252:
              if (JsapiSnsLabelUI.l(JsapiSnsLabelUI.this) == JsapiSnsLabelUI.this.RPA)
              {
                JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rtj.add(this.Rta);
                JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rtl.clear();
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
    setMMTitle(b.j.sns_tag_title);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(292, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(635, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(638, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(290, this);
    this.RPC = new a(this);
    this.RPC.RPJ = false;
    this.RPC.RPI = new a.b()
    {
      public final void a(a.c paramAnonymousc)
      {
        AppMethodBeat.i(100130);
        int i = paramAnonymousc.Rtv;
        int j = paramAnonymousc.Rtw;
        JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i, j);
        AppMethodBeat.o(100130);
      }
    };
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      this.RsJ = this.RPx;
      this.RPC.style = 0;
      this.RsE = null;
      this.RsF = null;
      this.RPC.Rtg = this.RsJ;
      if (this.RPC.style == 1) {
        findViewById(b.f.sns_label_layout).setBackgroundResource(b.c.black);
      }
      if (this.RsJ != this.RPz) {
        break label837;
      }
      if (!TextUtils.isEmpty(this.RsE)) {
        this.RPC.Rti = Util.stringsToList(this.RsE.split(","));
      }
      if (!TextUtils.isEmpty(this.RsF)) {
        this.RPC.Rtk = Util.stringsToList(this.RsF.split(","));
      }
    }
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList;
    for (;;)
    {
      com.tencent.mm.kernel.h.baF();
      this.RsL = ((Boolean)com.tencent.mm.kernel.h.baE().ban().d(335873, Boolean.TRUE)).booleanValue();
      if (this.RsL)
      {
        this.RsN = true;
        this.RsO = true;
        if (hoQ() > 0) {
          this.RsM = true;
        }
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.plugin.sns.model.w(1), 0);
      }
      initView();
      localObject1 = getIntent();
      if (localObject1 == null) {
        break label1300;
      }
      paramBundle = ((Intent)localObject1).getStringExtra("k_select_group");
      boolean bool1 = ((Intent)localObject1).getBooleanExtra("k_show_public", true);
      boolean bool2 = ((Intent)localObject1).getBooleanExtra("k_show_private", true);
      boolean bool3 = ((Intent)localObject1).getBooleanExtra("k_show_include", true);
      boolean bool4 = ((Intent)localObject1).getBooleanExtra("k_show_exclude", true);
      localObject2 = new int[4];
      localObject2[0] = b.j.sns_label_public;
      localObject2[1] = b.j.sns_label_private;
      localObject2[2] = b.j.sns_label_include;
      localObject2[3] = b.j.sns_label_exclude;
      int i = b.j.sns_label_public_hint;
      i = b.j.sns_label_private_hint;
      i = b.j.sns_label_include_hint;
      i = b.j.sns_label_exclude_hint;
      this.RPD.clear();
      localObject1 = new ArrayList();
      localArrayList = new ArrayList();
      if (bool1)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[0]));
        localArrayList.add(Integer.valueOf(localObject2[0]));
        this.RPD.add((String)this.RPB.get(0));
      }
      if (bool2)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[1]));
        localArrayList.add(Integer.valueOf(localObject2[1]));
        this.RPD.add((String)this.RPB.get(1));
      }
      if (bool3)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[2]));
        localArrayList.add(Integer.valueOf(localObject2[2]));
        this.RPD.add((String)this.RPB.get(2));
      }
      if (bool4)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[3]));
        localArrayList.add(Integer.valueOf(localObject2[3]));
        this.RPD.add((String)this.RPB.get(3));
      }
      if (this.RPD.size() != 0) {
        break label909;
      }
      finish();
      AppMethodBeat.o(100144);
      return;
      if (paramBundle.hasExtra("k_title")) {
        setMMTitle(paramBundle.getStringExtra("k_title"));
      }
      this.RsJ = paramBundle.getIntExtra("KLabel_range_index", this.RPx);
      this.RPC.style = paramBundle.getIntExtra("k_sns_label_ui_style", 0);
      this.RsE = paramBundle.getStringExtra("Klabel_name_list");
      this.RsF = paramBundle.getStringExtra("Kother_user_name_list");
      if (TextUtils.isEmpty(paramBundle.getStringExtra("k_sns_label_ui_title"))) {
        break;
      }
      setMMTitle(paramBundle.getStringExtra("k_sns_label_ui_title"));
      break;
      label837:
      if (this.RsJ == this.RPA)
      {
        if (!TextUtils.isEmpty(this.RsE)) {
          this.RPC.Rtj = Util.stringsToList(this.RsE.split(","));
        }
        if (!TextUtils.isEmpty(this.RsF)) {
          this.RPC.Rtl = Util.stringsToList(this.RsF.split(","));
        }
      }
    }
    label909:
    this.RPx = this.RPD.indexOf("public");
    this.RPy = this.RPD.indexOf("private");
    this.RPz = this.RPD.indexOf("visible");
    this.RPA = this.RPD.indexOf("invisible");
    if (this.RPC != null)
    {
      localObject2 = this.RPC;
      List localList = this.RPD;
      ((a)localObject2).RPH = localList;
      ((a)localObject2).RPx = localList.indexOf("public");
      ((a)localObject2).RPy = localList.indexOf("private");
      ((a)localObject2).RPz = localList.indexOf("visible");
      ((a)localObject2).RPA = localList.indexOf("invisible");
      this.RPC.RPG = ((List)localObject1).size();
      this.RPC.RsD = kT((List)localObject1);
      this.RPC.Rte = kT(localArrayList);
      if (!TextUtils.isEmpty(paramBundle))
      {
        this.RPC.Rtg = this.RPD.indexOf(paramBundle);
        if (paramBundle.equals("visible"))
        {
          if (!TextUtils.isEmpty(this.RsE)) {
            this.RPC.Rti = Util.stringsToList(this.RsE.split(","));
          }
          if (!TextUtils.isEmpty(this.RsF)) {
            this.RPC.Rtk = Util.stringsToList(this.RsF.split(","));
          }
          this.RsC.expandGroup(this.RPD.indexOf(paramBundle));
          AppMethodBeat.o(100144);
          return;
        }
        if (paramBundle.equals("invisible"))
        {
          if (!TextUtils.isEmpty(this.RsE)) {
            this.RPC.Rtj = Util.stringsToList(this.RsE.split(","));
          }
          if (!TextUtils.isEmpty(this.RsF)) {
            this.RPC.Rtl = Util.stringsToList(this.RsF.split(","));
          }
          this.RsC.expandGroup(this.RPD.indexOf(paramBundle));
        }
      }
    }
    label1300:
    AppMethodBeat.o(100144);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(100158);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(292, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(635, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(638, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(290, this);
    super.onDestroy();
    AppMethodBeat.o(100158);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(100159);
    if ((this.RPC != null) && (this.RsQ == null) && (this.RsC != null)) {
      this.RsC.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100131);
          com.tencent.mm.plugin.label.a.a.fTb().bja();
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, (ArrayList)com.tencent.mm.plugin.label.a.a.fTb().fSW());
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).bF(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
          JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
          if (((JsapiSnsLabelUI.j(JsapiSnsLabelUI.this) == null) || (JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).size() == 0)) && ((JsapiSnsLabelUI.p(JsapiSnsLabelUI.this) == null) || (JsapiSnsLabelUI.p(JsapiSnsLabelUI.this).length() == 0)) && (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rtg != JsapiSnsLabelUI.this.RPx) && (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rtg != JsapiSnsLabelUI.this.RPy)) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rtg = JsapiSnsLabelUI.this.RPx;
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(100160);
    Log.i("MicroMsg.SnsLabelUI", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!this.RsN)
    {
      AppMethodBeat.o(100160);
      return;
    }
    switch (paramp.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(100160);
      return;
      Object localObject;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = al.hgI().Fv();
        this.RsS = ((Cursor)localObject).getCount();
        if (this.RsS > 0)
        {
          ((Cursor)localObject).moveToFirst();
          ac localac = new ac();
          paramInt1 = ((Cursor)localObject).getCount();
          this.RsU = new ArrayList(paramInt1);
          this.RsT = new ArrayList(paramInt1);
          this.RsW = new ArrayList(paramInt1);
          this.RsV = new ArrayList(paramInt1);
          if (!((Cursor)localObject).isAfterLast())
          {
            localac.convertFrom((Cursor)localObject);
            if ((localac.field_memberList != null) && (localac.field_memberList.length() != 0))
            {
              this.RsW.add(localac.field_memberList.split(","));
              paramp = localac.field_tagName;
              ArrayList localArrayList = this.RsU;
              paramString = com.tencent.mm.plugin.label.a.a.fTb().fSY();
              if (paramString == null)
              {
                paramString = paramp;
                label297:
                localArrayList.add(paramString);
                this.RsT.add(paramp);
                this.RsV.add(Long.valueOf(localac.field_tagId));
              }
            }
            for (;;)
            {
              ((Cursor)localObject).moveToNext();
              break;
              if (!paramString.contains(paramp))
              {
                paramString = paramp;
                break label297;
              }
              paramString = String.format(getString(b.j.sns_label_from_tag_suffix), new Object[] { paramp });
              break label297;
              Log.e("MicroMsg.SnsLabelUI", "dz:snstaginfo memberlist is null.");
            }
          }
          ((Cursor)localObject).close();
          if (this.RsT.size() != 0) {
            break label508;
          }
          paramInt1 = 0;
          if (paramInt1 != 0) {}
        }
        else if (this.RsO)
        {
          this.RPC.Rtg = this.RsP;
          this.RsC.aFi(this.RsP);
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().B(335873, Boolean.FALSE);
        }
        ((Cursor)localObject).close();
        if (this.RsM)
        {
          this.RsN = true;
          com.tencent.mm.plugin.label.a.a.fTb().iE(this.RsU);
        }
      }
      for (;;)
      {
        this.RsO = false;
        AppMethodBeat.o(100160);
        return;
        label508:
        paramInt1 = 1;
        break;
        this.RsN = false;
        continue;
        hoS();
        Log.i("MicroMsg.SnsLabelUI", "dz: error at get sns tag list!");
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        kN(this.RsW);
        AppMethodBeat.o(100160);
        return;
      }
      hoS();
      Log.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
      AppMethodBeat.o(100160);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.RsT.iterator();
        paramp = this.RsV.iterator();
        while (paramString.hasNext())
        {
          long l = ((Long)paramp.next()).longValue();
          localObject = (String)paramString.next();
          if (l != 0L)
          {
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(new y(l, (String)localObject), 0);
          }
        }
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().B(335874, Integer.valueOf(0));
        this.JXW = ((ArrayList)com.tencent.mm.plugin.label.a.a.fTb().fSW());
        paramString = com.tencent.mm.plugin.report.service.h.OAn;
        paramInt2 = this.RsS;
        if (this.RsU == null) {}
        for (paramInt1 = 0;; paramInt1 = this.RsU.size())
        {
          paramString.b(11455, new Object[] { "", "", Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
          this.RsC.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100132);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rtg = JsapiSnsLabelUI.l(JsapiSnsLabelUI.this);
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
                    a.baH((String)((Iterator)localObject).next());
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
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).bF(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
              JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).notifyDataSetChanged();
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).aFi(JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).Rtg);
              if ((JsapiSnsLabelUI.r(JsapiSnsLabelUI.this) != null) && (JsapiSnsLabelUI.r(JsapiSnsLabelUI.this).isShowing())) {
                JsapiSnsLabelUI.r(JsapiSnsLabelUI.this).dismiss();
              }
              AppMethodBeat.o(100132);
            }
          }, 600L);
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().B(335873, Boolean.FALSE);
          AppMethodBeat.o(100160);
          return;
        }
      }
      hoS();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI
 * JD-Core Version:    0.7.0.1
 */