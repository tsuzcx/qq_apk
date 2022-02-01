package com.tencent.mm.plugin.sns.ad.h;

import android.text.TextUtils;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a<Request extends erp, Response extends esc>
  extends p
  implements m
{
  protected c PXM;
  protected h PXN;
  
  public final p a(Request paramRequest, Response paramResponse, String paramString, int paramInt, Object... paramVarArgs)
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
        paramVarArgs = new c.a();
        paramVarArgs.otE = paramRequest;
        paramVarArgs.otF = paramResponse;
        paramVarArgs.uri = paramString;
        paramVarArgs.funcId = paramInt;
        this.PXM = paramVarArgs.bEF();
        paramResponse = this;
        if (paramRequest == c.b.b(this.PXM.otB))
        {
          Log.i("SnsAd.AbsNetScene", "the request is same as mRequestAndResponse.getRequestProtoBuf()");
          return this;
        }
      }
      finally {}
    }
    return this;
  }
  
  protected abstract void a(Request paramRequest, Object... paramVarArgs);
  
  public final int doScene(g paramg, h paramh)
  {
    try
    {
      this.PXN = paramh;
      int i = dispatch(paramg, this.PXM, this);
      return i;
    }
    finally {}
    return 99999999;
  }
  
  public final int getType()
  {
    if (this.PXM != null) {
      return this.PXM.getType();
    }
    Log.w("SnsAd.AbsNetScene", "the scene is not initialized, please call initialize method");
    return 0;
  }
  
  public final Response hbp()
  {
    Object localObject1 = getReqResp();
    if ((localObject1 instanceof c))
    {
      localObject1 = c.c.b(((c)localObject1).otC);
      try
      {
        localObject1 = (esc)localObject1;
        return localObject1;
      }
      finally
      {
        Log.w("SnsAd.AbsNetScene", "the response result is not the required!!!!");
      }
    }
    return null;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    try
    {
      if (this.PXN != null) {
        this.PXN.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.h.a
 * JD-Core Version:    0.7.0.1
 */