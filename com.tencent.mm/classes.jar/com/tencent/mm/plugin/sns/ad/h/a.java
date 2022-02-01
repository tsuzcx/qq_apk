package com.tencent.mm.plugin.sns.ad.h;

import android.text.TextUtils;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a<Request extends dop, Response extends dpc>
  extends q
  implements m
{
  protected d Dxf;
  protected i Dxg;
  
  public final q a(Request paramRequest, Response paramResponse, String paramString, int paramInt, Object... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramResponse = null;
    }
    for (;;)
    {
      return paramResponse;
      try
      {
        a(paramRequest, paramVarArgs);
        paramVarArgs = new d.a();
        paramVarArgs.iLN = paramRequest;
        paramVarArgs.iLO = paramResponse;
        paramVarArgs.uri = paramString;
        paramVarArgs.funcId = paramInt;
        this.Dxf = paramVarArgs.aXF();
        paramResponse = this;
        if (paramRequest == this.Dxf.iLK.iLR)
        {
          Log.i("SnsAd.AbsNetScene", "the request is same as mRequestAndResponse.getRequestProtoBuf()");
          return this;
        }
      }
      catch (Throwable paramRequest) {}
    }
    return this;
  }
  
  protected abstract void a(Request paramRequest, Object... paramVarArgs);
  
  public final int doScene(g paramg, i parami)
  {
    try
    {
      this.Dxg = parami;
      int i = dispatch(paramg, this.Dxf, this);
      return i;
    }
    catch (Throwable paramg) {}
    return 99999999;
  }
  
  public final Response eXx()
  {
    Object localObject = getReqResp();
    if ((localObject instanceof d))
    {
      localObject = ((d)localObject).iLL.iLR;
      try
      {
        localObject = (dpc)localObject;
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        Log.w("SnsAd.AbsNetScene", "the response result is not the required!!!!");
      }
    }
    return null;
  }
  
  public final int getType()
  {
    if (this.Dxf != null) {
      return this.Dxf.getType();
    }
    Log.w("SnsAd.AbsNetScene", "the scene is not initialized, please call initialize method");
    return 0;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    try
    {
      if (this.Dxg != null) {
        this.Dxg.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      return;
    }
    catch (Throwable paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.h.a
 * JD-Core Version:    0.7.0.1
 */