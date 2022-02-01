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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.b.a.mt;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.k.g;
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

public class SnsLabelUI
  extends MMActivity
  implements i
{
  public static int[] KSE = { i.j.sns_label_public, i.j.sns_label_private, i.j.sns_label_include, i.j.sns_label_exclude };
  private com.tencent.mm.ui.base.s JII;
  private AnimatedExpandableListView KSD;
  private ArrayList<String> KSF;
  private String KSG;
  private String KSH;
  private String KSI;
  private String KSJ;
  bf KSK;
  private int KSL = 0;
  private boolean KSM = false;
  private boolean KSN;
  private boolean KSO = false;
  private boolean KSP = false;
  private boolean KSQ = false;
  private int KSR;
  private String KSS;
  private ArrayList<String> KST;
  private int KSU;
  private ArrayList<String> KSV;
  private ArrayList<String> KSW;
  private ArrayList<Long> KSX;
  private ArrayList<String[]> KSY;
  
  private static void fWA()
  {
    AppMethodBeat.i(98808);
    com.tencent.mm.kernel.h.aHH();
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(335874, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().aHp().i(335874, Integer.valueOf(i + 1));
    AppMethodBeat.o(98808);
  }
  
  private void fWB()
  {
    AppMethodBeat.i(98809);
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
      AppMethodBeat.o(98809);
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
    AppMethodBeat.o(98809);
  }
  
  private void fWC()
  {
    AppMethodBeat.i(98811);
    if ((this.KSF == null) || (this.KSF.isEmpty()))
    {
      if (this.KSK.KTk != null) {
        this.KSK.KTk.clear();
      }
      if (this.KSK.KTl != null) {
        this.KSK.KTl.clear();
      }
      AppMethodBeat.o(98811);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    String str;
    if ((this.KSL == 2) && (this.KSK.KTk != null))
    {
      localIterator = this.KSK.KTk.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.KSF.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.KSK.KTk.removeAll(localArrayList);
      AppMethodBeat.o(98811);
      return;
    }
    if (this.KSL == 3)
    {
      localIterator = this.KSK.KTl.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.KSF.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.KSK.KTl.removeAll(localArrayList);
    }
    AppMethodBeat.o(98811);
  }
  
  private void fWD()
  {
    AppMethodBeat.i(98812);
    if ((this.KSF == null) || (this.KSF.isEmpty()))
    {
      this.KSG = "";
      AppMethodBeat.o(98812);
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
    AppMethodBeat.o(98812);
  }
  
  private boolean fWw()
  {
    boolean bool2 = true;
    AppMethodBeat.i(98800);
    int i = this.KSK.KTi;
    boolean bool1;
    if (this.KSK.KTi != this.KSL) {
      if (i == 2)
      {
        bool1 = bool2;
        if (this.KSK.KTk.size() == 0)
        {
          bool1 = bool2;
          if (this.KSK.KTm.size() != 0) {}
        }
      }
      else
      {
        if (i != 3) {
          break label108;
        }
        bool1 = bool2;
        if (this.KSK.KTl.size() == 0)
        {
          if (this.KSK.KTn.size() == 0) {
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
              if ((i == 2) && (this.KSK.KTk.size() != 0))
              {
                bool1 = bool2;
                if (!Util.listToString(this.KSK.KTk, ",").equals(this.KSG)) {
                  break;
                }
                bool1 = bool2;
                if (!Util.listToString(this.KSK.KTm, ",").equals(this.KSH)) {
                  break;
                }
                bool1 = bool2;
                if (!Util.listToString(this.KSK.KTp, ",").equals(this.KSI)) {
                  break;
                }
              }
            } while ((i != 3) || (this.KSK.KTl.size() == 0));
            bool1 = bool2;
            if (!Util.listToString(this.KSK.KTl, ",").equals(this.KSG)) {
              break;
            }
            bool1 = bool2;
            if (!Util.listToString(this.KSK.KTn, ",").equals(this.KSH)) {
              break;
            }
          } while (Util.listToString(this.KSK.KTq, ",").equals(this.KSI));
          bool1 = bool2;
        }
      }
    }
  }
  
  private void fWx()
  {
    AppMethodBeat.i(98802);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ktag_range_index", this.KSL);
    if ((this.KSL == 2) || (this.KSL == 3))
    {
      fWD();
      localIntent.putExtra("Klabel_name_list", this.KSG);
      localIntent.putExtra("Kother_user_name_list", this.KSH);
      localIntent.putExtra("Kchat_room_name_list", this.KSI);
    }
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(98802);
  }
  
  private static int fWz()
  {
    AppMethodBeat.i(98807);
    com.tencent.mm.kernel.h.aHH();
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(335874, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(98807);
    return i;
  }
  
  private void goBack()
  {
    AppMethodBeat.i(98801);
    if (fWw())
    {
      com.tencent.mm.ui.base.h.a(this, true, getString(i.j.sns_label_goback_tip), "", getString(i.j.sns_label_goback_save), getString(i.j.sns_label_goback_notsave), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    fWx();
    AppMethodBeat.o(98801);
  }
  
  private void hM(List<String[]> paramList)
  {
    AppMethodBeat.i(98810);
    if ((this.KSW == null) || (this.KSW.size() == 0))
    {
      AppMethodBeat.o(98810);
      return;
    }
    Iterator localIterator = this.KSW.iterator();
    paramList = paramList.iterator();
    ArrayList localArrayList1 = new ArrayList(this.KSW.size());
    ArrayList localArrayList2 = new ArrayList(this.KSW.size());
    while (localIterator.hasNext())
    {
      localArrayList1.add(a.eLe().aMO((String)localIterator.next()));
      localArrayList2.add(Util.listToString(Arrays.asList((Object[])paramList.next()), ","));
      this.KSP = true;
    }
    a.eLe().s(localArrayList1, localArrayList2);
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
  
  final void fWy()
  {
    AppMethodBeat.i(98803);
    Intent localIntent = new Intent();
    if (this.KSK.KTi == 2)
    {
      this.KSG = Util.listToString(this.KSK.KTk, ",");
      this.KSH = Util.listToString(this.KSK.KTm, ",");
      this.KSI = Util.listToString(this.KSK.KTp, ",");
      this.KSJ = Util.listToString(this.KSK.KTr, ",");
      fWD();
      localIntent.putExtra("Klabel_name_list", this.KSG);
      localIntent.putExtra("Kother_user_name_list", this.KSH);
      localIntent.putExtra("Kchat_room_name_list", this.KSI);
      localIntent.putExtra("KNew_label_name_list", this.KSJ);
    }
    for (;;)
    {
      localIntent.putExtra("Ktag_range_index", this.KSK.KTi);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(98803);
      return;
      if (this.KSK.KTi == 3)
      {
        this.KSG = Util.listToString(this.KSK.KTl, ",");
        this.KSH = Util.listToString(this.KSK.KTn, ",");
        this.KSI = Util.listToString(this.KSK.KTq, ",");
        this.KSJ = Util.listToString(this.KSK.KTs, ",");
        fWD();
        localIntent.putExtra("Klabel_name_list", this.KSG);
        localIntent.putExtra("Kother_user_name_list", this.KSH);
        localIntent.putExtra("Kchat_room_name_list", this.KSI);
        localIntent.putExtra("KNew_label_name_list", this.KSJ);
      }
    }
  }
  
  public int getLayoutId()
  {
    return i.g.sns_label;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98798);
    boolean bool = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
    this.KSD = ((AnimatedExpandableListView)findViewById(i.f.sns_label_exlist));
    this.KSF = ((ArrayList)a.eLe().eKZ());
    this.KSK.KTj = bool;
    this.KSK.bf(this.KSF);
    fWC();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    localLayoutParams.height = getResources().getDimensionPixelSize(i.d.LargerPadding);
    View localView = new View(this);
    localView.setLayoutParams(localLayoutParams);
    this.KSD.addHeaderView(localView);
    this.KSD.setAdapter(this.KSK);
    if (this.KSK.KTi == 2) {
      this.KSD.expandGroup(2);
    }
    for (;;)
    {
      this.KSD.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
      {
        public final boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(98788);
          int i = SnsLabelUI.a(SnsLabelUI.this).KTi;
          g.Kia.agg(paramAnonymousInt);
          Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt > 1)
          {
            if ((SnsLabelUI.b(SnsLabelUI.this) != null) && (SnsLabelUI.b(SnsLabelUI.this).size() != 0) && (SnsLabelUI.fWE() == 0))
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
              SnsLabelUI.a(SnsLabelUI.this, com.tencent.mm.ui.base.h.a(SnsLabelUI.this, SnsLabelUI.this.getString(i.j.sns_label_is_transforming), false, null));
              Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
              AppMethodBeat.o(98788);
              return true;
            }
            if ((SnsLabelUI.a(SnsLabelUI.this).KTh == null) || (SnsLabelUI.a(SnsLabelUI.this).KTh.size() == 0))
            {
              SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt);
              SnsLabelUI.f(SnsLabelUI.this);
              Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
              AppMethodBeat.o(98788);
              return true;
            }
            if (i == paramAnonymousInt)
            {
              if (SnsLabelUI.g(SnsLabelUI.this).isGroupExpanded(paramAnonymousInt)) {
                SnsLabelUI.g(SnsLabelUI.this).ayz(paramAnonymousInt);
              }
              for (;;)
              {
                SnsLabelUI.a(SnsLabelUI.this).KTi = paramAnonymousInt;
                AppMethodBeat.o(98788);
                return true;
                SnsLabelUI.g(SnsLabelUI.this).ayy(paramAnonymousInt);
              }
            }
            if (i == 2)
            {
              SnsLabelUI.g(SnsLabelUI.this).collapseGroup(2);
              SnsLabelUI.a(SnsLabelUI.this).KTk.clear();
              SnsLabelUI.a(SnsLabelUI.this).KTm.clear();
            }
            for (;;)
            {
              SnsLabelUI.g(SnsLabelUI.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(98787);
                  SnsLabelUI.g(SnsLabelUI.this).ayy(paramAnonymousInt);
                  AppMethodBeat.o(98787);
                }
              });
              break;
              if (i == 3)
              {
                SnsLabelUI.g(SnsLabelUI.this).collapseGroup(3);
                SnsLabelUI.a(SnsLabelUI.this).KTl.clear();
                SnsLabelUI.a(SnsLabelUI.this).KTn.clear();
              }
            }
          }
          if (i > 1) {
            SnsLabelUI.g(SnsLabelUI.this).ayz(i);
          }
          SnsLabelUI.a(SnsLabelUI.this).KTi = paramAnonymousInt;
          AppMethodBeat.o(98788);
          return false;
        }
      });
      this.KSD.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
      {
        public final boolean onChildClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong)
        {
          AppMethodBeat.i(98789);
          if (paramAnonymousInt2 == bf.KTe)
          {
            SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt1);
            SnsLabelUI.f(SnsLabelUI.this);
            if (paramAnonymousInt2 != bf.KTe) {
              break label208;
            }
            paramAnonymousExpandableListView = g.Kia;
            if (paramAnonymousExpandableListView.Kik != null)
            {
              if (paramAnonymousExpandableListView.Kik.gVH > 0) {
                break label189;
              }
              paramAnonymousExpandableListView.Kik.gVH = 1;
            }
          }
          for (;;)
          {
            AppMethodBeat.o(98789);
            return false;
            if (paramAnonymousInt2 == bf.KTd)
            {
              SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt1);
              SnsLabelUI.h(SnsLabelUI.this);
              break;
            }
            paramAnonymousExpandableListView = (String)SnsLabelUI.a(SnsLabelUI.this).getChild(paramAnonymousInt1, paramAnonymousInt2 - bf.KTf);
            SnsLabelUI.a(SnsLabelUI.this);
            bf.bcc(paramAnonymousExpandableListView);
            if (paramAnonymousInt1 == 2)
            {
              SnsLabelUI.a(SnsLabelUI.this, 1, SnsLabelUI.a(SnsLabelUI.this).KTk, paramAnonymousExpandableListView, paramAnonymousView);
              break;
            }
            if (paramAnonymousInt1 != 3) {
              break;
            }
            SnsLabelUI.a(SnsLabelUI.this, 2, SnsLabelUI.a(SnsLabelUI.this).KTl, paramAnonymousExpandableListView, paramAnonymousView);
            break;
            label189:
            paramAnonymousExpandableListView.Kik.gVH += 1;
            continue;
            label208:
            if (paramAnonymousInt2 == bf.KTd)
            {
              paramAnonymousExpandableListView = g.Kia;
              if (paramAnonymousExpandableListView.Kik != null) {
                if (paramAnonymousExpandableListView.Kik.gVC <= 0) {
                  paramAnonymousExpandableListView.Kik.gVC = 1;
                } else {
                  paramAnonymousExpandableListView.Kik.gVC += 1;
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
      addTextOptionMenu(0, getString(i.j.sns_label_finish), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(98791);
          paramAnonymousMenuItem = SnsLabelUI.this;
          String str1 = Util.listToString(paramAnonymousMenuItem.KSK.KTk, ",");
          String str2 = Util.listToString(paramAnonymousMenuItem.KSK.KTm, ",");
          String str3 = Util.listToString(paramAnonymousMenuItem.KSK.KTp, ",");
          String str4 = Util.listToString(paramAnonymousMenuItem.KSK.KTl, ",");
          String str5 = Util.listToString(paramAnonymousMenuItem.KSK.KTn, ",");
          String str6 = Util.listToString(paramAnonymousMenuItem.KSK.KTq, ",");
          if (((paramAnonymousMenuItem.KSK.KTi == 2) && (paramAnonymousMenuItem.KSK.KTk.size() == 0) && (paramAnonymousMenuItem.KSK.KTm.size() == 0) && (paramAnonymousMenuItem.KSK.KTp.size() == 0)) || ((paramAnonymousMenuItem.KSK.KTi == 3) && (paramAnonymousMenuItem.KSK.KTl.size() == 0) && (paramAnonymousMenuItem.KSK.KTn.size() == 0) && (paramAnonymousMenuItem.KSK.KTq.size() == 0))) {
            com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(i.j.sns_label_need_select_one_least), "", paramAnonymousMenuItem.getString(i.j.sns_label_transform_ok), null);
          }
          for (;;)
          {
            AppMethodBeat.o(98791);
            return true;
            if (((paramAnonymousMenuItem.KSK.KTi == 2) && (Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)) && (Util.isNullOrNil(str3))) || ((paramAnonymousMenuItem.KSK.KTi == 3) && (Util.isNullOrNil(str4)) && (Util.isNullOrNil(str5)) && (Util.isNullOrNil(str6)))) {
              com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(i.j.sns_label_need_select_one_least), "", paramAnonymousMenuItem.getString(i.j.sns_label_transform_ok), null);
            } else {
              paramAnonymousMenuItem.fWy();
            }
          }
        }
      }, null, w.b.Wao);
      AppMethodBeat.o(98798);
      return;
      if (this.KSK.KTi == 3) {
        this.KSD.expandGroup(3);
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
        com.tencent.mm.by.c.b(getContext(), "label", ".ui.ContactLabelEditUI", paramIntent, 4002);
        AppMethodBeat.o(98799);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      this.KSH = new String(paramIntent);
      Log.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.KSR == 2)
      {
        this.KSK.KTm.clear();
        if (!Util.isNullOrNil(paramIntent))
        {
          paramIntent = Util.stringsToList(paramIntent.split(","));
          this.KSK.KTm.addAll(paramIntent);
          this.KSK.KTi = this.KSR;
        }
      }
      for (;;)
      {
        this.KSK.notifyDataSetChanged();
        this.KSD.expandGroup(this.KSR);
        AppMethodBeat.o(98799);
        return;
        if (this.KSR == 3)
        {
          this.KSK.KTn.clear();
          if (!Util.isNullOrNil(paramIntent))
          {
            paramIntent = Util.stringsToList(paramIntent.split(","));
            this.KSK.KTn.addAll(paramIntent);
            this.KSK.KTi = this.KSR;
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
      AppMethodBeat.o(98799);
      return;
    }
    if ((paramInt2 == 0) && (paramInt1 == 4002) && (paramIntent != null))
    {
      localObject = paramIntent.getStringExtra("k_sns_label_add_label");
      this.KSS = paramIntent.getStringExtra("k_sns_label_add_label");
      this.KST = paramIntent.getStringArrayListExtra("k_sns_label_add_label_usernames");
      this.KSD.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98793);
          SnsLabelUI.a(SnsLabelUI.this, (ArrayList)a.eLe().eKZ());
          if (SnsLabelUI.k(SnsLabelUI.this) == null) {
            SnsLabelUI.a(SnsLabelUI.this, new ArrayList());
          }
          if (!Util.isNullOrNil(this.KTc)) {
            if (!SnsLabelUI.k(SnsLabelUI.this).contains(this.KTc)) {
              SnsLabelUI.k(SnsLabelUI.this).add(this.KTc);
            }
          }
          for (int i = SnsLabelUI.k(SnsLabelUI.this).indexOf(this.KTc);; i = -1)
          {
            SnsLabelUI.a(SnsLabelUI.this).bf(SnsLabelUI.k(SnsLabelUI.this));
            SnsLabelUI.l(SnsLabelUI.this);
            SnsLabelUI.a(SnsLabelUI.this).KTi = SnsLabelUI.m(SnsLabelUI.this);
            if ((!Util.isNullOrNil(this.KTc)) && (i != -1))
            {
              if (SnsLabelUI.m(SnsLabelUI.this) != 2) {
                break label270;
              }
              SnsLabelUI.a(SnsLabelUI.this).KTk.add(this.KTc);
              SnsLabelUI.a(SnsLabelUI.this).KTr = new ArrayList(SnsLabelUI.n(SnsLabelUI.this));
              SnsLabelUI.a(SnsLabelUI.this).KTm.clear();
            }
            for (;;)
            {
              SnsLabelUI.a(SnsLabelUI.this).notifyDataSetChanged();
              SnsLabelUI.g(SnsLabelUI.this).expandGroup(SnsLabelUI.m(SnsLabelUI.this));
              SnsLabelUI.o(SnsLabelUI.this);
              AppMethodBeat.o(98793);
              return;
              label270:
              if (SnsLabelUI.m(SnsLabelUI.this) == 3)
              {
                SnsLabelUI.a(SnsLabelUI.this).KTl.add(this.KTc);
                SnsLabelUI.a(SnsLabelUI.this).KTs = new ArrayList(SnsLabelUI.n(SnsLabelUI.this));
                SnsLabelUI.a(SnsLabelUI.this).KTn.clear();
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
      this.KSI = paramIntent;
      Log.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.KSR != 2) {
        break label577;
      }
      this.KSK.KTp.clear();
      if (!Util.isNullOrNil(paramIntent))
      {
        paramIntent = Util.stringsToList(paramIntent.split(","));
        this.KSK.KTp.addAll(paramIntent);
        this.KSK.KTi = this.KSR;
      }
    }
    for (;;)
    {
      this.KSK.notifyDataSetChanged();
      this.KSD.expandGroup(this.KSR);
      AppMethodBeat.o(98799);
      return;
      label577:
      if (this.KSR == 3)
      {
        this.KSK.KTq.clear();
        if (!Util.isNullOrNil(paramIntent))
        {
          paramIntent = Util.stringsToList(paramIntent.split(","));
          this.KSK.KTq.addAll(paramIntent);
          this.KSK.KTi = this.KSR;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98797);
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
    this.KSK = new bf(this);
    this.KSK.KTt = new bf.b()
    {
      public final void a(bf.c paramAnonymousc)
      {
        AppMethodBeat.i(98784);
        int i = paramAnonymousc.KTy;
        int j = paramAnonymousc.KTz;
        SnsLabelUI.a(SnsLabelUI.this, i, j);
        AppMethodBeat.o(98784);
      }
    };
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      this.KSL = 0;
      this.KSK.style = 0;
      this.KSG = null;
      this.KSH = null;
      this.KSI = null;
      this.KSK.KTi = this.KSL;
      this.KSK.KSM = this.KSM;
      if (this.KSK.style == 1) {
        findViewById(i.f.sns_label_layout).setBackgroundResource(i.c.black);
      }
      if (this.KSL != 2) {
        break label491;
      }
      if (!TextUtils.isEmpty(this.KSG)) {
        this.KSK.KTk = Util.stringsToList(this.KSG.split(","));
      }
      if (!TextUtils.isEmpty(this.KSH)) {
        this.KSK.KTm = Util.stringsToList(this.KSH.split(","));
      }
      if ((this.KSI != null) && (!this.KSI.isEmpty())) {
        this.KSK.KTp = Util.stringsToList(this.KSI.split(","));
      }
    }
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
      AppMethodBeat.o(98797);
      return;
      this.KSM = paramBundle.getBooleanExtra("Kis_from_text_status", false);
      this.KSL = paramBundle.getIntExtra("KLabel_range_index", 0);
      this.KSK.style = paramBundle.getIntExtra("k_sns_label_ui_style", 0);
      this.KSG = paramBundle.getStringExtra("Klabel_name_list");
      this.KSH = paramBundle.getStringExtra("Kother_user_name_list");
      this.KSI = paramBundle.getStringExtra("Kchat_room_name_list");
      if (TextUtils.isEmpty(paramBundle.getStringExtra("k_sns_label_ui_title"))) {
        break;
      }
      setMMTitle(paramBundle.getStringExtra("k_sns_label_ui_title"));
      break;
      label491:
      if (this.KSL == 3)
      {
        if (!TextUtils.isEmpty(this.KSG)) {
          this.KSK.KTl = Util.stringsToList(this.KSG.split(","));
        }
        if (!TextUtils.isEmpty(this.KSH)) {
          this.KSK.KTn = Util.stringsToList(this.KSH.split(","));
        }
        if ((this.KSI != null) && (!this.KSI.isEmpty())) {
          this.KSK.KTq = Util.stringsToList(this.KSI.split(","));
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98804);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(292, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(635, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(638, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(290, this);
    super.onDestroy();
    AppMethodBeat.o(98804);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98805);
    if ((this.KSK != null) && (this.KSS == null) && (this.KSD != null)) {
      this.KSD.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98785);
          a.eLe().aPn();
          SnsLabelUI.a(SnsLabelUI.this, (ArrayList)a.eLe().eKZ());
          SnsLabelUI.a(SnsLabelUI.this).bf(SnsLabelUI.k(SnsLabelUI.this));
          SnsLabelUI.l(SnsLabelUI.this);
          if (((SnsLabelUI.k(SnsLabelUI.this) == null) || (SnsLabelUI.k(SnsLabelUI.this).size() == 0)) && ((SnsLabelUI.r(SnsLabelUI.this) == null) || (SnsLabelUI.r(SnsLabelUI.this).length() == 0)) && (SnsLabelUI.a(SnsLabelUI.this).KTi != 0) && (SnsLabelUI.a(SnsLabelUI.this).KTi != 1) && ((SnsLabelUI.s(SnsLabelUI.this) == null) || (SnsLabelUI.s(SnsLabelUI.this).length() == 0))) {
            SnsLabelUI.a(SnsLabelUI.this).KTi = 0;
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(98806);
    Log.i("MicroMsg.SnsLabelUI", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!this.KSP)
    {
      AppMethodBeat.o(98806);
      return;
    }
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(98806);
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
              paramString = a.eLe().eLb();
              if (paramString == null)
              {
                paramString = paramq;
                label298:
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
                break label298;
              }
              paramString = String.format(getString(i.j.sns_label_from_tag_suffix), new Object[] { paramq });
              break label298;
              Log.e("MicroMsg.SnsLabelUI", "dz:snstaginfo memberlist is null.");
            }
          }
          ((Cursor)localObject).close();
          if (this.KSV.size() != 0) {
            break label526;
          }
          paramInt1 = 0;
          if (paramInt1 != 0) {}
        }
        else if (this.KSQ)
        {
          this.KSK.KTi = this.KSR;
          if ((this.KSD != null) && (this.KSD.getChildCount() > 0)) {
            this.KSD.ayy(this.KSR);
          }
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().i(335873, Boolean.FALSE);
        }
        ((Cursor)localObject).close();
        if (this.KSO)
        {
          this.KSP = true;
          a.eLe().fH(this.KSW);
        }
      }
      for (;;)
      {
        this.KSQ = false;
        AppMethodBeat.o(98806);
        return;
        label526:
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
        AppMethodBeat.o(98806);
        return;
      }
      fWB();
      Log.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
      AppMethodBeat.o(98806);
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
        this.KSF = ((ArrayList)a.eLe().eKZ());
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
              AppMethodBeat.i(98786);
              SnsLabelUI.a(SnsLabelUI.this).KTi = SnsLabelUI.m(SnsLabelUI.this);
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
                    bf.bcc((String)((Iterator)localObject).next());
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
              SnsLabelUI.a(SnsLabelUI.this).bf(SnsLabelUI.k(SnsLabelUI.this));
              SnsLabelUI.l(SnsLabelUI.this);
              SnsLabelUI.a(SnsLabelUI.this).notifyDataSetChanged();
              SnsLabelUI.g(SnsLabelUI.this).ayy(SnsLabelUI.a(SnsLabelUI.this).KTi);
              if ((SnsLabelUI.u(SnsLabelUI.this) != null) && (SnsLabelUI.u(SnsLabelUI.this).isShowing())) {
                SnsLabelUI.u(SnsLabelUI.this).dismiss();
              }
              AppMethodBeat.o(98786);
            }
          }, 600L);
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().i(335873, Boolean.FALSE);
          AppMethodBeat.o(98806);
          return;
        }
      }
      fWB();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI
 * JD-Core Version:    0.7.0.1
 */