package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.bn;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.apu;
import com.tencent.mm.protocal.c.apv;
import com.tencent.mm.protocal.c.aqa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends m
  implements k
{
  int action = 1;
  private f dmL;
  final b esv;
  private long oaJ = 0L;
  
  public d(Collection<h.a> paramCollection, float paramFloat1, float paramFloat2, int paramInt)
  {
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecH = new apu();
    ((b.a)localObject1).ecI = new apv();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/ibeaconboardcast";
    ((b.a)localObject1).ecG = 658;
    ((b.a)localObject1).ecJ = 0;
    ((b.a)localObject1).ecK = 0;
    this.esv = ((b.a)localObject1).Kt();
    Object localObject2 = bn.Id();
    localObject1 = bk.pm(((bn)localObject2).dXv);
    localObject2 = bk.pm(((bn)localObject2).dXu);
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    apu localapu = (apu)this.esv.ecE.ecN;
    localapu.tlP = bk.pm(null);
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
        localStringBuilder.append("{\"UUID\":\"" + locala.dCX + "\",\"Location\":{\"Major\":" + locala.major + ",\"Minor\":" + locala.minor + "},\"Distance\":" + locala.eyp + ",\"Extra\":\"\",\"MacAddress\":\"" + locala.oaT + "\",\"Rssi\":\"" + locala.oaU + "\",\"MeasurePower\":\"" + locala.oaV + "\"}");
        if (i < j - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
    }
    int j = 1;
    boolean bool = ae.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
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
    localStringBuilder.append("],\"Action\":1,\"LBS\":{\"Latitude\":" + paramFloat1 + ",\"Longitude\":" + paramFloat2 + ",\"Province\":\"" + (String)localObject1 + "\",\"City\":\"" + (String)localObject2 + "\"},\"MachineID\":\"" + com.tencent.mm.compatible.e.q.zg() + "\",\"ZBBeaconState\":\"" + i + "\"}");
    localapu.kVs = localStringBuilder.toString();
    if (paramCollection != null) {}
    for (i = paramCollection.size();; i = 0)
    {
      y.i("MicroMsg.NetSceneShakeIbeacon", "[oneliang]beaconCollection.size:%d,json:%s", new Object[] { Integer.valueOf(i), localapu.kVs });
      o.a(2008, paramFloat2, paramFloat1, paramInt);
      return;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.oaJ = System.currentTimeMillis();
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.oaJ = (System.currentTimeMillis() - this.oaJ);
    h.nFQ.f(11497, new Object[] { String.valueOf((int)(this.oaJ / 1000L + 0.5D)), Integer.valueOf(1), Integer.valueOf((int)this.oaJ) });
    Object localObject1;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      y.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end ok");
      paramString = (apv)this.esv.ecF.ecN;
      try
      {
        paramq = new JSONObject(((apu)this.esv.ecE.ecN).kVs);
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
          if (paramString.tlQ.sML == 0)
          {
            localObject2 = paramString.tlQ.kSz;
            if ((paramInt2 != 1) || (localObject2 == null) || (((String)localObject2).equals("")) || (new JSONObject((String)localObject2).getJSONArray("msgs").length() != 0)) {
              return;
            }
            h.nFQ.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), localObject1, Integer.valueOf(paramInt3), Integer.valueOf(i), paramq, paramArrayOfByte, Integer.valueOf(2), Integer.valueOf(paramString.tlQ.sML) });
            return;
          }
          h.nFQ.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), localObject1, Integer.valueOf(paramInt3), Integer.valueOf(i), paramq, paramArrayOfByte, Integer.valueOf(2), Integer.valueOf(paramString.tlQ.sML) });
          return;
        }
      }
      catch (JSONException paramString)
      {
        y.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
        return;
      }
      h.nFQ.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), "", Integer.valueOf(0), Integer.valueOf(0), paramq, paramArrayOfByte, Integer.valueOf(2), Integer.valueOf(paramString.tlQ.sML) });
    }
    else
    {
      y.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end not ok");
      paramString = ((apu)this.esv.ecE.ecN).kVs;
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
          h.nFQ.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), paramArrayOfByte, Integer.valueOf(paramInt2), Integer.valueOf(i), paramString, paramq, Integer.valueOf(1), Integer.valueOf(paramInt3) });
          return;
        }
      }
      catch (JSONException paramString)
      {
        y.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
        return;
      }
      h.nFQ.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), "", Integer.valueOf(0), Integer.valueOf(0), paramString, paramq, Integer.valueOf(1), Integer.valueOf(paramInt3) });
    }
  }
  
  public final int getType()
  {
    return 658;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.d
 * JD-Core Version:    0.7.0.1
 */