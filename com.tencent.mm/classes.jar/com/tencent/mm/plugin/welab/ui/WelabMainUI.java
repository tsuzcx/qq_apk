package com.tencent.mm.plugin.welab.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.welab.d;
import com.tencent.mm.plugin.welab.e.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@i
public class WelabMainUI
  extends MMActivity
{
  private View vvA;
  private View vvB;
  private List<String> vvC;
  private Comparator<com.tencent.mm.plugin.welab.d.a.a> vvD;
  private View.OnClickListener vvE;
  private boolean vvl;
  private LinearLayout vvw;
  private LinearLayout vvx;
  private LinearLayout vvy;
  private LinearLayout vvz;
  
  public WelabMainUI()
  {
    AppMethodBeat.i(80619);
    this.vvl = false;
    this.vvD = new WelabMainUI.3(this);
    this.vvE = new WelabMainUI.4(this);
    AppMethodBeat.o(80619);
  }
  
  private void a(com.tencent.mm.plugin.welab.d.a.a parama, LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(80625);
    LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2130971313, paramLinearLayout, false);
    ImageView localImageView1 = (ImageView)localLinearLayout.findViewById(2131829568);
    ImageView localImageView2 = (ImageView)localLinearLayout.findViewById(2131829567);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131820680);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131821890);
    if (b.dhC().e(parama)) {
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.at.a.a.ahM().a(parama.ajA("field_ThumbUrl"), localImageView2, com.tencent.mm.plugin.welab.a.dhl().uMJ);
      com.tencent.mm.plugin.welab.a.dhl();
      localTextView1.setText(com.tencent.mm.plugin.welab.a.a(parama));
      localTextView2.setText(parama.ajA("field_Desc"));
      localLinearLayout.setTag(parama);
      localLinearLayout.setOnClickListener(this.vvE);
      paramLinearLayout.addView(localLinearLayout);
      AppMethodBeat.o(80625);
      return;
      localImageView1.setVisibility(8);
    }
  }
  
  private void dhB()
  {
    AppMethodBeat.i(80624);
    Object localObject = com.tencent.mm.plugin.welab.a.dhl().vuT.dht();
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)localIterator.next();
      if ((System.currentTimeMillis() / 1000L - locala.field_endtime >= 2592000L) || ("labs1de6f3".equals(locala.field_LabsAppId)))
      {
        localIterator.remove();
        com.tencent.mm.plugin.welab.a.vuS.vuT.delete(locala, new String[0]);
      }
      else if ((locala.isExpired()) && (locala.field_Switch != 3))
      {
        locala.field_Switch = 3;
        com.tencent.mm.plugin.welab.a.vuS.vuT.update(locala, new String[0]);
      }
      else if (locala.field_Switch != 3)
      {
        localIterator.remove();
      }
    }
    ab.i("WelabMgr", "stopped lab %s", new Object[] { localObject.toString() });
    if (((List)localObject).isEmpty())
    {
      this.vvx.setVisibility(8);
      AppMethodBeat.o(80624);
      return;
    }
    this.vvx.setVisibility(0);
    Collections.sort((List)localObject, this.vvD);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((com.tencent.mm.plugin.welab.d.a.a)((Iterator)localObject).next(), this.vvz);
    }
    ab.d("MicroMsg.WelabMainUI", "get online app count " + this.vvz.getChildCount());
    AppMethodBeat.o(80624);
  }
  
  public int getLayoutId()
  {
    return 2130971315;
  }
  
  public void initView()
  {
    AppMethodBeat.i(80621);
    setMMTitle(2131305953);
    setTitleDividerColor(2131690709);
    setActionbarColor(getResources().getColor(2131690708));
    setActionbarElementColor(getResources().getColor(2131689615));
    this.vvw = ((LinearLayout)findViewById(2131829576));
    this.vvy = ((LinearLayout)findViewById(2131829577));
    this.vvx = ((LinearLayout)findViewById(2131829578));
    this.vvz = ((LinearLayout)findViewById(2131829579));
    this.vvA = findViewById(2131829580);
    this.vvB = findViewById(2131829575);
    this.vvA.setOnClickListener(new WelabMainUI.1(this));
    setBackBtn(new WelabMainUI.2(this));
    AppMethodBeat.o(80621);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(80620);
    super.onCreate(paramBundle);
    setIsDarkActionbarBg(true);
    hideActionbarLine();
    if (getIntent() != null)
    {
      if (getIntent().getIntExtra("para_from_with_red_point", 0) == 1) {
        bool = true;
      }
      this.vvl = bool;
      this.vvC = getIntent().getStringArrayListExtra("key_exclude_apps");
    }
    initView();
    b.dhC();
    ah.dsQ().edit().putBoolean("key_has_enter_welab", true).commit();
    b.dhE();
    d.t("", 1, this.vvl);
    AppMethodBeat.o(80620);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80623);
    super.onPause();
    AppMethodBeat.o(80623);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80622);
    super.onResume();
    this.vvy.removeAllViews();
    this.vvz.removeAllViews();
    Object localObject = com.tencent.mm.plugin.welab.a.dhl().dhm();
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      this.vvw.setVisibility(8);
    }
    for (;;)
    {
      dhB();
      if ((this.vvw.getVisibility() == 0) || (this.vvx.getVisibility() == 0)) {
        break;
      }
      this.vvB.setVisibility(0);
      AppMethodBeat.o(80622);
      return;
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)localIterator.next();
        if ((!bo.isNullOrNil(locala.field_LabsAppId)) && (this.vvC.contains(locala.field_LabsAppId))) {
          localIterator.remove();
        }
      }
      if (((List)localObject).isEmpty())
      {
        this.vvw.setVisibility(8);
      }
      else
      {
        this.vvw.setVisibility(0);
        Collections.sort((List)localObject, this.vvD);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          a((com.tencent.mm.plugin.welab.d.a.a)((Iterator)localObject).next(), this.vvy);
        }
        ab.d("MicroMsg.WelabMainUI", "get online app count " + this.vvy.getChildCount());
      }
    }
    this.vvB.setVisibility(8);
    AppMethodBeat.o(80622);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabMainUI
 * JD-Core Version:    0.7.0.1
 */