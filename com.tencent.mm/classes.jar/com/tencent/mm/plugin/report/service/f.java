package com.tencent.mm.plugin.report.service;

import android.content.Context;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  private static String filePath = getAppFilePath() + "/kvcomm/exception/";
  private static Byte nFE = new Byte((byte)0);
  
  static
  {
    if (!e.bK(filePath)) {
      e.bN(filePath);
    }
  }
  
  public static void a(int paramInt1, int paramInt2, String arg2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!e.bK(filePath))
    {
      y.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, filepath:" + filePath + " not exist , logId:" + paramInt1 + ", type:" + paramInt2 + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1);
      return;
    }
    y.i("MicroMsg.ReportManagerKvCheck", "saveKVcommData, logId:" + paramInt1 + ", type:" + paramInt2 + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1);
    String str1 = bwX();
    if ("MM".equals(str1))
    {
      y.e("MicroMsg.ReportManagerKvCheck", "error path, invalid processname:" + str1 + ", logId:" + paramInt1 + ", type:" + paramInt2 + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1);
      return;
    }
    str1 = filePath + str1 + ".statictis_new";
    Object localObject = new c();
    ((c)localObject).nFr = paramInt1;
    ((c)localObject).hQR = paramInt2;
    ((c)localObject).nFs = ???;
    ((c)localObject).nFk = paramBoolean2;
    ((c)localObject).nFt = paramBoolean1;
    try
    {
      localObject = ((c)localObject).toByteArray();
      if (localObject == null)
      {
        y.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, null == temp.");
        return;
      }
    }
    catch (IOException ???)
    {
      y.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + ???.getMessage());
      return;
    }
    synchronized (nFE)
    {
      if (e.e(str1, wH(localObject.length)) != 0)
      {
        y.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write obj_len to file:" + str1 + " fail.");
        return;
      }
    }
    if (e.e(str2, (byte[])localObject) != 0) {
      y.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write object to file:" + str2 + " fail.");
    }
  }
  
  private static int aI(byte[] paramArrayOfByte)
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
  
  public static void bwW()
  {
    if (!e.bK(filePath))
    {
      y.w("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filepath:" + filePath + " not exist.");
      return;
    }
    File[] arrayOfFile = new File(filePath).listFiles();
    if (arrayOfFile == null)
    {
      y.e("MicroMsg.ReportManagerKvCheck", "list file fail, filePath:" + filePath);
      return;
    }
    for (;;)
    {
      int j;
      String str;
      int i;
      synchronized (nFE)
      {
        int k = arrayOfFile.length;
        j = 0;
        if (j >= k) {
          break label905;
        }
        localObject2 = arrayOfFile[j];
        if (localObject2 == null)
        {
          y.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, file is null");
        }
        else
        {
          str = ((File)localObject2).getAbsolutePath();
          i = 0;
          int m = e.bJ(str);
          y.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filename:" + ((File)localObject2).getAbsolutePath() + ", filelenth:" + m);
          if (i >= m)
          {
            y.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, read to end, deletefile:" + str);
            e.deleteFile(str);
          }
        }
      }
      Object localObject2 = e.c(str, i, 4);
      if (localObject2 == null)
      {
        y.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_len fail. delete file:" + str);
      }
      else
      {
        i += 4;
        int n = aI((byte[])localObject2);
        localObject2 = e.c(str, i, n);
        if (localObject2 == null)
        {
          y.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_data fail. delete file:" + str);
        }
        else
        {
          i += n;
          Object localObject3;
          if (str.contains(".statictis_new")) {
            localObject3 = new c();
          }
          for (;;)
          {
            boolean bool1;
            try
            {
              ((c)localObject3).aH((byte[])localObject2);
              n = ((c)localObject3).nFr;
              int i1 = ((c)localObject3).hQR;
              localObject2 = ((c)localObject3).nFs;
              bool1 = ((c)localObject3).nFk;
              boolean bool2 = ((c)localObject3).nFt;
              y.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportkvcomm, logid:" + n + ", type:" + i1 + ", value:" + (String)localObject2 + ", isReportNow:" + bool2 + ", isImportant" + bool1);
              localObject3 = h.nFQ;
              h.d(n, i1, (String)localObject2, bool2);
              y.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, curLen:" + i);
            }
            catch (IOException localIOException1)
            {
              y.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(kvcomm), IOException:" + localIOException1.getMessage());
            }
            break;
            if (str.contains(".monitor"))
            {
              localObject3 = new b();
              try
              {
                ((b)localObject3).aH(localIOException1);
                long l1 = ((b)localObject3).bxH;
                long l2 = ((b)localObject3).nFi;
                long l3 = ((b)localObject3).nFj;
                bool1 = ((b)localObject3).nFk;
                y.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportidkey, id:" + l1 + ", key:" + l2 + ", value:" + l3 + ", isImportant" + bool1);
                h.nFQ.a(l1, l2, l3, bool1);
              }
              catch (IOException localIOException2)
              {
                y.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + localIOException2.getMessage());
              }
              break;
            }
            if (!str.contains(".group_monitor")) {
              break label879;
            }
            localObject3 = new a();
            try
            {
              ((a)localObject3).aH(localIOException2);
              ArrayList localArrayList = new ArrayList();
              bool1 = false;
              localObject3 = ((a)localObject3).nFh.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                b localb = (b)((Iterator)localObject3).next();
                IDKey localIDKey = new IDKey(localb.bxH, localb.nFi, localb.nFj);
                bool1 = localb.nFk;
                localArrayList.add(localIDKey);
                y.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, idkeyGroupStat, id:" + localb.bxH + ", key:" + localb.nFi + ", value:" + localb.nFj + ", isImportant" + bool1);
              }
              h.nFQ.b(localArrayList, bool1);
            }
            catch (IOException localIOException3)
            {
              y.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + localIOException3.getMessage());
            }
          }
          continue;
          label879:
          y.e("MicroMsg.ReportManagerKvCheck", "invalid filename:" + str);
          continue;
          label905:
          return;
          j += 1;
        }
      }
    }
  }
  
  private static String bwX()
  {
    Object localObject = ae.getProcessName();
    if ((localObject == null) || (((String)localObject).length() == 0)) {
      return "MM";
    }
    localObject = ((String)localObject).split(":");
    if (localObject.length <= 1) {
      return "MM";
    }
    return localObject[1];
  }
  
  public static void c(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    y.i("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, id:" + paramInt1 + ", key:" + paramInt2 + ", value:" + paramInt3 + ", isImportant:" + paramBoolean);
    if (!e.bK(filePath))
    {
      y.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, filepath:" + filePath + " not exist , Id:" + paramInt1 + ", key:" + paramInt2 + ", value:" + paramInt3 + ", isImportant:" + paramBoolean);
      return;
    }
    String str1 = bwX();
    if ("MM".equals(str1))
    {
      y.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:" + str1 + ", id:" + paramInt1 + ", key:" + paramInt2 + ", val:" + paramInt3 + ", isImportant:" + paramBoolean);
      return;
    }
    str1 = filePath + str1 + ".monitor";
    ??? = new b();
    ((b)???).bxH = paramInt1;
    ((b)???).nFi = paramInt2;
    ((b)???).nFj = paramInt3;
    ((b)???).nFk = paramBoolean;
    byte[] arrayOfByte;
    try
    {
      arrayOfByte = ((b)???).toByteArray();
      if (arrayOfByte == null)
      {
        y.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, null == temp.");
        return;
      }
    }
    catch (IOException localIOException)
    {
      y.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + localIOException.getMessage());
      return;
    }
    synchronized (nFE)
    {
      if (e.e(localIOException, wH(arrayOfByte.length)) != 0)
      {
        y.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write obj_len to file:" + localIOException + " fail.");
        return;
      }
    }
    if (e.e(str2, arrayOfByte) != 0) {
      y.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write object to file:" + str2 + " fail.");
    }
    y.d("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, fileLength:" + e.bJ(str2));
  }
  
  public static void d(ArrayList<IDKey> arg0, boolean paramBoolean)
  {
    Object localObject1 = ???.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IDKey)((Iterator)localObject1).next();
      y.i("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, id:" + ((IDKey)localObject2).GetID() + ", key:" + ((IDKey)localObject2).GetKey() + ", value:" + ((IDKey)localObject2).GetValue() + ", isImportant:" + paramBoolean);
    }
    if (!e.bK(filePath))
    {
      y.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, filepath:" + filePath + " not exist ");
      return;
    }
    localObject1 = bwX();
    if ("MM".equals(localObject1))
    {
      y.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:" + (String)localObject1);
      return;
    }
    localObject1 = filePath + (String)localObject1 + ".group_monitor";
    Object localObject2 = new a();
    ((a)localObject2).hPS = ???.size();
    ??? = ???.iterator();
    while (???.hasNext())
    {
      IDKey localIDKey = (IDKey)???.next();
      b localb = new b();
      localb.bxH = ((int)localIDKey.GetID());
      localb.nFi = ((int)localIDKey.GetKey());
      localb.nFj = ((int)localIDKey.GetValue());
      localb.nFk = paramBoolean;
      ((a)localObject2).nFh.add(localb);
    }
    try
    {
      localObject2 = ((a)localObject2).toByteArray();
      if (localObject2 == null)
      {
        y.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, null == temp.");
        return;
      }
    }
    catch (IOException ???)
    {
      y.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, IOException, detail:" + ???.getMessage());
      return;
    }
    synchronized (nFE)
    {
      if (e.e((String)localObject1, wH(localObject2.length)) != 0)
      {
        y.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write obj_len to file:" + (String)localObject1 + " fail.");
        return;
      }
    }
    if (e.e(str, (byte[])localObject2) != 0) {
      y.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write object to file:" + str + " fail.");
    }
  }
  
  private static String getAppFilePath()
  {
    Object localObject = ae.getContext();
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((Context)localObject).getFilesDir();
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      localObject = ((File)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ReportManagerKvCheck", localException.getMessage());
    }
    return null;
  }
  
  private static byte[] wH(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.f
 * JD-Core Version:    0.7.0.1
 */