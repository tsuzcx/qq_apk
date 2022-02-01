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
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
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
  private static k.b Aek;
  private static k Ael;
  private static az Aem = null;
  private static long Aen = 0L;
  public JSONArray Aeo;
  
  private k()
  {
    AppMethodBeat.i(70283);
    g.afC();
    String str = (String)g.afB().afk().get(ae.a.FkP, "");
    ad.i("MicroMsg.GpsReportHelper", "GpsReportHelper ".concat(String.valueOf(str)));
    if (!bt.isNullOrNil(str)) {
      try
      {
        this.Aeo = new JSONArray(str);
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
  
  public static void Rx(int paramInt)
  {
    AppMethodBeat.i(70291);
    ad.i("MicroMsg.GpsReportHelper", "reflashLocationInfo ".concat(String.valueOf(paramInt)));
    Aen = System.currentTimeMillis() / 1000L;
    if (!shouldReportLocation())
    {
      Aek = null;
      ebR();
      Aen = System.currentTimeMillis() / 1000L;
    }
    AppMethodBeat.o(70291);
  }
  
  public static az aN(Map<String, String> paramMap)
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
    localObject1 = y.fjW().getBytes();
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
    paramMap = new az();
    localObject1 = Base64.encode(arrayOfByte, 0);
    paramMap.Cvi = o.ebU().bR((byte[])localObject1);
    paramMap.Cvh = new String(Base64.encode(AesEcb.aesCryptEcb(((String)localObject2).getBytes(), arrayOfByte, true, true), 0));
    AppMethodBeat.o(70289);
    return paramMap;
  }
  
  public static byx cRk()
  {
    AppMethodBeat.i(70294);
    if (Aem == null)
    {
      AppMethodBeat.o(70294);
      return null;
    }
    byx localbyx = new byx();
    localbyx.evA = Aem.evA;
    localbyx.evz = Aem.evz;
    localbyx.latitude = Aem.latitude;
    localbyx.longitude = Aem.longitude;
    localbyx.Cve = Aem.Cve;
    localbyx.Cvi = Aem.Cvi;
    localbyx.Cvf = Aem.Cvf;
    localbyx.Cvg = Aem.Cvg;
    localbyx.Cvh = Aem.Cvh;
    AppMethodBeat.o(70294);
    return localbyx;
  }
  
  public static k ebN()
  {
    AppMethodBeat.i(70284);
    if (Ael == null) {
      Ael = new k();
    }
    k localk = Ael;
    AppMethodBeat.o(70284);
    return localk;
  }
  
  private static String ebO()
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
      ((StringBuffer)localObject1).append(String.format("&scan_ssid%d=%s&scan_bssid%d=%s&sm%d=%s", new Object[] { Integer.valueOf(i), qg(localScanResult.SSID), Integer.valueOf(i), qg(localScanResult.BSSID), Integer.valueOf(i), Integer.valueOf(localScanResult.level) }));
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
  
  private static String ebP()
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
    ((HashMap)localObject1).put("net_type", ay.iw(aj.getContext()));
    ad.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 01- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    long l2 = System.currentTimeMillis();
    l1 = l2;
    if (ebQ())
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
    localObject2 = fu(aj.getContext());
    ad.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 03- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    l1 = System.currentTimeMillis();
    j = ((List)localObject2).size();
    i = 0;
    while (i < j)
    {
      localObject3 = (a)((List)localObject2).get(i);
      if (localObject3 != null)
      {
        ((HashMap)localObject1).put("mcc_".concat(String.valueOf(i)), ((a)localObject3).tzr);
        ((HashMap)localObject1).put("mnc_".concat(String.valueOf(i)), ((a)localObject3).tzs);
        ((HashMap)localObject1).put("lac_".concat(String.valueOf(i)), ((a)localObject3).Aep);
        ((HashMap)localObject1).put("cell_id_".concat(String.valueOf(i)), ((a)localObject3).tzt);
        ((HashMap)localObject1).put("type_".concat(String.valueOf(i)), ((a)localObject3).type);
        ((HashMap)localObject1).put("sid_".concat(String.valueOf(i)), ((a)localObject3).Aer);
        ((HashMap)localObject1).put("net_id_".concat(String.valueOf(i)), ((a)localObject3).Aes);
        ((HashMap)localObject1).put("sys_id_".concat(String.valueOf(i)), ((a)localObject3).systemId);
        ((HashMap)localObject1).put("dbm_".concat(String.valueOf(i)), ((a)localObject3).Aet);
        ((HashMap)localObject1).put("tac_".concat(String.valueOf(i)), ((a)localObject3).Aeq);
        ((HashMap)localObject1).put("arfcn_".concat(String.valueOf(i)), ((a)localObject3).Aew);
        ((HashMap)localObject1).put("earfcn_".concat(String.valueOf(i)), ((a)localObject3).Aeu);
        ((HashMap)localObject1).put("uarfcn_".concat(String.valueOf(i)), ((a)localObject3).Aev);
        ((HashMap)localObject1).put("dbm_".concat(String.valueOf(i)), ((a)localObject3).Aet);
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
        ((StringBuilder)localObject2).append(String.format("&%s=%s", new Object[] { str1, qg(str2) }));
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
  
  private static boolean ebQ()
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
  
  private static void ebR()
  {
    AppMethodBeat.i(70292);
    long l = System.currentTimeMillis();
    if (shouldReportLocation())
    {
      AppMethodBeat.o(70292);
      return;
    }
    if ((ebT()) || (shouldReportCellInfo())) {}
    try
    {
      Object localObject = (WifiManager)aj.getContext().getApplicationContext().getSystemService("wifi");
      localObject = ((WifiManager)localObject).getConnectionInfo().getRssi();
      String str2 = ay.iA(aj.getContext());
      String str3 = System.currentTimeMillis();
      String str4 = ay.iB(aj.getContext());
      String str5 = q.WX();
      localObject = String.format("wifissid=%s&wifibssid=%s&wifimac=%s&sm=%s&ssid_timestamp=%s", new Object[] { qg(str2), qg(str4), qg(str5), localObject, str3 });
      str2 = ebO();
      str2 = (String)localObject + str2;
      if (shouldReportCellInfo())
      {
        localObject = ebP();
        jE(str2, (String)localObject);
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
  
  public static az ebS()
  {
    AppMethodBeat.i(70293);
    long l = System.currentTimeMillis() / 1000L;
    if (l - Aen > 300L)
    {
      ebR();
      Aen = l;
    }
    az localaz = Aem;
    AppMethodBeat.o(70293);
    return localaz;
  }
  
  public static boolean ebT()
  {
    AppMethodBeat.i(70296);
    boolean bool = s.ecc().ecN().ecy();
    AppMethodBeat.o(70296);
    return bool;
  }
  
  private static List<a> fu(Context paramContext)
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
          locala.lrk = localTelephonyManager.getNetworkType();
          if (!(paramContext instanceof CellInfoGsm)) {
            continue;
          }
          localObject2 = ((CellInfoGsm)paramContext).getCellSignalStrength();
          localObject1 = ((CellInfoGsm)paramContext).getCellIdentity();
          i = ((CellIdentityGsm)localObject1).getMnc();
          locala.tzt = ((CellIdentityGsm)localObject1).getCid();
          locala.tzr = ((CellIdentityGsm)localObject1).getMcc();
          locala.tzs = ((CellIdentityGsm)localObject1).getMnc();
          locala.Aep = ((CellIdentityGsm)localObject1).getLac();
          locala.Aet = ((CellSignalStrengthGsm)localObject2).getDbm();
          if (!paramContext.isRegistered()) {
            continue;
          }
          paramContext = "1";
          locala.Aex = paramContext;
          if (Build.VERSION.SDK_INT < 24) {
            break label950;
          }
          locala.Aew = ((CellIdentityGsm)localObject1).getArfcn();
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
          locala.tzt = ((CellIdentityCdma)localObject2).getBasestationId();
          locala.tzs = ((CellIdentityCdma)localObject2).getSystemId();
          locala.Aep = ((CellIdentityCdma)localObject2).getNetworkId();
          locala.Aet = ((CellSignalStrengthCdma)localObject1).getDbm();
          if (paramContext.isRegistered())
          {
            paramContext = "1";
            locala.Aex = paramContext;
          }
        }
        else
        {
          if ((paramContext instanceof CellInfoLte))
          {
            localObject2 = ((CellInfoLte)paramContext).getCellSignalStrength();
            localObject1 = ((CellInfoLte)paramContext).getCellIdentity();
            i = ((CellIdentityLte)localObject1).getMnc();
            locala.tzt = ((CellIdentityLte)localObject1).getCi();
            locala.tzr = ((CellIdentityLte)localObject1).getMcc();
            locala.tzs = ((CellIdentityLte)localObject1).getMnc();
            locala.Aeq = ((CellIdentityLte)localObject1).getTac();
            locala.Aet = ((CellSignalStrengthLte)localObject2).getDbm();
            if (!paramContext.isRegistered()) {
              break label963;
            }
            paramContext = "1";
            locala.Aex = paramContext;
            if (Build.VERSION.SDK_INT < 24) {
              break label960;
            }
            locala.Aeu = ((CellIdentityLte)localObject1).getEarfcn();
            break label960;
          }
          if ((j >= 18) && ((paramContext instanceof CellInfoWcdma)))
          {
            localObject2 = ((CellInfoWcdma)paramContext).getCellSignalStrength();
            localObject1 = ((CellInfoWcdma)paramContext).getCellIdentity();
            i = ((CellIdentityWcdma)localObject1).getMnc();
            locala.tzt = ((CellIdentityWcdma)localObject1).getCid();
            locala.tzr = ((CellIdentityWcdma)localObject1).getMcc();
            locala.tzs = ((CellIdentityWcdma)localObject1).getMnc();
            locala.Aep = ((CellIdentityWcdma)localObject1).getLac();
            locala.Aet = ((CellSignalStrengthWcdma)localObject2).getDbm();
            if (!paramContext.isRegistered()) {
              break label973;
            }
            paramContext = "1";
            locala.Aex = paramContext;
            if (Build.VERSION.SDK_INT < 24) {
              break label970;
            }
            locala.Aev = ((CellIdentityWcdma)localObject1).getUarfcn();
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
  
  private static void jE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(70290);
    if (Aem == null) {
      Aem = new az();
    }
    ad.d("MicroMsg.GpsReportHelper", "encrypt data userInfo:%s, cellInfo:%s", new Object[] { paramString1, paramString2 });
    byte[] arrayOfByte3 = new byte[16];
    byte[] arrayOfByte2 = y.fjW().getBytes();
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
    Aem.Cvi = o.ebU().bR(arrayOfByte1);
    ad.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_key %s", new Object[] { Aem.Cvi });
    if (!bt.isNullOrNil(paramString1))
    {
      paramString1 = Base64.encode(AesEcb.aesCryptEcb(paramString1.getBytes(), arrayOfByte3, true, true), 0);
      Aem.Cvh = new String(paramString1);
      ad.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_userinfo %s", new Object[] { new String(paramString1) });
    }
    if (!bt.isNullOrNil(paramString2))
    {
      paramString1 = Base64.encode(AesEcb.aesCryptEcb(paramString2.getBytes(), arrayOfByte3, true, true), 0);
      Aem.Cvj = new String(paramString1);
      ad.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_cellinfo %s", new Object[] { new String(paramString1) });
    }
    AppMethodBeat.o(70290);
  }
  
  private static String qg(String paramString)
  {
    AppMethodBeat.i(70288);
    try
    {
      String str = p.encode(paramString, "UTF-8");
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
  
  public static boolean shouldReportCellInfo()
  {
    AppMethodBeat.i(70297);
    boolean bool = s.ecc().ecN().ecz();
    AppMethodBeat.o(70297);
    return bool;
  }
  
  public static boolean shouldReportLocation()
  {
    AppMethodBeat.i(70295);
    boolean bool = s.ecc().ecN().Ja();
    AppMethodBeat.o(70295);
    return bool;
  }
  
  public static final class a
  {
    public String Aep;
    public String Aeq;
    public String Aer;
    public String Aes;
    public String Aet;
    public String Aeu;
    public String Aev;
    public String Aew;
    public String Aex;
    public String lrk;
    public String systemId;
    public String type;
    public String tzr;
    public String tzs;
    public String tzt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.k
 * JD-Core Version:    0.7.0.1
 */