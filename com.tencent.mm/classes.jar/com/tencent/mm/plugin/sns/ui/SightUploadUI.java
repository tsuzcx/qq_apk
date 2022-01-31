package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.j;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SightUploadUI
  extends MMActivity
{
  private String desc = "";
  DisplayMetrics pUA;
  private String rKQ = "";
  private String rKR = "";
  private SnsEditText rLm;
  private y rLn = null;
  private LinearLayout rLo;
  private SnsSightUploadSayFooter rLp;
  private int rLq = 0;
  private int rLr = 0;
  private ArrayList<String> rLs;
  private boolean rLt = false;
  private int rLu = 0;
  private boolean rLv = false;
  private long rLw = 0L;
  
  public int getLayoutId()
  {
    return 2130970864;
  }
  
  public void initView()
  {
    AppMethodBeat.i(38592);
    this.rLm = ((SnsEditText)findViewById(2131825537));
    int i = this.rLm.getPaddingLeft();
    int j = this.rLo.getPaddingRight();
    int k = this.pUA.widthPixels;
    this.rLm.postDelayed(new SightUploadUI.1(this, k - (i + j)), 100L);
    if (!bo.isNullOrNil(getIntent().getStringExtra(e.j.yVi))) {
      this.rLm.setText(getIntent().getStringExtra(e.j.yVi));
    }
    this.rLm.setBackListener(new SightUploadUI.2(this));
    this.rLp = ((SnsSightUploadSayFooter)findViewById(2131828085));
    this.rLp.setMMEditText(this.rLm);
    this.rLp.setVisibility(0);
    setBackBtn(new SightUploadUI.3(this));
    if (getIntent().getBooleanExtra("KSightDraftEntrance", true)) {
      addIconOptionMenu(1, 2131231985, new SightUploadUI.4(this));
    }
    addTextOptionMenu(0, getString(2131297067), new SightUploadUI.5(this), null, q.b.zbA);
    enableOptionMenu(true);
    AppMethodBeat.o(38592);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38596);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(38596);
      return;
    }
    Object localObject1;
    if ((paramInt1 == 6) || (paramInt1 == 5) || (paramInt1 == 10))
    {
      localObject1 = this.rLp;
      if (paramIntent != null)
      {
        if (paramInt1 != 10) {
          break label81;
        }
        ((SnsSightUploadSayFooter)localObject1).rVZ.an(paramIntent);
      }
    }
    for (;;)
    {
      if (paramInt1 == 5) {
        if (paramIntent == null)
        {
          AppMethodBeat.o(38596);
          return;
          label81:
          if (paramInt1 == 5) {
            ((SnsSightUploadSayFooter)localObject1).rVY.a(paramInt1, paramInt2, paramIntent, null);
          }
        }
        else
        {
          paramInt2 = paramIntent.getIntExtra("Ktag_range_index", 0);
          if (paramInt2 >= 2)
          {
            this.rKQ = paramIntent.getStringExtra("Klabel_name_list");
            this.rKR = paramIntent.getStringExtra("Kother_user_name_list");
            localObject1 = Arrays.asList(this.rKQ.split(","));
            if (bo.isNullOrNil(this.rKR)) {
              break label531;
            }
          }
        }
      }
    }
    label528:
    label531:
    for (paramIntent = Arrays.asList(this.rKR.split(","));; paramIntent = null)
    {
      this.rLs = new ArrayList();
      Object localObject2;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          localObject2 = a.bKV().RR(a.bKV().RO((String)localObject2));
          if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
            break label324;
          }
          ab.e("MicroMsg.SightUploadUI", "dz: getContactNamesFromLabels,namelist get bu label is null");
        }
      }
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        paramInt1 = 0;
        label291:
        if (((Iterator)localObject1).hasNext())
        {
          if (bo.isNullOrNil((String)((Iterator)localObject1).next())) {
            break label528;
          }
          paramInt1 += 1;
        }
      }
      for (;;)
      {
        break label291;
        label324:
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          if (!this.rLs.contains(str))
          {
            this.rLs.add(str);
            ab.d("MicroMsg.SightUploadUI", "dz:name : %s", new Object[] { str });
          }
        }
        break;
        this.rLq = paramInt1;
        this.rLr = 0;
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            if (!this.rLs.contains(localObject1))
            {
              this.rLs.add(localObject1);
              this.rLr += 1;
            }
          }
        }
        if (paramInt2 == 2) {}
        for (this.rLt = false; 1 == paramInt2; this.rLt = true)
        {
          this.rLu = 1;
          AppMethodBeat.o(38596);
          return;
        }
        this.rLu = 0;
        AppMethodBeat.o(38596);
        return;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38591);
    f.m(this);
    super.onCreate(paramBundle);
    this.pUA = getResources().getDisplayMetrics();
    this.rLn = new ak(this);
    this.rLn.V(paramBundle);
    this.rLo = ((LinearLayout)findViewById(2131828084));
    this.rLo.addView(this.rLn.ctv());
    setMMTitle(2131304020);
    getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(2131689763));
    this.rLv = getIntent().getBooleanExtra("KSnsPostManu", false);
    this.rLw = getIntent().getLongExtra("KTouchCameraTime", 0L);
    initView();
    f.n(this);
    AppMethodBeat.o(38591);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38594);
    super.onDestroy();
    this.rLn.ctw();
    this.rLp.rVZ.stop();
    SnsSightUploadSayFooter localSnsSightUploadSayFooter = this.rLp;
    if (localSnsSightUploadSayFooter.eys != null)
    {
      localSnsSightUploadSayFooter.eys.Ay();
      localSnsSightUploadSayFooter.eys.destroy();
    }
    AppMethodBeat.o(38594);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38595);
    super.onPause();
    hideVKB();
    AppMethodBeat.o(38595);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38593);
    super.onResume();
    ab.d("MicroMsg.SightUploadUI", "onResume");
    SnsSightUploadSayFooter localSnsSightUploadSayFooter = this.rLp;
    if (localSnsSightUploadSayFooter.eys.getVisibility() == 8) {
      localSnsSightUploadSayFooter.cmc.showVKB();
    }
    AppMethodBeat.o(38593);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightUploadUI
 * JD-Core Version:    0.7.0.1
 */