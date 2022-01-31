package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.CustomViewPager;
import java.util.HashMap;

@com.tencent.mm.kernel.i
public class AlbumUI
  extends MMActivity
{
  private CustomViewPager mViewPager;
  private DoubleTabView yTu;
  private HashMap<Integer, MMFragment> yTv;
  private boolean yTw;
  
  public AlbumUI()
  {
    AppMethodBeat.i(29109);
    this.yTu = null;
    this.mViewPager = null;
    this.yTv = new HashMap();
    this.yTw = false;
    AppMethodBeat.o(29109);
  }
  
  protected void dealContentView(View paramView)
  {
    AppMethodBeat.i(29110);
    super.dealContentView(paramView);
    this.yTw = getIntent().getBooleanExtra("story_dot", false);
    this.yTu = ((DoubleTabView)findViewById(2131826138));
    this.mViewPager = ((CustomViewPager)findViewById(2131826139));
    this.yTu.setFirstTabString(getResources().getString(2131296516));
    this.yTu.setSecondTabString(getResources().getString(2131296517));
    if (this.yTw) {
      this.yTu.qe(true);
    }
    this.yTu.setOnTabClickListener(new AlbumUI.1(this));
    this.mViewPager.setOnPageChangeListener(new AlbumUI.2(this));
    this.mViewPager.setAdapter(new AlbumUI.a(this, getSupportFragmentManager()));
    paramView = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDs().cWn = 3L;
    paramView = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDt();
    AppMethodBeat.o(29110);
  }
  
  protected int getLayoutId()
  {
    return 2130970140;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(138619);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    AppMethodBeat.o(138619);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.AlbumUI
 * JD-Core Version:    0.7.0.1
 */