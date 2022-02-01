package com.tencent.xweb.xwalk.updater;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.internal.b.c;
import com.tencent.xweb.util.b;
import com.tencent.xweb.util.l;
import org.xwalk.core.XWalkEnvironment;

public final class m
  extends n
{
  private static m airc;
  
  public static n kkp()
  {
    AppMethodBeat.i(213001);
    if (airc == null) {
      airc = new m();
    }
    m localm = airc;
    AppMethodBeat.o(213001);
    return localm;
  }
  
  public final d a(b.c paramc)
  {
    AppMethodBeat.i(213015);
    Object localObject;
    if (paramc != null)
    {
      localObject = a.keX().qM("pre_down_abi", "tools");
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, "onConfigDownLoaded, config version:" + paramc.aiiU + ", pre download abi:" + (String)localObject);
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equalsIgnoreCase(b.khw()))) {
        break label210;
      }
      paramc = new e().a(paramc, (String)localObject, this);
      if (paramc != null) {
        l.y(577L, 240L, 1L);
      }
    }
    for (;;)
    {
      int i = 0;
      if (paramc != null)
      {
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "onConfigDownLoaded, pre download version:" + paramc.version);
        i = 1;
      }
      localObject = d(paramc);
      if ((i != 0) && (localObject == paramc))
      {
        if (!"armeabi-v7a".equalsIgnoreCase(paramc.strAbi)) {
          break label178;
        }
        l.y(577L, 236L, 1L);
      }
      for (;;)
      {
        AppMethodBeat.o(213015);
        return localObject;
        label178:
        if ("arm64-v8a".equalsIgnoreCase(paramc.strAbi)) {
          l.y(577L, 237L, 1L);
        }
      }
      AppMethodBeat.o(213015);
      return null;
      label210:
      paramc = null;
    }
  }
  
  public final String kjo()
  {
    return "XWebCorePredown";
  }
  
  protected final boolean kkb()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.m
 * JD-Core Version:    0.7.0.1
 */