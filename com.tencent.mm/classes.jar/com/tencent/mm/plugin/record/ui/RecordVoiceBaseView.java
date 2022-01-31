package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.b.s;
import com.tencent.mm.plugin.record.b.s.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.e.a;
import java.util.Iterator;
import java.util.List;

public class RecordVoiceBaseView
  extends TextView
  implements s.a
{
  private Context context;
  public int cve;
  public int duration;
  private boolean isRunning;
  private AlphaAnimation mvO;
  private AnimationDrawable mvP;
  private s pZX;
  public String path;
  
  public RecordVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24325);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    bxr();
    AppMethodBeat.o(24325);
  }
  
  public RecordVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(24326);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    bxr();
    AppMethodBeat.o(24326);
  }
  
  private void bxr()
  {
    AppMethodBeat.i(24327);
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
    AppMethodBeat.o(24327);
  }
  
  private void cgf()
  {
    AppMethodBeat.i(24328);
    if ((this.mvO != null) && (this.mvO.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131231097), null, null, null);
    this.mvP.stop();
    AppMethodBeat.o(24328);
  }
  
  public final void XT(String paramString)
  {
    AppMethodBeat.i(24332);
    ab.d("MicroMsg.RecordVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bo.bf(paramString, "").equals(this.path)) {
      cgf();
    }
    AppMethodBeat.o(24332);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(24333);
    stopPlay();
    AppMethodBeat.o(24333);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(24329);
    super.onFinishInflate();
    setOnClickListener(new RecordVoiceBaseView.1(this));
    AppMethodBeat.o(24329);
  }
  
  public void setVoiceHelper(s params)
  {
    AppMethodBeat.i(24330);
    this.pZX = params;
    params = this.pZX;
    Iterator localIterator = params.callbacks.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (this != (s.a)localIterator.next());
    for (;;)
    {
      AppMethodBeat.o(24330);
      return;
      params.callbacks.add(this);
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(24331);
    ab.d("MicroMsg.RecordVoiceBaseView", "stop play");
    cgf();
    this.pZX.stopPlay();
    AppMethodBeat.o(24331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */