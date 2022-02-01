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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.t;

public class NoteEditorVoiceBaseView
  extends TextView
  implements a.a
{
  private Context context;
  public int dtc;
  private int duration;
  private boolean isRunning;
  public String path;
  private AlphaAnimation pym;
  private AnimationDrawable pyn;
  
  public NoteEditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(30890);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    aPY();
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
    aPY();
    AppMethodBeat.o(30891);
  }
  
  private void aPY()
  {
    AppMethodBeat.i(30892);
    this.pym = new AlphaAnimation(0.1F, 1.0F);
    this.pym.setDuration(1000L);
    this.pym.setRepeatCount(-1);
    this.pym.setRepeatMode(2);
    this.pyn = new com.tencent.mm.ui.e.a();
    Drawable localDrawable = getResources().getDrawable(2131689892);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pyn.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689893);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pyn.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689894);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pyn.addFrame(localDrawable, 300);
    this.pyn.setOneShot(false);
    this.pyn.setVisible(true, true);
    AppMethodBeat.o(30892);
  }
  
  public final void aaY(String paramString)
  {
    AppMethodBeat.i(30895);
    ad.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bt.bI(paramString, "").equals(this.path)) {
      cfx();
    }
    AppMethodBeat.o(30895);
  }
  
  public final void cfx()
  {
    AppMethodBeat.i(30893);
    if ((this.pym != null) && (this.pym.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131689891), null, null, null);
    this.pyn.stop();
    AppMethodBeat.o(30893);
  }
  
  public final void cfy()
  {
    AppMethodBeat.i(30896);
    cfx();
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        String str = NoteEditorVoiceBaseView.a(NoteEditorVoiceBaseView.this);
        if (a.eXt().cfC()) {}
        for (localObject = "true";; localObject = "false")
        {
          ad.i("MicroMsg.NoteEditorVoiceBaseView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str, localObject, a.eXt().path });
          if ((!com.tencent.mm.s.a.cf(NoteEditorVoiceBaseView.b(NoteEditorVoiceBaseView.this))) && (!com.tencent.mm.s.a.cd(NoteEditorVoiceBaseView.b(NoteEditorVoiceBaseView.this))) && (!com.tencent.mm.s.a.ch(NoteEditorVoiceBaseView.b(NoteEditorVoiceBaseView.this)))) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30889);
          return;
        }
        if ((!e.abf()) && (!bt.isNullOrNil(NoteEditorVoiceBaseView.a(NoteEditorVoiceBaseView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30889);
          return;
        }
        if (k.eWM().ptn)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30889);
          return;
        }
        if ((bt.bI(NoteEditorVoiceBaseView.a(NoteEditorVoiceBaseView.this), "").equals(a.eXt().path)) && (a.eXt().cfC()))
        {
          paramAnonymousView = NoteEditorVoiceBaseView.this;
          ad.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
          paramAnonymousView.cfx();
          a.eXt().stopPlay();
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