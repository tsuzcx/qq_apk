package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SnsLabelUI
  extends MMActivity
  implements f
{
  public static int[] oZv = { i.j.sns_label_public, i.j.sns_label_private, i.j.sns_label_include, i.j.sns_label_exclude };
  private int oZA = 0;
  private boolean oZB;
  private boolean oZC = false;
  private boolean oZD = false;
  private boolean oZE = false;
  private int oZF;
  private com.tencent.mm.ui.base.p oZG;
  private String oZH;
  private int oZI;
  private ArrayList<String> oZJ;
  private ArrayList<String> oZK;
  private ArrayList<Long> oZL;
  private ArrayList<String[]> oZM;
  private AnimatedExpandableListView oZu;
  private ArrayList<String> oZw;
  private String oZx;
  private String oZy;
  ap oZz;
  
  private void bIX()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Ktag_range_index", this.oZA);
    if ((this.oZA == 2) || (this.oZA == 3))
    {
      bJc();
      localIntent.putExtra("Klabel_name_list", this.oZx);
      localIntent.putExtra("Kother_user_name_list", this.oZy);
    }
    setResult(-1, localIntent);
    finish();
  }
  
  private static int bIZ()
  {
    g.DQ();
    return ((Integer)g.DP().Dz().get(335874, Integer.valueOf(0))).intValue();
  }
  
  private void bJa()
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(11455, new Object[] { "", "", Integer.valueOf(this.oZI), Integer.valueOf(0) });
    g.DQ();
    int i = ((Integer)g.DP().Dz().get(335874, Integer.valueOf(0))).intValue();
    g.DQ();
    g.DP().Dz().o(335874, Integer.valueOf(i + 1));
    this.oZK = null;
    this.oZE = false;
    this.oZD = false;
    if ((this.oZG != null) && (this.oZG.isShowing())) {
      this.oZG.dismiss();
    }
    if (this.oZC)
    {
      this.oZC = false;
      return;
    }
    i = i.j.sns_label_transform_failed_once;
    if (bIZ() > 1) {
      i = i.j.sns_label_transform_failed_again;
    }
    com.tencent.mm.ui.base.h.a(this, i, i.j.app_ok, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
  }
  
  private void bJb()
  {
    if ((this.oZw == null) || (this.oZw.isEmpty()))
    {
      if (this.oZz.oZV != null) {
        this.oZz.oZV.clear();
      }
      if (this.oZz.oZW != null) {
        this.oZz.oZW.clear();
      }
    }
    ArrayList localArrayList;
    String str;
    do
    {
      return;
      localArrayList = new ArrayList();
      if ((this.oZA == 2) && (this.oZz.oZV != null))
      {
        localIterator = this.oZz.oZV.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (!this.oZw.contains(str)) {
            localArrayList.add(str);
          }
        }
        this.oZz.oZV.removeAll(localArrayList);
        return;
      }
    } while (this.oZA != 3);
    Iterator localIterator = this.oZz.oZW.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!this.oZw.contains(str)) {
        localArrayList.add(str);
      }
    }
    this.oZz.oZW.removeAll(localArrayList);
  }
  
  private void bJc()
  {
    if ((this.oZw == null) || (this.oZw.isEmpty())) {
      this.oZx = "";
    }
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    do
    {
      do
      {
        return;
        localArrayList1 = new ArrayList();
      } while (this.oZx == null);
      localArrayList2 = bk.G(this.oZx.split(","));
    } while (localArrayList2 == null);
    Iterator localIterator = localArrayList2.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!this.oZw.contains(str)) {
        localArrayList1.add(str);
      }
    }
    localArrayList2.removeAll(localArrayList1);
    this.oZx = bk.c(localArrayList2, ",");
  }
  
  private void cH(List<String[]> paramList)
  {
    if ((this.oZK == null) || (this.oZK.size() == 0)) {
      return;
    }
    Iterator localIterator = this.oZK.iterator();
    paramList = paramList.iterator();
    ArrayList localArrayList1 = new ArrayList(this.oZK.size());
    ArrayList localArrayList2 = new ArrayList(this.oZK.size());
    while (localIterator.hasNext())
    {
      localArrayList1.add(a.bdA().Gl((String)localIterator.next()));
      localArrayList2.add(bk.c(Arrays.asList((Object[])paramList.next()), ","));
      this.oZD = true;
    }
    a.bdA().h(localArrayList1, localArrayList2);
  }
  
  private void goBack()
  {
    int j = 0;
    int k = this.oZz.oZT;
    int i;
    if (this.oZz.oZT != this.oZA) {
      if (((k == 2) && ((this.oZz.oZV.size() != 0) || (this.oZz.oZX.size() != 0))) || ((k == 3) && ((this.oZz.oZW.size() != 0) || (this.oZz.oZY.size() != 0)))) {
        i = 1;
      }
    }
    while (i != 0)
    {
      com.tencent.mm.ui.base.h.a(this, true, getString(i.j.sns_label_goback_tip), "", getString(i.j.sns_label_goback_save), getString(i.j.sns_label_goback_notsave), new SnsLabelUI.11(this), new SnsLabelUI.12(this));
      return;
      if (k != 1)
      {
        i = j;
        if (k != 0) {}
      }
      else
      {
        i = 1;
        continue;
        if ((k != 2) || (this.oZz.oZV.size() == 0) || ((bk.c(this.oZz.oZV, ",").equals(this.oZx)) && (bk.c(this.oZz.oZX, ",").equals(this.oZy))))
        {
          i = j;
          if (k != 3) {
            continue;
          }
          i = j;
          if (this.oZz.oZW.size() == 0) {
            continue;
          }
          if (bk.c(this.oZz.oZW, ",").equals(this.oZx))
          {
            i = j;
            if (bk.c(this.oZz.oZY, ",").equals(this.oZy)) {
              continue;
            }
          }
        }
        i = 1;
      }
    }
    bIX();
  }
  
  final void bIY()
  {
    Intent localIntent = new Intent();
    if (this.oZz.oZT == 2)
    {
      this.oZx = bk.c(this.oZz.oZV, ",");
      this.oZy = bk.c(this.oZz.oZX, ",");
      bJc();
      localIntent.putExtra("Klabel_name_list", this.oZx);
      localIntent.putExtra("Kother_user_name_list", this.oZy);
    }
    for (;;)
    {
      localIntent.putExtra("Ktag_range_index", this.oZz.oZT);
      setResult(-1, localIntent);
      finish();
      return;
      if (this.oZz.oZT == 3)
      {
        this.oZx = bk.c(this.oZz.oZW, ",");
        this.oZy = bk.c(this.oZz.oZY, ",");
        bJc();
        localIntent.putExtra("Klabel_name_list", this.oZx);
        localIntent.putExtra("Kother_user_name_list", this.oZy);
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      goBack();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected final int getLayoutId()
  {
    return i.g.sns_label;
  }
  
  protected final void initView()
  {
    boolean bool = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
    this.oZu = ((AnimatedExpandableListView)findViewById(i.f.sns_label_exlist));
    this.oZw = ((ArrayList)a.bdA().bdv());
    this.oZz.oZU = bool;
    this.oZz.Q(this.oZw);
    bJb();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    localLayoutParams.height = getResources().getDimensionPixelSize(i.d.LargerPadding);
    View localView = new View(this);
    localView.setLayoutParams(localLayoutParams);
    this.oZu.addHeaderView(localView);
    this.oZu.setAdapter(this.oZz);
    if (this.oZz.oZT == 2) {
      this.oZu.expandGroup(2);
    }
    for (;;)
    {
      this.oZu.setOnGroupClickListener(new SnsLabelUI.5(this));
      this.oZu.setOnChildClickListener(new SnsLabelUI.6(this));
      setBackBtn(new SnsLabelUI.7(this));
      a(0, getString(i.j.sns_label_finish), new SnsLabelUI.8(this), s.b.uNx);
      return;
      if (this.oZz.oZT == 3) {
        this.oZu.expandGroup(3);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 4003))
    {
      y.i("MicroMsg.SnsLabelUI", "the Activity completed");
      localObject = paramIntent.getStringExtra("Select_Contacts_To_Create_New_Label");
      if (!bk.bl((String)localObject))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("Select_Contact", (String)localObject);
        d.b(this.mController.uMN, "label", ".ui.ContactLabelEditUI", paramIntent, 4002);
      }
    }
    do
    {
      do
      {
        return;
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        this.oZy = new String(paramIntent);
        y.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { paramIntent });
        if (this.oZF == 2)
        {
          this.oZz.oZX.clear();
          if (!bk.bl(paramIntent))
          {
            paramIntent = bk.G(paramIntent.split(","));
            this.oZz.oZX.addAll(paramIntent);
            this.oZz.oZT = this.oZF;
          }
        }
        for (;;)
        {
          this.oZz.notifyDataSetChanged();
          this.oZu.expandGroup(this.oZF);
          return;
          if (this.oZF == 3)
          {
            this.oZz.oZY.clear();
            if (!bk.bl(paramIntent))
            {
              paramIntent = bk.G(paramIntent.split(","));
              this.oZz.oZY.addAll(paramIntent);
              this.oZz.oZT = this.oZF;
            }
          }
        }
        if ((paramInt2 != -1) || (paramInt1 != 4001)) {
          break;
        }
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        y.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[] { paramIntent });
      } while (bk.bl(paramIntent));
      localObject = new Intent();
      ((Intent)localObject).putExtra("Select_Contact", paramIntent);
      d.b(this, "label", ".ui.ContactLabelEditUI", (Intent)localObject, 4002);
      return;
    } while ((paramInt2 != 0) || (paramInt1 != 4002) || (paramIntent == null));
    Object localObject = paramIntent.getStringExtra("k_sns_label_add_label");
    this.oZH = paramIntent.getStringExtra("k_sns_label_add_label");
    this.oZu.postDelayed(new SnsLabelUI.10(this, (String)localObject), 600L);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(i.j.sns_tag_title);
    g.DQ();
    g.DO().dJT.a(292, this);
    g.DQ();
    g.DO().dJT.a(635, this);
    g.DQ();
    g.DO().dJT.a(638, this);
    g.DQ();
    g.DO().dJT.a(290, this);
    this.oZz = new ap(this);
    this.oZz.oZZ = new SnsLabelUI.1(this);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      this.oZA = 0;
      this.oZz.style = 0;
      this.oZx = null;
      this.oZy = null;
      this.oZz.oZT = this.oZA;
      if (this.oZz.style == 1) {
        findViewById(i.f.sns_label_layout).setBackgroundResource(i.c.black);
      }
      if (this.oZA != 2) {
        break label402;
      }
      if (!TextUtils.isEmpty(this.oZx)) {
        this.oZz.oZV = bk.G(this.oZx.split(","));
      }
      if (!TextUtils.isEmpty(this.oZy)) {
        this.oZz.oZX = bk.G(this.oZy.split(","));
      }
    }
    for (;;)
    {
      g.DQ();
      this.oZB = ((Boolean)g.DP().Dz().get(335873, Boolean.valueOf(true))).booleanValue();
      if (this.oZB)
      {
        this.oZD = true;
        this.oZE = true;
        if (bIZ() > 0) {
          this.oZC = true;
        }
        g.DQ();
        g.DO().dJT.a(new v(1), 0);
      }
      initView();
      return;
      this.oZA = paramBundle.getIntExtra("KLabel_range_index", 0);
      this.oZz.style = paramBundle.getIntExtra("k_sns_label_ui_style", 0);
      this.oZx = paramBundle.getStringExtra("Klabel_name_list");
      this.oZy = paramBundle.getStringExtra("Kother_user_name_list");
      if (TextUtils.isEmpty(paramBundle.getStringExtra("k_sns_label_ui_title"))) {
        break;
      }
      setMMTitle(paramBundle.getStringExtra("k_sns_label_ui_title"));
      break;
      label402:
      if (this.oZA == 3)
      {
        if (!TextUtils.isEmpty(this.oZx)) {
          this.oZz.oZW = bk.G(this.oZx.split(","));
        }
        if (!TextUtils.isEmpty(this.oZy)) {
          this.oZz.oZY = bk.G(this.oZy.split(","));
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    g.DQ();
    g.DO().dJT.b(292, this);
    g.DQ();
    g.DO().dJT.b(635, this);
    g.DQ();
    g.DO().dJT.b(638, this);
    g.DQ();
    g.DO().dJT.b(290, this);
    super.onDestroy();
  }
  
  public void onResume()
  {
    if ((this.oZz != null) && (this.oZH == null) && (this.oZu != null)) {
      this.oZu.postDelayed(new SnsLabelUI.2(this), 600L);
    }
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.SnsLabelUI", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!this.oZD) {}
    do
    {
      return;
      switch (paramm.getType())
      {
      default: 
        return;
      }
    } while ((paramInt1 == 0) && (paramInt2 == 0));
    y.i("MicroMsg.SnsLabelUI", "dz: error at delete tag list!");
    return;
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      localObject = af.bDL().getCursor();
      this.oZI = ((Cursor)localObject).getCount();
      if (this.oZI > 0)
      {
        ((Cursor)localObject).moveToFirst();
        t localt = new t();
        paramInt1 = ((Cursor)localObject).getCount();
        this.oZK = new ArrayList(paramInt1);
        this.oZJ = new ArrayList(paramInt1);
        this.oZM = new ArrayList(paramInt1);
        this.oZL = new ArrayList(paramInt1);
        if (!((Cursor)localObject).isAfterLast())
        {
          localt.d((Cursor)localObject);
          if ((localt.field_memberList != null) && (localt.field_memberList.length() != 0))
          {
            this.oZM.add(localt.field_memberList.split(","));
            paramm = localt.field_tagName;
            ArrayList localArrayList = this.oZK;
            paramString = a.bdA().bdx();
            if (paramString == null)
            {
              paramString = paramm;
              label298:
              localArrayList.add(paramString);
              this.oZJ.add(paramm);
              this.oZL.add(Long.valueOf(localt.field_tagId));
            }
          }
          for (;;)
          {
            ((Cursor)localObject).moveToNext();
            break;
            if (!paramString.contains(paramm))
            {
              paramString = paramm;
              break label298;
            }
            paramString = String.format(getString(i.j.sns_label_from_tag_suffix), new Object[] { paramm });
            break label298;
            y.e("MicroMsg.SnsLabelUI", "dz:snstaginfo memberlist is null.");
          }
        }
        ((Cursor)localObject).close();
        if (this.oZJ.size() != 0) {
          break label504;
        }
        paramInt1 = 0;
        if (paramInt1 != 0) {}
      }
      else if (this.oZE)
      {
        this.oZz.oZT = this.oZF;
        this.oZu.Iw(this.oZF);
        g.DQ();
        g.DP().Dz().o(335873, Boolean.valueOf(false));
      }
      ((Cursor)localObject).close();
      if (this.oZC)
      {
        this.oZD = true;
        a.bdA().bF(this.oZK);
      }
    }
    for (;;)
    {
      this.oZE = false;
      return;
      label504:
      paramInt1 = 1;
      break;
      this.oZD = false;
      continue;
      bJa();
      y.i("MicroMsg.SnsLabelUI", "dz: error at get sns tag list!");
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      cH(this.oZM);
      return;
    }
    bJa();
    y.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
    return;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.oZJ.iterator();
      paramm = this.oZL.iterator();
      while (paramString.hasNext())
      {
        long l = ((Long)paramm.next()).longValue();
        localObject = (String)paramString.next();
        if (l != 0L)
        {
          g.DQ();
          g.DO().dJT.a(new x(l, (String)localObject), 0);
        }
      }
      g.DQ();
      g.DP().Dz().o(335874, Integer.valueOf(0));
      this.oZw = ((ArrayList)a.bdA().bdv());
      com.tencent.mm.plugin.report.service.h.nFQ.f(11455, new Object[] { "", "", Integer.valueOf(this.oZI), Integer.valueOf(this.oZK.size()) });
      this.oZu.postDelayed(new SnsLabelUI.3(this), 600L);
      g.DQ();
      g.DP().Dz().o(335873, Boolean.valueOf(false));
      return;
    }
    bJa();
    y.i("MicroMsg.SnsLabelUI", "dz: error at modify label list!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI
 * JD-Core Version:    0.7.0.1
 */