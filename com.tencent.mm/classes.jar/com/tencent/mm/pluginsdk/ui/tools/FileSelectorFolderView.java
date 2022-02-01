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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ao;

public class FileSelectorFolderView
  extends LinearLayout
  implements AdapterView.OnItemClickListener
{
  private a Cmn;
  private FileSelectorFolderView.b Cmo;
  boolean gX;
  private FrameLayout rJv;
  private View rJw;
  private ListView rJx;
  private boolean rJz;
  
  public FileSelectorFolderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31954);
    this.Cmn = null;
    this.gX = false;
    this.rJz = false;
    init();
    AppMethodBeat.o(31954);
  }
  
  public FileSelectorFolderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31955);
    this.Cmn = null;
    this.gX = false;
    this.rJz = false;
    init();
    AppMethodBeat.o(31955);
  }
  
  private void init()
  {
    AppMethodBeat.i(31957);
    setOrientation(1);
    this.rJv = new FrameLayout(getContext());
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    this.rJv.setVisibility(8);
    addView(this.rJv, (ViewGroup.LayoutParams)localObject);
    this.rJw = new View(getContext());
    this.rJw.setBackgroundColor(-872415232);
    this.rJw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31950);
        FileSelectorFolderView.c(FileSelectorFolderView.this);
        AppMethodBeat.o(31950);
      }
    });
    localObject = new FrameLayout.LayoutParams(-1, -1);
    this.rJv.addView(this.rJw, (ViewGroup.LayoutParams)localObject);
    this.rJx = new ListView(getContext());
    this.rJx.setCacheColorHint(0);
    this.rJx.setBackgroundColor(ao.aD(getContext(), 2130968582));
    this.rJx.setSelector(2131233299);
    this.rJx.setOnItemClickListener(this);
    int i = getResources().getDimensionPixelSize(2131165516);
    this.rJx.setPadding(i, i / 3, i, 0);
    localObject = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(2131165252);
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    this.rJv.addView(this.rJx, (ViewGroup.LayoutParams)localObject);
    this.Cmo = new FileSelectorFolderView.b(getContext());
    this.rJx.setAdapter(this.Cmo);
    AppMethodBeat.o(31957);
  }
  
  final void lH(boolean paramBoolean)
  {
    AppMethodBeat.i(31956);
    if (this.gX == paramBoolean)
    {
      ad.d("MicroMsg.FileSelectorFolderView", "want to expand, but same status, expanded %B", new Object[] { Boolean.valueOf(this.gX) });
      AppMethodBeat.o(31956);
      return;
    }
    if (this.rJz)
    {
      ad.d("MicroMsg.FileSelectorFolderView", "want to expand[%B], but now in animation", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(31956);
      return;
    }
    if (this.gX)
    {
      this.rJz = true;
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
      this.rJx.startAnimation(localAnimation);
      localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772048);
      this.rJw.startAnimation(localAnimation);
      AppMethodBeat.o(31956);
      return;
    }
    this.rJz = true;
    this.rJv.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772047);
    this.rJw.startAnimation(localAnimation);
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
    this.rJx.startAnimation(localAnimation);
    AppMethodBeat.o(31956);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(31958);
    if (this.Cmn != null) {
      this.Cmn.Vq(paramInt);
    }
    this.rJw.performClick();
    AppMethodBeat.o(31958);
  }
  
  public void setListener(a parama)
  {
    this.Cmn = parama;
  }
  
  public static abstract interface a
  {
    public abstract void Vq(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView
 * JD-Core Version:    0.7.0.1
 */