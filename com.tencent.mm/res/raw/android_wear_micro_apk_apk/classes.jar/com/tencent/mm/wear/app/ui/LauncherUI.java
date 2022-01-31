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
  private d aeC;
  private ListView aeD;
  private b aeE;
  private View aeF;
  private com.tencent.mm.sdk.a.e aeG = new com.tencent.mm.sdk.a.e() {};
  private com.tencent.mm.sdk.a.e aeH = new com.tencent.mm.sdk.a.e() {};
  private AdapterView.OnItemClickListener aeI = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      paramAnonymousInt -= LauncherUI.c(LauncherUI.this).getHeaderViewsCount();
      if ((paramAnonymousInt < 0) || (paramAnonymousInt > LauncherUI.d(LauncherUI.this).getCount() - 1)) {
        return;
      }
      paramAnonymousAdapterView = LauncherUI.d(LauncherUI.this).bT(paramAnonymousInt);
      if (paramAnonymousAdapterView.Vo.equals("supers_offline_pay"))
      {
        paramAnonymousAdapterView = new Intent(LauncherUI.this, PayUI.class);
        LauncherUI.this.startActivity(paramAnonymousAdapterView);
        return;
      }
      paramAnonymousView = new Intent(LauncherUI.this, MessageHistoryUI.class);
      paramAnonymousView.putExtra("key_talker", paramAnonymousAdapterView.Vo);
      LauncherUI.this.startActivity(paramAnonymousView);
    }
  };
  private boolean aeJ = false;
  private AbsListView.OnScrollListener aeK = new AbsListView.OnScrollListener()
  {
    public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
    {
      if ((paramAnonymousInt == 0) && (LauncherUI.c(LauncherUI.this).getLastVisiblePosition() == LauncherUI.d(LauncherUI.this).getCount() + LauncherUI.c(LauncherUI.this).getHeaderViewsCount()) && (!LauncherUI.e(LauncherUI.this)) && (LauncherUI.d(LauncherUI.this).mW()))
      {
        LauncherUI.f(LauncherUI.this);
        LauncherUI.g(LauncherUI.this).setVisibility(0);
      }
    }
  };
  
  private void mY()
  {
    if (h.mo())
    {
      if (h.mq())
      {
        N(h.mb().lT().Vm);
        this.aeD = ((ListView)findViewById(2131558457));
        View localView1 = getLayoutInflater().inflate(2130903056, null, false);
        this.aeF = localView1.findViewById(2131558458);
        this.aeF.setVisibility(8);
        if (!MMActivity.isRect())
        {
          this.aeD.setPadding(46, 0, 46, 0);
          View localView2 = new View(this);
          localView2.setLayoutParams(new AbsListView.LayoutParams(1, 60));
          this.aeD.addHeaderView(localView2);
          localView1.setPadding(0, 0, 0, 60);
        }
        this.aeD.addFooterView(localView1);
        this.aeE = new b(this);
        this.aeE.a(this);
        this.aeD.setAdapter(this.aeE);
        this.aeD.setOnItemClickListener(this.aeI);
        this.aeD.setOnScrollListener(this.aeK);
        this.aeE.mW();
        this.aeF.setVisibility(0);
        this.aeC.nD();
        this.aeD.setVisibility(0);
        com.tencent.mm.wear.app.d.a.bK(1);
        return;
      }
      h.mr();
      this.aeC.setTimeout(20000L);
      this.aeC.Q(getString(2131165243));
      this.aeC.R(getString(2131165212));
      this.aeC.startLoading();
      com.tencent.mm.sdk.a.a.WJ.a(this.aeH);
      return;
    }
    h.B(false);
    this.aeC.setTimeout(10000L);
    this.aeC.Q(getString(2131165244));
    this.aeC.R(getString(2131165214));
    this.aeC.startLoading();
    com.tencent.mm.sdk.a.a.WJ.a(this.aeG);
  }
  
  public final int getLayoutId()
  {
    return 2130903055;
  }
  
  public final void mX()
  {
    this.aeJ = false;
    this.aeF.setVisibility(8);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int k = 1;
    super.onCreate(paramBundle);
    z(MMApplication.getContext());
    this.aeC = new d(this);
    this.aeC.a(new com.tencent.mm.wear.app.ui.widget.e()
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
        mY();
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
    mY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.LauncherUI
 * JD-Core Version:    0.7.0.1
 */