package com.tencent.mm.sandbox.updater;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.i;
import com.tencent.mm.d.i.a;
import com.tencent.mm.protocal.protobuf.cbp;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.protocal.protobuf.cgx;
import com.tencent.mm.protocal.protobuf.cgy;
import com.tencent.mm.protocal.protobuf.cvl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  public String clientVersion;
  public final int fileSize;
  public final String gHx;
  public final Integer nUd;
  public final Integer nUe;
  public final Integer nUf;
  public final String nUg;
  public final String nUh;
  public HashMap<Integer, LinkedList<cbp>> uJg;
  public String uJh;
  public String uJi;
  public String uJj;
  public String uJk;
  public String uJl;
  public int versionCode;
  
  public f(cgy paramcgy)
  {
    AppMethodBeat.i(32708);
    this.uJg = new HashMap();
    if (paramcgy == null)
    {
      this.nUd = Integer.valueOf(1);
      this.gHx = "";
      this.nUg = "";
      this.nUe = Integer.valueOf(-1);
      this.nUf = Integer.valueOf(-1);
      this.nUh = "";
      this.fileSize = 0;
      this.uJh = "";
      this.uJi = "";
      this.versionCode = 0;
      this.clientVersion = "";
      this.uJj = "";
      this.uJk = "";
      this.uJl = "";
      AppMethodBeat.o(32708);
      return;
    }
    if (paramcgy.Hav != null)
    {
      this.nUg = paramcgy.Hav.MD5;
      this.gHx = paramcgy.Hav.Url;
    }
    Object localObject;
    for (this.fileSize = paramcgy.Hav.FileSize;; this.fileSize = 0)
    {
      this.nUd = Integer.valueOf(paramcgy.state);
      this.nUf = Integer.valueOf(paramcgy.Hau);
      if ((paramcgy.Has == null) || (paramcgy.Has.isEmpty())) {
        break;
      }
      int j = paramcgy.Has.size();
      int i = 0;
      while (i < j)
      {
        localObject = (cgx)paramcgy.Has.get(i);
        if ((((cgx)localObject).Har != null) && (!((cgx)localObject).Har.isEmpty())) {
          this.uJg.put(Integer.valueOf(((cgx)localObject).type), ((cgx)localObject).Har);
        }
        i += 1;
      }
      this.nUg = "";
      this.gHx = "";
    }
    this.nUe = Integer.valueOf(paramcgy.Hat);
    this.nUh = paramcgy.wDT;
    if ((paramcgy.Hax != null) && (!paramcgy.Hax.isEmpty()))
    {
      paramcgy = paramcgy.Hax.iterator();
      while (paramcgy.hasNext())
      {
        localObject = (cgw)paramcgy.next();
        if ((localObject != null) && (!bt.isNullOrNil(((cgw)localObject).key))) {
          if (((cgw)localObject).key.equalsIgnoreCase("newApkMd5")) {
            this.uJh = ((cgw)localObject).value;
          } else if (((cgw)localObject).key.equalsIgnoreCase("oldApkMd5")) {
            this.uJi = ((cgw)localObject).value;
          } else if (((cgw)localObject).key.equalsIgnoreCase("versionCode")) {
            this.versionCode = bt.aRe(((cgw)localObject).value);
          } else if (((cgw)localObject).key.equalsIgnoreCase("clientVersion")) {
            this.clientVersion = ((cgw)localObject).value;
          } else if (((cgw)localObject).key.equalsIgnoreCase("alphaTitle")) {
            this.uJj = anq(((cgw)localObject).value);
          } else if (((cgw)localObject).key.equalsIgnoreCase("alphaContent")) {
            this.uJk = anq(((cgw)localObject).value);
          } else if (((cgw)localObject).key.equalsIgnoreCase("alphaUrl")) {
            this.uJl = ((cgw)localObject).value;
          }
        }
      }
      AppMethodBeat.o(32708);
      return;
    }
    this.uJh = "";
    this.uJi = "";
    this.versionCode = 0;
    this.clientVersion = "";
    this.uJj = "";
    this.uJk = "";
    this.uJl = "";
    AppMethodBeat.o(32708);
  }
  
  public static boolean anp(String paramString)
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
  
  private static String anq(String paramString)
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
  
  public final String fiE()
  {
    AppMethodBeat.i(32709);
    Object localObject = this.gHx.substring(0, this.gHx.lastIndexOf('/') + 1);
    String str = this.gHx.substring(this.gHx.lastIndexOf('/') + 1);
    localObject = new i((String)localObject, this.versionCode);
    ((i)localObject).a(new i.a(this.uJi, this.uJh, this.nUg, str, this.fileSize));
    str = ((i)localObject).Lt();
    AppMethodBeat.o(32709);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(32710);
    String str = "responseState:" + this.nUd + "\ncdnUrl:" + this.gHx + "\nfileMd5:" + this.nUg + "\npackageType:" + this.nUe + "\nnetworkType:" + this.nUf + "\npatchId:" + this.nUh;
    AppMethodBeat.o(32710);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.f
 * JD-Core Version:    0.7.0.1
 */