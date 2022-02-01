package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.n;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public final class i
  extends h<String, Integer, Boolean>
{
  private int DHX;
  private String DHY;
  private List<cnb> DHZ;
  private String dPI;
  private n iuI;
  private String key;
  
  public i(String paramString1, String paramString2, List<cnb> paramList)
  {
    AppMethodBeat.i(95556);
    this.key = "";
    this.iuI = null;
    aj.faL().DHr.add(paramString1);
    this.dPI = paramString2;
    this.DHY = aj.getAccSnsPath();
    this.DHX = aj.fbb();
    this.DHZ = paramList;
    this.key = paramString1;
    AppMethodBeat.o(95556);
  }
  
  private boolean b(String paramString1, String paramString2, List<cnb> paramList)
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
      cnb localcnb = (cnb)localIterator.next();
      str1 = com.tencent.mm.plugin.sns.data.r.f(localcnb);
      str3 = com.tencent.mm.plugin.sns.data.r.e(localcnb);
      str2 = ar.ki(this.DHY, localcnb.Id);
      if (!s.YS(str2 + str1)) {
        if (!s.YS(str2 + str3))
        {
          paramList = com.tencent.mm.plugin.sns.data.r.l(localcnb);
          if (s.YS(str2 + paramList)) {
            break label440;
          }
          paramList = com.tencent.mm.plugin.sns.data.r.m(localcnb);
        }
      }
    }
    label440:
    for (;;)
    {
      com.tencent.mm.plugin.sns.storage.r.a(str2, paramList, str3, aj.fbc());
      com.tencent.mm.plugin.sns.storage.r.b(str2, str3, str1, aj.fbb());
      paramList = com.tencent.mm.plugin.sns.data.r.aOq(str2 + str1);
      if (paramList == null)
      {
        s.deleteFile(str2 + str1);
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
          paramString1 = ar.ki(this.DHY, paramString1);
          s.boN(paramString1);
          BitmapUtil.saveBitmapToImage(com.tencent.mm.plugin.sns.data.r.z(localLinkedList, this.DHX), 100, Bitmap.CompressFormat.JPEG, paramString1 + paramString2, false);
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
  
  public final ExecutorService eGk()
  {
    AppMethodBeat.i(179085);
    ExecutorService localExecutorService = aj.faz();
    AppMethodBeat.o(179085);
    return localExecutorService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.i
 * JD-Core Version:    0.7.0.1
 */