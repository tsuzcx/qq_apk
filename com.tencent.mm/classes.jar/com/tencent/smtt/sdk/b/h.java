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
    AppMethodBeat.i(192842);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteAllData", null, new Object[0]);
    AppMethodBeat.o(192842);
  }
  
  public void deleteOrigin(String paramString)
  {
    AppMethodBeat.i(192841);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteOrigin", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(192841);
  }
  
  public void getOrigins(ValueCallback<Map> paramValueCallback)
  {
    AppMethodBeat.i(192837);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetOrigins", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
    AppMethodBeat.o(192837);
  }
  
  public void getQuotaForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    AppMethodBeat.i(192839);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetQuotaForOrigin", new Class[] { String.class, ValueCallback.class }, new Object[] { paramString, paramValueCallback });
    AppMethodBeat.o(192839);
  }
  
  public void getUsageForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    AppMethodBeat.i(192838);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetUsageForOrigin", new Class[] { String.class, ValueCallback.class }, new Object[] { paramString, paramValueCallback });
    AppMethodBeat.o(192838);
  }
  
  public void setQuotaForOrigin(String paramString, long paramLong)
  {
    AppMethodBeat.i(192840);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageSetQuotaForOrigin", new Class[] { String.class, Long.TYPE }, new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(192840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.h
 * JD-Core Version:    0.7.0.1
 */