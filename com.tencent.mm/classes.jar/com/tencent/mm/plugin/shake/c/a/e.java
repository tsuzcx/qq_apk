package com.tencent.mm.plugin.shake.c.a;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.cb;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.protocal.protobuf.dav;
import com.tencent.mm.protocal.protobuf.dba;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends p
  implements m
{
  private long PBp;
  int action;
  private com.tencent.mm.am.h callback;
  final c oDw;
  
  public e(Collection<j.a> paramCollection, float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(28280);
    this.action = 1;
    this.PBp = 0L;
    this.action = 1;
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = new dau();
    ((c.a)localObject1).otF = new dav();
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/ibeaconboardcast";
    ((c.a)localObject1).funcId = 658;
    ((c.a)localObject1).otG = 0;
    ((c.a)localObject1).respCmdId = 0;
    this.oDw = ((c.a)localObject1).bEF();
    Object localObject2 = cb.bDe();
    localObject1 = Util.nullAsNil(((cb)localObject2).provinceCode);
    localObject2 = Util.nullAsNil(((cb)localObject2).cityCode);
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    dau localdau = (dau)c.b.b(this.oDw.otB);
    localdau.aaGq = Util.nullAsNil(null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"Beacons\":[");
    if (paramCollection != null)
    {
      j = paramCollection.size();
      Iterator localIterator = paramCollection.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        j.a locala = (j.a)localIterator.next();
        localStringBuilder.append("{\"UUID\":\"" + locala.uuid + "\",\"Location\":{\"Major\":" + locala.rid + ",\"Minor\":" + locala.rie + "},\"Distance\":" + locala.sgn + ",\"Extra\":\"\",\"MacAddress\":\"" + locala.PBy + "\",\"Rssi\":\"" + locala.PBz + "\",\"MeasurePower\":\"" + locala.PBA + "\"}");
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
    localStringBuilder.append("],\"Action\":1,\"LBS\":{\"Latitude\":" + paramFloat1 + ",\"Longitude\":" + paramFloat2 + ",\"Province\":\"" + (String)localObject1 + "\",\"City\":\"" + (String)localObject2 + "\"},\"MachineID\":\"" + q.aPg() + "\",\"ZBBeaconState\":\"" + i + "\"}");
    localdau.nUB = localStringBuilder.toString();
    if (paramCollection != null) {}
    for (i = paramCollection.size();; i = 0)
    {
      Log.i("MicroMsg.NetSceneShakeIbeacon", "[oneliang]beaconCollection.size:%d,json:%s", new Object[] { Integer.valueOf(i), localdau.nUB });
      n.a(2008, paramFloat2, paramFloat1, paramInt);
      AppMethodBeat.o(28280);
      return;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(28281);
    this.PBp = System.currentTimeMillis();
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
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
    this.PBp = (System.currentTimeMillis() - this.PBp);
    com.tencent.mm.plugin.report.service.h.OAn.b(11497, new Object[] { String.valueOf((int)(this.PBp / 1000L + 0.5D)), Integer.valueOf(1), Integer.valueOf((int)this.PBp) });
    Object localObject1;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end ok");
      paramString = (dav)c.c.b(this.oDw.otC);
      try
      {
        params = new JSONObject(((dau)c.b.b(this.oDw.otB)).nUB);
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
          if ((paramString.aaGr != null) && (paramString.aaGr.aaGv == 0))
          {
            localObject2 = paramString.aaGr.IHO;
            if ((paramInt2 == 1) && (localObject2 != null) && (!((String)localObject2).equals("")) && (new JSONObject((String)localObject2).getJSONArray("msgs").length() == 0)) {
              com.tencent.mm.plugin.report.service.h.OAn.b(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), localObject1, Integer.valueOf(paramInt3), Integer.valueOf(i), params, paramArrayOfByte, Integer.valueOf(2), Integer.valueOf(paramString.aaGr.aaGv) });
            }
            AppMethodBeat.o(28282);
            return;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), localObject1, Integer.valueOf(paramInt3), Integer.valueOf(i), params, paramArrayOfByte, Integer.valueOf(2), Integer.valueOf(paramString.aaGr.aaGv) });
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
      com.tencent.mm.plugin.report.service.h.OAn.b(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), "", Integer.valueOf(0), Integer.valueOf(0), params, paramArrayOfByte, Integer.valueOf(2), Integer.valueOf(paramString.aaGr.aaGv) });
      AppMethodBeat.o(28282);
      return;
    }
    Log.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end not ok");
    paramString = ((dau)c.b.b(this.oDw.otB)).nUB;
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
        com.tencent.mm.plugin.report.service.h.OAn.b(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), paramArrayOfByte, Integer.valueOf(paramInt2), Integer.valueOf(i), paramString, params, Integer.valueOf(1), Integer.valueOf(paramInt3) });
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
    com.tencent.mm.plugin.report.service.h.OAn.b(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), "", Integer.valueOf(0), Integer.valueOf(0), paramString, params, Integer.valueOf(1), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(28282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.e
 * JD-Core Version:    0.7.0.1
 */