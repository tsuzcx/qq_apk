package com.tencent.tencentmap.net;

import android.content.Context;
import com.tencent.map.tools.net.NetAdapter;
import com.tencent.map.tools.net.NetManager.NetRequestBuilder;
import com.tencent.map.tools.net.http.HttpCanceler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class NetManager
{
  private static NetManager sInstance;
  
  public static NetManager getInstance()
  {
    try
    {
      AppMethodBeat.i(181091);
      if (sInstance == null) {
        sInstance = new NetManager();
      }
      NetManager localNetManager = sInstance;
      AppMethodBeat.o(181091);
      return localNetManager;
    }
    finally {}
  }
  
  public NetResponse doGet(String paramString)
  {
    AppMethodBeat.i(181093);
    paramString = com.tencent.map.tools.net.NetManager.getInstance().builder().url(paramString).doGet();
    if (paramString != null)
    {
      paramString = new NetResponse(paramString);
      AppMethodBeat.o(181093);
      return paramString;
    }
    AppMethodBeat.o(181093);
    return null;
  }
  
  public NetResponse doGet(String paramString, int paramInt, HttpCanceler paramHttpCanceler)
  {
    AppMethodBeat.i(181097);
    paramString = com.tencent.map.tools.net.NetManager.getInstance().builder().url(paramString).retryNum(paramInt).canceler(paramHttpCanceler).doGet();
    if (paramString != null)
    {
      paramString = new NetResponse(paramString);
      AppMethodBeat.o(181097);
      return paramString;
    }
    AppMethodBeat.o(181097);
    return null;
  }
  
  public NetResponse doGet(String paramString1, String paramString2)
  {
    AppMethodBeat.i(181094);
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().builder().url(paramString1).userAgent(paramString2).doGet();
    if (paramString1 != null)
    {
      paramString1 = new NetResponse(paramString1);
      AppMethodBeat.o(181094);
      return paramString1;
    }
    AppMethodBeat.o(181094);
    return null;
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(181095);
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().builder().url(paramString1).userAgent(paramString2).retryNum(paramInt).doGet();
    if (paramString1 != null)
    {
      paramString1 = new NetResponse(paramString1);
      AppMethodBeat.o(181095);
      return paramString1;
    }
    AppMethodBeat.o(181095);
    return null;
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(181096);
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().builder().url(paramString1).userAgent(paramString2).retryNum(paramInt1).timeOut(paramInt2).header(paramHashMap).doGet();
    if (paramString1 != null)
    {
      paramString1 = new NetResponse(paramString1);
      AppMethodBeat.o(181096);
      return paramString1;
    }
    AppMethodBeat.o(181096);
    return null;
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    AppMethodBeat.i(181100);
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().builder().url(paramString1).userAgent(paramString2).timeOut(paramInt2).retryNum(paramInt1).header(paramHashMap).canceler(paramHttpCanceler).doGet();
    if (paramString1 != null)
    {
      paramString1 = new NetResponse(paramString1);
      AppMethodBeat.o(181100);
      return paramString1;
    }
    AppMethodBeat.o(181100);
    return null;
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt, HttpCanceler paramHttpCanceler)
  {
    AppMethodBeat.i(181098);
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().builder().url(paramString1).userAgent(paramString2).retryNum(paramInt).canceler(paramHttpCanceler).doGet();
    if (paramString1 != null)
    {
      paramString1 = new NetResponse(paramString1);
      AppMethodBeat.o(181098);
      return paramString1;
    }
    AppMethodBeat.o(181098);
    return null;
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    AppMethodBeat.i(181099);
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().builder().url(paramString1).userAgent(paramString2).retryNum(paramInt).header(paramHashMap).canceler(paramHttpCanceler).doGet();
    if (paramString1 != null)
    {
      paramString1 = new NetResponse(paramString1);
      AppMethodBeat.o(181099);
      return paramString1;
    }
    AppMethodBeat.o(181099);
    return null;
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(181102);
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().builder().url(paramString1).userAgent(paramString2).postData(paramArrayOfByte).doPost();
    if (paramString1 != null)
    {
      paramString1 = new NetResponse(paramString1);
      AppMethodBeat.o(181102);
      return paramString1;
    }
    AppMethodBeat.o(181102);
    return null;
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(181103);
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().builder().url(paramString1).userAgent(paramString2).retryNum(paramInt).postData(paramArrayOfByte).doPost();
    if (paramString1 != null)
    {
      paramString1 = new NetResponse(paramString1);
      AppMethodBeat.o(181103);
      return paramString1;
    }
    AppMethodBeat.o(181103);
    return null;
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(181104);
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().builder().url(paramString1).userAgent(paramString2).timeOut(paramInt2).retryNum(paramInt1).header(paramHashMap).postData(paramArrayOfByte).doPost();
    if (paramString1 != null)
    {
      paramString1 = new NetResponse(paramString1);
      AppMethodBeat.o(181104);
      return paramString1;
    }
    AppMethodBeat.o(181104);
    return null;
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, HttpCanceler paramHttpCanceler)
  {
    AppMethodBeat.i(181106);
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().builder().url(paramString1).userAgent(paramString2).retryNum(paramInt).canceler(paramHttpCanceler).postData(paramArrayOfByte).doPost();
    if (paramString1 != null)
    {
      paramString1 = new NetResponse(paramString1);
      AppMethodBeat.o(181106);
      return paramString1;
    }
    AppMethodBeat.o(181106);
    return null;
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, HashMap<String, String> paramHashMap, int paramInt2)
  {
    AppMethodBeat.i(181109);
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().builder().url(paramString1).userAgent(paramString2).timeOut(paramInt2).retryNum(paramInt1).header(paramHashMap).postData(paramArrayOfByte).doPost();
    if (paramString1 != null)
    {
      paramString1 = new NetResponse(paramString1);
      AppMethodBeat.o(181109);
      return paramString1;
    }
    AppMethodBeat.o(181109);
    return null;
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    AppMethodBeat.i(181107);
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().builder().url(paramString1).userAgent(paramString2).retryNum(paramInt).header(paramHashMap).canceler(paramHttpCanceler).postData(paramArrayOfByte).doPost();
    if (paramString1 != null)
    {
      paramString1 = new NetResponse(paramString1);
      AppMethodBeat.o(181107);
      return paramString1;
    }
    AppMethodBeat.o(181107);
    return null;
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler, int paramInt2)
  {
    AppMethodBeat.i(181108);
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().builder().url(paramString1).userAgent(paramString2).timeOut(paramInt2).retryNum(paramInt1).header(paramHashMap).canceler(paramHttpCanceler).postData(paramArrayOfByte).doPost();
    if (paramString1 != null)
    {
      paramString1 = new NetResponse(paramString1);
      AppMethodBeat.o(181108);
      return paramString1;
    }
    AppMethodBeat.o(181108);
    return null;
  }
  
  public NetResponse doPost(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(181101);
    paramString = com.tencent.map.tools.net.NetManager.getInstance().builder().url(paramString).postData(paramArrayOfByte).doPost();
    if (paramString != null)
    {
      paramString = new NetResponse(paramString);
      AppMethodBeat.o(181101);
      return paramString;
    }
    AppMethodBeat.o(181101);
    return null;
  }
  
  public NetResponse doPost(String paramString, byte[] paramArrayOfByte, int paramInt, HttpCanceler paramHttpCanceler)
  {
    AppMethodBeat.i(181105);
    paramString = com.tencent.map.tools.net.NetManager.getInstance().builder().url(paramString).retryNum(paramInt).canceler(paramHttpCanceler).postData(paramArrayOfByte).doPost();
    if (paramString != null)
    {
      paramString = new NetResponse(paramString);
      AppMethodBeat.o(181105);
      return paramString;
    }
    AppMethodBeat.o(181105);
    return null;
  }
  
  public NetResponse doPostNoBuffer(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(181110);
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().builder().url(paramString1).userAgent(paramString2).postData(paramArrayOfByte).doPostNoBuffer();
    if (paramString1 != null)
    {
      paramString1 = new NetResponse(paramString1);
      AppMethodBeat.o(181110);
      return paramString1;
    }
    AppMethodBeat.o(181110);
    return null;
  }
  
  public void doRangePost(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, String paramString4, String paramString5, HttpCanceler paramHttpCanceler)
  {
    AppMethodBeat.i(181111);
    com.tencent.map.tools.net.NetManager.getInstance().builder().url(paramString1).token(paramString2).postData(paramArrayOfByte).nonce(paramString3).timestamp(paramString4).startTag(paramString5).canceler(paramHttpCanceler).doRangePost();
    AppMethodBeat.o(181111);
  }
  
  public void setAdapter(Context paramContext, NetAdapter paramNetAdapter)
  {
    AppMethodBeat.i(181092);
    com.tencent.map.tools.net.NetManager.getInstance().setAdapter(paramContext, paramNetAdapter);
    AppMethodBeat.o(181092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.net.NetManager
 * JD-Core Version:    0.7.0.1
 */