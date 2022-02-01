package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public final class i
  extends h<String, Integer, Boolean>
{
  private String dyb;
  private n hAB;
  private String key;
  private int zxP;
  private String zxQ;
  private List<bzh> zxR;
  
  public i(String paramString1, String paramString2, List<bzh> paramList)
  {
    AppMethodBeat.i(95556);
    this.key = "";
    this.hAB = null;
    ah.dXB().zxi.add(paramString1);
    this.dyb = paramString2;
    this.zxQ = ah.getAccSnsPath();
    this.zxP = ah.dXP();
    this.zxR = paramList;
    this.key = paramString1;
    AppMethodBeat.o(95556);
  }
  
  private boolean b(String paramString1, String paramString2, List<bzh> paramList)
  {
    AppMethodBeat.i(95558);
    ae.i("MicroMsg.MutiImageLoader", "makeMutilMedia " + paramString1 + " " + paramString2);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    String str1;
    String str3;
    String str2;
    if (localIterator.hasNext())
    {
      bzh localbzh = (bzh)localIterator.next();
      str1 = r.e(localbzh);
      str3 = r.d(localbzh);
      str2 = ap.jv(this.zxQ, localbzh.Id);
      if (!o.fB(str2 + str1)) {
        if (!o.fB(str2 + str3))
        {
          paramList = r.k(localbzh);
          if (o.fB(str2 + paramList)) {
            break label440;
          }
          paramList = r.l(localbzh);
        }
      }
    }
    label440:
    for (;;)
    {
      u.a(str2, paramList, str3, ah.dXQ());
      u.b(str2, str3, str1, ah.dXP());
      paramList = r.azt(str2 + str1);
      if (paramList == null)
      {
        o.deleteFile(str2 + str1);
        ae.e("MicroMsg.MutiImageLoader", "userThumb decode fail !! ".concat(String.valueOf(str1)));
        AppMethodBeat.o(95558);
        return false;
      }
      localLinkedList.add(paramList);
      ae.i("MicroMsg.MutiImageLoader", "getbitmap from bm " + paramList + " " + str2 + str1);
      i += 1;
      if (i >= 4) {
        try
        {
          paramString1 = ap.jv(this.zxQ, paramString1);
          o.aZI(paramString1);
          com.tencent.mm.sdk.platformtools.h.a(r.v(localLinkedList, this.zxP), 100, Bitmap.CompressFormat.JPEG, paramString1 + paramString2, false);
          AppMethodBeat.o(95558);
          return true;
        }
        catch (IOException paramString1)
        {
          ae.printErrStackTrace("MicroMsg.MutiImageLoader", paramString1, "makeMutilMedia failed: ".concat(String.valueOf(paramString2)), new Object[0]);
          AppMethodBeat.o(95558);
          return false;
        }
      }
      break;
    }
  }
  
  public final ExecutorService dFv()
  {
    AppMethodBeat.i(179085);
    ExecutorService localExecutorService = ah.dXp();
    AppMethodBeat.o(179085);
    return localExecutorService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.i
 * JD-Core Version:    0.7.0.1
 */