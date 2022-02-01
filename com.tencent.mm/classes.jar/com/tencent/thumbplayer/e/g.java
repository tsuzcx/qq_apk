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
  private int RZN;
  private String RZO;
  private int RZP;
  private HashMap<Integer, b> RZQ;
  
  private g()
  {
    AppMethodBeat.i(189234);
    this.RZN = 0;
    this.RZO = "";
    this.RZP = 0;
    if (this.RZQ == null) {
      this.RZQ = new HashMap();
    }
    e.a(this);
    TPNetworkChangeMonitor.hop().a(this);
    AppMethodBeat.o(189234);
  }
  
  private void arv(int paramInt)
  {
    AppMethodBeat.i(189238);
    Iterator localIterator = this.RZQ.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).pushEvent(paramInt);
    }
    AppMethodBeat.o(189238);
  }
  
  private void hG(String paramString, int paramInt)
  {
    AppMethodBeat.i(189239);
    this.RZO = paramString;
    this.RZP = paramInt;
    Iterator localIterator = this.RZQ.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.hnx().setUserData("carrier_pesudo_code", paramString);
      localb.hnx().setUserData("carrier_pesudo_state", Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(189239);
  }
  
  public final b aru(int paramInt)
  {
    AppMethodBeat.i(189235);
    if (paramInt < 0)
    {
      AppMethodBeat.o(189235);
      return null;
    }
    if (this.RZQ.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = (b)this.RZQ.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(189235);
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
        if (((ITPDownloadProxy)localObject).init(localContext1, new TPDLProxyInitParam(a.getPlatform(), a.getAppVersionName(localContext2), a.getGuid(), a.hnk(), a.hnl(), a.hnm())) < 0)
        {
          com.tencent.thumbplayer.utils.g.i("TPProxyGlobalManager", "downloadProxy init failed with status:".concat(String.valueOf(localObject)));
          AppMethodBeat.o(189235);
          return null;
        }
        ((ITPDownloadProxy)localObject).setLogListener(new ITPDLProxyLogListener()
        {
          public final int d(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(189229);
            com.tencent.thumbplayer.utils.g.d(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(189229);
            return 0;
          }
          
          public final int e(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(189232);
            com.tencent.thumbplayer.utils.g.e(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(189232);
            return 0;
          }
          
          public final int i(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(189230);
            com.tencent.thumbplayer.utils.g.i(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(189230);
            return 0;
          }
          
          public final int w(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(189231);
            com.tencent.thumbplayer.utils.g.w(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(189231);
            return 0;
          }
        });
        i = TPNetworkChangeMonitor.aYS();
        if (i == 1)
        {
          ((ITPDownloadProxy)localObject).pushEvent(1);
          ((ITPDownloadProxy)localObject).pushEvent(10);
          ((ITPDownloadProxy)localObject).pushEvent(this.RZN);
          ((ITPDownloadProxy)localObject).setUserData("carrier_pesudo_code", this.RZO);
          ((ITPDownloadProxy)localObject).setUserData("carrier_pesudo_state", Integer.valueOf(this.RZP));
          localObject = new h((ITPDownloadProxy)localObject);
          this.RZQ.put(Integer.valueOf(paramInt), localObject);
          AppMethodBeat.o(189235);
          return localObject;
        }
        if (i != 2) {
          break label279;
        }
        ((ITPDownloadProxy)localObject).pushEvent(2);
        ((ITPDownloadProxy)localObject).pushEvent(9);
        continue;
        AppMethodBeat.o(189235);
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
    AppMethodBeat.i(189236);
    com.tencent.thumbplayer.utils.g.i("TPProxyGlobalManager", "onEvent eventId: " + paramInt1 + ", arg1: " + paramInt2 + ", arg2: " + paramInt3 + ", object" + paramObject);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(189236);
      return;
      this.RZN = 13;
      arv(13);
      AppMethodBeat.o(189236);
      return;
      this.RZN = 14;
      arv(14);
      AppMethodBeat.o(189236);
      return;
      hG((String)paramObject, paramInt2);
    }
  }
  
  public final void my(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189237);
    if (paramInt2 == 1)
    {
      arv(1);
      arv(10);
      AppMethodBeat.o(189237);
      return;
    }
    if (paramInt2 == 2)
    {
      arv(2);
      arv(9);
      AppMethodBeat.o(189237);
      return;
    }
    if (paramInt2 == 3)
    {
      arv(2);
      arv(10);
    }
    AppMethodBeat.o(189237);
  }
  
  static final class a
  {
    private static g RZS;
    
    static
    {
      AppMethodBeat.i(189233);
      RZS = new g((byte)0);
      AppMethodBeat.o(189233);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.e.g
 * JD-Core Version:    0.7.0.1
 */