package com.tencent.thumbplayer.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.d.a;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor.b;
import com.tencent.thumbplayer.utils.e;
import com.tencent.thumbplayer.utils.e.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class g
  implements TPNetworkChangeMonitor.b, e.a
{
  private HashMap<Integer, b> ZCA;
  private int ZCx;
  private String ZCy;
  private int ZCz;
  
  private g()
  {
    AppMethodBeat.i(220560);
    this.ZCx = 0;
    this.ZCy = "";
    this.ZCz = 0;
    if (this.ZCA == null) {
      this.ZCA = new HashMap();
    }
    e.a(this);
    TPNetworkChangeMonitor.irQ().a(this);
    AppMethodBeat.o(220560);
  }
  
  private void aBi(int paramInt)
  {
    AppMethodBeat.i(220569);
    Iterator localIterator = this.ZCA.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).pushEvent(paramInt);
    }
    AppMethodBeat.o(220569);
  }
  
  private void ip(String paramString, int paramInt)
  {
    AppMethodBeat.i(220571);
    this.ZCy = paramString;
    this.ZCz = paramInt;
    Iterator localIterator = this.ZCA.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.iqY().setUserData("carrier_pesudo_code", paramString);
      localb.iqY().setUserData("carrier_pesudo_state", Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(220571);
  }
  
  public final b aBh(int paramInt)
  {
    AppMethodBeat.i(220564);
    if (paramInt < 0)
    {
      AppMethodBeat.o(220564);
      return null;
    }
    if (this.ZCA.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = (b)this.ZCA.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(220564);
      return localObject;
    }
    Object localObject = TPDownloadProxyFactory.getTPDownloadProxy(paramInt);
    if (localObject != null) {}
    for (;;)
    {
      int i;
      try
      {
        Context localContext1 = TPPlayerMgr.getAppContext();
        Context localContext2 = TPPlayerMgr.getAppContext();
        if (((ITPDownloadProxy)localObject).init(localContext1, new TPDLProxyInitParam(a.getPlatform(), a.getAppVersionName(localContext2), a.getGuid(), a.iqL(), a.iqM(), a.iqN())) < 0)
        {
          com.tencent.thumbplayer.utils.g.i("TPProxyGlobalManager", "downloadProxy init failed with status:".concat(String.valueOf(localObject)));
          AppMethodBeat.o(220564);
          return null;
        }
        ((ITPDownloadProxy)localObject).setLogListener(new ITPDLProxyLogListener()
        {
          public final int d(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(220546);
            com.tencent.thumbplayer.utils.g.d(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(220546);
            return 0;
          }
          
          public final int e(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(220552);
            com.tencent.thumbplayer.utils.g.e(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(220552);
            return 0;
          }
          
          public final int i(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(220549);
            com.tencent.thumbplayer.utils.g.i(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(220549);
            return 0;
          }
          
          public final int w(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(220550);
            com.tencent.thumbplayer.utils.g.w(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(220550);
            return 0;
          }
        });
        i = TPNetworkChangeMonitor.bih();
        if (i == 1)
        {
          ((ITPDownloadProxy)localObject).pushEvent(1);
          ((ITPDownloadProxy)localObject).pushEvent(10);
          ((ITPDownloadProxy)localObject).pushEvent(this.ZCx);
          ((ITPDownloadProxy)localObject).setUserData("carrier_pesudo_code", this.ZCy);
          ((ITPDownloadProxy)localObject).setUserData("carrier_pesudo_state", Integer.valueOf(this.ZCz));
          localObject = new h((ITPDownloadProxy)localObject);
          this.ZCA.put(Integer.valueOf(paramInt), localObject);
          AppMethodBeat.o(220564);
          return localObject;
        }
        if (i != 2) {
          break label279;
        }
        ((ITPDownloadProxy)localObject).pushEvent(2);
        ((ITPDownloadProxy)localObject).pushEvent(9);
        continue;
        AppMethodBeat.o(220564);
      }
      catch (Throwable localThrowable)
      {
        com.tencent.thumbplayer.utils.g.i("TPProxyGlobalManager", "init proxy failed:".concat(String.valueOf(localThrowable)));
      }
      return null;
      label279:
      if (i == 3)
      {
        localThrowable.pushEvent(2);
        localThrowable.pushEvent(10);
      }
    }
  }
  
  public final void d(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(220565);
    com.tencent.thumbplayer.utils.g.i("TPProxyGlobalManager", "onEvent eventId: " + paramInt1 + ", arg1: " + paramInt2 + ", arg2: " + paramInt3 + ", object" + paramObject);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(220565);
      return;
      this.ZCx = 13;
      aBi(13);
      AppMethodBeat.o(220565);
      return;
      this.ZCx = 14;
      aBi(14);
      AppMethodBeat.o(220565);
      return;
      ip((String)paramObject, paramInt2);
    }
  }
  
  public final void nP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220567);
    if (paramInt2 == 1)
    {
      aBi(1);
      aBi(10);
      AppMethodBeat.o(220567);
      return;
    }
    if (paramInt2 == 2)
    {
      aBi(2);
      aBi(9);
      AppMethodBeat.o(220567);
      return;
    }
    if (paramInt2 == 3)
    {
      aBi(2);
      aBi(10);
    }
    AppMethodBeat.o(220567);
  }
  
  static final class a
  {
    private static g ZCC;
    
    static
    {
      AppMethodBeat.i(220556);
      ZCC = new g((byte)0);
      AppMethodBeat.o(220556);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.e.g
 * JD-Core Version:    0.7.0.1
 */