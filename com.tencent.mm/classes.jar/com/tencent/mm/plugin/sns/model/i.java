package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public final class i
  extends h<String, Integer, Boolean>
{
  private int JUW;
  private String JUX;
  private List<cvt> JUY;
  private String fIY;
  private String key;
  private n ljR;
  
  public i(String paramString1, String paramString2, List<cvt> paramList)
  {
    AppMethodBeat.i(95556);
    this.key = "";
    this.ljR = null;
    aj.fOF().JUq.add(paramString1);
    this.fIY = paramString2;
    this.JUX = aj.getAccSnsPath();
    this.JUW = aj.fOV();
    this.JUY = paramList;
    this.key = paramString1;
    AppMethodBeat.o(95556);
  }
  
  private boolean c(String paramString1, String paramString2, List<cvt> paramList)
  {
    AppMethodBeat.i(95558);
    Log.i("MicroMsg.MutiImageLoader", "makeMutilMedia " + paramString1 + " " + paramString2);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    String str1;
    String str3;
    String str2;
    if (localIterator.hasNext())
    {
      cvt localcvt = (cvt)localIterator.next();
      str1 = t.e(localcvt);
      str3 = t.d(localcvt);
      str2 = aq.kD(this.JUX, localcvt.Id);
      if (!u.agG(str2 + str1)) {
        if (!u.agG(str2 + str3))
        {
          paramList = t.k(localcvt);
          if (u.agG(str2 + paramList)) {
            break label440;
          }
          paramList = t.l(localcvt);
        }
      }
    }
    label440:
    for (;;)
    {
      r.a(str2, paramList, str3, aj.fOW());
      r.b(str2, str3, str1, aj.fOV());
      paramList = t.aZm(str2 + str1);
      if (paramList == null)
      {
        u.deleteFile(str2 + str1);
        Log.e("MicroMsg.MutiImageLoader", "userThumb decode fail !! ".concat(String.valueOf(str1)));
        AppMethodBeat.o(95558);
        return false;
      }
      localLinkedList.add(paramList);
      Log.i("MicroMsg.MutiImageLoader", "getbitmap from bm " + paramList + " " + str2 + str1);
      i += 1;
      if (i >= 4) {
        try
        {
          paramString1 = aq.kD(this.JUX, paramString1);
          u.bBD(paramString1);
          BitmapUtil.saveBitmapToImage(t.A(localLinkedList, this.JUW), 100, Bitmap.CompressFormat.JPEG, paramString1 + paramString2, false);
          AppMethodBeat.o(95558);
          return true;
        }
        catch (IOException paramString1)
        {
          Log.printErrStackTrace("MicroMsg.MutiImageLoader", paramString1, "makeMutilMedia failed: ".concat(String.valueOf(paramString2)), new Object[0]);
          AppMethodBeat.o(95558);
          return false;
        }
      }
      break;
    }
  }
  
  public final ExecutorService fsl()
  {
    AppMethodBeat.i(179085);
    ExecutorService localExecutorService = aj.fOt();
    AppMethodBeat.o(179085);
    return localExecutorService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.i
 * JD-Core Version:    0.7.0.1
 */