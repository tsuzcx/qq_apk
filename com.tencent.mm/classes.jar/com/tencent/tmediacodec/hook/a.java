package com.tencent.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.g.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private static boolean ahTX;
  private static final Map<String, c> ahTY;
  
  static
  {
    AppMethodBeat.i(210874);
    ahTY = new ConcurrentHashMap();
    AppMethodBeat.o(210874);
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(210847);
    ahTY.put(paramString, paramc);
    if (b.isLogEnable())
    {
      new StringBuilder("after hookSurfaceCallback size:").append(ahTY.size()).append(" mHoldCallbackMap:").append(ahTY);
      b.O("HookManager");
    }
    if (!ahTX)
    {
      ahTX = true;
      THookTextureView.setHookCallback(new THookTextureView.a()
      {
        public final boolean z(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(210845);
          if (paramAnonymousSurfaceTexture == null)
          {
            AppMethodBeat.o(210845);
            return true;
          }
          Object localObject = paramAnonymousSurfaceTexture.toString();
          Iterator localIterator = a.aYC().keySet().iterator();
          while (localIterator.hasNext()) {
            if (TextUtils.equals((String)localIterator.next(), (CharSequence)localObject))
            {
              localObject = (c)a.aYC().get(localObject);
              if (localObject != null) {
                ((c)localObject).x(paramAnonymousSurfaceTexture);
              }
              AppMethodBeat.o(210845);
              return false;
            }
          }
          AppMethodBeat.o(210845);
          return true;
        }
      });
    }
    AppMethodBeat.o(210847);
  }
  
  public static void bGs(String paramString)
  {
    AppMethodBeat.i(210855);
    ahTY.remove(paramString);
    AppMethodBeat.o(210855);
  }
  
  public static void y(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(210862);
    try
    {
      "realReleaseSurfaceTexture surfaceTexture:".concat(String.valueOf(paramSurfaceTexture));
      b.R("HookManager");
      bGs(paramSurfaceTexture.toString());
      paramSurfaceTexture.release();
      AppMethodBeat.o(210862);
      return;
    }
    finally
    {
      new StringBuilder("realReleaseSurfaceTexture surfaceTexture:").append(paramSurfaceTexture).append(" ignoreThrowable");
      b.S("HookManager");
      AppMethodBeat.o(210862);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.a
 * JD-Core Version:    0.7.0.1
 */