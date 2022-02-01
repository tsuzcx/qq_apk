package com.tencent.pb.common.b;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.pb.common.b.a.a.a.w;
import com.tencent.pb.common.b.a.a.a.x;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.h;
import java.util.Iterator;
import java.util.LinkedList;

public class f
{
  private static f RCS = null;
  private int RCT = 0;
  private LinkedList<a> RCU = null;
  public com.tencent.pb.talkroom.sdk.e RCV = null;
  private boolean RCW = false;
  private boolean RCX = true;
  
  private int a(a arg1, c paramc, String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    Object localObject = null;
    int i = hiY();
    for (;;)
    {
      try
      {
        if ((paramArrayOfByte.length >= 200) && (paramArrayOfByte != null) && (paramArrayOfByte.length >= paramArrayOfByte.length)) {}
        localw = new a.w();
        localw.EX = paramInt1;
        localw.REE = i;
        localw.userName = com.tencent.pb.a.a.a.hjq();
        localw.RDt = paramInt2;
        if (paramArrayOfByte != null) {
          continue;
        }
        b.w("NETCMD", new Object[] { "body null" });
        paramArrayOfByte = (byte[])localObject;
      }
      catch (Exception paramArrayOfByte)
      {
        a.w localw;
        b.w("NetError", new Object[] { "newTaskHelper addTask body null" });
        paramArrayOfByte = null;
        continue;
        if (paramArrayOfByte.length <= 61440) {
          continue;
        }
        b.w("NETCMD", new Object[] { "cmd:" + paramInt1 + "|body too large" });
        return -1;
        localObject = new a((byte)0);
        ((a)localObject).mTaskId = i;
        ((a)localObject).RCZ = ???;
        ((a)localObject).RDa = paramc;
        ((a)localObject).RCY = paramString;
      }
      if (paramArrayOfByte != null) {
        continue;
      }
      b.w("NETCMD", new Object[] { "cmd:" + paramInt1 + "|body is null" });
      return -1;
      localObject = new a.x();
      ((a.x)localObject).REH = localw;
      ((a.x)localObject).body = paramArrayOfByte;
      paramArrayOfByte = com.google.a.a.e.b((com.google.a.a.e)localObject);
    }
    for (;;)
    {
      synchronized (this.RCU)
      {
        this.RCU.add(localObject);
        paramInt2 = 1933;
        switch (paramInt1)
        {
        default: 
          paramInt1 = paramInt2;
          b.d("NETCMD", new Object[] { "CLTSEND|", Integer.valueOf(i), Integer.valueOf(paramInt1), paramString, com.tencent.pb.a.a.a.hjq() });
          if (this.RCV != null) {
            this.RCV.d(i, paramInt1, paramArrayOfByte);
          }
          return i;
        }
      }
      paramInt1 = 1918;
      continue;
      paramInt1 = 1919;
      continue;
      paramInt1 = 1931;
      continue;
      paramInt1 = 1929;
      continue;
      paramInt1 = 1927;
      continue;
      paramInt1 = 1928;
      continue;
      paramInt1 = 1932;
      continue;
      paramInt1 = 1935;
      continue;
      paramInt1 = 1937;
      continue;
      paramInt1 = 1938;
      continue;
      paramInt1 = 1939;
    }
  }
  
  private static a.x cP(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = (a.x)com.google.a.a.e.a(new a.x(), paramArrayOfByte, paramArrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      b.w("NETCMD", new Object[] { "Exception genReadPackageData" + paramArrayOfByte.getMessage() });
    }
    return null;
  }
  
  public static int cQ(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      b.w("NETCMD", new Object[] { "CLTNOT onNotify1 data == null ", Integer.valueOf(0) });
      h.asK(-1601);
      if ((!TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.hqJ().xOr)) || (!TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.hqJ().SuH))) {
        com.tencent.wecall.talkroom.model.a.hqJ().SuY.ag(new String[] { "notify", "datanull" });
      }
      for (;;)
      {
        return -1;
        h.a(com.tencent.wecall.talkroom.model.a.hqJ().yvK, com.tencent.wecall.talkroom.model.a.hqJ().HgX, new String[] { "notify", "datanull" });
      }
    }
    b.d("NETCMD", new Object[] { "CLTNOT onNotify data len=", Integer.valueOf(paramArrayOfByte.length) });
    return com.tencent.wecall.talkroom.model.a.hqJ().dc(paramArrayOfByte);
  }
  
  private int hiY()
  {
    synchronized (this.RCU)
    {
      this.RCT += 1;
      int i = this.RCT;
      return i;
    }
  }
  
  public static f hiZ()
  {
    if (RCS == null) {}
    try
    {
      if (RCS == null) {
        RCS = new f();
      }
      return RCS;
    }
    finally {}
  }
  
  final int a(a parama, c paramc, int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2)
  {
    if (!this.RCX)
    {
      b.w("NETCMD", new Object[] { "doSendTask mIsInitSucc is false" });
      return -1;
    }
    if (this.RCW == true)
    {
      b.w("NETCMD", new Object[] { "doSendTask fail: isRefreshing, cmd=" + paramInt1 + ", cmdTag=" + paramString });
      return -1;
    }
    try
    {
      paramInt1 = a(parama, paramc, paramString, paramInt1, paramArrayOfByte, paramInt2);
      return paramInt1;
    }
    catch (Throwable parama)
    {
      b.w("NETCMD", new Object[] { "Exception doSendTask", parama });
    }
    return -1;
  }
  
  public final int a(a parama, String paramString, com.google.a.a.e parame)
  {
    try
    {
      int i = a(parama, null, 31, paramString, com.google.a.a.e.b(parame), 0);
      return i;
    }
    catch (Exception parama)
    {
      b.w("NETCMD", new Object[] { "doSendTask exception:", parama });
    }
    return -1;
  }
  
  /* Error */
  public final void a(a parama, int paramInt, byte[] arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 136	com/tencent/pb/common/b/f$a:RDa	Lcom/tencent/pb/common/b/c;
    //   4: ifnull +14 -> 18
    //   7: aload_1
    //   8: getfield 136	com/tencent/pb/common/b/f$a:RDa	Lcom/tencent/pb/common/b/c;
    //   11: iload_2
    //   12: aload_3
    //   13: invokeinterface 256 3 0
    //   18: aload_1
    //   19: getfield 132	com/tencent/pb/common/b/f$a:RCZ	Lcom/tencent/pb/common/b/a;
    //   22: ifnull +17 -> 39
    //   25: aload_1
    //   26: getfield 132	com/tencent/pb/common/b/f$a:RCZ	Lcom/tencent/pb/common/b/a;
    //   29: aload_1
    //   30: getfield 139	com/tencent/pb/common/b/f$a:RCY	Ljava/lang/String;
    //   33: iload_2
    //   34: invokeinterface 262 3 0
    //   39: aload_0
    //   40: getfield 31	com/tencent/pb/common/b/f:RCU	Ljava/util/LinkedList;
    //   43: astore_3
    //   44: aload_3
    //   45: monitorenter
    //   46: aload_0
    //   47: getfield 31	com/tencent/pb/common/b/f:RCU	Ljava/util/LinkedList;
    //   50: aload_1
    //   51: invokevirtual 265	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   54: pop
    //   55: aload_3
    //   56: monitorexit
    //   57: return
    //   58: astore_3
    //   59: ldc 71
    //   61: iconst_2
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: ldc_w 267
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: aload_3
    //   74: invokevirtual 169	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   77: aastore
    //   78: invokestatic 79	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: goto -42 -> 39
    //   84: astore_1
    //   85: aload_3
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	f
    //   0	89	1	parama	a
    //   0	89	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   0	18	58	java/lang/Exception
    //   18	39	58	java/lang/Exception
    //   46	57	84	finally
    //   85	87	84	finally
  }
  
  public final a aqt(int paramInt)
  {
    for (;;)
    {
      synchronized (this.RCU)
      {
        Iterator localIterator = this.RCU.iterator();
        if (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (locala.mTaskId != paramInt) {
            continue;
          }
          return locala;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public final int u(int paramInt, byte[] paramArrayOfByte)
  {
    a locala = aqt(paramInt);
    if ((locala == null) && (-1000 != paramInt))
    {
      b.w("NETCMD", new Object[] { "buf2Resp fail: taskId:" + paramInt + " not found" });
      com.tencent.pb.common.c.e.U(20007, 3, "-1202");
      return 1;
    }
    paramArrayOfByte = cP(paramArrayOfByte);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.REH == null))
    {
      if (paramArrayOfByte == null) {}
      for (paramArrayOfByte = " pack is null ";; paramArrayOfByte = " head is " + paramArrayOfByte.REH)
      {
        b.w("NETCMD", new Object[] { " pack.head: ", paramArrayOfByte });
        a(locala, -3, null);
        return -1;
      }
    }
    int i = paramArrayOfByte.REH.ret;
    int j = paramArrayOfByte.REH.REG;
    String str = paramArrayOfByte.REH.userName;
    if (com.tencent.pb.common.a.a.RCj) {
      Toast.makeText(com.tencent.pb.common.c.c.Hhs, "retCode: " + i + " debugCode: " + j, 0).show();
    }
    if ((i != 0) && (locala != null)) {
      b.w("NETCMD", new Object[] { "CLTRCV", Integer.valueOf(paramInt), locala.RCY, Integer.valueOf(i), str, Integer.valueOf(j) });
    }
    for (;;)
    {
      paramArrayOfByte = paramArrayOfByte.body;
      if (paramArrayOfByte == null) {
        break;
      }
      a(locala, i, paramArrayOfByte);
      return 0;
      if (locala != null) {
        b.d("NETCMD", new Object[] { "CLTRCV", Integer.valueOf(paramInt), locala.RCY, Integer.valueOf(i), str, Integer.valueOf(j) });
      }
    }
    a(locala, i, null);
    return 0;
  }
  
  public final class a
  {
    public String RCY;
    a RCZ;
    c RDa;
    int mTaskId;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.f
 * JD-Core Version:    0.7.0.1
 */