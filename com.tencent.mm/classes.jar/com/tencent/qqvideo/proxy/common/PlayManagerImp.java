package com.tencent.qqvideo.proxy.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.qqvideo.proxy.httpproxy.HttpproxyFacade;
import com.tencent.qqvideo.proxy.httpproxy.TVHttpProxyLoadLibrary;

public class PlayManagerImp
  implements IPlayManager
{
  private static String TAG = "TV_Httpproxy";
  private static boolean mbSoLoadSuccess = false;
  private ConfigStorage mConfigStorageInstance = new ConfigStorage();
  private HttpproxyFacade proxy = null;
  
  private static boolean isWifiOn(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return false;
    }
    return paramContext.getType() == 1;
  }
  
  public void appToBack()
  {
    try
    {
      this.proxy.pushEvent(4);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        HttpproxyFacade.print(6, TAG, "error ,appToBack native not found");
      }
    }
    finally {}
  }
  
  public void appToFront()
  {
    try
    {
      this.proxy.pushEvent(3);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        HttpproxyFacade.print(6, TAG, "error ,appToFront native not found");
      }
    }
    finally {}
  }
  
  public String buildPlayURLMp4(int paramInt)
  {
    try
    {
      String str1 = this.proxy.buildPlayURL(paramInt);
      return str1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        HttpproxyFacade.print(6, TAG, "error ,buildPlayURL native not found");
        String str2 = "";
      }
    }
    finally {}
  }
  
  public int cleanStorage()
  {
    try
    {
      i = this.proxy.cleanStorage();
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        HttpproxyFacade.print(6, TAG, "error ,cleanStorage native not found");
        int i = -1;
      }
    }
    finally {}
  }
  
  public void deinit()
  {
    try
    {
      this.mConfigStorageInstance.stopGetServerConfig();
      this.proxy.deinit();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        HttpproxyFacade.print(6, TAG, "error ,deinit native not found");
      }
    }
    finally {}
  }
  
  public int getCurrentOffset(int paramInt)
  {
    try
    {
      paramInt = this.proxy.getCurrentOffset(paramInt);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        HttpproxyFacade.print(6, TAG, "error ,getCurrentOffset native not found");
        paramInt = 0;
      }
    }
    finally {}
  }
  
  public int getLocalServerPort()
  {
    try
    {
      i = this.proxy.getLocalServerPort();
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        HttpproxyFacade.print(6, TAG, "error ,getLocalServerPort native not found");
        int i = -1;
      }
    }
    finally {}
  }
  
  public String getProxyVersion()
  {
    try
    {
      String str1 = this.proxy.getVersion();
      return str1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        HttpproxyFacade.print(6, TAG, "error ,getProxyVersion native not found");
        String str2 = "TVHttpproxy.1.0.0.0000";
      }
    }
    finally {}
  }
  
  public int getTotalOffset(int paramInt)
  {
    try
    {
      paramInt = this.proxy.getTotalOffset(paramInt);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        HttpproxyFacade.print(6, TAG, "error ,getTotalOffset native not found");
        paramInt = 0;
      }
    }
    finally {}
  }
  
  public int init(Context paramContext, String paramString)
  {
    int i = -1;
    if (paramContext == null) {}
    for (;;)
    {
      return i;
      try
      {
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
            i = j;
          }
          catch (Throwable paramContext) {}
          paramContext = paramContext;
          mbSoLoadSuccess = false;
        }
      }
      finally {}
    }
  }
  
  public int preLoad(int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = this.proxy.preLoad(paramInt1, paramInt2);
      return paramInt1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        HttpproxyFacade.print(6, TAG, "error ,preLoad native not found");
        paramInt1 = -1;
      }
    }
    finally {}
  }
  
  public void setCookie(String paramString)
  {
    try
    {
      this.proxy.setCookie(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        HttpproxyFacade.print(6, TAG, "error ,setCookie native not found");
      }
    }
    finally {}
  }
  
  public int setMaxStorageSize(long paramLong)
  {
    try
    {
      i = this.proxy.setMaxStorageSize(paramLong);
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        HttpproxyFacade.print(6, TAG, "error ,setMaxStorageSize native not found");
        int i = -1;
      }
    }
    finally {}
  }
  
  public void setNetWorkState(int paramInt)
  {
    try
    {
      this.proxy.setNetWorkState(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        HttpproxyFacade.print(6, TAG, "error ,setNetWorkStatus native not found");
      }
    }
    finally {}
  }
  
  public void setPlayerState(int paramInt)
  {
    try
    {
      this.proxy.setPlayerState(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        HttpproxyFacade.print(6, TAG, "error ,setPlayState native not found");
      }
    }
    finally {}
  }
  
  public void setRemainTime(int paramInt1, int paramInt2)
  {
    try
    {
      this.proxy.setRemainTime(paramInt1, paramInt2);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        HttpproxyFacade.print(6, TAG, "error ,getTotalOffset native not found");
      }
    }
    finally {}
  }
  
  public void setUtilsObject(IUtils paramIUtils)
  {
    try
    {
      this.proxy.setUtils(paramIUtils);
      return;
    }
    catch (Throwable paramIUtils)
    {
      for (;;)
      {
        HttpproxyFacade.print(6, TAG, "error ,setUtilsObject native not found");
      }
    }
    finally {}
  }
  
  public int startPlay(String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2)
  {
    try
    {
      paramInt1 = this.proxy.startPlay(paramString1, paramInt1, paramString2, paramLong, paramInt2);
      return paramInt1;
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        HttpproxyFacade.print(6, TAG, "error ,startPlay native not found");
        paramInt1 = -1;
      }
    }
    finally {}
  }
  
  public void stopPlay(int paramInt)
  {
    try
    {
      this.proxy.stopPlay(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        HttpproxyFacade.print(6, TAG, "error ,stopPlay native not found");
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqvideo.proxy.common.PlayManagerImp
 * JD-Core Version:    0.7.0.1
 */