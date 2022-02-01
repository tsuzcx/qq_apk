package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.bz;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cck;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.protocal.protobuf.ccq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.ak.q
  implements m
{
  private long DiL;
  int action;
  private i callback;
  final com.tencent.mm.ak.d iUB;
  
  public d(Collection<h.a> paramCollection, float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(28280);
    this.action = 1;
    this.DiL = 0L;
    this.action = 1;
    Object localObject1 = new d.a();
    ((d.a)localObject1).iLN = new cck();
    ((d.a)localObject1).iLO = new ccl();
    ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/ibeaconboardcast";
    ((d.a)localObject1).funcId = 658;
    ((d.a)localObject1).iLP = 0;
    ((d.a)localObject1).respCmdId = 0;
    this.iUB = ((d.a)localObject1).aXF();
    Object localObject2 = bz.aWj();
    localObject1 = Util.nullAsNil(((bz)localObject2).provinceCode);
    localObject2 = Util.nullAsNil(((bz)localObject2).cityCode);
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    cck localcck = (cck)this.iUB.iLK.iLR;
    localcck.Mis = Util.nullAsNil(null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"Beacons\":[");
    if (paramCollection != null)
    {
      j = paramCollection.size();
      Iterator localIterator = paramCollection.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        h.a locala = (h.a)localIterator.next();
        localStringBuilder.append("{\"UUID\":\"" + locala.uuid + "\",\"Location\":{\"Major\":" + locala.major + ",\"Minor\":" + locala.minor + "},\"Distance\":" + locala.jiP + ",\"Extra\":\"\",\"MacAddress\":\"" + locala.DiU + "\",\"Rssi\":\"" + locala.DiV + "\",\"MeasurePower\":\"" + locala.DiW + "\"}");
        if (i < j - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
    }
    int j = 1;
    boolean bool = MMApplicationContext.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    int i = j;
    if (localBluetoothAdapter != null)
    {
      i = j;
      if (localBluetoothAdapter.getState() == 12)
      {
        i = j;
        if (Build.VERSION.SDK_INT >= 18)
        {
          i = j;
          if (bool) {
            i = 0;
          }
        }
      }
    }
    localStringBuilder.append("],\"Action\":1,\"LBS\":{\"Latitude\":" + paramFloat1 + ",\"Longitude\":" + paramFloat2 + ",\"Province\":\"" + (String)localObject1 + "\",\"City\":\"" + (String)localObject2 + "\"},\"MachineID\":\"" + com.tencent.mm.compatible.deviceinfo.q.aoG() + "\",\"ZBBeaconState\":\"" + i + "\"}");
    localcck.iAc = localStringBuilder.toString();
    if (paramCollection != null) {}
    for (i = paramCollection.size();; i = 0)
    {
      Log.i("MicroMsg.NetSceneShakeIbeacon", "[oneliang]beaconCollection.size:%d,json:%s", new Object[] { Integer.valueOf(i), localcck.iAc });
      o.a(2008, paramFloat2, paramFloat1, paramInt);
      AppMethodBeat.o(28280);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(28281);
    this.DiL = System.currentTimeMillis();
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(28281);
    return i;
  }
  
  public final int getType()
  {
    return 658;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28282);
    Log.i("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.DiL = (System.currentTimeMillis() - this.DiL);
    h.CyF.a(11497, new Object[] { String.valueOf((int)(this.DiL / 1000L + 0.5D)), Integer.valueOf(1), Integer.valueOf((int)this.DiL) });
    Object localObject1;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end ok");
      paramString = (ccl)this.iUB.iLL.iLR;
      try
      {
        params = new JSONObject(((cck)this.iUB.iLK.iLR).iAc);
        localObject1 = params.getJSONArray("Beacons");
        paramInt1 = ((JSONArray)localObject1).length();
        paramArrayOfByte = params.getJSONObject("LBS");
        paramInt2 = params.getInt("Action");
        params = paramArrayOfByte.getString("Latitude");
        paramArrayOfByte = paramArrayOfByte.getString("Longitude");
        if (paramInt1 > 0)
        {
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(0);
          localObject1 = ((JSONObject)localObject2).getString("UUID");
          localObject2 = ((JSONObject)localObject2).getJSONObject("Location");
          paramInt3 = ((JSONObject)localObject2).getInt("Major");
          i = ((JSONObject)localObject2).getInt("Minor");
          if ((paramString.Mit != null) && (paramString.Mit.LjQ == 0))
          {
            localObject2 = paramString.Mit.xJz;
            if ((paramInt2 == 1) && (localObject2 != null) && (!((String)localObject2).equals("")) && (new JSONObject((String)localObject2).getJSONArray("msgs").length() == 0)) {
              h.CyF.a(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), localObject1, Integer.valueOf(paramInt3), Integer.valueOf(i), params, paramArrayOfByte, Integer.valueOf(2), Integer.valueOf(paramString.Mit.LjQ) });
            }
            AppMethodBeat.o(28282);
            return;
          }
          h.CyF.a(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), localObject1, Integer.valueOf(paramInt3), Integer.valueOf(i), params, paramArrayOfByte, Integer.valueOf(2), Integer.valueOf(paramString.Mit.LjQ) });
          AppMethodBeat.o(28282);
          return;
        }
      }
      catch (JSONException paramString)
      {
        Log.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
        AppMethodBeat.o(28282);
        return;
      }
      h.CyF.a(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), "", Integer.valueOf(0), Integer.valueOf(0), params, paramArrayOfByte, Integer.valueOf(2), Integer.valueOf(paramString.Mit.LjQ) });
      AppMethodBeat.o(28282);
      return;
    }
    Log.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end not ok");
    paramString = ((cck)this.iUB.iLK.iLR).iAc;
    try
    {
      paramString = new JSONObject(paramString);
      paramArrayOfByte = paramString.getJSONArray("Beacons");
      paramInt1 = paramArrayOfByte.length();
      params = paramString.getJSONObject("LBS");
      paramString = params.getString("Latitude");
      params = params.getString("Longitude");
      if (paramInt1 > 0)
      {
        localObject1 = paramArrayOfByte.getJSONObject(0);
        paramArrayOfByte = ((JSONObject)localObject1).getString("UUID");
        localObject1 = ((JSONObject)localObject1).getJSONObject("Location");
        paramInt2 = ((JSONObject)localObject1).getInt("Major");
        i = ((JSONObject)localObject1).getInt("Minor");
        h.CyF.a(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), paramArrayOfByte, Integer.valueOf(paramInt2), Integer.valueOf(i), paramString, params, Integer.valueOf(1), Integer.valueOf(paramInt3) });
        AppMethodBeat.o(28282);
        return;
      }
    }
    catch (JSONException paramString)
    {
      Log.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
      AppMethodBeat.o(28282);
      return;
    }
    h.CyF.a(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), "", Integer.valueOf(0), Integer.valueOf(0), paramString, params, Integer.valueOf(1), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(28282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.d
 * JD-Core Version:    0.7.0.1
 */