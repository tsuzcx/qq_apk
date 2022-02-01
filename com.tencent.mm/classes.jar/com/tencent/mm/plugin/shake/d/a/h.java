package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.protobuf.bgz;
import com.tencent.mm.protocal.protobuf.bhe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
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
  public static int wnP = 3;
  private float fjD;
  private float fjE;
  private b.a fjJ;
  private com.tencent.mm.modelgeo.d gXu;
  private int wlE;
  private d wnK;
  public Collection<a> wnL;
  private int wnM;
  private int wnN;
  private int wnO;
  
  public h(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28293);
    this.wnL = null;
    this.fjD = -85.0F;
    this.fjE = -1000.0F;
    this.wlE = -1000;
    this.wnM = 10001;
    this.wnN = 10002;
    this.wnO = 10003;
    this.fjJ = new b.a()
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
    if ((paramd != null) && (paramd.field_sex == wnP))
    {
      az.arV();
      c.afk().set(ae.a.Fjz, Boolean.TRUE);
      long l = bt.aGK();
      az.arV();
      c.afk().set(ae.a.FjA, Long.valueOf(l));
    }
    try
    {
      paramd = new String(paramd.field_lvbuffer, "utf-8");
      if (paramd != null)
      {
        paramd = paramd.split(",");
        if (paramd.length == 4)
        {
          az.arV();
          c.afk().set(ae.a.Fjs, Long.valueOf(paramd[0]));
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
          a locala = new a();
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
  
  private void doE()
  {
    AppMethodBeat.i(28299);
    this.gXu = com.tencent.mm.modelgeo.d.axT();
    this.gXu.a(this.fjJ, true);
    AppMethodBeat.o(28299);
  }
  
  public final void doF()
  {
    AppMethodBeat.i(28300);
    super.doF();
    az.aeS().b(658, this);
    AppMethodBeat.o(28300);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28294);
    az.aeS().a(658, this);
    doE();
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
        paramString = (bgz)paramString.hdD.gUT.gUX;
        if (paramString.DEW.CWL == 0)
        {
          ad.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]onSceneEnd :message:%s,tips:%s,result:%s", new Object[] { paramString.DEW.sac, paramString.DEW.uwt, Integer.valueOf(paramString.DEW.CWL) });
          paramString = paramString.DEW.sac;
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
        az.arV();
        c.afk().set(ae.a.Fjt, Integer.valueOf(paramInt2));
        az.arV();
        c.afk().set(ae.a.Fju, Long.valueOf(l));
        az.arV();
        c.afk().set(ae.a.Fjv, Integer.valueOf(paramInt1));
        az.arV();
        c.afk().set(ae.a.FjE, Integer.valueOf(i));
        ad.i("MicroMsg.ShakeIbeaconService", "[shakezb]channel_open_method is " + paramInt2 + " ,channel_open_time is " + l + ", shake_tab_display is " + paramInt1);
        i = localJSONArray.length();
        paramString = null;
        e locale = m.dpb();
        locale.doR();
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
              paramString.field_sex = wnP;
            }
            paramString.field_lvbuffer = (String.valueOf(str5) + "," + String.valueOf(str6) + "," + String.valueOf(str7) + "," + String.valueOf(localObject)).getBytes("utf-8");
            paramString.field_insertBatch = 2;
            paramString.field_reserved3 = (str8 + "," + str9 + "," + k);
            paramn.add(paramString);
            locale.a(paramString, true);
            if ((paramString.field_sex != wnP) || (paramInt2 != 1)) {
              break label926;
            }
            a(paramString);
            break label926;
          }
        }
        this.wlU.c(paramString, 1L);
        AppMethodBeat.o(28301);
        return;
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb] parse error.%s", new Object[] { bt.nullAsNil(paramString.getMessage()) });
        this.wlU.c(null, 1L);
        AppMethodBeat.o(28301);
        return;
      }
      if (paramString.DEW.CWL == this.wnM)
      {
        this.wlU.c(null, 6L);
        AppMethodBeat.o(28301);
        return;
      }
      if (paramString.DEW.CWL == this.wnN)
      {
        this.wlU.c(null, 7L);
        AppMethodBeat.o(28301);
        return;
      }
      if (paramString.DEW.CWL == this.wnO)
      {
        this.wlU.c(null, 8L);
        AppMethodBeat.o(28301);
        return;
      }
      this.wlU.c(null, 1L);
      AppMethodBeat.o(28301);
      return;
      this.wlU.c(null, 3L);
      AppMethodBeat.o(28301);
      return;
      label926:
      paramInt1 += 1;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28297);
    if (this.gXu != null) {
      this.gXu.c(this.fjJ);
    }
    AppMethodBeat.o(28297);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28295);
    if (this.wnK != null) {
      az.aeS().a(this.wnK);
    }
    AppMethodBeat.o(28295);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(28298);
    if (this.gXu != null) {
      this.gXu.a(this.fjJ, true);
    }
    AppMethodBeat.o(28298);
  }
  
  public final void start()
  {
    AppMethodBeat.i(28296);
    ad.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:start");
    init();
    reset();
    if (this.gXu == null) {
      doE();
    }
    this.gXu.b(this.fjJ, true);
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
            h.a(h.this).c(null, 8L);
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
            h.b(h.this).c(null, 9L);
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
            h.c(h.this).c(null, 10L);
            AppMethodBeat.o(28292);
          }
        }, 1000L);
        AppMethodBeat.o(28296);
        return;
      }
      if (this.wnL != null) {}
      for (int i = this.wnL.size();; i = 0)
      {
        ad.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:beaconCollection.size:%d", new Object[] { Integer.valueOf(i) });
        this.wnK = new d(this.wnL, this.fjD, this.fjE, this.wlE);
        az.aeS().a(this.wnK, 0);
        AppMethodBeat.o(28296);
        return;
      }
    }
  }
  
  public static final class a
  {
    public double hqY = 0.0D;
    public int major = 0;
    public int minor = 0;
    public String uuid = null;
    public String wnR = "";
    public double wnS = 0.0D;
    public int wnT = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.h
 * JD-Core Version:    0.7.0.1
 */