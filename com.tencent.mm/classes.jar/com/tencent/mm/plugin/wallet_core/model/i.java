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
import android.util.Base64;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.aw;
import com.tencent.mm.protocal.c.bdd;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;

public final class i
{
  private static i.b qvI;
  private static i qvJ;
  private static aw qvK = null;
  private static long qvL = 0L;
  public JSONArray qvM;
  
  private i()
  {
    g.DQ();
    String str = (String)g.DP().Dz().get(ac.a.ust, "");
    y.i("MicroMsg.GpsReportHelper", "GpsReportHelper " + str);
    if (!bk.bl(str)) {}
    try
    {
      this.qvM = new JSONArray(str);
      return;
    }
    catch (JSONException localJSONException)
    {
      y.printErrStackTrace("MicroMsg.GpsReportHelper", localJSONException, "", new Object[0]);
      y.e("MicroMsg.GpsReportHelper", "parse lbs config error", new Object[] { localJSONException });
    }
  }
  
  public static void AN(int paramInt)
  {
    y.i("MicroMsg.GpsReportHelper", "reflashLocationInfo " + paramInt);
    qvL = System.currentTimeMillis() / 1000L;
    if (!bVk())
    {
      qvI = null;
      bVi();
      qvL = System.currentTimeMillis() / 1000L;
    }
  }
  
  public static i bVe()
  {
    if (qvJ == null) {
      qvJ = new i();
    }
    return qvJ;
  }
  
  private static String bVf()
  {
    long l = System.currentTimeMillis();
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      localObject = com.tencent.mm.sdk.platformtools.ae.getContext();
      if (localObject == null) {
        return "";
      }
      localObject = (WifiManager)((Context)localObject).getSystemService("wifi");
      ((WifiManager)localObject).getConnectionInfo();
      new StringBuffer();
      new StringBuffer();
      localObject = ((WifiManager)localObject).getScanResults().iterator();
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        int i;
        ScanResult localScanResult;
        y.printErrStackTrace("MicroMsg.GpsReportHelper", localException, "", new Object[0]);
      }
    }
    if (((Iterator)localObject).hasNext())
    {
      localScanResult = (ScanResult)((Iterator)localObject).next();
      localStringBuffer.append(String.format("&scan_ssid%d=%s&scan_bssid%d=%s", new Object[] { Integer.valueOf(i), xK(localScanResult.SSID), Integer.valueOf(i), xK(localScanResult.BSSID) }));
      i += 1;
      if (i < 5) {}
    }
    else
    {
      y.e("MicroMsg.GpsReportHelper", "RecordCostTime: readScanWifi cost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return localStringBuffer.toString();
    }
  }
  
  private static String bVg()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = new HashMap();
    if (!bVl()) {
      return "";
    }
    ((HashMap)localObject1).put("is_ci_permitted", "0");
    ((HashMap)localObject1).put("net_type", aq.fH(com.tencent.mm.sdk.platformtools.ae.getContext()));
    y.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 01- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    long l2 = System.currentTimeMillis();
    l1 = l2;
    if (bVh())
    {
      ((HashMap)localObject1).put("is_ci_permitted", "1");
      ((HashMap)localObject1).put("uuid", UUID.randomUUID().toString());
      ((HashMap)localObject1).put("sample_time", System.currentTimeMillis() / 1000L);
      ((HashMap)localObject1).put("phone_brand", Build.BRAND);
      ((HashMap)localObject1).put("phone_model", Build.MODEL);
    }
    try
    {
      if (com.tencent.mm.sdk.platformtools.ae.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)
      {
        localObject2 = ((ConnectivityManager)com.tencent.mm.sdk.platformtools.ae.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (localObject2 != null) {
          ((HashMap)localObject1).put("net_subtype", ((NetworkInfo)localObject2).getSubtype());
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      label220:
      int j;
      int i;
      Object localObject3;
      break label220;
    }
    y.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 02- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
    l1 = System.currentTimeMillis();
    localObject2 = dK(com.tencent.mm.sdk.platformtools.ae.getContext());
    y.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 03- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    l1 = System.currentTimeMillis();
    j = ((List)localObject2).size();
    i = 0;
    while (i < j)
    {
      localObject3 = (i.a)((List)localObject2).get(i);
      if (localObject3 != null)
      {
        ((HashMap)localObject1).put("mcc_" + i, ((i.a)localObject3).mdQ);
        ((HashMap)localObject1).put("mnc_" + i, ((i.a)localObject3).mdR);
        ((HashMap)localObject1).put("lac_" + i, ((i.a)localObject3).qvN);
        ((HashMap)localObject1).put("cell_id_" + i, ((i.a)localObject3).mdS);
        ((HashMap)localObject1).put("type_" + i, ((i.a)localObject3).type);
        ((HashMap)localObject1).put("sid_" + i, ((i.a)localObject3).qvP);
        ((HashMap)localObject1).put("net_id_" + i, ((i.a)localObject3).qvQ);
        ((HashMap)localObject1).put("sys_id_" + i, ((i.a)localObject3).systemId);
        ((HashMap)localObject1).put("dbm_" + i, ((i.a)localObject3).qvR);
        ((HashMap)localObject1).put("tac_" + i, ((i.a)localObject3).qvO);
        ((HashMap)localObject1).put("arfcn_" + i, ((i.a)localObject3).qvU);
        ((HashMap)localObject1).put("earfcn_" + i, ((i.a)localObject3).qvS);
        ((HashMap)localObject1).put("uarfcn_" + i, ((i.a)localObject3).qvT);
        ((HashMap)localObject1).put("dbm_" + i, ((i.a)localObject3).qvR);
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
      if (!bk.bl(str2)) {
        ((StringBuilder)localObject2).append(String.format("&%s=%s", new Object[] { str1, xK(str2) }));
      }
    }
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = localObject2;
    if (!bk.bl((String)localObject2))
    {
      localObject1 = localObject2;
      if (((String)localObject2).indexOf("&") == 0) {
        localObject1 = ((String)localObject2).substring(1);
      }
    }
    y.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 03- %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    return localObject1;
  }
  
  private static boolean bVh()
  {
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME))) {}
    for (;;)
    {
      return true;
      try
      {
        int i = b.checkSelfPermission(com.tencent.mm.sdk.platformtools.ae.getContext(), "android.permission.ACCESS_COARSE_LOCATION");
        if (i != 0) {
          return false;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.GpsReportHelper", "check permission exception:%s.", new Object[] { localException });
      }
    }
    return true;
  }
  
  private static void bVi()
  {
    long l = System.currentTimeMillis();
    if (bVk()) {
      return;
    }
    Object localObject = o.bVs().bVR();
    boolean bool;
    String str1;
    if ((((ae)localObject).qza & 0x40000) > 0)
    {
      bool = true;
      y.i("MicroMsg.WalletSwitchConfig", "isReportWifiSSid, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(((ae)localObject).qza) });
      if ((bool) || (bVl()))
      {
        WifiInfo localWifiInfo = aq.getWifiInfo(com.tencent.mm.sdk.platformtools.ae.getContext());
        String str3 = "";
        String str2 = "";
        str1 = "";
        localObject = "";
        if (localWifiInfo != null)
        {
          str3 = localWifiInfo.getSSID();
          str2 = System.currentTimeMillis();
          str1 = localWifiInfo.getBSSID();
          localObject = localWifiInfo.getMacAddress();
        }
        localObject = String.format("wifissid=%s&wifibssid=%s&wifimac=%s&ssid_timestamp=%s", new Object[] { xK(str3), xK(str1), xK((String)localObject), str2 });
        str1 = bVf();
        str1 = (String)localObject + str1;
        if (!bVl()) {
          break label247;
        }
      }
    }
    label247:
    for (localObject = bVg();; localObject = null)
    {
      fk(str1, (String)localObject);
      y.e("MicroMsg.GpsReportHelper", "RecordCostTime: refreshWifiAndCellInfo cost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
      bool = false;
      break;
    }
  }
  
  public static aw bVj()
  {
    long l = System.currentTimeMillis() / 1000L;
    if (l - qvL > 300L)
    {
      bVi();
      qvL = l;
    }
    return qvK;
  }
  
  private static boolean bVk()
  {
    ae localae = o.bVs().bVR();
    if ((localae.qza & 0x2000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localae.qza) });
      return bool;
    }
  }
  
  public static boolean bVl()
  {
    ae localae = o.bVs().bVR();
    if ((localae.qza & 0x800000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.WalletSwitchConfig", "isReportCellInfo, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localae.qza) });
      return bool;
    }
  }
  
  public static bdd bkn()
  {
    if (qvK == null) {
      return null;
    }
    bdd localbdd = new bdd();
    localbdd.cCB = qvK.cCB;
    localbdd.cCA = qvK.cCA;
    localbdd.latitude = qvK.latitude;
    localbdd.longitude = qvK.longitude;
    localbdd.sum = qvK.sum;
    localbdd.suq = qvK.suq;
    localbdd.sun = qvK.sun;
    localbdd.suo = qvK.suo;
    localbdd.sup = qvK.sup;
    return localbdd;
  }
  
  private static List<i.a> dK(Context paramContext)
  {
    for (;;)
    {
      try
      {
        LinkedList localLinkedList = new LinkedList();
        TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        int j = Build.VERSION.SDK_INT;
        i.a locala;
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
          locala = new i.a();
          locala.gYR = localTelephonyManager.getNetworkType();
          if (!(paramContext instanceof CellInfoGsm)) {
            continue;
          }
          localObject2 = ((CellInfoGsm)paramContext).getCellSignalStrength();
          localObject1 = ((CellInfoGsm)paramContext).getCellIdentity();
          i = ((CellIdentityGsm)localObject1).getMnc();
          locala.mdS = ((CellIdentityGsm)localObject1).getCid();
          locala.mdQ = ((CellIdentityGsm)localObject1).getMcc();
          locala.mdR = ((CellIdentityGsm)localObject1).getMnc();
          locala.qvN = ((CellIdentityGsm)localObject1).getLac();
          locala.qvR = ((CellSignalStrengthGsm)localObject2).getDbm();
          if (!paramContext.isRegistered()) {
            continue;
          }
          paramContext = "1";
          locala.qvV = paramContext;
          if (Build.VERSION.SDK_INT < 24) {
            break label933;
          }
          locala.qvU = ((CellIdentityGsm)localObject1).getArfcn();
        }
        catch (Exception paramContext)
        {
          y.e("MicroMsg.GpsReportHelper", "loadCellInfo: Unable to obtain cell signal information: ", new Object[] { paramContext });
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
          locala.mdS = ((CellIdentityCdma)localObject2).getBasestationId();
          locala.mdR = ((CellIdentityCdma)localObject2).getSystemId();
          locala.qvN = ((CellIdentityCdma)localObject2).getNetworkId();
          locala.qvR = ((CellSignalStrengthCdma)localObject1).getDbm();
          if (paramContext.isRegistered())
          {
            paramContext = "1";
            locala.qvV = paramContext;
          }
        }
        else
        {
          if ((paramContext instanceof CellInfoLte))
          {
            localObject2 = ((CellInfoLte)paramContext).getCellSignalStrength();
            localObject1 = ((CellInfoLte)paramContext).getCellIdentity();
            i = ((CellIdentityLte)localObject1).getMnc();
            locala.mdS = ((CellIdentityLte)localObject1).getCi();
            locala.mdQ = ((CellIdentityLte)localObject1).getMcc();
            locala.mdR = ((CellIdentityLte)localObject1).getMnc();
            locala.qvO = ((CellIdentityLte)localObject1).getTac();
            locala.qvR = ((CellSignalStrengthLte)localObject2).getDbm();
            if (!paramContext.isRegistered()) {
              break label945;
            }
            paramContext = "1";
            locala.qvV = paramContext;
            if (Build.VERSION.SDK_INT < 24) {
              break label942;
            }
            locala.qvS = ((CellIdentityLte)localObject1).getEarfcn();
            break label942;
          }
          if ((j >= 18) && ((paramContext instanceof CellInfoWcdma)))
          {
            localObject2 = ((CellInfoWcdma)paramContext).getCellSignalStrength();
            localObject1 = ((CellInfoWcdma)paramContext).getCellIdentity();
            i = ((CellIdentityWcdma)localObject1).getMnc();
            locala.mdS = ((CellIdentityWcdma)localObject1).getCid();
            locala.mdQ = ((CellIdentityWcdma)localObject1).getMcc();
            locala.mdR = ((CellIdentityWcdma)localObject1).getMnc();
            locala.qvN = ((CellIdentityWcdma)localObject1).getLac();
            locala.qvR = ((CellSignalStrengthWcdma)localObject2).getDbm();
            if (!paramContext.isRegistered()) {
              break label954;
            }
            paramContext = "1";
            locala.qvV = paramContext;
            if (Build.VERSION.SDK_INT < 24) {
              break label951;
            }
            locala.qvT = ((CellIdentityWcdma)localObject1).getUarfcn();
            break label951;
          }
          y.i("MicroMsg.GpsReportHelper", "Unknown type of cell signal!\n ClassName: " + paramContext.getClass().getSimpleName() + "\n ToString: " + paramContext.toString());
          i = 0;
          continue;
          continue;
        }
      }
      finally {}
      label933:
      paramContext = "0";
      continue;
      label942:
      continue;
      label945:
      paramContext = "0";
      continue;
      label951:
      continue;
      label954:
      paramContext = "0";
    }
  }
  
  private static void fk(String paramString1, String paramString2)
  {
    if (qvK == null) {
      qvK = new aw();
    }
    y.d("MicroMsg.GpsReportHelper", "encrypt data userInfo:%s, cellInfo:%s", new Object[] { paramString1, paramString2 });
    byte[] arrayOfByte = new byte[16];
    Object localObject2 = u.cMz().getBytes();
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > 0) {}
    }
    else
    {
      localObject1 = System.currentTimeMillis().getBytes();
    }
    int j = 0;
    int i = 0;
    int k;
    do
    {
      arrayOfByte[i] = localObject1[j];
      k = i + 1;
      j += 1;
      i = j;
      if (j >= localObject1.length) {
        i = 0;
      }
      j = i;
      i = k;
    } while (k < 16);
    Object localObject1 = Base64.encode(arrayOfByte, 0);
    localObject2 = qvK;
    if (l.qvW == null) {
      l.qvW = new l();
    }
    ((aw)localObject2).suq = l.qvW.aY((byte[])localObject1);
    y.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_key %s", new Object[] { qvK.suq });
    if (!bk.bl(paramString1))
    {
      paramString1 = Base64.encode(AesEcb.aesCryptEcb(paramString1.getBytes(), arrayOfByte, true, true), 0);
      qvK.sup = new String(paramString1);
      y.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_userinfo %s", new Object[] { new String(paramString1) });
    }
    if (!bk.bl(paramString2))
    {
      paramString1 = Base64.encode(AesEcb.aesCryptEcb(paramString2.getBytes(), arrayOfByte, true, true), 0);
      qvK.sur = new String(paramString1);
      y.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_cellinfo %s", new Object[] { new String(paramString1) });
    }
  }
  
  private static String xK(String paramString)
  {
    try
    {
      String str = q.encode(paramString, "UTF-8");
      return str;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.GpsReportHelper", localException, "", new Object[0]);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.i
 * JD-Core Version:    0.7.0.1
 */