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
import com.tencent.mm.al.i;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.List;

public class NoteVoiceView
  extends FrameLayout
  implements a.a
{
  public a BGV;
  public a BGW;
  public int dkj;
  public int duration;
  public View lRB;
  private TextView omo;
  private ViewGroup orn;
  TextView oro;
  private TextView orq;
  public String path;
  private ImageButton qfK;
  
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
  
  private void bTL()
  {
    AppMethodBeat.i(30926);
    this.BGW.stop();
    this.oro.setKeepScreenOn(false);
    AppMethodBeat.o(30926);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(30921);
    LayoutInflater.from(paramContext).inflate(2131495036, this, true);
    AppMethodBeat.o(30921);
  }
  
  public final void Tf(String paramString)
  {
    AppMethodBeat.i(30922);
    if (!this.path.equals(paramString)) {
      bTL();
    }
    AppMethodBeat.o(30922);
  }
  
  public final void bTG()
  {
    AppMethodBeat.i(30923);
    bTL();
    AppMethodBeat.o(30923);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(30924);
    super.onConfigurationChanged(paramConfiguration);
    ad.i("MicroMsg.NoteVoiceView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.BGW.isPaused) });
    if (this.BGW.isPaused) {
      this.BGW.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30912);
          NoteVoiceView.g(NoteVoiceView.this).akk();
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
    this.orn = ((ViewGroup)findViewById(2131306507));
    this.omo = ((TextView)findViewById(2131306505));
    this.orq = ((TextView)findViewById(2131306508));
    this.oro = ((TextView)findViewById(2131306506));
    this.qfK = ((ImageButton)findViewById(2131306504));
    this.lRB = findViewById(2131306547);
    this.BGW = new a((byte)0);
    this.qfK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30913);
        if ((com.tencent.mm.r.a.ce(paramAnonymousView.getContext())) || (com.tencent.mm.r.a.cc(paramAnonymousView.getContext())))
        {
          AppMethodBeat.o(30913);
          return;
        }
        if ((!e.XG()) && (!bt.isNullOrNil(NoteVoiceView.h(NoteVoiceView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          AppMethodBeat.o(30913);
          return;
        }
        if (!bt.by(NoteVoiceView.h(NoteVoiceView.this), "").equals(NoteVoiceView.i(NoteVoiceView.this).path))
        {
          NoteVoiceView.j(NoteVoiceView.this);
          AppMethodBeat.o(30913);
          return;
        }
        if (NoteVoiceView.i(NoteVoiceView.this).bTK())
        {
          paramAnonymousView = NoteVoiceView.this;
          ad.i("MicroMsg.NoteVoiceView", "pause play");
          localObject = paramAnonymousView.BGV;
          ad.i("MicroMsg.RecordVoiceHelper", "pause play");
          an.aFy("keep_app_silent");
          if (((a)localObject).org == null) {
            ad.w("MicroMsg.RecordVoiceHelper", "pause play error, player is null");
          }
          for (;;)
          {
            localObject = paramAnonymousView.BGW;
            ((NoteVoiceView.a)localObject).isPaused = true;
            ((NoteVoiceView.a)localObject).removeMessages(4096);
            NoteVoiceView.c(((NoteVoiceView.a)localObject).BGX).setImageResource(2131691385);
            NoteVoiceView.c(((NoteVoiceView.a)localObject).BGX).setContentDescription(((NoteVoiceView.a)localObject).BGX.getContext().getResources().getString(2131755856));
            paramAnonymousView.oro.setKeepScreenOn(false);
            AppMethodBeat.o(30913);
            return;
            if (((a)localObject).org.pause())
            {
              localObject = ((a)localObject).callbacks.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((Iterator)localObject).next();
              }
            }
          }
        }
        paramAnonymousView = NoteVoiceView.this;
        ad.i("MicroMsg.NoteVoiceView", "resume play");
        Object localObject = paramAnonymousView.BGV;
        ad.i("MicroMsg.RecordVoiceHelper", "resume play");
        an.aFx("keep_app_silent");
        int i;
        if (((a)localObject).org == null)
        {
          ad.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
          i = 0;
        }
        boolean bool;
        do
        {
          localObject = paramAnonymousView.BGW;
          ((NoteVoiceView.a)localObject).isPaused = false;
          ((NoteVoiceView.a)localObject).sendEmptyMessage(4096);
          NoteVoiceView.c(((NoteVoiceView.a)localObject).BGX).setImageResource(2131691386);
          NoteVoiceView.c(((NoteVoiceView.a)localObject).BGX).setContentDescription(((NoteVoiceView.a)localObject).BGX.getContext().getResources().getString(2131755838));
          paramAnonymousView.oro.setKeepScreenOn(true);
          if (i == 0) {
            NoteVoiceView.j(NoteVoiceView.this);
          }
          AppMethodBeat.o(30913);
          return;
          bool = ((a)localObject).org.resume();
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
    this.BGV = parama;
    this.BGV.a(this);
    AppMethodBeat.o(30927);
  }
  
  public final class a
    extends ap
  {
    int fVV;
    boolean isPaused;
    float oru;
    float orv;
    int orw;
    
    private a() {}
    
    @SuppressLint({"ResourceType"})
    public final void Ah(int paramInt)
    {
      AppMethodBeat.i(30914);
      this.isPaused = false;
      this.oru = b.pI(paramInt);
      this.orv = this.oru;
      this.orw = com.tencent.mm.cd.a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
      NoteVoiceView.a(NoteVoiceView.this).setText(m.C(NoteVoiceView.this.getContext(), (int)(this.oru - this.orv)));
      NoteVoiceView.b(NoteVoiceView.this).setText(m.C(NoteVoiceView.this.getContext(), (int)this.oru));
      NoteVoiceView.c(NoteVoiceView.this).setImageResource(2131691385);
      NoteVoiceView.c(NoteVoiceView.this).setContentDescription(NoteVoiceView.this.getContext().getResources().getString(2131755856));
      NoteVoiceView.d(NoteVoiceView.this).setWidth(this.orw);
      AppMethodBeat.o(30914);
    }
    
    public final void akk()
    {
      AppMethodBeat.i(30916);
      this.fVV = ((int)((1.0F - this.orv / this.oru) * (NoteVoiceView.f(NoteVoiceView.this).getWidth() - this.orw)) + this.orw);
      NoteVoiceView.a(NoteVoiceView.this).setText(m.C(NoteVoiceView.this.getContext(), (int)(this.oru - this.orv)));
      NoteVoiceView.b(NoteVoiceView.this).setText(m.C(NoteVoiceView.this.getContext(), (int)this.oru));
      NoteVoiceView.d(NoteVoiceView.this).setWidth(this.fVV);
      AppMethodBeat.o(30916);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(30918);
      this.orv = Math.max(0.0F, this.orv - 0.256F);
      akk();
      if (this.orv <= 0.1F)
      {
        AppMethodBeat.o(30918);
        return;
      }
      sendEmptyMessageDelayed(4096, 256L);
      AppMethodBeat.o(30918);
    }
    
    @SuppressLint({"ResourceType"})
    public final void jA(boolean paramBoolean)
    {
      AppMethodBeat.i(30917);
      this.orw = com.tencent.mm.cd.a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
      NoteVoiceView.c(NoteVoiceView.this).setImageResource(2131691385);
      NoteVoiceView.c(NoteVoiceView.this).setContentDescription(NoteVoiceView.this.getContext().getResources().getString(2131755856));
      akk();
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
      Ah(NoteVoiceView.e(NoteVoiceView.this));
      AppMethodBeat.o(30915);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView
 * JD-Core Version:    0.7.0.1
 */