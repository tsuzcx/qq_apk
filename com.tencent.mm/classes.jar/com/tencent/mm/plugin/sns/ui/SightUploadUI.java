package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.MMEditText.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SightUploadUI
  extends MMActivity
{
  private String desc = "";
  private int zTo = 0;
  private int zTw = 0;
  private int zTx = 0;
  private String zVF = "";
  private String zVG = "";
  private SnsEditText zWf;
  private ac zWg = null;
  private LinearLayout zWh;
  private SnsSightUploadSayFooter zWi;
  private ArrayList<String> zWj;
  private boolean zWk = false;
  private boolean zWl = false;
  private long zWm = 0L;
  DisplayMetrics zWn;
  
  public int getLayoutId()
  {
    return 2131495589;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98281);
    this.zWf = ((SnsEditText)findViewById(2131304971));
    int i = this.zWf.getPaddingLeft();
    int j = this.zWh.getPaddingRight();
    int k = this.zWn.widthPixels;
    this.zWf.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98272);
        SightUploadUI.a(SightUploadUI.this).setWidth((int)(this.zWo * 0.7D));
        SightUploadUI.b(SightUploadUI.this).setLayoutParams(new LinearLayout.LayoutParams((int)(this.zWo * 0.3D), SightUploadUI.b(SightUploadUI.this).getHeight()));
        AppMethodBeat.o(98272);
      }
    }, 100L);
    if (!bt.isNullOrNil(getIntent().getStringExtra("Kdescription"))) {
      this.zWf.setText(getIntent().getStringExtra("Kdescription"));
    }
    this.zWf.setBackListener(new MMEditText.a()
    {
      public final void onBack()
      {
        AppMethodBeat.i(98273);
        SightUploadUI.this.hideVKB();
        tx localtx = new tx();
        localtx.dIp.type = 0;
        localtx.dIp.dIr = false;
        com.tencent.mm.sdk.b.a.IbL.l(localtx);
        SightUploadUI.this.finish();
        AppMethodBeat.o(98273);
      }
    });
    this.zWi = ((SnsSightUploadSayFooter)findViewById(2131304290));
    this.zWi.setMMEditText(this.zWf);
    this.zWi.setVisibility(0);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98274);
        paramAnonymousMenuItem = new tx();
        paramAnonymousMenuItem.dIp.type = 0;
        paramAnonymousMenuItem.dIp.dIr = false;
        com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMenuItem);
        SightUploadUI.this.hideVKB();
        SightUploadUI.this.finish();
        AppMethodBeat.o(98274);
        return true;
      }
    });
    if (getIntent().getBooleanExtra("KSightDraftEntrance", true)) {
      addIconOptionMenu(1, 2131691171, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(98276);
          paramAnonymousMenuItem = SightUploadUI.this.getContext();
          String str = SightUploadUI.this.getString(2131763710);
          h.c local1 = new h.c()
          {
            public final void lf(int paramAnonymous2Int)
            {
              AppMethodBeat.i(98275);
              switch (paramAnonymous2Int)
              {
              }
              for (;;)
              {
                AppMethodBeat.o(98275);
                return;
                tx localtx = new tx();
                localtx.dIp.type = 0;
                localtx.dIp.dIt = true;
                localtx.dIp.dIr = true;
                com.tencent.mm.sdk.b.a.IbL.l(localtx);
                SightUploadUI.this.hideVKB();
                SightUploadUI.this.finish();
              }
            }
          };
          com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, null, new String[] { str }, null, local1);
          AppMethodBeat.o(98276);
          return false;
        }
      });
    }
    addTextOptionMenu(0, getString(2131755884), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98279);
        if (SightUploadUI.this.isFinishing())
        {
          AppMethodBeat.o(98279);
          return false;
        }
        SightUploadUI.a(SightUploadUI.this, SightUploadUI.a(SightUploadUI.this).getText().toString());
        final int i = SightUploadUI.a(SightUploadUI.this).getPasterLen();
        paramAnonymousMenuItem = c.d(SightUploadUI.a(SightUploadUI.this)).aeU(com.tencent.mm.n.b.acb());
        paramAnonymousMenuItem.KMn = true;
        paramAnonymousMenuItem.a(new c.a()
        {
          public final void JZ(String paramAnonymous2String)
          {
            AppMethodBeat.i(98277);
            paramAnonymous2String = new PInt();
            SightUploadUI.j(SightUploadUI.this).a(SightUploadUI.c(SightUploadUI.this), 0, null, SightUploadUI.d(SightUploadUI.this), null, SightUploadUI.e(SightUploadUI.this).getLocation(), null, i, SightUploadUI.f(SightUploadUI.this), SightUploadUI.g(SightUploadUI.this), paramAnonymous2String, "", SightUploadUI.h(SightUploadUI.this), SightUploadUI.i(SightUploadUI.this));
            g localg = g.yhR;
            long l1 = SightUploadUI.k(SightUploadUI.this);
            long l2 = bt.aQJ();
            if (SightUploadUI.l(SightUploadUI.this))
            {
              i = 0;
              localg.f(13303, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymous2String.value), "" });
              l1 = SightUploadUI.k(SightUploadUI.this);
              l2 = bt.aQJ();
              if (!SightUploadUI.l(SightUploadUI.this)) {
                break label283;
              }
            }
            label283:
            for (int i = 0;; i = 1)
            {
              ad.d("MicroMsg.SightUploadUI", "reprot timelinePostAction(13303), %d, %d, %d, %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymous2String.value) });
              AppMethodBeat.o(98277);
              return;
              i = 1;
              break;
            }
          }
          
          public final void aUu() {}
          
          public final void cU(String paramAnonymous2String)
          {
            AppMethodBeat.i(163078);
            com.tencent.mm.ui.base.h.l(SightUploadUI.this, 2131764058, 2131764059);
            AppMethodBeat.o(163078);
          }
        });
        AppMethodBeat.o(98279);
        return false;
      }
    }, null, s.b.JbU);
    enableOptionMenu(true);
    AppMethodBeat.o(98281);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98285);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(98285);
      return;
    }
    Object localObject1;
    if ((paramInt1 == 6) || (paramInt1 == 5) || (paramInt1 == 10))
    {
      localObject1 = this.zWi;
      if (paramIntent != null)
      {
        if (paramInt1 != 10) {
          break label81;
        }
        ((SnsSightUploadSayFooter)localObject1).AiO.aN(paramIntent);
      }
    }
    for (;;)
    {
      if (paramInt1 == 5) {
        if (paramIntent == null)
        {
          AppMethodBeat.o(98285);
          return;
          label81:
          if (paramInt1 == 5) {
            ((SnsSightUploadSayFooter)localObject1).AiN.a(paramInt1, paramInt2, paramIntent, null);
          }
        }
        else
        {
          paramInt2 = paramIntent.getIntExtra("Ktag_range_index", 0);
          if (paramInt2 >= 2)
          {
            this.zVF = paramIntent.getStringExtra("Klabel_name_list");
            this.zVG = paramIntent.getStringExtra("Kother_user_name_list");
            localObject1 = Arrays.asList(this.zVF.split(","));
            if (bt.isNullOrNil(this.zVG)) {
              break label531;
            }
          }
        }
      }
    }
    label528:
    label531:
    for (paramIntent = Arrays.asList(this.zVG.split(","));; paramIntent = null)
    {
      this.zWj = new ArrayList();
      Object localObject2;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          localObject2 = com.tencent.mm.plugin.label.a.a.dfo().aop(com.tencent.mm.plugin.label.a.a.dfo().aom((String)localObject2));
          if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
            break label324;
          }
          ad.e("MicroMsg.SightUploadUI", "dz: getContactNamesFromLabels,namelist get bu label is null");
        }
      }
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        paramInt1 = 0;
        label291:
        if (((Iterator)localObject1).hasNext())
        {
          if (bt.isNullOrNil((String)((Iterator)localObject1).next())) {
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
          if (!this.zWj.contains(str))
          {
            this.zWj.add(str);
            ad.d("MicroMsg.SightUploadUI", "dz:name : %s", new Object[] { str });
          }
        }
        break;
        this.zTw = paramInt1;
        this.zTx = 0;
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            if (!this.zWj.contains(localObject1))
            {
              this.zWj.add(localObject1);
              this.zTx += 1;
            }
          }
        }
        if (paramInt2 == 2) {}
        for (this.zWk = false; 1 == paramInt2; this.zWk = true)
        {
          this.zTo = 1;
          AppMethodBeat.o(98285);
          return;
        }
        this.zTo = 0;
        AppMethodBeat.o(98285);
        return;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98280);
    com.tencent.mm.pluginsdk.h.q(this);
    super.onCreate(paramBundle);
    this.zWn = getResources().getDisplayMetrics();
    this.zWg = new ar(this);
    this.zWg.ap(paramBundle);
    this.zWh = ((LinearLayout)findViewById(2131306993));
    this.zWh.addView(this.zWg.dZH());
    setMMTitle(2131764037);
    getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(2131100017));
    this.zWl = getIntent().getBooleanExtra("KSnsPostManu", false);
    this.zWm = getIntent().getLongExtra("KTouchCameraTime", 0L);
    initView();
    com.tencent.mm.pluginsdk.h.r(this);
    AppMethodBeat.o(98280);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98283);
    super.onDestroy();
    this.zWg.dZI();
    this.zWi.AiO.stop();
    SnsSightUploadSayFooter localSnsSightUploadSayFooter = this.zWi;
    if (localSnsSightUploadSayFooter.pWJ != null)
    {
      localSnsSightUploadSayFooter.pWJ.fbE();
      localSnsSightUploadSayFooter.pWJ.destroy();
    }
    AppMethodBeat.o(98283);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98284);
    super.onPause();
    hideVKB();
    AppMethodBeat.o(98284);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98282);
    super.onResume();
    ad.d("MicroMsg.SightUploadUI", "onResume");
    SnsSightUploadSayFooter localSnsSightUploadSayFooter = this.zWi;
    if (localSnsSightUploadSayFooter.pWJ.getVisibility() == 8) {
      localSnsSightUploadSayFooter.fLP.showVKB();
    }
    AppMethodBeat.o(98282);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightUploadUI
 * JD-Core Version:    0.7.0.1
 */