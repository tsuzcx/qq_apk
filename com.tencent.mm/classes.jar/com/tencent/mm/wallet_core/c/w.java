package com.tencent.mm.wallet_core.c;

import android.os.Bundle;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.t.a.a;
import com.tencent.mm.plugin.t.a.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public abstract class w
  extends q
  implements m
{
  private Bundle mBundle;
  private int mCmdId = 0;
  private String mProcessName = "";
  private long mRequestTime;
  private int mScene = 0;
  public long sessionId = 0L;
  
  private long reportCostTime(int paramInt1, int paramInt2)
  {
    long l1 = System.currentTimeMillis() - this.mRequestTime;
    Object localObject2 = "";
    Object localObject1 = "";
    this.mCmdId = getCgicmdForKV();
    long l2 = System.currentTimeMillis();
    if (this.mBundle != null)
    {
      String str1 = this.mBundle.getString("key_TransId");
      String str2 = this.mBundle.getString("key_reqKey");
      if (this.sessionId == 0L) {
        this.sessionId = this.mBundle.getLong("key_SessionId", 0L);
      }
      localObject1 = str2;
      localObject2 = str1;
      if (this.mScene == 0)
      {
        this.mScene = this.mBundle.getInt("key_scene");
        localObject2 = str1;
        localObject1 = str2;
      }
    }
    h.CyF.a(11170, new Object[] { Integer.valueOf(getType()), Integer.valueOf(this.mCmdId), Long.valueOf(l1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(NetStatusUtil.getNetType(MMApplicationContext.getContext())), this.mProcessName, localObject2, localObject1, Long.valueOf(this.sessionId), Long.valueOf(l2) });
    ab.a(getType(), getCgicmdForKV(), paramInt1, paramInt2, l1, this.mScene, this.mProcessName);
    return l1;
  }
  
  public int dispatch(g paramg, s params, m paramm)
  {
    this.mRequestTime = System.currentTimeMillis();
    c.eBv().sC(false);
    return super.dispatch(paramg, params, paramm);
  }
  
  public int getCgicmdForKV()
  {
    return -1;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte, reportCostTime(paramInt2, paramInt3));
  }
  
  public abstract void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong);
  
  public void setCmdId(int paramInt)
  {
    this.mCmdId = paramInt;
  }
  
  public void setProcessBundle(Bundle paramBundle)
  {
    this.mBundle = paramBundle;
  }
  
  public void setProcessName(String paramString)
  {
    this.mProcessName = paramString;
  }
  
  public void setProcessSessionId(long paramLong)
  {
    this.sessionId = paramLong;
  }
  
  public void setScene(int paramInt)
  {
    this.mScene = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.w
 * JD-Core Version:    0.7.0.1
 */