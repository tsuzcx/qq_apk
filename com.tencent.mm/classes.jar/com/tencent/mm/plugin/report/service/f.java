package com.tencent.mm.plugin.report.service;

import android.content.Context;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  private static String filePath;
  private static Byte vJV;
  
  static
  {
    AppMethodBeat.i(143852);
    filePath = getAppFilePath() + "/kvcomm/exception/";
    vJV = Byte.valueOf((byte)0);
    if (!i.eK(filePath)) {
      i.aMF(filePath);
    }
    AppMethodBeat.o(143852);
  }
  
  private static byte[] KH(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  public static void a(int paramInt1, int paramInt2, String arg2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(143848);
    if (!i.eK(filePath))
    {
      ad.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, filepath:" + filePath + " not exist , logId:" + paramInt1 + ", type:" + paramInt2 + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1 + ", ignoreFreqLimit:" + paramBoolean3);
      AppMethodBeat.o(143848);
      return;
    }
    ad.i("MicroMsg.ReportManagerKvCheck", "saveKVcommData, logId:" + paramInt1 + ", type:" + paramInt2 + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1 + "," + paramBoolean3);
    String str = dkN();
    if ("MM".equals(str))
    {
      ad.e("MicroMsg.ReportManagerKvCheck", "error path, invalid processname:" + str + ", logId:" + paramInt1 + ", type:" + paramInt2 + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1 + ", ignoreFreqLimit:" + paramBoolean3);
      AppMethodBeat.o(143848);
      return;
    }
    str = filePath + str + ".statictis_new2";
    Object localObject2 = new c();
    ((c)localObject2).fVA = paramInt1;
    ((c)localObject2).mBH = paramInt2;
    ((c)localObject2).vJI = ???;
    ((c)localObject2).vJB = paramBoolean2;
    ((c)localObject2).vJJ = paramBoolean1;
    ((c)localObject2).vJK = paramBoolean3;
    try
    {
      localObject2 = ((c)localObject2).toByteArray();
      if (localObject2 == null)
      {
        ad.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, null == temp.");
        AppMethodBeat.o(143848);
        return;
      }
    }
    catch (IOException ???)
    {
      ad.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + ???.getMessage());
      AppMethodBeat.o(143848);
      return;
    }
    synchronized (vJV)
    {
      if (i.e(str, KH(localObject2.length), 4) != 0)
      {
        ad.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write obj_len to file:" + str + " fail.");
        AppMethodBeat.o(143848);
        return;
      }
      if (i.e(str, (byte[])localObject2, localObject2.length) != 0) {
        ad.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write object to file:" + str + " fail.");
      }
      AppMethodBeat.o(143848);
      return;
    }
  }
  
  private static int bw(byte[] paramArrayOfByte)
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
    ad.i("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, id:" + paramInt1 + ", key:" + paramInt2 + ", value:" + paramInt3 + ", isImportant:" + paramBoolean);
    if (!i.eK(filePath))
    {
      ad.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, filepath:" + filePath + " not exist , Id:" + paramInt1 + ", key:" + paramInt2 + ", value:" + paramInt3 + ", isImportant:" + paramBoolean);
      AppMethodBeat.o(143849);
      return;
    }
    String str = dkN();
    if ("MM".equals(str))
    {
      ad.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:" + str + ", id:" + paramInt1 + ", key:" + paramInt2 + ", val:" + paramInt3 + ", isImportant:" + paramBoolean);
      AppMethodBeat.o(143849);
      return;
    }
    str = filePath + str + ".monitor";
    ??? = new b();
    ((b)???).ID = paramInt1;
    ((b)???).vJz = paramInt2;
    ((b)???).vJA = paramInt3;
    ((b)???).vJB = paramBoolean;
    byte[] arrayOfByte;
    try
    {
      arrayOfByte = ((b)???).toByteArray();
      if (arrayOfByte == null)
      {
        ad.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, null == temp.");
        AppMethodBeat.o(143849);
        return;
      }
    }
    catch (IOException localIOException)
    {
      ad.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + localIOException.getMessage());
      AppMethodBeat.o(143849);
      return;
    }
    synchronized (vJV)
    {
      if (i.e(localIOException, KH(arrayOfByte.length), 4) != 0)
      {
        ad.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write obj_len to file:" + localIOException + " fail.");
        AppMethodBeat.o(143849);
        return;
      }
      if (i.e(localIOException, arrayOfByte, arrayOfByte.length) != 0) {
        ad.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write object to file:" + localIOException + " fail.");
      }
      ad.d("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, fileLength:" + i.aMN(localIOException));
      AppMethodBeat.o(143849);
      return;
    }
  }
  
  public static void dkM()
  {
    AppMethodBeat.i(143847);
    if (!i.eK(filePath))
    {
      ad.w("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filepath:" + filePath + " not exist.");
      AppMethodBeat.o(143847);
      return;
    }
    com.tencent.mm.vfs.e[] arrayOfe = new com.tencent.mm.vfs.e(filePath).fhW();
    if (arrayOfe == null)
    {
      ad.e("MicroMsg.ReportManagerKvCheck", "list file fail, filePath:" + filePath);
      AppMethodBeat.o(143847);
      return;
    }
    for (;;)
    {
      int j;
      String str;
      int i;
      synchronized (vJV)
      {
        int k = arrayOfe.length;
        j = 0;
        if (j >= k) {
          break label991;
        }
        localObject2 = arrayOfe[j];
        if (localObject2 == null)
        {
          ad.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, file is null");
        }
        else
        {
          str = q.B(((com.tencent.mm.vfs.e)localObject2).fhU());
          i = 0;
          int m = (int)i.aMN(str);
          ad.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filename:" + q.B(((com.tencent.mm.vfs.e)localObject2).fhU()) + ", filelenth:" + m);
          if (i >= m)
          {
            ad.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, read to end, deletefile:".concat(String.valueOf(str)));
            i.deleteFile(str);
          }
        }
      }
      Object localObject2 = i.aR(str, i, 4);
      if (localObject2 == null)
      {
        ad.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_len fail. delete file:".concat(String.valueOf(str)));
      }
      else
      {
        i += 4;
        int n = bw((byte[])localObject2);
        localObject2 = i.aR(str, i, n);
        if (localObject2 == null)
        {
          ad.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_data fail. delete file:".concat(String.valueOf(str)));
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
              n = ((c)localObject3).fVA;
              i1 = ((c)localObject3).mBH;
              localObject2 = ((c)localObject3).vJI;
              boolean bool2 = ((c)localObject3).vJB;
              bool3 = ((c)localObject3).vJJ;
              bool1 = ((c)localObject3).vJK;
              ad.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportkvcomm, logid:" + n + ", type:" + i1 + ", value:" + (String)localObject2 + ", isReportNow:" + bool3 + ", isImportant" + bool2);
              localObject3 = h.vKh;
              if (aj.cbv())
              {
                if (com.tencent.mm.plugin.report.a.c.vJb)
                {
                  l1 = n;
                  l2 = i1;
                  bool2 = com.tencent.mm.plugin.report.a.c.vJc;
                  e.a(l1, l2, (String)localObject2, bool2, bool2, bool1);
                  ad.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, curLen:".concat(String.valueOf(i)));
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
              ad.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(kvcomm), IOException:" + localIOException1.getMessage());
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
                l2 = ((b)localObject3).vJz;
                long l3 = ((b)localObject3).vJA;
                bool1 = ((b)localObject3).vJB;
                ad.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportidkey, id:" + l1 + ", key:" + l2 + ", value:" + l3 + ", isImportant" + bool1);
                h.vKh.idkeyStat(l1, l2, l3, bool1);
              }
              catch (IOException localIOException2)
              {
                ad.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + localIOException2.getMessage());
              }
              break;
            }
            if (!str.contains(".group_monitor")) {
              break label972;
            }
            localObject3 = new a();
            try
            {
              ((a)localObject3).parseFrom(localIOException2);
              ArrayList localArrayList = new ArrayList();
              bool1 = false;
              localObject3 = ((a)localObject3).vJy.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                b localb = (b)((Iterator)localObject3).next();
                IDKey localIDKey = new IDKey(localb.ID, localb.vJz, localb.vJA);
                bool1 = localb.vJB;
                localArrayList.add(localIDKey);
                ad.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, idkeyGroupStat, id:" + localb.ID + ", key:" + localb.vJz + ", value:" + localb.vJA + ", isImportant" + bool1);
              }
              h.vKh.b(localArrayList, bool1);
            }
            catch (IOException localIOException3)
            {
              ad.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + localIOException3.getMessage());
            }
          }
          continue;
          label972:
          ad.e("MicroMsg.ReportManagerKvCheck", "invalid filename:".concat(String.valueOf(str)));
          continue;
          label991:
          AppMethodBeat.o(143847);
          return;
          j += 1;
        }
      }
    }
  }
  
  private static String dkN()
  {
    AppMethodBeat.i(143851);
    Object localObject = aj.getProcessName();
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
      ad.i("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, id:" + ((IDKey)localObject3).GetID() + ", key:" + ((IDKey)localObject3).GetKey() + ", value:" + ((IDKey)localObject3).GetValue() + ", isImportant:" + paramBoolean);
    }
    if (!i.eK(filePath))
    {
      ad.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, filepath:" + filePath + " not exist ");
      AppMethodBeat.o(143850);
      return;
    }
    localObject1 = dkN();
    if ("MM".equals(localObject1))
    {
      ad.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(143850);
      return;
    }
    localObject1 = filePath + (String)localObject1 + ".group_monitor";
    Object localObject3 = new a();
    ((a)localObject3).mAK = ???.size();
    ??? = ???.iterator();
    while (???.hasNext())
    {
      IDKey localIDKey = (IDKey)???.next();
      b localb = new b();
      localb.ID = ((int)localIDKey.GetID());
      localb.vJz = ((int)localIDKey.GetKey());
      localb.vJA = ((int)localIDKey.GetValue());
      localb.vJB = paramBoolean;
      ((a)localObject3).vJy.add(localb);
    }
    try
    {
      localObject3 = ((a)localObject3).toByteArray();
      if (localObject3 == null)
      {
        ad.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, null == temp.");
        AppMethodBeat.o(143850);
        return;
      }
    }
    catch (IOException ???)
    {
      ad.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, IOException, detail:" + ???.getMessage());
      AppMethodBeat.o(143850);
      return;
    }
    synchronized (vJV)
    {
      if (i.e((String)localObject1, KH(localObject3.length), 4) != 0)
      {
        ad.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write obj_len to file:" + (String)localObject1 + " fail.");
        AppMethodBeat.o(143850);
        return;
      }
      if (i.e((String)localObject1, (byte[])localObject3, localObject3.length) != 0) {
        ad.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write object to file:" + (String)localObject1 + " fail.");
      }
      AppMethodBeat.o(143850);
      return;
    }
  }
  
  private static String getAppFilePath()
  {
    AppMethodBeat.i(143846);
    Object localObject = aj.getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(143846);
      return null;
    }
    try
    {
      localObject = com.tencent.mm.vfs.e.R(((Context)localObject).getFilesDir());
      if (!((com.tencent.mm.vfs.e)localObject).exists()) {
        ((com.tencent.mm.vfs.e)localObject).createNewFile();
      }
      localObject = ((com.tencent.mm.vfs.e)localObject).toString();
      AppMethodBeat.o(143846);
      return localObject;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ReportManagerKvCheck", localException.getMessage());
      AppMethodBeat.o(143846);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.f
 * JD-Core Version:    0.7.0.1
 */