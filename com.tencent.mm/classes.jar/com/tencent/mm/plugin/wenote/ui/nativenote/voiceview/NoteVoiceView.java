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
import com.tencent.mm.ak.h;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.List;

public class NoteVoiceView
  extends FrameLayout
  implements a.a
{
  public a EVu;
  public a EVv;
  public int dui;
  public int duration;
  public View hcH;
  private TextView pAc;
  private ViewGroup pFb;
  TextView pFc;
  private TextView pFe;
  public String path;
  private ImageButton rGw;
  
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
  
  private void cgT()
  {
    AppMethodBeat.i(30926);
    this.EVv.stop();
    this.pFc.setKeepScreenOn(false);
    AppMethodBeat.o(30926);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(30921);
    LayoutInflater.from(paramContext).inflate(2131495036, this, true);
    AppMethodBeat.o(30921);
  }
  
  public final void abP(String paramString)
  {
    AppMethodBeat.i(30922);
    if (!this.path.equals(paramString)) {
      cgT();
    }
    AppMethodBeat.o(30922);
  }
  
  public final void cgO()
  {
    AppMethodBeat.i(30923);
    cgT();
    AppMethodBeat.o(30923);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(30924);
    super.onConfigurationChanged(paramConfiguration);
    ae.i("MicroMsg.NoteVoiceView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.EVv.isPaused) });
    if (this.EVv.isPaused) {
      this.EVv.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30912);
          NoteVoiceView.g(NoteVoiceView.this).amH();
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
    this.pFb = ((ViewGroup)findViewById(2131306507));
    this.pAc = ((TextView)findViewById(2131306505));
    this.pFe = ((TextView)findViewById(2131306508));
    this.pFc = ((TextView)findViewById(2131306506));
    this.rGw = ((ImageButton)findViewById(2131306504));
    this.hcH = findViewById(2131306547);
    this.EVv = new a((byte)0);
    this.rGw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30913);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteVoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if ((com.tencent.mm.r.a.ch(paramAnonymousView.getContext())) || (com.tencent.mm.r.a.cf(paramAnonymousView.getContext())) || (com.tencent.mm.r.a.cj(paramAnonymousView.getContext())))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteVoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30913);
          return;
        }
        if ((!e.abo()) && (!bu.isNullOrNil(NoteVoiceView.h(NoteVoiceView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteVoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30913);
          return;
        }
        if (!bu.bI(NoteVoiceView.h(NoteVoiceView.this), "").equals(NoteVoiceView.i(NoteVoiceView.this).path))
        {
          NoteVoiceView.j(NoteVoiceView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteVoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30913);
          return;
        }
        if (NoteVoiceView.i(NoteVoiceView.this).cgS())
        {
          paramAnonymousView = NoteVoiceView.this;
          ae.i("MicroMsg.NoteVoiceView", "pause play");
          localObject = paramAnonymousView.EVu;
          ae.i("MicroMsg.RecordVoiceHelper", "pause play");
          ao.aRS("keep_app_silent");
          if (((a)localObject).pEU == null) {
            ae.w("MicroMsg.RecordVoiceHelper", "pause play error, player is null");
          }
          for (;;)
          {
            localObject = paramAnonymousView.EVv;
            ((NoteVoiceView.a)localObject).isPaused = true;
            ((NoteVoiceView.a)localObject).removeMessages(4096);
            NoteVoiceView.c(((NoteVoiceView.a)localObject).EVw).setImageResource(2131691385);
            NoteVoiceView.c(((NoteVoiceView.a)localObject).EVw).setContentDescription(((NoteVoiceView.a)localObject).EVw.getContext().getResources().getString(2131755856));
            paramAnonymousView.pFc.setKeepScreenOn(false);
            break;
            if (((a)localObject).pEU.pause())
            {
              localObject = ((a)localObject).callbacks.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((Iterator)localObject).next();
              }
            }
          }
        }
        paramAnonymousView = NoteVoiceView.this;
        ae.i("MicroMsg.NoteVoiceView", "resume play");
        localObject = paramAnonymousView.EVu;
        ae.i("MicroMsg.RecordVoiceHelper", "resume play");
        ao.aRR("keep_app_silent");
        int i;
        if (((a)localObject).pEU == null)
        {
          ae.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
          i = 0;
        }
        boolean bool;
        do
        {
          localObject = paramAnonymousView.EVv;
          ((NoteVoiceView.a)localObject).isPaused = false;
          ((NoteVoiceView.a)localObject).sendEmptyMessage(4096);
          NoteVoiceView.c(((NoteVoiceView.a)localObject).EVw).setImageResource(2131691386);
          NoteVoiceView.c(((NoteVoiceView.a)localObject).EVw).setContentDescription(((NoteVoiceView.a)localObject).EVw.getContext().getResources().getString(2131755838));
          paramAnonymousView.pFc.setKeepScreenOn(true);
          if (i != 0) {
            break;
          }
          NoteVoiceView.j(NoteVoiceView.this);
          break;
          bool = ((a)localObject).pEU.resume();
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
    this.EVu = parama;
    this.EVu.a(this);
    AppMethodBeat.o(30927);
  }
  
  public final class a
    extends aq
  {
    int gvT;
    boolean isPaused;
    float pFi;
    float pFj;
    int pFk;
    
    private a() {}
    
    @SuppressLint({"ResourceType"})
    public final void BT(int paramInt)
    {
      AppMethodBeat.i(30914);
      this.isPaused = false;
      this.pFi = com.tencent.mm.plugin.fav.a.b.vK(paramInt);
      this.pFj = this.pFi;
      this.pFk = com.tencent.mm.cb.a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
      NoteVoiceView.a(NoteVoiceView.this).setText(m.G(NoteVoiceView.this.getContext(), (int)(this.pFi - this.pFj)));
      NoteVoiceView.b(NoteVoiceView.this).setText(m.G(NoteVoiceView.this.getContext(), (int)this.pFi));
      NoteVoiceView.c(NoteVoiceView.this).setImageResource(2131691385);
      NoteVoiceView.c(NoteVoiceView.this).setContentDescription(NoteVoiceView.this.getContext().getResources().getString(2131755856));
      NoteVoiceView.d(NoteVoiceView.this).setWidth(this.pFk);
      AppMethodBeat.o(30914);
    }
    
    public final void amH()
    {
      AppMethodBeat.i(30916);
      this.gvT = ((int)((1.0F - this.pFj / this.pFi) * (NoteVoiceView.f(NoteVoiceView.this).getWidth() - this.pFk)) + this.pFk);
      NoteVoiceView.a(NoteVoiceView.this).setText(m.G(NoteVoiceView.this.getContext(), (int)(this.pFi - this.pFj)));
      NoteVoiceView.b(NoteVoiceView.this).setText(m.G(NoteVoiceView.this.getContext(), (int)this.pFi));
      NoteVoiceView.d(NoteVoiceView.this).setWidth(this.gvT);
      AppMethodBeat.o(30916);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(30918);
      this.pFj = Math.max(0.0F, this.pFj - 0.256F);
      amH();
      if (this.pFj <= 0.1F)
      {
        AppMethodBeat.o(30918);
        return;
      }
      sendEmptyMessageDelayed(4096, 256L);
      AppMethodBeat.o(30918);
    }
    
    @SuppressLint({"ResourceType"})
    public final void kn(boolean paramBoolean)
    {
      AppMethodBeat.i(30917);
      this.pFk = com.tencent.mm.cb.a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
      NoteVoiceView.c(NoteVoiceView.this).setImageResource(2131691385);
      NoteVoiceView.c(NoteVoiceView.this).setContentDescription(NoteVoiceView.this.getContext().getResources().getString(2131755856));
      amH();
      if (paramBoolean)
      {
        NoteVoiceView.c(NoteVoiceView.this).setImageResource(2131691386);
        NoteVoiceView.c(NoteVoiceView.this).setContentDescription(NoteVoiceView.this.getContext().getResources().getString(2131755838));
        sendEmptyMessage(4096);
      }
      AppMethodBeat.o(30917);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(30915);
      this.isPaused = false;
      removeMessages(4096);
      BT(NoteVoiceView.e(NoteVoiceView.this));
      AppMethodBeat.o(30915);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView
 * JD-Core Version:    0.7.0.1
 */