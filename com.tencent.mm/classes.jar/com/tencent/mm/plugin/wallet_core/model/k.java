package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.content.b;
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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  private static k.b CWU;
  private static k CWV;
  private static bb CWW = null;
  private static long CWX = 0L;
  public JSONArray CWY;
  
  private k()
  {
    AppMethodBeat.i(70283);
    g.ajD();
    String str = (String)g.ajC().ajl().get(al.a.IuW, "");
    ad.i("MicroMsg.GpsReportHelper", "GpsReportHelper ".concat(String.valueOf(str)));
    if (!bt.isNullOrNil(str)) {
      try
      {
        this.CWY = new JSONArray(str);
        AppMethodBeat.o(70283);
        return;
      }
      catch (JSONException localJSONException)
      {
        ad.printErrStackTrace("MicroMsg.GpsReportHelper", localJSONException, "", new Object[0]);
        ad.e("MicroMsg.GpsReportHelper", "parse lbs config error", new Object[] { localJSONException });
      }
    }
    AppMethodBeat.o(70283);
  }
  
  public static void Vy(int paramInt)
  {
    AppMethodBeat.i(70291);
    ad.i("MicroMsg.GpsReportHelper", "reflashLocationInfo ".concat(String.valueOf(paramInt)));
    CWX = System.currentTimeMillis() / 1000L;
    if (!shouldReportLocation())
    {
      CWU = null;
      eFn();
      CWX = System.currentTimeMillis() / 1000L;
    }
    AppMethodBeat.o(70291);
  }
  
  public static bb aU(Map<String, String> paramMap)
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
    localObject1 = y.fRw().getBytes();
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
    paramMap = new bb();
    localObject1 = Base64.encode(arrayOfByte, 0);
    paramMap.FsI = o.eFq().bX((byte[])localObject1);
    paramMap.FsH = new String(Base64.encode(AesEcb.aesCryptEcb(((String)localObject2).getBytes(), arrayOfByte, true, true), 0));
    AppMethodBeat.o(70289);
    return paramMap;
  }
  
  public static cis dos()
  {
    AppMethodBeat.i(70294);
    if (CWW == null)
    {
      AppMethodBeat.o(70294);
      return null;
    }
    cis localcis = new cis();
    localcis.ePv = CWW.ePv;
    localcis.ePu = CWW.ePu;
    localcis.latitude = CWW.latitude;
    localcis.longitude = CWW.longitude;
    localcis.FsE = CWW.FsE;
    localcis.FsI = CWW.FsI;
    localcis.FsF = CWW.FsF;
    localcis.FsG = CWW.FsG;
    localcis.FsH = CWW.FsH;
    AppMethodBeat.o(70294);
    return localcis;
  }
  
  public static k eFj()
  {
    AppMethodBeat.i(70284);
    if (CWV == null) {
      CWV = new k();
    }
    k localk = CWV;
    AppMethodBeat.o(70284);
    return localk;
  }
  
  private static String eFk()
  {
    AppMethodBeat.i(70285);
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuffer();
    try
    {
      localObject2 = aj.getContext();
      if (localObject2 == null)
      {
        AppMethodBeat.o(70285);
        return "";
      }
      localObject2 = (WifiManager)((Context)localObject2).getSystemService("wifi");
      ((WifiManager)localObject2).getConnectionInfo();
      new StringBuffer();
      new StringBuffer();
      localObject2 = ((WifiManager)localObject2).getScanResults().iterator();
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        int i;
        ScanResult localScanResult;
        ad.printErrStackTrace("MicroMsg.GpsReportHelper", localException, "", new Object[0]);
      }
    }
    if (((Iterator)localObject2).hasNext())
    {
      localScanResult = (ScanResult)((Iterator)localObject2).next();
      ((StringBuffer)localObject1).append(String.format("&scan_ssid%d=%s&scan_bssid%d=%s&sm%d=%s", new Object[] { Integer.valueOf(i), wj(localScanResult.SSID), Integer.valueOf(i), wj(localScanResult.BSSID), Integer.valueOf(i), Integer.valueOf(localScanResult.level) }));
      i += 1;
      if (i < 5) {}
    }
    else
    {
      ad.e("MicroMsg.GpsReportHelper", "RecordCostTime: readScanWifi cost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      localObject1 = ((StringBuffer)localObject1).toString();
      AppMethodBeat.o(70285);
      return localObject1;
    }
  }
  
  private static String eFl()
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
    ((HashMap)localObject1).put("net_type", ay.iR(aj.getContext()));
    ad.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 01- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    long l2 = System.currentTimeMillis();
    l1 = l2;
    if (eFm())
    {
      ((HashMap)localObject1).put("is_ci_permitted", "1");
      ((HashMap)localObject1).put("uuid", UUID.randomUUID().toString());
      ((HashMap)localObject1).put("sample_time", System.currentTimeMillis() / 1000L);
      ((HashMap)localObject1).put("phone_brand", Build.BRAND);
      ((HashMap)localObject1).put("phone_model", Build.MODEL);
    }
    try
    {
      if (aj.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)
      {
        localObject2 = ((ConnectivityManager)aj.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
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
    ad.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 02- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
    l1 = System.currentTimeMillis();
    localObject2 = fL(aj.getContext());
    ad.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 03- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    l1 = System.currentTimeMillis();
    j = ((List)localObject2).size();
    i = 0;
    while (i < j)
    {
      localObject3 = (a)((List)localObject2).get(i);
      if (localObject3 != null)
      {
        ((HashMap)localObject1).put("mcc_".concat(String.valueOf(i)), ((a)localObject3).vKT);
        ((HashMap)localObject1).put("mnc_".concat(String.valueOf(i)), ((a)localObject3).vKU);
        ((HashMap)localObject1).put("lac_".concat(String.valueOf(i)), ((a)localObject3).CWZ);
        ((HashMap)localObject1).put("cell_id_".concat(String.valueOf(i)), ((a)localObject3).vKV);
        ((HashMap)localObject1).put("type_".concat(String.valueOf(i)), ((a)localObject3).type);
        ((HashMap)localObject1).put("sid_".concat(String.valueOf(i)), ((a)localObject3).CXb);
        ((HashMap)localObject1).put("net_id_".concat(String.valueOf(i)), ((a)localObject3).CXc);
        ((HashMap)localObject1).put("sys_id_".concat(String.valueOf(i)), ((a)localObject3).systemId);
        ((HashMap)localObject1).put("dbm_".concat(String.valueOf(i)), ((a)localObject3).CXd);
        ((HashMap)localObject1).put("tac_".concat(String.valueOf(i)), ((a)localObject3).CXa);
        ((HashMap)localObject1).put("arfcn_".concat(String.valueOf(i)), ((a)localObject3).CXg);
        ((HashMap)localObject1).put("earfcn_".concat(String.valueOf(i)), ((a)localObject3).CXe);
        ((HashMap)localObject1).put("uarfcn_".concat(String.valueOf(i)), ((a)localObject3).CXf);
        ((HashMap)localObject1).put("dbm_".concat(String.valueOf(i)), ((a)localObject3).CXd);
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
      if (!bt.isNullOrNil(str2)) {
        ((StringBuilder)localObject2).append(String.format("&%s=%s", new Object[] { str1, wj(str2) }));
      }
    }
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = localObject2;
    if (!bt.isNullOrNil((String)localObject2))
    {
      localObject1 = localObject2;
      if (((String)localObject2).indexOf("&") == 0) {
        localObject1 = ((String)localObject2).substring(1);
      }
    }
    ad.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 03- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(70286);
    return localObject1;
  }
  
  private static boolean eFm()
  {
    AppMethodBeat.i(70287);
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(70287);
      return true;
    }
    try
    {
      int i = b.checkSelfPermission(aj.getContext(), "android.permission.ACCESS_COARSE_LOCATION");
      if (i == 0)
      {
        AppMethodBeat.o(70287);
        return true;
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.GpsReportHelper", "check permission exception:%s.", new Object[] { localException });
      AppMethodBeat.o(70287);
      return true;
    }
    AppMethodBeat.o(70287);
    return false;
  }
  
  private static void eFn()
  {
    AppMethodBeat.i(70292);
    long l = System.currentTimeMillis();
    if (shouldReportLocation())
    {
      AppMethodBeat.o(70292);
      return;
    }
    if ((eFp()) || (shouldReportCellInfo())) {}
    try
    {
      Object localObject = (WifiManager)aj.getContext().getApplicationContext().getSystemService("wifi");
      localObject = ((WifiManager)localObject).getConnectionInfo().getRssi();
      String str2 = ay.iV(aj.getContext());
      String str3 = System.currentTimeMillis();
      String str4 = ay.iW(aj.getContext());
      String str5 = com.tencent.mm.compatible.deviceinfo.q.aav();
      localObject = String.format("wifissid=%s&wifibssid=%s&wifimac=%s&sm=%s&ssid_timestamp=%s", new Object[] { wj(str2), wj(str4), wj(str5), localObject, str3 });
      str2 = eFk();
      str2 = (String)localObject + str2;
      if (shouldReportCellInfo())
      {
        localObject = eFl();
        ku(str2, (String)localObject);
        ad.e("MicroMsg.GpsReportHelper", "RecordCostTime: refreshWifiAndCellInfo cost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(70292);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.GpsReportHelper", localException, "", new Object[0]);
        String str1 = "";
        continue;
        str1 = null;
      }
    }
  }
  
  public static bb eFo()
  {
    AppMethodBeat.i(70293);
    long l = System.currentTimeMillis() / 1000L;
    if (l - CWX > 300L)
    {
      eFn();
      CWX = l;
    }
    bb localbb = CWW;
    AppMethodBeat.o(70293);
    return localbb;
  }
  
  public static boolean eFp()
  {
    AppMethodBeat.i(70296);
    boolean bool = t.eFy().eGi().eFT();
    AppMethodBeat.o(70296);
    return bool;
  }
  
  private static List<a> fL(Context paramContext)
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
          paramContext = localTelephonyManager.getAllCellInfo();
          if (paramContext == null) {
            continue;
          }
          Iterator localIterator = paramContext.iterator();
          if (!localIterator.hasNext()) {
            continue;
          }
          paramContext = (CellInfo)localIterator.next();
          locala = new a();
          locala.msV = localTelephonyManager.getNetworkType();
          if (!(paramContext instanceof CellInfoGsm)) {
            continue;
          }
          localObject2 = ((CellInfoGsm)paramContext).getCellSignalStrength();
          localObject1 = ((CellInfoGsm)paramContext).getCellIdentity();
          i = ((CellIdentityGsm)localObject1).getMnc();
          locala.vKV = ((CellIdentityGsm)localObject1).getCid();
          locala.vKT = ((CellIdentityGsm)localObject1).getMcc();
          locala.vKU = ((CellIdentityGsm)localObject1).getMnc();
          locala.CWZ = ((CellIdentityGsm)localObject1).getLac();
          locala.CXd = ((CellSignalStrengthGsm)localObject2).getDbm();
          if (!paramContext.isRegistered()) {
            continue;
          }
          paramContext = "1";
          locala.CXh = paramContext;
          if (Build.VERSION.SDK_INT < 24) {
            break label950;
          }
          locala.CXg = ((CellIdentityGsm)localObject1).getArfcn();
        }
        catch (Exception paramContext)
        {
          ad.e("MicroMsg.GpsReportHelper", "loadCellInfo: Unable to obtain cell signal information: ", new Object[] { paramContext });
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
          locala.vKV = ((CellIdentityCdma)localObject2).getBasestationId();
          locala.vKU = ((CellIdentityCdma)localObject2).getSystemId();
          locala.CWZ = ((CellIdentityCdma)localObject2).getNetworkId();
          locala.CXd = ((CellSignalStrengthCdma)localObject1).getDbm();
          if (paramContext.isRegistered())
          {
            paramContext = "1";
            locala.CXh = paramContext;
          }
        }
        else
        {
          if ((paramContext instanceof CellInfoLte))
          {
            localObject2 = ((CellInfoLte)paramContext).getCellSignalStrength();
            localObject1 = ((CellInfoLte)paramContext).getCellIdentity();
            i = ((CellIdentityLte)localObject1).getMnc();
            locala.vKV = ((CellIdentityLte)localObject1).getCi();
            locala.vKT = ((CellIdentityLte)localObject1).getMcc();
            locala.vKU = ((CellIdentityLte)localObject1).getMnc();
            locala.CXa = ((CellIdentityLte)localObject1).getTac();
            locala.CXd = ((CellSignalStrengthLte)localObject2).getDbm();
            if (!paramContext.isRegistered()) {
              break label963;
            }
            paramContext = "1";
            locala.CXh = paramContext;
            if (Build.VERSION.SDK_INT < 24) {
              break label960;
            }
            locala.CXe = ((CellIdentityLte)localObject1).getEarfcn();
            break label960;
          }
          if ((j >= 18) && ((paramContext instanceof CellInfoWcdma)))
          {
            localObject2 = ((CellInfoWcdma)paramContext).getCellSignalStrength();
            localObject1 = ((CellInfoWcdma)paramContext).getCellIdentity();
            i = ((CellIdentityWcdma)localObject1).getMnc();
            locala.vKV = ((CellIdentityWcdma)localObject1).getCid();
            locala.vKT = ((CellIdentityWcdma)localObject1).getMcc();
            locala.vKU = ((CellIdentityWcdma)localObject1).getMnc();
            locala.CWZ = ((CellIdentityWcdma)localObject1).getLac();
            locala.CXd = ((CellSignalStrengthWcdma)localObject2).getDbm();
            if (!paramContext.isRegistered()) {
              break label973;
            }
            paramContext = "1";
            locala.CXh = paramContext;
            if (Build.VERSION.SDK_INT < 24) {
              break label970;
            }
            locala.CXf = ((CellIdentityWcdma)localObject1).getUarfcn();
            break label970;
          }
          ad.i("MicroMsg.GpsReportHelper", "Unknown type of cell signal!\n ClassName: " + paramContext.getClass().getSimpleName() + "\n ToString: " + paramContext.toString());
          i = 0;
          continue;
          continue;
        }
      }
      finally {}
      label950:
      paramContext = "0";
      continue;
      label960:
      continue;
      label963:
      paramContext = "0";
      continue;
      label970:
      continue;
      label973:
      paramContext = "0";
    }
  }
  
  private static void ku(String paramString1, String paramString2)
  {
    AppMethodBeat.i(70290);
    if (CWW == null) {
      CWW = new bb();
    }
    ad.d("MicroMsg.GpsReportHelper", "encrypt data userInfo:%s, cellInfo:%s", new Object[] { paramString1, paramString2 });
    byte[] arrayOfByte3 = new byte[16];
    byte[] arrayOfByte2 = y.fRw().getBytes();
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
    CWW.FsI = o.eFq().bX(arrayOfByte1);
    ad.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_key %s", new Object[] { CWW.FsI });
    if (!bt.isNullOrNil(paramString1))
    {
      paramString1 = Base64.encode(AesEcb.aesCryptEcb(paramString1.getBytes(), arrayOfByte3, true, true), 0);
      CWW.FsH = new String(paramString1);
      ad.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_userinfo %s", new Object[] { new String(paramString1) });
    }
    if (!bt.isNullOrNil(paramString2))
    {
      paramString1 = Base64.encode(AesEcb.aesCryptEcb(paramString2.getBytes(), arrayOfByte3, true, true), 0);
      CWW.FsJ = new String(paramString1);
      ad.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_cellinfo %s", new Object[] { new String(paramString1) });
    }
    AppMethodBeat.o(70290);
  }
  
  public static boolean shouldReportCellInfo()
  {
    AppMethodBeat.i(70297);
    boolean bool = t.eFy().eGi().eFU();
    AppMethodBeat.o(70297);
    return bool;
  }
  
  public static boolean shouldReportLocation()
  {
    AppMethodBeat.i(70295);
    boolean bool = t.eFy().eGi().Kj();
    AppMethodBeat.o(70295);
    return bool;
  }
  
  private static String wj(String paramString)
  {
    AppMethodBeat.i(70288);
    try
    {
      String str = com.tencent.mm.compatible.util.q.encode(paramString, "UTF-8");
      paramString = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.GpsReportHelper", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(70288);
    return paramString;
  }
  
  public static final class a
  {
    public String CWZ;
    public String CXa;
    public String CXb;
    public String CXc;
    public String CXd;
    public String CXe;
    public String CXf;
    public String CXg;
    public String CXh;
    public String msV;
    public String systemId;
    public String type;
    public String vKT;
    public String vKU;
    public String vKV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.k
 * JD-Core Version:    0.7.0.1
 */