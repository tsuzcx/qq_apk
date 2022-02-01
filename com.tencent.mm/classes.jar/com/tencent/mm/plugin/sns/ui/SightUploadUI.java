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
import com.tencent.mm.g.a.uw;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.MMEditText.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SightUploadUI
  extends MMActivity
{
  private int Etj = 0;
  private int Etq = 0;
  private int Etr = 0;
  private String EvA = "";
  private SnsEditText EvZ;
  private String Evz = "";
  private ad Ewa = null;
  private LinearLayout Ewb;
  private SnsSightUploadSayFooter Ewc;
  private ArrayList<String> Ewd;
  private boolean Ewe = false;
  private boolean Ewf = false;
  private long Ewg = 0L;
  DisplayMetrics Ewh;
  private String desc = "";
  
  public int getLayoutId()
  {
    return 2131496488;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98281);
    this.EvZ = ((SnsEditText)findViewById(2131308111));
    int i = this.EvZ.getPaddingLeft();
    int j = this.Ewb.getPaddingRight();
    int k = this.Ewh.widthPixels;
    this.EvZ.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98272);
        SightUploadUI.a(SightUploadUI.this).setWidth((int)(this.Ewi * 0.7D));
        SightUploadUI.b(SightUploadUI.this).setLayoutParams(new LinearLayout.LayoutParams((int)(this.Ewi * 0.3D), SightUploadUI.b(SightUploadUI.this).getHeight()));
        AppMethodBeat.o(98272);
      }
    }, 100L);
    if (!Util.isNullOrNil(getIntent().getStringExtra("Kdescription"))) {
      this.EvZ.setText(getIntent().getStringExtra("Kdescription"));
    }
    this.EvZ.setBackListener(new MMEditText.a()
    {
      public final void onBack()
      {
        AppMethodBeat.i(98273);
        SightUploadUI.this.hideVKB();
        uw localuw = new uw();
        localuw.ebg.type = 0;
        localuw.ebg.ebi = false;
        EventCenter.instance.publish(localuw);
        SightUploadUI.this.finish();
        AppMethodBeat.o(98273);
      }
    });
    this.Ewc = ((SnsSightUploadSayFooter)findViewById(2131307218));
    this.Ewc.setMMEditText(this.EvZ);
    this.Ewc.setVisibility(0);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98274);
        paramAnonymousMenuItem = new uw();
        paramAnonymousMenuItem.ebg.type = 0;
        paramAnonymousMenuItem.ebg.ebi = false;
        EventCenter.instance.publish(paramAnonymousMenuItem);
        SightUploadUI.this.hideVKB();
        SightUploadUI.this.finish();
        AppMethodBeat.o(98274);
        return true;
      }
    });
    if (getIntent().getBooleanExtra("KSightDraftEntrance", true)) {
      addIconOptionMenu(1, 2131691487, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(98276);
          paramAnonymousMenuItem = SightUploadUI.this.getContext();
          String str = SightUploadUI.this.getString(2131765901);
          h.d local1 = new h.d()
          {
            public final void oj(int paramAnonymous2Int)
            {
              AppMethodBeat.i(98275);
              switch (paramAnonymous2Int)
              {
              }
              for (;;)
              {
                AppMethodBeat.o(98275);
                return;
                uw localuw = new uw();
                localuw.ebg.type = 0;
                localuw.ebg.ebk = true;
                localuw.ebg.ebi = true;
                EventCenter.instance.publish(localuw);
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
    addTextOptionMenu(0, getString(2131755976), new MenuItem.OnMenuItemClickListener()
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
        com.tencent.mm.ui.tools.b.c.f(SightUploadUI.a(SightUploadUI.this)).aoq(com.tencent.mm.n.c.aqj()).CN(true).a(new c.a()
        {
          public final void Tw(String paramAnonymous2String)
          {
            AppMethodBeat.i(98277);
            paramAnonymous2String = new PInt();
            SightUploadUI.j(SightUploadUI.this).a(SightUploadUI.c(SightUploadUI.this), 0, null, SightUploadUI.d(SightUploadUI.this), null, SightUploadUI.e(SightUploadUI.this).getLocation(), null, i, SightUploadUI.f(SightUploadUI.this), SightUploadUI.g(SightUploadUI.this), paramAnonymous2String, "", SightUploadUI.h(SightUploadUI.this), SightUploadUI.i(SightUploadUI.this));
            com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
            long l1 = SightUploadUI.k(SightUploadUI.this);
            long l2 = Util.nowSecond();
            if (SightUploadUI.l(SightUploadUI.this))
            {
              i = 0;
              localh.a(13303, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymous2String.value), "" });
              l1 = SightUploadUI.k(SightUploadUI.this);
              l2 = Util.nowSecond();
              if (!SightUploadUI.l(SightUploadUI.this)) {
                break label283;
              }
            }
            label283:
            for (int i = 0;; i = 1)
            {
              Log.d("MicroMsg.SightUploadUI", "reprot timelinePostAction(13303), %d, %d, %d, %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymous2String.value) });
              AppMethodBeat.o(98277);
              return;
              i = 1;
              break;
            }
          }
          
          public final void Tx(String paramAnonymous2String) {}
          
          public final void dv(String paramAnonymous2String)
          {
            AppMethodBeat.i(163078);
            com.tencent.mm.ui.base.h.n(SightUploadUI.this, 2131766298, 2131766299);
            AppMethodBeat.o(163078);
          }
        });
        AppMethodBeat.o(98279);
        return false;
      }
    }, null, t.b.OGW);
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
      localObject1 = this.Ewc;
      if (paramIntent != null)
      {
        if (paramInt1 != 10) {
          break label81;
        }
        ((SnsSightUploadSayFooter)localObject1).EJv.aY(paramIntent);
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
            ((SnsSightUploadSayFooter)localObject1).EJu.a(paramInt1, paramInt2, paramIntent, null);
          }
        }
        else
        {
          paramInt2 = paramIntent.getIntExtra("Ktag_range_index", 0);
          if (paramInt2 >= 2)
          {
            this.Evz = paramIntent.getStringExtra("Klabel_name_list");
            this.EvA = paramIntent.getStringExtra("Kother_user_name_list");
            localObject1 = Arrays.asList(this.Evz.split(","));
            if (Util.isNullOrNil(this.EvA)) {
              break label531;
            }
          }
        }
      }
    }
    label528:
    label531:
    for (paramIntent = Arrays.asList(this.EvA.split(","));; paramIntent = null)
    {
      this.Ewd = new ArrayList();
      Object localObject2;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          localObject2 = a.ecg().aCK(a.ecg().aCH((String)localObject2));
          if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
            break label324;
          }
          Log.e("MicroMsg.SightUploadUI", "dz: getContactNamesFromLabels,namelist get bu label is null");
        }
      }
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        paramInt1 = 0;
        label291:
        if (((Iterator)localObject1).hasNext())
        {
          if (Util.isNullOrNil((String)((Iterator)localObject1).next())) {
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
          if (!this.Ewd.contains(str))
          {
            this.Ewd.add(str);
            Log.d("MicroMsg.SightUploadUI", "dz:name : %s", new Object[] { str });
          }
        }
        break;
        this.Etq = paramInt1;
        this.Etr = 0;
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            if (!this.Ewd.contains(localObject1))
            {
              this.Ewd.add(localObject1);
              this.Etr += 1;
            }
          }
        }
        if (paramInt2 == 2) {}
        for (this.Ewe = false; 1 == paramInt2; this.Ewe = true)
        {
          this.Etj = 1;
          AppMethodBeat.o(98285);
          return;
        }
        this.Etj = 0;
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
    this.Ewh = getResources().getDisplayMetrics();
    this.Ewa = new au(this);
    this.Ewa.aC(paramBundle);
    this.Ewb = ((LinearLayout)findViewById(2131310505));
    this.Ewb.addView(this.Ewa.ffB());
    setMMTitle(2131766275);
    getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(2131100042));
    this.Ewf = getIntent().getBooleanExtra("KSnsPostManu", false);
    this.Ewg = getIntent().getLongExtra("KTouchCameraTime", 0L);
    initView();
    com.tencent.mm.pluginsdk.h.r(this);
    AppMethodBeat.o(98280);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98283);
    super.onDestroy();
    this.Ewa.ffE();
    this.Ewc.EJv.stop();
    SnsSightUploadSayFooter localSnsSightUploadSayFooter = this.Ewc;
    if (localSnsSightUploadSayFooter.rum != null)
    {
      localSnsSightUploadSayFooter.rum.goC();
      localSnsSightUploadSayFooter.rum.destroy();
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
    Log.d("MicroMsg.SightUploadUI", "onResume");
    SnsSightUploadSayFooter localSnsSightUploadSayFooter = this.Ewc;
    if (localSnsSightUploadSayFooter.rum.getVisibility() == 8) {
      localSnsSightUploadSayFooter.gte.showVKB();
    }
    AppMethodBeat.o(98282);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightUploadUI
 * JD-Core Version:    0.7.0.1
 */