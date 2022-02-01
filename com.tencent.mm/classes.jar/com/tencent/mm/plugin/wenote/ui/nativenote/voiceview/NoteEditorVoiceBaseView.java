package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

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
import com.tencent.mm.plugin.wenote.model.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.t;

public class NoteEditorVoiceBaseView
  extends TextView
  implements a.a
{
  private Context context;
  public int dkj;
  private int duration;
  private boolean isRunning;
  private AlphaAnimation orc;
  private AnimationDrawable ord;
  public String path;
  
  public NoteEditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(30890);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    aGa();
    AppMethodBeat.o(30890);
  }
  
  public NoteEditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(30891);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    aGa();
    AppMethodBeat.o(30891);
  }
  
  private void aGa()
  {
    AppMethodBeat.i(30892);
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
    AppMethodBeat.o(30892);
  }
  
  public final void Tf(String paramString)
  {
    AppMethodBeat.i(30895);
    ad.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bt.by(paramString, "").equals(this.path)) {
      bTF();
    }
    AppMethodBeat.o(30895);
  }
  
  public final void bTF()
  {
    AppMethodBeat.i(30893);
    if ((this.orc != null) && (this.orc.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131689891), null, null, null);
    this.ord.stop();
    AppMethodBeat.o(30893);
  }
  
  public final void bTG()
  {
    AppMethodBeat.i(30896);
    bTF();
    AppMethodBeat.o(30896);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(30894);
    super.onFinishInflate();
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30889);
        String str2 = NoteEditorVoiceBaseView.a(NoteEditorVoiceBaseView.this);
        if (a.eth().bTK()) {}
        for (String str1 = "true";; str1 = "false")
        {
          ad.i("MicroMsg.NoteEditorVoiceBaseView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str2, str1, a.eth().path });
          if ((!com.tencent.mm.r.a.ce(NoteEditorVoiceBaseView.b(NoteEditorVoiceBaseView.this))) && (!com.tencent.mm.r.a.cc(NoteEditorVoiceBaseView.b(NoteEditorVoiceBaseView.this)))) {
            break;
          }
          AppMethodBeat.o(30889);
          return;
        }
        if ((!e.XG()) && (!bt.isNullOrNil(NoteEditorVoiceBaseView.a(NoteEditorVoiceBaseView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          AppMethodBeat.o(30889);
          return;
        }
        if (k.esA().omf)
        {
          AppMethodBeat.o(30889);
          return;
        }
        if ((bt.by(NoteEditorVoiceBaseView.a(NoteEditorVoiceBaseView.this), "").equals(a.eth().path)) && (a.eth().bTK()))
        {
          paramAnonymousView = NoteEditorVoiceBaseView.this;
          ad.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
          paramAnonymousView.bTF();
          a.eth().stopPlay();
          AppMethodBeat.o(30889);
          return;
        }
        NoteEditorVoiceBaseView.c(NoteEditorVoiceBaseView.this);
        AppMethodBeat.o(30889);
      }
    });
    AppMethodBeat.o(30894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */