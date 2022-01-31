package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.base.preference.Preference;

public class MusicPreference
  extends Preference
{
  private boolean isPlaying;
  private View mView = null;
  public String nGD = "";
  public String nGE = "";
  public String nGF = "";
  private ImageButton nJK = null;
  MusicPreference.a nJL;
  private View.OnClickListener nuB;
  
  public MusicPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MusicPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MusicPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(R.i.mm_preference_music);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    return this.mView;
  }
  
  public final void iy(boolean paramBoolean)
  {
    this.isPlaying = paramBoolean;
    if (this.nJK != null)
    {
      if (paramBoolean) {
        this.nJK.setImageResource(R.g.product_music_stop_btn);
      }
    }
    else {
      return;
    }
    this.nJK.setImageResource(R.g.product_music_play_btn);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    if (this.nuB == null) {
      this.nuB = new MusicPreference.1(this);
    }
    this.nJK = ((ImageButton)paramView.findViewById(R.h.pref_music_play_ib));
    this.nJK.setOnClickListener(this.nuB);
    if (this.isPlaying)
    {
      this.nJK.setImageResource(R.g.product_music_stop_btn);
      return;
    }
    this.nJK.setImageResource(R.g.product_music_play_btn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.MusicPreference
 * JD-Core Version:    0.7.0.1
 */