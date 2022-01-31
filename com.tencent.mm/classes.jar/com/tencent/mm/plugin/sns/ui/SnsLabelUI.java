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
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SnsLabelUI
  extends MMActivity
  implements f
{
  public static int[] rRO = { 2131303862, 2131303860, 2131303856, 2131303847 };
  private AnimatedExpandableListView rRN;
  private ArrayList<String> rRP;
  private String rRQ;
  private String rRR;
  private String rRS;
  ap rRT;
  private int rRU = 0;
  private boolean rRV;
  private boolean rRW = false;
  private boolean rRX = false;
  private boolean rRY = false;
  private int rRZ;
  private com.tencent.mm.ui.base.p rSa;
  private String rSb;
  private int rSc;
  private ArrayList<String> rSd;
  private ArrayList<String> rSe;
  private ArrayList<Long> rSf;
  private ArrayList<String[]> rSg;
  
  private boolean cvs()
  {
    boolean bool2 = true;
    AppMethodBeat.i(39027);
    int i = this.rRT.rSq;
    boolean bool1;
    if (this.rRT.rSq != this.rRU) {
      if (i == 2)
      {
        bool1 = bool2;
        if (this.rRT.rSs.size() == 0)
        {
          bool1 = bool2;
          if (this.rRT.rSu.size() != 0) {}
        }
      }
      else
      {
        if (i != 3) {
          break label106;
        }
        bool1 = bool2;
        if (this.rRT.rSt.size() == 0)
        {
          if (this.rRT.rSv.size() == 0) {
            break label106;
          }
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(39027);
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
              if ((i == 2) && (this.rRT.rSs.size() != 0))
              {
                bool1 = bool2;
                if (!bo.d(this.rRT.rSs, ",").equals(this.rRQ)) {
                  break;
                }
                bool1 = bool2;
                if (!bo.d(this.rRT.rSu, ",").equals(this.rRR)) {
                  break;
                }
                bool1 = bool2;
                if (!bo.d(this.rRT.rSw, ",").equals(this.rRS)) {
                  break;
                }
              }
            } while ((i != 3) || (this.rRT.rSt.size() == 0));
            bool1 = bool2;
            if (!bo.d(this.rRT.rSt, ",").equals(this.rRQ)) {
              break;
            }
            bool1 = bool2;
            if (!bo.d(this.rRT.rSv, ",").equals(this.rRR)) {
              break;
            }
          } while (bo.d(this.rRT.rSx, ",").equals(this.rRS));
          bool1 = bool2;
        }
      }
    }
  }
  
  private void cvt()
  {
    AppMethodBeat.i(39029);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ktag_range_index", this.rRU);
    if ((this.rRU == 2) || (this.rRU == 3))
    {
      cvz();
      localIntent.putExtra("Klabel_name_list", this.rRQ);
      localIntent.putExtra("Kother_user_name_list", this.rRR);
      localIntent.putExtra("Kchat_room_name_list", this.rRS);
    }
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(39029);
  }
  
  private static int cvv()
  {
    AppMethodBeat.i(39034);
    g.RM();
    int i = ((Integer)g.RL().Ru().get(335874, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(39034);
    return i;
  }
  
  private static void cvw()
  {
    AppMethodBeat.i(39035);
    g.RM();
    int i = ((Integer)g.RL().Ru().get(335874, Integer.valueOf(0))).intValue();
    g.RM();
    g.RL().Ru().set(335874, Integer.valueOf(i + 1));
    AppMethodBeat.o(39035);
  }
  
  private void cvx()
  {
    AppMethodBeat.i(39036);
    com.tencent.mm.plugin.report.service.h.qsU.e(11455, new Object[] { "", "", Integer.valueOf(this.rSc), Integer.valueOf(0) });
    cvw();
    this.rSe = null;
    this.rRY = false;
    this.rRX = false;
    if ((this.rSa != null) && (this.rSa.isShowing())) {
      this.rSa.dismiss();
    }
    if (this.rRW)
    {
      this.rRW = false;
      AppMethodBeat.o(39036);
      return;
    }
    int i = 2131303870;
    if (cvv() > 1) {
      i = 2131303869;
    }
    com.tencent.mm.ui.base.h.a(this, i, 2131297018, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(39036);
  }
  
  private void cvy()
  {
    AppMethodBeat.i(39038);
    if ((this.rRP == null) || (this.rRP.isEmpty()))
    {
      if (this.rRT.rSs != null) {
        this.rRT.rSs.clear();
      }
      if (this.rRT.rSt != null) {
        this.rRT.rSt.clear();
      }
      AppMethodBeat.o(39038);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    String str;
    if ((this.rRU == 2) && (this.rRT.rSs != null))
    {
      localIterator = this.rRT.rSs.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.rRP.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.rRT.rSs.removeAll(localArrayList);
      AppMethodBeat.o(39038);
      return;
    }
    if (this.rRU == 3)
    {
      localIterator = this.rRT.rSt.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!this.rRP.contains(str)) {
          localArrayList.add(str);
        }
      }
      this.rRT.rSt.removeAll(localArrayList);
    }
    AppMethodBeat.o(39038);
  }
  
  private void cvz()
  {
    AppMethodBeat.i(39039);
    if ((this.rRP == null) || (this.rRP.isEmpty()))
    {
      this.rRQ = "";
      AppMethodBeat.o(39039);
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    if (this.rRQ != null)
    {
      ArrayList localArrayList2 = bo.P(this.rRQ.split(","));
      if (localArrayList2 != null)
      {
        Iterator localIterator = localArrayList2.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!this.rRP.contains(str)) {
            localArrayList1.add(str);
          }
        }
        localArrayList2.removeAll(localArrayList1);
        this.rRQ = bo.d(localArrayList2, ",");
      }
    }
    AppMethodBeat.o(39039);
  }
  
  private void dn(List<String[]> paramList)
  {
    AppMethodBeat.i(39037);
    if ((this.rSe == null) || (this.rSe.size() == 0))
    {
      AppMethodBeat.o(39037);
      return;
    }
    Iterator localIterator = this.rSe.iterator();
    paramList = paramList.iterator();
    ArrayList localArrayList1 = new ArrayList(this.rSe.size());
    ArrayList localArrayList2 = new ArrayList(this.rSe.size());
    while (localIterator.hasNext())
    {
      localArrayList1.add(a.bKV().RO((String)localIterator.next()));
      localArrayList2.add(bo.d(Arrays.asList((Object[])paramList.next()), ","));
      this.rRX = true;
    }
    a.bKV().j(localArrayList1, localArrayList2);
    AppMethodBeat.o(39037);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(39028);
    if (cvs())
    {
      com.tencent.mm.ui.base.h.a(this, true, getString(2131303853), "", getString(2131303852), getString(2131303851), new SnsLabelUI.11(this), new SnsLabelUI.12(this));
      AppMethodBeat.o(39028);
      return;
    }
    cvt();
    AppMethodBeat.o(39028);
  }
  
  final void cvu()
  {
    AppMethodBeat.i(39030);
    Intent localIntent = new Intent();
    if (this.rRT.rSq == 2)
    {
      this.rRQ = bo.d(this.rRT.rSs, ",");
      this.rRR = bo.d(this.rRT.rSu, ",");
      this.rRS = bo.d(this.rRT.rSw, ",");
      cvz();
      localIntent.putExtra("Klabel_name_list", this.rRQ);
      localIntent.putExtra("Kother_user_name_list", this.rRR);
      localIntent.putExtra("Kchat_room_name_list", this.rRS);
    }
    for (;;)
    {
      localIntent.putExtra("Ktag_range_index", this.rRT.rSq);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(39030);
      return;
      if (this.rRT.rSq == 3)
      {
        this.rRQ = bo.d(this.rRT.rSt, ",");
        this.rRR = bo.d(this.rRT.rSv, ",");
        this.rRS = bo.d(this.rRT.rSx, ",");
        cvz();
        localIntent.putExtra("Klabel_name_list", this.rRQ);
        localIntent.putExtra("Kother_user_name_list", this.rRR);
        localIntent.putExtra("Kchat_room_name_list", this.rRS);
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(39023);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      goBack();
      AppMethodBeat.o(39023);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(39023);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2130970831;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39025);
    boolean bool = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
    this.rRN = ((AnimatedExpandableListView)findViewById(2131828013));
    this.rRP = ((ArrayList)a.bKV().bKQ());
    this.rRT.rSr = bool;
    this.rRT.S(this.rRP);
    cvy();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    localLayoutParams.height = getResources().getDimensionPixelSize(2131427775);
    View localView = new View(this);
    localView.setLayoutParams(localLayoutParams);
    this.rRN.addHeaderView(localView);
    this.rRN.setAdapter(this.rRT);
    if (this.rRT.rSq == 2) {
      this.rRN.expandGroup(2);
    }
    for (;;)
    {
      this.rRN.setOnGroupClickListener(new SnsLabelUI.5(this));
      this.rRN.setOnChildClickListener(new SnsLabelUI.6(this));
      setBackBtn(new SnsLabelUI.7(this));
      addTextOptionMenu(0, getString(2131303849), new SnsLabelUI.8(this), null, q.b.zby);
      AppMethodBeat.o(39025);
      return;
      if (this.rRT.rSq == 3) {
        this.rRN.expandGroup(3);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(39026);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if ((paramInt2 == -1) && (paramInt1 == 4003))
    {
      ab.i("MicroMsg.SnsLabelUI", "the Activity completed");
      localObject = paramIntent.getStringExtra("Select_Contacts_To_Create_New_Label");
      if (!bo.isNullOrNil((String)localObject))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("Select_Contact", (String)localObject);
        d.b(getContext(), "label", ".ui.ContactLabelEditUI", paramIntent, 4002);
        AppMethodBeat.o(39026);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      this.rRR = new String(paramIntent);
      ab.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.rRZ == 2)
      {
        this.rRT.rSu.clear();
        if (!bo.isNullOrNil(paramIntent))
        {
          paramIntent = bo.P(paramIntent.split(","));
          this.rRT.rSu.addAll(paramIntent);
          this.rRT.rSq = this.rRZ;
        }
      }
      for (;;)
      {
        this.rRT.notifyDataSetChanged();
        this.rRN.expandGroup(this.rRZ);
        AppMethodBeat.o(39026);
        return;
        if (this.rRZ == 3)
        {
          this.rRT.rSv.clear();
          if (!bo.isNullOrNil(paramIntent))
          {
            paramIntent = bo.P(paramIntent.split(","));
            this.rRT.rSv.addAll(paramIntent);
            this.rRT.rSq = this.rRZ;
          }
        }
      }
    }
    if ((paramInt2 == -1) && (paramInt1 == 4001))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      ab.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (!bo.isNullOrNil(paramIntent))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("Select_Contact", paramIntent);
        d.b(this, "label", ".ui.ContactLabelEditUI", (Intent)localObject, 4002);
      }
      AppMethodBeat.o(39026);
      return;
    }
    if ((paramInt2 == 0) && (paramInt1 == 4002) && (paramIntent != null))
    {
      localObject = paramIntent.getStringExtra("k_sns_label_add_label");
      this.rSb = paramIntent.getStringExtra("k_sns_label_add_label");
      this.rRN.postDelayed(new SnsLabelUI.10(this, (String)localObject), 600L);
      AppMethodBeat.o(39026);
      return;
    }
    if ((paramInt2 == -1) && (paramInt1 == 4004))
    {
      ab.i("MicroMsg.SnsLabelUI", "the Activity completed");
      paramIntent = paramIntent.getStringExtra("select_chatrooms");
      this.rRS = paramIntent;
      ab.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(paramIntent) });
      if (this.rRZ != 2) {
        break label563;
      }
      this.rRT.rSw.clear();
      if (!bo.isNullOrNil(paramIntent))
      {
        paramIntent = bo.P(paramIntent.split(","));
        this.rRT.rSw.addAll(paramIntent);
        this.rRT.rSq = this.rRZ;
      }
    }
    for (;;)
    {
      this.rRT.notifyDataSetChanged();
      this.rRN.expandGroup(this.rRZ);
      AppMethodBeat.o(39026);
      return;
      label563:
      if (this.rRZ == 3)
      {
        this.rRT.rSx.clear();
        if (!bo.isNullOrNil(paramIntent))
        {
          paramIntent = bo.P(paramIntent.split(","));
          this.rRT.rSx.addAll(paramIntent);
          this.rRT.rSq = this.rRZ;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39024);
    super.onCreate(paramBundle);
    setMMTitle(2131304001);
    g.RM();
    g.RK().eHt.a(292, this);
    g.RM();
    g.RK().eHt.a(635, this);
    g.RM();
    g.RK().eHt.a(638, this);
    g.RM();
    g.RK().eHt.a(290, this);
    this.rRT = new ap(this);
    this.rRT.rSy = new ap.b()
    {
      public final void a(ap.c paramAnonymousc)
      {
        AppMethodBeat.i(39011);
        int i = paramAnonymousc.rSD;
        int j = paramAnonymousc.rSE;
        SnsLabelUI.a(SnsLabelUI.this, i, j);
        AppMethodBeat.o(39011);
      }
    };
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      this.rRU = 0;
      this.rRT.style = 0;
      this.rRQ = null;
      this.rRR = null;
      this.rRS = null;
      this.rRT.rSq = this.rRU;
      if (this.rRT.style == 1) {
        findViewById(2131828012).setBackgroundResource(2131689763);
      }
      if (this.rRU != 2) {
        break label465;
      }
      if (!TextUtils.isEmpty(this.rRQ)) {
        this.rRT.rSs = bo.P(this.rRQ.split(","));
      }
      if (!TextUtils.isEmpty(this.rRR)) {
        this.rRT.rSu = bo.P(this.rRR.split(","));
      }
      if ((this.rRS != null) && (!this.rRS.isEmpty())) {
        this.rRT.rSw = bo.P(this.rRS.split(","));
      }
    }
    for (;;)
    {
      g.RM();
      this.rRV = ((Boolean)g.RL().Ru().get(335873, Boolean.TRUE)).booleanValue();
      if (this.rRV)
      {
        this.rRX = true;
        this.rRY = true;
        if (cvv() > 0) {
          this.rRW = true;
        }
        g.RM();
        g.RK().eHt.a(new v(1), 0);
      }
      initView();
      AppMethodBeat.o(39024);
      return;
      this.rRU = paramBundle.getIntExtra("KLabel_range_index", 0);
      this.rRT.style = paramBundle.getIntExtra("k_sns_label_ui_style", 0);
      this.rRQ = paramBundle.getStringExtra("Klabel_name_list");
      this.rRR = paramBundle.getStringExtra("Kother_user_name_list");
      this.rRS = paramBundle.getStringExtra("Kchat_room_name_list");
      if (TextUtils.isEmpty(paramBundle.getStringExtra("k_sns_label_ui_title"))) {
        break;
      }
      setMMTitle(paramBundle.getStringExtra("k_sns_label_ui_title"));
      break;
      label465:
      if (this.rRU == 3)
      {
        if (!TextUtils.isEmpty(this.rRQ)) {
          this.rRT.rSt = bo.P(this.rRQ.split(","));
        }
        if (!TextUtils.isEmpty(this.rRR)) {
          this.rRT.rSv = bo.P(this.rRR.split(","));
        }
        if ((this.rRS != null) && (!this.rRS.isEmpty())) {
          this.rRT.rSx = bo.P(this.rRS.split(","));
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39031);
    g.RM();
    g.RK().eHt.b(292, this);
    g.RM();
    g.RK().eHt.b(635, this);
    g.RM();
    g.RK().eHt.b(638, this);
    g.RM();
    g.RK().eHt.b(290, this);
    super.onDestroy();
    AppMethodBeat.o(39031);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39032);
    if ((this.rRT != null) && (this.rSb == null) && (this.rRN != null)) {
      this.rRN.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(39012);
          a.bKV().ahN();
          SnsLabelUI.a(SnsLabelUI.this, (ArrayList)a.bKV().bKQ());
          SnsLabelUI.a(SnsLabelUI.this).S(SnsLabelUI.k(SnsLabelUI.this));
          SnsLabelUI.l(SnsLabelUI.this);
          if (((SnsLabelUI.k(SnsLabelUI.this) == null) || (SnsLabelUI.k(SnsLabelUI.this).size() == 0)) && ((SnsLabelUI.q(SnsLabelUI.this) == null) || (SnsLabelUI.q(SnsLabelUI.this).length() == 0)) && (SnsLabelUI.a(SnsLabelUI.this).rSq != 0) && (SnsLabelUI.a(SnsLabelUI.this).rSq != 1) && ((SnsLabelUI.r(SnsLabelUI.this) == null) || (SnsLabelUI.r(SnsLabelUI.this).length() == 0))) {
            SnsLabelUI.a(SnsLabelUI.this).rSq = 0;
          }
          SnsLabelUI.a(SnsLabelUI.this).notifyDataSetChanged();
          SnsLabelUI.n(SnsLabelUI.this);
          AppMethodBeat.o(39012);
        }
      }, 600L);
    }
    super.onResume();
    AppMethodBeat.o(39032);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(39033);
    ab.i("MicroMsg.SnsLabelUI", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!this.rRX)
    {
      AppMethodBeat.o(39033);
      return;
    }
    switch (paramm.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(39033);
      return;
      Object localObject;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = ag.cpl().getCursor();
        this.rSc = ((Cursor)localObject).getCount();
        if (this.rSc > 0)
        {
          ((Cursor)localObject).moveToFirst();
          t localt = new t();
          paramInt1 = ((Cursor)localObject).getCount();
          this.rSe = new ArrayList(paramInt1);
          this.rSd = new ArrayList(paramInt1);
          this.rSg = new ArrayList(paramInt1);
          this.rSf = new ArrayList(paramInt1);
          if (!((Cursor)localObject).isAfterLast())
          {
            localt.convertFrom((Cursor)localObject);
            if ((localt.field_memberList != null) && (localt.field_memberList.length() != 0))
            {
              this.rSg.add(localt.field_memberList.split(","));
              paramm = localt.field_tagName;
              ArrayList localArrayList = this.rSe;
              paramString = a.bKV().bKS();
              if (paramString == null)
              {
                paramString = paramm;
                label297:
                localArrayList.add(paramString);
                this.rSd.add(paramm);
                this.rSf.add(Long.valueOf(localt.field_tagId));
              }
            }
            for (;;)
            {
              ((Cursor)localObject).moveToNext();
              break;
              if (!paramString.contains(paramm))
              {
                paramString = paramm;
                break label297;
              }
              paramString = String.format(getString(2131303850), new Object[] { paramm });
              break label297;
              ab.e("MicroMsg.SnsLabelUI", "dz:snstaginfo memberlist is null.");
            }
          }
          ((Cursor)localObject).close();
          if (this.rSd.size() != 0) {
            break label508;
          }
          paramInt1 = 0;
          if (paramInt1 != 0) {}
        }
        else if (this.rRY)
        {
          this.rRT.rSq = this.rRZ;
          this.rRN.Ro(this.rRZ);
          g.RM();
          g.RL().Ru().set(335873, Boolean.FALSE);
        }
        ((Cursor)localObject).close();
        if (this.rRW)
        {
          this.rRX = true;
          a.bKV().cc(this.rSe);
        }
      }
      for (;;)
      {
        this.rRY = false;
        AppMethodBeat.o(39033);
        return;
        label508:
        paramInt1 = 1;
        break;
        this.rRX = false;
        continue;
        cvx();
        ab.i("MicroMsg.SnsLabelUI", "dz: error at get sns tag list!");
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        dn(this.rSg);
        AppMethodBeat.o(39033);
        return;
      }
      cvx();
      ab.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
      AppMethodBeat.o(39033);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.rSd.iterator();
        paramm = this.rSf.iterator();
        while (paramString.hasNext())
        {
          long l = ((Long)paramm.next()).longValue();
          localObject = (String)paramString.next();
          if (l != 0L)
          {
            g.RM();
            g.RK().eHt.a(new x(l, (String)localObject), 0);
          }
        }
        g.RM();
        g.RL().Ru().set(335874, Integer.valueOf(0));
        this.rRP = ((ArrayList)a.bKV().bKQ());
        paramString = com.tencent.mm.plugin.report.service.h.qsU;
        paramInt2 = this.rSc;
        if (this.rSe == null) {}
        for (paramInt1 = 0;; paramInt1 = this.rSe.size())
        {
          paramString.e(11455, new Object[] { "", "", Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
          this.rRN.postDelayed(new SnsLabelUI.3(this), 600L);
          g.RM();
          g.RL().Ru().set(335873, Boolean.FALSE);
          AppMethodBeat.o(39033);
          return;
        }
      }
      cvx();
      ab.i("MicroMsg.SnsLabelUI", "dz: error at modify label list!");
      AppMethodBeat.o(39033);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        ab.i("MicroMsg.SnsLabelUI", "dz: error at delete tag list!");
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