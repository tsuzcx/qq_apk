package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.g.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class i
  extends h<String, Integer, Boolean>
{
  private n feU;
  private String key;
  private String ohe;
  private int rel;
  private String rem;
  private List<bcs> ren;
  
  public i(String paramString1, String paramString2, List<bcs> paramList)
  {
    AppMethodBeat.i(36231);
    this.key = "";
    this.feU = null;
    ag.cpc().rdJ.add(paramString1);
    this.ohe = paramString2;
    this.rem = ag.getAccSnsPath();
    this.rel = ag.cpn();
    this.ren = paramList;
    this.key = paramString1;
    AppMethodBeat.o(36231);
  }
  
  private boolean b(String paramString1, String paramString2, List<bcs> paramList)
  {
    AppMethodBeat.i(36233);
    ab.i("MicroMsg.MutiImageLoader", "makeMutilMedia " + paramString1 + " " + paramString2);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    String str1;
    String str3;
    String str2;
    if (localIterator.hasNext())
    {
      bcs localbcs = (bcs)localIterator.next();
      str1 = com.tencent.mm.plugin.sns.data.i.f(localbcs);
      str3 = com.tencent.mm.plugin.sns.data.i.e(localbcs);
      str2 = ao.gl(this.rem, localbcs.Id);
      if (!e.cN(str2 + str1)) {
        if (!e.cN(str2 + str3))
        {
          paramList = com.tencent.mm.plugin.sns.data.i.l(localbcs);
          if (e.cN(str2 + paramList)) {
            break label439;
          }
          paramList = com.tencent.mm.plugin.sns.data.i.m(localbcs);
        }
      }
    }
    label439:
    for (;;)
    {
      s.a(str2, paramList, str3, ag.cpo());
      s.b(str2, str3, str1, ag.cpn());
      paramList = com.tencent.mm.plugin.sns.data.i.ZH(str2 + str1);
      if (paramList == null)
      {
        e.deleteFile(str2 + str1);
        ab.e("MicroMsg.MutiImageLoader", "userThumb decode fail !! ".concat(String.valueOf(str1)));
        AppMethodBeat.o(36233);
        return false;
      }
      localLinkedList.add(paramList);
      ab.i("MicroMsg.MutiImageLoader", "getbitmap from bm " + paramList + " " + str2 + str1);
      i += 1;
      if (i >= 4) {
        try
        {
          paramString1 = ao.gl(this.rem, paramString1);
          e.um(paramString1);
          d.a(com.tencent.mm.plugin.sns.data.i.o(localLinkedList, this.rel), 100, Bitmap.CompressFormat.JPEG, paramString1 + paramString2, false);
          AppMethodBeat.o(36233);
          return true;
        }
        catch (IOException paramString1)
        {
          ab.printErrStackTrace("MicroMsg.MutiImageLoader", paramString1, "makeMutilMedia failed: ".concat(String.valueOf(paramString2)), new Object[0]);
          AppMethodBeat.o(36233);
          return false;
        }
      }
      break;
    }
  }
  
  public final a cjN()
  {
    AppMethodBeat.i(36232);
    a locala = ag.coQ();
    AppMethodBeat.o(36232);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.i
 * JD-Core Version:    0.7.0.1
 */