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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.b.a.gl;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
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
  public static int[] Aeo = { 2131763871, 2131763869, 2131763865, 2131763856 };
  private p AeA;
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
  private String Aes;
  ba Aet;
  private int Aeu = 0;
  private boolean Aev;
  private boolean Aew = false;
  private boolean Aex = false;
  private boolean Aey = false;
  private int Aez;
  
  private boolean ecd()
  {
    boolean bool2 = true;
    AppMethodBeat.i(98800);
    int i = this.Aet.AeQ;
    boolean bool1;
    if (this.Aet.AeQ != this.Aeu) {
      if (i == 2)
      {
        bool1 = bool2;
        if (this.Aet.AeS.size() == 0)
        {
          bool1 = bool2;
          if (this.Aet.AeU.size() != 0) {}
        }
      }
      else
      {
        if (i != 3) {
          break label106;
        }
        bool1 = bool2;
        if (this.Aet.AeT.size() == 0)
        {
          if (this.Aet.AeV.size() == 0) {
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
              if ((i == 2) && (this.Aet.AeS.size() != 0))
              {
                bool1 = bool2;
                if (!bt.m(this.Aet.AeS, ",").equals(this.Aeq)) {
                  break;
                }
                bool1 = bool2;
                if (!bt.m(this.Aet.AeU, ",").equals(this.Aer)) {
                  break;
                }
                bool1 = bool2;
                if (!bt.m(this.Aet.AeW, ",").equals(this.Aes)) {
                  break;
                }
              }
            } while ((i != 3) || (this.Aet.AeT.size() == 0));
            bool1 = bool2;
            if (!bt.m(this.Aet.AeT, ",").equals(this.Aeq)) {
              break;
            }
            bool1 = bool2;
            if (!bt.m(this.Aet.AeV, ",").equals(this.Aer)) {
              break;
            }
          } while (bt.m(this.Aet.AeX, ",").equals(this.Aes));
          bool1 = bool2;
        }
      }
    }
  }
  
  private void ece()
  {
    AppMethodBeat.i(98802);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ktag_range_index", this.Aeu);
    if ((this.Aeu == 2) || (this.Aeu == 3))
    {
      eck();
      localIntent.putExtra("Klabel_name_list", this.Aeq);
      localIntent.putExtra("Kother_user_name_list", this.Aer);
      localIntent.putExtra("Kchat_room_name_list", this.Aes);
    }
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(98802);
  }
  
  private static int ecg()
  {
    AppMethodBeat.i(98807);
    com.tencent.mm.kernel.g.ajD();
    int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(335874, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(98807);
    return i;
  }
  
  private static void ech()
  {
    AppMethodBeat.i(98808);
    com.tencent.mm.kernel.g.ajD();
    int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(335874, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajC().ajl().set(335874, Integer.valueOf(i + 1));
    AppMethodBeat.o(98808);
  }
  
  private void eci()
  {
    AppMethodBeat.i(98809);
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
      AppMethodBeat.o(98809);
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
    AppMethodBeat.o(98809);
  }
  
  private void ecj()
  {
    AppMethodBeat.i(98811);
    if ((this.Aep == null) || (this.Aep.isEmpty()))
    {
      if (this.Aet.AeS != null) {
        this.Aet.AeS.clear();
      }
      if (this.Aet.AeT != null) {
        this.Aet.AeT.clear();
      }
      AppMethodBeat.o(98811);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    String str;
    if ((this.Aeu == 2) && (this.Aet.AeS != null))
    {
      localIterator = this.Aet.AeS.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.Aep.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.Aet.AeS.removeAll(localArrayList);
      AppMethodBeat.o(98811);
      return;
    }
    if (this.Aeu == 3)
    {
      localIterator = this.Aet.AeT.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.Aep.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.Aet.AeT.removeAll(localArrayList);
    }
    AppMethodBeat.o(98811);
  }
  
  private void eck()
  {
    AppMethodBeat.i(98812);
    if ((this.Aep == null) || (this.Aep.isEmpty()))
    {
      this.Aeq = "";
      AppMethodBeat.o(98812);
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
    AppMethodBeat.o(98812);
  }
  
  private void fX(List<String[]> paramList)
  {
    AppMethodBeat.i(98810);
    if ((this.AeE == null) || (this.AeE.size() == 0))
    {
      AppMethodBeat.o(98810);
      return;
    }
    Iterator localIterator = this.AeE.iterator();
    paramList = paramList.iterator();
    ArrayList localArrayList1 = new ArrayList(this.AeE.size());
    ArrayList localArrayList2 = new ArrayList(this.AeE.size());
    while (localIterator.hasNext())
    {
      localArrayList1.add(a.dfo().aom((String)localIterator.next()));
      localArrayList2.add(bt.m(Arrays.asList((Object[])paramList.next()), ","));
      this.Aex = true;
    }
    a.dfo().n(localArrayList1, localArrayList2);
    AppMethodBeat.o(98810);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(98801);
    if (ecd())
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
    ece();
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
  
  final void ecf()
  {
    AppMethodBeat.i(98803);
    Intent localIntent = new Intent();
    if (this.Aet.AeQ == 2)
    {
      this.Aeq = bt.m(this.Aet.AeS, ",");
      this.Aer = bt.m(this.Aet.AeU, ",");
      this.Aes = bt.m(this.Aet.AeW, ",");
      eck();
      localIntent.putExtra("Klabel_name_list", this.Aeq);
      localIntent.putExtra("Kother_user_name_list", this.Aer);
      localIntent.putExtra("Kchat_room_name_list", this.Aes);
    }
    for (;;)
    {
      localIntent.putExtra("Ktag_range_index", this.Aet.AeQ);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(98803);
      return;
      if (this.Aet.AeQ == 3)
      {
        this.Aeq = bt.m(this.Aet.AeT, ",");
        this.Aer = bt.m(this.Aet.AeV, ",");
        this.Aes = bt.m(this.Aet.AeX, ",");
        eck();
        localIntent.putExtra("Klabel_name_list", this.Aeq);
        localIntent.putExtra("Kother_user_name_list", this.Aer);
        localIntent.putExtra("Kchat_room_name_list", this.Aes);
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
    this.Aen = ((AnimatedExpandableListView)findViewById(2131304991));
    this.Aep = ((ArrayList)a.dfo().dfj());
    this.Aet.AeR = bool;
    this.Aet.az(this.Aep);
    ecj();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    localLayoutParams.height = getResources().getDimensionPixelSize(2131165483);
    View localView = new View(this);
    localView.setLayoutParams(localLayoutParams);
    this.Aen.addHeaderView(localView);
    this.Aen.setAdapter(this.Aet);
    if (this.Aet.AeQ == 2) {
      this.Aen.expandGroup(2);
    }
    for (;;)
    {
      this.Aen.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
      {
        public final boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(98788);
          int i = SnsLabelUI.a(SnsLabelUI.this).AeQ;
          com.tencent.mm.plugin.sns.j.e.ztz.Ql(paramAnonymousInt);
          ad.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt > 1)
          {
            if ((SnsLabelUI.b(SnsLabelUI.this) != null) && (SnsLabelUI.b(SnsLabelUI.this).size() != 0) && (SnsLabelUI.ecl() == 0))
            {
              SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt);
              SnsLabelUI.c(SnsLabelUI.this);
              ad.i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
              AppMethodBeat.o(98788);
              return true;
            }
            if (SnsLabelUI.d(SnsLabelUI.this))
            {
              SnsLabelUI.e(SnsLabelUI.this);
              SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt);
              SnsLabelUI.a(SnsLabelUI.this, h.b(SnsLabelUI.this, SnsLabelUI.this.getString(2131763867), false, null));
              ad.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
              AppMethodBeat.o(98788);
              return true;
            }
            if ((SnsLabelUI.a(SnsLabelUI.this).AeP == null) || (SnsLabelUI.a(SnsLabelUI.this).AeP.size() == 0))
            {
              SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt);
              SnsLabelUI.f(SnsLabelUI.this);
              ad.i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
              AppMethodBeat.o(98788);
              return true;
            }
            if (i == paramAnonymousInt)
            {
              if (SnsLabelUI.g(SnsLabelUI.this).isGroupExpanded(paramAnonymousInt)) {
                SnsLabelUI.g(SnsLabelUI.this).afx(paramAnonymousInt);
              }
              for (;;)
              {
                SnsLabelUI.a(SnsLabelUI.this).AeQ = paramAnonymousInt;
                AppMethodBeat.o(98788);
                return true;
                SnsLabelUI.g(SnsLabelUI.this).afw(paramAnonymousInt);
              }
            }
            if (i == 2)
            {
              SnsLabelUI.g(SnsLabelUI.this).collapseGroup(2);
              SnsLabelUI.a(SnsLabelUI.this).AeS.clear();
              SnsLabelUI.a(SnsLabelUI.this).AeU.clear();
            }
            for (;;)
            {
              SnsLabelUI.g(SnsLabelUI.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(98787);
                  SnsLabelUI.g(SnsLabelUI.this).afw(paramAnonymousInt);
                  AppMethodBeat.o(98787);
                }
              });
              break;
              if (i == 3)
              {
                SnsLabelUI.g(SnsLabelUI.this).collapseGroup(3);
                SnsLabelUI.a(SnsLabelUI.this).AeT.clear();
                SnsLabelUI.a(SnsLabelUI.this).AeV.clear();
              }
            }
          }
          if (i > 1) {
            SnsLabelUI.g(SnsLabelUI.this).afx(i);
          }
          SnsLabelUI.a(SnsLabelUI.this).AeQ = paramAnonymousInt;
          AppMethodBeat.o(98788);
          return false;
        }
      });
      this.Aen.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
      {
        public final boolean onChildClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong)
        {
          AppMethodBeat.i(98789);
          if (paramAnonymousInt2 == ba.AeM)
          {
            SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt1);
            SnsLabelUI.f(SnsLabelUI.this);
            if (paramAnonymousInt2 != ba.AeM) {
              break label208;
            }
            paramAnonymousExpandableListView = com.tencent.mm.plugin.sns.j.e.ztz;
            if (paramAnonymousExpandableListView.ztH != null)
            {
              if (paramAnonymousExpandableListView.ztH.eoj > 0) {
                break label189;
              }
              paramAnonymousExpandableListView.ztH.eoj = 1;
            }
          }
          for (;;)
          {
            AppMethodBeat.o(98789);
            return false;
            if (paramAnonymousInt2 == ba.AeL)
            {
              SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt1);
              SnsLabelUI.h(SnsLabelUI.this);
              break;
            }
            paramAnonymousExpandableListView = (String)SnsLabelUI.a(SnsLabelUI.this).getChild(paramAnonymousInt1, paramAnonymousInt2 - ba.AeN);
            SnsLabelUI.a(SnsLabelUI.this);
            ba.aAP(paramAnonymousExpandableListView);
            if (paramAnonymousInt1 == 2)
            {
              SnsLabelUI.a(SnsLabelUI.this, 1, SnsLabelUI.a(SnsLabelUI.this).AeS, paramAnonymousExpandableListView, paramAnonymousView);
              break;
            }
            if (paramAnonymousInt1 != 3) {
              break;
            }
            SnsLabelUI.a(SnsLabelUI.this, 2, SnsLabelUI.a(SnsLabelUI.this).AeT, paramAnonymousExpandableListView, paramAnonymousView);
            break;
            label189:
            paramAnonymousExpandableListView.ztH.eoj += 1;
            continue;
            label208:
            if (paramAnonymousInt2 == ba.AeL)
            {
              paramAnonymousExpandableListView = com.tencent.mm.plugin.sns.j.e.ztz;
              if (paramAnonymousExpandableListView.ztH != null) {
                if (paramAnonymousExpandableListView.ztH.eod <= 0) {
                  paramAnonymousExpandableListView.ztH.eod = 1;
                } else {
                  paramAnonymousExpandableListView.ztH.eod += 1;
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
          String str1 = bt.m(paramAnonymousMenuItem.Aet.AeS, ",");
          String str2 = bt.m(paramAnonymousMenuItem.Aet.AeU, ",");
          String str3 = bt.m(paramAnonymousMenuItem.Aet.AeW, ",");
          String str4 = bt.m(paramAnonymousMenuItem.Aet.AeT, ",");
          String str5 = bt.m(paramAnonymousMenuItem.Aet.AeV, ",");
          String str6 = bt.m(paramAnonymousMenuItem.Aet.AeX, ",");
          if (((paramAnonymousMenuItem.Aet.AeQ == 2) && (paramAnonymousMenuItem.Aet.AeS.size() == 0) && (paramAnonymousMenuItem.Aet.AeU.size() == 0) && (paramAnonymousMenuItem.Aet.AeW.size() == 0)) || ((paramAnonymousMenuItem.Aet.AeQ == 3) && (paramAnonymousMenuItem.Aet.AeT.size() == 0) && (paramAnonymousMenuItem.Aet.AeV.size() == 0) && (paramAnonymousMenuItem.Aet.AeX.size() == 0))) {
            h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131763868), "", paramAnonymousMenuItem.getString(2131763880), null);
          }
          for (;;)
          {
            AppMethodBeat.o(98791);
            return true;
            if (((paramAnonymousMenuItem.Aet.AeQ == 2) && (bt.isNullOrNil(str1)) && (bt.isNullOrNil(str2)) && (bt.isNullOrNil(str3))) || ((paramAnonymousMenuItem.Aet.AeQ == 3) && (bt.isNullOrNil(str4)) && (bt.isNullOrNil(str5)) && (bt.isNullOrNil(str6)))) {
              h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131763868), "", paramAnonymousMenuItem.getString(2131763880), null);
            } else {
              paramAnonymousMenuItem.ecf();
            }
          }
        }
      }, null, s.b.JbS);
      AppMethodBeat.o(98798);
      return;
      if (this.Aet.AeQ == 3) {
        this.Aen.expandGroup(3);
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
      ad.i("MicroMsg.SnsLabelUI", "the Activity completed");
      localObject = paramIntent.getStringExtra("Select_Contacts_To_Create_New_Label");
      if (!bt.isNullOrNil((String)localObject))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("Select_Contact", (String)localObject);
        d.b(getContext(), "label", ".ui.ContactLabelEditUI", paramIntent, 4002);
        AppMethodBeat.o(98799);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      this.Aer = new String(paramIntent);
      ad.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.Aez == 2)
      {
        this.Aet.AeU.clear();
        if (!bt.isNullOrNil(paramIntent))
        {
          paramIntent = bt.U(paramIntent.split(","));
          this.Aet.AeU.addAll(paramIntent);
          this.Aet.AeQ = this.Aez;
        }
      }
      for (;;)
      {
        this.Aet.notifyDataSetChanged();
        this.Aen.expandGroup(this.Aez);
        AppMethodBeat.o(98799);
        return;
        if (this.Aez == 3)
        {
          this.Aet.AeV.clear();
          if (!bt.isNullOrNil(paramIntent))
          {
            paramIntent = bt.U(paramIntent.split(","));
            this.Aet.AeV.addAll(paramIntent);
            this.Aet.AeQ = this.Aez;
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
      AppMethodBeat.o(98799);
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
          AppMethodBeat.i(98793);
          SnsLabelUI.a(SnsLabelUI.this, (ArrayList)a.dfo().dfj());
          if (SnsLabelUI.k(SnsLabelUI.this) == null) {
            SnsLabelUI.a(SnsLabelUI.this, new ArrayList());
          }
          if (!bt.isNullOrNil(this.AeK)) {
            if (!SnsLabelUI.k(SnsLabelUI.this).contains(this.AeK)) {
              SnsLabelUI.k(SnsLabelUI.this).add(this.AeK);
            }
          }
          for (int i = SnsLabelUI.k(SnsLabelUI.this).indexOf(this.AeK);; i = -1)
          {
            SnsLabelUI.a(SnsLabelUI.this).az(SnsLabelUI.k(SnsLabelUI.this));
            SnsLabelUI.l(SnsLabelUI.this);
            SnsLabelUI.a(SnsLabelUI.this).AeQ = SnsLabelUI.m(SnsLabelUI.this);
            if ((!bt.isNullOrNil(this.AeK)) && (i != -1))
            {
              if (SnsLabelUI.m(SnsLabelUI.this) != 2) {
                break label246;
              }
              SnsLabelUI.a(SnsLabelUI.this).AeS.add(this.AeK);
              SnsLabelUI.a(SnsLabelUI.this).AeU.clear();
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
                SnsLabelUI.a(SnsLabelUI.this).AeT.add(this.AeK);
                SnsLabelUI.a(SnsLabelUI.this).AeV.clear();
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
      ad.i("MicroMsg.SnsLabelUI", "the Activity completed");
      paramIntent = paramIntent.getStringExtra("select_chatrooms");
      this.Aes = paramIntent;
      ad.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.Aez != 2) {
        break label563;
      }
      this.Aet.AeW.clear();
      if (!bt.isNullOrNil(paramIntent))
      {
        paramIntent = bt.U(paramIntent.split(","));
        this.Aet.AeW.addAll(paramIntent);
        this.Aet.AeQ = this.Aez;
      }
    }
    for (;;)
    {
      this.Aet.notifyDataSetChanged();
      this.Aen.expandGroup(this.Aez);
      AppMethodBeat.o(98799);
      return;
      label563:
      if (this.Aez == 3)
      {
        this.Aet.AeX.clear();
        if (!bt.isNullOrNil(paramIntent))
        {
          paramIntent = bt.U(paramIntent.split(","));
          this.Aet.AeX.addAll(paramIntent);
          this.Aet.AeQ = this.Aez;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98797);
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
    this.Aet = new ba(this);
    this.Aet.AeY = new ba.b()
    {
      public final void a(ba.c paramAnonymousc)
      {
        AppMethodBeat.i(98784);
        int i = paramAnonymousc.Afd;
        int j = paramAnonymousc.Afe;
        SnsLabelUI.a(SnsLabelUI.this, i, j);
        AppMethodBeat.o(98784);
      }
    };
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      this.Aeu = 0;
      this.Aet.style = 0;
      this.Aeq = null;
      this.Aer = null;
      this.Aes = null;
      this.Aet.AeQ = this.Aeu;
      if (this.Aet.style == 1) {
        findViewById(2131304992).setBackgroundResource(2131100017);
      }
      if (this.Aeu != 2) {
        break label465;
      }
      if (!TextUtils.isEmpty(this.Aeq)) {
        this.Aet.AeS = bt.U(this.Aeq.split(","));
      }
      if (!TextUtils.isEmpty(this.Aer)) {
        this.Aet.AeU = bt.U(this.Aer.split(","));
      }
      if ((this.Aes != null) && (!this.Aes.isEmpty())) {
        this.Aet.AeW = bt.U(this.Aes.split(","));
      }
    }
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
      AppMethodBeat.o(98797);
      return;
      this.Aeu = paramBundle.getIntExtra("KLabel_range_index", 0);
      this.Aet.style = paramBundle.getIntExtra("k_sns_label_ui_style", 0);
      this.Aeq = paramBundle.getStringExtra("Klabel_name_list");
      this.Aer = paramBundle.getStringExtra("Kother_user_name_list");
      this.Aes = paramBundle.getStringExtra("Kchat_room_name_list");
      if (TextUtils.isEmpty(paramBundle.getStringExtra("k_sns_label_ui_title"))) {
        break;
      }
      setMMTitle(paramBundle.getStringExtra("k_sns_label_ui_title"));
      break;
      label465:
      if (this.Aeu == 3)
      {
        if (!TextUtils.isEmpty(this.Aeq)) {
          this.Aet.AeT = bt.U(this.Aeq.split(","));
        }
        if (!TextUtils.isEmpty(this.Aer)) {
          this.Aet.AeV = bt.U(this.Aer.split(","));
        }
        if ((this.Aes != null) && (!this.Aes.isEmpty())) {
          this.Aet.AeX = bt.U(this.Aes.split(","));
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98804);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(292, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(635, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(638, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(290, this);
    super.onDestroy();
    AppMethodBeat.o(98804);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98805);
    if ((this.Aet != null) && (this.AeB == null) && (this.Aen != null)) {
      this.Aen.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98785);
          a.dfo().aox();
          SnsLabelUI.a(SnsLabelUI.this, (ArrayList)a.dfo().dfj());
          SnsLabelUI.a(SnsLabelUI.this).az(SnsLabelUI.k(SnsLabelUI.this));
          SnsLabelUI.l(SnsLabelUI.this);
          if (((SnsLabelUI.k(SnsLabelUI.this) == null) || (SnsLabelUI.k(SnsLabelUI.this).size() == 0)) && ((SnsLabelUI.q(SnsLabelUI.this) == null) || (SnsLabelUI.q(SnsLabelUI.this).length() == 0)) && (SnsLabelUI.a(SnsLabelUI.this).AeQ != 0) && (SnsLabelUI.a(SnsLabelUI.this).AeQ != 1) && ((SnsLabelUI.r(SnsLabelUI.this) == null) || (SnsLabelUI.r(SnsLabelUI.this).length() == 0))) {
            SnsLabelUI.a(SnsLabelUI.this).AeQ = 0;
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
    ad.i("MicroMsg.SnsLabelUI", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!this.Aex)
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
              paramString = a.dfo().dfl();
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
            break label525;
          }
          paramInt1 = 0;
          if (paramInt1 != 0) {}
        }
        else if (this.Aey)
        {
          this.Aet.AeQ = this.Aez;
          if ((this.Aen != null) && (this.Aen.getChildCount() > 0)) {
            this.Aen.afw(this.Aez);
          }
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(335873, Boolean.FALSE);
        }
        ((Cursor)localObject).close();
        if (this.Aew)
        {
          this.Aex = true;
          a.dfo().ek(this.AeE);
        }
      }
      for (;;)
      {
        this.Aey = false;
        AppMethodBeat.o(98806);
        return;
        label525:
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
        AppMethodBeat.o(98806);
        return;
      }
      eci();
      ad.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
      AppMethodBeat.o(98806);
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
        this.Aep = ((ArrayList)a.dfo().dfj());
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
              AppMethodBeat.i(98786);
              SnsLabelUI.a(SnsLabelUI.this).AeQ = SnsLabelUI.m(SnsLabelUI.this);
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
                    ba.aAP((String)((Iterator)localObject).next());
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
              SnsLabelUI.a(SnsLabelUI.this).az(SnsLabelUI.k(SnsLabelUI.this));
              SnsLabelUI.l(SnsLabelUI.this);
              SnsLabelUI.a(SnsLabelUI.this).notifyDataSetChanged();
              SnsLabelUI.g(SnsLabelUI.this).afw(SnsLabelUI.a(SnsLabelUI.this).AeQ);
              if ((SnsLabelUI.t(SnsLabelUI.this) != null) && (SnsLabelUI.t(SnsLabelUI.this).isShowing())) {
                SnsLabelUI.t(SnsLabelUI.this).dismiss();
              }
              AppMethodBeat.o(98786);
            }
          }, 600L);
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(335873, Boolean.FALSE);
          AppMethodBeat.o(98806);
          return;
        }
      }
      eci();
      ad.i("MicroMsg.SnsLabelUI", "dz: error at modify label list!");
      AppMethodBeat.o(98806);
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI
 * JD-Core Version:    0.7.0.1
 */