package com.tencent.mm.sandbox.updater;

import android.util.Base64;
import com.tencent.mm.c.i;
import com.tencent.mm.c.i.a;
import com.tencent.mm.protocal.c.ayo;
import com.tencent.mm.protocal.c.blu;
import com.tencent.mm.protocal.c.bxt;
import com.tencent.mm.protocal.c.bxu;
import com.tencent.mm.protocal.c.bxv;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  public String clientVersion;
  public final int fileSize;
  public String lnA;
  public String lnB;
  public String lnC;
  public String lnD;
  public final Integer lns;
  public HashMap<Integer, LinkedList<ayo>> lnt = new HashMap();
  public final Integer lnu;
  public final Integer lnv;
  public final String lnw;
  public final String lnx;
  public final String lny;
  public String lnz;
  public int versionCode;
  
  public e(bxv parambxv)
  {
    if (parambxv == null)
    {
      this.lns = Integer.valueOf(1);
      this.lnw = "";
      this.lnx = "";
      this.lnu = Integer.valueOf(-1);
      this.lnv = Integer.valueOf(-1);
      this.lny = "";
      this.fileSize = 0;
      this.lnz = "";
      this.lnA = "";
      this.versionCode = 0;
      this.clientVersion = "";
      this.lnB = "";
      this.lnC = "";
      this.lnD = "";
    }
    for (;;)
    {
      return;
      if (parambxv.tNQ != null)
      {
        this.lnx = parambxv.tNQ.sRE;
        this.lnw = parambxv.tNQ.kSC;
      }
      Object localObject;
      for (this.fileSize = parambxv.tNQ.ndo;; this.fileSize = 0)
      {
        this.lns = Integer.valueOf(parambxv.state);
        this.lnv = Integer.valueOf(parambxv.tNP);
        if ((parambxv.tNN == null) || (parambxv.tNN.isEmpty())) {
          break;
        }
        int j = parambxv.tNN.size();
        int i = 0;
        while (i < j)
        {
          localObject = (bxu)parambxv.tNN.get(i);
          if ((((bxu)localObject).tNM != null) && (!((bxu)localObject).tNM.isEmpty())) {
            this.lnt.put(Integer.valueOf(((bxu)localObject).type), ((bxu)localObject).tNM);
          }
          i += 1;
        }
        this.lnx = "";
        this.lnw = "";
      }
      this.lnu = Integer.valueOf(parambxv.tNO);
      this.lny = parambxv.sNz;
      if ((parambxv.tNS == null) || (parambxv.tNS.isEmpty())) {
        break;
      }
      parambxv = parambxv.tNS.iterator();
      while (parambxv.hasNext())
      {
        localObject = (bxt)parambxv.next();
        if ((localObject != null) && (!bk.bl(((bxt)localObject).key))) {
          if (((bxt)localObject).key.equalsIgnoreCase("newApkMd5")) {
            this.lnz = ((bxt)localObject).value;
          } else if (((bxt)localObject).key.equalsIgnoreCase("oldApkMd5")) {
            this.lnA = ((bxt)localObject).value;
          } else if (((bxt)localObject).key.equalsIgnoreCase("versionCode")) {
            this.versionCode = bk.ZR(((bxt)localObject).value);
          } else if (((bxt)localObject).key.equalsIgnoreCase("clientVersion")) {
            this.clientVersion = ((bxt)localObject).value;
          } else if (((bxt)localObject).key.equalsIgnoreCase("alphaTitle")) {
            this.lnB = Fu(((bxt)localObject).value);
          } else if (((bxt)localObject).key.equalsIgnoreCase("alphaContent")) {
            this.lnC = Fu(((bxt)localObject).value);
          } else if (((bxt)localObject).key.equalsIgnoreCase("alphaUrl")) {
            this.lnD = ((bxt)localObject).value;
          }
        }
      }
    }
    this.lnz = "";
    this.lnA = "";
    this.versionCode = 0;
    this.clientVersion = "";
    this.lnB = "";
    this.lnC = "";
    this.lnD = "";
  }
  
  public static boolean Ft(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bk.bl(paramString))
    {
      bool1 = bool2;
      if (paramString.length() != 10) {}
    }
    try
    {
      int i = Integer.decode(paramString).intValue();
      bool1 = bool2;
      if ((i & 0xFF) >= 0)
      {
        bool1 = bool2;
        if ((i & 0xFF) <= 31) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("Tinker.TinkerSyncResponse", paramString, "checkAplhVersion failed.", new Object[0]);
    }
    return false;
  }
  
  private static String Fu(String paramString)
  {
    if (!bk.bl(paramString)) {
      return new String(Base64.decode(paramString, 0));
    }
    return "";
  }
  
  public final String cpR()
  {
    Object localObject = this.lnw.substring(0, this.lnw.lastIndexOf('/') + 1);
    String str = this.lnw.substring(this.lnw.lastIndexOf('/') + 1);
    localObject = new i((String)localObject, Integer.valueOf(this.versionCode).intValue());
    ((i)localObject).a(new i.a(this.lnA, this.lnz, this.lnx, str, this.fileSize));
    return ((i)localObject).st();
  }
  
  public final String toString()
  {
    return "responseState:" + this.lns + "\ncdnUrl:" + this.lnw + "\nfileMd5:" + this.lnx + "\npackageType:" + this.lnu + "\nnetworkType:" + this.lnv + "\npatchId:" + this.lny;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.e
 * JD-Core Version:    0.7.0.1
 */