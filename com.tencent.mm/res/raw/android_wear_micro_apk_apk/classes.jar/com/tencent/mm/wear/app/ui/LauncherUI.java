package com.tencent.mm.wear.app.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.e.a.m;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.b.g;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.ui.pay.PayUI;
import com.tencent.mm.wear.app.ui.widget.d;
import java.util.ArrayList;

public class LauncherUI
  extends MMAvatarActivity
  implements c
{
  private d aie;
  private ListView aif;
  private b aig;
  private View aih;
  private com.tencent.mm.sdk.a.e aii = new com.tencent.mm.sdk.a.e() {};
  private com.tencent.mm.sdk.a.e aij = new com.tencent.mm.sdk.a.e() {};
  private AdapterView.OnItemClickListener aik = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      paramAnonymousInt -= LauncherUI.c(LauncherUI.this).getHeaderViewsCount();
      if ((paramAnonymousInt < 0) || (paramAnonymousInt > LauncherUI.d(LauncherUI.this).getCount() - 1)) {
        return;
      }
      paramAnonymousAdapterView = LauncherUI.d(LauncherUI.this).cp(paramAnonymousInt);
      if (paramAnonymousAdapterView.Xj.equals("supers_offline_pay"))
      {
        paramAnonymousAdapterView = new Intent(LauncherUI.this, PayUI.class);
        LauncherUI.this.startActivity(paramAnonymousAdapterView);
        return;
      }
      paramAnonymousView = new Intent(LauncherUI.this, MessageHistoryUI.class);
      paramAnonymousView.putExtra("key_talker", paramAnonymousAdapterView.Xj);
      LauncherUI.this.startActivity(paramAnonymousView);
    }
  };
  private boolean ail = false;
  private AbsListView.OnScrollListener aim = new AbsListView.OnScrollListener()
  {
    public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
    {
      if ((paramAnonymousInt == 0) && (LauncherUI.c(LauncherUI.this).getLastVisiblePosition() == LauncherUI.d(LauncherUI.this).getCount() + LauncherUI.c(LauncherUI.this).getHeaderViewsCount()) && (!LauncherUI.e(LauncherUI.this)) && (LauncherUI.d(LauncherUI.this).nI()))
      {
        LauncherUI.f(LauncherUI.this);
        LauncherUI.g(LauncherUI.this).setVisibility(0);
      }
    }
  };
  
  private void nK()
  {
    if (h.na())
    {
      if (h.nc())
      {
        U(h.mO().mG().Xh);
        nL();
        this.aig.nI();
        this.aih.setVisibility(0);
        this.aie.or();
        this.aif.setVisibility(0);
        com.tencent.mm.wear.app.d.a.cg(1);
        return;
      }
      h.nd();
      this.aie.setTimeout(20000L);
      this.aie.X(getString(2131165244));
      this.aie.Y(getString(2131165212));
      this.aie.startLoading();
      com.tencent.mm.sdk.a.a.YM.a(this.aij);
      return;
    }
    h.E(false);
    this.aie.setTimeout(10000L);
    this.aie.X(getString(2131165245));
    this.aie.Y(getString(2131165214));
    this.aie.startLoading();
    com.tencent.mm.sdk.a.a.YM.a(this.aii);
  }
  
  private void nL()
  {
    this.aif = ((ListView)findViewById(2131558458));
    View localView1 = getLayoutInflater().inflate(2130903056, null, false);
    this.aih = localView1.findViewById(2131558459);
    this.aih.setVisibility(8);
    if (!MMActivity.isRect())
    {
      this.aif.setPadding(46, 0, 46, 0);
      View localView2 = new View(this);
      localView2.setLayoutParams(new AbsListView.LayoutParams(1, 60));
      this.aif.addHeaderView(localView2);
      localView1.setPadding(0, 0, 0, 60);
    }
    this.aif.addFooterView(localView1);
    this.aig = new b(this);
    this.aig.a(this);
    this.aif.setAdapter(this.aig);
    this.aif.setOnItemClickListener(this.aik);
    this.aif.setOnScrollListener(this.aim);
  }
  
  public final int getLayoutId()
  {
    return 2130903055;
  }
  
  public final void nJ()
  {
    this.ail = false;
    this.aih.setVisibility(8);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int k = 1;
    super.onCreate(paramBundle);
    A(MMApplication.getContext());
    this.aie = new d(this);
    this.aie.a(new com.tencent.mm.wear.app.ui.widget.e()
    {
      public final void onStart()
      {
        LauncherUI.a(LauncherUI.this);
      }
    });
    int i;
    if (Build.VERSION.SDK_INT < 23)
    {
      i = k;
      if (i != 0) {
        nK();
      }
      return;
    }
    if (android.support.v4.content.a.b(this, "android.permission.BODY_SENSORS") == 0)
    {
      i = 1;
      label73:
      if (android.support.v4.content.a.b(this, "android.permission.RECORD_AUDIO") != 0) {
        break label160;
      }
    }
    label160:
    for (int j = 1;; j = 0)
    {
      paramBundle = new ArrayList();
      if (i == 0) {
        paramBundle.add("android.permission.BODY_SENSORS");
      }
      if (j == 0) {
        paramBundle.add("android.permission.RECORD_AUDIO");
      }
      if (paramBundle.size() > 0) {
        android.support.v4.app.a.a(this, (String[])paramBundle.toArray(new String[0]));
      }
      if (i != 0)
      {
        i = k;
        if (j != 0) {
          break;
        }
      }
      i = 0;
      break;
      i = 0;
      break label73;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    nK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.LauncherUI
 * JD-Core Version:    0.7.0.1
 */