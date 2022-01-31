package com.tencent.weui.base.preference;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.BaseActivity;

public abstract class WeUIPreference
  extends BaseActivity
{
  private b BCy;
  protected ImageView bannerCloseBtn;
  protected TextView bannerTv;
  protected RelativeLayout bannerView;
  private boolean dirty = false;
  private boolean isRefreshing = false;
  private ListView list;
  private SharedPreferences sp;
  
  public abstract int getResourceId();
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return super.onContextItemSelected(paramMenuItem);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    this.BCy = new b(this, this.sp);
    this.list = ((ListView)findViewById(16908298));
    this.bannerView = ((RelativeLayout)findViewById(2131826248));
    this.bannerTv = ((TextView)findViewById(2131826250));
    this.bannerCloseBtn = ((ImageView)findViewById(2131826249));
    paramBundle = this.BCy;
    paramBundle.BCC = new WeUIPreference.1(this);
    paramBundle.notifyDataSetChanged();
    int i = getResourceId();
    b localb;
    c localc;
    if (i != -1)
    {
      localb = this.BCy;
      localb.BCB = true;
      localc = localb.BCA;
      paramBundle = localc.mContext.getResources().getXml(i);
      if (paramBundle == null) {}
    }
    try
    {
      localc.a(paramBundle, localb);
      paramBundle.close();
      localb.BCB = false;
      localb.notifyDataSetChanged();
      this.list.setAdapter(this.BCy);
      this.list.setOnItemClickListener(new WeUIPreference.2(this));
      this.list.setOnItemLongClickListener(new WeUIPreference.3(this));
      this.list.setOnScrollListener(new WeUIPreference.4(this));
      return;
    }
    finally
    {
      paramBundle.close();
    }
  }
  
  public void onResume()
  {
    this.BCy.notifyDataSetChanged();
    super.onResume();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.weui.base.preference.WeUIPreference
 * JD-Core Version:    0.7.0.1
 */