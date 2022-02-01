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
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.model.y;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.t.b;
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
  implements com.tencent.mm.ak.i
{
  public static int[] EEO = { 2131766098, 2131766096, 2131766092, 2131766083 };
  private AnimatedExpandableListView EEN;
  private ArrayList<String> EEP;
  private String EEQ;
  private String EER;
  private int EEU;
  private boolean EEW;
  private boolean EEX;
  private boolean EEY;
  private boolean EEZ;
  private int EFa;
  private com.tencent.mm.ui.base.q EFb;
  private String EFc;
  private int EFd;
  private ArrayList<String> EFe;
  private ArrayList<String> EFf;
  private ArrayList<Long> EFg;
  private ArrayList<String[]> EFh;
  public int EZU;
  public int EZV;
  public int EZW;
  public int EZX;
  private List<String> EZY;
  a EZZ;
  List<String> Faa;
  
  public JsapiSnsLabelUI()
  {
    AppMethodBeat.i(100142);
    this.EZU = 0;
    this.EZV = 1;
    this.EZW = 2;
    this.EZX = 3;
    this.EZY = Arrays.asList("public,private,visible,invisible".split(","));
    this.EEU = this.EZU;
    this.EEX = false;
    this.EEY = false;
    this.EEZ = false;
    this.Faa = new ArrayList();
    AppMethodBeat.o(100142);
  }
  
  private static String aRo(String paramString)
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
          localJSONObject.put("avatar", aRq(str));
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
  
  private static String aRp(String paramString)
  {
    AppMethodBeat.i(100155);
    Object localObject1 = Util.stringToList(paramString, ",");
    paramString = new JSONObject();
    com.tencent.mm.plugin.label.a.b localb = com.tencent.mm.plugin.label.a.a.ecg();
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
          localObject2 = localb.aCK(localb.aCH((String)localObject2));
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              String str = (String)((Iterator)localObject2).next();
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("username", str);
              localJSONObject.put("displayName", getDisplayName(str));
              localJSONObject.put("avatar", aRq(str));
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
  
  private static String aRq(String paramString)
  {
    AppMethodBeat.i(100157);
    paramString = p.aYB().Mx(paramString);
    if (paramString != null)
    {
      paramString = paramString.aYu();
      AppMethodBeat.o(100157);
      return paramString;
    }
    AppMethodBeat.o(100157);
    return "";
  }
  
  private String aae(int paramInt)
  {
    AppMethodBeat.i(100153);
    if ((paramInt >= this.Faa.size()) || (paramInt < 0))
    {
      AppMethodBeat.o(100153);
      return "";
    }
    String str = (String)this.Faa.get(paramInt);
    AppMethodBeat.o(100153);
    return str;
  }
  
  private void bc(Intent paramIntent)
  {
    AppMethodBeat.i(100152);
    fir();
    paramIntent.putExtra("Klabel_name_list", aRp(this.EEQ));
    paramIntent.putExtra("Kother_user_name_list", aRo(this.EER));
    paramIntent.putExtra("k_select_group", aae(this.EZZ.EFr));
    AppMethodBeat.o(100152);
  }
  
  private boolean fik()
  {
    AppMethodBeat.i(100148);
    boolean bool2 = false;
    int i = this.EZZ.EFr;
    boolean bool1;
    if (this.EZZ.EFr != this.EEU) {
      if (((i == this.EZW) && ((this.EZZ.EFt.size() != 0) || (this.EZZ.EFv.size() != 0))) || ((i == this.EZX) && ((this.EZZ.EFu.size() != 0) || (this.EZZ.EFw.size() != 0)))) {
        bool1 = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(100148);
      return bool1;
      if (i != this.EZV)
      {
        bool1 = bool2;
        if (i != this.EZU) {}
      }
      else
      {
        bool1 = true;
        continue;
        if ((i != this.EZW) || (this.EZZ.EFt.size() == 0) || ((Util.listToString(this.EZZ.EFt, ",").equals(this.EEQ)) && (Util.listToString(this.EZZ.EFv, ",").equals(this.EER))))
        {
          bool1 = bool2;
          if (i != this.EZX) {
            continue;
          }
          bool1 = bool2;
          if (this.EZZ.EFu.size() == 0) {
            continue;
          }
          if (Util.listToString(this.EZZ.EFu, ",").equals(this.EEQ))
          {
            bool1 = bool2;
            if (Util.listToString(this.EZZ.EFw, ",").equals(this.EER)) {
              continue;
            }
          }
        }
        bool1 = true;
      }
    }
  }
  
  private void fil()
  {
    AppMethodBeat.i(100150);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ktag_range_index", this.EEU);
    bc(localIntent);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(100150);
  }
  
  private static int fin()
  {
    AppMethodBeat.i(100161);
    g.aAi();
    int i = ((Integer)g.aAh().azQ().get(335874, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(100161);
    return i;
  }
  
  private static void fio()
  {
    AppMethodBeat.i(100162);
    g.aAi();
    int i = ((Integer)g.aAh().azQ().get(335874, Integer.valueOf(0))).intValue();
    g.aAi();
    g.aAh().azQ().set(335874, Integer.valueOf(i + 1));
    AppMethodBeat.o(100162);
  }
  
  private void fip()
  {
    AppMethodBeat.i(100163);
    com.tencent.mm.plugin.report.service.h.CyF.a(11455, new Object[] { "", "", Integer.valueOf(this.EFd), Integer.valueOf(0) });
    fio();
    this.EFf = null;
    this.EEZ = false;
    this.EEY = false;
    if ((this.EFb != null) && (this.EFb.isShowing())) {
      this.EFb.dismiss();
    }
    if (this.EEX)
    {
      this.EEX = false;
      AppMethodBeat.o(100163);
      return;
    }
    int i = 2131766106;
    if (fin() > 1) {
      i = 2131766105;
    }
    com.tencent.mm.ui.base.h.a(this, i, 2131755921, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(100163);
  }
  
  private void fiq()
  {
    AppMethodBeat.i(100165);
    if ((this.EEP == null) || (this.EEP.isEmpty()))
    {
      if (this.EZZ.EFt != null) {
        this.EZZ.EFt.clear();
      }
      if (this.EZZ.EFu != null) {
        this.EZZ.EFu.clear();
      }
      AppMethodBeat.o(100165);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    String str;
    if ((this.Faa.size() > 0) && ("visible".equals(aae(this.EEU))) && (this.EZZ.EFt != null))
    {
      localIterator = this.EZZ.EFt.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.EEP.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.EZZ.EFt.removeAll(localArrayList);
      AppMethodBeat.o(100165);
      return;
    }
    if ((this.Faa.size() > 0) && ("invisible".equals(aae(this.EEU))))
    {
      localIterator = this.EZZ.EFu.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.EEP.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.EZZ.EFu.removeAll(localArrayList);
    }
    AppMethodBeat.o(100165);
  }
  
  private void fir()
  {
    AppMethodBeat.i(100166);
    if ((this.EEP == null) || (this.EEP.isEmpty()))
    {
      this.EEQ = "";
      AppMethodBeat.o(100166);
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    if (this.EEQ != null)
    {
      ArrayList localArrayList2 = Util.stringsToList(this.EEQ.split(","));
      if (localArrayList2 != null)
      {
        Iterator localIterator = localArrayList2.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!this.EEP.contains(str)) {
            localArrayList1.add(str);
          }
        }
        localArrayList2.removeAll(localArrayList1);
        this.EEQ = Util.listToString(localArrayList2, ",");
      }
    }
    AppMethodBeat.o(100166);
  }
  
  private static String getDisplayName(String paramString)
  {
    AppMethodBeat.i(100156);
    paramString = ((com.tencent.mm.plugin.messenger.a.b)g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramString);
    AppMethodBeat.o(100156);
    return paramString;
  }
  
  private void goBack()
  {
    AppMethodBeat.i(100149);
    if (fik())
    {
      com.tencent.mm.ui.base.h.a(this, true, getString(2131766089), "", getString(2131766088), getString(2131766087), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    fil();
    AppMethodBeat.o(100149);
  }
  
  private void hd(List<String[]> paramList)
  {
    AppMethodBeat.i(100164);
    if ((this.EFf == null) || (this.EFf.size() == 0))
    {
      AppMethodBeat.o(100164);
      return;
    }
    Iterator localIterator = this.EFf.iterator();
    paramList = paramList.iterator();
    ArrayList localArrayList1 = new ArrayList(this.EFf.size());
    ArrayList localArrayList2 = new ArrayList(this.EFf.size());
    while (localIterator.hasNext())
    {
      localArrayList1.add(com.tencent.mm.plugin.label.a.a.ecg().aCH((String)localIterator.next()));
      localArrayList2.add(Util.listToString(Arrays.asList((Object[])paramList.next()), ","));
      this.EEY = true;
    }
    com.tencent.mm.plugin.label.a.a.ecg().p(localArrayList1, localArrayList2);
    AppMethodBeat.o(100164);
  }
  
  private static int[] hj(List<Integer> paramList)
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
  
  final void fim()
  {
    AppMethodBeat.i(100151);
    Intent localIntent = new Intent();
    if (this.EZZ.EFr == this.EZW)
    {
      this.EEQ = Util.listToString(this.EZZ.EFt, ",");
      this.EER = Util.listToString(this.EZZ.EFv, ",");
      bc(localIntent);
    }
    for (;;)
    {
      localIntent.putExtra("k_select_group", aae(this.EZZ.EFr));
      localIntent.putExtra("k_select_index", this.EZZ.EFr);
      localIntent.putExtra("Ktag_range_index", this.EZZ.EFr);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(100151);
      return;
      if (this.EZZ.EFr == this.EZX)
      {
        this.EEQ = Util.listToString(this.EZZ.EFu, ",");
        this.EER = Util.listToString(this.EZZ.EFw, ",");
        bc(localIntent);
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131496446;
  }
  
  public void initView()
  {
    AppMethodBeat.i(100146);
    boolean bool = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
    this.EEN = ((AnimatedExpandableListView)findViewById(2131308142));
    this.EEP = ((ArrayList)com.tencent.mm.plugin.label.a.a.ecg().ecb());
    this.EZZ.EFs = bool;
    this.EZZ.aR(this.EEP);
    fiq();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    localLayoutParams.height = getResources().getDimensionPixelSize(2131165501);
    View localView = new View(this);
    localView.setLayoutParams(localLayoutParams);
    this.EEN.addHeaderView(localView);
    this.EEN.setAdapter(this.EZZ);
    this.EEN.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
    {
      public final boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100134);
        int i = JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFr;
        Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt) });
        if ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, paramAnonymousInt).equals("visible")) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, paramAnonymousInt).equals("invisible")))
        {
          if ((JsapiSnsLabelUI.b(JsapiSnsLabelUI.this) != null) && (JsapiSnsLabelUI.b(JsapiSnsLabelUI.this).size() != 0) && (JsapiSnsLabelUI.fks() == 0))
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
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, com.tencent.mm.ui.base.h.a(JsapiSnsLabelUI.this, JsapiSnsLabelUI.this.getString(2131766094), false, null));
            Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
            AppMethodBeat.o(100134);
            return true;
          }
          if ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFq == null) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFq.size() == 0))
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
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).apj(paramAnonymousInt);
            }
            for (;;)
            {
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFr = paramAnonymousInt;
              AppMethodBeat.o(100134);
              return true;
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).api(paramAnonymousInt);
            }
          }
          if (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("visible"))
          {
            JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).collapseGroup(i);
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFt.clear();
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFv.clear();
          }
          for (;;)
          {
            JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100133);
                JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).api(paramAnonymousInt);
                AppMethodBeat.o(100133);
              }
            });
            break;
            if (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("invisible"))
            {
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).collapseGroup(i);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFu.clear();
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFw.clear();
            }
          }
        }
        if ((i >= 0) && ((JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("visible")) || (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("invisible")))) {
          JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).apj(i);
        }
        JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFr = paramAnonymousInt;
        AppMethodBeat.o(100134);
        return false;
      }
    });
    this.EEN.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
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
          a.aRb(paramAnonymousExpandableListView);
          if (paramAnonymousInt1 == JsapiSnsLabelUI.this.EZW) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, 1, JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFt, paramAnonymousExpandableListView, paramAnonymousView);
          } else if (paramAnonymousInt1 == JsapiSnsLabelUI.this.EZX) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, 2, JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFu, paramAnonymousExpandableListView, paramAnonymousView);
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
    addTextOptionMenu(0, getString(2131766085), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(100137);
        paramAnonymousMenuItem = JsapiSnsLabelUI.this;
        String str1 = Util.listToString(paramAnonymousMenuItem.EZZ.EFt, ",");
        String str2 = Util.listToString(paramAnonymousMenuItem.EZZ.EFv, ",");
        String str3 = Util.listToString(paramAnonymousMenuItem.EZZ.EFu, ",");
        String str4 = Util.listToString(paramAnonymousMenuItem.EZZ.EFw, ",");
        if (((paramAnonymousMenuItem.EZZ.EFr == paramAnonymousMenuItem.EZW) && (paramAnonymousMenuItem.EZZ.EFt.size() == 0) && (paramAnonymousMenuItem.EZZ.EFv.size() == 0)) || ((paramAnonymousMenuItem.EZZ.EFr == paramAnonymousMenuItem.EZX) && (paramAnonymousMenuItem.EZZ.EFu.size() == 0) && (paramAnonymousMenuItem.EZZ.EFw.size() == 0))) {
          com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131766095), "", paramAnonymousMenuItem.getString(2131766107), null);
        }
        for (;;)
        {
          AppMethodBeat.o(100137);
          return true;
          if (((paramAnonymousMenuItem.EZZ.EFr == paramAnonymousMenuItem.EZW) && (Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2))) || ((paramAnonymousMenuItem.EZZ.EFr == paramAnonymousMenuItem.EZX) && (Util.isNullOrNil(str3)) && (Util.isNullOrNil(str4)))) {
            com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131766095), "", paramAnonymousMenuItem.getString(2131766107), null);
          } else {
            paramAnonymousMenuItem.fim();
          }
        }
      }
    }, null, t.b.OGU);
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
        c.b(getContext(), "label", ".ui.ContactLabelEditUI", paramIntent, 4002);
        AppMethodBeat.o(100147);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      this.EER = new String(paramIntent);
      Log.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.EFa == this.EZW)
      {
        this.EZZ.EFv.clear();
        if (!Util.isNullOrNil(paramIntent))
        {
          paramIntent = Util.stringsToList(paramIntent.split(","));
          this.EZZ.EFv.addAll(paramIntent);
          this.EZZ.EFr = this.EFa;
        }
      }
      for (;;)
      {
        this.EZZ.notifyDataSetChanged();
        this.EEN.expandGroup(this.EFa);
        AppMethodBeat.o(100147);
        return;
        if (this.EFa == this.EZX)
        {
          this.EZZ.EFw.clear();
          if (!Util.isNullOrNil(paramIntent))
          {
            paramIntent = Util.stringsToList(paramIntent.split(","));
            this.EZZ.EFw.addAll(paramIntent);
            this.EZZ.EFr = this.EFa;
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
        c.b(this, "label", ".ui.ContactLabelEditUI", (Intent)localObject, 4002);
      }
      AppMethodBeat.o(100147);
      return;
    }
    if ((paramInt2 == 0) && (paramInt1 == 4002) && (paramIntent != null))
    {
      localObject = paramIntent.getStringExtra("k_sns_label_add_label");
      this.EFc = paramIntent.getStringExtra("k_sns_label_add_label");
      this.EEN.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100139);
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, (ArrayList)com.tencent.mm.plugin.label.a.a.ecg().ecb());
          if (JsapiSnsLabelUI.j(JsapiSnsLabelUI.this) == null) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, new ArrayList());
          }
          if (!Util.isNullOrNil(this.EFl)) {
            if (!JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).contains(this.EFl)) {
              JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).add(this.EFl);
            }
          }
          for (int i = JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).indexOf(this.EFl);; i = -1)
          {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).aR(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
            JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFr = JsapiSnsLabelUI.l(JsapiSnsLabelUI.this);
            if ((!Util.isNullOrNil(this.EFl)) && (i != -1))
            {
              if (JsapiSnsLabelUI.l(JsapiSnsLabelUI.this) != JsapiSnsLabelUI.this.EZW) {
                break label252;
              }
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFt.add(this.EFl);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFv.clear();
            }
            for (;;)
            {
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).notifyDataSetChanged();
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).expandGroup(JsapiSnsLabelUI.l(JsapiSnsLabelUI.this));
              JsapiSnsLabelUI.m(JsapiSnsLabelUI.this);
              AppMethodBeat.o(100139);
              return;
              label252:
              if (JsapiSnsLabelUI.l(JsapiSnsLabelUI.this) == JsapiSnsLabelUI.this.EZX)
              {
                JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFu.add(this.EFl);
                JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFw.clear();
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
    setMMTitle(2131766256);
    g.aAi();
    g.aAg().hqi.a(292, this);
    g.aAi();
    g.aAg().hqi.a(635, this);
    g.aAi();
    g.aAg().hqi.a(638, this);
    g.aAi();
    g.aAg().hqi.a(290, this);
    this.EZZ = new a(this);
    this.EZZ.Fag = false;
    this.EZZ.Faf = new a.b()
    {
      public final void a(a.c paramAnonymousc)
      {
        AppMethodBeat.i(100130);
        int i = paramAnonymousc.EFE;
        int j = paramAnonymousc.EFF;
        JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i, j);
        AppMethodBeat.o(100130);
      }
    };
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      this.EEU = this.EZU;
      this.EZZ.style = 0;
      this.EEQ = null;
      this.EER = null;
      this.EZZ.EFr = this.EEU;
      if (this.EZZ.style == 1) {
        findViewById(2131308143).setBackgroundResource(2131100042);
      }
      if (this.EEU != this.EZW) {
        break label802;
      }
      if (!TextUtils.isEmpty(this.EEQ)) {
        this.EZZ.EFt = Util.stringsToList(this.EEQ.split(","));
      }
      if (!TextUtils.isEmpty(this.EER)) {
        this.EZZ.EFv = Util.stringsToList(this.EER.split(","));
      }
    }
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList;
    for (;;)
    {
      g.aAi();
      this.EEW = ((Boolean)g.aAh().azQ().get(335873, Boolean.TRUE)).booleanValue();
      if (this.EEW)
      {
        this.EEY = true;
        this.EEZ = true;
        if (fin() > 0) {
          this.EEX = true;
        }
        g.aAi();
        g.aAg().hqi.a(new w(1), 0);
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
      tmp413_411[0] = 2131766098;
      Object tmp418_413 = tmp413_411;
      tmp418_413[1] = 2131766096;
      Object tmp423_418 = tmp418_413;
      tmp423_418[2] = 2131766092;
      Object tmp428_423 = tmp423_418;
      tmp428_423[3] = 2131766083;
      tmp428_423;
      this.Faa.clear();
      localObject1 = new ArrayList();
      localArrayList = new ArrayList();
      if (bool1)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[0]));
        localArrayList.add(Integer.valueOf(localObject2[0]));
        this.Faa.add(this.EZY.get(0));
      }
      if (bool2)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[1]));
        localArrayList.add(Integer.valueOf(localObject2[1]));
        this.Faa.add(this.EZY.get(1));
      }
      if (bool3)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[2]));
        localArrayList.add(Integer.valueOf(localObject2[2]));
        this.Faa.add(this.EZY.get(2));
      }
      if (bool4)
      {
        ((List)localObject1).add(Integer.valueOf(localObject2[3]));
        localArrayList.add(Integer.valueOf(localObject2[3]));
        this.Faa.add(this.EZY.get(3));
      }
      if (this.Faa.size() != 0) {
        break label874;
      }
      finish();
      AppMethodBeat.o(100144);
      return;
      if (paramBundle.hasExtra("k_title")) {
        setMMTitle(paramBundle.getStringExtra("k_title"));
      }
      this.EEU = paramBundle.getIntExtra("KLabel_range_index", this.EZU);
      this.EZZ.style = paramBundle.getIntExtra("k_sns_label_ui_style", 0);
      this.EEQ = paramBundle.getStringExtra("Klabel_name_list");
      this.EER = paramBundle.getStringExtra("Kother_user_name_list");
      if (TextUtils.isEmpty(paramBundle.getStringExtra("k_sns_label_ui_title"))) {
        break;
      }
      setMMTitle(paramBundle.getStringExtra("k_sns_label_ui_title"));
      break;
      label802:
      if (this.EEU == this.EZX)
      {
        if (!TextUtils.isEmpty(this.EEQ)) {
          this.EZZ.EFu = Util.stringsToList(this.EEQ.split(","));
        }
        if (!TextUtils.isEmpty(this.EER)) {
          this.EZZ.EFw = Util.stringsToList(this.EER.split(","));
        }
      }
    }
    label874:
    this.EZU = this.Faa.indexOf("public");
    this.EZV = this.Faa.indexOf("private");
    this.EZW = this.Faa.indexOf("visible");
    this.EZX = this.Faa.indexOf("invisible");
    if (this.EZZ != null)
    {
      localObject2 = this.EZZ;
      List localList = this.Faa;
      ((a)localObject2).Fae = localList;
      ((a)localObject2).EZU = localList.indexOf("public");
      ((a)localObject2).EZV = localList.indexOf("private");
      ((a)localObject2).EZW = localList.indexOf("visible");
      ((a)localObject2).EZX = localList.indexOf("invisible");
      this.EZZ.Fad = ((List)localObject1).size();
      this.EZZ.EEO = hj((List)localObject1);
      this.EZZ.EFp = hj(localArrayList);
      if (!TextUtils.isEmpty(paramBundle))
      {
        this.EZZ.EFr = this.Faa.indexOf(paramBundle);
        if (paramBundle.equals("visible"))
        {
          if (!TextUtils.isEmpty(this.EEQ)) {
            this.EZZ.EFt = Util.stringsToList(this.EEQ.split(","));
          }
          if (!TextUtils.isEmpty(this.EER)) {
            this.EZZ.EFv = Util.stringsToList(this.EER.split(","));
          }
          this.EEN.expandGroup(this.Faa.indexOf(paramBundle));
          AppMethodBeat.o(100144);
          return;
        }
        if (paramBundle.equals("invisible"))
        {
          if (!TextUtils.isEmpty(this.EEQ)) {
            this.EZZ.EFu = Util.stringsToList(this.EEQ.split(","));
          }
          if (!TextUtils.isEmpty(this.EER)) {
            this.EZZ.EFw = Util.stringsToList(this.EER.split(","));
          }
          this.EEN.expandGroup(this.Faa.indexOf(paramBundle));
        }
      }
    }
    label1265:
    AppMethodBeat.o(100144);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(100158);
    g.aAi();
    g.aAg().hqi.b(292, this);
    g.aAi();
    g.aAg().hqi.b(635, this);
    g.aAi();
    g.aAg().hqi.b(638, this);
    g.aAi();
    g.aAg().hqi.b(290, this);
    super.onDestroy();
    AppMethodBeat.o(100158);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(100159);
    if ((this.EZZ != null) && (this.EFc == null) && (this.EEN != null)) {
      this.EEN.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100131);
          com.tencent.mm.plugin.label.a.a.ecg().aHn();
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, (ArrayList)com.tencent.mm.plugin.label.a.a.ecg().ecb());
          JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).aR(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
          JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
          if (((JsapiSnsLabelUI.j(JsapiSnsLabelUI.this) == null) || (JsapiSnsLabelUI.j(JsapiSnsLabelUI.this).size() == 0)) && ((JsapiSnsLabelUI.p(JsapiSnsLabelUI.this) == null) || (JsapiSnsLabelUI.p(JsapiSnsLabelUI.this).length() == 0)) && (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFr != JsapiSnsLabelUI.this.EZU) && (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFr != JsapiSnsLabelUI.this.EZV)) {
            JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFr = JsapiSnsLabelUI.this.EZU;
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(100160);
    Log.i("MicroMsg.SnsLabelUI", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!this.EEY)
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
        localObject = aj.faU().getCursor();
        this.EFd = ((Cursor)localObject).getCount();
        if (this.EFd > 0)
        {
          ((Cursor)localObject).moveToFirst();
          s locals = new s();
          paramInt1 = ((Cursor)localObject).getCount();
          this.EFf = new ArrayList(paramInt1);
          this.EFe = new ArrayList(paramInt1);
          this.EFh = new ArrayList(paramInt1);
          this.EFg = new ArrayList(paramInt1);
          if (!((Cursor)localObject).isAfterLast())
          {
            locals.convertFrom((Cursor)localObject);
            if ((locals.field_memberList != null) && (locals.field_memberList.length() != 0))
            {
              this.EFh.add(locals.field_memberList.split(","));
              paramq = locals.field_tagName;
              ArrayList localArrayList = this.EFf;
              paramString = com.tencent.mm.plugin.label.a.a.ecg().ecd();
              if (paramString == null)
              {
                paramString = paramq;
                label297:
                localArrayList.add(paramString);
                this.EFe.add(paramq);
                this.EFg.add(Long.valueOf(locals.field_tagId));
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
              paramString = String.format(getString(2131766086), new Object[] { paramq });
              break label297;
              Log.e("MicroMsg.SnsLabelUI", "dz:snstaginfo memberlist is null.");
            }
          }
          ((Cursor)localObject).close();
          if (this.EFe.size() != 0) {
            break label508;
          }
          paramInt1 = 0;
          if (paramInt1 != 0) {}
        }
        else if (this.EEZ)
        {
          this.EZZ.EFr = this.EFa;
          this.EEN.api(this.EFa);
          g.aAi();
          g.aAh().azQ().set(335873, Boolean.FALSE);
        }
        ((Cursor)localObject).close();
        if (this.EEX)
        {
          this.EEY = true;
          com.tencent.mm.plugin.label.a.a.ecg().fi(this.EFf);
        }
      }
      for (;;)
      {
        this.EEZ = false;
        AppMethodBeat.o(100160);
        return;
        label508:
        paramInt1 = 1;
        break;
        this.EEY = false;
        continue;
        fip();
        Log.i("MicroMsg.SnsLabelUI", "dz: error at get sns tag list!");
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        hd(this.EFh);
        AppMethodBeat.o(100160);
        return;
      }
      fip();
      Log.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
      AppMethodBeat.o(100160);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.EFe.iterator();
        paramq = this.EFg.iterator();
        while (paramString.hasNext())
        {
          long l = ((Long)paramq.next()).longValue();
          localObject = (String)paramString.next();
          if (l != 0L)
          {
            g.aAi();
            g.aAg().hqi.a(new y(l, (String)localObject), 0);
          }
        }
        g.aAi();
        g.aAh().azQ().set(335874, Integer.valueOf(0));
        this.EEP = ((ArrayList)com.tencent.mm.plugin.label.a.a.ecg().ecb());
        paramString = com.tencent.mm.plugin.report.service.h.CyF;
        paramInt2 = this.EFd;
        if (this.EFf == null) {}
        for (paramInt1 = 0;; paramInt1 = this.EFf.size())
        {
          paramString.a(11455, new Object[] { "", "", Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
          this.EEN.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100132);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFr = JsapiSnsLabelUI.l(JsapiSnsLabelUI.this);
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
                    a.aRb((String)((Iterator)localObject).next());
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
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).aR(JsapiSnsLabelUI.j(JsapiSnsLabelUI.this));
              JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
              JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).notifyDataSetChanged();
              JsapiSnsLabelUI.g(JsapiSnsLabelUI.this).api(JsapiSnsLabelUI.a(JsapiSnsLabelUI.this).EFr);
              if ((JsapiSnsLabelUI.r(JsapiSnsLabelUI.this) != null) && (JsapiSnsLabelUI.r(JsapiSnsLabelUI.this).isShowing())) {
                JsapiSnsLabelUI.r(JsapiSnsLabelUI.this).dismiss();
              }
              AppMethodBeat.o(100132);
            }
          }, 600L);
          g.aAi();
          g.aAh().azQ().set(335873, Boolean.FALSE);
          AppMethodBeat.o(100160);
          return;
        }
      }
      fip();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI
 * JD-Core Version:    0.7.0.1
 */