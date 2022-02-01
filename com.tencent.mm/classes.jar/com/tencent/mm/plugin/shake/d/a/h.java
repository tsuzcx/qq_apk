package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.bkw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h
  extends l.b
  implements g
{
  public static int xzg = 3;
  private float fmX;
  private float fmY;
  private b.a fnd;
  private com.tencent.mm.modelgeo.d hxT;
  private int xwU;
  private d xzb;
  public Collection<a> xzc;
  private int xzd;
  private int xze;
  private int xzf;
  
  public h(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28293);
    this.xzc = null;
    this.fmX = -85.0F;
    this.fmY = -1000.0F;
    this.xwU = -1000;
    this.xzd = 10001;
    this.xze = 10002;
    this.xzf = 10003;
    this.fnd = new b.a()
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
    if ((paramd != null) && (paramd.field_sex == xzg))
    {
      az.ayM();
      c.agA().set(ah.a.GHo, Boolean.TRUE);
      long l = bs.aNx();
      az.ayM();
      c.agA().set(ah.a.GHp, Long.valueOf(l));
    }
    try
    {
      paramd = new String(paramd.field_lvbuffer, "utf-8");
      if (paramd != null)
      {
        paramd = paramd.split(",");
        if (paramd.length == 4)
        {
          az.ayM();
          c.agA().set(ah.a.GHh, Long.valueOf(paramd[0]));
        }
      }
      AppMethodBeat.o(28302);
      return;
    }
    catch (UnsupportedEncodingException paramd)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.ShakeIbeaconService", paramd, "%s", new Object[] { "Unsupported" });
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
          a locala = new a();
          locala.uuid = paramd;
          locala.major = bs.getInt(str, 0);
          locala.minor = bs.getInt((String)localObject, 0);
        }
      }
      AppMethodBeat.o(28303);
      return;
    }
    catch (UnsupportedEncodingException paramd)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.ShakeIbeaconService", paramd, "%s", new Object[] { "Unsupported" });
        paramd = null;
      }
    }
  }
  
  private void dCO()
  {
    AppMethodBeat.i(28299);
    this.hxT = com.tencent.mm.modelgeo.d.aEL();
    this.hxT.a(this.fnd, true);
    AppMethodBeat.o(28299);
  }
  
  public final void dCP()
  {
    AppMethodBeat.i(28300);
    super.dCP();
    az.agi().b(658, this);
    AppMethodBeat.o(28300);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28294);
    az.agi().a(658, this);
    dCO();
    AppMethodBeat.o(28294);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(28301);
    ac.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService]onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (d)paramn;
      if ((658 == paramn.getType()) && (paramString.action == 1))
      {
        paramString = (bkr)paramString.hEg.hvs.hvw;
        if (paramString.Faq == null)
        {
          this.xxk.d(null, 3L);
          AppMethodBeat.o(28301);
          return;
        }
        if (paramString.Faq.Epu == 0)
        {
          ac.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]onSceneEnd :message:%s,tips:%s,result:%s", new Object[] { paramString.Faq.thV, paramString.Faq.vFm, Integer.valueOf(paramString.Faq.Epu) });
          paramString = paramString.Faq.thV;
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
        az.ayM();
        c.agA().set(ah.a.GHi, Integer.valueOf(paramInt2));
        az.ayM();
        c.agA().set(ah.a.GHj, Long.valueOf(l));
        az.ayM();
        c.agA().set(ah.a.GHk, Integer.valueOf(paramInt1));
        az.ayM();
        c.agA().set(ah.a.GHt, Integer.valueOf(i));
        ac.i("MicroMsg.ShakeIbeaconService", "[shakezb]channel_open_method is " + paramInt2 + " ,channel_open_time is " + l + ", shake_tab_display is " + paramInt1);
        i = localJSONArray.length();
        paramString = null;
        e locale = m.dDl();
        locale.dDb();
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
              paramString.field_sex = xzg;
            }
            paramString.field_lvbuffer = (String.valueOf(str5) + "," + String.valueOf(str6) + "," + String.valueOf(str7) + "," + String.valueOf(localObject)).getBytes("utf-8");
            paramString.field_insertBatch = 2;
            paramString.field_reserved3 = (str8 + "," + str9 + "," + k);
            paramn.add(paramString);
            locale.a(paramString, true);
            if ((paramString.field_sex != xzg) || (paramInt2 != 1)) {
              break label953;
            }
            a(paramString);
            break label953;
          }
        }
        this.xxk.d(paramString, 1L);
        AppMethodBeat.o(28301);
        return;
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb] parse error.%s", new Object[] { bs.nullAsNil(paramString.getMessage()) });
        this.xxk.d(null, 1L);
        AppMethodBeat.o(28301);
        return;
      }
      if (paramString.Faq.Epu == this.xzd)
      {
        this.xxk.d(null, 6L);
        AppMethodBeat.o(28301);
        return;
      }
      if (paramString.Faq.Epu == this.xze)
      {
        this.xxk.d(null, 7L);
        AppMethodBeat.o(28301);
        return;
      }
      if (paramString.Faq.Epu == this.xzf)
      {
        this.xxk.d(null, 8L);
        AppMethodBeat.o(28301);
        return;
      }
      this.xxk.d(null, 1L);
      AppMethodBeat.o(28301);
      return;
      this.xxk.d(null, 3L);
      AppMethodBeat.o(28301);
      return;
      label953:
      paramInt1 += 1;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28297);
    if (this.hxT != null) {
      this.hxT.c(this.fnd);
    }
    AppMethodBeat.o(28297);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28295);
    if (this.xzb != null) {
      az.agi().a(this.xzb);
    }
    AppMethodBeat.o(28295);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(28298);
    if (this.hxT != null) {
      this.hxT.a(this.fnd, true);
    }
    AppMethodBeat.o(28298);
  }
  
  public final void start()
  {
    AppMethodBeat.i(28296);
    ac.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:start");
    init();
    reset();
    if (this.hxT == null) {
      dCO();
    }
    this.hxT.b(this.fnd, true);
    Object localObject;
    if ((!Build.VERSION.RELEASE.equals("6.0")) && (!Build.VERSION.RELEASE.equals("6.0.0")) && (Build.VERSION.SDK_INT >= 23))
    {
      localObject = (LocationManager)ai.getContext().getSystemService("location");
      if (localObject == null) {
        break label301;
      }
    }
    label301:
    for (boolean bool = ((LocationManager)localObject).isProviderEnabled("gps");; bool = true)
    {
      if (!bool)
      {
        new ao().postDelayed(new Runnable()
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
        new ao().postDelayed(new Runnable()
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
        new ao().postDelayed(new Runnable()
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
      if (this.xzc != null) {}
      for (int i = this.xzc.size();; i = 0)
      {
        ac.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:beaconCollection.size:%d", new Object[] { Integer.valueOf(i) });
        this.xzb = new d(this.xzc, this.fmX, this.fmY, this.xwU);
        az.agi().a(this.xzb, 0);
        AppMethodBeat.o(28296);
        return;
      }
    }
  }
  
  public static final class a
  {
    public double hRA = 0.0D;
    public int major = 0;
    public int minor = 0;
    public String uuid = null;
    public String xzi = "";
    public double xzj = 0.0D;
    public int xzk = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.h
 * JD-Core Version:    0.7.0.1
 */