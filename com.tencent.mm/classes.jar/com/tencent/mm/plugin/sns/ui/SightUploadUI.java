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
import com.tencent.mm.g.a.sw;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.r.b;
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
  private int xpe = 0;
  private int xpm = 0;
  private int xpn = 0;
  private SnsEditText xrU;
  private ab xrV = null;
  private LinearLayout xrW;
  private SnsSightUploadSayFooter xrX;
  private ArrayList<String> xrY;
  private boolean xrZ = false;
  private String xru = "";
  private String xrv = "";
  private boolean xsa = false;
  private long xsb = 0L;
  DisplayMetrics xsc;
  
  public int getLayoutId()
  {
    return 2131495589;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98281);
    this.xrU = ((SnsEditText)findViewById(2131304971));
    int i = this.xrU.getPaddingLeft();
    int j = this.xrW.getPaddingRight();
    int k = this.xsc.widthPixels;
    this.xrU.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98272);
        SightUploadUI.a(SightUploadUI.this).setWidth((int)(this.xsd * 0.7D));
        SightUploadUI.b(SightUploadUI.this).setLayoutParams(new LinearLayout.LayoutParams((int)(this.xsd * 0.3D), SightUploadUI.b(SightUploadUI.this).getHeight()));
        AppMethodBeat.o(98272);
      }
    }, 100L);
    if (!bt.isNullOrNil(getIntent().getStringExtra("Kdescription"))) {
      this.xrU.setText(getIntent().getStringExtra("Kdescription"));
    }
    this.xrU.setBackListener(new MMEditText.a()
    {
      public final void onBack()
      {
        AppMethodBeat.i(98273);
        SightUploadUI.this.hideVKB();
        sw localsw = new sw();
        localsw.dyt.type = 0;
        localsw.dyt.dyv = false;
        com.tencent.mm.sdk.b.a.ESL.l(localsw);
        SightUploadUI.this.finish();
        AppMethodBeat.o(98273);
      }
    });
    this.xrX = ((SnsSightUploadSayFooter)findViewById(2131304290));
    this.xrX.setMMEditText(this.xrU);
    this.xrX.setVisibility(0);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98274);
        paramAnonymousMenuItem = new sw();
        paramAnonymousMenuItem.dyt.type = 0;
        paramAnonymousMenuItem.dyt.dyv = false;
        com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousMenuItem);
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
            public final void kM(int paramAnonymous2Int)
            {
              AppMethodBeat.i(98275);
              switch (paramAnonymous2Int)
              {
              }
              for (;;)
              {
                AppMethodBeat.o(98275);
                return;
                sw localsw = new sw();
                localsw.dyt.type = 0;
                localsw.dyt.dyx = true;
                localsw.dyt.dyv = true;
                com.tencent.mm.sdk.b.a.ESL.l(localsw);
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
        paramAnonymousMenuItem = c.d(SightUploadUI.a(SightUploadUI.this)).aaj(com.tencent.mm.m.b.YE());
        paramAnonymousMenuItem.HuM = true;
        paramAnonymousMenuItem.a(new c.a()
        {
          public final void CH(String paramAnonymous2String)
          {
            AppMethodBeat.i(98277);
            paramAnonymous2String = new PInt();
            SightUploadUI.j(SightUploadUI.this).a(SightUploadUI.c(SightUploadUI.this), 0, null, SightUploadUI.d(SightUploadUI.this), null, SightUploadUI.e(SightUploadUI.this).getLocation(), null, i, SightUploadUI.f(SightUploadUI.this), SightUploadUI.g(SightUploadUI.this), paramAnonymous2String, "", SightUploadUI.h(SightUploadUI.this), SightUploadUI.i(SightUploadUI.this));
            com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
            long l1 = SightUploadUI.k(SightUploadUI.this);
            long l2 = bt.aGK();
            if (SightUploadUI.l(SightUploadUI.this))
            {
              i = 0;
              localh.f(13303, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymous2String.value), "" });
              l1 = SightUploadUI.k(SightUploadUI.this);
              l2 = bt.aGK();
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
          
          public final void aKr() {}
          
          public final void ck(String paramAnonymous2String)
          {
            AppMethodBeat.i(163078);
            com.tencent.mm.ui.base.h.j(SightUploadUI.this, 2131764058, 2131764059);
            AppMethodBeat.o(163078);
          }
        });
        AppMethodBeat.o(98279);
        return false;
      }
    }, null, r.b.FOD);
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
      localObject1 = this.xrX;
      if (paramIntent != null)
      {
        if (paramInt1 != 10) {
          break label81;
        }
        ((SnsSightUploadSayFooter)localObject1).xEA.aG(paramIntent);
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
            ((SnsSightUploadSayFooter)localObject1).xEz.a(paramInt1, paramInt2, paramIntent, null);
          }
        }
        else
        {
          paramInt2 = paramIntent.getIntExtra("Ktag_range_index", 0);
          if (paramInt2 >= 2)
          {
            this.xru = paramIntent.getStringExtra("Klabel_name_list");
            this.xrv = paramIntent.getStringExtra("Kother_user_name_list");
            localObject1 = Arrays.asList(this.xru.split(","));
            if (bt.isNullOrNil(this.xrv)) {
              break label531;
            }
          }
        }
      }
    }
    label528:
    label531:
    for (paramIntent = Arrays.asList(this.xrv.split(","));; paramIntent = null)
    {
      this.xrY = new ArrayList();
      Object localObject2;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          localObject2 = com.tencent.mm.plugin.label.a.a.cIS().aeL(com.tencent.mm.plugin.label.a.a.cIS().aeI((String)localObject2));
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
          if (!this.xrY.contains(str))
          {
            this.xrY.add(str);
            ad.d("MicroMsg.SightUploadUI", "dz:name : %s", new Object[] { str });
          }
        }
        break;
        this.xpm = paramInt1;
        this.xpn = 0;
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            if (!this.xrY.contains(localObject1))
            {
              this.xrY.add(localObject1);
              this.xpn += 1;
            }
          }
        }
        if (paramInt2 == 2) {}
        for (this.xrZ = false; 1 == paramInt2; this.xrZ = true)
        {
          this.xpe = 1;
          AppMethodBeat.o(98285);
          return;
        }
        this.xpe = 0;
        AppMethodBeat.o(98285);
        return;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98280);
    g.o(this);
    super.onCreate(paramBundle);
    this.xsc = getResources().getDisplayMetrics();
    this.xrV = new ao(this);
    this.xrV.af(paramBundle);
    this.xrW = ((LinearLayout)findViewById(2131306993));
    this.xrW.addView(this.xrV.dyV());
    setMMTitle(2131764037);
    getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(2131100017));
    this.xsa = getIntent().getBooleanExtra("KSnsPostManu", false);
    this.xsb = getIntent().getLongExtra("KTouchCameraTime", 0L);
    initView();
    g.p(this);
    AppMethodBeat.o(98280);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98283);
    super.onDestroy();
    this.xrV.dyW();
    this.xrX.xEA.stop();
    SnsSightUploadSayFooter localSnsSightUploadSayFooter = this.xrX;
    if (localSnsSightUploadSayFooter.fSY != null)
    {
      localSnsSightUploadSayFooter.fSY.exm();
      localSnsSightUploadSayFooter.fSY.destroy();
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
    SnsSightUploadSayFooter localSnsSightUploadSayFooter = this.xrX;
    if (localSnsSightUploadSayFooter.fSY.getVisibility() == 8) {
      localSnsSightUploadSayFooter.imP.showVKB();
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