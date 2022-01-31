package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.ui.MMFragment;

public abstract class MMPreferenceFragment
  extends MMFragment
{
  protected h adapter;
  private boolean dirty = false;
  private boolean isRefreshing = false;
  protected ListView list;
  private SharedPreferences sp;
  private int zrT = 0;
  private int zrU = 0;
  protected boolean zrV;
  
  public final void dEP()
  {
    if (this.zrV) {}
    int i;
    do
    {
      return;
      i = getResourceId();
    } while (i == -1);
    this.adapter.addPreferencesFromResource(i);
    this.zrV = true;
  }
  
  public int getLayoutId()
  {
    return 2130970229;
  }
  
  public View getLayoutView()
  {
    b.SH();
    return b.b(getContext(), 2130970229);
  }
  
  public abstract int getResourceId();
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.zrV = false;
    this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    this.list = ((ListView)findViewById(16908298));
    this.adapter = new h(getContext(), this.list, this.sp);
    this.adapter.b(new MMPreferenceFragment.1(this));
    this.list.setAdapter(this.adapter);
    this.list.setOnItemClickListener(new MMPreferenceFragment.2(this));
    this.list.setOnItemLongClickListener(new MMPreferenceFragment.3(this));
    if (this.zrU != 0) {
      this.list.setSelectionFromTop(0, this.zrU);
    }
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return super.onContextItemSelected(paramMenuItem);
  }
  
  public abstract boolean onPreferenceTreeClick(f paramf, Preference paramPreference);
  
  public boolean onPreferenceTreeLongClick(f paramf, Preference paramPreference, View paramView)
  {
    return false;
  }
  
  public void onResume()
  {
    super.onResume();
    this.adapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreferenceFragment
 * JD-Core Version:    0.7.0.1
 */