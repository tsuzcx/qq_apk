package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.j;
import com.tencent.mm.plugin.welab.a.a;
import com.tencent.mm.plugin.welab.a.b;
import com.tencent.mm.plugin.welab.a.c;
import com.tencent.mm.plugin.welab.a.d;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@j
public class WelabMainUI
  extends MMActivity
{
  private boolean rEC = false;
  private LinearLayout rEN;
  private LinearLayout rEO;
  private LinearLayout rEP;
  private LinearLayout rEQ;
  private View rER;
  private View rES;
  private List<String> rET;
  private Comparator<com.tencent.mm.plugin.welab.c.a.a> rEU = new WelabMainUI.3(this);
  private View.OnClickListener rEV = new WelabMainUI.4(this);
  
  private void a(com.tencent.mm.plugin.welab.c.a.a parama, LinearLayout paramLinearLayout)
  {
    LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(a.c.welab_app_view, paramLinearLayout, false);
    ImageView localImageView1 = (ImageView)localLinearLayout.findViewById(a.b.title_prospect);
    ImageView localImageView2 = (ImageView)localLinearLayout.findViewById(a.b.app_img);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(a.b.title);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(a.b.summary);
    if (com.tencent.mm.plugin.welab.d.b.chq().e(parama)) {
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.as.a.a.OT().a(parama.Um("field_ThumbUrl"), localImageView2, com.tencent.mm.plugin.welab.b.chc().qXu);
      com.tencent.mm.plugin.welab.b.chc();
      localTextView1.setText(com.tencent.mm.plugin.welab.b.a(parama));
      localTextView2.setText(parama.Um("field_Desc"));
      localLinearLayout.setTag(parama);
      localLinearLayout.setOnClickListener(this.rEV);
      paramLinearLayout.addView(localLinearLayout);
      return;
      localImageView1.setVisibility(8);
    }
  }
  
  private void chp()
  {
    List localList = com.tencent.mm.plugin.welab.b.chc().rEr.chl();
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.welab.c.a.a locala = (com.tencent.mm.plugin.welab.c.a.a)((Iterator)localObject).next();
      if ((System.currentTimeMillis() / 1000L - locala.field_endtime >= 2592000L) || ("labs1de6f3".equals(locala.field_LabsAppId)))
      {
        ((Iterator)localObject).remove();
        com.tencent.mm.plugin.welab.b.chc().rEr.a(locala, new String[0]);
      }
      else if ((locala.caB()) && (locala.field_Switch != 3))
      {
        locala.field_Switch = 3;
        com.tencent.mm.plugin.welab.b.chc().rEr.c(locala, new String[0]);
      }
      else if (locala.field_Switch != 3)
      {
        ((Iterator)localObject).remove();
      }
    }
    if ("stopped lab " + localList != null) {}
    for (localObject = localList.toString();; localObject = "")
    {
      y.i("WelabMgr", (String)localObject);
      if (!localList.isEmpty()) {
        break;
      }
      this.rEO.setVisibility(8);
      return;
    }
    this.rEO.setVisibility(0);
    Collections.sort(localList, this.rEU);
    localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((com.tencent.mm.plugin.welab.c.a.a)((Iterator)localObject).next(), this.rEQ);
    }
    y.d("MicroMsg.WelabMainUI", "get online app count " + this.rEQ.getChildCount());
  }
  
  protected final int getLayoutId()
  {
    return a.c.welab_main;
  }
  
  protected final void initView()
  {
    setMMTitle(a.d.welab_name);
    s.czz();
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = getWindow();
      localWindow.clearFlags(201326592);
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(getResources().getColor(a.a.welab_main_color));
    }
    if (getSupportActionBar() != null) {
      getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(a.a.welab_main_color));
    }
    this.rEN = ((LinearLayout)findViewById(a.b.online_composite_container));
    this.rEP = ((LinearLayout)findViewById(a.b.online_container));
    this.rEO = ((LinearLayout)findViewById(a.b.stopped_composite_container));
    this.rEQ = ((LinearLayout)findViewById(a.b.stopped_container));
    this.rER = findViewById(a.b.privacy_detail);
    this.rES = findViewById(a.b.no_app_view);
    this.rER.setOnClickListener(new WelabMainUI.1(this));
    setBackBtn(new WelabMainUI.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.onCreate(paramBundle);
    mS(true);
    czo();
    if (getIntent() != null)
    {
      if (getIntent().getIntExtra("para_from_with_red_point", 0) == 1) {
        bool = true;
      }
      this.rEC = bool;
      this.rET = getIntent().getStringArrayListExtra("key_exclude_apps");
    }
    initView();
    com.tencent.mm.plugin.welab.d.b.chq();
    ae.cqS().edit().putBoolean("key_has_enter_welab", true).commit();
    com.tencent.mm.plugin.welab.d.b.chr();
    e.q("", 1, this.rEC);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.rEP.removeAllViews();
    this.rEQ.removeAllViews();
    Object localObject = com.tencent.mm.plugin.welab.b.chc().chd();
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      this.rEN.setVisibility(8);
    }
    for (;;)
    {
      chp();
      if ((this.rEN.getVisibility() == 0) || (this.rEO.getVisibility() == 0)) {
        break;
      }
      this.rES.setVisibility(0);
      return;
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.welab.c.a.a locala = (com.tencent.mm.plugin.welab.c.a.a)localIterator.next();
        if ((!bk.bl(locala.field_LabsAppId)) && (this.rET.contains(locala.field_LabsAppId))) {
          localIterator.remove();
        }
      }
      if (((List)localObject).isEmpty())
      {
        this.rEN.setVisibility(8);
      }
      else
      {
        this.rEN.setVisibility(0);
        Collections.sort((List)localObject, this.rEU);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          a((com.tencent.mm.plugin.welab.c.a.a)((Iterator)localObject).next(), this.rEP);
        }
        y.d("MicroMsg.WelabMainUI", "get online app count " + this.rEP.getChildCount());
      }
    }
    this.rES.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabMainUI
 * JD-Core Version:    0.7.0.1
 */