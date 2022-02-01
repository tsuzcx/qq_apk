package com.tencent.recovery.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.provider.Settings.Secure;
import com.tencent.recovery.Recovery;
import com.tencent.recovery.log.RecoveryLog;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class Util
{
  private static final String TAG = "Recovery.Util";
  private static String processName = "";
  
  /* Error */
  public static void copyAppendFile(java.io.File paramFile1, int paramInt1, int paramInt2, java.io.File paramFile2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 27	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore 5
    //   12: new 32	java/io/FileOutputStream
    //   15: dup
    //   16: aload_3
    //   17: iconst_1
    //   18: invokespecial 35	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   21: astore_0
    //   22: sipush 1024
    //   25: newarray byte
    //   27: astore_3
    //   28: goto +158 -> 186
    //   31: iload 4
    //   33: ifle +43 -> 76
    //   36: aload 5
    //   38: aload_3
    //   39: iconst_0
    //   40: iload 4
    //   42: invokevirtual 39	java/io/FileInputStream:read	([BII)I
    //   45: istore 4
    //   47: iload 4
    //   49: ifle +27 -> 76
    //   52: aload_0
    //   53: aload_3
    //   54: iconst_0
    //   55: iload 4
    //   57: invokevirtual 43	java/io/FileOutputStream:write	([BII)V
    //   60: iload 4
    //   62: iload_1
    //   63: iadd
    //   64: istore_1
    //   65: goto +121 -> 186
    //   68: sipush 1024
    //   71: istore 4
    //   73: goto -42 -> 31
    //   76: aload 5
    //   78: invokevirtual 46	java/io/FileInputStream:close	()V
    //   81: aload_0
    //   82: invokevirtual 47	java/io/FileOutputStream:close	()V
    //   85: return
    //   86: astore_0
    //   87: aconst_null
    //   88: astore_0
    //   89: aconst_null
    //   90: astore 5
    //   92: aload 5
    //   94: ifnull +8 -> 102
    //   97: aload 5
    //   99: invokevirtual 46	java/io/FileInputStream:close	()V
    //   102: aload_0
    //   103: ifnull -18 -> 85
    //   106: aload_0
    //   107: invokevirtual 47	java/io/FileOutputStream:close	()V
    //   110: return
    //   111: astore_0
    //   112: return
    //   113: astore_0
    //   114: aconst_null
    //   115: astore_3
    //   116: aconst_null
    //   117: astore 5
    //   119: aload 5
    //   121: ifnull +8 -> 129
    //   124: aload 5
    //   126: invokevirtual 46	java/io/FileInputStream:close	()V
    //   129: aload_3
    //   130: ifnull +7 -> 137
    //   133: aload_3
    //   134: invokevirtual 47	java/io/FileOutputStream:close	()V
    //   137: aload_0
    //   138: athrow
    //   139: astore_3
    //   140: goto -59 -> 81
    //   143: astore_0
    //   144: return
    //   145: astore_3
    //   146: goto -44 -> 102
    //   149: astore 5
    //   151: goto -22 -> 129
    //   154: astore_3
    //   155: goto -18 -> 137
    //   158: astore_0
    //   159: aconst_null
    //   160: astore_3
    //   161: goto -42 -> 119
    //   164: astore_3
    //   165: aload_0
    //   166: astore 6
    //   168: aload_3
    //   169: astore_0
    //   170: aload 6
    //   172: astore_3
    //   173: goto -54 -> 119
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_0
    //   179: goto -87 -> 92
    //   182: astore_3
    //   183: goto -91 -> 92
    //   186: iload_1
    //   187: sipush 1024
    //   190: iadd
    //   191: iload_2
    //   192: if_icmple -124 -> 68
    //   195: iload_2
    //   196: iload_1
    //   197: isub
    //   198: istore 4
    //   200: goto -169 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramFile1	java.io.File
    //   0	203	1	paramInt1	int
    //   0	203	2	paramInt2	int
    //   0	203	3	paramFile2	java.io.File
    //   31	168	4	i	int
    //   10	115	5	localFileInputStream	java.io.FileInputStream
    //   149	1	5	localIOException	java.io.IOException
    //   166	5	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   2	12	86	java/lang/Exception
    //   106	110	111	java/io/IOException
    //   2	12	113	finally
    //   76	81	139	java/io/IOException
    //   81	85	143	java/io/IOException
    //   97	102	145	java/io/IOException
    //   124	129	149	java/io/IOException
    //   133	137	154	java/io/IOException
    //   12	22	158	finally
    //   22	28	164	finally
    //   36	47	164	finally
    //   52	60	164	finally
    //   12	22	176	java/lang/Exception
    //   22	28	182	java/lang/Exception
    //   36	47	182	java/lang/Exception
    //   52	60	182	java/lang/Exception
  }
  
  private static final int genUUID(Context paramContext)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
    Object localObject = getLocalMacAddress(paramContext);
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = getLocalBtMacAddress();
    }
    localObject = paramContext;
    if (paramContext == null) {
      localObject = UUID.randomUUID().toString();
    }
    localStringBuffer.append((String)localObject);
    localStringBuffer.append(getHardWareId());
    return ("A" + getMessageDigest(localStringBuffer.toString().getBytes()).substring(0, 15)).hashCode();
  }
  
  private static final String getHardWareId()
  {
    return Build.MANUFACTURER + Build.MODEL;
  }
  
  public static String getLocalBtMacAddress()
  {
    String str = null;
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter != null) {
      str = localBluetoothAdapter.getAddress();
    }
    return str;
  }
  
  public static String getLocalMacAddress(Context paramContext)
  {
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext == null) {}
    for (paramContext = null; paramContext != null; paramContext = paramContext.getConnectionInfo()) {
      return paramContext.getMacAddress();
    }
    return null;
  }
  
  private static final String getMessageDigest(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp8_6 = arrayOfChar;
    tmp8_6[0] = 48;
    char[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 49;
    char[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 50;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 51;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 52;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 53;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 54;
    char[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 55;
    char[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 56;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 57;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 97;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 98;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 99;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 100;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 101;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 102;
    tmp92_86;
    for (;;)
    {
      Object localObject;
      int k;
      int i;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        k = paramArrayOfByte.length;
        localObject = new char[k * 2];
        i = 0;
        j = 0;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
      paramArrayOfByte = new String((char[])localObject);
      return paramArrayOfByte;
      while (i < k)
      {
        int n = paramArrayOfByte[i];
        int m = j + 1;
        localObject[j] = arrayOfChar[(n >>> 4 & 0xF)];
        localObject[m] = arrayOfChar[(n & 0xF)];
        i += 1;
        j = m + 1;
      }
    }
  }
  
  public static String getMyProcessName(Context paramContext)
  {
    return getProcessNameByPid(paramContext, Process.myPid());
  }
  
  public static String getProcessNameByPid(Context paramContext, int paramInt)
  {
    if (Process.myUid() >= 99000) {
      return "ISOLATE_PROCESS";
    }
    if (!isNullOrNil(processName)) {
      return processName;
    }
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = Recovery.getContext();
    }
    if ((localObject == null) || (paramInt <= 0)) {
      return processName;
    }
    try
    {
      paramContext = ((ActivityManager)((Context)localObject).getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((((ActivityManager.RunningAppProcessInfo)localObject).pid == paramInt) && (((ActivityManager.RunningAppProcessInfo)localObject).processName != null) && (!((ActivityManager.RunningAppProcessInfo)localObject).processName.equals(""))) {
          processName = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
        }
      }
      return processName;
    }
    catch (Exception paramContext)
    {
      RecoveryLog.printErrStackTrace("Recovery.Util", paramContext, "", new Object[0]);
    }
  }
  
  public static String getTimeFormat(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(paramLong));
  }
  
  public static final int getUUID(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("recovery-info", 0);
    int j = localSharedPreferences.getInt("KeySafeModeUUID", -1);
    int i = j;
    if (j == -1)
    {
      i = genUUID(paramContext);
      localSharedPreferences.edit().putInt("KeySafeModeUUID", i).commit();
    }
    return i;
  }
  
  public static final boolean isNullOrNil(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean isUidIsolated(int paramInt)
  {
    return paramInt >= 99000;
  }
  
  /* Error */
  public static String readStringFromFile(java.io.File paramFile)
  {
    // Byte code:
    //   0: new 27	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_3
    //   9: aload_3
    //   10: astore_2
    //   11: new 311	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: aload_0
    //   16: invokevirtual 316	java/io/File:length	()J
    //   19: l2i
    //   20: invokespecial 319	java/io/ByteArrayOutputStream:<init>	(I)V
    //   23: astore_0
    //   24: aload_3
    //   25: astore_2
    //   26: sipush 4096
    //   29: newarray byte
    //   31: astore 4
    //   33: aload_3
    //   34: astore_2
    //   35: aload_3
    //   36: aload 4
    //   38: invokevirtual 322	java/io/FileInputStream:read	([B)I
    //   41: istore_1
    //   42: iload_1
    //   43: ifle +32 -> 75
    //   46: aload_3
    //   47: astore_2
    //   48: aload_0
    //   49: aload 4
    //   51: iconst_0
    //   52: iload_1
    //   53: invokevirtual 323	java/io/ByteArrayOutputStream:write	([BII)V
    //   56: goto -23 -> 33
    //   59: astore_0
    //   60: aload_3
    //   61: astore_2
    //   62: aload_0
    //   63: athrow
    //   64: astore_0
    //   65: aload_2
    //   66: ifnull +7 -> 73
    //   69: aload_2
    //   70: invokevirtual 46	java/io/FileInputStream:close	()V
    //   73: aload_0
    //   74: athrow
    //   75: aload_3
    //   76: astore_2
    //   77: new 100	java/lang/String
    //   80: dup
    //   81: aload_0
    //   82: invokevirtual 326	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   85: invokespecial 328	java/lang/String:<init>	([B)V
    //   88: astore_0
    //   89: aload_3
    //   90: invokevirtual 46	java/io/FileInputStream:close	()V
    //   93: aload_0
    //   94: areturn
    //   95: astore_2
    //   96: aload_0
    //   97: areturn
    //   98: astore_2
    //   99: goto -26 -> 73
    //   102: astore_0
    //   103: aconst_null
    //   104: astore_2
    //   105: goto -40 -> 65
    //   108: astore_0
    //   109: aconst_null
    //   110: astore_2
    //   111: goto -49 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramFile	java.io.File
    //   41	12	1	i	int
    //   10	67	2	localFileInputStream1	java.io.FileInputStream
    //   95	1	2	localIOException1	java.io.IOException
    //   98	1	2	localIOException2	java.io.IOException
    //   104	7	2	localObject	Object
    //   8	82	3	localFileInputStream2	java.io.FileInputStream
    //   31	19	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   11	24	59	java/lang/Exception
    //   26	33	59	java/lang/Exception
    //   35	42	59	java/lang/Exception
    //   48	56	59	java/lang/Exception
    //   77	89	59	java/lang/Exception
    //   11	24	64	finally
    //   26	33	64	finally
    //   35	42	64	finally
    //   48	56	64	finally
    //   62	64	64	finally
    //   77	89	64	finally
    //   89	93	95	java/io/IOException
    //   69	73	98	java/io/IOException
    //   0	9	102	finally
    //   0	9	108	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.recovery.util.Util
 * JD-Core Version:    0.7.0.1
 */