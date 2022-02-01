package com.tencent.mm.plugin.music.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.plugin.music.a.g;
import java.util.HashMap;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSeeking", "", "()Z", "setSeeking", "(Z)V", "maxDuration", "maxDurationStr", "", "onSeekBarChange", "Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$OnSeekBarChange;", "initView", "", "setMaxProgress", "totalDuration", "setOnSeekBarChange", "setProgress", "currentPos", "updateTimeInfoText", "Companion", "OnSeekBarChange", "plugin-music_release"})
public final class MusicMainSeekBar
  extends FrameLayout
{
  public static final a FVt;
  private b FVr;
  private String FVs;
  private HashMap _$_findViewCache;
  private int maxDuration;
  private boolean rjZ;
  
  static
  {
    AppMethodBeat.i(260630);
    FVt = new a((byte)0);
    AppMethodBeat.o(260630);
  }
  
  public MusicMainSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(260628);
    AppMethodBeat.o(260628);
  }
  
  public MusicMainSeekBar(final Context paramContext, final AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(260627);
    this.FVs = "04:00";
    View.inflate(getContext(), a.g.music_main_seek_bar, (ViewGroup)this);
    paramContext = getResources().getDrawable(a.d.music_main_seek_bar_thumb);
    paramAttributeSet = new aa.f();
    paramAttributeSet.aaBC = getResources().getDrawable(a.d.music_main_seek_bar_thumb2);
    ((LinearLayout)_$_findCachedViewById(a.e.parentLayout)).setOnTouchListener((View.OnTouchListener)new c(this));
    ((SeekBar)_$_findCachedViewById(a.e.seekBar)).setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new d(this, paramAttributeSet, paramContext));
    ((SeekBar)_$_findCachedViewById(a.e.seekBar)).setOnTouchListener((View.OnTouchListener)MusicMainSeekBar.e.FVx);
    AppMethodBeat.o(260627);
  }
  
  private final void Zz(int paramInt)
  {
    AppMethodBeat.i(260623);
    TextView localTextView = (TextView)_$_findCachedViewById(a.e.timeStart);
    if (localTextView != null) {
      localTextView.setText((CharSequence)a.DY(paramInt));
    }
    localTextView = (TextView)_$_findCachedViewById(a.e.timeEnd);
    if (localTextView != null)
    {
      localTextView.setText((CharSequence)String.valueOf(this.FVs));
      AppMethodBeat.o(260623);
      return;
    }
    AppMethodBeat.o(260623);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(260634);
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
    AppMethodBeat.o(260634);
    return localView1;
  }
  
  public final void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(260624);
    this.maxDuration = paramInt;
    this.FVs = a.DY(paramInt);
    SeekBar localSeekBar = (SeekBar)_$_findCachedViewById(a.e.seekBar);
    p.j(localSeekBar, "seekBar");
    localSeekBar.setMax(paramInt);
    new StringBuilder("maxDuration:").append(this.FVs).append(", ").append(paramInt);
    h.ioq();
    AppMethodBeat.o(260624);
  }
  
  public final void setOnSeekBarChange(b paramb)
  {
    AppMethodBeat.i(260618);
    p.k(paramb, "onSeekBarChange");
    this.FVr = paramb;
    AppMethodBeat.o(260618);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(260620);
    if (this.rjZ)
    {
      AppMethodBeat.o(260620);
      return;
    }
    Zz(paramInt);
    SeekBar localSeekBar = (SeekBar)_$_findCachedViewById(a.e.seekBar);
    p.j(localSeekBar, "seekBar");
    localSeekBar.setProgress(paramInt);
    AppMethodBeat.o(260620);
  }
  
  public final void setSeeking(boolean paramBoolean)
  {
    this.rjZ = paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$Companion;", "", "()V", "TAG", "", "timeParse", "duration", "", "plugin-music_release"})
  public static final class a
  {
    public static String DY(int paramInt)
    {
      AppMethodBeat.i(260236);
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
      p.j(localObject, "time.toString()");
      AppMethodBeat.o(260236);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$OnSeekBarChange;", "", "onSeekBarChange", "", "seekPosition", "", "max", "onSeekEnd", "onSeekStart", "plugin-music_release"})
  public static abstract interface b
  {
    public abstract void ffH();
    
    public abstract void iA(int paramInt1, int paramInt2);
    
    public abstract void iz(int paramInt1, int paramInt2);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class c
    implements View.OnTouchListener
  {
    c(MusicMainSeekBar paramMusicMainSeekBar) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      float f1 = 0.0F;
      AppMethodBeat.i(260386);
      paramView = new Rect();
      ((SeekBar)this.FVu._$_findCachedViewById(a.e.seekBar)).getHitRect(paramView);
      p.j(paramMotionEvent, "event");
      float f3;
      float f2;
      if ((paramMotionEvent.getY() >= paramView.top - 500) && (paramMotionEvent.getY() <= paramView.bottom + 500))
      {
        f3 = paramView.top + paramView.height() / 2;
        f2 = paramMotionEvent.getX() - paramView.left;
        if (f2 >= 0.0F) {}
      }
      for (;;)
      {
        paramView = MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), paramMotionEvent.getAction(), f1, f3, paramMotionEvent.getMetaState());
        boolean bool = ((SeekBar)this.FVu._$_findCachedViewById(a.e.seekBar)).onTouchEvent(paramView);
        AppMethodBeat.o(260386);
        return bool;
        if (f2 > paramView.width())
        {
          f1 = paramView.width();
          continue;
          AppMethodBeat.o(260386);
          return false;
        }
        else
        {
          f1 = f2;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$initView$2", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "plugin-music_release"})
  public static final class d
    implements SeekBar.OnSeekBarChangeListener
  {
    d(aa.f paramf, Drawable paramDrawable) {}
    
    public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(259559);
      if (paramBoolean)
      {
        MusicMainSeekBar.a(this.FVu, paramInt);
        if (paramSeekBar != null)
        {
          MusicMainSeekBar.b localb = MusicMainSeekBar.a(this.FVu);
          if (localb != null)
          {
            localb.iA(paramSeekBar.getProgress(), paramSeekBar.getMax());
            AppMethodBeat.o(259559);
            return;
          }
          AppMethodBeat.o(259559);
          return;
        }
      }
      AppMethodBeat.o(259559);
    }
    
    public final void onStartTrackingTouch(SeekBar paramSeekBar)
    {
      AppMethodBeat.i(259562);
      this.FVu.setSeeking(true);
      Object localObject = this.FVu;
      if (paramSeekBar != null) {}
      for (int i = paramSeekBar.getProgress();; i = 0)
      {
        MusicMainSeekBar.a((MusicMainSeekBar)localObject, i);
        localObject = MusicMainSeekBar.a(this.FVu);
        if (localObject != null) {
          ((MusicMainSeekBar.b)localObject).ffH();
        }
        if (paramSeekBar == null) {
          break;
        }
        paramSeekBar.setThumb((Drawable)paramAttributeSet.aaBC);
        AppMethodBeat.o(259562);
        return;
      }
      AppMethodBeat.o(259562);
    }
    
    public final void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      AppMethodBeat.i(259565);
      this.FVu.setSeeking(false);
      if (paramSeekBar != null)
      {
        MusicMainSeekBar.b localb = MusicMainSeekBar.a(this.FVu);
        if (localb != null) {
          localb.iz(paramSeekBar.getProgress(), paramSeekBar.getMax());
        }
        paramSeekBar.setThumb(paramContext);
        AppMethodBeat.o(259565);
        return;
      }
      AppMethodBeat.o(259565);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.MusicMainSeekBar
 * JD-Core Version:    0.7.0.1
 */