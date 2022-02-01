package com.tencent.mm.plugin.sns.ad.c;

import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c.a;
import com.tencent.mm.plugin.appbrand.service.o.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.util.Map;

final class c$1
  implements o.a
{
  c$1(View paramView) {}
  
  public final void b(WxaAttributes paramWxaAttributes)
  {
    final boolean bool = false;
    AppMethodBeat.i(219001);
    if (paramWxaAttributes == null)
    {
      ae.e("AdWeAppHelper", "onGetWeAppInfo, info==null");
      AppMethodBeat.o(219001);
      return;
    }
    try
    {
      i = paramWxaAttributes.beU().kcY.kaX;
      if (TextUtils.isEmpty(paramWxaAttributes.field_username)) {}
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          c.access$000().put(paramWxaAttributes.field_username, Integer.valueOf(i));
          Object localObject = this.znp.getTag();
          if (!(localObject instanceof String)) {
            break label259;
          }
          localObject = (String)localObject;
          if (!((String)localObject).equals(paramWxaAttributes.field_username)) {
            break;
          }
          ae.i("AdWeAppHelper", "onGetWeAppInfo, weAppName=" + (String)localObject + ", flag=" + i);
          if (i == 1) {
            bool = true;
          }
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(219000);
              if (bool)
              {
                c.1.this.znp.setVisibility(0);
                AppMethodBeat.o(219000);
                return;
              }
              if (c.1.this.znp.getVisibility() == 0) {
                c.1.this.znp.setVisibility(4);
              }
              AppMethodBeat.o(219000);
            }
          });
          AppMethodBeat.o(219001);
          return;
        }
        finally
        {
          int i;
          AppMethodBeat.o(219001);
        }
        localException = localException;
        ae.e("AdWeAppHelper", "onGetWeAppInfo, exp=" + localException.toString());
        i = 0;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder("onGetWeAppInfo, View reuse, view.name=").append(localException).append(", info.name=");
    if (paramWxaAttributes == null) {}
    for (paramWxaAttributes = "";; paramWxaAttributes = paramWxaAttributes.field_username)
    {
      ae.w("AdWeAppHelper", paramWxaAttributes);
      AppMethodBeat.o(219001);
      return;
    }
    label259:
    localStringBuilder = new StringBuilder("onGetWeAppInfo, View reuse, view.name=null, info.name=");
    if (paramWxaAttributes == null) {}
    for (paramWxaAttributes = "";; paramWxaAttributes = paramWxaAttributes.field_username)
    {
      ae.w("AdWeAppHelper", paramWxaAttributes);
      AppMethodBeat.o(219001);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c.c.1
 * JD-Core Version:    0.7.0.1
 */