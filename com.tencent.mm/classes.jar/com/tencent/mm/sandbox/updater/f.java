package com.tencent.mm.sandbox.updater;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.i;
import com.tencent.mm.d.i.a;
import com.tencent.mm.protocal.protobuf.bwz;
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.protocal.protobuf.ccg;
import com.tencent.mm.protocal.protobuf.cch;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  public String clientVersion;
  public final int fileSize;
  public final String gnO;
  public final Integer nth;
  public final Integer nti;
  public final Integer ntj;
  public final String ntk;
  public final String ntl;
  public HashMap<Integer, LinkedList<bwz>> tGt;
  public String tGu;
  public String tGv;
  public String tGw;
  public String tGx;
  public String tGy;
  public int versionCode;
  
  public f(cch paramcch)
  {
    AppMethodBeat.i(32708);
    this.tGt = new HashMap();
    if (paramcch == null)
    {
      this.nth = Integer.valueOf(1);
      this.gnO = "";
      this.ntk = "";
      this.nti = Integer.valueOf(-1);
      this.ntj = Integer.valueOf(-1);
      this.ntl = "";
      this.fileSize = 0;
      this.tGu = "";
      this.tGv = "";
      this.versionCode = 0;
      this.clientVersion = "";
      this.tGw = "";
      this.tGx = "";
      this.tGy = "";
      AppMethodBeat.o(32708);
      return;
    }
    if (paramcch.FqL != null)
    {
      this.ntk = paramcch.FqL.MD5;
      this.gnO = paramcch.FqL.Url;
    }
    Object localObject;
    for (this.fileSize = paramcch.FqL.FileSize;; this.fileSize = 0)
    {
      this.nth = Integer.valueOf(paramcch.state);
      this.ntj = Integer.valueOf(paramcch.FqK);
      if ((paramcch.FqI == null) || (paramcch.FqI.isEmpty())) {
        break;
      }
      int j = paramcch.FqI.size();
      int i = 0;
      while (i < j)
      {
        localObject = (ccg)paramcch.FqI.get(i);
        if ((((ccg)localObject).FqH != null) && (!((ccg)localObject).FqH.isEmpty())) {
          this.tGt.put(Integer.valueOf(((ccg)localObject).type), ((ccg)localObject).FqH);
        }
        i += 1;
      }
      this.ntk = "";
      this.gnO = "";
    }
    this.nti = Integer.valueOf(paramcch.FqJ);
    this.ntl = paramcch.vyz;
    if ((paramcch.FqN != null) && (!paramcch.FqN.isEmpty()))
    {
      paramcch = paramcch.FqN.iterator();
      while (paramcch.hasNext())
      {
        localObject = (ccf)paramcch.next();
        if ((localObject != null) && (!bs.isNullOrNil(((ccf)localObject).key))) {
          if (((ccf)localObject).key.equalsIgnoreCase("newApkMd5")) {
            this.tGu = ((ccf)localObject).value;
          } else if (((ccf)localObject).key.equalsIgnoreCase("oldApkMd5")) {
            this.tGv = ((ccf)localObject).value;
          } else if (((ccf)localObject).key.equalsIgnoreCase("versionCode")) {
            this.versionCode = bs.aLy(((ccf)localObject).value);
          } else if (((ccf)localObject).key.equalsIgnoreCase("clientVersion")) {
            this.clientVersion = ((ccf)localObject).value;
          } else if (((ccf)localObject).key.equalsIgnoreCase("alphaTitle")) {
            this.tGw = aiD(((ccf)localObject).value);
          } else if (((ccf)localObject).key.equalsIgnoreCase("alphaContent")) {
            this.tGx = aiD(((ccf)localObject).value);
          } else if (((ccf)localObject).key.equalsIgnoreCase("alphaUrl")) {
            this.tGy = ((ccf)localObject).value;
          }
        }
      }
      AppMethodBeat.o(32708);
      return;
    }
    this.tGu = "";
    this.tGv = "";
    this.versionCode = 0;
    this.clientVersion = "";
    this.tGw = "";
    this.tGx = "";
    this.tGy = "";
    AppMethodBeat.o(32708);
  }
  
  public static boolean aiC(String paramString)
  {
    AppMethodBeat.i(32711);
    if ((!bs.isNullOrNil(paramString)) && (paramString.length() == 10)) {
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
        ac.printErrStackTrace("Tinker.TinkerSyncResponse", paramString, "checkAplhVersion failed.", new Object[0]);
      }
    }
    AppMethodBeat.o(32711);
    return false;
  }
  
  private static String aiD(String paramString)
  {
    AppMethodBeat.i(32712);
    if (!bs.isNullOrNil(paramString))
    {
      paramString = new String(Base64.decode(paramString, 0));
      AppMethodBeat.o(32712);
      return paramString;
    }
    AppMethodBeat.o(32712);
    return "";
  }
  
  public final String eTc()
  {
    AppMethodBeat.i(32709);
    Object localObject = this.gnO.substring(0, this.gnO.lastIndexOf('/') + 1);
    String str = this.gnO.substring(this.gnO.lastIndexOf('/') + 1);
    localObject = new i((String)localObject, this.versionCode);
    ((i)localObject).a(new i.a(this.tGv, this.tGu, this.ntk, str, this.fileSize));
    str = ((i)localObject).JU();
    AppMethodBeat.o(32709);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(32710);
    String str = "responseState:" + this.nth + "\ncdnUrl:" + this.gnO + "\nfileMd5:" + this.ntk + "\npackageType:" + this.nti + "\nnetworkType:" + this.ntj + "\npatchId:" + this.ntl;
    AppMethodBeat.o(32710);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.f
 * JD-Core Version:    0.7.0.1
 */