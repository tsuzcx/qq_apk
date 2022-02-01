package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.CustomViewPager;
import java.util.HashMap;

@i
public class AlbumUI
  extends MMActivity
{
  private DoubleTabView HeY;
  private HashMap<Integer, MMFragment> HeZ;
  private boolean Hfa;
  private CustomViewPager mViewPager;
  
  public AlbumUI()
  {
    AppMethodBeat.i(32932);
    this.HeY = null;
    this.mViewPager = null;
    this.HeZ = new HashMap();
    this.Hfa = false;
    AppMethodBeat.o(32932);
  }
  
  protected void dealContentView(View paramView)
  {
    AppMethodBeat.i(32934);
    super.dealContentView(paramView);
    this.Hfa = getIntent().getBooleanExtra("story_dot", false);
    this.HeY = ((DoubleTabView)findViewById(2131296623));
    this.mViewPager = ((CustomViewPager)findViewById(2131296628));
    this.HeY.setFirstTabString(getResources().getString(2131755249));
    this.HeY.setSecondTabString(getResources().getString(2131755250));
    if (this.Hfa) {
      this.HeY.wo(true);
    }
    this.HeY.setOnTabClickListener(new DoubleTabView.a()
    {
      public final void onTabClick(int paramAnonymousInt)
      {
        AppMethodBeat.i(32928);
        AlbumUI.a(AlbumUI.this).setCurrentItem(paramAnonymousInt, true);
        AppMethodBeat.o(32928);
      }
    });
    this.mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public final void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32929);
        AlbumUI.b(AlbumUI.this).n(paramAnonymousInt1, paramAnonymousFloat);
        AppMethodBeat.o(32929);
      }
      
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(32930);
        AlbumUI.b(AlbumUI.this).setTo(paramAnonymousInt);
        h localh;
        if (paramAnonymousInt == 0)
        {
          localh = h.zAU;
          h.dXO().dWf = 3L;
        }
        for (;;)
        {
          localh = h.zAU;
          h.dXP();
          AppMethodBeat.o(32930);
          return;
          localh = h.zAU;
          h.dXO().dWf = 2L;
          if (AlbumUI.c(AlbumUI.this))
          {
            AlbumUI.b(AlbumUI.this).wo(false);
            g.agR().agA().set(ah.a.GTh, Boolean.FALSE);
          }
        }
      }
    });
    this.mViewPager.setAdapter(new AlbumUI.a(this, getSupportFragmentManager()));
    paramView = h.zAU;
    h.dXO().dWf = 3L;
    paramView = h.zAU;
    h.dXP();
    AppMethodBeat.o(32934);
  }
  
  protected int getLayoutId()
  {
    return 2131494762;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32933);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
    AppMethodBeat.o(32933);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.AlbumUI
 * JD-Core Version:    0.7.0.1
 */