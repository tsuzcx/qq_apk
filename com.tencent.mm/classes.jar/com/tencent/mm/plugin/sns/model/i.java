package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public final class i
  extends h<String, Integer, Boolean>
{
  private int QrY;
  private String QrZ;
  private List<dmz> Qsa;
  private String hOG;
  private String key;
  private m nOC;
  
  public i(String paramString1, String paramString2, List<dmz> paramList)
  {
    AppMethodBeat.i(95556);
    this.key = "";
    this.nOC = null;
    al.hgy().Qrs.add(paramString1);
    this.hOG = paramString2;
    this.QrZ = al.getAccSnsPath();
    this.QrY = al.hgP();
    this.Qsa = paramList;
    this.key = paramString1;
    AppMethodBeat.o(95556);
  }
  
  private boolean e(String paramString1, String paramString2, List<dmz> paramList)
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
      dmz localdmz = (dmz)localIterator.next();
      str1 = t.e(localdmz);
      str3 = t.d(localdmz);
      str2 = as.mg(this.QrZ, localdmz.Id);
      if (!y.ZC(str2 + str1)) {
        if (!y.ZC(str2 + str3))
        {
          paramList = t.k(localdmz);
          if (y.ZC(str2 + paramList)) {
            break label440;
          }
          paramList = t.l(localdmz);
        }
      }
    }
    label440:
    for (;;)
    {
      aa.a(str2, paramList, str3, al.hgQ());
      aa.b(str2, str3, str1, al.hgP());
      paramList = t.aXx(str2 + str1);
      if (paramList == null)
      {
        y.deleteFile(str2 + str1);
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
          paramString1 = as.mg(this.QrZ, paramString1);
          y.bDX(paramString1);
          BitmapUtil.saveBitmapToImage(t.T(localLinkedList, this.QrY), 100, Bitmap.CompressFormat.JPEG, paramString1 + paramString2, false);
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
  
  public final ExecutorService gDT()
  {
    AppMethodBeat.i(179085);
    ExecutorService localExecutorService = al.hgm();
    AppMethodBeat.o(179085);
    return localExecutorService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.i
 * JD-Core Version:    0.7.0.1
 */