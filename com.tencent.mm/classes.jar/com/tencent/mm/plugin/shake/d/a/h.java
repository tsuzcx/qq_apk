package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.protocal.protobuf.ccq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h
  extends l.b
  implements i
{
  public static int DiS = 3;
  private int DgH;
  private d DiN;
  public Collection<h.a> DiO;
  private int DiP;
  private int DiQ;
  private int DiR;
  private b.a gmA;
  private float gmu;
  private float gmv;
  private com.tencent.mm.modelgeo.d iOv;
  
  public h(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28293);
    this.DiO = null;
    this.gmu = -85.0F;
    this.gmv = -1000.0F;
    this.DgH = -1000;
    this.DiP = 10001;
    this.DiQ = 10002;
    this.DiR = 10003;
    this.gmA = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(28289);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(28289);
          return true;
        }
        h.a(h.this, paramAnonymousFloat2);
        h.b(h.this, paramAnonymousFloat1);
        h.a(h.this, (int)paramAnonymousDouble2);
        AppMethodBeat.o(28289);
        return false;
      }
    };
    AppMethodBeat.o(28293);
  }
  
  public static void a(com.tencent.mm.plugin.shake.b.d paramd)
  {
    AppMethodBeat.i(28302);
    if ((paramd != null) && (paramd.field_sex == DiS))
    {
      bg.aVF();
      c.azQ().set(ar.a.NWf, Boolean.TRUE);
      long l = Util.nowSecond();
      bg.aVF();
      c.azQ().set(ar.a.NWg, Long.valueOf(l));
    }
    try
    {
      paramd = new String(paramd.field_lvbuffer, "utf-8");
      if (paramd != null)
      {
        paramd = paramd.split(",");
        if (paramd.length == 4)
        {
          bg.aVF();
          c.azQ().set(ar.a.NVY, Long.valueOf(paramd[0]));
        }
      }
      AppMethodBeat.o(28302);
      return;
    }
    catch (UnsupportedEncodingException paramd)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ShakeIbeaconService", paramd, "%s", new Object[] { "Unsupported" });
        paramd = null;
      }
    }
  }
  
  public static void b(com.tencent.mm.plugin.shake.b.d paramd)
  {
    AppMethodBeat.i(28303);
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
          locala.uuid = paramd;
          locala.major = Util.getInt(str, 0);
          locala.minor = Util.getInt((String)localObject, 0);
        }
      }
      AppMethodBeat.o(28303);
      return;
    }
    catch (UnsupportedEncodingException paramd)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ShakeIbeaconService", paramd, "%s", new Object[] { "Unsupported" });
        paramd = null;
      }
    }
  }
  
  private void eTP()
  {
    AppMethodBeat.i(28299);
    this.iOv = com.tencent.mm.modelgeo.d.bca();
    this.iOv.a(this.gmA, true);
    AppMethodBeat.o(28299);
  }
  
  public final void eTQ()
  {
    AppMethodBeat.i(28300);
    super.eTQ();
    bg.azz().b(658, this);
    AppMethodBeat.o(28300);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28294);
    bg.azz().a(658, this);
    eTP();
    AppMethodBeat.o(28294);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(28301);
    Log.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService]onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (d)paramq;
      if ((658 == paramq.getType()) && (paramString.action == 1))
      {
        paramString = (ccl)paramString.iUB.iLL.iLR;
        if (paramString.Mit == null)
        {
          this.DgX.f(null, 3L);
          AppMethodBeat.o(28301);
          return;
        }
        if (paramString.Mit.LjQ == 0)
        {
          Log.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]onSceneEnd :message:%s,tips:%s,result:%s", new Object[] { paramString.Mit.xJz, paramString.Mit.AZI, Integer.valueOf(paramString.Mit.LjQ) });
          paramString = paramString.Mit.xJz;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        JSONArray localJSONArray = paramString.getJSONArray("msgs");
        paramq = paramString.getJSONObject("guide_switch");
        paramInt2 = paramq.getInt("channel_open_method");
        long l = paramq.getLong("channel_open_time");
        paramInt1 = paramq.getInt("shake_tab_display");
        int i = paramString.getJSONObject("gated_launch_option").getInt("tab_state");
        bg.aVF();
        c.azQ().set(ar.a.NVZ, Integer.valueOf(paramInt2));
        bg.aVF();
        c.azQ().set(ar.a.NWa, Long.valueOf(l));
        bg.aVF();
        c.azQ().set(ar.a.NWb, Integer.valueOf(paramInt1));
        bg.aVF();
        c.azQ().set(ar.a.NWk, Integer.valueOf(i));
        Log.i("MicroMsg.ShakeIbeaconService", "[shakezb]channel_open_method is " + paramInt2 + " ,channel_open_time is " + l + ", shake_tab_display is " + paramInt1);
        i = localJSONArray.length();
        paramString = null;
        e locale = m.eUm();
        locale.eUc();
        if (i > 0)
        {
          paramq = new ArrayList();
          paramInt1 = 0;
          paramString = paramq;
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
              paramString.field_sex = DiS;
            }
            paramString.field_lvbuffer = (String.valueOf(str5) + "," + String.valueOf(str6) + "," + String.valueOf(str7) + "," + String.valueOf(localObject)).getBytes("utf-8");
            paramString.field_insertBatch = 2;
            paramString.field_reserved3 = (str8 + "," + str9 + "," + k);
            paramq.add(paramString);
            locale.a(paramString, true);
            if ((paramString.field_sex != DiS) || (paramInt2 != 1)) {
              break label953;
            }
            a(paramString);
            break label953;
          }
        }
        this.DgX.f(paramString, 1L);
        AppMethodBeat.o(28301);
        return;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb] parse error.%s", new Object[] { Util.nullAsNil(paramString.getMessage()) });
        this.DgX.f(null, 1L);
        AppMethodBeat.o(28301);
        return;
      }
      if (paramString.Mit.LjQ == this.DiP)
      {
        this.DgX.f(null, 6L);
        AppMethodBeat.o(28301);
        return;
      }
      if (paramString.Mit.LjQ == this.DiQ)
      {
        this.DgX.f(null, 7L);
        AppMethodBeat.o(28301);
        return;
      }
      if (paramString.Mit.LjQ == this.DiR)
      {
        this.DgX.f(null, 8L);
        AppMethodBeat.o(28301);
        return;
      }
      this.DgX.f(null, 1L);
      AppMethodBeat.o(28301);
      return;
      this.DgX.f(null, 3L);
      AppMethodBeat.o(28301);
      return;
      label953:
      paramInt1 += 1;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28297);
    if (this.iOv != null) {
      this.iOv.c(this.gmA);
    }
    AppMethodBeat.o(28297);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28295);
    if (this.DiN != null) {
      bg.azz().a(this.DiN);
    }
    AppMethodBeat.o(28295);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(28298);
    if (this.iOv != null) {
      this.iOv.a(this.gmA, true);
    }
    AppMethodBeat.o(28298);
  }
  
  public final void start()
  {
    AppMethodBeat.i(28296);
    Log.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:start");
    init();
    reset();
    if (this.iOv == null) {
      eTP();
    }
    this.iOv.b(this.gmA, true);
    Object localObject;
    if ((!Build.VERSION.RELEASE.equals("6.0")) && (!Build.VERSION.RELEASE.equals("6.0.0")) && (Build.VERSION.SDK_INT >= 23))
    {
      localObject = (LocationManager)MMApplicationContext.getContext().getSystemService("location");
      if (localObject == null) {
        break label301;
      }
    }
    label301:
    for (boolean bool = ((LocationManager)localObject).isProviderEnabled("gps");; bool = true)
    {
      if (!bool)
      {
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28290);
            h.a(h.this).f(null, 8L);
            AppMethodBeat.o(28290);
          }
        }, 1000L);
        AppMethodBeat.o(28296);
        return;
      }
      localObject = BluetoothAdapter.getDefaultAdapter();
      if ((localObject != null) && (((BluetoothAdapter)localObject).getState() != 12))
      {
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28291);
            h.b(h.this).f(null, 9L);
            AppMethodBeat.o(28291);
          }
        }, 1000L);
        AppMethodBeat.o(28296);
        return;
      }
      if (localObject == null)
      {
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28292);
            h.c(h.this).f(null, 10L);
            AppMethodBeat.o(28292);
          }
        }, 1000L);
        AppMethodBeat.o(28296);
        return;
      }
      if (this.DiO != null) {}
      for (int i = this.DiO.size();; i = 0)
      {
        Log.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:beaconCollection.size:%d", new Object[] { Integer.valueOf(i) });
        this.DiN = new d(this.DiO, this.gmu, this.gmv, this.DgH);
        bg.azz().a(this.DiN, 0);
        AppMethodBeat.o(28296);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.h
 * JD-Core Version:    0.7.0.1
 */