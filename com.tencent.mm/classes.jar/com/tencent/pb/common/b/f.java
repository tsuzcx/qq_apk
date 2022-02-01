package com.tencent.pb.common.b;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.pb.common.b.a.a.a.v;
import com.tencent.pb.common.b.a.a.a.w;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.h;
import java.util.Iterator;
import java.util.LinkedList;

public class f
{
  private static f Ikf = null;
  private int Ikg = 0;
  private LinkedList<a> Ikh = null;
  public com.tencent.pb.talkroom.sdk.e Iki = null;
  private boolean Ikj = false;
  private boolean Ikk = true;
  
  private int a(a arg1, c paramc, String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    Object localObject = null;
    int i = fln();
    for (;;)
    {
      try
      {
        if ((paramArrayOfByte.length >= 200) && (paramArrayOfByte != null) && (paramArrayOfByte.length >= paramArrayOfByte.length)) {}
        localv = new a.v();
        localv.BX = paramInt1;
        localv.IlP = i;
        localv.userName = com.tencent.pb.a.a.a.flE();
        localv.IkG = paramInt2;
        if (paramArrayOfByte != null) {
          continue;
        }
        b.w("NETCMD", new Object[] { "body null" });
        paramArrayOfByte = (byte[])localObject;
      }
      catch (Exception paramArrayOfByte)
      {
        a.v localv;
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
        ((a)localObject).Ikm = ???;
        ((a)localObject).Ikn = paramc;
        ((a)localObject).Ikl = paramString;
      }
      if (paramArrayOfByte != null) {
        continue;
      }
      b.w("NETCMD", new Object[] { "cmd:" + paramInt1 + "|body is null" });
      return -1;
      localObject = new a.w();
      ((a.w)localObject).IlR = localv;
      ((a.w)localObject).body = paramArrayOfByte;
      paramArrayOfByte = com.google.b.a.e.b((com.google.b.a.e)localObject);
    }
    for (;;)
    {
      synchronized (this.Ikh)
      {
        this.Ikh.add(localObject);
        paramInt2 = 1933;
        switch (paramInt1)
        {
        default: 
          paramInt1 = paramInt2;
          b.d("NETCMD", new Object[] { "CLTSEND|", Integer.valueOf(i), Integer.valueOf(paramInt1), paramString, com.tencent.pb.a.a.a.flE() });
          if (this.Iki != null) {
            this.Iki.c(i, paramInt1, paramArrayOfByte);
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
  
  private static a.w cD(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = (a.w)com.google.b.a.e.a(new a.w(), paramArrayOfByte, paramArrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      b.w("NETCMD", new Object[] { "Exception genReadPackageData" + paramArrayOfByte.getMessage() });
    }
    return null;
  }
  
  public static int cE(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      b.w("NETCMD", new Object[] { "CLTNOT onNotify1 data == null ", Integer.valueOf(0) });
      h.acW(-1601);
      if ((!TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.fpu().seB)) || (!TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.fpu().IJy))) {
        com.tencent.wecall.talkroom.model.a.fpu().IJO.ad(new String[] { "notify", "datanull" });
      }
      for (;;)
      {
        return -1;
        h.a(com.tencent.wecall.talkroom.model.a.fpu().sHe, com.tencent.wecall.talkroom.model.a.fpu().ztl, new String[] { "notify", "datanull" });
      }
    }
    b.d("NETCMD", new Object[] { "CLTNOT onNotify data len=", Integer.valueOf(paramArrayOfByte.length) });
    return com.tencent.wecall.talkroom.model.a.fpu().cO(paramArrayOfByte);
  }
  
  private int fln()
  {
    synchronized (this.Ikh)
    {
      this.Ikg += 1;
      int i = this.Ikg;
      return i;
    }
  }
  
  public static f flo()
  {
    if (Ikf == null) {}
    try
    {
      if (Ikf == null) {
        Ikf = new f();
      }
      return Ikf;
    }
    finally {}
  }
  
  final int a(a parama, c paramc, int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2)
  {
    if (!this.Ikk)
    {
      b.w("NETCMD", new Object[] { "doSendTask mIsInitSucc is false" });
      return -1;
    }
    if (this.Ikj == true)
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
  
  public final int a(a parama, String paramString, com.google.b.a.e parame)
  {
    try
    {
      int i = a(parama, null, 31, paramString, com.google.b.a.e.b(parame), 0);
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
    //   1: getfield 136	com/tencent/pb/common/b/f$a:Ikn	Lcom/tencent/pb/common/b/c;
    //   4: ifnull +14 -> 18
    //   7: aload_1
    //   8: getfield 136	com/tencent/pb/common/b/f$a:Ikn	Lcom/tencent/pb/common/b/c;
    //   11: iload_2
    //   12: aload_3
    //   13: invokeinterface 257 3 0
    //   18: aload_1
    //   19: getfield 132	com/tencent/pb/common/b/f$a:Ikm	Lcom/tencent/pb/common/b/a;
    //   22: ifnull +17 -> 39
    //   25: aload_1
    //   26: getfield 132	com/tencent/pb/common/b/f$a:Ikm	Lcom/tencent/pb/common/b/a;
    //   29: aload_1
    //   30: getfield 139	com/tencent/pb/common/b/f$a:Ikl	Ljava/lang/String;
    //   33: iload_2
    //   34: invokeinterface 263 3 0
    //   39: aload_0
    //   40: getfield 31	com/tencent/pb/common/b/f:Ikh	Ljava/util/LinkedList;
    //   43: astore_3
    //   44: aload_3
    //   45: monitorenter
    //   46: aload_0
    //   47: getfield 31	com/tencent/pb/common/b/f:Ikh	Ljava/util/LinkedList;
    //   50: aload_1
    //   51: invokevirtual 266	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
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
    //   67: ldc_w 268
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: aload_3
    //   74: invokevirtual 170	java/lang/Exception:getMessage	()Ljava/lang/String;
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
  
  public final a abE(int paramInt)
  {
    for (;;)
    {
      synchronized (this.Ikh)
      {
        Iterator localIterator = this.Ikh.iterator();
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
    a locala = abE(paramInt);
    if ((locala == null) && (-1000 != paramInt))
    {
      b.w("NETCMD", new Object[] { "buf2Resp fail: taskId:" + paramInt + " not found" });
      com.tencent.pb.common.c.e.R(20007, 3, "-1202");
      return 1;
    }
    paramArrayOfByte = cD(paramArrayOfByte);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.IlR == null))
    {
      if (paramArrayOfByte == null) {}
      for (paramArrayOfByte = " pack is null ";; paramArrayOfByte = " head is " + paramArrayOfByte.IlR)
      {
        b.w("NETCMD", new Object[] { " pack.head: ", paramArrayOfByte });
        a(locala, -3, null);
        return -1;
      }
    }
    int i = paramArrayOfByte.IlR.ret;
    int j = paramArrayOfByte.IlR.IlQ;
    String str = paramArrayOfByte.IlR.userName;
    if (com.tencent.pb.common.a.a.Ijw) {
      Toast.makeText(com.tencent.pb.common.c.c.ztG, "retCode: " + i + " debugCode: " + j, 0).show();
    }
    if ((i != 0) && (locala != null)) {
      b.w("NETCMD", new Object[] { "CLTRCV", Integer.valueOf(paramInt), locala.Ikl, Integer.valueOf(i), str, Integer.valueOf(j) });
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
        b.d("NETCMD", new Object[] { "CLTRCV", Integer.valueOf(paramInt), locala.Ikl, Integer.valueOf(i), str, Integer.valueOf(j) });
      }
    }
    a(locala, i, null);
    return 0;
  }
  
  public final class a
  {
    public String Ikl;
    a Ikm;
    c Ikn;
    int mTaskId;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.f
 * JD-Core Version:    0.7.0.1
 */