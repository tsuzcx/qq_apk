package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.e.a;

public class NoteEditorVoiceBaseView
  extends TextView
  implements a.a
{
  private Context context;
  public int cve;
  private int duration;
  private boolean isRunning;
  private AlphaAnimation mvO;
  private AnimationDrawable mvP;
  public String path;
  
  public NoteEditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27189);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    bxr();
    AppMethodBeat.o(27189);
  }
  
  public NoteEditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27190);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    bxr();
    AppMethodBeat.o(27190);
  }
  
  private void bxr()
  {
    AppMethodBeat.i(27191);
    this.mvO = new AlphaAnimation(0.1F, 1.0F);
    this.mvO.setDuration(1000L);
    this.mvO.setRepeatCount(-1);
    this.mvO.setRepeatMode(2);
    this.mvP = new a();
    Drawable localDrawable = getResources().getDrawable(2131231098);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.mvP.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131231099);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.mvP.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131231100);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.mvP.addFrame(localDrawable, 300);
    this.mvP.setOneShot(false);
    this.mvP.setVisible(true, true);
    AppMethodBeat.o(27191);
  }
  
  public final void akb(String paramString)
  {
    AppMethodBeat.i(27194);
    ab.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bo.bf(paramString, "").equals(this.path)) {
      cgf();
    }
    AppMethodBeat.o(27194);
  }
  
  public final void cgf()
  {
    AppMethodBeat.i(27192);
    if ((this.mvO != null) && (this.mvO.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131231097), null, null, null);
    this.mvP.stop();
    AppMethodBeat.o(27192);
  }
  
  public final void djY()
  {
    AppMethodBeat.i(27195);
    cgf();
    AppMethodBeat.o(27195);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(27193);
    super.onFinishInflate();
    setOnClickListener(new NoteEditorVoiceBaseView.1(this));
    AppMethodBeat.o(27193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */