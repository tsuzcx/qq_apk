package com.tencent.smtt.sdk.b;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreNetwork;
import com.tencent.smtt.export.external.interfaces.UrlRequest;
import com.tencent.smtt.export.external.interfaces.UrlRequest.Callback;
import java.util.ArrayList;
import java.util.concurrent.Executor;

public class m
  implements IX5CoreNetwork
{
  private DexLoader a;
  
  m(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  public String getCanonicalUrl(String paramString)
  {
    return null;
  }
  
  public String getCoreExtraMessage()
  {
    return null;
  }
  
  public UrlRequest getX5UrlRequestProvider(String paramString1, int paramInt, UrlRequest.Callback paramCallback, Executor paramExecutor, boolean paramBoolean, String paramString2, ArrayList<Pair<String, String>> paramArrayList, String paramString3, byte[] paramArrayOfByte, String paramString4, String paramString5)
  {
    return null;
  }
  
  public void resetSpdySession() {}
  
  public void setPreConnect(String paramString, int paramInt)
  {
    AppMethodBeat.i(219788);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "preConnect", new Class[] { Context.class, String.class, Integer.TYPE }, new Object[] { null, paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(219788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.m
 * JD-Core Version:    0.7.0.1
 */