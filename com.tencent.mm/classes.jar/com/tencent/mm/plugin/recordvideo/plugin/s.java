package com.tencent.mm.plugin.recordvideo.plugin;

import a.f.b.j;
import a.l;
import android.os.Looper;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.sdk.platformtools.ak;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/widget/RelativeLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureHint", "Landroid/widget/TextView;", "enablePicture", "", "hideHintRunnable", "Ljava/lang/Runnable;", "lastTakePictureTime", "", "getLayout", "()Landroid/widget/RelativeLayout;", "setLayout", "(Landroid/widget/RelativeLayout;)V", "maxRecordTimeMS", "", "recordButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "takePictureMinInterval", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "recordTimeNotEnough", "reset", "setEnablePicture", "showHint", "strRes", "showProcessBar", "showRecordShortHint", "showRecordTipHint", "plugin-recordvideo_release"})
public final class s
  implements q
{
  public final ak faV;
  final TextView lyj;
  private final Runnable lym;
  public MMSightRecordButton oPm;
  RelativeLayout odi;
  public d qbI;
  int qcP;
  public boolean qcQ;
  final int qcR;
  long qcS;
  
  public s(RelativeLayout paramRelativeLayout, d paramd)
  {
    AppMethodBeat.i(150711);
    this.odi = paramRelativeLayout;
    this.qbI = paramd;
    paramRelativeLayout = this.odi.findViewById(2131827127);
    j.p(paramRelativeLayout, "layout.findViewById(R.id.record_button)");
    this.oPm = ((MMSightRecordButton)paramRelativeLayout);
    paramRelativeLayout = this.odi.findViewById(2131821761);
    j.p(paramRelativeLayout, "layout.findViewById(R.id.capture_hint)");
    this.lyj = ((TextView)paramRelativeLayout);
    this.faV = new ak(Looper.getMainLooper());
    this.qcP = 10000;
    this.qcR = 500;
    this.qcS = -1L;
    this.lym = ((Runnable)new a(this));
    this.oPm.setSimpleTapCallback((MMSightRecordButton.d)new s.1(this));
    AppMethodBeat.o(150711);
  }
  
  public final void Cq(int paramInt)
  {
    AppMethodBeat.i(150709);
    this.odi.removeCallbacks(this.lym);
    this.lyj.setText(paramInt);
    this.lyj.setVisibility(0);
    this.lyj.animate().alpha(1.0F).start();
    this.odi.postDelayed(this.lym, 2000L);
    AppMethodBeat.o(150709);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(150708);
    j.q(paramRecordConfigProvider, "config");
    this.qcP = (paramRecordConfigProvider.qbx + 250);
    Boolean localBoolean = paramRecordConfigProvider.qbt;
    j.p(localBoolean, "config.enablePicture");
    this.qcQ = localBoolean.booleanValue();
    localBoolean = paramRecordConfigProvider.qbt;
    j.p(localBoolean, "config.enablePicture");
    if (localBoolean.booleanValue())
    {
      this.lyj.setText(2131301567);
      this.oPm.setSimpleTapCallback((MMSightRecordButton.d)new s.b(this));
    }
    localBoolean = paramRecordConfigProvider.qbu;
    j.p(localBoolean, "config.enableVideo");
    if (localBoolean.booleanValue())
    {
      this.lyj.setText(2131301568);
      this.oPm.setLongPressCallback((MMSightRecordButton.b)new s.c(this));
      this.oPm.setLongPressScrollCallback((MMSightRecordButton.c)new s.d(this));
    }
    localBoolean = paramRecordConfigProvider.qbt;
    j.p(localBoolean, "config.enablePicture");
    if (localBoolean.booleanValue())
    {
      paramRecordConfigProvider = paramRecordConfigProvider.qbu;
      j.p(paramRecordConfigProvider, "config.enableVideo");
      if (paramRecordConfigProvider.booleanValue()) {
        this.lyj.setText(2131301566);
      }
    }
    AppMethodBeat.o(150708);
  }
  
  public final boolean cgq()
  {
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(150710);
    this.oPm.bRO();
    AppMethodBeat.o(150710);
  }
  
  public final void setVisibility(int paramInt) {}
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(s params) {}
    
    public final void run()
    {
      AppMethodBeat.i(150698);
      this.qcT.lyj.animate().alpha(0.0F).withEndAction((Runnable)new s.a.1(this)).start();
      AppMethodBeat.o(150698);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.s
 * JD-Core Version:    0.7.0.1
 */