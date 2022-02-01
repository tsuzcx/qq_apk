package com.tencent.mm.plugin.music.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSeeking", "", "()Z", "setSeeking", "(Z)V", "maxDuration", "maxDurationStr", "", "onSeekBarChange", "Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$OnSeekBarChange;", "initView", "", "setMaxProgress", "totalDuration", "setOnSeekBarChange", "setProgress", "currentPos", "updateTimeInfoText", "Companion", "OnSeekBarChange", "plugin-music_release"})
public final class MusicMainSeekBar
  extends FrameLayout
{
  public static final a Aon;
  private b Aol;
  private String Aom;
  private HashMap _$_findViewCache;
  private int maxDuration;
  private boolean oyR;
  
  static
  {
    AppMethodBeat.i(220050);
    Aon = new a((byte)0);
    AppMethodBeat.o(220050);
  }
  
  public MusicMainSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(220049);
    AppMethodBeat.o(220049);
  }
  
  public MusicMainSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220048);
    this.Aom = "04:00";
    View.inflate(getContext(), 2131495777, (ViewGroup)this);
    getResources().getDrawable(2131234195);
    ((SeekBar)_$_findCachedViewById(2131307481)).setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new c(this));
    ((SeekBar)_$_findCachedViewById(2131307481)).setOnTouchListener((View.OnTouchListener)d.Aop);
    AppMethodBeat.o(220048);
  }
  
  private final void Tf(int paramInt)
  {
    AppMethodBeat.i(220046);
    TextView localTextView = (TextView)_$_findCachedViewById(2131309087);
    if (localTextView != null) {
      localTextView.setText((CharSequence)a.Ar(paramInt));
    }
    localTextView = (TextView)_$_findCachedViewById(2131309088);
    if (localTextView != null)
    {
      localTextView.setText((CharSequence)(" / " + this.Aom));
      AppMethodBeat.o(220046);
      return;
    }
    AppMethodBeat.o(220046);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(220052);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(220052);
    return localView1;
  }
  
  public final void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(220047);
    this.maxDuration = paramInt;
    this.Aom = a.Ar(paramInt);
    SeekBar localSeekBar = (SeekBar)_$_findCachedViewById(2131307481);
    p.g(localSeekBar, "seekBar");
    localSeekBar.setMax(paramInt);
    new StringBuilder("maxDuration:").append(this.Aom).append(", ").append(paramInt);
    h.hkS();
    AppMethodBeat.o(220047);
  }
  
  public final void setOnSeekBarChange(b paramb)
  {
    AppMethodBeat.i(220044);
    p.h(paramb, "onSeekBarChange");
    this.Aol = paramb;
    AppMethodBeat.o(220044);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(220045);
    if (this.oyR)
    {
      AppMethodBeat.o(220045);
      return;
    }
    Tf(paramInt);
    SeekBar localSeekBar = (SeekBar)_$_findCachedViewById(2131307481);
    p.g(localSeekBar, "seekBar");
    localSeekBar.setProgress(paramInt);
    AppMethodBeat.o(220045);
  }
  
  public final void setSeeking(boolean paramBoolean)
  {
    this.oyR = paramBoolean;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$Companion;", "", "()V", "TAG", "", "timeParse", "duration", "", "plugin-music_release"})
  public static final class a
  {
    public static String Ar(int paramInt)
    {
      AppMethodBeat.i(220038);
      Object localObject = new StringBuilder();
      long l1 = paramInt / 60000L;
      long l2 = Math.floor(paramInt % 60000L / 1000.0D);
      if (l1 < 10L) {
        ((StringBuilder)localObject).append("0");
      }
      ((StringBuilder)localObject).append(l1 + ':');
      if (l2 < 10L) {
        ((StringBuilder)localObject).append("0");
      }
      ((StringBuilder)localObject).append(l2);
      localObject = ((StringBuilder)localObject).toString();
      p.g(localObject, "time.toString()");
      AppMethodBeat.o(220038);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$OnSeekBarChange;", "", "onSeekBarChange", "", "seekPosition", "", "max", "onSeekEnd", "onSeekStart", "plugin-music_release"})
  public static abstract interface b
  {
    public abstract void evo();
    
    public abstract void hv(int paramInt1, int paramInt2);
    
    public abstract void hw(int paramInt1, int paramInt2);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$initView$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "plugin-music_release"})
  public static final class c
    implements SeekBar.OnSeekBarChangeListener
  {
    public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(220039);
      if (paramBoolean)
      {
        MusicMainSeekBar.a(this.Aoo, paramInt);
        if (paramSeekBar != null)
        {
          MusicMainSeekBar.b localb = MusicMainSeekBar.a(this.Aoo);
          if (localb != null)
          {
            localb.hw(paramSeekBar.getProgress(), paramSeekBar.getMax());
            AppMethodBeat.o(220039);
            return;
          }
          AppMethodBeat.o(220039);
          return;
        }
      }
      AppMethodBeat.o(220039);
    }
    
    public final void onStartTrackingTouch(SeekBar paramSeekBar)
    {
      AppMethodBeat.i(220040);
      this.Aoo.setSeeking(true);
      paramSeekBar = (LinearLayout)this.Aoo._$_findCachedViewById(2131309089);
      if (paramSeekBar != null) {
        paramSeekBar.setVisibility(0);
      }
      paramSeekBar = MusicMainSeekBar.a(this.Aoo);
      if (paramSeekBar != null)
      {
        paramSeekBar.evo();
        AppMethodBeat.o(220040);
        return;
      }
      AppMethodBeat.o(220040);
    }
    
    public final void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      AppMethodBeat.i(220041);
      this.Aoo.setSeeking(false);
      Object localObject = (LinearLayout)this.Aoo._$_findCachedViewById(2131309089);
      if (localObject != null) {
        ((LinearLayout)localObject).setVisibility(4);
      }
      if (paramSeekBar != null)
      {
        localObject = MusicMainSeekBar.a(this.Aoo);
        if (localObject != null)
        {
          ((MusicMainSeekBar.b)localObject).hv(paramSeekBar.getProgress(), paramSeekBar.getMax());
          AppMethodBeat.o(220041);
          return;
        }
        AppMethodBeat.o(220041);
        return;
      }
      AppMethodBeat.o(220041);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class d
    implements View.OnTouchListener
  {
    public static final d Aop;
    
    static
    {
      AppMethodBeat.i(220043);
      Aop = new d();
      AppMethodBeat.o(220043);
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(220042);
      p.g(paramMotionEvent, "event");
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        paramView.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(220042);
        return true;
        p.g(paramView, "v");
        paramView.getParent().requestDisallowInterceptTouchEvent(true);
        continue;
        p.g(paramView, "v");
        paramView.getParent().requestDisallowInterceptTouchEvent(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.MusicMainSeekBar
 * JD-Core Version:    0.7.0.1
 */