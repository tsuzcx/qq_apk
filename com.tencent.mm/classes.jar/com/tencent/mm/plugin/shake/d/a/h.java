package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.protocal.protobuf.avu;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h
  extends l.b
  implements f
{
  public static int qPa = 3;
  private b.a dZA;
  private float dZu;
  private float dZv;
  private com.tencent.mm.modelgeo.d fwu;
  private int qAl;
  private d qOV;
  public Collection<h.a> qOW;
  private int qOX;
  private int qOY;
  private int qOZ;
  
  public h(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(24623);
    this.qOW = null;
    this.dZu = -85.0F;
    this.dZv = -1000.0F;
    this.qAl = -1000;
    this.qOX = 10001;
    this.qOY = 10002;
    this.qOZ = 10003;
    this.dZA = new h.1(this);
    AppMethodBeat.o(24623);
  }
  
  public static void a(com.tencent.mm.plugin.shake.b.d paramd)
  {
    AppMethodBeat.i(24632);
    if ((paramd != null) && (paramd.field_sex == qPa))
    {
      aw.aaz();
      c.Ru().set(ac.a.yBd, Boolean.TRUE);
      long l = bo.aox();
      aw.aaz();
      c.Ru().set(ac.a.yBe, Long.valueOf(l));
    }
    try
    {
      paramd = new String(paramd.field_lvbuffer, "utf-8");
      if (paramd != null)
      {
        paramd = paramd.split(",");
        if (paramd.length == 4)
        {
          aw.aaz();
          c.Ru().set(ac.a.yAW, Long.valueOf(paramd[0]));
        }
      }
      AppMethodBeat.o(24632);
      return;
    }
    catch (UnsupportedEncodingException paramd)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ShakeIbeaconService", paramd, "%s", new Object[] { "Unsupported" });
        paramd = null;
      }
    }
  }
  
  public static void b(com.tencent.mm.plugin.shake.b.d paramd)
  {
    AppMethodBeat.i(24633);
    if (paramd != null) {}
    try
    {
      paramd = new String(paramd.field_lvbuffer, "utf-8");
      if (paramd != null)
      {
        Object localObject = paramd.split(",");
        if (localObject.length == 4)
        {
          paramd = localObject[1];
          String str = localObject[2];
          localObject = localObject[3];
          h.a locala = new h.a();
          locala.eAx = paramd;
          locala.major = bo.getInt(str, 0);
          locala.minor = bo.getInt((String)localObject, 0);
        }
      }
      AppMethodBeat.o(24633);
      return;
    }
    catch (UnsupportedEncodingException paramd)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ShakeIbeaconService", paramd, "%s", new Object[] { "Unsupported" });
        paramd = null;
      }
    }
  }
  
  private void ckQ()
  {
    AppMethodBeat.i(24629);
    this.fwu = com.tencent.mm.modelgeo.d.agQ();
    this.fwu.a(this.dZA, true);
    AppMethodBeat.o(24629);
  }
  
  public final void ckR()
  {
    AppMethodBeat.i(24630);
    super.ckR();
    aw.Rc().b(658, this);
    AppMethodBeat.o(24630);
  }
  
  public final void init()
  {
    AppMethodBeat.i(24624);
    aw.Rc().a(658, this);
    ckQ();
    AppMethodBeat.o(24624);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(24631);
    ab.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService]onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (d)paramm;
      if ((658 == paramm.getType()) && (paramString.action == 1))
      {
        paramString = (avu)paramString.fBd.fsW.fta;
        if (paramString.xlj.wKy == 0)
        {
          ab.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]onSceneEnd :message:%s,tips:%s,result:%s", new Object[] { paramString.xlj.nqz, paramString.xlj.puI, Integer.valueOf(paramString.xlj.wKy) });
          paramString = paramString.xlj.nqz;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        JSONArray localJSONArray = paramString.getJSONArray("msgs");
        paramm = paramString.getJSONObject("guide_switch");
        paramInt2 = paramm.getInt("channel_open_method");
        long l = paramm.getLong("channel_open_time");
        paramInt1 = paramm.getInt("shake_tab_display");
        int i = paramString.getJSONObject("gated_launch_option").getInt("tab_state");
        aw.aaz();
        c.Ru().set(ac.a.yAX, Integer.valueOf(paramInt2));
        aw.aaz();
        c.Ru().set(ac.a.yAY, Long.valueOf(l));
        aw.aaz();
        c.Ru().set(ac.a.yAZ, Integer.valueOf(paramInt1));
        aw.aaz();
        c.Ru().set(ac.a.yBi, Integer.valueOf(i));
        ab.i("MicroMsg.ShakeIbeaconService", "[shakezb]channel_open_method is " + paramInt2 + " ,channel_open_time is " + l + ", shake_tab_display is " + paramInt1);
        i = localJSONArray.length();
        paramString = null;
        e locale = com.tencent.mm.plugin.shake.b.m.cln();
        locale.cld();
        if (i > 0)
        {
          paramm = new ArrayList();
          paramInt1 = 0;
          paramString = paramm;
          if (paramInt1 < i)
          {
            paramString = new com.tencent.mm.plugin.shake.b.d();
            JSONObject localJSONObject = localJSONArray.getJSONObject(paramInt1);
            String str1 = localJSONObject.getString("url");
            String str2 = localJSONObject.getString("content");
            String str3 = localJSONObject.getString("title");
            String str4 = localJSONObject.getString("picurl");
            String str5 = localJSONObject.getString("shopid");
            Object localObject = localJSONObject.getJSONObject("beacon");
            String str6 = ((JSONObject)localObject).getString("uuid");
            String str7 = ((JSONObject)localObject).getString("major");
            localObject = ((JSONObject)localObject).getString("minor");
            int j = localJSONObject.getInt("guide_state");
            String str8 = localJSONObject.getString("wxa_username");
            String str9 = localJSONObject.getString("wxa_path");
            int k = localJSONObject.getInt("wxa_version_type");
            paramString.field_type = 11;
            paramString.field_username = str3;
            paramString.field_nickname = str3;
            paramString.field_signature = str2;
            paramString.field_province = str4;
            paramString.field_city = str1;
            if (j == 1) {
              paramString.field_sex = qPa;
            }
            paramString.field_lvbuffer = (String.valueOf(str5) + "," + String.valueOf(str6) + "," + String.valueOf(str7) + "," + String.valueOf(localObject)).getBytes("utf-8");
            paramString.field_insertBatch = 2;
            paramString.field_reserved3 = (str8 + "," + str9 + "," + k);
            paramm.add(paramString);
            locale.a(paramString, true);
            if ((paramString.field_sex != qPa) || (paramInt2 != 1)) {
              break label926;
            }
            a(paramString);
            break label926;
          }
        }
        this.qNe.b(paramString, 1L);
        AppMethodBeat.o(24631);
        return;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb] parse error.%s", new Object[] { bo.nullAsNil(paramString.getMessage()) });
        this.qNe.b(null, 1L);
        AppMethodBeat.o(24631);
        return;
      }
      if (paramString.xlj.wKy == this.qOX)
      {
        this.qNe.b(null, 6L);
        AppMethodBeat.o(24631);
        return;
      }
      if (paramString.xlj.wKy == this.qOY)
      {
        this.qNe.b(null, 7L);
        AppMethodBeat.o(24631);
        return;
      }
      if (paramString.xlj.wKy == this.qOZ)
      {
        this.qNe.b(null, 8L);
        AppMethodBeat.o(24631);
        return;
      }
      this.qNe.b(null, 1L);
      AppMethodBeat.o(24631);
      return;
      this.qNe.b(null, 3L);
      AppMethodBeat.o(24631);
      return;
      label926:
      paramInt1 += 1;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(24627);
    if (this.fwu != null) {
      this.fwu.c(this.dZA);
    }
    AppMethodBeat.o(24627);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(24625);
    if (this.qOV != null) {
      aw.Rc().a(this.qOV);
    }
    AppMethodBeat.o(24625);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(24628);
    if (this.fwu != null) {
      this.fwu.a(this.dZA, true);
    }
    AppMethodBeat.o(24628);
  }
  
  public final void start()
  {
    AppMethodBeat.i(24626);
    ab.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:start");
    init();
    reset();
    if (this.fwu == null) {
      ckQ();
    }
    this.fwu.b(this.dZA, true);
    Object localObject;
    if ((!Build.VERSION.RELEASE.equals("6.0")) && (!Build.VERSION.RELEASE.equals("6.0.0")) && (Build.VERSION.SDK_INT >= 23))
    {
      localObject = (LocationManager)ah.getContext().getSystemService("location");
      if (localObject == null) {
        break label301;
      }
    }
    label301:
    for (boolean bool = ((LocationManager)localObject).isProviderEnabled("gps");; bool = true)
    {
      if (!bool)
      {
        new ak().postDelayed(new h.2(this), 1000L);
        AppMethodBeat.o(24626);
        return;
      }
      localObject = BluetoothAdapter.getDefaultAdapter();
      if ((localObject != null) && (((BluetoothAdapter)localObject).getState() != 12))
      {
        new ak().postDelayed(new h.3(this), 1000L);
        AppMethodBeat.o(24626);
        return;
      }
      if (localObject == null)
      {
        new ak().postDelayed(new h.4(this), 1000L);
        AppMethodBeat.o(24626);
        return;
      }
      if (this.qOW != null) {}
      for (int i = this.qOW.size();; i = 0)
      {
        ab.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:beaconCollection.size:%d", new Object[] { Integer.valueOf(i) });
        this.qOV = new d(this.qOW, this.dZu, this.dZv, this.qAl);
        aw.Rc().a(this.qOV, 0);
        AppMethodBeat.o(24626);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.h
 * JD-Core Version:    0.7.0.1
 */