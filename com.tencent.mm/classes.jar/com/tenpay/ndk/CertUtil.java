package com.tenpay.ndk;

import android.content.Context;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import java.io.File;
import java.security.MessageDigest;

public class CertUtil
{
  public static final String TAG = CertUtil.class.getSimpleName();
  private static CertUtil instance = null;
  private String cert_dir;
  private String cert_id = null;
  private byte[] certid_buf = null;
  private byte[] cipher_buf = null;
  private byte[] csr_buf = null;
  private String deskey = null;
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
  
  private void checkDir(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    while (paramString.isDirectory()) {
      return;
    }
    paramString.delete();
    paramString.mkdirs();
  }
  
  private boolean create_dir(String paramString)
  {
    try
    {
      paramString = new File(paramString);
      if (!paramString.exists())
      {
        boolean bool = paramString.mkdirs();
        if (!bool) {}
        return bool;
      }
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private boolean del_all_files(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {}
    while (!localFile.isDirectory()) {
      return false;
    }
    String[] arrayOfString = localFile.list();
    int i = 0;
    boolean bool = false;
    if (i < arrayOfString.length) {
      if (paramString.endsWith(File.separator))
      {
        localFile = new File(paramString + arrayOfString[i]);
        label86:
        if (!localFile.isFile()) {
          break label146;
        }
        localFile.delete();
      }
    }
    for (;;)
    {
      i += 1;
      break;
      localFile = new File(paramString + File.separator + arrayOfString[i]);
      break label86;
      label146:
      if (localFile.isDirectory())
      {
        del_all_files(paramString + File.separator + arrayOfString[i]);
        del_dir(paramString + File.separator + arrayOfString[i], true);
        bool = true;
        continue;
        return bool;
      }
    }
  }
  
  private void del_dir(String paramString, boolean paramBoolean)
  {
    try
    {
      del_all_files(paramString);
      if (paramBoolean) {
        new File(paramString.toString()).delete();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  private native boolean encrypt();
  
  private native boolean genCertApplyCsr();
  
  private native boolean genCertApplyCsrNew(int paramInt);
  
  private native boolean genQrcode();
  
  private String getCertDir()
  {
    return this.mContext.getFilesDir().getParentFile().getAbsolutePath() + "/cert";
  }
  
  private native boolean getCertid();
  
  public static CertUtil getInstance()
  {
    if (instance == null) {}
    try
    {
      instance = new CertUtil();
      return instance;
    }
    finally {}
  }
  
  private native boolean getToken();
  
  private native int getTokenCount();
  
  private String hexdigest(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    char[] arrayOfChar = new char[16];
    char[] tmp15_13 = arrayOfChar;
    tmp15_13[0] = 48;
    char[] tmp20_15 = tmp15_13;
    tmp20_15[1] = 49;
    char[] tmp25_20 = tmp20_15;
    tmp25_20[2] = 50;
    char[] tmp30_25 = tmp25_20;
    tmp30_25[3] = 51;
    char[] tmp35_30 = tmp30_25;
    tmp35_30[4] = 52;
    char[] tmp40_35 = tmp35_30;
    tmp40_35[5] = 53;
    char[] tmp45_40 = tmp40_35;
    tmp45_40[6] = 54;
    char[] tmp51_45 = tmp45_40;
    tmp51_45[7] = 55;
    char[] tmp57_51 = tmp51_45;
    tmp57_51[8] = 56;
    char[] tmp63_57 = tmp57_51;
    tmp63_57[9] = 57;
    char[] tmp69_63 = tmp63_57;
    tmp69_63[10] = 65;
    char[] tmp75_69 = tmp69_63;
    tmp75_69[11] = 66;
    char[] tmp81_75 = tmp75_69;
    tmp81_75[12] = 67;
    char[] tmp87_81 = tmp81_75;
    tmp87_81[13] = 68;
    char[] tmp93_87 = tmp87_81;
    tmp93_87[14] = 69;
    char[] tmp99_93 = tmp93_87;
    tmp99_93[15] = 70;
    tmp99_93;
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
        return null;
      }
      paramString = new String((char[])localObject);
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
    boolean bool = true;
    paramString = new File(paramString);
    if ((!paramString.exists()) || (!paramString.isDirectory()) || (paramString.listFiles() == null)) {
      bool = false;
    }
    return bool;
  }
  
  private boolean isNullOrEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  private boolean isValidDir(String paramString)
  {
    boolean bool = true;
    paramString = new File(paramString);
    if ((!paramString.exists()) || (!paramString.isDirectory())) {
      bool = false;
    }
    return bool;
  }
  
  private void setAndCheckDir(String paramString)
  {
    String str = getCertDir();
    paramString = str + "/" + hexdigest(new StringBuilder().append(paramString).append(this.imei).toString());
    this.cert_dir = (paramString + "/cert");
    this.priv_dir = (paramString + "/priv");
    this.publ_dir = (paramString + "/publ");
    this.token_dir = (paramString + "/auth");
    checkDir(str);
    checkDir(this.token_dir);
  }
  
  private void setDir(String paramString)
  {
    paramString = getCertDir() + "/" + hexdigest(new StringBuilder().append(paramString).append(this.imei).toString());
    this.cert_dir = (paramString + "/cert");
    this.priv_dir = (paramString + "/priv");
    this.publ_dir = (paramString + "/publ");
    this.token_dir = (paramString + "/auth");
  }
  
  private native boolean setToken();
  
  private native boolean usrSig();
  
  public void clearAllCert()
  {
    try
    {
      del_dir(getCertDir(), true);
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
      del_dir(getCertDir() + "/" + hexdigest(new StringBuilder().append(paramString).append(this.imei).toString()), true);
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
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 267	com/tenpay/ndk/CertUtil:isNullOrEmpty	(Ljava/lang/String;)Z
    //   7: istore_2
    //   8: iload_2
    //   9: ifeq +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: aload_1
    //   17: invokespecial 269	com/tenpay/ndk/CertUtil:setDir	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: aload_0
    //   22: getfield 257	com/tenpay/ndk/CertUtil:token_dir	Ljava/lang/String;
    //   25: iconst_1
    //   26: invokespecial 155	com/tenpay/ndk/CertUtil:del_dir	(Ljava/lang/String;Z)V
    //   29: goto -17 -> 12
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	CertUtil
    //   0	37	1	paramString	String
    //   7	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	32	finally
    //   15	29	32	finally
  }
  
  public String encrypt(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    label36:
    do
    {
      do
      {
        do
        {
          do
          {
            try
            {
              if (!isNullOrEmpty(paramString1))
              {
                boolean bool = isNullOrEmpty(paramString2);
                if (!bool) {
                  break label36;
                }
                localObject1 = localObject2;
              }
            }
            finally
            {
              try
              {
                paramString1 = new String(this.cipher_buf, "UTF-8");
                localObject1 = paramString1;
              }
              catch (Exception paramString1)
              {
                localObject1 = localObject2;
              }
              paramString1 = finally;
            }
            return localObject1;
            setAndCheckDir(paramString1);
            localObject1 = localObject2;
          } while (!isNotEmptyDir(this.cert_dir));
          localObject1 = localObject2;
        } while (!isNotEmptyDir(this.publ_dir));
        localObject1 = localObject2;
      } while (!isNotEmptyDir(this.priv_dir));
      this.cert_id = paramString1;
      this.plain_buf = paramString2;
      this.cipher_buf = null;
      if (!encrypt()) {
        break label151;
      }
      paramString1 = this.cipher_buf;
    } while (paramString1 != null);
    for (;;)
    {
      label151:
      paramString1 = null;
    }
  }
  
  /* Error */
  public byte[] genQrcode(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload 6
    //   7: astore 5
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 267	com/tenpay/ndk/CertUtil:isNullOrEmpty	(Ljava/lang/String;)Z
    //   14: ifne +36 -> 50
    //   17: aload 6
    //   19: astore 5
    //   21: aload_0
    //   22: aload_3
    //   23: invokespecial 267	com/tenpay/ndk/CertUtil:isNullOrEmpty	(Ljava/lang/String;)Z
    //   26: ifne +24 -> 50
    //   29: aload 6
    //   31: astore 5
    //   33: aload_2
    //   34: ifnull +16 -> 50
    //   37: aload_2
    //   38: arraylength
    //   39: istore 4
    //   41: iload 4
    //   43: ifne +12 -> 55
    //   46: aload 6
    //   48: astore 5
    //   50: aload_0
    //   51: monitorexit
    //   52: aload 5
    //   54: areturn
    //   55: aload_0
    //   56: aload_1
    //   57: invokespecial 272	com/tenpay/ndk/CertUtil:setAndCheckDir	(Ljava/lang/String;)V
    //   60: aload 6
    //   62: astore 5
    //   64: aload_0
    //   65: aload_0
    //   66: getfield 245	com/tenpay/ndk/CertUtil:cert_dir	Ljava/lang/String;
    //   69: invokespecial 274	com/tenpay/ndk/CertUtil:isNotEmptyDir	(Ljava/lang/String;)Z
    //   72: ifeq -22 -> 50
    //   75: aload 6
    //   77: astore 5
    //   79: aload_0
    //   80: aload_0
    //   81: getfield 253	com/tenpay/ndk/CertUtil:publ_dir	Ljava/lang/String;
    //   84: invokespecial 274	com/tenpay/ndk/CertUtil:isNotEmptyDir	(Ljava/lang/String;)Z
    //   87: ifeq -37 -> 50
    //   90: aload 6
    //   92: astore 5
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 249	com/tenpay/ndk/CertUtil:priv_dir	Ljava/lang/String;
    //   99: invokespecial 274	com/tenpay/ndk/CertUtil:isNotEmptyDir	(Ljava/lang/String;)Z
    //   102: ifeq -52 -> 50
    //   105: aload_0
    //   106: aload_1
    //   107: putfield 62	com/tenpay/ndk/CertUtil:cert_id	Ljava/lang/String;
    //   110: aload_0
    //   111: aload_2
    //   112: putfield 68	com/tenpay/ndk/CertUtil:plain_buf2	[B
    //   115: aload_0
    //   116: aconst_null
    //   117: putfield 80	com/tenpay/ndk/CertUtil:cipher_buf	[B
    //   120: aload_0
    //   121: aload_3
    //   122: putfield 70	com/tenpay/ndk/CertUtil:token	Ljava/lang/String;
    //   125: aload 6
    //   127: astore 5
    //   129: aload_0
    //   130: invokespecial 284	com/tenpay/ndk/CertUtil:genQrcode	()Z
    //   133: ifeq -83 -> 50
    //   136: aload_0
    //   137: getfield 80	com/tenpay/ndk/CertUtil:cipher_buf	[B
    //   140: astore_1
    //   141: aload 6
    //   143: astore 5
    //   145: aload_1
    //   146: ifnull -96 -> 50
    //   149: aload_0
    //   150: getfield 80	com/tenpay/ndk/CertUtil:cipher_buf	[B
    //   153: astore 5
    //   155: goto -105 -> 50
    //   158: astore_1
    //   159: aload 6
    //   161: astore 5
    //   163: goto -113 -> 50
    //   166: astore_1
    //   167: aload_0
    //   168: monitorexit
    //   169: aload_1
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	CertUtil
    //   0	171	1	paramString1	String
    //   0	171	2	paramArrayOfByte	byte[]
    //   0	171	3	paramString2	String
    //   39	3	4	i	int
    //   7	155	5	localObject1	Object
    //   1	159	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   149	155	158	java/lang/Exception
    //   9	17	166	finally
    //   21	29	166	finally
    //   37	41	166	finally
    //   55	60	166	finally
    //   64	75	166	finally
    //   79	90	166	finally
    //   94	125	166	finally
    //   129	141	166	finally
    //   149	155	166	finally
  }
  
  public String genUserSig(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    label36:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    try
                    {
                      if (!isNullOrEmpty(paramString1))
                      {
                        boolean bool = isNullOrEmpty(paramString2);
                        if (!bool) {
                          break label36;
                        }
                        localObject1 = localObject2;
                      }
                    }
                    finally
                    {
                      try
                      {
                        paramString1 = new String(this.sig_buf, "UTF-8");
                        localObject1 = paramString1;
                      }
                      catch (Exception paramString1)
                      {
                        localObject1 = localObject2;
                      }
                      paramString1 = finally;
                    }
                    return localObject1;
                    setAndCheckDir(paramString1);
                    localObject1 = localObject2;
                  } while (!isNotEmptyDir(this.cert_dir));
                  localObject1 = localObject2;
                } while (!isNotEmptyDir(this.publ_dir));
                localObject1 = localObject2;
              } while (!isNotEmptyDir(this.priv_dir));
              localObject1 = localObject2;
            } while (paramString1 == null);
            localObject1 = localObject2;
          } while (paramString2 == null);
          localObject1 = localObject2;
        } while (paramString1.length() <= 0);
        localObject1 = localObject2;
      } while (paramString2.length() <= 0);
      this.cert_id = paramString1;
      this.sig_raw_buf = paramString2;
      this.sig_buf = null;
      if (!usrSig()) {
        break label189;
      }
      paramString1 = this.sig_buf;
    } while (paramString1 != null);
    for (;;)
    {
      label189:
      paramString1 = null;
    }
  }
  
  /* Error */
  public String getCertApplyCSR(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 56	com/tenpay/ndk/CertUtil:qq_id	Ljava/lang/String;
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 76	com/tenpay/ndk/CertUtil:csr_buf	[B
    //   14: aload_0
    //   15: invokespecial 290	com/tenpay/ndk/CertUtil:genCertApplyCsr	()Z
    //   18: ifeq +42 -> 60
    //   21: aload_0
    //   22: getfield 76	com/tenpay/ndk/CertUtil:csr_buf	[B
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +33 -> 60
    //   30: new 133	java/lang/String
    //   33: dup
    //   34: aload_0
    //   35: getfield 76	com/tenpay/ndk/CertUtil:csr_buf	[B
    //   38: ldc_w 292
    //   41: invokespecial 281	java/lang/String:<init>	([BLjava/lang/String;)V
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: areturn
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    //   54: astore_1
    //   55: aload_2
    //   56: astore_1
    //   57: goto -12 -> 45
    //   60: aconst_null
    //   61: astore_1
    //   62: goto -17 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	CertUtil
    //   0	65	1	paramString	String
    //   1	55	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	26	49	finally
    //   30	45	49	finally
    //   30	45	54	java/lang/Exception
  }
  
  /* Error */
  public String getCertApplyCSR(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 56	com/tenpay/ndk/CertUtil:qq_id	Ljava/lang/String;
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 76	com/tenpay/ndk/CertUtil:csr_buf	[B
    //   14: aload_0
    //   15: iload_2
    //   16: invokespecial 295	com/tenpay/ndk/CertUtil:genCertApplyCsrNew	(I)Z
    //   19: ifeq +42 -> 61
    //   22: aload_0
    //   23: getfield 76	com/tenpay/ndk/CertUtil:csr_buf	[B
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +33 -> 61
    //   31: new 133	java/lang/String
    //   34: dup
    //   35: aload_0
    //   36: getfield 76	com/tenpay/ndk/CertUtil:csr_buf	[B
    //   39: ldc_w 292
    //   42: invokespecial 281	java/lang/String:<init>	([BLjava/lang/String;)V
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: areturn
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    //   55: astore_1
    //   56: aload_3
    //   57: astore_1
    //   58: goto -12 -> 46
    //   61: aconst_null
    //   62: astore_1
    //   63: goto -17 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	CertUtil
    //   0	66	1	paramString	String
    //   0	66	2	paramInt	int
    //   1	56	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	27	50	finally
    //   31	46	50	finally
    //   31	46	55	java/lang/Exception
  }
  
  public native int getLastError();
  
  public String getToken(String paramString)
  {
    Object localObject2 = null;
    label22:
    do
    {
      do
      {
        try
        {
          boolean bool = isNullOrEmpty(paramString);
          if (!bool) {
            break label22;
          }
          localObject1 = localObject2;
        }
        finally
        {
          try
          {
            paramString = new String(this.token_buf, "UTF-8");
            localObject1 = paramString;
          }
          catch (Exception paramString)
          {
            Object localObject1 = localObject2;
          }
          paramString = finally;
        }
        return localObject1;
        setAndCheckDir(paramString);
        localObject1 = localObject2;
      } while (!isNotEmptyDir(this.token_dir));
      this.cert_id = paramString;
      if (!getToken()) {
        break label94;
      }
      paramString = this.token_buf;
    } while (paramString != null);
    for (;;)
    {
      label94:
      paramString = null;
    }
  }
  
  /* Error */
  public int getTokenCount(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 267	com/tenpay/ndk/CertUtil:isNullOrEmpty	(Ljava/lang/String;)Z
    //   7: istore_3
    //   8: iload_3
    //   9: ifeq +9 -> 18
    //   12: iconst_0
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 269	com/tenpay/ndk/CertUtil:setDir	(Ljava/lang/String;)V
    //   23: aload_0
    //   24: aload_1
    //   25: putfield 62	com/tenpay/ndk/CertUtil:cert_id	Ljava/lang/String;
    //   28: aload_0
    //   29: invokespecial 301	com/tenpay/ndk/CertUtil:getTokenCount	()I
    //   32: istore_2
    //   33: goto -19 -> 14
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	CertUtil
    //   0	41	1	paramString	String
    //   13	20	2	i	int
    //   7	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	36	finally
    //   18	33	36	finally
  }
  
  /* Error */
  public boolean importCert(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: invokevirtual 235	java/lang/String:length	()I
    //   6: istore_3
    //   7: iload_3
    //   8: ifgt +11 -> 19
    //   11: iconst_0
    //   12: istore 4
    //   14: aload_0
    //   15: monitorexit
    //   16: iload 4
    //   18: ireturn
    //   19: aload_0
    //   20: new 133	java/lang/String
    //   23: dup
    //   24: aload_2
    //   25: invokevirtual 214	java/lang/String:getBytes	()[B
    //   28: ldc_w 292
    //   31: invokespecial 281	java/lang/String:<init>	([BLjava/lang/String;)V
    //   34: putfield 60	com/tenpay/ndk/CertUtil:svr_cert	Ljava/lang/String;
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 304	com/tenpay/ndk/CertUtil:clearCert	(Ljava/lang/String;)V
    //   42: aload_0
    //   43: aload_1
    //   44: invokespecial 272	com/tenpay/ndk/CertUtil:setAndCheckDir	(Ljava/lang/String;)V
    //   47: aload_0
    //   48: aload_0
    //   49: getfield 245	com/tenpay/ndk/CertUtil:cert_dir	Ljava/lang/String;
    //   52: invokespecial 306	com/tenpay/ndk/CertUtil:create_dir	(Ljava/lang/String;)Z
    //   55: pop
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 249	com/tenpay/ndk/CertUtil:priv_dir	Ljava/lang/String;
    //   61: invokespecial 306	com/tenpay/ndk/CertUtil:create_dir	(Ljava/lang/String;)Z
    //   64: pop
    //   65: aload_0
    //   66: aload_0
    //   67: getfield 253	com/tenpay/ndk/CertUtil:publ_dir	Ljava/lang/String;
    //   70: invokespecial 306	com/tenpay/ndk/CertUtil:create_dir	(Ljava/lang/String;)Z
    //   73: pop
    //   74: aload_0
    //   75: invokespecial 308	com/tenpay/ndk/CertUtil:importCert	()Z
    //   78: istore 4
    //   80: goto -66 -> 14
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    //   88: astore_2
    //   89: goto -52 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	CertUtil
    //   0	92	1	paramString1	String
    //   0	92	2	paramString2	String
    //   6	2	3	i	int
    //   12	67	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	83	finally
    //   19	37	83	finally
    //   37	80	83	finally
    //   19	37	88	java/lang/Exception
  }
  
  public void init(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    try
    {
      this.imsi = localTelephonyManager.getSubscriberId();
      this.iccid = localTelephonyManager.getSimSerialNumber();
      this.imei = localTelephonyManager.getDeviceId();
      this.softid = Settings.System.getString(paramContext.getContentResolver(), "android_id");
      label57:
      this.deskey = this.imei;
      return;
    }
    catch (Exception paramContext)
    {
      break label57;
    }
  }
  
  /* Error */
  public boolean isCertExist(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: invokespecial 267	com/tenpay/ndk/CertUtil:isNullOrEmpty	(Ljava/lang/String;)Z
    //   9: istore_2
    //   10: iload_2
    //   11: ifeq +9 -> 20
    //   14: iload_3
    //   15: istore_2
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_2
    //   19: ireturn
    //   20: aload_0
    //   21: aload_1
    //   22: invokespecial 269	com/tenpay/ndk/CertUtil:setDir	(Ljava/lang/String;)V
    //   25: iload_3
    //   26: istore_2
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 245	com/tenpay/ndk/CertUtil:cert_dir	Ljava/lang/String;
    //   32: invokespecial 274	com/tenpay/ndk/CertUtil:isNotEmptyDir	(Ljava/lang/String;)Z
    //   35: ifeq -19 -> 16
    //   38: iload_3
    //   39: istore_2
    //   40: aload_0
    //   41: aload_0
    //   42: getfield 253	com/tenpay/ndk/CertUtil:publ_dir	Ljava/lang/String;
    //   45: invokespecial 274	com/tenpay/ndk/CertUtil:isNotEmptyDir	(Ljava/lang/String;)Z
    //   48: ifeq -32 -> 16
    //   51: iload_3
    //   52: istore_2
    //   53: aload_0
    //   54: aload_0
    //   55: getfield 249	com/tenpay/ndk/CertUtil:priv_dir	Ljava/lang/String;
    //   58: invokespecial 274	com/tenpay/ndk/CertUtil:isNotEmptyDir	(Ljava/lang/String;)Z
    //   61: ifeq -45 -> 16
    //   64: aload_0
    //   65: aload_1
    //   66: putfield 62	com/tenpay/ndk/CertUtil:cert_id	Ljava/lang/String;
    //   69: aload_0
    //   70: invokespecial 345	com/tenpay/ndk/CertUtil:isCertExist	()Z
    //   73: istore_2
    //   74: goto -58 -> 16
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	CertUtil
    //   0	82	1	paramString	String
    //   9	65	2	bool1	boolean
    //   1	51	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	10	77	finally
    //   20	25	77	finally
    //   27	38	77	finally
    //   40	51	77	finally
    //   53	74	77	finally
  }
  
  /* Error */
  public boolean setTokens(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 7
    //   6: aload_0
    //   7: monitorenter
    //   8: iload 7
    //   10: istore 6
    //   12: aload_0
    //   13: aload_1
    //   14: invokespecial 267	com/tenpay/ndk/CertUtil:isNullOrEmpty	(Ljava/lang/String;)Z
    //   17: ifne +19 -> 36
    //   20: aload_0
    //   21: aload_2
    //   22: invokespecial 267	com/tenpay/ndk/CertUtil:isNullOrEmpty	(Ljava/lang/String;)Z
    //   25: istore 6
    //   27: iload 6
    //   29: ifeq +12 -> 41
    //   32: iload 7
    //   34: istore 6
    //   36: aload_0
    //   37: monitorexit
    //   38: iload 6
    //   40: ireturn
    //   41: iload_3
    //   42: ifeq +22 -> 64
    //   45: aload 4
    //   47: ifnull +17 -> 64
    //   50: iload 7
    //   52: istore 6
    //   54: aload 4
    //   56: invokevirtual 235	java/lang/String:length	()I
    //   59: bipush 16
    //   61: if_icmpne -25 -> 36
    //   64: aload_0
    //   65: aload_1
    //   66: invokespecial 272	com/tenpay/ndk/CertUtil:setAndCheckDir	(Ljava/lang/String;)V
    //   69: iload 7
    //   71: istore 6
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 245	com/tenpay/ndk/CertUtil:cert_dir	Ljava/lang/String;
    //   78: invokespecial 349	com/tenpay/ndk/CertUtil:isValidDir	(Ljava/lang/String;)Z
    //   81: ifeq -45 -> 36
    //   84: iload 7
    //   86: istore 6
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 257	com/tenpay/ndk/CertUtil:token_dir	Ljava/lang/String;
    //   93: invokespecial 349	com/tenpay/ndk/CertUtil:isValidDir	(Ljava/lang/String;)Z
    //   96: ifeq -60 -> 36
    //   99: iload_3
    //   100: ifeq +6 -> 106
    //   103: iconst_1
    //   104: istore 5
    //   106: aload_0
    //   107: iload 5
    //   109: putfield 98	com/tenpay/ndk/CertUtil:useSM4	I
    //   112: aload_0
    //   113: aload 4
    //   115: putfield 96	com/tenpay/ndk/CertUtil:sm4Key	Ljava/lang/String;
    //   118: aload_0
    //   119: aload_1
    //   120: putfield 62	com/tenpay/ndk/CertUtil:cert_id	Ljava/lang/String;
    //   123: aload_0
    //   124: aload_2
    //   125: putfield 70	com/tenpay/ndk/CertUtil:token	Ljava/lang/String;
    //   128: aload_0
    //   129: aload_0
    //   130: getfield 70	com/tenpay/ndk/CertUtil:token	Ljava/lang/String;
    //   133: invokevirtual 235	java/lang/String:length	()I
    //   136: putfield 74	com/tenpay/ndk/CertUtil:token_len	I
    //   139: aload_0
    //   140: invokespecial 351	com/tenpay/ndk/CertUtil:setToken	()Z
    //   143: istore 6
    //   145: goto -109 -> 36
    //   148: astore_1
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	CertUtil
    //   0	153	1	paramString1	String
    //   0	153	2	paramString2	String
    //   0	153	3	paramBoolean	boolean
    //   0	153	4	paramString3	String
    //   1	107	5	i	int
    //   10	134	6	bool1	boolean
    //   4	81	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   12	27	148	finally
    //   54	64	148	finally
    //   64	69	148	finally
    //   73	84	148	finally
    //   88	99	148	finally
    //   106	145	148	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tenpay.ndk.CertUtil
 * JD-Core Version:    0.7.0.1
 */