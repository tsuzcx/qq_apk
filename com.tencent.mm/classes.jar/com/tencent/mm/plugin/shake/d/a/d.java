package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.avt;
import com.tencent.mm.protocal.protobuf.avu;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends m
  implements k
{
  int action;
  private f callback;
  final b fBd;
  private long qOS;
  
  public d(Collection<h.a> paramCollection, float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(24610);
    this.action = 1;
    this.qOS = 0L;
    this.action = 1;
    Object localObject1 = new b.a();
    ((b.a)localObject1).fsX = new avt();
    ((b.a)localObject1).fsY = new avu();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/ibeaconboardcast";
    ((b.a)localObject1).funcId = 658;
    ((b.a)localObject1).reqCmdId = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.fBd = ((b.a)localObject1).ado();
    Object localObject2 = bp.aba();
    localObject1 = bo.nullAsNil(((bp)localObject2).fnC);
    localObject2 = bo.nullAsNil(((bp)localObject2).fnB);
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    avt localavt = (avt)this.fBd.fsV.fta;
    localavt.xli = bo.nullAsNil(null);
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
        localStringBuilder.append("{\"UUID\":\"" + locala.eAx + "\",\"Location\":{\"Major\":" + locala.major + ",\"Minor\":" + locala.minor + "},\"Distance\":" + locala.fOc + ",\"Extra\":\"\",\"MacAddress\":\"" + locala.qPc + "\",\"Rssi\":\"" + locala.qPd + "\",\"MeasurePower\":\"" + locala.qPe + "\"}");
        if (i < j - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
    }
    int j = 1;
    boolean bool = ah.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
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
    localStringBuilder.append("],\"Action\":1,\"LBS\":{\"Latitude\":" + paramFloat1 + ",\"Longitude\":" + paramFloat2 + ",\"Province\":\"" + (String)localObject1 + "\",\"City\":\"" + (String)localObject2 + "\"},\"MachineID\":\"" + com.tencent.mm.compatible.e.q.LK() + "\",\"ZBBeaconState\":\"" + i + "\"}");
    localavt.ntu = localStringBuilder.toString();
    if (paramCollection != null) {}
    for (i = paramCollection.size();; i = 0)
    {
      ab.i("MicroMsg.NetSceneShakeIbeacon", "[oneliang]beaconCollection.size:%d,json:%s", new Object[] { Integer.valueOf(i), localavt.ntu });
      o.a(2008, paramFloat2, paramFloat1, paramInt);
      AppMethodBeat.o(24610);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(24611);
    this.qOS = System.currentTimeMillis();
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(24611);
    return i;
  }
  
  public final int getType()
  {
    return 658;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24612);
    ab.i("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.qOS = (System.currentTimeMillis() - this.qOS);
    h.qsU.e(11497, new Object[] { String.valueOf((int)(this.qOS / 1000L + 0.5D)), Integer.valueOf(1), Integer.valueOf((int)this.qOS) });
    Object localObject1;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ab.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end ok");
      paramString = (avu)this.fBd.fsW.fta;
      try
      {
        paramq = new JSONObject(((avt)this.fBd.fsV.fta).ntu);
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
          if (paramString.xlj.wKy == 0)
          {
            localObject2 = paramString.xlj.nqz;
            if ((paramInt2 == 1) && (localObject2 != null) && (!((String)localObject2).equals("")) && (new JSONObject((String)localObject2).getJSONArray("msgs").length() == 0)) {
              h.qsU.e(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), localObject1, Integer.valueOf(paramInt3), Integer.valueOf(i), paramq, paramArrayOfByte, Integer.valueOf(2), Integer.valueOf(paramString.xlj.wKy) });
            }
            AppMethodBeat.o(24612);
            return;
          }
          h.qsU.e(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), localObject1, Integer.valueOf(paramInt3), Integer.valueOf(i), paramq, paramArrayOfByte, Integer.valueOf(2), Integer.valueOf(paramString.xlj.wKy) });
          AppMethodBeat.o(24612);
          return;
        }
      }
      catch (JSONException paramString)
      {
        ab.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
        AppMethodBeat.o(24612);
        return;
      }
      h.qsU.e(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), "", Integer.valueOf(0), Integer.valueOf(0), paramq, paramArrayOfByte, Integer.valueOf(2), Integer.valueOf(paramString.xlj.wKy) });
      AppMethodBeat.o(24612);
      return;
    }
    ab.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end not ok");
    paramString = ((avt)this.fBd.fsV.fta).ntu;
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
        h.qsU.e(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), paramArrayOfByte, Integer.valueOf(paramInt2), Integer.valueOf(i), paramString, paramq, Integer.valueOf(1), Integer.valueOf(paramInt3) });
        AppMethodBeat.o(24612);
        return;
      }
    }
    catch (JSONException paramString)
    {
      ab.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
      AppMethodBeat.o(24612);
      return;
    }
    h.qsU.e(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), "", Integer.valueOf(0), Integer.valueOf(0), paramString, paramq, Integer.valueOf(1), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(24612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.d
 * JD-Core Version:    0.7.0.1
 */