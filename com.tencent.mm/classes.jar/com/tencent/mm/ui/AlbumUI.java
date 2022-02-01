package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.textstatus.a.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.report.MMSecDataActivity;
import java.util.HashMap;

@k
public class AlbumUI
  extends MMSecDataActivity
{
  private DoubleTabView VPU;
  private HashMap<Integer, MMFragment> VPV;
  private boolean VPW;
  private boolean VPX;
  private CustomViewPager mViewPager;
  
  public AlbumUI()
  {
    AppMethodBeat.i(32932);
    this.VPU = null;
    this.mViewPager = null;
    this.VPV = new HashMap();
    this.VPW = false;
    this.VPX = false;
    AppMethodBeat.o(32932);
  }
  
  protected void dealContentView(View paramView)
  {
    AppMethodBeat.i(32934);
    super.dealContentView(paramView);
    this.VPW = getIntent().getBooleanExtra("story_only", false);
    this.VPX = getIntent().getBooleanExtra("story_dot", false);
    if (Util.getInt(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_sns_reset_userpage_md5", "0", false, true), 0) > 0)
    {
      Log.i("MicroMsg.AlbumUI", "AlbumUI resetMd5");
      aj.fOM().fSI();
    }
    this.VPU = ((DoubleTabView)findViewById(R.h.dqL));
    if (this.VPW)
    {
      this.VPU.setVisibility(8);
      this.mViewPager = ((CustomViewPager)findViewById(R.h.dqM));
      this.mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt) {}
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
        {
          AppMethodBeat.i(279883);
          AlbumUI.b(AlbumUI.this).q(paramAnonymousInt1, paramAnonymousFloat);
          AppMethodBeat.o(279883);
        }
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(279884);
          AlbumUI.b(AlbumUI.this).setTo(paramAnonymousInt);
          Object localObject;
          if (paramAnonymousInt == 0)
          {
            localObject = com.tencent.mm.plugin.story.h.h.LOJ;
            com.tencent.mm.plugin.story.h.h.geI().gnG = 3L;
          }
          for (;;)
          {
            localObject = com.tencent.mm.plugin.story.h.h.LOJ;
            com.tencent.mm.plugin.story.h.h.geJ();
            if ((!t.gkZ()) || (paramAnonymousInt != 1)) {
              break;
            }
            ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).report22208(13L, "");
            AlbumUI.this.showOptionMenu(true);
            AppMethodBeat.o(279884);
            return;
            localObject = com.tencent.mm.plugin.story.h.h.LOJ;
            com.tencent.mm.plugin.story.h.h.geI().gnG = 2L;
            if (AlbumUI.c(AlbumUI.this))
            {
              localObject = AlbumUI.b(AlbumUI.this);
              if (((DoubleTabView)localObject).VTE != null) {
                ((DoubleTabView)localObject).VTE.FA(false);
              }
              com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vxi, Boolean.FALSE);
            }
          }
          AlbumUI.this.showOptionMenu(false);
          AppMethodBeat.o(279884);
        }
      });
      this.mViewPager.setAdapter(new a(getSupportFragmentManager()));
      paramView = com.tencent.mm.plugin.story.h.h.LOJ;
      com.tencent.mm.plugin.story.h.h.geI().gnG = 3L;
      paramView = com.tencent.mm.plugin.story.h.h.LOJ;
      com.tencent.mm.plugin.story.h.h.geJ();
      AppMethodBeat.o(32934);
      return;
    }
    this.VPU.setFirstTabString(getResources().getString(R.l.eoe));
    if (t.gkZ()) {}
    for (paramView = getResources().getString(R.l.eog);; paramView = getResources().getString(R.l.eoh))
    {
      this.VPU.setSecondTabString(paramView);
      if (t.gkZ())
      {
        addIconOptionMenu(0, R.k.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(270706);
            ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).goLikeListFromSelfHistory(AlbumUI.this.getContext());
            ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).report22208(18L, "");
            AppMethodBeat.o(270706);
            return true;
          }
        });
        showOptionMenu(false);
      }
      this.VPU.setOnTabClickListener(new DoubleTabView.a()
      {
        public final void onTabClick(int paramAnonymousInt)
        {
          AppMethodBeat.i(275974);
          AlbumUI.a(AlbumUI.this).setCurrentItem(paramAnonymousInt, true);
          AppMethodBeat.o(275974);
        }
      });
      break;
    }
  }
  
  protected int getLayoutId()
  {
    return R.i.eiH;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32933);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    MultiProcessMMKV.getMMKV("SnsMMKV").encode("SnsMMKVSnsUI", true);
    setRequestedOrientation(1);
    AppMethodBeat.o(32933);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(290027);
    MultiProcessMMKV.getMMKV("SnsMMKV").encode("SnsMMKVSnsUI", false);
    super.onDestroy();
    AppMethodBeat.o(290027);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends androidx.fragment.app.h
  {
    public a(e parame)
    {
      super();
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(291735);
      if (AlbumUI.d(AlbumUI.this))
      {
        AppMethodBeat.o(291735);
        return 1;
      }
      AppMethodBeat.o(291735);
      return 2;
    }
    
    public final Fragment getItem(int paramInt)
    {
      AppMethodBeat.i(291734);
      MMFragment localMMFragment = AlbumUI.a(AlbumUI.this, paramInt);
      AppMethodBeat.o(291734);
      return localMMFragment;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.AlbumUI
 * JD-Core Version:    0.7.0.1
 */