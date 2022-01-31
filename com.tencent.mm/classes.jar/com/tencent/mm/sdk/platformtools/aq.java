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
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;
import java.util.List;

public final class aq
{
  private static int lqh = -1;
  private static int nowStrength;
  private static PhoneStateListener uhc = null;
  private static int uhd = 10000;
  
  static
  {
    nowStrength = 10000;
  }
  
  public static String fG(Context paramContext)
  {
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
      y.i("MicroMsg.NetStatusUtil", "netstatus " + localStringBuilder.toString());
      return localStringBuilder.toString();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        y.i("MicroMsg.NetStatusUtil", paramContext.getMessage());
        y.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      }
    }
  }
  
  public static String fH(Context paramContext)
  {
    if (is2G(paramContext)) {
      return "2G";
    }
    if (is3G(paramContext)) {
      return "3G";
    }
    if (is4G(paramContext)) {
      return "4G";
    }
    if (isWifi(paramContext)) {
      return "WIFI";
    }
    return getNetTypeString(paramContext);
  }
  
  public static int fI(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {
        return 0;
      }
      if (paramContext.getType() == 1) {
        return 1;
      }
      if ((paramContext.getSubtype() == 1) || (paramContext.getSubtype() == 2)) {
        break label74;
      }
      if (paramContext.getSubtype() >= 13) {
        return 4;
      }
      int i = paramContext.getSubtype();
      if (i >= 3) {
        return 3;
      }
    }
    catch (Exception paramContext) {}
    return 0;
    label74:
    return 2;
  }
  
  public static int fJ(Context paramContext)
  {
    try
    {
      int i = getNetType(paramContext);
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {
        return 0;
      }
      if (paramContext.getType() == 1) {
        return 1;
      }
      if ((paramContext.getSubtype() == 1) || (paramContext.getSubtype() == 2)) {
        break label88;
      }
      if (paramContext.getSubtype() >= 13) {
        return 5;
      }
      if (paramContext.getSubtype() >= 3) {
        return 4;
      }
      boolean bool = isWap(i);
      if (bool) {
        return 2;
      }
    }
    catch (Exception paramContext) {}
    return 0;
    label88:
    return 3;
  }
  
  public static boolean fK(Context paramContext)
  {
    int i = getNetType(paramContext);
    if ((i == 0) || (i == 10))
    {
      y.d("MicroMsg.NetStatusUtil", "[cpan] is wifi or 4g network");
      return true;
    }
    y.d("MicroMsg.NetStatusUtil", "[cpan] is mobile network");
    return false;
  }
  
  public static void fL(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      lqh = paramContext.getPhoneType();
      if (uhc == null)
      {
        uhc = new PhoneStateListener()
        {
          public final void onSignalStrengthsChanged(SignalStrength paramAnonymousSignalStrength)
          {
            super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
            if (aq.lqh == 2) {
              aq.pF(paramAnonymousSignalStrength.getCdmaDbm());
            }
            if (aq.lqh == 1) {
              aq.pF(paramAnonymousSignalStrength.getGsmSignalStrength() * 2 - 113);
            }
            y.i("MicroMsg.NetStatusUtil", "PhoneStateListener  type:%d  strength:%d", new Object[] { Integer.valueOf(aq.lqh), Integer.valueOf(aq.nowStrength) });
          }
        };
        paramContext.listen(uhc, 256);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  public static List<a> fM(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 19	com/tencent/mm/sdk/platformtools/aq:uhc	Landroid/telephony/PhoneStateListener;
    //   6: ifnonnull +17 -> 23
    //   9: ldc 140
    //   11: ldc 205
    //   13: invokestatic 208	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aconst_null
    //   17: astore_0
    //   18: ldc 2
    //   20: monitorexit
    //   21: aload_0
    //   22: areturn
    //   23: aload_0
    //   24: ldc 191
    //   26: invokevirtual 46	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   29: checkcast 193	android/telephony/TelephonyManager
    //   32: astore 7
    //   34: new 210	java/util/LinkedList
    //   37: dup
    //   38: invokespecial 211	java/util/LinkedList:<init>	()V
    //   41: astore 4
    //   43: ldc 213
    //   45: astore 5
    //   47: ldc 153
    //   49: astore 6
    //   51: aload 7
    //   53: invokevirtual 216	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull +177 -> 235
    //   61: aload_3
    //   62: ldc 153
    //   64: invokevirtual 222	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifne +168 -> 235
    //   70: aload_3
    //   71: iconst_0
    //   72: iconst_3
    //   73: invokevirtual 226	java/lang/String:substring	(II)Ljava/lang/String;
    //   76: astore_0
    //   77: aload_3
    //   78: iconst_3
    //   79: iconst_5
    //   80: invokevirtual 226	java/lang/String:substring	(II)Ljava/lang/String;
    //   83: astore_3
    //   84: aload 7
    //   86: invokevirtual 196	android/telephony/TelephonyManager:getPhoneType	()I
    //   89: istore_1
    //   90: iload_1
    //   91: iconst_2
    //   92: if_icmpne +516 -> 608
    //   95: aload 7
    //   97: invokevirtual 230	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   100: checkcast 232	android/telephony/cdma/CdmaCellLocation
    //   103: astore 6
    //   105: aload 6
    //   107: ifnull +122 -> 229
    //   110: getstatic 23	com/tencent/mm/sdk/platformtools/aq:nowStrength	I
    //   113: getstatic 21	com/tencent/mm/sdk/platformtools/aq:uhd	I
    //   116: if_icmpne +191 -> 307
    //   119: ldc 153
    //   121: astore 5
    //   123: aload 6
    //   125: invokevirtual 235	android/telephony/cdma/CdmaCellLocation:getBaseStationId	()I
    //   128: iconst_m1
    //   129: if_icmpeq +100 -> 229
    //   132: aload 6
    //   134: invokevirtual 238	android/telephony/cdma/CdmaCellLocation:getNetworkId	()I
    //   137: iconst_m1
    //   138: if_icmpeq +91 -> 229
    //   141: aload 6
    //   143: invokevirtual 241	android/telephony/cdma/CdmaCellLocation:getSystemId	()I
    //   146: iconst_m1
    //   147: if_icmpeq +82 -> 229
    //   150: aload 4
    //   152: new 8	com/tencent/mm/sdk/platformtools/aq$a
    //   155: dup
    //   156: aload_0
    //   157: aload_3
    //   158: ldc 153
    //   160: ldc 153
    //   162: aload 5
    //   164: ldc 243
    //   166: new 35	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   173: aload 6
    //   175: invokevirtual 235	android/telephony/cdma/CdmaCellLocation:getBaseStationId	()I
    //   178: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   181: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: new 35	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   191: aload 6
    //   193: invokevirtual 238	android/telephony/cdma/CdmaCellLocation:getNetworkId	()I
    //   196: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: new 35	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   209: aload 6
    //   211: invokevirtual 241	android/telephony/cdma/CdmaCellLocation:getSystemId	()I
    //   214: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokespecial 246	com/tencent/mm/sdk/platformtools/aq$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   223: invokeinterface 251 2 0
    //   228: pop
    //   229: aload 4
    //   231: astore_0
    //   232: goto -214 -> 18
    //   235: aload 7
    //   237: invokevirtual 254	android/telephony/TelephonyManager:getSimOperator	()Ljava/lang/String;
    //   240: astore 8
    //   242: aload 6
    //   244: astore_3
    //   245: aload 5
    //   247: astore_0
    //   248: aload 8
    //   250: ifnull +35 -> 285
    //   253: aload 6
    //   255: astore_3
    //   256: aload 5
    //   258: astore_0
    //   259: aload 8
    //   261: ldc 153
    //   263: invokevirtual 222	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   266: ifne +19 -> 285
    //   269: aload 8
    //   271: iconst_0
    //   272: iconst_3
    //   273: invokevirtual 226	java/lang/String:substring	(II)Ljava/lang/String;
    //   276: astore_0
    //   277: aload 8
    //   279: iconst_3
    //   280: iconst_5
    //   281: invokevirtual 226	java/lang/String:substring	(II)Ljava/lang/String;
    //   284: astore_3
    //   285: goto -201 -> 84
    //   288: astore_0
    //   289: ldc 140
    //   291: aload_0
    //   292: ldc 153
    //   294: iconst_0
    //   295: anewarray 4	java/lang/Object
    //   298: invokestatic 157	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: aload 4
    //   303: astore_0
    //   304: goto -286 -> 18
    //   307: new 35	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   314: getstatic 23	com/tencent/mm/sdk/platformtools/aq:nowStrength	I
    //   317: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: astore 5
    //   325: goto -202 -> 123
    //   328: astore 5
    //   330: aload 7
    //   332: invokevirtual 230	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   335: checkcast 256	android/telephony/gsm/GsmCellLocation
    //   338: astore 5
    //   340: aload 5
    //   342: ifnull +68 -> 410
    //   345: aload 5
    //   347: invokevirtual 259	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   350: istore_1
    //   351: aload 5
    //   353: invokevirtual 262	android/telephony/gsm/GsmCellLocation:getLac	()I
    //   356: istore_2
    //   357: iload_2
    //   358: ldc_w 263
    //   361: if_icmpge +49 -> 410
    //   364: iload_2
    //   365: iconst_m1
    //   366: if_icmpeq +44 -> 410
    //   369: iload_1
    //   370: iconst_m1
    //   371: if_icmpeq +39 -> 410
    //   374: aload 4
    //   376: new 8	com/tencent/mm/sdk/platformtools/aq$a
    //   379: dup
    //   380: aload_0
    //   381: aload_3
    //   382: iload_2
    //   383: invokestatic 267	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   386: iload_1
    //   387: invokestatic 267	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   390: ldc 153
    //   392: ldc_w 269
    //   395: ldc 153
    //   397: ldc 153
    //   399: ldc 153
    //   401: invokespecial 246	com/tencent/mm/sdk/platformtools/aq$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   404: invokeinterface 251 2 0
    //   409: pop
    //   410: aload 7
    //   412: invokevirtual 273	android/telephony/TelephonyManager:getNeighboringCellInfo	()Ljava/util/List;
    //   415: astore 5
    //   417: aload 5
    //   419: ifnull -190 -> 229
    //   422: aload 5
    //   424: invokeinterface 276 1 0
    //   429: ifle -200 -> 229
    //   432: aload 5
    //   434: invokeinterface 280 1 0
    //   439: astore 5
    //   441: aload 5
    //   443: invokeinterface 285 1 0
    //   448: ifeq -219 -> 229
    //   451: aload 5
    //   453: invokeinterface 289 1 0
    //   458: checkcast 291	android/telephony/NeighboringCellInfo
    //   461: astore 6
    //   463: aload 6
    //   465: invokevirtual 292	android/telephony/NeighboringCellInfo:getCid	()I
    //   468: iconst_m1
    //   469: if_icmpeq -28 -> 441
    //   472: aload 6
    //   474: invokevirtual 293	android/telephony/NeighboringCellInfo:getLac	()I
    //   477: ldc_w 263
    //   480: if_icmpgt -39 -> 441
    //   483: aload 6
    //   485: invokevirtual 293	android/telephony/NeighboringCellInfo:getLac	()I
    //   488: iconst_m1
    //   489: if_icmpeq -48 -> 441
    //   492: new 35	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   499: aload 6
    //   501: invokevirtual 296	android/telephony/NeighboringCellInfo:getRssi	()I
    //   504: iconst_2
    //   505: imul
    //   506: bipush 113
    //   508: isub
    //   509: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   512: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: astore 7
    //   517: aload 4
    //   519: new 8	com/tencent/mm/sdk/platformtools/aq$a
    //   522: dup
    //   523: aload_0
    //   524: aload_3
    //   525: new 35	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   532: aload 6
    //   534: invokevirtual 293	android/telephony/NeighboringCellInfo:getLac	()I
    //   537: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   540: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: new 35	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   550: aload 6
    //   552: invokevirtual 292	android/telephony/NeighboringCellInfo:getCid	()I
    //   555: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   558: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: aload 7
    //   563: ldc_w 269
    //   566: ldc 153
    //   568: ldc 153
    //   570: ldc 153
    //   572: invokespecial 246	com/tencent/mm/sdk/platformtools/aq$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   575: invokeinterface 251 2 0
    //   580: pop
    //   581: goto -140 -> 441
    //   584: astore_0
    //   585: ldc 2
    //   587: monitorexit
    //   588: aload_0
    //   589: athrow
    //   590: astore 5
    //   592: ldc 140
    //   594: aload 5
    //   596: ldc 153
    //   598: iconst_0
    //   599: anewarray 4	java/lang/Object
    //   602: invokestatic 157	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   605: goto -195 -> 410
    //   608: aload 7
    //   610: invokevirtual 230	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   613: checkcast 256	android/telephony/gsm/GsmCellLocation
    //   616: astore 5
    //   618: aload 5
    //   620: ifnull +81 -> 701
    //   623: aload 5
    //   625: invokevirtual 259	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   628: istore_1
    //   629: aload 5
    //   631: invokevirtual 262	android/telephony/gsm/GsmCellLocation:getLac	()I
    //   634: istore_2
    //   635: iload_2
    //   636: ldc_w 263
    //   639: if_icmpge +62 -> 701
    //   642: iload_2
    //   643: iconst_m1
    //   644: if_icmpeq +57 -> 701
    //   647: iload_1
    //   648: iconst_m1
    //   649: if_icmpeq +52 -> 701
    //   652: getstatic 23	com/tencent/mm/sdk/platformtools/aq:nowStrength	I
    //   655: getstatic 21	com/tencent/mm/sdk/platformtools/aq:uhd	I
    //   658: if_icmpne +260 -> 918
    //   661: ldc 153
    //   663: astore 5
    //   665: aload 4
    //   667: new 8	com/tencent/mm/sdk/platformtools/aq$a
    //   670: dup
    //   671: aload_0
    //   672: aload_3
    //   673: iload_2
    //   674: invokestatic 267	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   677: iload_1
    //   678: invokestatic 267	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   681: aload 5
    //   683: ldc_w 269
    //   686: ldc 153
    //   688: ldc 153
    //   690: ldc 153
    //   692: invokespecial 246	com/tencent/mm/sdk/platformtools/aq$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   695: invokeinterface 251 2 0
    //   700: pop
    //   701: aload 7
    //   703: invokevirtual 273	android/telephony/TelephonyManager:getNeighboringCellInfo	()Ljava/util/List;
    //   706: astore 5
    //   708: aload 5
    //   710: ifnull -481 -> 229
    //   713: aload 5
    //   715: invokeinterface 276 1 0
    //   720: ifle -491 -> 229
    //   723: aload 5
    //   725: invokeinterface 280 1 0
    //   730: astore 5
    //   732: aload 5
    //   734: invokeinterface 285 1 0
    //   739: ifeq -510 -> 229
    //   742: aload 5
    //   744: invokeinterface 289 1 0
    //   749: checkcast 291	android/telephony/NeighboringCellInfo
    //   752: astore 6
    //   754: aload 6
    //   756: invokevirtual 292	android/telephony/NeighboringCellInfo:getCid	()I
    //   759: iconst_m1
    //   760: if_icmpeq -28 -> 732
    //   763: aload 6
    //   765: invokevirtual 293	android/telephony/NeighboringCellInfo:getLac	()I
    //   768: ldc_w 263
    //   771: if_icmpgt -39 -> 732
    //   774: new 35	java/lang/StringBuilder
    //   777: dup
    //   778: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   781: aload 6
    //   783: invokevirtual 296	android/telephony/NeighboringCellInfo:getRssi	()I
    //   786: iconst_2
    //   787: imul
    //   788: bipush 113
    //   790: isub
    //   791: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   794: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   797: astore 7
    //   799: ldc_w 298
    //   802: new 35	java/lang/StringBuilder
    //   805: dup
    //   806: ldc_w 300
    //   809: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   812: aload 6
    //   814: invokevirtual 293	android/telephony/NeighboringCellInfo:getLac	()I
    //   817: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   820: ldc_w 302
    //   823: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: aload 6
    //   828: invokevirtual 292	android/telephony/NeighboringCellInfo:getCid	()I
    //   831: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   834: ldc_w 304
    //   837: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: aload 7
    //   842: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   848: invokestatic 307	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   851: aload 4
    //   853: new 8	com/tencent/mm/sdk/platformtools/aq$a
    //   856: dup
    //   857: aload_0
    //   858: aload_3
    //   859: new 35	java/lang/StringBuilder
    //   862: dup
    //   863: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   866: aload 6
    //   868: invokevirtual 293	android/telephony/NeighboringCellInfo:getLac	()I
    //   871: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   874: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   877: new 35	java/lang/StringBuilder
    //   880: dup
    //   881: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   884: aload 6
    //   886: invokevirtual 292	android/telephony/NeighboringCellInfo:getCid	()I
    //   889: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   892: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   895: aload 7
    //   897: ldc_w 269
    //   900: ldc 153
    //   902: ldc 153
    //   904: ldc 153
    //   906: invokespecial 246	com/tencent/mm/sdk/platformtools/aq$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   909: invokeinterface 251 2 0
    //   914: pop
    //   915: goto -183 -> 732
    //   918: new 35	java/lang/StringBuilder
    //   921: dup
    //   922: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   925: getstatic 23	com/tencent/mm/sdk/platformtools/aq:nowStrength	I
    //   928: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   931: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   934: astore 5
    //   936: goto -271 -> 665
    //   939: astore 5
    //   941: ldc 140
    //   943: aload 5
    //   945: ldc 153
    //   947: iconst_0
    //   948: anewarray 4	java/lang/Object
    //   951: invokestatic 157	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   954: goto -253 -> 701
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	957	0	paramContext	Context
    //   89	589	1	i	int
    //   356	318	2	j	int
    //   56	803	3	localObject1	Object
    //   41	811	4	localLinkedList	java.util.LinkedList
    //   45	279	5	str1	String
    //   328	1	5	localException1	Exception
    //   338	114	5	localObject2	Object
    //   590	5	5	localException2	Exception
    //   616	319	5	localObject3	Object
    //   939	5	5	localException3	Exception
    //   49	836	6	localObject4	Object
    //   32	864	7	localObject5	Object
    //   240	38	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   51	57	288	java/lang/Exception
    //   61	84	288	java/lang/Exception
    //   235	242	288	java/lang/Exception
    //   259	285	288	java/lang/Exception
    //   95	105	328	java/lang/Exception
    //   110	119	328	java/lang/Exception
    //   123	229	328	java/lang/Exception
    //   307	325	328	java/lang/Exception
    //   3	16	584	finally
    //   23	43	584	finally
    //   51	57	584	finally
    //   61	84	584	finally
    //   84	90	584	finally
    //   95	105	584	finally
    //   110	119	584	finally
    //   123	229	584	finally
    //   235	242	584	finally
    //   259	285	584	finally
    //   289	301	584	finally
    //   307	325	584	finally
    //   330	340	584	finally
    //   345	357	584	finally
    //   374	410	584	finally
    //   410	417	584	finally
    //   422	441	584	finally
    //   441	581	584	finally
    //   592	605	584	finally
    //   608	618	584	finally
    //   623	635	584	finally
    //   652	661	584	finally
    //   665	701	584	finally
    //   701	708	584	finally
    //   713	732	584	finally
    //   732	915	584	finally
    //   918	936	584	finally
    //   941	954	584	finally
    //   330	340	590	java/lang/Exception
    //   345	357	590	java/lang/Exception
    //   374	410	590	java/lang/Exception
    //   608	618	939	java/lang/Exception
    //   623	635	939	java/lang/Exception
    //   652	661	939	java/lang/Exception
    //   665	701	939	java/lang/Exception
    //   918	936	939	java/lang/Exception
  }
  
  public static int getBackgroundLimitType(Context paramContext)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        Object localObject = Class.forName("android.app.ActivityManagerNative");
        localObject = ((Class)localObject).getMethod("getDefault", new Class[0]).invoke(localObject, new Object[0]);
        i = ((Integer)localObject.getClass().getMethod("getProcessLimit", new Class[0]).invoke(localObject, new Object[0])).intValue();
        if (i == 0) {
          return 1;
        }
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.NetStatusUtil", localException, "", new Object[0]);
      }
    }
    try
    {
      i = Settings.System.getInt(paramContext.getContentResolver(), "wifi_sleep_policy", 2);
      if (i != 2)
      {
        int j = getNetType(paramContext);
        if (j == 0) {}
      }
      else
      {
        return 0;
      }
      if ((i == 1) || (i == 0)) {
        return 3;
      }
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
    }
    return 0;
  }
  
  public static int getISPCode(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return 0;
    }
    paramContext = paramContext.getSimOperator();
    if ((paramContext == null) || (paramContext.length() < 5)) {
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
          break label129;
        }
        i = 6;
      }
      catch (Exception paramContext)
      {
        y.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
        return 0;
      }
      if (j < i) {
        if (!Character.isDigit(paramContext.charAt(j)))
        {
          if (localStringBuilder.length() <= 0) {
            break label134;
          }
        }
        else
        {
          localStringBuilder.append(paramContext.charAt(j));
          break label134;
        }
      }
      int i = Integer.valueOf(localStringBuilder.toString()).intValue();
      return i;
      label129:
      int j = 0;
      continue;
      label134:
      j += 1;
    }
  }
  
  public static String getISPName(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        return "";
      }
      y.d("MicroMsg.NetStatusUtil", "getISPName ISPName=%s", new Object[] { paramContext.getSimOperatorName() });
      if (paramContext.getSimOperatorName().length() <= 100) {
        return paramContext.getSimOperatorName();
      }
      paramContext = paramContext.getSimOperatorName().substring(0, 100);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static int getNetType(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return -1;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return -1;
    }
    if (paramContext.getType() == 1) {
      return 0;
    }
    y.d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", new Object[] { paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()) });
    if (paramContext.getExtraInfo() != null)
    {
      if (paramContext.getExtraInfo().equalsIgnoreCase("uninet")) {
        return 1;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("uniwap")) {
        return 2;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gwap")) {
        return 3;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gnet")) {
        return 4;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmwap")) {
        return 5;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmnet")) {
        return 6;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctwap")) {
        return 7;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctnet")) {
        return 8;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("LTE")) {
        return 10;
      }
    }
    return 9;
  }
  
  public static int getNetTypeForStat(Context paramContext)
  {
    if (paramContext == null) {
      return 999;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return 999;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        return 999;
      }
      if (paramContext.getType() == 1) {
        return 1;
      }
      int i = paramContext.getSubtype();
      if (i == 0) {
        return 999;
      }
      return i * 1000;
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
    }
    return 999;
  }
  
  public static String getNetTypeString(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return "NON_NETWORK";
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        return "NON_NETWORK";
      }
      if (paramContext.getType() == 1) {
        return "WIFI";
      }
      y.d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", new Object[] { paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()) });
      if (paramContext.getExtraInfo() != null)
      {
        paramContext = paramContext.getExtraInfo();
        return paramContext;
      }
      return "MOBILE";
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
    }
    return "NON_NETWORK";
  }
  
  public static int getNetWorkType(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        int i = paramContext.getType();
        return i;
      }
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
    }
    return -1;
  }
  
  public static int getStrength(Context paramContext)
  {
    int i;
    if (paramContext == null) {
      i = 0;
    }
    for (;;)
    {
      return i;
      try
      {
        if (getNetTypeForStat(paramContext) == 1)
        {
          i = Math.abs(((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getRssi());
          continue;
        }
        if (uhc == null) {
          y.e("MicroMsg.NetStatusUtil", "getStrength phone Listener has not been inited");
        }
        i = Math.abs(nowStrength);
      }
      catch (Exception paramContext)
      {
        y.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
        i = 0;
      }
      finally {}
    }
  }
  
  public static WifiInfo getWifiInfo(Context paramContext)
  {
    try
    {
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null) {
        return null;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject != null) && (1 == ((NetworkInfo)localObject).getType()))
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext == null) {
          return null;
        }
        paramContext = paramContext.getConnectionInfo();
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      return null;
    }
    return null;
  }
  
  public static boolean is2G(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {
        return false;
      }
      if (paramContext.getType() == 1) {
        return false;
      }
      y.d("MicroMsg.NetStatusUtil", "is2G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      if ((paramContext.getSubtype() != 2) && (paramContext.getSubtype() != 1))
      {
        int i = paramContext.getSubtype();
        if (i != 4) {}
      }
      else
      {
        return true;
      }
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
    }
    return false;
  }
  
  public static boolean is3G(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {
        return false;
      }
      if (paramContext.getType() == 1) {
        return false;
      }
      y.d("MicroMsg.NetStatusUtil", "is3G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      if (paramContext.getSubtype() >= 5)
      {
        int i = paramContext.getSubtype();
        if (i < 13) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
    }
    return false;
  }
  
  public static boolean is4G(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {
        return false;
      }
      if (paramContext.getType() == 1) {
        return false;
      }
      y.d("MicroMsg.NetStatusUtil", "is4G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      int i = paramContext.getSubtype();
      if (i >= 13) {
        return true;
      }
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
    }
    return false;
  }
  
  public static boolean isConnected(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    try
    {
      bool = paramContext.isConnected();
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
  
  public static boolean isLimited(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1) || (paramInt == 3);
  }
  
  public static boolean isMobile(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {
        return false;
      }
      int i = paramContext.getType();
      return i != 1;
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
    }
    return false;
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return false;
    }
    return paramContext.getState() == NetworkInfo.State.CONNECTED;
  }
  
  public static boolean isWap(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 5) || (paramInt == 7) || (paramInt == 3);
  }
  
  public static boolean isWap(Context paramContext)
  {
    return isWap(getNetType(paramContext));
  }
  
  public static boolean isWifi(int paramInt)
  {
    return paramInt == 0;
  }
  
  public static boolean isWifi(Context paramContext)
  {
    return getNetType(paramContext) == 0;
  }
  
  private static Intent searchIntentByClass(Context paramContext, String paramString)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      List localList = localPackageManager.getInstalledPackages(0);
      if ((localList != null) && (localList.size() > 0))
      {
        y.e("MicroMsg.NetStatusUtil", "package  size" + localList.size());
        int i = 0;
        for (;;)
        {
          int j = localList.size();
          if (i >= j) {
            break label343;
          }
          try
          {
            y.e("MicroMsg.NetStatusUtil", "package " + ((PackageInfo)localList.get(i)).packageName);
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
                  y.e("MicroMsg.NetStatusUtil", "activityName count " + j);
                  int k = 0;
                  for (;;)
                  {
                    if (k >= j) {
                      break label305;
                    }
                    localObject1 = ((ResolveInfo)((List)localObject2).get(k)).activityInfo;
                    if (((ActivityInfo)localObject1).name.contains(paramString))
                    {
                      localObject2 = new Intent("/");
                      ((Intent)localObject2).setComponent(new ComponentName(((ActivityInfo)localObject1).packageName, ((ActivityInfo)localObject1).name));
                      ((Intent)localObject2).setAction("android.intent.action.VIEW");
                      paramContext.startActivity((Intent)localObject2);
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
                  y.printErrStackTrace("MicroMsg.NetStatusUtil", localException1, "", new Object[0]);
                }
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              label305:
              y.printErrStackTrace("MicroMsg.NetStatusUtil", localException2, "", new Object[0]);
            }
          }
        }
      }
      return null;
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
    }
  }
  
  public static void startSettingItent(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case 2: 
      try
      {
        Intent localIntent1 = new Intent("/");
        localIntent1.setComponent(new ComponentName("com.android.providers.subscribedfeeds", "com.android.settings.ManageAccountsSettings"));
        localIntent1.setAction("android.intent.action.VIEW");
        paramContext.startActivity(localIntent1);
        return;
      }
      catch (Exception localException1)
      {
        try
        {
          Intent localIntent2 = new Intent("/");
          localIntent2.setComponent(new ComponentName("com.htc.settings.accountsync", "com.htc.settings.accountsync.ManageAccountsSettings"));
          localIntent2.setAction("android.intent.action.VIEW");
          paramContext.startActivity(localIntent2);
          return;
        }
        catch (Exception localException2)
        {
          searchIntentByClass(paramContext, "ManageAccountsSettings");
          return;
        }
      }
    case 1: 
      try
      {
        Intent localIntent3 = new Intent("/");
        localIntent3.setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
        localIntent3.setAction("android.intent.action.VIEW");
        paramContext.startActivity(localIntent3);
        return;
      }
      catch (Exception localException3)
      {
        searchIntentByClass(paramContext, "DevelopmentSettings");
        return;
      }
    }
    try
    {
      Intent localIntent4 = new Intent();
      localIntent4.setAction("android.settings.WIFI_IP_SETTINGS");
      paramContext.startActivity(localIntent4);
      return;
    }
    catch (Exception localException4)
    {
      searchIntentByClass(paramContext, "AdvancedSettings");
    }
  }
  
  public static final class a
  {
    public String mdQ;
    public String mdR;
    public String mdS;
    public String qvN;
    public String qvP;
    public String qvQ;
    public String qvR;
    public String systemId;
    public String type;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      this.mdQ = paramString1;
      this.mdR = paramString2;
      this.qvN = paramString3;
      this.type = paramString6;
      this.mdS = paramString4;
      this.qvP = paramString7;
      this.qvQ = paramString8;
      this.systemId = paramString9;
      this.qvR = paramString5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.aq
 * JD-Core Version:    0.7.0.1
 */