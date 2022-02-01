package com.tencent.mm.sandbox.updater;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.i;
import com.tencent.mm.d.i.a;
import com.tencent.mm.protocal.protobuf.ccj;
import com.tencent.mm.protocal.protobuf.chq;
import com.tencent.mm.protocal.protobuf.chr;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.protocal.protobuf.cwf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  public String clientVersion;
  public final int fileSize;
  public final String gKg;
  public final Integer nZJ;
  public final Integer nZK;
  public final Integer nZL;
  public final String nZM;
  public final String nZN;
  public HashMap<Integer, LinkedList<ccj>> uUT;
  public String uUU;
  public String uUV;
  public String uUW;
  public String uUX;
  public String uUY;
  public int versionCode;
  
  public f(chs paramchs)
  {
    AppMethodBeat.i(32708);
    this.uUT = new HashMap();
    if (paramchs == null)
    {
      this.nZJ = Integer.valueOf(1);
      this.gKg = "";
      this.nZM = "";
      this.nZK = Integer.valueOf(-1);
      this.nZL = Integer.valueOf(-1);
      this.nZN = "";
      this.fileSize = 0;
      this.uUU = "";
      this.uUV = "";
      this.versionCode = 0;
      this.clientVersion = "";
      this.uUW = "";
      this.uUX = "";
      this.uUY = "";
      AppMethodBeat.o(32708);
      return;
    }
    if (paramchs.HtV != null)
    {
      this.nZM = paramchs.HtV.MD5;
      this.gKg = paramchs.HtV.Url;
    }
    Object localObject;
    for (this.fileSize = paramchs.HtV.FileSize;; this.fileSize = 0)
    {
      this.nZJ = Integer.valueOf(paramchs.state);
      this.nZL = Integer.valueOf(paramchs.HtU);
      if ((paramchs.HtS == null) || (paramchs.HtS.isEmpty())) {
        break;
      }
      int j = paramchs.HtS.size();
      int i = 0;
      while (i < j)
      {
        localObject = (chr)paramchs.HtS.get(i);
        if ((((chr)localObject).HtR != null) && (!((chr)localObject).HtR.isEmpty())) {
          this.uUT.put(Integer.valueOf(((chr)localObject).type), ((chr)localObject).HtR);
        }
        i += 1;
      }
      this.nZM = "";
      this.gKg = "";
    }
    this.nZK = Integer.valueOf(paramchs.HtT);
    this.nZN = paramchs.wTE;
    if ((paramchs.HtX != null) && (!paramchs.HtX.isEmpty()))
    {
      paramchs = paramchs.HtX.iterator();
      while (paramchs.hasNext())
      {
        localObject = (chq)paramchs.next();
        if ((localObject != null) && (!bu.isNullOrNil(((chq)localObject).key))) {
          if (((chq)localObject).key.equalsIgnoreCase("newApkMd5")) {
            this.uUU = ((chq)localObject).value;
          } else if (((chq)localObject).key.equalsIgnoreCase("oldApkMd5")) {
            this.uUV = ((chq)localObject).value;
          } else if (((chq)localObject).key.equalsIgnoreCase("versionCode")) {
            this.versionCode = bu.aSB(((chq)localObject).value);
          } else if (((chq)localObject).key.equalsIgnoreCase("clientVersion")) {
            this.clientVersion = ((chq)localObject).value;
          } else if (((chq)localObject).key.equalsIgnoreCase("alphaTitle")) {
            this.uUW = aos(((chq)localObject).value);
          } else if (((chq)localObject).key.equalsIgnoreCase("alphaContent")) {
            this.uUX = aos(((chq)localObject).value);
          } else if (((chq)localObject).key.equalsIgnoreCase("alphaUrl")) {
            this.uUY = ((chq)localObject).value;
          }
        }
      }
      AppMethodBeat.o(32708);
      return;
    }
    this.uUU = "";
    this.uUV = "";
    this.versionCode = 0;
    this.clientVersion = "";
    this.uUW = "";
    this.uUX = "";
    this.uUY = "";
    AppMethodBeat.o(32708);
  }
  
  public static boolean aor(String paramString)
  {
    AppMethodBeat.i(32711);
    if ((!bu.isNullOrNil(paramString)) && (paramString.length() == 10)) {
      try
      {
        int i = Integer.decode(paramString).intValue();
        if (((i & 0xFF) >= 0) && ((i & 0xFF) <= 31))
        {
          AppMethodBeat.o(32711);
          return true;
        }
        AppMethodBeat.o(32711);
        return false;
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("Tinker.TinkerSyncResponse", paramString, "checkAplhVersion failed.", new Object[0]);
      }
    }
    AppMethodBeat.o(32711);
    return false;
  }
  
  private static String aos(String paramString)
  {
    AppMethodBeat.i(32712);
    if (!bu.isNullOrNil(paramString))
    {
      paramString = new String(Base64.decode(paramString, 0));
      AppMethodBeat.o(32712);
      return paramString;
    }
    AppMethodBeat.o(32712);
    return "";
  }
  
  public final String fmw()
  {
    AppMethodBeat.i(32709);
    Object localObject = this.gKg.substring(0, this.gKg.lastIndexOf('/') + 1);
    String str = this.gKg.substring(this.gKg.lastIndexOf('/') + 1);
    localObject = new i((String)localObject, this.versionCode);
    ((i)localObject).a(new i.a(this.uUV, this.uUU, this.nZM, str, this.fileSize));
    str = ((i)localObject).LB();
    AppMethodBeat.o(32709);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(32710);
    String str = "responseState:" + this.nZJ + "\ncdnUrl:" + this.gKg + "\nfileMd5:" + this.nZM + "\npackageType:" + this.nZK + "\nnetworkType:" + this.nZL + "\npatchId:" + this.nZN;
    AppMethodBeat.o(32710);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.f
 * JD-Core Version:    0.7.0.1
 */