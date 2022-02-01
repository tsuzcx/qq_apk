package com.tencent.mm.sandbox.updater;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.i;
import com.tencent.mm.d.i.a;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.protocal.protobuf.dhi;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.protocal.protobuf.dhk;
import com.tencent.mm.protocal.protobuf.dyu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  public String DNA;
  public String DNB;
  public HashMap<Integer, LinkedList<dag>> DNw;
  public String DNx;
  public String DNy;
  public String DNz;
  public String clientVersion;
  public final String coY;
  public final int fileSize;
  public final Integer smQ;
  public final Integer smR;
  public final Integer smS;
  public final String smT;
  public final String smU;
  public int versionCode;
  
  public f(dhk paramdhk)
  {
    AppMethodBeat.i(32708);
    this.DNw = new HashMap();
    if (paramdhk == null)
    {
      this.smQ = Integer.valueOf(1);
      this.smT = "";
      this.smU = "";
      this.smR = Integer.valueOf(-1);
      this.smS = Integer.valueOf(-1);
      this.coY = "";
      this.fileSize = 0;
      this.DNx = "";
      this.DNy = "";
      this.versionCode = 0;
      this.clientVersion = "";
      this.DNz = "";
      this.DNA = "";
      this.DNB = "";
      AppMethodBeat.o(32708);
      return;
    }
    if (paramdhk.TOz != null)
    {
      this.smU = paramdhk.TOz.MD5;
      this.smT = paramdhk.TOz.Url;
    }
    Object localObject;
    for (this.fileSize = paramdhk.TOz.HlG;; this.fileSize = 0)
    {
      this.smQ = Integer.valueOf(paramdhk.state);
      this.smS = Integer.valueOf(paramdhk.TOy);
      if ((paramdhk.TOw == null) || (paramdhk.TOw.isEmpty())) {
        break;
      }
      int j = paramdhk.TOw.size();
      int i = 0;
      while (i < j)
      {
        localObject = (dhj)paramdhk.TOw.get(i);
        if ((((dhj)localObject).TOv != null) && (!((dhj)localObject).TOv.isEmpty())) {
          this.DNw.put(Integer.valueOf(((dhj)localObject).type), ((dhj)localObject).TOv);
        }
        i += 1;
      }
      this.smU = "";
      this.smT = "";
    }
    this.smR = Integer.valueOf(paramdhk.TOx);
    this.coY = paramdhk.GIL;
    if ((paramdhk.TOB != null) && (!paramdhk.TOB.isEmpty()))
    {
      paramdhk = paramdhk.TOB.iterator();
      while (paramdhk.hasNext())
      {
        localObject = (dhi)paramdhk.next();
        if ((localObject != null) && (!Util.isNullOrNil(((dhi)localObject).key))) {
          if (((dhi)localObject).key.equalsIgnoreCase("newApkMd5")) {
            this.DNx = ((dhi)localObject).value;
          } else if (((dhi)localObject).key.equalsIgnoreCase("oldApkMd5")) {
            this.DNy = ((dhi)localObject).value;
          } else if (((dhi)localObject).key.equalsIgnoreCase("versionCode")) {
            this.versionCode = Util.safeParseInt(((dhi)localObject).value);
          } else if (((dhi)localObject).key.equalsIgnoreCase("clientVersion")) {
            this.clientVersion = ((dhi)localObject).value;
          } else if (((dhi)localObject).key.equalsIgnoreCase("alphaTitle")) {
            this.DNz = aLS(((dhi)localObject).value);
          } else if (((dhi)localObject).key.equalsIgnoreCase("alphaContent")) {
            this.DNA = aLS(((dhi)localObject).value);
          } else if (((dhi)localObject).key.equalsIgnoreCase("alphaUrl")) {
            this.DNB = ((dhi)localObject).value;
          }
        }
      }
      AppMethodBeat.o(32708);
      return;
    }
    this.DNx = "";
    this.DNy = "";
    this.versionCode = 0;
    this.clientVersion = "";
    this.DNz = "";
    this.DNA = "";
    this.DNB = "";
    AppMethodBeat.o(32708);
  }
  
  public static boolean aLR(String paramString)
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
  
  private static String aLS(String paramString)
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
  
  public final String hsi()
  {
    AppMethodBeat.i(32709);
    Object localObject = this.smT.substring(0, this.smT.lastIndexOf('/') + 1);
    String str = this.smT.substring(this.smT.lastIndexOf('/') + 1);
    localObject = new i((String)localObject, this.versionCode);
    ((i)localObject).a(new i.a(this.DNy, this.DNx, this.smU, str, this.fileSize));
    str = ((i)localObject).aaj();
    AppMethodBeat.o(32709);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(32710);
    String str = "responseState:" + this.smQ + "\ncdnUrl:" + this.smT + "\nfileMd5:" + this.smU + "\npackageType:" + this.smR + "\nnetworkType:" + this.smS + "\npatchId:" + this.coY;
    AppMethodBeat.o(32710);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.f
 * JD-Core Version:    0.7.0.1
 */