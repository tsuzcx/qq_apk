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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public class FileSelectorFolderView
  extends LinearLayout
  implements AdapterView.OnItemClickListener
{
  private a Kub;
  private FileSelectorFolderView.b Kuc;
  boolean jT;
  private FrameLayout xpS;
  private View xpT;
  private ListView xpU;
  private boolean xpW;
  
  public FileSelectorFolderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31954);
    this.Kub = null;
    this.jT = false;
    this.xpW = false;
    init();
    AppMethodBeat.o(31954);
  }
  
  public FileSelectorFolderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31955);
    this.Kub = null;
    this.jT = false;
    this.xpW = false;
    init();
    AppMethodBeat.o(31955);
  }
  
  private void init()
  {
    AppMethodBeat.i(31957);
    setOrientation(1);
    this.xpS = new FrameLayout(getContext());
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    this.xpS.setVisibility(8);
    addView(this.xpS, (ViewGroup.LayoutParams)localObject);
    this.xpT = new View(getContext());
    this.xpT.setBackgroundColor(-872415232);
    this.xpT.setOnClickListener(new FileSelectorFolderView.3(this));
    localObject = new FrameLayout.LayoutParams(-1, -1);
    this.xpS.addView(this.xpT, (ViewGroup.LayoutParams)localObject);
    this.xpU = new ListView(getContext());
    this.xpU.setCacheColorHint(0);
    this.xpU.setBackgroundColor(getContext().getResources().getColor(2131099653));
    this.xpU.setSelector(2131233974);
    this.xpU.setOnItemClickListener(this);
    int i = getResources().getDimensionPixelSize(2131165534);
    this.xpU.setPadding(i, i / 3, i, 0);
    localObject = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(2131165256);
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    this.xpS.addView(this.xpU, (ViewGroup.LayoutParams)localObject);
    this.Kuc = new FileSelectorFolderView.b(getContext());
    this.xpU.setAdapter(this.Kuc);
    AppMethodBeat.o(31957);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(31958);
    b localb = new b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    a.b("com/tencent/mm/pluginsdk/ui/tools/FileSelectorFolderView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    if (this.Kub != null) {
      this.Kub.aiQ(paramInt);
    }
    this.xpT.performClick();
    a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorFolderView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(31958);
  }
  
  final void pD(boolean paramBoolean)
  {
    AppMethodBeat.i(31956);
    if (this.jT == paramBoolean)
    {
      Log.d("MicroMsg.FileSelectorFolderView", "want to expand, but same status, expanded %B", new Object[] { Boolean.valueOf(this.jT) });
      AppMethodBeat.o(31956);
      return;
    }
    if (this.xpW)
    {
      Log.d("MicroMsg.FileSelectorFolderView", "want to expand[%B], but now in animation", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(31956);
      return;
    }
    if (this.jT)
    {
      this.xpW = true;
      localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772130);
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
      this.xpU.startAnimation(localAnimation);
      localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772060);
      this.xpT.startAnimation(localAnimation);
      AppMethodBeat.o(31956);
      return;
    }
    this.xpW = true;
    this.xpS.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772059);
    this.xpT.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772132);
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
    this.xpU.startAnimation(localAnimation);
    AppMethodBeat.o(31956);
  }
  
  public void setListener(a parama)
  {
    this.Kub = parama;
  }
  
  public static abstract interface a
  {
    public abstract void aiQ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView
 * JD-Core Version:    0.7.0.1
 */