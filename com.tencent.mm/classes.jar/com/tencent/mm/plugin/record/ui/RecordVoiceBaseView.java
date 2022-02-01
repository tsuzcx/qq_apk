package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.record.b.s;
import com.tencent.mm.plugin.record.b.s.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.List;

public class RecordVoiceBaseView
  extends TextView
  implements s.a
{
  private Context context;
  public int dkj;
  public int duration;
  private boolean isRunning;
  private AlphaAnimation orc;
  private AnimationDrawable ord;
  public String path;
  private s vbT;
  
  public RecordVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27982);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    aGa();
    AppMethodBeat.o(27982);
  }
  
  public RecordVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27983);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    aGa();
    AppMethodBeat.o(27983);
  }
  
  private void aGa()
  {
    AppMethodBeat.i(27984);
    this.orc = new AlphaAnimation(0.1F, 1.0F);
    this.orc.setDuration(1000L);
    this.orc.setRepeatCount(-1);
    this.orc.setRepeatMode(2);
    this.ord = new com.tencent.mm.ui.e.a();
    Drawable localDrawable = getResources().getDrawable(2131689892);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.ord.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689893);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.ord.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689894);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.ord.addFrame(localDrawable, 300);
    this.ord.setOneShot(false);
    this.ord.setVisible(true, true);
    AppMethodBeat.o(27984);
  }
  
  private void bTF()
  {
    AppMethodBeat.i(27985);
    if ((this.orc != null) && (this.orc.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131689891), null, null, null);
    this.ord.stop();
    AppMethodBeat.o(27985);
  }
  
  public final void alu(String paramString)
  {
    AppMethodBeat.i(27989);
    ad.d("MicroMsg.RecordVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bt.by(paramString, "").equals(this.path)) {
      bTF();
    }
    AppMethodBeat.o(27989);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(27990);
    stopPlay();
    AppMethodBeat.o(27990);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(27986);
    super.onFinishInflate();
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(27981);
        ad.d("MicroMsg.RecordVoiceBaseView", "clicked path %s, isPlay %s", new Object[] { RecordVoiceBaseView.a(RecordVoiceBaseView.this), Boolean.valueOf(RecordVoiceBaseView.b(RecordVoiceBaseView.this).bTK()) });
        if ((com.tencent.mm.r.a.ce(RecordVoiceBaseView.c(RecordVoiceBaseView.this))) || (com.tencent.mm.r.a.cc(RecordVoiceBaseView.c(RecordVoiceBaseView.this))))
        {
          AppMethodBeat.o(27981);
          return;
        }
        if ((!e.XG()) && (!bt.isNullOrNil(RecordVoiceBaseView.a(RecordVoiceBaseView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          AppMethodBeat.o(27981);
          return;
        }
        if (!bt.by(RecordVoiceBaseView.a(RecordVoiceBaseView.this), "").equals(RecordVoiceBaseView.b(RecordVoiceBaseView.this).path))
        {
          RecordVoiceBaseView.d(RecordVoiceBaseView.this);
          AppMethodBeat.o(27981);
          return;
        }
        if (RecordVoiceBaseView.b(RecordVoiceBaseView.this).bTK())
        {
          RecordVoiceBaseView.this.stopPlay();
          AppMethodBeat.o(27981);
          return;
        }
        if (!RecordVoiceBaseView.e(RecordVoiceBaseView.this)) {
          RecordVoiceBaseView.d(RecordVoiceBaseView.this);
        }
        AppMethodBeat.o(27981);
      }
    });
    AppMethodBeat.o(27986);
  }
  
  public void setVoiceHelper(s params)
  {
    AppMethodBeat.i(27987);
    this.vbT = params;
    params = this.vbT;
    Iterator localIterator = params.callbacks.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (this != (s.a)localIterator.next());
    for (;;)
    {
      AppMethodBeat.o(27987);
      return;
      params.callbacks.add(this);
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(27988);
    ad.d("MicroMsg.RecordVoiceBaseView", "stop play");
    bTF();
    this.vbT.stopPlay();
    AppMethodBeat.o(27988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */