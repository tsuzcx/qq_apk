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
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c.w;
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

public final class m
{
  private static m.b uie;
  private static m uif;
  private static aw uig = null;
  private static long uih = 0L;
  public JSONArray uii;
  
  private m()
  {
    AppMethodBeat.i(46766);
    g.RM();
    String str = (String)g.RL().Ru().get(ac.a.yCt, "");
    ab.i("MicroMsg.GpsReportHelper", "GpsReportHelper ".concat(String.valueOf(str)));
    if (!bo.isNullOrNil(str)) {
      try
      {
        this.uii = new JSONArray(str);
        AppMethodBeat.o(46766);
        return;
      }
      catch (JSONException localJSONException)
      {
        ab.printErrStackTrace("MicroMsg.GpsReportHelper", localJSONException, "", new Object[0]);
        ab.e("MicroMsg.GpsReportHelper", "parse lbs config error", new Object[] { localJSONException });
      }
    }
    AppMethodBeat.o(46766);
  }
  
  public static void Iy(int paramInt)
  {
    AppMethodBeat.i(46773);
    ab.i("MicroMsg.GpsReportHelper", "reflashLocationInfo ".concat(String.valueOf(paramInt)));
    uih = System.currentTimeMillis() / 1000L;
    if (!cTD())
    {
      uie = null;
      cTB();
      uih = System.currentTimeMillis() / 1000L;
    }
    AppMethodBeat.o(46773);
  }
  
  public static aw ak(Map<String, String> paramMap)
  {
    AppMethodBeat.i(142484);
    Object localObject1 = new ArrayList();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      localObject2 = (Map.Entry)paramMap.next();
      ((ArrayList)localObject1).add((String)((Map.Entry)localObject2).getKey() + "=" + (String)((Map.Entry)localObject2).getValue());
    }
    Object localObject2 = TextUtils.join("&", (Iterable)localObject1);
    byte[] arrayOfByte = new byte[16];
    localObject1 = w.dSo().getBytes();
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
    paramMap = new aw();
    localObject1 = Base64.encode(arrayOfByte, 0);
    paramMap.wmT = q.cTG().bz((byte[])localObject1);
    paramMap.wmS = new String(Base64.encode(AesEcb.aesCryptEcb(((String)localObject2).getBytes(), arrayOfByte, true, true), 0));
    AppMethodBeat.o(142484);
    return paramMap;
  }
  
  public static bkx bSo()
  {
    AppMethodBeat.i(46776);
    if (uig == null)
    {
      AppMethodBeat.o(46776);
      return null;
    }
    bkx localbkx = new bkx();
    localbkx.city = uig.city;
    localbkx.province = uig.province;
    localbkx.latitude = uig.latitude;
    localbkx.longitude = uig.longitude;
    localbkx.wmP = uig.wmP;
    localbkx.wmT = uig.wmT;
    localbkx.wmQ = uig.wmQ;
    localbkx.wmR = uig.wmR;
    localbkx.wmS = uig.wmS;
    AppMethodBeat.o(46776);
    return localbkx;
  }
  
  private static boolean cTA()
  {
    AppMethodBeat.i(46770);
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(46770);
      return true;
    }
    try
    {
      int i = b.checkSelfPermission(ah.getContext(), "android.permission.ACCESS_COARSE_LOCATION");
      if (i == 0)
      {
        AppMethodBeat.o(46770);
        return true;
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.GpsReportHelper", "check permission exception:%s.", new Object[] { localException });
      AppMethodBeat.o(46770);
      return true;
    }
    AppMethodBeat.o(46770);
    return false;
  }
  
  private static void cTB()
  {
    AppMethodBeat.i(46774);
    long l = System.currentTimeMillis();
    if (cTD())
    {
      AppMethodBeat.o(46774);
      return;
    }
    if ((cTE()) || (cTF())) {}
    try
    {
      Object localObject = (WifiManager)ah.getContext().getApplicationContext().getSystemService("wifi");
      localObject = ((WifiManager)localObject).getConnectionInfo().getRssi();
      String str2 = at.gX(ah.getContext());
      String str3 = System.currentTimeMillis();
      String str4 = at.gY(ah.getContext());
      String str5 = com.tencent.mm.compatible.e.q.LH();
      localObject = String.format("wifissid=%s&wifibssid=%s&wifimac=%s&sm=%s&ssid_timestamp=%s", new Object[] { lQ(str2), lQ(str4), lQ(str5), localObject, str3 });
      str2 = cTy();
      str2 = (String)localObject + str2;
      if (cTF())
      {
        localObject = cTz();
        hb(str2, (String)localObject);
        ab.e("MicroMsg.GpsReportHelper", "RecordCostTime: refreshWifiAndCellInfo cost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(46774);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.GpsReportHelper", localException, "", new Object[0]);
        String str1 = "";
        continue;
        str1 = null;
      }
    }
  }
  
  public static aw cTC()
  {
    AppMethodBeat.i(46775);
    long l = System.currentTimeMillis() / 1000L;
    if (l - uih > 300L)
    {
      cTB();
      uih = l;
    }
    aw localaw = uig;
    AppMethodBeat.o(46775);
    return localaw;
  }
  
  private static boolean cTD()
  {
    AppMethodBeat.i(46777);
    boolean bool = t.cTN().cUt().aec();
    AppMethodBeat.o(46777);
    return bool;
  }
  
  private static boolean cTE()
  {
    AppMethodBeat.i(46778);
    boolean bool = t.cTN().cUt().cUg();
    AppMethodBeat.o(46778);
    return bool;
  }
  
  public static boolean cTF()
  {
    AppMethodBeat.i(46779);
    boolean bool = t.cTN().cUt().cUh();
    AppMethodBeat.o(46779);
    return bool;
  }
  
  public static m cTx()
  {
    AppMethodBeat.i(46767);
    if (uif == null) {
      uif = new m();
    }
    m localm = uif;
    AppMethodBeat.o(46767);
    return localm;
  }
  
  private static String cTy()
  {
    AppMethodBeat.i(46768);
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuffer();
    try
    {
      localObject2 = ah.getContext();
      if (localObject2 == null)
      {
        AppMethodBeat.o(46768);
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
        ab.printErrStackTrace("MicroMsg.GpsReportHelper", localException, "", new Object[0]);
      }
    }
    if (((Iterator)localObject2).hasNext())
    {
      localScanResult = (ScanResult)((Iterator)localObject2).next();
      ((StringBuffer)localObject1).append(String.format("&scan_ssid%d=%s&scan_bssid%d=%s&sm%d=%s", new Object[] { Integer.valueOf(i), lQ(localScanResult.SSID), Integer.valueOf(i), lQ(localScanResult.BSSID), Integer.valueOf(i), Integer.valueOf(localScanResult.level) }));
      i += 1;
      if (i < 5) {}
    }
    else
    {
      ab.e("MicroMsg.GpsReportHelper", "RecordCostTime: readScanWifi cost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      localObject1 = ((StringBuffer)localObject1).toString();
      AppMethodBeat.o(46768);
      return localObject1;
    }
  }
  
  private static String cTz()
  {
    AppMethodBeat.i(46769);
    long l1 = System.currentTimeMillis();
    Object localObject1 = new HashMap();
    if (!cTF())
    {
      AppMethodBeat.o(46769);
      return "";
    }
    ((HashMap)localObject1).put("is_ci_permitted", "0");
    ((HashMap)localObject1).put("net_type", at.gU(ah.getContext()));
    ab.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 01- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    long l2 = System.currentTimeMillis();
    l1 = l2;
    if (cTA())
    {
      ((HashMap)localObject1).put("is_ci_permitted", "1");
      ((HashMap)localObject1).put("uuid", UUID.randomUUID().toString());
      ((HashMap)localObject1).put("sample_time", System.currentTimeMillis() / 1000L);
      ((HashMap)localObject1).put("phone_brand", Build.BRAND);
      ((HashMap)localObject1).put("phone_model", Build.MODEL);
    }
    try
    {
      if (ah.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)
      {
        localObject2 = ((ConnectivityManager)ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
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
    ab.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 02- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
    l1 = System.currentTimeMillis();
    localObject2 = ew(ah.getContext());
    ab.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 03- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    l1 = System.currentTimeMillis();
    j = ((List)localObject2).size();
    i = 0;
    while (i < j)
    {
      localObject3 = (m.a)((List)localObject2).get(i);
      if (localObject3 != null)
      {
        ((HashMap)localObject1).put("mcc_".concat(String.valueOf(i)), ((m.a)localObject3).oEm);
        ((HashMap)localObject1).put("mnc_".concat(String.valueOf(i)), ((m.a)localObject3).oEn);
        ((HashMap)localObject1).put("lac_".concat(String.valueOf(i)), ((m.a)localObject3).uij);
        ((HashMap)localObject1).put("cell_id_".concat(String.valueOf(i)), ((m.a)localObject3).oEo);
        ((HashMap)localObject1).put("type_".concat(String.valueOf(i)), ((m.a)localObject3).type);
        ((HashMap)localObject1).put("sid_".concat(String.valueOf(i)), ((m.a)localObject3).uil);
        ((HashMap)localObject1).put("net_id_".concat(String.valueOf(i)), ((m.a)localObject3).uim);
        ((HashMap)localObject1).put("sys_id_".concat(String.valueOf(i)), ((m.a)localObject3).systemId);
        ((HashMap)localObject1).put("dbm_".concat(String.valueOf(i)), ((m.a)localObject3).uio);
        ((HashMap)localObject1).put("tac_".concat(String.valueOf(i)), ((m.a)localObject3).uik);
        ((HashMap)localObject1).put("arfcn_".concat(String.valueOf(i)), ((m.a)localObject3).uis);
        ((HashMap)localObject1).put("earfcn_".concat(String.valueOf(i)), ((m.a)localObject3).uiq);
        ((HashMap)localObject1).put("uarfcn_".concat(String.valueOf(i)), ((m.a)localObject3).uir);
        ((HashMap)localObject1).put("dbm_".concat(String.valueOf(i)), ((m.a)localObject3).uio);
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
      if (!bo.isNullOrNil(str2)) {
        ((StringBuilder)localObject2).append(String.format("&%s=%s", new Object[] { str1, lQ(str2) }));
      }
    }
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = localObject2;
    if (!bo.isNullOrNil((String)localObject2))
    {
      localObject1 = localObject2;
      if (((String)localObject2).indexOf("&") == 0) {
        localObject1 = ((String)localObject2).substring(1);
      }
    }
    ab.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 03- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(46769);
    return localObject1;
  }
  
  private static List<m.a> ew(Context paramContext)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(46780);
        LinkedList localLinkedList = new LinkedList();
        TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        int j = Build.VERSION.SDK_INT;
        m.a locala;
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
          locala = new m.a();
          locala.iHg = localTelephonyManager.getNetworkType();
          if (!(paramContext instanceof CellInfoGsm)) {
            continue;
          }
          localObject2 = ((CellInfoGsm)paramContext).getCellSignalStrength();
          localObject1 = ((CellInfoGsm)paramContext).getCellIdentity();
          i = ((CellIdentityGsm)localObject1).getMnc();
          locala.oEo = ((CellIdentityGsm)localObject1).getCid();
          locala.oEm = ((CellIdentityGsm)localObject1).getMcc();
          locala.oEn = ((CellIdentityGsm)localObject1).getMnc();
          locala.uij = ((CellIdentityGsm)localObject1).getLac();
          locala.uio = ((CellSignalStrengthGsm)localObject2).getDbm();
          if (!paramContext.isRegistered()) {
            continue;
          }
          paramContext = "1";
          locala.uit = paramContext;
          if (Build.VERSION.SDK_INT < 24) {
            break label950;
          }
          locala.uis = ((CellIdentityGsm)localObject1).getArfcn();
        }
        catch (Exception paramContext)
        {
          ab.e("MicroMsg.GpsReportHelper", "loadCellInfo: Unable to obtain cell signal information: ", new Object[] { paramContext });
          AppMethodBeat.o(46780);
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
          locala.oEo = ((CellIdentityCdma)localObject2).getBasestationId();
          locala.oEn = ((CellIdentityCdma)localObject2).getSystemId();
          locala.uij = ((CellIdentityCdma)localObject2).getNetworkId();
          locala.uio = ((CellSignalStrengthCdma)localObject1).getDbm();
          if (paramContext.isRegistered())
          {
            paramContext = "1";
            locala.uit = paramContext;
          }
        }
        else
        {
          if ((paramContext instanceof CellInfoLte))
          {
            localObject2 = ((CellInfoLte)paramContext).getCellSignalStrength();
            localObject1 = ((CellInfoLte)paramContext).getCellIdentity();
            i = ((CellIdentityLte)localObject1).getMnc();
            locala.oEo = ((CellIdentityLte)localObject1).getCi();
            locala.oEm = ((CellIdentityLte)localObject1).getMcc();
            locala.oEn = ((CellIdentityLte)localObject1).getMnc();
            locala.uik = ((CellIdentityLte)localObject1).getTac();
            locala.uio = ((CellSignalStrengthLte)localObject2).getDbm();
            if (!paramContext.isRegistered()) {
              break label963;
            }
            paramContext = "1";
            locala.uit = paramContext;
            if (Build.VERSION.SDK_INT < 24) {
              break label960;
            }
            locala.uiq = ((CellIdentityLte)localObject1).getEarfcn();
            break label960;
          }
          if ((j >= 18) && ((paramContext instanceof CellInfoWcdma)))
          {
            localObject2 = ((CellInfoWcdma)paramContext).getCellSignalStrength();
            localObject1 = ((CellInfoWcdma)paramContext).getCellIdentity();
            i = ((CellIdentityWcdma)localObject1).getMnc();
            locala.oEo = ((CellIdentityWcdma)localObject1).getCid();
            locala.oEm = ((CellIdentityWcdma)localObject1).getMcc();
            locala.oEn = ((CellIdentityWcdma)localObject1).getMnc();
            locala.uij = ((CellIdentityWcdma)localObject1).getLac();
            locala.uio = ((CellSignalStrengthWcdma)localObject2).getDbm();
            if (!paramContext.isRegistered()) {
              break label973;
            }
            paramContext = "1";
            locala.uit = paramContext;
            if (Build.VERSION.SDK_INT < 24) {
              break label970;
            }
            locala.uir = ((CellIdentityWcdma)localObject1).getUarfcn();
            break label970;
          }
          ab.i("MicroMsg.GpsReportHelper", "Unknown type of cell signal!\n ClassName: " + paramContext.getClass().getSimpleName() + "\n ToString: " + paramContext.toString());
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
  
  private static void hb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46772);
    if (uig == null) {
      uig = new aw();
    }
    ab.d("MicroMsg.GpsReportHelper", "encrypt data userInfo:%s, cellInfo:%s", new Object[] { paramString1, paramString2 });
    byte[] arrayOfByte3 = new byte[16];
    byte[] arrayOfByte2 = w.dSo().getBytes();
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
    uig.wmT = q.cTG().bz(arrayOfByte1);
    ab.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_key %s", new Object[] { uig.wmT });
    if (!bo.isNullOrNil(paramString1))
    {
      paramString1 = Base64.encode(AesEcb.aesCryptEcb(paramString1.getBytes(), arrayOfByte3, true, true), 0);
      uig.wmS = new String(paramString1);
      ab.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_userinfo %s", new Object[] { new String(paramString1) });
    }
    if (!bo.isNullOrNil(paramString2))
    {
      paramString1 = Base64.encode(AesEcb.aesCryptEcb(paramString2.getBytes(), arrayOfByte3, true, true), 0);
      uig.wmU = new String(paramString1);
      ab.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_cellinfo %s", new Object[] { new String(paramString1) });
    }
    AppMethodBeat.o(46772);
  }
  
  private static String lQ(String paramString)
  {
    AppMethodBeat.i(46771);
    try
    {
      String str = com.tencent.mm.compatible.util.q.encode(paramString, "UTF-8");
      paramString = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.GpsReportHelper", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(46771);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.m
 * JD-Core Version:    0.7.0.1
 */