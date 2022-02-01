package com.tencent.mm.sandbox.updater;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.h;
import com.tencent.mm.d.h.a;
import com.tencent.mm.protocal.protobuf.dro;
import com.tencent.mm.protocal.protobuf.dzr;
import com.tencent.mm.protocal.protobuf.dzs;
import com.tencent.mm.protocal.protobuf.dzt;
import com.tencent.mm.protocal.protobuf.ery;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  public HashMap<Integer, LinkedList<dro>> JEK;
  public String JEL;
  public String JEM;
  public String JEN;
  public String JEO;
  public String JEP;
  public String clientVersion;
  public final String egJ;
  public final int fileSize;
  public final String mOI;
  public int versionCode;
  public final Integer vyP;
  public final Integer vyQ;
  public final Integer vyR;
  public final String vyS;
  
  public f(dzt paramdzt)
  {
    AppMethodBeat.i(32708);
    this.JEK = new HashMap();
    if (paramdzt == null)
    {
      this.vyP = Integer.valueOf(1);
      this.mOI = "";
      this.vyS = "";
      this.vyQ = Integer.valueOf(-1);
      this.vyR = Integer.valueOf(-1);
      this.egJ = "";
      this.fileSize = 0;
      this.JEL = "";
      this.JEM = "";
      this.versionCode = 0;
      this.clientVersion = "";
      this.JEN = "";
      this.JEO = "";
      this.JEP = "";
      AppMethodBeat.o(32708);
      return;
    }
    if (paramdzt.abeV != null)
    {
      this.vyS = paramdzt.abeV.MD5;
      this.mOI = paramdzt.abeV.Url;
    }
    Object localObject;
    for (this.fileSize = paramdzt.abeV.Nju;; this.fileSize = 0)
    {
      this.vyP = Integer.valueOf(paramdzt.state);
      this.vyR = Integer.valueOf(paramdzt.abeU);
      if ((paramdzt.abeS == null) || (paramdzt.abeS.isEmpty())) {
        break;
      }
      int j = paramdzt.abeS.size();
      int i = 0;
      while (i < j)
      {
        localObject = (dzs)paramdzt.abeS.get(i);
        if ((((dzs)localObject).abeR != null) && (!((dzs)localObject).abeR.isEmpty())) {
          this.JEK.put(Integer.valueOf(((dzs)localObject).type), ((dzs)localObject).abeR);
        }
        i += 1;
      }
      this.vyS = "";
      this.mOI = "";
    }
    this.vyQ = Integer.valueOf(paramdzt.abeT);
    this.egJ = paramdzt.ycW;
    if ((paramdzt.abeX != null) && (!paramdzt.abeX.isEmpty()))
    {
      paramdzt = paramdzt.abeX.iterator();
      while (paramdzt.hasNext())
      {
        localObject = (dzr)paramdzt.next();
        if ((localObject != null) && (!Util.isNullOrNil(((dzr)localObject).key))) {
          if (((dzr)localObject).key.equalsIgnoreCase("newApkMd5")) {
            this.JEL = ((dzr)localObject).value;
          } else if (((dzr)localObject).key.equalsIgnoreCase("oldApkMd5")) {
            this.JEM = ((dzr)localObject).value;
          } else if (((dzr)localObject).key.equalsIgnoreCase("versionCode")) {
            this.versionCode = Util.safeParseInt(((dzr)localObject).value);
          } else if (((dzr)localObject).key.equalsIgnoreCase("clientVersion")) {
            this.clientVersion = ((dzr)localObject).value;
          } else if (((dzr)localObject).key.equalsIgnoreCase("alphaTitle")) {
            this.JEN = aIM(((dzr)localObject).value);
          } else if (((dzr)localObject).key.equalsIgnoreCase("alphaContent")) {
            this.JEO = aIM(((dzr)localObject).value);
          } else if (((dzr)localObject).key.equalsIgnoreCase("alphaUrl")) {
            this.JEP = ((dzr)localObject).value;
          }
        }
      }
      AppMethodBeat.o(32708);
      return;
    }
    this.JEL = "";
    this.JEM = "";
    this.versionCode = 0;
    this.clientVersion = "";
    this.JEN = "";
    this.JEO = "";
    this.JEP = "";
    AppMethodBeat.o(32708);
  }
  
  public static boolean aIL(String paramString)
  {
    AppMethodBeat.i(32711);
    if ((!Util.isNullOrNil(paramString)) && (paramString.length() == 10)) {
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
        Log.printErrStackTrace("Tinker.TinkerSyncResponse", paramString, "checkAplhVersion failed.", new Object[0]);
      }
    }
    AppMethodBeat.o(32711);
    return false;
  }
  
  private static String aIM(String paramString)
  {
    AppMethodBeat.i(32712);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = new String(Base64.decode(paramString, 0));
      AppMethodBeat.o(32712);
      return paramString;
    }
    AppMethodBeat.o(32712);
    return "";
  }
  
  public final String iSn()
  {
    AppMethodBeat.i(32709);
    Object localObject = this.mOI.substring(0, this.mOI.lastIndexOf('/') + 1);
    String str = this.mOI.substring(this.mOI.lastIndexOf('/') + 1);
    localObject = new h((String)localObject, this.versionCode);
    ((h)localObject).a(new h.a(this.JEM, this.JEL, this.vyS, str, this.fileSize));
    str = ((h)localObject).aBN();
    AppMethodBeat.o(32709);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(32710);
    String str = "responseState:" + this.vyP + "\ncdnUrl:" + this.mOI + "\nfileMd5:" + this.vyS + "\npackageType:" + this.vyQ + "\nnetworkType:" + this.vyR + "\npatchId:" + this.egJ;
    AppMethodBeat.o(32710);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.f
 * JD-Core Version:    0.7.0.1
 */