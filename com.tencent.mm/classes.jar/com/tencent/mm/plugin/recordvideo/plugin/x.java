package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.g.b.a.fb;
import com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/widget/RelativeLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureHint", "Landroid/widget/TextView;", "enablePicture", "", "hideHintRunnable", "Ljava/lang/Runnable;", "initMaxRecordTime", "", "getInitMaxRecordTime", "()I", "setInitMaxRecordTime", "(I)V", "lastTakePictureTime", "", "getLayout", "()Landroid/widget/RelativeLayout;", "setLayout", "(Landroid/widget/RelativeLayout;)V", "maxRecordTimeMS", "getMaxRecordTimeMS", "setMaxRecordTimeMS", "progressChangeCallBack", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "", "Lkotlin/ParameterName;", "name", "subProgress", "", "getProgressChangeCallBack", "()Lkotlin/jvm/functions/Function1;", "setProgressChangeCallBack", "(Lkotlin/jvm/functions/Function1;)V", "recordButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "takePictureMinInterval", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "changeRecordDuration", "time", "enable", "hideHint", "initConfig", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "onAttach", "onDetach", "onPause", "prepareDelete", "delete", "recordFinish", "finish", "recordTimeNotEnough", "removeCurrentProgress", "verify", "removeSelectProgress", "index", "reset", "restoreRecordDuration", "setEnableSubProgress", "setEnableType", "setHintRes", "res", "setNormalVideoHint", "setSubVideoHint", "setVisibility", "visibility", "showHint", "strRes", "showRecordMaxTimeHint", "hitStr", "", "showRecordShortHint", "showRecordStartMusicHint", "showRecordTipHint", "Companion", "plugin-recordvideo_release"})
public final class x
  implements t
{
  public static final x.a wtJ;
  private final ao gox;
  private final TextView prP;
  private final Runnable prT;
  d rTT;
  private MMSightRecordButton uTc;
  RelativeLayout uah;
  int wtD;
  private int wtE;
  private boolean wtF;
  private final int wtG;
  private long wtH;
  public b<? super ArrayList<Float>, y> wtI;
  
  static
  {
    AppMethodBeat.i(199317);
    wtJ = new x.a((byte)0);
    AppMethodBeat.o(199317);
  }
  
  public x(RelativeLayout paramRelativeLayout, d paramd)
  {
    AppMethodBeat.i(75629);
    this.uah = paramRelativeLayout;
    this.rTT = paramd;
    paramRelativeLayout = this.uah.findViewById(2131303883);
    k.g(paramRelativeLayout, "layout.findViewById(R.id.record_button)");
    this.uTc = ((MMSightRecordButton)paramRelativeLayout);
    paramRelativeLayout = this.uah.findViewById(2131297708);
    k.g(paramRelativeLayout, "layout.findViewById(R.id.capture_hint)");
    this.prP = ((TextView)paramRelativeLayout);
    this.gox = new ao(Looper.getMainLooper());
    this.wtD = 10000;
    this.wtE = this.wtD;
    this.wtG = 500;
    this.wtH = -1L;
    this.prT = ((Runnable)new c(this));
    this.uTc.setSimpleTapCallback((MMSightRecordButton.d)new MMSightRecordButton.d()
    {
      public final void cfP()
      {
        AppMethodBeat.i(75613);
        this.wtK.Mj(2131762240);
        AppMethodBeat.o(75613);
      }
    });
    AppMethodBeat.o(75629);
  }
  
  private final void c(final RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(199305);
    Boolean localBoolean = paramRecordConfigProvider.wqy;
    k.g(localBoolean, "config.enablePicture");
    this.wtF = localBoolean.booleanValue();
    localBoolean = paramRecordConfigProvider.wqy;
    k.g(localBoolean, "config.enablePicture");
    if (localBoolean.booleanValue())
    {
      this.prP.setText(2131761239);
      this.uTc.setSimpleTapCallback((MMSightRecordButton.d)new e(this));
    }
    localBoolean = paramRecordConfigProvider.wqz;
    k.g(localBoolean, "config.enableVideo");
    if (localBoolean.booleanValue())
    {
      this.prP.setText(2131761240);
      this.uTc.setLongPressCallback((MMSightRecordButton.b)new f(this, paramRecordConfigProvider));
      this.uTc.setLongPressScrollCallback((MMSightRecordButton.c)new g(this));
    }
    localBoolean = paramRecordConfigProvider.wqy;
    k.g(localBoolean, "config.enablePicture");
    if (localBoolean.booleanValue())
    {
      paramRecordConfigProvider = paramRecordConfigProvider.wqz;
      k.g(paramRecordConfigProvider, "config.enableVideo");
      if (paramRecordConfigProvider.booleanValue()) {
        this.prP.setText(2131761238);
      }
    }
    AppMethodBeat.o(199305);
  }
  
  private void dwd()
  {
    AppMethodBeat.i(199307);
    this.prP.setText(2131766783);
    AppMethodBeat.o(199307);
  }
  
  private void dwe()
  {
    AppMethodBeat.i(199308);
    this.prP.setText(2131761238);
    AppMethodBeat.o(199308);
  }
  
  private final void pp(boolean paramBoolean)
  {
    AppMethodBeat.i(199314);
    this.uTc.setTouchEnable(false);
    this.gox.postDelayed((Runnable)new d(this), 1500L);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_1_BOOLEAN", paramBoolean);
    this.rTT.a(d.c.wvU, localBundle);
    AppMethodBeat.o(199314);
  }
  
  public final void IV(int paramInt)
  {
    AppMethodBeat.i(199311);
    this.uTc.IV(paramInt);
    AppMethodBeat.o(199311);
  }
  
  public final void Mj(int paramInt)
  {
    AppMethodBeat.i(75625);
    this.uah.removeCallbacks(this.prT);
    this.prP.setText(paramInt);
    this.prP.setVisibility(0);
    this.prP.animate().alpha(1.0F).start();
    this.uah.postDelayed(this.prT, 2000L);
    AppMethodBeat.o(75625);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(199306);
    k.h(paramRecordConfigProvider, "config");
    this.wtE = paramRecordConfigProvider.wqC;
    this.wtD = (paramRecordConfigProvider.wqC + 250);
    c(paramRecordConfigProvider);
    AppMethodBeat.o(199306);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk()
  {
    AppMethodBeat.i(75627);
    this.uah.setVisibility(0);
    AppMethodBeat.o(75627);
  }
  
  public final void dwf()
  {
    AppMethodBeat.i(199309);
    if (this.wtF)
    {
      d.b.a(this.rTT, d.c.wwb);
      AppMethodBeat.o(199309);
      return;
    }
    Mj(2131762241);
    AppMethodBeat.o(199309);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void oe(boolean paramBoolean)
  {
    AppMethodBeat.i(199312);
    this.uTc.oe(paramBoolean);
    AppMethodBeat.o(199312);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach()
  {
    AppMethodBeat.i(75628);
    this.uah.setVisibility(4);
    AppMethodBeat.o(75628);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(199313);
    this.uTc.stopRecord();
    AppMethodBeat.o(199313);
  }
  
  public final void onResume() {}
  
  public final void po(boolean paramBoolean)
  {
    AppMethodBeat.i(199304);
    this.wtF = paramBoolean;
    if (this.wtF)
    {
      this.prP.setText(2131761239);
      this.uTc.setSimpleTapCallback((MMSightRecordButton.d)new b(this));
      AppMethodBeat.o(199304);
      return;
    }
    this.prP.setText(2131761240);
    this.uTc.setSimpleTapCallback(null);
    AppMethodBeat.o(199304);
  }
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(75626);
    this.uTc.der();
    this.uTc.setTouchEnable(true);
    this.gox.removeCallbacksAndMessages(null);
    AppMethodBeat.o(75626);
  }
  
  public final void setEnableSubProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(199310);
    this.uTc.od(paramBoolean);
    if (paramBoolean)
    {
      dwd();
      AppMethodBeat.o(199310);
      return;
    }
    dwe();
    AppMethodBeat.o(199310);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(199316);
    this.uTc.setVisibility(paramInt);
    AppMethodBeat.o(199316);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onSimpleTap"})
  static final class b
    implements MMSightRecordButton.d
  {
    b(x paramx) {}
    
    public final void cfP()
    {
      AppMethodBeat.i(199294);
      if ((x.b(this.wtK) == -1L) || (bs.aO(x.b(this.wtK)) > x.c(this.wtK)))
      {
        ac.i("MicroMsg.MMRecordUI", "onSimpleTap %s", new Object[] { bs.eWi().toString() });
        d.b.a(this.wtK.rTT, d.c.wwb);
        x.a(this.wtK, bs.Gn());
        AppMethodBeat.o(199294);
        return;
      }
      ac.i("MicroMsg.MMRecordUI", "onSimpleTap too often! %s", new Object[] { bs.eWi().toString() });
      AppMethodBeat.o(199294);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(x paramx) {}
    
    public final void run()
    {
      AppMethodBeat.i(75615);
      x.e(this.wtK).animate().alpha(0.0F).withEndAction((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(75614);
          x.e(this.wtL.wtK).setVisibility(4);
          AppMethodBeat.o(75614);
        }
      }).start();
      AppMethodBeat.o(75615);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(x paramx) {}
    
    public final void run()
    {
      AppMethodBeat.i(75616);
      x.d(this.wtK).showLoading();
      AppMethodBeat.o(75616);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onSimpleTap"})
  static final class e
    implements MMSightRecordButton.d
  {
    e(x paramx) {}
    
    public final void cfP()
    {
      AppMethodBeat.i(199295);
      if ((x.b(this.wtK) == -1L) || (bs.aO(x.b(this.wtK)) > x.c(this.wtK)))
      {
        ac.i("MicroMsg.MMRecordUI", "onSimpleTap %s", new Object[] { bs.eWi().toString() });
        d.b.a(this.wtK.rTT, d.c.wwb);
        x.a(this.wtK, bs.Gn());
        AppMethodBeat.o(199295);
        return;
      }
      ac.i("MicroMsg.MMRecordUI", "onSimpleTap too often! %s", new Object[] { bs.eWi().toString() });
      AppMethodBeat.o(199295);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$setEnableType$2", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressCallback;", "onLongPress", "", "onLongPressFinish", "onPressDown", "plugin-recordvideo_release"})
  public static final class f
    implements MMSightRecordButton.b
  {
    f(RecordConfigProvider paramRecordConfigProvider) {}
    
    public final void cfN()
    {
      AppMethodBeat.i(199301);
      ac.i("MicroMsg.RecordButtonPlugin", "onLongPressFinish");
      x.a(this.wtK);
      AppMethodBeat.o(199301);
    }
    
    public final void cfO()
    {
      AppMethodBeat.i(199299);
      Object localObject = new int[2];
      x.d(this.wtK).getLocationOnScreen((int[])localObject);
      Bundle localBundle = new Bundle();
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_LOCATION_INT", localObject[1]);
      this.wtK.rTT.a(d.c.wvP, localBundle);
      x.e(this.wtK).animate().alpha(0.0F).withEndAction((Runnable)new b(this)).start();
      localObject = c.wyg;
      c.Mo(2);
      localObject = c.wyg;
      c.Mn(2);
      localObject = c.wyg;
      c.dws().RJ();
      AppMethodBeat.o(199299);
    }
    
    public final void jl()
    {
      AppMethodBeat.i(199300);
      d.b.a(this.wtK.rTT, d.c.wvT);
      Object localObject = paramRecordConfigProvider.wqu;
      if (localObject != null)
      {
        i = ((UICustomParam)localObject).fKF;
        if (i != 0) {
          break label106;
        }
        localObject = this.wtK.uah.getContext();
        k.g(localObject, "layout.context");
      }
      label106:
      for (int i = ((Context)localObject).getResources().getColor(2131101171);; i = paramRecordConfigProvider.wqu.fKF)
      {
        x.d(this.wtK).a(this.wtK.wtD, i, (MMSightCircularProgressBar.a)new a(this));
        AppMethodBeat.o(199300);
        return;
        i = 0;
        break;
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$setEnableType$2$onLongPress$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCircularProgressBar$ProgressCallback;", "onProgress", "", "subProgress", "Ljava/util/ArrayList;", "", "onProgressFinish", "finish", "", "plugin-recordvideo_release"})
    public static final class a
      implements MMSightCircularProgressBar.a
    {
      public final void S(ArrayList<Float> paramArrayList)
      {
        AppMethodBeat.i(199296);
        k.h(paramArrayList, "subProgress");
        b localb = this.wtN.wtK.wtI;
        if (localb != null)
        {
          localb.ay(paramArrayList);
          AppMethodBeat.o(199296);
          return;
        }
        AppMethodBeat.o(199296);
      }
      
      public final void kw(boolean paramBoolean)
      {
        AppMethodBeat.i(199297);
        ac.i("MicroMsg.RecordButtonPlugin", "onProgressFinish");
        x.a(this.wtN.wtK, paramBoolean);
        AppMethodBeat.o(199297);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(x.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(199298);
        x.e(this.wtN.wtK).setVisibility(4);
        AppMethodBeat.o(199298);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$setEnableType$3", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressScrollCallback;", "onScrollDown", "", "factor", "", "onScrollUp", "plugin-recordvideo_release"})
  public static final class g
    implements MMSightRecordButton.c
  {
    public final void BO(int paramInt)
    {
      AppMethodBeat.i(199302);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", paramInt);
      this.wtK.rTT.a(d.c.wvQ, localBundle);
      AppMethodBeat.o(199302);
    }
    
    public final void BP(int paramInt)
    {
      AppMethodBeat.i(199303);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", paramInt);
      this.wtK.rTT.a(d.c.wvQ, localBundle);
      AppMethodBeat.o(199303);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.x
 * JD-Core Version:    0.7.0.1
 */