package com.tencent.mm.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.protocal.protobuf.fng;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.CustomViewPager;
import java.util.HashMap;

@com.tencent.mm.kernel.k
public class AlbumUI
  extends MMSecDataActivity
{
  private DoubleTabView adua;
  private HashMap<Integer, MMFragment> adub;
  private boolean aduc;
  private boolean adud;
  private CustomViewPager mViewPager;
  
  public AlbumUI()
  {
    AppMethodBeat.i(32932);
    this.adua = null;
    this.mViewPager = null;
    this.adub = new HashMap();
    this.aduc = false;
    this.adud = false;
    AppMethodBeat.o(32932);
  }
  
  protected void dealContentView(View paramView)
  {
    AppMethodBeat.i(32934);
    super.dealContentView(paramView);
    this.aduc = getIntent().getBooleanExtra("story_only", false);
    this.adud = getIntent().getBooleanExtra("story_dot", false);
    if (Util.getInt(d.dNI().a("clicfg_sns_reset_userpage_md5", "1", false, true), 1) > 0)
    {
      Log.i("MicroMsg.AlbumUI", "AlbumUI resetMd5");
      al.hgF().hkU();
    }
    this.adua = ((DoubleTabView)findViewById(R.h.fqZ));
    if (this.aduc)
    {
      this.adua.setVisibility(8);
      this.mViewPager = ((CustomViewPager)findViewById(R.h.fra));
      this.mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt) {}
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
        {
          AppMethodBeat.i(249410);
          AlbumUI.b(AlbumUI.this).t(paramAnonymousInt1, paramAnonymousFloat);
          AppMethodBeat.o(249410);
        }
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(249414);
          AlbumUI.b(AlbumUI.this).setTo(paramAnonymousInt);
          com.tencent.mm.plugin.textstatus.a.f localf;
          if (paramAnonymousInt == 0)
          {
            localObject = com.tencent.mm.plugin.story.g.h.SqZ;
            com.tencent.mm.plugin.story.g.h.hya().iwZ = 3L;
            localObject = com.tencent.mm.plugin.story.g.h.SqZ;
            com.tencent.mm.plugin.story.g.h.hyb();
            if ((!ac.hFS()) || (paramAnonymousInt != 1)) {
              break label166;
            }
            localf = (com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class);
            if (!AlbumUI.b(AlbumUI.this).adxU) {
              break label160;
            }
          }
          label160:
          for (Object localObject = "1";; localObject = "0")
          {
            localf.report22208(13L, (String)localObject);
            com.tencent.mm.plugin.newtips.a.gtf().aeI(37);
            AlbumUI.this.showOptionMenu(true);
            AppMethodBeat.o(249414);
            return;
            localObject = com.tencent.mm.plugin.story.g.h.SqZ;
            com.tencent.mm.plugin.story.g.h.hya().iwZ = 2L;
            if (!AlbumUI.c(AlbumUI.this)) {
              break;
            }
            AlbumUI.b(AlbumUI.this).KW(false);
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acYU, Boolean.FALSE);
            break;
          }
          label166:
          AlbumUI.this.showOptionMenu(false);
          AppMethodBeat.o(249414);
        }
      });
      this.mViewPager.setAdapter(new AlbumUI.a(this, getSupportFragmentManager()));
      paramView = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.hya().iwZ = 3L;
      paramView = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.hyb();
      AppMethodBeat.o(32934);
      return;
    }
    this.adua.setFirstTabString(getResources().getString(R.l.grd));
    boolean bool = ac.hFS();
    if (bool) {}
    for (paramView = getResources().getString(R.l.gre);; paramView = getResources().getString(R.l.grf))
    {
      this.adua.setSecondTabString(paramView);
      if (bool)
      {
        paramView = new b(this.adua, "textstate_history");
        com.tencent.mm.plugin.newtips.a.gtf().h(paramView);
      }
      if (bool)
      {
        addIconOptionMenu(0, R.k.icons_outlined_more, new AlbumUI.1(this));
        showOptionMenu(false);
      }
      this.adua.setOnTabClickListener(new DoubleTabView.a()
      {
        public final void onTabClick(int paramAnonymousInt)
        {
          AppMethodBeat.i(249396);
          AlbumUI.a(AlbumUI.this).setCurrentItem(paramAnonymousInt, true);
          AppMethodBeat.o(249396);
        }
      });
      break;
    }
  }
  
  protected int getLayoutId()
  {
    return R.i.glG;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32933);
    aw.bW(this);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    MultiProcessMMKV.getMMKV("SnsMMKV").encode("SnsMMKVSnsUI", true);
    setRequestedOrientation(1);
    AppMethodBeat.o(32933);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(249242);
    MultiProcessMMKV.getMMKV("SnsMMKV").encode("SnsMMKVSnsUI", false);
    super.onDestroy();
    AppMethodBeat.o(249242);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class b
    implements com.tencent.mm.plugin.newtips.a.a
  {
    public DoubleTabView aduf;
    public String path;
    
    public b(DoubleTabView paramDoubleTabView, String paramString)
    {
      this.aduf = paramDoubleTabView;
      this.path = paramString;
    }
    
    public final void a(com.tencent.mm.plugin.newtips.a.k paramk, boolean paramBoolean) {}
    
    public final boolean a(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean fZD()
    {
      return false;
    }
    
    public final String getPath()
    {
      return this.path;
    }
    
    public final View getRoot()
    {
      return this.aduf;
    }
    
    public final boolean ym(boolean paramBoolean)
    {
      return false;
    }
    
    public final boolean yn(boolean paramBoolean)
    {
      AppMethodBeat.i(249107);
      if (paramBoolean) {
        this.aduf.KW(true);
      }
      for (;;)
      {
        AppMethodBeat.o(249107);
        return true;
        this.aduf.KW(false);
      }
    }
    
    public final boolean yo(boolean paramBoolean)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.AlbumUI
 * JD-Core Version:    0.7.0.1
 */