package com.tencent.mm.plugin.sns.ad.landingpage.helper.b;

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
  public Map<String, WeakReference<View>> PUC;
  private String PUD;
  public d PUE;
  private volatile int mOrientation;
  
  private a()
  {
    AppMethodBeat.i(310817);
    this.PUC = new HashMap();
    this.mOrientation = 0;
    AppMethodBeat.o(310817);
  }
  
  public static a hbb()
  {
    AppMethodBeat.i(310821);
    a locala = a.hbc();
    AppMethodBeat.o(310821);
    return locala;
  }
  
  public final void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(310843);
    if (paramInt == 0) {
      this.mOrientation = 0;
    }
    while (Util.isNullOrNil(this.PUD))
    {
      Log.i("ScreenSwitchManager", "componentId is null");
      AppMethodBeat.o(310843);
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
    Object localObject = (WeakReference)this.PUC.get(this.PUD);
    if (localObject == null)
    {
      Log.i("ScreenSwitchManager", "mViewRef is null");
      AppMethodBeat.o(310843);
      return;
    }
    localObject = (View)((WeakReference)localObject).get();
    if ((localObject instanceof AdLandingGeneralVideoWrapper)) {
      ((AdLandingGeneralVideoWrapper)localObject).ajv(this.mOrientation);
    }
    AppMethodBeat.o(310843);
  }
  
  public final void start(String paramString)
  {
    AppMethodBeat.i(310831);
    this.PUD = paramString;
    if (this.PUE != null)
    {
      this.PUE.enable();
      this.PUE.KUU = this;
    }
    AppMethodBeat.o(310831);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(310835);
    if (this.PUE != null)
    {
      this.PUE.disable();
      this.PUE.KUU = null;
    }
    AppMethodBeat.o(310835);
  }
  
  static final class a
  {
    private static final a PUF;
    
    static
    {
      AppMethodBeat.i(310825);
      PUF = new a((byte)0);
      AppMethodBeat.o(310825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a
 * JD-Core Version:    0.7.0.1
 */