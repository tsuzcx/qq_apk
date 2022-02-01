package com.tencent.mm.plugin.sns.ad.g;

import android.text.TextUtils;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a<Request extends dyl, Response extends dyy>
  extends q
  implements m
{
  protected d JGM;
  protected i JGN;
  
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
        paramVarArgs.lBU = paramRequest;
        paramVarArgs.lBV = paramResponse;
        paramVarArgs.uri = paramString;
        paramVarArgs.funcId = paramInt;
        this.JGM = paramVarArgs.bgN();
        paramResponse = this;
        if (paramRequest == d.b.b(this.JGM.lBR))
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
      this.JGN = parami;
      int i = dispatch(paramg, this.JGM, this);
      return i;
    }
    catch (Throwable paramg) {}
    return 99999999;
  }
  
  public final Response fKY()
  {
    Object localObject = getReqResp();
    if ((localObject instanceof d))
    {
      localObject = d.c.b(((d)localObject).lBS);
      try
      {
        localObject = (dyy)localObject;
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
    if (this.JGM != null) {
      return this.JGM.getType();
    }
    Log.w("SnsAd.AbsNetScene", "the scene is not initialized, please call initialize method");
    return 0;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    try
    {
      if (this.JGN != null) {
        this.JGN.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      return;
    }
    catch (Throwable paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.a
 * JD-Core Version:    0.7.0.1
 */