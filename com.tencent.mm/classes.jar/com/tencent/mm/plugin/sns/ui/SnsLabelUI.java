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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.b.a.dw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.sns.k.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsLabelUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  public static int[] xAe = { 2131763871, 2131763869, 2131763865, 2131763856 };
  private AnimatedExpandableListView xAd;
  private ArrayList<String> xAf;
  private String xAg;
  private String xAh;
  private String xAi;
  ax xAj;
  private int xAk = 0;
  private boolean xAl;
  private boolean xAm = false;
  private boolean xAn = false;
  private boolean xAo = false;
  private int xAp;
  private p xAq;
  private String xAr;
  private int xAs;
  private ArrayList<String> xAt;
  private ArrayList<String> xAu;
  private ArrayList<Long> xAv;
  private ArrayList<String[]> xAw;
  
  private boolean dBp()
  {
    boolean bool2 = true;
    AppMethodBeat.i(98800);
    int i = this.xAj.xAG;
    boolean bool1;
    if (this.xAj.xAG != this.xAk) {
      if (i == 2)
      {
        bool1 = bool2;
        if (this.xAj.xAI.size() == 0)
        {
          bool1 = bool2;
          if (this.xAj.xAK.size() != 0) {}
        }
      }
      else
      {
        if (i != 3) {
          break label106;
        }
        bool1 = bool2;
        if (this.xAj.xAJ.size() == 0)
        {
          if (this.xAj.xAL.size() == 0) {
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
              if ((i == 2) && (this.xAj.xAI.size() != 0))
              {
                bool1 = bool2;
                if (!bt.n(this.xAj.xAI, ",").equals(this.xAg)) {
                  break;
                }
                bool1 = bool2;
                if (!bt.n(this.xAj.xAK, ",").equals(this.xAh)) {
                  break;
                }
                bool1 = bool2;
                if (!bt.n(this.xAj.xAM, ",").equals(this.xAi)) {
                  break;
                }
              }
            } while ((i != 3) || (this.xAj.xAJ.size() == 0));
            bool1 = bool2;
            if (!bt.n(this.xAj.xAJ, ",").equals(this.xAg)) {
              break;
            }
            bool1 = bool2;
            if (!bt.n(this.xAj.xAL, ",").equals(this.xAh)) {
              break;
            }
          } while (bt.n(this.xAj.xAN, ",").equals(this.xAi));
          bool1 = bool2;
        }
      }
    }
  }
  
  private void dBq()
  {
    AppMethodBeat.i(98802);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ktag_range_index", this.xAk);
    if ((this.xAk == 2) || (this.xAk == 3))
    {
      dBw();
      localIntent.putExtra("Klabel_name_list", this.xAg);
      localIntent.putExtra("Kother_user_name_list", this.xAh);
      localIntent.putExtra("Kchat_room_name_list", this.xAi);
    }
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(98802);
  }
  
  private static int dBs()
  {
    AppMethodBeat.i(98807);
    com.tencent.mm.kernel.g.afC();
    int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(335874, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(98807);
    return i;
  }
  
  private static void dBt()
  {
    AppMethodBeat.i(98808);
    com.tencent.mm.kernel.g.afC();
    int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(335874, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afk().set(335874, Integer.valueOf(i + 1));
    AppMethodBeat.o(98808);
  }
  
  private void dBu()
  {
    AppMethodBeat.i(98809);
    com.tencent.mm.plugin.report.service.h.vKh.f(11455, new Object[] { "", "", Integer.valueOf(this.xAs), Integer.valueOf(0) });
    dBt();
    this.xAu = null;
    this.xAo = false;
    this.xAn = false;
    if ((this.xAq != null) && (this.xAq.isShowing())) {
      this.xAq.dismiss();
    }
    if (this.xAm)
    {
      this.xAm = false;
      AppMethodBeat.o(98809);
      return;
    }
    int i = 2131763879;
    if (dBs() > 1) {
      i = 2131763878;
    }
    com.tencent.mm.ui.base.h.a(this, i, 2131755835, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(98809);
  }
  
  private void dBv()
  {
    AppMethodBeat.i(98811);
    if ((this.xAf == null) || (this.xAf.isEmpty()))
    {
      if (this.xAj.xAI != null) {
        this.xAj.xAI.clear();
      }
      if (this.xAj.xAJ != null) {
        this.xAj.xAJ.clear();
      }
      AppMethodBeat.o(98811);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    String str;
    if ((this.xAk == 2) && (this.xAj.xAI != null))
    {
      localIterator = this.xAj.xAI.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.xAf.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.xAj.xAI.removeAll(localArrayList);
      AppMethodBeat.o(98811);
      return;
    }
    if (this.xAk == 3)
    {
      localIterator = this.xAj.xAJ.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.xAf.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.xAj.xAJ.removeAll(localArrayList);
    }
    AppMethodBeat.o(98811);
  }
  
  private void dBw()
  {
    AppMethodBeat.i(98812);
    if ((this.xAf == null) || (this.xAf.isEmpty()))
    {
      this.xAg = "";
      AppMethodBeat.o(98812);
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    if (this.xAg != null)
    {
      ArrayList localArrayList2 = bt.S(this.xAg.split(","));
      if (localArrayList2 != null)
      {
        Iterator localIterator = localArrayList2.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!this.xAf.contains(str)) {
            localArrayList1.add(str);
          }
        }
        localArrayList2.removeAll(localArrayList1);
        this.xAg = bt.n(localArrayList2, ",");
      }
    }
    AppMethodBeat.o(98812);
  }
  
  private void fE(List<String[]> paramList)
  {
    AppMethodBeat.i(98810);
    if ((this.xAu == null) || (this.xAu.size() == 0))
    {
      AppMethodBeat.o(98810);
      return;
    }
    Iterator localIterator = this.xAu.iterator();
    paramList = paramList.iterator();
    ArrayList localArrayList1 = new ArrayList(this.xAu.size());
    ArrayList localArrayList2 = new ArrayList(this.xAu.size());
    while (localIterator.hasNext())
    {
      localArrayList1.add(a.cIS().aeI((String)localIterator.next()));
      localArrayList2.add(bt.n(Arrays.asList((Object[])paramList.next()), ","));
      this.xAn = true;
    }
    a.cIS().n(localArrayList1, localArrayList2);
    AppMethodBeat.o(98810);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(98801);
    if (dBp())
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
    dBq();
    AppMethodBeat.o(98801);
  }
  
  final void dBr()
  {
    AppMethodBeat.i(98803);
    Intent localIntent = new Intent();
    if (this.xAj.xAG == 2)
    {
      this.xAg = bt.n(this.xAj.xAI, ",");
      this.xAh = bt.n(this.xAj.xAK, ",");
      this.xAi = bt.n(this.xAj.xAM, ",");
      dBw();
      localIntent.putExtra("Klabel_name_list", this.xAg);
      localIntent.putExtra("Kother_user_name_list", this.xAh);
      localIntent.putExtra("Kchat_room_name_list", this.xAi);
    }
    for (;;)
    {
      localIntent.putExtra("Ktag_range_index", this.xAj.xAG);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(98803);
      return;
      if (this.xAj.xAG == 3)
      {
        this.xAg = bt.n(this.xAj.xAJ, ",");
        this.xAh = bt.n(this.xAj.xAL, ",");
        this.xAi = bt.n(this.xAj.xAN, ",");
        dBw();
        localIntent.putExtra("Klabel_name_list", this.xAg);
        localIntent.putExtra("Kother_user_name_list", this.xAh);
        localIntent.putExtra("Kchat_room_name_list", this.xAi);
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
    this.xAd = ((AnimatedExpandableListView)findViewById(2131304991));
    this.xAf = ((ArrayList)a.cIS().cIN());
    this.xAj.xAH = bool;
    this.xAj.ap(this.xAf);
    dBv();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    localLayoutParams.height = getResources().getDimensionPixelSize(2131165483);
    View localView = new View(this);
    localView.setLayoutParams(localLayoutParams);
    this.xAd.addHeaderView(localView);
    this.xAd.setAdapter(this.xAj);
    if (this.xAj.xAG == 2) {
      this.xAd.expandGroup(2);
    }
    for (;;)
    {
      this.xAd.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
      {
        public final boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(98788);
          int i = SnsLabelUI.a(SnsLabelUI.this).xAG;
          f.wQY.MB(paramAnonymousInt);
          ad.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt > 1)
          {
            if ((SnsLabelUI.b(SnsLabelUI.this) != null) && (SnsLabelUI.b(SnsLabelUI.this).size() != 0) && (SnsLabelUI.dBx() == 0))
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
              SnsLabelUI.a(SnsLabelUI.this, com.tencent.mm.ui.base.h.b(SnsLabelUI.this, SnsLabelUI.this.getString(2131763867), false, null));
              ad.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
              AppMethodBeat.o(98788);
              return true;
            }
            if ((SnsLabelUI.a(SnsLabelUI.this).xAF == null) || (SnsLabelUI.a(SnsLabelUI.this).xAF.size() == 0))
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
                SnsLabelUI.g(SnsLabelUI.this).aaL(paramAnonymousInt);
              }
              for (;;)
              {
                SnsLabelUI.a(SnsLabelUI.this).xAG = paramAnonymousInt;
                AppMethodBeat.o(98788);
                return true;
                SnsLabelUI.g(SnsLabelUI.this).aaK(paramAnonymousInt);
              }
            }
            if (i == 2)
            {
              SnsLabelUI.g(SnsLabelUI.this).collapseGroup(2);
              SnsLabelUI.a(SnsLabelUI.this).xAI.clear();
              SnsLabelUI.a(SnsLabelUI.this).xAK.clear();
            }
            for (;;)
            {
              SnsLabelUI.g(SnsLabelUI.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(98787);
                  SnsLabelUI.g(SnsLabelUI.this).aaK(paramAnonymousInt);
                  AppMethodBeat.o(98787);
                }
              });
              break;
              if (i == 3)
              {
                SnsLabelUI.g(SnsLabelUI.this).collapseGroup(3);
                SnsLabelUI.a(SnsLabelUI.this).xAJ.clear();
                SnsLabelUI.a(SnsLabelUI.this).xAL.clear();
              }
            }
          }
          if (i > 1) {
            SnsLabelUI.g(SnsLabelUI.this).aaL(i);
          }
          SnsLabelUI.a(SnsLabelUI.this).xAG = paramAnonymousInt;
          AppMethodBeat.o(98788);
          return false;
        }
      });
      this.xAd.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
      {
        public final boolean onChildClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong)
        {
          AppMethodBeat.i(98789);
          if (paramAnonymousInt2 == ax.xAC)
          {
            SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt1);
            SnsLabelUI.f(SnsLabelUI.this);
            if (paramAnonymousInt2 != ax.xAC) {
              break label208;
            }
            paramAnonymousExpandableListView = f.wQY;
            if (paramAnonymousExpandableListView.wRg != null)
            {
              if (paramAnonymousExpandableListView.wRg.dVX > 0) {
                break label189;
              }
              paramAnonymousExpandableListView.wRg.dVX = 1;
            }
          }
          for (;;)
          {
            AppMethodBeat.o(98789);
            return false;
            if (paramAnonymousInt2 == ax.xAB)
            {
              SnsLabelUI.a(SnsLabelUI.this, paramAnonymousInt1);
              SnsLabelUI.h(SnsLabelUI.this);
              break;
            }
            paramAnonymousExpandableListView = (String)SnsLabelUI.a(SnsLabelUI.this).getChild(paramAnonymousInt1, paramAnonymousInt2 - ax.xAD);
            SnsLabelUI.a(SnsLabelUI.this);
            ax.aqz(paramAnonymousExpandableListView);
            if (paramAnonymousInt1 == 2)
            {
              SnsLabelUI.a(SnsLabelUI.this, 1, SnsLabelUI.a(SnsLabelUI.this).xAI, paramAnonymousExpandableListView, paramAnonymousView);
              break;
            }
            if (paramAnonymousInt1 != 3) {
              break;
            }
            SnsLabelUI.a(SnsLabelUI.this, 2, SnsLabelUI.a(SnsLabelUI.this).xAJ, paramAnonymousExpandableListView, paramAnonymousView);
            break;
            label189:
            paramAnonymousExpandableListView.wRg.dVX += 1;
            continue;
            label208:
            if (paramAnonymousInt2 == ax.xAB)
            {
              paramAnonymousExpandableListView = f.wQY;
              if (paramAnonymousExpandableListView.wRg != null) {
                if (paramAnonymousExpandableListView.wRg.dVS <= 0) {
                  paramAnonymousExpandableListView.wRg.dVS = 1;
                } else {
                  paramAnonymousExpandableListView.wRg.dVS += 1;
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
          String str1 = bt.n(paramAnonymousMenuItem.xAj.xAI, ",");
          String str2 = bt.n(paramAnonymousMenuItem.xAj.xAK, ",");
          String str3 = bt.n(paramAnonymousMenuItem.xAj.xAM, ",");
          String str4 = bt.n(paramAnonymousMenuItem.xAj.xAJ, ",");
          String str5 = bt.n(paramAnonymousMenuItem.xAj.xAL, ",");
          String str6 = bt.n(paramAnonymousMenuItem.xAj.xAN, ",");
          if (((paramAnonymousMenuItem.xAj.xAG == 2) && (paramAnonymousMenuItem.xAj.xAI.size() == 0) && (paramAnonymousMenuItem.xAj.xAK.size() == 0) && (paramAnonymousMenuItem.xAj.xAM.size() == 0)) || ((paramAnonymousMenuItem.xAj.xAG == 3) && (paramAnonymousMenuItem.xAj.xAJ.size() == 0) && (paramAnonymousMenuItem.xAj.xAL.size() == 0) && (paramAnonymousMenuItem.xAj.xAN.size() == 0))) {
            com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131763868), "", paramAnonymousMenuItem.getString(2131763880), null);
          }
          for (;;)
          {
            AppMethodBeat.o(98791);
            return true;
            if (((paramAnonymousMenuItem.xAj.xAG == 2) && (bt.isNullOrNil(str1)) && (bt.isNullOrNil(str2)) && (bt.isNullOrNil(str3))) || ((paramAnonymousMenuItem.xAj.xAG == 3) && (bt.isNullOrNil(str4)) && (bt.isNullOrNil(str5)) && (bt.isNullOrNil(str6)))) {
              com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131763868), "", paramAnonymousMenuItem.getString(2131763880), null);
            } else {
              paramAnonymousMenuItem.dBr();
            }
          }
        }
      }, null, r.b.FOB);
      AppMethodBeat.o(98798);
      return;
      if (this.xAj.xAG == 3) {
        this.xAd.expandGroup(3);
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
      this.xAh = new String(paramIntent);
      ad.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.xAp == 2)
      {
        this.xAj.xAK.clear();
        if (!bt.isNullOrNil(paramIntent))
        {
          paramIntent = bt.S(paramIntent.split(","));
          this.xAj.xAK.addAll(paramIntent);
          this.xAj.xAG = this.xAp;
        }
      }
      for (;;)
      {
        this.xAj.notifyDataSetChanged();
        this.xAd.expandGroup(this.xAp);
        AppMethodBeat.o(98799);
        return;
        if (this.xAp == 3)
        {
          this.xAj.xAL.clear();
          if (!bt.isNullOrNil(paramIntent))
          {
            paramIntent = bt.S(paramIntent.split(","));
            this.xAj.xAL.addAll(paramIntent);
            this.xAj.xAG = this.xAp;
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
      this.xAr = paramIntent.getStringExtra("k_sns_label_add_label");
      this.xAd.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98793);
          SnsLabelUI.a(SnsLabelUI.this, (ArrayList)a.cIS().cIN());
          if (SnsLabelUI.k(SnsLabelUI.this) == null) {
            SnsLabelUI.a(SnsLabelUI.this, new ArrayList());
          }
          if (!bt.isNullOrNil(this.xAA)) {
            if (!SnsLabelUI.k(SnsLabelUI.this).contains(this.xAA)) {
              SnsLabelUI.k(SnsLabelUI.this).add(this.xAA);
            }
          }
          for (int i = SnsLabelUI.k(SnsLabelUI.this).indexOf(this.xAA);; i = -1)
          {
            SnsLabelUI.a(SnsLabelUI.this).ap(SnsLabelUI.k(SnsLabelUI.this));
            SnsLabelUI.l(SnsLabelUI.this);
            SnsLabelUI.a(SnsLabelUI.this).xAG = SnsLabelUI.m(SnsLabelUI.this);
            if ((!bt.isNullOrNil(this.xAA)) && (i != -1))
            {
              if (SnsLabelUI.m(SnsLabelUI.this) != 2) {
                break label246;
              }
              SnsLabelUI.a(SnsLabelUI.this).xAI.add(this.xAA);
              SnsLabelUI.a(SnsLabelUI.this).xAK.clear();
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
                SnsLabelUI.a(SnsLabelUI.this).xAJ.add(this.xAA);
                SnsLabelUI.a(SnsLabelUI.this).xAL.clear();
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
      this.xAi = paramIntent;
      ad.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.xAp != 2) {
        break label563;
      }
      this.xAj.xAM.clear();
      if (!bt.isNullOrNil(paramIntent))
      {
        paramIntent = bt.S(paramIntent.split(","));
        this.xAj.xAM.addAll(paramIntent);
        this.xAj.xAG = this.xAp;
      }
    }
    for (;;)
    {
      this.xAj.notifyDataSetChanged();
      this.xAd.expandGroup(this.xAp);
      AppMethodBeat.o(98799);
      return;
      label563:
      if (this.xAp == 3)
      {
        this.xAj.xAN.clear();
        if (!bt.isNullOrNil(paramIntent))
        {
          paramIntent = bt.S(paramIntent.split(","));
          this.xAj.xAN.addAll(paramIntent);
          this.xAj.xAG = this.xAp;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98797);
    super.onCreate(paramBundle);
    setMMTitle(2131764018);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(292, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(635, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(638, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(290, this);
    this.xAj = new ax(this);
    this.xAj.xAO = new ax.b()
    {
      public final void a(ax.c paramAnonymousc)
      {
        AppMethodBeat.i(98784);
        int i = paramAnonymousc.xAT;
        int j = paramAnonymousc.xAU;
        SnsLabelUI.a(SnsLabelUI.this, i, j);
        AppMethodBeat.o(98784);
      }
    };
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      this.xAk = 0;
      this.xAj.style = 0;
      this.xAg = null;
      this.xAh = null;
      this.xAi = null;
      this.xAj.xAG = this.xAk;
      if (this.xAj.style == 1) {
        findViewById(2131304992).setBackgroundResource(2131100017);
      }
      if (this.xAk != 2) {
        break label465;
      }
      if (!TextUtils.isEmpty(this.xAg)) {
        this.xAj.xAI = bt.S(this.xAg.split(","));
      }
      if (!TextUtils.isEmpty(this.xAh)) {
        this.xAj.xAK = bt.S(this.xAh.split(","));
      }
      if ((this.xAi != null) && (!this.xAi.isEmpty())) {
        this.xAj.xAM = bt.S(this.xAi.split(","));
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.afC();
      this.xAl = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(335873, Boolean.TRUE)).booleanValue();
      if (this.xAl)
      {
        this.xAn = true;
        this.xAo = true;
        if (dBs() > 0) {
          this.xAm = true;
        }
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(new u(1), 0);
      }
      initView();
      AppMethodBeat.o(98797);
      return;
      this.xAk = paramBundle.getIntExtra("KLabel_range_index", 0);
      this.xAj.style = paramBundle.getIntExtra("k_sns_label_ui_style", 0);
      this.xAg = paramBundle.getStringExtra("Klabel_name_list");
      this.xAh = paramBundle.getStringExtra("Kother_user_name_list");
      this.xAi = paramBundle.getStringExtra("Kchat_room_name_list");
      if (TextUtils.isEmpty(paramBundle.getStringExtra("k_sns_label_ui_title"))) {
        break;
      }
      setMMTitle(paramBundle.getStringExtra("k_sns_label_ui_title"));
      break;
      label465:
      if (this.xAk == 3)
      {
        if (!TextUtils.isEmpty(this.xAg)) {
          this.xAj.xAJ = bt.S(this.xAg.split(","));
        }
        if (!TextUtils.isEmpty(this.xAh)) {
          this.xAj.xAL = bt.S(this.xAh.split(","));
        }
        if ((this.xAi != null) && (!this.xAi.isEmpty())) {
          this.xAj.xAN = bt.S(this.xAi.split(","));
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98804);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(292, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(635, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(638, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(290, this);
    super.onDestroy();
    AppMethodBeat.o(98804);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98805);
    if ((this.xAj != null) && (this.xAr == null) && (this.xAd != null)) {
      this.xAd.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98785);
          a.cIS().ayP();
          SnsLabelUI.a(SnsLabelUI.this, (ArrayList)a.cIS().cIN());
          SnsLabelUI.a(SnsLabelUI.this).ap(SnsLabelUI.k(SnsLabelUI.this));
          SnsLabelUI.l(SnsLabelUI.this);
          if (((SnsLabelUI.k(SnsLabelUI.this) == null) || (SnsLabelUI.k(SnsLabelUI.this).size() == 0)) && ((SnsLabelUI.q(SnsLabelUI.this) == null) || (SnsLabelUI.q(SnsLabelUI.this).length() == 0)) && (SnsLabelUI.a(SnsLabelUI.this).xAG != 0) && (SnsLabelUI.a(SnsLabelUI.this).xAG != 1) && ((SnsLabelUI.r(SnsLabelUI.this) == null) || (SnsLabelUI.r(SnsLabelUI.this).length() == 0))) {
            SnsLabelUI.a(SnsLabelUI.this).xAG = 0;
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
    if (!this.xAn)
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
        localObject = af.dtA().getCursor();
        this.xAs = ((Cursor)localObject).getCount();
        if (this.xAs > 0)
        {
          ((Cursor)localObject).moveToFirst();
          v localv = new v();
          paramInt1 = ((Cursor)localObject).getCount();
          this.xAu = new ArrayList(paramInt1);
          this.xAt = new ArrayList(paramInt1);
          this.xAw = new ArrayList(paramInt1);
          this.xAv = new ArrayList(paramInt1);
          if (!((Cursor)localObject).isAfterLast())
          {
            localv.convertFrom((Cursor)localObject);
            if ((localv.field_memberList != null) && (localv.field_memberList.length() != 0))
            {
              this.xAw.add(localv.field_memberList.split(","));
              paramn = localv.field_tagName;
              ArrayList localArrayList = this.xAu;
              paramString = a.cIS().cIP();
              if (paramString == null)
              {
                paramString = paramn;
                label297:
                localArrayList.add(paramString);
                this.xAt.add(paramn);
                this.xAv.add(Long.valueOf(localv.field_tagId));
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
          if (this.xAt.size() != 0) {
            break label525;
          }
          paramInt1 = 0;
          if (paramInt1 != 0) {}
        }
        else if (this.xAo)
        {
          this.xAj.xAG = this.xAp;
          if ((this.xAd != null) && (this.xAd.getChildCount() > 0)) {
            this.xAd.aaK(this.xAp);
          }
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(335873, Boolean.FALSE);
        }
        ((Cursor)localObject).close();
        if (this.xAm)
        {
          this.xAn = true;
          a.cIS().dT(this.xAu);
        }
      }
      for (;;)
      {
        this.xAo = false;
        AppMethodBeat.o(98806);
        return;
        label525:
        paramInt1 = 1;
        break;
        this.xAn = false;
        continue;
        dBu();
        ad.i("MicroMsg.SnsLabelUI", "dz: error at get sns tag list!");
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        fE(this.xAw);
        AppMethodBeat.o(98806);
        return;
      }
      dBu();
      ad.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
      AppMethodBeat.o(98806);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.xAt.iterator();
        paramn = this.xAv.iterator();
        while (paramString.hasNext())
        {
          long l = ((Long)paramn.next()).longValue();
          localObject = (String)paramString.next();
          if (l != 0L)
          {
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(new com.tencent.mm.plugin.sns.model.w(l, (String)localObject), 0);
          }
        }
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(335874, Integer.valueOf(0));
        this.xAf = ((ArrayList)a.cIS().cIN());
        paramString = com.tencent.mm.plugin.report.service.h.vKh;
        paramInt2 = this.xAs;
        if (this.xAu == null) {}
        for (paramInt1 = 0;; paramInt1 = this.xAu.size())
        {
          paramString.f(11455, new Object[] { "", "", Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
          this.xAd.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(98786);
              SnsLabelUI.a(SnsLabelUI.this).xAG = SnsLabelUI.m(SnsLabelUI.this);
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
                    ax.aqz((String)((Iterator)localObject).next());
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
              SnsLabelUI.a(SnsLabelUI.this).ap(SnsLabelUI.k(SnsLabelUI.this));
              SnsLabelUI.l(SnsLabelUI.this);
              SnsLabelUI.a(SnsLabelUI.this).notifyDataSetChanged();
              SnsLabelUI.g(SnsLabelUI.this).aaK(SnsLabelUI.a(SnsLabelUI.this).xAG);
              if ((SnsLabelUI.t(SnsLabelUI.this) != null) && (SnsLabelUI.t(SnsLabelUI.this).isShowing())) {
                SnsLabelUI.t(SnsLabelUI.this).dismiss();
              }
              AppMethodBeat.o(98786);
            }
          }, 600L);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(335873, Boolean.FALSE);
          AppMethodBeat.o(98806);
          return;
        }
      }
      dBu();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI
 * JD-Core Version:    0.7.0.1
 */