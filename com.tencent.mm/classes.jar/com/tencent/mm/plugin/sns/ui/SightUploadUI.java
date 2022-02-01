package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.wa;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.MMEditText.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SightUploadUI
  extends MMActivity
{
  private int KGG = 0;
  private int KGN = 0;
  private int KGO = 0;
  private SnsEditText KJQ;
  private af KJR = null;
  private LinearLayout KJS;
  private SnsSightUploadSayFooter KJT;
  private ArrayList<String> KJU;
  private boolean KJV = false;
  private boolean KJW = false;
  private long KJX = 0L;
  DisplayMetrics KJY;
  private String KJq = "";
  private String KJr = "";
  private String desc = "";
  
  public int getLayoutId()
  {
    return i.g.sns_sight_upload_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98281);
    this.KJQ = ((SnsEditText)findViewById(i.f.sns_desc_tv));
    this.KJQ.getInputExtras(true).putInt("wechat_scene", 3);
    this.KJQ.getInputExtras(true).putBoolean("if_support_wx_emoji", true);
    int i = this.KJQ.getPaddingLeft();
    int j = this.KJS.getPaddingRight();
    int k = this.KJY.widthPixels;
    this.KJQ.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98272);
        SightUploadUI.a(SightUploadUI.this).setWidth((int)(this.KJZ * 0.7D));
        SightUploadUI.b(SightUploadUI.this).setLayoutParams(new LinearLayout.LayoutParams((int)(this.KJZ * 0.3D), SightUploadUI.b(SightUploadUI.this).getHeight()));
        AppMethodBeat.o(98272);
      }
    }, 100L);
    if (!Util.isNullOrNil(getIntent().getStringExtra("Kdescription"))) {
      this.KJQ.setText(getIntent().getStringExtra("Kdescription"));
    }
    this.KJQ.setBackListener(new MMEditText.a()
    {
      public final void onBack()
      {
        AppMethodBeat.i(98273);
        SightUploadUI.this.hideVKB();
        wa localwa = new wa();
        localwa.fVd.type = 0;
        localwa.fVd.fVf = false;
        EventCenter.instance.publish(localwa);
        SightUploadUI.this.finish();
        AppMethodBeat.o(98273);
      }
    });
    this.KJT = ((SnsSightUploadSayFooter)findViewById(i.f.say_footer));
    this.KJT.setMMEditText(this.KJQ);
    this.KJT.setVisibility(0);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98274);
        paramAnonymousMenuItem = new wa();
        paramAnonymousMenuItem.fVd.type = 0;
        paramAnonymousMenuItem.fVd.fVf = false;
        EventCenter.instance.publish(paramAnonymousMenuItem);
        SightUploadUI.this.hideVKB();
        SightUploadUI.this.finish();
        AppMethodBeat.o(98274);
        return true;
      }
    });
    if (getIntent().getBooleanExtra("KSightDraftEntrance", true)) {
      addIconOptionMenu(1, i.i.sight_draft_menu, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(98276);
          paramAnonymousMenuItem = SightUploadUI.this.getContext();
          String str = SightUploadUI.this.getString(i.j.sight_save_tips);
          h.d local1 = new h.d()
          {
            public final void qy(int paramAnonymous2Int)
            {
              AppMethodBeat.i(98275);
              switch (paramAnonymous2Int)
              {
              }
              for (;;)
              {
                AppMethodBeat.o(98275);
                return;
                wa localwa = new wa();
                localwa.fVd.type = 0;
                localwa.fVd.fVh = true;
                localwa.fVd.fVf = true;
                EventCenter.instance.publish(localwa);
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
    addTextOptionMenu(0, getString(i.j.app_send), new MenuItem.OnMenuItemClickListener()
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
        com.tencent.mm.ui.tools.b.c.i(SightUploadUI.a(SightUploadUI.this)).axx(com.tencent.mm.n.c.awC()).Hh(true).a(new c.a()
        {
          public final void abc(String paramAnonymous2String)
          {
            AppMethodBeat.i(98277);
            paramAnonymous2String = new PInt();
            SightUploadUI.j(SightUploadUI.this).a(SightUploadUI.c(SightUploadUI.this), 0, null, SightUploadUI.d(SightUploadUI.this), null, SightUploadUI.e(SightUploadUI.this).getLocation(), null, i, SightUploadUI.f(SightUploadUI.this), SightUploadUI.g(SightUploadUI.this), paramAnonymous2String, "", SightUploadUI.h(SightUploadUI.this), SightUploadUI.i(SightUploadUI.this));
            com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
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
          
          public final void abd(String paramAnonymous2String) {}
          
          public final void dN(String paramAnonymous2String)
          {
            AppMethodBeat.i(163078);
            com.tencent.mm.ui.base.h.p(SightUploadUI.this, i.j.sns_upload_post_text_invalid_more, i.j.sns_upload_post_text_invalid_title);
            AppMethodBeat.o(163078);
          }
        });
        AppMethodBeat.o(98279);
        return false;
      }
    }, null, w.b.Waq);
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
      localObject1 = this.KJT;
      if (paramIntent != null)
      {
        if (paramInt1 != 10) {
          break label84;
        }
        ((SnsSightUploadSayFooter)localObject1).KXw.aY(paramIntent);
      }
    }
    for (;;)
    {
      if (paramInt1 == 5) {
        if (paramIntent == null)
        {
          AppMethodBeat.o(98285);
          return;
          label84:
          if (paramInt1 == 5) {
            ((SnsSightUploadSayFooter)localObject1).KXv.a(paramInt1, paramInt2, paramIntent, null);
          }
        }
        else
        {
          paramInt2 = paramIntent.getIntExtra("Ktag_range_index", 0);
          if (paramInt2 >= 2)
          {
            this.KJq = paramIntent.getStringExtra("Klabel_name_list");
            this.KJr = paramIntent.getStringExtra("Kother_user_name_list");
            localObject1 = Arrays.asList(this.KJq.split(","));
            if (Util.isNullOrNil(this.KJr)) {
              break label539;
            }
          }
        }
      }
    }
    label536:
    label539:
    for (paramIntent = Arrays.asList(this.KJr.split(","));; paramIntent = null)
    {
      this.KJU = new ArrayList();
      Object localObject2;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          localObject2 = a.eLe().aMR(a.eLe().aMO((String)localObject2));
          if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
            break label330;
          }
          Log.e("MicroMsg.SightUploadUI", "dz: getContactNamesFromLabels,namelist get bu label is null");
        }
      }
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        paramInt1 = 0;
        label297:
        if (((Iterator)localObject1).hasNext())
        {
          if (Util.isNullOrNil((String)((Iterator)localObject1).next())) {
            break label536;
          }
          paramInt1 += 1;
        }
      }
      for (;;)
      {
        break label297;
        label330:
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          if (!this.KJU.contains(str))
          {
            this.KJU.add(str);
            Log.d("MicroMsg.SightUploadUI", "dz:name : %s", new Object[] { str });
          }
        }
        break;
        this.KGN = paramInt1;
        this.KGO = 0;
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            if (!this.KJU.contains(localObject1))
            {
              this.KJU.add(localObject1);
              this.KGO += 1;
            }
          }
        }
        if (paramInt2 == 2) {}
        for (this.KJV = false; 1 == paramInt2; this.KJV = true)
        {
          this.KGG = 1;
          AppMethodBeat.o(98285);
          return;
        }
        this.KGG = 0;
        AppMethodBeat.o(98285);
        return;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98280);
    com.tencent.mm.pluginsdk.h.r(this);
    super.onCreate(paramBundle);
    this.KJY = getResources().getDisplayMetrics();
    this.KJR = new aw(this);
    this.KJR.ay(paramBundle);
    this.KJS = ((LinearLayout)findViewById(i.f.widget_content));
    this.KJS.addView(this.KJR.fTx());
    setMMTitle(i.j.sns_timeline_ui_title);
    getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(i.c.black));
    this.KJW = getIntent().getBooleanExtra("KSnsPostManu", false);
    this.KJX = getIntent().getLongExtra("KTouchCameraTime", 0L);
    initView();
    com.tencent.mm.pluginsdk.h.s(this);
    AppMethodBeat.o(98280);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98283);
    super.onDestroy();
    this.KJR.fTA();
    this.KJT.KXw.stop();
    SnsSightUploadSayFooter localSnsSightUploadSayFooter = this.KJT;
    if (localSnsSightUploadSayFooter.jPN != null)
    {
      localSnsSightUploadSayFooter.jPN.hjm();
      localSnsSightUploadSayFooter.jPN.destroy();
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
    SnsSightUploadSayFooter localSnsSightUploadSayFooter = this.KJT;
    if (localSnsSightUploadSayFooter.jPN.getVisibility() == 8) {
      localSnsSightUploadSayFooter.iXq.showVKB();
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