package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.sdk.platformtools.ae;

public class FileSelectorFolderView
  extends LinearLayout
  implements AdapterView.OnItemClickListener
{
  private a FCj;
  private FileSelectorFolderView.b FCk;
  boolean jR;
  private FrameLayout tYF;
  private View tYG;
  private ListView tYH;
  private boolean tYJ;
  
  public FileSelectorFolderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31954);
    this.FCj = null;
    this.jR = false;
    this.tYJ = false;
    init();
    AppMethodBeat.o(31954);
  }
  
  public FileSelectorFolderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31955);
    this.FCj = null;
    this.jR = false;
    this.tYJ = false;
    init();
    AppMethodBeat.o(31955);
  }
  
  private void init()
  {
    AppMethodBeat.i(31957);
    setOrientation(1);
    this.tYF = new FrameLayout(getContext());
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    this.tYF.setVisibility(8);
    addView(this.tYF, (ViewGroup.LayoutParams)localObject);
    this.tYG = new View(getContext());
    this.tYG.setBackgroundColor(-872415232);
    this.tYG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31950);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/tools/FileSelectorFolderView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        FileSelectorFolderView.c(FileSelectorFolderView.this);
        a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorFolderView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(31950);
      }
    });
    localObject = new FrameLayout.LayoutParams(-1, -1);
    this.tYF.addView(this.tYG, (ViewGroup.LayoutParams)localObject);
    this.tYH = new ListView(getContext());
    this.tYH.setCacheColorHint(0);
    this.tYH.setBackgroundColor(getContext().getResources().getColor(2131099653));
    this.tYH.setSelector(2131233299);
    this.tYH.setOnItemClickListener(this);
    int i = getResources().getDimensionPixelSize(2131165516);
    this.tYH.setPadding(i, i / 3, i, 0);
    localObject = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(2131165252);
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    this.tYF.addView(this.tYH, (ViewGroup.LayoutParams)localObject);
    this.FCk = new FileSelectorFolderView.b(getContext());
    this.tYH.setAdapter(this.FCk);
    AppMethodBeat.o(31957);
  }
  
  final void mW(boolean paramBoolean)
  {
    AppMethodBeat.i(31956);
    if (this.jR == paramBoolean)
    {
      ae.d("MicroMsg.FileSelectorFolderView", "want to expand, but same status, expanded %B", new Object[] { Boolean.valueOf(this.jR) });
      AppMethodBeat.o(31956);
      return;
    }
    if (this.tYJ)
    {
      ae.d("MicroMsg.FileSelectorFolderView", "want to expand[%B], but now in animation", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(31956);
      return;
    }
    if (this.jR)
    {
      this.tYJ = true;
      localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772106);
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
      this.tYH.startAnimation(localAnimation);
      localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772048);
      this.tYG.startAnimation(localAnimation);
      AppMethodBeat.o(31956);
      return;
    }
    this.tYJ = true;
    this.tYF.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772047);
    this.tYG.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772108);
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
    this.tYH.startAnimation(localAnimation);
    AppMethodBeat.o(31956);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(31958);
    b localb = new b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mu(paramInt);
    localb.rl(paramLong);
    a.b("com/tencent/mm/pluginsdk/ui/tools/FileSelectorFolderView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    if (this.FCj != null) {
      this.FCj.aab(paramInt);
    }
    this.tYG.performClick();
    a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorFolderView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(31958);
  }
  
  public void setListener(a parama)
  {
    this.FCj = parama;
  }
  
  public static abstract interface a
  {
    public abstract void aab(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView
 * JD-Core Version:    0.7.0.1
 */