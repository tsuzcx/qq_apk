package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.autogen.a.xr;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.MMEditText.a;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SightUploadUI
  extends MMActivity
{
  private int Rgh = 0;
  private int Rgo = 0;
  private int Rgp = 0;
  private String RiR = "";
  private String RiS = "";
  DisplayMetrics RjA;
  private SnsEditText Rjs;
  private ag Rjt = null;
  private LinearLayout Rju;
  private SnsSightUploadSayFooter Rjv;
  private ArrayList<String> Rjw;
  private boolean Rjx = false;
  private boolean Rjy = false;
  private long Rjz = 0L;
  private String desc = "";
  
  public int getLayoutId()
  {
    return b.g.sns_sight_upload_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98281);
    this.Rjs = ((SnsEditText)findViewById(b.f.sns_desc_tv));
    this.Rjs.getInputExtras(true).putInt("wechat_scene", 3);
    this.Rjs.getInputExtras(true).putBoolean("if_support_wx_emoji", true);
    int i = this.Rjs.getPaddingLeft();
    int j = this.Rju.getPaddingRight();
    int k = this.RjA.widthPixels;
    this.Rjs.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98272);
        SightUploadUI.a(SightUploadUI.this).setWidth((int)(this.RjB * 0.7D));
        SightUploadUI.b(SightUploadUI.this).setLayoutParams(new LinearLayout.LayoutParams((int)(this.RjB * 0.3D), SightUploadUI.b(SightUploadUI.this).getHeight()));
        AppMethodBeat.o(98272);
      }
    }, 100L);
    if (!Util.isNullOrNil(getIntent().getStringExtra("Kdescription"))) {
      this.Rjs.setText(getIntent().getStringExtra("Kdescription"));
    }
    this.Rjs.setBackListener(new MMEditText.a()
    {
      public final void onBack()
      {
        AppMethodBeat.i(98273);
        SightUploadUI.this.hideVKB();
        xr localxr = new xr();
        localxr.iba.type = 0;
        localxr.iba.ibc = false;
        localxr.publish();
        SightUploadUI.this.finish();
        AppMethodBeat.o(98273);
      }
    });
    this.Rjv = ((SnsSightUploadSayFooter)findViewById(b.f.say_footer));
    this.Rjv.setMMEditText(this.Rjs);
    this.Rjv.setVisibility(0);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98274);
        paramAnonymousMenuItem = new xr();
        paramAnonymousMenuItem.iba.type = 0;
        paramAnonymousMenuItem.iba.ibc = false;
        paramAnonymousMenuItem.publish();
        SightUploadUI.this.hideVKB();
        SightUploadUI.this.finish();
        AppMethodBeat.o(98274);
        return true;
      }
    });
    if (getIntent().getBooleanExtra("KSightDraftEntrance", true)) {
      addIconOptionMenu(1, b.i.sight_draft_menu, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(98276);
          paramAnonymousMenuItem = SightUploadUI.this.getContext();
          String str = SightUploadUI.this.getString(b.j.sight_save_tips);
          k.d local1 = new k.d()
          {
            public final void qz(int paramAnonymous2Int)
            {
              AppMethodBeat.i(98275);
              switch (paramAnonymous2Int)
              {
              }
              for (;;)
              {
                AppMethodBeat.o(98275);
                return;
                xr localxr = new xr();
                localxr.iba.type = 0;
                localxr.iba.ibe = true;
                localxr.iba.ibc = true;
                localxr.publish();
                SightUploadUI.this.hideVKB();
                SightUploadUI.this.finish();
              }
            }
          };
          k.a(paramAnonymousMenuItem, null, new String[] { str }, null, local1);
          AppMethodBeat.o(98276);
          return false;
        }
      });
    }
    addTextOptionMenu(0, getString(b.j.app_send), new MenuItem.OnMenuItemClickListener()
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
        com.tencent.mm.ui.tools.b.c.i(SightUploadUI.a(SightUploadUI.this)).aEg(com.tencent.mm.k.c.aRc()).Nc(true).a(new c.a()
        {
          public final void Tw(String paramAnonymous2String)
          {
            AppMethodBeat.i(98277);
            paramAnonymous2String = new PInt();
            SightUploadUI.j(SightUploadUI.this).a(SightUploadUI.c(SightUploadUI.this), 0, null, SightUploadUI.d(SightUploadUI.this), null, SightUploadUI.e(SightUploadUI.this).getLocation(), null, i, SightUploadUI.f(SightUploadUI.this), SightUploadUI.g(SightUploadUI.this), paramAnonymous2String, "", SightUploadUI.h(SightUploadUI.this), SightUploadUI.i(SightUploadUI.this));
            com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
            long l1 = SightUploadUI.k(SightUploadUI.this);
            long l2 = Util.nowSecond();
            if (SightUploadUI.l(SightUploadUI.this))
            {
              i = 0;
              localh.b(13303, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymous2String.value), "" });
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
          
          public final void eY(String paramAnonymous2String)
          {
            AppMethodBeat.i(163078);
            k.s(SightUploadUI.this, b.j.sns_upload_post_text_invalid_more, b.j.sns_upload_post_text_invalid_title);
            AppMethodBeat.o(163078);
          }
        });
        AppMethodBeat.o(98279);
        return false;
      }
    }, null, y.b.adEL);
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
      localObject1 = this.Rjv;
      if (paramIntent != null)
      {
        if (paramInt1 != 10) {
          break label84;
        }
        ((SnsSightUploadSayFooter)localObject1).Rxx.by(paramIntent);
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
            ((SnsSightUploadSayFooter)localObject1).Rxw.a(paramInt1, paramInt2, paramIntent, null);
          }
        }
        else
        {
          paramInt2 = paramIntent.getIntExtra("Ktag_range_index", 0);
          if (paramInt2 >= 2)
          {
            this.RiR = paramIntent.getStringExtra("Klabel_name_list");
            this.RiS = paramIntent.getStringExtra("Kother_user_name_list");
            localObject1 = Arrays.asList(this.RiR.split(","));
            if (Util.isNullOrNil(this.RiS)) {
              break label539;
            }
          }
        }
      }
    }
    label536:
    label539:
    for (paramIntent = Arrays.asList(this.RiS.split(","));; paramIntent = null)
    {
      this.Rjw = new ArrayList();
      Object localObject2;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          localObject2 = a.fTb().aJK(a.fTb().aJH((String)localObject2));
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
          if (!this.Rjw.contains(str))
          {
            this.Rjw.add(str);
            Log.d("MicroMsg.SightUploadUI", "dz:name : %s", new Object[] { str });
          }
        }
        break;
        this.Rgo = paramInt1;
        this.Rgp = 0;
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            if (!this.Rjw.contains(localObject1))
            {
              this.Rjw.add(localObject1);
              this.Rgp += 1;
            }
          }
        }
        if (paramInt2 == 2) {}
        for (this.Rjx = false; 1 == paramInt2; this.Rjx = true)
        {
          this.Rgh = 1;
          AppMethodBeat.o(98285);
          return;
        }
        this.Rgh = 0;
        AppMethodBeat.o(98285);
        return;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98280);
    com.tencent.mm.pluginsdk.h.w(this);
    super.onCreate(paramBundle);
    this.RjA = getResources().getDisplayMetrics();
    this.Rjt = new ax(this);
    this.Rjt.aZ(paramBundle);
    this.Rju = ((LinearLayout)findViewById(b.f.widget_content));
    this.Rju.addView(this.Rjt.hlQ());
    setMMTitle(b.j.sns_timeline_ui_title);
    getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(b.c.black));
    this.Rjy = getIntent().getBooleanExtra("KSnsPostManu", false);
    this.Rjz = getIntent().getLongExtra("KTouchCameraTime", 0L);
    initView();
    com.tencent.mm.pluginsdk.h.x(this);
    AppMethodBeat.o(98280);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98283);
    super.onDestroy();
    this.Rjt.hlT();
    this.Rjv.Rxx.stop();
    SnsSightUploadSayFooter localSnsSightUploadSayFooter = this.Rjv;
    if (localSnsSightUploadSayFooter.moD != null)
    {
      localSnsSightUploadSayFooter.moD.iKg();
      localSnsSightUploadSayFooter.moD.destroy();
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
    SnsSightUploadSayFooter localSnsSightUploadSayFooter = this.Rjv;
    if (localSnsSightUploadSayFooter.moD.getVisibility() == 8) {
      localSnsSightUploadSayFooter.lzt.showVKB();
    }
    AppMethodBeat.o(98282);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightUploadUI
 * JD-Core Version:    0.7.0.1
 */