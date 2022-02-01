package com.tencent.mm.wallet_core.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tenpay.ndk.CertUtil;
import com.tenpay.ndk.CertUtil.EventListener;
import com.tenpay.ndk.MessageDigestUtil;

public final class b
{
  private static b YUJ = null;
  static boolean isInit = false;
  private boolean YUK;
  private CertUtil.EventListener YUL;
  
  public b()
  {
    AppMethodBeat.i(72725);
    this.YUK = false;
    this.YUL = new CertUtil.EventListener()
    {
      public final String getUniqueID()
      {
        AppMethodBeat.i(72724);
        String str = q.dR(false);
        if (Util.isNullOrNil(str))
        {
          str = q.auM();
          AppMethodBeat.o(72724);
          return str;
        }
        AppMethodBeat.o(72724);
        return str;
      }
      
      public final void onEvent(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(72723);
        Log.i("MicroMsg.CertUtilWx", "code ret: %s %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        AppMethodBeat.o(72723);
      }
    };
    AppMethodBeat.o(72725);
  }
  
  public static boolean I(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(72734);
    Object localObject1 = "";
    if (paramBoolean)
    {
      localObject1 = new MessageDigestUtil();
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHE();
      Object localObject2 = p.getString(com.tencent.mm.kernel.b.getUin());
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
    Log.d("MicroMsg.CertUtilWx", "setTokens stack v2 useSm4 %s sm4Key %s %s", new Object[] { Boolean.valueOf(paramBoolean), localObject1, Util.getStack().toString() });
    paramBoolean = CertUtil.getInstance().setTokens(paramString1, paramString2, paramBoolean, (String)localObject1);
    Log.d("MicroMsg.CertUtilWx", "setTokens result ret:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(72734);
    return paramBoolean;
  }
  
  public static int bCi(String paramString)
  {
    AppMethodBeat.i(72737);
    int i = CertUtil.getInstance().getTokenCount(paramString);
    Log.d("MicroMsg.CertUtilWx", "getTokenCount ret: %d stack %s", new Object[] { Integer.valueOf(i), Util.getStack().toString() });
    AppMethodBeat.o(72737);
    return i;
  }
  
  public static void clean()
  {
    AppMethodBeat.i(72740);
    Log.d("MicroMsg.CertUtilWx", "clean allcrt stack %s", new Object[] { Util.getStack().toString() });
    CertUtil.getInstance().clearAllCert();
    AppMethodBeat.o(72740);
  }
  
  public static void clearCert(String paramString)
  {
    AppMethodBeat.i(72739);
    Log.d("MicroMsg.CertUtilWx", "clearCert stack %s", new Object[] { Util.getStack().toString() });
    CertUtil.getInstance().clearCert(paramString);
    AppMethodBeat.o(72739);
  }
  
  public static void clearToken(String paramString)
  {
    AppMethodBeat.i(72736);
    Log.d("MicroMsg.CertUtilWx", "clearToken stack %s", new Object[] { Util.getStack().toString() });
    CertUtil.getInstance().clearToken(paramString);
    AppMethodBeat.o(72736);
  }
  
  public static String genUserSig(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72733);
    Log.d("MicroMsg.CertUtilWx", "genUserSig stack %s", new Object[] { Util.getStack().toString() });
    paramString1 = CertUtil.getInstance().genUserSig(paramString1, paramString2);
    AppMethodBeat.o(72733);
    return paramString1;
  }
  
  public static String genUserSig(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(72732);
    Log.d("MicroMsg.CertUtilWx", "genUserSig stack %s", new Object[] { Util.getStack().toString() });
    paramString = CertUtil.getInstance().genUserSig(paramString, paramArrayOfByte);
    AppMethodBeat.o(72732);
    return paramString;
  }
  
  public static int getLastError()
  {
    AppMethodBeat.i(72738);
    Log.d("MicroMsg.CertUtilWx", "getLastError stack %s", new Object[] { Util.getStack().toString() });
    int i = CertUtil.getInstance().getLastError();
    AppMethodBeat.o(72738);
    return i;
  }
  
  public static String getToken(String paramString)
  {
    AppMethodBeat.i(72735);
    Log.d("MicroMsg.CertUtilWx", "getToken stack %s", new Object[] { Util.getStack().toString() });
    paramString = CertUtil.getInstance().getToken(paramString);
    AppMethodBeat.o(72735);
    return paramString;
  }
  
  public static b iiL()
  {
    AppMethodBeat.i(72726);
    if (YUJ == null) {
      YUJ = new b();
    }
    b localb = YUJ;
    AppMethodBeat.o(72726);
    return localb;
  }
  
  public static boolean isCertExist(String paramString)
  {
    AppMethodBeat.i(72731);
    Log.d("MicroMsg.CertUtilWx", "isCertExist stack %s", new Object[] { Util.getStack().toString() });
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(414L, 5L, 1L, true);
    boolean bool = CertUtil.getInstance().isCertExist(paramString);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(414L, 6L, 1L, true);
    AppMethodBeat.o(72731);
    return bool;
  }
  
  public final String ia(String paramString, int paramInt)
  {
    AppMethodBeat.i(72728);
    Log.i("MicroMsg.CertUtilWx", "getCertApplyCSR lock %s %s", new Object[] { Util.getStack().toString(), Integer.valueOf(paramInt) });
    try
    {
      if (this.YUK)
      {
        Log.i("MicroMsg.CertUtilWx", "isCert_Wating");
        return "";
      }
      this.YUK = true;
      paramString = CertUtil.getInstance().getCertApplyCSR(paramString, paramInt);
      return paramString;
    }
    finally
    {
      AppMethodBeat.o(72728);
    }
  }
  
  public final boolean iiM()
  {
    AppMethodBeat.i(72730);
    Log.d("MicroMsg.CertUtilWx", "importCertNone");
    try
    {
      this.YUK = false;
      return false;
    }
    finally
    {
      AppMethodBeat.o(72730);
    }
  }
  
  public final boolean importCert(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72729);
    Log.i("MicroMsg.CertUtilWx", "importCert  cid %s cert %s stack %s", new Object[] { paramString1, paramString2, Util.getStack().toString() });
    try
    {
      this.YUK = false;
      boolean bool = CertUtil.getInstance().importCert(paramString1, paramString2);
      Log.i("MicroMsg.CertUtilWx", "importCert %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(72729);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(72729);
    }
  }
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(72727);
    if (isInit)
    {
      AppMethodBeat.o(72727);
      return;
    }
    Log.d("MicroMsg.CertUtilWx", "init  %s", new Object[] { Util.getStack().toString() });
    CertUtil.getInstance().init(paramContext, this.YUL);
    isInit = true;
    AppMethodBeat.o(72727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.b
 * JD-Core Version:    0.7.0.1
 */