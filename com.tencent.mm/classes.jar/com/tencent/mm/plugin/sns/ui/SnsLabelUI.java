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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.b.a.fm;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.sns.j.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
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
  implements com.tencent.mm.ak.g
{
  public static int[] yMS = { 2131763871, 2131763869, 2131763865, 2131763856 };
  private AnimatedExpandableListView yMR;
  private ArrayList<String> yMT;
  private String yMU;
  private String yMV;
  private String yMW;
  ax yMX;
  private int yMY = 0;
  private boolean yMZ;
  private boolean yNa = false;
  private boolean yNb = false;
  private boolean yNc = false;
  private int yNd;
  private p yNe;
  private String yNf;
  private int yNg;
  private ArrayList<String> yNh;
  private ArrayList<String> yNi;
  private ArrayList<Long> yNj;
  private ArrayList<String[]> yNk;
  
  private boolean dPM()
  {
    boolean bool2 = true;
    AppMethodBeat.i(98800);
    int i = this.yMX.yNu;
    boolean bool1;
    if (this.yMX.yNu != this.yMY) {
      if (i == 2)
      {
        bool1 = bool2;
        if (this.yMX.yNw.size() == 0)
        {
          bool1 = bool2;
          if (this.yMX.yNy.size() != 0) {}
        }
      }
      else
      {
        if (i != 3) {
          break label106;
        }
        bool1 = bool2;
        if (this.yMX.yNx.size() == 0)
        {
          if (this.yMX.yNz.size() == 0) {
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
              if ((i == 2) && (this.yMX.yNw.size() != 0))
              {
                bool1 = bool2;
                if (!bs.n(this.yMX.yNw, ",").equals(this.yMU)) {
                  break;
                }
                bool1 = bool2;
                if (!bs.n(this.yMX.yNy, ",").equals(this.yMV)) {
                  break;
                }
                bool1 = bool2;
                if (!bs.n(this.yMX.yNA, ",").equals(this.yMW)) {
                  break;
                }
              }
            } while ((i != 3) || (this.yMX.yNx.size() == 0));
            bool1 = bool2;
            if (!bs.n(this.yMX.yNx, ",").equals(this.yMU)) {
              break;
            }
            bool1 = bool2;
            if (!bs.n(this.yMX.yNz, ",").equals(this.yMV)) {
              break;
            }
          } while (bs.n(this.yMX.yNB, ",").equals(this.yMW));
          bool1 = bool2;
        }
      }
    }
  }
  
  private void dPN()
  {
    AppMethodBeat.i(98802);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ktag_range_index", this.yMY);
    if ((this.yMY == 2) || (this.yMY == 3))
    {
      dPT();
      localIntent.putExtra("Klabel_name_list", this.yMU);
      localIntent.putExtra("Kother_user_name_list", this.yMV);
      localIntent.putExtra("Kchat_room_name_list", this.yMW);
    }
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(98802);
  }
  
  private static int dPP()
  {
    AppMethodBeat.i(98807);
    com.tencent.mm.kernel.g.agS();
    int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(335874, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(98807);
    return i;
  }
  
  private static void dPQ()
  {
    AppMethodBeat.i(98808);
    com.tencent.mm.kernel.g.agS();
    int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(335874, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agA().set(335874, Integer.valueOf(i + 1));
    AppMethodBeat.o(98808);
  }
  
  private void dPR()
  {
    AppMethodBeat.i(98809);
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
      AppMethodBeat.o(98809);
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
    AppMethodBeat.o(98809);
  }
  
  private void dPS()
  {
    AppMethodBeat.i(98811);
    if ((this.yMT == null) || (this.yMT.isEmpty()))
    {
      if (this.yMX.yNw != null) {
        this.yMX.yNw.clear();
      }
      if (this.yMX.yNx != null) {
        this.yMX.yNx.clear();
      }
      AppMethodBeat.o(98811);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    String str;
    if ((this.yMY == 2) && (this.yMX.yNw != null))
    {
      localIterator = this.yMX.yNw.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.yMT.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.yMX.yNw.removeAll(localArrayList);
      AppMethodBeat.o(98811);
      return;
    }
    if (this.yMY == 3)
    {
      localIterator = this.yMX.yNx.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.yMT.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.yMX.yNx.removeAll(localArrayList);
    }
    AppMethodBeat.o(98811);
  }
  
  private void dPT()
  {
    AppMethodBeat.i(98812);
    if ((this.yMT == null) || (this.yMT.isEmpty()))
    {
      this.yMU = "";
      AppMethodBeat.o(98812);
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
    AppMethodBeat.o(98812);
  }
  
  private void fM(List<String[]> paramList)
  {
    AppMethodBeat.i(98810);
    if ((this.yNi == null) || (this.yNi.size() == 0))
    {
      AppMethodBeat.o(98810);
      return;
    }
    Iterator localIterator = this.yNi.iterator();
    paramList = paramList.iterator();
    ArrayList localArrayList1 = new ArrayList(this.yNi.size());
    ArrayList localArrayList2 = new ArrayList(this.yNi.size());
    while (localIterator.hasNext())
    {
      localArrayList1.add(a.cWd().ajA((String)localIterator.next()));
      localArrayList2.add(bs.n(Arrays.asList((Object[])paramList.next()), ","));
      this.yNb = true;
    }
    a.cWd().m(localArrayList1, localArrayList2);
    AppMethodBeat.o(98810);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(98801);
    if (dPM())
    {
      com.tencent.mm.ui.base.h.a(this, true, getString(2131763862), "", getString(2131763861), getString(2131763860), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    dPN();
    AppMethodBeat.o(98801);
  }
  
  final void dPO()
  {
    AppMethodBeat.i(98803);
    Intent localIntent = new Intent();
    if (this.yMX.yNu == 2)
    {
      this.yMU = bs.n(this.yMX.yNw, ",");
      this.yMV = bs.n(this.yMX.yNy, ",");
      this.yMW = bs.n(this.yMX.yNA, ",");
      dPT();
      localIntent.putExtra("Klabel_name_list", this.yMU);
      localIntent.putExtra("Kother_user_name_list", this.yMV);
      localIntent.putExtra("Kchat_room_name_list", this.yMW);
    }
    for (;;)
    {
      localIntent.putExtra("Ktag_range_index", this.yMX.yNu);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(98803);
      return;
      if (this.yMX.yNu == 3)
      {
        this.yMU = bs.n(this.yMX.yNx, ",");
        this.yMV = bs.n(this.yMX.yNz, ",");
        this.yMW = bs.n(this.yMX.yNB, ",");
        dPT();
        localIntent.putExtra("Klabel_name_list", this.yMU);
        localIntent.putExtra("Kother_user_name_list", this.yMV);
        localIntent.putExtra("Kchat_room_name_list", this.yMW);
      }
    }
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
  
  public int getLayoutId()
  {
    return 2131495554;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98798);
    boolean bool = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
    this.yMR = ((AnimatedExpandableListView)findViewById(2131304991));
    this.yMT = ((ArrayList)a.cWd().cVY());
    this.yMX.yNv = bool;
    this.yMX.aB(this.yMT);
    dPS();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    localLayoutParams.height = getResources().getDimensionPixelSize(2131165483);
    View localView = new View(this);
    localView.setLayoutParams(localLayoutParams);
    this.yMR.addHeaderView(localView);
    this.yMR.setAdapter(this.yMX);
    if (this.yMX.yNu == 2) {
      this.yMR.expandGroup(2);
    }
    for (;;)
    {
      this.yMR.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
      {
        public final boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(98788);
          int i = SnsLabelUI.a(SnsLabelUI.this).yNu;
          f.ydE.OD(paramAnonymousInt);
          ac.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt > 1)
          {
            if ((SnsLabelUI.b(SnsLabelUI.this) != null) && (SnsLabelUI.b(SnsLabelUI.this).size() != 0) && (SnsLabelUI.dPU() == 0))
            {
              SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt);
              SnsLabelUI.c(SnsLabelUI.this);
              ac.i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
              AppMethodBeat.o(98788);
              return true;
            }
            if (SnsLabelUI.d(SnsLabelUI.this))
            {
              SnsLabelUI.e(SnsLabelUI.this);
              SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt);
              SnsLabelUI.a(SnsLabelUI.this, com.tencent.mm.ui.base.h.b(SnsLabelUI.this, SnsLabelUI.this.getString(2131763867), false, null));
              ac.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
              AppMethodBeat.o(98788);
              return true;
            }
            if ((SnsLabelUI.a(SnsLabelUI.this).yNt == null) || (SnsLabelUI.a(SnsLabelUI.this).yNt.size() == 0))
            {
              SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt);
              SnsLabelUI.f(SnsLabelUI.this);
              ac.i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
              AppMethodBeat.o(98788);
              return true;
            }
            if (i == paramAnonymousInt)
            {
              if (SnsLabelUI.g(SnsLabelUI.this).isGroupExpanded(paramAnonymousInt)) {
                SnsLabelUI.g(SnsLabelUI.this).acW(paramAnonymousInt);
              }
              for (;;)
              {
                SnsLabelUI.a(SnsLabelUI.this).yNu = paramAnonymousInt;
                AppMethodBeat.o(98788);
                return true;
                SnsLabelUI.g(SnsLabelUI.this).acV(paramAnonymousInt);
              }
            }
            if (i == 2)
            {
              SnsLabelUI.g(SnsLabelUI.this).collapseGroup(2);
              SnsLabelUI.a(SnsLabelUI.this).yNw.clear();
              SnsLabelUI.a(SnsLabelUI.this).yNy.clear();
            }
            for (;;)
            {
              SnsLabelUI.g(SnsLabelUI.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(98787);
                  SnsLabelUI.g(SnsLabelUI.this).acV(paramAnonymousInt);
                  AppMethodBeat.o(98787);
                }
              });
              break;
              if (i == 3)
              {
                SnsLabelUI.g(SnsLabelUI.this).collapseGroup(3);
                SnsLabelUI.a(SnsLabelUI.this).yNx.clear();
                SnsLabelUI.a(SnsLabelUI.this).yNz.clear();
              }
            }
          }
          if (i > 1) {
            SnsLabelUI.g(SnsLabelUI.this).acW(i);
          }
          SnsLabelUI.a(SnsLabelUI.this).yNu = paramAnonymousInt;
          AppMethodBeat.o(98788);
          return false;
        }
      });
      this.yMR.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
      {
        public final boolean onChildClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong)
        {
          AppMethodBeat.i(98789);
          if (paramAnonymousInt2 == ax.yNq)
          {
            SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt1);
            SnsLabelUI.f(SnsLabelUI.this);
            if (paramAnonymousInt2 != ax.yNq) {
              break label208;
            }
            paramAnonymousExpandableListView = f.ydE;
            if (paramAnonymousExpandableListView.ydM != null)
            {
              if (paramAnonymousExpandableListView.ydM.dXS > 0) {
                break label189;
              }
              paramAnonymousExpandableListView.ydM.dXS = 1;
            }
          }
          for (;;)
          {
            AppMethodBeat.o(98789);
            return false;
            if (paramAnonymousInt2 == ax.yNp)
            {
              SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt1);
              SnsLabelUI.h(SnsLabelUI.this);
              break;
            }
            paramAnonymousExpandableListView = (String)SnsLabelUI.a(SnsLabelUI.this).getChild(paramAnonymousInt1, paramAnonymousInt2 - ax.yNr);
            SnsLabelUI.a(SnsLabelUI.this);
            ax.avI(paramAnonymousExpandableListView);
            if (paramAnonymousInt1 == 2)
            {
              SnsLabelUI.a(SnsLabelUI.this, 1, SnsLabelUI.a(SnsLabelUI.this).yNw, paramAnonymousExpandableListView, paramAnonymousView);
              break;
            }
            if (paramAnonymousInt1 != 3) {
              break;
            }
            SnsLabelUI.a(SnsLabelUI.this, 2, SnsLabelUI.a(SnsLabelUI.this).yNx, paramAnonymousExpandableListView, paramAnonymousView);
            break;
            label189:
            paramAnonymousExpandableListView.ydM.dXS += 1;
            continue;
            label208:
            if (paramAnonymousInt2 == ax.yNp)
            {
              paramAnonymousExpandableListView = f.ydE;
              if (paramAnonymousExpandableListView.ydM != null) {
                if (paramAnonymousExpandableListView.ydM.dXN <= 0) {
                  paramAnonymousExpandableListView.ydM.dXN = 1;
                } else {
                  paramAnonymousExpandableListView.ydM.dXN += 1;
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
          String str1 = bs.n(paramAnonymousMenuItem.yMX.yNw, ",");
          String str2 = bs.n(paramAnonymousMenuItem.yMX.yNy, ",");
          String str3 = bs.n(paramAnonymousMenuItem.yMX.yNA, ",");
          String str4 = bs.n(paramAnonymousMenuItem.yMX.yNx, ",");
          String str5 = bs.n(paramAnonymousMenuItem.yMX.yNz, ",");
          String str6 = bs.n(paramAnonymousMenuItem.yMX.yNB, ",");
          if (((paramAnonymousMenuItem.yMX.yNu == 2) && (paramAnonymousMenuItem.yMX.yNw.size() == 0) && (paramAnonymousMenuItem.yMX.yNy.size() == 0) && (paramAnonymousMenuItem.yMX.yNA.size() == 0)) || ((paramAnonymousMenuItem.yMX.yNu == 3) && (paramAnonymousMenuItem.yMX.yNx.size() == 0) && (paramAnonymousMenuItem.yMX.yNz.size() == 0) && (paramAnonymousMenuItem.yMX.yNB.size() == 0))) {
            com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131763868), "", paramAnonymousMenuItem.getString(2131763880), null);
          }
          for (;;)
          {
            AppMethodBeat.o(98791);
            return true;
            if (((paramAnonymousMenuItem.yMX.yNu == 2) && (bs.isNullOrNil(str1)) && (bs.isNullOrNil(str2)) && (bs.isNullOrNil(str3))) || ((paramAnonymousMenuItem.yMX.yNu == 3) && (bs.isNullOrNil(str4)) && (bs.isNullOrNil(str5)) && (bs.isNullOrNil(str6)))) {
              com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131763868), "", paramAnonymousMenuItem.getString(2131763880), null);
            } else {
              paramAnonymousMenuItem.dPO();
            }
          }
        }
      }, null, s.b.Hom);
      AppMethodBeat.o(98798);
      return;
      if (this.yMX.yNu == 3) {
        this.yMR.expandGroup(3);
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
      ac.i("MicroMsg.SnsLabelUI", "the Activity completed");
      localObject = paramIntent.getStringExtra("Select_Contacts_To_Create_New_Label");
      if (!bs.isNullOrNil((String)localObject))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("Select_Contact", (String)localObject);
        d.b(getContext(), "label", ".ui.ContactLabelEditUI", paramIntent, 4002);
        AppMethodBeat.o(98799);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      this.yMV = new String(paramIntent);
      ac.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.yNd == 2)
      {
        this.yMX.yNy.clear();
        if (!bs.isNullOrNil(paramIntent))
        {
          paramIntent = bs.S(paramIntent.split(","));
          this.yMX.yNy.addAll(paramIntent);
          this.yMX.yNu = this.yNd;
        }
      }
      for (;;)
      {
        this.yMX.notifyDataSetChanged();
        this.yMR.expandGroup(this.yNd);
        AppMethodBeat.o(98799);
        return;
        if (this.yNd == 3)
        {
          this.yMX.yNz.clear();
          if (!bs.isNullOrNil(paramIntent))
          {
            paramIntent = bs.S(paramIntent.split(","));
            this.yMX.yNz.addAll(paramIntent);
            this.yMX.yNu = this.yNd;
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
      AppMethodBeat.o(98799);
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
          AppMethodBeat.i(98793);
          SnsLabelUI.a(SnsLabelUI.this, (ArrayList)a.cWd().cVY());
          if (SnsLabelUI.k(SnsLabelUI.this) == null) {
            SnsLabelUI.a(SnsLabelUI.this, new ArrayList());
          }
          if (!bs.isNullOrNil(this.yNo)) {
            if (!SnsLabelUI.k(SnsLabelUI.this).contains(this.yNo)) {
              SnsLabelUI.k(SnsLabelUI.this).add(this.yNo);
            }
          }
          for (int i = SnsLabelUI.k(SnsLabelUI.this).indexOf(this.yNo);; i = -1)
          {
            SnsLabelUI.a(SnsLabelUI.this).aB(SnsLabelUI.k(SnsLabelUI.this));
            SnsLabelUI.l(SnsLabelUI.this);
            SnsLabelUI.a(SnsLabelUI.this).yNu = SnsLabelUI.m(SnsLabelUI.this);
            if ((!bs.isNullOrNil(this.yNo)) && (i != -1))
            {
              if (SnsLabelUI.m(SnsLabelUI.this) != 2) {
                break label246;
              }
              SnsLabelUI.a(SnsLabelUI.this).yNw.add(this.yNo);
              SnsLabelUI.a(SnsLabelUI.this).yNy.clear();
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
                SnsLabelUI.a(SnsLabelUI.this).yNx.add(this.yNo);
                SnsLabelUI.a(SnsLabelUI.this).yNz.clear();
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
      ac.i("MicroMsg.SnsLabelUI", "the Activity completed");
      paramIntent = paramIntent.getStringExtra("select_chatrooms");
      this.yMW = paramIntent;
      ac.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.yNd != 2) {
        break label563;
      }
      this.yMX.yNA.clear();
      if (!bs.isNullOrNil(paramIntent))
      {
        paramIntent = bs.S(paramIntent.split(","));
        this.yMX.yNA.addAll(paramIntent);
        this.yMX.yNu = this.yNd;
      }
    }
    for (;;)
    {
      this.yMX.notifyDataSetChanged();
      this.yMR.expandGroup(this.yNd);
      AppMethodBeat.o(98799);
      return;
      label563:
      if (this.yNd == 3)
      {
        this.yMX.yNB.clear();
        if (!bs.isNullOrNil(paramIntent))
        {
          paramIntent = bs.S(paramIntent.split(","));
          this.yMX.yNB.addAll(paramIntent);
          this.yMX.yNu = this.yNd;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98797);
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
    this.yMX = new ax(this);
    this.yMX.yNC = new ax.b()
    {
      public final void a(ax.c paramAnonymousc)
      {
        AppMethodBeat.i(98784);
        int i = paramAnonymousc.yNH;
        int j = paramAnonymousc.yNI;
        SnsLabelUI.a(SnsLabelUI.this, i, j);
        AppMethodBeat.o(98784);
      }
    };
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      this.yMY = 0;
      this.yMX.style = 0;
      this.yMU = null;
      this.yMV = null;
      this.yMW = null;
      this.yMX.yNu = this.yMY;
      if (this.yMX.style == 1) {
        findViewById(2131304992).setBackgroundResource(2131100017);
      }
      if (this.yMY != 2) {
        break label465;
      }
      if (!TextUtils.isEmpty(this.yMU)) {
        this.yMX.yNw = bs.S(this.yMU.split(","));
      }
      if (!TextUtils.isEmpty(this.yMV)) {
        this.yMX.yNy = bs.S(this.yMV.split(","));
      }
      if ((this.yMW != null) && (!this.yMW.isEmpty())) {
        this.yMX.yNA = bs.S(this.yMW.split(","));
      }
    }
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
      AppMethodBeat.o(98797);
      return;
      this.yMY = paramBundle.getIntExtra("KLabel_range_index", 0);
      this.yMX.style = paramBundle.getIntExtra("k_sns_label_ui_style", 0);
      this.yMU = paramBundle.getStringExtra("Klabel_name_list");
      this.yMV = paramBundle.getStringExtra("Kother_user_name_list");
      this.yMW = paramBundle.getStringExtra("Kchat_room_name_list");
      if (TextUtils.isEmpty(paramBundle.getStringExtra("k_sns_label_ui_title"))) {
        break;
      }
      setMMTitle(paramBundle.getStringExtra("k_sns_label_ui_title"));
      break;
      label465:
      if (this.yMY == 3)
      {
        if (!TextUtils.isEmpty(this.yMU)) {
          this.yMX.yNx = bs.S(this.yMU.split(","));
        }
        if (!TextUtils.isEmpty(this.yMV)) {
          this.yMX.yNz = bs.S(this.yMV.split(","));
        }
        if ((this.yMW != null) && (!this.yMW.isEmpty())) {
          this.yMX.yNB = bs.S(this.yMW.split(","));
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98804);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(292, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(635, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(638, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(290, this);
    super.onDestroy();
    AppMethodBeat.o(98804);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98805);
    if ((this.yMX != null) && (this.yNf == null) && (this.yMR != null)) {
      this.yMR.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98785);
          a.cWd().alK();
          SnsLabelUI.a(SnsLabelUI.this, (ArrayList)a.cWd().cVY());
          SnsLabelUI.a(SnsLabelUI.this).aB(SnsLabelUI.k(SnsLabelUI.this));
          SnsLabelUI.l(SnsLabelUI.this);
          if (((SnsLabelUI.k(SnsLabelUI.this) == null) || (SnsLabelUI.k(SnsLabelUI.this).size() == 0)) && ((SnsLabelUI.q(SnsLabelUI.this) == null) || (SnsLabelUI.q(SnsLabelUI.this).length() == 0)) && (SnsLabelUI.a(SnsLabelUI.this).yNu != 0) && (SnsLabelUI.a(SnsLabelUI.this).yNu != 1) && ((SnsLabelUI.r(SnsLabelUI.this) == null) || (SnsLabelUI.r(SnsLabelUI.this).length() == 0))) {
            SnsLabelUI.a(SnsLabelUI.this).yNu = 0;
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
    ac.i("MicroMsg.SnsLabelUI", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!this.yNb)
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
              paramString = a.cWd().cWa();
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
            break label525;
          }
          paramInt1 = 0;
          if (paramInt1 != 0) {}
        }
        else if (this.yNc)
        {
          this.yMX.yNu = this.yNd;
          if ((this.yMR != null) && (this.yMR.getChildCount() > 0)) {
            this.yMR.acV(this.yNd);
          }
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(335873, Boolean.FALSE);
        }
        ((Cursor)localObject).close();
        if (this.yNa)
        {
          this.yNb = true;
          a.cWd().dX(this.yNi);
        }
      }
      for (;;)
      {
        this.yNc = false;
        AppMethodBeat.o(98806);
        return;
        label525:
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
        AppMethodBeat.o(98806);
        return;
      }
      dPR();
      ac.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
      AppMethodBeat.o(98806);
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
        this.yMT = ((ArrayList)a.cWd().cVY());
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
              AppMethodBeat.i(98786);
              SnsLabelUI.a(SnsLabelUI.this).yNu = SnsLabelUI.m(SnsLabelUI.this);
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
                    ax.avI((String)((Iterator)localObject).next());
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
              SnsLabelUI.a(SnsLabelUI.this).aB(SnsLabelUI.k(SnsLabelUI.this));
              SnsLabelUI.l(SnsLabelUI.this);
              SnsLabelUI.a(SnsLabelUI.this).notifyDataSetChanged();
              SnsLabelUI.g(SnsLabelUI.this).acV(SnsLabelUI.a(SnsLabelUI.this).yNu);
              if ((SnsLabelUI.t(SnsLabelUI.this) != null) && (SnsLabelUI.t(SnsLabelUI.this).isShowing())) {
                SnsLabelUI.t(SnsLabelUI.this).dismiss();
              }
              AppMethodBeat.o(98786);
            }
          }, 600L);
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(335873, Boolean.FALSE);
          AppMethodBeat.o(98806);
          return;
        }
      }
      dPR();
      ac.i("MicroMsg.SnsLabelUI", "dz: error at modify label list!");
      AppMethodBeat.o(98806);
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI
 * JD-Core Version:    0.7.0.1
 */