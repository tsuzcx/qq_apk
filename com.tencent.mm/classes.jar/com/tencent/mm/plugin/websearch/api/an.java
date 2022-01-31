package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class an
{
  private static an qUR = new an();
  public an.a qUQ;
  
  private an()
  {
    Object localObject = (String)g.DP().Dz().get(ac.a.uxo, "");
    this.qUQ = new an.a();
    an.a locala = this.qUQ;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("&");
        locala.id = bk.q(localObject[0], new Object[0]);
        locala.qUS = bk.ZR(localObject[1]);
        locala.qUT = bk.ZR(localObject[2]);
        locala.lSJ = bk.ZS(localObject[3]);
        locala.qTU = bk.ZR(localObject[4]);
        locala.type = bk.ZR(localObject[5]);
        locala.text = localObject[6];
        locala.bVO = localObject[7];
        locala.timestamp = bk.ZS(localObject[8]);
        locala.qUU = bk.ZR(localObject[9]);
        locala.eud = bk.ZS(localObject[10]);
        locala.qUV = bk.ZR(localObject[11]);
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.WebSearch.WebSearchRedPointMgr", localException, "", new Object[0]);
    }
  }
  
  public static an bZJ()
  {
    return qUR;
  }
  
  public static boolean bZK()
  {
    return false;
  }
  
  public static long bZL()
  {
    Object localObject = g.DP().Dz().get(ac.a.uzh, null);
    if (localObject == null) {
      return 0L;
    }
    return ((Long)localObject).longValue();
  }
  
  public final void save()
  {
    if (this.qUQ == null) {}
    for (Object localObject = "";; localObject = ((an.a)localObject).id + "&" + ((an.a)localObject).qUS + "&" + ((an.a)localObject).qUT + "&" + ((an.a)localObject).lSJ + "&" + ((an.a)localObject).qTU + "&" + ((an.a)localObject).type + "&" + ((an.a)localObject).text + "&" + ((an.a)localObject).bVO + "&" + ((an.a)localObject).timestamp + "&" + ((an.a)localObject).qUU + "&" + ((an.a)localObject).eud + "&" + ((an.a)localObject).qUV)
    {
      g.DP().Dz().c(ac.a.uxo, localObject);
      return;
      localObject = this.qUQ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.an
 * JD-Core Version:    0.7.0.1
 */