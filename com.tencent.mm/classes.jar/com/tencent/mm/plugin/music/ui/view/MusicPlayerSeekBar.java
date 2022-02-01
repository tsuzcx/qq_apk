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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/ui/view/MusicPlayerSeekBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSeeking", "", "()Z", "setSeeking", "(Z)V", "onSeekBarChange", "Lcom/tencent/mm/plugin/music/ui/view/MusicPlayerSeekBar$OnSeekBarChange;", "thumbDrawable", "Landroid/graphics/drawable/Drawable;", "getThumbDrawable", "()Landroid/graphics/drawable/Drawable;", "setThumbDrawable", "(Landroid/graphics/drawable/Drawable;)V", "enableLoading", "", "enable", "initView", "setColor", "color", "setGravityNoSpan", "setMaxProgress", "totalDuration", "setOnSeekBarChange", "setProgress", "currentPos", "setTextSize", "textSize", "Companion", "OnSeekBarChange", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicPlayerSeekBar
  extends FrameLayout
{
  public static final MusicPlayerSeekBar.a LRb;
  private MusicPlayerSeekBar.b LRc;
  private boolean msx;
  private Drawable uMP;
  
  static
  {
    AppMethodBeat.i(270978);
    LRb = new MusicPlayerSeekBar.a((byte)0);
    AppMethodBeat.o(270978);
  }
  
  public MusicPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(270969);
    AppMethodBeat.o(270969);
  }
  
  public MusicPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(270967);
    View.inflate(getContext(), a.g.music_player_seek_bar, (ViewGroup)this);
    paramContext = (TextView)findViewById(a.e.currentTime);
    s.checkNotNull(paramContext);
    paramContext.setText((CharSequence)"00:00");
    paramContext = (TextView)findViewById(a.e.endTime);
    s.checkNotNull(paramContext);
    paramContext.setText((CharSequence)"--:--");
    this.uMP = getResources().getDrawable(a.d.music_seek_bar_tumb);
    Util.expandViewTouchArea((View)findViewById(a.e.mpSeekBar), 100, 100, 100, 100);
    ((SeekBar)findViewById(a.e.mpSeekBar)).setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new c(this));
    AppMethodBeat.o(270967);
  }
  
  public final Drawable getThumbDrawable()
  {
    return this.uMP;
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(271008);
    Object localObject = (TextView)findViewById(a.e.currentTime);
    s.checkNotNull(localObject);
    ((TextView)localObject).setTextColor(paramInt);
    localObject = (TextView)findViewById(a.e.endTime);
    s.checkNotNull(localObject);
    ((TextView)localObject).setTextColor(paramInt);
    localObject = (SeekBar)findViewById(a.e.mpSeekBar);
    s.checkNotNull(localObject);
    ((SeekBar)localObject).getProgressDrawable().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    localObject = (SeekBar)findViewById(a.e.mpSeekBar);
    s.checkNotNull(localObject);
    ((SeekBar)localObject).getThumb().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    localObject = this.uMP;
    s.checkNotNull(localObject);
    ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    findViewById(a.e.firstPart).setBackgroundColor(paramInt);
    AppMethodBeat.o(271008);
  }
  
  public final void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(271020);
    Object localObject = (TextView)findViewById(a.e.endTime);
    s.checkNotNull(localObject);
    ((TextView)localObject).setText((CharSequence)MusicPlayerSeekBar.a.Ey(paramInt));
    localObject = (SeekBar)findViewById(a.e.mpSeekBar);
    s.checkNotNull(localObject);
    ((SeekBar)localObject).setMax(paramInt);
    AppMethodBeat.o(271020);
  }
  
  public final void setOnSeekBarChange(MusicPlayerSeekBar.b paramb)
  {
    AppMethodBeat.i(270999);
    s.u(paramb, "onSeekBarChange");
    this.LRc = paramb;
    AppMethodBeat.o(270999);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(271015);
    if (this.msx)
    {
      AppMethodBeat.o(271015);
      return;
    }
    Object localObject = (TextView)findViewById(a.e.currentTime);
    s.checkNotNull(localObject);
    ((TextView)localObject).setText((CharSequence)MusicPlayerSeekBar.a.Ey(paramInt));
    localObject = (SeekBar)findViewById(a.e.mpSeekBar);
    s.checkNotNull(localObject);
    ((SeekBar)localObject).setProgress(paramInt);
    if (paramInt > 0) {
      findViewById(a.e.firstPart).setAlpha(1.0F);
    }
    AppMethodBeat.o(271015);
  }
  
  public final void setSeeking(boolean paramBoolean)
  {
    this.msx = paramBoolean;
  }
  
  public final void setTextSize(int paramInt)
  {
    AppMethodBeat.i(271004);
    TextView localTextView = (TextView)findViewById(a.e.currentTime);
    s.checkNotNull(localTextView);
    localTextView.setTextSize(0, paramInt);
    localTextView = (TextView)findViewById(a.e.endTime);
    s.checkNotNull(localTextView);
    localTextView.setTextSize(0, paramInt);
    AppMethodBeat.o(271004);
  }
  
  public final void setThumbDrawable(Drawable paramDrawable)
  {
    this.uMP = paramDrawable;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/music/ui/view/MusicPlayerSeekBar$initView$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "mpSeekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements SeekBar.OnSeekBarChangeListener
  {
    c(MusicPlayerSeekBar paramMusicPlayerSeekBar) {}
    
    public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
    
    public final void onStartTrackingTouch(SeekBar paramSeekBar)
    {
      AppMethodBeat.i(270972);
      this.LRd.setSeeking(true);
      AppMethodBeat.o(270972);
    }
    
    public final void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      AppMethodBeat.i(270979);
      this.LRd.setSeeking(false);
      if (MusicPlayerSeekBar.a(this.LRd) != null)
      {
        s.checkNotNull(MusicPlayerSeekBar.a(this.LRd));
        s.checkNotNull(paramSeekBar);
        paramSeekBar.getProgress();
      }
      AppMethodBeat.o(270979);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.MusicPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */