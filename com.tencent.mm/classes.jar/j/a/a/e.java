package j.a.a;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.SoundPool;
import android.media.SoundPool.Builder;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e
  extends b
{
  private static Map<Integer, e> UpR;
  private static Map<String, List<e>> UpS;
  private static SoundPool yRy;
  private final String UpK;
  private String UpO = "speakers";
  private final a UpQ;
  private Integer UpT;
  private Integer UpU;
  private boolean UpV = false;
  private boolean aWP = false;
  private boolean bfW = false;
  private float rate = 1.0F;
  private boolean tN = false;
  private String url;
  private float volume = 1.0F;
  
  static
  {
    AppMethodBeat.i(204549);
    if (Build.VERSION.SDK_INT >= 21) {
      localObject = new AudioAttributes.Builder().setLegacyStreamType(-2147483648).setUsage(14).build();
    }
    for (Object localObject = new SoundPool.Builder().setAudioAttributes((AudioAttributes)localObject).setMaxStreams(100).build();; localObject = new SoundPool(1, 3, 1))
    {
      yRy = (SoundPool)localObject;
      ((SoundPool)localObject).setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener()
      {
        public final void onLoadComplete(SoundPool arg1, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(204531);
          Object localObject1 = (e)e.UpR.get(Integer.valueOf(paramAnonymousInt1));
          if (localObject1 != null)
          {
            e.UpR.remove(e.a((e)localObject1));
            synchronized (e.apc())
            {
              localObject1 = ((List)e.apc().get(e.b((e)localObject1))).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                e locale = (e)((Iterator)localObject1).next();
                new StringBuilder("Marking ").append(locale).append(" as loaded");
                e.c(locale);
                if (e.d(locale))
                {
                  new StringBuilder("Delayed start of ").append(locale);
                  e.e(locale);
                }
              }
            }
            AppMethodBeat.o(204531);
            return;
          }
          AppMethodBeat.o(204531);
        }
      });
      UpR = Collections.synchronizedMap(new HashMap());
      UpS = Collections.synchronizedMap(new HashMap());
      AppMethodBeat.o(204549);
      return;
    }
  }
  
  e(a parama, String paramString)
  {
    this.UpQ = parama;
    this.UpK = paramString;
  }
  
  /* Error */
  private static File bvw(String paramString)
  {
    // Byte code:
    //   0: ldc 143
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_0
    //   8: invokestatic 149	java/net/URI:create	(Ljava/lang/String;)Ljava/net/URI;
    //   11: invokevirtual 153	java/net/URI:toURL	()Ljava/net/URL;
    //   14: invokestatic 157	j/a/a/e:g	(Ljava/net/URL;)[B
    //   17: astore_3
    //   18: ldc 159
    //   20: ldc 161
    //   22: invokestatic 167	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   25: astore 4
    //   27: new 169	java/io/FileOutputStream
    //   30: dup
    //   31: aload 4
    //   33: invokespecial 172	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   36: astore_1
    //   37: aload_1
    //   38: astore_0
    //   39: aload_1
    //   40: aload_3
    //   41: invokevirtual 176	java/io/FileOutputStream:write	([B)V
    //   44: aload_1
    //   45: astore_0
    //   46: aload 4
    //   48: invokevirtual 179	java/io/File:deleteOnExit	()V
    //   51: aload_1
    //   52: invokevirtual 182	java/io/FileOutputStream:close	()V
    //   55: ldc 143
    //   57: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload 4
    //   62: areturn
    //   63: astore_0
    //   64: new 184	java/lang/RuntimeException
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 187	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   72: astore_0
    //   73: ldc 143
    //   75: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_0
    //   79: athrow
    //   80: astore_2
    //   81: aconst_null
    //   82: astore_1
    //   83: aload_1
    //   84: astore_0
    //   85: new 184	java/lang/RuntimeException
    //   88: dup
    //   89: aload_2
    //   90: invokespecial 187	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   93: astore_2
    //   94: aload_1
    //   95: astore_0
    //   96: ldc 143
    //   98: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aload_1
    //   102: astore_0
    //   103: aload_2
    //   104: athrow
    //   105: astore_2
    //   106: aload_0
    //   107: astore_1
    //   108: aload_2
    //   109: astore_0
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 182	java/io/FileOutputStream:close	()V
    //   118: ldc 143
    //   120: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aload_0
    //   124: athrow
    //   125: astore_0
    //   126: new 184	java/lang/RuntimeException
    //   129: dup
    //   130: aload_0
    //   131: invokespecial 187	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   134: astore_0
    //   135: ldc 143
    //   137: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_0
    //   141: athrow
    //   142: astore_0
    //   143: aload_2
    //   144: astore_1
    //   145: goto -35 -> 110
    //   148: astore_2
    //   149: goto -66 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramString	String
    //   36	109	1	localObject1	Object
    //   6	1	2	localObject2	Object
    //   80	10	2	localIOException1	java.io.IOException
    //   93	11	2	localRuntimeException	java.lang.RuntimeException
    //   105	39	2	localObject3	Object
    //   148	1	2	localIOException2	java.io.IOException
    //   17	24	3	arrayOfByte	byte[]
    //   25	36	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   51	55	63	java/io/IOException
    //   7	37	80	java/io/IOException
    //   39	44	105	finally
    //   46	51	105	finally
    //   85	94	105	finally
    //   96	101	105	finally
    //   103	105	105	finally
    //   114	118	125	java/io/IOException
    //   7	37	142	finally
    //   39	44	148	java/io/IOException
    //   46	51	148	java/io/IOException
  }
  
  private static UnsupportedOperationException bvx(String paramString)
  {
    AppMethodBeat.i(204547);
    paramString = new UnsupportedOperationException("LOW_LATENCY mode does not support: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(204547);
    return paramString;
  }
  
  /* Error */
  private static byte[] g(java.net.URL paramURL)
  {
    // Byte code:
    //   0: ldc 217
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 219	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 220	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore 6
    //   14: aconst_null
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 4
    //   20: aload 4
    //   22: astore_3
    //   23: aload 5
    //   25: astore_2
    //   26: sipush 4096
    //   29: newarray byte
    //   31: astore 7
    //   33: aload 4
    //   35: astore_3
    //   36: aload 5
    //   38: astore_2
    //   39: aload_0
    //   40: invokevirtual 226	java/net/URL:openStream	()Ljava/io/InputStream;
    //   43: astore_0
    //   44: aload_0
    //   45: astore_3
    //   46: aload_0
    //   47: astore_2
    //   48: aload_0
    //   49: aload 7
    //   51: invokevirtual 232	java/io/InputStream:read	([B)I
    //   54: istore_1
    //   55: iload_1
    //   56: ifle +54 -> 110
    //   59: aload_0
    //   60: astore_3
    //   61: aload_0
    //   62: astore_2
    //   63: aload 6
    //   65: aload 7
    //   67: iconst_0
    //   68: iload_1
    //   69: invokevirtual 235	java/io/ByteArrayOutputStream:write	([BII)V
    //   72: goto -28 -> 44
    //   75: astore_0
    //   76: aload_3
    //   77: astore_2
    //   78: new 184	java/lang/RuntimeException
    //   81: dup
    //   82: aload_0
    //   83: invokespecial 187	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   86: astore_0
    //   87: aload_3
    //   88: astore_2
    //   89: ldc 217
    //   91: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_3
    //   95: astore_2
    //   96: aload_0
    //   97: athrow
    //   98: astore_0
    //   99: aload_2
    //   100: invokevirtual 236	java/io/InputStream:close	()V
    //   103: ldc 217
    //   105: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload_0
    //   109: athrow
    //   110: aload_0
    //   111: invokevirtual 236	java/io/InputStream:close	()V
    //   114: aload 6
    //   116: invokevirtual 240	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   119: astore_0
    //   120: ldc 217
    //   122: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aload_0
    //   126: areturn
    //   127: astore_0
    //   128: new 184	java/lang/RuntimeException
    //   131: dup
    //   132: aload_0
    //   133: invokespecial 187	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   136: astore_0
    //   137: ldc 217
    //   139: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload_0
    //   143: athrow
    //   144: astore_0
    //   145: new 184	java/lang/RuntimeException
    //   148: dup
    //   149: aload_0
    //   150: invokespecial 187	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   153: astore_0
    //   154: ldc 217
    //   156: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload_0
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramURL	java.net.URL
    //   54	15	1	i	int
    //   25	75	2	localObject1	Object
    //   22	73	3	localObject2	Object
    //   18	16	4	localObject3	Object
    //   15	22	5	localObject4	Object
    //   12	103	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   31	35	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   26	33	75	java/io/IOException
    //   39	44	75	java/io/IOException
    //   48	55	75	java/io/IOException
    //   63	72	75	java/io/IOException
    //   26	33	98	finally
    //   39	44	98	finally
    //   48	55	98	finally
    //   63	72	98	finally
    //   78	87	98	finally
    //   89	94	98	finally
    //   96	98	98	finally
    //   110	114	127	java/io/IOException
    //   99	103	144	java/io/IOException
  }
  
  private void start()
  {
    AppMethodBeat.i(204544);
    P(this.rate);
    if (this.tN)
    {
      yRy.resume(this.UpU.intValue());
      this.tN = false;
      AppMethodBeat.o(204544);
      return;
    }
    SoundPool localSoundPool = yRy;
    int j = this.UpT.intValue();
    float f1 = this.volume;
    float f2 = this.volume;
    if (this.UpV) {}
    for (int i = -1;; i = 0)
    {
      this.UpU = Integer.valueOf(localSoundPool.play(j, f1, f2, 0, i, 1.0F));
      AppMethodBeat.o(204544);
      return;
    }
  }
  
  final int P(double paramDouble)
  {
    AppMethodBeat.i(204538);
    this.rate = ((float)paramDouble);
    if (this.UpU != null)
    {
      yRy.setRate(this.UpU.intValue(), this.rate);
      AppMethodBeat.o(204538);
      return 1;
    }
    AppMethodBeat.o(204538);
    return 0;
  }
  
  final void a(c paramc)
  {
    int i = 0;
    AppMethodBeat.i(204539);
    if (paramc == c.UpH) {}
    for (boolean bool = true;; bool = false)
    {
      this.UpV = bool;
      if (this.bfW)
      {
        paramc = yRy;
        int j = this.UpU.intValue();
        if (this.UpV) {
          i = -1;
        }
        paramc.setLoop(j, i);
      }
      AppMethodBeat.o(204539);
      return;
    }
  }
  
  final void a(String paramString, boolean paramBoolean, Context paramContext)
  {
    AppMethodBeat.i(204536);
    if ((this.url != null) && (this.url.equals(paramString)))
    {
      AppMethodBeat.o(204536);
      return;
    }
    if (this.UpT != null) {
      release();
    }
    synchronized (UpS)
    {
      this.url = paramString;
      paramContext = (List)UpS.get(paramString);
      if (paramContext != null)
      {
        localObject = (e)paramContext.get(0);
        this.UpT = ((e)localObject).UpT;
        this.aWP = ((e)localObject).aWP;
        paramContext.add(this);
        new StringBuilder("Reusing soundId").append(this.UpT).append(" for ").append(paramString).append(" is loading=").append(this.aWP).append(" ").append(this);
        AppMethodBeat.o(204536);
        return;
      }
      this.aWP = true;
      long l = System.currentTimeMillis();
      Object localObject = yRy;
      if (paramBoolean)
      {
        paramContext = paramString;
        this.UpT = Integer.valueOf(((SoundPool)localObject).load(paramContext, 1));
        new StringBuilder("time to call load() for ").append(paramString).append(": ").append(System.currentTimeMillis() - l).append(" player=").append(this);
        UpR.put(this.UpT, this);
        paramContext = new ArrayList();
        paramContext.add(this);
        UpS.put(paramString, paramContext);
        AppMethodBeat.o(204536);
        return;
      }
      paramContext = bvw(paramString).getAbsolutePath();
    }
  }
  
  final void a(boolean paramBoolean1, boolean paramBoolean2, Context paramContext) {}
  
  final String esX()
  {
    return this.UpK;
  }
  
  final int getCurrentPosition()
  {
    AppMethodBeat.i(204541);
    UnsupportedOperationException localUnsupportedOperationException = bvx("getCurrentPosition");
    AppMethodBeat.o(204541);
    throw localUnsupportedOperationException;
  }
  
  final int getDuration()
  {
    AppMethodBeat.i(204540);
    UnsupportedOperationException localUnsupportedOperationException = bvx("getDuration");
    AppMethodBeat.o(204540);
    throw localUnsupportedOperationException;
  }
  
  final boolean hRs()
  {
    return false;
  }
  
  final void mb(Context paramContext)
  {
    AppMethodBeat.i(204532);
    if (!this.aWP) {
      start();
    }
    this.bfW = true;
    AppMethodBeat.o(204532);
  }
  
  final void p(String paramString, Context paramContext)
  {
    AppMethodBeat.i(204542);
    paramString = bvx("setPlayingRoute");
    AppMethodBeat.o(204542);
    throw paramString;
  }
  
  final void pause()
  {
    AppMethodBeat.i(204535);
    if (this.bfW)
    {
      yRy.pause(this.UpU.intValue());
      this.bfW = false;
      this.tN = true;
    }
    AppMethodBeat.o(204535);
  }
  
  final void release()
  {
    AppMethodBeat.i(204534);
    stop();
    if ((this.UpT != null) && (this.url != null)) {
      synchronized (UpS)
      {
        List localList = (List)UpS.get(this.url);
        if (localList != null)
        {
          if ((localList.size() == 1) && (localList.get(0) == this))
          {
            UpS.remove(this.url);
            yRy.unload(this.UpT.intValue());
            UpR.remove(this.UpT);
            this.UpT = null;
            new StringBuilder("Unloaded soundId ").append(this.UpT);
          }
        }
        else
        {
          AppMethodBeat.o(204534);
          return;
        }
        localList.remove(this);
      }
    }
    AppMethodBeat.o(204534);
  }
  
  final void seek(int paramInt)
  {
    AppMethodBeat.i(204543);
    UnsupportedOperationException localUnsupportedOperationException = bvx("seek");
    AppMethodBeat.o(204543);
    throw localUnsupportedOperationException;
  }
  
  final void stop()
  {
    AppMethodBeat.i(204533);
    if (this.bfW)
    {
      yRy.stop(this.UpU.intValue());
      this.bfW = false;
    }
    this.tN = false;
    AppMethodBeat.o(204533);
  }
  
  final void u(double paramDouble)
  {
    AppMethodBeat.i(204537);
    this.volume = ((float)paramDouble);
    if (this.bfW) {
      yRy.setVolume(this.UpU.intValue(), this.volume, this.volume);
    }
    AppMethodBeat.o(204537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     j.a.a.e
 * JD-Core Version:    0.7.0.1
 */