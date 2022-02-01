package com.tencent.mm.plugin.report.service;

import android.content.Context;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.report.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  private static Byte OAb;
  private static String filePath;
  
  static
  {
    AppMethodBeat.i(143852);
    filePath = getAppFilePath() + "/kvcomm/exception/";
    OAb = Byte.valueOf((byte)0);
    if (!y.ZC(filePath)) {
      y.bDX(filePath);
    }
    AppMethodBeat.o(143852);
  }
  
  public static void a(int paramInt1, int paramInt2, String arg2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(143848);
    if (!y.ZC(filePath))
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, filepath:" + filePath + " not exist , logId:" + paramInt1 + ", type:" + paramInt2 + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1 + ", ignoreFreqLimit:" + paramBoolean3);
      AppMethodBeat.o(143848);
      return;
    }
    Log.i("MicroMsg.ReportManagerKvCheck", "saveKVcommData, logId:" + paramInt1 + ", type:" + paramInt2 + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1 + "," + paramBoolean3);
    String str = gNU();
    if ("MM".equals(str))
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "error path, invalid processname:" + str + ", logId:" + paramInt1 + ", type:" + paramInt2 + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1 + ", ignoreFreqLimit:" + paramBoolean3);
      AppMethodBeat.o(143848);
      return;
    }
    str = filePath + str + ".statictis_new2";
    Object localObject2 = new d();
    ((d)localObject2).muy = paramInt1;
    ((d)localObject2).vhJ = paramInt2;
    ((d)localObject2).OzQ = ???;
    ((d)localObject2).OzI = paramBoolean2;
    ((d)localObject2).OzR = paramBoolean1;
    ((d)localObject2).OzS = paramBoolean3;
    try
    {
      localObject2 = ((d)localObject2).toByteArray();
      if (localObject2 == null)
      {
        Log.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, null == temp.");
        AppMethodBeat.o(143848);
        return;
      }
    }
    catch (IOException ???)
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + ???.getMessage());
      AppMethodBeat.o(143848);
      return;
    }
    synchronized (OAb)
    {
      byte[] arrayOfByte = ahv(localObject2.length);
      if (y.e(str, arrayOfByte, arrayOfByte.length) != 0)
      {
        Log.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write obj_len to file:" + str + " fail.");
        AppMethodBeat.o(143848);
        return;
      }
      if (y.e(str, (byte[])localObject2, localObject2.length) != 0) {
        Log.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write object to file:" + str + " fail.");
      }
      AppMethodBeat.o(143848);
      return;
    }
  }
  
  private static byte[] ahv(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  private static int byteArrayToInt(byte[] paramArrayOfByte)
  {
    int i = 0;
    int k;
    int m;
    for (int j = 0;; j = ((m & 0xFF) << (3 - k) * 8) + j)
    {
      k = i;
      if (k >= 4) {
        break;
      }
      m = paramArrayOfByte[k];
      i = k + 1;
    }
    return j;
  }
  
  public static void d(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(143849);
    Log.i("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, id:" + paramInt1 + ", key:" + paramInt2 + ", value:" + paramInt3 + ", isImportant:" + paramBoolean);
    if (!y.ZC(filePath))
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, filepath:" + filePath + " not exist , Id:" + paramInt1 + ", key:" + paramInt2 + ", value:" + paramInt3 + ", isImportant:" + paramBoolean);
      AppMethodBeat.o(143849);
      return;
    }
    String str = gNU();
    if ("MM".equals(str))
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:" + str + ", id:" + paramInt1 + ", key:" + paramInt2 + ", val:" + paramInt3 + ", isImportant:" + paramBoolean);
      AppMethodBeat.o(143849);
      return;
    }
    str = filePath + str + ".monitor";
    ??? = new b();
    ((b)???).hjP = paramInt1;
    ((b)???).OzG = paramInt2;
    ((b)???).OzH = paramInt3;
    ((b)???).OzI = paramBoolean;
    byte[] arrayOfByte1;
    try
    {
      arrayOfByte1 = ((b)???).toByteArray();
      if (arrayOfByte1 == null)
      {
        Log.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, null == temp.");
        AppMethodBeat.o(143849);
        return;
      }
    }
    catch (IOException localIOException)
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + localIOException.getMessage());
      AppMethodBeat.o(143849);
      return;
    }
    synchronized (OAb)
    {
      byte[] arrayOfByte2 = ahv(arrayOfByte1.length);
      if (y.e(localIOException, arrayOfByte2, arrayOfByte2.length) != 0)
      {
        Log.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write obj_len to file:" + localIOException + " fail.");
        AppMethodBeat.o(143849);
        return;
      }
      if (y.e(localIOException, arrayOfByte1, arrayOfByte1.length) != 0) {
        Log.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write object to file:" + localIOException + " fail.");
      }
      Log.d("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, fileLength:" + y.bEl(localIOException));
      AppMethodBeat.o(143849);
      return;
    }
  }
  
  public static void gNT()
  {
    AppMethodBeat.i(143847);
    for (;;)
    {
      int j;
      String str1;
      int i;
      synchronized (OAb)
      {
        if (!y.ZC(filePath))
        {
          Log.w("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filepath:" + filePath + " not exist.");
          AppMethodBeat.o(143847);
          return;
        }
        u[] arrayOfu = new u(filePath).jKX();
        if (arrayOfu == null)
        {
          Log.e("MicroMsg.ReportManagerKvCheck", "list file fail, filePath:" + filePath);
          AppMethodBeat.o(143847);
          return;
        }
        int k = arrayOfu.length;
        j = 0;
        if (j >= k) {
          break label1033;
        }
        localObject2 = arrayOfu[j];
        if (localObject2 == null)
        {
          Log.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, file is null");
        }
        else
        {
          str1 = ah.v(((u)localObject2).jKT());
          i = 0;
          int m = (int)y.bEl(str1);
          Log.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filename:" + ah.v(((u)localObject2).jKT()) + ", filelenth:" + m);
          if (i >= m)
          {
            Log.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, read to end, deletefile:".concat(String.valueOf(str1)));
            label219:
            y.deleteFile(str1);
          }
        }
      }
      Object localObject2 = y.bi(str1, i, 4);
      if (localObject2 == null)
      {
        Log.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_len fail. delete file:".concat(String.valueOf(str1)));
      }
      else
      {
        i += 4;
        int n;
        try
        {
          n = byteArrayToInt((byte[])localObject2);
          localObject2 = y.bi(str1, i, n);
          if (localObject2 != null) {
            break label340;
          }
          Log.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_data fail. delete file:".concat(String.valueOf(str1)));
        }
        catch (Exception localException1)
        {
          Log.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, byteArrayToInt error. delete file:".concat(String.valueOf(str1)));
        }
        continue;
        label340:
        i += n;
        Object localObject3;
        if (str1.contains(".statictis_new2")) {
          localObject3 = new d();
        }
        for (;;)
        {
          boolean bool1;
          try
          {
            ((d)localObject3).parseFrom(localException1);
            int i1 = ((d)localObject3).muy;
            int i2 = ((d)localObject3).vhJ;
            String str2 = ((d)localObject3).OzQ;
            bool1 = ((d)localObject3).OzI;
            boolean bool2 = ((d)localObject3).OzR;
            boolean bool3 = ((d)localObject3).OzS;
            Log.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportkvcomm, logid:" + i1 + ", type:" + i2 + ", value:" + str2 + ", isReportNow:" + bool2 + ", isImportant" + bool1);
            localObject3 = h.OAn;
            h.c(i1, i2, str2, bool2, bool3);
            Log.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, curLen:".concat(String.valueOf(i)));
          }
          catch (Exception localException2)
          {
            Log.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(kvcomm), objLen = " + n + ", Exception:" + localException2.getMessage());
            if (n == 0) {
              break label567;
            }
          }
          if (!com.tencent.matrix.c.a.ni(83)) {
            break label1049;
          }
          label567:
          e.a.ns(83);
          break label219;
          if (str1.contains(".monitor"))
          {
            localObject3 = new b();
            try
            {
              ((b)localObject3).parseFrom(localException2);
              long l1 = ((b)localObject3).hjP;
              long l2 = ((b)localObject3).OzG;
              long l3 = ((b)localObject3).OzH;
              bool1 = ((b)localObject3).OzI;
              Log.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportidkey, id:" + l1 + ", key:" + l2 + ", value:" + l3 + ", isImportant" + bool1);
              h.OAn.idkeyStat(l1, l2, l3, bool1);
            }
            catch (IOException localIOException1)
            {
              Log.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), objLen = " + n + ", IOException:" + localIOException1.getMessage());
              if (n == 0) {
                break label756;
              }
            }
            if (!com.tencent.matrix.c.a.ni(83)) {
              break label1052;
            }
            label756:
            e.a.ns(83);
            break label219;
          }
          if (!str1.contains(".group_monitor")) {
            break label1014;
          }
          localObject3 = new a();
          try
          {
            ((a)localObject3).parseFrom(localIOException1);
            ArrayList localArrayList = new ArrayList();
            bool1 = false;
            localObject3 = ((a)localObject3).OzF.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              b localb = (b)((Iterator)localObject3).next();
              IDKey localIDKey = new IDKey(localb.hjP, localb.OzG, localb.OzH);
              bool1 = localb.OzI;
              localArrayList.add(localIDKey);
              Log.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, idkeyGroupStat, id:" + localb.hjP + ", key:" + localb.OzG + ", value:" + localb.OzH + ", isImportant" + bool1);
            }
            h.OAn.b(localArrayList, bool1);
          }
          catch (IOException localIOException2)
          {
            Log.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), objLen = " + n + ", IOException:" + localIOException2.getMessage());
            if (n == 0) {
              break label1006;
            }
          }
        }
        label1033:
        label1049:
        label1052:
        if (com.tencent.matrix.c.a.ni(83))
        {
          label1006:
          e.a.ns(83);
          continue;
          label1014:
          Log.e("MicroMsg.ReportManagerKvCheck", "invalid filename:".concat(String.valueOf(str1)));
          continue;
          AppMethodBeat.o(143847);
          return;
          j += 1;
          continue;
          continue;
        }
      }
    }
  }
  
  private static String gNU()
  {
    AppMethodBeat.i(143851);
    Object localObject = MMApplicationContext.getProcessName();
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      AppMethodBeat.o(143851);
      return "MM";
    }
    localObject = ((String)localObject).split(":");
    if (localObject.length <= 1)
    {
      AppMethodBeat.o(143851);
      return "MM";
    }
    localObject = localObject[1];
    AppMethodBeat.o(143851);
    return localObject;
  }
  
  private static String getAppFilePath()
  {
    AppMethodBeat.i(143846);
    Object localObject = MMApplicationContext.getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(143846);
      return null;
    }
    try
    {
      localObject = u.V(((Context)localObject).getFilesDir());
      if (!((u)localObject).jKS()) {
        ((u)localObject).jKZ();
      }
      localObject = ((u)localObject).toString();
      AppMethodBeat.o(143846);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ReportManagerKvCheck", localException.getMessage());
      AppMethodBeat.o(143846);
    }
    return null;
  }
  
  public static void h(ArrayList<IDKey> arg0, boolean paramBoolean)
  {
    AppMethodBeat.i(143850);
    Object localObject1 = ???.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (IDKey)((Iterator)localObject1).next();
      Log.i("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, id:" + ((IDKey)localObject3).GetID() + ", key:" + ((IDKey)localObject3).GetKey() + ", value:" + ((IDKey)localObject3).GetValue() + ", isImportant:" + paramBoolean);
    }
    if (!y.ZC(filePath))
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, filepath:" + filePath + " not exist ");
      AppMethodBeat.o(143850);
      return;
    }
    localObject1 = gNU();
    if ("MM".equals(localObject1))
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(143850);
      return;
    }
    localObject1 = filePath + (String)localObject1 + ".group_monitor";
    Object localObject3 = new a();
    ((a)localObject3).vgN = ???.size();
    ??? = ???.iterator();
    Object localObject4;
    while (???.hasNext())
    {
      localObject4 = (IDKey)???.next();
      b localb = new b();
      localb.hjP = ((int)((IDKey)localObject4).GetID());
      localb.OzG = ((int)((IDKey)localObject4).GetKey());
      localb.OzH = ((int)((IDKey)localObject4).GetValue());
      localb.OzI = paramBoolean;
      ((a)localObject3).OzF.add(localb);
    }
    try
    {
      localObject3 = ((a)localObject3).toByteArray();
      if (localObject3 == null)
      {
        Log.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, null == temp.");
        AppMethodBeat.o(143850);
        return;
      }
    }
    catch (IOException ???)
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, IOException, detail:" + ???.getMessage());
      AppMethodBeat.o(143850);
      return;
    }
    synchronized (OAb)
    {
      localObject4 = ahv(localObject3.length);
      if (y.e((String)localObject1, (byte[])localObject4, localObject4.length) != 0)
      {
        Log.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write obj_len to file:" + (String)localObject1 + " fail.");
        AppMethodBeat.o(143850);
        return;
      }
      if (y.e((String)localObject1, (byte[])localObject3, localObject3.length) != 0) {
        Log.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write object to file:" + (String)localObject1 + " fail.");
      }
      AppMethodBeat.o(143850);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.f
 * JD-Core Version:    0.7.0.1
 */