package com.tencent.wxa.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.b.a;
import com.tencent.wxa.c.2;
import com.tencent.wxa.c.a;
import com.tencent.wxa.c.a;
import io.flutter.plugin.common.MethodCall;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends com.tencent.wxa.b
{
  public final b.a a(MethodCall paramMethodCall)
  {
    AppMethodBeat.i(210523);
    Object localObject = paramMethodCall.method;
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramMethodCall = keP();
        AppMethodBeat.o(210523);
        return paramMethodCall;
        if (((String)localObject).equals("updatePopGestureEnable"))
        {
          i = 0;
          continue;
          if (((String)localObject).equals("onStageEmpty")) {
            i = 1;
          }
        }
        break;
      }
    }
    localObject = (HashMap)paramMethodCall.arguments;
    paramMethodCall = (String)((Map)localObject).get("activityId");
    boolean bool = ((Boolean)((Map)localObject).get("isPopGestureEnabled")).booleanValue();
    localObject = com.tencent.wxa.c.keQ();
    a.i("WxaRouter.WxaRouter", "appIsPause activityId:%s isPopGestureEnabled:%b", new Object[] { paramMethodCall, Boolean.valueOf(bool) });
    if (((com.tencent.wxa.c)localObject).aids.containsKey(paramMethodCall)) {
      ((com.tencent.wxa.b.b)((com.tencent.wxa.c)localObject).aids.get(paramMethodCall)).cG(bool);
    }
    paramMethodCall = hl(Boolean.TRUE);
    AppMethodBeat.o(210523);
    return paramMethodCall;
    i = ((Integer)((HashMap)paramMethodCall.arguments).get("engineId")).intValue();
    paramMethodCall = com.tencent.wxa.c.keQ();
    if (c.a.i(paramMethodCall.aidn).booleanValue())
    {
      a.i("WxaRouter.WxaRouter", "tryReleaseDefaultEngine success.", new Object[0]);
      paramMethodCall.handler.post(new c.2(paramMethodCall, i));
    }
    for (;;)
    {
      paramMethodCall = hl(Boolean.TRUE);
      AppMethodBeat.o(210523);
      return paramMethodCall;
      a.i("WxaRouter.WxaRouter", "tryReleaseDefaultEngine fail. isReleaseDefaultEngineWhenEmptyView is false.", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wxa.a.c
 * JD-Core Version:    0.7.0.1
 */