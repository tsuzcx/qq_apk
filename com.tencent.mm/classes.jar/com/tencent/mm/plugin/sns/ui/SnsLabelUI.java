package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.autogen.mmdata.rpt.pv;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.comm.b.e;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.y;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.ac;
import com.tencent.mm.plugin.sns.storage.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsLabelUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  public static int[] RsD = { b.j.sns_label_public, b.j.sns_label_private, b.j.sns_label_include, b.j.sns_label_exclude };
  private ArrayList<String> JXW;
  private com.tencent.mm.ui.base.w PZK;
  private AnimatedExpandableListView RsC;
  private String RsE;
  private String RsF;
  private String RsG;
  private String RsH;
  bg RsI;
  private int RsJ = 0;
  private boolean RsK = false;
  private boolean RsL;
  private boolean RsM = false;
  private boolean RsN = false;
  private boolean RsO = false;
  private int RsP;
  private String RsQ;
  private ArrayList<String> RsR;
  private int RsS;
  private ArrayList<String> RsT;
  private ArrayList<String> RsU;
  private ArrayList<Long> RsV;
  private ArrayList<String[]> RsW;
  
  private void goBack()
  {
    AppMethodBeat.i(98801);
    if (hoN())
    {
      k.a(this, true, getString(b.j.sns_label_goback_tip), "", getString(b.j.sns_label_goback_save), getString(b.j.sns_label_goback_notsave), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(98794);
          SnsLabelUI.p(SnsLabelUI.this);
          AppMethodBeat.o(98794);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(98795);
          SnsLabelUI.q(SnsLabelUI.this);
          AppMethodBeat.o(98795);
        }
      });
      AppMethodBeat.o(98801);
      return;
    }
    hoO();
    AppMethodBeat.o(98801);
  }
  
  private boolean hoN()
  {
    boolean bool2 = true;
    AppMethodBeat.i(98800);
    int i = this.RsI.Rtg;
    boolean bool1;
    if (this.RsI.Rtg != this.RsJ) {
      if (i == 2)
      {
        bool1 = bool2;
        if (this.RsI.Rti.size() == 0)
        {
          bool1 = bool2;
          if (this.RsI.Rtk.size() != 0) {}
        }
      }
      else
      {
        if (i != 3) {
          break label108;
        }
        bool1 = bool2;
        if (this.RsI.Rtj.size() == 0)
        {
          if (this.RsI.Rtl.size() == 0) {
            break label108;
          }
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(98800);
      return bool1;
      label108:
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
              if ((i == 2) && (this.RsI.Rti.size() != 0))
              {
                bool1 = bool2;
                if (!Util.listToString(this.RsI.Rti, ",").equals(this.RsE)) {
                  break;
                }
                bool1 = bool2;
                if (!Util.listToString(this.RsI.Rtk, ",").equals(this.RsF)) {
                  break;
                }
                bool1 = bool2;
                if (!Util.listToString(this.RsI.Rtm, ",").equals(this.RsG)) {
                  break;
                }
              }
            } while ((i != 3) || (this.RsI.Rtj.size() == 0));
            bool1 = bool2;
            if (!Util.listToString(this.RsI.Rtj, ",").equals(this.RsE)) {
              break;
            }
            bool1 = bool2;
            if (!Util.listToString(this.RsI.Rtl, ",").equals(this.RsF)) {
              break;
            }
          } while (Util.listToString(this.RsI.Rtn, ",").equals(this.RsG));
          bool1 = bool2;
        }
      }
    }
  }
  
  private void hoO()
  {
    AppMethodBeat.i(98802);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ktag_range_index", this.RsJ);
    if ((this.RsJ == 2) || (this.RsJ == 3))
    {
      hoU();
      localIntent.putExtra("Klabel_name_list", this.RsE);
      localIntent.putExtra("Kother_user_name_list", this.RsF);
      localIntent.putExtra("Kchat_room_name_list", this.RsG);
    }
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(98802);
  }
  
  private static int hoQ()
  {
    AppMethodBeat.i(98807);
    com.tencent.mm.kernel.h.baF();
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().d(335874, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(98807);
    return i;
  }
  
  private static void hoR()
  {
    AppMethodBeat.i(98808);
    com.tencent.mm.kernel.h.baF();
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().d(335874, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().B(335874, Integer.valueOf(i + 1));
    AppMethodBeat.o(98808);
  }
  
  private void hoS()
  {
    AppMethodBeat.i(98809);
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
      AppMethodBeat.o(98809);
      return;
    }
    int i = b.j.sns_label_transform_failed_once;
    if (hoQ() > 1) {
      i = b.j.sns_label_transform_failed_again;
    }
    k.a(this, i, b.j.app_ok, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(98809);
  }
  
  private void hoT()
  {
    AppMethodBeat.i(98811);
    if ((this.JXW == null) || (this.JXW.isEmpty()))
    {
      if (this.RsI.Rti != null) {
        this.RsI.Rti.clear();
      }
      if (this.RsI.Rtj != null) {
        this.RsI.Rtj.clear();
      }
      AppMethodBeat.o(98811);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    String str;
    if ((this.RsJ == 2) && (this.RsI.Rti != null))
    {
      localIterator = this.RsI.Rti.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.JXW.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.RsI.Rti.removeAll(localArrayList);
      AppMethodBeat.o(98811);
      return;
    }
    if (this.RsJ == 3)
    {
      localIterator = this.RsI.Rtj.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.JXW.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.RsI.Rtj.removeAll(localArrayList);
    }
    AppMethodBeat.o(98811);
  }
  
  private void hoU()
  {
    AppMethodBeat.i(98812);
    if ((this.JXW == null) || (this.JXW.isEmpty()))
    {
      this.RsE = "";
      AppMethodBeat.o(98812);
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
    AppMethodBeat.o(98812);
  }
  
  private void kN(List<String[]> paramList)
  {
    AppMethodBeat.i(98810);
    if ((this.RsU == null) || (this.RsU.size() == 0))
    {
      AppMethodBeat.o(98810);
      return;
    }
    Iterator localIterator = this.RsU.iterator();
    paramList = paramList.iterator();
    ArrayList localArrayList1 = new ArrayList(this.RsU.size());
    ArrayList localArrayList2 = new ArrayList(this.RsU.size());
    while (localIterator.hasNext())
    {
      localArrayList1.add(a.fTb().aJH((String)localIterator.next()));
      localArrayList2.add(Util.listToString(Arrays.asList((String[])paramList.next()), ","));
      this.RsN = true;
    }
    a.fTb().G(localArrayList1, localArrayList2);
    AppMethodBeat.o(98810);
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
    return b.g.sns_label;
  }
  
  final void hoP()
  {
    AppMethodBeat.i(98803);
    Intent localIntent = new Intent();
    if (this.RsI.Rtg == 2)
    {
      this.RsE = Util.listToString(this.RsI.Rti, ",");
      this.RsF = Util.listToString(this.RsI.Rtk, ",");
      this.RsG = Util.listToString(this.RsI.Rtm, ",");
      this.RsH = Util.listToString(this.RsI.Rto, ",");
      hoU();
      localIntent.putExtra("Klabel_name_list", this.RsE);
      localIntent.putExtra("Kother_user_name_list", this.RsF);
      localIntent.putExtra("Kchat_room_name_list", this.RsG);
      localIntent.putExtra("KNew_label_name_list", this.RsH);
    }
    for (;;)
    {
      localIntent.putExtra("Ktag_range_index", this.RsI.Rtg);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(98803);
      return;
      if (this.RsI.Rtg == 3)
      {
        this.RsE = Util.listToString(this.RsI.Rtj, ",");
        this.RsF = Util.listToString(this.RsI.Rtl, ",");
        this.RsG = Util.listToString(this.RsI.Rtn, ",");
        this.RsH = Util.listToString(this.RsI.Rtp, ",");
        hoU();
        localIntent.putExtra("Klabel_name_list", this.RsE);
        localIntent.putExtra("Kother_user_name_list", this.RsF);
        localIntent.putExtra("Kchat_room_name_list", this.RsG);
        localIntent.putExtra("KNew_label_name_list", this.RsH);
      }
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(98798);
    boolean bool = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
    this.RsC = ((AnimatedExpandableListView)findViewById(b.f.sns_label_exlist));
    this.JXW = ((ArrayList)a.fTb().fSW());
    this.RsI.Rth = bool;
    this.RsI.bF(this.JXW);
    hoT();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    localLayoutParams.height = getResources().getDimensionPixelSize(b.d.LargerPadding);
    View localView = new View(this);
    localView.setLayoutParams(localLayoutParams);
    this.RsC.addHeaderView(localView);
    this.RsC.setAdapter(this.RsI);
    if (this.RsI.Rtg == 2) {
      this.RsC.expandGroup(2);
    }
    for (;;)
    {
      this.RsC.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
      {
        public final boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(98788);
          if ((aj.hga()) && (SnsLabelUI.this.getIntent().getBooleanExtra("Kis_with_together", false)) && (paramAnonymousInt == 1))
          {
            paramAnonymousExpandableListView = new g.a(SnsLabelUI.this);
            paramAnonymousExpandableListView.bDE(SnsLabelUI.this.getString(b.j.sns_withta_not_set_privacy));
            paramAnonymousExpandableListView.aEX(b.j.app_i_know).show();
            AppMethodBeat.o(98788);
            return false;
          }
          int i = SnsLabelUI.a(SnsLabelUI.this).Rtg;
          j.QFS.akX(paramAnonymousInt);
          Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt > 1)
          {
            if ((SnsLabelUI.b(SnsLabelUI.this) != null) && (SnsLabelUI.b(SnsLabelUI.this).size() != 0) && (SnsLabelUI.hoV() == 0))
            {
              SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt);
              SnsLabelUI.c(SnsLabelUI.this);
              Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
              AppMethodBeat.o(98788);
              return true;
            }
            if (SnsLabelUI.d(SnsLabelUI.this))
            {
              SnsLabelUI.e(SnsLabelUI.this);
              SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt);
              SnsLabelUI.a(SnsLabelUI.this, k.a(SnsLabelUI.this, SnsLabelUI.this.getString(b.j.sns_label_is_transforming), false, null));
              Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
              AppMethodBeat.o(98788);
              return true;
            }
            if (i == paramAnonymousInt)
            {
              if (SnsLabelUI.f(SnsLabelUI.this).isGroupExpanded(paramAnonymousInt)) {
                SnsLabelUI.f(SnsLabelUI.this).aFj(paramAnonymousInt);
              }
              for (;;)
              {
                SnsLabelUI.a(SnsLabelUI.this).Rtg = paramAnonymousInt;
                AppMethodBeat.o(98788);
                return true;
                SnsLabelUI.f(SnsLabelUI.this).aFi(paramAnonymousInt);
              }
            }
            if (i == 2)
            {
              SnsLabelUI.f(SnsLabelUI.this).collapseGroup(2);
              SnsLabelUI.a(SnsLabelUI.this).Rti.clear();
              SnsLabelUI.a(SnsLabelUI.this).Rtk.clear();
            }
            for (;;)
            {
              SnsLabelUI.f(SnsLabelUI.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(98787);
                  SnsLabelUI.f(SnsLabelUI.this).aFi(paramAnonymousInt);
                  AppMethodBeat.o(98787);
                }
              });
              break;
              if (i == 3)
              {
                SnsLabelUI.f(SnsLabelUI.this).collapseGroup(3);
                SnsLabelUI.a(SnsLabelUI.this).Rtj.clear();
                SnsLabelUI.a(SnsLabelUI.this).Rtl.clear();
              }
            }
          }
          if (i > 1) {
            SnsLabelUI.f(SnsLabelUI.this).aFj(i);
          }
          SnsLabelUI.a(SnsLabelUI.this).Rtg = paramAnonymousInt;
          AppMethodBeat.o(98788);
          return false;
        }
      });
      this.RsC.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
      {
        public final boolean onChildClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong)
        {
          AppMethodBeat.i(98789);
          if (paramAnonymousInt2 == bg.Rtc)
          {
            SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt1);
            SnsLabelUI.g(SnsLabelUI.this);
            if (paramAnonymousInt2 != bg.Rtc) {
              break label208;
            }
            paramAnonymousExpandableListView = j.QFS;
            if (paramAnonymousExpandableListView.QGd != null)
            {
              if (paramAnonymousExpandableListView.QGd.jpd > 0) {
                break label189;
              }
              paramAnonymousExpandableListView.QGd.jpd = 1;
            }
          }
          for (;;)
          {
            AppMethodBeat.o(98789);
            return true;
            if (paramAnonymousInt2 == bg.Rtb)
            {
              SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt1);
              SnsLabelUI.h(SnsLabelUI.this);
              break;
            }
            paramAnonymousExpandableListView = (String)SnsLabelUI.a(SnsLabelUI.this).getChild(paramAnonymousInt1, paramAnonymousInt2 - bg.Rtd);
            SnsLabelUI.a(SnsLabelUI.this);
            bg.baH(paramAnonymousExpandableListView);
            if (paramAnonymousInt1 == 2)
            {
              SnsLabelUI.a(SnsLabelUI.this, 1, SnsLabelUI.a(SnsLabelUI.this).Rti, paramAnonymousExpandableListView, paramAnonymousView);
              break;
            }
            if (paramAnonymousInt1 != 3) {
              break;
            }
            SnsLabelUI.a(SnsLabelUI.this, 2, SnsLabelUI.a(SnsLabelUI.this).Rtj, paramAnonymousExpandableListView, paramAnonymousView);
            break;
            label189:
            paramAnonymousExpandableListView.QGd.jpd += 1;
            continue;
            label208:
            if (paramAnonymousInt2 == bg.Rtb)
            {
              paramAnonymousExpandableListView = j.QFS;
              if (paramAnonymousExpandableListView.QGd != null) {
                if (paramAnonymousExpandableListView.QGd.joY <= 0) {
                  paramAnonymousExpandableListView.QGd.joY = 1;
                } else {
                  paramAnonymousExpandableListView.QGd.joY += 1;
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
      addTextOptionMenu(0, getString(b.j.sns_label_finish), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(98791);
          paramAnonymousMenuItem = SnsLabelUI.this;
          String str1 = Util.listToString(paramAnonymousMenuItem.RsI.Rti, ",");
          String str2 = Util.listToString(paramAnonymousMenuItem.RsI.Rtk, ",");
          String str3 = Util.listToString(paramAnonymousMenuItem.RsI.Rtm, ",");
          String str4 = Util.listToString(paramAnonymousMenuItem.RsI.Rtj, ",");
          String str5 = Util.listToString(paramAnonymousMenuItem.RsI.Rtl, ",");
          String str6 = Util.listToString(paramAnonymousMenuItem.RsI.Rtn, ",");
          if (((paramAnonymousMenuItem.RsI.Rtg == 2) && (paramAnonymousMenuItem.RsI.Rti.size() == 0) && (paramAnonymousMenuItem.RsI.Rtk.size() == 0) && (paramAnonymousMenuItem.RsI.Rtm.size() == 0)) || ((paramAnonymousMenuItem.RsI.Rtg == 3) && (paramAnonymousMenuItem.RsI.Rtj.size() == 0) && (paramAnonymousMenuItem.RsI.Rtl.size() == 0) && (paramAnonymousMenuItem.RsI.Rtn.size() == 0))) {
            k.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(b.j.sns_label_need_select_one_least), "", paramAnonymousMenuItem.getString(b.j.sns_label_transform_ok), null);
          }
          for (;;)
          {
            AppMethodBeat.o(98791);
            return true;
            if (((paramAnonymousMenuItem.RsI.Rtg == 2) && (Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)) && (Util.isNullOrNil(str3))) || ((paramAnonymousMenuItem.RsI.Rtg == 3) && (Util.isNullOrNil(str4)) && (Util.isNullOrNil(str5)) && (Util.isNullOrNil(str6)))) {
              k.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(b.j.sns_label_need_select_one_least), "", paramAnonymousMenuItem.getString(b.j.sns_label_transform_ok), null);
            } else {
              paramAnonymousMenuItem.hoP();
            }
          }
        }
      }, null, y.b.adEJ);
      AppMethodBeat.o(98798);
      return;
      if (this.RsI.Rtg == 3) {
        this.RsC.expandGroup(3);
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
      Log.i("MicroMsg.SnsLabelUI", "the Activity completed");
      localObject = paramIntent.getStringExtra("Select_Contacts_To_Create_New_Label");
      if (!Util.isNullOrNil((String)localObject))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("Select_Contact", (String)localObject);
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUm, 1) == 1)
        {
          Log.i("MicroMsg.SnsLabelUI", "startActivity ContactEditLabel ");
          com.tencent.mm.br.c.b(getContext(), "label", ".ui.ContactEditLabel", paramIntent, 4002);
          AppMethodBeat.o(98799);
          return;
        }
        Log.i("MicroMsg.SnsLabelUI", "startActivity ContactLabelEditUI ");
        com.tencent.mm.br.c.b(getContext(), "label", ".ui.ContactLabelEditUI", paramIntent, 4002);
        AppMethodBeat.o(98799);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      this.RsF = new String(paramIntent);
      Log.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.RsP == 2)
      {
        this.RsI.Rtk.clear();
        if (!Util.isNullOrNil(paramIntent))
        {
          paramIntent = Util.stringsToList(paramIntent.split(","));
          this.RsI.Rtk.addAll(paramIntent);
          this.RsI.Rtg = this.RsP;
        }
      }
      for (;;)
      {
        this.RsI.notifyDataSetChanged();
        this.RsC.expandGroup(this.RsP);
        AppMethodBeat.o(98799);
        return;
        if (this.RsP == 3)
        {
          this.RsI.Rtl.clear();
          if (!Util.isNullOrNil(paramIntent))
          {
            paramIntent = Util.stringsToList(paramIntent.split(","));
            this.RsI.Rtl.addAll(paramIntent);
            this.RsI.Rtg = this.RsP;
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
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUm, 1) == 1)
        {
          Log.i("MicroMsg.SnsLabelUI", "startActivity ContactEditLabel ");
          com.tencent.mm.br.c.b(getContext(), "label", ".ui.ContactEditLabel", (Intent)localObject, 4002);
          AppMethodBeat.o(98799);
          return;
        }
        Log.i("MicroMsg.SnsLabelUI", "startActivity ContactLabelEditUI ");
        com.tencent.mm.br.c.b(getContext(), "label", ".ui.ContactLabelEditUI", (Intent)localObject, 4002);
      }
      AppMethodBeat.o(98799);
      return;
    }
    if ((paramInt2 == 0) && (paramInt1 == 4002) && (paramIntent != null))
    {
      localObject = paramIntent.getStringExtra("k_sns_label_add_label");
      this.RsQ = paramIntent.getStringExtra("k_sns_label_add_label");
      this.RsR = paramIntent.getStringArrayListExtra("k_sns_label_add_label_usernames");
      this.RsC.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98793);
          SnsLabelUI.a(SnsLabelUI.this, (ArrayList)a.fTb().fSW());
          if (SnsLabelUI.k(SnsLabelUI.this) == null) {
            SnsLabelUI.a(SnsLabelUI.this, new ArrayList());
          }
          if (!Util.isNullOrNil(this.Rta)) {
            if (!SnsLabelUI.k(SnsLabelUI.this).contains(this.Rta)) {
              SnsLabelUI.k(SnsLabelUI.this).add(this.Rta);
            }
          }
          for (int i = SnsLabelUI.k(SnsLabelUI.this).indexOf(this.Rta);; i = -1)
          {
            SnsLabelUI.a(SnsLabelUI.this).bF(SnsLabelUI.k(SnsLabelUI.this));
            SnsLabelUI.l(SnsLabelUI.this);
            SnsLabelUI.a(SnsLabelUI.this).Rtg = SnsLabelUI.m(SnsLabelUI.this);
            if ((!Util.isNullOrNil(this.Rta)) && (i != -1))
            {
              if (SnsLabelUI.m(SnsLabelUI.this) != 2) {
                break label270;
              }
              SnsLabelUI.a(SnsLabelUI.this).Rti.add(this.Rta);
              SnsLabelUI.a(SnsLabelUI.this).Rto = new ArrayList(SnsLabelUI.n(SnsLabelUI.this));
              SnsLabelUI.a(SnsLabelUI.this).Rtk.clear();
            }
            for (;;)
            {
              SnsLabelUI.a(SnsLabelUI.this).notifyDataSetChanged();
              SnsLabelUI.f(SnsLabelUI.this).expandGroup(SnsLabelUI.m(SnsLabelUI.this));
              SnsLabelUI.o(SnsLabelUI.this);
              AppMethodBeat.o(98793);
              return;
              label270:
              if (SnsLabelUI.m(SnsLabelUI.this) == 3)
              {
                SnsLabelUI.a(SnsLabelUI.this).Rtj.add(this.Rta);
                SnsLabelUI.a(SnsLabelUI.this).Rtp = new ArrayList(SnsLabelUI.n(SnsLabelUI.this));
                SnsLabelUI.a(SnsLabelUI.this).Rtl.clear();
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
      Log.i("MicroMsg.SnsLabelUI", "the Activity completed");
      paramIntent = paramIntent.getStringExtra("select_chatrooms");
      this.RsG = paramIntent;
      Log.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.RsP != 2) {
        break label690;
      }
      this.RsI.Rtm.clear();
      if (!Util.isNullOrNil(paramIntent))
      {
        paramIntent = Util.stringsToList(paramIntent.split(","));
        this.RsI.Rtm.addAll(paramIntent);
        this.RsI.Rtg = this.RsP;
      }
    }
    for (;;)
    {
      this.RsI.notifyDataSetChanged();
      this.RsC.expandGroup(this.RsP);
      AppMethodBeat.o(98799);
      return;
      label690:
      if (this.RsP == 3)
      {
        this.RsI.Rtn.clear();
        if (!Util.isNullOrNil(paramIntent))
        {
          paramIntent = Util.stringsToList(paramIntent.split(","));
          this.RsI.Rtn.addAll(paramIntent);
          this.RsI.Rtg = this.RsP;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98797);
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
    this.RsI = new bg(this);
    this.RsI.Rtq = new bg.b()
    {
      public final void a(bg.c paramAnonymousc)
      {
        AppMethodBeat.i(98784);
        int i = paramAnonymousc.Rtv;
        int j = paramAnonymousc.Rtw;
        SnsLabelUI.a(SnsLabelUI.this, i, j);
        AppMethodBeat.o(98784);
      }
    };
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      this.RsJ = 0;
      this.RsI.style = 0;
      this.RsE = null;
      this.RsF = null;
      this.RsG = null;
      this.RsI.Rtg = this.RsJ;
      this.RsI.RsK = this.RsK;
      if (this.RsI.style == 1) {
        findViewById(b.f.sns_label_layout).setBackgroundResource(b.c.black);
      }
      if (this.RsJ != 2) {
        break label491;
      }
      if (!TextUtils.isEmpty(this.RsE)) {
        this.RsI.Rti = Util.stringsToList(this.RsE.split(","));
      }
      if (!TextUtils.isEmpty(this.RsF)) {
        this.RsI.Rtk = Util.stringsToList(this.RsF.split(","));
      }
      if ((this.RsG != null) && (!this.RsG.isEmpty())) {
        this.RsI.Rtm = Util.stringsToList(this.RsG.split(","));
      }
    }
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
      AppMethodBeat.o(98797);
      return;
      this.RsK = paramBundle.getBooleanExtra("Kis_from_text_status", false);
      this.RsJ = paramBundle.getIntExtra("KLabel_range_index", 0);
      this.RsI.style = paramBundle.getIntExtra("k_sns_label_ui_style", 0);
      this.RsE = paramBundle.getStringExtra("Klabel_name_list");
      this.RsF = paramBundle.getStringExtra("Kother_user_name_list");
      this.RsG = paramBundle.getStringExtra("Kchat_room_name_list");
      if (TextUtils.isEmpty(paramBundle.getStringExtra("k_sns_label_ui_title"))) {
        break;
      }
      setMMTitle(paramBundle.getStringExtra("k_sns_label_ui_title"));
      break;
      label491:
      if (this.RsJ == 3)
      {
        if (!TextUtils.isEmpty(this.RsE)) {
          this.RsI.Rtj = Util.stringsToList(this.RsE.split(","));
        }
        if (!TextUtils.isEmpty(this.RsF)) {
          this.RsI.Rtl = Util.stringsToList(this.RsF.split(","));
        }
        if ((this.RsG != null) && (!this.RsG.isEmpty())) {
          this.RsI.Rtn = Util.stringsToList(this.RsG.split(","));
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98804);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(292, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(635, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(638, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(290, this);
    super.onDestroy();
    e.xfd.a("SnsPublishProcess", "privacyPageStaytime_", Long.valueOf(getActivityBrowseTimeMs()), com.tencent.mm.plugin.comm.b.c.xeT);
    AppMethodBeat.o(98804);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98805);
    if ((this.RsI != null) && (this.RsQ == null) && (this.RsC != null)) {
      this.RsC.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98785);
          a.fTb().bja();
          SnsLabelUI.a(SnsLabelUI.this, (ArrayList)a.fTb().fSW());
          SnsLabelUI.a(SnsLabelUI.this).bF(SnsLabelUI.k(SnsLabelUI.this));
          SnsLabelUI.l(SnsLabelUI.this);
          if (((SnsLabelUI.k(SnsLabelUI.this) == null) || (SnsLabelUI.k(SnsLabelUI.this).size() == 0)) && ((SnsLabelUI.r(SnsLabelUI.this) == null) || (SnsLabelUI.r(SnsLabelUI.this).length() == 0)) && (SnsLabelUI.a(SnsLabelUI.this).Rtg != 0) && (SnsLabelUI.a(SnsLabelUI.this).Rtg != 1) && ((SnsLabelUI.s(SnsLabelUI.this) == null) || (SnsLabelUI.s(SnsLabelUI.this).length() == 0))) {
            SnsLabelUI.a(SnsLabelUI.this).Rtg = 0;
          }
          SnsLabelUI.a(SnsLabelUI.this).notifyDataSetChanged();
          SnsLabelUI.o(SnsLabelUI.this);
          AppMethodBeat.o(98785);
        }
      }, 600L);
    }
    super.onResume();
    AppMethodBeat.o(98805);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(98806);
    Log.i("MicroMsg.SnsLabelUI", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!this.RsN)
    {
      AppMethodBeat.o(98806);
      return;
    }
    switch (paramp.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(98806);
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
              paramString = a.fTb().fSY();
              if (paramString == null)
              {
                paramString = paramp;
                label294:
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
                break label294;
              }
              paramString = String.format(getString(b.j.sns_label_from_tag_suffix), new Object[] { paramp });
              break label294;
              Log.e("MicroMsg.SnsLabelUI", "dz:snstaginfo memberlist is null.");
            }
          }
          ((Cursor)localObject).close();
          if (this.RsT.size() != 0) {
            break label521;
          }
          paramInt1 = 0;
          if (paramInt1 != 0) {}
        }
        else if (this.RsO)
        {
          this.RsI.Rtg = this.RsP;
          if ((this.RsC != null) && (this.RsC.getChildCount() > 0)) {
            this.RsC.aFi(this.RsP);
          }
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().B(335873, Boolean.FALSE);
        }
        ((Cursor)localObject).close();
        if (this.RsM)
        {
          this.RsN = true;
          a.fTb().iE(this.RsU);
        }
      }
      for (;;)
      {
        this.RsO = false;
        AppMethodBeat.o(98806);
        return;
        label521:
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
        AppMethodBeat.o(98806);
        return;
      }
      hoS();
      Log.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
      AppMethodBeat.o(98806);
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
        this.JXW = ((ArrayList)a.fTb().fSW());
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
              AppMethodBeat.i(98786);
              SnsLabelUI.a(SnsLabelUI.this).Rtg = SnsLabelUI.m(SnsLabelUI.this);
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
                    bg.baH((String)((Iterator)localObject).next());
                  }
                  SnsLabelUI.k(SnsLabelUI.this).addAll(SnsLabelUI.b(SnsLabelUI.this));
                }
                Object localObject = new HashSet(SnsLabelUI.k(SnsLabelUI.this));
                SnsLabelUI.k(SnsLabelUI.this).clear();
                SnsLabelUI.k(SnsLabelUI.this).addAll((Collection)localObject);
                SnsLabelUI.b(SnsLabelUI.this).clear();
                SnsLabelUI.t(SnsLabelUI.this);
                ((HashSet)localObject).clear();
              }
              SnsLabelUI.a(SnsLabelUI.this).bF(SnsLabelUI.k(SnsLabelUI.this));
              SnsLabelUI.l(SnsLabelUI.this);
              SnsLabelUI.a(SnsLabelUI.this).notifyDataSetChanged();
              SnsLabelUI.f(SnsLabelUI.this).aFi(SnsLabelUI.a(SnsLabelUI.this).Rtg);
              if ((SnsLabelUI.u(SnsLabelUI.this) != null) && (SnsLabelUI.u(SnsLabelUI.this).isShowing())) {
                SnsLabelUI.u(SnsLabelUI.this).dismiss();
              }
              AppMethodBeat.o(98786);
            }
          }, 600L);
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().B(335873, Boolean.FALSE);
          AppMethodBeat.o(98806);
          return;
        }
      }
      hoS();
      Log.i("MicroMsg.SnsLabelUI", "dz: error at modify label list!");
      AppMethodBeat.o(98806);
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI
 * JD-Core Version:    0.7.0.1
 */