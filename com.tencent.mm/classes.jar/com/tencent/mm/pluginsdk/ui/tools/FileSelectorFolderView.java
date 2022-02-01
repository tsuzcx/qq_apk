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
  private FrameLayout HOp;
  private View HOq;
  private ListView HOr;
  private boolean HOt;
  private a YrD;
  private FileSelectorFolderView.b YrE;
  boolean qv;
  
  public FileSelectorFolderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31954);
    this.YrD = null;
    this.qv = false;
    this.HOt = false;
    init();
    AppMethodBeat.o(31954);
  }
  
  public FileSelectorFolderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31955);
    this.YrD = null;
    this.qv = false;
    this.HOt = false;
    init();
    AppMethodBeat.o(31955);
  }
  
  private void init()
  {
    AppMethodBeat.i(31957);
    setOrientation(1);
    this.HOp = new FrameLayout(getContext());
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    this.HOp.setVisibility(8);
    addView(this.HOp, (ViewGroup.LayoutParams)localObject);
    this.HOq = new View(getContext());
    this.HOq.setBackgroundColor(-872415232);
    this.HOq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31950);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/pluginsdk/ui/tools/FileSelectorFolderView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        FileSelectorFolderView.c(FileSelectorFolderView.this);
        a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorFolderView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(31950);
      }
    });
    localObject = new FrameLayout.LayoutParams(-1, -1);
    this.HOp.addView(this.HOq, (ViewGroup.LayoutParams)localObject);
    this.HOr = new ListView(getContext());
    this.HOr.setCacheColorHint(0);
    this.HOr.setBackgroundColor(getContext().getResources().getColor(R.e.BG_5));
    this.HOr.setSelector(R.g.mm_trans);
    this.HOr.setOnItemClickListener(this);
    int i = getResources().getDimensionPixelSize(R.f.NormalPadding);
    this.HOr.setPadding(i, i / 3, i, 0);
    localObject = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    this.HOp.addView(this.HOr, (ViewGroup.LayoutParams)localObject);
    this.YrE = new FileSelectorFolderView.b(getContext());
    this.HOr.setAdapter(this.YrE);
    AppMethodBeat.o(31957);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(31958);
    b localb = new b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    a.c("com/tencent/mm/pluginsdk/ui/tools/FileSelectorFolderView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    if (this.YrD != null) {
      this.YrD.axd(paramInt);
    }
    this.HOq.performClick();
    a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorFolderView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(31958);
  }
  
  public void setListener(a parama)
  {
    this.YrD = parama;
  }
  
  final void vX(boolean paramBoolean)
  {
    AppMethodBeat.i(31956);
    if (this.qv == paramBoolean)
    {
      Log.d("MicroMsg.FileSelectorFolderView", "want to expand, but same status, expanded %B", new Object[] { Boolean.valueOf(this.qv) });
      AppMethodBeat.o(31956);
      return;
    }
    if (this.HOt)
    {
      Log.d("MicroMsg.FileSelectorFolderView", "want to expand[%B], but now in animation", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(31956);
      return;
    }
    if (this.qv)
    {
      this.HOt = true;
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
      this.HOr.startAnimation(localAnimation);
      localAnimation = AnimationUtils.loadAnimation(getContext(), R.a.fast_faded_out);
      this.HOq.startAnimation(localAnimation);
      AppMethodBeat.o(31956);
      return;
    }
    this.HOt = true;
    this.HOp.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), R.a.fast_faded_in);
    this.HOq.startAnimation(localAnimation);
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
    this.HOr.startAnimation(localAnimation);
    AppMethodBeat.o(31956);
  }
  
  public static abstract interface a
  {
    public abstract void axd(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView
 * JD-Core Version:    0.7.0.1
 */