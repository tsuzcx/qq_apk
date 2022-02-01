package com.tencent.mm.ui.base.preference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;

public abstract class MMPreference
  extends MMActivity
{
  public static final String TAG = "MicroMsg.mmui.MMPreference";
  private byte _hellAccFlag_;
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
    this.adapter.b(new Preference.a()
    {
      public final boolean a(Preference paramAnonymousPreference, Object paramAnonymousObject)
      {
        AppMethodBeat.i(142585);
        if ((!MMPreference.this.isRefreshing) && (paramAnonymousPreference.isEnabled()) && (paramAnonymousPreference.HFI))
        {
          MMPreference.access$002(MMPreference.this, true);
          if (!(paramAnonymousPreference instanceof CheckBoxPreference)) {
            break label171;
          }
          paramAnonymousObject = (CheckBoxPreference)paramAnonymousPreference;
          paramAnonymousObject.mF = paramAnonymousObject.isChecked();
          if (paramAnonymousObject.HFK) {
            MMPreference.this.sp.edit().putBoolean(paramAnonymousPreference.mKey, paramAnonymousObject.isChecked()).commit();
          }
          MMPreference.access$202(MMPreference.this, true);
        }
        label171:
        for (int i = 1;; i = 0)
        {
          if (paramAnonymousPreference.mKey != null) {
            MMPreference.this.onPreferenceTreeClick(MMPreference.this.adapter, paramAnonymousPreference);
          }
          if (i != 0) {
            MMPreference.this.adapter.notifyDataSetChanged();
          }
          MMPreference.access$002(MMPreference.this, false);
          if (i != 0)
          {
            AppMethodBeat.o(142585);
            return true;
          }
          AppMethodBeat.o(142585);
          return false;
        }
      }
    });
    int i = getResourceId();
    if (i != -1) {
      this.adapter.addPreferencesFromResource(i);
    }
    this.list.setAdapter(this.adapter);
    this.list.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, final View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(142588);
        paramAnonymousAdapterView = (Preference)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          AppMethodBeat.o(142588);
          return;
        }
        if ((paramAnonymousAdapterView.isEnabled()) && (paramAnonymousAdapterView.HFI))
        {
          if ((paramAnonymousAdapterView instanceof CheckBoxPreference))
          {
            AppMethodBeat.o(142588);
            return;
          }
          if ((paramAnonymousAdapterView instanceof DialogPreference))
          {
            paramAnonymousView = (DialogPreference)paramAnonymousAdapterView;
            paramAnonymousView.showDialog();
            paramAnonymousView.HDW = new DialogPreference.a()
            {
              public final void fjj()
              {
                AppMethodBeat.i(142586);
                MMPreference.access$202(MMPreference.this, true);
                if (paramAnonymousView.HFK) {
                  MMPreference.this.sp.edit().putString(paramAnonymousAdapterView.mKey, paramAnonymousView.getValue()).commit();
                }
                MMPreference.this.adapter.notifyDataSetChanged();
                AppMethodBeat.o(142586);
              }
            };
          }
          if ((paramAnonymousAdapterView instanceof EditPreference))
          {
            paramAnonymousView = (EditPreference)paramAnonymousAdapterView;
            paramAnonymousView.showDialog();
            paramAnonymousView.HDY = new EditPreference.a()
            {
              public final void fjj()
              {
                AppMethodBeat.i(142587);
                MMPreference.access$202(MMPreference.this, true);
                if (paramAnonymousView.HFK) {
                  MMPreference.this.sp.edit().putString(paramAnonymousAdapterView.mKey, paramAnonymousView.value).commit();
                }
                MMPreference.this.adapter.notifyDataSetChanged();
                AppMethodBeat.o(142587);
              }
            };
          }
          if (paramAnonymousAdapterView.mKey != null) {
            MMPreference.this.onPreferenceTreeClick(MMPreference.this.adapter, paramAnonymousAdapterView);
          }
        }
        AppMethodBeat.o(142588);
      }
    });
    this.list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(142589);
        if (paramAnonymousInt < MMPreference.this.list.getHeaderViewsCount())
        {
          AppMethodBeat.o(142589);
          return false;
        }
        paramAnonymousInt -= MMPreference.this.list.getHeaderViewsCount();
        if (paramAnonymousInt >= MMPreference.this.adapter.getCount())
        {
          ac.e("MicroMsg.mmui.MMPreference", "itemlongclick, outofindex, %d, %d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(MMPreference.this.adapter.getCount()) });
          AppMethodBeat.o(142589);
          return false;
        }
        paramAnonymousAdapterView = (Preference)MMPreference.this.adapter.getItem(paramAnonymousInt);
        boolean bool = MMPreference.this.onPreferenceTreeLongClick(MMPreference.this.adapter, paramAnonymousAdapterView, MMPreference.this.list);
        AppMethodBeat.o(142589);
        return bool;
      }
    });
    this.list.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(142590);
        if (1 == paramAnonymousInt)
        {
          paramAnonymousAbsListView = MMPreference.this.getCurrentFocus();
          if (paramAnonymousAbsListView != null) {
            paramAnonymousAbsListView.clearFocus();
          }
        }
        AppMethodBeat.o(142590);
      }
    });
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
    return 2131494873;
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
    this.bannerView = ((RelativeLayout)findViewById(2131303382));
    this.bannerTv = ((TextView)findViewById(2131303381));
    this.bannerCloseBtn = ((ImageView)findViewById(2131303380));
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
        FrameLayout localFrameLayout = (FrameLayout)findViewById(2131303378);
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
        ac.e("MicroMsg.mmui.MMPreference", "[arthurdan.mmpreference] Notice!!! header.getLayoutParams() is null!!!\n");
      }
    }
    if (paramBundle.getLayoutParams() != null) {
      paramBundle.setLayoutParams(new AbsListView.LayoutParams(paramBundle.getLayoutParams()));
    }
    for (;;)
    {
      this.list.addFooterView(paramBundle);
      break;
      ac.e("MicroMsg.mmui.MMPreference", "[arthurdan.mmpreference] Notice!!! footer.getLayoutParams() is null!!!\n");
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
    Object localObject1 = this.list;
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/ui/base/preference/MMPreference", "onSetToTop", "()Z", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    BackwardSupportUtil.c.b((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/base/preference/MMPreference", "onSetToTop", "()Z", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreference
 * JD-Core Version:    0.7.0.1
 */