package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.CustomViewPager;
import java.util.HashMap;

@i
public class AlbumUI
  extends MMActivity
{
  private DoubleTabView ISp;
  private HashMap<Integer, MMFragment> ISq;
  private boolean ISr;
  private CustomViewPager mViewPager;
  
  public AlbumUI()
  {
    AppMethodBeat.i(32932);
    this.ISp = null;
    this.mViewPager = null;
    this.ISq = new HashMap();
    this.ISr = false;
    AppMethodBeat.o(32932);
  }
  
  protected void dealContentView(View paramView)
  {
    AppMethodBeat.i(32934);
    super.dealContentView(paramView);
    this.ISr = getIntent().getBooleanExtra("story_dot", false);
    this.ISp = ((DoubleTabView)findViewById(2131296623));
    this.mViewPager = ((CustomViewPager)findViewById(2131296628));
    this.ISp.setFirstTabString(getResources().getString(2131755249));
    this.ISp.setSecondTabString(getResources().getString(2131755250));
    if (this.ISr) {
      this.ISp.xa(true);
    }
    this.ISp.setOnTabClickListener(new DoubleTabView.a()
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
        AlbumUI.b(AlbumUI.this).o(paramAnonymousInt1, paramAnonymousFloat);
        AppMethodBeat.o(32929);
      }
      
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(32930);
        AlbumUI.b(AlbumUI.this).setTo(paramAnonymousInt);
        h localh;
        if (paramAnonymousInt == 0)
        {
          localh = h.ASt;
          h.ekd().emv = 3L;
        }
        for (;;)
        {
          localh = h.ASt;
          h.eke();
          AppMethodBeat.o(32930);
          return;
          localh = h.ASt;
          h.ekd().emv = 2L;
          if (AlbumUI.c(AlbumUI.this))
          {
            AlbumUI.b(AlbumUI.this).xa(false);
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IFM, Boolean.FALSE);
          }
        }
      }
    });
    this.mViewPager.setAdapter(new a(getSupportFragmentManager()));
    paramView = h.ASt;
    h.ekd().emv = 3L;
    paramView = h.ASt;
    h.eke();
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
  
  final class a
    extends j
  {
    public a(android.support.v4.app.g paramg)
    {
      super();
    }
    
    public final int getCount()
    {
      return 2;
    }
    
    public final Fragment getItem(int paramInt)
    {
      AppMethodBeat.i(32931);
      MMFragment localMMFragment = AlbumUI.a(AlbumUI.this, paramInt);
      AppMethodBeat.o(32931);
      return localMMFragment;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.AlbumUI
 * JD-Core Version:    0.7.0.1
 */