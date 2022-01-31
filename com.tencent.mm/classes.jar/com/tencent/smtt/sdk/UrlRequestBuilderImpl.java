package com.tencent.smtt.sdk;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.UrlRequest;
import com.tencent.smtt.export.external.interfaces.UrlRequest.Builder;
import com.tencent.smtt.export.external.interfaces.UrlRequest.Callback;
import java.util.ArrayList;
import java.util.concurrent.Executor;

public class UrlRequestBuilderImpl
  extends UrlRequest.Builder
{
  private static final String a;
  private final String b;
  private final UrlRequest.Callback c;
  private final Executor d;
  private String e;
  private final ArrayList<Pair<String, String>> f;
  private boolean g;
  private int h;
  
  static
  {
    AppMethodBeat.i(64672);
    a = UrlRequestBuilderImpl.class.getSimpleName();
    AppMethodBeat.o(64672);
  }
  
  public UrlRequestBuilderImpl(String paramString, UrlRequest.Callback paramCallback, Executor paramExecutor)
  {
    AppMethodBeat.i(64665);
    this.f = new ArrayList();
    this.h = 3;
    if (paramString == null)
    {
      paramString = new NullPointerException("URL is required.");
      AppMethodBeat.o(64665);
      throw paramString;
    }
    if (paramCallback == null)
    {
      paramString = new NullPointerException("Callback is required.");
      AppMethodBeat.o(64665);
      throw paramString;
    }
    if (paramExecutor == null)
    {
      paramString = new NullPointerException("Executor is required.");
      AppMethodBeat.o(64665);
      throw paramString;
    }
    this.b = paramString;
    this.c = paramCallback;
    this.d = paramExecutor;
    AppMethodBeat.o(64665);
  }
  
  public UrlRequestBuilderImpl addHeader(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64667);
    if (paramString1 == null)
    {
      paramString1 = new NullPointerException("Invalid header name.");
      AppMethodBeat.o(64667);
      throw paramString1;
    }
    if (paramString2 == null)
    {
      paramString1 = new NullPointerException("Invalid header value.");
      AppMethodBeat.o(64667);
      throw paramString1;
    }
    if ("Accept-Encoding".equalsIgnoreCase(paramString1))
    {
      AppMethodBeat.o(64667);
      return this;
    }
    this.f.add(Pair.create(paramString1, paramString2));
    AppMethodBeat.o(64667);
    return this;
  }
  
  public UrlRequest build()
  {
    AppMethodBeat.i(64668);
    Object localObject = bz.a();
    if ((localObject != null) && (((bz)localObject).b()))
    {
      localObject = ((bz)localObject).c().b();
      Class localClass1 = Integer.TYPE;
      Class localClass2 = Boolean.TYPE;
      String str1 = this.b;
      int i = this.h;
      UrlRequest.Callback localCallback = this.c;
      Executor localExecutor = this.d;
      boolean bool = this.g;
      String str2 = this.e;
      ArrayList localArrayList = this.f;
      localObject = (UrlRequest)((DexLoader)localObject).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "UrlRequest_getX5UrlRequestProvider", new Class[] { String.class, localClass1, UrlRequest.Callback.class, Executor.class, localClass2, String.class, ArrayList.class }, new Object[] { str1, Integer.valueOf(i), localCallback, localExecutor, Boolean.valueOf(bool), str2, localArrayList });
      if (localObject == null)
      {
        localObject = new NullPointerException("UrlRequest build fail");
        AppMethodBeat.o(64668);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(64668);
      return localObject;
    }
    AppMethodBeat.o(64668);
    return null;
  }
  
  public UrlRequestBuilderImpl disableCache()
  {
    this.g = true;
    return this;
  }
  
  public UrlRequest.Builder setHttpMethod(String paramString)
  {
    AppMethodBeat.i(64666);
    if (paramString == null)
    {
      paramString = new NullPointerException("Method is required.");
      AppMethodBeat.o(64666);
      throw paramString;
    }
    this.e = paramString;
    AppMethodBeat.o(64666);
    return this;
  }
  
  public UrlRequestBuilderImpl setPriority(int paramInt)
  {
    this.h = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.UrlRequestBuilderImpl
 * JD-Core Version:    0.7.0.1
 */