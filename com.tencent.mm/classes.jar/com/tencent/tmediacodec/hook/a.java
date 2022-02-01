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
  private static boolean Sml;
  private static final Map<String, c> Smm;
  
  static
  {
    AppMethodBeat.i(190137);
    Smm = new ConcurrentHashMap();
    AppMethodBeat.o(190137);
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(190134);
    Smm.put(paramString, paramc);
    if (b.isLogEnable())
    {
      new StringBuilder("after hookSurfaceCallback size:").append(Smm.size()).append(" mHoldCallbackMap:").append(Smm);
      b.bqQ("HookManager");
    }
    if (!Sml)
    {
      Sml = true;
      THookTextureView.setHookCallback(new THookTextureView.a()
      {
        public final boolean u(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(190133);
          if (paramAnonymousSurfaceTexture == null)
          {
            AppMethodBeat.o(190133);
            return true;
          }
          Object localObject = paramAnonymousSurfaceTexture.toString();
          Iterator localIterator = a.Smm.keySet().iterator();
          while (localIterator.hasNext()) {
            if (TextUtils.equals((String)localIterator.next(), (CharSequence)localObject))
            {
              localObject = (c)a.Smm.get(localObject);
              if (localObject != null) {
                ((c)localObject).s(paramAnonymousSurfaceTexture);
              }
              AppMethodBeat.o(190133);
              return false;
            }
          }
          AppMethodBeat.o(190133);
          return true;
        }
      });
    }
    AppMethodBeat.o(190134);
  }
  
  public static void bqO(String paramString)
  {
    AppMethodBeat.i(190135);
    Smm.remove(paramString);
    AppMethodBeat.o(190135);
  }
  
  public static void t(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(190136);
    try
    {
      "realReleaseSurfaceTexture surfaceTexture:".concat(String.valueOf(paramSurfaceTexture));
      b.bqS("HookManager");
      bqO(paramSurfaceTexture.toString());
      paramSurfaceTexture.release();
      AppMethodBeat.o(190136);
      return;
    }
    catch (Throwable localThrowable)
    {
      new StringBuilder("realReleaseSurfaceTexture surfaceTexture:").append(paramSurfaceTexture).append(" ignoreThrowable");
      b.bqT("HookManager");
      AppMethodBeat.o(190136);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.a
 * JD-Core Version:    0.7.0.1
 */