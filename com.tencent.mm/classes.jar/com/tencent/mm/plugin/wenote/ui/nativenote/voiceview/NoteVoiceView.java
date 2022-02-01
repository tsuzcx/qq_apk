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
import com.tencent.mm.ak.i;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.List;

public class NoteVoiceView
  extends FrameLayout
  implements a.a
{
  public a CZc;
  public a CZd;
  public int dhE;
  public int duration;
  public View gGk;
  private TextView oPO;
  private ViewGroup oUN;
  TextView oUO;
  private TextView oUQ;
  public String path;
  private ImageButton qOm;
  
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
  
  private void caZ()
  {
    AppMethodBeat.i(30926);
    this.CZd.stop();
    this.oUO.setKeepScreenOn(false);
    AppMethodBeat.o(30926);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(30921);
    LayoutInflater.from(paramContext).inflate(2131495036, this, true);
    AppMethodBeat.o(30921);
  }
  
  public final void Xr(String paramString)
  {
    AppMethodBeat.i(30922);
    if (!this.path.equals(paramString)) {
      caZ();
    }
    AppMethodBeat.o(30922);
  }
  
  public final void caU()
  {
    AppMethodBeat.i(30923);
    caZ();
    AppMethodBeat.o(30923);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(30924);
    super.onConfigurationChanged(paramConfiguration);
    ac.i("MicroMsg.NoteVoiceView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.CZd.isPaused) });
    if (this.CZd.isPaused) {
      this.CZd.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30912);
          NoteVoiceView.g(NoteVoiceView.this).ajG();
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
    this.oUN = ((ViewGroup)findViewById(2131306507));
    this.oPO = ((TextView)findViewById(2131306505));
    this.oUQ = ((TextView)findViewById(2131306508));
    this.oUO = ((TextView)findViewById(2131306506));
    this.qOm = ((ImageButton)findViewById(2131306504));
    this.gGk = findViewById(2131306547);
    this.CZd = new a((byte)0);
    this.qOm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30913);
        if ((com.tencent.mm.r.a.ci(paramAnonymousView.getContext())) || (com.tencent.mm.r.a.cf(paramAnonymousView.getContext())) || (com.tencent.mm.r.a.ck(paramAnonymousView.getContext())))
        {
          AppMethodBeat.o(30913);
          return;
        }
        if ((!e.YD()) && (!bs.isNullOrNil(NoteVoiceView.h(NoteVoiceView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          AppMethodBeat.o(30913);
          return;
        }
        if (!bs.bG(NoteVoiceView.h(NoteVoiceView.this), "").equals(NoteVoiceView.i(NoteVoiceView.this).path))
        {
          NoteVoiceView.j(NoteVoiceView.this);
          AppMethodBeat.o(30913);
          return;
        }
        if (NoteVoiceView.i(NoteVoiceView.this).caY())
        {
          paramAnonymousView = NoteVoiceView.this;
          ac.i("MicroMsg.NoteVoiceView", "pause play");
          localObject = paramAnonymousView.CZc;
          ac.i("MicroMsg.RecordVoiceHelper", "pause play");
          am.aKP("keep_app_silent");
          if (((a)localObject).oUG == null) {
            ac.w("MicroMsg.RecordVoiceHelper", "pause play error, player is null");
          }
          for (;;)
          {
            localObject = paramAnonymousView.CZd;
            ((NoteVoiceView.a)localObject).isPaused = true;
            ((NoteVoiceView.a)localObject).removeMessages(4096);
            NoteVoiceView.c(((NoteVoiceView.a)localObject).CZe).setImageResource(2131691385);
            NoteVoiceView.c(((NoteVoiceView.a)localObject).CZe).setContentDescription(((NoteVoiceView.a)localObject).CZe.getContext().getResources().getString(2131755856));
            paramAnonymousView.oUO.setKeepScreenOn(false);
            AppMethodBeat.o(30913);
            return;
            if (((a)localObject).oUG.pause())
            {
              localObject = ((a)localObject).callbacks.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((Iterator)localObject).next();
              }
            }
          }
        }
        paramAnonymousView = NoteVoiceView.this;
        ac.i("MicroMsg.NoteVoiceView", "resume play");
        Object localObject = paramAnonymousView.CZc;
        ac.i("MicroMsg.RecordVoiceHelper", "resume play");
        am.aKO("keep_app_silent");
        int i;
        if (((a)localObject).oUG == null)
        {
          ac.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
          i = 0;
        }
        boolean bool;
        do
        {
          localObject = paramAnonymousView.CZd;
          ((NoteVoiceView.a)localObject).isPaused = false;
          ((NoteVoiceView.a)localObject).sendEmptyMessage(4096);
          NoteVoiceView.c(((NoteVoiceView.a)localObject).CZe).setImageResource(2131691386);
          NoteVoiceView.c(((NoteVoiceView.a)localObject).CZe).setContentDescription(((NoteVoiceView.a)localObject).CZe.getContext().getResources().getString(2131755838));
          paramAnonymousView.oUO.setKeepScreenOn(true);
          if (i == 0) {
            NoteVoiceView.j(NoteVoiceView.this);
          }
          AppMethodBeat.o(30913);
          return;
          bool = ((a)localObject).oUG.resume();
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
    this.CZc = parama;
    this.CZc.a(this);
    AppMethodBeat.o(30927);
  }
  
  public final class a
    extends ao
  {
    int fZQ;
    boolean isPaused;
    float oUU;
    float oUV;
    int oUW;
    
    private a() {}
    
    @SuppressLint({"ResourceType"})
    public final void AZ(int paramInt)
    {
      AppMethodBeat.i(30914);
      this.isPaused = false;
      this.oUU = b.tx(paramInt);
      this.oUV = this.oUU;
      this.oUW = com.tencent.mm.cc.a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
      NoteVoiceView.a(NoteVoiceView.this).setText(m.F(NoteVoiceView.this.getContext(), (int)(this.oUU - this.oUV)));
      NoteVoiceView.b(NoteVoiceView.this).setText(m.F(NoteVoiceView.this.getContext(), (int)this.oUU));
      NoteVoiceView.c(NoteVoiceView.this).setImageResource(2131691385);
      NoteVoiceView.c(NoteVoiceView.this).setContentDescription(NoteVoiceView.this.getContext().getResources().getString(2131755856));
      NoteVoiceView.d(NoteVoiceView.this).setWidth(this.oUW);
      AppMethodBeat.o(30914);
    }
    
    public final void ajG()
    {
      AppMethodBeat.i(30916);
      this.fZQ = ((int)((1.0F - this.oUV / this.oUU) * (NoteVoiceView.f(NoteVoiceView.this).getWidth() - this.oUW)) + this.oUW);
      NoteVoiceView.a(NoteVoiceView.this).setText(m.F(NoteVoiceView.this.getContext(), (int)(this.oUU - this.oUV)));
      NoteVoiceView.b(NoteVoiceView.this).setText(m.F(NoteVoiceView.this.getContext(), (int)this.oUU));
      NoteVoiceView.d(NoteVoiceView.this).setWidth(this.fZQ);
      AppMethodBeat.o(30916);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(30918);
      this.oUV = Math.max(0.0F, this.oUV - 0.256F);
      ajG();
      if (this.oUV <= 0.1F)
      {
        AppMethodBeat.o(30918);
        return;
      }
      sendEmptyMessageDelayed(4096, 256L);
      AppMethodBeat.o(30918);
    }
    
    @SuppressLint({"ResourceType"})
    public final void kd(boolean paramBoolean)
    {
      AppMethodBeat.i(30917);
      this.oUW = com.tencent.mm.cc.a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
      NoteVoiceView.c(NoteVoiceView.this).setImageResource(2131691385);
      NoteVoiceView.c(NoteVoiceView.this).setContentDescription(NoteVoiceView.this.getContext().getResources().getString(2131755856));
      ajG();
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
      AZ(NoteVoiceView.e(NoteVoiceView.this));
      AppMethodBeat.o(30915);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView
 * JD-Core Version:    0.7.0.1
 */