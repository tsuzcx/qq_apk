package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.WiFiScanResult;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;

public final class k
{
  private static k.b OPR;
  private static k OPS;
  private static bd OPT = null;
  private static long OPU = 0L;
  public JSONArray OPV;
  
  private k()
  {
    AppMethodBeat.i(70283);
    h.aHH();
    String str = (String)h.aHG().aHp().get(ar.a.Vlv, "");
    Log.i("MicroMsg.GpsReportHelper", "GpsReportHelper ".concat(String.valueOf(str)));
    if (!Util.isNullOrNil(str)) {
      try
      {
        this.OPV = new JSONArray(str);
        AppMethodBeat.o(70283);
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.printErrStackTrace("MicroMsg.GpsReportHelper", localJSONException, "", new Object[0]);
        Log.e("MicroMsg.GpsReportHelper", "parse lbs config error", new Object[] { localJSONException });
      }
    }
    AppMethodBeat.o(70283);
  }
  
  private static String Mc(String paramString)
  {
    AppMethodBeat.i(70288);
    try
    {
      String str = com.tencent.mm.compatible.util.q.an(paramString, "UTF-8");
      paramString = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.GpsReportHelper", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(70288);
    return paramString;
  }
  
  public static bd aT(Map<String, String> paramMap)
  {
    AppMethodBeat.i(70289);
    Object localObject1 = new ArrayList();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      localObject2 = (Map.Entry)paramMap.next();
      ((ArrayList)localObject1).add((String)((Map.Entry)localObject2).getKey() + "=" + (String)((Map.Entry)localObject2).getValue());
    }
    Object localObject2 = TextUtils.join("&", (Iterable)localObject1);
    byte[] arrayOfByte = new byte[16];
    localObject1 = y.iiR().getBytes();
    if (localObject1 != null)
    {
      paramMap = (Map<String, String>)localObject1;
      if (localObject1.length > 0) {}
    }
    else
    {
      paramMap = System.currentTimeMillis().getBytes();
    }
    int j = 0;
    int i = 0;
    int k;
    do
    {
      arrayOfByte[i] = paramMap[j];
      k = i + 1;
      j += 1;
      i = j;
      if (j >= paramMap.length) {
        i = 0;
      }
      j = i;
      i = k;
    } while (k < 16);
    paramMap = new bd();
    localObject1 = Base64.encode(arrayOfByte, 0);
    paramMap.RFY = o.gJg().cI((byte[])localObject1);
    paramMap.RFX = new String(Base64.encode(AesEcb.aesCryptEcb(((String)localObject2).getBytes(), arrayOfByte, true, true), 0));
    AppMethodBeat.o(70289);
    return paramMap;
  }
  
  public static void amw(int paramInt)
  {
    AppMethodBeat.i(70291);
    Log.i("MicroMsg.GpsReportHelper", "reflashLocationInfo ".concat(String.valueOf(paramInt)));
    OPU = System.currentTimeMillis() / 1000L;
    if (!shouldReportLocation())
    {
      OPR = null;
      gJd();
      OPU = System.currentTimeMillis() / 1000L;
    }
    AppMethodBeat.o(70291);
  }
  
  public static dji eUT()
  {
    AppMethodBeat.i(70294);
    if (OPT == null)
    {
      AppMethodBeat.o(70294);
      return null;
    }
    dji localdji = new dji();
    localdji.city = OPT.city;
    localdji.province = OPT.province;
    localdji.latitude = OPT.latitude;
    localdji.longitude = OPT.longitude;
    localdji.RFU = OPT.RFU;
    localdji.RFY = OPT.RFY;
    localdji.RFV = OPT.RFV;
    localdji.RFW = OPT.RFW;
    localdji.RFX = OPT.RFX;
    AppMethodBeat.o(70294);
    return localdji;
  }
  
  public static k gIZ()
  {
    AppMethodBeat.i(70284);
    if (OPS == null) {
      OPS = new k();
    }
    k localk = OPS;
    AppMethodBeat.o(70284);
    return localk;
  }
  
  private static String gJa()
  {
    AppMethodBeat.i(70285);
    long l = System.currentTimeMillis();
    Object localObject = new StringBuffer();
    try
    {
      if (MMApplicationContext.getContext() == null)
      {
        AppMethodBeat.o(70285);
        return "";
      }
      new StringBuffer();
      new StringBuffer();
      localIterator = ConnectivityCompat.Companion.getWiFiScanResults().iterator();
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Iterator localIterator;
        int i;
        ConnectivityCompat.WiFiScanResult localWiFiScanResult;
        Log.printErrStackTrace("MicroMsg.GpsReportHelper", localException, "", new Object[0]);
      }
    }
    if (localIterator.hasNext())
    {
      localWiFiScanResult = (ConnectivityCompat.WiFiScanResult)localIterator.next();
      ((StringBuffer)localObject).append(String.format("&scan_ssid%d=%s&scan_bssid%d=%s&sm%d=%s", new Object[] { Integer.valueOf(i), Mc(localWiFiScanResult.getSsid()), Integer.valueOf(i), Mc(localWiFiScanResult.getBssid()), Integer.valueOf(i), Integer.valueOf(localWiFiScanResult.getLevel()) }));
      i += 1;
      if (i < 5) {}
    }
    else
    {
      Log.e("MicroMsg.GpsReportHelper", "RecordCostTime: readScanWifi cost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(70285);
      return localObject;
    }
  }
  
  private static String gJb()
  {
    AppMethodBeat.i(70286);
    long l1 = System.currentTimeMillis();
    Object localObject1 = new HashMap();
    if (!shouldReportCellInfo())
    {
      AppMethodBeat.o(70286);
      return "";
    }
    ((HashMap)localObject1).put("is_ci_permitted", "0");
    ((HashMap)localObject1).put("net_type", NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()));
    Log.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 01- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    long l2 = System.currentTimeMillis();
    l1 = l2;
    if (gJc())
    {
      ((HashMap)localObject1).put("is_ci_permitted", "1");
      ((HashMap)localObject1).put("uuid", UUID.randomUUID().toString());
      ((HashMap)localObject1).put("sample_time", System.currentTimeMillis() / 1000L);
      ((HashMap)localObject1).put("phone_brand", Build.BRAND);
      ((HashMap)localObject1).put("phone_model", Build.MODEL);
    }
    try
    {
      if (MMApplicationContext.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)
      {
        localObject2 = ((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (localObject2 != null) {
          ((HashMap)localObject1).put("net_subtype", ((NetworkInfo)localObject2).getSubtype());
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      label239:
      int j;
      int i;
      Object localObject3;
      break label239;
    }
    Log.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 02- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
    l1 = System.currentTimeMillis();
    localObject2 = hu(MMApplicationContext.getContext());
    Log.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 03- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    l1 = System.currentTimeMillis();
    j = ((List)localObject2).size();
    i = 0;
    while (i < j)
    {
      localObject3 = (a)((List)localObject2).get(i);
      if (localObject3 != null)
      {
        ((HashMap)localObject1).put("mcc_".concat(String.valueOf(i)), ((a)localObject3).mcc);
        ((HashMap)localObject1).put("mnc_".concat(String.valueOf(i)), ((a)localObject3).mnc);
        ((HashMap)localObject1).put("lac_".concat(String.valueOf(i)), ((a)localObject3).lac);
        ((HashMap)localObject1).put("cell_id_".concat(String.valueOf(i)), ((a)localObject3).cellid);
        ((HashMap)localObject1).put("type_".concat(String.valueOf(i)), ((a)localObject3).type);
        ((HashMap)localObject1).put("sid_".concat(String.valueOf(i)), ((a)localObject3).stationId);
        ((HashMap)localObject1).put("net_id_".concat(String.valueOf(i)), ((a)localObject3).networkId);
        ((HashMap)localObject1).put("sys_id_".concat(String.valueOf(i)), ((a)localObject3).systemId);
        ((HashMap)localObject1).put("dbm_".concat(String.valueOf(i)), ((a)localObject3).dbm);
        ((HashMap)localObject1).put("tac_".concat(String.valueOf(i)), ((a)localObject3).OPW);
        ((HashMap)localObject1).put("arfcn_".concat(String.valueOf(i)), ((a)localObject3).OPZ);
        ((HashMap)localObject1).put("earfcn_".concat(String.valueOf(i)), ((a)localObject3).OPX);
        ((HashMap)localObject1).put("uarfcn_".concat(String.valueOf(i)), ((a)localObject3).OPY);
        ((HashMap)localObject1).put("dbm_".concat(String.valueOf(i)), ((a)localObject3).dbm);
      }
      i += 1;
    }
    ((HashMap)localObject1).put("count", String.valueOf(j));
    localObject2 = new StringBuilder("");
    localObject3 = ((HashMap)localObject1).keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str1 = (String)((Iterator)localObject3).next();
      String str2 = (String)((HashMap)localObject1).get(str1);
      if (!Util.isNullOrNil(str2)) {
        ((StringBuilder)localObject2).append(String.format("&%s=%s", new Object[] { str1, Mc(str2) }));
      }
    }
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = localObject2;
    if (!Util.isNullOrNil((String)localObject2))
    {
      localObject1 = localObject2;
      if (((String)localObject2).indexOf("&") == 0) {
        localObject1 = ((String)localObject2).substring(1);
      }
    }
    Log.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 03- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(70286);
    return localObject1;
  }
  
  private static boolean gJc()
  {
    AppMethodBeat.i(70287);
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(70287);
      return true;
    }
    try
    {
      int i = androidx.core.content.a.checkSelfPermission(MMApplicationContext.getContext(), "android.permission.ACCESS_FINE_LOCATION");
      if (i == 0)
      {
        AppMethodBeat.o(70287);
        return true;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.GpsReportHelper", "check permission exception:%s.", new Object[] { localException });
      AppMethodBeat.o(70287);
      return true;
    }
    AppMethodBeat.o(70287);
    return false;
  }
  
  private static void gJd()
  {
    AppMethodBeat.i(70292);
    long l = System.currentTimeMillis();
    if (shouldReportLocation())
    {
      AppMethodBeat.o(70292);
      return;
    }
    if ((gJf()) || (shouldReportCellInfo())) {
      localObject = "";
    }
    try
    {
      str1 = ConnectivityCompat.Companion.getWiFiRssi();
      localObject = str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        String str2;
        String str3;
        String str4;
        Log.printErrStackTrace("MicroMsg.GpsReportHelper", localException, "", new Object[0]);
        continue;
        localObject = null;
      }
    }
    str1 = ConnectivityCompat.Companion.getFormattedWiFiSsid();
    str2 = System.currentTimeMillis();
    str3 = ConnectivityCompat.Companion.getFormattedWiFiBssid();
    str4 = com.tencent.mm.compatible.deviceinfo.q.auJ();
    localObject = String.format("wifissid=%s&wifibssid=%s&wifimac=%s&sm=%s&ssid_timestamp=%s", new Object[] { Mc(str1), Mc(str3), Mc(str4), localObject, str2 });
    str1 = gJa();
    str1 = (String)localObject + str1;
    if (shouldReportCellInfo())
    {
      localObject = gJb();
      lR(str1, (String)localObject);
      Log.e("MicroMsg.GpsReportHelper", "RecordCostTime: refreshWifiAndCellInfo cost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(70292);
      return;
    }
  }
  
  public static bd gJe()
  {
    AppMethodBeat.i(70293);
    long l = System.currentTimeMillis() / 1000L;
    if (l - OPU > 300L)
    {
      gJd();
      OPU = l;
    }
    bd localbd = OPT;
    AppMethodBeat.o(70293);
    return localbd;
  }
  
  public static boolean gJf()
  {
    AppMethodBeat.i(70296);
    boolean bool = u.gJo().gJY().gJJ();
    AppMethodBeat.o(70296);
    return bool;
  }
  
  private static List<a> hu(Context paramContext)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(70298);
        LinkedList localLinkedList = new LinkedList();
        TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        int j = Build.VERSION.SDK_INT;
        a locala;
        Object localObject2;
        Object localObject1;
        int i;
        try
        {
          paramContext = (List)com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, "com/tencent/mm/plugin/wallet_core/model/GpsReportHelper", "getExtraCellInfoList", "(Landroid/content/Context;)Ljava/util/List;", "android/telephony/TelephonyManager", "getAllCellInfo", "()Ljava/util/List;");
          if (paramContext == null) {
            continue;
          }
          Iterator localIterator = paramContext.iterator();
          if (!localIterator.hasNext()) {
            continue;
          }
          paramContext = (CellInfo)localIterator.next();
          locala = new a();
          locala.networkType = localTelephonyManager.getNetworkType();
          if (!(paramContext instanceof CellInfoGsm)) {
            continue;
          }
          localObject2 = ((CellInfoGsm)paramContext).getCellSignalStrength();
          localObject1 = ((CellInfoGsm)paramContext).getCellIdentity();
          i = ((CellIdentityGsm)localObject1).getMnc();
          locala.cellid = ((CellIdentityGsm)localObject1).getCid();
          locala.mcc = ((CellIdentityGsm)localObject1).getMcc();
          locala.mnc = ((CellIdentityGsm)localObject1).getMnc();
          locala.lac = ((CellIdentityGsm)localObject1).getLac();
          locala.dbm = ((CellSignalStrengthGsm)localObject2).getDbm();
          if (!paramContext.isRegistered()) {
            continue;
          }
          paramContext = "1";
          locala.OQa = paramContext;
          if (Build.VERSION.SDK_INT < 24) {
            break label971;
          }
          locala.OPZ = ((CellIdentityGsm)localObject1).getArfcn();
        }
        catch (Exception paramContext)
        {
          Log.e("MicroMsg.GpsReportHelper", "loadCellInfo: Unable to obtain cell signal information: ", new Object[] { paramContext });
          AppMethodBeat.o(70298);
          return localLinkedList;
        }
        if (i == 2147483647) {
          continue;
        }
        localLinkedList.add(locala);
        continue;
        paramContext = "0";
        continue;
        if ((paramContext instanceof CellInfoCdma))
        {
          localObject1 = ((CellInfoCdma)paramContext).getCellSignalStrength();
          localObject2 = ((CellInfoCdma)paramContext).getCellIdentity();
          i = ((CellIdentityCdma)localObject2).getSystemId();
          locala.cellid = ((CellIdentityCdma)localObject2).getBasestationId();
          locala.mnc = ((CellIdentityCdma)localObject2).getSystemId();
          locala.lac = ((CellIdentityCdma)localObject2).getNetworkId();
          locala.dbm = ((CellSignalStrengthCdma)localObject1).getDbm();
          if (paramContext.isRegistered())
          {
            paramContext = "1";
            locala.OQa = paramContext;
          }
        }
        else
        {
          if ((paramContext instanceof CellInfoLte))
          {
            localObject2 = ((CellInfoLte)paramContext).getCellSignalStrength();
            localObject1 = ((CellInfoLte)paramContext).getCellIdentity();
            i = ((CellIdentityLte)localObject1).getMnc();
            locala.cellid = ((CellIdentityLte)localObject1).getCi();
            locala.mcc = ((CellIdentityLte)localObject1).getMcc();
            locala.mnc = ((CellIdentityLte)localObject1).getMnc();
            locala.OPW = ((CellIdentityLte)localObject1).getTac();
            locala.dbm = ((CellSignalStrengthLte)localObject2).getDbm();
            if (!paramContext.isRegistered()) {
              break label984;
            }
            paramContext = "1";
            locala.OQa = paramContext;
            if (Build.VERSION.SDK_INT < 24) {
              break label981;
            }
            locala.OPX = ((CellIdentityLte)localObject1).getEarfcn();
            break label981;
          }
          if ((j >= 18) && ((paramContext instanceof CellInfoWcdma)))
          {
            localObject2 = ((CellInfoWcdma)paramContext).getCellSignalStrength();
            localObject1 = ((CellInfoWcdma)paramContext).getCellIdentity();
            i = ((CellIdentityWcdma)localObject1).getMnc();
            locala.cellid = ((CellIdentityWcdma)localObject1).getCid();
            locala.mcc = ((CellIdentityWcdma)localObject1).getMcc();
            locala.mnc = ((CellIdentityWcdma)localObject1).getMnc();
            locala.lac = ((CellIdentityWcdma)localObject1).getLac();
            locala.dbm = ((CellSignalStrengthWcdma)localObject2).getDbm();
            if (!paramContext.isRegistered()) {
              break label994;
            }
            paramContext = "1";
            locala.OQa = paramContext;
            if (Build.VERSION.SDK_INT < 24) {
              break label991;
            }
            locala.OPY = ((CellIdentityWcdma)localObject1).getUarfcn();
            break label991;
          }
          Log.i("MicroMsg.GpsReportHelper", "Unknown type of cell signal!\n ClassName: " + paramContext.getClass().getSimpleName() + "\n ToString: " + paramContext.toString());
          i = 0;
          continue;
          continue;
        }
      }
      finally {}
      label971:
      paramContext = "0";
      continue;
      label981:
      continue;
      label984:
      paramContext = "0";
      continue;
      label991:
      continue;
      label994:
      paramContext = "0";
    }
  }
  
  private static void lR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(70290);
    if (OPT == null) {
      OPT = new bd();
    }
    Log.d("MicroMsg.GpsReportHelper", "encrypt data userInfo:%s, cellInfo:%s", new Object[] { paramString1, paramString2 });
    byte[] arrayOfByte3 = new byte[16];
    byte[] arrayOfByte2 = y.iiR().getBytes();
    if (arrayOfByte2 != null)
    {
      arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2.length > 0) {}
    }
    else
    {
      arrayOfByte1 = System.currentTimeMillis().getBytes();
    }
    int j = 0;
    int i = 0;
    int k;
    do
    {
      arrayOfByte3[i] = arrayOfByte1[j];
      k = i + 1;
      j += 1;
      i = j;
      if (j >= arrayOfByte1.length) {
        i = 0;
      }
      j = i;
      i = k;
    } while (k < 16);
    byte[] arrayOfByte1 = Base64.encode(arrayOfByte3, 0);
    OPT.RFY = o.gJg().cI(arrayOfByte1);
    Log.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_key %s", new Object[] { OPT.RFY });
    if (!Util.isNullOrNil(paramString1))
    {
      paramString1 = Base64.encode(AesEcb.aesCryptEcb(paramString1.getBytes(), arrayOfByte3, true, true), 0);
      OPT.RFX = new String(paramString1);
      Log.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_userinfo %s", new Object[] { new String(paramString1) });
    }
    if (!Util.isNullOrNil(paramString2))
    {
      paramString1 = Base64.encode(AesEcb.aesCryptEcb(paramString2.getBytes(), arrayOfByte3, true, true), 0);
      OPT.RFZ = new String(paramString1);
      Log.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_cellinfo %s", new Object[] { new String(paramString1) });
    }
    AppMethodBeat.o(70290);
  }
  
  public static boolean shouldReportCellInfo()
  {
    AppMethodBeat.i(70297);
    boolean bool = u.gJo().gJY().gJK();
    AppMethodBeat.o(70297);
    return bool;
  }
  
  public static boolean shouldReportLocation()
  {
    AppMethodBeat.i(70295);
    boolean bool = u.gJo().gJY().YT();
    AppMethodBeat.o(70295);
    return bool;
  }
  
  public static final class a
  {
    public String OPW;
    public String OPX;
    public String OPY;
    public String OPZ;
    public String OQa;
    public String cellid;
    public String dbm;
    public String lac;
    public String mcc;
    public String mnc;
    public String networkId;
    public String networkType;
    public String stationId;
    public String systemId;
    public String type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.k
 * JD-Core Version:    0.7.0.1
 */