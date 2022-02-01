package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a.a;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Map;

final class j$a
  implements a.a
{
  private String zUD;
  private Reference<j> zUE;
  
  j$a(String paramString, j paramj)
  {
    AppMethodBeat.i(219435);
    this.zUD = paramString;
    this.zUE = new WeakReference(paramj);
    AppMethodBeat.o(219435);
  }
  
  public final void aI(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(219436);
    for (;;)
    {
      j localj;
      long l;
      try
      {
        ae.i("AdLandingNewH5Comp", "onGeoCallback is called!");
        str = this.zUD;
        localj = (j)this.zUE.get();
        if ((str == null) || (localj == null)) {
          break label344;
        }
        if (localj.lAf == null)
        {
          boolean bool = localj.mIsDestroyed;
          if (bool) {}
        }
        try
        {
          localObject1 = (x)g.ab(x.class);
          if (localObject1 == null) {
            break label350;
          }
          localObject1 = ((x)localObject1).b(localj.hLV);
          if (localObject1 == null) {
            continue;
          }
          ae.d("AdLandingNewH5Comp", "the jsApiHandler is set from service");
          localj.lAf = ((f)localObject1);
        }
        catch (Throwable localThrowable1)
        {
          Object localObject1;
          Class localClass;
          Method localMethod;
          ae.e("AdLandingNewH5Comp", "ensureJsApiHandlerFromService has something wrong!!");
          continue;
        }
        localObject1 = localj.lAf;
        if (localObject1 != null) {}
      }
      catch (Throwable paramMap)
      {
        String str;
        ae.e("AdLandingNewH5Comp", "there is a exception in onGeoCallback");
        AppMethodBeat.o(219436);
        return;
      }
      try
      {
        l = SystemClock.currentThreadTimeMillis();
        localClass = localj.hLV.getClass();
        localMethod = j.aU(localClass);
        localObject1 = localMethod;
        if (localMethod == null)
        {
          ae.i("AdLandingNewH5Comp", "the js method is not found in getJsapiMethod, try to findJsapiMethod");
          localObject1 = j.aV(localClass);
        }
        if (localObject1 != null) {
          break label246;
        }
        ae.w("AdLandingNewH5Comp", "the js method is not found!");
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Object localObject2;
          ae.e("AdLandingNewH5Comp", "there is no getJsApiHandler method, the jsApiHandler object may be null!!");
          break;
          ae.w("AdLandingNewH5Comp", "the method return value is null ??");
        }
        ae.w("AdLandingNewH5Comp", "the js api handler is null!!");
      }
      localObject1 = localj.lAf;
      if (localObject1 != null)
      {
        ae.d("AdLandingNewH5Comp", "the js api handler is called!!");
        ((f)localObject1).a(str, "GEO", paramMap, true);
        AppMethodBeat.o(219436);
        return;
        ae.w("AdLandingNewH5Comp", "the jsApiHandler is null from service!");
        continue;
        label246:
        localObject2 = localThrowable1.invoke(localj.hLV, new Object[0]);
        if ((localObject2 instanceof f))
        {
          ae.i("AdLandingNewH5Comp", "the method return type is js api in ensureJsApiHandlerFromWebView");
          localj.lAf = ((f)localObject2);
          ae.i("AdLandingNewH5Comp", "get the js api handler takes : " + (SystemClock.currentThreadTimeMillis() - l));
          continue;
        }
      }
      label344:
      AppMethodBeat.o(219436);
      return;
      label350:
      Object localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.a
 * JD-Core Version:    0.7.0.1
 */