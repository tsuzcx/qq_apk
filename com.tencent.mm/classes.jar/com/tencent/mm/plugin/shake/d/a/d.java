package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bv;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.bps;
import com.tencent.mm.protocal.protobuf.bpt;
import com.tencent.mm.protocal.protobuf.bpy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends n
  implements k
{
  int action;
  private f callback;
  final b hZD;
  private long zdT;
  
  public d(Collection<h.a> paramCollection, float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(28280);
    this.action = 1;
    this.zdT = 0L;
    this.action = 1;
    Object localObject1 = new b.a();
    ((b.a)localObject1).hQF = new bps();
    ((b.a)localObject1).hQG = new bpt();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/ibeaconboardcast";
    ((b.a)localObject1).funcId = 658;
    ((b.a)localObject1).hQH = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.hZD = ((b.a)localObject1).aDS();
    Object localObject2 = bv.aCL();
    localObject1 = bu.nullAsNil(((bv)localObject2).provinceCode);
    localObject2 = bu.nullAsNil(((bv)localObject2).cityCode);
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    bps localbps = (bps)this.hZD.hQD.hQJ;
    localbps.Hdp = bu.nullAsNil(null);
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
        localStringBuilder.append("{\"UUID\":\"" + locala.uuid + "\",\"Location\":{\"Major\":" + locala.major + ",\"Minor\":" + locala.minor + "},\"Distance\":" + locala.inH + ",\"Extra\":\"\",\"MacAddress\":\"" + locala.zec + "\",\"Rssi\":\"" + locala.zed + "\",\"MeasurePower\":\"" + locala.zee + "\"}");
        if (i < j - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
    }
    int j = 1;
    boolean bool = ak.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
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
    localStringBuilder.append("],\"Action\":1,\"LBS\":{\"Latitude\":" + paramFloat1 + ",\"Longitude\":" + paramFloat2 + ",\"Province\":\"" + (String)localObject1 + "\",\"City\":\"" + (String)localObject2 + "\"},\"MachineID\":\"" + com.tencent.mm.compatible.deviceinfo.q.aaH() + "\",\"ZBBeaconState\":\"" + i + "\"}");
    localbps.hFS = localStringBuilder.toString();
    if (paramCollection != null) {}
    for (i = paramCollection.size();; i = 0)
    {
      ae.i("MicroMsg.NetSceneShakeIbeacon", "[oneliang]beaconCollection.size:%d,json:%s", new Object[] { Integer.valueOf(i), localbps.hFS });
      o.a(2008, paramFloat2, paramFloat1, paramInt);
      AppMethodBeat.o(28280);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(28281);
    this.zdT = System.currentTimeMillis();
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(28281);
    return i;
  }
  
  public final int getType()
  {
    return 658;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28282);
    ae.i("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.zdT = (System.currentTimeMillis() - this.zdT);
    g.yxI.f(11497, new Object[] { String.valueOf((int)(this.zdT / 1000L + 0.5D)), Integer.valueOf(1), Integer.valueOf((int)this.zdT) });
    Object localObject1;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ae.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end ok");
      paramString = (bpt)this.hZD.hQE.hQJ;
      try
      {
        paramq = new JSONObject(((bps)this.hZD.hQD.hQJ).hFS);
        localObject1 = paramq.getJSONArray("Beacons");
        paramInt1 = ((JSONArray)localObject1).length();
        paramArrayOfByte = paramq.getJSONObject("LBS");
        paramInt2 = paramq.getInt("Action");
        paramq = paramArrayOfByte.getString("Latitude");
        paramArrayOfByte = paramArrayOfByte.getString("Longitude");
        if (paramInt1 > 0)
        {
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(0);
          localObject1 = ((JSONObject)localObject2).getString("UUID");
          localObject2 = ((JSONObject)localObject2).getJSONObject("Location");
          paramInt3 = ((JSONObject)localObject2).getInt("Major");
          i = ((JSONObject)localObject2).getInt("Minor");
          if ((paramString.Hdq != null) && (paramString.Hdq.Gpf == 0))
          {
            localObject2 = paramString.Hdq.urg;
            if ((paramInt2 == 1) && (localObject2 != null) && (!((String)localObject2).equals("")) && (new JSONObject((String)localObject2).getJSONArray("msgs").length() == 0)) {
              g.yxI.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), localObject1, Integer.valueOf(paramInt3), Integer.valueOf(i), paramq, paramArrayOfByte, Integer.valueOf(2), Integer.valueOf(paramString.Hdq.Gpf) });
            }
            AppMethodBeat.o(28282);
            return;
          }
          g.yxI.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), localObject1, Integer.valueOf(paramInt3), Integer.valueOf(i), paramq, paramArrayOfByte, Integer.valueOf(2), Integer.valueOf(paramString.Hdq.Gpf) });
          AppMethodBeat.o(28282);
          return;
        }
      }
      catch (JSONException paramString)
      {
        ae.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
        AppMethodBeat.o(28282);
        return;
      }
      g.yxI.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), "", Integer.valueOf(0), Integer.valueOf(0), paramq, paramArrayOfByte, Integer.valueOf(2), Integer.valueOf(paramString.Hdq.Gpf) });
      AppMethodBeat.o(28282);
      return;
    }
    ae.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end not ok");
    paramString = ((bps)this.hZD.hQD.hQJ).hFS;
    try
    {
      paramString = new JSONObject(paramString);
      paramArrayOfByte = paramString.getJSONArray("Beacons");
      paramInt1 = paramArrayOfByte.length();
      paramq = paramString.getJSONObject("LBS");
      paramString = paramq.getString("Latitude");
      paramq = paramq.getString("Longitude");
      if (paramInt1 > 0)
      {
        localObject1 = paramArrayOfByte.getJSONObject(0);
        paramArrayOfByte = ((JSONObject)localObject1).getString("UUID");
        localObject1 = ((JSONObject)localObject1).getJSONObject("Location");
        paramInt2 = ((JSONObject)localObject1).getInt("Major");
        i = ((JSONObject)localObject1).getInt("Minor");
        g.yxI.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), paramArrayOfByte, Integer.valueOf(paramInt2), Integer.valueOf(i), paramString, paramq, Integer.valueOf(1), Integer.valueOf(paramInt3) });
        AppMethodBeat.o(28282);
        return;
      }
    }
    catch (JSONException paramString)
    {
      ae.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
      AppMethodBeat.o(28282);
      return;
    }
    g.yxI.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), "", Integer.valueOf(0), Integer.valueOf(0), paramString, paramq, Integer.valueOf(1), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(28282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.d
 * JD-Core Version:    0.7.0.1
 */