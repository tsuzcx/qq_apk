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
  private int ahHA;
  private String ahHB;
  private int ahHC;
  private HashMap<Integer, b> ahHD;
  
  private g()
  {
    AppMethodBeat.i(227028);
    this.ahHA = 0;
    this.ahHB = "";
    this.ahHC = 0;
    if (this.ahHD == null) {
      this.ahHD = new HashMap();
    }
    e.a(this);
    TPNetworkChangeMonitor.kbq().a(this);
    AppMethodBeat.o(227028);
  }
  
  private void aHV(int paramInt)
  {
    AppMethodBeat.i(227032);
    Iterator localIterator = this.ahHD.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).pushEvent(paramInt);
    }
    AppMethodBeat.o(227032);
  }
  
  private void jC(String paramString, int paramInt)
  {
    AppMethodBeat.i(227037);
    this.ahHB = paramString;
    this.ahHC = paramInt;
    Iterator localIterator = this.ahHD.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.kau().setUserData("carrier_pesudo_code", paramString);
      localb.kau().setUserData("carrier_pesudo_state", Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(227037);
  }
  
  public final b aHU(int paramInt)
  {
    AppMethodBeat.i(227051);
    if (paramInt < 0)
    {
      AppMethodBeat.o(227051);
      return null;
    }
    if (this.ahHD.containsKey(Integer.valueOf(paramInt)))
    {
      localObject1 = (b)this.ahHD.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(227051);
      return localObject1;
    }
    Object localObject1 = TPDownloadProxyFactory.getTPDownloadProxy(paramInt);
    if (localObject1 != null) {}
    for (;;)
    {
      int i;
      try
      {
        Context localContext1 = TPPlayerMgr.getAppContext();
        Context localContext2 = TPPlayerMgr.getAppContext();
        if (((ITPDownloadProxy)localObject1).init(localContext1, new TPDLProxyInitParam(a.getPlatform(), a.getAppVersionName(localContext2), a.getGuid(), a.kah(), a.kai(), a.kaj())) < 0)
        {
          com.tencent.thumbplayer.utils.g.i("TPProxyGlobalManager", "downloadProxy init failed with status:".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(227051);
          return null;
        }
        ((ITPDownloadProxy)localObject1).setLogListener(new ITPDLProxyLogListener()
        {
          public final int d(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(227040);
            com.tencent.thumbplayer.utils.g.d(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(227040);
            return 0;
          }
          
          public final int e(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(227062);
            com.tencent.thumbplayer.utils.g.e(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(227062);
            return 0;
          }
          
          public final int i(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(227049);
            com.tencent.thumbplayer.utils.g.i(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(227049);
            return 0;
          }
          
          public final int w(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(227053);
            com.tencent.thumbplayer.utils.g.w(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(227053);
            return 0;
          }
        });
        i = TPNetworkChangeMonitor.bFQ();
        if (i == 1)
        {
          ((ITPDownloadProxy)localObject1).pushEvent(1);
          ((ITPDownloadProxy)localObject1).pushEvent(10);
          ((ITPDownloadProxy)localObject1).pushEvent(this.ahHA);
          ((ITPDownloadProxy)localObject1).setUserData("carrier_pesudo_code", this.ahHB);
          ((ITPDownloadProxy)localObject1).setUserData("carrier_pesudo_state", Integer.valueOf(this.ahHC));
          localObject1 = new h((ITPDownloadProxy)localObject1);
          this.ahHD.put(Integer.valueOf(paramInt), localObject1);
          AppMethodBeat.o(227051);
          return localObject1;
        }
        if (i != 2) {
          break label279;
        }
        ((ITPDownloadProxy)localObject1).pushEvent(2);
        ((ITPDownloadProxy)localObject1).pushEvent(9);
        continue;
        AppMethodBeat.o(227051);
      }
      finally
      {
        com.tencent.thumbplayer.utils.g.i("TPProxyGlobalManager", "init proxy failed:".concat(String.valueOf(localObject2)));
      }
      return null;
      label279:
      if (i == 3)
      {
        localObject2.pushEvent(2);
        localObject2.pushEvent(10);
      }
    }
  }
  
  public final void d(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(227060);
    com.tencent.thumbplayer.utils.g.i("TPProxyGlobalManager", "onEvent eventId: " + paramInt1 + ", arg1: " + paramInt2 + ", arg2: " + paramInt3 + ", object" + paramObject);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(227060);
      return;
      this.ahHA = 13;
      aHV(13);
      AppMethodBeat.o(227060);
      return;
      this.ahHA = 14;
      aHV(14);
      AppMethodBeat.o(227060);
      return;
      jC((String)paramObject, paramInt2);
    }
  }
  
  public final void pM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227069);
    if (paramInt2 == 1)
    {
      aHV(1);
      aHV(10);
      AppMethodBeat.o(227069);
      return;
    }
    if (paramInt2 == 2)
    {
      aHV(2);
      aHV(9);
      AppMethodBeat.o(227069);
      return;
    }
    if (paramInt2 == 3)
    {
      aHV(2);
      aHV(10);
    }
    AppMethodBeat.o(227069);
  }
  
  static final class a
  {
    private static g ahHF;
    
    static
    {
      AppMethodBeat.i(226968);
      ahHF = new g((byte)0);
      AppMethodBeat.o(226968);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.e.g
 * JD-Core Version:    0.7.0.1
 */