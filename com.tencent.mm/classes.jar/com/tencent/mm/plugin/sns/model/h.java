package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.ac;
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
  private String dlj;
  private n hfF;
  private String key;
  private int xRf;
  private String xRg;
  private List<btz> xRh;
  
  public h(String paramString1, String paramString2, List<btz> paramList)
  {
    AppMethodBeat.i(95556);
    this.key = "";
    this.hfF = null;
    af.dHO().xQy.add(paramString1);
    this.dlj = paramString2;
    this.xRg = af.getAccSnsPath();
    this.xRf = af.dIc();
    this.xRh = paramList;
    this.key = paramString1;
    AppMethodBeat.o(95556);
  }
  
  private boolean b(String paramString1, String paramString2, List<btz> paramList)
  {
    AppMethodBeat.i(95558);
    ac.i("MicroMsg.MutiImageLoader", "makeMutilMedia " + paramString1 + " " + paramString2);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    String str1;
    String str3;
    String str2;
    if (localIterator.hasNext())
    {
      btz localbtz = (btz)localIterator.next();
      str1 = q.e(localbtz);
      str3 = q.d(localbtz);
      str2 = an.jc(this.xRg, localbtz.Id);
      if (!i.eA(str2 + str1)) {
        if (!i.eA(str2 + str3))
        {
          paramList = q.k(localbtz);
          if (i.eA(str2 + paramList)) {
            break label440;
          }
          paramList = q.l(localbtz);
        }
      }
    }
    label440:
    for (;;)
    {
      u.a(str2, paramList, str3, af.dId());
      u.b(str2, str3, str1, af.dIc());
      paramList = q.asX(str2 + str1);
      if (paramList == null)
      {
        i.deleteFile(str2 + str1);
        ac.e("MicroMsg.MutiImageLoader", "userThumb decode fail !! ".concat(String.valueOf(str1)));
        AppMethodBeat.o(95558);
        return false;
      }
      localLinkedList.add(paramList);
      ac.i("MicroMsg.MutiImageLoader", "getbitmap from bm " + paramList + " " + str2 + str1);
      i += 1;
      if (i >= 4) {
        try
        {
          paramString1 = an.jc(this.xRg, paramString1);
          i.aSh(paramString1);
          com.tencent.mm.sdk.platformtools.f.a(q.s(localLinkedList, this.xRf), 100, Bitmap.CompressFormat.JPEG, paramString1 + paramString2, false);
          AppMethodBeat.o(95558);
          return true;
        }
        catch (IOException paramString1)
        {
          ac.printErrStackTrace("MicroMsg.MutiImageLoader", paramString1, "makeMutilMedia failed: ".concat(String.valueOf(paramString2)), new Object[0]);
          AppMethodBeat.o(95558);
          return false;
        }
      }
      break;
    }
  }
  
  public final ExecutorService dBu()
  {
    AppMethodBeat.i(179085);
    ExecutorService localExecutorService = af.dHC();
    AppMethodBeat.o(179085);
    return localExecutorService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.h
 * JD-Core Version:    0.7.0.1
 */