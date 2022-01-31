package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public class NoteVoiceView
  extends FrameLayout
  implements a.a
{
  public int cve;
  public int duration;
  public View jbK;
  private ViewGroup myk;
  TextView myl;
  private ImageButton mym;
  private TextView myn;
  public String path;
  private TextView vEm;
  public a vEn;
  public a vEo;
  
  public NoteVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27217);
    this.path = "";
    init(paramContext);
    AppMethodBeat.o(27217);
  }
  
  public NoteVoiceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27218);
    this.path = "";
    init(paramContext);
    AppMethodBeat.o(27218);
  }
  
  private void dka()
  {
    AppMethodBeat.i(27224);
    this.vEo.stop();
    this.myl.setKeepScreenOn(false);
    AppMethodBeat.o(27224);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(27219);
    LayoutInflater.from(paramContext).inflate(2130970374, this, true);
    AppMethodBeat.o(27219);
  }
  
  public final void akb(String paramString)
  {
    AppMethodBeat.i(27220);
    if (!this.path.equals(paramString)) {
      dka();
    }
    AppMethodBeat.o(27220);
  }
  
  public final void djY()
  {
    AppMethodBeat.i(27221);
    dka();
    AppMethodBeat.o(27221);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(27222);
    super.onConfigurationChanged(paramConfiguration);
    ab.i("MicroMsg.NoteVoiceView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.vEo.isPaused) });
    if (this.vEo.isPaused) {
      this.vEo.postDelayed(new NoteVoiceView.1(this), 128L);
    }
    AppMethodBeat.o(27222);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(27223);
    super.onFinishInflate();
    this.myk = ((ViewGroup)findViewById(2131824125));
    this.myn = ((TextView)findViewById(2131824124));
    this.vEm = ((TextView)findViewById(2131824127));
    this.myl = ((TextView)findViewById(2131824126));
    this.mym = ((ImageButton)findViewById(2131824123));
    this.jbK = findViewById(2131826616);
    this.vEo = new a((byte)0);
    this.mym.setOnClickListener(new NoteVoiceView.2(this));
    AppMethodBeat.o(27223);
  }
  
  public void setVoiceHelper(a parama)
  {
    AppMethodBeat.i(27225);
    this.vEn = parama;
    this.vEn.a(this);
    AppMethodBeat.o(27225);
  }
  
  public final class a
    extends ak
  {
    boolean isPaused;
    float myq;
    float myr;
    int mys;
    int myt;
    
    private a() {}
    
    public final void Vf()
    {
      AppMethodBeat.i(27214);
      this.mys = ((int)((1.0F - this.myr / this.myq) * (NoteVoiceView.f(NoteVoiceView.this).getWidth() - this.myt)) + this.myt);
      NoteVoiceView.a(NoteVoiceView.this).setText(j.C(NoteVoiceView.this.getContext(), (int)(this.myq - this.myr)));
      NoteVoiceView.b(NoteVoiceView.this).setText(j.C(NoteVoiceView.this.getContext(), (int)this.myq));
      NoteVoiceView.d(NoteVoiceView.this).setWidth(this.mys);
      AppMethodBeat.o(27214);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(27216);
      this.myr = Math.max(0.0F, this.myr - 0.256F);
      Vf();
      if (this.myr <= 0.1F)
      {
        AppMethodBeat.o(27216);
        return;
      }
      sendEmptyMessageDelayed(4096, 256L);
      AppMethodBeat.o(27216);
    }
    
    @SuppressLint({"ResourceType"})
    public final void oV(boolean paramBoolean)
    {
      AppMethodBeat.i(27215);
      this.myt = com.tencent.mm.cb.a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
      NoteVoiceView.c(NoteVoiceView.this).setImageResource(2131232175);
      NoteVoiceView.c(NoteVoiceView.this).setContentDescription(NoteVoiceView.this.getContext().getResources().getString(2131297039));
      Vf();
      if (paramBoolean)
      {
        NoteVoiceView.c(NoteVoiceView.this).setImageResource(2131232176);
        NoteVoiceView.c(NoteVoiceView.this).setContentDescription(NoteVoiceView.this.getContext().getResources().getString(2131297021));
        sendEmptyMessage(4096);
      }
      AppMethodBeat.o(27215);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(27213);
      this.isPaused = false;
      removeMessages(4096);
      vY(NoteVoiceView.e(NoteVoiceView.this));
      AppMethodBeat.o(27213);
    }
    
    @SuppressLint({"ResourceType"})
    public final void vY(int paramInt)
    {
      AppMethodBeat.i(27212);
      this.isPaused = false;
      this.myq = b.jR(paramInt);
      this.myr = this.myq;
      this.myt = com.tencent.mm.cb.a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
      NoteVoiceView.a(NoteVoiceView.this).setText(j.C(NoteVoiceView.this.getContext(), (int)(this.myq - this.myr)));
      NoteVoiceView.b(NoteVoiceView.this).setText(j.C(NoteVoiceView.this.getContext(), (int)this.myq));
      NoteVoiceView.c(NoteVoiceView.this).setImageResource(2131232175);
      NoteVoiceView.c(NoteVoiceView.this).setContentDescription(NoteVoiceView.this.getContext().getResources().getString(2131297039));
      NoteVoiceView.d(NoteVoiceView.this).setWidth(this.myt);
      AppMethodBeat.o(27212);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView
 * JD-Core Version:    0.7.0.1
 */