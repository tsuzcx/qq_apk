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
import com.tencent.mm.ak.i;
import com.tencent.mm.br.c;
import com.tencent.mm.g.b.a.kb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.label.a.a;
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

public class SnsLabelUI
  extends MMActivity
  implements i
{
  public static int[] EEO = { 2131766098, 2131766096, 2131766092, 2131766083 };
  private AnimatedExpandableListView EEN;
  private ArrayList<String> EEP;
  private String EEQ;
  private String EER;
  private String EES;
  bd EET;
  private int EEU = 0;
  private boolean EEV = false;
  private boolean EEW;
  private boolean EEX = false;
  private boolean EEY = false;
  private boolean EEZ = false;
  private int EFa;
  private com.tencent.mm.ui.base.q EFb;
  private String EFc;
  private int EFd;
  private ArrayList<String> EFe;
  private ArrayList<String> EFf;
  private ArrayList<Long> EFg;
  private ArrayList<String[]> EFh;
  
  private boolean fik()
  {
    boolean bool2 = true;
    AppMethodBeat.i(98800);
    int i = this.EET.EFr;
    boolean bool1;
    if (this.EET.EFr != this.EEU) {
      if (i == 2)
      {
        bool1 = bool2;
        if (this.EET.EFt.size() == 0)
        {
          bool1 = bool2;
          if (this.EET.EFv.size() != 0) {}
        }
      }
      else
      {
        if (i != 3) {
          break label108;
        }
        bool1 = bool2;
        if (this.EET.EFu.size() == 0)
        {
          if (this.EET.EFw.size() == 0) {
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
              if ((i == 2) && (this.EET.EFt.size() != 0))
              {
                bool1 = bool2;
                if (!Util.listToString(this.EET.EFt, ",").equals(this.EEQ)) {
                  break;
                }
                bool1 = bool2;
                if (!Util.listToString(this.EET.EFv, ",").equals(this.EER)) {
                  break;
                }
                bool1 = bool2;
                if (!Util.listToString(this.EET.EFx, ",").equals(this.EES)) {
                  break;
                }
              }
            } while ((i != 3) || (this.EET.EFu.size() == 0));
            bool1 = bool2;
            if (!Util.listToString(this.EET.EFu, ",").equals(this.EEQ)) {
              break;
            }
            bool1 = bool2;
            if (!Util.listToString(this.EET.EFw, ",").equals(this.EER)) {
              break;
            }
          } while (Util.listToString(this.EET.EFy, ",").equals(this.EES));
          bool1 = bool2;
        }
      }
    }
  }
  
  private void fil()
  {
    AppMethodBeat.i(98802);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ktag_range_index", this.EEU);
    if ((this.EEU == 2) || (this.EEU == 3))
    {
      fir();
      localIntent.putExtra("Klabel_name_list", this.EEQ);
      localIntent.putExtra("Kother_user_name_list", this.EER);
      localIntent.putExtra("Kchat_room_name_list", this.EES);
    }
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(98802);
  }
  
  private static int fin()
  {
    AppMethodBeat.i(98807);
    g.aAi();
    int i = ((Integer)g.aAh().azQ().get(335874, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(98807);
    return i;
  }
  
  private static void fio()
  {
    AppMethodBeat.i(98808);
    g.aAi();
    int i = ((Integer)g.aAh().azQ().get(335874, Integer.valueOf(0))).intValue();
    g.aAi();
    g.aAh().azQ().set(335874, Integer.valueOf(i + 1));
    AppMethodBeat.o(98808);
  }
  
  private void fip()
  {
    AppMethodBeat.i(98809);
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
      AppMethodBeat.o(98809);
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
    AppMethodBeat.o(98809);
  }
  
  private void fiq()
  {
    AppMethodBeat.i(98811);
    if ((this.EEP == null) || (this.EEP.isEmpty()))
    {
      if (this.EET.EFt != null) {
        this.EET.EFt.clear();
      }
      if (this.EET.EFu != null) {
        this.EET.EFu.clear();
      }
      AppMethodBeat.o(98811);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    String str;
    if ((this.EEU == 2) && (this.EET.EFt != null))
    {
      localIterator = this.EET.EFt.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.EEP.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.EET.EFt.removeAll(localArrayList);
      AppMethodBeat.o(98811);
      return;
    }
    if (this.EEU == 3)
    {
      localIterator = this.EET.EFu.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.EEP.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.EET.EFu.removeAll(localArrayList);
    }
    AppMethodBeat.o(98811);
  }
  
  private void fir()
  {
    AppMethodBeat.i(98812);
    if ((this.EEP == null) || (this.EEP.isEmpty()))
    {
      this.EEQ = "";
      AppMethodBeat.o(98812);
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
    AppMethodBeat.o(98812);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(98801);
    if (fik())
    {
      com.tencent.mm.ui.base.h.a(this, true, getString(2131766089), "", getString(2131766088), getString(2131766087), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    fil();
    AppMethodBeat.o(98801);
  }
  
  private void hd(List<String[]> paramList)
  {
    AppMethodBeat.i(98810);
    if ((this.EFf == null) || (this.EFf.size() == 0))
    {
      AppMethodBeat.o(98810);
      return;
    }
    Iterator localIterator = this.EFf.iterator();
    paramList = paramList.iterator();
    ArrayList localArrayList1 = new ArrayList(this.EFf.size());
    ArrayList localArrayList2 = new ArrayList(this.EFf.size());
    while (localIterator.hasNext())
    {
      localArrayList1.add(a.ecg().aCH((String)localIterator.next()));
      localArrayList2.add(Util.listToString(Arrays.asList((Object[])paramList.next()), ","));
      this.EEY = true;
    }
    a.ecg().p(localArrayList1, localArrayList2);
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
  
  final void fim()
  {
    AppMethodBeat.i(98803);
    Intent localIntent = new Intent();
    if (this.EET.EFr == 2)
    {
      this.EEQ = Util.listToString(this.EET.EFt, ",");
      this.EER = Util.listToString(this.EET.EFv, ",");
      this.EES = Util.listToString(this.EET.EFx, ",");
      fir();
      localIntent.putExtra("Klabel_name_list", this.EEQ);
      localIntent.putExtra("Kother_user_name_list", this.EER);
      localIntent.putExtra("Kchat_room_name_list", this.EES);
    }
    for (;;)
    {
      localIntent.putExtra("Ktag_range_index", this.EET.EFr);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(98803);
      return;
      if (this.EET.EFr == 3)
      {
        this.EEQ = Util.listToString(this.EET.EFu, ",");
        this.EER = Util.listToString(this.EET.EFw, ",");
        this.EES = Util.listToString(this.EET.EFy, ",");
        fir();
        localIntent.putExtra("Klabel_name_list", this.EEQ);
        localIntent.putExtra("Kother_user_name_list", this.EER);
        localIntent.putExtra("Kchat_room_name_list", this.EES);
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131496446;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98798);
    boolean bool = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
    this.EEN = ((AnimatedExpandableListView)findViewById(2131308142));
    this.EEP = ((ArrayList)a.ecg().ecb());
    this.EET.EFs = bool;
    this.EET.aR(this.EEP);
    fiq();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    localLayoutParams.height = getResources().getDimensionPixelSize(2131165501);
    View localView = new View(this);
    localView.setLayoutParams(localLayoutParams);
    this.EEN.addHeaderView(localView);
    this.EEN.setAdapter(this.EET);
    if (this.EET.EFr == 2) {
      this.EEN.expandGroup(2);
    }
    for (;;)
    {
      this.EEN.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
      {
        public final boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(98788);
          int i = SnsLabelUI.a(SnsLabelUI.this).EFr;
          com.tencent.mm.plugin.sns.k.e.DUQ.YP(paramAnonymousInt);
          Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt > 1)
          {
            if ((SnsLabelUI.b(SnsLabelUI.this) != null) && (SnsLabelUI.b(SnsLabelUI.this).size() != 0) && (SnsLabelUI.fis() == 0))
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
              SnsLabelUI.a(SnsLabelUI.this, com.tencent.mm.ui.base.h.a(SnsLabelUI.this, SnsLabelUI.this.getString(2131766094), false, null));
              Log.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
              AppMethodBeat.o(98788);
              return true;
            }
            if ((SnsLabelUI.a(SnsLabelUI.this).EFq == null) || (SnsLabelUI.a(SnsLabelUI.this).EFq.size() == 0))
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
                SnsLabelUI.g(SnsLabelUI.this).apj(paramAnonymousInt);
              }
              for (;;)
              {
                SnsLabelUI.a(SnsLabelUI.this).EFr = paramAnonymousInt;
                AppMethodBeat.o(98788);
                return true;
                SnsLabelUI.g(SnsLabelUI.this).api(paramAnonymousInt);
              }
            }
            if (i == 2)
            {
              SnsLabelUI.g(SnsLabelUI.this).collapseGroup(2);
              SnsLabelUI.a(SnsLabelUI.this).EFt.clear();
              SnsLabelUI.a(SnsLabelUI.this).EFv.clear();
            }
            for (;;)
            {
              SnsLabelUI.g(SnsLabelUI.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(98787);
                  SnsLabelUI.g(SnsLabelUI.this).api(paramAnonymousInt);
                  AppMethodBeat.o(98787);
                }
              });
              break;
              if (i == 3)
              {
                SnsLabelUI.g(SnsLabelUI.this).collapseGroup(3);
                SnsLabelUI.a(SnsLabelUI.this).EFu.clear();
                SnsLabelUI.a(SnsLabelUI.this).EFw.clear();
              }
            }
          }
          if (i > 1) {
            SnsLabelUI.g(SnsLabelUI.this).apj(i);
          }
          SnsLabelUI.a(SnsLabelUI.this).EFr = paramAnonymousInt;
          AppMethodBeat.o(98788);
          return false;
        }
      });
      this.EEN.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
      {
        public final boolean onChildClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong)
        {
          AppMethodBeat.i(98789);
          if (paramAnonymousInt2 == bd.EFn)
          {
            SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt1);
            SnsLabelUI.f(SnsLabelUI.this);
            if (paramAnonymousInt2 != bd.EFn) {
              break label208;
            }
            paramAnonymousExpandableListView = com.tencent.mm.plugin.sns.k.e.DUQ;
            if (paramAnonymousExpandableListView.DVa != null)
            {
              if (paramAnonymousExpandableListView.DVa.eTt > 0) {
                break label189;
              }
              paramAnonymousExpandableListView.DVa.eTt = 1;
            }
          }
          for (;;)
          {
            AppMethodBeat.o(98789);
            return false;
            if (paramAnonymousInt2 == bd.EFm)
            {
              SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt1);
              SnsLabelUI.h(SnsLabelUI.this);
              break;
            }
            paramAnonymousExpandableListView = (String)SnsLabelUI.a(SnsLabelUI.this).getChild(paramAnonymousInt1, paramAnonymousInt2 - bd.EFo);
            SnsLabelUI.a(SnsLabelUI.this);
            bd.aRb(paramAnonymousExpandableListView);
            if (paramAnonymousInt1 == 2)
            {
              SnsLabelUI.a(SnsLabelUI.this, 1, SnsLabelUI.a(SnsLabelUI.this).EFt, paramAnonymousExpandableListView, paramAnonymousView);
              break;
            }
            if (paramAnonymousInt1 != 3) {
              break;
            }
            SnsLabelUI.a(SnsLabelUI.this, 2, SnsLabelUI.a(SnsLabelUI.this).EFu, paramAnonymousExpandableListView, paramAnonymousView);
            break;
            label189:
            paramAnonymousExpandableListView.DVa.eTt += 1;
            continue;
            label208:
            if (paramAnonymousInt2 == bd.EFm)
            {
              paramAnonymousExpandableListView = com.tencent.mm.plugin.sns.k.e.DUQ;
              if (paramAnonymousExpandableListView.DVa != null) {
                if (paramAnonymousExpandableListView.DVa.eTo <= 0) {
                  paramAnonymousExpandableListView.DVa.eTo = 1;
                } else {
                  paramAnonymousExpandableListView.DVa.eTo += 1;
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
      addTextOptionMenu(0, getString(2131766085), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(98791);
          paramAnonymousMenuItem = SnsLabelUI.this;
          String str1 = Util.listToString(paramAnonymousMenuItem.EET.EFt, ",");
          String str2 = Util.listToString(paramAnonymousMenuItem.EET.EFv, ",");
          String str3 = Util.listToString(paramAnonymousMenuItem.EET.EFx, ",");
          String str4 = Util.listToString(paramAnonymousMenuItem.EET.EFu, ",");
          String str5 = Util.listToString(paramAnonymousMenuItem.EET.EFw, ",");
          String str6 = Util.listToString(paramAnonymousMenuItem.EET.EFy, ",");
          if (((paramAnonymousMenuItem.EET.EFr == 2) && (paramAnonymousMenuItem.EET.EFt.size() == 0) && (paramAnonymousMenuItem.EET.EFv.size() == 0) && (paramAnonymousMenuItem.EET.EFx.size() == 0)) || ((paramAnonymousMenuItem.EET.EFr == 3) && (paramAnonymousMenuItem.EET.EFu.size() == 0) && (paramAnonymousMenuItem.EET.EFw.size() == 0) && (paramAnonymousMenuItem.EET.EFy.size() == 0))) {
            com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131766095), "", paramAnonymousMenuItem.getString(2131766107), null);
          }
          for (;;)
          {
            AppMethodBeat.o(98791);
            return true;
            if (((paramAnonymousMenuItem.EET.EFr == 2) && (Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)) && (Util.isNullOrNil(str3))) || ((paramAnonymousMenuItem.EET.EFr == 3) && (Util.isNullOrNil(str4)) && (Util.isNullOrNil(str5)) && (Util.isNullOrNil(str6)))) {
              com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131766095), "", paramAnonymousMenuItem.getString(2131766107), null);
            } else {
              paramAnonymousMenuItem.fim();
            }
          }
        }
      }, null, t.b.OGU);
      AppMethodBeat.o(98798);
      return;
      if (this.EET.EFr == 3) {
        this.EEN.expandGroup(3);
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
        c.b(getContext(), "label", ".ui.ContactLabelEditUI", paramIntent, 4002);
        AppMethodBeat.o(98799);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      this.EER = new String(paramIntent);
      Log.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.EFa == 2)
      {
        this.EET.EFv.clear();
        if (!Util.isNullOrNil(paramIntent))
        {
          paramIntent = Util.stringsToList(paramIntent.split(","));
          this.EET.EFv.addAll(paramIntent);
          this.EET.EFr = this.EFa;
        }
      }
      for (;;)
      {
        this.EET.notifyDataSetChanged();
        this.EEN.expandGroup(this.EFa);
        AppMethodBeat.o(98799);
        return;
        if (this.EFa == 3)
        {
          this.EET.EFw.clear();
          if (!Util.isNullOrNil(paramIntent))
          {
            paramIntent = Util.stringsToList(paramIntent.split(","));
            this.EET.EFw.addAll(paramIntent);
            this.EET.EFr = this.EFa;
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
      AppMethodBeat.o(98799);
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
          AppMethodBeat.i(98793);
          SnsLabelUI.a(SnsLabelUI.this, (ArrayList)a.ecg().ecb());
          if (SnsLabelUI.k(SnsLabelUI.this) == null) {
            SnsLabelUI.a(SnsLabelUI.this, new ArrayList());
          }
          if (!Util.isNullOrNil(this.EFl)) {
            if (!SnsLabelUI.k(SnsLabelUI.this).contains(this.EFl)) {
              SnsLabelUI.k(SnsLabelUI.this).add(this.EFl);
            }
          }
          for (int i = SnsLabelUI.k(SnsLabelUI.this).indexOf(this.EFl);; i = -1)
          {
            SnsLabelUI.a(SnsLabelUI.this).aR(SnsLabelUI.k(SnsLabelUI.this));
            SnsLabelUI.l(SnsLabelUI.this);
            SnsLabelUI.a(SnsLabelUI.this).EFr = SnsLabelUI.m(SnsLabelUI.this);
            if ((!Util.isNullOrNil(this.EFl)) && (i != -1))
            {
              if (SnsLabelUI.m(SnsLabelUI.this) != 2) {
                break label246;
              }
              SnsLabelUI.a(SnsLabelUI.this).EFt.add(this.EFl);
              SnsLabelUI.a(SnsLabelUI.this).EFv.clear();
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
                SnsLabelUI.a(SnsLabelUI.this).EFu.add(this.EFl);
                SnsLabelUI.a(SnsLabelUI.this).EFw.clear();
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
      this.EES = paramIntent;
      Log.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.EFa != 2) {
        break label563;
      }
      this.EET.EFx.clear();
      if (!Util.isNullOrNil(paramIntent))
      {
        paramIntent = Util.stringsToList(paramIntent.split(","));
        this.EET.EFx.addAll(paramIntent);
        this.EET.EFr = this.EFa;
      }
    }
    for (;;)
    {
      this.EET.notifyDataSetChanged();
      this.EEN.expandGroup(this.EFa);
      AppMethodBeat.o(98799);
      return;
      label563:
      if (this.EFa == 3)
      {
        this.EET.EFy.clear();
        if (!Util.isNullOrNil(paramIntent))
        {
          paramIntent = Util.stringsToList(paramIntent.split(","));
          this.EET.EFy.addAll(paramIntent);
          this.EET.EFr = this.EFa;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98797);
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
    this.EET = new bd(this);
    this.EET.EFz = new bd.b()
    {
      public final void a(bd.c paramAnonymousc)
      {
        AppMethodBeat.i(98784);
        int i = paramAnonymousc.EFE;
        int j = paramAnonymousc.EFF;
        SnsLabelUI.a(SnsLabelUI.this, i, j);
        AppMethodBeat.o(98784);
      }
    };
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      this.EEU = 0;
      this.EET.style = 0;
      this.EEQ = null;
      this.EER = null;
      this.EES = null;
      this.EET.EFr = this.EEU;
      this.EET.EEV = this.EEV;
      if (this.EET.style == 1) {
        findViewById(2131308143).setBackgroundResource(2131100042);
      }
      if (this.EEU != 2) {
        break label488;
      }
      if (!TextUtils.isEmpty(this.EEQ)) {
        this.EET.EFt = Util.stringsToList(this.EEQ.split(","));
      }
      if (!TextUtils.isEmpty(this.EER)) {
        this.EET.EFv = Util.stringsToList(this.EER.split(","));
      }
      if ((this.EES != null) && (!this.EES.isEmpty())) {
        this.EET.EFx = Util.stringsToList(this.EES.split(","));
      }
    }
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
      AppMethodBeat.o(98797);
      return;
      this.EEV = paramBundle.getBooleanExtra("Kis_from_text_status", false);
      this.EEU = paramBundle.getIntExtra("KLabel_range_index", 0);
      this.EET.style = paramBundle.getIntExtra("k_sns_label_ui_style", 0);
      this.EEQ = paramBundle.getStringExtra("Klabel_name_list");
      this.EER = paramBundle.getStringExtra("Kother_user_name_list");
      this.EES = paramBundle.getStringExtra("Kchat_room_name_list");
      if (TextUtils.isEmpty(paramBundle.getStringExtra("k_sns_label_ui_title"))) {
        break;
      }
      setMMTitle(paramBundle.getStringExtra("k_sns_label_ui_title"));
      break;
      label488:
      if (this.EEU == 3)
      {
        if (!TextUtils.isEmpty(this.EEQ)) {
          this.EET.EFu = Util.stringsToList(this.EEQ.split(","));
        }
        if (!TextUtils.isEmpty(this.EER)) {
          this.EET.EFw = Util.stringsToList(this.EER.split(","));
        }
        if ((this.EES != null) && (!this.EES.isEmpty())) {
          this.EET.EFy = Util.stringsToList(this.EES.split(","));
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98804);
    g.aAi();
    g.aAg().hqi.b(292, this);
    g.aAi();
    g.aAg().hqi.b(635, this);
    g.aAi();
    g.aAg().hqi.b(638, this);
    g.aAi();
    g.aAg().hqi.b(290, this);
    super.onDestroy();
    AppMethodBeat.o(98804);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98805);
    if ((this.EET != null) && (this.EFc == null) && (this.EEN != null)) {
      this.EEN.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98785);
          a.ecg().aHn();
          SnsLabelUI.a(SnsLabelUI.this, (ArrayList)a.ecg().ecb());
          SnsLabelUI.a(SnsLabelUI.this).aR(SnsLabelUI.k(SnsLabelUI.this));
          SnsLabelUI.l(SnsLabelUI.this);
          if (((SnsLabelUI.k(SnsLabelUI.this) == null) || (SnsLabelUI.k(SnsLabelUI.this).size() == 0)) && ((SnsLabelUI.q(SnsLabelUI.this) == null) || (SnsLabelUI.q(SnsLabelUI.this).length() == 0)) && (SnsLabelUI.a(SnsLabelUI.this).EFr != 0) && (SnsLabelUI.a(SnsLabelUI.this).EFr != 1) && ((SnsLabelUI.r(SnsLabelUI.this) == null) || (SnsLabelUI.r(SnsLabelUI.this).length() == 0))) {
            SnsLabelUI.a(SnsLabelUI.this).EFr = 0;
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(98806);
    Log.i("MicroMsg.SnsLabelUI", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!this.EEY)
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
              paramString = a.ecg().ecd();
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
            break label525;
          }
          paramInt1 = 0;
          if (paramInt1 != 0) {}
        }
        else if (this.EEZ)
        {
          this.EET.EFr = this.EFa;
          if ((this.EEN != null) && (this.EEN.getChildCount() > 0)) {
            this.EEN.api(this.EFa);
          }
          g.aAi();
          g.aAh().azQ().set(335873, Boolean.FALSE);
        }
        ((Cursor)localObject).close();
        if (this.EEX)
        {
          this.EEY = true;
          a.ecg().fi(this.EFf);
        }
      }
      for (;;)
      {
        this.EEZ = false;
        AppMethodBeat.o(98806);
        return;
        label525:
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
        AppMethodBeat.o(98806);
        return;
      }
      fip();
      Log.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
      AppMethodBeat.o(98806);
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
        this.EEP = ((ArrayList)a.ecg().ecb());
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
              AppMethodBeat.i(98786);
              SnsLabelUI.a(SnsLabelUI.this).EFr = SnsLabelUI.m(SnsLabelUI.this);
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
                    bd.aRb((String)((Iterator)localObject).next());
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
              SnsLabelUI.a(SnsLabelUI.this).aR(SnsLabelUI.k(SnsLabelUI.this));
              SnsLabelUI.l(SnsLabelUI.this);
              SnsLabelUI.a(SnsLabelUI.this).notifyDataSetChanged();
              SnsLabelUI.g(SnsLabelUI.this).api(SnsLabelUI.a(SnsLabelUI.this).EFr);
              if ((SnsLabelUI.t(SnsLabelUI.this) != null) && (SnsLabelUI.t(SnsLabelUI.this).isShowing())) {
                SnsLabelUI.t(SnsLabelUI.this).dismiss();
              }
              AppMethodBeat.o(98786);
            }
          }, 600L);
          g.aAi();
          g.aAh().azQ().set(335873, Boolean.FALSE);
          AppMethodBeat.o(98806);
          return;
        }
      }
      fip();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI
 * JD-Core Version:    0.7.0.1
 */