package com.tenpay.ndk;

import android.content.Context;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.f;
import java.io.File;
import java.security.MessageDigest;

public class CertUtil
{
  public static final String TAG;
  private static CertUtil instance;
  private String cert_dir;
  private String cert_id = null;
  private byte[] certid_buf = null;
  private byte[] cipher_buf = null;
  private byte[] csr_buf = null;
  private String deskey = null;
  private CertUtil.EventListener eventListener = null;
  private String iccid = null;
  private String imei = null;
  private String imsi = null;
  private String login_ip = null;
  private Context mContext = null;
  private String mac = null;
  private String plain_buf = null;
  private byte[] plain_buf2 = null;
  private String priv_dir;
  private String publ_dir;
  private String qq_id = null;
  private byte[] sig_buf = null;
  private String sig_raw_buf = null;
  private String sm4Key = null;
  private String softid = null;
  private String svr_cert = null;
  private String token = null;
  private byte[] token_buf = null;
  private String token_dir;
  private int token_len = 0;
  private int useSM4 = 0;
  
  static
  {
    AppMethodBeat.i(49565);
    TAG = CertUtil.class.getSimpleName();
    instance = null;
    AppMethodBeat.o(49565);
  }
  
  private void checkDir(String paramString)
  {
    AppMethodBeat.i(49544);
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      paramString.mkdirs();
      AppMethodBeat.o(49544);
      return;
    }
    if (!paramString.isDirectory())
    {
      paramString.delete();
      paramString.mkdirs();
    }
    AppMethodBeat.o(49544);
  }
  
  private boolean create_dir(String paramString)
  {
    AppMethodBeat.i(49545);
    for (;;)
    {
      try
      {
        paramString = new File(paramString);
        if (paramString.exists()) {
          continue;
        }
        boolean bool2 = paramString.mkdirs();
        bool1 = bool2;
        if (bool2) {}
      }
      catch (Exception paramString)
      {
        boolean bool1 = false;
        continue;
      }
      AppMethodBeat.o(49545);
      return bool1;
      bool1 = true;
    }
  }
  
  private boolean del_all_files(String paramString)
  {
    AppMethodBeat.i(49546);
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      AppMethodBeat.o(49546);
      return false;
    }
    if (!localFile.isDirectory())
    {
      AppMethodBeat.o(49546);
      return false;
    }
    String[] arrayOfString = localFile.list();
    int i = 0;
    boolean bool = false;
    if (i < arrayOfString.length) {
      if (paramString.endsWith(File.separator))
      {
        localFile = new File(paramString + arrayOfString[i]);
        label103:
        if (!localFile.isFile()) {
          break label163;
        }
        localFile.delete();
      }
    }
    for (;;)
    {
      i += 1;
      break;
      localFile = new File(paramString + File.separator + arrayOfString[i]);
      break label103;
      label163:
      if (localFile.isDirectory())
      {
        del_all_files(paramString + File.separator + arrayOfString[i]);
        del_dir(paramString + File.separator + arrayOfString[i], true);
        bool = true;
        continue;
        AppMethodBeat.o(49546);
        return bool;
      }
    }
  }
  
  private void del_dir(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(49547);
    try
    {
      del_all_files(paramString);
      if (paramBoolean) {
        new File(paramString.toString()).delete();
      }
      AppMethodBeat.o(49547);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(49547);
    }
  }
  
  private native boolean encrypt();
  
  private native boolean genCertApplyCsr();
  
  private native boolean genCertApplyCsrNew(int paramInt);
  
  private native boolean genQrcode();
  
  private String getCertDir()
  {
    AppMethodBeat.i(49541);
    String str = this.mContext.getFilesDir().getParentFile().getAbsolutePath() + "/cert";
    AppMethodBeat.o(49541);
    return str;
  }
  
  private native boolean getCertid();
  
  public static CertUtil getInstance()
  {
    AppMethodBeat.i(49539);
    if (instance == null) {}
    try
    {
      instance = new CertUtil();
      CertUtil localCertUtil = instance;
      AppMethodBeat.o(49539);
      return localCertUtil;
    }
    finally
    {
      AppMethodBeat.o(49539);
    }
  }
  
  private native boolean getToken();
  
  private native int getTokenCount();
  
  private String hexdigest(String paramString)
  {
    AppMethodBeat.i(49550);
    if (paramString == null)
    {
      AppMethodBeat.o(49550);
      return "";
    }
    char[] arrayOfChar = new char[16];
    char[] tmp25_23 = arrayOfChar;
    tmp25_23[0] = 48;
    char[] tmp30_25 = tmp25_23;
    tmp30_25[1] = 49;
    char[] tmp35_30 = tmp30_25;
    tmp35_30[2] = 50;
    char[] tmp40_35 = tmp35_30;
    tmp40_35[3] = 51;
    char[] tmp45_40 = tmp40_35;
    tmp45_40[4] = 52;
    char[] tmp50_45 = tmp45_40;
    tmp50_45[5] = 53;
    char[] tmp55_50 = tmp50_45;
    tmp55_50[6] = 54;
    char[] tmp61_55 = tmp55_50;
    tmp61_55[7] = 55;
    char[] tmp67_61 = tmp61_55;
    tmp67_61[8] = 56;
    char[] tmp73_67 = tmp67_61;
    tmp73_67[9] = 57;
    char[] tmp79_73 = tmp73_67;
    tmp79_73[10] = 65;
    char[] tmp85_79 = tmp79_73;
    tmp85_79[11] = 66;
    char[] tmp91_85 = tmp85_79;
    tmp91_85[12] = 67;
    char[] tmp97_91 = tmp91_85;
    tmp97_91[13] = 68;
    char[] tmp103_97 = tmp97_91;
    tmp103_97[14] = 69;
    char[] tmp109_103 = tmp103_97;
    tmp109_103[15] = 70;
    tmp109_103;
    for (;;)
    {
      Object localObject;
      int i;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString.getBytes());
        paramString = ((MessageDigest)localObject).digest();
        localObject = new char[32];
        i = 0;
        j = 0;
      }
      catch (Exception paramString)
      {
        paramString = null;
        continue;
      }
      paramString = new String((char[])localObject);
      AppMethodBeat.o(49550);
      return paramString;
      while (i < 16)
      {
        int m = paramString[i];
        int k = j + 1;
        localObject[j] = arrayOfChar[(m >>> 4 & 0xF)];
        localObject[k] = arrayOfChar[(m & 0xF)];
        i += 1;
        j = k + 1;
      }
    }
  }
  
  private native boolean importCert();
  
  private native boolean isCertExist();
  
  private boolean isNotEmptyDir(String paramString)
  {
    AppMethodBeat.i(49548);
    boolean bool = true;
    paramString = new File(paramString);
    if ((!paramString.exists()) || (!paramString.isDirectory()) || (paramString.listFiles() == null)) {
      bool = false;
    }
    AppMethodBeat.o(49548);
    return bool;
  }
  
  private boolean isNullOrEmpty(String paramString)
  {
    AppMethodBeat.i(49551);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(49551);
      return true;
    }
    AppMethodBeat.o(49551);
    return false;
  }
  
  private boolean isValidDir(String paramString)
  {
    AppMethodBeat.i(49549);
    boolean bool = true;
    paramString = new File(paramString);
    if ((!paramString.exists()) || (!paramString.isDirectory())) {
      bool = false;
    }
    AppMethodBeat.o(49549);
    return bool;
  }
  
  private void onNativeEvent(int paramInt, String paramString)
  {
    AppMethodBeat.i(142687);
    if (this.eventListener != null) {
      this.eventListener.onEvent(paramInt, paramString);
    }
    AppMethodBeat.o(142687);
  }
  
  private void setAndCheckDir(String paramString)
  {
    AppMethodBeat.i(49542);
    String str = getCertDir();
    paramString = str + "/" + hexdigest(new StringBuilder().append(paramString).append(this.imei).toString());
    this.cert_dir = (paramString + "/cert");
    this.priv_dir = (paramString + "/priv");
    this.publ_dir = (paramString + "/publ");
    this.token_dir = (paramString + "/auth");
    checkDir(str);
    checkDir(this.token_dir);
    AppMethodBeat.o(49542);
  }
  
  private void setDir(String paramString)
  {
    AppMethodBeat.i(49543);
    paramString = getCertDir() + "/" + hexdigest(new StringBuilder().append(paramString).append(this.imei).toString());
    this.cert_dir = (paramString + "/cert");
    this.priv_dir = (paramString + "/priv");
    this.publ_dir = (paramString + "/publ");
    this.token_dir = (paramString + "/auth");
    AppMethodBeat.o(49543);
  }
  
  private native boolean setToken();
  
  private native boolean usrSig(byte[] paramArrayOfByte);
  
  public void clearAllCert()
  {
    try
    {
      AppMethodBeat.i(49556);
      del_dir(getCertDir(), true);
      AppMethodBeat.o(49556);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void clearCert(String paramString)
  {
    try
    {
      AppMethodBeat.i(49557);
      del_dir(getCertDir() + "/" + hexdigest(new StringBuilder().append(paramString).append(this.imei).toString()), true);
      AppMethodBeat.o(49557);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public void clearToken(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 303
    //   5: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: invokespecial 305	com/tenpay/ndk/CertUtil:isNullOrEmpty	(Ljava/lang/String;)Z
    //   13: ifeq +12 -> 25
    //   16: ldc_w 303
    //   19: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial 307	com/tenpay/ndk/CertUtil:setDir	(Ljava/lang/String;)V
    //   30: aload_0
    //   31: aload_0
    //   32: getfield 290	com/tenpay/ndk/CertUtil:token_dir	Ljava/lang/String;
    //   35: iconst_1
    //   36: invokespecial 174	com/tenpay/ndk/CertUtil:del_dir	(Ljava/lang/String;Z)V
    //   39: ldc_w 303
    //   42: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: goto -23 -> 22
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	CertUtil
    //   0	53	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	22	48	finally
    //   25	45	48	finally
  }
  
  public String encrypt(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(49558);
        if ((isNullOrEmpty(paramString1)) || (isNullOrEmpty(paramString2)))
        {
          AppMethodBeat.o(49558);
          paramString1 = localObject1;
          return paramString1;
        }
        setAndCheckDir(paramString1);
        if ((!isNotEmptyDir(this.cert_dir)) || (!isNotEmptyDir(this.publ_dir)) || (!isNotEmptyDir(this.priv_dir)))
        {
          AppMethodBeat.o(49558);
          paramString1 = localObject1;
          continue;
        }
        this.cert_id = paramString1;
      }
      finally {}
      this.plain_buf = paramString2;
      this.cipher_buf = null;
      paramString1 = localObject2;
      if (encrypt())
      {
        paramString2 = this.cipher_buf;
        paramString1 = localObject2;
        if (paramString2 == null) {}
      }
      try
      {
        paramString1 = new String(this.cipher_buf, "UTF-8");
        AppMethodBeat.o(49558);
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(49558);
        paramString1 = localObject1;
      }
    }
  }
  
  public byte[] genQrcode(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(49560);
        if ((isNullOrEmpty(paramString1)) || (isNullOrEmpty(paramString2)) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          AppMethodBeat.o(49560);
          paramString1 = localObject1;
          return paramString1;
        }
        setAndCheckDir(paramString1);
        if ((!isNotEmptyDir(this.cert_dir)) || (!isNotEmptyDir(this.publ_dir)) || (!isNotEmptyDir(this.priv_dir)))
        {
          AppMethodBeat.o(49560);
          paramString1 = localObject1;
          continue;
        }
        this.cert_id = paramString1;
      }
      finally {}
      this.plain_buf2 = paramArrayOfByte;
      this.cipher_buf = null;
      this.token = paramString2;
      paramString1 = localObject2;
      if (genQrcode())
      {
        paramArrayOfByte = this.cipher_buf;
        paramString1 = localObject2;
        if (paramArrayOfByte == null) {}
      }
      try
      {
        paramString1 = this.cipher_buf;
        AppMethodBeat.o(49560);
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(49560);
        paramString1 = localObject1;
      }
    }
  }
  
  public String genUserSig(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(49559);
        if ((isNullOrEmpty(paramString1)) || (isNullOrEmpty(paramString2)))
        {
          AppMethodBeat.o(49559);
          paramString1 = localObject1;
          return paramString1;
        }
        setAndCheckDir(paramString1);
        if ((!isNotEmptyDir(this.cert_dir)) || (!isNotEmptyDir(this.publ_dir)) || (!isNotEmptyDir(this.priv_dir)))
        {
          AppMethodBeat.o(49559);
          paramString1 = localObject1;
          continue;
        }
        if (paramString1 == null) {
          break label117;
        }
      }
      finally {}
      if ((paramString2 == null) || (paramString1.length() <= 0) || (paramString2.length() <= 0))
      {
        label117:
        AppMethodBeat.o(49559);
        paramString1 = localObject1;
      }
      else
      {
        this.cert_id = paramString1;
        this.sig_raw_buf = paramString2;
        this.sig_buf = null;
        paramString1 = localObject2;
        if (usrSig(paramString2.getBytes()))
        {
          paramString2 = this.sig_buf;
          paramString1 = localObject2;
          if (paramString2 == null) {}
        }
        try
        {
          paramString1 = new String(this.sig_buf, "UTF-8");
          AppMethodBeat.o(49559);
        }
        catch (Exception paramString1)
        {
          AppMethodBeat.o(49559);
          paramString1 = localObject1;
        }
      }
    }
  }
  
  public String genUserSig(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(155105);
        if ((isNullOrEmpty(paramString)) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          AppMethodBeat.o(155105);
          paramString = localObject1;
          return paramString;
        }
        setAndCheckDir(paramString);
        if ((!isNotEmptyDir(this.cert_dir)) || (!isNotEmptyDir(this.publ_dir)) || (!isNotEmptyDir(this.priv_dir)))
        {
          AppMethodBeat.o(155105);
          paramString = localObject1;
          continue;
        }
        this.cert_id = paramString;
      }
      finally {}
      this.sig_buf = null;
      paramString = localObject2;
      if (usrSig(paramArrayOfByte))
      {
        paramArrayOfByte = this.sig_buf;
        paramString = localObject2;
        if (paramArrayOfByte == null) {}
      }
      try
      {
        paramString = new String(this.sig_buf, "UTF-8");
        AppMethodBeat.o(155105);
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(155105);
        paramString = localObject1;
      }
    }
  }
  
  public String getCertApplyCSR(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    try
    {
      AppMethodBeat.i(49552);
      this.qq_id = paramString;
      this.csr_buf = null;
      paramString = localObject2;
      if (genCertApplyCsr())
      {
        byte[] arrayOfByte = this.csr_buf;
        paramString = localObject2;
        if (arrayOfByte == null) {}
      }
      try
      {
        paramString = new String(this.csr_buf, "ASCII");
        AppMethodBeat.o(49552);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          AppMethodBeat.o(49552);
          paramString = localObject1;
        }
      }
      return paramString;
    }
    finally {}
  }
  
  public String getCertApplyCSR(String paramString, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    try
    {
      AppMethodBeat.i(49553);
      this.qq_id = paramString;
      this.csr_buf = null;
      paramString = localObject2;
      if (genCertApplyCsrNew(paramInt))
      {
        byte[] arrayOfByte = this.csr_buf;
        paramString = localObject2;
        if (arrayOfByte == null) {}
      }
      try
      {
        paramString = new String(this.csr_buf, "ASCII");
        AppMethodBeat.o(49553);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          AppMethodBeat.o(49553);
          paramString = localObject1;
        }
      }
      return paramString;
    }
    finally {}
  }
  
  public native int getLastError();
  
  public String getToken(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(49562);
        if (isNullOrEmpty(paramString))
        {
          AppMethodBeat.o(49562);
          paramString = localObject1;
          return paramString;
        }
        setAndCheckDir(paramString);
        if (!isNotEmptyDir(this.token_dir))
        {
          AppMethodBeat.o(49562);
          paramString = localObject1;
          continue;
        }
        this.cert_id = paramString;
      }
      finally {}
      paramString = localObject2;
      if (getToken())
      {
        byte[] arrayOfByte = this.token_buf;
        paramString = localObject2;
        if (arrayOfByte == null) {}
      }
      try
      {
        paramString = new String(this.token_buf, "UTF-8");
        AppMethodBeat.o(49562);
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(49562);
        paramString = localObject1;
      }
    }
  }
  
  /* Error */
  public int getTokenCount(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 346
    //   5: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: invokespecial 305	com/tenpay/ndk/CertUtil:isNullOrEmpty	(Ljava/lang/String;)Z
    //   13: ifeq +15 -> 28
    //   16: iconst_0
    //   17: istore_2
    //   18: ldc_w 346
    //   21: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_2
    //   27: ireturn
    //   28: aload_0
    //   29: aload_1
    //   30: invokespecial 307	com/tenpay/ndk/CertUtil:setDir	(Ljava/lang/String;)V
    //   33: aload_0
    //   34: aload_1
    //   35: putfield 78	com/tenpay/ndk/CertUtil:cert_id	Ljava/lang/String;
    //   38: aload_0
    //   39: invokespecial 348	com/tenpay/ndk/CertUtil:getTokenCount	()I
    //   42: istore_2
    //   43: ldc_w 346
    //   46: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: goto -25 -> 24
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	CertUtil
    //   0	57	1	paramString	String
    //   17	26	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	16	52	finally
    //   18	24	52	finally
    //   28	49	52	finally
  }
  
  /* Error */
  public boolean importCert(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 350
    //   5: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: invokevirtual 260	java/lang/String:length	()I
    //   12: ifgt +15 -> 27
    //   15: iconst_0
    //   16: istore_3
    //   17: ldc_w 350
    //   20: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_3
    //   26: ireturn
    //   27: aload_0
    //   28: new 152	java/lang/String
    //   31: dup
    //   32: aload_2
    //   33: invokevirtual 237	java/lang/String:getBytes	()[B
    //   36: ldc_w 336
    //   39: invokespecial 320	java/lang/String:<init>	([BLjava/lang/String;)V
    //   42: putfield 76	com/tenpay/ndk/CertUtil:svr_cert	Ljava/lang/String;
    //   45: aload_0
    //   46: aload_1
    //   47: invokevirtual 352	com/tenpay/ndk/CertUtil:clearCert	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: aload_1
    //   52: invokespecial 311	com/tenpay/ndk/CertUtil:setAndCheckDir	(Ljava/lang/String;)V
    //   55: aload_0
    //   56: aload_0
    //   57: getfield 278	com/tenpay/ndk/CertUtil:cert_dir	Ljava/lang/String;
    //   60: invokespecial 354	com/tenpay/ndk/CertUtil:create_dir	(Ljava/lang/String;)Z
    //   63: pop
    //   64: aload_0
    //   65: aload_0
    //   66: getfield 282	com/tenpay/ndk/CertUtil:priv_dir	Ljava/lang/String;
    //   69: invokespecial 354	com/tenpay/ndk/CertUtil:create_dir	(Ljava/lang/String;)Z
    //   72: pop
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 286	com/tenpay/ndk/CertUtil:publ_dir	Ljava/lang/String;
    //   78: invokespecial 354	com/tenpay/ndk/CertUtil:create_dir	(Ljava/lang/String;)Z
    //   81: pop
    //   82: aload_0
    //   83: invokespecial 356	com/tenpay/ndk/CertUtil:importCert	()Z
    //   86: istore_3
    //   87: ldc_w 350
    //   90: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: goto -70 -> 23
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    //   101: astore_2
    //   102: goto -57 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	CertUtil
    //   0	105	1	paramString1	String
    //   0	105	2	paramString2	String
    //   16	71	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	15	96	finally
    //   17	23	96	finally
    //   27	45	96	finally
    //   45	93	96	finally
    //   27	45	101	java/lang/Exception
  }
  
  public void init(Context paramContext, CertUtil.EventListener paramEventListener)
  {
    AppMethodBeat.i(142686);
    this.eventListener = paramEventListener;
    this.mContext = paramContext.getApplicationContext();
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (f.IS_FLAVOR_RED) {}
    try
    {
      this.imsi = localTelephonyManager.getSubscriberId();
      this.iccid = localTelephonyManager.getSimSerialNumber();
      this.imei = localTelephonyManager.getDeviceId();
      this.softid = Settings.System.getString(paramContext.getContentResolver(), "android_id");
      label74:
      this.deskey = paramEventListener.getUniqueID();
      ab.d(TAG, "init deskey %s imei: %s", new Object[] { this.deskey, this.imei });
      for (;;)
      {
        this.imei = this.deskey;
        AppMethodBeat.o(142686);
        return;
        this.deskey = paramEventListener.getUniqueID();
      }
    }
    catch (Exception paramContext)
    {
      break label74;
    }
  }
  
  public boolean isCertExist(String paramString)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(49555);
        if (isNullOrEmpty(paramString))
        {
          AppMethodBeat.o(49555);
          return bool;
        }
        setDir(paramString);
        if ((isNotEmptyDir(this.cert_dir)) && (isNotEmptyDir(this.publ_dir)) && (isNotEmptyDir(this.priv_dir)))
        {
          this.cert_id = paramString;
          bool = isCertExist();
          AppMethodBeat.o(49555);
        }
        else
        {
          AppMethodBeat.o(49555);
        }
      }
      finally {}
    }
  }
  
  public void setEventListener(CertUtil.EventListener paramEventListener)
  {
    this.eventListener = paramEventListener;
  }
  
  public boolean setTokens(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    int i = 0;
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(49561);
        if ((isNullOrEmpty(paramString1)) || (isNullOrEmpty(paramString2)))
        {
          AppMethodBeat.o(49561);
          paramBoolean = bool;
          return paramBoolean;
        }
        if ((paramBoolean) && ((paramString3 == null) || (paramString3.length() != 16)))
        {
          AppMethodBeat.o(49561);
          paramBoolean = bool;
          continue;
        }
        setAndCheckDir(paramString1);
      }
      finally {}
      if (!isValidDir(this.cert_dir))
      {
        AppMethodBeat.o(49561);
        paramBoolean = bool;
      }
      else
      {
        if (isValidDir(this.token_dir)) {
          break;
        }
        AppMethodBeat.o(49561);
        paramBoolean = bool;
      }
    }
    for (;;)
    {
      this.useSM4 = i;
      this.sm4Key = paramString3;
      this.cert_id = paramString1;
      this.token = paramString2;
      this.token_len = this.token.length();
      paramBoolean = setToken();
      AppMethodBeat.o(49561);
      break;
      if (paramBoolean) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tenpay.ndk.CertUtil
 * JD-Core Version:    0.7.0.1
 */