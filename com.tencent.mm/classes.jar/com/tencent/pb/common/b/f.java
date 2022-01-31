package com.tencent.pb.common.b;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.pb.common.b.a.a.u;
import com.tencent.pb.common.b.a.a.v;
import com.tencent.pb.common.c.d;
import com.tencent.wecall.talkroom.model.h;
import java.util.Iterator;
import java.util.LinkedList;

public class f
{
  private static f wFJ = null;
  private int wFK = 0;
  private LinkedList<f.a> wFL = null;
  public com.tencent.pb.talkroom.sdk.e wFM = null;
  private boolean wFN = false;
  private boolean wFO = true;
  
  private int a(a arg1, c paramc, String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    Object localObject = null;
    int i = cNU();
    for (;;)
    {
      try
      {
        if ((paramArrayOfByte.length >= 200) && (paramArrayOfByte != null) && (paramArrayOfByte.length >= paramArrayOfByte.length)) {}
        localu = new a.u();
        localu.uC = paramInt1;
        localu.wHt = i;
        localu.userName = com.tencent.pb.a.a.a.cOl();
        localu.wGk = paramInt2;
        if (paramArrayOfByte != null) {
          continue;
        }
        com.tencent.pb.common.c.c.x("NETCMD", new Object[] { "body null" });
        paramArrayOfByte = (byte[])localObject;
      }
      catch (Exception paramArrayOfByte)
      {
        a.u localu;
        com.tencent.pb.common.c.c.x("NetError", new Object[] { "newTaskHelper addTask body null" });
        paramArrayOfByte = null;
        continue;
        if (paramArrayOfByte.length <= 61440) {
          continue;
        }
        com.tencent.pb.common.c.c.x("NETCMD", new Object[] { "cmd:" + paramInt1 + "|body too large" });
        return -1;
        localObject = new f.a(this, (byte)0);
        ((f.a)localObject).mTaskId = i;
        ((f.a)localObject).wFQ = ???;
        ((f.a)localObject).wFR = paramc;
        ((f.a)localObject).wFP = paramString;
      }
      if (paramArrayOfByte != null) {
        continue;
      }
      com.tencent.pb.common.c.c.x("NETCMD", new Object[] { "cmd:" + paramInt1 + "|body is null" });
      return -1;
      localObject = new a.v();
      ((a.v)localObject).wHv = localu;
      ((a.v)localObject).body = paramArrayOfByte;
      paramArrayOfByte = com.google.a.a.e.b((com.google.a.a.e)localObject);
    }
    for (;;)
    {
      synchronized (this.wFL)
      {
        this.wFL.add(localObject);
        paramInt2 = 1933;
        switch (paramInt1)
        {
        default: 
          paramInt1 = paramInt2;
          com.tencent.pb.common.c.c.d("NETCMD", new Object[] { "CLTSEND|", Integer.valueOf(i), Integer.valueOf(paramInt1), paramString, com.tencent.pb.a.a.a.cOl() });
          if (this.wFM != null) {
            this.wFM.c(i, paramInt1, paramArrayOfByte);
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
  
  private static a.v bL(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = (a.v)com.google.a.a.e.a(new a.v(), paramArrayOfByte, paramArrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      com.tencent.pb.common.c.c.x("NETCMD", new Object[] { "Exception genReadPackageData" + paramArrayOfByte.getMessage() });
    }
    return null;
  }
  
  public static int bM(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      com.tencent.pb.common.c.c.x("NETCMD", new Object[] { "CLTNOT onNotify1 data == null ", Integer.valueOf(0) });
      h.KA(-1601);
      if ((!TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.cRq().kWU)) || (!TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.cRq().xdQ))) {
        com.tencent.wecall.talkroom.model.a.cRq().xdZ.R(new String[] { "notify", "datanull" });
      }
      for (;;)
      {
        return -1;
        h.a(com.tencent.wecall.talkroom.model.a.cRq().lvU, com.tencent.wecall.talkroom.model.a.cRq().xdR, new String[] { "notify", "datanull" });
      }
    }
    com.tencent.pb.common.c.c.d("NETCMD", new Object[] { "CLTNOT onNotify data len=", Integer.valueOf(paramArrayOfByte.length) });
    return com.tencent.wecall.talkroom.model.a.cRq().bU(paramArrayOfByte);
  }
  
  private int cNU()
  {
    synchronized (this.wFL)
    {
      this.wFK += 1;
      int i = this.wFK;
      return i;
    }
  }
  
  public static f cNV()
  {
    if (wFJ == null) {}
    try
    {
      if (wFJ == null) {
        wFJ = new f();
      }
      return wFJ;
    }
    finally {}
  }
  
  public final f.a Jf(int paramInt)
  {
    for (;;)
    {
      synchronized (this.wFL)
      {
        Iterator localIterator = this.wFL.iterator();
        if (localIterator.hasNext())
        {
          f.a locala = (f.a)localIterator.next();
          if (locala.mTaskId != paramInt) {
            continue;
          }
          return locala;
        }
      }
      Object localObject2 = null;
    }
  }
  
  final int a(a parama, c paramc, int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2)
  {
    if (!this.wFO)
    {
      com.tencent.pb.common.c.c.x("NETCMD", new Object[] { "doSendTask mIsInitSucc is false" });
      return -1;
    }
    if (this.wFN == true)
    {
      com.tencent.pb.common.c.c.x("NETCMD", new Object[] { "doSendTask fail: isRefreshing, cmd=" + paramInt1 + ", cmdTag=" + paramString });
      return -1;
    }
    try
    {
      paramInt1 = a(parama, paramc, paramString, paramInt1, paramArrayOfByte, paramInt2);
      return paramInt1;
    }
    catch (Throwable parama)
    {
      com.tencent.pb.common.c.c.x("NETCMD", new Object[] { "Exception doSendTask", parama });
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
      com.tencent.pb.common.c.c.x("NETCMD", new Object[] { "doSendTask exception:", parama });
    }
    return -1;
  }
  
  /* Error */
  public final void a(f.a parama, int paramInt, byte[] arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 136	com/tencent/pb/common/b/f$a:wFR	Lcom/tencent/pb/common/b/c;
    //   4: ifnull +14 -> 18
    //   7: aload_1
    //   8: getfield 136	com/tencent/pb/common/b/f$a:wFR	Lcom/tencent/pb/common/b/c;
    //   11: iload_2
    //   12: aload_3
    //   13: invokeinterface 273 3 0
    //   18: aload_1
    //   19: getfield 132	com/tencent/pb/common/b/f$a:wFQ	Lcom/tencent/pb/common/b/a;
    //   22: ifnull +17 -> 39
    //   25: aload_1
    //   26: getfield 132	com/tencent/pb/common/b/f$a:wFQ	Lcom/tencent/pb/common/b/a;
    //   29: aload_1
    //   30: getfield 139	com/tencent/pb/common/b/f$a:wFP	Ljava/lang/String;
    //   33: iload_2
    //   34: invokeinterface 279 3 0
    //   39: aload_0
    //   40: getfield 30	com/tencent/pb/common/b/f:wFL	Ljava/util/LinkedList;
    //   43: astore_3
    //   44: aload_3
    //   45: monitorenter
    //   46: aload_0
    //   47: getfield 30	com/tencent/pb/common/b/f:wFL	Ljava/util/LinkedList;
    //   50: aload_1
    //   51: invokevirtual 282	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
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
    //   67: ldc_w 284
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: aload_3
    //   74: invokevirtual 170	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   77: aastore
    //   78: invokestatic 79	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: goto -42 -> 39
    //   84: astore_1
    //   85: aload_3
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	f
    //   0	89	1	parama	f.a
    //   0	89	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   0	18	58	java/lang/Exception
    //   18	39	58	java/lang/Exception
    //   46	57	84	finally
    //   85	87	84	finally
  }
  
  public final int s(int paramInt, byte[] paramArrayOfByte)
  {
    f.a locala = Jf(paramInt);
    if ((locala == null) && (-1000 != paramInt))
    {
      com.tencent.pb.common.c.c.x("NETCMD", new Object[] { "buf2Resp fail: taskId:" + paramInt + " not found" });
      com.tencent.pb.common.c.f.y(20007, 3, "-1202");
      return 1;
    }
    paramArrayOfByte = bL(paramArrayOfByte);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.wHv == null))
    {
      if (paramArrayOfByte == null) {}
      for (paramArrayOfByte = " pack is null ";; paramArrayOfByte = " head is " + paramArrayOfByte.wHv)
      {
        com.tencent.pb.common.c.c.x("NETCMD", new Object[] { " pack.head: ", paramArrayOfByte });
        a(locala, -3, null);
        return -1;
      }
    }
    int i = paramArrayOfByte.wHv.ret;
    int j = paramArrayOfByte.wHv.wHu;
    String str = paramArrayOfByte.wHv.userName;
    if (com.tencent.pb.common.a.a.wEZ) {
      Toast.makeText(d.pZI, "retCode: " + i + " debugCode: " + j, 0).show();
    }
    if ((i != 0) && (locala != null)) {
      com.tencent.pb.common.c.c.x("NETCMD", new Object[] { "CLTRCV", Integer.valueOf(paramInt), locala.wFP, Integer.valueOf(i), str, Integer.valueOf(j) });
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
        com.tencent.pb.common.c.c.d("NETCMD", new Object[] { "CLTRCV", Integer.valueOf(paramInt), locala.wFP, Integer.valueOf(i), str, Integer.valueOf(j) });
      }
    }
    a(locala, i, null);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.f
 * JD-Core Version:    0.7.0.1
 */