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
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.plugin.music.a.g;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/ui/view/MusicPlayerSeekBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSeeking", "", "()Z", "setSeeking", "(Z)V", "onSeekBarChange", "Lcom/tencent/mm/plugin/music/ui/view/MusicPlayerSeekBar$OnSeekBarChange;", "thumbDrawable", "Landroid/graphics/drawable/Drawable;", "getThumbDrawable", "()Landroid/graphics/drawable/Drawable;", "setThumbDrawable", "(Landroid/graphics/drawable/Drawable;)V", "enableLoading", "", "enable", "initView", "setColor", "color", "setGravityNoSpan", "setMaxProgress", "totalDuration", "setOnSeekBarChange", "setProgress", "currentPos", "setTextSize", "textSize", "Companion", "OnSeekBarChange", "plugin-music_release"})
public final class MusicPlayerSeekBar
  extends FrameLayout
{
  public static final a FWd;
  private b FWc;
  private HashMap _$_findViewCache;
  private Drawable rBA;
  private boolean rjZ;
  
  static
  {
    AppMethodBeat.i(259424);
    FWd = new a((byte)0);
    AppMethodBeat.o(259424);
  }
  
  public MusicPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(259422);
    AppMethodBeat.o(259422);
  }
  
  public MusicPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(259421);
    View.inflate(getContext(), a.g.music_player_seek_bar, (ViewGroup)this);
    paramContext = (TextView)_$_findCachedViewById(a.e.currentTime);
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.setText((CharSequence)"00:00");
    paramContext = (TextView)_$_findCachedViewById(a.e.endTime);
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.setText((CharSequence)"--:--");
    this.rBA = getResources().getDrawable(a.d.music_seek_bar_tumb);
    Util.expandViewTouchArea((SeekBar)_$_findCachedViewById(a.e.mpSeekBar), 100, 100, 100, 100);
    ((SeekBar)_$_findCachedViewById(a.e.mpSeekBar)).setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new c(this));
    AppMethodBeat.o(259421);
  }
  
  private View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(259425);
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
    AppMethodBeat.o(259425);
    return localView1;
  }
  
  public final Drawable getThumbDrawable()
  {
    return this.rBA;
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(259417);
    Object localObject = (TextView)_$_findCachedViewById(a.e.currentTime);
    if (localObject == null) {
      p.iCn();
    }
    ((TextView)localObject).setTextColor(paramInt);
    localObject = (TextView)_$_findCachedViewById(a.e.endTime);
    if (localObject == null) {
      p.iCn();
    }
    ((TextView)localObject).setTextColor(paramInt);
    localObject = (SeekBar)_$_findCachedViewById(a.e.mpSeekBar);
    if (localObject == null) {
      p.iCn();
    }
    ((SeekBar)localObject).getProgressDrawable().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    localObject = (SeekBar)_$_findCachedViewById(a.e.mpSeekBar);
    if (localObject == null) {
      p.iCn();
    }
    ((SeekBar)localObject).getThumb().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    localObject = this.rBA;
    if (localObject == null) {
      p.iCn();
    }
    ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    _$_findCachedViewById(a.e.firstPart).setBackgroundColor(paramInt);
    AppMethodBeat.o(259417);
  }
  
  public final void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(259420);
    Object localObject = (TextView)_$_findCachedViewById(a.e.endTime);
    if (localObject == null) {
      p.iCn();
    }
    ((TextView)localObject).setText((CharSequence)a.DY(paramInt));
    localObject = (SeekBar)_$_findCachedViewById(a.e.mpSeekBar);
    if (localObject == null) {
      p.iCn();
    }
    ((SeekBar)localObject).setMax(paramInt);
    AppMethodBeat.o(259420);
  }
  
  public final void setOnSeekBarChange(b paramb)
  {
    AppMethodBeat.i(259414);
    p.k(paramb, "onSeekBarChange");
    this.FWc = paramb;
    AppMethodBeat.o(259414);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(259419);
    if (this.rjZ)
    {
      AppMethodBeat.o(259419);
      return;
    }
    Object localObject = (TextView)_$_findCachedViewById(a.e.currentTime);
    if (localObject == null) {
      p.iCn();
    }
    ((TextView)localObject).setText((CharSequence)a.DY(paramInt));
    localObject = (SeekBar)_$_findCachedViewById(a.e.mpSeekBar);
    if (localObject == null) {
      p.iCn();
    }
    ((SeekBar)localObject).setProgress(paramInt);
    if (paramInt > 0)
    {
      localObject = _$_findCachedViewById(a.e.firstPart);
      p.j(localObject, "firstPart");
      ((View)localObject).setAlpha(1.0F);
    }
    AppMethodBeat.o(259419);
  }
  
  public final void setSeeking(boolean paramBoolean)
  {
    this.rjZ = paramBoolean;
  }
  
  public final void setTextSize(int paramInt)
  {
    AppMethodBeat.i(259415);
    TextView localTextView = (TextView)_$_findCachedViewById(a.e.currentTime);
    if (localTextView == null) {
      p.iCn();
    }
    localTextView.setTextSize(0, paramInt);
    localTextView = (TextView)_$_findCachedViewById(a.e.endTime);
    if (localTextView == null) {
      p.iCn();
    }
    localTextView.setTextSize(0, paramInt);
    AppMethodBeat.o(259415);
  }
  
  public final void setThumbDrawable(Drawable paramDrawable)
  {
    this.rBA = paramDrawable;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/ui/view/MusicPlayerSeekBar$Companion;", "", "()V", "TAG", "", "timeParse", "duration", "", "plugin-music_release"})
  public static final class a
  {
    public static String DY(int paramInt)
    {
      AppMethodBeat.i(259912);
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
      AppMethodBeat.o(259912);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/ui/view/MusicPlayerSeekBar$OnSeekBarChange;", "", "onSeekBarChange", "", "seekPosition", "", "plugin-music_release"})
  public static abstract interface b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/music/ui/view/MusicPlayerSeekBar$initView$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "mpSeekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "plugin-music_release"})
  public static final class c
    implements SeekBar.OnSeekBarChangeListener
  {
    public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
    
    public final void onStartTrackingTouch(SeekBar paramSeekBar)
    {
      AppMethodBeat.i(260599);
      this.FWe.setSeeking(true);
      AppMethodBeat.o(260599);
    }
    
    public final void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      AppMethodBeat.i(260602);
      this.FWe.setSeeking(false);
      if (MusicPlayerSeekBar.a(this.FWe) != null)
      {
        if (MusicPlayerSeekBar.a(this.FWe) == null) {
          p.iCn();
        }
        if (paramSeekBar == null) {
          p.iCn();
        }
        paramSeekBar.getProgress();
      }
      AppMethodBeat.o(260602);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.MusicPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */