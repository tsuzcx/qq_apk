package com.tencent.mm.sandbox.updater;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.i;
import com.tencent.mm.d.i.a;
import com.tencent.mm.protocal.protobuf.bsi;
import com.tencent.mm.protocal.protobuf.bxk;
import com.tencent.mm.protocal.protobuf.bxl;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  public String clientVersion;
  public final int fileSize;
  public final Integer syD;
  public HashMap<Integer, LinkedList<bsi>> syE;
  public final Integer syF;
  public final Integer syG;
  public final String syH;
  public final String syI;
  public final String syJ;
  public String syK;
  public String syL;
  public String syM;
  public String syN;
  public String syO;
  public int versionCode;
  
  public f(bxm parambxm)
  {
    AppMethodBeat.i(32708);
    this.syE = new HashMap();
    if (parambxm == null)
    {
      this.syD = Integer.valueOf(1);
      this.syH = "";
      this.syI = "";
      this.syF = Integer.valueOf(-1);
      this.syG = Integer.valueOf(-1);
      this.syJ = "";
      this.fileSize = 0;
      this.syK = "";
      this.syL = "";
      this.versionCode = 0;
      this.clientVersion = "";
      this.syM = "";
      this.syN = "";
      this.syO = "";
      AppMethodBeat.o(32708);
      return;
    }
    if (parambxm.DTY != null)
    {
      this.syI = parambxm.DTY.MD5;
      this.syH = parambxm.DTY.Url;
    }
    Object localObject;
    for (this.fileSize = parambxm.DTY.FileSize;; this.fileSize = 0)
    {
      this.syD = Integer.valueOf(parambxm.state);
      this.syG = Integer.valueOf(parambxm.DTX);
      if ((parambxm.DTV == null) || (parambxm.DTV.isEmpty())) {
        break;
      }
      int j = parambxm.DTV.size();
      int i = 0;
      while (i < j)
      {
        localObject = (bxl)parambxm.DTV.get(i);
        if ((((bxl)localObject).DTU != null) && (!((bxl)localObject).DTU.isEmpty())) {
          this.syE.put(Integer.valueOf(((bxl)localObject).type), ((bxl)localObject).DTU);
        }
        i += 1;
      }
      this.syI = "";
      this.syH = "";
    }
    this.syF = Integer.valueOf(parambxm.DTW);
    this.syJ = parambxm.upD;
    if ((parambxm.DUa != null) && (!parambxm.DUa.isEmpty()))
    {
      parambxm = parambxm.DUa.iterator();
      while (parambxm.hasNext())
      {
        localObject = (bxk)parambxm.next();
        if ((localObject != null) && (!bt.isNullOrNil(((bxk)localObject).key))) {
          if (((bxk)localObject).key.equalsIgnoreCase("newApkMd5")) {
            this.syK = ((bxk)localObject).value;
          } else if (((bxk)localObject).key.equalsIgnoreCase("oldApkMd5")) {
            this.syL = ((bxk)localObject).value;
          } else if (((bxk)localObject).key.equalsIgnoreCase("versionCode")) {
            this.versionCode = bt.aGh(((bxk)localObject).value);
          } else if (((bxk)localObject).key.equalsIgnoreCase("clientVersion")) {
            this.clientVersion = ((bxk)localObject).value;
          } else if (((bxk)localObject).key.equalsIgnoreCase("alphaTitle")) {
            this.syM = adL(((bxk)localObject).value);
          } else if (((bxk)localObject).key.equalsIgnoreCase("alphaContent")) {
            this.syN = adL(((bxk)localObject).value);
          } else if (((bxk)localObject).key.equalsIgnoreCase("alphaUrl")) {
            this.syO = ((bxk)localObject).value;
          }
        }
      }
      AppMethodBeat.o(32708);
      return;
    }
    this.syK = "";
    this.syL = "";
    this.versionCode = 0;
    this.clientVersion = "";
    this.syM = "";
    this.syN = "";
    this.syO = "";
    AppMethodBeat.o(32708);
  }
  
  public static boolean adK(String paramString)
  {
    AppMethodBeat.i(32711);
    if ((!bt.isNullOrNil(paramString)) && (paramString.length() == 10)) {
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
        ad.printErrStackTrace("Tinker.TinkerSyncResponse", paramString, "checkAplhVersion failed.", new Object[0]);
      }
    }
    AppMethodBeat.o(32711);
    return false;
  }
  
  private static String adL(String paramString)
  {
    AppMethodBeat.i(32712);
    if (!bt.isNullOrNil(paramString))
    {
      paramString = new String(Base64.decode(paramString, 0));
      AppMethodBeat.o(32712);
      return paramString;
    }
    AppMethodBeat.o(32712);
    return "";
  }
  
  public final String eDI()
  {
    AppMethodBeat.i(32709);
    Object localObject = this.syH.substring(0, this.syH.lastIndexOf('/') + 1);
    String str = this.syH.substring(this.syH.lastIndexOf('/') + 1);
    localObject = new i((String)localObject, this.versionCode);
    ((i)localObject).a(new i.a(this.syL, this.syK, this.syI, str, this.fileSize));
    str = ((i)localObject).Kk();
    AppMethodBeat.o(32709);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(32710);
    String str = "responseState:" + this.syD + "\ncdnUrl:" + this.syH + "\nfileMd5:" + this.syI + "\npackageType:" + this.syF + "\nnetworkType:" + this.syG + "\npatchId:" + this.syJ;
    AppMethodBeat.o(32710);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.f
 * JD-Core Version:    0.7.0.1
 */