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
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  private static k DoA;
  private static bb DoB = null;
  private static long DoC = 0L;
  private static k.b Doz;
  public JSONArray DoD;
  
  private k()
  {
    AppMethodBeat.i(70283);
    g.ajS();
    String str = (String)g.ajR().ajA().get(am.a.IPu, "");
    ae.i("MicroMsg.GpsReportHelper", "GpsReportHelper ".concat(String.valueOf(str)));
    if (!bu.isNullOrNil(str)) {
      try
      {
        this.DoD = new JSONArray(str);
        AppMethodBeat.o(70283);
        return;
      }
      catch (JSONException localJSONException)
      {
        ae.printErrStackTrace("MicroMsg.GpsReportHelper", localJSONException, "", new Object[0]);
        ae.e("MicroMsg.GpsReportHelper", "parse lbs config error", new Object[] { localJSONException });
      }
    }
    AppMethodBeat.o(70283);
  }
  
  public static void Wf(int paramInt)
  {
    AppMethodBeat.i(70291);
    ae.i("MicroMsg.GpsReportHelper", "reflashLocationInfo ".concat(String.valueOf(paramInt)));
    DoC = System.currentTimeMillis() / 1000L;
    if (!shouldReportLocation())
    {
      Doz = null;
      eIU();
      DoC = System.currentTimeMillis() / 1000L;
    }
    AppMethodBeat.o(70291);
  }
  
  public static bb ba(Map<String, String> paramMap)
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
    localObject1 = y.fVS().getBytes();
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
    paramMap.FLg = o.eIX().ca((byte[])localObject1);
    paramMap.FLf = new String(Base64.encode(AesEcb.aesCryptEcb(((String)localObject2).getBytes(), arrayOfByte, true, true), 0));
    AppMethodBeat.o(70289);
    return paramMap;
  }
  
  public static cjm drq()
  {
    AppMethodBeat.i(70294);
    if (DoB == null)
    {
      AppMethodBeat.o(70294);
      return null;
    }
    cjm localcjm = new cjm();
    localcjm.eRg = DoB.eRg;
    localcjm.eRf = DoB.eRf;
    localcjm.latitude = DoB.latitude;
    localcjm.longitude = DoB.longitude;
    localcjm.FLc = DoB.FLc;
    localcjm.FLg = DoB.FLg;
    localcjm.FLd = DoB.FLd;
    localcjm.FLe = DoB.FLe;
    localcjm.FLf = DoB.FLf;
    AppMethodBeat.o(70294);
    return localcjm;
  }
  
  public static k eIQ()
  {
    AppMethodBeat.i(70284);
    if (DoA == null) {
      DoA = new k();
    }
    k localk = DoA;
    AppMethodBeat.o(70284);
    return localk;
  }
  
  private static String eIR()
  {
    AppMethodBeat.i(70285);
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuffer();
    try
    {
      localObject2 = ak.getContext();
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
        ae.printErrStackTrace("MicroMsg.GpsReportHelper", localException, "", new Object[0]);
      }
    }
    if (((Iterator)localObject2).hasNext())
    {
      localScanResult = (ScanResult)((Iterator)localObject2).next();
      ((StringBuffer)localObject1).append(String.format("&scan_ssid%d=%s&scan_bssid%d=%s&sm%d=%s", new Object[] { Integer.valueOf(i), wS(localScanResult.SSID), Integer.valueOf(i), wS(localScanResult.BSSID), Integer.valueOf(i), Integer.valueOf(localScanResult.level) }));
      i += 1;
      if (i < 5) {}
    }
    else
    {
      ae.e("MicroMsg.GpsReportHelper", "RecordCostTime: readScanWifi cost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      localObject1 = ((StringBuffer)localObject1).toString();
      AppMethodBeat.o(70285);
      return localObject1;
    }
  }
  
  private static String eIS()
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
    ((HashMap)localObject1).put("net_type", az.iW(ak.getContext()));
    ae.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 01- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    long l2 = System.currentTimeMillis();
    l1 = l2;
    if (eIT())
    {
      ((HashMap)localObject1).put("is_ci_permitted", "1");
      ((HashMap)localObject1).put("uuid", UUID.randomUUID().toString());
      ((HashMap)localObject1).put("sample_time", System.currentTimeMillis() / 1000L);
      ((HashMap)localObject1).put("phone_brand", Build.BRAND);
      ((HashMap)localObject1).put("phone_model", Build.MODEL);
    }
    try
    {
      if (ak.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)
      {
        localObject2 = ((ConnectivityManager)ak.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
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
    ae.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 02- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
    l1 = System.currentTimeMillis();
    localObject2 = fR(ak.getContext());
    ae.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 03- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    l1 = System.currentTimeMillis();
    j = ((List)localObject2).size();
    i = 0;
    while (i < j)
    {
      localObject3 = (a)((List)localObject2).get(i);
      if (localObject3 != null)
      {
        ((HashMap)localObject1).put("mcc_".concat(String.valueOf(i)), ((a)localObject3).vWX);
        ((HashMap)localObject1).put("mnc_".concat(String.valueOf(i)), ((a)localObject3).vWY);
        ((HashMap)localObject1).put("lac_".concat(String.valueOf(i)), ((a)localObject3).DoE);
        ((HashMap)localObject1).put("cell_id_".concat(String.valueOf(i)), ((a)localObject3).vWZ);
        ((HashMap)localObject1).put("type_".concat(String.valueOf(i)), ((a)localObject3).type);
        ((HashMap)localObject1).put("sid_".concat(String.valueOf(i)), ((a)localObject3).DoG);
        ((HashMap)localObject1).put("net_id_".concat(String.valueOf(i)), ((a)localObject3).DoH);
        ((HashMap)localObject1).put("sys_id_".concat(String.valueOf(i)), ((a)localObject3).systemId);
        ((HashMap)localObject1).put("dbm_".concat(String.valueOf(i)), ((a)localObject3).DoI);
        ((HashMap)localObject1).put("tac_".concat(String.valueOf(i)), ((a)localObject3).DoF);
        ((HashMap)localObject1).put("arfcn_".concat(String.valueOf(i)), ((a)localObject3).DoL);
        ((HashMap)localObject1).put("earfcn_".concat(String.valueOf(i)), ((a)localObject3).DoJ);
        ((HashMap)localObject1).put("uarfcn_".concat(String.valueOf(i)), ((a)localObject3).DoK);
        ((HashMap)localObject1).put("dbm_".concat(String.valueOf(i)), ((a)localObject3).DoI);
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
      if (!bu.isNullOrNil(str2)) {
        ((StringBuilder)localObject2).append(String.format("&%s=%s", new Object[] { str1, wS(str2) }));
      }
    }
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = localObject2;
    if (!bu.isNullOrNil((String)localObject2))
    {
      localObject1 = localObject2;
      if (((String)localObject2).indexOf("&") == 0) {
        localObject1 = ((String)localObject2).substring(1);
      }
    }
    ae.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 03- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(70286);
    return localObject1;
  }
  
  private static boolean eIT()
  {
    AppMethodBeat.i(70287);
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(70287);
      return true;
    }
    try
    {
      int i = b.checkSelfPermission(ak.getContext(), "android.permission.ACCESS_COARSE_LOCATION");
      if (i == 0)
      {
        AppMethodBeat.o(70287);
        return true;
      }
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.GpsReportHelper", "check permission exception:%s.", new Object[] { localException });
      AppMethodBeat.o(70287);
      return true;
    }
    AppMethodBeat.o(70287);
    return false;
  }
  
  private static void eIU()
  {
    AppMethodBeat.i(70292);
    long l = System.currentTimeMillis();
    if (shouldReportLocation())
    {
      AppMethodBeat.o(70292);
      return;
    }
    if ((eIW()) || (shouldReportCellInfo())) {}
    try
    {
      Object localObject = (WifiManager)ak.getContext().getApplicationContext().getSystemService("wifi");
      localObject = ((WifiManager)localObject).getConnectionInfo().getRssi();
      String str2 = az.ja(ak.getContext());
      String str3 = System.currentTimeMillis();
      String str4 = az.jb(ak.getContext());
      String str5 = com.tencent.mm.compatible.deviceinfo.q.aaE();
      localObject = String.format("wifissid=%s&wifibssid=%s&wifimac=%s&sm=%s&ssid_timestamp=%s", new Object[] { wS(str2), wS(str4), wS(str5), localObject, str3 });
      str2 = eIR();
      str2 = (String)localObject + str2;
      if (shouldReportCellInfo())
      {
        localObject = eIS();
        kB(str2, (String)localObject);
        ae.e("MicroMsg.GpsReportHelper", "RecordCostTime: refreshWifiAndCellInfo cost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(70292);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.GpsReportHelper", localException, "", new Object[0]);
        String str1 = "";
        continue;
        str1 = null;
      }
    }
  }
  
  public static bb eIV()
  {
    AppMethodBeat.i(70293);
    long l = System.currentTimeMillis() / 1000L;
    if (l - DoC > 300L)
    {
      eIU();
      DoC = l;
    }
    bb localbb = DoB;
    AppMethodBeat.o(70293);
    return localbb;
  }
  
  public static boolean eIW()
  {
    AppMethodBeat.i(70296);
    boolean bool = t.eJf().eJP().eJA();
    AppMethodBeat.o(70296);
    return bool;
  }
  
  private static List<a> fR(Context paramContext)
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
          locala.mxS = localTelephonyManager.getNetworkType();
          if (!(paramContext instanceof CellInfoGsm)) {
            continue;
          }
          localObject2 = ((CellInfoGsm)paramContext).getCellSignalStrength();
          localObject1 = ((CellInfoGsm)paramContext).getCellIdentity();
          i = ((CellIdentityGsm)localObject1).getMnc();
          locala.vWZ = ((CellIdentityGsm)localObject1).getCid();
          locala.vWX = ((CellIdentityGsm)localObject1).getMcc();
          locala.vWY = ((CellIdentityGsm)localObject1).getMnc();
          locala.DoE = ((CellIdentityGsm)localObject1).getLac();
          locala.DoI = ((CellSignalStrengthGsm)localObject2).getDbm();
          if (!paramContext.isRegistered()) {
            continue;
          }
          paramContext = "1";
          locala.DoM = paramContext;
          if (Build.VERSION.SDK_INT < 24) {
            break label950;
          }
          locala.DoL = ((CellIdentityGsm)localObject1).getArfcn();
        }
        catch (Exception paramContext)
        {
          ae.e("MicroMsg.GpsReportHelper", "loadCellInfo: Unable to obtain cell signal information: ", new Object[] { paramContext });
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
          locala.vWZ = ((CellIdentityCdma)localObject2).getBasestationId();
          locala.vWY = ((CellIdentityCdma)localObject2).getSystemId();
          locala.DoE = ((CellIdentityCdma)localObject2).getNetworkId();
          locala.DoI = ((CellSignalStrengthCdma)localObject1).getDbm();
          if (paramContext.isRegistered())
          {
            paramContext = "1";
            locala.DoM = paramContext;
          }
        }
        else
        {
          if ((paramContext instanceof CellInfoLte))
          {
            localObject2 = ((CellInfoLte)paramContext).getCellSignalStrength();
            localObject1 = ((CellInfoLte)paramContext).getCellIdentity();
            i = ((CellIdentityLte)localObject1).getMnc();
            locala.vWZ = ((CellIdentityLte)localObject1).getCi();
            locala.vWX = ((CellIdentityLte)localObject1).getMcc();
            locala.vWY = ((CellIdentityLte)localObject1).getMnc();
            locala.DoF = ((CellIdentityLte)localObject1).getTac();
            locala.DoI = ((CellSignalStrengthLte)localObject2).getDbm();
            if (!paramContext.isRegistered()) {
              break label963;
            }
            paramContext = "1";
            locala.DoM = paramContext;
            if (Build.VERSION.SDK_INT < 24) {
              break label960;
            }
            locala.DoJ = ((CellIdentityLte)localObject1).getEarfcn();
            break label960;
          }
          if ((j >= 18) && ((paramContext instanceof CellInfoWcdma)))
          {
            localObject2 = ((CellInfoWcdma)paramContext).getCellSignalStrength();
            localObject1 = ((CellInfoWcdma)paramContext).getCellIdentity();
            i = ((CellIdentityWcdma)localObject1).getMnc();
            locala.vWZ = ((CellIdentityWcdma)localObject1).getCid();
            locala.vWX = ((CellIdentityWcdma)localObject1).getMcc();
            locala.vWY = ((CellIdentityWcdma)localObject1).getMnc();
            locala.DoE = ((CellIdentityWcdma)localObject1).getLac();
            locala.DoI = ((CellSignalStrengthWcdma)localObject2).getDbm();
            if (!paramContext.isRegistered()) {
              break label973;
            }
            paramContext = "1";
            locala.DoM = paramContext;
            if (Build.VERSION.SDK_INT < 24) {
              break label970;
            }
            locala.DoK = ((CellIdentityWcdma)localObject1).getUarfcn();
            break label970;
          }
          ae.i("MicroMsg.GpsReportHelper", "Unknown type of cell signal!\n ClassName: " + paramContext.getClass().getSimpleName() + "\n ToString: " + paramContext.toString());
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
  
  private static void kB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(70290);
    if (DoB == null) {
      DoB = new bb();
    }
    ae.d("MicroMsg.GpsReportHelper", "encrypt data userInfo:%s, cellInfo:%s", new Object[] { paramString1, paramString2 });
    byte[] arrayOfByte3 = new byte[16];
    byte[] arrayOfByte2 = y.fVS().getBytes();
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
    DoB.FLg = o.eIX().ca(arrayOfByte1);
    ae.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_key %s", new Object[] { DoB.FLg });
    if (!bu.isNullOrNil(paramString1))
    {
      paramString1 = Base64.encode(AesEcb.aesCryptEcb(paramString1.getBytes(), arrayOfByte3, true, true), 0);
      DoB.FLf = new String(paramString1);
      ae.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_userinfo %s", new Object[] { new String(paramString1) });
    }
    if (!bu.isNullOrNil(paramString2))
    {
      paramString1 = Base64.encode(AesEcb.aesCryptEcb(paramString2.getBytes(), arrayOfByte3, true, true), 0);
      DoB.FLh = new String(paramString1);
      ae.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_cellinfo %s", new Object[] { new String(paramString1) });
    }
    AppMethodBeat.o(70290);
  }
  
  public static boolean shouldReportCellInfo()
  {
    AppMethodBeat.i(70297);
    boolean bool = t.eJf().eJP().eJB();
    AppMethodBeat.o(70297);
    return bool;
  }
  
  public static boolean shouldReportLocation()
  {
    AppMethodBeat.i(70295);
    boolean bool = t.eJf().eJP().Kr();
    AppMethodBeat.o(70295);
    return bool;
  }
  
  private static String wS(String paramString)
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
        ae.printErrStackTrace("MicroMsg.GpsReportHelper", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(70288);
    return paramString;
  }
  
  public static final class a
  {
    public String DoE;
    public String DoF;
    public String DoG;
    public String DoH;
    public String DoI;
    public String DoJ;
    public String DoK;
    public String DoL;
    public String DoM;
    public String mxS;
    public String systemId;
    public String type;
    public String vWX;
    public String vWY;
    public String vWZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.k
 * JD-Core Version:    0.7.0.1
 */