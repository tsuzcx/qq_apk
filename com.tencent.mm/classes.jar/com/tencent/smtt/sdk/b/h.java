package com.tencent.smtt.sdk.b;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebStorage;
import java.util.Map;

public class h
  implements IX5CoreWebStorage
{
  private DexLoader a;
  
  h(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  public void deleteAllData()
  {
    AppMethodBeat.i(219832);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteAllData", null, new Object[0]);
    AppMethodBeat.o(219832);
  }
  
  public void deleteOrigin(String paramString)
  {
    AppMethodBeat.i(219826);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteOrigin", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(219826);
  }
  
  public void getOrigins(ValueCallback<Map> paramValueCallback)
  {
    AppMethodBeat.i(219801);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetOrigins", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
    AppMethodBeat.o(219801);
  }
  
  public void getQuotaForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    AppMethodBeat.i(219811);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetQuotaForOrigin", new Class[] { String.class, ValueCallback.class }, new Object[] { paramString, paramValueCallback });
    AppMethodBeat.o(219811);
  }
  
  public void getUsageForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    AppMethodBeat.i(219805);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetUsageForOrigin", new Class[] { String.class, ValueCallback.class }, new Object[] { paramString, paramValueCallback });
    AppMethodBeat.o(219805);
  }
  
  public void setQuotaForOrigin(String paramString, long paramLong)
  {
    AppMethodBeat.i(219819);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageSetQuotaForOrigin", new Class[] { String.class, Long.TYPE }, new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(219819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.h
 * JD-Core Version:    0.7.0.1
 */