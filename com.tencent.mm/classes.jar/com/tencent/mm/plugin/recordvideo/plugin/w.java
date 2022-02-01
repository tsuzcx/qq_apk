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
import com.tencent.mm.g.b.a.gc;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/widget/RelativeLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureHint", "Landroid/widget/TextView;", "enablePicture", "", "hideHintRunnable", "Ljava/lang/Runnable;", "initMaxRecordTime", "", "getInitMaxRecordTime", "()I", "setInitMaxRecordTime", "(I)V", "lastTakePictureTime", "", "getLayout", "()Landroid/widget/RelativeLayout;", "setLayout", "(Landroid/widget/RelativeLayout;)V", "maxRecordTimeMS", "getMaxRecordTimeMS", "setMaxRecordTimeMS", "progressChangeCallBack", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "", "Lkotlin/ParameterName;", "name", "subProgress", "", "getProgressChangeCallBack", "()Lkotlin/jvm/functions/Function1;", "setProgressChangeCallBack", "(Lkotlin/jvm/functions/Function1;)V", "recordButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "takePictureMinInterval", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "changeRecordDuration", "time", "enable", "hideHint", "initConfig", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "onAttach", "onDetach", "onPause", "prepareDelete", "delete", "recordFinish", "finish", "recordTimeNotEnough", "removeCurrentProgress", "verify", "removeSelectProgress", "index", "reset", "restoreRecordDuration", "setEnableSubProgress", "setEnableType", "setHintRes", "res", "setNormalVideoHint", "setSubVideoHint", "setVisibility", "visibility", "showHint", "strRes", "showRecordMaxTimeHint", "hitStr", "", "showRecordShortHint", "showRecordStartMusicHint", "showRecordTipHint", "Companion", "plugin-recordvideo_release"})
public final class w
  implements t
{
  public static final w.a xRA;
  private final aq gKO;
  private final TextView qca;
  private final Runnable qce;
  d tbP;
  RelativeLayout vpb;
  private MMSightRecordButton wiq;
  int xRu;
  private int xRv;
  private boolean xRw;
  private final int xRx;
  private long xRy;
  public b<? super ArrayList<Float>, z> xRz;
  
  static
  {
    AppMethodBeat.i(206611);
    xRA = new w.a((byte)0);
    AppMethodBeat.o(206611);
  }
  
  public w(RelativeLayout paramRelativeLayout, d paramd)
  {
    AppMethodBeat.i(75629);
    this.vpb = paramRelativeLayout;
    this.tbP = paramd;
    paramRelativeLayout = this.vpb.findViewById(2131303883);
    p.g(paramRelativeLayout, "layout.findViewById(R.id.record_button)");
    this.wiq = ((MMSightRecordButton)paramRelativeLayout);
    paramRelativeLayout = this.vpb.findViewById(2131297708);
    p.g(paramRelativeLayout, "layout.findViewById(R.id.capture_hint)");
    this.qca = ((TextView)paramRelativeLayout);
    this.gKO = new aq(Looper.getMainLooper());
    this.xRu = 10000;
    this.xRv = this.xRu;
    this.xRx = 500;
    this.xRy = -1L;
    this.qce = ((Runnable)new c(this));
    this.wiq.setSimpleTapCallback((MMSightRecordButton.d)new MMSightRecordButton.d()
    {
      public final void clI()
      {
        AppMethodBeat.i(75613);
        this.xRB.Oo(2131762240);
        AppMethodBeat.o(75613);
      }
    });
    AppMethodBeat.o(75629);
  }
  
  private final void c(final RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(206599);
    Boolean localBoolean = paramRecordConfigProvider.xOl;
    p.g(localBoolean, "config.enablePicture");
    this.xRw = localBoolean.booleanValue();
    localBoolean = paramRecordConfigProvider.xOl;
    p.g(localBoolean, "config.enablePicture");
    if (localBoolean.booleanValue())
    {
      this.qca.setText(2131761239);
      this.wiq.setSimpleTapCallback((MMSightRecordButton.d)new e(this));
    }
    localBoolean = paramRecordConfigProvider.xOm;
    p.g(localBoolean, "config.enableVideo");
    if (localBoolean.booleanValue())
    {
      this.qca.setText(2131761240);
      this.wiq.setLongPressCallback((MMSightRecordButton.b)new f(this, paramRecordConfigProvider));
      this.wiq.setLongPressScrollCallback((MMSightRecordButton.c)new g(this));
    }
    localBoolean = paramRecordConfigProvider.xOl;
    p.g(localBoolean, "config.enablePicture");
    if (localBoolean.booleanValue())
    {
      paramRecordConfigProvider = paramRecordConfigProvider.xOm;
      p.g(paramRecordConfigProvider, "config.enableVideo");
      if (paramRecordConfigProvider.booleanValue()) {
        this.qca.setText(2131761238);
      }
    }
    AppMethodBeat.o(206599);
  }
  
  private void dJQ()
  {
    AppMethodBeat.i(206601);
    this.qca.setText(2131766783);
    AppMethodBeat.o(206601);
  }
  
  private void dJR()
  {
    AppMethodBeat.i(206602);
    this.qca.setText(2131761238);
    AppMethodBeat.o(206602);
  }
  
  private final void pT(boolean paramBoolean)
  {
    AppMethodBeat.i(206608);
    this.wiq.setTouchEnable(false);
    this.gKO.postDelayed((Runnable)new d(this), 1500L);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_1_BOOLEAN", paramBoolean);
    this.tbP.a(d.c.xTX, localBundle);
    AppMethodBeat.o(206608);
  }
  
  public final void KS(int paramInt)
  {
    AppMethodBeat.i(206605);
    this.wiq.KS(paramInt);
    AppMethodBeat.o(206605);
  }
  
  public final void Oo(int paramInt)
  {
    AppMethodBeat.i(75625);
    this.vpb.removeCallbacks(this.qce);
    this.qca.setText(paramInt);
    this.qca.setVisibility(0);
    this.qca.animate().alpha(1.0F).start();
    this.vpb.postDelayed(this.qce, 2000L);
    AppMethodBeat.o(75625);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(206600);
    p.h(paramRecordConfigProvider, "config");
    this.xRv = paramRecordConfigProvider.xOp;
    this.xRu = (paramRecordConfigProvider.xOp + 250);
    c(paramRecordConfigProvider);
    AppMethodBeat.o(206600);
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm()
  {
    AppMethodBeat.i(75627);
    this.vpb.setVisibility(0);
    AppMethodBeat.o(75627);
  }
  
  public final void dJS()
  {
    AppMethodBeat.i(206603);
    if (this.xRw)
    {
      d.b.a(this.tbP, d.c.xUe);
      AppMethodBeat.o(206603);
      return;
    }
    Oo(2131762241);
    AppMethodBeat.o(206603);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void oD(boolean paramBoolean)
  {
    AppMethodBeat.i(206606);
    this.wiq.oD(paramBoolean);
    AppMethodBeat.o(206606);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach()
  {
    AppMethodBeat.i(75628);
    this.vpb.setVisibility(4);
    AppMethodBeat.o(75628);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(206607);
    this.wiq.stopRecord();
    AppMethodBeat.o(206607);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(206612);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(206612);
  }
  
  public final void onResume() {}
  
  public final void pS(boolean paramBoolean)
  {
    AppMethodBeat.i(206598);
    this.xRw = paramBoolean;
    if (this.xRw)
    {
      this.qca.setText(2131761239);
      this.wiq.setSimpleTapCallback((MMSightRecordButton.d)new b(this));
      AppMethodBeat.o(206598);
      return;
    }
    this.qca.setText(2131761240);
    this.wiq.setSimpleTapCallback(null);
    AppMethodBeat.o(206598);
  }
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(75626);
    this.wiq.dqN();
    this.wiq.setTouchEnable(true);
    this.gKO.removeCallbacksAndMessages(null);
    AppMethodBeat.o(75626);
  }
  
  public final void setEnableSubProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(206604);
    this.wiq.oC(paramBoolean);
    if (paramBoolean)
    {
      dJQ();
      AppMethodBeat.o(206604);
      return;
    }
    dJR();
    AppMethodBeat.o(206604);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(206610);
    this.wiq.setVisibility(paramInt);
    this.vpb.bringToFront();
    AppMethodBeat.o(206610);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onSimpleTap"})
  static final class b
    implements MMSightRecordButton.d
  {
    b(w paramw) {}
    
    public final void clI()
    {
      AppMethodBeat.i(206588);
      if ((w.b(this.xRB) == -1L) || (bu.aO(w.b(this.xRB)) > w.c(this.xRB)))
      {
        ae.i("MicroMsg.MMRecordUI", "onSimpleTap %s", new Object[] { bu.fpN().toString() });
        d.b.a(this.xRB.tbP, d.c.xUe);
        w.a(this.xRB, bu.HQ());
        AppMethodBeat.o(206588);
        return;
      }
      ae.i("MicroMsg.MMRecordUI", "onSimpleTap too often! %s", new Object[] { bu.fpN().toString() });
      AppMethodBeat.o(206588);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(w paramw) {}
    
    public final void run()
    {
      AppMethodBeat.i(75615);
      w.e(this.xRB).animate().alpha(0.0F).withEndAction((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(75614);
          w.e(this.xRC.xRB).setVisibility(4);
          AppMethodBeat.o(75614);
        }
      }).start();
      AppMethodBeat.o(75615);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(w paramw) {}
    
    public final void run()
    {
      AppMethodBeat.i(75616);
      w.d(this.xRB).showLoading();
      AppMethodBeat.o(75616);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onSimpleTap"})
  static final class e
    implements MMSightRecordButton.d
  {
    e(w paramw) {}
    
    public final void clI()
    {
      AppMethodBeat.i(206589);
      if ((w.b(this.xRB) == -1L) || (bu.aO(w.b(this.xRB)) > w.c(this.xRB)))
      {
        ae.i("MicroMsg.MMRecordUI", "onSimpleTap %s", new Object[] { bu.fpN().toString() });
        d.b.a(this.xRB.tbP, d.c.xUe);
        w.a(this.xRB, bu.HQ());
        AppMethodBeat.o(206589);
        return;
      }
      ae.i("MicroMsg.MMRecordUI", "onSimpleTap too often! %s", new Object[] { bu.fpN().toString() });
      AppMethodBeat.o(206589);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$setEnableType$2", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressCallback;", "onLongPress", "", "onLongPressFinish", "onPressDown", "plugin-recordvideo_release"})
  public static final class f
    implements MMSightRecordButton.b
  {
    f(RecordConfigProvider paramRecordConfigProvider) {}
    
    public final void clG()
    {
      AppMethodBeat.i(206595);
      ae.i("MicroMsg.RecordButtonPlugin", "onLongPressFinish");
      w.a(this.xRB);
      AppMethodBeat.o(206595);
    }
    
    public final void clH()
    {
      AppMethodBeat.i(206593);
      Object localObject = new int[2];
      w.d(this.xRB).getLocationOnScreen((int[])localObject);
      Bundle localBundle = new Bundle();
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_LOCATION_INT", localObject[1]);
      this.xRB.tbP.a(d.c.xTS, localBundle);
      w.e(this.xRB).animate().alpha(0.0F).withEndAction((Runnable)new b(this)).start();
      localObject = c.xWV;
      c.Ot(2);
      localObject = c.xWV;
      c.Os(2);
      localObject = c.xWV;
      c.dKd().TW();
      AppMethodBeat.o(206593);
    }
    
    public final void jB()
    {
      AppMethodBeat.i(206594);
      d.b.a(this.xRB.tbP, d.c.xTW);
      Object localObject = paramRecordConfigProvider.xOh;
      if (localObject != null)
      {
        i = ((UICustomParam)localObject).ggo;
        if (i != 0) {
          break label106;
        }
        localObject = this.xRB.vpb.getContext();
        p.g(localObject, "layout.context");
      }
      label106:
      for (int i = ((Context)localObject).getResources().getColor(2131101171);; i = paramRecordConfigProvider.xOh.ggo)
      {
        w.d(this.xRB).a(this.xRB.xRu, i, (MMSightCircularProgressBar.a)new a(this));
        AppMethodBeat.o(206594);
        return;
        i = 0;
        break;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$setEnableType$2$onLongPress$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCircularProgressBar$ProgressCallback;", "onProgress", "", "subProgress", "Ljava/util/ArrayList;", "", "onProgressFinish", "finish", "", "plugin-recordvideo_release"})
    public static final class a
      implements MMSightCircularProgressBar.a
    {
      public final void S(ArrayList<Float> paramArrayList)
      {
        AppMethodBeat.i(206590);
        p.h(paramArrayList, "subProgress");
        b localb = this.xRE.xRB.xRz;
        if (localb != null)
        {
          localb.invoke(paramArrayList);
          AppMethodBeat.o(206590);
          return;
        }
        AppMethodBeat.o(206590);
      }
      
      public final void kI(boolean paramBoolean)
      {
        AppMethodBeat.i(206591);
        ae.i("MicroMsg.RecordButtonPlugin", "onProgressFinish");
        w.a(this.xRE.xRB, paramBoolean);
        AppMethodBeat.o(206591);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(w.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(206592);
        w.e(this.xRE.xRB).setVisibility(4);
        AppMethodBeat.o(206592);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$setEnableType$3", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressScrollCallback;", "onScrollDown", "", "factor", "", "onScrollUp", "plugin-recordvideo_release"})
  public static final class g
    implements MMSightRecordButton.c
  {
    public final void CI(int paramInt)
    {
      AppMethodBeat.i(206596);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", paramInt);
      this.xRB.tbP.a(d.c.xTT, localBundle);
      AppMethodBeat.o(206596);
    }
    
    public final void CJ(int paramInt)
    {
      AppMethodBeat.i(206597);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", paramInt);
      this.xRB.tbP.a(d.c.xTT, localBundle);
      AppMethodBeat.o(206597);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.w
 * JD-Core Version:    0.7.0.1
 */