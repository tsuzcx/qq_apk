package com.tencent.weui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ui.BaseActivity;

public abstract class WeUIPreference
  extends BaseActivity
{
  private boolean dirty = false;
  private SharedPreferences dnD;
  private ListView lwE;
  private boolean pCE = false;
  protected RelativeLayout vde;
  protected TextView vdf;
  protected ImageView vdg;
  private b xfS;
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return super.onContextItemSelected(paramMenuItem);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dnD = getSharedPreferences(getPackageName() + "_preferences", 0);
    this.xfS = new b(this, this.dnD);
    this.lwE = ((ListView)findViewById(16908298));
    this.vde = ((RelativeLayout)findViewById(a.f.preference_tips_banner_view));
    this.vdf = ((TextView)findViewById(a.f.preference_tips_banner_tv));
    this.vdg = ((ImageView)findViewById(a.f.preference_tips_banner_close));
    paramBundle = this.xfS;
    paramBundle.xfV = new WeUIPreference.1(this);
    paramBundle.notifyDataSetChanged();
    int i = xj();
    if (i != -1)
    {
      paramBundle = this.xfS;
      paramBundle.vdt = true;
      paramBundle.xfU.a(i, paramBundle);
      paramBundle.vdt = false;
      paramBundle.notifyDataSetChanged();
    }
    this.lwE.setAdapter(this.xfS);
    this.lwE.setOnItemClickListener(new WeUIPreference.2(this));
    this.lwE.setOnItemLongClickListener(new WeUIPreference.3(this));
    this.lwE.setOnScrollListener(new WeUIPreference.4(this));
  }
  
  protected void onResume()
  {
    this.xfS.notifyDataSetChanged();
    super.onResume();
  }
  
  public abstract int xj();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.weui.base.preference.WeUIPreference
 * JD-Core Version:    0.7.0.1
 */