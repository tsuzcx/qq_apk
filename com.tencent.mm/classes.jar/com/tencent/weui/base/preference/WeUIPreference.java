package com.tencent.weui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.mm.ui.bc;

public abstract class WeUIPreference
  extends BaseActivity
{
  public b aicv;
  protected ImageView bannerCloseBtn;
  protected TextView bannerTv;
  protected RelativeLayout bannerView;
  private boolean dirty = false;
  private boolean isRefreshing = false;
  private ListView list;
  private SharedPreferences sp;
  
  public static boolean keH()
  {
    return false;
  }
  
  public abstract boolean a(a parama, Preference paramPreference);
  
  public int getFooterResourceId()
  {
    return -1;
  }
  
  public final int getLayoutId()
  {
    return a.g.mm_preference_list_content;
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
    this.aicv = new b(this, this.sp);
    this.list = ((ListView)findViewById(16908298));
    this.bannerView = ((RelativeLayout)findViewById(a.f.preference_tips_banner_view));
    this.bannerTv = ((TextView)findViewById(a.f.preference_tips_banner_tv));
    this.bannerCloseBtn = ((ImageView)findViewById(a.f.preference_tips_banner_close));
    int i = getFooterResourceId();
    if (i != -1)
    {
      paramBundle = getLayoutInflater().inflate(i, null);
      this.list.addFooterView(paramBundle);
    }
    paramBundle = this.aicv;
    paramBundle.aicz = new Preference.OnPreferenceChangeListener()
    {
      public final boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
      {
        AppMethodBeat.i(159997);
        if ((!WeUIPreference.a(WeUIPreference.this)) && (paramAnonymousPreference.isEnabled()) && (paramAnonymousPreference.isSelectable()))
        {
          WeUIPreference.a(WeUIPreference.this, true);
          if (!(paramAnonymousPreference instanceof CheckBoxPreference)) {
            break label170;
          }
          paramAnonymousObject = (CheckBoxPreference)paramAnonymousPreference;
          paramAnonymousObject.duj = paramAnonymousObject.isChecked();
          if (paramAnonymousObject.isPersistent()) {
            WeUIPreference.b(WeUIPreference.this).edit().putBoolean(paramAnonymousPreference.getKey(), paramAnonymousObject.isChecked()).commit();
          }
          WeUIPreference.c(WeUIPreference.this);
        }
        label170:
        for (int i = 1;; i = 0)
        {
          if (paramAnonymousPreference.getKey() != null) {
            WeUIPreference.this.a(WeUIPreference.d(WeUIPreference.this), paramAnonymousPreference);
          }
          if (i != 0) {
            WeUIPreference.d(WeUIPreference.this).notifyDataSetChanged();
          }
          WeUIPreference.a(WeUIPreference.this, false);
          if (i != 0)
          {
            AppMethodBeat.o(159997);
            return true;
          }
          AppMethodBeat.o(159997);
          return false;
        }
      }
    };
    paramBundle.notifyDataSetChanged();
    i = getResourceId();
    b localb;
    c localc;
    if (i != -1)
    {
      localb = this.aicv;
      localb.aicy = true;
      localc = localb.aicx;
      paramBundle = localc.mContext.getResources().getXml(i);
      if (paramBundle == null) {}
    }
    try
    {
      localc.a(paramBundle, localb);
      paramBundle.close();
      localb.aicy = false;
      localb.notifyDataSetChanged();
      this.list.setAdapter(this.aicv);
      this.list.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(159998);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/weui/base/preference/WeUIPreference$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          paramAnonymousAdapterView = (Preference)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/weui/base/preference/WeUIPreference$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(159998);
            return;
          }
          if ((paramAnonymousAdapterView.isEnabled()) && (paramAnonymousAdapterView.isSelectable()))
          {
            if ((paramAnonymousAdapterView instanceof CheckBoxPreference))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/weui/base/preference/WeUIPreference$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(159998);
              return;
            }
            if (paramAnonymousAdapterView.getKey() != null) {
              WeUIPreference.this.a(WeUIPreference.d(WeUIPreference.this), paramAnonymousAdapterView);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/weui/base/preference/WeUIPreference$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(159998);
        }
      });
      this.list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(159999);
          if (paramAnonymousInt < WeUIPreference.e(WeUIPreference.this).getHeaderViewsCount())
          {
            AppMethodBeat.o(159999);
            return false;
          }
          paramAnonymousInt -= WeUIPreference.e(WeUIPreference.this).getHeaderViewsCount();
          if (paramAnonymousInt >= WeUIPreference.d(WeUIPreference.this).getCount())
          {
            bc.e("MicroMsg.mmui.WeUIPreference", "itemlongclick, outofindex, %d, %d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(WeUIPreference.d(WeUIPreference.this).getCount()) });
            AppMethodBeat.o(159999);
            return false;
          }
          WeUIPreference.d(WeUIPreference.this).getItem(paramAnonymousInt);
          WeUIPreference.d(WeUIPreference.this);
          WeUIPreference.e(WeUIPreference.this);
          boolean bool = WeUIPreference.keH();
          AppMethodBeat.o(159999);
          return bool;
        }
      });
      this.list.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(160000);
          if (1 == paramAnonymousInt)
          {
            paramAnonymousAbsListView = WeUIPreference.this.getCurrentFocus();
            if (paramAnonymousAbsListView != null) {
              paramAnonymousAbsListView.clearFocus();
            }
          }
          AppMethodBeat.o(160000);
        }
      });
      return;
    }
    finally
    {
      paramBundle.close();
    }
  }
  
  public void onResume()
  {
    this.aicv.notifyDataSetChanged();
    super.onResume();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.weui.base.preference.WeUIPreference
 * JD-Core Version:    0.7.0.1
 */