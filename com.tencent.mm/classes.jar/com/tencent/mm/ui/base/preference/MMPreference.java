package com.tencent.mm.ui.base.preference;

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
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public abstract class MMPreference
  extends MMActivity
{
  private boolean dirty = false;
  public SharedPreferences dnD;
  public ListView lwE;
  private boolean pCE = false;
  public h vdd;
  protected RelativeLayout vde;
  protected TextView vdf;
  protected ImageView vdg;
  
  public static boolean cBx()
  {
    return false;
  }
  
  public boolean XI()
  {
    return true;
  }
  
  public h a(SharedPreferences paramSharedPreferences)
  {
    return new h(this, paramSharedPreferences);
  }
  
  public abstract boolean a(f paramf, Preference paramPreference);
  
  public View aBq()
  {
    return null;
  }
  
  public int axE()
  {
    return -1;
  }
  
  public View byP()
  {
    return null;
  }
  
  public int getLayoutId()
  {
    return a.h.mm_preference_list_content;
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return super.onContextItemSelected(paramMenuItem);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dnD = getSharedPreferences(getPackageName() + "_preferences", 0);
    this.vdd = a(this.dnD);
    this.lwE = ((ListView)findViewById(16908298));
    this.vde = ((RelativeLayout)findViewById(a.g.preference_tips_banner_view));
    this.vdf = ((TextView)findViewById(a.g.preference_tips_banner_tv));
    this.vdg = ((ImageView)findViewById(a.g.preference_tips_banner_close));
    int i = axE();
    if (i != -1)
    {
      paramBundle = getLayoutInflater().inflate(i, null);
      this.lwE.addHeaderView(paramBundle);
    }
    paramBundle = aBq();
    if (paramBundle != null)
    {
      if (paramBundle.getLayoutParams() == null) {
        break label290;
      }
      paramBundle.setLayoutParams(new AbsListView.LayoutParams(paramBundle.getLayoutParams()));
    }
    for (;;)
    {
      this.lwE.addFooterView(paramBundle);
      paramBundle = byP();
      if (paramBundle != null)
      {
        FrameLayout localFrameLayout = (FrameLayout)findViewById(a.g.preference_bottom);
        localFrameLayout.addView(paramBundle);
        localFrameLayout.setVisibility(0);
      }
      this.vdd.b(new MMPreference.1(this));
      i = xj();
      if (i != -1) {
        this.vdd.addPreferencesFromResource(i);
      }
      this.lwE.setAdapter(this.vdd);
      this.lwE.setOnItemClickListener(new MMPreference.2(this));
      this.lwE.setOnItemLongClickListener(new MMPreference.3(this));
      this.lwE.setOnScrollListener(new MMPreference.4(this));
      return;
      label290:
      y.e("MicroMsg.mmui.MMPreference", "[arthurdan.mmpreference] Notice!!! footer.getLayoutParams() is null!!!\n");
    }
  }
  
  public void onResume()
  {
    if (XI()) {
      this.vdd.notifyDataSetChanged();
    }
    super.onResume();
  }
  
  public final void setSelection(int paramInt)
  {
    this.lwE.setSelection(paramInt);
  }
  
  public abstract int xj();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreference
 * JD-Core Version:    0.7.0.1
 */