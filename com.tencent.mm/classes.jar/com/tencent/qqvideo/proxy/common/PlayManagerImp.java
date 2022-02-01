package com.tencent.qqvideo.proxy.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.qqvideo.proxy.httpproxy.HttpproxyFacade;

public class PlayManagerImp
  implements IPlayManager
{
  private static String TAG = "TV_Httpproxy";
  private static boolean mbSoLoadSuccess = false;
  private ConfigStorage mConfigStorageInstance;
  private HttpproxyFacade proxy;
  
  public PlayManagerImp()
  {
    AppMethodBeat.i(89682);
    this.proxy = null;
    this.mConfigStorageInstance = new ConfigStorage();
    this.proxy = HttpproxyFacade.instance();
    AppMethodBeat.o(89682);
  }
  
  private static boolean isWifiOn(Context paramContext)
  {
    AppMethodBeat.i(89683);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(89683);
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(89683);
      return false;
    }
    if (paramContext.getType() == 1)
    {
      AppMethodBeat.o(89683);
      return true;
    }
    AppMethodBeat.o(89683);
    return false;
  }
  
  public void appToBack()
  {
    try
    {
      AppMethodBeat.i(89691);
      try
      {
        this.proxy.pushEvent(4);
        AppMethodBeat.o(89691);
      }
      finally
      {
        for (;;)
        {
          localObject1 = finally;
          HttpproxyFacade.print(6, TAG, "error ,appToBack native not found");
          AppMethodBeat.o(89691);
        }
      }
      return;
    }
    finally {}
  }
  
  public void appToFront()
  {
    try
    {
      AppMethodBeat.i(89690);
      try
      {
        this.proxy.pushEvent(3);
        AppMethodBeat.o(89690);
      }
      finally
      {
        for (;;)
        {
          localObject1 = finally;
          HttpproxyFacade.print(6, TAG, "error ,appToFront native not found");
          AppMethodBeat.o(89690);
        }
      }
      return;
    }
    finally {}
  }
  
  public String buildPlayURLMp4(int paramInt)
  {
    try
    {
      AppMethodBeat.i(89686);
      try
      {
        str1 = this.proxy.buildPlayURL(paramInt);
        AppMethodBeat.o(89686);
      }
      finally
      {
        for (;;)
        {
          String str1;
          localObject1 = finally;
          HttpproxyFacade.print(6, TAG, "error ,buildPlayURL native not found");
          String str2 = "";
          AppMethodBeat.o(89686);
        }
      }
      return str1;
    }
    finally {}
  }
  
  public int cleanStorage()
  {
    try
    {
      AppMethodBeat.i(89702);
      try
      {
        i = this.proxy.cleanStorage();
        AppMethodBeat.o(89702);
      }
      finally
      {
        for (;;)
        {
          localObject1 = finally;
          HttpproxyFacade.print(6, TAG, "error ,cleanStorage native not found");
          int i = -1;
          AppMethodBeat.o(89702);
        }
      }
      return i;
    }
    finally {}
  }
  
  public void deinit()
  {
    try
    {
      AppMethodBeat.i(89685);
      try
      {
        this.mConfigStorageInstance.stopGetServerConfig();
        this.proxy.deinit();
        AppMethodBeat.o(89685);
      }
      finally
      {
        for (;;)
        {
          localObject1 = finally;
          HttpproxyFacade.print(6, TAG, "error ,deinit native not found");
          AppMethodBeat.o(89685);
        }
      }
      return;
    }
    finally {}
  }
  
  public int getCurrentOffset(int paramInt)
  {
    try
    {
      AppMethodBeat.i(89697);
      try
      {
        paramInt = this.proxy.getCurrentOffset(paramInt);
        AppMethodBeat.o(89697);
      }
      finally
      {
        for (;;)
        {
          localObject1 = finally;
          HttpproxyFacade.print(6, TAG, "error ,getCurrentOffset native not found");
          paramInt = 0;
          AppMethodBeat.o(89697);
        }
      }
      return paramInt;
    }
    finally {}
  }
  
  public int getLocalServerPort()
  {
    try
    {
      AppMethodBeat.i(89700);
      try
      {
        i = this.proxy.getLocalServerPort();
        AppMethodBeat.o(89700);
      }
      finally
      {
        for (;;)
        {
          localObject1 = finally;
          HttpproxyFacade.print(6, TAG, "error ,getLocalServerPort native not found");
          int i = -1;
          AppMethodBeat.o(89700);
        }
      }
      return i;
    }
    finally {}
  }
  
  public String getProxyVersion()
  {
    try
    {
      AppMethodBeat.i(89692);
      try
      {
        str1 = this.proxy.getVersion();
        AppMethodBeat.o(89692);
      }
      finally
      {
        for (;;)
        {
          String str1;
          localObject1 = finally;
          HttpproxyFacade.print(6, TAG, "error ,getProxyVersion native not found");
          String str2 = "TVHttpproxy.1.0.0.0000";
          AppMethodBeat.o(89692);
        }
      }
      return str1;
    }
    finally {}
  }
  
  public int getTotalOffset(int paramInt)
  {
    try
    {
      AppMethodBeat.i(89698);
      try
      {
        paramInt = this.proxy.getTotalOffset(paramInt);
        AppMethodBeat.o(89698);
      }
      finally
      {
        for (;;)
        {
          localObject1 = finally;
          HttpproxyFacade.print(6, TAG, "error ,getTotalOffset native not found");
          paramInt = 0;
          AppMethodBeat.o(89698);
        }
      }
      return paramInt;
    }
    finally {}
  }
  
  /* Error */
  public int init(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 144
    //   6: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: ifnonnull +12 -> 22
    //   13: ldc 144
    //   15: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_3
    //   21: ireturn
    //   22: aload_0
    //   23: getfield 35	com/tencent/qqvideo/proxy/common/PlayManagerImp:proxy	Lcom/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade;
    //   26: ifnull +7 -> 33
    //   29: aload_1
    //   30: invokestatic 148	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:setContext	(Landroid/content/Context;)V
    //   33: getstatic 22	com/tencent/qqvideo/proxy/common/PlayManagerImp:mbSoLoadSuccess	Z
    //   36: istore 5
    //   38: iload 5
    //   40: ifne +21 -> 61
    //   43: ldc 150
    //   45: ldc 2
    //   47: invokevirtual 156	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   50: aload_1
    //   51: invokestatic 162	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:load	(Ljava/lang/String;Ljava/lang/ClassLoader;Landroid/content/Context;)V
    //   54: invokestatic 165	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:setupBrokenLibraryHandler	()V
    //   57: iconst_1
    //   58: putstatic 22	com/tencent/qqvideo/proxy/common/PlayManagerImp:mbSoLoadSuccess	Z
    //   61: aload_1
    //   62: invokestatic 169	com/tencent/qqvideo/proxy/common/ConfigStorage:getDownProxyConfig	(Landroid/content/Context;)Ljava/lang/String;
    //   65: astore 7
    //   67: aload_0
    //   68: getfield 40	com/tencent/qqvideo/proxy/common/PlayManagerImp:mConfigStorageInstance	Lcom/tencent/qqvideo/proxy/common/ConfigStorage;
    //   71: aload_1
    //   72: invokevirtual 172	com/tencent/qqvideo/proxy/common/ConfigStorage:synGetServerConfig	(Landroid/content/Context;)V
    //   75: aload_2
    //   76: astore 6
    //   78: aload_2
    //   79: ifnonnull +7 -> 86
    //   82: ldc 97
    //   84: astore 6
    //   86: aload_0
    //   87: getfield 35	com/tencent/qqvideo/proxy/common/PlayManagerImp:proxy	Lcom/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade;
    //   90: aload 6
    //   92: aload 7
    //   94: invokevirtual 175	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:init	(Ljava/lang/String;Ljava/lang/String;)I
    //   97: istore 4
    //   99: aload_1
    //   100: invokestatic 177	com/tencent/qqvideo/proxy/common/PlayManagerImp:isWifiOn	(Landroid/content/Context;)Z
    //   103: ifne +11 -> 114
    //   106: aload_0
    //   107: getfield 35	com/tencent/qqvideo/proxy/common/PlayManagerImp:proxy	Lcom/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade;
    //   110: iconst_2
    //   111: invokevirtual 180	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:setNetWorkState	(I)V
    //   114: ldc 144
    //   116: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: iload 4
    //   121: istore_3
    //   122: goto -104 -> 18
    //   125: astore_1
    //   126: iconst_0
    //   127: putstatic 22	com/tencent/qqvideo/proxy/common/PlayManagerImp:mbSoLoadSuccess	Z
    //   130: ldc 144
    //   132: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: goto -117 -> 18
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    //   143: astore_1
    //   144: ldc 144
    //   146: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: goto -131 -> 18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	PlayManagerImp
    //   0	152	1	paramContext	Context
    //   0	152	2	paramString	String
    //   1	121	3	i	int
    //   97	23	4	j	int
    //   36	3	5	bool	boolean
    //   76	15	6	str1	String
    //   65	28	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   43	61	125	finally
    //   4	9	138	finally
    //   13	18	138	finally
    //   22	33	138	finally
    //   33	38	138	finally
    //   114	119	138	finally
    //   126	135	138	finally
    //   144	149	138	finally
    //   61	75	143	finally
    //   86	114	143	finally
  }
  
  public int preLoad(int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(89696);
      try
      {
        paramInt1 = this.proxy.preLoad(paramInt1, paramInt2);
        AppMethodBeat.o(89696);
      }
      finally
      {
        for (;;)
        {
          localObject1 = finally;
          HttpproxyFacade.print(6, TAG, "error ,preLoad native not found");
          paramInt1 = -1;
          AppMethodBeat.o(89696);
        }
      }
      return paramInt1;
    }
    finally {}
  }
  
  public void setCookie(String paramString)
  {
    try
    {
      AppMethodBeat.i(89689);
      try
      {
        this.proxy.setCookie(paramString);
        AppMethodBeat.o(89689);
      }
      finally
      {
        for (;;)
        {
          paramString = finally;
          HttpproxyFacade.print(6, TAG, "error ,setCookie native not found");
          AppMethodBeat.o(89689);
        }
      }
      return;
    }
    finally {}
  }
  
  public int setMaxStorageSize(long paramLong)
  {
    try
    {
      AppMethodBeat.i(89701);
      try
      {
        i = this.proxy.setMaxStorageSize(paramLong);
        AppMethodBeat.o(89701);
      }
      finally
      {
        for (;;)
        {
          localObject1 = finally;
          HttpproxyFacade.print(6, TAG, "error ,setMaxStorageSize native not found");
          int i = -1;
          AppMethodBeat.o(89701);
        }
      }
      return i;
    }
    finally {}
  }
  
  public void setNetWorkState(int paramInt)
  {
    try
    {
      AppMethodBeat.i(89693);
      "setNetWorkState".concat(String.valueOf(paramInt));
      try
      {
        this.proxy.setNetWorkState(paramInt);
        AppMethodBeat.o(89693);
      }
      finally
      {
        for (;;)
        {
          localObject1 = finally;
          HttpproxyFacade.print(6, TAG, "error ,setNetWorkStatus native not found");
          AppMethodBeat.o(89693);
        }
      }
      return;
    }
    finally {}
  }
  
  public void setPlayerState(int paramInt)
  {
    try
    {
      AppMethodBeat.i(89694);
      "setPlayerState".concat(String.valueOf(paramInt));
      try
      {
        this.proxy.setPlayerState(paramInt);
        AppMethodBeat.o(89694);
      }
      finally
      {
        for (;;)
        {
          localObject1 = finally;
          HttpproxyFacade.print(6, TAG, "error ,setPlayState native not found");
          AppMethodBeat.o(89694);
        }
      }
      return;
    }
    finally {}
  }
  
  public void setRemainTime(int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(89699);
      try
      {
        this.proxy.setRemainTime(paramInt1, paramInt2);
        AppMethodBeat.o(89699);
      }
      finally
      {
        for (;;)
        {
          localObject1 = finally;
          HttpproxyFacade.print(6, TAG, "error ,getTotalOffset native not found");
          AppMethodBeat.o(89699);
        }
      }
      return;
    }
    finally {}
  }
  
  public void setUtilsObject(IUtils paramIUtils)
  {
    try
    {
      AppMethodBeat.i(89688);
      try
      {
        this.proxy.setUtils(paramIUtils);
        AppMethodBeat.o(89688);
      }
      finally
      {
        for (;;)
        {
          paramIUtils = finally;
          HttpproxyFacade.print(6, TAG, "error ,setUtilsObject native not found");
          AppMethodBeat.o(89688);
        }
      }
      return;
    }
    finally {}
  }
  
  public int startPlay(String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(89695);
      try
      {
        paramInt1 = this.proxy.startPlay(paramString1, paramInt1, paramString2, paramLong, paramInt2);
        AppMethodBeat.o(89695);
      }
      finally
      {
        for (;;)
        {
          paramString1 = finally;
          HttpproxyFacade.print(6, TAG, "error ,startPlay native not found");
          paramInt1 = -1;
          AppMethodBeat.o(89695);
        }
      }
      return paramInt1;
    }
    finally {}
  }
  
  public void stopPlay(int paramInt)
  {
    try
    {
      AppMethodBeat.i(89687);
      try
      {
        this.proxy.stopPlay(paramInt);
        AppMethodBeat.o(89687);
      }
      finally
      {
        for (;;)
        {
          localObject1 = finally;
          HttpproxyFacade.print(6, TAG, "error ,stopPlay native not found");
          AppMethodBeat.o(89687);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqvideo.proxy.common.PlayManagerImp
 * JD-Core Version:    0.7.0.1
 */