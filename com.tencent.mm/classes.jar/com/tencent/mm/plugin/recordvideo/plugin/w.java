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
import com.tencent.mm.g.b.a.ga;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/widget/RelativeLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureHint", "Landroid/widget/TextView;", "enablePicture", "", "hideHintRunnable", "Ljava/lang/Runnable;", "initMaxRecordTime", "", "getInitMaxRecordTime", "()I", "setInitMaxRecordTime", "(I)V", "lastTakePictureTime", "", "getLayout", "()Landroid/widget/RelativeLayout;", "setLayout", "(Landroid/widget/RelativeLayout;)V", "maxRecordTimeMS", "getMaxRecordTimeMS", "setMaxRecordTimeMS", "progressChangeCallBack", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "", "Lkotlin/ParameterName;", "name", "subProgress", "", "getProgressChangeCallBack", "()Lkotlin/jvm/functions/Function1;", "setProgressChangeCallBack", "(Lkotlin/jvm/functions/Function1;)V", "recordButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "takePictureMinInterval", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "changeRecordDuration", "time", "enable", "hideHint", "initConfig", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "onAttach", "onDetach", "onPause", "prepareDelete", "delete", "recordFinish", "finish", "recordTimeNotEnough", "removeCurrentProgress", "verify", "removeSelectProgress", "index", "reset", "restoreRecordDuration", "setEnableSubProgress", "setEnableType", "setHintRes", "res", "setNormalVideoHint", "setSubVideoHint", "setVisibility", "visibility", "showHint", "strRes", "showRecordMaxTimeHint", "hitStr", "", "showRecordShortHint", "showRecordStartMusicHint", "showRecordTipHint", "Companion", "plugin-recordvideo_release"})
public final class w
  implements t
{
  public static final w.a xBF;
  private final ap gIf;
  private final TextView pVv;
  private final Runnable pVz;
  d sQE;
  private MMSightRecordButton vWm;
  RelativeLayout vcQ;
  private int xBA;
  private boolean xBB;
  private final int xBC;
  private long xBD;
  public b<? super ArrayList<Float>, z> xBE;
  int xBz;
  
  static
  {
    AppMethodBeat.i(200350);
    xBF = new w.a((byte)0);
    AppMethodBeat.o(200350);
  }
  
  public w(RelativeLayout paramRelativeLayout, d paramd)
  {
    AppMethodBeat.i(75629);
    this.vcQ = paramRelativeLayout;
    this.sQE = paramd;
    paramRelativeLayout = this.vcQ.findViewById(2131303883);
    p.g(paramRelativeLayout, "layout.findViewById(R.id.record_button)");
    this.vWm = ((MMSightRecordButton)paramRelativeLayout);
    paramRelativeLayout = this.vcQ.findViewById(2131297708);
    p.g(paramRelativeLayout, "layout.findViewById(R.id.capture_hint)");
    this.pVv = ((TextView)paramRelativeLayout);
    this.gIf = new ap(Looper.getMainLooper());
    this.xBz = 10000;
    this.xBA = this.xBz;
    this.xBC = 500;
    this.xBD = -1L;
    this.pVz = ((Runnable)new c(this));
    this.vWm.setSimpleTapCallback((MMSightRecordButton.d)new MMSightRecordButton.d()
    {
      public final void cks()
      {
        AppMethodBeat.i(75613);
        this.xBG.NI(2131762240);
        AppMethodBeat.o(75613);
      }
    });
    AppMethodBeat.o(75629);
  }
  
  private final void c(final RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(200338);
    Boolean localBoolean = paramRecordConfigProvider.xyo;
    p.g(localBoolean, "config.enablePicture");
    this.xBB = localBoolean.booleanValue();
    localBoolean = paramRecordConfigProvider.xyo;
    p.g(localBoolean, "config.enablePicture");
    if (localBoolean.booleanValue())
    {
      this.pVv.setText(2131761239);
      this.vWm.setSimpleTapCallback((MMSightRecordButton.d)new e(this));
    }
    localBoolean = paramRecordConfigProvider.xyp;
    p.g(localBoolean, "config.enableVideo");
    if (localBoolean.booleanValue())
    {
      this.pVv.setText(2131761240);
      this.vWm.setLongPressCallback((MMSightRecordButton.b)new f(this, paramRecordConfigProvider));
      this.vWm.setLongPressScrollCallback((MMSightRecordButton.c)new g(this));
    }
    localBoolean = paramRecordConfigProvider.xyo;
    p.g(localBoolean, "config.enablePicture");
    if (localBoolean.booleanValue())
    {
      paramRecordConfigProvider = paramRecordConfigProvider.xyp;
      p.g(paramRecordConfigProvider, "config.enableVideo");
      if (paramRecordConfigProvider.booleanValue()) {
        this.pVv.setText(2131761238);
      }
    }
    AppMethodBeat.o(200338);
  }
  
  private void dGA()
  {
    AppMethodBeat.i(200341);
    this.pVv.setText(2131761238);
    AppMethodBeat.o(200341);
  }
  
  private void dGz()
  {
    AppMethodBeat.i(200340);
    this.pVv.setText(2131766783);
    AppMethodBeat.o(200340);
  }
  
  private final void pL(boolean paramBoolean)
  {
    AppMethodBeat.i(200347);
    this.vWm.setTouchEnable(false);
    this.gIf.postDelayed((Runnable)new d(this), 1500L);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_1_BOOLEAN", paramBoolean);
    this.sQE.a(d.c.xEc, localBundle);
    AppMethodBeat.o(200347);
  }
  
  public final void Ks(int paramInt)
  {
    AppMethodBeat.i(200344);
    this.vWm.Ks(paramInt);
    AppMethodBeat.o(200344);
  }
  
  public final void NI(int paramInt)
  {
    AppMethodBeat.i(75625);
    this.vcQ.removeCallbacks(this.pVz);
    this.pVv.setText(paramInt);
    this.pVv.setVisibility(0);
    this.pVv.animate().alpha(1.0F).start();
    this.vcQ.postDelayed(this.pVz, 2000L);
    AppMethodBeat.o(75625);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(200339);
    p.h(paramRecordConfigProvider, "config");
    this.xBA = paramRecordConfigProvider.xyt;
    this.xBz = (paramRecordConfigProvider.xyt + 250);
    c(paramRecordConfigProvider);
    AppMethodBeat.o(200339);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX()
  {
    AppMethodBeat.i(75627);
    this.vcQ.setVisibility(0);
    AppMethodBeat.o(75627);
  }
  
  public final void dGB()
  {
    AppMethodBeat.i(200342);
    if (this.xBB)
    {
      d.b.a(this.sQE, d.c.xEj);
      AppMethodBeat.o(200342);
      return;
    }
    NI(2131762241);
    AppMethodBeat.o(200342);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach()
  {
    AppMethodBeat.i(75628);
    this.vcQ.setVisibility(4);
    AppMethodBeat.o(75628);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(200346);
    this.vWm.stopRecord();
    AppMethodBeat.o(200346);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200351);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200351);
  }
  
  public final void onResume() {}
  
  public final void oy(boolean paramBoolean)
  {
    AppMethodBeat.i(200345);
    this.vWm.oy(paramBoolean);
    AppMethodBeat.o(200345);
  }
  
  public final void pK(boolean paramBoolean)
  {
    AppMethodBeat.i(200337);
    this.xBB = paramBoolean;
    if (this.xBB)
    {
      this.pVv.setText(2131761239);
      this.vWm.setSimpleTapCallback((MMSightRecordButton.d)new b(this));
      AppMethodBeat.o(200337);
      return;
    }
    this.pVv.setText(2131761240);
    this.vWm.setSimpleTapCallback(null);
    AppMethodBeat.o(200337);
  }
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(75626);
    this.vWm.dnP();
    this.vWm.setTouchEnable(true);
    this.gIf.removeCallbacksAndMessages(null);
    AppMethodBeat.o(75626);
  }
  
  public final void setEnableSubProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(200343);
    this.vWm.ox(paramBoolean);
    if (paramBoolean)
    {
      dGz();
      AppMethodBeat.o(200343);
      return;
    }
    dGA();
    AppMethodBeat.o(200343);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(200349);
    this.vWm.setVisibility(paramInt);
    this.vcQ.bringToFront();
    AppMethodBeat.o(200349);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onSimpleTap"})
  static final class b
    implements MMSightRecordButton.d
  {
    b(w paramw) {}
    
    public final void cks()
    {
      AppMethodBeat.i(200327);
      if ((w.b(this.xBG) == -1L) || (bt.aO(w.b(this.xBG)) > w.c(this.xBG)))
      {
        ad.i("MicroMsg.MMRecordUI", "onSimpleTap %s", new Object[] { bt.flS().toString() });
        d.b.a(this.xBG.sQE, d.c.xEj);
        w.a(this.xBG, bt.HI());
        AppMethodBeat.o(200327);
        return;
      }
      ad.i("MicroMsg.MMRecordUI", "onSimpleTap too often! %s", new Object[] { bt.flS().toString() });
      AppMethodBeat.o(200327);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(w paramw) {}
    
    public final void run()
    {
      AppMethodBeat.i(75615);
      w.e(this.xBG).animate().alpha(0.0F).withEndAction((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(75614);
          w.e(this.xBH.xBG).setVisibility(4);
          AppMethodBeat.o(75614);
        }
      }).start();
      AppMethodBeat.o(75615);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(w paramw) {}
    
    public final void run()
    {
      AppMethodBeat.i(75616);
      w.d(this.xBG).showLoading();
      AppMethodBeat.o(75616);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onSimpleTap"})
  static final class e
    implements MMSightRecordButton.d
  {
    e(w paramw) {}
    
    public final void cks()
    {
      AppMethodBeat.i(200328);
      if ((w.b(this.xBG) == -1L) || (bt.aO(w.b(this.xBG)) > w.c(this.xBG)))
      {
        ad.i("MicroMsg.MMRecordUI", "onSimpleTap %s", new Object[] { bt.flS().toString() });
        d.b.a(this.xBG.sQE, d.c.xEj);
        w.a(this.xBG, bt.HI());
        AppMethodBeat.o(200328);
        return;
      }
      ad.i("MicroMsg.MMRecordUI", "onSimpleTap too often! %s", new Object[] { bt.flS().toString() });
      AppMethodBeat.o(200328);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$setEnableType$2", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressCallback;", "onLongPress", "", "onLongPressFinish", "onPressDown", "plugin-recordvideo_release"})
  public static final class f
    implements MMSightRecordButton.b
  {
    f(RecordConfigProvider paramRecordConfigProvider) {}
    
    public final void ckq()
    {
      AppMethodBeat.i(200334);
      ad.i("MicroMsg.RecordButtonPlugin", "onLongPressFinish");
      w.a(this.xBG);
      AppMethodBeat.o(200334);
    }
    
    public final void ckr()
    {
      AppMethodBeat.i(200332);
      Object localObject = new int[2];
      w.d(this.xBG).getLocationOnScreen((int[])localObject);
      Bundle localBundle = new Bundle();
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_LOCATION_INT", localObject[1]);
      this.xBG.sQE.a(d.c.xDX, localBundle);
      w.e(this.xBG).animate().alpha(0.0F).withEndAction((Runnable)new b(this)).start();
      localObject = c.xHa;
      c.NN(2);
      localObject = c.xHa;
      c.NM(2);
      localObject = c.xHa;
      c.dGM().TQ();
      AppMethodBeat.o(200332);
    }
    
    public final void jB()
    {
      AppMethodBeat.i(200333);
      d.b.a(this.xBG.sQE, d.c.xEb);
      Object localObject = paramRecordConfigProvider.xyk;
      if (localObject != null)
      {
        i = ((UICustomParam)localObject).geg;
        if (i != 0) {
          break label106;
        }
        localObject = this.xBG.vcQ.getContext();
        p.g(localObject, "layout.context");
      }
      label106:
      for (int i = ((Context)localObject).getResources().getColor(2131101171);; i = paramRecordConfigProvider.xyk.geg)
      {
        w.d(this.xBG).a(this.xBG.xBz, i, (MMSightCircularProgressBar.a)new a(this));
        AppMethodBeat.o(200333);
        return;
        i = 0;
        break;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$setEnableType$2$onLongPress$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCircularProgressBar$ProgressCallback;", "onProgress", "", "subProgress", "Ljava/util/ArrayList;", "", "onProgressFinish", "finish", "", "plugin-recordvideo_release"})
    public static final class a
      implements MMSightCircularProgressBar.a
    {
      public final void S(ArrayList<Float> paramArrayList)
      {
        AppMethodBeat.i(200329);
        p.h(paramArrayList, "subProgress");
        b localb = this.xBJ.xBG.xBE;
        if (localb != null)
        {
          localb.invoke(paramArrayList);
          AppMethodBeat.o(200329);
          return;
        }
        AppMethodBeat.o(200329);
      }
      
      public final void kH(boolean paramBoolean)
      {
        AppMethodBeat.i(200330);
        ad.i("MicroMsg.RecordButtonPlugin", "onProgressFinish");
        w.a(this.xBJ.xBG, paramBoolean);
        AppMethodBeat.o(200330);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(w.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(200331);
        w.e(this.xBJ.xBG).setVisibility(4);
        AppMethodBeat.o(200331);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$setEnableType$3", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressScrollCallback;", "onScrollDown", "", "factor", "", "onScrollUp", "plugin-recordvideo_release"})
  public static final class g
    implements MMSightRecordButton.c
  {
    public final void Cw(int paramInt)
    {
      AppMethodBeat.i(200335);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", paramInt);
      this.xBG.sQE.a(d.c.xDY, localBundle);
      AppMethodBeat.o(200335);
    }
    
    public final void Cx(int paramInt)
    {
      AppMethodBeat.i(200336);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", paramInt);
      this.xBG.sQE.a(d.c.xDY, localBundle);
      AppMethodBeat.o(200336);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.w
 * JD-Core Version:    0.7.0.1
 */