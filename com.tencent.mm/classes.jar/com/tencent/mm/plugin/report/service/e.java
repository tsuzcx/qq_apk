package com.tencent.mm.plugin.report.service;

import android.content.Context;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  private static String filePath;
  private static Byte yxw;
  
  static
  {
    AppMethodBeat.i(143852);
    filePath = getAppFilePath() + "/kvcomm/exception/";
    yxw = Byte.valueOf((byte)0);
    if (!o.fB(filePath)) {
      o.aZI(filePath);
    }
    AppMethodBeat.o(143852);
  }
  
  private static byte[] OO(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  public static void a(int paramInt1, int paramInt2, String arg2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(143848);
    if (!o.fB(filePath))
    {
      ae.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, filepath:" + filePath + " not exist , logId:" + paramInt1 + ", type:" + paramInt2 + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1 + ", ignoreFreqLimit:" + paramBoolean3);
      AppMethodBeat.o(143848);
      return;
    }
    ae.i("MicroMsg.ReportManagerKvCheck", "saveKVcommData, logId:" + paramInt1 + ", type:" + paramInt2 + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1 + "," + paramBoolean3);
    String str = dNG();
    if ("MM".equals(str))
    {
      ae.e("MicroMsg.ReportManagerKvCheck", "error path, invalid processname:" + str + ", logId:" + paramInt1 + ", type:" + paramInt2 + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1 + ", ignoreFreqLimit:" + paramBoolean3);
      AppMethodBeat.o(143848);
      return;
    }
    str = filePath + str + ".statictis_new2";
    Object localObject2 = new c();
    ((c)localObject2).gvt = paramInt1;
    ((c)localObject2).nJA = paramInt2;
    ((c)localObject2).yxn = ???;
    ((c)localObject2).yxg = paramBoolean2;
    ((c)localObject2).yxo = paramBoolean1;
    ((c)localObject2).yxp = paramBoolean3;
    try
    {
      localObject2 = ((c)localObject2).toByteArray();
      if (localObject2 == null)
      {
        ae.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, null == temp.");
        AppMethodBeat.o(143848);
        return;
      }
    }
    catch (IOException ???)
    {
      ae.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + ???.getMessage());
      AppMethodBeat.o(143848);
      return;
    }
    synchronized (yxw)
    {
      if (o.e(str, OO(localObject2.length), 4) != 0)
      {
        ae.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write obj_len to file:" + str + " fail.");
        AppMethodBeat.o(143848);
        return;
      }
      if (o.e(str, (byte[])localObject2, localObject2.length) != 0) {
        ae.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write object to file:" + str + " fail.");
      }
      AppMethodBeat.o(143848);
      return;
    }
  }
  
  private static int bF(byte[] paramArrayOfByte)
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
    AppMethodBeat.i(143849);
    ae.i("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, id:" + paramInt1 + ", key:" + paramInt2 + ", value:" + paramInt3 + ", isImportant:" + paramBoolean);
    if (!o.fB(filePath))
    {
      ae.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, filepath:" + filePath + " not exist , Id:" + paramInt1 + ", key:" + paramInt2 + ", value:" + paramInt3 + ", isImportant:" + paramBoolean);
      AppMethodBeat.o(143849);
      return;
    }
    String str = dNG();
    if ("MM".equals(str))
    {
      ae.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:" + str + ", id:" + paramInt1 + ", key:" + paramInt2 + ", val:" + paramInt3 + ", isImportant:" + paramBoolean);
      AppMethodBeat.o(143849);
      return;
    }
    str = filePath + str + ".monitor";
    ??? = new b();
    ((b)???).ID = paramInt1;
    ((b)???).yxe = paramInt2;
    ((b)???).yxf = paramInt3;
    ((b)???).yxg = paramBoolean;
    byte[] arrayOfByte;
    try
    {
      arrayOfByte = ((b)???).toByteArray();
      if (arrayOfByte == null)
      {
        ae.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, null == temp.");
        AppMethodBeat.o(143849);
        return;
      }
    }
    catch (IOException localIOException)
    {
      ae.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + localIOException.getMessage());
      AppMethodBeat.o(143849);
      return;
    }
    synchronized (yxw)
    {
      if (o.e(localIOException, OO(arrayOfByte.length), 4) != 0)
      {
        ae.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write obj_len to file:" + localIOException + " fail.");
        AppMethodBeat.o(143849);
        return;
      }
      if (o.e(localIOException, arrayOfByte, arrayOfByte.length) != 0) {
        ae.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write object to file:" + localIOException + " fail.");
      }
      ae.d("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, fileLength:" + o.aZR(localIOException));
      AppMethodBeat.o(143849);
      return;
    }
  }
  
  public static void dNF()
  {
    AppMethodBeat.i(143847);
    for (;;)
    {
      int j;
      String str1;
      int i;
      synchronized (yxw)
      {
        if (!o.fB(filePath))
        {
          ae.w("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filepath:" + filePath + " not exist.");
          AppMethodBeat.o(143847);
          return;
        }
        k[] arrayOfk = new k(filePath).fTj();
        if (arrayOfk == null)
        {
          ae.e("MicroMsg.ReportManagerKvCheck", "list file fail, filePath:" + filePath);
          AppMethodBeat.o(143847);
          return;
        }
        int k = arrayOfk.length;
        j = 0;
        if (j >= k) {
          break label1018;
        }
        localObject2 = arrayOfk[j];
        if (localObject2 == null)
        {
          ae.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, file is null");
        }
        else
        {
          str1 = w.B(((k)localObject2).fTh());
          i = 0;
          int m = (int)o.aZR(str1);
          ae.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filename:" + w.B(((k)localObject2).fTh()) + ", filelenth:" + m);
          if (i >= m)
          {
            ae.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, read to end, deletefile:".concat(String.valueOf(str1)));
            o.deleteFile(str1);
          }
        }
      }
      Object localObject2 = o.bb(str1, i, 4);
      if (localObject2 == null)
      {
        ae.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_len fail. delete file:".concat(String.valueOf(str1)));
      }
      else
      {
        i += 4;
        int n;
        try
        {
          n = bF((byte[])localObject2);
          localObject2 = o.bb(str1, i, n);
          if (localObject2 != null) {
            break label340;
          }
          ae.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_data fail. delete file:".concat(String.valueOf(str1)));
        }
        catch (Exception localException1)
        {
          ae.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, byteArrayToInt error. delete file:".concat(String.valueOf(str1)));
        }
        continue;
        label340:
        i += n;
        Object localObject3;
        if (str1.contains(".statictis_new2")) {
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
            ((c)localObject3).parseFrom(localException1);
            n = ((c)localObject3).gvt;
            i1 = ((c)localObject3).nJA;
            String str2 = ((c)localObject3).yxn;
            boolean bool2 = ((c)localObject3).yxg;
            bool3 = ((c)localObject3).yxo;
            bool1 = ((c)localObject3).yxp;
            ae.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportkvcomm, logid:" + n + ", type:" + i1 + ", value:" + str2 + ", isReportNow:" + bool3 + ", isImportant" + bool2);
            localObject3 = g.yxI;
            if (ak.cpe())
            {
              if (com.tencent.mm.plugin.report.a.c.ywG)
              {
                l1 = n;
                l2 = i1;
                bool2 = com.tencent.mm.plugin.report.a.c.ywH;
                d.a(l1, l2, str2, bool2, bool2, bool1);
                ae.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, curLen:".concat(String.valueOf(i)));
                break;
              }
              l1 = n;
              l2 = i1;
              d.a(l1, l2, str2, bool3, false, bool1);
              continue;
            }
          }
          catch (Exception localException2)
          {
            ae.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(kvcomm), Exception:" + localException2.getMessage());
          }
          g.a(n, i1, localException2, bool3, bool1);
          continue;
          if (str1.contains(".monitor"))
          {
            localObject3 = new b();
            try
            {
              ((b)localObject3).parseFrom(localException2);
              l1 = ((b)localObject3).ID;
              l2 = ((b)localObject3).yxe;
              long l3 = ((b)localObject3).yxf;
              bool1 = ((b)localObject3).yxg;
              ae.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportidkey, id:" + l1 + ", key:" + l2 + ", value:" + l3 + ", isImportant" + bool1);
              g.yxI.idkeyStat(l1, l2, l3, bool1);
            }
            catch (IOException localIOException1)
            {
              ae.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + localIOException1.getMessage());
            }
            break;
          }
          if (!str1.contains(".group_monitor")) {
            break label999;
          }
          localObject3 = new a();
          try
          {
            ((a)localObject3).parseFrom(localIOException1);
            ArrayList localArrayList = new ArrayList();
            bool1 = false;
            localObject3 = ((a)localObject3).yxd.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              b localb = (b)((Iterator)localObject3).next();
              IDKey localIDKey = new IDKey(localb.ID, localb.yxe, localb.yxf);
              bool1 = localb.yxg;
              localArrayList.add(localIDKey);
              ae.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, idkeyGroupStat, id:" + localb.ID + ", key:" + localb.yxe + ", value:" + localb.yxf + ", isImportant" + bool1);
            }
            g.yxI.b(localArrayList, bool1);
          }
          catch (IOException localIOException2)
          {
            ae.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + localIOException2.getMessage());
          }
        }
        continue;
        label999:
        ae.e("MicroMsg.ReportManagerKvCheck", "invalid filename:".concat(String.valueOf(str1)));
        continue;
        label1018:
        AppMethodBeat.o(143847);
        return;
        j += 1;
      }
    }
  }
  
  private static String dNG()
  {
    AppMethodBeat.i(143851);
    Object localObject = ak.getProcessName();
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
  
  public static void e(ArrayList<IDKey> arg0, boolean paramBoolean)
  {
    AppMethodBeat.i(143850);
    Object localObject1 = ???.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (IDKey)((Iterator)localObject1).next();
      ae.i("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, id:" + ((IDKey)localObject3).GetID() + ", key:" + ((IDKey)localObject3).GetKey() + ", value:" + ((IDKey)localObject3).GetValue() + ", isImportant:" + paramBoolean);
    }
    if (!o.fB(filePath))
    {
      ae.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, filepath:" + filePath + " not exist ");
      AppMethodBeat.o(143850);
      return;
    }
    localObject1 = dNG();
    if ("MM".equals(localObject1))
    {
      ae.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(143850);
      return;
    }
    localObject1 = filePath + (String)localObject1 + ".group_monitor";
    Object localObject3 = new a();
    ((a)localObject3).nID = ???.size();
    ??? = ???.iterator();
    while (???.hasNext())
    {
      IDKey localIDKey = (IDKey)???.next();
      b localb = new b();
      localb.ID = ((int)localIDKey.GetID());
      localb.yxe = ((int)localIDKey.GetKey());
      localb.yxf = ((int)localIDKey.GetValue());
      localb.yxg = paramBoolean;
      ((a)localObject3).yxd.add(localb);
    }
    try
    {
      localObject3 = ((a)localObject3).toByteArray();
      if (localObject3 == null)
      {
        ae.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, null == temp.");
        AppMethodBeat.o(143850);
        return;
      }
    }
    catch (IOException ???)
    {
      ae.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, IOException, detail:" + ???.getMessage());
      AppMethodBeat.o(143850);
      return;
    }
    synchronized (yxw)
    {
      if (o.e((String)localObject1, OO(localObject3.length), 4) != 0)
      {
        ae.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write obj_len to file:" + (String)localObject1 + " fail.");
        AppMethodBeat.o(143850);
        return;
      }
      if (o.e((String)localObject1, (byte[])localObject3, localObject3.length) != 0) {
        ae.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write object to file:" + (String)localObject1 + " fail.");
      }
      AppMethodBeat.o(143850);
      return;
    }
  }
  
  private static String getAppFilePath()
  {
    AppMethodBeat.i(143846);
    Object localObject = ak.getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(143846);
      return null;
    }
    try
    {
      localObject = k.W(((Context)localObject).getFilesDir());
      if (!((k)localObject).exists()) {
        ((k)localObject).createNewFile();
      }
      localObject = ((k)localObject).toString();
      AppMethodBeat.o(143846);
      return localObject;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.ReportManagerKvCheck", localException.getMessage());
      AppMethodBeat.o(143846);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.e
 * JD-Core Version:    0.7.0.1
 */