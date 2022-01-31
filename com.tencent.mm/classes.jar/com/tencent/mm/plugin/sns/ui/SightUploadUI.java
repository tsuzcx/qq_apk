package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SightUploadUI
  extends MMActivity
{
  private String desc = "";
  DisplayMetrics npm;
  private String oSV = "";
  private String oSW = "";
  private SnsEditText oTp;
  private y oTq = null;
  private LinearLayout oTr;
  private SnsSightUploadSayFooter oTs;
  private int oTt = 0;
  private int oTu = 0;
  private ArrayList<String> oTv;
  private boolean oTw = false;
  private int oTx = 0;
  private boolean oTy = false;
  private long oTz = 0L;
  
  protected final int getLayoutId()
  {
    return i.g.sns_sight_upload_ui;
  }
  
  protected final void initView()
  {
    this.oTp = ((SnsEditText)findViewById(i.f.sns_desc_tv));
    int i = this.oTp.getPaddingLeft();
    int j = this.oTr.getPaddingRight();
    int k = this.npm.widthPixels;
    this.oTp.postDelayed(new SightUploadUI.1(this, k - (i + j)), 100L);
    if (!bk.bl(getIntent().getStringExtra(e.h.uHV))) {
      this.oTp.setText(getIntent().getStringExtra(e.h.uHV));
    }
    this.oTp.setBackListener(new SightUploadUI.2(this));
    this.oTs = ((SnsSightUploadSayFooter)findViewById(i.f.say_footer));
    this.oTs.setMMEditText(this.oTp);
    this.oTs.setVisibility(0);
    setBackBtn(new SightUploadUI.3(this));
    if (getIntent().getBooleanExtra("KSightDraftEntrance", true)) {
      addIconOptionMenu(1, i.i.sight_draft_menu, new SightUploadUI.4(this));
    }
    a(0, getString(i.j.app_send), new SightUploadUI.5(this), s.b.uNz);
    enableOptionMenu(true);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {
      return;
    }
    Object localObject1;
    if ((paramInt1 == 6) || (paramInt1 == 5) || (paramInt1 == 10))
    {
      localObject1 = this.oTs;
      if (paramIntent != null)
      {
        if (paramInt1 != 10) {
          break label285;
        }
        ((SnsSightUploadSayFooter)localObject1).pdr.U(paramIntent);
      }
    }
    label56:
    if ((paramInt1 == 5) && (paramIntent != null))
    {
      paramInt2 = paramIntent.getIntExtra("Ktag_range_index", 0);
      if (paramInt2 < 2) {
        break label475;
      }
      this.oSV = paramIntent.getStringExtra("Klabel_name_list");
      this.oSW = paramIntent.getStringExtra("Kother_user_name_list");
      localObject1 = Arrays.asList(this.oSV.split(","));
      if (bk.bl(this.oSW)) {
        break label503;
      }
    }
    label170:
    label306:
    label475:
    label500:
    label501:
    label503:
    for (paramIntent = Arrays.asList(this.oSW.split(","));; paramIntent = null)
    {
      this.oTv = new ArrayList();
      Object localObject2;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          localObject2 = a.bdA().Go(a.bdA().Gl((String)localObject2));
          if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
            break label306;
          }
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SightUploadUI", "dz: getContactNamesFromLabels,namelist get bu label is null");
        }
      }
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        paramInt1 = 0;
        label252:
        if (((Iterator)localObject1).hasNext())
        {
          if (bk.bl((String)((Iterator)localObject1).next())) {
            break label500;
          }
          paramInt1 += 1;
        }
      }
      for (;;)
      {
        break label252;
        if (paramInt1 != 5) {
          break label501;
        }
        ((SnsSightUploadSayFooter)localObject1).pdq.a(paramInt1, paramInt2, paramIntent, null);
        break label56;
        break;
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          if (!this.oTv.contains(str))
          {
            this.oTv.add(str);
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SightUploadUI", "dz:name : %s", new Object[] { str });
          }
        }
        break label170;
        this.oTt = paramInt1;
        this.oTu = 0;
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            if (!this.oTv.contains(localObject1))
            {
              this.oTv.add(localObject1);
              this.oTu += 1;
            }
          }
        }
        if (paramInt2 == 2) {}
        for (this.oTw = false; 1 == paramInt2; this.oTw = true)
        {
          this.oTx = 1;
          return;
        }
        this.oTx = 0;
        return;
      }
      break label56;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    e.k(this);
    super.onCreate(paramBundle);
    this.npm = getResources().getDisplayMetrics();
    this.oTq = new ak(this);
    this.oTq.E(paramBundle);
    this.oTr = ((LinearLayout)findViewById(i.f.widget_content));
    this.oTr.addView(this.oTq.bHr());
    setMMTitle(i.j.sns_timeline_ui_title);
    getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(i.c.black));
    this.oTy = getIntent().getBooleanExtra("KSnsPostManu", false);
    this.oTz = getIntent().getLongExtra("KTouchCameraTime", 0L);
    initView();
    e.l(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.oTq.bHs();
    this.oTs.pdr.stop();
    SnsSightUploadSayFooter localSnsSightUploadSayFooter = this.oTs;
    if (localSnsSightUploadSayFooter.jpC != null)
    {
      localSnsSightUploadSayFooter.jpC.sj();
      localSnsSightUploadSayFooter.jpC.destroy();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    XM();
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SightUploadUI", "onResume");
    SnsSightUploadSayFooter localSnsSightUploadSayFooter = this.oTs;
    if (localSnsSightUploadSayFooter.jpC.getVisibility() == 8) {
      localSnsSightUploadSayFooter.bER.showVKB();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightUploadUI
 * JD-Core Version:    0.7.0.1
 */