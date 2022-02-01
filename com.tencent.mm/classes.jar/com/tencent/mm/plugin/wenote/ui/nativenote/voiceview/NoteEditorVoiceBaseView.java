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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;

public class NoteEditorVoiceBaseView
  extends TextView
  implements a.a
{
  private Context context;
  public int dLt;
  private int duration;
  private boolean isRunning;
  public String path;
  private AlphaAnimation qUh;
  private AnimationDrawable qUi;
  
  public NoteEditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(30890);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    blc();
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
    blc();
    AppMethodBeat.o(30891);
  }
  
  private void blc()
  {
    AppMethodBeat.i(30892);
    this.qUh = new AlphaAnimation(0.1F, 1.0F);
    this.qUh.setDuration(1000L);
    this.qUh.setRepeatCount(-1);
    this.qUh.setRepeatMode(2);
    this.qUi = new com.tencent.mm.ui.f.a();
    Drawable localDrawable = getResources().getDrawable(2131689907);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.qUi.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689908);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.qUi.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689909);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.qUi.addFrame(localDrawable, 300);
    this.qUi.setOneShot(false);
    this.qUi.setVisible(true, true);
    AppMethodBeat.o(30892);
  }
  
  public final void alV(String paramString)
  {
    AppMethodBeat.i(30895);
    Log.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!Util.nullAs(paramString, "").equals(this.path)) {
      cEA();
    }
    AppMethodBeat.o(30895);
  }
  
  public final void cEA()
  {
    AppMethodBeat.i(30893);
    if ((this.qUh != null) && (this.qUh.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131689906), null, null, null);
    this.qUi.stop();
    AppMethodBeat.o(30893);
  }
  
  public final void cEB()
  {
    AppMethodBeat.i(30896);
    cEA();
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
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        String str = NoteEditorVoiceBaseView.a(NoteEditorVoiceBaseView.this);
        if (a.gkl().cEF()) {}
        for (localObject = "true";; localObject = "false")
        {
          Log.i("MicroMsg.NoteEditorVoiceBaseView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str, localObject, a.gkl().path });
          if ((!com.tencent.mm.q.a.cC(NoteEditorVoiceBaseView.b(NoteEditorVoiceBaseView.this))) && (!com.tencent.mm.q.a.cA(NoteEditorVoiceBaseView.b(NoteEditorVoiceBaseView.this))) && (!com.tencent.mm.q.a.cE(NoteEditorVoiceBaseView.b(NoteEditorVoiceBaseView.this)))) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30889);
          return;
        }
        if ((!e.apn()) && (!Util.isNullOrNil(NoteEditorVoiceBaseView.a(NoteEditorVoiceBaseView.this))))
        {
          u.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30889);
          return;
        }
        if (k.gjD().qPk)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30889);
          return;
        }
        if ((Util.nullAs(NoteEditorVoiceBaseView.a(NoteEditorVoiceBaseView.this), "").equals(a.gkl().path)) && (a.gkl().cEF()))
        {
          paramAnonymousView = NoteEditorVoiceBaseView.this;
          Log.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
          paramAnonymousView.cEA();
          a.gkl().stopPlay();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */