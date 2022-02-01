package com.tencent.thumbplayer.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.h;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.e.a;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor.b;
import com.tencent.thumbplayer.utils.b.a;
import com.tencent.thumbplayer.utils.b.b;
import com.tencent.thumbplayer.utils.d;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class f
  implements TPNetworkChangeMonitor.b, b.b
{
  private int Mbb;
  private String Mbc;
  private int Mbd;
  private HashMap<Integer, b> Mbe;
  
  private f()
  {
    AppMethodBeat.i(191960);
    this.Mbb = 0;
    this.Mbc = "";
    this.Mbd = 0;
    if (this.Mbe == null) {
      this.Mbe = new HashMap();
    }
    b.a.fXG().a(this);
    TPNetworkChangeMonitor.fXH().a(this);
    AppMethodBeat.o(191960);
  }
  
  private void ahs(int paramInt)
  {
    AppMethodBeat.i(191963);
    Iterator localIterator = this.Mbe.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).pushEvent(paramInt);
    }
    AppMethodBeat.o(191963);
  }
  
  public final b ahr(int paramInt)
  {
    AppMethodBeat.i(191961);
    if (paramInt < 0)
    {
      AppMethodBeat.o(191961);
      return null;
    }
    if (this.Mbe.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = (b)this.Mbe.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(191961);
      return localObject;
    }
    Object localObject = TPDownloadProxyFactory.getTPDownloadProxy(paramInt);
    if (localObject != null) {}
    for (;;)
    {
      int i;
      try
      {
        ((ITPDownloadProxy)localObject).setLogListener(new ITPDLProxyLogListener()
        {
          public final int d(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(191955);
            d.d(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(191955);
            return 0;
          }
          
          public final int e(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(191958);
            d.e(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(191958);
            return 0;
          }
          
          public final int i(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(191956);
            d.i(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(191956);
            return 0;
          }
          
          public final int w(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(191957);
            d.w(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(191957);
            return 0;
          }
        });
        Context localContext = h.IR;
        if (((ITPDownloadProxy)localObject).init(localContext, new TPDLProxyInitParam(a.getPlatform(), a.getAppVersionName(localContext), a.getGuid(), a.fWO(), a.fWP(), a.fWQ())) < 0)
        {
          d.i("TPProxyGlobalManager", "downloadProxy init failed with status:".concat(String.valueOf(localObject)));
          AppMethodBeat.o(191961);
          return null;
        }
        i = TPNetworkChangeMonitor.aEN();
        if (i == 1)
        {
          ((ITPDownloadProxy)localObject).pushEvent(1);
          ((ITPDownloadProxy)localObject).pushEvent(10);
          ((ITPDownloadProxy)localObject).pushEvent(this.Mbb);
          ((ITPDownloadProxy)localObject).setUserData("carrier_pesudo_code", this.Mbc);
          ((ITPDownloadProxy)localObject).setUserData("carrier_pesudo_state", Integer.valueOf(this.Mbd));
          localObject = new g((ITPDownloadProxy)localObject);
          this.Mbe.put(Integer.valueOf(paramInt), localObject);
          AppMethodBeat.o(191961);
          return localObject;
        }
        if (i != 2) {
          break label274;
        }
        ((ITPDownloadProxy)localObject).pushEvent(2);
        ((ITPDownloadProxy)localObject).pushEvent(9);
        continue;
        AppMethodBeat.o(191961);
      }
      catch (Throwable localThrowable)
      {
        d.i("TPProxyGlobalManager", "init proxy failed:".concat(String.valueOf(localThrowable)));
      }
      return null;
      label274:
      if (i == 3)
      {
        localThrowable.pushEvent(2);
        localThrowable.pushEvent(10);
      }
    }
  }
  
  public final void kT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191962);
    if (paramInt2 == 1)
    {
      ahs(1);
      ahs(10);
      AppMethodBeat.o(191962);
      return;
    }
    if (paramInt2 == 2)
    {
      ahs(2);
      ahs(9);
      AppMethodBeat.o(191962);
      return;
    }
    if (paramInt2 == 3)
    {
      ahs(2);
      ahs(10);
    }
    AppMethodBeat.o(191962);
  }
  
  static final class a
  {
    private static f Mbg;
    
    static
    {
      AppMethodBeat.i(191959);
      Mbg = new f((byte)0);
      AppMethodBeat.o(191959);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.f.f
 * JD-Core Version:    0.7.0.1
 */