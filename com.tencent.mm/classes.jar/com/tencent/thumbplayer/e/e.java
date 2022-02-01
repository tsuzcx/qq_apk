package com.tencent.thumbplayer.e;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy;
import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy.IPreloadListener;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.d.a;
import java.util.ArrayList;

public final class e
  implements ITPPreloadProxy
{
  private a RZK;
  private ITPPreloadProxy.IPreloadListener RZL;
  private ITPDownloadProxy RZp;
  private boolean RZq;
  private Context mContext;
  private int mServiceType;
  
  public e(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(189222);
    this.RZq = false;
    this.RZK = new a((byte)0);
    this.RZL = new d("TPPreloadProxyImpl");
    this.mContext = paramContext;
    this.mServiceType = paramInt;
    hny();
    AppMethodBeat.o(189222);
  }
  
  private void hny()
  {
    AppMethodBeat.i(189223);
    int i = 3;
    while ((i > 0) && (!this.RZq))
    {
      int j = i;
      try
      {
        b localb = g.a.hnA().aru(this.mServiceType);
        if (localb != null)
        {
          j = i;
          if (localb.hnx() != null)
          {
            j = i;
            this.RZp = localb.hnx();
            j = i;
            this.RZp.setLogListener(this.RZK);
            j = i;
            this.RZp.setUserData("qq_is_vip", Boolean.valueOf(a.hnr()));
            j = i;
            if (!TextUtils.isEmpty(a.hnn()))
            {
              j = i;
              this.RZp.setUserData("user_uin", a.hnn());
            }
            j = i;
            if (!TextUtils.isEmpty(a.getAppVersionName(this.mContext)))
            {
              j = i;
              this.RZp.setUserData("app_version_name", a.getAppVersionName(this.mContext));
            }
            j = i;
            if (a.li(this.mContext) != -1L)
            {
              j = i;
              this.RZp.setUserData("app_version_code", String.valueOf(a.li(this.mContext)));
            }
            j = i;
            this.RZp.setUserData("carrier_pesudo_code", a.hno());
            j = i;
            this.RZp.setUserData("carrier_pesudo_state", Integer.valueOf(a.hnp()));
            j = i;
            this.RZp.setUserData("external_network_ip", a.hnq());
            j = i;
            this.RZq = true;
            AppMethodBeat.o(189223);
            return;
          }
        }
        i -= 1;
        j = i;
        com.tencent.thumbplayer.utils.g.e("TPPreloadProxyImpl", "p2p so load failed");
      }
      catch (Exception localException)
      {
        i = j - 1;
        com.tencent.thumbplayer.utils.g.e("TPPreloadProxyImpl", localException);
      }
    }
    AppMethodBeat.o(189223);
  }
  
  public final String getPlayErrorCodeStr(int paramInt)
  {
    return null;
  }
  
  public final boolean isAvailable()
  {
    return (this.RZp != null) && (this.RZq);
  }
  
  public final void pushEvent(int paramInt)
  {
    AppMethodBeat.i(189227);
    if (!isAvailable())
    {
      AppMethodBeat.o(189227);
      return;
    }
    try
    {
      this.RZp.pushEvent(paramInt);
      AppMethodBeat.o(189227);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.g.e("TPPreloadProxyImpl", localThrowable);
      AppMethodBeat.o(189227);
    }
  }
  
  public final void setPreloadListener(ITPPreloadProxy.IPreloadListener paramIPreloadListener)
  {
    AppMethodBeat.i(189224);
    if (paramIPreloadListener == null)
    {
      this.RZL = new d("TPPreloadProxyImpl");
      AppMethodBeat.o(189224);
      return;
    }
    this.RZL = paramIPreloadListener;
    AppMethodBeat.o(189224);
  }
  
  public final int startClipPreload(String paramString, ArrayList<TPDownloadParamData> paramArrayList)
  {
    return 0;
  }
  
  public final int startPreload(String paramString, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(189225);
    if (!isAvailable())
    {
      hny();
      if (!isAvailable())
      {
        AppMethodBeat.o(189225);
        return -1;
      }
    }
    if (paramTPDownloadParamData != null)
    {
      paramTPDownloadParamData = i.b(null, paramTPDownloadParamData);
      try
      {
        int i = this.RZp.startPreload(paramString, paramTPDownloadParamData, this.RZK);
        AppMethodBeat.o(189225);
        return i;
      }
      catch (Throwable paramString)
      {
        com.tencent.thumbplayer.utils.g.e("TPPreloadProxyImpl", paramString);
      }
    }
    AppMethodBeat.o(189225);
    return -1;
  }
  
  public final void stopPreload(int paramInt)
  {
    AppMethodBeat.i(189226);
    if (this.RZp == null)
    {
      AppMethodBeat.o(189226);
      return;
    }
    try
    {
      this.RZp.stopPreload(paramInt);
      AppMethodBeat.o(189226);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.g.e("TPPreloadProxyImpl", localThrowable);
      AppMethodBeat.o(189226);
    }
  }
  
  final class a
    implements ITPDLProxyLogListener, ITPPreLoadListener
  {
    private a() {}
    
    public final int d(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      AppMethodBeat.i(189215);
      com.tencent.thumbplayer.utils.g.d(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
      AppMethodBeat.o(189215);
      return 0;
    }
    
    public final int e(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      AppMethodBeat.i(189218);
      com.tencent.thumbplayer.utils.g.e(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
      AppMethodBeat.o(189218);
      return 0;
    }
    
    public final int i(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      AppMethodBeat.i(189216);
      com.tencent.thumbplayer.utils.g.i(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
      AppMethodBeat.o(189216);
      return 0;
    }
    
    public final void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
    {
      AppMethodBeat.i(189221);
      e.a(e.this).onPrepareDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2);
      AppMethodBeat.o(189221);
    }
    
    public final void onPrepareError(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(189220);
      e.a(e.this).onPrepareError();
      AppMethodBeat.o(189220);
    }
    
    public final void onPrepareOK()
    {
      AppMethodBeat.i(189219);
      e.a(e.this).onPrepareSuccess();
      AppMethodBeat.o(189219);
    }
    
    public final int w(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      AppMethodBeat.i(189217);
      com.tencent.thumbplayer.utils.g.w(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
      AppMethodBeat.o(189217);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.e.e
 * JD-Core Version:    0.7.0.1
 */