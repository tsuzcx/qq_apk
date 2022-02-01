package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import android.annotation.SuppressLint;
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
import com.tencent.mm.an.k;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import java.util.Iterator;
import java.util.List;

public class NoteVoiceView
  extends FrameLayout
  implements a.a
{
  public a QKH;
  public a QKI;
  public int duration;
  public int fEi;
  public View maskView;
  public String path;
  private TextView urz;
  private TextView uwB;
  private ViewGroup uwy;
  TextView uwz;
  private ImageButton wMr;
  
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
  
  private void cTm()
  {
    AppMethodBeat.i(30926);
    this.QKI.stop();
    this.uwz.setKeepScreenOn(false);
    AppMethodBeat.o(30926);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(30921);
    LayoutInflater.from(paramContext).inflate(R.i.ejI, this, true);
    AppMethodBeat.o(30921);
  }
  
  public final void atP(String paramString)
  {
    AppMethodBeat.i(30922);
    if (!this.path.equals(paramString)) {
      cTm();
    }
    AppMethodBeat.o(30922);
  }
  
  public final void cTh()
  {
    AppMethodBeat.i(30923);
    cTm();
    AppMethodBeat.o(30923);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(30924);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.NoteVoiceView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.QKI.isPaused) });
    if (this.QKI.isPaused) {
      this.QKI.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30912);
          NoteVoiceView.g(NoteVoiceView.this).aMU();
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
    this.uwy = ((ViewGroup)findViewById(R.h.voice_player_progress_bg));
    this.urz = ((TextView)findViewById(R.h.voice_player_length));
    this.uwB = ((TextView)findViewById(R.h.voice_player_total_length));
    this.uwz = ((TextView)findViewById(R.h.voice_player_progress));
    this.wMr = ((ImageButton)findViewById(R.h.voice_player_btn));
    this.maskView = findViewById(R.h.eas);
    this.QKI = new a((byte)0);
    this.wMr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30913);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteVoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if ((com.tencent.mm.q.a.cy(paramAnonymousView.getContext())) || (com.tencent.mm.q.a.cw(paramAnonymousView.getContext())) || (com.tencent.mm.q.a.cB(paramAnonymousView.getContext())))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteVoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30913);
          return;
        }
        if ((!e.avA()) && (!Util.isNullOrNil(NoteVoiceView.h(NoteVoiceView.this))))
        {
          w.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteVoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30913);
          return;
        }
        if (!Util.nullAs(NoteVoiceView.h(NoteVoiceView.this), "").equals(NoteVoiceView.i(NoteVoiceView.this).path))
        {
          NoteVoiceView.j(NoteVoiceView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteVoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30913);
          return;
        }
        if (NoteVoiceView.i(NoteVoiceView.this).cTl())
        {
          paramAnonymousView = NoteVoiceView.this;
          Log.i("MicroMsg.NoteVoiceView", "pause play");
          localObject = paramAnonymousView.QKH;
          Log.i("MicroMsg.RecordVoiceHelper", "pause play");
          MMEntryLock.unlock("keep_app_silent");
          if (((a)localObject).uwr == null) {
            Log.w("MicroMsg.RecordVoiceHelper", "pause play error, player is null");
          }
          for (;;)
          {
            localObject = paramAnonymousView.QKI;
            ((NoteVoiceView.a)localObject).isPaused = true;
            ((NoteVoiceView.a)localObject).removeMessages(4096);
            NoteVoiceView.c(((NoteVoiceView.a)localObject).QKJ).setImageResource(R.k.voicepost_beginicon);
            NoteVoiceView.c(((NoteVoiceView.a)localObject).QKJ).setContentDescription(((NoteVoiceView.a)localObject).QKJ.getContext().getResources().getString(R.l.app_play));
            paramAnonymousView.uwz.setKeepScreenOn(false);
            break;
            if (((a)localObject).uwr.pause())
            {
              localObject = ((a)localObject).callbacks.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((Iterator)localObject).next();
              }
            }
          }
        }
        paramAnonymousView = NoteVoiceView.this;
        Log.i("MicroMsg.NoteVoiceView", "resume play");
        localObject = paramAnonymousView.QKH;
        Log.i("MicroMsg.RecordVoiceHelper", "resume play");
        MMEntryLock.lock("keep_app_silent");
        int i;
        if (((a)localObject).uwr == null)
        {
          Log.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
          i = 0;
        }
        boolean bool;
        do
        {
          localObject = paramAnonymousView.QKI;
          ((NoteVoiceView.a)localObject).isPaused = false;
          ((NoteVoiceView.a)localObject).sendEmptyMessage(4096);
          NoteVoiceView.c(((NoteVoiceView.a)localObject).QKJ).setImageResource(R.k.voicepost_pauseicon);
          NoteVoiceView.c(((NoteVoiceView.a)localObject).QKJ).setContentDescription(((NoteVoiceView.a)localObject).QKJ.getContext().getResources().getString(R.l.app_pause));
          paramAnonymousView.uwz.setKeepScreenOn(true);
          if (i != 0) {
            break;
          }
          NoteVoiceView.j(NoteVoiceView.this);
          break;
          bool = ((a)localObject).uwr.resume();
          i = bool;
        } while (!bool);
        localObject = ((a)localObject).callbacks.iterator();
        for (;;)
        {
          i = bool;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          ((Iterator)localObject).next();
        }
      }
    });
    AppMethodBeat.o(30925);
  }
  
  public void setVoiceHelper(a parama)
  {
    AppMethodBeat.i(30927);
    this.QKH = parama;
    this.QKH.a(this);
    AppMethodBeat.o(30927);
  }
  
  public final class a
    extends MMHandler
  {
    boolean isPaused;
    int jUG;
    float uwF;
    float uwG;
    int uwH;
    
    private a() {}
    
    @SuppressLint({"ResourceType"})
    public final void Jl(int paramInt)
    {
      AppMethodBeat.i(30914);
      this.isPaused = false;
      this.uwF = com.tencent.mm.plugin.fav.a.b.Kc(paramInt);
      this.uwG = this.uwF;
      this.uwH = com.tencent.mm.ci.a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
      NoteVoiceView.a(NoteVoiceView.this).setText(m.N(NoteVoiceView.this.getContext(), (int)(this.uwF - this.uwG)));
      NoteVoiceView.b(NoteVoiceView.this).setText(m.N(NoteVoiceView.this.getContext(), (int)this.uwF));
      NoteVoiceView.c(NoteVoiceView.this).setImageResource(R.k.voicepost_beginicon);
      NoteVoiceView.c(NoteVoiceView.this).setContentDescription(NoteVoiceView.this.getContext().getResources().getString(R.l.app_play));
      NoteVoiceView.d(NoteVoiceView.this).setWidth(this.uwH);
      AppMethodBeat.o(30914);
    }
    
    public final void aMU()
    {
      AppMethodBeat.i(30916);
      this.jUG = ((int)((1.0F - this.uwG / this.uwF) * (NoteVoiceView.f(NoteVoiceView.this).getWidth() - this.uwH)) + this.uwH);
      NoteVoiceView.a(NoteVoiceView.this).setText(m.N(NoteVoiceView.this.getContext(), (int)(this.uwF - this.uwG)));
      NoteVoiceView.b(NoteVoiceView.this).setText(m.N(NoteVoiceView.this.getContext(), (int)this.uwF));
      NoteVoiceView.d(NoteVoiceView.this).setWidth(this.jUG);
      AppMethodBeat.o(30916);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(30918);
      this.uwG = Math.max(0.0F, this.uwG - 0.256F);
      aMU();
      if (this.uwG <= 0.1F)
      {
        AppMethodBeat.o(30918);
        return;
      }
      sendEmptyMessageDelayed(4096, 256L);
      AppMethodBeat.o(30918);
    }
    
    @SuppressLint({"ResourceType"})
    public final void mB(boolean paramBoolean)
    {
      AppMethodBeat.i(30917);
      this.uwH = com.tencent.mm.ci.a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
      NoteVoiceView.c(NoteVoiceView.this).setImageResource(R.k.voicepost_beginicon);
      NoteVoiceView.c(NoteVoiceView.this).setContentDescription(NoteVoiceView.this.getContext().getResources().getString(R.l.app_play));
      aMU();
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
      Jl(NoteVoiceView.e(NoteVoiceView.this));
      AppMethodBeat.o(30915);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView
 * JD-Core Version:    0.7.0.1
 */