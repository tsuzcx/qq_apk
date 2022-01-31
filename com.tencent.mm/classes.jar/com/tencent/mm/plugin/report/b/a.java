package com.tencent.mm.plugin.report.b;

import com.tencent.mm.a.e;
import com.tencent.mm.protocal.c.apb;
import com.tencent.mm.protocal.c.ayi;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static String filename = "heavy_user_id_mapping.dat";
  private static Object lock = new Object();
  private a nEN = null;
  private int nEO = 0;
  private int nEP = 1;
  private int nEQ = 2;
  private int nER = 3;
  
  private static void a(apb paramapb, boolean paramBoolean)
  {
    ayi localayi;
    if (paramBoolean)
    {
      y.i("MicroMsg.HeavyUserIDMappingStg", "################################# svr heavy user strategy #############################");
      y.i("MicroMsg.HeavyUserIDMappingStg", "svr_version:" + paramapb.tkU + ", ret:" + paramapb.tkW);
      paramapb = paramapb.tkV.iterator();
      while (paramapb.hasNext())
      {
        localayi = (ayi)paramapb.next();
        y.i("MicroMsg.HeavyUserIDMappingStg", "origin:" + localayi.tus + ", userid:" + localayi.tut);
      }
      y.i("MicroMsg.HeavyUserIDMappingStg", "#################################  End ################################################");
      return;
    }
    y.d("MicroMsg.HeavyUserIDMappingStg", "################################# Local heavy user strategy #############################");
    y.d("MicroMsg.HeavyUserIDMappingStg", "svr_version:" + paramapb.tkU + ", ret:" + paramapb.tkW);
    paramapb = paramapb.tkV.iterator();
    while (paramapb.hasNext())
    {
      localayi = (ayi)paramapb.next();
      y.d("MicroMsg.HeavyUserIDMappingStg", "origin:" + localayi.tus + ", userid:" + localayi.tut);
    }
    y.d("MicroMsg.HeavyUserIDMappingStg", "#################################  End ################################################");
  }
  
  public static apb bwN()
  {
    y.d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingObj");
    synchronized (lock)
    {
      byte[] arrayOfByte1 = e.d(ac.dOP + filename, 0, -1);
      if (arrayOfByte1 == null)
      {
        y.w("MicroMsg.HeavyUserIDMappingStg", "get file content fail, filename" + filename);
        return null;
      }
    }
    ??? = new apb();
    try
    {
      ((apb)???).aH(arrayOfByte2);
      a((apb)???, false);
      return ???;
    }
    catch (IOException localIOException)
    {
      y.printErrStackTrace("MicroMsg.HeavyUserIDMappingStg", localIOException, "", new Object[0]);
    }
    return null;
  }
  
  public static int wG(int paramInt)
  {
    y.d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingVersion,chanel:" + paramInt);
    apb localapb = bwN();
    if (localapb == null) {
      return 0;
    }
    paramInt = localapb.tkU;
    y.i("MicroMsg.HeavyUserIDMappingStg", "version:" + paramInt);
    return paramInt;
  }
  
  public final void a(apb paramapb, int paramInt)
  {
    y.i("MicroMsg.HeavyUserIDMappingStg", "saveIDMapping, channel:" + paramInt);
    if (paramapb == null)
    {
      y.w("MicroMsg.HeavyUserIDMappingStg", "HeavyUserRespInfo is null");
      return;
    }
    Object localObject2;
    if (this.nEO != paramapb.tkW)
    {
      localObject2 = new StringBuilder("heavyUserRespInfo.RespType Unnormal, type:");
      paramInt = paramapb.tkW;
      if (this.nEP == paramInt) {
        ??? = "服务器过载";
      }
      for (;;)
      {
        y.e("MicroMsg.HeavyUserIDMappingStg", (String)??? + ",version:" + paramapb.tkU);
        return;
        if (this.nEQ == paramInt) {
          ??? = "服务器没有配置表";
        } else if (this.nER == paramInt) {
          ??? = "服务器配置表错误";
        } else {
          ??? = "非法的错误类型";
        }
      }
    }
    int i = wG(paramInt);
    int j = paramapb.tkU;
    if (i == j)
    {
      y.d("MicroMsg.HeavyUserIDMappingStg", "client has same version with Srv, version:" + j);
      return;
    }
    y.i("MicroMsg.HeavyUserIDMappingStg", "version changed, client:" + wG(paramInt) + ", svr:" + j);
    a(paramapb, true);
    try
    {
      localObject2 = paramapb.toByteArray();
      synchronized (lock)
      {
        y.i("MicroMsg.HeavyUserIDMappingStg", "new version:" + paramapb.tkU);
        e.b(ac.dOP, filename, (byte[])localObject2);
        return;
      }
      return;
    }
    catch (IOException paramapb)
    {
      y.printErrStackTrace("MicroMsg.HeavyUserIDMappingStg", paramapb, "", new Object[0]);
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.a
 * JD-Core Version:    0.7.0.1
 */