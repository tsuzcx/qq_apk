package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class FileSelectorFolderView
  extends LinearLayout
  implements AdapterView.OnItemClickListener
{
  boolean Zb;
  private FrameLayout nfH;
  private View nfI;
  private ListView nfJ;
  private boolean nfL;
  private FileSelectorFolderView.a wev;
  private FileSelectorFolderView.b wew;
  
  public FileSelectorFolderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(28164);
    this.wev = null;
    this.Zb = false;
    this.nfL = false;
    init();
    AppMethodBeat.o(28164);
  }
  
  public FileSelectorFolderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28165);
    this.wev = null;
    this.Zb = false;
    this.nfL = false;
    init();
    AppMethodBeat.o(28165);
  }
  
  private void init()
  {
    AppMethodBeat.i(28167);
    setOrientation(1);
    this.nfH = new FrameLayout(getContext());
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    this.nfH.setVisibility(8);
    addView(this.nfH, (ViewGroup.LayoutParams)localObject);
    this.nfI = new View(getContext());
    this.nfI.setBackgroundColor(-872415232);
    this.nfI.setOnClickListener(new FileSelectorFolderView.3(this));
    localObject = new FrameLayout.LayoutParams(-1, -1);
    this.nfH.addView(this.nfI, (ViewGroup.LayoutParams)localObject);
    this.nfJ = new ListView(getContext());
    this.nfJ.setCacheColorHint(0);
    this.nfJ.setBackgroundResource(2131690310);
    this.nfJ.setSelector(2130839676);
    this.nfJ.setOnItemClickListener(this);
    int i = getResources().getDimensionPixelSize(2131427808);
    this.nfJ.setPadding(i, i / 3, i, 0);
    localObject = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(2131427559);
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    this.nfH.addView(this.nfJ, (ViewGroup.LayoutParams)localObject);
    this.wew = new FileSelectorFolderView.b(getContext());
    this.nfJ.setAdapter(this.wew);
    AppMethodBeat.o(28167);
  }
  
  final void hV(boolean paramBoolean)
  {
    AppMethodBeat.i(28166);
    if (this.Zb == paramBoolean)
    {
      ab.d("MicroMsg.FileSelectorFolderView", "want to expand, but same status, expanded %B", new Object[] { Boolean.valueOf(this.Zb) });
      AppMethodBeat.o(28166);
      return;
    }
    if (this.nfL)
    {
      ab.d("MicroMsg.FileSelectorFolderView", "want to expand[%B], but now in animation", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(28166);
      return;
    }
    if (this.Zb)
    {
      this.nfL = true;
      localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034228);
      localAnimation.setAnimationListener(new FileSelectorFolderView.1(this));
      this.nfJ.startAnimation(localAnimation);
      localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034182);
      this.nfI.startAnimation(localAnimation);
      AppMethodBeat.o(28166);
      return;
    }
    this.nfL = true;
    this.nfH.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034181);
    this.nfI.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034230);
    localAnimation.setAnimationListener(new FileSelectorFolderView.2(this));
    this.nfJ.startAnimation(localAnimation);
    AppMethodBeat.o(28166);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(28168);
    if (this.wev != null) {
      this.wev.Mw(paramInt);
    }
    this.nfI.performClick();
    AppMethodBeat.o(28168);
  }
  
  public void setListener(FileSelectorFolderView.a parama)
  {
    this.wev = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView
 * JD-Core Version:    0.7.0.1
 */