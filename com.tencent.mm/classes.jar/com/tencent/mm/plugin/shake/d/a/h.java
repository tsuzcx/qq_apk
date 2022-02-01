package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.protobuf.bpb;
import com.tencent.mm.protocal.protobuf.bpg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  public static int yNQ = 3;
  private float fFf;
  private float fFg;
  private b.a fFl;
  private com.tencent.mm.modelgeo.d hQo;
  private int yLF;
  private d yNL;
  public Collection<h.a> yNM;
  private int yNN;
  private int yNO;
  private int yNP;
  
  public h(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28293);
    this.yNM = null;
    this.fFf = -85.0F;
    this.fFg = -1000.0F;
    this.yLF = -1000;
    this.yNN = 10001;
    this.yNO = 10002;
    this.yNP = 10003;
    this.fFl = new b.a()
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
    if ((paramd != null) && (paramd.field_sex == yNQ))
    {
      ba.aBQ();
      c.ajl().set(al.a.ItG, Boolean.TRUE);
      long l = bt.aQJ();
      ba.aBQ();
      c.ajl().set(al.a.ItH, Long.valueOf(l));
    }
    try
    {
      paramd = new String(paramd.field_lvbuffer, "utf-8");
      if (paramd != null)
      {
        paramd = paramd.split(",");
        if (paramd.length == 4)
        {
          ba.aBQ();
          c.ajl().set(al.a.Itz, Long.valueOf(paramd[0]));
        }
      }
      AppMethodBeat.o(28302);
      return;
    }
    catch (UnsupportedEncodingException paramd)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.ShakeIbeaconService", paramd, "%s", new Object[] { "Unsupported" });
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
          locala.major = bt.getInt(str, 0);
          locala.minor = bt.getInt((String)localObject, 0);
        }
      }
      AppMethodBeat.o(28303);
      return;
    }
    catch (UnsupportedEncodingException paramd)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.ShakeIbeaconService", paramd, "%s", new Object[] { "Unsupported" });
        paramd = null;
      }
    }
  }
  
  private void dOr()
  {
    AppMethodBeat.i(28299);
    this.hQo = com.tencent.mm.modelgeo.d.aHQ();
    this.hQo.a(this.fFl, true);
    AppMethodBeat.o(28299);
  }
  
  public final void dOs()
  {
    AppMethodBeat.i(28300);
    super.dOs();
    ba.aiU().b(658, this);
    AppMethodBeat.o(28300);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28294);
    ba.aiU().a(658, this);
    dOr();
    AppMethodBeat.o(28294);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(28301);
    ad.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService]onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (d)paramn;
      if ((658 == paramn.getType()) && (paramString.action == 1))
      {
        paramString = (bpb)paramString.hWL.hNL.hNQ;
        if (paramString.GJP == null)
        {
          this.yLV.d(null, 3L);
          AppMethodBeat.o(28301);
          return;
        }
        if (paramString.GJP.FWG == 0)
        {
          ad.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]onSceneEnd :message:%s,tips:%s,result:%s", new Object[] { paramString.GJP.ufM, paramString.GJP.wMs, Integer.valueOf(paramString.GJP.FWG) });
          paramString = paramString.GJP.ufM;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        JSONArray localJSONArray = paramString.getJSONArray("msgs");
        paramn = paramString.getJSONObject("guide_switch");
        paramInt2 = paramn.getInt("channel_open_method");
        long l = paramn.getLong("channel_open_time");
        paramInt1 = paramn.getInt("shake_tab_display");
        int i = paramString.getJSONObject("gated_launch_option").getInt("tab_state");
        ba.aBQ();
        c.ajl().set(al.a.ItA, Integer.valueOf(paramInt2));
        ba.aBQ();
        c.ajl().set(al.a.ItB, Long.valueOf(l));
        ba.aBQ();
        c.ajl().set(al.a.ItC, Integer.valueOf(paramInt1));
        ba.aBQ();
        c.ajl().set(al.a.ItL, Integer.valueOf(i));
        ad.i("MicroMsg.ShakeIbeaconService", "[shakezb]channel_open_method is " + paramInt2 + " ,channel_open_time is " + l + ", shake_tab_display is " + paramInt1);
        i = localJSONArray.length();
        paramString = null;
        e locale = m.dOO();
        locale.dOE();
        if (i > 0)
        {
          paramn = new ArrayList();
          paramInt1 = 0;
          paramString = paramn;
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
              paramString.field_sex = yNQ;
            }
            paramString.field_lvbuffer = (String.valueOf(str5) + "," + String.valueOf(str6) + "," + String.valueOf(str7) + "," + String.valueOf(localObject)).getBytes("utf-8");
            paramString.field_insertBatch = 2;
            paramString.field_reserved3 = (str8 + "," + str9 + "," + k);
            paramn.add(paramString);
            locale.a(paramString, true);
            if ((paramString.field_sex != yNQ) || (paramInt2 != 1)) {
              break label953;
            }
            a(paramString);
            break label953;
          }
        }
        this.yLV.d(paramString, 1L);
        AppMethodBeat.o(28301);
        return;
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb] parse error.%s", new Object[] { bt.nullAsNil(paramString.getMessage()) });
        this.yLV.d(null, 1L);
        AppMethodBeat.o(28301);
        return;
      }
      if (paramString.GJP.FWG == this.yNN)
      {
        this.yLV.d(null, 6L);
        AppMethodBeat.o(28301);
        return;
      }
      if (paramString.GJP.FWG == this.yNO)
      {
        this.yLV.d(null, 7L);
        AppMethodBeat.o(28301);
        return;
      }
      if (paramString.GJP.FWG == this.yNP)
      {
        this.yLV.d(null, 8L);
        AppMethodBeat.o(28301);
        return;
      }
      this.yLV.d(null, 1L);
      AppMethodBeat.o(28301);
      return;
      this.yLV.d(null, 3L);
      AppMethodBeat.o(28301);
      return;
      label953:
      paramInt1 += 1;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28297);
    if (this.hQo != null) {
      this.hQo.c(this.fFl);
    }
    AppMethodBeat.o(28297);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28295);
    if (this.yNL != null) {
      ba.aiU().a(this.yNL);
    }
    AppMethodBeat.o(28295);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(28298);
    if (this.hQo != null) {
      this.hQo.a(this.fFl, true);
    }
    AppMethodBeat.o(28298);
  }
  
  public final void start()
  {
    AppMethodBeat.i(28296);
    ad.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:start");
    init();
    reset();
    if (this.hQo == null) {
      dOr();
    }
    this.hQo.b(this.fFl, true);
    Object localObject;
    if ((!Build.VERSION.RELEASE.equals("6.0")) && (!Build.VERSION.RELEASE.equals("6.0.0")) && (Build.VERSION.SDK_INT >= 23))
    {
      localObject = (LocationManager)aj.getContext().getSystemService("location");
      if (localObject == null) {
        break label301;
      }
    }
    label301:
    for (boolean bool = ((LocationManager)localObject).isProviderEnabled("gps");; bool = true)
    {
      if (!bool)
      {
        new ap().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28290);
            h.a(h.this).d(null, 8L);
            AppMethodBeat.o(28290);
          }
        }, 1000L);
        AppMethodBeat.o(28296);
        return;
      }
      localObject = BluetoothAdapter.getDefaultAdapter();
      if ((localObject != null) && (((BluetoothAdapter)localObject).getState() != 12))
      {
        new ap().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28291);
            h.b(h.this).d(null, 9L);
            AppMethodBeat.o(28291);
          }
        }, 1000L);
        AppMethodBeat.o(28296);
        return;
      }
      if (localObject == null)
      {
        new ap().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28292);
            h.c(h.this).d(null, 10L);
            AppMethodBeat.o(28292);
          }
        }, 1000L);
        AppMethodBeat.o(28296);
        return;
      }
      if (this.yNM != null) {}
      for (int i = this.yNM.size();; i = 0)
      {
        ad.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:beaconCollection.size:%d", new Object[] { Integer.valueOf(i) });
        this.yNL = new d(this.yNM, this.fFf, this.fFg, this.yLF);
        ba.aiU().a(this.yNL, 0);
        AppMethodBeat.o(28296);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.h
 * JD-Core Version:    0.7.0.1
 */