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
import com.tencent.mm.R.k;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.record.model.u;
import com.tencent.mm.plugin.record.model.u.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import java.util.Iterator;
import java.util.List;

public class RecordVoiceBaseView
  extends TextView
  implements u.a
{
  private u NCj;
  private boolean Uz;
  private Context context;
  public int duration;
  public int hIY;
  public String path;
  private AlphaAnimation xCM;
  private AnimationDrawable xCN;
  
  public RecordVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27982);
    this.Uz = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    bTa();
    AppMethodBeat.o(27982);
  }
  
  public RecordVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27983);
    this.Uz = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    bTa();
    AppMethodBeat.o(27983);
  }
  
  private void bTa()
  {
    AppMethodBeat.i(27984);
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
    AppMethodBeat.o(27984);
  }
  
  private void dxz()
  {
    AppMethodBeat.i(27985);
    if ((this.xCM != null) && (this.xCM.isInitialized())) {
      setAnimation(null);
    }
    this.Uz = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.k.chatfrom_voice_playing_new), null, null, null);
    this.xCN.stop();
    AppMethodBeat.o(27985);
  }
  
  public final void aSI(String paramString)
  {
    AppMethodBeat.i(27989);
    Log.d("MicroMsg.RecordVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!Util.nullAs(paramString, "").equals(this.path)) {
      dxz();
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
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/RecordVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.d("MicroMsg.RecordVoiceBaseView", "clicked path %s, isPlay %s", new Object[] { RecordVoiceBaseView.a(RecordVoiceBaseView.this), Boolean.valueOf(RecordVoiceBaseView.b(RecordVoiceBaseView.this).dxE()) });
        if ((com.tencent.mm.n.a.dm(RecordVoiceBaseView.c(RecordVoiceBaseView.this))) || (com.tencent.mm.n.a.dl(RecordVoiceBaseView.c(RecordVoiceBaseView.this))) || (com.tencent.mm.n.a.dp(RecordVoiceBaseView.c(RecordVoiceBaseView.this))))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27981);
          return;
        }
        if ((!e.aPU()) && (!Util.isNullOrNil(RecordVoiceBaseView.a(RecordVoiceBaseView.this))))
        {
          aa.j(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27981);
          return;
        }
        if (!Util.nullAs(RecordVoiceBaseView.a(RecordVoiceBaseView.this), "").equals(RecordVoiceBaseView.b(RecordVoiceBaseView.this).path)) {
          RecordVoiceBaseView.d(RecordVoiceBaseView.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27981);
          return;
          if (RecordVoiceBaseView.b(RecordVoiceBaseView.this).dxE()) {
            RecordVoiceBaseView.this.stopPlay();
          } else if (!RecordVoiceBaseView.e(RecordVoiceBaseView.this)) {
            RecordVoiceBaseView.d(RecordVoiceBaseView.this);
          }
        }
      }
    });
    AppMethodBeat.o(27986);
  }
  
  public void setVoiceHelper(u paramu)
  {
    AppMethodBeat.i(27987);
    this.NCj = paramu;
    paramu = this.NCj;
    Iterator localIterator = paramu.bPE.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (this != (u.a)localIterator.next());
    for (;;)
    {
      AppMethodBeat.o(27987);
      return;
      paramu.bPE.add(this);
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(27988);
    Log.d("MicroMsg.RecordVoiceBaseView", "stop play");
    dxz();
    this.NCj.stopPlay();
    AppMethodBeat.o(27988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */