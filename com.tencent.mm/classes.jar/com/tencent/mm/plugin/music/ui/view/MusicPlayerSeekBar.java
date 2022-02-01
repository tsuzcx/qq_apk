package com.tencent.mm.plugin.music.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/ui/view/MusicPlayerSeekBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSeeking", "", "()Z", "setSeeking", "(Z)V", "onSeekBarChange", "Lcom/tencent/mm/plugin/music/ui/view/MusicPlayerSeekBar$OnSeekBarChange;", "thumbDrawable", "Landroid/graphics/drawable/Drawable;", "getThumbDrawable", "()Landroid/graphics/drawable/Drawable;", "setThumbDrawable", "(Landroid/graphics/drawable/Drawable;)V", "enableLoading", "", "enable", "initView", "setColor", "color", "setGravityNoSpan", "setMaxProgress", "totalDuration", "setOnSeekBarChange", "setProgress", "currentPos", "setTextSize", "textSize", "Companion", "OnSeekBarChange", "plugin-music_release"})
public final class MusicPlayerSeekBar
  extends FrameLayout
{
  public static final a AoV;
  private b AoU;
  private HashMap _$_findViewCache;
  private boolean oyR;
  private Drawable oyT;
  
  static
  {
    AppMethodBeat.i(220068);
    AoV = new a((byte)0);
    AppMethodBeat.o(220068);
  }
  
  public MusicPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(220067);
    AppMethodBeat.o(220067);
  }
  
  public MusicPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220066);
    View.inflate(getContext(), 2131495799, (ViewGroup)this);
    paramContext = (TextView)_$_findCachedViewById(2131299369);
    if (paramContext == null) {
      p.hyc();
    }
    paramContext.setText((CharSequence)"00:00");
    paramContext = (TextView)_$_findCachedViewById(2131300121);
    if (paramContext == null) {
      p.hyc();
    }
    paramContext.setText((CharSequence)"--:--");
    this.oyT = getResources().getDrawable(2131234195);
    Util.expandViewTouchArea((SeekBar)_$_findCachedViewById(2131304917), 100, 100, 100, 100);
    ((SeekBar)_$_findCachedViewById(2131304917)).setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new c(this));
    AppMethodBeat.o(220066);
  }
  
  private View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(220069);
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
    AppMethodBeat.o(220069);
    return localView1;
  }
  
  public final Drawable getThumbDrawable()
  {
    return this.oyT;
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(220063);
    Object localObject = (TextView)_$_findCachedViewById(2131299369);
    if (localObject == null) {
      p.hyc();
    }
    ((TextView)localObject).setTextColor(paramInt);
    localObject = (TextView)_$_findCachedViewById(2131300121);
    if (localObject == null) {
      p.hyc();
    }
    ((TextView)localObject).setTextColor(paramInt);
    localObject = (SeekBar)_$_findCachedViewById(2131304917);
    if (localObject == null) {
      p.hyc();
    }
    ((SeekBar)localObject).getProgressDrawable().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    localObject = (SeekBar)_$_findCachedViewById(2131304917);
    if (localObject == null) {
      p.hyc();
    }
    ((SeekBar)localObject).getThumb().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    localObject = this.oyT;
    if (localObject == null) {
      p.hyc();
    }
    ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    _$_findCachedViewById(2131301548).setBackgroundColor(paramInt);
    AppMethodBeat.o(220063);
  }
  
  public final void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(220065);
    Object localObject = (TextView)_$_findCachedViewById(2131300121);
    if (localObject == null) {
      p.hyc();
    }
    ((TextView)localObject).setText((CharSequence)a.Ar(paramInt));
    localObject = (SeekBar)_$_findCachedViewById(2131304917);
    if (localObject == null) {
      p.hyc();
    }
    ((SeekBar)localObject).setMax(paramInt);
    AppMethodBeat.o(220065);
  }
  
  public final void setOnSeekBarChange(b paramb)
  {
    AppMethodBeat.i(220061);
    p.h(paramb, "onSeekBarChange");
    this.AoU = paramb;
    AppMethodBeat.o(220061);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(220064);
    if (this.oyR)
    {
      AppMethodBeat.o(220064);
      return;
    }
    Object localObject = (TextView)_$_findCachedViewById(2131299369);
    if (localObject == null) {
      p.hyc();
    }
    ((TextView)localObject).setText((CharSequence)a.Ar(paramInt));
    localObject = (SeekBar)_$_findCachedViewById(2131304917);
    if (localObject == null) {
      p.hyc();
    }
    ((SeekBar)localObject).setProgress(paramInt);
    if (paramInt > 0)
    {
      localObject = _$_findCachedViewById(2131301548);
      p.g(localObject, "firstPart");
      ((View)localObject).setAlpha(1.0F);
    }
    AppMethodBeat.o(220064);
  }
  
  public final void setSeeking(boolean paramBoolean)
  {
    this.oyR = paramBoolean;
  }
  
  public final void setTextSize(int paramInt)
  {
    AppMethodBeat.i(220062);
    TextView localTextView = (TextView)_$_findCachedViewById(2131299369);
    if (localTextView == null) {
      p.hyc();
    }
    localTextView.setTextSize(0, paramInt);
    localTextView = (TextView)_$_findCachedViewById(2131300121);
    if (localTextView == null) {
      p.hyc();
    }
    localTextView.setTextSize(0, paramInt);
    AppMethodBeat.o(220062);
  }
  
  public final void setThumbDrawable(Drawable paramDrawable)
  {
    this.oyT = paramDrawable;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/ui/view/MusicPlayerSeekBar$Companion;", "", "()V", "TAG", "", "timeParse", "duration", "", "plugin-music_release"})
  public static final class a
  {
    public static String Ar(int paramInt)
    {
      AppMethodBeat.i(220058);
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
      AppMethodBeat.o(220058);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/ui/view/MusicPlayerSeekBar$OnSeekBarChange;", "", "onSeekBarChange", "", "seekPosition", "", "plugin-music_release"})
  public static abstract interface b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/music/ui/view/MusicPlayerSeekBar$initView$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "mpSeekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "plugin-music_release"})
  public static final class c
    implements SeekBar.OnSeekBarChangeListener
  {
    public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
    
    public final void onStartTrackingTouch(SeekBar paramSeekBar)
    {
      AppMethodBeat.i(220059);
      this.AoW.setSeeking(true);
      AppMethodBeat.o(220059);
    }
    
    public final void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      AppMethodBeat.i(220060);
      this.AoW.setSeeking(false);
      if (MusicPlayerSeekBar.a(this.AoW) != null)
      {
        if (MusicPlayerSeekBar.a(this.AoW) == null) {
          p.hyc();
        }
        if (paramSeekBar == null) {
          p.hyc();
        }
        paramSeekBar.getProgress();
      }
      AppMethodBeat.o(220060);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.MusicPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */