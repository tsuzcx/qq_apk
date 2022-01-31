package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mm.R.k;
import com.tencent.mm.plugin.record.b.m;
import com.tencent.mm.plugin.record.b.m.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

public class RecordVoiceBaseView
  extends TextView
  implements m.a
{
  public int bNM;
  private Context context;
  public int duration = -1;
  private boolean isRunning = false;
  private AlphaAnimation kbs;
  private AnimationDrawable kbt;
  private m nup;
  public String path = "";
  
  public RecordVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    aRd();
  }
  
  public RecordVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
  
  private void bvP()
  {
    if ((this.kbs != null) && (this.kbs.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.k.chatfrom_voice_playing_new), null, null, null);
    this.kbt.stop();
  }
  
  public final void LI(String paramString)
  {
    y.d("MicroMsg.RecordVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bk.aM(paramString, "").equals(this.path)) {
      bvP();
    }
  }
  
  public final void onFinish()
  {
    stopPlay();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setOnClickListener(new RecordVoiceBaseView.1(this));
  }
  
  public void setVoiceHelper(m paramm)
  {
    this.nup = paramm;
    paramm = this.nup;
    Iterator localIterator = paramm.dhm.iterator();
    while (localIterator.hasNext()) {
      if (this == (m.a)localIterator.next()) {
        return;
      }
    }
    paramm.dhm.add(this);
  }
  
  public final void stopPlay()
  {
    y.d("MicroMsg.RecordVoiceBaseView", "stop play");
    bvP();
    this.nup.stopPlay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */