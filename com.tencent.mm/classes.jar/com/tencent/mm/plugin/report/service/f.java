package com.tencent.mm.plugin.report.service;

import android.content.Context;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  private static Byte Cyt;
  private static String filePath;
  
  static
  {
    AppMethodBeat.i(143852);
    filePath = getAppFilePath() + "/kvcomm/exception/";
    Cyt = Byte.valueOf((byte)0);
    if (!s.YS(filePath)) {
      s.boN(filePath);
    }
    AppMethodBeat.o(143852);
  }
  
  private static byte[] Wk(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  public static void a(int paramInt1, int paramInt2, String arg2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(143848);
    if (!s.YS(filePath))
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, filepath:" + filePath + " not exist , logId:" + paramInt1 + ", type:" + paramInt2 + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1 + ", ignoreFreqLimit:" + paramBoolean3);
      AppMethodBeat.o(143848);
      return;
    }
    Log.i("MicroMsg.ReportManagerKvCheck", "saveKVcommData, logId:" + paramInt1 + ", type:" + paramInt2 + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1 + "," + paramBoolean3);
    String str = eOG();
    if ("MM".equals(str))
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "error path, invalid processname:" + str + ", logId:" + paramInt1 + ", type:" + paramInt2 + ", val:" + ??? + ", isImportant:" + paramBoolean2 + ", reportnow:" + paramBoolean1 + ", ignoreFreqLimit:" + paramBoolean3);
      AppMethodBeat.o(143848);
      return;
    }
    str = filePath + str + ".statictis_new2";
    Object localObject2 = new d();
    ((d)localObject2).hii = paramInt1;
    ((d)localObject2).oUv = paramInt2;
    ((d)localObject2).Cyk = ???;
    ((d)localObject2).Cyc = paramBoolean2;
    ((d)localObject2).Cyl = paramBoolean1;
    ((d)localObject2).Cym = paramBoolean3;
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
    synchronized (Cyt)
    {
      if (s.e(str, Wk(localObject2.length), 4) != 0)
      {
        Log.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write obj_len to file:" + str + " fail.");
        AppMethodBeat.o(143848);
        return;
      }
      if (s.e(str, (byte[])localObject2, localObject2.length) != 0) {
        Log.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write object to file:" + str + " fail.");
      }
      AppMethodBeat.o(143848);
      return;
    }
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
  
  public static void c(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(143849);
    Log.i("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, id:" + paramInt1 + ", key:" + paramInt2 + ", value:" + paramInt3 + ", isImportant:" + paramBoolean);
    if (!s.YS(filePath))
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, filepath:" + filePath + " not exist , Id:" + paramInt1 + ", key:" + paramInt2 + ", value:" + paramInt3 + ", isImportant:" + paramBoolean);
      AppMethodBeat.o(143849);
      return;
    }
    String str = eOG();
    if ("MM".equals(str))
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:" + str + ", id:" + paramInt1 + ", key:" + paramInt2 + ", val:" + paramInt3 + ", isImportant:" + paramBoolean);
      AppMethodBeat.o(143849);
      return;
    }
    str = filePath + str + ".monitor";
    ??? = new b();
    ((b)???).ID = paramInt1;
    ((b)???).Cya = paramInt2;
    ((b)???).Cyb = paramInt3;
    ((b)???).Cyc = paramBoolean;
    byte[] arrayOfByte;
    try
    {
      arrayOfByte = ((b)???).toByteArray();
      if (arrayOfByte == null)
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
    synchronized (Cyt)
    {
      if (s.e(localIOException, Wk(arrayOfByte.length), 4) != 0)
      {
        Log.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write obj_len to file:" + localIOException + " fail.");
        AppMethodBeat.o(143849);
        return;
      }
      if (s.e(localIOException, arrayOfByte, arrayOfByte.length) != 0) {
        Log.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write object to file:" + localIOException + " fail.");
      }
      Log.d("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, fileLength:" + s.boW(localIOException));
      AppMethodBeat.o(143849);
      return;
    }
  }
  
  public static void eOF()
  {
    AppMethodBeat.i(143847);
    for (;;)
    {
      int j;
      String str1;
      int i;
      synchronized (Cyt)
      {
        if (!s.YS(filePath))
        {
          Log.w("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filepath:" + filePath + " not exist.");
          AppMethodBeat.o(143847);
          return;
        }
        o[] arrayOfo = new o(filePath).het();
        if (arrayOfo == null)
        {
          Log.e("MicroMsg.ReportManagerKvCheck", "list file fail, filePath:" + filePath);
          AppMethodBeat.o(143847);
          return;
        }
        int k = arrayOfo.length;
        j = 0;
        if (j >= k) {
          break label1018;
        }
        localObject2 = arrayOfo[j];
        if (localObject2 == null)
        {
          Log.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, file is null");
        }
        else
        {
          str1 = aa.z(((o)localObject2).her());
          i = 0;
          int m = (int)s.boW(str1);
          Log.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filename:" + aa.z(((o)localObject2).her()) + ", filelenth:" + m);
          if (i >= m)
          {
            Log.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, read to end, deletefile:".concat(String.valueOf(str1)));
            s.deleteFile(str1);
          }
        }
      }
      Object localObject2 = s.aW(str1, i, 4);
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
          localObject2 = s.aW(str1, i, n);
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
          int i1;
          boolean bool3;
          boolean bool1;
          long l1;
          long l2;
          try
          {
            ((d)localObject3).parseFrom(localException1);
            n = ((d)localObject3).hii;
            i1 = ((d)localObject3).oUv;
            String str2 = ((d)localObject3).Cyk;
            boolean bool2 = ((d)localObject3).Cyc;
            bool3 = ((d)localObject3).Cyl;
            bool1 = ((d)localObject3).Cym;
            Log.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportkvcomm, logid:" + n + ", type:" + i1 + ", value:" + str2 + ", isReportNow:" + bool3 + ", isImportant" + bool2);
            localObject3 = h.CyF;
            if (MMApplicationContext.isMMProcess())
            {
              if (c.CxC)
              {
                l1 = n;
                l2 = i1;
                bool2 = c.CxD;
                e.a(l1, l2, str2, bool2, bool2, bool1);
                Log.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, curLen:".concat(String.valueOf(i)));
                break;
              }
              l1 = n;
              l2 = i1;
              e.a(l1, l2, str2, bool3, false, bool1);
              continue;
            }
          }
          catch (Exception localException2)
          {
            Log.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(kvcomm), Exception:" + localException2.getMessage());
          }
          h.b(n, i1, localException2, bool3, bool1);
          continue;
          if (str1.contains(".monitor"))
          {
            localObject3 = new b();
            try
            {
              ((b)localObject3).parseFrom(localException2);
              l1 = ((b)localObject3).ID;
              l2 = ((b)localObject3).Cya;
              long l3 = ((b)localObject3).Cyb;
              bool1 = ((b)localObject3).Cyc;
              Log.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportidkey, id:" + l1 + ", key:" + l2 + ", value:" + l3 + ", isImportant" + bool1);
              h.CyF.idkeyStat(l1, l2, l3, bool1);
            }
            catch (IOException localIOException1)
            {
              Log.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + localIOException1.getMessage());
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
            localObject3 = ((a)localObject3).CxZ.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              b localb = (b)((Iterator)localObject3).next();
              IDKey localIDKey = new IDKey(localb.ID, localb.Cya, localb.Cyb);
              bool1 = localb.Cyc;
              localArrayList.add(localIDKey);
              Log.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, idkeyGroupStat, id:" + localb.ID + ", key:" + localb.Cya + ", value:" + localb.Cyb + ", isImportant" + bool1);
            }
            h.CyF.b(localArrayList, bool1);
          }
          catch (IOException localIOException2)
          {
            Log.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + localIOException2.getMessage());
          }
        }
        continue;
        label999:
        Log.e("MicroMsg.ReportManagerKvCheck", "invalid filename:".concat(String.valueOf(str1)));
        continue;
        label1018:
        AppMethodBeat.o(143847);
        return;
        j += 1;
      }
    }
  }
  
  private static String eOG()
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
  
  public static void f(ArrayList<IDKey> arg0, boolean paramBoolean)
  {
    AppMethodBeat.i(143850);
    Object localObject1 = ???.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (IDKey)((Iterator)localObject1).next();
      Log.i("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, id:" + ((IDKey)localObject3).GetID() + ", key:" + ((IDKey)localObject3).GetKey() + ", value:" + ((IDKey)localObject3).GetValue() + ", isImportant:" + paramBoolean);
    }
    if (!s.YS(filePath))
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, filepath:" + filePath + " not exist ");
      AppMethodBeat.o(143850);
      return;
    }
    localObject1 = eOG();
    if ("MM".equals(localObject1))
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(143850);
      return;
    }
    localObject1 = filePath + (String)localObject1 + ".group_monitor";
    Object localObject3 = new a();
    ((a)localObject3).oTz = ???.size();
    ??? = ???.iterator();
    while (???.hasNext())
    {
      IDKey localIDKey = (IDKey)???.next();
      b localb = new b();
      localb.ID = ((int)localIDKey.GetID());
      localb.Cya = ((int)localIDKey.GetKey());
      localb.Cyb = ((int)localIDKey.GetValue());
      localb.Cyc = paramBoolean;
      ((a)localObject3).CxZ.add(localb);
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
    synchronized (Cyt)
    {
      if (s.e((String)localObject1, Wk(localObject3.length), 4) != 0)
      {
        Log.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write obj_len to file:" + (String)localObject1 + " fail.");
        AppMethodBeat.o(143850);
        return;
      }
      if (s.e((String)localObject1, (byte[])localObject3, localObject3.length) != 0) {
        Log.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write object to file:" + (String)localObject1 + " fail.");
      }
      AppMethodBeat.o(143850);
      return;
    }
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
      localObject = o.X(((Context)localObject).getFilesDir());
      if (!((o)localObject).exists()) {
        ((o)localObject).createNewFile();
      }
      localObject = ((o)localObject).toString();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.f
 * JD-Core Version:    0.7.0.1
 */