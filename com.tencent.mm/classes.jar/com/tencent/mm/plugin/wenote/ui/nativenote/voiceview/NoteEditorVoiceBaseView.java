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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.t;

public class NoteEditorVoiceBaseView
  extends TextView
  implements a.a
{
  private Context context;
  public int dhE;
  private int duration;
  private boolean isRunning;
  private AlphaAnimation oUC;
  private AnimationDrawable oUD;
  public String path;
  
  public NoteEditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(30890);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    aMN();
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
    aMN();
    AppMethodBeat.o(30891);
  }
  
  private void aMN()
  {
    AppMethodBeat.i(30892);
    this.oUC = new AlphaAnimation(0.1F, 1.0F);
    this.oUC.setDuration(1000L);
    this.oUC.setRepeatCount(-1);
    this.oUC.setRepeatMode(2);
    this.oUD = new com.tencent.mm.ui.e.a();
    Drawable localDrawable = getResources().getDrawable(2131689892);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.oUD.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689893);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.oUD.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689894);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.oUD.addFrame(localDrawable, 300);
    this.oUD.setOneShot(false);
    this.oUD.setVisible(true, true);
    AppMethodBeat.o(30892);
  }
  
  public final void Xr(String paramString)
  {
    AppMethodBeat.i(30895);
    ac.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bs.bG(paramString, "").equals(this.path)) {
      caT();
    }
    AppMethodBeat.o(30895);
  }
  
  public final void caT()
  {
    AppMethodBeat.i(30893);
    if ((this.oUC != null) && (this.oUC.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131689891), null, null, null);
    this.oUD.stop();
    AppMethodBeat.o(30893);
  }
  
  public final void caU()
  {
    AppMethodBeat.i(30896);
    caT();
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
        if (a.eIA().caY()) {}
        for (String str1 = "true";; str1 = "false")
        {
          ac.i("MicroMsg.NoteEditorVoiceBaseView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str2, str1, a.eIA().path });
          if ((!com.tencent.mm.r.a.ci(NoteEditorVoiceBaseView.b(NoteEditorVoiceBaseView.this))) && (!com.tencent.mm.r.a.cf(NoteEditorVoiceBaseView.b(NoteEditorVoiceBaseView.this))) && (!com.tencent.mm.r.a.ck(NoteEditorVoiceBaseView.b(NoteEditorVoiceBaseView.this)))) {
            break;
          }
          AppMethodBeat.o(30889);
          return;
        }
        if ((!e.YD()) && (!bs.isNullOrNil(NoteEditorVoiceBaseView.a(NoteEditorVoiceBaseView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          AppMethodBeat.o(30889);
          return;
        }
        if (k.eHT().oPF)
        {
          AppMethodBeat.o(30889);
          return;
        }
        if ((bs.bG(NoteEditorVoiceBaseView.a(NoteEditorVoiceBaseView.this), "").equals(a.eIA().path)) && (a.eIA().caY()))
        {
          paramAnonymousView = NoteEditorVoiceBaseView.this;
          ac.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
          paramAnonymousView.caT();
          a.eIA().stopPlay();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */