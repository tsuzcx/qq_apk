package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.os.Bundle;
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
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/widget/RelativeLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureHint", "Landroid/widget/TextView;", "enablePicture", "", "hideHintRunnable", "Ljava/lang/Runnable;", "initMaxRecordTime", "", "getInitMaxRecordTime", "()I", "setInitMaxRecordTime", "(I)V", "lastTakePictureTime", "", "getLayout", "()Landroid/widget/RelativeLayout;", "setLayout", "(Landroid/widget/RelativeLayout;)V", "maxRecordTimeMS", "getMaxRecordTimeMS", "setMaxRecordTimeMS", "progressChangeCallBack", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "", "Lkotlin/ParameterName;", "name", "subProgress", "", "getProgressChangeCallBack", "()Lkotlin/jvm/functions/Function1;", "setProgressChangeCallBack", "(Lkotlin/jvm/functions/Function1;)V", "recordButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "takePictureMinInterval", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "changeRecordDuration", "time", "enable", "hideHint", "initConfig", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "onAttach", "onDetach", "onPause", "prepareDelete", "delete", "recordFinish", "finish", "recordTimeNotEnough", "removeCurrentProgress", "verify", "removeSelectProgress", "index", "reset", "restoreRecordDuration", "setEnableSubProgress", "setEnableType", "setHintRes", "res", "setNormalVideoHint", "setSubVideoHint", "setVisibility", "visibility", "showHint", "strRes", "showRecordMaxTimeHint", "hitStr", "", "showRecordShortHint", "showRecordStartMusicHint", "showRecordTipHint", "Companion", "plugin-recordvideo_release"})
public final class w
  implements t
{
  public static final c Lno;
  private int Lnm;
  public b<? super ArrayList<Float>, y> Lnn;
  private final ap gAC;
  private final TextView oOv;
  private final Runnable oOz;
  RelativeLayout sRU;
  private MMSightRecordButton tKw;
  d vjo;
  int vla;
  private boolean vlb;
  private final int vlc;
  private long vld;
  
  static
  {
    AppMethodBeat.i(204131);
    Lno = new c((byte)0);
    AppMethodBeat.o(204131);
  }
  
  public w(RelativeLayout paramRelativeLayout, d paramd)
  {
    AppMethodBeat.i(75629);
    this.sRU = paramRelativeLayout;
    this.vjo = paramd;
    paramRelativeLayout = this.sRU.findViewById(2131303883);
    k.g(paramRelativeLayout, "layout.findViewById(R.id.record_button)");
    this.tKw = ((MMSightRecordButton)paramRelativeLayout);
    paramRelativeLayout = this.sRU.findViewById(2131297708);
    k.g(paramRelativeLayout, "layout.findViewById(R.id.capture_hint)");
    this.oOv = ((TextView)paramRelativeLayout);
    this.gAC = new ap(Looper.getMainLooper());
    this.vla = 10000;
    this.Lnm = this.vla;
    this.vlc = 500;
    this.vld = -1L;
    this.oOz = ((Runnable)new a(this));
    this.tKw.setSimpleTapCallback((MMSightRecordButton.d)new MMSightRecordButton.d()
    {
      public final void bYC()
      {
        AppMethodBeat.i(75613);
        this.vle.Kl(2131762240);
        AppMethodBeat.o(75613);
      }
    });
    AppMethodBeat.o(75629);
  }
  
  private void fYg()
  {
    AppMethodBeat.i(204121);
    this.oOv.setText(2131766745);
    AppMethodBeat.o(204121);
  }
  
  private void fYh()
  {
    AppMethodBeat.i(204122);
    this.oOv.setText(2131761238);
    AppMethodBeat.o(204122);
  }
  
  private final void h(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(204119);
    Boolean localBoolean = paramRecordConfigProvider.vhM;
    k.g(localBoolean, "config.enablePicture");
    this.vlb = localBoolean.booleanValue();
    localBoolean = paramRecordConfigProvider.vhM;
    k.g(localBoolean, "config.enablePicture");
    if (localBoolean.booleanValue())
    {
      this.oOv.setText(2131761239);
      this.tKw.setSimpleTapCallback((MMSightRecordButton.d)new e(this));
    }
    localBoolean = paramRecordConfigProvider.vhN;
    k.g(localBoolean, "config.enableVideo");
    if (localBoolean.booleanValue())
    {
      this.oOv.setText(2131761240);
      this.tKw.setLongPressCallback((MMSightRecordButton.b)new w.f(this, paramRecordConfigProvider));
      this.tKw.setLongPressScrollCallback((MMSightRecordButton.c)new w.g(this));
    }
    localBoolean = paramRecordConfigProvider.vhM;
    k.g(localBoolean, "config.enablePicture");
    if (localBoolean.booleanValue())
    {
      paramRecordConfigProvider = paramRecordConfigProvider.vhN;
      k.g(paramRecordConfigProvider, "config.enableVideo");
      if (paramRecordConfigProvider.booleanValue()) {
        this.oOv.setText(2131761238);
      }
    }
    AppMethodBeat.o(204119);
  }
  
  private final void zb(boolean paramBoolean)
  {
    AppMethodBeat.i(204128);
    this.tKw.setTouchEnable(false);
    this.gAC.postDelayed((Runnable)new b(this), 1500L);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_1_BOOLEAN", paramBoolean);
    this.vjo.a(d.c.vnz, localBundle);
    AppMethodBeat.o(204128);
  }
  
  public final void Kl(int paramInt)
  {
    AppMethodBeat.i(75625);
    this.sRU.removeCallbacks(this.oOz);
    this.oOv.setText(paramInt);
    this.oOv.setVisibility(0);
    this.oOv.animate().alpha(1.0F).start();
    this.sRU.postDelayed(this.oOz, 2000L);
    AppMethodBeat.o(75625);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(204120);
    k.h(paramRecordConfigProvider, "config");
    this.Lnm = paramRecordConfigProvider.vhQ;
    this.vla = (paramRecordConfigProvider.vhQ + 250);
    h(paramRecordConfigProvider);
    AppMethodBeat.o(204120);
  }
  
  public final void aic(int paramInt)
  {
    AppMethodBeat.i(204125);
    this.tKw.aic(paramInt);
    AppMethodBeat.o(204125);
  }
  
  public final void apt()
  {
    AppMethodBeat.i(75627);
    this.sRU.setVisibility(0);
    AppMethodBeat.o(75627);
  }
  
  public final boolean dia()
  {
    return false;
  }
  
  public final void fYi()
  {
    AppMethodBeat.i(204123);
    if (this.vlb)
    {
      d.b.a(this.vjo, d.c.vnA);
      AppMethodBeat.o(204123);
      return;
    }
    Kl(2131762241);
    AppMethodBeat.o(204123);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach()
  {
    AppMethodBeat.i(75628);
    this.sRU.setVisibility(4);
    AppMethodBeat.o(75628);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(204127);
    this.tKw.stopRecord();
    AppMethodBeat.o(204127);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(75626);
    this.tKw.cQI();
    this.tKw.setTouchEnable(true);
    this.gAC.removeCallbacksAndMessages(null);
    AppMethodBeat.o(75626);
  }
  
  public final void setEnableSubProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(204124);
    this.tKw.yX(paramBoolean);
    if (paramBoolean)
    {
      fYg();
      AppMethodBeat.o(204124);
      return;
    }
    fYh();
    AppMethodBeat.o(204124);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(204130);
    this.tKw.setVisibility(paramInt);
    AppMethodBeat.o(204130);
  }
  
  public final void yY(boolean paramBoolean)
  {
    AppMethodBeat.i(204126);
    this.tKw.yY(paramBoolean);
    AppMethodBeat.o(204126);
  }
  
  public final void za(boolean paramBoolean)
  {
    AppMethodBeat.i(204118);
    this.vlb = paramBoolean;
    if (this.vlb)
    {
      this.oOv.setText(2131761239);
      this.tKw.setSimpleTapCallback((MMSightRecordButton.d)new d(this));
      AppMethodBeat.o(204118);
      return;
    }
    this.oOv.setText(2131761240);
    this.tKw.setSimpleTapCallback(null);
    AppMethodBeat.o(204118);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(w paramw) {}
    
    public final void run()
    {
      AppMethodBeat.i(75615);
      w.e(this.vle).animate().alpha(0.0F).withEndAction((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(75614);
          w.e(this.vlf.vle).setVisibility(4);
          AppMethodBeat.o(75614);
        }
      }).start();
      AppMethodBeat.o(75615);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(w paramw) {}
    
    public final void run()
    {
      AppMethodBeat.i(75616);
      w.d(this.vle).showLoading();
      AppMethodBeat.o(75616);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class c {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onSimpleTap"})
  static final class d
    implements MMSightRecordButton.d
  {
    d(w paramw) {}
    
    public final void bYC()
    {
      AppMethodBeat.i(204108);
      if ((w.b(this.vle) == -1L) || (bt.aS(w.b(this.vle)) > w.c(this.vle)))
      {
        ad.i("MicroMsg.MMRecordUI", "onSimpleTap %s", new Object[] { bt.eGN().toString() });
        d.b.a(this.vle.vjo, d.c.vnA);
        w.a(this.vle, bt.GC());
        AppMethodBeat.o(204108);
        return;
      }
      ad.i("MicroMsg.MMRecordUI", "onSimpleTap too often! %s", new Object[] { bt.eGN().toString() });
      AppMethodBeat.o(204108);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onSimpleTap"})
  static final class e
    implements MMSightRecordButton.d
  {
    e(w paramw) {}
    
    public final void bYC()
    {
      AppMethodBeat.i(204109);
      if ((w.b(this.vle) == -1L) || (bt.aS(w.b(this.vle)) > w.c(this.vle)))
      {
        ad.i("MicroMsg.MMRecordUI", "onSimpleTap %s", new Object[] { bt.eGN().toString() });
        d.b.a(this.vle.vjo, d.c.vnA);
        w.a(this.vle, bt.GC());
        AppMethodBeat.o(204109);
        return;
      }
      ad.i("MicroMsg.MMRecordUI", "onSimpleTap too often! %s", new Object[] { bt.eGN().toString() });
      AppMethodBeat.o(204109);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.w
 * JD-Core Version:    0.7.0.1
 */