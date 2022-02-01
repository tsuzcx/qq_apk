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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.ao;

public class FileSelectorFolderView
  extends LinearLayout
  implements AdapterView.OnItemClickListener
{
  private a DEE;
  private FileSelectorFolderView.b DEF;
  boolean hW;
  private FrameLayout sRk;
  private View sRl;
  private ListView sRm;
  private boolean sRo;
  
  public FileSelectorFolderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31954);
    this.DEE = null;
    this.hW = false;
    this.sRo = false;
    init();
    AppMethodBeat.o(31954);
  }
  
  public FileSelectorFolderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31955);
    this.DEE = null;
    this.hW = false;
    this.sRo = false;
    init();
    AppMethodBeat.o(31955);
  }
  
  private void init()
  {
    AppMethodBeat.i(31957);
    setOrientation(1);
    this.sRk = new FrameLayout(getContext());
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    this.sRk.setVisibility(8);
    addView(this.sRk, (ViewGroup.LayoutParams)localObject);
    this.sRl = new View(getContext());
    this.sRl.setBackgroundColor(-872415232);
    this.sRl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31950);
        FileSelectorFolderView.c(FileSelectorFolderView.this);
        AppMethodBeat.o(31950);
      }
    });
    localObject = new FrameLayout.LayoutParams(-1, -1);
    this.sRk.addView(this.sRl, (ViewGroup.LayoutParams)localObject);
    this.sRm = new ListView(getContext());
    this.sRm.setCacheColorHint(0);
    this.sRm.setBackgroundColor(ao.aJ(getContext(), 2130968582));
    this.sRm.setSelector(2131233299);
    this.sRm.setOnItemClickListener(this);
    int i = getResources().getDimensionPixelSize(2131165516);
    this.sRm.setPadding(i, i / 3, i, 0);
    localObject = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(2131165252);
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    this.sRk.addView(this.sRm, (ViewGroup.LayoutParams)localObject);
    this.DEF = new FileSelectorFolderView.b(getContext());
    this.sRm.setAdapter(this.DEF);
    AppMethodBeat.o(31957);
  }
  
  final void mA(boolean paramBoolean)
  {
    AppMethodBeat.i(31956);
    if (this.hW == paramBoolean)
    {
      ac.d("MicroMsg.FileSelectorFolderView", "want to expand, but same status, expanded %B", new Object[] { Boolean.valueOf(this.hW) });
      AppMethodBeat.o(31956);
      return;
    }
    if (this.sRo)
    {
      ac.d("MicroMsg.FileSelectorFolderView", "want to expand[%B], but now in animation", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(31956);
      return;
    }
    if (this.hW)
    {
      this.sRo = true;
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
      this.sRm.startAnimation(localAnimation);
      localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772048);
      this.sRl.startAnimation(localAnimation);
      AppMethodBeat.o(31956);
      return;
    }
    this.sRo = true;
    this.sRk.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772047);
    this.sRl.startAnimation(localAnimation);
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
    this.sRm.startAnimation(localAnimation);
    AppMethodBeat.o(31956);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(31958);
    if (this.DEE != null) {
      this.DEE.Xz(paramInt);
    }
    this.sRl.performClick();
    AppMethodBeat.o(31958);
  }
  
  public void setListener(a parama)
  {
    this.DEE = parama;
  }
  
  public static abstract interface a
  {
    public abstract void Xz(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView
 * JD-Core Version:    0.7.0.1
 */