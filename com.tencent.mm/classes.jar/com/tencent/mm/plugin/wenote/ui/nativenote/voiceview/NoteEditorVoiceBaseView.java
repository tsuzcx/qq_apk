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
import com.tencent.mm.R.k;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wenote.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;

public class NoteEditorVoiceBaseView
  extends TextView
  implements a.a
{
  private boolean Uz;
  private Context context;
  private int duration;
  public int hIY;
  public String path;
  private AlphaAnimation xCM;
  private AnimationDrawable xCN;
  
  public NoteEditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(30890);
    this.Uz = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    bTa();
    AppMethodBeat.o(30890);
  }
  
  public NoteEditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(30891);
    this.Uz = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    bTa();
    AppMethodBeat.o(30891);
  }
  
  private void bTa()
  {
    AppMethodBeat.i(30892);
    this.xCM = new AlphaAnimation(0.1F, 1.0F);
    this.xCM.setDuration(1000L);
    this.xCM.setRepeatCount(-1);
    this.xCM.setRepeatMode(2);
    this.xCN = new com.tencent.mm.ui.g.a();
    Drawable localDrawable = getResources().getDrawable(R.k.chatfrom_voice_playing_new_f1);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.xCN.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(R.k.chatfrom_voice_playing_new_f2);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.xCN.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(R.k.chatfrom_voice_playing_new_f3);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.xCN.addFrame(localDrawable, 300);
    this.xCN.setOneShot(false);
    this.xCN.setVisible(true, true);
    AppMethodBeat.o(30892);
  }
  
  public final void anE(String paramString)
  {
    AppMethodBeat.i(30895);
    Log.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!Util.nullAs(paramString, "").equals(this.path)) {
      dxz();
    }
    AppMethodBeat.o(30895);
  }
  
  public final void dxA()
  {
    AppMethodBeat.i(30896);
    dxz();
    AppMethodBeat.o(30896);
  }
  
  public final void dxz()
  {
    AppMethodBeat.i(30893);
    if ((this.xCM != null) && (this.xCM.isInitialized())) {
      setAnimation(null);
    }
    this.Uz = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.k.chatfrom_voice_playing_new), null, null, null);
    this.xCN.stop();
    AppMethodBeat.o(30893);
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
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        String str = NoteEditorVoiceBaseView.a(NoteEditorVoiceBaseView.this);
        if (a.iEK().dxE()) {}
        for (localObject = "true";; localObject = "false")
        {
          Log.i("MicroMsg.NoteEditorVoiceBaseView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str, localObject, a.iEK().path });
          if ((!com.tencent.mm.n.a.dm(NoteEditorVoiceBaseView.b(NoteEditorVoiceBaseView.this))) && (!com.tencent.mm.n.a.dl(NoteEditorVoiceBaseView.b(NoteEditorVoiceBaseView.this))) && (!com.tencent.mm.n.a.dp(NoteEditorVoiceBaseView.b(NoteEditorVoiceBaseView.this)))) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30889);
          return;
        }
        if ((!e.aPU()) && (!Util.isNullOrNil(NoteEditorVoiceBaseView.a(NoteEditorVoiceBaseView.this))))
        {
          aa.j(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30889);
          return;
        }
        if (k.iDY().xxL)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30889);
          return;
        }
        if ((Util.nullAs(NoteEditorVoiceBaseView.a(NoteEditorVoiceBaseView.this), "").equals(a.iEK().path)) && (a.iEK().dxE()))
        {
          paramAnonymousView = NoteEditorVoiceBaseView.this;
          Log.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
          paramAnonymousView.dxz();
          a.iEK().stopPlay();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */