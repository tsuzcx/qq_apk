package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.j;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import java.util.Iterator;
import java.util.List;

public class NoteVoiceView
  extends FrameLayout
  implements a.a
{
  private ImageButton AiO;
  public a XEg;
  public a XEh;
  public int duration;
  public int hIY;
  public View maskView;
  public String path;
  private ViewGroup xCX;
  TextView xCY;
  private TextView xDa;
  private TextView xxU;
  
  public NoteVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(30919);
    this.path = "";
    init(paramContext);
    AppMethodBeat.o(30919);
  }
  
  public NoteVoiceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(30920);
    this.path = "";
    init(paramContext);
    AppMethodBeat.o(30920);
  }
  
  private void dxF()
  {
    AppMethodBeat.i(30926);
    this.XEh.stop();
    this.xCY.setKeepScreenOn(false);
    AppMethodBeat.o(30926);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(30921);
    LayoutInflater.from(paramContext).inflate(R.i.gmJ, this, true);
    AppMethodBeat.o(30921);
  }
  
  public final void anE(String paramString)
  {
    AppMethodBeat.i(30922);
    if (!this.path.equals(paramString)) {
      dxF();
    }
    AppMethodBeat.o(30922);
  }
  
  public final void dxA()
  {
    AppMethodBeat.i(30923);
    dxF();
    AppMethodBeat.o(30923);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(30924);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.NoteVoiceView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.XEh.isPaused) });
    if (this.XEh.isPaused) {
      this.XEh.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30912);
          NoteVoiceView.g(NoteVoiceView.this).bgE();
          AppMethodBeat.o(30912);
        }
      }, 128L);
    }
    AppMethodBeat.o(30924);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(30925);
    super.onFinishInflate();
    this.xCX = ((ViewGroup)findViewById(R.h.voice_player_progress_bg));
    this.xxU = ((TextView)findViewById(R.h.voice_player_length));
    this.xDa = ((TextView)findViewById(R.h.voice_player_total_length));
    this.xCY = ((TextView)findViewById(R.h.voice_player_progress));
    this.AiO = ((ImageButton)findViewById(R.h.voice_player_btn));
    this.maskView = findViewById(R.h.gdi);
    this.XEh = new a((byte)0);
    this.AiO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30913);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteVoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if ((com.tencent.mm.n.a.dm(paramAnonymousView.getContext())) || (com.tencent.mm.n.a.dl(paramAnonymousView.getContext())) || (com.tencent.mm.n.a.dp(paramAnonymousView.getContext())))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteVoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30913);
          return;
        }
        if ((!e.aPU()) && (!Util.isNullOrNil(NoteVoiceView.h(NoteVoiceView.this))))
        {
          aa.j(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteVoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30913);
          return;
        }
        if (!Util.nullAs(NoteVoiceView.h(NoteVoiceView.this), "").equals(NoteVoiceView.i(NoteVoiceView.this).path)) {
          NoteVoiceView.j(NoteVoiceView.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteVoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30913);
          return;
          if (NoteVoiceView.i(NoteVoiceView.this).dxE())
          {
            paramAnonymousView = NoteVoiceView.this;
            Log.i("MicroMsg.NoteVoiceView", "pause play");
            localObject = paramAnonymousView.XEg;
            Log.i("MicroMsg.RecordVoiceHelper", "pause play");
            MMEntryLock.unlock("keep_app_silent");
            if (((a)localObject).xCQ == null) {
              Log.w("MicroMsg.RecordVoiceHelper", "pause play error, player is null");
            }
            for (;;)
            {
              localObject = paramAnonymousView.XEh;
              ((NoteVoiceView.a)localObject).isPaused = true;
              ((NoteVoiceView.a)localObject).removeMessages(4096);
              NoteVoiceView.c(((NoteVoiceView.a)localObject).XEi).setImageResource(R.k.voicepost_beginicon);
              NoteVoiceView.c(((NoteVoiceView.a)localObject).XEi).setContentDescription(((NoteVoiceView.a)localObject).XEi.getContext().getResources().getString(R.l.app_play) + ((NoteVoiceView.a)localObject).XEi.getContext().getResources().getString(R.l.gOX));
              paramAnonymousView.xCY.setKeepScreenOn(false);
              break;
              if (((a)localObject).xCQ.pause())
              {
                localObject = ((a)localObject).bPE.iterator();
                while (((Iterator)localObject).hasNext()) {
                  ((Iterator)localObject).next();
                }
              }
            }
          }
          if (!NoteVoiceView.this.resumePlay()) {
            NoteVoiceView.j(NoteVoiceView.this);
          }
        }
      }
    });
    AppMethodBeat.o(30925);
  }
  
  public final boolean resumePlay()
  {
    AppMethodBeat.i(275229);
    Log.i("MicroMsg.NoteVoiceView", "resume play");
    Object localObject = this.XEg;
    Log.i("MicroMsg.RecordVoiceHelper", "resume play");
    MMEntryLock.lock("keep_app_silent");
    boolean bool1;
    if (((a)localObject).xCQ == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
      bool1 = false;
    }
    boolean bool2;
    do
    {
      localObject = this.XEh;
      ((a)localObject).isPaused = false;
      ((a)localObject).sendEmptyMessage(4096);
      ((a)localObject).XEi.AiO.setImageResource(R.k.voicepost_pauseicon);
      ((a)localObject).XEi.AiO.setContentDescription(((a)localObject).XEi.getContext().getResources().getString(R.l.app_pause));
      this.xCY.setKeepScreenOn(true);
      AppMethodBeat.o(275229);
      return bool1;
      bool2 = ((a)localObject).xCQ.resume();
      bool1 = bool2;
    } while (!bool2);
    localObject = ((a)localObject).bPE.iterator();
    for (;;)
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      ((Iterator)localObject).next();
    }
  }
  
  public void setVoiceHelper(a parama)
  {
    AppMethodBeat.i(30927);
    this.XEg = parama;
    this.XEg.a(this);
    AppMethodBeat.o(30927);
  }
  
  public final class a
    extends MMHandler
  {
    boolean isPaused;
    int muX;
    float xDe;
    float xDf;
    int xDg;
    
    private a() {}
    
    public final void bgE()
    {
      AppMethodBeat.i(30916);
      this.muX = ((int)((1.0F - this.xDf / this.xDe) * (NoteVoiceView.f(NoteVoiceView.this).getWidth() - this.xDg)) + this.xDg);
      NoteVoiceView.a(NoteVoiceView.this).setText(m.Q(NoteVoiceView.this.getContext(), (int)(this.xDe - this.xDf)));
      NoteVoiceView.b(NoteVoiceView.this).setText(m.Q(NoteVoiceView.this.getContext(), (int)this.xDe));
      NoteVoiceView.d(NoteVoiceView.this).setWidth(this.muX);
      AppMethodBeat.o(30916);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(30918);
      this.xDf = Math.max(0.0F, this.xDf - 0.256F);
      bgE();
      if (this.xDf <= 0.1F)
      {
        AppMethodBeat.o(30918);
        return;
      }
      sendEmptyMessageDelayed(4096, 256L);
      AppMethodBeat.o(30918);
    }
    
    public final void hi(int paramInt)
    {
      AppMethodBeat.i(30914);
      this.isPaused = false;
      this.xDe = com.tencent.mm.plugin.fav.a.b.mA(paramInt);
      this.xDf = this.xDe;
      this.xDg = com.tencent.mm.cd.a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
      NoteVoiceView.a(NoteVoiceView.this).setText(m.Q(NoteVoiceView.this.getContext(), (int)(this.xDe - this.xDf)));
      NoteVoiceView.b(NoteVoiceView.this).setText(m.Q(NoteVoiceView.this.getContext(), (int)this.xDe));
      paramInt = (int)this.xDe / 60;
      int i = (int)this.xDe;
      NoteVoiceView.b(NoteVoiceView.this).setTag(R.h.tag_key_data, NoteVoiceView.b(NoteVoiceView.this).getContext().getString(R.l.gXY, new Object[] { String.valueOf(paramInt), String.valueOf(i % 60) }));
      NoteVoiceView.c(NoteVoiceView.this).setImageResource(R.k.voicepost_beginicon);
      NoteVoiceView.c(NoteVoiceView.this).setContentDescription(NoteVoiceView.this.getContext().getResources().getString(R.l.app_play) + NoteVoiceView.this.getContext().getResources().getString(R.l.gOX));
      NoteVoiceView.d(NoteVoiceView.this).setWidth(this.xDg);
      AppMethodBeat.o(30914);
    }
    
    public final void nX(boolean paramBoolean)
    {
      AppMethodBeat.i(30917);
      this.xDg = com.tencent.mm.cd.a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
      NoteVoiceView.c(NoteVoiceView.this).setImageResource(R.k.voicepost_beginicon);
      NoteVoiceView.c(NoteVoiceView.this).setContentDescription(NoteVoiceView.this.getContext().getResources().getString(R.l.app_play) + NoteVoiceView.this.getContext().getResources().getString(R.l.gOX));
      bgE();
      if (paramBoolean)
      {
        NoteVoiceView.c(NoteVoiceView.this).setImageResource(R.k.voicepost_pauseicon);
        NoteVoiceView.c(NoteVoiceView.this).setContentDescription(NoteVoiceView.this.getContext().getResources().getString(R.l.app_pause));
        sendEmptyMessage(4096);
      }
      AppMethodBeat.o(30917);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(30915);
      this.isPaused = false;
      removeMessages(4096);
      hi(NoteVoiceView.e(NoteVoiceView.this));
      AppMethodBeat.o(30915);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView
 * JD-Core Version:    0.7.0.1
 */