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
import com.tencent.mm.ak.k;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import java.util.Iterator;
import java.util.List;

public class NoteVoiceView
  extends FrameLayout
  implements a.a
{
  public a JLo;
  public a JLp;
  public int dLt;
  public int duration;
  public View maskView;
  public String path;
  private TextView qPt;
  private ViewGroup qUs;
  TextView qUt;
  private TextView qUv;
  private ImageButton tgc;
  
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
  
  private void cEG()
  {
    AppMethodBeat.i(30926);
    this.JLp.stop();
    this.qUt.setKeepScreenOn(false);
    AppMethodBeat.o(30926);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(30921);
    LayoutInflater.from(paramContext).inflate(2131495868, this, true);
    AppMethodBeat.o(30921);
  }
  
  public final void alV(String paramString)
  {
    AppMethodBeat.i(30922);
    if (!this.path.equals(paramString)) {
      cEG();
    }
    AppMethodBeat.o(30922);
  }
  
  public final void cEB()
  {
    AppMethodBeat.i(30923);
    cEG();
    AppMethodBeat.o(30923);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(30924);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.NoteVoiceView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.JLp.isPaused) });
    if (this.JLp.isPaused) {
      this.JLp.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30912);
          NoteVoiceView.g(NoteVoiceView.this).aED();
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
    this.qUs = ((ViewGroup)findViewById(2131309967));
    this.qPt = ((TextView)findViewById(2131309965));
    this.qUv = ((TextView)findViewById(2131309968));
    this.qUt = ((TextView)findViewById(2131309966));
    this.tgc = ((ImageButton)findViewById(2131309964));
    this.maskView = findViewById(2131310007);
    this.JLp = new a((byte)0);
    this.tgc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30913);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteVoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if ((com.tencent.mm.q.a.cC(paramAnonymousView.getContext())) || (com.tencent.mm.q.a.cA(paramAnonymousView.getContext())) || (com.tencent.mm.q.a.cE(paramAnonymousView.getContext())))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteVoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30913);
          return;
        }
        if ((!e.apn()) && (!Util.isNullOrNil(NoteVoiceView.h(NoteVoiceView.this))))
        {
          u.g(paramAnonymousView.getContext(), null);
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
        if (NoteVoiceView.i(NoteVoiceView.this).cEF())
        {
          paramAnonymousView = NoteVoiceView.this;
          Log.i("MicroMsg.NoteVoiceView", "pause play");
          localObject = paramAnonymousView.JLo;
          Log.i("MicroMsg.RecordVoiceHelper", "pause play");
          MMEntryLock.unlock("keep_app_silent");
          if (((a)localObject).qUl == null) {
            Log.w("MicroMsg.RecordVoiceHelper", "pause play error, player is null");
          }
          for (;;)
          {
            localObject = paramAnonymousView.JLp;
            ((NoteVoiceView.a)localObject).isPaused = true;
            ((NoteVoiceView.a)localObject).removeMessages(4096);
            NoteVoiceView.c(((NoteVoiceView.a)localObject).JLq).setImageResource(2131691719);
            NoteVoiceView.c(((NoteVoiceView.a)localObject).JLq).setContentDescription(((NoteVoiceView.a)localObject).JLq.getContext().getResources().getString(2131755942));
            paramAnonymousView.qUt.setKeepScreenOn(false);
            break;
            if (((a)localObject).qUl.pause())
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
        localObject = paramAnonymousView.JLo;
        Log.i("MicroMsg.RecordVoiceHelper", "resume play");
        MMEntryLock.lock("keep_app_silent");
        int i;
        if (((a)localObject).qUl == null)
        {
          Log.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
          i = 0;
        }
        boolean bool;
        do
        {
          localObject = paramAnonymousView.JLp;
          ((NoteVoiceView.a)localObject).isPaused = false;
          ((NoteVoiceView.a)localObject).sendEmptyMessage(4096);
          NoteVoiceView.c(((NoteVoiceView.a)localObject).JLq).setImageResource(2131691720);
          NoteVoiceView.c(((NoteVoiceView.a)localObject).JLq).setContentDescription(((NoteVoiceView.a)localObject).JLq.getContext().getResources().getString(2131755924));
          paramAnonymousView.qUt.setKeepScreenOn(true);
          if (i != 0) {
            break;
          }
          NoteVoiceView.j(NoteVoiceView.this);
          break;
          bool = ((a)localObject).qUl.resume();
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
    this.JLo = parama;
    this.JLo.a(this);
    AppMethodBeat.o(30927);
  }
  
  public final class a
    extends MMHandler
  {
    int hiI;
    boolean isPaused;
    float qUA;
    int qUB;
    float qUz;
    
    private a() {}
    
    @SuppressLint({"ResourceType"})
    public final void FD(int paramInt)
    {
      AppMethodBeat.i(30914);
      this.isPaused = false;
      this.qUz = com.tencent.mm.plugin.fav.a.b.DO(paramInt);
      this.qUA = this.qUz;
      this.qUB = com.tencent.mm.cb.a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
      NoteVoiceView.a(NoteVoiceView.this).setText(m.J(NoteVoiceView.this.getContext(), (int)(this.qUz - this.qUA)));
      NoteVoiceView.b(NoteVoiceView.this).setText(m.J(NoteVoiceView.this.getContext(), (int)this.qUz));
      NoteVoiceView.c(NoteVoiceView.this).setImageResource(2131691719);
      NoteVoiceView.c(NoteVoiceView.this).setContentDescription(NoteVoiceView.this.getContext().getResources().getString(2131755942));
      NoteVoiceView.d(NoteVoiceView.this).setWidth(this.qUB);
      AppMethodBeat.o(30914);
    }
    
    public final void aED()
    {
      AppMethodBeat.i(30916);
      this.hiI = ((int)((1.0F - this.qUA / this.qUz) * (NoteVoiceView.f(NoteVoiceView.this).getWidth() - this.qUB)) + this.qUB);
      NoteVoiceView.a(NoteVoiceView.this).setText(m.J(NoteVoiceView.this.getContext(), (int)(this.qUz - this.qUA)));
      NoteVoiceView.b(NoteVoiceView.this).setText(m.J(NoteVoiceView.this.getContext(), (int)this.qUz));
      NoteVoiceView.d(NoteVoiceView.this).setWidth(this.hiI);
      AppMethodBeat.o(30916);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(30918);
      this.qUA = Math.max(0.0F, this.qUA - 0.256F);
      aED();
      if (this.qUA <= 0.1F)
      {
        AppMethodBeat.o(30918);
        return;
      }
      sendEmptyMessageDelayed(4096, 256L);
      AppMethodBeat.o(30918);
    }
    
    @SuppressLint({"ResourceType"})
    public final void lp(boolean paramBoolean)
    {
      AppMethodBeat.i(30917);
      this.qUB = com.tencent.mm.cb.a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
      NoteVoiceView.c(NoteVoiceView.this).setImageResource(2131691719);
      NoteVoiceView.c(NoteVoiceView.this).setContentDescription(NoteVoiceView.this.getContext().getResources().getString(2131755942));
      aED();
      if (paramBoolean)
      {
        NoteVoiceView.c(NoteVoiceView.this).setImageResource(2131691720);
        NoteVoiceView.c(NoteVoiceView.this).setContentDescription(NoteVoiceView.this.getContext().getResources().getString(2131755924));
        sendEmptyMessage(4096);
      }
      AppMethodBeat.o(30917);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(30915);
      this.isPaused = false;
      removeMessages(4096);
      FD(NoteVoiceView.e(NoteVoiceView.this));
      AppMethodBeat.o(30915);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView
 * JD-Core Version:    0.7.0.1
 */