package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mm.R.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class NoteEditorVoiceBaseView
  extends TextView
  implements a.a
{
  public int bNM;
  private Context context;
  private int duration = -1;
  private boolean isRunning = false;
  private AlphaAnimation kbs;
  private AnimationDrawable kbt;
  public String path = "";
  
  public NoteEditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    aRd();
  }
  
  public NoteEditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    aRd();
  }
  
  private void aRd()
  {
    this.kbs = new AlphaAnimation(0.1F, 1.0F);
    this.kbs.setDuration(1000L);
    this.kbs.setRepeatCount(-1);
    this.kbs.setRepeatMode(2);
    this.kbt = new AnimationDrawable();
    Drawable localDrawable = getResources().getDrawable(R.k.chatfrom_voice_playing_new_f1);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.kbt.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(R.k.chatfrom_voice_playing_new_f2);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.kbt.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(R.k.chatfrom_voice_playing_new_f3);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.kbt.addFrame(localDrawable, 300);
    this.kbt.setOneShot(false);
    this.kbt.setVisible(true, true);
  }
  
  public final void UJ(String paramString)
  {
    y.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bk.aM(paramString, "").equals(this.path)) {
      bvP();
    }
  }
  
  public final void bvP()
  {
    if ((this.kbs != null) && (this.kbs.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.k.chatfrom_voice_playing_new), null, null, null);
    this.kbt.stop();
  }
  
  public final void cjw()
  {
    bvP();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setOnClickListener(new NoteEditorVoiceBaseView.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */