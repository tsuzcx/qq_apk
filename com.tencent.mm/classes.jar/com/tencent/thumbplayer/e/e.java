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
  private ITPDownloadProxy ZBZ;
  private boolean ZCa;
  private a ZCu;
  private ITPPreloadProxy.IPreloadListener ZCv;
  private Context mContext;
  private int mServiceType;
  
  public e(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(220521);
    this.ZCa = false;
    this.ZCu = new a((byte)0);
    this.ZCv = new d("TPPreloadProxyImpl");
    this.mContext = paramContext;
    this.mServiceType = paramInt;
    iqZ();
    AppMethodBeat.o(220521);
  }
  
  private void iqZ()
  {
    AppMethodBeat.i(220527);
    int i = 3;
    while ((i > 0) && (!this.ZCa))
    {
      int j = i;
      try
      {
        b localb = g.a.irb().aBh(this.mServiceType);
        if (localb != null)
        {
          j = i;
          if (localb.iqY() != null)
          {
            j = i;
            this.ZBZ = localb.iqY();
            j = i;
            this.ZBZ.setLogListener(this.ZCu);
            j = i;
            this.ZBZ.setUserData("qq_is_vip", Boolean.valueOf(a.iqS()));
            j = i;
            if (!TextUtils.isEmpty(a.iqO()))
            {
              j = i;
              this.ZBZ.setUserData("user_uin", a.iqO());
            }
            j = i;
            if (!TextUtils.isEmpty(a.getAppVersionName(this.mContext)))
            {
              j = i;
              this.ZBZ.setUserData("app_version_name", a.getAppVersionName(this.mContext));
            }
            j = i;
            if (a.mg(this.mContext) != -1L)
            {
              j = i;
              this.ZBZ.setUserData("app_version_code", String.valueOf(a.mg(this.mContext)));
            }
            j = i;
            this.ZBZ.setUserData("carrier_pesudo_code", a.iqP());
            j = i;
            this.ZBZ.setUserData("carrier_pesudo_state", Integer.valueOf(a.iqQ()));
            j = i;
            this.ZBZ.setUserData("external_network_ip", a.iqR());
            j = i;
            this.ZCa = true;
            AppMethodBeat.o(220527);
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
    AppMethodBeat.o(220527);
  }
  
  public final String getPlayErrorCodeStr(int paramInt)
  {
    return null;
  }
  
  public final boolean isAvailable()
  {
    return (this.ZBZ != null) && (this.ZCa);
  }
  
  public final void pushEvent(int paramInt)
  {
    AppMethodBeat.i(220540);
    if (!isAvailable())
    {
      AppMethodBeat.o(220540);
      return;
    }
    try
    {
      this.ZBZ.pushEvent(paramInt);
      AppMethodBeat.o(220540);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.g.e("TPPreloadProxyImpl", localThrowable);
      AppMethodBeat.o(220540);
    }
  }
  
  public final void setPreloadListener(ITPPreloadProxy.IPreloadListener paramIPreloadListener)
  {
    AppMethodBeat.i(220529);
    if (paramIPreloadListener == null)
    {
      this.ZCv = new d("TPPreloadProxyImpl");
      AppMethodBeat.o(220529);
      return;
    }
    this.ZCv = paramIPreloadListener;
    AppMethodBeat.o(220529);
  }
  
  public final int startClipPreload(String paramString, ArrayList<TPDownloadParamData> paramArrayList)
  {
    return 0;
  }
  
  public final int startPreload(String paramString, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(220536);
    if (!isAvailable())
    {
      iqZ();
      if (!isAvailable())
      {
        AppMethodBeat.o(220536);
        return -1;
      }
    }
    if (paramTPDownloadParamData != null)
    {
      paramTPDownloadParamData = i.b(null, paramTPDownloadParamData);
      try
      {
        int i = this.ZBZ.startPreload(paramString, paramTPDownloadParamData, this.ZCu);
        AppMethodBeat.o(220536);
        return i;
      }
      catch (Throwable paramString)
      {
        com.tencent.thumbplayer.utils.g.e("TPPreloadProxyImpl", paramString);
      }
    }
    AppMethodBeat.o(220536);
    return -1;
  }
  
  public final void stopPreload(int paramInt)
  {
    AppMethodBeat.i(220538);
    if (this.ZBZ == null)
    {
      AppMethodBeat.o(220538);
      return;
    }
    try
    {
      this.ZBZ.stopPreload(paramInt);
      AppMethodBeat.o(220538);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.g.e("TPPreloadProxyImpl", localThrowable);
      AppMethodBeat.o(220538);
    }
  }
  
  final class a
    implements ITPDLProxyLogListener, ITPPreLoadListener
  {
    private a() {}
    
    public final int d(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      AppMethodBeat.i(220501);
      com.tencent.thumbplayer.utils.g.d(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
      AppMethodBeat.o(220501);
      return 0;
    }
    
    public final int e(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      AppMethodBeat.i(220507);
      com.tencent.thumbplayer.utils.g.e(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
      AppMethodBeat.o(220507);
      return 0;
    }
    
    public final int i(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      AppMethodBeat.i(220504);
      com.tencent.thumbplayer.utils.g.i(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
      AppMethodBeat.o(220504);
      return 0;
    }
    
    public final void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
    {
      AppMethodBeat.i(220512);
      e.a(e.this).onPrepareDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2);
      AppMethodBeat.o(220512);
    }
    
    public final void onPrepareError(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(220509);
      e.a(e.this).onPrepareError();
      AppMethodBeat.o(220509);
    }
    
    public final void onPrepareOK()
    {
      AppMethodBeat.i(220508);
      e.a(e.this).onPrepareSuccess();
      AppMethodBeat.o(220508);
    }
    
    public final int w(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      AppMethodBeat.i(220505);
      com.tencent.thumbplayer.utils.g.w(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
      AppMethodBeat.o(220505);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.e.e
 * JD-Core Version:    0.7.0.1
 */