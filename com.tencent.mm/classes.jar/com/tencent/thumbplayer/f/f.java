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
import com.tencent.thumbplayer.utils.d;
import com.tencent.thumbplayer.utils.d.a;
import com.tencent.thumbplayer.utils.d.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class f
  implements TPNetworkChangeMonitor.b, d.b
{
  private int KhL;
  private String KhM;
  private int KhN;
  private HashMap<Integer, b> KhO;
  
  private f()
  {
    AppMethodBeat.i(187939);
    this.KhL = 0;
    this.KhM = "";
    this.KhN = 0;
    if (this.KhO == null) {
      this.KhO = new HashMap();
    }
    d.a.fGu().a(this);
    TPNetworkChangeMonitor.fGv().a(this);
    AppMethodBeat.o(187939);
  }
  
  private void aeS(int paramInt)
  {
    AppMethodBeat.i(187942);
    Iterator localIterator = this.KhO.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).pushEvent(paramInt);
    }
    AppMethodBeat.o(187942);
  }
  
  public final b aeR(int paramInt)
  {
    AppMethodBeat.i(187940);
    if (paramInt < 0)
    {
      AppMethodBeat.o(187940);
      return null;
    }
    if (this.KhO.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = (b)this.KhO.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(187940);
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
            AppMethodBeat.i(187934);
            com.tencent.thumbplayer.utils.f.d(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(187934);
            return 0;
          }
          
          public final int e(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(187937);
            com.tencent.thumbplayer.utils.f.e(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(187937);
            return 0;
          }
          
          public final int i(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(187935);
            com.tencent.thumbplayer.utils.f.i(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(187935);
            return 0;
          }
          
          public final int w(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(187936);
            com.tencent.thumbplayer.utils.f.w(paramAnonymousString2, "[" + paramAnonymousString1 + ":" + paramAnonymousInt + "] " + paramAnonymousString3);
            AppMethodBeat.o(187936);
            return 0;
          }
        });
        Context localContext = h.GX;
        if (((ITPDownloadProxy)localObject).init(localContext, new TPDLProxyInitParam(a.getPlatform(), a.getAppVersionName(localContext), a.getGuid(), a.fFz(), a.fFA(), a.fFB())) < 0)
        {
          com.tencent.thumbplayer.utils.f.i("TPProxyGlobalManager", "downloadProxy init failed with status:".concat(String.valueOf(localObject)));
          AppMethodBeat.o(187940);
          return null;
        }
        i = TPNetworkChangeMonitor.aBK();
        if (i == 1)
        {
          ((ITPDownloadProxy)localObject).pushEvent(1);
          ((ITPDownloadProxy)localObject).pushEvent(10);
          ((ITPDownloadProxy)localObject).pushEvent(this.KhL);
          ((ITPDownloadProxy)localObject).setUserData("carrier_pesudo_code", this.KhM);
          ((ITPDownloadProxy)localObject).setUserData("carrier_pesudo_state", Integer.valueOf(this.KhN));
          localObject = new g((ITPDownloadProxy)localObject);
          this.KhO.put(Integer.valueOf(paramInt), localObject);
          AppMethodBeat.o(187940);
          return localObject;
        }
        if (i != 2) {
          break label274;
        }
        ((ITPDownloadProxy)localObject).pushEvent(2);
        ((ITPDownloadProxy)localObject).pushEvent(9);
        continue;
        AppMethodBeat.o(187940);
      }
      catch (Throwable localThrowable)
      {
        com.tencent.thumbplayer.utils.f.i("TPProxyGlobalManager", "init proxy failed:".concat(String.valueOf(localThrowable)));
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
  
  public final void kE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187941);
    if (paramInt2 == 1)
    {
      aeS(1);
      aeS(10);
      AppMethodBeat.o(187941);
      return;
    }
    if (paramInt2 == 2)
    {
      aeS(2);
      aeS(9);
      AppMethodBeat.o(187941);
      return;
    }
    if (paramInt2 == 3)
    {
      aeS(2);
      aeS(10);
    }
    AppMethodBeat.o(187941);
  }
  
  static final class a
  {
    private static f KhQ;
    
    static
    {
      AppMethodBeat.i(187938);
      KhQ = new f((byte)0);
      AppMethodBeat.o(187938);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.f.f
 * JD-Core Version:    0.7.0.1
 */