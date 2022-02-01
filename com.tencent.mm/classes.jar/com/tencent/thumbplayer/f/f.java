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
  private int MxW;
  private String MxX;
  private int MxY;
  private HashMap<Integer, b> MxZ;
  
  private f()
  {
    AppMethodBeat.i(194638);
    this.MxW = 0;
    this.MxX = "";
    this.MxY = 0;
    if (this.MxZ == null) {
      this.MxZ = new HashMap();
    }
    b.a.gcf().a(this);
    TPNetworkChangeMonitor.gcg().a(this);
    AppMethodBeat.o(194638);
  }
  
  private void aib(int paramInt)
  {
    AppMethodBeat.i(194641);
    Iterator localIterator = this.MxZ.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).pushEvent(paramInt);
    }
    AppMethodBeat.o(194641);
  }
  
  public final b aia(int paramInt)
  {
    AppMethodBeat.i(194639);
    if (paramInt < 0)
    {
      AppMethodBeat.o(194639);
      return null;
    }
    if (this.MxZ.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = (b)this.MxZ.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(194639);
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
            AppMethodBeat.i(194633);
            d.d(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(194633);
            return 0;
          }
          
          public final int e(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(194636);
            d.e(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(194636);
            return 0;
          }
          
          public final int i(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(194634);
            d.i(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(194634);
            return 0;
          }
          
          public final int w(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(194635);
            d.w(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(194635);
            return 0;
          }
        });
        Context localContext = h.IR;
        if (((ITPDownloadProxy)localObject).init(localContext, new TPDLProxyInitParam(a.getPlatform(), a.getAppVersionName(localContext), a.getGuid(), a.gbn(), a.gbo(), a.gbp())) < 0)
        {
          d.i("TPProxyGlobalManager", "downloadProxy init failed with status:".concat(String.valueOf(localObject)));
          AppMethodBeat.o(194639);
          return null;
        }
        i = TPNetworkChangeMonitor.aFd();
        if (i == 1)
        {
          ((ITPDownloadProxy)localObject).pushEvent(1);
          ((ITPDownloadProxy)localObject).pushEvent(10);
          ((ITPDownloadProxy)localObject).pushEvent(this.MxW);
          ((ITPDownloadProxy)localObject).setUserData("carrier_pesudo_code", this.MxX);
          ((ITPDownloadProxy)localObject).setUserData("carrier_pesudo_state", Integer.valueOf(this.MxY));
          localObject = new g((ITPDownloadProxy)localObject);
          this.MxZ.put(Integer.valueOf(paramInt), localObject);
          AppMethodBeat.o(194639);
          return localObject;
        }
        if (i != 2) {
          break label274;
        }
        ((ITPDownloadProxy)localObject).pushEvent(2);
        ((ITPDownloadProxy)localObject).pushEvent(9);
        continue;
        AppMethodBeat.o(194639);
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
  
  public final void la(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194640);
    if (paramInt2 == 1)
    {
      aib(1);
      aib(10);
      AppMethodBeat.o(194640);
      return;
    }
    if (paramInt2 == 2)
    {
      aib(2);
      aib(9);
      AppMethodBeat.o(194640);
      return;
    }
    if (paramInt2 == 3)
    {
      aib(2);
      aib(10);
    }
    AppMethodBeat.o(194640);
  }
  
  static final class a
  {
    private static f Myb;
    
    static
    {
      AppMethodBeat.i(194637);
      Myb = new f((byte)0);
      AppMethodBeat.o(194637);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.f.f
 * JD-Core Version:    0.7.0.1
 */