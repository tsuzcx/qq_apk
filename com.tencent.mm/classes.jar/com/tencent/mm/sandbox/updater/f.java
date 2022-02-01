package com.tencent.mm.sandbox.updater;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.i;
import com.tencent.mm.d.i.a;
import com.tencent.mm.protocal.protobuf.crl;
import com.tencent.mm.protocal.protobuf.cxx;
import com.tencent.mm.protocal.protobuf.cxy;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.protocal.protobuf.doy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  public String clientVersion;
  public final String cri;
  public final int fileSize;
  public final Integer pkH;
  public final Integer pkI;
  public final Integer pkJ;
  public final String pkK;
  public final String pkL;
  public int versionCode;
  public HashMap<Integer, LinkedList<crl>> ynu;
  public String ynv;
  public String ynw;
  public String ynx;
  public String yny;
  public String ynz;
  
  public f(cxz paramcxz)
  {
    AppMethodBeat.i(32708);
    this.ynu = new HashMap();
    if (paramcxz == null)
    {
      this.pkH = Integer.valueOf(1);
      this.pkK = "";
      this.pkL = "";
      this.pkI = Integer.valueOf(-1);
      this.pkJ = Integer.valueOf(-1);
      this.cri = "";
      this.fileSize = 0;
      this.ynv = "";
      this.ynw = "";
      this.versionCode = 0;
      this.clientVersion = "";
      this.ynx = "";
      this.yny = "";
      this.ynz = "";
      AppMethodBeat.o(32708);
      return;
    }
    if (paramcxz.MCT != null)
    {
      this.pkL = paramcxz.MCT.MD5;
      this.pkK = paramcxz.MCT.Url;
    }
    Object localObject;
    for (this.fileSize = paramcxz.MCT.FileSize;; this.fileSize = 0)
    {
      this.pkH = Integer.valueOf(paramcxz.state);
      this.pkJ = Integer.valueOf(paramcxz.MCS);
      if ((paramcxz.MCQ == null) || (paramcxz.MCQ.isEmpty())) {
        break;
      }
      int j = paramcxz.MCQ.size();
      int i = 0;
      while (i < j)
      {
        localObject = (cxy)paramcxz.MCQ.get(i);
        if ((((cxy)localObject).MCP != null) && (!((cxy)localObject).MCP.isEmpty())) {
          this.ynu.put(Integer.valueOf(((cxy)localObject).type), ((cxy)localObject).MCP);
        }
        i += 1;
      }
      this.pkL = "";
      this.pkK = "";
    }
    this.pkI = Integer.valueOf(paramcxz.MCR);
    this.cri = paramcxz.APx;
    if ((paramcxz.MCV != null) && (!paramcxz.MCV.isEmpty()))
    {
      paramcxz = paramcxz.MCV.iterator();
      while (paramcxz.hasNext())
      {
        localObject = (cxx)paramcxz.next();
        if ((localObject != null) && (!Util.isNullOrNil(((cxx)localObject).key))) {
          if (((cxx)localObject).key.equalsIgnoreCase("newApkMd5")) {
            this.ynv = ((cxx)localObject).value;
          } else if (((cxx)localObject).key.equalsIgnoreCase("oldApkMd5")) {
            this.ynw = ((cxx)localObject).value;
          } else if (((cxx)localObject).key.equalsIgnoreCase("versionCode")) {
            this.versionCode = Util.safeParseInt(((cxx)localObject).value);
          } else if (((cxx)localObject).key.equalsIgnoreCase("clientVersion")) {
            this.clientVersion = ((cxx)localObject).value;
          } else if (((cxx)localObject).key.equalsIgnoreCase("alphaTitle")) {
            this.ynx = aBL(((cxx)localObject).value);
          } else if (((cxx)localObject).key.equalsIgnoreCase("alphaContent")) {
            this.yny = aBL(((cxx)localObject).value);
          } else if (((cxx)localObject).key.equalsIgnoreCase("alphaUrl")) {
            this.ynz = ((cxx)localObject).value;
          }
        }
      }
      AppMethodBeat.o(32708);
      return;
    }
    this.ynv = "";
    this.ynw = "";
    this.versionCode = 0;
    this.clientVersion = "";
    this.ynx = "";
    this.yny = "";
    this.ynz = "";
    AppMethodBeat.o(32708);
  }
  
  public static boolean aBK(String paramString)
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
  
  private static String aBL(String paramString)
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
  
  public final String gwj()
  {
    AppMethodBeat.i(32709);
    Object localObject = this.pkK.substring(0, this.pkK.lastIndexOf('/') + 1);
    String str = this.pkK.substring(this.pkK.lastIndexOf('/') + 1);
    localObject = new i((String)localObject, this.versionCode);
    ((i)localObject).a(new i.a(this.ynw, this.ynv, this.pkL, str, this.fileSize));
    str = ((i)localObject).VO();
    AppMethodBeat.o(32709);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(32710);
    String str = "responseState:" + this.pkH + "\ncdnUrl:" + this.pkK + "\nfileMd5:" + this.pkL + "\npackageType:" + this.pkI + "\nnetworkType:" + this.pkJ + "\npatchId:" + this.cri;
    AppMethodBeat.o(32710);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.f
 * JD-Core Version:    0.7.0.1
 */