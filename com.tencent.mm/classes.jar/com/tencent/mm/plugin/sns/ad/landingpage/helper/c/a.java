package com.tencent.mm.plugin.sns.ad.landingpage.helper.c;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.d;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.plugin.sns.ad.landingpage.component.view.AdLandingGeneralVideoWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements d.a
{
  public Map<String, WeakReference<View>> JDD;
  public d JDE;
  private String componentId;
  private volatile int mOrientation;
  
  private a()
  {
    AppMethodBeat.i(263460);
    this.JDD = new HashMap();
    this.mOrientation = 0;
    AppMethodBeat.o(263460);
  }
  
  public final void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(263465);
    if (paramInt == 0) {
      this.mOrientation = 0;
    }
    while (Util.isNullOrNil(this.componentId))
    {
      Log.i("ScreenSwitchManager", "componentId is null");
      AppMethodBeat.o(263465);
      return;
      if (paramInt == 270) {
        this.mOrientation = 90;
      } else if (paramInt == 90) {
        this.mOrientation = -90;
      } else if (paramInt == 180) {
        this.mOrientation = 180;
      } else {
        this.mOrientation = -1;
      }
    }
    Object localObject = (WeakReference)this.JDD.get(this.componentId);
    if (localObject == null)
    {
      Log.i("ScreenSwitchManager", "mViewRef is null");
      AppMethodBeat.o(263465);
      return;
    }
    localObject = (View)((WeakReference)localObject).get();
    if ((localObject instanceof AdLandingGeneralVideoWrapper)) {
      ((AdLandingGeneralVideoWrapper)localObject).aeN(this.mOrientation);
    }
    AppMethodBeat.o(263465);
  }
  
  public final void start(String paramString)
  {
    AppMethodBeat.i(263461);
    this.componentId = paramString;
    if (this.JDE != null)
    {
      this.JDE.enable();
      this.JDE.EZi = this;
    }
    AppMethodBeat.o(263461);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(263462);
    if (this.JDE != null)
    {
      this.JDE.disable();
      this.JDE.EZi = null;
    }
    AppMethodBeat.o(263462);
  }
  
  public static final class a
  {
    private static final a JDF;
    
    static
    {
      AppMethodBeat.i(269109);
      JDF = new a((byte)0);
      AppMethodBeat.o(269109);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.c.a
 * JD-Core Version:    0.7.0.1
 */