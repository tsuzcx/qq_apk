package com.tencent.mm.plugin.multitalk.b;

import android.os.Looper;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.wxmm.IConfCallBack;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class l
{
  IConfCallBack pdy;
  final SparseArray<HashSet<a>> pdz;
  
  l()
  {
    AppMethodBeat.i(190477);
    this.pdy = null;
    this.pdz = new SparseArray(5);
    this.pdy = new IConfCallBack()
    {
      public final byte[] callBackFromConf(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(190475);
        ae.i("MicroMsg.Multitalk.ILinkNativeCallbackMgr", "hy: triggered native callback: %d, %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        paramAnonymousArrayOfByte = l.this.c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte);
        AppMethodBeat.o(190475);
        return paramAnonymousArrayOfByte;
      }
      
      public final void callbackWriteLog(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2, String paramAnonymousString3, String paramAnonymousString4, int paramAnonymousInt3)
      {
        AppMethodBeat.i(190476);
        if (paramAnonymousInt1 >= s.cbh()) {
          Xlog.logWrite2(paramAnonymousInt1, "CloudVoIPNative:".concat(String.valueOf(paramAnonymousString1)), paramAnonymousString2, paramAnonymousString3, Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramAnonymousString4);
        }
        AppMethodBeat.o(190476);
      }
    };
    AppMethodBeat.o(190477);
  }
  
  public final <ConvertedDataType, OutParamType> void a(int paramInt, a<ConvertedDataType, OutParamType> parama)
  {
    int i = 1;
    AppMethodBeat.i(190480);
    ae.i("MicroMsg.Multitalk.ILinkNativeCallbackMgr", "hy: registering event id: %d", new Object[] { Integer.valueOf(paramInt) });
    for (;;)
    {
      try
      {
        HashSet localHashSet = (HashSet)this.pdz.get(paramInt);
        if (localHashSet == null)
        {
          localHashSet = new HashSet(1);
          localHashSet.add(parama);
          if (i != 0) {
            this.pdz.append(paramInt, localHashSet);
          }
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(190480);
      }
      i = 0;
    }
  }
  
  final <ConvertedDataType, OutParamType> void b(int paramInt, a<ConvertedDataType, OutParamType> parama)
  {
    AppMethodBeat.i(190481);
    try
    {
      HashSet localHashSet = (HashSet)this.pdz.get(paramInt);
      if (localHashSet != null) {
        localHashSet.remove(parama);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(190481);
    }
  }
  
  final byte[] c(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(190479);
    HashSet localHashSet;
    ArrayList localArrayList;
    Object localObject;
    for (;;)
    {
      try
      {
        localHashSet = (HashSet)this.pdz.get(paramInt1);
        if ((localHashSet == null) || (localHashSet.size() <= 0)) {
          break label199;
        }
        localArrayList = new ArrayList(1);
        localObject = new byte[1];
        Iterator localIterator = localHashSet.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        a locala = (a)localIterator.next();
        if (locala != null)
        {
          byte[] arrayOfByte = locala.cU(locala.k(paramInt2, locala.aO(paramArrayOfByte)));
          localObject = arrayOfByte;
          if (!locala.cbm())
          {
            localArrayList.add(locala);
            localObject = arrayOfByte;
          }
        }
        else
        {
          ae.e("MicroMsg.Multitalk.ILinkNativeCallbackMgr", "hy: item is null! weired");
        }
      }
      finally
      {
        AppMethodBeat.o(190479);
      }
    }
    paramArrayOfByte = localArrayList.iterator();
    while (paramArrayOfByte.hasNext()) {
      localHashSet.remove((a)paramArrayOfByte.next());
    }
    AppMethodBeat.o(190479);
    return localObject;
    label199:
    ae.w("MicroMsg.Multitalk.ILinkNativeCallbackMgr", "hy: nobody's listening to event %d, what a pity!", new Object[] { Integer.valueOf(paramInt1) });
    paramArrayOfByte = new byte[1];
    AppMethodBeat.o(190479);
    return paramArrayOfByte;
  }
  
  final IConfCallBack jH(boolean paramBoolean)
  {
    AppMethodBeat.i(190478);
    ae.i("MicroMsg.Multitalk.ILinkNativeCallbackMgr", "hy: trigger validate callback %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {}
    try
    {
      this.pdz.clear();
      IConfCallBack localIConfCallBack = this.pdy;
      return localIConfCallBack;
    }
    finally
    {
      AppMethodBeat.o(190478);
    }
  }
  
  static abstract interface a<InParamType, OutParamType>
  {
    public abstract InParamType aO(byte[] paramArrayOfByte);
    
    public abstract byte[] cU(OutParamType paramOutParamType);
    
    public abstract boolean cbm();
    
    public abstract OutParamType k(int paramInt, InParamType paramInParamType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.l
 * JD-Core Version:    0.7.0.1
 */