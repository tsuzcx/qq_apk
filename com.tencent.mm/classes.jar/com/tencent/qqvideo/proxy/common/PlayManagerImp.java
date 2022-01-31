package com.tencent.qqvideo.proxy.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.qqvideo.proxy.httpproxy.HttpproxyFacade;
import com.tencent.qqvideo.proxy.httpproxy.TVHttpProxyLoadLibrary;

public class PlayManagerImp
  implements IPlayManager
{
  private static String TAG = "TV_Httpproxy";
  private static boolean mbSoLoadSuccess = false;
  private ConfigStorage mConfigStorageInstance;
  private HttpproxyFacade proxy;
  
  public PlayManagerImp()
  {
    AppMethodBeat.i(124408);
    this.proxy = null;
    this.mConfigStorageInstance = new ConfigStorage();
    this.proxy = HttpproxyFacade.instance();
    AppMethodBeat.o(124408);
  }
  
  private static boolean isWifiOn(Context paramContext)
  {
    AppMethodBeat.i(124409);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(124409);
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(124409);
      return false;
    }
    if (paramContext.getType() == 1)
    {
      AppMethodBeat.o(124409);
      return true;
    }
    AppMethodBeat.o(124409);
    return false;
  }
  
  public void appToBack()
  {
    try
    {
      AppMethodBeat.i(124417);
      try
      {
        this.proxy.pushEvent(4);
        AppMethodBeat.o(124417);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          HttpproxyFacade.print(6, TAG, "error ,appToBack native not found");
          AppMethodBeat.o(124417);
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
      AppMethodBeat.i(124416);
      try
      {
        this.proxy.pushEvent(3);
        AppMethodBeat.o(124416);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          HttpproxyFacade.print(6, TAG, "error ,appToFront native not found");
          AppMethodBeat.o(124416);
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
      AppMethodBeat.i(124412);
      try
      {
        str1 = this.proxy.buildPlayURL(paramInt);
        AppMethodBeat.o(124412);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          String str1;
          HttpproxyFacade.print(6, TAG, "error ,buildPlayURL native not found");
          String str2 = "";
          AppMethodBeat.o(124412);
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
      AppMethodBeat.i(124428);
      try
      {
        i = this.proxy.cleanStorage();
        AppMethodBeat.o(124428);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          HttpproxyFacade.print(6, TAG, "error ,cleanStorage native not found");
          int i = -1;
          AppMethodBeat.o(124428);
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
      AppMethodBeat.i(124411);
      try
      {
        this.mConfigStorageInstance.stopGetServerConfig();
        this.proxy.deinit();
        AppMethodBeat.o(124411);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          HttpproxyFacade.print(6, TAG, "error ,deinit native not found");
          AppMethodBeat.o(124411);
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
      AppMethodBeat.i(124423);
      try
      {
        paramInt = this.proxy.getCurrentOffset(paramInt);
        AppMethodBeat.o(124423);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          HttpproxyFacade.print(6, TAG, "error ,getCurrentOffset native not found");
          paramInt = 0;
          AppMethodBeat.o(124423);
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
      AppMethodBeat.i(124426);
      try
      {
        i = this.proxy.getLocalServerPort();
        AppMethodBeat.o(124426);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          HttpproxyFacade.print(6, TAG, "error ,getLocalServerPort native not found");
          int i = -1;
          AppMethodBeat.o(124426);
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
      AppMethodBeat.i(124418);
      try
      {
        str1 = this.proxy.getVersion();
        AppMethodBeat.o(124418);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          String str1;
          HttpproxyFacade.print(6, TAG, "error ,getProxyVersion native not found");
          String str2 = "TVHttpproxy.1.0.0.0000";
          AppMethodBeat.o(124418);
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
      AppMethodBeat.i(124424);
      try
      {
        paramInt = this.proxy.getTotalOffset(paramInt);
        AppMethodBeat.o(124424);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          HttpproxyFacade.print(6, TAG, "error ,getTotalOffset native not found");
          paramInt = 0;
          AppMethodBeat.o(124424);
        }
      }
      return paramInt;
    }
    finally {}
  }
  
  public int init(Context paramContext, String paramString)
  {
    int i = -1;
    try
    {
      AppMethodBeat.i(124410);
      if (paramContext == null) {
        AppMethodBeat.o(124410);
      }
      for (;;)
      {
        return i;
        if (this.proxy != null) {
          HttpproxyFacade.setContext(paramContext);
        }
        boolean bool = mbSoLoadSuccess;
        if (!bool) {}
        try
        {
          TVHttpProxyLoadLibrary.load("wxhttpproxy", PlayManagerImp.class.getClassLoader(), paramContext);
          TVHttpProxyLoadLibrary.setupBrokenLibraryHandler();
          mbSoLoadSuccess = true;
        }
        catch (Throwable paramContext)
        {
          try
          {
            String str2 = ConfigStorage.getDownProxyConfig(paramContext);
            this.mConfigStorageInstance.synGetServerConfig(paramContext);
            String str1 = paramString;
            if (paramString == null) {
              str1 = "";
            }
            int j = this.proxy.init(str1, str2);
            if (!isWifiOn(paramContext)) {
              this.proxy.setNetWorkState(2);
            }
            AppMethodBeat.o(124410);
            i = j;
          }
          catch (Throwable paramContext)
          {
            AppMethodBeat.o(124410);
          }
          paramContext = paramContext;
          mbSoLoadSuccess = false;
          AppMethodBeat.o(124410);
        }
      }
    }
    finally {}
  }
  
  public int preLoad(int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(124422);
      try
      {
        paramInt1 = this.proxy.preLoad(paramInt1, paramInt2);
        AppMethodBeat.o(124422);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          HttpproxyFacade.print(6, TAG, "error ,preLoad native not found");
          paramInt1 = -1;
          AppMethodBeat.o(124422);
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
      AppMethodBeat.i(124415);
      try
      {
        this.proxy.setCookie(paramString);
        AppMethodBeat.o(124415);
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          HttpproxyFacade.print(6, TAG, "error ,setCookie native not found");
          AppMethodBeat.o(124415);
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
      AppMethodBeat.i(124427);
      try
      {
        i = this.proxy.setMaxStorageSize(paramLong);
        AppMethodBeat.o(124427);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          HttpproxyFacade.print(6, TAG, "error ,setMaxStorageSize native not found");
          int i = -1;
          AppMethodBeat.o(124427);
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
      AppMethodBeat.i(124419);
      "setNetWorkState".concat(String.valueOf(paramInt));
      try
      {
        this.proxy.setNetWorkState(paramInt);
        AppMethodBeat.o(124419);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          HttpproxyFacade.print(6, TAG, "error ,setNetWorkStatus native not found");
          AppMethodBeat.o(124419);
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
      AppMethodBeat.i(124420);
      "setPlayerState".concat(String.valueOf(paramInt));
      try
      {
        this.proxy.setPlayerState(paramInt);
        AppMethodBeat.o(124420);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          HttpproxyFacade.print(6, TAG, "error ,setPlayState native not found");
          AppMethodBeat.o(124420);
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
      AppMethodBeat.i(124425);
      try
      {
        this.proxy.setRemainTime(paramInt1, paramInt2);
        AppMethodBeat.o(124425);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          HttpproxyFacade.print(6, TAG, "error ,getTotalOffset native not found");
          AppMethodBeat.o(124425);
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
      AppMethodBeat.i(124414);
      try
      {
        this.proxy.setUtils(paramIUtils);
        AppMethodBeat.o(124414);
      }
      catch (Throwable paramIUtils)
      {
        for (;;)
        {
          HttpproxyFacade.print(6, TAG, "error ,setUtilsObject native not found");
          AppMethodBeat.o(124414);
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
      AppMethodBeat.i(124421);
      try
      {
        paramInt1 = this.proxy.startPlay(paramString1, paramInt1, paramString2, paramLong, paramInt2);
        AppMethodBeat.o(124421);
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          HttpproxyFacade.print(6, TAG, "error ,startPlay native not found");
          paramInt1 = -1;
          AppMethodBeat.o(124421);
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
      AppMethodBeat.i(124413);
      try
      {
        this.proxy.stopPlay(paramInt);
        AppMethodBeat.o(124413);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          HttpproxyFacade.print(6, TAG, "error ,stopPlay native not found");
          AppMethodBeat.o(124413);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqvideo.proxy.common.PlayManagerImp
 * JD-Core Version:    0.7.0.1
 */