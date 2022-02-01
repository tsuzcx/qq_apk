package com.tencent.mm.plugin.music.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.plugin.music.a.g;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSeeking", "", "()Z", "setSeeking", "(Z)V", "maxDuration", "maxDurationStr", "", "onSeekBarChange", "Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$OnSeekBarChange;", "initView", "", "setMaxProgress", "totalDuration", "setOnSeekBarChange", "setProgress", "currentPos", "updateTimeInfoText", "Companion", "OnSeekBarChange", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMainSeekBar
  extends FrameLayout
{
  public static final MusicMainSeekBar.a LQq;
  private b LQr;
  private String LQs;
  private int maxDuration;
  private boolean msx;
  
  static
  {
    AppMethodBeat.i(271009);
    LQq = new MusicMainSeekBar.a((byte)0);
    AppMethodBeat.o(271009);
  }
  
  public MusicMainSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(270973);
    AppMethodBeat.o(270973);
  }
  
  public MusicMainSeekBar(final Context paramContext, final AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(270970);
    this.LQs = "04:00";
    View.inflate(getContext(), a.g.music_main_seek_bar, (ViewGroup)this);
    paramContext = getResources().getDrawable(a.d.music_main_seek_bar_thumb);
    paramAttributeSet = new ah.f();
    paramAttributeSet.aqH = getResources().getDrawable(a.d.music_main_seek_bar_thumb2);
    ((LinearLayout)findViewById(a.e.parentLayout)).setOnTouchListener(new MusicMainSeekBar..ExternalSyntheticLambda0(this));
    ((SeekBar)findViewById(a.e.seekBar)).setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new c(this, paramAttributeSet, paramContext));
    ((SeekBar)findViewById(a.e.seekBar)).setOnTouchListener(MusicMainSeekBar..ExternalSyntheticLambda1.INSTANCE);
    AppMethodBeat.o(270970);
  }
  
  private static final boolean a(MusicMainSeekBar paramMusicMainSeekBar, View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(270988);
    s.u(paramMusicMainSeekBar, "this$0");
    paramView = new Rect();
    ((SeekBar)paramMusicMainSeekBar.findViewById(a.e.seekBar)).getHitRect(paramView);
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
      boolean bool = ((SeekBar)paramMusicMainSeekBar.findViewById(a.e.seekBar)).onTouchEvent(paramView);
      AppMethodBeat.o(270988);
      return bool;
      if (f2 > paramView.width())
      {
        f1 = paramView.width();
        continue;
        AppMethodBeat.o(270988);
        return false;
      }
      else
      {
        f1 = f2;
      }
    }
  }
  
  private final void adM(int paramInt)
  {
    AppMethodBeat.i(270980);
    TextView localTextView = (TextView)findViewById(a.e.timeStart);
    if (localTextView != null) {
      localTextView.setText((CharSequence)MusicMainSeekBar.a.Ey(paramInt));
    }
    localTextView = (TextView)findViewById(a.e.timeEnd);
    if (localTextView != null) {
      localTextView.setText((CharSequence)String.valueOf(this.LQs));
    }
    AppMethodBeat.o(270980);
  }
  
  private static final boolean j(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(270995);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      paramView.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(270995);
      return true;
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
    }
  }
  
  public final void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(271044);
    this.maxDuration = paramInt;
    this.LQs = MusicMainSeekBar.a.Ey(paramInt);
    ((SeekBar)findViewById(a.e.seekBar)).setMax(paramInt);
    new StringBuilder("maxDuration:").append(this.LQs).append(", ").append(paramInt);
    h.jXD();
    AppMethodBeat.o(271044);
  }
  
  public final void setOnSeekBarChange(b paramb)
  {
    AppMethodBeat.i(271033);
    s.u(paramb, "onSeekBarChange");
    this.LQr = paramb;
    AppMethodBeat.o(271033);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(271036);
    if (this.msx)
    {
      AppMethodBeat.o(271036);
      return;
    }
    adM(paramInt);
    ((SeekBar)findViewById(a.e.seekBar)).setProgress(paramInt);
    AppMethodBeat.o(271036);
  }
  
  public final void setSeeking(boolean paramBoolean)
  {
    this.msx = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$OnSeekBarChange;", "", "onSeekBarChange", "", "seekPosition", "", "max", "onSeekEnd", "onSeekStart", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void goV();
    
    public abstract void kd(int paramInt1, int paramInt2);
    
    public abstract void ke(int paramInt1, int paramInt2);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$initView$2", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements SeekBar.OnSeekBarChangeListener
  {
    c(MusicMainSeekBar paramMusicMainSeekBar, ah.f<Drawable> paramf, Drawable paramDrawable) {}
    
    public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(271042);
      if (paramBoolean)
      {
        MusicMainSeekBar.a(this.LQt, paramInt);
        if (paramSeekBar != null)
        {
          MusicMainSeekBar.b localb = MusicMainSeekBar.a(this.LQt);
          if (localb != null) {
            localb.ke(paramSeekBar.getProgress(), paramSeekBar.getMax());
          }
        }
      }
      AppMethodBeat.o(271042);
    }
    
    public final void onStartTrackingTouch(SeekBar paramSeekBar)
    {
      AppMethodBeat.i(271050);
      this.LQt.setSeeking(true);
      Object localObject = this.LQt;
      if (paramSeekBar == null) {}
      for (int i = 0;; i = paramSeekBar.getProgress())
      {
        MusicMainSeekBar.a((MusicMainSeekBar)localObject, i);
        localObject = MusicMainSeekBar.a(this.LQt);
        if (localObject != null) {
          ((MusicMainSeekBar.b)localObject).goV();
        }
        if (paramSeekBar != null) {
          paramSeekBar.setThumb((Drawable)paramAttributeSet.aqH);
        }
        AppMethodBeat.o(271050);
        return;
      }
    }
    
    public final void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      AppMethodBeat.i(271056);
      this.LQt.setSeeking(false);
      if (paramSeekBar != null)
      {
        Object localObject = this.LQt;
        Drawable localDrawable = paramContext;
        localObject = MusicMainSeekBar.a((MusicMainSeekBar)localObject);
        if (localObject != null) {
          ((MusicMainSeekBar.b)localObject).kd(paramSeekBar.getProgress(), paramSeekBar.getMax());
        }
        paramSeekBar.setThumb(localDrawable);
      }
      AppMethodBeat.o(271056);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.MusicMainSeekBar
 * JD-Core Version:    0.7.0.1
 */