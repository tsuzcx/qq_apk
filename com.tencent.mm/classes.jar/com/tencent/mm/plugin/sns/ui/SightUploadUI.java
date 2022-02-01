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
import com.tencent.mm.g.a.ty;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private int AkD = 0;
  private int AkE = 0;
  private int Akv = 0;
  private String AmN = "";
  private String AmO = "";
  private SnsEditText Ann;
  private ac Ano = null;
  private LinearLayout Anp;
  private SnsSightUploadSayFooter Anq;
  private ArrayList<String> Ans;
  private boolean Ant = false;
  private boolean Anu = false;
  private long Anv = 0L;
  DisplayMetrics Anw;
  private String desc = "";
  
  public int getLayoutId()
  {
    return 2131495589;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98281);
    this.Ann = ((SnsEditText)findViewById(2131304971));
    int i = this.Ann.getPaddingLeft();
    int j = this.Anp.getPaddingRight();
    int k = this.Anw.widthPixels;
    this.Ann.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98272);
        SightUploadUI.a(SightUploadUI.this).setWidth((int)(this.Anx * 0.7D));
        SightUploadUI.b(SightUploadUI.this).setLayoutParams(new LinearLayout.LayoutParams((int)(this.Anx * 0.3D), SightUploadUI.b(SightUploadUI.this).getHeight()));
        AppMethodBeat.o(98272);
      }
    }, 100L);
    if (!bu.isNullOrNil(getIntent().getStringExtra("Kdescription"))) {
      this.Ann.setText(getIntent().getStringExtra("Kdescription"));
    }
    this.Ann.setBackListener(new MMEditText.a()
    {
      public final void onBack()
      {
        AppMethodBeat.i(98273);
        SightUploadUI.this.hideVKB();
        ty localty = new ty();
        localty.dJt.type = 0;
        localty.dJt.dJv = false;
        com.tencent.mm.sdk.b.a.IvT.l(localty);
        SightUploadUI.this.finish();
        AppMethodBeat.o(98273);
      }
    });
    this.Anq = ((SnsSightUploadSayFooter)findViewById(2131304290));
    this.Anq.setMMEditText(this.Ann);
    this.Anq.setVisibility(0);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98274);
        paramAnonymousMenuItem = new ty();
        paramAnonymousMenuItem.dJt.type = 0;
        paramAnonymousMenuItem.dJt.dJv = false;
        com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousMenuItem);
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
            public final void lh(int paramAnonymous2Int)
            {
              AppMethodBeat.i(98275);
              switch (paramAnonymous2Int)
              {
              }
              for (;;)
              {
                AppMethodBeat.o(98275);
                return;
                ty localty = new ty();
                localty.dJt.type = 0;
                localty.dJt.dJx = true;
                localty.dJt.dJv = true;
                com.tencent.mm.sdk.b.a.IvT.l(localty);
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
        paramAnonymousMenuItem = c.d(SightUploadUI.a(SightUploadUI.this)).afD(com.tencent.mm.n.b.ack());
        paramAnonymousMenuItem.LiL = true;
        paramAnonymousMenuItem.a(new c.a()
        {
          public final void Ky(String paramAnonymous2String)
          {
            AppMethodBeat.i(98277);
            paramAnonymous2String = new PInt();
            SightUploadUI.j(SightUploadUI.this).a(SightUploadUI.c(SightUploadUI.this), 0, null, SightUploadUI.d(SightUploadUI.this), null, SightUploadUI.e(SightUploadUI.this).getLocation(), null, i, SightUploadUI.f(SightUploadUI.this), SightUploadUI.g(SightUploadUI.this), paramAnonymous2String, "", SightUploadUI.h(SightUploadUI.this), SightUploadUI.i(SightUploadUI.this));
            g localg = g.yxI;
            long l1 = SightUploadUI.k(SightUploadUI.this);
            long l2 = bu.aRi();
            if (SightUploadUI.l(SightUploadUI.this))
            {
              i = 0;
              localg.f(13303, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymous2String.value), "" });
              l1 = SightUploadUI.k(SightUploadUI.this);
              l2 = bu.aRi();
              if (!SightUploadUI.l(SightUploadUI.this)) {
                break label283;
              }
            }
            label283:
            for (int i = 0;; i = 1)
            {
              ae.d("MicroMsg.SightUploadUI", "reprot timelinePostAction(13303), %d, %d, %d, %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymous2String.value) });
              AppMethodBeat.o(98277);
              return;
              i = 1;
              break;
            }
          }
          
          public final void aUT() {}
          
          public final void cW(String paramAnonymous2String)
          {
            AppMethodBeat.i(163078);
            com.tencent.mm.ui.base.h.l(SightUploadUI.this, 2131764058, 2131764059);
            AppMethodBeat.o(163078);
          }
        });
        AppMethodBeat.o(98279);
        return false;
      }
    }, null, s.b.JwC);
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
      localObject1 = this.Anq;
      if (paramIntent != null)
      {
        if (paramInt1 != 10) {
          break label81;
        }
        ((SnsSightUploadSayFooter)localObject1).AzZ.aO(paramIntent);
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
            ((SnsSightUploadSayFooter)localObject1).AzY.a(paramInt1, paramInt2, paramIntent, null);
          }
        }
        else
        {
          paramInt2 = paramIntent.getIntExtra("Ktag_range_index", 0);
          if (paramInt2 >= 2)
          {
            this.AmN = paramIntent.getStringExtra("Klabel_name_list");
            this.AmO = paramIntent.getStringExtra("Kother_user_name_list");
            localObject1 = Arrays.asList(this.AmN.split(","));
            if (bu.isNullOrNil(this.AmO)) {
              break label531;
            }
          }
        }
      }
    }
    label528:
    label531:
    for (paramIntent = Arrays.asList(this.AmO.split(","));; paramIntent = null)
    {
      this.Ans = new ArrayList();
      Object localObject2;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          localObject2 = com.tencent.mm.plugin.label.a.a.dig().apr(com.tencent.mm.plugin.label.a.a.dig().apo((String)localObject2));
          if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
            break label324;
          }
          ae.e("MicroMsg.SightUploadUI", "dz: getContactNamesFromLabels,namelist get bu label is null");
        }
      }
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        paramInt1 = 0;
        label291:
        if (((Iterator)localObject1).hasNext())
        {
          if (bu.isNullOrNil((String)((Iterator)localObject1).next())) {
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
          if (!this.Ans.contains(str))
          {
            this.Ans.add(str);
            ae.d("MicroMsg.SightUploadUI", "dz:name : %s", new Object[] { str });
          }
        }
        break;
        this.AkD = paramInt1;
        this.AkE = 0;
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            if (!this.Ans.contains(localObject1))
            {
              this.Ans.add(localObject1);
              this.AkE += 1;
            }
          }
        }
        if (paramInt2 == 2) {}
        for (this.Ant = false; 1 == paramInt2; this.Ant = true)
        {
          this.Akv = 1;
          AppMethodBeat.o(98285);
          return;
        }
        this.Akv = 0;
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
    this.Anw = getResources().getDisplayMetrics();
    this.Ano = new ar(this);
    this.Ano.aq(paramBundle);
    this.Anp = ((LinearLayout)findViewById(2131306993));
    this.Anp.addView(this.Ano.edm());
    setMMTitle(2131764037);
    getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(2131100017));
    this.Anu = getIntent().getBooleanExtra("KSnsPostManu", false);
    this.Anv = getIntent().getLongExtra("KTouchCameraTime", 0L);
    initView();
    com.tencent.mm.pluginsdk.h.r(this);
    AppMethodBeat.o(98280);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98283);
    super.onDestroy();
    this.Ano.edo();
    this.Anq.AzZ.stop();
    SnsSightUploadSayFooter localSnsSightUploadSayFooter = this.Anq;
    if (localSnsSightUploadSayFooter.qdo != null)
    {
      localSnsSightUploadSayFooter.qdo.ffs();
      localSnsSightUploadSayFooter.qdo.destroy();
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
    ae.d("MicroMsg.SightUploadUI", "onResume");
    SnsSightUploadSayFooter localSnsSightUploadSayFooter = this.Anq;
    if (localSnsSightUploadSayFooter.qdo.getVisibility() == 8) {
      localSnsSightUploadSayFooter.fNT.showVKB();
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