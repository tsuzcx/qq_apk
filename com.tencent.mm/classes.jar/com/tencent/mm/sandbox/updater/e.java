package com.tencent.mm.sandbox.updater;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.i;
import com.tencent.mm.c.i.a;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.bjx;
import com.tencent.mm.protocal.protobuf.bjy;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  public String clientVersion;
  public final int fileSize;
  public final Integer nKL;
  public HashMap<Integer, LinkedList<bfl>> nKM;
  public final Integer nKN;
  public final Integer nKO;
  public final String nKP;
  public final String nKQ;
  public final String nKR;
  public String nKS;
  public String nKT;
  public String nKU;
  public String nKV;
  public String nKW;
  public int versionCode;
  
  public e(bjy parambjy)
  {
    AppMethodBeat.i(28894);
    this.nKM = new HashMap();
    if (parambjy == null)
    {
      this.nKL = Integer.valueOf(1);
      this.nKP = "";
      this.nKQ = "";
      this.nKN = Integer.valueOf(-1);
      this.nKO = Integer.valueOf(-1);
      this.nKR = "";
      this.fileSize = 0;
      this.nKS = "";
      this.nKT = "";
      this.versionCode = 0;
      this.clientVersion = "";
      this.nKU = "";
      this.nKV = "";
      this.nKW = "";
      AppMethodBeat.o(28894);
      return;
    }
    if (parambjy.xyr != null)
    {
      this.nKQ = parambjy.xyr.wQr;
      this.nKP = parambjy.xyr.Url;
    }
    Object localObject;
    for (this.fileSize = parambjy.xyr.FileSize;; this.fileSize = 0)
    {
      this.nKL = Integer.valueOf(parambjy.state);
      this.nKO = Integer.valueOf(parambjy.xyq);
      if ((parambjy.xyo == null) || (parambjy.xyo.isEmpty())) {
        break;
      }
      int j = parambjy.xyo.size();
      int i = 0;
      while (i < j)
      {
        localObject = (bjx)parambjy.xyo.get(i);
        if ((((bjx)localObject).xyn != null) && (!((bjx)localObject).xyn.isEmpty())) {
          this.nKM.put(Integer.valueOf(((bjx)localObject).type), ((bjx)localObject).xyn);
        }
        i += 1;
      }
      this.nKQ = "";
      this.nKP = "";
    }
    this.nKN = Integer.valueOf(parambjy.xyp);
    this.nKR = parambjy.pqD;
    if ((parambjy.xyu != null) && (!parambjy.xyu.isEmpty()))
    {
      parambjy = parambjy.xyu.iterator();
      while (parambjy.hasNext())
      {
        localObject = (bjw)parambjy.next();
        if ((localObject != null) && (!bo.isNullOrNil(((bjw)localObject).key))) {
          if (((bjw)localObject).key.equalsIgnoreCase("newApkMd5")) {
            this.nKS = ((bjw)localObject).value;
          } else if (((bjw)localObject).key.equalsIgnoreCase("oldApkMd5")) {
            this.nKT = ((bjw)localObject).value;
          } else if (((bjw)localObject).key.equalsIgnoreCase("versionCode")) {
            this.versionCode = bo.apV(((bjw)localObject).value);
          } else if (((bjw)localObject).key.equalsIgnoreCase("clientVersion")) {
            this.clientVersion = ((bjw)localObject).value;
          } else if (((bjw)localObject).key.equalsIgnoreCase("alphaTitle")) {
            this.nKU = QS(((bjw)localObject).value);
          } else if (((bjw)localObject).key.equalsIgnoreCase("alphaContent")) {
            this.nKV = QS(((bjw)localObject).value);
          } else if (((bjw)localObject).key.equalsIgnoreCase("alphaUrl")) {
            this.nKW = ((bjw)localObject).value;
          }
        }
      }
      AppMethodBeat.o(28894);
      return;
    }
    this.nKS = "";
    this.nKT = "";
    this.versionCode = 0;
    this.clientVersion = "";
    this.nKU = "";
    this.nKV = "";
    this.nKW = "";
    AppMethodBeat.o(28894);
  }
  
  public static boolean QR(String paramString)
  {
    AppMethodBeat.i(28897);
    if ((!bo.isNullOrNil(paramString)) && (paramString.length() == 10)) {
      try
      {
        int i = Integer.decode(paramString).intValue();
        if (((i & 0xFF) >= 0) && ((i & 0xFF) <= 31))
        {
          AppMethodBeat.o(28897);
          return true;
        }
        AppMethodBeat.o(28897);
        return false;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("Tinker.TinkerSyncResponse", paramString, "checkAplhVersion failed.", new Object[0]);
      }
    }
    AppMethodBeat.o(28897);
    return false;
  }
  
  private static String QS(String paramString)
  {
    AppMethodBeat.i(28898);
    if (!bo.isNullOrNil(paramString))
    {
      paramString = new String(Base64.decode(paramString, 0));
      AppMethodBeat.o(28898);
      return paramString;
    }
    AppMethodBeat.o(28898);
    return "";
  }
  
  public final String drF()
  {
    AppMethodBeat.i(28895);
    Object localObject = this.nKP.substring(0, this.nKP.lastIndexOf('/') + 1);
    String str = this.nKP.substring(this.nKP.lastIndexOf('/') + 1);
    localObject = new i((String)localObject, this.versionCode);
    ((i)localObject).a(new i.a(this.nKT, this.nKS, this.nKQ, str, this.fileSize));
    str = ((i)localObject).AK();
    AppMethodBeat.o(28895);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(28896);
    String str = "responseState:" + this.nKL + "\ncdnUrl:" + this.nKP + "\nfileMd5:" + this.nKQ + "\npackageType:" + this.nKN + "\nnetworkType:" + this.nKO + "\npatchId:" + this.nKR;
    AppMethodBeat.o(28896);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.e
 * JD-Core Version:    0.7.0.1
 */