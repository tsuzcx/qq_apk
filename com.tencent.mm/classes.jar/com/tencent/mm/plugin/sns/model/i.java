package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class i
  extends h<String, Integer, Boolean>
{
  private n dPv = null;
  private String key = "";
  private String lJQ;
  private int opH;
  private String opI;
  private List<awd> opJ;
  
  public i(String paramString1, String paramString2, List<awd> paramList)
  {
    af.bDC().opl.add(paramString1);
    this.lJQ = paramString2;
    this.opI = af.getAccSnsPath();
    this.opH = af.bDN();
    this.opJ = paramList;
    this.key = paramString1;
  }
  
  private boolean a(String paramString1, String paramString2, List<awd> paramList)
  {
    y.i("MicroMsg.MutiImageLoader", "makeMutilMedia " + paramString1 + " " + paramString2);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    String str1;
    String str3;
    String str2;
    if (localIterator.hasNext())
    {
      awd localawd = (awd)localIterator.next();
      str1 = com.tencent.mm.plugin.sns.data.i.f(localawd);
      str3 = com.tencent.mm.plugin.sns.data.i.e(localawd);
      str2 = an.eJ(this.opI, localawd.lsK);
      if (!e.bK(str2 + str1)) {
        if (!e.bK(str2 + str3))
        {
          paramList = com.tencent.mm.plugin.sns.data.i.l(localawd);
          if (e.bK(str2 + paramList)) {
            break label433;
          }
          paramList = com.tencent.mm.plugin.sns.data.i.m(localawd);
        }
      }
    }
    label433:
    for (;;)
    {
      s.a(str2, paramList, str3, af.bDO());
      s.b(str2, str3, str1, af.bDN());
      paramList = com.tencent.mm.plugin.sns.data.i.Na(str2 + str1);
      if (paramList == null)
      {
        e.deleteFile(str2 + str1);
        y.e("MicroMsg.MutiImageLoader", "userThumb decode fail !! " + str1);
        return false;
      }
      localLinkedList.add(paramList);
      y.i("MicroMsg.MutiImageLoader", "getbitmap from bm " + paramList + " " + str2 + str1);
      i += 1;
      if (i >= 4) {
        try
        {
          paramString1 = an.eJ(this.opI, paramString1);
          e.nb(paramString1);
          c.a(com.tencent.mm.plugin.sns.data.i.j(localLinkedList, this.opH), 100, Bitmap.CompressFormat.JPEG, paramString1 + paramString2, false);
          return true;
        }
        catch (IOException paramString1)
        {
          y.printErrStackTrace("MicroMsg.MutiImageLoader", paramString1, "makeMutilMedia failed: " + paramString2, new Object[0]);
          return false;
        }
      }
      break;
    }
  }
  
  public final ah byB()
  {
    return af.aXo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.i
 * JD-Core Version:    0.7.0.1
 */