package com.tencent.mm.plugin.report.service;

import android.content.Context;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  private static String filePath;
  private static Byte qsI;
  
  static
  {
    AppMethodBeat.i(72739);
    filePath = getAppFilePath() + "/kvcomm/exception/";
    qsI = Byte.valueOf((byte)0);
    if (!com.tencent.mm.a.e.cN(filePath)) {
      com.tencent.mm.a.e.cQ(filePath);
    }
    AppMethodBeat.o(72739);
  }
  
  public static void a(int paramInt1, int paramInt2, String arg2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(72735);
    if (!com.tencent.mm.a.e.cN(filePath))
    {
      ab.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, filepath:" + filePath + " not exist , logId:" + paramInt1 + ", type:" + paramInt2 + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1 + ", ignoreFreqLimit:" + paramBoolean3);
      AppMethodBeat.o(72735);
      return;
    }
    ab.i("MicroMsg.ReportManagerKvCheck", "saveKVcommData, logId:" + paramInt1 + ", type:" + paramInt2 + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1 + "," + paramBoolean3);
    String str = chQ();
    if ("MM".equals(str))
    {
      ab.e("MicroMsg.ReportManagerKvCheck", "error path, invalid processname:" + str + ", logId:" + paramInt1 + ", type:" + paramInt2 + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1 + ", ignoreFreqLimit:" + paramBoolean3);
      AppMethodBeat.o(72735);
      return;
    }
    str = filePath + str + ".statictis_new2";
    Object localObject2 = new c();
    ((c)localObject2).qst = paramInt1;
    ((c)localObject2).jKs = paramInt2;
    ((c)localObject2).qsu = ???;
    ((c)localObject2).qsm = paramBoolean2;
    ((c)localObject2).qsv = paramBoolean1;
    ((c)localObject2).qsw = paramBoolean3;
    try
    {
      localObject2 = ((c)localObject2).toByteArray();
      if (localObject2 == null)
      {
        ab.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, null == temp.");
        AppMethodBeat.o(72735);
        return;
      }
    }
    catch (IOException ???)
    {
      ab.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + ???.getMessage());
      AppMethodBeat.o(72735);
      return;
    }
    synchronized (qsI)
    {
      if (com.tencent.mm.a.e.e(str, intToByteArray(localObject2.length)) != 0)
      {
        ab.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write obj_len to file:" + str + " fail.");
        AppMethodBeat.o(72735);
        return;
      }
      if (com.tencent.mm.a.e.e(str, (byte[])localObject2) != 0) {
        ab.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write object to file:" + str + " fail.");
      }
      AppMethodBeat.o(72735);
      return;
    }
  }
  
  private static int bg(byte[] paramArrayOfByte)
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
  
  public static void c(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(72736);
    ab.i("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, id:" + paramInt1 + ", key:" + paramInt2 + ", value:" + paramInt3 + ", isImportant:" + paramBoolean);
    if (!com.tencent.mm.a.e.cN(filePath))
    {
      ab.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, filepath:" + filePath + " not exist , Id:" + paramInt1 + ", key:" + paramInt2 + ", value:" + paramInt3 + ", isImportant:" + paramBoolean);
      AppMethodBeat.o(72736);
      return;
    }
    String str = chQ();
    if ("MM".equals(str))
    {
      ab.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:" + str + ", id:" + paramInt1 + ", key:" + paramInt2 + ", val:" + paramInt3 + ", isImportant:" + paramBoolean);
      AppMethodBeat.o(72736);
      return;
    }
    str = filePath + str + ".monitor";
    ??? = new b();
    ((b)???).ID = paramInt1;
    ((b)???).qsk = paramInt2;
    ((b)???).qsl = paramInt3;
    ((b)???).qsm = paramBoolean;
    byte[] arrayOfByte;
    try
    {
      arrayOfByte = ((b)???).toByteArray();
      if (arrayOfByte == null)
      {
        ab.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, null == temp.");
        AppMethodBeat.o(72736);
        return;
      }
    }
    catch (IOException localIOException)
    {
      ab.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + localIOException.getMessage());
      AppMethodBeat.o(72736);
      return;
    }
    synchronized (qsI)
    {
      if (com.tencent.mm.a.e.e(localIOException, intToByteArray(arrayOfByte.length)) != 0)
      {
        ab.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write obj_len to file:" + localIOException + " fail.");
        AppMethodBeat.o(72736);
        return;
      }
      if (com.tencent.mm.a.e.e(localIOException, arrayOfByte) != 0) {
        ab.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write object to file:" + localIOException + " fail.");
      }
      ab.d("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, fileLength:" + com.tencent.mm.a.e.cM(localIOException));
      AppMethodBeat.o(72736);
      return;
    }
  }
  
  public static void chP()
  {
    AppMethodBeat.i(72734);
    if (!com.tencent.mm.a.e.cN(filePath))
    {
      ab.w("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filepath:" + filePath + " not exist.");
      AppMethodBeat.o(72734);
      return;
    }
    File[] arrayOfFile = new File(filePath).listFiles();
    if (arrayOfFile == null)
    {
      ab.e("MicroMsg.ReportManagerKvCheck", "list file fail, filePath:" + filePath);
      AppMethodBeat.o(72734);
      return;
    }
    for (;;)
    {
      int j;
      String str;
      int i;
      synchronized (qsI)
      {
        int k = arrayOfFile.length;
        j = 0;
        if (j >= k) {
          break label984;
        }
        localObject2 = arrayOfFile[j];
        if (localObject2 == null)
        {
          ab.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, file is null");
        }
        else
        {
          str = ((File)localObject2).getAbsolutePath();
          i = 0;
          int m = com.tencent.mm.a.e.cM(str);
          ab.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filename:" + ((File)localObject2).getAbsolutePath() + ", filelenth:" + m);
          if (i >= m)
          {
            ab.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, read to end, deletefile:".concat(String.valueOf(str)));
            com.tencent.mm.a.e.deleteFile(str);
          }
        }
      }
      Object localObject2 = com.tencent.mm.a.e.i(str, i, 4);
      if (localObject2 == null)
      {
        ab.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_len fail. delete file:".concat(String.valueOf(str)));
      }
      else
      {
        i += 4;
        int n = bg((byte[])localObject2);
        localObject2 = com.tencent.mm.a.e.i(str, i, n);
        if (localObject2 == null)
        {
          ab.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_data fail. delete file:".concat(String.valueOf(str)));
        }
        else
        {
          i += n;
          Object localObject3;
          if (str.contains(".statictis_new2")) {
            localObject3 = new c();
          }
          for (;;)
          {
            int i1;
            boolean bool3;
            boolean bool1;
            long l1;
            long l2;
            try
            {
              ((c)localObject3).parseFrom((byte[])localObject2);
              n = ((c)localObject3).qst;
              i1 = ((c)localObject3).jKs;
              localObject2 = ((c)localObject3).qsu;
              boolean bool2 = ((c)localObject3).qsm;
              bool3 = ((c)localObject3).qsv;
              bool1 = ((c)localObject3).qsw;
              ab.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportkvcomm, logid:" + n + ", type:" + i1 + ", value:" + (String)localObject2 + ", isReportNow:" + bool3 + ", isImportant" + bool2);
              localObject3 = h.qsU;
              if (ah.brt())
              {
                if (com.tencent.mm.plugin.report.a.c.qrL)
                {
                  l1 = n;
                  l2 = i1;
                  bool2 = com.tencent.mm.plugin.report.a.c.qrM;
                  e.a(l1, l2, (String)localObject2, bool2, bool2, bool1);
                  ab.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, curLen:".concat(String.valueOf(i)));
                  break;
                }
                l1 = n;
                l2 = i1;
                e.a(l1, l2, (String)localObject2, bool3, false, bool1);
                continue;
              }
            }
            catch (IOException localIOException1)
            {
              ab.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(kvcomm), IOException:" + localIOException1.getMessage());
            }
            h.a(n, i1, localIOException1, bool3, bool1);
            continue;
            if (str.contains(".monitor"))
            {
              localObject3 = new b();
              try
              {
                ((b)localObject3).parseFrom(localIOException1);
                l1 = ((b)localObject3).ID;
                l2 = ((b)localObject3).qsk;
                long l3 = ((b)localObject3).qsl;
                bool1 = ((b)localObject3).qsm;
                ab.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportidkey, id:" + l1 + ", key:" + l2 + ", value:" + l3 + ", isImportant" + bool1);
                h.qsU.idkeyStat(l1, l2, l3, bool1);
              }
              catch (IOException localIOException2)
              {
                ab.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + localIOException2.getMessage());
              }
              break;
            }
            if (!str.contains(".group_monitor")) {
              break label965;
            }
            localObject3 = new a();
            try
            {
              ((a)localObject3).parseFrom(localIOException2);
              ArrayList localArrayList = new ArrayList();
              bool1 = false;
              localObject3 = ((a)localObject3).qsj.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                b localb = (b)((Iterator)localObject3).next();
                IDKey localIDKey = new IDKey(localb.ID, localb.qsk, localb.qsl);
                bool1 = localb.qsm;
                localArrayList.add(localIDKey);
                ab.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, idkeyGroupStat, id:" + localb.ID + ", key:" + localb.qsk + ", value:" + localb.qsl + ", isImportant" + bool1);
              }
              h.qsU.b(localArrayList, bool1);
            }
            catch (IOException localIOException3)
            {
              ab.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + localIOException3.getMessage());
            }
          }
          continue;
          label965:
          ab.e("MicroMsg.ReportManagerKvCheck", "invalid filename:".concat(String.valueOf(str)));
          continue;
          label984:
          AppMethodBeat.o(72734);
          return;
          j += 1;
        }
      }
    }
  }
  
  private static String chQ()
  {
    AppMethodBeat.i(72738);
    Object localObject = ah.getProcessName();
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      AppMethodBeat.o(72738);
      return "MM";
    }
    localObject = ((String)localObject).split(":");
    if (localObject.length <= 1)
    {
      AppMethodBeat.o(72738);
      return "MM";
    }
    localObject = localObject[1];
    AppMethodBeat.o(72738);
    return localObject;
  }
  
  public static void f(ArrayList<IDKey> arg0, boolean paramBoolean)
  {
    AppMethodBeat.i(72737);
    Object localObject1 = ???.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (IDKey)((Iterator)localObject1).next();
      ab.i("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, id:" + ((IDKey)localObject3).GetID() + ", key:" + ((IDKey)localObject3).GetKey() + ", value:" + ((IDKey)localObject3).GetValue() + ", isImportant:" + paramBoolean);
    }
    if (!com.tencent.mm.a.e.cN(filePath))
    {
      ab.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, filepath:" + filePath + " not exist ");
      AppMethodBeat.o(72737);
      return;
    }
    localObject1 = chQ();
    if ("MM".equals(localObject1))
    {
      ab.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(72737);
      return;
    }
    localObject1 = filePath + (String)localObject1 + ".group_monitor";
    Object localObject3 = new a();
    ((a)localObject3).jJu = ???.size();
    ??? = ???.iterator();
    while (???.hasNext())
    {
      IDKey localIDKey = (IDKey)???.next();
      b localb = new b();
      localb.ID = ((int)localIDKey.GetID());
      localb.qsk = ((int)localIDKey.GetKey());
      localb.qsl = ((int)localIDKey.GetValue());
      localb.qsm = paramBoolean;
      ((a)localObject3).qsj.add(localb);
    }
    try
    {
      localObject3 = ((a)localObject3).toByteArray();
      if (localObject3 == null)
      {
        ab.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, null == temp.");
        AppMethodBeat.o(72737);
        return;
      }
    }
    catch (IOException ???)
    {
      ab.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, IOException, detail:" + ???.getMessage());
      AppMethodBeat.o(72737);
      return;
    }
    synchronized (qsI)
    {
      if (com.tencent.mm.a.e.e((String)localObject1, intToByteArray(localObject3.length)) != 0)
      {
        ab.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write obj_len to file:" + (String)localObject1 + " fail.");
        AppMethodBeat.o(72737);
        return;
      }
      if (com.tencent.mm.a.e.e((String)localObject1, (byte[])localObject3) != 0) {
        ab.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write object to file:" + (String)localObject1 + " fail.");
      }
      AppMethodBeat.o(72737);
      return;
    }
  }
  
  private static String getAppFilePath()
  {
    AppMethodBeat.i(72733);
    Object localObject = ah.getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(72733);
      return null;
    }
    try
    {
      localObject = ((Context)localObject).getFilesDir();
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      localObject = ((File)localObject).toString();
      AppMethodBeat.o(72733);
      return localObject;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ReportManagerKvCheck", localException.getMessage());
      AppMethodBeat.o(72733);
    }
    return null;
  }
  
  private static byte[] intToByteArray(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.f
 * JD-Core Version:    0.7.0.1
 */