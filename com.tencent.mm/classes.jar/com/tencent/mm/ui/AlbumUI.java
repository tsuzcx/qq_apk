package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.textstatus.a.c;
import com.tencent.mm.plugin.textstatus.a.p;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.CustomViewPager;
import java.util.HashMap;

@i
public class AlbumUI
  extends MMActivity
{
  private DoubleTabView OwQ;
  private HashMap<Integer, MMFragment> OwR;
  private boolean OwS;
  private boolean OwT;
  private CustomViewPager mViewPager;
  
  public AlbumUI()
  {
    AppMethodBeat.i(32932);
    this.OwQ = null;
    this.mViewPager = null;
    this.OwR = new HashMap();
    this.OwS = false;
    this.OwT = false;
    AppMethodBeat.o(32932);
  }
  
  protected void dealContentView(View paramView)
  {
    AppMethodBeat.i(32934);
    super.dealContentView(paramView);
    this.OwS = getIntent().getBooleanExtra("story_only", false);
    this.OwT = getIntent().getBooleanExtra("story_dot", false);
    this.OwQ = ((DoubleTabView)findViewById(2131296700));
    if (this.OwS)
    {
      this.OwQ.setVisibility(8);
      this.mViewPager = ((CustomViewPager)findViewById(2131296705));
      this.mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt) {}
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
        {
          AppMethodBeat.i(232434);
          AlbumUI.b(AlbumUI.this).p(paramAnonymousInt1, paramAnonymousFloat);
          AppMethodBeat.o(232434);
        }
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(232435);
          AlbumUI.b(AlbumUI.this).setTo(paramAnonymousInt);
          Object localObject;
          if (paramAnonymousInt == 0)
          {
            localObject = h.FuH;
            h.fqm().erR = 3L;
          }
          for (;;)
          {
            localObject = h.FuH;
            h.fqn();
            if (p.fvC()) {
              ((c)com.tencent.mm.kernel.g.ah(c.class)).report22208(13L, "");
            }
            AppMethodBeat.o(232435);
            return;
            localObject = h.FuH;
            h.fqm().erR = 2L;
            if (AlbumUI.c(AlbumUI.this))
            {
              localObject = AlbumUI.b(AlbumUI.this);
              if (((DoubleTabView)localObject).OAr != null) {
                ((DoubleTabView)localObject).OAr.Bk(false);
              }
              com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OiS, Boolean.FALSE);
            }
          }
        }
      });
      this.mViewPager.setAdapter(new a(getSupportFragmentManager()));
      paramView = h.FuH;
      h.fqm().erR = 3L;
      paramView = h.FuH;
      h.fqn();
      AppMethodBeat.o(32934);
      return;
    }
    this.OwQ.setFirstTabString(getResources().getString(2131755283));
    if (p.fvC()) {}
    for (paramView = getResources().getString(2131755284);; paramView = getResources().getString(2131755285))
    {
      this.OwQ.setSecondTabString(paramView);
      addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(232432);
          ((c)com.tencent.mm.kernel.g.ah(c.class)).goLikeListFromSelfHistory(AlbumUI.this.getContext());
          ((c)com.tencent.mm.kernel.g.ah(c.class)).report22208(18L, "");
          AppMethodBeat.o(232432);
          return true;
        }
      });
      this.OwQ.setOnTabClickListener(new DoubleTabView.a()
      {
        public final void onTabClick(int paramAnonymousInt)
        {
          AppMethodBeat.i(232433);
          AlbumUI.a(AlbumUI.this).setCurrentItem(paramAnonymousInt, true);
          AppMethodBeat.o(232433);
        }
      });
      break;
    }
  }
  
  protected int getLayoutId()
  {
    return 2131495496;
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
      AppMethodBeat.i(232436);
      if (AlbumUI.d(AlbumUI.this))
      {
        AppMethodBeat.o(232436);
        return 1;
      }
      AppMethodBeat.o(232436);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.AlbumUI
 * JD-Core Version:    0.7.0.1
 */