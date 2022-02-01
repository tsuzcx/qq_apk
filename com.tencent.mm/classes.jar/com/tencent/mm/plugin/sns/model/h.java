package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public final class h
  extends g<String, Integer, Boolean>
{
  private String dnB;
  private n gFe;
  private String key;
  private int wEK;
  private String wEL;
  private List<bpi> wEM;
  
  public h(String paramString1, String paramString2, List<bpi> paramList)
  {
    AppMethodBeat.i(95556);
    this.key = "";
    this.gFe = null;
    af.dtr().wEd.add(paramString1);
    this.dnB = paramString2;
    this.wEL = af.getAccSnsPath();
    this.wEK = af.dtE();
    this.wEM = paramList;
    this.key = paramString1;
    AppMethodBeat.o(95556);
  }
  
  private boolean b(String paramString1, String paramString2, List<bpi> paramList)
  {
    AppMethodBeat.i(95558);
    ad.i("MicroMsg.MutiImageLoader", "makeMutilMedia " + paramString1 + " " + paramString2);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    String str1;
    String str3;
    String str2;
    if (localIterator.hasNext())
    {
      bpi localbpi = (bpi)localIterator.next();
      str1 = q.e(localbpi);
      str3 = q.d(localbpi);
      str2 = an.iF(this.wEL, localbpi.Id);
      if (!i.eK(str2 + str1)) {
        if (!i.eK(str2 + str3))
        {
          paramList = q.k(localbpi);
          if (i.eK(str2 + paramList)) {
            break label440;
          }
          paramList = q.l(localbpi);
        }
      }
    }
    label440:
    for (;;)
    {
      u.a(str2, paramList, str3, af.dtF());
      u.b(str2, str3, str1, af.dtE());
      paramList = q.anL(str2 + str1);
      if (paramList == null)
      {
        i.deleteFile(str2 + str1);
        ad.e("MicroMsg.MutiImageLoader", "userThumb decode fail !! ".concat(String.valueOf(str1)));
        AppMethodBeat.o(95558);
        return false;
      }
      localLinkedList.add(paramList);
      ad.i("MicroMsg.MutiImageLoader", "getbitmap from bm " + paramList + " " + str2 + str1);
      i += 1;
      if (i >= 4) {
        try
        {
          paramString1 = an.iF(this.wEL, paramString1);
          i.aMF(paramString1);
          com.tencent.mm.sdk.platformtools.f.a(q.s(localLinkedList, this.wEK), 100, Bitmap.CompressFormat.JPEG, paramString1 + paramString2, false);
          AppMethodBeat.o(95558);
          return true;
        }
        catch (IOException paramString1)
        {
          ad.printErrStackTrace("MicroMsg.MutiImageLoader", paramString1, "makeMutilMedia failed: ".concat(String.valueOf(paramString2)), new Object[0]);
          AppMethodBeat.o(95558);
          return false;
        }
      }
      break;
    }
  }
  
  public final ExecutorService dnm()
  {
    AppMethodBeat.i(179085);
    ExecutorService localExecutorService = af.dtf();
    AppMethodBeat.o(179085);
    return localExecutorService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.h
 * JD-Core Version:    0.7.0.1
 */