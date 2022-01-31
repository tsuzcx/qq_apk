package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.ui.x;

public abstract class i
  extends x
{
  private boolean dirty = false;
  private SharedPreferences dnD;
  private ListView lwE;
  private boolean pCE = false;
  public h vdd;
  public boolean vdv;
  
  public abstract boolean a(f paramf, Preference paramPreference);
  
  public boolean a(f paramf, Preference paramPreference, View paramView)
  {
    return false;
  }
  
  protected int getLayoutId()
  {
    return a.h.mm_preference_fragment_list_content;
  }
  
  protected View getLayoutView()
  {
    return b.ED().a(getContext(), "R.layout.mm_preference_fragment_list_content", a.h.mm_preference_fragment_list_content);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.vdv = false;
    this.dnD = getSharedPreferences(getPackageName() + "_preferences", 0);
    this.vdd = new h(getContext(), this.dnD);
    this.lwE = ((ListView)findViewById(16908298));
    this.vdd.b(new i.1(this));
    this.lwE.setAdapter(this.vdd);
    this.lwE.setOnItemClickListener(new i.2(this));
    this.lwE.setOnItemLongClickListener(new i.3(this));
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return super.onContextItemSelected(paramMenuItem);
  }
  
  public void onResume()
  {
    super.onResume();
    this.vdd.notifyDataSetChanged();
  }
  
  public abstract int xj();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.i
 * JD-Core Version:    0.7.0.1
 */