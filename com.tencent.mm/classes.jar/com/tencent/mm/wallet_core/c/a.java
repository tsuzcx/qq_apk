package com.tencent.mm.wallet_core.c;

import android.content.Context;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tenpay.ndk.CertUtil;
import com.tenpay.ndk.MessageDigestUtil;

public final class a
{
  static boolean dBn = false;
  private static a wAf = null;
  private boolean wAg = false;
  
  public static int afd(String paramString)
  {
    int i = CertUtil.getInstance().getTokenCount(paramString);
    y.d("MicroMsg.CertUtilWx", "getTokenCount ret: %d stack %s", new Object[] { Integer.valueOf(i), bk.csb().toString() });
    return i;
  }
  
  public static a cMr()
  {
    if (wAf == null) {
      wAf = new a();
    }
    return wAf;
  }
  
  public static void clean()
  {
    y.d("MicroMsg.CertUtilWx", "clean allcrt stack %s", new Object[] { bk.csb().toString() });
    CertUtil.getInstance().clearAllCert();
  }
  
  public static void clearCert(String paramString)
  {
    y.d("MicroMsg.CertUtilWx", "clearCert stack %s", new Object[] { bk.csb().toString() });
    CertUtil.getInstance().clearCert(paramString);
  }
  
  public static void clearToken(String paramString)
  {
    y.d("MicroMsg.CertUtilWx", "clearToken stack %s", new Object[] { bk.csb().toString() });
    CertUtil.getInstance().clearToken(paramString);
  }
  
  public static String genUserSig(String paramString1, String paramString2)
  {
    y.d("MicroMsg.CertUtilWx", "genUserSig stack %s", new Object[] { bk.csb().toString() });
    return CertUtil.getInstance().genUserSig(paramString1, paramString2);
  }
  
  public static int getLastError()
  {
    y.d("MicroMsg.CertUtilWx", "getLastError stack %s", new Object[] { bk.csb().toString() });
    return CertUtil.getInstance().getLastError();
  }
  
  public static String getToken(String paramString)
  {
    y.d("MicroMsg.CertUtilWx", "getToken stack %s", new Object[] { bk.csb().toString() });
    return CertUtil.getInstance().getToken(paramString);
  }
  
  public static void init(Context paramContext)
  {
    if (dBn) {
      return;
    }
    y.d("MicroMsg.CertUtilWx", "init  %s", new Object[] { bk.csb().toString() });
    CertUtil.getInstance().init(paramContext);
    dBn = true;
  }
  
  public static boolean isCertExist(String paramString)
  {
    y.d("MicroMsg.CertUtilWx", "isCertExist stack %s", new Object[] { bk.csb().toString() });
    h.nFQ.a(414L, 5L, 1L, true);
    boolean bool = CertUtil.getInstance().isCertExist(paramString);
    h.nFQ.a(414L, 6L, 1L, true);
    return bool;
  }
  
  public static boolean z(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = "";
    if (paramBoolean)
    {
      localObject1 = new MessageDigestUtil();
      g.DQ();
      g.DN();
      Object localObject2 = o.getString(com.tencent.mm.kernel.a.CK());
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
    y.d("MicroMsg.CertUtilWx", "setTokens stack v2 useSm4 %s sm4Key %s %s", new Object[] { Boolean.valueOf(paramBoolean), localObject1, bk.csb().toString() });
    paramBoolean = CertUtil.getInstance().setTokens(paramString1, paramString2, paramBoolean, (String)localObject1);
    y.d("MicroMsg.CertUtilWx", "setTokens result ret:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    return paramBoolean;
  }
  
  public final boolean cMs()
  {
    y.d("MicroMsg.CertUtilWx", "importCertNone");
    try
    {
      this.wAg = false;
      return false;
    }
    finally {}
  }
  
  public final String dO(String paramString, int paramInt)
  {
    y.d("MicroMsg.CertUtilWx", "getCertApplyCSR lock %s %s", new Object[] { bk.csb().toString(), Integer.valueOf(paramInt) });
    try
    {
      if (this.wAg)
      {
        y.i("MicroMsg.CertUtilWx", "isCert_Wating");
        return "";
      }
      this.wAg = true;
      paramString = CertUtil.getInstance().getCertApplyCSR(paramString, paramInt);
      return paramString;
    }
    finally {}
  }
  
  public final boolean importCert(String paramString1, String paramString2)
  {
    y.d("MicroMsg.CertUtilWx", "importCert  cid %s cert %s stack %s", new Object[] { paramString1, paramString2, bk.csb().toString() });
    try
    {
      this.wAg = false;
      boolean bool = CertUtil.getInstance().importCert(paramString1, paramString2);
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.a
 * JD-Core Version:    0.7.0.1
 */