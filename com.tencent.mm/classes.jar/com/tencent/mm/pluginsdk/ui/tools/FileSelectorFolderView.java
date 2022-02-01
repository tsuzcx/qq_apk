package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public class FileSelectorFolderView
  extends LinearLayout
  implements AdapterView.OnItemClickListener
{
  private FrameLayout Ccn;
  private View Cco;
  private ListView Ccp;
  private boolean Ccr;
  private a Rvh;
  private FileSelectorFolderView.b Rvi;
  boolean py;
  
  public FileSelectorFolderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31954);
    this.Rvh = null;
    this.py = false;
    this.Ccr = false;
    init();
    AppMethodBeat.o(31954);
  }
  
  public FileSelectorFolderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31955);
    this.Rvh = null;
    this.py = false;
    this.Ccr = false;
    init();
    AppMethodBeat.o(31955);
  }
  
  private void init()
  {
    AppMethodBeat.i(31957);
    setOrientation(1);
    this.Ccn = new FrameLayout(getContext());
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    this.Ccn.setVisibility(8);
    addView(this.Ccn, (ViewGroup.LayoutParams)localObject);
    this.Cco = new View(getContext());
    this.Cco.setBackgroundColor(-872415232);
    this.Cco.setOnClickListener(new FileSelectorFolderView.3(this));
    localObject = new FrameLayout.LayoutParams(-1, -1);
    this.Ccn.addView(this.Cco, (ViewGroup.LayoutParams)localObject);
    this.Ccp = new ListView(getContext());
    this.Ccp.setCacheColorHint(0);
    this.Ccp.setBackgroundColor(getContext().getResources().getColor(R.e.BG_5));
    this.Ccp.setSelector(R.g.mm_trans);
    this.Ccp.setOnItemClickListener(this);
    int i = getResources().getDimensionPixelSize(R.f.NormalPadding);
    this.Ccp.setPadding(i, i / 3, i, 0);
    localObject = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    this.Ccn.addView(this.Ccp, (ViewGroup.LayoutParams)localObject);
    this.Rvi = new FileSelectorFolderView.b(getContext());
    this.Ccp.setAdapter(this.Rvi);
    AppMethodBeat.o(31957);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(31958);
    b localb = new b();
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    a.c("com/tencent/mm/pluginsdk/ui/tools/FileSelectorFolderView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    if (this.Rvh != null) {
      this.Rvh.aqX(paramInt);
    }
    this.Cco.performClick();
    a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorFolderView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(31958);
  }
  
  final void rY(boolean paramBoolean)
  {
    AppMethodBeat.i(31956);
    if (this.py == paramBoolean)
    {
      Log.d("MicroMsg.FileSelectorFolderView", "want to expand, but same status, expanded %B", new Object[] { Boolean.valueOf(this.py) });
      AppMethodBeat.o(31956);
      return;
    }
    if (this.Ccr)
    {
      Log.d("MicroMsg.FileSelectorFolderView", "want to expand[%B], but now in animation", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(31956);
      return;
    }
    if (this.py)
    {
      this.Ccr = true;
      localAnimation = AnimationUtils.loadAnimation(getContext(), R.a.push_down_out);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(31948);
          FileSelectorFolderView.a(FileSelectorFolderView.this).setVisibility(8);
          FileSelectorFolderView.a(FileSelectorFolderView.this, false);
          FileSelectorFolderView.b(FileSelectorFolderView.this);
          AppMethodBeat.o(31948);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.Ccp.startAnimation(localAnimation);
      localAnimation = AnimationUtils.loadAnimation(getContext(), R.a.fast_faded_out);
      this.Cco.startAnimation(localAnimation);
      AppMethodBeat.o(31956);
      return;
    }
    this.Ccr = true;
    this.Ccn.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), R.a.fast_faded_in);
    this.Cco.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(getContext(), R.a.push_up_in);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(31949);
        FileSelectorFolderView.a(FileSelectorFolderView.this, true);
        FileSelectorFolderView.b(FileSelectorFolderView.this);
        AppMethodBeat.o(31949);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.Ccp.startAnimation(localAnimation);
    AppMethodBeat.o(31956);
  }
  
  public void setListener(a parama)
  {
    this.Rvh = parama;
  }
  
  public static abstract interface a
  {
    public abstract void aqX(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView
 * JD-Core Version:    0.7.0.1
 */