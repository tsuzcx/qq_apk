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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wenote.model.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.t;

public class NoteEditorVoiceBaseView
  extends TextView
  implements a.a
{
  private Context context;
  public int dui;
  private int duration;
  private boolean isRunning;
  private AlphaAnimation pEQ;
  private AnimationDrawable pER;
  public String path;
  
  public NoteEditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(30890);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    aQx();
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
    aQx();
    AppMethodBeat.o(30891);
  }
  
  private void aQx()
  {
    AppMethodBeat.i(30892);
    this.pEQ = new AlphaAnimation(0.1F, 1.0F);
    this.pEQ.setDuration(1000L);
    this.pEQ.setRepeatCount(-1);
    this.pEQ.setRepeatMode(2);
    this.pER = new com.tencent.mm.ui.e.a();
    Drawable localDrawable = getResources().getDrawable(2131689892);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pER.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689893);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pER.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689894);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pER.addFrame(localDrawable, 300);
    this.pER.setOneShot(false);
    this.pER.setVisible(true, true);
    AppMethodBeat.o(30892);
  }
  
  public final void abP(String paramString)
  {
    AppMethodBeat.i(30895);
    ae.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bu.bI(paramString, "").equals(this.path)) {
      cgN();
    }
    AppMethodBeat.o(30895);
  }
  
  public final void cgN()
  {
    AppMethodBeat.i(30893);
    if ((this.pEQ != null) && (this.pEQ.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131689891), null, null, null);
    this.pER.stop();
    AppMethodBeat.o(30893);
  }
  
  public final void cgO()
  {
    AppMethodBeat.i(30896);
    cgN();
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
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        String str = NoteEditorVoiceBaseView.a(NoteEditorVoiceBaseView.this);
        if (a.fbf().cgS()) {}
        for (localObject = "true";; localObject = "false")
        {
          ae.i("MicroMsg.NoteEditorVoiceBaseView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str, localObject, a.fbf().path });
          if ((!com.tencent.mm.r.a.ch(NoteEditorVoiceBaseView.b(NoteEditorVoiceBaseView.this))) && (!com.tencent.mm.r.a.cf(NoteEditorVoiceBaseView.b(NoteEditorVoiceBaseView.this))) && (!com.tencent.mm.r.a.cj(NoteEditorVoiceBaseView.b(NoteEditorVoiceBaseView.this)))) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30889);
          return;
        }
        if ((!e.abo()) && (!bu.isNullOrNil(NoteEditorVoiceBaseView.a(NoteEditorVoiceBaseView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30889);
          return;
        }
        if (k.fay().pzT)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30889);
          return;
        }
        if ((bu.bI(NoteEditorVoiceBaseView.a(NoteEditorVoiceBaseView.this), "").equals(a.fbf().path)) && (a.fbf().cgS()))
        {
          paramAnonymousView = NoteEditorVoiceBaseView.this;
          ae.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
          paramAnonymousView.cgN();
          a.fbf().stopPlay();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30889);
          return;
          NoteEditorVoiceBaseView.c(NoteEditorVoiceBaseView.this);
        }
      }
    });
    AppMethodBeat.o(30894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */