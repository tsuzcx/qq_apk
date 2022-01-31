package com.tencent.mm.ui.base.preference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public abstract class MMPreference
  extends MMActivity
{
  public static final String TAG = "MicroMsg.mmui.MMPreference";
  private h adapter;
  protected ImageView bannerCloseBtn;
  protected TextView bannerTv;
  protected RelativeLayout bannerView;
  private boolean dirty = false;
  private boolean isRefreshing = false;
  private ListView list;
  private SharedPreferences sp;
  
  private void setupList()
  {
    this.adapter.b(new MMPreference.1(this));
    int i = getResourceId();
    if (i != -1) {
      this.adapter.addPreferencesFromResource(i);
    }
    this.list.setAdapter(this.adapter);
    this.list.setOnItemClickListener(new MMPreference.2(this));
    this.list.setOnItemLongClickListener(new MMPreference.3(this));
    this.list.setOnScrollListener(new MMPreference.4(this));
  }
  
  protected boolean autoRefresh()
  {
    return true;
  }
  
  public h createAdapter(SharedPreferences paramSharedPreferences)
  {
    return new h(this, getListView(), paramSharedPreferences);
  }
  
  public void createUI()
  {
    this.list.setAdapter(this.adapter);
  }
  
  public boolean dirty()
  {
    return this.dirty;
  }
  
  protected void doPrepareData() {}
  
  public View getBottomView()
  {
    return null;
  }
  
  public SharedPreferences getDefaultSharedPreferences()
  {
    return this.sp;
  }
  
  public int getFooterResourceId()
  {
    return -1;
  }
  
  public View getFooterView()
  {
    return null;
  }
  
  public int getHeaderResourceId()
  {
    return -1;
  }
  
  public View getHeaderView()
  {
    return null;
  }
  
  public int getLayoutId()
  {
    return 2130970245;
  }
  
  public ListView getListView()
  {
    return this.list;
  }
  
  public f getPreferenceScreen()
  {
    return this.adapter;
  }
  
  public abstract int getResourceId();
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return super.onContextItemSelected(paramMenuItem);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    this.list = ((ListView)findViewById(16908298));
    this.adapter = createAdapter(this.sp);
    this.bannerView = ((RelativeLayout)findViewById(2131826248));
    this.bannerTv = ((TextView)findViewById(2131826250));
    this.bannerCloseBtn = ((ImageView)findViewById(2131826249));
    doPrepareData();
    int i = getHeaderResourceId();
    paramBundle = getHeaderView();
    if (i != -1)
    {
      paramBundle = getLayoutInflater().inflate(i, null);
      this.list.addHeaderView(paramBundle);
      i = getFooterResourceId();
      paramBundle = getFooterView();
      if (i == -1) {
        break label251;
      }
      paramBundle = getLayoutInflater().inflate(i, null);
      this.list.addFooterView(paramBundle);
    }
    label251:
    while (paramBundle == null)
    {
      paramBundle = getBottomView();
      if (paramBundle != null)
      {
        FrameLayout localFrameLayout = (FrameLayout)findViewById(2131826251);
        localFrameLayout.addView(paramBundle);
        localFrameLayout.setVisibility(0);
      }
      setupList();
      return;
      if (paramBundle == null) {
        break;
      }
      if (paramBundle.getLayoutParams() != null) {
        paramBundle.setLayoutParams(new AbsListView.LayoutParams(paramBundle.getLayoutParams()));
      }
      for (;;)
      {
        this.list.addHeaderView(paramBundle);
        break;
        ab.e("MicroMsg.mmui.MMPreference", "[arthurdan.mmpreference] Notice!!! header.getLayoutParams() is null!!!\n");
      }
    }
    if (paramBundle.getLayoutParams() != null) {
      paramBundle.setLayoutParams(new AbsListView.LayoutParams(paramBundle.getLayoutParams()));
    }
    for (;;)
    {
      this.list.addFooterView(paramBundle);
      break;
      ab.e("MicroMsg.mmui.MMPreference", "[arthurdan.mmpreference] Notice!!! footer.getLayoutParams() is null!!!\n");
    }
  }
  
  public abstract boolean onPreferenceTreeClick(f paramf, Preference paramPreference);
  
  public boolean onPreferenceTreeLongClick(f paramf, Preference paramPreference, View paramView)
  {
    return false;
  }
  
  public void onResume()
  {
    if (autoRefresh()) {
      this.adapter.notifyDataSetChanged();
    }
    super.onResume();
  }
  
  public boolean onSetToTop()
  {
    BackwardSupportUtil.c.a(this.list);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void releaseUI()
  {
    this.list.setAdapter(null);
  }
  
  public void setSelection(int paramInt)
  {
    this.list.setSelection(paramInt);
  }
  
  public void updateAdapter(h paramh)
  {
    this.adapter = paramh;
    setupList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreference
 * JD-Core Version:    0.7.0.1
 */