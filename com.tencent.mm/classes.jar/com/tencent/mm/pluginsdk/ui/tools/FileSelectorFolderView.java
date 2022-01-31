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
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.sdk.platformtools.y;

public class FileSelectorFolderView
  extends LinearLayout
  implements AdapterView.OnItemClickListener
{
  boolean Yq = false;
  private FrameLayout kJj;
  private View kJk;
  private ListView kJl;
  private boolean kJn = false;
  private FileSelectorFolderView.a slT = null;
  private FileSelectorFolderView.b slU;
  
  public FileSelectorFolderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public FileSelectorFolderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setOrientation(1);
    this.kJj = new FrameLayout(getContext());
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    this.kJj.setVisibility(8);
    addView(this.kJj, (ViewGroup.LayoutParams)localObject);
    this.kJk = new View(getContext());
    this.kJk.setBackgroundColor(-872415232);
    this.kJk.setOnClickListener(new FileSelectorFolderView.3(this));
    localObject = new FrameLayout.LayoutParams(-1, -1);
    this.kJj.addView(this.kJk, (ViewGroup.LayoutParams)localObject);
    this.kJl = new ListView(getContext());
    this.kJl.setCacheColorHint(0);
    this.kJl.setBackgroundResource(R.e.navpage);
    this.kJl.setSelector(R.g.mm_trans);
    this.kJl.setOnItemClickListener(this);
    int i = getResources().getDimensionPixelSize(R.f.NormalPadding);
    this.kJl.setPadding(i, i / 3, i, 0);
    localObject = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    this.kJj.addView(this.kJl, (ViewGroup.LayoutParams)localObject);
    this.slU = new FileSelectorFolderView.b(getContext());
    this.kJl.setAdapter(this.slU);
  }
  
  final void gq(boolean paramBoolean)
  {
    if (this.Yq == paramBoolean)
    {
      y.d("MicroMsg.FileSelectorFolderView", "want to expand, but same status, expanded %B", new Object[] { Boolean.valueOf(this.Yq) });
      return;
    }
    if (this.kJn)
    {
      y.d("MicroMsg.FileSelectorFolderView", "want to expand[%B], but now in animation", new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    if (this.Yq)
    {
      this.kJn = true;
      localAnimation = AnimationUtils.loadAnimation(getContext(), R.a.push_down_out);
      localAnimation.setAnimationListener(new FileSelectorFolderView.1(this));
      this.kJl.startAnimation(localAnimation);
      localAnimation = AnimationUtils.loadAnimation(getContext(), R.a.fast_faded_out);
      this.kJk.startAnimation(localAnimation);
      return;
    }
    this.kJn = true;
    this.kJj.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), R.a.fast_faded_in);
    this.kJk.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(getContext(), R.a.push_up_in);
    localAnimation.setAnimationListener(new FileSelectorFolderView.2(this));
    this.kJl.startAnimation(localAnimation);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.slT != null) {
      this.slT.Ey(paramInt);
    }
    this.kJk.performClick();
  }
  
  public void setListener(FileSelectorFolderView.a parama)
  {
    this.slT = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView
 * JD-Core Version:    0.7.0.1
 */