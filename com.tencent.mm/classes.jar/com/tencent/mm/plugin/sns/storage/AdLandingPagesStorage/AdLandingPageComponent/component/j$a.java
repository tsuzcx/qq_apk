package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a.a;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Map;

final class j$a
  implements a.a
{
  private String zDA;
  private Reference<j> zDB;
  
  j$a(String paramString, j paramj)
  {
    AppMethodBeat.i(197935);
    this.zDA = paramString;
    this.zDB = new WeakReference(paramj);
    AppMethodBeat.o(197935);
  }
  
  public final void aC(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(197936);
    for (;;)
    {
      j localj;
      long l;
      try
      {
        ad.i("AdLandingNewH5Comp", "onGeoCallback is called!");
        str = this.zDA;
        localj = (j)this.zDB.get();
        if ((str == null) || (localj == null)) {
          break label344;
        }
        if (localj.lvH == null)
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
          localObject1 = ((x)localObject1).b(localj.hJc);
          if (localObject1 == null) {
            continue;
          }
          ad.d("AdLandingNewH5Comp", "the jsApiHandler is set from service");
          localj.lvH = ((f)localObject1);
        }
        catch (Throwable localThrowable1)
        {
          Object localObject1;
          Class localClass;
          Method localMethod;
          ad.e("AdLandingNewH5Comp", "ensureJsApiHandlerFromService has something wrong!!");
          continue;
        }
        localObject1 = localj.lvH;
        if (localObject1 != null) {}
      }
      catch (Throwable paramMap)
      {
        String str;
        ad.e("AdLandingNewH5Comp", "there is a exception in onGeoCallback");
        AppMethodBeat.o(197936);
        return;
      }
      try
      {
        l = SystemClock.currentThreadTimeMillis();
        localClass = localj.hJc.getClass();
        localMethod = j.aU(localClass);
        localObject1 = localMethod;
        if (localMethod == null)
        {
          ad.i("AdLandingNewH5Comp", "the js method is not found in getJsapiMethod, try to findJsapiMethod");
          localObject1 = j.aV(localClass);
        }
        if (localObject1 != null) {
          break label246;
        }
        ad.w("AdLandingNewH5Comp", "the js method is not found!");
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Object localObject2;
          ad.e("AdLandingNewH5Comp", "there is no getJsApiHandler method, the jsApiHandler object may be null!!");
          break;
          ad.w("AdLandingNewH5Comp", "the method return value is null ??");
        }
        ad.w("AdLandingNewH5Comp", "the js api handler is null!!");
      }
      localObject1 = localj.lvH;
      if (localObject1 != null)
      {
        ad.d("AdLandingNewH5Comp", "the js api handler is called!!");
        ((f)localObject1).a(str, "GEO", paramMap, true);
        AppMethodBeat.o(197936);
        return;
        ad.w("AdLandingNewH5Comp", "the jsApiHandler is null from service!");
        continue;
        label246:
        localObject2 = localThrowable1.invoke(localj.hJc, new Object[0]);
        if ((localObject2 instanceof f))
        {
          ad.i("AdLandingNewH5Comp", "the method return type is js api in ensureJsApiHandlerFromWebView");
          localj.lvH = ((f)localObject2);
          ad.i("AdLandingNewH5Comp", "get the js api handler takes : " + (SystemClock.currentThreadTimeMillis() - l));
          continue;
        }
      }
      label344:
      AppMethodBeat.o(197936);
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