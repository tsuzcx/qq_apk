package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.y;

public class NoteVoiceView
  extends FrameLayout
  implements a.a
{
  public int bNM;
  public int duration;
  public View hoY;
  private ViewGroup kdA;
  TextView kdB;
  private ImageButton kdC;
  private TextView kdD;
  public String path = "";
  private TextView rNI;
  public a rNJ;
  public NoteVoiceView.a rNK;
  
  public NoteVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public NoteVoiceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void cjy()
  {
    this.rNK.stop();
    this.kdB.setKeepScreenOn(false);
  }
  
  private void init(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(R.i.note_voice_view, this, true);
  }
  
  public final void UJ(String paramString)
  {
    if (!this.path.equals(paramString)) {
      cjy();
    }
  }
  
  public final void cjw()
  {
    cjy();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    y.i("MicroMsg.NoteVoiceView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.rNK.isPaused) });
    if (this.rNK.isPaused) {
      this.rNK.postDelayed(new NoteVoiceView.1(this), 128L);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.kdA = ((ViewGroup)findViewById(R.h.voice_player_progress_bg));
    this.kdD = ((TextView)findViewById(R.h.voice_player_length));
    this.rNI = ((TextView)findViewById(R.h.voice_player_total_length));
    this.kdB = ((TextView)findViewById(R.h.voice_player_progress));
    this.kdC = ((ImageButton)findViewById(R.h.voice_player_btn));
    this.hoY = findViewById(R.h.voice_view_mask);
    this.rNK = new NoteVoiceView.a(this, (byte)0);
    this.kdC.setOnClickListener(new NoteVoiceView.2(this));
  }
  
  public void setVoiceHelper(a parama)
  {
    this.rNJ = parama;
    this.rNJ.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView
 * JD-Core Version:    0.7.0.1
 */