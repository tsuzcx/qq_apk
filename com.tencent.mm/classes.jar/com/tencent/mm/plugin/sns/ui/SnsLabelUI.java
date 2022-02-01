package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.b.a.gn;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsLabelUI
  extends MMActivity
  implements f
{
  public static int[] AvA = { 2131763871, 2131763869, 2131763865, 2131763856 };
  private ArrayList<String> AvB;
  private String AvC;
  private String AvD;
  private String AvE;
  ba AvF;
  private int AvG = 0;
  private boolean AvH;
  private boolean AvI = false;
  private boolean AvJ = false;
  private boolean AvK = false;
  private int AvL;
  private p AvM;
  private String AvN;
  private int AvO;
  private ArrayList<String> AvP;
  private ArrayList<String> AvQ;
  private ArrayList<Long> AvR;
  private ArrayList<String[]> AvS;
  private AnimatedExpandableListView Avz;
  
  private boolean efK()
  {
    boolean bool2 = true;
    AppMethodBeat.i(98800);
    int i = this.AvF.Awc;
    boolean bool1;
    if (this.AvF.Awc != this.AvG) {
      if (i == 2)
      {
        bool1 = bool2;
        if (this.AvF.Awe.size() == 0)
        {
          bool1 = bool2;
          if (this.AvF.Awg.size() != 0) {}
        }
      }
      else
      {
        if (i != 3) {
          break label106;
        }
        bool1 = bool2;
        if (this.AvF.Awf.size() == 0)
        {
          if (this.AvF.Awh.size() == 0) {
            break label106;
          }
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(98800);
      return bool1;
      label106:
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 0)
        {
          do
          {
            do
            {
              bool1 = false;
              break;
              if ((i == 2) && (this.AvF.Awe.size() != 0))
              {
                bool1 = bool2;
                if (!bu.m(this.AvF.Awe, ",").equals(this.AvC)) {
                  break;
                }
                bool1 = bool2;
                if (!bu.m(this.AvF.Awg, ",").equals(this.AvD)) {
                  break;
                }
                bool1 = bool2;
                if (!bu.m(this.AvF.Awi, ",").equals(this.AvE)) {
                  break;
                }
              }
            } while ((i != 3) || (this.AvF.Awf.size() == 0));
            bool1 = bool2;
            if (!bu.m(this.AvF.Awf, ",").equals(this.AvC)) {
              break;
            }
            bool1 = bool2;
            if (!bu.m(this.AvF.Awh, ",").equals(this.AvD)) {
              break;
            }
          } while (bu.m(this.AvF.Awj, ",").equals(this.AvE));
          bool1 = bool2;
        }
      }
    }
  }
  
  private void efL()
  {
    AppMethodBeat.i(98802);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ktag_range_index", this.AvG);
    if ((this.AvG == 2) || (this.AvG == 3))
    {
      efR();
      localIntent.putExtra("Klabel_name_list", this.AvC);
      localIntent.putExtra("Kother_user_name_list", this.AvD);
      localIntent.putExtra("Kchat_room_name_list", this.AvE);
    }
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(98802);
  }
  
  private static int efN()
  {
    AppMethodBeat.i(98807);
    com.tencent.mm.kernel.g.ajS();
    int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(335874, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(98807);
    return i;
  }
  
  private static void efO()
  {
    AppMethodBeat.i(98808);
    com.tencent.mm.kernel.g.ajS();
    int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(335874, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().ajA().set(335874, Integer.valueOf(i + 1));
    AppMethodBeat.o(98808);
  }
  
  private void efP()
  {
    AppMethodBeat.i(98809);
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
      AppMethodBeat.o(98809);
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
    AppMethodBeat.o(98809);
  }
  
  private void efQ()
  {
    AppMethodBeat.i(98811);
    if ((this.AvB == null) || (this.AvB.isEmpty()))
    {
      if (this.AvF.Awe != null) {
        this.AvF.Awe.clear();
      }
      if (this.AvF.Awf != null) {
        this.AvF.Awf.clear();
      }
      AppMethodBeat.o(98811);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    String str;
    if ((this.AvG == 2) && (this.AvF.Awe != null))
    {
      localIterator = this.AvF.Awe.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.AvB.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.AvF.Awe.removeAll(localArrayList);
      AppMethodBeat.o(98811);
      return;
    }
    if (this.AvG == 3)
    {
      localIterator = this.AvF.Awf.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.AvB.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.AvF.Awf.removeAll(localArrayList);
    }
    AppMethodBeat.o(98811);
  }
  
  private void efR()
  {
    AppMethodBeat.i(98812);
    if ((this.AvB == null) || (this.AvB.isEmpty()))
    {
      this.AvC = "";
      AppMethodBeat.o(98812);
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
    AppMethodBeat.o(98812);
  }
  
  private void gg(List<String[]> paramList)
  {
    AppMethodBeat.i(98810);
    if ((this.AvQ == null) || (this.AvQ.size() == 0))
    {
      AppMethodBeat.o(98810);
      return;
    }
    Iterator localIterator = this.AvQ.iterator();
    paramList = paramList.iterator();
    ArrayList localArrayList1 = new ArrayList(this.AvQ.size());
    ArrayList localArrayList2 = new ArrayList(this.AvQ.size());
    while (localIterator.hasNext())
    {
      localArrayList1.add(a.dig().apo((String)localIterator.next()));
      localArrayList2.add(bu.m(Arrays.asList((Object[])paramList.next()), ","));
      this.AvJ = true;
    }
    a.dig().n(localArrayList1, localArrayList2);
    AppMethodBeat.o(98810);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(98801);
    if (efK())
    {
      h.a(this, true, getString(2131763862), "", getString(2131763861), getString(2131763860), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(98794);
          SnsLabelUI.o(SnsLabelUI.this);
          AppMethodBeat.o(98794);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(98795);
          SnsLabelUI.p(SnsLabelUI.this);
          AppMethodBeat.o(98795);
        }
      });
      AppMethodBeat.o(98801);
      return;
    }
    efL();
    AppMethodBeat.o(98801);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98796);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      goBack();
      AppMethodBeat.o(98796);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98796);
    return bool;
  }
  
  final void efM()
  {
    AppMethodBeat.i(98803);
    Intent localIntent = new Intent();
    if (this.AvF.Awc == 2)
    {
      this.AvC = bu.m(this.AvF.Awe, ",");
      this.AvD = bu.m(this.AvF.Awg, ",");
      this.AvE = bu.m(this.AvF.Awi, ",");
      efR();
      localIntent.putExtra("Klabel_name_list", this.AvC);
      localIntent.putExtra("Kother_user_name_list", this.AvD);
      localIntent.putExtra("Kchat_room_name_list", this.AvE);
    }
    for (;;)
    {
      localIntent.putExtra("Ktag_range_index", this.AvF.Awc);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(98803);
      return;
      if (this.AvF.Awc == 3)
      {
        this.AvC = bu.m(this.AvF.Awf, ",");
        this.AvD = bu.m(this.AvF.Awh, ",");
        this.AvE = bu.m(this.AvF.Awj, ",");
        efR();
        localIntent.putExtra("Klabel_name_list", this.AvC);
        localIntent.putExtra("Kother_user_name_list", this.AvD);
        localIntent.putExtra("Kchat_room_name_list", this.AvE);
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131495554;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98798);
    boolean bool = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
    this.Avz = ((AnimatedExpandableListView)findViewById(2131304991));
    this.AvB = ((ArrayList)a.dig().dib());
    this.AvF.Awd = bool;
    this.AvF.aA(this.AvB);
    efQ();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    localLayoutParams.height = getResources().getDimensionPixelSize(2131165483);
    View localView = new View(this);
    localView.setLayoutParams(localLayoutParams);
    this.Avz.addHeaderView(localView);
    this.Avz.setAdapter(this.AvF);
    if (this.AvF.Awc == 2) {
      this.Avz.expandGroup(2);
    }
    for (;;)
    {
      this.Avz.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
      {
        public final boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(98788);
          int i = SnsLabelUI.a(SnsLabelUI.this).Awc;
          com.tencent.mm.plugin.sns.j.e.zKO.QS(paramAnonymousInt);
          ae.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt > 1)
          {
            if ((SnsLabelUI.b(SnsLabelUI.this) != null) && (SnsLabelUI.b(SnsLabelUI.this).size() != 0) && (SnsLabelUI.efS() == 0))
            {
              SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt);
              SnsLabelUI.c(SnsLabelUI.this);
              ae.i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
              AppMethodBeat.o(98788);
              return true;
            }
            if (SnsLabelUI.d(SnsLabelUI.this))
            {
              SnsLabelUI.e(SnsLabelUI.this);
              SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt);
              SnsLabelUI.a(SnsLabelUI.this, h.b(SnsLabelUI.this, SnsLabelUI.this.getString(2131763867), false, null));
              ae.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
              AppMethodBeat.o(98788);
              return true;
            }
            if ((SnsLabelUI.a(SnsLabelUI.this).Awb == null) || (SnsLabelUI.a(SnsLabelUI.this).Awb.size() == 0))
            {
              SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt);
              SnsLabelUI.f(SnsLabelUI.this);
              ae.i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
              AppMethodBeat.o(98788);
              return true;
            }
            if (i == paramAnonymousInt)
            {
              if (SnsLabelUI.g(SnsLabelUI.this).isGroupExpanded(paramAnonymousInt)) {
                SnsLabelUI.g(SnsLabelUI.this).agg(paramAnonymousInt);
              }
              for (;;)
              {
                SnsLabelUI.a(SnsLabelUI.this).Awc = paramAnonymousInt;
                AppMethodBeat.o(98788);
                return true;
                SnsLabelUI.g(SnsLabelUI.this).agf(paramAnonymousInt);
              }
            }
            if (i == 2)
            {
              SnsLabelUI.g(SnsLabelUI.this).collapseGroup(2);
              SnsLabelUI.a(SnsLabelUI.this).Awe.clear();
              SnsLabelUI.a(SnsLabelUI.this).Awg.clear();
            }
            for (;;)
            {
              SnsLabelUI.g(SnsLabelUI.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(98787);
                  SnsLabelUI.g(SnsLabelUI.this).agf(paramAnonymousInt);
                  AppMethodBeat.o(98787);
                }
              });
              break;
              if (i == 3)
              {
                SnsLabelUI.g(SnsLabelUI.this).collapseGroup(3);
                SnsLabelUI.a(SnsLabelUI.this).Awf.clear();
                SnsLabelUI.a(SnsLabelUI.this).Awh.clear();
              }
            }
          }
          if (i > 1) {
            SnsLabelUI.g(SnsLabelUI.this).agg(i);
          }
          SnsLabelUI.a(SnsLabelUI.this).Awc = paramAnonymousInt;
          AppMethodBeat.o(98788);
          return false;
        }
      });
      this.Avz.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
      {
        public final boolean onChildClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong)
        {
          AppMethodBeat.i(98789);
          if (paramAnonymousInt2 == ba.AvY)
          {
            SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt1);
            SnsLabelUI.f(SnsLabelUI.this);
            if (paramAnonymousInt2 != ba.AvY) {
              break label208;
            }
            paramAnonymousExpandableListView = com.tencent.mm.plugin.sns.j.e.zKO;
            if (paramAnonymousExpandableListView.zKY != null)
            {
              if (paramAnonymousExpandableListView.zKY.epQ > 0) {
                break label189;
              }
              paramAnonymousExpandableListView.zKY.epQ = 1;
            }
          }
          for (;;)
          {
            AppMethodBeat.o(98789);
            return false;
            if (paramAnonymousInt2 == ba.AvX)
            {
              SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt1);
              SnsLabelUI.h(SnsLabelUI.this);
              break;
            }
            paramAnonymousExpandableListView = (String)SnsLabelUI.a(SnsLabelUI.this).getChild(paramAnonymousInt1, paramAnonymousInt2 - ba.AvZ);
            SnsLabelUI.a(SnsLabelUI.this);
            ba.aCg(paramAnonymousExpandableListView);
            if (paramAnonymousInt1 == 2)
            {
              SnsLabelUI.a(SnsLabelUI.this, 1, SnsLabelUI.a(SnsLabelUI.this).Awe, paramAnonymousExpandableListView, paramAnonymousView);
              break;
            }
            if (paramAnonymousInt1 != 3) {
              break;
            }
            SnsLabelUI.a(SnsLabelUI.this, 2, SnsLabelUI.a(SnsLabelUI.this).Awf, paramAnonymousExpandableListView, paramAnonymousView);
            break;
            label189:
            paramAnonymousExpandableListView.zKY.epQ += 1;
            continue;
            label208:
            if (paramAnonymousInt2 == ba.AvX)
            {
              paramAnonymousExpandableListView = com.tencent.mm.plugin.sns.j.e.zKO;
              if (paramAnonymousExpandableListView.zKY != null) {
                if (paramAnonymousExpandableListView.zKY.epL <= 0) {
                  paramAnonymousExpandableListView.zKY.epL = 1;
                } else {
                  paramAnonymousExpandableListView.zKY.epL += 1;
                }
              }
            }
          }
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(98790);
          SnsLabelUI.i(SnsLabelUI.this);
          AppMethodBeat.o(98790);
          return true;
        }
      });
      addTextOptionMenu(0, getString(2131763858), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(98791);
          paramAnonymousMenuItem = SnsLabelUI.this;
          String str1 = bu.m(paramAnonymousMenuItem.AvF.Awe, ",");
          String str2 = bu.m(paramAnonymousMenuItem.AvF.Awg, ",");
          String str3 = bu.m(paramAnonymousMenuItem.AvF.Awi, ",");
          String str4 = bu.m(paramAnonymousMenuItem.AvF.Awf, ",");
          String str5 = bu.m(paramAnonymousMenuItem.AvF.Awh, ",");
          String str6 = bu.m(paramAnonymousMenuItem.AvF.Awj, ",");
          if (((paramAnonymousMenuItem.AvF.Awc == 2) && (paramAnonymousMenuItem.AvF.Awe.size() == 0) && (paramAnonymousMenuItem.AvF.Awg.size() == 0) && (paramAnonymousMenuItem.AvF.Awi.size() == 0)) || ((paramAnonymousMenuItem.AvF.Awc == 3) && (paramAnonymousMenuItem.AvF.Awf.size() == 0) && (paramAnonymousMenuItem.AvF.Awh.size() == 0) && (paramAnonymousMenuItem.AvF.Awj.size() == 0))) {
            h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131763868), "", paramAnonymousMenuItem.getString(2131763880), null);
          }
          for (;;)
          {
            AppMethodBeat.o(98791);
            return true;
            if (((paramAnonymousMenuItem.AvF.Awc == 2) && (bu.isNullOrNil(str1)) && (bu.isNullOrNil(str2)) && (bu.isNullOrNil(str3))) || ((paramAnonymousMenuItem.AvF.Awc == 3) && (bu.isNullOrNil(str4)) && (bu.isNullOrNil(str5)) && (bu.isNullOrNil(str6)))) {
              h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131763868), "", paramAnonymousMenuItem.getString(2131763880), null);
            } else {
              paramAnonymousMenuItem.efM();
            }
          }
        }
      }, null, s.b.JwA);
      AppMethodBeat.o(98798);
      return;
      if (this.AvF.Awc == 3) {
        this.Avz.expandGroup(3);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98799);
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
        AppMethodBeat.o(98799);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      this.AvD = new String(paramIntent);
      ae.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.AvL == 2)
      {
        this.AvF.Awg.clear();
        if (!bu.isNullOrNil(paramIntent))
        {
          paramIntent = bu.U(paramIntent.split(","));
          this.AvF.Awg.addAll(paramIntent);
          this.AvF.Awc = this.AvL;
        }
      }
      for (;;)
      {
        this.AvF.notifyDataSetChanged();
        this.Avz.expandGroup(this.AvL);
        AppMethodBeat.o(98799);
        return;
        if (this.AvL == 3)
        {
          this.AvF.Awh.clear();
          if (!bu.isNullOrNil(paramIntent))
          {
            paramIntent = bu.U(paramIntent.split(","));
            this.AvF.Awh.addAll(paramIntent);
            this.AvF.Awc = this.AvL;
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
      AppMethodBeat.o(98799);
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
          AppMethodBeat.i(98793);
          SnsLabelUI.a(SnsLabelUI.this, (ArrayList)a.dig().dib());
          if (SnsLabelUI.k(SnsLabelUI.this) == null) {
            SnsLabelUI.a(SnsLabelUI.this, new ArrayList());
          }
          if (!bu.isNullOrNil(this.AvW)) {
            if (!SnsLabelUI.k(SnsLabelUI.this).contains(this.AvW)) {
              SnsLabelUI.k(SnsLabelUI.this).add(this.AvW);
            }
          }
          for (int i = SnsLabelUI.k(SnsLabelUI.this).indexOf(this.AvW);; i = -1)
          {
            SnsLabelUI.a(SnsLabelUI.this).aA(SnsLabelUI.k(SnsLabelUI.this));
            SnsLabelUI.l(SnsLabelUI.this);
            SnsLabelUI.a(SnsLabelUI.this).Awc = SnsLabelUI.m(SnsLabelUI.this);
            if ((!bu.isNullOrNil(this.AvW)) && (i != -1))
            {
              if (SnsLabelUI.m(SnsLabelUI.this) != 2) {
                break label246;
              }
              SnsLabelUI.a(SnsLabelUI.this).Awe.add(this.AvW);
              SnsLabelUI.a(SnsLabelUI.this).Awg.clear();
            }
            for (;;)
            {
              SnsLabelUI.a(SnsLabelUI.this).notifyDataSetChanged();
              SnsLabelUI.g(SnsLabelUI.this).expandGroup(SnsLabelUI.m(SnsLabelUI.this));
              SnsLabelUI.n(SnsLabelUI.this);
              AppMethodBeat.o(98793);
              return;
              label246:
              if (SnsLabelUI.m(SnsLabelUI.this) == 3)
              {
                SnsLabelUI.a(SnsLabelUI.this).Awf.add(this.AvW);
                SnsLabelUI.a(SnsLabelUI.this).Awh.clear();
              }
            }
          }
        }
      }, 600L);
      AppMethodBeat.o(98799);
      return;
    }
    if ((paramInt2 == -1) && (paramInt1 == 4004))
    {
      ae.i("MicroMsg.SnsLabelUI", "the Activity completed");
      paramIntent = paramIntent.getStringExtra("select_chatrooms");
      this.AvE = paramIntent;
      ae.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.AvL != 2) {
        break label563;
      }
      this.AvF.Awi.clear();
      if (!bu.isNullOrNil(paramIntent))
      {
        paramIntent = bu.U(paramIntent.split(","));
        this.AvF.Awi.addAll(paramIntent);
        this.AvF.Awc = this.AvL;
      }
    }
    for (;;)
    {
      this.AvF.notifyDataSetChanged();
      this.Avz.expandGroup(this.AvL);
      AppMethodBeat.o(98799);
      return;
      label563:
      if (this.AvL == 3)
      {
        this.AvF.Awj.clear();
        if (!bu.isNullOrNil(paramIntent))
        {
          paramIntent = bu.U(paramIntent.split(","));
          this.AvF.Awj.addAll(paramIntent);
          this.AvF.Awc = this.AvL;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98797);
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
    this.AvF = new ba(this);
    this.AvF.Awk = new ba.b()
    {
      public final void a(ba.c paramAnonymousc)
      {
        AppMethodBeat.i(98784);
        int i = paramAnonymousc.Awp;
        int j = paramAnonymousc.Awq;
        SnsLabelUI.a(SnsLabelUI.this, i, j);
        AppMethodBeat.o(98784);
      }
    };
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      this.AvG = 0;
      this.AvF.style = 0;
      this.AvC = null;
      this.AvD = null;
      this.AvE = null;
      this.AvF.Awc = this.AvG;
      if (this.AvF.style == 1) {
        findViewById(2131304992).setBackgroundResource(2131100017);
      }
      if (this.AvG != 2) {
        break label465;
      }
      if (!TextUtils.isEmpty(this.AvC)) {
        this.AvF.Awe = bu.U(this.AvC.split(","));
      }
      if (!TextUtils.isEmpty(this.AvD)) {
        this.AvF.Awg = bu.U(this.AvD.split(","));
      }
      if ((this.AvE != null) && (!this.AvE.isEmpty())) {
        this.AvF.Awi = bu.U(this.AvE.split(","));
      }
    }
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
      AppMethodBeat.o(98797);
      return;
      this.AvG = paramBundle.getIntExtra("KLabel_range_index", 0);
      this.AvF.style = paramBundle.getIntExtra("k_sns_label_ui_style", 0);
      this.AvC = paramBundle.getStringExtra("Klabel_name_list");
      this.AvD = paramBundle.getStringExtra("Kother_user_name_list");
      this.AvE = paramBundle.getStringExtra("Kchat_room_name_list");
      if (TextUtils.isEmpty(paramBundle.getStringExtra("k_sns_label_ui_title"))) {
        break;
      }
      setMMTitle(paramBundle.getStringExtra("k_sns_label_ui_title"));
      break;
      label465:
      if (this.AvG == 3)
      {
        if (!TextUtils.isEmpty(this.AvC)) {
          this.AvF.Awf = bu.U(this.AvC.split(","));
        }
        if (!TextUtils.isEmpty(this.AvD)) {
          this.AvF.Awh = bu.U(this.AvD.split(","));
        }
        if ((this.AvE != null) && (!this.AvE.isEmpty())) {
          this.AvF.Awj = bu.U(this.AvE.split(","));
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98804);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(292, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(635, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(638, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(290, this);
    super.onDestroy();
    AppMethodBeat.o(98804);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98805);
    if ((this.AvF != null) && (this.AvN == null) && (this.Avz != null)) {
      this.Avz.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98785);
          a.dig().aoM();
          SnsLabelUI.a(SnsLabelUI.this, (ArrayList)a.dig().dib());
          SnsLabelUI.a(SnsLabelUI.this).aA(SnsLabelUI.k(SnsLabelUI.this));
          SnsLabelUI.l(SnsLabelUI.this);
          if (((SnsLabelUI.k(SnsLabelUI.this) == null) || (SnsLabelUI.k(SnsLabelUI.this).size() == 0)) && ((SnsLabelUI.q(SnsLabelUI.this) == null) || (SnsLabelUI.q(SnsLabelUI.this).length() == 0)) && (SnsLabelUI.a(SnsLabelUI.this).Awc != 0) && (SnsLabelUI.a(SnsLabelUI.this).Awc != 1) && ((SnsLabelUI.r(SnsLabelUI.this) == null) || (SnsLabelUI.r(SnsLabelUI.this).length() == 0))) {
            SnsLabelUI.a(SnsLabelUI.this).Awc = 0;
          }
          SnsLabelUI.a(SnsLabelUI.this).notifyDataSetChanged();
          SnsLabelUI.n(SnsLabelUI.this);
          AppMethodBeat.o(98785);
        }
      }, 600L);
    }
    super.onResume();
    AppMethodBeat.o(98805);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(98806);
    ae.i("MicroMsg.SnsLabelUI", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!this.AvJ)
    {
      AppMethodBeat.o(98806);
      return;
    }
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(98806);
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
              paramString = a.dig().did();
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
            break label525;
          }
          paramInt1 = 0;
          if (paramInt1 != 0) {}
        }
        else if (this.AvK)
        {
          this.AvF.Awc = this.AvL;
          if ((this.Avz != null) && (this.Avz.getChildCount() > 0)) {
            this.Avz.agf(this.AvL);
          }
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().set(335873, Boolean.FALSE);
        }
        ((Cursor)localObject).close();
        if (this.AvI)
        {
          this.AvJ = true;
          a.dig().eo(this.AvQ);
        }
      }
      for (;;)
      {
        this.AvK = false;
        AppMethodBeat.o(98806);
        return;
        label525:
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
        AppMethodBeat.o(98806);
        return;
      }
      efP();
      ae.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
      AppMethodBeat.o(98806);
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
        this.AvB = ((ArrayList)a.dig().dib());
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
              AppMethodBeat.i(98786);
              SnsLabelUI.a(SnsLabelUI.this).Awc = SnsLabelUI.m(SnsLabelUI.this);
              if (SnsLabelUI.b(SnsLabelUI.this) != null)
              {
                if (SnsLabelUI.k(SnsLabelUI.this) == null) {
                  SnsLabelUI.a(SnsLabelUI.this, SnsLabelUI.b(SnsLabelUI.this));
                }
                for (;;)
                {
                  localObject = SnsLabelUI.b(SnsLabelUI.this).iterator();
                  while (((Iterator)localObject).hasNext())
                  {
                    SnsLabelUI.a(SnsLabelUI.this);
                    ba.aCg((String)((Iterator)localObject).next());
                  }
                  SnsLabelUI.k(SnsLabelUI.this).addAll(SnsLabelUI.b(SnsLabelUI.this));
                }
                Object localObject = new HashSet(SnsLabelUI.k(SnsLabelUI.this));
                SnsLabelUI.k(SnsLabelUI.this).clear();
                SnsLabelUI.k(SnsLabelUI.this).addAll((Collection)localObject);
                SnsLabelUI.b(SnsLabelUI.this).clear();
                SnsLabelUI.s(SnsLabelUI.this);
                ((HashSet)localObject).clear();
              }
              SnsLabelUI.a(SnsLabelUI.this).aA(SnsLabelUI.k(SnsLabelUI.this));
              SnsLabelUI.l(SnsLabelUI.this);
              SnsLabelUI.a(SnsLabelUI.this).notifyDataSetChanged();
              SnsLabelUI.g(SnsLabelUI.this).agf(SnsLabelUI.a(SnsLabelUI.this).Awc);
              if ((SnsLabelUI.t(SnsLabelUI.this) != null) && (SnsLabelUI.t(SnsLabelUI.this).isShowing())) {
                SnsLabelUI.t(SnsLabelUI.this).dismiss();
              }
              AppMethodBeat.o(98786);
            }
          }, 600L);
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().set(335873, Boolean.FALSE);
          AppMethodBeat.o(98806);
          return;
        }
      }
      efP();
      ae.i("MicroMsg.SnsLabelUI", "dz: error at modify label list!");
      AppMethodBeat.o(98806);
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI
 * JD-Core Version:    0.7.0.1
 */