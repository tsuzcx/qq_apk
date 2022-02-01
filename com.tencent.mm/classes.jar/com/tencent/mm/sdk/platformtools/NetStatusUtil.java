package com.tencent.mm.sdk.platformtools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NetStatusUtil
{
  public static final String CELL_CDMA = "cdma";
  public static final String CELL_GSM = "gsm";
  public static final int CMNET = 6;
  public static final int CMWAP = 5;
  public static final int CTNET = 8;
  public static final int CTWAP = 7;
  private static int INVAL_STRENGTH = 10000;
  public static final int IOS_NETTYPE_2G = 2;
  public static final int IOS_NETTYPE_3G = 3;
  public static final int IOS_NETTYPE_4G = 4;
  public static final int IOS_NETTYPE_UNKNOW = 0;
  public static final int IOS_NETTYPE_WIFI = 1;
  public static final int LTE = 10;
  public static final int MOBILE = 9;
  public static final int NETTYPE_NOT_WIFI = 0;
  public static final int NETTYPE_WIFI = 1;
  public static final int NETWORK_TYPE_NR = 20;
  public static final int NET_3G = 4;
  public static final int NON_NETWORK = -1;
  public static final int NO_SIM_OPERATOR = 0;
  public static final int OLD_IOS_NETTYPE_2G = 3;
  public static final int OLD_IOS_NETTYPE_3G = 4;
  public static final int OLD_IOS_NETTYPE_4G = 5;
  public static final int OLD_IOS_NETTYPE_NOT_WIFI = 0;
  public static final int OLD_IOS_NETTYPE_WAP = 2;
  public static final int OLD_IOS_NETTYPE_WIFI = 1;
  public static final int POLICY_NONE = 0;
  public static final int POLICY_REJECT_METERED_BACKGROUND = 1;
  private static final String TAG = "MicroMsg.NetStatusUtil";
  public static final int TBACKGROUND_DATA_LIMITED = 2;
  public static final int TBACKGROUND_NOT_LIMITED = 0;
  public static final int TBACKGROUND_PROCESS_LIMITED = 1;
  public static final int TBACKGROUND_WIFI_LIMITED = 3;
  public static final int UNINET = 1;
  public static final int UNIWAP = 2;
  public static final int UNKNOW_TYPE = 999;
  public static final int WAP_3G = 3;
  public static final int WIFI = 0;
  private static int nowStrength = 10000;
  private static PhoneStateListener phoneListener = null;
  private static int phoneType = -1;
  private byte _hellAccFlag_;
  
  public static String dumpNetStatus(Context paramContext)
  {
    AppMethodBeat.i(157730);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      localStringBuilder.append("isAvailable " + localNetworkInfo.isAvailable() + "\r\n");
      localStringBuilder.append("isAvailable " + localNetworkInfo.isAvailable() + "\r\n");
      localStringBuilder.append("isConnected " + localNetworkInfo.isConnected() + "\r\n");
      localStringBuilder.append("isRoaming " + localNetworkInfo.isRoaming() + "\r\n");
      localStringBuilder.append("isFailover " + localNetworkInfo.isFailover() + "\r\n");
      localStringBuilder.append("getSubtypeName " + localNetworkInfo.getSubtypeName() + "\r\n");
      localStringBuilder.append("getSubtype " + localNetworkInfo.getSubtype() + "\r\n");
      localStringBuilder.append("getType " + localNetworkInfo.getType() + "\r\n");
      localStringBuilder.append("getExtraInfo " + localNetworkInfo.getExtraInfo() + "\r\n");
      localStringBuilder.append("activeNetInfo " + localNetworkInfo.toString() + "\r\n");
      localStringBuilder.append("is2G " + is2G(paramContext) + "\r\n");
      localStringBuilder.append("is3G " + is3G(paramContext) + "\r\n");
      localStringBuilder.append("is4G " + is4G(paramContext) + "\r\n");
      localStringBuilder.append("isWifi " + isWifi(paramContext) + "\r\n");
      Log.i("MicroMsg.NetStatusUtil", "netstatus " + localStringBuilder.toString());
      paramContext = localStringBuilder.toString();
      AppMethodBeat.o(157730);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.i("MicroMsg.NetStatusUtil", paramContext.getMessage());
        Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      }
    }
  }
  
  public static int getBackgroundLimitType(Context paramContext)
  {
    AppMethodBeat.i(157754);
    int i;
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        Object localObject = Class.forName("android.app.ActivityManagerNative");
        localObject = ((Class)localObject).getMethod("getDefault", new Class[0]).invoke(localObject, new Object[0]);
        i = ((Integer)localObject.getClass().getMethod("getProcessLimit", new Class[0]).invoke(localObject, new Object[0])).intValue();
        if (i == 0)
        {
          AppMethodBeat.o(157754);
          return 1;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.NetStatusUtil", localException, "", new Object[0]);
      }
    }
    try
    {
      i = getWifiSleeepPolicy(paramContext);
      if (i != 2)
      {
        int j = getNetType(paramContext);
        if (j == 0) {}
      }
      else
      {
        AppMethodBeat.o(157754);
        return 0;
      }
      if ((i == 1) || (i == 0))
      {
        AppMethodBeat.o(157754);
        return 3;
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157754);
    }
    return 0;
  }
  
  /* Error */
  public static List<CellInfo> getCellInfoList(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 277
    //   6: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 81	com/tencent/mm/sdk/platformtools/NetStatusUtil:phoneListener	Landroid/telephony/PhoneStateListener;
    //   12: ifnonnull +24 -> 36
    //   15: ldc 61
    //   17: ldc_w 279
    //   20: invokestatic 282	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aconst_null
    //   24: astore_0
    //   25: ldc_w 277
    //   28: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_0
    //   35: areturn
    //   36: aload_0
    //   37: ldc_w 284
    //   40: invokevirtual 118	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   43: checkcast 286	android/telephony/TelephonyManager
    //   46: astore 7
    //   48: new 288	java/util/LinkedList
    //   51: dup
    //   52: invokespecial 289	java/util/LinkedList:<init>	()V
    //   55: astore 4
    //   57: ldc_w 291
    //   60: astore 5
    //   62: ldc 225
    //   64: astore 6
    //   66: aload 7
    //   68: invokevirtual 294	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   71: astore_3
    //   72: aload_3
    //   73: ifnull +183 -> 256
    //   76: aload_3
    //   77: ldc 225
    //   79: invokevirtual 300	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifne +174 -> 256
    //   85: aload_3
    //   86: iconst_0
    //   87: iconst_3
    //   88: invokevirtual 304	java/lang/String:substring	(II)Ljava/lang/String;
    //   91: astore_0
    //   92: aload_3
    //   93: iconst_3
    //   94: iconst_5
    //   95: invokevirtual 304	java/lang/String:substring	(II)Ljava/lang/String;
    //   98: astore_3
    //   99: aload 7
    //   101: invokevirtual 307	android/telephony/TelephonyManager:getPhoneType	()I
    //   104: istore_1
    //   105: iload_1
    //   106: iconst_2
    //   107: if_icmpne +550 -> 657
    //   110: aload 7
    //   112: invokevirtual 311	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   115: checkcast 313	android/telephony/cdma/CdmaCellLocation
    //   118: astore 6
    //   120: aload 6
    //   122: ifnull +122 -> 244
    //   125: getstatic 85	com/tencent/mm/sdk/platformtools/NetStatusUtil:nowStrength	I
    //   128: getstatic 83	com/tencent/mm/sdk/platformtools/NetStatusUtil:INVAL_STRENGTH	I
    //   131: if_icmpne +203 -> 334
    //   134: ldc 225
    //   136: astore 5
    //   138: aload 6
    //   140: invokevirtual 316	android/telephony/cdma/CdmaCellLocation:getBaseStationId	()I
    //   143: iconst_m1
    //   144: if_icmpeq +100 -> 244
    //   147: aload 6
    //   149: invokevirtual 319	android/telephony/cdma/CdmaCellLocation:getNetworkId	()I
    //   152: iconst_m1
    //   153: if_icmpeq +91 -> 244
    //   156: aload 6
    //   158: invokevirtual 322	android/telephony/cdma/CdmaCellLocation:getSystemId	()I
    //   161: iconst_m1
    //   162: if_icmpeq +82 -> 244
    //   165: aload 4
    //   167: new 8	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo
    //   170: dup
    //   171: aload_0
    //   172: aload_3
    //   173: ldc 225
    //   175: ldc 225
    //   177: aload 5
    //   179: ldc 15
    //   181: new 109	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   188: aload 6
    //   190: invokevirtual 316	android/telephony/cdma/CdmaCellLocation:getBaseStationId	()I
    //   193: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: new 109	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   206: aload 6
    //   208: invokevirtual 319	android/telephony/cdma/CdmaCellLocation:getNetworkId	()I
    //   211: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: new 109	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   224: aload 6
    //   226: invokevirtual 322	android/telephony/cdma/CdmaCellLocation:getSystemId	()I
    //   229: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokespecial 325	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   238: invokeinterface 330 2 0
    //   243: pop
    //   244: ldc_w 277
    //   247: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aload 4
    //   252: astore_0
    //   253: goto -222 -> 31
    //   256: aload 7
    //   258: invokevirtual 333	android/telephony/TelephonyManager:getSimOperator	()Ljava/lang/String;
    //   261: astore 8
    //   263: aload 6
    //   265: astore_3
    //   266: aload 5
    //   268: astore_0
    //   269: aload 8
    //   271: ifnull +35 -> 306
    //   274: aload 6
    //   276: astore_3
    //   277: aload 5
    //   279: astore_0
    //   280: aload 8
    //   282: ldc 225
    //   284: invokevirtual 300	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   287: ifne +19 -> 306
    //   290: aload 8
    //   292: iconst_0
    //   293: iconst_3
    //   294: invokevirtual 304	java/lang/String:substring	(II)Ljava/lang/String;
    //   297: astore_0
    //   298: aload 8
    //   300: iconst_3
    //   301: iconst_5
    //   302: invokevirtual 304	java/lang/String:substring	(II)Ljava/lang/String;
    //   305: astore_3
    //   306: goto -207 -> 99
    //   309: astore_0
    //   310: ldc 61
    //   312: aload_0
    //   313: ldc 225
    //   315: iconst_0
    //   316: anewarray 4	java/lang/Object
    //   319: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: ldc_w 277
    //   325: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   328: aload 4
    //   330: astore_0
    //   331: goto -300 -> 31
    //   334: new 109	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   341: getstatic 85	com/tencent/mm/sdk/platformtools/NetStatusUtil:nowStrength	I
    //   344: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   347: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: astore 5
    //   352: goto -214 -> 138
    //   355: astore 5
    //   357: aload 7
    //   359: invokevirtual 311	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   362: checkcast 335	android/telephony/gsm/GsmCellLocation
    //   365: astore 5
    //   367: aload 5
    //   369: ifnull +67 -> 436
    //   372: aload 5
    //   374: invokevirtual 338	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   377: istore_1
    //   378: aload 5
    //   380: invokevirtual 341	android/telephony/gsm/GsmCellLocation:getLac	()I
    //   383: istore_2
    //   384: iload_2
    //   385: ldc_w 342
    //   388: if_icmpge +48 -> 436
    //   391: iload_2
    //   392: iconst_m1
    //   393: if_icmpeq +43 -> 436
    //   396: iload_1
    //   397: iconst_m1
    //   398: if_icmpeq +38 -> 436
    //   401: aload 4
    //   403: new 8	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo
    //   406: dup
    //   407: aload_0
    //   408: aload_3
    //   409: iload_2
    //   410: invokestatic 346	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   413: iload_1
    //   414: invokestatic 346	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   417: ldc 225
    //   419: ldc 18
    //   421: ldc 225
    //   423: ldc 225
    //   425: ldc 225
    //   427: invokespecial 325	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   430: invokeinterface 330 2 0
    //   435: pop
    //   436: aload 7
    //   438: invokevirtual 350	android/telephony/TelephonyManager:getAllCellInfo	()Ljava/util/List;
    //   441: astore 5
    //   443: aload 5
    //   445: ifnull -201 -> 244
    //   448: aload 5
    //   450: invokeinterface 353 1 0
    //   455: ifle -211 -> 244
    //   458: aload 5
    //   460: invokeinterface 357 1 0
    //   465: astore 5
    //   467: aload 5
    //   469: invokeinterface 362 1 0
    //   474: ifeq -230 -> 244
    //   477: aload 5
    //   479: invokeinterface 366 1 0
    //   484: checkcast 368	android/telephony/CellInfo
    //   487: astore 7
    //   489: aload 7
    //   491: instanceof 370
    //   494: ifeq -27 -> 467
    //   497: aload 7
    //   499: checkcast 370	android/telephony/CellInfoGsm
    //   502: invokevirtual 374	android/telephony/CellInfoGsm:getCellIdentity	()Landroid/telephony/CellIdentityGsm;
    //   505: astore 6
    //   507: aload 6
    //   509: invokevirtual 377	android/telephony/CellIdentityGsm:getCid	()I
    //   512: iconst_m1
    //   513: if_icmpeq -46 -> 467
    //   516: aload 6
    //   518: invokevirtual 378	android/telephony/CellIdentityGsm:getLac	()I
    //   521: ldc_w 342
    //   524: if_icmpgt -57 -> 467
    //   527: aload 6
    //   529: invokevirtual 378	android/telephony/CellIdentityGsm:getLac	()I
    //   532: iconst_m1
    //   533: if_icmpeq -66 -> 467
    //   536: new 109	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   543: aload 7
    //   545: checkcast 370	android/telephony/CellInfoGsm
    //   548: invokevirtual 382	android/telephony/CellInfoGsm:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthGsm;
    //   551: invokevirtual 387	android/telephony/CellSignalStrengthGsm:getAsuLevel	()I
    //   554: iconst_2
    //   555: imul
    //   556: bipush 113
    //   558: isub
    //   559: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   562: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: astore 7
    //   567: aload 4
    //   569: new 8	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo
    //   572: dup
    //   573: aload_0
    //   574: aload_3
    //   575: new 109	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   582: aload 6
    //   584: invokevirtual 378	android/telephony/CellIdentityGsm:getLac	()I
    //   587: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   590: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: new 109	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   600: aload 6
    //   602: invokevirtual 377	android/telephony/CellIdentityGsm:getCid	()I
    //   605: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   608: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: aload 7
    //   613: ldc 18
    //   615: ldc 225
    //   617: ldc 225
    //   619: ldc 225
    //   621: invokespecial 325	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   624: invokeinterface 330 2 0
    //   629: pop
    //   630: goto -163 -> 467
    //   633: astore_0
    //   634: ldc 2
    //   636: monitorexit
    //   637: aload_0
    //   638: athrow
    //   639: astore 5
    //   641: ldc 61
    //   643: aload 5
    //   645: ldc 225
    //   647: iconst_0
    //   648: anewarray 4	java/lang/Object
    //   651: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   654: goto -218 -> 436
    //   657: aload 7
    //   659: invokevirtual 311	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   662: checkcast 335	android/telephony/gsm/GsmCellLocation
    //   665: astore 5
    //   667: aload 5
    //   669: ifnull +80 -> 749
    //   672: aload 5
    //   674: invokevirtual 338	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   677: istore_1
    //   678: aload 5
    //   680: invokevirtual 341	android/telephony/gsm/GsmCellLocation:getLac	()I
    //   683: istore_2
    //   684: iload_2
    //   685: ldc_w 342
    //   688: if_icmpge +61 -> 749
    //   691: iload_2
    //   692: iconst_m1
    //   693: if_icmpeq +56 -> 749
    //   696: iload_1
    //   697: iconst_m1
    //   698: if_icmpeq +51 -> 749
    //   701: getstatic 85	com/tencent/mm/sdk/platformtools/NetStatusUtil:nowStrength	I
    //   704: getstatic 83	com/tencent/mm/sdk/platformtools/NetStatusUtil:INVAL_STRENGTH	I
    //   707: if_icmpne +282 -> 989
    //   710: ldc 225
    //   712: astore 5
    //   714: aload 4
    //   716: new 8	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo
    //   719: dup
    //   720: aload_0
    //   721: aload_3
    //   722: iload_2
    //   723: invokestatic 346	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   726: iload_1
    //   727: invokestatic 346	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   730: aload 5
    //   732: ldc 18
    //   734: ldc 225
    //   736: ldc 225
    //   738: ldc 225
    //   740: invokespecial 325	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   743: invokeinterface 330 2 0
    //   748: pop
    //   749: aload 7
    //   751: invokevirtual 350	android/telephony/TelephonyManager:getAllCellInfo	()Ljava/util/List;
    //   754: astore 5
    //   756: aload 5
    //   758: ifnull -514 -> 244
    //   761: aload 5
    //   763: invokeinterface 353 1 0
    //   768: ifle -524 -> 244
    //   771: aload 5
    //   773: invokeinterface 357 1 0
    //   778: astore 5
    //   780: aload 5
    //   782: invokeinterface 362 1 0
    //   787: ifeq -543 -> 244
    //   790: aload 5
    //   792: invokeinterface 366 1 0
    //   797: checkcast 368	android/telephony/CellInfo
    //   800: astore 7
    //   802: aload 7
    //   804: instanceof 370
    //   807: ifeq -27 -> 780
    //   810: aload 7
    //   812: checkcast 370	android/telephony/CellInfoGsm
    //   815: invokevirtual 374	android/telephony/CellInfoGsm:getCellIdentity	()Landroid/telephony/CellIdentityGsm;
    //   818: astore 6
    //   820: aload 6
    //   822: invokevirtual 377	android/telephony/CellIdentityGsm:getCid	()I
    //   825: iconst_m1
    //   826: if_icmpeq -46 -> 780
    //   829: aload 6
    //   831: invokevirtual 378	android/telephony/CellIdentityGsm:getLac	()I
    //   834: ldc_w 342
    //   837: if_icmpgt -57 -> 780
    //   840: new 109	java/lang/StringBuilder
    //   843: dup
    //   844: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   847: aload 7
    //   849: checkcast 370	android/telephony/CellInfoGsm
    //   852: invokevirtual 382	android/telephony/CellInfoGsm:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthGsm;
    //   855: invokevirtual 387	android/telephony/CellSignalStrengthGsm:getAsuLevel	()I
    //   858: iconst_2
    //   859: imul
    //   860: bipush 113
    //   862: isub
    //   863: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   866: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   869: astore 7
    //   871: ldc_w 389
    //   874: new 109	java/lang/StringBuilder
    //   877: dup
    //   878: ldc_w 391
    //   881: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   884: aload 6
    //   886: invokevirtual 378	android/telephony/CellIdentityGsm:getLac	()I
    //   889: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   892: ldc_w 393
    //   895: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: aload 6
    //   900: invokevirtual 377	android/telephony/CellIdentityGsm:getCid	()I
    //   903: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   906: ldc_w 395
    //   909: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: aload 7
    //   914: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   920: invokestatic 398	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   923: aload 4
    //   925: new 8	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo
    //   928: dup
    //   929: aload_0
    //   930: aload_3
    //   931: new 109	java/lang/StringBuilder
    //   934: dup
    //   935: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   938: aload 6
    //   940: invokevirtual 378	android/telephony/CellIdentityGsm:getLac	()I
    //   943: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   946: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   949: new 109	java/lang/StringBuilder
    //   952: dup
    //   953: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   956: aload 6
    //   958: invokevirtual 377	android/telephony/CellIdentityGsm:getCid	()I
    //   961: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   964: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   967: aload 7
    //   969: ldc 18
    //   971: ldc 225
    //   973: ldc 225
    //   975: ldc 225
    //   977: invokespecial 325	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   980: invokeinterface 330 2 0
    //   985: pop
    //   986: goto -206 -> 780
    //   989: new 109	java/lang/StringBuilder
    //   992: dup
    //   993: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   996: getstatic 85	com/tencent/mm/sdk/platformtools/NetStatusUtil:nowStrength	I
    //   999: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1002: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1005: astore 5
    //   1007: goto -293 -> 714
    //   1010: astore 5
    //   1012: ldc 61
    //   1014: aload 5
    //   1016: ldc 225
    //   1018: iconst_0
    //   1019: anewarray 4	java/lang/Object
    //   1022: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1025: goto -276 -> 749
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1028	0	paramContext	Context
    //   104	623	1	i	int
    //   383	340	2	j	int
    //   71	860	3	localObject1	Object
    //   55	869	4	localLinkedList	java.util.LinkedList
    //   60	291	5	str1	String
    //   355	1	5	localException1	Exception
    //   365	113	5	localObject2	Object
    //   639	5	5	localException2	Exception
    //   665	341	5	localObject3	Object
    //   1010	5	5	localException3	Exception
    //   64	893	6	localObject4	Object
    //   46	922	7	localObject5	Object
    //   261	38	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   66	72	309	java/lang/Exception
    //   76	99	309	java/lang/Exception
    //   256	263	309	java/lang/Exception
    //   280	306	309	java/lang/Exception
    //   110	120	355	java/lang/Exception
    //   125	134	355	java/lang/Exception
    //   138	244	355	java/lang/Exception
    //   334	352	355	java/lang/Exception
    //   3	23	633	finally
    //   25	31	633	finally
    //   36	57	633	finally
    //   66	72	633	finally
    //   76	99	633	finally
    //   99	105	633	finally
    //   110	120	633	finally
    //   125	134	633	finally
    //   138	244	633	finally
    //   244	250	633	finally
    //   256	263	633	finally
    //   280	306	633	finally
    //   310	328	633	finally
    //   334	352	633	finally
    //   357	367	633	finally
    //   372	384	633	finally
    //   401	436	633	finally
    //   436	443	633	finally
    //   448	467	633	finally
    //   467	630	633	finally
    //   641	654	633	finally
    //   657	667	633	finally
    //   672	684	633	finally
    //   701	710	633	finally
    //   714	749	633	finally
    //   749	756	633	finally
    //   761	780	633	finally
    //   780	986	633	finally
    //   989	1007	633	finally
    //   1012	1025	633	finally
    //   357	367	639	java/lang/Exception
    //   372	384	639	java/lang/Exception
    //   401	436	639	java/lang/Exception
    //   657	667	1010	java/lang/Exception
    //   672	684	1010	java/lang/Exception
    //   701	710	1010	java/lang/Exception
    //   714	749	1010	java/lang/Exception
    //   989	1007	1010	java/lang/Exception
  }
  
  public static String getConnectedWifiBssid(Context paramContext)
  {
    AppMethodBeat.i(157750);
    if (getNetType(paramContext) != 0)
    {
      Log.i("MicroMsg.NetStatusUtil", "wifi not connected. getConnectedWifiBssid() is empty");
      AppMethodBeat.o(157750);
      return "";
    }
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext == null)
    {
      AppMethodBeat.o(157750);
      return "";
    }
    paramContext = paramContext.getConnectionInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(157750);
      return "";
    }
    paramContext = Util.nullAsNil(paramContext.getBSSID()).toLowerCase();
    Log.i("MicroMsg.NetStatusUtil", "getConnectedWifiBssid()=".concat(String.valueOf(paramContext)));
    AppMethodBeat.o(157750);
    return paramContext;
  }
  
  public static String getConnectedWifiClientMac(Context paramContext)
  {
    AppMethodBeat.i(157751);
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext == null)
    {
      Log.e("MicroMsg.NetStatusUtil", "error wifiManager is null!!");
      AppMethodBeat.o(157751);
      return "";
    }
    paramContext = paramContext.getConnectionInfo();
    if (paramContext == null)
    {
      Log.e("MicroMsg.NetStatusUtil", "error wifiInfo is null!!");
      AppMethodBeat.o(157751);
      return "";
    }
    String str = paramContext.getMacAddress();
    paramContext = str;
    if (Build.VERSION.SDK_INT > 22) {
      if (str != null)
      {
        paramContext = str;
        if (!str.equals("02:00:00:00:00:00")) {}
      }
      else
      {
        paramContext = getMacAddressFromNet();
      }
    }
    paramContext = Util.nullAsNil(paramContext).toLowerCase();
    Log.i("MicroMsg.NetStatusUtil", "getConnectedWifiClientMac()=".concat(String.valueOf(paramContext)));
    AppMethodBeat.o(157751);
    return paramContext;
  }
  
  public static String getConnectedWifiSsid(Context paramContext)
  {
    AppMethodBeat.i(157749);
    if (getNetType(paramContext) != 0)
    {
      Log.i("MicroMsg.NetStatusUtil", "wifi not connected. getConnectedWifiSsid() is empty");
      AppMethodBeat.o(157749);
      return "";
    }
    Object localObject2 = (WifiManager)paramContext.getSystemService("wifi");
    if (localObject2 == null)
    {
      AppMethodBeat.o(157749);
      return "";
    }
    Object localObject1 = ((WifiManager)localObject2).getConnectionInfo();
    if (localObject1 == null)
    {
      AppMethodBeat.o(157749);
      return "";
    }
    paramContext = ((WifiInfo)localObject1).getSSID();
    if (Build.VERSION.SDK_INT >= 27) {
      try
      {
        localObject2 = ((WifiManager)localObject2).getConfiguredNetworks();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            WifiConfiguration localWifiConfiguration = (WifiConfiguration)((Iterator)localObject2).next();
            if (localWifiConfiguration.networkId == ((WifiInfo)localObject1).getNetworkId())
            {
              Log.i("MicroMsg.NetStatusUtil", "get wifi config ssid %s", new Object[] { localWifiConfiguration.SSID });
              localObject1 = localWifiConfiguration.SSID;
              paramContext = (Context)localObject1;
            }
          }
        }
        for (;;)
        {
          paramContext = Util.nullAsNil(paramContext);
          Log.i("MicroMsg.NetStatusUtil", "getConnectedWifiSsid()=" + removeSsidQuote(paramContext));
          paramContext = removeSsidQuote(paramContext);
          AppMethodBeat.o(157749);
          return paramContext;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.NetStatusUtil", localThrowable, "get wifi ssid fail", new Object[0]);
      }
    }
  }
  
  public static String getFormatedNetType(Context paramContext)
  {
    AppMethodBeat.i(157733);
    if (is2G(paramContext))
    {
      AppMethodBeat.o(157733);
      return "2G";
    }
    if (is3G(paramContext))
    {
      AppMethodBeat.o(157733);
      return "3G";
    }
    if (is4G(paramContext))
    {
      AppMethodBeat.o(157733);
      return "4G";
    }
    if (is5G(paramContext))
    {
      AppMethodBeat.o(157733);
      return "5G";
    }
    if (isWifi(paramContext))
    {
      AppMethodBeat.o(157733);
      return "WIFI";
    }
    paramContext = getNetTypeString(paramContext);
    AppMethodBeat.o(157733);
    return paramContext;
  }
  
  public static int getIOSNetType(Context paramContext)
  {
    AppMethodBeat.i(157734);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(157734);
        return 0;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(157734);
        return 1;
      }
      if (paramContext.getSubtype() != 1)
      {
        i = paramContext.getSubtype();
        if (i != 2) {}
      }
      else
      {
        AppMethodBeat.o(157734);
        return 2;
      }
      i = paramContext.getSubtype();
      if (i >= 13)
      {
        AppMethodBeat.o(157734);
        return 4;
      }
      i = paramContext.getSubtype();
      if (i >= 3)
      {
        AppMethodBeat.o(157734);
        return 3;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(157734);
    }
    return 0;
  }
  
  public static int getIOSOldNetType(Context paramContext)
  {
    AppMethodBeat.i(157735);
    try
    {
      int i = getNetType(paramContext);
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(157735);
        return 0;
      }
      int j = paramContext.getType();
      if (j == 1)
      {
        AppMethodBeat.o(157735);
        return 1;
      }
      if (paramContext.getSubtype() != 1)
      {
        j = paramContext.getSubtype();
        if (j != 2) {}
      }
      else
      {
        AppMethodBeat.o(157735);
        return 3;
      }
      j = paramContext.getSubtype();
      if (j >= 13)
      {
        AppMethodBeat.o(157735);
        return 5;
      }
      j = paramContext.getSubtype();
      if (j >= 3)
      {
        AppMethodBeat.o(157735);
        return 4;
      }
      boolean bool = isWap(i);
      if (bool)
      {
        AppMethodBeat.o(157735);
        return 2;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(157735);
    }
    return 0;
  }
  
  public static int getISPCode(Context paramContext)
  {
    AppMethodBeat.i(157738);
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null)
    {
      AppMethodBeat.o(157738);
      return 0;
    }
    paramContext = paramContext.getSimOperator();
    if ((paramContext == null) || (paramContext.length() < 5))
    {
      AppMethodBeat.o(157738);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        j = paramContext.length();
        i = j;
        if (j <= 6) {
          break label160;
        }
        i = 6;
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
        AppMethodBeat.o(157738);
        return 0;
      }
      if (j < i) {
        if (!Character.isDigit(paramContext.charAt(j)))
        {
          if (localStringBuilder.length() <= 0) {
            break label165;
          }
        }
        else
        {
          localStringBuilder.append(paramContext.charAt(j));
          break label165;
        }
      }
      int i = Integer.valueOf(localStringBuilder.toString()).intValue();
      AppMethodBeat.o(157738);
      return i;
      label160:
      int j = 0;
      continue;
      label165:
      j += 1;
    }
  }
  
  public static String getISPName(Context paramContext)
  {
    AppMethodBeat.i(157739);
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null)
      {
        AppMethodBeat.o(157739);
        return "";
      }
      Log.d("MicroMsg.NetStatusUtil", "getISPName ISPName=%s", new Object[] { paramContext.getSimOperatorName() });
      if (paramContext.getSimOperatorName().length() <= 100)
      {
        paramContext = paramContext.getSimOperatorName();
        AppMethodBeat.o(157739);
        return paramContext;
      }
      paramContext = paramContext.getSimOperatorName().substring(0, 100);
      AppMethodBeat.o(157739);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(157739);
    }
    return "";
  }
  
  public static String getMacAddressFromNet()
  {
    AppMethodBeat.i(157752);
    long l = System.currentTimeMillis();
    try
    {
      if (NetworkInterface.getNetworkInterfaces() != null)
      {
        Object localObject1 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (NetworkInterface)((Iterator)localObject1).next();
          if (((NetworkInterface)localObject2).getName().equalsIgnoreCase("wlan0"))
          {
            localObject1 = ((NetworkInterface)localObject2).getHardwareAddress();
            if (localObject1 == null)
            {
              Log.d("MicroMsg.NetStatusUtil", "et mobile mac from net time cost :" + (System.currentTimeMillis() - l));
              AppMethodBeat.o(157752);
              return "02:00:00:00:00:00";
            }
            localObject2 = new StringBuilder();
            int j = localObject1.length;
            int i = 0;
            while (i < j)
            {
              ((StringBuilder)localObject2).append(String.format("%02X:", new Object[] { Byte.valueOf(localObject1[i]) }));
              i += 1;
            }
            if (((StringBuilder)localObject2).length() > 0) {
              ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
            }
            Log.d("MicroMsg.NetStatusUtil", "et mobile mac from net time cost :" + (System.currentTimeMillis() - l));
            localObject1 = ((StringBuilder)localObject2).toString();
            AppMethodBeat.o(157752);
            return localObject1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NetStatusUtil", "get mobile mac from net fail!".concat(String.valueOf(localException)));
      Log.d("MicroMsg.NetStatusUtil", "et mobile mac from net time cost :" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(157752);
    }
    return "02:00:00:00:00:00";
  }
  
  public static int getNetType(Context paramContext)
  {
    AppMethodBeat.i(157737);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(157737);
      return -1;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(157737);
      return -1;
    }
    if (paramContext.getType() == 1)
    {
      AppMethodBeat.o(157737);
      return 0;
    }
    Log.d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", new Object[] { paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()) });
    if (paramContext.getExtraInfo() != null)
    {
      if (paramContext.getExtraInfo().equalsIgnoreCase("uninet"))
      {
        AppMethodBeat.o(157737);
        return 1;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("uniwap"))
      {
        AppMethodBeat.o(157737);
        return 2;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gwap"))
      {
        AppMethodBeat.o(157737);
        return 3;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gnet"))
      {
        AppMethodBeat.o(157737);
        return 4;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmwap"))
      {
        AppMethodBeat.o(157737);
        return 5;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmnet"))
      {
        AppMethodBeat.o(157737);
        return 6;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctwap"))
      {
        AppMethodBeat.o(157737);
        return 7;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctnet"))
      {
        AppMethodBeat.o(157737);
        return 8;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("LTE"))
      {
        AppMethodBeat.o(157737);
        return 10;
      }
    }
    AppMethodBeat.o(157737);
    return 9;
  }
  
  public static int getNetTypeForStat(Context paramContext)
  {
    AppMethodBeat.i(157756);
    if (paramContext == null)
    {
      AppMethodBeat.o(157756);
      return 999;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null)
      {
        AppMethodBeat.o(157756);
        return 999;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(157756);
        return 999;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(157756);
        return 1;
      }
      i = paramContext.getSubtype();
      if (i == 0)
      {
        AppMethodBeat.o(157756);
        return 999;
      }
      AppMethodBeat.o(157756);
      return i * 1000;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157756);
    }
    return 999;
  }
  
  public static String getNetTypeString(Context paramContext)
  {
    AppMethodBeat.i(157732);
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null)
      {
        AppMethodBeat.o(157732);
        return "NON_NETWORK";
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(157732);
        return "NON_NETWORK";
      }
      if (paramContext.getType() == 1)
      {
        AppMethodBeat.o(157732);
        return "WIFI";
      }
      Log.d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", new Object[] { paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()) });
      if (paramContext.getExtraInfo() != null)
      {
        paramContext = paramContext.getExtraInfo();
        AppMethodBeat.o(157732);
        return paramContext;
      }
      AppMethodBeat.o(157732);
      return "MOBILE";
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157732);
    }
    return "NON_NETWORK";
  }
  
  public static int getNetWorkType(Context paramContext)
  {
    AppMethodBeat.i(157736);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        int i = paramContext.getType();
        AppMethodBeat.o(157736);
        return i;
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157736);
    }
    return -1;
  }
  
  public static int getProxyInfo(Context paramContext, StringBuffer paramStringBuffer)
  {
    AppMethodBeat.i(230364);
    try
    {
      paramContext = Proxy.getDefaultHost();
      int i = Proxy.getDefaultPort();
      Log.d("MicroMsg.NetStatusUtil", "dkwap api host:%s port:%d thr:%d", new Object[] { paramContext, Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
      if ((paramContext != null) && (paramContext.length() > 0) && (i > 0))
      {
        paramStringBuffer.append(paramContext);
        AppMethodBeat.o(230364);
        return i;
      }
      paramContext = System.getProperty("http.proxyHost");
      String str = System.getProperty("http.proxyPort");
      Log.d("MicroMsg.NetStatusUtil", "dkwap vm host:%s port:%s thr:%d", new Object[] { paramContext, str, Long.valueOf(Thread.currentThread().getId()) });
      int j = 80;
      i = j;
      if (str != null)
      {
        i = j;
        if (str.length() > 0) {
          i = Integer.parseInt(str);
        }
      }
      if ((paramContext != null) && (paramContext.length() > 0))
      {
        paramStringBuffer.append(paramContext);
        AppMethodBeat.o(230364);
        return i;
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(230364);
    }
    return 0;
  }
  
  /* Error */
  public static int getStrength(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 672
    //   6: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnonnull +16 -> 26
    //   13: ldc_w 672
    //   16: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: aload_0
    //   27: invokestatic 674	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetTypeForStat	(Landroid/content/Context;)I
    //   30: iconst_1
    //   31: if_icmpne +38 -> 69
    //   34: aload_0
    //   35: ldc_w 406
    //   38: invokevirtual 118	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   41: checkcast 408	android/net/wifi/WifiManager
    //   44: invokevirtual 412	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   47: invokevirtual 677	android/net/wifi/WifiInfo:getRssi	()I
    //   50: invokestatic 682	java/lang/Math:abs	(I)I
    //   53: istore_1
    //   54: ldc_w 672
    //   57: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: goto -39 -> 21
    //   63: astore_0
    //   64: ldc 2
    //   66: monitorexit
    //   67: aload_0
    //   68: athrow
    //   69: getstatic 81	com/tencent/mm/sdk/platformtools/NetStatusUtil:phoneListener	Landroid/telephony/PhoneStateListener;
    //   72: ifnonnull +11 -> 83
    //   75: ldc 61
    //   77: ldc_w 279
    //   80: invokestatic 282	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: getstatic 85	com/tencent/mm/sdk/platformtools/NetStatusUtil:nowStrength	I
    //   86: invokestatic 682	java/lang/Math:abs	(I)I
    //   89: istore_1
    //   90: ldc_w 672
    //   93: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: goto -75 -> 21
    //   99: astore_0
    //   100: ldc 61
    //   102: aload_0
    //   103: ldc 225
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: ldc_w 672
    //   115: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: iconst_0
    //   119: istore_1
    //   120: goto -99 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramContext	Context
    //   20	100	1	i	int
    // Exception table:
    //   from	to	target	type
    //   3	9	63	finally
    //   13	19	63	finally
    //   26	54	63	finally
    //   54	60	63	finally
    //   69	83	63	finally
    //   83	90	63	finally
    //   90	96	63	finally
    //   100	118	63	finally
    //   26	54	99	java/lang/Exception
    //   69	83	99	java/lang/Exception
    //   83	90	99	java/lang/Exception
  }
  
  public static WifiInfo getWifiInfo(Context paramContext)
  {
    AppMethodBeat.i(157746);
    try
    {
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null)
      {
        AppMethodBeat.o(157746);
        return null;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject != null)
      {
        int i = ((NetworkInfo)localObject).getType();
        if (1 == i) {}
      }
      else
      {
        AppMethodBeat.o(157746);
        return null;
      }
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext == null)
      {
        AppMethodBeat.o(157746);
        return null;
      }
      paramContext = paramContext.getConnectionInfo();
      AppMethodBeat.o(157746);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157746);
    }
    return null;
  }
  
  public static int getWifiSleeepPolicy(Context paramContext)
  {
    AppMethodBeat.i(230362);
    int i = Settings.System.getInt(paramContext.getContentResolver(), "wifi_sleep_policy", 2);
    AppMethodBeat.o(230362);
    return i;
  }
  
  public static int guessNetSpeed(Context paramContext)
  {
    AppMethodBeat.i(230359);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(230359);
        return 102400;
      }
      i = paramContext.getSubtype();
      switch (i)
      {
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      }
    }
    AppMethodBeat.o(230359);
    return 102400;
    AppMethodBeat.o(230359);
    return 4096;
    AppMethodBeat.o(230359);
    return 8192;
    AppMethodBeat.o(230359);
    return 102400;
  }
  
  public static void initMobileStrengthListener(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(157758);
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      phoneType = paramContext.getPhoneType();
      if (phoneListener == null)
      {
        phoneListener = new PhoneStateListener()
        {
          public final void onSignalStrengthsChanged(SignalStrength paramAnonymousSignalStrength)
          {
            AppMethodBeat.i(157729);
            super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
            if (NetStatusUtil.phoneType == 2) {
              NetStatusUtil.access$102(paramAnonymousSignalStrength.getCdmaDbm());
            }
            if (NetStatusUtil.phoneType == 1) {
              NetStatusUtil.access$102(paramAnonymousSignalStrength.getGsmSignalStrength() * 2 - 113);
            }
            Log.i("MicroMsg.NetStatusUtil", "PhoneStateListener  type:%d  strength:%d", new Object[] { Integer.valueOf(NetStatusUtil.phoneType), Integer.valueOf(NetStatusUtil.nowStrength) });
            AppMethodBeat.o(157729);
          }
        };
        Object localObject = phoneListener;
        localObject = c.a(256, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "initMobileStrengthListener", "(Landroid/content/Context;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        paramContext.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "initMobileStrengthListener", "(Landroid/content/Context;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      }
      AppMethodBeat.o(157758);
      return;
    }
    finally {}
  }
  
  public static boolean is2G(Context paramContext)
  {
    AppMethodBeat.i(157741);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(157741);
        return false;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(157741);
        return false;
      }
      Log.d("MicroMsg.NetStatusUtil", "is2G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      if ((paramContext.getSubtype() != 2) && (paramContext.getSubtype() != 1))
      {
        i = paramContext.getSubtype();
        if (i != 4) {}
      }
      else
      {
        AppMethodBeat.o(157741);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157741);
    }
    return false;
  }
  
  public static boolean is3G(Context paramContext)
  {
    AppMethodBeat.i(157744);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(157744);
        return false;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(157744);
        return false;
      }
      Log.d("MicroMsg.NetStatusUtil", "is3G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      if (paramContext.getSubtype() >= 5)
      {
        i = paramContext.getSubtype();
        if (i < 13)
        {
          AppMethodBeat.o(157744);
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157744);
    }
    return false;
  }
  
  public static boolean is4G(Context paramContext)
  {
    AppMethodBeat.i(157742);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(157742);
        return false;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(157742);
        return false;
      }
      Log.d("MicroMsg.NetStatusUtil", "is4G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      if (paramContext.getSubtype() >= 13)
      {
        i = paramContext.getSubtype();
        if (i < 20)
        {
          AppMethodBeat.o(157742);
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157742);
    }
    return false;
  }
  
  public static boolean is5G(Context paramContext)
  {
    AppMethodBeat.i(230361);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(230361);
        return false;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(230361);
        return false;
      }
      Log.d("MicroMsg.NetStatusUtil", "is5G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      i = paramContext.getSubtype();
      if (i >= 20)
      {
        AppMethodBeat.o(230361);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(230361);
    }
    return false;
  }
  
  public static boolean isConnected(Context paramContext)
  {
    AppMethodBeat.i(157731);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(157731);
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    try
    {
      bool = paramContext.isConnected();
      AppMethodBeat.o(157731);
      return bool;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
  
  public static boolean isImmediatelyDestroyActivities(Context paramContext)
  {
    AppMethodBeat.i(230363);
    if (Settings.System.getInt(paramContext.getContentResolver(), "always_finish_activities", 0) != 0)
    {
      AppMethodBeat.o(230363);
      return true;
    }
    AppMethodBeat.o(230363);
    return false;
  }
  
  public static boolean isKnownDirectNet(Context paramContext)
  {
    AppMethodBeat.i(230365);
    int i = getNetType(paramContext);
    if ((6 == i) || (1 == i) || (4 == i) || (8 == i) || (10 == i) || (i == 0))
    {
      AppMethodBeat.o(230365);
      return true;
    }
    AppMethodBeat.o(230365);
    return false;
  }
  
  public static boolean isLimited(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1) || (paramInt == 3);
  }
  
  public static boolean isMobile(Context paramContext)
  {
    AppMethodBeat.i(157740);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(157740);
        return false;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(157740);
        return false;
      }
      AppMethodBeat.o(157740);
      return true;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157740);
    }
    return false;
  }
  
  public static boolean isMobileNetworkOpen(Context paramContext)
  {
    AppMethodBeat.i(230360);
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        Method localMethod = paramContext.getClass().getMethod("getMobileDataEnabled", new Class[0]);
        localMethod.setAccessible(true);
        boolean bool = ((Boolean)localMethod.invoke(paramContext, new Object[0])).booleanValue();
        AppMethodBeat.o(230360);
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(230360);
    }
    return false;
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    AppMethodBeat.i(157755);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(157755);
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(157755);
      return false;
    }
    if (paramContext.getState() != NetworkInfo.State.CONNECTED)
    {
      AppMethodBeat.o(157755);
      return false;
    }
    AppMethodBeat.o(157755);
    return true;
  }
  
  public static boolean isWap(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 5) || (paramInt == 7) || (paramInt == 3);
  }
  
  public static boolean isWap(Context paramContext)
  {
    AppMethodBeat.i(157743);
    boolean bool = isWap(getNetType(paramContext));
    AppMethodBeat.o(157743);
    return bool;
  }
  
  public static boolean isWifi(int paramInt)
  {
    return paramInt == 0;
  }
  
  public static boolean isWifi(Context paramContext)
  {
    AppMethodBeat.i(157745);
    boolean bool = isWifi(getNetType(paramContext));
    AppMethodBeat.o(157745);
    return bool;
  }
  
  public static boolean isWifiOr4G(Context paramContext)
  {
    AppMethodBeat.i(157757);
    int i = getNetType(paramContext);
    if ((i == 0) || (i == 10))
    {
      Log.d("MicroMsg.NetStatusUtil", "[cpan] is wifi or 4g network");
      AppMethodBeat.o(157757);
      return true;
    }
    Log.d("MicroMsg.NetStatusUtil", "[cpan] is mobile network");
    AppMethodBeat.o(157757);
    return false;
  }
  
  public static String removeSsidQuote(String paramString)
  {
    AppMethodBeat.i(157753);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157753);
      return "";
    }
    if (paramString.equals("<unknown ssid>"))
    {
      AppMethodBeat.o(157753);
      return "";
    }
    String str = paramString;
    if (paramString.startsWith("\""))
    {
      str = paramString;
      if (paramString.endsWith("\"")) {
        str = paramString.substring(1, paramString.length() - 1);
      }
    }
    AppMethodBeat.o(157753);
    return str;
  }
  
  private static Intent searchIntentByClass(Context paramContext, String paramString)
  {
    AppMethodBeat.i(157747);
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      List localList = localPackageManager.getInstalledPackages(0);
      if ((localList != null) && (localList.size() > 0))
      {
        Log.e("MicroMsg.NetStatusUtil", "package  size" + localList.size());
        int i = 0;
        for (;;)
        {
          int j = localList.size();
          if (i >= j) {
            break label418;
          }
          try
          {
            Log.e("MicroMsg.NetStatusUtil", "package " + ((PackageInfo)localList.get(i)).packageName);
            Object localObject1 = new Intent();
            ((Intent)localObject1).setPackage(((PackageInfo)localList.get(i)).packageName);
            Object localObject2 = localPackageManager.queryIntentActivities((Intent)localObject1, 0);
            if (localObject2 != null) {
              j = ((List)localObject2).size();
            }
            for (;;)
            {
              if (j > 0) {
                try
                {
                  Log.e("MicroMsg.NetStatusUtil", "activityName count ".concat(String.valueOf(j)));
                  int k = 0;
                  for (;;)
                  {
                    if (k >= j) {
                      break label380;
                    }
                    localObject1 = ((ResolveInfo)((List)localObject2).get(k)).activityInfo;
                    if (((ActivityInfo)localObject1).name.contains(paramString))
                    {
                      localObject2 = new Intent("/");
                      ((Intent)localObject2).setComponent(new ComponentName(((ActivityInfo)localObject1).packageName, ((ActivityInfo)localObject1).name));
                      ((Intent)localObject2).setAction("android.intent.action.VIEW");
                      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
                      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "searchIntentByClass", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
                      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "searchIntentByClass", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      AppMethodBeat.o(157747);
                      return localObject2;
                      j = 0;
                      break;
                    }
                    k += 1;
                  }
                  i += 1;
                }
                catch (Exception localException1)
                {
                  Log.printErrStackTrace("MicroMsg.NetStatusUtil", localException1, "", new Object[0]);
                }
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              label380:
              Log.printErrStackTrace("MicroMsg.NetStatusUtil", localException2, "", new Object[0]);
            }
          }
        }
      }
      label418:
      return null;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157747);
    }
  }
  
  public static void startSettingItent(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(157748);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(157748);
      return;
      AppMethodBeat.o(157748);
      return;
      try
      {
        Object localObject1 = new Intent("/");
        ((Intent)localObject1).setComponent(new ComponentName("com.android.providers.subscribedfeeds", "com.android.settings.ManageAccountsSettings"));
        ((Intent)localObject1).setAction("android.intent.action.VIEW");
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(157748);
        return;
      }
      catch (Exception localException1)
      {
        try
        {
          Object localObject2 = new Intent("/");
          ((Intent)localObject2).setComponent(new ComponentName("com.htc.settings.accountsync", "com.htc.settings.accountsync.ManageAccountsSettings"));
          ((Intent)localObject2).setAction("android.intent.action.VIEW");
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(157748);
          return;
        }
        catch (Exception localException2)
        {
          searchIntentByClass(paramContext, "ManageAccountsSettings");
          AppMethodBeat.o(157748);
          return;
        }
      }
      try
      {
        Object localObject3 = new Intent("/");
        ((Intent)localObject3).setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
        ((Intent)localObject3).setAction("android.intent.action.VIEW");
        localObject3 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject3);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject3).axQ(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(157748);
        return;
      }
      catch (Exception localException3)
      {
        searchIntentByClass(paramContext, "DevelopmentSettings");
        AppMethodBeat.o(157748);
        return;
      }
      try
      {
        Object localObject4 = new Intent();
        ((Intent)localObject4).setAction("android.settings.WIFI_IP_SETTINGS");
        localObject4 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject4);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject4).axQ(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject4).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(157748);
        return;
      }
      catch (Exception localException4)
      {
        searchIntentByClass(paramContext, "AdvancedSettings");
      }
    }
  }
  
  public static class CellInfo
  {
    public static final int MAX_CID = 65535;
    public static final int MAX_LAC = 65535;
    public String cellid;
    public String dbm;
    public String lac;
    public String mcc;
    public String mnc;
    public String networkId;
    public String stationId;
    public String systemId;
    public String type;
    
    public CellInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      this.mcc = paramString1;
      this.mnc = paramString2;
      this.lac = paramString3;
      this.type = paramString6;
      this.cellid = paramString4;
      this.stationId = paramString7;
      this.networkId = paramString8;
      this.systemId = paramString9;
      this.dbm = paramString5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.NetStatusUtil
 * JD-Core Version:    0.7.0.1
 */