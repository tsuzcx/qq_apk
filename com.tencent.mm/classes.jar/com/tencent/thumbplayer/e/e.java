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
  private ITPDownloadProxy ahHc;
  private boolean ahHd;
  private a ahHx;
  private ITPPreloadProxy.IPreloadListener ahHy;
  private Context mContext;
  private int mServiceType;
  
  public e(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(226996);
    this.ahHd = false;
    this.ahHx = new a((byte)0);
    this.ahHy = new d("TPPreloadProxyImpl");
    this.mContext = paramContext;
    this.mServiceType = paramInt;
    kav();
    AppMethodBeat.o(226996);
  }
  
  private void kav()
  {
    AppMethodBeat.i(227006);
    int i = 3;
    while ((i > 0) && (!this.ahHd))
    {
      int j = i;
      try
      {
        b localb = g.a.kax().aHU(this.mServiceType);
        if (localb != null)
        {
          j = i;
          if (localb.kau() != null)
          {
            j = i;
            this.ahHc = localb.kau();
            j = i;
            this.ahHc.setLogListener(this.ahHx);
            j = i;
            this.ahHc.setUserData("qq_is_vip", Boolean.valueOf(a.kao()));
            j = i;
            if (!TextUtils.isEmpty(a.kak()))
            {
              j = i;
              this.ahHc.setUserData("user_uin", a.kak());
            }
            j = i;
            if (!TextUtils.isEmpty(a.getAppVersionName(this.mContext)))
            {
              j = i;
              this.ahHc.setUserData("app_version_name", a.getAppVersionName(this.mContext));
            }
            j = i;
            if (a.ot(this.mContext) != -1L)
            {
              j = i;
              this.ahHc.setUserData("app_version_code", String.valueOf(a.ot(this.mContext)));
            }
            j = i;
            this.ahHc.setUserData("carrier_pesudo_code", a.kal());
            j = i;
            this.ahHc.setUserData("carrier_pesudo_state", Integer.valueOf(a.kam()));
            j = i;
            this.ahHc.setUserData("external_network_ip", a.kan());
            j = i;
            this.ahHd = true;
            AppMethodBeat.o(227006);
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
    AppMethodBeat.o(227006);
  }
  
  public final String getPlayErrorCodeStr(int paramInt)
  {
    return null;
  }
  
  public final boolean isAvailable()
  {
    return (this.ahHc != null) && (this.ahHd);
  }
  
  public final void pushEvent(int paramInt)
  {
    AppMethodBeat.i(227058);
    if (!isAvailable())
    {
      AppMethodBeat.o(227058);
      return;
    }
    try
    {
      this.ahHc.pushEvent(paramInt);
      AppMethodBeat.o(227058);
      return;
    }
    finally
    {
      com.tencent.thumbplayer.utils.g.e("TPPreloadProxyImpl", localThrowable);
      AppMethodBeat.o(227058);
    }
  }
  
  public final void setPreloadListener(ITPPreloadProxy.IPreloadListener paramIPreloadListener)
  {
    AppMethodBeat.i(227023);
    if (paramIPreloadListener == null)
    {
      this.ahHy = new d("TPPreloadProxyImpl");
      AppMethodBeat.o(227023);
      return;
    }
    this.ahHy = paramIPreloadListener;
    AppMethodBeat.o(227023);
  }
  
  public final int startClipPreload(String paramString, ArrayList<TPDownloadParamData> paramArrayList)
  {
    return 0;
  }
  
  public final int startPreload(String paramString, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(227031);
    if (!isAvailable())
    {
      kav();
      if (!isAvailable())
      {
        AppMethodBeat.o(227031);
        return -1;
      }
    }
    if (paramTPDownloadParamData != null)
    {
      paramTPDownloadParamData = i.b(null, paramTPDownloadParamData);
      try
      {
        int i = this.ahHc.startPreload(paramString, paramTPDownloadParamData, this.ahHx);
        AppMethodBeat.o(227031);
        return i;
      }
      finally
      {
        com.tencent.thumbplayer.utils.g.e("TPPreloadProxyImpl", paramString);
      }
    }
    AppMethodBeat.o(227031);
    return -1;
  }
  
  public final void stopPreload(int paramInt)
  {
    AppMethodBeat.i(227047);
    if (this.ahHc == null)
    {
      AppMethodBeat.o(227047);
      return;
    }
    try
    {
      this.ahHc.stopPreload(paramInt);
      AppMethodBeat.o(227047);
      return;
    }
    finally
    {
      com.tencent.thumbplayer.utils.g.e("TPPreloadProxyImpl", localThrowable);
      AppMethodBeat.o(227047);
    }
  }
  
  final class a
    implements ITPDLProxyLogListener, ITPPreLoadListener
  {
    private a() {}
    
    public final int d(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      AppMethodBeat.i(226983);
      com.tencent.thumbplayer.utils.g.d(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
      AppMethodBeat.o(226983);
      return 0;
    }
    
    public final int e(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      AppMethodBeat.i(226999);
      com.tencent.thumbplayer.utils.g.e(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
      AppMethodBeat.o(226999);
      return 0;
    }
    
    public final int i(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      AppMethodBeat.i(226987);
      com.tencent.thumbplayer.utils.g.i(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
      AppMethodBeat.o(226987);
      return 0;
    }
    
    public final void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
    {
      AppMethodBeat.i(227016);
      e.a(e.this).onPrepareDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2);
      AppMethodBeat.o(227016);
    }
    
    public final void onPrepareError(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(227009);
      e.a(e.this).onPrepareError();
      AppMethodBeat.o(227009);
    }
    
    public final void onPrepareOK()
    {
      AppMethodBeat.i(227003);
      e.a(e.this).onPrepareSuccess();
      AppMethodBeat.o(227003);
    }
    
    public final int w(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      AppMethodBeat.i(226993);
      com.tencent.thumbplayer.utils.g.w(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
      AppMethodBeat.o(226993);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.e.e
 * JD-Core Version:    0.7.0.1
 */