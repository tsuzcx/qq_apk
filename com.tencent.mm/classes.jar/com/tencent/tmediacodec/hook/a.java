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
  private static boolean ZOW;
  private static final Map<String, c> ZOX;
  
  static
  {
    AppMethodBeat.i(224439);
    ZOX = new ConcurrentHashMap();
    AppMethodBeat.o(224439);
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(224433);
    ZOX.put(paramString, paramc);
    if (b.isLogEnable())
    {
      new StringBuilder("after hookSurfaceCallback size:").append(ZOX.size()).append(" mHoldCallbackMap:").append(ZOX);
      b.bDP("HookManager");
    }
    if (!ZOW)
    {
      ZOW = true;
      THookTextureView.setHookCallback(new THookTextureView.a()
      {
        public final boolean x(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(224429);
          if (paramAnonymousSurfaceTexture == null)
          {
            AppMethodBeat.o(224429);
            return true;
          }
          Object localObject = paramAnonymousSurfaceTexture.toString();
          Iterator localIterator = a.ZOX.keySet().iterator();
          while (localIterator.hasNext()) {
            if (TextUtils.equals((String)localIterator.next(), (CharSequence)localObject))
            {
              localObject = (c)a.ZOX.get(localObject);
              if (localObject != null) {
                ((c)localObject).v(paramAnonymousSurfaceTexture);
              }
              AppMethodBeat.o(224429);
              return false;
            }
          }
          AppMethodBeat.o(224429);
          return true;
        }
      });
    }
    AppMethodBeat.o(224433);
  }
  
  public static void bDN(String paramString)
  {
    AppMethodBeat.i(224434);
    ZOX.remove(paramString);
    AppMethodBeat.o(224434);
  }
  
  public static void w(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(224437);
    try
    {
      "realReleaseSurfaceTexture surfaceTexture:".concat(String.valueOf(paramSurfaceTexture));
      b.bDR("HookManager");
      bDN(paramSurfaceTexture.toString());
      paramSurfaceTexture.release();
      AppMethodBeat.o(224437);
      return;
    }
    catch (Throwable localThrowable)
    {
      new StringBuilder("realReleaseSurfaceTexture surfaceTexture:").append(paramSurfaceTexture).append(" ignoreThrowable");
      b.bDS("HookManager");
      AppMethodBeat.o(224437);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.a
 * JD-Core Version:    0.7.0.1
 */