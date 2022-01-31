package com.tencent.mm.wallet_core.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tenpay.ndk.CertUtil;
import com.tenpay.ndk.CertUtil.EventListener;
import com.tenpay.ndk.MessageDigestUtil;

public final class b
{
  private static b AWF = null;
  static boolean bRB = false;
  private boolean AWG;
  private CertUtil.EventListener AWH;
  
  public b()
  {
    AppMethodBeat.i(142652);
    this.AWG = false;
    this.AWH = new b.1(this);
    AppMethodBeat.o(142652);
  }
  
  public static boolean F(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(49029);
    Object localObject1 = "";
    if (paramBoolean)
    {
      localObject1 = new MessageDigestUtil();
      g.RM();
      g.RJ();
      Object localObject2 = p.getString(a.getUin());
      String str = (String)localObject2 + "_pUI6cNqzLt2Z3mQSrYuF09XSGsBtTIcUgp9jcWZ7F7BBs8/DFVFMKiwbtaRPOiLE";
      localObject2 = new byte[16];
      localObject1 = ((MessageDigestUtil)localObject1).getSHA256Hex(str.getBytes()).getBytes();
      int i = 0;
      while ((i < 16) && (i < localObject1.length))
      {
        localObject2[i] = localObject1[i];
        i += 1;
      }
      localObject1 = new String((byte[])localObject2);
    }
    ab.d("MicroMsg.CertUtilWx", "setTokens stack v2 useSm4 %s sm4Key %s %s", new Object[] { Boolean.valueOf(paramBoolean), localObject1, bo.dtY().toString() });
    paramBoolean = CertUtil.getInstance().setTokens(paramString1, paramString2, paramBoolean, (String)localObject1);
    ab.d("MicroMsg.CertUtilWx", "setTokens result ret:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(49029);
    return paramBoolean;
  }
  
  public static int avW(String paramString)
  {
    AppMethodBeat.i(49032);
    int i = CertUtil.getInstance().getTokenCount(paramString);
    ab.d("MicroMsg.CertUtilWx", "getTokenCount ret: %d stack %s", new Object[] { Integer.valueOf(i), bo.dtY().toString() });
    AppMethodBeat.o(49032);
    return i;
  }
  
  public static void clean()
  {
    AppMethodBeat.i(49035);
    ab.d("MicroMsg.CertUtilWx", "clean allcrt stack %s", new Object[] { bo.dtY().toString() });
    CertUtil.getInstance().clearAllCert();
    AppMethodBeat.o(49035);
  }
  
  public static void clearCert(String paramString)
  {
    AppMethodBeat.i(49034);
    ab.d("MicroMsg.CertUtilWx", "clearCert stack %s", new Object[] { bo.dtY().toString() });
    CertUtil.getInstance().clearCert(paramString);
    AppMethodBeat.o(49034);
  }
  
  public static void clearToken(String paramString)
  {
    AppMethodBeat.i(49031);
    ab.d("MicroMsg.CertUtilWx", "clearToken stack %s", new Object[] { bo.dtY().toString() });
    CertUtil.getInstance().clearToken(paramString);
    AppMethodBeat.o(49031);
  }
  
  public static b dSi()
  {
    AppMethodBeat.i(49022);
    if (AWF == null) {
      AWF = new b();
    }
    b localb = AWF;
    AppMethodBeat.o(49022);
    return localb;
  }
  
  public static String genUserSig(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49028);
    ab.d("MicroMsg.CertUtilWx", "genUserSig stack %s", new Object[] { bo.dtY().toString() });
    paramString1 = CertUtil.getInstance().genUserSig(paramString1, paramString2);
    AppMethodBeat.o(49028);
    return paramString1;
  }
  
  public static String genUserSig(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(155102);
    ab.d("MicroMsg.CertUtilWx", "genUserSig stack %s", new Object[] { bo.dtY().toString() });
    paramString = CertUtil.getInstance().genUserSig(paramString, paramArrayOfByte);
    AppMethodBeat.o(155102);
    return paramString;
  }
  
  public static int getLastError()
  {
    AppMethodBeat.i(49033);
    ab.d("MicroMsg.CertUtilWx", "getLastError stack %s", new Object[] { bo.dtY().toString() });
    int i = CertUtil.getInstance().getLastError();
    AppMethodBeat.o(49033);
    return i;
  }
  
  public static String getToken(String paramString)
  {
    AppMethodBeat.i(49030);
    ab.d("MicroMsg.CertUtilWx", "getToken stack %s", new Object[] { bo.dtY().toString() });
    paramString = CertUtil.getInstance().getToken(paramString);
    AppMethodBeat.o(49030);
    return paramString;
  }
  
  public static boolean isCertExist(String paramString)
  {
    AppMethodBeat.i(49027);
    ab.d("MicroMsg.CertUtilWx", "isCertExist stack %s", new Object[] { bo.dtY().toString() });
    h.qsU.idkeyStat(414L, 5L, 1L, true);
    boolean bool = CertUtil.getInstance().isCertExist(paramString);
    h.qsU.idkeyStat(414L, 6L, 1L, true);
    AppMethodBeat.o(49027);
    return bool;
  }
  
  public final boolean dSj()
  {
    AppMethodBeat.i(49026);
    ab.d("MicroMsg.CertUtilWx", "importCertNone");
    try
    {
      this.AWG = false;
      return false;
    }
    finally
    {
      AppMethodBeat.o(49026);
    }
  }
  
  public final String eY(String paramString, int paramInt)
  {
    AppMethodBeat.i(49024);
    ab.i("MicroMsg.CertUtilWx", "getCertApplyCSR lock %s %s", new Object[] { bo.dtY().toString(), Integer.valueOf(paramInt) });
    try
    {
      if (this.AWG)
      {
        ab.i("MicroMsg.CertUtilWx", "isCert_Wating");
        return "";
      }
      this.AWG = true;
      paramString = CertUtil.getInstance().getCertApplyCSR(paramString, paramInt);
      return paramString;
    }
    finally
    {
      AppMethodBeat.o(49024);
    }
  }
  
  public final boolean importCert(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49025);
    ab.i("MicroMsg.CertUtilWx", "importCert  cid %s cert %s stack %s", new Object[] { paramString1, paramString2, bo.dtY().toString() });
    try
    {
      this.AWG = false;
      boolean bool = CertUtil.getInstance().importCert(paramString1, paramString2);
      ab.i("MicroMsg.CertUtilWx", "importCert %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(49025);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(49025);
    }
  }
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(49023);
    if (bRB)
    {
      AppMethodBeat.o(49023);
      return;
    }
    ab.d("MicroMsg.CertUtilWx", "init  %s", new Object[] { bo.dtY().toString() });
    CertUtil.getInstance().init(paramContext, this.AWH);
    bRB = true;
    AppMethodBeat.o(49023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.b
 * JD-Core Version:    0.7.0.1
 */